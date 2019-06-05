/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ResenhaRemicaoInterno;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Socializa TI 02
 */
public class ControleResenhaInterno {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ResenhaRemicaoInterno objResenha = new ResenhaRemicaoInterno();

    int codLivro, codInterno, codColaborador;

    public ResenhaRemicaoInterno incluirResenhaInterno(ResenhaRemicaoInterno objResenha) {
        buscarColaborador(objResenha.getNomeColaboradorResp(), objResenha.getIdFunc());
        buscarInterno(objResenha.getNomeInternoCrc(), objResenha.getIdInternoCrc());
        buscarLivro(objResenha.getTituloLivro(), objResenha.getIdLivro());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO RESENHA_REMICAO_INTERNO (StatusResenha,DataResenha,IdLivro,IdInternoCrc,IdFunc,ResenhaEntregue,DataEntraga,NrResenha,ValidacaoResenha,Paragrafo,Margens,Legivel,Rasuras,Compreensao,Compatibilidade,Tema,Fidedignidade,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objResenha.getStatusResenha());
            if (objResenha.getDataResenha() != null) {
                pst.setTimestamp(2, new java.sql.Timestamp(objResenha.getDataResenha().getTime()));
            } else {
                pst.setDate(2, null);
            }
            pst.setInt(3, codLivro);
            pst.setInt(4, codInterno);
            pst.setInt(5, codColaborador);
            pst.setString(6, objResenha.getResenhaEntregue());
            if (objResenha.getDataEntraga() != null) {
                pst.setTimestamp(7, new java.sql.Timestamp(objResenha.getDataEntraga().getTime()));
            } else {
                pst.setDate(7, null);
            }
            pst.setInt(8, objResenha.getNrResenha());
            pst.setFloat(9, objResenha.getValidacaoResenha());
            pst.setFloat(10, objResenha.getParagrafo());
            pst.setFloat(11, objResenha.getMargens());
            pst.setFloat(12, objResenha.getLegivel());
            pst.setFloat(13, objResenha.getRasuras());
            pst.setFloat(14, objResenha.getCompreensao());
            pst.setFloat(15, objResenha.getCompatibilidade());
            pst.setFloat(16, objResenha.getTema());
            pst.setString(17, objResenha.getFidedignidade());
            pst.setString(18, objResenha.getObservacao());
            pst.setString(19, objResenha.getUsuarioInsert());
            pst.setString(20, objResenha.getDataInsert());
            pst.setString(21, objResenha.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objResenha;
    }

    public ResenhaRemicaoInterno alterarResenhaInterno(ResenhaRemicaoInterno objResenha) {
        buscarColaborador(objResenha.getNomeColaboradorResp(), objResenha.getIdFunc());
        buscarInterno(objResenha.getNomeInternoCrc(), objResenha.getIdInternoCrc());
        buscarLivro(objResenha.getTituloLivro(), objResenha.getIdLivro());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE RESENHA_REMICAO_INTERNO SET StatusResenha=?,DataResenha=?,IdLivro=?,IdInternoCrc=?,IdFunc=?,ResenhaEntregue=?,DataEntraga=?,NrResenha=?,ValidacaoResenha=?,Paragrafo=?,Margens=?,Legivel=?,Rasuras=?,Compreensao=?,Compatibilidade=?,Tema=?,Fidedignidade=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdResenha='" + objResenha.getIdResenha() + "'");
            pst.setString(1, objResenha.getStatusResenha());
            if (objResenha.getDataResenha() != null) {
                pst.setTimestamp(2, new java.sql.Timestamp(objResenha.getDataResenha().getTime()));
            } else {
                pst.setDate(2, null);
            }
            pst.setInt(3, codLivro);
            pst.setInt(4, codInterno);
            pst.setInt(5, codColaborador);
            pst.setString(6, objResenha.getResenhaEntregue());
            if (objResenha.getDataEntraga() != null) {
                pst.setTimestamp(7, new java.sql.Timestamp(objResenha.getDataEntraga().getTime()));
            } else {
                pst.setDate(7, null);
            }
            pst.setInt(8, objResenha.getNrResenha());
            pst.setFloat(9, objResenha.getValidacaoResenha());
            pst.setFloat(10, objResenha.getParagrafo());
            pst.setFloat(11, objResenha.getMargens());
            pst.setFloat(12, objResenha.getLegivel());
            pst.setFloat(13, objResenha.getRasuras());
            pst.setFloat(14, objResenha.getCompreensao());
            pst.setFloat(15, objResenha.getCompatibilidade());
            pst.setFloat(16, objResenha.getTema());
            pst.setString(17, objResenha.getFidedignidade());
            pst.setString(18, objResenha.getObservacao());
            pst.setString(19, objResenha.getUsuarioUp());
            pst.setString(20, objResenha.getDataUp());
            pst.setString(21, objResenha.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objResenha;
    }

    public ResenhaRemicaoInterno excluirResenhaInterno(ResenhaRemicaoInterno objResenha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM RESENHA_REMICAO_INTERNO WHERE IdResenha='" + objResenha.getIdResenha() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objResenha;
    }

    public void buscarColaborador(String nome, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM COLABORADOR "
                    + "WHERE NomeFunc='" + nome + "' "
                    + "AND idFunc='" + codigo + "'");
            conecta.rs.first();
            codColaborador = conecta.rs.getInt("IdFunc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar o colaborador." + e);
        }
        conecta.desconecta();
    }

    public void buscarInterno(String nome0, int codigo0) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE NomeInternoCrc='" + nome0 + "' "
                    + "AND IdInternoCrc='" + codigo0 + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar o interno." + e);
        }
        conecta.desconecta();
    }

    public void buscarLivro(String desc, int codigoDes) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM LIVROS_REVISTAS_JORNAIS "
                    + "WHERE TituloLivro='" + desc + "' "
                    + "AND IdLivro='" + codigoDes + "'");
            conecta.rs.first();
            codLivro = conecta.rs.getInt("IdLivro");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar o colaborador." + e);
        }
        conecta.desconecta();
    }
}
