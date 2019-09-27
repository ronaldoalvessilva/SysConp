/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.VaraCondenatoria;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronal
 */
public class ControleListaVC {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    VaraCondenatoria objVara = new VaraCondenatoria();

    String pSTATUS = "Ativo";

    public List<VaraCondenatoria> read() throws Exception {
        conecta.abrirConexao();
        List<VaraCondenatoria> listaUnid = new ArrayList<VaraCondenatoria>();
        try {
            conecta.executaSQL("SELECT * FROM DADOSPENAISINTERNOS");
            while (conecta.rs.next()) {
                VaraCondenatoria pDigi = new VaraCondenatoria();
                pDigi.setDescricaoVaraCondenatoria(conecta.rs.getString("VaraCondenatoria"));
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
