/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EncaminhamentoCirurgiasEspecialistas;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleEncaminhaInternos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EncaminhamentoCirurgiasEspecialistas objEncaCir = new EncaminhamentoCirurgiasEspecialistas();

    int codInterno;

    public EncaminhamentoCirurgiasEspecialistas incluirEncaminhamento(EncaminhamentoCirurgiasEspecialistas objEncaCir) {
        buscarInterno(objEncaCir.getNomeInternoCrc(), objEncaCir.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ENCAMINHAMENTO_CIRURGIAS_ESPECIALISTAS (StatusEnca,DataEnca,IdInternoCrc,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES (?,?,?,?,?,?,?)");
            pst.setString(1, objEncaCir.getStatusEnca());
            pst.setTimestamp(2, new java.sql.Timestamp(objEncaCir.getDataEnca().getTime()));
            pst.setInt(3, codInterno);
            pst.setString(4, objEncaCir.getObservacao());
            pst.setString(5, objEncaCir.getUsuarioInsert());
            pst.setString(6, objEncaCir.getDataInsert());
            pst.setString(7, objEncaCir.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEncaCir;
    }

    public EncaminhamentoCirurgiasEspecialistas alterarEncaminhamento(EncaminhamentoCirurgiasEspecialistas objEncaCir) {
        buscarInterno(objEncaCir.getNomeInternoCrc(), objEncaCir.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENCAMINHAMENTO_CIRURGIAS_ESPECIALISTAS SET StatusEnca=?,DataEnca=?,IdInternoCrc=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdEnca='" + objEncaCir.getIdEnca() + "'");
            pst.setString(1, objEncaCir.getStatusEnca());
            pst.setTimestamp(2, new java.sql.Timestamp(objEncaCir.getDataEnca().getTime()));
            pst.setInt(3, codInterno);
            pst.setString(4, objEncaCir.getObservacao());
            pst.setString(5, objEncaCir.getUsuarioUp());
            pst.setString(6, objEncaCir.getDataUp());
            pst.setString(7, objEncaCir.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEncaCir;
    }

    public EncaminhamentoCirurgiasEspecialistas excluirEncaminhamento(EncaminhamentoCirurgiasEspecialistas objEncaCir) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ENCAMINHAMENTO_CIRURGIAS_ESPECIALISTAS WHERE IdEnca='" + objEncaCir.getIdEnca() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEncaCir;
    }

    public EncaminhamentoCirurgiasEspecialistas finalizarEncaminhamento(EncaminhamentoCirurgiasEspecialistas objEncaCir) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENCAMINHAMENTO_CIRURGIAS_ESPECIALISTAS SET StatusEnca=? WHERE IdEnca='" + objEncaCir.getIdEnca() + "'");
            pst.setString(1, objEncaCir.getStatusEnca());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEncaCir;
    }

    public void buscarInterno(String desc, int cod) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + desc + "' "
                    + "AND IdInternoCrc='" + cod + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível pesquisar o interno.\nERRO: " + ex);
        }
    }
}
