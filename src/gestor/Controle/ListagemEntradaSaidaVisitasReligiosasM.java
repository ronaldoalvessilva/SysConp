/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.FechamentoRegistros;
import static gestor.Visao.TelaAberturaRegistroSistema.jDataFinal;
import static gestor.Visao.TelaAberturaRegistroSistema.jDataInicial;
import static gestor.Visao.TelaAberturaRegistroSistema.pTOTAL_ENTRADAS_SAIDAS_VISITAS_religiosas;
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
 * @author ronaldo.silva7
 */
public class ListagemEntradaSaidaVisitasReligiosasM {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    FechamentoRegistros objFecha = new FechamentoRegistros();
    //
    String pSTATUS_NOVA_ENTRADA = "FINALIZADO";
    String pDATA_PESQUISA_FECHAMENTO = "";
    String pDATA_PESQUISA_FECHAMENTO1 = "";

    public List<FechamentoRegistros> read() throws Exception {
        if (tipoServidor == null || tipoServidor.equals("")) {
            JOptionPane.showMessageDialog(null, "É necessário definir o parâmtero para o sistema operacional utilizado no servidor, (UBUNTU-LINUX ou WINDOWS SERVER).");
        } else if (tipoServidor.equals("Servidor Linux (Ubuntu)/MS-SQL Server")) {
            SimpleDateFormat formatoAmerica = new SimpleDateFormat("yyyy/MM/dd");
            pDATA_PESQUISA_FECHAMENTO = formatoAmerica.format(jDataInicial.getDate().getTime());
            pDATA_PESQUISA_FECHAMENTO1 = formatoAmerica.format(jDataFinal.getDate().getTime());
        } else if (tipoServidor.equals("Servidor Windows/MS-SQL Server")) {
            SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
            pDATA_PESQUISA_FECHAMENTO = formatoAmerica.format(jDataInicial.getDate().getTime());
            pDATA_PESQUISA_FECHAMENTO1 = formatoAmerica.format(jDataFinal.getDate().getTime());
        }
        pTOTAL_ENTRADAS_SAIDAS_VISITAS_religiosas = 0;
        List<FechamentoRegistros> listaEntradaSaidaVR = new ArrayList<FechamentoRegistros>();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT StatusLanc "
                    + "FROM ENTRADA_SAIDA_VISITAS_RELIGIOSA "
                    + "WHERE StatusLanc='" + pSTATUS_NOVA_ENTRADA + "' "
                    + "AND DataLanc BETWEEN'" + pDATA_PESQUISA_FECHAMENTO + "' "
                    + "AND '" + pDATA_PESQUISA_FECHAMENTO1 + "'");
            while (conecta.rs.next()) {
                FechamentoRegistros pEntradaSaiaVR = new FechamentoRegistros();
                pEntradaSaiaVR.setStatusRegistro(conecta.rs.getString("StatusLanc"));
                listaEntradaSaidaVR.add(pEntradaSaiaVR);
                pTOTAL_ENTRADAS_SAIDAS_VISITAS_religiosas = pTOTAL_ENTRADAS_SAIDAS_VISITAS_religiosas + 1;
            }
            return listaEntradaSaidaVR;
        } catch (SQLException ex) {
            Logger.getLogger(ListagemEntradaSaidaVisitasReligiosasM.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
