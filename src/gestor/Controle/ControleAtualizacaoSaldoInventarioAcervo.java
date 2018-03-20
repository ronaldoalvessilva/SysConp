/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.SaldoEstoqueAcervo;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleAtualizacaoSaldoInventarioAcervo {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    SaldoEstoqueAcervo objSaldoEstoque = new SaldoEstoqueAcervo();

    public SaldoEstoqueAcervo incluirEstoqueAcervo(SaldoEstoqueAcervo objSaldoEstoque) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ESTOQUE_ACERVO (DataLanc,TipoMov,IdLivro,IdLocal,SaldoEstoque) VALUES (?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objSaldoEstoque.getDataLanc().getTime()));
            pst.setString(2, objSaldoEstoque.getTipoMov());
            pst.setFloat(3, objSaldoEstoque.getIdLivro());
            pst.setInt(4, objSaldoEstoque.getIdLocal());
            pst.setFloat(5, objSaldoEstoque.getQtdItem());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ATUALIZAR ESTOQUE... \n\nERRO" + ex);
        }
        conecta.desconecta();
        return objSaldoEstoque;
    }

    public SaldoEstoqueAcervo alterarEstoqueAcervo(SaldoEstoqueAcervo objSaldoEstoque) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ESTOQUE_ACERVO SET SaldoEstoque=? WHERE IdLivro='" + objSaldoEstoque.getIdLivro() + "'");
            //  pst.setString(1, objSaldoEstoque.getLote());
            pst.setFloat(1, objSaldoEstoque.getQtdItem());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ATUALIZAR ESTOQUE... \n\nERRO" + ex);
        }
        conecta.desconecta();
        return objSaldoEstoque;
    }

    // Atualizar saldo de estoque de cada produto
    public SaldoEstoqueAcervo atualizarEstoqueAcervo(SaldoEstoqueAcervo objSaldoEstoque) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ESTOQUE_ACERVO SET SaldoEstoque=? WHERE IdLivro='" + objSaldoEstoque.getIdLivro() + "'");
            pst.setFloat(1, objSaldoEstoque.getSaldoEstoque());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ATUALIZAR ESTOQUE... \n\nERRO" + ex);
        }
        conecta.desconecta();
        return objSaldoEstoque;
    }
}
