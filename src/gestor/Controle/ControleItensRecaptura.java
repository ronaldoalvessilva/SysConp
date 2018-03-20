/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensRecaptura;
import gestor.Modelo.RecapturaInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleItensRecaptura {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensRecaptura objItensRecap = new ItensRecaptura();
    RecapturaInternos objRecap = new RecapturaInternos();
    int codInt;
    int qtdUnit = 1;

    public ItensRecaptura incluirItensRecaptura(ItensRecaptura objItensRecap) {
        buscarInternoCrc(objItensRecap.getNomeInterno(), objItensRecap.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENSRECAPTURA (IdInternoCrc,IdRecaptura,DataRetorno,OrigemRetorno,DocumentoRetorno,IdRegistro,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, codInt);
            pst.setInt(2, objItensRecap.getIdRecaptura());
            pst.setTimestamp(3, new java.sql.Timestamp(objItensRecap.getDataRetorno().getTime()));
            pst.setString(4, objItensRecap.getOrigemRetorno());
            pst.setString(5, objItensRecap.getDocumentoRetorno()); 
            pst.setInt(6, objItensRecap.getIdRegistro());
            pst.setString(7, objItensRecap.getUsuarioInsert());
            pst.setString(8, objItensRecap.getDataInsert());
            pst.setString(9, objItensRecap.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados. (ITENSRECAPTURA)\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objItensRecap;
    }

    public ItensRecaptura alterarItensRecaptura(ItensRecaptura objItensRecap) {
        buscarInternoCrc(objItensRecap.getNomeInterno(), objItensRecap.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSRECAPTURA SET IdInternoCrc=?,IdRecaptura=?,DataRetorno=?,OrigemRetorno=?,DocumentoRetorno=?,IdRegistro=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objItensRecap.getIdItem() + "'");
            pst.setInt(1, codInt);
            pst.setInt(2, objItensRecap.getIdRecaptura());
            pst.setTimestamp(3, new java.sql.Timestamp(objItensRecap.getDataRetorno().getTime()));
            pst.setString(4, objItensRecap.getOrigemRetorno());
            pst.setString(5, objItensRecap.getDocumentoRetorno()); 
            pst.setInt(6, objItensRecap.getIdRegistro());
            pst.setString(7, objItensRecap.getUsuarioUp());
            pst.setString(8, objItensRecap.getDataUp());
            pst.setString(9, objItensRecap.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensRecap;
    }

    //Método para excluir ITENS DE SAIDA
    public ItensRecaptura excluirItensRecaptura(ItensRecaptura objItensRecap) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst;
            pst = conecta.con.prepareStatement("DELETE FROM ITENSRECAPTURA WHERE IdItem='" + objItensRecap.getIdItem() + "'");
            pst.execute();
            conecta.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\n ERRO\n" + ex);
        }
        conecta.desconecta();
        return objItensRecap;

    }
 //------------------------------------ RETORNO RECAPTURA ---------------------------------------
    // Confirmar a utilização do registro de retorno
    public ItensRecaptura alterarRegItensRetornoRecaptura(ItensRecaptura objItensRecap) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSREGISTRO SET ConfirmacaoRetorno=? WHERE IdItem='" + objItensRecap.getIdItem() + "'OR IdItem='" + objItensRecap.getIdRecaptura() + "'");
            pst.setString(1, objItensRecap.getConfirmaRecaptura());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensRecap;
    }

    // Confirmar a utilização do registro de retorno
    public ItensRecaptura excluirRegItensRetornoRecaptura(ItensRecaptura objItensRecap) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSREGISTRO SET ConfirmacaoRetorno=? WHERE IdItem='" + objItensRecap.getIdRecaptura() + "'AND IdInternoCrc='" + objItensRecap.getIdInternoCrc() + "'");
            pst.setString(1, objItensRecap.getConfirmaRecaptura());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensRecap;
    }
    // Buscar INTERNO
     public void buscarInternoCrc(String desc, int cod) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE NomeInternoCrc='" + desc + "' AND IdInternoCrc='" + cod + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNOS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
