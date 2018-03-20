/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.SolicitacaoExamesMedicoPsiquiatrico;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleSolicitacaoExamesMedicoPsiquiatrico {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    SolicitacaoExamesMedicoPsiquiatrico objSoliEx = new SolicitacaoExamesMedicoPsiquiatrico();

    int codInterno;

    public SolicitacaoExamesMedicoPsiquiatrico incluirExameMedicoPsiquiatrico(SolicitacaoExamesMedicoPsiquiatrico objSoliEx) {       
        buscarInterno(objSoliEx.getNomeInternoCrc(),objSoliEx.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO SOLICITACAO_EXAMES_MEDICO_PSIQUIATRICO (StatusSolExame,DataSolExame,IdInternoCrc,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES (?,?,?,?,?,?,?)");
            pst.setString(1, objSoliEx.getStatusSolExame());
            pst.setTimestamp(2, new java.sql.Timestamp(objSoliEx.getDataSolExame().getTime()));
            pst.setInt(3, codInterno);
            pst.setString(4, objSoliEx.getObservacao());
            pst.setString(5, objSoliEx.getUsuarioInsert());
            pst.setString(6, objSoliEx.getDataInsert());
            pst.setString(7, objSoliEx.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSoliEx;
    }

    public SolicitacaoExamesMedicoPsiquiatrico alterarExameMedicoPsiquiatrico(SolicitacaoExamesMedicoPsiquiatrico objSoliEx) {
        buscarInterno(objSoliEx.getNomeInternoCrc(),objSoliEx.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE SOLICITACAO_EXAMES_MEDICO_PSIQUIATRICO SET StatusSolExame=?,DataSolExame=?,IdInternoCrc=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdSolExame='" + objSoliEx.getIdSolExame() + "'");
            pst.setString(1, objSoliEx.getStatusSolExame());
            pst.setTimestamp(2, new java.sql.Timestamp(objSoliEx.getDataSolExame().getTime()));
            pst.setInt(3, codInterno);
            pst.setString(4, objSoliEx.getObservacao());
            pst.setString(5, objSoliEx.getUsuarioUp());
            pst.setString(6, objSoliEx.getDataUp());
            pst.setString(7, objSoliEx.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSoliEx;
    }

    public SolicitacaoExamesMedicoPsiquiatrico excluirExameMedicoPsiquiatrico(SolicitacaoExamesMedicoPsiquiatrico objSoliEx) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM SOLICITACAO_EXAMES_MEDICO_PSIQUIATRICO WHERE IdSolExame='" + objSoliEx.getIdSolExame() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSoliEx;
    }

    public SolicitacaoExamesMedicoPsiquiatrico finalizarExameMedicoPsiquiatrico(SolicitacaoExamesMedicoPsiquiatrico objSoliEx) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE SOLICITACAO_EXAMES_MEDICO_PSIQUIATRICO SET StatusSolExame=? WHERE IdSolExame='" + objSoliEx.getIdSolExame() + "'");
            pst.setString(1, objSoliEx.getStatusSolExame());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSoliEx;
    }

    public void buscarInterno(String desc, int cod) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + desc + "'AND IdInternoCrc='" + cod + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível pesquisar o interno.\nERRO: " + ex);
        }
    }
}
