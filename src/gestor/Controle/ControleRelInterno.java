/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ProntuarioPesquisaRel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronal
 */
public class ControleRelInterno {

    ProntuarioPesquisaRel objPront = new ProntuarioPesquisaRel();
    ConexaoBancoDados conecta = new ConexaoBancoDados();

    public List<ProntuarioPesquisaRel> read() throws Exception {

        conecta.abrirConexao();
        List<ProntuarioPesquisaRel> listaInternos = new ArrayList<ProntuarioPesquisaRel>();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC ORDER BY NomeInternoCrc");
            while (conecta.rs.next()) {
                ProntuarioPesquisaRel pDigi = new ProntuarioPesquisaRel();
                pDigi.setIdInterno(conecta.rs.getInt("IdInternoCrc"));
                pDigi.setNomeInterno(conecta.rs.getString("NomeInternoCrc"));
                listaInternos.add(pDigi);
            }
            return listaInternos;
        } catch (SQLException ex) {
            Logger.getLogger(ControleRelInterno.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
