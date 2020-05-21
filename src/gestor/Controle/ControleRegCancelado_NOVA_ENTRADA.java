/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.RegistroCanceladoCrc;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleRegCancelado_NOVA_ENTRADA {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    RegistroCanceladoCrc objRecCancel = new RegistroCanceladoCrc();

    public RegistroCanceladoCrc incluirRegCanceladoNE(RegistroCanceladoCrc objRecCancel) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO REGISTRO_CANCELADO_NE (StatusLanc,DataLanc,Motivo,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?)");
            pst.setString(1, objRecCancel.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objRecCancel.getDataLanc().getTime()));
            pst.setString(3, objRecCancel.getMotivo());
            pst.setString(4, objRecCancel.getUsuarioInsert());
            pst.setString(5, objRecCancel.getDataInsert());
            pst.setString(6, objRecCancel.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objRecCancel;
    }

    public RegistroCanceladoCrc alterarRegCanceladoNE(RegistroCanceladoCrc objRecCancel) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REGISTRO_CANCELADO_NE SET StatusLanc=?,DataLanc=?,Motivo=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdRegCancel='" + objRecCancel.getIdLanc() + "'");
            pst.setString(1, objRecCancel.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objRecCancel.getDataLanc().getTime()));
            pst.setString(3, objRecCancel.getMotivo());
            pst.setString(4, objRecCancel.getUsuarioUp());
            pst.setString(5, objRecCancel.getDataUp());
            pst.setString(6, objRecCancel.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objRecCancel;
    }

    public RegistroCanceladoCrc excluirRegCanceladoNE(RegistroCanceladoCrc objRecCancel) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM REGISTRO_CANCELADO_NE WHERE IdRegCancel='" + objRecCancel.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objRecCancel;
    }

    public RegistroCanceladoCrc finalizarRegCanceladoNE(RegistroCanceladoCrc objRecCancel) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REGISTRO_CANCELADO_NE SET StatusLanc=? WHERE IdRegCancel='" + objRecCancel.getIdLanc() + "'");
            pst.setString(1, objRecCancel.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados.\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objRecCancel;
    }
}
