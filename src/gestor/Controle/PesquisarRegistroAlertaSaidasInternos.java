/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AtivarDesativarAlertaEntradas;
import static gestor.Visao.TelaAlertaEntradas.jComboBoxAtivarDesativar;
import static gestor.Visao.TelaPesquisaAtivaDesativaAlertaSaidasP1.pTOTAL_registros;
import static gestor.Visao.TelaPesquisaAtivaDesativaAlertaSaidasP1.jIdRegistro;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronal
 */
public class PesquisarRegistroAlertaSaidasInternos {

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
                conecta.executaSQL("SELECT DISTINCT "
                        + "ITENSREGSAIDA.IdSaidaTmp, "
                        + "ITENSREGSAIDA.IdSaida, "
                        + "ITENSREGSAIDA.DataSaida, "
                        + "ITENSREGSAIDA.HoraSaida, "
                        + "ITENSREGSAIDA.DocumentoSaida, "
                        + "ITENSREGSAIDA.IdInternoCrc, "
                        + "PRONTUARIOSCRC.NomeInternoCrc, "
                        + "ITENSREGSAIDA.DestinoSaida, "
                        + "ITENSCRCPORTARIA.SaidaConfirmada "
                        + "FROM ITENSCRCPORTARIA "
                        + "INNER JOIN ITENSREGSAIDA "
                        + "ON ITENSCRCPORTARIA.IdInternoCrc=ITENSREGSAIDA.IdInternoCrc "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ITENSCRCPORTARIA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE ITENSREGSAIDA.IdSaidaTmp='" + jIdRegistro.getText() + "' "
                        + "AND ITENSCRCPORTARIA.SaidaConfirmada='" + pCONFIRMACAO_entrada + "'");
                while (conecta.rs.next()) {
                    AtivarDesativarAlertaEntradas pREGISTRO_p1 = new AtivarDesativarAlertaEntradas();
                    pREGISTRO_p1.setIdItem(conecta.rs.getInt("IdSaidaTmp"));
                    pREGISTRO_p1.setNumeroRegistro(conecta.rs.getInt("IdSaida"));
                    pREGISTRO_p1.setDataEntrada(conecta.rs.getDate("DataSaida"));
                    pREGISTRO_p1.setHoraEntrada(conecta.rs.getString("HoraSaida"));
                    pREGISTRO_p1.setNumeroOficio(conecta.rs.getString("DocumentoSaida"));
                    pREGISTRO_p1.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                    pREGISTRO_p1.setNomeInterno(conecta.rs.getString("NomeInternoCrc"));
                    pREGISTRO_p1.setOrigemInterno(conecta.rs.getString("DestinoSaida"));
                    pREGISTRO_p1.setConfirmaEntrada(conecta.rs.getString("SaidaConfirmada"));
                    listaRegistroPrimeiraEntrada.add(pREGISTRO_p1);
                    pTOTAL_registros = pTOTAL_registros + 1;
                }
                return listaRegistroPrimeiraEntrada;
            } catch (SQLException ex) {
                Logger.getLogger(PesquisarRegistroAlertaSaidasInternos.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                conecta.desconecta();
            }
        } else if (jComboBoxAtivarDesativar.getSelectedItem().equals("Desativar")) {
            try {
                conecta.executaSQL("SELECT DISTINCT "
                        + "ITENSREGSAIDA.IdSaidaTmp, "
                        + "ITENSREGSAIDA.IdSaida, "
                        + "ITENSREGSAIDA.DataSaida, "
                        + "ITENSREGSAIDA.HoraSaida, "
                        + "ITENSREGSAIDA.DocumentoSaida, "
                        + "ITENSCRCPORTARIA.IdInternoCrc, "
                        + "PRONTUARIOSCRC.NomeInternoCrc, "
                        + "ITENSREGSAIDA.DestinoSaida, "
                        + "ITENSCRCPORTARIA.SaidaConfirmada "
                        + "FROM ITENSCRCPORTARIA "
                        + "INNER JOIN ITENSREGSAIDA "
                        + "ON ITENSCRCPORTARIA.IdInternoCrc=ITENSREGSAIDA.IdInternoCrc "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ITENSCRCPORTARIA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE ITENSREGSAIDA.IdSaida='" + jIdRegistro.getText() + "' "
                        + "AND ITENSCRCPORTARIA.SaidaConfirmada='" + pCONFIRMACAO_negada + "'");
                while (conecta.rs.next()) {
                    AtivarDesativarAlertaEntradas pREGISTRO_p1 = new AtivarDesativarAlertaEntradas();
                    pREGISTRO_p1.setIdItem(conecta.rs.getInt("IdSaidaTmp"));
                    pREGISTRO_p1.setNumeroRegistro(conecta.rs.getInt("IdSaida"));
                    pREGISTRO_p1.setDataEntrada(conecta.rs.getDate("DataSaida"));
                    pREGISTRO_p1.setHoraEntrada(conecta.rs.getString("HoraSaida"));
                    pREGISTRO_p1.setNumeroOficio(conecta.rs.getString("DocumentoSaida"));
                    pREGISTRO_p1.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                    pREGISTRO_p1.setNomeInterno(conecta.rs.getString("NomeInternoCrc"));
                    pREGISTRO_p1.setOrigemInterno(conecta.rs.getString("DestinoSaida"));
                    pREGISTRO_p1.setConfirmaEntrada(conecta.rs.getString("SaidaConfirmada"));
                    listaRegistroPrimeiraEntrada.add(pREGISTRO_p1);
                    pTOTAL_registros = pTOTAL_registros + 1;
                }
                return listaRegistroPrimeiraEntrada;
            } catch (SQLException ex) {
                Logger.getLogger(PesquisarRegistroAlertaSaidasInternos.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                conecta.desconecta();
            }
        }
        return null;
    }
}
