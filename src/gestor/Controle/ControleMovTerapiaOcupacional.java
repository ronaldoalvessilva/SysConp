/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AtendimentoTerapeuta;
import gestor.Modelo.MovTecnicoTerapia;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleMovTerapiaOcupacional {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    MovTecnicoTerapia objMovTec = new MovTecnicoTerapia();
    AtendimentoTerapeuta objAtend = new AtendimentoTerapeuta();
    String nomeOpeTecnica = "Atendimento na Terapia Ocupacional";
    int codInt;

    // Incluir movimento do serviço social
    public AtendimentoTerapeuta incluirMovTec(AtendimentoTerapeuta objAtend) {
        buscarInternoCrc(objAtend.getNomeInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO MOVTECNICO (IdInternoCrc,IdAtend,NomeOpe,DataMov,DeptoMov,StatusAtend) VALUES(?,?,?,?,?,?)");
            pst.setInt(1, codInt);
            pst.setInt(2, objAtend.getIdLanc());
            pst.setString(3, nomeOpeTecnica);
            pst.setTimestamp(4, new java.sql.Timestamp(objAtend.getDataLanc().getTime()));
            pst.setString(5, objAtend.getDeptoTerapia());
            pst.setString(6, objAtend.getStatusLanc());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAtend;
    }

    // Alterar movimento da terapia ocupacional
    public AtendimentoTerapeuta alterarMovTec(AtendimentoTerapeuta objAtend) {
        buscarInternoCrc(objAtend.getNomeInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE MOVTECNICO SET IdInternoCrc=?,IdAtend=?,NomeOpe=?,DataMov=?,DeptoMov=?,StatusAtend=? WHERE IdAtend='" + objAtend.getIdLanc() + "' AND NomeOpe='" + nomeOpeTecnica + "'");
            pst.setInt(1, codInt);
            pst.setInt(2, objAtend.getIdLanc());
            pst.setString(3, nomeOpeTecnica);
            pst.setTimestamp(4, new java.sql.Timestamp(objAtend.getDataLanc().getTime()));
            pst.setString(5, objAtend.getDeptoTerapia());
            pst.setString(6, objAtend.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAtend;
    }

    public AtendimentoTerapeuta finalizarMovTec(AtendimentoTerapeuta objAtend) {
       
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE MOVTECNICO SET StatusAtend=? WHERE IdAtend='" + objAtend.getIdLanc()+ "' AND NomeOpe='" + nomeOpeTecnica + "'");
            pst.setString(1, objAtend.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR na tabela MOVIMENTO TÉCNICO os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAtend;
    }

    // Excluir movimento da terapia ocupacional
    public AtendimentoTerapeuta excluirMovTec(AtendimentoTerapeuta objAtend) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM MOVTECNICO WHERE IdAtend='" + objAtend.getIdLanc()+ "' AND NomeOpe='" + nomeOpeTecnica + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAtend;
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
