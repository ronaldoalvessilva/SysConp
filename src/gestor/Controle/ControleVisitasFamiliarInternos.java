/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensEntradaSaidaVisitasInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleVisitasFamiliarInternos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensEntradaSaidaVisitasInternos objItensVisitaInternos = new ItensEntradaSaidaVisitasInternos();

    // Incluir interno no histórico da visita (familiar)
    public ItensEntradaSaidaVisitasInternos incluirInternoVisita(ItensEntradaSaidaVisitasInternos objItensVisitaInternos) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO HISTORICOVISITASINTERNOS (IdInternoCrc,IdVisita,Idlanc,DataEntrada,HorarioEntrada,DataSaida,HorarioSaida) VALUES(?,?,?,?,?,?,?)");
            pst.setInt(1, objItensVisitaInternos.getIdInternoCrc());
            pst.setInt(2, objItensVisitaInternos.getIdVisita());
            pst.setInt(3, objItensVisitaInternos.getIdlanc());
            pst.setTimestamp(4, new java.sql.Timestamp(objItensVisitaInternos.getDataEntrada().getTime()));
            pst.setString(5, objItensVisitaInternos.getHorarioEntrada());
            if(objItensVisitaInternos.getDataSaida() != null){
               pst.setTimestamp(6, new java.sql.Timestamp(objItensVisitaInternos.getDataSaida().getTime()));  
            }else{
                pst.setDate(7, null);
            }           
            pst.setString(7, objItensVisitaInternos.getHorarioSaida());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados na tabela HISTORICOVISITASINTERNOS.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensVisitaInternos;
    }
    // Alterar interno no histórico das visitas (familia)
    public ItensEntradaSaidaVisitasInternos alterarInternoVisita(ItensEntradaSaidaVisitasInternos objItensVisitaInternos) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE HISTORICOVISITASINTERNOS SET IdInternoCrc=?,IdVisita=?,Idlanc=?,DataEntrada=?,HorarioEntrada=?,DataSaida=?,HorarioSaida=? WHERE IdLanc='" + objItensVisitaInternos.getIdlanc()  + "'AND IdInternoCrc='" + objItensVisitaInternos.getIdInternoCrc()  + "'AND IdVisita='" + objItensVisitaInternos.getIdVisita() + "'");
            pst.setInt(1, objItensVisitaInternos.getIdInternoCrc());
            pst.setInt(2, objItensVisitaInternos.getIdVisita());
            pst.setInt(3, objItensVisitaInternos.getIdlanc());
            pst.setTimestamp(4, new java.sql.Timestamp(objItensVisitaInternos.getDataEntrada().getTime()));
            pst.setString(5, objItensVisitaInternos.getHorarioEntrada());
            pst.setTimestamp(6, new java.sql.Timestamp(objItensVisitaInternos.getDataSaida().getTime()));
            pst.setString(7, objItensVisitaInternos.getHorarioSaida());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensVisitaInternos;
    }
    // Excluir histórico de Internos na entrada de visitas (familia)
    public ItensEntradaSaidaVisitasInternos excluirInternoVisita(ItensEntradaSaidaVisitasInternos objItensVisitaInternos) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM HISTORICOVISITASINTERNOS  WHERE IdLanc='" + objItensVisitaInternos.getIdlanc()  + "'AND IdInternoCrc='" + objItensVisitaInternos.getIdInternoCrc()  + "'AND IdVisita='" + objItensVisitaInternos.getIdVisita() + "'");           
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensVisitaInternos;
    }
}
