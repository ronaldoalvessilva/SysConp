/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.Instituicao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleInstituicao {
    ConexaoBancoDados conecta = new ConexaoBancoDados();
    Instituicao objInst = new Instituicao();
    
    public Instituicao incluirInstituicao(Instituicao objInst) {
       
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO INSTITUICAOESCOLAR (StatusInst,DataCad,NomeInstituicao,Endereco,Cidade,Estado,Telefone,Telefone1,Celular,Celular1,Email,Contato,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objInst.getStatusInst());
            pst.setTimestamp(2, new java.sql.Timestamp(objInst.getDataCad().getTime()));
            pst.setString(3, objInst.getNomeInstituicao());
            pst.setString(4, objInst.getEndereco());
            pst.setString(5, objInst.getCidade());
            pst.setString(6, objInst.getEstado());
            pst.setString(7, objInst.getTelefone());
            pst.setString(8, objInst.getTelefone1());
            pst.setString(9, objInst.getCelular());
            pst.setString(10, objInst.getCelular1());
            pst.setString(11, objInst.getEmail());
            pst.setString(12, objInst.getContato());
            pst.setString(13, objInst.getObservacao());
            pst.setString(14, objInst.getUsuarioInsert());
            pst.setString(15, objInst.getDataInsert());
            pst.setString(16, objInst.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objInst;
    }
    public Instituicao alterarInstituicao(Instituicao objInst) {
       
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE INSTITUICAOESCOLAR SET StatusInst=?,DataCad=?,NomeInstituicao=?,Endereco=?,Cidade=?,Estado=?,Telefone=?,Telefone1=?,Celular=?,Celular1=?,Email=?,Contato=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdCod='" + objInst.getIdCod() + "'");
            pst.setString(1, objInst.getStatusInst());
            pst.setTimestamp(2, new java.sql.Timestamp(objInst.getDataCad().getTime()));
            pst.setString(3, objInst.getNomeInstituicao());
            pst.setString(4, objInst.getEndereco());
            pst.setString(5, objInst.getCidade());
            pst.setString(6, objInst.getEstado());
            pst.setString(7, objInst.getTelefone());
            pst.setString(8, objInst.getTelefone1());
            pst.setString(9, objInst.getCelular());
            pst.setString(10, objInst.getCelular1());
            pst.setString(11, objInst.getEmail());
            pst.setString(12, objInst.getContato());
            pst.setString(13, objInst.getObservacao());
            pst.setString(14, objInst.getUsuarioUp());
            pst.setString(15, objInst.getDataUp());
            pst.setString(16, objInst.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objInst;
    }
    public Instituicao excluirInstituicao(Instituicao objInst) {
       
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM INSTITUICAOESCOLAR WHERE IdCod='" + objInst.getIdCod() + "'");           
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objInst;
    }
}
