/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensRegistroCanceladoCrc;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleItensRegistroCanceladoCrc {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensRegistroCanceladoCrc objItensRecCancel = new ItensRegistroCanceladoCrc();

    public ItensRegistroCanceladoCrc incluirRegCancelado(ItensRegistroCanceladoCrc objItensRecCancel) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENSREGISTROCANCELADO (IdLanc,DataSaida,NomeInternoCrc,NrDocumento,HoraSaida,ConfirmacaoRegistro,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objItensRecCancel.getIdLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objItensRecCancel.getDataSaida().getTime()));
            pst.setString(3, objItensRecCancel.getNomeInternoCrc());
            pst.setString(4, objItensRecCancel.getNrDocumento());
            pst.setString(5, objItensRecCancel.getHoraSaida());
            pst.setString(6, objItensRecCancel.getConfirmacaoRegistro());
            pst.setString(7, objItensRecCancel.getUsuarioInsert());
            pst.setString(8, objItensRecCancel.getDataInsert());
            pst.setString(9, objItensRecCancel.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensRecCancel;
    }

    public ItensRegistroCanceladoCrc alterarRegCancelado(ItensRegistroCanceladoCrc objItensRecCancel) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSREGISTROCANCELADO SET NrDocumento=?,HoraSaida=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objItensRecCancel.getIdItem() + "'AND NomeInternoCrc='" + objItensRecCancel.getNomeInternoCrc() + "'");
            pst.setString(1, objItensRecCancel.getNrDocumento());
            pst.setString(2, objItensRecCancel.getHoraSaida());
            pst.setString(3, objItensRecCancel.getUsuarioUp());
            pst.setString(4, objItensRecCancel.getDataUp());
            pst.setString(5, objItensRecCancel.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensRecCancel;
    }

    public ItensRegistroCanceladoCrc excluirRegCancelado(ItensRegistroCanceladoCrc objItensRecCancel) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENSREGISTROCANCELADO WHERE IdItem='" + objItensRecCancel.getIdItem() + "'AND NomeInternoCrc='" + objItensRecCancel.getNomeInternoCrc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensRecCancel;
    }
}
