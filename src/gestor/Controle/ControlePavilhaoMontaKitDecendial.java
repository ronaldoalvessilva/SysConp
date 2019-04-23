/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.PavilhaoInternoMontaKit;
import gestor.Modelo.PavilhaoInternosMontagemKit;
import gestor.Modelo.PavilhaoInternosSelecionados;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jComboBoxPavilhoes;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jDataComp;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.qtdInternos;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.qtdInternosKD;
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
public class ControlePavilhaoMontaKitDecendial {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    PavilhaoInternosMontagemKit objPavInt = new PavilhaoInternosMontagemKit();
    PavilhaoInternosSelecionados objPavIntSelec = new PavilhaoInternosSelecionados();
    //
    String situacaoEntrada = "ENTRADA NA UNIDADE";
    String situacaoRetorno = "RETORNO A UNIDADE";
    int codPavilhao = 0;
    int codInterno = 0;
    String kitDecendial = "Não";
    String kitPago = "Não";
    String data = "";
    String pUtilizado = "Não";
    String dataPesquisa = "";
    String kitGerado = "Não";

    public List<PavilhaoInternoMontaKit> read() throws Exception {
        if (tipoServidor == null || tipoServidor.equals("")) {
            JOptionPane.showMessageDialog(null, "É necessário definir o parâmtero para o sistema operacional utilizado no servidor, (UBUNTU-LINUX ou WINDOWS SERVER).");
        } else if (tipoServidor.equals("Servidor Linux (Ubuntu)/MS-SQL Server")) {
            SimpleDateFormat formatoAmerica = new SimpleDateFormat("yyyy/MM/dd");
            dataPesquisa = formatoAmerica.format(jDataComp.getDate().getTime());
        } else if (tipoServidor.equals("Servidor Windows/MS-SQL Server")) {
            SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
            dataPesquisa = formatoAmerica.format(jDataComp.getDate().getTime());
        }
        conecta.abrirConexao();
        List<PavilhaoInternoMontaKit> listaInternosPavilhao = new ArrayList<PavilhaoInternoMontaKit>();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "INNER JOIN ITENSLOCACAOINTERNO "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSLOCACAOINTERNO.IdInternoCrc "
                    + "INNER JOIN CELAS "
                    + "ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                    + "INNER JOIN PAVILHAO "
                    + "ON CELAS.IdPav=PAVILHAO.IdPav "
                    + "INNER JOIN KITS_DECENDIAL_INTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=KITS_DECENDIAL_INTERNOS.IdInternoCrc "
                    + "WHERE PAVILHAO.DescricaoPav='" + jComboBoxPavilhoes.getSelectedItem() + "' "
                    + "AND PRONTUARIOSCRC.SituacaoCrc='" + situacaoEntrada + "' "
                    + "AND KITS_DECENDIAL_INTERNOS.KitPago='" + kitPago + "' "
                    + "AND KITS_DECENDIAL_INTERNOS.DataPrevisaoPro='" + dataPesquisa + "' "
                    + "AND KITS_DECENDIAL_INTERNOS.Utilizado='" + pUtilizado + "' "
                    + "OR PAVILHAO.DescricaoPav='" + jComboBoxPavilhoes.getSelectedItem() + "' "
                    + "AND PRONTUARIOSCRC.SituacaoCrc='" + situacaoRetorno + "' "
                    + "AND KITS_DECENDIAL_INTERNOS.KitPago='" + kitPago + "' "
                    + "AND KITS_DECENDIAL_INTERNOS.DataPrevisaoPro='" + dataPesquisa + "' "
                    + "AND KITS_DECENDIAL_INTERNOS.Utilizado='" + pUtilizado + "' "
                    + "ORDER BY PRONTUARIOSCRC.NomeInternoCrc");
            while (conecta.rs.next()) {
                PavilhaoInternoMontaKit pDigi = new PavilhaoInternoMontaKit();
                pDigi.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                pDigi.setCncInternoCrc(conecta.rs.getString("Cnc"));
                pDigi.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
                pDigi.setIdPav(conecta.rs.getInt("IdPav"));
                pDigi.setDescricaoPav(conecta.rs.getString("DescricaoPav"));
                listaInternosPavilhao.add(pDigi);
                qtdInternosKD++;
                qtdInternos++;
            }
            return listaInternosPavilhao;
        } catch (SQLException ex) {
            Logger.getLogger(ControlePavilhaoMontaKitDecendial.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public void calcularDPKD() {
        data = jDataSistema.getText();
//        int dia = Integer.parseInt(data.substring(8, 10));
//        int mes = Integer.parseInt(data.substring(5, 7));
//        int ano = Integer.parseInt(data.substring(0, 4));
        //
//        String data = "10/03/2012";
        int dia = Integer.parseInt(data.substring(0, 2));
        int mes = Integer.parseInt(data.substring(3, 5));
        int ano = Integer.parseInt(data.substring(6, 10));
        //se é pra 5 meses consecutivos:
        int mesParada = mes + 5;
        String proximaData = null;
        while (mes <= mesParada) {
            ++mes;
            proximaData = dia + "/" + mes + "/" + ano;
            conecta.desconecta();
        }
    }

    public void buscarDataPrevisaoKitConverter() {
        SimpleDateFormat formatoAmerica = new SimpleDateFormat("yyyy/MM/dd");
        dataPesquisa = formatoAmerica.format(jDataComp.getDate().getTime());
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM KITS_DECENDIAL_INTERNOS "
                    + "WHERE Utilizado='" + pUtilizado + "' "
                    + "AND KitPago='" + kitPago + "' "
                    + "AND DataPrevisaoPro='" + dataPesquisa + "'");
            conecta.rs.first();

        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
