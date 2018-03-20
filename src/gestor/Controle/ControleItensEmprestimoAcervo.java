/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensEmprestimoAcervo;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleItensEmprestimoAcervo {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensEmprestimoAcervo objItensEmprestimo = new ItensEmprestimoAcervo();
    int codProduto;

    public ItensEmprestimoAcervo incluirProdutoEmprestimoAcervo(ItensEmprestimoAcervo objItensEmprestimo) {
        buscarProdutoAcervo(objItensEmprestimo.getTituloLivro());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_EMPRESTIMO_ACERVO (TipoOperacao,IdEmprestimo,IdLivro,QtdItem,QtdReserva,SaldoEstoque,UtilizaReserva,UtilizadoDevolucao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objItensEmprestimo.getTipoOperacao());
            pst.setInt(2, objItensEmprestimo.getIdEmprestimo());            
            pst.setInt(3, codProduto);
            pst.setInt(4, objItensEmprestimo.getQuantidade());
            pst.setFloat(5, objItensEmprestimo.getQtdReserva());
            pst.setFloat(6, objItensEmprestimo.getSaldoEstoque());
            pst.setString(7, objItensEmprestimo.getUtilizaReservaAcervo());
            pst.setString(8, objItensEmprestimo.getUtilizaDevolucaoAcervo());
            pst.setString(9, objItensEmprestimo.getUsuarioInsert());
            pst.setString(10, objItensEmprestimo.getDataInsert());
            pst.setString(11, objItensEmprestimo.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR (PRODUTOS)os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensEmprestimo;
    }

    public ItensEmprestimoAcervo alterarProdutoEmprestimoAcervo(ItensEmprestimoAcervo objItensEmprestimo) {
        buscarProdutoAcervo(objItensEmprestimo.getTituloLivro());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_EMPRESTIMO_ACERVO SET TipoOperacao=?,IdEmprestimo=?,IdLivro=?,QtdItem=?,QtdReserva=?,SaldoEstoque=?,UtilizaReserva=?,UtilizadoDevolucao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objItensEmprestimo.getIdItem() + "'");
            pst.setInt(1, objItensEmprestimo.getTipoOperacao());
            pst.setInt(2, objItensEmprestimo.getIdEmprestimo());  
            pst.setInt(3, codProduto);
            pst.setInt(4, objItensEmprestimo.getQuantidade());
            pst.setFloat(5, objItensEmprestimo.getQtdReserva());
            pst.setFloat(6, objItensEmprestimo.getSaldoEstoque());
            pst.setString(7, objItensEmprestimo.getUtilizaReservaAcervo());
            pst.setString(8, objItensEmprestimo.getUsuarioUp());
            pst.setString(9, objItensEmprestimo.getDataUp());
            pst.setString(10, objItensEmprestimo.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (PRODUTOS)os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensEmprestimo;
    }

    public ItensEmprestimoAcervo excluirProdutoEmprestimoAcervo(ItensEmprestimoAcervo objItensEmprestimo) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_EMPRESTIMO_ACERVO WHERE IdItem='" + objItensEmprestimo.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR (PRODUTOS)os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensEmprestimo;
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
