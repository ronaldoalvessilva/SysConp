/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.MatriculaEscolar;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleMatriculaEscolar {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    MatriculaEscolar objMatEscolar = new MatriculaEscolar();
    int idCod, idTempo, idCarga, idSala;

    public MatriculaEscolar incluirMatriculaEscolar(MatriculaEscolar objMatEscolar) {
        buscarInstituicao(objMatEscolar.getNomeIstituicao());
        buscarTempoFormativo(objMatEscolar.getDescricaoTempoFormativo(),objMatEscolar.getIdTempo());
        buscarCargaHoraria(objMatEscolar.getDescricaoCargaHoraria());
        buscarSalaAula(objMatEscolar.getDescricaoSala());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO MATRICULAESCOLAR (StatusMat,DataMat,IdCod,IdTempo,IdCarga,IdSala,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objMatEscolar.getStatusMatricula());
            pst.setTimestamp(2, new java.sql.Timestamp(objMatEscolar.getDataMat().getTime()));
            pst.setInt(3, idCod);
            pst.setInt(4, idTempo);
            pst.setInt(5, idCarga);
            pst.setInt(6, idSala);
            pst.setString(7, objMatEscolar.getUsuarioInsert());
            pst.setString(8, objMatEscolar.getDataInsert());
            pst.setString(9, objMatEscolar.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objMatEscolar;
    }

    public MatriculaEscolar alterarMatriculaEscolar(MatriculaEscolar objMatEscolar) {
        buscarInstituicao(objMatEscolar.getNomeIstituicao());
        buscarTempoFormativo(objMatEscolar.getDescricaoTempoFormativo(),objMatEscolar.getIdTempo());
        buscarCargaHoraria(objMatEscolar.getDescricaoCargaHoraria());
        buscarSalaAula(objMatEscolar.getDescricaoSala());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE MATRICULAESCOLAR SET statusMat=?,DataMat=?,IdCod=?,IdTempo=?,IdCarga=?,IdSala=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdMat='" + objMatEscolar.getIdMat() + "'");
            pst.setString(1, objMatEscolar.getStatusMatricula());
            pst.setTimestamp(2, new java.sql.Timestamp(objMatEscolar.getDataMat().getTime()));
            pst.setInt(3, idCod);
            pst.setInt(4, idTempo);
            pst.setInt(5, idCarga);
            pst.setInt(6, idSala);
            pst.setString(7, objMatEscolar.getUsuarioUp());
            pst.setString(8, objMatEscolar.getDataUp());
            pst.setString(9, objMatEscolar.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objMatEscolar;
    }

    public MatriculaEscolar excluirMatriculaEscolar(MatriculaEscolar objMatEscolar) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM MATRICULAESCOLAR WHERE IdMat='" + objMatEscolar.getIdMat() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objMatEscolar;
    }

    public MatriculaEscolar finalizarEntradaLote(MatriculaEscolar objMatEscolar) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE MATRICULAESCOLAR SET StatusMat=? WHERE IdMat='" + objMatEscolar.getIdMat() + "'");
            pst.setString(1, objMatEscolar.getStatusMatricula());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objMatEscolar;
    }

    public void buscarInstituicao(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM INSTITUICAOESCOLAR WHERE NomeInstituicao='" + nome + "'");
            conecta.rs.first();
            idCod = conecta.rs.getInt("IdCod");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (INSTITUIÇÃO) a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void buscarTempoFormativo(String descricao, int codTempo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM TEMPOFORMATIVO WHERE DescricaoTempo='" + descricao + "' AND IdTempo='" + codTempo + "'");
            conecta.rs.first();
            idTempo = conecta.rs.getInt("IdTempo");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (TEMPO FORMATIVO) a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void buscarCargaHoraria(String descricao) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM CARGAHORARIA WHERE DescricaoCarga='" + descricao + "'");
            conecta.rs.first();
            idCarga = conecta.rs.getInt("IdCarga");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (CARGA HORARIA) a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void buscarSalaAula(String descricao) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM SALAS WHERE Descricao='" + descricao + "'");
            conecta.rs.first();
            idSala = conecta.rs.getInt("IdSala");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (SALA DE AULA) a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
