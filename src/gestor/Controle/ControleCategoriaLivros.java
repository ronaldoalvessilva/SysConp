/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.CategoriaLivros;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleCategoriaLivros {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    CategoriaLivros objCatLiv = new CategoriaLivros();

    public CategoriaLivros incluirCategoriaLivros(CategoriaLivros objCatLiv) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO CATEGORIA_LIVROS (StatusCat,TipoCategoria,DataCat,DescricaoCategoria,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");
            pst.setString(1, objCatLiv.getStatusCat());
            pst.setString(2, objCatLiv.getTipoCategoria());
            pst.setTimestamp(3, new java.sql.Timestamp(objCatLiv.getDataCat().getTime()));
            pst.setString(4, objCatLiv.getDescricaoCategoria());
            pst.setString(5, objCatLiv.getUsuarioInsert());
            pst.setString(6, objCatLiv.getDataInsert());
            pst.setString(7, objCatLiv.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objCatLiv;
    }

    public CategoriaLivros alterarCategoriaLivros(CategoriaLivros objCatLiv) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE CATEGORIA_LIVROS SET StatusCat=?,TipoCategoria=?,DataCat=?,DescricaoCategoria=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdCat='" + objCatLiv.getIdCat() + "'");
            pst.setString(1, objCatLiv.getStatusCat());
            pst.setString(2, objCatLiv.getTipoCategoria());
            pst.setTimestamp(3, new java.sql.Timestamp(objCatLiv.getDataCat().getTime()));
            pst.setString(4, objCatLiv.getDescricaoCategoria());
            pst.setString(5, objCatLiv.getUsuarioUp());
            pst.setString(6, objCatLiv.getDataUp());
            pst.setString(7, objCatLiv.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objCatLiv;
    }

    public CategoriaLivros excluirCategoriaLivros(CategoriaLivros objCatLiv) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM CATEGORIA_LIVROS WHERE IdCat='" + objCatLiv.getIdCat() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objCatLiv;
    }
}
