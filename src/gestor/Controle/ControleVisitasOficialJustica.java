/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.VisitasOficialJusticaInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleVisitasOficialJustica {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    VisitasOficialJusticaInternos objVisitasOFInt = new VisitasOficialJusticaInternos();
    
    public VisitasOficialJusticaInternos incluirOficialJusticaInterno(VisitasOficialJusticaInternos objVisitasOFInt) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO VISITAS_OFICIAL_JUSTICA (IdOficial,IdInternoCrc,Idlanc,DataEntrada,HorarioEntrada,DataSaida,HorarioSaida) VALUES(?,?,?,?,?,?,?)");
            pst.setInt(1, objVisitasOFInt.getIdOficial());
            pst.setInt(2, objVisitasOFInt.getIdInternoCrc());
            pst.setInt(3, objVisitasOFInt.getIdLanc());
            pst.setTimestamp(4, new java.sql.Timestamp(objVisitasOFInt.getDataEntrada().getTime()));
            pst.setString(5, objVisitasOFInt.getHorarioEntrada());
            pst.setTimestamp(6, new java.sql.Timestamp(objVisitasOFInt.getDataSaida().getTime()));
            pst.setString(7, objVisitasOFInt.getHorarioSaida());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objVisitasOFInt;
    }
    public VisitasOficialJusticaInternos alterarOficialJusticaInterno(VisitasOficialJusticaInternos objVisitasOFInt) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE VISITAS_OFICIAL_JUSTICA SET IdOficial=?,IdInternoCrc=?,Idlanc=?,DataEntrada=?,HorarioEntrada=?,DataSaida=?,HorarioSaida=? WHERE Idlanc='" + objVisitasOFInt.getIdLanc() + "'");
            pst.setInt(1, objVisitasOFInt.getIdOficial());
            pst.setInt(2, objVisitasOFInt.getIdInternoCrc());
            pst.setInt(3, objVisitasOFInt.getIdLanc());
            pst.setTimestamp(4, new java.sql.Timestamp(objVisitasOFInt.getDataEntrada().getTime()));
            pst.setString(5, objVisitasOFInt.getHorarioEntrada());
            pst.setTimestamp(6, new java.sql.Timestamp(objVisitasOFInt.getDataSaida().getTime()));
            pst.setString(7, objVisitasOFInt.getHorarioSaida());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objVisitasOFInt;
    }
    public VisitasOficialJusticaInternos excluirOficialJusticaInterno(VisitasOficialJusticaInternos objVisitasOFInt) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM VISITAS_OFICIAL_JUSTICA WHERE Idlanc='" + objVisitasOFInt.getIdLanc() + "' AND IdInternoCrc='" + objVisitasOFInt.getIdInternoCrc()  + "'");            
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objVisitasOFInt;
    }    
    public VisitasOficialJusticaInternos alterarHorarioOficialJusticaInterno(VisitasOficialJusticaInternos objVisitasOFInt) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE VISITAS_OFICIAL_JUSTICA SET DataEntrada=?,HorarioEntrada=?,DataSaida=?,HorarioSaida=? WHERE Idlanc='" + objVisitasOFInt.getIdLanc() + "'");            
            pst.setTimestamp(1, new java.sql.Timestamp(objVisitasOFInt.getDataEntrada().getTime()));
            pst.setString(2, objVisitasOFInt.getHorarioEntrada());
            pst.setTimestamp(3, new java.sql.Timestamp(objVisitasOFInt.getDataSaida().getTime()));
            pst.setString(4, objVisitasOFInt.getHorarioSaida());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objVisitasOFInt;
    }
}
