/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AgendaBeneficioInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleAgendaBeneficiosInternos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AgendaBeneficioInternos objAgendaBene = new AgendaBeneficioInternos();

    public AgendaBeneficioInternos incluirAgendaBeneicios(AgendaBeneficioInternos objAgendaBene) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO AGENDA_BENEFICIO_INTERNOS (StatusReg,DataReg,TipoBeneficio,DataAg,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");
            pst.setString(1, objAgendaBene.getStatusReg());
            pst.setTimestamp(2, new java.sql.Timestamp(objAgendaBene.getDataReg().getTime()));
            pst.setString(3, objAgendaBene.getTipoBeneficio());
            pst.setTimestamp(4, new java.sql.Timestamp(objAgendaBene.getDataAg().getTime()));
            pst.setString(5, objAgendaBene.getUsuarioInsert());
            pst.setString(6, objAgendaBene.getDataInsert());
            pst.setString(7, objAgendaBene.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAgendaBene;
    }

    public AgendaBeneficioInternos alterarAgendaBeneicios(AgendaBeneficioInternos objAgendaBene) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE AGENDA_BENEFICIO_INTERNOS SET StatusReg=?,DataReg=?,TipoBeneficio=?,DataAg=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdReg='" + objAgendaBene.getIdReg() + "'");
            pst.setString(1, objAgendaBene.getStatusReg());
            pst.setTimestamp(2, new java.sql.Timestamp(objAgendaBene.getDataReg().getTime()));
            pst.setString(3, objAgendaBene.getTipoBeneficio());
            pst.setTimestamp(4, new java.sql.Timestamp(objAgendaBene.getDataAg().getTime()));
            pst.setString(5, objAgendaBene.getUsuarioUp());
            pst.setString(6, objAgendaBene.getDataUp());
            pst.setString(7, objAgendaBene.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAgendaBene;
    }

    public AgendaBeneficioInternos excluirAgendaBeneicios(AgendaBeneficioInternos objAgendaBene) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM AGENDA_BENEFICIO_INTERNOS WHERE IdReg='" + objAgendaBene.getIdReg() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAgendaBene;
    }
}
