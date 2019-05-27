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
public class ControleIndicadoresAcompanhaPSI {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    IndicadoresAcompanhamento objPerfilInter = new IndicadoresAcompanhamento();
    int codInt;

    public IndicadoresAcompanhamento incluirIndicadorAcompanhamentoPSI(IndicadoresAcompanhamento objPerfilInter) {
        buscarInternoCrc(objPerfilInter.getNomeInternoPerfil(), objPerfilInter.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO "
                    + "INDICADOR_ACOMPANHAMENTO_INTERNO_PSI (IdIndAco,IdInternoCrc,DataPsi,"
                    + "Tratamento,QtdTratamento,Acompanha,QtdAcompanha,Recuperacao,QtdRecuperacao,"
                    + "Observacao,UsuarioInsert,DataInsert,"
                    + "HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objPerfilInter.getIdIndAco());
            pst.setInt(2, codInt);
            pst.setTimestamp(3, new java.sql.Timestamp(objPerfilInter.getDataPsi().getTime()));
            pst.setString(4, objPerfilInter.getTratamento());
            pst.setInt(5, objPerfilInter.getQtdTratamento());
            pst.setString(6, objPerfilInter.getAcompanha());
            pst.setInt(7, objPerfilInter.getQtdAcompanha());
            pst.setString(8, objPerfilInter.getRecuparacao());
            pst.setInt(9, objPerfilInter.getQtdRecuparacao());
            pst.setString(10, objPerfilInter.getObservacaoPsi());
            pst.setString(11, objPerfilInter.getUsuarioInsert());
            pst.setString(12, objPerfilInter.getDataInsert());
            pst.setString(13, objPerfilInter.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPerfilInter;
    }

    public IndicadoresAcompanhamento alterarIndicadorAcompanhamentoPSI(IndicadoresAcompanhamento objPerfilInter) {
        buscarInternoCrc(objPerfilInter.getNomeInternoPerfil(), objPerfilInter.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE INDICADOR_ACOMPANHAMENTO_INTERNO_PSI SET IdIndAco=?,IdInternoCrc=?,DataPsi=?,Tratamento=?,QtdTratamento=?,Acompanha=?,QtdAcompanha=?,Recuperacao=?,QtdRecuperacao=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdPsi='" + objPerfilInter.getIdPsi() + "'AND IdIndAco='" + objPerfilInter.getIdIndAco() + "'");
            pst.setInt(1, objPerfilInter.getIdIndAco());
            pst.setInt(2, codInt);
            pst.setTimestamp(3, new java.sql.Timestamp(objPerfilInter.getDataPsi().getTime()));
            pst.setString(4, objPerfilInter.getTratamento());
            pst.setInt(5, objPerfilInter.getQtdTratamento());
            pst.setString(6, objPerfilInter.getAcompanha());
            pst.setInt(7, objPerfilInter.getQtdAcompanha());
            pst.setString(8, objPerfilInter.getRecuparacao());
            pst.setInt(9, objPerfilInter.getQtdRecuparacao());
            pst.setString(10, objPerfilInter.getObservacaoPsi());
            pst.setString(11, objPerfilInter.getUsuarioUp());
            pst.setString(12, objPerfilInter.getDataUp());
            pst.setString(13, objPerfilInter.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPerfilInter;
    }

    public IndicadoresAcompanhamento excluirIndicadorAcompanhamentoPSI(IndicadoresAcompanhamento objPerfilInter) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM INDICADOR_ACOMPANHAMENTO_INTERNO_PSI WHERE IdPsi='" + objPerfilInter.getIdPsi() + "'AND IdIndAco='" + objPerfilInter.getIdIndAco() + "'");
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
