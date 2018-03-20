/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensDevolucaoAcervo;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleItensDevolucaoAcervo {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensDevolucaoAcervo objItensDevolucao = new ItensDevolucaoAcervo();
    int codProduto;

    public ItensDevolucaoAcervo incluirProdutoDevolucaoAcervo(ItensDevolucaoAcervo objItensDevolucao) {
        buscarProdutoAcervo(objItensDevolucao.getTituloLivro());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_DEVOLUCAO_ACERVO (TipoOperacao,IdDevolucao,IdLivro,QtdItem,QtdEmprestada,SaldoEstoque,UtilizaEmprestimo,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objItensDevolucao.getTipoOperacao());
            pst.setInt(2, objItensDevolucao.getIdDevolucao());
            pst.setInt(3, codProduto);
            pst.setInt(4, objItensDevolucao.getQuantidade());
            pst.setFloat(5, objItensDevolucao.getQtdEmprestada());
            pst.setFloat(6, objItensDevolucao.getSaldoEstoque());
            pst.setString(7, objItensDevolucao.getUtilizaEmprestimoAcervo());
            pst.setString(8, objItensDevolucao.getUsuarioInsert());
            pst.setString(9, objItensDevolucao.getDataInsert());
            pst.setString(10, objItensDevolucao.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR (PRODUTOS)os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensDevolucao;
    }

    public ItensDevolucaoAcervo alterarProdutoDevolucaoAcervo(ItensDevolucaoAcervo objItensDevolucao) {
        buscarProdutoAcervo(objItensDevolucao.getTituloLivro());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_DEVOLUCAO_ACERVO SET TipoOperacao=?,IdDevolucao=?,IdLivro=?,QtdItem=?,QtdEmprestada=?,SaldoEstoque=?,UtilizaEmprestimo=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objItensDevolucao.getIdItem() + "'");
            pst.setInt(1, objItensDevolucao.getTipoOperacao());
            pst.setInt(2, objItensDevolucao.getIdDevolucao());
            pst.setInt(3, codProduto);
            pst.setInt(4, objItensDevolucao.getQuantidade());
            pst.setFloat(5, objItensDevolucao.getQtdEmprestada());
            pst.setFloat(6, objItensDevolucao.getSaldoEstoque());
            pst.setString(7, objItensDevolucao.getUtilizaEmprestimoAcervo());
            pst.setString(8, objItensDevolucao.getUsuarioUp());
            pst.setString(9, objItensDevolucao.getDataUp());
            pst.setString(10, objItensDevolucao.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (PRODUTOS)os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensDevolucao;
    }

    public ItensDevolucaoAcervo excluirProdutoDevolucaoAcervo(ItensDevolucaoAcervo objItensDevolucao) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_DEVOLUCAO_ACERVO WHERE IdItem='" + objItensDevolucao.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR (PRODUTOS)os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensDevolucao;
    }

    public void buscarProdutoAcervo(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM LIVROS_REVISTAS_JORNAIS WHERE TituloLivro='" + nome + "'");
            conecta.rs.first();
            codProduto = conecta.rs.getInt("IdLivro");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (ACERVO) a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
