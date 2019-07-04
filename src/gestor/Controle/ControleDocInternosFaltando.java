/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ProntuarioCrc;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        documentosInterno(objProCrc.getQuaisDocumentosFaltam());
        conecta.abrirConexao();
        try (PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO LISTA_DOCUMENTOS_INTERNO_CRC (IdInternoCrc,IdChek) VALUES(?,?)")) {
            pst.setInt(1, codInterno);
            pst.setInt(2, objProCrc.getIdChek());
            pst.execute();
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
}
