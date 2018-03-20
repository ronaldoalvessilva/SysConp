/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.RegistroIndisciplinarPortaria;
import gestor.Modelo.VisitasOcorrenciaPortaria;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleBloqueioOcorrenciaServicoSocial {
    ConexaoBancoDados conecta = new ConexaoBancoDados();
    RegistroIndisciplinarPortaria objRegInd = new RegistroIndisciplinarPortaria();
    VisitasOcorrenciaPortaria objOcrPort = new VisitasOcorrenciaPortaria();

    int codInterno;
    
    public RegistroIndisciplinarPortaria atualizarBloqueioVisitasServicoSocial(RegistroIndisciplinarPortaria objRegInd) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REGISTRO_INDISCIPLINA_PORTARIA SET DataAprovacao1=?,UsuarioAutorizadorSS=?,StatusAprovacao=? WHERE IdReg='" + objRegInd.getIdReg() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objRegInd.getDataAprovacao1().getTime()));
            pst.setString(2, objRegInd.getUsuarioAprovador1());
            pst.setString(3, objRegInd.getStatusAprovacao());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ATUALIZAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objRegInd;
    }
    
    public VisitasOcorrenciaPortaria atualizarBloqueioVisitasItensRol(VisitasOcorrenciaPortaria objOcrPort) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSROL SET StatusVisita=? WHERE IdVisita='" + objOcrPort.getIdVisita()+ "'");           
            pst.setString(1, objOcrPort.getStatusVisitaRol()); 
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ATUALIZAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objOcrPort;
    }
    
    public VisitasOcorrenciaPortaria atualizarBloqueioInternasItensRol(VisitasOcorrenciaPortaria objOcrPort) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_LISTA_ROL SET StatusInterna=? WHERE IdInternoCrc='" + objOcrPort.getIdInternoCrc()+ "'");           
            pst.setString(1, objOcrPort.getStatusVisitaRol());  
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ATUALIZAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objOcrPort;
    }
    
    public VisitasOcorrenciaPortaria atualizarDataAprovacaoVisitasServicoSocial(VisitasOcorrenciaPortaria objOcrPort) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE VISITAS_OCORRENCIA_PORTARIA SET DataAprovaSocial=? WHERE IdReg='" + objOcrPort.getIdReg() + "'AND IdVisita='" + objOcrPort.getIdVisita()  + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objOcrPort.getDataAprovaSocial().getTime()));          
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ATUALIZAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objOcrPort;
    }
    
    public VisitasOcorrenciaPortaria atualizarDataAprovacaoVisitasInternasServicoSocial(VisitasOcorrenciaPortaria objOcrPort) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE VISITAS_INTERNAS_OCORRENCIA_PORTARIA SET DataAprovaSocial=? WHERE IdReg='" + objOcrPort.getIdReg() + "'AND IdInternoCrc='" + objOcrPort.getIdInternoCrc()  + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objOcrPort.getDataAprovaSocial().getTime()));          
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ATUALIZAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objOcrPort;
    }
}
