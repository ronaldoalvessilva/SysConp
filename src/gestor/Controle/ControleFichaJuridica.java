/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.FichaJuridica;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleFichaJuridica {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    FichaJuridica objFicha = new FichaJuridica();

    int codInterno;

    public FichaJuridica incluirFichaJuridica(FichaJuridica objFicha) {
         buscarInterno(objFicha.getNomeInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO FICHA_JURIDICA (StatusFicha,DataFicha,IdInternoCrc,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?)");
            pst.setString(1, objFicha.getStatusFicha());
            pst.setTimestamp(2, new java.sql.Timestamp(objFicha.getDataFicha().getTime())); 
            pst.setInt(3, codInterno);
            pst.setString(4, objFicha.getUsuarioInsert());
            pst.setString(5, objFicha.getDataInsert());
            pst.setString(6, objFicha.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFicha;
    }

    public FichaJuridica alterarFichaJuridica(FichaJuridica objFicha) {
        buscarInterno(objFicha.getNomeInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE FICHA_JURIDICA SET StatusFicha=?,DataFicha=?,IdInternoCrc=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdFicha='" + objFicha.getIdFicha() + "'");
            pst.setString(1, objFicha.getStatusFicha());
            pst.setTimestamp(2, new java.sql.Timestamp(objFicha.getDataFicha().getTime()));
            pst.setInt(3, codInterno);           
            pst.setString(4, objFicha.getUsuarioUp());
            pst.setString(5, objFicha.getDataUp());
            pst.setString(6, objFicha.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFicha;
    }

    public FichaJuridica excluirFichaJuridica(FichaJuridica objFicha) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM FICHA_JURIDICA WHERE IdFicha='" + objFicha.getIdFicha() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFicha;
    }

    public FichaJuridica finalizarFichaJuridica(FichaJuridica objFicha) {
        
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE FICHA_JURIDICA SET StatusFicha=? WHERE IdFicha='" + objFicha.getIdFicha() + "'");
            pst.setString(1, objFicha.getStatusFicha());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível FINALIZAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFicha;
    }

    public void buscarInterno(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + nome + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível pesquisar o interno.\nERRO: " + ex);
        }
        conecta.desconecta();
    }
}
