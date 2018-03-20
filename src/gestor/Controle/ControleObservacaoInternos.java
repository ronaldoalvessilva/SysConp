/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ObservacaoInterno;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleObservacaoInternos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ObservacaoInterno objObsInt = new ObservacaoInterno();

    public ObservacaoInterno incluirObservacaoInterno(ObservacaoInterno objObsInt) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO REGOBSERVACOES (IdInternoCrc,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?)");
            pst.setInt(1, objObsInt.getIdInterno());
            pst.setString(2, objObsInt.getObservacao());
            pst.setString(3, objObsInt.getUsuarioInsert());
            pst.setString(4, objObsInt.getDataInsert());
            pst.setString(5, objObsInt.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel inserir observação do interno\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objObsInt;
    }
    public ObservacaoInterno alterarObservacaoInterno(ObservacaoInterno objObsInt) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REGOBSERVACOES SET IdInternoCrc=?,Observacao=?,UsuariouP=?,DataUp=?,HorarioUp=? WHERE IdInternoCrc='" + objObsInt.getIdInterno()  + "'");
            pst.setInt(1, objObsInt.getIdInterno());
            pst.setString(2, objObsInt.getObservacao());
            pst.setString(3, objObsInt.getUsuarioInsert());
            pst.setString(4, objObsInt.getDataInsert());
            pst.setString(5, objObsInt.getHorarioInsert());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel alterar observação do interno\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objObsInt;
    }
     public ObservacaoInterno excluirObservacaoInterno(ObservacaoInterno objObsInt) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM REGOBSERVACOES WHERE IdInternoCrc='" + objObsInt.getIdInterno()  + "'");            
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel excluir observação do interno\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objObsInt;
    }
}
