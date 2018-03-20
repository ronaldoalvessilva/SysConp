/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.*;
import gestor.Modelo.AvaliacaoPsicologica;
import gestor.Modelo.MovTecPsicologia;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleMovPsicologiaAvaliacao {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    MovTecPsicologia objMovTec = new MovTecPsicologia();
    AvaliacaoPsicologica objAvaPsi = new AvaliacaoPsicologica();
    String nomeOpeTecnica = "Atendimento do Interno na Psicologia - (Avaliação)";
    int codInt;

    // Incluir movimento do psicologico
    public AvaliacaoPsicologica incluirMovTec(AvaliacaoPsicologica objAvaPsi) {
        buscarInternoCrc(objAvaPsi.getNomeInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO MOVTECNICO (IdInternoCrc,IdAtend,NomeOpe,DataMov,DeptoMov,StatusAtend) VALUES(?,?,?,?,?,?)");
            pst.setInt(1, codInt);
            pst.setInt(2, objAvaPsi.getIdLanc());
            pst.setString(3, nomeOpeTecnica);
            pst.setTimestamp(4, new java.sql.Timestamp(objAvaPsi.getDataLanc().getTime()));
            pst.setString(5, objAvaPsi.getDeptoPsicologico());
            pst.setString(6, objAvaPsi.getStatusLanc());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAvaPsi;
    }

    // Alterar movimento do psicologico
    public AvaliacaoPsicologica alterarMovTec(AvaliacaoPsicologica objAvaPsi) {
        buscarInternoCrc(objAvaPsi.getNomeInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE MOVTECNICO SET IdInternoCrc=?,IdAtend=?,NomeOpe=?,DataMov=?,DeptoMov=?,StatusAtend=? WHERE IdAtend='" + objAvaPsi.getIdLanc() + "' AND NomeOpe='" + nomeOpeTecnica + "'");
            pst.setInt(1, codInt);
            pst.setInt(2, objAvaPsi.getIdLanc());
            pst.setString(3, nomeOpeTecnica);
            pst.setTimestamp(4, new java.sql.Timestamp(objAvaPsi.getDataLanc().getTime()));
            pst.setString(5, objAvaPsi.getDeptoPsicologico());
            pst.setString(6, objAvaPsi.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAvaPsi;
    }

    public AvaliacaoPsicologica finalizarMovTec(AvaliacaoPsicologica objAvaPsi) {
       
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE MOVTECNICO SET StatusAtend=? WHERE IdAtend='" + objAvaPsi.getIdLanc() + "' AND NomeOpe='" + nomeOpeTecnica + "'");
            pst.setString(1, objAvaPsi.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR na tabela MOVIMENTO TÉCNICO os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAvaPsi;
    }

    // Excluir movimento do psicologico 
    public AvaliacaoPsicologica excluirMovTec(AvaliacaoPsicologica objAdmPsi) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM MOVTECNICO WHERE IdAtend='" + objAdmPsi.getIdLanc() + "' AND NomeOpe='" + nomeOpeTecnica + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAdmPsi;
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
