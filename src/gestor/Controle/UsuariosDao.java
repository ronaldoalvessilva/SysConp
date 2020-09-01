/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.Usuarios;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronal
 */
public class UsuariosDao {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    Usuarios objUser = new Usuarios();

    public List<Usuarios> read() throws Exception {

        conecta.abrirConexao();
        List<Usuarios> listarUsuarios = new ArrayList<Usuarios>();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS ORDER BY NomeUsuario");
            while (conecta.rs.next()) {
                Usuarios pDigi = new Usuarios();
                pDigi.setIdUsuario(conecta.rs.getInt("IdUsuario"));
                pDigi.setNomeUsuario(conecta.rs.getString("NomeUsuario"));
                pDigi.setLogin(conecta.rs.getString("LoginUsuario"));
                listarUsuarios.add(pDigi);
            }
            return listarUsuarios;
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
