/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensEntradaLote;
import gestor.Modelo.RegistroCanceladoCrc;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleRegCancelado_SAIDAS {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    RegistroCanceladoCrc objRecCancel = new RegistroCanceladoCrc();

    public RegistroCanceladoCrc incluirRegCanceladoRE(RegistroCanceladoCrc objRecCancel) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO REGISTRO_CANCELADO_SAIDAS (StatusLanc,DataLanc,Motivo,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?)");
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

    public RegistroCanceladoCrc alterarRegCanceladoRE(RegistroCanceladoCrc objRecCancel) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REGISTRO_CANCELADO_SAIDAS SET StatusLanc=?,DataLanc=?,Motivo=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdRegCancelSA='" + objRecCancel.getIdLanc() + "'");
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

    public RegistroCanceladoCrc excluirRegCanceladoRE(RegistroCanceladoCrc objRecCancel) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM REGISTRO_CANCELADO_SAIDAS WHERE IdRegCancelSA='" + objRecCancel.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objRecCancel;
    }

    public RegistroCanceladoCrc finalizarRegCanceladoRE(RegistroCanceladoCrc objRecCancel) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REGISTRO_CANCELADO_SAIDAS SET StatusLanc=? WHERE IdRegCancelSA='" + objRecCancel.getIdLanc() + "'");
            pst.setString(1, objRecCancel.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados.\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objRecCancel;
    }
    

    public RegistroCanceladoCrc alterarDataMOV(RegistroCanceladoCrc objRecCancel) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSCRCPORTARIA SET DataSaida=CONVERT(DATE, DataSaida,103)");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objRecCancel;
    }
}
