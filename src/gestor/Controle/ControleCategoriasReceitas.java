/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.CategoriaReceitas;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleCategoriasReceitas {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    CategoriaReceitas objCat = new CategoriaReceitas();        

    public CategoriaReceitas incluirCategoriaReceitas(CategoriaReceitas objCat) {
        
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO CATEGORIA_RECEITAS_NUTRI (StatusCat,TipoReceita,DataCat,DescricaoCategoria,UsuarioInsert,DataInsert,HorarioInsert)VALUES(?,?,?,?,?,?,?)");
            pst.setString(1, objCat.getStatusCat());
            pst.setString(2, objCat.getTipoReceita());
            pst.setTimestamp(3, new java.sql.Timestamp(objCat.getDataCat().getTime()));
            pst.setString(4, objCat.getDescricaoCategoria());
            pst.setString(5, objCat.getUsuarioInsert());
            pst.setString(6, objCat.getDataInsert());
            pst.setString(7, objCat.getHorarioInsert());
            pst.execute(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCat;
    }

    public CategoriaReceitas alterarCategoriaReceitas(CategoriaReceitas objCat) {
        
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE CATEGORIA_RECEITAS_NUTRI SET StatusCat=?,TipoReceita=?,DataCat=?,DescricaoCategoria=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdCat='" + objCat.getIdCat() + "'");
            pst.setString(1, objCat.getStatusCat());
            pst.setString(2, objCat.getTipoReceita());
            pst.setTimestamp(3, new java.sql.Timestamp(objCat.getDataCat().getTime()));
            pst.setString(4, objCat.getDescricaoCategoria());
            pst.setString(5, objCat.getUsuarioUp());
            pst.setString(6, objCat.getDataUp());
            pst.setString(7, objCat.getHorarioUp());
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCat;
    }

    public CategoriaReceitas excluirCategoriaReceitas(CategoriaReceitas objCat) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM CATEGORIA_RECEITAS_NUTRI WHERE IdCat='" + objCat.getIdCat() + "'");
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCat;
    }    
}
