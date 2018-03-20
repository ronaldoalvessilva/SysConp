/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AprovadorSolicitacaoCompra;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleAprovadorSolicitacaoENFA {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AprovadorSolicitacaoCompra objAprovaSol = new AprovadorSolicitacaoCompra();

    int codDepto;

    public AprovadorSolicitacaoCompra incluirAprovadorSolicitacao(AprovadorSolicitacaoCompra objAprovaSol) {
        pesquisarDepartamento(objAprovaSol.getDescricaoDepartamento());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO APROVADOR_REQUISICAO_MEDICAMENTOS_ENFAR (FotoFuncAprova,StatusAprova,TipoAprova,NomeAprovador,IdDepartamento,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objAprovaSol.getFotoFuncAprova());
            pst.setString(2, objAprovaSol.getStatusAprova());
            pst.setString(3, objAprovaSol.getTipoAprova());
            pst.setString(4, objAprovaSol.getNomeAprovador());
            pst.setInt(5, codDepto);            
            pst.setString(6, objAprovaSol.getObservacao());
            pst.setString(7, objAprovaSol.getUsuarioInsert());
            pst.setString(8, objAprovaSol.getDataInsert());
            pst.setString(9, objAprovaSol.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel gravar os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAprovaSol;
    }

    public AprovadorSolicitacaoCompra alterarAprovadorSolicitacao(AprovadorSolicitacaoCompra objAprovaSol) {
        pesquisarDepartamento(objAprovaSol.getDescricaoDepartamento());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE APROVADOR_REQUISICAO_MEDICAMENTOS_ENFAR SET FotoFuncAprova=?,StatusAprova=?,TipoAprova=?,NomeAprovador=?,IdDepartamento=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdFuncAprova='" + objAprovaSol.getIdFuncAprova() + "'");
            pst.setString(1, objAprovaSol.getFotoFuncAprova());
            pst.setString(2, objAprovaSol.getStatusAprova());
            pst.setString(3, objAprovaSol.getTipoAprova());
            pst.setString(4, objAprovaSol.getNomeAprovador());
            pst.setInt(5, codDepto);            
            pst.setString(6, objAprovaSol.getObservacao());
            pst.setString(7, objAprovaSol.getUsuarioUp());
            pst.setString(8, objAprovaSol.getDataUp());
            pst.setString(9, objAprovaSol.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel gravar os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAprovaSol;
    }

    public AprovadorSolicitacaoCompra excluirAprovadorSolicitacao(AprovadorSolicitacaoCompra objAprovaSol) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM APROVADOR_REQUISICAO_MEDICAMENTOS_ENFAR WHERE IdFuncAprova='" + objAprovaSol.getIdFuncAprova() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel gravar os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAprovaSol;
    }

    public void pesquisarDepartamento(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM DEPARTAMENTOS WHERE NomeDepartamento='" + nome + "'");
            conecta.rs.first();
            codDepto = conecta.rs.getInt("IdDepartamento");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!.\nERRO: " + ex);
        }
        conecta.desconecta();
    }
}
