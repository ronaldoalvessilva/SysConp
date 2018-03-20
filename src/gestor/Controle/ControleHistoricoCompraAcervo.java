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
 * @author Ronaldo
 */
public class ControleHistoricoCompraAcervo {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    HistoricoCompraAcervo objHistCompra = new HistoricoCompraAcervo();

    int codLivro;

    public HistoricoCompraAcervo incluirHistoricoAcervoCompras(HistoricoCompraAcervo objHistCompra) {
        buscarAcervo(objHistCompra.getNomeLivro());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO HISTORICO_COMPRA_ACERVO (DataMov,IdCompra,IdLivro,QtdeCompra,ValorUnit,ValorTotal) VALUES(?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objHistCompra.getDataMov().getTime()));
            pst.setInt(2, objHistCompra.getIdCompra());
            pst.setInt(3, codLivro);
            pst.setFloat(4, objHistCompra.getQtdeCompra());
            pst.setFloat(5, objHistCompra.getValorUnit());
            pst.setFloat(6, objHistCompra.getValorTotal());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível INCLUIR registro.\nERRO: " + ex);
        }
        return objHistCompra;
    }

    public HistoricoCompraAcervo alterarHistoricoAcervoCompras(HistoricoCompraAcervo objHistCompra) {
        buscarAcervo(objHistCompra.getNomeLivro());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE HISTORICO_COMPRA_ACERVO SET DataMov=?,IdCompra=?,IdLivro=?,QtdeCompra=?,ValorUnit=?,ValorTotal=? WHERE IdCompra='" + objHistCompra.getIdCompra() + "'AND IdLivro='" + objHistCompra.getIdLivro()  + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objHistCompra.getDataMov().getTime()));
            pst.setInt(2, objHistCompra.getIdCompra());
            pst.setInt(3, codLivro);
            pst.setFloat(4, objHistCompra.getQtdeCompra());
            pst.setFloat(5, objHistCompra.getValorUnit());
            pst.setFloat(6, objHistCompra.getValorTotal());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível ALTERAR registro.\nERRO: " + ex);
        }
        return objHistCompra;
    }

    public HistoricoCompraAcervo excluirHistoricoAcervoCompras(HistoricoCompraAcervo objHistCompra) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM HISTORICO_COMPRA_ACERVO WHERE IdCompra='" + objHistCompra.getIdCompra() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível EXCLUIR registro.\nERRO: " + ex);
        }
        return objHistCompra;
    }

    public void buscarAcervo(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM LIVROS_REVISTAS_JORNAIS WHERE TituloLivro='" + desc + "'");
            conecta.rs.first();
            codLivro = conecta.rs.getInt("IdLivro");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível listar a acervo..." + e);
        }
        conecta.desconecta();
    }
}
