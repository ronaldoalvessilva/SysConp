/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.*;
import gestor.Modelo.AdmissaoEnfermagem;
import gestor.Modelo.AvaliacaoPsicologica;
import gestor.Modelo.MovTecEnfermeira;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleMovAdmissaoEnfermeira {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    MovTecEnfermeira objMovTec = new MovTecEnfermeira();
    AdmissaoEnfermagem objAdmEnfermagem = new AdmissaoEnfermagem();
    String nomeOpeTecnica = "Atendimento do Interno na Enfermaria - (Admissão Enfermeira)";
    int codInt;

    // Incluir movimento da admissão enfermeira
    public AdmissaoEnfermagem incluirMovTec(AdmissaoEnfermagem objAdmEnfermagem) {
        buscarInternoCrc(objAdmEnfermagem.getNomeInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO MOVTECNICO (IdInternoCrc,IdAtend,NomeOpe,DataMov,DeptoMov,StatusAtend) VALUES(?,?,?,?,?,?)");
            pst.setInt(1, codInt);
            pst.setInt(2, objAdmEnfermagem.getIdLanc());
            pst.setString(3, nomeOpeTecnica);
            pst.setTimestamp(4, new java.sql.Timestamp(objAdmEnfermagem.getDataLanc().getTime()));
            pst.setString(5, objAdmEnfermagem.getDeptoMedico());
            pst.setString(6, objAdmEnfermagem.getStatusLanc());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAdmEnfermagem;
    }

    // Alterar movimento da admissão enfermeira
    public AdmissaoEnfermagem alterarMovTec(AdmissaoEnfermagem objAdmEnfermagem) {
        buscarInternoCrc(objAdmEnfermagem.getNomeInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE MOVTECNICO SET IdInternoCrc=?,IdAtend=?,NomeOpe=?,DataMov=?,DeptoMov=?,StatusAtend=? WHERE IdAtend='" + objAdmEnfermagem.getIdLanc() + "' AND NomeOpe='" + nomeOpeTecnica + "'");
            pst.setInt(1, codInt);
            pst.setInt(2, objAdmEnfermagem.getIdLanc());
            pst.setString(3, nomeOpeTecnica);
            pst.setTimestamp(4, new java.sql.Timestamp(objAdmEnfermagem.getDataLanc().getTime()));
            pst.setString(5, objAdmEnfermagem.getDeptoMedico());
            pst.setString(6, objAdmEnfermagem.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAdmEnfermagem;
    }

    public AdmissaoEnfermagem finalizarMovTec(AdmissaoEnfermagem objAdmEnfermagem) {
       
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE MOVTECNICO SET StatusAtend=? WHERE IdAtend='" + objAdmEnfermagem.getIdLanc() + "' AND NomeOpe='" + nomeOpeTecnica + "'");
            pst.setString(1, objAdmEnfermagem.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR na tabela MOVIMENTO TÉCNICO os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAdmEnfermagem;
    }

    // Excluir movimento do psicologico 
    public AdmissaoEnfermagem excluirMovTec(AdmissaoEnfermagem objAdmEnfermagem) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM MOVTECNICO WHERE IdAtend='" + objAdmEnfermagem.getIdLanc() + "' AND NomeOpe='" + nomeOpeTecnica + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAdmEnfermagem;
    }

    // Buscar o nome do interno
    public void buscarInternoCrc(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + desc + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNOS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
