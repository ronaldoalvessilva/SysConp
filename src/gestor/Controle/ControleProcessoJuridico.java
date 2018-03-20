/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ProcessoJuridico;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleProcessoJuridico {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ProcessoJuridico objProcJuri = new ProcessoJuridico();

    public ProcessoJuridico incluirProcessoJuridico(ProcessoJuridico objProcJuri) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO PROCESSOS_JURIDICOS (IdFicha,NrProcesso,Inquerito,Regime,Sentenca,TipoSentenca,SituacaoPresoProcesso,Anos,Meses,Dias,DataInicio,DataTermino,TotalDias,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objProcJuri.getIdFicha());
            pst.setString(2, objProcJuri.getNrProcesso());
            pst.setString(3, objProcJuri.getInquerito());
            pst.setString(4, objProcJuri.getRegime());
            pst.setString(5, objProcJuri.getSentenca());
            pst.setString(6, objProcJuri.getTipoSentenca());
            pst.setString(7, objProcJuri.getSituacaoPresoProcesso());
            pst.setInt(8, objProcJuri.getAnos());
            pst.setInt(9, objProcJuri.getMeses());
            pst.setInt(10, objProcJuri.getDias());
            if (objProcJuri.getDataInicio() != null) {
                pst.setTimestamp(11, new java.sql.Timestamp(objProcJuri.getDataInicio().getTime()));
            } else {
                pst.setDate(11, null);
            }
            if (objProcJuri.getDataTermino() != null) {
                pst.setTimestamp(12, new java.sql.Timestamp(objProcJuri.getDataTermino().getTime()));
            } else {
                pst.setDate(12, null);
            }
            pst.setInt(13, objProcJuri.getTotalDias());
            pst.setString(14, objProcJuri.getObservacao());
            pst.setString(15, objProcJuri.getUsuarioInsert());
            pst.setString(16, objProcJuri.getDataInsert());
            pst.setString(17, objProcJuri.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProcJuri;
    }

    public ProcessoJuridico alterarProcessoJuridico(ProcessoJuridico objProcJuri) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PROCESSOS_JURIDICOS SET IdFicha=?,NrProcesso=?,Inquerito=?,Regime=?,Sentenca=?,TipoSentenca=?,SituacaoPresoProcesso=?,Anos=?,Meses=?,Dias=?,DataInicio=?,DataTermino=?,TotalDias=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdProc='" + objProcJuri.getIdProc() + "'");
            pst.setInt(1, objProcJuri.getIdFicha());
            pst.setString(2, objProcJuri.getNrProcesso());
            pst.setString(3, objProcJuri.getInquerito());
            pst.setString(4, objProcJuri.getRegime());
            pst.setString(5, objProcJuri.getSentenca());
            pst.setString(6, objProcJuri.getTipoSentenca());
            pst.setString(7, objProcJuri.getSituacaoPresoProcesso());
            pst.setInt(8, objProcJuri.getAnos());
            pst.setInt(9, objProcJuri.getMeses());
            pst.setInt(10, objProcJuri.getDias());
            if (objProcJuri.getDataInicio() != null) {
                pst.setTimestamp(11, new java.sql.Timestamp(objProcJuri.getDataInicio().getTime()));
            } else {
                pst.setDate(11, null);
            }
            if (objProcJuri.getDataTermino() != null) {
                pst.setTimestamp(12, new java.sql.Timestamp(objProcJuri.getDataTermino().getTime()));
            } else {
                pst.setDate(12, null);
            }
            pst.setInt(13, objProcJuri.getTotalDias());
            pst.setString(14, objProcJuri.getObservacao());
            pst.setString(15, objProcJuri.getUsuarioUp());
            pst.setString(16, objProcJuri.getDataUp());
            pst.setString(17, objProcJuri.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProcJuri;
    }

    public ProcessoJuridico excluirProcessoJuridico(ProcessoJuridico objProcJuri) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM PROCESSOS_JURIDICOS WHERE IdProc='" + objProcJuri.getIdProc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProcJuri;
    }
}
