/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleCCGF;
import gestor.Controle.ControleEAPI1;
import gestor.Controle.ControleEAPI2;
import gestor.Controle.ControleEvolucaoPAI_NOVO;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControlePAI_DEME;
import gestor.Controle.ControlePAI_DJ;
import gestor.Controle.ControlePAI_DPTL;
import gestor.Controle.ControlePAI_DS;
import gestor.Controle.ControlePAI_NOVO;
import gestor.Controle.ControleSocial2PsicoSocialPAI_NOVO;
import gestor.Controle.ControleSocial2VisitaIntimaPsicosocial_PAI_NOVO;
import gestor.Controle.ControleSocial2VisitaPsicosocialPAI_NOVO;
import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.LimiteDigitosAlfa;
import gestor.Dao.LimiteDigitosNum;
import gestor.Dao.ModeloTabela;
import gestor.Modelo.CCGF_PAI;
import gestor.Modelo.EvolucaoPAI;
import gestor.Modelo.FichaCadastroPaiEapi1;
import gestor.Modelo.FichaCadastroPaiEapi2;
import gestor.Modelo.FichaDeme;
import gestor.Modelo.FichaPAI_DJ;
import gestor.Modelo.FichaPAI_DPTL;
import gestor.Modelo.FichaPAI_DS;
import gestor.Modelo.LogSistema;
import gestor.Modelo.PaiPsicoSocialNovo;
import gestor.Modelo.Social2FamiliarPsicosocial;
import gestor.Modelo.Social2PaiPsicoSocial;
import static gestor.Visao.TelaLoginSenha.descricaoUnidade;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloEnfermaria.nomeModuloENFER;
import static gestor.Visao.TelaModuloJuridico.nomeModuloJURI;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaModuloServicoSocial.codAbrir;
import static gestor.Visao.TelaModuloServicoSocial.codAlterar;
import static gestor.Visao.TelaModuloServicoSocial.codConsultar;
import static gestor.Visao.TelaModuloServicoSocial.codExcluir;
import static gestor.Visao.TelaModuloServicoSocial.codGravar;
import static gestor.Visao.TelaModuloServicoSocial.codIncluir;
import static gestor.Visao.TelaModuloServicoSocial.codUserAcesso;
import static gestor.Visao.TelaModuloServicoSocial.codigoGrupo;
import static gestor.Visao.TelaModuloServicoSocial.codigoUser;
import static gestor.Visao.TelaModuloServicoSocial.codigoUserGroup;
import static gestor.Visao.TelaModuloServicoSocial.nomeGrupo;
import static gestor.Visao.TelaModuloServicoSocial.nomeModuloSERV;
import static gestor.Visao.TelaModuloServicoSocial.nomeTela;
import static gestor.Visao.TelaModuloServicoSocial.telaPAISS;
import static gestor.Visao.TelaModuloServicoSocial.telaPaiCCGFFam_SS;
import static gestor.Visao.TelaModuloServicoSocial.telaPaiCCGFVisInt_SS;
import static gestor.Visao.TelaModuloServicoSocial.telaPaiCCGFVis_SS;
import static gestor.Visao.TelaModuloServicoSocial.telaPaiCCGF_SS;
import static gestor.Visao.TelaModuloServicoSocial.telaPaiDEME_SS;
import static gestor.Visao.TelaModuloServicoSocial.telaPaiDPTL_SS;
import static gestor.Visao.TelaModuloServicoSocial.telaPaiDJ_SS;
import static gestor.Visao.TelaModuloServicoSocial.telaPaiDS_SS;
import static gestor.Visao.TelaModuloServicoSocial.telaPaiEAPI1_SS;
import static gestor.Visao.TelaModuloServicoSocial.telaPaiEAPI2_SS;
import static gestor.Visao.TelaModuloServicoSocial.telaPaiEPAI_SS;
import static gestor.Visao.TelaModuloTerapiaOcupacional.nomeModuloTERA;
import java.awt.Color;
import java.awt.Image;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Currency;
import java.util.HashMap;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ronaldo.silva7
 */
// Inicio 14/07/2017 - as 09:15 hs
public class TelaPAI_NOVO extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    // MANUTENÇÃO
    PaiPsicoSocialNovo objPaiPsico = new PaiPsicoSocialNovo();
    ControlePAI_NOVO control = new ControlePAI_NOVO();
    // C.C.G.F.
    CCGF_PAI objCcgf = new CCGF_PAI();
    ControleCCGF controle = new ControleCCGF();
    //C.C.G.F.
    Social2PaiPsicoSocial objSocial2Pai = new Social2PaiPsicoSocial();
    ControleSocial2PsicoSocialPAI_NOVO controle2 = new ControleSocial2PsicoSocialPAI_NOVO();
    //C.C.G.F.
    Social2FamiliarPsicosocial objSocial2Vista = new Social2FamiliarPsicosocial();
    ControleSocial2VisitaPsicosocialPAI_NOVO controlVisita = new ControleSocial2VisitaPsicosocialPAI_NOVO();
    //C.C.G.F.
    ControleSocial2VisitaIntimaPsicosocial_PAI_NOVO controlVisitaIntima = new ControleSocial2VisitaIntimaPsicosocial_PAI_NOVO();
    //D.E.M.E
    FichaDeme objFichaDeme = new FichaDeme();
    ControlePAI_DEME controle3 = new ControlePAI_DEME();
    // D.P.T.L.
    FichaPAI_DPTL objFichaDPTL = new FichaPAI_DPTL();
    ControlePAI_DPTL controle4 = new ControlePAI_DPTL();
    // D.J.
    FichaPAI_DJ objFichaDJ = new FichaPAI_DJ();
    ControlePAI_DJ controle5 = new ControlePAI_DJ();
    //D.S.
    FichaPAI_DS objFichaDS = new FichaPAI_DS();
    ControlePAI_DS controle6 = new ControlePAI_DS();
    // E.A.P.I.-1
    FichaCadastroPaiEapi1 objEapi1 = new FichaCadastroPaiEapi1();
    ControleEAPI1 controle7 = new ControleEAPI1();
    // E.A.P.I.-2
    FichaCadastroPaiEapi2 objEapi2 = new FichaCadastroPaiEapi2();
    ControleEAPI2 controle8 = new ControleEAPI2();
    // EVOLUÇÃO
    EvolucaoPAI objEvolucaoPAI = new EvolucaoPAI();
    ControleEvolucaoPAI_NOVO controleEvo = new ControleEvolucaoPAI_NOVO();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    //
    String nomeModuloTela = "Serviço Social:P.A.I.:Manutenção";
    String nomeModuloTela1 = "Serviço Social:P.A.I.:C.C.G.F.";
    String nomeModuloTela2 = "Serviço Social:P.A.I.:C.C.G.F.:Familia";
    String nomeModuloTela3 = "Serviço Social:P.A.I.:C.C.G.F.:Visita";
    String nomeModuloTela4 = "Serviço Social:P.A.I.:C.C.G.F.:Visita Intima";
    String nomeModuloTela5 = "Serviço Social:P.A.I.:D.E.M.E.";
    String nomeModuloTela6 = "Serviço Social:P.A.I.:D.P.T.L.";
    String nomeModuloTela7 = "Serviço Social:P.A.I.:D.J.";
    String nomeModuloTela8 = "Serviço Social:P.A.I.:D.S.";
    String nomeModuloTela9 = "Serviço Social:P.A.I.:E.A.P.I.-1";
    String nomeModuloTela10 = "Serviço Social:P.A.I.:E.A.P.I.-2";
    String nomeModuloTela11 = "Serviço Social:P.A.I.:E-PAI";
    //
    String statusMov;
    String horaMov;
    String dataModFinal;
    //
    int acao;
    int flag;
    int count = 0;
    String dataInicial;
    String dataFinal, dataPAI;
    String caminho;
    // MANUTENÇÃO
    String codigoInternoPAI; // VERIFICAR SE O INTERNO JÁ FOI INCLUÍDO NO PAI. SÓ É PERMITIDO UM P.A.I. POR INTERNO.
    String nomeMaeInterno; // NOME DA MÃE DO INTERNO PARA NEGAR DUPLICIDADE DE INTERNO NO P.A.I  
    // C.C.G.F.
    int codigoSS1 = 0; // CÓDIGO SS1 PARA PODER ALTERAR O REGISTRO JA INCLUÍDO.
    int codigoPaiSS1 = 0; // CÓDIGO PARA VERIFICAR SE JÁ FOI INCLUÍDO O REGISTRO SS1, NÃO PERMITIR CADASTRAR MAIS DE UM
    int codigoInternoSS1; // CÓDIGO DO INTERNO PARA VERIFICAR SE JÁ FOI INCLUÍDO NO SS1
    int idSol2Visita, idSol2VisitaIntima = 0;
    // EVOLUÇÃO PAI    
    String dataEvolucaoPAI;
    String nomeUserRegistro;
    //
    int codigoVF = 0;
    int codigoVF1 = 0;
    int codigoVF2 = 0;
    // C.C.G.F.
    int idPaiCCGF = 0;
    int idPaiVF = 0;
    int idPaiVF1 = 0;
    int idPaiVF2 = 0;
    // D.E.M.E.
    int codigoPaiTOPED = 0;
    int codigoInternoTOPED = 0;
    int codTeraPed = 0;
    // D.P.T.L.
    int codigoPSI = 0;
    int codigoPaiPSI = 0;
    int codigoInternoPSI = 0;
    //
    float valorSalarial = 0;
    // D.J.
    int codigoDJ = 0;
    int codigoPaiDJ = 0;
    int codigoInternoDJ = 0;
    // D.S.
    int codigoSS3 = 0;
    int codigoPaiSS3 = 0;
    int codigoInternoSS3 = 0;
    //
    int tipoHanseniase = 0;
    int tipoDiabetes = 0;
    int tipoTuberculose = 0;
    int tipoHipertensao = 0;
    int tipoHepatites = 0;
    int tipoSifilis = 0;
    int tipoEscabiose = 0;
    int tipoHiv = 0;
    //
    int tipoDesanimo = 0;
    int tipoInsonia = 0;
    int tipoFaltaApetite = 0;
    int tipoIsolamentoSocial = 0;
    int tipoPensamentosSuicida = 0;
    int tipoAgressividade = 0;
    int tipoInquietacaoMotora = 0;
    int tipoOutros = 0;
    //
    int tipoAlcool = 0;
    int tipoMaconha = 0;
    int tipoCocaina = 0;
    int tipoCola = 0;
    int tipoCrack;
    int tipoInjetaveis = 0;
    int tipoOutrasDoencas = 0;
    //
    int tipoSudorese = 0;
    int tipoTremores = 0;
    int tipoFissura = 0;
    int tipoBocaSeca = 0;
    int tipoNauseas = 0;
    //
    int tipoDesejo = 0;
    int tipoNaoconseguir = 0;
    int tipoAumentoTolerancia = 0;
    //
    int tipoEnfermagem = 0;
    int tipoMedico = 0;
    int tipoPsiquiatrico = 0;
    int tipoPsicologico = 0;
    // E.A.P.I.1
    int codigoEAPI = 0;
    int codigoPaiEAPI = 0;
    int codigoInternoEAPI = 0;
    // E.A.P.I.2
    int codigoPaiEAPI2 = 0;
    int codigoInternoEAPI2 = 0;
    int codigoEAPI2 = 0;
    //
    String codigoPAI_CCGF = "";
    String codigoPAI_DEME = "";
    String codigoPAI_DPTL = "";
    String codigoPAI_DJ = "";
    String codigoPAI_DS = "";
    String codigoPAI_EAPI1 = "";
    String codigoPAI_EAPI2 = "";
    String codigoPAI_EVOL = "";
    //
    String pRelPAI = "";

    /**
     * Creates new form TelaPAI_NOVO
     */
    public static TelaPesquisarTecnico telaPesqTec;

    public TelaPAI_NOVO() {
        initComponents();
        corCampos();
        formatarCampos();
    }

    public void mostrarAssistentePsicologo() {
        telaPesqTec = new TelaPesquisarTecnico(this, true);
        telaPesqTec.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        jCodigoPesqPAI = new javax.swing.JTextField();
        jBtPesqCodigo = new javax.swing.JButton();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jDataInicial = new com.toedter.calendar.JDateChooser();
        jDataFinal = new com.toedter.calendar.JDateChooser();
        jBtPesqDataPAI = new javax.swing.JButton();
        jLabel64 = new javax.swing.JLabel();
        jNomeInternoPesquisa = new javax.swing.JTextField();
        jBtPesqNomeInternoPAI = new javax.swing.JButton();
        jCheckBoxTodosRegistros = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabelaPAI = new javax.swing.JTable();
        jPanel32 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jCodigoPAI = new javax.swing.JTextField();
        jComboBoxStatusPAI = new javax.swing.JComboBox();
        jDataPAI = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jDataAdmissao = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jUnidadePenal = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jMatriculaPenal = new javax.swing.JTextField();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jIdInternoPAI = new javax.swing.JTextField();
        jNomeInternoPAI = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jBtPesquisarInternoPAI = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jNomeMaeInternoPAI = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jNomePaiInternoPAI = new javax.swing.JTextField();
        jDataNascimentoPAI = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jIdadeInterno = new javax.swing.JFormattedTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jNaturalidadeInternoPAI = new javax.swing.JTextField();
        jComboBoxCorEtiniaInternoPAI = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        jMunicipioRegistrado = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jComboBoxDocumentoDelega = new javax.swing.JComboBox();
        jLabel21 = new javax.swing.JLabel();
        jTipoOrientacaoSexual = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jComboBoxOrientacaoSexual = new javax.swing.JComboBox();
        jLabel23 = new javax.swing.JLabel();
        jQualDocumento = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jQualDelegacia = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jComboBoxRegularizarDocumento = new javax.swing.JComboBox();
        jComboBoxTipoDocumento = new javax.swing.JComboBox();
        jPanel5 = new javax.swing.JPanel();
        jRGInternoPAI = new javax.swing.JTextField();
        jDataExpedicao = new com.toedter.calendar.JDateChooser();
        jCPFInternoPAI = new javax.swing.JTextField();
        jEmissor = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jCartaoSUSPAI = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jTituloEleitor = new javax.swing.JTextField();
        jZona = new javax.swing.JTextField();
        jSessao = new javax.swing.JTextField();
        jNIS = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jCTPS = new javax.swing.JTextField();
        jSerie = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jComboBoxEstadoCivil = new javax.swing.JComboBox();
        jLabel33 = new javax.swing.JLabel();
        jComboBoxReligiao = new javax.swing.JComboBox();
        jPanel9 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jEndereco = new javax.swing.JTextField();
        jComplemento = new javax.swing.JTextField();
        jReferencia = new javax.swing.JTextField();
        jBairro = new javax.swing.JTextField();
        jCidade = new javax.swing.JTextField();
        jComboBoxEstadoNaturalidade = new javax.swing.JComboBox();
        jLabel40 = new javax.swing.JLabel();
        jTelefone = new javax.swing.JFormattedTextField();
        jLabel41 = new javax.swing.JLabel();
        jTelefone1 = new javax.swing.JFormattedTextField();
        jLabel42 = new javax.swing.JLabel();
        jCelular = new javax.swing.JFormattedTextField();
        jPanel6 = new javax.swing.JPanel();
        jBtAuditoria = new javax.swing.JButton();
        jBtNovo = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jBtImpressaoPAI = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jComboBoxVinculoPAI = new javax.swing.JComboBox();
        jLabel122 = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        jBtSalvarFamiliar = new javax.swing.JButton();
        jBtCancelarFamiliar = new javax.swing.JButton();
        jBtExcluirFamiliar = new javax.swing.JButton();
        jIdFamiliarPAI = new javax.swing.JTextField();
        jLabel120 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTabelaFamiliarPAI = new javax.swing.JTable();
        jEnderecoTelefonePAI = new javax.swing.JTextField();
        jIdadeFamiliarPAI = new javax.swing.JTextField();
        jBtAuditoriaFamiliar = new javax.swing.JButton();
        jOcupacaoFamiliarPAI = new javax.swing.JTextField();
        jLabel125 = new javax.swing.JLabel();
        jNomeFamiliarPAI = new javax.swing.JTextField();
        jBtAlterarFamiliar = new javax.swing.JButton();
        jLabel124 = new javax.swing.JLabel();
        jBtNovoFamiliar = new javax.swing.JButton();
        jLabel121 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel12 = new javax.swing.JPanel();
        jBtAuditoriaSS = new javax.swing.JButton();
        jBtNovoSS = new javax.swing.JButton();
        jBtAlterarSS = new javax.swing.JButton();
        jBtExcluirSS = new javax.swing.JButton();
        jBtSalvarSS = new javax.swing.JButton();
        jBtCancelarSS = new javax.swing.JButton();
        jBtSairSS = new javax.swing.JButton();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel11 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jComboBoxTemFilhos = new javax.swing.JComboBox();
        jLabel44 = new javax.swing.JLabel();
        jQuantosFilhos = new javax.swing.JFormattedTextField();
        jLabel46 = new javax.swing.JLabel();
        jComboBoxReconhecerPaterna = new javax.swing.JComboBox();
        jLabel47 = new javax.swing.JLabel();
        jDadosPaternidade = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jComboBoxEstaoFilhos = new javax.swing.JComboBox();
        jLabel48 = new javax.swing.JLabel();
        jComboBoxNecessidaEspecial = new javax.swing.JComboBox();
        jLabel49 = new javax.swing.JLabel();
        jQualNecessidadeESP = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jComboBoxCRAS = new javax.swing.JComboBox();
        jComboBoxCREAS = new javax.swing.JComboBox();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jComboBoxRecebeBeneficio = new javax.swing.JComboBox();
        jLabel53 = new javax.swing.JLabel();
        jQuaisBeneficiosFamilia = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jComboBoxAntesBeneficio = new javax.swing.JComboBox();
        jLabel55 = new javax.swing.JLabel();
        jQuaisBeneficiosAntesPrisao = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jComboBoxNecessitaBeneficio = new javax.swing.JComboBox();
        jLabel57 = new javax.swing.JLabel();
        jNecessitaBeneficio = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        jComboBoxMoradia = new javax.swing.JComboBox();
        jLabel60 = new javax.swing.JLabel();
        jComboBoxModalidade = new javax.swing.JComboBox();
        jLabel65 = new javax.swing.JLabel();
        jComboBoxAbastecimento = new javax.swing.JComboBox();
        jLabel66 = new javax.swing.JLabel();
        jComboBoxEliminaDejetos = new javax.swing.JComboBox();
        jLabel68 = new javax.swing.JLabel();
        jComboBoxDescarte = new javax.swing.JComboBox();
        jLabel69 = new javax.swing.JLabel();
        jComboBoxFamiliaVulneraSocial = new javax.swing.JComboBox();
        jLabel70 = new javax.swing.JLabel();
        jComboBoxViveuRua = new javax.swing.JComboBox();
        jLabel71 = new javax.swing.JLabel();
        jQuantoTempo = new javax.swing.JFormattedTextField();
        jLabel72 = new javax.swing.JLabel();
        jMotivo = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        jComboBoxFamiliaDetido = new javax.swing.JComboBox();
        jLabel74 = new javax.swing.JLabel();
        jComboBoxRestabelecerVinculo = new javax.swing.JComboBox();
        jLabel75 = new javax.swing.JLabel();
        jComboBoxComoRestabelecer = new javax.swing.JComboBox();
        jPanel14 = new javax.swing.JPanel();
        jLabel129 = new javax.swing.JLabel();
        jNomeVisitaPAI = new javax.swing.JTextField();
        jParentescoPAI = new javax.swing.JTextField();
        jLabel134 = new javax.swing.JLabel();
        jBtPesqVisita = new javax.swing.JButton();
        jIdadeVisita = new javax.swing.JTextField();
        jOcupacaoVisita = new javax.swing.JTextField();
        jLabel126 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTabelaVisitas = new javax.swing.JTable();
        jLabel127 = new javax.swing.JLabel();
        jIdVisitaPAI = new javax.swing.JTextField();
        jBtCancelarVisita = new javax.swing.JButton();
        jBtExcluirVisita = new javax.swing.JButton();
        jBtSalvarVisita = new javax.swing.JButton();
        jBtNovaVisita = new javax.swing.JButton();
        jBtAlterarVisita = new javax.swing.JButton();
        jBtAuditoriaVisita = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTabelaVisitasIntimas = new javax.swing.JTable();
        jLabel130 = new javax.swing.JLabel();
        jIdadeVisitaIntima = new javax.swing.JTextField();
        jBtPesqVisitaIntima = new javax.swing.JButton();
        jIdVisitaIntima = new javax.swing.JTextField();
        jBtSalvarVisitaIntima = new javax.swing.JButton();
        jLabel133 = new javax.swing.JLabel();
        jBtCancelarVisitaIntima = new javax.swing.JButton();
        jLabel135 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        jOcupacaoVisitaIntima = new javax.swing.JTextField();
        jParentescoVisitaIntima = new javax.swing.JTextField();
        jBtAlterarVisitaIntima = new javax.swing.JButton();
        jBtExcluirVisitaIntima = new javax.swing.JButton();
        jBtAuditoriaVisitaIntima = new javax.swing.JButton();
        jBtNovaVisitaIntima = new javax.swing.JButton();
        jNomeVisitaIntima = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jBtAuditoriaTO = new javax.swing.JButton();
        jBtNovoTO = new javax.swing.JButton();
        jBtAlterarTO = new javax.swing.JButton();
        jBtExcluirTO = new javax.swing.JButton();
        jBtSalvarTO = new javax.swing.JButton();
        jBtCancelarTO = new javax.swing.JButton();
        jBtSairTO = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jLabel76 = new javax.swing.JLabel();
        jComboBoxNecessitaFamilia = new javax.swing.JComboBox();
        jLabel77 = new javax.swing.JLabel();
        jParaQuemFamilia = new javax.swing.JTextField();
        jLabel78 = new javax.swing.JLabel();
        jComboBoxEstaGravida = new javax.swing.JComboBox();
        jLabel79 = new javax.swing.JLabel();
        jComboBoxComprovacao = new javax.swing.JComboBox();
        jLabel80 = new javax.swing.JLabel();
        jComboBoxPreNatal = new javax.swing.JComboBox();
        jLabel81 = new javax.swing.JLabel();
        jOndePreNatal = new javax.swing.JTextField();
        jLabel82 = new javax.swing.JLabel();
        jComboBoxDestinoBebe = new javax.swing.JComboBox();
        jLabel83 = new javax.swing.JLabel();
        jComboBoxSuspeitaGravidez = new javax.swing.JComboBox();
        jLabel84 = new javax.swing.JLabel();
        jQuantosPartos = new javax.swing.JFormattedTextField();
        jLabel85 = new javax.swing.JLabel();
        jQuantosAbortos = new javax.swing.JFormattedTextField();
        jLabel86 = new javax.swing.JLabel();
        jQuantosPartosNornais = new javax.swing.JFormattedTextField();
        jLabel87 = new javax.swing.JLabel();
        jQuantasCesarianas = new javax.swing.JFormattedTextField();
        jLabel88 = new javax.swing.JLabel();
        jComboBoxContraceptivos = new javax.swing.JComboBox();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jComboBoxDemanda = new javax.swing.JComboBox();
        jLabel91 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jQualContraceptivos = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jQualDemanda = new javax.swing.JTextArea();
        jPanel19 = new javax.swing.JPanel();
        jLabel92 = new javax.swing.JLabel();
        jComboBoxInstrucao = new javax.swing.JComboBox();
        jLabel93 = new javax.swing.JLabel();
        jComboBoxEstudandoPreso = new javax.swing.JComboBox();
        jLabel94 = new javax.swing.JLabel();
        jComboBoxParticipouPrisional = new javax.swing.JComboBox();
        jLabel95 = new javax.swing.JLabel();
        jComboBoxGostariaPrisional = new javax.swing.JComboBox();
        jPanel16 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel96 = new javax.swing.JLabel();
        jProfissaoOcupacao = new javax.swing.JTextField();
        jLabel97 = new javax.swing.JLabel();
        jComboBoxTrabalhaDetido = new javax.swing.JComboBox();
        jLabel98 = new javax.swing.JLabel();
        jComboBoxDesempregado = new javax.swing.JComboBox();
        jLabel99 = new javax.swing.JLabel();
        jComboBoxCarteiraAssinada = new javax.swing.JComboBox();
        jLabel100 = new javax.swing.JLabel();
        jQuantoTempoCarteira = new javax.swing.JFormattedTextField();
        jLabel101 = new javax.swing.JLabel();
        jFaixaSalarial = new javax.swing.JFormattedTextField();
        jLabel102 = new javax.swing.JLabel();
        jComboBoxTemBeneficios = new javax.swing.JComboBox();
        jLabel103 = new javax.swing.JLabel();
        jQuemTemBeneficios = new javax.swing.JTextField();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jComboBoxDemandaReclusao = new javax.swing.JComboBox();
        jComboBoxDemandaDesemprego = new javax.swing.JComboBox();
        jLabel106 = new javax.swing.JLabel();
        jComboBoxPossuiRedimento = new javax.swing.JComboBox();
        jLabel107 = new javax.swing.JLabel();
        jQualRendimento = new javax.swing.JTextField();
        jLabel108 = new javax.swing.JLabel();
        jComboBoxExerceAtividade = new javax.swing.JComboBox();
        jLabel109 = new javax.swing.JLabel();
        jQualAtividadeExerce = new javax.swing.JTextField();
        jLabel110 = new javax.swing.JLabel();
        jComboBoxGeracaoRenda = new javax.swing.JComboBox();
        jLabel111 = new javax.swing.JLabel();
        jComboBoxAptidaoProfissional = new javax.swing.JComboBox();
        jLabel112 = new javax.swing.JLabel();
        jQualAptidao = new javax.swing.JTextField();
        jLabel113 = new javax.swing.JLabel();
        jComboBoxDemandaProfissional = new javax.swing.JComboBox();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jComboBoxAptidaoArt = new javax.swing.JComboBox();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jComboBoxDemandaLazer = new javax.swing.JComboBox();
        jLabel118 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jQualDemandaLazer = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        jQualAptidaoArt = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        jQualDemandaProfissional = new javax.swing.JTextArea();
        jPanel22 = new javax.swing.JPanel();
        jBtAuditoriaPSI = new javax.swing.JButton();
        jBtNovoPSI = new javax.swing.JButton();
        jBtAlterarPSI = new javax.swing.JButton();
        jBtExcluirPSI = new javax.swing.JButton();
        jBtSalvarPSI = new javax.swing.JButton();
        jBtCancelarPSI = new javax.swing.JButton();
        jBtSairPSI = new javax.swing.JButton();
        jPanel23 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jLabel119 = new javax.swing.JLabel();
        jComboBoxRegimeAprisionamento = new javax.swing.JComboBox();
        jLabel128 = new javax.swing.JLabel();
        jArtigo = new javax.swing.JTextField();
        jLabel137 = new javax.swing.JLabel();
        jDelito = new javax.swing.JTextField();
        jLabel138 = new javax.swing.JLabel();
        jComboBoxReincidente = new javax.swing.JComboBox();
        jLabel139 = new javax.swing.JLabel();
        jComboBoxPossuiPena = new javax.swing.JComboBox();
        jLabel140 = new javax.swing.JLabel();
        jComboBoxQualPena = new javax.swing.JComboBox();
        jLabel141 = new javax.swing.JLabel();
        jComboBoxPossuiJuridica = new javax.swing.JComboBox();
        jLabel142 = new javax.swing.JLabel();
        jComboBoxQualAssistenciaJuridica = new javax.swing.JComboBox();
        jLabel143 = new javax.swing.JLabel();
        jComboBoxPROMAE = new javax.swing.JComboBox();
        jLabel144 = new javax.swing.JLabel();
        jComboBoxAssistenciaJuridica = new javax.swing.JComboBox();
        jPanel29 = new javax.swing.JPanel();
        jBtAuditoriaDJ = new javax.swing.JButton();
        jBtNovoDJ = new javax.swing.JButton();
        jBtAlterarDJ = new javax.swing.JButton();
        jBtExcluirDJ = new javax.swing.JButton();
        jBtSalvarDJ = new javax.swing.JButton();
        jBtCancelarDJ = new javax.swing.JButton();
        jBtSairDJ = new javax.swing.JButton();
        jPanel25 = new javax.swing.JPanel();
        jLabel145 = new javax.swing.JLabel();
        jComboBoxTrabalhaempresa = new javax.swing.JComboBox();
        jLabel146 = new javax.swing.JLabel();
        jQualEmpresa = new javax.swing.JTextField();
        jLabel147 = new javax.swing.JLabel();
        jQualFuncaoExerce = new javax.swing.JTextField();
        jLabel148 = new javax.swing.JLabel();
        jTelefoneContatoEmpresa = new javax.swing.JFormattedTextField();
        jLabel149 = new javax.swing.JLabel();
        jComboBoxCartaInformal = new javax.swing.JComboBox();
        jLabel150 = new javax.swing.JLabel();
        jParaOnde = new javax.swing.JTextField();
        jLabel151 = new javax.swing.JLabel();
        jTelefoneContato = new javax.swing.JFormattedTextField();
        jLabel152 = new javax.swing.JLabel();
        jComboBoxEstudaUP = new javax.swing.JComboBox();
        jLabel153 = new javax.swing.JLabel();
        jOndeEstuda = new javax.swing.JTextField();
        jLabel154 = new javax.swing.JLabel();
        jComboBoxNecessitaTrabalho = new javax.swing.JComboBox();
        jLabel155 = new javax.swing.JLabel();
        jQualNecessitaTrabalho = new javax.swing.JTextField();
        jLabel156 = new javax.swing.JLabel();
        jComboBoxNecessitaEstudaFUP = new javax.swing.JComboBox();
        jLabel157 = new javax.swing.JLabel();
        jQualNecessidadeEstudaFUP = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel26 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jLabel158 = new javax.swing.JLabel();
        jComboBoxRefereSaude = new javax.swing.JComboBox();
        jLabel159 = new javax.swing.JLabel();
        jLabel160 = new javax.swing.JLabel();
        jComboBoxFazendoTratamento = new javax.swing.JComboBox();
        jLabel161 = new javax.swing.JLabel();
        jOutrasDoencas = new javax.swing.JTextField();
        jRBHipertensao = new javax.swing.JRadioButton();
        jRBSifilis = new javax.swing.JRadioButton();
        jRBTuberculose = new javax.swing.JRadioButton();
        jRBHIV = new javax.swing.JRadioButton();
        jRBHepatites = new javax.swing.JRadioButton();
        jRBDiabetes = new javax.swing.JRadioButton();
        jRBEscabiose = new javax.swing.JRadioButton();
        jRBHanseniase = new javax.swing.JRadioButton();
        jPanel36 = new javax.swing.JPanel();
        jBtAuditoriaSS3 = new javax.swing.JButton();
        jBtNovoSS3 = new javax.swing.JButton();
        jBtAlterarSS3 = new javax.swing.JButton();
        jBtExcluirSS3 = new javax.swing.JButton();
        jBtSalvarSS3 = new javax.swing.JButton();
        jBtCancelarSS3 = new javax.swing.JButton();
        jBtSairSS3 = new javax.swing.JButton();
        jPanel28 = new javax.swing.JPanel();
        jLabel162 = new javax.swing.JLabel();
        jComboBoxPsiquiatrico = new javax.swing.JComboBox();
        jLabel163 = new javax.swing.JLabel();
        jOndePsiquiatrico = new javax.swing.JTextField();
        jLabel164 = new javax.swing.JLabel();
        jComboBoxPsicotropico = new javax.swing.JComboBox();
        jLabel165 = new javax.swing.JLabel();
        jQualPsicotropico = new javax.swing.JTextField();
        jLabel166 = new javax.swing.JLabel();
        jComboBoxMental = new javax.swing.JComboBox();
        jLabel167 = new javax.swing.JLabel();
        jRBDesanimo = new javax.swing.JRadioButton();
        jRBInsonia = new javax.swing.JRadioButton();
        jRBFaltaApetite = new javax.swing.JRadioButton();
        jRBIsomantoSocial = new javax.swing.JRadioButton();
        jRBAgressividade = new javax.swing.JRadioButton();
        jRBInquientacao = new javax.swing.JRadioButton();
        jRBPensamentosSuicida = new javax.swing.JRadioButton();
        jRBOutrosDoencas = new javax.swing.JRadioButton();
        jLabel168 = new javax.swing.JLabel();
        jQualOutrosDoencas = new javax.swing.JTextField();
        jLabel169 = new javax.swing.JLabel();
        jComboBoxInternadoPSI = new javax.swing.JComboBox();
        jLabel170 = new javax.swing.JLabel();
        jDataInternaPSI = new com.toedter.calendar.JDateChooser();
        jLabel171 = new javax.swing.JLabel();
        jComboBoxAcompanhaCAPS = new javax.swing.JComboBox();
        jLabel172 = new javax.swing.JLabel();
        jDataCAPS = new com.toedter.calendar.JDateChooser();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel35 = new javax.swing.JPanel();
        jRBInjetaveis = new javax.swing.JRadioButton();
        jRBOutrasSub = new javax.swing.JRadioButton();
        jQualOutrasSub = new javax.swing.JTextField();
        jLabel173 = new javax.swing.JLabel();
        jRBCocaina = new javax.swing.JRadioButton();
        jRBMaconha = new javax.swing.JRadioButton();
        jRBAlcool = new javax.swing.JRadioButton();
        jComboBoxUsoPsicoativos = new javax.swing.JComboBox();
        jRBCrack = new javax.swing.JRadioButton();
        jRBCola = new javax.swing.JRadioButton();
        jLabel174 = new javax.swing.JLabel();
        jComboBoxCompartilhaCrack = new javax.swing.JComboBox();
        jLabel175 = new javax.swing.JLabel();
        jRBSudorese = new javax.swing.JRadioButton();
        jRBTremores = new javax.swing.JRadioButton();
        jRBFissura = new javax.swing.JRadioButton();
        jRBBoca = new javax.swing.JRadioButton();
        jRBNausea = new javax.swing.JRadioButton();
        jPanel37 = new javax.swing.JPanel();
        jLabel176 = new javax.swing.JLabel();
        jRBDesejo = new javax.swing.JRadioButton();
        jRBNaoPara = new javax.swing.JRadioButton();
        jRBAumentoTolerancia = new javax.swing.JRadioButton();
        jPanel33 = new javax.swing.JPanel();
        jLabel177 = new javax.swing.JLabel();
        jComboBoxCAPSAD = new javax.swing.JComboBox();
        jLabel178 = new javax.swing.JLabel();
        jDataCAPSAD = new com.toedter.calendar.JDateChooser();
        jLabel179 = new javax.swing.JLabel();
        jComboBoxEsteveInternado = new javax.swing.JComboBox();
        jLabel180 = new javax.swing.JLabel();
        jQuantoTempoInternado = new javax.swing.JFormattedTextField();
        jLabel181 = new javax.swing.JLabel();
        jComboBoxAceitaDanos = new javax.swing.JComboBox();
        jLabel182 = new javax.swing.JLabel();
        jComboBoxSaudeBucal = new javax.swing.JComboBox();
        jPanel38 = new javax.swing.JPanel();
        jLabel185 = new javax.swing.JLabel();
        jComboBoxNecessitaAtende = new javax.swing.JComboBox();
        jRBMedico = new javax.swing.JRadioButton();
        jRBEnfermagem = new javax.swing.JRadioButton();
        jRBPsicologico = new javax.swing.JRadioButton();
        jRBPsiquiatrico = new javax.swing.JRadioButton();
        jLabel183 = new javax.swing.JLabel();
        jComboBoxPessoasQuimica = new javax.swing.JComboBox();
        jLabel184 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jQuemNecessita = new javax.swing.JTextArea();
        jPanel34 = new javax.swing.JPanel();
        jPanel39 = new javax.swing.JPanel();
        jBtAuditoriaEAPI1 = new javax.swing.JButton();
        jBtNovoEAPI1 = new javax.swing.JButton();
        jBtAlterarEAPI1 = new javax.swing.JButton();
        jBtExcluirEAPI1 = new javax.swing.JButton();
        jBtSalvarEAPI1 = new javax.swing.JButton();
        jBtCancelarEAPI1 = new javax.swing.JButton();
        jBtSairEAPI1 = new javax.swing.JButton();
        jPanel40 = new javax.swing.JPanel();
        jLabel187 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTextoPSP = new javax.swing.JTextArea();
        jPanel41 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTextoCEDEGEP = new javax.swing.JTextArea();
        jPanel42 = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTextoCRASCREAS = new javax.swing.JTextArea();
        jPanel45 = new javax.swing.JPanel();
        jPanel43 = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        jTextoASSISTENCIA = new javax.swing.JTextArea();
        jPanel44 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextoDOCUMENTOCIVIL = new javax.swing.JTextArea();
        jPanel46 = new javax.swing.JPanel();
        jBtAuditoriaEAPI2 = new javax.swing.JButton();
        jBtNovoEAPI2 = new javax.swing.JButton();
        jBtAlterarEAPI2 = new javax.swing.JButton();
        jBtExcluirEAPI2 = new javax.swing.JButton();
        jBtSalvarEAPI2 = new javax.swing.JButton();
        jBtCancelarEAPI2 = new javax.swing.JButton();
        jBtSairEAPI2 = new javax.swing.JButton();
        jPanel47 = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        jTextEAPI2PAI = new javax.swing.JTextArea();
        jLabel186 = new javax.swing.JLabel();
        jLabel188 = new javax.swing.JLabel();
        jLabel189 = new javax.swing.JLabel();
        jLabel190 = new javax.swing.JLabel();
        jTecnicoServicoSocial = new javax.swing.JTextField();
        jLabel191 = new javax.swing.JLabel();
        jTecnicoPsicologico = new javax.swing.JTextField();
        jBtAssistente = new javax.swing.JButton();
        jBtPsicologo = new javax.swing.JButton();
        jPanel50 = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        jTabelaEvolucaoPAI = new javax.swing.JTable();
        jPanel51 = new javax.swing.JPanel();
        jLabel194 = new javax.swing.JLabel();
        jNomeInternoEvolucaoPAI = new javax.swing.JTextField();
        jLabel195 = new javax.swing.JLabel();
        jIdEvolucao = new javax.swing.JTextField();
        jLabel196 = new javax.swing.JLabel();
        jDataEvolucao = new com.toedter.calendar.JDateChooser();
        jBtAuditoriaEvolucao = new javax.swing.JButton();
        jBtCancelarEvolucao = new javax.swing.JButton();
        jBtImpressaoEvolucao = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jBtSalvarEvolucao = new javax.swing.JButton();
        jBtExcluirEvolucao = new javax.swing.JButton();
        jBtAlterarEvolucao = new javax.swing.JButton();
        jBtNovaEvolucao = new javax.swing.JButton();
        jScrollPane18 = new javax.swing.JScrollPane();
        jTextoEvolucao = new javax.swing.JTextArea();
        jPanel8 = new javax.swing.JPanel();
        jFotoInternoPAI = new javax.swing.JLabel();
        jPanel48 = new javax.swing.JPanel();
        jLabel192 = new javax.swing.JLabel();
        jPanel49 = new javax.swing.JPanel();
        jLabel193 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: P.A.I. - Programa de Assistência Individualizado - NOVO");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel21.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel61.setText("Código:");

        jCodigoPesqPAI.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodigoPesqPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqCodigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqCodigo.setToolTipText("Pesquisar PAI por Código");
        jBtPesqCodigo.setContentAreaFilled(false);
        jBtPesqCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqCodigoActionPerformed(evt);
            }
        });

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel62.setText("Data Inicial:");

        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel63.setText("Data Final:");

        jDataInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jDataFinal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqDataPAI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqDataPAI.setToolTipText("Pesquisar PAI por Código");
        jBtPesqDataPAI.setContentAreaFilled(false);
        jBtPesqDataPAI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqDataPAIActionPerformed(evt);
            }
        });

        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel64.setText("Nome do Interno:");

        jNomeInternoPesquisa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqNomeInternoPAI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqNomeInternoPAI.setToolTipText("Pesquisar PAI por Código");
        jBtPesqNomeInternoPAI.setContentAreaFilled(false);
        jBtPesqNomeInternoPAI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqNomeInternoPAIActionPerformed(evt);
            }
        });

        jCheckBoxTodosRegistros.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxTodosRegistros.setText("Todos");
        jCheckBoxTodosRegistros.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxTodosRegistrosItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel64, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel62, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel61, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                        .addComponent(jLabel63)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqDataPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                        .addComponent(jCodigoPesqPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBoxTodosRegistros))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                        .addComponent(jNomeInternoPesquisa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqNomeInternoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jCheckBoxTodosRegistros)
                    .addComponent(jBtPesqCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCodigoPesqPAI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel61))
                .addGap(2, 2, 2)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel63)
                    .addComponent(jDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqDataPAI)
                    .addComponent(jDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel62))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtPesqNomeInternoPAI)
                    .addComponent(jNomeInternoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel64))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jTabelaPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaPAI.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Código", "Data", "Status", "Nome do Interno"
            }
        ));
        jTabelaPAI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaPAIMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTabelaPAI);
        if (jTabelaPAI.getColumnModel().getColumnCount() > 0) {
            jTabelaPAI.getColumnModel().getColumn(0).setMinWidth(60);
            jTabelaPAI.getColumnModel().getColumn(0).setMaxWidth(60);
            jTabelaPAI.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaPAI.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaPAI.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaPAI.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaPAI.getColumnModel().getColumn(3).setMinWidth(280);
            jTabelaPAI.getColumnModel().getColumn(3).setMaxWidth(280);
        }

        jPanel32.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jtotalRegistros.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
        );

        jPanel30.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jLabel67.setText("Total de Registros:");

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel67))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel67)
        );

        jPanel31.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("Listagem", jPanel1);

        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Status");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Data Cadastro");

        jCodigoPAI.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodigoPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCodigoPAI.setEnabled(false);

        jComboBoxStatusPAI.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxStatusPAI.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Ativo", "Inativo" }));
        jComboBoxStatusPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxStatusPAI.setEnabled(false);

        jDataPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataPAI.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Data Admissão");

        jDataAdmissao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataAdmissao.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Unidade penal");

        jUnidadePenal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jUnidadePenal.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jUnidadePenal.setEnabled(false);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Matricula Penal");

        jMatriculaPenal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jMatriculaPenal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMatriculaPenal.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jUnidadePenal)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jCodigoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jComboBoxStatusPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jDataPAI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jDataAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jMatriculaPenal)))
                    .addComponent(jLabel5))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jLabel15)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jCodigoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxStatusPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jMatriculaPenal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jUnidadePenal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.setForeground(new java.awt.Color(0, 0, 255));
        jTabbedPane2.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel59.setText("Código");

        jIdInternoPAI.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdInternoPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdInternoPAI.setEnabled(false);

        jNomeInternoPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoPAI.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Nome do Interno");

        jBtPesquisarInternoPAI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesquisarInternoPAI.setToolTipText("Pesquisar Internos");
        jBtPesquisarInternoPAI.setContentAreaFilled(false);
        jBtPesquisarInternoPAI.setEnabled(false);
        jBtPesquisarInternoPAI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisarInternoPAIActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Nome da Mãe");

        jNomeMaeInternoPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeMaeInternoPAI.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Nome do Pai");

        jNomePaiInternoPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomePaiInternoPAI.setEnabled(false);

        jDataNascimentoPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataNascimentoPAI.setEnabled(false);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Dt. Nascimento");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Idade");

        jIdadeInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdadeInterno.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdadeInterno.setEnabled(false);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Cor/Etinia");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Naturalidade");

        jNaturalidadeInternoPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNaturalidadeInternoPAI.setEnabled(false);

        jComboBoxCorEtiniaInternoPAI.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxCorEtiniaInternoPAI.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Negro", "Branco", "Pardo", "Indio", "Amarelo" }));
        jComboBoxCorEtiniaInternoPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxCorEtiniaInternoPAI.setEnabled(false);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Municipio onde foi registrado");

        jMunicipioRegistrado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMunicipioRegistrado.setEnabled(false);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Deseja informar algo sobre orientação sexual?");

        jComboBoxDocumentoDelega.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDocumentoDelega.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxDocumentoDelega.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDocumentoDelega.setEnabled(false);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Se Sim, o que?");

        jTipoOrientacaoSexual.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTipoOrientacaoSexual.setEnabled(false);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("Documento(s) e/ou objetos retirado(s) na delegacia?");

        jComboBoxOrientacaoSexual.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxOrientacaoSexual.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxOrientacaoSexual.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxOrientacaoSexual.setEnabled(false);

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setText("O que?");

        jQualDocumento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualDocumento.setEnabled(false);

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setText("Qual Delegacia?");

        jQualDelegacia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualDelegacia.setEnabled(false);

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setText("Tem necessidade regular. documento civil?");

        jComboBoxRegularizarDocumento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxRegularizarDocumento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxRegularizarDocumento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxRegularizarDocumento.setEnabled(false);

        jComboBoxTipoDocumento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTipoDocumento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "CN,RG,CPF", "Certidão Nascimento", "Certidão Casamento", "RG", "CPF", "Titulo Eleitor", "Passaporte", "CNH", "Carteira de Trabalho", " " }));
        jComboBoxTipoDocumento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTipoDocumento.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jQualDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel24))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBoxRegularizarDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxTipoDocumento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jQualDelegacia)
                    .addComponent(jComboBoxDocumentoDelega, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTipoOrientacaoSexual)
                .addGap(14, 14, 14))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jNomeMaeInternoPAI, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(158, 158, 158))
                            .addComponent(jNomePaiInternoPAI)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jDataNascimentoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jIdadeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel17)
                            .addComponent(jComboBoxCorEtiniaInternoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jMunicipioRegistrado)
                                    .addComponent(jNaturalidadeInternoPAI))
                                .addGap(4, 4, 4))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(16, 16, 16)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxOrientacaoSexual, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel59)
                    .addComponent(jIdInternoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jNomeInternoPAI)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesquisarInternoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(27, 27, 27))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel59)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIdInternoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNomeInternoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesquisarInternoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(2, 2, 2)
                        .addComponent(jNomeMaeInternoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jNomePaiInternoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(jLabel14)))
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jNaturalidadeInternoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataNascimentoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdadeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxCorEtiniaInternoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jMunicipioRegistrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jComboBoxOrientacaoSexual, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jTipoOrientacaoSexual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jComboBoxDocumentoDelega, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jQualDelegacia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(jQualDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jComboBoxRegularizarDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("DADOS CIVIS", jPanel4);

        jRGInternoPAI.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jRGInternoPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jRGInternoPAI.setEnabled(false);

        jDataExpedicao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataExpedicao.setEnabled(false);

        jCPFInternoPAI.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCPFInternoPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCPFInternoPAI.setEnabled(false);

        jEmissor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jEmissor.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("RG Nº");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Data Exp.");

        jCartaoSUSPAI.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCartaoSUSPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCartaoSUSPAI.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("CPF Nº");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Cartão SUS");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Emissor");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setText("Titulo Eleitor");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setText("Zona");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel28.setText("Sessão");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel29.setText("NIS");

        jTituloEleitor.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTituloEleitor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTituloEleitor.setEnabled(false);

        jZona.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jZona.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jZona.setEnabled(false);

        jSessao.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jSessao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jSessao.setEnabled(false);

        jNIS.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jNIS.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNIS.setEnabled(false);

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel30.setText("CTPS");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel31.setText("Série");

        jCTPS.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCTPS.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCTPS.setEnabled(false);

        jSerie.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jSerie.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jSerie.setEnabled(false);

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel32.setText("Religião");

        jComboBoxEstadoCivil.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Solteiro(a)", "Solteiro(a) com conpanheiro(a)", "Casado(a)", "Separado(a)", "Divorciado(a)", "Viúvo(a)" }));
        jComboBoxEstadoCivil.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxEstadoCivil.setEnabled(false);

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel33.setText("Situação Civil");

        jComboBoxReligiao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxReligiao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Católica", "Evangélica", "M. africanas", "Espirita", "Nenhuma", "Outra" }));
        jComboBoxReligiao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxReligiao.setEnabled(false);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Endereço", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(204, 0, 0))); // NOI18N

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel34.setText("Endereço:");

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel35.setText("Complem:");

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel36.setText("Referência:");

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel37.setText("Cidade:");

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel38.setText("Bairro:");

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel39.setText("UF:");

        jEndereco.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jEndereco.setEnabled(false);

        jComplemento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComplemento.setEnabled(false);

        jReferencia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jReferencia.setEnabled(false);

        jBairro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jBairro.setEnabled(false);

        jCidade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCidade.setEnabled(false);

        jComboBoxEstadoNaturalidade.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxEstadoNaturalidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "AL", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        jComboBoxEstadoNaturalidade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxEstadoNaturalidade.setEnabled(false);

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel40.setText("Telefone:");

        jTelefone.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTelefone.setEnabled(false);

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel41.setText("Telefone:");

        jTelefone1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTelefone1.setEnabled(false);

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel42.setText("Celular:");

        jCelular.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCelular.setEnabled(false);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel40)
                    .addComponent(jLabel37)
                    .addComponent(jLabel38)
                    .addComponent(jLabel36)
                    .addComponent(jLabel35)
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jEndereco)
                    .addComponent(jComplemento)
                    .addComponent(jReferencia)
                    .addComponent(jBairro, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jCidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel39)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxEstadoNaturalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(jLabel42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel9Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jCelular, jTelefone, jTelefone1});

        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel34)
                    .addComponent(jEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel35)
                    .addComponent(jComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(jBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39)
                    .addComponent(jComboBoxEstadoNaturalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42)
                    .addComponent(jTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41)
                    .addComponent(jTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jRGInternoPAI, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel26)
                            .addComponent(jLabel30)
                            .addComponent(jTituloEleitor)
                            .addComponent(jCTPS))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jEmissor, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel27))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDataExpedicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(jLabel18))
                                    .addComponent(jLabel28)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel31))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSessao)
                                    .addComponent(jLabel33)
                                    .addComponent(jComboBoxEstadoCivil, 0, 1, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCPFInternoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jCartaoSUSPAI)))
                            .addComponent(jNIS)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel29)
                                    .addComponent(jLabel32))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jComboBoxReligiao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jEmissor, jSerie, jZona});

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jDataExpedicao, jSessao});

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jCTPS, jRGInternoPAI, jTituloEleitor});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel18)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel9))
                .addGap(6, 6, 6)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jEmissor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRGInternoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataExpedicao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCPFInternoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCartaoSUSPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTituloEleitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSessao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNIS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCTPS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxReligiao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("DOCUMENTOS/DADOS PESSOAIS", jPanel5);

        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jBtAuditoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoria.setToolTipText("Auditoria");
        jBtAuditoria.setContentAreaFilled(false);
        jBtAuditoria.setEnabled(false);
        jBtAuditoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaActionPerformed(evt);
            }
        });

        jBtNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovo.setText("Novo");
        jBtNovo.setContentAreaFilled(false);
        jBtNovo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoActionPerformed(evt);
            }
        });

        jBtAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterar.setText("Alterar");
        jBtAlterar.setContentAreaFilled(false);
        jBtAlterar.setEnabled(false);
        jBtAlterar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarActionPerformed(evt);
            }
        });

        jBtExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluir.setText("Excluir");
        jBtExcluir.setContentAreaFilled(false);
        jBtExcluir.setEnabled(false);
        jBtExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluir.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirActionPerformed(evt);
            }
        });

        jBtSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvar.setText("Gravar");
        jBtSalvar.setContentAreaFilled(false);
        jBtSalvar.setEnabled(false);
        jBtSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarActionPerformed(evt);
            }
        });

        jBtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelar.setText("Cancelar");
        jBtCancelar.setContentAreaFilled(false);
        jBtCancelar.setEnabled(false);
        jBtCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarActionPerformed(evt);
            }
        });

        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSair.setText("Sair");
        jBtSair.setContentAreaFilled(false);
        jBtSair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSair.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSair.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        jBtImpressaoPAI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/gtklp-icone-3770-16.png"))); // NOI18N
        jBtImpressaoPAI.setToolTipText("Impressão do Rel. P.A.I.");
        jBtImpressaoPAI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtImpressaoPAIActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(jBtNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSair)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtImpressaoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jBtNovo)
            .addComponent(jBtAlterar)
            .addComponent(jBtExcluir)
            .addComponent(jBtSalvar)
            .addComponent(jBtCancelar)
            .addComponent(jBtSair)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBtImpressaoPAI)
                    .addComponent(jBtAuditoria)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manutenção", jPanel2);

        jComboBoxVinculoPAI.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxVinculoPAI.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Pai", "Mãe", "Avô", "Avó", "Tio", "Tia", "Irmão", "Irmã", "Primo", "Prima" }));
        jComboBoxVinculoPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxVinculoPAI.setEnabled(false);

        jLabel122.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel122.setText("Vinculo");

        jLabel123.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel123.setText("Ocupação");

        jBtSalvarFamiliar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarFamiliar.setToolTipText("Gravar");
        jBtSalvarFamiliar.setEnabled(false);
        jBtSalvarFamiliar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvarFamiliar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarFamiliar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarFamiliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarFamiliarActionPerformed(evt);
            }
        });

        jBtCancelarFamiliar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarFamiliar.setToolTipText("Cancelar");
        jBtCancelarFamiliar.setEnabled(false);
        jBtCancelarFamiliar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelarFamiliar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarFamiliar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarFamiliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarFamiliarActionPerformed(evt);
            }
        });

        jBtExcluirFamiliar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirFamiliar.setToolTipText("Excluir");
        jBtExcluirFamiliar.setEnabled(false);
        jBtExcluirFamiliar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluirFamiliar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirFamiliar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirFamiliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirFamiliarActionPerformed(evt);
            }
        });

        jIdFamiliarPAI.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdFamiliarPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdFamiliarPAI.setEnabled(false);

        jLabel120.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel120.setText("Código");

        jTabelaFamiliarPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaFamiliarPAI.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Nome do Familiar", "Vinculo", "Idade", "Ocupação"
            }
        ));
        jTabelaFamiliarPAI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaFamiliarPAIMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(jTabelaFamiliarPAI);
        if (jTabelaFamiliarPAI.getColumnModel().getColumnCount() > 0) {
            jTabelaFamiliarPAI.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaFamiliarPAI.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaFamiliarPAI.getColumnModel().getColumn(1).setMinWidth(250);
            jTabelaFamiliarPAI.getColumnModel().getColumn(1).setMaxWidth(250);
            jTabelaFamiliarPAI.getColumnModel().getColumn(2).setMinWidth(120);
            jTabelaFamiliarPAI.getColumnModel().getColumn(2).setMaxWidth(120);
            jTabelaFamiliarPAI.getColumnModel().getColumn(3).setMinWidth(40);
            jTabelaFamiliarPAI.getColumnModel().getColumn(3).setMaxWidth(40);
            jTabelaFamiliarPAI.getColumnModel().getColumn(4).setMinWidth(140);
            jTabelaFamiliarPAI.getColumnModel().getColumn(4).setMaxWidth(140);
        }

        jEnderecoTelefonePAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jEnderecoTelefonePAI.setEnabled(false);

        jIdadeFamiliarPAI.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdadeFamiliarPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdadeFamiliarPAI.setEnabled(false);

        jBtAuditoriaFamiliar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaFamiliar.setToolTipText("Auditoria");
        jBtAuditoriaFamiliar.setContentAreaFilled(false);
        jBtAuditoriaFamiliar.setEnabled(false);
        jBtAuditoriaFamiliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaFamiliarActionPerformed(evt);
            }
        });

        jOcupacaoFamiliarPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jOcupacaoFamiliarPAI.setEnabled(false);

        jLabel125.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel125.setText("idade");

        jNomeFamiliarPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeFamiliarPAI.setEnabled(false);

        jBtAlterarFamiliar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarFamiliar.setToolTipText("Alterar");
        jBtAlterarFamiliar.setEnabled(false);
        jBtAlterarFamiliar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterarFamiliar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarFamiliar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarFamiliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarFamiliarActionPerformed(evt);
            }
        });

        jLabel124.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel124.setText("Endereço/Telefone");

        jBtNovoFamiliar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoFamiliar.setToolTipText("Novo");
        jBtNovoFamiliar.setEnabled(false);
        jBtNovoFamiliar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovoFamiliar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovoFamiliar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovoFamiliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoFamiliarActionPerformed(evt);
            }
        });

        jLabel121.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel121.setText("Nome do Familiar");

        jPanel12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jBtAuditoriaSS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaSS.setToolTipText("Auditoria");
        jBtAuditoriaSS.setContentAreaFilled(false);
        jBtAuditoriaSS.setEnabled(false);
        jBtAuditoriaSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaSSActionPerformed(evt);
            }
        });

        jBtNovoSS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoSS.setText("Novo");
        jBtNovoSS.setContentAreaFilled(false);
        jBtNovoSS.setEnabled(false);
        jBtNovoSS.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovoSS.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovoSS.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovoSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoSSActionPerformed(evt);
            }
        });

        jBtAlterarSS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarSS.setText("Alterar");
        jBtAlterarSS.setContentAreaFilled(false);
        jBtAlterarSS.setEnabled(false);
        jBtAlterarSS.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterarSS.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarSS.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarSSActionPerformed(evt);
            }
        });

        jBtExcluirSS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirSS.setText("Excluir");
        jBtExcluirSS.setContentAreaFilled(false);
        jBtExcluirSS.setEnabled(false);
        jBtExcluirSS.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluirSS.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirSS.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirSSActionPerformed(evt);
            }
        });

        jBtSalvarSS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarSS.setText("Gravar");
        jBtSalvarSS.setContentAreaFilled(false);
        jBtSalvarSS.setEnabled(false);
        jBtSalvarSS.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvarSS.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarSS.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarSSActionPerformed(evt);
            }
        });

        jBtCancelarSS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarSS.setText("Cancelar");
        jBtCancelarSS.setContentAreaFilled(false);
        jBtCancelarSS.setEnabled(false);
        jBtCancelarSS.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelarSS.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarSS.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarSSActionPerformed(evt);
            }
        });

        jBtSairSS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSairSS.setText("Sair");
        jBtSairSS.setContentAreaFilled(false);
        jBtSairSS.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSairSS.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSairSS.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSairSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairSSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addComponent(jBtNovoSS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarSS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirSS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarSS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelarSS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSairSS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaSS, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtAuditoriaSS))
            .addComponent(jBtNovoSS)
            .addComponent(jBtAlterarSS)
            .addComponent(jBtExcluirSS)
            .addComponent(jBtSalvarSS)
            .addComponent(jBtCancelarSS)
            .addComponent(jBtSairSS)
        );

        jTabbedPane3.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel43.setText("Tem filhos(as)?");

        jComboBoxTemFilhos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTemFilhos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxTemFilhos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTemFilhos.setEnabled(false);

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel44.setText("Qtos?");

        jQuantosFilhos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQuantosFilhos.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jQuantosFilhos.setEnabled(false);

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel46.setText("Neces. reconhecer paternidade?");

        jComboBoxReconhecerPaterna.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxReconhecerPaterna.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxReconhecerPaterna.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxReconhecerPaterna.setEnabled(false);

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel47.setText("Dados:");

        jDadosPaternidade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDadosPaternidade.setEnabled(false);

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel45.setText("Com quem estão os filhos?");

        jComboBoxEstaoFilhos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxEstaoFilhos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Mãe", "Avós paternos", "Avós maternos", "Instituição", "Pai", "Parentes", "Vizinhos", "Não sabe", "Na rua", "São adultos independentes", " " }));
        jComboBoxEstaoFilhos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxEstaoFilhos.setEnabled(false);

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel48.setText("Alguém na família com necess. especiais?");

        jComboBoxNecessidaEspecial.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxNecessidaEspecial.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxNecessidaEspecial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxNecessidaEspecial.setEnabled(false);

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel49.setText("Qual?");

        jQualNecessidadeESP.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualNecessidadeESP.setEnabled(false);

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel50.setText("A família é referênciada no CRAS?");

        jComboBoxCRAS.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxCRAS.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxCRAS.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxCRAS.setEnabled(false);

        jComboBoxCREAS.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxCREAS.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxCREAS.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxCREAS.setEnabled(false);

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel51.setText("E no CREAS?");

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel52.setText("A família recebe algum benefício social?");

        jComboBoxRecebeBeneficio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxRecebeBeneficio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxRecebeBeneficio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxRecebeBeneficio.setEnabled(false);

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel53.setText("Qual(is)?");

        jQuaisBeneficiosFamilia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQuaisBeneficiosFamilia.setEnabled(false);

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel54.setText("Antes prisão, recebe algum benef. social?");

        jComboBoxAntesBeneficio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxAntesBeneficio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxAntesBeneficio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxAntesBeneficio.setEnabled(false);

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel55.setText("Qual(is)?");

        jQuaisBeneficiosAntesPrisao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQuaisBeneficiosAntesPrisao.setEnabled(false);

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel56.setText("Necessita transf. titular. algum beneficio?");

        jComboBoxNecessitaBeneficio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxNecessitaBeneficio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxNecessitaBeneficio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxNecessitaBeneficio.setEnabled(false);

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel57.setText("P/quem?");

        jNecessitaBeneficio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNecessitaBeneficio.setEnabled(false);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addComponent(jLabel49)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jQualNecessidadeESP))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel45)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxEstaoFilhos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel56)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxNecessitaBeneficio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel57)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jNecessitaBeneficio, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel11Layout.createSequentialGroup()
                                            .addComponent(jLabel50)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jComboBoxCRAS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel11Layout.createSequentialGroup()
                                            .addComponent(jLabel48)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jComboBoxNecessidaEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel11Layout.createSequentialGroup()
                                            .addComponent(jLabel52)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jComboBoxRecebeBeneficio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(jLabel54)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxAntesBeneficio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel55, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel53, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jQuaisBeneficiosFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jQuaisBeneficiosAntesPrisao, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(349, 349, 349)
                                .addComponent(jLabel51)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxCREAS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(jLabel47)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jDadosPaternidade, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(jLabel43)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxTemFilhos, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel44)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jQuantosFilhos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel46)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxReconhecerPaterna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel11Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jNecessitaBeneficio, jQuaisBeneficiosAntesPrisao, jQuaisBeneficiosFamilia});

        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxReconhecerPaterna, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46)
                    .addComponent(jQuantosFilhos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44)
                    .addComponent(jComboBoxTemFilhos, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel47)
                    .addComponent(jDadosPaternidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel45)
                    .addComponent(jComboBoxEstaoFilhos, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(jComboBoxNecessidaEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49)
                    .addComponent(jQualNecessidadeESP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(jLabel51)
                    .addComponent(jComboBoxCREAS, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxCRAS, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxRecebeBeneficio, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel52)
                    .addComponent(jQuaisBeneficiosFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jQuaisBeneficiosAntesPrisao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxAntesBeneficio, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel55)
                    .addComponent(jLabel54))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(jComboBoxNecessitaBeneficio, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel57)
                    .addComponent(jNecessitaBeneficio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("CCGF-1", jPanel11);

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel58.setText("Moradia:");

        jComboBoxMoradia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxMoradia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Casa", "Apartamento", "Barraco", "Lona/Plástico", "Rua Assentamento" }));
        jComboBoxMoradia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxMoradia.setEnabled(false);

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel60.setText("Modalidade moradia:");

        jComboBoxModalidade.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxModalidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Próprio", "Alugado", "Ocupado", "Cedido" }));
        jComboBoxModalidade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxModalidade.setEnabled(false);

        jLabel65.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel65.setText("Abastecimento água:");

        jComboBoxAbastecimento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxAbastecimento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Encanada", "Cisterna", "Poço", "Fonte", "Rua" }));
        jComboBoxAbastecimento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxAbastecimento.setEnabled(false);

        jLabel66.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel66.setText("Eliminação de dejetos:");

        jComboBoxEliminaDejetos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxEliminaDejetos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Rede esgoto", "Fossa séptica", "Mato", "Outros" }));
        jComboBoxEliminaDejetos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxEliminaDejetos.setEnabled(false);

        jLabel68.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel68.setText("Descarte do lixo:");

        jComboBoxDescarte.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDescarte.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Coleta", "Queima", "Enterra", "A céu aberto" }));
        jComboBoxDescarte.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDescarte.setEnabled(false);

        jLabel69.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel69.setText("Família situação vulnera. social?");
        jLabel69.setToolTipText("A família encontra-se em situação de vulnerabilidade social?");

        jComboBoxFamiliaVulneraSocial.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxFamiliaVulneraSocial.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxFamiliaVulneraSocial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxFamiliaVulneraSocial.setEnabled(false);

        jLabel70.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel70.setText("O(A) interno(a) alguma vez já viveu ou vive em situação de rua?");

        jComboBoxViveuRua.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxViveuRua.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxViveuRua.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxViveuRua.setEnabled(false);

        jLabel71.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel71.setText("Por quanto tempo?");

        jQuantoTempo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQuantoTempo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jQuantoTempo.setEnabled(false);

        jLabel72.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel72.setText("Motivo:");

        jMotivo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMotivo.setEnabled(false);

        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel73.setText("Como tem sido part. família durante tempo que está detido(a)?");
        jLabel73.setToolTipText("Como tem sido a participação da família durante o tempo em que está detido(a)?");

        jComboBoxFamiliaDetido.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxFamiliaDetido.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Nula", "Insuficiente", "Razoável", "Muita boa" }));
        jComboBoxFamiliaDetido.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxFamiliaDetido.setEnabled(false);

        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel74.setText("Necessita restabelecer vínculos familiares?");

        jComboBoxRestabelecerVinculo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxRestabelecerVinculo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim", "Não quer" }));
        jComboBoxRestabelecerVinculo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxRestabelecerVinculo.setEnabled(false);

        jLabel75.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel75.setText("Como?");

        jComboBoxComoRestabelecer.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxComoRestabelecer.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Localizar familiares", "Contatar familiares", "Agendar atendimento para sensibilização" }));
        jComboBoxComoRestabelecer.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxComoRestabelecer.setEnabled(false);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel71)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jQuantoTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel72)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jMotivo))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel73)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxFamiliaDetido, 0, 102, Short.MAX_VALUE))
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel13Layout.createSequentialGroup()
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel13Layout.createSequentialGroup()
                                    .addComponent(jLabel68)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jComboBoxDescarte, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel13Layout.createSequentialGroup()
                                    .addComponent(jLabel58)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jComboBoxMoradia, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel13Layout.createSequentialGroup()
                                    .addComponent(jLabel65)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jComboBoxAbastecimento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel13Layout.createSequentialGroup()
                                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel60, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel66, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jComboBoxEliminaDejetos, 0, 107, Short.MAX_VALUE)
                                        .addComponent(jComboBoxModalidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel13Layout.createSequentialGroup()
                                    .addComponent(jLabel69)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jComboBoxFamiliaVulneraSocial, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(jPanel13Layout.createSequentialGroup()
                            .addComponent(jLabel70)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jComboBoxViveuRua, 0, 95, Short.MAX_VALUE))
                        .addGroup(jPanel13Layout.createSequentialGroup()
                            .addComponent(jLabel74)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jComboBoxRestabelecerVinculo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel75)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxComoRestabelecer, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel58)
                    .addComponent(jComboBoxMoradia, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel60)
                    .addComponent(jComboBoxModalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel65)
                    .addComponent(jComboBoxAbastecimento, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel66)
                    .addComponent(jComboBoxEliminaDejetos, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel68)
                    .addComponent(jComboBoxDescarte, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxFamiliaVulneraSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel69))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel70)
                    .addComponent(jComboBoxViveuRua, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel71)
                    .addComponent(jQuantoTempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel72)
                    .addComponent(jMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel73)
                    .addComponent(jComboBoxFamiliaDetido, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel74)
                    .addComponent(jComboBoxRestabelecerVinculo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel75)
                    .addComponent(jComboBoxComoRestabelecer, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane3.addTab("CCGF-2", jPanel13);

        jLabel129.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel129.setText("Idade");

        jNomeVisitaPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeVisitaPAI.setEnabled(false);

        jParentescoPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jParentescoPAI.setEnabled(false);

        jLabel134.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel134.setText("Vinculo");

        jBtPesqVisita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqVisita.setContentAreaFilled(false);
        jBtPesqVisita.setEnabled(false);
        jBtPesqVisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqVisitaActionPerformed(evt);
            }
        });

        jIdadeVisita.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdadeVisita.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdadeVisita.setEnabled(false);

        jOcupacaoVisita.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jOcupacaoVisita.setEnabled(false);

        jLabel126.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel126.setText("Código");

        jLabel131.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel131.setText("Ocupação");

        jTabelaVisitas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaVisitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Item", "Código", "Nome da Visita", "Vinculo", "Idade", "Ocupação"
            }
        ));
        jTabelaVisitas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaVisitasMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(jTabelaVisitas);
        if (jTabelaVisitas.getColumnModel().getColumnCount() > 0) {
            jTabelaVisitas.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaVisitas.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaVisitas.getColumnModel().getColumn(1).setMinWidth(50);
            jTabelaVisitas.getColumnModel().getColumn(1).setMaxWidth(50);
            jTabelaVisitas.getColumnModel().getColumn(2).setMinWidth(250);
            jTabelaVisitas.getColumnModel().getColumn(2).setMaxWidth(250);
            jTabelaVisitas.getColumnModel().getColumn(3).setMinWidth(120);
            jTabelaVisitas.getColumnModel().getColumn(3).setMaxWidth(120);
            jTabelaVisitas.getColumnModel().getColumn(4).setMinWidth(40);
            jTabelaVisitas.getColumnModel().getColumn(4).setMaxWidth(40);
            jTabelaVisitas.getColumnModel().getColumn(5).setMinWidth(140);
            jTabelaVisitas.getColumnModel().getColumn(5).setMaxWidth(140);
        }

        jLabel127.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel127.setText("Nome da Visita");

        jIdVisitaPAI.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdVisitaPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdVisitaPAI.setEnabled(false);

        jBtCancelarVisita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarVisita.setToolTipText("Cancelar");
        jBtCancelarVisita.setEnabled(false);
        jBtCancelarVisita.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelarVisita.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarVisita.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarVisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarVisitaActionPerformed(evt);
            }
        });

        jBtExcluirVisita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirVisita.setToolTipText("Excluir");
        jBtExcluirVisita.setEnabled(false);
        jBtExcluirVisita.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluirVisita.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirVisita.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirVisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirVisitaActionPerformed(evt);
            }
        });

        jBtSalvarVisita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarVisita.setToolTipText("Gravar");
        jBtSalvarVisita.setEnabled(false);
        jBtSalvarVisita.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvarVisita.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarVisita.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarVisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarVisitaActionPerformed(evt);
            }
        });

        jBtNovaVisita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovaVisita.setToolTipText("Novo");
        jBtNovaVisita.setEnabled(false);
        jBtNovaVisita.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovaVisita.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovaVisita.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovaVisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovaVisitaActionPerformed(evt);
            }
        });

        jBtAlterarVisita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarVisita.setToolTipText("Alterar");
        jBtAlterarVisita.setEnabled(false);
        jBtAlterarVisita.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterarVisita.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarVisita.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarVisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarVisitaActionPerformed(evt);
            }
        });

        jBtAuditoriaVisita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaVisita.setToolTipText("Auditoria");
        jBtAuditoriaVisita.setContentAreaFilled(false);
        jBtAuditoriaVisita.setEnabled(false);
        jBtAuditoriaVisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaVisitaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane10)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jBtNovaVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtAlterarVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtExcluirVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSalvarVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtCancelarVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtAuditoriaVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel126)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel127)
                        .addGap(315, 315, 315))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jIdVisitaPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jNomeVisitaPAI)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jOcupacaoVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel131))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel134)
                            .addComponent(jParentescoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jIdadeVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel129))))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel126)
                    .addComponent(jLabel127))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtPesqVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNomeVisitaPAI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdVisitaPAI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel131)
                        .addComponent(jLabel134))
                    .addComponent(jLabel129))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jParentescoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jOcupacaoVisita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdadeVisita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtNovaVisita)
                    .addComponent(jBtAlterarVisita)
                    .addComponent(jBtExcluirVisita)
                    .addComponent(jBtSalvarVisita)
                    .addComponent(jBtCancelarVisita)
                    .addComponent(jBtAuditoriaVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jTabbedPane3.addTab("PRPV", jPanel14);

        jTabelaVisitasIntimas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaVisitasIntimas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Item", "Código", "Nome da Visita Intima", "Vinculo", "Idade", "Ocupação"
            }
        ));
        jTabelaVisitasIntimas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaVisitasIntimasMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(jTabelaVisitasIntimas);
        if (jTabelaVisitasIntimas.getColumnModel().getColumnCount() > 0) {
            jTabelaVisitasIntimas.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaVisitasIntimas.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaVisitasIntimas.getColumnModel().getColumn(1).setMinWidth(50);
            jTabelaVisitasIntimas.getColumnModel().getColumn(1).setMaxWidth(50);
            jTabelaVisitasIntimas.getColumnModel().getColumn(2).setMinWidth(250);
            jTabelaVisitasIntimas.getColumnModel().getColumn(2).setMaxWidth(250);
            jTabelaVisitasIntimas.getColumnModel().getColumn(3).setMinWidth(120);
            jTabelaVisitasIntimas.getColumnModel().getColumn(3).setMaxWidth(120);
            jTabelaVisitasIntimas.getColumnModel().getColumn(4).setMinWidth(40);
            jTabelaVisitasIntimas.getColumnModel().getColumn(4).setMaxWidth(40);
            jTabelaVisitasIntimas.getColumnModel().getColumn(5).setMinWidth(140);
            jTabelaVisitasIntimas.getColumnModel().getColumn(5).setMaxWidth(140);
        }

        jLabel130.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel130.setText("Idade");

        jIdadeVisitaIntima.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdadeVisitaIntima.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdadeVisitaIntima.setEnabled(false);

        jBtPesqVisitaIntima.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqVisitaIntima.setContentAreaFilled(false);
        jBtPesqVisitaIntima.setEnabled(false);
        jBtPesqVisitaIntima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqVisitaIntimaActionPerformed(evt);
            }
        });

        jIdVisitaIntima.setEditable(false);
        jIdVisitaIntima.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdVisitaIntima.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdVisitaIntima.setEnabled(false);

        jBtSalvarVisitaIntima.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarVisitaIntima.setToolTipText("Gravar");
        jBtSalvarVisitaIntima.setEnabled(false);
        jBtSalvarVisitaIntima.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvarVisitaIntima.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarVisitaIntima.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarVisitaIntima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarVisitaIntimaActionPerformed(evt);
            }
        });

        jLabel133.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel133.setText("Nome da Visita Intima");

        jBtCancelarVisitaIntima.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarVisitaIntima.setToolTipText("Cancelar");
        jBtCancelarVisitaIntima.setEnabled(false);
        jBtCancelarVisitaIntima.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelarVisitaIntima.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarVisitaIntima.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarVisitaIntima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarVisitaIntimaActionPerformed(evt);
            }
        });

        jLabel135.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel135.setText("Código");

        jLabel132.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel132.setText("Ocupação");

        jLabel136.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel136.setText("Vinculo");

        jOcupacaoVisitaIntima.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jOcupacaoVisitaIntima.setEnabled(false);

        jParentescoVisitaIntima.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jParentescoVisitaIntima.setEnabled(false);

        jBtAlterarVisitaIntima.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarVisitaIntima.setToolTipText("Alterar");
        jBtAlterarVisitaIntima.setEnabled(false);
        jBtAlterarVisitaIntima.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterarVisitaIntima.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarVisitaIntima.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarVisitaIntima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarVisitaIntimaActionPerformed(evt);
            }
        });

        jBtExcluirVisitaIntima.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirVisitaIntima.setToolTipText("Excluir");
        jBtExcluirVisitaIntima.setEnabled(false);
        jBtExcluirVisitaIntima.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluirVisitaIntima.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirVisitaIntima.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirVisitaIntima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirVisitaIntimaActionPerformed(evt);
            }
        });

        jBtAuditoriaVisitaIntima.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaVisitaIntima.setToolTipText("Auditoria");
        jBtAuditoriaVisitaIntima.setContentAreaFilled(false);
        jBtAuditoriaVisitaIntima.setEnabled(false);
        jBtAuditoriaVisitaIntima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaVisitaIntimaActionPerformed(evt);
            }
        });

        jBtNovaVisitaIntima.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovaVisitaIntima.setToolTipText("Novo");
        jBtNovaVisitaIntima.setEnabled(false);
        jBtNovaVisitaIntima.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovaVisitaIntima.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovaVisitaIntima.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovaVisitaIntima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovaVisitaIntimaActionPerformed(evt);
            }
        });

        jNomeVisitaIntima.setEditable(false);
        jNomeVisitaIntima.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeVisitaIntima.setEnabled(false);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jBtNovaVisitaIntima, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtAlterarVisitaIntima, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtExcluirVisitaIntima, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSalvarVisitaIntima, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtCancelarVisitaIntima, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtAuditoriaVisitaIntima, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel135)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel133)
                        .addGap(0, 278, Short.MAX_VALUE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jOcupacaoVisitaIntima, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel132))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel136)
                                .addGap(0, 159, Short.MAX_VALUE))
                            .addComponent(jParentescoVisitaIntima))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jIdadeVisitaIntima, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel130)))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jIdVisitaIntima, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jNomeVisitaIntima)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqVisitaIntima, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel135)
                    .addComponent(jLabel133))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIdVisitaIntima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNomeVisitaIntima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqVisitaIntima, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel132)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel130)
                        .addComponent(jLabel136)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jOcupacaoVisitaIntima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jParentescoVisitaIntima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdadeVisitaIntima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtNovaVisitaIntima)
                    .addComponent(jBtAlterarVisitaIntima)
                    .addComponent(jBtExcluirVisitaIntima)
                    .addComponent(jBtSalvarVisitaIntima)
                    .addComponent(jBtCancelarVisitaIntima)
                    .addComponent(jBtAuditoriaVisitaIntima)))
        );

        jTabbedPane3.addTab("PRPVI", jPanel15);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2)
                    .addComponent(jScrollPane9))
                .addContainerGap())
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jBtNovoFamiliar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarFamiliar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirFamiliar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarFamiliar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelarFamiliar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaFamiliar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel123)
                    .addComponent(jOcupacaoFamiliarPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel124)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jEnderecoTelefonePAI)
                        .addContainerGap())))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel120)
                    .addComponent(jIdFamiliarPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel121)
                    .addComponent(jNomeFamiliarPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel125, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jIdadeFamiliarPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel122)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jComboBoxVinculoPAI, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel120)
                    .addComponent(jLabel121)
                    .addComponent(jLabel125)
                    .addComponent(jLabel122))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxVinculoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdadeFamiliarPAI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNomeFamiliarPAI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdFamiliarPAI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel123)
                        .addGap(3, 3, 3)
                        .addComponent(jOcupacaoFamiliarPAI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel124)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jEnderecoTelefonePAI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtNovoFamiliar)
                    .addComponent(jBtAlterarFamiliar)
                    .addComponent(jBtExcluirFamiliar)
                    .addComponent(jBtSalvarFamiliar)
                    .addComponent(jBtCancelarFamiliar)
                    .addComponent(jBtAuditoriaFamiliar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("C.C.G.F.", jPanel7);

        jPanel18.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jBtAuditoriaTO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaTO.setToolTipText("Auditoria");
        jBtAuditoriaTO.setContentAreaFilled(false);
        jBtAuditoriaTO.setEnabled(false);
        jBtAuditoriaTO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaTOActionPerformed(evt);
            }
        });

        jBtNovoTO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoTO.setText("Novo");
        jBtNovoTO.setContentAreaFilled(false);
        jBtNovoTO.setEnabled(false);
        jBtNovoTO.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovoTO.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovoTO.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovoTO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoTOActionPerformed(evt);
            }
        });

        jBtAlterarTO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarTO.setText("Alterar");
        jBtAlterarTO.setContentAreaFilled(false);
        jBtAlterarTO.setEnabled(false);
        jBtAlterarTO.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterarTO.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarTO.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarTO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarTOActionPerformed(evt);
            }
        });

        jBtExcluirTO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirTO.setText("Excluir");
        jBtExcluirTO.setContentAreaFilled(false);
        jBtExcluirTO.setEnabled(false);
        jBtExcluirTO.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluirTO.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirTO.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirTO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirTOActionPerformed(evt);
            }
        });

        jBtSalvarTO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarTO.setText("Gravar");
        jBtSalvarTO.setContentAreaFilled(false);
        jBtSalvarTO.setEnabled(false);
        jBtSalvarTO.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvarTO.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarTO.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarTO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarTOActionPerformed(evt);
            }
        });

        jBtCancelarTO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarTO.setText("Cancelar");
        jBtCancelarTO.setContentAreaFilled(false);
        jBtCancelarTO.setEnabled(false);
        jBtCancelarTO.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelarTO.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarTO.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarTO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarTOActionPerformed(evt);
            }
        });

        jBtSairTO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSairTO.setText("Sair");
        jBtSairTO.setContentAreaFilled(false);
        jBtSairTO.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSairTO.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSairTO.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSairTO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairTOActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addComponent(jBtNovoTO)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarTO)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirTO)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarTO)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelarTO)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSairTO)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaTO, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtAuditoriaTO))
            .addComponent(jBtNovoTO)
            .addComponent(jBtAlterarTO)
            .addComponent(jBtExcluirTO)
            .addComponent(jBtSalvarTO)
            .addComponent(jBtCancelarTO)
            .addComponent(jBtSairTO)
        );

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Dados Especificos da Mulher Encarcerada", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(204, 0, 0))); // NOI18N

        jLabel76.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel76.setText("Necessita transferir titularidade do bolsa família?");

        jComboBoxNecessitaFamilia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxNecessitaFamilia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxNecessitaFamilia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxNecessitaFamilia.setEnabled(false);

        jLabel77.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel77.setText("Para quem?");

        jParaQuemFamilia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jParaQuemFamilia.setEnabled(false);

        jLabel78.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel78.setText("Está grávida?");

        jComboBoxEstaGravida.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxEstaGravida.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim", "Talvez" }));
        jComboBoxEstaGravida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxEstaGravida.setEnabled(false);

        jLabel79.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel79.setText("Fez teste para comprovação?");

        jComboBoxComprovacao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxComprovacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxComprovacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxComprovacao.setEnabled(false);

        jLabel80.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel80.setText("Estava fazendo pré-natal?");
        jLabel80.setToolTipText("Estava fazendo pré-natal?");

        jComboBoxPreNatal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxPreNatal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxPreNatal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxPreNatal.setEnabled(false);

        jLabel81.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel81.setText("Onde?");

        jOndePreNatal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jOndePreNatal.setEnabled(false);

        jLabel82.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel82.setText("Destino bebê:");

        jComboBoxDestinoBebe.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDestinoBebe.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Mãe", "Pai", "Parentes", "Instituição" }));
        jComboBoxDestinoBebe.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDestinoBebe.setEnabled(false);

        jLabel83.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel83.setText("Suspeita gravidez?");

        jComboBoxSuspeitaGravidez.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxSuspeitaGravidez.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxSuspeitaGravidez.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxSuspeitaGravidez.setEnabled(false);

        jLabel84.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel84.setText("Partos:");

        jQuantosPartos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQuantosPartos.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jQuantosPartos.setEnabled(false);

        jLabel85.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel85.setText("Aborto(s):");

        jQuantosAbortos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQuantosAbortos.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jQuantosAbortos.setEnabled(false);

        jLabel86.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel86.setText("Parto(s) normal(is):");

        jQuantosPartosNornais.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQuantosPartosNornais.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jQuantosPartosNornais.setEnabled(false);

        jLabel87.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel87.setText("Cesariana(s):");

        jQuantasCesarianas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQuantasCesarianas.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jQuantasCesarianas.setEnabled(false);

        jLabel88.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel88.setText("Usa algum contraceptivo?");

        jComboBoxContraceptivos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxContraceptivos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxContraceptivos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxContraceptivos.setEnabled(false);

        jLabel89.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel89.setText("Qual?");

        jLabel90.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel90.setText("Apresenta alguma demanda?");
        jLabel90.setToolTipText("Apresenta alguma demanda?");

        jComboBoxDemanda.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDemanda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxDemanda.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDemanda.setEnabled(false);

        jLabel91.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel91.setText("Qual?");

        jScrollPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jQualContraceptivos.setColumns(20);
        jQualContraceptivos.setRows(5);
        jQualContraceptivos.setEnabled(false);
        jScrollPane1.setViewportView(jQualContraceptivos);

        jScrollPane3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jQualDemanda.setColumns(20);
        jQualDemanda.setRows(5);
        jQualDemanda.setEnabled(false);
        jScrollPane3.setViewportView(jQualDemanda);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jParaQuemFamilia))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel77, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel78, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel82)
                                .addComponent(jLabel85)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxEstaGravida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel17Layout.createSequentialGroup()
                                        .addComponent(jComboBoxDestinoBebe, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel83)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxSuspeitaGravidez, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addComponent(jLabel84))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                                .addComponent(jQuantosAbortos, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel86)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jQuantosPartosNornais, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel87)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jQuantasCesarianas, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jQuantosPartos, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel89)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                                .addGap(201, 201, 201)
                                .addComponent(jLabel81)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jOndePreNatal, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                                    .addComponent(jLabel80, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jComboBoxPreNatal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(131, 131, 131))
                                .addGroup(jPanel17Layout.createSequentialGroup()
                                    .addComponent(jLabel76)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jComboBoxNecessitaFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGap(239, 239, 239)
                                .addComponent(jLabel79)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxComprovacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel88)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxContraceptivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(jLabel90)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxDemanda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(jLabel91)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel76)
                    .addComponent(jComboBoxNecessitaFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel77)
                    .addComponent(jParaQuemFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel78)
                    .addComponent(jComboBoxEstaGravida, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel79)
                    .addComponent(jComboBoxComprovacao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jOndePreNatal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel81)
                    .addComponent(jComboBoxPreNatal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel80))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel82)
                    .addComponent(jComboBoxDestinoBebe, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel83)
                    .addComponent(jComboBoxSuspeitaGravidez, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel84)
                    .addComponent(jQuantosPartos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel87)
                    .addComponent(jQuantasCesarianas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel86)
                    .addComponent(jQuantosPartosNornais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jQuantosAbortos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel85))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel88)
                    .addComponent(jComboBoxContraceptivos, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel89)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel90)
                    .addComponent(jComboBoxDemanda, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel91)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Dados de Escolarização", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel92.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel92.setText("Instrução:");

        jComboBoxInstrucao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxInstrucao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Analfabeto(a)", "Alfabetizado(a)", "Fundamental I", "Fundamental II", "Ensino Médio Completo", "Ensino Médio Incompleto", "Superior Completo", "Superior Incompleto", "Pós graduação" }));
        jComboBoxInstrucao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxInstrucao.setEnabled(false);

        jLabel93.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel93.setText("Estudando antes de ser preso?");
        jLabel93.setToolTipText("Estava estudando antes de ser preso?");

        jComboBoxEstudandoPreso.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxEstudandoPreso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxEstudandoPreso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxEstudandoPreso.setEnabled(false);

        jLabel94.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel94.setText("Participou ou participa de atividade educativa na unidade prisional?");

        jComboBoxParticipouPrisional.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxParticipouPrisional.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxParticipouPrisional.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxParticipouPrisional.setEnabled(false);

        jLabel95.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel95.setText("Gostaria de participar de atividade educativa na unidade prisional?");

        jComboBoxGostariaPrisional.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxGostariaPrisional.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxGostariaPrisional.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxGostariaPrisional.setEnabled(false);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel92)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxInstrucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel93)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxEstudandoPreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                                .addComponent(jLabel94)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxParticipouPrisional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                                .addComponent(jLabel95)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxGostariaPrisional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(9, 9, 9))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxEstudandoPreso, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel93)
                    .addComponent(jComboBoxInstrucao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel92))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel94)
                    .addComponent(jComboBoxParticipouPrisional, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel95)
                    .addComponent(jComboBoxGostariaPrisional, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("D.E.M.E.", jPanel10);

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Dados Profissionais, de Trabalho e Lazer", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 102, 0))); // NOI18N

        jLabel96.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel96.setText("Profissão/Ocupação:");

        jProfissaoOcupacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jProfissaoOcupacao.setEnabled(false);

        jLabel97.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel97.setText("Trabalha antes de ser detido(a)?");

        jComboBoxTrabalhaDetido.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTrabalhaDetido.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxTrabalhaDetido.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTrabalhaDetido.setEnabled(false);

        jLabel98.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel98.setText("Desempregado?");

        jComboBoxDesempregado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDesempregado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxDesempregado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDesempregado.setEnabled(false);

        jLabel99.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel99.setText("Carteira assinada?");

        jComboBoxCarteiraAssinada.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxCarteiraAssinada.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxCarteiraAssinada.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxCarteiraAssinada.setEnabled(false);

        jLabel100.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel100.setText("Por quanto tempo?");

        jQuantoTempoCarteira.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQuantoTempoCarteira.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jQuantoTempoCarteira.setEnabled(false);

        jLabel101.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel101.setText("Faixa salarial:");

        jFaixaSalarial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jFaixaSalarial.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFaixaSalarial.setEnabled(false);

        jLabel102.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel102.setText("Tem beneficiários?");
        jLabel102.setToolTipText("Possui beneficários(Filhos e/ou Pais)");

        jComboBoxTemBeneficios.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTemBeneficios.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxTemBeneficios.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTemBeneficios.setEnabled(false);

        jLabel103.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel103.setText("Quem?");

        jQuemTemBeneficios.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQuemTemBeneficios.setEnabled(false);

        jLabel104.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel104.setText("Demanda pesquisa sobre auxilio reclusão?");

        jLabel105.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel105.setText("Demanda pesquisa sobre auxilio Desemprego?");

        jComboBoxDemandaReclusao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDemandaReclusao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxDemandaReclusao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDemandaReclusao.setEnabled(false);

        jComboBoxDemandaDesemprego.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDemandaDesemprego.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxDemandaDesemprego.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDemandaDesemprego.setEnabled(false);

        jLabel106.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel106.setText("Possui rendimento agora?");

        jComboBoxPossuiRedimento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxPossuiRedimento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxPossuiRedimento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxPossuiRedimento.setEnabled(false);

        jLabel107.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel107.setText("Qual?");

        jQualRendimento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualRendimento.setEnabled(false);

        jLabel108.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel108.setText("Exerce ativ. labo. na U.Prisional?");

        jComboBoxExerceAtividade.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxExerceAtividade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxExerceAtividade.setToolTipText("Exerce atividade laborativa na Unidade Penal");
        jComboBoxExerceAtividade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxExerceAtividade.setEnabled(false);

        jLabel109.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel109.setText("Qual?");

        jQualAtividadeExerce.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualAtividadeExerce.setEnabled(false);

        jLabel110.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel110.setText("Com geração de renda?");

        jComboBoxGeracaoRenda.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxGeracaoRenda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxGeracaoRenda.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxGeracaoRenda.setEnabled(false);

        jLabel111.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel111.setText("Aptidão Profissional?");

        jComboBoxAptidaoProfissional.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxAptidaoProfissional.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxAptidaoProfissional.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxAptidaoProfissional.setEnabled(false);

        jLabel112.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel112.setText("Qual Aptidão?");

        jQualAptidao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualAptidao.setEnabled(false);

        jLabel113.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel113.setText("Dem. qualifi. profissional?");

        jComboBoxDemandaProfissional.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDemandaProfissional.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxDemandaProfissional.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDemandaProfissional.setEnabled(false);

        jLabel114.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel114.setText("Qual?");

        jLabel115.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel115.setText("Aptidão espor./artisitica?");

        jComboBoxAptidaoArt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxAptidaoArt.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxAptidaoArt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxAptidaoArt.setEnabled(false);

        jLabel116.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel116.setText("Qual?");

        jLabel117.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel117.setText("Dem.prática. esp. e lazer?");

        jComboBoxDemandaLazer.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDemandaLazer.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxDemandaLazer.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDemandaLazer.setEnabled(false);

        jLabel118.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel118.setText("Qual?");

        jQualDemandaLazer.setColumns(20);
        jQualDemandaLazer.setRows(5);
        jQualDemandaLazer.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualDemandaLazer.setEnabled(false);
        jScrollPane4.setViewportView(jQualDemandaLazer);

        jQualAptidaoArt.setColumns(20);
        jQualAptidaoArt.setRows(5);
        jQualAptidaoArt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualAptidaoArt.setEnabled(false);
        jScrollPane5.setViewportView(jQualAptidaoArt);

        jQualDemandaProfissional.setColumns(20);
        jQualDemandaProfissional.setRows(5);
        jQualDemandaProfissional.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualDemandaProfissional.setEnabled(false);
        jScrollPane6.setViewportView(jQualDemandaProfissional);

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel113)
                            .addComponent(jLabel117)
                            .addComponent(jLabel115))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxDemandaLazer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxAptidaoArt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxDemandaProfissional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel118, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel116, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel114, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel112)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jQualAptidao)
                        .addContainerGap())
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel102)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxTemBeneficios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel103)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jQuemTemBeneficios)
                        .addContainerGap())
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jLabel106))
                            .addComponent(jLabel108)
                            .addComponent(jLabel110, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxPossuiRedimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxExerceAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel20Layout.createSequentialGroup()
                                        .addComponent(jLabel107)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBoxDemandaReclusao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jComboBoxDemandaDesemprego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jQualRendimento, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel20Layout.createSequentialGroup()
                                        .addComponent(jLabel109)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jQualAtividadeExerce, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addComponent(jComboBoxGeracaoRenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel111)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxAptidaoProfissional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel20Layout.createSequentialGroup()
                                        .addComponent(jLabel99)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxCarteiraAssinada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel100)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jQuantoTempoCarteira, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel20Layout.createSequentialGroup()
                                        .addComponent(jLabel97)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxTrabalhaDetido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel20Layout.createSequentialGroup()
                                        .addComponent(jLabel98)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jComboBoxDesempregado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel20Layout.createSequentialGroup()
                                        .addComponent(jLabel101)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jFaixaSalarial))))
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel105, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel104, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addComponent(jLabel96)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jProfissaoOcupacao)))
                        .addContainerGap())))
        );

        jPanel20Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jQualAtividadeExerce, jQualRendimento});

        jPanel20Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jScrollPane4, jScrollPane5, jScrollPane6});

        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel96)
                    .addComponent(jProfissaoOcupacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel97)
                    .addComponent(jComboBoxTrabalhaDetido, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel98)
                    .addComponent(jComboBoxDesempregado, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jQuantoTempoCarteira, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel100)
                    .addComponent(jComboBoxCarteiraAssinada, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel99)
                    .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel101)
                        .addComponent(jFaixaSalarial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel102)
                    .addComponent(jComboBoxTemBeneficios, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel103)
                    .addComponent(jQuemTemBeneficios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel104)
                    .addComponent(jComboBoxDemandaReclusao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel105)
                    .addComponent(jComboBoxDemandaDesemprego, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jQualRendimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel107)
                    .addComponent(jComboBoxPossuiRedimento, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel106))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel108)
                    .addComponent(jComboBoxExerceAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel109)
                    .addComponent(jQualAtividadeExerce, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel111)
                    .addComponent(jComboBoxAptidaoProfissional, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxGeracaoRenda, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel110))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel112)
                    .addComponent(jQualAptidao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel113)
                        .addComponent(jComboBoxDemandaProfissional, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel114))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel115)
                            .addComponent(jComboBoxAptidaoArt, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel116))
                        .addGap(0, 38, Short.MAX_VALUE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jComboBoxDemandaLazer, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel117)
                        .addComponent(jLabel118))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel22.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jBtAuditoriaPSI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaPSI.setToolTipText("Auditoria");
        jBtAuditoriaPSI.setContentAreaFilled(false);
        jBtAuditoriaPSI.setEnabled(false);
        jBtAuditoriaPSI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaPSIActionPerformed(evt);
            }
        });

        jBtNovoPSI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoPSI.setText("Novo");
        jBtNovoPSI.setContentAreaFilled(false);
        jBtNovoPSI.setEnabled(false);
        jBtNovoPSI.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovoPSI.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovoPSI.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovoPSI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoPSIActionPerformed(evt);
            }
        });

        jBtAlterarPSI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarPSI.setText("Alterar");
        jBtAlterarPSI.setContentAreaFilled(false);
        jBtAlterarPSI.setEnabled(false);
        jBtAlterarPSI.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterarPSI.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarPSI.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarPSI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarPSIActionPerformed(evt);
            }
        });

        jBtExcluirPSI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirPSI.setText("Excluir");
        jBtExcluirPSI.setContentAreaFilled(false);
        jBtExcluirPSI.setEnabled(false);
        jBtExcluirPSI.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluirPSI.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirPSI.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirPSI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirPSIActionPerformed(evt);
            }
        });

        jBtSalvarPSI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarPSI.setText("Gravar");
        jBtSalvarPSI.setContentAreaFilled(false);
        jBtSalvarPSI.setEnabled(false);
        jBtSalvarPSI.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvarPSI.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarPSI.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarPSI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarPSIActionPerformed(evt);
            }
        });

        jBtCancelarPSI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarPSI.setText("Cancelar");
        jBtCancelarPSI.setContentAreaFilled(false);
        jBtCancelarPSI.setEnabled(false);
        jBtCancelarPSI.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelarPSI.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarPSI.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarPSI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarPSIActionPerformed(evt);
            }
        });

        jBtSairPSI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSairPSI.setText("Sair");
        jBtSairPSI.setContentAreaFilled(false);
        jBtSairPSI.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSairPSI.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSairPSI.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSairPSI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairPSIActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addComponent(jBtNovoPSI)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarPSI)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirPSI)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarPSI)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelarPSI)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSairPSI)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaPSI, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtAuditoriaPSI))
            .addComponent(jBtNovoPSI)
            .addComponent(jBtAlterarPSI)
            .addComponent(jBtExcluirPSI)
            .addComponent(jBtSalvarPSI)
            .addComponent(jBtCancelarPSI)
            .addComponent(jBtSairPSI)
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("D.P.T.L", jPanel16);

        jPanel24.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Dados Jurídicos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(153, 0, 102))); // NOI18N

        jLabel119.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel119.setText("Regime de Aprisionamento:");

        jComboBoxRegimeAprisionamento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxRegimeAprisionamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Provisório", "Fechado", "Semi-Aberto", "Aberto" }));
        jComboBoxRegimeAprisionamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxRegimeAprisionamento.setEnabled(false);

        jLabel128.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel128.setText("Artigo:");

        jArtigo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jArtigo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jArtigo.setEnabled(false);

        jLabel137.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel137.setText("Delito:");

        jDelito.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDelito.setEnabled(false);

        jLabel138.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel138.setText("Reincidente?");

        jComboBoxReincidente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxReincidente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxReincidente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxReincidente.setEnabled(false);

        jLabel139.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel139.setText("Possui req. temp. pleit. prog. pena?");
        jLabel139.setToolTipText("Possui requisito temporal para pleitear progressão depena");

        jComboBoxPossuiPena.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxPossuiPena.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxPossuiPena.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxPossuiPena.setEnabled(false);

        jLabel140.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel140.setText("Qual?");

        jComboBoxQualPena.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxQualPena.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Semi-aberto", "Aberto", "Livramento Condicional", "Indulto" }));
        jComboBoxQualPena.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxQualPena.setEnabled(false);

        jLabel141.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel141.setText("Possui assistência jurídica?");

        jComboBoxPossuiJuridica.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxPossuiJuridica.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxPossuiJuridica.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxPossuiJuridica.setEnabled(false);

        jLabel142.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel142.setText("Qual?");

        jComboBoxQualAssistenciaJuridica.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxQualAssistenciaJuridica.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Pública", "Particular" }));
        jComboBoxQualAssistenciaJuridica.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxQualAssistenciaJuridica.setEnabled(false);

        jLabel143.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel143.setText("Possui requisitos para ser inserido no PROMAE?");

        jComboBoxPROMAE.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxPROMAE.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Não", "Sim", "Talvez" }));
        jComboBoxPROMAE.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxPROMAE.setEnabled(false);

        jLabel144.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel144.setText("Necessita de assitência jurídica?");

        jComboBoxAssistenciaJuridica.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxAssistenciaJuridica.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxAssistenciaJuridica.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxAssistenciaJuridica.setEnabled(false);

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel142)
                                    .addComponent(jLabel143)))
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel141, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel139, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addGroup(jPanel24Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel144)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxPossuiJuridica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxPossuiPena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel140)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxPROMAE, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxQualAssistenciaJuridica, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxQualPena, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(jComboBoxAssistenciaJuridica, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel119)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxRegimeAprisionamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel128)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jArtigo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel137)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDelito)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel138)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxReincidente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );

        jPanel24Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jComboBoxPROMAE, jComboBoxQualAssistenciaJuridica, jComboBoxQualPena});

        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel119)
                    .addComponent(jComboBoxRegimeAprisionamento, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel128)
                    .addComponent(jArtigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jDelito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel138)
                    .addComponent(jComboBoxReincidente, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel137))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxPossuiPena, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel139)
                    .addComponent(jLabel140)
                    .addComponent(jComboBoxQualPena, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel141)
                    .addComponent(jComboBoxPossuiJuridica, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel142)
                    .addComponent(jComboBoxQualAssistenciaJuridica, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel143)
                    .addComponent(jComboBoxPROMAE, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel144)
                    .addComponent(jComboBoxAssistenciaJuridica, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel24Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jComboBoxPROMAE, jComboBoxQualAssistenciaJuridica, jComboBoxQualPena});

        jPanel29.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jBtAuditoriaDJ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaDJ.setToolTipText("Auditoria");
        jBtAuditoriaDJ.setContentAreaFilled(false);
        jBtAuditoriaDJ.setEnabled(false);
        jBtAuditoriaDJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaDJActionPerformed(evt);
            }
        });

        jBtNovoDJ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoDJ.setText("Novo");
        jBtNovoDJ.setContentAreaFilled(false);
        jBtNovoDJ.setEnabled(false);
        jBtNovoDJ.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovoDJ.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovoDJ.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovoDJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoDJActionPerformed(evt);
            }
        });

        jBtAlterarDJ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarDJ.setText("Alterar");
        jBtAlterarDJ.setContentAreaFilled(false);
        jBtAlterarDJ.setEnabled(false);
        jBtAlterarDJ.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterarDJ.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarDJ.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarDJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarDJActionPerformed(evt);
            }
        });

        jBtExcluirDJ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirDJ.setText("Excluir");
        jBtExcluirDJ.setContentAreaFilled(false);
        jBtExcluirDJ.setEnabled(false);
        jBtExcluirDJ.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluirDJ.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirDJ.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirDJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirDJActionPerformed(evt);
            }
        });

        jBtSalvarDJ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarDJ.setText("Gravar");
        jBtSalvarDJ.setContentAreaFilled(false);
        jBtSalvarDJ.setEnabled(false);
        jBtSalvarDJ.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvarDJ.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarDJ.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarDJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarDJActionPerformed(evt);
            }
        });

        jBtCancelarDJ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarDJ.setText("Cancelar");
        jBtCancelarDJ.setContentAreaFilled(false);
        jBtCancelarDJ.setEnabled(false);
        jBtCancelarDJ.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelarDJ.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarDJ.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarDJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarDJActionPerformed(evt);
            }
        });

        jBtSairDJ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSairDJ.setText("Sair");
        jBtSairDJ.setContentAreaFilled(false);
        jBtSairDJ.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSairDJ.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSairDJ.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSairDJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairDJActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                .addComponent(jBtNovoDJ)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarDJ)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirDJ)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarDJ)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelarDJ)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSairDJ)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaDJ, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtAuditoriaDJ))
            .addComponent(jBtNovoDJ)
            .addComponent(jBtAlterarDJ)
            .addComponent(jBtExcluirDJ)
            .addComponent(jBtSalvarDJ)
            .addComponent(jBtCancelarDJ)
            .addComponent(jBtSairDJ)
        );

        jPanel25.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Dados Especificos do Regime Semi-aberto e Aberto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(102, 0, 51))); // NOI18N

        jLabel145.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel145.setText("Trabalhando em alguma empresa?");

        jComboBoxTrabalhaempresa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTrabalhaempresa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxTrabalhaempresa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTrabalhaempresa.setEnabled(false);

        jLabel146.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel146.setText("Qual?");

        jQualEmpresa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualEmpresa.setEnabled(false);

        jLabel147.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel147.setText("Qual a função exerce?");

        jQualFuncaoExerce.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualFuncaoExerce.setEnabled(false);

        jLabel148.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel148.setText("Tel. contato empresa?");

        jTelefoneContatoEmpresa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTelefoneContatoEmpresa.setEnabled(false);

        jLabel149.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel149.setText("Carta Emp. ou convite informal?");
        jLabel149.setToolTipText("Possui carta emprego ou algum convite informal?");

        jComboBoxCartaInformal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxCartaInformal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxCartaInformal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxCartaInformal.setEnabled(false);

        jLabel150.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel150.setText("Para onde?");

        jParaOnde.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jParaOnde.setEnabled(false);

        jLabel151.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel151.setText("Tel.Contato:");

        jTelefoneContato.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTelefoneContato.setEnabled(false);

        jLabel152.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel152.setText("Estuda atualmente fora da Unidade Penal?");

        jComboBoxEstudaUP.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxEstudaUP.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxEstudaUP.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxEstudaUP.setEnabled(false);

        jLabel153.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel153.setText("Onde?");

        jOndeEstuda.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jOndeEstuda.setEnabled(false);

        jLabel154.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel154.setText("Necess. de contato p/ fins de trabalho?");
        jLabel154.setToolTipText("Necessidade de contato para fins de trabalho?");

        jComboBoxNecessitaTrabalho.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxNecessitaTrabalho.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxNecessitaTrabalho.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxNecessitaTrabalho.setEnabled(false);

        jLabel155.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel155.setText("Qual?");

        jQualNecessitaTrabalho.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualNecessitaTrabalho.setEnabled(false);

        jLabel156.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel156.setText("Necess. de contato p/ estudar fora U.P?");

        jComboBoxNecessitaEstudaFUP.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxNecessitaEstudaFUP.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxNecessitaEstudaFUP.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxNecessitaEstudaFUP.setEnabled(false);

        jLabel157.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel157.setText("Qual?");

        jQualNecessidadeEstudaFUP.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualNecessidadeEstudaFUP.setEnabled(false);

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel147)
                        .addGap(6, 6, 6)
                        .addComponent(jQualFuncaoExerce))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel145)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxTrabalhaempresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel148)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTelefoneContatoEmpresa))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel146)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jQualEmpresa))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel25Layout.createSequentialGroup()
                                .addComponent(jLabel149)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxCartaInformal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel150)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jParaOnde))
                            .addGroup(jPanel25Layout.createSequentialGroup()
                                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel151)
                                    .addComponent(jLabel153))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jOndeEstuda)
                                    .addGroup(jPanel25Layout.createSequentialGroup()
                                        .addComponent(jTelefoneContato, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel152)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxEstudaUP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel154)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxNecessitaTrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel155)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jQualNecessitaTrabalho))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel156)
                        .addGap(1, 1, 1)
                        .addComponent(jComboBoxNecessitaEstudaFUP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel157)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jQualNecessidadeEstudaFUP)))
                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel145)
                    .addComponent(jComboBoxTrabalhaempresa, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel148)
                    .addComponent(jTelefoneContatoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel146)
                    .addComponent(jQualEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel147)
                    .addComponent(jQualFuncaoExerce, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel149)
                    .addComponent(jComboBoxCartaInformal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel150)
                    .addComponent(jParaOnde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel152)
                    .addComponent(jTelefoneContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel151)
                    .addComponent(jComboBoxEstudaUP, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel153)
                    .addComponent(jOndeEstuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel154)
                    .addComponent(jComboBoxNecessitaTrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel155)
                    .addComponent(jQualNecessitaTrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel157)
                    .addComponent(jComboBoxNecessitaEstudaFUP, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jQualNecessidadeEstudaFUP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel156))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1))
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("D.J.", jPanel23);

        jPanel27.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Dados de Saúde", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(102, 204, 0))); // NOI18N

        jLabel158.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel158.setText("Refere problema saúde física?");

        jComboBoxRefereSaude.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxRefereSaude.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxRefereSaude.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxRefereSaude.setEnabled(false);

        jLabel159.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel159.setText("Qual(is)?");

        jLabel160.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel160.setText("Está fazendo tratamento?");

        jComboBoxFazendoTratamento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxFazendoTratamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxFazendoTratamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxFazendoTratamento.setEnabled(false);

        jLabel161.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel161.setText("Outras:");

        jOutrasDoencas.setToolTipText("");
        jOutrasDoencas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jOutrasDoencas.setEnabled(false);

        jRBHipertensao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBHipertensao.setText("Hipertensão");
        jRBHipertensao.setEnabled(false);

        jRBSifilis.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBSifilis.setText("Sífilis");
        jRBSifilis.setEnabled(false);

        jRBTuberculose.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBTuberculose.setText("Tuberculose");
        jRBTuberculose.setEnabled(false);

        jRBHIV.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBHIV.setText("HIV");
        jRBHIV.setEnabled(false);

        jRBHepatites.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBHepatites.setText("Hepatites");
        jRBHepatites.setEnabled(false);
        jRBHepatites.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBHepatitesActionPerformed(evt);
            }
        });

        jRBDiabetes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBDiabetes.setText("Diabetes");
        jRBDiabetes.setEnabled(false);

        jRBEscabiose.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBEscabiose.setText("Escabiose");
        jRBEscabiose.setEnabled(false);

        jRBHanseniase.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBHanseniase.setText("Hanseniase");
        jRBHanseniase.setEnabled(false);

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addComponent(jLabel158)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxRefereSaude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(jLabel159)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRBHanseniase)
                                .addGap(2, 2, 2)
                                .addComponent(jRBDiabetes))
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addComponent(jLabel161)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jOutrasDoencas, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel160)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxFazendoTratamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(1, 1, 1))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jRBTuberculose)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRBHipertensao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRBHepatites)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRBSifilis)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRBEscabiose)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRBHIV)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel158)
                    .addComponent(jComboBoxRefereSaude, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel159)
                    .addComponent(jRBDiabetes)
                    .addComponent(jRBHanseniase))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRBTuberculose)
                    .addComponent(jRBHepatites)
                    .addComponent(jRBHipertensao)
                    .addComponent(jRBSifilis)
                    .addComponent(jRBEscabiose)
                    .addComponent(jRBHIV))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jOutrasDoencas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel161)
                    .addComponent(jLabel160)
                    .addComponent(jComboBoxFazendoTratamento, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jPanel36.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jBtAuditoriaSS3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaSS3.setToolTipText("Auditoria");
        jBtAuditoriaSS3.setContentAreaFilled(false);
        jBtAuditoriaSS3.setEnabled(false);
        jBtAuditoriaSS3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaSS3ActionPerformed(evt);
            }
        });

        jBtNovoSS3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoSS3.setText("Novo");
        jBtNovoSS3.setContentAreaFilled(false);
        jBtNovoSS3.setEnabled(false);
        jBtNovoSS3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovoSS3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovoSS3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovoSS3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoSS3ActionPerformed(evt);
            }
        });

        jBtAlterarSS3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarSS3.setText("Alterar");
        jBtAlterarSS3.setContentAreaFilled(false);
        jBtAlterarSS3.setEnabled(false);
        jBtAlterarSS3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterarSS3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarSS3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarSS3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarSS3ActionPerformed(evt);
            }
        });

        jBtExcluirSS3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirSS3.setText("Excluir");
        jBtExcluirSS3.setContentAreaFilled(false);
        jBtExcluirSS3.setEnabled(false);
        jBtExcluirSS3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluirSS3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirSS3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirSS3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirSS3ActionPerformed(evt);
            }
        });

        jBtSalvarSS3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarSS3.setText("Gravar");
        jBtSalvarSS3.setContentAreaFilled(false);
        jBtSalvarSS3.setEnabled(false);
        jBtSalvarSS3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvarSS3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarSS3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarSS3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarSS3ActionPerformed(evt);
            }
        });

        jBtCancelarSS3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarSS3.setText("Cancelar");
        jBtCancelarSS3.setContentAreaFilled(false);
        jBtCancelarSS3.setEnabled(false);
        jBtCancelarSS3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelarSS3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarSS3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarSS3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarSS3ActionPerformed(evt);
            }
        });

        jBtSairSS3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSairSS3.setText("Sair");
        jBtSairSS3.setContentAreaFilled(false);
        jBtSairSS3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSairSS3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSairSS3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSairSS3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairSS3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
                .addComponent(jBtNovoSS3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarSS3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirSS3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarSS3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelarSS3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSairSS3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaSS3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtAuditoriaSS3))
            .addComponent(jBtNovoSS3)
            .addComponent(jBtAlterarSS3)
            .addComponent(jBtExcluirSS3)
            .addComponent(jBtSalvarSS3)
            .addComponent(jBtCancelarSS3)
            .addComponent(jBtSairSS3)
        );

        jPanel28.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Saúde Mental", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 153))); // NOI18N

        jLabel162.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel162.setText("Já fez ou faz acomp. psiquiatrico?");
        jLabel162.setToolTipText("Já fez ou faz acompanhamento psiquiatrico?");

        jComboBoxPsiquiatrico.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxPsiquiatrico.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxPsiquiatrico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxPsiquiatrico.setEnabled(false);

        jLabel163.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel163.setText("Onde?");

        jOndePsiquiatrico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jOndePsiquiatrico.setEnabled(false);

        jLabel164.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel164.setText("Já fez ou faz uso de psicotrópico?");

        jComboBoxPsicotropico.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxPsicotropico.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxPsicotropico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxPsicotropico.setEnabled(false);

        jLabel165.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel165.setText("Qual?");

        jQualPsicotropico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualPsicotropico.setEnabled(false);

        jLabel166.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel166.setText("Ref. sint. sug./ind.trans. mental?");
        jLabel166.setToolTipText("Refere sintomas sugestivos/indicadores de transtorno mental?");

        jComboBoxMental.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxMental.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxMental.setToolTipText("Refere sintomas sugestivos/indicadores de transtorno mental");
        jComboBoxMental.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxMental.setEnabled(false);

        jLabel167.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel167.setText("Qual?");

        jRBDesanimo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBDesanimo.setText("Desânimo");
        jRBDesanimo.setEnabled(false);

        jRBInsonia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBInsonia.setText("Insônia");
        jRBInsonia.setEnabled(false);

        jRBFaltaApetite.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBFaltaApetite.setText("Falta/Excesso de apetite");
        jRBFaltaApetite.setEnabled(false);

        jRBIsomantoSocial.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBIsomantoSocial.setText("Isolamento Social");
        jRBIsomantoSocial.setEnabled(false);

        jRBAgressividade.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBAgressividade.setText("Agressividade");
        jRBAgressividade.setEnabled(false);

        jRBInquientacao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBInquientacao.setText("Inquietação motora excessiva");
        jRBInquientacao.setEnabled(false);

        jRBPensamentosSuicida.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBPensamentosSuicida.setText("Pensamentos suicidas");
        jRBPensamentosSuicida.setEnabled(false);

        jRBOutrosDoencas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBOutrosDoencas.setText("Outros");
        jRBOutrosDoencas.setEnabled(false);

        jLabel168.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel168.setText("Qual outros?");

        jQualOutrosDoencas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualOutrosDoencas.setEnabled(false);

        jLabel169.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel169.setText("Foi internado em algum hosp. psiquiátrico?");

        jComboBoxInternadoPSI.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxInternadoPSI.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxInternadoPSI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxInternadoPSI.setEnabled(false);

        jLabel170.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel170.setText("Quando?");

        jDataInternaPSI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataInternaPSI.setEnabled(false);

        jLabel171.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel171.setText("Fez acompanhamento em algum CAPS?");

        jComboBoxAcompanhaCAPS.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxAcompanhaCAPS.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxAcompanhaCAPS.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxAcompanhaCAPS.setEnabled(false);

        jLabel172.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel172.setText("Quando?");

        jDataCAPS.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataCAPS.setEnabled(false);

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addComponent(jLabel171)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxAcompanhaCAPS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addComponent(jLabel169)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxInternadoPSI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addComponent(jLabel170)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDataInternaPSI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addComponent(jLabel172)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDataCAPS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel166, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel164, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel162, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxMental, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxPsicotropico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxPsiquiatrico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel165, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel163, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jOndePsiquiatrico)
                                    .addComponent(jQualPsicotropico)))
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addComponent(jLabel167)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRBDesanimo)
                                .addGap(81, 81, 81))))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRBFaltaApetite)
                            .addComponent(jRBAgressividade))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addComponent(jRBInquientacao)
                                .addGap(18, 18, 18)
                                .addComponent(jRBOutrosDoencas))
                            .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jRBInsonia)
                                .addGroup(jPanel28Layout.createSequentialGroup()
                                    .addComponent(jRBIsomantoSocial)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jRBPensamentosSuicida, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(jLabel168)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jQualOutrosDoencas)))
                .addContainerGap())
        );

        jPanel28Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jComboBoxMental, jComboBoxPsicotropico, jComboBoxPsiquiatrico});

        jPanel28Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jRBInsonia, jRBOutrosDoencas});

        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel162)
                    .addComponent(jComboBoxPsiquiatrico, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel163)
                    .addComponent(jOndePsiquiatrico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel164)
                    .addComponent(jComboBoxPsicotropico, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel165)
                    .addComponent(jQualPsicotropico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel166)
                    .addComponent(jComboBoxMental, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel167)
                    .addComponent(jRBDesanimo)
                    .addComponent(jRBInsonia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRBFaltaApetite)
                    .addComponent(jRBIsomantoSocial)
                    .addComponent(jRBPensamentosSuicida))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRBAgressividade)
                    .addComponent(jRBInquientacao)
                    .addComponent(jRBOutrosDoencas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel168)
                    .addComponent(jQualOutrosDoencas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel170)
                    .addComponent(jDataInternaPSI, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxInternadoPSI, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel169))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jDataCAPS, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel172)
                    .addComponent(jComboBoxAcompanhaCAPS, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel171))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jLabel169.getAccessibleContext().setAccessibleDescription("Já foi internado em algum hospital psiquiátrico?");

        jTabbedPane4.setForeground(new java.awt.Color(102, 0, 102));
        jTabbedPane4.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jRBInjetaveis.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBInjetaveis.setText("Injetáveis");
        jRBInjetaveis.setEnabled(false);

        jRBOutrasSub.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBOutrasSub.setText("Outras:");
        jRBOutrasSub.setEnabled(false);

        jQualOutrasSub.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualOutrasSub.setEnabled(false);

        jLabel173.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel173.setText("Fez uso subs. psicoáticas?");

        jRBCocaina.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBCocaina.setText("Cocaína");
        jRBCocaina.setEnabled(false);

        jRBMaconha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBMaconha.setText("Maconha");
        jRBMaconha.setEnabled(false);

        jRBAlcool.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBAlcool.setText("Àlcool");
        jRBAlcool.setEnabled(false);

        jComboBoxUsoPsicoativos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxUsoPsicoativos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxUsoPsicoativos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxUsoPsicoativos.setEnabled(false);

        jRBCrack.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBCrack.setText("Crack");
        jRBCrack.setEnabled(false);

        jRBCola.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBCola.setText("Cola");
        jRBCola.setEnabled(false);

        jLabel174.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel174.setText("Já fez uso compartilhado de drogas injetáveis e/ou cachimbo de crack?");

        jComboBoxCompartilhaCrack.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxCompartilhaCrack.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxCompartilhaCrack.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxCompartilhaCrack.setEnabled(false);

        jLabel175.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel175.setText("S.  abstinência:");
        jLabel175.setToolTipText("Sinais de abstinência");

        jRBSudorese.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBSudorese.setText("Sudorese");
        jRBSudorese.setEnabled(false);

        jRBTremores.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBTremores.setText("Tremores");
        jRBTremores.setEnabled(false);

        jRBFissura.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBFissura.setText("Fissura");
        jRBFissura.setEnabled(false);

        jRBBoca.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBBoca.setText("Boca Seca");
        jRBBoca.setEnabled(false);

        jRBNausea.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBNausea.setText("Náusea");
        jRBNausea.setEnabled(false);

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel35Layout.createSequentialGroup()
                                .addComponent(jRBCrack)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRBInjetaveis)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRBOutrasSub)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jQualOutrasSub))
                            .addGroup(jPanel35Layout.createSequentialGroup()
                                .addComponent(jLabel173)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxUsoPsicoativos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRBAlcool)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRBMaconha, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRBCocaina, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRBCola)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(10, 10, 10))
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addComponent(jLabel174)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(jComboBoxCompartilhaCrack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addComponent(jLabel175, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRBSudorese)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRBTremores)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRBFissura)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRBBoca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRBNausea, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel173)
                    .addComponent(jComboBoxUsoPsicoativos, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRBAlcool)
                    .addComponent(jRBMaconha)
                    .addComponent(jRBCocaina)
                    .addComponent(jRBCola))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jQualOutrasSub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRBOutrasSub)
                    .addComponent(jRBInjetaveis)
                    .addComponent(jRBCrack))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxCompartilhaCrack, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel174))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jRBNausea)
                    .addComponent(jRBBoca)
                    .addComponent(jRBFissura)
                    .addComponent(jRBTremores)
                    .addComponent(jRBSudorese)
                    .addComponent(jLabel175))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Uso Substâncias Psicoátivas", jPanel35);

        jLabel176.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel176.setText("SINAIS SUGESTIVOS DE DEPENDÊNCIA QUÍMICA:");

        jRBDesejo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBDesejo.setText("Desejo incontrolável de usar");
        jRBDesejo.setEnabled(false);

        jRBNaoPara.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBNaoPara.setText("Não conseguir parar depois que começa a usar");
        jRBNaoPara.setEnabled(false);

        jRBAumentoTolerancia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBAumentoTolerancia.setText("Aumento da tolerância(doses cada vez maiores)");
        jRBAumentoTolerancia.setEnabled(false);

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel176)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
                .addContainerGap(131, Short.MAX_VALUE)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRBDesejo)
                    .addComponent(jRBNaoPara)
                    .addComponent(jRBAumentoTolerancia))
                .addGap(49, 49, 49))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel176)
                .addGap(5, 5, 5)
                .addComponent(jRBDesejo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addComponent(jRBNaoPara)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRBAumentoTolerancia)
                .addContainerGap())
        );

        jTabbedPane4.addTab("Continuação", jPanel37);

        jLabel177.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel177.setText("Fez acompanhamento em algum CAPS AD?");

        jComboBoxCAPSAD.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxCAPSAD.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxCAPSAD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxCAPSAD.setEnabled(false);

        jLabel178.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel178.setText("Quando?");

        jDataCAPSAD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataCAPSAD.setEnabled(false);

        jLabel179.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel179.setText("Esteve internado em casa de acolhimento?");

        jComboBoxEsteveInternado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxEsteveInternado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxEsteveInternado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxEsteveInternado.setEnabled(false);

        jLabel180.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel180.setText("Quanto tempo?");

        jQuantoTempoInternado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQuantoTempoInternado.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jQuantoTempoInternado.setEnabled(false);

        jLabel181.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel181.setText("Aceita conhecer e/ou participar de um programa de redução de danos?");

        jComboBoxAceitaDanos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxAceitaDanos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxAceitaDanos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxAceitaDanos.setEnabled(false);

        jLabel182.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel182.setText("Refere queixa relacionada a saúde bucal?");

        jComboBoxSaudeBucal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxSaudeBucal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxSaudeBucal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxSaudeBucal.setEnabled(false);

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel33Layout.createSequentialGroup()
                                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel177)
                                    .addComponent(jLabel179))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxEsteveInternado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxCAPSAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel180))
                            .addComponent(jLabel181))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jQuantoTempoInternado, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxAceitaDanos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addGap(322, 322, 322)
                        .addComponent(jLabel178)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataCAPSAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel182)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxSaudeBucal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel33Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jComboBoxAceitaDanos, jQuantoTempoInternado});

        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel178)
                    .addComponent(jDataCAPSAD, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxCAPSAD, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel177))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel179)
                    .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxEsteveInternado, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel180)
                        .addComponent(jQuantoTempoInternado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxAceitaDanos, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel181))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel182)
                    .addComponent(jComboBoxSaudeBucal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Continuação", jPanel33);

        jLabel185.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel185.setText("Necessita de algum tipo de atendimento?");

        jComboBoxNecessitaAtende.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxNecessitaAtende.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxNecessitaAtende.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxNecessitaAtende.setEnabled(false);

        jRBMedico.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBMedico.setText("Médico");
        jRBMedico.setEnabled(false);

        jRBEnfermagem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBEnfermagem.setText("Enfermagem");
        jRBEnfermagem.setEnabled(false);

        jRBPsicologico.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBPsicologico.setText("Psicológico");
        jRBPsicologico.setEnabled(false);

        jRBPsiquiatrico.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBPsiquiatrico.setText("Psiquiátrico");
        jRBPsiquiatrico.setEnabled(false);

        jLabel183.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel183.setText("Pessoas família dependência química?");
        jLabel183.setToolTipText("Há pessoas na família com dependência química?");

        jComboBoxPessoasQuimica.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxPessoasQuimica.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxPessoasQuimica.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxPessoasQuimica.setEnabled(false);

        jLabel184.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel184.setText("Quem?");

        jScrollPane7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jQuemNecessita.setColumns(20);
        jQuemNecessita.setRows(5);
        jQuemNecessita.setEnabled(false);
        jScrollPane7.setViewportView(jQuemNecessita);

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addComponent(jRBPsiquiatrico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRBPsicologico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel183)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxPessoasQuimica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addComponent(jLabel185)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxNecessitaAtende, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRBEnfermagem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRBMedico)
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addComponent(jLabel184)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane7)))
                .addContainerGap())
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel185)
                    .addComponent(jComboBoxNecessitaAtende, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRBEnfermagem)
                    .addComponent(jRBMedico))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel183)
                    .addComponent(jComboBoxPessoasQuimica, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRBPsicologico)
                    .addComponent(jRBPsiquiatrico))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addComponent(jLabel184)
                        .addContainerGap(39, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jTabbedPane4.addTab("Continuação", jPanel38);

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTabbedPane4, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel28, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel27, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("D.S.", jPanel26);

        jPanel39.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jBtAuditoriaEAPI1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaEAPI1.setToolTipText("Auditoria");
        jBtAuditoriaEAPI1.setContentAreaFilled(false);
        jBtAuditoriaEAPI1.setEnabled(false);
        jBtAuditoriaEAPI1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaEAPI1ActionPerformed(evt);
            }
        });

        jBtNovoEAPI1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoEAPI1.setText("Novo");
        jBtNovoEAPI1.setContentAreaFilled(false);
        jBtNovoEAPI1.setEnabled(false);
        jBtNovoEAPI1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovoEAPI1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovoEAPI1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovoEAPI1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoEAPI1ActionPerformed(evt);
            }
        });

        jBtAlterarEAPI1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarEAPI1.setText("Alterar");
        jBtAlterarEAPI1.setContentAreaFilled(false);
        jBtAlterarEAPI1.setEnabled(false);
        jBtAlterarEAPI1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterarEAPI1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarEAPI1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarEAPI1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarEAPI1ActionPerformed(evt);
            }
        });

        jBtExcluirEAPI1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirEAPI1.setText("Excluir");
        jBtExcluirEAPI1.setContentAreaFilled(false);
        jBtExcluirEAPI1.setEnabled(false);
        jBtExcluirEAPI1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluirEAPI1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirEAPI1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirEAPI1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirEAPI1ActionPerformed(evt);
            }
        });

        jBtSalvarEAPI1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarEAPI1.setText("Gravar");
        jBtSalvarEAPI1.setContentAreaFilled(false);
        jBtSalvarEAPI1.setEnabled(false);
        jBtSalvarEAPI1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvarEAPI1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarEAPI1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarEAPI1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarEAPI1ActionPerformed(evt);
            }
        });

        jBtCancelarEAPI1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarEAPI1.setText("Cancelar");
        jBtCancelarEAPI1.setContentAreaFilled(false);
        jBtCancelarEAPI1.setEnabled(false);
        jBtCancelarEAPI1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelarEAPI1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarEAPI1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarEAPI1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarEAPI1ActionPerformed(evt);
            }
        });

        jBtSairEAPI1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSairEAPI1.setText("Sair");
        jBtSairEAPI1.setContentAreaFilled(false);
        jBtSairEAPI1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSairEAPI1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSairEAPI1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSairEAPI1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairEAPI1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel39Layout.createSequentialGroup()
                .addComponent(jBtNovoEAPI1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarEAPI1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirEAPI1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarEAPI1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelarEAPI1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSairEAPI1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaEAPI1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtAuditoriaEAPI1))
            .addComponent(jBtNovoEAPI1)
            .addComponent(jBtAlterarEAPI1)
            .addComponent(jBtExcluirEAPI1)
            .addComponent(jBtSalvarEAPI1)
            .addComponent(jBtCancelarEAPI1)
            .addComponent(jBtSairEAPI1)
        );

        jPanel40.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "EAPI - Estratégia de Acompanhamento Psicossocial Individualizado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        jLabel187.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel187.setText("PSP - Post de Saíde Penitenciário (Atenção Básica, Saúde Mental)");

        jTextoPSP.setColumns(20);
        jTextoPSP.setRows(5);
        jTextoPSP.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextoPSP.setEnabled(false);
        jScrollPane12.setViewportView(jTextoPSP);

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addComponent(jLabel187)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane12))
                .addContainerGap())
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addComponent(jLabel187)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
        );

        jPanel41.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "CEDEGEP (Educação, Trabalho, Cultura e Lazer)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(204, 0, 153))); // NOI18N

        jTextoCEDEGEP.setColumns(20);
        jTextoCEDEGEP.setRows(5);
        jTextoCEDEGEP.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextoCEDEGEP.setEnabled(false);
        jScrollPane13.setViewportView(jTextoCEDEGEP);

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane13)
                .addContainerGap())
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane13)
        );

        jPanel42.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "CRAS e CREAS - Proteção Social(Benefícios, Incentivos às famílias)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jTextoCRASCREAS.setColumns(20);
        jTextoCRASCREAS.setRows(5);
        jTextoCRASCREAS.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextoCRASCREAS.setEnabled(false);
        jScrollPane14.setViewportView(jTextoCRASCREAS);

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel42Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane14)
                .addContainerGap())
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("EAPI-1", jPanel34);

        jPanel43.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Assistência Jurídica(Defensoria Pública, Patronato)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 153, 0))); // NOI18N

        jTextoASSISTENCIA.setColumns(20);
        jTextoASSISTENCIA.setRows(5);
        jTextoASSISTENCIA.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextoASSISTENCIA.setEnabled(false);
        jScrollPane15.setViewportView(jTextoASSISTENCIA);

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane15)
                .addContainerGap())
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel44.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Doc. Civil (Posto Pedro Melo, Receita Federal, Vara de Registro Público)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(153, 0, 0))); // NOI18N

        jTextoDOCUMENTOCIVIL.setColumns(20);
        jTextoDOCUMENTOCIVIL.setRows(5);
        jTextoDOCUMENTOCIVIL.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextoDOCUMENTOCIVIL.setEnabled(false);
        jScrollPane8.setViewportView(jTextoDOCUMENTOCIVIL);

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8)
                .addContainerGap())
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
        );

        jPanel46.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jBtAuditoriaEAPI2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaEAPI2.setToolTipText("Auditoria");
        jBtAuditoriaEAPI2.setContentAreaFilled(false);
        jBtAuditoriaEAPI2.setEnabled(false);
        jBtAuditoriaEAPI2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaEAPI2ActionPerformed(evt);
            }
        });

        jBtNovoEAPI2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoEAPI2.setText("Novo");
        jBtNovoEAPI2.setContentAreaFilled(false);
        jBtNovoEAPI2.setEnabled(false);
        jBtNovoEAPI2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovoEAPI2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovoEAPI2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovoEAPI2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoEAPI2ActionPerformed(evt);
            }
        });

        jBtAlterarEAPI2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarEAPI2.setText("Alterar");
        jBtAlterarEAPI2.setContentAreaFilled(false);
        jBtAlterarEAPI2.setEnabled(false);
        jBtAlterarEAPI2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterarEAPI2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarEAPI2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarEAPI2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarEAPI2ActionPerformed(evt);
            }
        });

        jBtExcluirEAPI2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirEAPI2.setText("Excluir");
        jBtExcluirEAPI2.setContentAreaFilled(false);
        jBtExcluirEAPI2.setEnabled(false);
        jBtExcluirEAPI2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluirEAPI2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirEAPI2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirEAPI2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirEAPI2ActionPerformed(evt);
            }
        });

        jBtSalvarEAPI2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarEAPI2.setText("Gravar");
        jBtSalvarEAPI2.setContentAreaFilled(false);
        jBtSalvarEAPI2.setEnabled(false);
        jBtSalvarEAPI2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvarEAPI2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarEAPI2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarEAPI2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarEAPI2ActionPerformed(evt);
            }
        });

        jBtCancelarEAPI2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarEAPI2.setText("Cancelar");
        jBtCancelarEAPI2.setContentAreaFilled(false);
        jBtCancelarEAPI2.setEnabled(false);
        jBtCancelarEAPI2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelarEAPI2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarEAPI2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarEAPI2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarEAPI2ActionPerformed(evt);
            }
        });

        jBtSairEAPI2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSairEAPI2.setText("Sair");
        jBtSairEAPI2.setContentAreaFilled(false);
        jBtSairEAPI2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSairEAPI2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSairEAPI2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSairEAPI2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairEAPI2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel46Layout.createSequentialGroup()
                .addComponent(jBtNovoEAPI2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarEAPI2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirEAPI2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarEAPI2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelarEAPI2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSairEAPI2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaEAPI2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtAuditoriaEAPI2))
            .addComponent(jBtNovoEAPI2)
            .addComponent(jBtAlterarEAPI2)
            .addComponent(jBtExcluirEAPI2)
            .addComponent(jBtSalvarEAPI2)
            .addComponent(jBtCancelarEAPI2)
            .addComponent(jBtSairEAPI2)
        );

        jPanel47.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "PAI - Programa de Assistência Individualizada ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jScrollPane16.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jTextEAPI2PAI.setColumns(20);
        jTextEAPI2PAI.setRows(5);
        jTextEAPI2PAI.setEnabled(false);
        jScrollPane16.setViewportView(jTextEAPI2PAI);

        jLabel186.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel186.setText("Atendimento individuais ou em grupo, atendimentos a familiares, oficinas,");

        jLabel188.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel188.setText(" registros das evoluções a atualização das EAPIs.");

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane16)
                    .addGroup(jPanel47Layout.createSequentialGroup()
                        .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel186)
                            .addComponent(jLabel188))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addComponent(jLabel186)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel188)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        jLabel189.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel189.setText("Assistente Social/CRESS:");

        jLabel190.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel190.setForeground(new java.awt.Color(204, 0, 0));
        jLabel190.setText("Técnicos de Referência:");

        jTecnicoServicoSocial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTecnicoServicoSocial.setEnabled(false);

        jLabel191.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel191.setText("Psicólogo/CRP:");

        jTecnicoPsicologico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTecnicoPsicologico.setEnabled(false);

        jBtAssistente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtAssistente.setToolTipText("Pesquisar Assistente Social");
        jBtAssistente.setContentAreaFilled(false);
        jBtAssistente.setEnabled(false);
        jBtAssistente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAssistenteActionPerformed(evt);
            }
        });

        jBtPsicologo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPsicologo.setToolTipText("Pesquisar Psicólogo");
        jBtPsicologo.setContentAreaFilled(false);
        jBtPsicologo.setEnabled(false);
        jBtPsicologo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPsicologoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel46, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel189, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel191, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel45Layout.createSequentialGroup()
                                .addComponent(jLabel190)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jTecnicoServicoSocial)
                            .addComponent(jTecnicoPsicologico))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBtAssistente, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtPsicologo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addComponent(jPanel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel190)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTecnicoServicoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtAssistente)
                    .addComponent(jLabel189))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel191)
                    .addComponent(jTecnicoPsicologico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPsicologo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("EAPI-2", jPanel45);

        jTabelaEvolucaoPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaEvolucaoPAI.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Código", "Data", "Evolução"
            }
        ));
        jTabelaEvolucaoPAI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaEvolucaoPAIMouseClicked(evt);
            }
        });
        jScrollPane17.setViewportView(jTabelaEvolucaoPAI);
        if (jTabelaEvolucaoPAI.getColumnModel().getColumnCount() > 0) {
            jTabelaEvolucaoPAI.getColumnModel().getColumn(0).setMinWidth(60);
            jTabelaEvolucaoPAI.getColumnModel().getColumn(0).setMaxWidth(60);
            jTabelaEvolucaoPAI.getColumnModel().getColumn(1).setMinWidth(80);
            jTabelaEvolucaoPAI.getColumnModel().getColumn(1).setMaxWidth(80);
            jTabelaEvolucaoPAI.getColumnModel().getColumn(2).setMinWidth(350);
            jTabelaEvolucaoPAI.getColumnModel().getColumn(2).setMaxWidth(350);
        }

        jPanel51.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Evolução do Acompanhameto PsicoSocial", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 51, 204))); // NOI18N

        jLabel194.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel194.setText("Nome Completo do Interno");

        jNomeInternoEvolucaoPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoEvolucaoPAI.setEnabled(false);

        jLabel195.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel195.setText("Código");

        jIdEvolucao.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdEvolucao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdEvolucao.setEnabled(false);

        jLabel196.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel196.setText("Data Evolução");

        jDataEvolucao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataEvolucao.setEnabled(false);

        javax.swing.GroupLayout jPanel51Layout = new javax.swing.GroupLayout(jPanel51);
        jPanel51.setLayout(jPanel51Layout);
        jPanel51Layout.setHorizontalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel195)
                    .addComponent(jIdEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel196, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel51Layout.createSequentialGroup()
                        .addComponent(jLabel194)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jNomeInternoEvolucaoPAI))
                .addContainerGap())
        );
        jPanel51Layout.setVerticalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel51Layout.createSequentialGroup()
                            .addComponent(jLabel195)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jIdEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel51Layout.createSequentialGroup()
                            .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel196)
                                .addComponent(jLabel194))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jDataEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel51Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jNomeInternoEvolucaoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jBtAuditoriaEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaEvolucao.setToolTipText("Auditoria");
        jBtAuditoriaEvolucao.setContentAreaFilled(false);
        jBtAuditoriaEvolucao.setEnabled(false);
        jBtAuditoriaEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaEvolucaoActionPerformed(evt);
            }
        });

        jBtCancelarEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarEvolucao.setEnabled(false);
        jBtCancelarEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarEvolucaoActionPerformed(evt);
            }
        });

        jBtImpressaoEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/gtklp-icone-3770-16.png"))); // NOI18N
        jBtImpressaoEvolucao.setToolTipText("Impressão Evolução");
        jBtImpressaoEvolucao.setEnabled(false);
        jBtImpressaoEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtImpressaoEvolucaoActionPerformed(evt);
            }
        });

        jBtSalvarEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarEvolucao.setToolTipText("Gravar Evolução");
        jBtSalvarEvolucao.setEnabled(false);
        jBtSalvarEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarEvolucaoActionPerformed(evt);
            }
        });

        jBtExcluirEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirEvolucao.setToolTipText("Excluir Evolução");
        jBtExcluirEvolucao.setEnabled(false);
        jBtExcluirEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirEvolucaoActionPerformed(evt);
            }
        });

        jBtAlterarEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/refresh-reload-icone-6258-16.png"))); // NOI18N
        jBtAlterarEvolucao.setToolTipText("Alterar Evolução");
        jBtAlterarEvolucao.setEnabled(false);
        jBtAlterarEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarEvolucaoActionPerformed(evt);
            }
        });

        jBtNovaEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovaEvolucao.setToolTipText("Nova Evolução");
        jBtNovaEvolucao.setEnabled(false);
        jBtNovaEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovaEvolucaoActionPerformed(evt);
            }
        });

        jTextoEvolucao.setColumns(20);
        jTextoEvolucao.setRows(5);
        jTextoEvolucao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextoEvolucao.setEnabled(false);
        jScrollPane18.setViewportView(jTextoEvolucao);

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                    .addComponent(jPanel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel50Layout.createSequentialGroup()
                        .addComponent(jBtNovaEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtAlterarEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtExcluirEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSalvarEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtCancelarEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtImpressaoEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtAuditoriaEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))
                    .addComponent(jScrollPane18))
                .addContainerGap())
        );

        jPanel50Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterarEvolucao, jBtCancelarEvolucao, jBtExcluirEvolucao, jBtImpressaoEvolucao, jBtNovaEvolucao, jBtSalvarEvolucao});

        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtAuditoriaEvolucao)
                    .addComponent(jBtCancelarEvolucao)
                    .addComponent(jBtSalvarEvolucao)
                    .addComponent(jBtExcluirEvolucao)
                    .addComponent(jBtAlterarEvolucao)
                    .addComponent(jBtNovaEvolucao)
                    .addComponent(jBtImpressaoEvolucao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, 3, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel50Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterarEvolucao, jBtCancelarEvolucao, jBtExcluirEvolucao, jBtImpressaoEvolucao, jBtNovaEvolucao, jBtSalvarEvolucao});

        jTabbedPane1.addTab("E-PAI", jPanel50);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Foto Interno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        jFotoInternoPAI.setToolTipText("Foto do Interno");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoPAI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoPAI, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
        );

        jPanel48.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel192.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel192.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/SERVIÇO_SOCIAL.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel192)
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addComponent(jLabel192, javax.swing.GroupLayout.PREFERRED_SIZE, 150, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel49.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel193.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel193.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/PSICOLOGIA_PSI.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addComponent(jLabel193, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addComponent(jLabel193, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel49, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel48, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        setBounds(300, 30, 700, 581);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesqCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqCodigoActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (jCodigoPesqPAI.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe um código para pesquisa.");
            jCodigoPesqPAI.requestFocus();
        } else {
            preencherTabelaAtendentimentoPAI("SELECT * FROM FICHA_CADASTRO_PAI_PSICOSOCIAL "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=FICHA_CADASTRO_PAI_PSICOSOCIAL.IdInternoCrc "
                    + "WHERE IdPai='" + jCodigoPesqPAI.getText() + "'");
        }
    }//GEN-LAST:event_jBtPesqCodigoActionPerformed

    private void jBtPesqDataPAIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqDataPAIActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (jDataInicial.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Informe a data inicial para pesquisa.");
            jDataInicial.requestFocus();
        } else {
            if (jDataFinal.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data final para pesquisa.");
                jDataFinal.requestFocus();
            } else {
                if (jDataInicial.getDate().after(jDataFinal.getDate())) {
                    JOptionPane.showMessageDialog(rootPane, "Data Inicial não pode ser maior que data final");
                } else {
                    SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
                    dataInicial = formatoAmerica.format(jDataInicial.getDate().getTime());
                    dataFinal = formatoAmerica.format(jDataFinal.getDate().getTime());
                    preencherTabelaAtendentimentoPAI("SELECT * FROM FICHA_CADASTRO_PAI_PSICOSOCIAL "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON PRONTUARIOSCRC.IdInternoCrc=FICHA_CADASTRO_PAI_PSICOSOCIAL.IdInternoCrc "
                            + "WHERE DataPai BETWEEN'" + dataInicial + "'AND '" + dataFinal + "'");
                }
            }
        }
    }//GEN-LAST:event_jBtPesqDataPAIActionPerformed

    private void jBtPesqNomeInternoPAIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNomeInternoPAIActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (jNomeInternoPesquisa.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o nome do interno para pesquisa do registro.");
            jNomeInternoPesquisa.requestFocus();
        } else {
            preencherTabelaAtendentimentoPAI("SELECT * FROM FICHA_CADASTRO_PAI_PSICOSOCIAL "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=FICHA_CADASTRO_PAI_PSICOSOCIAL.IdInternoCrc "
                    + "WHERE NomeInternoCrc LIKE'%" + jNomeInternoPesquisa.getText() + "%'");
        }
    }//GEN-LAST:event_jBtPesqNomeInternoPAIActionPerformed

    private void jCheckBoxTodosRegistrosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxTodosRegistrosItemStateChanged
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherTabelaAtendentimentoPAI("SELECT * FROM FICHA_CADASTRO_PAI_PSICOSOCIAL "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=FICHA_CADASTRO_PAI_PSICOSOCIAL.IdInternoCrc");
        } else {
            limparTabelaPAISocial();
        }
    }//GEN-LAST:event_jCheckBoxTodosRegistrosItemStateChanged

    private void jTabelaPAIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaPAIMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            String idAtend = "" + jTabelaPAI.getValueAt(jTabelaPAI.getSelectedRow(), 0);
            jCodigoPesqPAI.setText(idAtend);
            //
            bloquearBotoes();
            bloquearCampos();
            limparCamposNovo();
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtAuditoria.setEnabled(true);
            //
            jBtNovoSS.setEnabled(true);
            jBtNovoTO.setEnabled(true);
            jBtNovoPSI.setEnabled(true);
            jBtNovoSS3.setEnabled(true);
            jBtNovoDJ.setEnabled(true);
            jBtNovoEAPI1.setEnabled(true);
            jBtNovoEAPI2.setEnabled(true);
            jBtNovaEvolucao.setEnabled(true);
            //
            jComboBoxCorEtiniaInternoPAI.removeAllItems();
            jComboBoxReligiao.removeAllItems();
            jComboBoxEstadoCivil.removeAllItems();
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM FICHA_CADASTRO_PAI_PSICOSOCIAL "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=FICHA_CADASTRO_PAI_PSICOSOCIAL.IdInternoCrc "
                        + "INNER JOIN DADOSFISICOSINTERNOS "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSFISICOSINTERNOS.IdInternoCrc "
                        + "INNER JOIN DADOSPENAISINTERNOS "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                        + "INNER JOIN CIDADES "
                        + "ON PRONTUARIOSCRC.IdCidade=CIDADES.IdCidade "
                        + "WHERE IdPai='" + idAtend + "'");
                conecta.rs.first();
                jCodigoPAI.setText(String.valueOf(conecta.rs.getInt("IdPai")));
                jComboBoxStatusPAI.setSelectedItem(conecta.rs.getString("StatusPai"));
                jDataPAI.setDate(conecta.rs.getDate("DataPai"));
                jIdInternoPAI.setText(conecta.rs.getString("IdInternoCrc"));
                jDataAdmissao.setDate(conecta.rs.getDate("DataEntrada"));
                jMatriculaPenal.setText(conecta.rs.getString("MatriculaCrc"));
                jNomeInternoPAI.setText(conecta.rs.getString("NomeInternoCrc"));
                jNomeMaeInternoPAI.setText(conecta.rs.getString("MaeInternoCrc"));
                jNomePaiInternoPAI.setText(conecta.rs.getString("PaiInternoCrc"));
                jNaturalidadeInternoPAI.setText(conecta.rs.getString("NomeCidade"));
                jComboBoxCorEtiniaInternoPAI.addItem(conecta.rs.getString("Cutis"));
                // Capturando foto
                caminho = conecta.rs.getString("FotoInternoCrc");
                javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                jFotoInternoPAI.setIcon(i);
                jFotoInternoPAI.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoInternoPAI.getWidth(), jFotoInternoPAI.getHeight(), Image.SCALE_DEFAULT)));
                jRGInternoPAI.setText(conecta.rs.getString("RgInternoCrc"));
                jCPFInternoPAI.setText(conecta.rs.getString("CpfInternoCrc"));
                jCartaoSUSPAI.setText(conecta.rs.getString("CartaoSus"));
                jDataNascimentoPAI.setDate(conecta.rs.getDate("DataNasciCrc"));
                jIdadeInterno.setText(conecta.rs.getString("IdadeInterno"));
                jNaturalidadeInternoPAI.setText(conecta.rs.getString("Naturalidade"));
                jComboBoxOrientacaoSexual.setSelectedItem(conecta.rs.getString("OrientacaoSexual"));
                jMunicipioRegistrado.setText(conecta.rs.getString("MunicipioRegistrado"));
                jTipoOrientacaoSexual.setText(conecta.rs.getString("TipoOrientacaoSexual"));
                jComboBoxDocumentoDelega.setSelectedItem(conecta.rs.getString("DocumentoDelega"));
                jQualDocumento.setText(conecta.rs.getString("QualDocumento"));
                jQualDelegacia.setText(conecta.rs.getString("QualDelegacia"));
                jComboBoxRegularizarDocumento.setSelectedItem(conecta.rs.getString("RegularizarDocumento"));
                jComboBoxTipoDocumento.setSelectedItem(conecta.rs.getString("TipoDocumento"));
                jRGInternoPAI.setText(conecta.rs.getString("RGInternoPAI"));
                jEmissor.setText(conecta.rs.getString("Emissor"));
                jDataExpedicao.setDate(conecta.rs.getDate("DataExpedicao"));
                jCPFInternoPAI.setText(conecta.rs.getString("CPFInternoPAI"));
                jCartaoSUSPAI.setText(conecta.rs.getString("CartaoSUSPAI"));
                jTituloEleitor.setText(conecta.rs.getString("TituloEleitor"));
                jZona.setText(conecta.rs.getString("Zona"));
                jSessao.setText(conecta.rs.getString("Sessao"));
                jNIS.setText(conecta.rs.getString("NIS"));
                jCTPS.setText(conecta.rs.getString("CTPS"));
                jSerie.setText(conecta.rs.getString("Serie"));
                jComboBoxReligiao.addItem(conecta.rs.getString("Religiao"));
                jComboBoxEstadoCivil.addItem(conecta.rs.getString("EstadoCivil"));
                jEndereco.setText(conecta.rs.getString("Endereco"));
                jComplemento.setText(conecta.rs.getString("Complemento"));
                jReferencia.setText(conecta.rs.getString("Referencia"));
                jBairro.setText(conecta.rs.getString("Bairro"));
                jCidade.setText(conecta.rs.getString("Cidade"));
                jComboBoxEstadoNaturalidade.setSelectedItem(conecta.rs.getString("Estado"));
                jTelefone.setText(conecta.rs.getString("Telefone"));
                jTelefone1.setText(conecta.rs.getString("Telefone1"));
                jCelular.setText(conecta.rs.getString("Celular"));
                //
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa dos dados..." + e);
            }
            // C.C.G.F            
            try {
                conecta.executaSQL("SELECT * FROM FICHA_CADASTRO_PAI_CCGF "
                        + "INNER JOIN FICHA_CADASTRO_PAI_PSICOSOCIAL "
                        + "ON FICHA_CADASTRO_PAI_CCGF.IdPai=FICHA_CADASTRO_PAI_PSICOSOCIAL.IdPai "
                        + "WHERE FICHA_CADASTRO_PAI_CCGF.IdPai='" + jCodigoPAI.getText() + "'");
                conecta.rs.first();
                codigoSS1 = conecta.rs.getInt("IdCCGF");
                jComboBoxTemFilhos.setSelectedItem(conecta.rs.getString("TemFilhos"));
                jQuantosFilhos.setText(conecta.rs.getString("QuantosFilhos"));
                jComboBoxReconhecerPaterna.setSelectedItem(conecta.rs.getString("ReconhecerPaterna"));
                jDadosPaternidade.setText(conecta.rs.getString("DadosPaternidade"));
                jComboBoxEstaoFilhos.setSelectedItem(conecta.rs.getString("EstaoFilho"));
                jComboBoxNecessidaEspecial.setSelectedItem(conecta.rs.getString("NecessidaEspecial"));
                jQualNecessidadeESP.setText(conecta.rs.getString("NecessidadeESP"));
                jComboBoxCRAS.setSelectedItem(conecta.rs.getString("CRAS"));
                jComboBoxCREAS.setSelectedItem(conecta.rs.getString("CREAS"));
                jComboBoxRecebeBeneficio.setSelectedItem(conecta.rs.getString("RecebeBeneficio"));
                jQuaisBeneficiosFamilia.setText(conecta.rs.getString("QuaisBeneficiosFamilia"));
                jComboBoxAntesBeneficio.setSelectedItem(conecta.rs.getString("AntesBeneficio"));
                jQuaisBeneficiosAntesPrisao.setText(conecta.rs.getString("QuaisBeneficiosAntesPrisao"));
                jComboBoxNecessitaBeneficio.setSelectedItem(conecta.rs.getString("NecessitaBeneficio"));
                jNecessitaBeneficio.setText(conecta.rs.getString("QuemNecessitaBeneficio"));
                //
                jComboBoxMoradia.setSelectedItem(conecta.rs.getString("Moradia"));
                jComboBoxModalidade.setSelectedItem(conecta.rs.getString("Modalidade"));
                jComboBoxAbastecimento.setSelectedItem(conecta.rs.getString("Abastecimento"));
                jComboBoxEliminaDejetos.setSelectedItem(conecta.rs.getString("EliminaDejetos"));
                jComboBoxDescarte.setSelectedItem(conecta.rs.getString("Descarte"));
                jComboBoxFamiliaVulneraSocial.setSelectedItem(conecta.rs.getString("FamiliaVulneraSocial"));
                jComboBoxViveuRua.setSelectedItem(conecta.rs.getString("ViveuRua"));
                jQuantoTempo.setText(conecta.rs.getString("QuantoTempo"));
                jMotivo.setText(conecta.rs.getString("Motivo"));
                jComboBoxFamiliaDetido.setSelectedItem(conecta.rs.getString("FamiliaDetido"));
                jComboBoxRestabelecerVinculo.setSelectedItem(conecta.rs.getString("RestabelecerVinculo"));
                jComboBoxComoRestabelecer.setSelectedItem(conecta.rs.getString("ComoRestabelecer"));
                if (codigoSS1 != 0) {
                    jBtNovoSS.setEnabled(true);
                    jBtAlterarSS.setEnabled(true);
                    jBtExcluirSS.setEnabled(true);
                    jBtSalvarSS.setEnabled(!true);
                    jBtCancelarSS.setEnabled(!true);
                    jBtAuditoriaSS.setEnabled(true);
                }
            } catch (Exception e) {
            }
            preencherTabelaFamiliar("SELECT * FROM FICHA_CADASTRO_PAI_CCGF_VF "
                    + "INNER JOIN FICHA_CADASTRO_PAI_PSICOSOCIAL "
                    + "ON FICHA_CADASTRO_PAI_CCGF_VF.IdPai=FICHA_CADASTRO_PAI_PSICOSOCIAL.IdPai "
                    + "WHERE FICHA_CADASTRO_PAI_CCGF_VF.IdPai='" + jCodigoPAI.getText() + "'");
            //
            preencherTabelaVisitas("SELECT * FROM FICHA_CADASTRO_PAI_CCGF_VF1 "
                    + "INNER JOIN FICHA_CADASTRO_PAI_PSICOSOCIAL "
                    + "ON FICHA_CADASTRO_PAI_CCGF_VF1.IdPai=FICHA_CADASTRO_PAI_PSICOSOCIAL.IdPai "
                    + "INNER JOIN VISITASINTERNO "
                    + "ON FICHA_CADASTRO_PAI_CCGF_VF1.IdVisita=VISITASINTERNO.IdVisita "
                    + "WHERE FICHA_CADASTRO_PAI_CCGF_VF1.IdPai='" + jCodigoPAI.getText() + "'");
            preencherTabelaVisitasIntimas("SELECT * FROM FICHA_CADASTRO_PAI_CCGF_VF2 "
                    + "INNER JOIN FICHA_CADASTRO_PAI_PSICOSOCIAL "
                    + "ON FICHA_CADASTRO_PAI_CCGF_VF2.IdPai=FICHA_CADASTRO_PAI_PSICOSOCIAL.IdPai "
                    + "INNER JOIN VISITASINTERNO "
                    + "ON FICHA_CADASTRO_PAI_CCGF_VF2.IdVisita=VISITASINTERNO.IdVisita "
                    + "WHERE FICHA_CADASTRO_PAI_CCGF_VF2.IdPai='" + jCodigoPAI.getText() + "'");
            // D.E.M.E.
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM FICHA_CADASTRO_PAI_DEME "
                        + "INNER JOIN FICHA_CADASTRO_PAI_PSICOSOCIAL "
                        + "ON FICHA_CADASTRO_PAI_DEME.IdPai=FICHA_CADASTRO_PAI_PSICOSOCIAL.IdPai "
                        + "WHERE FICHA_CADASTRO_PAI_DEME.IdPai='" + jCodigoPAI.getText() + "'");
                conecta.rs.first();
                codTeraPed = conecta.rs.getInt("IdDEME");
                jComboBoxNecessitaFamilia.setSelectedItem(conecta.rs.getString("NecessitaFamilia"));
                jParaQuemFamilia.setText(conecta.rs.getString("ParaQuemFamilia"));
                jComboBoxEstaGravida.setSelectedItem(conecta.rs.getString("EstaGravida"));
                jComboBoxComprovacao.setSelectedItem(conecta.rs.getString("Comprovacao"));
                jComboBoxPreNatal.setSelectedItem(conecta.rs.getString("PreNatal"));
                jOndePreNatal.setText(conecta.rs.getString("OndePreNatal"));
                jComboBoxDestinoBebe.setSelectedItem(conecta.rs.getString("DestinoBebe"));
                jComboBoxSuspeitaGravidez.setSelectedItem(conecta.rs.getString("SuspeitaGravidez"));
                jQuantosPartos.setText(conecta.rs.getString("QuantosPartos"));
                jQuantosAbortos.setText(conecta.rs.getString("QuantosAbortos"));
                jQuantosPartosNornais.setText(conecta.rs.getString("QuantosPartosNornais"));
                jQuantasCesarianas.setText(conecta.rs.getString("QuantasCesarianas"));
                jComboBoxContraceptivos.setSelectedItem(conecta.rs.getString("Contraceptivos"));
                jQualContraceptivos.setText(conecta.rs.getString("QualContraceptivos"));
                jComboBoxDemanda.setSelectedItem(conecta.rs.getString("Demanda"));
                jQualDemanda.setText(conecta.rs.getString("QualDemanda"));
                jComboBoxInstrucao.setSelectedItem(conecta.rs.getString("Instrucao"));
                jComboBoxEstudandoPreso.setSelectedItem(conecta.rs.getString("EstudandoPreso"));
                jComboBoxParticipouPrisional.setSelectedItem(conecta.rs.getString("ParticipouPrisional"));
                jComboBoxGostariaPrisional.setSelectedItem(conecta.rs.getString("GostariaPrisional"));
                if (codTeraPed != 0) {
                    jBtNovoTO.setEnabled(true);
                    jBtAlterarTO.setEnabled(true);
                    jBtExcluirTO.setEnabled(true);
                    jBtSalvarTO.setEnabled(!true);
                    jBtCancelarTO.setEnabled(!true);
                    jBtAuditoriaTO.setEnabled(true);
                }
            } catch (Exception e) {
            }
            // D.P.T.L.
            try {
                conecta.executaSQL("SELECT * FROM FICHA_CADASTRO_PAI_DPTL "
                        + "INNER JOIN FICHA_CADASTRO_PAI_PSICOSOCIAL "
                        + "ON FICHA_CADASTRO_PAI_DPTL.IdPai=FICHA_CADASTRO_PAI_PSICOSOCIAL.IdPai "
                        + "WHERE FICHA_CADASTRO_PAI_DPTL.IdPai='" + jCodigoPAI.getText() + "'");
                conecta.rs.first();
                codigoPSI = conecta.rs.getInt("IdDPTL");
                jProfissaoOcupacao.setText(conecta.rs.getString("ProfissaoOcupacao"));
                jComboBoxTrabalhaDetido.setSelectedItem(conecta.rs.getString("TrabalhaDetido"));
                jComboBoxDesempregado.setSelectedItem(conecta.rs.getString("Desempregado"));
                jComboBoxCarteiraAssinada.setSelectedItem(conecta.rs.getString("CarteiraAssinada"));
                jQuantoTempoCarteira.setText(conecta.rs.getString("QuantoTempoCarteira"));
                //jFaixaSalarial.setText(conecta.rs.getString("FaixaSalarial"));
                valorSalarial = conecta.rs.getFloat("FaixaSalarial");
                DecimalFormat vc = new DecimalFormat("#,##0.00");
                String vlCusto = vc.format(valorSalarial);
                jFaixaSalarial.setText(vlCusto);
                jComboBoxTemBeneficios.setSelectedItem(conecta.rs.getString("TemBeneficios"));
                jQuemTemBeneficios.setText(conecta.rs.getString("QuemTemBeneficios"));
                jComboBoxDemandaReclusao.setSelectedItem(conecta.rs.getString("DemandaReclusao"));
                jComboBoxDemandaDesemprego.setSelectedItem(conecta.rs.getString("DemandaDesemprego"));
                jComboBoxPossuiRedimento.setSelectedItem(conecta.rs.getString("PossuiRedimento"));
                jQualRendimento.setText(conecta.rs.getString("QualRendimento"));
                jComboBoxExerceAtividade.setSelectedItem(conecta.rs.getString("ExerceAtividade"));
                jQualAtividadeExerce.setText(conecta.rs.getString("QualAtividadeExerce"));
                jComboBoxGeracaoRenda.setSelectedItem(conecta.rs.getString("GeracaoRenda"));
                jComboBoxAptidaoProfissional.setSelectedItem(conecta.rs.getString("AptidaoProfissional"));
                jQualAptidao.setText(conecta.rs.getString("QualAptidao"));
                jComboBoxDemandaProfissional.setSelectedItem(conecta.rs.getString("DemandaProfissional"));
                jQualDemandaProfissional.setText(conecta.rs.getString("QualDemandaProfissional"));
                jComboBoxAptidaoArt.setSelectedItem(conecta.rs.getString("AptidaoArt"));
                jQualAptidaoArt.setText(conecta.rs.getString("QualAptidaoArt"));
                jComboBoxDemandaLazer.setSelectedItem(conecta.rs.getString("DemandaLazer"));
                jQualDemandaLazer.setText(conecta.rs.getString("QualDemandaLazer"));
                if (codigoPSI != 0) {
                    jBtNovoPSI.setEnabled(true);
                    jBtAlterarPSI.setEnabled(true);
                    jBtExcluirPSI.setEnabled(true);
                    jBtSalvarPSI.setEnabled(!true);
                    jBtCancelarPSI.setEnabled(!true);
                    jBtAuditoriaPSI.setEnabled(true);
                }
            } catch (Exception e) {
            }
            //D.J.        
            try {
                conecta.executaSQL("SELECT * FROM FICHA_CADASTRO_PAI_DJ "
                        + "INNER JOIN FICHA_CADASTRO_PAI_PSICOSOCIAL "
                        + "ON FICHA_CADASTRO_PAI_DJ.IdPai=FICHA_CADASTRO_PAI_PSICOSOCIAL.IdPai "
                        + "WHERE FICHA_CADASTRO_PAI_DJ.IdPai='" + jCodigoPAI.getText() + "'");
                conecta.rs.first();
                codigoDJ = conecta.rs.getInt("IdDJ");
                jComboBoxRegimeAprisionamento.setSelectedItem(conecta.rs.getString("RegimeAprisionamento"));
                jArtigo.setText(conecta.rs.getString("Artigo"));
                jDelito.setText(conecta.rs.getString("Delito"));
                jComboBoxReincidente.setSelectedItem(conecta.rs.getString("Reincidente"));
                jComboBoxPossuiPena.setSelectedItem(conecta.rs.getString("PossuiPena"));
                jComboBoxQualPena.setSelectedItem(conecta.rs.getString("QualPena"));
                jComboBoxPossuiJuridica.setSelectedItem(conecta.rs.getString("PossuiJuridica"));
                jComboBoxQualAssistenciaJuridica.setSelectedItem(conecta.rs.getString("QualAssistenciaJuridica"));
                jComboBoxPROMAE.setSelectedItem(conecta.rs.getString("PROMAE"));
                jComboBoxAssistenciaJuridica.setSelectedItem(conecta.rs.getString("AssistenciaJuridica"));
                jComboBoxTrabalhaempresa.setSelectedItem(conecta.rs.getString("Trabalhaempresa"));
                jTelefoneContatoEmpresa.setText(conecta.rs.getString("TelefoneContatoEmpresa"));
                jQualEmpresa.setText(conecta.rs.getString("QualEmpresa"));
                jQualFuncaoExerce.setText(conecta.rs.getString("QualFuncaoExerce"));
                jComboBoxCartaInformal.setSelectedItem(conecta.rs.getString("CartaInformal"));
                jParaOnde.setText(conecta.rs.getString("ParaOnde"));
                jTelefoneContato.setText(conecta.rs.getString("TelefoneContato"));
                jComboBoxEstudaUP.setSelectedItem(conecta.rs.getString("EstudaUP"));
                jOndeEstuda.setText(conecta.rs.getString("OndeEstuda"));
                jComboBoxNecessitaTrabalho.setSelectedItem(conecta.rs.getString("NecessitaTrabalho"));
                jQualNecessitaTrabalho.setText(conecta.rs.getString("QualNecessitaTrabalho"));
                jComboBoxNecessitaEstudaFUP.setSelectedItem(conecta.rs.getString("NecessitaEstudaFUP"));
                jQualNecessidadeEstudaFUP.setText(conecta.rs.getString("QualNecessidadeEstudaFUP"));
                if (codigoDJ != 0) {
                    jBtNovoDJ.setEnabled(true);
                    jBtAlterarDJ.setEnabled(true);
                    jBtExcluirDJ.setEnabled(true);
                    jBtSalvarDJ.setEnabled(!true);
                    jBtCancelarDJ.setEnabled(!true);
                    jBtAuditoriaDJ.setEnabled(true);
                }
            } catch (Exception e) {
            }
            // D.S.
            try {
                conecta.executaSQL("SELECT * FROM FICHA_CADASTRO_PAI_DS "
                        + "INNER JOIN FICHA_CADASTRO_PAI_PSICOSOCIAL "
                        + "ON FICHA_CADASTRO_PAI_DS.IdPai=FICHA_CADASTRO_PAI_PSICOSOCIAL.IdPai "
                        + "WHERE FICHA_CADASTRO_PAI_DS.IdPai='" + jCodigoPAI.getText() + "'");
                conecta.rs.first();
                codigoSS3 = conecta.rs.getInt("IdDS");
                jComboBoxRefereSaude.setSelectedItem(conecta.rs.getString("RefereSaude"));
                tipoHanseniase = conecta.rs.getInt("Hanseniase");
                if (tipoHanseniase == 1) {
                    jRBHanseniase.setSelected(true);
                } else if (tipoHanseniase == 0) {
                    jRBHanseniase.setSelected(!true);
                }
                tipoDiabetes = conecta.rs.getInt("Diabetes");
                if (tipoDiabetes == 1) {
                    jRBDiabetes.setSelected(true);
                } else if (tipoDiabetes == 0) {
                    jRBDiabetes.setSelected(!true);
                }
                tipoTuberculose = conecta.rs.getInt("Tuberculose");
                if (tipoTuberculose == 1) {
                    jRBTuberculose.setSelected(true);
                } else if (tipoTuberculose == 0) {
                    jRBTuberculose.setSelected(!true);
                }
                tipoHipertensao = conecta.rs.getInt("Hipertensao");
                if (tipoHipertensao == 1) {
                    jRBHanseniase.setSelected(true);
                } else if (tipoHipertensao == 0) {
                    jRBHanseniase.setSelected(!true);
                }
                tipoHepatites = conecta.rs.getInt("Hepatites");
                if (tipoHepatites == 1) {
                    jRBHepatites.setSelected(true);
                } else if (tipoHepatites == 0) {
                    jRBHepatites.setSelected(!true);
                }
                tipoSifilis = conecta.rs.getInt("Sifilis");
                if (tipoSifilis == 1) {
                    jRBSifilis.setSelected(true);
                } else if (tipoSifilis == 0) {
                    jRBSifilis.setSelected(!true);
                }
                tipoEscabiose = conecta.rs.getInt("Escabiose");
                if (tipoEscabiose == 1) {
                    jRBEscabiose.setSelected(true);
                } else if (tipoEscabiose == 0) {
                    jRBEscabiose.setSelected(!true);
                }
                tipoHiv = conecta.rs.getInt("HIV");
                if (tipoHiv == 1) {
                    jRBHIV.setSelected(true);
                } else if (tipoHiv == 0) {
                    jRBHIV.setSelected(!true);
                }
                jOutrasDoencas.setText(conecta.rs.getString("OutrasDoencas"));
                jComboBoxFazendoTratamento.setSelectedItem(conecta.rs.getString("FazendoTratamento"));
                jComboBoxPsiquiatrico.setSelectedItem(conecta.rs.getString("Psiquiatrico"));
                jOndePsiquiatrico.setText(conecta.rs.getString("OndePsiquiatrico"));
                jComboBoxPsicotropico.setSelectedItem(conecta.rs.getString("Psicotropico"));
                jQualPsicotropico.setText(conecta.rs.getString("QualPsicotropico"));
                jComboBoxMental.setSelectedItem(conecta.rs.getString("Mental"));
                tipoDesanimo = conecta.rs.getInt("Desanimo");
                if (tipoDesanimo == 1) {
                    jRBDesanimo.setSelected(true);
                } else if (tipoDesanimo == 0) {
                    jRBDesanimo.setSelected(!true);
                }
                tipoInsonia = conecta.rs.getInt("Insonia");
                if (tipoInsonia == 1) {
                    jRBInsonia.setSelected(true);
                } else if (tipoInsonia == 0) {
                    jRBInsonia.setSelected(!true);
                }
                tipoFaltaApetite = conecta.rs.getInt("FaltaApetite");
                if (tipoFaltaApetite == 1) {
                    jRBFaltaApetite.setSelected(true);
                } else if (tipoFaltaApetite == 0) {
                    jRBFaltaApetite.setSelected(!true);
                }
                tipoIsolamentoSocial = conecta.rs.getInt("IsolamentoSocial");
                if (tipoIsolamentoSocial == 1) {
                    jRBIsomantoSocial.setSelected(true);
                } else if (tipoIsolamentoSocial == 0) {
                    jRBIsomantoSocial.setSelected(!true);
                }
                tipoPensamentosSuicida = conecta.rs.getInt("PensamentosSuicidas");
                if (tipoPensamentosSuicida == 1) {
                    jRBPensamentosSuicida.setSelected(true);
                } else if (tipoPensamentosSuicida == 0) {
                    jRBPensamentosSuicida.setSelected(!true);
                }
                tipoAgressividade = conecta.rs.getInt("Agressividade");
                if (tipoAgressividade == 1) {
                    jRBAgressividade.setSelected(true);
                } else if (tipoAgressividade == 0) {
                    jRBAgressividade.setSelected(!true);
                }
                tipoInquietacaoMotora = conecta.rs.getInt("Inquietacao");
                if (tipoInquietacaoMotora == 1) {
                    jRBInquientacao.setSelected(true);
                } else if (tipoInquietacaoMotora == 0) {
                    jRBInquientacao.setSelected(!true);
                }
                tipoOutrasDoencas = conecta.rs.getInt("OutroDoencas");
                if (tipoOutrasDoencas == 1) {
                    jRBOutrosDoencas.setSelected(true);
                } else if (tipoOutrasDoencas == 0) {
                    jRBOutrosDoencas.setSelected(!true);
                }
                jQualOutrosDoencas.setText(conecta.rs.getString("QualOutrosDoencas"));
                jComboBoxInternadoPSI.setSelectedItem(conecta.rs.getString("InternadoPSI"));
                jDataInternaPSI.setDate(conecta.rs.getDate("DataInternaPSI"));
                jComboBoxAcompanhaCAPS.setSelectedItem(conecta.rs.getString("AcompanhaCAPS"));
                jDataCAPS.setDate(conecta.rs.getDate("DataCAPS"));
                jComboBoxUsoPsicoativos.setSelectedItem(conecta.rs.getString("UsoPsicoativos"));
                tipoAlcool = conecta.rs.getInt("Alcool");
                if (tipoAlcool == 1) {
                    jRBAlcool.setSelected(true);
                } else if (tipoAlcool == 0) {
                    jRBAlcool.setSelected(!true);
                }
                tipoMaconha = conecta.rs.getInt("Maconha");
                if (tipoMaconha == 1) {
                    jRBMaconha.setSelected(true);
                } else if (tipoMaconha == 0) {
                    jRBMaconha.setSelected(!true);
                }
                tipoCocaina = conecta.rs.getInt("Cocaina");
                if (tipoCocaina == 1) {
                    jRBCocaina.setSelected(true);
                } else if (tipoCocaina == 0) {
                    jRBCocaina.setSelected(true);
                }
                tipoCola = conecta.rs.getInt("Cola");
                if (tipoCola == 1) {
                    jRBCola.setSelected(true);
                } else if (tipoCola == 0) {
                    jRBCola.setSelected(!true);
                }
                tipoCrack = conecta.rs.getInt("Crack");
                if (tipoCrack == 1) {
                    jRBCrack.setSelected(true);
                } else if (tipoCrack == 0) {
                    jRBCrack.setSelected(!true);
                }
                tipoInjetaveis = conecta.rs.getInt("Injetaveis");
                if (tipoInjetaveis == 1) {
                    jRBInjetaveis.setSelected(true);
                } else if (tipoInjetaveis == 0) {
                    jRBInjetaveis.setSelected(!true);
                }
                tipoOutrasDoencas = conecta.rs.getInt("OutrasSub");
                if (tipoOutrasDoencas == 1) {
                    jRBOutrasSub.setSelected(true);
                } else if (tipoOutrasDoencas == 0) {
                    jRBOutrasSub.setSelected(!true);
                }
                jQualOutrasSub.setText(conecta.rs.getString("QualOutrasSub"));
                jComboBoxCompartilhaCrack.setSelectedItem(conecta.rs.getString("CompartilhaCrack"));
                tipoSudorese = conecta.rs.getInt("Sudorese");
                if (tipoSudorese == 1) {
                    jRBSudorese.setSelected(true);
                } else if (tipoSudorese == 0) {
                    jRBSudorese.setSelected(!true);
                }
                tipoTremores = conecta.rs.getInt("Tremores");
                if (tipoTremores == 1) {
                    jRBTremores.setSelected(true);
                } else if (tipoTremores == 0) {
                    jRBTremores.setSelected(!true);
                }
                tipoFissura = conecta.rs.getInt("Fissura");
                if (tipoFissura == 1) {
                    jRBFissura.setSelected(true);
                } else if (tipoFissura == 0) {
                    jRBFissura.setSelected(!true);
                }
                tipoBocaSeca = conecta.rs.getInt("BocaSeca");
                if (tipoBocaSeca == 1) {
                    jRBBoca.setSelected(true);
                } else if (tipoBocaSeca == 0) {
                    jRBBoca.setSelected(!true);
                }
                tipoNauseas = conecta.rs.getInt("Nausea");
                if (tipoNauseas == 1) {
                    jRBNausea.setSelected(true);
                } else if (tipoNauseas == 0) {
                    jRBNausea.setSelected(true);
                }
                tipoDesejo = conecta.rs.getInt("Desejo");
                if (tipoDesejo == 1) {
                    jRBDesejo.setSelected(true);
                } else if (tipoDesejo == 0) {
                    jRBDesejo.setSelected(!true);
                }
                tipoNaoconseguir = conecta.rs.getInt("NaoPara");
                if (tipoNaoconseguir == 1) {
                    jRBNaoPara.setSelected(true);
                } else if (tipoNaoconseguir == 0) {
                    jRBNaoPara.setSelected(!true);
                }
                tipoAumentoTolerancia = conecta.rs.getInt("AumentoTolerancia");
                if (tipoAumentoTolerancia == 1) {
                    jRBAumentoTolerancia.setSelected(true);
                } else if (tipoAumentoTolerancia == 0) {
                    jRBAumentoTolerancia.setSelected(!true);
                }
                jComboBoxCAPSAD.setSelectedItem(conecta.rs.getString("CAPSAD"));
                jDataCAPSAD.setDate(conecta.rs.getDate("DataCAPSAD"));
                jComboBoxEsteveInternado.setSelectedItem(conecta.rs.getString("EsteveInternado"));
                jQuantoTempoInternado.setText(conecta.rs.getString("QuantoTempoInternado"));
                jComboBoxAceitaDanos.setSelectedItem(conecta.rs.getString("AceitaDanos"));
                jComboBoxSaudeBucal.setSelectedItem(conecta.rs.getString("SaudeBucal"));
                jComboBoxNecessitaAtende.setSelectedItem(conecta.rs.getString("NecessitaAtende"));
                tipoEnfermagem = conecta.rs.getInt("Enfermagem");
                if (tipoEnfermagem == 1) {
                    jRBEnfermagem.setSelected(true);
                } else if (tipoEnfermagem == 0) {
                    jRBEnfermagem.setSelected(!true);
                }
                tipoMedico = conecta.rs.getInt("Medico");
                if (tipoMedico == 1) {
                    jRBMedico.setSelected(true);
                } else if (tipoMedico == 0) {
                    jRBMedico.setSelected(!true);
                }
                tipoPsiquiatrico = conecta.rs.getInt("PsiquiatricoN");
                if (tipoPsiquiatrico == 1) {
                    jRBPsiquiatrico.setSelected(true);
                } else if (tipoPsiquiatrico == 0) {
                    jRBPsiquiatrico.setSelected(!true);
                }
                tipoPsicologico = conecta.rs.getInt("Psicologico");
                if (tipoPsicologico == 1) {
                    jRBPsicologico.setSelected(true);
                } else if (tipoPsicologico == 0) {
                    jRBPsicologico.setSelected(!true);
                }
                jComboBoxPessoasQuimica.setSelectedItem(conecta.rs.getString("PessoasQuimica"));
                jQuemNecessita.setText(conecta.rs.getString("QuemNecessita"));
                if (codigoSS3 != 0) {
                    jBtNovoSS3.setEnabled(true);
                    jBtAlterarSS3.setEnabled(true);
                    jBtExcluirSS3.setEnabled(true);
                    jBtSalvarSS3.setEnabled(!true);
                    jBtCancelarSS3.setEnabled(!true);
                    jBtAuditoriaSS3.setEnabled(true);
                }
            } catch (Exception e) {
            }
            // EAPI-1
            try {
                conecta.executaSQL("SELECT * FROM FICHA_CADASTRO_PAI_EAPI1 "
                        + "INNER JOIN FICHA_CADASTRO_PAI_PSICOSOCIAL "
                        + "ON FICHA_CADASTRO_PAI_EAPI1.IdPai=FICHA_CADASTRO_PAI_PSICOSOCIAL.IdPai "
                        + "WHERE FICHA_CADASTRO_PAI_EAPI1.IdPai='" + jCodigoPAI.getText() + "'");
                conecta.rs.first();
                codigoEAPI = conecta.rs.getInt("IdEAP1");
                jTextoPSP.setText(conecta.rs.getString("PSP"));
                jTextoCEDEGEP.setText(conecta.rs.getString("CEDEGEP"));
                jTextoCRASCREAS.setText(conecta.rs.getString("CRASCREAS"));
                //
                if (codigoEAPI != 0) {
                    jBtNovoEAPI1.setEnabled(true);
                    jBtAlterarEAPI1.setEnabled(true);
                    jBtExcluirEAPI1.setEnabled(true);
                    jBtSalvarEAPI1.setEnabled(!true);
                    jBtCancelarEAPI1.setEnabled(!true);
                    jBtAuditoriaEAPI1.setEnabled(true);
                }
            } catch (Exception e) {
            }
            //E.A.P.I.2            
            try {
                conecta.executaSQL("SELECT * FROM FICHA_CADASTRO_PAI_EAPI2 "
                        + "INNER JOIN FICHA_CADASTRO_PAI_PSICOSOCIAL "
                        + "ON FICHA_CADASTRO_PAI_EAPI2.IdPai=FICHA_CADASTRO_PAI_PSICOSOCIAL.IdPai "
                        + "WHERE FICHA_CADASTRO_PAI_EAPI2.IdPai='" + jCodigoPAI.getText() + "'");
                conecta.rs.first();
                codigoEAPI2 = conecta.rs.getInt("IdEAPI2");
                jTextoASSISTENCIA.setText(conecta.rs.getString("ASSISTENCIA"));
                jTextoDOCUMENTOCIVIL.setText(conecta.rs.getString("DOCUMENTOCIVIL"));
                jTextEAPI2PAI.setText(conecta.rs.getString("EAPI2PAI"));
                jTecnicoServicoSocial.setText(conecta.rs.getString("TecnicoServicoSocial"));
                jTecnicoPsicologico.setText(conecta.rs.getString("TecnicoPsicologico"));
                //
                if (codigoEAPI2 != 0) {
                    jBtNovoEAPI2.setEnabled(true);
                    jBtAlterarEAPI2.setEnabled(true);
                    jBtExcluirEAPI2.setEnabled(true);
                    jBtSalvarEAPI2.setEnabled(!true);
                    jBtCancelarEAPI2.setEnabled(!true);
                    jBtAuditoriaEAPI2.setEnabled(true);
                }
            } catch (Exception e) {
            }
            // EVOLUÇÃO PAI
            preencherTabelaEvolucao("SELECT * FROM EVOLUCAO_PAI_NOVO "
                    + "INNER JOIN FICHA_CADASTRO_PAI_PSICOSOCIAL "
                    + "ON EVOLUCAO_PAI_NOVO.IdPai=FICHA_CADASTRO_PAI_PSICOSOCIAL.IdPai "
                    + "WHERE EVOLUCAO_PAI_NOVO.IdPai='" + jCodigoPAI.getText() + "'");
        }
        conecta.desconecta();
    }//GEN-LAST:event_jTabelaPAIMouseClicked

    private void jBtAuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaPAI_Manu objAudManu = new TelaAuditoriaPAI_Manu();
        TelaModuloServicoSocial.jPainelServicoSocial.add(objAudManu);
        objAudManu.show();
    }//GEN-LAST:event_jBtAuditoriaActionPerformed

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        if (codigoUser == codUserAcesso && nomeTela.equals(telaPAISS) && codIncluir == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            acao = 1;
            limparCamposNovo();
            bloquearCampos();
            bloquearBotoes();
            limparTabelaFamiliar();
            limparTabelaVisitas();
            limparTabelaVisitasIntimas();
            Novo();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a incluir registro.");
        }
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        // TODO add your handling code here:
        if (codigoUser == codUserAcesso && nomeTela.equals(telaPAISS) && codAlterar == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            acao = 2;
            bloquearCampos();
            bloquearBotoes();
            Alterar();
            statusMov = "Alterou";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a alterar registro.");
        }
    }//GEN-LAST:event_jBtAlterarActionPerformed

    private void jBtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirActionPerformed
        // TODO add your handling code here:
        if (codigoUser == codUserAcesso && nomeTela.equals(telaPAISS) && codExcluir == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            verificarCodigoPAI();
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            objPaiPsico.setIdPai(Integer.valueOf(jCodigoPAI.getText()));
            if (objPaiPsico.getIdPai() == idPaiCCGF
                    || objPaiPsico.getIdPai() == idPaiVF
                    || objPaiPsico.getIdPai() == idPaiVF1
                    || objPaiPsico.getIdPai() == idPaiVF2) {
                JOptionPane.showMessageDialog(null, "Esse registro não poderá ser excluído, existem outros registros relacionados.");
            } else {
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    objPaiPsico.setIdPai(Integer.parseInt(jCodigoPAI.getText()));
                    control.excluirPAI(objPaiPsico);
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    bloquearCampos();
                    Excluir();
                    JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a excluir registro.");
        }
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        if (codigoUser == codUserAcesso && nomeTela.equals(telaPAISS) && codGravar == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            verificarExistenciaInternoPAI();
            if (jDataPAI.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data de Cadastro do P.A.I.");
            } else if (jIdInternoPAI.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome do interno.");
            } else if (jNomeInternoPAI.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome do interno.");
            } else if (jIdadeInterno.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Informe a idade do interno.");
            } else {
                objPaiPsico.setIdInternoCrc(Integer.valueOf(jIdInternoPAI.getText()));
                objPaiPsico.setNomeInternoCrc(jNomeInternoPAI.getText());
                objPaiPsico.setStatusPai((String) jComboBoxStatusPAI.getSelectedItem());
                objPaiPsico.setDataPai(jDataPAI.getDate());
                objPaiPsico.setIdadeInterno(Integer.valueOf(jIdadeInterno.getText()));
                objPaiPsico.setNaturalidade(jNaturalidadeInternoPAI.getText());
                objPaiPsico.setMunicipioRegistrado(jMunicipioRegistrado.getText());
                objPaiPsico.setOrientacaoSexual((String) jComboBoxOrientacaoSexual.getSelectedItem());
                objPaiPsico.setTipoOrientacaoSexual(jTipoOrientacaoSexual.getText());
                objPaiPsico.setDocumentoDelega((String) jComboBoxDocumentoDelega.getSelectedItem());
                objPaiPsico.setQualDocumento(jQualDocumento.getText());
                objPaiPsico.setQualDelegacia(jQualDelegacia.getText());
                objPaiPsico.setRegularizarDocumento((String) jComboBoxRegularizarDocumento.getSelectedItem());
                objPaiPsico.setTipoDocumento((String) jComboBoxTipoDocumento.getSelectedItem());
                objPaiPsico.setrGInternoPAI(jRGInternoPAI.getText());
                objPaiPsico.setEmissor(jEmissor.getText());
                objPaiPsico.setDataExpedicao(jDataExpedicao.getDate());
                objPaiPsico.setcPFInternoPAI(jCPFInternoPAI.getText());
                objPaiPsico.setCartaoSUSPAI(jCartaoSUSPAI.getText());
                objPaiPsico.setTituloEleitor(jTituloEleitor.getText());
                objPaiPsico.setZona(jZona.getText());
                objPaiPsico.setSessao(jSessao.getText());
                objPaiPsico.setnIS(jNIS.getText());
                objPaiPsico.setcTPS(jCTPS.getText());
                objPaiPsico.setSerie(jSerie.getText());
                objPaiPsico.setReligiao((String) jComboBoxReligiao.getSelectedItem());
                objPaiPsico.setEstadoCivil((String) jComboBoxEstadoCivil.getSelectedItem());
                objPaiPsico.setEndereco(jEndereco.getText());
                objPaiPsico.setComplemento(jComplemento.getText());
                objPaiPsico.setReferencia(jReferencia.getText());
                objPaiPsico.setBairro(jBairro.getText());
                objPaiPsico.setCidade(jCidade.getText());
                objPaiPsico.setEstado((String) jComboBoxEstadoNaturalidade.getSelectedItem());
                objPaiPsico.setTelefone(jTelefone.getText());
                objPaiPsico.setTelefone1(jTelefone1.getText());
                objPaiPsico.setCelular(jCelular.getText());
                if (acao == 1) {
                    if (jIdInternoPAI.getText().equals(codigoInternoPAI) && jNomeMaeInternoPAI.getText().equals(nomeMaeInterno)) {
                        JOptionPane.showMessageDialog(rootPane, "Esse interno já foi incluído no P.A.I.");
                    } else {
                        objPaiPsico.setUsuarioInsert(nameUser);
                        objPaiPsico.setDataInsert(dataModFinal);
                        objPaiPsico.setHorarioInsert(horaMov);
                        control.incluirPAI(objPaiPsico);
                        buscarCodigo();
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        Salvar();
                        verificarRegistrosTodasAbas();
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    }
                }
                if (acao == 2) {
                    objPaiPsico.setUsuarioUp(nameUser);
                    objPaiPsico.setDataUp(dataModFinal);
                    objPaiPsico.setHorarioUp(horaMov);
                    objPaiPsico.setIdPai(Integer.valueOf(jCodigoPAI.getText()));
                    control.alterarPAI(objPaiPsico);
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    Salvar();
                    verificarRegistrosTodasAbas();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a gravar registro.");
        }
    }//GEN-LAST:event_jBtSalvarActionPerformed

    private void jBtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarActionPerformed
        // TODO add your handling code here:
        Cancelar();
    }//GEN-LAST:event_jBtCancelarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtPesquisarInternoPAIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisarInternoPAIActionPerformed
        // TODO add your handling code here:       
        if (nomeModuloSERV.equals("SERVICO") && TelaModuloServicoSocial.jPainelServicoSocial != null) {
            TelaPesqInternoPAI_NOVO_SOCIAL objPesqInternoPAI_NOVO = new TelaPesqInternoPAI_NOVO_SOCIAL();
            TelaModuloServicoSocial.jPainelServicoSocial.add(objPesqInternoPAI_NOVO);
            objPesqInternoPAI_NOVO.show();
        }
        if (nomeModuloJURI.equals("JURIDICO") && TelaModuloJuridico.jPainelJuridico != null) {
            TelaPesqInternoPAI_NOVO_JURIDICO objPesqInternoPAI_NOVO_JU = new TelaPesqInternoPAI_NOVO_JURIDICO();
            TelaModuloJuridico.jPainelJuridico.add(objPesqInternoPAI_NOVO_JU);
            objPesqInternoPAI_NOVO_JU.show();
        }
        if (nomeModuloENFER.equals("ENFERMARIA") && TelaModuloEnfermaria.jPainelMedico != null) {
            TelaPesqInternoPAI_NOVO_SOCIAL objPesqInternoPAI_NOVO = new TelaPesqInternoPAI_NOVO_SOCIAL();
            TelaModuloEnfermaria.jPainelMedico.add(objPesqInternoPAI_NOVO);
            objPesqInternoPAI_NOVO.show();
        }
        if (nomeModuloTERA.equals("TERAPIA") && TelaModuloTerapiaOcupacional.jPainelTerapia != null) {
            TelaPesqInternoPAI_NOVO_SOCIAL objPesqInternoPAI_NOVO = new TelaPesqInternoPAI_NOVO_SOCIAL();
            TelaModuloTerapiaOcupacional.jPainelTerapia.add(objPesqInternoPAI_NOVO);
            objPesqInternoPAI_NOVO.show();
        }
    }//GEN-LAST:event_jBtPesquisarInternoPAIActionPerformed

    private void jBtSalvarFamiliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarFamiliarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPaiCCGFFam_SS);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaPaiCCGFFam_SS) && codGravar == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            if (jNomeFamiliarPAI.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome do familiar para cadastrar.");
            } else {
                objSocial2Pai.setNomeFamiliar(jNomeFamiliarPAI.getText());
                objSocial2Pai.setIdade(Integer.valueOf(jIdadeFamiliarPAI.getText()));
                objSocial2Pai.setVinculo((String) jComboBoxVinculoPAI.getSelectedItem());
                objSocial2Pai.setOcupacao(jOcupacaoFamiliarPAI.getText());
                objSocial2Pai.setEnderecoTelefonePAI(jEnderecoTelefonePAI.getText());
                objSocial2Pai.setIdPai(Integer.valueOf(jCodigoPAI.getText()));
                objSocial2Pai.setNomeInternoCrc(jNomeInternoPAI.getText());
                if (acao == 5) {
                    objSocial2Pai.setUsuarioInsert(nameUser);
                    objSocial2Pai.setDataInsert(dataModFinal);
                    objSocial2Pai.setHorarioInsert(horaMov);
                    //
                    controle2.incluirSocial2PsicoSocial(objSocial2Pai);
                    buscarCodigoFamiliar();
                    objLog2();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    preencherTabelaFamiliar("SELECT * FROM FICHA_CADASTRO_PAI_CCGF_VF "
                            + "INNER JOIN FICHA_CADASTRO_PAI_PSICOSOCIAL "
                            + "ON FICHA_CADASTRO_PAI_CCGF_VF.IdPai=FICHA_CADASTRO_PAI_PSICOSOCIAL.IdPai "
                            + "WHERE FICHA_CADASTRO_PAI_CCGF_VF.IdPai='" + jCodigoPAI.getText() + "'");
                    SalvarFamiliar();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
                if (acao == 6) {
                    objSocial2Pai.setUsuarioUp(nameUser);
                    objSocial2Pai.setDataUp(dataModFinal);
                    objSocial2Pai.setHorarioUp(horaMov);
                    //
                    objSocial2Pai.setIdFamiliar(Integer.valueOf(jIdFamiliarPAI.getText()));
                    controle2.alterarSocial2PsicoSocial(objSocial2Pai);
                    objLog2();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    preencherTabelaFamiliar("SELECT * FROM FICHA_CADASTRO_PAI_CCGF_VF "
                            + "INNER JOIN FICHA_CADASTRO_PAI_PSICOSOCIAL "
                            + "ON FICHA_CADASTRO_PAI_CCGF_VF.IdPai=FICHA_CADASTRO_PAI_PSICOSOCIAL.IdPai "
                            + "WHERE FICHA_CADASTRO_PAI_CCGF_VF.IdPai='" + jCodigoPAI.getText() + "'");
                    SalvarFamiliar();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a gravar registro.");
        }
    }//GEN-LAST:event_jBtSalvarFamiliarActionPerformed

    private void jBtCancelarFamiliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarFamiliarActionPerformed
        // TODO add your handling code here:
        CancelarFamiliar();
    }//GEN-LAST:event_jBtCancelarFamiliarActionPerformed

    private void jBtExcluirFamiliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirFamiliarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPaiCCGFFam_SS);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaPaiCCGFFam_SS) && codExcluir == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            bloquearCampos();
            bloquearBotoes();
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objSocial2Pai.setIdFamiliar(Integer.parseInt(jIdFamiliarPAI.getText()));
                controle2.excluirSocial2PsicoSocial(objSocial2Pai);
                objLog2();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                preencherTabelaFamiliar("SELECT * FROM FICHA_CADASTRO_PAI_CCGF_VF "
                        + "INNER JOIN FICHA_CADASTRO_PAI_PSICOSOCIAL "
                        + "ON FICHA_CADASTRO_PAI_CCGF_VF.IdPai=FICHA_CADASTRO_PAI_PSICOSOCIAL.IdPai "
                        + "WHERE FICHA_CADASTRO_PAI_CCGF_VF.IdPai='" + jCodigoPAI.getText() + "'");
                ExcluirFamiliar();
                JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a excluir registro.");
        }
    }//GEN-LAST:event_jBtExcluirFamiliarActionPerformed

    private void jTabelaFamiliarPAIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaFamiliarPAIMouseClicked
        // TODO add your handling code here:
        if (acao == 4) {
            if (flag == 1) {
                String idFamilia = "" + jTabelaFamiliarPAI.getValueAt(jTabelaFamiliarPAI.getSelectedRow(), 0);
                jIdFamiliarPAI.setText(idFamilia);
                //
                bloquearCampos();
                bloquearBotoes();
                //
                jBtNovoFamiliar.setEnabled(!true);
                jBtAlterarFamiliar.setEnabled(true);
                jBtExcluirFamiliar.setEnabled(true);
                jBtSalvarFamiliar.setEnabled(!true);
                jBtCancelarFamiliar.setEnabled(true);
                jBtAuditoriaFamiliar.setEnabled(true);
                //
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM FICHA_CADASTRO_PAI_CCGF_VF "
                            + "INNER JOIN FICHA_CADASTRO_PAI_PSICOSOCIAL "
                            + "ON FICHA_CADASTRO_PAI_CCGF_VF.IdPai=FICHA_CADASTRO_PAI_PSICOSOCIAL.IdPai "
                            + "WHERE FICHA_CADASTRO_PAI_CCGF_VF.IdPai='" + jCodigoPAI.getText() + "' "
                            + "AND IdVF='" + idFamilia + "'");
                    conecta.rs.first();
                    jIdFamiliarPAI.setText(conecta.rs.getString("IdVF"));
                    jNomeFamiliarPAI.setText(conecta.rs.getString("NomeFamiliar"));
                    jIdadeFamiliarPAI.setText(conecta.rs.getString("Idade"));
                    jComboBoxVinculoPAI.setSelectedItem(conecta.rs.getString("Vinculo"));
                    jOcupacaoFamiliarPAI.setText(conecta.rs.getString("Ocupacao"));
                    jEnderecoTelefonePAI.setText(conecta.rs.getString("Endereco"));
                } catch (Exception e) {
                }
                conecta.desconecta();
            }
        }
    }//GEN-LAST:event_jTabelaFamiliarPAIMouseClicked

    private void jBtAuditoriaFamiliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaFamiliarActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaPAI_CCGF_FAM1 objAudCCGF_FAM1 = new TelaAuditoriaPAI_CCGF_FAM1();
        TelaModuloServicoSocial.jPainelServicoSocial.add(objAudCCGF_FAM1);
        objAudCCGF_FAM1.show();
    }//GEN-LAST:event_jBtAuditoriaFamiliarActionPerformed

    private void jBtAlterarFamiliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarFamiliarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPaiCCGFFam_SS);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaPaiCCGFFam_SS) && codAlterar == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            acao = 6;
            bloquearCampos();
            bloquearBotoes();
            AlterarFamiliar();
            statusMov = "Alterou";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a alterar registro.");
        }
    }//GEN-LAST:event_jBtAlterarFamiliarActionPerformed

    private void jBtNovoFamiliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoFamiliarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPaiCCGFFam_SS);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaPaiCCGFFam_SS) && codIncluir == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            acao = 5;
            bloquearCampos();
            bloquearBotoes();
            NovoFamiliar();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a incluir registro.");
        }
    }//GEN-LAST:event_jBtNovoFamiliarActionPerformed

    private void jBtAuditoriaSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaSSActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaPAI_CCGF objAudCCGF = new TelaAuditoriaPAI_CCGF();
        TelaModuloServicoSocial.jPainelServicoSocial.add(objAudCCGF);
        objAudCCGF.show();
    }//GEN-LAST:event_jBtAuditoriaSSActionPerformed

    private void jBtNovoSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoSSActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPaiCCGF_SS);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaPaiCCGF_SS) && codIncluir == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            acao = 3;
            bloquearBotoes();
            bloquearCampos();
            NovoSS();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a incluir registro.");
        }
    }//GEN-LAST:event_jBtNovoSSActionPerformed

    private void jBtAlterarSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarSSActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPaiCCGF_SS);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaPaiCCGF_SS) && codAlterar == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            acao = 4;
            bloquearBotoes();
            bloquearCampos();
            AlterarSS();
            statusMov = "Alterou";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a alterar registro.");
        }
    }//GEN-LAST:event_jBtAlterarSSActionPerformed

    private void jBtExcluirSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirSSActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPaiCCGF_SS);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaPaiCCGF_SS) && codExcluir == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            objSocial2Pai.setIdPai(Integer.valueOf(jCodigoPAI.getText()));
            verificarVisitasFamiliarIntima();
            if (objSocial2Pai.getIdPai() == codigoVF || objSocial2Pai.getIdPai() == codigoVF1 || objSocial2Pai.getIdPai() == codigoVF2) {
                JOptionPane.showMessageDialog(null, "Não é possível excluir esse registro, existe, registro relacionado a ele.");
            } else {
                statusMov = "Excluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    objSocial2Pai.setIdPai(Integer.parseInt(jCodigoPAI.getText()));
                    controle.excluirCCGF_PAI(objCcgf);
                    objLog1();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    bloquearCampos();
                    bloquearBotoes();
                    ExcluirSS();
                    JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a excluir registro.");
        }
    }//GEN-LAST:event_jBtExcluirSSActionPerformed

    private void jBtSalvarSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarSSActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPaiCCGF_SS);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaPaiCCGF_SS) && codGravar == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            verificarCCGF(); // VERIFICAR SE JÁ EXISTE UM REGISTRO CADASTRADO PARA O INTERNO.(SOMENTE PODERÁ EXISTIR UM POR INTERNO)
            objCcgf.setTemFilhos((String) jComboBoxTemFilhos.getSelectedItem());
            objCcgf.setQuantosFilhos(Integer.valueOf(jQuantosFilhos.getText()));
            objCcgf.setReconhecerPaterna((String) jComboBoxReconhecerPaterna.getSelectedItem());
            objCcgf.setDadosPaternidade(jDadosPaternidade.getText());
            objCcgf.setEstaoFilhos((String) jComboBoxEstaoFilhos.getSelectedItem());
            objCcgf.setNecessidaEspecial((String) jComboBoxNecessidaEspecial.getSelectedItem());
            objCcgf.setNecessidadeESP(jQualNecessidadeESP.getText());
            objCcgf.setcRAS((String) jComboBoxCRAS.getSelectedItem());
            objCcgf.setcREAS((String) jComboBoxCREAS.getSelectedItem());
            objCcgf.setRecebeBeneficio((String) jComboBoxRecebeBeneficio.getSelectedItem());
            objCcgf.setQuaisBeneficiosFamilia(jQuaisBeneficiosFamilia.getText());
            objCcgf.setAntesBeneficio((String) jComboBoxAntesBeneficio.getSelectedItem());
            objCcgf.setQuaisBeneficiosAntesPrisao(jQuaisBeneficiosAntesPrisao.getText());
            objCcgf.setNecessitaBeneficio((String) jComboBoxNecessitaBeneficio.getSelectedItem());
            objCcgf.setQuemNecessitaBeneficio(jNecessitaBeneficio.getText());
            objCcgf.setMoradia((String) jComboBoxMoradia.getSelectedItem());
            objCcgf.setModalidade((String) jComboBoxModalidade.getSelectedItem());
            objCcgf.setAbastecimento((String) jComboBoxAbastecimento.getSelectedItem());
            objCcgf.setEliminaDejetos((String) jComboBoxEliminaDejetos.getSelectedItem());
            objCcgf.setDescarte((String) jComboBoxDescarte.getSelectedItem());
            objCcgf.setFamiliaVulneraSocial((String) jComboBoxFamiliaVulneraSocial.getSelectedItem());
            objCcgf.setViveuRua((String) jComboBoxViveuRua.getSelectedItem());
            objCcgf.setQuantoTempo(Integer.valueOf(jQuantoTempo.getText()));
            objCcgf.setMotivo(jMotivo.getText());
            objCcgf.setFamiliaDetido((String) jComboBoxFamiliaDetido.getSelectedItem());
            objCcgf.setRestabelecerVinculo((String) jComboBoxRestabelecerVinculo.getSelectedItem());
            objCcgf.setComoRestabelecer((String) jComboBoxComoRestabelecer.getSelectedItem());
            objCcgf.setIdInternoCrc(Integer.valueOf(jIdInternoPAI.getText()));
            objCcgf.setNomeInternoCrc(jNomeInternoPAI.getText());
            objCcgf.setIdPai(Integer.valueOf(jCodigoPAI.getText()));
            if (acao == 3) {
                if (objCcgf.getIdPai() == codigoPaiSS1 && objCcgf.getIdInternoCrc() == codigoInternoSS1) {
                    JOptionPane.showMessageDialog(rootPane, "Já foi realizado um registro para esse interno.");
                } else {
                    objCcgf.setUsuarioInsert(nameUser);
                    objCcgf.setDataInsert(dataModFinal);
                    objCcgf.setHorarioInsert(horaMov);
                    controle.incluirCCGF_PAI(objCcgf);
                    objLog1();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    SalvarSS();
                    verificarRegistrosTodasAbas();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
            }
            if (acao == 4) {
                objCcgf.setUsuarioUp(nameUser);
                objCcgf.setDataUp(dataModFinal);
                objCcgf.setHorarioUp(horaMov);
                objCcgf.setIdPai(codigoPaiSS1);
                controle.alterarCCGF_PAI(objCcgf);
                objLog1();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                SalvarSS();
                verificarRegistrosTodasAbas();
                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a gravar registro.");
        }
    }//GEN-LAST:event_jBtSalvarSSActionPerformed

    private void jBtCancelarSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarSSActionPerformed
        // TODO add your handling code here:
        acao = 0;
        CancelarSS();
    }//GEN-LAST:event_jBtCancelarSSActionPerformed

    private void jBtSairSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairSSActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairSSActionPerformed

    private void jBtPesqVisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqVisitaActionPerformed

        if (nomeModuloSERV.equals("SERVICO") && TelaModuloServicoSocial.jPainelServicoSocial != null) {
            TelaPesquisaVisitasPAI_NOVO objPesqVisitaPN = new TelaPesquisaVisitasPAI_NOVO();
            TelaModuloServicoSocial.jPainelServicoSocial.add(objPesqVisitaPN);
            objPesqVisitaPN.show();
        }
        if (nomeModuloJURI.equals("JURIDICO") && TelaModuloJuridico.jPainelJuridico != null) {
            TelaPesquisaVisitasPAI_NOVO objPesqVisitaPN = new TelaPesquisaVisitasPAI_NOVO();
            TelaModuloJuridico.jPainelJuridico.add(objPesqVisitaPN);
            objPesqVisitaPN.show();
        }
        if (nomeModuloENFER.equals("ENFERMARIA") && TelaModuloEnfermaria.jPainelMedico != null) {
            TelaPesquisaVisitasPAI_NOVO objPesqVisitaPN = new TelaPesquisaVisitasPAI_NOVO();
            TelaModuloEnfermaria.jPainelMedico.add(objPesqVisitaPN);
            objPesqVisitaPN.show();
        }
        if (nomeModuloTERA.equals("TERAPIA") && TelaModuloTerapiaOcupacional.jPainelTerapia != null) {
            TelaPesquisaVisitasPAI_NOVO objPesqVisitaPN = new TelaPesquisaVisitasPAI_NOVO();
            TelaModuloTerapiaOcupacional.jPainelTerapia.add(objPesqVisitaPN);
            objPesqVisitaPN.show();
        }
    }//GEN-LAST:event_jBtPesqVisitaActionPerformed

    private void jTabelaVisitasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaVisitasMouseClicked
        // TODO add your handling code here:
        if (acao == 4) {
            if (flag == 1) {
                String idSolVisita = "" + jTabelaVisitas.getValueAt(jTabelaVisitas.getSelectedRow(), 0);
                jIdVisitaPAI.setText(idSolVisita);
                //
                bloquearCampos();
                //
                jBtNovaVisita.setEnabled(!true);
                jBtAlterarVisita.setEnabled(true);
                jBtExcluirVisita.setEnabled(true);
                jBtSalvarVisita.setEnabled(!true);
                jBtCancelarVisita.setEnabled(true);
                jBtAuditoriaVisita.setEnabled(true);
                //
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM FICHA_CADASTRO_PAI_CCGF_VF1 "
                            + "INNER JOIN FICHA_CADASTRO_PAI_PSICOSOCIAL "
                            + "ON FICHA_CADASTRO_PAI_CCGF_VF1.IdPai=FICHA_CADASTRO_PAI_PSICOSOCIAL.IdPai "
                            + "INNER JOIN VISITASINTERNO "
                            + "ON FICHA_CADASTRO_PAI_CCGF_VF1.IdVisita=VISITASINTERNO.IdVisita "
                            + "WHERE FICHA_CADASTRO_PAI_CCGF_VF1.IdPai='" + jCodigoPAI.getText() + "' "
                            + "AND IdVF1='" + idSolVisita + "'");
                    conecta.rs.first();
                    idSol2Visita = conecta.rs.getInt("IdVF1");
                    jIdVisitaPAI.setText(conecta.rs.getString("IdVisita"));
                    jNomeVisitaPAI.setText(conecta.rs.getString("NomeVisita"));
                    jOcupacaoVisita.setText(conecta.rs.getString("Ocupacao"));
                    jParentescoPAI.setText(conecta.rs.getString("ParentescoVisita"));
                    jIdadeVisita.setText(conecta.rs.getString("Idade"));
                } catch (Exception e) {
                }
                conecta.desconecta();
            }
        }
    }//GEN-LAST:event_jTabelaVisitasMouseClicked

    private void jBtCancelarVisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarVisitaActionPerformed
        // TODO add your handling code here:
        CancelarVisita();
    }//GEN-LAST:event_jBtCancelarVisitaActionPerformed

    private void jBtExcluirVisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirVisitaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPaiCCGFVis_SS);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaPaiCCGFVis_SS) && codExcluir == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            bloquearCampos();
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objSocial2Vista.setIdSol2Visita(idSol2Visita);
                controlVisita.excluirVisitaPsicoSocial(objSocial2Vista);
                objLog3();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                preencherTabelaVisitas("SELECT * FROM FICHA_CADASTRO_PAI_CCGF_VF1 "
                        + "INNER JOIN FICHA_CADASTRO_PAI_PSICOSOCIAL "
                        + "ON FICHA_CADASTRO_PAI_CCGF_VF1.IdPai=FICHA_CADASTRO_PAI_PSICOSOCIAL.IdPai "
                        + "INNER JOIN VISITASINTERNO "
                        + "ON FICHA_CADASTRO_PAI_CCGF_VF1.IdVisita=VISITASINTERNO.IdVisita "
                        + "WHERE FICHA_CADASTRO_PAI_CCGF_VF1.IdPai='" + jCodigoPAI.getText() + "'");
                ExcluirVisita();
                JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a excluir registro.");
        }
    }//GEN-LAST:event_jBtExcluirVisitaActionPerformed

    private void jBtSalvarVisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarVisitaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPaiCCGFVis_SS);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaPaiCCGFVis_SS) && codGravar == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            if (jIdVisitaPAI.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome da visita.");
            } else if (jNomeVisitaPAI.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome da Visita");
            } else if (jIdadeVisita.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Informe a idade da visita.");
            } else {
                objSocial2Vista.setOcupacao(jOcupacaoVisita.getText());
                objSocial2Vista.setIdade(Integer.valueOf(jIdadeVisita.getText()));
                objSocial2Vista.setIdPai(Integer.valueOf(jCodigoPAI.getText()));
                objSocial2Vista.setIdVisita(Integer.valueOf(jIdVisitaPAI.getText()));
                objSocial2Vista.setNomeVisita(jNomeVisitaPAI.getText());
                objSocial2Vista.setIdInternoCrc(Integer.valueOf(jIdInternoPAI.getText()));
                objSocial2Vista.setNomeInternoCrc(jNomeInternoPAI.getText());
                if (acao == 7) {
                    objSocial2Vista.setUsuarioInsert(nameUser);
                    objSocial2Vista.setDataInsert(dataModFinal);
                    objSocial2Vista.setHorarioInsert(horaMov);
                    controlVisita.incluirVisitaPsicoSocial(objSocial2Vista);
                    //
                    objLog3();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    SalvarVisita();
                    preencherTabelaVisitas("SELECT * FROM FICHA_CADASTRO_PAI_CCGF_VF1 "
                            + "INNER JOIN FICHA_CADASTRO_PAI_PSICOSOCIAL "
                            + "ON FICHA_CADASTRO_PAI_CCGF_VF1.IdPai=FICHA_CADASTRO_PAI_PSICOSOCIAL.IdPai "
                            + "INNER JOIN VISITASINTERNO "
                            + "ON FICHA_CADASTRO_PAI_CCGF_VF1.IdVisita=VISITASINTERNO.IdVisita "
                            + "WHERE FICHA_CADASTRO_PAI_CCGF_VF1.IdPai='" + jCodigoPAI.getText() + "'");
                    JOptionPane.showMessageDialog(null, "Registro gravado com sucesso.");
                }
                if (acao == 8) {
                    objSocial2Vista.setUsuarioUp(nameUser);
                    objSocial2Vista.setDataUp(dataModFinal);
                    objSocial2Vista.setHorarioUp(horaMov);
                    //
                    objSocial2Vista.setIdSol2Visita(idSol2Visita);
                    controlVisita.alterarVisitaPsicoSocial(objSocial2Vista);
                    //
                    objLog3();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    SalvarVisita();
                    preencherTabelaVisitas("SELECT * FROM FICHA_CADASTRO_PAI_CCGF_VF1 "
                            + "INNER JOIN FICHA_CADASTRO_PAI_PSICOSOCIAL "
                            + "ON FICHA_CADASTRO_PAI_CCGF_VF1.IdPai=FICHA_CADASTRO_PAI_PSICOSOCIAL.IdPai "
                            + "INNER JOIN VISITASINTERNO "
                            + "ON FICHA_CADASTRO_PAI_CCGF_VF1.IdVisita=VISITASINTERNO.IdVisita "
                            + "WHERE FICHA_CADASTRO_PAI_CCGF_VF1.IdPai='" + jCodigoPAI.getText() + "'");
                    JOptionPane.showMessageDialog(null, "Registro gravado com sucesso.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a gravar registro.");
        }
    }//GEN-LAST:event_jBtSalvarVisitaActionPerformed

    private void jBtNovaVisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovaVisitaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPaiCCGFVis_SS);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaPaiCCGFVis_SS) && codIncluir == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            acao = 7;
            bloquearCampos();
            bloquearBotoes();
            NovaVisita();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a incluir registro.");
        }
    }//GEN-LAST:event_jBtNovaVisitaActionPerformed

    private void jBtAlterarVisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarVisitaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPaiCCGFVis_SS);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaPaiCCGFVis_SS) && codAlterar == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            acao = 8;
            bloquearCampos();
            bloquearBotoes();
            AlterarVisita();
            statusMov = "Alterou";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a alterar registro.");
        }
    }//GEN-LAST:event_jBtAlterarVisitaActionPerformed

    private void jBtAuditoriaVisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaVisitaActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaPAI_CCGF_FAM2 objAudCCGF_FAM2 = new TelaAuditoriaPAI_CCGF_FAM2();
        TelaModuloServicoSocial.jPainelServicoSocial.add(objAudCCGF_FAM2);
        objAudCCGF_FAM2.show();
    }//GEN-LAST:event_jBtAuditoriaVisitaActionPerformed

    private void jTabelaVisitasIntimasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaVisitasIntimasMouseClicked
        // TODO add your handling code here:
        if (acao == 4) {
            if (flag == 1) {
                String idSolVisita = "" + jTabelaVisitasIntimas.getValueAt(jTabelaVisitasIntimas.getSelectedRow(), 0);
                jIdVisitaIntima.setText(idSolVisita);
                //
                bloquearCampos();
                bloquearBotoes();
                //
                jBtNovaVisitaIntima.setEnabled(!true);
                jBtAlterarVisitaIntima.setEnabled(true);
                jBtExcluirVisitaIntima.setEnabled(true);
                jBtSalvarVisitaIntima.setEnabled(!true);
                jBtCancelarVisitaIntima.setEnabled(true);
                jBtAuditoriaVisitaIntima.setEnabled(true);
                //
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM FICHA_CADASTRO_PAI_CCGF_VF2 "
                            + "INNER JOIN FICHA_CADASTRO_PAI_PSICOSOCIAL "
                            + "ON FICHA_CADASTRO_PAI_CCGF_VF2.IdPai=FICHA_CADASTRO_PAI_PSICOSOCIAL.IdPai "
                            + "INNER JOIN VISITASINTERNO "
                            + "ON FICHA_CADASTRO_PAI_CCGF_VF2.IdVisita=VISITASINTERNO.IdVisita "
                            + "WHERE FICHA_CADASTRO_PAI_CCGF_VF2.IdPai='" + jCodigoPAI.getText() + "' "
                            + "AND IdVF2='" + idSolVisita + "'");
                    conecta.rs.first();
                    idSol2VisitaIntima = conecta.rs.getInt("IdVF2");
                    jIdVisitaIntima.setText(conecta.rs.getString("IdVisita"));
                    jNomeVisitaIntima.setText(conecta.rs.getString("NomeVisita"));
                    jOcupacaoVisitaIntima.setText(conecta.rs.getString("Ocupacao"));
                    jParentescoVisitaIntima.setText(conecta.rs.getString("ParentescoVisita"));
                    jIdadeVisitaIntima.setText(conecta.rs.getString("Idade"));
                } catch (Exception e) {
                }
                conecta.desconecta();
            }
        }
    }//GEN-LAST:event_jTabelaVisitasIntimasMouseClicked

    private void jBtPesqVisitaIntimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqVisitaIntimaActionPerformed
        // TODO add your handling code here:

        if (nomeModuloSERV.equals("SERVICO") && TelaModuloServicoSocial.jPainelServicoSocial != null) {
            TelaPesquisaVisitasIntimaPAI_NOVO objPesqVisitaIntima = new TelaPesquisaVisitasIntimaPAI_NOVO();
            TelaModuloServicoSocial.jPainelServicoSocial.add(objPesqVisitaIntima);
            objPesqVisitaIntima.show();
        }
        if (nomeModuloJURI.equals("JURIDICO") && TelaModuloJuridico.jPainelJuridico != null) {
            TelaPesquisaVisitasIntimaPAI_NOVO objPesqVisitaIntima = new TelaPesquisaVisitasIntimaPAI_NOVO();
            TelaModuloJuridico.jPainelJuridico.add(objPesqVisitaIntima);
            objPesqVisitaIntima.show();
        }
        if (nomeModuloENFER.equals("ENFERMARIA") && TelaModuloEnfermaria.jPainelMedico != null) {
            TelaPesquisaVisitasIntimaPAI_NOVO objPesqVisitaIntima = new TelaPesquisaVisitasIntimaPAI_NOVO();
            TelaModuloEnfermaria.jPainelMedico.add(objPesqVisitaIntima);
            objPesqVisitaIntima.show();
        }
        if (nomeModuloTERA.equals("TERAPIA") && TelaModuloTerapiaOcupacional.jPainelTerapia != null) {
            TelaPesquisaVisitasIntimaPAI_NOVO objPesqVisitaIntima = new TelaPesquisaVisitasIntimaPAI_NOVO();
            TelaModuloTerapiaOcupacional.jPainelTerapia.add(objPesqVisitaIntima);
            objPesqVisitaIntima.show();
        }
    }//GEN-LAST:event_jBtPesqVisitaIntimaActionPerformed

    private void jBtSalvarVisitaIntimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarVisitaIntimaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPaiCCGFVisInt_SS);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaPaiCCGFVisInt_SS) && codGravar == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            if (jIdVisitaIntima.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome da visita.");
            } else if (jNomeVisitaIntima.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome da Visita");
            } else if (jIdadeVisitaIntima.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Informe a idade da visita.");
            } else {
                objSocial2Vista.setOcupacao(jOcupacaoVisitaIntima.getText());
                objSocial2Vista.setIdade(Integer.valueOf(jIdadeVisitaIntima.getText()));
                objSocial2Vista.setIdPai(Integer.valueOf(jCodigoPAI.getText()));
                objSocial2Vista.setIdVisita(Integer.valueOf(jIdVisitaIntima.getText()));
                objSocial2Vista.setNomeVisita(jNomeVisitaIntima.getText());
                objSocial2Vista.setIdInternoCrc(Integer.valueOf(jIdInternoPAI.getText()));
                objSocial2Vista.setNomeInternoCrc(jNomeInternoPAI.getText());
                if (acao == 9) {
                    objSocial2Vista.setUsuarioInsert(nameUser);
                    objSocial2Vista.setDataInsert(dataModFinal);
                    objSocial2Vista.setHorarioInsert(horaMov);
                    controlVisitaIntima.incluirVisitaIntimaPsicoSocial(objSocial2Vista);
                    //
                    objLog4();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    SalvarVisitaIntima();
                    preencherTabelaVisitasIntimas("SELECT * FROM FICHA_CADASTRO_PAI_CCGF_VF2 "
                            + "INNER JOIN FICHA_CADASTRO_PAI_PSICOSOCIAL "
                            + "ON FICHA_CADASTRO_PAI_CCGF_VF2.IdPai=FICHA_CADASTRO_PAI_PSICOSOCIAL.IdPai "
                            + "INNER JOIN VISITASINTERNO "
                            + "ON FICHA_CADASTRO_PAI_CCGF_VF2.IdVisita=VISITASINTERNO.IdVisita "
                            + "WHERE FICHA_CADASTRO_PAI_CCGF_VF2.IdPai='" + jCodigoPAI.getText() + "'");
                    JOptionPane.showMessageDialog(null, "Registro gravado com sucesso.");
                }
                if (acao == 10) {
                    objSocial2Vista.setUsuarioUp(nameUser);
                    objSocial2Vista.setDataUp(dataModFinal);
                    objSocial2Vista.setHorarioUp(horaMov);
                    //
                    objSocial2Vista.setIdSol2Visita(idSol2VisitaIntima);
                    controlVisitaIntima.alterarVisitaIntimaPsicoSocial(objSocial2Vista);
                    //
                    objLog4();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    SalvarVisitaIntima();
                    preencherTabelaVisitasIntimas("SELECT * FROM FICHA_CADASTRO_PAI_CCGF_VF2 "
                            + "INNER JOIN FICHA_CADASTRO_PAI_PSICOSOCIAL "
                            + "ON FICHA_CADASTRO_PAI_CCGF_VF2.IdPai=FICHA_CADASTRO_PAI_PSICOSOCIAL.IdPai "
                            + "INNER JOIN VISITASINTERNO "
                            + "ON FICHA_CADASTRO_PAI_CCGF_VF2.IdVisita=VISITASINTERNO.IdVisita "
                            + "WHERE FICHA_CADASTRO_PAI_CCGF_VF2.IdPai='" + jCodigoPAI.getText() + "'");
                    JOptionPane.showMessageDialog(null, "Registro gravado com sucesso.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a gravar registro.");
        }
    }//GEN-LAST:event_jBtSalvarVisitaIntimaActionPerformed

    private void jBtCancelarVisitaIntimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarVisitaIntimaActionPerformed
        // TODO add your handling code here:
        CancelarVisitaIntima();
    }//GEN-LAST:event_jBtCancelarVisitaIntimaActionPerformed

    private void jBtAlterarVisitaIntimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarVisitaIntimaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPaiCCGFVisInt_SS);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaPaiCCGFVisInt_SS) && codAlterar == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            acao = 10;
            bloquearCampos();
            AlterarVisitaIntima();
            statusMov = "Alterou";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a alterar registro.");
        }
    }//GEN-LAST:event_jBtAlterarVisitaIntimaActionPerformed

    private void jBtExcluirVisitaIntimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirVisitaIntimaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPaiCCGFVisInt_SS);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaPaiCCGFVisInt_SS) && codExcluir == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            bloquearCampos();
            bloquearBotoes();
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objSocial2Vista.setIdSol2Visita(idSol2VisitaIntima);
                controlVisitaIntima.excluirVisitaIntimaPsicoSocial(objSocial2Vista);
                objLog4();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                preencherTabelaVisitasIntimas("SELECT * FROM FICHA_CADASTRO_PAI_CCGF_VF2 "
                        + "INNER JOIN FICHA_CADASTRO_PAI_PSICOSOCIAL "
                        + "ON FICHA_CADASTRO_PAI_CCGF_VF2.IdPai=FICHA_CADASTRO_PAI_PSICOSOCIAL.IdPai "
                        + "INNER JOIN VISITASINTERNO "
                        + "ON FICHA_CADASTRO_PAI_CCGF_VF2.IdVisita=VISITASINTERNO.IdVisita "
                        + "WHERE FICHA_CADASTRO_PAI_CCGF_VF2.IdPai='" + jCodigoPAI.getText() + "'");
                ExcluirVisitaIntima();
                JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a excluir registro.");
        }
    }//GEN-LAST:event_jBtExcluirVisitaIntimaActionPerformed

    private void jBtAuditoriaVisitaIntimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaVisitaIntimaActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaPAI_CCGF_FAM3 objAudCCGF_FAM3 = new TelaAuditoriaPAI_CCGF_FAM3();
        TelaModuloServicoSocial.jPainelServicoSocial.add(objAudCCGF_FAM3);
        objAudCCGF_FAM3.show();
    }//GEN-LAST:event_jBtAuditoriaVisitaIntimaActionPerformed

    private void jBtNovaVisitaIntimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovaVisitaIntimaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPaiCCGFVisInt_SS);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaPaiCCGFVisInt_SS) && codIncluir == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            acao = 9;
            bloquearCampos();
            NovaVisitaIntima();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a incluir registro.");
        }
    }//GEN-LAST:event_jBtNovaVisitaIntimaActionPerformed

    private void jBtAuditoriaTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaTOActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaPAI_DEME objAudDEME = new TelaAuditoriaPAI_DEME();
        TelaModuloServicoSocial.jPainelServicoSocial.add(objAudDEME);
        objAudDEME.show();
    }//GEN-LAST:event_jBtAuditoriaTOActionPerformed

    private void jBtNovoTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoTOActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPaiDEME_SS);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaPaiDEME_SS) && codIncluir == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            acao = 11;
            bloquearCampos();
            NovoTOPed();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a incluir registro.");
        }
    }//GEN-LAST:event_jBtNovoTOActionPerformed

    private void jBtAlterarTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarTOActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPaiDEME_SS);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaPaiDEME_SS) && codAlterar == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            acao = 12;
            bloquearCampos();
            AlterarTOPed();
            statusMov = "Alterou";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a incluir registro.");
        }
    }//GEN-LAST:event_jBtAlterarTOActionPerformed

    private void jBtExcluirTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirTOActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPaiDEME_SS);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaPaiDEME_SS) && codExcluir == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objFichaDeme.setIdPai(Integer.parseInt(jCodigoPAI.getText()));
                controle3.excluirPAI_DEME(objFichaDeme);
                objLog5();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                bloquearCampos();
                ExcluirTOPed();
                JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a incluir registro.");
        }
    }//GEN-LAST:event_jBtExcluirTOActionPerformed

    private void jBtSalvarTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarTOActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPaiDEME_SS);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaPaiDEME_SS) && codGravar == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            verificarTOPED();
            objFichaDeme.setIdPai(Integer.valueOf(jCodigoPAI.getText()));
            objFichaDeme.setIdInternoCrc(Integer.valueOf(jIdInternoPAI.getText()));
            objFichaDeme.setNomeInternoCrc(jNomeInternoPAI.getText());
            objFichaDeme.setNecessitaFamilia((String) jComboBoxNecessitaFamilia.getSelectedItem());
            objFichaDeme.setParaQuemFamilia(jParaQuemFamilia.getText());
            objFichaDeme.setEstaGravida((String) jComboBoxEstaGravida.getSelectedItem());
            objFichaDeme.setComprovacao((String) jComboBoxComprovacao.getSelectedItem());
            objFichaDeme.setPreNatal((String) jComboBoxPreNatal.getSelectedItem());
            objFichaDeme.setOndePreNatal(jOndePreNatal.getText());
            objFichaDeme.setDestinoBebe((String) jComboBoxDestinoBebe.getSelectedItem());
            objFichaDeme.setSuspeitaGravidez((String) jComboBoxSuspeitaGravidez.getSelectedItem());
            objFichaDeme.setQuantosPartos(Integer.valueOf(jQuantosPartos.getText()));
            objFichaDeme.setQuantosAbortos(Integer.valueOf(jQuantosAbortos.getText()));
            objFichaDeme.setQuantosPartosNornais(Integer.valueOf(jQuantosPartosNornais.getText()));
            objFichaDeme.setQuantasCesarianas(Integer.valueOf(jQuantasCesarianas.getText()));
            objFichaDeme.setContraceptivos((String) jComboBoxContraceptivos.getSelectedItem());
            objFichaDeme.setQualContraceptivos(jQualContraceptivos.getText());
            objFichaDeme.setDemanda((String) jComboBoxDemanda.getSelectedItem());
            objFichaDeme.setQualDemanda(jQualDemanda.getText());
            objFichaDeme.setInstrucao((String) jComboBoxInstrucao.getSelectedItem());
            objFichaDeme.setEstudandoPreso((String) jComboBoxEstudandoPreso.getSelectedItem());
            objFichaDeme.setParticipouPrisional((String) jComboBoxParticipouPrisional.getSelectedItem());
            objFichaDeme.setGostariaPrisional((String) jComboBoxGostariaPrisional.getSelectedItem());
            if (acao == 11) {
                if (objFichaDeme.getIdPai() == codigoPaiTOPED && objFichaDeme.getIdInternoCrc() == codigoInternoTOPED) {
                    JOptionPane.showMessageDialog(rootPane, "Já foi realizado um registro para esse interno.");
                } else {
                    objFichaDeme.setUsuarioInsert(nameUser);
                    objFichaDeme.setDataInsert(dataModFinal);
                    objFichaDeme.setHorarioInsert(horaMov);
                    controle3.incluirPAI_DEME(objFichaDeme);
                    buscarCodTOPED();
                    objLog5();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    SalvarTOPed();
                    verificarRegistrosTodasAbas();
                    JOptionPane.showMessageDialog(null, "Registro gravado com sucesso.");
                }
            }
            if (acao == 12) {
                objFichaDeme.setUsuarioUp(nameUser);
                objFichaDeme.setDataUp(dataModFinal);
                objFichaDeme.setHorarioUp(horaMov);
                objFichaDeme.setIdDEME(codTeraPed);
                controle3.alterarPAI_DEME(objFichaDeme);
                objLog5();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                SalvarTOPed();
                verificarRegistrosTodasAbas();
                JOptionPane.showMessageDialog(null, "Registro gravado com sucesso.");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a incluir registro.");
        }
    }//GEN-LAST:event_jBtSalvarTOActionPerformed

    private void jBtCancelarTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarTOActionPerformed
        // TODO add your handling code here:
        CancelarTOPed();
    }//GEN-LAST:event_jBtCancelarTOActionPerformed

    private void jBtSairTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairTOActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairTOActionPerformed

    private void jBtAuditoriaPSIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaPSIActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaPAI_DPTI objAudPAI_DPTI = new TelaAuditoriaPAI_DPTI();
        TelaModuloServicoSocial.jPainelServicoSocial.add(objAudPAI_DPTI);
        objAudPAI_DPTI.show();
    }//GEN-LAST:event_jBtAuditoriaPSIActionPerformed

    private void jBtNovoPSIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoPSIActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPaiDPTL_SS);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaPaiDPTL_SS) && codIncluir == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            acao = 13;
            bloquearCampos();
            NovoPSI();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a incluir registro.");
        }
    }//GEN-LAST:event_jBtNovoPSIActionPerformed

    private void jBtAlterarPSIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarPSIActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPaiDPTL_SS);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaPaiDPTL_SS) && codAlterar == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            acao = 14;
            bloquearCampos();
            AlterarPSI();
            statusMov = "Alterou";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a alterar registro.");
        }
    }//GEN-LAST:event_jBtAlterarPSIActionPerformed

    private void jBtExcluirPSIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirPSIActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPaiDPTL_SS);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaPaiDPTL_SS) && codExcluir == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objFichaDPTL.setIdPai(Integer.parseInt(jCodigoPAI.getText()));
                controle4.excluirPAI_DPTL(objFichaDPTL);
                objLog6();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                bloquearCampos();
                ExcluirPSI();
                JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a excluir registro.");
        }
    }//GEN-LAST:event_jBtExcluirPSIActionPerformed

    private void jBtSalvarPSIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarPSIActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPaiDPTL_SS);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaPaiDPTL_SS) && codGravar == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            DecimalFormat valorReal = new DecimalFormat("#,###.00");
            valorReal.setCurrency(Currency.getInstance(new Locale("pt", "BR")));
            verificarCodigoPSI();
            objFichaDPTL.setProfissaoOcupacao(jProfissaoOcupacao.getText());
            objFichaDPTL.setTrabalhaDetido((String) jComboBoxTrabalhaDetido.getSelectedItem());
            objFichaDPTL.setDesempregado((String) jComboBoxDesempregado.getSelectedItem());
            objFichaDPTL.setCarteiraAssinada((String) jComboBoxCarteiraAssinada.getSelectedItem());
            objFichaDPTL.setQuantoTempoCarteira(Integer.valueOf(jQuantoTempoCarteira.getText()));
            try {
                objFichaDPTL.setFaixaSalarial(valorReal.parse(jFaixaSalarial.getText()).doubleValue());
            } catch (ParseException ex) {
                Logger.getLogger(TelaInventarioProdutosAC.class.getName()).log(Level.SEVERE, null, ex);
            }
            objFichaDPTL.setTemBeneficios((String) jComboBoxTemBeneficios.getSelectedItem());
            objFichaDPTL.setQuemTemBeneficios(jQuemTemBeneficios.getText());
            objFichaDPTL.setDemandaReclusao((String) jComboBoxDemanda.getSelectedItem());
            objFichaDPTL.setDemandaDesemprego((String) jComboBoxDemandaDesemprego.getSelectedItem());
            objFichaDPTL.setPossuiRedimento((String) jComboBoxPossuiRedimento.getSelectedItem());
            objFichaDPTL.setQualRendimento(jQualRendimento.getText());
            objFichaDPTL.setExerceAtividade((String) jComboBoxExerceAtividade.getSelectedItem());
            objFichaDPTL.setQualAtividadeExerce(jQualAtividadeExerce.getText());
            objFichaDPTL.setGeracaoRenda((String) jComboBoxGeracaoRenda.getSelectedItem());
            objFichaDPTL.setAptidaoProfissional((String) jComboBoxAptidaoProfissional.getSelectedItem());
            objFichaDPTL.setQualAptidao(jQualAptidao.getText());
            objFichaDPTL.setDemandaProfissional((String) jComboBoxDemandaProfissional.getSelectedItem());
            objFichaDPTL.setQualDemandaProfissional(jQualDemandaProfissional.getText());
            objFichaDPTL.setAptidaoArt((String) jComboBoxAptidaoArt.getSelectedItem());
            objFichaDPTL.setQualAptidaoArt(jQualAptidaoArt.getText());
            objFichaDPTL.setDemandaLazer((String) jComboBoxDemandaLazer.getSelectedItem());
            objFichaDPTL.setQualDemandaLazer(jQualDemandaLazer.getText());
            objFichaDPTL.setIdPai(Integer.valueOf(jCodigoPAI.getText()));
            objFichaDPTL.setIdInternoCrc(Integer.valueOf(jIdInternoPAI.getText()));
            objFichaDPTL.setNomeInternoCrc(jNomeInternoPAI.getText());
            if (acao == 13) {
                if (objFichaDPTL.getIdPai() == codigoPaiPSI && objFichaDPTL.getIdInternoCrc() == codigoInternoPSI) {
                    JOptionPane.showMessageDialog(rootPane, "Já foi realizado um registro para esse interno.");
                } else {
                    objFichaDPTL.setUsuarioInsert(nameUser);
                    objFichaDPTL.setDataInsert(dataModFinal);
                    objFichaDPTL.setHorarioInsert(horaMov);
                    controle4.incluirPAI_DPTL(objFichaDPTL);
                    buscarCodigoPSI();
                    //
                    objLog6();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    SalvarPSI();
                    verificarRegistrosTodasAbas();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso !!!");
                }
            }
            if (acao == 14) {
                objFichaDPTL.setUsuarioUp(nameUser);
                objFichaDPTL.setDataUp(dataModFinal);
                objFichaDPTL.setHorarioUp(horaMov);
                //
                objFichaDPTL.setIdPai(Integer.valueOf(jCodigoPAI.getText()));
                controle4.alterarPAI_DPTL(objFichaDPTL);
                //
                objLog6();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                SalvarPSI();
                verificarRegistrosTodasAbas();
                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso !!!");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a gravar registro.");
        }
    }//GEN-LAST:event_jBtSalvarPSIActionPerformed

    private void jBtCancelarPSIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarPSIActionPerformed
        // TODO add your handling code here:
        CancelarPSI();
    }//GEN-LAST:event_jBtCancelarPSIActionPerformed

    private void jBtSairPSIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairPSIActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairPSIActionPerformed

    private void jBtAuditoriaDJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaDJActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaPAI_DJ objAudPAI_DJ = new TelaAuditoriaPAI_DJ();
        TelaModuloServicoSocial.jPainelServicoSocial.add(objAudPAI_DJ);
        objAudPAI_DJ.show();
    }//GEN-LAST:event_jBtAuditoriaDJActionPerformed

    private void jBtNovoDJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoDJActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPaiDJ_SS);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaPaiDJ_SS) && codIncluir == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            acao = 17;
            bloquearCampos();
            bloquearBotoes();
            NovoDJ();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a incluir registro.");
        }
    }//GEN-LAST:event_jBtNovoDJActionPerformed

    private void jBtAlterarDJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarDJActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPaiDJ_SS);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaPaiDJ_SS) && codAlterar == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            acao = 18;
            bloquearCampos();
            bloquearBotoes();
            AlterarDJ();
            statusMov = "Alterou";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a alterar registro.");
        }
    }//GEN-LAST:event_jBtAlterarDJActionPerformed

    private void jBtExcluirDJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirDJActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPaiDJ_SS);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaPaiDJ_SS) && codExcluir == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objFichaDJ.setIdPai(Integer.parseInt(jCodigoPAI.getText()));
                controle5.excluirPAI_DJ(objFichaDJ);
                objLog7();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                bloquearCampos();
                ExcluirDJ();
                JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a excluir registro.");
        }
    }//GEN-LAST:event_jBtExcluirDJActionPerformed

    private void jBtSalvarDJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarDJActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPaiDJ_SS);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaPaiDJ_SS) && codGravar == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            verificarCodigoDJ();
            objFichaDJ.setIdPai(Integer.valueOf(jCodigoPAI.getText()));
            objFichaDJ.setIdInternoCrc(Integer.valueOf(jIdInternoPAI.getText()));
            objFichaDJ.setNomeInternoCrc(jNomeInternoPAI.getText());
            //
            objFichaDJ.setRegimeAprisionamento((String) jComboBoxRegimeAprisionamento.getSelectedItem());
            objFichaDJ.setArtigo(Integer.valueOf(jArtigo.getText()));
            objFichaDJ.setDelito(jDelito.getText());
            objFichaDJ.setReincidente((String) jComboBoxReincidente.getSelectedItem());
            objFichaDJ.setPossuiPena((String) jComboBoxPossuiPena.getSelectedItem());
            objFichaDJ.setQualPena((String) jComboBoxQualPena.getSelectedItem());
            objFichaDJ.setPossuiJuridica((String) jComboBoxPossuiJuridica.getSelectedItem());
            objFichaDJ.setQualAssistenciaJuridica((String) jComboBoxQualAssistenciaJuridica.getSelectedItem());
            objFichaDJ.setpROMAE((String) jComboBoxPROMAE.getSelectedItem());
            objFichaDJ.setAssistenciaJuridica((String) jComboBoxAssistenciaJuridica.getSelectedItem());
            objFichaDJ.setTrabalhaempresa((String) jComboBoxTrabalhaempresa.getSelectedItem());
            objFichaDJ.setTelefoneContatoEmpresa(jTelefoneContatoEmpresa.getText());
            objFichaDJ.setQualEmpresa(jQualEmpresa.getText());
            objFichaDJ.setQualFuncaoExerce(jQualFuncaoExerce.getText());
            objFichaDJ.setCartaInformal((String) jComboBoxCartaInformal.getSelectedItem());
            objFichaDJ.setParaOnde(jParaOnde.getText());
            objFichaDJ.setTelefoneContato(jTelefoneContato.getText());
            objFichaDJ.setEstudaUP((String) jComboBoxEstudaUP.getSelectedItem());
            objFichaDJ.setOndeEstuda(jOndeEstuda.getText());
            objFichaDJ.setNecessitaTrabalho((String) jComboBoxNecessitaTrabalho.getSelectedItem());
            objFichaDJ.setQualNecessitaTrabalho(jQualNecessitaTrabalho.getText());
            objFichaDJ.setNecessitaEstudaFUP((String) jComboBoxNecessitaEstudaFUP.getSelectedItem());
            objFichaDJ.setQualNecessidadeEstudaFUP(jQualNecessidadeEstudaFUP.getText());
            //
            if (acao == 17) {
                if (objFichaDJ.getIdPai() == codigoPaiDJ && objFichaDJ.getIdInternoCrc() == codigoInternoDJ) {
                    JOptionPane.showMessageDialog(rootPane, "Já foi realizado um registro para esse interno.");
                } else {
                    objFichaDJ.setUsuarioInsert(nameUser);
                    objFichaDJ.setDataInsert(dataModFinal);
                    objFichaDJ.setHorarioInsert(horaMov);
                    controle5.incluirPAI_DJ(objFichaDJ);
                    buscarCodigoDJ();
                    objLog7();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    SalvarDJ();
                    verificarRegistrosTodasAbas();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso !!!");
                }
            }
            if (acao == 18) {
                objFichaDJ.setUsuarioUp(nameUser);
                objFichaDJ.setDataUp(dataModFinal);
                objFichaDJ.setHorarioUp(horaMov);
                objFichaDJ.setIdPai(Integer.valueOf(jCodigoPAI.getText()));
                controle5.alterarPAI_DJ(objFichaDJ);
                objLog7();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                SalvarDJ();
                verificarRegistrosTodasAbas();
                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso !!!");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a gravar registro.");
        }
    }//GEN-LAST:event_jBtSalvarDJActionPerformed

    private void jBtCancelarDJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarDJActionPerformed
        // TODO add your handling code here:
        CancelarDJ();
    }//GEN-LAST:event_jBtCancelarDJActionPerformed

    private void jBtSairDJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairDJActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairDJActionPerformed

    private void jBtAuditoriaSS3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaSS3ActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaPAI_DS objAudPAI_DS = new TelaAuditoriaPAI_DS();
        TelaModuloServicoSocial.jPainelServicoSocial.add(objAudPAI_DS);
        objAudPAI_DS.show();
    }//GEN-LAST:event_jBtAuditoriaSS3ActionPerformed

    private void jBtNovoSS3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoSS3ActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPaiDS_SS);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaPaiDS_SS) && codIncluir == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            acao = 19;
            bloquearCampos();
            bloquearBotoes();
            NovoSS3();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a incluir registro.");
        }
    }//GEN-LAST:event_jBtNovoSS3ActionPerformed

    private void jBtAlterarSS3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarSS3ActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPaiDS_SS);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaPaiDS_SS) && codAlterar == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            acao = 20;
            bloquearCampos();
            bloquearBotoes();
            AlterarSS3();
            statusMov = "Alterou";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a alterar registro.");
        }
    }//GEN-LAST:event_jBtAlterarSS3ActionPerformed

    private void jBtExcluirSS3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirSS3ActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPaiDS_SS);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaPaiDS_SS) && codExcluir == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objFichaDS.setIdPai(Integer.parseInt(jCodigoPAI.getText()));
                controle6.excluirPAI_DS(objFichaDS);
                objLog8();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                bloquearCampos();
                bloquearBotoes();
                ExcluirSS3();
                JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a excluir registro.");
        }
    }//GEN-LAST:event_jBtExcluirSS3ActionPerformed

    private void jBtSalvarSS3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarSS3ActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPaiDS_SS);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaPaiDS_SS) && codGravar == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            verificarCodigoSS3();
            objFichaDS.setIdPai(Integer.valueOf(jCodigoPAI.getText()));
            objFichaDS.setIdInternoCrc(Integer.valueOf(jIdInternoPAI.getText()));
            objFichaDS.setNomeInternoCrc(jNomeInternoPAI.getText());
            objFichaDS.setRefereSaude((String) jComboBoxRefereSaude.getSelectedItem());
            if (jRBHanseniase.isSelected()) {
                tipoHanseniase = 1;
            } else if (!jRBHanseniase.isSelected()) {
                tipoHanseniase = 0;
            }
            objFichaDS.setHanseniase(tipoHanseniase);
            if (jRBDiabetes.isSelected()) {
                tipoDiabetes = 1;
            } else if (!jRBDiabetes.isSelected()) {
                tipoDiabetes = 0;
            }
            objFichaDS.setDiabetes(tipoDiabetes);
            if (jRBTuberculose.isSelected()) {
                tipoTuberculose = 1;
            } else if (!jRBTuberculose.isSelected()) {
                tipoTuberculose = 0;
            }
            objFichaDS.setTuberculose(tipoTuberculose);
            if (jRBHipertensao.isSelected()) {
                tipoHipertensao = 1;
            } else if (!jRBHipertensao.isSelected()) {
                tipoHipertensao = 0;
            }
            objFichaDS.setHipertensao(tipoHipertensao);
            if (jRBHepatites.isSelected()) {
                tipoHepatites = 1;
            } else if (!jRBHepatites.isSelected()) {
                tipoHepatites = 0;
            }
            objFichaDS.setHepatites(tipoHepatites);
            if (jRBSifilis.isSelected()) {
                tipoSifilis = 1;
            } else if (!jRBSifilis.isSelected()) {
                tipoSifilis = 0;
            }
            objFichaDS.setSifilis(tipoSifilis);
            if (jRBEscabiose.isSelected()) {
                tipoEscabiose = 1;
            } else if (!jRBEscabiose.isSelected()) {
                tipoEscabiose = 0;
            }
            objFichaDS.setEscabiose(tipoEscabiose);
            if (jRBHIV.isSelected()) {
                tipoHiv = 1;
            } else if (!jRBHIV.isSelected()) {
                tipoHiv = 0;
            }
            objFichaDS.sethIV(tipoHiv);
            objFichaDS.setOutrasDoencas(jOutrasDoencas.getText());
            objFichaDS.setFazendoTratamento((String) jComboBoxFazendoTratamento.getSelectedItem());
            objFichaDS.setPsiquiatrico((String) jComboBoxPsiquiatrico.getSelectedItem());
            objFichaDS.setOndePsiquiatrico(jOndePsiquiatrico.getText());
            objFichaDS.setPsicotropico((String) jComboBoxPsicotropico.getSelectedItem());
            objFichaDS.setQualPsicotropico(jQualPsicotropico.getText());
            objFichaDS.setMental((String) jComboBoxMental.getSelectedItem());
            if (jRBDesanimo.isSelected()) {
                tipoDesanimo = 1;
            } else if (!jRBDesanimo.isSelected()) {
                tipoDesanimo = 0;
            }
            objFichaDS.setDesanimo(tipoDesanimo);
            if (jRBInsonia.isSelected()) {
                tipoInsonia = 1;
            } else if (!jRBInsonia.isSelected()) {
                tipoInsonia = 0;
            }
            objFichaDS.setInsonia(tipoInsonia);
            if (jRBFaltaApetite.isSelected()) {
                tipoFaltaApetite = 1;
            } else if (!jRBFaltaApetite.isSelected()) {
                tipoFaltaApetite = 0;
            }
            objFichaDS.setFaltaApetite(tipoFaltaApetite);
            if (jRBIsomantoSocial.isSelected()) {
                tipoIsolamentoSocial = 1;
            } else if (!jRBIsomantoSocial.isSelected()) {
                tipoIsolamentoSocial = 0;
            }
            objFichaDS.setIsolamentoSocial(tipoIsolamentoSocial);
            if (jRBPensamentosSuicida.isSelected()) {
                tipoPensamentosSuicida = 1;
            } else if (!jRBPensamentosSuicida.isSelected()) {
                tipoPensamentosSuicida = 0;
            }
            objFichaDS.setPensamentosSuicidas(tipoPensamentosSuicida);
            if (jRBAgressividade.isSelected()) {
                tipoAgressividade = 1;
            } else if (!jRBAgressividade.isSelected()) {
                tipoAgressividade = 0;
            }
            objFichaDS.setAgressividade(tipoAgressividade);
            if (jRBInquientacao.isSelected()) {
                tipoInquietacaoMotora = 1;
            } else if (!jRBInquientacao.isSelected()) {
                tipoInquietacaoMotora = 0;
            }
            objFichaDS.setInquietacao(tipoInquietacaoMotora);
            if (jRBOutrosDoencas.isSelected()) {
                tipoOutrasDoencas = 1;
            } else if (!jRBOutrosDoencas.isSelected()) {
                tipoOutrasDoencas = 0;
            }
            objFichaDS.setOutroDoencas(tipoOutrasDoencas);
            objFichaDS.setQualOutrosDoencas(jQualOutrosDoencas.getText());
            objFichaDS.setInternadoPSI((String) jComboBoxInternadoPSI.getSelectedItem());
            objFichaDS.setDataInternaPSI(jDataInternaPSI.getDate());
            objFichaDS.setAcompanhaCAPS((String) jComboBoxAcompanhaCAPS.getSelectedItem());
            objFichaDS.setDataCAPS(jDataCAPS.getDate());
            objFichaDS.setUsoPsicoativos((String) jComboBoxUsoPsicoativos.getSelectedItem());
            if (jRBAlcool.isSelected()) {
                tipoAlcool = 1;
            } else if (!jRBAlcool.isSelected()) {
                tipoAlcool = 0;
            }
            if (jRBMaconha.isSelected()) {
                tipoMaconha = 1;
            } else if (!jRBMaconha.isSelected()) {
                tipoMaconha = 0;
            }
            objFichaDS.setMaconha(tipoMaconha);
            if (jRBCocaina.isSelected()) {
                tipoCocaina = 1;
            } else if (!jRBCocaina.isSelected()) {
                tipoCocaina = 0;
            }
            objFichaDS.setCocaina(tipoCocaina);
            if (jRBCola.isSelected()) {
                tipoCola = 1;
            } else if (!jRBCola.isSelected()) {
                tipoCola = 0;
            }
            objFichaDS.setCola(tipoCola);
            if (jRBCrack.isSelected()) {
                tipoCrack = 1;
            } else if (!jRBCrack.isSelected()) {
                tipoCrack = 0;
            }
            objFichaDS.setCrack(tipoCrack);
            if (jRBInjetaveis.isSelected()) {
                tipoInjetaveis = 1;
            } else if (!jRBInjetaveis.isSelected()) {
                tipoInjetaveis = 0;
            }
            objFichaDS.setInjetaveis(tipoInjetaveis);
            if (jRBOutrasSub.isSelected()) {
                tipoOutrasDoencas = 1;
            } else if (!jRBOutrasSub.isSelected()) {
                tipoOutrasDoencas = 0;
            }
            objFichaDS.setOutrasSub(tipoOutrasDoencas);
            objFichaDS.setQualOutrasSub(jQualOutrasSub.getText());
            objFichaDS.setCompartilhaCrack((String) jComboBoxCompartilhaCrack.getSelectedItem());
            if (jRBSudorese.isSelected()) {
                tipoSudorese = 1;
            } else if (!jRBSudorese.isSelected()) {
                tipoSudorese = 0;
            }
            objFichaDS.setSudorese(tipoSudorese);
            if (jRBTremores.isSelected()) {
                tipoTremores = 1;
            } else if (!jRBTremores.isSelected()) {
                tipoTremores = 0;
            }
            objFichaDS.setTremores(tipoTremores);
            if (jRBFissura.isSelected()) {
                tipoFissura = 1;
            } else if (!jRBFissura.isSelected()) {
                tipoFissura = 0;
            }
            objFichaDS.setFissura(tipoFissura);
            if (jRBBoca.isSelected()) {
                tipoBocaSeca = 1;
            } else if (!jRBBoca.isSelected()) {
                tipoBocaSeca = 0;
            }
            objFichaDS.setBocaSeca(tipoBocaSeca);
            if (jRBNausea.isSelected()) {
                tipoNauseas = 1;
            } else if (!jRBNausea.isSelected()) {
                tipoNauseas = 0;
            }
            objFichaDS.setNausea(tipoNauseas);
            if (jRBDesejo.isSelected()) {
                tipoDesejo = 1;
            } else if (!jRBDesejo.isSelected()) {
                tipoDesejo = 0;
            }
            objFichaDS.setDesejo(tipoDesejo);
            if (jRBNaoPara.isSelected()) {
                tipoNaoconseguir = 1;
            } else if (!jRBNaoPara.isSelected()) {
                tipoNaoconseguir = 0;
            }
            objFichaDS.setNaoPara(tipoNaoconseguir);
            if (jRBAumentoTolerancia.isSelected()) {
                tipoAumentoTolerancia = 1;
            } else if (!jRBAumentoTolerancia.isSelected()) {
                tipoAumentoTolerancia = 0;
            }
            objFichaDS.setAumentoTolerancia(tipoAumentoTolerancia);
            objFichaDS.setcAPSAD((String) jComboBoxCAPSAD.getSelectedItem());
            objFichaDS.setDataCAPSAD(jDataCAPSAD.getDate());
            objFichaDS.setEsteveInternado((String) jComboBoxEsteveInternado.getSelectedItem());
            objFichaDS.setQuantoTempoInternado(Integer.valueOf(jQuantoTempoInternado.getText()));
            objFichaDS.setAceitaDanos((String) jComboBoxAceitaDanos.getSelectedItem());
            objFichaDS.setSaudeBucal((String) jComboBoxSaudeBucal.getSelectedItem());
            objFichaDS.setNecessitaAtende((String) jComboBoxNecessitaAtende.getSelectedItem());
            if (jRBEnfermagem.isSelected()) {
                tipoEnfermagem = 1;
            } else if (!jRBEnfermagem.isSelected()) {
                tipoEnfermagem = 0;
            }
            objFichaDS.setEnfermagem(tipoEnfermagem);
            if (jRBMedico.isSelected()) {
                tipoMedico = 1;
            } else if (!jRBMedico.isSelected()) {
                tipoMedico = 0;
            }
            objFichaDS.setMedico(tipoMedico);
            if (jRBPsiquiatrico.isSelected()) {
                tipoPsiquiatrico = 1;
            } else if (!jRBPsiquiatrico.isSelected()) {
                tipoPsiquiatrico = 0;
            }
            objFichaDS.setPsiquiatricoN(tipoPsiquiatrico);
            if (jRBPsicologico.isSelected()) {
                tipoPsicologico = 1;
            } else if (!jRBPsicologico.isSelected()) {
                tipoPsicologico = 0;
            }
            objFichaDS.setPsiquiatricoN(tipoPsiquiatrico);
            objFichaDS.setPessoasQuimica((String) jComboBoxPessoasQuimica.getSelectedItem());
            objFichaDS.setQuemNecessita(jQuemNecessita.getText());
            if (acao == 19) {
                if (objFichaDS.getIdPai() == codigoPaiSS3 && objFichaDS.getIdInternoCrc() == codigoInternoSS3) {
                    JOptionPane.showMessageDialog(rootPane, "Já foi realizado um registro para esse interno.");
                } else {
                    objFichaDS.setUsuarioInsert(nameUser);
                    objFichaDS.setDataInsert(dataModFinal);
                    objFichaDS.setHorarioInsert(horaMov);
                    controle6.incluirPAI_DS(objFichaDS);
                    objLog8();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    SalvarSS3();
                    verificarRegistrosTodasAbas();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso !!!");
                }
            }
            if (acao == 20) {
                objFichaDS.setUsuarioUp(nameUser);
                objFichaDS.setDataUp(dataModFinal);
                objFichaDS.setHorarioUp(horaMov);
                objFichaDS.setIdPai(Integer.valueOf(jCodigoPAI.getText()));
                controle6.alterarPAI_DS(objFichaDS);
                objLog8();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                SalvarSS3();
                verificarRegistrosTodasAbas();
                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso !!!");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a gravar registro.");
        }
    }//GEN-LAST:event_jBtSalvarSS3ActionPerformed

    private void jBtCancelarSS3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarSS3ActionPerformed
        // TODO add your handling code here:
        CancelarSS3();
    }//GEN-LAST:event_jBtCancelarSS3ActionPerformed

    private void jBtSairSS3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairSS3ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairSS3ActionPerformed

    private void jBtAuditoriaEAPI1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaEAPI1ActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaPAI_EAPI objAudPAI_EAPI = new TelaAuditoriaPAI_EAPI();
        TelaModuloServicoSocial.jPainelServicoSocial.add(objAudPAI_EAPI);
        objAudPAI_EAPI.show();
    }//GEN-LAST:event_jBtAuditoriaEAPI1ActionPerformed

    private void jBtNovoEAPI1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoEAPI1ActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPaiEAPI1_SS);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaPaiEAPI1_SS) && codIncluir == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            acao = 21;
            bloquearCampos();
            bloquearBotoes();
            NovoEAPI1();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a incluir registro.");
        }
    }//GEN-LAST:event_jBtNovoEAPI1ActionPerformed

    private void jBtAlterarEAPI1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarEAPI1ActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPaiEAPI1_SS);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaPaiEAPI1_SS) && codAlterar == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            acao = 22;
            bloquearCampos();
            bloquearBotoes();
            AlterarEAPI1();
            statusMov = "Alterou";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a alterar registro.");
        }
    }//GEN-LAST:event_jBtAlterarEAPI1ActionPerformed

    private void jBtExcluirEAPI1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirEAPI1ActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPaiEAPI1_SS);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaPaiEAPI1_SS) && codExcluir == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objEapi1.setIdPai(Integer.parseInt(jCodigoPAI.getText()));
                controle7.excluirPaiEAPI(objEapi1);
                objLog9();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                bloquearCampos();
                bloquearBotoes();
                ExcluirEAPI1();
                JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a excluir registro.");
        }
    }//GEN-LAST:event_jBtExcluirEAPI1ActionPerformed

    private void jBtSalvarEAPI1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarEAPI1ActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPaiEAPI1_SS);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaPaiEAPI1_SS) && codGravar == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            verificarCodigoEAPI1();
            objEapi1.setIdPai(Integer.parseInt(jCodigoPAI.getText()));
            objEapi1.setIdInternoCrc(Integer.valueOf(jIdInternoPAI.getText()));
            objEapi1.setNomeInternoCrc(jNomeInternoPAI.getText());
            objEapi1.setpSP(jTextoPSP.getText());
            objEapi1.setcEDEGEP(jTextoCEDEGEP.getText());
            objEapi1.setcRASCREAS(jTextoCRASCREAS.getText());
            if (acao == 21) {
                if (objEapi1.getIdPai() == codigoPaiEAPI && objEapi1.getIdInternoCrc() == codigoInternoDJ) {
                    JOptionPane.showMessageDialog(rootPane, "Já foi realizado um registro para esse interno.");
                } else {
                    objEapi1.setUsuarioInsert(nameUser);
                    objEapi1.setDataInsert(dataModFinal);
                    objEapi1.setHorarioInsert(horaMov);
                    controle7.incluirPaiEAPI(objEapi1);
                    buscarCodigoEAPI1();
                    objLog9();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    SalvarEAPI1();
                    verificarRegistrosTodasAbas();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso !!!");
                }
            }
            if (acao == 22) {
                objEapi1.setUsuarioUp(nameUser);
                objEapi1.setDataUp(dataModFinal);
                objEapi1.setHorarioUp(horaMov);
                objEapi1.setIdPai(Integer.parseInt(jCodigoPAI.getText()));
                controle7.alterarPaiEAPI(objEapi1);
                objLog9();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                SalvarEAPI1();
                verificarRegistrosTodasAbas();
                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso !!!");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a gravar registro.");
        }
    }//GEN-LAST:event_jBtSalvarEAPI1ActionPerformed

    private void jBtCancelarEAPI1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarEAPI1ActionPerformed
        // TODO add your handling code here:
        CancelarEAPI1();
    }//GEN-LAST:event_jBtCancelarEAPI1ActionPerformed

    private void jBtSairEAPI1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairEAPI1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairEAPI1ActionPerformed

    private void jBtAuditoriaEAPI2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaEAPI2ActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaPAI_EAPI2 objAudPAI_EAPI2 = new TelaAuditoriaPAI_EAPI2();
        TelaModuloServicoSocial.jPainelServicoSocial.add(objAudPAI_EAPI2);
        objAudPAI_EAPI2.show();
    }//GEN-LAST:event_jBtAuditoriaEAPI2ActionPerformed

    private void jBtNovoEAPI2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoEAPI2ActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPaiEAPI2_SS);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaPaiEAPI2_SS) && codIncluir == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            acao = 23;
            bloquearCampos();
            bloquearBotoes();
            NovoEAPI2();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a incluir registro.");
        }
    }//GEN-LAST:event_jBtNovoEAPI2ActionPerformed

    private void jBtAlterarEAPI2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarEAPI2ActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPaiEAPI2_SS);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaPaiEAPI2_SS) && codAlterar == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            acao = 24;
            bloquearCampos();
            bloquearBotoes();
            AlterarEAPI2();
            statusMov = "Alterou";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a alterar registro.");
        }
    }//GEN-LAST:event_jBtAlterarEAPI2ActionPerformed

    private void jBtExcluirEAPI2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirEAPI2ActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPaiEAPI2_SS);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaPaiEAPI2_SS) && codExcluir == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objEapi2.setIdPai(Integer.parseInt(jCodigoPAI.getText()));
                controle8.excluirPaiEAPI2(objEapi2);
                objLog10();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                bloquearCampos();
                ExcluirEAPI2();
                JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a excluir registro.");
        }
    }//GEN-LAST:event_jBtExcluirEAPI2ActionPerformed

    private void jBtSalvarEAPI2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarEAPI2ActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPaiEAPI2_SS);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaPaiEAPI2_SS) && codGravar == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            verificarCodigoEAPI2();
            objEapi2.setIdPai(Integer.valueOf(jCodigoPAI.getText()));
            objEapi2.setIdInternoCrc(Integer.valueOf(jIdInternoPAI.getText()));
            objEapi2.setNomeInternoCrc(jNomeInternoPAI.getText());
            objEapi2.setaSSISTENCIA(jTextoASSISTENCIA.getText());
            objEapi2.setdOCUMENTOCIVIL(jTextoDOCUMENTOCIVIL.getText());
            objEapi2.seteAPI2PAI(jTextEAPI2PAI.getText());
            objEapi2.setTecnicoServicoSocial(jTecnicoServicoSocial.getText());
            objEapi2.setTecnicoPsicologico(jTecnicoPsicologico.getText());
            if (acao == 23) {
                if (objEapi2.getIdPai() == codigoPaiEAPI && objEapi2.getIdInternoCrc() == codigoInternoEAPI) {
                    JOptionPane.showMessageDialog(rootPane, "Já foi realizado um registro para esse interno.");
                } else {
                    objEapi2.setUsuarioInsert(nameUser);
                    objEapi2.setDataInsert(dataModFinal);
                    objEapi2.setHorarioInsert(horaMov);
                    //
                    controle8.incluirPaiEAPI2(objEapi2);
                    buscarCodigoEAPI2();
                    objLog10();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    SalvarEAPI2();
                    verificarRegistrosTodasAbas();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso !!!");
                }
            }
            if (acao == 24) {
                objEapi2.setUsuarioUp(nameUser);
                objEapi2.setDataUp(dataModFinal);
                objEapi2.setHorarioUp(horaMov);
                //
                objEapi2.setIdPai(Integer.valueOf(jCodigoPAI.getText()));
                controle8.excluirPaiEAPI2(objEapi2);
                objLog10();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                SalvarEAPI2();
                verificarRegistrosTodasAbas();
                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso !!!");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a gravar registro.");
        }
    }//GEN-LAST:event_jBtSalvarEAPI2ActionPerformed

    private void jBtCancelarEAPI2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarEAPI2ActionPerformed
        // TODO add your handling code here:
        CancelarEAPI2();
    }//GEN-LAST:event_jBtCancelarEAPI2ActionPerformed

    private void jBtSairEAPI2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairEAPI2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairEAPI2ActionPerformed

    private void jTabelaEvolucaoPAIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaEvolucaoPAIMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            String idEvolucao = "" + jTabelaEvolucaoPAI.getValueAt(jTabelaEvolucaoPAI.getSelectedRow(), 0);
            jIdEvolucao.setText(idEvolucao);
            //
            bloquearCampos();
            //
            jBtNovaEvolucao.setEnabled(true);
            jBtAlterarEvolucao.setEnabled(true);
            jBtExcluirEvolucao.setEnabled(true);
            jBtSalvarEvolucao.setEnabled(!true);
            jBtCancelarEvolucao.setEnabled(true);
            jBtAuditoriaEvolucao.setEnabled(true);
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM EVOLUCAO_PAI_NOVO "
                        + "INNER JOIN FICHA_CADASTRO_PAI_PSICOSOCIAL "
                        + "ON EVOLUCAO_PAI_NOVO.IdPai=FICHA_CADASTRO_PAI_PSICOSOCIAL.IdPai "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON EVOLUCAO_PAI_NOVO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE EVOLUCAO_PAI_NOVO.IdPai='" + jCodigoPAI.getText() + "' "
                        + "AND IdEvolucao='" + idEvolucao + "'");
                conecta.rs.first();
                jIdEvolucao.setText(conecta.rs.getString("IdEvolucao"));
                jDataEvolucao.setDate(conecta.rs.getDate("DataEvolucao"));
                jNomeInternoEvolucaoPAI.setText(conecta.rs.getString("NomeInternoCrc"));
                jTextoEvolucao.setText(conecta.rs.getString("TextoEvolucao"));
            } catch (Exception e) {
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaEvolucaoPAIMouseClicked

    private void jBtAuditoriaEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaEvolucaoActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaPAI_Evolucao objAudEvo = new TelaAuditoriaPAI_Evolucao();
        TelaModuloServicoSocial.jPainelServicoSocial.add(objAudEvo);
        objAudEvo.show();
    }//GEN-LAST:event_jBtAuditoriaEvolucaoActionPerformed

    private void jBtCancelarEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarEvolucaoActionPerformed
        // TODO add your handling code here:
        CancelarEvolucao();
    }//GEN-LAST:event_jBtCancelarEvolucaoActionPerformed

    private void jBtImpressaoEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImpressaoEvolucaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtImpressaoEvolucaoActionPerformed

    private void jBtSalvarEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarEvolucaoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPaiEPAI_SS);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaPaiEPAI_SS) && codGravar == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            if (jNomeInternoEvolucaoPAI.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Informe o nome do interno para evolução.");
            } else if (jDataEvolucao.getDate() == null) {
                JOptionPane.showMessageDialog(null, "Informe a data da evolução.");
            } else {
                objEvolucaoPAI.setDataEvolucaoPAI(jDataEvolucao.getDate());
                objEvolucaoPAI.setIdInternoCrc(Integer.valueOf(jIdInternoPAI.getText()));
                objEvolucaoPAI.setNomeInternoCrc(jNomeInternoEvolucaoPAI.getText());
                objEvolucaoPAI.setTextoEvolucaoPAI(jTextoEvolucao.getText());
                objEvolucaoPAI.setIdPai(Integer.valueOf(jCodigoPAI.getText()));
                if (acao == 25) {
                    objEvolucaoPAI.setUsuarioInsert(nameUser);
                    objEvolucaoPAI.setDataInsert(dataModFinal);
                    objEvolucaoPAI.setHorarioInsert(horaMov);
                    //
                    controleEvo.incluirEvolucaoPAI(objEvolucaoPAI);
                    buscarCodigoEvolucao();
                    //
                    objLog11();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação                
                    preencherTabelaEvolucao("SELECT * FROM EVOLUCAO_PAI_NOVO "
                            + "INNER JOIN FICHA_CADASTRO_PAI_PSICOSOCIAL "
                            + "ON EVOLUCAO_PAI_NOVO.IdPai=FICHA_CADASTRO_PAI_PSICOSOCIAL.IdPai "
                            + "WHERE EVOLUCAO_PAI_NOVO.IdPai='" + jCodigoPAI.getText() + "'");
                    SalvarEvolucao();
                    verificarRegistrosTodasAbas();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso !!!");
                }
                if (acao == 26) {
                    objEvolucaoPAI.setUsuarioUp(nameUser);
                    objEvolucaoPAI.setDataUp(dataModFinal);
                    objEvolucaoPAI.setHorarioUp(horaMov);
                    //
                    objEvolucaoPAI.setIdEvolucaoPAI(Integer.valueOf(jIdEvolucao.getText()));
                    objEvolucaoPAI.setIdInternoCrc(Integer.valueOf(jIdInternoPAI.getText()));
                    objEvolucaoPAI.setNomeInternoCrc(jNomeInternoEvolucaoPAI.getText());
                    controleEvo.alterarEvolucaoPAI(objEvolucaoPAI);
                    //
                    objLog11();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação                
                    preencherTabelaEvolucao("SELECT * FROM EVOLUCAO_PAI_NOVO "
                            + "INNER JOIN FICHA_CADASTRO_PAI_PSICOSOCIAL "
                            + "ON EVOLUCAO_PAI_NOVO.IdPai=FICHA_CADASTRO_PAI_PSICOSOCIAL.IdPai "
                            + "WHERE EVOLUCAO_PAI_NOVO.IdPai='" + jCodigoPAI.getText() + "'");
                    SalvarEvolucao();
                    verificarRegistrosTodasAbas();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso !!!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a alterar registro.");
        }
    }//GEN-LAST:event_jBtSalvarEvolucaoActionPerformed

    private void jBtExcluirEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirEvolucaoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPaiEPAI_SS);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaPaiEPAI_SS) && codExcluir == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM EVOLUCAO_PAI_NOVO "
                        + "WHERE IdEvolucao='" + jIdEvolucao.getText() + "'");
                conecta.rs.first();
                nomeUserRegistro = conecta.rs.getString("UsuarioInsert");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não foi possível encontrar o usuário.");
            }
            if (nomeUserRegistro == null ? nameUser == null : nomeUserRegistro.equals(nameUser)) {
                bloquearCampos();
                statusMov = "Excluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
                bloquearCampos();
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    objEvolucaoPAI.setIdPai(Integer.valueOf(jCodigoPAI.getText()));
                    objEvolucaoPAI.setIdEvolucaoPAI(Integer.valueOf(jIdEvolucao.getText()));
                    objEvolucaoPAI.setIdInternoCrc(Integer.valueOf(jIdInternoPAI.getText()));
                    controleEvo.excluirEvolucaoPAI(objEvolucaoPAI);
                    //
                    objLog11();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    preencherTabelaEvolucao("SELECT * FROM EVOLUCAO_PAI_NOVO "
                            + "INNER JOIN FICHA_CADASTRO_PAI_PSICOSOCIAL "
                            + "ON EVOLUCAO_PAI_NOVO.IdPai=FICHA_CADASTRO_PAI_PSICOSOCIAL.IdPai "
                            + "WHERE EVOLUCAO_PAI_NOVO.IdPai='" + jCodigoPAI.getText() + "'");
                    ExcluirEvolucao();
                    JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esse registro foi inserido pelo " + nomeUserRegistro + " só esse usuário poderá modificar.");
                conecta.desconecta();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a excluir registro.");
        }
    }//GEN-LAST:event_jBtExcluirEvolucaoActionPerformed

    private void jBtAlterarEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarEvolucaoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPaiEPAI_SS);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaPaiEPAI_SS) && codAlterar == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM EVOLUCAO_PAI_NOVO WHERE IdEvolucao='" + jIdEvolucao.getText() + "'");
                conecta.rs.first();
                nomeUserRegistro = conecta.rs.getString("UsuarioInsert");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não foi possível encontrar o usuário.");
            }
            if (nomeUserRegistro == null ? nameUser == null : nomeUserRegistro.equals(nameUser)) {
                acao = 26;
                bloquearCampos();
                AlterarEvolucao();
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esse registro foi inserido pelo " + nomeUserRegistro + " só esse usuário poderá modificar.");
                conecta.desconecta();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a gravar registro.");
        }
    }//GEN-LAST:event_jBtAlterarEvolucaoActionPerformed

    private void jBtNovaEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovaEvolucaoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPaiEPAI_SS);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaPaiEPAI_SS) && codIncluir == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            acao = 25;
            bloquearCampos();
            NovaEvolucao();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a incluir registro.");
        }
    }//GEN-LAST:event_jBtNovaEvolucaoActionPerformed

    private void jRBHepatitesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBHepatitesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRBHepatitesActionPerformed

    private void jBtImpressaoPAIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImpressaoPAIActionPerformed
        // TODO add your handling code here:         
        buscarParametroPAI();
        verificarImpressaoPAI();
        if (jCodigoPAI.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Pesquise o registro antes de imprimir.");
        } else {
            //P.A.I. COM CÁRCERE SOMENTE MASCULINO
            if (pRelPAI.equals("Não")) {
                if (jCodigoPAI.getText().equals(codigoPAI_CCGF)
                        && jCodigoPAI.getText().equals(codigoPAI_DEME)
                        && jCodigoPAI.getText().equals(codigoPAI_DPTL)
                        && jCodigoPAI.getText().equals(codigoPAI_DJ)
                        && jCodigoPAI.getText().equals(codigoPAI_DS)
                        && jCodigoPAI.getText().equals(codigoPAI_EAPI1)
                        && jCodigoPAI.getText().equals(codigoPAI_EAPI2)
                        && jCodigoPAI.getText().equals(codigoPAI_EVOL)) {
                    try {
                        conecta.abrirConexao();
                        String path = "reports/RelatorioPAI.jasper";
                        conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC AS P "
                                + "INNER JOIN DADOSFISICOSINTERNOS AS DF ON P.IdInternoCrc=DF.IdInternoCrc "
                                + "INNER JOIN DADOSPENAISINTERNOS AS DP ON P.IdInternoCrc=DP.IdInternoCrc "
                                + "INNER JOIN CIDADES AS C ON P.IdCidade=C.IdCidade "
                                + "INNER JOIN FICHA_CADASTRO_PAI_PSICOSOCIAL AS PP ON P.IdInternoCrc=PP.IdInternoCrc "
                                + "INNER JOIN FICHA_CADASTRO_PAI_CCGF AS PC ON P.IdInternoCrc=PC.IdInternoCrc "
                                + "INNER JOIN FICHA_CADASTRO_PAI_DEME AS M ON P.IdInternoCrc=M.IdInternoCrc "
                                + "INNER JOIN FICHA_CADASTRO_PAI_DPTL AS DPTL ON P.IdInternoCrc=DPTL.IdInternoCrc "
                                + "INNER JOIN FICHA_CADASTRO_PAI_DJ AS DJ ON P.IdInternoCrc=DJ.IdInternoCrc "
                                + "INNER JOIN FICHA_CADASTRO_PAI_DS AS DS ON P.IdInternoCrc=DS.IdInternoCrc "
                                + "INNER JOIN FICHA_CADASTRO_PAI_EAPI1 AS EAPI1 ON P.IdInternoCrc=EAPI1.IdInternoCrc "
                                + "INNER JOIN FICHA_CADASTRO_PAI_EAPI2 AS EAPI2 ON P.IdInternoCrc=EAPI2.IdInternoCrc "
                                + "INNER JOIN EVOLUCAO_PAI_NOVO AS PN ON P.IdInternoCrc=PN.IdInternoCrc "
                                + "WHERE PP.IdPai='" + jCodigoPAI.getText() + "'");
                        HashMap parametros = new HashMap();
                        parametros.put("CodigoPAI", jCodigoPAI.getText());
                        parametros.put("usuario", nameUser);
                        parametros.put("descricaoUnidade", descricaoUnidade);
                        // Sub Relatório
                        try {
                            parametros.put("REPORT_CONNECTION", conecta.stmt.getConnection());
                        } catch (SQLException ex) {
                        }
                        JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
                        JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
                        JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
                        jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
                        jv.setTitle("P.A.I. - Programa de Assistência Individualizado");
                        jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
                        jv.toFront(); // Traz o relatorio para frente da aplicação            
                        conecta.desconecta();
                    } catch (JRException e) {
                        JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO: " + e);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "É necessário preencher o P.A.I. completamente para poder imprimir.");
                }
                //P.A.I. PARA UNIDADES COM CÁRECE FEMINIO (ITABUNA)
            } else if (pRelPAI.equals("Sim")) {
                if (jCodigoPAI.getText().equals(codigoPAI_CCGF)
                        && jCodigoPAI.getText().equals(codigoPAI_DPTL)
                        && jCodigoPAI.getText().equals(codigoPAI_DJ)
                        && jCodigoPAI.getText().equals(codigoPAI_DS)
                        && jCodigoPAI.getText().equals(codigoPAI_EAPI1)
                        && jCodigoPAI.getText().equals(codigoPAI_EAPI2)
                        && jCodigoPAI.getText().equals(codigoPAI_EVOL)) {
                    try {
                        conecta.abrirConexao();
                        String path = "reports/RelatorioPAI-DEME.jasper";
                        conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC AS P "
                                + "INNER JOIN DADOSFISICOSINTERNOS AS DF ON P.IdInternoCrc=DF.IdInternoCrc "
                                + "INNER JOIN DADOSPENAISINTERNOS AS DP ON P.IdInternoCrc=DP.IdInternoCrc "
                                + "INNER JOIN CIDADES AS C ON P.IdCidade=C.IdCidade "
                                + "INNER JOIN FICHA_CADASTRO_PAI_PSICOSOCIAL AS PP ON P.IdInternoCrc=PP.IdInternoCrc "
                                + "INNER JOIN FICHA_CADASTRO_PAI_CCGF AS PC ON P.IdInternoCrc=PC.IdInternoCrc "
                                + "INNER JOIN FICHA_CADASTRO_PAI_DEME AS M ON P.IdInternoCrc=M.IdInternoCrc "
                                + "INNER JOIN FICHA_CADASTRO_PAI_DPTL AS DPTL ON P.IdInternoCrc=DPTL.IdInternoCrc "
                                + "INNER JOIN FICHA_CADASTRO_PAI_DJ AS DJ ON P.IdInternoCrc=DJ.IdInternoCrc "
                                + "INNER JOIN FICHA_CADASTRO_PAI_DS AS DS ON P.IdInternoCrc=DS.IdInternoCrc "
                                + "INNER JOIN FICHA_CADASTRO_PAI_EAPI1 AS EAPI1 ON P.IdInternoCrc=EAPI1.IdInternoCrc "
                                + "INNER JOIN FICHA_CADASTRO_PAI_EAPI2 AS EAPI2 ON P.IdInternoCrc=EAPI2.IdInternoCrc "
                                + "INNER JOIN EVOLUCAO_PAI_NOVO AS PN ON P.IdInternoCrc=PN.IdInternoCrc "
                                + "WHERE PP.IdPai='" + jCodigoPAI.getText() + "'");
                        HashMap parametros = new HashMap();
                        parametros.put("CodigoPAI", jCodigoPAI.getText());
                        parametros.put("usuario", nameUser);
                        parametros.put("descricaoUnidade", nameUser);
                        // Sub Relatório
                        try {
                            parametros.put("REPORT_CONNECTION", conecta.stmt.getConnection());
                        } catch (SQLException ex) {
                        }
                        JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
                        JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
                        JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
                        jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
                        jv.setTitle("P.A.I. - Programa de Assistência Individualizado");
                        jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
                        jv.toFront(); // Traz o relatorio para frente da aplicação            
                        conecta.desconecta();
                    } catch (JRException e) {
                        JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO: " + e);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "É necessário preencher o P.A.I. completamente para poder imprimir.");
                }
            }
        }
    }//GEN-LAST:event_jBtImpressaoPAIActionPerformed

    private void jBtAssistenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAssistenteActionPerformed
        // TODO add your handling code here:
        mostrarAssistentePsicologo();
    }//GEN-LAST:event_jBtAssistenteActionPerformed

    private void jBtPsicologoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPsicologoActionPerformed
        // TODO add your handling code here:
        mostrarAssistentePsicologo();
    }//GEN-LAST:event_jBtPsicologoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField jArtigo;
    private javax.swing.JTextField jBairro;
    private javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtAlterarDJ;
    private javax.swing.JButton jBtAlterarEAPI1;
    private javax.swing.JButton jBtAlterarEAPI2;
    private javax.swing.JButton jBtAlterarEvolucao;
    private javax.swing.JButton jBtAlterarFamiliar;
    private javax.swing.JButton jBtAlterarPSI;
    private javax.swing.JButton jBtAlterarSS;
    private javax.swing.JButton jBtAlterarSS3;
    private javax.swing.JButton jBtAlterarTO;
    private javax.swing.JButton jBtAlterarVisita;
    private javax.swing.JButton jBtAlterarVisitaIntima;
    private javax.swing.JButton jBtAssistente;
    private javax.swing.JButton jBtAuditoria;
    private javax.swing.JButton jBtAuditoriaDJ;
    private javax.swing.JButton jBtAuditoriaEAPI1;
    private javax.swing.JButton jBtAuditoriaEAPI2;
    private javax.swing.JButton jBtAuditoriaEvolucao;
    private javax.swing.JButton jBtAuditoriaFamiliar;
    private javax.swing.JButton jBtAuditoriaPSI;
    private javax.swing.JButton jBtAuditoriaSS;
    private javax.swing.JButton jBtAuditoriaSS3;
    private javax.swing.JButton jBtAuditoriaTO;
    private javax.swing.JButton jBtAuditoriaVisita;
    private javax.swing.JButton jBtAuditoriaVisitaIntima;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtCancelarDJ;
    private javax.swing.JButton jBtCancelarEAPI1;
    private javax.swing.JButton jBtCancelarEAPI2;
    private javax.swing.JButton jBtCancelarEvolucao;
    private javax.swing.JButton jBtCancelarFamiliar;
    private javax.swing.JButton jBtCancelarPSI;
    private javax.swing.JButton jBtCancelarSS;
    private javax.swing.JButton jBtCancelarSS3;
    private javax.swing.JButton jBtCancelarTO;
    private javax.swing.JButton jBtCancelarVisita;
    private javax.swing.JButton jBtCancelarVisitaIntima;
    private javax.swing.JButton jBtExcluir;
    private javax.swing.JButton jBtExcluirDJ;
    private javax.swing.JButton jBtExcluirEAPI1;
    private javax.swing.JButton jBtExcluirEAPI2;
    private javax.swing.JButton jBtExcluirEvolucao;
    private javax.swing.JButton jBtExcluirFamiliar;
    private javax.swing.JButton jBtExcluirPSI;
    private javax.swing.JButton jBtExcluirSS;
    private javax.swing.JButton jBtExcluirSS3;
    private javax.swing.JButton jBtExcluirTO;
    private javax.swing.JButton jBtExcluirVisita;
    private javax.swing.JButton jBtExcluirVisitaIntima;
    private javax.swing.JButton jBtImpressaoEvolucao;
    private javax.swing.JButton jBtImpressaoPAI;
    private javax.swing.JButton jBtNovaEvolucao;
    private javax.swing.JButton jBtNovaVisita;
    private javax.swing.JButton jBtNovaVisitaIntima;
    private javax.swing.JButton jBtNovo;
    private javax.swing.JButton jBtNovoDJ;
    private javax.swing.JButton jBtNovoEAPI1;
    private javax.swing.JButton jBtNovoEAPI2;
    private javax.swing.JButton jBtNovoFamiliar;
    private javax.swing.JButton jBtNovoPSI;
    private javax.swing.JButton jBtNovoSS;
    private javax.swing.JButton jBtNovoSS3;
    private javax.swing.JButton jBtNovoTO;
    private javax.swing.JButton jBtPesqCodigo;
    private javax.swing.JButton jBtPesqDataPAI;
    private javax.swing.JButton jBtPesqNomeInternoPAI;
    private javax.swing.JButton jBtPesqVisita;
    private javax.swing.JButton jBtPesqVisitaIntima;
    private javax.swing.JButton jBtPesquisarInternoPAI;
    private javax.swing.JButton jBtPsicologo;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSairDJ;
    private javax.swing.JButton jBtSairEAPI1;
    private javax.swing.JButton jBtSairEAPI2;
    private javax.swing.JButton jBtSairPSI;
    private javax.swing.JButton jBtSairSS;
    private javax.swing.JButton jBtSairSS3;
    private javax.swing.JButton jBtSairTO;
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JButton jBtSalvarDJ;
    private javax.swing.JButton jBtSalvarEAPI1;
    private javax.swing.JButton jBtSalvarEAPI2;
    private javax.swing.JButton jBtSalvarEvolucao;
    private javax.swing.JButton jBtSalvarFamiliar;
    private javax.swing.JButton jBtSalvarPSI;
    private javax.swing.JButton jBtSalvarSS;
    private javax.swing.JButton jBtSalvarSS3;
    private javax.swing.JButton jBtSalvarTO;
    private javax.swing.JButton jBtSalvarVisita;
    private javax.swing.JButton jBtSalvarVisitaIntima;
    public static javax.swing.JTextField jCPFInternoPAI;
    private javax.swing.JTextField jCTPS;
    public static javax.swing.JTextField jCartaoSUSPAI;
    private javax.swing.JFormattedTextField jCelular;
    private javax.swing.JCheckBox jCheckBoxTodosRegistros;
    private javax.swing.JTextField jCidade;
    public static javax.swing.JTextField jCodigoPAI;
    private javax.swing.JTextField jCodigoPesqPAI;
    private javax.swing.JComboBox jComboBoxAbastecimento;
    private javax.swing.JComboBox jComboBoxAceitaDanos;
    private javax.swing.JComboBox jComboBoxAcompanhaCAPS;
    private javax.swing.JComboBox jComboBoxAntesBeneficio;
    private javax.swing.JComboBox jComboBoxAptidaoArt;
    private javax.swing.JComboBox jComboBoxAptidaoProfissional;
    private javax.swing.JComboBox jComboBoxAssistenciaJuridica;
    private javax.swing.JComboBox jComboBoxCAPSAD;
    private javax.swing.JComboBox jComboBoxCRAS;
    private javax.swing.JComboBox jComboBoxCREAS;
    private javax.swing.JComboBox jComboBoxCartaInformal;
    private javax.swing.JComboBox jComboBoxCarteiraAssinada;
    private javax.swing.JComboBox jComboBoxComoRestabelecer;
    private javax.swing.JComboBox jComboBoxCompartilhaCrack;
    private javax.swing.JComboBox jComboBoxComprovacao;
    private javax.swing.JComboBox jComboBoxContraceptivos;
    public static javax.swing.JComboBox jComboBoxCorEtiniaInternoPAI;
    private javax.swing.JComboBox jComboBoxDemanda;
    private javax.swing.JComboBox jComboBoxDemandaDesemprego;
    private javax.swing.JComboBox jComboBoxDemandaLazer;
    private javax.swing.JComboBox jComboBoxDemandaProfissional;
    private javax.swing.JComboBox jComboBoxDemandaReclusao;
    private javax.swing.JComboBox jComboBoxDescarte;
    private javax.swing.JComboBox jComboBoxDesempregado;
    private javax.swing.JComboBox jComboBoxDestinoBebe;
    private javax.swing.JComboBox jComboBoxDocumentoDelega;
    private javax.swing.JComboBox jComboBoxEliminaDejetos;
    private javax.swing.JComboBox jComboBoxEstaGravida;
    public static javax.swing.JComboBox jComboBoxEstadoCivil;
    private javax.swing.JComboBox jComboBoxEstadoNaturalidade;
    private javax.swing.JComboBox jComboBoxEstaoFilhos;
    private javax.swing.JComboBox jComboBoxEsteveInternado;
    private javax.swing.JComboBox jComboBoxEstudaUP;
    private javax.swing.JComboBox jComboBoxEstudandoPreso;
    private javax.swing.JComboBox jComboBoxExerceAtividade;
    private javax.swing.JComboBox jComboBoxFamiliaDetido;
    private javax.swing.JComboBox jComboBoxFamiliaVulneraSocial;
    private javax.swing.JComboBox jComboBoxFazendoTratamento;
    private javax.swing.JComboBox jComboBoxGeracaoRenda;
    private javax.swing.JComboBox jComboBoxGostariaPrisional;
    private javax.swing.JComboBox jComboBoxInstrucao;
    private javax.swing.JComboBox jComboBoxInternadoPSI;
    private javax.swing.JComboBox jComboBoxMental;
    private javax.swing.JComboBox jComboBoxModalidade;
    private javax.swing.JComboBox jComboBoxMoradia;
    private javax.swing.JComboBox jComboBoxNecessidaEspecial;
    private javax.swing.JComboBox jComboBoxNecessitaAtende;
    private javax.swing.JComboBox jComboBoxNecessitaBeneficio;
    private javax.swing.JComboBox jComboBoxNecessitaEstudaFUP;
    private javax.swing.JComboBox jComboBoxNecessitaFamilia;
    private javax.swing.JComboBox jComboBoxNecessitaTrabalho;
    private javax.swing.JComboBox jComboBoxOrientacaoSexual;
    private javax.swing.JComboBox jComboBoxPROMAE;
    private javax.swing.JComboBox jComboBoxParticipouPrisional;
    private javax.swing.JComboBox jComboBoxPessoasQuimica;
    private javax.swing.JComboBox jComboBoxPossuiJuridica;
    private javax.swing.JComboBox jComboBoxPossuiPena;
    private javax.swing.JComboBox jComboBoxPossuiRedimento;
    private javax.swing.JComboBox jComboBoxPreNatal;
    private javax.swing.JComboBox jComboBoxPsicotropico;
    private javax.swing.JComboBox jComboBoxPsiquiatrico;
    private javax.swing.JComboBox jComboBoxQualAssistenciaJuridica;
    private javax.swing.JComboBox jComboBoxQualPena;
    private javax.swing.JComboBox jComboBoxRecebeBeneficio;
    private javax.swing.JComboBox jComboBoxReconhecerPaterna;
    private javax.swing.JComboBox jComboBoxRefereSaude;
    private javax.swing.JComboBox jComboBoxRegimeAprisionamento;
    private javax.swing.JComboBox jComboBoxRegularizarDocumento;
    private javax.swing.JComboBox jComboBoxReincidente;
    public static javax.swing.JComboBox jComboBoxReligiao;
    private javax.swing.JComboBox jComboBoxRestabelecerVinculo;
    private javax.swing.JComboBox jComboBoxSaudeBucal;
    private javax.swing.JComboBox jComboBoxStatusPAI;
    private javax.swing.JComboBox jComboBoxSuspeitaGravidez;
    private javax.swing.JComboBox jComboBoxTemBeneficios;
    private javax.swing.JComboBox jComboBoxTemFilhos;
    private javax.swing.JComboBox jComboBoxTipoDocumento;
    private javax.swing.JComboBox jComboBoxTrabalhaDetido;
    private javax.swing.JComboBox jComboBoxTrabalhaempresa;
    private javax.swing.JComboBox jComboBoxUsoPsicoativos;
    private javax.swing.JComboBox jComboBoxVinculoPAI;
    private javax.swing.JComboBox jComboBoxViveuRua;
    private javax.swing.JTextField jComplemento;
    private javax.swing.JTextField jDadosPaternidade;
    public static com.toedter.calendar.JDateChooser jDataAdmissao;
    private com.toedter.calendar.JDateChooser jDataCAPS;
    private com.toedter.calendar.JDateChooser jDataCAPSAD;
    private com.toedter.calendar.JDateChooser jDataEvolucao;
    private com.toedter.calendar.JDateChooser jDataExpedicao;
    private com.toedter.calendar.JDateChooser jDataFinal;
    private com.toedter.calendar.JDateChooser jDataInicial;
    private com.toedter.calendar.JDateChooser jDataInternaPSI;
    public static com.toedter.calendar.JDateChooser jDataNascimentoPAI;
    private com.toedter.calendar.JDateChooser jDataPAI;
    private javax.swing.JTextField jDelito;
    private javax.swing.JTextField jEmissor;
    private javax.swing.JTextField jEndereco;
    private javax.swing.JTextField jEnderecoTelefonePAI;
    private javax.swing.JFormattedTextField jFaixaSalarial;
    public static javax.swing.JLabel jFotoInternoPAI;
    private javax.swing.JTextField jIdEvolucao;
    public static javax.swing.JTextField jIdFamiliarPAI;
    public static javax.swing.JTextField jIdInternoPAI;
    public static javax.swing.JTextField jIdVisitaIntima;
    public static javax.swing.JTextField jIdVisitaPAI;
    private javax.swing.JTextField jIdadeFamiliarPAI;
    private javax.swing.JFormattedTextField jIdadeInterno;
    private javax.swing.JTextField jIdadeVisita;
    private javax.swing.JTextField jIdadeVisitaIntima;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel167;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel169;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel170;
    private javax.swing.JLabel jLabel171;
    private javax.swing.JLabel jLabel172;
    private javax.swing.JLabel jLabel173;
    private javax.swing.JLabel jLabel174;
    private javax.swing.JLabel jLabel175;
    private javax.swing.JLabel jLabel176;
    private javax.swing.JLabel jLabel177;
    private javax.swing.JLabel jLabel178;
    private javax.swing.JLabel jLabel179;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel180;
    private javax.swing.JLabel jLabel181;
    private javax.swing.JLabel jLabel182;
    private javax.swing.JLabel jLabel183;
    private javax.swing.JLabel jLabel184;
    private javax.swing.JLabel jLabel185;
    private javax.swing.JLabel jLabel186;
    private javax.swing.JLabel jLabel187;
    private javax.swing.JLabel jLabel188;
    private javax.swing.JLabel jLabel189;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel190;
    private javax.swing.JLabel jLabel191;
    private javax.swing.JLabel jLabel192;
    private javax.swing.JLabel jLabel193;
    private javax.swing.JLabel jLabel194;
    private javax.swing.JLabel jLabel195;
    private javax.swing.JLabel jLabel196;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    public static javax.swing.JTextField jMatriculaPenal;
    private javax.swing.JTextField jMotivo;
    private javax.swing.JTextField jMunicipioRegistrado;
    private javax.swing.JTextField jNIS;
    public static javax.swing.JTextField jNaturalidadeInternoPAI;
    private javax.swing.JTextField jNecessitaBeneficio;
    private javax.swing.JTextField jNomeFamiliarPAI;
    private javax.swing.JTextField jNomeInternoEvolucaoPAI;
    public static javax.swing.JTextField jNomeInternoPAI;
    private javax.swing.JTextField jNomeInternoPesquisa;
    public static javax.swing.JTextField jNomeMaeInternoPAI;
    public static javax.swing.JTextField jNomePaiInternoPAI;
    public static javax.swing.JTextField jNomeVisitaIntima;
    public static javax.swing.JTextField jNomeVisitaPAI;
    private javax.swing.JTextField jOcupacaoFamiliarPAI;
    private javax.swing.JTextField jOcupacaoVisita;
    private javax.swing.JTextField jOcupacaoVisitaIntima;
    private javax.swing.JTextField jOndeEstuda;
    private javax.swing.JTextField jOndePreNatal;
    private javax.swing.JTextField jOndePsiquiatrico;
    private javax.swing.JTextField jOutrasDoencas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jParaOnde;
    private javax.swing.JTextField jParaQuemFamilia;
    public static javax.swing.JTextField jParentescoPAI;
    public static javax.swing.JTextField jParentescoVisitaIntima;
    private javax.swing.JTextField jProfissaoOcupacao;
    private javax.swing.JTextField jQuaisBeneficiosAntesPrisao;
    private javax.swing.JTextField jQuaisBeneficiosFamilia;
    private javax.swing.JTextField jQualAptidao;
    private javax.swing.JTextArea jQualAptidaoArt;
    private javax.swing.JTextField jQualAtividadeExerce;
    private javax.swing.JTextArea jQualContraceptivos;
    private javax.swing.JTextField jQualDelegacia;
    private javax.swing.JTextArea jQualDemanda;
    private javax.swing.JTextArea jQualDemandaLazer;
    private javax.swing.JTextArea jQualDemandaProfissional;
    private javax.swing.JTextField jQualDocumento;
    private javax.swing.JTextField jQualEmpresa;
    private javax.swing.JTextField jQualFuncaoExerce;
    private javax.swing.JTextField jQualNecessidadeESP;
    private javax.swing.JTextField jQualNecessidadeEstudaFUP;
    private javax.swing.JTextField jQualNecessitaTrabalho;
    private javax.swing.JTextField jQualOutrasSub;
    private javax.swing.JTextField jQualOutrosDoencas;
    private javax.swing.JTextField jQualPsicotropico;
    private javax.swing.JTextField jQualRendimento;
    private javax.swing.JFormattedTextField jQuantasCesarianas;
    private javax.swing.JFormattedTextField jQuantoTempo;
    private javax.swing.JFormattedTextField jQuantoTempoCarteira;
    private javax.swing.JFormattedTextField jQuantoTempoInternado;
    private javax.swing.JFormattedTextField jQuantosAbortos;
    private javax.swing.JFormattedTextField jQuantosFilhos;
    private javax.swing.JFormattedTextField jQuantosPartos;
    private javax.swing.JFormattedTextField jQuantosPartosNornais;
    private javax.swing.JTextArea jQuemNecessita;
    private javax.swing.JTextField jQuemTemBeneficios;
    private javax.swing.JRadioButton jRBAgressividade;
    private javax.swing.JRadioButton jRBAlcool;
    private javax.swing.JRadioButton jRBAumentoTolerancia;
    private javax.swing.JRadioButton jRBBoca;
    private javax.swing.JRadioButton jRBCocaina;
    private javax.swing.JRadioButton jRBCola;
    private javax.swing.JRadioButton jRBCrack;
    private javax.swing.JRadioButton jRBDesanimo;
    private javax.swing.JRadioButton jRBDesejo;
    private javax.swing.JRadioButton jRBDiabetes;
    private javax.swing.JRadioButton jRBEnfermagem;
    private javax.swing.JRadioButton jRBEscabiose;
    private javax.swing.JRadioButton jRBFaltaApetite;
    private javax.swing.JRadioButton jRBFissura;
    private javax.swing.JRadioButton jRBHIV;
    private javax.swing.JRadioButton jRBHanseniase;
    private javax.swing.JRadioButton jRBHepatites;
    private javax.swing.JRadioButton jRBHipertensao;
    private javax.swing.JRadioButton jRBInjetaveis;
    private javax.swing.JRadioButton jRBInquientacao;
    private javax.swing.JRadioButton jRBInsonia;
    private javax.swing.JRadioButton jRBIsomantoSocial;
    private javax.swing.JRadioButton jRBMaconha;
    private javax.swing.JRadioButton jRBMedico;
    private javax.swing.JRadioButton jRBNaoPara;
    private javax.swing.JRadioButton jRBNausea;
    private javax.swing.JRadioButton jRBOutrasSub;
    private javax.swing.JRadioButton jRBOutrosDoencas;
    private javax.swing.JRadioButton jRBPensamentosSuicida;
    private javax.swing.JRadioButton jRBPsicologico;
    private javax.swing.JRadioButton jRBPsiquiatrico;
    private javax.swing.JRadioButton jRBSifilis;
    private javax.swing.JRadioButton jRBSudorese;
    private javax.swing.JRadioButton jRBTremores;
    private javax.swing.JRadioButton jRBTuberculose;
    public static javax.swing.JTextField jRGInternoPAI;
    private javax.swing.JTextField jReferencia;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jSerie;
    private javax.swing.JTextField jSessao;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTable jTabelaEvolucaoPAI;
    private javax.swing.JTable jTabelaFamiliarPAI;
    private javax.swing.JTable jTabelaPAI;
    private javax.swing.JTable jTabelaVisitas;
    private javax.swing.JTable jTabelaVisitasIntimas;
    public static javax.swing.JTextField jTecnicoPsicologico;
    public static javax.swing.JTextField jTecnicoServicoSocial;
    private javax.swing.JFormattedTextField jTelefone;
    private javax.swing.JFormattedTextField jTelefone1;
    private javax.swing.JFormattedTextField jTelefoneContato;
    private javax.swing.JFormattedTextField jTelefoneContatoEmpresa;
    private javax.swing.JTextArea jTextEAPI2PAI;
    private javax.swing.JTextArea jTextoASSISTENCIA;
    private javax.swing.JTextArea jTextoCEDEGEP;
    private javax.swing.JTextArea jTextoCRASCREAS;
    private javax.swing.JTextArea jTextoDOCUMENTOCIVIL;
    private javax.swing.JTextArea jTextoEvolucao;
    private javax.swing.JTextArea jTextoPSP;
    private javax.swing.JTextField jTipoOrientacaoSexual;
    private javax.swing.JTextField jTituloEleitor;
    private javax.swing.JTextField jUnidadePenal;
    private javax.swing.JTextField jZona;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void buscarAcessoUsuario(String nomeTela) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nameUser + "'");
            conecta.rs.first();
            codigoUser = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUser + "'");
            conecta.rs.first();
            codigoUserGroup = conecta.rs.getInt("IdUsuario");
            codigoGrupo = conecta.rs.getInt("IdGrupo");
            nomeGrupo = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUser + "' "
                    + "AND NomeTela='" + nomeTela + "'");
            conecta.rs.first();
            codUserAcesso = conecta.rs.getInt("IdUsuario");
            codAbrir = conecta.rs.getInt("Abrir");
            codIncluir = conecta.rs.getInt("Incluir");
            codAlterar = conecta.rs.getInt("Alterar");
            codExcluir = conecta.rs.getInt("Excluir");
            codGravar = conecta.rs.getInt("Gravar");
            codConsultar = conecta.rs.getInt("Consultar");
            nomeTela = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void buscarParametroPAI() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PARAMETROSCRC");
            conecta.rs.first();
            pRelPAI = conecta.rs.getString("CarcereFem");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarImpressaoPAI() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM FICHA_CADASTRO_PAI_CCGF "
                    + "WHERE IdPai='" + jCodigoPAI.getText() + "'");
            conecta.rs.first();
            codigoPAI_CCGF = conecta.rs.getString("IdPai");
            //
            conecta.executaSQL("SELECT * FROM FICHA_CADASTRO_PAI_DEME "
                    + "WHERE IdPai='" + jCodigoPAI.getText() + "'");
            conecta.rs.first();
            codigoPAI_DEME = conecta.rs.getString("IdPai");
            //
            conecta.executaSQL("SELECT * FROM FICHA_CADASTRO_PAI_DPTL "
                    + "WHERE IdPai='" + jCodigoPAI.getText() + "'");
            conecta.rs.first();
            codigoPAI_DPTL = conecta.rs.getString("IdPai");
            //
            conecta.executaSQL("SELECT * FROM FICHA_CADASTRO_PAI_DJ "
                    + "WHERE IdPai='" + jCodigoPAI.getText() + "'");
            conecta.rs.first();
            codigoPAI_DJ = conecta.rs.getString("IdPai");
            //
            conecta.executaSQL("SELECT * FROM FICHA_CADASTRO_PAI_DS "
                    + "WHERE IdPai='" + jCodigoPAI.getText() + "'");
            conecta.rs.first();
            codigoPAI_DS = conecta.rs.getString("IdPai");
            //
            conecta.executaSQL("SELECT * FROM FICHA_CADASTRO_PAI_EAPI1 "
                    + "WHERE IdPai='" + jCodigoPAI.getText() + "'");
            conecta.rs.first();
            codigoPAI_EAPI1 = conecta.rs.getString("IdPai");
            //
            conecta.executaSQL("SELECT * FROM FICHA_CADASTRO_PAI_EAPI2 "
                    + "WHERE IdPai='" + jCodigoPAI.getText() + "'");
            conecta.rs.first();
            codigoPAI_EAPI2 = conecta.rs.getString("IdPai");
            //
            conecta.executaSQL("SELECT * FROM EVOLUCAO_PAI_NOVO "
                    + "WHERE IdPai='" + jCodigoPAI.getText() + "'");
            conecta.rs.first();
            codigoPAI_EVOL = conecta.rs.getString("IdPai");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void formatarCampos() {
        jIdadeInterno.setDocument(new LimiteDigitosNum(3));
        jNaturalidadeInternoPAI.setDocument(new LimiteDigitosAlfa(53));
        jTipoOrientacaoSexual.setDocument(new LimiteDigitosAlfa(62));
        jQualDocumento.setDocument(new LimiteDigitosAlfa(150));
        jQualDelegacia.setDocument(new LimiteDigitosAlfa(150));
        //
        jRGInternoPAI.setDocument(new LimiteDigitosNum(20));
        jEmissor.setDocument(new LimiteDigitosAlfa(20));
        jCPFInternoPAI.setDocument(new LimiteDigitosNum(20));
        jCartaoSUSPAI.setDocument(new LimiteDigitosNum(20));
        jTituloEleitor.setDocument(new LimiteDigitosNum(20));
        jZona.setDocument(new LimiteDigitosNum(20));
        jSessao.setDocument(new LimiteDigitosNum(20));
        jNIS.setDocument(new LimiteDigitosAlfa(20));
        jCTPS.setDocument(new LimiteDigitosAlfa(20));
        jSerie.setDocument(new LimiteDigitosAlfa(20));
        //
        jEndereco.setDocument(new LimiteDigitosAlfa(200));
        jComplemento.setDocument(new LimiteDigitosAlfa(200));
        jReferencia.setDocument(new LimiteDigitosAlfa(200));
        jBairro.setDocument(new LimiteDigitosAlfa(200));
        jCidade.setDocument(new LimiteDigitosAlfa(200));
        jTelefone.setDocument(new LimiteDigitosAlfa(20));
        jTelefone1.setDocument(new LimiteDigitosAlfa(20));
        jCelular.setDocument(new LimiteDigitosAlfa(20));
        //
        jOcupacaoVisita.setDocument(new LimiteDigitosAlfa(33));
        jIdadeVisita.setDocument(new LimiteDigitosNum(3));
        //
        jOcupacaoVisitaIntima.setDocument(new LimiteDigitosAlfa(33));
        jIdadeVisitaIntima.setDocument(new LimiteDigitosNum(3));
        //

        jQualNecessidadeESP.setDocument(new LimiteDigitosAlfa(100));
        //
        jTextoCEDEGEP.setLineWrap(true);
        jTextoCEDEGEP.setWrapStyleWord(true);
        jTextoCRASCREAS.setLineWrap(true);
        jTextoCRASCREAS.setWrapStyleWord(true);
        jTextoASSISTENCIA.setLineWrap(true);
        jTextoASSISTENCIA.setWrapStyleWord(true);
        jTextoDOCUMENTOCIVIL.setLineWrap(true);
        jTextoDOCUMENTOCIVIL.setWrapStyleWord(true);
        //
        jTecnicoServicoSocial.setDocument(new LimiteDigitosAlfa(53));
        jTecnicoPsicologico.setDocument(new LimiteDigitosAlfa(53));
        // EVOLUÇÃO PAI      
        jTextoEvolucao.setLineWrap(true);
        jTextoEvolucao.setWrapStyleWord(true);
    }

    public void corCampos() {
        jCodigoPAI.setBackground(Color.white);
        jComboBoxStatusPAI.setBackground(Color.white);
        jDataPAI.setBackground(Color.white);
        jDataAdmissao.setBackground(Color.white);
        jMatriculaPenal.setBackground(Color.white);
        jUnidadePenal.setBackground(Color.white);
        jIdInternoPAI.setBackground(Color.white);
        jNomeInternoPAI.setBackground(Color.white);
        jNomeMaeInternoPAI.setBackground(Color.white);
        jNomePaiInternoPAI.setBackground(Color.white);
        jDataNascimentoPAI.setBackground(Color.white);
        jIdadeInterno.setBackground(Color.white);
        jNaturalidadeInternoPAI.setBackground(Color.white);
        jComboBoxCorEtiniaInternoPAI.setBackground(Color.white);
        jMunicipioRegistrado.setBackground(Color.white);
        jComboBoxOrientacaoSexual.setBackground(Color.white);
        jTipoOrientacaoSexual.setBackground(Color.white);
        jComboBoxDocumentoDelega.setBackground(Color.white);
        jQualDocumento.setBackground(Color.white);
        jQualDelegacia.setBackground(Color.white);
        jComboBoxRegularizarDocumento.setBackground(Color.white);
        jComboBoxTipoDocumento.setBackground(Color.white);
        //DOCUMENTOS/DADOS PESSOAIS        
        jRGInternoPAI.setBackground(Color.white);
        jEmissor.setBackground(Color.white);
        jDataExpedicao.setBackground(Color.white);
        jCPFInternoPAI.setBackground(Color.white);
        jCartaoSUSPAI.setBackground(Color.white);
        jTituloEleitor.setBackground(Color.white);
        jZona.setBackground(Color.white);
        jSessao.setBackground(Color.white);
        jNIS.setBackground(Color.white);
        jCTPS.setBackground(Color.white);
        jSerie.setBackground(Color.white);
        jComboBoxReligiao.setBackground(Color.white);
        jComboBoxEstadoCivil.setBackground(Color.white);
        jEndereco.setBackground(Color.white);
        jComplemento.setBackground(Color.white);
        jReferencia.setBackground(Color.white);
        jBairro.setBackground(Color.white);
        jCidade.setBackground(Color.white);
        jComboBoxEstadoNaturalidade.setBackground(Color.white);
        jTelefone.setBackground(Color.white);
        jTelefone1.setBackground(Color.white);
        jCelular.setBackground(Color.white);
        // C.C.G.F.
        jComboBoxTemFilhos.setBackground(Color.white);
        jQuantosFilhos.setBackground(Color.white);
        jComboBoxReconhecerPaterna.setBackground(Color.white);
        jDadosPaternidade.setBackground(Color.white);
        jComboBoxEstaoFilhos.setBackground(Color.white);
        jComboBoxNecessidaEspecial.setBackground(Color.white);
        jQualNecessidadeESP.setBackground(Color.white);
        jComboBoxCRAS.setBackground(Color.white);
        jComboBoxCREAS.setBackground(Color.white);
        jComboBoxRecebeBeneficio.setBackground(Color.white);
        jQuaisBeneficiosFamilia.setBackground(Color.white);
        jComboBoxAntesBeneficio.setBackground(Color.white);
        jQuaisBeneficiosAntesPrisao.setBackground(Color.white);
        jComboBoxNecessitaBeneficio.setBackground(Color.white);
        jNecessitaBeneficio.setBackground(Color.white);
        //
        jComboBoxMoradia.setBackground(Color.white);
        jComboBoxModalidade.setBackground(Color.white);
        jComboBoxAbastecimento.setBackground(Color.white);
        jComboBoxEliminaDejetos.setBackground(Color.white);
        jComboBoxDescarte.setBackground(Color.white);
        jComboBoxFamiliaVulneraSocial.setBackground(Color.white);
        jComboBoxViveuRua.setBackground(Color.white);
        jQuantoTempo.setBackground(Color.white);
        jMotivo.setBackground(Color.white);
        jComboBoxFamiliaDetido.setBackground(Color.white);
        jComboBoxRestabelecerVinculo.setBackground(Color.white);
        jComboBoxComoRestabelecer.setBackground(Color.white);
        //
        jIdFamiliarPAI.setBackground(Color.white);
        jNomeFamiliarPAI.setBackground(Color.white);
        jIdadeFamiliarPAI.setBackground(Color.white);
        jComboBoxVinculoPAI.setBackground(Color.white);
        jOcupacaoFamiliarPAI.setBackground(Color.white);
        jEnderecoTelefonePAI.setBackground(Color.white);
        //
        jIdVisitaPAI.setBackground(Color.white);
        jNomeVisitaPAI.setBackground(Color.white);
        jOcupacaoVisita.setBackground(Color.white);
        jParentescoPAI.setBackground(Color.white);
        jIdadeVisita.setBackground(Color.white);
        //
        jIdVisitaIntima.setBackground(Color.white);
        jNomeVisitaIntima.setBackground(Color.white);
        jParentescoVisitaIntima.setBackground(Color.white);
        jOcupacaoVisitaIntima.setBackground(Color.white);
        jIdadeVisitaIntima.setBackground(Color.white);
        // D.E.M.E.
        jComboBoxNecessitaFamilia.setBackground(Color.white);
        jParaQuemFamilia.setBackground(Color.white);
        jComboBoxEstaGravida.setBackground(Color.white);
        jComboBoxComprovacao.setBackground(Color.white);
        jComboBoxPreNatal.setBackground(Color.white);
        jOndePreNatal.setBackground(Color.white);
        jComboBoxDestinoBebe.setBackground(Color.white);
        jComboBoxSuspeitaGravidez.setBackground(Color.white);
        jQuantosPartos.setBackground(Color.white);
        jQuantosAbortos.setBackground(Color.white);
        jQuantosPartosNornais.setBackground(Color.white);
        jQuantasCesarianas.setBackground(Color.white);
        jComboBoxContraceptivos.setBackground(Color.white);
        jQualContraceptivos.setBackground(Color.white);
        jComboBoxDemanda.setBackground(Color.white);
        jQualDemanda.setBackground(Color.white);
        jComboBoxInstrucao.setBackground(Color.white);
        jComboBoxEstudandoPreso.setBackground(Color.white);
        jComboBoxParticipouPrisional.setBackground(Color.white);
        jComboBoxGostariaPrisional.setBackground(Color.white);
        // D.P.T.L.
        jProfissaoOcupacao.setBackground(Color.white);
        jComboBoxTrabalhaDetido.setBackground(Color.white);
        jComboBoxDesempregado.setBackground(Color.white);
        jComboBoxCarteiraAssinada.setBackground(Color.white);
        jQuantoTempoCarteira.setBackground(Color.white);
        jFaixaSalarial.setBackground(Color.white);
        jComboBoxTemBeneficios.setBackground(Color.white);
        jQuemTemBeneficios.setBackground(Color.white);
        jComboBoxDemandaReclusao.setBackground(Color.white);
        jComboBoxDemandaDesemprego.setBackground(Color.white);
        jComboBoxPossuiRedimento.setBackground(Color.white);
        jQualRendimento.setBackground(Color.white);
        jComboBoxExerceAtividade.setBackground(Color.white);
        jQualAtividadeExerce.setBackground(Color.white);
        jComboBoxGeracaoRenda.setBackground(Color.white);
        jComboBoxAptidaoProfissional.setBackground(Color.white);
        jQualAptidao.setBackground(Color.white);
        jComboBoxDemandaProfissional.setBackground(Color.white);
        jQualDemandaProfissional.setBackground(Color.white);
        jComboBoxAptidaoArt.setBackground(Color.white);
        jQualAptidaoArt.setBackground(Color.white);
        jComboBoxDemandaLazer.setBackground(Color.white);
        jQualDemandaLazer.setBackground(Color.white);
        // D.J.
        jComboBoxRegimeAprisionamento.setBackground(Color.white);
        jArtigo.setBackground(Color.white);
        jDelito.setBackground(Color.white);
        jComboBoxReincidente.setBackground(Color.white);
        jComboBoxPossuiPena.setBackground(Color.white);
        jComboBoxQualPena.setBackground(Color.white);
        jComboBoxPossuiJuridica.setBackground(Color.white);
        jComboBoxQualAssistenciaJuridica.setBackground(Color.white);
        jComboBoxPROMAE.setBackground(Color.white);
        jComboBoxAssistenciaJuridica.setBackground(Color.white);
        jComboBoxTrabalhaempresa.setBackground(Color.white);
        jTelefoneContatoEmpresa.setBackground(Color.white);
        jQualEmpresa.setBackground(Color.white);
        jQualFuncaoExerce.setBackground(Color.white);
        jComboBoxCartaInformal.setBackground(Color.white);
        jParaOnde.setBackground(Color.white);
        jTelefoneContato.setBackground(Color.white);
        jComboBoxEstudaUP.setBackground(Color.white);
        jOndeEstuda.setBackground(Color.white);
        jComboBoxNecessitaTrabalho.setBackground(Color.white);
        jQualNecessitaTrabalho.setBackground(Color.white);
        jComboBoxNecessitaEstudaFUP.setBackground(Color.white);
        jQualNecessidadeEstudaFUP.setBackground(Color.white);
        // D.S.
        jComboBoxRefereSaude.setBackground(Color.white);
        jOutrasDoencas.setBackground(Color.white);
        jComboBoxFazendoTratamento.setBackground(Color.white);
        jComboBoxPsiquiatrico.setBackground(Color.white);
        jOndePsiquiatrico.setBackground(Color.white);
        jComboBoxPsicotropico.setBackground(Color.white);
        jQualPsicotropico.setBackground(Color.white);
        jComboBoxMental.setBackground(Color.white);
        jQualOutrosDoencas.setBackground(Color.white);
        jComboBoxInternadoPSI.setBackground(Color.white);
        jDataInternaPSI.setBackground(Color.white);
        jComboBoxAcompanhaCAPS.setBackground(Color.white);
        jDataCAPS.setBackground(Color.white);
        jComboBoxUsoPsicoativos.setBackground(Color.white);
        jQualOutrasSub.setBackground(Color.white);
        jComboBoxCompartilhaCrack.setBackground(Color.white);
        jComboBoxCAPSAD.setBackground(Color.white);
        jDataCAPSAD.setBackground(Color.white);
        jComboBoxEsteveInternado.setBackground(Color.white);
        jQuantoTempoInternado.setBackground(Color.white);
        jComboBoxAceitaDanos.setBackground(Color.white);
        jComboBoxSaudeBucal.setBackground(Color.white);
        jComboBoxNecessitaAtende.setBackground(Color.white);
        jComboBoxPessoasQuimica.setBackground(Color.white);
        jQuemNecessita.setBackground(Color.white);
        // E.A.P.I.1
        jTextoPSP.setBackground(Color.white);
        jTextoCEDEGEP.setBackground(Color.white);
        jTextoCRASCREAS.setBackground(Color.white);
        // E.A.P.I.2
        jTextoCEDEGEP.setBackground(Color.white);
        jTextoCRASCREAS.setBackground(Color.white);
        jTextoASSISTENCIA.setBackground(Color.white);
        jTextoDOCUMENTOCIVIL.setBackground(Color.white);
        jTextEAPI2PAI.setBackground(Color.white);
        //

    }

    public void bloquearCampos() {
        // MANUTENÇÃO
        jCodigoPAI.setEnabled(!true);
        jComboBoxStatusPAI.setEnabled(!true);
        jDataPAI.setEnabled(!true);
        jDataAdmissao.setEnabled(!true);
        jMatriculaPenal.setEnabled(!true);
        jUnidadePenal.setEnabled(!true);
        jIdInternoPAI.setEnabled(!true);
        jNomeInternoPAI.setEnabled(!true);
        jNomeMaeInternoPAI.setEnabled(!true);
        jNomePaiInternoPAI.setEnabled(!true);
        jDataNascimentoPAI.setEnabled(!true);
        jIdadeInterno.setEnabled(!true);
        jNaturalidadeInternoPAI.setEnabled(!true);
        jComboBoxCorEtiniaInternoPAI.setEnabled(!true);
        jMunicipioRegistrado.setEnabled(!true);
        jComboBoxOrientacaoSexual.setEnabled(!true);
        jTipoOrientacaoSexual.setEnabled(!true);
        jComboBoxDocumentoDelega.setEnabled(!true);
        jQualDocumento.setEnabled(!true);
        jQualDelegacia.setEnabled(!true);
        jComboBoxRegularizarDocumento.setEnabled(!true);
        jComboBoxTipoDocumento.setEnabled(!true);
        //DOCUMENTOS/DADOS PESSOAIS        
        jRGInternoPAI.setEnabled(!true);
        jEmissor.setEnabled(!true);
        jDataExpedicao.setEnabled(!true);
        jCPFInternoPAI.setEnabled(!true);
        jCartaoSUSPAI.setEnabled(!true);
        jTituloEleitor.setEnabled(!true);
        jZona.setEnabled(!true);
        jSessao.setEnabled(!true);
        jNIS.setEnabled(!true);
        jCTPS.setEnabled(!true);
        jSerie.setEnabled(!true);
        jComboBoxReligiao.setEnabled(!true);
        jComboBoxEstadoCivil.setEnabled(!true);
        jEndereco.setEnabled(!true);
        jComplemento.setEnabled(!true);
        jReferencia.setEnabled(!true);
        jBairro.setEnabled(!true);
        jCidade.setEnabled(!true);
        jComboBoxEstadoNaturalidade.setEnabled(!true);
        jTelefone.setEnabled(!true);
        jTelefone1.setEnabled(!true);
        jCelular.setEnabled(!true);
        // C.C.G.F.
        jComboBoxTemFilhos.setEnabled(!true);
        jQuantosFilhos.setEnabled(!true);
        jComboBoxReconhecerPaterna.setEnabled(!true);
        jDadosPaternidade.setEnabled(!true);
        jComboBoxEstaoFilhos.setEnabled(!true);
        jComboBoxNecessidaEspecial.setEnabled(!true);
        jQualNecessidadeESP.setEnabled(!true);
        jComboBoxCRAS.setEnabled(!true);
        jComboBoxCREAS.setEnabled(!true);
        jComboBoxRecebeBeneficio.setEnabled(!true);
        jQuaisBeneficiosFamilia.setEnabled(!true);
        jComboBoxAntesBeneficio.setEnabled(!true);
        jQuaisBeneficiosAntesPrisao.setEnabled(!true);
        jComboBoxNecessitaBeneficio.setEnabled(!true);
        jNecessitaBeneficio.setEnabled(!true);
        //
        jComboBoxMoradia.setEnabled(!true);
        jComboBoxModalidade.setEnabled(!true);
        jComboBoxAbastecimento.setEnabled(!true);
        jComboBoxEliminaDejetos.setEnabled(!true);
        jComboBoxDescarte.setEnabled(!true);
        jComboBoxFamiliaVulneraSocial.setEnabled(!true);
        jComboBoxViveuRua.setEnabled(!true);
        jQuantoTempo.setEnabled(!true);
        jMotivo.setEnabled(!true);
        jComboBoxFamiliaDetido.setEnabled(!true);
        jComboBoxRestabelecerVinculo.setEnabled(!true);
        jComboBoxComoRestabelecer.setEnabled(!true);
        //
        jIdFamiliarPAI.setEnabled(!true);
        jNomeFamiliarPAI.setEnabled(!true);
        jIdadeFamiliarPAI.setEnabled(!true);
        jComboBoxVinculoPAI.setEnabled(!true);
        jOcupacaoFamiliarPAI.setEnabled(!true);
        jEnderecoTelefonePAI.setEnabled(!true);
        //
        jIdVisitaPAI.setEnabled(!true);
        jNomeVisitaPAI.setEnabled(!true);
        jOcupacaoVisita.setEnabled(!true);
        jParentescoPAI.setEnabled(!true);
        jIdadeVisita.setEnabled(!true);
        //
        jIdVisitaIntima.setEnabled(!true);
        jNomeVisitaIntima.setEnabled(!true);
        jParentescoVisitaIntima.setEnabled(!true);
        jOcupacaoVisitaIntima.setEnabled(!true);
        jIdadeVisitaIntima.setEnabled(!true);
        //D.E.M.E.
        jComboBoxNecessitaFamilia.setEnabled(!true);
        jParaQuemFamilia.setEnabled(!true);
        jComboBoxEstaGravida.setEnabled(!true);
        jComboBoxComprovacao.setEnabled(!true);
        jComboBoxPreNatal.setEnabled(!true);
        jOndePreNatal.setEnabled(!true);
        jComboBoxDestinoBebe.setEnabled(!true);
        jComboBoxSuspeitaGravidez.setEnabled(!true);
        jQuantosPartos.setEnabled(!true);
        jQuantosAbortos.setEnabled(!true);
        jQuantosPartosNornais.setEnabled(!true);
        jQuantasCesarianas.setEnabled(!true);
        jComboBoxContraceptivos.setEnabled(!true);
        jQualContraceptivos.setEnabled(!true);
        jComboBoxDemanda.setEnabled(!true);
        jQualDemanda.setEnabled(!true);
        jComboBoxInstrucao.setEnabled(!true);
        jComboBoxEstudandoPreso.setEnabled(!true);
        jComboBoxParticipouPrisional.setEnabled(!true);
        jComboBoxGostariaPrisional.setEnabled(!true);
        // D.P.T.L.
        jProfissaoOcupacao.setEnabled(!true);
        jComboBoxTrabalhaDetido.setEnabled(!true);
        jComboBoxDesempregado.setEnabled(!true);
        jComboBoxCarteiraAssinada.setEnabled(!true);
        jQuantoTempoCarteira.setEnabled(!true);
        jFaixaSalarial.setEnabled(!true);
        jComboBoxTemBeneficios.setEnabled(!true);
        jQuemTemBeneficios.setEnabled(!true);
        jComboBoxDemandaReclusao.setEnabled(!true);
        jComboBoxDemandaDesemprego.setEnabled(!true);
        jComboBoxPossuiRedimento.setEnabled(!true);
        jQualRendimento.setEnabled(!true);
        jComboBoxExerceAtividade.setEnabled(!true);
        jQualAtividadeExerce.setEnabled(!true);
        jComboBoxGeracaoRenda.setEnabled(!true);
        jComboBoxAptidaoProfissional.setEnabled(!true);
        jQualAptidao.setEnabled(!true);
        jComboBoxDemandaProfissional.setEnabled(!true);
        jQualDemandaProfissional.setEnabled(!true);
        jComboBoxAptidaoArt.setEnabled(!true);
        jQualAptidaoArt.setEnabled(!true);
        jComboBoxDemandaLazer.setEnabled(!true);
        jQualDemandaLazer.setEnabled(!true);
        //D.J.
        jComboBoxRegimeAprisionamento.setEnabled(!true);
        jArtigo.setEnabled(!true);
        jDelito.setEnabled(!true);
        jComboBoxReincidente.setEnabled(!true);
        jComboBoxPossuiPena.setEnabled(!true);
        jComboBoxQualPena.setEnabled(!true);
        jComboBoxPossuiJuridica.setEnabled(!true);
        jComboBoxQualAssistenciaJuridica.setEnabled(!true);
        jComboBoxPROMAE.setEnabled(!true);
        jComboBoxAssistenciaJuridica.setEnabled(!true);
        jComboBoxTrabalhaempresa.setEnabled(!true);
        jTelefoneContatoEmpresa.setEnabled(!true);
        jQualEmpresa.setEnabled(!true);
        jQualFuncaoExerce.setEnabled(!true);
        jComboBoxCartaInformal.setEnabled(!true);
        jParaOnde.setEnabled(!true);
        jTelefoneContato.setEnabled(!true);
        jComboBoxEstudaUP.setEnabled(!true);
        jOndeEstuda.setEnabled(!true);
        jComboBoxNecessitaTrabalho.setEnabled(!true);
        jQualNecessitaTrabalho.setEnabled(!true);
        jComboBoxNecessitaEstudaFUP.setEnabled(!true);
        jQualNecessidadeEstudaFUP.setEnabled(!true);
        // D.S.
        jComboBoxRefereSaude.setEnabled(!true);
        jRBHanseniase.setEnabled(!true);
        jRBDiabetes.setEnabled(!true);
        jRBTuberculose.setEnabled(!true);
        jRBHipertensao.setEnabled(!true);
        jRBHepatites.setEnabled(!true);
        jRBSifilis.setEnabled(!true);
        jRBEscabiose.setEnabled(!true);
        jRBHIV.setEnabled(!true);
        jOutrasDoencas.setEnabled(!true);
        jComboBoxFazendoTratamento.setEnabled(!true);
        jComboBoxPsiquiatrico.setEnabled(!true);
        jOndePsiquiatrico.setEnabled(!true);
        jComboBoxPsicotropico.setEnabled(!true);
        jQualPsicotropico.setEnabled(!true);
        jComboBoxMental.setEnabled(!true);
        jRBDesanimo.setEnabled(!true);
        jRBInsonia.setEnabled(!true);
        jRBFaltaApetite.setEnabled(!true);
        jRBIsomantoSocial.setEnabled(!true);
        jRBPensamentosSuicida.setEnabled(!true);
        jRBAgressividade.setEnabled(!true);
        jRBInquientacao.setEnabled(!true);
        jRBOutrosDoencas.setEnabled(!true);
        jQualOutrosDoencas.setEnabled(!true);
        jComboBoxInternadoPSI.setEnabled(!true);
        jDataInternaPSI.setEnabled(!true);
        jComboBoxAcompanhaCAPS.setEnabled(!true);
        jDataCAPS.setEnabled(!true);
        jComboBoxUsoPsicoativos.setEnabled(!true);
        jRBAlcool.setEnabled(!true);
        jRBMaconha.setEnabled(!true);
        jRBCocaina.setEnabled(!true);
        jRBCola.setEnabled(!true);
        jRBCrack.setEnabled(!true);
        jRBInjetaveis.setEnabled(!true);
        jRBOutrasSub.setEnabled(!true);
        jQualOutrasSub.setEnabled(!true);
        jComboBoxCompartilhaCrack.setEnabled(!true);
        jRBSudorese.setEnabled(!true);
        jRBTremores.setEnabled(!true);
        jRBFissura.setEnabled(!true);
        jRBBoca.setEnabled(!true);
        jRBNausea.setEnabled(!true);
        jRBDesejo.setEnabled(!true);
        jRBNaoPara.setEnabled(!true);
        jRBAumentoTolerancia.setEnabled(!true);
        jComboBoxCAPSAD.setEnabled(!true);
        jDataCAPSAD.setEnabled(!true);
        jComboBoxEsteveInternado.setEnabled(!true);
        jQuantoTempoInternado.setEnabled(!true);
        jComboBoxAceitaDanos.setEnabled(!true);
        jComboBoxSaudeBucal.setEnabled(!true);
        jComboBoxNecessitaAtende.setEnabled(!true);
        jRBEnfermagem.setEnabled(!true);
        jRBMedico.setEnabled(!true);
        jRBPsicologico.setEnabled(!true);
        jRBPsiquiatrico.setEnabled(!true);
        jComboBoxPessoasQuimica.setEnabled(!true);
        jQuemNecessita.setEnabled(!true);
        // E.A.P.I.1
        jTextoPSP.setEnabled(!true);
        jTextoCEDEGEP.setEnabled(!true);
        jTextoCRASCREAS.setEnabled(!true);
        // E.A.P.I.2
        jTextoCEDEGEP.setEnabled(!true);
        jTextoCRASCREAS.setEnabled(!true);
        jTextoASSISTENCIA.setEnabled(!true);
        jTextoDOCUMENTOCIVIL.setEnabled(!true);
        jTextEAPI2PAI.setEnabled(!true);
    }

    public void bloquearBotoes() {
        //MANUTENÇÃO
        jBtPesquisarInternoPAI.setEnabled(!true);
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        // C.C.G.F.
        jBtNovoSS.setEnabled(!true);
        jBtAlterarSS.setEnabled(!true);
        jBtExcluirSS.setEnabled(!true);
        jBtSalvarSS.setEnabled(!true);
        jBtCancelarSS.setEnabled(!true);
        jBtAuditoriaSS.setEnabled(!true);
        //
        jBtNovoFamiliar.setEnabled(!true);
        jBtAlterarFamiliar.setEnabled(!true);
        jBtExcluirFamiliar.setEnabled(!true);
        jBtSalvarFamiliar.setEnabled(!true);
        jBtCancelarFamiliar.setEnabled(!true);
        jBtAuditoriaFamiliar.setEnabled(!true);
        //
        jBtNovaVisita.setEnabled(!true);
        jBtAlterarVisita.setEnabled(!true);
        jBtExcluirVisita.setEnabled(!true);
        jBtSalvarVisita.setEnabled(!true);
        jBtCancelarVisita.setEnabled(!true);
        jBtAuditoriaVisita.setEnabled(!true);
        //
        jBtNovaVisitaIntima.setEnabled(!true);
        jBtAlterarVisitaIntima.setEnabled(!true);
        jBtExcluirVisitaIntima.setEnabled(!true);
        jBtSalvarVisitaIntima.setEnabled(!true);
        jBtCancelarVisitaIntima.setEnabled(!true);
        jBtAuditoriaVisitaIntima.setEnabled(!true);
        // D.E.M.E.
        jBtNovoTO.setEnabled(!true);
        jBtAlterarTO.setEnabled(!true);
        jBtExcluirTO.setEnabled(!true);
        jBtSalvarTO.setEnabled(!true);
        jBtCancelarTO.setEnabled(!true);
        jBtAuditoriaTO.setEnabled(!true);
        // D.P.T.L.
        jBtNovoPSI.setEnabled(!true);
        jBtAlterarPSI.setEnabled(!true);
        jBtExcluirPSI.setEnabled(!true);
        jBtSalvarPSI.setEnabled(!true);
        jBtCancelarPSI.setEnabled(!true);
        jBtAuditoriaPSI.setEnabled(!true);
        // D.J.
        jBtNovoDJ.setEnabled(!true);
        jBtAlterarDJ.setEnabled(!true);
        jBtExcluirDJ.setEnabled(!true);
        jBtSalvarDJ.setEnabled(!true);
        jBtCancelarDJ.setEnabled(!true);
        jBtAuditoriaDJ.setEnabled(!true);
        // D.S.
        jBtNovoSS3.setEnabled(!true);
        jBtAlterarSS3.setEnabled(!true);
        jBtExcluirSS3.setEnabled(!true);
        jBtSalvarSS3.setEnabled(!true);
        jBtCancelarSS3.setEnabled(!true);
        jBtAuditoriaSS3.setEnabled(!true);
        // EAPI-1
        jBtNovoEAPI1.setEnabled(!true);
        jBtAlterarEAPI1.setEnabled(!true);
        jBtExcluirEAPI1.setEnabled(!true);
        jBtSalvarEAPI1.setEnabled(!true);
        jBtCancelarEAPI1.setEnabled(!true);
        jBtAuditoriaEAPI1.setEnabled(!true);
        // EAPI-2
        jBtNovoEAPI2.setEnabled(!true);
        jBtAlterarEAPI2.setEnabled(!true);
        jBtExcluirEAPI2.setEnabled(!true);
        jBtSalvarEAPI2.setEnabled(!true);
        jBtCancelarEAPI2.setEnabled(!true);
        jBtAuditoriaEAPI2.setEnabled(!true);
        jBtAssistente.setEnabled(!true);
        jBtPsicologo.setEnabled(!true);
        // EVOLUÇÃO
        jBtNovaEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
    }

    public void limparCamposNovo() {
        // MANUTENÇÃO
        jCodigoPAI.setText("");
        jComboBoxStatusPAI.setSelectedItem("Selecione...");
        jFotoInternoPAI.setIcon(null);
        jDataPAI.setDate(null);
        jDataAdmissao.setDate(null);
        jMatriculaPenal.setText("");
        jUnidadePenal.setText(descricaoUnidade);
        jIdInternoPAI.setText("");
        jNomeInternoPAI.setText("");
        jNomeMaeInternoPAI.setText("");
        jNomePaiInternoPAI.setText("");
        jDataNascimentoPAI.setDate(null);
        jIdadeInterno.setText("");
        jNaturalidadeInternoPAI.setText("");
        jComboBoxCorEtiniaInternoPAI.setSelectedItem("Selecione...");
        jMunicipioRegistrado.setText("");
        jComboBoxOrientacaoSexual.setSelectedItem("Selecione...");
        jTipoOrientacaoSexual.setText("");
        jComboBoxDocumentoDelega.setSelectedItem("Não");
        jQualDocumento.setText("");
        jQualDelegacia.setText("");
        jComboBoxRegularizarDocumento.setSelectedItem("Não");
        jComboBoxTipoDocumento.setSelectedItem("Selecione...");
        //DOCUMENTOS/DADOS PESSOAIS        
        jRGInternoPAI.setText("");
        jEmissor.setText("");
        jDataExpedicao.setDate(null);
        jCPFInternoPAI.setText("");
        jCartaoSUSPAI.setText("");
        jTituloEleitor.setText("");
        jZona.setText("");
        jSessao.setText("");
        jNIS.setText("");
        jCTPS.setText("");
        jSerie.setText("");
        jComboBoxReligiao.setSelectedItem("Selecione...");
        jComboBoxEstadoCivil.setSelectedItem("Selecione...");
        jEndereco.setText("");
        jComplemento.setText("");
        jReferencia.setText("");
        jBairro.setText("");
        jCidade.setText("");
        jComboBoxEstadoNaturalidade.setSelectedItem("AC");
        jTelefone.setText("");
        jTelefone1.setText("");
        jCelular.setText("");
        // C.C.G.F.
        jComboBoxTemFilhos.setSelectedItem("Não");
        jQuantosFilhos.setText("0");
        jComboBoxReconhecerPaterna.setSelectedItem("Não");
        jDadosPaternidade.setText("");
        jComboBoxEstaoFilhos.setSelectedItem("Selecione...");
        jComboBoxNecessidaEspecial.setSelectedItem("Não");
        jQualNecessidadeESP.setText("");
        jComboBoxCRAS.setSelectedItem("Não");
        jComboBoxCREAS.setSelectedItem("Não");
        jComboBoxRecebeBeneficio.setSelectedItem("Não");
        jQuaisBeneficiosFamilia.setText("");
        jComboBoxAntesBeneficio.setSelectedItem("Não");
        jQuaisBeneficiosAntesPrisao.setText("");
        jComboBoxNecessitaBeneficio.setSelectedItem("Não");
        jNecessitaBeneficio.setText("");
        //
        jComboBoxMoradia.setSelectedItem("Selecione...");
        jComboBoxModalidade.setSelectedItem("Selecione...");
        jComboBoxAbastecimento.setSelectedItem("Selecione...");
        jComboBoxEliminaDejetos.setSelectedItem("Selecione...");
        jComboBoxDescarte.setSelectedItem("Selecione...");
        jComboBoxFamiliaVulneraSocial.setSelectedItem("Não");
        jComboBoxViveuRua.setSelectedItem("Não");
        jQuantoTempo.setText("");
        jMotivo.setText("");
        jComboBoxFamiliaDetido.setSelectedItem("Selecione...");
        jComboBoxRestabelecerVinculo.setSelectedItem("Não");
        jComboBoxComoRestabelecer.setSelectedItem("Selecione...");
        //
        jIdFamiliarPAI.setText("");
        jNomeFamiliarPAI.setText("");
        jIdadeFamiliarPAI.setText("0");
        jComboBoxVinculoPAI.setSelectedItem("Selecione...");
        jOcupacaoFamiliarPAI.setText("");
        jEnderecoTelefonePAI.setText("");
        //
        jIdVisitaPAI.setText("");
        jNomeVisitaPAI.setText("");
        jOcupacaoVisita.setText("");
        jParentescoPAI.setText("");
        jIdadeVisita.setText("");
        //
        jIdVisitaIntima.setText("");
        jNomeVisitaIntima.setText("");
        jParentescoVisitaIntima.setText("");
        jOcupacaoVisitaIntima.setText("");
        jIdadeVisitaIntima.setText("");
        //
        jIdFamiliarPAI.setText("");
        jNomeFamiliarPAI.setText("");
        jIdadeFamiliarPAI.setText("");
        jComboBoxVinculoPAI.setSelectedItem("Selecione...");
        jOcupacaoFamiliarPAI.setText("");
        jEnderecoTelefonePAI.setText("");
        //D.E.M.E.
        jComboBoxNecessitaFamilia.setSelectedItem("Não");
        jParaQuemFamilia.setText("");
        jComboBoxEstaGravida.setSelectedItem("Não");
        jComboBoxComprovacao.setSelectedItem("Não");
        jComboBoxPreNatal.setSelectedItem("Não");
        jOndePreNatal.setText("");
        jComboBoxDestinoBebe.setSelectedItem("Selecione...");
        jComboBoxSuspeitaGravidez.setSelectedItem("Não");
        jQuantosPartos.setText("0");
        jQuantosAbortos.setText("0");
        jQuantosPartosNornais.setText("0");
        jQuantasCesarianas.setText("0");
        jComboBoxContraceptivos.setSelectedItem("Não");
        jQualContraceptivos.setText("");
        jComboBoxDemanda.setSelectedItem("Não");
        jQualDemanda.setText("");
        jComboBoxInstrucao.setSelectedItem("Selecione...");
        jComboBoxEstudandoPreso.setSelectedItem("Não");
        jComboBoxParticipouPrisional.setSelectedItem("Não");
        jComboBoxGostariaPrisional.setSelectedItem("Não");
        // D.P.T.L.
        jProfissaoOcupacao.setText("");
        jComboBoxTrabalhaDetido.setSelectedItem("Não");
        jComboBoxDesempregado.setSelectedItem("Não");
        jComboBoxCarteiraAssinada.setSelectedItem("Não");
        jQuantoTempoCarteira.setText("0");
        jFaixaSalarial.setText("0,00");
        jComboBoxTemBeneficios.setSelectedItem("Não");
        jQuemTemBeneficios.setText("");
        jComboBoxDemandaReclusao.setSelectedItem("Não");
        jComboBoxDemandaDesemprego.setSelectedItem("Não");
        jComboBoxPossuiRedimento.setSelectedItem("Não");
        jQualRendimento.setText("");
        jComboBoxExerceAtividade.setSelectedItem("Não");
        jQualAtividadeExerce.setText("");
        jComboBoxGeracaoRenda.setSelectedItem("Não");
        jComboBoxAptidaoProfissional.setSelectedItem("Não");
        jQualAptidao.setText("");
        jComboBoxDemandaProfissional.setSelectedItem("Não");
        jQualDemandaProfissional.setText("");
        jComboBoxAptidaoArt.setSelectedItem("Não");
        jQualAptidaoArt.setText("");
        jComboBoxDemandaLazer.setSelectedItem("Não");
        jQualDemandaLazer.setText("");
        //D.J.
        jComboBoxRegimeAprisionamento.setSelectedItem("Selecione...");
        jArtigo.setText("");
        jDelito.setText("");
        jComboBoxReincidente.setSelectedItem("Não");
        jComboBoxPossuiPena.setSelectedItem("Não");
        jComboBoxQualPena.setSelectedItem("Selecione...");
        jComboBoxPossuiJuridica.setSelectedItem("Não");
        jComboBoxQualAssistenciaJuridica.setSelectedItem("Selecione...");
        jComboBoxPROMAE.setSelectedItem("Selecione...");
        jComboBoxAssistenciaJuridica.setSelectedItem("Não");
        jComboBoxTrabalhaempresa.setSelectedItem("Não");
        jTelefoneContatoEmpresa.setText("");
        jQualEmpresa.setText("");
        jQualFuncaoExerce.setText("");
        jComboBoxCartaInformal.setSelectedItem("Não");
        jParaOnde.setText("");
        jTelefoneContato.setText("");
        jComboBoxEstudaUP.setSelectedItem("Não");
        jOndeEstuda.setText("");
        jComboBoxNecessitaTrabalho.setSelectedItem("Não");
        jQualNecessitaTrabalho.setText("");
        jComboBoxNecessitaEstudaFUP.setSelectedItem("Não");
        jQualNecessidadeEstudaFUP.setText("");
        // D.S.
        jComboBoxRefereSaude.setSelectedItem("Não");
        jRBHanseniase.setSelected(!true);
        jRBDiabetes.setSelected(!true);
        jRBTuberculose.setSelected(!true);
        jRBHipertensao.setSelected(!true);
        jRBHepatites.setSelected(!true);
        jRBSifilis.setSelected(!true);
        jRBEscabiose.setSelected(!true);
        jRBHIV.setSelected(!true);
        jOutrasDoencas.setText("");
        jComboBoxFazendoTratamento.setSelectedItem("Não");
        jComboBoxPsiquiatrico.setSelectedItem("Não");
        jOndePsiquiatrico.setText("");
        jComboBoxPsicotropico.setSelectedItem("Não");
        jQualPsicotropico.setText("");
        jComboBoxMental.setSelectedItem("Não");
        jRBDesanimo.setSelected(!true);
        jRBInsonia.setSelected(!true);
        jRBFaltaApetite.setSelected(!true);
        jRBIsomantoSocial.setSelected(!true);
        jRBPensamentosSuicida.setSelected(!true);
        jRBAgressividade.setSelected(!true);
        jRBInquientacao.setSelected(!true);
        jRBOutrosDoencas.setSelected(!true);
        jQualOutrosDoencas.setText("");
        jComboBoxInternadoPSI.setSelectedItem("Não");
        jDataInternaPSI.setDate(null);
        jComboBoxAcompanhaCAPS.setSelectedItem("Não");
        jDataCAPS.setDate(null);
        jComboBoxUsoPsicoativos.setSelectedItem("Não");
        jRBAlcool.setSelected(!true);
        jRBMaconha.setSelected(!true);
        jRBCocaina.setSelected(!true);
        jRBCola.setSelected(!true);
        jRBCrack.setSelected(!true);
        jRBInjetaveis.setSelected(!true);
        jRBOutrasSub.setSelected(!true);
        jQualOutrasSub.setText("");
        jComboBoxCompartilhaCrack.setSelectedItem("Não");
        jRBSudorese.setSelected(!true);
        jRBTremores.setSelected(!true);
        jRBFissura.setSelected(!true);
        jRBBoca.setSelected(!true);
        jRBNausea.setSelected(!true);
        jRBDesejo.setSelected(!true);
        jRBNaoPara.setSelected(!true);
        jRBAumentoTolerancia.setSelected(!true);
        jComboBoxCAPSAD.setSelectedItem("Não");
        jDataCAPSAD.setDate(null);
        jComboBoxEsteveInternado.setSelectedItem("Não");
        jQuantoTempoInternado.setText("");
        jComboBoxAceitaDanos.setSelectedItem("Não");
        jComboBoxSaudeBucal.setSelectedItem("Não");
        jComboBoxNecessitaAtende.setSelectedItem("Não");
        jRBEnfermagem.setSelected(!true);
        jRBMedico.setSelected(!true);
        jRBPsicologico.setSelected(!true);
        jRBPsiquiatrico.setSelected(!true);
        jComboBoxPessoasQuimica.setSelectedItem("Não");
        jQuemNecessita.setText("");
        // EAPI-1
        jTextoPSP.setText("");
        jTextoCEDEGEP.setText("");
        jTextoCRASCREAS.setText("");
        // EAPI-2
        jTextoASSISTENCIA.setText("");
        jTextoDOCUMENTOCIVIL.setText("");
        jTextEAPI2PAI.setText("");
        jTecnicoServicoSocial.setText("");
        jTecnicoPsicologico.setText("");
        // EVOLUÇÃO
        jIdEvolucao.setText("");
        jDataEvolucao.setDate(null);
        jNomeInternoEvolucaoPAI.setText("");
        jTextoEvolucao.setText("");
    }

    public void Novo() {
        // MANUTENÇÃO    
        jComboBoxStatusPAI.setSelectedItem("Ativo");
        jDataPAI.setCalendar(Calendar.getInstance());
        jIdadeInterno.setText("0");
        //
        jComboBoxStatusPAI.setEnabled(true);
        jDataPAI.setEnabled(true);
        jDataAdmissao.setEnabled(true);
        jMatriculaPenal.setEnabled(true);
        //jUnidadePenal.setEnabled(true);
        jDataNascimentoPAI.setEnabled(true);
        jIdadeInterno.setEnabled(true);
        jNaturalidadeInternoPAI.setEnabled(true);
        jComboBoxCorEtiniaInternoPAI.setEnabled(true);
        jMunicipioRegistrado.setEnabled(true);
        jComboBoxOrientacaoSexual.setEnabled(true);
        jTipoOrientacaoSexual.setEnabled(true);
        jComboBoxDocumentoDelega.setEnabled(true);
        jQualDocumento.setEnabled(true);
        jQualDelegacia.setEnabled(true);
        jComboBoxRegularizarDocumento.setEnabled(true);
        jComboBoxTipoDocumento.setEnabled(true);
        //DOCUMENTOS/DADOS PESSOAIS        
        jRGInternoPAI.setEnabled(true);
        jEmissor.setEnabled(true);
        jDataExpedicao.setEnabled(true);
        jCPFInternoPAI.setEnabled(true);
        jCartaoSUSPAI.setEnabled(true);
        jTituloEleitor.setEnabled(true);
        jZona.setEnabled(true);
        jSessao.setEnabled(true);
        jNIS.setEnabled(true);
        jCTPS.setEnabled(true);
        jSerie.setEnabled(true);
        jComboBoxReligiao.setEnabled(true);
        jComboBoxEstadoCivil.setEnabled(true);
        jEndereco.setEnabled(true);
        jComplemento.setEnabled(true);
        jReferencia.setEnabled(true);
        jBairro.setEnabled(true);
        jCidade.setEnabled(true);
        jComboBoxEstadoNaturalidade.setEnabled(true);
        jTelefone.setEnabled(true);
        jTelefone1.setEnabled(true);
        jCelular.setEnabled(true);
        //
        jBtPesquisarInternoPAI.setEnabled(true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
    }

    public void Alterar() {
        // MANUTENÇÃO       
        jComboBoxStatusPAI.setEnabled(true);
        jDataPAI.setEnabled(true);
        jDataAdmissao.setEnabled(true);
        jMatriculaPenal.setEnabled(true);
        jUnidadePenal.setEnabled(true);
        jDataNascimentoPAI.setEnabled(true);
        jIdadeInterno.setEnabled(true);
        jNaturalidadeInternoPAI.setEnabled(true);
        jComboBoxCorEtiniaInternoPAI.setEnabled(true);
        jMunicipioRegistrado.setEnabled(true);
        jComboBoxOrientacaoSexual.setEnabled(true);
        jTipoOrientacaoSexual.setEnabled(true);
        jComboBoxDocumentoDelega.setEnabled(true);
        jQualDocumento.setEnabled(true);
        jQualDelegacia.setEnabled(true);
        jComboBoxRegularizarDocumento.setEnabled(true);
        jComboBoxTipoDocumento.setEnabled(true);
        //DOCUMENTOS/DADOS PESSOAIS        
        jRGInternoPAI.setEnabled(true);
        jEmissor.setEnabled(true);
        jDataExpedicao.setEnabled(true);
        jCPFInternoPAI.setEnabled(true);
        jCartaoSUSPAI.setEnabled(true);
        jTituloEleitor.setEnabled(true);
        jZona.setEnabled(true);
        jSessao.setEnabled(true);
        jNIS.setEnabled(true);
        jCTPS.setEnabled(true);
        jSerie.setEnabled(true);
        jComboBoxReligiao.setEnabled(true);
        jComboBoxEstadoCivil.setEnabled(true);
        jEndereco.setEnabled(true);
        jComplemento.setEnabled(true);
        jReferencia.setEnabled(true);
        jBairro.setEnabled(true);
        jCidade.setEnabled(true);
        jComboBoxEstadoNaturalidade.setEnabled(true);
        jTelefone.setEnabled(true);
        jTelefone1.setEnabled(true);
        jCelular.setEnabled(true);
        //
        jBtPesquisarInternoPAI.setEnabled(true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
    }

    public void Excluir() {
        jBtNovo.setEnabled(true);
    }

    public void Salvar() {
        bloquearCampos();
        bloquearBotoes();
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
        //
        jBtNovoSS.setEnabled(true);
        jBtNovoFamiliar.setEnabled(true);
        jBtNovaVisita.setEnabled(true);
        jBtNovaVisitaIntima.setEnabled(true);
        jBtNovoTO.setEnabled(true);
        jBtNovoPSI.setEnabled(true);
        jBtNovoDJ.setEnabled(true);
        jBtNovoSS3.setEnabled(true);
        jBtNovoEAPI1.setEnabled(true);
        jBtNovoEAPI2.setEnabled(true);
        jBtNovaEvolucao.setEnabled(true);
    }

    public void Cancelar() {
        if (jCodigoPAI.getText().equals("")) {
            bloquearCampos();
            limparCamposNovo();
            bloquearBotoes();
            jBtNovo.setEnabled(true);
        } else {
            bloquearCampos();
            bloquearBotoes();
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtAuditoria.setEnabled(true);
            //
            jBtNovoSS.setEnabled(true);
            jBtNovoFamiliar.setEnabled(true);
            jBtNovaVisita.setEnabled(true);
            jBtNovaVisitaIntima.setEnabled(true);
            jBtNovoTO.setEnabled(true);
            jBtNovoPSI.setEnabled(true);
            jBtNovoDJ.setEnabled(true);
            jBtNovoSS3.setEnabled(true);
            jBtNovoEAPI1.setEnabled(true);
            jBtNovoEAPI2.setEnabled(true);
            jBtNovaEvolucao.setEnabled(true);
        }
    }

    public void buscarCodigo() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM FICHA_CADASTRO_PAI_PSICOSOCIAL");
            conecta.rs.last();
            jCodigoPAI.setText(conecta.rs.getString("IdPai"));
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarExistenciaInternoPAI() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM FICHA_CADASTRO_PAI_PSICOSOCIAL "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON FICHA_CADASTRO_PAI_PSICOSOCIAL.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE FICHA_CADASTRO_PAI_PSICOSOCIAL.IdInternoCrc='" + jIdInternoPAI.getText() + "'");
            conecta.rs.first();
            codigoInternoPAI = conecta.rs.getString("IdInternoCrc");
            nomeMaeInterno = conecta.rs.getString("MaeInternoCrc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarCodigoPAI() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM FICHA_CADASTRO_PAI_CCGF WHERE IdPai='" + jCodigoPAI.getText() + "'");
            conecta.rs.first();
            idPaiCCGF = conecta.rs.getInt("IdPai");
            //
            conecta.executaSQL("SELECT * FROM FICHA_CADASTRO_PAI_CCGF_VF WHERE IdPai='" + jCodigoPAI.getText() + "'");
            conecta.rs.first();
            idPaiVF = conecta.rs.getInt("IdPai");
            //
            conecta.executaSQL("SELECT * FROM FICHA_CADASTRO_PAI_CCGF_VF1 WHERE IdPai='" + jCodigoPAI.getText() + "'");
            conecta.rs.first();
            idPaiVF1 = conecta.rs.getInt("IdPai");
            //
            conecta.executaSQL("SELECT * FROM FICHA_CADASTRO_PAI_CCGF_VF2 WHERE IdPai='" + jCodigoPAI.getText() + "'");
            conecta.rs.first();
            idPaiVF2 = conecta.rs.getInt("IdPai");
            //
//            conecta.executaSQL("SELECT * FROM TERAPIA_PEDAGOGIA_PSICOSOCIAL WHERE IdPai='" + jCodigoPAI.getText() + "'");
//            conecta.rs.first();
//            idPaiTera = conecta.rs.getString("IdPai");
//            //
//            conecta.executaSQL("SELECT * FROM PSICOLOGIA_PAI_PSICOSOCIAL WHERE IdPai='" + jCodigoPAI.getText() + "'");
//            conecta.rs.first();
//            idPaiPsico = conecta.rs.getString("IdPai");
//            //
//            conecta.executaSQL("SELECT * FROM PSICOLOGIA_MEDICO_PAI_PSICOSOCIAL WHERE IdPai='" + jCodigoPAI.getText() + "'");
//            conecta.rs.first();
//            idPaiPsicoMed = conecta.rs.getString("IdPai");
//            //
//            conecta.executaSQL("SELECT * FROM EAPI_CRC_PAI_PSICOSOCIAL WHERE IdPai='" + jCodigoPAI.getText() + "'");
//            conecta.rs.first();
//            idPaiEapi = conecta.rs.getString("IdPai");
//            //
//            conecta.executaSQL("SELECT * FROM SS3_PAI_PSICOSOCIAL WHERE IdPai='" + jCodigoPAI.getText() + "'");
//            conecta.rs.first();
//            idPaiSS3 = conecta.rs.getString("IdPai");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void NovoSS() {
        jQuantosFilhos.setText("0");
        jQuantoTempo.setText("0");
        // C.C.G.F.
        jComboBoxTemFilhos.setEnabled(true);
        jQuantosFilhos.setEnabled(true);
        jComboBoxReconhecerPaterna.setEnabled(true);
        jDadosPaternidade.setEnabled(true);
        jComboBoxEstaoFilhos.setEnabled(true);
        jComboBoxNecessidaEspecial.setEnabled(true);
        jQualNecessidadeESP.setEnabled(true);
        jComboBoxCRAS.setEnabled(true);
        jComboBoxCREAS.setEnabled(true);
        jComboBoxRecebeBeneficio.setEnabled(true);
        jQuaisBeneficiosFamilia.setEnabled(true);
        jComboBoxAntesBeneficio.setEnabled(true);
        jQuaisBeneficiosAntesPrisao.setEnabled(true);
        jComboBoxNecessitaBeneficio.setEnabled(true);
        jNecessitaBeneficio.setEnabled(true);
        //
        jComboBoxMoradia.setEnabled(true);
        jComboBoxModalidade.setEnabled(true);
        jComboBoxAbastecimento.setEnabled(true);
        jComboBoxEliminaDejetos.setEnabled(true);
        jComboBoxDescarte.setEnabled(true);
        jComboBoxFamiliaVulneraSocial.setEnabled(true);
        jComboBoxViveuRua.setEnabled(true);
        jQuantoTempo.setEnabled(true);
        jMotivo.setEnabled(true);
        jComboBoxFamiliaDetido.setEnabled(true);
        jComboBoxRestabelecerVinculo.setEnabled(true);
        jComboBoxComoRestabelecer.setEnabled(true);
        //
        jBtSalvarSS.setEnabled(true);
        jBtCancelarSS.setEnabled(true);
        //
        jBtNovoFamiliar.setEnabled(true);
        jBtNovaVisita.setEnabled(true);
        jBtNovaVisitaIntima.setEnabled(true);
    }

    public void AlterarSS() {
        // C.C.G.F.              
        jComboBoxTemFilhos.setEnabled(true);
        jQuantosFilhos.setEnabled(true);
        jComboBoxReconhecerPaterna.setEnabled(true);
        jDadosPaternidade.setEnabled(true);
        jComboBoxEstaoFilhos.setEnabled(true);
        jComboBoxNecessidaEspecial.setEnabled(true);
        jQualNecessidadeESP.setEnabled(true);
        jComboBoxCRAS.setEnabled(true);
        jComboBoxCREAS.setEnabled(true);
        jComboBoxRecebeBeneficio.setEnabled(true);
        jQuaisBeneficiosFamilia.setEnabled(true);
        jComboBoxAntesBeneficio.setEnabled(true);
        jQuaisBeneficiosAntesPrisao.setEnabled(true);
        jComboBoxNecessitaBeneficio.setEnabled(true);
        jNecessitaBeneficio.setEnabled(true);
        //
        jComboBoxMoradia.setEnabled(true);
        jComboBoxModalidade.setEnabled(true);
        jComboBoxAbastecimento.setEnabled(true);
        jComboBoxEliminaDejetos.setEnabled(true);
        jComboBoxDescarte.setEnabled(true);
        jComboBoxFamiliaVulneraSocial.setEnabled(true);
        jComboBoxViveuRua.setEnabled(true);
        jQuantoTempo.setEnabled(true);
        jMotivo.setEnabled(true);
        jComboBoxFamiliaDetido.setEnabled(true);
        jComboBoxRestabelecerVinculo.setEnabled(true);
        jComboBoxComoRestabelecer.setEnabled(true);
        //
        jBtSalvarSS.setEnabled(true);
        jBtCancelarSS.setEnabled(true);
        //
        jBtNovoFamiliar.setEnabled(true);
        jBtNovaVisita.setEnabled(true);
        jBtNovaVisitaIntima.setEnabled(true);
    }

    public void ExcluirSS() {
        bloquearCampos();
        bloquearBotoes();
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
        //
        jBtNovoSS.setEnabled(true);
        jBtNovoTO.setEnabled(true);
        jBtNovoPSI.setEnabled(true);
        jBtNovoDJ.setEnabled(true);
        jBtNovoSS3.setEnabled(true);
        jBtNovoEAPI1.setEnabled(true);
        jBtNovoEAPI2.setEnabled(true);
        jBtNovaEvolucao.setEnabled(true);

    }

    public void SalvarSS() {
        bloquearCampos();
        bloquearBotoes();
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
        //
        jBtNovoSS.setEnabled(true);
        jBtAlterarSS.setEnabled(true);
        jBtExcluirSS.setEnabled(true);
        jBtSalvarSS.setEnabled(!true);
        jBtCancelarSS.setEnabled(!true);
        jBtAuditoriaSS.setEnabled(true);
        //
        jBtNovoTO.setEnabled(true);
        jBtNovoPSI.setEnabled(true);
        jBtNovoDJ.setEnabled(true);
        jBtNovoSS3.setEnabled(true);
        jBtNovoEAPI1.setEnabled(true);
        jBtNovoEAPI2.setEnabled(true);
        jBtNovaEvolucao.setEnabled(true);
        acao = 0;
    }

    public void CancelarSS() {
        bloquearCampos();
        bloquearBotoes();
        //
        jBtNovoTO.setEnabled(true);
        jBtNovoPSI.setEnabled(true);
        jBtNovoDJ.setEnabled(true);
        jBtNovoSS3.setEnabled(true);
        jBtNovoEAPI1.setEnabled(true);
        jBtNovoEAPI2.setEnabled(true);
        jBtNovaEvolucao.setEnabled(true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
        // C.C.G.F          
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM FICHA_CADASTRO_PAI_CCGF "
                    + "INNER JOIN FICHA_CADASTRO_PAI_PSICOSOCIAL "
                    + "ON FICHA_CADASTRO_PAI_CCGF.IdPai=FICHA_CADASTRO_PAI_PSICOSOCIAL.IdPai "
                    + "WHERE FICHA_CADASTRO_PAI_CCGF.IdPai='" + jCodigoPAI.getText() + "'");
            conecta.rs.first();
            codigoSS1 = conecta.rs.getInt("IdCCGF");
            jComboBoxTemFilhos.setSelectedItem(conecta.rs.getString("TemFilhos"));
            jQuantosFilhos.setText(conecta.rs.getString("QuantosFilhos"));
            jComboBoxReconhecerPaterna.setSelectedItem(conecta.rs.getString("ReconhecerPaterna"));
            jDadosPaternidade.setText(conecta.rs.getString("DadosPaternidade"));
            jComboBoxEstaoFilhos.setSelectedItem(conecta.rs.getString("EstaoFilho"));
            jComboBoxNecessidaEspecial.setSelectedItem(conecta.rs.getString("NecessidaEspecial"));
            jQualNecessidadeESP.setText(conecta.rs.getString("NecessidadeESP"));
            jComboBoxCRAS.setSelectedItem(conecta.rs.getString("CRAS"));
            jComboBoxCREAS.setSelectedItem(conecta.rs.getString("CREAS"));
            jComboBoxRecebeBeneficio.setSelectedItem(conecta.rs.getString("RecebeBeneficio"));
            jQuaisBeneficiosFamilia.setText(conecta.rs.getString("QuaisBeneficiosFamilia"));
            jComboBoxAntesBeneficio.setSelectedItem(conecta.rs.getString("AntesBeneficio"));
            jQuaisBeneficiosAntesPrisao.setText(conecta.rs.getString("QuaisBeneficiosAntesPrisao"));
            jComboBoxNecessitaBeneficio.setSelectedItem(conecta.rs.getString("NecessitaBeneficio"));
            jNecessitaBeneficio.setText(conecta.rs.getString("QuemNecessitaBeneficio"));
            //
            jComboBoxMoradia.setSelectedItem(conecta.rs.getString("Moradia"));
            jComboBoxModalidade.setSelectedItem(conecta.rs.getString("Modalidade"));
            jComboBoxAbastecimento.setSelectedItem(conecta.rs.getString("Abastecimento"));
            jComboBoxEliminaDejetos.setSelectedItem(conecta.rs.getString("EliminaDejetos"));
            jComboBoxDescarte.setSelectedItem(conecta.rs.getString("Descarte"));
            jComboBoxFamiliaVulneraSocial.setSelectedItem(conecta.rs.getString("FamiliaVulneraSocial"));
            jComboBoxViveuRua.setSelectedItem(conecta.rs.getString("ViveuRua"));
            jQuantoTempo.setText(conecta.rs.getString("QuantoTempo"));
            jMotivo.setText(conecta.rs.getString("Motivo"));
            jComboBoxFamiliaDetido.setSelectedItem(conecta.rs.getString("FamiliaDetido"));
            jComboBoxRestabelecerVinculo.setSelectedItem(conecta.rs.getString("RestabelecerVinculo"));
            jComboBoxComoRestabelecer.setSelectedItem(conecta.rs.getString("ComoRestabelecer"));
            if (codigoSS1 != 0) {
                jBtNovoSS.setEnabled(true);
                jBtAlterarSS.setEnabled(true);
                jBtExcluirSS.setEnabled(true);
                jBtSalvarSS.setEnabled(!true);
                jBtCancelarSS.setEnabled(!true);
                jBtAuditoriaSS.setEnabled(true);
            }
        } catch (Exception e) {
        }
    }

    public void verificarCCGF() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM FICHA_CADASTRO_PAI_CCGF "
                    + "WHERE IdPai='" + jCodigoPAI.getText() + "' "
                    + "AND IdInternoCrc='" + jIdInternoPAI.getText() + "'");
            conecta.rs.first();
            codigoPaiSS1 = conecta.rs.getInt("IdPai");
            codigoInternoSS1 = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void NovoFamiliar() {
        jIdFamiliarPAI.setText("");
        jNomeFamiliarPAI.setText("");
        jIdadeFamiliarPAI.setText("0");
        jComboBoxVinculoPAI.setSelectedItem(null);
        jOcupacaoFamiliarPAI.setText("");
        jEnderecoTelefonePAI.setText("");
        //
        jNomeFamiliarPAI.setEnabled(true);
        jIdadeFamiliarPAI.setEnabled(true);
        jComboBoxVinculoPAI.setEnabled(true);
        jOcupacaoFamiliarPAI.setEnabled(true);
        jEnderecoTelefonePAI.setEnabled(true);
        // FAMILIAR               
        jBtSalvarFamiliar.setEnabled(true);
        jBtCancelarFamiliar.setEnabled(true);
    }

    public void AlterarFamiliar() {
        jNomeFamiliarPAI.setEnabled(true);
        jIdadeFamiliarPAI.setEnabled(true);
        jComboBoxVinculoPAI.setEnabled(true);
        jOcupacaoFamiliarPAI.setEnabled(true);
        jEnderecoTelefonePAI.setEnabled(true);
        // FAMILIAR               
        jBtSalvarFamiliar.setEnabled(true);
        jBtCancelarFamiliar.setEnabled(true);
    }

    public void ExcluirFamiliar() {
        bloquearBotoes();
        bloquearCampos();
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
        //
        jBtNovoSS.setEnabled(!true);
        jBtAlterarSS.setEnabled(!true);
        jBtExcluirSS.setEnabled(!true);
        jBtSalvarSS.setEnabled(true);
        jBtCancelarSS.setEnabled(true);
        jBtAuditoriaSS.setEnabled(!true);
        //
        jBtNovoTO.setEnabled(true);
        jBtNovoPSI.setEnabled(true);
        jBtNovoDJ.setEnabled(true);
        jBtNovoSS3.setEnabled(true);
        jBtNovoEAPI1.setEnabled(true);
        jBtNovoEAPI2.setEnabled(true);
        jBtNovaEvolucao.setEnabled(true);
    }

    public void SalvarFamiliar() {
        bloquearBotoes();
        bloquearCampos();
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
        //
        jComboBoxTemFilhos.setEnabled(true);
        jQuantosFilhos.setEnabled(true);
        jComboBoxReconhecerPaterna.setEnabled(true);
        jDadosPaternidade.setEnabled(true);
        jComboBoxEstaoFilhos.setEnabled(true);
        jComboBoxNecessidaEspecial.setEnabled(true);
        jQualNecessidadeESP.setEnabled(true);
        jComboBoxCRAS.setEnabled(true);
        jComboBoxCREAS.setEnabled(true);
        jComboBoxRecebeBeneficio.setEnabled(true);
        jQuaisBeneficiosFamilia.setEnabled(true);
        jComboBoxAntesBeneficio.setEnabled(true);
        jQuaisBeneficiosAntesPrisao.setEnabled(true);
        jComboBoxNecessitaBeneficio.setEnabled(true);
        jNecessitaBeneficio.setEnabled(true);
        //
        jComboBoxMoradia.setEnabled(true);
        jComboBoxModalidade.setEnabled(true);
        jComboBoxAbastecimento.setEnabled(true);
        jComboBoxEliminaDejetos.setEnabled(true);
        jComboBoxDescarte.setEnabled(true);
        jComboBoxFamiliaVulneraSocial.setEnabled(true);
        jComboBoxViveuRua.setEnabled(true);
        jQuantoTempo.setEnabled(true);
        jMotivo.setEnabled(true);
        jComboBoxFamiliaDetido.setEnabled(true);
        jComboBoxRestabelecerVinculo.setEnabled(true);
        jComboBoxComoRestabelecer.setEnabled(true);
        //
        jBtNovoSS.setEnabled(!true);
        jBtAlterarSS.setEnabled(!true);
        jBtExcluirSS.setEnabled(!true);
        jBtSalvarSS.setEnabled(true);
        jBtCancelarSS.setEnabled(true);
        jBtAuditoriaSS.setEnabled(!true);
        //
        jBtNovoFamiliar.setEnabled(true);
        jBtNovaVisita.setEnabled(true);
        jBtNovaVisitaIntima.setEnabled(true);
        jBtNovoTO.setEnabled(true);
        jBtNovoPSI.setEnabled(true);
        jBtNovoDJ.setEnabled(true);
        jBtNovoSS3.setEnabled(true);
        jBtNovoEAPI1.setEnabled(true);
        jBtNovoEAPI2.setEnabled(true);
        jBtNovaEvolucao.setEnabled(true);
        //
        jIdFamiliarPAI.setText("");
        jNomeFamiliarPAI.setText("");
        jIdadeFamiliarPAI.setText("0");
        jComboBoxVinculoPAI.setSelectedItem("Selecione...");
        jOcupacaoFamiliarPAI.setText("");
        jEnderecoTelefonePAI.setText("");
        //        
        acao = 4;
    }

    public void CancelarFamiliar() {
        bloquearBotoes();
        bloquearCampos();
        //
        jIdFamiliarPAI.setText("");
        jNomeFamiliarPAI.setText("");
        jIdadeFamiliarPAI.setText("0");
        jComboBoxVinculoPAI.setSelectedItem("Selecione...");
        jOcupacaoFamiliarPAI.setText("");
        jEnderecoTelefonePAI.setText("");
        //
        jIdVisitaPAI.setText("");
        jNomeVisitaPAI.setText("");
        jOcupacaoFamiliarPAI.setText("");
        jParentescoPAI.setText("");
        jIdadeVisita.setText("0");
        //
        jIdVisitaIntima.setText("");
        jNomeVisitaIntima.setText("");
        jOcupacaoVisitaIntima.setText("");
        jParentescoVisitaIntima.setText("");
        jIdadeVisitaIntima.setText("0");
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
        //
        jBtNovoSS.setEnabled(!true);
        jBtAlterarSS.setEnabled(!true);
        jBtExcluirSS.setEnabled(!true);
        jBtSalvarSS.setEnabled(true);
        jBtCancelarSS.setEnabled(true);
        jBtAuditoriaSS.setEnabled(!true);
        //
        jBtNovoFamiliar.setEnabled(true);
        jBtNovaVisita.setEnabled(true);
        jBtNovaVisitaIntima.setEnabled(true);
        //
        jBtNovoTO.setEnabled(true);
        jBtNovoPSI.setEnabled(true);
        jBtNovoDJ.setEnabled(true);
        jBtNovoSS3.setEnabled(true);
        jBtNovoEAPI1.setEnabled(true);
        jBtNovoEAPI2.setEnabled(true);
        jBtNovaEvolucao.setEnabled(true);
        // C.C.G.F.
        jComboBoxTemFilhos.setEnabled(true);
        jQuantosFilhos.setEnabled(true);
        jComboBoxReconhecerPaterna.setEnabled(true);
        jDadosPaternidade.setEnabled(true);
        jComboBoxEstaoFilhos.setEnabled(true);
        jComboBoxNecessidaEspecial.setEnabled(true);
        jQualNecessidadeESP.setEnabled(true);
        jComboBoxCRAS.setEnabled(true);
        jComboBoxCREAS.setEnabled(true);
        jComboBoxRecebeBeneficio.setEnabled(true);
        jQuaisBeneficiosFamilia.setEnabled(true);
        jComboBoxAntesBeneficio.setEnabled(true);
        jQuaisBeneficiosAntesPrisao.setEnabled(true);
        jComboBoxNecessitaBeneficio.setEnabled(true);
        jNecessitaBeneficio.setEnabled(true);
        //
        jComboBoxMoradia.setEnabled(true);
        jComboBoxModalidade.setEnabled(true);
        jComboBoxAbastecimento.setEnabled(true);
        jComboBoxEliminaDejetos.setEnabled(true);
        jComboBoxDescarte.setEnabled(true);
        jComboBoxFamiliaVulneraSocial.setEnabled(true);
        jComboBoxViveuRua.setEnabled(true);
        jQuantoTempo.setEnabled(true);
        jMotivo.setEnabled(true);
        jComboBoxFamiliaDetido.setEnabled(true);
        jComboBoxRestabelecerVinculo.setEnabled(true);
        jComboBoxComoRestabelecer.setEnabled(true);
    }

    public void buscarCodigoFamiliar() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM FICHA_CADASTRO_PAI_CCGF_VF");
            conecta.rs.last();
            jIdFamiliarPAI.setText(conecta.rs.getString("IdVF"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter o código do registro.");
        }
        conecta.desconecta();
    }

    public void NovaVisita() {
        jIdVisitaPAI.setText("");
        jNomeVisitaPAI.setText("");
        jOcupacaoVisita.setText("");
        jParentescoPAI.setText("");
        jIdadeVisita.setText("0");
        //
        jOcupacaoVisita.setEnabled(true);
        jIdadeVisita.setEnabled(true);
        //
        jBtPesqVisita.setEnabled(true);
        //
        jBtNovaVisita.setEnabled(!true);
        jBtAlterarVisita.setEnabled(!true);
        jBtExcluirVisita.setEnabled(!true);
        jBtSalvarVisita.setEnabled(true);
        jBtCancelarVisita.setEnabled(true);
        jBtAuditoriaVisita.setEnabled(!true);
    }

    public void AlterarVisita() {
        jOcupacaoVisita.setEnabled(true);
        jIdadeVisita.setEnabled(true);
        //
        jBtPesqVisita.setEnabled(true);
        //
        jBtNovaVisita.setEnabled(!true);
        jBtAlterarVisita.setEnabled(!true);
        jBtExcluirVisita.setEnabled(!true);
        jBtSalvarVisita.setEnabled(true);
        jBtCancelarVisita.setEnabled(true);
        jBtAuditoriaVisita.setEnabled(!true);
    }

    public void ExcluirVisita() {
        jIdVisitaPAI.setText("");
        jNomeVisitaPAI.setText("");
        jOcupacaoVisita.setText("");
        jParentescoPAI.setText("");
        jIdadeVisita.setText("0");
        //
        jOcupacaoVisita.setEnabled(!true);
        jIdadeVisita.setEnabled(!true);
        //
        jBtPesqVisita.setEnabled(!true);
        //
        jBtNovaVisita.setEnabled(true);
        jBtAlterarVisita.setEnabled(!true);
        jBtExcluirVisita.setEnabled(!true);
        jBtSalvarVisita.setEnabled(!true);
        jBtCancelarVisita.setEnabled(!true);
        jBtAuditoriaVisita.setEnabled(!true);
    }

    public void SalvarVisita() {
        bloquearBotoes();
        bloquearCampos();
        jIdVisitaPAI.setText("");
        jNomeVisitaPAI.setText("");
        jOcupacaoVisita.setText("");
        jParentescoPAI.setText("");
        jIdadeVisita.setText("0");
        //
        jOcupacaoVisita.setEnabled(!true);
        jIdadeVisita.setEnabled(!true);
        //
        jBtPesqVisita.setEnabled(!true);
        //
        jBtNovaVisita.setEnabled(true);
        jBtNovoFamiliar.setEnabled(true);
        jBtNovaVisitaIntima.setEnabled(true);
        // MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
        //
        jComboBoxTemFilhos.setEnabled(true);
        jQuantosFilhos.setEnabled(true);
        jComboBoxReconhecerPaterna.setEnabled(true);
        jDadosPaternidade.setEnabled(true);
        jComboBoxEstaoFilhos.setEnabled(true);
        jComboBoxNecessidaEspecial.setEnabled(true);
        jQualNecessidadeESP.setEnabled(true);
        jComboBoxCRAS.setEnabled(true);
        jComboBoxCREAS.setEnabled(true);
        jComboBoxRecebeBeneficio.setEnabled(true);
        jQuaisBeneficiosFamilia.setEnabled(true);
        jComboBoxAntesBeneficio.setEnabled(true);
        jQuaisBeneficiosAntesPrisao.setEnabled(true);
        jComboBoxNecessitaBeneficio.setEnabled(true);
        jNecessitaBeneficio.setEnabled(true);
        //        
        jComboBoxMoradia.setEnabled(true);
        jComboBoxModalidade.setEnabled(true);
        jComboBoxAbastecimento.setEnabled(true);
        jComboBoxEliminaDejetos.setEnabled(true);
        jComboBoxDescarte.setEnabled(true);
        jComboBoxFamiliaVulneraSocial.setEnabled(true);
        jComboBoxViveuRua.setEnabled(true);
        jQuantoTempo.setEnabled(true);
        jMotivo.setEnabled(true);
        jComboBoxFamiliaDetido.setEnabled(true);
        jComboBoxRestabelecerVinculo.setEnabled(true);
        jComboBoxComoRestabelecer.setEnabled(true);
        //
        jBtNovoSS.setEnabled(!true);
        jBtAlterarSS.setEnabled(!true);
        jBtExcluirSS.setEnabled(!true);
        jBtSalvarSS.setEnabled(true);
        jBtCancelarSS.setEnabled(true);
        jBtAuditoriaSS.setEnabled(!true);
        acao = 4;
    }

    public void CancelarVisita() {
        bloquearCampos();
        bloquearBotoes();
        jIdFamiliarPAI.setText("");
        jNomeFamiliarPAI.setText("");
        jIdadeFamiliarPAI.setText("0");
        jComboBoxVinculoPAI.setSelectedItem("Selecione...");
        jOcupacaoFamiliarPAI.setText("");
        jEnderecoTelefonePAI.setText("");
        //
        jIdVisitaPAI.setText("");
        jNomeVisitaPAI.setText("");
        jOcupacaoFamiliarPAI.setText("");
        jParentescoPAI.setText("");
        jIdadeVisita.setText("0");
        //
        jIdVisitaIntima.setText("");
        jNomeVisitaIntima.setText("");
        jOcupacaoVisitaIntima.setText("");
        jParentescoVisitaIntima.setText("");
        jIdadeVisitaIntima.setText("0");
        //
        jOcupacaoVisita.setEnabled(!true);
        jIdadeVisita.setEnabled(!true);
        //
        jBtPesqVisita.setEnabled(!true);
        //
        jBtNovaVisita.setEnabled(true);
        jBtNovaVisitaIntima.setEnabled(true);
        jBtNovoFamiliar.setEnabled(true);
        //
        jBtNovoSS.setEnabled(!true);
        jBtAlterarSS.setEnabled(!true);
        jBtExcluirSS.setEnabled(!true);
        jBtSalvarSS.setEnabled(true);
        jBtCancelarSS.setEnabled(true);
        jBtAuditoriaSS.setEnabled(!true);
        // MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
        // C.C.G.F.
        jComboBoxTemFilhos.setEnabled(true);
        jQuantosFilhos.setEnabled(true);
        jComboBoxReconhecerPaterna.setEnabled(true);
        jDadosPaternidade.setEnabled(true);
        jComboBoxEstaoFilhos.setEnabled(true);
        jComboBoxNecessidaEspecial.setEnabled(true);
        jQualNecessidadeESP.setEnabled(true);
        jComboBoxCRAS.setEnabled(true);
        jComboBoxCREAS.setEnabled(true);
        jComboBoxRecebeBeneficio.setEnabled(true);
        jQuaisBeneficiosFamilia.setEnabled(true);
        jComboBoxAntesBeneficio.setEnabled(true);
        jQuaisBeneficiosAntesPrisao.setEnabled(true);
        jComboBoxNecessitaBeneficio.setEnabled(true);
        jNecessitaBeneficio.setEnabled(true);
        //
        jComboBoxMoradia.setEnabled(true);
        jComboBoxModalidade.setEnabled(true);
        jComboBoxAbastecimento.setEnabled(true);
        jComboBoxEliminaDejetos.setEnabled(true);
        jComboBoxDescarte.setEnabled(true);
        jComboBoxFamiliaVulneraSocial.setEnabled(true);
        jComboBoxViveuRua.setEnabled(true);
        jQuantoTempo.setEnabled(true);
        jMotivo.setEnabled(true);
        jComboBoxFamiliaDetido.setEnabled(true);
        jComboBoxRestabelecerVinculo.setEnabled(true);
        jComboBoxComoRestabelecer.setEnabled(true);
    }

    public void NovaVisitaIntima() {
        jIdVisitaIntima.setText("");
        jNomeVisitaIntima.setText("");
        jOcupacaoVisitaIntima.setText("");
        jParentescoVisitaIntima.setText("");
        jIdadeVisitaIntima.setText("0");
        //
        jOcupacaoVisitaIntima.setEnabled(true);
        jIdadeVisitaIntima.setEnabled(true);
        //
        jBtPesqVisitaIntima.setEnabled(true);
        //
        jBtNovaVisitaIntima.setEnabled(!true);
        jBtAlterarVisitaIntima.setEnabled(!true);
        jBtExcluirVisitaIntima.setEnabled(!true);
        jBtSalvarVisitaIntima.setEnabled(true);
        jBtCancelarVisitaIntima.setEnabled(true);
        jBtAuditoriaVisitaIntima.setEnabled(!true);
    }

    public void AlterarVisitaIntima() {
        jOcupacaoVisitaIntima.setEnabled(true);
        jIdadeVisitaIntima.setEnabled(true);
        //
        jBtPesqVisitaIntima.setEnabled(true);
        //
        jBtNovaVisitaIntima.setEnabled(!true);
        jBtAlterarVisitaIntima.setEnabled(!true);
        jBtExcluirVisitaIntima.setEnabled(!true);
        jBtSalvarVisitaIntima.setEnabled(true);
        jBtCancelarVisitaIntima.setEnabled(true);
        jBtAuditoriaVisitaIntima.setEnabled(!true);
    }

    public void ExcluirVisitaIntima() {
        jIdVisitaIntima.setText("");
        jNomeVisitaIntima.setText("");
        jOcupacaoVisitaIntima.setText("");
        jParentescoVisitaIntima.setText("");
        jIdadeVisitaIntima.setText("0");
        //
        jOcupacaoVisitaIntima.setEnabled(!true);
        jIdadeVisitaIntima.setEnabled(!true);
        //
        jBtPesqVisitaIntima.setEnabled(!true);
        //
        jBtNovaVisitaIntima.setEnabled(true);
        jBtAlterarVisitaIntima.setEnabled(!true);
        jBtExcluirVisitaIntima.setEnabled(!true);
        jBtSalvarVisitaIntima.setEnabled(!true);
        jBtCancelarVisitaIntima.setEnabled(!true);
        jBtAuditoriaVisitaIntima.setEnabled(!true);
    }

    public void SalvarVisitaIntima() {
        bloquearBotoes();
        bloquearCampos();
        jIdVisitaIntima.setText("");
        jNomeVisitaIntima.setText("");
        jOcupacaoVisitaIntima.setText("");
        jParentescoVisitaIntima.setText("");
        jIdadeVisitaIntima.setText("0");
        //
        jOcupacaoVisitaIntima.setEnabled(!true);
        jIdadeVisitaIntima.setEnabled(!true);
        //
        jBtPesqVisitaIntima.setEnabled(!true);
        //
        jBtNovaVisitaIntima.setEnabled(true);
        jBtAlterarVisitaIntima.setEnabled(!true);
        jBtExcluirVisitaIntima.setEnabled(!true);
        jBtSalvarVisitaIntima.setEnabled(!true);
        jBtCancelarVisitaIntima.setEnabled(!true);
        jBtAuditoriaVisitaIntima.setEnabled(!true);
        //
        jBtNovaVisita.setEnabled(true);
        jBtNovoFamiliar.setEnabled(true);
        // MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
        //
        jBtNovoSS.setEnabled(!true);
        jBtAlterarSS.setEnabled(!true);
        jBtExcluirSS.setEnabled(!true);
        jBtSalvarSS.setEnabled(true);
        jBtCancelarSS.setEnabled(true);
        jBtAuditoriaSS.setEnabled(!true);
        //
        jComboBoxTemFilhos.setEnabled(true);
        jQuantosFilhos.setEnabled(true);
        jComboBoxReconhecerPaterna.setEnabled(true);
        jDadosPaternidade.setEnabled(true);
        jComboBoxEstaoFilhos.setEnabled(true);
        jComboBoxNecessidaEspecial.setEnabled(true);
        jQualNecessidadeESP.setEnabled(true);
        jComboBoxCRAS.setEnabled(true);
        jComboBoxCREAS.setEnabled(true);
        jComboBoxRecebeBeneficio.setEnabled(true);
        jQuaisBeneficiosFamilia.setEnabled(true);
        jComboBoxAntesBeneficio.setEnabled(true);
        jQuaisBeneficiosAntesPrisao.setEnabled(true);
        jComboBoxNecessitaBeneficio.setEnabled(true);
        jNecessitaBeneficio.setEnabled(true);
        //
        jComboBoxMoradia.setEnabled(true);
        jComboBoxModalidade.setEnabled(true);
        jComboBoxAbastecimento.setEnabled(true);
        jComboBoxEliminaDejetos.setEnabled(true);
        jComboBoxDescarte.setEnabled(true);
        jComboBoxFamiliaVulneraSocial.setEnabled(true);
        jComboBoxViveuRua.setEnabled(true);
        jQuantoTempo.setEnabled(true);
        jMotivo.setEnabled(true);
        jComboBoxFamiliaDetido.setEnabled(true);
        jComboBoxRestabelecerVinculo.setEnabled(true);
        jComboBoxComoRestabelecer.setEnabled(true);
        acao = 4;
    }

    public void CancelarVisitaIntima() {
        bloquearBotoes();
        bloquearCampos();
        //
        jIdFamiliarPAI.setText("");
        jNomeFamiliarPAI.setText("");
        jIdadeFamiliarPAI.setText("0");
        jComboBoxVinculoPAI.setSelectedItem("Selecione...");
        jOcupacaoFamiliarPAI.setText("");
        jEnderecoTelefonePAI.setText("");
        //
        jIdVisitaPAI.setText("");
        jNomeVisitaPAI.setText("");
        jOcupacaoFamiliarPAI.setText("");
        jParentescoPAI.setText("");
        jIdadeVisita.setText("0");
        //
        jIdVisitaIntima.setText("");
        jNomeVisitaIntima.setText("");
        jOcupacaoVisitaIntima.setText("");
        jParentescoVisitaIntima.setText("");
        jIdadeVisitaIntima.setText("0");
        //
        jOcupacaoVisitaIntima.setEnabled(!true);
        jIdadeVisitaIntima.setEnabled(!true);
        //
        jBtPesqVisitaIntima.setEnabled(!true);
        //
        jBtNovaVisitaIntima.setEnabled(true);
        jBtNovaVisita.setEnabled(true);
        jBtNovoFamiliar.setEnabled(true);
        //
        jBtNovoSS.setEnabled(!true);
        jBtAlterarSS.setEnabled(!true);
        jBtExcluirSS.setEnabled(!true);
        jBtSalvarSS.setEnabled(true);
        jBtCancelarSS.setEnabled(true);
        jBtAuditoriaSS.setEnabled(!true);
        // MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
        // C.C.G.F.
        jComboBoxTemFilhos.setEnabled(true);
        jQuantosFilhos.setEnabled(true);
        jComboBoxReconhecerPaterna.setEnabled(true);
        jDadosPaternidade.setEnabled(true);
        jComboBoxEstaoFilhos.setEnabled(true);
        jComboBoxNecessidaEspecial.setEnabled(true);
        jQualNecessidadeESP.setEnabled(true);
        jComboBoxCRAS.setEnabled(true);
        jComboBoxCREAS.setEnabled(true);
        jComboBoxRecebeBeneficio.setEnabled(true);
        jQuaisBeneficiosFamilia.setEnabled(true);
        jComboBoxAntesBeneficio.setEnabled(true);
        jQuaisBeneficiosAntesPrisao.setEnabled(true);
        jComboBoxNecessitaBeneficio.setEnabled(true);
        jNecessitaBeneficio.setEnabled(true);
        //
        jComboBoxMoradia.setEnabled(true);
        jComboBoxModalidade.setEnabled(true);
        jComboBoxAbastecimento.setEnabled(true);
        jComboBoxEliminaDejetos.setEnabled(true);
        jComboBoxDescarte.setEnabled(true);
        jComboBoxFamiliaVulneraSocial.setEnabled(true);
        jComboBoxViveuRua.setEnabled(true);
        jQuantoTempo.setEnabled(true);
        jMotivo.setEnabled(true);
        jComboBoxFamiliaDetido.setEnabled(true);
        jComboBoxRestabelecerVinculo.setEnabled(true);
        jComboBoxComoRestabelecer.setEnabled(true);
    }

    public void NovoTOPed() {
        bloquearBotoes();
        bloquearCampos();
        //D.E.M.E.
        jComboBoxNecessitaFamilia.setSelectedItem("Não");
        jParaQuemFamilia.setText("");
        jComboBoxEstaGravida.setSelectedItem("Não");
        jComboBoxComprovacao.setSelectedItem("Não");
        jComboBoxPreNatal.setSelectedItem("Não");
        jOndePreNatal.setText("");
        jComboBoxDestinoBebe.setSelectedItem("Selecione...");
        jComboBoxSuspeitaGravidez.setSelectedItem("Não");
        jQuantosPartos.setText("0");
        jQuantosAbortos.setText("0");
        jQuantosPartosNornais.setText("0");
        jQuantasCesarianas.setText("0");
        jComboBoxContraceptivos.setSelectedItem("Não");
        jQualContraceptivos.setText("");
        jComboBoxDemanda.setSelectedItem("Não");
        jQualDemanda.setText("");
        jComboBoxInstrucao.setSelectedItem("Selecione...");
        jComboBoxEstudandoPreso.setSelectedItem("Não");
        jComboBoxParticipouPrisional.setSelectedItem("Não");
        jComboBoxGostariaPrisional.setSelectedItem("Não");
        //
        jComboBoxNecessitaFamilia.setEnabled(true);
        jParaQuemFamilia.setEnabled(true);
        jComboBoxEstaGravida.setEnabled(true);
        jComboBoxComprovacao.setEnabled(true);
        jComboBoxPreNatal.setEnabled(true);
        jOndePreNatal.setEnabled(true);
        jComboBoxDestinoBebe.setEnabled(true);
        jComboBoxSuspeitaGravidez.setEnabled(true);
        jQuantosPartos.setEnabled(true);
        jQuantosAbortos.setEnabled(true);
        jQuantosPartosNornais.setEnabled(true);
        jQuantasCesarianas.setEnabled(true);
        jComboBoxContraceptivos.setEnabled(true);
        jQualContraceptivos.setEnabled(true);
        jComboBoxDemanda.setEnabled(true);
        jQualDemanda.setEnabled(true);
        jComboBoxInstrucao.setEnabled(true);
        jComboBoxEstudandoPreso.setEnabled(true);
        jComboBoxParticipouPrisional.setEnabled(true);
        jComboBoxGostariaPrisional.setEnabled(true);
        //
        jBtNovoTO.setEnabled(!true);
        jBtAlterarTO.setEnabled(!true);
        jBtExcluirTO.setEnabled(!true);
        jBtSalvarTO.setEnabled(true);
        jBtCancelarTO.setEnabled(true);
        jBtAuditoriaTO.setEnabled(!true);
    }

    public void AlterarTOPed() {
        bloquearBotoes();
        bloquearCampos();
        //D.E.M.E.        
        jComboBoxNecessitaFamilia.setEnabled(true);
        jParaQuemFamilia.setEnabled(true);
        jComboBoxEstaGravida.setEnabled(true);
        jComboBoxComprovacao.setEnabled(true);
        jComboBoxPreNatal.setEnabled(true);
        jOndePreNatal.setEnabled(true);
        jComboBoxDestinoBebe.setEnabled(true);
        jComboBoxSuspeitaGravidez.setEnabled(true);
        jQuantosPartos.setEnabled(true);
        jQuantosAbortos.setEnabled(true);
        jQuantosPartosNornais.setEnabled(true);
        jQuantasCesarianas.setEnabled(true);
        jComboBoxContraceptivos.setEnabled(true);
        jQualContraceptivos.setEnabled(true);
        jComboBoxDemanda.setEnabled(true);
        jQualDemanda.setEnabled(true);
        jComboBoxInstrucao.setEnabled(true);
        jComboBoxEstudandoPreso.setEnabled(true);
        jComboBoxParticipouPrisional.setEnabled(true);
        jComboBoxGostariaPrisional.setEnabled(true);
        //
        jBtNovoTO.setEnabled(!true);
        jBtAlterarTO.setEnabled(!true);
        jBtExcluirTO.setEnabled(!true);
        jBtSalvarTO.setEnabled(true);
        jBtCancelarTO.setEnabled(true);
        jBtAuditoriaTO.setEnabled(!true);
    }

    public void ExcluirTOPed() {
        bloquearBotoes();
        bloquearCampos();
        //D.E.M.E.
        jComboBoxNecessitaFamilia.setSelectedItem("Não");
        jParaQuemFamilia.setText("");
        jComboBoxEstaGravida.setSelectedItem("Não");
        jComboBoxComprovacao.setSelectedItem("Não");
        jComboBoxPreNatal.setSelectedItem("Não");
        jOndePreNatal.setText("");
        jComboBoxDestinoBebe.setSelectedItem("Selecione...");
        jComboBoxSuspeitaGravidez.setSelectedItem("Não");
        jQuantosPartos.setText("");
        jQuantosAbortos.setText("");
        jQuantosPartosNornais.setText("");
        jQuantasCesarianas.setText("");
        jComboBoxContraceptivos.setSelectedItem("Não");
        jQualContraceptivos.setText("");
        jComboBoxDemanda.setSelectedItem("Não");
        jQualDemanda.setText("");
        jComboBoxInstrucao.setSelectedItem("Selecione...");
        jComboBoxEstudandoPreso.setSelectedItem("Não");
        jComboBoxParticipouPrisional.setSelectedItem("Não");
        jComboBoxGostariaPrisional.setSelectedItem("Não");
        //
        jComboBoxNecessitaFamilia.setEnabled(!true);
        jParaQuemFamilia.setEnabled(!true);
        jComboBoxEstaGravida.setEnabled(!true);
        jComboBoxComprovacao.setEnabled(!true);
        jComboBoxPreNatal.setEnabled(!true);
        jOndePreNatal.setEnabled(!true);
        jComboBoxDestinoBebe.setEnabled(!true);
        jComboBoxSuspeitaGravidez.setEnabled(!true);
        jQuantosPartos.setEnabled(!true);
        jQuantosAbortos.setEnabled(!true);
        jQuantosPartosNornais.setEnabled(!true);
        jQuantasCesarianas.setEnabled(!true);
        jComboBoxContraceptivos.setEnabled(!true);
        jQualContraceptivos.setEnabled(!true);
        jComboBoxDemanda.setEnabled(!true);
        jQualDemanda.setEnabled(!true);
        jComboBoxInstrucao.setEnabled(!true);
        jComboBoxEstudandoPreso.setEnabled(!true);
        jComboBoxParticipouPrisional.setEnabled(!true);
        jComboBoxGostariaPrisional.setEnabled(!true);
        //
        jBtNovoTO.setEnabled(true);
        jBtAlterarTO.setEnabled(!true);
        jBtExcluirTO.setEnabled(!true);
        jBtSalvarTO.setEnabled(!true);
        jBtCancelarTO.setEnabled(!true);
        jBtAuditoriaTO.setEnabled(!true);
        // MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
        // C.C.G.F.
        jBtNovoSS.setEnabled(true);
        jBtAlterarSS.setEnabled(true);
        jBtExcluirSS.setEnabled(true);
        jBtSalvarSS.setEnabled(!true);
        jBtCancelarSS.setEnabled(!true);
        jBtAuditoriaSS.setEnabled(true);
        //
        jBtNovoTO.setEnabled(true);
        jBtNovoPSI.setEnabled(true);
        jBtNovoDJ.setEnabled(true);
        jBtNovoSS3.setEnabled(true);
        jBtNovoEAPI1.setEnabled(true);
        jBtNovoEAPI2.setEnabled(true);
        jBtNovaEvolucao.setEnabled(true);
    }

    public void SalvarTOPed() {
        jComboBoxNecessitaFamilia.setEnabled(!true);
        jParaQuemFamilia.setEnabled(!true);
        jComboBoxEstaGravida.setEnabled(!true);
        jComboBoxComprovacao.setEnabled(!true);
        jComboBoxPreNatal.setEnabled(!true);
        jOndePreNatal.setEnabled(!true);
        jComboBoxDestinoBebe.setEnabled(!true);
        jComboBoxSuspeitaGravidez.setEnabled(!true);
        jQuantosPartos.setEnabled(!true);
        jQuantosAbortos.setEnabled(!true);
        jQuantosPartosNornais.setEnabled(!true);
        jQuantasCesarianas.setEnabled(!true);
        jComboBoxContraceptivos.setEnabled(!true);
        jQualContraceptivos.setEnabled(!true);
        jComboBoxDemanda.setEnabled(!true);
        jQualDemanda.setEnabled(!true);
        jComboBoxInstrucao.setEnabled(!true);
        jComboBoxEstudandoPreso.setEnabled(!true);
        jComboBoxParticipouPrisional.setEnabled(!true);
        jComboBoxGostariaPrisional.setEnabled(!true);
        //
        jBtNovoTO.setEnabled(true);
        jBtAlterarTO.setEnabled(true);
        jBtExcluirTO.setEnabled(true);
        jBtSalvarTO.setEnabled(!true);
        jBtCancelarTO.setEnabled(!true);
        jBtAuditoriaTO.setEnabled(true);
        // MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
        // C.C.G.F.
        jBtNovoSS.setEnabled(true);
        jBtAlterarSS.setEnabled(true);
        jBtExcluirSS.setEnabled(true);
        jBtSalvarSS.setEnabled(!true);
        jBtCancelarSS.setEnabled(!true);
        jBtAuditoriaSS.setEnabled(true);
        //
        jBtNovoTO.setEnabled(true);
        jBtNovoPSI.setEnabled(true);
        jBtNovoDJ.setEnabled(true);
        jBtNovoSS3.setEnabled(true);
        jBtNovoEAPI1.setEnabled(true);
        jBtNovoEAPI2.setEnabled(true);
        jBtNovaEvolucao.setEnabled(true);
    }

    public void CancelarTOPed() {
        bloquearBotoes();
        bloquearCampos();
        //D.E.M.E.
        jComboBoxNecessitaFamilia.setSelectedItem("Não");
        jParaQuemFamilia.setText("");
        jComboBoxEstaGravida.setSelectedItem("Não");
        jComboBoxComprovacao.setSelectedItem("Não");
        jComboBoxPreNatal.setSelectedItem("Não");
        jOndePreNatal.setText("");
        jComboBoxDestinoBebe.setSelectedItem("Selecione...");
        jComboBoxSuspeitaGravidez.setSelectedItem("Não");
        jQuantosPartos.setText("");
        jQuantosAbortos.setText("");
        jQuantosPartosNornais.setText("");
        jQuantasCesarianas.setText("");
        jComboBoxContraceptivos.setSelectedItem("Não");
        jQualContraceptivos.setText("");
        jComboBoxDemanda.setSelectedItem("Não");
        jQualDemanda.setText("");
        jComboBoxInstrucao.setSelectedItem("Selecione...");
        jComboBoxEstudandoPreso.setSelectedItem("Não");
        jComboBoxParticipouPrisional.setSelectedItem("Não");
        jComboBoxGostariaPrisional.setSelectedItem("Não");
        //
        jComboBoxNecessitaFamilia.setEnabled(!true);
        jParaQuemFamilia.setEnabled(!true);
        jComboBoxEstaGravida.setEnabled(!true);
        jComboBoxComprovacao.setEnabled(!true);
        jComboBoxPreNatal.setEnabled(!true);
        jOndePreNatal.setEnabled(!true);
        jComboBoxDestinoBebe.setEnabled(!true);
        jComboBoxSuspeitaGravidez.setEnabled(!true);
        jQuantosPartos.setEnabled(!true);
        jQuantosAbortos.setEnabled(!true);
        jQuantosPartosNornais.setEnabled(!true);
        jQuantasCesarianas.setEnabled(!true);
        jComboBoxContraceptivos.setEnabled(!true);
        jQualContraceptivos.setEnabled(!true);
        jComboBoxDemanda.setEnabled(!true);
        jQualDemanda.setEnabled(!true);
        jComboBoxInstrucao.setEnabled(!true);
        jComboBoxEstudandoPreso.setEnabled(!true);
        jComboBoxParticipouPrisional.setEnabled(!true);
        jComboBoxGostariaPrisional.setEnabled(!true);
        //
        jBtNovoTO.setEnabled(true);
        jBtAlterarTO.setEnabled(!true);
        jBtExcluirTO.setEnabled(!true);
        jBtSalvarTO.setEnabled(!true);
        jBtCancelarTO.setEnabled(!true);
        jBtAuditoriaTO.setEnabled(!true);
        // MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
        // TO/Ped  
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM FICHA_CADASTRO_PAI_DEME "
                    + "INNER JOIN FICHA_CADASTRO_PAI_PSICOSOCIAL "
                    + "ON FICHA_CADASTRO_PAI_DEME.IdPai=FICHA_CADASTRO_PAI_PSICOSOCIAL.IdPai "
                    + "WHERE FICHA_CADASTRO_PAI_DEME.IdPai='" + jCodigoPAI.getText() + "'");
            conecta.rs.first();
            codTeraPed = conecta.rs.getInt("IdDEME");
            jComboBoxNecessitaFamilia.setSelectedItem(conecta.rs.getString("NecessitaFamilia"));
            jParaQuemFamilia.setText(conecta.rs.getString("ParaQuemFamilia"));
            jComboBoxEstaGravida.setSelectedItem(conecta.rs.getString("EstaGravida"));
            jComboBoxComprovacao.setSelectedItem(conecta.rs.getString("Comprovacao"));
            jComboBoxPreNatal.setSelectedItem(conecta.rs.getString("PreNatal"));
            jOndePreNatal.setText(conecta.rs.getString("OndePreNatal"));
            jComboBoxDestinoBebe.setSelectedItem(conecta.rs.getString("DestinoBebe"));
            jComboBoxSuspeitaGravidez.setSelectedItem(conecta.rs.getString("SuspeitaGravidez"));
            jQuantosPartos.setText(conecta.rs.getString("QuantosPartos"));
            jQuantosAbortos.setText(conecta.rs.getString("QuantosAbortos"));
            jQuantosPartosNornais.setText(conecta.rs.getString("QuantosPartosNornais"));
            jQuantasCesarianas.setText(conecta.rs.getString("QuantasCesarianas"));
            jComboBoxContraceptivos.setSelectedItem(conecta.rs.getString("Contraceptivos"));
            jQualContraceptivos.setText(conecta.rs.getString("QualContraceptivos"));
            jComboBoxDemanda.setSelectedItem(conecta.rs.getString("Demanda"));
            jQualDemanda.setText(conecta.rs.getString("QualDemanda"));
            jComboBoxInstrucao.setSelectedItem(conecta.rs.getString("Instrucao"));
            jComboBoxEstudandoPreso.setSelectedItem(conecta.rs.getString("EstudandoPreso"));
            jComboBoxParticipouPrisional.setSelectedItem(conecta.rs.getString("ParticipouPrisional"));
            jComboBoxGostariaPrisional.setSelectedItem(conecta.rs.getString("GostariaPrisional"));
            if (codTeraPed != 0) {
                jBtNovoTO.setEnabled(true);
                jBtAlterarTO.setEnabled(true);
                jBtExcluirTO.setEnabled(true);
                jBtSalvarTO.setEnabled(!true);
                jBtCancelarTO.setEnabled(!true);
                jBtAuditoriaTO.setEnabled(true);
            }
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void buscarCodTOPED() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM FICHA_CADASTRO_PAI_DEME");
            conecta.rs.last();
            codTeraPed = conecta.rs.getInt("IdDEME");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarTOPED() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM FICHA_CADASTRO_PAI_DEME "
                    + "WHERE IdPai='" + jCodigoPAI.getText() + "' "
                    + "AND IdInternoCrc='" + jIdInternoPAI.getText() + "'");
            conecta.rs.first();
            codigoPaiTOPED = conecta.rs.getInt("IdPai");
            codigoInternoTOPED = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void NovoPSI() {
        bloquearBotoes();
        bloquearCampos();
        jProfissaoOcupacao.setText("");
        jComboBoxTrabalhaDetido.setSelectedItem("Não");
        jComboBoxDesempregado.setSelectedItem("Não");
        jComboBoxCarteiraAssinada.setSelectedItem("Não");
        jQuantoTempoCarteira.setText("0");
        jFaixaSalarial.setText("0,00");
        jComboBoxTemBeneficios.setSelectedItem("Não");
        jQuemTemBeneficios.setText("");
        jComboBoxDemandaReclusao.setSelectedItem("Não");
        jComboBoxDemandaDesemprego.setSelectedItem("Não");
        jComboBoxPossuiRedimento.setSelectedItem("Não");
        jQualRendimento.setText("");
        jComboBoxExerceAtividade.setSelectedItem("Não");
        jQualAtividadeExerce.setText("");
        jComboBoxGeracaoRenda.setSelectedItem("Não");
        jComboBoxAptidaoProfissional.setSelectedItem("Não");
        jQualAptidao.setText("");
        jComboBoxDemandaProfissional.setSelectedItem("Não");
        jQualDemandaProfissional.setText("");
        jComboBoxAptidaoArt.setSelectedItem("Não");
        jQualAptidaoArt.setText("");
        jComboBoxDemandaLazer.setSelectedItem("Não");
        jQualDemandaLazer.setText("");
        //
        jProfissaoOcupacao.setEnabled(true);
        jComboBoxTrabalhaDetido.setEnabled(true);
        jComboBoxDesempregado.setEnabled(true);
        jComboBoxCarteiraAssinada.setEnabled(true);
        jQuantoTempoCarteira.setEnabled(true);
        jFaixaSalarial.setEnabled(true);
        jComboBoxTemBeneficios.setEnabled(true);
        jQuemTemBeneficios.setEnabled(true);
        jComboBoxDemandaReclusao.setEnabled(true);
        jComboBoxDemandaDesemprego.setEnabled(true);
        jComboBoxPossuiRedimento.setEnabled(true);
        jQualRendimento.setEnabled(true);
        jComboBoxExerceAtividade.setEnabled(true);
        jQualAtividadeExerce.setEnabled(true);
        jComboBoxGeracaoRenda.setEnabled(true);
        jComboBoxAptidaoProfissional.setEnabled(true);
        jQualAptidao.setEnabled(true);
        jComboBoxDemandaProfissional.setEnabled(true);
        jQualDemandaProfissional.setEnabled(true);
        jComboBoxAptidaoArt.setEnabled(true);
        jQualAptidaoArt.setEnabled(true);
        jComboBoxDemandaLazer.setEnabled(true);
        jQualDemandaLazer.setEnabled(true);
        //
        jBtNovoPSI.setEnabled(!true);
        jBtAlterarPSI.setEnabled(!true);
        jBtExcluirPSI.setEnabled(!true);
        jBtSalvarPSI.setEnabled(true);
        jBtCancelarPSI.setEnabled(true);
        jBtAuditoriaPSI.setEnabled(true);
    }

    public void AlterarPSI() {
        bloquearBotoes();
        bloquearCampos();
        //
        jProfissaoOcupacao.setEnabled(true);
        jComboBoxTrabalhaDetido.setEnabled(true);
        jComboBoxDesempregado.setEnabled(true);
        jComboBoxCarteiraAssinada.setEnabled(true);
        jQuantoTempoCarteira.setEnabled(true);
        jFaixaSalarial.setEnabled(true);
        jComboBoxTemBeneficios.setEnabled(true);
        jQuemTemBeneficios.setEnabled(true);
        jComboBoxDemandaReclusao.setEnabled(true);
        jComboBoxDemandaDesemprego.setEnabled(true);
        jComboBoxPossuiRedimento.setEnabled(true);
        jQualRendimento.setEnabled(true);
        jComboBoxExerceAtividade.setEnabled(true);
        jQualAtividadeExerce.setEnabled(true);
        jComboBoxGeracaoRenda.setEnabled(true);
        jComboBoxAptidaoProfissional.setEnabled(true);
        jQualAptidao.setEnabled(true);
        jComboBoxDemandaProfissional.setEnabled(true);
        jQualDemandaProfissional.setEnabled(true);
        jComboBoxAptidaoArt.setEnabled(true);
        jQualAptidaoArt.setEnabled(true);
        jComboBoxDemandaLazer.setEnabled(true);
        jQualDemandaLazer.setEnabled(true);
        //
        jBtNovoPSI.setEnabled(!true);
        jBtAlterarPSI.setEnabled(!true);
        jBtExcluirPSI.setEnabled(!true);
        jBtSalvarPSI.setEnabled(true);
        jBtCancelarPSI.setEnabled(true);
        jBtAuditoriaPSI.setEnabled(true);
    }

    public void ExcluirPSI() {
        bloquearBotoes();
        bloquearCampos();
        jProfissaoOcupacao.setText("");
        jComboBoxTrabalhaDetido.setSelectedItem("Não");
        jComboBoxDesempregado.setSelectedItem("Não");
        jComboBoxCarteiraAssinada.setSelectedItem("Não");
        jQuantoTempoCarteira.setText("0");
        jFaixaSalarial.setText("0,00");
        jComboBoxTemBeneficios.setSelectedItem("Não");
        jQuemTemBeneficios.setText("");
        jComboBoxDemandaReclusao.setSelectedItem("Não");
        jComboBoxDemandaDesemprego.setSelectedItem("Não");
        jComboBoxPossuiRedimento.setSelectedItem("Não");
        jQualRendimento.setText("");
        jComboBoxExerceAtividade.setSelectedItem("Não");
        jQualAtividadeExerce.setText("");
        jComboBoxGeracaoRenda.setSelectedItem("Não");
        jComboBoxAptidaoProfissional.setSelectedItem("Não");
        jQualAptidao.setText("");
        jComboBoxDemandaProfissional.setSelectedItem("Não");
        jQualDemandaProfissional.setText("");
        jComboBoxAptidaoArt.setSelectedItem("Não");
        jQualAptidaoArt.setText("");
        jComboBoxDemandaLazer.setSelectedItem("Não");
        jQualDemandaLazer.setText("");
        //
        jBtNovoPSI.setEnabled(true);
        jBtAlterarPSI.setEnabled(!true);
        jBtExcluirPSI.setEnabled(!true);
        jBtSalvarPSI.setEnabled(!true);
        jBtCancelarPSI.setEnabled(!true);
        jBtAuditoriaPSI.setEnabled(!true);
        //        
        jBtNovoTO.setEnabled(true);
        jBtNovoSS.setEnabled(true);
        jBtNovoDJ.setEnabled(true);
        jBtNovoSS3.setEnabled(true);
        jBtNovoEAPI1.setEnabled(true);
        jBtNovoEAPI2.setEnabled(true);
        jBtNovaEvolucao.setEnabled(true);
    }

    public void SalvarPSI() {
        bloquearBotoes();
        bloquearCampos();
        //
        jBtNovoPSI.setEnabled(true);
        jBtAlterarPSI.setEnabled(true);
        jBtExcluirPSI.setEnabled(true);
        jBtSalvarPSI.setEnabled(!true);
        jBtCancelarPSI.setEnabled(!true);
        jBtAuditoriaPSI.setEnabled(true);
        // D.E.M.E.
        jBtNovoTO.setEnabled(true);
        jBtAlterarTO.setEnabled(true);
        jBtExcluirTO.setEnabled(true);
        jBtSalvarTO.setEnabled(!true);
        jBtCancelarTO.setEnabled(!true);
        jBtAuditoriaTO.setEnabled(true);
        // C.C.G.F.
        jBtNovoSS.setEnabled(true);
        jBtAlterarSS.setEnabled(true);
        jBtExcluirSS.setEnabled(true);
        jBtSalvarSS.setEnabled(!true);
        jBtCancelarSS.setEnabled(!true);
        jBtAuditoriaSS.setEnabled(true);
        // MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
        //        
        jBtNovoTO.setEnabled(true);
        jBtNovoSS.setEnabled(true);
        jBtNovoDJ.setEnabled(true);
        jBtNovoSS3.setEnabled(true);
        jBtNovoEAPI1.setEnabled(true);
        jBtNovoEAPI2.setEnabled(true);
        jBtNovaEvolucao.setEnabled(true);
    }

    public void CancelarPSI() {
        bloquearBotoes();
        bloquearCampos();
        jProfissaoOcupacao.setText("");
        jComboBoxTrabalhaDetido.setSelectedItem("Não");
        jComboBoxDesempregado.setSelectedItem("Não");
        jComboBoxCarteiraAssinada.setSelectedItem("Não");
        jQuantoTempoCarteira.setText("0");
        jFaixaSalarial.setText("0,00");
        jComboBoxTemBeneficios.setSelectedItem("Não");
        jQuemTemBeneficios.setText("");
        jComboBoxDemandaReclusao.setSelectedItem("Não");
        jComboBoxDemandaDesemprego.setSelectedItem("Não");
        jComboBoxPossuiRedimento.setSelectedItem("Não");
        jQualRendimento.setText("");
        jComboBoxExerceAtividade.setSelectedItem("Não");
        jQualAtividadeExerce.setText("");
        jComboBoxGeracaoRenda.setSelectedItem("Não");
        jComboBoxAptidaoProfissional.setSelectedItem("Não");
        jQualAptidao.setText("");
        jComboBoxDemandaProfissional.setSelectedItem("Não");
        jQualDemandaProfissional.setText("");
        jComboBoxAptidaoArt.setSelectedItem("Não");
        jQualAptidaoArt.setText("");
        jComboBoxDemandaLazer.setSelectedItem("Não");
        jQualDemandaLazer.setText("");
        // MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
        // C.C.G.F.
        jBtNovoSS.setEnabled(true);
        jBtAlterarSS.setEnabled(true);
        jBtExcluirSS.setEnabled(true);
        jBtSalvarSS.setEnabled(!true);
        jBtCancelarSS.setEnabled(!true);
        jBtAuditoriaSS.setEnabled(true);
        // D.E.M.E.
        jBtNovoTO.setEnabled(true);
        jBtAlterarTO.setEnabled(true);
        jBtExcluirTO.setEnabled(true);
        jBtSalvarTO.setEnabled(!true);
        jBtCancelarTO.setEnabled(!true);
        jBtAuditoriaTO.setEnabled(true);
        //      
        jBtNovoDJ.setEnabled(true);
        jBtNovoSS3.setEnabled(true);
        jBtNovoEAPI1.setEnabled(true);
        jBtNovoEAPI2.setEnabled(true);
        jBtNovaEvolucao.setEnabled(true);
        //
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM FICHA_CADASTRO_PAI_DPTL "
                    + "INNER JOIN FICHA_CADASTRO_PAI_PSICOSOCIAL "
                    + "ON FICHA_CADASTRO_PAI_DPTL.IdPai=FICHA_CADASTRO_PAI_PSICOSOCIAL.IdPai "
                    + "WHERE FICHA_CADASTRO_PAI_DPTL.IdPai='" + jCodigoPAI.getText() + "'");
            conecta.rs.first();
            // D.P.T.L.
            codigoPSI = conecta.rs.getInt("IdDPTL");
            jProfissaoOcupacao.setText(conecta.rs.getString("ProfissaoOcupacao"));
            jComboBoxTrabalhaDetido.setSelectedItem(conecta.rs.getString("TrabalhaDetido"));
            jComboBoxDesempregado.setSelectedItem(conecta.rs.getString("Desempregado"));
            jComboBoxCarteiraAssinada.setSelectedItem(conecta.rs.getString("CarteiraAssinada"));
            jQuantoTempoCarteira.setText(conecta.rs.getString("QuantoTempoCarteira"));
            jFaixaSalarial.setText(conecta.rs.getString("FaixaSalarial"));
            jComboBoxTemBeneficios.setSelectedItem(conecta.rs.getString("TemBeneficios"));
            jQuemTemBeneficios.setText(conecta.rs.getString("QuemTemBeneficios"));
            jComboBoxDemandaReclusao.setSelectedItem(conecta.rs.getString("DemandaReclusao"));
            jComboBoxDemandaDesemprego.setSelectedItem(conecta.rs.getString("DemandaDesemprego"));
            jComboBoxPossuiRedimento.setSelectedItem(conecta.rs.getString("PossuiRedimento"));
            jQualRendimento.setText(conecta.rs.getString("QualRendimento"));
            jComboBoxExerceAtividade.setSelectedItem(conecta.rs.getString("ExerceAtividade"));
            jQualAtividadeExerce.setText(conecta.rs.getString("QualAtividadeExerce"));
            jComboBoxGeracaoRenda.setSelectedItem(conecta.rs.getString("GeracaoRenda"));
            jComboBoxAptidaoProfissional.setSelectedItem(conecta.rs.getString("AptidaoProfissional"));
            jQualAptidao.setText(conecta.rs.getString("QualAptidao"));
            jComboBoxDemandaProfissional.setSelectedItem(conecta.rs.getString("DemandaProfissional"));
            jQualDemandaProfissional.setText(conecta.rs.getString("QualDemandaProfissional"));
            jComboBoxAptidaoArt.setSelectedItem(conecta.rs.getString("AptidaoArt"));
            jQualAptidaoArt.setText(conecta.rs.getString("QualAptidaoArt"));
            jComboBoxDemandaLazer.setSelectedItem(conecta.rs.getString("DemandaLazer"));
            jQualDemandaLazer.setText(conecta.rs.getString("QualDemandaLazer"));
            if (codigoPSI != 0) {
                jBtNovoPSI.setEnabled(true);
                jBtAlterarPSI.setEnabled(true);
                jBtExcluirPSI.setEnabled(true);
                jBtSalvarPSI.setEnabled(!true);
                jBtCancelarPSI.setEnabled(!true);
                jBtAuditoriaPSI.setEnabled(true);
            }
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void buscarCodigoPSI() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM FICHA_CADASTRO_PAI_DPTL");
            conecta.rs.last();
            codigoPSI = conecta.rs.getInt("IdDPTL");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarCodigoPSI() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM FICHA_CADASTRO_PAI_DPTL "
                    + "WHERE IdPai='" + jCodigoPAI.getText() + "' "
                    + "AND IdInternoCrc='" + jIdInternoPAI.getText() + "'");
            conecta.rs.first();
            codigoPaiPSI = conecta.rs.getInt("IdPai");
            codigoInternoPSI = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void NovoDJ() {
        jComboBoxRegimeAprisionamento.setSelectedItem("Selecione...");
        jArtigo.setText("");
        jDelito.setText("");
        jComboBoxReincidente.setSelectedItem("Não");
        jComboBoxPossuiPena.setSelectedItem("Não");
        jComboBoxQualPena.setSelectedItem("Selecione...");
        jComboBoxPossuiJuridica.setSelectedItem("Não");
        jComboBoxQualAssistenciaJuridica.setSelectedItem("Selecione...");
        jComboBoxPROMAE.setSelectedItem("Selecione...");
        jComboBoxAssistenciaJuridica.setSelectedItem("Não");
        jComboBoxTrabalhaempresa.setSelectedItem("Não");
        jTelefoneContatoEmpresa.setText("");
        jQualEmpresa.setText("");
        jQualFuncaoExerce.setText("");
        jComboBoxCartaInformal.setSelectedItem("Não");
        jParaOnde.setText("");
        jTelefoneContato.setText("");
        jComboBoxEstudaUP.setSelectedItem("Não");
        jOndeEstuda.setText("");
        jComboBoxNecessitaTrabalho.setSelectedItem("Não");
        jQualNecessitaTrabalho.setText("");
        jComboBoxNecessitaEstudaFUP.setSelectedItem("Não");
        jQualNecessidadeEstudaFUP.setText("");
        //
        jComboBoxRegimeAprisionamento.setEnabled(true);
        jArtigo.setEnabled(true);
        jDelito.setEnabled(true);
        jComboBoxReincidente.setEnabled(true);
        jComboBoxPossuiPena.setEnabled(true);
        jComboBoxQualPena.setEnabled(true);
        jComboBoxPossuiJuridica.setEnabled(true);
        jComboBoxQualAssistenciaJuridica.setEnabled(true);
        jComboBoxPROMAE.setEnabled(true);
        jComboBoxAssistenciaJuridica.setEnabled(true);
        jComboBoxTrabalhaempresa.setEnabled(true);
        jTelefoneContatoEmpresa.setEnabled(true);
        jQualEmpresa.setEnabled(true);
        jQualFuncaoExerce.setEnabled(true);
        jComboBoxCartaInformal.setEnabled(true);
        jParaOnde.setEnabled(true);
        jTelefoneContato.setEnabled(true);
        jComboBoxEstudaUP.setEnabled(true);
        jOndeEstuda.setEnabled(true);
        jComboBoxNecessitaTrabalho.setEnabled(true);
        jQualNecessitaTrabalho.setEnabled(true);
        jComboBoxNecessitaEstudaFUP.setEnabled(true);
        jQualNecessidadeEstudaFUP.setEnabled(true);
        // D.J.        
        jBtSalvarDJ.setEnabled(true);
        jBtCancelarDJ.setEnabled(true);
    }

    public void AlterarDJ() {
        jComboBoxRegimeAprisionamento.setEnabled(true);
        jArtigo.setEnabled(true);
        jDelito.setEnabled(true);
        jComboBoxReincidente.setEnabled(true);
        jComboBoxPossuiPena.setEnabled(true);
        jComboBoxQualPena.setEnabled(true);
        jComboBoxPossuiJuridica.setEnabled(true);
        jComboBoxQualAssistenciaJuridica.setEnabled(true);
        jComboBoxPROMAE.setEnabled(true);
        jComboBoxAssistenciaJuridica.setEnabled(true);
        jComboBoxTrabalhaempresa.setEnabled(true);
        jTelefoneContatoEmpresa.setEnabled(true);
        jQualEmpresa.setEnabled(true);
        jQualFuncaoExerce.setEnabled(true);
        jComboBoxCartaInformal.setEnabled(true);
        jParaOnde.setEnabled(true);
        jTelefoneContato.setEnabled(true);
        jComboBoxEstudaUP.setEnabled(true);
        jOndeEstuda.setEnabled(true);
        jComboBoxNecessitaTrabalho.setEnabled(true);
        jQualNecessitaTrabalho.setEnabled(true);
        jComboBoxNecessitaEstudaFUP.setEnabled(true);
        jQualNecessidadeEstudaFUP.setEnabled(true);
        // D.J.        
        jBtSalvarDJ.setEnabled(true);
        jBtCancelarDJ.setEnabled(true);
    }

    public void ExcluirDJ() {
        bloquearBotoes();
        bloquearCampos();
        jComboBoxRegimeAprisionamento.setSelectedItem("Selecione...");
        jArtigo.setText("");
        jDelito.setText("");
        jComboBoxReincidente.setSelectedItem("Não");
        jComboBoxPossuiPena.setSelectedItem("Não");
        jComboBoxQualPena.setSelectedItem("Selecione...");
        jComboBoxPossuiJuridica.setSelectedItem("Não");
        jComboBoxQualAssistenciaJuridica.setSelectedItem("Selecione...");
        jComboBoxPROMAE.setSelectedItem("Selecione...");
        jComboBoxAssistenciaJuridica.setSelectedItem("Não");
        jComboBoxTrabalhaempresa.setSelectedItem("Não");
        jTelefoneContatoEmpresa.setText("");
        jQualEmpresa.setText("");
        jQualFuncaoExerce.setText("");
        jComboBoxCartaInformal.setSelectedItem("Não");
        jParaOnde.setText("");
        jTelefoneContato.setText("");
        jComboBoxEstudaUP.setSelectedItem("Não");
        jOndeEstuda.setText("");
        jComboBoxNecessitaTrabalho.setSelectedItem("Não");
        jQualNecessitaTrabalho.setText("");
        jComboBoxNecessitaEstudaFUP.setSelectedItem("Não");
        jQualNecessidadeEstudaFUP.setText("");
        //
        jComboBoxRegimeAprisionamento.setEnabled(!true);
        jArtigo.setEnabled(!true);
        jDelito.setEnabled(!true);
        jComboBoxReincidente.setEnabled(!true);
        jComboBoxPossuiPena.setEnabled(!true);
        jComboBoxQualPena.setEnabled(!true);
        jComboBoxPossuiJuridica.setEnabled(!true);
        jComboBoxQualAssistenciaJuridica.setEnabled(!true);
        jComboBoxPROMAE.setEnabled(!true);
        jComboBoxAssistenciaJuridica.setEnabled(!true);
        jComboBoxTrabalhaempresa.setEnabled(!true);
        jTelefoneContatoEmpresa.setEnabled(!true);
        jQualEmpresa.setEnabled(!true);
        jQualFuncaoExerce.setEnabled(!true);
        jComboBoxCartaInformal.setEnabled(!true);
        jParaOnde.setEnabled(!true);
        jTelefoneContato.setEnabled(!true);
        jComboBoxEstudaUP.setEnabled(!true);
        jOndeEstuda.setEnabled(!true);
        jComboBoxNecessitaTrabalho.setEnabled(!true);
        jQualNecessitaTrabalho.setEnabled(!true);
        jComboBoxNecessitaEstudaFUP.setEnabled(!true);
        jQualNecessidadeEstudaFUP.setEnabled(!true);
        // D.J.        
        jBtNovoDJ.setEnabled(true);
        jBtNovoEAPI1.setEnabled(true);
        jBtNovoEAPI2.setEnabled(true);
        jBtNovoPSI.setEnabled(true);
        jBtNovoTO.setEnabled(true);
        jBtNovoSS.setEnabled(true);
        // MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
    }

    public void SalvarDJ() {
        bloquearBotoes();
        bloquearCampos();
        //
        jComboBoxRegimeAprisionamento.setEnabled(!true);
        jArtigo.setEnabled(!true);
        jDelito.setEnabled(!true);
        jComboBoxReincidente.setEnabled(!true);
        jComboBoxPossuiPena.setEnabled(!true);
        jComboBoxQualPena.setEnabled(!true);
        jComboBoxPossuiJuridica.setEnabled(!true);
        jComboBoxQualAssistenciaJuridica.setEnabled(!true);
        jComboBoxPROMAE.setEnabled(!true);
        jComboBoxAssistenciaJuridica.setEnabled(!true);
        jComboBoxTrabalhaempresa.setEnabled(!true);
        jTelefoneContatoEmpresa.setEnabled(!true);
        jQualEmpresa.setEnabled(!true);
        jQualFuncaoExerce.setEnabled(!true);
        jComboBoxCartaInformal.setEnabled(!true);
        jParaOnde.setEnabled(!true);
        jTelefoneContato.setEnabled(!true);
        jComboBoxEstudaUP.setEnabled(!true);
        jOndeEstuda.setEnabled(!true);
        jComboBoxNecessitaTrabalho.setEnabled(!true);
        jQualNecessitaTrabalho.setEnabled(!true);
        jComboBoxNecessitaEstudaFUP.setEnabled(!true);
        jQualNecessidadeEstudaFUP.setEnabled(!true);
        // D.J.        
        jBtNovoDJ.setEnabled(true);
        jBtAlterarDJ.setEnabled(true);
        jBtExcluirDJ.setEnabled(true);
        jBtSalvarDJ.setEnabled(!true);
        jBtCancelarDJ.setEnabled(!true);
        jBtAuditoriaDJ.setEnabled(true);
        // MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
        //
        jBtNovoEAPI1.setEnabled(true);
        jBtNovoEAPI2.setEnabled(true);
        jBtNovoPSI.setEnabled(true);
        jBtNovoTO.setEnabled(true);
        jBtNovoSS.setEnabled(true);
        jBtNovoSS3.setEnabled(true);
        jBtNovaEvolucao.setEnabled(true);
    }

    public void CancelarDJ() {
        bloquearBotoes();
        bloquearCampos();
        jComboBoxRegimeAprisionamento.setSelectedItem("Selecione...");
        jArtigo.setText("");
        jDelito.setText("");
        jComboBoxReincidente.setSelectedItem("Não");
        jComboBoxPossuiPena.setSelectedItem("Não");
        jComboBoxQualPena.setSelectedItem("Selecione...");
        jComboBoxPossuiJuridica.setSelectedItem("Não");
        jComboBoxQualAssistenciaJuridica.setSelectedItem("Selecione...");
        jComboBoxPROMAE.setSelectedItem("Selecione...");
        jComboBoxAssistenciaJuridica.setSelectedItem("Não");
        jComboBoxTrabalhaempresa.setSelectedItem("Não");
        jTelefoneContatoEmpresa.setText("");
        jQualEmpresa.setText("");
        jQualFuncaoExerce.setText("");
        jComboBoxCartaInformal.setSelectedItem("Não");
        jParaOnde.setText("");
        jTelefoneContato.setText("");
        jComboBoxEstudaUP.setSelectedItem("Não");
        jOndeEstuda.setText("");
        jComboBoxNecessitaTrabalho.setSelectedItem("Não");
        jQualNecessitaTrabalho.setText("");
        jComboBoxNecessitaEstudaFUP.setSelectedItem("Não");
        jQualNecessidadeEstudaFUP.setText("");
        //
        jComboBoxRegimeAprisionamento.setEnabled(!true);
        jArtigo.setEnabled(!true);
        jDelito.setEnabled(!true);
        jComboBoxReincidente.setEnabled(!true);
        jComboBoxPossuiPena.setEnabled(!true);
        jComboBoxQualPena.setEnabled(!true);
        jComboBoxPossuiJuridica.setEnabled(!true);
        jComboBoxQualAssistenciaJuridica.setEnabled(!true);
        jComboBoxPROMAE.setEnabled(!true);
        jComboBoxAssistenciaJuridica.setEnabled(!true);
        jComboBoxTrabalhaempresa.setEnabled(!true);
        jTelefoneContatoEmpresa.setEnabled(!true);
        jQualEmpresa.setEnabled(!true);
        jQualFuncaoExerce.setEnabled(!true);
        jComboBoxCartaInformal.setEnabled(!true);
        jParaOnde.setEnabled(!true);
        jTelefoneContato.setEnabled(!true);
        jComboBoxEstudaUP.setEnabled(!true);
        jOndeEstuda.setEnabled(!true);
        jComboBoxNecessitaTrabalho.setEnabled(!true);
        jQualNecessitaTrabalho.setEnabled(!true);
        jComboBoxNecessitaEstudaFUP.setEnabled(!true);
        jQualNecessidadeEstudaFUP.setEnabled(!true);
        // D.J.        
        jBtNovoDJ.setEnabled(true);
        jBtNovoEAPI1.setEnabled(true);
        jBtNovoEAPI2.setEnabled(true);
        jBtNovoPSI.setEnabled(true);
        jBtNovoTO.setEnabled(true);
        jBtNovoSS.setEnabled(true);
        // MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
        //D.J.
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM FICHA_CADASTRO_PAI_DJ "
                    + "INNER JOIN FICHA_CADASTRO_PAI_PSICOSOCIAL "
                    + "ON FICHA_CADASTRO_PAI_DJ.IdPai=FICHA_CADASTRO_PAI_PSICOSOCIAL.IdPai "
                    + "WHERE FICHA_CADASTRO_PAI_DJ.IdPai='" + jCodigoPAI.getText() + "'");
            conecta.rs.first();
            codigoDJ = conecta.rs.getInt("IdDJ");
            jComboBoxRegimeAprisionamento.setSelectedItem(conecta.rs.getString("RegimeAprisionamento"));
            jArtigo.setText(conecta.rs.getString("Artigo"));
            jDelito.setText(conecta.rs.getString("Delito"));
            jComboBoxReincidente.setSelectedItem(conecta.rs.getString("Reincidente"));
            jComboBoxPossuiPena.setSelectedItem(conecta.rs.getString("PossuiPena"));
            jComboBoxQualPena.setSelectedItem(conecta.rs.getString("QualPena"));
            jComboBoxPossuiJuridica.setSelectedItem(conecta.rs.getString("PossuiJuridica"));
            jComboBoxQualAssistenciaJuridica.setSelectedItem(conecta.rs.getString("QualAssistenciaJuridica"));
            jComboBoxPROMAE.setSelectedItem(conecta.rs.getString("PROMAE"));
            jComboBoxAssistenciaJuridica.setSelectedItem(conecta.rs.getString("AssistenciaJuridica"));
            jComboBoxTrabalhaempresa.setSelectedItem(conecta.rs.getString("Trabalhaempresa"));
            jTelefoneContatoEmpresa.setText(conecta.rs.getString("TelefoneContatoEmpresa"));
            jQualEmpresa.setText(conecta.rs.getString("QualEmpresa"));
            jQualFuncaoExerce.setText(conecta.rs.getString("QualFuncaoExerce"));
            jComboBoxCartaInformal.setSelectedItem(conecta.rs.getString("CartaInformal"));
            jParaOnde.setText(conecta.rs.getString("ParaOnde"));
            jTelefoneContato.setText(conecta.rs.getString("TelefoneContato"));
            jComboBoxEstudaUP.setSelectedItem(conecta.rs.getString("EstudaUP"));
            jOndeEstuda.setText(conecta.rs.getString("OndeEstuda"));
            jComboBoxNecessitaTrabalho.setSelectedItem(conecta.rs.getString("NecessitaTrabalho"));
            jQualNecessitaTrabalho.setText(conecta.rs.getString("QualNecessitaTrabalho"));
            jComboBoxNecessitaEstudaFUP.setSelectedItem(conecta.rs.getString("NecessitaEstudaFUP"));
            jQualNecessidadeEstudaFUP.setText(conecta.rs.getString("QualNecessidadeEstudaFUP"));
            if (codigoDJ != 0) {
                jBtNovoDJ.setEnabled(true);
                jBtAlterarDJ.setEnabled(true);
                jBtExcluirDJ.setEnabled(true);
                jBtSalvarDJ.setEnabled(!true);
                jBtCancelarDJ.setEnabled(!true);
                jBtAuditoriaDJ.setEnabled(true);
            }
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void buscarCodigoDJ() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM FICHA_CADASTRO_PAI_DJ ");
            conecta.rs.last();
            codigoDJ = conecta.rs.getInt("IdDJ");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível obter o código do registro.\nERRO: " + e);
        }
        conecta.desconecta();
    }

    public void verificarCodigoDJ() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM FICHA_CADASTRO_PAI_DJ "
                    + "WHERE IdPai='" + jCodigoPAI.getText() + "' "
                    + "AND IdInternoCrc='" + jIdInternoPAI.getText() + "'");
            conecta.rs.first();
            codigoPaiDJ = conecta.rs.getInt("IdPai");
            codigoInternoDJ = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void NovoSS3() {
        jComboBoxRefereSaude.setSelectedItem("Não");
        jRBHanseniase.setSelected(!true);
        jRBDiabetes.setSelected(!true);
        jRBTuberculose.setSelected(!true);
        jRBHipertensao.setSelected(!true);
        jRBHepatites.setSelected(!true);
        jRBSifilis.setSelected(!true);
        jRBEscabiose.setSelected(!true);
        jRBHIV.setSelected(!true);
        jOutrasDoencas.setText("");
        jComboBoxFazendoTratamento.setSelectedItem("Não");
        jComboBoxPsiquiatrico.setSelectedItem("Não");
        jOndePsiquiatrico.setText("");
        jComboBoxPsicotropico.setSelectedItem("Não");
        jQualPsicotropico.setText("");
        jComboBoxMental.setSelectedItem("Não");
        jRBDesanimo.setSelected(!true);
        jRBInsonia.setSelected(!true);
        jRBFaltaApetite.setSelected(!true);
        jRBIsomantoSocial.setSelected(!true);
        jRBPensamentosSuicida.setSelected(!true);
        jRBAgressividade.setSelected(!true);
        jRBInquientacao.setSelected(!true);
        jRBOutrosDoencas.setSelected(!true);
        jQualOutrosDoencas.setText("");
        jComboBoxInternadoPSI.setSelectedItem("Não");
        jDataInternaPSI.setDate(null);
        jComboBoxAcompanhaCAPS.setSelectedItem("Não");
        jDataCAPS.setDate(null);
        jComboBoxUsoPsicoativos.setSelectedItem("Não");
        jRBAlcool.setSelected(!true);
        jRBMaconha.setSelected(!true);
        jRBCocaina.setSelected(!true);
        jRBCola.setSelected(!true);
        jRBCrack.setSelected(!true);
        jRBInjetaveis.setSelected(!true);
        jRBOutrasSub.setSelected(!true);
        jQualOutrasSub.setText("");
        jComboBoxCompartilhaCrack.setSelectedItem("Não");
        jRBSudorese.setSelected(!true);
        jRBTremores.setSelected(!true);
        jRBFissura.setSelected(!true);
        jRBBoca.setSelected(!true);
        jRBNausea.setSelected(!true);
        jRBDesejo.setSelected(!true);
        jRBNaoPara.setSelected(!true);
        jRBAumentoTolerancia.setSelected(!true);
        jComboBoxCAPSAD.setSelectedItem("Não");
        jDataCAPSAD.setDate(null);
        jComboBoxEsteveInternado.setSelectedItem("Não");
        jQuantoTempoInternado.setText("0");
        jComboBoxAceitaDanos.setSelectedItem("Não");
        jComboBoxSaudeBucal.setSelectedItem("Não");
        jComboBoxNecessitaAtende.setSelectedItem("Não");
        jRBEnfermagem.setSelected(!true);
        jRBMedico.setSelected(!true);
        jRBPsicologico.setSelected(!true);
        jRBPsiquiatrico.setSelected(!true);
        jComboBoxPessoasQuimica.setSelectedItem("Não");
        jQuemNecessita.setText("");
        //
        jComboBoxRefereSaude.setEnabled(true);
        jRBHanseniase.setEnabled(true);
        jRBDiabetes.setEnabled(true);
        jRBTuberculose.setEnabled(true);
        jRBHipertensao.setEnabled(true);
        jRBHepatites.setEnabled(true);
        jRBSifilis.setEnabled(true);
        jRBEscabiose.setEnabled(true);
        jRBHIV.setEnabled(true);
        jOutrasDoencas.setEnabled(true);
        jComboBoxFazendoTratamento.setEnabled(true);
        jComboBoxPsiquiatrico.setEnabled(true);
        jOndePsiquiatrico.setEnabled(true);
        jComboBoxPsicotropico.setEnabled(true);
        jQualPsicotropico.setEnabled(true);
        jComboBoxMental.setEnabled(true);
        jRBDesanimo.setEnabled(true);
        jRBInsonia.setEnabled(true);
        jRBFaltaApetite.setEnabled(true);
        jRBIsomantoSocial.setEnabled(true);
        jRBPensamentosSuicida.setEnabled(true);
        jRBAgressividade.setEnabled(true);
        jRBInquientacao.setEnabled(true);
        jRBOutrosDoencas.setEnabled(true);
        jQualOutrosDoencas.setEnabled(true);
        jComboBoxInternadoPSI.setEnabled(true);
        jDataInternaPSI.setEnabled(true);
        jComboBoxAcompanhaCAPS.setEnabled(true);
        jDataCAPS.setEnabled(true);
        jComboBoxUsoPsicoativos.setEnabled(true);
        jRBAlcool.setEnabled(true);
        jRBMaconha.setEnabled(true);
        jRBCocaina.setEnabled(true);
        jRBCola.setEnabled(true);
        jRBCrack.setEnabled(true);
        jRBInjetaveis.setEnabled(true);
        jRBOutrasSub.setEnabled(true);
        jQualOutrasSub.setEnabled(true);
        jComboBoxCompartilhaCrack.setEnabled(true);
        jRBSudorese.setEnabled(true);
        jRBTremores.setEnabled(true);
        jRBFissura.setEnabled(true);
        jRBBoca.setEnabled(true);
        jRBNausea.setEnabled(true);
        jRBDesejo.setEnabled(true);
        jRBNaoPara.setEnabled(true);
        jRBAumentoTolerancia.setEnabled(true);
        jComboBoxCAPSAD.setEnabled(true);
        jDataCAPSAD.setEnabled(true);
        jComboBoxEsteveInternado.setEnabled(true);
        jQuantoTempoInternado.setEnabled(true);
        jComboBoxAceitaDanos.setEnabled(true);
        jComboBoxSaudeBucal.setEnabled(true);
        jComboBoxNecessitaAtende.setEnabled(true);
        jRBEnfermagem.setEnabled(true);
        jRBMedico.setEnabled(true);
        jRBPsicologico.setEnabled(true);
        jRBPsiquiatrico.setEnabled(true);
        jComboBoxPessoasQuimica.setEnabled(true);
        jQuemNecessita.setEnabled(true);
        //
        jBtNovoSS3.setEnabled(!true);
        jBtAlterarSS3.setEnabled(!true);
        jBtExcluirSS3.setEnabled(!true);
        jBtSalvarSS3.setEnabled(true);
        jBtCancelarSS3.setEnabled(true);
        jBtAuditoriaSS3.setEnabled(!true);
    }

    public void AlterarSS3() {
        jComboBoxRefereSaude.setEnabled(true);
        jRBHanseniase.setEnabled(true);
        jRBDiabetes.setEnabled(true);
        jRBTuberculose.setEnabled(true);
        jRBHipertensao.setEnabled(true);
        jRBHepatites.setEnabled(true);
        jRBSifilis.setEnabled(true);
        jRBEscabiose.setEnabled(true);
        jRBHIV.setEnabled(true);
        jOutrasDoencas.setEnabled(true);
        jComboBoxFazendoTratamento.setEnabled(true);
        jComboBoxPsiquiatrico.setEnabled(true);
        jOndePsiquiatrico.setEnabled(true);
        jComboBoxPsicotropico.setEnabled(true);
        jQualPsicotropico.setEnabled(true);
        jComboBoxMental.setEnabled(true);
        jRBDesanimo.setEnabled(true);
        jRBInsonia.setEnabled(true);
        jRBFaltaApetite.setEnabled(true);
        jRBIsomantoSocial.setEnabled(true);
        jRBPensamentosSuicida.setEnabled(true);
        jRBAgressividade.setEnabled(true);
        jRBInquientacao.setEnabled(true);
        jRBOutrosDoencas.setEnabled(true);
        jQualOutrosDoencas.setEnabled(true);
        jComboBoxInternadoPSI.setEnabled(true);
        jDataInternaPSI.setEnabled(true);
        jComboBoxAcompanhaCAPS.setEnabled(true);
        jDataCAPS.setEnabled(true);
        jComboBoxUsoPsicoativos.setEnabled(true);
        jRBAlcool.setEnabled(true);
        jRBMaconha.setEnabled(true);
        jRBCocaina.setEnabled(true);
        jRBCola.setEnabled(true);
        jRBCrack.setEnabled(true);
        jRBInjetaveis.setEnabled(true);
        jRBOutrasSub.setEnabled(true);
        jQualOutrasSub.setEnabled(true);
        jComboBoxCompartilhaCrack.setEnabled(true);
        jRBSudorese.setEnabled(true);
        jRBTremores.setEnabled(true);
        jRBFissura.setEnabled(true);
        jRBBoca.setEnabled(true);
        jRBNausea.setEnabled(true);
        jRBDesejo.setEnabled(true);
        jRBNaoPara.setEnabled(true);
        jRBAumentoTolerancia.setEnabled(true);
        jComboBoxCAPSAD.setEnabled(true);
        jDataCAPSAD.setEnabled(true);
        jComboBoxEsteveInternado.setEnabled(true);
        jQuantoTempoInternado.setEnabled(true);
        jComboBoxAceitaDanos.setEnabled(true);
        jComboBoxSaudeBucal.setEnabled(true);
        jComboBoxNecessitaAtende.setEnabled(true);
        jRBEnfermagem.setEnabled(true);
        jRBMedico.setEnabled(true);
        jRBPsicologico.setEnabled(true);
        jRBPsiquiatrico.setEnabled(true);
        jComboBoxPessoasQuimica.setEnabled(true);
        jQuemNecessita.setEnabled(true);
        //
        jBtNovoSS3.setEnabled(!true);
        jBtAlterarSS3.setEnabled(!true);
        jBtExcluirSS3.setEnabled(!true);
        jBtSalvarSS3.setEnabled(true);
        jBtCancelarSS3.setEnabled(true);
        jBtAuditoriaSS3.setEnabled(!true);
    }

    public void ExcluirSS3() {
        jComboBoxRefereSaude.setSelectedItem("Não");
        jRBHanseniase.setSelected(!true);
        jRBDiabetes.setSelected(!true);
        jRBTuberculose.setSelected(!true);
        jRBHipertensao.setSelected(!true);
        jRBHepatites.setSelected(!true);
        jRBSifilis.setSelected(!true);
        jRBEscabiose.setSelected(!true);
        jRBHIV.setSelected(!true);
        jOutrasDoencas.setText("");
        jComboBoxFazendoTratamento.setSelectedItem("Não");
        jComboBoxPsiquiatrico.setSelectedItem("Não");
        jOndePsiquiatrico.setText("");
        jComboBoxPsicotropico.setSelectedItem("Não");
        jQualPsicotropico.setText("");
        jComboBoxMental.setSelectedItem("Não");
        jRBDesanimo.setSelected(!true);
        jRBInsonia.setSelected(!true);
        jRBFaltaApetite.setSelected(!true);
        jRBIsomantoSocial.setSelected(!true);
        jRBPensamentosSuicida.setSelected(!true);
        jRBAgressividade.setSelected(!true);
        jRBInquientacao.setSelected(!true);
        jRBOutrosDoencas.setSelected(!true);
        jQualOutrosDoencas.setText("");
        jComboBoxInternadoPSI.setSelectedItem("Não");
        jDataInternaPSI.setDate(null);
        jComboBoxAcompanhaCAPS.setSelectedItem("Não");
        jDataCAPS.setDate(null);
        jComboBoxUsoPsicoativos.setSelectedItem("Não");
        jRBAlcool.setSelected(!true);
        jRBMaconha.setSelected(!true);
        jRBCocaina.setSelected(!true);
        jRBCola.setSelected(!true);
        jRBCrack.setSelected(!true);
        jRBInjetaveis.setSelected(!true);
        jRBOutrasSub.setSelected(!true);
        jQualOutrasSub.setText("");
        jComboBoxCompartilhaCrack.setSelectedItem("Não");
        jRBSudorese.setSelected(!true);
        jRBTremores.setSelected(!true);
        jRBFissura.setSelected(!true);
        jRBBoca.setSelected(!true);
        jRBNausea.setSelected(!true);
        jRBDesejo.setSelected(!true);
        jRBNaoPara.setSelected(!true);
        jRBAumentoTolerancia.setSelected(!true);
        jComboBoxCAPSAD.setSelectedItem("Não");
        jDataCAPSAD.setDate(null);
        jComboBoxEsteveInternado.setSelectedItem("Não");
        jQuantoTempoInternado.setText("");
        jComboBoxAceitaDanos.setSelectedItem("Não");
        jComboBoxSaudeBucal.setSelectedItem("Não");
        jComboBoxNecessitaAtende.setSelectedItem("Não");
        jRBEnfermagem.setSelected(!true);
        jRBMedico.setSelected(!true);
        jRBPsicologico.setSelected(!true);
        jRBPsiquiatrico.setSelected(!true);
        jComboBoxPessoasQuimica.setSelectedItem("Não");
        jQuemNecessita.setText("");
        //
        jComboBoxRefereSaude.setEnabled(!true);
        jRBHanseniase.setEnabled(!true);
        jRBDiabetes.setEnabled(!true);
        jRBTuberculose.setEnabled(!true);
        jRBHipertensao.setEnabled(!true);
        jRBHepatites.setEnabled(!true);
        jRBSifilis.setEnabled(!true);
        jRBEscabiose.setEnabled(!true);
        jRBHIV.setEnabled(!true);
        jOutrasDoencas.setEnabled(!true);
        jComboBoxFazendoTratamento.setEnabled(!true);
        jComboBoxPsiquiatrico.setEnabled(!true);
        jOndePsiquiatrico.setEnabled(!true);
        jComboBoxPsicotropico.setEnabled(!true);
        jQualPsicotropico.setEnabled(!true);
        jComboBoxMental.setEnabled(!true);
        jRBDesanimo.setEnabled(!true);
        jRBInsonia.setEnabled(!true);
        jRBFaltaApetite.setEnabled(!true);
        jRBIsomantoSocial.setEnabled(!true);
        jRBPensamentosSuicida.setEnabled(!true);
        jRBAgressividade.setEnabled(!true);
        jRBInquientacao.setEnabled(!true);
        jRBOutrosDoencas.setEnabled(!true);
        jQualOutrosDoencas.setEnabled(!true);
        jComboBoxInternadoPSI.setEnabled(!true);
        jDataInternaPSI.setEnabled(!true);
        jComboBoxAcompanhaCAPS.setEnabled(!true);
        jDataCAPS.setEnabled(!true);
        jComboBoxUsoPsicoativos.setEnabled(!true);
        jRBAlcool.setEnabled(!true);
        jRBMaconha.setEnabled(!true);
        jRBCocaina.setEnabled(!true);
        jRBCola.setEnabled(!true);
        jRBCrack.setEnabled(!true);
        jRBInjetaveis.setEnabled(!true);
        jRBOutrasSub.setEnabled(!true);
        jQualOutrasSub.setEnabled(!true);
        jComboBoxCompartilhaCrack.setEnabled(!true);
        jRBSudorese.setEnabled(!true);
        jRBTremores.setEnabled(!true);
        jRBFissura.setEnabled(!true);
        jRBBoca.setEnabled(!true);
        jRBNausea.setEnabled(!true);
        jRBDesejo.setEnabled(!true);
        jRBNaoPara.setEnabled(!true);
        jRBAumentoTolerancia.setEnabled(!true);
        jComboBoxCAPSAD.setEnabled(!true);
        jDataCAPSAD.setEnabled(!true);
        jComboBoxEsteveInternado.setEnabled(!true);
        jQuantoTempoInternado.setEnabled(!true);
        jComboBoxAceitaDanos.setEnabled(!true);
        jComboBoxSaudeBucal.setEnabled(!true);
        jComboBoxNecessitaAtende.setEnabled(!true);
        jRBEnfermagem.setEnabled(!true);
        jRBMedico.setEnabled(!true);
        jRBPsicologico.setEnabled(!true);
        jRBPsiquiatrico.setEnabled(!true);
        jComboBoxPessoasQuimica.setEnabled(!true);
        jQuemNecessita.setEnabled(!true);
        //
        jBtNovoSS3.setEnabled(true);
        jBtAlterarSS3.setEnabled(!true);
        jBtExcluirSS3.setEnabled(!true);
        jBtSalvarSS3.setEnabled(!true);
        jBtCancelarSS3.setEnabled(!true);
        jBtAuditoriaSS3.setEnabled(!true);
        //
        jBtNovoDJ.setEnabled(true);
        jBtNovoEAPI1.setEnabled(true);
        jBtNovoEAPI2.setEnabled(true);
        jBtNovoPSI.setEnabled(true);
        jBtNovoTO.setEnabled(true);
        jBtNovoSS.setEnabled(true);
        jBtNovaEvolucao.setEnabled(true);
        //MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
    }

    public void SalvarSS3() {
        jComboBoxRefereSaude.setEnabled(!true);
        jRBHanseniase.setEnabled(!true);
        jRBDiabetes.setEnabled(!true);
        jRBTuberculose.setEnabled(!true);
        jRBHipertensao.setEnabled(!true);
        jRBHepatites.setEnabled(!true);
        jRBSifilis.setEnabled(!true);
        jRBEscabiose.setEnabled(!true);
        jRBHIV.setEnabled(!true);
        jOutrasDoencas.setEnabled(!true);
        jComboBoxFazendoTratamento.setEnabled(!true);
        jComboBoxPsiquiatrico.setEnabled(!true);
        jOndePsiquiatrico.setEnabled(!true);
        jComboBoxPsicotropico.setEnabled(!true);
        jQualPsicotropico.setEnabled(!true);
        jComboBoxMental.setEnabled(!true);
        jRBDesanimo.setEnabled(!true);
        jRBInsonia.setEnabled(!true);
        jRBFaltaApetite.setEnabled(!true);
        jRBIsomantoSocial.setEnabled(!true);
        jRBPensamentosSuicida.setEnabled(!true);
        jRBAgressividade.setEnabled(!true);
        jRBInquientacao.setEnabled(!true);
        jRBOutrosDoencas.setEnabled(!true);
        jQualOutrosDoencas.setEnabled(!true);
        jComboBoxInternadoPSI.setEnabled(!true);
        jDataInternaPSI.setEnabled(!true);
        jComboBoxAcompanhaCAPS.setEnabled(!true);
        jDataCAPS.setEnabled(!true);
        jComboBoxUsoPsicoativos.setEnabled(!true);
        jRBAlcool.setEnabled(!true);
        jRBMaconha.setEnabled(!true);
        jRBCocaina.setEnabled(!true);
        jRBCola.setEnabled(!true);
        jRBCrack.setEnabled(!true);
        jRBInjetaveis.setEnabled(!true);
        jRBOutrasSub.setEnabled(!true);
        jQualOutrasSub.setEnabled(!true);
        jComboBoxCompartilhaCrack.setEnabled(!true);
        jRBSudorese.setEnabled(!true);
        jRBTremores.setEnabled(!true);
        jRBFissura.setEnabled(!true);
        jRBBoca.setEnabled(!true);
        jRBNausea.setEnabled(!true);
        jRBDesejo.setEnabled(!true);
        jRBNaoPara.setEnabled(!true);
        jRBAumentoTolerancia.setEnabled(!true);
        jComboBoxCAPSAD.setEnabled(!true);
        jDataCAPSAD.setEnabled(!true);
        jComboBoxEsteveInternado.setEnabled(!true);
        jQuantoTempoInternado.setEnabled(!true);
        jComboBoxAceitaDanos.setEnabled(!true);
        jComboBoxSaudeBucal.setEnabled(!true);
        jComboBoxNecessitaAtende.setEnabled(!true);
        jRBEnfermagem.setEnabled(!true);
        jRBMedico.setEnabled(!true);
        jRBPsicologico.setEnabled(!true);
        jRBPsiquiatrico.setEnabled(!true);
        jComboBoxPessoasQuimica.setEnabled(!true);
        jQuemNecessita.setEnabled(!true);
        //
        jBtNovoSS3.setEnabled(true);
        jBtAlterarSS3.setEnabled(true);
        jBtExcluirSS3.setEnabled(true);
        jBtSalvarSS3.setEnabled(!true);
        jBtCancelarSS3.setEnabled(!true);
        jBtAuditoriaSS3.setEnabled(true);
        //
        jBtNovoDJ.setEnabled(true);
        jBtNovoEAPI1.setEnabled(true);
        jBtNovoEAPI2.setEnabled(true);
        jBtNovoPSI.setEnabled(true);
        jBtNovoTO.setEnabled(true);
        jBtNovoSS.setEnabled(true);
        jBtNovaEvolucao.setEnabled(true);
        //MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
    }

    public void CancelarSS3() {
        jComboBoxRefereSaude.setSelectedItem("Não");
        jRBHanseniase.setSelected(!true);
        jRBDiabetes.setSelected(!true);
        jRBTuberculose.setSelected(!true);
        jRBHipertensao.setSelected(!true);
        jRBHepatites.setSelected(!true);
        jRBSifilis.setSelected(!true);
        jRBEscabiose.setSelected(!true);
        jRBHIV.setSelected(!true);
        jOutrasDoencas.setText("");
        jComboBoxFazendoTratamento.setSelectedItem("Não");
        jComboBoxPsiquiatrico.setSelectedItem("Não");
        jOndePsiquiatrico.setText("");
        jComboBoxPsicotropico.setSelectedItem("Não");
        jQualPsicotropico.setText("");
        jComboBoxMental.setSelectedItem("Não");
        jRBDesanimo.setSelected(!true);
        jRBInsonia.setSelected(!true);
        jRBFaltaApetite.setSelected(!true);
        jRBIsomantoSocial.setSelected(!true);
        jRBPensamentosSuicida.setSelected(!true);
        jRBAgressividade.setSelected(!true);
        jRBInquientacao.setSelected(!true);
        jRBOutrosDoencas.setSelected(!true);
        jQualOutrosDoencas.setText("");
        jComboBoxInternadoPSI.setSelectedItem("Não");
        jDataInternaPSI.setDate(null);
        jComboBoxAcompanhaCAPS.setSelectedItem("Não");
        jDataCAPS.setDate(null);
        jComboBoxUsoPsicoativos.setSelectedItem("Não");
        jRBAlcool.setSelected(!true);
        jRBMaconha.setSelected(!true);
        jRBCocaina.setSelected(!true);
        jRBCola.setSelected(!true);
        jRBCrack.setSelected(!true);
        jRBInjetaveis.setSelected(!true);
        jRBOutrasSub.setSelected(!true);
        jQualOutrasSub.setText("");
        jComboBoxCompartilhaCrack.setSelectedItem("Não");
        jRBSudorese.setSelected(!true);
        jRBTremores.setSelected(!true);
        jRBFissura.setSelected(!true);
        jRBBoca.setSelected(!true);
        jRBNausea.setSelected(!true);
        jRBDesejo.setSelected(!true);
        jRBNaoPara.setSelected(!true);
        jRBAumentoTolerancia.setSelected(!true);
        jComboBoxCAPSAD.setSelectedItem("Não");
        jDataCAPSAD.setDate(null);
        jComboBoxEsteveInternado.setSelectedItem("Não");
        jQuantoTempoInternado.setText("");
        jComboBoxAceitaDanos.setSelectedItem("Não");
        jComboBoxSaudeBucal.setSelectedItem("Não");
        jComboBoxNecessitaAtende.setSelectedItem("Não");
        jRBEnfermagem.setSelected(!true);
        jRBMedico.setSelected(!true);
        jRBPsicologico.setSelected(!true);
        jRBPsiquiatrico.setSelected(!true);
        jComboBoxPessoasQuimica.setSelectedItem("Não");
        jQuemNecessita.setText("");
        //
        jComboBoxRefereSaude.setEnabled(!true);
        jRBHanseniase.setEnabled(!true);
        jRBDiabetes.setEnabled(!true);
        jRBTuberculose.setEnabled(!true);
        jRBHipertensao.setEnabled(!true);
        jRBHepatites.setEnabled(!true);
        jRBSifilis.setEnabled(!true);
        jRBEscabiose.setEnabled(!true);
        jRBHIV.setEnabled(!true);
        jOutrasDoencas.setEnabled(!true);
        jComboBoxFazendoTratamento.setEnabled(!true);
        jComboBoxPsiquiatrico.setEnabled(!true);
        jOndePsiquiatrico.setEnabled(!true);
        jComboBoxPsicotropico.setEnabled(!true);
        jQualPsicotropico.setEnabled(!true);
        jComboBoxMental.setEnabled(!true);
        jRBDesanimo.setEnabled(!true);
        jRBInsonia.setEnabled(!true);
        jRBFaltaApetite.setEnabled(!true);
        jRBIsomantoSocial.setEnabled(!true);
        jRBPensamentosSuicida.setEnabled(!true);
        jRBAgressividade.setEnabled(!true);
        jRBInquientacao.setEnabled(!true);
        jRBOutrosDoencas.setEnabled(!true);
        jQualOutrosDoencas.setEnabled(!true);
        jComboBoxInternadoPSI.setEnabled(!true);
        jDataInternaPSI.setEnabled(!true);
        jComboBoxAcompanhaCAPS.setEnabled(!true);
        jDataCAPS.setEnabled(!true);
        jComboBoxUsoPsicoativos.setEnabled(!true);
        jRBAlcool.setEnabled(!true);
        jRBMaconha.setEnabled(!true);
        jRBCocaina.setEnabled(!true);
        jRBCola.setEnabled(!true);
        jRBCrack.setEnabled(!true);
        jRBInjetaveis.setEnabled(!true);
        jRBOutrasSub.setEnabled(!true);
        jQualOutrasSub.setEnabled(!true);
        jComboBoxCompartilhaCrack.setEnabled(!true);
        jRBSudorese.setEnabled(!true);
        jRBTremores.setEnabled(!true);
        jRBFissura.setEnabled(!true);
        jRBBoca.setEnabled(!true);
        jRBNausea.setEnabled(!true);
        jRBDesejo.setEnabled(!true);
        jRBNaoPara.setEnabled(!true);
        jRBAumentoTolerancia.setEnabled(!true);
        jComboBoxCAPSAD.setEnabled(!true);
        jDataCAPSAD.setEnabled(!true);
        jComboBoxEsteveInternado.setEnabled(!true);
        jQuantoTempoInternado.setEnabled(!true);
        jComboBoxAceitaDanos.setEnabled(!true);
        jComboBoxSaudeBucal.setEnabled(!true);
        jComboBoxNecessitaAtende.setEnabled(!true);
        jRBEnfermagem.setEnabled(!true);
        jRBMedico.setEnabled(!true);
        jRBPsicologico.setEnabled(!true);
        jRBPsiquiatrico.setEnabled(!true);
        jComboBoxPessoasQuimica.setEnabled(!true);
        jQuemNecessita.setEnabled(!true);
        //
        jBtNovoDJ.setEnabled(true);
        jBtNovoEAPI1.setEnabled(true);
        jBtNovoEAPI2.setEnabled(true);
        jBtNovoPSI.setEnabled(true);
        jBtNovoTO.setEnabled(true);
        jBtNovoSS.setEnabled(true);
        jBtNovaEvolucao.setEnabled(true);
        //MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM FICHA_CADASTRO_PAI_DS "
                    + "INNER JOIN FICHA_CADASTRO_PAI_PSICOSOCIAL "
                    + "ON FICHA_CADASTRO_PAI_DS.IdPai=FICHA_CADASTRO_PAI_PSICOSOCIAL.IdPai "
                    + "WHERE FICHA_CADASTRO_PAI_DS.IdPai='" + jCodigoPAI.getText() + "'");
            conecta.rs.first();
            codigoSS3 = conecta.rs.getInt("IdDS");
            jComboBoxRefereSaude.setSelectedItem(conecta.rs.getString("RefereSaude"));
            tipoHanseniase = conecta.rs.getInt("Hanseniase");
            if (tipoHanseniase == 1) {
                jRBHanseniase.setSelected(true);
            } else if (tipoHanseniase == 0) {
                jRBHanseniase.setSelected(!true);
            }
            tipoDiabetes = conecta.rs.getInt("Diabetes");
            if (tipoDiabetes == 1) {
                jRBDiabetes.setSelected(true);
            } else if (tipoDiabetes == 0) {
                jRBDiabetes.setSelected(!true);
            }
            tipoTuberculose = conecta.rs.getInt("Tuberculose");
            if (tipoTuberculose == 1) {
                jRBTuberculose.setSelected(true);
            } else if (tipoTuberculose == 0) {
                jRBTuberculose.setSelected(!true);
            }
            tipoHipertensao = conecta.rs.getInt("Hipertensao");
            if (tipoHipertensao == 1) {
                jRBHanseniase.setSelected(true);
            } else if (tipoHipertensao == 0) {
                jRBHanseniase.setSelected(!true);
            }
            tipoHepatites = conecta.rs.getInt("Hepatites");
            if (tipoHepatites == 1) {
                jRBHepatites.setSelected(true);
            } else if (tipoHepatites == 0) {
                jRBHepatites.setSelected(!true);
            }
            tipoSifilis = conecta.rs.getInt("Sifilis");
            if (tipoSifilis == 1) {
                jRBSifilis.setSelected(true);
            } else if (tipoSifilis == 0) {
                jRBSifilis.setSelected(!true);
            }
            tipoEscabiose = conecta.rs.getInt("Escabiose");
            if (tipoEscabiose == 1) {
                jRBEscabiose.setSelected(true);
            } else if (tipoEscabiose == 0) {
                jRBEscabiose.setSelected(!true);
            }
            tipoHiv = conecta.rs.getInt("HIV");
            if (tipoHiv == 1) {
                jRBHIV.setSelected(true);
            } else if (tipoHiv == 0) {
                jRBHIV.setSelected(!true);
            }
            jOutrasDoencas.setText(conecta.rs.getString("OutrasDoencas"));
            jComboBoxFazendoTratamento.setSelectedItem(conecta.rs.getString("FazendoTratamento"));
            jComboBoxPsiquiatrico.setSelectedItem(conecta.rs.getString("Psiquiatrico"));
            jOndePsiquiatrico.setText(conecta.rs.getString("OndePsiquiatrico"));
            jComboBoxPsicotropico.setSelectedItem(conecta.rs.getString("Psicotropico"));
            jQualPsicotropico.setText(conecta.rs.getString("QualPsicotropico"));
            jComboBoxMental.setSelectedItem(conecta.rs.getString("Mental"));
            tipoDesanimo = conecta.rs.getInt("Desanimo");
            if (tipoDesanimo == 1) {
                jRBDesanimo.setSelected(true);
            } else if (tipoDesanimo == 0) {
                jRBDesanimo.setSelected(!true);
            }
            tipoInsonia = conecta.rs.getInt("Insonia");
            if (tipoInsonia == 1) {
                jRBInsonia.setSelected(true);
            } else if (tipoInsonia == 0) {
                jRBInsonia.setSelected(!true);
            }
            tipoFaltaApetite = conecta.rs.getInt("FaltaApetite");
            if (tipoFaltaApetite == 1) {
                jRBFaltaApetite.setSelected(true);
            } else if (tipoFaltaApetite == 0) {
                jRBFaltaApetite.setSelected(!true);
            }
            tipoIsolamentoSocial = conecta.rs.getInt("IsolamentoSocial");
            if (tipoIsolamentoSocial == 1) {
                jRBIsomantoSocial.setSelected(true);
            } else if (tipoIsolamentoSocial == 0) {
                jRBIsomantoSocial.setSelected(!true);
            }
            tipoPensamentosSuicida = conecta.rs.getInt("PensamentosSuicidas");
            if (tipoPensamentosSuicida == 1) {
                jRBPensamentosSuicida.setSelected(true);
            } else if (tipoPensamentosSuicida == 0) {
                jRBPensamentosSuicida.setSelected(!true);
            }
            tipoAgressividade = conecta.rs.getInt("Agressividade");
            if (tipoAgressividade == 1) {
                jRBAgressividade.setSelected(true);
            } else if (tipoAgressividade == 0) {
                jRBAgressividade.setSelected(!true);
            }
            tipoInquietacaoMotora = conecta.rs.getInt("Inquietacao");
            if (tipoInquietacaoMotora == 1) {
                jRBInquientacao.setSelected(true);
            } else if (tipoInquietacaoMotora == 0) {
                jRBInquientacao.setSelected(!true);
            }
            tipoOutrasDoencas = conecta.rs.getInt("OutroDoencas");
            if (tipoOutrasDoencas == 1) {
                jRBOutrosDoencas.setSelected(true);
            } else if (tipoOutrasDoencas == 0) {
                jRBOutrosDoencas.setSelected(!true);
            }
            jQualOutrosDoencas.setText(conecta.rs.getString("QualOutrosDoencas"));
            jComboBoxInternadoPSI.setSelectedItem(conecta.rs.getString("InternadoPSI"));
            jDataInternaPSI.setDate(conecta.rs.getDate("DataInternaPSI"));
            jComboBoxAcompanhaCAPS.setSelectedItem(conecta.rs.getString("AcompanhaCAPS"));
            jDataCAPS.setDate(conecta.rs.getDate("DataCAPS"));
            jComboBoxUsoPsicoativos.setSelectedItem(conecta.rs.getString("UsoPsicoativos"));
            tipoAlcool = conecta.rs.getInt("Alcool");
            if (tipoAlcool == 1) {
                jRBAlcool.setSelected(true);
            } else if (tipoAlcool == 0) {
                jRBAlcool.setSelected(!true);
            }
            tipoMaconha = conecta.rs.getInt("Maconha");
            if (tipoMaconha == 1) {
                jRBMaconha.setSelected(true);
            } else if (tipoMaconha == 0) {
                jRBMaconha.setSelected(!true);
            }
            tipoCocaina = conecta.rs.getInt("Cocaina");
            if (tipoCocaina == 1) {
                jRBCocaina.setSelected(true);
            } else if (tipoCocaina == 0) {
                jRBCocaina.setSelected(true);
            }
            tipoCola = conecta.rs.getInt("Cola");
            if (tipoCola == 1) {
                jRBCola.setSelected(true);
            } else if (tipoCola == 0) {
                jRBCola.setSelected(!true);
            }
            tipoCrack = conecta.rs.getInt("Crack");
            if (tipoCrack == 1) {
                jRBCrack.setSelected(true);
            } else if (tipoCrack == 0) {
                jRBCrack.setSelected(!true);
            }
            tipoInjetaveis = conecta.rs.getInt("Injetaveis");
            if (tipoInjetaveis == 1) {
                jRBInjetaveis.setSelected(true);
            } else if (tipoInjetaveis == 0) {
                jRBInjetaveis.setSelected(!true);
            }
            tipoOutrasDoencas = conecta.rs.getInt("OutrasSub");
            if (tipoOutrasDoencas == 1) {
                jRBOutrasSub.setSelected(true);
            } else if (tipoOutrasDoencas == 0) {
                jRBOutrasSub.setSelected(!true);
            }
            jQualOutrasSub.setText(conecta.rs.getString("QualOutrasSub"));
            jComboBoxCompartilhaCrack.setSelectedItem(conecta.rs.getString("CompartilhaCrack"));
            tipoSudorese = conecta.rs.getInt("Sudorese");
            if (tipoSudorese == 1) {
                jRBSudorese.setSelected(true);
            } else if (tipoSudorese == 0) {
                jRBSudorese.setSelected(!true);
            }
            tipoTremores = conecta.rs.getInt("Tremores");
            if (tipoTremores == 1) {
                jRBTremores.setSelected(true);
            } else if (tipoTremores == 0) {
                jRBTremores.setSelected(!true);
            }
            tipoFissura = conecta.rs.getInt("Fissura");
            if (tipoFissura == 1) {
                jRBFissura.setSelected(true);
            } else if (tipoFissura == 0) {
                jRBFissura.setSelected(!true);
            }
            tipoBocaSeca = conecta.rs.getInt("BocaSeca");
            if (tipoBocaSeca == 1) {
                jRBBoca.setSelected(true);
            } else if (tipoBocaSeca == 0) {
                jRBBoca.setSelected(!true);
            }
            tipoNauseas = conecta.rs.getInt("Nausea");
            if (tipoNauseas == 1) {
                jRBNausea.setSelected(true);
            } else if (tipoNauseas == 0) {
                jRBNausea.setSelected(true);
            }
            tipoDesejo = conecta.rs.getInt("Desejo");
            if (tipoDesejo == 1) {
                jRBDesejo.setSelected(true);
            } else if (tipoDesejo == 0) {
                jRBDesejo.setSelected(!true);
            }
            tipoNaoconseguir = conecta.rs.getInt("NaoPara");
            if (tipoNaoconseguir == 1) {
                jRBNaoPara.setSelected(true);
            } else if (tipoNaoconseguir == 0) {
                jRBNaoPara.setSelected(!true);
            }
            tipoAumentoTolerancia = conecta.rs.getInt("AumentoTolerancia");
            if (tipoAumentoTolerancia == 1) {
                jRBAumentoTolerancia.setSelected(true);
            } else if (tipoAumentoTolerancia == 0) {
                jRBAumentoTolerancia.setSelected(!true);
            }
            jComboBoxCAPSAD.setSelectedItem(conecta.rs.getString("CAPSAD"));
            jDataCAPSAD.setDate(conecta.rs.getDate("DataCAPSAD"));
            jComboBoxEsteveInternado.setSelectedItem(conecta.rs.getString("EsteveInternado"));
            jQuantoTempoInternado.setText(conecta.rs.getString("QuantoTempoInternado"));
            jComboBoxAceitaDanos.setSelectedItem(conecta.rs.getString("AceitaDanos"));
            jComboBoxSaudeBucal.setSelectedItem(conecta.rs.getString("SaudeBucal"));
            jComboBoxNecessitaAtende.setSelectedItem(conecta.rs.getString("NecessitaAtende"));
            tipoEnfermagem = conecta.rs.getInt("Enfermagem");
            if (tipoEnfermagem == 1) {
                jRBEnfermagem.setSelected(true);
            } else if (tipoEnfermagem == 0) {
                jRBEnfermagem.setSelected(!true);
            }
            tipoMedico = conecta.rs.getInt("Medico");
            if (tipoMedico == 1) {
                jRBMedico.setSelected(true);
            } else if (tipoMedico == 0) {
                jRBMedico.setSelected(!true);
            }
            tipoPsiquiatrico = conecta.rs.getInt("PsiquiatricoN");
            if (tipoPsiquiatrico == 1) {
                jRBPsiquiatrico.setSelected(true);
            } else if (tipoPsiquiatrico == 0) {
                jRBPsiquiatrico.setSelected(!true);
            }
            tipoPsicologico = conecta.rs.getInt("Psicologico");
            if (tipoPsicologico == 1) {
                jRBPsicologico.setSelected(true);
            } else if (tipoPsicologico == 0) {
                jRBPsicologico.setSelected(!true);
            }
            jComboBoxPessoasQuimica.setSelectedItem(conecta.rs.getString("PessoasQuimica"));
            jQuemNecessita.setText(conecta.rs.getString("QuemNecessita"));
            if (codigoSS3 != 0) {
                jBtNovoSS3.setEnabled(true);
                jBtAlterarSS3.setEnabled(true);
                jBtExcluirSS3.setEnabled(true);
                jBtSalvarSS3.setEnabled(!true);
                jBtCancelarSS3.setEnabled(!true);
                jBtAuditoriaSS3.setEnabled(true);
            }
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarCodigoSS3() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM FICHA_CADASTRO_PAI_DS "
                    + "WHERE IdPai='" + jCodigoPAI.getText() + "' "
                    + "AND IdInternoCrc='" + jIdInternoPAI.getText() + "'");
            conecta.rs.first();
            codigoPaiSS3 = conecta.rs.getInt("IdPai");
            codigoInternoSS3 = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void NovoEAPI1() {
        jTextoPSP.setText("");
        jTextoCEDEGEP.setText("");
        jTextoCRASCREAS.setText("");
        //
        jTextoPSP.setEnabled(true);
        jTextoCEDEGEP.setEnabled(true);
        jTextoCRASCREAS.setEnabled(true);
        //
        jBtSalvarEAPI1.setEnabled(true);
        jBtCancelarEAPI1.setEnabled(true);
    }

    public void AlterarEAPI1() {
        jTextoPSP.setEnabled(true);
        jTextoCEDEGEP.setEnabled(true);
        jTextoCRASCREAS.setEnabled(true);
        //
        jBtSalvarEAPI1.setEnabled(true);
        jBtCancelarEAPI1.setEnabled(true);
    }

    public void ExcluirEAPI1() {
        jTextoPSP.setText("");
        jTextoCEDEGEP.setText("");
        jTextoCRASCREAS.setText("");
        //
        jTextoPSP.setEnabled(!true);
        jTextoCEDEGEP.setEnabled(!true);
        jTextoCRASCREAS.setEnabled(!true);
        //
        jBtNovoEAPI1.setEnabled(true);
        jBtAlterarEAPI1.setEnabled(!true);
        jBtExcluirEAPI1.setEnabled(!true);
        jBtSalvarEAPI1.setEnabled(!true);
        jBtCancelarEAPI1.setEnabled(!true);
        jBtAuditoriaEAPI1.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        //
        jBtNovoDJ.setEnabled(true);
        jBtNovoEAPI2.setEnabled(true);
        jBtNovoPSI.setEnabled(true);
        jBtNovoTO.setEnabled(true);
        jBtNovoSS.setEnabled(true);
        jBtNovoSS3.setEnabled(true);
    }

    public void SalvarEAPI1() {
        jTextoPSP.setEnabled(!true);
        jTextoCEDEGEP.setEnabled(!true);
        jTextoCRASCREAS.setEnabled(!true);
        //
        jBtNovoEAPI1.setEnabled(true);
        jBtAlterarEAPI1.setEnabled(true);
        jBtExcluirEAPI1.setEnabled(true);
        jBtSalvarEAPI1.setEnabled(!true);
        jBtCancelarEAPI1.setEnabled(!true);
        jBtAuditoriaEAPI1.setEnabled(true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        //
        jBtNovoDJ.setEnabled(true);
        jBtNovoEAPI2.setEnabled(true);
        jBtNovoPSI.setEnabled(true);
        jBtNovoTO.setEnabled(true);
        jBtNovoSS.setEnabled(true);
        jBtNovoSS3.setEnabled(true);
        jBtNovaEvolucao.setEnabled(true);
    }

    public void CancelarEAPI1() {
        jTextoPSP.setText("");
        jTextoCEDEGEP.setText("");
        jTextoCRASCREAS.setText("");
        //
        jTextoPSP.setEnabled(!true);
        jTextoCEDEGEP.setEnabled(!true);
        jTextoCRASCREAS.setEnabled(!true);
        //
        jBtNovoEAPI1.setEnabled(true);
        jBtAlterarEAPI1.setEnabled(!true);
        jBtExcluirEAPI1.setEnabled(!true);
        jBtSalvarEAPI1.setEnabled(!true);
        jBtCancelarEAPI1.setEnabled(!true);
        jBtAuditoriaEAPI1.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        //
        jBtNovoDJ.setEnabled(true);
        jBtNovoEAPI2.setEnabled(true);
        jBtNovoPSI.setEnabled(true);
        jBtNovoTO.setEnabled(true);
        jBtNovoSS.setEnabled(true);
        jBtNovoSS3.setEnabled(true);
        //
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM FICHA_CADASTRO_PAI_EAPI1 "
                    + "INNER JOIN FICHA_CADASTRO_PAI_PSICOSOCIAL "
                    + "ON FICHA_CADASTRO_PAI_EAPI1.IdPai=FICHA_CADASTRO_PAI_PSICOSOCIAL.IdPai "
                    + "WHERE FICHA_CADASTRO_PAI_EAPI1.IdPai='" + jCodigoPAI.getText() + "'");
            conecta.rs.first();
            codigoEAPI = conecta.rs.getInt("IdEAP1");
            jTextoPSP.setText(conecta.rs.getString("PSP"));
            jTextoCEDEGEP.setText(conecta.rs.getString("CEDEGEP"));
            jTextoCRASCREAS.setText(conecta.rs.getString("CRASCREAS"));
            //
            if (codigoEAPI != 0) {
                jBtNovoEAPI1.setEnabled(true);
                jBtAlterarEAPI1.setEnabled(true);
                jBtExcluirEAPI1.setEnabled(true);
                jBtSalvarEAPI1.setEnabled(!true);
                jBtCancelarEAPI1.setEnabled(!true);
                jBtAuditoriaEAPI1.setEnabled(true);
            }
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarCodigoEAPI1() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM FICHA_CADASTRO_PAI_EAPI1 "
                    + "WHERE IdPai='" + jCodigoPAI.getText() + "' "
                    + "AND IdInternoCrc='" + jIdInternoPAI.getText() + "'");
            conecta.rs.first();
            codigoPaiEAPI = conecta.rs.getInt("IdPai");
            codigoInternoDJ = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void buscarCodigoEAPI1() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM FICHA_CADASTRO_PAI_EAPI1 ");
            conecta.rs.last();
            codigoEAPI = conecta.rs.getInt("IdEAP1");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível obter o código do registro.\nERRO: " + e);
        }
        conecta.desconecta();
    }

    public void NovoEAPI2() {
        jTextoCEDEGEP.setText("");
        jTextoCRASCREAS.setText("");
        jTextoASSISTENCIA.setText("");
        jTextoDOCUMENTOCIVIL.setText("");
        jTextEAPI2PAI.setText("");
        jTecnicoServicoSocial.setText("");
        jTecnicoPsicologico.setText("");
        //
        jTextoCEDEGEP.setEnabled(true);
        jTextoCRASCREAS.setEnabled(true);
        jTextoASSISTENCIA.setEnabled(true);
        jTextEAPI2PAI.setEnabled(true);
        jTextoDOCUMENTOCIVIL.setEnabled(true);
        //
        jBtSalvarEAPI2.setEnabled(true);
        jBtCancelarEAPI2.setEnabled(true);
        jBtAssistente.setEnabled(true);
        jBtPsicologo.setEnabled(true);
    }

    public void AlterarEAPI2() {
        jTextoCEDEGEP.setEnabled(true);
        jTextoCRASCREAS.setEnabled(true);
        jTextoASSISTENCIA.setEnabled(true);
        jTextoDOCUMENTOCIVIL.setEnabled(true);
        jTextEAPI2PAI.setEnabled(true);
        //
        jBtSalvarEAPI2.setEnabled(true);
        jBtCancelarEAPI2.setEnabled(true);
        jBtAssistente.setEnabled(true);
        jBtPsicologo.setEnabled(true);
    }

    public void ExcluirEAPI2() {
        jTextoCEDEGEP.setText("");
        jTextoCRASCREAS.setText("");
        jTextoASSISTENCIA.setText("");
        jTextoDOCUMENTOCIVIL.setText("");
        jTextEAPI2PAI.setText("");
        //
        jTextoCEDEGEP.setEnabled(!true);
        jTextoCRASCREAS.setEnabled(!true);
        jTextoASSISTENCIA.setEnabled(!true);
        jTextoDOCUMENTOCIVIL.setEnabled(!true);
        jTextEAPI2PAI.setEnabled(!true);
        //
        jBtNovoEAPI2.setEnabled(true);
        // MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
        //
        jBtNovaEvolucao.setEnabled(true);
        jBtNovoEAPI1.setEnabled(true);
        jBtNovoSS3.setEnabled(true);
        jBtNovoDJ.setEnabled(true);
        jBtNovoPSI.setEnabled(true);
        jBtNovoTO.setEnabled(true);
        jBtNovoSS.setEnabled(true);
        jBtAssistente.setEnabled(!true);
        jBtPsicologo.setEnabled(!true);
    }

    public void SalvarEAPI2() {
        jTextoCEDEGEP.setEnabled(!true);
        jTextoCRASCREAS.setEnabled(!true);
        jTextoASSISTENCIA.setEnabled(!true);
        jTextoDOCUMENTOCIVIL.setEnabled(!true);
        jTextEAPI2PAI.setEnabled(!true);
        //
        jBtNovoEAPI2.setEnabled(true);
        jBtAlterarEAPI2.setEnabled(true);
        jBtExcluirEAPI2.setEnabled(true);
        jBtSalvarEAPI2.setEnabled(!true);
        jBtCancelarEAPI2.setEnabled(!true);
        jBtAuditoriaEAPI2.setEnabled(true);
        // MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
        //
        jBtNovaEvolucao.setEnabled(true);
        jBtNovoEAPI1.setEnabled(true);
        jBtNovoSS3.setEnabled(true);
        jBtNovoDJ.setEnabled(true);
        jBtNovoPSI.setEnabled(true);
        jBtNovoTO.setEnabled(true);
        jBtNovoSS.setEnabled(true);
        jBtAssistente.setEnabled(!true);
        jBtPsicologo.setEnabled(!true);
    }

    public void CancelarEAPI2() {
        jTextoCEDEGEP.setText("");
        jTextoCRASCREAS.setText("");
        jTextoASSISTENCIA.setText("");
        jTextoDOCUMENTOCIVIL.setText("");
        jTextEAPI2PAI.setText("");
        //
        jTextoCEDEGEP.setEnabled(!true);
        jTextoCRASCREAS.setEnabled(!true);
        jTextoASSISTENCIA.setEnabled(!true);
        jTextoDOCUMENTOCIVIL.setEnabled(!true);
        jTextEAPI2PAI.setEnabled(!true);
        //
        jBtNovoEAPI2.setEnabled(true);
        jBtAlterarEAPI2.setEnabled(true);
        jBtExcluirEAPI2.setEnabled(true);
        jBtSalvarEAPI2.setEnabled(!true);
        jBtCancelarEAPI2.setEnabled(!true);
        jBtAuditoriaEAPI2.setEnabled(true);
        // MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
        //
        jBtNovaEvolucao.setEnabled(true);
        jBtNovoEAPI1.setEnabled(true);
        jBtNovoSS3.setEnabled(true);
        jBtNovoDJ.setEnabled(true);
        jBtNovoPSI.setEnabled(true);
        jBtNovoTO.setEnabled(true);
        jBtNovoSS.setEnabled(true);
        jBtAssistente.setEnabled(!true);
        jBtPsicologo.setEnabled(!true);
        //
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM FICHA_CADASTRO_PAI_EAPI2 "
                    + "INNER JOIN FICHA_CADASTRO_PAI_PSICOSOCIAL "
                    + "ON FICHA_CADASTRO_PAI_EAPI2.IdPai=FICHA_CADASTRO_PAI_PSICOSOCIAL.IdPai "
                    + "WHERE FICHA_CADASTRO_PAI_EAPI2.IdPai='" + jCodigoPAI.getText() + "'");
            conecta.rs.first();
            codigoEAPI2 = conecta.rs.getInt("IdEAPI2");
            jTextoASSISTENCIA.setText(conecta.rs.getString("ASSISTENCIA"));
            jTextoDOCUMENTOCIVIL.setText(conecta.rs.getString("DOCUMENTOCIVIL"));
            jTextEAPI2PAI.setText(conecta.rs.getString("EAPI2PAI"));
            jTecnicoServicoSocial.setText(conecta.rs.getString("TecnicoServicoSocial"));
            jTecnicoPsicologico.setText(conecta.rs.getString("TecnicoPsicologico"));
            //
            if (codigoEAPI2 != 0) {
                jBtNovoEAPI2.setEnabled(true);
                jBtAlterarEAPI2.setEnabled(true);
                jBtExcluirEAPI2.setEnabled(true);
                jBtSalvarEAPI2.setEnabled(!true);
                jBtCancelarEAPI2.setEnabled(!true);
                jBtAuditoriaEAPI2.setEnabled(true);
            }
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarCodigoEAPI2() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM FICHA_CADASTRO_PAI_EAPI2 "
                    + "WHERE IdPai='" + jCodigoPAI.getText() + "' "
                    + "AND IdInternoCrc='" + jIdInternoPAI.getText() + "'");
            conecta.rs.first();
            codigoPaiEAPI2 = conecta.rs.getInt("IdPai");
            codigoInternoEAPI2 = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void buscarCodigoEAPI2() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM FICHA_CADASTRO_PAI_EAPI2 ");
            conecta.rs.last();
            codigoEAPI2 = conecta.rs.getInt("IdEAPI2");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível obter o código do registro.\nERRO: " + e);
        }
        conecta.desconecta();
    }

    public void NovaEvolucao() {
        jIdEvolucao.setText("");
        jDataEvolucao.setCalendar(Calendar.getInstance());
        jNomeInternoEvolucaoPAI.setText(jNomeInternoPAI.getText());
        jTextoEvolucao.setText("");
        //
        jDataEvolucao.setEnabled(true);
        jTextoEvolucao.setEnabled(true);
        //
        jBtNovaEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(true);
        jBtCancelarEvolucao.setEnabled(true);
        jBtAuditoriaEvolucao.setEnabled(!true);
    }

    public void AlterarEvolucao() {
        jDataEvolucao.setEnabled(true);
        jTextoEvolucao.setEnabled(true);
        //
        jBtNovaEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(true);
        jBtCancelarEvolucao.setEnabled(true);
        jBtAuditoriaEvolucao.setEnabled(!true);
    }

    public void ExcluirEvolucao() {
        jIdEvolucao.setText("");
        jDataEvolucao.setDate(null);
        jNomeInternoEvolucaoPAI.setText("");
        jTextoEvolucao.setText("");
        //
        jDataEvolucao.setEnabled(true);
        jTextoEvolucao.setEnabled(true);
        //
        jBtNovaEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(true);
        jBtCancelarEvolucao.setEnabled(true);
        jBtAuditoriaEvolucao.setEnabled(!true);
    }

    public void SalvarEvolucao() {
        jDataEvolucao.setEnabled(!true);
        jTextoEvolucao.setEnabled(!true);
        //
        jBtNovaEvolucao.setEnabled(true);
        jBtAlterarEvolucao.setEnabled(true);
        jBtExcluirEvolucao.setEnabled(true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(true);
    }

    public void CancelarEvolucao() {
        if (jIdEvolucao.getText().equals("")) {
            jIdEvolucao.setText("");
            jDataEvolucao.setDate(null);
            jNomeInternoEvolucaoPAI.setText("");
            jTextoEvolucao.setText("");
            //
            jDataEvolucao.setEnabled(!true);
            jTextoEvolucao.setEnabled(!true);
            //
            jBtNovaEvolucao.setEnabled(true);
            jBtAlterarEvolucao.setEnabled(!true);
            jBtExcluirEvolucao.setEnabled(!true);
            jBtSalvarEvolucao.setEnabled(!true);
            jBtCancelarEvolucao.setEnabled(!true);
            jBtAuditoriaEvolucao.setEnabled(!true);
        } else {
            jDataEvolucao.setEnabled(!true);
            jTextoEvolucao.setEnabled(!true);
            //
            jBtNovaEvolucao.setEnabled(true);
            jBtAlterarEvolucao.setEnabled(true);
            jBtExcluirEvolucao.setEnabled(true);
            jBtSalvarEvolucao.setEnabled(!true);
            jBtCancelarEvolucao.setEnabled(!true);
            jBtAuditoriaEvolucao.setEnabled(true);
        }
    }

    public void buscarCodigoEvolucao() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM EVOLUCAO_PAI ");
            conecta.rs.last();
            jIdEvolucao.setText(conecta.rs.getString("IdEvolucao"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível obter código do registro.");
        }
        conecta.desconecta();
    }

    public void verificarRegistrosTodasAbas() {
        codigoSS1 = 0;
        codTeraPed = 0;
        codigoPSI = 0;
        codigoDJ = 0;
        codigoSS3 = 0;
        codigoEAPI = 0;
        codigoEAPI2 = 0;
        conecta.abrirConexao();
        // C.C.G.F            
        try {
            conecta.executaSQL("SELECT * FROM FICHA_CADASTRO_PAI_CCGF "
                    + "INNER JOIN FICHA_CADASTRO_PAI_PSICOSOCIAL "
                    + "ON FICHA_CADASTRO_PAI_CCGF.IdPai=FICHA_CADASTRO_PAI_PSICOSOCIAL.IdPai "
                    + "WHERE FICHA_CADASTRO_PAI_CCGF.IdPai='" + jCodigoPAI.getText() + "'");
            conecta.rs.first();
            codigoSS1 = conecta.rs.getInt("IdCCGF");
        } catch (Exception e) {
        }
        // D.E.M.E.        
        try {
            conecta.executaSQL("SELECT * FROM FICHA_CADASTRO_PAI_DEME "
                    + "INNER JOIN FICHA_CADASTRO_PAI_PSICOSOCIAL "
                    + "ON FICHA_CADASTRO_PAI_DEME.IdPai=FICHA_CADASTRO_PAI_PSICOSOCIAL.IdPai "
                    + "WHERE FICHA_CADASTRO_PAI_DEME.IdPai='" + jCodigoPAI.getText() + "'");
            conecta.rs.first();
            codTeraPed = conecta.rs.getInt("IdDEME");
            if (codTeraPed != 0) {
                jBtNovoTO.setEnabled(true);
                jBtAlterarTO.setEnabled(true);
                jBtExcluirTO.setEnabled(true);
                jBtSalvarTO.setEnabled(!true);
                jBtCancelarTO.setEnabled(!true);
                jBtAuditoriaTO.setEnabled(true);
            }
        } catch (Exception e) {
        }
        // D.P.T.L.
        try {
            conecta.executaSQL("SELECT * FROM FICHA_CADASTRO_PAI_DPTL "
                    + "INNER JOIN FICHA_CADASTRO_PAI_PSICOSOCIAL "
                    + "ON FICHA_CADASTRO_PAI_DPTL.IdPai=FICHA_CADASTRO_PAI_PSICOSOCIAL.IdPai "
                    + "WHERE FICHA_CADASTRO_PAI_DPTL.IdPai='" + jCodigoPAI.getText() + "'");
            conecta.rs.first();
            codigoPSI = conecta.rs.getInt("IdDPTL");
            if (codigoPSI != 0) {
                jBtNovoPSI.setEnabled(true);
                jBtAlterarPSI.setEnabled(true);
                jBtExcluirPSI.setEnabled(true);
                jBtSalvarPSI.setEnabled(!true);
                jBtCancelarPSI.setEnabled(!true);
                jBtAuditoriaPSI.setEnabled(true);
            }
        } catch (Exception e) {
        }
        //D.J.        
        try {
            conecta.executaSQL("SELECT * FROM FICHA_CADASTRO_PAI_DJ "
                    + "INNER JOIN FICHA_CADASTRO_PAI_PSICOSOCIAL "
                    + "ON FICHA_CADASTRO_PAI_DJ.IdPai=FICHA_CADASTRO_PAI_PSICOSOCIAL.IdPai "
                    + "WHERE FICHA_CADASTRO_PAI_DJ.IdPai='" + jCodigoPAI.getText() + "'");
            conecta.rs.first();
            codigoDJ = conecta.rs.getInt("IdDJ");
            if (codigoDJ != 0) {
                jBtNovoDJ.setEnabled(true);
                jBtAlterarDJ.setEnabled(true);
                jBtExcluirDJ.setEnabled(true);
                jBtSalvarDJ.setEnabled(!true);
                jBtCancelarDJ.setEnabled(!true);
                jBtAuditoriaDJ.setEnabled(true);
            }
        } catch (Exception e) {
        }
        // D.S.
        try {
            conecta.executaSQL("SELECT * FROM FICHA_CADASTRO_PAI_DS "
                    + "INNER JOIN FICHA_CADASTRO_PAI_PSICOSOCIAL "
                    + "ON FICHA_CADASTRO_PAI_DS.IdPai=FICHA_CADASTRO_PAI_PSICOSOCIAL.IdPai "
                    + "WHERE FICHA_CADASTRO_PAI_DS.IdPai='" + jCodigoPAI.getText() + "'");
            conecta.rs.first();
            codigoSS3 = conecta.rs.getInt("IdDS");
            if (codigoSS3 != 0) {
                jBtNovoSS3.setEnabled(true);
                jBtAlterarSS3.setEnabled(true);
                jBtExcluirSS3.setEnabled(true);
                jBtSalvarSS3.setEnabled(!true);
                jBtCancelarSS3.setEnabled(!true);
                jBtAuditoriaSS3.setEnabled(true);
            }
        } catch (Exception e) {
        }
        // EAPI-1
        try {
            conecta.executaSQL("SELECT * FROM FICHA_CADASTRO_PAI_EAPI1 "
                    + "INNER JOIN FICHA_CADASTRO_PAI_PSICOSOCIAL "
                    + "ON FICHA_CADASTRO_PAI_EAPI1.IdPai=FICHA_CADASTRO_PAI_PSICOSOCIAL.IdPai "
                    + "WHERE FICHA_CADASTRO_PAI_EAPI1.IdPai='" + jCodigoPAI.getText() + "'");
            conecta.rs.first();
            codigoEAPI = conecta.rs.getInt("IdEAP1");
            if (codigoEAPI != 0) {
                jBtNovoEAPI1.setEnabled(true);
                jBtAlterarEAPI1.setEnabled(true);
                jBtExcluirEAPI1.setEnabled(true);
                jBtSalvarEAPI1.setEnabled(!true);
                jBtCancelarEAPI1.setEnabled(!true);
                jBtAuditoriaEAPI1.setEnabled(true);
            }
        } catch (Exception e) {
        }
        //E.A.P.I.2            
        try {
            conecta.executaSQL("SELECT * FROM FICHA_CADASTRO_PAI_EAPI2 "
                    + "INNER JOIN FICHA_CADASTRO_PAI_PSICOSOCIAL "
                    + "ON FICHA_CADASTRO_PAI_EAPI2.IdPai=FICHA_CADASTRO_PAI_PSICOSOCIAL.IdPai "
                    + "WHERE FICHA_CADASTRO_PAI_EAPI2.IdPai='" + jCodigoPAI.getText() + "'");
            conecta.rs.first();
            codigoEAPI2 = conecta.rs.getInt("IdEAPI2");
            if (codigoEAPI2 != 0) {
                jBtNovoEAPI2.setEnabled(true);
                jBtAlterarEAPI2.setEnabled(true);
                jBtExcluirEAPI2.setEnabled(true);
                jBtSalvarEAPI2.setEnabled(!true);
                jBtCancelarEAPI2.setEnabled(!true);
                jBtAuditoriaEAPI2.setEnabled(true);
            }
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarVisitasFamiliarIntima() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM FICHA_CADASTRO_PAI_CCGF_VF WHERE IdPai='" + jCodigoPAI.getText() + "'");
            conecta.rs.first();
            codigoVF = conecta.rs.getInt("IdPai");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM FICHA_CADASTRO_PAI_CCGF_VF1 WHERE IdPai='" + jCodigoPAI.getText() + "'");
            conecta.rs.first();
            codigoVF1 = conecta.rs.getInt("IdPai");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM FICHA_CADASTRO_PAI_CCGF_VF2 WHERE IdPai='" + jCodigoPAI.getText() + "'");
            conecta.rs.first();
            codigoVF2 = conecta.rs.getInt("IdPai");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void preencherTabelaAtendentimentoPAI(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Nome do Interno"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1;
                // Formatar a data Entrada
                dataPAI = conecta.rs.getString("DataPai");
                String diae = dataPAI.substring(8, 10);
                String mese = dataPAI.substring(5, 7);
                String anoe = dataPAI.substring(0, 4);
                dataPAI = diae + "/" + mese + "/" + anoe;
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdPai"), dataPAI, conecta.rs.getString("StatusPai"), conecta.rs.getString("NomeInternoCrc")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPAI.setModel(modelo);
        jTabelaPAI.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaPAI.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPAI.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaPAI.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPAI.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaPAI.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPAI.getColumnModel().getColumn(3).setPreferredWidth(270);
        jTabelaPAI.getColumnModel().getColumn(3).setResizable(false);
        jTabelaPAI.getTableHeader().setReorderingAllowed(false);
        jTabelaPAI.setAutoResizeMode(jTabelaPAI.AUTO_RESIZE_OFF);
        jTabelaPAI.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCelulasTabelaPAISocial();
        conecta.desconecta();
    }

    public void alinharCelulasTabelaPAISocial() {
        //
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaPAI.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaPAI.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaPAI.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }

    public void limparTabelaPAISocial() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Nome do Interno"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPAI.setModel(modelo);
        jTabelaPAI.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaPAI.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPAI.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaPAI.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPAI.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaPAI.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPAI.getColumnModel().getColumn(3).setPreferredWidth(270);
        jTabelaPAI.getColumnModel().getColumn(3).setResizable(false);
        jTabelaPAI.getTableHeader().setReorderingAllowed(false);
        jTabelaPAI.setAutoResizeMode(jTabelaPAI.AUTO_RESIZE_OFF);
        jTabelaPAI.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void preencherTabelaFamiliar(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome do Familiar", "Vinculo", "Idade", "Ocupação"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdVF"), conecta.rs.getString("NomeFamiliar"), conecta.rs.getString("Vinculo"), conecta.rs.getString("Idade"), conecta.rs.getString("Ocupacao")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaFamiliarPAI.setModel(modelo);
        jTabelaFamiliarPAI.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaFamiliarPAI.getColumnModel().getColumn(0).setResizable(false);
        jTabelaFamiliarPAI.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTabelaFamiliarPAI.getColumnModel().getColumn(1).setResizable(false);
        jTabelaFamiliarPAI.getColumnModel().getColumn(2).setPreferredWidth(120);
        jTabelaFamiliarPAI.getColumnModel().getColumn(2).setResizable(false);
        jTabelaFamiliarPAI.getColumnModel().getColumn(3).setPreferredWidth(40);
        jTabelaFamiliarPAI.getColumnModel().getColumn(3).setResizable(false);
        jTabelaFamiliarPAI.getColumnModel().getColumn(4).setPreferredWidth(140);
        jTabelaFamiliarPAI.getColumnModel().getColumn(4).setResizable(false);
        jTabelaFamiliarPAI.getTableHeader().setReorderingAllowed(false);
        jTabelaFamiliarPAI.setAutoResizeMode(jTabelaFamiliarPAI.AUTO_RESIZE_OFF);
        jTabelaFamiliarPAI.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaFamiliar();
        conecta.desconecta();
    }

    public void limparTabelaFamiliar() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome do Familiar", "Vinculo", "Idade", "Ocupação"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaFamiliarPAI.setModel(modelo);
        jTabelaFamiliarPAI.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaFamiliarPAI.getColumnModel().getColumn(0).setResizable(false);
        jTabelaFamiliarPAI.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTabelaFamiliarPAI.getColumnModel().getColumn(1).setResizable(false);
        jTabelaFamiliarPAI.getColumnModel().getColumn(2).setPreferredWidth(120);
        jTabelaFamiliarPAI.getColumnModel().getColumn(2).setResizable(false);
        jTabelaFamiliarPAI.getColumnModel().getColumn(3).setPreferredWidth(40);
        jTabelaFamiliarPAI.getColumnModel().getColumn(3).setResizable(false);
        jTabelaFamiliarPAI.getColumnModel().getColumn(4).setPreferredWidth(140);
        jTabelaFamiliarPAI.getColumnModel().getColumn(4).setResizable(false);
        jTabelaFamiliarPAI.getTableHeader().setReorderingAllowed(false);
        jTabelaFamiliarPAI.setAutoResizeMode(jTabelaFamiliarPAI.AUTO_RESIZE_OFF);
        jTabelaFamiliarPAI.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabelaFamiliar() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaFamiliarPAI.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaFamiliarPAI.getColumnModel().getColumn(3).setCellRenderer(centralizado);
    }

    public void preencherTabelaVisitas(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código", "Nome da Visita", "Vinculo", "Idade", "Ocupação"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdVF1"), conecta.rs.getInt("IdVisita"), conecta.rs.getString("NomeVisita"), conecta.rs.getString("ParentescoVisita"), conecta.rs.getString("Idade"), conecta.rs.getString("Ocupacao")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaVisitas.setModel(modelo);
        jTabelaVisitas.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaVisitas.getColumnModel().getColumn(0).setResizable(false);
        jTabelaVisitas.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTabelaVisitas.getColumnModel().getColumn(1).setResizable(false);
        jTabelaVisitas.getColumnModel().getColumn(2).setPreferredWidth(250);
        jTabelaVisitas.getColumnModel().getColumn(2).setResizable(false);
        jTabelaVisitas.getColumnModel().getColumn(3).setPreferredWidth(120);
        jTabelaVisitas.getColumnModel().getColumn(3).setResizable(false);
        jTabelaVisitas.getColumnModel().getColumn(4).setPreferredWidth(40);
        jTabelaVisitas.getColumnModel().getColumn(4).setResizable(false);
        jTabelaVisitas.getColumnModel().getColumn(5).setPreferredWidth(140);
        jTabelaVisitas.getColumnModel().getColumn(5).setResizable(false);
        jTabelaVisitas.getTableHeader().setReorderingAllowed(false);
        jTabelaVisitas.setAutoResizeMode(jTabelaVisitas.AUTO_RESIZE_OFF);
        jTabelaVisitas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaVisitas();
        conecta.desconecta();
    }

    public void limparTabelaVisitas() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código", "Nome da Visita", "Vinculo", "Idade", "Ocupação"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaVisitas.setModel(modelo);
        jTabelaVisitas.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaVisitas.getColumnModel().getColumn(0).setResizable(false);
        jTabelaVisitas.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTabelaVisitas.getColumnModel().getColumn(1).setResizable(false);
        jTabelaVisitas.getColumnModel().getColumn(2).setPreferredWidth(250);
        jTabelaVisitas.getColumnModel().getColumn(2).setResizable(false);
        jTabelaVisitas.getColumnModel().getColumn(3).setPreferredWidth(120);
        jTabelaVisitas.getColumnModel().getColumn(3).setResizable(false);
        jTabelaVisitas.getColumnModel().getColumn(4).setPreferredWidth(40);
        jTabelaVisitas.getColumnModel().getColumn(4).setResizable(false);
        jTabelaVisitas.getColumnModel().getColumn(5).setPreferredWidth(140);
        jTabelaVisitas.getColumnModel().getColumn(5).setResizable(false);
        jTabelaVisitas.getTableHeader().setReorderingAllowed(false);
        jTabelaVisitas.setAutoResizeMode(jTabelaVisitas.AUTO_RESIZE_OFF);
        jTabelaVisitas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabelaVisitas() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaVisitas.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaVisitas.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaVisitas.getColumnModel().getColumn(4).setCellRenderer(centralizado);
    }

    public void preencherTabelaVisitasIntimas(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código", "Nome da Visita", "Vinculo", "Idade", "Ocupação"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdVF2"), conecta.rs.getInt("IdVisita"), conecta.rs.getString("NomeVisita"), conecta.rs.getString("ParentescoVisita"), conecta.rs.getString("Idade"), conecta.rs.getString("Ocupacao")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaVisitasIntimas.setModel(modelo);
        jTabelaVisitasIntimas.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaVisitasIntimas.getColumnModel().getColumn(0).setResizable(false);
        jTabelaVisitasIntimas.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTabelaVisitasIntimas.getColumnModel().getColumn(1).setResizable(false);
        jTabelaVisitasIntimas.getColumnModel().getColumn(2).setPreferredWidth(250);
        jTabelaVisitasIntimas.getColumnModel().getColumn(2).setResizable(false);
        jTabelaVisitasIntimas.getColumnModel().getColumn(3).setPreferredWidth(120);
        jTabelaVisitasIntimas.getColumnModel().getColumn(3).setResizable(false);
        jTabelaVisitasIntimas.getColumnModel().getColumn(4).setPreferredWidth(40);
        jTabelaVisitasIntimas.getColumnModel().getColumn(4).setResizable(false);
        jTabelaVisitasIntimas.getColumnModel().getColumn(5).setPreferredWidth(140);
        jTabelaVisitasIntimas.getColumnModel().getColumn(5).setResizable(false);
        jTabelaVisitasIntimas.getTableHeader().setReorderingAllowed(false);
        jTabelaVisitasIntimas.setAutoResizeMode(jTabelaVisitasIntimas.AUTO_RESIZE_OFF);
        jTabelaVisitasIntimas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaVisitasIntimas();
        conecta.desconecta();
    }

    public void limparTabelaVisitasIntimas() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código", "Nome da Visita", "Vinculo", "Idade", "Ocupação"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaVisitasIntimas.setModel(modelo);
        jTabelaVisitasIntimas.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaVisitasIntimas.getColumnModel().getColumn(0).setResizable(false);
        jTabelaVisitasIntimas.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTabelaVisitasIntimas.getColumnModel().getColumn(1).setResizable(false);
        jTabelaVisitasIntimas.getColumnModel().getColumn(2).setPreferredWidth(250);
        jTabelaVisitasIntimas.getColumnModel().getColumn(2).setResizable(false);
        jTabelaVisitasIntimas.getColumnModel().getColumn(3).setPreferredWidth(120);
        jTabelaVisitasIntimas.getColumnModel().getColumn(3).setResizable(false);
        jTabelaVisitasIntimas.getColumnModel().getColumn(4).setPreferredWidth(40);
        jTabelaVisitasIntimas.getColumnModel().getColumn(4).setResizable(false);
        jTabelaVisitasIntimas.getColumnModel().getColumn(5).setPreferredWidth(140);
        jTabelaVisitasIntimas.getColumnModel().getColumn(5).setResizable(false);
        jTabelaVisitasIntimas.getTableHeader().setReorderingAllowed(false);
        jTabelaVisitasIntimas.setAutoResizeMode(jTabelaVisitasIntimas.AUTO_RESIZE_OFF);
        jTabelaVisitasIntimas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabelaVisitasIntimas() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaVisitasIntimas.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaVisitasIntimas.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaVisitasIntimas.getColumnModel().getColumn(4).setCellRenderer(centralizado);
    }

    public void preencherTabelaEvolucao(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Evolução"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1;
                // Formatar a data Entrada
                dataEvolucaoPAI = conecta.rs.getString("DataEvolucao");
                String diae = dataEvolucaoPAI.substring(8, 10);
                String mese = dataEvolucaoPAI.substring(5, 7);
                String anoe = dataEvolucaoPAI.substring(0, 4);
                dataEvolucaoPAI = diae + "/" + mese + "/" + anoe;
                dados.add(new Object[]{conecta.rs.getInt("IdEvolucao"), dataEvolucaoPAI, conecta.rs.getString("TextoEvolucao")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaEvolucaoPAI.setModel(modelo);
        jTabelaEvolucaoPAI.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaEvolucaoPAI.getColumnModel().getColumn(0).setResizable(false);
        jTabelaEvolucaoPAI.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaEvolucaoPAI.getColumnModel().getColumn(1).setResizable(false);
        jTabelaEvolucaoPAI.getColumnModel().getColumn(2).setPreferredWidth(350);
        jTabelaEvolucaoPAI.getColumnModel().getColumn(2).setResizable(false);
        jTabelaEvolucaoPAI.getTableHeader().setReorderingAllowed(false);
        jTabelaEvolucaoPAI.setAutoResizeMode(jTabelaEvolucaoPAI.AUTO_RESIZE_OFF);
        jTabelaEvolucaoPAI.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCelulasTabelaEvolucao();
        conecta.desconecta();
    }

    public void alinharCelulasTabelaEvolucao() {
        //
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaEvolucaoPAI.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaEvolucaoPAI.getColumnModel().getColumn(1).setCellRenderer(centralizado);
    }

    public void limparTabelaTabelaEvolucao() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Evolução"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaEvolucaoPAI.setModel(modelo);
        jTabelaEvolucaoPAI.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaEvolucaoPAI.getColumnModel().getColumn(0).setResizable(false);
        jTabelaEvolucaoPAI.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaEvolucaoPAI.getColumnModel().getColumn(1).setResizable(false);
        jTabelaEvolucaoPAI.getColumnModel().getColumn(2).setPreferredWidth(350);
        jTabelaEvolucaoPAI.getColumnModel().getColumn(2).setResizable(false);
        jTabelaEvolucaoPAI.getTableHeader().setReorderingAllowed(false);
        jTabelaEvolucaoPAI.setAutoResizeMode(jTabelaEvolucaoPAI.AUTO_RESIZE_OFF);
        jTabelaEvolucaoPAI.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jCodigoPAI.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog1() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela1);
        objLogSys.setIdLancMov(Integer.valueOf(jCodigoPAI.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog2() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela2);
        objLogSys.setIdLancMov(Integer.valueOf(jCodigoPAI.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog3() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela3);
        objLogSys.setIdLancMov(Integer.valueOf(jCodigoPAI.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog4() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela4);
        objLogSys.setIdLancMov(Integer.valueOf(jCodigoPAI.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog5() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela5);
        objLogSys.setIdLancMov(Integer.valueOf(jCodigoPAI.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog6() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela6);
        objLogSys.setIdLancMov(Integer.valueOf(jCodigoPAI.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog7() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela7);
        objLogSys.setIdLancMov(Integer.valueOf(jCodigoPAI.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog8() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela8);
        objLogSys.setIdLancMov(Integer.valueOf(jCodigoPAI.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog9() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela9);
        objLogSys.setIdLancMov(Integer.valueOf(jCodigoPAI.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog10() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela10);
        objLogSys.setIdLancMov(Integer.valueOf(jCodigoPAI.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog11() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela11);
        objLogSys.setIdLancMov(Integer.valueOf(jCodigoPAI.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }
}
