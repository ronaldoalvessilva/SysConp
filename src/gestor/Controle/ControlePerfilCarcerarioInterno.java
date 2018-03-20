/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.PerfilCarcerarioInterno;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControlePerfilCarcerarioInterno {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    PerfilCarcerarioInterno objPerfilInter = new PerfilCarcerarioInterno();
    int codInt;

    public PerfilCarcerarioInterno incluirPerfilCarcerarioInterno(PerfilCarcerarioInterno objPerfilInter) {
        buscarInternoCrc(objPerfilInter.getNomeInternoPerfil(), objPerfilInter.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO PERFIL_CARCERARIO_INTERNO (StatusPerfil,DataPerfil,IdInternoCrc,ObservacaoPerfil,UsuarioInsert,DataInsert,HorarioInsert,OpcaoSexual,AnoNasc,AnoRef) VALUES(?,?,?,?,?,?,?,?,?,?)");
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
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPerfilInter;
    }

    public PerfilCarcerarioInterno alterarPerfilCarcerarioInterno(PerfilCarcerarioInterno objPerfilInter) {
        buscarInternoCrc(objPerfilInter.getNomeInternoPerfil(), objPerfilInter.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PERFIL_CARCERARIO_INTERNO SET StatusPerfil=?,DataPerfil=?,IdInternoCrc=?,ObservacaoPerfil=?,UsuarioUp=?,DataUp=?,HorarioUp=?,OpcaoSexual=?,AnoNasc=?,AnoRef=? WHERE IdPerfil='" + objPerfilInter.getIdPerfil() + "'");
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

    public PerfilCarcerarioInterno excluirPerfilCarcerarioInterno(PerfilCarcerarioInterno objPerfilInter) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM PERFIL_CARCERARIO_INTERNO WHERE IdPerfil='" + objPerfilInter.getIdPerfil() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPerfilInter;
    }

    public PerfilCarcerarioInterno finalizarPerfilCarcerarioInterno(PerfilCarcerarioInterno objPerfilInter) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PERFIL_CARCERARIO_INTERNO SET StatusPerfil=? WHERE IdPerfil='" + objPerfilInter.getIdPerfil() + "'");
            pst.setString(1, objPerfilInter.getStatusPerfil());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPerfilInter;
    }

    public PerfilCarcerarioInterno finalizarTodosPerfilCarcerarioInterno(PerfilCarcerarioInterno objPerfilInter) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PERFIL_CARCERARIO_INTERNO SET StatusPerfil=?");
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
