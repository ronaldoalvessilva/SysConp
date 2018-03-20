/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AgendaEscolta;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleAgendaEscolta {
    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AgendaEscolta objAgenda = new AgendaEscolta();
    
    // Incluir agenda
    public AgendaEscolta incluirAgendaEscolta(AgendaEscolta objAgenda){
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO AGENDAESCOLTA (DataAgenda,StatusAgenda,ObsAgenda,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?)");                        
            pst.setTimestamp(1, new java.sql.Timestamp(objAgenda.getDataAgenda().getTime()));
            pst.setString(2, objAgenda.getStatusAgenda());
            pst.setString(3, objAgenda.getObsAgenda());  
            pst.setString(4, objAgenda.getUsuarioInsert());
            pst.setString(5, objAgenda.getDataInsert());
            pst.setString(6, objAgenda.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAgenda;
    }
    // Alterar agenda
    public AgendaEscolta alterarAgendaEscolta(AgendaEscolta objAgenda){
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE AGENDAESCOLTA SET DataAgenda=?,StatusAgenda=?,ObsAgenda=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdAgenda='" + objAgenda.getIdAgenda()  + "'");                        
            pst.setTimestamp(1, new java.sql.Timestamp(objAgenda.getDataAgenda().getTime()));
            pst.setString(2, objAgenda.getStatusAgenda());
            pst.setString(3, objAgenda.getObsAgenda()); 
            pst.setString(4, objAgenda.getUsuarioUp());
            pst.setString(5, objAgenda.getDataUp());
            pst.setString(6, objAgenda.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAgenda;
    }
    // Excluir agenda
    public AgendaEscolta excluirAgendaEscolta(AgendaEscolta objAgenda){
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM AGENDAESCOLTA WHERE IdAgenda='" + objAgenda.getIdAgenda()  + "'");                                  
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAgenda;
    }
    public AgendaEscolta finalizarAgendaEscolta(AgendaEscolta objAgenda){
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE AGENDAESCOLTA SET StatusAgenda=? WHERE IdAgenda='" + objAgenda.getIdAgenda()  + "'");                                  
            pst.setString(1, objAgenda.getStatusAgenda());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR o agendamento\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAgenda;
    }
}
