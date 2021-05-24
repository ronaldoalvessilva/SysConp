/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ParametrosCrc;
import static gestor.Visao.TelaParamentrosSistema.pCODIGO_registro;
import static gestor.Visao.TelaParamentrosSistema.pCODIGO_parametro;
import static gestor.Visao.TelaParamentrosSistema.pCODIGO_PESQUISA_modulo;
import static gestor.Visao.TelaParamentrosSistema.pCODIGO_PESQUISA_tela;
import static gestor.Visao.TelaParamentrosSistema.pRESPOSTA_gravado;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static gestor.Visao.TelaParamentrosSistema.jComboBoxTelaImplementacao;
import static gestor.Visao.TelaParamentrosSistema.jComboBoxModuloImplementacao;
import static gestor.Visao.TelaParamentrosSistema.pCOD_mod;
import static gestor.Visao.TelaParamentrosSistema.pCOD_tel;
import static gestor.Visao.TelaParamentrosSistema.pMOD;
import static gestor.Visao.TelaParamentrosSistema.pTELA;
import static gestor.Visao.TelaPesquisaModuloTela_CONF.pMODp;
import static gestor.Visao.TelaPesquisaModuloTela_CONF.pTELAp;

/**
 *
 * @author ronaldo
 */
public class ControleParamentrosCrc {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ParametrosCrc objParCrc = new ParametrosCrc();

