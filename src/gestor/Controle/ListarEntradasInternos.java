/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.FechamentoRegistros;
import static gestor.Visao.TelaFechamentoSistema.pTOTAL_ENTRADAS;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronal
 */
public class ListarEntradasInternos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    FechamentoRegistros objFecha = new FechamentoRegistros();
    //
    String pSTATUS_ENTRADA = "ABERTO";

    public List<FechamentoRegistros> read() throws Exception {
        pTOTAL_ENTRADAS = 0;
        List<FechamentoRegistros> listaTodasEntradas = new ArrayList<FechamentoRegistros>();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT StatusEnt "
                    + "FROM ENTRADALOTE "
                    + "WHERE StatusEnt='" + pSTATUS_ENTRADA + "'");
            while (conecta.rs.next()) {
                FechamentoRegistros pEntradas = new FechamentoRegistros();
                pEntradas.setStatusRegistro(conecta.rs.getString("StatusEnt"));
                listaTodasEntradas.add(pEntradas);
                pTOTAL_ENTRADAS = pTOTAL_ENTRADAS + 1;
            }
            return listaTodasEntradas;
        } catch (SQLException ex) {
            Logger.getLogger(ListarEntradasInternos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
