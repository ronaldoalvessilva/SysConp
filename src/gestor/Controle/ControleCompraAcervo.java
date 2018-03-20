/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ComprasAcervo;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleCompraAcervo {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ComprasAcervo objCompraAcervo = new ComprasAcervo();

    int codForn;

    public ComprasAcervo incluirCompraAcervo(ComprasAcervo objCompraAcervo) {
        buscarFornecedorAcervo(objCompraAcervo.getNomeFornecedor());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO COMPRAS_ACERVO (StatusLanc,ClasseCompra,DataCompra,IdForn,NumeroDoc,SerieDoc,DataRecebe,DataEmissao,FormaPagto,ValorProdutos,ValorNFE,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objCompraAcervo.getStatusLanc());
            pst.setString(2, objCompraAcervo.getClasseCompra());
            pst.setTimestamp(3, new java.sql.Timestamp(objCompraAcervo.getDataCompra().getTime()));
            pst.setInt(4, codForn);
            pst.setInt(5, objCompraAcervo.getNumeroDoc());
            pst.setString(6, objCompraAcervo.getSerieDoc());
            pst.setTimestamp(7, new java.sql.Timestamp(objCompraAcervo.getDataRecebe().getTime()));
            pst.setTimestamp(8, new java.sql.Timestamp(objCompraAcervo.getDataEmissao().getTime()));
            pst.setInt(9, objCompraAcervo.getFormaPagto());
            pst.setFloat(10, objCompraAcervo.getValorProdutos());
            pst.setFloat(11, objCompraAcervo.getValorNFE());
            pst.setString(12, objCompraAcervo.getObservacao());
            pst.setString(13, objCompraAcervo.getUsuarioInsert());
            pst.setString(14, objCompraAcervo.getDataInsert());
            pst.setString(15, objCompraAcervo.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCompraAcervo;
    }

    public ComprasAcervo alterarCompraAcervo(ComprasAcervo objCompraAcervo) {
        buscarFornecedorAcervo(objCompraAcervo.getNomeFornecedor());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE COMPRAS_ACERVO SET StatusLanc=?,ClasseCompra=?,DataCompra=?,IdForn=?,NumeroDoc=?,SerieDoc=?,DataRecebe=?,DataEmissao=?,FormaPagto=?,ValorProdutos=?,ValorNFE=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdCompra='" + objCompraAcervo.getIdCompra() + "'");
            pst.setString(1, objCompraAcervo.getStatusLanc());
            pst.setString(2, objCompraAcervo.getClasseCompra());
            pst.setTimestamp(3, new java.sql.Timestamp(objCompraAcervo.getDataCompra().getTime()));
            pst.setInt(4, codForn);
            pst.setInt(5, objCompraAcervo.getNumeroDoc());
            pst.setString(6, objCompraAcervo.getSerieDoc());
            pst.setTimestamp(7, new java.sql.Timestamp(objCompraAcervo.getDataRecebe().getTime()));
            pst.setTimestamp(8, new java.sql.Timestamp(objCompraAcervo.getDataEmissao().getTime()));
            pst.setInt(9, objCompraAcervo.getFormaPagto());
            pst.setFloat(10, objCompraAcervo.getValorProdutos());
            pst.setFloat(11, objCompraAcervo.getValorNFE());
            pst.setString(12, objCompraAcervo.getObservacao());
            pst.setString(13, objCompraAcervo.getUsuarioUp());
            pst.setString(14, objCompraAcervo.getDataUp());
            pst.setString(15, objCompraAcervo.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCompraAcervo;
    }

    public ComprasAcervo excluirCompraAcervo(ComprasAcervo objCompraAcervo) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM COMPRAS_ACERVO WHERE IdCompra='" + objCompraAcervo.getIdCompra() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCompraAcervo;
    }

    public ComprasAcervo finalizarCompraAcervo(ComprasAcervo objCompraAcervo) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE COMPRAS_ACERVO SET StatusLanc=? WHERE IdCompra='" + objCompraAcervo.getIdCompra() + "'");
            pst.setString(1, objCompraAcervo.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível FINALIZAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCompraAcervo;
    }

    public void buscarFornecedorAcervo(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM FORNECEDORES_ACERVO WHERE RazaoSocial='" + nome + "'");
            conecta.rs.first();
            codForn = conecta.rs.getInt("IdForn");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (FORNECEDOR) a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
