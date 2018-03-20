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
 * @author Ronaldo
 */
public class ControleModulosUsuariosGrupos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    Usuarios objUser = new Usuarios();
    int codModulo;
    int codGrupo;

    public Usuarios incluirModuloUsuarios(Usuarios objUser) {
        pesquisarModulosUsuarios(objUser.getNomeModulo());
        pesquisarGrupoUsuarios(objUser.getNomeGrupo());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO USUARIOS_MODULOS (IdUsuario,IdGrupo,IdModulo,Permissao)VALUES(?,?,?,?)");
            pst.setInt(1, objUser.getIdUsuario());
            pst.setInt(2, codGrupo);
            pst.setInt(3, codModulo);
            pst.setString(4, objUser.getPermissaoModulo());
            pst.execute(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objUser;
    }

    public Usuarios alterarModuloUsuarios(Usuarios objUser) {
        pesquisarModulosUsuarios(objUser.getNomeModulo());
        pesquisarGrupoUsuarios(objUser.getNomeGrupo());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE USUARIOS_MODULOS SET IdUsuario=?,IdGrupo=?,IdModulo=?,Permissao=? WHERE IdMod='" + objUser.getIdMod() + "'");
            pst.setInt(1, objUser.getIdUsuario());
            pst.setInt(2, codGrupo);
            pst.setInt(3, codModulo);
            pst.setString(4, objUser.getPermissaoModulo());
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objUser;
    }

    public Usuarios excluirModuloUsuarios(Usuarios objUser) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM USUARIOS_MODULOS WHERE IdMod='" + objUser.getIdModulo() + "'");
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objUser;
    }

    public void pesquisarModulosUsuarios(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM MODULOS WHERE NomeModulo='" + nome + "'");
            conecta.rs.first();
            codModulo = conecta.rs.getInt("IdModulo");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void pesquisarGrupoUsuarios(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM GRUPOUSUARIOS WHERE NomeGrupo='" + nome + "'");
            conecta.rs.first();
            codGrupo = conecta.rs.getInt("IdGrupo");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
