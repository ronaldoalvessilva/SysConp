/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.RegistroRetornoInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleRegistroRetornoInternos {
    ConexaoBancoDados conecta = new ConexaoBancoDados();
    RegistroRetornoInternos objRetorno = new RegistroRetornoInternos();   
    int codOpe;
    // Inclusão de retorno
    public RegistroRetornoInternos incluirRetornoInternos(RegistroRetornoInternos objRetorno){
        buscarOperacao(objRetorno.getNomeOperacao());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO REGRETORNO (ObsRetorno,StatusRet,IdOp,DataLancRetorno,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");                        
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
    public RegistroRetornoInternos alterarRetornoInternos(RegistroRetornoInternos objRetorno){
        buscarOperacao(objRetorno.getNomeOperacao());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REGRETORNO SET ObsRetorno=?,StatusRet=?,IdOp=?,DataLancRetorno=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdRetorno='" + objRetorno.getIdRetorno()  + "'");                        
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
    public RegistroRetornoInternos excluirRetornoInternos(RegistroRetornoInternos objRetorno){       
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM REGRETORNO WHERE IdRetorno='" + objRetorno.getIdRetorno() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objRetorno;        
    }
    public RegistroRetornoInternos finalizarRetornoInternos(RegistroRetornoInternos objRetorno){       
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REGRETORNO SET StatusRet=? WHERE IdRetorno='" + objRetorno.getIdRetorno() + "'");
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
