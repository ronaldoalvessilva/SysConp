/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.SaqueValores;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleSaqueInativos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    SaqueValores objSaque = new SaqueValores();
    int codInt;

    public SaqueValores incluirSaqueInativos(SaqueValores objSaque) {
        buscarInterno(objSaque.getNomeInterno(), objSaque.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO SAQUE_INATIVOS (StatusLanc,DataLanc,IdInternoCrc,ValorSaque,Favorecido,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objSaque.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objSaque.getDataLanc().getTime()));
            pst.setInt(3, codInt);
            pst.setFloat(4, objSaque.getValorSaque());
            pst.setString(5, objSaque.getFavorecido());
            pst.setString(6, objSaque.getObservacao());
            pst.setString(7, objSaque.getUsuarioInsert());
            pst.setString(8, objSaque.getDataInsert());
            pst.setString(9, objSaque.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSaque;
    }

    public SaqueValores alterarSaqueInativos(SaqueValores objSaque) {
        buscarInterno(objSaque.getNomeInterno(), objSaque.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE SAQUE_INATIVOS SET StatusLanc=?,DataLanc=?,IdInternoCrc=?,ValorSaque=?,Favorecido=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdSaqIna='" + objSaque.getIdLanc() + "'");
            pst.setString(1, objSaque.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objSaque.getDataLanc().getTime()));
            pst.setInt(3, codInt);
            pst.setFloat(4, objSaque.getValorSaque());
            pst.setString(5, objSaque.getFavorecido());
            pst.setString(6, objSaque.getObservacao());
            pst.setString(7, objSaque.getUsuarioUp());
            pst.setString(8, objSaque.getDataUp());
            pst.setString(9, objSaque.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSaque;
    }

    public SaqueValores excluirSaqueInativos(SaqueValores objSaque) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM SAQUE_INATIVOS WHERE IdSaqIna='" + objSaque.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSaque;
    }

    public SaqueValores finalizarDepositos(SaqueValores objSaque) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE SAQUE_INATIVOS SET StatusLanc=? WHERE IdSaqIna='" + objSaque.getIdLanc() + "'");
            pst.setString(1, objSaque.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSaque;
    }

    public SaqueValores salvarReciboSaque(SaqueValores objSaque) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE SAQUE_INATIVOS SET ReciboSaque=? WHERE IdSaqIna='" + objSaque.getIdLanc() + "'");
            pst.setString(1, objSaque.getReciboSaque());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel SALVAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSaque;
    }

    public void buscarInterno(String nome, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + nome + "'AND IdInternoCrc='" + codigo + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados do INTERNO a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
