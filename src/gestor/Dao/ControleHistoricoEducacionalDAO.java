/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Dao;

import gestor.Modelo.HistoricoEducacionalLaboral;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleHistoricoEducacionalDAO {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    HistoricoEducacionalLaboral objHistEducLabor = new HistoricoEducacionalLaboral();

    int codInterno;

    public HistoricoEducacionalLaboral incluirHistoricoEduca(HistoricoEducacionalLaboral objHistEducLabor) {
        buscarInterno(objHistEducLabor.getNomeInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO TO_HISTORICO_EDUCACIONAL_NOVO (IdATN,IdInternoCrc,EscreveProprioNome,SabeLerEscrever,NivelInstrucao,InteresseEstudar,CursoProfissionalizante,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objHistEducLabor.getIdATN());
            pst.setInt(2, codInterno);
            pst.setString(3, objHistEducLabor.getEscreveProprioNome());
            pst.setString(4, objHistEducLabor.getSabeLerEscrever());
            pst.setString(5, objHistEducLabor.getNivelInstrucao());
            pst.setString(6, objHistEducLabor.getInteresseEstudar());
            pst.setString(7, objHistEducLabor.getCursoProfissionalizante());
            pst.setString(8, objHistEducLabor.getUsuarioInsert());
            pst.setString(9, objHistEducLabor.getDataInsert());
            pst.setString(10, objHistEducLabor.getHorarioInsert());
            pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados. (TO_HISTORICO_EDUCACIONAL_NOVO)\nERRO: " + e);
        }
        conecta.desconecta();
        return objHistEducLabor;
    }

    public HistoricoEducacionalLaboral alterarHistoricoEduca(HistoricoEducacionalLaboral objHistEducLabor) {
        buscarInterno(objHistEducLabor.getNomeInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE TO_HISTORICO_EDUCACIONAL_NOVO SET IdATN=?,IdInternoCrc=?,EscreveProprioNome=?,SabeLerEscrever=?,NivelInstrucao=?,InteresseEstudar=?,CursoProfissionalizante=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdHistoricoEduN='" + objHistEducLabor.getIdHistoricoEduN()+ "'");
            pst.setInt(1, objHistEducLabor.getIdATN());
            pst.setInt(2, codInterno);
            pst.setString(3, objHistEducLabor.getEscreveProprioNome());
            pst.setString(4, objHistEducLabor.getSabeLerEscrever());
            pst.setString(5, objHistEducLabor.getNivelInstrucao());
            pst.setString(6, objHistEducLabor.getInteresseEstudar());
            pst.setString(7, objHistEducLabor.getCursoProfissionalizante());
            pst.setString(8, objHistEducLabor.getUsuarioUp());
            pst.setString(9, objHistEducLabor.getDataUp());
            pst.setString(10, objHistEducLabor.getHorarioUp());
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados. (TO_HISTORICO_EDUCACIONAL_NOVO)\nERRO: " + e);
        }
        conecta.desconecta();
        return objHistEducLabor;
    }

    public HistoricoEducacionalLaboral excluirHistoricoEduca(HistoricoEducacionalLaboral objHistEducLabor) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM TO_HISTORICO_EDUCACIONAL_NOVO WHERE IdHistoricoEduN='" + objHistEducLabor.getIdHistoricoEduN()+ "'");
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados. (TO_HISTORICO_EDUCACIONAL_NOVO)\nERRO: " + e);
        }
        conecta.desconecta();
        return objHistEducLabor;
    }

    public void buscarInterno(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + desc + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível pesquisar o interno.\nERRO: " + ex);
        }
    }
}
