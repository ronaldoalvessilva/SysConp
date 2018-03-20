/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.Documentos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleDocumentosColaborador {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    Documentos objDoc = new Documentos();

    public Documentos incluirDocumentosColaborador(Documentos objDoc) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO DOCUMENTOS (IdFunc,RgDoc,DataEmissaoDoc,OrgaoDoc,EstadoOrg,CpfDoc,PisDoc,DataCadPisDoc,TituloDoc,ZonaDoc,SecaoDoc,CtpsDoc,SerieDoc,HabiliDoc,ReservistaDoc,CateDoc,CartSaudeDoc,ProfDoc,AlturaDoc,PesoDoc,CalcaDoc,CamisaDoc,SapatoDoc,CarteiraDoc,TipoConjugue,DataNasConjugue,NomeConjugue,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objDoc.getIdFunc());
            pst.setString(2, objDoc.getRgDoc());
            if (objDoc.getDataEmissaoDoc() != null) {
                pst.setTimestamp(3, new java.sql.Timestamp(objDoc.getDataEmissaoDoc().getTime()));
            } else {
                pst.setDate(3, null);
            }
            pst.setString(4, objDoc.getOrgaoDoc());
            pst.setString(5, objDoc.getEstadoOrgao());
            pst.setString(6, objDoc.getCpfDoc());
            pst.setString(7, objDoc.getPisDoc());
            if (objDoc.getDataCadPisDoc() != null) {
                pst.setTimestamp(8, new java.sql.Timestamp(objDoc.getDataCadPisDoc().getTime()));
            } else {
                pst.setDate(8, null);
            }
            pst.setString(9, objDoc.getTituloDoc());
            pst.setString(10, objDoc.getZonaDoc());
            pst.setString(11, objDoc.getSecaoDoc());
            pst.setString(12, objDoc.getCtpsDoc());
            pst.setString(13, objDoc.getSerieDoc());
            pst.setString(14, objDoc.getHabiliDoc());
            pst.setString(15, objDoc.getReserVistaDoc());
            pst.setString(16, objDoc.getCateDoc());
            pst.setString(17, objDoc.getCartSaudeDoc());
            pst.setString(18, objDoc.getProfDoc());
            pst.setString(19, objDoc.getAlturaDoc());
            pst.setString(20, objDoc.getPesoDoc());
            pst.setString(21, objDoc.getCalcaDoc());
            pst.setString(22, objDoc.getCamisaDoc());
            pst.setString(23, objDoc.getSapatoDoc());
            pst.setString(24, objDoc.getCarteiraDoc());
            pst.setString(25, objDoc.getTipoConjugue());
            if (objDoc.getDataNasConjugue() != null) {
                pst.setTimestamp(26, new java.sql.Timestamp(objDoc.getDataNasConjugue().getTime()));
            } else {
                pst.setDate(26, null);
            }
            pst.setString(27, objDoc.getNomeConjugue());
            pst.setString(28, objDoc.getUsuarioInsert());
            pst.setString(29, objDoc.getDataInsert());
            pst.setString(30, objDoc.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INCLUIR os Dados. (DOCUMENTOS)\nERRO: " + ex);
        }
        conecta.desconecta();
        return objDoc;
    }

    public Documentos alterarDocumentosColaborador(Documentos objDoc) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE DOCUMENTOS SET IdFunc=?,RgDoc=?,DataEmissaoDoc=?,OrgaoDoc=?,EstadoOrg=?,CpfDoc=?,PisDoc=?,DataCadPisDoc=?,TituloDoc=?,ZonaDoc=?,SecaoDoc=?,CtpsDoc=?,SerieDoc=?,HabiliDoc=?,ReservistaDoc=?,CateDoc=?,CartSaudeDoc=?,ProfDoc=?,AlturaDoc=?,PesoDoc=?,CalcaDoc=?,CamisaDoc=?,SapatoDoc=?,CarteiraDoc=?,TipoConjugue=?,DataNasConjugue=?,NomeConjugue=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdDoc='" + objDoc.getIdDoc() + "'AND IdFunc='" + objDoc.getIdFunc() + "'");
            pst.setInt(1, objDoc.getIdFunc());
            pst.setString(2, objDoc.getRgDoc());
            if (objDoc.getDataEmissaoDoc() != null) {
                pst.setTimestamp(3, new java.sql.Timestamp(objDoc.getDataEmissaoDoc().getTime()));
            } else {
                pst.setDate(3, null);
            }
            pst.setString(4, objDoc.getOrgaoDoc());
            pst.setString(5, objDoc.getEstadoOrgao());
            pst.setString(6, objDoc.getCpfDoc());
            pst.setString(7, objDoc.getPisDoc());
            if (objDoc.getDataCadPisDoc() != null) {
                pst.setTimestamp(8, new java.sql.Timestamp(objDoc.getDataCadPisDoc().getTime()));
            } else {
                pst.setDate(8, null);
            }
            pst.setString(9, objDoc.getTituloDoc());
            pst.setString(10, objDoc.getZonaDoc());
            pst.setString(11, objDoc.getSecaoDoc());
            pst.setString(12, objDoc.getCtpsDoc());
            pst.setString(13, objDoc.getSerieDoc());
            pst.setString(14, objDoc.getHabiliDoc());
            pst.setString(15, objDoc.getReserVistaDoc());
            pst.setString(16, objDoc.getCateDoc());
            pst.setString(17, objDoc.getCartSaudeDoc());
            pst.setString(18, objDoc.getProfDoc());
            pst.setString(19, objDoc.getAlturaDoc());
            pst.setString(20, objDoc.getPesoDoc());
            pst.setString(21, objDoc.getCalcaDoc());
            pst.setString(22, objDoc.getCamisaDoc());
            pst.setString(23, objDoc.getSapatoDoc());
            pst.setString(24, objDoc.getCarteiraDoc());
            pst.setString(25, objDoc.getTipoConjugue());
            if (objDoc.getDataNasConjugue() != null) {
                pst.setTimestamp(26, new java.sql.Timestamp(objDoc.getDataNasConjugue().getTime()));
            } else {
                pst.setDate(26, null);
            }
            pst.setString(27, objDoc.getNomeConjugue());
            pst.setString(28, objDoc.getUsuarioUp());
            pst.setString(29, objDoc.getDataUp());
            pst.setString(30, objDoc.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objDoc;
    }

    public Documentos excluirDocumentosColaborador(Documentos objDoc) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM DOCUMENTOS WHERE IdDoc='" + objDoc.getIdDoc() + "'AND IdFunc='" + objDoc.getIdFunc() + "'");
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objDoc;
    }
}
