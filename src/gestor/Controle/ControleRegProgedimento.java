/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.RegistroProcedimentos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleRegProgedimento {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    RegistroProcedimentos objRegProc = new RegistroProcedimentos();

    public RegistroProcedimentos incluirRegProcedimento(RegistroProcedimentos objRegProc) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO PROCEDIMENTOS (StatusLanc,DataLanc,HorarioInicial,HorarioTermino,Responsavel,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objRegProc.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objRegProc.getDataLanc().getTime()));
            pst.setString(3, objRegProc.getHorarioInicial());
            pst.setString(4, objRegProc.getHorarioTermino());
            pst.setString(5, objRegProc.getResponsavel());
            pst.setString(6, objRegProc.getObservacao());
            pst.setString(7, objRegProc.getUsuarioInsert());
            pst.setString(8, objRegProc.getDataInsert());
            pst.setString(9, objRegProc.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objRegProc;
    }

    public RegistroProcedimentos alterarRegProcedimento(RegistroProcedimentos objRegProc) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PROCEDIMENTOS SET StatusLanc=?,DataLanc=?,HorarioInicial=?,HorarioTermino=?,Responsavel=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdProc='" + objRegProc.getIdProc() + "'");
            pst.setString(1, objRegProc.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objRegProc.getDataLanc().getTime()));
            pst.setString(3, objRegProc.getHorarioInicial());
            pst.setString(4, objRegProc.getHorarioTermino());
            pst.setString(5, objRegProc.getResponsavel());
            pst.setString(6, objRegProc.getObservacao());
            pst.setString(7, objRegProc.getUsuarioUp());
            pst.setString(8, objRegProc.getDataUp());
            pst.setString(9, objRegProc.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objRegProc;
    }

    public RegistroProcedimentos excluirRegProcedimento(RegistroProcedimentos objRegProc) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM PROCEDIMENTOS WHERE IdProc='" + objRegProc.getIdProc() + "'");           
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objRegProc;
    }

    public RegistroProcedimentos finalizarRegProcedimento(RegistroProcedimentos objRegProc) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PROCEDIMENTOS SET StatusLanc=? WHERE IdProc='" + objRegProc.getIdProc() + "'");
            pst.setString(1, objRegProc.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objRegProc;
    }
}
