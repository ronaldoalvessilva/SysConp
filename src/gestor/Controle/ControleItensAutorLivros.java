/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensAutorLivros;
import gestor.Modelo.LivrosRevistasJornais;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleItensAutorLivros {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensAutorLivros objItensAutor = new ItensAutorLivros();

    int codAutor;

    public ItensAutorLivros incluirAutorLivrosRevistasJornais(ItensAutorLivros objItensAutor) {
        buscarAutor(objItensAutor.getNomeAutor());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_AUTOR_LIVROS (IdAutor,IdLivro,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?)");
            pst.setInt(1, codAutor);
            pst.setInt(2, objItensAutor.getIdLivro());
            pst.setString(3, objItensAutor.getUsuarioInsert());
            pst.setString(4, objItensAutor.getDataInsert());
            pst.setString(5, objItensAutor.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensAutor;
    }

    public ItensAutorLivros alterarAutorLivrosRevistasJornais(ItensAutorLivros objItensAutor) {
        buscarAutor(objItensAutor.getNomeAutor());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_AUTOR_LIVROS SET IdAutor=?,IdLivro=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objItensAutor.getIdItem() + "'");
            pst.setInt(1, codAutor);
            pst.setInt(2, objItensAutor.getIdLivro());
            pst.setString(3, objItensAutor.getUsuarioUp());
            pst.setString(4, objItensAutor.getDataUp());
            pst.setString(5, objItensAutor.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensAutor;
    }

    public ItensAutorLivros excluirAutorLivrosRevistasJornais(ItensAutorLivros objItensAutor) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_AUTOR_LIVROS WHERE IdItem='" + objItensAutor.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensAutor;
    }

    public void buscarAutor(String nomeAutor) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM AUTORES_LIVROS WHERE NomeAutor='" + nomeAutor + "'");
            conecta.rs.first();
            codAutor = conecta.rs.getInt("IdAutor");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar o autor." + e);
        }
    }
}
