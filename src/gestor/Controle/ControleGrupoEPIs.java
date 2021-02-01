/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.GrupoArmasEPIs;
import static gestor.Visao.TelaGrupoEPIs.pTOTAL_grupo;
import static gestor.Visao.TelaGrupoEPIs.jPesqNomeGrupoArma;
import static gestor.Visao.TelaGrupoEPIs.pID_grupo;
import static gestor.Visao.TelaGrupoEPIs.pRESPOSTA_grupo;
import static gestor.Visao.TelaGrupoEPIs.jCodigoGrupo;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo.silva7
 */
public class ControleGrupoEPIs {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    GrupoArmasEPIs objGrupoArm = new GrupoArmasEPIs();

    public GrupoArmasEPIs incluirGrupoArmas(GrupoArmasEPIs objGrupoArm) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO GRUPO_EPIs (StatusEPI,DataCadastro,DescricaoGrupoEPI,Obsercacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");
            pst.setString(1, objGrupoArm.getStatusArmaEPI());
            pst.setTimestamp(2, new java.sql.Timestamp(objGrupoArm.getDataCadastro().getTime()));
            pst.setString(3, objGrupoArm.getDescricaoArma());
            pst.setString(4, objGrupoArm.getObsercacao());
            pst.setString(5, objGrupoArm.getUsuarioInsert());
            pst.setString(6, objGrupoArm.getDataInsert());
            pst.setString(7, objGrupoArm.getHorarioInsert());
            pst.execute();
            pRESPOSTA_grupo = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_grupo = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objGrupoArm;
    }

    public GrupoArmasEPIs alterarGrupoArmas(GrupoArmasEPIs objGrupoArm) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE GRUPO_EPIs SET StatusEPI=?,DataCadastro=?,DescricaoGrupoEPI=?,Obsercacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdGrupoEPI='" + objGrupoArm.getIdGrupArma() + "'");
            pst.setString(1, objGrupoArm.getStatusArmaEPI());
            pst.setTimestamp(2, new java.sql.Timestamp(objGrupoArm.getDataCadastro().getTime()));
            pst.setString(3, objGrupoArm.getDescricaoArma());
            pst.setString(4, objGrupoArm.getObsercacao());
            pst.setString(5, objGrupoArm.getUsuarioUp());
            pst.setString(6, objGrupoArm.getDataUp());
            pst.setString(7, objGrupoArm.getHorarioUp());
            pst.executeUpdate();
            pRESPOSTA_grupo = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_grupo = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objGrupoArm;
    }

    public GrupoArmasEPIs excluirGrupoArmas(GrupoArmasEPIs objGrupoArm) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM GRUPO_EPIs WHERE IdGrupoEPI='" + objGrupoArm.getIdGrupArma() + "'");
            pst.executeUpdate();
            pRESPOSTA_grupo = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_grupo = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objGrupoArm;
    }

    public List<GrupoArmasEPIs> TODOS_read() throws Exception {
        pTOTAL_grupo = 0;
        conecta.abrirConexao();
        List<GrupoArmasEPIs> listaGruposArmas = new ArrayList<GrupoArmasEPIs>();
        try {
            conecta.executaSQL("SELECT IdGrupoEPI,StatusEPI, "
                    + "DataCadastro,DescricaoGrupoEPI, "
                    + "Obsercacao "
                    + "FROM GRUPO_EPIs "
                    + "ORDER BY DescricaoGrupoEPI");
            while (conecta.rs.next()) {
                GrupoArmasEPIs pDigi = new GrupoArmasEPIs();
                pDigi.setIdGrupArma(conecta.rs.getInt("IdGrupoEPI"));
                pDigi.setStatusArmaEPI(conecta.rs.getString("StatusEPI"));
                pDigi.setDataCadastro(conecta.rs.getDate("DataCadastro"));
                pDigi.setDescricaoArma(conecta.rs.getString("DescricaoGrupoEPI"));
                pDigi.setObsercacao(conecta.rs.getString("Obsercacao"));
                listaGruposArmas.add(pDigi);
                pTOTAL_grupo++;
            }
            return listaGruposArmas;
        } catch (SQLException ex) {
            Logger.getLogger(ControleGrupoEPIs.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public List<GrupoArmasEPIs> pNOME_GRUPO_read() throws Exception {
        pTOTAL_grupo = 0;
        conecta.abrirConexao();
        List<GrupoArmasEPIs> listaGruposArmas = new ArrayList<GrupoArmasEPIs>();
        try {
            conecta.executaSQL("SELECT IdGrupoEPI,StatusEPI, "
                    + "DataCadastro,DescricaoGrupoEPI, "
                    + "Obsercacao "
                    + "FROM GRUPO_EPIs "
                    + "WHERE DescricaoGrupoEPI LIKE'%" + jPesqNomeGrupoArma.getText() + "%' ");
            while (conecta.rs.next()) {
                GrupoArmasEPIs pDigi = new GrupoArmasEPIs();
                pDigi.setIdGrupArma(conecta.rs.getInt("IdGrupoEPI"));
                pDigi.setStatusArmaEPI(conecta.rs.getString("StatusEPI"));
                pDigi.setDataCadastro(conecta.rs.getDate("DataCadastro"));
                pDigi.setDescricaoArma(conecta.rs.getString("DescricaoGrupoEPI"));
                pDigi.setObsercacao(conecta.rs.getString("Obsercacao"));
                listaGruposArmas.add(pDigi);
                pTOTAL_grupo++;
            }
            return listaGruposArmas;
        } catch (SQLException ex) {
            Logger.getLogger(ControleGrupoEPIs.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public List<GrupoArmasEPIs> pCODIGO_GRUPO_read() throws Exception {
        pTOTAL_grupo = 0;
        conecta.abrirConexao();
        List<GrupoArmasEPIs> listaGruposArmas = new ArrayList<GrupoArmasEPIs>();
        try {
            conecta.executaSQL("SELECT IdGrupoEPI,StatusEPI, "
                    + "DataCadastro,DescricaoGrupoEPI, "
                    + "Obsercacao "
                    + "FROM GRUPO_EPIs "
                    + "WHERE IdGrupoEPI='" + pID_grupo.toString().trim() + "' ");
            while (conecta.rs.next()) {
                GrupoArmasEPIs pDigi = new GrupoArmasEPIs();
                pDigi.setIdGrupArma(conecta.rs.getInt("IdGrupoEPI"));
                pDigi.setStatusArmaEPI(conecta.rs.getString("StatusEPI"));
                pDigi.setDataCadastro(conecta.rs.getDate("DataCadastro"));
                pDigi.setDescricaoArma(conecta.rs.getString("DescricaoGrupoEPI"));
                pDigi.setObsercacao(conecta.rs.getString("Obsercacao"));
                listaGruposArmas.add(pDigi);
                pTOTAL_grupo++;
            }
            return listaGruposArmas;
        } catch (SQLException ex) {
            Logger.getLogger(ControleGrupoEPIs.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
    
    public GrupoArmasEPIs pBUSCAR_codigo(GrupoArmasEPIs objGrupoArm) {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdGrupoEPI "
                    + "FROM GRUPO_EPIs");
            conecta.rs.last();
            jCodigoGrupo.setText(String.valueOf(conecta.rs.getInt("IdGrupoEPI")));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ENCONTRAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objGrupoArm;
    }
}
