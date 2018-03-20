/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AutorLivros;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleAutorLivros {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AutorLivros objAutor = new AutorLivros();

    public AutorLivros incluirAutorLivros(AutorLivros objAutor) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO AUTORES_LIVROS (StatusAutor,DataLanc,NomeAutor,NacionalidadeAutor,PaisAutor,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objAutor.getStatusAutor());
            pst.setTimestamp(2, new java.sql.Timestamp(objAutor.getDataLanc().getTime()));
            pst.setString(3, objAutor.getNomeAutor());
            pst.setString(4, objAutor.getNacionalidadeAutor());
            pst.setString(5, objAutor.getPaisAutor());
            pst.setString(6, objAutor.getObservacao());
            pst.setString(7, objAutor.getUsuarioInsert());
            pst.setString(8, objAutor.getDataInsert());
            pst.setString(9, objAutor.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAutor;
    }

    public AutorLivros alterarAutorLivros(AutorLivros objAutor) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE AUTORES_LIVROS SET StatusAutor=?,DataLanc=?,NomeAutor=?,NacionalidadeAutor=?,PaisAutor=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdAutor='" + objAutor.getIdAutor() + "'");
            pst.setString(1, objAutor.getStatusAutor());
            pst.setTimestamp(2, new java.sql.Timestamp(objAutor.getDataLanc().getTime()));
            pst.setString(3, objAutor.getNomeAutor());
            pst.setString(4, objAutor.getNacionalidadeAutor());
            pst.setString(5, objAutor.getPaisAutor());
            pst.setString(6, objAutor.getObservacao());
            pst.setString(7, objAutor.getUsuarioUp());
            pst.setString(8, objAutor.getDataUp());
            pst.setString(9, objAutor.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAutor;
    }

    public AutorLivros excluirAutorLivros(AutorLivros objAutor) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM AUTORES_LIVROS WHERE IdAutor='" + objAutor.getIdAutor() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAutor;
    }
}
