/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AtividadesMensalRealizadaUnidades;
import static gestor.Visao.TelaAtividadesMensalUnidade.jDataPeriodoFinal;
import static gestor.Visao.TelaAtividadesMensalUnidade.jDataPeriodoInicial;
import static gestor.Visao.TelaAtividadesMensalUnidade.pQUANTIDADE_INTERNOS_CIVIL;
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
public class ListagemInternosCivilmente {

    //MODELO DA LISTAGEM PARA O SERVIÇO SOCIAL. AINDA NÃO FOI DEVIDAMENTE IMPLEMENTADA.
    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AtividadesMensalRealizadaUnidades objAtividade = new AtividadesMensalRealizadaUnidades();
    //
    String pDATA_INICIAL;
    String pDATA_FINAL;
    String pRG = "Sim";
    String pCTPS = "Sim";
    String pPASSAPORTE = "Sim";
    String pRESERVISTA = "Sim";
    String pCNH = "Sim";

    public List<AtividadesMensalRealizadaUnidades> read() throws Exception {
        pQUANTIDADE_INTERNOS_CIVIL = 0;
        List<AtividadesMensalRealizadaUnidades> listaAtendSS = new ArrayList<AtividadesMensalRealizadaUnidades>();
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
            conecta.executaSQL("SELECT DataDoc,IdInternoCrc, "
                    + "RgDoc,CnhDoc, "
                    + "ReservistaDoc, "
                    + "CtpsDoc,OutrosDoc "
                    + "FROM DOCINTERNOS "
                    + "WHERE CONVERT(DATE, DataDoc) BETWEEN'" + pDATA_INICIAL + "' "
                    + "AND '" + pDATA_FINAL + "' "
                    + "AND RgDoc='" + pRG + "' "
                    + "OR CONVERT(DATE, DataDoc) BETWEEN'" + pDATA_INICIAL + "' "
                    + "AND '" + pDATA_FINAL + "' "
                    + "AND OutrosDoc='" + pPASSAPORTE + "' "
                    + "OR CONVERT(DATE, DataDoc) BETWEEN'" + pDATA_INICIAL + "' "
                    + "AND '" + pDATA_FINAL + "' "
                    + "AND CtpsDoc='" + pCTPS + "' "
                    + "OR CONVERT(DATE, DataDoc) BETWEEN'" + pDATA_INICIAL + "' "
                    + "AND '" + pDATA_FINAL + "' "
                    + "AND CnhDoc='" + pCNH + "' "
                    + "OR CONVERT(DATE, DataDoc) BETWEEN'" + pDATA_INICIAL + "' "
                    + "AND '" + pDATA_FINAL + "' "
                    + "AND ReservistaDoc='" + pRESERVISTA + "'");
            while (conecta.rs.next()) {
                AtividadesMensalRealizadaUnidades pAtivaSS = new AtividadesMensalRealizadaUnidades();
                pAtivaSS.setDataAtendimento(conecta.rs.getDate("DataDoc"));
                listaAtendSS.add(pAtivaSS);
                pQUANTIDADE_INTERNOS_CIVIL = pQUANTIDADE_INTERNOS_CIVIL + 1;
            }
            return listaAtendSS;
        } catch (SQLException ex) {
            Logger.getLogger(listarInternosPopulacaoNominal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
