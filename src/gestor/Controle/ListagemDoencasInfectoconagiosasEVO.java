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
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import static gestor.Visao.TelaAtividadesMensalUnidade.pQUANTIDADE_VDRL;
import static gestor.Visao.TelaAtividadesMensalUnidade.pQUANTIDADE_HEPATITE_C;
import static gestor.Visao.TelaAtividadesMensalUnidade.pQUANTIDADE_HIV;
import static gestor.Visao.TelaAtividadesMensalUnidade.pQUANTIDADE_SIFILIS;
import static gestor.Visao.TelaAtividadesMensalUnidade.pQUANTIDADE_HPV;
import static gestor.Visao.TelaAtividadesMensalUnidade.pQUANTIDADE_DIABETES;
import static gestor.Visao.TelaAtividadesMensalUnidade.pQUANTIDADE_HIPERTENSAO;
import static gestor.Visao.TelaAtividadesMensalUnidade.pQUANTIDADE_TUBERCULOSE;
import static gestor.Visao.TelaAtividadesMensalUnidade.pQUANTIDADE_HANSEINIASE;
import static gestor.Visao.TelaAtividadesMensalUnidade.pQUANTIDADE_DST;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static gestor.Visao.TelaAtividadesMensalUnidade.pQUANTIDADE_ESCABIOSE;
import static gestor.Visao.TelaAtividadesMensalUnidade.pQUANTIDADE_TOTAL_INFECTO_EVO;
import static gestor.Visao.TelaAtividadesMensalUnidade.pQUANTIDADE_VACINADOS;

/**
 *
 * @author ronal
 */
public class ListagemDoencasInfectoconagiosasEVO {
    
    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AtividadesMensalRealizadaUnidades objAtividade = new AtividadesMensalRealizadaUnidades();
    //
    String pDATA_INICIAL;
    String pDATA_FINAL;
    String pHEPATITE_B = "Reagente";
    String pHEPATITE_C = "Reagente";
    String pHIV = "Reagente";
    String pSIFILIS = "Reagente";
    String pHPV = "Sim";
    String pTUBERCULOSE = "Positivo";
    String pHANSEINIASE = "Reagente";
    String pESCABIOSE = "Sim";
    String pDST = "Sim";

