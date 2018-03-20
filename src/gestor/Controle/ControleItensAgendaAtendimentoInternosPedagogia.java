/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensAgendaAtendimentoInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleItensAgendaAtendimentoInternosPedagogia {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensAgendaAtendimentoInternos objItens = new ItensAgendaAtendimentoInternos();

    int codInterno;

    public ItensAgendaAtendimentoInternos incluirItensAgendaInterno(ItensAgendaAtendimentoInternos objItens) {
        buscarInterno(objItens.getNomeInternoAgenda(), objItens.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_AGENDA_ATENDIMENTO_INTERNOS_PEDAGOGIA (IdReg,IdInternoCrc,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?)");
            pst.setInt(1, objItens.getIdReg());
            pst.setInt(2, codInterno);
            pst.setString(3, objItens.getUsuarioInsert());
            pst.setString(4, objItens.getDataInsert());
            pst.setString(5, objItens.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItens;
    }

    public ItensAgendaAtendimentoInternos alterarItensAgendaInterno(ItensAgendaAtendimentoInternos objItens) {
        buscarInterno(objItens.getNomeInternoAgenda(), objItens.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_AGENDA_ATENDIMENTO_INTERNOS_PEDAGOGIA SET IdReg=?,IdInternoCrc=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdReg='" + objItens.getIdReg() + "'");
            pst.setInt(1, objItens.getIdReg());
            pst.setInt(2, codInterno);
            pst.setString(3, objItens.getUsuarioUp());
            pst.setString(4, objItens.getDataUp());
            pst.setString(5, objItens.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItens;
    }

    public ItensAgendaAtendimentoInternos excluirItensAgendaInterno(ItensAgendaAtendimentoInternos objItens) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_AGENDA_ATENDIMENTO_INTERNOS_PEDAGOGIA WHERE IdReg='" + objItens.getIdReg() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItens;
    }

    public void buscarInterno(String nome, int codigoInterno) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + nome + "'AND IdInternoCrc='" + codigoInterno + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
