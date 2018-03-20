/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensRequisicaoMateriaisInternosSEAC;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleItensRequisicaoMateriaisInternosSEAC {
      ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensRequisicaoMateriaisInternosSEAC objItensReqMatInterSEAC = new ItensRequisicaoMateriaisInternosSEAC();
    int codProd;

    public ItensRequisicaoMateriaisInternosSEAC incluirRequisicaoMaterialInternosSEAC(ItensRequisicaoMateriaisInternosSEAC objItensReqMatInterSEAC) {
        buscarProduto(objItensReqMatInterSEAC.getDescricaoProduto());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_REQUISICAO_PRODUTOS_INTERNOS_SEAC (IdReq,IdProd,CodigoBarras,UnidadeProd,QtdItem,ValorUnitarioItem,ValorTotalItem,ReqAtend,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objItensReqMatInterSEAC.getIdReq());
            pst.setInt(2, codProd);
            pst.setString(3, objItensReqMatInterSEAC.getCodigoBarras());
            pst.setString(4, objItensReqMatInterSEAC.getUnidadeProd());
            pst.setFloat(5, objItensReqMatInterSEAC.getQtdItem());
            pst.setFloat(6, objItensReqMatInterSEAC.getValorUnitarioItem());
            pst.setFloat(7, objItensReqMatInterSEAC.getValorTotalItem());
            pst.setString(8, objItensReqMatInterSEAC.getUtilizaRequisicao());
            pst.setString(9, objItensReqMatInterSEAC.getUsuarioInsert());
            pst.setString(10, objItensReqMatInterSEAC.getDataInsert());
            pst.setString(11, objItensReqMatInterSEAC.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR itens da requisição.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensReqMatInterSEAC;
    }

    public ItensRequisicaoMateriaisInternosSEAC alterarRequisicaoMaterialInternosSEAC(ItensRequisicaoMateriaisInternosSEAC objItensReqMatInterSEAC) {
        buscarProduto(objItensReqMatInterSEAC.getDescricaoProduto());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_REQUISICAO_PRODUTOS_INTERNOS_SEAC SET IdReq=?,IdProd=?,CodigoBarras=?,UnidadeProd=?,QtdItem=?,ValorUnitarioItem=?,ValorTotalItem=?,ReqAtend=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objItensReqMatInterSEAC.getIdItem() + "'");
            pst.setInt(1, objItensReqMatInterSEAC.getIdReq());
            pst.setInt(2, codProd);
            pst.setString(3, objItensReqMatInterSEAC.getCodigoBarras());
            pst.setString(4, objItensReqMatInterSEAC.getUnidadeProd());
            pst.setFloat(5, objItensReqMatInterSEAC.getQtdItem());
            pst.setFloat(6, objItensReqMatInterSEAC.getValorUnitarioItem());
            pst.setFloat(7, objItensReqMatInterSEAC.getValorTotalItem());
            pst.setString(8, objItensReqMatInterSEAC.getUtilizaRequisicao());
            pst.setString(9, objItensReqMatInterSEAC.getUsuarioUp());
            pst.setString(10, objItensReqMatInterSEAC.getDataUp());
            pst.setString(11, objItensReqMatInterSEAC.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR itens da requisição.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensReqMatInterSEAC;
    }

    public ItensRequisicaoMateriaisInternosSEAC excluirRequisicaoMaterialInternosSEAC(ItensRequisicaoMateriaisInternosSEAC objItensReqMatInterSEAC) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_REQUISICAO_PRODUTOS_INTERNOS_SEAC WHERE IdItem='" + objItensReqMatInterSEAC.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR itens da requisição.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensReqMatInterSEAC;
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
