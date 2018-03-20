/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensInventarioEstoque;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleItensInventarioAcervo {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensInventarioEstoque objItensInventEstoque = new ItensInventarioEstoque();
    int codProd;

    public ItensInventarioEstoque incluirItensInventarioAcervo(ItensInventarioEstoque objItensInventEstoque) {
        buscarProduto(objItensInventEstoque.getNomeProduto());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_INVENTARIO_ACERVO (IdLanc,IdLivro,Unidade,QtdItem,ValorCusto,IdLocal,Lote,DataLote,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objItensInventEstoque.getIdLanc());
            pst.setInt(2, codProd);
            pst.setString(3, objItensInventEstoque.getUnidade());
            pst.setFloat(4, objItensInventEstoque.getQtdItem());
            pst.setFloat(5, objItensInventEstoque.getValorCusto());
            pst.setInt(6, objItensInventEstoque.getIdLocal());
            pst.setString(7, objItensInventEstoque.getLote());
            if (objItensInventEstoque.getDataLote() != null) {
                pst.setTimestamp(8, new java.sql.Timestamp(objItensInventEstoque.getDataLote().getTime()));
            } else {
                pst.setDate(8, null);
            }
            pst.setString(9, objItensInventEstoque.getUsuarioInsert());
            pst.setString(10, objItensInventEstoque.getDataInsert());
            pst.setString(11, objItensInventEstoque.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensInventEstoque;
    }

    public ItensInventarioEstoque alterarItensInventarioAcervo(ItensInventarioEstoque objItensInventEstoque) {
        buscarProduto(objItensInventEstoque.getNomeProduto());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_INVENTARIO_ACERVO SET IdLanc=?,IdLivro=?,Unidade=?,QtdItem=?,ValorCusto=?,IdLocal=?,Lote=?,DataLote=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objItensInventEstoque.getIdItem() + "'");
            pst.setInt(1, objItensInventEstoque.getIdLanc());
            pst.setInt(2, codProd);
            pst.setString(3, objItensInventEstoque.getUnidade());
            pst.setFloat(4, objItensInventEstoque.getQtdItem());
            pst.setFloat(5, objItensInventEstoque.getValorCusto());
            pst.setInt(6, objItensInventEstoque.getIdLocal());
            pst.setString(7, objItensInventEstoque.getLote());
            if (objItensInventEstoque.getDataLote() != null) {
                pst.setTimestamp(8, new java.sql.Timestamp(objItensInventEstoque.getDataLote().getTime()));
            } else {
                pst.setDate(8, null);
            }
            pst.setString(9, objItensInventEstoque.getUsuarioUp());
            pst.setString(10, objItensInventEstoque.getDataUp());
            pst.setString(11, objItensInventEstoque.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensInventEstoque;
    }

    public ItensInventarioEstoque excluirItensInventarioAcervo(ItensInventarioEstoque objItensInventEstoque) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_INVENTARIO_ACERVO WHERE IdItem='" + objItensInventEstoque.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensInventEstoque;
    }

    public void buscarProduto(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM LIVROS_REVISTAS_JORNAIS WHERE TituloLivro='" + nome + "'");
            conecta.rs.first();
            codProd = conecta.rs.getInt("IdLivro");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (LIVROS) a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
