/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.Transientes;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleTransientes {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    Transientes objTransi = new Transientes();

    public Transientes incluirTransientes(Transientes objTransi) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO TRANSIENTES (StatusTrans,DataTrans,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?)");
            pst.setString(1, objTransi.getStatusTrans());
            pst.setTimestamp(2, new java.sql.Timestamp(objTransi.getDataTrans().getTime()));
            pst.setString(3, objTransi.getObservacao());
            pst.setString(4, objTransi.getUsuarioInsert());
            pst.setString(5, objTransi.getDataInsert());
            pst.setString(6, objTransi.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objTransi;
    }

    public Transientes alterarTransientes(Transientes objTransi) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE TRANSIENTES SET StatusTrans=?,DataTrans=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdTrans='" + objTransi.getIdTrans() + "'");
            pst.setString(1, objTransi.getStatusTrans());
            pst.setTimestamp(2, new java.sql.Timestamp(objTransi.getDataTrans().getTime()));
            pst.setString(3, objTransi.getObservacao());
            pst.setString(4, objTransi.getUsuarioUp());
            pst.setString(5, objTransi.getDataUp());
            pst.setString(6, objTransi.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objTransi;
    }

    public Transientes excluirTransientes(Transientes objTransi) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM TRANSIENTES WHERE IdTrans='" + objTransi.getIdTrans() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objTransi;
    }

    public Transientes finalizarTransientes(Transientes objTransi) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE TRANSIENTES SET StatusTrans=? WHERE IdTrans='" + objTransi.getIdTrans() + "'");
            pst.setString(1, objTransi.getStatusTrans());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível FINALIZAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objTransi;
    }
}
