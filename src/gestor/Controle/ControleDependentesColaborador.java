/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.Dependentes;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleDependentesColaborador {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    Dependentes objDep = new Dependentes();

    public Dependentes incluirDepndenteColaborador(Dependentes objDep) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO DEPENDENTES (NomeDep,DataNascDep,ParenteDep,IdFunc,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");
            pst.setString(1, objDep.getNomeDep());
            pst.setTimestamp(2, new java.sql.Timestamp(objDep.getDataNascDep().getTime()));
            pst.setString(3, objDep.getParenteDep());
            pst.setInt(4, objDep.getIdFunc());
            pst.setString(5, objDep.getUsuarioInsert());
            pst.setString(6, objDep.getDataInsert());
            pst.setString(7, objDep.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados dos DEPENDENTES.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objDep;
    }

    public Dependentes alterarDepndenteColaborador(Dependentes objDep) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE DEPENDENTES SET NomeDep=?,DataNascDep=?,ParenteDep=?,IdFunc=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdDep='" + objDep.getIdDep() + "'AND IdFunc='" + objDep.getIdFunc() + "'");
            pst.setString(1, objDep.getNomeDep());
            pst.setTimestamp(2, new java.sql.Timestamp(objDep.getDataNascDep().getTime()));
            pst.setString(3, objDep.getParenteDep());
            pst.setInt(4, objDep.getIdFunc());
            pst.setString(5, objDep.getUsuarioUp());
            pst.setString(6, objDep.getDataUp());
            pst.setString(7, objDep.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados dos DEPENDENTES.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objDep;
    }

    public Dependentes excluirDepndenteColaborador(Dependentes objDep) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM DEPENDENTES WHERE IdDep='" + objDep.getIdDep() + "'AND IdFunc='" + objDep.getIdFunc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados dos DEPENDENTES.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objDep;
    }
}
