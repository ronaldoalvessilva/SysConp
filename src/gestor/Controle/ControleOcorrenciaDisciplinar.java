/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.OcorrenciaRegimeDisciplinar;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleOcorrenciaDisciplinar {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    OcorrenciaRegimeDisciplinar objOcrDisc = new OcorrenciaRegimeDisciplinar();

    int codInterno;

    public OcorrenciaRegimeDisciplinar incluirOcorrenciaDisciplinar(OcorrenciaRegimeDisciplinar objOcrDisc) {
        pesquisarInterno(objOcrDisc.getNomeInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO OCORRENCIA_AUTORES (DataOcr,IdReg,IdInternoCrc,Ocorrencia,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objOcrDisc.getDataOcr().getTime()));
            pst.setInt(2, objOcrDisc.getIdReg());
            pst.setInt(3, codInterno);
            pst.setString(4, objOcrDisc.getOcorrencia());
            pst.setString(5, objOcrDisc.getUsuarioInsert());
            pst.setString(6, objOcrDisc.getDataInsert());
            pst.setString(7, objOcrDisc.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objOcrDisc;
    }

    public OcorrenciaRegimeDisciplinar alterarOcorrenciaDisciplinar(OcorrenciaRegimeDisciplinar objOcrDisc) {
        pesquisarInterno(objOcrDisc.getNomeInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE OCORRENCIA_AUTORES SET DataOcr=?,IdReg=?,IdInternoCrc=?,Ocorrencia=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdOcr='" + objOcrDisc.getIdOcr() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objOcrDisc.getDataOcr().getTime()));
            pst.setInt(2, objOcrDisc.getIdReg());
            pst.setInt(3, codInterno);
            pst.setString(4, objOcrDisc.getOcorrencia());
            pst.setString(5, objOcrDisc.getUsuarioUp());
            pst.setString(6, objOcrDisc.getDataUp());
            pst.setString(7, objOcrDisc.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objOcrDisc;
    }

    public OcorrenciaRegimeDisciplinar excluirOcorrenciaDisciplinar(OcorrenciaRegimeDisciplinar objOcrDisc) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM OCORRENCIA_AUTORES WHERE IdOcr='" + objOcrDisc.getIdOcr() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objOcrDisc;
    }

    public void pesquisarInterno(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + nome + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!\nERRO: " + ex);
        }
        conecta.desconecta();
    }
}
