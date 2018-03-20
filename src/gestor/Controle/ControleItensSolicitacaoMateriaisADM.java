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
public class ControleItensSolicitacaoMateriaisADM {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensSolicitacaoCompras objItensCompra = new ItensSolicitacaoCompras();
    int codProd;

    public ItensSolicitacaoCompras incluirItensSolicitacaoMaterialADM(ItensSolicitacaoCompras objItensCompra) {
        buscarProduto(objItensCompra.getNomeProduto());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_SOLICITACAO_PRODUTOS_ADM (IdSol,IdProd,CodigoBarras,StatusAprovacao,UnidadeProd,QtdItem,ValorUnitarioItem,ValorTotalItem,AprovaSol,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objItensCompra.getIdSol());
            pst.setInt(2, codProd);
            pst.setString(3, objItensCompra.getCodigoBarras());
            pst.setString(4, objItensCompra.getStatusAprovacao());
            pst.setString(5, objItensCompra.getUnidadeProd());
            pst.setFloat(6, objItensCompra.getQtdItem());
            pst.setFloat(7, objItensCompra.getValorUnitarioItem());
            pst.setFloat(8, objItensCompra.getValorTotalItem());
            pst.setString(9, objItensCompra.getAprovaSolicitacao());
            pst.setString(10, objItensCompra.getUsuarioInsert());
            pst.setString(11, objItensCompra.getDataInsert());
            pst.setString(12, objItensCompra.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR itens da requisição.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensCompra;
    }

    public ItensSolicitacaoCompras alterarItensSolicitacaoMaterialADM(ItensSolicitacaoCompras objItensCompra) {
        buscarProduto(objItensCompra.getNomeProduto());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_SOLICITACAO_PRODUTOS_ADM SET IdSol=?,IdProd=?,CodigoBarras=?,StatusAprovacao=?,UnidadeProd=?,QtdItem=?,ValorUnitarioItem=?,ValorTotalItem=?,AprovaSol=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objItensCompra.getIdItem() + "'");
            pst.setInt(1, objItensCompra.getIdSol());
            pst.setInt(2, codProd);
            pst.setString(3, objItensCompra.getCodigoBarras());
            pst.setString(4, objItensCompra.getStatusAprovacao());
            pst.setString(5, objItensCompra.getUnidadeProd());
            pst.setFloat(6, objItensCompra.getQtdItem());
            pst.setFloat(7, objItensCompra.getValorUnitarioItem());
            pst.setFloat(8, objItensCompra.getValorTotalItem());
            pst.setString(9, objItensCompra.getAprovaSolicitacao());
            pst.setString(10, objItensCompra.getUsuarioUp());
            pst.setString(11, objItensCompra.getDataUp());
            pst.setString(12, objItensCompra.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR itens da requisição.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensCompra;
    }

    public ItensSolicitacaoCompras excluirItensSolicitacaoMaterialADM(ItensSolicitacaoCompras objItensCompra) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_SOLICITACAO_PRODUTOS_ADM WHERE IdProd='" + objItensCompra.getIdProd() + "'AND IdSol='" + objItensCompra.getIdSol() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR itens da requisição.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensCompra;
    }

    //---------------------------- EXCLUIR ITENS NA APROVAÇÃO DE COMPRAS
    public ItensSolicitacaoCompras excluirItensSolicitacaoComprasADM(ItensSolicitacaoCompras objItensCompra) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_SOLICITACAO_COMPRAS_ADM WHERE IdProd='" + objItensCompra.getIdProd() + "'AND IdSol='" + objItensCompra.getIdSol() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR itens da requisição.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensCompra;
    }
    
    //----------------------- GRAVAR OS DADOS DA TABELA ITENS_SOLICITACAO_COMPRAS_ADM NA TABELA ITENS_APROVACAO_COMPRAS_ADM
    public ItensSolicitacaoCompras incluirItensAprovadoADM(ItensSolicitacaoCompras objItensCompra) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_APROVACAO_SOLICITACAO_COMPRAS_ADM (DataAprova,IdAprova,IdProd,QtdAprova,ValorUnitario,ValorTotal,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objItensCompra.getDataAprova().getTime()));
            pst.setInt(2, objItensCompra.getIdAprova());
            pst.setInt(3, objItensCompra.getIdProd());
            pst.setFloat(4, objItensCompra.getQtdItem());
            pst.setFloat(5, objItensCompra.getValorUnitarioItem());
            pst.setFloat(6, objItensCompra.getValorTotalItem());
            pst.setString(7, objItensCompra.getUsuarioInsert());
            pst.setString(8, objItensCompra.getDataInsert());
            pst.setString(9, objItensCompra.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR itens da requisição.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensCompra;
    }

    // ATUALIZAR ITENS APROVADO NA TABELA ITENS_APROVACAO_SOLICITACAO_COMPRAS_ADM

    public ItensSolicitacaoCompras alterarItensAprovadoADM(ItensSolicitacaoCompras objItensCompra) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_APROVACAO_SOLICITACAO_COMPRAS_ADM SET QtdAprova=?,ValorTotal=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdAprova='" + objItensCompra.getIdAprova() + "'AND IdProd='" + objItensCompra.getIdProd() + "'");
            pst.setFloat(1, objItensCompra.getQtdItem());
            pst.setFloat(2, objItensCompra.getValorTotalItem());
            pst.setString(3, objItensCompra.getUsuarioUp());
            pst.setString(4, objItensCompra.getDataUp());
            pst.setString(5, objItensCompra.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR itens da solicitação.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensCompra;
    }

    // EXCLUIR ITEM DA TABELA ITENS_APROVACAO_SOLICITACAO_COMPRAS_ADM
    public ItensSolicitacaoCompras excluirItensAprovadoADM(ItensSolicitacaoCompras objItensCompra) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_APROVACAO_SOLICITACAO_COMPRAS_ADM WHERE IdAprova='" + objItensCompra.getIdAprova() + "'AND IdProd='" + objItensCompra.getIdProd() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR itens da solicitação.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensCompra;
    }

    //------------------------------ MODIFICA O CAMPO DA TABELA ITENS_SOLICITACAO_PRODUTOS_ADM
    public ItensSolicitacaoCompras atualizaCampoAprovaSolicitacaoMaterialADM(ItensSolicitacaoCompras objItensCompra) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_SOLICITACAO_PRODUTOS_ADM SET AprovaSol=?,StatusAprovacao=? WHERE IdSol='" + objItensCompra.getIdSol() + "'AND IdProd='" + objItensCompra.getIdProd() + "'");
            pst.setString(1, objItensCompra.getAprovaSolicitacao());
            pst.setString(2, objItensCompra.getStatusAprovacao());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR campo da solicitação.\nERRO: " + ex);
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
