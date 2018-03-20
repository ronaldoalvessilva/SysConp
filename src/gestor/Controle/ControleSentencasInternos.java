/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.SentencaInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleSentencasInternos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    SentencaInternos objSentInt = new SentencaInternos();
   

    public SentencaInternos incluirSentencaInternos(SentencaInternos objSentInt) {
 
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO SENTENCAS (DocMudaRegime,MudancaRegime,DataLanc,IdInternoCrc,DataEntrada,IdUnid,DataCrime,DataPrisao,DataCondenacao,Participacao,Regime,Pena,Artigo1,Artigo2,Artigo3,Paragrafo1,Paragrafo2,Paragrafo3,CrimeHediondo,TerminoPena) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objSentInt.getIdLanc());
            pst.setString(2, objSentInt.getMudancaRegime());
            pst.setTimestamp(3, new java.sql.Timestamp(objSentInt.getDataLanc().getTime()));
            pst.setInt(4, objSentInt.getIdInternoCrc());
            if (objSentInt.getDataEntradaCrc() != null) {
                pst.setTimestamp(5, new java.sql.Timestamp(objSentInt.getDataEntradaCrc().getTime()));
            } else {
                pst.setDate(5, null);
            }
            pst.setInt(6, objSentInt.getIdUnid());
            if (objSentInt.getDataCrimeCrc() != null) {
                pst.setTimestamp(7, new java.sql.Timestamp(objSentInt.getDataCrimeCrc().getTime()));
            } else {
                pst.setDate(7, null);
            }
            if (objSentInt.getDataPrisaoCrc() != null) {
                pst.setTimestamp(8, new java.sql.Timestamp(objSentInt.getDataPrisaoCrc().getTime()));
            } else {
                pst.setDate(8, null);
            }
            if (objSentInt.getDataCondenacaoCrc() != null) {
                pst.setTimestamp(9, new java.sql.Timestamp(objSentInt.getDataCondenacaoCrc().getTime()));
            } else {
                pst.setDate(9, null);
            }
            pst.setString(10, objSentInt.getParticipacao());
            pst.setString(11, objSentInt.getRegimeAnterior());
            pst.setString(12, objSentInt.getPena());
            pst.setString(13, objSentInt.getArtigo1());
            pst.setString(14, objSentInt.getArtigo2());
            pst.setString(15, objSentInt.getArtigo3());
            pst.setString(16, objSentInt.getParagrafo1());
            pst.setString(17, objSentInt.getParagrafo2());
            pst.setString(18, objSentInt.getParagrafo3());
            pst.setString(19, objSentInt.getCrimeHediondo());
            if(objSentInt.getTerminoPenaCrc() != null){
                pst.setTimestamp(20, new java.sql.Timestamp(objSentInt.getTerminoPenaCrc().getTime()));
            }else{
                pst.setDate(20, null);
            }            
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objSentInt;
    }

    public SentencaInternos alterarSentencaInternos(SentencaInternos objSentInt) {
     
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE SENTENCAS SET DocMudaRegime=?,MudancaRegime=?,DataLanc=?,IdInternoCrc=?,DataEntrada=?,IdUnid=?,DataCrime=?,DataPrisao=?,DataCondenacao=?,Participacao=?,Regime=?,Pena=?,Artigo1=?,Artigo2=?,Artigo3=?,Paragrafo1=?,Paragrafo2=?,Paragrafo3=?,CrimeHediondo=?,TerminoPena=? WHERE IdInternoCrc='" + objSentInt.getIdInternoCrc() + "'AND DocMudaRegime='" + objSentInt.getIdLanc() + "'");
            pst.setInt(1, objSentInt.getIdLanc());
            pst.setString(2, objSentInt.getMudancaRegime());
            pst.setTimestamp(3, new java.sql.Timestamp(objSentInt.getDataLanc().getTime()));
            pst.setInt(4, objSentInt.getIdInternoCrc());
            if (objSentInt.getDataEntradaCrc() != null) {
                pst.setTimestamp(5, new java.sql.Timestamp(objSentInt.getDataEntradaCrc().getTime()));
            } else {
                pst.setDate(5, null);
            }
            pst.setInt(6, objSentInt.getIdUnid());
            if (objSentInt.getDataCrimeCrc() != null) {
                pst.setTimestamp(7, new java.sql.Timestamp(objSentInt.getDataCrimeCrc().getTime()));
            } else {
                pst.setDate(7, null);
            }
            if (objSentInt.getDataPrisaoCrc() != null) {
                pst.setTimestamp(8, new java.sql.Timestamp(objSentInt.getDataPrisaoCrc().getTime()));
            } else {
                pst.setDate(8, null);
            }
            if (objSentInt.getDataCondenacaoCrc() != null) {
                pst.setTimestamp(9, new java.sql.Timestamp(objSentInt.getDataCondenacaoCrc().getTime()));
            } else {
                pst.setDate(9, null);
            }
            pst.setString(10, objSentInt.getParticipacao());
            pst.setString(11, objSentInt.getRegimeAnterior());
            pst.setString(12, objSentInt.getPena());
            pst.setString(13, objSentInt.getArtigo1());
            pst.setString(14, objSentInt.getArtigo2());
            pst.setString(15, objSentInt.getArtigo3());
            pst.setString(16, objSentInt.getParagrafo1());
            pst.setString(17, objSentInt.getParagrafo2());
            pst.setString(18, objSentInt.getParagrafo3());
            pst.setString(19, objSentInt.getCrimeHediondo());
            if(objSentInt.getTerminoPenaCrc() != null){
                pst.setTimestamp(20, new java.sql.Timestamp(objSentInt.getTerminoPenaCrc().getTime()));
            }else{
                pst.setDate(20, null);
            }            
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objSentInt;
    }
    
     public SentencaInternos excluirSentencaInternos(SentencaInternos objSentInt) {
     
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM SENTENCAS WHERE IdInternoCrc='" + objSentInt.getIdInternoCrc() + "'AND DocMudaRegime='" + objSentInt.getIdLanc() + "'");          
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR a SETENÇA!!!\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objSentInt;
    }
}
