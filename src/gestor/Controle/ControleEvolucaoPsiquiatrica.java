/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EvolucaoPsiquiatrica;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleEvolucaoPsiquiatrica {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EvolucaoPsiquiatrica objDiag = new EvolucaoPsiquiatrica();

    public EvolucaoPsiquiatrica incluirEvolucaoPsiquiatrica(EvolucaoPsiquiatrica objDiag) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO EVOLUCAO_PSIQUIATRICA (DataEvol,IdLanc,IdInternoCrc,EvolucaoPsiquiatrica,UsuarioInsert,DataInsert,HorarioInsert,HipoteseDiagnostica,ExamesSolicitados,Patologia) VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objDiag.getDataDiag().getTime()));
            pst.setInt(2, objDiag.getIdLanc());
            pst.setInt(3, objDiag.getIdInternoCrc());
            pst.setString(4, objDiag.getEvolucaoPsiquiatrica());
            pst.setString(5, objDiag.getUsuarioInsert());
            pst.setString(6, objDiag.getDataInsert());
            pst.setString(7, objDiag.getHorarioInsert());
            pst.setString(8, objDiag.getHipoteseDiagnostica());
            pst.setString(9, objDiag.getExamesSolicitados());
            pst.setString(10, objDiag.getPatologiaAdquidida());
            pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + e);
        }
        conecta.desconecta();
        return objDiag;
    }

    public EvolucaoPsiquiatrica alterarEvolucaoPsiquiatrica(EvolucaoPsiquiatrica objDiag) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE EVOLUCAO_PSIQUIATRICA SET DataEvol=?,IdLanc=?,IdInternoCrc=?,EvolucaoPsiquiatrica=?,UsuarioUp=?,DataUp=?,HorarioUp=?,HipoteseDiagnostica=?,ExamesSolicitados=?,Patologia=? WHERE IdItem='" + objDiag.getIdItem() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objDiag.getDataDiag().getTime()));
            pst.setInt(2, objDiag.getIdLanc());
            pst.setInt(3, objDiag.getIdInternoCrc());
            pst.setString(4, objDiag.getEvolucaoPsiquiatrica());
            pst.setString(5, objDiag.getUsuarioUp());
            pst.setString(6, objDiag.getDataUp());
            pst.setString(7, objDiag.getHorarioUp());
            pst.setString(8, objDiag.getHipoteseDiagnostica());
            pst.setString(9, objDiag.getExamesSolicitados());
            pst.setString(10, objDiag.getPatologiaAdquidida());
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + e);
        }
        conecta.desconecta();
        return objDiag;
    }

    public EvolucaoPsiquiatrica excluirEvolucaoPsiquiatrica(EvolucaoPsiquiatrica objDiag) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM EVOLUCAO_PSIQUIATRICA WHERE IdItem='" + objDiag.getIdItem() + "'");
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + e);
        }
        conecta.desconecta();
        return objDiag;
    }
}
