/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.CalendarioVacinasInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleCalendarioVacinasInterno {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    CalendarioVacinasInternos objCal = new CalendarioVacinasInternos();

    int codInterno;

    public CalendarioVacinasInternos incluirCartilhaVacinas(CalendarioVacinasInternos objCal) {
        buscarInterno(objCal.getNomeInternoCrcVacina(), objCal.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO CARTILHA_VACINAS_INTERNOS (StatusCart,DataCart,IdInternoCrc,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES (?,?,?,?,?,?,?)");
            pst.setString(1, objCal.getStatusCart());
            pst.setTimestamp(2, new java.sql.Timestamp(objCal.getDataCart().getTime()));
            pst.setInt(3, codInterno);
            pst.setString(4, objCal.getObservacao());
            pst.setString(5, objCal.getUsuarioInsert());
            pst.setString(6, objCal.getDataInsert());
            pst.setString(7, objCal.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCal;
    }

    public CalendarioVacinasInternos alterarCartilhaVacinas(CalendarioVacinasInternos objCal) {
        buscarInterno(objCal.getNomeInternoCrcVacina(), objCal.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE CARTILHA_VACINAS_INTERNOS SET StatusCart=?,DataCart=?,IdInternoCrc=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdCart='" + objCal.getIdCart() + "'");
            pst.setString(1, objCal.getStatusCart());
            pst.setTimestamp(2, new java.sql.Timestamp(objCal.getDataCart().getTime()));
            pst.setInt(3, codInterno);
            pst.setString(4, objCal.getObservacao());
            pst.setString(5, objCal.getUsuarioUp());
            pst.setString(6, objCal.getDataUp());
            pst.setString(7, objCal.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCal;
    }

    public CalendarioVacinasInternos excluirCartilhaVacinas(CalendarioVacinasInternos objCal) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM CARTILHA_VACINAS_INTERNOS WHERE IdCart='" + objCal.getIdCart() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCal;
    }
    
     public CalendarioVacinasInternos finalizarCartilhaVacinas(CalendarioVacinasInternos objCal) {
      
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE CARTILHA_VACINAS_INTERNOS SET StatusCart=? WHERE IdCart='" + objCal.getIdCart() + "'");
            pst.setString(1, objCal.getStatusCart());          
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível FINALIZAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCal;
    }

    public void buscarInterno(String desc, int cod) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE NomeInternoCrc='" + desc + "' "
                    + "AND IdInternoCrc='" + cod + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível pesquisar o interno.\nERRO: " + ex);
        }
    }
}
