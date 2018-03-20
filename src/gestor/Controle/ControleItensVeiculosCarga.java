/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensVeiculosCarga;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleItensVeiculosCarga {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensVeiculosCarga objItensVeicCarga = new ItensVeiculosCarga();
    int codVisita;

    public ItensVeiculosCarga incluirItensVeiculoCarga(ItensVeiculosCarga objItensVeicCarga) {
        buscarVisitante(objItensVeicCarga.getNomeVisita(), objItensVeicCarga.getIdVisita());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENSVEICULOCARGA (Idlanc,IdVisita,DataEntrada,HorarioEntrada,DataSaida,HorarioSaida,OrigemEntrada,DestinoEntrada,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objItensVeicCarga.getIdLanc());
            pst.setInt(2, codVisita);
            pst.setTimestamp(3, new java.sql.Timestamp(objItensVeicCarga.getDataEntrada().getTime()));
            pst.setString(4, objItensVeicCarga.getHorarioEntrada());
            pst.setTimestamp(5, new java.sql.Timestamp(objItensVeicCarga.getDataSaida().getTime()));
            pst.setString(6, objItensVeicCarga.getHorarioSaida());
            pst.setString(7, objItensVeicCarga.getOrigemEntrada());
            pst.setString(8, objItensVeicCarga.getDestinoEntrada());
            pst.setString(9, objItensVeicCarga.getUsuarioInsert());
            pst.setString(10, objItensVeicCarga.getDataInsert());
            pst.setString(11, objItensVeicCarga.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensVeicCarga;
    }

    public ItensVeiculosCarga alterarItensVeiculoCarga(ItensVeiculosCarga objItensVeicCarga) {
        buscarVisitante(objItensVeicCarga.getNomeVisita(), objItensVeicCarga.getIdVisita());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSVEICULOCARGA SET Idlanc=?,IdVisita=?,DataEntrada=?,HorarioEntrada=?,DataSaida=?,HorarioSaida=?,OrigemEntrada=?,DestinoEntrada=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE Iditem='" + objItensVeicCarga.getIdItem() + "'");
            pst.setInt(1, objItensVeicCarga.getIdLanc());
            pst.setInt(2, codVisita);
            pst.setTimestamp(3, new java.sql.Timestamp(objItensVeicCarga.getDataEntrada().getTime()));
            pst.setString(4, objItensVeicCarga.getHorarioEntrada());
            pst.setTimestamp(5, new java.sql.Timestamp(objItensVeicCarga.getDataSaida().getTime()));
            pst.setString(6, objItensVeicCarga.getHorarioSaida());
            pst.setString(7, objItensVeicCarga.getOrigemEntrada());
            pst.setString(8, objItensVeicCarga.getDestinoEntrada());
            pst.setString(9, objItensVeicCarga.getUsuarioUp());
            pst.setString(10, objItensVeicCarga.getDataUp());
            pst.setString(11, objItensVeicCarga.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensVeicCarga;
    }

    public ItensVeiculosCarga excluirItensVeiculoCarga(ItensVeiculosCarga objItensVeicCarga) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENSVEICULOCARGA WHERE Iditem='" + objItensVeicCarga.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensVeicCarga;
    }

    public void buscarVisitante(String desc, int codV1) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM VISITASDIVERSAS WHERE NomeVisita='" + desc + "'AND IdVisita='" + codV1 + "'");
            conecta.rs.first();
            codVisita = conecta.rs.getInt("IdVisita");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (VISITA) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
