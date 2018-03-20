/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensSolicitacaoCompras;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleItensSolicitacaoMateriaisNUTRI {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensSolicitacaoCompras objItensCompra = new ItensSolicitacaoCompras();
    int codProd;

    public ItensSolicitacaoCompras incluirItensSolicitacaoMaterialNUTRI(ItensSolicitacaoCompras objItensCompra) {
        buscarProduto(objItensCompra.getNomeProduto());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_SOLICITACAO_PRODUTOS_NUTRI (IdSol,IdProd,CodigoBarras,UnidadeProd,QtdItem,ValorUnitarioItem,ValorTotalItem,AprovaSol,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objItensCompra.getIdSol());
            pst.setInt(2, codProd);
            pst.setString(3, objItensCompra.getCodigoBarras());
            pst.setString(4, objItensCompra.getUnidadeProd());
            pst.setFloat(5, objItensCompra.getQtdItem());
            pst.setFloat(6, objItensCompra.getValorUnitarioItem());
            pst.setFloat(7, objItensCompra.getValorTotalItem());
            pst.setString(8, objItensCompra.getAprovaSolicitacao());
            pst.setString(9, objItensCompra.getUsuarioInsert());
            pst.setString(10, objItensCompra.getDataInsert());
            pst.setString(11, objItensCompra.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR itens da requisição.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensCompra;
    }

    public ItensSolicitacaoCompras alterarItensSolicitacaoMaterialNUTRI(ItensSolicitacaoCompras objItensCompra) {
        buscarProduto(objItensCompra.getNomeProduto());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_SOLICITACAO_PRODUTOS_NUTRI SET IdSol=?,IdProd=?,CodigoBarras=?,UnidadeProd=?,QtdItem=?,ValorUnitarioItem=?,ValorTotalItem=?,AprovaSol=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objItensCompra.getIdItem() + "'");
            pst.setInt(1, objItensCompra.getIdSol());
            pst.setInt(2, codProd);
            pst.setString(3, objItensCompra.getCodigoBarras());
            pst.setString(4, objItensCompra.getUnidadeProd());
            pst.setFloat(5, objItensCompra.getQtdItem());
            pst.setFloat(6, objItensCompra.getValorUnitarioItem());
            pst.setFloat(7, objItensCompra.getValorTotalItem());
            pst.setString(8, objItensCompra.getAprovaSolicitacao());
            pst.setString(9, objItensCompra.getUsuarioUp());
            pst.setString(10, objItensCompra.getDataUp());
            pst.setString(11, objItensCompra.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR itens da requisição.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensCompra;
    }

    public ItensSolicitacaoCompras excluirItensSolicitacaoMaterialNUTRI(ItensSolicitacaoCompras objItensCompra) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_SOLICITACAO_PRODUTOS_NUTRI WHERE IdItem='" + objItensCompra.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR itens da requisição.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensCompra;
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
