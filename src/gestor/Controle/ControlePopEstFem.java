/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.PopEstrangeiraFem;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControlePopEstFem {
    ConexaoBancoDados conecta = new ConexaoBancoDados();
    PopEstrangeiraFem objPopEsFem = new PopEstrangeiraFem();   
    
    public PopEstrangeiraFem incluirPopEstFem(PopEstrangeiraFem objPopEsFem){
        
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO POPESTRANGFEM (DataPop,IdPopMov,EstraMulherAbe,EstraMulherFec,EstraMulherPro,EstraMulherSem,TotalGeralFem) VALUES(?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objPopEsFem.getDataPop().getTime()));
            pst.setInt(2, objPopEsFem.getIdPopEstFem());
            pst.setInt(3, objPopEsFem.getEstraMulherAbe());
            pst.setInt(4, objPopEsFem.getEstraMulherFec());
            pst.setInt(5, objPopEsFem.getEstraMulherPro());
            pst.setInt(6, objPopEsFem.getEstraMulherSem());
            pst.setInt(7, objPopEsFem.getTotalGeralFem());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();        
        return objPopEsFem;
    }
    public PopEstrangeiraFem alterarPopEstFem(PopEstrangeiraFem objPopEsFem){
        
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE POPESTRANGFEM SET DataPop=?,IdPopMov=?,EstraMulherAbe=?,EstraMulherFec=?,EstraMulherPro=?,EstraMulherSem=?,TotalGeralFem=? WHERE IdPopMov='" + objPopEsFem.getIdPopEstFem()+ "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objPopEsFem.getDataPop().getTime()));
            pst.setInt(2, objPopEsFem.getIdPopEstFem());
            pst.setInt(3, objPopEsFem.getEstraMulherAbe());
            pst.setInt(4, objPopEsFem.getEstraMulherFec());
            pst.setInt(5, objPopEsFem.getEstraMulherPro());
            pst.setInt(6, objPopEsFem.getEstraMulherSem());
            pst.setInt(7, objPopEsFem.getTotalGeralFem());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();        
        return objPopEsFem;
    }
    public PopEstrangeiraFem excluirPopEstFem(PopEstrangeiraFem objPopEsFem){
        
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM POPESTRANGFEM WHERE IdPopMov='" + objPopEsFem.getIdPopEstFem()+ "'");
             pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel DELETAR os Dados (POPULAÇÃO ESTRANGEIRA FEMININO)\n\nERRO" + ex);
        }
        conecta.desconecta();        
        return objPopEsFem;
    }
}
