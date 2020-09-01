/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.Usuarios;
import static gestor.Visao.TelaLoginSenha.jUsuario;
import static gestor.Visao.TelaLoginSenha.Codstatus;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronaldo.silva7
 */
public class ControleVerificacaoAcessos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    Usuarios objUsusarios = new Usuarios();

    public List<Usuarios> read() throws Exception {

        conecta.abrirConexao();
        List<Usuarios> listarUsuarios = new ArrayList<Usuarios>();
        try {
            conecta.executaSQL("SELECT IdUsuario,LoginUsuario, "
                    + "SenhaUsuario,StatusUsuario,NomeUsuario "
                    + "FROM USUARIOS  "
                    + "WHERE LoginUsuario='" + jUsuario.getText() + "'");
            while (conecta.rs.next()) {
                Usuarios pUser = new Usuarios();
                Codstatus = conecta.rs.getInt("StatusUsuario");
                pUser.setIdUsuario(conecta.rs.getInt("IdUsuario"));
                pUser.setLogin(conecta.rs.getString("LoginUsuario"));
                pUser.setNomeUsuario(conecta.rs.getString("NomeUsuario"));
                pUser.setSenha1(conecta.rs.getString("SenhaUsuario"));                
                listarUsuarios.add(pUser);
            }
            return listarUsuarios;
        } catch (SQLException ex) {
            Logger.getLogger(ControleVerificacaoAcessos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
