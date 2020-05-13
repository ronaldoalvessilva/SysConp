/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EvolucaoServicoSocial;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleEvolucaoServicoSocial {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EvolucaoServicoSocial objEvol = new EvolucaoServicoSocial();

    public EvolucaoServicoSocial incluirEvolucaoServicoSocial(EvolucaoServicoSocial objEvol) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO EVOLUCAO_ATENDIMENTO_SOCIAL (DataEvol,IdAtend,IdInternoCrc,TextoEvolucao,UsuarioInsert,DataInsert,HorarioInsert,AdmEvo) VALUES (?,?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objEvol.getDataEvol().getTime()));
            pst.setInt(2, objEvol.getIdAtend());
            pst.setInt(3, objEvol.getIdInternoCrc());
            pst.setString(4, objEvol.getTextoEvolucao());
            pst.setString(5, objEvol.getUsuarioInsert());
            pst.setString(6, objEvol.getDataInsert());
            pst.setString(7, objEvol.getHorarioInsert());
            pst.setString(8, objEvol.getAdmEvo());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEvol;
    }

    public EvolucaoServicoSocial alterarEvolucaoServicoSocial(EvolucaoServicoSocial objEvol) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE EVOLUCAO_ATENDIMENTO_SOCIAL SET DataEvol=?,IdAtend=?,IdInternoCrc=?,TextoEvolucao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objEvol.getIdItem() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objEvol.getDataEvol().getTime()));
            pst.setInt(2, objEvol.getIdAtend());
            pst.setInt(3, objEvol.getIdInternoCrc());
            pst.setString(4, objEvol.getTextoEvolucao());
            pst.setString(5, objEvol.getUsuarioUp());
            pst.setString(6, objEvol.getDataUp());
            pst.setString(7, objEvol.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEvol;
    }

    public EvolucaoServicoSocial excluirEvolucaoServicoSocial(EvolucaoServicoSocial objEvol) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM EVOLUCAO_ATENDIMENTO_SOCIAL WHERE IdItem='" + objEvol.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEvol;
    }
    
    public EvolucaoServicoSocial alterarEvolucaoServicoSocialADM(EvolucaoServicoSocial objEvol) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE EVOLUCAO_ATENDIMENTO_SOCIAL SET DataEvol=?,IdAtend=?,IdInternoCrc=?,TextoEvolucao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE AdmEvo='" + objEvol.getAdmEvo()+ "' AND IdAtend='" + objEvol.getIdAtend() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objEvol.getDataEvol().getTime()));
            pst.setInt(2, objEvol.getIdAtend());
            pst.setInt(3, objEvol.getIdInternoCrc());
            pst.setString(4, objEvol.getTextoEvolucao());
            pst.setString(5, objEvol.getUsuarioUp());
            pst.setString(6, objEvol.getDataUp());
            pst.setString(7, objEvol.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (EVOLUÇÃO ADM)os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEvol;
    }
}
