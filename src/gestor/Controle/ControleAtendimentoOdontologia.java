/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AtendimentoOdontologico;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleAtendimentoOdontologia {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AtendimentoOdontologico objAtendOdonto = new AtendimentoOdontologico();
    int codInterno;

    public AtendimentoOdontologico incluirAtendOdonto(AtendimentoOdontologico objAtendOdonto) {
        buscarInterno(objAtendOdonto.getNomeInterno(), objAtendOdonto.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ATENDIMENTODONTO (StatusLanc,DataLanc,IdInternoCrc,TipoAtendimento,"
                    + "TratamentoMedico,Medicacao,Alegria,QueixaPrincipal,Afirmacao1,Afirmacao2,Afirmacao3,PlanoTratamento,Hepatite,Hiv,Asma,Fumante,"
                    + "Febre,Diabetes,Epilepsia,Cicatrizacao,Disturbios,Endocardite,Epatico,Renal,Cardiaco,Tensao,Cirurgia,Internacao,TextoDoenca,"
                    + "UsuarioInsert,DataInsert,HorarioInsert,Gestante,TempoGestacao,Observacao,Sifilis,Tuberculose,Outras,QualOutraDoenca) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objAtendOdonto.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objAtendOdonto.getDataLanc().getTime()));
            pst.setInt(3, codInterno);
            pst.setString(4, objAtendOdonto.getTipoAtendimento());
            pst.setString(5, objAtendOdonto.getTratamentoMedico());
            pst.setString(6, objAtendOdonto.getMedicacao());
            pst.setString(7, objAtendOdonto.getAlegria());
            pst.setString(8, objAtendOdonto.getQueixaPrincipal());
            pst.setString(9, objAtendOdonto.getAfirmacao1());
            pst.setString(10, objAtendOdonto.getAfirmacao2());
            pst.setString(11, objAtendOdonto.getAfirmacao3());
            pst.setString(12, objAtendOdonto.getPlanoTratamento());
            pst.setString(13, objAtendOdonto.getHepatite());
            pst.setString(14, objAtendOdonto.getHiv());
            pst.setString(15, objAtendOdonto.getAsma());
            pst.setString(16, objAtendOdonto.getFumante());
            pst.setString(17, objAtendOdonto.getFebre());
            pst.setString(18, objAtendOdonto.getDiabetes());
            pst.setString(19, objAtendOdonto.getEpilepsia());
            pst.setString(20, objAtendOdonto.getCicatrizacao());
            pst.setString(21, objAtendOdonto.getDisturbios());
            pst.setString(22, objAtendOdonto.getEndocardite());
            pst.setString(23, objAtendOdonto.getEpatico());
            pst.setString(24, objAtendOdonto.getRenal());
            pst.setString(25, objAtendOdonto.getCardiaco());
            pst.setString(26, objAtendOdonto.getTensao());
            pst.setString(27, objAtendOdonto.getCirurgia());
            pst.setString(28, objAtendOdonto.getInternacao());
            pst.setString(29, objAtendOdonto.getTextoDoenca());
            pst.setString(30, objAtendOdonto.getUsuarioInsert());
            pst.setString(31, objAtendOdonto.getDataInsert());
            pst.setString(32, objAtendOdonto.getHorarioInsert());
            pst.setString(33, objAtendOdonto.getGestante());
            pst.setInt(34, objAtendOdonto.getTempoGestacao());
            pst.setString(35, objAtendOdonto.getObservacao());
            pst.setString(36, objAtendOdonto.getSifilis());
            pst.setString(37, objAtendOdonto.getTuberculose());
            pst.setString(38, objAtendOdonto.getOutras());
            pst.setString(39, objAtendOdonto.getQualOutraDoenca());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtendOdonto;
    }

    public AtendimentoOdontologico alterarAtendOdonto(AtendimentoOdontologico objAtendOdonto) {
        buscarInterno(objAtendOdonto.getNomeInterno(), objAtendOdonto.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATENDIMENTODONTO SET StatusLanc=?,DataLanc=?,IdInternoCrc=?,"
                    + "TipoAtendimento=?,TratamentoMedico=?,Medicacao=?,Alegria=?,QueixaPrincipal=?,Afirmacao1=?,Afirmacao2=?,Afirmacao3=?,"
                    + "PlanoTratamento=?,Hepatite=?,Hiv=?,Asma=?,Fumante=?,Febre=?,Diabetes=?,Epilepsia=?,Cicatrizacao=?,Disturbios=?,"
                    + "Endocardite=?,Epatico=?,Renal=?,Cardiaco=?,Tensao=?,Cirurgia=?,Internacao=?,TextoDoenca=?,UsuarioUp=?,DataUp=?,"
                    + "HorarioUp=?,Gestante=?,TempoGestacao=?,Observacao=?,Sifilis=?,Tuberculose=?,Outras=?,QualOutraDoenca=? WHERE IdLanc='" + objAtendOdonto.getIdLanc() + "'");
            pst.setString(1, objAtendOdonto.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objAtendOdonto.getDataLanc().getTime()));
            pst.setInt(3, codInterno);
            pst.setString(4, objAtendOdonto.getTipoAtendimento());
            pst.setString(5, objAtendOdonto.getTratamentoMedico());
            pst.setString(6, objAtendOdonto.getMedicacao());
            pst.setString(7, objAtendOdonto.getAlegria());
            pst.setString(8, objAtendOdonto.getQueixaPrincipal());
            pst.setString(9, objAtendOdonto.getAfirmacao1());
            pst.setString(10, objAtendOdonto.getAfirmacao2());
            pst.setString(11, objAtendOdonto.getAfirmacao3());
            pst.setString(12, objAtendOdonto.getPlanoTratamento());
            pst.setString(13, objAtendOdonto.getHepatite());
            pst.setString(14, objAtendOdonto.getHiv());
            pst.setString(15, objAtendOdonto.getAsma());
            pst.setString(16, objAtendOdonto.getFumante());
            pst.setString(17, objAtendOdonto.getFebre());
            pst.setString(18, objAtendOdonto.getDiabetes());
            pst.setString(19, objAtendOdonto.getEpilepsia());
            pst.setString(20, objAtendOdonto.getCicatrizacao());
            pst.setString(21, objAtendOdonto.getDisturbios());
            pst.setString(22, objAtendOdonto.getEndocardite());
            pst.setString(23, objAtendOdonto.getEpatico());
            pst.setString(24, objAtendOdonto.getRenal());
            pst.setString(25, objAtendOdonto.getCardiaco());
            pst.setString(26, objAtendOdonto.getTensao());
            pst.setString(27, objAtendOdonto.getCirurgia());
            pst.setString(28, objAtendOdonto.getInternacao());
            pst.setString(29, objAtendOdonto.getTextoDoenca());
            pst.setString(30, objAtendOdonto.getUsuarioUp());
            pst.setString(31, objAtendOdonto.getDataUp());
            pst.setString(32, objAtendOdonto.getHorarioUp());
            pst.setString(33, objAtendOdonto.getGestante());
            pst.setInt(34, objAtendOdonto.getTempoGestacao());
            pst.setString(35, objAtendOdonto.getObservacao());
            pst.setString(36, objAtendOdonto.getSifilis());
            pst.setString(37, objAtendOdonto.getTuberculose());
            pst.setString(38, objAtendOdonto.getOutras());
            pst.setString(39, objAtendOdonto.getQualOutraDoenca());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAtendOdonto;
    }

    public AtendimentoOdontologico excluirAtendOdonto(AtendimentoOdontologico objAtendOdonto) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ATENDIMENTODONTO WHERE IdLanc='" + objAtendOdonto.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAtendOdonto;
    }

    public AtendimentoOdontologico finalizarAtendOdonto(AtendimentoOdontologico objAtendOdonto) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATENDIMENTODONTO SET StatusLanc=? WHERE IdLanc='" + objAtendOdonto.getIdLanc() + "'");
            pst.setString(1, objAtendOdonto.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAtendOdonto;
    }

    public void buscarInterno(String desc, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + desc + "'AND IdInternoCrc='" + codigo + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível pesquisar o interno.\nERRO: " + ex);
        }
    }
}
