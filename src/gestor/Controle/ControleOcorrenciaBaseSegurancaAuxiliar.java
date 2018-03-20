/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.OcorrenciaSeguranca;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleOcorrenciaBaseSegurancaAuxiliar {
    ConexaoBancoDados conecta = new ConexaoBancoDados();
    OcorrenciaSeguranca objOcorr = new OcorrenciaSeguranca();
    
     public OcorrenciaSeguranca incluirOcorrenciaP1(OcorrenciaSeguranca objOcorr) {
       
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO OCORRENCIAS_BASE_SEGURANCA_AUXILIAR (StatusLanc,DataLanc,Titulo,TextoArea,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");          
            pst.setString(1, objOcorr.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objOcorr.getDataLanc().getTime()));
            pst.setString(3, objOcorr.getTitulo());            
            pst.setString(4, objOcorr.getTextoArea());
            pst.setString(5, objOcorr.getUsuarioInsert());
            pst.setString(6, objOcorr.getDataInsert());
            pst.setString(7, objOcorr.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objOcorr;
    }
      public OcorrenciaSeguranca alterarOcorrenciaP1(OcorrenciaSeguranca objOcorr) {
       
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE OCORRENCIAS_BASE_SEGURANCA_AUXILIAR SET StatusLanc=?,DataLanc=?,Titulo=?,TextoArea=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdLanc='" + objOcorr.getIdLanc() + "'");          
            pst.setString(1, objOcorr.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objOcorr.getDataLanc().getTime()));
            pst.setString(3, objOcorr.getTitulo());            
            pst.setString(4, objOcorr.getTextoArea());
            pst.setString(5, objOcorr.getUsuarioInsert());
            pst.setString(6, objOcorr.getDataInsert());
            pst.setString(7, objOcorr.getHorarioInsert());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objOcorr;
    }
       public OcorrenciaSeguranca excluirOcorrenciaP1(OcorrenciaSeguranca objOcorr) {
       
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM OCORRENCIAS_BASE_SEGURANCA_AUXILIAR WHERE IdLanc='" + objOcorr.getIdLanc() + "'");                     
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel DELETAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objOcorr;
    }
        public OcorrenciaSeguranca finalizarOcorrenciaP1(OcorrenciaSeguranca objOcorr) {
       
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE OCORRENCIAS_BASE_SEGURANCA_AUXILIAR SET StatusLanc=? WHERE IdLanc='" + objOcorr.getIdLanc() + "'");          
            pst.setString(1, objOcorr.getStatusLanc());            
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALZAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objOcorr;
    }
}
