/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.BaixaInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleBaixaInternos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    BaixaInternos objBaixa = new BaixaInternos();

    public BaixaInternos incluirBaixaInternos(BaixaInternos objBaixa) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO BAIXAINTERNOS (StatusLanc,DataLanc,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?)");
            pst.setString(1, objBaixa.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objBaixa.getDataLanc().getTime()));
            pst.setString(3, objBaixa.getObservacao());
            pst.setString(4, objBaixa.getUsuarioInsert());
            pst.setString(5, objBaixa.getDataInsert());
            pst.setString(6, objBaixa.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objBaixa;
    }

    public BaixaInternos alterarBaixaInternos(BaixaInternos objBaixa) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE BAIXAINTERNOS SET StatusLanc=?,DataLanc=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdLanc='" + objBaixa.getIdLanc() + "'");
            pst.setString(1, objBaixa.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objBaixa.getDataLanc().getTime()));
            pst.setString(3, objBaixa.getObservacao());
            pst.setString(4, objBaixa.getUsuarioUp());
            pst.setString(5, objBaixa.getDataUp());
            pst.setString(6, objBaixa.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objBaixa;
    }

    public BaixaInternos excluirBaixaInternos(BaixaInternos objBaixa) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM BAIXAINTERNOS WHERE IdLanc='" + objBaixa.getIdLanc() + "'");           
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objBaixa;
    }

    public BaixaInternos FinalizarBaixaInternos(BaixaInternos objBaixa) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE BAIXAINTERNOS SET StatusLanc=? WHERE IdLanc='" + objBaixa.getIdLanc() + "'");
            pst.setString(1, objBaixa.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objBaixa;
    }
}
