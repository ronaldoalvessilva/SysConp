/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EvolucaoTerapia;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleEvolucaoTerapia {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EvolucaoTerapia objEvolu = new EvolucaoTerapia();

    public EvolucaoTerapia incluirEvolucaoTerapia(EvolucaoTerapia objEvolu) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO EVOLUCAOTERAPIA(DataEvo,IdInternoCrc,IdLanc,Evolucao,UsuarioInsert,DataInsert,HorarioInsert) VALUES (?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objEvolu.getDataEvo().getTime()));
            pst.setInt(2, objEvolu.getIdInternoCrc());
            pst.setInt(3, objEvolu.getIdLanc());
            pst.setString(4, objEvolu.getEvolucao());
            pst.setString(5, objEvolu.getUsuarioInsert());
            pst.setString(6, objEvolu.getDataInsert());
            pst.setString(7, objEvolu.getHorarioInsert());
            pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + e);
        }
        conecta.desconecta();
        return objEvolu;
    }
    public EvolucaoTerapia alterarEvolucaoTerapia(EvolucaoTerapia objEvolu) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE EVOLUCAOTERAPIA SET DataEvo=?,IdInternoCrc=?,IdLanc=?,Evolucao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdEvo='" + objEvolu.getIdEvo() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objEvolu.getDataEvo().getTime()));
            pst.setInt(2, objEvolu.getIdInternoCrc());
            pst.setInt(3, objEvolu.getIdLanc());
            pst.setString(4, objEvolu.getEvolucao());
            pst.setString(5, objEvolu.getUsuarioUp());
            pst.setString(6, objEvolu.getDataUp());
            pst.setString(7, objEvolu.getHorarioUp());
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + e);
        }
        conecta.desconecta();
        return objEvolu;
    }
    public EvolucaoTerapia excluirEvolucaoTerapia(EvolucaoTerapia objEvolu) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM EVOLUCAOTERAPIA WHERE IdEvo='" + objEvolu.getIdEvo() + "'");            
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + e);
        }
        conecta.desconecta();
        return objEvolu;
    }
}