    Integer pCODIGO_modulo = 0;
    Integer pCODIGO_tela = 0;

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
                    + "SistemaManutencao=?,BiometriaEF=?,PopulacaoAutomatica=?,FecharSistema=?,MaioridadePenal=?,ControlaMP=? WHERE IdPar='" + objParCrc.getIdPar() + "'");
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
            pst.setString(77, objParCrc.getGeraPopulacao());
            pst.setString(78, objParCrc.getFecharSistema());
            pst.setInt(79, objParCrc.getMaioridadePenal());
            pst.setString(80, objParCrc.getControlaMP());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objParCrc;
    }

    public ParametrosCrc incluirImp(ParametrosCrc objParCrc) {
        pBUSCAR_modulo(objParCrc.getNomeModulo());
        pBUSCAR_tela(objParCrc.getNomeTela());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO IMPLEMENTACAO_SISTEMA (IdModulo,IdTelas,IdPar,Habilitar) VALUES(?,?,?,?) ");
            pst.setInt(1, pCODIGO_modulo);
            pst.setInt(2, pCODIGO_tela);
            pst.setInt(3, objParCrc.getIdPar());
            pst.setString(4, objParCrc.getHabilitarImp());
            pst.executeUpdate();
            pRESPOSTA_gravado = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_gravado = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objParCrc;
    }

    public ParametrosCrc alterarImp(ParametrosCrc objParCrc) {
        pBUSCAR_modulo(objParCrc.getNomeModulo());
        pBUSCAR_tela(objParCrc.getNomeTela());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE IMPLEMENTACAO_SISTEMA SET IdModulo=?,IdTelas=?,Habilitar=? WHERE IdImp='" + objParCrc.getIdImp() + "'");
            pst.setInt(1, pCODIGO_modulo);
            pst.setInt(2, pCODIGO_tela);
            pst.setString(3, objParCrc.getHabilitarImp());
            pst.executeUpdate();
            pRESPOSTA_gravado = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_gravado = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objParCrc;
    }

    public ParametrosCrc excluirImp(ParametrosCrc objParCrc) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM IMPLEMENTACAO_SISTEMA "
                    + "WHERE IdImp='" + objParCrc.getIdImp() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objParCrc;
    }

    public void pBUSCAR_modulo(String pDESCRICAO_modulo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM MODULOS "
                    + "WHERE NomeModulo='" + pDESCRICAO_modulo + "'");
            conecta.rs.first();
            pCODIGO_modulo = conecta.rs.getInt("IdModulo");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível pesquisar o módulo.\nERRO: " + ex);
        }
        conecta.desconecta();
    }

    public void pBUSCAR_tela(String pDESCRICAO_tela) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + pDESCRICAO_tela + "'");
            conecta.rs.first();
            pCODIGO_tela = conecta.rs.getInt("IdTelas");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível pesquisar o módulo.\nERRO: " + ex);
        }
        conecta.desconecta();
    }

    public List<ParametrosCrc> read() throws Exception {
        conecta.abrirConexao();
        List<ParametrosCrc> listaTelas = new ArrayList<ParametrosCrc>();
        try {
            conecta.executaSQL("SELECT IdImp, "
                    + "IMPLEMENTACAO_SISTEMA.IdModulo, "
                    + "IMPLEMENTACAO_SISTEMA.IdTelas, "
                    + "TELAS.NomeTela, "
                    + "MODULOS.NomeModulo, "
                    + "IMPLEMENTACAO_SISTEMA.IdPar, "
                    + "IMPLEMENTACAO_SISTEMA.Habilitar "
                    + "FROM IMPLEMENTACAO_SISTEMA "
                    + "INNER JOIN MODULOS "
                    + "ON IMPLEMENTACAO_SISTEMA.IdModulo=MODULOS.IdModulo "
                    + "INNER JOIN TELAS "
                    + "ON IMPLEMENTACAO_SISTEMA.IdTelas=TELAS.IdTelas "
                    + "INNER JOIN PARAMETROSCRC "
                    + "ON IMPLEMENTACAO_SISTEMA.IdPar=PARAMETROSCRC.IdPar "
                    + "WHERE IMPLEMENTACAO_SISTEMA.IdPar='" + pCODIGO_parametro + "'");
            while (conecta.rs.next()) {
                ParametrosCrc pDigital = new ParametrosCrc();
                pDigital.setIdImp(conecta.rs.getInt("IdImp"));
                pDigital.setIdPar(conecta.rs.getInt("IdPar"));
                pDigital.setIdModulo(conecta.rs.getInt("IdModulo"));
                pDigital.setNomeModulo(conecta.rs.getString("NomeModulo"));
                pDigital.setIdTelas(conecta.rs.getInt("IdTelas"));
                pDigital.setNomeTela(conecta.rs.getString("NomeTela"));
                pDigital.setHabilitarImp(conecta.rs.getString("Habilitar"));
                listaTelas.add(pDigital);
            }
            return listaTelas;
        } catch (SQLException ex) {
            Logger.getLogger(ControleParamentrosCrc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public ParametrosCrc pPESQUISAR_registro(ParametrosCrc objParCrc) {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT IdImp, "
                    + "IMPLEMENTACAO_SISTEMA.IdModulo, "
                    + "IMPLEMENTACAO_SISTEMA.IdTelas, "
                    + "TELAS.NomeTela, "
                    + "MODULOS.NomeModulo, "
                    + "IMPLEMENTACAO_SISTEMA.IdPar, "
                    + "IMPLEMENTACAO_SISTEMA.Habilitar "
                    + "FROM IMPLEMENTACAO_SISTEMA "
                    + "INNER JOIN MODULOS "
                    + "ON IMPLEMENTACAO_SISTEMA.IdModulo=MODULOS.IdModulo "
                    + "INNER JOIN TELAS "
                    + "ON IMPLEMENTACAO_SISTEMA.IdTelas=TELAS.IdTelas "
                    + "INNER JOIN PARAMETROSCRC "
                    + "ON IMPLEMENTACAO_SISTEMA.IdPar=PARAMETROSCRC.IdPar "
                    + "WHERE TELAS.NomeTela='" + pMOD + "' "
                    + "AND MODULOS.NomeModulo='" + pTELA + "'");
            conecta.rs.first();
            pCODIGO_registro = conecta.rs.getInt("IdImp");
            objParCrc.setHabilitarImp(conecta.rs.getString("Habilitar"));
            objParCrc.setIdModulo(conecta.rs.getInt("IdModulo"));
            objParCrc.setNomeModulo(conecta.rs.getString("NomeModulo"));
            objParCrc.setIdTelas(conecta.rs.getInt("IdTelas"));
            objParCrc.setNomeTela(conecta.rs.getString("NomeTela"));
        } catch (SQLException ex) {
        }
        conecta.desconecta();
        return objParCrc;
    }

    public ParametrosCrc pPESQUISAR_modulo(ParametrosCrc objParCrc) {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdModulo "
                    + "FROM MODULOS "
                    + "WHERE NomeModulo='" + jComboBoxModuloImplementacao.getSelectedItem() + "' ");
            conecta.rs.first();
            pCODIGO_PESQUISA_modulo = conecta.rs.getInt("IdModulo");
        } catch (SQLException ex) {
        }
        conecta.desconecta();
        return objParCrc;
    }

    public ParametrosCrc pPESQUISAR_tela(ParametrosCrc objParCrc) {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdTelas "
                    + "FROM TELAS "
                    + "WHERE NomeTela='" + jComboBoxTelaImplementacao.getSelectedItem() + "' ");
            conecta.rs.first();
            pCODIGO_PESQUISA_tela = conecta.rs.getInt("IdTelas");
        } catch (SQLException ex) {
        }
        conecta.desconecta();
        return objParCrc;
    }
    
    public ParametrosCrc pPESQUISAR_REGISTRO_selecionado(ParametrosCrc objParCrc) {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT IdImp, "
                    + "IMPLEMENTACAO_SISTEMA.IdModulo, "
                    + "IMPLEMENTACAO_SISTEMA.IdTelas, "
                    + "TELAS.NomeTela, "
                    + "MODULOS.NomeModulo, "
                    + "IMPLEMENTACAO_SISTEMA.IdPar, "
                    + "IMPLEMENTACAO_SISTEMA.Habilitar "
                    + "FROM IMPLEMENTACAO_SISTEMA "
                    + "INNER JOIN MODULOS "
                    + "ON IMPLEMENTACAO_SISTEMA.IdModulo=MODULOS.IdModulo "
                    + "INNER JOIN TELAS "
                    + "ON IMPLEMENTACAO_SISTEMA.IdTelas=TELAS.IdTelas "
                    + "INNER JOIN PARAMETROSCRC "
                    + "ON IMPLEMENTACAO_SISTEMA.IdPar=PARAMETROSCRC.IdPar "
                    + "WHERE TELAS.NomeTela='" + pMODp + "' "
                    + "AND MODULOS.NomeModulo='" + pTELAp + "'");
            conecta.rs.first();
            pCODIGO_registro = conecta.rs.getInt("IdImp");
            objParCrc.setHabilitarImp(conecta.rs.getString("Habilitar"));
            objParCrc.setIdModulo(conecta.rs.getInt("IdModulo"));
            objParCrc.setNomeModulo(conecta.rs.getString("NomeModulo"));
            objParCrc.setIdTelas(conecta.rs.getInt("IdTelas"));
            objParCrc.setNomeTela(conecta.rs.getString("NomeTela"));
        } catch (SQLException ex) {
        }
        conecta.desconecta();
        return objParCrc;
    }
}
