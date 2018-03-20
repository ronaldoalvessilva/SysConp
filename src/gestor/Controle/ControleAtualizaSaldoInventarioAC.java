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
public class ControleAtualizaSaldoInventarioAC {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ProdutoMedicamento objProdMed = new ProdutoMedicamento();

    public ProdutoMedicamento incluirEstoqueProdutoAC(ProdutoMedicamento objProdMed) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO SALDO_ESTOQUE_AC (IdProd,Lote,SaldoAtual) VALUES (?,?,?)");
            pst.setFloat(1, objProdMed.getIdProd());
            pst.setString(2, objProdMed.getLote());
            pst.setFloat(3, objProdMed.getSaldoAtual());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ATUALIZAR ESTOQUE... \nERRO: " + ex);
        }
        conecta.desconecta();
        return objProdMed;
    }
    public ProdutoMedicamento alterarEstoqueProdutoAC(ProdutoMedicamento objProdMed) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE SALDO_ESTOQUE_AC SET SaldoAtual=? WHERE IdProd='" + objProdMed.getIdProd() + "'");                    
            pst.setFloat(1, objProdMed.getSaldoAtual());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ATUALIZAR ESTOQUE... \nERRO:" + ex);
        }
        conecta.desconecta();
        return objProdMed;
    }
    
    // Atualizar saldo de estoque de cada produto
    public ProdutoMedicamento atualizarEstoqueProdutoAC(ProdutoMedicamento objProdMed) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE SALDO_ESTOQUE_AC SET SaldoAtual=? WHERE IdProd='" + objProdMed.getIdProd() + "'");                      
            pst.setFloat(1, objProdMed.getSaldoAtual());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ATUALIZAR ESTOQUE... \nERRO:" + ex);
        }
        conecta.desconecta();
        return objProdMed;
    }
}
