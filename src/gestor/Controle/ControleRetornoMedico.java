/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.RetornoMedico;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleRetornoMedico {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    RetornoMedico objRetMedico = new RetornoMedico();
    int codOpe;

    // Inclusão de retorno
    public RetornoMedico incluirRetonoMedico(RetornoMedico objRetMedico) {
        buscarOperacao(objRetMedico.getNomeOperacao());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO RETORNOMEDICO (ObsRetorno,StatusRet,IdOp,DataLancRetorno,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");
            pst.setString(1, objRetMedico.getObsRetorno());
            pst.setString(2, objRetMedico.getStatusRet());
            pst.setInt(3, codOpe);
            pst.setTimestamp(4, new java.sql.Timestamp(objRetMedico.getDataLancRetorno().getTime()));
            pst.setString(5, objRetMedico.getNomeUsuarioInsert());
            pst.setString(6, objRetMedico.getDataInsert());
            pst.setString(7, objRetMedico.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objRetMedico;
    }

    //
    public RetornoMedico alterarRetonoMedico(RetornoMedico objRetMedico) {
        buscarOperacao(objRetMedico.getNomeOperacao());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE RETORNOMEDICO SET ObsRetorno=?,StatusRet=?,IdOp=?,DataLancRetorno=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdRetorno='" + objRetMedico.getIdRetorno() + "'");
            pst.setString(1, objRetMedico.getObsRetorno());
            pst.setString(2, objRetMedico.getStatusRet());
            pst.setInt(3, codOpe);
            pst.setTimestamp(4, new java.sql.Timestamp(objRetMedico.getDataLancRetorno().getTime()));
            pst.setString(5, objRetMedico.getNomeUsuarioUpdate());
            pst.setString(6, objRetMedico.getDataUp());
            pst.setString(7, objRetMedico.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objRetMedico;
    }

    public RetornoMedico excluirRetonoMedico(RetornoMedico objRetMedico) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM RETORNOMEDICO WHERE IdRetorno='" + objRetMedico.getIdRetorno() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objRetMedico;
    }

    public RetornoMedico finalizarRetonoMedico(RetornoMedico objRetMedico) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE RETORNOMEDICO SET StatusRet=? WHERE IdRetorno='" + objRetMedico.getIdRetorno() + "'");
            pst.setString(1, objRetMedico.getStatusRet());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objRetMedico;
    }

    // Buscar Operação 
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
