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
public class ControleIndicadoresAcompanhaSS {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    IndicadoresAcompanhamento objPerfilInter = new IndicadoresAcompanhamento();
    int codInt;

    public IndicadoresAcompanhamento incluirIndicadorAcompanhamentoSS(IndicadoresAcompanhamento objPerfilInter) {
        buscarInternoCrc(objPerfilInter.getNomeInternoPerfil(), objPerfilInter.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO "
                    + "INDICADOR_ACOMPANHAMENTO_INTERNO_SS (IdIndAco,IdInternoCrc,DataSS,"
                    + "AcompanhaSS,QtdAcompanha,"
                    + "Observacao,UsuarioInsert,DataInsert,"
                    + "HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objPerfilInter.getIdIndAco());
            pst.setInt(2, codInt);
            pst.setTimestamp(3, new java.sql.Timestamp(objPerfilInter.getDataSS().getTime()));
            pst.setString(4, objPerfilInter.getAcompanhaSS());
            pst.setInt(5, objPerfilInter.getQtdAcompanhaSS());
            pst.setString(6, objPerfilInter.getObservacao());
            pst.setString(7, objPerfilInter.getUsuarioInsert());
            pst.setString(8, objPerfilInter.getDataInsert());
            pst.setString(9, objPerfilInter.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPerfilInter;
    }

    public IndicadoresAcompanhamento alterarIndicadorAcompanhamentoSS(IndicadoresAcompanhamento objPerfilInter) {
        buscarInternoCrc(objPerfilInter.getNomeInternoPerfil(), objPerfilInter.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE INDICADOR_ACOMPANHAMENTO_INTERNO_SS SET IdIndAco=?,IdInternoCrc=?,DataSS=?,AcompanhaSS=?,QtdAcompanha=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdSS='" + objPerfilInter.getIdSS() + "'AND IdIndAco='" + objPerfilInter.getIdIndAco() + "'");
            pst.setInt(1, objPerfilInter.getIdIndAco());
            pst.setInt(2, codInt);
            pst.setTimestamp(3, new java.sql.Timestamp(objPerfilInter.getDataSS().getTime()));
            pst.setString(4, objPerfilInter.getAcompanhaSS());
            pst.setInt(5, objPerfilInter.getQtdAcompanhaSS());
            pst.setString(6, objPerfilInter.getObservacao());
            pst.setString(7, objPerfilInter.getUsuarioUp());
            pst.setString(8, objPerfilInter.getDataUp());
            pst.setString(9, objPerfilInter.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPerfilInter;
    }

    public IndicadoresAcompanhamento excluirIndicadorAcompanhamentoSS(IndicadoresAcompanhamento objPerfilInter) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM INDICADOR_ACOMPANHAMENTO_INTERNO_SS WHERE IdSS='" + objPerfilInter.getIdSS() + "'AND IdIndAco='" + objPerfilInter.getIdIndAco() + "'");
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
