/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.InventarioArmaEPI;
import static gestor.Visao.TelaInventarioArmasEquipamentosEPI.idItem;
import static gestor.Visao.TelaInventarioArmasEquipamentosEPI.jComboBoxLocalArmazenamento;
import static gestor.Visao.TelaInventarioArmasEquipamentosEPI.jIDPesq;
import static gestor.Visao.TelaInventarioArmasEquipamentosEPI.jIdLanc;
import static gestor.Visao.TelaInventarioArmasEquipamentosEPI.nomeProdutoArma;
import static gestor.Visao.TelaLocalArmazenamentoEPI.jPesqDescricaoLocal;
import static gestor.Visao.TelaPesqLocalArmazenamentoAE.idLocal;
import static gestor.Visao.TelaPesqLocalArmazenamentoAE.nomeProduto;
import static gestor.Visao.TelaPesqProdutoInventarioAE.jCodigoPesquisaEPI;
import static gestor.Visao.TelaPesqProdutoInventarioAE.jPesqDescricaoProdutosEPI;
import static gestor.Visao.TelaPesqProdutoInventarioArmas.idInt;
import static gestor.Visao.TelaPesqProdutoInventarioArmas.jCodigoPesquisa;
import static gestor.Visao.TelaPesqProdutoInventarioArmas.jPesqDescricaoProdutos;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronaldo.silva7
 */
public class ControlePesquisaLocalAramaEPI {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    InventarioArmaEPI objInventEstoque = new InventarioArmaEPI();
    //
    String pSTATUS = "Ativo";

