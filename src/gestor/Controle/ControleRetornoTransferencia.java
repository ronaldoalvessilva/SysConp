/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.RetornoPorTransferencia;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleRetornoTransferencia {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    RetornoPorTransferencia objRetTrans = new RetornoPorTransferencia();
    int codOpe;
    int codUnid;

    // Inclusão de retorno
    public RetornoPorTransferencia incluirRetonoTransferencia(RetornoPorTransferencia objRetTrans) {
        buscarOperacao(objRetTrans.getNomeOperacao());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO RETORNOTRANSFERENCIA (StatusRet,IdOp,DataLancRetorno,ObsRetorno,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");
            pst.setString(1, objRetTrans.getStatusRet());
            pst.setInt(2, codOpe);
            pst.setTimestamp(3, new java.sql.Timestamp(objRetTrans.getDataLancRetorno().getTime()));
            pst.setString(4, objRetTrans.getObsRetorno());
            pst.setString(5, objRetTrans.getNomeUsuarioInsert());
            pst.setString(6, objRetTrans.getDataInsert());
            pst.setString(7, objRetTrans.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objRetTrans;
    }

    public RetornoPorTransferencia alterarRetonoTransferencia(RetornoPorTransferencia objRetTrans) {
        buscarOperacao(objRetTrans.getNomeOperacao());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE RETORNOTRANSFERENCIA SET StatusRet=?,IdOp=?,DataLancRetorno=?,ObsRetorno=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdRetorno='" + objRetTrans.getIdRetorno() + "'");
            pst.setString(1, objRetTrans.getStatusRet());
            pst.setInt(2, codOpe);
            pst.setTimestamp(3, new java.sql.Timestamp(objRetTrans.getDataLancRetorno().getTime()));
            pst.setString(4, objRetTrans.getObsRetorno());
            pst.setString(5, objRetTrans.getNomeUsuarioUpdate());
            pst.setString(6, objRetTrans.getDataUp());
            pst.setString(7, objRetTrans.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objRetTrans;
    }

    public RetornoPorTransferencia excluirRetonoTransferencia(RetornoPorTransferencia objRetTrans) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM RETORNOTRANSFERENCIA WHERE IdRetorno='" + objRetTrans.getIdRetorno() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objRetTrans;
    }

    public RetornoPorTransferencia finalizarRetonoTransferencia(RetornoPorTransferencia objRetTrans) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE RETORNOTRANSFERENCIA SET StatusRet=? WHERE IdRetorno='" + objRetTrans.getIdRetorno() + "'");
            pst.setString(1, objRetTrans.getStatusRet());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objRetTrans;
    }

    public void buscarOperacao(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM OPERACAO WHERE DescricaoOp='" + nome + "'");
            conecta.rs.first();
            codOpe = conecta.rs.getInt("IdOp");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (OPERAÇÃO) a serem exibidos." + ex);
        }
        conecta.desconecta();
    }
}
