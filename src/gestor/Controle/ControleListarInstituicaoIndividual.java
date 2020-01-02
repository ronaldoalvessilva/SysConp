/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.Instituicao;
import static gestor.Visao.TelaCCAC_TPS.pCODIGO_INSTITUICAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Socializa TI 02
 */
public class ControleListarInstituicaoIndividual {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    Instituicao objInst = new Instituicao();

    String pSTATUS_INSTITUICAO = "Ativo";

    public List<Instituicao> read() throws Exception {
        conecta.abrirConexao();
        List<Instituicao> listaInstituicao = new ArrayList<Instituicao>();
        try {
            conecta.executaSQL("SELECT * FROM INSTITUICAOESCOLAR "
                    + "INNER JOIN ATIVIDADES_COMPLEMENTARES_PEDAGOGICA "
                    + "ON INSTITUICAOESCOLAR.IdCod=ATIVIDADES_COMPLEMENTARES_PEDAGOGICA.IdCod "
                    + "WHERE INSTITUICAOESCOLAR.StatusInst='" + pSTATUS_INSTITUICAO + "' "
                    + "AND ATIVIDADES_COMPLEMENTARES_PEDAGOGICA.IdCod='" + pCODIGO_INSTITUICAO + "'");
            while (conecta.rs.next()) {
                Instituicao pDigiAC = new Instituicao();
                pDigiAC.setIdCod(conecta.rs.getInt("IdCod"));
                pDigiAC.setStatusInst(conecta.rs.getString("StatusInst"));
                pDigiAC.setNomeInstituicao(conecta.rs.getString("NomeInstituicao"));
                listaInstituicao.add(pDigiAC);
            }
            return listaInstituicao;
        } catch (SQLException ex) {
            Logger.getLogger(ControleListaInstituicao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