    public List<InventarioArmaEPI> LOCAL_ARMAZENAMENTO_desc() throws Exception {

        conecta.abrirConexao();
        List<InventarioArmaEPI> LISTAR_acessorios = new ArrayList<InventarioArmaEPI>();
        try {
            conecta.executaSQL("SELECT "
                    + "l.IdLocal, "
                    + "l.StatusLocal, "
                    + "l.DescricaoPrincipal "
                    + "FROM LOCAL_ARMAZENAMENTO_ARMAS_EPI AS l "
                    + "WHERE l.DescricaoPrincipal LIKE'%" + jPesqDescricaoLocal.getText() + "%' "
                    + "AND l.StatusLocal='" + pSTATUS + "'");
            while (conecta.rs.next()) {
                InventarioArmaEPI pLocalArmas = new InventarioArmaEPI();
                pLocalArmas.setIdLocal(conecta.rs.getInt("IdLocal"));
                pLocalArmas.setStatusLanc(conecta.rs.getString("StatusLocal"));
                pLocalArmas.setNomeLocalArmazenamento(conecta.rs.getString("DescricaoPrincipal"));
                LISTAR_acessorios.add(pLocalArmas);
            }
            return LISTAR_acessorios;
        } catch (SQLException ex) {
            Logger.getLogger(ControlePesquisaLocalAramaEPI.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public List<InventarioArmaEPI> LOCAL_ARMAZENAMENTO_todos() throws Exception {

        conecta.abrirConexao();
        List<InventarioArmaEPI> LISTAR_acessorios = new ArrayList<InventarioArmaEPI>();
        try {
            conecta.executaSQL("SELECT "
                    + "IdLocal, "
                    + "StatusLocal, "
                    + "DescricaoPrincipal "
                    + "FROM LOCAL_ARMAZENAMENTO_ARMAS_EPI "
                    + "WHERE StatusLocal='" + pSTATUS + "'");
            while (conecta.rs.next()) {
                InventarioArmaEPI pLocalArmas = new InventarioArmaEPI();
                pLocalArmas.setIdLocal(conecta.rs.getInt("IdLocal"));
                pLocalArmas.setStatusLanc(conecta.rs.getString("StatusLocal"));
                pLocalArmas.setNomeLocalArmazenamento(conecta.rs.getString("DescricaoPrincipal"));
                LISTAR_acessorios.add(pLocalArmas);
            }
            return LISTAR_acessorios;
        } catch (SQLException ex) {
            Logger.getLogger(ControlePesquisaLocalAramaEPI.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public InventarioArmaEPI MOSTRAR_dados(InventarioArmaEPI objInventEstoque) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdLocal, "
                    + "DescricaoPrincipal "
                    + "FROM LOCAL_ARMAZENAMENTO_ARMAS_EPI "
                    + "WHERE DescricaoPrincipal='" + nomeProduto + "' "
                    + "AND IdLocal='" + idLocal + "'");
            conecta.rs.first();
            objInventEstoque.setIdLocal(conecta.rs.getInt("IdLocal"));
            objInventEstoque.setNomeLocalArmazenamento(conecta.rs.getString("DescricaoPrincipal"));
        } catch (SQLException ex) {
            Logger.getLogger(ControlePesquisaLocalAramaEPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
        return objInventEstoque;
    }

    public InventarioArmaEPI MOSTRA_local(InventarioArmaEPI objInventEstoque) {
        jComboBoxLocalArmazenamento.removeAllItems();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "DescricaoPrincipal "
                    + "FROM LOCAL_ARMAZENAMENTO_ARMAS_EPI "
                    + "GROUP BY DescricaoPrincipal");
            conecta.rs.first();
            do {
                jComboBoxLocalArmazenamento.addItem(conecta.rs.getString("DescricaoPrincipal"));
            } while (conecta.rs.next());
            jComboBoxLocalArmazenamento.updateUI();
        } catch (SQLException ex) {
        }
        conecta.desconecta();
        return objInventEstoque;
    }

    //--------------------- PESQUISAS DE ITENS (ARMAS) E (EPIS) --------------------------------------------
    public List<InventarioArmaEPI> ITENS_LOCAL_ARMAS_todos() throws Exception {

        conecta.abrirConexao();
        List<InventarioArmaEPI> LISTAR_armas = new ArrayList<InventarioArmaEPI>();
        try {
            conecta.executaSQL("SELECT "
                    + "IdArma, "
                    + "StatusArma, "
                    + "DescricaoArma, "
                    + "UnidadeArma, "
                    + "CustoArma, "
                    + "l.IdLocal, "
                    + "l.DescricaoResumida "
                    + "FROM ARMAS AS a "
                    + "INNER JOIN LOCAL_ARMAZENAMENTO_ARMAS_EPI AS l "
                    + "ON a.IdLocal=l.IdLocal "
                    + "WHERE a.StatusArma='" + pSTATUS + "'");
            while (conecta.rs.next()) {
                InventarioArmaEPI pArmas = new InventarioArmaEPI();
                pArmas.setIdProduto(conecta.rs.getInt("IdArma"));
                pArmas.setStatusLanc(conecta.rs.getString("StatusArma"));
                pArmas.setNomeProduto(conecta.rs.getString("DescricaoArma"));
                pArmas.setUnidade(conecta.rs.getString("UnidadeArma"));
                pArmas.setValorCusto(conecta.rs.getFloat("CustoArma"));
                pArmas.setIdLocal(conecta.rs.getInt("IdLocal"));
                pArmas.setNomeLocalArmazenamento(conecta.rs.getString("DescricaoResumida"));
                LISTAR_armas.add(pArmas);
            }
            return LISTAR_armas;
        } catch (SQLException ex) {
            Logger.getLogger(ControlePesquisaLocalAramaEPI.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public List<InventarioArmaEPI> ITENS_LOCAL_ARMAS_nome() throws Exception {

        conecta.abrirConexao();
        List<InventarioArmaEPI> LISTAR_armas = new ArrayList<InventarioArmaEPI>();
        try {
            conecta.executaSQL("SELECT "
                    + "IdArma, "
                    + "StatusArma, "
                    + "DescricaoArma, "
                    + "UnidadeArma, "
                    + "CustoArma, "
                    + "l.IdLocal, "
                    + "l.DescricaoResumida "
                    + "FROM ARMAS AS a "
                    + "INNER JOIN LOCAL_ARMAZENAMENTO_ARMAS_EPI AS l "
                    + "a.IdLocal=l.IdLocal "
                    + "WHERE a.StatusArma='" + pSTATUS + "' "
                    + "AND a.DescricaoArma LIKE '%" + jPesqDescricaoProdutos.getText() + "%'");
            while (conecta.rs.next()) {
                InventarioArmaEPI pArmas = new InventarioArmaEPI();
                pArmas.setIdProduto(conecta.rs.getInt("IdArma"));
                pArmas.setStatusLanc(conecta.rs.getString("StatusArma"));
                pArmas.setNomeProduto(conecta.rs.getString("DescricaoArma"));
                pArmas.setUnidade(conecta.rs.getString("UnidadeArma"));
                pArmas.setValorCusto(conecta.rs.getFloat("CustoArma"));
                pArmas.setIdLocal(conecta.rs.getInt("IdLocal"));
                pArmas.setNomeLocalArmazenamento(conecta.rs.getString("DescricaoResumida"));
                LISTAR_armas.add(pArmas);
            }
            return LISTAR_armas;
        } catch (SQLException ex) {
            Logger.getLogger(ControlePesquisaLocalAramaEPI.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public List<InventarioArmaEPI> ITENS_LOCAL_ARMAS_codigo() throws Exception {

        conecta.abrirConexao();
        List<InventarioArmaEPI> LISTAR_armas = new ArrayList<InventarioArmaEPI>();
        try {
            conecta.executaSQL("SELECT "
                    + "IdArma, "
                    + "StatusArma, "
                    + "DescricaoArma, "
                    + "UnidadeArma, "
                    + "CustoArma, "
                    + "l.IdLocal, "
                    + "l.DescricaoResumida "
                    + "FROM ARMAS AS a "
                    + "INNER JOIN LOCAL_ARMAZENAMENTO_ARMAS_EPI AS l "
                    + "a.IdLocal=l.IdLocal "
                    + "WHERE a.StatusArma='" + pSTATUS + "' "
                    + "AND a.IdArma='" + jCodigoPesquisa.getText() + "'");
            while (conecta.rs.next()) {
                InventarioArmaEPI pArmas = new InventarioArmaEPI();
                pArmas.setIdProduto(conecta.rs.getInt("IdArma"));
                pArmas.setStatusLanc(conecta.rs.getString("StatusArma"));
                pArmas.setNomeProduto(conecta.rs.getString("DescricaoArma"));
                pArmas.setUnidade(conecta.rs.getString("UnidadeArma"));
                pArmas.setValorCusto(conecta.rs.getFloat("CustoArma"));
                pArmas.setIdLocal(conecta.rs.getInt("IdLocal"));
                pArmas.setNomeLocalArmazenamento(conecta.rs.getString("DescricaoResumida"));
                LISTAR_armas.add(pArmas);
            }
            return LISTAR_armas;
        } catch (SQLException ex) {
            Logger.getLogger(ControlePesquisaLocalAramaEPI.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public InventarioArmaEPI MOSTRAR_ITENS_inventario(InventarioArmaEPI objInventEstoque) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "a.IdArma, "
                    + "a.DescricaoArma, "
                    + "a.UnidadeArma, "
                    + "a.CustoArma, "
                    + "l.DescricaoResumida "
                    + "FROM ARMAS AS a "
                    + "INNER JOIN LOCAL_ARMAZENAMENTO_ARMAS_EPI AS l "
                    + "ON a.IdLocal=l.IdLocal "
                    + "WHERE a.DescricaoArma='" + jPesqDescricaoProdutos.getText() + "' "
                    + "AND a.IdArma='" + idInt + "'");
            conecta.rs.first();
            objInventEstoque.setIdProduto(conecta.rs.getInt("IdArma"));
            objInventEstoque.setNomeProduto(conecta.rs.getString("DescricaoArma"));
            objInventEstoque.setUnidade(conecta.rs.getString("UnidadeArma"));
            objInventEstoque.setValorCusto(conecta.rs.getFloat("CustoArma"));
            objInventEstoque.setNomeLocalArmazenamento(conecta.rs.getString("DescricaoResumida"));
        } catch (Exception e) {
        }
        conecta.desconecta();
        return objInventEstoque;
    }

    // ---------------------- ITENS DO INVENTÁRIIO -------------------------------------------------
    public InventarioArmaEPI VERIFICAR_TIPO_produto(InventarioArmaEPI objInventEstoque) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdLanc, "
                    + "TipoProduto "
                    + "FROM ITENS_INVENTARIO_ARMAS_EPI "
                    + "WHERE IdLanc='" + jIDPesq.getText() + "'");
            conecta.rs.first();
            objInventEstoque.setTipoArmaEPI(conecta.rs.getInt("TipoProduto"));
        } catch (SQLException ex) {
            Logger.getLogger(ControlePesquisaLocalAramaEPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
        return objInventEstoque;
    }

    public InventarioArmaEPI VERIFICAR_TIPO2_produto(InventarioArmaEPI objInventEstoque) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdLanc, "
                    + "TipoProduto "
                    + "FROM ITENS_INVENTARIO_ARMAS_EPI "
                    + "WHERE IdLanc='" + jIdLanc.getText() + "' "
                    + "AND Iditem='" + idItem + "'");
            conecta.rs.first();
            objInventEstoque.setTipoArmaEPI(conecta.rs.getInt("TipoProduto"));
        } catch (SQLException ex) {
            Logger.getLogger(ControlePesquisaLocalAramaEPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
        return objInventEstoque;
    }

    public List<InventarioArmaEPI> ITENS_ARMAS_registro() throws Exception {

        conecta.abrirConexao();
        List<InventarioArmaEPI> LISTAR_armas = new ArrayList<InventarioArmaEPI>();
        try {
            conecta.executaSQL("SELECT "
                    + "a.IdArma, "
                    + "a.StatusArma, "
                    + "a.DescricaoArma, "
                    + "a.UnidadeArma, "
                    + "a.CustoArma, "
                    + "i.IdItem, "
                    + "i.IdLanc, "
                    + "i.IdProd, "
                    + "i.QtdItem, "
                    + "i.Lote, "
                    + "i.DataLote, "
                    + "l.IdLocal, "
                    + "l.DescricaoResumida "
                    + "FROM ARMAS AS a "
                    + "INNER JOIN ITENS_INVENTARIO_ARMAS_EPI AS i "
                    + "ON a.IdArma=i.IdProd "
                    + "INNER JOIN LOCAL_ARMAZENAMENTO_ARMAS_EPI AS l "
                    + "ON a.IdLocal=l.IdLocal "
                    + "WHERE i.IdLanc='" + jIdLanc.getText() + "'");
            while (conecta.rs.next()) {
                InventarioArmaEPI pArmas = new InventarioArmaEPI();
                pArmas.setIdItem(conecta.rs.getInt("IdItem"));
                pArmas.setIdProduto(conecta.rs.getInt("IdProd"));
                pArmas.setNomeProduto(conecta.rs.getString("DescricaoArma"));
                pArmas.setUnidade(conecta.rs.getString("UnidadeArma"));
                pArmas.setValorCusto(conecta.rs.getFloat("CustoArma"));
                pArmas.setQtdItem(conecta.rs.getInt("QtdItem"));
                pArmas.setNomeLocalArmazenamento(conecta.rs.getString("DescricaoResumida"));
                pArmas.setDataLote(conecta.rs.getDate("DataLote"));
                LISTAR_armas.add(pArmas);
            }
            return LISTAR_armas;
        } catch (SQLException ex) {
            Logger.getLogger(ControlePesquisaLocalAramaEPI.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public List<InventarioArmaEPI> ITENS_EPI_registro() throws Exception {

        conecta.abrirConexao();
        List<InventarioArmaEPI> LISTAR_armas = new ArrayList<InventarioArmaEPI>();
        try {
            conecta.executaSQL("SELECT "
                    + "e.IdEquipamento, "
                    + "e.StatusEquipamento, "
                    + "e.DescricaoEquipamento, "
                    + "e.Unidade, "
                    + "i.IdItem, "
                    + "i.IdLanc, "
                    + "i.IdProd, "
                    + "i.QtdItem, "
                    + "i.Lote, "
                    + "i.DataLote, "
                    + "l.IdLocal, "
                    + "l.DescricaoResumida "
                    + "FROM EQUIPAMENTOS_SEGURANCA_EPI AS e "
                    + "INNER JOIN ITENS_INVENTARIO_ARMAS_EPI AS i "
                    + "ON e.IdEquipamento=i.IdProd "
                    + "INNER JOIN LOCAL_ARMAZENAMENTO_ARMAS_EPI AS l "
                    + "ON e.IdLocal=l.IdLocal "
                    + "WHERE i.IdLanc='" + jIdLanc.getText() + "'");
            while (conecta.rs.next()) {
                InventarioArmaEPI pArmas = new InventarioArmaEPI();
                pArmas.setIdItem(conecta.rs.getInt("IdItem"));
                pArmas.setIdProduto(conecta.rs.getInt("IdProd"));
                pArmas.setNomeProduto(conecta.rs.getString("DescricaoEquipamento"));
                pArmas.setUnidade(conecta.rs.getString("Unidade"));;
                pArmas.setQtdItem(conecta.rs.getInt("QtdItem"));
                pArmas.setNomeLocalArmazenamento(conecta.rs.getString("DescricaoResumida"));
                pArmas.setDataLote(conecta.rs.getDate("DataLote"));
                LISTAR_armas.add(pArmas);
            }
            return LISTAR_armas;
        } catch (SQLException ex) {
            Logger.getLogger(ControlePesquisaLocalAramaEPI.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public InventarioArmaEPI EXIBIR_produto(InventarioArmaEPI objInventEstoque) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "a.IdArma, "
                    + "a.StatusArma, "
                    + "a.DescricaoArma, "
                    + "a.UnidadeArma, "
                    + "a.CustoArma, "
                    + "i.IdItem, "
                    + "i.IdLanc, "
                    + "i.IdProd, "
                    + "i.QtdItem, "
                    + "i.Lote, "
                    + "i.DataLote, "
                    + "l.IdLocal, "
                    + "l.DescricaoResumida, "
                    + "a.DataLicencaArma "
                    + "FROM ARMAS AS a "
                    + "INNER JOIN ITENS_INVENTARIO_ARMAS_EPI AS i "
                    + "ON a.IdArma=i.IdProd "
                    + "INNER JOIN LOCAL_ARMAZENAMENTO_ARMAS_EPI AS l "
                    + "ON a.IdLocal=l.IdLocal "
                    + "WHERE i.IdLanc='" + jIdLanc.getText() + "' "
                    + "AND a.DescricaoArma='" + nomeProdutoArma + "' "
                    + "AND i.IdItem='" + idItem + "'");
            conecta.rs.first();
            objInventEstoque.setIdProduto(conecta.rs.getInt("IdProd"));
            objInventEstoque.setNomeProduto(conecta.rs.getString("DescricaoArma"));
            objInventEstoque.setIdItem(conecta.rs.getInt("IdItem"));
            objInventEstoque.setUnidade(conecta.rs.getString("UnidadeArma"));
            objInventEstoque.setQtdItem(conecta.rs.getInt("QtdItem"));
            objInventEstoque.setValorCusto(conecta.rs.getFloat("CustoArma"));
            objInventEstoque.setNomeLocalArmazenamento(conecta.rs.getString("DescricaoResumida"));
            objInventEstoque.setDataLote(conecta.rs.getDate("DataLicencaArma"));
        } catch (Exception e) {
        }
        conecta.desconecta();
        return objInventEstoque;
    }

    public InventarioArmaEPI EXIBIR_produtoEPI(InventarioArmaEPI objInventEstoque) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "e.IdEquipamento, "
                    + "e.StatusEquipamento, "
                    + "e.DescricaoEquipamento, "
                    + "e.Unidade, "
                    + "i.IdItem, "
                    + "i.IdLanc, "
                    + "i.IdProd, "
                    + "i.QtdItem, "
                    + "i.Lote, "
                    + "i.DataLote, "
                    + "l.IdLocal, "
                    + "l.DescricaoResumida, "
                    + "e.DataCadastroEquipamento "
                    + "FROM EQUIPAMENTOS_SEGURANCA_EPI AS e "
                    + "INNER JOIN ITENS_INVENTARIO_ARMAS_EPI AS i "
                    + "ON e.IdEquipamento=i.IdProd "
                    + "INNER JOIN LOCAL_ARMAZENAMENTO_ARMAS_EPI AS l "
                    + "ON e.IdLocal=l.IdLocal "
                    + "WHERE i.IdLanc='" + jIdLanc.getText() + "' "
                    + "AND e.DescricaoEquipamento='" + nomeProdutoArma + "' "
                    + "AND i.IdItem='" + idItem + "'");
            conecta.rs.first();
            objInventEstoque.setIdProduto(conecta.rs.getInt("IdProd"));
            objInventEstoque.setNomeProduto(conecta.rs.getString("DescricaoEquipamento"));
            objInventEstoque.setIdItem(conecta.rs.getInt("IdItem"));
            objInventEstoque.setUnidade(conecta.rs.getString("Unidade"));
            objInventEstoque.setQtdItem(conecta.rs.getInt("QtdItem"));
            objInventEstoque.setNomeLocalArmazenamento(conecta.rs.getString("DescricaoResumida"));
            objInventEstoque.setDataLote(conecta.rs.getDate("DataCadastroEquipamento"));
        } catch (Exception e) {
        }
        conecta.desconecta();
        return objInventEstoque;
    }

    //----------------------------------------- EQUIPAMENTOS - EPI -------------------------------------------------------------
    public List<InventarioArmaEPI> ITENS_EPI_todos() throws Exception {

        conecta.abrirConexao();
        List<InventarioArmaEPI> LISTAR_armas = new ArrayList<InventarioArmaEPI>();
        try {
            conecta.executaSQL("SELECT "
                    + "IdEquipamento, "
                    + "StatusEquipamento, "
                    + "DescricaoEquipamento, "
                    + "Unidade, "
                    + "l.IdLocal, "
                    + "l.DescricaoResumida "
                    + "FROM EQUIPAMENTOS_SEGURANCA_EPI AS e "
                    + "INNER JOIN LOCAL_ARMAZENAMENTO_ARMAS_EPI AS l "
                    + "ON e.IdLocal=l.IdLocal "
                    + "WHERE e.StatusEquipamento='" + pSTATUS + "'");
            while (conecta.rs.next()) {
                InventarioArmaEPI pArmas = new InventarioArmaEPI();
                pArmas.setIdProduto(conecta.rs.getInt("IdEquipamento"));
                pArmas.setStatusLanc(conecta.rs.getString("StatusEquipamento"));
                pArmas.setNomeProduto(conecta.rs.getString("DescricaoEquipamento"));
                pArmas.setUnidade(conecta.rs.getString("Unidade"));
                pArmas.setIdLocal(conecta.rs.getInt("IdLocal"));
                pArmas.setNomeLocalArmazenamento(conecta.rs.getString("DescricaoResumida"));
                LISTAR_armas.add(pArmas);
            }
            return LISTAR_armas;
        } catch (SQLException ex) {
            Logger.getLogger(ControlePesquisaLocalAramaEPI.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public List<InventarioArmaEPI> ITENS_EPI_codigo() throws Exception {

        conecta.abrirConexao();
        List<InventarioArmaEPI> LISTAR_armas = new ArrayList<InventarioArmaEPI>();
        try {
            conecta.executaSQL("SELECT "
                    + "IdEquipamento, "
                    + "StatusEquipamento, "
                    + "DescricaoEquipamento, "
                    + "Unidade, "
                    + "l.IdLocal, "
                    + "l.DescricaoResumida "
                    + "FROM EQUIPAMENTOS_SEGURANCA_EPI AS e "
                    + "INNER JOIN LOCAL_ARMAZENAMENTO_ARMAS_EPI AS l "
                    + "ON e.IdLocal=l.IdLocal "
                    + "WHERE e.StatusEquipamento='" + pSTATUS + "' "
                    + "AND e.IdEquipamento'" + jCodigoPesquisaEPI.getText() + "'");
            while (conecta.rs.next()) {
                InventarioArmaEPI pArmas = new InventarioArmaEPI();
                pArmas.setIdProduto(conecta.rs.getInt("IdEquipamento"));
                pArmas.setStatusLanc(conecta.rs.getString("StatusEquipamento"));
                pArmas.setNomeProduto(conecta.rs.getString("DescricaoEquipamento"));
                pArmas.setUnidade(conecta.rs.getString("Unidade"));
                pArmas.setIdLocal(conecta.rs.getInt("IdLocal"));
                pArmas.setNomeLocalArmazenamento(conecta.rs.getString("DescricaoResumida"));
                LISTAR_armas.add(pArmas);
            }
            return LISTAR_armas;
        } catch (SQLException ex) {
            Logger.getLogger(ControlePesquisaLocalAramaEPI.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public List<InventarioArmaEPI> ITENS_EPI_nome() throws Exception {

        conecta.abrirConexao();
        List<InventarioArmaEPI> LISTAR_armas = new ArrayList<InventarioArmaEPI>();
        try {
            conecta.executaSQL("SELECT "
                    + "IdEquipamento, "
                    + "StatusEquipamento, "
                    + "DescricaoEquipamento, "
                    + "Unidade, "
                    + "l.IdLocal, "
                    + "l.DescricaoResumida "
                    + "FROM EQUIPAMENTOS_SEGURANCA_EPI AS e "
                    + "INNER JOIN LOCAL_ARMAZENAMENTO_ARMAS_EPI AS l "
                    + "ON e.IdLocal=l.IdLocal "
                    + "WHERE e.StatusEquipamento='" + pSTATUS + "' "
                    + "AND e.DescricaoEquipamento LIKE '%" + jPesqDescricaoProdutosEPI.getText() + "%'");
            while (conecta.rs.next()) {
                InventarioArmaEPI pArmas = new InventarioArmaEPI();
                pArmas.setIdProduto(conecta.rs.getInt("IdEquipamento"));
                pArmas.setStatusLanc(conecta.rs.getString("StatusEquipamento"));
                pArmas.setNomeProduto(conecta.rs.getString("DescricaoEquipamento"));
                pArmas.setUnidade(conecta.rs.getString("Unidade"));
                pArmas.setIdLocal(conecta.rs.getInt("IdLocal"));
                pArmas.setNomeLocalArmazenamento(conecta.rs.getString("DescricaoResumida"));
                LISTAR_armas.add(pArmas);
            }
            return LISTAR_armas;
        } catch (SQLException ex) {
            Logger.getLogger(ControlePesquisaLocalAramaEPI.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public InventarioArmaEPI MOSTRAR_ITENS_inventarioEPI(InventarioArmaEPI objInventEstoque) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "e.IdEquipamento, "
                    + "e.DescricaoEquipamento, "
                    + "e.Unidade, "
                    //                    + "e.CustoArma, "
                    + "l.DescricaoResumida "
                    + "FROM EQUIPAMENTOS_SEGURANCA_EPI AS e "
                    + "INNER JOIN LOCAL_ARMAZENAMENTO_ARMAS_EPI AS l "
                    + "ON e.IdLocal=l.IdLocal "
                    + "WHERE e.DescricaoEquipamento='" + jPesqDescricaoProdutosEPI.getText() + "' "
                    + "AND e.IdEquipamento='" + jCodigoPesquisaEPI.getText() + "'");
            conecta.rs.first();
            objInventEstoque.setIdProduto(conecta.rs.getInt("IdEquipamento"));
            objInventEstoque.setNomeProduto(conecta.rs.getString("DescricaoEquipamento"));
            objInventEstoque.setUnidade(conecta.rs.getString("Unidade"));
//            objInventEstoque.setValorCusto(conecta.rs.getFloat("CustoArma"));
            objInventEstoque.setNomeLocalArmazenamento(conecta.rs.getString("DescricaoResumida"));
        } catch (Exception e) {
        }
        conecta.desconecta();
        return objInventEstoque;
    }
}
