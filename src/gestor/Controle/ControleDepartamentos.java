/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.Departamentos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleDepartamentos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    Departamentos objDepto = new Departamentos();

    public Departamentos incluirDepartamento(Departamentos objDepto) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO DEPARTAMENTOS (StatusDepartamento,NomeDepartamento,SalaNr)VALUES(?,?,?)");
            pst.setBoolean(1, objDepto.isStatusDepartamento());
            pst.setString(2, objDepto.getNomeDepartamento());
            pst.setInt(3, objDepto.getNumeroSala());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objDepto;
    }
     public Departamentos alterarDepartamento(Departamentos objDepto) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE DEPARTAMENTOS SET StatusDepartamento=?,NomeDepartamento=?,SalaNr=? WHERE idDepartamento='" + objDepto.getIdDepartamento() + "'");
            pst.setBoolean(1, objDepto.isStatusDepartamento());
            pst.setString(2, objDepto.getNomeDepartamento());
            pst.setInt(3, objDepto.getNumeroSala());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objDepto;
    }
     public Departamentos excluirDepartamento(Departamentos objDepto) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM DEPARTAMENTOS WHERE idDepartamento='" + objDepto.getIdDepartamento() + "'");            
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objDepto;
    }
}
