/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EntradaLote;
import gestor.Modelo.Operacao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleEntradaLote {
                
    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EntradaLote objEntLote = new EntradaLote();
    Operacao objOp = new Operacao();
    
    int codOpe;

    //Método para SALVAR ENTRADAS
    public EntradaLote incluirEntradaLote(EntradaLote objEntLote) {
        buscarOperacao(objEntLote.getNomeOperacao());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ENTRADALOTE (ObsEntrada,StatusEnt,IdOp,DataLancaMov,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");                        
            pst.setString(1, objEntLote.getObs());
            pst.setString(2, objEntLote.getStatusEntrada());
            pst.setInt(3, codOpe);
            pst.setTimestamp(4, new java.sql.Timestamp(objEntLote.getDateLancamento().getTime())); 
            pst.setString(5, objEntLote.getUsuarioInsert());
            pst.setString(6, objEntLote.getDataInsert());
            pst.setString(7, objEntLote.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntLote;
    }
//Método para ALTERAR ENTRADAS EM LOTE

    public EntradaLote alterarEntradaLote(EntradaLote objEntLote) {

        buscarOperacao(objEntLote.getNomeOperacao());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADALOTE SET ObsEntrada=?,StatusEnt=?,IdOp=?,DataLancaMov=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdEntrada='" + objEntLote.getIdLanc() + "'");
            pst.setString(1, objEntLote.getObs());
            pst.setString(2, objEntLote.getStatusEntrada());
            pst.setInt(3, codOpe);
            pst.setTimestamp(4, new java.sql.Timestamp(objEntLote.getDateLancamento().getTime())); 
            pst.setString(5, objEntLote.getUsuarioUp());
            pst.setString(6, objEntLote.getDataUp());
            pst.setString(7, objEntLote.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\n ERRO\n" + ex);
        }
        conecta.desconecta();
        return objEntLote;
    }
//Método para excluir ENTRADAS    
    public EntradaLote excluirEntradaLote(EntradaLote objEntLote) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst;
            pst = conecta.con.prepareStatement("DELETE FROM ENTRADALOTE WHERE IdEntrada='" + objEntLote.getIdLanc() + "'");            
            pst.executeUpdate();            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\n ERRO\n" + ex);
        }
        conecta.desconecta();
        return objEntLote;
    }
    
     public EntradaLote finalizarEntradaLote(EntradaLote objEntLote) {
        
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADALOTE SET StatusEnt=? WHERE IdEntrada='" + objEntLote.getIdLanc() + "'");
            pst.setString(1, objEntLote.getStatusEntrada());                      
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados\n\n ERRO\n" + ex);
        }
        conecta.desconecta();
        return objEntLote;
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
