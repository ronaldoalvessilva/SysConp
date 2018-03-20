/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.OcorrenciaJuridico;
import gestor.Modelo.OcorrenciasPortaria;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleOcorrenciaJuridico {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    OcorrenciaJuridico objOcorr = new OcorrenciaJuridico();

    public OcorrenciaJuridico incluirOcorrenciaJuridico(OcorrenciaJuridico objOcorr) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO OCORRENCIAS_JU (StatusLanc,DataLanc,Titulo,TextoArea,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");
            pst.setString(1, objOcorr.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objOcorr.getDataLanc().getTime()));
            pst.setString(3, objOcorr.getTitulo());
            pst.setString(4, objOcorr.getTextoArea());
            pst.setString(5, objOcorr.getUsuarioInsert());
            pst.setString(6, objOcorr.getDataInsert());
            pst.setString(7, objOcorr.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objOcorr;
    }

    public OcorrenciaJuridico alterarOcorrenciaJuridico(OcorrenciaJuridico objOcorr) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE OCORRENCIAS_JU SET StatusLanc=?,DataLanc=?,Titulo=?,TextoArea=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdLanc='" + objOcorr.getIdLanc() + "'");
            pst.setString(1, objOcorr.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objOcorr.getDataLanc().getTime()));
            pst.setString(3, objOcorr.getTitulo());
            pst.setString(4, objOcorr.getTextoArea());
            pst.setString(5, objOcorr.getUsuarioInsert());
            pst.setString(6, objOcorr.getDataInsert());
            pst.setString(7, objOcorr.getHorarioInsert());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objOcorr;
    }

    public OcorrenciaJuridico excluirOcorrenciaJuridico(OcorrenciaJuridico objOcorr) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM OCORRENCIAS_JU WHERE IdLanc='" + objOcorr.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel DELETAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objOcorr;
    }

    public OcorrenciaJuridico finalizarOcorrenciaJuridico(OcorrenciaJuridico objOcorr) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE OCORRENCIAS_JU SET StatusLanc=? WHERE IdLanc='" + objOcorr.getIdLanc() + "'");
            pst.setString(1, objOcorr.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALZAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objOcorr;
    }
}
