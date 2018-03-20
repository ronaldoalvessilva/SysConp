/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EntradaObjetosPertences;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControlEntradaObjetos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EntradaObjetosPertences objEntraObj = new EntradaObjetosPertences();
    int codInterno;

    public EntradaObjetosPertences incluirEntradaObjetos(EntradaObjetosPertences objEntraObj) {
        buscarInternoCrc(objEntraObj.getNomeInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ENTRADAOBJETOSPERTENCES (StatusLanc,DataLanc,IdInternoCrc,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");
            pst.setString(1, objEntraObj.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objEntraObj.getDataLanc().getTime()));
            pst.setInt(3, codInterno);
            pst.setString(4, objEntraObj.getObservacao());
            pst.setString(5, objEntraObj.getUsuarioInsert());
            pst.setString(6, objEntraObj.getDataInsert());
            pst.setString(7, objEntraObj.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objEntraObj;
    }

    public EntradaObjetosPertences alterarEntradaObjetos(EntradaObjetosPertences objEntraObj) {
        buscarInternoCrc(objEntraObj.getNomeInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADAOBJETOSPERTENCES SET StatusLanc=?,DataLanc=?,IdInternoCrc=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdEntrada='" + objEntraObj.getIdLanc() + "'");
            pst.setString(1, objEntraObj.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objEntraObj.getDataLanc().getTime()));
            pst.setInt(3, codInterno);
            pst.setString(4, objEntraObj.getObservacao());
            pst.setString(5, objEntraObj.getUsuarioUp());
            pst.setString(6, objEntraObj.getDataUp());
            pst.setString(7, objEntraObj.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objEntraObj;
    }

    public EntradaObjetosPertences excluirEntradaObjetos(EntradaObjetosPertences objEntraObj) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ENTRADAOBJETOSPERTENCES WHERE IdEntrada=" + objEntraObj.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objEntraObj;
    }

    public EntradaObjetosPertences finalizarEntradaObjetos(EntradaObjetosPertences objEntraObj) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADAOBJETOSPERTENCES SET StatusLanc=? WHERE IdEntrada='" + objEntraObj.getIdLanc() + "'");
            pst.setString(1, objEntraObj.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objEntraObj;
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
