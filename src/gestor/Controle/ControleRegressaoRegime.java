/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.RegressaoRegime;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleRegressaoRegime {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    RegressaoRegime objRegRegime = new RegressaoRegime();

    public RegressaoRegime incluirRegressaoRegime(RegressaoRegime objRegRegime) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO REGRESSAOREGIME (StatusLanc,TipoMudanca,DataLanc,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");
            pst.setString(1, objRegRegime.getStatusLanc());
            pst.setString(2, objRegRegime.getTipoMudanca());
            pst.setTimestamp(3, new java.sql.Timestamp(objRegRegime.getDataLanc().getTime()));
            pst.setString(4, objRegRegime.getObservacao());
            pst.setString(5, objRegRegime.getUsuarioInsert());
            pst.setString(6, objRegRegime.getDataInsert());
            pst.setString(7, objRegRegime.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objRegRegime;
    }

    public RegressaoRegime alterarRegressaoRegime(RegressaoRegime obRegRegime) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REGRESSAOREGIME SET StatusLanc=?,TipoMudanca=?,DataLanc=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdLanc='" + obRegRegime.getIdLanc() + "'");
            pst.setString(1, obRegRegime.getStatusLanc());
            pst.setString(2, obRegRegime.getTipoMudanca());
            pst.setTimestamp(3, new java.sql.Timestamp(obRegRegime.getDataLanc().getTime()));
            pst.setString(4, obRegRegime.getObservacao());
            pst.setString(5, obRegRegime.getUsuarioUp());
            pst.setString(6, obRegRegime.getDataUp());
            pst.setString(7, obRegRegime.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return obRegRegime;
    }

    public RegressaoRegime excluirRegressaoRegime(RegressaoRegime obRegRegime) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM REGRESSAOREGIME WHERE IdLanc='" + obRegRegime.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return obRegRegime;
    }

    public RegressaoRegime finalizarRegressaoRegime(RegressaoRegime objRegRegime) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REGRESSAOREGIME SET StatusLanc=? WHERE IdLanc='" + objRegRegime.getIdLanc() + "'");
            pst.setString(1, objRegRegime.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objRegRegime;
    }
}
