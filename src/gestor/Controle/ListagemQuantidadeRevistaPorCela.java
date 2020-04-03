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
import static gestor.Visao.TelaAtividadesMensalUnidade.pQUANTIDADE_REVISTA_POR_CELA;
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
public class ListagemQuantidadeRevistaPorCela {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AtividadesMensalRealizadaUnidades objAtividade = new AtividadesMensalRealizadaUnidades();
    //
    String pDATA_INICIAL;
    String pDATA_FINAL;
    String pTIPO_APARELHO = "Aparelho Celular";

    public List<AtividadesMensalRealizadaUnidades> read() throws Exception {
        pQUANTIDADE_REVISTA_POR_CELA = 0;
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
            conecta.executaSQL("SELECT ITENSPCIP.DataProc, "
                    + "ITENSPCIP.IdCela,CELAS.EndCelaPav "
                    + "FROM ITENSPCIP "
                    + "INNER JOIN PROCEDIMENTOS "
                    + "ON ITENSPCIP.IdProc=PROCEDIMENTOS.IdProc "
                    + "INNER JOIN PAVILHAO "
                    + "ON ITENSPCIP.IdPav=PAVILHAO.IdPav "
                    + "INNER JOIN CELAS "
                    + "ON ITENSPCIP.IdCela=CELAS.IdCela "
                    + "WHERE CONVERT(DATE, ITENSPCIP.DataProc) BETWEEN'" + pDATA_INICIAL + "' "
                    + "AND '" + pDATA_FINAL + "'");
            while (conecta.rs.next()) {
                AtividadesMensalRealizadaUnidades pQuantRevista = new AtividadesMensalRealizadaUnidades();
                pQuantRevista.setDataProcedimento(conecta.rs.getDate("DataProc"));               
                listaInternospIntFreq.add(pQuantRevista);
                pQUANTIDADE_REVISTA_POR_CELA = pQUANTIDADE_REVISTA_POR_CELA + 1;
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
