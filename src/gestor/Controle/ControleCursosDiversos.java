/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.CursosDiversos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleCursosDiversos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    CursosDiversos objCursos = new CursosDiversos();

    public CursosDiversos incluirCursos(CursosDiversos objCursos) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO CURSOS (StatusCurso, DataCurso,DescricaoCurso,usuarioInsert,DataInsert,HorarioInsert,TipoCurso) VALUES(?,?,?,?,?,?,?)");
            pst.setString(1, objCursos.getStatusCurso());
            pst.setTimestamp(2, new java.sql.Timestamp(objCursos.getDataCurso().getTime()));
            pst.setString(3, objCursos.getDescricaoCurso());
            pst.setString(4, objCursos.getUsuarioInsert());
            pst.setString(5, objCursos.getDataInsert());
            pst.setString(6, objCursos.getHorarioInsert());
            pst.setString(7, objCursos.getTipoCurso());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCursos;
    }

    public CursosDiversos alterarCursos(CursosDiversos objCursos) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE CURSOS SET StatusCurso=?, DataCurso=?,DescricaoCurso=?,UsuarioUp=?,DataUp=?,HorarioUp=?,TipoCurso=? WHERE IdCurso='" + objCursos.getIdCurso() + "'");
            pst.setString(1, objCursos.getStatusCurso());
            pst.setTimestamp(2, new java.sql.Timestamp(objCursos.getDataCurso().getTime()));
            pst.setString(3, objCursos.getDescricaoCurso());
            pst.setString(4, objCursos.getUsuarioUp());
            pst.setString(5, objCursos.getDataUp());
            pst.setString(6, objCursos.getHorarioUp());
            pst.setString(7, objCursos.getTipoCurso());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCursos;
    }

    public CursosDiversos excluirCursos(CursosDiversos objCursos) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM CURSOS WHERE IdCurso='" + objCursos.getIdCurso() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCursos;
    }
}
