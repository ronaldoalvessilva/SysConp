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
public class ControleSaldoSaqueInativos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ConsultaSaldoInternos objSaldo = new ConsultaSaldoInternos();

    public ConsultaSaldoInternos incluirSaldo(ConsultaSaldoInternos objSaldo) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO SALDO_VALORES_INATIVOS (DataMov,IdInternoCrc,IdDoc,Historico,FavorecidoDepositante,TipoMov,ValorMov,SaldoAtual) VALUES(?,?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objSaldo.getDataMov().getTime()));
            pst.setInt(2, objSaldo.getIdInternoCrc());
            pst.setInt(3, objSaldo.getIdLanc());
            pst.setString(4, objSaldo.getHistorico());
            pst.setString(5, objSaldo.getFavorecidoDepositante());
            pst.setString(6, objSaldo.getStatusMov());
            pst.setDouble(7, objSaldo.getSaldo());
            pst.setDouble(8, objSaldo.getSaldoAtual());
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
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE SALDO_VALORES_INATIVOS SET DataMov=?,IdInternoCrc=?,IdDoc=?,Historico=?,FavorecidoDepositante=?,TipoMov=?,ValorMov=?,SaldoAtual=? WHERE IdDoc='" + objSaldo.getIdLanc() + "'AND TipoMov='" + objSaldo.getStatusMov() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objSaldo.getDataMov().getTime()));
            pst.setInt(2, objSaldo.getIdInternoCrc());
            pst.setInt(3, objSaldo.getIdLanc());
            pst.setString(4, objSaldo.getHistorico());
            pst.setString(5, objSaldo.getFavorecidoDepositante());
            pst.setString(6, objSaldo.getStatusMov());
            pst.setDouble(7, objSaldo.getSaldo());
            pst.setDouble(8, objSaldo.getSaldoAtual());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSaldo;
    }

    public ConsultaSaldoInternos excluirSaldo(ConsultaSaldoInternos objSaldo) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM SALDO_VALORES_INATIVOS WHERE IdSaldoAtual='" + objSaldo.getIdLanc() + "'AND TipoMov='" + objSaldo.getStatusMov() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSaldo;
    }
}
