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
 * @author Ronaldo
 */
public class ControleSituacao {
    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ProntuarioCrc objProCrc = new ProntuarioCrc();
     //Método para Alterar INTERNO CRC
     public ProntuarioCrc alterarSituacaoInterno(ProntuarioCrc objProCrc) {       
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PRONTUARIOSCRC SET SituacaoCrc=? WHERE IdInternoCrc='" + objProCrc.getIdInterno()+ "'");
            pst.setString(1, objProCrc.getSituacao());           
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }        
        conecta.desconecta();
        return objProCrc;        
    }     
}
