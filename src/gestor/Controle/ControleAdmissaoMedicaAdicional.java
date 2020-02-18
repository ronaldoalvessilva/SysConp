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
public class ControleAdmissaoMedicaAdicional {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AdmissaoMedica objAdmMedico = new AdmissaoMedica();
    int codInterno;

    public AdmissaoMedica incluirAdmissaoMedica(AdmissaoMedica objAdmMedico) {
        buscarInterno(objAdmMedico.getNomeInterno(), objAdmMedico.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ADMISSAO_MEDICA_ADICIONAL (IdLanc,StatusLanc,DataLanc,IdInternoCrc,"
                    + "AR,ACV,AGU,CABPESC,EXT,ABD,CirurgiasPrevisas,TratamentoCurso,QualDrogas,QualEtilismo,QuantoTempoTabagismo,"
                    + "Drogas,Etilismo,Tabagismo,Vacinas,AtualizaIgnora,UsuarioInsert,DataInsert,HorarioInsert,CombBoxAR,CombBoxACV,"
                    + "CombBoxAGU,CombBoxCABPESC,CombBoxEXT,CombBoxABD,Alergia,QuaisAlergias,DrogaInjetavel,QualTipoDrogaInjet,"
                    + "Sexualidade,NumeroPareceiro,TipoSangue,FatorRh,UsaPreserva,UsaMedicamento,QualMedicamento,OutrasAlergias,"
                    + "QuaisOutrasAlergias,DiagnosticoInicial,TipoDiag) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objAdmMedico.getIdLanc());
            pst.setString(2, objAdmMedico.getStatusLanc());
            pst.setTimestamp(3, new java.sql.Timestamp(objAdmMedico.getDataLanc().getTime()));
            pst.setInt(4, codInterno);
            pst.setString(5, objAdmMedico.getAr());
            pst.setString(6, objAdmMedico.getAcv());
            pst.setString(7, objAdmMedico.getAgu());
            pst.setString(8, objAdmMedico.getCabPesc());
            pst.setString(9, objAdmMedico.getExt());
            pst.setString(10, objAdmMedico.getAbd());
            pst.setString(11, objAdmMedico.getCirurgiasPrevisas());
            pst.setString(12, objAdmMedico.getTratamentoCurso());
            pst.setString(13, objAdmMedico.getQualDrogas());
            pst.setString(14, objAdmMedico.getQualEtilismo());
            pst.setString(15, objAdmMedico.getQuantoTempoTabagismo());
            pst.setString(16, objAdmMedico.getDrogas());
            pst.setString(17, objAdmMedico.getEtilismo());
            pst.setString(18, objAdmMedico.getTabagismo());
            pst.setString(19, objAdmMedico.getVacinas());
            pst.setString(20, objAdmMedico.getAtualizadaIgnorada());
            pst.setString(21, objAdmMedico.getUsuarioInsert());
            pst.setString(22, objAdmMedico.getDataInsert());
            pst.setString(23, objAdmMedico.getHoraInsert());
            pst.setString(24, objAdmMedico.getComboBoxAR());
            pst.setString(25, objAdmMedico.getComboBoxACV());
            pst.setString(26, objAdmMedico.getComboBoxAGU());
            pst.setString(27, objAdmMedico.getComboBoxCAB());
            pst.setString(28, objAdmMedico.getComboBoxEXT());
            pst.setString(29, objAdmMedico.getComboBoxABD());
            pst.setString(30, objAdmMedico.getAlergia());
            pst.setString(31, objAdmMedico.getQuaisAlergias());
            pst.setString(32, objAdmMedico.getDrogasInjetavel());
            pst.setString(33, objAdmMedico.getQualTipoDrograInjet());
            pst.setString(34, objAdmMedico.getSexualidade());
            pst.setString(35, objAdmMedico.getNumeroParceiros());
            pst.setString(36, objAdmMedico.getTipoSanguineo());
            pst.setString(37, objAdmMedico.getFatorRH());
            pst.setString(38, objAdmMedico.getUsoPreservativos());
            pst.setString(39, objAdmMedico.getUsaMedicamentos());
            pst.setString(40, objAdmMedico.getQualMedicacaoUsa());
            pst.setString(41, objAdmMedico.getOutrasAlergias());
            pst.setString(42, objAdmMedico.getQuaisOutrasAlergias());
            pst.setString(43, objAdmMedico.getDiagnostico());
            pst.setInt(44, objAdmMedico.getTipoDiagnostico());
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
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ADMISSAO_MEDICA_ADICIONAL SET IdLanc=?,StatusLanc=?,DataLanc=?,"
                    + "IdInternoCrc=?,AR=?,ACV=?,AGU=?,CABPESC=?,EXT=?,ABD=?,CirurgiasPrevisas=?,TratamentoCurso=?,"
                    + "QualDrogas=?,QualEtilismo=?,QuantoTempoTabagismo=?,Drogas=?,Etilismo=?,Tabagismo=?,Vacinas=?,"
                    + "AtualizaIgnora=?,UsuarioUp=?,DataUp=?,HorarioUp=?,CombBoxAR=?,CombBoxACV=?,CombBoxAGU=?,"
                    + "CombBoxCABPESC=?,CombBoxEXT=?,CombBoxABD=?,Alergia=?,QuaisAlergias=?,DrogaInjetavel=?,"
                    + "QualTipoDrogaInjet=?,Sexualidade=?,NumeroPareceiro=?,TipoSangue=?,FatorRh=?,UsaPreserva=?,"
                    + "UsaMedicamento=?,QualMedicamento=?,OutrasAlergias=?,QuaisOutrasAlergias=?,DiagnosticoInicial=?,"
                    + "TipoDiag=? WHERE IdAdmADI='" + objAdmMedico.getIdLanc() + "'");
            pst.setInt(1, objAdmMedico.getIdLanc());
            pst.setString(2, objAdmMedico.getStatusLanc());
            pst.setTimestamp(3, new java.sql.Timestamp(objAdmMedico.getDataLanc().getTime()));
            pst.setInt(4, codInterno);
            pst.setString(5, objAdmMedico.getAr());
            pst.setString(6, objAdmMedico.getAcv());
            pst.setString(7, objAdmMedico.getAgu());
            pst.setString(8, objAdmMedico.getCabPesc());
            pst.setString(9, objAdmMedico.getExt());
            pst.setString(10, objAdmMedico.getAbd());
            pst.setString(11, objAdmMedico.getCirurgiasPrevisas());
            pst.setString(12, objAdmMedico.getTratamentoCurso());
            pst.setString(13, objAdmMedico.getQualDrogas());
            pst.setString(14, objAdmMedico.getQualEtilismo());
            pst.setString(15, objAdmMedico.getQuantoTempoTabagismo());
            pst.setString(16, objAdmMedico.getDrogas());
            pst.setString(17, objAdmMedico.getEtilismo());
            pst.setString(18, objAdmMedico.getTabagismo());
            pst.setString(19, objAdmMedico.getVacinas());
            pst.setString(20, objAdmMedico.getAtualizadaIgnorada());
            pst.setString(21, objAdmMedico.getUsuarioUp());
            pst.setString(22, objAdmMedico.getDataUp());
            pst.setString(23, objAdmMedico.getHoraUp());
            pst.setString(24, objAdmMedico.getComboBoxAR());
            pst.setString(25, objAdmMedico.getComboBoxACV());
            pst.setString(26, objAdmMedico.getComboBoxAGU());
            pst.setString(27, objAdmMedico.getComboBoxCAB());
            pst.setString(28, objAdmMedico.getComboBoxEXT());
            pst.setString(29, objAdmMedico.getComboBoxABD());
            pst.setString(30, objAdmMedico.getAlergia());
            pst.setString(31, objAdmMedico.getQuaisAlergias());
            pst.setString(32, objAdmMedico.getDrogasInjetavel());
            pst.setString(33, objAdmMedico.getQualTipoDrograInjet());
            pst.setString(34, objAdmMedico.getSexualidade());
            pst.setString(35, objAdmMedico.getNumeroParceiros());
            pst.setString(36, objAdmMedico.getTipoSanguineo());
            pst.setString(37, objAdmMedico.getFatorRH());
            pst.setString(38, objAdmMedico.getUsoPreservativos());
            pst.setString(39, objAdmMedico.getUsaMedicamentos());
            pst.setString(40, objAdmMedico.getQualMedicacaoUsa());
            pst.setString(41, objAdmMedico.getOutrasAlergias());
            pst.setString(42, objAdmMedico.getQuaisOutrasAlergias());
            pst.setString(43, objAdmMedico.getDiagnostico());
            pst.setInt(44, objAdmMedico.getTipoDiagnostico());
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
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ADMISSAO_MEDICA_ADICIONAL WHERE IdAdmADI='" + objAdmMedico.getIdLanc() + "'");
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
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ADMISSAO_MEDICA_ADICIONAL SET StatusLanc=? WHERE IdAdmADI='" + objAdmMedico.getIdLanc() + "'");
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
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE NomeInternoCrc='" + desc + "' "
                    + "AND IdInternoCrc='" + codigo + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível pesquisar o interno.\nERRO: " + ex);
        }
    }
}
