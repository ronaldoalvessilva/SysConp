/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AgendaEscolta;
import gestor.Modelo.ItensAgendaEscolta;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleItensAgendaEscolta {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AgendaEscolta objAgenda = new AgendaEscolta();
    ItensAgendaEscolta objItensAgenda = new ItensAgendaEscolta();
    int codInt;

    public ItensAgendaEscolta incluirItensAgenda(ItensAgendaEscolta objItensAgenda) {

        buscarInternoCrc(objItensAgenda.getNomeInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENSAGENDA (IdInternoCrc,IdAgenda,DataAgenda,HorarioAgenda,LocalAgenda,OficioAgenda,UsuarioInsert,DataInsert,HorarioInsert,UtilizaAgenda) VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, codInt);
            pst.setInt(2, objItensAgenda.getIdAgenda());
            pst.setTimestamp(3, new java.sql.Timestamp(objItensAgenda.getDataAgendamento().getTime()));
            pst.setString(4, objItensAgenda.getHorarioAgenda());
            pst.setString(5, objItensAgenda.getLocalAgenda());
            pst.setString(6, objItensAgenda.getOficioAgenda());
            pst.setString(7, objItensAgenda.getUsuarioInsert());
            pst.setString(8, objItensAgenda.getDataInsert());
            pst.setString(9, objItensAgenda.getHoraInsert());
            pst.setString(10, objItensAgenda.getUtilizaAgenda());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensAgenda;
    }

    public ItensAgendaEscolta alterarItensAgenda(ItensAgendaEscolta objItensAgenda) {

        buscarInternoCrc(objItensAgenda.getNomeInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSAGENDA SET IdInternoCrc=?,IdAgenda=?,DataAgenda=?,HorarioAgenda=?,LocalAgenda=?,OficioAgenda=?,UsuarioUp=?,DataUp=?,HorarioUp=?,UtilizaAgenda=? WHERE IdItem='" + objItensAgenda.getIdItem()+ "'");
            pst.setInt(1, codInt);
            pst.setInt(2, objItensAgenda.getIdAgenda());
            pst.setTimestamp(3, new java.sql.Timestamp(objItensAgenda.getDataAgendamento().getTime()));
            pst.setString(4, objItensAgenda.getHorarioAgenda());
            pst.setString(5, objItensAgenda.getLocalAgenda());
            pst.setString(6, objItensAgenda.getOficioAgenda());
            pst.setString(7, objItensAgenda.getUsuarioUp());
            pst.setString(8, objItensAgenda.getDataUp());
            pst.setString(9, objItensAgenda.getHoraUp());
            pst.setString(10, objItensAgenda.getUtilizaAgenda());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensAgenda;
    }
     public ItensAgendaEscolta excluirItensAgenda(ItensAgendaEscolta objItensAgenda) {
        
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENSAGENDA WHERE IdItem='" + objItensAgenda.getIdItem()+ "'");            
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensAgenda;
    }
    
// Buscar INTERNO
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
