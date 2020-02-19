/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.PortaEntrada;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Socializa TI 02
 */
public class ControlePortaEntrada {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    PortaEntrada objPortaEntrada = new PortaEntrada();

    int codInterno;

    public PortaEntrada incluirPortaEntrada(PortaEntrada objPortaEntrada) {
        buscarInterno(objPortaEntrada.getNomeInternoCrc(), objPortaEntrada.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO PORTA_ENTRADA (IdInternoCrc,DataEntrada,PSPEnf,HabEnf,PSPMed,HabMed,PSPJur,HabJur,PSPPed,HabPed,PSPPsi,HabPsi,PSPSso,HabSso,PSPOdo,HabOdo,PSPTer,HabTer,PSPEdu,HabEdu)"
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, codInterno);
            pst.setTimestamp(2, new java.sql.Timestamp(objPortaEntrada.getDataEntrada().getTime()));
            pst.setString(3, objPortaEntrada.getpSPEnf());
            pst.setString(4, objPortaEntrada.getHabEnf());
            pst.setString(5, objPortaEntrada.getpSPMed());
            pst.setString(6, objPortaEntrada.getHabMed());
            pst.setString(7, objPortaEntrada.getpSPJur());
            pst.setString(8, objPortaEntrada.getHabJur());
            pst.setString(9, objPortaEntrada.getpSPPed());
            pst.setString(10, objPortaEntrada.getHabPed());
            pst.setString(11, objPortaEntrada.getpSPPsi());
            pst.setString(12, objPortaEntrada.getHabPsi());
            pst.setString(13, objPortaEntrada.getpSPSso());
            pst.setString(14, objPortaEntrada.getHabSso());
            pst.setString(15, objPortaEntrada.getpSPOdo());
            pst.setString(16, objPortaEntrada.getHabOdo());
            pst.setString(17, objPortaEntrada.getpSPTer());
            pst.setString(18, objPortaEntrada.getHabTer());
            pst.setString(19, objPortaEntrada.getpSPEdu());
            pst.setString(20, objPortaEntrada.getHabEdu());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPortaEntrada;
    }

    public PortaEntrada alterarPortaEntradaCRC(PortaEntrada objPortaEntrada) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PORTA_ENTRADA SET DataEntrada=?,HabEnf=?,HabMed=?,HabJur=?,HabPed=?,HabPsi=?,HabSso=?,HabOdo=?,HabTer=?,HabEdu=? WHERE IdInternoCrc='" + objPortaEntrada.getIdInternoCrc() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objPortaEntrada.getDataEntrada().getTime()));
            pst.setString(2, objPortaEntrada.getHabEnf());
            pst.setString(3, objPortaEntrada.getHabMed());
            pst.setString(4, objPortaEntrada.getHabJur());
            pst.setString(5, objPortaEntrada.getHabPed());
            pst.setString(6, objPortaEntrada.getHabPsi());
            pst.setString(7, objPortaEntrada.getHabSso());
            pst.setString(8, objPortaEntrada.getHabOdo());
            pst.setString(9, objPortaEntrada.getHabTer());
            pst.setString(10, objPortaEntrada.getHabEdu());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPortaEntrada;
    }

    public PortaEntrada excluirPortaEntrada(PortaEntrada objPortaEntrada) {
        buscarInterno(objPortaEntrada.getNomeInternoCrc(), objPortaEntrada.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM PORTA_ENTRADA WHERE IdInternoCrc='" + objPortaEntrada.getIdInternoCrc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPortaEntrada;
    }

    //--------------------------------  MODICAÇÕES PARA PSP --------------------------------------------------
    public PortaEntrada alterarPortaEntradaMedica(PortaEntrada objPortaEntrada) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PORTA_ENTRADA SET HabMed=? WHERE IdInternoCrc='" + objPortaEntrada.getIdInternoCrc() + "'");
            pst.setString(1, objPortaEntrada.getHabMed());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPortaEntrada;
    }

    public PortaEntrada alterarPortaEntradaEnfermeira(PortaEntrada objPortaEntrada) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PORTA_ENTRADA SET HabEnf=? WHERE IdInternoCrc='" + objPortaEntrada.getIdInternoCrc() + "'");
            pst.setString(1, objPortaEntrada.getHabEnf());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPortaEntrada;
    }

    public PortaEntrada alterarPortaEntradaJuridico(PortaEntrada objPortaEntrada) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PORTA_ENTRADA SET HabJur=? WHERE IdInternoCrc='" + objPortaEntrada.getIdInternoCrc() + "'");
            pst.setString(1, objPortaEntrada.getHabJur());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPortaEntrada;
    }

    public PortaEntrada alterarPortaEntradaPedagogia(PortaEntrada objPortaEntrada) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PORTA_ENTRADA SET HabPed=? WHERE IdInternoCrc='" + objPortaEntrada.getIdInternoCrc() + "'");
            pst.setString(1, objPortaEntrada.getHabPed());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPortaEntrada;
    }

    public PortaEntrada alterarPortaEntradaPsicologia(PortaEntrada objPortaEntrada) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PORTA_ENTRADA SET HabPsi=? WHERE IdInternoCrc='" + objPortaEntrada.getIdInternoCrc() + "'");
            pst.setString(1, objPortaEntrada.getHabPsi());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPortaEntrada;
    }

    public PortaEntrada alterarPortaEntradaSocial(PortaEntrada objPortaEntrada) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PORTA_ENTRADA SET HabSso=? WHERE IdInternoCrc='" + objPortaEntrada.getIdInternoCrc() + "'");
            pst.setString(1, objPortaEntrada.getHabSso());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPortaEntrada;
    }

    public PortaEntrada alterarPortaEntradaOdontologia(PortaEntrada objPortaEntrada) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PORTA_ENTRADA SET HabOdo=? WHERE IdInternoCrc='" + objPortaEntrada.getIdInternoCrc() + "'");
            pst.setString(1, objPortaEntrada.getHabOdo());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPortaEntrada;
    }

    public PortaEntrada alterarPortaEntradaTerapia(PortaEntrada objPortaEntrada) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PORTA_ENTRADA SET HabTer=? WHERE IdInternoCrc='" + objPortaEntrada.getIdInternoCrc() + "'");
            pst.setString(1, objPortaEntrada.getHabTer());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPortaEntrada;
    }

    public PortaEntrada alterarPortaEntradaEducacao(PortaEntrada objPortaEntrada) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PORTA_ENTRADA SET HabEdu=? WHERE IdInternoCrc='" + objPortaEntrada.getIdInternoCrc() + "'");
            pst.setString(1, objPortaEntrada.getHabEdu());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPortaEntrada;
    }

    public void buscarInterno(String desc, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE NomeInternoCrc='" + desc + "' "
                    + "AND IdInternoCrc='" + codigo + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível pesquisar o interno.\nERRO: " + ex);
        }
    }
}
