/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AdmissaoMedica;
import gestor.Modelo.MovTecMedico;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleMovMedico {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    MovTecMedico objMovTec = new MovTecMedico();
    AdmissaoMedica objAdmMedico = new AdmissaoMedica();
    String nomeOpeTecnica = "Atendimento do Interno na Enfermaria - (Admissão)";
    int codInt;

    // Incluir movimento do serviço social
    public AdmissaoMedica incluirMovTec(AdmissaoMedica objAdmMedico) {
        buscarInternoCrc(objAdmMedico.getNomeInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO MOVTECNICO (IdInternoCrc,IdAtend,NomeOpe,DataMov,DeptoMov,StatusAtend) VALUES(?,?,?,?,?,?)");
            pst.setInt(1, codInt);
            pst.setInt(2, objAdmMedico.getIdLanc());
            pst.setString(3, nomeOpeTecnica);
            pst.setTimestamp(4, new java.sql.Timestamp(objAdmMedico.getDataLanc().getTime()));
            pst.setString(5, objAdmMedico.getDeptoMedico());
            pst.setString(6, objAdmMedico.getStatusLanc());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAdmMedico;
    }

    // Alterar movimento do serviço social 
    public AdmissaoMedica alterarMovTec(AdmissaoMedica objAdmMedico) {
        buscarInternoCrc(objAdmMedico.getNomeInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE MOVTECNICO SET IdInternoCrc=?,IdAtend=?,NomeOpe=?,DataMov=?,DeptoMov=?,StatusAtend=? WHERE IdAtend='" + objAdmMedico.getIdLanc() + "' AND NomeOpe='" + nomeOpeTecnica + "'");
            pst.setInt(1, codInt);
            pst.setInt(2, objAdmMedico.getIdLanc());
            pst.setString(3, nomeOpeTecnica);
            pst.setTimestamp(4, new java.sql.Timestamp(objAdmMedico.getDataLanc().getTime()));
            pst.setString(5, objAdmMedico.getDeptoMedico());
            pst.setString(6, objAdmMedico.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAdmMedico;
    }

    public AdmissaoMedica finalizarMovTec(AdmissaoMedica objAdmMedico) {
        //  buscarInternoCrc(objAdmPsi.getNomeInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE MOVTECNICO SET StatusAtend=? WHERE IdAtend='" + objAdmMedico.getIdLanc() + "' AND NomeOpe='" + nomeOpeTecnica + "'");
            pst.setString(1, objAdmMedico.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR na tabela MOVIMENTO TÉCNICO os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAdmMedico;
    }

    // Excluir movimento do serviço social 
    public AdmissaoMedica excluirMovTec(AdmissaoMedica objAdmMedico) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM MOVTECNICO WHERE IdAtend='" + objAdmMedico.getIdLanc() + "' AND NomeOpe='" + nomeOpeTecnica + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAdmMedico;
    }

    // Buscar o nome do interno
    public void buscarInternoCrc(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + desc + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNOS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
