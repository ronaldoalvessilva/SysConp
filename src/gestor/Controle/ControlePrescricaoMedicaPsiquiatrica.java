/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.PrescricaoMedicaPsiquiatrica;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControlePrescricaoMedicaPsiquiatrica {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    PrescricaoMedicaPsiquiatrica objPrescricao = new PrescricaoMedicaPsiquiatrica();

    public PrescricaoMedicaPsiquiatrica incluirPrescricaoMedica(PrescricaoMedicaPsiquiatrica objPrescricao) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO PRESCRICAO_MEDICA_PSIQUIATRICA (DataPres,IdLanc,IdInternoCrc,TipoP,TextoPrescricao,UsuarioInsert,DataInsert,HorarioInsert) VALUES (?,?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objPrescricao.getDataPrescricao().getTime()));
            pst.setInt(2, objPrescricao.getIdLanc());
            pst.setInt(3, objPrescricao.getIdInternoCrc());
            pst.setInt(4, objPrescricao.getTipoPrescricaoMedica());
            pst.setString(5, objPrescricao.getTextoPrescricao());
            pst.setString(6, objPrescricao.getUsuarioInsert());
            pst.setString(7, objPrescricao.getDataInsert());
            pst.setString(8, objPrescricao.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objPrescricao;
    }

    public PrescricaoMedicaPsiquiatrica alterarPrescricaoMedica(PrescricaoMedicaPsiquiatrica objPrescricao) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PRESCRICAO_MEDICA_PSIQUIATRICA SET DataPres=?,IdLanc=?,IdInternoCrc=?,TipoP=?,TextoPrescricao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdLanc='" + objPrescricao.getIdLanc() + "'AND IdItem='" + objPrescricao.getIdItem() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objPrescricao.getDataPrescricao().getTime()));
            pst.setInt(2, objPrescricao.getIdLanc());
            pst.setInt(3, objPrescricao.getIdInternoCrc());
            pst.setInt(4, objPrescricao.getTipoPrescricaoMedica());
            pst.setString(5, objPrescricao.getTextoPrescricao());
            pst.setString(6, objPrescricao.getUsuarioUp());
            pst.setString(7, objPrescricao.getDataUp());
            pst.setString(8, objPrescricao.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objPrescricao;
    }

    public PrescricaoMedicaPsiquiatrica alterarPrescricaoOdontolica(PrescricaoMedicaPsiquiatrica objPrescricao) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PRESCRICAO_MEDICA_PSIQUIATRICA SET DataPres=?,IdLanc=?,IdInternoCrc=?,TipoP=?,TextoPrescricao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdLanc='" + objPrescricao.getIdLanc() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objPrescricao.getDataPrescricao().getTime()));
            pst.setInt(2, objPrescricao.getIdLanc());
            pst.setInt(3, objPrescricao.getIdInternoCrc());
            pst.setInt(4, objPrescricao.getTipoPrescricaoMedica());
            pst.setString(5, objPrescricao.getTextoPrescricao());
            pst.setString(6, objPrescricao.getUsuarioUp());
            pst.setString(7, objPrescricao.getDataUp());
            pst.setString(8, objPrescricao.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPrescricao;
    }

    public PrescricaoMedicaPsiquiatrica excluirPrescricaoMedica(PrescricaoMedicaPsiquiatrica objPrescricao) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM PRESCRICAO_MEDICA_PSIQUIATRICA WHERE IdLanc='" + objPrescricao.getIdLanc() + "'AND IdItem='" + objPrescricao.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objPrescricao;
    }

    public PrescricaoMedicaPsiquiatrica excluirPrescricaoOdontologica(PrescricaoMedicaPsiquiatrica objPrescricao) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM PRESCRICAO_MEDICA_PSIQUIATRICA WHERE IdLanc='" + objPrescricao.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objPrescricao;
    }

    public PrescricaoMedicaPsiquiatrica finalizarPrescricaoMedica(PrescricaoMedicaPsiquiatrica objPrescricao) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PRESCRICAO_MEDICA_PSIQUIATRICA SET StatusLanc=? WHERE IdLanc='" + objPrescricao.getIdLanc() + "'");
            pst.setString(1, objPrescricao.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objPrescricao;
    }
}
