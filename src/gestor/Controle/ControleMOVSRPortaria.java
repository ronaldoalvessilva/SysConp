/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensRegistroRetornoInterno;
import gestor.Modelo.RegistroRetornoInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
// Metódo para confirmar os retornos dos internos na portaria tabela MOVSR
public class ControleMOVSRPortaria {
    
    ConexaoBancoDados conecta = new ConexaoBancoDados();
    RegistroRetornoInternos objRetorno = new RegistroRetornoInternos();
    ItensRegistroRetornoInterno objItensRetorno = new ItensRegistroRetornoInterno();
    
    public ItensRegistroRetornoInterno incluirRegistroRetorno(ItensRegistroRetornoInterno objItensRetorno) {
        
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE MOVISR SET IdRetorno=?,DataRetorno=?,NrDocRetorno=?,IdItemRetorno=? WHERE IdInternoCrc='" + objItensRetorno.getIdInternoCrc() + "'AND NrDocSaida='" + objItensRetorno.getDocumento() + "'");            
            pst.setInt(1, objItensRetorno.getIdRetorno());
            if (objItensRetorno.getDataRetorno() != null) {
                pst.setTimestamp(2, new java.sql.Timestamp(objItensRetorno.getDataRetorno().getTime()));
            } else {
                pst.setDate(2, null);
            }
            pst.setString(3, objItensRetorno.getDocumento());
            pst.setInt(4, objItensRetorno.getIdItemRetorno());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensRetorno;
    }
    
    // QUANDO EXCLUIR O INTERNO NA PORTARIA, MODIFICAR A RESPOSTA PARA PODER BUSCAR NOVAMENTE.
    public ItensRegistroRetornoInterno alterarRegistroRetorno(ItensRegistroRetornoInterno objItensRetorno) {
        
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE MOVISR SET IdRetorno=?,DataRetorno=?,NrDocRetorno=?,IdItemRetorno=? WHERE IdRetorno='" + objItensRetorno.getIdRetorno() + "' AND IdInternoCrc='" + objItensRetorno.getIdInternoCrc() + "'");            
            pst.setInt(1, objItensRetorno.getIdRetorno());
            if (objItensRetorno.getDataRetorno() != null) {
                pst.setTimestamp(2, new java.sql.Timestamp(objItensRetorno.getDataRetorno().getTime()));
            } else {
                pst.setDate(2, null);
            }
            pst.setString(3, objItensRetorno.getDocumento());
            pst.setInt(4, objItensRetorno.getIdItemRetorno());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensRetorno;
    }
}
