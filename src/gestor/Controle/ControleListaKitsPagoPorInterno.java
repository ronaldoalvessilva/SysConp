package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AlertaKitHigiente;
import static gestor.Visao.TelaConsultaKitsEntregueNaoEntreguesInternos.jComboBoxNomeInterno;
import static gestor.Visao.TelaConsultaKitsEntregueNaoEntreguesInternos.pTOTAL_produtos;
import static gestor.Visao.TelaConsultaKitsEntregueNaoEntreguesInternos.jDataFinal;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static gestor.Visao.TelaConsultaKitsEntregueNaoEntreguesInternos.jDataInicial;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ronaldo.silva7
 */
public class ControleListaKitsPagoPorInterno {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AlertaKitHigiente objComp = new AlertaKitHigiente();    
    //
    String pKIT_pago = "Sim";
    String pDATA_inicial = "";
    String pDATA_final = "";

    public List<AlertaKitHigiente> read() throws Exception {
        pTOTAL_produtos = 0;
        if (tipoServidor == null || tipoServidor.equals("")) {
            JOptionPane.showMessageDialog(null, "É necessário definir o parâmtero para o sistema operacional utilizado no servidor, (UBUNTU-LINUX ou WINDOWS SERVER).");
        } else if (tipoServidor.equals("Servidor Linux (Ubuntu)/MS-SQL Server")) {
            SimpleDateFormat formatoAmerica = new SimpleDateFormat("yyyy/MM/dd");
            pDATA_inicial = formatoAmerica.format(jDataInicial.getDate().getTime());
            pDATA_final = formatoAmerica.format(jDataFinal.getDate().getTime());
            conecta.abrirConexao();
            List<AlertaKitHigiente> listaInternosKitComp = new ArrayList<AlertaKitHigiente>();
            try {
                conecta.executaSQL("SELECT "
                        + "DISTINCT ITENS_PAGAMENTO_KIT_INTERNOS.IdPagto, "
                        + "ITENS_PAGAMENTO_KIT_INTERNOS.DataEntrega, "
                        + "PAGAMENTO_KIT_INTERNOS.TipoKit, "
                        + "ITENS_PAGAMENTO_KIT_INTERNOS_PRODUTOS.IdProd, "
                        + "PRODUTOS_AC.DescricaoProd, "
                        + "ITENS_PAGAMENTO_KIT_INTERNOS_PRODUTOS.QuantProd, "
                        + "PAVILHAO.DescricaoPav "
                        + "FROM PAGAMENTO_KIT_INTERNOS "
                        + "INNER JOIN ITENS_PAGAMENTO_KIT_INTERNOS "
                        + "ON PAGAMENTO_KIT_INTERNOS.IdPagto=ITENS_PAGAMENTO_KIT_INTERNOS.IdPagto "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ITENS_PAGAMENTO_KIT_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "INNER JOIN PAVILHAO "
                        + "ON PAGAMENTO_KIT_INTERNOS.IdPav=PAVILHAO.IdPav "
                        + "INNER JOIN ITENS_PAGAMENTO_KIT_INTERNOS_PRODUTOS "
                        + "ON PAGAMENTO_KIT_INTERNOS.IdPagto=ITENS_PAGAMENTO_KIT_INTERNOS_PRODUTOS.IdPagto "
                        + "INNER JOIN PRODUTOS_AC "
                        + "ON ITENS_PAGAMENTO_KIT_INTERNOS_PRODUTOS.IdProd=PRODUTOS_AC.IdProd "
                        + "WHERE PRONTUARIOSCRC.NomeInternoCrc LIKE'%" +  jComboBoxNomeInterno.getSelectedItem()  + "%' "
                        + "AND ITENS_PAGAMENTO_KIT_INTERNOS.DataEntrega BETWEEN'" + pDATA_inicial + "' "
                        + "AND '" + pDATA_final + "' "
                        + "ORDER BY ITENS_PAGAMENTO_KIT_INTERNOS.DataEntrega, TipoKit");
                while (conecta.rs.next()) {
                    AlertaKitHigiente pDigi = new AlertaKitHigiente();
                    pDigi.setIdRegistroComp(conecta.rs.getInt("IdPagto"));
                    pDigi.setDataPagamento(conecta.rs.getDate("DataEntrega"));
                    pDigi.setTipoKit(conecta.rs.getString("TipoKit"));   
                    pDigi.setCodigoProduto(conecta.rs.getInt("IdProd"));
                    pDigi.setDescricaoProduto(conecta.rs.getString("DescricaoProd"));
                    pDigi.setDescricaoPav(conecta.rs.getString("DescricaoPav"));
                    pDigi.setQuantProd(conecta.rs.getInt("QuantProd"));
                    listaInternosKitComp.add(pDigi);
                    ++pTOTAL_produtos;
                }
                return listaInternosKitComp;
            } catch (SQLException ex) {
                Logger.getLogger(ControleListaKitsPagoPorInterno.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                conecta.desconecta();
            }
        } else if (tipoServidor.equals("Servidor Windows/MS-SQL Server")) {
            SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
            pDATA_inicial = formatoAmerica.format(jDataInicial.getDate().getTime());
            pDATA_final = formatoAmerica.format(jDataFinal.getDate().getTime());
            conecta.abrirConexao();
            List<AlertaKitHigiente> listaInternosKitComp = new ArrayList<AlertaKitHigiente>();
            try {
                conecta.executaSQL("SELECT "
                        + "DISTINCT ITENS_PAGAMENTO_KIT_INTERNOS.IdPagto, "
                        + "ITENS_PAGAMENTO_KIT_INTERNOS.DataEntrega, "
                        + "PAGAMENTO_KIT_INTERNOS.TipoKit, "
                        + "ITENS_PAGAMENTO_KIT_INTERNOS_PRODUTOS.IdProd, "
                        + "PRODUTOS_AC.DescricaoProd, "
                        + "ITENS_PAGAMENTO_KIT_INTERNOS_PRODUTOS.QuantProd, "
                        + "PAVILHAO.DescricaoPav "
                        + "FROM PAGAMENTO_KIT_INTERNOS "
                        + "INNER JOIN ITENS_PAGAMENTO_KIT_INTERNOS "
                        + "ON PAGAMENTO_KIT_INTERNOS.IdPagto=ITENS_PAGAMENTO_KIT_INTERNOS.IdPagto "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ITENS_PAGAMENTO_KIT_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "INNER JOIN PAVILHAO "
                        + "ON PAGAMENTO_KIT_INTERNOS.IdPav=PAVILHAO.IdPav "
                        + "INNER JOIN ITENS_PAGAMENTO_KIT_INTERNOS_PRODUTOS "
                        + "ON PAGAMENTO_KIT_INTERNOS.IdPagto=ITENS_PAGAMENTO_KIT_INTERNOS_PRODUTOS.IdPagto "
                        + "INNER JOIN PRODUTOS_AC "
                        + "ON ITENS_PAGAMENTO_KIT_INTERNOS_PRODUTOS.IdProd=PRODUTOS_AC.IdProd "
                        + "WHERE PRONTUARIOSCRC.NomeInternoCrc LIKE'%" +  jComboBoxNomeInterno.getSelectedItem()  + "%' "
                        + "AND ITENS_PAGAMENTO_KIT_INTERNOS.DataEntrega BETWEEN'" + pDATA_inicial + "' "
                        + "AND '" + pDATA_final + "' "
                        + "ORDER BY ITENS_PAGAMENTO_KIT_INTERNOS.DataEntrega, TipoKit");
                while (conecta.rs.next()) {
                   AlertaKitHigiente pDigi = new AlertaKitHigiente();
                    pDigi.setIdRegistroComp(conecta.rs.getInt("IdPagto"));
                    pDigi.setDataPagamento(conecta.rs.getDate("DataEntrega"));
                    pDigi.setTipoKit(conecta.rs.getString("TipoKit"));   
                    pDigi.setCodigoProduto(conecta.rs.getInt("IdProd"));
                    pDigi.setDescricaoProduto(conecta.rs.getString("DescricaoProd"));
                    pDigi.setDescricaoPav(conecta.rs.getString("DescricaoPav"));
                    pDigi.setQuantProd(conecta.rs.getInt("QuantProd"));
                    listaInternosKitComp.add(pDigi);
                    ++pTOTAL_produtos;
                }
                return listaInternosKitComp;
            } catch (SQLException ex) {
                Logger.getLogger(ControleListaKitsPagoPorInterno.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                conecta.desconecta();
            }
        }
        return null;
    }
}
