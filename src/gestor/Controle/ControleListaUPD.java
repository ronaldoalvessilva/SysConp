/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ProntuarioCrc;
import gestor.Modelo.UnidadePenal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronal
 */
public class ControleListaUPD {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    UnidadePenal objUni = new UnidadePenal();

    String pSTATUS = "Ativo";

    public List<UnidadePenal> read() throws Exception {
        conecta.abrirConexao();
        List<UnidadePenal> listaUnid = new ArrayList<UnidadePenal>();
        try {
            conecta.executaSQL("SELECT * FROM UNIDADE");
            while (conecta.rs.next()) {
                UnidadePenal pDigi = new UnidadePenal();
                pDigi.setIdUnid(conecta.rs.getInt("IdUnid"));
                pDigi.setDescricaoUnid(conecta.rs.getString("DescricaoUnid"));
                listaUnid.add(pDigi);
            }
            return listaUnid;
        } catch (SQLException ex) {
            Logger.getLogger(ControleListaUPD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
