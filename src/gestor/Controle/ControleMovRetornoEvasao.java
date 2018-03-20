/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensMovSaidaRetorno;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleMovRetornoEvasao {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensMovSaidaRetorno objMovSaiRetornoEva = new ItensMovSaidaRetorno();

     public ItensMovSaidaRetorno alterarMovRetornoEvasao(ItensMovSaidaRetorno objMovSaiRetornoEva) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE MOVISR SET IdRetorno=?,DataRetorno=?,NrDocRetorno=?,ConfirmaEvasao=? WHERE IdInternoCrc='" + objMovSaiRetornoEva.getIdInternoCrc() + "'AND NrDocSaida='" + objMovSaiRetornoEva.getNrDocSaida() + "'");
            pst.setInt(1, objMovSaiRetornoEva.getIdRetorno());
            if(objMovSaiRetornoEva.getDataRetorno() != null){
                pst.setTimestamp(2, new java.sql.Timestamp(objMovSaiRetornoEva.getDataRetorno().getTime()));
            }else{
                pst.setDate(2, null);
            }            
            pst.setString(3, objMovSaiRetornoEva.getNrDocRetorno());                        
            pst.setString(4, objMovSaiRetornoEva.getConfirmaEvasao());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objMovSaiRetornoEva;
    }     
}
