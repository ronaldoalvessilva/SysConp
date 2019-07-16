/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AtualizarMatricula;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronal
 */
public class ControleAtualizarMatricula {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AtualizarMatricula objAtual = new AtualizarMatricula();
    int codigoInterno;

    public AtualizarMatricula incluirAtualizacaoMatricula(AtualizarMatricula objAtual) {
        pesquisaInterno(objAtual.getNomeInternoCrc(), objAtual.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ATUALIZAR_MATRICULA_INTERNO (StatusAtual,DataRegistro,IdInternoCrc,StatusAluno,SituacaoAluno,DataAvaliacao,Avaliacao,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objAtual.getStatusAtual());
            pst.setTimestamp(2, new java.sql.Timestamp(objAtual.getDataRegistro().getTime()));
            pst.setInt(3, codigoInterno);
            pst.setString(4, objAtual.getStatusAluno());
            pst.setString(5, objAtual.getSituacaoAluno());
            pst.setTimestamp(6, new java.sql.Timestamp(objAtual.getDataAvaliacao().getTime()));
            pst.setDouble(7, objAtual.getAvaliacao());
            pst.setString(8, objAtual.getObservacao());
            pst.setString(9, objAtual.getUsuarioInsert());
            pst.setString(10, objAtual.getDataInsert());
            pst.setString(11, objAtual.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtual;
    }

    public AtualizarMatricula alterarAtualizacaoMatricula(AtualizarMatricula objAtual) {
        pesquisaInterno(objAtual.getNomeInternoCrc(), objAtual.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATUALIZAR_MATRICULA_INTERNO SET StatusAtual=?,DataRegistro=?,IdInternoCrc=?,StatusAluno=?,SituacaoAluno=?,DataAvaliacao=?,Avaliacao=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdAtual='" + objAtual.getIdAtual() + "'");
            pst.setString(1, objAtual.getStatusAtual());
            pst.setTimestamp(2, new java.sql.Timestamp(objAtual.getDataRegistro().getTime()));
            pst.setInt(3, codigoInterno);
            pst.setString(4, objAtual.getStatusAluno());
            pst.setString(5, objAtual.getSituacaoAluno());
            pst.setTimestamp(6, new java.sql.Timestamp(objAtual.getDataAvaliacao().getTime()));
            pst.setDouble(7, objAtual.getAvaliacao());
            pst.setString(8, objAtual.getObservacao());
            pst.setString(9, objAtual.getUsuarioInsert());
            pst.setString(10, objAtual.getDataInsert());
            pst.setString(11, objAtual.getHorarioInsert());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtual;
    }

    public AtualizarMatricula excluirAtualizacaoMatricula(AtualizarMatricula objAtual) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ATUALIZAR_MATRICULA_INTERNO WHERE IdAtual='" + objAtual.getIdAtual() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtual;
    }

    public void pesquisaInterno(String nome, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE NomeInternoCrc='" + nome + "' "
                    + "AND IdInternoCrc='" + codigo + "'");
            conecta.rs.first();
            codigoInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
