/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EvolucaoEnfermagem;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleEvolucaoEnfermagem {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EvolucaoEnfermagem objEvolEnferma = new EvolucaoEnfermagem();
  

    public EvolucaoEnfermagem incluirEvolucaoEnfermagem(EvolucaoEnfermagem objEvolEnferma) {
       
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO EVOLUCAOENFERMAGEM (DataEvol,IdLanc,IdInternoCrc,TextoEvolucao,UsuarioInsert,DataInsert,HorarioInsert,AdmEvo) VALUES (?,?,?,?,?,?,?,?)");           
            pst.setTimestamp(1, new java.sql.Timestamp(objEvolEnferma.getDataEvol().getTime()));
            pst.setInt(2, objEvolEnferma.getIdLanc());
            pst.setInt(3, objEvolEnferma.getIdInternoCrc());
            pst.setString(4, objEvolEnferma.getTextoEvolucao());
            pst.setString(5, objEvolEnferma.getUsuarioInsert());
            pst.setString(6, objEvolEnferma.getDataInsert());
            pst.setString(7, objEvolEnferma.getHoraInsert());
            pst.setString(8, objEvolEnferma.getAdmEvo());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEvolEnferma;
    }

    public EvolucaoEnfermagem alterarEvolucaoEnfermagem(EvolucaoEnfermagem objEvolEnferma) {
       
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE EVOLUCAOENFERMAGEM SET DataEvol=?,IdLanc=?,IdInternoCrc=?,TextoEvolucao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdLanc='" + objEvolEnferma.getIdLanc() + "'AND IdItem='" + objEvolEnferma.getIdItem() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objEvolEnferma.getDataEvol().getTime()));
            pst.setInt(2, objEvolEnferma.getIdLanc());
            pst.setInt(3, objEvolEnferma.getIdInternoCrc());
            pst.setString(4, objEvolEnferma.getTextoEvolucao());
            pst.setString(5, objEvolEnferma.getUsuarioUp());
            pst.setString(6, objEvolEnferma.getDataUp());
            pst.setString(7, objEvolEnferma.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEvolEnferma;
    }

    public EvolucaoEnfermagem excluirEvolucaoEnfermagem(EvolucaoEnfermagem objEvolEnferma) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM EVOLUCAOENFERMAGEM WHERE IdLanc='" + objEvolEnferma.getIdLanc() + "'AND IdItem='" + objEvolEnferma.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEvolEnferma;
    }   
}
