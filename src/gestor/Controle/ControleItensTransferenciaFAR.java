/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensProdutoTransferenciaLocal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleItensTransferenciaFAR {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensProdutoTransferenciaLocal objItensTranProd = new ItensProdutoTransferenciaLocal();
    int codProd;
    int codLocal;

    public ItensProdutoTransferenciaLocal incluirItensTransferenciaFAR(ItensProdutoTransferenciaLocal objItensTranProd) {
        buscarProduto(objItensTranProd.getDescricaoProduto());
        buscarLocalArmazenamento(objItensTranProd.getNomeLocal());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_TRANSFERENCIA_PRODUTO_FAR (IdLanc,IdProd,IdLocal,CodigoBarras,UnidadeProd,Lote,QtdItem,ValorUN,ValorTotal,UsuarioInsert,DataInsert,HorarioInsert,IdItemLote,DataVencLote) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objItensTranProd.getIdLanc());
            pst.setInt(2, codProd);
            pst.setInt(3, codLocal);
            pst.setString(4, objItensTranProd.getCodigoBarras());
            pst.setString(5, objItensTranProd.getUnidadeProd());
            pst.setString(6, objItensTranProd.getLoteProduto());
            pst.setFloat(7, objItensTranProd.getQtdItem());
            pst.setFloat(8, objItensTranProd.getValorUN());
            pst.setFloat(9, objItensTranProd.getValorTotal());
            pst.setString(10, objItensTranProd.getUsuarioInsert());
            pst.setString(11, objItensTranProd.getDataInsert());
            pst.setString(12, objItensTranProd.getHorarioInsert());
            pst.setInt(13, objItensTranProd.getIdItemTrans());
            pst.setTimestamp(14, new java.sql.Timestamp(objItensTranProd.getDataVctoLote().getTime()));
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR itens da requisição.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensTranProd;
    }

    public ItensProdutoTransferenciaLocal alterarItensTransferenciaFAR(ItensProdutoTransferenciaLocal objItensTranProd) {
        buscarProduto(objItensTranProd.getDescricaoProduto());
        buscarLocalArmazenamento(objItensTranProd.getNomeLocal());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_TRANSFERENCIA_PRODUTO_FAR SET IdLanc=?,IdProd=?,IdLocal=?,CodigoBarras=?,UnidadeProd=?,Lote=?,QtdItem=?,ValorUN=?,ValorTotal=?,UsuarioUp=?,DataUp=?,HorarioUp=?,IdItemLote=?,DataVencLote=? WHERE IdItem='" + objItensTranProd.getIdItem() + "'");
            pst.setInt(1, objItensTranProd.getIdLanc());
            pst.setInt(2, codProd);
            pst.setInt(3, codLocal);
            pst.setString(4, objItensTranProd.getCodigoBarras());
            pst.setString(5, objItensTranProd.getUnidadeProd());
            pst.setString(6, objItensTranProd.getLoteProduto());
            pst.setFloat(7, objItensTranProd.getQtdItem());
            pst.setFloat(8, objItensTranProd.getValorUN());
            pst.setFloat(9, objItensTranProd.getValorTotal());
            pst.setString(10, objItensTranProd.getUsuarioUp());
            pst.setString(11, objItensTranProd.getDataUp());
            pst.setString(12, objItensTranProd.getHorarioUp());
            pst.setInt(13, objItensTranProd.getIdItemTrans());
            pst.setTimestamp(14, new java.sql.Timestamp(objItensTranProd.getDataVctoLote().getTime()));
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR itens da requisição.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensTranProd;
    }

    public ItensProdutoTransferenciaLocal excluirItensTransferenciaFAR(ItensProdutoTransferenciaLocal objItensTranProd) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_TRANSFERENCIA_PRODUTO_FAR WHERE IdItem='" + objItensTranProd.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR itens da requisição.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensTranProd;
    }

    // ALTERAR O SALDO DE PRODUTOS NA TABELA LOTE_PRODUTOS_AC FARMACIA
    public ItensProdutoTransferenciaLocal alterarEstoqueProduto(ItensProdutoTransferenciaLocal objItensTranProd) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE LOTE_PRODUTOS_AC SET Qtd=? WHERE IdProd='" + objItensTranProd.getIdProd() + "'AND Lote='" + objItensTranProd.getLoteProduto() + "'AND IdItem='" + objItensTranProd.getIdItemTrans()+ "'");
            pst.setFloat(1, objItensTranProd.getQtdItem());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR saldo de estoque.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensTranProd;
    }

    // ALTERAR TABELA ITENS_REQUISICAO_PRODUTOS_ENFERMARIA_FAR  SE FOI UTILIZADO
    public ItensProdutoTransferenciaLocal alterarUtilizacaoRequisicaoTrans(ItensProdutoTransferenciaLocal objItensTranProd) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_REQUISICAO_PRODUTOS_ENFERMARIA_ENFAR SET ReqAtend=? WHERE IdProd='" + objItensTranProd.getIdProd() + "'AND IdSol='" + objItensTranProd.getIdReqFar() + "'");
            pst.setString(1, objItensTranProd.getAtendeReqEnfermaria());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR saldo de estoque.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensTranProd;
    }

    // ATUALIZA O SALDO DOS PRODUTOS NA TABELA DE LOTE_PRODUTOS_ENF

    public ItensProdutoTransferenciaLocal adicionarLoteEnfermaria(ItensProdutoTransferenciaLocal objItensTranProd) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO LOTE_PRODUTOS_ENF (IdProd,IdLanc,DataVenc,Lote,Qtd,IdItemLote) VALUES(?,?,?,?,?,?)");
            pst.setInt(1, objItensTranProd.getIdProd());
            pst.setInt(2, objItensTranProd.getIdLanc());
            pst.setTimestamp(3, new java.sql.Timestamp(objItensTranProd.getDataVctoLote().getTime()));
            pst.setString(4, objItensTranProd.getLoteProduto());
            pst.setFloat(5, objItensTranProd.getQtdItem());
            pst.setInt(6, objItensTranProd.getIdItem());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INCLUIR Lote da Enfermaria.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensTranProd;
    }

    public ItensProdutoTransferenciaLocal modificarLoteEnfermaria(ItensProdutoTransferenciaLocal objItensTranProd) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE LOTE_PRODUTOS_ENF SET Qtd=? WHERE IdProd='" + objItensTranProd.getIdProd() + "'AND Lote='" + objItensTranProd.getLoteProduto() + "'");
            pst.setFloat(1, objItensTranProd.getQtdItem());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR Lote da Enfermaria.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensTranProd;
    }

    public void buscarProduto(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRODUTOS_AC WHERE DescricaoProd='" + nome + "'");
            conecta.rs.first();
            codProd = conecta.rs.getInt("IdProd");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados do PRODUTO a ser exibido !!!");
        }
        conecta.desconecta();
    }

    public void buscarLocalArmazenamento(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM LOCAL_ARMAZENAMENTO_AC WHERE DescricaoLocal='" + nome + "'");
            conecta.rs.first();
            codLocal = conecta.rs.getInt("IdLocal");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados do LOCAL ARMAZENAMENTO a ser exibido !!!");
        }
        conecta.desconecta();
    }
}
