/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.PrescricaoMedicamentoOdontologica;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControlePrescricaoMedicaOdontologica {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    PrescricaoMedicamentoOdontologica objPrescOdonto = new PrescricaoMedicamentoOdontologica();

    public PrescricaoMedicamentoOdontologica incluirPrescricaoOdontologica(PrescricaoMedicamentoOdontologica objPrescOdonto) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO PRESCRICAO_ODONTOLOGIA (DataPre,IdLanc,IdInternoCrc,TextoPrescricao,UsuarioInsert,DataInsert,HorarioInsert) VALUES (?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objPrescOdonto.getDataPrescricao().getTime()));
            pst.setInt(2, objPrescOdonto.getIdLanc());
            pst.setInt(3, objPrescOdonto.getIdInternoCrc());
            pst.setString(4, objPrescOdonto.getTextoPrescricao());
            pst.setString(5, objPrescOdonto.getUsuarioInsert());
            pst.setString(6, objPrescOdonto.getDataInsert());
            pst.setString(7, objPrescOdonto.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPrescOdonto;
    }

    public PrescricaoMedicamentoOdontologica alterarPrescricaoOdontologica(PrescricaoMedicamentoOdontologica objPrescOdonto) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PRESCRICAO_ODONTOLOGIA SET DataPre=?,IdLanc=?,IdInternoCrc=?,TextoPrescricao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdPre='" + objPrescOdonto.getIdPre() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objPrescOdonto.getDataPrescricao().getTime()));
            pst.setInt(2, objPrescOdonto.getIdLanc());
            pst.setInt(3, objPrescOdonto.getIdInternoCrc());
            pst.setString(4, objPrescOdonto.getTextoPrescricao());
            pst.setString(5, objPrescOdonto.getUsuarioUp());
            pst.setString(6, objPrescOdonto.getDataUp());
            pst.setString(7, objPrescOdonto.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPrescOdonto;
    }

    public PrescricaoMedicamentoOdontologica excluirPrescricaoOdontologica(PrescricaoMedicamentoOdontologica objPrescOdonto) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM PRESCRICAO_ODONTOLOGIA WHERE IdPre='" + objPrescOdonto.getIdPre() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPrescOdonto;
    }
}
