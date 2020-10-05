/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.CamposAcessos;
import java.sql.SQLException;

/**
 *
 * @author ronaldo.silva7
 */
public class ControleAcessoGeral {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    CamposAcessos objCampos = new CamposAcessos();

    //USUÁRIOS
    public CamposAcessos pesquisarUsuario(CamposAcessos objCampos) {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT IdUsuario,NomeUsuario "
                    + "FROM USUARIOS "
                    + "WHERE NomeUsuario='" + objCampos.getNomeUsuario() + "'");
            conecta.rs.first();
            objCampos.setCodigoUsuario(conecta.rs.getInt("IdUsuario"));
        } catch (SQLException ex) {
        }
        conecta.desconecta();
        return objCampos;
    }

    //GRUPOS DE USUÁRIOS
    public CamposAcessos pesquisarGrupoUsuario(CamposAcessos objCampos) {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + objCampos.getCodigoUsuario() + "'");
            conecta.rs.first();
            objCampos.setCodigoUsuarioGrupo(conecta.rs.getInt("IdUsuario"));
            objCampos.setCodigoGrupo(conecta.rs.getInt("IdGrupo"));
            objCampos.setNomeGrupo(conecta.rs.getString("NomeGrupo"));
        } catch (SQLException ex) {
        }
        conecta.desconecta();
        return objCampos;
    }

    //TELAS DE ACESSO JÁ LIBERADA
    public CamposAcessos pesquisarTelasAcesso(CamposAcessos objCampos) {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + objCampos.getCodigoUsuario() + "' "
                    + "AND NomeTela='" + objCampos.getNomeTelaAcesso() + "'");
            conecta.rs.first();
            objCampos.setCodigoUsuarioAcesso(conecta.rs.getInt("IdUsuario"));
            objCampos.setCodigoAbrir(conecta.rs.getInt("Abrir"));
            objCampos.setCodigoIncluir(conecta.rs.getInt("Incluir"));
            objCampos.setCodigoAlterar(conecta.rs.getInt("Alterar"));
            objCampos.setCodigoExcluir(conecta.rs.getInt("Excluir"));
            objCampos.setCodigoGravar(conecta.rs.getInt("Gravar"));
            objCampos.setCodigoConsultar(conecta.rs.getInt("Consultar"));
            objCampos.setNomeTelaAcesso(conecta.rs.getString("NomeTela"));
        } catch (SQLException ex) {
        }
        conecta.desconecta();
        return objCampos;
    }

    //TELAS DO SISTEMA JÁ CADASTRADA PELO MÓDULO
    public CamposAcessos pesquisarTelaCadastrada(CamposAcessos objCampos) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + objCampos.getNomeTelaPesquisa() + "'");
            conecta.rs.first();
            objCampos.setNomeTelaCadastrada(conecta.rs.getString("NomeTela"));
        } catch (SQLException ex) {
        }
        conecta.desconecta();
        return objCampos;
    }

    //BUSCAR MÓDULO
    public CamposAcessos pesquisarCodigoModulo(CamposAcessos objCampos) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM MODULOS "
                    + "WHERE NomeModulo='" + objCampos.getNomeModulo() + "'");
            conecta.rs.first();
            objCampos.setCodigoModulo(conecta.rs.getInt("IdModulo"));
        } catch (SQLException ex) {
        }
        conecta.desconecta();
        return objCampos;
    }
}
