/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AdmissaoPsicologica;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleParecerPsicologico {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AdmissaoPsicologica objAdmPsi = new AdmissaoPsicologica();
    int codInterno;

    public AdmissaoPsicologica incluirParecerPsi(AdmissaoPsicologica objAdmPsi) {
        buscarInterno(objAdmPsi.getNomeInterno(), objAdmPsi.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO PARECER_PSI (DataParecer,IdLanc,IdInternoCrc,ParecerPsicologico,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objAdmPsi.getDataParecer().getTime()));
            pst.setInt(2, objAdmPsi.getIdLanc());
            pst.setInt(3, codInterno);           
            pst.setString(4, objAdmPsi.getParecerPsicologico());
            pst.setString(5, objAdmPsi.getUsuarioInsert());
            pst.setString(6, objAdmPsi.getDataInsert());
            pst.setString(7, objAdmPsi.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAdmPsi;
    }

    public AdmissaoPsicologica alterarParecerPsi(AdmissaoPsicologica objAdmPsi) {
        buscarInterno(objAdmPsi.getNomeInterno(), objAdmPsi.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PARECER_PSI SET DataParecer=?,IdLanc=?,IdInternoCrc=?,ParecerPsicologico=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdParecer='" + objAdmPsi.getIdParecer() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objAdmPsi.getDataParecer().getTime()));
            pst.setInt(2, objAdmPsi.getIdLanc());
            pst.setInt(3, codInterno); 
            pst.setString(4, objAdmPsi.getParecerPsicologico());
            pst.setString(5, objAdmPsi.getUsuarioUp());
            pst.setString(6, objAdmPsi.getDataUp());
            pst.setString(7, objAdmPsi.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAdmPsi;
    }

    public AdmissaoPsicologica excluirParecerPsi(AdmissaoPsicologica objAdmPsi) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM PARECER_PSI WHERE IdParecer='" + objAdmPsi.getIdParecer() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAdmPsi;
    }

    public void buscarInterno(String desc, int codigoInterno) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + desc + "'AND IdInternoCrc='" + codigoInterno + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível pesquisar o interno.\nERRO: " + ex);
        }
    }
}
