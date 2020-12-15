/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ParametrosCrc;
import java.sql.SQLException;

/**
 *
 * @author ronaldo.silva7
 */
public class ControleImplementacoes {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ParametrosCrc objParCrc = new ParametrosCrc();

    public ParametrosCrc pPESQUISAR_liberacao(ParametrosCrc objParCrc) {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdModulo, "
                    + "IdTelas, "
                    + "Habilitar "
                    + "FROM IMPLEMENTACAO_SISTEMA "
                    + "WHERE IdModulo='" + objParCrc.getIdModulo() + "' "
                    + "AND IdTelas='" + objParCrc.getIdTelas() + "'");
            conecta.rs.first();
            objParCrc.setIdModulo(conecta.rs.getInt("IdModulo"));
            objParCrc.setIdTelas(conecta.rs.getInt("IdTelas"));
            objParCrc.setHabilitarImp(conecta.rs.getString("Habilitar"));
        } catch (SQLException ex) {
        }
        conecta.desconecta();
        return objParCrc;
    }

    public ParametrosCrc pPESQUISAR_CODIGO_TELA(ParametrosCrc objParCrc) {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdTelas, "
                    + "IdModulo, "
                    + "NomeTela "
                    + "FROM TELAS "
                    + "WHERE NomeTela='" + objParCrc.getNomeTela() + "' ");
            conecta.rs.first();
            objParCrc.setIdModulo(conecta.rs.getInt("IdModulo"));
            objParCrc.setIdTelas(conecta.rs.getInt("IdTelas"));
            objParCrc.setHabilitarImp(conecta.rs.getString("NomeTela"));
        } catch (SQLException ex) {
        }
        conecta.desconecta();
        return objParCrc;
    }
}
