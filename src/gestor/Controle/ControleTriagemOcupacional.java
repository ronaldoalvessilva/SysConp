/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AtendimentoTerapeuta;
import gestor.Modelo.TriagemOcupacional;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleTriagemOcupacional {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    TriagemOcupacional objTriaOcupa = new TriagemOcupacional();
    int codInt;

    public TriagemOcupacional incluirTriagemOcupacional(TriagemOcupacional objTriaOcupa) {
        buscarInternoCrc(objTriaOcupa.getNomeInternoTriagem());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO TRIAGEM_OCUPACIONAL (StatusLanc,DataLanc,IdInternoCrc,JaTrabalho,OndeTrabalhou,"
                    + "InteresseUnidade,QualTipoAtividade,VisitasFinaisSemana,Observacao,"
                    + "UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objTriaOcupa.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objTriaOcupa.getDataLanc().getTime()));
            pst.setInt(3, codInt);
            pst.setString(4, objTriaOcupa.getJaTrabalho());
            pst.setString(5, objTriaOcupa.getOndeTrabalhou());
            pst.setString(6, objTriaOcupa.getInteresseUnidade());
            pst.setString(7, objTriaOcupa.getQualTipoAtividade());
            pst.setString(8, objTriaOcupa.getVisitasFinaisSemana());
            pst.setString(9, objTriaOcupa.getObservacao());
            pst.setString(10, objTriaOcupa.getUsuarioInsert());
            pst.setString(11, objTriaOcupa.getDataInsert());
            pst.setString(12, objTriaOcupa.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objTriaOcupa;
    }

    public TriagemOcupacional alterarTriagemOcupacional(TriagemOcupacional objTriaOcupa) {
        buscarInternoCrc(objTriaOcupa.getNomeInternoTriagem());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE TRIAGEM_OCUPACIONAL SET StatusLanc=?,DataLanc=?,IdInternoCrc=?,JaTrabalho=?,OndeTrabalhou=?,"
                    + "InteresseUnidade=?,QualTipoAtividade=?,VisitasFinaisSemana=?,Observacao=?,"
                    + "UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdTriagem='" + objTriaOcupa.getIdTraigem() + "'");
            pst.setString(1, objTriaOcupa.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objTriaOcupa.getDataLanc().getTime()));
            pst.setInt(3, codInt);
            pst.setString(4, objTriaOcupa.getJaTrabalho());
            pst.setString(5, objTriaOcupa.getOndeTrabalhou());
            pst.setString(6, objTriaOcupa.getInteresseUnidade());
            pst.setString(7, objTriaOcupa.getQualTipoAtividade());
            pst.setString(8, objTriaOcupa.getVisitasFinaisSemana());
            pst.setString(9, objTriaOcupa.getObservacao());
            pst.setString(10, objTriaOcupa.getUsuarioUp());
            pst.setString(11, objTriaOcupa.getDataUp());
            pst.setString(12, objTriaOcupa.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objTriaOcupa;
    }

    public TriagemOcupacional excluirTriagemOcupacional(TriagemOcupacional objTriaOcupa) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM TRIAGEM_OCUPACIONAL WHERE IdTriagem='" + objTriaOcupa.getIdTraigem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados.\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objTriaOcupa;
    }

    public TriagemOcupacional finalizarTriagemOcupacional(TriagemOcupacional objTriaOcupa) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE TRIAGEM_OCUPACIONAL SET StatusLanc=? WHERE IdTriagem='" + objTriaOcupa.getIdTraigem() + "'");
            pst.setString(1, objTriaOcupa.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível FINALIZAR os Dados.\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objTriaOcupa;
    }

    public void buscarInternoCrc(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + desc + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNOS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
