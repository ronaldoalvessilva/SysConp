/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.PopBrasilFem;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControlePopBraFem {
    ConexaoBancoDados conecta = new ConexaoBancoDados();
    PopBrasilFem objPopBraFem = new PopBrasilFem();    
    
    public PopBrasilFem incluirPopBraFem(PopBrasilFem objPopBraFem){
        
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO POPBRASFEM (DataPop,IdPopMov,BrasMulherAbe,BrasMulherFec,BrasMulherPro,BrasMulherSem,TotalGeralBrasFem) VALUES(?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objPopBraFem.getDataPop().getTime()));
            pst.setInt(2, objPopBraFem.getIdPopBrasm());
            pst.setInt(3, objPopBraFem.getBrasMulherAbe());
            pst.setInt(4, objPopBraFem.getBrasMulherFec());
            pst.setInt(5, objPopBraFem.getBrasMulherPro());
            pst.setInt(6, objPopBraFem.getBrasMulherSem());
            pst.setInt(7, objPopBraFem.getTotalGeralFem());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objPopBraFem;
    }
    public PopBrasilFem alterarPopBraFem(PopBrasilFem objPopBraFem){
        
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE POPBRASFEM SET DataPop=?,IdPopMov=?,BrasMulherAbe=?,BrasMulherFec=?,BrasMulherPro=?,BrasMulherSem=?,TotalGeralBrasFem=? WHERE IdPopMov='" + objPopBraFem.getIdPopBrasm()  + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objPopBraFem.getDataPop().getTime()));
            pst.setInt(2, objPopBraFem.getIdPopBrasm());
            pst.setInt(3, objPopBraFem.getBrasMulherAbe());
            pst.setInt(4, objPopBraFem.getBrasMulherFec());
            pst.setInt(5, objPopBraFem.getBrasMulherPro());
            pst.setInt(6, objPopBraFem.getBrasMulherSem());
            pst.setInt(7, objPopBraFem.getTotalGeralFem());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objPopBraFem;
    }
    public PopBrasilFem excluirPopBraFem(PopBrasilFem objPopBraFem){
        
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM POPBRASFEM  WHERE IdPopMov='" + objPopBraFem.getIdPopBrasm()  + "'");            
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel DELETAR os Dados (POLULAÇÃO BRASIL FEMININO)\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objPopBraFem;
    }
}
