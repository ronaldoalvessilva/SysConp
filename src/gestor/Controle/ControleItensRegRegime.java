/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensRegressaoRegime;
import static gestor.Visao.TelaPesquisaInternoMuddancaRegime.regimeAnterior;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleItensRegRegime {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensRegressaoRegime objItenReg = new ItensRegressaoRegime();
    //
    String situacaoEnt = "ENTRADA NA UNIDADE";
    String situacaoRet = "RETORNO A UNIDADE";
    int codInterno;

    public ItensRegressaoRegime incluirItensRegressaoRegime(ItensRegressaoRegime objItenReg) {
        buscarInternoCrc(objItenReg.getNomeInternoCrc(),objItenReg.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENSREGRESSAOREGIME (IdLanc,IdInternoCrc,DataRegressao,NovoRegimeReg,NovaDataCondenacao,NovaPena,NovoTerminoPenaReg,NovoCrimeHediondo,Juizo,NovoArtigo1,NovoArtigo2,NovoArtigo3,NovoParagrafo1,NovoParagrafo2,NovoParagrafo3,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objItenReg.getIdLanc());
            pst.setInt(2, codInterno);
            pst.setTimestamp(3, new java.sql.Timestamp(objItenReg.getDataRegressao().getTime()));
            pst.setString(4, objItenReg.getRegime());
            pst.setTimestamp(5, new java.sql.Timestamp(objItenReg.getDataCondenacao().getTime()));
            pst.setString(6, objItenReg.getPena());
            pst.setTimestamp(7, new java.sql.Timestamp(objItenReg.getTerminoPena().getTime()));
            pst.setString(8, objItenReg.getCrimeHediondo());
            pst.setString(9, objItenReg.getJuizo());
            pst.setString(10, objItenReg.getArtigo1());
            pst.setString(11, objItenReg.getArtigo2());
            pst.setString(12, objItenReg.getArtigo3());
            pst.setString(13, objItenReg.getParagrafo1());
            pst.setString(14, objItenReg.getParagrafo2());
            pst.setString(15, objItenReg.getParagrafo3());
            pst.setString(16, objItenReg.getUsuarioInsert());
            pst.setString(17, objItenReg.getDataInsert());
            pst.setString(18, objItenReg.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItenReg;
    }

    public ItensRegressaoRegime alterarItensRegressaoRegime(ItensRegressaoRegime objItenReg) {
        buscarInternoCrc(objItenReg.getNomeInternoCrc(),objItenReg.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSREGRESSAOREGIME SET IdLanc=?,IdInternoCrc=?,DataRegressao=?,NovoRegimeReg=?,NovaDataCondenacao=?,NovaPena=?,NovoTerminoPenaReg=?,NovoCrimeHediondo=?,Juizo=?,NovoArtigo1=?,NovoArtigo2=?,NovoArtigo3=?,NovoParagrafo1=?,NovoParagrafo2=?,NovoParagrafo3=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objItenReg.getIdItem() + "'");
            pst.setInt(1, objItenReg.getIdLanc());
            pst.setInt(2, codInterno);
            pst.setTimestamp(3, new java.sql.Timestamp(objItenReg.getDataRegressao().getTime()));
            pst.setString(4, objItenReg.getRegime());
            pst.setTimestamp(5, new java.sql.Timestamp(objItenReg.getDataCondenacao().getTime()));
            pst.setString(6, objItenReg.getPena());
            pst.setTimestamp(7, new java.sql.Timestamp(objItenReg.getTerminoPena().getTime()));
            pst.setString(8, objItenReg.getCrimeHediondo());
            pst.setString(9, objItenReg.getJuizo());
            pst.setString(10, objItenReg.getArtigo1());
            pst.setString(11, objItenReg.getArtigo2());
            pst.setString(12, objItenReg.getArtigo3());
            pst.setString(13, objItenReg.getParagrafo1());
            pst.setString(14, objItenReg.getParagrafo2());
            pst.setString(15, objItenReg.getParagrafo3());
            pst.setString(16, objItenReg.getUsuarioUp());
            pst.setString(17, objItenReg.getDataUp());
            pst.setString(18, objItenReg.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItenReg;
    }

    // Atualiza o prontuario do interno quando o mesmo está o regime provisório e muda para outro regime.
    public ItensRegressaoRegime atualizarRegimeInternoProvisorio(ItensRegressaoRegime objItenReg) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE DADOSPENAISINTERNOS SET Regime=?,DataCondenacao=?,Pena=?,TerminoPena=?,CrimeEdiondo=?,Artigo1=?,Artigo2=?,Artigo3=?,Paragrafo1=?,Paragrafo2=?,Paragrafo3=? WHERE IdInternoCrc='" + objItenReg.getIdInternoCrc() + "'AND Regime='" + regimeAnterior + "'");
            pst.setString(1, objItenReg.getRegime());
            pst.setTimestamp(2, new java.sql.Timestamp(objItenReg.getDataCondenacao().getTime()));
            pst.setString(3, objItenReg.getPena());
            pst.setTimestamp(4, new java.sql.Timestamp(objItenReg.getTerminoPena().getTime()));
            pst.setString(5, objItenReg.getCrimeHediondo());
            pst.setString(6, objItenReg.getArtigo1());
            pst.setString(7, objItenReg.getArtigo2());
            pst.setString(8, objItenReg.getArtigo3());
            pst.setString(9, objItenReg.getParagrafo1());
            pst.setString(10, objItenReg.getParagrafo2());
            pst.setString(11, objItenReg.getParagrafo3());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados do PRONTUARIO do INTERNO \n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItenReg;
    }

    // Atualiza o prontuario do interno quando o mesmo está o regime Semi-Aberto/Fechado e muda para outro regime.

    public ItensRegressaoRegime atualizarRegInternoFechadoSemiAberto(ItensRegressaoRegime objItenReg) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE DADOSPENAISINTERNOS SET Regime=?,Pena=?,TerminoPena=?,Artigo3=?,Paragrafo3=? WHERE IdInternoCrc='" + objItenReg.getIdInternoCrc() + "'AND Regime='" + regimeAnterior + "'");
            pst.setString(1, objItenReg.getRegime());
            pst.setString(2, objItenReg.getPena());
            pst.setTimestamp(3, new java.sql.Timestamp(objItenReg.getTerminoPena().getTime()));
            pst.setString(4, objItenReg.getArtigo3());
            pst.setString(5, objItenReg.getParagrafo3());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados do PRONTUARIO do INTERNO \n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItenReg;
    }

    public ItensRegressaoRegime excluirItensRegressaoRegime(ItensRegressaoRegime objItenReg) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENSREGRESSAOREGIME WHERE IdItem='" + objItenReg.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItenReg;
    }

    public void buscarInternoCrc(String desc, int cod) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE NomeInternoCrc='" + desc + "' "
                    + "AND IdInternoCrc='" + cod + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNO) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
