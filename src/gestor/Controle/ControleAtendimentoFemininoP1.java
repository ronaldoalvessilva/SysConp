/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AtendimentoFemininoP1;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleAtendimentoFemininoP1 {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AtendimentoFemininoP1 objAfP1 = new AtendimentoFemininoP1();

    int codigoInterno;

    public AtendimentoFemininoP1 incluirAtendimentoFemininoP1(AtendimentoFemininoP1 objAfP1) {
        buscarInterno(objAfP1.getNomeInternoCrc(), objAfP1.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ADME_AFP1 (IdLanc,IdInternoCrc,Hipertensao,Cardiopatias,Anemias,"
                    + "DoencasRenais,Diabetes,APAlergias,PortadorHIV,Transfusao,Retroviarias,QuaisRetroviarias,Cirurgias,DataCirurgia,TipoCirurgia,"
                    + "Ciclos,Metodos,Doencas,Colpocitologia,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objAfP1.getIdLanc());
            pst.setInt(2, codigoInterno);
            pst.setString(3, objAfP1.getHipertensao());
            pst.setString(4, objAfP1.getCardiopatias());
            pst.setString(5, objAfP1.getAnemias());
            pst.setString(6, objAfP1.getDoencasRenais());
            pst.setString(7, objAfP1.getDiabetes());
            pst.setString(8, objAfP1.getaPAlergias());
            pst.setString(9, objAfP1.getPortadorHIV());
            pst.setString(10, objAfP1.getTransfusao());
            pst.setString(11, objAfP1.getRetroviarias());
            pst.setString(12, objAfP1.getQuaisRetroviarias());
            pst.setString(13, objAfP1.getCirurgias());
            if (objAfP1.getDataCirurgia() != null) {
                pst.setTimestamp(14, new java.sql.Timestamp(objAfP1.getDataCirurgia().getTime()));
            } else {
                pst.setDate(14, null);
            }
            pst.setString(15, objAfP1.getTipoCirurgia());
            pst.setString(16, objAfP1.getCiclos());
            pst.setString(17, objAfP1.getMetodos());
            pst.setString(18, objAfP1.getDoencas());
            pst.setString(19, objAfP1.getColpocitologia());
            pst.setString(20, objAfP1.getUsuarioInsert());
            pst.setString(21, objAfP1.getDataInsert());
            pst.setString(22, objAfP1.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAfP1;
    }

    public AtendimentoFemininoP1 alterarAtendimentoFemininoP1(AtendimentoFemininoP1 objAfP1) {
        buscarInterno(objAfP1.getNomeInternoCrc(), objAfP1.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ADME_AFP1 SET IdLanc=?,IdInternoCrc=?,Hipertensao=?,Cardiopatias=?,Anemias=?,"
                    + "DoencasRenais=?,Diabetes=?,APAlergias=?,PortadorHIV=?,Transfusao=?,Retroviarias=?,QuaisRetroviarias=?,Cirurgias=?,DataCirurgia=?,"
                    + "TipoCirurgia=?,Ciclos=?,Metodos=?,Doencas=?,Colpocitologia=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdAfp1='" + objAfP1.getIdAfp1() + "'");
            pst.setInt(1, objAfP1.getIdLanc());
            pst.setInt(2, codigoInterno);
            pst.setString(3, objAfP1.getHipertensao());
            pst.setString(4, objAfP1.getCardiopatias());
            pst.setString(5, objAfP1.getAnemias());
            pst.setString(6, objAfP1.getDoencasRenais());
            pst.setString(7, objAfP1.getDiabetes());
            pst.setString(8, objAfP1.getaPAlergias());
            pst.setString(9, objAfP1.getPortadorHIV());
            pst.setString(10, objAfP1.getTransfusao());
            pst.setString(11, objAfP1.getRetroviarias());
            pst.setString(12, objAfP1.getQuaisRetroviarias());
            pst.setString(13, objAfP1.getCirurgias());
            if (objAfP1.getDataCirurgia() != null) {
                pst.setTimestamp(14, new java.sql.Timestamp(objAfP1.getDataCirurgia().getTime()));
            } else {
                pst.setDate(14, null);
            }
            pst.setString(15, objAfP1.getTipoCirurgia());
            pst.setString(16, objAfP1.getCiclos());
            pst.setString(17, objAfP1.getMetodos());
            pst.setString(18, objAfP1.getDoencas());
            pst.setString(19, objAfP1.getColpocitologia());
            pst.setString(20, objAfP1.getUsuarioUp());
            pst.setString(21, objAfP1.getDataUp());
            pst.setString(22, objAfP1.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAfP1;
    }

     public AtendimentoFemininoP1 excluirAtendimentoFemininoP1(AtendimentoFemininoP1 objAfP1) {
       
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ADME_AFP1 WHERE IdAfp1='" + objAfP1.getIdAfp1() + "'");          
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAfP1;
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
