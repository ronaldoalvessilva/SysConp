/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EvolucaoMedica;
import gestor.Modelo.MovTecEvolucaoMedica;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleMovEvolucaoMedica {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    MovTecEvolucaoMedica objModTecEM = new MovTecEvolucaoMedica();
    EvolucaoMedica objEvolMedica = new EvolucaoMedica();
    String nomeOpeTecnica = "Atendimento do Interno na Enfermaria - (Evolução Médica)";
    int codInt;

    // Incluir movimento do serviço social

    public EvolucaoMedica incluirMovTec(EvolucaoMedica objEvolMedica) {
       
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO MOVTECNICO (IdInternoCrc,IdAtend,NomeOpe,DataMov,DeptoMov,StatusAtend) VALUES(?,?,?,?,?,?)");
            pst.setInt(1, objEvolMedica.getIdInternoCrc());
            pst.setInt(2, objEvolMedica.getIdLanc());
            pst.setString(3, nomeOpeTecnica);
            pst.setTimestamp(4, new java.sql.Timestamp(objEvolMedica.getDataEvolu().getTime()));
            pst.setString(5, objEvolMedica.getDeptoMedico());
            pst.setString(6, objEvolMedica.getStatusLanc());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEvolMedica;
    }

    // Alterar movimento do serviço social 
    public EvolucaoMedica alterarMovTec(EvolucaoMedica objEvolMedica) {
       
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE MOVTECNICO SET IdInternoCrc=?,IdAtend=?,NomeOpe=?,DataMov=?,DeptoMov=?,StatusAtend=? WHERE IdAtend='" + objEvolMedica.getIdLanc() + "' AND NomeOpe='" + nomeOpeTecnica + "'");
            pst.setInt(1, objEvolMedica.getIdInternoCrc());
            pst.setInt(2, objEvolMedica.getIdLanc());
            pst.setString(3, nomeOpeTecnica);
            pst.setTimestamp(4, new java.sql.Timestamp(objEvolMedica.getDataEvolu().getTime()));
            pst.setString(5, objEvolMedica.getDeptoMedico());
            pst.setString(6, objEvolMedica.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEvolMedica;
    }   

    // Excluir movimento do serviço social 
    public EvolucaoMedica excluirMovTec(EvolucaoMedica objEvolMedica) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM MOVTECNICO WHERE IdAtend='" + objEvolMedica.getIdLanc() + "' AND NomeOpe='" + nomeOpeTecnica + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEvolMedica;
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
