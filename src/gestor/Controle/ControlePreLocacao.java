/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.PreLocacao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronal
 */
public class ControlePreLocacao {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    PreLocacao objPreLocacao = new PreLocacao();

    public PreLocacao incluirPreLocacao(PreLocacao objPreLocacao) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO PRE_LOCACAO_INTERNOS (StatusReg,DataReg,ObservacaoReg,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?)");
            pst.setString(1, objPreLocacao.getStatusReg());
            pst.setTimestamp(2, new java.sql.Timestamp(objPreLocacao.getDataReg().getTime()));
            pst.setString(3, objPreLocacao.getObservacao());
            pst.setString(4, objPreLocacao.getUsuarioInsert());
            pst.setString(5, objPreLocacao.getDataInsert());
            pst.setString(6, objPreLocacao.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPreLocacao;
    }

    public PreLocacao alterarPreLocacao(PreLocacao objPreLocacao) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PRE_LOCACAO_INTERNOS SET StatusReg=?,DataReg=?,ObservacaoReg=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE CodigoReg='" + objPreLocacao.getCodigoReg() + "'");
            pst.setString(1, objPreLocacao.getStatusReg());
            pst.setTimestamp(2, new java.sql.Timestamp(objPreLocacao.getDataReg().getTime()));
            pst.setString(3, objPreLocacao.getObservacao());
            pst.setString(4, objPreLocacao.getUsuarioInsert());
            pst.setString(5, objPreLocacao.getDataInsert());
            pst.setString(6, objPreLocacao.getHorarioInsert());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPreLocacao;
    }

    public PreLocacao excluirPreLocacao(PreLocacao objPreLocacao) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM PRE_LOCACAO_INTERNOS WHERE CodigoReg='" + objPreLocacao.getCodigoReg() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPreLocacao;
    }

    public PreLocacao finalizarPreLocacao(PreLocacao objPreLocacao) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PRE_LOCACAO_INTERNOS SET StatusReg=? WHERE CodigoReg='" + objPreLocacao.getCodigoReg() + "'");
            pst.setString(1, objPreLocacao.getStatusReg());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR o registro.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPreLocacao;
    }
}
