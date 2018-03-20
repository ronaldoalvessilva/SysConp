/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.TarefasDiversas;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleTarefasDiversas {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    TarefasDiversas objTarefa = new TarefasDiversas();

    public TarefasDiversas incluirTarefa(TarefasDiversas objTarefa) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO TAREFASDIVERSAS (StatusTarefa, DataTarefa,DescricaoTarefa,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?)");
            pst.setString(1, objTarefa.getStatusTarefa());
            pst.setTimestamp(2, new java.sql.Timestamp(objTarefa.getDataTarefa().getTime()));
            pst.setString(3, objTarefa.getDescricaoTarefa());
            pst.setString(4, objTarefa.getUsuarioInsert());
            pst.setString(5, objTarefa.getDataInsert());
            pst.setString(6, objTarefa.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objTarefa;
    }

    public TarefasDiversas alterarTarefa(TarefasDiversas objTarefa) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE TAREFASDIVERSAS SET StatusTarefa=?, DataTarefa=?,DescricaoTarefa=?,UsuarioUp=?,DataUp=?,Horarioup=? WHERE IdTarefa='" + objTarefa.getIdTarefa() + "'");
            pst.setString(1, objTarefa.getStatusTarefa());
            pst.setTimestamp(2, new java.sql.Timestamp(objTarefa.getDataTarefa().getTime()));
            pst.setString(3, objTarefa.getDescricaoTarefa());
            pst.setString(4, objTarefa.getUsuarioUp());
            pst.setString(5, objTarefa.getDataUp());
            pst.setString(6, objTarefa.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objTarefa;
    }

    public TarefasDiversas excluirTarefa(TarefasDiversas objTarefa) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM TAREFASDIVERSAS WHERE IdTarefa='" + objTarefa.getIdTarefa() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objTarefa;
    }
}
