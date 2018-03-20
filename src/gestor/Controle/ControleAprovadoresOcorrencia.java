/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AprovadoresOcorrencia;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleAprovadoresOcorrencia {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AprovadoresOcorrencia objAprova = new AprovadoresOcorrencia();

    int codInt;

    public AprovadoresOcorrencia incluirAprovadorOcorrencia(AprovadoresOcorrencia objAprova) {
        buscarColaborador(objAprova.getNomeColaborador());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO APROVADORES_OCORRENCIA_PORTARIA (StatusAprova,DataAprova,IdUsuario,Observacao,ModDep,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?)");
            pst.setString(1, objAprova.getStatusAprova());
            pst.setTimestamp(2, new java.sql.Timestamp(objAprova.getDataAprova().getTime()));
            pst.setInt(3, codInt);
            pst.setString(4, objAprova.getObservacao());
            pst.setInt(5, objAprova.getModDep());
            pst.setString(6, objAprova.getUsuarioInsert());
            pst.setString(7, objAprova.getDataInsert());
            pst.setString(8, objAprova.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAprova;
    }

    public AprovadoresOcorrencia alterarAprovadorOcorrencia(AprovadoresOcorrencia objAprova) {
        buscarColaborador(objAprova.getNomeColaborador());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE APROVADORES_OCORRENCIA_PORTARIA SET StatusAprova=?,DataAprova=?,IdUsuario=?,Observacao=?,ModDep=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdAprova='" + objAprova.getIdAprova() + "'");
            pst.setString(1, objAprova.getStatusAprova());
            pst.setTimestamp(2, new java.sql.Timestamp(objAprova.getDataAprova().getTime()));
            pst.setInt(3, codInt);
            pst.setString(4, objAprova.getObservacao());
            pst.setInt(5, objAprova.getModDep());
            pst.setString(6, objAprova.getUsuarioUp());
            pst.setString(7, objAprova.getDataUp());
            pst.setString(8, objAprova.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAprova;
    }

    public AprovadoresOcorrencia excluirAprovadorOcorrencia(AprovadoresOcorrencia objAprova) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM APROVADORES_OCORRENCIA_PORTARIA WHERE IdAprova='" + objAprova.getIdAprova() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAprova;
    }

    public void buscarColaborador(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS WHERE NomeUsuario='" + desc + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (USUÁRIO) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
