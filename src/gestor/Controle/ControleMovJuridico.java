/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AtendimentoJuridico;
import gestor.Modelo.MovTecJuridico;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleMovJuridico {
    ConexaoBancoDados conecta = new ConexaoBancoDados();
    MovTecJuridico objMovTec = new MovTecJuridico() ;
    AtendimentoJuridico objAtendJuri = new AtendimentoJuridico();
    String nomeOpeTecnica = "Atendimento do Interno no Juridico";
    int codInt;
    // Incluir movimento do serviço social
    public AtendimentoJuridico incluirMovTec(AtendimentoJuridico objAtendJuri) {
        buscarInternoCrc(objAtendJuri.getNomeInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO MOVTECNICO (IdInternoCrc,IdAtend,NomeOpe,DataMov,DeptoMov,StatusAtend) VALUES(?,?,?,?,?,?)");
            pst.setInt(1, codInt);
            pst.setInt(2, objAtendJuri.getIdLanc());
            pst.setString(3, nomeOpeTecnica);
            pst.setTimestamp(4, new java.sql.Timestamp(objAtendJuri.getDataLanc().getTime()));
            pst.setString(5, objAtendJuri.getDeptoJuridico());
            pst.setString(6, objAtendJuri.getStatusLanc());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAtendJuri;
    }

    // Alterar movimento do serviço social 
    public AtendimentoJuridico alterarMovTec(AtendimentoJuridico objAtendJuri) {
        buscarInternoCrc(objAtendJuri.getNomeInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE MOVTECNICO SET IdInternoCrc=?,IdAtend=?,NomeOpe=?,DataMov=?,DeptoMov=?,StatusAtend=? WHERE IdAtend='" + objAtendJuri.getIdLanc() + "' AND NomeOpe='" + nomeOpeTecnica + "'");
            pst.setInt(1, codInt);
            pst.setInt(2, objAtendJuri.getIdLanc());
            pst.setString(3, nomeOpeTecnica);
            pst.setTimestamp(4, new java.sql.Timestamp(objAtendJuri.getDataLanc().getTime()));
            pst.setString(5, objAtendJuri.getDeptoJuridico());
            pst.setString(6, objAtendJuri.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAtendJuri;
    }

    public AtendimentoJuridico finalizarMovTec(AtendimentoJuridico objAtendJuri) {
       
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE MOVTECNICO SET StatusAtend=? WHERE IdAtend='" + objAtendJuri.getIdLanc() + "' AND NomeOpe='" + nomeOpeTecnica + "'");
            pst.setString(1, objAtendJuri.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR na tabela MOVIMENTO TÉCNICO os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAtendJuri;
    }

    // Excluir movimento do serviço social 
    public AtendimentoJuridico excluirMovTec(AtendimentoJuridico objAtendJuri) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM MOVTECNICO WHERE IdAtend='" + objAtendJuri.getIdLanc() + "' AND NomeOpe='" + nomeOpeTecnica + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAtendJuri;
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
