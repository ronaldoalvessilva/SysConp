/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.DadosFisicosInternos;
import gestor.Modelo.ProntuarioCrc;
import static gestor.Visao.TelaProntuarioTriagem.pRESPOSTA_DADOS_fisicos;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleDadosFisicos_TRIAGEM {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ProntuarioCrc objProCrc = new ProntuarioCrc();
    DadosFisicosInternos objDafis = new DadosFisicosInternos();

    int codIntCrc;
    int codUnid;

    // Incluir DADOS FISICOS INTERNO CRC
    public DadosFisicosInternos incluirDadosFisicos(DadosFisicosInternos objDafis) {
        BUSCAR_CODIGO_interno(objDafis.getNomeInternoCrc(), objDafis.getNomeMaeInternoCrc());
        // Incluir Registro na tabela de INTERNOS CRC
        conecta.abrirConexao();
        try (PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO DADOSFISICOSINTERNOS (Cutis,Olhos,Cabelos,"
                + "Barba,Bigode,Nariz,Boca,Rosto,Labios,Camisa,Calca,Sapato,Peso,"
                + "Altura,Sinais,Orelhas,Pescoco,Compleicao,IdInternoCrc) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)")) {
            pst.setString(1, objDafis.getCutis());
            pst.setString(2, objDafis.getOlhos());
            pst.setString(3, objDafis.getCabelos());
            pst.setString(4, objDafis.getBarba());
            pst.setString(5, objDafis.getBigode());
            pst.setString(6, objDafis.getNariz());
            pst.setString(7, objDafis.getBoca());
            pst.setString(8, objDafis.getRosto());
            pst.setString(9, objDafis.getLabios());
            pst.setString(10, objDafis.getCamisa());
            pst.setString(11, objDafis.getCalca());
            pst.setString(12, objDafis.getSapato());
            pst.setString(13, objDafis.getPeso());
            pst.setString(14, objDafis.getAltura());
            pst.setString(15, objDafis.getSinais());
            pst.setString(16, objDafis.getOrelha());
            pst.setString(17, objDafis.getPescoco());
            pst.setString(18, objDafis.getCompleicao());
            pst.setInt(19, codIntCrc);
            pst.executeUpdate();
            pRESPOSTA_DADOS_fisicos = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_DADOS_fisicos = "Não";
            Logger.getLogger(ControleDadosFisicos_TRIAGEM.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
        return objDafis;
    }

    //Método para Alterar DADOS FISICOS INTERNO CRC
    public DadosFisicosInternos alterarDadosFisicos(DadosFisicosInternos objDafis) {
        conecta.abrirConexao();
        // Alterar Registro na tabela de INTERNOS CRC
        try (PreparedStatement pst = conecta.con.prepareStatement("UPDATE DADOSFISICOSINTERNOS SET Cutis=?,Olhos=?,Cabelos=?,"
                + "Barba=?,Bigode=?,Nariz=?,Boca=?,Rosto=?,Labios=?,Camisa=?,Calca=?,Sapato=?,Peso=?,"
                + "Altura=?,Sinais=?,Orelhas=?,Pescoco=?,Compleicao=?,IdInternoCrc=? WHERE IdInternoCrc='" + objDafis.getIdInternoCrc() + "'")) {
            pst.setString(1, objDafis.getCutis());
            pst.setString(2, objDafis.getOlhos());
            pst.setString(3, objDafis.getCabelos());
            pst.setString(4, objDafis.getBarba());
            pst.setString(5, objDafis.getBigode());
            pst.setString(6, objDafis.getNariz());
            pst.setString(7, objDafis.getBoca());
            pst.setString(8, objDafis.getRosto());
            pst.setString(9, objDafis.getLabios());
            pst.setString(10, objDafis.getCamisa());
            pst.setString(11, objDafis.getCalca());
            pst.setString(12, objDafis.getSapato());
            pst.setString(13, objDafis.getPeso());
            pst.setString(14, objDafis.getAltura());
            pst.setString(15, objDafis.getSinais());
            pst.setString(16, objDafis.getOrelha());
            pst.setString(17, objDafis.getPescoco());
            pst.setString(18, objDafis.getCompleicao());
            pst.setInt(19, objDafis.getIdInternoCrc());
            pst.executeUpdate();
            pRESPOSTA_DADOS_fisicos = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_DADOS_fisicos = "Não";
            Logger.getLogger(ControleDadosFisicos_TRIAGEM.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
        return objDafis;
    }

    // EXCLUIR registro do DADOS FISICOS DO INTERNO CRC
    public DadosFisicosInternos excluirDadosFisicos(DadosFisicosInternos objDafis) {
        conecta.abrirConexao();
        try (PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM DADOSFISICOSINTERNOS WHERE IdInternoCrc='" + objDafis.getIdInternoCrc() + "'")) {
            pst.executeUpdate();
            pRESPOSTA_DADOS_fisicos = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_DADOS_fisicos = "Não";
            Logger.getLogger(ControleDadosFisicos_TRIAGEM.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
        return objDafis;
    }

    public void BUSCAR_CODIGO_interno(String nomeInterno, String nomeMae) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdInternoCrc, "
                    + "NomeInternoCrc, "
                    + "MaeInternoCrc "
                    + "FROM PRONTUARIOSCRC "
                    + "WHERE NomeInternoCrc='" + nomeInterno + "' "
                    + "AND MaeInternoCrc='" + nomeMae + "'");
            conecta.rs.last();
            codIntCrc = conecta.rs.getInt("IdInternoCrc");
            objProCrc.setIdInterno(codIntCrc);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (FISICOS) a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
