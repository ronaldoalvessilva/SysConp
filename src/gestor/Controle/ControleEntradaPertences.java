/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EntradaPertences;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleEntradaPertences {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EntradaPertences objEntPert = new EntradaPertences();
    int codVisita;
    int codInterno;

    public EntradaPertences incluirEntradaPertences(EntradaPertences objEntPert) {
        buscarVisita(objEntPert.getNomeVisita());
        buscarInterno(objEntPert.getNomeInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ENTRADAPERTENCES (SituacaoEnt,Datalanc,IdVisita,IdInternoCrc,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?)");
            pst.setString(1, objEntPert.getSituacaoEnt());
            pst.setTimestamp(2, new java.sql.Timestamp(objEntPert.getDataLanc().getTime()));
            pst.setInt(3, codVisita);
            pst.setInt(4, codInterno);
            pst.setString(5, objEntPert.getObservacao());
            pst.setString(6, objEntPert.getUsuarioInsert());
            pst.setString(7, objEntPert.getDataInsert());
            pst.setString(8, objEntPert.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntPert;
    }

    public EntradaPertences alterarEntradaPertences(EntradaPertences objEntPert) {
        buscarVisita(objEntPert.getNomeVisita());
        buscarInterno(objEntPert.getNomeInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADAPERTENCES SET SituacaoEnt=?,Datalanc=?,IdVisita=?,IdInternoCrc=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE Idlanc='" + objEntPert.getIdLanc() + "'");
            pst.setString(1, objEntPert.getSituacaoEnt());
            pst.setTimestamp(2, new java.sql.Timestamp(objEntPert.getDataLanc().getTime()));
            pst.setInt(3, codVisita);
            pst.setInt(4, codInterno);
            pst.setString(5, objEntPert.getObservacao());
            pst.setString(6, objEntPert.getUsuarioUp());
            pst.setString(7, objEntPert.getDataUp());
            pst.setString(8, objEntPert.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntPert;
    }

    public EntradaPertences excluirEntradaPertences(EntradaPertences objEntPert) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ENTRADAPERTENCES WHERE Idlanc='" + objEntPert.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntPert;
    }

    public EntradaPertences finalizarEntradaPertences(EntradaPertences objEntPert) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADAPERTENCES SET SituacaoEnt=? WHERE IdLanc='" + objEntPert.getIdLanc() + "'");
            pst.setString(1, objEntPert.getSituacaoEnt());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR atendimento\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntPert;
    }

    public void buscarVisita(String desc) {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM VISITASINTERNO WHERE NomeVisita='" + desc + "'");
            conecta.rs.first();
            codVisita = conecta.rs.getInt("IdVisita");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (VISITANTE) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }

    public void buscarInterno(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + desc + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNO) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
