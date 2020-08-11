/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.CancelamentoPagamentoKitHigiene;
import static gestor.Visao.TelaCancelamentoPagamentoKits.jIdRegistro;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronal
 */
public class PesquisarInternosProdutosCanceladosKits {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    CancelamentoPagamentoKitHigiene objCancelaKit = new CancelamentoPagamentoKitHigiene();

    String caminho = "";

    public List<CancelamentoPagamentoKitHigiene> read() throws Exception {
        conecta.abrirConexao();
        List<CancelamentoPagamentoKitHigiene> listaCancelCodigo = new ArrayList<CancelamentoPagamentoKitHigiene>();
        try {
            conecta.executaSQL("SELECT IdRegistro, "
                    + "ITENS_CANCELAR_PAGAMENTO_KIT_HIGIENE_INTERNOS.IdInternoCrc "
                    + "PRONTUARIOSCRC.NomeInternoCrc,PRODUTOS_AC.UnidadeProd, "
                    + "ITENS_CANCELAR_PAGAMENTO_KIT_HIGIENE_PRODUTOS.QuantProd "
                    + "FROM ITENS_CANCELAR_PAGAMENTO_KIT_HIGIENE_PRODUTOS "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON ITENS_CANCELAR_PAGAMENTO_KIT_HIGIENE_PRODUTOS.IdProd=PRODUTOS_AC.IdProd "
                    + "WHERE ITENS_CANCELAR_PAGAMENTO_KIT_HIGIENE_PRODUTOS.IdRegistro='" + jIdRegistro.getText() + "' "
                    + "ORDER BY IdItemPRO");
            while (conecta.rs.next()) {
                CancelamentoPagamentoKitHigiene pCancelamentos = new CancelamentoPagamentoKitHigiene();
                pCancelamentos.setIdItemSA(conecta.rs.getInt("IdItemINT"));
                pCancelamentos.setIdInternoKit(conecta.rs.getInt("IdInternoCrc"));
                pCancelamentos.setNomeInternoKit(conecta.rs.getString("NomeInternoCrc"));
                listaCancelCodigo.add(pCancelamentos);
            }
            return listaCancelCodigo;
        } catch (SQLException ex) {
            Logger.getLogger(PesquisarInternosProdutosCanceladosKits.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

//    public CancelamentoPagamentoKitHigiene MOSTRAR_KIT_INTERNO_cancelado(CancelamentoPagamentoKitHigiene objCancelaKit) {
//        conecta.abrirConexao();
//        try {
//            conecta.executaSQL("SELECT IdItemINT,IdInternoCrc "
//                    + "NomeInternoCrc,FotoInternoCrc,ImagemFrente, "
//                    + "DataEntrega,Horario "
//                    + "FROM ITENS_CANCELAR_PAGAMENTO_KIT_HIGIENE_INTERNOS "
//                    + "INNER JOIN PRONTUARIOSCRC "
//                    + "ON ITENS_CANCELAR_PAGAMENTO_KIT_HIGIENE_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
//                    + "WHERE IdItemINT='" + idItemPagto + "'");
//            conecta.rs.first();
//            idItemINT = conecta.rs.getInt("IdItemINT");
//            codItemINT = conecta.rs.getInt("IdItemINT");
//            jIdInternoKit.setText(conecta.rs.getString("IdInternoCrc"));
//            objCancelaKit.setIdInternoKit(conecta.rs.getInt("IdInternoCrc"));
//            objCancelaKit.setNomeInternoKit(conecta.rs.getString("NomeInternoCrc"));
//            // Capturando foto
//            caminho = conecta.rs.getString("FotoInternoCrc");
//            if (caminho != null) {
//                javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
//                jFotoInternoKit.setIcon(i);
//                jFotoInternoKit.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoInternoKit.getWidth(), jFotoInternoKit.getHeight(), Image.SCALE_SMOOTH)));
//            }
//            // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
//            byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrente"));
//            if (imgBytes != null) {
//                ImageIcon pic = null;
//                pic = new ImageIcon(imgBytes);
//                Image scaled = pic.getImage().getScaledInstance(jFotoInternoKit.getWidth(), jFotoInternoKit.getHeight(), Image.SCALE_SMOOTH);
//                ImageIcon icon = new ImageIcon(scaled);
//                jFotoInternoKit.setIcon(icon);
//            }
//            objCancelaKit.setDataEntrega(conecta.rs.getDate("DataEntrega"));
//            objCancelaKit.setHorario(conecta.rs.getString("Horario"));
//        } catch (SQLException ex) {
//            Logger.getLogger(PesquisaCancelamentoKitCodigo.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        conecta.desconecta();
//        return objCancelaKit;
//    }
}
