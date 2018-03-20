/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.Enderecos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleEnderecosColaborador {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    Enderecos objEnd = new Enderecos();

    public Enderecos incluirEnderecosColaborador(Enderecos objEnd) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ENDERECOS (Endereco,BairroEnd,CompEnd,CidadeEnd,UfEnd,CepEnd,FoneEnd,TelEnd,CelEnd,EmailEnd,Url,Observacao,IdFunc,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objEnd.getEndereco());
            pst.setString(2, objEnd.getBairroEnd());
            pst.setString(3, objEnd.getCompEnd());
            pst.setString(4, objEnd.getCidadeEnd());
            pst.setString(5, objEnd.getEstadoEnd());
            pst.setString(6, objEnd.getCepEnd());
            pst.setString(7, objEnd.getFoneEnd());
            pst.setString(8, objEnd.getTelEnd());
            pst.setString(9, objEnd.getCelEnd());
            pst.setString(10, objEnd.getEmalEnd());
            pst.setString(11, objEnd.getUrl());
            pst.setString(12, objEnd.getObservacao());
            pst.setInt(13, objEnd.getIdFunc());
            pst.setString(14, objEnd.getUsuarioInsert());
            pst.setString(15, objEnd.getDataInsert());
            pst.setString(16, objEnd.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INCLUIR os Dados.(ENDEREÇOS)\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEnd;
    }

    public Enderecos alterarEnderecoColaborador(Enderecos objEnd) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENDERECOS SET Endereco=?,BairroEnd=?,CompEnd=?,CidadeEnd=?,UfEnd=?,CepEnd=?,FoneEnd=?,TelEnd=?,CelEnd=?,EmailEnd=?,Url=?,Observacao=?,IdFunc=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdEnd='" + objEnd.getIdEnd() + "'AND IdFunc='" + objEnd.getIdFunc() + "'");
            pst.setString(1, objEnd.getEndereco());
            pst.setString(2, objEnd.getBairroEnd());
            pst.setString(3, objEnd.getCompEnd());
            pst.setString(4, objEnd.getCidadeEnd());
            pst.setString(5, objEnd.getEstadoEnd());
            pst.setString(6, objEnd.getCepEnd());
            pst.setString(7, objEnd.getFoneEnd());
            pst.setString(8, objEnd.getTelEnd());
            pst.setString(9, objEnd.getCelEnd());
            pst.setString(10, objEnd.getEmalEnd());
            pst.setString(11, objEnd.getUrl());
            pst.setString(12, objEnd.getObservacao());
            pst.setInt(13, objEnd.getIdFunc());
            pst.setString(14, objEnd.getUsuarioUp());
            pst.setString(15, objEnd.getDataUp());
            pst.setString(16, objEnd.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEnd;
    }

    public Enderecos excluiEnderecosColaborador(Enderecos objEnd) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ENDERECOS WHERE IdEnd='" + objEnd.getIdEnd() + "'AND IdFunc='" + objEnd.getIdFunc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEnd;
    }
}
