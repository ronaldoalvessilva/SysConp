/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.NovaEntradaCrcP1;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ContoleNovaEntrada {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    NovaEntradaCrcP1 objNovaEnt = new NovaEntradaCrcP1();

    public NovaEntradaCrcP1 incluirNovaEntrada(NovaEntradaCrcP1 objNovaEnt) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ENTRADANOVA (StatusLanc,DataLanc,TipoOperacao,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");
            pst.setString(1, objNovaEnt.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objNovaEnt.getDataLanc().getTime()));
            pst.setString(3, objNovaEnt.getTipoOperacao());
            pst.setString(4, objNovaEnt.getObservacao());
            pst.setString(5, objNovaEnt.getUsuarioInsert());
            pst.setString(6, objNovaEnt.getDataInsert());
            pst.setString(7, objNovaEnt.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objNovaEnt;
    }

    public NovaEntradaCrcP1 alterarNovaEntrada(NovaEntradaCrcP1 objNovaEnt) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADANOVA SET StatusLanc=?,DataLanc=?,TipoOperacao=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdEntrada='" + objNovaEnt.getIdEntrada() + "'");
            pst.setString(1, objNovaEnt.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objNovaEnt.getDataLanc().getTime()));
            pst.setString(3, objNovaEnt.getTipoOperacao());
            pst.setString(4, objNovaEnt.getObservacao());
            pst.setString(5, objNovaEnt.getUsuarioUp());
            pst.setString(6, objNovaEnt.getDataUp());
            pst.setString(7, objNovaEnt.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objNovaEnt;
    }

    public NovaEntradaCrcP1 excluirNovaEntrada(NovaEntradaCrcP1 objNovaEnt) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ENTRADANOVA WHERE IdEntrada='" + objNovaEnt.getIdEntrada() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objNovaEnt;
    }

    public NovaEntradaCrcP1 finalizarNovaEntrada(NovaEntradaCrcP1 objNovaEnt) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADANOVA SET StatusLanc=? WHERE IdEntrada='" + objNovaEnt.getIdEntrada() + "'");
            pst.setString(1, objNovaEnt.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objNovaEnt;
    }
}
