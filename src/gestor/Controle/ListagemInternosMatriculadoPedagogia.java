/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.listarInternosPopulacaoNominal;
import gestor.Modelo.AtividadesMensalRealizadaUnidades;
import static gestor.Visao.TelaAtividadesMensalUnidade.jDataPeriodoFinal;
import static gestor.Visao.TelaAtividadesMensalUnidade.jDataPeriodoInicial;
import static gestor.Visao.TelaAtividadesMensalUnidade.pQUANTIDADE_MATRICULADOS;
import static gestor.Visao.TelaAtividadesMensalUnidade.pTIPO_MATRICULA_PEDAGODIA;
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
public class ListagemInternosMatriculadoPedagogia {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AtividadesMensalRealizadaUnidades objAtividade = new AtividadesMensalRealizadaUnidades();
    //
    String pDATA_INICIAL;
    String pDATA_FINAL;
    String pREGIME_INTERNO = "Provisório";
    String pENTRADA_UNIDADE = "ENTRADA NA UNIDADE";
    String pRETORNO_UNIDADE = "RETORNO A UNIDADE";

    public List<AtividadesMensalRealizadaUnidades> read() throws Exception {
        pQUANTIDADE_MATRICULADOS = 0;
        List<AtividadesMensalRealizadaUnidades> listaInternosMat = new ArrayList<AtividadesMensalRealizadaUnidades>();
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
            conecta.executaSQL("SELECT MATRICULAESCOLAR.DataMat "
                    + "FROM MATRICULAESCOLAR "
                    + "INNER JOIN ITENSMATRICULA "
                    + "ON MATRICULAESCOLAR.IdMat=ITENSMATRICULA.IdMat "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENSMATRICULA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "WHERE CONVERT(DATE, DataMat) BETWEEN'" + pDATA_INICIAL + "' "
                    + "AND '" + pDATA_FINAL + "' "
                    + "AND PRONTUARIOSCRC.SituacaoCrc='" + pENTRADA_UNIDADE + "' "
                    + "AND DADOSPENAISINTERNOS.Regime!='" + pREGIME_INTERNO + "' "
                    + "AND ITENSMATRICULA.StatusAluno='" + pTIPO_MATRICULA_PEDAGODIA + "' "                           
                    + "OR CONVERT(DATE, DataMat) BETWEEN'" + pDATA_INICIAL + "' "
                    + "AND '" + pDATA_FINAL + "' "
                    + "AND PRONTUARIOSCRC.SituacaoCrc='" + pRETORNO_UNIDADE + "' "
                    + "AND DADOSPENAISINTERNOS.Regime!='" + pREGIME_INTERNO + "' "
                    + "AND ITENSMATRICULA.StatusAluno='" + pTIPO_MATRICULA_PEDAGODIA + "'");
            while (conecta.rs.next()) {
                AtividadesMensalRealizadaUnidades pIntMat = new AtividadesMensalRealizadaUnidades();
                pIntMat.setDataMatricula(conecta.rs.getDate("DataMat"));
                listaInternosMat.add(pIntMat);
                pQUANTIDADE_MATRICULADOS = pQUANTIDADE_MATRICULADOS + 1;
            }
            return listaInternosMat;
        } catch (SQLException ex) {
            Logger.getLogger(listarInternosPopulacaoNominal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
