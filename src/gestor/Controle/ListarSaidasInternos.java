/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.FechamentoRegistros;
import static gestor.Visao.TelaFechamentoSistema.pTOTAL_SAIDAS;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronal
 */
public class ListarSaidasInternos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    FechamentoRegistros objFecha = new FechamentoRegistros();
    //
    String pSTATUS_SAIDAS = "ABERTO";

    public List<FechamentoRegistros> read() throws Exception {
        pTOTAL_SAIDAS = 0;
        List<FechamentoRegistros> listaTodasSaidas = new ArrayList<FechamentoRegistros>();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT StatusSai "
                    + "FROM SAIDACRC "
                    + "WHERE StatusSai='" + pSTATUS_SAIDAS + "'");
            while (conecta.rs.next()) {
                FechamentoRegistros pSaidas = new FechamentoRegistros();
                pSaidas.setStatusRegistro(conecta.rs.getString("StatusSai"));
                listaTodasSaidas.add(pSaidas);
                pTOTAL_SAIDAS = pTOTAL_SAIDAS + 1;
            }
            return listaTodasSaidas;
        } catch (SQLException ex) {
            Logger.getLogger(ListarSaidasInternos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
