/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AgendaCompromissos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleAgendaCompromissos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AgendaCompromissos objAgeComp = new AgendaCompromissos();

    public AgendaCompromissos incluirCompromisso(AgendaCompromissos objAgeComp) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO AGENDA_COMPROMISSOS (StatusAgenda,TipoEvento,DataAgenda,Assunto,Prioridade,Conclusao,DataInicio,HoraInicio,DataTermino,HoraTermino,DataLembrete,HoraLembrete,Texto,UsuarioAgenda,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objAgeComp.getStatusAgenda());
            pst.setString(2, objAgeComp.getTipoEvento());
            pst.setTimestamp(3, new java.sql.Timestamp(objAgeComp.getDataAgenda().getTime()));
            pst.setString(4, objAgeComp.getAssunto());
            pst.setString(5, objAgeComp.getPrioridade());
            pst.setString(6, objAgeComp.getConclusao());
            if (objAgeComp.getDataInicio() != null) {
                pst.setTimestamp(7, new java.sql.Timestamp(objAgeComp.getDataInicio().getTime()));
            } else {
                pst.setDate(7, null);
            }
            pst.setString(8, objAgeComp.getHoraInicio());
            if (objAgeComp.getDataTermino() != null) {
                pst.setTimestamp(9, new java.sql.Timestamp(objAgeComp.getDataTermino().getTime()));
            } else {
                pst.setDate(9, null);
            }
            pst.setString(10, objAgeComp.getHoraTermino());
            pst.setTimestamp(11, new java.sql.Timestamp(objAgeComp.getDataLembrete().getTime()));
            pst.setString(12, objAgeComp.getHoraLembrete());
            pst.setString(13, objAgeComp.getTexto());
            pst.setString(14, objAgeComp.getUsuarioAgenda());
            pst.setString(15, objAgeComp.getUsuarioInsert());
            pst.setString(16, objAgeComp.getDataInsert());
            pst.setString(17, objAgeComp.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAgeComp;
    }

    public AgendaCompromissos alterarCompromisso(AgendaCompromissos objAgeComp) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE AGENDA_COMPROMISSOS SET StatusAgenda=?,TipoEvento=?,DataAgenda=?,Assunto=?,Prioridade=?,Conclusao=?,DataInicio=?,HoraInicio=?,DataTermino=?,HoraTermino=?,DataLembrete=?,HoraLembrete=?,Texto=?,UsuarioAgenda=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdAgenda='" + objAgeComp.getIdAgenda() + "'");
            pst.setString(1, objAgeComp.getStatusAgenda());
            pst.setString(2, objAgeComp.getTipoEvento());
            pst.setTimestamp(3, new java.sql.Timestamp(objAgeComp.getDataAgenda().getTime()));
            pst.setString(4, objAgeComp.getAssunto());
            pst.setString(5, objAgeComp.getPrioridade());
            pst.setString(6, objAgeComp.getConclusao());
            if (objAgeComp.getDataInicio() != null) {
                pst.setTimestamp(7, new java.sql.Timestamp(objAgeComp.getDataInicio().getTime()));
            } else {
                pst.setDate(7, null);
            }
            pst.setString(8, objAgeComp.getHoraInicio());
            if (objAgeComp.getDataTermino() != null) {
                pst.setTimestamp(9, new java.sql.Timestamp(objAgeComp.getDataTermino().getTime()));
            } else {
                pst.setDate(9, null);
            }
            pst.setString(10, objAgeComp.getHoraTermino());
            pst.setTimestamp(11, new java.sql.Timestamp(objAgeComp.getDataLembrete().getTime()));
            pst.setString(12, objAgeComp.getHoraLembrete());
            pst.setString(13, objAgeComp.getTexto());
            pst.setString(14, objAgeComp.getUsuarioAgenda());
            pst.setString(15, objAgeComp.getUsuarioUp());
            pst.setString(16, objAgeComp.getDataUp());
            pst.setString(17, objAgeComp.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAgeComp;
    }

    public AgendaCompromissos excluirCompromisso(AgendaCompromissos objAgeComp) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM AGENDA_COMPROMISSOS WHERE IdAgenda='" + objAgeComp.getIdAgenda() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAgeComp;
    }
    
     public AgendaCompromissos confirmarCompromisso(AgendaCompromissos objAgeComp) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE AGENDA_COMPROMISSOS SET StatusAgenda=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdAgenda='" + objAgeComp.getIdAgenda() + "'");
            pst.setString(1, objAgeComp.getStatusAgenda());                        
            pst.setString(2, objAgeComp.getUsuarioUp());
            pst.setString(3, objAgeComp.getDataUp());
            pst.setString(4, objAgeComp.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível CONFIRMAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAgeComp;
    }
}
