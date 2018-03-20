/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensRequisicaoMateriaisInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleItensEstornoMateriaisFAR {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensRequisicaoMateriaisInternos objItensReqMatInter = new ItensRequisicaoMateriaisInternos();
    int codProd;

    public ItensRequisicaoMateriaisInternos incluirItensEstornoTransReqFAR(ItensRequisicaoMateriaisInternos objItensReqMatInter) {
        buscarProduto(objItensReqMatInter.getDescricaoProduto());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_ESTORNO_PRODUTOS_FAR (IdEst,IdProd,CodigoBarras,UnidadeProd,QtdItem,ValorUnitarioItem,ValorTotalItem,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objItensReqMatInter.getIdReq());
            pst.setInt(2, codProd);
            pst.setString(3, objItensReqMatInter.getCodigoBarras());
            pst.setString(4, objItensReqMatInter.getUnidadeProd());
            pst.setFloat(5, objItensReqMatInter.getQtdItem());
            pst.setFloat(6, objItensReqMatInter.getValorUnitarioItem());
            pst.setFloat(7, objItensReqMatInter.getValorTotalItem());
            pst.setString(8, objItensReqMatInter.getUsuarioInsert());
            pst.setString(9, objItensReqMatInter.getDataInsert());
            pst.setString(10, objItensReqMatInter.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR itens da requisição.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensReqMatInter;
    }

    public ItensRequisicaoMateriaisInternos alterarItensEstornoTransReqFAR(ItensRequisicaoMateriaisInternos objItensReqMatInter) {
        buscarProduto(objItensReqMatInter.getDescricaoProduto());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_ESTORNO_PRODUTOS_FAR SET IdEst=?,IdProd=?,CodigoBarras=?,UnidadeProd=?,QtdItem=?,ValorUnitarioItem=?,ValorTotalItem=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objItensReqMatInter.getIdItem() + "'");
            pst.setInt(1, objItensReqMatInter.getIdReq());
            pst.setInt(2, codProd);
            pst.setString(3, objItensReqMatInter.getCodigoBarras());
            pst.setString(4, objItensReqMatInter.getUnidadeProd());
            pst.setFloat(5, objItensReqMatInter.getQtdItem());
            pst.setFloat(6, objItensReqMatInter.getValorUnitarioItem());
            pst.setFloat(7, objItensReqMatInter.getValorTotalItem());
            pst.setString(8, objItensReqMatInter.getUsuarioUp());
            pst.setString(9, objItensReqMatInter.getDataUp());
            pst.setString(10, objItensReqMatInter.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR itens da requisição.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensReqMatInter;
    }

    public ItensRequisicaoMateriaisInternos excluirItensEstornoTransReqFAR(ItensRequisicaoMateriaisInternos objItensReqMatInter) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_ESTORNO_PRODUTOS_FAR WHERE IdItem='" + objItensReqMatInter.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR itens da requisição.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensReqMatInter;
    }

    // ALTERAR O SALDO DE PRODUTOS NA TABELA LOTEPRODUTOS FARMACIA
    public ItensRequisicaoMateriaisInternos alterarEstoqueMateraisFAR(ItensRequisicaoMateriaisInternos objItensReqMatInter) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE LOTE_PRODUTOS_AC SET Qtd=? WHERE IdProd='" + objItensReqMatInter.getIdProd() + "'AND Lote='" + objItensReqMatInter.getLoteProduto() + "'");
            pst.setFloat(1, objItensReqMatInter.getQtdItem());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR saldo de estoque.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensReqMatInter;
    }

    public ItensRequisicaoMateriaisInternos modificarRequisicaoMaterialAvulsoEstorno(ItensRequisicaoMateriaisInternos objItensReqMatInter) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_REQUISICAO_AVULSA_PRODUTOS_FAR  SET EstornoProduto=? WHERE IdProd='" + objItensReqMatInter.getIdProd() + "'AND IdReq='" + objItensReqMatInter.getIdReq() + "'");
            pst.setString(1, objItensReqMatInter.getEstornoProduto());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR itens da requisição.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensReqMatInter;
    }

    public ItensRequisicaoMateriaisInternos modificarTransferenciaEstoqueFAR(ItensRequisicaoMateriaisInternos objItensReqMatInter) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_TRANSFERENCIA_PRODUTO_FAR  SET EstornoProduto=? WHERE IdProd='" + objItensReqMatInter.getIdProd() + "'AND IdLanc='" + objItensReqMatInter.getIdReq() + "'");
            pst.setString(1, objItensReqMatInter.getEstornoProduto());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR itens da transferência.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensReqMatInter;
    }

    public ItensRequisicaoMateriaisInternos modificarEstoqueEnfermariaFAR(ItensRequisicaoMateriaisInternos objItensReqMatInter) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE LOTE_PRODUTOS_ENF  SET Qtd=? WHERE IdProd='" + objItensReqMatInter.getIdProd() + "'AND IdLanc='" + objItensReqMatInter.getIdReq() + "'AND Lote='" +  objItensReqMatInter.getLoteProduto()  + "'");
            pst.setFloat(1, objItensReqMatInter.getQtdItem());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR itens da transferência.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensReqMatInter;
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
}
