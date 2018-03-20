/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.Frequencia;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleFrequencia {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    Frequencia objFre = new Frequencia();

    public Frequencia incluirFrequencia(Frequencia objFre) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO FREQUENCIA (StatusFreq,DataFreq,IdMat,UsuarioInsert,DataInsert,HorarioInsert)VALUES(?,?,?,?,?,?)");
            pst.setString(1, objFre.getStatusFreq());
            pst.setTimestamp(2, new java.sql.Timestamp(objFre.getDataFreq().getTime()));
            pst.setInt(3, objFre.getIdMat());
            pst.setString(4, objFre.getUsuarioInsert());
            pst.setString(5, objFre.getDataInsert());
            pst.setString(6, objFre.getHorarioInsert());
            pst.execute(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objFre;
    }

    public Frequencia alterarFrequencia(Frequencia objFre) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE FREQUENCIA SET StatusFreq=?,DataFreq=?,IdMat=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdFreq='" + objFre.getIdFreq() + "'");
            pst.setString(1, objFre.getStatusFreq());
            pst.setTimestamp(2, new java.sql.Timestamp(objFre.getDataFreq().getTime()));
            pst.setInt(3, objFre.getIdMat());
            pst.setString(4, objFre.getUsuarioUp());
            pst.setString(5, objFre.getDataUp());
            pst.setString(6, objFre.getHorarioUp());
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objFre;
    }

    public Frequencia excluirFrequencia(Frequencia objFre) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM FREQUENCIA WHERE IdFreq='" + objFre.getIdFreq() + "'");
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objFre;
    }

    public Frequencia finalizarFrequencia(Frequencia objFre) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE FREQUENCIA SET StatusFreq=? WHERE IdFreq='" + objFre.getIdFreq() + "'");
            pst.setString(1, objFre.getStatusFreq());
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objFre;
    }
}
