/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.SaidaInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleSaidaInternos {
    ConexaoBancoDados conecta = new ConexaoBancoDados();
    SaidaInternos objSaida = new SaidaInternos();
    int codOpe;
    
    public SaidaInternos incluirSaidaInternos(SaidaInternos objSaida){
        buscarOperacao(objSaida.getNomeOperacao());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO SAIDACRC (ObsSaida,StatusSai,IdOp,DataLancaMov,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");                        
            pst.setString(1, objSaida.getObsSaida());
            pst.setString(2, objSaida.getStatusSaida());
            pst.setInt(3, codOpe);
            pst.setTimestamp(4, new java.sql.Timestamp(objSaida.getDataLanc().getTime()));
            pst.setString(5, objSaida.getUsuarioInsert());
            pst.setString(6, objSaida.getDataInsert());
            pst.setString(7, objSaida.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objSaida;
        
    }
    public SaidaInternos alterarSaidaInternos(SaidaInternos objSaida){
        buscarOperacao(objSaida.getNomeOperacao());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE SAIDACRC SET ObsSaida=?,StatusSai=?,IdOp=?,DataLancaMov=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdSaida='" + objSaida.getIdSaida() + "'");                        
            pst.setString(1, objSaida.getObsSaida());
            pst.setString(2, objSaida.getStatusSaida());
            pst.setInt(3, codOpe);
            pst.setTimestamp(4, new java.sql.Timestamp(objSaida.getDataLanc().getTime()));
            pst.setString(5, objSaida.getUsuarioUp());
            pst.setString(6, objSaida.getDataUp());
            pst.setString(7, objSaida.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objSaida;
        
    }
    //Método para excluir ENTRADAS    
    public SaidaInternos excluirSaidaInternos(SaidaInternos objSaida) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst;
            pst = conecta.con.prepareStatement("DELETE FROM SAIDACRC WHERE IdSaida='" + objSaida.getIdSaida() + "'");            
            pst.executeUpdate();            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\n ERRO\n" + ex);
        }
        conecta.desconecta();
        return objSaida;
    }
    //Método para excluir ENTRADAS    
    public SaidaInternos finalizarSaidaInternos(SaidaInternos objSaida) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst;
            pst = conecta.con.prepareStatement("UPDATE SAIDACRC SET StatusSai=? WHERE IdSaida='" + objSaida.getIdSaida() + "'");            
            pst.setString(1, objSaida.getStatusSaida());
            pst.executeUpdate();            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\n ERRO\n" + ex);
        }
        conecta.desconecta();
        return objSaida;
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
