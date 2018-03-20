/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.DietaMedica;
import gestor.Modelo.MovTecDietaMedicaPsiquiatrica;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleMovDietaMedicaPsiquiatrica {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    MovTecDietaMedicaPsiquiatrica objModTecEM = new MovTecDietaMedicaPsiquiatrica();
    DietaMedica objDietaMedica = new DietaMedica();
    String nomeOpeTecnica = "Atendimento do Interno na Enfermaria - (Dieta Médica/Psiquiatrica)";
    int codInt;

    // Incluir movimento do serviço social
    public DietaMedica incluirMovTecDieta(DietaMedica objDietaMedica) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO MOVTECNICO (IdInternoCrc,IdAtend,NomeOpe,DataMov,DeptoMov,StatusAtend) VALUES(?,?,?,?,?,?)");
            pst.setInt(1, objDietaMedica.getIdInternoCrc());
            pst.setInt(2, objDietaMedica.getIdLanc());
            pst.setString(3, nomeOpeTecnica);
            pst.setTimestamp(4, new java.sql.Timestamp(objDietaMedica.getDataDieta().getTime()));
            pst.setString(5, objDietaMedica.getDeptoMedico());
            pst.setString(6, objDietaMedica.getStatusLanc());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objDietaMedica;
    }

    // Alterar movimento do serviço social 
    public DietaMedica alterarMovTecDieta(DietaMedica objDietaMedica) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE MOVTECNICO SET IdInternoCrc=?,IdAtend=?,NomeOpe=?,DataMov=?,DeptoMov=?,StatusAtend=? WHERE IdAtend='" + objDietaMedica.getIdLanc() + "' AND NomeOpe='" + nomeOpeTecnica + "'");
            pst.setInt(1, objDietaMedica.getIdInternoCrc());
            pst.setInt(2, objDietaMedica.getIdLanc());
            pst.setString(3, nomeOpeTecnica);
            pst.setTimestamp(4, new java.sql.Timestamp(objDietaMedica.getDataDieta().getTime()));
            pst.setString(5, objDietaMedica.getDeptoMedico());
            pst.setString(6, objDietaMedica.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objDietaMedica;
    }

    // Excluir movimento do serviço social 
    public DietaMedica excluirMovTecDieta(DietaMedica objDietaMedica) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM MOVTECNICO WHERE IdAtend='" + objDietaMedica.getIdLanc() + "' AND NomeOpe='" + nomeOpeTecnica + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objDietaMedica;
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
