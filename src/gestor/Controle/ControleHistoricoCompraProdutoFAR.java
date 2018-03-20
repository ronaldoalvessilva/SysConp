/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.HistoricoCompraAcervo;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleHistoricoCompraProdutoFAR {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    HistoricoCompraAcervo objHistCompra = new HistoricoCompraAcervo();

    int codProduto;

    public HistoricoCompraAcervo incluirHistoricoComprasProdutoFAR(HistoricoCompraAcervo objHistCompra) {
        buscarProdutosAC(objHistCompra.getNomeLivro());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO HISTORICO_COMPRA_FAR (NfCompra,DataMov,IdNfEntrada,IdProd,QtdeCompra,ValorUnit,ValorTotal) VALUES(?,?,?,?,?,?,?)");
            pst.setInt(1, objHistCompra.getNfCompra());
            pst.setTimestamp(2, new java.sql.Timestamp(objHistCompra.getDataMov().getTime()));
            pst.setInt(3, objHistCompra.getIdCompra());
            pst.setInt(4, codProduto);
            pst.setFloat(5, objHistCompra.getQtdeCompra());
            pst.setFloat(6, objHistCompra.getValorUnit());
            pst.setFloat(7, objHistCompra.getValorTotal());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível INCLUIR registro.\nERRO: " + ex);
        }
        return objHistCompra;
    }

    public HistoricoCompraAcervo alterarHistoricoComprasProdutoFAR(HistoricoCompraAcervo objHistCompra) {
        buscarProdutosAC(objHistCompra.getNomeLivro());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE HISTORICO_COMPRA_FAR SET NfCompra=?,DataMov=?,IdNfEntrada=?,IdProd=?,QtdeCompra=?,ValorUnit=?,ValorTotal=? WHERE IdNfEntrada='" + objHistCompra.getIdCompra() + "'AND IdProd='" + objHistCompra.getIdLivro() + "'");
            pst.setInt(1, objHistCompra.getNfCompra());
            pst.setTimestamp(2, new java.sql.Timestamp(objHistCompra.getDataMov().getTime()));
            pst.setInt(3, objHistCompra.getIdCompra());
            pst.setInt(4, codProduto);
            pst.setFloat(5, objHistCompra.getQtdeCompra());
            pst.setFloat(6, objHistCompra.getValorUnit());
            pst.setFloat(7, objHistCompra.getValorTotal());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível ALTERAR registro.\nERRO: " + ex);
        }
        return objHistCompra;
    }

    public HistoricoCompraAcervo excluirHistoricoComprasProdutoFAR(HistoricoCompraAcervo objHistCompra) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM HISTORICO_COMPRA_FAR WHERE IdNfEntrada='" + objHistCompra.getIdCompra() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível EXCLUIR registro.\nERRO: " + ex);
        }
        return objHistCompra;
    }

    public void buscarProdutosAC(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRODUTOS_AC WHERE DescricaoProd='" + desc + "'");
            conecta.rs.first();
            codProduto = conecta.rs.getInt("IdProd");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível listar o produto..." + e);
        }
        conecta.desconecta();
    }
}
