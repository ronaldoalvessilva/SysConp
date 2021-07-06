/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.InventarioArmaEPI;
import static gestor.Visao.TelaInventarioArmasEquipamentosEPI.jComboBoxLocalArmazenamento;
import static gestor.Visao.TelaLocalArmazenamentoEPI.jPesqDescricaoLocal;
import static gestor.Visao.TelaPesqLocalArmazenamentoAE.idLocal;
import static gestor.Visao.TelaPesqLocalArmazenamentoAE.nomeProduto;
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
    public List<InventarioArmaEPI> ITENS_ARMAS_todos() throws Exception {

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
                    + "l.DescricaoResumida"
                    + "FROM ARMAS AS a "
                    + "INNER JOIN LOCAL_ARMAZENAMENTO_ARMAS_EPI AS l "
                    + "a.IdLocal=l.IdLocal "
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

    public List<InventarioArmaEPI> ITENS_ARMAS_nome() throws Exception {

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
                    + "l.DescricaoResumida"
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

    public List<InventarioArmaEPI> ITENS_ARMAS_codigo() throws Exception {

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
                    + "l.DescricaoResumida"
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
                    + "IdProd, "
                    + "DescricaoArma, "
                    + "UnidadeArma, "
                    + "CustoArma, "
                    + "FROM ITENS_INVENTARIO_ARMAS_EPI AS i "
                    + "INNER JOIN ARMAS AS a "
                    + "ON i.IdProd=a.Armas "
                    + "WHERE DescricaoArma='" + jPesqDescricaoProdutos.getText() + "' "
                    + "AND");
            conecta.rs.first();
            objInventEstoque.setIdProduto(conecta.rs.getInt("IdProd"));
        } catch (Exception e) {
        }
        conecta.desconecta();
        return objInventEstoque;
    }
}
