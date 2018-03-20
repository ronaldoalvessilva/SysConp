/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EvolucaoPsiquiatrica;
import gestor.Modelo.MovTecDiagnosticoMedico;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleMovDiagnosticoMedico {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    MovTecDiagnosticoMedico objModTecEM = new MovTecDiagnosticoMedico();
    EvolucaoPsiquiatrica objDiag = new EvolucaoPsiquiatrica();
    String nomeOpeTecnica = "Atendimento do Interno na Enfermaria - (Evolução Psiquiatrica)";
    int codInt;

    // Incluir movimento de diagnóstico da enfermaria
    public EvolucaoPsiquiatrica incluirMovTecDiag(EvolucaoPsiquiatrica objDiag) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO MOVTECNICO (IdInternoCrc,IdAtend,NomeOpe,DataMov,DeptoMov,StatusAtend) VALUES(?,?,?,?,?,?)");
            pst.setInt(1, objDiag.getIdInternoCrc());
            pst.setInt(2, objDiag.getIdLanc());
            pst.setString(3, nomeOpeTecnica);
            pst.setTimestamp(4, new java.sql.Timestamp(objDiag.getDataDiag().getTime()));
            pst.setString(5, objDiag.getDeptoMedicoPsiq());
            pst.setString(6, objDiag.getStatusLanc());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objDiag;
    }

    // Alterar movimento de diagnóstico da enfermaria
    public EvolucaoPsiquiatrica alterarMovTecDiag(EvolucaoPsiquiatrica objDiag) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE MOVTECNICO SET IdInternoCrc=?,IdAtend=?,NomeOpe=?,DataMov=?,DeptoMov=?,StatusAtend=? WHERE IdAtend='" + objDiag.getIdLanc() + "' AND NomeOpe='" + nomeOpeTecnica + "'");
            pst.setInt(1, objDiag.getIdInternoCrc());
            pst.setInt(2, objDiag.getIdLanc());
            pst.setString(3, nomeOpeTecnica);
            pst.setTimestamp(4, new java.sql.Timestamp(objDiag.getDataDiag().getTime()));
            pst.setString(5, objDiag.getDeptoMedicoPsiq());
            pst.setString(6, objDiag.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objDiag;
    }

    // Excluir movimento de diagnóstico da enfermaria
    public EvolucaoPsiquiatrica excluirMovTecDiag(EvolucaoPsiquiatrica objDiag) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM MOVTECNICO WHERE IdAtend='" + objDiag.getIdLanc() + "' AND NomeOpe='" + nomeOpeTecnica + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objDiag;
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
