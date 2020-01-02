/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AssistenciaEducativa;
import static gestor.Visao.TelaCCAC_TPS.pCODIGO_AT;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Socializa TI 02
 */
public class ControleListalCursosIndividual {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AssistenciaEducativa objASSE = new AssistenciaEducativa();

    String pSTATUS_CURSO = "Ativo";

    public List<AssistenciaEducativa> read() throws Exception {
        conecta.abrirConexao();
        List<AssistenciaEducativa> listaCursos = new ArrayList<AssistenciaEducativa>();
        try {
            conecta.executaSQL("SELECT * FROM CURSOS "
                    + "INNER JOIN ATIVIDADES_COMPLEMENTARES_PEDAGOGICA "
                    + "ON CURSOS.IdCurso=ATIVIDADES_COMPLEMENTARES_PEDAGOGICA.IdCurso "
                    + "WHERE CURSOS.StatusCurso='" + pSTATUS_CURSO + "' "
                    + "AND ATIVIDADES_COMPLEMENTARES_PEDAGOGICA.IdCurso='" + pCODIGO_AT + "'");
            while (conecta.rs.next()) {
                AssistenciaEducativa pDigiCurso = new AssistenciaEducativa();
                pDigiCurso.setIdCurso(conecta.rs.getInt("IdCurso"));
                pDigiCurso.setStatusLanc(conecta.rs.getString("StatusCurso"));
                pDigiCurso.setDescricaoCurso(conecta.rs.getString("DescricaoCurso"));
                listaCursos.add(pDigiCurso);
            }
            return listaCursos;
        } catch (SQLException ex) {
            Logger.getLogger(ControleListaCursos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
