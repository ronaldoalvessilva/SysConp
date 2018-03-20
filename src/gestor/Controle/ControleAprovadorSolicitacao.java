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
public class ControleAprovadorSolicitacao {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AprovadorSolicitacaoCompra objAprovaSol = new AprovadorSolicitacaoCompra();

    int codFunc;

    public AprovadorSolicitacaoCompra incluirAprovadorSolicitacao(AprovadorSolicitacaoCompra objAprovaSol) {
        pesquisarColaborador(objAprovaSol.getNomeColaborador());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO APROVADOR_SOLICITACAO_COMPRAS_AC (StatusAprova,TipoAprova,NomeAprovador,IdFunc,ValorSolicita,ValorPedido,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?)");            
            pst.setString(1, objAprovaSol.getStatusAprova());
            pst.setString(2, objAprovaSol.getTipoAprova());
            pst.setString(3, objAprovaSol.getNomeAprovador());
            pst.setInt(4, codFunc);
            pst.setFloat(5, objAprovaSol.getValorSolicita());
            pst.setFloat(6, objAprovaSol.getValorPedido());
            pst.setString(7, objAprovaSol.getObservacao());
            pst.setString(8, objAprovaSol.getUsuarioInsert());
            pst.setString(9, objAprovaSol.getDataInsert());
            pst.setString(10, objAprovaSol.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel gravar os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAprovaSol;
    }

    public AprovadorSolicitacaoCompra alterarAprovadorSolicitacao(AprovadorSolicitacaoCompra objAprovaSol) {
        pesquisarColaborador(objAprovaSol.getNomeColaborador());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE APROVADOR_SOLICITACAO_COMPRAS_AC SET StatusAprova=?,TipoAprova=?,NomeAprovador=?,IdFunc=?,ValorSolicita=?,ValorPedido=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdFuncAprova='" + objAprovaSol.getIdFuncAprova() + "'");
            pst.setString(1, objAprovaSol.getStatusAprova());
            pst.setString(2, objAprovaSol.getTipoAprova());
            pst.setString(3, objAprovaSol.getNomeAprovador());
            pst.setInt(4, codFunc);
            pst.setFloat(5, objAprovaSol.getValorSolicita());
            pst.setFloat(6, objAprovaSol.getValorPedido());
            pst.setString(7, objAprovaSol.getObservacao());
            pst.setString(8, objAprovaSol.getUsuarioUp());
            pst.setString(9, objAprovaSol.getDataUp());
            pst.setString(10, objAprovaSol.getHorarioUp());
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
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM APROVADOR_SOLICITACAO_COMPRAS_AC WHERE IdFuncAprova='" + objAprovaSol.getIdFuncAprova() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel gravar os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAprovaSol;
    }

    public void pesquisarColaborador(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM COLABORADOR WHERE NomeFunc='" + nome + "'");
            conecta.rs.first();
            codFunc = conecta.rs.getInt("IdFunc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!.\nERRO: " + ex);
        }
        conecta.desconecta();
    }
}
