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
 * @author ronaldo
 */
public class ControleHistoricoMovimentacaoFAR {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    HistoricoMovimentacaoEstoque objHistMovAC = new HistoricoMovimentacaoEstoque();

    int codLocal;

    // INCLUIR HISTÓRICO DE MOVIMENTAÇÃO DO ESTOQUE PARA CONSULTA DE SALDO DE ESTOQUE

    public HistoricoMovimentacaoEstoque incluirHistoricoProdutoFAR(HistoricoMovimentacaoEstoque objHistMovAC) {
      //  buscarLocalArmazenamento(objHistMovAC.getDescricaoLocal());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO HISTORICO_MOVIMENTACAO_ESTOQUE_FAR (IdProd,IdLocal,TipoOpe,NomeOperacao,IdDoc,DataMov,QtdItem,SaldoAtual) VALUES (?,?,?,?,?,?,?,?)");
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
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR HISTÓRICO DE PRODUTOS... \nERRO: " + ex);
        }
        conecta.desconecta();
        return objHistMovAC;
    }

    public HistoricoMovimentacaoEstoque alterarHistoricoProdutoFAR(HistoricoMovimentacaoEstoque objHistMovAC) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE HISTORICO_MOVIMENTACAO_ESTOQUE_FAR SET IdProd=?,IdLocal=?,TipoOpe=?,NomeOperacao=?,IdDoc=?,DataMov=?,QtdItem=?,SaldoAtual=? WHERE IdProd='" + objHistMovAC.getIdProd() + "'");
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
    public HistoricoMovimentacaoEstoque alterarHistoricoProdutoFARAE(HistoricoMovimentacaoEstoque objHistMovAC) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE HISTORICO_MOVIMENTACAO_ESTOQUE_FAR SET IdProd=?,IdLocal=?,TipoOpe=?,NomeOperacao=?,IdDoc=?,DataMov=?,QtdItem=?,SaldoAtual=? WHERE IdProd='" + objHistMovAC.getIdProd() + "' AND IdDoc='" + objHistMovAC.getIdDoc() + "'");
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

    public HistoricoMovimentacaoEstoque excluirHistoricoProdutoFAR(HistoricoMovimentacaoEstoque objHistMovAC) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM HISTORICO_MOVIMENTACAO_ESTOQUE_FAR WHERE IdProd='" + objHistMovAC.getIdProd() + "' AND IdDoc='");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR HISTÓRICO DE PRODUTOS... \nERRO: " + ex);
        }
        conecta.desconecta();
        return objHistMovAC;
    }

    public void buscarLocalArmazenamento(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM LOCAL_ARMAZENAMENTO_AC WHERE DescricaoLocal='" + nome + "'");
            conecta.rs.first();
            codLocal = conecta.rs.getInt("IdLocal");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (LOCAL DE ARMAZENAMENTO) a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
