/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.VisitasAdvogadosInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleVisitasAdvogados {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    VisitasAdvogadosInternos objEntSaiAdInternos = new VisitasAdvogadosInternos();
    
    public VisitasAdvogadosInternos incluirAdvogadosInterno(VisitasAdvogadosInternos objEntSaiAdInternos) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO VISITASADVOGADOS (IdAdvogado,IdInternoCrc,Idlanc,DataEntrada,HorarioEntrada,DataSaida,HorarioSaida) VALUES(?,?,?,?,?,?,?)");
            pst.setInt(1, objEntSaiAdInternos.getIdAdvogado());
            pst.setInt(2, objEntSaiAdInternos.getIdInternoCrc());
            pst.setInt(3, objEntSaiAdInternos.getIdLanc());
            pst.setTimestamp(4, new java.sql.Timestamp(objEntSaiAdInternos.getDataEntrada().getTime()));
            pst.setString(5, objEntSaiAdInternos.getHorarioEntrada());
            pst.setTimestamp(6, new java.sql.Timestamp(objEntSaiAdInternos.getDataSaida().getTime()));
            pst.setString(7, objEntSaiAdInternos.getHorarioSaida());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntSaiAdInternos;
    }
    public VisitasAdvogadosInternos alterarAdvogadosInterno(VisitasAdvogadosInternos objEntSaiAdInternos) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE VISITASADVOGADOS SET IdAdvogado=?,IdInternoCrc=?,Idlanc=?,DataEntrada=?,HorarioEntrada=?,DataSaida=?,HorarioSaida=? WHERE Idlanc='" + objEntSaiAdInternos.getIdLanc() + "'");
            pst.setInt(1, objEntSaiAdInternos.getIdAdvogado());
            pst.setInt(2, objEntSaiAdInternos.getIdInternoCrc());
            pst.setInt(3, objEntSaiAdInternos.getIdLanc());
            pst.setTimestamp(4, new java.sql.Timestamp(objEntSaiAdInternos.getDataEntrada().getTime()));
            pst.setString(5, objEntSaiAdInternos.getHorarioEntrada());
            pst.setTimestamp(6, new java.sql.Timestamp(objEntSaiAdInternos.getDataSaida().getTime()));
            pst.setString(7, objEntSaiAdInternos.getHorarioSaida());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntSaiAdInternos;
    }
    public VisitasAdvogadosInternos excluirAdvogadosInterno(VisitasAdvogadosInternos objEntSaiAdInternos) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM VISITASADVOGADOS WHERE Idlanc='" + objEntSaiAdInternos.getIdLanc() + "' AND IdInternoCrc='" + objEntSaiAdInternos.getIdInternoCrc()  + "'");            
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntSaiAdInternos;
    }    
    public VisitasAdvogadosInternos alterarHorarioAdvogadosInterno(VisitasAdvogadosInternos objEntSaiAdInternos) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE VISITASADVOGADOS SET DataEntrada=?,HorarioEntrada=?,DataSaida=?,HorarioSaida=? WHERE Idlanc='" + objEntSaiAdInternos.getIdLanc() + "'");            
            pst.setTimestamp(1, new java.sql.Timestamp(objEntSaiAdInternos.getDataEntrada().getTime()));
            pst.setString(2, objEntSaiAdInternos.getHorarioEntrada());
            pst.setTimestamp(3, new java.sql.Timestamp(objEntSaiAdInternos.getDataSaida().getTime()));
            pst.setString(4, objEntSaiAdInternos.getHorarioSaida());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEntSaiAdInternos;
    }
}
