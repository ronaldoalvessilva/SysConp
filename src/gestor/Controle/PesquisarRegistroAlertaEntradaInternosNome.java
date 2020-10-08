/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AtivarDesativarAlertaEntradas;
import static gestor.Visao.TelaPesquisaAtivaDesativaAlertaEntradas.jIdRegistro;
import static gestor.Visao.TelaPesquisaAtivaDesativaAlertaEntradas.pTOTAL_registros;
import static gestor.Visao.TelaPesquisaAtivaDesativaAlertaEntradas.jNomeInternoPesquisa;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronal
 */
public class PesquisarRegistroAlertaEntradaInternosNome {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AtivarDesativarAlertaEntradas objAlertaEntrada = new AtivarDesativarAlertaEntradas();

    String pCONFIRMACAO_entrada = "Sim";

    public List<AtivarDesativarAlertaEntradas> read() throws Exception {
        pTOTAL_registros = 0;
        conecta.abrirConexao();
        List<AtivarDesativarAlertaEntradas> listaRegistroPrimeiraEntrada = new ArrayList<AtivarDesativarAlertaEntradas>();
        try {
            conecta.executaSQL("SELECT "
                    + "ITENSENTRADAPORTARIA.IdItem, "
                    + "ITENSENTRADAPORTARIA.IdLanc, "
                    + "ITENSENTRADAPORTARIA.DataEntrada, "
                    + "ITENSENTRADAPORTARIA.HoraEntrada, "
                    + "ITENSENTRADAPORTARIA.OficioInternos, "
                    + "ITENSENTRADAPORTARIA.NomeInternoCrc, "
                    + "ITENSENTRADAPORTARIA.OrigemInterno, "
                    + "ITENSENTRADAPORTARIA.ConfirmaEntrada "
                    + "FROM ITENSENTRADAPORTARIA "
                    + "WHERE ITENSENTRADAPORTARIA.NomeInternoCrc LIKE'%" + jNomeInternoPesquisa.getText() + "%' "
                    + "AND ITENSENTRADAPORTARIA.ConfirmaEntrada='" + pCONFIRMACAO_entrada + "'");
            while (conecta.rs.next()) {
                AtivarDesativarAlertaEntradas pREGISTRO_p1 = new AtivarDesativarAlertaEntradas();
                pREGISTRO_p1.setIdItem(conecta.rs.getInt("IdItem"));
                pREGISTRO_p1.setNumeroRegistro(conecta.rs.getInt("IdLanc"));
                pREGISTRO_p1.setDataEntrada(conecta.rs.getDate("DataEntrada"));
                pREGISTRO_p1.setHoraEntrada(conecta.rs.getString("HoraEntrada"));
                pREGISTRO_p1.setNumeroOficio(conecta.rs.getString("OficioInternos"));
                pREGISTRO_p1.setNomeInterno(conecta.rs.getString("NomeInternoCrc"));
                pREGISTRO_p1.setOrigemInterno(conecta.rs.getString("OrigemInterno"));
                pREGISTRO_p1.setConfirmaEntrada(conecta.rs.getString("ConfirmaEntrada"));
                listaRegistroPrimeiraEntrada.add(pREGISTRO_p1);
                pTOTAL_registros = pTOTAL_registros + 1;
            }
            return listaRegistroPrimeiraEntrada;
        } catch (SQLException ex) {
            Logger.getLogger(PesquisarRegistroAlertaEntradaInternosNome.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public AtivarDesativarAlertaEntradas MOSTRAR_registros(AtivarDesativarAlertaEntradas objAlertaEntrada) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "ITENSENTRADAPORTARIA.IdItem, "
                    + "ITENSENTRADAPORTARIA.IdLanc, "
                    + "ITENSENTRADAPORTARIA.DataEntrada, "
                    + "ITENSENTRADAPORTARIA.HoraEntrada, "
                    + "ITENSENTRADAPORTARIA.OficioInternos, "
                    + "ITENSENTRADAPORTARIA.NomeInternoCrc, "
                    + "ITENSENTRADAPORTARIA.OrigemInterno, "
                    + "ITENSENTRADAPORTARIA.ConfirmaEntrada "
                    + "FROM ITENSENTRADAPORTARIA "
                    + "WHERE IdLanc='" + jIdRegistro.getText() + "' "
                    + "AND NomeInternoCrc='" + jNomeInternoPesquisa.getText() + "'");
            conecta.rs.first();
            objAlertaEntrada.setIdItem(conecta.rs.getInt("IdItem"));
            objAlertaEntrada.setNumeroRegistro(conecta.rs.getInt("IdLanc"));
            objAlertaEntrada.setDataEntrada(conecta.rs.getDate("DataEntrada"));
            objAlertaEntrada.setHoraEntrada(conecta.rs.getString("HoraEntrada"));
            objAlertaEntrada.setNumeroOficio(conecta.rs.getString("OficioInternos"));
            objAlertaEntrada.setNomeInterno(conecta.rs.getString("NomeInternoCrc"));
            objAlertaEntrada.setOrigemInterno(conecta.rs.getString("OrigemInterno"));
            objAlertaEntrada.setConfirmaEntrada(conecta.rs.getString("ConfirmaEntrada"));
        } catch (SQLException ex) {
            Logger.getLogger(PesquisarRegistroAlertaEntradaInternosNome.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
        return objAlertaEntrada;
    }
}
