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
public class ControleItensRegistroCanceladoCrc_SAIDAS {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensRegistroCanceladoCrc objItensRecCancel = new ItensRegistroCanceladoCrc();

    public ItensRegistroCanceladoCrc incluirRegCanceladoRE(ItensRegistroCanceladoCrc objItensRecCancel) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_REGISTRO_CANCELADO_SAIDAS (IdRegCancelSA,DataSaida,IdInternoCrc,NrDocumento,HoraSaida,ConfirmacaoRegistro,TipoSaidaCrcPortaria,SetorSaidaCrcPortaria,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objItensRecCancel.getIdLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objItensRecCancel.getDataSaida().getTime()));
            pst.setInt(3, objItensRecCancel.getIdInternoCrc());
            pst.setString(4, objItensRecCancel.getNrDocumento());
            pst.setString(5, objItensRecCancel.getHoraSaida());
            pst.setString(6, objItensRecCancel.getConfirmacaoRegistro());
            pst.setString(7, objItensRecCancel.getTipoRetorno());
            pst.setString(8, objItensRecCancel.getSetor());
            pst.setString(9, objItensRecCancel.getUsuarioInsert());
            pst.setString(10, objItensRecCancel.getDataInsert());
            pst.setString(11, objItensRecCancel.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensRecCancel;
    }

    public ItensRegistroCanceladoCrc alterarRegCanceladoRE(ItensRegistroCanceladoCrc objItensRecCancel) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_REGISTRO_CANCELADO_SAIDAS SET IdRegCancel=?,DataSaida=?,IdInternoCrc=?,NrDocumento=?,HoraSaida=?,ConfirmacaoRegistro=?,TipoSaidaCrcPortaria=?,SetorSaidaCrcPortaria=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItemSA='" + objItensRecCancel.getIdItem() + "'AND NomeInternoCrc='" + objItensRecCancel.getNomeInternoCrc() + "'");
            pst.setInt(1, objItensRecCancel.getIdLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objItensRecCancel.getDataSaida().getTime()));
            pst.setInt(3, objItensRecCancel.getIdInternoCrc());
            pst.setString(4, objItensRecCancel.getNrDocumento());
            pst.setString(5, objItensRecCancel.getHoraSaida());
            pst.setString(6, objItensRecCancel.getConfirmacaoRegistro());
            pst.setString(7, objItensRecCancel.getTipoRetorno());
            pst.setString(8, objItensRecCancel.getSetor());
            pst.setString(9, objItensRecCancel.getUsuarioUp());
            pst.setString(10, objItensRecCancel.getDataUp());
            pst.setString(11, objItensRecCancel.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensRecCancel;
    }

    public ItensRegistroCanceladoCrc excluirRegCanceladoRE(ItensRegistroCanceladoCrc objItensRecCancel) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_REGISTRO_CANCELADO_SAIDAS WHERE IdItemSA='" + objItensRecCancel.getIdItem() + "'AND NomeInternoCrc='" + objItensRecCancel.getNomeInternoCrc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensRecCancel;
    }
}
