/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import Utilitarios.Criptografia;
import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.Usuarios;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronal
 */
public class SenhaCriptografadaDao {
    ConexaoBancoDados conecta = new ConexaoBancoDados();
    Usuarios objUser = new Usuarios();
    
    public Usuarios gravarSenhaCriptoggrafada(Usuarios objUser) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE USUARIOS SET LoginUsuario=?,PasswordCriptogradaUm=?,PasswordCriptogradaDois=? WHERE IdUsuario='" + objUser.getIdUsuario() + "'");                      
            pst.setString(1, objUser.getLogin());
            pst.setString(2, Criptografia.criptografar(objUser.getPasswordCriptogradaUm()));
            pst.setString(3, Criptografia.criptografar(objUser.getPasswordCriptogradaDois()));           
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objUser;
    }
}
