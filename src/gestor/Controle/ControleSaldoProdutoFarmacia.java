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
public class ControleSaldoProdutoFarmacia {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ProdutoMedicamento objProdMed = new ProdutoMedicamento();
    int codLocal;
    public ProdutoMedicamento incluirEstoqueProduto(ProdutoMedicamento objProdMed) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO SALDO_ESTOQUE_AC (IdProd,IdLocal,EstoqueMaximo,EstoqueMinimo,PontoPedido,SaldoAtual,InvEstoque) VALUES(?,?,?,?,?,?,?)");
            pst.setInt(1, objProdMed.getIdProd());
            pst.setInt(2, objProdMed.getIdLocal());
            pst.setFloat(3, objProdMed.getEstoqueMaximo());
            pst.setFloat(4, objProdMed.getEstoqueMinimo());
            pst.setFloat(5, objProdMed.getPontoPedido());
            pst.setFloat(6, objProdMed.getSaldoAtual());
            pst.setString(7, objProdMed.getTipoInventario());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR ESTOQUE os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProdMed;
    }

    public ProdutoMedicamento alterarEstoqueProduto(ProdutoMedicamento objProdMed) {
        buscarLocalArmazenamento(objProdMed.getNomeLocal());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE SALDO_ESTOQUE_AC SET IdProd=?,IdLocal=?,EstoqueMaximo=?,EstoqueMinimo=?,PontoPedido=?,SaldoAtual=?,InvEstoque=? WHERE IdProd='" + objProdMed.getIdProd() + "'");
            pst.setInt(1, objProdMed.getIdProd());
            pst.setInt(2, codLocal);
            pst.setFloat(3, objProdMed.getEstoqueMaximo());
            pst.setFloat(4, objProdMed.getEstoqueMinimo());
            pst.setFloat(5, objProdMed.getPontoPedido());
            pst.setFloat(6, objProdMed.getSaldoAtual());
            pst.setString(7, objProdMed.getTipoInventario());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR ESTOQUE os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProdMed;
    }
    public ProdutoMedicamento excluirEstoqueProduto(ProdutoMedicamento objProdMed) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM SALDO_ESTOQUE_AC WHERE IdProd=" + objProdMed.getIdProd() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR ESTOQUE os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProdMed;
    }
     public void buscarLocalArmazenamento(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM LOCAL_ARMAZENAMENTO_AC WHERE DescricaoLocal='" + nome + "'");
            conecta.rs.first();
            codLocal = conecta.rs.getInt("IdLocal");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (LOCAL DE ARMAZENAMENTO) a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
