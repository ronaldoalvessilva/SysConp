/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AtendimentoJuridico;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleJuridicoNovaAdmissao {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AtendimentoJuridico objAtendJuri = new AtendimentoJuridico();
    int codInt;

    public AtendimentoJuridico incluirAtendJuridicoNOVA(AtendimentoJuridico objAtendJuri) {
        buscarInternoCrc(objAtendJuri.getNomeInterno(),objAtendJuri.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ADMISSAO_JURIDICO_ADICIONAL (IdLanc,StatusLanc,DataLanc,IdInternoCrc,DataEnca,TipoAdvogado,Resposta,HoraEnvio,SetorEncaminhamento,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1,objAtendJuri.getIdLanc());
            pst.setString(2, objAtendJuri.getStatusLanc());
            pst.setTimestamp(3, new java.sql.Timestamp(objAtendJuri.getDataLanc().getTime()));
            pst.setInt(4, codInt);
            if (objAtendJuri.getDataEnca() != null) {
                pst.setTimestamp(5, new java.sql.Timestamp(objAtendJuri.getDataEnca().getTime()));
            } else {
                pst.setDate(5, null);
            }
            pst.setString(6, objAtendJuri.getTipoAdvogado());
            pst.setString(7, objAtendJuri.getResposta());
            pst.setString(8, objAtendJuri.getHoraEnvio());
            pst.setString(9, objAtendJuri.getSetorEncaminhameto());
            pst.setString(10, objAtendJuri.getObservacao());
            pst.setString(11, objAtendJuri.getUsuarioInsert());
            pst.setString(12, objAtendJuri.getDataInsert());
            pst.setString(13, objAtendJuri.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtendJuri;
    }

    public AtendimentoJuridico alterarAtendJuridicoNOVA(AtendimentoJuridico objAtendJuri) {
        buscarInternoCrc(objAtendJuri.getNomeInterno(),objAtendJuri.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ADMISSAO_JURIDICO_ADICIONAL SET StatusLanc=?,DataLanc=?,IdInternoCrc=?,DataEnca=?,TipoAdvogado=?,Resposta=?,HoraEnvio=?,SetorEncaminhamento=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdADM_JURI='" + objAtendJuri.getIdADM_JURI() + "'");
            pst.setString(1, objAtendJuri.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objAtendJuri.getDataLanc().getTime()));
            pst.setInt(3, codInt);
            if (objAtendJuri.getDataEnca() != null) {
                pst.setTimestamp(4, new java.sql.Timestamp(objAtendJuri.getDataEnca().getTime()));
            } else {
                pst.setDate(4, null);
            }
            pst.setString(5, objAtendJuri.getTipoAdvogado());
            pst.setString(6, objAtendJuri.getResposta());
            pst.setString(7, objAtendJuri.getHoraEnvio());
            pst.setString(8, objAtendJuri.getSetorEncaminhameto());
            pst.setString(9, objAtendJuri.getObservacao());
            pst.setString(10, objAtendJuri.getUsuarioUp());
            pst.setString(11, objAtendJuri.getDataUp());
            pst.setString(12, objAtendJuri.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtendJuri;
    }

    public AtendimentoJuridico excluirAtendJuridicoNOVA(AtendimentoJuridico objAtendJuri) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ADMISSAO_JURIDICO_ADICIONAL WHERE IdADM_JURI='" + objAtendJuri.getIdADM_JURI() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAtendJuri;
    }

    public AtendimentoJuridico finalizarAtendJuridicoNOVA(AtendimentoJuridico objAtendJuri) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ADMISSAO_JURIDICO_ADICIONAL SET StatusLanc=? WHERE IdADM_JURI='" + objAtendJuri.getIdADM_JURI() + "'");
            pst.setString(1, objAtendJuri.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAtendJuri;
    }
    // Buscar o nome do interno

    public void buscarInternoCrc(String desc, int cod) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE NomeInternoCrc='" + desc + "' "
                    + "AND IdInternoCrc='" + cod + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNOS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
