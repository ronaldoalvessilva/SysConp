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
 * @author Ronaldo
 */
public class ControleInternasVisitandoInternos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensEntradaSaidaVisitasInternos objItensVisitaInternos = new ItensEntradaSaidaVisitasInternos();
    int codInterno;

    public ItensEntradaSaidaVisitasInternos incluirItensVisitasInternos(ItensEntradaSaidaVisitasInternos objItensVisitaInternos) {
        buscarInternaVisitante(objItensVisitaInternos.getNomeVisita(), objItensVisitaInternos.getIdVisita());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_VISITA_INTERNA (IdInternoCrc,IdRol,Idlanc,DataEntrada,HorarioEntrada,DataSaida,HorarioSaida,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, codInterno);
            pst.setInt(2, objItensVisitaInternos.getIdRol());
            pst.setInt(3, objItensVisitaInternos.getIdlanc());
            pst.setTimestamp(4, new java.sql.Timestamp(objItensVisitaInternos.getDataEntrada().getTime()));
            pst.setString(5, objItensVisitaInternos.getHorarioEntrada());
            pst.setTimestamp(6, new java.sql.Timestamp(objItensVisitaInternos.getDataSaida().getTime()));
            pst.setString(7, objItensVisitaInternos.getHorarioSaida());
            pst.setString(8, objItensVisitaInternos.getUsuarioInsert());
            pst.setString(9, objItensVisitaInternos.getDataInsert());
            pst.setString(10, objItensVisitaInternos.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados na tabela (ITENSFAMILIAR).\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensVisitaInternos;
    }

    public ItensEntradaSaidaVisitasInternos alterarItensVisitasInternos(ItensEntradaSaidaVisitasInternos objItensVisitaInternos) {
        buscarInternaVisitante(objItensVisitaInternos.getNomeVisita(), objItensVisitaInternos.getIdVisita());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_VISITA_INTERNA SET IdInternoCrc=?,IdRol=?,Idlanc=?,DataEntrada=?,HorarioEntrada=?,DataSaida=?,HorarioSaida=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objItensVisitaInternos.getIdItem() + "'");
            pst.setInt(1, codInterno);
            pst.setInt(2, objItensVisitaInternos.getIdRol());
            pst.setInt(3, objItensVisitaInternos.getIdlanc());
            pst.setTimestamp(4, new java.sql.Timestamp(objItensVisitaInternos.getDataEntrada().getTime()));
            pst.setString(5, objItensVisitaInternos.getHorarioEntrada());
            pst.setTimestamp(6, new java.sql.Timestamp(objItensVisitaInternos.getDataSaida().getTime()));
            pst.setString(7, objItensVisitaInternos.getHorarioSaida());
            pst.setString(8, objItensVisitaInternos.getUsuarioInsert());
            pst.setString(9, objItensVisitaInternos.getDataInsert());
            pst.setString(10, objItensVisitaInternos.getHoraInsert());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensVisitaInternos;
    }

    public ItensEntradaSaidaVisitasInternos excluirItensVisitaInternos(ItensEntradaSaidaVisitasInternos objItensVisitaInternos) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_VISITA_INTERNA WHERE IdItem='" + objItensVisitaInternos.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensVisitaInternos;
    }

    public void buscarInternaVisitante(String desc, int codigoInterno) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + desc + "'AND IdInternoCrc='" + codigoInterno + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNA) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }

}
