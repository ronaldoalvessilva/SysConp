/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.Operacao;
import gestor.Modelo.PrevisaoSaida;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControlePrevisaoSaida {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    PrevisaoSaida objPrevSaida = new PrevisaoSaida();
    Operacao objOp = new Operacao();

    int codOpe;

    //Método para SALVAR PREVISAO DE SAIDA
    public PrevisaoSaida incluirPrevisaoSaida(PrevisaoSaida objPrevSaida) {
        buscarOperacao(objPrevSaida.getDescricaoOp());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO PREVISAOSAIDA (StatusLanc,DataLanc,IdOp,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");
            pst.setString(1, objPrevSaida.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objPrevSaida.getDataLanc().getTime()));
            pst.setInt(3, codOpe);
            pst.setString(4, objPrevSaida.getObservacao());
            pst.setString(5, objPrevSaida.getUsuarioInsert());
            pst.setString(6, objPrevSaida.getDataInsert());
            pst.setString(7, objPrevSaida.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objPrevSaida;
    }

    public PrevisaoSaida alterarPrevisaoSaida(PrevisaoSaida objPrevSaida) {
        buscarOperacao(objPrevSaida.getDescricaoOp());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PREVISAOSAIDA SET StatusLanc=?,DataLanc=?,IdOp=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdLanc='" + objPrevSaida.getIdLanc() + "'");
            pst.setString(1, objPrevSaida.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objPrevSaida.getDataLanc().getTime()));
            pst.setInt(3, codOpe);
            pst.setString(4, objPrevSaida.getObservacao());
            pst.setString(5, objPrevSaida.getUsuarioUp());
            pst.setString(6, objPrevSaida.getDataUp());
            pst.setString(7, objPrevSaida.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objPrevSaida;
    }

    public PrevisaoSaida excluirPrevisaoSaida(PrevisaoSaida objPrevSaida) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM PREVISAOSAIDA WHERE IdLanc=" + objPrevSaida.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objPrevSaida;
    }

    public PrevisaoSaida finalizarPrevisaoSaida(PrevisaoSaida objPrevSaida) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PREVISAOSAIDA SET StatusLanc=? WHERE IdLanc='" + objPrevSaida.getIdLanc() + "'");
            pst.setString(1, objPrevSaida.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objPrevSaida;
    }

    public void buscarOperacao(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM OPERACAO WHERE DescricaoOp='" + nome + "'");
            conecta.rs.first();
            codOpe = conecta.rs.getInt("IdOp");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (OPERAÇÃO) a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
