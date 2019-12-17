/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AssistenciaEducativa;
import gestor.Modelo.CursosDiversos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleAssistenciaEducativa {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AssistenciaEducativa objAssis = new AssistenciaEducativa();
    CursosDiversos objCursos = new CursosDiversos();
    int codInstituicao;
    int codTurno;

    public AssistenciaEducativa incluirAssistenciaEducativa(AssistenciaEducativa objAssis) {
        buscarInstituicao(objAssis.getDescricaoInstituicao());
        buscarTurnos(objAssis.getDescricaoTurno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ASSISTENCIA_EDUCACAO_EXTERNA (StatusLanc,DataLanc,IdCod,IdTurno,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?)");
            pst.setString(1, objAssis.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objAssis.getDataLanc().getTime()));
            pst.setInt(3, codInstituicao);
            pst.setInt(4, codTurno);
            pst.setString(5, objAssis.getObservacao());
            pst.setString(6, objAssis.getUsuarioInsert());
            pst.setString(7, objAssis.getDataInsert());
            pst.setString(8, objAssis.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO:" + ex);
        }
        conecta.desconecta();
        return objAssis;
    }

    public AssistenciaEducativa alterarAssistenciaEducativa(AssistenciaEducativa objAssis) {
        buscarInstituicao(objAssis.getDescricaoInstituicao());
        buscarTurnos(objAssis.getDescricaoTurno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ASSISTENCIA_EDUCACAO_EXTERNA SET StatusLanc=?,DataLanc=?,IdCod=?,IdTurno=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdEduca='" + objAssis.getIdEduca() + "'");
            pst.setString(1, objAssis.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objAssis.getDataLanc().getTime()));
            pst.setInt(3, codInstituicao);
            pst.setInt(4, codTurno);
            pst.setString(5, objAssis.getObservacao());
            pst.setString(6, objAssis.getUsuarioInsert());
            pst.setString(7, objAssis.getDataInsert());
            pst.setString(8, objAssis.getHorarioInsert());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objAssis;
    }

    public AssistenciaEducativa excluirAssistenciaEducativa(AssistenciaEducativa objAssis) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ASSISTENCIA_EDUCACAO_EXTERNA WHERE IdEduca='" + objAssis.getIdEduca() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objAssis;
    }

    public AssistenciaEducativa finalizarAssistenciaEducativa(AssistenciaEducativa objAssis) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ASSISTENCIA_EDUCACAO_EXTERNA SET StatusLanc=? WHERE IdEduca='" + objAssis.getIdEduca() + "'");
            pst.setString(1, objAssis.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objAssis;
    }

    public void buscarInstituicao(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM INSTITUICAOESCOLAR WHERE NomeInstituicao='" + nome + "'");
            conecta.rs.first();
            codInstituicao = conecta.rs.getInt("IdCod");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (INSTITUIÇÃO) a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void buscarTurnos(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM TURNOSAULA WHERE DescricaoTurno='" + nome + "'");
            conecta.rs.first();
            codTurno = conecta.rs.getInt("IdTurno");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (TURNOS) a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public List<CursosDiversos> read() throws Exception {
        conecta.abrirConexao();
        List<CursosDiversos> listaInternosKitComp = new ArrayList<CursosDiversos>();
        try {
            conecta.executaSQL("SELECT * FROM CURSOS "
                    + "ORDER BY CURSOS.DescricaoCurso");
            while (conecta.rs.next()) {
                CursosDiversos pDigi = new CursosDiversos();
                pDigi.setIdCurso(conecta.rs.getInt("IdCurso"));
                pDigi.setDescricaoCurso(conecta.rs.getString("DescricaoCurso"));
                listaInternosKitComp.add(pDigi);
            }
            return listaInternosKitComp;
        } catch (SQLException ex) {
            Logger.getLogger(ControleAssistenciaEducativa.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
