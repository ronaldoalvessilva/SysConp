/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EvolucaoTecEnfrmagem;
import gestor.Modelo.MovTecEvolucaoTecEnfermagem;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleMovEvolucaoTecEnfermagem {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    MovTecEvolucaoTecEnfermagem objModTecEM = new MovTecEvolucaoTecEnfermagem();
    EvolucaoTecEnfrmagem objEvoTecEnf = new EvolucaoTecEnfrmagem();
    String nomeOpeTecnica = "Atendimento do Interno na Enfermaria - (Evolução Téc. Enfermagem)";
    int codInt;

    // Incluir movimento do serviço social
    public EvolucaoTecEnfrmagem incluirMovTecEnfEvol(EvolucaoTecEnfrmagem objEvoTecEnf) {
        buscarInternoCrc(objEvoTecEnf.getNomeInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO MOVTECNICO (IdInternoCrc,IdAtend,NomeOpe,DataMov,DeptoMov,StatusAtend) VALUES(?,?,?,?,?,?)");
            pst.setInt(1, codInt);
            pst.setInt(2, objEvoTecEnf.getIdLanc());
            pst.setString(3, nomeOpeTecnica);
            pst.setTimestamp(4, new java.sql.Timestamp(objEvoTecEnf.getDataEvol().getTime()));
            pst.setString(5, objEvoTecEnf.getDeptoMedico());
            pst.setString(6, objEvoTecEnf.getStatusLanc());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEvoTecEnf;
    }

    // Alterar movimento do serviço social 
    public EvolucaoTecEnfrmagem alterarMovTecEnfEvol(EvolucaoTecEnfrmagem objEvoTecEnf) {
        buscarInternoCrc(objEvoTecEnf.getNomeInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE MOVTECNICO SET IdInternoCrc=?,IdAtend=?,NomeOpe=?,DataMov=?,DeptoMov=?,StatusAtend=? WHERE IdAtend='" + objEvoTecEnf.getIdLanc() + "' AND NomeOpe='" + nomeOpeTecnica + "'");
            pst.setInt(1, codInt);
            pst.setInt(2, objEvoTecEnf.getIdLanc());
            pst.setString(3, nomeOpeTecnica);
            pst.setTimestamp(4, new java.sql.Timestamp(objEvoTecEnf.getDataEvol().getTime()));
            pst.setString(5, objEvoTecEnf.getDeptoMedico());
            pst.setString(6, objEvoTecEnf.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEvoTecEnf;
    }

    public EvolucaoTecEnfrmagem finalizarMovTecEnfEvol(EvolucaoTecEnfrmagem objEvoTecEnf) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE MOVTECNICO SET StatusAtend=? WHERE IdAtend='" + objEvoTecEnf.getIdLanc() + "' AND NomeOpe='" + nomeOpeTecnica + "'");
            pst.setString(1, objEvoTecEnf.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR na tabela MOVIMENTO TÉCNICO os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEvoTecEnf;
    }

    // Excluir movimento do serviço social 
    public EvolucaoTecEnfrmagem excluirMovTecEnfEvol(EvolucaoTecEnfrmagem objEvoTecEnf) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM MOVTECNICO WHERE IdAtend='" + objEvoTecEnf.getIdLanc() + "' AND NomeOpe='" + nomeOpeTecnica + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEvoTecEnf;
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
