/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AtendimentoTecEnfermagem;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleAtendimentoTecEnfermagem {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AtendimentoTecEnfermagem objAtendlTecEnferma = new AtendimentoTecEnfermagem();
    int codInterno;

    public AtendimentoTecEnfermagem incluirAtendTecEnfermagem(AtendimentoTecEnfermagem objAtendTecEnferma) {
        buscarInterno(objAtendTecEnferma.getNomeInterno(), objAtendTecEnferma.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ATENDIMENTOTECENFERMAGEM (StatusLanc,DataLanc,IdInternoCrc,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES (?,?,?,?,?,?,?)");
            pst.setString(1, objAtendTecEnferma.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objAtendTecEnferma.getDataLanc().getTime()));
            pst.setInt(3, codInterno);
            pst.setString(4, objAtendTecEnferma.getTextoEvolucao());
            pst.setString(5, objAtendTecEnferma.getUsuarioInsert());
            pst.setString(6, objAtendTecEnferma.getDataInsert());
            pst.setString(7, objAtendTecEnferma.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAtendTecEnferma;
    }

    public AtendimentoTecEnfermagem alterarAtendTecEnfermagem(AtendimentoTecEnfermagem objAtendTecEnferma) {
        buscarInterno(objAtendTecEnferma.getNomeInterno(), objAtendTecEnferma.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATENDIMENTOTECENFERMAGEM SET StatusLanc=?,DataLanc=?,IdInternoCrc=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdLanc='" + objAtendTecEnferma.getIdLanc() + "'");
            pst.setString(1, objAtendTecEnferma.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objAtendTecEnferma.getDataLanc().getTime()));
            pst.setInt(3, codInterno);
            pst.setString(4, objAtendTecEnferma.getTextoEvolucao());
            pst.setString(5, objAtendTecEnferma.getUsuarioUp());
            pst.setString(6, objAtendTecEnferma.getDataUp());
            pst.setString(7, objAtendTecEnferma.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAtendTecEnferma;
    }

    public AtendimentoTecEnfermagem excluirAtendTecEnfermagem(AtendimentoTecEnfermagem objAtendTecEnferma) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ATENDIMENTOTECENFERMAGEM WHERE IdLanc='" + objAtendTecEnferma.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAtendTecEnferma;
    }

    public AtendimentoTecEnfermagem FinalizarAtendTecEnfermagem(AtendimentoTecEnfermagem objAtendTecEnferma) {
       
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATENDIMENTOTECENFERMAGEM SET StatusLanc=? WHERE IdLanc='" + objAtendTecEnferma.getIdLanc() + "'");
            pst.setString(1, objAtendTecEnferma.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAtendTecEnferma;
    }

    public void buscarInterno(String desc, int cod) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE NomeInternoCrc='" + desc + "' "
                    + "AND IdInternoCrc='" + cod + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível pesquisar o interno.\nERRO: " + ex);
        }
    }
}
