/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.NotaFiscalCompra;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleNFeComprasNUTRI {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    NotaFiscalCompra objNFEComprasv = new NotaFiscalCompra();

    int codForn;

    public NotaFiscalCompra incluirNFeComprasNUTRI(NotaFiscalCompra objNFEComprasv) {
        buscarFornecedor(objNFEComprasv.getNomeFornecedor());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO NF_COMPRAS_NUTRI "
                    + "(Modelo,SerieNf,NumeroNf,StatusNf,IdLocal,IdForn,DataEmissao,Tipodocumento,FormaPagamento, "
                    + "DataEntrada,BaseCalculoICMS,ValorICMS,BaseCalculoICMSSub,ValorICMSSub,ValorTotalProdutos, "
                    + "ValorTotalFrete,ValorTotalSeguro,ValorTotalDesconto,ValorTotalIPI,ValorTotalNFE,ObservacaoNF, "
                    + "UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objNFEComprasv.getModelo());
            pst.setString(2, objNFEComprasv.getSerieNf());
            pst.setString(3, objNFEComprasv.getNumeroNf());
            pst.setString(4, objNFEComprasv.getStatusNf());
            pst.setInt(5, objNFEComprasv.getIdLocal());
            pst.setInt(6, codForn);
            pst.setTimestamp(7, new java.sql.Timestamp(objNFEComprasv.getDataEmissao().getTime()));
            pst.setString(8, objNFEComprasv.getTipodocumento());
            pst.setString(9, objNFEComprasv.getFormaPagamento());
            pst.setTimestamp(10, new java.sql.Timestamp(objNFEComprasv.getDataEntrada().getTime()));
            pst.setFloat(11, objNFEComprasv.getBaseCalculoICMS());
            pst.setFloat(12, objNFEComprasv.getValorICMS());
            pst.setFloat(13, objNFEComprasv.getBaseCalculoICMSSub());
            pst.setFloat(14, objNFEComprasv.getValorICMSSub());
            pst.setFloat(15, objNFEComprasv.getValorTotalProdutos());
            pst.setFloat(16, objNFEComprasv.getValorTotalFrete());
            pst.setFloat(17, objNFEComprasv.getValorTotalSeguro());
            pst.setFloat(18, objNFEComprasv.getValorTotalDesconto());
            pst.setFloat(19, objNFEComprasv.getValorTotalIPI());
            pst.setFloat(20, objNFEComprasv.getValorTotalNFE());
            pst.setString(21, objNFEComprasv.getObservacaoNF());
            pst.setString(22, objNFEComprasv.getUsuarioInsert());
            pst.setString(23, objNFEComprasv.getDataInsert());
            pst.setString(24, objNFEComprasv.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objNFEComprasv;
    }

    public NotaFiscalCompra alterarNFeComprasNUTRI(NotaFiscalCompra objNFEComprasv) {
        buscarFornecedor(objNFEComprasv.getNomeFornecedor());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE NF_COMPRAS_NUTRI SET "
                    + "Modelo=?,SerieNf=?,NumeroNf=?,StatusNf=?,IdLocal=?,IdForn=?,DataEmissao=?,Tipodocumento=?,FormaPagamento=?, "
                    + "DataEntrada=?,BaseCalculoICMS=?,ValorICMS=?,BaseCalculoICMSSub=?,ValorICMSSub=?,ValorTotalProdutos=?, "
                    + "ValorTotalFrete=?,ValorTotalSeguro=?,ValorTotalDesconto=?,ValorTotalIPI=?,ValorTotalNFE=?,ObservacaoNF=?, "
                    + "UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdNfEntrada='" + objNFEComprasv.getIdNfEntrada() + "'");
            pst.setString(1, objNFEComprasv.getModelo());
            pst.setString(2, objNFEComprasv.getSerieNf());
            pst.setString(3, objNFEComprasv.getNumeroNf());
            pst.setString(4, objNFEComprasv.getStatusNf());
            pst.setInt(5, objNFEComprasv.getIdLocal());
            pst.setInt(6, codForn);
            pst.setTimestamp(7, new java.sql.Timestamp(objNFEComprasv.getDataEmissao().getTime()));
            pst.setString(8, objNFEComprasv.getTipodocumento());
            pst.setString(9, objNFEComprasv.getFormaPagamento());
            pst.setTimestamp(10, new java.sql.Timestamp(objNFEComprasv.getDataEntrada().getTime()));
            pst.setFloat(11, objNFEComprasv.getBaseCalculoICMS());
            pst.setFloat(12, objNFEComprasv.getValorICMS());
            pst.setFloat(13, objNFEComprasv.getBaseCalculoICMSSub());
            pst.setFloat(14, objNFEComprasv.getValorICMSSub());
            pst.setFloat(15, objNFEComprasv.getValorTotalProdutos());
            pst.setFloat(16, objNFEComprasv.getValorTotalFrete());
            pst.setFloat(17, objNFEComprasv.getValorTotalSeguro());
            pst.setFloat(18, objNFEComprasv.getValorTotalDesconto());
            pst.setFloat(19, objNFEComprasv.getValorTotalIPI());
            pst.setFloat(20, objNFEComprasv.getValorTotalNFE());
            pst.setString(21, objNFEComprasv.getObservacaoNF());
            pst.setString(22, objNFEComprasv.getUsuarioUp());
            pst.setString(23, objNFEComprasv.getDataUp());
            pst.setString(24, objNFEComprasv.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objNFEComprasv;
    }

    public NotaFiscalCompra excluirNFeComprasNUTRI(NotaFiscalCompra objNFEComprasv) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM NF_COMPRAS_NUTRI WHERE IdNfEntrada='" + objNFEComprasv.getIdNfEntrada() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objNFEComprasv;
    }

     public NotaFiscalCompra finalizarNFeComprasNUTRI(NotaFiscalCompra objNFEComprasv) {
       
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE NF_COMPRAS_NUTRI SET StatusNf=? WHERE IdNfEntrada='" + objNFEComprasv.getIdNfEntrada() + "'");           
            pst.setString(1, objNFEComprasv.getStatusNf());           
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objNFEComprasv;
    }
    public void buscarFornecedor(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM FORNECEDORES_AC WHERE RazaoSocial='" + nome + "'");
            conecta.rs.first();
            codForn = conecta.rs.getInt("IdForn");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (FORNECEDOR) a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
