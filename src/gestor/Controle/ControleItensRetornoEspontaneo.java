/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensRecaptura;
import gestor.Modelo.ItensRetornoEspontaneo;
import gestor.Modelo.RetornoEspontaneo;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleItensRetornoEspontaneo {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    RetornoEspontaneo objRetEspontaneo = new RetornoEspontaneo();
    ItensRetornoEspontaneo objItensRetEsp = new ItensRetornoEspontaneo();
    int codInt;
    int qtdUnit = 1;

    public ItensRetornoEspontaneo incluirItensRetornoEspontaneo(ItensRetornoEspontaneo objItensRetEsp) {
        buscarInternoCrc(objItensRetEsp.getNomeInterno(), objItensRetEsp.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENSRETORNOESPONTANEO (IdInternoCrc,IdRetorno,DataRetorno,OrigemRetorno,IdRegistro,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?)");
            pst.setInt(1, codInt);
            pst.setInt(2, objItensRetEsp.getIdRetorno());
            pst.setTimestamp(3, new java.sql.Timestamp(objItensRetEsp.getDataRetorno().getTime()));
            pst.setString(4, objItensRetEsp.getOrigemRetorno());
            pst.setInt(5, objItensRetEsp.getIdRegistro());
            pst.setString(6, objItensRetEsp.getUsuarioInsert());
            pst.setString(7, objItensRetEsp.getDataInsert());
            pst.setString(8, objItensRetEsp.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensRetEsp;
    }

    public ItensRetornoEspontaneo alterarItensRetornoEspontaneo(ItensRetornoEspontaneo objItensRetEsp) {
        buscarInternoCrc(objItensRetEsp.getNomeInterno(), objItensRetEsp.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSRETORNOESPONTANEO SET IdInternoCrc=?,IdRetorno=?,DataRetorno=?,OrigemRetorno=?,IdRegistro=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objItensRetEsp.getIdItem() + "'");
            pst.setInt(1, codInt);
            pst.setInt(2, objItensRetEsp.getIdRetorno());
            pst.setTimestamp(3, new java.sql.Timestamp(objItensRetEsp.getDataRetorno().getTime()));
            pst.setString(4, objItensRetEsp.getOrigemRetorno());
            pst.setInt(5, objItensRetEsp.getIdRegistro());
            pst.setString(6, objItensRetEsp.getUsuarioUp());
            pst.setString(7, objItensRetEsp.getDataUp());
            pst.setString(8, objItensRetEsp.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensRetEsp;
    }

    //Método para excluir ITENS DE RETORNO ESPONTANEO
    public ItensRetornoEspontaneo excluirItensRetornoEspontaneo(ItensRetornoEspontaneo objItensRetEsp) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst;
            pst = conecta.con.prepareStatement("DELETE FROM ITENSRETORNOESPONTANEO WHERE IdItem='" + objItensRetEsp.getIdItem() + "'");
            pst.execute();
            conecta.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\n ERRO\n" + ex);
        }
        conecta.desconecta();
        return objItensRetEsp;

    }
 //----------------------------------------- RETORNO ESPONANEO -----------------------------------

    // Confirmar a utilização do registro de retorno
    public ItensRetornoEspontaneo alterarRegItensRetornoEspontaneo(ItensRetornoEspontaneo objItensRetEsp) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSREGISTRO SET ConfirmacaoRetorno=? WHERE IdItem='" + objItensRetEsp.getIdItem() + "'OR IdItem='" + objItensRetEsp.getIdRetorno() + "'");
            pst.setString(1, objItensRetEsp.getConfirmaRetorno());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensRetEsp;
    }

    // Confirmar a utilização do registro de retorno
    public ItensRetornoEspontaneo excluirRegItensRetornoEspontaneo(ItensRetornoEspontaneo objItensRetEsp) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSREGISTRO SET ConfirmacaoRetorno=? WHERE IdItem='" + objItensRetEsp.getIdRegistro() + "'AND IdInternoCrc='" + objItensRetEsp.getIdInternoCrc() + "'");
            pst.setString(1, objItensRetEsp.getConfirmaRetorno());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensRetEsp;
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
