/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AtendimentoFemininoP2;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleAtendimentoFemininoP2 {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AtendimentoFemininoP2 objAfP2 = new AtendimentoFemininoP2();
    int codigoInterno;

    public AtendimentoFemininoP2 incluirAtendimentoFemininoP2(AtendimentoFemininoP2 objAfP2) {
        buscarInterno(objAfP2.getNomeInternoCrc(), objAfP2.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ADME_AFP2 (IdLanc,IdInternoCrc,NumeroGestacoes,NumeroPartos,NumeroAbortos,"
                    + "NumeroFilhosVivos,IdadePrimeiraGestacao,IntervaloGestacoes,Pretermo,Postermo,BaixoPeso,MortesNeonataisPrecoce,MotivoMorteNeonataisPrecoce,"
                    + "MortesNeonataisTardias,MotivoMortesNeonataisTardias,Natimortos,Ictericia,Transfusao,Hipoglicemia,IsoimunizacaoRH,IntercorrenciaComplicacoesGestoes,"
                    + "HistoriaAleitamentosAnteriores,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objAfP2.getIdLanc());
            pst.setInt(2, codigoInterno);
            pst.setInt(3, objAfP2.getNumeroGestacoes());
            pst.setInt(4, objAfP2.getNumeroPartos());
            pst.setInt(5, objAfP2.getNumeroAbortos());
            pst.setInt(6, objAfP2.getNumeroFilhosVivos());
            pst.setInt(7, objAfP2.getIdadePrimeiraGestacao());
            pst.setInt(8, objAfP2.getIntervaloGestacoes());
            pst.setInt(9, objAfP2.getPretermo());
            pst.setInt(10, objAfP2.getPostermo());
            pst.setInt(11, objAfP2.getBaixoPeso());
            pst.setInt(12, objAfP2.getMortesNeonataisPrecoce());
            pst.setString(13, objAfP2.getMotivoMorteNeonataisPrecoce());
            pst.setInt(14, objAfP2.getMortesNeonataisTardias());
            pst.setString(15, objAfP2.getMotivoMortesNeonataisTardias());
            pst.setInt(16, objAfP2.getNatimortos());
            pst.setInt(17, objAfP2.getIctericia());
            pst.setInt(18, objAfP2.getTransfusao());
            pst.setInt(19, objAfP2.getHipoglicemia());
            pst.setString(20, objAfP2.getIsoimunizacaoRH());
            pst.setString(21, objAfP2.getIntercorrenciaComplicacoesGestoes());
            pst.setString(22, objAfP2.getHistoriaAleitamentosAnteriores());
            pst.setString(23, objAfP2.getUsuarioInsert());
            pst.setString(24, objAfP2.getDataInsert());
            pst.setString(25, objAfP2.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAfP2;
    }

    public AtendimentoFemininoP2 alterarAtendimentoFemininoP2(AtendimentoFemininoP2 objAfP2) {
        buscarInterno(objAfP2.getNomeInternoCrc(), objAfP2.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ADME_AFP2 SET IdLanc=?,IdInternoCrc=?,NumeroGestacoes=?,NumeroPartos=?,NumeroAbortos=?,"
                    + "NumeroFilhosVivos=?,IdadePrimeiraGestacao=?,IntervaloGestacoes=?,Pretermo=?,Postermo=?,BaixoPeso=?,MortesNeonataisPrecoce=?,MotivoMorteNeonataisPrecoce=?,"
                    + "MortesNeonataisTardias=?,MotivoMortesNeonataisTardias=?,Natimortos=?,Ictericia=?,Transfusao=?,Hipoglicemia=?,IsoimunizacaoRH=?,IntercorrenciaComplicacoesGestoes=?,"
                    + "HistoriaAleitamentosAnteriores=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdAfp2='" + objAfP2.getIdAfp2() + "'");
            pst.setInt(1, objAfP2.getIdLanc());
            pst.setInt(2, codigoInterno);
            pst.setInt(3, objAfP2.getNumeroGestacoes());
            pst.setInt(4, objAfP2.getNumeroPartos());
            pst.setInt(5, objAfP2.getNumeroAbortos());
            pst.setInt(6, objAfP2.getNumeroFilhosVivos());
            pst.setInt(7, objAfP2.getIdadePrimeiraGestacao());
            pst.setInt(8, objAfP2.getIntervaloGestacoes());
            pst.setInt(9, objAfP2.getPretermo());
            pst.setInt(10, objAfP2.getPostermo());
            pst.setInt(11, objAfP2.getBaixoPeso());
            pst.setInt(12, objAfP2.getMortesNeonataisPrecoce());
            pst.setString(13, objAfP2.getMotivoMorteNeonataisPrecoce());
            pst.setInt(14, objAfP2.getMortesNeonataisTardias());
            pst.setString(15, objAfP2.getMotivoMortesNeonataisTardias());
            pst.setInt(16, objAfP2.getNatimortos());
            pst.setInt(17, objAfP2.getIctericia());
            pst.setInt(18, objAfP2.getTransfusao());
            pst.setInt(19, objAfP2.getHipoglicemia());
            pst.setString(20, objAfP2.getIsoimunizacaoRH());
            pst.setString(21, objAfP2.getIntercorrenciaComplicacoesGestoes());
            pst.setString(22, objAfP2.getHistoriaAleitamentosAnteriores());
            pst.setString(23, objAfP2.getUsuarioUp());
            pst.setString(24, objAfP2.getDataUp());
            pst.setString(25, objAfP2.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAfP2;
    }

    public AtendimentoFemininoP2 excluirAtendimentoFemininoP2(AtendimentoFemininoP2 objAfP2) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ADME_AFP2 WHERE IdAfp2='" + objAfP2.getIdAfp2() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAfP2;
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
