/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.IndicacaoVisitas;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleIndicacaoVisitasInterno {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    IndicacaoVisitas objInd = new IndicacaoVisitas();

    int codInterno;

    public IndicacaoVisitas incluirIndicacaoVisitas(IndicacaoVisitas objInd) {
        buscarInternoCrc(objInd.getNomeInternoCrc(), objInd.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO INDICACAO_VISITA_INTERNO_SERVICO_SOCIAL (DataInd,IdAtend,IdInternoCrc,NomeVisitante,GrauParentesco,TextoArea,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objInd.getDataInd().getTime()));
            pst.setInt(2, objInd.getIdAtend());
            pst.setInt(3, codInterno);
            pst.setString(4, objInd.getNomeVisitante());
            pst.setString(5, objInd.getGrauParentesco());
            pst.setString(6, objInd.getTextoArea());
            pst.setString(7, objInd.getUsuarioInsert());
            pst.setString(8, objInd.getDataInsert());
            pst.setString(9, objInd.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objInd;
    }

    public IndicacaoVisitas alterarIndicacaoVisitas(IndicacaoVisitas objInd) {
        buscarInternoCrc(objInd.getNomeInternoCrc(), objInd.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE INDICACAO_VISITA_INTERNO_SERVICO_SOCIAL SET DataInd=?,IdAtend=?,IdInternoCrc=?,NomeVisitante=?,GrauParentesco=?,TextoArea=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdInd='" + objInd.getIdInd() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objInd.getDataInd().getTime()));
            pst.setInt(2, objInd.getIdAtend());
            pst.setInt(3, codInterno);
            pst.setString(4, objInd.getNomeVisitante());
            pst.setString(5, objInd.getGrauParentesco());
            pst.setString(6, objInd.getTextoArea());
            pst.setString(7, objInd.getUsuarioUp());
            pst.setString(8, objInd.getDataUp());
            pst.setString(9, objInd.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objInd;
    }

    public IndicacaoVisitas excluirIndicacaoVisitas(IndicacaoVisitas objInd) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM INDICACAO_VISITA_INTERNO_SERVICO_SOCIAL WHERE IdInd='" + objInd.getIdInd() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objInd;
    }

    public void buscarInternoCrc(String nome, int cod) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE nomeInternoCrc='" + nome + "' AND IdInternoCrc='" + cod + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar o interno.\nERRO: " + e);
        }
        conecta.desconecta();
    }
}
