/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import Utilitarios.listarInternosPopulacaoNominal;
import gestor.Modelo.AtividadesMensalRealizadaUnidades;
import static gestor.Visao.TelaAtividadesMensalUnidade.jDataPeriodoFinal;
import static gestor.Visao.TelaAtividadesMensalUnidade.jDataPeriodoInicial;
import static gestor.Visao.TelaAtividadesMensalUnidade.pPRESENCA_INTERNO;
import static gestor.Visao.TelaAtividadesMensalUnidade.pQUANTIDADE_INTERNOS_PRESENTE;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ronal
 */
public class ListagemInternosFrequenciaPedagogia {

    //MODELO DA LISTAGEM PARA O SERVIÇO SOCIAL. AINDA NÃO FOI DEVIDAMENTE IMPLEMENTADA.
    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AtividadesMensalRealizadaUnidades objAtividade = new AtividadesMensalRealizadaUnidades();
    //
    String pDATA_INICIAL;
    String pDATA_FINAL;
    String pREGIME_INTERNO = "Provisório";
    String pENTRADA_UNIDADE = "ENTRADA NA UNIDADE";
    String pRETORNO_UNIDADE = "RETORNO A UNIDADE";

    public List<AtividadesMensalRealizadaUnidades> read() throws Exception {
        pQUANTIDADE_INTERNOS_PRESENTE = 0;
        List<AtividadesMensalRealizadaUnidades> listaInternospIntFreq = new ArrayList<AtividadesMensalRealizadaUnidades>();
        if (tipoServidor == null || tipoServidor.equals("")) {
            JOptionPane.showMessageDialog(null, "É necessário definir o parâmtero para o sistema operacional utilizado no servidor, (UBUNTU-LINUX ou WINDOWS SERVER).");
        } else if (tipoServidor.equals("Servidor Linux (Ubuntu)/MS-SQL Server")) {
            SimpleDateFormat formatoAmerica = new SimpleDateFormat("yyyy/MM/dd");
            pDATA_INICIAL = formatoAmerica.format(jDataPeriodoInicial.getDate().getTime());
            pDATA_FINAL = formatoAmerica.format(jDataPeriodoFinal.getDate().getTime());
        } else if (tipoServidor.equals("Servidor Windows/MS-SQL Server")) {
            SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
            pDATA_INICIAL = formatoAmerica.format(jDataPeriodoInicial.getDate().getTime());
            pDATA_FINAL = formatoAmerica.format(jDataPeriodoFinal.getDate().getTime());
        }
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT DataFreq "
                    + "FROM FREQUENCIA "
                    + "INNER JOIN ITENSFREQUENCIA "
                    + "ON FREQUENCIA.IdFreq=ITENSFREQUENCIA.IdFreq "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENSFREQUENCIA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "WHERE PRONTUARIOSCRC.SituacaoCrc='" + pENTRADA_UNIDADE + "' "
                    + "AND DADOSPENAISINTERNOS.Regime!='" + pREGIME_INTERNO + "' "
                    + "AND Presenca='" + pPRESENCA_INTERNO + "' "
                    + "AND CONVERT(DATE, DataFreq) BETWEEN'" + pDATA_INICIAL + "' "
                    + "AND '" + pDATA_FINAL + "' "
                    + "OR PRONTUARIOSCRC.SituacaoCrc='" + pRETORNO_UNIDADE + "' "
                    + "AND DADOSPENAISINTERNOS.Regime!='" + pREGIME_INTERNO + "' "
                    + "AND Presenca='" + pPRESENCA_INTERNO + "' "
                    + "AND CONVERT(DATE, DataFreq) BETWEEN'" + pDATA_INICIAL + "' "
                    + "AND '" + pDATA_FINAL + "'");
            while (conecta.rs.next()) {
                AtividadesMensalRealizadaUnidades pIntFreq = new AtividadesMensalRealizadaUnidades();
                pIntFreq.setDataMatricula(conecta.rs.getDate("DataFreq"));
                listaInternospIntFreq.add(pIntFreq);
                pQUANTIDADE_INTERNOS_PRESENTE = pQUANTIDADE_INTERNOS_PRESENTE + 1;
            }
            return listaInternospIntFreq;
        } catch (SQLException ex) {
            Logger.getLogger(listarInternosPopulacaoNominal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
