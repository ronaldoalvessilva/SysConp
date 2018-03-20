/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AvaliacaoPsicologica;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleAvaliacaoPsicologica {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AvaliacaoPsicologica objAvaPsi = new AvaliacaoPsicologica();
    int codInt;

    public AvaliacaoPsicologica incluirAvaliacaoPsicologica(AvaliacaoPsicologica objAvaPsi) {
        buscarInternoCrc(objAvaPsi.getNomeInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO AVALIACAOPSI (StatusLanc,DataLanc,IdInternoCrc,InfanciaPergunta1,InfanciaPergunta2,InfanciaPergunta3,InfanciaPergunta4,EscolaPergunta1,EscolaPergunta2,VidaLaborativa,RedeSocial,SubstanciaPsicoativa,RelacaoAfetiva,Pespectiva,HistoricoCriminal,HistoricoPrisional,DadosCognitivos,IndicadorPsicopatologico,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objAvaPsi.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objAvaPsi.getDataLanc().getTime()));
            pst.setInt(3, codInt);
            pst.setString(4, objAvaPsi.getInfanciaPergunta1());
            pst.setString(5, objAvaPsi.getInfanciaPergunta2());
            pst.setString(6, objAvaPsi.getInfanciaPergunta3());
            pst.setString(7, objAvaPsi.getInfanciaPergunta4());
            pst.setString(8, objAvaPsi.getEscolaPergunta1());
            pst.setString(9, objAvaPsi.getEscolaPergunta2());
            pst.setString(10, objAvaPsi.getVidaLaborativa());
            pst.setString(11, objAvaPsi.getRedeSocial());
            pst.setString(12, objAvaPsi.getSubstanciaPsicoativa());
            pst.setString(13, objAvaPsi.getRelacaoAfetiva());
            pst.setString(14, objAvaPsi.getPespectiva());
            pst.setString(15, objAvaPsi.getHistoricoCriminal());
            pst.setString(16, objAvaPsi.getHistoricoPrisional());
            pst.setString(17, objAvaPsi.getDadosCognitivos());
            pst.setString(18, objAvaPsi.getIndicadorPsicopatologico());
            pst.setString(19, objAvaPsi.getUsuarioInsert());
            pst.setString(20, objAvaPsi.getDataInsert());
            pst.setString(21, objAvaPsi.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAvaPsi;
    }

    public AvaliacaoPsicologica alterarAvaliacaoPsicologica(AvaliacaoPsicologica objAvaPsi) {
        buscarInternoCrc(objAvaPsi.getNomeInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE AVALIACAOPSI SET StatusLanc=?,DataLanc=?,IdInternoCrc=?,InfanciaPergunta1=?,InfanciaPergunta2=?,InfanciaPergunta3=?,InfanciaPergunta4=?,EscolaPergunta1=?,EscolaPergunta2=?,VidaLaborativa=?,RedeSocial=?,SubstanciaPsicoativa=?,RelacaoAfetiva=?,Pespectiva=?,HistoricoCriminal=?,HistoricoPrisional=?,DadosCognitivos=?,IndicadorPsicopatologico=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdLanc='" + objAvaPsi.getIdLanc() + "'");
            pst.setString(1, objAvaPsi.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objAvaPsi.getDataLanc().getTime()));
            pst.setInt(3, codInt);
            pst.setString(4, objAvaPsi.getInfanciaPergunta1());
            pst.setString(5, objAvaPsi.getInfanciaPergunta2());
            pst.setString(6, objAvaPsi.getInfanciaPergunta3());
            pst.setString(7, objAvaPsi.getInfanciaPergunta4());
            pst.setString(8, objAvaPsi.getEscolaPergunta1());
            pst.setString(9, objAvaPsi.getEscolaPergunta2());
            pst.setString(10, objAvaPsi.getVidaLaborativa());
            pst.setString(11, objAvaPsi.getRedeSocial());
            pst.setString(12, objAvaPsi.getSubstanciaPsicoativa());
            pst.setString(13, objAvaPsi.getRelacaoAfetiva());
            pst.setString(14, objAvaPsi.getPespectiva());
            pst.setString(15, objAvaPsi.getHistoricoCriminal());
            pst.setString(16, objAvaPsi.getHistoricoPrisional());
            pst.setString(17, objAvaPsi.getDadosCognitivos());
            pst.setString(18, objAvaPsi.getIndicadorPsicopatologico());
            pst.setString(19, objAvaPsi.getUsuarioUp());
            pst.setString(20, objAvaPsi.getDataUp());
            pst.setString(21, objAvaPsi.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAvaPsi;
    }

    public AvaliacaoPsicologica excluirAvaliacaoPsicologica(AvaliacaoPsicologica objAvaPsi) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM AVALIACAOPSI WHERE IdLanc='" + objAvaPsi.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAvaPsi;
    }

    public AvaliacaoPsicologica finalizarAvaliacaoPsicologica(AvaliacaoPsicologica objAvaPsi) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE AVALIACAOPSI SET StatusLanc=? WHERE IdLanc='" + objAvaPsi.getIdLanc() + "'");
            pst.setString(1, objAvaPsi.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAvaPsi;
    }

    // Buscar o nome do interno

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
