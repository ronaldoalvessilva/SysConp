/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ParametrosCrc;
import static gestor.Visao.TelaParamentrosSistema.pCODIGO_parametro;
import static gestor.Visao.TelaPesquisaModuloTela_CONF.jTelaModuloImplementacao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronaldo.silva7
 */
public class ControlePesquisaParametrosImplementacoes {
    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ParametrosCrc objParCrc = new ParametrosCrc();

    Integer pCODIGO_modulo = 0;
    Integer pCODIGO_tela = 0;
    
    public List<ParametrosCrc> read() throws Exception {
        conecta.abrirConexao();
        List<ParametrosCrc> listaTelas = new ArrayList<ParametrosCrc>();
        try {
            conecta.executaSQL("SELECT IdImp, "
                    + "IMPLEMENTACAO_SISTEMA.IdModulo, "
                    + "IMPLEMENTACAO_SISTEMA.IdTelas, "
                    + "TELAS.NomeTela, "
                    + "MODULOS.NomeModulo, "
                    + "IMPLEMENTACAO_SISTEMA.IdPar, "
                    + "IMPLEMENTACAO_SISTEMA.Habilitar "
                    + "FROM IMPLEMENTACAO_SISTEMA "
                    + "INNER JOIN MODULOS "
                    + "ON IMPLEMENTACAO_SISTEMA.IdModulo=MODULOS.IdModulo "
                    + "INNER JOIN TELAS "
                    + "ON IMPLEMENTACAO_SISTEMA.IdTelas=TELAS.IdTelas "
                    + "INNER JOIN PARAMETROSCRC "
                    + "ON IMPLEMENTACAO_SISTEMA.IdPar=PARAMETROSCRC.IdPar "
                    + "WHERE TELAS.NomeTela LIKE'" + jTelaModuloImplementacao.getText() + "%'");
            while (conecta.rs.next()) {
                ParametrosCrc pDigital = new ParametrosCrc();
                pDigital.setIdImp(conecta.rs.getInt("IdImp"));
                pDigital.setIdPar(conecta.rs.getInt("IdPar"));
                pDigital.setIdModulo(conecta.rs.getInt("IdModulo"));
                pDigital.setNomeModulo(conecta.rs.getString("NomeModulo"));
                pDigital.setIdTelas(conecta.rs.getInt("IdTelas"));
                pDigital.setNomeTela(conecta.rs.getString("NomeTela"));
                pDigital.setHabilitarImp(conecta.rs.getString("Habilitar"));
                listaTelas.add(pDigital);
            }
            return listaTelas;
        } catch (SQLException ex) {
            Logger.getLogger(ControleParamentrosCrc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
