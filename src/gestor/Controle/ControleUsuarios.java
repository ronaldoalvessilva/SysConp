/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.Usuarios;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleUsuarios {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    Usuarios objUser = new Usuarios();
    int codGrupo;

    public Usuarios incluirUsuarios(Usuarios objUser) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO USUARIOS (StatusUsuario,DataCadastro,NomeUsuario,NomeDepartamento,NomeCargo,LoginUsuario,SenhaUsuario,ConfirmaSenhaUsuario)VALUES(?,?,?,?,?,?,?,?)");
            pst.setBoolean(1, objUser.getStatus());
            if (objUser.getDataCadastro() != null) {
                pst.setTimestamp(2, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            } else {
                pst.setDate(2, null);
            }
            pst.setString(3, objUser.getNomeUsuario());
            pst.setString(4, objUser.getNomeDepartamento());
            pst.setString(5, objUser.getNomeCargo());
            pst.setString(6, objUser.getLogin());
            pst.setString(7, objUser.getSenha1());
            pst.setString(8, objUser.getSenha2());
            pst.execute(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objUser;
    }

    public Usuarios alterarUsuarios(Usuarios objUser) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE USUARIOS SET StatusUsuario=?,DataCadastro=?,NomeUsuario=?,NomeDepartamento=?,NomeCargo=?,LoginUsuario=?,SenhaUsuario=?,ConfirmaSenhaUsuario=? WHERE IdUsuario='" + objUser.getIdUsuario() + "'");
            pst.setBoolean(1, objUser.getStatus());
            if (objUser.getDataCadastro() != null) {
                pst.setTimestamp(2, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            } else {
                pst.setDate(2, null);
            }
            pst.setString(3, objUser.getNomeUsuario());
            pst.setString(4, objUser.getNomeDepartamento());
            pst.setString(5, objUser.getNomeCargo());
            pst.setString(6, objUser.getLogin());
            pst.setString(7, objUser.getSenha1());
            pst.setString(8, objUser.getSenha2());
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objUser;
    }

    public Usuarios excluirUsuarios(Usuarios objUser) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM USUARIOS WHERE IdUsuario='" + objUser.getIdUsuario() + "'");
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objUser;
    }

    public Usuarios trocarSenhaUsuario(Usuarios objUser) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE USUARIOS SET SenhaUsuario=?,ConfirmaSenhaUsuario=? WHERE IdUsuario='" + objUser.getIdUsuario() + "'");
            pst.setString(1, objUser.getSenha1());
            pst.setString(2, objUser.getSenha2());
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO:" + ex);
        }
        conecta.desconecta();
        return objUser;
    }
}
