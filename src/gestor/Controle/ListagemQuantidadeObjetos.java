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
import static gestor.Visao.TelaAtividadesMensalUnidade.pQUANTIDADE_OBJETOS_PROC;
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
public class ListagemQuantidadeObjetos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AtividadesMensalRealizadaUnidades objAtividade = new AtividadesMensalRealizadaUnidades();
    //
    String pDATA_INICIAL;
    String pDATA_FINAL;
    String pTIPO_APARELHO = "Aparelho Celular";

    public List<AtividadesMensalRealizadaUnidades> read() throws Exception {
        pQUANTIDADE_OBJETOS_PROC = 0;
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
            conecta.executaSQL("SELECT PROCEDIMENTOS.DataLanc, "
                    + "OBJETOSPROCEDIMENTOS.DescricaoObjeto, "
                    + "ITENSOBJETOSPROCEDIMENTO.Qtde "
                    + "FROM ITENSOBJETOSPROCEDIMENTO "
                    + "INNER JOIN OBJETOSPROCEDIMENTOS "
                    + "ON ITENSOBJETOSPROCEDIMENTO.IdObjeto=OBJETOSPROCEDIMENTOS.IdObjeto "
                    + "INNER JOIN CELAS "
                    + "ON ITENSOBJETOSPROCEDIMENTO.IdCela=CELAS.IdCela "
                    + "INNER JOIN PROCEDIMENTOS "
                    + "ON ITENSOBJETOSPROCEDIMENTO.IdProc=PROCEDIMENTOS.IdProc "
                    + "WHERE CONVERT(DATE, PROCEDIMENTOS.DataLanc) BETWEEN'" + pDATA_INICIAL + "' "
                    + "AND '" + pDATA_FINAL + "'");
            while (conecta.rs.next()) {
                AtividadesMensalRealizadaUnidades pQuantApa = new AtividadesMensalRealizadaUnidades();
                pQuantApa.setDataProcedimento(conecta.rs.getDate("DataLanc"));
                pQuantApa.setQuantidadeObjetos(conecta.rs.getInt("Qtde"));
                listaInternospIntFreq.add(pQuantApa);
                pQUANTIDADE_OBJETOS_PROC = pQUANTIDADE_OBJETOS_PROC + pQuantApa.getQuantidadeObjetos();
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
