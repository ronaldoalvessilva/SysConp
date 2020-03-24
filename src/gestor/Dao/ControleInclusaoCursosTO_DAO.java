/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Dao;

import gestor.Modelo.HistoricoEducacionalLaboral;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleInclusaoCursosTO_DAO {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    HistoricoEducacionalLaboral objHistEducLabor = new HistoricoEducacionalLaboral();

    int codCurso;

    public HistoricoEducacionalLaboral incluirCursos(HistoricoEducacionalLaboral objHistEducLabor) {
        buscarCursos(objHistEducLabor.getDescricaoCurso());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_CURSOS_TO_HISTORICO_EDUCACIONAL_NOVO (IdATN,IdCurso,IdHistoricoEduN,PrioridadeCurso) VALUES(?,?,?,?)");
            pst.setInt(1, objHistEducLabor.getIdATN());
            pst.setInt(2, codCurso);
            pst.setInt(3, objHistEducLabor.getIdHistoricoEduN());
            pst.setInt(4, objHistEducLabor.getPrioridadeCurso());
            pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\nERRO: " + e);
        }
        conecta.desconecta();
        return objHistEducLabor;
    }

    public HistoricoEducacionalLaboral alterarCursos(HistoricoEducacionalLaboral objHistEducLabor) {
        buscarCursos(objHistEducLabor.getDescricaoCurso());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_CURSOS_TO_HISTORICO_EDUCACIONAL_NOVO SET IdCurso=?,PrioridadeCurso=? WHERE IdHistoricoEduN='" + objHistEducLabor.getIdHistoricoEduN()+ "'");
            pst.setInt(1, codCurso);            
            pst.setInt(2, objHistEducLabor.getPrioridadeCurso());
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados(ITENS_CURSOS).\nERRO: " + e);
        }
        conecta.desconecta();
        return objHistEducLabor;
    }

    public HistoricoEducacionalLaboral excluirCursos(HistoricoEducacionalLaboral objHistEducLabor) {
       
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_CURSOS_TO_HISTORICO_EDUCACIONAL_NOVO WHERE IdHistoricoEduN='" + objHistEducLabor.getIdHistoricoEduN()+ "'");
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados (ITENS_CURSOS).\nERRO: " + e);
        }
        conecta.desconecta();
        return objHistEducLabor;
    }

    public void buscarCursos(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM CURSOS WHERE DescricaoCurso='" + desc + "'");
            conecta.rs.first();
            codCurso = conecta.rs.getInt("IdCurso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (CURSOS) a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
