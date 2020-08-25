/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.CancelamentoPagamentoKitHigiene;
import static gestor.Visao.TelaCancelamentoPagamentoKits.idItemINT;
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
public class PesquisarInternosProdutosKitCancelado {

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
                    + "AND IdItemINT='" + idItemINT + "'");
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
            Logger.getLogger(PesquisarInternosProdutosKitCancelado.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
