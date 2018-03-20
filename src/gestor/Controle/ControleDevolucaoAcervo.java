/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.DevolucaoAcervo;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleDevolucaoAcervo {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    DevolucaoAcervo objDevolucaoAcervo = new DevolucaoAcervo();

    int codInterno;

    public DevolucaoAcervo incluirDevolucaoAcervo(DevolucaoAcervo objDevolucaoAcervo) {
        buscarInternoEmprestimoAcervo(objDevolucaoAcervo.getNomeInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO DEVOLUCAO_ACERVO (StatusLanc,DataDevol,IdInternoCrc,IdEmprestimo,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?)");
            pst.setString(1, objDevolucaoAcervo.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objDevolucaoAcervo.getDataDevolucao().getTime()));
            pst.setInt(3, codInterno);
            pst.setInt(4, objDevolucaoAcervo.getIdEmprestimo());
            pst.setString(5, objDevolucaoAcervo.getObservacao());
            pst.setString(6, objDevolucaoAcervo.getUsuarioInsert());
            pst.setString(7, objDevolucaoAcervo.getDataInsert());
            pst.setString(8, objDevolucaoAcervo.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objDevolucaoAcervo;
    }

    public DevolucaoAcervo alterarDevolucaoAcervo(DevolucaoAcervo objDevolucaoAcervo) {
        buscarInternoEmprestimoAcervo(objDevolucaoAcervo.getNomeInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE DEVOLUCAO_ACERVO SET StatusLanc=?,DataDevol=?,IdInternoCrc=?,IdEmprestimo=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdDevolucao='" + objDevolucaoAcervo.getIdDevolucao() + "'");
            pst.setString(1, objDevolucaoAcervo.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objDevolucaoAcervo.getDataDevolucao().getTime()));
            pst.setInt(3, codInterno);
            pst.setInt(4, objDevolucaoAcervo.getIdEmprestimo());
            pst.setString(5, objDevolucaoAcervo.getObservacao());
            pst.setString(6, objDevolucaoAcervo.getUsuarioUp());
            pst.setString(7, objDevolucaoAcervo.getDataUp());
            pst.setString(8, objDevolucaoAcervo.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objDevolucaoAcervo;
    }

    public DevolucaoAcervo excluirDevolucaoAcervo(DevolucaoAcervo objDevolucaoAcervo) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM DEVOLUCAO_ACERVO WHERE IdDevolucao='" + objDevolucaoAcervo.getIdDevolucao() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objDevolucaoAcervo;
    }

    public DevolucaoAcervo finalizarDevolucaoAcervo(DevolucaoAcervo objDevolucaoAcervo) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE DEVOLUCAO_ACERVO SET StatusLanc=? WHERE IdDevolucao='" + objDevolucaoAcervo.getIdDevolucao() + "'");
            pst.setString(1, objDevolucaoAcervo.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objDevolucaoAcervo;
    }

    public void buscarInternoEmprestimoAcervo(String nome) {
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
