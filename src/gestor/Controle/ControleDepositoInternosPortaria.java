/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.DepositoPortaria;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleDepositoInternosPortaria {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    DepositoPortaria objDepoPort = new DepositoPortaria();

    public DepositoPortaria incluirDepositoPortaria(DepositoPortaria objDepoPort) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO DEPOSITOPORTARIA (StatusLanc,DataLanc,NomeDepositante,Observacao,OrigemDeposito,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?)");
            pst.setString(1, objDepoPort.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objDepoPort.getDataLanc().getTime()));
            pst.setString(3, objDepoPort.getNomeDepositante());
            pst.setString(4, objDepoPort.getObservacao());
            pst.setString(5, objDepoPort.getOrigemDeposito());
            pst.setString(6, objDepoPort.getUsuarioInsert());
            pst.setString(7, objDepoPort.getDataInsert());
            pst.setString(8, objDepoPort.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objDepoPort;
    }

    public DepositoPortaria alterarDepositoPortaria(DepositoPortaria objDepoPort) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE DEPOSITOPORTARIA SET StatusLanc=?,DataLanc=?,NomeDepositante=?,Observacao=?,OrigemDeposito=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdLanc='" + objDepoPort.getIdLanc() + "'");
            pst.setString(1, objDepoPort.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objDepoPort.getDataLanc().getTime()));
            pst.setString(3, objDepoPort.getNomeDepositante());
            pst.setString(4, objDepoPort.getObservacao());
            pst.setString(5, objDepoPort.getOrigemDeposito());
            pst.setString(6, objDepoPort.getUsuarioUp());
            pst.setString(7, objDepoPort.getDataUp());
            pst.setString(8, objDepoPort.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objDepoPort;
    }

    public DepositoPortaria excluirDepositoPortaria(DepositoPortaria objDepoPort) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM DEPOSITOPORTARIA WHERE IdLanc='" + objDepoPort.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objDepoPort;
    }

    public DepositoPortaria finalizarDepositoPortaria(DepositoPortaria objDepoPort) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE DEPOSITOPORTARIA SET StatusLanc=? WHERE IdLanc='" + objDepoPort.getIdLanc() + "'");
            pst.setString(1, objDepoPort.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objDepoPort;
    }
}
