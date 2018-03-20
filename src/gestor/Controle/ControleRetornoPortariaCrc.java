/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.RetornoPortariaCrc;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleRetornoPortariaCrc {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    RetornoPortariaCrc objRetPortCrc = new RetornoPortariaCrc();

    public RetornoPortariaCrc alterarRespostaRetornoInterno(RetornoPortariaCrc objRetPortCrc) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS SET RetCrc=? WHERE IdInternoCrc='" + objRetPortCrc.getIdInternoCrc()  + "'AND RetCrc='" + objRetPortCrc.getConfirmaCrc()  + "'");
            pst.setString(1, objRetPortCrc.getRespostaCrc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.(VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS)\nERRO" + ex);
        }
        conecta.desconecta();
        return objRetPortCrc;
    }
}
