/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ProdutoInternosKitLote;
import static gestor.Visao.TelaEstoqueProdutosKitBaixaLote.idProd;
import static gestor.Visao.TelaEstoqueProdutosKitBaixaLote.jCodigoBarraPesquisa;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.pTipoKitCI;
import static gestor.Visao.TelaEstoqueProdutosKitBaixaLote.jCodigoProdPesquisa;
import static gestor.Visao.TelaEstoqueProdutosKitBaixaLote.jDescricapProdPesquisa;
import static gestor.Visao.TelaEstoqueProdutosKitBaixaLote.pCODIGO_kit;
import static gestor.Visao.TelaEstoqueProdutosKitBaixaLote.pTOTAL_REGISTROS_pesquisado;
import static gestor.Visao.TelaEstoqueProdutosKitBaixaLote.pTOTAL_registros;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.idItem;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jIdRegistroComp;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.pPESQUISA_ID_kit;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.idProduto;
import static gestor.Visao.TelaEstoqueProdutosKitBaixaLote.pcodigoProduto;
import static gestor.Visao.TelaEstoqueProdutosKitBaixaLote.pRegistroComp;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ronal
 */
public class ControleBaixaLoteKitHigiene {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ProdutoInternosKitLote objProdKit = new ProdutoInternosKitLote();
    //
    double qtdItem = 0;
    String qtdItemTab;
    //
    double qtdItemKit = 0;
    String qtdItemTabKit;
    //
    int count = 0;
    int flag = 0;
    String statusProd = "Ativo";
    float qtdEstoque = 0;
    String modulo = "A";
    String compoeKit = "Sim";
    float qdtKit = 0;
    int qdtInterno = 0;
    float qtdTotal = 0;
    String nomeProduto = "";

