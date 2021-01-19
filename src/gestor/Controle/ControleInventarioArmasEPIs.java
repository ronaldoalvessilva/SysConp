/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.InventarioArmaEPI;
import gestor.Modelo.InventarioEstoque;
import static gestor.Visao.TelaInventarioArmasEquipamentosEPI.dataFinal;
import static gestor.Visao.TelaInventarioArmasEquipamentosEPI.dataInicial;
import static gestor.Visao.TelaInventarioArmasEquipamentosEPI.jIDPesq;
import static gestor.Visao.TelaInventarioArmasEquipamentosEPI.jIdLanc;
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

    public InventarioArmaEPI incluirInventarioAC(InventarioArmaEPI objInventEstoque) {
        buscarLocalArmazenamento(objInventEstoque.getNomeLocalArmazenamento());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO INVENTARIO_AC (TipoProduto,StatusLanc,TipoInventario,IdLocal,Responsavel,DataInicio,DataTermino,HorarioInicio,HorarioTermino,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
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

    public InventarioArmaEPI alterarInventarioAC(InventarioArmaEPI objInventEstoque) {
        buscarLocalArmazenamento(objInventEstoque.getNomeLocalArmazenamento());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE INVENTARIO_AC SET TipoProduto=?,StatusLanc=?,TipoInventario=?,IdLocal=?,Responsavel=?,DataInicio=?,DataTermino=?,HorarioInicio=?,HorarioTermino=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdLanc='" + objInventEstoque.getIdLanc() + "'");
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

    public InventarioArmaEPI excluirInventarioAC(InventarioArmaEPI objInventEstoque) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM INVENTARIO_AC WHERE IdLanc='" + objInventEstoque.getIdLanc() + "'");
            pst.executeUpdate();
            pRESPOSTA_inv = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_inv = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objInventEstoque;
    }

    public InventarioArmaEPI efetivarInventarioAC(InventarioArmaEPI objInventEstoque) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE INVENTARIO_AC SET StatusLanc=?,DataTermino=?,HorarioTermino=? WHERE IdLanc='" + objInventEstoque.getIdLanc() + "'");
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

    public void buscarLocalArmazenamento(String nomeLocal) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * "
                    + "FROM LOCAL_ARMAZENAMENTO_AC "
                    + "WHERE DescricaoLocal='" + nomeLocal + "'");
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
                    + "IdLanc,TipoProduto,DataInicio, "
                    + "StatusLanc,Observacao "
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
                    + "IdLanc,TipoProduto,DataInicio, "
                    + "StatusLanc,Observacao "
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
                    + "IdLanc,TipoProduto,DataInicio, "
                    + "StatusLanc,Observacao "
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
                    + "IdLanc,TipoProduto,DataInicio, "
                    + "StatusLanc,Observacao "
                    + "FROM INVENTARIO_ARMAS_EPI "
                    + "WHERE IdLanc='" + jIDPesq.getText() + "'");
            while (conecta.rs.next()) {
                InventarioArmaEPI pInventaEPI = new InventarioArmaEPI();
                pInventaEPI.setIdLanc(conecta.rs.getInt("IdLanc"));
                pInventaEPI.setTipoProduto(conecta.rs.getString("TipoProduto"));
                pInventaEPI.setStatusLanc(conecta.rs.getString("StatusLanc"));
                pInventaEPI.setTipoInventario(conecta.rs.getString("TipoInventario"));
                pInventaEPI.setIdLocal(conecta.rs.getInt("IdLocal"));
                pInventaEPI.setNomeLocalArmazenamento(conecta.rs.getString("DescricaoLocal"));
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

    //---------------------------------------------- PRODUTOS ---------------------------------------------------------------------------
    public InventarioArmaEPI incluirItensInventarioAC(InventarioArmaEPI objInventEstoque) {
        buscarProduto(objInventEstoque.getNomeProduto());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_INVENTARIO_AC (IdLanc,IdProd,QtdItem,ValorCusto,IdLocal,Lote,DataLote,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objInventEstoque.getIdLanc());
            pst.setInt(2, codProd);
            pst.setFloat(3, objInventEstoque.getQtdItem());
            pst.setFloat(4, objInventEstoque.getValorCusto());
            pst.setInt(5, objInventEstoque.getIdLocal());
            pst.setString(6, objInventEstoque.getLote());
            if (objInventEstoque.getDataLote() != null) {
                pst.setTimestamp(7, new java.sql.Timestamp(objInventEstoque.getDataLote().getTime()));
            } else {
                pst.setDate(7, null);
            }
            pst.setString(8, objInventEstoque.getUsuarioInsert());
            pst.setString(9, objInventEstoque.getDataInsert());
            pst.setString(10, objInventEstoque.getHorarioInsert());
            pst.execute();
            pRESPOSTA_inv = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_inv = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objInventEstoque;
    }

    public InventarioArmaEPI alterarItensInventarioAC(InventarioArmaEPI objInventEstoque) {
        buscarProduto(objInventEstoque.getNomeProduto());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_INVENTARIO_AC SET IdLanc=?,IdProd=?,QtdItem=?,ValorCusto=?,IdLocal=?,Lote=?,DataLote=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objInventEstoque.getIdItem() + "'");
            pst.setInt(1, objInventEstoque.getIdLanc());
            pst.setInt(2, codProd);
            pst.setFloat(3, objInventEstoque.getQtdItem());
            pst.setFloat(4, objInventEstoque.getValorCusto());
            pst.setInt(5, objInventEstoque.getIdLocal());
            pst.setString(6, objInventEstoque.getLote());
            if (objInventEstoque.getDataLote() != null) {
                pst.setTimestamp(7, new java.sql.Timestamp(objInventEstoque.getDataLote().getTime()));
            } else {
                pst.setDate(7, null);
            }
            pst.setString(8, objInventEstoque.getUsuarioUp());
            pst.setString(9, objInventEstoque.getDataUp());
            pst.setString(10, objInventEstoque.getHorarioUp());
            pst.executeUpdate();
            pRESPOSTA_inv = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_inv = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objInventEstoque;
    }

    public InventarioArmaEPI excluirItensInventarioAC(InventarioArmaEPI objInventEstoque) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_INVENTARIO_AC WHERE IdItem='" + objInventEstoque.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objInventEstoque;
    }

    public void buscarProduto(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRODUTOS_AC WHERE DescricaoProd='" + nome + "'");
            conecta.rs.first();
            codProd = conecta.rs.getInt("IdProd");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (PRODUTO) a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public List<InventarioArmaEPI> pPESQUISAR_ITENS_INVENTARIO_selecionado() throws Exception {
        pTOTAL_inve = 0;
        conecta.abrirConexao();
        List<InventarioArmaEPI> LISTAR_inventario = new ArrayList<InventarioArmaEPI>();
        try {
            conecta.executaSQL("SELECT "
                    + ""
                    + "FROM ITENS_INVENTARIO_AC "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON ITENS_INVENTARIO_AC.IdProd=PRODUTOS_AC.IdProd "
                    + "WHERE IdLanc='" + jIdLanc.getText() + "' "
                    + "ORDER BY DescricaoProd");
            while (conecta.rs.next()) {
                InventarioArmaEPI pInventaEPI = new InventarioArmaEPI();
                pInventaEPI.setIdItem(conecta.rs.getInt("IdItem"));
                pInventaEPI.setIdProduto(conecta.rs.getInt("IdProd"));
                pInventaEPI.setNomeProduto(conecta.rs.getString("NomeProduto"));
                pInventaEPI.setUnidade(conecta.rs.getString("Unidade"));
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
}
