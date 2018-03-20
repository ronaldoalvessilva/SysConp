/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensReservaAcervo;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleItensReservaAcervo {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensReservaAcervo objItensReserva = new ItensReservaAcervo();
    int codProduto;

    public ItensReservaAcervo incluirProdutoReservaAcervo(ItensReservaAcervo objItensReserva) {
        buscarProdutoAcervo(objItensReserva.getTituloLivro());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_RESERVA_ACERVO (IdReserva,TipoOperacao,IdLivro,QtdItem,SaldoEstoque,UtilizaReserva,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objItensReserva.getIdReserva());
            pst.setInt(2, objItensReserva.getTipoOperacao());
            pst.setInt(3, codProduto);
            pst.setInt(4, objItensReserva.getQuantidade());
            pst.setFloat(5, objItensReserva.getSaldoEstoque());
            pst.setString(6, objItensReserva.getUtilizaReservaAcervo());
            pst.setString(7, objItensReserva.getUsuarioInsert());
            pst.setString(8, objItensReserva.getDataInsert());
            pst.setString(9, objItensReserva.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR (PRODUTOS)os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensReserva;
    }

    public ItensReservaAcervo alterarProdutoReservaAcervo(ItensReservaAcervo objItensReserva) {
        buscarProdutoAcervo(objItensReserva.getTituloLivro());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_RESERVA_ACERVO SET IdReserva=?,TipoOperacao=?,IdLivro=?,QtdItem=?,SaldoEstoque=?,UtilizaReserva=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objItensReserva.getIdItem() + "'");
            pst.setInt(1, objItensReserva.getIdReserva());
            pst.setInt(2, objItensReserva.getTipoOperacao());
            pst.setInt(3, codProduto);
            pst.setInt(4, objItensReserva.getQuantidade());
            pst.setFloat(5, objItensReserva.getSaldoEstoque());
            pst.setString(6, objItensReserva.getUtilizaReservaAcervo());
            pst.setString(7, objItensReserva.getUsuarioUp());
            pst.setString(8, objItensReserva.getDataUp());
            pst.setString(9, objItensReserva.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (PRODUTOS)os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensReserva;
    }

    public ItensReservaAcervo excluirProdutoReservaAcervo(ItensReservaAcervo objItensReserva) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_RESERVA_ACERVO WHERE IdItem='" + objItensReserva.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR (PRODUTOS)os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensReserva;
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
