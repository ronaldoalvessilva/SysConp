/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EvolucaoEnfermagem;
import gestor.Modelo.MovTecEvolucaoEnfermagem;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleMovEvolucaoEnfermagem {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    MovTecEvolucaoEnfermagem objModTecEM = new MovTecEvolucaoEnfermagem();
    EvolucaoEnfermagem objEvolEnferma = new EvolucaoEnfermagem();
    String nomeOpeTecnica = "Atendimento do Interno na Enfermaria - (Evolução Enfermagem)";

    public EvolucaoEnfermagem incluirMovTecEnf(EvolucaoEnfermagem objEvolEnferma) {
      
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO MOVTECNICO (IdInternoCrc,IdAtend,NomeOpe,DataMov,DeptoMov,StatusAtend) VALUES(?,?,?,?,?,?)");
            pst.setInt(1, objEvolEnferma.getIdInternoCrc());
            pst.setInt(2, objEvolEnferma.getIdLanc());
            pst.setString(3, nomeOpeTecnica);
            pst.setTimestamp(4, new java.sql.Timestamp(objEvolEnferma.getDataEvol().getTime()));
            pst.setString(5, objEvolEnferma.getDeptoMedico());
            pst.setString(6, objEvolEnferma.getStatusLanc());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEvolEnferma;
    }

    // Alterar movimento do serviço social 
    public EvolucaoEnfermagem alterarMovTecEnf(EvolucaoEnfermagem objEvolEnferma) {
      
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE MOVTECNICO SET IdInternoCrc=?,IdAtend=?,NomeOpe=?,DataMov=?,DeptoMov=?,StatusAtend=? WHERE IdAtend='" + objEvolEnferma.getIdLanc() + "' AND NomeOpe='" + nomeOpeTecnica + "'");
            pst.setInt(1, objEvolEnferma.getIdInternoCrc());
            pst.setInt(2, objEvolEnferma.getIdLanc());
            pst.setString(3, nomeOpeTecnica);
            pst.setTimestamp(4, new java.sql.Timestamp(objEvolEnferma.getDataEvol().getTime()));
            pst.setString(5, objEvolEnferma.getDeptoMedico());
            pst.setString(6, objEvolEnferma.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEvolEnferma;
    }

    public EvolucaoEnfermagem finalizarMovTecEnf(EvolucaoEnfermagem objEvolEnferma) {
     
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE MOVTECNICO SET StatusAtend=? WHERE IdAtend='" + objEvolEnferma.getIdLanc() + "' AND NomeOpe='" + nomeOpeTecnica + "'");
            pst.setString(1, objEvolEnferma.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR na tabela MOVIMENTO TÉCNICO os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEvolEnferma;
    }

    // Excluir movimento do serviço social 
    public EvolucaoEnfermagem  excluirMovTecEnf(EvolucaoEnfermagem objEvolEnferma) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM MOVTECNICO WHERE IdAtend='" + objEvolEnferma.getIdLanc() + "' AND NomeOpe='" + nomeOpeTecnica + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEvolEnferma;
    }

//    // Buscar o nome do interno
//    public void buscarInternoCrc(String desc) {
//        conecta.abrirConexao();
//        try {
//            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + desc + "'");
//            conecta.rs.first();
//            codInt = conecta.rs.getInt("IdInternoCrc");
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNOS) a ser exibido !!!" + e);
//        }
//        conecta.desconecta();
//    }
}
