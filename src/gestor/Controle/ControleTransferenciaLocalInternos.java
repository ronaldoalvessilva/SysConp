/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.TransferenciaLocalInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleTransferenciaLocalInternos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    TransferenciaLocalInternos objTranLocalInt = new TransferenciaLocalInternos();

    public TransferenciaLocalInternos incluirTransIntLocal(TransferenciaLocalInternos objTranLocalInt) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO TRANSFERENCIALOCAL (StatusLanc,DataLanc,IdInternoCrc,IdCela,DescricaoCelaOrigem,DescricaoPavilhaoOrigem,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objTranLocalInt.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objTranLocalInt.getDataLanc().getTime()));
            pst.setInt(3, objTranLocalInt.getIdInternoCrc());
            pst.setInt(4, objTranLocalInt.getIdCela());
            pst.setString(5, objTranLocalInt.getDescricaoCelaOrigem());
            pst.setString(6, objTranLocalInt.getDescricaoPavilhaoOrigem());
            pst.setString(7, objTranLocalInt.getUsuarioInsert());
            pst.setString(8, objTranLocalInt.getDataInsert());
            pst.setString(9, objTranLocalInt.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objTranLocalInt;
    }

    public TransferenciaLocalInternos alterarTransIntLocal(TransferenciaLocalInternos objTranLocalInt) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE TRANSFERENCIALOCAL SET StatusLanc=?,DataLanc=?,IdInternoCrc=?,IdCela=?,DescricaoCelaOrigem=?,DescricaoPavilhaoOrigem=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdLanc='" + objTranLocalInt.getIdLanc() + "'");
            pst.setString(1, objTranLocalInt.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objTranLocalInt.getDataLanc().getTime()));
            pst.setInt(3, objTranLocalInt.getIdInternoCrc());
            pst.setInt(4, objTranLocalInt.getIdCela());
            pst.setString(5, objTranLocalInt.getDescricaoCelaOrigem());
            pst.setString(6, objTranLocalInt.getDescricaoPavilhaoOrigem());
            pst.setString(7, objTranLocalInt.getUsuarioUp());
            pst.setString(8, objTranLocalInt.getDataUp());
            pst.setString(9, objTranLocalInt.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objTranLocalInt;
    }

    public TransferenciaLocalInternos excluirTransIntLocal(TransferenciaLocalInternos objTranLocalInt) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM TRANSFERENCIALOCAL WHERE IdLanc='" + objTranLocalInt.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objTranLocalInt;
    }    
}
