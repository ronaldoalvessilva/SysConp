/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.InventarioArmaEPI;
import static gestor.Visao.TelaInventarioArmasEquipamentosEPI.dataFinal;
import static gestor.Visao.TelaInventarioArmasEquipamentosEPI.dataInicial;
import static gestor.Visao.TelaInventarioArmasEquipamentosEPI.jComboBoxTipoInventario;
import static gestor.Visao.TelaInventarioArmasEquipamentosEPI.jIDPesq;
import static gestor.Visao.TelaInventarioArmasEquipamentosEPI.jIdLanc;
import static gestor.Visao.TelaInventarioArmasEquipamentosEPI.jIdProduto;
import static gestor.Visao.TelaInventarioArmasEquipamentosEPI.jRBtArmas;
import static gestor.Visao.TelaInventarioArmasEquipamentosEPI.jRBtEPIs;
import static gestor.Visao.TelaInventarioArmasEquipamentosEPI.pTOTAL_inve;
import static gestor.Visao.TelaInventarioArmasEquipamentosEPI.pRESPOSTA_inv;
import static gestor.Visao.TelaInventarioArmasEquipamentosEPI.pCODIGO_inventario;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleInventarioArmasEPIs {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    InventarioArmaEPI objInventEstoque = new InventarioArmaEPI();
    int codLocal;
    int codProd;

    public InventarioArmaEPI incluirInventarioAE(InventarioArmaEPI objInventEstoque) {
        pBUSCAR_LOCAL_armazenamento(objInventEstoque.getNomeLocalArmazenamento());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO INVENTARIO_ARMAS_EPI (TipoProduto,StatusLanc,TipoInventario,IdLocal,Responsavel,DataInicio,DataTermino,HorarioInicio,HorarioTermino,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objInventEstoque.getTipoProduto());
            pst.setString(2, objInventEstoque.getStatusLanc());
            pst.setString(3, objInventEstoque.getTipoInventario());
            pst.setInt(4, codLocal);
            pst.setString(5, objInventEstoque.getResponsavel());
            pst.setTimestamp(6, new java.sql.Timestamp(objInventEstoque.getDataInicio().getTime()));
            if (objInventEstoque.getDataTermino() != null) {
                pst.setTimestamp(7, new java.sql.Timestamp(objInventEstoque.getDataTermino().getTime()));
            } else {
                pst.setDate(7, null);
            }
            pst.setString(8, objInventEstoque.getHorarioInicio());
            pst.setString(9, objInventEstoque.getHorarioTermino());
            pst.setString(10, objInventEstoque.getObservacao());
            pst.setString(11, objInventEstoque.getUsuarioInsert());
            pst.setString(12, objInventEstoque.getDataInsert());
            pst.setString(13, objInventEstoque.getHorarioInsert());
            pst.execute();
            pRESPOSTA_inv = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_inv = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objInventEstoque;
    }

    public InventarioArmaEPI alterarInventarioAE(InventarioArmaEPI objInventEstoque) {
        pBUSCAR_LOCAL_armazenamento(objInventEstoque.getNomeLocalArmazenamento());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE INVENTARIO_ARMAS_EPI SET TipoProduto=?,StatusLanc=?,TipoInventario=?,IdLocal=?,Responsavel=?,DataInicio=?,DataTermino=?,HorarioInicio=?,HorarioTermino=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdLanc='" + objInventEstoque.getIdLanc() + "'");
            pst.setString(1, objInventEstoque.getTipoProduto());
            pst.setString(2, objInventEstoque.getStatusLanc());
            pst.setString(3, objInventEstoque.getTipoInventario());
            pst.setInt(4, codLocal);
            pst.setString(5, objInventEstoque.getResponsavel());
            pst.setTimestamp(6, new java.sql.Timestamp(objInventEstoque.getDataInicio().getTime()));
            if (objInventEstoque.getDataTermino() != null) {
                pst.setTimestamp(7, new java.sql.Timestamp(objInventEstoque.getDataTermino().getTime()));
            } else {
                pst.setDate(7, null);
            }
            pst.setString(8, objInventEstoque.getHorarioInicio());
            pst.setString(9, objInventEstoque.getHorarioTermino());
            pst.setString(10, objInventEstoque.getObservacao());
            pst.setString(11, objInventEstoque.getUsuarioUp());
            pst.setString(12, objInventEstoque.getDataUp());
            pst.setString(13, objInventEstoque.getHorarioUp());
            pst.executeUpdate();
            pRESPOSTA_inv = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_inv = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objInventEstoque;
    }

    public InventarioArmaEPI excluirInventarioAE(InventarioArmaEPI objInventEstoque) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM INVENTARIO_ARMAS_EPI WHERE IdLanc='" + objInventEstoque.getIdLanc() + "'");
            pst.executeUpdate();
            pRESPOSTA_inv = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_inv = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objInventEstoque;
    }

    public InventarioArmaEPI efetivarInventarioAE(InventarioArmaEPI objInventEstoque) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE INVENTARIO_ARMAS_EPI SET StatusLanc=?,DataTermino=?,HorarioTermino=? WHERE IdLanc='" + objInventEstoque.getIdLanc() + "'");
            pst.setString(1, objInventEstoque.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objInventEstoque.getDataTermino().getTime()));
            pst.setString(3, objInventEstoque.getHorarioTermino());
            pst.executeUpdate();
            pRESPOSTA_inv = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_inv = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel EFETIVA essse inventário.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objInventEstoque;
    }

    public void pBUSCAR_LOCAL_armazenamento(String nomeLocal) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdLocal,"
                    + "DescricaoResumida "
                    + "FROM LOCAL_ARMAZENAMENTO_ARMAS_EPI "
                    + "WHERE DescricaoResumida='" + nomeLocal + "'");
            conecta.rs.first();
            codLocal = conecta.rs.getInt("IdLocal");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar código do local de armazenamento.\nERRO :" + ex);
        }
    }

    public List<InventarioArmaEPI> pPESQUISAR_INVENTARIO_codigo() throws Exception {
        pTOTAL_inve = 0;
        conecta.abrirConexao();
        List<InventarioArmaEPI> LISTAR_inventario = new ArrayList<InventarioArmaEPI>();
        try {
            conecta.executaSQL("SELECT "
                    + "IdLanc, "
                    + "TipoProduto, "
                    + "DataInicio, "
                    + "StatusLanc, "
                    + "Observacao "
                    + "FROM INVENTARIO_ARMAS_EPI "
                    + "WHERE IdLanc='" + jIDPesq.getText() + "'");
            while (conecta.rs.next()) {
                InventarioArmaEPI pInventaEPI = new InventarioArmaEPI();
                pInventaEPI.setIdLanc(conecta.rs.getInt("IdLanc"));
                pInventaEPI.setTipoProduto(conecta.rs.getString("TipoProduto"));
                pInventaEPI.setStatusLanc(conecta.rs.getString("StatusLanc"));
                pInventaEPI.setDataInicio(conecta.rs.getDate("DataInicio"));
                pInventaEPI.setObservacao(conecta.rs.getString("Observacao"));
                LISTAR_inventario.add(pInventaEPI);
                pTOTAL_inve++;
            }
            return LISTAR_inventario;
        } catch (SQLException ex) {
            Logger.getLogger(ControleInventarioArmasEPIs.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public List<InventarioArmaEPI> pPESQUISAR_INVENTARIO_todos() throws Exception {
        pTOTAL_inve = 0;
        conecta.abrirConexao();
        List<InventarioArmaEPI> LISTAR_inventario = new ArrayList<InventarioArmaEPI>();
        try {
            conecta.executaSQL("SELECT "
                    + "IdLanc, "
                    + "TipoProduto, "
                    + "DataInicio, "
                    + "StatusLanc, "
                    + "Observacao "
                    + "FROM INVENTARIO_ARMAS_EPI "
                    + "ORDER BY IdLanc");
            while (conecta.rs.next()) {
                InventarioArmaEPI pInventaEPI = new InventarioArmaEPI();
                pInventaEPI.setIdLanc(conecta.rs.getInt("IdLanc"));
                pInventaEPI.setTipoProduto(conecta.rs.getString("TipoProduto"));
                pInventaEPI.setStatusLanc(conecta.rs.getString("StatusLanc"));
                pInventaEPI.setDataInicio(conecta.rs.getDate("DataInicio"));
                pInventaEPI.setObservacao(conecta.rs.getString("Observacao"));
                LISTAR_inventario.add(pInventaEPI);
                pTOTAL_inve++;
            }
            return LISTAR_inventario;
        } catch (SQLException ex) {
            Logger.getLogger(ControleInventarioArmasEPIs.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public List<InventarioArmaEPI> pPESQUISAR_INVENTARIO_data() throws Exception {
        pTOTAL_inve = 0;
        conecta.abrirConexao();
        List<InventarioArmaEPI> LISTAR_inventario = new ArrayList<InventarioArmaEPI>();
        try {
            conecta.executaSQL("SELECT "
                    + "IdLanc, "
                    + "TipoProduto, "
                    + "DataInicio, "
                    + "StatusLanc, "
                    + "Observacao "
                    + "FROM INVENTARIO_ARMAS_EPI "
                    + "WHERE DataInicio BETWEEN'" + dataInicial + "' "
                    + "AND'" + dataFinal + "'");
            while (conecta.rs.next()) {
                InventarioArmaEPI pInventaEPI = new InventarioArmaEPI();
                pInventaEPI.setIdLanc(conecta.rs.getInt("IdLanc"));
                pInventaEPI.setTipoProduto(conecta.rs.getString("TipoProduto"));
                pInventaEPI.setStatusLanc(conecta.rs.getString("StatusLanc"));
                pInventaEPI.setDataInicio(conecta.rs.getDate("DataInicio"));
                pInventaEPI.setObservacao(conecta.rs.getString("Observacao"));
                LISTAR_inventario.add(pInventaEPI);
                pTOTAL_inve++;
            }
            return LISTAR_inventario;
        } catch (SQLException ex) {
            Logger.getLogger(ControleInventarioArmasEPIs.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public List<InventarioArmaEPI> pPESQUISAR_INVENTARIO_selecionado() throws Exception {
        pTOTAL_inve = 0;
        conecta.abrirConexao();
        List<InventarioArmaEPI> LISTAR_inventario = new ArrayList<InventarioArmaEPI>();
        try {
            conecta.executaSQL("SELECT  "
                    + "i.IdLanc, "
                    + "i.TipoProduto, "
                    + "i.StatusLanc, "
                    + "i.TipoInventario, "
                    + "i.IdLocal, "
                    + "l.DescricaoPrincipal, "
                    + "i.Responsavel, "
                    + "i.DataInicio, "
                    + "i.HorarioInicio, "
                    + "i.DataTermino, "
                    + "i.HorarioTermino, "
                    + "i.Observacao "
                    + "FROM INVENTARIO_ARMAS_EPI AS i "
                    + "INNER JOIN LOCAL_ARMAZENAMENTO_ARMAS_EPI AS l "
                    + "ON i.IdLocal=l.IdLocal "
                    + "WHERE i.IdLanc='" + jIDPesq.getText() + "'");
            while (conecta.rs.next()) {
                InventarioArmaEPI pInventaEPI = new InventarioArmaEPI();
                pInventaEPI.setIdLanc(conecta.rs.getInt("IdLanc"));
                pInventaEPI.setTipoProduto(conecta.rs.getString("TipoProduto"));
                pInventaEPI.setStatusLanc(conecta.rs.getString("StatusLanc"));
                pInventaEPI.setTipoInventario(conecta.rs.getString("TipoInventario"));
                pInventaEPI.setIdLocal(conecta.rs.getInt("IdLocal"));
                pInventaEPI.setNomeLocalArmazenamento(conecta.rs.getString("DescricaoPrincipal"));
                pInventaEPI.setResponsavel(conecta.rs.getString("Responsavel"));
                pInventaEPI.setDataInicio(conecta.rs.getDate("DataInicio"));
                pInventaEPI.setHorarioInicio(conecta.rs.getString("HorarioInicio"));
                pInventaEPI.setDataTermino(conecta.rs.getDate("DataTermino"));
                pInventaEPI.setHorarioTermino(conecta.rs.getString("HorarioTermino"));
                pInventaEPI.setObservacao(conecta.rs.getString("Observacao"));
                LISTAR_inventario.add(pInventaEPI);
                pTOTAL_inve++;
            }
            return LISTAR_inventario;
        } catch (SQLException ex) {
            Logger.getLogger(ControleInventarioArmasEPIs.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public InventarioArmaEPI pVERIFICAR_CODIGO_invent(InventarioArmaEPI objEquipa) {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdLanc "
                    + "FROM ITENS_INVENTARIO_ARMAS_EPI "
                    + "WHERE IdLanc='" + jIdLanc.getText() + "'");
            conecta.rs.first();
            pCODIGO_inventario = conecta.rs.getString("IdLanc");
        } catch (SQLException ex) {
        }
        conecta.desconecta();
        return objEquipa;
    }

    public InventarioArmaEPI pPESQUISAR_CODIGO_invent(InventarioArmaEPI objEquipa) {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdLanc "
                    + "FROM INVENTARIO_ARMAS_EPI ");
            conecta.rs.last();
            jIdLanc.setText(String.valueOf(conecta.rs.getInt("IdLanc")));
        } catch (SQLException ex) {
        }
        conecta.desconecta();
        return objEquipa;
    }

    //---------------------------------------------- PRODUTOS ---------------------------------------------------------------------------
    public InventarioArmaEPI incluirItensInventarioAE(InventarioArmaEPI objInventEstoque) {
        if (jRBtArmas.isSelected()) {
            pBUSCAR_arma(objInventEstoque.getNomeProduto());
        } else if (jRBtEPIs.isSelected()) {
            pBUSCAR_epi(objInventEstoque.getNomeProduto());
        }
        pBUSCAR_LOCAL_armazenamento(objInventEstoque.getNomeLocalArmazenamento());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_INVENTARIO_ARMAS_EPI (IdLanc,IdProd,QtdItem,ValorCusto,IdLocal,Lote,DataLote,TipoProduto,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objInventEstoque.getIdLanc());
            pst.setInt(2, codProd);
            pst.setFloat(3, objInventEstoque.getQtdItem());
            pst.setFloat(4, objInventEstoque.getValorCusto());
            pst.setInt(5, codLocal);
            pst.setString(6, objInventEstoque.getLote());
            if (objInventEstoque.getDataLote() != null) {
                pst.setTimestamp(7, new java.sql.Timestamp(objInventEstoque.getDataLote().getTime()));
            } else {
                pst.setDate(7, null);
            }
            pst.setInt(8, objInventEstoque.getTipoArmaEPI());
            pst.setString(9, objInventEstoque.getUsuarioInsert());
            pst.setString(10, objInventEstoque.getDataInsert());
            pst.setString(11, objInventEstoque.getHorarioInsert());
            pst.execute();
            pRESPOSTA_inv = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_inv = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objInventEstoque;
    }

    public InventarioArmaEPI alterarItensInventarioAE(InventarioArmaEPI objInventEstoque) {
        if (jRBtArmas.isSelected()) {
            pBUSCAR_arma(objInventEstoque.getNomeProduto());
        } else if (jRBtEPIs.isSelected()) {
            pBUSCAR_epi(objInventEstoque.getNomeProduto());
        }
        pBUSCAR_LOCAL_armazenamento(objInventEstoque.getNomeLocalArmazenamento());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_INVENTARIO_ARMAS_EPI SET IdLanc=?,IdProd=?,QtdItem=?,ValorCusto=?,IdLocal=?,Lote=?,DataLote=?,TipoProduto=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objInventEstoque.getIdItem() + "'");
            pst.setInt(1, objInventEstoque.getIdLanc());
            pst.setInt(2, codProd);
            pst.setFloat(3, objInventEstoque.getQtdItem());
            pst.setFloat(4, objInventEstoque.getValorCusto());
            pst.setInt(5, codLocal);
            pst.setString(6, objInventEstoque.getLote());
            if (objInventEstoque.getDataLote() != null) {
                pst.setTimestamp(7, new java.sql.Timestamp(objInventEstoque.getDataLote().getTime()));
            } else {
                pst.setDate(7, null);
            }
            pst.setInt(8, objInventEstoque.getTipoArmaEPI());
            pst.setString(9, objInventEstoque.getUsuarioUp());
            pst.setString(10, objInventEstoque.getDataUp());
            pst.setString(11, objInventEstoque.getHorarioUp());
            pst.executeUpdate();
            pRESPOSTA_inv = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_inv = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objInventEstoque;
    }

    public InventarioArmaEPI excluirItensInventarioAE(InventarioArmaEPI objInventEstoque) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_INVENTARIO_ARMAS_EPI WHERE IdItem='" + objInventEstoque.getIdItem() + "'");
            pst.executeUpdate();
            pRESPOSTA_inv = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_inv = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objInventEstoque;
    }

    public void pBUSCAR_arma(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdArma, "
                    + "DescricaoArma "
                    + "FROM ARMAS "
                    + "WHERE DescricaoArma='" + nome + "'");
            conecta.rs.first();
            codProd = conecta.rs.getInt("IdArma");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (ARMAS) a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void pBUSCAR_epi(String descricao) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdEquipamento, "
                    + "DescricaoEquipamento "
                    + "FROM EQUIPAMENTOS_SEGURANCA_EPI "
                    + "WHERE DescricaoEquipamento='" + descricao + "'");
            conecta.rs.first();
            codProd = conecta.rs.getInt("IdEquipamento");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (EQUIPAMENTOS_SEGURANCA_EPI) a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public List<InventarioArmaEPI> pPESQUISAR_ITENS_INVENTARIO_selecionado() throws Exception {
        pTOTAL_inve = 0;
        conecta.abrirConexao();
        List<InventarioArmaEPI> LISTAR_inventario = new ArrayList<InventarioArmaEPI>();
        try {
            conecta.executaSQL("SELECT "
                    + "i.IdLanc, "
                    + "i.IdItem, "
                    + "i.IdProd, "
                    + "a.IdArma, "
                    + "a.DescricaoArma, "
                    + "a.UnidadeArma, "
                    + "a.QtdItem "
                    + "FROM ITENS_INVENTARIO_ARMAS_EPI AS i "
                    + "INNER JOIN ARMAS AS a "
                    + "ON i.IdProd=a.IdArma "
                    + "WHERE i.IdLanc='" + jIdLanc.getText() + "' "
                    + "ORDER BY a.DescricaoArma");
            while (conecta.rs.next()) {
                InventarioArmaEPI pInventaEPI = new InventarioArmaEPI();
                pInventaEPI.setIdItem(conecta.rs.getInt("IdItem"));
                pInventaEPI.setIdProduto(conecta.rs.getInt("IdProd"));
                pInventaEPI.setNomeProduto(conecta.rs.getString("DescricaoArma"));
                pInventaEPI.setUnidade(conecta.rs.getString("UnidadeArma"));
                pInventaEPI.setQtdItem(conecta.rs.getInt("QtdItem"));
                LISTAR_inventario.add(pInventaEPI);
                pTOTAL_inve++;
            }
            return LISTAR_inventario;
        } catch (SQLException ex) {
            Logger.getLogger(ControleInventarioArmasEPIs.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public InventarioArmaEPI PESQUISAR_codigo(InventarioArmaEPI objInventEstoque) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "i.IdLanc, "
                    + "i.IdProd "
                    + "FROM ITENS_INVENTARIO_ARMAS_EPI AS i "
                    + "WHERE i.IdProd='" + jIdProduto.getText() + "' "
                    + "AND i.IdLanc='" + jIdLanc.getText() + "'");
            conecta.rs.first();
            objInventEstoque.setIdProduto(conecta.rs.getInt("IdProd"));
            objInventEstoque.setIdLanc(conecta.rs.getInt("IdLanc"));
        } catch (Exception e) {
        }
        conecta.desconecta();
        return objInventEstoque;
    }

    public InventarioArmaEPI PESQUISA_inventario(InventarioArmaEPI objInventEstoque) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "i.IdLocal, "
                    + "i.TipoInventario "
                    + "FROM INVENTARIO_ARMAS_EPI AS i "
                    + "WHERE i.TipoInventario='" + jComboBoxTipoInventario.getSelectedItem() + "'");
            conecta.rs.first();
            objInventEstoque.setTipoInventario(conecta.rs.getString("TipoInventario"));
            objInventEstoque.setIdLocal(conecta.rs.getInt("IdLocal"));
        } catch (Exception e) {
        }
        conecta.desconecta();
        return objInventEstoque;
    }
}
