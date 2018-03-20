/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.Disciplina;
import gestor.Modelo.Funcionarios;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleDisciplina {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    Disciplina objDisc = new Disciplina();

    public Disciplina incluirDisciplina(Disciplina objDisc) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO DISCIPLINAS (StatusDisc,DataDisc,Descricao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?)");
            pst.setString(1, objDisc.getStatusDisc());
            pst.setTimestamp(2, new java.sql.Timestamp(objDisc.getDataDisc().getTime()));
            pst.setString(3, objDisc.getDescricao());
            pst.setString(4, objDisc.getUsuarioInsert());
            pst.setString(5, objDisc.getDataInsert());
            pst.setString(6, objDisc.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel gravar os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objDisc;
    }

    public Disciplina alterarDisciplina(Disciplina objDisc) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE DISCIPLINAS SET StatusDisc=?,DataDisc=?,Descricao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdDisc='" + objDisc.getIdDisc() + "'");
            pst.setString(1, objDisc.getStatusDisc());
            pst.setTimestamp(2, new java.sql.Timestamp(objDisc.getDataDisc().getTime()));
            pst.setString(3, objDisc.getDescricao());
            pst.setString(4, objDisc.getUsuarioUp());
            pst.setString(5, objDisc.getDataUp());
            pst.setString(6, objDisc.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel gravar os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objDisc;
    }

    public Disciplina excluirDisciplina(Disciplina objDisc) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM DISCIPLINAS WHERE IdDisc='" + objDisc.getIdDisc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel excluir os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objDisc;
    }
}
