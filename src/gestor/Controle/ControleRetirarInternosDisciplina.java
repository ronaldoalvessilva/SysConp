/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.InternosIsolamento;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleRetirarInternosDisciplina {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    InternosIsolamento objIntIsolamento = new InternosIsolamento();

    int codInterno;

    public InternosIsolamento incluirInternoIsolameto(InternosIsolamento objIntIsolamento) {
        pesquisarInterno(objIntIsolamento.getNomeInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO INTERNOSISOLAMENTO (IdInternoCrc,IdLancRet,IdLanc,ConfirmaUtilizacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");
            pst.setInt(1, codInterno);
            pst.setInt(2, objIntIsolamento.getIdLancRet());
            pst.setInt(3, objIntIsolamento.getIdLanc());
            pst.setString(4, objIntIsolamento.getConfirmaUtilizacao());
            pst.setString(5, objIntIsolamento.getUsuarioInsert());
            pst.setString(6, objIntIsolamento.getDataInsert());
            pst.setString(7, objIntIsolamento.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel gravar os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objIntIsolamento;
    }

    public InternosIsolamento alterarInternoIsolameto(InternosIsolamento objIntIsolamento) {
        pesquisarInterno(objIntIsolamento.getNomeInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE INTERNOSISOLAMENTO SET IdInternoCrc=?,IdLancRet=?,IdLanc=?,ConfirmaUtilizacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdIsola='" + objIntIsolamento.getIdIsola() + "'");
            pst.setInt(1, codInterno);
            pst.setInt(2, objIntIsolamento.getIdLancRet());
            pst.setInt(3, objIntIsolamento.getIdLanc());
            pst.setString(4, objIntIsolamento.getConfirmaUtilizacao());
            pst.setString(5, objIntIsolamento.getUsuarioUp());
            pst.setString(6, objIntIsolamento.getDataUp());
            pst.setString(7, objIntIsolamento.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel gravar os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objIntIsolamento;
    }

    public InternosIsolamento excluirInternoIsolameto(InternosIsolamento objIntIsolamento) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM INTERNOSISOLAMENTO WHERE IdIsola='" + objIntIsolamento.getIdIsola() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel excluir registro.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objIntIsolamento;
    }

    public InternosIsolamento alterarAutorEventosIsolamento(InternosIsolamento objIntIsolamento) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE AUTOREVENTOS SET UtilizaSaida=? WHERE IdLanc='" + objIntIsolamento.getIdLanc() + "'AND IdInternoCrc='" + objIntIsolamento.getIdInternoCrc() + "'");
            pst.setString(1, objIntIsolamento.getConfirmaUtilizacao());            
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel gravar os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objIntIsolamento;
    }

    public InternosIsolamento alterarRegistroIsolamentoInterno(InternosIsolamento objIntIsolamento) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE AUTORES_REGIMENTO_DISCIPLINAR SET UtilizaSaida=? WHERE IdReg='" + objIntIsolamento.getIdLanc() + "'AND IdInternoCrc='" + objIntIsolamento.getIdInternoCrc() + "'");
            pst.setString(1, objIntIsolamento.getConfirmaUtilizacao());            
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel gravar os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objIntIsolamento;
    }
    public void pesquisarInterno(String nome) {
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
