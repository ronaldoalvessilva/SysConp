/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.HistoricoAvaliacaoSocial;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleHistoricoAvaliacaoServicoSocial {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    HistoricoAvaliacaoSocial objHistAva = new HistoricoAvaliacaoSocial();
    int codInt;

    public HistoricoAvaliacaoSocial incluirHistoricoAvalivacao(HistoricoAvaliacaoSocial objHistAva) {
        buscarInterno(objHistAva.getNomeInternoCrc(), objHistAva.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO HISTORICO_AVALICAO_SERVICO_SOCIAL (StatusLanc,DataLanc,IdInternoCrc,Titulo,TextoArea,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?)");
            pst.setString(1, objHistAva.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objHistAva.getDataLanc().getTime()));
            pst.setInt(3, codInt);
            pst.setString(4, objHistAva.getTitulo());
            pst.setString(5, objHistAva.getTextoArea());
            pst.setString(6, objHistAva.getUsuarioInsert());
            pst.setString(7, objHistAva.getDataInsert());
            pst.setString(8, objHistAva.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objHistAva;
    }

    public HistoricoAvaliacaoSocial alterarHistoricoAvalivacao(HistoricoAvaliacaoSocial objHistAva) {
        buscarInterno(objHistAva.getNomeInternoCrc(), objHistAva.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE HISTORICO_AVALICAO_SERVICO_SOCIAL SET StatusLanc=?,DataLanc=?,IdInternoCrc=?,Titulo=?,TextoArea=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdLanc='" + objHistAva.getIdLanc() + "'");
            pst.setString(1, objHistAva.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objHistAva.getDataLanc().getTime()));
            pst.setInt(3, codInt);
            pst.setString(4, objHistAva.getTitulo());
            pst.setString(5, objHistAva.getTextoArea());
            pst.setString(6, objHistAva.getUsuarioInsert());
            pst.setString(7, objHistAva.getDataInsert());
            pst.setString(8, objHistAva.getHorarioInsert());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objHistAva;
    }

    public HistoricoAvaliacaoSocial excluirHistoricoAvalivacao(HistoricoAvaliacaoSocial objHistAva) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM HISTORICO_AVALICAO_SERVICO_SOCIAL WHERE IdLanc='" + objHistAva.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel DELETAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objHistAva;
    }

    public HistoricoAvaliacaoSocial finalizarHistoricoAvalivacao(HistoricoAvaliacaoSocial objHistAva) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE HISTORICO_AVALICAO_SERVICO_SOCIAL SET StatusLanc=? WHERE IdLanc='" + objHistAva.getIdLanc() + "'");
            pst.setString(1, objHistAva.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objHistAva;
    }

    public void buscarInterno(String nome, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + nome + "'AND IdInternoCrc='" + codigo + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados do INTERNO a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
