/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.TransferenciaValores;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleTransferenciaValores {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    TransferenciaValores objTransVal = new TransferenciaValores();
    int codInt;

    public TransferenciaValores incluirTransferencia(TransferenciaValores objTransVal) {
        buscarInterno(objTransVal.getNomeInternoCrc(), objTransVal.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO TRANSFERENCIA_VALORES_INATIVOS (StatusLanc,DataLanc,IdInternoCrc,SaldoContaAtiva,ValorTransferido,Motivo,TipoTransferencia,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objTransVal.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objTransVal.getDataLanc().getTime()));
            pst.setInt(3, codInt);
            pst.setDouble(4, objTransVal.getSaldoContaAtiva());
            pst.setDouble(5, objTransVal.getValorTransferido());
            pst.setString(6, objTransVal.getMotivo());
            pst.setString(7, objTransVal.getTipoTransferencia());
            pst.setString(8, objTransVal.getUsuarioInsert());
            pst.setString(9, objTransVal.getDataInsert());
            pst.setString(10, objTransVal.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objTransVal;
    }

    public TransferenciaValores alterarTransferencia(TransferenciaValores objTransVal) {
        buscarInterno(objTransVal.getNomeInternoCrc(), objTransVal.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE TRANSFERENCIA_VALORES_INATIVOS SET StatusLanc=?,DataLanc=?,IdInternoCrc=?,SaldoContaAtiva=?,ValorTransferido=?,TipoTransferencia=?,Motivo=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdLanc='" + objTransVal.getIdLanc() + "'");
            pst.setString(1, objTransVal.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objTransVal.getDataLanc().getTime()));
            pst.setInt(3, codInt);
            pst.setDouble(4, objTransVal.getSaldoContaAtiva());
            pst.setDouble(5, objTransVal.getValorTransferido());
            pst.setString(6, objTransVal.getMotivo());
            pst.setString(7, objTransVal.getTipoTransferencia());
            pst.setString(8, objTransVal.getUsuarioUp());
            pst.setString(9, objTransVal.getDataUp());
            pst.setString(10, objTransVal.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objTransVal;
    }

    public TransferenciaValores excluirTransferencia(TransferenciaValores objTransVal) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM TRANSFERENCIA_VALORES_INATIVOS WHERE IdLanc='" + objTransVal.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objTransVal;
    }

    public void buscarInterno(String nome, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + nome + "'AND IdInternoCrc='" + codigo + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados da VISITA a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
