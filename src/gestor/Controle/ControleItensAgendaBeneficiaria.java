/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensAgendaBeneficioInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleItensAgendaBeneficiaria {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensAgendaBeneficioInternos objItens = new ItensAgendaBeneficioInternos();

    int codInterno;

    public ItensAgendaBeneficioInternos incluirItensInterno(ItensAgendaBeneficioInternos objItens) {
        buscarInterno(objItens.getNomeInternoAgenda());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_AGENDA_BENEFICIO_INTERNOS (IdReg,IdInternoCrc,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?)");
            pst.setInt(1, objItens.getIdReg());
            pst.setInt(2, codInterno);           
            pst.setString(3, objItens.getUsuarioInsert());
            pst.setString(4, objItens.getDataInsert());
            pst.setString(5, objItens.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItens;
    }

    public ItensAgendaBeneficioInternos alterarItensInterno(ItensAgendaBeneficioInternos objItens) {
        buscarInterno(objItens.getNomeInternoAgenda());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_AGENDA_BENEFICIO_INTERNOS SET IdReg=?,IdInternoCrc=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objItens.getIdItem() + "'");
            pst.setInt(1, objItens.getIdReg());
            pst.setInt(2, codInterno);           
            pst.setString(3, objItens.getUsuarioUp());
            pst.setString(4, objItens.getDataUp());
            pst.setString(5, objItens.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItens;
    }

    public ItensAgendaBeneficioInternos excluirItensInterno(ItensAgendaBeneficioInternos objItens) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_AGENDA_BENEFICIO_INTERNOS WHERE IdItem='" + objItens.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItens;
    }

    public void buscarInterno(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + nome + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
