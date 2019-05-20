/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.IndicadoresAcompanhamento;
import gestor.Modelo.PerfilCarcerarioInterno;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleIndicadoresAcompanhamento {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    IndicadoresAcompanhamento objPerfilInter = new IndicadoresAcompanhamento();
    int codInt;

    public IndicadoresAcompanhamento incluirIndicadorAcompanhamento(IndicadoresAcompanhamento objPerfilInter) {
        buscarInternoCrc(objPerfilInter.getNomeInternoPerfil(), objPerfilInter.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO INDICADOR_ACOMPANHAMENTO_INTERNO (StatusPerfil,DataPerfil,IdInternoCrc,ObservacaoPerfil,UsuarioInsert,DataInsert,HorarioInsert,OpcaoSexual,AnoNasc,AnoRef,MesRef) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objPerfilInter.getStatusPerfil());
            pst.setTimestamp(2, new java.sql.Timestamp(objPerfilInter.getDataPerfil().getTime()));
            pst.setInt(3, codInt);
            pst.setString(4, objPerfilInter.getObservacaoPerfil());
            pst.setString(5, objPerfilInter.getUsuarioInsert());
            pst.setString(6, objPerfilInter.getDataInsert());
            pst.setString(7, objPerfilInter.getHorarioInsert());
            pst.setString(8, objPerfilInter.getOpcaoSexual());
            pst.setInt(9, objPerfilInter.getAnoNascimento());
            pst.setInt(10, objPerfilInter.getAnoReferencia());
            pst.setString(10, objPerfilInter.getMesReferencia());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPerfilInter;
    }

    public IndicadoresAcompanhamento alterarIndicadorAcompanhamento(IndicadoresAcompanhamento objPerfilInter) {
        buscarInternoCrc(objPerfilInter.getNomeInternoPerfil(), objPerfilInter.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE INDICADOR_ACOMPANHAMENTO_INTERNO SET StatusPerfil=?,DataPerfil=?,IdInternoCrc=?,ObservacaoPerfil=?,UsuarioUp=?,DataUp=?,HorarioUp=?,OpcaoSexual=?,AnoNasc=?,AnoRef=? WHERE IdPerfil='" + objPerfilInter.getIdIndAco()+ "'");
            pst.setString(1, objPerfilInter.getStatusPerfil());
            pst.setTimestamp(2, new java.sql.Timestamp(objPerfilInter.getDataPerfil().getTime()));
            pst.setInt(3, codInt);
            pst.setString(4, objPerfilInter.getObservacaoPerfil());
            pst.setString(5, objPerfilInter.getUsuarioUp());
            pst.setString(6, objPerfilInter.getDataUp());
            pst.setString(7, objPerfilInter.getHorarioUp());
            pst.setString(8, objPerfilInter.getOpcaoSexual());
            pst.setInt(9, objPerfilInter.getAnoNascimento());
            pst.setInt(10, objPerfilInter.getAnoReferencia());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPerfilInter;
    }

    public IndicadoresAcompanhamento excluirIndicadorAcompanhamento(IndicadoresAcompanhamento objPerfilInter) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM INDICADOR_ACOMPANHAMENTO_INTERNO WHERE IdPerfil='" + objPerfilInter.getIdIndAco() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPerfilInter;
    }

    public IndicadoresAcompanhamento finalizarIndicadorAcompanhamento(IndicadoresAcompanhamento objPerfilInter) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE INDICADOR_ACOMPANHAMENTO_INTERNO SET StatusPerfil=? WHERE IdPerfil='" + objPerfilInter.getIdIndAco() + "'");
            pst.setString(1, objPerfilInter.getStatusPerfil());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPerfilInter;
    }

    public IndicadoresAcompanhamento finalizarTodosIndicadorAcompanhamento(IndicadoresAcompanhamento objPerfilInter) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE INDICADOR_ACOMPANHAMENTO_INTERNO SET StatusPerfil=?");
            pst.setString(1, objPerfilInter.getStatusPerfil());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados.\n\nERRO: " + ex);
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
