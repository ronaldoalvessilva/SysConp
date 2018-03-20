/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EvolucaoTecEnfrmagem;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleEvolucaoTecEnfermagem {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EvolucaoTecEnfrmagem objEvoTecEnf = new EvolucaoTecEnfrmagem();

    public EvolucaoTecEnfrmagem incluirEvolucaoTecEnfermagem(EvolucaoTecEnfrmagem objEvoTecEnf) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO EVOLUCAOTECENFERMAGEM (DataEvol,IdLanc,IdInternoCrc,TextoEvolucao,UsuarioInsert,DataInsert,HorarioInsert) VALUES (?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objEvoTecEnf.getDataEvol().getTime()));
            pst.setInt(2, objEvoTecEnf.getIdLanc());
            pst.setInt(3, objEvoTecEnf.getIdInternoCrc());
            pst.setString(4, objEvoTecEnf.getTextoEvolucao());
            pst.setString(5, objEvoTecEnf.getUsuarioInsert());
            pst.setString(6, objEvoTecEnf.getDataInsert());
            pst.setString(7, objEvoTecEnf.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEvoTecEnf;
    }

    public EvolucaoTecEnfrmagem alterarEvolucaoTecEnfermagem(EvolucaoTecEnfrmagem objEvoTecEnf) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE EVOLUCAOTECENFERMAGEM SET DataEvol=?,IdLanc=?,IdInternoCrc=?,TextoEvolucao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdLanc='" + objEvoTecEnf.getIdLanc() + "'AND IdItem='" + objEvoTecEnf.getIdItem() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objEvoTecEnf.getDataEvol().getTime()));
            pst.setInt(2, objEvoTecEnf.getIdLanc());
            pst.setInt(3, objEvoTecEnf.getIdInternoCrc());
            pst.setString(4, objEvoTecEnf.getTextoEvolucao());
            pst.setString(5, objEvoTecEnf.getUsuarioUp());
            pst.setString(6, objEvoTecEnf.getDataUp());
            pst.setString(7, objEvoTecEnf.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEvoTecEnf;
    }

    public EvolucaoTecEnfrmagem excluirEvolucaoTecEnfermagem(EvolucaoTecEnfrmagem objEvoTecEnf) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM EVOLUCAOTECENFERMAGEM WHERE IdLanc='" + objEvoTecEnf.getIdLanc() + "'AND IdItem='" + objEvoTecEnf.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEvoTecEnf;
    }
}
