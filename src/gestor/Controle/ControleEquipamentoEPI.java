/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EquipamentoSegurancaEPI;
import static gestor.Visao.TelaQRCode_epi.pNUMERO_EQUIP_epi;
import static gestor.Visao.TelaEquipamentosEPI.jCodigoEquipamento;
import static gestor.Visao.TelaEquipamentosEPI.jPesqNomeEquipamento;
import static gestor.Visao.TelaEquipamentosEPI.pID_equipamento;
import static gestor.Visao.TelaQRCode_epi.pCODIGO_QRCode;
import static gestor.Visao.TelaCodigoBarraEpi.pCODIGO_BArra;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static gestor.Visao.TelaEquipamentosEPI.pRESPOSTA_epi;
import static gestor.Visao.TelaEquipamentosEPI.pTOTAL_epi;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static gestor.Visao.TelaCodigoBarraEpi.pNUMERO_equipamento;

/**
 *
 * @author ronaldo.silva7
 */
public class ControleEquipamentoEPI {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EquipamentoSegurancaEPI objEquipa = new EquipamentoSegurancaEPI();

    public EquipamentoSegurancaEPI incluirEQUIPAMENTO_epi(EquipamentoSegurancaEPI objEquipa) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO EQUIPAMENTOS_SEGURANCA_EPI (FotoEquipamento,StatusEquipamento,DataCadastroEquipamento,DescricaoEquipamento,MarcaEquipamento,ModeloEquipamento,ComprimentoEquipamento,TipoMaterialEquipamento,PesoEquipamento,CorEquipamento,Observacao,NumeroCodigoBarras,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setBytes(1, objEquipa.getFotoEquipamento());
            pst.setString(2, objEquipa.getStatusEquipamento());
            pst.setTimestamp(3, new java.sql.Timestamp(objEquipa.getDataCadastroEquipamento().getTime()));
            pst.setString(4, objEquipa.getDescricaoEquipamento());
            pst.setString(5, objEquipa.getMarcaEquipamento());
            pst.setString(6, objEquipa.getModeloEquipamento());
            pst.setString(7, objEquipa.getComprimentoEquipamento());
            pst.setString(8, objEquipa.getTipoMaterialEquipamento());
            pst.setFloat(9, objEquipa.getPesoEquipamento());
            pst.setString(10, objEquipa.getCorEquipamento());
            pst.setString(11, objEquipa.getObservacao());
            pst.setString(12, objEquipa.getNumeroCodigoBarras());
            pst.setString(13, objEquipa.getUsuarioInsert());
            pst.setString(14, objEquipa.getDataInsert());
            pst.setString(15, objEquipa.getHorarioInsert());
            pst.execute();
            pRESPOSTA_epi = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_epi = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEquipa;
    }

