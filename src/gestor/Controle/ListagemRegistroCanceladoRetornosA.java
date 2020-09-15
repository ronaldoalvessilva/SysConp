/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.FechamentoRegistros;
import static gestor.Visao.TelaAberturaTotalSistema.jDataFechamento;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static gestor.Visao.TelaAberturaTotalSistema.pREGISTRO_CANCELADO_RETORNOS;

/**
 *
 * @author ronaldo.silva7
 */
public class ListagemRegistroCanceladoRetornosA {
    ConexaoBancoDados conecta = new ConexaoBancoDados();
    FechamentoRegistros objFecha = new FechamentoRegistros();
    //
    String pSTATUS_REGISTRO_CANCELADO = "FINALIZADO";
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
        pREGISTRO_CANCELADO_RETORNOS = 0;
        List<FechamentoRegistros> listaTodasNovaEntrada = new ArrayList<FechamentoRegistros>();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT StatusLanc "
                    + "FROM REGISTRO_CANCELADO_RETORNOS "
                    + "WHERE StatusLanc='" + pSTATUS_REGISTRO_CANCELADO + "' "
                    + "AND DataLanc<='" + pDATA_PESQUISA_FECHAMENTO + "'");
            while (conecta.rs.next()) {
                FechamentoRegistros pNovaEntrada = new FechamentoRegistros();
                pNovaEntrada.setStatusRegistro(conecta.rs.getString("StatusLanc"));
                listaTodasNovaEntrada.add(pNovaEntrada);
                pREGISTRO_CANCELADO_RETORNOS = pREGISTRO_CANCELADO_RETORNOS + 1;
            }
            return listaTodasNovaEntrada;
        } catch (SQLException ex) {
            Logger.getLogger(ListarNovaEntrada_Internos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
