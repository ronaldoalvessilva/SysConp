/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ValeTransporte;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleValeTransporte {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ValeTransporte objValeTransporte = new ValeTransporte();

    public ValeTransporte incluirValeTransporte(ValeTransporte objValeTransporte) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO VALETRANSPORTE (StatusLanc,DataLanc,MesReferencia,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");
            pst.setString(1, objValeTransporte.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objValeTransporte.getDataLanc().getTime()));
            pst.setString(3, objValeTransporte.getMesReferencia());
            pst.setString(4, objValeTransporte.getObservacao());
            pst.setString(5, objValeTransporte.getUsuarioInsert());
            pst.setString(6, objValeTransporte.getDataInsert());
            pst.setString(7, objValeTransporte.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objValeTransporte;
    }

    public ValeTransporte alterarValeTransporte(ValeTransporte objValeTransporte) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE VALETRANSPORTE SET StatusLanc=?,DataLanc=?,MesReferencia=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdLanc='" + objValeTransporte.getIdLanc() + "'");
            pst.setString(1, objValeTransporte.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objValeTransporte.getDataLanc().getTime()));
            pst.setString(3, objValeTransporte.getMesReferencia());
            pst.setString(4, objValeTransporte.getObservacao());
            pst.setString(5, objValeTransporte.getUsuarioInsert());
            pst.setString(6, objValeTransporte.getDataInsert());
            pst.setString(7, objValeTransporte.getHorarioInsert());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objValeTransporte;
    }
    public ValeTransporte excluirValeTransporte(ValeTransporte objValeTransporte) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM VALETRANSPORTE WHERE IdLanc='" + objValeTransporte.getIdLanc() + "'");           
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objValeTransporte;
    }
}
