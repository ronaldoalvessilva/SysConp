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
public class ControleItensEntradaSaidaVisitasInternos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensEntradaSaidaVisitasInternos objItensVisitaInternos = new ItensEntradaSaidaVisitasInternos();
    int codInterno;
    int codVisita;

    public ItensEntradaSaidaVisitasInternos incluirItensVisitasInternos(ItensEntradaSaidaVisitasInternos objItensVisitaInternos) {
        buscarVisita(objItensVisitaInternos.getIdVisita(), objItensVisitaInternos.getNomeVisita());
        buscarInterno(objItensVisitaInternos.getNomeInternosCrc(), objItensVisitaInternos.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENSFAMILIAR (IdInternoCrc,IdVisita,IdRol,Idlanc,DataEntrada,HorarioEntrada,DataSaida,HorarioSaida,UsuarioInsert,DataInsert,HorarioInsert,TipoOperacao,AssinaturaEntrada) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, codInterno);
            pst.setInt(2, codVisita);
            pst.setInt(3, objItensVisitaInternos.getIdRol());
            pst.setInt(4, objItensVisitaInternos.getIdlanc());
            pst.setTimestamp(5, new java.sql.Timestamp(objItensVisitaInternos.getDataEntrada().getTime()));
            pst.setString(6, objItensVisitaInternos.getHorarioEntrada());
            if (objItensVisitaInternos.getDataSaida() != null) {
                pst.setTimestamp(7, new java.sql.Timestamp(objItensVisitaInternos.getDataSaida().getTime()));
            } else {
                pst.setDate(7, null);
            }
            pst.setString(8, objItensVisitaInternos.getHorarioSaida());
            pst.setString(9, objItensVisitaInternos.getUsuarioInsert());
            pst.setString(10, objItensVisitaInternos.getDataInsert());
            pst.setString(11, objItensVisitaInternos.getHoraInsert());
            pst.setString(12, objItensVisitaInternos.getTipoOperacao());
            pst.setBytes(13, objItensVisitaInternos.getAssinaturaEntradaVisita());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados na tabela (ITENSFAMILIAR).\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensVisitaInternos;
    }

    public ItensEntradaSaidaVisitasInternos alterarItensVisitasInternos(ItensEntradaSaidaVisitasInternos objItensVisitaInternos) {
        buscarVisita(objItensVisitaInternos.getIdVisita(), objItensVisitaInternos.getNomeVisita());
        buscarInterno(objItensVisitaInternos.getNomeInternosCrc(), objItensVisitaInternos.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSFAMILIAR SET IdInternoCrc=?,IdVisita=?,IdRol=?,Idlanc=?,DataEntrada=?,HorarioEntrada=?,DataSaida=?,HorarioSaida=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objItensVisitaInternos.getIdItem() + "'");
            pst.setInt(1, codInterno);
            pst.setInt(2, codVisita);
            pst.setInt(3, objItensVisitaInternos.getIdRol());
            pst.setInt(4, objItensVisitaInternos.getIdlanc());
            pst.setTimestamp(5, new java.sql.Timestamp(objItensVisitaInternos.getDataEntrada().getTime()));
            pst.setString(6, objItensVisitaInternos.getHorarioEntrada());
            pst.setTimestamp(7, new java.sql.Timestamp(objItensVisitaInternos.getDataSaida().getTime()));
            pst.setString(8, objItensVisitaInternos.getHorarioSaida());
            pst.setString(9, objItensVisitaInternos.getUsuarioUp());
            pst.setString(10, objItensVisitaInternos.getDataUp());
            pst.setString(11, objItensVisitaInternos.getHoraUp());            
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objItensVisitaInternos;
    }

    public ItensEntradaSaidaVisitasInternos excluirItensVisitaInternos(ItensEntradaSaidaVisitasInternos objItensVisitaInternos) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENSFAMILIAR WHERE IdItem='" + objItensVisitaInternos.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensVisitaInternos;
    }

    //---------------------------------------- UPDATE ATRAVES DA BIOMETRIA NA SAÍDA DA VISITA -------------------------------------------
       
    public ItensEntradaSaidaVisitasInternos alterarItensVisitasInternoBio(ItensEntradaSaidaVisitasInternos objItensVisitaInternos) {
        buscarVisita(objItensVisitaInternos.getIdVisita(), objItensVisitaInternos.getNomeVisita());
        buscarInterno(objItensVisitaInternos.getNomeInternosCrc(), objItensVisitaInternos.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSFAMILIAR SET DataSaida=?,HorarioSaida=?,UsuarioUp=?,DataUp=?,HorarioUp=?,AssinaturaSaida=? WHERE IdItem='" + objItensVisitaInternos.getIdItem() + "'");          
            pst.setTimestamp(1, new java.sql.Timestamp(objItensVisitaInternos.getDataSaida().getTime()));
            pst.setString(2, objItensVisitaInternos.getHorarioSaida());
            pst.setString(3, objItensVisitaInternos.getUsuarioUp());
            pst.setString(4, objItensVisitaInternos.getDataUp());
            pst.setString(5, objItensVisitaInternos.getHoraUp());            
            pst.setBytes(6, objItensVisitaInternos.getAssinaturaSaidaVisita());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensVisitaInternos;
    }
    
    public void buscarVisita(int idVisita, String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM VISITASINTERNO WHERE NomeVisita='" + desc + "'AND IdVisita='" + idVisita + "'");
            conecta.rs.first();
            codVisita = conecta.rs.getInt("IdVisita");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (VISITA) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }

    public void buscarInterno(String desc, int codigoInterno) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + desc + "'AND IdInternoCrc='" + codigoInterno + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNO) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
