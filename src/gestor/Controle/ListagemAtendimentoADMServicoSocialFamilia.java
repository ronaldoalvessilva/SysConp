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
import static gestor.Visao.TelaAtividadesMensalUnidade.pQUANTIDADE_ADM_SOCIAL;
import static gestor.Visao.TelaAtividadesMensalUnidade.pQUANTIDADE_ATE_FAMILIA;
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
public class ListagemAtendimentoADMServicoSocialFamilia {

    //MODELO DA LISTAGEM PARA O SERVIÇO SOCIAL. AINDA NÃO FOI DEVIDAMENTE IMPLEMENTADA.
    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AtividadesMensalRealizadaUnidades objAtividade = new AtividadesMensalRealizadaUnidades();
    //
    String pDATA_INICIAL;
    String pDATA_FINAL;

    public List<AtividadesMensalRealizadaUnidades> read() throws Exception {
        pQUANTIDADE_ADM_SOCIAL = 0;
        List<AtividadesMensalRealizadaUnidades> listaAtendInternos = new ArrayList<AtividadesMensalRealizadaUnidades>();
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
            conecta.executaSQL("SELECT DataAtendf "
                    + "FROM ATENDIMENTOFAMILIAR A "
                    + "INNER JOIN EVOLUCAO_ATENDIMENTO_FAMILIA B "
                    + "ON A.IdVisita = B.IdVisita "
                    + "WHERE CONVERT(DATE, A.DataAtendf) BETWEEN'" + pDATA_INICIAL + "' "
                    + "AND '" + pDATA_FINAL + "' ");                   
            while (conecta.rs.next()) {
                AtividadesMensalRealizadaUnidades pAtivaSSF = new AtividadesMensalRealizadaUnidades();
                pAtivaSSF.setDataAtendimento(conecta.rs.getDate("DataAtendf"));
                listaAtendInternos.add(pAtivaSSF);
                pQUANTIDADE_ATE_FAMILIA = pQUANTIDADE_ATE_FAMILIA + 1;
            }
            return listaAtendInternos;
        } catch (SQLException ex) {
            Logger.getLogger(listarInternosPopulacaoNominal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
