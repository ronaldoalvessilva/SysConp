/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AssistenciaEducativa;
import static gestor.Visao.TelaAssistenciaEducacionalExterna.pCODIGO_CURSO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Socializa TI 02
 */
public class listarInternosEE {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AssistenciaEducativa objAssis = new AssistenciaEducativa();

    public List<AssistenciaEducativa> read() throws Exception {
        conecta.abrirConexao();
        List<AssistenciaEducativa> listaInternosEE = new ArrayList<AssistenciaEducativa>();
        try {
            conecta.executaSQL("SELECT * FROM CURSOS "
                    + "INNER JOIN ASSISTENCIA_EDUCACAO_EXTERNA "
                    + "ON CURSOS.IdCurso=ASSISTENCIA_EDUCACAO_EXTERNA.IdCurso "
                    + "WHERE ASSISTENCIA_EDUCACAO_EXTERNA.IdCurso='" + pCODIGO_CURSO + "'");
            while (conecta.rs.next()) {
                AssistenciaEducativa pDigi = new AssistenciaEducativa();
                pDigi.setIdCurso(conecta.rs.getInt("IdCurso"));
                pDigi.setDescricaoCurso(conecta.rs.getString("DescricaoCurso"));
                listaInternosEE.add(pDigi);
            }
            return listaInternosEE;
        } catch (SQLException ex) {
            Logger.getLogger(listarInternosEE.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
