/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AdmissaoMedica;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleAdmissaoMedica {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AdmissaoMedica objAdmMedico = new AdmissaoMedica();
    int codInterno;

    public AdmissaoMedica incluirAdmissaoMedica(AdmissaoMedica objAdmMedico) {
        buscarInterno(objAdmMedico.getNomeInterno(), objAdmMedico.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ADMISSAOMEDICA (StatusLanc,DataLanc,IdInternoCrc,"
                    + "AR,ACV,AGU,CABPESC,EXT,ABD,CirurgiasPrevisas,TratamentoCurso,QualDrogas,QualEtilismo,QuantoTempoTabagismo,"
                    + "Drogas,Etilismo,Tabagismo,Vacinas,AtualizaIgnora,UsuarioInsert,DataInsert,HorarioInsert,CombBoxAR,CombBoxACV,"
                    + "CombBoxAGU,CombBoxCABPESC,CombBoxEXT,CombBoxABD,Alergia,QuaisAlergias,DrogaInjetavel,QualTipoDrogaInjet,"
                    + "Sexualidade,NumeroPareceiro,TipoSangue,FatorRh,UsaPreserva,UsaMedicamento,QualMedicamento,OutrasAlergias,"
                    + "QuaisOutrasAlergias,DiagnosticoInicial,TipoDiag) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objAdmMedico.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objAdmMedico.getDataLanc().getTime()));
            pst.setInt(3, codInterno);
            pst.setString(4, objAdmMedico.getAr());
            pst.setString(5, objAdmMedico.getAcv());
            pst.setString(6, objAdmMedico.getAgu());
            pst.setString(7, objAdmMedico.getCabPesc());
            pst.setString(8, objAdmMedico.getExt());
            pst.setString(9, objAdmMedico.getAbd());
            pst.setString(10, objAdmMedico.getCirurgiasPrevisas());
            pst.setString(11, objAdmMedico.getTratamentoCurso());
            pst.setString(12, objAdmMedico.getQualDrogas());
            pst.setString(13, objAdmMedico.getQualEtilismo());
            pst.setString(14, objAdmMedico.getQuantoTempoTabagismo());
            pst.setString(15, objAdmMedico.getDrogas());
            pst.setString(16, objAdmMedico.getEtilismo());
            pst.setString(17, objAdmMedico.getTabagismo());
            pst.setString(18, objAdmMedico.getVacinas());
            pst.setString(19, objAdmMedico.getAtualizadaIgnorada());
            pst.setString(20, objAdmMedico.getUsuarioInsert());
            pst.setString(21, objAdmMedico.getDataInsert());
            pst.setString(22, objAdmMedico.getHoraInsert());
            pst.setString(23, objAdmMedico.getComboBoxAR());
            pst.setString(24, objAdmMedico.getComboBoxACV());
            pst.setString(25, objAdmMedico.getComboBoxAGU());
            pst.setString(26, objAdmMedico.getComboBoxCAB());
            pst.setString(27, objAdmMedico.getComboBoxEXT());
            pst.setString(28, objAdmMedico.getComboBoxABD());
            pst.setString(29, objAdmMedico.getAlergia());
            pst.setString(30, objAdmMedico.getQuaisAlergias());
            pst.setString(31, objAdmMedico.getDrogasInjetavel());
            pst.setString(32, objAdmMedico.getQualTipoDrograInjet());
            pst.setString(33, objAdmMedico.getSexualidade());
            pst.setString(34, objAdmMedico.getNumeroParceiros());
            pst.setString(35, objAdmMedico.getTipoSanguineo());
            pst.setString(36, objAdmMedico.getFatorRH());
            pst.setString(37, objAdmMedico.getUsoPreservativos());
            pst.setString(38, objAdmMedico.getUsaMedicamentos());
            pst.setString(39, objAdmMedico.getQualMedicacaoUsa());
            pst.setString(40, objAdmMedico.getOutrasAlergias());
            pst.setString(41, objAdmMedico.getQuaisOutrasAlergias());
            pst.setString(42, objAdmMedico.getDiagnostico());
            pst.setInt(43, objAdmMedico.getTipoDiagnostico());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAdmMedico;
    }

    public AdmissaoMedica alterarAdmissaoMedica(AdmissaoMedica objAdmMedico) {
        buscarInterno(objAdmMedico.getNomeInterno(), objAdmMedico.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ADMISSAOMEDICA SET StatusLanc=?,DataLanc=?,"
                    + "IdInternoCrc=?,AR=?,ACV=?,AGU=?,CABPESC=?,EXT=?,ABD=?,CirurgiasPrevisas=?,TratamentoCurso=?,"
                    + "QualDrogas=?,QualEtilismo=?,QuantoTempoTabagismo=?,Drogas=?,Etilismo=?,Tabagismo=?,Vacinas=?,"
                    + "AtualizaIgnora=?,UsuarioUp=?,DataUp=?,HorarioUp=?,CombBoxAR=?,CombBoxACV=?,CombBoxAGU=?,"
                    + "CombBoxCABPESC=?,CombBoxEXT=?,CombBoxABD=?,Alergia=?,QuaisAlergias=?,DrogaInjetavel=?,"
                    + "QualTipoDrogaInjet=?,Sexualidade=?,NumeroPareceiro=?,TipoSangue=?,FatorRh=?,UsaPreserva=?,"
                    + "UsaMedicamento=?,QualMedicamento=?,OutrasAlergias=?,QuaisOutrasAlergias=?,DiagnosticoInicial=?,"
                    + "TipoDiag=? WHERE IdLanc='" + objAdmMedico.getIdLanc() + "'");
            pst.setString(1, objAdmMedico.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objAdmMedico.getDataLanc().getTime()));
            pst.setInt(3, codInterno);
            pst.setString(4, objAdmMedico.getAr());
            pst.setString(5, objAdmMedico.getAcv());
            pst.setString(6, objAdmMedico.getAgu());
            pst.setString(7, objAdmMedico.getCabPesc());
            pst.setString(8, objAdmMedico.getExt());
            pst.setString(9, objAdmMedico.getAbd());
            pst.setString(10, objAdmMedico.getCirurgiasPrevisas());
            pst.setString(11, objAdmMedico.getTratamentoCurso());
            pst.setString(12, objAdmMedico.getQualDrogas());
            pst.setString(13, objAdmMedico.getQualEtilismo());
            pst.setString(14, objAdmMedico.getQuantoTempoTabagismo());
            pst.setString(15, objAdmMedico.getDrogas());
            pst.setString(16, objAdmMedico.getEtilismo());
            pst.setString(17, objAdmMedico.getTabagismo());
            pst.setString(18, objAdmMedico.getVacinas());
            pst.setString(19, objAdmMedico.getAtualizadaIgnorada());
            pst.setString(20, objAdmMedico.getUsuarioUp());
            pst.setString(21, objAdmMedico.getDataUp());
            pst.setString(22, objAdmMedico.getHoraUp());
            pst.setString(23, objAdmMedico.getComboBoxAR());
            pst.setString(24, objAdmMedico.getComboBoxACV());
            pst.setString(25, objAdmMedico.getComboBoxAGU());
            pst.setString(26, objAdmMedico.getComboBoxCAB());
            pst.setString(27, objAdmMedico.getComboBoxEXT());
            pst.setString(28, objAdmMedico.getComboBoxABD());
            pst.setString(29, objAdmMedico.getAlergia());
            pst.setString(30, objAdmMedico.getQuaisAlergias());
            pst.setString(31, objAdmMedico.getDrogasInjetavel());
            pst.setString(32, objAdmMedico.getQualTipoDrograInjet());
            pst.setString(33, objAdmMedico.getSexualidade());
            pst.setString(34, objAdmMedico.getNumeroParceiros());
            pst.setString(35, objAdmMedico.getTipoSanguineo());
            pst.setString(36, objAdmMedico.getFatorRH());
            pst.setString(37, objAdmMedico.getUsoPreservativos());
            pst.setString(38, objAdmMedico.getUsaMedicamentos());
            pst.setString(39, objAdmMedico.getQualMedicacaoUsa());
            pst.setString(40, objAdmMedico.getOutrasAlergias());
            pst.setString(41, objAdmMedico.getQuaisOutrasAlergias());
            pst.setString(42, objAdmMedico.getDiagnostico());
            pst.setInt(43, objAdmMedico.getTipoDiagnostico());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAdmMedico;
    }

    public AdmissaoMedica excluirAdmissaoMedica(AdmissaoMedica objAdmMedico) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ADMISSAOMEDICA WHERE IdLanc='" + objAdmMedico.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAdmMedico;
    }

    public AdmissaoMedica finalizarAdmissaoMedica(AdmissaoMedica objAdmMedico) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ADMISSAOMEDICA SET StatusLanc=? WHERE IdLanc='" + objAdmMedico.getIdLanc() + "'");
            pst.setString(1, objAdmMedico.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAdmMedico;
    }

    public void buscarInterno(String desc, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + desc + "'AND IdInternoCrc='" + codigo  + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível pesquisar o interno.\nERRO: " + ex);
        }
    }
}
