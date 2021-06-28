/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.LocalArmazenamento;
import static gestor.Visao.TelaLocalArmazenamentoEPI.jIDLocal;
import static gestor.Visao.TelaLocalArmazenamentoEPI.jPesqDescricaoLocal;
import static gestor.Visao.TelaLocalArmazenamentoEPI.pTOTAL_registros;
import static gestor.Visao.TelaLocalArmazenamentoEPI.pRESPOSTA_local;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleLocalArmazenamentoEPI {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    LocalArmazenamento objLocalMaster = new LocalArmazenamento();

    public LocalArmazenamento incluirLocalMaster(LocalArmazenamento objLocalMaster) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO LOCAL_ARMAZENAMENTO_EPI (StatusLocal,DescricaoLocal,NivelLocal,Modulo,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");
            pst.setString(1, objLocalMaster.getStatusLocal());
            pst.setString(2, objLocalMaster.getDescricaLocal());
            pst.setInt(3, objLocalMaster.getNivelLocal());
            pst.setString(4, objLocalMaster.getModulo());
            pst.setString(5, objLocalMaster.getUsuarioInsert());
            pst.setString(6, objLocalMaster.getDataInsert());
            pst.setString(7, objLocalMaster.getHorarioInsert());
            pst.execute();
            pRESPOSTA_local = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_local = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objLocalMaster;
    }

    public LocalArmazenamento alterarLocalMaster(LocalArmazenamento objLocalMaster) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE LOCAL_ARMAZENAMENTO_EPI SET StatusLocal=?,DescricaoLocal=?,NivelLocal=?,Modulo=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdLocal='" + objLocalMaster.getIdLocal() + "'");
            pst.setString(1, objLocalMaster.getStatusLocal());
            pst.setString(2, objLocalMaster.getDescricaLocal());
            pst.setInt(3, objLocalMaster.getNivelLocal());
            pst.setString(4, objLocalMaster.getModulo());
            pst.setString(5, objLocalMaster.getUsuarioUp());
            pst.setString(6, objLocalMaster.getDataUp());
            pst.setString(7, objLocalMaster.getHorarioUp());
            pst.executeUpdate();
            pRESPOSTA_local = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_local = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objLocalMaster;
    }

    public LocalArmazenamento excluirLocalMaster(LocalArmazenamento objLocalMaster) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM LOCAL_ARMAZENAMENTO_EPI WHERE IdLocal='" + objLocalMaster.getIdLocal() + "'");
            pst.executeUpdate();
            pRESPOSTA_local = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_local = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objLocalMaster;
    }

    //---------------------------------------- PESQUISAS ----------------------------------------------------------
    public List<LocalArmazenamento> TODOS_read() throws Exception {
        pTOTAL_registros = 0;
        conecta.abrirConexao();
        List<LocalArmazenamento> listarTodos = new ArrayList<LocalArmazenamento>();
        try {
            conecta.executaSQL("SELECT  "
                    + "IdLocal, "
                    + "StatusLocal, "
                    + "DescricaoLocal "
                    + "FROM LOCAL_ARMAZENAMENTO_EPI");
            while (conecta.rs.next()) {
                LocalArmazenamento pLocal = new LocalArmazenamento();
                pLocal.setIdLocal(conecta.rs.getInt("IdLocal"));
                pLocal.setStatusLocal(conecta.rs.getString("StatusLocal"));
                pLocal.setDescricaLocal(conecta.rs.getString("DescricaoLocal"));
                listarTodos.add(pLocal);
                pTOTAL_registros++;
            }
            return listarTodos;
        } catch (SQLException ex) {
            Logger.getLogger(ControleLocalArmazenamentoEPI.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
    
    public List<LocalArmazenamento> TODOS_nome() throws Exception {
        pTOTAL_registros = 0;
        conecta.abrirConexao();
        List<LocalArmazenamento> listarTodos = new ArrayList<LocalArmazenamento>();
        try {
            conecta.executaSQL("SELECT  "
                    + "IdLocal, "
                    + "StatusLocal, "
                    + "DescricaoLocal "
                    + "FROM LOCAL_ARMAZENAMENTO_EPI "
                    + "WHERE DescricaoLocal LIKE'%" + jPesqDescricaoLocal.getText() + "%'");
            while (conecta.rs.next()) {
                LocalArmazenamento pLocal = new LocalArmazenamento();
                pLocal.setIdLocal(conecta.rs.getInt("IdLocal"));
                pLocal.setStatusLocal(conecta.rs.getString("StatusLocal"));
                pLocal.setDescricaLocal(conecta.rs.getString("DescricaoLocal"));
                listarTodos.add(pLocal);
                pTOTAL_registros++;
            }
            return listarTodos;
        } catch (SQLException ex) {
            Logger.getLogger(ControleLocalArmazenamentoEPI.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public LocalArmazenamento PESQUISAR_nome(LocalArmazenamento objLocalMaster) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                     + "IdLocal, "
                    + "StatusLocal, "
                    + "DescricaoLocal "
                    + "FROM LOCAL_ARMAZENAMENTO_EPI "
                    + "WHERE DescricaoLocal LIKE'%" + jPesqDescricaoLocal.getText() + "%'");
            conecta.rs.first();
            objLocalMaster.setIdLocal(conecta.rs.getInt("IdLocal"));
            objLocalMaster.setStatusLocal(conecta.rs.getString("StatusLocal"));
            objLocalMaster.setDescricaLocal(conecta.rs.getString("DescricaoLocal"));
        } catch (Exception ex) {
            Logger.getLogger(ControleLocalArmazenamentoEPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
        return objLocalMaster;
    }
    
    public LocalArmazenamento BUSCAR_codigo(LocalArmazenamento objLocalMaster) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                     + "IdLocal "
                    + "FROM LOCAL_ARMAZENAMENTO_EPI");
            conecta.rs.first();
            jIDLocal.setText(String.valueOf(conecta.rs.getInt("IdLocal")));
        } catch (Exception ex) {
            Logger.getLogger(ControleLocalArmazenamentoEPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
        return objLocalMaster;
    }
}
