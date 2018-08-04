/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ProdutoInternosKitLote;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jIdRegistroComp;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jTabelaProdutosKitCompleto;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.qtdProd;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronal
 */
// GRAVAR E LISTAR OS PRODUTOS DO KIT COMPLETO APOS SELECIONADO
public class ControleListarGravarProdutosKitCompleto {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ProdutoInternosKitLote objProdKit = new ProdutoInternosKitLote();
    int codProd;

    public List<ProdutoInternosKitLote> read() throws Exception {
        conecta.abrirConexao();
        List<ProdutoInternosKitLote> listaInternosPavilhaoSelecionados = new ArrayList<ProdutoInternosKitLote>();
        try {
            conecta.executaSQL("SELECT * FROM ITENS_PRODUTOS_INTERNOS_PAVILHAO_KIT_LOTE "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON ITENS_PRODUTOS_INTERNOS_PAVILHAO_KIT_LOTE.IdProd=PRODUTOS_AC.IdProd "
                    + "WHERE ITENS_PRODUTOS_INTERNOS_PAVILHAO_KIT_LOTE.IdRegistroComp='" + jIdRegistroComp.getText() + "' "
                    + "AND ITENS_PRODUTOS_INTERNOS_PAVILHAO_KIT_LOTE.IdProd!=" + jTabelaProdutosKitCompleto.getValueAt(jTabelaProdutosKitCompleto.getSelectedRow(), 0) + "'");
            while (conecta.rs.next()) {
                ProdutoInternosKitLote pDigiProd = new ProdutoInternosKitLote();
                pDigiProd.setIdRegProdKit(conecta.rs.getInt("IdRegProdKit"));
                pDigiProd.setIdKit(conecta.rs.getInt("IdKit"));
                pDigiProd.setIdProd(conecta.rs.getInt("IdProd"));
                pDigiProd.setDescricaoProduto(conecta.rs.getString("DescricaoProd"));
                pDigiProd.setUnidadeProd(conecta.rs.getString("UnidadeProd"));
                pDigiProd.setQuantidadeProd(conecta.rs.getFloat("QuantProd"));
                listaInternosPavilhaoSelecionados.add(pDigiProd);
                qtdProd = qtdProd + 1;
            }
            return listaInternosPavilhaoSelecionados;
        } catch (SQLException ex) {
            Logger.getLogger(ControleListarGravarProdutosKitCompleto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

}
