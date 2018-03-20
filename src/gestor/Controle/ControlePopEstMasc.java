/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.PopEstrangeiraMasc;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControlePopEstMasc {
    ConexaoBancoDados conecta = new ConexaoBancoDados();
    PopEstrangeiraMasc objPopEsMas = new PopEstrangeiraMasc();   
    
    public PopEstrangeiraMasc incluirPopEstMasc(PopEstrangeiraMasc objPopEsMas){
        
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO POPESTRANGMASC (DataPop,IdPopMov,EstraHomenAbe,EstraHomenFec,EstraHomenPro,EstraHomenSem,TotalGeralMasc) VALUES(?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objPopEsMas.getDataPop().getTime()));
            pst.setInt(2, objPopEsMas.getIdPopEsth());
            pst.setInt(3, objPopEsMas.getEstraHomenAbe());
            pst.setInt(4, objPopEsMas.getEstraHomenFec());
            pst.setInt(5, objPopEsMas.getEstraHomenPro());
            pst.setInt(6, objPopEsMas.getEstraHomenSem());
            pst.setInt(7, objPopEsMas.getTotalGeralMasc());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objPopEsMas;
    }
    public PopEstrangeiraMasc alterarPopEstMasc(PopEstrangeiraMasc objPopEsMas){
        
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE POPESTRANGMASC SET DataPop=?,IdPopMov=?,EstraHomenAbe=?,EstraHomenFec=?,EstraHomenPro=?,EstraHomenSem=?,TotalGeralMasc=? WHERE IdPopMov='" + objPopEsMas.getIdPopEsth() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objPopEsMas.getDataPop().getTime()));
            pst.setInt(2, objPopEsMas.getIdPopEsth());
            pst.setInt(3, objPopEsMas.getEstraHomenAbe());
            pst.setInt(4, objPopEsMas.getEstraHomenFec());
            pst.setInt(5, objPopEsMas.getEstraHomenPro());
            pst.setInt(6, objPopEsMas.getEstraHomenSem());
            pst.setInt(7, objPopEsMas.getTotalGeralMasc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objPopEsMas;
    }
    public PopEstrangeiraMasc excluirPopEstMasc(PopEstrangeiraMasc objPopEsMas){
        
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM POPESTRANGMASC WHERE IdPopMov='" + objPopEsMas.getIdPopEsth() + "'");            
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados (POPULAÇÃO ESTRANGEIRO MASCULINO)\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objPopEsMas;
    }
}
