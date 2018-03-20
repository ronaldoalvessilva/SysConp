/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ProdutosCotacaoCompras;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleProdutosCotacao {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ProdutosCotacaoCompras objProdutoCotacao = new ProdutosCotacaoCompras();
    int codProduto, codDepto, codForn;

    public ProdutosCotacaoCompras incluirProdutoCotacao(ProdutosCotacaoCompras objProdutoCotacao) {
        buscarProdutoCotacao(objProdutoCotacao.getNomeProduto());
        buscarDepartamento(objProdutoCotacao.getNomeDepartamnto());
        buscarFornecedor(objProdutoCotacao.getNomeFornecedor());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_COTACAO_COMPRAS (IdCota,IdForn,IdDepartamento,IdProd,IdSol,QtdItem,ValorUnit,ValorTotal,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objProdutoCotacao.getIdCota());
            pst.setInt(2, codForn);
            pst.setInt(3, codDepto);
            pst.setInt(4, codProduto);
            pst.setInt(5, objProdutoCotacao.getIdSol());
            pst.setFloat(6, objProdutoCotacao.getQtdItem());
            pst.setFloat(7, objProdutoCotacao.getValorUnitario());
            pst.setFloat(8, objProdutoCotacao.getValorTotalProduto());
            pst.setString(9, objProdutoCotacao.getUsuarioInsert());
            pst.setString(10, objProdutoCotacao.getDataInsert());
            pst.setString(11, objProdutoCotacao.getHorarioInsert());
            pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados...\nERRO: " + e);
        }
        conecta.desconecta();
        return objProdutoCotacao;
    }

    public ProdutosCotacaoCompras alterarProdutoCotacao(ProdutosCotacaoCompras objProdutoCotacao) {
        buscarProdutoCotacao(objProdutoCotacao.getNomeProduto());
        buscarDepartamento(objProdutoCotacao.getNomeDepartamnto());
        buscarFornecedor(objProdutoCotacao.getNomeFornecedor());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_COTACAO_COMPRAS SET IdCota=?,IdForn=?,IdDepartamento=?,IdProd=?,IdSol=?,QtdItem=?,ValorUnit=?,ValorTotal=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objProdutoCotacao.getIdItem() + "'");
            pst.setInt(1, objProdutoCotacao.getIdCota());
            pst.setInt(2, codForn);
            pst.setInt(3, codDepto);
            pst.setInt(4, codProduto);
            pst.setInt(5, objProdutoCotacao.getIdSol());
            pst.setFloat(6, objProdutoCotacao.getQtdItem());
            pst.setFloat(7, objProdutoCotacao.getValorUnitario());
            pst.setFloat(8, objProdutoCotacao.getValorTotalProduto());
            pst.setString(9, objProdutoCotacao.getUsuarioInsert());
            pst.setString(10, objProdutoCotacao.getDataInsert());
            pst.setString(11, objProdutoCotacao.getHorarioInsert());
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados...\nERRO: " + e);
        }
        conecta.desconecta();
        return objProdutoCotacao;
    }

    public ProdutosCotacaoCompras excluirProdutoCotacao(ProdutosCotacaoCompras objProdutoCotacao) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_COTACAO_COMPRAS WHERE IdItem='" + objProdutoCotacao.getIdItem() + "'");
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados...\nERRO: " + e);
        }
        conecta.desconecta();
        return objProdutoCotacao;
    }

    public void buscarProdutoCotacao(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRODUTOS_AC WHERE DescricaoProd='" + desc + "'");
            conecta.rs.first();
            codProduto = conecta.rs.getInt("IdProd");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (FORMA DE PAGAMENTO) a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void buscarDepartamento(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM DEPARTAMENTOS WHERE NomeDepartamento='" + desc + "'");
            conecta.rs.first();
            codDepto = conecta.rs.getInt("IdDepartamento");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (DEPARTAMENTOS) a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void buscarFornecedor(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM FORNECEDORES_AC WHERE RazaoSocial='" + nome + "'");
            conecta.rs.first();
            codForn = conecta.rs.getInt("IdForn");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (FORNECEDORES) a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
