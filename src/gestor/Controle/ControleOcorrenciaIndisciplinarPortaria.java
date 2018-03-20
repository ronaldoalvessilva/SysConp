/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.RegistroIndisciplinarPortaria;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleOcorrenciaIndisciplinarPortaria {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    RegistroIndisciplinarPortaria objRegInd = new RegistroIndisciplinarPortaria();

    int codInt;

    public RegistroIndisciplinarPortaria incluirRegistroVisitas(RegistroIndisciplinarPortaria objRegInd) {
        buscarInternoCrc(objRegInd.getNomeInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO REGISTRO_INDISCIPLINA_PORTARIA (StatusReg,TipoVisita,TipoOcorrencia,DataReg,IdInternoCrc,StatusAprovacao,DataAprovacao,DataAprovacao1,UsuarioAutorizadorSeg,UsuarioAutorizadorSS,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objRegInd.getStatusReg());
            pst.setString(2, objRegInd.getTipoVisita());
            pst.setString(3, objRegInd.getTipoOcorrencia());
            pst.setTimestamp(4, new java.sql.Timestamp(objRegInd.getDataReg().getTime()));
            pst.setInt(5, codInt);
            pst.setString(6, objRegInd.getStatusAprovacao());
            if (objRegInd.getDataAprovacao() != null) {
                pst.setTimestamp(7, new java.sql.Timestamp(objRegInd.getDataAprovacao().getTime()));
            } else {
                pst.setDate(7, null);
            }

            if (objRegInd.getDataAprovacao1() != null) {
                pst.setTimestamp(8, new java.sql.Timestamp(objRegInd.getDataAprovacao1().getTime()));
            } else {
                pst.setDate(8, null);
            }
            pst.setString(9, objRegInd.getUsuarioAprovador());
            pst.setString(10, objRegInd.getUsuarioAprovador1());
            pst.setString(11, objRegInd.getObservacao());
            pst.setString(12, objRegInd.getUsuarioInsert());
            pst.setString(13, objRegInd.getDataInsert());
            pst.setString(14, objRegInd.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objRegInd;
    }

    public RegistroIndisciplinarPortaria alterarRegistroVisitas(RegistroIndisciplinarPortaria objRegInd) {
        buscarInternoCrc(objRegInd.getNomeInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REGISTRO_INDISCIPLINA_PORTARIA SET StatusReg=?,TipoVisita=?,TipoOcorrencia=?,DataReg=?,IdInternoCrc=?,StatusAprovacao=?,DataAprovacao=?,DataAprovacao1=?,UsuarioAutorizadorSeg=?,UsuarioAutorizadorSS=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdReg='" + objRegInd.getIdReg() + "'");
            pst.setString(1, objRegInd.getStatusReg());
            pst.setString(2, objRegInd.getTipoVisita());
            pst.setString(3, objRegInd.getTipoOcorrencia());
            pst.setTimestamp(4, new java.sql.Timestamp(objRegInd.getDataReg().getTime()));
            pst.setInt(5, codInt);
            pst.setString(6, objRegInd.getStatusAprovacao());
            if (objRegInd.getDataAprovacao() != null) {
                pst.setTimestamp(7, new java.sql.Timestamp(objRegInd.getDataAprovacao().getTime()));
            } else {
                pst.setDate(7, null);
            }

            if (objRegInd.getDataAprovacao1() != null) {
                pst.setTimestamp(8, new java.sql.Timestamp(objRegInd.getDataAprovacao1().getTime()));
            } else {
                pst.setDate(8, null);
            }
            pst.setString(9, objRegInd.getUsuarioAprovador());
            pst.setString(10, objRegInd.getUsuarioAprovador1());
            pst.setString(11, objRegInd.getObservacao());
            pst.setString(12, objRegInd.getUsuarioUp());
            pst.setString(13, objRegInd.getDataUp());
            pst.setString(14, objRegInd.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objRegInd;
    }

    public RegistroIndisciplinarPortaria excluirRegistroVisitas(RegistroIndisciplinarPortaria objRegInd) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM REGISTRO_INDISCIPLINA_PORTARIA WHERE IdReg='" + objRegInd.getIdReg() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objRegInd;
    }

    public RegistroIndisciplinarPortaria finalizarRegistroVisitas(RegistroIndisciplinarPortaria objRegInd) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REGISTRO_INDISCIPLINA_PORTARIA SET StatusReg=? WHERE IdReg='" + objRegInd.getIdReg() + "'");
            pst.setString(1, objRegInd.getStatusReg());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível FINALIZAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objRegInd;
    }

    public void buscarInternoCrc(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + desc + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNOS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
