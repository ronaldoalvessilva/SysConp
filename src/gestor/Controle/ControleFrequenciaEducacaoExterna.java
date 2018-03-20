/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.FrequenciaLaborativaExterna;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleFrequenciaEducacaoExterna {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    FrequenciaLaborativaExterna objFreq = new FrequenciaLaborativaExterna();

    int codInstituicao;

    public FrequenciaLaborativaExterna incluirFrequenciaEducativaExterna(FrequenciaLaborativaExterna objFreq) {
       buscarInstituicao(objFreq.getNomeEmpresa(), objFreq.getIdEmp());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO FREQUENCIA_PEDAGOGIA_EXTERNA (StatusFreqLab,DataFreqLab,TipoAtiv,IdCod,Observacao,MesReferencia,AnoReferencia,DataInicio,DataTermino,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objFreq.getStatusFreqLab());
            pst.setTimestamp(2, new java.sql.Timestamp(objFreq.getDataFreqLab().getTime()));
            pst.setInt(3, objFreq.getTipoAtiv());
            pst.setInt(4, codInstituicao);
            pst.setString(5, objFreq.getObservacao());
            pst.setString(6, objFreq.getMesReferencia());
            pst.setInt(7, objFreq.getAnoReferencia());
            if (objFreq.getDataInicio() != null) {
                pst.setTimestamp(8, new java.sql.Timestamp(objFreq.getDataInicio().getTime()));
            } else {
                pst.setDate(8, null);
            }
            if (objFreq.getDataTermino() != null) {
                pst.setTimestamp(9, new java.sql.Timestamp(objFreq.getDataTermino().getTime()));
            } else {
                pst.setDate(9, null);
            }
            pst.setString(10, objFreq.getUsuarioInsert());
            pst.setString(11, objFreq.getDataInsert());
            pst.setString(12, objFreq.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFreq;
    }

    public FrequenciaLaborativaExterna alterarFrequenciaEducativaExterna(FrequenciaLaborativaExterna objFreq) {
        buscarInstituicao(objFreq.getNomeEmpresa(), objFreq.getIdEmp());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE FREQUENCIA_PEDAGOGIA_EXTERNA SET StatusFreqLab=?,DataFreqLab=?,TipoAtiv=?,IdCod=?,Observacao=?,MesReferencia=?,AnoReferencia=?,DataInicio=?,DataTermino=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdFreqLab='" + objFreq.getIdFreqLab() + "'");
            pst.setString(1, objFreq.getStatusFreqLab());
            pst.setTimestamp(2, new java.sql.Timestamp(objFreq.getDataFreqLab().getTime()));
            pst.setInt(3, objFreq.getTipoAtiv());
            pst.setInt(4, codInstituicao);
            pst.setString(5, objFreq.getObservacao());
            pst.setString(6, objFreq.getMesReferencia());
            pst.setInt(7, objFreq.getAnoReferencia());
            if (objFreq.getDataInicio() != null) {
                pst.setTimestamp(8, new java.sql.Timestamp(objFreq.getDataInicio().getTime()));
            } else {
                pst.setDate(8, null);
            }
            if (objFreq.getDataTermino() != null) {
                pst.setTimestamp(9, new java.sql.Timestamp(objFreq.getDataTermino().getTime()));
            } else {
                pst.setDate(9, null);
            }
            pst.setString(10, objFreq.getUsuarioUp());
            pst.setString(11, objFreq.getDataUp());
            pst.setString(12, objFreq.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFreq;
    }

    public FrequenciaLaborativaExterna excluirFrequenciaEducativaExterna(FrequenciaLaborativaExterna objFreq) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM FREQUENCIA_PEDAGOGIA_EXTERNA WHERE IdFreqLab='" + objFreq.getIdFreqLab() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFreq;
    }

    public FrequenciaLaborativaExterna finalizarFrequenciaEducativaExterna(FrequenciaLaborativaExterna objFreq) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE FREQUENCIA_PEDAGOGIA_EXTERNA SET StatusFreqLab=? WHERE IdFreqLab='" + objFreq.getIdFreqLab() + "'");
            pst.setString(1, objFreq.getStatusFreqLab());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFreq;
    }

    public void buscarInstituicao(String nome, int codigoInstituicao) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM INSTITUICAOESCOLAR WHERE NomeInstituicao='" + nome + "'AND IdCod='" + codigoInstituicao + "'");
            conecta.rs.first();
            codInstituicao = conecta.rs.getInt("IdCod");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
