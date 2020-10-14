/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AtivarDesativarAlertaEntradas;
//import gestor.Visao.TelaAlertaEntradas.pRESPOSTA;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo.silva7
 */
public class ControleAlertasCRCPortaria {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AtivarDesativarAlertaEntradas objAlertaEntrada = new AtivarDesativarAlertaEntradas();
    //
    public static String pRESPOSTA = "";

    public AtivarDesativarAlertaEntradas alterarAlertaEntrada_PRIMEIRA_VEZ(AtivarDesativarAlertaEntradas objAlertaEntrada) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSENTRADAPORTARIA SET ConfirmaEntrada=? WHERE IdItem='" + objAlertaEntrada.getIdItem() + "'");
            pst.setString(1, objAlertaEntrada.getConfirmaEntrada());
            pst.executeUpdate();
            pRESPOSTA = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAlertaEntrada;
    }
    
    //NOVA ENTRADA NA PORTARIA
    public AtivarDesativarAlertaEntradas alterarAlertaNovaEntrada(AtivarDesativarAlertaEntradas objAlertaEntrada) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSNOVAENTRADA SET UtilizadoCrc=? WHERE IdItem='" + objAlertaEntrada.getIdItem() + "'");
            pst.setString(1, objAlertaEntrada.getConfirmaEntrada());
            pst.executeUpdate();
            pRESPOSTA = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAlertaEntrada;
    }
    
    //RETORNOS DE ENTRADAS NA PORTARIA
    public AtivarDesativarAlertaEntradas alterarRetornoEntrada(AtivarDesativarAlertaEntradas objAlertaEntrada) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS SET RetCrc=? WHERE IdRetorno='" + objAlertaEntrada.getIdItem() + "' AND IdInternoCrc='" + objAlertaEntrada.getIdInternoCrc() + "'");
            pst.setString(1, objAlertaEntrada.getConfirmaEntrada());
            pst.executeUpdate();
            pRESPOSTA = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAlertaEntrada;
    }
    
    //SAÍDAS DA UNIDADE
    public AtivarDesativarAlertaEntradas alterarSaidas(AtivarDesativarAlertaEntradas objAlertaEntrada) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSCRCPORTARIA SET SaidaConfirmada=? WHERE IdSaida='" + objAlertaEntrada.getIdItem() + "' AND IdInternoCrc='" + objAlertaEntrada.getIdInternoCrc() + "'");
            pst.setString(1, objAlertaEntrada.getConfirmaEntrada());
            pst.executeUpdate();
            pRESPOSTA = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAlertaEntrada;
    }
}
