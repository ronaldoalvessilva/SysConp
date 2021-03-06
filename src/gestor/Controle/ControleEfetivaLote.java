/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ProdutoMedicamento;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleEfetivaLote {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ProdutoMedicamento objProdMed = new ProdutoMedicamento();

    // Inlcui o código do produto na tabela de lote no momento do cadastro do produto (tabela PRODUTOS)
    public ProdutoMedicamento incluirLoteProduto(ProdutoMedicamento objProdMed) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO LOTE_PRODUTOS_AC (IdProd,Lote,Qtd,Modulo) VALUES (?,?,?,?)");
            pst.setInt(1, objProdMed.getIdProd());
            pst.setString(2, objProdMed.getLote());
            pst.setFloat(3, objProdMed.getQtdLote());
            pst.setString(4, objProdMed.getModulo());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR LOTE DE PRODUTOS... \n\nERRO" + ex);
        }
        conecta.desconecta();
        return objProdMed;
    }

    // Incluir novo produto caso o intetário tenha o mesmo produto com mais de um lote
    public ProdutoMedicamento incluirNovoLoteProduto(ProdutoMedicamento objProdMed) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO LOTE_PRODUTOS_AC (IdProd,IdLanc,DataVenc,Lote,Qtd,Modulo) VALUES (?,?,?,?,?,?)");
            pst.setInt(1, objProdMed.getIdProd());
            pst.setInt(2, objProdMed.getIdLanc());
            if (objProdMed.getDataValidade() != null) {
                pst.setTimestamp(3, new java.sql.Timestamp(objProdMed.getDataValidade().getTime()));
            } else {
                pst.setDate(3, null);
            }
            pst.setString(4, objProdMed.getLote());
            pst.setFloat(5, objProdMed.getSaldoAtual());
            pst.setString(6, objProdMed.getModulo());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INCLUIR NOVO LOTE DE PRODUTOS... \n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProdMed;
    }

    public ProdutoMedicamento alterarLoteProduto(ProdutoMedicamento objProdMed) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE LOTE_PRODUTOS_AC SET IdLanc=?,DataVenc=?,Lote=?,Qtd=?,Modulo=? WHERE IdProd='" + objProdMed.getIdProd() + "' AND Lote='" + objProdMed.getLote()+ "'");
            pst.setInt(1, objProdMed.getIdLanc());
            if (objProdMed.getDataValidade() != null) {
                pst.setTimestamp(2, new java.sql.Timestamp(objProdMed.getDataValidade().getTime()));
            } else {
                pst.setDate(2, null);
            }
            pst.setString(3, objProdMed.getLote());
            pst.setFloat(4, objProdMed.getSaldoAtual());
            pst.setString(5, objProdMed.getModulo());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR LOTE DE PRODUTOS... \n\nERRO" + ex);
        }
        conecta.desconecta();
        return objProdMed;
    }
}
