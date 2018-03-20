/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.RecapturaInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleRecapturaInternos {
    ConexaoBancoDados conecta = new ConexaoBancoDados();
    RecapturaInternos objRecap = new RecapturaInternos(); 
    int codOpe;
    // Inclusão de retorno
    public RecapturaInternos incluirRecapturaInternos(RecapturaInternos objRecap){
        buscarOperacao(objRecap.getNomeOperacao());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO RECAPTURA (ObsRetorno,StatusRet,IdOp,DataLancRetorno,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");                        
            pst.setString(1, objRecap.getObsRetorno());
            pst.setString(2, objRecap.getStatusRet());
            pst.setInt(3, codOpe);
            pst.setTimestamp(4, new java.sql.Timestamp(objRecap.getDataLancRetorno().getTime()));
            pst.setString(5, objRecap.getNomeUsuarioInsert());
            pst.setString(6, objRecap.getDataInsert());
            pst.setString(7, objRecap.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objRecap;        
    }
    //
    public RecapturaInternos  alterarRecapturaInternos(RecapturaInternos objRecap){
        buscarOperacao(objRecap.getNomeOperacao());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE RECAPTURA SET ObsRetorno=?,StatusRet=?,IdOp=?,DataLancRetorno=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdRecaptura='" + objRecap.getIdRecaptura() + "'");                        
            pst.setString(1, objRecap.getObsRetorno());
            pst.setString(2, objRecap.getStatusRet());
            pst.setInt(3, codOpe);
            pst.setTimestamp(4, new java.sql.Timestamp(objRecap.getDataLancRetorno().getTime()));
            pst.setString(5, objRecap.getNomeUsuarioUpdate());
            pst.setString(6, objRecap.getDataUp());
            pst.setString(7, objRecap.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objRecap;        
    }
    public RecapturaInternos excluirRecapturaInternos(RecapturaInternos objRecap){       
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM RECAPTURA WHERE IdRecaptura='" + objRecap.getIdRecaptura() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objRecap;        
    }
    public RecapturaInternos finalizarRecapturaInternos(RecapturaInternos objRecap){       
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE RECAPTURA SET StatusRet=? WHERE IdRecaptura='" + objRecap.getIdRecaptura() + "'");
            pst.setString(1, objRecap.getStatusRet());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objRecap;        
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
