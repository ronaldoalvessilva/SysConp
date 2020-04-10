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
import static gestor.Visao.TelaAtividadesMensalUnidade.pQUANTIDADE_TOTAL_TO;
import static gestor.Visao.TelaAtividadesMensalUnidade.pTIPO_ATENDIMENTO_ADM_TO;
import static gestor.Visao.TelaAtividadesMensalUnidade.pTIPO_ATENDIMENTO_EVO_TO;
import static gestor.Visao.TelaAtividadesMensalUnidade.pTIPO_ATENDIMENTO_GRUPO_TO;
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
public class ListagemAtendimentoADMEVOLTerapaia {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AtividadesMensalRealizadaUnidades objAtividade = new AtividadesMensalRealizadaUnidades();
    //
    String pDATA_INICIAL;
    String pDATA_FINAL;

    public List<AtividadesMensalRealizadaUnidades> read() throws Exception {
        pQUANTIDADE_TOTAL_TO = 0;
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
            conecta.executaSQL("SELECT DataAtendimento,TipoAtendimento "
                    + "FROM REGISTRO_ATENDIMENTO_INTERNO_PSP "
                    + "WHERE CONVERT(DATE, DataAtendimento) BETWEEN'" + pDATA_INICIAL + "' "
                    + "AND '" + pDATA_FINAL + "' "
                    + "AND TipoAtendimento='" + pTIPO_ATENDIMENTO_ADM_TO + "' "
                    + "OR CONVERT(DATE, DataAtendimento) BETWEEN'" + pDATA_INICIAL + "' "
                    + "AND '" + pDATA_FINAL + "' "
                    + "AND TipoAtendimento='" + pTIPO_ATENDIMENTO_EVO_TO + "' "
                    + "OR CONVERT(DATE, DataAtendimento) BETWEEN'" + pDATA_INICIAL + "' "
                    + "AND '" + pDATA_FINAL + "' "
                    + "AND TipoAtendimento='" + pTIPO_ATENDIMENTO_GRUPO_TO + "' ");
            while (conecta.rs.next()) {
                AtividadesMensalRealizadaUnidades pAtivaSS = new AtividadesMensalRealizadaUnidades();
                pAtivaSS.setDataAtendimento(conecta.rs.getDate("DataAtendimento"));
                pAtivaSS.setTipoAtendimento(conecta.rs.getString("TipoAtendimento"));
                listaAtendSS.add(pAtivaSS);
                pQUANTIDADE_TOTAL_TO = pQUANTIDADE_TOTAL_TO + 1;
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
