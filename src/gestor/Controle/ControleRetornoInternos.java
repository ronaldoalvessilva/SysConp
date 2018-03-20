/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.RetornoInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleRetornoInternos {
    ConexaoBancoDados conecta = new ConexaoBancoDados();
    RetornoInternos objRetorno = new RetornoInternos();    
    int codOpe;
    // Inclusão de retorno
    public RetornoInternos incluirRetornoInternos(RetornoInternos objRetorno){
        buscarOperacao(objRetorno.getNomeOperacao());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO RETORNOSCRC (ObsRetorno,StatusRet,IdOp,DataLancRetorno,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");                        
            pst.setString(1, objRetorno.getObsRetorno());
            pst.setString(2, objRetorno.getStatusRetorno());
            pst.setInt(3, codOpe);
            pst.setTimestamp(4, new java.sql.Timestamp(objRetorno.getDateLancamento().getTime()));
            pst.setString(5, objRetorno.getNomeUsuario());
            pst.setString(6, objRetorno.getDataInsert());
            pst.setString(7, objRetorno.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objRetorno;        
    }
    //
    public RetornoInternos alterarRetornoInternos(RetornoInternos objRetorno){
        buscarOperacao(objRetorno.getNomeOperacao());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE RETORNOSCRC SET ObsRetorno=?,StatusRet=?,IdOp=?,DataLancRetorno=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdRetorno='" + objRetorno.getIdRetorno()  + "'");                        
            pst.setString(1, objRetorno.getObsRetorno());
            pst.setString(2, objRetorno.getStatusRetorno());
            pst.setInt(3, codOpe);
            pst.setTimestamp(4, new java.sql.Timestamp(objRetorno.getDateLancamento().getTime()));
            pst.setString(5, objRetorno.getNomeUsuario());
            pst.setString(6, objRetorno.getDataUpdate());
            pst.setString(7, objRetorno.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objRetorno;        
    }
    public RetornoInternos excluirRetornoInternos(RetornoInternos objRetorno){       
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM RETORNOSCRC WHERE IdRetorno='" + objRetorno.getIdRetorno() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objRetorno;        
    }
    public RetornoInternos finalizarRetornoInternos(RetornoInternos objRetorno){       
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE RETORNOSCRC SET StatusRet=? WHERE IdRetorno='" + objRetorno.getIdRetorno() + "'");
            pst.setString(1, objRetorno.getStatusRetorno());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objRetorno;        
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
