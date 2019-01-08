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
    int idPavDestino;
    int idCelaDestino;

    public InternosIsolamento incluirInternoIsolameto(InternosIsolamento objIntIsolamento) {
        pesquisarInterno(objIntIsolamento.getNomeInterno(), objIntIsolamento.getIdInternoCrc());
        pesquisarPavilhao(objIntIsolamento.getNomePavilhoDestino(), objIntIsolamento.getIdPavDestino());
        pesquisarCelas(objIntIsolamento.getNomeCelaDestino(), objIntIsolamento.getIdCelaDestino());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO INTERNOSISOLAMENTO (IdInternoCrc,IdLancRet,IdLanc,ConfirmaUtilizacao,UsuarioInsert,DataInsert,HorarioInsert,IdPav,IdCela,PavilhaoOrigem,CelaOrigem) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, codInterno);
            pst.setInt(2, objIntIsolamento.getIdLancRet());
            pst.setInt(3, objIntIsolamento.getIdLanc());
            pst.setString(4, objIntIsolamento.getConfirmaUtilizacao());
            pst.setString(5, objIntIsolamento.getUsuarioInsert());
            pst.setString(6, objIntIsolamento.getDataInsert());
            pst.setString(7, objIntIsolamento.getHorarioInsert());
            pst.setInt(8, idPavDestino);
            pst.setInt(9, idCelaDestino);
            pst.setString(10, objIntIsolamento.getNomePavilhaoOrigem());
            pst.setString(11, objIntIsolamento.getNomeCelaOrigem());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel gravar os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objIntIsolamento;
    }

    public InternosIsolamento alterarInternoIsolameto(InternosIsolamento objIntIsolamento) {
        pesquisarInterno(objIntIsolamento.getNomeInterno(), objIntIsolamento.getIdInternoCrc());
        pesquisarPavilhao(objIntIsolamento.getNomePavilhoDestino(), objIntIsolamento.getIdPavDestino());
        pesquisarCelas(objIntIsolamento.getNomeCelaDestino(), objIntIsolamento.getIdCelaDestino());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE INTERNOSISOLAMENTO SET IdInternoCrc=?,IdLancRet=?,IdLanc=?,ConfirmaUtilizacao=?,UsuarioUp=?,DataUp=?,HorarioUp=?,IdPav=?,IdCela=?,PavilhaoOrigem=?,CelaOrigem=? WHERE IdIsola='" + objIntIsolamento.getIdIsola() + "'");
            pst.setInt(1, codInterno);
            pst.setInt(2, objIntIsolamento.getIdLancRet());
            pst.setInt(3, objIntIsolamento.getIdLanc());
            pst.setString(4, objIntIsolamento.getConfirmaUtilizacao());
            pst.setString(5, objIntIsolamento.getUsuarioUp());
            pst.setString(6, objIntIsolamento.getDataUp());
            pst.setString(7, objIntIsolamento.getHorarioUp());
            pst.setInt(8, idPavDestino);
            pst.setInt(9, idCelaDestino);
            pst.setString(10, objIntIsolamento.getNomePavilhaoOrigem());
            pst.setString(11, objIntIsolamento.getNomeCelaOrigem());
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

    public void pesquisarInterno(String nome, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + nome + "' "
                    + "AND IdInternoCrc='" + codigo + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!.\nERRO: " + ex);
        }
        conecta.desconecta();
    }

    public void pesquisarPavilhao(String descricao, int id) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PAVILHAO WHERE DescricaoPav='" + descricao + "' "
                    + "AND IdPav='" + id + "'");
            conecta.rs.first();
            idPavDestino = conecta.rs.getInt("IdPav");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados do PAVILHÃO a serem exibidos !!!.\nERRO: " + ex);
        }
        conecta.desconecta();
    }

    public void pesquisarCelas(String descricaoCela, int idCelas) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM CELAS WHERE EndCelaPav='" + descricaoCela + "' "
                    + "AND IdCela='" + idCelas + "'");
            conecta.rs.first();
            idCelaDestino = conecta.rs.getInt("IdCela");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados da CELA a serem exibidos !!!.\nERRO: " + ex);
        }
        conecta.desconecta();
    }
}
