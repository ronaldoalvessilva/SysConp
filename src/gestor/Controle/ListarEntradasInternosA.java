/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.FechamentoRegistros;
import static gestor.Visao.TelaFechamentoSistema.jDataFechamento;
import static gestor.Visao.TelaFechamentoSistema.pTOTAL_ENTRADAS;
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
public class ListarEntradasInternosA {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    FechamentoRegistros objFecha = new FechamentoRegistros();
    //
    String pSTATUS_ENTRADA = "FINALIZADO";
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
        pTOTAL_ENTRADAS = 0;
        List<FechamentoRegistros> listaTodasEntradas = new ArrayList<FechamentoRegistros>();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT StatusEnt "
                    + "FROM ENTRADALOTE "
                    + "WHERE StatusEnt='" + pSTATUS_ENTRADA + "' "
                    + "AND DataLancaMov<='" + pDATA_PESQUISA_FECHAMENTO + "'");
            while (conecta.rs.next()) {
                FechamentoRegistros pEntradas = new FechamentoRegistros();
                pEntradas.setStatusRegistro(conecta.rs.getString("StatusEnt"));
                listaTodasEntradas.add(pEntradas);
                pTOTAL_ENTRADAS = pTOTAL_ENTRADAS + 1;
            }
            return listaTodasEntradas;
        } catch (SQLException ex) {
            Logger.getLogger(ListarEntradasInternosA.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
