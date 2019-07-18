/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AtualizarMatricula;
import gestor.Modelo.ItensInternosMatriculado;
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
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ATUALIZAR_MATRICULA_INTERNO (StatusAtual,DataRegistro,IdInternoCrc,IdMat,StatusAluno,SituacaoAluno,DataAvaliacao,Avaliacao,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objAtual.getStatusAtual());
            pst.setTimestamp(2, new java.sql.Timestamp(objAtual.getDataRegistro().getTime()));
            pst.setInt(3, codigoInterno);
            pst.setInt(4, objAtual.getIdMat());
            pst.setString(5, objAtual.getStatusAluno());
            pst.setString(6, objAtual.getSituacaoAluno());
            pst.setTimestamp(7, new java.sql.Timestamp(objAtual.getDataAvaliacao().getTime()));
            pst.setDouble(8, objAtual.getAvaliacao());
            pst.setString(9, objAtual.getObservacao());
            pst.setString(10, objAtual.getUsuarioInsert());
            pst.setString(11, objAtual.getDataInsert());
            pst.setString(12, objAtual.getHorarioInsert());
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
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATUALIZAR_MATRICULA_INTERNO SET StatusAtual=?,DataRegistro=?,IdInternoCrc=?,IdMat=?,StatusAluno=?,SituacaoAluno=?,DataAvaliacao=?,Avaliacao=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdAtual='" + objAtual.getIdAtual() + "'");
            pst.setString(1, objAtual.getStatusAtual());
            pst.setTimestamp(2, new java.sql.Timestamp(objAtual.getDataRegistro().getTime()));
            pst.setInt(3, codigoInterno);
            pst.setInt(4, objAtual.getIdMat());
            pst.setString(5, objAtual.getStatusAluno());
            pst.setString(6, objAtual.getSituacaoAluno());
            pst.setTimestamp(7, new java.sql.Timestamp(objAtual.getDataAvaliacao().getTime()));
            pst.setDouble(8, objAtual.getAvaliacao());
            pst.setString(9, objAtual.getObservacao());
            pst.setString(10, objAtual.getUsuarioInsert());
            pst.setString(11, objAtual.getDataInsert());
            pst.setString(12, objAtual.getHorarioInsert());
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

    public AtualizarMatricula finalizarAtualizacaoMatricula(AtualizarMatricula objAtual) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATUALIZAR_MATRICULA_INTERNO SET StatusAtual=? WHERE IdAtual='" + objAtual.getIdAtual() + "'");
            pst.setString(1, objAtual.getStatusAtual());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtual;
    }

    public ItensInternosMatriculado atualizarInternosMatricula(ItensInternosMatriculado objItensMat) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSMATRICULA SET StatusAluno=?,SituacaoAluno=?,DataConDes=? WHERE IdInternoCrc='" + objItensMat.getIdInternoCrc() + "'AND IdMat='" + objItensMat.getIdMat() + "'");
            pst.setString(1, objItensMat.getStatusAluno());
            pst.setString(2, objItensMat.getSituacaoAluno());
            if (objItensMat.getDataConclusaoDesistencia() != null) {
                pst.setTimestamp(3, new java.sql.Timestamp(objItensMat.getDataConclusaoDesistencia().getTime()));
            } else {
                pst.setDate(3, null);
            }
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensMat;
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
