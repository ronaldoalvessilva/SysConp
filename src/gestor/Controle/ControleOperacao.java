/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.Operacao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleOperacao {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    Operacao objOp = new Operacao();

    //Método para SALVAR OPERAÇÃO
    public Operacao incluirOperacao(Operacao objOp) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO OPERACAO (TipoOp,DescricaoOp,StatusOp) VALUES(?,?,?)");
            pst.setString(1, objOp.getTipo());
            pst.setString(2, objOp.getDescricao());
            pst.setString(3, objOp.getStatusOperacao());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objOp;
    }
//Método para ALTERAR OPERAÇÃO

    public Operacao alterarOperacao(Operacao objOp) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE OPERACAO SET TipoOp=?,DescricaoOp=?,StatusOp=? WHERE IdOp='" + objOp.getIdOp() + "'");
            pst.setString(1, objOp.getTipo());
            pst.setString(2, objOp.getDescricao());
            pst.setString(3, objOp.getStatusOperacao());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objOp;
    }
//Método para excluir OPERAÇÃO

    /**
     *
     * @param objOp
     * @return
     */
    public Operacao excluirOperacao(Operacao objOp) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst;
            pst = conecta.con.prepareStatement("DELETE FROM OPERACAO "
                    + "WHERE IdOp='" + objOp.getIdOp() + "'");           
            pst.execute();
            conecta.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\n ERRO\n" + ex);
        }
        conecta.desconecta();
        return objOp;
    }
}