    public List<ProdutoInternosKitLote> PESQUISA_PRODUTOS_codigo() throws Exception {
        pTOTAL_registros = 0;
        conecta.abrirConexao();
        List<ProdutoInternosKitLote> LISTA_PRODUTO_estoque = new ArrayList<ProdutoInternosKitLote>();
        try {
            conecta.executaSQL("SELECT DISTINCT "
                    + "PRODUTOS_KITS_HIGIENE_INTERNO.IdKit, "
                    + "PRODUTOS_KITS_HIGIENE_INTERNO.IdProd,"
                    + "PRODUTOS_AC.CodigoBarra, "
                    + "PRODUTOS_AC.DescricaoProd, "
                    + "PRODUTOS_AC.UnidadeProd, "
                    + "LOTE_PRODUTOS_AC.Qtd, "
                    + "PRODUTOS_KITS_HIGIENE_INTERNO.QuantItem, "
                    + "PRODUTOS_AC.StatusProd, "
                    + "LOTE_PRODUTOS_AC.Modulo, "
                    + "LOTE_PRODUTOS_AC.Lote, "
                    + "PRODUTOS_AC.CompoeKit "
                    + "FROM PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                    + "INNER JOIN LOTE_PRODUTOS_AC "
                    + "ON PRODUTOS_AC.IdProd=LOTE_PRODUTOS_AC.IdProd "
                    + "INNER JOIN KITS_HIGIENE_INTERNO "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                    + "WHERE PRODUTOS_KITS_HIGIENE_INTERNO.IdProd='" + jCodigoProdPesquisa.getText() + "' "
                    + "AND LOTE_PRODUTOS_AC.Qtd!='" + qtdEstoque + "' "
                    + "AND PRODUTOS_AC.StatusProd='" + statusProd + "' "
                    + "AND LOTE_PRODUTOS_AC.Modulo='" + modulo + "' "
                    + "AND PRODUTOS_AC.CompoeKit='" + compoeKit + "'"
                    + "AND PRODUTOS_KITS_HIGIENE_INTERNO.IdKit='" + pTipoKitCI + "'");
            while (conecta.rs.next()) {
                ProdutoInternosKitLote pPRODUTOS = new ProdutoInternosKitLote();
                pPRODUTOS.setIdProd(conecta.rs.getInt("IdProd"));
                pPRODUTOS.setCodigoBarras(conecta.rs.getString("CodigoBarra"));
                pPRODUTOS.setDescricaoProduto(conecta.rs.getString("DescricaoProd"));
                pPRODUTOS.setUnidadeProd(conecta.rs.getString("UnidadeProd"));
                pPRODUTOS.setIdKit(conecta.rs.getInt("IdKit"));
                pPRODUTOS.setQtdEstoque(conecta.rs.getFloat("Qtd"));
                pPRODUTOS.setQuantidadeProd(conecta.rs.getInt("QuantItem"));
                pPRODUTOS.setLote(conecta.rs.getString("Lote"));
                LISTA_PRODUTO_estoque.add(pPRODUTOS);
                pTOTAL_registros++;
            }
            return LISTA_PRODUTO_estoque;
        } catch (SQLException ex) {
            Logger.getLogger(ControleBaixaLoteKitHigiene.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public List<ProdutoInternosKitLote> PESQUISA_PRODUTOS_codigoBarras() throws Exception {
        pTOTAL_registros = 0;
        conecta.abrirConexao();
        List<ProdutoInternosKitLote> LISTA_PRODUTO_estoque = new ArrayList<ProdutoInternosKitLote>();
        try {
            conecta.executaSQL("SELECT DISTINCT "
                    + "PRODUTOS_KITS_HIGIENE_INTERNO.IdKit, "
                    + "PRODUTOS_KITS_HIGIENE_INTERNO.IdProd,"
                    + "PRODUTOS_AC.CodigoBarra, "
                    + "PRODUTOS_AC.DescricaoProd, "
                    + "PRODUTOS_AC.UnidadeProd, "
                    + "LOTE_PRODUTOS_AC.Qtd, "
                    + "PRODUTOS_KITS_HIGIENE_INTERNO.QuantItem, "
                    + "PRODUTOS_AC.StatusProd, "
                    + "LOTE_PRODUTOS_AC.Modulo, "
                    + "LOTE_PRODUTOS_AC.Lote, "
                    + "PRODUTOS_AC.CompoeKit "
                    + "FROM PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                    + "INNER JOIN LOTE_PRODUTOS_AC "
                    + "ON PRODUTOS_AC.IdProd=LOTE_PRODUTOS_AC.IdProd "
                    + "INNER JOIN KITS_HIGIENE_INTERNO "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                    + "WHERE PRODUTOS_KITS_HIGIENE_INTERNO.IdProd='" + jCodigoBarraPesquisa.getText() + "' "
                    + "AND LOTE_PRODUTOS_AC.Qtd!='" + qtdEstoque + "' "
                    + "AND PRODUTOS_AC.StatusProd='" + statusProd + "' "
                    + "AND LOTE_PRODUTOS_AC.Modulo='" + modulo + "' "
                    + "AND PRODUTOS_AC.CompoeKit='" + compoeKit + "'"
                    + "AND PRODUTOS_KITS_HIGIENE_INTERNO.IdKit='" + pTipoKitCI + "'");
            while (conecta.rs.next()) {
                ProdutoInternosKitLote pPRODUTOS = new ProdutoInternosKitLote();
                pPRODUTOS.setIdProd(conecta.rs.getInt("IdProd"));
                pPRODUTOS.setCodigoBarras(conecta.rs.getString("CodigoBarra"));
                pPRODUTOS.setDescricaoProduto(conecta.rs.getString("DescricaoProd"));
                pPRODUTOS.setUnidadeProd(conecta.rs.getString("UnidadeProd"));
                pPRODUTOS.setIdKit(conecta.rs.getInt("IdKit"));
                pPRODUTOS.setQtdEstoque(conecta.rs.getFloat("Qtd"));
                pPRODUTOS.setQuantidadeProd(conecta.rs.getInt("QuantItem"));
                pPRODUTOS.setLote(conecta.rs.getString("Lote"));
                LISTA_PRODUTO_estoque.add(pPRODUTOS);
                pTOTAL_registros++;
            }
            return LISTA_PRODUTO_estoque;
        } catch (SQLException ex) {
            Logger.getLogger(ControleBaixaLoteKitHigiene.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public List<ProdutoInternosKitLote> PESQUISA_PRODUTOS_descricao() throws Exception {
        pTOTAL_registros = 0;
        conecta.abrirConexao();
        List<ProdutoInternosKitLote> LISTA_PRODUTO_estoque = new ArrayList<ProdutoInternosKitLote>();
        try {
            conecta.executaSQL("SELECT DISTINCT "
                    + "PRODUTOS_KITS_HIGIENE_INTERNO.IdKit, "
                    + "PRODUTOS_KITS_HIGIENE_INTERNO.IdProd,"
                    + "PRODUTOS_AC.CodigoBarra, "
                    + "PRODUTOS_AC.DescricaoProd, "
                    + "PRODUTOS_AC.UnidadeProd, "
                    + "LOTE_PRODUTOS_AC.Qtd, "
                    + "PRODUTOS_KITS_HIGIENE_INTERNO.QuantItem, "
                    + "PRODUTOS_AC.StatusProd, "
                    + "LOTE_PRODUTOS_AC.Modulo, "
                    + "LOTE_PRODUTOS_AC.Lote, "
                    + "PRODUTOS_AC.CompoeKit "
                    + "FROM PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                    + "INNER JOIN LOTE_PRODUTOS_AC "
                    + "ON PRODUTOS_AC.IdProd=LOTE_PRODUTOS_AC.IdProd "
                    + "INNER JOIN KITS_HIGIENE_INTERNO "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                    + "WHERE PRODUTOS_AC.DescricaoProd LIKE'%" + jDescricapProdPesquisa.getText() + "%' "
                    + "AND LOTE_PRODUTOS_AC.Qtd!='" + qtdEstoque + "' "
                    + "AND PRODUTOS_AC.StatusProd='" + statusProd + "' "
                    + "AND LOTE_PRODUTOS_AC.Modulo='" + modulo + "' "
                    + "AND PRODUTOS_AC.CompoeKit='" + compoeKit + "'"
                    + "AND PRODUTOS_KITS_HIGIENE_INTERNO.IdKit='" + pTipoKitCI + "'");
            while (conecta.rs.next()) {
                ProdutoInternosKitLote pPRODUTOS = new ProdutoInternosKitLote();
                pPRODUTOS.setIdProd(conecta.rs.getInt("IdProd"));
                pPRODUTOS.setCodigoBarras(conecta.rs.getString("CodigoBarra"));
                pPRODUTOS.setDescricaoProduto(conecta.rs.getString("DescricaoProd"));
                pPRODUTOS.setUnidadeProd(conecta.rs.getString("UnidadeProd"));
                pPRODUTOS.setIdKit(conecta.rs.getInt("IdKit"));
                pPRODUTOS.setQtdEstoque(conecta.rs.getFloat("Qtd"));
                pPRODUTOS.setQuantidadeProd(conecta.rs.getInt("QuantItem"));
                pPRODUTOS.setLote(conecta.rs.getString("Lote"));
                LISTA_PRODUTO_estoque.add(pPRODUTOS);
                pTOTAL_registros++;
            }
            return LISTA_PRODUTO_estoque;
        } catch (SQLException ex) {
            Logger.getLogger(ControleBaixaLoteKitHigiene.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public List<ProdutoInternosKitLote> PESQUISA_PRODUTOS_todos() throws Exception {
        pTOTAL_REGISTROS_pesquisado = 0;
        conecta.abrirConexao();
        List<ProdutoInternosKitLote> LISTA_PRODUTO_estoque = new ArrayList<ProdutoInternosKitLote>();
        try {
            conecta.executaSQL("SELECT DISTINCT "
                    + "PRODUTOS_KITS_HIGIENE_INTERNO.IdKit, "
                    + "PRODUTOS_KITS_HIGIENE_INTERNO.IdProd,"
                    + "PRODUTOS_AC.CodigoBarra, "
                    + "PRODUTOS_AC.DescricaoProd, "
                    + "PRODUTOS_AC.UnidadeProd, "
                    + "LOTE_PRODUTOS_AC.Qtd, "
                    + "PRODUTOS_KITS_HIGIENE_INTERNO.QuantItem, "
                    + "PRODUTOS_AC.StatusProd, "
                    + "LOTE_PRODUTOS_AC.Modulo, "
                    + "LOTE_PRODUTOS_AC.Lote, "
                    + "PRODUTOS_AC.CompoeKit "
                    + "FROM PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                    + "INNER JOIN LOTE_PRODUTOS_AC "
                    + "ON PRODUTOS_AC.IdProd=LOTE_PRODUTOS_AC.IdProd "
                    + "INNER JOIN KITS_HIGIENE_INTERNO "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                    + "WHERE LOTE_PRODUTOS_AC.Qtd!='" + qtdEstoque + "' "
                    + "AND PRODUTOS_AC.StatusProd='" + statusProd + "' "
                    + "AND LOTE_PRODUTOS_AC.Modulo='" + modulo + "' "
                    + "AND PRODUTOS_AC.CompoeKit='" + compoeKit + "'"
                    + "AND PRODUTOS_KITS_HIGIENE_INTERNO.IdKit='" + pTipoKitCI + "'");
            while (conecta.rs.next()) {
                ProdutoInternosKitLote pPRODUTOS = new ProdutoInternosKitLote();
                pPRODUTOS.setIdProd(conecta.rs.getInt("IdProd"));
                pPRODUTOS.setCodigoBarras(conecta.rs.getString("CodigoBarra"));
                pPRODUTOS.setDescricaoProduto(conecta.rs.getString("DescricaoProd"));
                pPRODUTOS.setUnidadeProd(conecta.rs.getString("UnidadeProd"));
                pPRODUTOS.setIdKit(conecta.rs.getInt("IdKit"));
                pPRODUTOS.setQtdEstoque(conecta.rs.getFloat("Qtd"));
                pPRODUTOS.setQuantidadeProd(conecta.rs.getInt("QuantItem"));
                pPRODUTOS.setLote(conecta.rs.getString("Lote"));
                LISTA_PRODUTO_estoque.add(pPRODUTOS);
                pTOTAL_REGISTROS_pesquisado++;
            }
            return LISTA_PRODUTO_estoque;
        } catch (SQLException ex) {
            Logger.getLogger(ControleBaixaLoteKitHigiene.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public ProdutoInternosKitLote SELECIONAR_produto(ProdutoInternosKitLote objProdKit) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "PRODUTOS_KITS_HIGIENE_INTERNO.IdProd, "
                    + "PRODUTOS_AC.DescricaoProd, "
                    + "PRODUTOS_AC.UnidadeProd, "
                    + "PRODUTOS_AC.IdLocal, "
                    + "PRODUTOS_KITS_HIGIENE_INTERNO.IdKit, "
                    + "PRODUTOS_KITS_HIGIENE_INTERNO.QuantItem, "
                    + "LOTE_PRODUTOS_AC.Qtd "
                    + "FROM PRODUTOS_AC "
                    + "INNER JOIN LOCAL_ARMAZENAMENTO_AC "
                    + "ON PRODUTOS_AC.IdLocal=LOCAL_ARMAZENAMENTO_AC.IdLocal "
                    + "INNER JOIN LOTE_PRODUTOS_AC "
                    + "ON PRODUTOS_AC.IdProd=LOTE_PRODUTOS_AC.IdProd "
                    + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "ON PRODUTOS_AC.IdProd=PRODUTOS_KITS_HIGIENE_INTERNO.IdProd "
                    + "WHERE PRODUTOS_KITS_HIGIENE_INTERNO.IdProd='" + idProd + "' "
                    + "AND PRODUTOS_KITS_HIGIENE_INTERNO.IdKit='" + pCODIGO_kit + "'");
            conecta.rs.first();
            objProdKit.setIdProd(conecta.rs.getInt("IdProd"));
            objProdKit.setDescricaoProduto(conecta.rs.getString("DescricaoProd"));
            objProdKit.setUnidadeProd(conecta.rs.getString("UnidadeProd"));
            objProdKit.setIdLocal(conecta.rs.getInt("IdLocal"));
            objProdKit.setIdKit(conecta.rs.getInt("IdKit"));
            objProdKit.setQtdEstoque(conecta.rs.getFloat("Qtd"));
            objProdKit.setQuantidadeProd(conecta.rs.getInt("QuantItem"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO ao selecionar o registro, verifique o erro e informe ao administrador do sistema.\nERROR: " + ex);
        }
        conecta.desconecta();
        return objProdKit;
    }

    public ProdutoInternosKitLote VERIFICAR_PRODUTOS_incluido(ProdutoInternosKitLote objProdKit) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdRegistroComp, "
                    + "IdProd "
                    + "FROM ITENS_PRODUTOS_INTERNOS_PAVILHAO_KIT_LOTE "
                    + "WHERE IdRegistroComp='" + objProdKit.getIdRegistroComp() + "' "
                    + "AND IdProd='" + objProdKit.getIdProd() + "'");
            conecta.rs.first();
            pcodigoProduto = conecta.rs.getInt("IdProd");
            pRegistroComp = conecta.rs.getInt("IdRegistroComp");
        } catch (Exception e) {
        }
        conecta.desconecta();
        return objProdKit;
    }

    public ProdutoInternosKitLote VERIFICAR_PRODUTO_estoque(ProdutoInternosKitLote objProdKit) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdProd, "
                    + "IdItem, "
                    + "Qtd "
                    + "FROM LOTE_PRODUTOS_AC "
                    + "WHERE IdProd='" + objProdKit.getIdProd() + "'");
            conecta.rs.first();
            objProdKit.setIdProd(conecta.rs.getInt("IdProd"));
            objProdKit.setIdItem(conecta.rs.getInt("IdItem"));
            objProdKit.setQtdEstoque(conecta.rs.getFloat("Qtd"));
        } catch (Exception e) {
        }
        conecta.desconecta();
        return objProdKit;
    }

    public ProdutoInternosKitLote BUSCAR_CODIGO_PRODUTO_gravado(ProdutoInternosKitLote objProdKit) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdRegProdKit "
                    + "FROM ITENS_PRODUTOS_INTERNOS_PAVILHAO_KIT_LOTE");
            conecta.rs.last();
            objProdKit.setIdRegProdKit(conecta.rs.getInt("IdRegProdKit"));
        } catch (Exception ERROR) {
        }
        conecta.desconecta();
        return objProdKit;
    }

    public List<ProdutoInternosKitLote> MOSTRAR_TABELA_PRODUTO_gravado() throws Exception {
        conecta.abrirConexao();
        List<ProdutoInternosKitLote> listaInternosPavilhaoSelecionados = new ArrayList<ProdutoInternosKitLote>();
        try {
            conecta.executaSQL("SELECT DISTINCT "
                    + "ITENS_PRODUTOS_INTERNOS_PAVILHAO_KIT_LOTE.IdRegProdKit, "
                    + "ITENS_PRODUTOS_INTERNOS_PAVILHAO_KIT_LOTE.IdKit, "
                    + "ITENS_PRODUTOS_INTERNOS_PAVILHAO_KIT_LOTE.IdProd, "
                    + "PRODUTOS_AC.DescricaoProd,PRODUTOS_AC.UnidadeProd, "
                    + "ITENS_PRODUTOS_INTERNOS_PAVILHAO_KIT_LOTE.QuantProd "
                    + "FROM ITENS_PRODUTOS_INTERNOS_PAVILHAO_KIT_LOTE "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON ITENS_PRODUTOS_INTERNOS_PAVILHAO_KIT_LOTE.IdProd=PRODUTOS_AC.IdProd "
                    + "WHERE ITENS_PRODUTOS_INTERNOS_PAVILHAO_KIT_LOTE.IdRegistroComp='" + jIdRegistroComp.getText() + "'");
            while (conecta.rs.next()) {
                ProdutoInternosKitLote pPRODUTOS = new ProdutoInternosKitLote();
                pPRODUTOS.setIdRegProdKit(conecta.rs.getInt("IdRegProdKit"));
                pPRODUTOS.setIdKit(conecta.rs.getInt("IdKit"));
                pPRODUTOS.setIdProd(conecta.rs.getInt("IdProd"));
                pPRODUTOS.setDescricaoProduto(conecta.rs.getString("DescricaoProd"));
                pPRODUTOS.setUnidadeProd(conecta.rs.getString("UnidadeProd"));
                pPRODUTOS.setQuantidadeProd(conecta.rs.getInt("QuantProd"));
                listaInternosPavilhaoSelecionados.add(pPRODUTOS);
            }
            return listaInternosPavilhaoSelecionados;
        } catch (SQLException ex) {
            Logger.getLogger(ControlePavilhaoInternosMontaKitInicial.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public ProdutoInternosKitLote EXIBIR_PRODUTO_gravado(ProdutoInternosKitLote objProdKit) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT DISTINCT "
                    + "ITENS_PRODUTOS_INTERNOS_PAVILHAO_KIT_LOTE.IdRegProdKit, "
                    + "ITENS_PRODUTOS_INTERNOS_PAVILHAO_KIT_LOTE.IdKit, "
                    + "ITENS_PRODUTOS_INTERNOS_PAVILHAO_KIT_LOTE.IdProd, "
                    + "PRODUTOS_AC.DescricaoProd, "
                    + "PRODUTOS_AC.UnidadeProd, "
                    + "LOTE_PRODUTOS_AC.Qtd, "
                    + "ITENS_PRODUTOS_INTERNOS_PAVILHAO_KIT_LOTE.QuantProd "
                    + "FROM ITENS_PRODUTOS_INTERNOS_PAVILHAO_KIT_LOTE "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON ITENS_PRODUTOS_INTERNOS_PAVILHAO_KIT_LOTE.IdProd=PRODUTOS_AC.IdProd "
                    + "INNER JOIN LOTE_PRODUTOS_AC "
                    + "ON PRODUTOS_AC.IdProd=LOTE_PRODUTOS_AC.IdProd "
                    + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "ON PRODUTOS_AC.IdProd=PRODUTOS_KITS_HIGIENE_INTERNO.IdProd "
                    + "WHERE ITENS_PRODUTOS_INTERNOS_PAVILHAO_KIT_LOTE.IdRegistroComp='" + jIdRegistroComp.getText() + "' "
                    + "AND ITENS_PRODUTOS_INTERNOS_PAVILHAO_KIT_LOTE.IdProd='" + idProduto + "' "
                    + "AND ITENS_PRODUTOS_INTERNOS_PAVILHAO_KIT_LOTE.IdRegProdKit='" + idItem + "' "
                    + "AND ITENS_PRODUTOS_INTERNOS_PAVILHAO_KIT_LOTE.IdKit='" + pPESQUISA_ID_kit + "'");
            conecta.rs.first();
            objProdKit.setIdProd(conecta.rs.getInt("IdProd"));
            objProdKit.setDescricaoProduto(conecta.rs.getString("DescricaoProd"));
            objProdKit.setIdItem(conecta.rs.getInt("IdRegProdKit"));
            objProdKit.setIdKit(conecta.rs.getInt("IdKit"));
            objProdKit.setUnidadeProd(conecta.rs.getString("UnidadeProd"));
            objProdKit.setQtdEstoque(conecta.rs.getFloat("Qtd"));
            objProdKit.setQuantidadeProd(conecta.rs.getInt("QuantProd"));
        } catch (Exception ERROR) {
        }
        conecta.desconecta();
        return objProdKit;
    }

}
