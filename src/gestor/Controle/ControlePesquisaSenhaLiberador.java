/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.Usuarios;
import static gestor.Visao.TelaLoginSenha.nameUser;
import javax.swing.JOptionPane;

/**
 *
 * @author ronal
 */
public class ControlePesquisaSenhaLiberador {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    Usuarios objUsuarios = new Usuarios();

    public Usuarios pPESQUISAR_SENHA_ususario(Usuarios objUsuarios) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nameUser + "'");
            conecta.rs.first();
            objUsuarios.setSenha1(conecta.rs.getString("SenhaUsuario"));
        } catch (Exception e) {            
        }
        conecta.desconecta();
        return objUsuarios;
    }
}
