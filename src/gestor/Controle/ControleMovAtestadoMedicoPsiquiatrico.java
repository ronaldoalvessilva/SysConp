/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AtestadoMedicoPsiquiatrico;
import gestor.Modelo.MovTecAtestadoMedicoPsiquiatrico;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleMovAtestadoMedicoPsiquiatrico {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    MovTecAtestadoMedicoPsiquiatrico objModTecEM = new MovTecAtestadoMedicoPsiquiatrico();
    AtestadoMedicoPsiquiatrico objAtestado = new AtestadoMedicoPsiquiatrico();
    String nomeOpeTecnica = "Atendimento do Interno na Enfermaria - (Atestado Médico/Psiquiatrico)";
    int codInt;

    // Incluir movimento do serviço social
    public AtestadoMedicoPsiquiatrico incluirMovTecAtestado(AtestadoMedicoPsiquiatrico objAtestado) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO MOVTECNICO (IdInternoCrc,IdAtend,NomeOpe,DataMov,DeptoMov,StatusAtend) VALUES(?,?,?,?,?,?)");
            pst.setInt(1, objAtestado.getIdInternoCrc());
            pst.setInt(2, objAtestado.getIdLanc());
            pst.setString(3, nomeOpeTecnica);
            pst.setTimestamp(4, new java.sql.Timestamp(objAtestado.getDataAtesta().getTime()));
            pst.setString(5, objAtestado.getDeptoMedico());
            pst.setString(6, objAtestado.getStatusLanc());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAtestado;
    }

    // Alterar movimento do serviço social 
    public AtestadoMedicoPsiquiatrico alterarMovTecAtestado(AtestadoMedicoPsiquiatrico objAtestado) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE MOVTECNICO SET IdInternoCrc=?,IdAtend=?,NomeOpe=?,DataMov=?,DeptoMov=?,StatusAtend=? WHERE IdAtend='" + objAtestado.getIdLanc() + "' AND NomeOpe='" + nomeOpeTecnica + "'");
            pst.setInt(1, objAtestado.getIdInternoCrc());
            pst.setInt(2, objAtestado.getIdLanc());
            pst.setString(3, nomeOpeTecnica);
            pst.setTimestamp(4, new java.sql.Timestamp(objAtestado.getDataAtesta().getTime()));
            pst.setString(5, objAtestado.getDeptoMedico());
            pst.setString(6, objAtestado.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAtestado;
    }

    // Excluir movimento do serviço social 
    public AtestadoMedicoPsiquiatrico excluirMovTecAtestado(AtestadoMedicoPsiquiatrico objAtestado) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM MOVTECNICO WHERE IdAtend='" + objAtestado.getIdLanc() + "' AND NomeOpe='" + nomeOpeTecnica + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAtestado;
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
