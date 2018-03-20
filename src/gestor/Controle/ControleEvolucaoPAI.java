/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EvolucaoPAI;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleEvolucaoPAI {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EvolucaoPAI objEvolucaoPAI = new EvolucaoPAI();

    int codInterno;

    public EvolucaoPAI incluirEvolucaoPAI(EvolucaoPAI objEvolucaoPAI) {
        buscarInternoCrc(objEvolucaoPAI.getNomeInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO EVOLUCAO_PAI (DataEvolucao,IdPai,IdInternoCrc,TextoEvolucao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objEvolucaoPAI.getDataEvolucaoPAI().getTime()));
            pst.setInt(2, objEvolucaoPAI.getIdPai());
            pst.setInt(3, codInterno);
            pst.setString(4, objEvolucaoPAI.getTextoEvolucaoPAI());
            pst.setString(5, objEvolucaoPAI.getUsuarioInsert());
            pst.setString(6, objEvolucaoPAI.getDataInsert());
            pst.setString(7, objEvolucaoPAI.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEvolucaoPAI;
    }

    public EvolucaoPAI alterarEvolucaoPAI(EvolucaoPAI objEvolucaoPAI) {
        buscarInternoCrc(objEvolucaoPAI.getNomeInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE EVOLUCAO_PAI SET DataEvolucao=?,IdPai=?,IdInternoCrc=?,TextoEvolucao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdEvolucao='" + objEvolucaoPAI.getIdEvolucaoPAI() + "'AND IdPai='" + objEvolucaoPAI.getIdPai() + "'AND IdInternoCrc='" + objEvolucaoPAI.getIdInternoCrc() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objEvolucaoPAI.getDataEvolucaoPAI().getTime()));
            pst.setInt(2, objEvolucaoPAI.getIdPai());
            pst.setInt(3, codInterno);
            pst.setString(4, objEvolucaoPAI.getTextoEvolucaoPAI());
            pst.setString(5, objEvolucaoPAI.getUsuarioUp());
            pst.setString(6, objEvolucaoPAI.getDataUp());
            pst.setString(7, objEvolucaoPAI.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEvolucaoPAI;
    }

    public EvolucaoPAI excluirEvolucaoPAI(EvolucaoPAI objEvolucaoPAI) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM EVOLUCAO_PAI  WHERE IdEvolucao='" + objEvolucaoPAI.getIdEvolucaoPAI() + "'AND IdPai='" + objEvolucaoPAI.getIdPai() + "'AND IdInternoCrc='" + objEvolucaoPAI.getIdInternoCrc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEvolucaoPAI;
    }

    public void buscarInternoCrc(String nomeInterno) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + nomeInterno + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNOS) a ser exibido !!!\nERRO: " + e);
        }
        conecta.desconecta();
    }
}
