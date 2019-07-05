/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ProntuarioCrc;
import static gestor.Visao.TelaProntuarioCrc.jIdInterno;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Socializa TI 02
 */
public class ControleDocInternosFaltando {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ProntuarioCrc objProCrc = new ProntuarioCrc();
    int codInterno;
    int idChek;

    public ProntuarioCrc incluirDocumentoInternoCrc(ProntuarioCrc objProCrc) throws SQLException {
        buscarInterno(objProCrc.getNomeInterno(), objProCrc.getIdInterno());
        conecta.abrirConexao();
        try (PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO LISTA_DOCUMENTOS_INTERNO_CRC (IdInternoCrc,IdChek) VALUES(?,?)")) {
            pst.setInt(1, codInterno);
            pst.setInt(2, objProCrc.getIdChek());
            pst.execute();
        }
        conecta.desconecta();
        return objProCrc;
    }

    public ProntuarioCrc alterarDocumentoInternoCrc(ProntuarioCrc objProCrc) throws SQLException {
        buscarInterno(objProCrc.getNomeInterno(), objProCrc.getIdInterno());
        conecta.abrirConexao();
        try (PreparedStatement pst = conecta.con.prepareStatement("UPDATE LISTA_DOCUMENTOS_INTERNO_CRC SET IdInternoCrc=?,IdChek=? WHERE IdInternoCrc='" + objProCrc.getIdInterno() + "' AND IdChek='" + objProCrc.getIdChek() + "'")) {
            pst.setInt(1, codInterno);
            pst.setInt(2, objProCrc.getIdChek());
            pst.executeUpdate();
        }
        conecta.desconecta();
        return objProCrc;
    }

    public ProntuarioCrc excluirDocumentoInternoCrc(ProntuarioCrc objProCrc) throws SQLException {

        conecta.abrirConexao();
        try (PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM LISTA_DOCUMENTOS_INTERNO_CRC WHERE DescricaoDocumentos='" + objProCrc.getQuaisDocumentosFaltam() + "' AND IdInternoCrc='" + objProCrc.getIdInterno() + "'")) {
            pst.executeUpdate();
        }
        conecta.desconecta();
        return objProCrc;
    }

    public void buscarInterno(String nomeInterno, int idInterno) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE NomeInternoCrc='" + nomeInterno + "' "
                    + "AND IdInternoCrc='" + idInterno + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados dos INTERNOS a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void documentosInterno(String descricaoDoc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM CHECK_LIST_DOCUMENTOS_INTERNO_CRC "
                    + "WHERE DescricaoDocumentos='" + descricaoDoc + "'");
            conecta.rs.first();
            idChek = conecta.rs.getInt("IdChek");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados dos DOCUMENTOS a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public List<ProntuarioCrc> read() throws Exception {
        conecta.abrirConexao();
        List<ProntuarioCrc> listaInternosPavilhao = new ArrayList<ProntuarioCrc>();
        try {
            conecta.executaSQL("SELECT * FROM LISTA_DOCUMENTOS_INTERNO_CRC "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON LISTA_DOCUMENTOS_INTERNO_CRC.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN CHECK_LIST_DOCUMENTOS_INTERNO_CRC "
                    + "ON LISTA_DOCUMENTOS_INTERNO_CRC.IdChek=CHECK_LIST_DOCUMENTOS_INTERNO_CRC.IdChek "
                    + "WHERE PRONTUARIOSCRC.IdInternoCrc='" + jIdInterno.getText() + "'");
            while (conecta.rs.next()) {
                ProntuarioCrc pDigiDoc = new ProntuarioCrc();
                pDigiDoc.setIdInterno(conecta.rs.getInt("IdInternoCrc"));
                pDigiDoc.setIdChek(conecta.rs.getInt("IdChek"));
                pDigiDoc.setDescricaoDoc(conecta.rs.getString("DescricaoDocumentos"));
                listaInternosPavilhao.add(pDigiDoc);
            }
            return listaInternosPavilhao;
        } catch (SQLException ex) {
            Logger.getLogger(ControleDocInternosFaltando.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
