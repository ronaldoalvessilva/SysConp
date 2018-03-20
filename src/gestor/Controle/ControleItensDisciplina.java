/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.Cargos;
import gestor.Modelo.Professores;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleItensDisciplina {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    Professores objProf = new Professores();
    int codDisc;

    public Professores incluirItensDisciplina(Professores objProf) {
        buscarDisciplina(objProf.getDisciplina());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO DISCIPLINASPROFESSOR (IdDisc,IdProf,ObsDisciplina,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?)");
            pst.setInt(1, codDisc);
            pst.setInt(2, objProf.getIdProf());
            pst.setString(3, objProf.getObsDisciplina());
            pst.setString(4, objProf.getUsuarioInsert());
            pst.setString(5, objProf.getDataInsert());
            pst.setString(6, objProf.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objProf;
    }

    public Professores alterarItensDisciplina(Professores objProf) {
        buscarDisciplina(objProf.getDisciplina());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE DISCIPLINASPROFESSOR SET IdDisc=?,IdProf=?,ObsDisciplina=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objProf.getIdItem()+ "'");
            pst.setInt(1, codDisc);
            pst.setInt(2, objProf.getIdProf());
            pst.setString(3, objProf.getObsDisciplina());
            pst.setString(4, objProf.getUsuarioUp());
            pst.setString(5, objProf.getDataUp());
            pst.setString(6, objProf.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objProf;
    }

    public Professores excluirItensDisciplina(Professores objProf) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM DISCIPLINASPROFESSOR WHERE IdItem='" + objProf.getIdProf() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objProf;
    }

    public void buscarDisciplina(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM DISCIPLINAS WHERE Descricao='" + desc + "'");
            conecta.rs.first();
            codDisc = conecta.rs.getInt("IdDisc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (DISCIPLINA) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
