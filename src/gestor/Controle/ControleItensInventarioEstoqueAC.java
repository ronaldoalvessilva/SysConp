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
 * @author user
 */
public class ControleItensInventarioEstoqueAC {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensInventarioEstoque objItensInventEstoque = new ItensInventarioEstoque();
    int codProd;

    public ItensInventarioEstoque incluirItensInventarioAC(ItensInventarioEstoque objItensInventEstoque) {
        buscarProduto(objItensInventEstoque.getNomeProduto());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_INVENTARIO_AC (IdLanc,IdProd,QtdItem,ValorCusto,IdLocal,Lote,DataLote,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objItensInventEstoque.getIdLanc());
            pst.setInt(2, codProd);
            pst.setFloat(3, objItensInventEstoque.getQtdItem());
            pst.setFloat(4, objItensInventEstoque.getValorCusto());
            pst.setInt(5, objItensInventEstoque.getIdLocal());
            pst.setString(6, objItensInventEstoque.getLote());
            if (objItensInventEstoque.getDataLote() != null) {
                pst.setTimestamp(7, new java.sql.Timestamp(objItensInventEstoque.getDataLote().getTime()));
            } else {
                pst.setDate(7, null);
            }
            pst.setString(8, objItensInventEstoque.getUsuarioInsert());
            pst.setString(9, objItensInventEstoque.getDataInsert());
            pst.setString(10, objItensInventEstoque.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensInventEstoque;
    }

    public ItensInventarioEstoque alterarItensInventarioAC(ItensInventarioEstoque objItensInventEstoque) {
        buscarProduto(objItensInventEstoque.getNomeProduto());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_INVENTARIO_AC SET IdLanc=?,IdProd=?,QtdItem=?,ValorCusto=?,IdLocal=?,Lote=?,DataLote=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objItensInventEstoque.getIdItem() + "'");
            pst.setInt(1, objItensInventEstoque.getIdLanc());
            pst.setInt(2, codProd);
            pst.setFloat(3, objItensInventEstoque.getQtdItem());
            pst.setFloat(4, objItensInventEstoque.getValorCusto());
            pst.setInt(5, objItensInventEstoque.getIdLocal());
            pst.setString(6, objItensInventEstoque.getLote());
            if (objItensInventEstoque.getDataLote() != null) {
                pst.setTimestamp(7, new java.sql.Timestamp(objItensInventEstoque.getDataLote().getTime()));
            } else {
                pst.setDate(7, null);
            }
            pst.setString(8, objItensInventEstoque.getUsuarioUp());
            pst.setString(9, objItensInventEstoque.getDataUp());
            pst.setString(10, objItensInventEstoque.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensInventEstoque;
    }

    public ItensInventarioEstoque excluirItensInventarioAC(ItensInventarioEstoque objItensInventEstoque) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_INVENTARIO_AC WHERE IdItem='" + objItensInventEstoque.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensInventEstoque;
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
