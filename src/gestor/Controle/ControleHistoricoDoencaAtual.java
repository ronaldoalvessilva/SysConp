/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.HistoricoDoencaAtual;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleHistoricoDoencaAtual {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    HistoricoDoencaAtual objHistDoe = new HistoricoDoencaAtual();

    int codInterno;

    public HistoricoDoencaAtual incluirHistoricoDoencaAtual(HistoricoDoencaAtual objHistDoe) {
        buscarInterno(objHistDoe.getNomeInternoCrc(), objHistDoe.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO HISTORICO_DOENCA_FAMILIA (StatusHist,DataHist,IdInternoCrc,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES (?,?,?,?,?,?,?)");
            pst.setString(1, objHistDoe.getStatusHist());
            pst.setTimestamp(2, new java.sql.Timestamp(objHistDoe.getDataHist().getTime()));
            pst.setInt(3, codInterno);
            pst.setString(4, objHistDoe.getObservacao());
            pst.setString(5, objHistDoe.getUsuarioInsert());
            pst.setString(6, objHistDoe.getDataInsert());
            pst.setString(7, objHistDoe.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objHistDoe;
    }

    public HistoricoDoencaAtual alterarHistoricoDoencaAtual(HistoricoDoencaAtual objHistDoe) {
        buscarInterno(objHistDoe.getNomeInternoCrc(), objHistDoe.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE HISTORICO_DOENCA_FAMILIA SET StatusHist=?,DataHist=?,IdInternoCrc=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdHist='" + objHistDoe.getIdHist() + "'");
            pst.setString(1, objHistDoe.getStatusHist());
            pst.setTimestamp(2, new java.sql.Timestamp(objHistDoe.getDataHist().getTime()));
            pst.setInt(3, codInterno);
            pst.setString(4, objHistDoe.getObservacao());
            pst.setString(5, objHistDoe.getUsuarioUp());
            pst.setString(6, objHistDoe.getDataUp());
            pst.setString(7, objHistDoe.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objHistDoe;
    }

    public HistoricoDoencaAtual excluirHistoricoDoencaAtual(HistoricoDoencaAtual objHistDoe) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM HISTORICO_DOENCA_FAMILIA WHERE IdHist='" + objHistDoe.getIdHist() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objHistDoe;
    }

    public HistoricoDoencaAtual FinalizarHistoricoDoencaAtual(HistoricoDoencaAtual objHistDoe) {
        
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE HISTORICO_DOENCA_FAMILIA SET StatusHist=? WHERE IdHist='" + objHistDoe.getIdHist() + "'");
            pst.setString(1, objHistDoe.getStatusHist());          
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objHistDoe;
    }
    public void buscarInterno(String desc, int cod) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE NomeInternoCrc='" + desc + "' "
                    + "AND IdInternoCrc='" + cod  + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível pesquisar o interno.\nERRO: " + ex);
        }
    }
}
