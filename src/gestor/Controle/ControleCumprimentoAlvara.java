/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.CumprimentoAlvara;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleCumprimentoAlvara {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    CumprimentoAlvara objCumpreAlvara = new CumprimentoAlvara();

    int codInterno;

    public CumprimentoAlvara incluirCumprimentoAlvara(CumprimentoAlvara objCumpreAlvara) {
        buscarInterno(objCumpreAlvara.getNomeInternoCrc(), objCumpreAlvara.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO CUMPRIMENTOALVARA (StatusLanc,DataLanc,IdInternoCrc,Historico,TipoCumprimento,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?)");
            pst.setString(1, objCumpreAlvara.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objCumpreAlvara.getDataLanc().getTime()));
            pst.setInt(3, codInterno);
            pst.setString(4, objCumpreAlvara.getHistorico());
            pst.setInt(5, objCumpreAlvara.getTipoCumprimento());
            pst.setString(6, objCumpreAlvara.getUsuarioInsert());
            pst.setString(7, objCumpreAlvara.getDataInsert());
            pst.setString(8, objCumpreAlvara.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objCumpreAlvara;
    }

    public CumprimentoAlvara alterarCumprimentoAlvara(CumprimentoAlvara objCumpreAlvara) {
         buscarInterno(objCumpreAlvara.getNomeInternoCrc(), objCumpreAlvara.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE CUMPRIMENTOALVARA SET StatusLanc=?,DataLanc=?,IdInternoCrc=?,Historico=?,TipoCumprimento=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdLanc='" + objCumpreAlvara.getIdLanc() + "'");
            pst.setString(1, objCumpreAlvara.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objCumpreAlvara.getDataLanc().getTime()));
            pst.setInt(3, codInterno);
            pst.setString(4, objCumpreAlvara.getHistorico());
            pst.setInt(5, objCumpreAlvara.getTipoCumprimento());
            pst.setString(6, objCumpreAlvara.getUsuarioUp());
            pst.setString(7, objCumpreAlvara.getDataUp());
            pst.setString(8, objCumpreAlvara.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objCumpreAlvara;
    }

    public CumprimentoAlvara excluirCumprimentoAlvara(CumprimentoAlvara objCumpreAlvara) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM CUMPRIMENTOALVARA WHERE IdLanc='" + objCumpreAlvara.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objCumpreAlvara;
    }

    public CumprimentoAlvara finalizarCumprimentoAlvara(CumprimentoAlvara objCumpreAlvara) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE CUMPRIMENTOALVARA SET StatusLanc=? WHERE IdLanc='" + objCumpreAlvara.getIdLanc() + "'");
            pst.setString(1, objCumpreAlvara.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objCumpreAlvara;
    }

    public void buscarInterno(String nome, int codigoInterno) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + nome + "'AND IdInternoCrc='" + codigoInterno  + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (INTERNO) a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
