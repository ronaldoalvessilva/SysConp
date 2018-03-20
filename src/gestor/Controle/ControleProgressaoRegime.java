/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ProgressaoRegime;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleProgressaoRegime {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ProgressaoRegime objProgresRegime = new ProgressaoRegime();

    public ProgressaoRegime incluirProgressaoRegime(ProgressaoRegime objProgresRegime) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO PROGRESSAOREGIME (StatusLanc,TipoMudanca,DataLanc,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");
            pst.setString(1, objProgresRegime.getStatusLanc());
            pst.setString(2, objProgresRegime.getTipoMudanca());
            pst.setTimestamp(3, new java.sql.Timestamp(objProgresRegime.getDataLanc().getTime()));
            pst.setString(4, objProgresRegime.getObservacao());
            pst.setString(5, objProgresRegime.getUsuarioInsert());
            pst.setString(6, objProgresRegime.getDataInsert());
            pst.setString(7, objProgresRegime.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objProgresRegime;
    }

    public ProgressaoRegime alterarProgressaoRegime(ProgressaoRegime objProgresRegime) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PROGRESSAOREGIME SET StatusLanc=?,TipoMudanca=?,DataLanc=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdLanc='" + objProgresRegime.getIdLanc() + "'");
            pst.setString(1, objProgresRegime.getStatusLanc());
            pst.setString(2, objProgresRegime.getTipoMudanca());
            pst.setTimestamp(3, new java.sql.Timestamp(objProgresRegime.getDataLanc().getTime()));
            pst.setString(4, objProgresRegime.getObservacao());
            pst.setString(5, objProgresRegime.getUsuarioUp());
            pst.setString(6, objProgresRegime.getDataUp());
            pst.setString(7, objProgresRegime.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objProgresRegime;
    }

    public ProgressaoRegime excluirProgressaoRegime(ProgressaoRegime objProgresRegime) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM PROGRESSAOREGIME WHERE IdLanc='" + objProgresRegime.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objProgresRegime;
    }

    public ProgressaoRegime finalizarProgressaoRegime(ProgressaoRegime objProgresRegime) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PROGRESSAOREGIME SET StatusLanc=? WHERE IdLanc='" + objProgresRegime.getIdLanc() + "'");
            pst.setString(1, objProgresRegime.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objProgresRegime;
    }
}
