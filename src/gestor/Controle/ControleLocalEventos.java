/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EventoIndisciplinar;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleLocalEventos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EventoIndisciplinar objLocal = new EventoIndisciplinar();

    public EventoIndisciplinar incluirLocalEventos(EventoIndisciplinar objLocal) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO LOCALEVENTOS (StatusLocal,DescricaoLocal,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?)");
            pst.setString(1, objLocal.getStatusLocal());
            pst.setString(2, objLocal.getDescricaoLocal());
            pst.setString(3, objLocal.getUsuarioInsert());
            pst.setString(4, objLocal.getDataInsert());
            pst.setString(5, objLocal.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objLocal;
    }

    public EventoIndisciplinar alterarLocalEventos(EventoIndisciplinar objLocal) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE LOCALEVENTOS SET StatusLocal=?,DescricaoLocal=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdLocal='" + objLocal.getIdLocal() + "'");
            pst.setString(1, objLocal.getStatusLocal());
            pst.setString(2, objLocal.getDescricaoLocal());
            pst.setString(3, objLocal.getUsuarioUp());
            pst.setString(4, objLocal.getDataUp());
            pst.setString(5, objLocal.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objLocal;
    }

    public EventoIndisciplinar excluirLocalPertences(EventoIndisciplinar objLocal) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM LOCALEVENTOS WHERE IdLocal='" + objLocal.getIdLocal() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel DELETE os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objLocal;
    }
}
