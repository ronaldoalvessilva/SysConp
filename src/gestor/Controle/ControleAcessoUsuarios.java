/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.Usuarios;

/**
 *
 * @author Ronaldo
 */
// CRIADO EM 24/04/2016 - AINDA NÃO FOI COCLUÍDO NEM TESTADO
public class ControleAcessoUsuarios {
    ConexaoBancoDados conecta = new ConexaoBancoDados();
    Usuarios objUser = new Usuarios();
    
    public Usuarios verificarAcessoUsuarios(Usuarios objUser) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "INNER JOIN USUARIOS_GRUPOS "
                    + "ON USUARIOS.IdUsuario=USUARIOS_GRUPOS.IdUsuario "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOSUSUARIOS.IdGrupo "
                    + "INNER JOIN MODULOS "
                    + "ON USUARIOS_GRUPOS.IdModulo=MODULO.IdModulo");
            conecta.rs.first();
        } catch (Exception e) {
        }
        conecta.desconecta();
        return objUser;        
    }    
}
