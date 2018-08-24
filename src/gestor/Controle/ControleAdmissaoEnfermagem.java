/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AdmissaoEnfermagem;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleAdmissaoEnfermagem {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AdmissaoEnfermagem objAdmEnfermagem = new AdmissaoEnfermagem();
    int codInterno;

    public AdmissaoEnfermagem incluirAdmissaoEnfermagem(AdmissaoEnfermagem objAdmEnfermagem) {
        buscarInterno(objAdmEnfermagem.getNomeInterno(), objAdmEnfermagem.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ADMISSAOENFERMEIRA (StatusLanc,DataLanc,IdInternoCrc,EstadoEmocional,SonoRepouso,NivelConsciencia,PressaoArterial,Hemograma,Temperatura,FrequenciaRespiratoria, "
                    + "Peso,FrequenciaCardiaca,UsaMedicamentos,QualMedicacao,Locomocao,AcuidadeVisual,AcuidadeAuditiva,FuncaoMotora,QualFuncaoMotora,FalaLinguagem,"
                    + "QualFala,Pele,Mucosa,TipoPele,Localizacao,Cabelos,Boca,FuncaoRespiratoria,Torax,FuncaoIntestinal,DiasConstipado,Abdome,"
                    + "FuncaoVesical,Genitalia,QualGenitalia,Vacinado,QuaisVacinas,Vdrl,HepatiteC,HepatiteB,Hiv,Cirurgias,QuaisCirurgias,UsuarioDrogas,QuaisDrogas,"
                    + "PortadorDoenca,QuaisDoencas,Alergias,QuaisAlergias,Observacao,UsuarioInsert,DataInsert,HorarioInsert,Sifilis,Diabetes,Hipertensao,Tuberculose) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objAdmEnfermagem.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objAdmEnfermagem.getDataLanc().getTime()));
            pst.setInt(3, codInterno);
            pst.setInt(4, objAdmEnfermagem.getEstadoEmocional());
            pst.setInt(5, objAdmEnfermagem.getSonoRepouso());
            pst.setInt(6, objAdmEnfermagem.getNivelConciencia());
            pst.setString(7, objAdmEnfermagem.getPressaoArterial());
            pst.setString(8, objAdmEnfermagem.getHemograma());
            pst.setString(9, objAdmEnfermagem.getTemperatura());
            pst.setString(10, objAdmEnfermagem.getFrequenciaRespitatoria());
            pst.setString(11, objAdmEnfermagem.getPeso());
            pst.setString(12, objAdmEnfermagem.getFrequenciaCardiaca());
            pst.setString(13, objAdmEnfermagem.getUsaMedicamentos());
            pst.setString(14, objAdmEnfermagem.getQualMedicacao());
            pst.setInt(15, objAdmEnfermagem.getLocomocao());
            pst.setInt(16, objAdmEnfermagem.getAcuidadeVisual());
            pst.setInt(17, objAdmEnfermagem.getAcuidadeAuditiva());
            pst.setInt(18, objAdmEnfermagem.getFuncaoMotora());
            pst.setString(19, objAdmEnfermagem.getQualFuncaoMotora());
            pst.setInt(20, objAdmEnfermagem.getFalaLinguagem());
            pst.setString(21, objAdmEnfermagem.getQualFala());
            pst.setInt(22, objAdmEnfermagem.getPele());
            pst.setInt(23, objAdmEnfermagem.getMucosa());
            pst.setString(24, objAdmEnfermagem.getTipoPele());
            pst.setString(25, objAdmEnfermagem.getLocalizacao());
            pst.setInt(26, objAdmEnfermagem.getCabelos());
            pst.setInt(27, objAdmEnfermagem.getBoca());
            pst.setInt(28, objAdmEnfermagem.getFuncaoRespiratoria());
            pst.setInt(29, objAdmEnfermagem.getTorax());
            pst.setInt(30, objAdmEnfermagem.getFuncaoIntestinal());
            pst.setString(31, objAdmEnfermagem.getDiasConstipado());
            pst.setInt(32, objAdmEnfermagem.getAbdome());
            pst.setInt(33, objAdmEnfermagem.getFuncaoVesical());
            pst.setInt(34, objAdmEnfermagem.getGenitalia());
            pst.setString(35, objAdmEnfermagem.getQualGenitalia());
            pst.setString(36, objAdmEnfermagem.getVacinado());
            pst.setString(37, objAdmEnfermagem.getQuaisVacinas());
            pst.setString(38, objAdmEnfermagem.getVdrl());
            pst.setString(39, objAdmEnfermagem.getHepatiteC());
            pst.setString(40, objAdmEnfermagem.getHepatiteB());
            pst.setString(41, objAdmEnfermagem.getHiv());
            pst.setString(42, objAdmEnfermagem.getCirurgias());
            pst.setString(43, objAdmEnfermagem.getQuaisCirurgias());
            pst.setString(44, objAdmEnfermagem.getUsuarioDrogas());
            pst.setString(45, objAdmEnfermagem.getQuaisDrogas());
            pst.setString(46, objAdmEnfermagem.getPortadorDoenca());
            pst.setString(47, objAdmEnfermagem.getQuaisDoencas());
            pst.setString(48, objAdmEnfermagem.getAlergias());
            pst.setString(49, objAdmEnfermagem.getQuaisAlergias());
            pst.setString(50, objAdmEnfermagem.getObservacao());
            pst.setString(51, objAdmEnfermagem.getUsuarioInsert());
            pst.setString(52, objAdmEnfermagem.getDataInsert());
            pst.setString(53, objAdmEnfermagem.getHoraInsert());
            pst.setString(54, objAdmEnfermagem.getSifilis());
            pst.setString(55, objAdmEnfermagem.getDiabetes());
            pst.setString(56, objAdmEnfermagem.getHipertensao());
            pst.setString(57, objAdmEnfermagem.getTuberculose());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAdmEnfermagem;
    }

    public AdmissaoEnfermagem alterarAdmissaoEnfermagem(AdmissaoEnfermagem objAdmEnfermagem) {
        buscarInterno(objAdmEnfermagem.getNomeInterno(), objAdmEnfermagem.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ADMISSAOENFERMEIRA SET StatusLanc=?,DataLanc=?,IdInternoCrc=?,EstadoEmocional=?,SonoRepouso=?,NivelConsciencia=?,PressaoArterial=?,Hemograma=?,Temperatura=?,FrequenciaRespiratoria=?, "
                    + "Peso=?,FrequenciaCardiaca=?,UsaMedicamentos=?,QualMedicacao=?,Locomocao=?,AcuidadeVisual=?,AcuidadeAuditiva=?,FuncaoMotora=?,QualFuncaoMotora=?,FalaLinguagem=?,"
                    + "QualFala=?,Pele=?,Mucosa=?,TipoPele=?,Localizacao=?,Cabelos=?,Boca=?,FuncaoRespiratoria=?,Torax=?,FuncaoIntestinal=?,DiasConstipado=?,Abdome=?,"
                    + "FuncaoVesical=?,Genitalia=?,QualGenitalia=?,Vacinado=?,QuaisVacinas=?,Vdrl=?,HepatiteC=?,HepatiteB=?,Hiv=?,Cirurgias=?,QuaisCirurgias=?,UsuarioDrogas=?,QuaisDrogas=?,"
                    + "PortadorDoenca=?,QuaisDoencas=?,Alergias=?,QuaisAlergias=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=?,Sifilis=?,Diabetes=?,Hipertensao=?,Tuberculose=? WHERE IdLanc='" + objAdmEnfermagem.getIdLanc() + "'");
            pst.setString(1, objAdmEnfermagem.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objAdmEnfermagem.getDataLanc().getTime()));
            pst.setInt(3, codInterno);
            pst.setInt(4, objAdmEnfermagem.getEstadoEmocional());
            pst.setInt(5, objAdmEnfermagem.getSonoRepouso());
            pst.setInt(6, objAdmEnfermagem.getNivelConciencia());
            pst.setString(7, objAdmEnfermagem.getPressaoArterial());
            pst.setString(8, objAdmEnfermagem.getHemograma());
            pst.setString(9, objAdmEnfermagem.getTemperatura());
            pst.setString(10, objAdmEnfermagem.getFrequenciaRespitatoria());
            pst.setString(11, objAdmEnfermagem.getPeso());
            pst.setString(12, objAdmEnfermagem.getFrequenciaCardiaca());
            pst.setString(13, objAdmEnfermagem.getUsaMedicamentos());
            pst.setString(14, objAdmEnfermagem.getQualMedicacao());
            pst.setInt(15, objAdmEnfermagem.getLocomocao());
            pst.setInt(16, objAdmEnfermagem.getAcuidadeVisual());
            pst.setInt(17, objAdmEnfermagem.getAcuidadeAuditiva());
            pst.setInt(18, objAdmEnfermagem.getFuncaoMotora());
            pst.setString(19, objAdmEnfermagem.getQualFuncaoMotora());
            pst.setInt(20, objAdmEnfermagem.getFalaLinguagem());
            pst.setString(21, objAdmEnfermagem.getQualFala());
           pst.setInt(22, objAdmEnfermagem.getPele());
            pst.setInt(23, objAdmEnfermagem.getMucosa());
            pst.setString(24, objAdmEnfermagem.getTipoPele());
            pst.setString(25, objAdmEnfermagem.getLocalizacao());
            pst.setInt(26, objAdmEnfermagem.getCabelos());
            pst.setInt(27, objAdmEnfermagem.getBoca());
            pst.setInt(28, objAdmEnfermagem.getFuncaoRespiratoria());
            pst.setInt(29, objAdmEnfermagem.getTorax());
            pst.setInt(30, objAdmEnfermagem.getFuncaoIntestinal());
            pst.setString(31, objAdmEnfermagem.getDiasConstipado());
            pst.setInt(32, objAdmEnfermagem.getAbdome());
            pst.setInt(33, objAdmEnfermagem.getFuncaoVesical());
            pst.setInt(34, objAdmEnfermagem.getGenitalia());
            pst.setString(35, objAdmEnfermagem.getQualGenitalia());
            pst.setString(36, objAdmEnfermagem.getVacinado());
            pst.setString(37, objAdmEnfermagem.getQuaisVacinas());
            pst.setString(38, objAdmEnfermagem.getVdrl());
            pst.setString(39, objAdmEnfermagem.getHepatiteC());
            pst.setString(40, objAdmEnfermagem.getHepatiteB());
            pst.setString(41, objAdmEnfermagem.getHiv());
            pst.setString(42, objAdmEnfermagem.getCirurgias());
            pst.setString(43, objAdmEnfermagem.getQuaisCirurgias());
            pst.setString(44, objAdmEnfermagem.getUsuarioDrogas());
            pst.setString(45, objAdmEnfermagem.getQuaisDrogas());
            pst.setString(46, objAdmEnfermagem.getPortadorDoenca());
            pst.setString(47, objAdmEnfermagem.getQuaisDoencas());
            pst.setString(48, objAdmEnfermagem.getAlergias());
            pst.setString(49, objAdmEnfermagem.getQuaisAlergias());
            pst.setString(50, objAdmEnfermagem.getObservacao());
            pst.setString(51, objAdmEnfermagem.getUsuarioUp());
            pst.setString(52, objAdmEnfermagem.getDataUp());
            pst.setString(53, objAdmEnfermagem.getHoraUp());
            pst.setString(54, objAdmEnfermagem.getSifilis());
            pst.setString(55, objAdmEnfermagem.getDiabetes());
            pst.setString(56, objAdmEnfermagem.getHipertensao());
            pst.setString(57, objAdmEnfermagem.getTuberculose());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAdmEnfermagem;
    }

    public AdmissaoEnfermagem excluiAdmissaoEnfermagem(AdmissaoEnfermagem objAdmEnfermagem) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ADMISSAOENFERMEIRA WHERE IdLanc='" + objAdmEnfermagem.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAdmEnfermagem;
    }

    public AdmissaoEnfermagem finalizarAdmissaoEnfermagem(AdmissaoEnfermagem objAdmEnfermagem) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ADMISSAOENFERMEIRA SET StatusLanc=? WHERE IdLanc='" + objAdmEnfermagem.getIdLanc() + "'");
            pst.setString(1, objAdmEnfermagem.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAdmEnfermagem;
    }

    public void buscarInterno(String desc, int codigoInterno) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + desc + "'AND IdInternoCrc='" + codigoInterno + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível pesquisar o interno.\nERRO: " + ex);
        }
    }
}
