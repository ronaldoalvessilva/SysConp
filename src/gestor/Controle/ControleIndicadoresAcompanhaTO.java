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
public class ControleIndicadoresAcompanhaTO {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    IndicadoresAcompanhamento objPerfilInter = new IndicadoresAcompanhamento();
    int codInt;

    public IndicadoresAcompanhamento incluirIndicadorAcompanhamentoTO(IndicadoresAcompanhamento objPerfilInter) {
        buscarInternoCrc(objPerfilInter.getNomeInternoPerfil(), objPerfilInter.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO "
                    + "INDICADOR_ACOMPANHAMENTO_INTERNO_TO (IdIndAco,IdInternoCrc,DataTo,"
                    + "Programa,Qtdprograma,Curso,QtdCurso,Profissional,QtdProfissional,"
                    + "Observacao,UsuarioInsert,DataInsert,"
                    + "HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objPerfilInter.getIdIndAco());
            pst.setInt(2, codInt);
            pst.setTimestamp(3, new java.sql.Timestamp(objPerfilInter.getDataTo().getTime()));
            pst.setString(4, objPerfilInter.getPrograma());
            pst.setInt(5, objPerfilInter.getQtdprograma());
            pst.setString(6, objPerfilInter.getCurso());
            pst.setInt(7, objPerfilInter.getQtdCurso());
            pst.setString(8, objPerfilInter.getProfissional());
            pst.setInt(9, objPerfilInter.getQtdProfissional());              
            pst.setString(10, objPerfilInter.getObservacaoTo());
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

    public IndicadoresAcompanhamento alterarIndicadorAcompanhamentoTO(IndicadoresAcompanhamento objPerfilInter) {
        buscarInternoCrc(objPerfilInter.getNomeInternoPerfil(), objPerfilInter.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE INDICADOR_ACOMPANHAMENTO_INTERNO_TO SET IdIndAco=?,IdInternoCrc=?,DataTo=?,Programa=?,Qtdprograma=?,Curso=?,QtdCurso=?,Profissional=?,QtdProfissional=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdTo='" + objPerfilInter.getIdTo()+ "'AND IdIndAco='" + objPerfilInter.getIdIndAco() + "'");
            pst.setInt(1, objPerfilInter.getIdIndAco());
            pst.setInt(2, codInt);
            pst.setTimestamp(3, new java.sql.Timestamp(objPerfilInter.getDataTo().getTime()));
            pst.setString(4, objPerfilInter.getPrograma());
            pst.setInt(5, objPerfilInter.getQtdprograma());
            pst.setString(6, objPerfilInter.getCurso());
            pst.setInt(7, objPerfilInter.getQtdCurso());
            pst.setString(8, objPerfilInter.getProfissional());
            pst.setInt(9, objPerfilInter.getQtdProfissional());              
            pst.setString(10, objPerfilInter.getObservacaoTo());
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

    public IndicadoresAcompanhamento excluirIndicadorAcompanhamentoTO(IndicadoresAcompanhamento objPerfilInter) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM INDICADOR_ACOMPANHAMENTO_INTERNO_TO WHERE IdTo='" + objPerfilInter.getIdTo()+ "'AND IdIndAco='" + objPerfilInter.getIdIndAco() + "'");
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
