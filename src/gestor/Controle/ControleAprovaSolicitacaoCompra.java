/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AprovarSolicitacaoCompras;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleAprovaSolicitacaoCompra {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AprovarSolicitacaoCompras objAprovaSol = new AprovarSolicitacaoCompras();

    public AprovarSolicitacaoCompras incluirAprovacaoSolicitacao(AprovarSolicitacaoCompras objAprovaSol) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO APROVACAO_SOLICITACAO_COMPRAS_ADM (StatusAprova,DataAprova,UsuarioAprovador,IdSol,Observacao,ValorSolicitado,ValorAutorizado,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objAprovaSol.getStatusAprova());
            pst.setTimestamp(2, new java.sql.Timestamp(objAprovaSol.getDataAprova().getTime()));
            pst.setString(3, objAprovaSol.getNomeUsuarioAprovador());
            pst.setInt(4, objAprovaSol.getIdSol());
            pst.setString(5, objAprovaSol.getObservacao());
            pst.setFloat(6, objAprovaSol.getValorTotalSolicitacao());
            pst.setFloat(7, objAprovaSol.getValorTotalAprovado());
            pst.setString(8, objAprovaSol.getUsuarioInsert());
            pst.setString(9, objAprovaSol.getDataInsert());
            pst.setString(10, objAprovaSol.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAprovaSol;
    }

    public AprovarSolicitacaoCompras alterarAprovacaoSolicitacao(AprovarSolicitacaoCompras objAprovaSol) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE APROVACAO_SOLICITACAO_COMPRAS_ADM SET StatusAprova=?,DataAprova=?,UsuarioAprovador=?,IdSol=?,Observacao=?,ValorSolicitado=?,ValorAutorizado=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdAprova='" + objAprovaSol.getIdAprova() + "'");
            pst.setString(1, objAprovaSol.getStatusAprova());
            pst.setTimestamp(2, new java.sql.Timestamp(objAprovaSol.getDataAprova().getTime()));
            pst.setString(3, objAprovaSol.getNomeUsuarioAprovador());
            pst.setInt(4, objAprovaSol.getIdSol());
            pst.setString(5, objAprovaSol.getObservacao());
            pst.setFloat(6, objAprovaSol.getValorTotalSolicitacao());
            pst.setFloat(7, objAprovaSol.getValorTotalAprovado());
            pst.setString(8, objAprovaSol.getUsuarioUp());
            pst.setString(9, objAprovaSol.getDataUp());
            pst.setString(10, objAprovaSol.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ATERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAprovaSol;
    }

    public AprovarSolicitacaoCompras excluirAprovacaoSolicitacao(AprovarSolicitacaoCompras objAprovaSol) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM APROVACAO_SOLICITACAO_COMPRAS_ADM WHERE IdAprova='" + objAprovaSol.getIdAprova() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAprovaSol;
    }
    
     public AprovarSolicitacaoCompras finalizarAprovacaoSolicitacao(AprovarSolicitacaoCompras objAprovaSol) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE APROVACAO_SOLICITACAO_COMPRAS_ADM SET StatusAprova=? WHERE IdAprova='" + objAprovaSol.getIdAprova() + "'");
            pst.setString(1, objAprovaSol.getStatusAprova());                      
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível FINALIZAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAprovaSol;
    }
}
