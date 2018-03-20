/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AtendimentoFemininoP3;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleAtendimentoFemininoP3 {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AtendimentoFemininoP3 objAfP3 = new AtendimentoFemininoP3();

    int codigoInterno;

    public AtendimentoFemininoP3 incluirAtendimentoFemininoP3(AtendimentoFemininoP3 objAfP3) {
        buscarInterno(objAfP3.getNomeInternoCrc(), objAfP3.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ADME_AFP3 (IdLanc,IdInternoCrc,DataUltimaMenstruacao,Gestante,CertezaDuvidaGestacao,HabitosAlimentares,"
                    + "MedicamentoGestacao,InternacaoGestacao,OndeGestacao,Cigarro,Pacaia,Maconha,Cocaina,Craque,Alcool,Outros,QuaisDrogras,SinaisSintomas,OcupacaoHabitual,"
                    + "AceitacaoGravidez,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objAfP3.getIdLanc());
            pst.setInt(2, codigoInterno);
            if (objAfP3.getDataUltimaMenstruacao() != null) {
                pst.setTimestamp(3, new java.sql.Timestamp(objAfP3.getDataUltimaMenstruacao().getTime()));
            } else {
                pst.setDate(3, null);
            }
            pst.setString(4, objAfP3.getGestante());
            pst.setString(5, objAfP3.getCertezaDuvidaGestacao());
            pst.setString(6, objAfP3.getHabitosAlimentares());
            pst.setString(7, objAfP3.getMedicamentoGestacao());
            pst.setString(8, objAfP3.getInternacaoGestacao());
            pst.setString(9, objAfP3.getOndeGestacao());
            pst.setInt(10, objAfP3.getCigarro());
            pst.setInt(11, objAfP3.getPacaia());
            pst.setInt(12, objAfP3.getMaconha());
            pst.setInt(13, objAfP3.getCocaina());
            pst.setInt(14, objAfP3.getCraque());
            pst.setInt(15, objAfP3.getAlcool());
            pst.setInt(16, objAfP3.getOutros());
            pst.setString(17, objAfP3.getQuaisDrogras());
            pst.setString(18, objAfP3.getSinaisSintomas());
            pst.setString(19, objAfP3.getOcupacaoHabitual());
            pst.setString(20, objAfP3.getAceitacaoGravidez());
            pst.setString(21, objAfP3.getUsuarioInsert());
            pst.setString(22, objAfP3.getDataInsert());
            pst.setString(23, objAfP3.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAfP3;
    }

    public AtendimentoFemininoP3 alterarAtendimentoFemininoP3(AtendimentoFemininoP3 objAfP3) {
        buscarInterno(objAfP3.getNomeInternoCrc(), objAfP3.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ADME_AFP3 SET IdLanc=?,IdInternoCrc=?,DataUltimaMenstruacao=?,Gestante=?,CertezaDuvidaGestacao=?,HabitosAlimentares=?,"
                    + "MedicamentoGestacao=?,InternacaoGestacao=?,OndeGestacao=?,Cigarro=?,Pacaia=?,Maconha=?,Cocaina=?,Craque=?,Alcool=?,Outros=?,QuaisDrogras=?,SinaisSintomas=?,OcupacaoHabitual=?,"
                    + "AceitacaoGravidez=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdAfp3='" + objAfP3.getIdAfp3() + "'");
            pst.setInt(1, objAfP3.getIdLanc());
            pst.setInt(2, codigoInterno);
            if (objAfP3.getDataUltimaMenstruacao() != null) {
                pst.setTimestamp(3, new java.sql.Timestamp(objAfP3.getDataUltimaMenstruacao().getTime()));
            } else {
                pst.setDate(3, null);
            }
            pst.setString(4, objAfP3.getGestante());
            pst.setString(5, objAfP3.getCertezaDuvidaGestacao());
            pst.setString(6, objAfP3.getHabitosAlimentares());
            pst.setString(7, objAfP3.getMedicamentoGestacao());
            pst.setString(8, objAfP3.getInternacaoGestacao());
            pst.setString(9, objAfP3.getOndeGestacao());
            pst.setInt(10, objAfP3.getCigarro());
            pst.setInt(11, objAfP3.getPacaia());
            pst.setInt(12, objAfP3.getMaconha());
            pst.setInt(13, objAfP3.getCocaina());
            pst.setInt(14, objAfP3.getCraque());
            pst.setInt(15, objAfP3.getAlcool());
            pst.setInt(16, objAfP3.getOutros());
            pst.setString(17, objAfP3.getQuaisDrogras());
            pst.setString(18, objAfP3.getSinaisSintomas());
            pst.setString(19, objAfP3.getOcupacaoHabitual());
            pst.setString(20, objAfP3.getAceitacaoGravidez());
            pst.setString(21, objAfP3.getUsuarioUp());
            pst.setString(22, objAfP3.getDataUp());
            pst.setString(23, objAfP3.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAfP3;
    }

    public AtendimentoFemininoP3 excluirAtendimentoFemininoP3(AtendimentoFemininoP3 objAfP3) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ADME_AFP3 WHERE IdAfp3='" + objAfP3.getIdAfp3() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUÍR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAfP3;
    }

    public void buscarInterno(String desc, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + desc + "'AND IdInternoCrc='" + codigo + "'");
            conecta.rs.first();
            codigoInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível pesquisar o interno.\nERRO: " + ex);
        }
    }
}
