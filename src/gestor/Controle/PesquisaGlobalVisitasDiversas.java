/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ProntuarioPesquisaRel;
import gestor.Modelo.VisitasDiversas;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Socializa TI 02
 */
public class PesquisaGlobalVisitasDiversas {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    VisitasDiversas objVisDiv = new VisitasDiversas();

    public List<VisitasDiversas> read() throws Exception {

        conecta.abrirConexao();
        List<VisitasDiversas> listaInternos = new ArrayList<VisitasDiversas>();
        try {
            conecta.executaSQL("SELECT * FROM VISITASDIVERSAS ORDER BY NomeVisita");
            while (conecta.rs.next()) {
                VisitasDiversas pVisitasDiv = new VisitasDiversas();
                pVisitasDiv.setIdVisita(conecta.rs.getInt("IdVisita"));
                pVisitasDiv.setNomeVisita(conecta.rs.getString("NomeVisita"));
                listaInternos.add(pVisitasDiv);
            }
            return listaInternos;
        } catch (SQLException ex) {
            Logger.getLogger(PesquisaGlobalVisitasDiversas.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
