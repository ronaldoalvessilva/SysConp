/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensEntradaSaidaVisitasDiversas;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleItensEntradaSaidaVisitasDiversas {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensEntradaSaidaVisitasDiversas objItensVisita = new ItensEntradaSaidaVisitasDiversas();
    int codVisita;
    int codDepto;

    public ItensEntradaSaidaVisitasDiversas incluirItensVisitas(ItensEntradaSaidaVisitasDiversas objItensVisita) {
        buscarVisita(objItensVisita.getNomeVisita());
        buscarDepto(objItensVisita.getNomeDepartamento());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENSVISITASDIVERSAS (IdVisita,IdDepartamento,Idlanc,MotivoVisita,DataEntrada,HorarioEntrada,DataSaida,HorarioSaida,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, codVisita);
            pst.setInt(2, codDepto);
            pst.setInt(3, objItensVisita.getIdlanc());
            pst.setString(4, objItensVisita.getMotivoVisita());
            pst.setTimestamp(5, new java.sql.Timestamp(objItensVisita.getDataEntrada().getTime()));
            pst.setString(6, objItensVisita.getHorarioEntrada());
            pst.setTimestamp(7, new java.sql.Timestamp(objItensVisita.getDataSaida().getTime()));
            pst.setString(8, objItensVisita.getHorarioSaida());
            pst.setString(9, objItensVisita.getUsuarioInsert());
            pst.setString(10, objItensVisita.getDataInsert());
            pst.setString(11, objItensVisita.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensVisita;
    }

    public ItensEntradaSaidaVisitasDiversas alterarItensVisitas(ItensEntradaSaidaVisitasDiversas objItensVisita) {
        buscarVisita(objItensVisita.getNomeVisita());
        buscarDepto(objItensVisita.getNomeDepartamento());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSVISITASDIVERSAS SET IdVisita=?,IdDepartamento=?,Idlanc=?,MotivoVisita=?,DataEntrada=?,HorarioEntrada=?,DataSaida=?,HorarioSaida=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objItensVisita.getIdItem() + "'");
            pst.setInt(1, codVisita);
            pst.setInt(2, codDepto);
            pst.setInt(3, objItensVisita.getIdlanc());
            pst.setString(4, objItensVisita.getMotivoVisita());
            pst.setTimestamp(5, new java.sql.Timestamp(objItensVisita.getDataEntrada().getTime()));
            pst.setString(6, objItensVisita.getHorarioEntrada());
            pst.setTimestamp(7, new java.sql.Timestamp(objItensVisita.getDataSaida().getTime()));
            pst.setString(8, objItensVisita.getHorarioSaida());
            pst.setString(9, objItensVisita.getUsuarioUp());
            pst.setString(10, objItensVisita.getDataUp());
            pst.setString(11, objItensVisita.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensVisita;
    }

    public ItensEntradaSaidaVisitasDiversas excluirItensVisita(ItensEntradaSaidaVisitasDiversas objItensVisita) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENSVISITASDIVERSAS WHERE IdItem='" + objItensVisita.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensVisita;
    }

    public void buscarVisita(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM VISITASDIVERSAS WHERE NomeVisita='" + desc + "'");
            conecta.rs.first();
            codVisita = conecta.rs.getInt("IdVisita");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (VISITA) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }

    public void buscarDepto(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM DEPARTAMENTOS WHERE NomeDepartamento='" + desc + "'");
            conecta.rs.first();
            codDepto = conecta.rs.getInt("IdDepartamento");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (DEPARTAMENTO) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
