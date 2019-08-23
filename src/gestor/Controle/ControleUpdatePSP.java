/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.RegistroAtendimentoInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronal
 */
public class ControleUpdatePSP {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    RegistroAtendimentoInternos objProdKit = new RegistroAtendimentoInternos();
    //
    public static String pATENDIDO_PSP = "Sim";
    public static int pQUANTIDADE_ATENDIDA = 0;

    public RegistroAtendimentoInternos alterar_QUANTIDADE_ATENDIDO(RegistroAtendimentoInternos objProdKit) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REGISTRO_ATENDIMENTO_INTERNO_PSP SET Qtd=? "
                    + "WHERE Atendido='" + pATENDIDO_PSP + "' "
                    + "AND Qtd='" + pQUANTIDADE_ATENDIDA + "'");
            pst.setInt(1, objProdKit.getQtdAtend());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProdKit;
    }
}
