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
 * @author ronaldo
 */
public class ControleBloqueioOcorrenciaSegurancaVisitaInterna {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    RegistroIndisciplinarPortaria objRegInd = new RegistroIndisciplinarPortaria();
    VisitasOcorrenciaPortaria objOcrPort = new VisitasOcorrenciaPortaria();

    public RegistroIndisciplinarPortaria atualizarBloqueioVisitasSegurancaInterna(RegistroIndisciplinarPortaria objRegInd) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REGISTRO_INDISCIPLINA_PORTARIA SET DataAprovacao=?,UsuarioAutorizadorSeg=?,StatusAprovacao=? WHERE IdReg='" + objRegInd.getIdReg() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objRegInd.getDataAprovacao().getTime()));
            pst.setString(2, objRegInd.getUsuarioAprovador());
            pst.setString(3, objRegInd.getStatusAprovacao());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ATUALIZAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objRegInd;
    }

    public VisitasOcorrenciaPortaria atualizarBloqueioVisitasSegurancaDatasInterna(VisitasOcorrenciaPortaria objOcrPort) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE VISITAS_INTERNAS_OCORRENCIA_PORTARIA SET DataBloq=?,DataBloq1=?,TipoBloq=? WHERE IdItem='" + objOcrPort.getIdItem() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objOcrPort.getDataBloq().getTime()));
            if (objOcrPort.getDataBloq() != null) {
                pst.setTimestamp(2, new java.sql.Timestamp(objOcrPort.getDataBloq1().getTime()));
            } else {
                pst.setDate(2, null);
            }
            pst.setInt(3, objOcrPort.getTipoBloqueio());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ATUALIZAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objOcrPort;
    }

    public VisitasOcorrenciaPortaria atualizarLiberacaoVisitasSegurancaInterna(VisitasOcorrenciaPortaria objOcrPort) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE VISITAS_INTERNAS_OCORRENCIA_PORTARIA SET DataLib=?,TipoBloq=? WHERE IdItem='" + objOcrPort.getIdItem() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objOcrPort.getDataLib().getTime()));
            pst.setInt(2, objOcrPort.getBloqueioLiberacao());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ATUALIZAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objOcrPort;
    }

    public VisitasOcorrenciaPortaria confirmarLiberacaoVisitasSegurancaInterna(VisitasOcorrenciaPortaria objOcrPort) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE VISITAS_INTERNAS_OCORRENCIA_PORTARIA SET Confirmar=? WHERE IdReg='" + objOcrPort.getIdReg() + "'");
            pst.setString(1, objOcrPort.getConfirmar());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ATUALIZAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objOcrPort;
    }

    public RegistroIndisciplinarPortaria atualizarBloqueioVisitasServicoSocialInterna(RegistroIndisciplinarPortaria objRegInd) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REGISTRO_INDISCIPLINA_PORTARIA SET DataAprovacao=?,UsuarioAutorizadorSeq=? WHERE IdReg='" + objRegInd.getIdReg() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objRegInd.getDataAprovacao1().getTime()));
            pst.setString(2, objRegInd.getUsuarioAprovador1());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ATUALIZAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objRegInd;
    }
}
