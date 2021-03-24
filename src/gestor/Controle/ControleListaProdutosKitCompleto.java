/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ProdutoInternosKitLote;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jIdRegistroComp;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.qtdProdutosKitComo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronal
 */
public class ControleListaProdutosKitCompleto {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ProdutoInternosKitLote objProdKit = new ProdutoInternosKitLote();

    public List<ProdutoInternosKitLote> read() throws Exception {
        conecta.abrirConexao();
        List<ProdutoInternosKitLote> listaInternosKitComp = new ArrayList<ProdutoInternosKitLote>();
        try {
            conecta.executaSQL("SELECT "
                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp, "
                    + "PRODUTOS_AC.IdProd, "
                    + "PRODUTOS_AC.DescricaoProd, "
                    + "PRODUTOS_AC.UnidadeProd, "
                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd "
                    + "FROM ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdProd=PRODUTOS_AC.IdProd "
                    + "WHERE ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp='" + jIdRegistroComp.getText() + "'");
            while (conecta.rs.next()) {
                ProdutoInternosKitLote pDigi = new ProdutoInternosKitLote();
                pDigi.setIdProd(conecta.rs.getInt("IdProd"));
                pDigi.setDescricaoProduto(conecta.rs.getString("DescricaoProd"));
                pDigi.setUnidadeProd(conecta.rs.getString("UnidadeProd"));
                pDigi.setQuantidadeProd(conecta.rs.getInt("QuantProd"));
                listaInternosKitComp.add(pDigi);
                qtdProdutosKitComo = qtdProdutosKitComo + 1;
            }
            return listaInternosKitComp;
        } catch (SQLException ex) {
            Logger.getLogger(ControlePavilhaoInternosMontaKitInicial.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
