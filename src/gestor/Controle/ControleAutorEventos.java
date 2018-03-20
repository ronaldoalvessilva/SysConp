/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AutorEventos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleAutorEventos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AutorEventos objAutorEvento = new AutorEventos();

    int codInterno, codCela;

    public AutorEventos incluirAutorEvento(AutorEventos objAutorEvento) {
        pesquisarInternoRol(objAutorEvento.getNomeInterno());
        pesquisarCela(objAutorEvento.getDescricaoCela());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO AUTOREVENTOS (IdLanc,IdInternoCrc,IdCela,QtdeDias,UtilizaSaida,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?)");
            pst.setInt(1, objAutorEvento.getIdLanc());
            pst.setInt(2, codInterno);
            pst.setInt(3, codCela);
            pst.setFloat(4, objAutorEvento.getQtdDias());
            pst.setString(5, objAutorEvento.getUtilizacaoSaida());
            pst.setString(6, objAutorEvento.getUsuarioInsert());
            pst.setString(7, objAutorEvento.getDataInsert());
            pst.setString(8, objAutorEvento.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel gravar os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAutorEvento;
    }

    public AutorEventos alterarAutorEvento(AutorEventos objAutorEvento) {
        pesquisarInternoRol(objAutorEvento.getNomeInterno());
        pesquisarCela(objAutorEvento.getDescricaoCela());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE AUTOREVENTOS SET IdLanc=?,IdInternoCrc=?,IdCela=?,QtdeDias=?,UtilizaSaida=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdAutor='" + objAutorEvento.getIdAutor() + "'");
            pst.setInt(1, objAutorEvento.getIdLanc());
            pst.setInt(2, codInterno);
            pst.setInt(3, codCela);
            pst.setFloat(4, objAutorEvento.getQtdDias());
            pst.setString(5, objAutorEvento.getUtilizacaoSaida());
            pst.setString(6, objAutorEvento.getUsuarioUp());
            pst.setString(7, objAutorEvento.getDataUp());
            pst.setString(8, objAutorEvento.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel gravar os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAutorEvento;
    }

    public AutorEventos excluirAutorEvento(AutorEventos objAutorEvento) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM AUTOREVENTOS WHERE IdAutor='" + objAutorEvento.getIdAutor() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel excluir os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAutorEvento;
    }

    public void pesquisarInternoRol(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + nome + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!.\nERRO: " + ex);
        }
        conecta.desconecta();
    }

    public void pesquisarCela(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM CELAS WHERE EndCelaPav='" + nome + "'");
            conecta.rs.first();
            codCela = conecta.rs.getInt("IdCela");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!.\nERRO: " + ex);
        }
        conecta.desconecta();
    }
}
