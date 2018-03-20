/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.DietaMedica;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleDietaMedicaPsiquiatrica {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    DietaMedica objDietaMedica = new DietaMedica();

    public DietaMedica incluirDietaMedicaPsiquiatrica(DietaMedica objDietaMedica) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO DIETA_MEDICA_PSIQUIATRICA (DataDieta,IdLanc,IdInternoCrc,TextoDieta,UsuarioInsert,DataInsert,HorarioInsert) VALUES (?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objDietaMedica.getDataDieta().getTime()));
            pst.setInt(2, objDietaMedica.getIdLanc());
            pst.setInt(3, objDietaMedica.getIdInternoCrc());
            pst.setString(4, objDietaMedica.getTextoDieta());
            pst.setString(5, objDietaMedica.getUsuarioInsert());
            pst.setString(6, objDietaMedica.getDataInsert());
            pst.setString(7, objDietaMedica.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objDietaMedica;
    }

    public DietaMedica alterarDietaMedicaPsiquiatrica(DietaMedica objDietaMedica) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE DIETA_MEDICA_PSIQUIATRICA SET DataDieta=?,IdLanc=?,IdInternoCrc=?,TextoDieta=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdLanc='" + objDietaMedica.getIdLanc() + "'AND IdItem='" + objDietaMedica.getIdItem() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objDietaMedica.getDataDieta().getTime()));
            pst.setInt(2, objDietaMedica.getIdLanc());
            pst.setInt(3, objDietaMedica.getIdInternoCrc());
            pst.setString(4, objDietaMedica.getTextoDieta());
            pst.setString(5, objDietaMedica.getUsuarioUp());
            pst.setString(6, objDietaMedica.getDataUp());
            pst.setString(7, objDietaMedica.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objDietaMedica;
    }

    public DietaMedica excluirDietaMedicaPsiquiatrica(DietaMedica objDietaMedica) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM DIETA_MEDICA_PSIQUIATRICA WHERE IdLanc='" + objDietaMedica.getIdLanc() + "'AND IdItem='" + objDietaMedica.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objDietaMedica;
    }

    public DietaMedica finalizarDietaMedicaPsiquiatrica(DietaMedica objDietaMedica) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE DIETA_MEDICA_PSIQUIATRICA SET StatusLanc=? WHERE IdLanc='" + objDietaMedica.getIdLanc() + "'");
            //       pst.setString(1, objDietaMedica.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objDietaMedica;
    }
}