    public List<AtividadesMensalRealizadaUnidades> read() throws Exception {
        pQUANTIDADE_VDRL = 0;
        pQUANTIDADE_VACINADOS = 0;
        pQUANTIDADE_HEPATITE_C = 0;
        pQUANTIDADE_HIV = 0;
        pQUANTIDADE_SIFILIS = 0;
        pQUANTIDADE_HPV = 0;
        pQUANTIDADE_DIABETES = 0;
        pQUANTIDADE_HIPERTENSAO = 0;
        pQUANTIDADE_TUBERCULOSE = 0;
        pQUANTIDADE_HANSEINIASE = 0;
        pQUANTIDADE_ESCABIOSE = 0;
        pQUANTIDADE_DST = 0;
        pQUANTIDADE_TOTAL_INFECTO_EVO = 0;
        List<AtividadesMensalRealizadaUnidades> listaInfectoDiagnosticadoEVO = new ArrayList<AtividadesMensalRealizadaUnidades>();
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
            conecta.executaSQL("SELECT DataReg,HepatiteB, "
                    + "HepatiteC,Hiv,Sifilis, "
                    + "Tuberculose,Hanseniase, "
                    + "Escabiose,Dst "
                    + "FROM ACOMPANHAMENTO_INTERNO_ENFERMARIA "
                    + "WHERE "
                    + "CONVERT(DATE, DataReg) BETWEEN'" + pDATA_INICIAL + "' "
                    + "AND '" + pDATA_FINAL + "' "
                    + "AND HepatiteB='" + pHEPATITE_B + "' "
                    + "OR CONVERT(DATE, DataReg) BETWEEN'" + pDATA_INICIAL + "' "
                    + "AND '" + pDATA_FINAL + "' "
                    + "AND HepatiteC='" + pHEPATITE_C + "' "
                    + "OR CONVERT(DATE, DataReg) BETWEEN'" + pDATA_INICIAL + "' "
                    + "AND '" + pDATA_FINAL + "'  "
                    + "AND Hiv='" + pHIV + "' "
                    + "OR CONVERT(DATE, DataReg) BETWEEN'" + pDATA_INICIAL + "' "
                    + "AND '" + pDATA_FINAL + "' "
                    + "AND Sifilis='" + pSIFILIS + "' "
                    + "OR CONVERT(DATE, DataReg) BETWEEN'" + pDATA_INICIAL + "' "
                    + "AND '" + pDATA_FINAL + "' "
                    + "AND Tuberculose='" + pTUBERCULOSE + "' "
                    + "OR CONVERT(DATE, DataReg) BETWEEN'" + pDATA_INICIAL + "' "
                    + "AND '" + pDATA_FINAL + "' "
                    + "AND Hanseniase='" + pHANSEINIASE + "' "
                    + "OR CONVERT(DATE, DataReg) BETWEEN'" + pDATA_INICIAL + "' "
                    + "AND '" + pDATA_FINAL + "' "
                    + "AND Escabiose='" + pESCABIOSE + "' "
                    + "OR CONVERT(DATE, DataReg) BETWEEN'" + pDATA_INICIAL + "' "
                    + "AND '" + pDATA_FINAL + "' "
                    + "AND Dst='" + pDST + "'");
            while (conecta.rs.next()) {
                AtividadesMensalRealizadaUnidades pInfectoEvo = new AtividadesMensalRealizadaUnidades();
                pInfectoEvo.setDataAtendimento(conecta.rs.getDate("DataReg"));
                if (pHEPATITE_B.equals("Reagente")) {
                    pQUANTIDADE_VACINADOS = pQUANTIDADE_VACINADOS + 1;
                    pInfectoEvo.setHepatiteB(pQUANTIDADE_VACINADOS);
                } else if (pHEPATITE_C.equals("Reagente")) {
                    pQUANTIDADE_HEPATITE_C = pQUANTIDADE_HEPATITE_C + 1;
                    pInfectoEvo.setHepatiteC(pQUANTIDADE_HEPATITE_C);
                } else if (pHIV.equals("Reagente")) {
                    pQUANTIDADE_HIV = pQUANTIDADE_HIV + 1;
                    pInfectoEvo.setHiv(pQUANTIDADE_HIV);
                } else if (pSIFILIS.equals("Reagente")) {
                    pQUANTIDADE_SIFILIS = pQUANTIDADE_SIFILIS + 1;
                    pInfectoEvo.setSifilis(pQUANTIDADE_SIFILIS);
                } else if (pHPV.equals("Sim")) {
                    pQUANTIDADE_HPV = pQUANTIDADE_HPV + 1;
                    pInfectoEvo.setHpv(pQUANTIDADE_HPV);
                } else if (pTUBERCULOSE.equals("Positivo")) {
                    pQUANTIDADE_TUBERCULOSE = pQUANTIDADE_TUBERCULOSE + 1;
                    pInfectoEvo.setTuberculose(pQUANTIDADE_TUBERCULOSE);
                } else if (pHANSEINIASE.equals("Reagente")) {
                    pQUANTIDADE_HANSEINIASE = pQUANTIDADE_HANSEINIASE + 1;
                    pInfectoEvo.setHanseniase(pQUANTIDADE_HANSEINIASE);
                } else if (pESCABIOSE.equals("Sim")) {
                    pQUANTIDADE_ESCABIOSE = pQUANTIDADE_ESCABIOSE + 1;
                    pInfectoEvo.setEscabiose(pQUANTIDADE_ESCABIOSE);
                } else if (pDST.equals("Reagente")) {
                    pQUANTIDADE_DST = pQUANTIDADE_DST + 1;
                    pInfectoEvo.setDst(pQUANTIDADE_DST);
                }
                pQUANTIDADE_TOTAL_INFECTO_EVO = pQUANTIDADE_VACINADOS + pQUANTIDADE_HEPATITE_C + pQUANTIDADE_HIV + pQUANTIDADE_SIFILIS + pQUANTIDADE_HPV + pQUANTIDADE_TUBERCULOSE + pQUANTIDADE_HANSEINIASE + pQUANTIDADE_ESCABIOSE + pQUANTIDADE_DST;
                pInfectoEvo.setQuantidadeEvoInfectoTotal(pQUANTIDADE_TOTAL_INFECTO_EVO);
                listaInfectoDiagnosticadoEVO.add(pInfectoEvo);
            }
            return listaInfectoDiagnosticadoEVO;
        } catch (SQLException ex) {
            Logger.getLogger(listarInternosPopulacaoNominal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
