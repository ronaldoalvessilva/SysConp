/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensEntradaInternosPortaria;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleItensEntradaPortaria_RETORNOS {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensEntradaInternosPortaria objItensEntIntPort = new ItensEntradaInternosPortaria();

    public ItensEntradaInternosPortaria incluirItensEntradaPortariaRE(ItensEntradaInternosPortaria objItensEntIntPort) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_REGISTRO_CANCELADO_RETORNOS (IdLanc,NomeInternoCrc,DataEntrada,HoraEntrada,OficioInternos,OrigemInterno,ConfirmaEntrada,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objItensEntIntPort.getIdLanc());
            pst.setString(2, objItensEntIntPort.getNomeInternoCrc());
            pst.setTimestamp(3, new java.sql.Timestamp(objItensEntIntPort.getDataChegada().getTime()));
            pst.setString(4, objItensEntIntPort.getHorarioChegada());
            pst.setString(5, objItensEntIntPort.getNumeroOficio());
            pst.setString(6, objItensEntIntPort.getOrigemInterno());
            pst.setString(7, objItensEntIntPort.getConfirmaEntrada());
            pst.setString(8, objItensEntIntPort.getUsuarioInsert());
            pst.setString(9, objItensEntIntPort.getDataInsert());
            pst.setString(10, objItensEntIntPort.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensEntIntPort;
    }

    public ItensEntradaInternosPortaria alterarItensEntradaPortariaRE(ItensEntradaInternosPortaria objItensEntIntPort) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_REGISTRO_CANCELADO_RETORNOS SET IdLanc=?,NomeInternoCrc=?,DataEntrada=?,HoraEntrada=?,OficioInternos=?,OrigemInterno=?,ConfirmaEntrada=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objItensEntIntPort.getIdItem() + "'");
            pst.setInt(1, objItensEntIntPort.getIdLanc());
            pst.setString(2, objItensEntIntPort.getNomeInternoCrc());
            pst.setTimestamp(3, new java.sql.Timestamp(objItensEntIntPort.getDataChegada().getTime()));
            pst.setString(4, objItensEntIntPort.getHorarioChegada());
            pst.setString(5, objItensEntIntPort.getNumeroOficio());
            pst.setString(6, objItensEntIntPort.getOrigemInterno());
            pst.setString(7, objItensEntIntPort.getConfirmaEntrada());
            pst.setString(8, objItensEntIntPort.getUsuarioUp());
            pst.setString(9, objItensEntIntPort.getDataUp());
            pst.setString(10, objItensEntIntPort.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensEntIntPort;
    }

    public ItensEntradaInternosPortaria excluirItensEntradaPortariaRE(ItensEntradaInternosPortaria objItensEntIntPort) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_REGISTRO_CANCELADO_RETORNOS WHERE IdItem='" + objItensEntIntPort.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensEntIntPort;
    }

    //CANCELAMENTO DE RETORNO
    public ItensEntradaInternosPortaria confirmarEntradaPortariaCrcRE(ItensEntradaInternosPortaria objItensEntIntPort) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS SET RetCrc=?,RetPort=?,RegistroCancelado=? WHERE IdInternoCrc='" + objItensEntIntPort.getIdInternoCrc() + "'AND IdRetorno='" + objItensEntIntPort.getIdRetorno() + "'");
            pst.setString(1, objItensEntIntPort.getConfirmaEntrada());
            pst.setString(2, objItensEntIntPort.getConfirmaRetPort());
            pst.setString(3, objItensEntIntPort.getRegistroCancelado());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel CONFIRMAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensEntIntPort;
    }

    public ItensEntradaInternosPortaria confirmarEntradaPortariaCrcRET(ItensEntradaInternosPortaria objItensEntIntPort) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSREGISTRO SET RegistroCancelado=? WHERE IdInternoCrc='" + objItensEntIntPort.getIdInternoCrc() + "'AND IdRetorno='" + objItensEntIntPort.getIdRetorno() + "' AND OrigemRetorno='" + objItensEntIntPort.getOrigemInterno() + "'");
            pst.setString(1, objItensEntIntPort.getRegistroCancelado());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel CONFIRMAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensEntIntPort;
    }
    
    public ItensEntradaInternosPortaria confirmarMOVI_RETORNO(ItensEntradaInternosPortaria objItensEntIntPort) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE MOVISR SET IdRetorno=?,DataRetorno=?,NrDocRetorno=?,IdItemRetorno=? WHERE IdInternoCrc='" + objItensEntIntPort.getIdInternoCrc()+ "'AND IdRetorno='" + objItensEntIntPort.getIdRetorno() + "'");
            pst.setInt(1, objItensEntIntPort.getIdRetorno());
            pst.setDate(2, null);
            pst.setString(3, objItensEntIntPort.getNumeroOficio());
            pst.setInt(4, objItensEntIntPort.getIdItem());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel CONFIRMAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensEntIntPort;
    }
}
