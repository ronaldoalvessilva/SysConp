/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensCompraAcervo;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleComprasProdutoAcervo {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensCompraAcervo objItensCompraAcervo = new ItensCompraAcervo();

    int codProduto;

    public ItensCompraAcervo incluirProdutoCompraAcervo(ItensCompraAcervo objItensCompraAcervo) {
        buscarProdutoAcervo(objItensCompraAcervo.getDescricaoLivro());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_COMPRA_ACERVO (IdCompra,TipoCompra,TipoOperacao,IdLivro,QtdItem,ValorUnit,ValorTotal,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objItensCompraAcervo.getIdCompra());
            pst.setInt(2, objItensCompraAcervo.getTipoCompra());
            pst.setInt(3, objItensCompraAcervo.getTipoOperacao());
            pst.setInt(4, codProduto);
            pst.setFloat(5, objItensCompraAcervo.getQtdeCompra());
            pst.setFloat(6, objItensCompraAcervo.getValorUnit());
            pst.setFloat(7, objItensCompraAcervo.getValorTotal());
            pst.setString(8, objItensCompraAcervo.getUsuarioInsert());
            pst.setString(9, objItensCompraAcervo.getDataInsert());
            pst.setString(10, objItensCompraAcervo.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR (PRODUTOS)os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensCompraAcervo;
    }

    public ItensCompraAcervo alterarProdutoCompraAcervo(ItensCompraAcervo objItensCompraAcervo) {
        buscarProdutoAcervo(objItensCompraAcervo.getDescricaoLivro());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_COMPRA_ACERVO SET IdCompra=?,TipoCompra=?,TipoOperacao=?,IdLivro=?,QtdItem=?,ValorUnit=?,ValorTotal=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objItensCompraAcervo.getIdItem() + "'");
            pst.setInt(1, objItensCompraAcervo.getIdCompra());
            pst.setInt(2, objItensCompraAcervo.getTipoCompra());
            pst.setInt(3, objItensCompraAcervo.getTipoOperacao());
            pst.setInt(4, codProduto);
            pst.setFloat(5, objItensCompraAcervo.getQtdeCompra());
            pst.setFloat(6, objItensCompraAcervo.getValorUnit());
            pst.setFloat(7, objItensCompraAcervo.getValorTotal());
            pst.setString(8, objItensCompraAcervo.getUsuarioUp());
            pst.setString(9, objItensCompraAcervo.getDataUp());
            pst.setString(10, objItensCompraAcervo.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensCompraAcervo;
    }

    public ItensCompraAcervo excluirProdutoCompraAcervo(ItensCompraAcervo objItensCompraAcervo) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_COMPRA_ACERVO WHERE IdItem='" + objItensCompraAcervo.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensCompraAcervo;
    }

    public void buscarProdutoAcervo(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM LIVROS_REVISTAS_JORNAIS WHERE TituloLivro='" + nome + "'");
            conecta.rs.first();
            codProduto = conecta.rs.getInt("IdLivro");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (LIVROS) a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
