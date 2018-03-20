/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensDepositoPortaria;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleItensDepositoPortaria {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensDepositoPortaria objItensDepoPort = new ItensDepositoPortaria();
    int codInterno;

    public ItensDepositoPortaria incluirDepositoPortaria(ItensDepositoPortaria objItensDepoPort) {
        buscarInterno(objItensDepoPort.getNomeInterno(),objItensDepoPort.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENSDEPOSITOPORTARIA (IdLanc,IdInternoCrc,ValorDeposito,DataDeposito,Efetuado,OrigemDeposito,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objItensDepoPort.getIdlanc());
            pst.setInt(2, codInterno);
            pst.setFloat(3, objItensDepoPort.getValorDeposito());
            pst.setTimestamp(4, new java.sql.Timestamp(objItensDepoPort.getDataDeposito().getTime()));
            pst.setString(5, objItensDepoPort.getEfetuado());
            pst.setString(6, objItensDepoPort.getOrigemDeposito());
            pst.setString(7, objItensDepoPort.getUsuarioInsert());
            pst.setString(8, objItensDepoPort.getDataInsert());
            pst.setString(9, objItensDepoPort.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensDepoPort;
    }

    public ItensDepositoPortaria alterarDepositoPortaria(ItensDepositoPortaria objItensDepoPort) {
        buscarInterno(objItensDepoPort.getNomeInterno(),objItensDepoPort.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSDEPOSITOPORTARIA SET IdLanc=?,IdInternoCrc=?,ValorDeposito=?,DataDeposito=?,Efetuado=?,OrigemDeposito=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objItensDepoPort.getIdItem() + "'");
            pst.setInt(1, objItensDepoPort.getIdlanc());
            pst.setInt(2, codInterno);
            pst.setFloat(3, objItensDepoPort.getValorDeposito());
            pst.setTimestamp(4, new java.sql.Timestamp(objItensDepoPort.getDataDeposito().getTime()));
            pst.setString(5, objItensDepoPort.getEfetuado());
            pst.setString(6, objItensDepoPort.getOrigemDeposito());
            pst.setString(7, objItensDepoPort.getUsuarioUp());
            pst.setString(8, objItensDepoPort.getDataUp());
            pst.setString(9, objItensDepoPort.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensDepoPort;
    }

    public ItensDepositoPortaria excluirDepositoPortaria(ItensDepositoPortaria objItensDepoPort) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENSDEPOSITOPORTARIA WHERE IdItem='" + objItensDepoPort.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensDepoPort;
    }

    public void buscarInterno(String desc, int cod) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + desc + "' AND IdInternoCrc='" + cod + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNO) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
