/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AtividadesMensalRealizadaUnidades;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronal
 */
public class ControleAtividadesUnidade {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AtividadesMensalRealizadaUnidades objAtividade = new AtividadesMensalRealizadaUnidades();

    //ABA MANUTENÇÃO
    public AtividadesMensalRealizadaUnidades incluirAtividade(AtividadesMensalRealizadaUnidades objAtividade) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ATIVIDADES_UNIDADE (StatusAtividade,"
                    + "DataCriacao,DataAtualizacao,IdUnidEmp,Populacao,MesReferencia,AnoReferencia,IdFunc,"
                    + "Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objAtividade.getStatus());
            pst.setTimestamp(2, new java.sql.Timestamp(objAtividade.getDataCriacao().getTime()));
            if (objAtividade.getDataAtualizacao() != null) {
                pst.setTimestamp(3, new java.sql.Timestamp(objAtividade.getDataAtualizacao().getTime()));
            } else {
                pst.setDate(3, null);
            }
            pst.setInt(4, objAtividade.getIdUnidade());
            pst.setInt(5, objAtividade.getMediaPopulacao());
            pst.setString(6, objAtividade.getMesReferencia());
            pst.setString(7, objAtividade.getAnoReferencia());
            pst.setInt(9, objAtividade.getIdFunc());
            pst.setString(9, objAtividade.getObservacao());
            pst.setString(10, objAtividade.getUsuarioInsert());
            pst.setString(11, objAtividade.getDataInsert());
            pst.setString(12, objAtividade.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtividade;
    }

    public AtividadesMensalRealizadaUnidades alterarAtividade(AtividadesMensalRealizadaUnidades objAtividade) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATIVIDADES_UNIDADE SET StatusAtividade=?,"
                    + "DataCriacao=?,DataAtualizacao=?,IdUnidEmp=?,Populacao=?,MesReferencia=?,AnoReferencia=?,IdFunc=?,"
                    + "Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdAtividade='" + objAtividade.getChave() + "'");
            pst.setString(1, objAtividade.getStatus());
            pst.setTimestamp(2, new java.sql.Timestamp(objAtividade.getDataCriacao().getTime()));
            if (objAtividade.getDataAtualizacao() != null) {
                pst.setTimestamp(3, new java.sql.Timestamp(objAtividade.getDataAtualizacao().getTime()));
            } else {
                pst.setDate(3, null);
            }
            pst.setInt(4, objAtividade.getIdUnidade());
            pst.setInt(5, objAtividade.getMediaPopulacao());
            pst.setString(6, objAtividade.getMesReferencia());
            pst.setString(7, objAtividade.getAnoReferencia());
            pst.setInt(9, objAtividade.getIdFunc());
            pst.setString(9, objAtividade.getObservacao());
            pst.setString(10, objAtividade.getUsuarioInsert());
            pst.setString(11, objAtividade.getDataInsert());
            pst.setString(12, objAtividade.getHorarioInsert());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtividade;
    }

    public AtividadesMensalRealizadaUnidades excluirAtividade(AtividadesMensalRealizadaUnidades objAtividade) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ATIVIDADES_UNIDADE WHERE IdAtividade='" + objAtividade.getChave() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtividade;
    }

    public AtividadesMensalRealizadaUnidades finalizarAtividade(AtividadesMensalRealizadaUnidades objAtividade) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATIVIDADES_UNIDADE SET StatusAtividade=? WHERE IdAtividade='" + objAtividade.getChave() + "'");
            pst.setString(1, objAtividade.getStatus());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtividade;
    }

    //ABA ASSI
}
