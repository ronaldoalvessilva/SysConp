/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ProntuarioCrc;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronal
 */
public class ControleAtualizaInternoKits {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ProntuarioCrc objProCrc = new ProntuarioCrc();
    String resp = "Não";

    public ProntuarioCrc atualizarInternoKitInicial(ProntuarioCrc objProCrc) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE KITS_INICIAL_INTERNOS SET Utilizado=? WHERE IdInternoCrc='" + objProCrc.getIdInterno() + "' "
                    + "AND Utilizado='" + resp + "'");
            pst.setString(1, objProCrc.getKitIPago());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados do INTERNO.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProCrc;
    }

    public ProntuarioCrc atualizarInternoKitDecendial(ProntuarioCrc objProCrc) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE KITS_DECENDIAL_INTERNOS SET Utilizado=? WHERE IdInternoCrc='" + objProCrc.getIdInterno() + "' "
                    + "AND Utilizado='" + resp + "'");
            pst.setString(1, objProCrc.getKitDecendial());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados do INTERNO.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProCrc;
    }

    public ProntuarioCrc atualizarInternoKitQuinzenal(ProntuarioCrc objProCrc) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE KITS_QUINZENAL_INTERNOS SET Utilizado=? WHERE IdInternoCrc='" + objProCrc.getIdInterno() + "' "
                    + "AND Utilizado='" + resp + "'");
            pst.setString(1, objProCrc.getKitQuinzenal());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados do INTERNO.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProCrc;
    }

    public ProntuarioCrc atualizarInternoKitMensal(ProntuarioCrc objProCrc) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE KITS_MENSAL_INTERNOS SET Utilizado=? WHERE IdInternoCrc='" + objProCrc.getIdInterno() + "' "
                    + "AND Utilizado='" + resp + "'");
            pst.setString(1, objProCrc.getKitMensal());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados do INTERNO.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProCrc;
    }

    public ProntuarioCrc atualizarInternoKitSemestral(ProntuarioCrc objProCrc) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE KITS_SEMESTRAL_INTERNOS SET Utilizado=? WHERE IdInternoCrc='" + objProCrc.getIdInterno() + "' "
                    + "AND Utilizado='" + resp + "'");
            pst.setString(1, objProCrc.getKitSemestral());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados do INTERNO.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProCrc;
    }

    public ProntuarioCrc atualizarInternoKitAnual(ProntuarioCrc objProCrc) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE KITS_ANUAL_INTERNOS SET Utilizado=? WHERE IdInternoCrc='" + objProCrc.getIdInterno() + "' "
                    + "AND Utilizado='" + resp + "'");
            pst.setString(1, objProCrc.getKitAnual());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados do INTERNO.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProCrc;
    }
}
