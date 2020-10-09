/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AtivarDesativarAlertaEntradas;
import static gestor.Visao.TelaAlertaEntradas.jComboBoxAtivarDesativar;
import static gestor.Visao.TelaPesquisaAtivaDesativaAlertaNovaEntradas.pTOTAL_registros;
import static gestor.Visao.TelaPesquisaAtivaDesativaAlertaNovaEntradas.jIdRegistro;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronal
 */
public class PesquisarRegistroAlertaNovaEntradaInternos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AtivarDesativarAlertaEntradas objSaida = new AtivarDesativarAlertaEntradas();

    String pCONFIRMACAO_entrada = "Sim";
    String pCONFIRMACAO_negada = "Não";

    public List<AtivarDesativarAlertaEntradas> read() throws Exception {
        pTOTAL_registros = 0;
        conecta.abrirConexao();
        List<AtivarDesativarAlertaEntradas> listaRegistroPrimeiraEntrada = new ArrayList<AtivarDesativarAlertaEntradas>();
        if (jComboBoxAtivarDesativar.getSelectedItem().equals("Ativar")) {
            try {
                conecta.executaSQL("SELECT "
                        + "ITENSNOVAENTRADA.IdItem, "
                        + "ITENSNOVAENTRADA.IdEntrada, "
                        + "ITENSNOVAENTRADA.DataEntrada, "
                        + "ITENSNOVAENTRADA.HorarioEntrada, "
                        + "ITENSNOVAENTRADA.NrOficio, "
                        + "ITENSNOVAENTRADA.IdInternoCrc, "
                        + "PRONTUARIOSCRC.NomeInternoCrc, "
                        + "ITENSNOVAENTRADA.OrigemInterno, "
                        + "ITENSNOVAENTRADA.UtilizadoCrc "
                        + "FROM ITENSENTRADAPORTARIA "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ITENSNOVAENTRADA.idInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE ITENSNOVAENTRADA.IdEntrada='" + jIdRegistro.getText() + "' "
                        + "AND ITENSNOVAENTRADA.UtilizadoCrc='" + pCONFIRMACAO_entrada + "'");
                while (conecta.rs.next()) {
                    AtivarDesativarAlertaEntradas pREGISTRO_p1 = new AtivarDesativarAlertaEntradas();
                    pREGISTRO_p1.setIdItem(conecta.rs.getInt("IdItem"));
                    pREGISTRO_p1.setNumeroRegistro(conecta.rs.getInt("IdEntrada"));
                    pREGISTRO_p1.setDataEntrada(conecta.rs.getDate("DataEntrada"));
                    pREGISTRO_p1.setHoraEntrada(conecta.rs.getString("HorarioEntrada"));
                    pREGISTRO_p1.setNumeroOficio(conecta.rs.getString("NrOficio"));
                    pREGISTRO_p1.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                    pREGISTRO_p1.setNomeInterno(conecta.rs.getString("NomeInternoCrc"));
                    pREGISTRO_p1.setOrigemInterno(conecta.rs.getString("OrigemInterno"));
                    pREGISTRO_p1.setConfirmaEntrada(conecta.rs.getString("UtilizadoCrc"));
                    listaRegistroPrimeiraEntrada.add(pREGISTRO_p1);
                    pTOTAL_registros = pTOTAL_registros + 1;
                }
                return listaRegistroPrimeiraEntrada;
            } catch (SQLException ex) {
                Logger.getLogger(PesquisarRegistroAlertaNovaEntradaInternos.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                conecta.desconecta();
            }
        } else if (jComboBoxAtivarDesativar.getSelectedItem().equals("Desativar")) {
            try {
                conecta.executaSQL("SELECT "
                        + "ITENSNOVAENTRADA.IdItem, "
                        + "ITENSNOVAENTRADA.IdEntrada, "
                        + "ITENSNOVAENTRADA.DataEntrada, "
                        + "ITENSNOVAENTRADA.HorarioEntrada, "
                        + "ITENSNOVAENTRADA.NrOficio, "
                        + "ITENSNOVAENTRADA.IdInternoCrc, "
                        + "PRONTUARIOSCRC.NomeInternoCrc, "
                        + "ITENSNOVAENTRADA.OrigemInterno, "
                        + "ITENSNOVAENTRADA.UtilizadoCrc "
                        + "FROM ITENSENTRADAPORTARIA "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ITENSNOVAENTRADA.idInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE ITENSNOVAENTRADA.IdEntrada='" + jIdRegistro.getText() + "' "
                        + "AND ITENSNOVAENTRADA.UtilizadoCrc='" + pCONFIRMACAO_negada + "'");
                while (conecta.rs.next()) {
                    AtivarDesativarAlertaEntradas pREGISTRO_p1 = new AtivarDesativarAlertaEntradas();
                    pREGISTRO_p1.setIdItem(conecta.rs.getInt("IdItem"));
                    pREGISTRO_p1.setNumeroRegistro(conecta.rs.getInt("IdEntrada"));
                    pREGISTRO_p1.setDataEntrada(conecta.rs.getDate("DataEntrada"));
                    pREGISTRO_p1.setHoraEntrada(conecta.rs.getString("HorarioEntrada"));
                    pREGISTRO_p1.setNumeroOficio(conecta.rs.getString("NrOficio"));
                    pREGISTRO_p1.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                    pREGISTRO_p1.setNomeInterno(conecta.rs.getString("NomeInternoCrc"));
                    pREGISTRO_p1.setOrigemInterno(conecta.rs.getString("OrigemInterno"));
                    pREGISTRO_p1.setConfirmaEntrada(conecta.rs.getString("UtilizadoCrc"));
                    listaRegistroPrimeiraEntrada.add(pREGISTRO_p1);
                    pTOTAL_registros = pTOTAL_registros + 1;
                }
                return listaRegistroPrimeiraEntrada;
            } catch (SQLException ex) {
                Logger.getLogger(PesquisarRegistroAlertaNovaEntradaInternos.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                conecta.desconecta();
            }
        }
        return null;
    }
}
