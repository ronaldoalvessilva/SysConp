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
import static gestor.Visao.TelaAtividadesMensalUnidade.pQUANTIDADE_DIABETES;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import static gestor.Visao.TelaAtividadesMensalUnidade.pQUANTIDADE_HIPERTENSAO;
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
public class ListagemControleDiabetes {

    //MODELO DA LISTAGEM PARA O SERVIÇO SOCIAL. AINDA NÃO FOI DEVIDAMENTE IMPLEMENTADA.
    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AtividadesMensalRealizadaUnidades objAtividade = new AtividadesMensalRealizadaUnidades();
    //
    String pDATA_INICIAL;
    String pDATA_FINAL;
    //TIPOS DE AGRAVOS DIAGNOSTICADOS
    int pDIABETES = 0;

    public List<AtividadesMensalRealizadaUnidades> read() throws Exception {
        pQUANTIDADE_DIABETES = 0;
        List<AtividadesMensalRealizadaUnidades> listaAgravoDiagnosticado = new ArrayList<AtividadesMensalRealizadaUnidades>();
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
            conecta.executaSQL("SELECT DataReg,QtdDiabetes "
                    + "FROM ACOMPANHAMENTO_INTERNO_ENFERMARIA "
                    + "WHERE CONVERT(DATE, DataReg) BETWEEN'" + pDATA_INICIAL + "' "
                    + "AND '" + pDATA_FINAL + "' "
                    + "AND QtdDiabetes>'" + pDIABETES + "' "
                    + "AND QtdDiabetes IS NOT NULL");
            while (conecta.rs.next()) {
                AtividadesMensalRealizadaUnidades pAgravoDiag = new AtividadesMensalRealizadaUnidades();
                pAgravoDiag.setDataAtendimento(conecta.rs.getDate("DataReg"));
                if (pDIABETES > pDIABETES) {
                    pQUANTIDADE_DIABETES = pQUANTIDADE_DIABETES + 1;
                    pAgravoDiag.setDiabetes(pQUANTIDADE_DIABETES);
                }
                pQUANTIDADE_DIABETES = pQUANTIDADE_DIABETES + 1;
                listaAgravoDiagnosticado.add(pAgravoDiag);
            }
            return listaAgravoDiagnosticado;
        } catch (SQLException ex) {
            Logger.getLogger(listarInternosPopulacaoNominal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
