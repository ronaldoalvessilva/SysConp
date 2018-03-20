/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.CancelamentoVisitasRol;
import gestor.Modelo.RolVisitas;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleCancelamentoVisitas {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    CancelamentoVisitasRol objCancel = new CancelamentoVisitasRol();
    int codInt;

    public CancelamentoVisitasRol incluirBloqueioVisitasRol(CancelamentoVisitasRol objCancel) {
        buscarInterno(objCancel.getNomeInternoCrc(), objCancel.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO CANCELAMENTO_VISITAS_EXTERNA_INTERNA_ROL (StatusCan,DataCan,CodigoRol,IdInternoCrc,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?)");
            pst.setString(1, objCancel.getStatusCan());
            pst.setTimestamp(2, new java.sql.Timestamp(objCancel.getDataCan().getTime()));
            pst.setInt(3, objCancel.getCodigoRol());
            pst.setInt(4, codInt);
            pst.setString(5, objCancel.getObservacao());
            pst.setString(6, objCancel.getUsuarioInsert());
            pst.setString(7, objCancel.getDataInsert());
            pst.setString(8, objCancel.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCancel;
    }

    public CancelamentoVisitasRol alterarBloqueioVisitasRol(CancelamentoVisitasRol objCancel) {
        buscarInterno(objCancel.getNomeInternoCrc(), objCancel.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE CANCELAMENTO_VISITAS_EXTERNA_INTERNA_ROL SET StatusCan=?,DataCan=?,CodigoRol=?,IdInternoCrc=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdCan='" + objCancel.getIdCan() + "'");
            pst.setString(1, objCancel.getStatusCan());
            pst.setTimestamp(2, new java.sql.Timestamp(objCancel.getDataCan().getTime()));
            pst.setInt(3, objCancel.getCodigoRol());
            pst.setInt(4, codInt);
            pst.setString(5, objCancel.getObservacao());
            pst.setString(6, objCancel.getUsuarioUp());
            pst.setString(7, objCancel.getDataUp());
            pst.setString(8, objCancel.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCancel;
    }

    public CancelamentoVisitasRol excluirBloqueioVisitasRol(CancelamentoVisitasRol objCancel) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM CANCELAMENTO_VISITAS_EXTERNA_INTERNA_ROL WHERE IdCan='" + objCancel.getIdCan() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCancel;
    }

    public CancelamentoVisitasRol finalizarBloqueioVisitasRol(CancelamentoVisitasRol objCancel) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE CANCELAMENTO_VISITAS_EXTERNA_INTERNA_ROL SET StatusCan=? WHERE IdCan='" + objCancel.getIdCan() + "'");
            pst.setString(1, objCancel.getStatusCan());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCancel;
    }

    public void buscarInterno(String nome, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + nome + "'AND IdInternoCrc='" + codigo + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados do INTERNO a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
