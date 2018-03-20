/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AdmissaoPsicologica;
import gestor.Modelo.AgendaRecados;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleAgendaRecados {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AgendaRecados objAgendaRec = new AgendaRecados();
    int codUsuario;

    public AgendaRecados incluirAgendaRecado(AgendaRecados objAgendaRec) {
        buscarUsuario(objAgendaRec.getNomeUsuario());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO AGENDARECADOS (DataLanc,Horario,StatusAgenda,NomeUsuarioLogado,IdUsuario,Recados,MensagemEnviada,MensagemRecebida) VALUES(?,?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objAgendaRec.getDataLanc().getTime()));
            pst.setString(2, objAgendaRec.getHorario());
            pst.setString(3, objAgendaRec.getStatusAgena());
            pst.setString(4, objAgendaRec.getNomeUsuarioLogado());
            pst.setInt(5, codUsuario);
            pst.setString(6, objAgendaRec.getRecados());
            pst.setString(7, objAgendaRec.getMensagemEnviada());
            pst.setString(8, objAgendaRec.getMensagemRecebida());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAgendaRec;
    }

    public AgendaRecados alterarAgendaRecado(AgendaRecados objAgendaRec) {
        buscarUsuario(objAgendaRec.getNomeUsuario());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE AGENDARECADOS SET DataLanc=?,Horario=?,StatusAgenda=?,NomeUsuarioLogado=?,IdUsuario=?,Recados=?,MensagemEnviada=?,MensagemRecebida=? WHERE IdLanc='" + objAgendaRec.getIdLanc() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objAgendaRec.getDataLanc().getTime()));
            pst.setString(2, objAgendaRec.getHorario());
            pst.setString(3, objAgendaRec.getStatusAgena());
            pst.setString(4, objAgendaRec.getNomeUsuarioLogado());
            pst.setInt(5, codUsuario);
            pst.setString(6, objAgendaRec.getRecados());
            pst.setString(7, objAgendaRec.getMensagemEnviada());
            pst.setString(8, objAgendaRec.getMensagemRecebida());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAgendaRec;
    }

     public AgendaRecados alterarStatusAgendaRecado(AgendaRecados objAgendaRec) {
       
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE AGENDARECADOS SET StatusAgenda=?,MensagemRecebida=? WHERE IdLanc='" + objAgendaRec.getIdLanc() + "'");            
            pst.setString(1, objAgendaRec.getStatusAgena()); 
            pst.setString(2, objAgendaRec.getMensagemRecebida());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAgendaRec;
    }
    public AgendaRecados excluirAgendaRecado(AgendaRecados objAgendaRec) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM AGENDARECADOS WHERE IdLanc='" + objAgendaRec.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAgendaRec;
    }

    public void buscarUsuario(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS WHERE NomeUsuario='" + desc + "'");
            conecta.rs.first();
            codUsuario = conecta.rs.getInt("IdUsuario");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível pesquisar o usuario.\nERRO: " + ex);
        }
    }
}
