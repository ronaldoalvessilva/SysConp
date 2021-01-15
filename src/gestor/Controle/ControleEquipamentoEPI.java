/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EquipamentoSegurancaEPI;
import static gestor.Visao.TelaEquipamentosEPI.jCodigoEquipamento;
import static gestor.Visao.TelaEquipamentosEPI.jPesqNomeEquipamento;
import static gestor.Visao.TelaEquipamentosEPI.pID_equipamento;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static gestor.Visao.TelaEquipamentosEPI.pRESPOSTA_epi;
import static gestor.Visao.TelaEquipamentosEPI.pTOTAL_epi;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO EQUIPAMENTOS_SEGURANCA_EPI (FotoEquipamento,StatusEquipamento,DataCadastroEquipamento,DescricaoEquipamento,MarcaEquipamento,ModeloEquipamento,ComprimentoEquipamento,TipoMaterialEquipamento,PesoEquipamento,CorEquipamento,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
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
            pst.setString(12, objEquipa.getUsuarioInsert());
            pst.setString(13, objEquipa.getDataInsert());
            pst.setString(14, objEquipa.getHorarioInsert());
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
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE EQUIPAMENTOS_SEGURANCA_EPI SET FotoEquipamento=?,StatusEquipamento=?,DataCadastroEquipamento=?,DescricaoEquipamento=?,MarcaEquipamento=?,ModeloEquipamento=?,ComprimentoEquipamento=?,TipoMaterialEquipamento=?,PesoEquipamento=?,CorEquipamento=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdEquipamento='" + objEquipa.getIdEquipamento() + "'");
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
            pst.setString(12, objEquipa.getUsuarioUp());
            pst.setString(13, objEquipa.getDataUp());
            pst.setString(14, objEquipa.getHorarioUp());
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
                EquipamentoSegurancaEPI pDigi = new EquipamentoSegurancaEPI();
                pDigi.setIdEquipamento(conecta.rs.getInt("IdEquipamento"));
                pDigi.setStatusEquipamento(conecta.rs.getString("StatusEquipamento"));
                pDigi.setDataCadastroEquipamento(conecta.rs.getDate("DataCadastroEquipamento"));
                pDigi.setDescricaoEquipamento(conecta.rs.getString("DescricaoEquipamento"));
                pDigi.setMarcaEquipamento(conecta.rs.getString("MarcaEquipamento"));
                pDigi.setModeloEquipamento(conecta.rs.getString("ModeloEquipamento"));
                pDigi.setComprimentoEquipamento(conecta.rs.getString("ComprimentoEquipamento"));
                pDigi.setTipoMaterialEquipamento(conecta.rs.getString("TipoMaterialEquipamento"));
                pDigi.setPesoEquipamento(conecta.rs.getFloat("PesoEquipamento"));
                pDigi.setCorEquipamento(conecta.rs.getString("CorEquipamento"));
                pDigi.setObservacao(conecta.rs.getString("Observacao"));
                listaGruposArmas.add(pDigi);
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
                EquipamentoSegurancaEPI pDigi = new EquipamentoSegurancaEPI();
                pDigi.setIdEquipamento(conecta.rs.getInt("IdEquipamento"));
                pDigi.setStatusEquipamento(conecta.rs.getString("StatusEquipamento"));
                pDigi.setDataCadastroEquipamento(conecta.rs.getDate("DataCadastroEquipamento"));
                pDigi.setDescricaoEquipamento(conecta.rs.getString("DescricaoEquipamento"));
                pDigi.setMarcaEquipamento(conecta.rs.getString("MarcaEquipamento"));
                pDigi.setModeloEquipamento(conecta.rs.getString("ModeloEquipamento"));
                pDigi.setComprimentoEquipamento(conecta.rs.getString("ComprimentoEquipamento"));
                pDigi.setTipoMaterialEquipamento(conecta.rs.getString("TipoMaterialEquipamento"));
                pDigi.setPesoEquipamento(conecta.rs.getFloat("PesoEquipamento"));
                pDigi.setCorEquipamento(conecta.rs.getString("CorEquipamento"));
                pDigi.setObservacao(conecta.rs.getString("Observacao"));
                listaGruposArmas.add(pDigi);
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
            conecta.executaSQL("SELECT IdEquipamento,StatusEquipamento, "
                    + "DataCadastroEquipamento,DescricaoEquipamento, "
                    + "MarcaEquipamento,ModeloEquipamento,ComprimentoEquipamento, "
                    + "TipoMaterialEquipamento,PesoEquipamento, "
                    + "CorEquipamento,Observacao "
                    + "FROM EQUIPAMENTOS_SEGURANCA_EPI "
                    + "WHERE IdGrupoArm='" + pID_equipamento.toString().trim() + "' ");
            while (conecta.rs.next()) {
                EquipamentoSegurancaEPI pDigi = new EquipamentoSegurancaEPI();
                pDigi.setIdEquipamento(conecta.rs.getInt("IdEquipamento"));
                pDigi.setStatusEquipamento(conecta.rs.getString("StatusEquipamento"));
                pDigi.setDataCadastroEquipamento(conecta.rs.getDate("DataCadastroEquipamento"));
                pDigi.setDescricaoEquipamento(conecta.rs.getString("DescricaoEquipamento"));
                pDigi.setMarcaEquipamento(conecta.rs.getString("MarcaEquipamento"));
                pDigi.setModeloEquipamento(conecta.rs.getString("ModeloEquipamento"));
                pDigi.setComprimentoEquipamento(conecta.rs.getString("ComprimentoEquipamento"));
                pDigi.setTipoMaterialEquipamento(conecta.rs.getString("TipoMaterialEquipamento"));
                pDigi.setPesoEquipamento(conecta.rs.getFloat("PesoEquipamento"));
                pDigi.setCorEquipamento(conecta.rs.getString("CorEquipamento"));
                pDigi.setObservacao(conecta.rs.getString("Observacao"));
                listaGruposArmas.add(pDigi);
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

    public EquipamentoSegurancaEPI pBUSCAR_codigo(EquipamentoSegurancaEPI objGrupoArm) {

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
        return objGrupoArm;
    }
}