    public EquipamentoSegurancaEPI alterarEQUIPAMENTO_epi(EquipamentoSegurancaEPI objEquipa) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE EQUIPAMENTOS_SEGURANCA_EPI SET FotoEquipamento=?,StatusEquipamento=?,DataCadastroEquipamento=?,DescricaoEquipamento=?,MarcaEquipamento=?,ModeloEquipamento=?,ComprimentoEquipamento=?,TipoMaterialEquipamento=?,PesoEquipamento=?,CorEquipamento=?,Observacao=?,NumeroCodigoBarras=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdEquipamento='" + objEquipa.getIdEquipamento() + "'");
            pst.setBytes(1, objEquipa.getFotoEquipamento());
            pst.setString(2, objEquipa.getStatusEquipamento());
            pst.setTimestamp(3, new java.sql.Timestamp(objEquipa.getDataCadastroEquipamento().getTime()));
            pst.setString(4, objEquipa.getDescricaoEquipamento());
            pst.setString(5, objEquipa.getMarcaEquipamento());
            pst.setString(6, objEquipa.getModeloEquipamento());
            pst.setString(7, objEquipa.getComprimentoEquipamento());
            pst.setString(8, objEquipa.getTipoMaterialEquipamento());
            pst.setFloat(9, objEquipa.getPesoEquipamento());
            pst.setString(10, objEquipa.getCorEquipamento());
            pst.setString(11, objEquipa.getObservacao());
            pst.setString(12, objEquipa.getNumeroCodigoBarras());
            pst.setString(13, objEquipa.getUsuarioUp());
            pst.setString(14, objEquipa.getDataUp());
            pst.setString(15, objEquipa.getHorarioUp());
            pst.executeUpdate();
            pRESPOSTA_epi = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_epi = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEquipa;
    }

    public EquipamentoSegurancaEPI excluirEQUIPAMENTO_epi(EquipamentoSegurancaEPI objEquipa) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM EQUIPAMENTOS_SEGURANCA_EPI WHERE IdEquipamento='" + objEquipa.getIdEquipamento() + "'");
            pst.executeUpdate();
            pRESPOSTA_epi = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_epi = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEquipa;
    }

    public List<EquipamentoSegurancaEPI> TODOS_read() throws Exception {
        pTOTAL_epi = 0;
        conecta.abrirConexao();
        List<EquipamentoSegurancaEPI> listaGruposArmas = new ArrayList<EquipamentoSegurancaEPI>();
        try {
            conecta.executaSQL("SELECT IdEquipamento,StatusEquipamento, "
                    + "DataCadastroEquipamento,DescricaoEquipamento, "
                    + "MarcaEquipamento,ModeloEquipamento,ComprimentoEquipamento, "
                    + "TipoMaterialEquipamento,PesoEquipamento, "
                    + "CorEquipamento,Observacao "
                    + "FROM EQUIPAMENTOS_SEGURANCA_EPI "
                    + "ORDER BY DescricaoEquipamento");
            while (conecta.rs.next()) {
                EquipamentoSegurancaEPI objEquipa = new EquipamentoSegurancaEPI();
                objEquipa.setIdEquipamento(conecta.rs.getInt("IdEquipamento"));
                objEquipa.setStatusEquipamento(conecta.rs.getString("StatusEquipamento"));
                objEquipa.setDataCadastroEquipamento(conecta.rs.getDate("DataCadastroEquipamento"));
                objEquipa.setDescricaoEquipamento(conecta.rs.getString("DescricaoEquipamento"));
                objEquipa.setMarcaEquipamento(conecta.rs.getString("MarcaEquipamento"));
                objEquipa.setModeloEquipamento(conecta.rs.getString("ModeloEquipamento"));
                objEquipa.setComprimentoEquipamento(conecta.rs.getString("ComprimentoEquipamento"));
                objEquipa.setTipoMaterialEquipamento(conecta.rs.getString("TipoMaterialEquipamento"));
                objEquipa.setPesoEquipamento(conecta.rs.getFloat("PesoEquipamento"));
                objEquipa.setCorEquipamento(conecta.rs.getString("CorEquipamento"));
                objEquipa.setObservacao(conecta.rs.getString("Observacao"));
                listaGruposArmas.add(objEquipa);
                pTOTAL_epi++;
            }
            return listaGruposArmas;
        } catch (SQLException ex) {
            Logger.getLogger(ControleGrupoArmas.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public List<EquipamentoSegurancaEPI> pNOME_EQUIPAMENTO_read() throws Exception {
        pTOTAL_epi = 0;
        conecta.abrirConexao();
        List<EquipamentoSegurancaEPI> listaGruposArmas = new ArrayList<EquipamentoSegurancaEPI>();
        try {
            conecta.executaSQL("SELECT IdEquipamento,StatusEquipamento, "
                    + "DataCadastroEquipamento,DescricaoEquipamento, "
                    + "MarcaEquipamento,ModeloEquipamento,ComprimentoEquipamento, "
                    + "TipoMaterialEquipamento,PesoEquipamento, "
                    + "CorEquipamento,Observacao "
                    + "FROM EQUIPAMENTOS_SEGURANCA_EPI "
                    + "WHERE DescricaoEquipamento LIKE'%" + jPesqNomeEquipamento.getText() + "%' ");
            while (conecta.rs.next()) {
                EquipamentoSegurancaEPI objEquipa = new EquipamentoSegurancaEPI();
                objEquipa.setIdEquipamento(conecta.rs.getInt("IdEquipamento"));
                objEquipa.setStatusEquipamento(conecta.rs.getString("StatusEquipamento"));
                objEquipa.setDataCadastroEquipamento(conecta.rs.getDate("DataCadastroEquipamento"));
                objEquipa.setDescricaoEquipamento(conecta.rs.getString("DescricaoEquipamento"));
                objEquipa.setMarcaEquipamento(conecta.rs.getString("MarcaEquipamento"));
                objEquipa.setModeloEquipamento(conecta.rs.getString("ModeloEquipamento"));
                objEquipa.setComprimentoEquipamento(conecta.rs.getString("ComprimentoEquipamento"));
                objEquipa.setTipoMaterialEquipamento(conecta.rs.getString("TipoMaterialEquipamento"));
                objEquipa.setPesoEquipamento(conecta.rs.getFloat("PesoEquipamento"));
                objEquipa.setCorEquipamento(conecta.rs.getString("CorEquipamento"));
                objEquipa.setObservacao(conecta.rs.getString("Observacao"));
                listaGruposArmas.add(objEquipa);
                pTOTAL_epi++;
            }
            return listaGruposArmas;
        } catch (SQLException ex) {
            Logger.getLogger(ControleGrupoArmas.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public List<EquipamentoSegurancaEPI> pCODIGO_EQUIPAMENTO_read() throws Exception {
        pTOTAL_epi = 0;
        conecta.abrirConexao();
        List<EquipamentoSegurancaEPI> listaGruposArmas = new ArrayList<EquipamentoSegurancaEPI>();
        try {
            conecta.executaSQL("SELECT "
                    + "EQUIPAMENTOS_SEGURANCA_EPI.IdEquipamento, "
                    + "EQUIPAMENTOS_SEGURANCA_EPI.StatusEquipamento, "
                    + "EQUIPAMENTOS_SEGURANCA_EPI.DataCadastroEquipamento, "
                    + "EQUIPAMENTOS_SEGURANCA_EPI.DescricaoEquipamento, "
                    + "EQUIPAMENTOS_SEGURANCA_EPI.NumeroCodigoBarras, "
                    + "EQUIPAMENTOS_SEGURANCA_EPI.MarcaEquipamento, "
                    + "EQUIPAMENTOS_SEGURANCA_EPI.ModeloEquipamento, "
                    + "EQUIPAMENTOS_SEGURANCA_EPI.ComprimentoEquipamento, "
                    + "EQUIPAMENTOS_SEGURANCA_EPI.TipoMaterialEquipamento, "
                    + "EQUIPAMENTOS_SEGURANCA_EPI.PesoEquipamento, "
                    + "EQUIPAMENTOS_SEGURANCA_EPI.CorEquipamento, "
                    + "EQUIPAMENTOS_SEGURANCA_EPI.Observacao, "
                    + "EQUIPAMENTOS_SEGURANCA_EPI.FotoEquipamento, "
                    + "EQUIPAMENTOS_SEGURANCA_EPI.QRCode, "
                    + "EQUIPAMENTOS_SEGURANCA_EPI.CodigoBarras "
                    + "FROM EQUIPAMENTOS_SEGURANCA_EPI "
                    + "WHERE EQUIPAMENTOS_SEGURANCA_EPI.IdEquipamento='" + pID_equipamento.toString().trim() + "' ");
            while (conecta.rs.next()) {
                EquipamentoSegurancaEPI objEquipa = new EquipamentoSegurancaEPI();
                objEquipa.setIdEquipamento(conecta.rs.getInt("IdEquipamento"));
                objEquipa.setStatusEquipamento(conecta.rs.getString("StatusEquipamento"));
                objEquipa.setDataCadastroEquipamento(conecta.rs.getDate("DataCadastroEquipamento"));
                objEquipa.setNumeroCodigoBarras(conecta.rs.getString("NumeroCodigoBarras"));
                objEquipa.setDescricaoEquipamento(conecta.rs.getString("DescricaoEquipamento"));
                objEquipa.setMarcaEquipamento(conecta.rs.getString("MarcaEquipamento"));
                objEquipa.setModeloEquipamento(conecta.rs.getString("ModeloEquipamento"));
                objEquipa.setComprimentoEquipamento(conecta.rs.getString("ComprimentoEquipamento"));
                objEquipa.setTipoMaterialEquipamento(conecta.rs.getString("TipoMaterialEquipamento"));
                objEquipa.setPesoEquipamento(conecta.rs.getFloat("PesoEquipamento"));
                objEquipa.setCorEquipamento(conecta.rs.getString("CorEquipamento"));
                objEquipa.setObservacao(conecta.rs.getString("Observacao"));
                objEquipa.setFotoEquipamento(conecta.rs.getBytes("FotoEquipamento"));
                objEquipa.setqRCodeEquipamento(conecta.rs.getBytes("QRCode"));
                objEquipa.setCodigoBarra(conecta.rs.getBytes("CodigoBarras"));
                listaGruposArmas.add(objEquipa);
                pTOTAL_epi++;
            }
            return listaGruposArmas;
        } catch (SQLException ex) {
            Logger.getLogger(ControleGrupoArmas.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public EquipamentoSegurancaEPI pBUSCAR_codigo(EquipamentoSegurancaEPI objEquipa) {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdEquipamento "
                    + "FROM EQUIPAMENTOS_SEGURANCA_EPI");
            conecta.rs.last();
            jCodigoEquipamento.setText(String.valueOf(conecta.rs.getInt("IdEquipamento")));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ENCONTRAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEquipa;
    }

    //------------------------------------------ QRCODE ---------------------------------------------------------
    public EquipamentoSegurancaEPI incluirQRCode(EquipamentoSegurancaEPI objEquipa) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO QRCODE_EPI (IdEquipamento,TextoQRCode,QRCode) VALUES(?,?,?)");
            pst.setInt(1, objEquipa.getIdEquipamento());
            pst.setString(2, objEquipa.getTextoQRCode());
            pst.setBytes(3, objEquipa.getqRCodeEquipamento());
            pst.execute();
            pRESPOSTA_epi = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_epi = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEquipa;
    }

    public EquipamentoSegurancaEPI alterarQRCode(EquipamentoSegurancaEPI objEquipa) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE QRCODE_EPI SET TextoQRCode=?,QRCode=? WHERE IdEquipamento='" + objEquipa.getIdEquipamento() + "'");
            pst.setString(1, objEquipa.getTextoQRCode());
            pst.setBytes(2, objEquipa.getqRCodeEquipamento());
            pst.executeUpdate();
            pRESPOSTA_epi = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_epi = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEquipa;
    }

    public EquipamentoSegurancaEPI excluirQRCode(EquipamentoSegurancaEPI objArma) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM QRCODE_EPI WHERE IdEquipamento='" + objArma.getIdEquipamento() + "'");
            pst.executeUpdate();
            pRESPOSTA_epi = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_epi = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objArma;
    }

    public EquipamentoSegurancaEPI alterarQRCodeEpi(EquipamentoSegurancaEPI objEquipa) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE EQUIPAMENTOS_SEGURANCA_EPI SET QRCode=? WHERE IdEquipamento='" + objEquipa.getIdEquipamento() + "'");
            pst.setBytes(1, objEquipa.getqRCodeEquipamento());
            pst.executeUpdate();
            pRESPOSTA_epi = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_epi = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEquipa;
    }

    public EquipamentoSegurancaEPI pBUSCAR_QRCode_codigo(EquipamentoSegurancaEPI objEquipa) {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdQrCodeEpi "
                    + "FROM QRCODE_EPI");
            conecta.rs.last();
            pCODIGO_QRCode = conecta.rs.getInt("IdQrCodeEpi");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ENCONTRAR o código do QRCode.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEquipa;
    }

     public EquipamentoSegurancaEPI pVERIFICAR_QRCode_codigo(EquipamentoSegurancaEPI objEquipa) {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdEquipamento "
                    + "FROM QRCODE_EPI "
                    + "WHERE IdEquipamento='" + jCodigoEquipamento.getText() + "'");
            conecta.rs.first();
            pNUMERO_EQUIP_epi = conecta.rs.getString("IdEquipamento");
        } catch (SQLException ex) {            
        }
        conecta.desconecta();
        return objEquipa;
    }
    
    public List<EquipamentoSegurancaEPI> pPESQUISAR_QRCode_read() throws Exception {
        pTOTAL_epi = 0;
        conecta.abrirConexao();
        List<EquipamentoSegurancaEPI> LISTAR_ARAMAS_codigo = new ArrayList<EquipamentoSegurancaEPI>();
        try {
            conecta.executaSQL("SELECT "
                    + "IdEquipamento, "
                    + "TextoQRCode, "
                    + "QRCode "
                    + "FROM QRCODE_EPI "
                    + "WHERE IdEquipamento='" + jCodigoEquipamento.getText().toString().trim() + "'");
            while (conecta.rs.next()) {
                EquipamentoSegurancaEPI pEquipa = new EquipamentoSegurancaEPI();
                pEquipa.setIdEquipamento(conecta.rs.getInt("IdEquipamento"));
                pEquipa.setTextoQRCode(conecta.rs.getString("TextoQRCode"));
                pEquipa.setqRCodeEquipamento(conecta.rs.getBytes("QRCode"));
                LISTAR_ARAMAS_codigo.add(pEquipa);
                pTOTAL_epi++;
            }
            return LISTAR_ARAMAS_codigo;
        } catch (SQLException ex) {
            Logger.getLogger(ControleGrupoArmas.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    //---------------------------------------- CÓDIGO DE BARRAS ------------------------------------------------
    public EquipamentoSegurancaEPI incluirCODIGO_barra(EquipamentoSegurancaEPI objEquipa) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO CODIGO_BARRA_EPI (IdEquipamento,NumeroSerie,CodigoBarra) VALUES(?,?,?)");
            pst.setInt(1, objEquipa.getIdEquipamento());
            pst.setString(2, objEquipa.getNumeroCodigoBarras());
            pst.setBytes(3, objEquipa.getCodigoBarra());
            pst.execute();
            pRESPOSTA_epi = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_epi = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEquipa;
    }

    public EquipamentoSegurancaEPI alterarCODIGO_barra(EquipamentoSegurancaEPI objEquipa) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE CODIGO_BARRA_EPI SET NumeroSerie=?,CodigoBarra=? WHERE IdEquipamento='" + objEquipa.getIdEquipamento() + "'");
            pst.setString(1, objEquipa.getNumeroCodigoBarras());
            pst.setBytes(2, objEquipa.getCodigoBarra());
            pst.executeUpdate();
            pRESPOSTA_epi = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_epi = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEquipa;
    }

    public EquipamentoSegurancaEPI excluirCODIGO_barra(EquipamentoSegurancaEPI objEquipa) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM CODIGO_BARRA_EPI WHERE IdEquipamento='" + objEquipa.getIdEquipamento() + "'");
            pst.executeUpdate();
            pRESPOSTA_epi = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_epi = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEquipa;
    }

    public EquipamentoSegurancaEPI alterarCodigoBarraEpi(EquipamentoSegurancaEPI objEquipa) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE EQUIPAMENTOS_SEGURANCA_EPI SET CodigoBarras=? WHERE IdEquipamento='" + objEquipa.getIdEquipamento() + "'");
            pst.setBytes(1, objEquipa.getCodigoBarra());
            pst.executeUpdate();
            pRESPOSTA_epi = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_epi = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEquipa;
    }

    public EquipamentoSegurancaEPI pBUSCAR_CODIGO_barra(EquipamentoSegurancaEPI objEquipa) {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdCodigoBarraEpi "
                    + "FROM CODIGO_BARRA_EPI");
            conecta.rs.last();
            pCODIGO_BArra = conecta.rs.getInt("IdCodigoBarraEpi");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ENCONTRAR o código de barra.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEquipa;
    }

    public EquipamentoSegurancaEPI pVERIFICAR_CODIGO_barra(EquipamentoSegurancaEPI objEquipa) {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdEquipamento "
                    + "FROM CODIGO_BARRA_EPI "
                    + "WHERE IdEquipamento='" + jCodigoEquipamento.getText() + "'");
            conecta.rs.first();
            pNUMERO_equipamento = conecta.rs.getString("IdEquipamento");
        } catch (SQLException ex) {            
        }
        conecta.desconecta();
        return objEquipa;
    }

    public List<EquipamentoSegurancaEPI> pPESQUISAR_CODIGO_barras_read() throws Exception {
        pTOTAL_epi = 0;
        conecta.abrirConexao();
        List<EquipamentoSegurancaEPI> LISTAR_CODIGO_barra = new ArrayList<EquipamentoSegurancaEPI>();
        try {
            conecta.executaSQL("SELECT "
                    + "EQUIPAMENTOS_SEGURANCA_EPI.IdEquipamento, "
                    + "EQUIPAMENTOS_SEGURANCA_EPI.NumeroCodigoBarras, "
                    + "EQUIPAMENTOS_SEGURANCA_EPI.DescricaoEquipamento, "
                    + "EQUIPAMENTOS_SEGURANCA_EPI.CodigoBarras "
                    + "FROM CODIGO_BARRA_EPI "
                    + "INNER JOIN EQUIPAMENTOS_SEGURANCA_EPI "
                    + "ON CODIGO_BARRA_EPI.IdEquipamento=EQUIPAMENTOS_SEGURANCA_EPI.IdEquipamento "
                    + "WHERE EQUIPAMENTOS_SEGURANCA_EPI.IdEquipamento='" + jCodigoEquipamento.getText().toString().trim() + "'");
            while (conecta.rs.next()) {
                EquipamentoSegurancaEPI pEquipa = new EquipamentoSegurancaEPI();
                pEquipa.setIdEquipamento(conecta.rs.getInt("IdEquipamento"));
                pEquipa.setNumeroCodigoBarras(conecta.rs.getString("NumeroCodigoBarras"));
                pEquipa.setDescricaoEquipamento(conecta.rs.getString("DescricaoEquipamento"));
                pEquipa.setCodigoBarra(conecta.rs.getBytes("CodigoBarras"));
                LISTAR_CODIGO_barra.add(pEquipa);
                pTOTAL_epi++;
            }
            return LISTAR_CODIGO_barra;
        } catch (SQLException ex) {
            Logger.getLogger(ControleGrupoArmas.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

}
