/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.PatologiaEvolucaoPsiquiatrica;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControlePatologiaEvolucaoPsiquiatrica {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    PatologiaEvolucaoPsiquiatrica objPatEvol = new PatologiaEvolucaoPsiquiatrica();

    int codDoenca;

    public PatologiaEvolucaoPsiquiatrica incluirPatologiaPsiquiatria(PatologiaEvolucaoPsiquiatrica objPatEvol) {
        buscarPatologia(objPatEvol.getDescricaoDoenca());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO PATOLOGIA_EVOLUCAO_PSIQUIATRICA (DataReg,IdItem,IdInternoCrc,IdDoenca,TipoAna,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objPatEvol.getDataReg().getTime()));
            pst.setInt(2, objPatEvol.getIdItem());
            pst.setInt(3, objPatEvol.getIdInternoCrc());            
            pst.setInt(4, codDoenca);
            pst.setString(5, objPatEvol.getTipoAna());
            pst.setString(6, objPatEvol.getUsuarioInsert());
            pst.setString(7, objPatEvol.getDataInsert());
            pst.setString(8, objPatEvol.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPatEvol;
    }

    public PatologiaEvolucaoPsiquiatrica alterarPatologiaPsiquiatria(PatologiaEvolucaoPsiquiatrica objPatEvol) {
        buscarPatologia(objPatEvol.getDescricaoDoenca());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PATOLOGIA_EVOLUCAO_PSIQUIATRICA SET DataReg=?,IdItem=?,IdInternoCrc=?,IdDoenca=?,TipoAna=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdPatPsi='" + objPatEvol.getIdPatPsi() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objPatEvol.getDataReg().getTime()));
            pst.setInt(2, objPatEvol.getIdItem());
            pst.setInt(3, objPatEvol.getIdInternoCrc()); 
            pst.setInt(4, codDoenca);
            pst.setString(5, objPatEvol.getTipoAna());
            pst.setString(6, objPatEvol.getUsuarioUp());
            pst.setString(7, objPatEvol.getDataUp());
            pst.setString(8, objPatEvol.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPatEvol;
    }

    public PatologiaEvolucaoPsiquiatrica excluirPatologiaPsiquiatria(PatologiaEvolucaoPsiquiatrica objPatEvol) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM PATOLOGIA_EVOLUCAO_PSIQUIATRICA WHERE IdPatPsi='" + objPatEvol.getIdPatPsi() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPatEvol;
    }

    public void buscarPatologia(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM DOENCAS WHERE Descricao='" + nome + "'");
            conecta.rs.first();
            codDoenca = conecta.rs.getInt("IdDoenca");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
