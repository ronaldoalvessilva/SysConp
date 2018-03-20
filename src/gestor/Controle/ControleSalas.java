/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.Sala;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleSalas {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    Sala objSala = new Sala();

    public Sala incluirSalas(Sala objSala) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO SALAS (StatusSala,DataCad,Descricao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?)");
            pst.setString(1, objSala.getStatusSala());
            pst.setTimestamp(2, new java.sql.Timestamp(objSala.getDataCad().getTime()));
            pst.setString(3, objSala.getDescricao());
            pst.setString(4, objSala.getUsuarioInsert());
            pst.setString(5, objSala.getDataInsert());
            pst.setString(6, objSala.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objSala;
    }

    public Sala alterarSalas(Sala objSala) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE SALAS SET StatusSala=?,DataCad=?,Descricao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdSala='" + objSala.getIdSala() + "'");
            pst.setString(1, objSala.getStatusSala());
            pst.setTimestamp(2, new java.sql.Timestamp(objSala.getDataCad().getTime()));
            pst.setString(3, objSala.getDescricao());
            pst.setString(4, objSala.getUsuarioUp());
            pst.setString(5, objSala.getDataUp());
            pst.setString(6, objSala.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objSala;
    }

    public Sala excluirSalas(Sala objSala) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM SALAS WHERE IdSala='" + objSala.getIdSala() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objSala;
    }
}
