/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.CancelamentoPagamentoKitHigiene;
import static gestor.Visao.TelaCancelamentoPagamentoKits.jFotoInternoKit;
import static gestor.Visao.TelaCancelamentoPagamentoKits.jIdInternoKit;
import static gestor.Visao.TelaCancelamentoPagamentoKits.jIdRegistro;
import static gestor.Visao.TelaCancelamentoPagamentoKits.idItemINT;
import static gestor.Visao.TelaCancelamentoPagamentoKits.codItemINT;
import static gestor.Visao.TelaCancelamentoPagamentoKits.idItemPagto;
import static gestor.Visao.TelaCancelamentoPagamentoKits.pINTERNOS;
import java.awt.Image;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author ronal
 */
public class PesquisarProdutosCanceladosKits {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    CancelamentoPagamentoKitHigiene objCancelaKit = new CancelamentoPagamentoKitHigiene();

    String caminho = "";

    public List<CancelamentoPagamentoKitHigiene> read() throws Exception {
        conecta.abrirConexao();
        List<CancelamentoPagamentoKitHigiene> listaCancelCodigo = new ArrayList<CancelamentoPagamentoKitHigiene>();
        try {
            conecta.executaSQL("SELECT DISTINCT "
                    + "ITENS_CANCELAR_PAGAMENTO_KIT_HIGIENE_PRODUTOS.IdProd,"
                    + "PRODUTOS_AC.DescricaoProd,PRODUTOS_AC.UnidadeProd, "
                    + "ITENS_CANCELAR_PAGAMENTO_KIT_HIGIENE_PRODUTOS.IdRegistro, "
                    + "ITENS_CANCELAR_PAGAMENTO_KIT_HIGIENE_PRODUTOS.Quantidade "
                    + "FROM ITENS_CANCELAR_PAGAMENTO_KIT_HIGIENE_PRODUTOS "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON ITENS_CANCELAR_PAGAMENTO_KIT_HIGIENE_PRODUTOS.IdProd=PRODUTOS_AC.IdProd "
                    + "WHERE ITENS_CANCELAR_PAGAMENTO_KIT_HIGIENE_PRODUTOS.IdRegistro='" + jIdRegistro.getText() + "' "
                    + "AND IdItemINT='" + idItemPagto + "'");
            while (conecta.rs.next()) {
                CancelamentoPagamentoKitHigiene pCancelamentos = new CancelamentoPagamentoKitHigiene();
                pCancelamentos.setIdRegistro(conecta.rs.getInt("IdRegistro"));
                pCancelamentos.setCodigoProduto(conecta.rs.getInt("IdProd"));
                pCancelamentos.setDescricaoProduto(conecta.rs.getString("DescricaoProd"));
                pCancelamentos.setUnidadeProduto(conecta.rs.getString("UnidadeProd"));
                pCancelamentos.setQuantidadeProduto(conecta.rs.getInt("Quantidade"));
                listaCancelCodigo.add(pCancelamentos);
            }
            return listaCancelCodigo;
        } catch (SQLException ex) {
            Logger.getLogger(PesquisarProdutosCanceladosKits.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public CancelamentoPagamentoKitHigiene MOSTRAR_KIT_INTERNO_cancelado(CancelamentoPagamentoKitHigiene objCancelaKit) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT ITENS_CANCELAR_PAGAMENTO_KIT_HIGIENE_INTERNOS.IdItemINT, "
                    + "ITENS_CANCELAR_PAGAMENTO_KIT_HIGIENE_INTERNOS.IdRegistro,"
                    + "ITENS_CANCELAR_PAGAMENTO_KIT_HIGIENE_INTERNOS.IdInternoCrc, "
                    + "PRONTUARIOSCRC.NomeInternoCrc,PRONTUARIOSCRC.FotoInternoCrc, "
                    + "PRONTUARIOSCRC.ImagemFrente, "
                    + "ITENS_CANCELAR_PAGAMENTO_KIT_HIGIENE_INTERNOS.DataEntrega, "
                    + "ITENS_CANCELAR_PAGAMENTO_KIT_HIGIENE_INTERNOS.Horario "
                    + "FROM ITENS_CANCELAR_PAGAMENTO_KIT_HIGIENE_INTERNOS "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENS_CANCELAR_PAGAMENTO_KIT_HIGIENE_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE IdRegistro='" + jIdRegistro.getText() + "' "
                    + "AND ITENS_CANCELAR_PAGAMENTO_KIT_HIGIENE_INTERNOS.IdInternoCrc='" + pINTERNOS + "'");
            conecta.rs.first();
            idItemINT = conecta.rs.getInt("IdItemINT");
            codItemINT = conecta.rs.getInt("IdItemINT");
            objCancelaKit.setIdInternoKit(conecta.rs.getInt("IdInternoCrc"));
            objCancelaKit.setNomeInternoKit(conecta.rs.getString("NomeInternoCrc"));
            // Capturando foto
            caminho = conecta.rs.getString("FotoInternoCrc");
            if (caminho != null) {
                javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                jFotoInternoKit.setIcon(i);
                jFotoInternoKit.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoInternoKit.getWidth(), jFotoInternoKit.getHeight(), Image.SCALE_SMOOTH)));
            }
            // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
            byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrente"));
            if (imgBytes != null) {
                ImageIcon pic = null;
                pic = new ImageIcon(imgBytes);
                Image scaled = pic.getImage().getScaledInstance(jFotoInternoKit.getWidth(), jFotoInternoKit.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(scaled);
                jFotoInternoKit.setIcon(icon);
            }
            objCancelaKit.setDataEntrega(conecta.rs.getDate("DataEntrega"));
            objCancelaKit.setHorario(conecta.rs.getString("Horario"));
        } catch (SQLException ex) {
            Logger.getLogger(PesquisaCancelamentoKitCodigo.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
        return objCancelaKit;
    }
}
