/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.MovimentoPopulacao;
import gestor.Modelo.PopBrasilMasc;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControlePopBraMasc {
    ConexaoBancoDados conecta = new ConexaoBancoDados();
    PopBrasilMasc objPopBraMasc = new PopBrasilMasc();
    MovimentoPopulacao objPopMov = new MovimentoPopulacao();
    
    public PopBrasilMasc incluirPopBraMasc(PopBrasilMasc objPopBraMasc){
        
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO POPBRASMASC (DataPop,IdPopMov,BrasHomemAbe,BrasHomemFec,BrasHomemPro,BrasHomemSem,TotalGeralBrasMasc) VALUES(?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objPopBraMasc.getDataPop().getTime()));
            pst.setInt(2, objPopBraMasc.getIdPopBrash());
            pst.setInt(3, objPopBraMasc.getBrasHomemAbe());
            pst.setInt(4, objPopBraMasc.getBrasHomemFec());
            pst.setInt(5, objPopBraMasc.getBrasHomemPro());
            pst.setInt(6, objPopBraMasc.getBrasHomemSem());
            pst.setInt(7, objPopBraMasc.getTotalGeralMas());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objPopBraMasc;
    }
    public PopBrasilMasc alterarPopBraMasc(PopBrasilMasc objPopBraMasc){
        
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE POPBRASMASC SET DataPop=?,IdPopMov=?,BrasHomemAbe=?,BrasHomemFec=?,BrasHomemPro=?,BrasHomemSem=?,TotalGeralBrasMasc=? WHERE IdPopMov='" +  objPopBraMasc.getIdPopBrash()  + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objPopBraMasc.getDataPop().getTime()));
            pst.setInt(2, objPopBraMasc.getIdPopBrash());
            pst.setInt(3, objPopBraMasc.getBrasHomemAbe());
            pst.setInt(4, objPopBraMasc.getBrasHomemFec());
            pst.setInt(5, objPopBraMasc.getBrasHomemPro());
            pst.setInt(6, objPopBraMasc.getBrasHomemSem());
            pst.setInt(7, objPopBraMasc.getTotalGeralMas());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objPopBraMasc;
    }
    public PopBrasilMasc excluirPopBraMasc(PopBrasilMasc objPopBraMasc){
        
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM POPBRASMASC WHERE IdPopMov='" +  objPopBraMasc.getIdPopBrash()  + "'");            
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel DELETAR os Dados (POPULAÇÃO BRASIL MASCULINO)\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objPopBraMasc;
    }
}
