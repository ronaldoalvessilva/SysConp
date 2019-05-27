/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.IndicadoresAcompanhamento;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Socializa TI 02
 */
public class ControleIndicadoresAcompanhaJuridicoCrc {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    IndicadoresAcompanhamento objPerfilInter = new IndicadoresAcompanhamento();
    int codInt;

    public IndicadoresAcompanhamento incluirIndicadorAcompanhamentoCrc(IndicadoresAcompanhamento objPerfilInter) {
        buscarInternoCrc(objPerfilInter.getNomeInternoPerfil(), objPerfilInter.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO "
                    + "INDICADOR_ACOMPANHAMENTO_INTERNO_JURIDICO_CRC (IdIndAco,IdInternoCrc,DataJurCrc,"
                    + "Processos,QtdProgresso,Documentacao,QtdDocumentacao,Progressao,QtdProgressao,Livramento,QtdLivramento,"
                    + "Observacao,UsuarioInsert,DataInsert,"
                    + "HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objPerfilInter.getIdIndAco());
            pst.setInt(2, codInt);
            pst.setTimestamp(3, new java.sql.Timestamp(objPerfilInter.getDataJurCrc().getTime()));
            pst.setString(4, objPerfilInter.getProcessos());
            pst.setInt(5, objPerfilInter.getQtdProgresso());
            pst.setString(6, objPerfilInter.getDocumentacao());
            pst.setInt(7, objPerfilInter.getQtdDocumentacao());
            pst.setString(8, objPerfilInter.getProgressao());
            pst.setInt(9, objPerfilInter.getQtdProgressao());
            pst.setString(10, objPerfilInter.getLivramento());
            pst.setInt(11, objPerfilInter.getQtdLivramento());           
            pst.setString(12, objPerfilInter.getObservacaoCrc());
            pst.setString(13, objPerfilInter.getUsuarioInsert());
            pst.setString(14, objPerfilInter.getDataInsert());
            pst.setString(15, objPerfilInter.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPerfilInter;
    }

    public IndicadoresAcompanhamento alterarIndicadorAcompanhamentoCrc(IndicadoresAcompanhamento objPerfilInter) {
        buscarInternoCrc(objPerfilInter.getNomeInternoPerfil(), objPerfilInter.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE INDICADOR_ACOMPANHAMENTO_INTERNO_JURIDICO_CRC SET IdIndAco=?,IdInternoCrc=?,DataJurCrc=?,Processos=?,QtdProgresso=?,Documentacao=?,QtdDocumentacao=?,Progressao=?,QtdProgressao=?,Livramento=?,QtdLivramento=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdJurCrc='" + objPerfilInter.getIdJurCrc()+ "'AND IdIndAco='" + objPerfilInter.getIdIndAco() + "'");
            pst.setInt(1, objPerfilInter.getIdIndAco());
            pst.setInt(2, codInt);
            pst.setTimestamp(3, new java.sql.Timestamp(objPerfilInter.getDataJurCrc().getTime()));
            pst.setString(4, objPerfilInter.getProcessos());
            pst.setInt(5, objPerfilInter.getQtdProgresso());
            pst.setString(6, objPerfilInter.getDocumentacao());
            pst.setInt(7, objPerfilInter.getQtdDocumentacao());
            pst.setString(8, objPerfilInter.getProgressao());
            pst.setInt(9, objPerfilInter.getQtdProgressao());
            pst.setString(10, objPerfilInter.getLivramento());
            pst.setInt(11, objPerfilInter.getQtdLivramento());           
            pst.setString(12, objPerfilInter.getObservacaoCrc());
            pst.setString(13, objPerfilInter.getUsuarioUp());
            pst.setString(14, objPerfilInter.getDataUp());
            pst.setString(15, objPerfilInter.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPerfilInter;
    }

    public IndicadoresAcompanhamento excluirIndicadorAcompanhamentoCrc(IndicadoresAcompanhamento objPerfilInter) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM INDICADOR_ACOMPANHAMENTO_INTERNO_JURIDICO_CRC WHERE IdJurCrc='" + objPerfilInter.getIdJurCrc()+ "'AND IdIndAco='" + objPerfilInter.getIdIndAco() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPerfilInter;
    }

    public void buscarInternoCrc(String desc, int cod) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE NomeInternoCrc='" + desc + "' "
                    + "AND IdInternoCrc='" + cod + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNOS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
