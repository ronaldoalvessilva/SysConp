/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensFrequenciaLaborativaExterna;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleItensFrequenciaEducacaoExterna {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensFrequenciaLaborativaExterna objItenFreq = new ItensFrequenciaLaborativaExterna();

    int codInterno;

    public ItensFrequenciaLaborativaExterna incluirFrequenciaEducativaExterna(ItensFrequenciaLaborativaExterna objItenFreq) {
        buscarInterno(objItenFreq.getIdInternoCrc(), objItenFreq.getNomeInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_FREQUENCIA_PEDAGOGIA_EXTERNA (IdFreqLab,IdInternoCrc,TotalDias,MesReferencia,AnoReferencia,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?)");
            pst.setInt(1, objItenFreq.getIdFreqLab());
            pst.setInt(2, codInterno);
            pst.setInt(3, objItenFreq.getTotalDias());
            pst.setString(4, objItenFreq.getMesReferencia());
            pst.setInt(5, objItenFreq.getAnoReferencia());
            pst.setString(6, objItenFreq.getUsuarioInsert());
            pst.setString(7, objItenFreq.getDataInsert());
            pst.setString(8, objItenFreq.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItenFreq;
    }

    public ItensFrequenciaLaborativaExterna alterarFrequenciaEducativaExterna(ItensFrequenciaLaborativaExterna objItenFreq) {
        buscarInterno(objItenFreq.getIdInternoCrc(), objItenFreq.getNomeInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_FREQUENCIA_PEDAGOGIA_EXTERNA SET IdFreqLab=?,IdInternoCrc=?,TotalDias=?,MesReferencia=?,AnoReferencia=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objItenFreq.getIdItem() + "'");
            pst.setInt(1, objItenFreq.getIdFreqLab());
            pst.setInt(2, codInterno);
            pst.setInt(3, objItenFreq.getTotalDias());
            pst.setString(4, objItenFreq.getMesReferencia());
            pst.setInt(5, objItenFreq.getAnoReferencia());
            pst.setString(6, objItenFreq.getUsuarioUp());
            pst.setString(7, objItenFreq.getDataUp());
            pst.setString(8, objItenFreq.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItenFreq;
    }

    public ItensFrequenciaLaborativaExterna alterarMesAnoFrequenciaEducativaExterna(ItensFrequenciaLaborativaExterna objItenFreq) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_FREQUENCIA_PEDAGOGIA_EXTERNA SET MesReferencia=?,AnoReferencia=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdFreqLab='" + objItenFreq.getIdFreqLab() + "'");
            pst.setString(1, objItenFreq.getMesReferencia());
            pst.setInt(2, objItenFreq.getAnoReferencia());
            pst.setString(3, objItenFreq.getUsuarioUp());
            pst.setString(4, objItenFreq.getDataUp());
            pst.setString(5, objItenFreq.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItenFreq;
    }

    public ItensFrequenciaLaborativaExterna excluirFrequenciaEducativaExterna(ItensFrequenciaLaborativaExterna objItenFreq) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_FREQUENCIA_PEDAGOGIA_EXTERNA WHERE IdItem='" + objItenFreq.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItenFreq;
    }

    public void buscarInterno(int codigo, String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE IdInternoCrc='" + codigo + "'AND NomeInternoCrc='" + nome + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
