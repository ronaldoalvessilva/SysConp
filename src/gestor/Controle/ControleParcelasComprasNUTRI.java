/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ParcelasPagtoCompras;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleParcelasComprasNUTRI {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ParcelasPagtoCompras objParCompras = new ParcelasPagtoCompras();

    int codForn;

    public ParcelasPagtoCompras incluirParcelasComprasNUTRI(ParcelasPagtoCompras objParCompras) {
        buscarFornecedor(objParCompras.getNomeFornecedor());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO PARCELAS_COMPRAS_NUTRI "
                    + "(IdNfEntrada,IdForn,DataVcto,ValorParcela,ValorTotalParcelas, "
                    + "UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?)");
            pst.setInt(1, objParCompras.getIdNfEntrada());          
            pst.setInt(2, codForn);
            pst.setTimestamp(3, new java.sql.Timestamp(objParCompras.getDataVcto().getTime()));
            pst.setFloat(4, objParCompras.getValorParcela());
            pst.setFloat(5, objParCompras.getValorTotalParcelas());
            pst.setString(6, objParCompras.getUsuarioInsert());
            pst.setString(7, objParCompras.getDataInsert());
            pst.setString(8, objParCompras.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objParCompras;
    }

    public ParcelasPagtoCompras alterarParcelasComprasNUTRI(ParcelasPagtoCompras objParCompras) {
        buscarFornecedor(objParCompras.getNomeFornecedor());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PARCELAS_COMPRAS_NUTRI SET "
                    + "IdNfEntrada=?,IdForn=?,DataVcto=?,ValorParcela=?,ValorTotalParcelas=?, "
                    + "UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdParc='" + objParCompras.getIdParc() + "'");
            pst.setInt(1, objParCompras.getIdNfEntrada());
            pst.setInt(2, codForn);
            pst.setTimestamp(3, new java.sql.Timestamp(objParCompras.getDataVcto().getTime()));
            pst.setFloat(4, objParCompras.getValorParcela());
            pst.setFloat(5, objParCompras.getValorTotalParcelas());
            pst.setString(6, objParCompras.getUsuarioUp());
            pst.setString(7, objParCompras.getDataUp());
            pst.setString(8, objParCompras.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objParCompras;
    }

    public ParcelasPagtoCompras excluirParcelasComprasNUTRI(ParcelasPagtoCompras objParCompras) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM PARCELAS_COMPRAS_NUTRI WHERE IdParc='" + objParCompras.getIdParc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objParCompras;
    }

    public void buscarFornecedor(String nomeFornecedor) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM FORNECEDORES_AC WHERE RazaoSocial='" + nomeFornecedor + "'");
            conecta.rs.first();
            codForn = conecta.rs.getInt("IdForn");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar código do fornecedor.\nERRO :" + ex);
        }
    }
}
