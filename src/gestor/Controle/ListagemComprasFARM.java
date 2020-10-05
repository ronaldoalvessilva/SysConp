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
import static gestor.Visao.TelaFechamentoSistema.pCOMPRAS_far;
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
public class ListagemComprasFARM {

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
        pCOMPRAS_far = 0;
        List<FechamentoRegistros> listaTodasNovaEntrada = new ArrayList<FechamentoRegistros>();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT StatusNf "
                    + "FROM NF_COMPRAS_FAR "
                    + "WHERE StatusNf='" + pSTATUS_NOVA_ENTRADA + "' "
                    + "AND DataEntrada BETWEEN'" + pDATA_PESQUISA_FECHAMENTO + "' "
                    + "AND '" + pDATA_PESQUISA_FECHAMENTO1 + "'");
            while (conecta.rs.next()) {
                FechamentoRegistros pNovaEntrada = new FechamentoRegistros();
                pNovaEntrada.setStatusRegistro(conecta.rs.getString("StatusNf"));
                listaTodasNovaEntrada.add(pNovaEntrada);
                pCOMPRAS_far = pCOMPRAS_far + 1;
            }
            return listaTodasNovaEntrada;
        } catch (SQLException ex) {
            Logger.getLogger(ListagemComprasFARM.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
