/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensNfeCompras;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleItensCompras {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensNfeCompras objItensCompras = new ItensNfeCompras();
    int codProd;

    public ItensNfeCompras incluirItensCompras(ItensNfeCompras objItensCompras) {
        buscarProduto(objItensCompras.getDescricaoProduto());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_COMPRAS_MATERIAIS "
                    + "(IdPedido,IdNfEntrada,IdProd,Lote,QtdItem,ValorUN,AliquotaICMS,AliquotaIPI,DataVctoLote, "
                    + "ValorTotalItem,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objItensCompras.getIdPedido());
            pst.setInt(2, objItensCompras.getIdNfEntrada());
            pst.setInt(3, codProd);
            pst.setString(4, objItensCompras.getLote());
            pst.setFloat(5, objItensCompras.getQtdItem());
            pst.setFloat(6, objItensCompras.getValorUN());
            pst.setFloat(7, objItensCompras.getAliquotaICMS());
            pst.setFloat(8, objItensCompras.getAliquotaIPI());
            if (objItensCompras.getDataVcto() != null) {
                pst.setTimestamp(9, new java.sql.Timestamp(objItensCompras.getDataVcto().getTime()));
            } else {
                pst.setDate(9, null);
            }
            pst.setFloat(10, objItensCompras.getValorTotalItem());
            pst.setString(11, objItensCompras.getUsuarioInsert());
            pst.setString(12, objItensCompras.getDataInsert());
            pst.setString(13, objItensCompras.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensCompras;
    }

    public ItensNfeCompras alterarItensCompras(ItensNfeCompras objItensCompras) {
        buscarProduto(objItensCompras.getDescricaoProduto());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_COMPRAS_MATERIAIS SET "
                    + "IdPedido=?,IdNfEntrada=?,IdProd=?,Lote=?,QtdItem=?,ValorUN=?,AliquotaICMS=?,AliquotaIPI=?,DataVctoLote=?, "
                    + "ValorTotalItem=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objItensCompras.getIdItem() + "'");
            pst.setInt(1, objItensCompras.getIdPedido());
            pst.setInt(2, objItensCompras.getIdNfEntrada());
            pst.setInt(3, codProd);
            pst.setString(4, objItensCompras.getLote());
            pst.setFloat(5, objItensCompras.getQtdItem());
            pst.setFloat(6, objItensCompras.getValorUN());
            pst.setFloat(7, objItensCompras.getAliquotaICMS());
            pst.setFloat(8, objItensCompras.getAliquotaIPI());
            if (objItensCompras.getDataVcto() != null) {
                pst.setTimestamp(9, new java.sql.Timestamp(objItensCompras.getDataVcto().getTime()));
            } else {
                pst.setDate(9, null);
            }
            pst.setFloat(10, objItensCompras.getValorTotalItem());
            pst.setString(11, objItensCompras.getUsuarioUp());
            pst.setString(12, objItensCompras.getDataUp());
            pst.setString(13, objItensCompras.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensCompras;
    }

    public ItensNfeCompras excluirItensCompras(ItensNfeCompras objItensCompras) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_COMPRAS_MATERIAIS WHERE IdItem='" + objItensCompras.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensCompras;
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
