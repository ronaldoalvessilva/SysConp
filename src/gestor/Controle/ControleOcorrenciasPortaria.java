/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.OcorrenciasPortaria;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleOcorrenciasPortaria {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    OcorrenciasPortaria objOcorr = new OcorrenciasPortaria();

    public OcorrenciasPortaria incluirOcorrenciaP1(OcorrenciasPortaria objOcorr) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO OCORRENCIAS_P1 (StatusLanc,DataLanc,Titulo,TextoArea,UsuarioInsert,DataInsert,HorarioInsert,Fonte,Tamanho,BtEsq,BtCen,BtDir,BtJus) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objOcorr.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objOcorr.getDataLanc().getTime()));
            pst.setString(3, objOcorr.getTitulo());
            pst.setString(4, objOcorr.getTextoArea());
            pst.setString(5, objOcorr.getUsuarioInsert());
            pst.setString(6, objOcorr.getDataInsert());
            pst.setString(7, objOcorr.getHorarioInsert());
            pst.setString(8, objOcorr.getFonte());
            pst.setString(9, objOcorr.getTamanho());
            pst.setInt(10, objOcorr.getBtesq());
            pst.setInt(11, objOcorr.getBtCen());
            pst.setInt(12, objOcorr.getBtDir());
            pst.setInt(13, objOcorr.getBtJus());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objOcorr;
    }

    public OcorrenciasPortaria alterarOcorrenciaP1(OcorrenciasPortaria objOcorr) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE OCORRENCIAS_P1 SET StatusLanc=?,DataLanc=?,Titulo=?,TextoArea=?,UsuarioUp=?,DataUp=?,HorarioUp=?,Fonte=?,Tamanho=?,BtEsq=?,BtCen=?,BtDir=?,BtJus=? WHERE IdLanc='" + objOcorr.getIdLanc() + "'");
            pst.setString(1, objOcorr.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objOcorr.getDataLanc().getTime()));
            pst.setString(3, objOcorr.getTitulo());
            pst.setString(4, objOcorr.getTextoArea());
            pst.setString(5, objOcorr.getUsuarioUp());
            pst.setString(6, objOcorr.getDataUp());
            pst.setString(7, objOcorr.getHorarioUp());
            pst.setString(8, objOcorr.getFonte());
            pst.setString(9, objOcorr.getTamanho());
            pst.setInt(10, objOcorr.getBtesq());
            pst.setInt(11, objOcorr.getBtCen());
            pst.setInt(12, objOcorr.getBtDir());
            pst.setInt(13, objOcorr.getBtJus());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objOcorr;
    }

    public OcorrenciasPortaria excluirOcorrenciaP1(OcorrenciasPortaria objOcorr) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM OCORRENCIAS_P1 WHERE IdLanc='" + objOcorr.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel DELETAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objOcorr;
    }

    public OcorrenciasPortaria finalizarOcorrenciaP1(OcorrenciasPortaria objOcorr) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE OCORRENCIAS_P1 SET StatusLanc=? WHERE IdLanc='" + objOcorr.getIdLanc() + "'");
            pst.setString(1, objOcorr.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objOcorr;
    }
}
