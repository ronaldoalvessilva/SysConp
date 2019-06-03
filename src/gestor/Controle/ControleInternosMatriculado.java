/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensInternosMatriculado;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleInternosMatriculado {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensInternosMatriculado objItensMat = new ItensInternosMatriculado();
    int codInterno;

    public ItensInternosMatriculado incluirInternosMatricula(ItensInternosMatriculado objItensMat) {
        buscarInterno(objItensMat.getNomeInternoCrc(), objItensMat.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENSMATRICULA (IdMat,IdInternoCrc,Bloqueio,UsuarioInsert,DataInsert,HorarioInsert,StatusAluno,SituacaoAluno,DataConDes) VALUES(?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objItensMat.getIdMat());
            pst.setInt(2, codInterno);
            pst.setString(3, objItensMat.getBloqueio());
            pst.setString(4, objItensMat.getUsuarioInsert());
            pst.setString(5, objItensMat.getDataInsert());
            pst.setString(6, objItensMat.getHorarioInsert());
            pst.setString(7, objItensMat.getStatusAluno());
            pst.setString(8, objItensMat.getSituacaoAluno());
            if (objItensMat.getDataConclusaoDesistencia() != null) {
                pst.setTimestamp(9, new java.sql.Timestamp(objItensMat.getDataConclusaoDesistencia().getTime()));
            } else {
                pst.setDate(9, null);
            }
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensMat;
    }

    public ItensInternosMatriculado alterarInternosMatricula(ItensInternosMatriculado objItensMat) {
        buscarInterno(objItensMat.getNomeInternoCrc(), objItensMat.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSMATRICULA SET IdMat=?,IdInternoCrc=?,Bloqueio=?,UsuarioUp=?,DataUp=?,HorarioUp=?,StatusAluno=?,SituacaoAluno=?,DataConDes=? WHERE IdItem='" + objItensMat.getIdItem() + "'");
            pst.setInt(1, objItensMat.getIdMat());
            pst.setInt(2, codInterno);
            pst.setString(3, objItensMat.getBloqueio());
            pst.setString(4, objItensMat.getUsuarioUp());
            pst.setString(5, objItensMat.getDataUp());
            pst.setString(6, objItensMat.getHorarioUp());
            pst.setString(7, objItensMat.getStatusAluno());
            pst.setString(8, objItensMat.getSituacaoAluno());
            if (objItensMat.getDataConclusaoDesistencia() != null) {
                pst.setTimestamp(9, new java.sql.Timestamp(objItensMat.getDataConclusaoDesistencia().getTime()));
            } else {
                pst.setDate(9, null);
            }
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensMat;
    }

    public ItensInternosMatriculado excluirInternosMatricula(ItensInternosMatriculado objItensMat) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENSMATRICULA WHERE IdItem='" + objItensMat.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensMat;
    }

    public void buscarInterno(String nomeInterno, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + nomeInterno + "' AND IdInternoCrc='" + codigo + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNO) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
