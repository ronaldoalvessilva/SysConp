/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.Paises;
import java.sql.PreparedStatement;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControlePaises {
    ConexaoBancoDados conecta = new ConexaoBancoDados();
    Paises objPaises = new Paises();
    
    // Método para inserir PAIS
    public Paises Salvar(Paises objPaises) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO PAISES (CodPais, NomePais,UsuarioInsert) VALUES(?,?,?)");
            pst.setInt(1, objPaises.getCodPais());
            pst.setString(2, objPaises.getNomePais());
            pst.setString(3, objPaises.getNomeUsuario());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objPaises;
    }
    //Método para ALTERAR PAIS
    public Paises Alterar(Paises objPaises) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PAISES SET CodPais=?,NomePais=?,UsuarioInsert=? WHERE IdPais='" + objPaises.getIdPais() + "'");
            pst.setInt(1, objPaises.getCodPais());
            pst.setString(2, objPaises.getNomePais());
        //    pst.setInt(3, objPaises.getIdPais());
            pst.setString(3, objPaises.getNomeUsuario());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\n ERRO\n" + ex);
        }
        conecta.desconecta();
        return objPaises;
    }
    //Método para excluir PAIS
    public Paises Excluir(Paises objPaises) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst;
            pst = conecta.con.prepareStatement("DELETE FROM PAISES WHERE IdPais='" + objPaises.getIdPais() + "'");
           // pst.setInt(1, objPaises.getIdPais());
            pst.execute();        
            conecta.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\n ERRO\n" + ex);
        }
        conecta.desconecta();
        return objPaises;

    }
}
