/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.*;
import gestor.Modelo.TransferenciaInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleTransfInternos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    TransferenciaInternos objTransf = new TransferenciaInternos();
    int codOpe;

    public TransferenciaInternos incluirTransfInternos(TransferenciaInternos objTransf) {
        buscarOperacao(objTransf.getNomeOperacao());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO TRANSFERENCIACRC (ObsTransf,StatusTran,IdOp,DataLancTransf,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");
            pst.setString(1, objTransf.getObsTrans());
            pst.setString(2, objTransf.getStatusTransf());
            pst.setInt(3, codOpe);
            pst.setTimestamp(4, new java.sql.Timestamp(objTransf.getDatalancamento().getTime()));
            pst.setString(5, objTransf.getUsuarioInsert());
            pst.setString(6, objTransf.getDataInsert());
            pst.setString(7, objTransf.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objTransf;

    }

    // Alterar os dados da capa de transferência
    public TransferenciaInternos alterarTransfInternos(TransferenciaInternos objTransf) {
        buscarOperacao(objTransf.getNomeOperacao());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE TRANSFERENCIACRC SET ObsTransf=?,StatusTran=?,IdOp=?,DataLancTransf=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE Idtransf='" + objTransf.getIdTrans() + "'");
            pst.setString(1, objTransf.getObsTrans());
            pst.setString(2, objTransf.getStatusTransf());
            pst.setInt(3, codOpe);
            pst.setTimestamp(4, new java.sql.Timestamp(objTransf.getDatalancamento().getTime()));
            pst.setString(5, objTransf.getUsuarioUp());
            pst.setString(6, objTransf.getDataUp());
            pst.setString(7, objTransf.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objTransf;

    }

    //Método para excluir ENTRADAS    
    public TransferenciaInternos excluirTransfInternos(TransferenciaInternos objTransf) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst;
            pst = conecta.con.prepareStatement("DELETE FROM TRANSFERENCIACRC WHERE IdTransf='" + objTransf.getIdTrans() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\n ERRO\n" + ex);
        }
        conecta.desconecta();
        return objTransf;
    }

    public TransferenciaInternos finalizarTransfInternos(TransferenciaInternos objTransf) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst;
            pst = conecta.con.prepareStatement("UPDATE TRANSFERENCIACRC SET StatusTran=? WHERE IdTransf='" + objTransf.getIdTrans() + "'");
            pst.setString(1, objTransf.getStatusTransf());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados\n\n ERRO\n" + ex);
        }
        conecta.desconecta();
        return objTransf;
    }

    public void buscarOperacao(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM OPERACAO WHERE DescricaoOp='" + nome + "'");
            conecta.rs.first();
            codOpe = conecta.rs.getInt("IdOp");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (OPERAÇÃO) a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
