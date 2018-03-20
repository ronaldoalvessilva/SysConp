/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AtendimentoFamiliarJuridico;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleAtendimentoFamiliarJuridico {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AtendimentoFamiliarJuridico objAtendf = new AtendimentoFamiliarJuridico();
    int codInt;
    int codVisita;

    // Incluir Atendimento Familiar
    public AtendimentoFamiliarJuridico incluirAtendFamiliar(AtendimentoFamiliarJuridico objAtendf) {
        buscarVista(objAtendf.getNomeVisita());
        buscarInternoCrc(objAtendf.getNomeInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ATENDIMENTOFAMILIARJURIDICO (DataAtendf,StatusAtendf,IdVisita,IdInternoCrc,Evolucao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objAtendf.getDataAtendf().getTime()));
            pst.setString(2, objAtendf.getStatusAtend());
            pst.setInt(3, codVisita);
            pst.setInt(4, codInt);
            pst.setString(5, objAtendf.getEvolucao());
            pst.setString(6, objAtendf.getUsuarioInsert());
            pst.setString(7, objAtendf.getDataInsert());
            pst.setString(8, objAtendf.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAtendf;
    }

    // Alterar Atendimento Familiar
    public AtendimentoFamiliarJuridico alterarAtendFamiliar(AtendimentoFamiliarJuridico objAtendf) {
        buscarVista(objAtendf.getNomeVisita());
        buscarInternoCrc(objAtendf.getNomeInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATENDIMENTOFAMILIARJURIDICO SET DataAtendf=?,StatusAtendf=?,IdVisita=?,IdInternoCrc=?,Evolucao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdAtendf='" + objAtendf.getIdAtendf() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objAtendf.getDataAtendf().getTime()));
            pst.setString(2, objAtendf.getStatusAtend());
            pst.setInt(3, codVisita);
            pst.setInt(4, codInt);
            pst.setString(5, objAtendf.getEvolucao());
            pst.setString(6, objAtendf.getUsuarioUp());
            pst.setString(7, objAtendf.getDataUp());
            pst.setString(8, objAtendf.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAtendf;
    }

    // Excluir Atendimento Familiar
    public AtendimentoFamiliarJuridico excluirAtendFamiliar(AtendimentoFamiliarJuridico objAtendf) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ATENDIMENTOFAMILIARJURIDICO WHERE IdAtendf='" + objAtendf.getIdAtendf() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAtendf;
    }

    public AtendimentoFamiliarJuridico finalizarAtendFamiliar(AtendimentoFamiliarJuridico objAtendf) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATENDIMENTOFAMILIARJURIDICO SET StatusAtendf=? WHERE IdAtendf='" + objAtendf.getIdAtendf() + "'");
            pst.setString(1, objAtendf.getStatusAtend());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR atendimento\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAtendf;
    }

    // Buscar código de interno
    public void buscarVista(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM VISITASINTERNO WHERE NomeVisita='" + desc + "'");
            conecta.rs.first();
            codVisita = conecta.rs.getInt("IdVisita");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (VISITAS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }

    // Buscar código de visita
    public void buscarInternoCrc(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + desc + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNOS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
