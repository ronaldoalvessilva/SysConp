/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensNovaEntrada;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleItensEntradaNova {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensNovaEntrada objItensNova = new ItensNovaEntrada();
    int codInt;

    public ItensNovaEntrada incluiritensNovaEntrada(ItensNovaEntrada objItensNova) {
        buscarInternoCrc(objItensNova.getNomeInternoCrc(), objItensNova.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENSNOVAENTRADA (IdEntrada,IdInternoCrc,NrOficio,DataEntrada,OrigemInterno,UtilizadoCrc,UsuarioInsert,DataInsert,HorarioInsert,HorarioEntrada) VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objItensNova.getIdEntrada());
            pst.setInt(2, codInt);
            pst.setString(3, objItensNova.getNrOficio());
            pst.setTimestamp(4, new java.sql.Timestamp(objItensNova.getDataEntrada().getTime()));
            pst.setString(5, objItensNova.getOrigemInterno());
            pst.setString(6, objItensNova.getUtilizacaoCrc());
            pst.setString(7, objItensNova.getUsuarioInsert());
            pst.setString(8, objItensNova.getDataInsert());
            pst.setString(9, objItensNova.getHorarioInsert());
            pst.setString(10, objItensNova.getHorarioEntrada());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensNova;
    }

    public ItensNovaEntrada alterarItensNovaEntrada(ItensNovaEntrada objItensNova) {
        buscarInternoCrc(objItensNova.getNomeInternoCrc(), objItensNova.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSNOVAENTRADA SET IdEntrada=?,IdInternoCrc=?,NrOficio=?,DataEntrada=?,OrigemInterno=?,UtilizadoCrc=?,UsuarioUp=?,DataUp=?,HorarioUp=?,HorarioEntrada=? WHERE IdItem='" + objItensNova.getIdItem() + "'");
            pst.setInt(1, objItensNova.getIdEntrada());
            pst.setInt(2, codInt);
            pst.setString(3, objItensNova.getNrOficio());
            pst.setTimestamp(4, new java.sql.Timestamp(objItensNova.getDataEntrada().getTime()));
            pst.setString(5, objItensNova.getOrigemInterno());
            pst.setString(6, objItensNova.getUtilizacaoCrc());
            pst.setString(7, objItensNova.getUsuarioUp());
            pst.setString(8, objItensNova.getDataUp());
            pst.setString(9, objItensNova.getHorarioUp());
            pst.setString(10, objItensNova.getHorarioEntrada());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensNova;
    }

    public ItensNovaEntrada excluirItensNovaEntrada(ItensNovaEntrada objItensNova) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENSNOVAENTRADA WHERE IdItem='" + objItensNova.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensNova;
    }

    public ItensNovaEntrada alterarUtilizacaoNovaEntrada(ItensNovaEntrada objItensNova) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSNOVAENTRADA SET UtilizadoCrc=? WHERE IdInternoCrc='" + objItensNova.getIdInternoCrc() + "'AND UtilizadoCrc!='" + objItensNova.getUtilizacaoCrc() + "'");
            pst.setString(1, objItensNova.getUtilizacaoCrc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR UTILIZAÇÃO NA PORTARIA.\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensNova;
    }

    public void buscarInternoCrc(String desc, int cod) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE NomeInternoCrc='" + desc + "' "
                    + "AND IdInternoCrc='" + cod + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNOS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
