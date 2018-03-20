/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.DocumentosInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleDocumentosInternos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    DocumentosInternos objDocInternos = new DocumentosInternos();
    int idInterno;

    public DocumentosInternos incluirDocumentosInternos(DocumentosInternos objDocInternos) {
        buscarInterno(objDocInternos.getNomeInterno(),objDocInternos.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO DOCINTERNOS (StatusDoc,DataDoc,IdInternoCrc,"
                    + "RgDoc,CpfDoc,CnhDoc,TituloDoc,ReservistaDoc,CtpsDoc,CNascimentoDoc,CCasamentoDoc,OutrosDoc,DataDevolucaoDoc,"
                    + "ObservacaoDoc,UsuarioInsert,DataInsert,HorarioInsert,RgVia,CpfVia,CnhVia,ReservistaVia,CtpsVia,CertidaoNascVia,TituloVia,CertidaoCasaVia,PassaporteVia) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objDocInternos.getStatusDoc());
            pst.setTimestamp(2, new java.sql.Timestamp(objDocInternos.getDataDoc().getTime()));
            pst.setInt(3, idInterno);
            pst.setString(4, objDocInternos.getRgDoc());
            pst.setString(5, objDocInternos.getCpfDoc());
            pst.setString(6, objDocInternos.getCnhDoc());
            pst.setString(7, objDocInternos.getTituloDoc());
            pst.setString(8, objDocInternos.getReservistaDoc());
            pst.setString(9, objDocInternos.getCtpsDoc());
            pst.setString(10, objDocInternos.getcNascimentoDoc());
            pst.setString(11, objDocInternos.getcCasamentoDoc());
            pst.setString(12, objDocInternos.getOutrosDoc());
            if(objDocInternos.getDataDevolucaoDoc() != null){
                pst.setTimestamp(13, new java.sql.Timestamp(objDocInternos.getDataDevolucaoDoc().getTime()));
            }else{
                pst.setDate(13, null);
            }            
            pst.setString(14, objDocInternos.getObservacaoDoc());
            pst.setString(15, objDocInternos.getUsuarioInsert());
            pst.setString(16, objDocInternos.getDataInsert());
            pst.setString(17, objDocInternos.getHorarioInsert());  
            
            pst.setString(18, objDocInternos.getrGVia());
            pst.setString(19, objDocInternos.getcPFVia());
            pst.setString(20, objDocInternos.getcNHVia());
            pst.setString(21, objDocInternos.getReservistaVia());
            pst.setString(22, objDocInternos.getcTPSVia());
            pst.setString(23, objDocInternos.getCertidaoNascVia());
            pst.setString(24, objDocInternos.getTituloVia());
            pst.setString(25, objDocInternos.getCertidaoCasaVia());
            pst.setString(26, objDocInternos.getPassaporteVia());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objDocInternos;
    }
     public DocumentosInternos alterarDocumentosInternos(DocumentosInternos objDocInternos) {
        buscarInterno(objDocInternos.getNomeInterno(),objDocInternos.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE DOCINTERNOS SET StatusDoc=?,DataDoc=?,IdInternoCrc=?,RgDoc=?,CpfDoc=?,CnhDoc=?,TituloDoc=?,ReservistaDoc=?,CtpsDoc=?,CNascimentoDoc=?,CCasamentoDoc=?,OutrosDoc=?,DataDevolucaoDoc=?,ObservacaoDoc=?,UsuarioUp=?,DataUp=?,HorarioUp=?,RgVia=?,CpfVia=?,CnhVia=?,ReservistaVia=?,CtpsVia=?,CertidaoNascVia=?,TituloVia=?,CertidaoCasaVia=?,PassaporteVia=? WHERE IdDoc='" + objDocInternos.getIdDoc()  + "'");
            pst.setString(1, objDocInternos.getStatusDoc());
            if(objDocInternos.getDataDoc() != null){
                pst.setTimestamp(2, new java.sql.Timestamp(objDocInternos.getDataDoc().getTime()));
            }else{
                pst.setDate(2, null);
            }            
            pst.setInt(3, idInterno);
            pst.setString(4, objDocInternos.getRgDoc());
            pst.setString(5, objDocInternos.getCpfDoc());
            pst.setString(6, objDocInternos.getCnhDoc());
            pst.setString(7, objDocInternos.getTituloDoc());
            pst.setString(8, objDocInternos.getReservistaDoc());
            pst.setString(9, objDocInternos.getCtpsDoc());
            pst.setString(10, objDocInternos.getcNascimentoDoc());
            pst.setString(11, objDocInternos.getcCasamentoDoc());
            pst.setString(12, objDocInternos.getOutrosDoc());
            if(objDocInternos.getDataDevolucaoDoc() != null){
                pst.setTimestamp(13, new java.sql.Timestamp(objDocInternos.getDataDevolucaoDoc().getTime()));
            }else{
                pst.setDate(13, null);
            }            
            pst.setString(14, objDocInternos.getObservacaoDoc());
            pst.setString(15, objDocInternos.getUsuarioInsert());
            pst.setString(16, objDocInternos.getDataInsert());
            pst.setString(17, objDocInternos.getHorarioInsert());
            pst.setString(18, objDocInternos.getrGVia());
            pst.setString(19, objDocInternos.getcPFVia());
            pst.setString(20, objDocInternos.getcNHVia());
            pst.setString(21, objDocInternos.getReservistaVia());
            pst.setString(22, objDocInternos.getcTPSVia());
            pst.setString(23, objDocInternos.getCertidaoNascVia());
            pst.setString(24, objDocInternos.getTituloVia());
            pst.setString(25, objDocInternos.getCertidaoCasaVia());
            pst.setString(26, objDocInternos.getPassaporteVia());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objDocInternos;
    }
     
     public DocumentosInternos excluirDocumentosInternos(DocumentosInternos objDocInternos) {
       
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM DOCINTERNOS WHERE IdDoc='" + objDocInternos.getIdDoc()  + "'");            
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objDocInternos;
    }

    public void buscarInterno(String nome, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + nome + "'AND IdInternoCrc='" + codigo + "'");
            conecta.rs.first();
            idInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados da VISITA a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
