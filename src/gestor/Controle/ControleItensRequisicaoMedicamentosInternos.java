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
 * @author Ronaldo
 */
public class ControleItensRequisicaoMedicamentosInternos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensRequisicaoMateriaisInternos objItensReqMatInter = new ItensRequisicaoMateriaisInternos();
    int codProd;

    public ItensRequisicaoMateriaisInternos incluirRequisicaoMaterialInternos(ItensRequisicaoMateriaisInternos objItensReqMatInter) {
        buscarProduto(objItensReqMatInter.getDescricaoProduto());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_REQUISICAO_PRODUTOS_INTERNOS_ENF (IdReq,IdProd,CodigoBarras,UnidadeProd,QtdItem,QtdDosesAT,ValorUnitarioItem,ValorTotalItem,EstornoProduto,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objItensReqMatInter.getIdReq());
            pst.setInt(2, codProd);
            pst.setString(3, objItensReqMatInter.getCodigoBarras());
            pst.setString(4, objItensReqMatInter.getUnidadeProd());
            pst.setFloat(5, objItensReqMatInter.getQtdItem());
            pst.setInt(6, objItensReqMatInter.getQtdDoses());
            pst.setFloat(7, objItensReqMatInter.getValorUnitarioItem());
            pst.setFloat(8, objItensReqMatInter.getValorTotalItem());
            pst.setString(9, objItensReqMatInter.getEstornoProduto());
            pst.setString(10, objItensReqMatInter.getUsuarioInsert());
            pst.setString(11, objItensReqMatInter.getDataInsert());
            pst.setString(12, objItensReqMatInter.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR itens da requisição.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensReqMatInter;
    }

    public ItensRequisicaoMateriaisInternos alterarRequisicaoMaterialInternos(ItensRequisicaoMateriaisInternos objItensReqMatInter) {
        buscarProduto(objItensReqMatInter.getDescricaoProduto());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_REQUISICAO_PRODUTOS_INTERNOS_ENF SET IdReq=?,IdProd=?,CodigoBarras=?,UnidadeProd=?,QtdItem=?,QtdDosesAT=?,ValorUnitarioItem=?,ValorTotalItem=?,EstornoProduto=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objItensReqMatInter.getIdItem() + "'");
            pst.setInt(1, objItensReqMatInter.getIdReq());
            pst.setInt(2, codProd);
            pst.setString(3, objItensReqMatInter.getCodigoBarras());
            pst.setString(4, objItensReqMatInter.getUnidadeProd());
            pst.setFloat(5, objItensReqMatInter.getQtdItem());
            pst.setInt(6, objItensReqMatInter.getQtdDoses());
            pst.setFloat(7, objItensReqMatInter.getValorUnitarioItem());
            pst.setFloat(8, objItensReqMatInter.getValorTotalItem());
            pst.setString(9, objItensReqMatInter.getEstornoProduto());
            pst.setString(10, objItensReqMatInter.getUsuarioUp());
            pst.setString(11, objItensReqMatInter.getDataUp());
            pst.setString(12, objItensReqMatInter.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR itens da requisição.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensReqMatInter;
    }

    public ItensRequisicaoMateriaisInternos excluirRequisicaoMaterialInternos(ItensRequisicaoMateriaisInternos objItensReqMatInter) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_REQUISICAO_PRODUTOS_INTERNOS_ENF WHERE IdItem='" + objItensReqMatInter.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR itens da requisição.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensReqMatInter;
    }

    // ALTERAR O SALDO DE PRODUTOS NA TABELA LOTE_PRODUTOS_ENF
    public ItensRequisicaoMateriaisInternos alterarEstoqueMaterais(ItensRequisicaoMateriaisInternos objItensReqMatInter) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE LOTE_PRODUTOS_ENF SET Qtd=? WHERE IdProd='" + objItensReqMatInter.getIdProd() + "'AND Lote='" + objItensReqMatInter.getLoteProduto() + "'");
            pst.setFloat(1, objItensReqMatInter.getQtdItem());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR saldo de estoque.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensReqMatInter;
    }

    // ALTERAR TABELA ITENS_REQUISICAO_PRODUTOS_INTERNOS_SEAC   SE FOI UTILIZADO
//    public ItensRequisicaoMateriaisInternos alterarUtilizacaoMaterais(ItensRequisicaoMateriaisInternos objItensReqMatInter) {
//
//        conecta.abrirConexao();
//        try {
//            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_REQUISICAO_PRODUTOS_INTERNOS_SEAC SET ReqAtend=? WHERE IdProd='" + objItensReqMatInter.getIdProd() + "'AND IdReq='" + objItensReqMatInter.getIdReq() + "'");
//            pst.setString(1, objItensReqMatInter.getAtendReq());
//            pst.executeUpdate();
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR saldo de estoque.\nERRO: " + ex);
//        }
//        conecta.desconecta();
//        return objItensReqMatInter;
//    }

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
