/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.Professores;
import static gestor.Visao.TelaCCAC_TPS.pCODIGO_PROFESSOR;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Socializa TI 02
 */
public class ControleListaProfessorIndividual {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    Professores objProf = new Professores();

    String pSTATUS_INSTITUICAO = "Ativo";

    public List<Professores> read() throws Exception {
        conecta.abrirConexao();
        List<Professores> listaProf = new ArrayList<Professores>();
        try {
            conecta.executaSQL("SELECT * FROM PROFESSORES "
                    + "INNER JOIN ATIVIDADES_COMPLEMENTARES_PEDAGOGICA "
                    + "ON PROFESSORES.IdProf=ATIVIDADES_COMPLEMENTARES_PEDAGOGICA.IdProf "
                    + "WHERE PROFESSORES.StatusProf='" + pSTATUS_INSTITUICAO + "' "
                    + "AND ATIVIDADES_COMPLEMENTARES_PEDAGOGICA.IdProf='" + pCODIGO_PROFESSOR + "'");
            while (conecta.rs.next()) {
                Professores pDigiPRF = new Professores();
                pDigiPRF.setIdProf(conecta.rs.getInt("IdProf"));
                pDigiPRF.setStatusProf(conecta.rs.getString("StatusProf"));
                pDigiPRF.setNomeProfessor(conecta.rs.getString("NomeProfessor"));
                listaProf.add(pDigiPRF);
            }
            return listaProf;
        } catch (SQLException ex) {
            Logger.getLogger(ControleListaProfessores.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
