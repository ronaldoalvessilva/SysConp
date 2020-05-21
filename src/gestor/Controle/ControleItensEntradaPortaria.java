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
public class ControleItensEntradaPortaria {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensEntradaInternosPortaria objItensEntIntPort = new ItensEntradaInternosPortaria();

    public ItensEntradaInternosPortaria incluirItensEntradaPortaria(ItensEntradaInternosPortaria objItensEntIntPort) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENSENTRADAPORTARIA (IdLanc,NomeInternoCrc,DataEntrada,HoraEntrada,OficioInternos,OrigemInterno,ConfirmaEntrada,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?)");
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
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensEntIntPort;
    }

    public ItensEntradaInternosPortaria alterarItensEntradaPortaria(ItensEntradaInternosPortaria objItensEntIntPort) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSENTRADAPORTARIA SET IdLanc=?,NomeInternoCrc=?,DataEntrada=?,HoraEntrada=?,OficioInternos=?,OrigemInterno=?,ConfirmaEntrada=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objItensEntIntPort.getIdItem() + "'");
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
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensEntIntPort;
    }

    public ItensEntradaInternosPortaria excluirItensEntradaPortaria(ItensEntradaInternosPortaria objItensEntIntPort) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENSENTRADAPORTARIA WHERE IdItem='" + objItensEntIntPort.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensEntIntPort;
    }

    // Modificar como utilizado pelo Crc após o cancelamento.

    public ItensEntradaInternosPortaria confirmarEntradaPortariaCrc(ItensEntradaInternosPortaria objItensEntIntPort) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSENTRADAPORTARIA SET ConfirmaEntrada=?,RegistroCancelado=? WHERE NomeInternoCrc='" + objItensEntIntPort.getNomeInternoCrc() + "'");
            pst.setString(1, objItensEntIntPort.getConfirmaEntrada());
            pst.setString(2, objItensEntIntPort.getRegistroCancelado());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel CONFIRMAR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensEntIntPort;
    }
}
