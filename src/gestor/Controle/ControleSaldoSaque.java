/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ConsultaSaldoInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleSaldoSaque {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ConsultaSaldoInternos objSaldo = new ConsultaSaldoInternos();

    public ConsultaSaldoInternos incluirSaldo(ConsultaSaldoInternos objSaldo) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO SALDOVALORES (IdInternoCrc,IdLanc,Historico,FavorecidoDepositante,ValorMov,StatusMov,DataMov) VALUES(?,?,?,?,?,?,?)");
            pst.setInt(1, objSaldo.getIdInternoCrc());
            pst.setInt(2, objSaldo.getIdLanc());
            pst.setString(3, objSaldo.getHistorico());
            pst.setString(4, objSaldo.getFavorecidoDepositante());
            pst.setFloat(5, objSaldo.getSaldo());
            pst.setString(6, objSaldo.getStatusMov());
            pst.setTimestamp(7, new java.sql.Timestamp(objSaldo.getDataMov().getTime()));
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSaldo;
    }

    public ConsultaSaldoInternos alterarSaldo(ConsultaSaldoInternos objSaldo) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE SALDOVALORES SET IdInternoCrc=?,IdLanc=?,Historico=?,FavorecidoDepositante=?,ValorMov=?,StatusMov=?,DataMov=? WHERE IdLanc='" + objSaldo.getIdLanc() + "'AND StatusMov='" + objSaldo.getStatusMov() + "'");
            pst.setInt(1, objSaldo.getIdInternoCrc());
            pst.setInt(2, objSaldo.getIdLanc());
            pst.setString(3, objSaldo.getHistorico());
            pst.setString(4, objSaldo.getFavorecidoDepositante());
            pst.setFloat(5, objSaldo.getSaldo());
            pst.setString(6, objSaldo.getStatusMov());
            pst.setTimestamp(7, new java.sql.Timestamp(objSaldo.getDataMov().getTime()));
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objSaldo;
    }

    public ConsultaSaldoInternos excluirSaldo(ConsultaSaldoInternos objSaldo) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM SALDOVALORES WHERE IdLanc='" + objSaldo.getIdLanc()+ "'AND StatusMov='" + objSaldo.getStatusMov() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objSaldo;
    }
}
