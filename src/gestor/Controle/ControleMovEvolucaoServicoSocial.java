/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EvolucaoEnfermagem;
import gestor.Modelo.EvolucaoServicoSocial;
import gestor.Modelo.MovTecEvolucaoEnfermagem;
import gestor.Modelo.MovTecEvolucaoServicoSocial;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleMovEvolucaoServicoSocial {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    MovTecEvolucaoServicoSocial controlMovEvolSSocial = new MovTecEvolucaoServicoSocial();
    EvolucaoServicoSocial objEvol = new EvolucaoServicoSocial();
    String nomeOpeTecnica = "Atendimento do Interno no Serviço Social - (Evolução S. Social)";

    public EvolucaoServicoSocial incluirMovServicoSocial(EvolucaoServicoSocial objEvol) {
      
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO MOVTECNICO (IdInternoCrc,IdAtend,NomeOpe,DataMov,DeptoMov,StatusAtend) VALUES(?,?,?,?,?,?)");
            pst.setInt(1, objEvol.getIdInternoCrc());
            pst.setInt(2, objEvol.getIdAtend());
            pst.setString(3, nomeOpeTecnica);
            pst.setTimestamp(4, new java.sql.Timestamp(objEvol.getDataEvol().getTime()));
            pst.setString(5, objEvol.getDeptoMedico());
            pst.setString(6, objEvol.getStatusLanc());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEvol;
    }

    // Alterar movimento do serviço social 
    public EvolucaoServicoSocial alterarMovServicoSocial(EvolucaoServicoSocial objEvol) {
      
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE MOVTECNICO SET IdInternoCrc=?,IdAtend=?,NomeOpe=?,DataMov=?,DeptoMov=?,StatusAtend=? WHERE IdAtend='" + objEvol.getIdAtend()+ "' AND NomeOpe='" + nomeOpeTecnica + "'");
            pst.setInt(1, objEvol.getIdInternoCrc());
            pst.setInt(2, objEvol.getIdAtend());
            pst.setString(3, nomeOpeTecnica);
            pst.setTimestamp(4, new java.sql.Timestamp(objEvol.getDataEvol().getTime()));
            pst.setString(5, objEvol.getDeptoMedico());
            pst.setString(6, objEvol.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEvol;
    }

    public EvolucaoServicoSocial finalizarMovServicoSocial(EvolucaoServicoSocial objEvol) {
        //  buscarInternoCrc(objAdmPsi.getNomeInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE MOVTECNICO SET StatusAtend=? WHERE IdAtend='" + objEvol.getIdAtend()+ "' AND NomeOpe='" + nomeOpeTecnica + "'");
            pst.setString(1, objEvol.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR na tabela MOVIMENTO TÉCNICO os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEvol;
    }

    // Excluir movimento do serviço social 
    public EvolucaoServicoSocial  excluirMovServicoSocial(EvolucaoServicoSocial objEvol) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM MOVTECNICO WHERE IdAtend='" + objEvol.getIdAtend()+ "' AND NomeOpe='" + nomeOpeTecnica + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEvol;
    }
}
