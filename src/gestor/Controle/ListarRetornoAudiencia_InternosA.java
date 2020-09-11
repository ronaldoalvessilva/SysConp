/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.FechamentoRegistros;
import static gestor.Visao.TelaFechamentoSistema.jDataFechamento;
import static gestor.Visao.TelaFechamentoSistema.pRETORNO_AUDIENCIAS;
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
public class ListarRetornoAudiencia_InternosA {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    FechamentoRegistros objFecha = new FechamentoRegistros();
    //
    String pSTATUS_RETORNO_AUDIENCIA = "FINALIZADO";
    String pDATA_PESQUISA_FECHAMENTO = "";

    public List<FechamentoRegistros> read() throws Exception {
        if (tipoServidor == null || tipoServidor.equals("")) {
            JOptionPane.showMessageDialog(null, "É necessário definir o parâmtero para o sistema operacional utilizado no servidor, (UBUNTU-LINUX ou WINDOWS SERVER).");
        } else if (tipoServidor.equals("Servidor Linux (Ubuntu)/MS-SQL Server")) {
            SimpleDateFormat formatoAmerica = new SimpleDateFormat("yyyy/MM/dd");
            pDATA_PESQUISA_FECHAMENTO = formatoAmerica.format(jDataFechamento.getDate().getTime());
        } else if (tipoServidor.equals("Servidor Windows/MS-SQL Server")) {
            SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
            pDATA_PESQUISA_FECHAMENTO = formatoAmerica.format(jDataFechamento.getDate().getTime());
        }
        pRETORNO_AUDIENCIAS = 0;
        List<FechamentoRegistros> listaTodasRetorno_AUDIENCIA = new ArrayList<FechamentoRegistros>();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT StatusRet "
                    + "FROM RETORNOAUDIENCIA "
                    + "WHERE StatusRet='" + pSTATUS_RETORNO_AUDIENCIA + "' "
                    + "AND DataLancRetorno<='" + pDATA_PESQUISA_FECHAMENTO + "'");
            while (conecta.rs.next()) {
                FechamentoRegistros pRetornos_ESP = new FechamentoRegistros();
                pRetornos_ESP.setStatusRegistro(conecta.rs.getString("StatusRet"));
                listaTodasRetorno_AUDIENCIA.add(pRetornos_ESP);
                pRETORNO_AUDIENCIAS = pRETORNO_AUDIENCIAS + 1;
            }
            return listaTodasRetorno_AUDIENCIA;
        } catch (SQLException ex) {
            Logger.getLogger(ListarRetornoAudiencia_InternosA.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
