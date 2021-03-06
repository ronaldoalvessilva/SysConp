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
import static gestor.Visao.TelaAtividadesMensalUnidade.pTIPO_ATENDIMENTO_ATE_ODONTOLOGICO;
import static gestor.Visao.TelaAtividadesMensalUnidade.pTIPO_ATENDIMENTO_EVO_ODONTOLOGICO;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static gestor.Visao.TelaAtividadesMensalUnidade.pQUANTIDADE_PROC_ODONTOLOGICO;

/**
 *
 * @author ronal
 */
public class ListagemAtendimentoPROCOdontologica {

    //MODELO DA LISTAGEM PARA O SERVIÇO SOCIAL. AINDA NÃO FOI DEVIDAMENTE IMPLEMENTADA.
    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AtividadesMensalRealizadaUnidades objAtividade = new AtividadesMensalRealizadaUnidades();
    //
    String pDATA_INICIAL;
    String pDATA_FINAL;

    public List<AtividadesMensalRealizadaUnidades> read() throws Exception {
        pQUANTIDADE_ADM_SOCIAL = 0;
        List<AtividadesMensalRealizadaUnidades> listaAtendPsicologia = new ArrayList<AtividadesMensalRealizadaUnidades>();
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
            conecta.executaSQL(
                    //                    "SELECT REGISTRO_ATENDIMENTO_INTERNO_PSP.DataAtendimento, "
                    //                    + "REGISTRO_ATENDIMENTO_INTERNO_PSP.TipoAtendimento "
                    //                    + "FROM REGISTRO_ATENDIMENTO_INTERNO_PSP "
                    //                    + "INNER JOIN ATENDIMENTODONTO "
                    //                    + "ON REGISTRO_ATENDIMENTO_INTERNO_PSP.IdAtend=ATENDIMENTODONTO.IdLanc "
                    //                    + "INNER JOIN ODONTOGRAMA_ADMISSAO "
                    //                    + "ON ATENDIMENTODONTO.IdLanc=ODONTOGRAMA_ADMISSAO.IdLanc "
                    //                    + "INNER JOIN PROCEDIMENTOS_ODONTOLOGICO "
                    //                    + "ON ODONTOGRAMA_ADMISSAO.IdProcOdonto=PROCEDIMENTOS_ODONTOLOGICO.IdProcOdonto "
                    //                    + "INNER JOIN ODONTOPROCEDIMENTO "
                    //                    + "ON ATENDIMENTODONTO.IdLanc=ODONTOPROCEDIMENTO.IdLanc "
                    //                    + "WHERE CONVERT(DATE, REGISTRO_ATENDIMENTO_INTERNO_PSP.DataAtendimento) BETWEEN'" + pDATA_INICIAL + "' "
                    //                    + "AND '" + pDATA_FINAL + "' "
                    //                    + "AND REGISTRO_ATENDIMENTO_INTERNO_PSP.TipoAtendimento='" + pTIPO_ATENDIMENTO_ATE_ODONTOLOGICO + "' "
                    //                    + "OR CONVERT(DATE, REGISTRO_ATENDIMENTO_INTERNO_PSP.DataAtendimento) BETWEEN'" + pDATA_INICIAL + "' "
                    //                    + "AND '" + pDATA_FINAL + "' "
                    //                    + "AND REGISTRO_ATENDIMENTO_INTERNO_PSP.TipoAtendimento='" + pTIPO_ATENDIMENTO_EVO_ODONTOLOGICO + "' "
                    "SELECT A.DataOdontograma "
                    + "FROM ODONTOGRAMA_ADMISSAO  AS A  "
                    + "INNER JOIN ATENDIMENTODONTO AS B ON B.IdLanc = A.IdLanc "
                    + "INNER JOIN PRONTUARIOSCRC AS C ON C.IdInternoCrc = B.IdInternoCrc "
                    + "INNER JOIN PROCEDIMENTOS_ODONTOLOGICO AS D ON D.IdProcOdonto = A.IdProcOdonto "
                    + "WHERE  CONVERT(DATE, A.DataOdontograma) BETWEEN'" + pDATA_INICIAL + "' "
                    + "AND '" + pDATA_FINAL + "' "
                    + "UNION ALL "
                    + "SELECT A.DataOdontograma "
                    + "FROM ODONTOGRAMA_EVOLUCAO  AS A  "
                    + "INNER JOIN ATENDIMENTODONTO AS B ON B.IdLanc = A.IdLanc "
                    + "INNER JOIN PRONTUARIOSCRC AS C ON C.IdInternoCrc = B.IdInternoCrc "
                    + "INNER JOIN PROCEDIMENTOS_ODONTOLOGICO AS D ON D.IdProcOdonto = A.IdProcOdonto "
                    + "WHERE  CONVERT(DATE, A.DataOdontograma) BETWEEN'" + pDATA_INICIAL + "' "
                    + "AND '" + pDATA_FINAL + "' "
            );
            while (conecta.rs.next()) {
                AtividadesMensalRealizadaUnidades pAtivaPsico = new AtividadesMensalRealizadaUnidades();
                pAtivaPsico.setDataAtendimento(conecta.rs.getDate("DataOdontograma"));
//                pAtivaPsico.setTipoAtendimento(conecta.rs.getString("TipoAtendimento"));
                listaAtendPsicologia.add(pAtivaPsico);
                pQUANTIDADE_PROC_ODONTOLOGICO = pQUANTIDADE_PROC_ODONTOLOGICO + 1;
            }
            return listaAtendPsicologia;
        } catch (SQLException ex) {
            Logger.getLogger(listarInternosPopulacaoNominal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
