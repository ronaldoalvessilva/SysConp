/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.SaidaObjetosPertences;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleSaidaObjetos {
    ConexaoBancoDados conecta = new ConexaoBancoDados();
    SaidaObjetosPertences objSaidaObj = new SaidaObjetosPertences();
    int codInterno;

    public SaidaObjetosPertences incluirSaidaObjetos(SaidaObjetosPertences objSaidaObj) {
        buscarInternoCrc(objSaidaObj.getNomeInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO SAIDAOBJETOSPERTENCES (StatusLanc,DataLanc,IdInternoCrc,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");
            pst.setString(1, objSaidaObj.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objSaidaObj.getDataLanc().getTime()));
            pst.setInt(3, codInterno);
            pst.setString(4, objSaidaObj.getObservacao());
            pst.setString(5, objSaidaObj.getUsuarioInsert());
            pst.setString(6, objSaidaObj.getDataInsert());
            pst.setString(7, objSaidaObj.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objSaidaObj;
    }

    public SaidaObjetosPertences alterarSaidaObjetos(SaidaObjetosPertences objSaidaObj) {
        buscarInternoCrc(objSaidaObj.getNomeInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE SAIDAOBJETOSPERTENCES SET StatusLanc=?,DataLanc=?,IdInternoCrc=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdSaida='" + objSaidaObj.getIdLanc() + "'");
            pst.setString(1, objSaidaObj.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objSaidaObj.getDataLanc().getTime()));
            pst.setInt(3, codInterno);
            pst.setString(4, objSaidaObj.getObservacao());
            pst.setString(5, objSaidaObj.getUsuarioUp());
            pst.setString(6, objSaidaObj.getDataUp());
            pst.setString(7, objSaidaObj.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objSaidaObj;
    }

    public SaidaObjetosPertences excluirSaidaObjetos(SaidaObjetosPertences objSaidaObj) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM SAIDAOBJETOSPERTENCES WHERE IdEntrada=" + objSaidaObj.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objSaidaObj;
    }

    public SaidaObjetosPertences finalizarSaidaObjetos(SaidaObjetosPertences objSaidaObj) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE SAIDAOBJETOSPERTENCES SET StatusLanc=? WHERE IdEntrada='" + objSaidaObj.getIdLanc() + "'");
            pst.setString(1, objSaidaObj.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objSaidaObj;
    }

    public void buscarInternoCrc(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + nome + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar o interno.\nERRO: " + e);
        }
        conecta.desconecta();
    }
}
