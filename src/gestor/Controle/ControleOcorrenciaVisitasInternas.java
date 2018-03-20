/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.VisitasOcorrenciaPortaria;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleOcorrenciaVisitasInternas {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    VisitasOcorrenciaPortaria objOcrPort = new VisitasOcorrenciaPortaria();
    int codVisita;

    public VisitasOcorrenciaPortaria incluirVisitasInterna(VisitasOcorrenciaPortaria objOcrPort) {
        buscarVisitaInterno(objOcrPort.getNomeVisitaInterna());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO VISITAS_INTERNAS_OCORRENCIA_PORTARIA (IdReg,IdInternoCrc,BloqLib,TipoBloq,Confirmar,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?)");
            pst.setInt(1, objOcrPort.getIdReg());
            pst.setInt(2, codVisita);
            pst.setInt(3, objOcrPort.getBloqueioLiberacao());
            pst.setInt(4, objOcrPort.getTipoBloqueio());
            pst.setString(5, objOcrPort.getConfirmar());
            pst.setString(6, objOcrPort.getUsuarioInsert());
            pst.setString(7, objOcrPort.getDataInsert());
            pst.setString(8, objOcrPort.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objOcrPort;
    }

    public VisitasOcorrenciaPortaria alterarVisitasInterna(VisitasOcorrenciaPortaria objOcrPort) {
        buscarVisitaInterno(objOcrPort.getNomeVisitaInterna());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE VISITAS_INTERNAS_OCORRENCIA_PORTARIA SET IdReg=?,IdInternoCrc=?,BloqLib=?,TipoBloq=?,Confirmar=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objOcrPort.getIdItem() + "'");          
            pst.setInt(1, objOcrPort.getIdReg());
            pst.setInt(2, codVisita);
            pst.setInt(3, objOcrPort.getBloqueioLiberacao());
            pst.setInt(4, objOcrPort.getTipoBloqueio());
            pst.setString(5, objOcrPort.getConfirmar());
            pst.setString(6, objOcrPort.getUsuarioUp());
            pst.setString(7, objOcrPort.getDataUp());
            pst.setString(8, objOcrPort.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objOcrPort;
    }

    public VisitasOcorrenciaPortaria excluirVisitasInterna(VisitasOcorrenciaPortaria objOcrPort) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM VISITAS_INTERNAS_OCORRENCIA_PORTARIA WHERE IdItem='" + objOcrPort.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objOcrPort;
    }

    public void buscarVisitaInterno(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + nome + "'");
            conecta.rs.first();
            codVisita = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
