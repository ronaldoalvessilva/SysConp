/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.HistoricoAutor;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleHistoricoAutor {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    HistoricoAutor objHisto = new HistoricoAutor();

    int codInterno;

    public HistoricoAutor incluirHistoricoInterno(HistoricoAutor objHisto) {
        pesquisarHistoricoInterno(objHisto.getNomeInternoHistorico());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO HISTORICOAUTOR (IdLanc,IdInternoCrc,Historico,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?)");
            pst.setInt(1, objHisto.getIdLanc());
            pst.setInt(2, codInterno);
            pst.setString(3, objHisto.getHistorico());
            pst.setString(4, objHisto.getUsuarioInsert());
            pst.setString(5, objHisto.getDataInsert());
            pst.setString(6, objHisto.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel gravar os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objHisto;
    }

    public HistoricoAutor alterarHistoricoInterno(HistoricoAutor objHisto) {
        pesquisarHistoricoInterno(objHisto.getNomeInternoHistorico());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE HISTORICOAUTOR SET IdLanc=?,IdInternoCrc=?,Historico=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdHist='" + objHisto.getIdHist() + "'");
            pst.setInt(1, objHisto.getIdLanc());
            pst.setInt(2, codInterno);
            pst.setString(3, objHisto.getHistorico());
            pst.setString(4, objHisto.getUsuarioUp());
            pst.setString(5, objHisto.getDataUp());
            pst.setString(6, objHisto.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel gravar os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objHisto;
    }

    public HistoricoAutor excluirHistoricoInterno(HistoricoAutor objHisto) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM HISTORICOAUTOR WHERE IdHist='" + objHisto.getIdHist() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel excluir os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objHisto;
    }

    public void pesquisarHistoricoInterno(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + nome + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!.\nERRO: " + ex);
        }
        conecta.desconecta();
    }
}
