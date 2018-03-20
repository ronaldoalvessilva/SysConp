/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ReservaAcervo;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleReservaAcervo {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ReservaAcervo objReserva = new ReservaAcervo();

    int codInterno;

    public ReservaAcervo incluirReservaAcervo(ReservaAcervo objReserva) {
        buscarInternoReservaAcervo(objReserva.getNomeInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO RESERVA_ACERVO (StatusLanc,DataReserva,IdInternoCrc,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");
            pst.setString(1, objReserva.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objReserva.getDataReserva().getTime()));
            pst.setInt(3, codInterno);
            pst.setString(4, objReserva.getObservacao());
            pst.setString(5, objReserva.getUsuarioInsert());
            pst.setString(6, objReserva.getDataInsert());
            pst.setString(7, objReserva.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objReserva;
    }

    public ReservaAcervo alterarReservaAcervo(ReservaAcervo objReserva) {
        buscarInternoReservaAcervo(objReserva.getNomeInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE RESERVA_ACERVO SET StatusLanc=?,DataReserva=?,IdInternoCrc=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdReserva='" + objReserva.getIdReserva() + "'");
            pst.setString(1, objReserva.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objReserva.getDataReserva().getTime()));
            pst.setInt(3, codInterno);
            pst.setString(4, objReserva.getObservacao());
            pst.setString(5, objReserva.getUsuarioUp());
            pst.setString(6, objReserva.getDataUp());
            pst.setString(7, objReserva.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objReserva;
    }

    public ReservaAcervo excluirReservaAcervo(ReservaAcervo objReserva) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM RESERVA_ACERVO WHERE IdReserva='" + objReserva.getIdReserva() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objReserva;
    }

    public ReservaAcervo finalizarReservaAcervo(ReservaAcervo objReserva) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE RESERVA_ACERVO SET StatusLanc=? WHERE IdReserva='" + objReserva.getIdReserva() + "'");
            pst.setString(1, objReserva.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objReserva;
    }

    public void buscarInternoReservaAcervo(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + nome + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (INTERNO) a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
