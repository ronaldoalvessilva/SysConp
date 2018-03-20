/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensLocacaoInternos;
import gestor.Modelo.TransferenciaLocalInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleSaldoInternos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    TransferenciaLocalInternos objTranLocalInt = new TransferenciaLocalInternos();
    ItensLocacaoInternos objItensLoca = new ItensLocacaoInternos();

    public ItensLocacaoInternos incluirSaldo(ItensLocacaoInternos objItensLoca) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO LOCALINTERNOS (IdInternoCrc,IdCela) VALUES(?,?)");
            pst.setInt(1, objItensLoca.getIdInternoCrc());
            pst.setInt(2, objItensLoca.getIdCela());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensLoca;
    }

    public ItensLocacaoInternos alterarSaldo(ItensLocacaoInternos objItensLoca) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE LOCALINTERNOS SET IdInternoCrc=?,IdCela=? WHERE IdInternoCrc='" + objItensLoca.getIdInternoCrc() + "'OR IdCela='" + objItensLoca.getIdCela() + "'");
            pst.setInt(1, objItensLoca.getIdInternoCrc());
            pst.setInt(2, objItensLoca.getIdCela());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensLoca;
    }

    public ItensLocacaoInternos excluirSaldo(ItensLocacaoInternos objItensLoca) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM LOCALINTERNOS WHERE IdInternoCrc='" + objItensLoca.getIdInternoCrc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensLoca;
    }
 // Alterar o local do interno, ou seja, transfere de um local para outro. (TelaTransCelas)
    public TransferenciaLocalInternos transferirInternoLocal(TransferenciaLocalInternos objTranLocalInt) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSLOCACAOINTERNO SET IdLoca=?,IdInternoCrc=?,IdCela=? WHERE IdInternoCrc='" + objTranLocalInt.getIdInternoCrc() + "'");
            pst.setInt(1, objTranLocalInt.getIdLanc());
            pst.setInt(2, objTranLocalInt.getIdInternoCrc());
            pst.setInt(3, objTranLocalInt.getIdCela());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objTranLocalInt;
    }
}
