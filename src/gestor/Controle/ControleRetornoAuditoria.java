/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.RetornoEspontaneo;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleRetornoAuditoria {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    RetornoEspontaneo objRetEspontaneo = new RetornoEspontaneo();
    int codOpe;

    // Inclusão de retorno

    public RetornoEspontaneo incluirRetonoEspontaneo(RetornoEspontaneo objRetEspontaneo) {
        buscarOperacao(objRetEspontaneo.getNomeOperacao());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO RETORNOAUDIENCIA (ObsRetorno,StatusRet,IdOp,DataLancRetorno,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");
            pst.setString(1, objRetEspontaneo.getObsRetorno());
            pst.setString(2, objRetEspontaneo.getStatusRet());
            pst.setInt(3, codOpe);
            pst.setTimestamp(4, new java.sql.Timestamp(objRetEspontaneo.getDataLancRetorno().getTime()));
            pst.setString(5, objRetEspontaneo.getNomeUsuarioInsert());
            pst.setString(6, objRetEspontaneo.getDataInsert());
            pst.setString(7, objRetEspontaneo.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objRetEspontaneo;
    }

    //

    public RetornoEspontaneo alterarRetonoEspontaneo(RetornoEspontaneo objRetEspontaneo) {
        buscarOperacao(objRetEspontaneo.getNomeOperacao());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE RETORNOAUDIENCIA SET ObsRetorno=?,StatusRet=?,IdOp=?,DataLancRetorno=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdRetorno='" + objRetEspontaneo.getIdRetorno() + "'");
            pst.setString(1, objRetEspontaneo.getObsRetorno());
            pst.setString(2, objRetEspontaneo.getStatusRet());
            pst.setInt(3, codOpe);
            pst.setTimestamp(4, new java.sql.Timestamp(objRetEspontaneo.getDataLancRetorno().getTime()));
            pst.setString(5, objRetEspontaneo.getNomeUsuarioUpdate());
            pst.setString(6, objRetEspontaneo.getDataUp());
            pst.setString(7, objRetEspontaneo.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objRetEspontaneo;
    }

    public RetornoEspontaneo excluirRetonoEspontaneo(RetornoEspontaneo objRetEspontaneo) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM RETORNOAUDIENCIA WHERE IdRetorno='" + objRetEspontaneo.getIdRetorno() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objRetEspontaneo;
    }

    public RetornoEspontaneo finalizarRetonoEspontaneo(RetornoEspontaneo objRetEspontaneo) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE RETORNOAUDIENCIA SET StatusRet=? WHERE IdRetorno='" + objRetEspontaneo.getIdRetorno() + "'");
            pst.setString(1, objRetEspontaneo.getStatusRet());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objRetEspontaneo;
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
