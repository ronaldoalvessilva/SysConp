/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.MovTecPrescricaMedicaPsiquiatrico;
import gestor.Modelo.PrescricaoMedicaPsiquiatrica;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleMovPrescricaoMedicaPsiquiatrica {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    MovTecPrescricaMedicaPsiquiatrico objModTecEM = new MovTecPrescricaMedicaPsiquiatrico();
    PrescricaoMedicaPsiquiatrica objPrescricao = new PrescricaoMedicaPsiquiatrica();
    String nomeOpeTecnica = "Atendimento do Interno na Enfermaria - (Prescrição Médica/Psiquiatrica)";
    int codInt;

    // Incluir movimento do serviço social

    public PrescricaoMedicaPsiquiatrica incluirMovTecPrescricao(PrescricaoMedicaPsiquiatrica objPrescricao) {
       
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO MOVTECNICO (IdInternoCrc,IdAtend,NomeOpe,DataMov,DeptoMov,StatusAtend) VALUES(?,?,?,?,?,?)");
            pst.setInt(1, objPrescricao.getIdInternoCrc());
            pst.setInt(2, objPrescricao.getIdLanc());
            pst.setString(3, nomeOpeTecnica);
            pst.setTimestamp(4, new java.sql.Timestamp(objPrescricao.getDataPrescricao().getTime()));
            pst.setString(5, objPrescricao.getDeptoMedico());
            pst.setString(6, objPrescricao.getStatusLanc());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objPrescricao;
    }

    // Alterar movimento do serviço social 
    public PrescricaoMedicaPsiquiatrica alterarMovTecPrescricao(PrescricaoMedicaPsiquiatrica objPrescricao) {
       
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE MOVTECNICO SET IdInternoCrc=?,IdAtend=?,NomeOpe=?,DataMov=?,DeptoMov=?,StatusAtend=? WHERE IdAtend='" + objPrescricao.getIdLanc() + "' AND NomeOpe='" + nomeOpeTecnica + "'");
            pst.setInt(1, objPrescricao.getIdInternoCrc());
            pst.setInt(2, objPrescricao.getIdLanc());
            pst.setString(3, nomeOpeTecnica);
            pst.setTimestamp(4, new java.sql.Timestamp(objPrescricao.getDataPrescricao().getTime()));
            pst.setString(5, objPrescricao.getDeptoMedico());
            pst.setString(6, objPrescricao.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objPrescricao;
    }   

    // Excluir movimento do serviço social 
    public PrescricaoMedicaPsiquiatrica excluirMovTecPrescricao(PrescricaoMedicaPsiquiatrica objPrescricao) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM MOVTECNICO WHERE IdAtend='" + objPrescricao.getIdLanc() + "' AND NomeOpe='" + nomeOpeTecnica + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objPrescricao;
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
