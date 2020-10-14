/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AtivarDesativarAlertaEntradas;
import static gestor.Visao.TelaAlertaEntradas.jComboBoxAtivarDesativar;
import static gestor.Visao.TelaPesquisaAtivaDesativaAlertaRetornos.pTOTAL_registros;
import static gestor.Visao.TelaPesquisaAtivaDesativaAlertaRetornos.jIdRegistro;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronal
 */
public class PesquisarRegistroAlertaRetornosInternos {

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
                        + "ITENSREGISTRO.IdRetorno, "
                        + "ITENSREGISTRO.DataRetorno, "
                        + "ITENSREGISTRO.HorarioRetorno, "
                        + "ITENSREGISTRO.DocumentoRetorno, "
                        + "ITENSREGISTRO.IdInternoCrc, "
                        + "PRONTUARIOSCRC.NomeInternoCrc, "
                        + "ITENSREGISTRO.OrigemRetorno, "
                        + "VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS.RetPort, "
                        + "VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS.RetCrc "
                        + "FROM VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS "
                        + "INNER JOIN ITENSREGISTRO "
                        + "ON VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS.IdInternoCrc=ITENSREGISTRO.IdInternoCrc "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE ITENSREGISTRO.IdRetorno='" + jIdRegistro.getText() + "' "
                        + "AND VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS.RetCrc='" + pCONFIRMACAO_entrada + "'");
                while (conecta.rs.next()) {
                    AtivarDesativarAlertaEntradas pREGISTRO_p1 = new AtivarDesativarAlertaEntradas();
                    pREGISTRO_p1.setIdItem(conecta.rs.getInt("IdRetorno"));
                    pREGISTRO_p1.setNumeroRegistro(conecta.rs.getInt("IdRetorno"));
                    pREGISTRO_p1.setDataEntrada(conecta.rs.getDate("DataRetorno"));
                    pREGISTRO_p1.setHoraEntrada(conecta.rs.getString("HorarioRetorno"));
                    pREGISTRO_p1.setNumeroOficio(conecta.rs.getString("DocumentoRetorno"));
                    pREGISTRO_p1.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                    pREGISTRO_p1.setNomeInterno(conecta.rs.getString("NomeInternoCrc"));
                    pREGISTRO_p1.setOrigemInterno(conecta.rs.getString("OrigemRetorno"));
                    pREGISTRO_p1.setConfirmaEntrada(conecta.rs.getString("RetCrc"));
                    listaRegistroPrimeiraEntrada.add(pREGISTRO_p1);
                    pTOTAL_registros = pTOTAL_registros + 1;
                }
                return listaRegistroPrimeiraEntrada;
            } catch (SQLException ex) {
                Logger.getLogger(PesquisarRegistroAlertaRetornosInternos.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                conecta.desconecta();
            }
        } else if (jComboBoxAtivarDesativar.getSelectedItem().equals("Desativar")) {
            try {
                conecta.executaSQL("SELECT "
                        + "ITENSREGISTRO.IdRetorno, "
                        + "ITENSREGISTRO.DataRetorno, "
                        + "ITENSREGISTRO.HorarioRetorno, "
                        + "ITENSREGISTRO.DocumentoRetorno, "
                        + "ITENSREGISTRO.IdInternoCrc, "
                        + "PRONTUARIOSCRC.NomeInternoCrc, "
                        + "ITENSREGISTRO.OrigemRetorno, "
                        + "VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS.RetPort, "
                        + "VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS.RetCrc "
                        + "FROM VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS "
                        + "INNER JOIN ITENSREGISTRO "
                        + "ON VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS.IdInternoCrc=ITENSREGISTRO.IdInternoCrc "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE ITENSREGISTRO.IdRetorno='" + jIdRegistro.getText() + "' "
                        + "AND VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS.RetCrc='" + pCONFIRMACAO_negada + "'");
                while (conecta.rs.next()) {
                    AtivarDesativarAlertaEntradas pREGISTRO_p1 = new AtivarDesativarAlertaEntradas();
                    pREGISTRO_p1.setIdItem(conecta.rs.getInt("IdRetorno"));
                    pREGISTRO_p1.setNumeroRegistro(conecta.rs.getInt("IdRetorno"));
                    pREGISTRO_p1.setDataEntrada(conecta.rs.getDate("DataRetorno"));
                    pREGISTRO_p1.setHoraEntrada(conecta.rs.getString("HorarioRetorno"));
                    pREGISTRO_p1.setNumeroOficio(conecta.rs.getString("DocumentoRetorno"));
                    pREGISTRO_p1.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                    pREGISTRO_p1.setNomeInterno(conecta.rs.getString("NomeInternoCrc"));
                    pREGISTRO_p1.setOrigemInterno(conecta.rs.getString("OrigemRetorno"));
                    pREGISTRO_p1.setConfirmaEntrada(conecta.rs.getString("RetCrc"));
                    listaRegistroPrimeiraEntrada.add(pREGISTRO_p1);
                    pTOTAL_registros = pTOTAL_registros + 1;
                }
                return listaRegistroPrimeiraEntrada;
            } catch (SQLException ex) {
                Logger.getLogger(PesquisarRegistroAlertaRetornosInternos.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                conecta.desconecta();
            }
        }
        return null;
    }
}
