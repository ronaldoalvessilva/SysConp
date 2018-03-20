/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.HistoricoProdutoFornecedor;
import gestor.Modelo.ProdutoMedicamento;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleAtualizaDadosUltimaCompra {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ProdutoMedicamento objProdMed = new ProdutoMedicamento();
    HistoricoProdutoFornecedor objHistorForn = new HistoricoProdutoFornecedor();

    int codForn;
    int codProd;

    public ProdutoMedicamento alterarDadosCompras(ProdutoMedicamento objProdMed) {        
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PRODUTOS_AC SET DataCompra=?,QtdCompra=?,ValorCompra=?,DataValidade=? WHERE IdProd='" + objProdMed.getIdProd() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objProdMed.getDataCompra().getTime()));
            pst.setFloat(2, objProdMed.getQtdCompra());
            pst.setFloat(3, objProdMed.getValorCompra());
            pst.setTimestamp(4, new java.sql.Timestamp(objProdMed.getDataValidade().getTime()));
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados (PRODUTO).\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProdMed;
    }

    public HistoricoProdutoFornecedor incluirDadosFornecedor(HistoricoProdutoFornecedor objHistorForn) {
        buscarFornecedor(objHistorForn.getNomeFornecedor());  
        buscarProduto(objHistorForn.getDescricaoProduto());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO HISTORICO_PRODUTOS_FORNECEDOR (NfCompra,DataMov,IdForn,IdItem,IdProd,QtdeCompra,ValorUnit) VALUES(?,?,?,?,?,?,?)");
            pst.setInt(1, objHistorForn.getNfCompra());
            pst.setTimestamp(2, new java.sql.Timestamp(objHistorForn.getDataMov().getTime()));
            pst.setInt(3, codForn);            
            pst.setInt(4, objHistorForn.getIdNfEntrada());
            pst.setInt(5, codProd);
            pst.setFloat(6, objHistorForn.getQtdeCompra());
            pst.setFloat(7, objHistorForn.getValorUnit());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INCLUIR os Dados no HISTÓRICO FORNECEDOR.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objHistorForn;
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

    public void buscarProduto(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRODUTOS_AC WHERE DescricaoProd='" + nome + "'");
            conecta.rs.first();
            codProd = conecta.rs.getInt("IdProd");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (PRODUTO) a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
