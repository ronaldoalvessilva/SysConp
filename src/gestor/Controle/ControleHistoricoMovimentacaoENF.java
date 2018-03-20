/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.HistoricoMovimentacaoEstoque;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleHistoricoMovimentacaoENF {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    HistoricoMovimentacaoEstoque objHistMovAC = new HistoricoMovimentacaoEstoque();

    // INCLUIR HISTÓRICO DE MOVIMENTAÇÃO DO ESTOQUE PARA CONSULTA DE SALDO DE ESTOQUE
    public HistoricoMovimentacaoEstoque incluirHistoricoProdutoENF(HistoricoMovimentacaoEstoque objHistMovAC) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO HISTORICO_MOVIMENTACAO_ESTOQUE_ENF (IdProd,IdLocal,TipoOpe,NomeOperacao,IdDoc,DataMov,QtdItem,SaldoAtual) VALUES (?,?,?,?,?,?,?,?)");
            pst.setInt(1, objHistMovAC.getIdProd());
            pst.setInt(2, objHistMovAC.getIdLocal());
            pst.setString(3, objHistMovAC.getTipoOpe());
            pst.setString(4, objHistMovAC.getNomeOperacao());
            pst.setInt(5, objHistMovAC.getIdDoc());
            pst.setTimestamp(6, new java.sql.Timestamp(objHistMovAC.getDataMov().getTime()));
            pst.setFloat(7, objHistMovAC.getQtdItem());
            pst.setFloat(8, objHistMovAC.getSaldoAtual());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR HISTÓRICO DE PRODUTOS... \nERRO: " + ex);
        }
        conecta.desconecta();
        return objHistMovAC;
    }

    public HistoricoMovimentacaoEstoque alterarHistoricoProdutoENF(HistoricoMovimentacaoEstoque objHistMovAC) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE HISTORICO_MOVIMENTACAO_ESTOQUE_ENF SET IdProd=?,IdLocal=?,TipoOpe=?,NomeOperacao=?,IdDoc=?,DataMov=?,QtdItem=?,SaldoAtual=? WHERE IdProd='" + objHistMovAC.getIdProd() + "'");
            pst.setInt(1, objHistMovAC.getIdProd());
            pst.setInt(2, objHistMovAC.getIdLocal());
            pst.setString(3, objHistMovAC.getTipoOpe());
            pst.setString(4, objHistMovAC.getNomeOperacao());
            pst.setInt(5, objHistMovAC.getIdDoc());
            if (objHistMovAC.getDataMov() != null) {
                pst.setTimestamp(6, new java.sql.Timestamp(objHistMovAC.getDataMov().getTime()));
            } else {
                pst.setDate(6, null);
            }
            pst.setFloat(7, objHistMovAC.getQtdItem());
            pst.setFloat(8, objHistMovAC.getSaldoAtual());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR HISTÓRICO DE PRODUTOS... \nERRO: " + ex);
        }
        conecta.desconecta();
        return objHistMovAC;
    }

    public HistoricoMovimentacaoEstoque excluirHistoricoProdutoENF(HistoricoMovimentacaoEstoque objHistMovAC) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM HISTORICO_MOVIMENTACAO_ESTOQUE_ENF WHERE IdProd='" + objHistMovAC.getIdProd() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR HISTÓRICO DE PRODUTOS... \nERRO: " + ex);
        }
        conecta.desconecta();
        return objHistMovAC;
    }
}
