/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.FrequenciaCapacitacaoInterno;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Socializa TI 02
 */
public class ControleFrequenciaCapacitacaoInternos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    FrequenciaCapacitacaoInterno objFreqCap = new FrequenciaCapacitacaoInterno();
    int codigoCurso;
    int codigoInterno;

    public FrequenciaCapacitacaoInterno incluirFrequenciaCapacitacao(FrequenciaCapacitacaoInterno objFreqCap) {
        buscarCurso(objFreqCap.getDescricaoCurso());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO FREQUENCIA_CAPACITACAO_INTERNO_TO (DataRegistro,StatusRegistro,IdCurso,LocalCurso,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objFreqCap.getDataRegistro().getTime()));
            pst.setString(2, objFreqCap.getStatusRegistro());
            pst.setInt(3, codigoCurso);
            pst.setString(4, objFreqCap.getLocalCurso());
            pst.setString(5, objFreqCap.getObservacao());
            pst.setString(6, objFreqCap.getUsuarioInsert());
            pst.setString(7, objFreqCap.getDataInsert());
            pst.setString(8, objFreqCap.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFreqCap;
    }

    public FrequenciaCapacitacaoInterno alterarFrequenciaCapacitacao(FrequenciaCapacitacaoInterno objFreqCap) {
        buscarCurso(objFreqCap.getDescricaoCurso());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE FREQUENCIA_CAPACITACAO_INTERNO_TO SET DataRegistro=?,StatusRegistro=?,IdCurso=?,LocalCurso=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdFreqCap='" + objFreqCap.getIdFreqCap() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objFreqCap.getDataRegistro().getTime()));
            pst.setString(2, objFreqCap.getStatusRegistro());
            pst.setInt(3, codigoCurso);
            pst.setString(4, objFreqCap.getLocalCurso());
            pst.setString(5, objFreqCap.getObservacao());
            pst.setString(6, objFreqCap.getUsuarioUp());
            pst.setString(7, objFreqCap.getDataUp());
            pst.setString(8, objFreqCap.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFreqCap;
    }

    public FrequenciaCapacitacaoInterno excluirFrequenciaCapacitacao(FrequenciaCapacitacaoInterno objFreqCap) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM FREQUENCIA_CAPACITACAO_INTERNO_TO WHERE IdFreqCap='" + objFreqCap.getIdFreqCap() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFreqCap;
    }

    public FrequenciaCapacitacaoInterno finalizarFrequenciaCapacitacao(FrequenciaCapacitacaoInterno objFreqCap) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE FREQUENCIA_CAPACITACAO_INTERNO_TO SET StatusRegistro=? WHERE IdFreqCap='" + objFreqCap.getIdFreqCap() + "'");
            pst.setString(1, objFreqCap.getStatusRegistro());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFreqCap;
    }

    //------------------------------- INTERNOS CAPACITANDO 
    public FrequenciaCapacitacaoInterno incluirInternoFrequenciaCapacitacao(FrequenciaCapacitacaoInterno objFreqCap) {
        buscarInterno(objFreqCap.getNomeInterno(), objFreqCap.getIdInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_FREQUENCIA_CAPACITACAO_INTERNO_TO (IdInternoCrc,IdFreqCap,DataEntrada,HoraEntrada,HoraSaida,NotaAvalia,Frequencia,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, codigoInterno);
            pst.setInt(2, objFreqCap.getIdFreqCap());
            if (objFreqCap.getDataEntrada() != null) {
                pst.setTimestamp(3, new java.sql.Timestamp(objFreqCap.getDataEntrada().getTime()));
            } else {
                pst.setDate(3, null);
            }
            pst.setString(4, objFreqCap.getHorariaEntrada());
            pst.setString(5, objFreqCap.getHorarioSaida());
            pst.setFloat(6, objFreqCap.getNotaAvaliacao());
            pst.setString(7, objFreqCap.getFrequencia());
            pst.setString(8, objFreqCap.getUsuarioInsert());
            pst.setString(9, objFreqCap.getDataInsert());
            pst.setString(10, objFreqCap.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFreqCap;
    }

    public FrequenciaCapacitacaoInterno alterarInternoFrequenciaCapacitacao(FrequenciaCapacitacaoInterno objFreqCap) {
        buscarInterno(objFreqCap.getNomeInterno(), objFreqCap.getIdInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_FREQUENCIA_CAPACITACAO_INTERNO_TO SET IdInternoCrc=?,IdFreqCap=?,DataEntrada=?,HoraEntrada=?,HoraSaida=?,NotaAvalia=?,Frequencia=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItemFreqCap='" + objFreqCap.getIdItemFreqCap() + "'");
            pst.setInt(1, codigoInterno);
            pst.setInt(2, objFreqCap.getIdFreqCap());
            if (objFreqCap.getDataEntrada() != null) {
                pst.setTimestamp(3, new java.sql.Timestamp(objFreqCap.getDataEntrada().getTime()));
            } else {
                pst.setDate(3, null);
            }
            pst.setString(4, objFreqCap.getHorariaEntrada());
            pst.setString(5, objFreqCap.getHorarioSaida());
            pst.setFloat(6, objFreqCap.getNotaAvaliacao());
            pst.setString(7, objFreqCap.getFrequencia());
            pst.setString(8, objFreqCap.getUsuarioUp());
            pst.setString(9, objFreqCap.getDataUp());
            pst.setString(10, objFreqCap.getHorarioUp());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFreqCap;
    }

    public FrequenciaCapacitacaoInterno excluirInternoFrequenciaCapacitacao(FrequenciaCapacitacaoInterno objFreqCap) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_FREQUENCIA_CAPACITACAO_INTERNO_TO WHERE IdItemFreqCap='" + objFreqCap.getIdItemFreqCap() + "'");
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFreqCap;
    }

    public void buscarCurso(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM CURSOS WHERE DescricaoCurso='" + desc + "'");
            conecta.rs.first();
            codigoCurso = conecta.rs.getInt("IdCurso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (CURSOS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }

    public void buscarInterno(String nome, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE NomeInternoCrc='" + nome + "' "
                    + "AND IdInternoCrc='" + codigo + "'");
            conecta.rs.first();
            codigoInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNO) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
