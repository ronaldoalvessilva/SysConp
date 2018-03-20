/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.CargaHoraria;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleCargaHoraria {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    CargaHoraria objCargaHoraria = new CargaHoraria();

    public CargaHoraria incluirCargaHoraria(CargaHoraria objCargaHoraria) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO CARGAHORARIA (StatusCarga,DataCad,DescricaoCarga,QtdDias,QtdHoras,MesReferencia,AnoReferencia,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objCargaHoraria.getStatusCarga());
            pst.setTimestamp(2, new java.sql.Timestamp(objCargaHoraria.getDataCad().getTime()));
            pst.setString(3, objCargaHoraria.getDescricaoCarga());
            pst.setString(4, objCargaHoraria.getQtdDias());
            pst.setString(5, objCargaHoraria.getQtdHoras());
            pst.setString(6, objCargaHoraria.getMesReferencia());
            pst.setInt(7, objCargaHoraria.getAnoReferencia());
            pst.setString(8, objCargaHoraria.getUsuarioInsert());
            pst.setString(9, objCargaHoraria.getDataInsert());
            pst.setString(10, objCargaHoraria.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objCargaHoraria;
    }

    public CargaHoraria alterarCargaHoraria(CargaHoraria objCargaHoraria) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE CARGAHORARIA SET StatusCarga=?,DataCad=?,DescricaoCarga=?,QtdDias=?,QtdHoras=?,MesReferencia=?,AnoReferencia=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdCarga='" + objCargaHoraria.getIdCarga() + "'");
            pst.setString(1, objCargaHoraria.getStatusCarga());
            pst.setTimestamp(2, new java.sql.Timestamp(objCargaHoraria.getDataCad().getTime()));
            pst.setString(3, objCargaHoraria.getDescricaoCarga());
            pst.setString(4, objCargaHoraria.getQtdDias());
            pst.setString(5, objCargaHoraria.getQtdHoras());
            pst.setString(6, objCargaHoraria.getMesReferencia());
            pst.setInt(7, objCargaHoraria.getAnoReferencia());
            pst.setString(8, objCargaHoraria.getUsuarioUp());
            pst.setString(9, objCargaHoraria.getDataUp());
            pst.setString(10, objCargaHoraria.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objCargaHoraria;
    }

    public CargaHoraria excluirCargaHoraria(CargaHoraria objCargaHoraria) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM CARGAHORARIA WHERE IdCarga='" + objCargaHoraria.getIdCarga() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objCargaHoraria;
    }
}
