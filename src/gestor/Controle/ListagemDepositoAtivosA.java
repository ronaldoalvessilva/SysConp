/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.FechamentoRegistros;
import static gestor.Visao.TelaAberturaTotalSistema.jDataFechamento;
import static gestor.Visao.TelaAberturaTotalSistema.pDEPOSITO_ativo;
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
public class ListagemDepositoAtivosA {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    FechamentoRegistros objFecha = new FechamentoRegistros();
    //
    String pSTATUS_NOVA_ENTRADA = "FINALIZADO";
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
        pDEPOSITO_ativo = 0;
        List<FechamentoRegistros> listaTodasNovaEntrada = new ArrayList<FechamentoRegistros>();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT StatusLanc "
                    + "FROM DEPOSITO "
                    + "WHERE StatusLanc='" + pSTATUS_NOVA_ENTRADA + "' "
                    + "AND DataLanc<='" + pDATA_PESQUISA_FECHAMENTO + "'");
            while (conecta.rs.next()) {
                FechamentoRegistros pNovaEntrada = new FechamentoRegistros();
                pNovaEntrada.setStatusRegistro(conecta.rs.getString("StatusLanc"));
                listaTodasNovaEntrada.add(pNovaEntrada);
                pDEPOSITO_ativo = pDEPOSITO_ativo + 1;
            }
            return listaTodasNovaEntrada;
        } catch (SQLException ex) {
            Logger.getLogger(ListagemDepositoAtivosA.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}