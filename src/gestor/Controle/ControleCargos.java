/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.Cargos;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleCargos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    Cargos objCargo = new Cargos();

    public Cargos Salvar(Cargos objCargo) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO CARGOS (StatusCargo, NomeCargo) VALUES(?,?)");
            pst.setBoolean(1, objCargo.isStatusCargo());
            pst.setString(2, objCargo.getNomeCargo());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objCargo;
    }
//Método para ALTERAR CARGO

    public Cargos Alterar(Cargos objCargo) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE CARGOS SET StatusCargo=?,NomeCargo=? WHERE IdCargo = ?");
            pst.setBoolean(1, objCargo.isStatusCargo());
            pst.setString(2, objCargo.getNomeCargo());
            pst.setInt(3, objCargo.getIdCargo());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\n ERRO\n" + ex);
        }
        conecta.desconecta();
        return objCargo;
    }
//Método para excluir CARGO

    public Cargos Excluir(Cargos objCargo) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst;
            pst = conecta.con.prepareStatement("DELETE FROM CARGOS WHERE IdCargo = ?");
            pst.setInt(1, objCargo.getIdCargo());
            pst.execute();
            conecta.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\n ERRO\n" + ex);
        }
        conecta.desconecta();
        return objCargo;

    }
// Método para buscar o código (ID) para salvar na tabela principal com relacionamento

    public void buscaCod(String Grupo, String Depto) {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM GRUPOUSUARIOS WHERE IdGrupo='" + Grupo + "'");
            conecta.rs.first();
            int codGrupo = conecta.rs.getInt("IdGrupo");
            conecta.executaSQL("SELECT * FROM DEPARTAMENTOS WHERE IdDepartamento='" + Depto + "'");
            conecta.rs.first();
            int codDepto = conecta.rs.getInt("IdDepartamento");
        } catch (SQLException ex) {
            Logger.getLogger(ControleCargos.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
    }

}
