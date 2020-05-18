/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ParametrosCrc;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleParamentrosCrc {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ParametrosCrc objParCrc = new ParametrosCrc();

    public ParametrosCrc alterarParametrosCrc(ParametrosCrc objParCrc) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PARAMETROSCRC SET QtdDias=?,QtdHoras=?,UsuarioAutorizado=?,RetornosPortaria=?,EntradasPortaria=?,UsuarioUp=?,DataUp=?,HorarioUp=?,"
                    + "DocAudiencia=?,DocTrans=?,DocSaidaTmp=?,DocLivraPro=?,ValAudiencia=?,Valtrans=?,ValSaidaTmp=?,ValLivraPro=?,DocPro=?,DocAlvara=?,ValPro=?,ValAlvara=?,PopulacaoBgp=?,LocacaoBgp=?,"
                    + "TransferenciaBgp=?,PavilhaoCelaBgp=?,PopulacaoBpa=?,LocacaoBpa=?,TransferenciaBpa=?,PavilhaoCelaBpa=?,CaminhoImagemServicoSocial=?,CaminhoImagemCRCInterno=?,LocalFotosAdvogados=?,"
                    + "LocalFotoVisitasDiversas=?,LocalFotosOficialJustica=?,LocalFotosVisitasInternos=?,LocalFotosInternos=?,LocalFotosColaboradores=?,CaminhoImagemColaboradores=?,BiometriaMedicos=?,"
                    + "BiometriaEnfermeiros=?,BiometriaTecnicos=?,CarcereFem=?,LocalPDF_PI=?,LocalPDF_PE=?,LocalPDF_B1=?,LocalPDF_B2=?,CaminhoExecutavel=?,DataVersao=?,NumeroVersao=?,PreLocacaoB1=?,"
                    + "PreLocacaoB2=?,HabilitarAlertaVisitasBaseI=?,HabilitarAlertaVisitasBaseII=?,NomeColaboradorPRI=?,NomeColaboradorSEG=?,AtendInterSocial=?,LigacaoTelSocial=?,AtendimentoBioPSI=?,"
                    + "AvaliacaoBioPSI=?,AdmissaoJuridico=?,AdmissaoTO=?,AdmissaoOdonto=?,NomeColaboradorCRC=?,NomeColaboradorCRCSEG=?,BiometriaPeda=?,NomeColaboradorTER=?,NomeColaboradorQUA=?,"
                    + "NomeColaboradorQUI=?,TipoServidor=?,TipoBancoDados=?,NomeColaboradorLiberaUm=?,NomeColaboradorLiberaDois=?,NomeColaboradorEncerraUm=?,NomeColaboradorEncerraDois=?,PagamentoKit=?,"
                    + "SistemaManutencao=?,BiometriaEF=? WHERE IdPar='" + objParCrc.getIdPar() + "'");
            pst.setInt(1, objParCrc.getQtdDias());
            pst.setString(2, objParCrc.getQtdHoras());
            pst.setString(3, objParCrc.getUsuarioAutorizado());
            pst.setString(4, objParCrc.getRegRetornoPortaria());
            pst.setString(5, objParCrc.getRegEntradaPortaria());
            pst.setString(6, objParCrc.getUsuariosUp());
            pst.setString(7, objParCrc.getDataUp());
            pst.setString(8, objParCrc.getHorarioUp());
            pst.setString(9, objParCrc.getDocAudiencia());
            pst.setString(10, objParCrc.getDocTrans());
            pst.setString(11, objParCrc.getDocSaidaTmp());
            pst.setString(12, objParCrc.getDocLivraPro());
            pst.setString(13, objParCrc.getValAudiencia());
            pst.setString(14, objParCrc.getValTrans());
            pst.setString(15, objParCrc.getValSaidaTmp());
            pst.setString(16, objParCrc.getValLivraPro());
            pst.setString(17, objParCrc.getDocPro());
            pst.setString(18, objParCrc.getDocAlvara());
            pst.setString(19, objParCrc.getValPro());
            pst.setString(20, objParCrc.getValAlvara());
            pst.setString(21, objParCrc.getPopulacaoBgp());
            pst.setString(22, objParCrc.getLocacaoBgp());
            pst.setString(23, objParCrc.getTransferenciaBgp());
            pst.setString(24, objParCrc.getPavilhaoCelas());
            pst.setString(25, objParCrc.getPopulacaoBpa());
            pst.setString(26, objParCrc.getLocacaoBpa());
            pst.setString(27, objParCrc.getTransferenciaBpa());
            pst.setString(28, objParCrc.getPavilhaoCelasBpa());
            pst.setString(29, objParCrc.getCaminhoImagemSS());
            pst.setString(30, objParCrc.getCaminhoImagemCrc());
            pst.setString(31, objParCrc.getLocalFotoAdvogado());
            pst.setString(32, objParCrc.getLocalFotoVisitasDiversas());
            pst.setString(33, objParCrc.getLocalFotoOficial());
            pst.setString(34, objParCrc.getLocalFotoVisitasInternos());
            pst.setString(35, objParCrc.getLocalFotoInternos());
            pst.setString(36, objParCrc.getLocalFotoColaboradores());
            pst.setString(37, objParCrc.getCaminhoImagemFunc());
            pst.setString(38, objParCrc.getBiometriaMedicos());
            pst.setString(39, objParCrc.getBiometriaEnfermerios());
            pst.setString(40, objParCrc.getBiometriaTecnicos());
            pst.setString(41, objParCrc.getCarcereFem());
            pst.setString(42, objParCrc.getLocalPDF_PI());
            pst.setString(43, objParCrc.getLocalPDF_PE());
            pst.setString(44, objParCrc.getLocalPDF_B1());
            pst.setString(45, objParCrc.getLocalPDF_B2());
            pst.setString(46, objParCrc.getCaminhoAtualizaSis());
            if (objParCrc.getDataVersao() != null) {
                pst.setTimestamp(47, new java.sql.Timestamp(objParCrc.getDataVersao().getTime()));
            } else {
                pst.setTimestamp(47, null);
            }
            pst.setString(48, objParCrc.getNumeroVersao());
            pst.setString(49, objParCrc.getPreLocacaoB1());
            pst.setString(50, objParCrc.getPreLocacaoB2());
            pst.setString(51, objParCrc.getpHabilitaBaseI());
            pst.setString(52, objParCrc.getpHabilitaBaseII());
            pst.setString(53, objParCrc.getNomeColaboradorPRI());
            pst.setString(54, objParCrc.getNomeColaboradorSEG());
            pst.setString(55, objParCrc.getpHabilitaAtendSS());
            pst.setString(56, objParCrc.getpHabilitaTele());
            pst.setString(57, objParCrc.getAtendimentoBioPSI());
            pst.setString(58, objParCrc.getAvaliacaoBioPSI());
            pst.setString(59, objParCrc.getAdimissaoJuridico());
            pst.setString(60, objParCrc.getAdmissaoTO());
            pst.setString(61, objParCrc.getAdmissaoOdonto());
            pst.setString(62, objParCrc.getNomeColaboradorCRC());
            pst.setString(63, objParCrc.getNomeColaboradorCRCSEG());
            pst.setString(64, objParCrc.getpHabilitaPEDA());
            pst.setString(65, objParCrc.getNomeColaboradorTER());
            pst.setString(66, objParCrc.getNomeColaboradorQUA());
            pst.setString(67, objParCrc.getNomeColaboradorQUI());
            pst.setString(68, objParCrc.getTipoServidor());
            pst.setString(69, objParCrc.getTipoBanco());
            pst.setString(70, objParCrc.getNomeLiberadorAG0());
            pst.setString(71, objParCrc.getNomeLiberadorAG1());
            pst.setString(72, objParCrc.getNomeEncerradorAG0());
            pst.setString(73, objParCrc.getNomeEncerradorAG1());
            pst.setString(74, objParCrc.getPagamentoKit());
            pst.setString(75, objParCrc.getSistemaManutencao());
            pst.setString(76, objParCrc.getBiometriaEF());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objParCrc;
    }
}
