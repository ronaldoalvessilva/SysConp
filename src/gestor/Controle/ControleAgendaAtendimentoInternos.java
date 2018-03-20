/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AgendamentoAtendimentoInterno;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleAgendaAtendimentoInternos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AgendamentoAtendimentoInterno objAgendaAtend = new AgendamentoAtendimentoInterno();

    public AgendamentoAtendimentoInterno incluirAgendaAtendimento(AgendamentoAtendimentoInterno objAgendaAtend) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO AGENDA_ATENDIMENTO_INTERNOS (StatusReg,DataReg,Departamento,DataAg,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?)");
            pst.setString(1, objAgendaAtend.getStatusReg());
            pst.setTimestamp(2, new java.sql.Timestamp(objAgendaAtend.getDataReg().getTime()));
            pst.setString(3, objAgendaAtend.getDepartamentoAgendamento());
            pst.setTimestamp(4, new java.sql.Timestamp(objAgendaAtend.getDataAg().getTime()));
            pst.setString(5, objAgendaAtend.getObservacao());
            pst.setString(6, objAgendaAtend.getUsuarioInsert());
            pst.setString(7, objAgendaAtend.getDataInsert());
            pst.setString(8, objAgendaAtend.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAgendaAtend;
    }

    public AgendamentoAtendimentoInterno alterarAgendaAtendimento(AgendamentoAtendimentoInterno objAgendaAtend) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE AGENDA_ATENDIMENTO_INTERNOS SET StatusReg=?,DataReg=?,Departamento=?,DataAg=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdReg='" + objAgendaAtend.getIdReg() + "'");
            pst.setString(1, objAgendaAtend.getStatusReg());
            pst.setTimestamp(2, new java.sql.Timestamp(objAgendaAtend.getDataReg().getTime()));
            pst.setString(3, objAgendaAtend.getDepartamentoAgendamento());
            pst.setTimestamp(4, new java.sql.Timestamp(objAgendaAtend.getDataAg().getTime()));
            pst.setString(5, objAgendaAtend.getObservacao());
            pst.setString(6, objAgendaAtend.getUsuarioUp());
            pst.setString(7, objAgendaAtend.getDataUp());
            pst.setString(8, objAgendaAtend.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAgendaAtend;
    }

    public AgendamentoAtendimentoInterno excluirAgendaAtendimento(AgendamentoAtendimentoInterno objAgendaAtendobjAgendaAtend) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM AGENDA_ATENDIMENTO_INTERNOS WHERE IdReg='" + objAgendaAtendobjAgendaAtend.getIdReg() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAgendaAtendobjAgendaAtend;
    }        
}
