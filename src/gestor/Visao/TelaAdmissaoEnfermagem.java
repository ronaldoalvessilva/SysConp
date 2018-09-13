/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleAdmissaoEnfermagem;
import gestor.Controle.ControleAtendimentoFemininoP1;
import gestor.Controle.ControleAtendimentoFemininoP2;
import gestor.Controle.ControleAtendimentoFemininoP3;
import gestor.Controle.ControleAtendimentoFemininoP4;
import gestor.Controle.ControleEvolucaoEnfermagem;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControleMovAdmissaoEnfermeira;
import gestor.Controle.ControleMovEvolucaoEnfermagem;
import gestor.Controle.ControleRegistroAtendimentoInternoBio;
import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.LimiteDigitosAlfa;
import gestor.Dao.LimiteDigitosSoNum;
import gestor.Dao.ModeloTabela;
import gestor.Modelo.AdmissaoEnfermagem;
import gestor.Modelo.AtendimentoFemininoP1;
import gestor.Modelo.AtendimentoFemininoP2;
import gestor.Modelo.AtendimentoFemininoP3;
import gestor.Modelo.AtendimentoFemininoP4;
import gestor.Modelo.EvolucaoEnfermagem;
import gestor.Modelo.LogSistema;
import gestor.Modelo.RegistroAtendimentoInternos;
import static gestor.Visao.TelaLoginSenha.descricaoUnidade;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloEnfermaria.codAlterarENF;
import static gestor.Visao.TelaModuloEnfermaria.codExcluirENF;
import static gestor.Visao.TelaModuloEnfermaria.codGravarENF;
import static gestor.Visao.TelaModuloEnfermaria.codigoGrupoENF;
import static gestor.Visao.TelaModuloEnfermaria.nomeGrupoENF;
import static gestor.Visao.TelaModuloEnfermaria.nomeTelaENF;
import static gestor.Visao.TelaModuloEnfermaria.telaAdmissaoEnfeIntEvolENF;
import static gestor.Visao.TelaModuloEnfermaria.telaAdmissaoEnfeIntManuENF;
import static gestor.Visao.TelaModuloEnfermaria.telaAdmissãoEnfeIntAEFP1ENF;
import static gestor.Visao.TelaModuloEnfermaria.telaAdmissãoEnfeIntAEFP2ENF;
import static gestor.Visao.TelaModuloEnfermaria.telaAdmissãoEnfeIntAEFP3ENF;
import static gestor.Visao.TelaModuloEnfermaria.telaAdmissãoEnfeIntAEFP4ENF;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import java.awt.Color;
import java.awt.Image;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
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
import static gestor.Visao.TelaModuloEnfermaria.codConsultarENF;
import static gestor.Visao.TelaModuloEnfermaria.codigoUserENF;
import static gestor.Visao.TelaModuloEnfermaria.codUserAcessoENF;
import static gestor.Visao.TelaModuloEnfermaria.codigoUserGroupENF;
import static gestor.Visao.TelaModuloEnfermaria.codAbrirENF;
import static gestor.Visao.TelaModuloEnfermaria.codIncluirENF;

/**
 *
 * @author ronaldo
 */
public class TelaAdmissaoEnfermagem extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AdmissaoEnfermagem objAdmEnfermagem = new AdmissaoEnfermagem();
    ControleAdmissaoEnfermagem control = new ControleAdmissaoEnfermagem();
    //
    ControleMovAdmissaoEnfermeira controle = new ControleMovAdmissaoEnfermeira();
    //
    EvolucaoEnfermagem objEvolEnferma = new EvolucaoEnfermagem();
    ControleEvolucaoEnfermagem controleEnfa = new ControleEvolucaoEnfermagem();
    //
    ControleMovEvolucaoEnfermagem controlMovEvolEnfa = new ControleMovEvolucaoEnfermagem();
    //
    AtendimentoFemininoP1 objAfP1 = new AtendimentoFemininoP1();
    ControleAtendimentoFemininoP1 controlAfP1 = new ControleAtendimentoFemininoP1();
    //
    AtendimentoFemininoP2 objAfP2 = new AtendimentoFemininoP2();
    ControleAtendimentoFemininoP2 controlAfP2 = new ControleAtendimentoFemininoP2();
    //
    AtendimentoFemininoP3 objAfP3 = new AtendimentoFemininoP3();
    ControleAtendimentoFemininoP3 controlAfP3 = new ControleAtendimentoFemininoP3();
    //
    AtendimentoFemininoP4 objAfP4 = new AtendimentoFemininoP4();
    ControleAtendimentoFemininoP4 controlAfP4 = new ControleAtendimentoFemininoP4();
    //
    RegistroAtendimentoInternos objRegAtend = new RegistroAtendimentoInternos();
    ControleRegistroAtendimentoInternoBio controlRegAtend = new ControleRegistroAtendimentoInternoBio();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela = "ENFERMARIA:Admissão Enfermeira de Internos:Manutenção";
    String nomeModuloTela2 = "ENFERMARIA:Admissão Enfermeira de Internos:Evolução";
    String nomeModuloTela3 = "ENFERMARIA:Admissão Enfermeira de Internos:AEF-P1";
    String nomeModuloTela4 = "ENFERMARIA:Admissão Enfermeira de Internos:AEF-P2";
    String nomeModuloTela5 = "ENFERMARIA:Admissão Enfermeira de Internos:AEF-P3";
    String nomeModuloTela6 = "ENFERMARIA:Admissão Enfermeira de Internos:AEF-P4";
    String statusMov;
    String horaMov;
    String dataModFinal;
    //
    int acao;
    int flag;
    String dataInicial, dataFinal, dataEntrada, dataEvolu;
    String statusLanc = "ABERTO";
    String deptoTecnico = "ENFERMARIA";
    String caminho;
    // Variaveis para saber qual radiobutton foi selecionado
    int statusEstadoEmocional;
    int statusSonoRepouso;
    int statusNivelConsciencia;
    int statusLocomocao;
    int statusAcuidadeVisual;
    int statusAcuidadeAuditiva;
    int statusFuncaoMotora;
    int statusFalaLinguagem;
    int statusPele;
    int statusMucosa;
    int statusCabelos;
    int statusBoca;
    int statusFuncaoRespiratoria;
    int statusTorax;
    int statusFuncaoIntestinal;
    int statusAbdome;
    int statusFuncaoVesical;
    int statusGenitalia;
    //
    int idItemEvol;
    String codEvolucao;
    String nomeUserRegistro;
    // AEF-P1
    public static int codigoAFP1;
    String codigoAdm1;
    String codigoInternoAdm1;
    // AEF - P2
    public static int codigoAFP2;
    String codigoAdm2;
    String codigoInternoAdm2;
    // AEF - P3
    public static int codigoAFP3;
    String codigoAdm3;
    String codigoInternoAdm3;
    int tipoDrogaCigarro;
    int tipoDrogaPacaia;
    int tipoDrogaMaconha;
    int tipoDrogaCocaina;
    int tipoDrogaCraque;
    int tipoDrogaAlcool;
    int tipoDrogaOutros;
    // AEF - P4
    public static int codigoAFP4;
    String codigoAdm4;
    String codigoInternoAdm4;
    int pesquisaEdemaFace;
    int pesquisaEdemaTronco;
    int pesquisaEdemaMMII;
    int pesquisaEdemaMMSS;
    float pesoGestante;
    float alturaGestante;
    float alturaUterina;
    int count = 0;
    //
    String atendido = "Sim";
    String codigoAtend = "";
    String dataReg = "";
    Date dataRegistro = null;
    String codigoEvol = "";
    String codigoInternoAtend = "";
    String atendeEvol = "Não";
    String opcao = "Não";
    //
    public static int codigoDepartamentoENF = 0;
    public static int codigoDepartamentoENFenf = 0;
    String tipoAtendimentoAdm = "Admissão Enfermagem";
    String tipoAtendimentoEvolENF = "Evolução Enfermagem";
    //    
    String phabilitaEnferemeiro = "";
    //
    String admEvolucao = "Sim";

    /**
     * Creates new form TelaAdmissaoEnfermagem
     */
    public TelaAdmissaoEnfermagem() {
        initComponents();
        formatarCampos();
        corCampos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel94 = new javax.swing.JLabel();
        Locomocao = new javax.swing.ButtonGroup();
        AcuidadeVisual = new javax.swing.ButtonGroup();
        AcuidadeAuditiva = new javax.swing.ButtonGroup();
        FuncaoMotora = new javax.swing.ButtonGroup();
        EstadoEmocional = new javax.swing.ButtonGroup();
        SonoRepouso = new javax.swing.ButtonGroup();
        NivelConciencia = new javax.swing.ButtonGroup();
        FalaLinguagem = new javax.swing.ButtonGroup();
        PeleMucosaHipo = new javax.swing.ButtonGroup();
        Cabelos = new javax.swing.ButtonGroup();
        Boca = new javax.swing.ButtonGroup();
        FuncaoRespiratoria = new javax.swing.ButtonGroup();
        Torax = new javax.swing.ButtonGroup();
        FuncaoIntestinal = new javax.swing.ButtonGroup();
        Abdome = new javax.swing.ButtonGroup();
        FuncaoVesical = new javax.swing.ButtonGroup();
        Genitalia = new javax.swing.ButtonGroup();
        Pele = new javax.swing.ButtonGroup();
        Mucosa = new javax.swing.ButtonGroup();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        Listagem = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jCodigoLanc = new javax.swing.JTextField();
        jBtPesqCodigo = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jNomesInternoPesq = new javax.swing.JTextField();
        jBtPesqNomeInterno = new javax.swing.JButton();
        jCheckBoxTodos = new javax.swing.JCheckBox();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jDataInicial = new com.toedter.calendar.JDateChooser();
        jDataFinal = new com.toedter.calendar.JDateChooser();
        jBtPesqDatas = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabelaAdmissaoEnfermeira = new javax.swing.JTable();
        jPanel45 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel46 = new javax.swing.JPanel();
        jPanel47 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        Admissao = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jIdInternoMedico = new javax.swing.JTextField();
        jNomeInternoMedico = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jFotoInternoMedico = new javax.swing.JLabel();
        jBtPesqInternoEnfermaria = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jMaeInterno = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPaiInternoMedico = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jEstadoCivilMedico = new javax.swing.JTextField();
        jDataNascimento = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jRBTranquilo = new javax.swing.JRadioButton();
        jRBAnsioso = new javax.swing.JRadioButton();
        jRBAgeressivo = new javax.swing.JRadioButton();
        jRBTrite = new javax.swing.JRadioButton();
        jRBAgitado = new javax.swing.JRadioButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jPressaoArterial = new javax.swing.JFormattedTextField();
        jHemograma = new javax.swing.JFormattedTextField();
        jPeso = new javax.swing.JFormattedTextField();
        jFrequenciaRespira = new javax.swing.JFormattedTextField();
        jTemperatura = new javax.swing.JFormattedTextField();
        jFrequenciaCardiaca = new javax.swing.JFormattedTextField();
        jPanel17 = new javax.swing.JPanel();
        jRBPreservado = new javax.swing.JRadioButton();
        jRBDiminuido = new javax.swing.JRadioButton();
        jPanel16 = new javax.swing.JPanel();
        jRBOrientado = new javax.swing.JRadioButton();
        jRBDesorientado = new javax.swing.JRadioButton();
        jLabel42 = new javax.swing.JLabel();
        jComboBoxUsaMedica = new javax.swing.JComboBox();
        jLabel50 = new javax.swing.JLabel();
        jQualMedicamento = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jIdLanc = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jStatusLanc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jDataLanc = new com.toedter.calendar.JDateChooser();
        jPanel28 = new javax.swing.JPanel();
        jBtAlterar = new javax.swing.JButton();
        jBtNovo = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jBtFinalizar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jBtAuditoria = new javax.swing.JButton();
        jBtImpressaoFicha = new javax.swing.JButton();
        Continuacao = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel23 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jRBComAlteracaoFala = new javax.swing.JRadioButton();
        jRBSemAlteracaoFala = new javax.swing.JRadioButton();
        jQualAlteracaoFala = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jRBPeleHipohidratada = new javax.swing.JRadioButton();
        jRBPeleIntegra = new javax.swing.JRadioButton();
        jRBPeleLesao = new javax.swing.JRadioButton();
        jPanel18 = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        jLocalizacao = new javax.swing.JTextField();
        jTipo = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jRBPeleNormocoradas = new javax.swing.JRadioButton();
        jRBPeleHipocoradas = new javax.swing.JRadioButton();
        jRBPeleHidratadas = new javax.swing.JRadioButton();
        jPanel26 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jRBBocaHalitose = new javax.swing.JRadioButton();
        jRBBocaHalitoseCetonica = new javax.swing.JRadioButton();
        jRBProteseDentaria = new javax.swing.JRadioButton();
        jRBBocaAusenDenteCarie = new javax.swing.JRadioButton();
        jPanel27 = new javax.swing.JPanel();
        jRBCabelosIntegro = new javax.swing.JRadioButton();
        jRBCabelosCalvice = new javax.swing.JRadioButton();
        jRBCabelosSujidade = new javax.swing.JRadioButton();
        jPanel30 = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        jRBToraxSimetrico = new javax.swing.JRadioButton();
        jRBToraxAssimetrico = new javax.swing.JRadioButton();
        jPanel33 = new javax.swing.JPanel();
        jRBFuncaoRespDispneico = new javax.swing.JRadioButton();
        jRBFuncaoRespTaquipenico = new javax.swing.JRadioButton();
        jRBFuncaoRespEupneico = new javax.swing.JRadioButton();
        jPanel31 = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        jLabel96 = new javax.swing.JLabel();
        jCostipacaoDias = new javax.swing.JTextField();
        jRBFuncaoIntesRegular = new javax.swing.JRadioButton();
        jRBFuncaoIntesAusente = new javax.swing.JRadioButton();
        jRBFuncaoIntesConstipacao = new javax.swing.JRadioButton();
        jRBFuncaoIntesDiarreia = new javax.swing.JRadioButton();
        jPanel35 = new javax.swing.JPanel();
        jRBAbdomeGloboso = new javax.swing.JRadioButton();
        jRBAbdomeFlacido = new javax.swing.JRadioButton();
        jRBAbdomePlano = new javax.swing.JRadioButton();
        jPanel32 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        jRBFuncaoVesicalFralda = new javax.swing.JRadioButton();
        jRBFuncaoVesicalCV = new javax.swing.JRadioButton();
        jRBFuncaVeisicalEspontanea = new javax.swing.JRadioButton();
        jPanel38 = new javax.swing.JPanel();
        jLabel95 = new javax.swing.JLabel();
        jQualGenitalia = new javax.swing.JTextField();
        jRBGenitaliaComAlteracao = new javax.swing.JRadioButton();
        jRBGenitaliaIntegra = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel39 = new javax.swing.JPanel();
        jComboBoxVacinado = new javax.swing.JComboBox();
        jLabel90 = new javax.swing.JLabel();
        jQuaisVacinas = new javax.swing.JTextField();
        jLabel93 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel41 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jComboBoxVDRL = new javax.swing.JComboBox();
        jComboBoxHepatiteC = new javax.swing.JComboBox();
        jComboBoxHepatiteB = new javax.swing.JComboBox();
        jComboBoxHIV = new javax.swing.JComboBox();
        jLabel91 = new javax.swing.JLabel();
        jComboBoxCirurgia = new javax.swing.JComboBox();
        jLabel92 = new javax.swing.JLabel();
        jQualCirurgia = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jComboBoxSifilis = new javax.swing.JComboBox<>();
        jLabel106 = new javax.swing.JLabel();
        jComboBoxDiabetesMasc = new javax.swing.JComboBox();
        jLabel109 = new javax.swing.JLabel();
        jComboBoxTuberculose = new javax.swing.JComboBox<>();
        jLabel84 = new javax.swing.JLabel();
        jComboBoxHipertensaoMasc = new javax.swing.JComboBox();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jRBFuncaoComAlteracao = new javax.swing.JRadioButton();
        jRBFuncaoSemAlteracao = new javax.swing.JRadioButton();
        jLabel52 = new javax.swing.JLabel();
        jQualFuncaoMotora = new javax.swing.JTextField();
        jPanel43 = new javax.swing.JPanel();
        jRBDeambulando = new javax.swing.JRadioButton();
        jRBDifiDeambulando = new javax.swing.JRadioButton();
        jRBDeficiente = new javax.swing.JRadioButton();
        jPanel19 = new javax.swing.JPanel();
        jRBAcuiVisualPreservado = new javax.swing.JRadioButton();
        jRBAcuiVisulaDiminuido = new javax.swing.JRadioButton();
        jPanel44 = new javax.swing.JPanel();
        jRBAcuAudiPreservado = new javax.swing.JRadioButton();
        jRBAcuidAudDiminuido = new javax.swing.JRadioButton();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel60 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jQuaisDrogas = new javax.swing.JTextField();
        jQuaisDoencas = new javax.swing.JTextField();
        jQuaisAlergias = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jComboBoxPortadorDoencas = new javax.swing.JComboBox();
        jComboBoxAlergias = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jComboBoxUsuarioDrogas = new javax.swing.JComboBox();
        jPanel61 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jObservacao = new javax.swing.JTextArea();
        AEFP1 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jComboBoxHipertensao = new javax.swing.JComboBox();
        jLabel38 = new javax.swing.JLabel();
        jComboBoxCardiopatias = new javax.swing.JComboBox();
        jLabel39 = new javax.swing.JLabel();
        jComboBoxDiabetes = new javax.swing.JComboBox();
        jLabel40 = new javax.swing.JLabel();
        jComboBoxAnemias = new javax.swing.JComboBox();
        jLabel41 = new javax.swing.JLabel();
        jComboBoxAPAlergias = new javax.swing.JComboBox();
        jLabel43 = new javax.swing.JLabel();
        jComboBoxDoencasRenais = new javax.swing.JComboBox();
        jLabel44 = new javax.swing.JLabel();
        jComboBoxPortadorHIV = new javax.swing.JComboBox();
        jLabel45 = new javax.swing.JLabel();
        jComboBoxTransfusao = new javax.swing.JComboBox();
        jLabel46 = new javax.swing.JLabel();
        jComboBoxRetroviarias = new javax.swing.JComboBox();
        jLabel47 = new javax.swing.JLabel();
        jQuaisRetroviarias = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jComboBoxCirurgias = new javax.swing.JComboBox();
        jLabel51 = new javax.swing.JLabel();
        jDataCirurgia = new com.toedter.calendar.JDateChooser();
        jLabel49 = new javax.swing.JLabel();
        jTipoCirurgia = new javax.swing.JTextField();
        jPanel49 = new javax.swing.JPanel();
        jBtNovoAFP1 = new javax.swing.JButton();
        jBtAlterarAFP1 = new javax.swing.JButton();
        jBtExcluirAFP1 = new javax.swing.JButton();
        jBtCancelarAFP1 = new javax.swing.JButton();
        jBtSalvarAFP1 = new javax.swing.JButton();
        jBtSairAFP1 = new javax.swing.JButton();
        jBtAuditoriaAFP1 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel48 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jCiclosMenstruais = new javax.swing.JTextArea();
        jPanel50 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jMetodosAnticoncepcionais = new javax.swing.JTextArea();
        jPanel51 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jDoencasSexualmenteTransmissiveis = new javax.swing.JTextArea();
        jPanel52 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jColpocitologiaOncotica = new javax.swing.JTextArea();
        AEFP2 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jNumeroPartos = new javax.swing.JFormattedTextField();
        jNumeroGestacoes = new javax.swing.JFormattedTextField();
        jLabel60 = new javax.swing.JLabel();
        jNumeroAbortos = new javax.swing.JFormattedTextField();
        jLabel61 = new javax.swing.JLabel();
        jNumeroFilhosVivos = new javax.swing.JFormattedTextField();
        jLabel62 = new javax.swing.JLabel();
        jIdadePrimeiraGestacao = new javax.swing.JFormattedTextField();
        jLabel64 = new javax.swing.JLabel();
        jIntervaloGestacoes = new javax.swing.JFormattedTextField();
        jPanel53 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jPretermo = new javax.swing.JFormattedTextField();
        jLabel68 = new javax.swing.JLabel();
        jPostermo = new javax.swing.JFormattedTextField();
        jLabel69 = new javax.swing.JLabel();
        jBaixoPeso = new javax.swing.JFormattedTextField();
        jLabel70 = new javax.swing.JLabel();
        jMortesNeonataisPrecoce = new javax.swing.JFormattedTextField();
        jLabel71 = new javax.swing.JLabel();
        jMotivoMorteNeonataisPrecoce = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        jMortesNeonataisTardias = new javax.swing.JFormattedTextField();
        jLabel73 = new javax.swing.JLabel();
        jMotivoMortesNeonataisTardias = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        jNatimortos = new javax.swing.JFormattedTextField();
        jLabel75 = new javax.swing.JLabel();
        jIctericia = new javax.swing.JFormattedTextField();
        jLabel76 = new javax.swing.JLabel();
        jTransfusao = new javax.swing.JFormattedTextField();
        jLabel77 = new javax.swing.JLabel();
        jHipoglicemia = new javax.swing.JFormattedTextField();
        jLabel78 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jIntercorrenciaComplicacoesGestoes = new javax.swing.JTextArea();
        jLabel79 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jHistoriaAleitamentosAnteriores = new javax.swing.JTextArea();
        jLabel113 = new javax.swing.JLabel();
        jIsoimunizacaoRH = new javax.swing.JFormattedTextField();
        jPanel54 = new javax.swing.JPanel();
        jBtNovoAFP2 = new javax.swing.JButton();
        jBtAlterarAFP2 = new javax.swing.JButton();
        jBtExcluirAFP2 = new javax.swing.JButton();
        jBtCancelarAFP2 = new javax.swing.JButton();
        jBtSalvarAFP2 = new javax.swing.JButton();
        jBtSairAFP2 = new javax.swing.JButton();
        jBtAuditoriaAFP2 = new javax.swing.JButton();
        AEFP3 = new javax.swing.JPanel();
        jPanel55 = new javax.swing.JPanel();
        jLabel81 = new javax.swing.JLabel();
        jDataUltimaMenstruacao = new com.toedter.calendar.JDateChooser();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jHabitosAlimentares = new javax.swing.JTextField();
        jLabel87 = new javax.swing.JLabel();
        jMedicamentoGestacao = new javax.swing.JTextField();
        jLabel88 = new javax.swing.JLabel();
        jComboBoxInternacaoGestacao = new javax.swing.JComboBox();
        jLabel89 = new javax.swing.JLabel();
        jOndeGestacao = new javax.swing.JTextField();
        jLabel100 = new javax.swing.JLabel();
        jCheckBoxCigarro = new javax.swing.JCheckBox();
        jCheckBoxPacaia = new javax.swing.JCheckBox();
        jCheckBoxMaconha = new javax.swing.JCheckBox();
        jCheckBoxCocaina = new javax.swing.JCheckBox();
        jCheckBoxCraque = new javax.swing.JCheckBox();
        jCheckBoxOutros = new javax.swing.JCheckBox();
        jCheckBoxAlcool = new javax.swing.JCheckBox();
        jLabel101 = new javax.swing.JLabel();
        jQuaisDrogras = new javax.swing.JTextField();
        jLabel102 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jOcupacaoHabitual = new javax.swing.JTextArea();
        jLabel103 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jAceitacaoGravidez = new javax.swing.JTextArea();
        jLabel114 = new javax.swing.JLabel();
        jComboBoxGestante = new javax.swing.JComboBox();
        jCertezaDuvidaGestacao = new javax.swing.JTextField();
        jScrollPane14 = new javax.swing.JScrollPane();
        jSinaisSintomas = new javax.swing.JTextArea();
        jPanel56 = new javax.swing.JPanel();
        jBtNovoAFP3 = new javax.swing.JButton();
        jBtAlterarAFP3 = new javax.swing.JButton();
        jBtExcluirAFP3 = new javax.swing.JButton();
        jBtCancelarAFP3 = new javax.swing.JButton();
        jBtSalvarAFP3 = new javax.swing.JButton();
        jBtSairAFP3 = new javax.swing.JButton();
        jBtAuditoriaAFP3 = new javax.swing.JButton();
        AEFP4 = new javax.swing.JPanel();
        jPanel57 = new javax.swing.JPanel();
        jLabel104 = new javax.swing.JLabel();
        jPesoGestante = new javax.swing.JFormattedTextField();
        jLabel105 = new javax.swing.JLabel();
        jAlturaGestante = new javax.swing.JFormattedTextField();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jPalpacaoTireoide = new javax.swing.JTextArea();
        jLabel110 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jCheckBoxFace = new javax.swing.JCheckBox();
        jCheckBoxTronco = new javax.swing.JCheckBox();
        jCheckBoxMembroInferior = new javax.swing.JCheckBox();
        jScrollPane15 = new javax.swing.JScrollPane();
        jInspecaoPeleMucosa = new javax.swing.JTextArea();
        jCheckBoxMembroSuperior = new javax.swing.JCheckBox();
        jScrollPane16 = new javax.swing.JScrollPane();
        jExameAbdomem = new javax.swing.JTextArea();
        jLabel80 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jScrollPane17 = new javax.swing.JScrollPane();
        jPosicaoFetal = new javax.swing.JTextArea();
        jAlturaUterina = new javax.swing.JFormattedTextField();
        jLabel83 = new javax.swing.JLabel();
        jPanel58 = new javax.swing.JPanel();
        jBtNovoAFP4 = new javax.swing.JButton();
        jBtAlterarAFP4 = new javax.swing.JButton();
        jBtExcluirAFP4 = new javax.swing.JButton();
        jBtCancelarAFP4 = new javax.swing.JButton();
        jBtSalvarAFP4 = new javax.swing.JButton();
        jBtSairAFP4 = new javax.swing.JButton();
        jBtAuditoriaAFP4 = new javax.swing.JButton();
        Evolucao = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTabelaEvolucaoEnfermagem = new javax.swing.JTable();
        jPanel40 = new javax.swing.JPanel();
        jIdEvolucao = new javax.swing.JTextField();
        jNomeInternoEvolEnf = new javax.swing.JTextField();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jDataEvolu = new com.toedter.calendar.JDateChooser();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextoEvolucao = new javax.swing.JTextArea();
        jBtNovaEvolucao = new javax.swing.JButton();
        jBtAlterarEvolucao = new javax.swing.JButton();
        jBtExcluirEvolucao = new javax.swing.JButton();
        jBtSalvarEvolucao = new javax.swing.JButton();
        jBtCancelarEvolucao = new javax.swing.JButton();
        jBtAuditoriaEvolucao = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jBtImpressao = new javax.swing.JButton();

        jLabel94.setText("jLabel94");

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Admissão de Enfermagem/Evolução -  {DM} :::...");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Código:");

        jCodigoLanc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodigoLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqCodigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqCodigo.setContentAreaFilled(false);
        jBtPesqCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqCodigoActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Nome do Interno:");

        jNomesInternoPesq.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqNomeInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqNomeInterno.setContentAreaFilled(false);
        jBtPesqNomeInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqNomeInternoActionPerformed(evt);
            }
        });

        jCheckBoxTodos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxTodos.setText("Todos");
        jCheckBoxTodos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxTodosItemStateChanged(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("Data Inicial:");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setText("Data Final:");

        jDataInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jDataFinal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqDatas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqDatas.setContentAreaFilled(false);
        jBtPesqDatas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqDatasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jCodigoLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqDatas, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jNomesInternoPesq)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxTodos)
                        .addGap(21, 21, 21))))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel20)
                    .addComponent(jCodigoLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqCodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel22)
                    .addComponent(jDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(jDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqDatas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jNomesInternoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(jBtPesqNomeInterno)
                    .addComponent(jCheckBoxTodos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaAdmissaoEnfermeira.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaAdmissaoEnfermeira.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Data", "Status", "Nome Completo do Interno", "Histórico Criminal"
            }
        ));
        jTabelaAdmissaoEnfermeira.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaAdmissaoEnfermeiraMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTabelaAdmissaoEnfermeira);
        if (jTabelaAdmissaoEnfermeira.getColumnModel().getColumnCount() > 0) {
            jTabelaAdmissaoEnfermeira.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaAdmissaoEnfermeira.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaAdmissaoEnfermeira.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaAdmissaoEnfermeira.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaAdmissaoEnfermeira.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaAdmissaoEnfermeira.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaAdmissaoEnfermeira.getColumnModel().getColumn(3).setMinWidth(335);
            jTabelaAdmissaoEnfermeira.getColumnModel().getColumn(3).setMaxWidth(335);
            jTabelaAdmissaoEnfermeira.getColumnModel().getColumn(4).setMinWidth(335);
            jTabelaAdmissaoEnfermeira.getColumnModel().getColumn(4).setMaxWidth(335);
        }

        jPanel45.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jtotalRegistros.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
        );

        jPanel46.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        jPanel47.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jLabel63.setText("Total de Registros:");

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel63))
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel63)
        );

        javax.swing.GroupLayout ListagemLayout = new javax.swing.GroupLayout(Listagem);
        Listagem.setLayout(ListagemLayout);
        ListagemLayout.setHorizontalGroup(
            ListagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ListagemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ListagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
                    .addGroup(ListagemLayout.createSequentialGroup()
                        .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        ListagemLayout.setVerticalGroup(
            ListagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ListagemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ListagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("Listagem", Listagem);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Interno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Código");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Nome Completo do Interno");

        jIdInternoMedico.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdInternoMedico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdInternoMedico.setEnabled(false);

        jNomeInternoMedico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoMedico.setEnabled(false);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Foto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoMedico, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jFotoInternoMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jBtPesqInternoEnfermaria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqInternoEnfermaria.setContentAreaFilled(false);
        jBtPesqInternoEnfermaria.setEnabled(false);
        jBtPesqInternoEnfermaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqInternoEnfermariaActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Mãe:");

        jMaeInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMaeInterno.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Pai:");

        jPaiInternoMedico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPaiInternoMedico.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Dt. Nasc:");

        jEstadoCivilMedico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jEstadoCivilMedico.setEnabled(false);

        jDataNascimento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataNascimento.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("E. Civil:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(jLabel6))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jLabel5))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGap(176, 176, 176)
                                .addComponent(jDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jEstadoCivilMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(jIdInternoMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPaiInternoMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jMaeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jNomeInternoMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtPesqInternoEnfermaria, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jMaeInterno, jNomeInternoMedico, jPaiInternoMedico});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIdInternoMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNomeInternoMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqInternoEnfermaria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel7)
                    .addComponent(jMaeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel8)
                    .addComponent(jPaiInternoMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel9)
                    .addComponent(jDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jEstadoCivilMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 11, Short.MAX_VALUE))
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jMaeInterno, jNomeInternoMedico, jPaiInternoMedico});

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Estado Emocional", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        EstadoEmocional.add(jRBTranquilo);
        jRBTranquilo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBTranquilo.setSelected(true);
        jRBTranquilo.setText("Tranquilo");
        jRBTranquilo.setEnabled(false);

        EstadoEmocional.add(jRBAnsioso);
        jRBAnsioso.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBAnsioso.setText("Ansioso");
        jRBAnsioso.setEnabled(false);

        EstadoEmocional.add(jRBAgeressivo);
        jRBAgeressivo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBAgeressivo.setText("Agressivo");
        jRBAgeressivo.setEnabled(false);

        EstadoEmocional.add(jRBTrite);
        jRBTrite.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBTrite.setText("Triste");
        jRBTrite.setEnabled(false);

        EstadoEmocional.add(jRBAgitado);
        jRBAgitado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBAgitado.setText("Agitado");
        jRBAgitado.setEnabled(false);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRBTranquilo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRBAnsioso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRBAgeressivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRBTrite)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRBAgitado)
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRBTranquilo)
                    .addComponent(jRBAnsioso)
                    .addComponent(jRBAgeressivo)
                    .addComponent(jRBTrite)
                    .addComponent(jRBAgitado))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sinais Vitais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setText("HGT:");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setText("ml/dl");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel28.setText("T:");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel29.setText("Cº");

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel30.setText("FC:");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setText(" PA:");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setText("mmhg");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel31.setText("bpm");

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel32.setText("FR:");

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel33.setText("irm");

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel34.setText("Peso:");

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel35.setText("Kg");

        jPressaoArterial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPressaoArterial.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPressaoArterial.setEnabled(false);

        jHemograma.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHemograma.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jHemograma.setEnabled(false);

        jPeso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPeso.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPeso.setEnabled(false);

        jFrequenciaRespira.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jFrequenciaRespira.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFrequenciaRespira.setEnabled(false);

        jTemperatura.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTemperatura.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTemperatura.setEnabled(false);

        jFrequenciaCardiaca.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jFrequenciaCardiaca.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFrequenciaCardiaca.setEnabled(false);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jPressaoArterial, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel26))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jFrequenciaRespira, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel34)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jHemograma, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addGap(14, 14, 14)))
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel28)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jTemperatura, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel29))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jFrequenciaCardiaca, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel31)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jFrequenciaCardiaca, jFrequenciaRespira, jHemograma, jPeso, jPressaoArterial, jTemperatura});

        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29)
                    .addComponent(jPressaoArterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jHemograma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTemperatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33)
                    .addComponent(jLabel34)
                    .addComponent(jLabel35)
                    .addComponent(jLabel30)
                    .addComponent(jLabel31)
                    .addComponent(jPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFrequenciaRespira, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFrequenciaCardiaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jFrequenciaCardiaca, jFrequenciaRespira, jHemograma, jPeso, jPressaoArterial, jTemperatura});

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sono/Repouso", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        SonoRepouso.add(jRBPreservado);
        jRBPreservado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBPreservado.setSelected(true);
        jRBPreservado.setText("Preservado");
        jRBPreservado.setEnabled(false);

        SonoRepouso.add(jRBDiminuido);
        jRBDiminuido.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBDiminuido.setText("Dimunuido");
        jRBDiminuido.setEnabled(false);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRBDiminuido)
                    .addComponent(jRBPreservado))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jRBPreservado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRBDiminuido))
        );

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nível de Consciência", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        NivelConciencia.add(jRBOrientado);
        jRBOrientado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBOrientado.setSelected(true);
        jRBOrientado.setText("Orientado");
        jRBOrientado.setEnabled(false);

        NivelConciencia.add(jRBDesorientado);
        jRBDesorientado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBDesorientado.setText("Desorientado");
        jRBDesorientado.setEnabled(false);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRBDesorientado)
                    .addComponent(jRBOrientado))
                .addGap(25, 25, 25))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRBOrientado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRBDesorientado)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel42.setText("Usa Medicamentos");

        jComboBoxUsaMedica.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxUsaMedica.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxUsaMedica.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxUsaMedica.setEnabled(false);

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel50.setText("Qual medicamento Utiliza?");

        jQualMedicamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualMedicamento.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxUsaMedica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel50)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jQualMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(jComboBoxUsaMedica, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel50)
                    .addComponent(jQualMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Aendimento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código:");

        jIdLanc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdLanc.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Status:");

        jStatusLanc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jStatusLanc.setForeground(new java.awt.Color(153, 0, 153));
        jStatusLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jStatusLanc.setDisabledTextColor(new java.awt.Color(204, 0, 153));
        jStatusLanc.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Data:");

        jDataLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataLanc.setEnabled(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jIdLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jStatusLanc)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDataLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jDataLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jStatusLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jIdLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel28.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

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

        jBtFinalizar.setForeground(new java.awt.Color(255, 0, 0));
        jBtFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/accept.png"))); // NOI18N
        jBtFinalizar.setText("Finalizar");
        jBtFinalizar.setContentAreaFilled(false);
        jBtFinalizar.setEnabled(false);
        jBtFinalizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtFinalizar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtFinalizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFinalizarActionPerformed(evt);
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

        jBtAuditoria.setForeground(new java.awt.Color(0, 0, 255));
        jBtAuditoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoria.setContentAreaFilled(false);
        jBtAuditoria.setEnabled(false);
        jBtAuditoria.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAuditoria.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAuditoria.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAuditoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaActionPerformed(evt);
            }
        });

        jBtImpressaoFicha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/gtklp-icone-3770-16.png"))); // NOI18N
        jBtImpressaoFicha.setToolTipText("Impressão de Ficha Interno");
        jBtImpressaoFicha.setContentAreaFilled(false);
        jBtImpressaoFicha.setEnabled(false);
        jBtImpressaoFicha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtImpressaoFichaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addComponent(jBtNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSair)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtImpressaoFicha, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBtCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtSalvar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jBtSair)
                            .addComponent(jBtFinalizar)
                            .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jBtAlterar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBtNovo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(43, 43, 43))
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBtAuditoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtImpressaoFicha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout AdmissaoLayout = new javax.swing.GroupLayout(Admissao);
        Admissao.setLayout(AdmissaoLayout);
        AdmissaoLayout.setHorizontalGroup(
            AdmissaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdmissaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AdmissaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        AdmissaoLayout.setVerticalGroup(
            AdmissaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdmissaoLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(556, 556, 556))
        );

        jTabbedPane1.addTab("Admissão", Admissao);

        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Avaliações Admissionais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        jTabbedPane2.setForeground(new java.awt.Color(51, 153, 0));
        jTabbedPane2.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fala/Linguagem", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        FalaLinguagem.add(jRBComAlteracaoFala);
        jRBComAlteracaoFala.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBComAlteracaoFala.setText("C/Alteração");
        jRBComAlteracaoFala.setEnabled(false);

        FalaLinguagem.add(jRBSemAlteracaoFala);
        jRBSemAlteracaoFala.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBSemAlteracaoFala.setSelected(true);
        jRBSemAlteracaoFala.setText("S/Alteração");
        jRBSemAlteracaoFala.setEnabled(false);

        jQualAlteracaoFala.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualAlteracaoFala.setEnabled(false);

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel59.setText("Qual?:");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRBSemAlteracaoFala)
                    .addComponent(jRBComAlteracaoFala))
                .addGap(28, 28, 28)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel59)
                        .addGap(0, 349, Short.MAX_VALUE))
                    .addComponent(jQualAlteracaoFala))
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRBComAlteracaoFala)
                    .addComponent(jLabel59, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRBSemAlteracaoFala)
                    .addComponent(jQualAlteracaoFala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Fala", jPanel23);

        jPanel25.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pele", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        Pele.add(jRBPeleHipohidratada);
        jRBPeleHipohidratada.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBPeleHipohidratada.setText("Hipohidratada");
        jRBPeleHipohidratada.setEnabled(false);

        Pele.add(jRBPeleIntegra);
        jRBPeleIntegra.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBPeleIntegra.setSelected(true);
        jRBPeleIntegra.setText("Integra");
        jRBPeleIntegra.setEnabled(false);

        Pele.add(jRBPeleLesao);
        jRBPeleLesao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBPeleLesao.setText("Lesão");
        jRBPeleLesao.setEnabled(false);

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jRBPeleHipohidratada)
            .addComponent(jRBPeleIntegra)
            .addComponent(jRBPeleLesao)
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addComponent(jRBPeleHipohidratada)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRBPeleIntegra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRBPeleLesao)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel66.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel66.setText("Localização:");

        jLocalizacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLocalizacao.setEnabled(false);

        jTipo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTipo.setEnabled(false);

        jLabel65.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel65.setText("Tipo");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel65)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel66)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLocalizacao))
                    .addComponent(jTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(141, 141, 141))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel65)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel66)
                    .addComponent(jLocalizacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mucosa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        Mucosa.add(jRBPeleNormocoradas);
        jRBPeleNormocoradas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBPeleNormocoradas.setSelected(true);
        jRBPeleNormocoradas.setText("Normocoradas");
        jRBPeleNormocoradas.setEnabled(false);

        Mucosa.add(jRBPeleHipocoradas);
        jRBPeleHipocoradas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBPeleHipocoradas.setText("Hipocoradas");
        jRBPeleHipocoradas.setEnabled(false);

        Mucosa.add(jRBPeleHidratadas);
        jRBPeleHidratadas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBPeleHidratadas.setText("Hidratadas");
        jRBPeleHidratadas.setEnabled(false);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRBPeleNormocoradas)
                    .addComponent(jRBPeleHipocoradas)
                    .addComponent(jRBPeleHidratadas))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jRBPeleNormocoradas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRBPeleHipocoradas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRBPeleHidratadas)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane2.addTab("Pele/Mucosa", jPanel24);

        jPanel29.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Boca", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        Boca.add(jRBBocaHalitose);
        jRBBocaHalitose.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBBocaHalitose.setText("Halitose");
        jRBBocaHalitose.setEnabled(false);

        Boca.add(jRBBocaHalitoseCetonica);
        jRBBocaHalitoseCetonica.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBBocaHalitoseCetonica.setText("Halitose Cetônico");
        jRBBocaHalitoseCetonica.setEnabled(false);

        Boca.add(jRBProteseDentaria);
        jRBProteseDentaria.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBProteseDentaria.setSelected(true);
        jRBProteseDentaria.setText("Protese Dentária");
        jRBProteseDentaria.setEnabled(false);

        Boca.add(jRBBocaAusenDenteCarie);
        jRBBocaAusenDenteCarie.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBBocaAusenDenteCarie.setText("Ausencia de Dente/Caries");
        jRBBocaAusenDenteCarie.setEnabled(false);

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRBBocaHalitoseCetonica)
                    .addComponent(jRBBocaHalitose))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRBBocaAusenDenteCarie)
                    .addComponent(jRBProteseDentaria))
                .addContainerGap())
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRBBocaHalitose)
                    .addComponent(jRBProteseDentaria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRBBocaHalitoseCetonica)
                    .addComponent(jRBBocaAusenDenteCarie))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel27.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cabelos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        Cabelos.add(jRBCabelosIntegro);
        jRBCabelosIntegro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBCabelosIntegro.setSelected(true);
        jRBCabelosIntegro.setText("Integro");
        jRBCabelosIntegro.setEnabled(false);

        Cabelos.add(jRBCabelosCalvice);
        jRBCabelosCalvice.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBCabelosCalvice.setText("Calvicie");
        jRBCabelosCalvice.setEnabled(false);

        Cabelos.add(jRBCabelosSujidade);
        jRBCabelosSujidade.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBCabelosSujidade.setText("Sujidade");
        jRBCabelosSujidade.setEnabled(false);

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jRBCabelosIntegro)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jRBCabelosCalvice)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRBCabelosSujidade)))
                .addContainerGap())
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRBCabelosIntegro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRBCabelosCalvice)
                    .addComponent(jRBCabelosSujidade))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("C/Cabeludo", jPanel26);

        jPanel34.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Toráx", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        Torax.add(jRBToraxSimetrico);
        jRBToraxSimetrico.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBToraxSimetrico.setSelected(true);
        jRBToraxSimetrico.setText("Simétrico");
        jRBToraxSimetrico.setEnabled(false);

        Torax.add(jRBToraxAssimetrico);
        jRBToraxAssimetrico.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBToraxAssimetrico.setText("Assimétrico");
        jRBToraxAssimetrico.setEnabled(false);

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRBToraxAssimetrico)
                    .addComponent(jRBToraxSimetrico))
                .addContainerGap(166, Short.MAX_VALUE))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRBToraxSimetrico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRBToraxAssimetrico)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel33.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Função Respiratória", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        FuncaoRespiratoria.add(jRBFuncaoRespDispneico);
        jRBFuncaoRespDispneico.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBFuncaoRespDispneico.setText("Dispnéico");
        jRBFuncaoRespDispneico.setEnabled(false);

        FuncaoRespiratoria.add(jRBFuncaoRespTaquipenico);
        jRBFuncaoRespTaquipenico.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBFuncaoRespTaquipenico.setText("Taquipénico");
        jRBFuncaoRespTaquipenico.setEnabled(false);

        FuncaoRespiratoria.add(jRBFuncaoRespEupneico);
        jRBFuncaoRespEupneico.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBFuncaoRespEupneico.setSelected(true);
        jRBFuncaoRespEupneico.setText("Eupnéico");
        jRBFuncaoRespEupneico.setEnabled(false);

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addComponent(jRBFuncaoRespTaquipenico)
                        .addGap(32, 32, 32)
                        .addComponent(jRBFuncaoRespDispneico))
                    .addComponent(jRBFuncaoRespEupneico))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRBFuncaoRespEupneico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRBFuncaoRespTaquipenico)
                    .addComponent(jRBFuncaoRespDispneico))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("FR/T", jPanel30);

        jPanel36.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Função Intestinal", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel96.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel96.setText("Dias:");

        jCostipacaoDias.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCostipacaoDias.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCostipacaoDias.setEnabled(false);

        FuncaoIntestinal.add(jRBFuncaoIntesRegular);
        jRBFuncaoIntesRegular.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBFuncaoIntesRegular.setSelected(true);
        jRBFuncaoIntesRegular.setText("Regular");
        jRBFuncaoIntesRegular.setEnabled(false);

        FuncaoIntestinal.add(jRBFuncaoIntesAusente);
        jRBFuncaoIntesAusente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBFuncaoIntesAusente.setText("Ausênte");
        jRBFuncaoIntesAusente.setEnabled(false);

        FuncaoIntestinal.add(jRBFuncaoIntesConstipacao);
        jRBFuncaoIntesConstipacao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBFuncaoIntesConstipacao.setText("Constipado");
        jRBFuncaoIntesConstipacao.setEnabled(false);

        FuncaoIntestinal.add(jRBFuncaoIntesDiarreia);
        jRBFuncaoIntesDiarreia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBFuncaoIntesDiarreia.setText("Diarréia");
        jRBFuncaoIntesDiarreia.setEnabled(false);

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRBFuncaoIntesRegular)
                    .addComponent(jRBFuncaoIntesAusente))
                .addGap(14, 14, 14)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(jRBFuncaoIntesConstipacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel96)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCostipacaoDias, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jRBFuncaoIntesDiarreia))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel96)
                            .addComponent(jCostipacaoDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jRBFuncaoIntesConstipacao))
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRBFuncaoIntesRegular)
                            .addComponent(jRBFuncaoIntesDiarreia))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRBFuncaoIntesAusente)))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel35.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Abome", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        Abdome.add(jRBAbdomeGloboso);
        jRBAbdomeGloboso.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBAbdomeGloboso.setText("Globoso");
        jRBAbdomeGloboso.setEnabled(false);

        Abdome.add(jRBAbdomeFlacido);
        jRBAbdomeFlacido.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBAbdomeFlacido.setSelected(true);
        jRBAbdomeFlacido.setText("Flácido");
        jRBAbdomeFlacido.setEnabled(false);

        Abdome.add(jRBAbdomePlano);
        jRBAbdomePlano.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBAbdomePlano.setText("Plano");
        jRBAbdomePlano.setEnabled(false);

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addComponent(jRBAbdomeFlacido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRBAbdomePlano))
                    .addComponent(jRBAbdomeGloboso))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRBAbdomeGloboso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRBAbdomeFlacido)
                    .addComponent(jRBAbdomePlano))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(53, 53, 53))
        );

        jTabbedPane2.addTab("AB/FI", jPanel31);

        jPanel37.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Função Vesical", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        FuncaoVesical.add(jRBFuncaoVesicalFralda);
        jRBFuncaoVesicalFralda.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBFuncaoVesicalFralda.setSelected(true);
        jRBFuncaoVesicalFralda.setText("Fralda");
        jRBFuncaoVesicalFralda.setEnabled(false);

        FuncaoVesical.add(jRBFuncaoVesicalCV);
        jRBFuncaoVesicalCV.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBFuncaoVesicalCV.setText("CV");
        jRBFuncaoVesicalCV.setToolTipText("");
        jRBFuncaoVesicalCV.setEnabled(false);

        FuncaoVesical.add(jRBFuncaVeisicalEspontanea);
        jRBFuncaVeisicalEspontanea.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBFuncaVeisicalEspontanea.setText("Espontâneo");
        jRBFuncaVeisicalEspontanea.setEnabled(false);

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRBFuncaoVesicalFralda)
                    .addComponent(jRBFuncaVeisicalEspontanea)
                    .addComponent(jRBFuncaoVesicalCV))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addComponent(jRBFuncaoVesicalFralda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRBFuncaoVesicalCV)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRBFuncaVeisicalEspontanea))
        );

        jPanel38.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Genitália", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel95.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel95.setText("Qual?");

        jQualGenitalia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualGenitalia.setEnabled(false);

        Genitalia.add(jRBGenitaliaComAlteracao);
        jRBGenitaliaComAlteracao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBGenitaliaComAlteracao.setText("Com Alteração");
        jRBGenitaliaComAlteracao.setEnabled(false);

        Genitalia.add(jRBGenitaliaIntegra);
        jRBGenitaliaIntegra.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBGenitaliaIntegra.setSelected(true);
        jRBGenitaliaIntegra.setText("Integra");
        jRBGenitaliaIntegra.setEnabled(false);

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRBGenitaliaIntegra)
                    .addComponent(jRBGenitaliaComAlteracao))
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel95)
                        .addContainerGap(234, Short.MAX_VALUE))
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jQualGenitalia)
                        .addContainerGap())))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel95)
                    .addComponent(jRBGenitaliaIntegra))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jQualGenitalia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRBGenitaliaComAlteracao))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel37, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("FV/GE", jPanel32);

        jPanel39.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Vacinas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        jComboBoxVacinado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxVacinado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Não sabe", "Sim" }));
        jComboBoxVacinado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxVacinado.setEnabled(false);

        jLabel90.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel90.setText("Quais:");

        jQuaisVacinas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQuaisVacinas.setEnabled(false);

        jLabel93.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel93.setText("Vacinado:");

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel93)
                    .addComponent(jLabel90))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel39Layout.createSequentialGroup()
                        .addComponent(jComboBoxVacinado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 364, Short.MAX_VALUE))
                    .addComponent(jQuaisVacinas))
                .addContainerGap())
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel39Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxVacinado, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel93))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel90)
                    .addComponent(jQuaisVacinas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, 87, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Vacina", jPanel1);

        jPanel41.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Teste rápido/Cirurgias", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("VDRL:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Hepatite C:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Hepatite B:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("HIV:");

        jComboBoxVDRL.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxVDRL.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não reagente", "Reagente", "Não Realizado" }));
        jComboBoxVDRL.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxVDRL.setEnabled(false);

        jComboBoxHepatiteC.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxHepatiteC.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não reagente", "Reagente", "Não realizado" }));
        jComboBoxHepatiteC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxHepatiteC.setEnabled(false);

        jComboBoxHepatiteB.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxHepatiteB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não reagente", "Reagente", "Não realizado" }));
        jComboBoxHepatiteB.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxHepatiteB.setEnabled(false);

        jComboBoxHIV.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxHIV.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não reagente", "Reagente", "Não realizado" }));
        jComboBoxHIV.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxHIV.setEnabled(false);

        jLabel91.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel91.setText("Cirurgias:");

        jComboBoxCirurgia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxCirurgia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxCirurgia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxCirurgia.setEnabled(false);

        jLabel92.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel92.setText("Quais:");

        jQualCirurgia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualCirurgia.setEnabled(false);

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel36.setText("Sifilis:");

        jComboBoxSifilis.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxSifilis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não reagente", "Reagente", "Não Realizado" }));
        jComboBoxSifilis.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxSifilis.setEnabled(false);

        jLabel106.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel106.setText("Diabetes:");

        jComboBoxDiabetesMasc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDiabetesMasc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxDiabetesMasc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDiabetesMasc.setEnabled(false);

        jLabel109.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel109.setText("Tuberculose:");
        jLabel109.setToolTipText("Tuberculose");

        jComboBoxTuberculose.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTuberculose.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Negativo", "Positivo" }));
        jComboBoxTuberculose.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTuberculose.setEnabled(false);

        jLabel84.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel84.setText("Hiper:");
        jLabel84.setToolTipText("Hipertensão");

        jComboBoxHipertensaoMasc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxHipertensaoMasc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxHipertensaoMasc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxHipertensaoMasc.setEnabled(false);

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel36)
                    .addComponent(jLabel13)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBoxVDRL, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxHIV, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxSifilis, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel91, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel106, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addComponent(jComboBoxHepatiteC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxHepatiteB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel41Layout.createSequentialGroup()
                                .addComponent(jComboBoxDiabetesMasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel84))
                            .addGroup(jPanel41Layout.createSequentialGroup()
                                .addComponent(jComboBoxCirurgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel92)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jQualCirurgia)
                            .addGroup(jPanel41Layout.createSequentialGroup()
                                .addComponent(jComboBoxHipertensaoMasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel109, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxTuberculose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );

        jPanel41Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jComboBoxHIV, jComboBoxHepatiteB, jComboBoxHepatiteC, jComboBoxVDRL});

        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel10)
                    .addComponent(jComboBoxVDRL, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jComboBoxHepatiteC, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jComboBoxHepatiteB, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel13)
                    .addComponent(jComboBoxHIV, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel91)
                    .addComponent(jComboBoxCirurgia, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel92)
                    .addComponent(jQualCirurgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel36)
                    .addComponent(jComboBoxSifilis, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel106)
                    .addComponent(jComboBoxDiabetesMasc, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel84)
                    .addComponent(jComboBoxHipertensaoMasc, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel109)
                    .addComponent(jComboBoxTuberculose, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, 118, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Testes Rápidos", jPanel2);

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Locomoção/Função Motora", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 102, 51))); // NOI18N

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Função Motora", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 102, 0))); // NOI18N

        FuncaoMotora.add(jRBFuncaoComAlteracao);
        jRBFuncaoComAlteracao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBFuncaoComAlteracao.setText("Com Alteração");
        jRBFuncaoComAlteracao.setEnabled(false);

        FuncaoMotora.add(jRBFuncaoSemAlteracao);
        jRBFuncaoSemAlteracao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBFuncaoSemAlteracao.setSelected(true);
        jRBFuncaoSemAlteracao.setText("Sem Alteração");
        jRBFuncaoSemAlteracao.setEnabled(false);

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel52.setText("Qual?");

        jQualFuncaoMotora.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualFuncaoMotora.setEnabled(false);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRBFuncaoComAlteracao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRBFuncaoSemAlteracao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel52)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jQualFuncaoMotora)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jRBFuncaoComAlteracao)
                    .addComponent(jRBFuncaoSemAlteracao)
                    .addComponent(jQualFuncaoMotora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel52))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel43.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Locomoção", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        Locomocao.add(jRBDeambulando);
        jRBDeambulando.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBDeambulando.setSelected(true);
        jRBDeambulando.setText("Deambul.");
        jRBDeambulando.setEnabled(false);

        Locomocao.add(jRBDifiDeambulando);
        jRBDifiDeambulando.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBDifiDeambulando.setText("Difi. Deamb.");
        jRBDifiDeambulando.setEnabled(false);

        Locomocao.add(jRBDeficiente);
        jRBDeficiente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBDeficiente.setText("Deficiente");
        jRBDeficiente.setEnabled(false);

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRBDeambulando)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jRBDifiDeambulando, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRBDeficiente, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jRBDeambulando)
                    .addComponent(jRBDifiDeambulando)
                    .addComponent(jRBDeficiente))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Acuidade visual", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        AcuidadeVisual.add(jRBAcuiVisualPreservado);
        jRBAcuiVisualPreservado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBAcuiVisualPreservado.setSelected(true);
        jRBAcuiVisualPreservado.setText("Preservado");
        jRBAcuiVisualPreservado.setEnabled(false);

        AcuidadeVisual.add(jRBAcuiVisulaDiminuido);
        jRBAcuiVisulaDiminuido.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBAcuiVisulaDiminuido.setText("Diminuido");
        jRBAcuiVisulaDiminuido.setEnabled(false);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRBAcuiVisualPreservado)
                    .addComponent(jRBAcuiVisulaDiminuido))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(jRBAcuiVisualPreservado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRBAcuiVisulaDiminuido)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel44.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Acuidade auditiva", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        AcuidadeAuditiva.add(jRBAcuAudiPreservado);
        jRBAcuAudiPreservado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBAcuAudiPreservado.setSelected(true);
        jRBAcuAudiPreservado.setText("Preservado");
        jRBAcuAudiPreservado.setEnabled(false);

        AcuidadeAuditiva.add(jRBAcuidAudDiminuido);
        jRBAcuidAudDiminuido.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBAcuidAudDiminuido.setText("Diminuido");
        jRBAcuidAudDiminuido.setEnabled(false);

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRBAcuAudiPreservado)
                    .addComponent(jRBAcuidAudDiminuido))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addComponent(jRBAcuAudiPreservado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRBAcuidAudDiminuido)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel19, jPanel44});

        jTabbedPane4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Quais?");

        jQuaisDrogas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQuaisDrogas.setEnabled(false);

        jQuaisDoencas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQuaisDoencas.setEnabled(false);

        jQuaisAlergias.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQuaisAlergias.setEnabled(false);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Quais?");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Quais?");

        jComboBoxPortadorDoencas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxPortadorDoencas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxPortadorDoencas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxPortadorDoencas.setEnabled(false);

        jComboBoxAlergias.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxAlergias.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxAlergias.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxAlergias.setEnabled(false);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Alergias?");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Usuário de drogas?");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Portador de alguma doença?");

        jComboBoxUsuarioDrogas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxUsuarioDrogas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxUsuarioDrogas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxUsuarioDrogas.setEnabled(false);

        javax.swing.GroupLayout jPanel60Layout = new javax.swing.GroupLayout(jPanel60);
        jPanel60.setLayout(jPanel60Layout);
        jPanel60Layout.setHorizontalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel60Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel60Layout.createSequentialGroup()
                        .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxPortadorDoencas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxUsuarioDrogas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel60Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jQuaisDrogas, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel60Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jQuaisAlergias)
                                    .addComponent(jQuaisDoencas, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel60Layout.createSequentialGroup()
                        .addComponent(jComboBoxAlergias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel19)))
                .addContainerGap())
        );
        jPanel60Layout.setVerticalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel60Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel14)
                    .addComponent(jComboBoxUsuarioDrogas, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jQuaisDrogas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel16)
                    .addComponent(jComboBoxPortadorDoencas, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jQuaisDoencas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel18)
                    .addComponent(jComboBoxAlergias, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(jQuaisAlergias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel60Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jQuaisAlergias, jQuaisDoencas, jQuaisDrogas});

        jTabbedPane4.addTab("Drogas", jPanel60);

        jObservacao.setColumns(20);
        jObservacao.setRows(5);
        jObservacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jObservacao.setEnabled(false);
        jScrollPane1.setViewportView(jObservacao);

        javax.swing.GroupLayout jPanel61Layout = new javax.swing.GroupLayout(jPanel61);
        jPanel61.setLayout(jPanel61Layout);
        jPanel61Layout.setHorizontalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel61Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel61Layout.setVerticalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel61Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane4.addTab("Evolução da Admissão", new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/composer-preferences-icone-5121-16.png")), jPanel61); // NOI18N

        javax.swing.GroupLayout ContinuacaoLayout = new javax.swing.GroupLayout(Continuacao);
        Continuacao.setLayout(ContinuacaoLayout);
        ContinuacaoLayout.setHorizontalGroup(
            ContinuacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContinuacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ContinuacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jTabbedPane4))
                .addContainerGap())
        );
        ContinuacaoLayout.setVerticalGroup(
            ContinuacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContinuacaoLayout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane4)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Continuação", Continuacao);

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Antecedentes Pessoais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel37.setText("Hipertesão arterial crônica?");

        jComboBoxHipertensao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxHipertensao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim", "Não Sei" }));
        jComboBoxHipertensao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxHipertensao.setEnabled(false);

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel38.setText("Cadiopatias?");

        jComboBoxCardiopatias.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxCardiopatias.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim", "Não Sei" }));
        jComboBoxCardiopatias.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxCardiopatias.setEnabled(false);

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel39.setText("Diabetes mellitus?");

        jComboBoxDiabetes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDiabetes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim", "Não Sei" }));
        jComboBoxDiabetes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDiabetes.setEnabled(false);

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel40.setText("Anemias?");

        jComboBoxAnemias.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxAnemias.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim", "Não Sei" }));
        jComboBoxAnemias.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxAnemias.setEnabled(false);

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel41.setText("Alergias?");

        jComboBoxAPAlergias.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxAPAlergias.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim", "Não Sei" }));
        jComboBoxAPAlergias.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxAPAlergias.setEnabled(false);

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel43.setText("Doenças renais crônicas?");

        jComboBoxDoencasRenais.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDoencasRenais.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim", "Não Sei" }));
        jComboBoxDoencasRenais.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDoencasRenais.setEnabled(false);

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel44.setText("Portadora de infecção HIV?");

        jComboBoxPortadorHIV.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxPortadorHIV.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim", "Não Sei" }));
        jComboBoxPortadorHIV.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxPortadorHIV.setEnabled(false);

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel45.setText("Transfusões de sangue?");

        jComboBoxTransfusao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTransfusao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim", "Não Sei" }));
        jComboBoxTransfusao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTransfusao.setEnabled(false);

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel46.setText("Uso de retroviarias?");

        jComboBoxRetroviarias.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxRetroviarias.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim", "Não Sei" }));
        jComboBoxRetroviarias.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxRetroviarias.setEnabled(false);

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel47.setText("Quais?");

        jQuaisRetroviarias.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQuaisRetroviarias.setEnabled(false);

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel48.setText("Cirurgia?");

        jComboBoxCirurgias.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxCirurgias.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim", "Não Sei" }));
        jComboBoxCirurgias.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxCirurgias.setEnabled(false);

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel51.setText("Data Cirurgia?");

        jDataCirurgia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataCirurgia.setEnabled(false);

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel49.setText("Tipo Cirurgia?");

        jTipoCirurgia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTipoCirurgia.setEnabled(false);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel49)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTipoCirurgia, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel43)
                            .addComponent(jLabel37)
                            .addComponent(jLabel46)
                            .addComponent(jLabel44)
                            .addComponent(jLabel48))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBoxDoencasRenais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jComboBoxHipertensao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                                                .addComponent(jLabel38)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jComboBoxCardiopatias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                                                .addComponent(jLabel39)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jComboBoxDiabetes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel40, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel41, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel13Layout.createSequentialGroup()
                                            .addComponent(jComboBoxPortadorHIV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(243, 243, 243))
                                        .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.TRAILING)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxTransfusao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxAPAlergias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxAnemias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jComboBoxRetroviarias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel47)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jQuaisRetroviarias))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jComboBoxCirurgias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(140, 140, 140)
                                .addComponent(jLabel51)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jDataCirurgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(20, 20, 20))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxAnemias, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40)
                    .addComponent(jComboBoxCardiopatias, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38)
                    .addComponent(jComboBoxHipertensao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel43)
                    .addComponent(jComboBoxDoencasRenais, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39)
                    .addComponent(jComboBoxDiabetes, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41)
                    .addComponent(jComboBoxAPAlergias, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel44)
                    .addComponent(jComboBoxPortadorHIV, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45)
                    .addComponent(jComboBoxTransfusao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jQuaisRetroviarias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel47)
                    .addComponent(jComboBoxRetroviarias, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel48)
                    .addComponent(jComboBoxCirurgias, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel51)
                    .addComponent(jDataCirurgia, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(jTipoCirurgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel49.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtNovoAFP1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoAFP1.setText("Novo");
        jBtNovoAFP1.setContentAreaFilled(false);
        jBtNovoAFP1.setEnabled(false);
        jBtNovoAFP1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovoAFP1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovoAFP1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovoAFP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoAFP1ActionPerformed(evt);
            }
        });

        jBtAlterarAFP1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarAFP1.setText("Alterar");
        jBtAlterarAFP1.setContentAreaFilled(false);
        jBtAlterarAFP1.setEnabled(false);
        jBtAlterarAFP1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterarAFP1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarAFP1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarAFP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarAFP1ActionPerformed(evt);
            }
        });

        jBtExcluirAFP1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirAFP1.setText("Excluir");
        jBtExcluirAFP1.setContentAreaFilled(false);
        jBtExcluirAFP1.setEnabled(false);
        jBtExcluirAFP1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluirAFP1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirAFP1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirAFP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirAFP1ActionPerformed(evt);
            }
        });

        jBtCancelarAFP1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarAFP1.setText("Cancelar");
        jBtCancelarAFP1.setContentAreaFilled(false);
        jBtCancelarAFP1.setEnabled(false);
        jBtCancelarAFP1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelarAFP1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarAFP1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarAFP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarAFP1ActionPerformed(evt);
            }
        });

        jBtSalvarAFP1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarAFP1.setText("Gravar");
        jBtSalvarAFP1.setContentAreaFilled(false);
        jBtSalvarAFP1.setEnabled(false);
        jBtSalvarAFP1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvarAFP1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarAFP1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarAFP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarAFP1ActionPerformed(evt);
            }
        });

        jBtSairAFP1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSairAFP1.setText("Sair");
        jBtSairAFP1.setContentAreaFilled(false);
        jBtSairAFP1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSairAFP1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSairAFP1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSairAFP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairAFP1ActionPerformed(evt);
            }
        });

        jBtAuditoriaAFP1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaAFP1.setToolTipText("Auditoria");
        jBtAuditoriaAFP1.setContentAreaFilled(false);
        jBtAuditoriaAFP1.setEnabled(false);
        jBtAuditoriaAFP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaAFP1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addComponent(jBtNovoAFP1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarAFP1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirAFP1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarAFP1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelarAFP1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSairAFP1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaAFP1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtAuditoriaAFP1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtNovoAFP1)
                    .addComponent(jBtAlterarAFP1)
                    .addComponent(jBtExcluirAFP1)
                    .addComponent(jBtSalvarAFP1)
                    .addComponent(jBtCancelarAFP1)
                    .addComponent(jBtSairAFP1))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Antecedentes Ginecológicos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        jTabbedPane3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel53.setText("Ciclos menstruais (Duração, intervalo e regularidade)");

        jCiclosMenstruais.setColumns(20);
        jCiclosMenstruais.setRows(5);
        jCiclosMenstruais.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCiclosMenstruais.setEnabled(false);
        jScrollPane5.setViewportView(jCiclosMenstruais);

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel48Layout.createSequentialGroup()
                        .addComponent(jLabel53)
                        .addGap(0, 236, Short.MAX_VALUE))
                    .addComponent(jScrollPane5))
                .addContainerGap())
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel53)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Ciclos", jPanel48);

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel54.setText("Uso de métodos anticoncepcionais prévios (Quais, por quanto tempo e motivo do abandono)");

        jScrollPane6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jMetodosAnticoncepcionais.setColumns(20);
        jMetodosAnticoncepcionais.setRows(5);
        jMetodosAnticoncepcionais.setEnabled(false);
        jScrollPane6.setViewportView(jMetodosAnticoncepcionais);

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel50Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel54)
                .addGap(35, 35, 35))
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel54)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Metódos", jPanel50);

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel55.setText("Doenças sexualmente transmissíveis (Tratamento realizados, inclusive pelo parceiro)");

        jScrollPane7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jDoencasSexualmenteTransmissiveis.setColumns(20);
        jDoencasSexualmenteTransmissiveis.setRows(5);
        jDoencasSexualmenteTransmissiveis.setEnabled(false);
        jScrollPane7.setViewportView(jDoencasSexualmenteTransmissiveis);

        javax.swing.GroupLayout jPanel51Layout = new javax.swing.GroupLayout(jPanel51);
        jPanel51.setLayout(jPanel51Layout);
        jPanel51Layout.setHorizontalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel51Layout.createSequentialGroup()
                        .addComponent(jLabel55)
                        .addGap(0, 53, Short.MAX_VALUE))
                    .addComponent(jScrollPane7))
                .addContainerGap())
        );
        jPanel51Layout.setVerticalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel55)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Doenças", jPanel51);

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel56.setText("Última colpocitologia oncótica (Papanicolau ou \"preventiva\"), data e resultado");

        jScrollPane8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jColpocitologiaOncotica.setColumns(20);
        jColpocitologiaOncotica.setRows(5);
        jColpocitologiaOncotica.setEnabled(false);
        jScrollPane8.setViewportView(jColpocitologiaOncotica);

        javax.swing.GroupLayout jPanel52Layout = new javax.swing.GroupLayout(jPanel52);
        jPanel52.setLayout(jPanel52Layout);
        jPanel52Layout.setHorizontalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel52Layout.createSequentialGroup()
                        .addComponent(jLabel56)
                        .addGap(0, 94, Short.MAX_VALUE))
                    .addComponent(jScrollPane8))
                .addContainerGap())
        );
        jPanel52Layout.setVerticalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel56)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Colpocitologia Oncótica", jPanel52);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3)
        );

        javax.swing.GroupLayout AEFP1Layout = new javax.swing.GroupLayout(AEFP1);
        AEFP1.setLayout(AEFP1Layout);
        AEFP1Layout.setHorizontalGroup(
            AEFP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AEFP1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AEFP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 572, Short.MAX_VALUE)
                    .addComponent(jPanel49, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        AEFP1Layout.setVerticalGroup(
            AEFP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AEFP1Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("A.E.F. - P1", AEFP1);

        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Antecedentes Obstétricos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 153, 0))); // NOI18N

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel57.setText("Números de gestações (Incluíndo abordos, gravidez ectópica)");

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel58.setText("Número partos (Domiciliares, hospitalares, vaginais espotâneos, cesáreas - indicações)");

        jNumeroPartos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNumeroPartos.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jNumeroPartos.setEnabled(false);

        jNumeroGestacoes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNumeroGestacoes.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jNumeroGestacoes.setEnabled(false);

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel60.setText("Número de abortamentos (Espontâneos, provocados, causados por DST, complicados...)");
        jLabel60.setToolTipText("Número de abortos (Espontâneos, provocados, causados por DST, complicados por infecções, curetagem pós-abortamento)");

        jNumeroAbortos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNumeroAbortos.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jNumeroAbortos.setEnabled(false);

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel61.setText("Núm. filhos vivos?");

        jNumeroFilhosVivos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNumeroFilhosVivos.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jNumeroFilhosVivos.setEnabled(false);

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel62.setText("Idade 1ª gestação?");

        jIdadePrimeiraGestacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdadePrimeiraGestacao.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdadePrimeiraGestacao.setEnabled(false);

        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel64.setText("Intervalo entre as gestações?");

        jIntervaloGestacoes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIntervaloGestacoes.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIntervaloGestacoes.setEnabled(false);

        jPanel53.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Número de Recém nascidos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        jLabel67.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel67.setText("Pré-termo:");
        jLabel67.setToolTipText("Antes da 37ª semana de gestação");

        jPretermo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPretermo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPretermo.setEnabled(false);

        jLabel68.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel68.setText("Pós-termo:");
        jLabel68.setToolTipText("Igual ou mais de 42 semanas de gestação");

        jPostermo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPostermo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPostermo.setEnabled(false);

        jLabel69.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel69.setText("Baixo Peso:");

        jBaixoPeso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jBaixoPeso.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jBaixoPeso.setToolTipText("Menos de 2.500g e Com mais de 4.000g");
        jBaixoPeso.setEnabled(false);

        jLabel70.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel70.setText("Mortes neonatais precoce:");

        jMortesNeonataisPrecoce.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMortesNeonataisPrecoce.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jMortesNeonataisPrecoce.setToolTipText("Entre 7 e 28 dias de vida");
        jMortesNeonataisPrecoce.setEnabled(false);

        jLabel71.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel71.setText("Motivo:");

        jMotivoMorteNeonataisPrecoce.setToolTipText("Motivo de óbitos do neonatais");
        jMotivoMorteNeonataisPrecoce.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMotivoMorteNeonataisPrecoce.setEnabled(false);

        jLabel72.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel72.setText("Mortes neonatais tardias:");

        jMortesNeonataisTardias.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMortesNeonataisTardias.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jMortesNeonataisTardias.setToolTipText("Entre 7 e 28 dias de vida");
        jMortesNeonataisTardias.setEnabled(false);

        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel73.setText("Motivo:");

        jMotivoMortesNeonataisTardias.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMotivoMortesNeonataisTardias.setEnabled(false);

        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel74.setText("Natimortos:");

        jNatimortos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNatimortos.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jNatimortos.setToolTipText("Morte fetal intra-útero e idade gestacional em que ocorreu");
        jNatimortos.setEnabled(false);

        jLabel75.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel75.setText("Icterícia:");

        jIctericia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIctericia.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIctericia.setToolTipText("");
        jIctericia.setEnabled(false);

        jLabel76.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel76.setText("Transfusão:");

        jTransfusao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTransfusao.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTransfusao.setToolTipText("");
        jTransfusao.setEnabled(false);

        jLabel77.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel77.setText("Hipoglicemia:");

        jHipoglicemia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHipoglicemia.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jHipoglicemia.setToolTipText("");
        jHipoglicemia.setEnabled(false);

        javax.swing.GroupLayout jPanel53Layout = new javax.swing.GroupLayout(jPanel53);
        jPanel53.setLayout(jPanel53Layout);
        jPanel53Layout.setHorizontalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel53Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel71, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel67, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel53Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel72))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel53Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel74)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jNatimortos, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jMortesNeonataisTardias, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel73, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel75, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel53Layout.createSequentialGroup()
                        .addComponent(jIctericia, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel76)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTransfusao, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel77)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jHipoglicemia, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jMotivoMortesNeonataisTardias))
                .addContainerGap())
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel53Layout.createSequentialGroup()
                        .addComponent(jPretermo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel68)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPostermo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel69)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBaixoPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jLabel70)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jMortesNeonataisPrecoce)
                        .addContainerGap())
                    .addGroup(jPanel53Layout.createSequentialGroup()
                        .addComponent(jMotivoMorteNeonataisPrecoce)
                        .addGap(10, 10, 10))))
        );
        jPanel53Layout.setVerticalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel67)
                    .addComponent(jPretermo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel68)
                    .addComponent(jPostermo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel69)
                    .addComponent(jBaixoPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel70)
                    .addComponent(jMortesNeonataisPrecoce, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jMotivoMorteNeonataisPrecoce, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel71))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel72)
                    .addComponent(jMortesNeonataisTardias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel73)
                    .addComponent(jMotivoMortesNeonataisTardias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel74)
                    .addComponent(jNatimortos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel75)
                    .addComponent(jIctericia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel76)
                    .addComponent(jTransfusao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel77)
                    .addComponent(jHipoglicemia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jLabel78.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel78.setText("Intercorrências ou complicações em gestações anteriores");

        jScrollPane9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jIntercorrenciaComplicacoesGestoes.setColumns(20);
        jIntercorrenciaComplicacoesGestoes.setRows(5);
        jIntercorrenciaComplicacoesGestoes.setEnabled(false);
        jScrollPane9.setViewportView(jIntercorrenciaComplicacoesGestoes);

        jLabel79.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel79.setText("História de aleitamentos anteriores (Duração e motivo do desmame)");

        jScrollPane10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jHistoriaAleitamentosAnteriores.setColumns(20);
        jHistoriaAleitamentosAnteriores.setRows(5);
        jHistoriaAleitamentosAnteriores.setEnabled(false);
        jScrollPane10.setViewportView(jHistoriaAleitamentosAnteriores);

        jLabel113.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel113.setText("Isoimunização RH:");

        jIsoimunizacaoRH.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIsoimunizacaoRH.setEnabled(false);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel57)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jNumeroGestacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel21Layout.createSequentialGroup()
                                        .addComponent(jLabel61)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jNumeroFilhosVivos, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel62)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jIdadePrimeiraGestacao, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel64)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jIntervaloGestacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jNumeroAbortos)
                            .addComponent(jNumeroPartos, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addComponent(jLabel113)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jIsoimunizacaoRH))
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel78)
                                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel79)
                                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(10, 10, 10))
        );

        jPanel21Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jIntervaloGestacoes, jNumeroAbortos, jNumeroFilhosVivos, jNumeroPartos});

        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(jNumeroGestacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(jNumeroPartos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60)
                    .addComponent(jNumeroAbortos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61)
                    .addComponent(jNumeroFilhosVivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel62)
                    .addComponent(jIdadePrimeiraGestacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel64)
                    .addComponent(jIntervaloGestacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel113)
                    .addComponent(jIsoimunizacaoRH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel78)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel79)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel54.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtNovoAFP2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoAFP2.setText("Novo");
        jBtNovoAFP2.setContentAreaFilled(false);
        jBtNovoAFP2.setEnabled(false);
        jBtNovoAFP2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovoAFP2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovoAFP2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovoAFP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoAFP2ActionPerformed(evt);
            }
        });

        jBtAlterarAFP2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarAFP2.setText("Alterar");
        jBtAlterarAFP2.setContentAreaFilled(false);
        jBtAlterarAFP2.setEnabled(false);
        jBtAlterarAFP2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterarAFP2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarAFP2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarAFP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarAFP2ActionPerformed(evt);
            }
        });

        jBtExcluirAFP2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirAFP2.setText("Excluir");
        jBtExcluirAFP2.setContentAreaFilled(false);
        jBtExcluirAFP2.setEnabled(false);
        jBtExcluirAFP2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluirAFP2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirAFP2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirAFP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirAFP2ActionPerformed(evt);
            }
        });

        jBtCancelarAFP2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarAFP2.setText("Cancelar");
        jBtCancelarAFP2.setContentAreaFilled(false);
        jBtCancelarAFP2.setEnabled(false);
        jBtCancelarAFP2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelarAFP2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarAFP2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarAFP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarAFP2ActionPerformed(evt);
            }
        });

        jBtSalvarAFP2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarAFP2.setText("Gravar");
        jBtSalvarAFP2.setContentAreaFilled(false);
        jBtSalvarAFP2.setEnabled(false);
        jBtSalvarAFP2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvarAFP2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarAFP2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarAFP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarAFP2ActionPerformed(evt);
            }
        });

        jBtSairAFP2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSairAFP2.setText("Sair");
        jBtSairAFP2.setContentAreaFilled(false);
        jBtSairAFP2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSairAFP2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSairAFP2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSairAFP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairAFP2ActionPerformed(evt);
            }
        });

        jBtAuditoriaAFP2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaAFP2.setToolTipText("Auditoria");
        jBtAuditoriaAFP2.setContentAreaFilled(false);
        jBtAuditoriaAFP2.setEnabled(false);
        jBtAuditoriaAFP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaAFP2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel54Layout = new javax.swing.GroupLayout(jPanel54);
        jPanel54.setLayout(jPanel54Layout);
        jPanel54Layout.setHorizontalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addComponent(jBtNovoAFP2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarAFP2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirAFP2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarAFP2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelarAFP2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSairAFP2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaAFP2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel54Layout.setVerticalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtAuditoriaAFP2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtNovoAFP2)
                    .addComponent(jBtAlterarAFP2)
                    .addComponent(jBtExcluirAFP2)
                    .addComponent(jBtSalvarAFP2)
                    .addComponent(jBtCancelarAFP2)
                    .addComponent(jBtSairAFP2))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout AEFP2Layout = new javax.swing.GroupLayout(AEFP2);
        AEFP2.setLayout(AEFP2Layout);
        AEFP2Layout.setHorizontalGroup(
            AEFP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AEFP2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AEFP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        AEFP2Layout.setVerticalGroup(
            AEFP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AEFP2Layout.createSequentialGroup()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("A.E.F. - P2", AEFP2);

        jPanel55.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Gestação Atual", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(153, 0, 102))); // NOI18N

        jLabel81.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel81.setText("DUM:");

        jDataUltimaMenstruacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataUltimaMenstruacao.setToolTipText("Data Última Menstruação");
        jDataUltimaMenstruacao.setEnabled(false);

        jLabel85.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel85.setText("Sinais e sintomas na gestação em curso?");

        jLabel86.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel86.setText("Hábitos alimentares:");

        jHabitosAlimentares.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHabitosAlimentares.setEnabled(false);

        jLabel87.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel87.setText("Med. usado gestação:");

        jMedicamentoGestacao.setToolTipText("Medicamentos Usados na Gestação");
        jMedicamentoGestacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMedicamentoGestacao.setEnabled(false);

        jLabel88.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel88.setText("Inte. nessa gestação?");
        jLabel88.setToolTipText("Internação durante esta gestação?");

        jComboBoxInternacaoGestacao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxInternacaoGestacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxInternacaoGestacao.setToolTipText("Internação durante esta gestação?");
        jComboBoxInternacaoGestacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxInternacaoGestacao.setEnabled(false);

        jLabel89.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel89.setText("Onde?");

        jOndeGestacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jOndeGestacao.setEnabled(false);

        jLabel100.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel100.setText("Hábitos:");

        jCheckBoxCigarro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxCigarro.setForeground(new java.awt.Color(255, 0, 0));
        jCheckBoxCigarro.setText("Cigarro");
        jCheckBoxCigarro.setEnabled(false);

        jCheckBoxPacaia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxPacaia.setForeground(new java.awt.Color(0, 0, 255));
        jCheckBoxPacaia.setText("Pacaia");
        jCheckBoxPacaia.setEnabled(false);

        jCheckBoxMaconha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxMaconha.setForeground(new java.awt.Color(153, 204, 0));
        jCheckBoxMaconha.setText("Maconha");
        jCheckBoxMaconha.setEnabled(false);

        jCheckBoxCocaina.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxCocaina.setForeground(new java.awt.Color(153, 0, 102));
        jCheckBoxCocaina.setText("Cocina");
        jCheckBoxCocaina.setEnabled(false);

        jCheckBoxCraque.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxCraque.setText("Craque");
        jCheckBoxCraque.setEnabled(false);

        jCheckBoxOutros.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxOutros.setText("Outros");
        jCheckBoxOutros.setEnabled(false);

        jCheckBoxAlcool.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxAlcool.setForeground(new java.awt.Color(0, 153, 0));
        jCheckBoxAlcool.setText("Álcool");
        jCheckBoxAlcool.setEnabled(false);

        jLabel101.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel101.setText("Qual(ais)?");

        jQuaisDrogras.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQuaisDrogras.setEnabled(false);

        jLabel102.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel102.setText("Ocupação habitual:");

        jScrollPane11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jOcupacaoHabitual.setColumns(20);
        jOcupacaoHabitual.setRows(5);
        jOcupacaoHabitual.setToolTipText("Esforço físico, exposição a agentes químicos físicos potencialmente nocivos, estress.");
        jOcupacaoHabitual.setEnabled(false);
        jScrollPane11.setViewportView(jOcupacaoHabitual);

        jLabel103.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel103.setText("Aceitação da gravidez:");

        jScrollPane12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jAceitacaoGravidez.setColumns(20);
        jAceitacaoGravidez.setRows(5);
        jAceitacaoGravidez.setToolTipText("Aceitação ou não da gravidez pela mulher, parceiro e pela família, principalemnte se for adolescente.");
        jAceitacaoGravidez.setEnabled(false);
        jScrollPane12.setViewportView(jAceitacaoGravidez);

        jLabel114.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel114.setText("Gestante:");

        jComboBoxGestante.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxGestante.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxGestante.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxGestante.setEnabled(false);

        jCertezaDuvidaGestacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCertezaDuvidaGestacao.setEnabled(false);

        jScrollPane14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jSinaisSintomas.setColumns(20);
        jSinaisSintomas.setRows(5);
        jSinaisSintomas.setToolTipText("Esforço físico, exposição a agentes químicos físicos potencialmente nocivos, estress.");
        jSinaisSintomas.setEnabled(false);
        jScrollPane14.setViewportView(jSinaisSintomas);

        javax.swing.GroupLayout jPanel55Layout = new javax.swing.GroupLayout(jPanel55);
        jPanel55.setLayout(jPanel55Layout);
        jPanel55Layout.setHorizontalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel55Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel100)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel55Layout.createSequentialGroup()
                        .addComponent(jCheckBoxOutros)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel101))
                    .addGroup(jPanel55Layout.createSequentialGroup()
                        .addComponent(jCheckBoxCigarro)
                        .addGap(12, 12, 12)
                        .addComponent(jCheckBoxPacaia)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel55Layout.createSequentialGroup()
                        .addComponent(jCheckBoxMaconha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBoxCocaina)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBoxCraque)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBoxAlcool))
                    .addComponent(jQuaisDrogras, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9))
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel55Layout.createSequentialGroup()
                        .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel55Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel86))
                            .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel88)
                                .addComponent(jLabel87)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jMedicamentoGestacao, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jHabitosAlimentares, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel55Layout.createSequentialGroup()
                                .addComponent(jComboBoxInternacaoGestacao, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel89)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jOndeGestacao))))
                    .addGroup(jPanel55Layout.createSequentialGroup()
                        .addComponent(jLabel103)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane12))
                    .addGroup(jPanel55Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel102)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane14, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane11)))
                    .addGroup(jPanel55Layout.createSequentialGroup()
                        .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel85)
                            .addGroup(jPanel55Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel114)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxGestante, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCertezaDuvidaGestacao, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel55Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel81)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDataUltimaMenstruacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel55Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jHabitosAlimentares, jMedicamentoGestacao});

        jPanel55Layout.setVerticalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel81, javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jDataUltimaMenstruacao, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel114)
                    .addComponent(jComboBoxGestante, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCertezaDuvidaGestacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel86)
                    .addComponent(jHabitosAlimentares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel87)
                    .addComponent(jMedicamentoGestacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jOndeGestacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel89)
                    .addComponent(jComboBoxInternacaoGestacao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel88))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel100)
                    .addComponent(jCheckBoxCigarro)
                    .addComponent(jCheckBoxPacaia)
                    .addComponent(jCheckBoxMaconha)
                    .addComponent(jCheckBoxCocaina)
                    .addComponent(jCheckBoxCraque)
                    .addComponent(jCheckBoxAlcool))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxOutros)
                    .addComponent(jLabel101)
                    .addComponent(jQuaisDrogras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel85)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel102))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel103)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel56.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtNovoAFP3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoAFP3.setText("Novo");
        jBtNovoAFP3.setContentAreaFilled(false);
        jBtNovoAFP3.setEnabled(false);
        jBtNovoAFP3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovoAFP3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovoAFP3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovoAFP3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoAFP3ActionPerformed(evt);
            }
        });

        jBtAlterarAFP3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarAFP3.setText("Alterar");
        jBtAlterarAFP3.setContentAreaFilled(false);
        jBtAlterarAFP3.setEnabled(false);
        jBtAlterarAFP3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterarAFP3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarAFP3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarAFP3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarAFP3ActionPerformed(evt);
            }
        });

        jBtExcluirAFP3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirAFP3.setText("Excluir");
        jBtExcluirAFP3.setContentAreaFilled(false);
        jBtExcluirAFP3.setEnabled(false);
        jBtExcluirAFP3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluirAFP3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirAFP3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirAFP3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirAFP3ActionPerformed(evt);
            }
        });

        jBtCancelarAFP3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarAFP3.setText("Cancelar");
        jBtCancelarAFP3.setContentAreaFilled(false);
        jBtCancelarAFP3.setEnabled(false);
        jBtCancelarAFP3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelarAFP3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarAFP3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarAFP3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarAFP3ActionPerformed(evt);
            }
        });

        jBtSalvarAFP3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarAFP3.setText("Gravar");
        jBtSalvarAFP3.setContentAreaFilled(false);
        jBtSalvarAFP3.setEnabled(false);
        jBtSalvarAFP3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvarAFP3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarAFP3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarAFP3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarAFP3ActionPerformed(evt);
            }
        });

        jBtSairAFP3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSairAFP3.setText("Sair");
        jBtSairAFP3.setContentAreaFilled(false);
        jBtSairAFP3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSairAFP3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSairAFP3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSairAFP3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairAFP3ActionPerformed(evt);
            }
        });

        jBtAuditoriaAFP3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaAFP3.setToolTipText("Auditoria");
        jBtAuditoriaAFP3.setContentAreaFilled(false);
        jBtAuditoriaAFP3.setEnabled(false);
        jBtAuditoriaAFP3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaAFP3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel56Layout = new javax.swing.GroupLayout(jPanel56);
        jPanel56.setLayout(jPanel56Layout);
        jPanel56Layout.setHorizontalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel56Layout.createSequentialGroup()
                .addComponent(jBtNovoAFP3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarAFP3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirAFP3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarAFP3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelarAFP3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSairAFP3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaAFP3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel56Layout.setVerticalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel56Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtAuditoriaAFP3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel56Layout.createSequentialGroup()
                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtNovoAFP3)
                    .addComponent(jBtAlterarAFP3)
                    .addComponent(jBtExcluirAFP3)
                    .addComponent(jBtSalvarAFP3)
                    .addComponent(jBtCancelarAFP3)
                    .addComponent(jBtSairAFP3))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout AEFP3Layout = new javax.swing.GroupLayout(AEFP3);
        AEFP3.setLayout(AEFP3Layout);
        AEFP3Layout.setHorizontalGroup(
            AEFP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AEFP3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AEFP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        AEFP3Layout.setVerticalGroup(
            AEFP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AEFP3Layout.createSequentialGroup()
                .addComponent(jPanel55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel56, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("A.E.F. - P3", AEFP3);

        jPanel57.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Exame Físico", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel104.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel104.setText("Peso:");

        jPesoGestante.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPesoGestante.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPesoGestante.setEnabled(false);

        jLabel105.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel105.setText("Altura:");

        jAlturaGestante.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAlturaGestante.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jAlturaGestante.setEnabled(false);

        jLabel107.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel107.setText("Inspeção da pele/mucosa:");

        jLabel108.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel108.setText("Palpação de tireóide, pescoço, região cervical e axilar (pesquisa nódulos/outras anormalidades)");
        jLabel108.setToolTipText("Palpação de tireóide e do pescoço, região cervical e axilar (pesquisa de nódulos ou outras anormalidades)");

        jPalpacaoTireoide.setColumns(20);
        jPalpacaoTireoide.setRows(5);
        jPalpacaoTireoide.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPalpacaoTireoide.setEnabled(false);
        jScrollPane13.setViewportView(jPalpacaoTireoide);

        jLabel110.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel110.setText("Exame abdonem:");

        jLabel112.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel112.setText("Pesquisa de Edema:");

        jCheckBoxFace.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxFace.setText(" Face");
        jCheckBoxFace.setEnabled(false);

        jCheckBoxTronco.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxTronco.setText("Tronco");
        jCheckBoxTronco.setEnabled(false);

        jCheckBoxMembroInferior.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxMembroInferior.setText("MMII");
        jCheckBoxMembroInferior.setToolTipText("Membros Inferiores");
        jCheckBoxMembroInferior.setEnabled(false);

        jInspecaoPeleMucosa.setColumns(20);
        jInspecaoPeleMucosa.setRows(5);
        jInspecaoPeleMucosa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jInspecaoPeleMucosa.setEnabled(false);
        jScrollPane15.setViewportView(jInspecaoPeleMucosa);

        jCheckBoxMembroSuperior.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxMembroSuperior.setText("MMSS");
        jCheckBoxMembroSuperior.setToolTipText("membros Superiores");
        jCheckBoxMembroSuperior.setEnabled(false);

        jScrollPane16.setViewportBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jExameAbdomem.setColumns(20);
        jExameAbdomem.setRows(5);
        jExameAbdomem.setEnabled(false);
        jScrollPane16.setViewportView(jExameAbdomem);

        jLabel80.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel80.setText("Altura uterina:");

        jLabel82.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel82.setText("Posição fetal:");

        jScrollPane17.setViewportBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jPosicaoFetal.setColumns(20);
        jPosicaoFetal.setRows(5);
        jPosicaoFetal.setEnabled(false);
        jScrollPane17.setViewportView(jPosicaoFetal);

        jAlturaUterina.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAlturaUterina.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jAlturaUterina.setToolTipText("Altura em cm");
        jAlturaUterina.setEnabled(false);

        jLabel83.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel83.setText("Cm");

        javax.swing.GroupLayout jPanel57Layout = new javax.swing.GroupLayout(jPanel57);
        jPanel57.setLayout(jPanel57Layout);
        jPanel57Layout.setHorizontalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel57Layout.createSequentialGroup()
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel57Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane17))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel57Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel104)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPesoGestante, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel105)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jAlturaGestante, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel112)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBoxFace)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxTronco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxMembroInferior)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBoxMembroSuperior))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel57Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane15)
                            .addGroup(jPanel57Layout.createSequentialGroup()
                                .addComponent(jLabel107)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel57Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane16)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel57Layout.createSequentialGroup()
                                .addComponent(jLabel110)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel57Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel57Layout.createSequentialGroup()
                                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel108))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel57Layout.createSequentialGroup()
                                .addComponent(jLabel82)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel80)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jAlturaUterina, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel83)
                                .addGap(5, 5, 5)))))
                .addContainerGap())
        );
        jPanel57Layout.setVerticalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jCheckBoxMembroSuperior)
                    .addComponent(jCheckBoxMembroInferior)
                    .addComponent(jCheckBoxTronco)
                    .addComponent(jCheckBoxFace)
                    .addComponent(jLabel112)
                    .addComponent(jAlturaGestante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel105)
                    .addComponent(jPesoGestante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel104))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel107)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel108)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel110)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel80)
                    .addComponent(jLabel82)
                    .addComponent(jAlturaUterina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel83))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel58.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtNovoAFP4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoAFP4.setText("Novo");
        jBtNovoAFP4.setContentAreaFilled(false);
        jBtNovoAFP4.setEnabled(false);
        jBtNovoAFP4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovoAFP4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovoAFP4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovoAFP4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoAFP4ActionPerformed(evt);
            }
        });

        jBtAlterarAFP4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarAFP4.setText("Alterar");
        jBtAlterarAFP4.setContentAreaFilled(false);
        jBtAlterarAFP4.setEnabled(false);
        jBtAlterarAFP4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterarAFP4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarAFP4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarAFP4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarAFP4ActionPerformed(evt);
            }
        });

        jBtExcluirAFP4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirAFP4.setText("Excluir");
        jBtExcluirAFP4.setContentAreaFilled(false);
        jBtExcluirAFP4.setEnabled(false);
        jBtExcluirAFP4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluirAFP4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirAFP4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirAFP4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirAFP4ActionPerformed(evt);
            }
        });

        jBtCancelarAFP4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarAFP4.setText("Cancelar");
        jBtCancelarAFP4.setContentAreaFilled(false);
        jBtCancelarAFP4.setEnabled(false);
        jBtCancelarAFP4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelarAFP4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarAFP4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarAFP4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarAFP4ActionPerformed(evt);
            }
        });

        jBtSalvarAFP4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarAFP4.setText("Gravar");
        jBtSalvarAFP4.setContentAreaFilled(false);
        jBtSalvarAFP4.setEnabled(false);
        jBtSalvarAFP4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvarAFP4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarAFP4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarAFP4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarAFP4ActionPerformed(evt);
            }
        });

        jBtSairAFP4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSairAFP4.setText("Sair");
        jBtSairAFP4.setContentAreaFilled(false);
        jBtSairAFP4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSairAFP4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSairAFP4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSairAFP4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairAFP4ActionPerformed(evt);
            }
        });

        jBtAuditoriaAFP4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaAFP4.setToolTipText("Auditoria");
        jBtAuditoriaAFP4.setContentAreaFilled(false);
        jBtAuditoriaAFP4.setEnabled(false);
        jBtAuditoriaAFP4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaAFP4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel58Layout = new javax.swing.GroupLayout(jPanel58);
        jPanel58.setLayout(jPanel58Layout);
        jPanel58Layout.setHorizontalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addComponent(jBtNovoAFP4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarAFP4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirAFP4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarAFP4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelarAFP4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSairAFP4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaAFP4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel58Layout.setVerticalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtAuditoriaAFP4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtNovoAFP4)
                    .addComponent(jBtAlterarAFP4)
                    .addComponent(jBtExcluirAFP4)
                    .addComponent(jBtSalvarAFP4)
                    .addComponent(jBtCancelarAFP4)
                    .addComponent(jBtSairAFP4))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout AEFP4Layout = new javax.swing.GroupLayout(AEFP4);
        AEFP4.setLayout(AEFP4Layout);
        AEFP4Layout.setHorizontalGroup(
            AEFP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AEFP4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AEFP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        AEFP4Layout.setVerticalGroup(
            AEFP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AEFP4Layout.createSequentialGroup()
                .addComponent(jPanel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel58, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("A.E.F. - P4", AEFP4);

        jTabelaEvolucaoEnfermagem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaEvolucaoEnfermagem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Seq.", "Data", "Evolução"
            }
        ));
        jTabelaEvolucaoEnfermagem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaEvolucaoEnfermagemMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTabelaEvolucaoEnfermagem);
        if (jTabelaEvolucaoEnfermagem.getColumnModel().getColumnCount() > 0) {
            jTabelaEvolucaoEnfermagem.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaEvolucaoEnfermagem.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaEvolucaoEnfermagem.getColumnModel().getColumn(1).setMinWidth(80);
            jTabelaEvolucaoEnfermagem.getColumnModel().getColumn(1).setMaxWidth(80);
            jTabelaEvolucaoEnfermagem.getColumnModel().getColumn(2).setMinWidth(440);
            jTabelaEvolucaoEnfermagem.getColumnModel().getColumn(2).setMaxWidth(440);
        }

        jPanel40.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Interno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        jIdEvolucao.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdEvolucao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdEvolucao.setEnabled(false);

        jNomeInternoEvolEnf.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoEvolEnf.setEnabled(false);

        jLabel97.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel97.setText("Código");

        jLabel98.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel98.setText("Nome Completo do Interno");

        jLabel99.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel99.setText("Data");

        jDataEvolu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataEvolu.setEnabled(false);

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel97)
                    .addComponent(jIdEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addComponent(jLabel98)
                        .addGap(0, 202, Short.MAX_VALUE))
                    .addComponent(jNomeInternoEvolEnf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel99)
                    .addComponent(jDataEvolu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel40Layout.createSequentialGroup()
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel97)
                    .addComponent(jLabel98)
                    .addComponent(jLabel99))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jIdEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jNomeInternoEvolEnf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDataEvolu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTextoEvolucao.setColumns(20);
        jTextoEvolucao.setRows(5);
        jTextoEvolucao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextoEvolucao.setEnabled(false);
        jScrollPane4.setViewportView(jTextoEvolucao);

        jBtNovaEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovaEvolucao.setToolTipText("Novo");
        jBtNovaEvolucao.setEnabled(false);
        jBtNovaEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovaEvolucaoActionPerformed(evt);
            }
        });

        jBtAlterarEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarEvolucao.setToolTipText("Alterar");
        jBtAlterarEvolucao.setEnabled(false);
        jBtAlterarEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarEvolucaoActionPerformed(evt);
            }
        });

        jBtExcluirEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirEvolucao.setToolTipText("Excluir");
        jBtExcluirEvolucao.setEnabled(false);
        jBtExcluirEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirEvolucaoActionPerformed(evt);
            }
        });

        jBtSalvarEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarEvolucao.setToolTipText("Gravar");
        jBtSalvarEvolucao.setEnabled(false);
        jBtSalvarEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarEvolucaoActionPerformed(evt);
            }
        });

        jBtCancelarEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarEvolucao.setToolTipText("Cancelar");
        jBtCancelarEvolucao.setEnabled(false);
        jBtCancelarEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarEvolucaoActionPerformed(evt);
            }
        });

        jBtAuditoriaEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaEvolucao.setToolTipText("Auditoria");
        jBtAuditoriaEvolucao.setContentAreaFilled(false);
        jBtAuditoriaEvolucao.setEnabled(false);
        jBtAuditoriaEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaEvolucaoActionPerformed(evt);
            }
        });

        jBtImpressao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/gtklp-icone-3770-16.png"))); // NOI18N
        jBtImpressao.setToolTipText("Imprimir Evolução");
        jBtImpressao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtImpressaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EvolucaoLayout = new javax.swing.GroupLayout(Evolucao);
        Evolucao.setLayout(EvolucaoLayout);
        EvolucaoLayout.setHorizontalGroup(
            EvolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EvolucaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EvolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
                    .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(EvolucaoLayout.createSequentialGroup()
                        .addComponent(jBtNovaEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtAlterarEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtExcluirEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSalvarEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtCancelarEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtImpressao, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(125, 125, 125)
                        .addComponent(jBtAuditoriaEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4))
                .addContainerGap())
        );

        EvolucaoLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterarEvolucao, jBtCancelarEvolucao, jBtExcluirEvolucao, jBtImpressao, jBtNovaEvolucao, jBtSalvarEvolucao});

        EvolucaoLayout.setVerticalGroup(
            EvolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EvolucaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(EvolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtImpressao)
                    .addComponent(jBtNovaEvolucao)
                    .addComponent(jBtAlterarEvolucao)
                    .addComponent(jBtExcluirEvolucao)
                    .addComponent(jBtSalvarEvolucao)
                    .addComponent(jBtCancelarEvolucao)
                    .addComponent(jBtAuditoriaEvolucao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addContainerGap())
        );

        EvolucaoLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterarEvolucao, jBtCancelarEvolucao, jBtExcluirEvolucao, jBtImpressao, jBtNovaEvolucao, jBtSalvarEvolucao});

        jTabbedPane1.addTab("Evolução", Evolucao);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(300, 10, 610, 538);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAdmissaoEnfeIntManuENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaAdmissaoEnfeIntManuENF) && codIncluirENF == 1) {
            acao = 1;
            bloquearCampos();
            Novo();
            corCampos();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAdmissaoEnfeIntManuENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaAdmissaoEnfeIntManuENF) && codAlterarENF == 1) {
            objAdmEnfermagem.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse antedimento não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 2;
                bloquearCampos();
                Alterar();
                corCampos();
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtAlterarActionPerformed

    private void jBtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAdmissaoEnfeIntManuENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaAdmissaoEnfeIntManuENF) && codExcluirENF == 1) {
            verificarEvolucao();
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            objAdmEnfermagem.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse antedimento não poderá ser excluída, o mesmo encontra-se FINALIZADO");
            } else {
                if (jIdLanc.getText().equals(codEvolucao)) {
                    JOptionPane.showMessageDialog(rootPane, "Esse registro não pode ser EXCLUÍDO.");
                } else {
                    int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o atendimento selecionado?", "Confirmação",
                            JOptionPane.YES_NO_OPTION);
                    if (resposta == JOptionPane.YES_OPTION) {
                        objAdmEnfermagem.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                        control.excluiAdmissaoEnfermagem(objAdmEnfermagem);
                        objAdmEnfermagem.setNomeInterno(jNomeInternoMedico.getText());;
                        objAdmEnfermagem.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                        controle.excluirMovTec(objAdmEnfermagem);
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                        Excluir();
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAdmissaoEnfeIntManuENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaAdmissaoEnfeIntManuENF) && codGravarENF == 1) {
            if (jDataLanc.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data do atendimento.");
                jDataLanc.requestFocus();
                jDataLanc.setBackground(Color.red);
            } else if (jNomeInternoMedico.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome do interno para atendimento.");
                jNomeInternoMedico.requestFocus();
                jNomeInternoMedico.setBackground(Color.red);
            } else {
                compararRadioButtons(); // Compara qual botão foi assionado pelo usuário
                objAdmEnfermagem.setStatusLanc(statusLanc);
                objAdmEnfermagem.setDataLanc(jDataLanc.getDate());
                objAdmEnfermagem.setEstadoEmocional(statusEstadoEmocional);
                objAdmEnfermagem.setSonoRepouso(statusSonoRepouso);
                objAdmEnfermagem.setPressaoArterial(jPressaoArterial.getText());
                objAdmEnfermagem.setHemograma(jHemograma.getText());
                objAdmEnfermagem.setTemperatura(jTemperatura.getText());
                objAdmEnfermagem.setFrequenciaRespitatoria(jFrequenciaRespira.getText());
                objAdmEnfermagem.setPeso(jPeso.getText());
                objAdmEnfermagem.setFrequenciaCardiaca(jFrequenciaCardiaca.getText());
                objAdmEnfermagem.setNivelConciencia(statusNivelConsciencia);
                objAdmEnfermagem.setUsaMedicamentos((String) jComboBoxUsuarioDrogas.getSelectedItem());
                objAdmEnfermagem.setQualMedicacao(jQualMedicamento.getText());
                objAdmEnfermagem.setLocomocao(statusLocomocao);
                objAdmEnfermagem.setAcuidadeVisual(statusAcuidadeVisual);
                objAdmEnfermagem.setAcuidadeAuditiva(statusAcuidadeAuditiva);
                objAdmEnfermagem.setFuncaoMotora(statusFuncaoMotora);
                objAdmEnfermagem.setQualFuncaoMotora(jQualFuncaoMotora.getText());
                objAdmEnfermagem.setFalaLinguagem(statusFalaLinguagem);
                objAdmEnfermagem.setQualFala(jQualAlteracaoFala.getText());
                objAdmEnfermagem.setPele(statusPele);
                objAdmEnfermagem.setMucosa(statusMucosa);
                objAdmEnfermagem.setTipoPele(jTipo.getText());
                objAdmEnfermagem.setLocalizacao(jLocalizacao.getText());
                objAdmEnfermagem.setCabelos(statusCabelos);
                objAdmEnfermagem.setBoca(statusBoca);
                objAdmEnfermagem.setFuncaoRespiratoria(statusFuncaoRespiratoria);
                objAdmEnfermagem.setTorax(statusTorax);
                objAdmEnfermagem.setFuncaoIntestinal(statusFuncaoIntestinal);
                objAdmEnfermagem.setDiasConstipado(jCostipacaoDias.getText());
                objAdmEnfermagem.setAbdome(statusAbdome);
                objAdmEnfermagem.setFuncaoVesical(statusFuncaoVesical);
                objAdmEnfermagem.setGenitalia(statusGenitalia);
                objAdmEnfermagem.setQualGenitalia(jQualGenitalia.getText());
                objAdmEnfermagem.setVacinado((String) jComboBoxVacinado.getSelectedItem());
                objAdmEnfermagem.setQuaisVacinas(jQuaisVacinas.getText());
                objAdmEnfermagem.setVdrl((String) jComboBoxVDRL.getSelectedItem());
                objAdmEnfermagem.setHepatiteC((String) jComboBoxHepatiteC.getSelectedItem());
                objAdmEnfermagem.setHepatiteB((String) jComboBoxHepatiteB.getSelectedItem());
                objAdmEnfermagem.setHiv((String) jComboBoxHIV.getSelectedItem());
                objAdmEnfermagem.setCirurgias((String) jComboBoxCirurgia.getSelectedItem());
                objAdmEnfermagem.setQuaisCirurgias(jQualCirurgia.getText());
                objAdmEnfermagem.setSifilis((String) jComboBoxSifilis.getSelectedItem());
                objAdmEnfermagem.setHipertensao((String) jComboBoxHipertensaoMasc.getSelectedItem());
                objAdmEnfermagem.setDiabetes((String) jComboBoxDiabetesMasc.getSelectedItem());
                objAdmEnfermagem.setTuberculose((String) jComboBoxTuberculose.getSelectedItem());
                objAdmEnfermagem.setUsuarioDrogas((String) jComboBoxUsuarioDrogas.getSelectedItem());
                objAdmEnfermagem.setQuaisDrogas(jQuaisDrogas.getText());
                objAdmEnfermagem.setPortadorDoenca((String) jComboBoxPortadorDoencas.getSelectedItem());
                objAdmEnfermagem.setQuaisDoencas(jQuaisDoencas.getText());
                objAdmEnfermagem.setAlergias((String) jComboBoxAlergias.getSelectedItem());
                objAdmEnfermagem.setQuaisAlergias(jQuaisAlergias.getText());
                objAdmEnfermagem.setObservacao(jObservacao.getText());
                if (acao == 1) {
                    // log de usuario
                    objAdmEnfermagem.setUsuarioInsert(nameUser);
                    objAdmEnfermagem.setDataInsert(dataModFinal);
                    objAdmEnfermagem.setHoraInsert(horaMov);
                    objAdmEnfermagem.setIdInternoCrc(Integer.valueOf(jIdInternoMedico.getText()));
                    objAdmEnfermagem.setNomeInterno(jNomeInternoMedico.getText());
                    control.incluirAdmissaoEnfermagem(objAdmEnfermagem);
                    buscarID();
                    objAdmEnfermagem.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                    objAdmEnfermagem.setNomeInterno(jNomeInternoMedico.getText());
                    objAdmEnfermagem.setDeptoMedico(deptoTecnico);
                    controle.incluirMovTec(objAdmEnfermagem);
                    // MODIFICAR A TABELA REGISTRO_ATENDIMENTO_INTERNO_PSP INFORMANDO QUE JÁ FOI ATENDIDO  
                    atendido = "Sim";
                    objRegAtend.setIdInternoCrc(Integer.valueOf(jIdInternoMedico.getText()));
                    objRegAtend.setNomeInternoCrc(jNomeInternoMedico.getText());
                    objRegAtend.setIdDepartamento(codigoDepartamentoENFenf);
                    objRegAtend.setTipoAtemdimento(tipoAtendimentoAdm);
                    objRegAtend.setAtendido(atendido);
                    objRegAtend.setDataAtendimento(jDataLanc.getDate());
                    objRegAtend.setIdAtend(Integer.valueOf(jIdLanc.getText()));
                    //
                    objRegAtend.setUsuarioUp(nameUser);
                    objRegAtend.setDataUp(dataModFinal);
                    objRegAtend.setHorarioUp(horaMov);
                    controlRegAtend.alterarRegAtend(objRegAtend);
                    // ADICIONA EVOLUÇÃO APARTIR DA ADMISSÃO
                    objEvolEnferma.setIdInternoCrc(Integer.valueOf(jIdInternoMedico.getText()));
                    objEvolEnferma.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                    objEvolEnferma.setDataEvol(jDataLanc.getDate());
                    objEvolEnferma.setTextoEvolucao(jObservacao.getText());
                    objEvolEnferma.setAdmEvo(admEvolucao);
                    // log de usuario
                    objEvolEnferma.setUsuarioInsert(nameUser);
                    objEvolEnferma.setDataInsert(dataModFinal);
                    objEvolEnferma.setHoraInsert(horaMov);
                    controleEnfa.incluirEvolucaoEnfermagem(objEvolEnferma);
                    preencherTabelaEvolucaoEnfermagem("SELECT * FROM EVOLUCAOENFERMAGEM "
                            + "WHERE IdLanc='" + jIdLanc.getText() + "'");
                    buscarEvolucao();
                    //
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    Salvar();
                }
                if (acao == 2) {
                    // log de usuario
                    objAdmEnfermagem.setUsuarioUp(nameUser);
                    objAdmEnfermagem.setDataUp(dataModFinal);
                    objAdmEnfermagem.setHoraUp(horaMov);
                    objAdmEnfermagem.setIdInternoCrc(Integer.valueOf(jIdInternoMedico.getText()));
                    objAdmEnfermagem.setNomeInterno(jNomeInternoMedico.getText());
                    objAdmEnfermagem.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                    control.alterarAdmissaoEnfermagem(objAdmEnfermagem);
                    objAdmEnfermagem.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                    objAdmEnfermagem.setNomeInterno(jNomeInternoMedico.getText());
                    objAdmEnfermagem.setDeptoMedico(deptoTecnico);
                    controle.alterarMovTec(objAdmEnfermagem);
                    // EDITAR A EVOLUÇÃO APARTIR DA ADMISSÃO
                    objEvolEnferma.setIdItem(Integer.valueOf(jIdEvolucao.getText()));
                    objEvolEnferma.setIdInternoCrc(Integer.valueOf(jIdInternoMedico.getText()));
                    objEvolEnferma.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                    objEvolEnferma.setDataEvol(jDataLanc.getDate());
                    objEvolEnferma.setTextoEvolucao(jObservacao.getText());
                    // log de usuario
                    objEvolEnferma.setUsuarioInsert(nameUser);
                    objEvolEnferma.setDataInsert(dataModFinal);
                    objEvolEnferma.setHoraInsert(horaMov);
                    controleEnfa.alterarEvolucaoEnfermagem(objEvolEnferma);
                    preencherTabelaEvolucaoEnfermagem("SELECT * FROM EVOLUCAOENFERMAGEM "
                            + "WHERE IdLanc='" + jIdLanc.getText() + "'");
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    Salvar();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtSalvarActionPerformed

    private void jBtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarActionPerformed
        // TODO add your handling code here:
        Cancelar();
    }//GEN-LAST:event_jBtCancelarActionPerformed

    private void jBtFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFinalizarActionPerformed
        // TODO add your handling code here:
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ADMISSAOENFERMEIRA WHERE IdLanc='" + jIdLanc.getText() + "'");
            conecta.rs.first();
            jStatusLanc.setText(conecta.rs.getString("StatusLanc"));
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Lançamento já foi finalizado");
            } else {
                Finalizar();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível verificar se lançamento foi finalizado\nERRO: " + ex);
        }
        conecta.desconecta();
    }//GEN-LAST:event_jBtFinalizarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtPesqCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqCodigoActionPerformed
        // TODO add your handling code here:
        count = 0;
        if (jCodigoLanc.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um código de Lançamento a ser pesquisado.");
        } else {
            preencherAdmissaoEnfermeira("SELECT * FROM ADMISSAOENFERMEIRA "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ADMISSAOENFERMEIRA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE IdLanc='" + jCodigoLanc.getText() + "'");
        }
    }//GEN-LAST:event_jBtPesqCodigoActionPerformed

    private void jCheckBoxTodosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxTodosItemStateChanged
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherAdmissaoEnfermeira("SELECT * FROM ADMISSAOENFERMEIRA "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ADMISSAOENFERMEIRA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc");
        } else {
            jtotalRegistros.setText("");
            limparTabelaAdmissao();
        }
    }//GEN-LAST:event_jCheckBoxTodosItemStateChanged

    private void jBtPesqNomeInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNomeInternoActionPerformed
        // TODO add your handling code here:
        count = 0;
        if (jNomesInternoPesq.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o nome do interno para pesquisa.");
        } else {
            preencherAdmissaoEnfermeira("SELECT * FROM ADMISSAOENFERMEIRA "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ADMISSAOENFERMEIRA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE NomeInternoCrc LIKE'" + jNomesInternoPesq.getText() + "%'");
        }
    }//GEN-LAST:event_jBtPesqNomeInternoActionPerformed

    private void jBtPesqDatasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqDatasActionPerformed
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
                    preencherAdmissaoEnfermeira("SELECT * FROM ADMISSAOENFERMEIRA "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON ADMISSAOENFERMEIRA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "WHERE DataLanc BETWEEN'" + dataInicial + "'AND '" + dataFinal + "'");
                }
            }
        }
    }//GEN-LAST:event_jBtPesqDatasActionPerformed

    private void jTabelaAdmissaoEnfermeiraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaAdmissaoEnfermeiraMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String IdLanc = "" + jTabelaAdmissaoEnfermeira.getValueAt(jTabelaAdmissaoEnfermeira.getSelectedRow(), 0);
            jCodigoLanc.setText(IdLanc);
            //  jDatalancamento.setDate(jDatalancamento.getDate());
            jBtNovo.setEnabled(!true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            jBtNovaEvolucao.setEnabled(true);
            jBtImpressaoFicha.setEnabled(true);
            //
            bloquearCampos();
            // AEF-P1
            jBtNovoAFP1.setEnabled(true);
            // AEF-P2
            jBtNovoAFP2.setEnabled(true);
            // AEF-P3
            jBtNovoAFP3.setEnabled(true);
            // AEF-P4
            jBtNovoAFP4.setEnabled(true);
            // EVOLUÇÃO
            jIdEvolucao.setText("");
            jDataEvolu.setDate(null);
            jNomeInternoEvolEnf.setText("");
            jTextoEvolucao.setText("");
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ADMISSAOENFERMEIRA "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ADMISSAOENFERMEIRA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE IdLanc='" + IdLanc + "'");
                conecta.rs.first();
                jIdLanc.setText(String.valueOf(conecta.rs.getInt("IdLanc")));
                jStatusLanc.setText(conecta.rs.getString("StatusLanc"));
                jDataLanc.setDate(conecta.rs.getDate("DataLanc"));
                jIdInternoMedico.setText(conecta.rs.getString("IdInternoCrc"));
                jNomeInternoMedico.setText(conecta.rs.getString("NomeInternoCrc"));
                jMaeInterno.setText(conecta.rs.getString("MaeInternoCrc"));
                jPaiInternoMedico.setText(conecta.rs.getString("PaiInternoCrc"));
                caminho = conecta.rs.getString("FotoInternoCrc");
                javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                jFotoInternoMedico.setIcon(i);
                jFotoInternoMedico.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoInternoMedico.getWidth(), jFotoInternoMedico.getHeight(), Image.SCALE_DEFAULT)));
                jEstadoCivilMedico.setText(conecta.rs.getString("EstadoCivilCrc"));
                //
                statusEstadoEmocional = conecta.rs.getInt("EstadoEmocional");
                if (statusEstadoEmocional == 0) {
                    jRBTranquilo.setSelected(true);
                } else if (statusEstadoEmocional == 1) {
                    jRBAnsioso.setSelected(true);
                } else if (statusEstadoEmocional == 2) {
                    jRBAgeressivo.setSelected(true);
                } else if (statusEstadoEmocional == 3) {
                    jRBTrite.setSelected(true);
                } else if (statusEstadoEmocional == 4) {
                    jRBAgitado.setSelected(true);
                }
                statusSonoRepouso = conecta.rs.getInt("SonoRepouso");
                if (statusSonoRepouso == 0) {
                    jRBPreservado.setSelected(true);
                } else if (statusSonoRepouso == 1) {
                    jRBDiminuido.setSelected(true);
                }
                statusNivelConsciencia = conecta.rs.getInt("NivelConsciencia");
                if (statusNivelConsciencia == 0) {
                    jRBOrientado.setSelected(true);
                } else if (statusNivelConsciencia == 1) {
                    jRBDesorientado.setSelected(true);
                }
                jPressaoArterial.setText(conecta.rs.getString("PressaoArterial"));
                jHemograma.setText(conecta.rs.getString("Hemograma"));
                jTemperatura.setText(conecta.rs.getString("Temperatura"));
                jFrequenciaRespira.setText(conecta.rs.getString("FrequenciaRespiratoria"));
                jPeso.setText(conecta.rs.getString("Peso"));
                jFrequenciaCardiaca.setText(conecta.rs.getString("FrequenciaCardiaca"));
                jComboBoxUsaMedica.setSelectedItem(conecta.rs.getString("UsaMedicamentos"));
                jQualMedicamento.setText(conecta.rs.getString("QualMedicacao"));
                statusLocomocao = conecta.rs.getInt("Locomocao");
                if (statusLocomocao == 0) {
                    jRBDeambulando.setSelected(true);
                } else if (statusLocomocao == 1) {
                    jRBDifiDeambulando.setSelected(true);
                } else if (statusLocomocao == 2) {
                    jRBDeficiente.setSelected(true);
                }
                statusAcuidadeVisual = conecta.rs.getInt("AcuidadeVisual");
                if (statusAcuidadeVisual == 0) {
                    jRBAcuiVisualPreservado.setSelected(true);
                } else if (statusAcuidadeVisual == 1) {
                    jRBAcuiVisulaDiminuido.setSelected(true);
                }
                statusAcuidadeAuditiva = conecta.rs.getInt("AcuidadeAuditiva");
                if (statusAcuidadeAuditiva == 0) {
                    jRBAcuAudiPreservado.setSelected(true);
                } else if (statusAcuidadeAuditiva == 1) {
                    jRBAcuidAudDiminuido.setSelected(true);
                }
                statusFuncaoMotora = conecta.rs.getInt("FuncaoMotora");
                if (statusFuncaoMotora == 0) {
                    jRBFuncaoComAlteracao.setSelected(true);
                } else if (statusFuncaoMotora == 1) {
                    jRBFuncaoSemAlteracao.setSelected(true);
                }
                jQualFuncaoMotora.setText(conecta.rs.getString("QualFuncaoMotora"));
                statusFalaLinguagem = conecta.rs.getInt("FalaLinguagem");
                if (statusFalaLinguagem == 0) {
                    jRBComAlteracaoFala.setSelected(true);
                } else if (statusFalaLinguagem == 1) {
                    jRBSemAlteracaoFala.setSelected(true);
                }
                jQualAlteracaoFala.setText(conecta.rs.getString("QualFala"));
                statusMucosa = conecta.rs.getInt("Mucosa");
                if (statusMucosa == 0) {
                    jRBPeleNormocoradas.setSelected(true);
                } else if (statusMucosa == 1) {
                    jRBPeleHipocoradas.setSelected(true);
                } else if (statusMucosa == 2) {
                    jRBPeleHidratadas.setSelected(true);
                }
                statusPele = conecta.rs.getInt("Pele");
                if (statusPele == 0) {
                    jRBPeleHipohidratada.setSelected(true);
                } else if (statusPele == 1) {
                    jRBPeleIntegra.setSelected(true);
                } else if (statusPele == 2) {
                    jRBPeleLesao.setSelected(true);
                }
                jTipo.setText(conecta.rs.getString("TipoPele"));
                jLocalizacao.setText(conecta.rs.getString("Localizacao"));
                statusCabelos = conecta.rs.getInt("Cabelos");
                if (statusCabelos == 0) {
                    jRBCabelosIntegro.setSelected(true);
                } else if (statusCabelos == 1) {
                    jRBCabelosCalvice.setSelected(true);
                } else if (statusCabelos == 2) {
                    jRBCabelosSujidade.setSelected(true);
                }
                statusBoca = conecta.rs.getInt("Boca");
                if (statusBoca == 0) {
                    jRBBocaHalitose.setSelected(true);
                } else if (statusBoca == 1) {
                    jRBBocaHalitoseCetonica.setSelected(true);
                } else if (statusBoca == 2) {
                    jRBProteseDentaria.setSelected(true);
                } else if (statusBoca == 3) {
                    jRBBocaAusenDenteCarie.setSelected(true);
                }
                statusFuncaoRespiratoria = conecta.rs.getInt("FuncaoRespiratoria");
                if (statusFuncaoRespiratoria == 0) {
                    jRBFuncaoRespEupneico.setSelected(true);
                } else if (statusFuncaoRespiratoria == 1) {
                    jRBFuncaoRespTaquipenico.setSelected(true);
                } else if (statusFuncaoRespiratoria == 2) {
                    jRBFuncaoRespDispneico.setSelected(true);
                }
                statusTorax = conecta.rs.getInt("Torax");
                if (statusTorax == 0) {
                    jRBToraxSimetrico.setSelected(true);
                } else if (statusTorax == 1) {
                    jRBToraxAssimetrico.setSelected(true);
                }
                statusFuncaoIntestinal = conecta.rs.getInt("FuncaoIntestinal");
                if (statusFuncaoIntestinal == 0) {
                    jRBFuncaoRespEupneico.setSelected(true);
                } else if (statusFuncaoIntestinal == 1) {
                    jRBFuncaoRespTaquipenico.setSelected(true);
                } else if (statusFuncaoIntestinal == 2) {
                    jRBFuncaoRespDispneico.setSelected(true);
                } else if (statusFuncaoIntestinal == 3) {
                    jRBFuncaoIntesConstipacao.setSelected(true);
                }
                jCostipacaoDias.setText(conecta.rs.getString("DiasConstipado"));
                statusAbdome = conecta.rs.getInt("Abdome");
                if (statusAbdome == 0) {
                    jRBAbdomeGloboso.setSelected(true);
                } else if (statusAbdome == 1) {
                    jRBAbdomeFlacido.setSelected(true);
                } else if (statusAbdome == 2) {
                    jRBAbdomePlano.setSelected(true);
                }
                statusFuncaoVesical = conecta.rs.getInt("FuncaoVesical");
                if (statusFuncaoVesical == 0) {
                    jRBFuncaoVesicalFralda.setSelected(true);
                } else if (statusFuncaoVesical == 1) {
                    jRBFuncaoVesicalCV.setSelected(true);
                } else if (statusFuncaoVesical == 2) {
                    jRBFuncaVeisicalEspontanea.setSelected(true);
                }
                statusGenitalia = conecta.rs.getInt("Genitalia");
                if (statusGenitalia == 0) {
                    jRBGenitaliaIntegra.setSelected(true);
                } else if (statusGenitalia == 1) {
                    jRBGenitaliaComAlteracao.setSelected(true);
                }
                jQualGenitalia.setText(conecta.rs.getString("QualGenitalia"));
                jComboBoxVacinado.setSelectedItem(conecta.rs.getString("Vacinado"));
                jQuaisVacinas.setText(conecta.rs.getString("QuaisVacinas"));
                //
                jComboBoxVDRL.setSelectedItem(conecta.rs.getString("Vdrl"));
                jComboBoxHepatiteC.setSelectedItem(conecta.rs.getString("HepatiteC"));
                jComboBoxHepatiteB.setSelectedItem(conecta.rs.getString("HepatiteB"));
                jComboBoxHIV.setSelectedItem(conecta.rs.getString("Hiv"));
                jComboBoxCirurgia.setSelectedItem(conecta.rs.getString("Cirurgias"));
                jQualCirurgia.setText(conecta.rs.getString("QuaisCirurgias"));
                jComboBoxSifilis.setSelectedItem(conecta.rs.getString("Sifilis"));
                jComboBoxHipertensaoMasc.setSelectedItem(conecta.rs.getString("Hipertensao"));
                jComboBoxDiabetesMasc.setSelectedItem(conecta.rs.getString("Diabetes"));
                jComboBoxTuberculose.setSelectedItem(conecta.rs.getString("Tuberculose"));
                //
                jComboBoxUsuarioDrogas.setSelectedItem(conecta.rs.getString("UsuarioDrogas"));
                jQuaisDrogas.setText(conecta.rs.getString("QuaisDrogas"));
                jComboBoxPortadorDoencas.setSelectedItem(conecta.rs.getString("PortadorDoenca"));
                jQuaisDoencas.setText(conecta.rs.getString("QuaisDoencas"));
                jComboBoxAlergias.setSelectedItem(conecta.rs.getString("Alergias"));
                jQuaisAlergias.setText(conecta.rs.getString("QuaisAlergias"));
                jObservacao.setText(conecta.rs.getString("Observacao"));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa..." + e);
            }
            // AEF -P1
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ADME_AFP1 "
                        + "INNER JOIN ADMISSAOENFERMEIRA "
                        + "ON ADME_AFP1.IdLanc=ADMISSAOENFERMEIRA.IdLanc "
                        + "WHERE ADME_AFP1.IdLanc='" + IdLanc + "'");
                conecta.rs.first();
                codigoAFP1 = conecta.rs.getInt("IdAfp1");
                jComboBoxHipertensao.setSelectedItem(conecta.rs.getString("Hipertensao"));
                jComboBoxCardiopatias.setSelectedItem(conecta.rs.getString("Cardiopatias"));
                jComboBoxAnemias.setSelectedItem(conecta.rs.getString("Anemias"));
                jComboBoxDoencasRenais.setSelectedItem(conecta.rs.getString("DoencasRenais"));
                jComboBoxDiabetes.setSelectedItem(conecta.rs.getString("Diabetes"));
                jComboBoxAPAlergias.setSelectedItem(conecta.rs.getString("APAlergias"));
                jComboBoxPortadorHIV.setSelectedItem(conecta.rs.getString("PortadorHIV"));
                jComboBoxTransfusao.setSelectedItem(conecta.rs.getString("Transfusao"));
                jComboBoxRetroviarias.setSelectedItem(conecta.rs.getString("Retroviarias"));
                jQuaisRetroviarias.setText(conecta.rs.getString("QuaisRetroviarias"));
                jComboBoxCirurgias.setSelectedItem(conecta.rs.getString("Cirurgias"));
                jDataCirurgia.setDate(conecta.rs.getDate("DataCirurgia"));
                jTipoCirurgia.setText(conecta.rs.getString("TipoCirurgia"));
                jCiclosMenstruais.setText(conecta.rs.getString("Ciclos"));
                jMetodosAnticoncepcionais.setText(conecta.rs.getString("Metodos"));
                jDoencasSexualmenteTransmissiveis.setText(conecta.rs.getString("Doencas"));
                jColpocitologiaOncotica.setText(conecta.rs.getString("Colpocitologia"));
            } catch (Exception e) {
            }
            if (codigoAFP1 != 0) {
                jBtNovoAFP1.setEnabled(true);
                jBtAlterarAFP1.setEnabled(true);
                jBtExcluirAFP1.setEnabled(true);
                jBtSalvarAFP1.setEnabled(!true);
                jBtCancelarAFP1.setEnabled(true);
                jBtAuditoriaAFP1.setEnabled(true);
            }
            //AEF-P2
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ADME_AFP2 "
                        + "INNER JOIN ADMISSAOENFERMEIRA "
                        + "ON ADME_AFP2.IdLanc=ADMISSAOENFERMEIRA.IdLanc "
                        + "WHERE ADME_AFP2.IdLanc='" + IdLanc + "'");
                conecta.rs.first();
                codigoAFP2 = conecta.rs.getInt("IdAfp2");
                jNumeroGestacoes.setText(conecta.rs.getString("NumeroGestacoes"));
                jNumeroPartos.setText(conecta.rs.getString("NumeroPartos"));
                jNumeroAbortos.setText(conecta.rs.getString("NumeroAbortos"));
                jNumeroFilhosVivos.setText(conecta.rs.getString("NumeroFilhosVivos"));
                jIdadePrimeiraGestacao.setText(conecta.rs.getString("IdadePrimeiraGestacao"));
                jIntervaloGestacoes.setText(conecta.rs.getString("IntervaloGestacoes"));
                jPretermo.setText(conecta.rs.getString("Pretermo"));
                jPostermo.setText(conecta.rs.getString("Postermo"));
                jBaixoPeso.setText(conecta.rs.getString("BaixoPeso"));
                jMortesNeonataisPrecoce.setText(conecta.rs.getString("MortesNeonataisPrecoce"));
                jMotivoMorteNeonataisPrecoce.setText(conecta.rs.getString("MotivoMorteNeonataisPrecoce"));
                jMortesNeonataisTardias.setText(conecta.rs.getString("MortesNeonataisTardias"));
                jMotivoMortesNeonataisTardias.setText(conecta.rs.getString("MotivoMortesNeonataisTardias"));
                jNatimortos.setText(conecta.rs.getString("Natimortos"));
                jIctericia.setText(conecta.rs.getString("Ictericia"));
                jTransfusao.setText(conecta.rs.getString("Transfusao"));
                jHipoglicemia.setText(conecta.rs.getString("Hipoglicemia"));
                jIsoimunizacaoRH.setText(conecta.rs.getString("IsoimunizacaoRH"));
                jIntercorrenciaComplicacoesGestoes.setText(conecta.rs.getString("IntercorrenciaComplicacoesGestoes"));
                jHistoriaAleitamentosAnteriores.setText(conecta.rs.getString("HistoriaAleitamentosAnteriores"));
            } catch (Exception e) {
            }
            if (codigoAFP2 != 0) {
                jBtNovoAFP2.setEnabled(true);
                jBtAlterarAFP2.setEnabled(true);
                jBtExcluirAFP2.setEnabled(true);
                jBtSalvarAFP2.setEnabled(!true);
                jBtCancelarAFP2.setEnabled(true);
                jBtAuditoriaAFP2.setEnabled(true);
            }
            //AEF-P3
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ADME_AFP3 "
                        + "INNER JOIN ADMISSAOENFERMEIRA "
                        + "ON ADME_AFP3.IdLanc=ADMISSAOENFERMEIRA.IdLanc "
                        + "WHERE ADME_AFP3.IdLanc='" + IdLanc + "'");
                conecta.rs.first();
                codigoAFP3 = conecta.rs.getInt("IdAfp3");
                jDataUltimaMenstruacao.setDate(conecta.rs.getDate("DataUltimaMenstruacao"));
                jComboBoxGestante.setSelectedItem(conecta.rs.getString("Gestante"));
                jCertezaDuvidaGestacao.setText(conecta.rs.getString("CertezaDuvidaGestacao"));
                jHabitosAlimentares.setText(conecta.rs.getString("HabitosAlimentares"));
                jMedicamentoGestacao.setText(conecta.rs.getString("MedicamentoGestacao"));
                jComboBoxInternacaoGestacao.setSelectedItem(conecta.rs.getString("InternacaoGestacao"));
                jOndeGestacao.setText(conecta.rs.getString("OndeGestacao"));
                jQuaisDrogras.setText(conecta.rs.getString("QuaisDrogras"));
                jSinaisSintomas.setText(conecta.rs.getString("SinaisSintomas"));
                jOcupacaoHabitual.setText(conecta.rs.getString("OcupacaoHabitual"));
                jAceitacaoGravidez.setText(conecta.rs.getString("AceitacaoGravidez"));
                tipoDrogaCigarro = conecta.rs.getInt("Cigarro");
                if (tipoDrogaCigarro == 0) {
                    jCheckBoxCigarro.setSelected(true);
                } else if (tipoDrogaCigarro == 1) {
                    jCheckBoxCigarro.setSelected(!true);
                }
                tipoDrogaPacaia = conecta.rs.getInt("Pacaia");
                if (tipoDrogaPacaia == 0) {
                    jCheckBoxPacaia.setSelected(true);
                } else if (tipoDrogaPacaia == 1) {
                    jCheckBoxPacaia.setSelected(!true);
                }
                tipoDrogaMaconha = conecta.rs.getInt("Maconha");
                if (tipoDrogaMaconha == 0) {
                    jCheckBoxMaconha.setSelected(true);
                } else if (tipoDrogaMaconha == 1) {
                    jCheckBoxMaconha.setSelected(!true);
                }
                tipoDrogaCocaina = conecta.rs.getInt("Cocaina");
                if (tipoDrogaCocaina == 0) {
                    jCheckBoxCocaina.setSelected(true);
                } else if (tipoDrogaCocaina == 1) {
                    jCheckBoxCocaina.setSelected(!true);
                }
                tipoDrogaCraque = conecta.rs.getInt("Craque");
                if (tipoDrogaCraque == 0) {
                    jCheckBoxCraque.setSelected(true);
                } else if (tipoDrogaCraque == 1) {
                    jCheckBoxCraque.setSelected(!true);
                }
                tipoDrogaAlcool = conecta.rs.getInt("Alcool");
                if (tipoDrogaAlcool == 0) {
                    jCheckBoxAlcool.setSelected(true);
                } else if (tipoDrogaAlcool == 1) {
                    jCheckBoxAlcool.setSelected(!true);
                }
                tipoDrogaOutros = conecta.rs.getInt("Outros");
                if (tipoDrogaOutros == 0) {
                    jCheckBoxOutros.setSelected(true);
                } else if (tipoDrogaOutros == 1) {
                    jCheckBoxOutros.setSelected(!true);
                }
            } catch (Exception e) {
            }
            if (codigoAFP3 != 0) {
                jBtNovoAFP3.setEnabled(true);
                jBtAlterarAFP3.setEnabled(true);
                jBtExcluirAFP3.setEnabled(true);
                jBtSalvarAFP3.setEnabled(!true);
                jBtCancelarAFP3.setEnabled(true);
                jBtAuditoriaAFP3.setEnabled(true);
            }
            //AEF-P4
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ADME_AFP4 "
                        + "INNER JOIN ADMISSAOENFERMEIRA "
                        + "ON ADME_AFP4.IdLanc=ADMISSAOENFERMEIRA.IdLanc "
                        + "WHERE ADME_AFP4.IdLanc='" + IdLanc + "'");
                conecta.rs.first();
                codigoAFP4 = conecta.rs.getInt("IdAfp4");
                //
                pesoGestante = conecta.rs.getFloat("PesoGestante");
                DecimalFormat p1 = new DecimalFormat("#0.00");
                String pg = p1.format(pesoGestante);
                jPesoGestante.setText(pg);
                //               
                alturaGestante = conecta.rs.getFloat("AlturaGestante");
                DecimalFormat a1 = new DecimalFormat("#0.00");
                String ag = p1.format(alturaGestante);
                jAlturaGestante.setText(ag);
                //                
                jInspecaoPeleMucosa.setText(conecta.rs.getString("InspecaoPeleMucosa"));
                jPalpacaoTireoide.setText(conecta.rs.getString("PalpacaoTireoide"));;
                jExameAbdomem.setText(conecta.rs.getString("ExameAbdomem"));
                //
                alturaUterina = conecta.rs.getFloat("AlturaUterina");
                DecimalFormat altUter = new DecimalFormat("#0.00");
                String altura = altUter.format(alturaUterina);
                jAlturaUterina.setText(altura);
                //
                jPosicaoFetal.setText(conecta.rs.getString("PosicaoFetal"));
                pesquisaEdemaFace = conecta.rs.getInt("Face");
                if (pesquisaEdemaFace == 0) {
                    jCheckBoxFace.setSelected(true);
                } else if (pesquisaEdemaFace == 1) {
                    jCheckBoxFace.setSelected(!true);
                }
                pesquisaEdemaTronco = conecta.rs.getInt("Tronco");
                if (pesquisaEdemaTronco == 0) {
                    jCheckBoxTronco.setSelected(true);
                } else if (pesquisaEdemaTronco == 1) {
                    jCheckBoxTronco.setSelected(!true);
                }
                pesquisaEdemaMMII = conecta.rs.getInt("MembroInferior");
                if (pesquisaEdemaMMII == 0) {
                    jCheckBoxMembroInferior.setSelected(true);
                } else if (pesquisaEdemaMMII == 1) {
                    jCheckBoxMembroInferior.setSelected(!true);
                }
                pesquisaEdemaMMSS = conecta.rs.getInt("MembroSuperior");
                if (pesquisaEdemaMMSS == 0) {
                    jCheckBoxMembroSuperior.setSelected(true);
                } else if (pesquisaEdemaMMSS == 1) {
                    jCheckBoxMembroSuperior.setSelected(!true);
                }
            } catch (Exception e) {
            }
            if (codigoAFP4 != 0) {
                jBtNovoAFP4.setEnabled(true);
                jBtAlterarAFP4.setEnabled(true);
                jBtExcluirAFP4.setEnabled(true);
                jBtSalvarAFP4.setEnabled(!true);
                jBtCancelarAFP4.setEnabled(true);
                jBtAuditoriaAFP4.setEnabled(true);
            }
            // EVOLUÇÃO
            preencherTabelaEvolucaoEnfermagem("SELECT * FROM EVOLUCAOENFERMAGEM "
                    + "WHERE IdLanc='" + jIdLanc.getText() + "'");
        }
    }//GEN-LAST:event_jTabelaAdmissaoEnfermeiraMouseClicked

    private void jBtPesqInternoEnfermariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqInternoEnfermariaActionPerformed
        // TODO add your handling code here:
        verificarRegistroBiometria();
        if (phabilitaEnferemeiro.equals("Não")) {
            TelaPesqInternoADEnferemeiros objPesqIntAdmEnf = new TelaPesqInternoADEnferemeiros();
            TelaModuloEnfermaria.jPainelMedico.add(objPesqIntAdmEnf);
            objPesqIntAdmEnf.show();
        } else {
            TelaPesqInternoAdmissaoEnfermeria objPesqIntAdmEnf = new TelaPesqInternoAdmissaoEnfermeria();
            TelaModuloEnfermaria.jPainelMedico.add(objPesqIntAdmEnf);
            objPesqIntAdmEnf.show();
        }
    }//GEN-LAST:event_jBtPesqInternoEnfermariaActionPerformed

    private void jBtAuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaAdmissaoEnfermeira objAudiEnfer = new TelaAuditoriaAdmissaoEnfermeira();
        TelaModuloEnfermaria.jPainelMedico.add(objAudiEnfer);
        objAudiEnfer.show();
    }//GEN-LAST:event_jBtAuditoriaActionPerformed

    private void jBtNovaEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovaEvolucaoActionPerformed
        // TODO add your handling code here: 
        verificarInternoRegistradoAdm();
        buscarAcessoUsuario(telaAdmissaoEnfeIntEvolENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaAdmissaoEnfeIntEvolENF) && codIncluirENF == 1) {
            if (atendido == null) {
                JOptionPane.showMessageDialog(rootPane, "É necessário fazer o registro do interno para ser atendido.");
            } else if (atendido.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário fazer o registro do interno para ser atendido.");
            } else if (atendido.equals("Sim")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário fazer o registro do interno para ser atendido.");
            } else if (atendido.equals("Não")) {
                acao = 5;
                bloquearCampos();
                NovaEvolucao();
                statusMov = "Incluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovaEvolucaoActionPerformed

    private void jBtAlterarEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarEvolucaoActionPerformed
        buscarAcessoUsuario(telaAdmissaoEnfeIntEvolENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaAdmissaoEnfeIntEvolENF) && codAlterarENF == 1) {
            verificarEvolucaoAdmissao();
            if (admEvolucao == null) {
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM EVOLUCAOENFERMAGEM "
                            + "WHERE IdItem='" + jIdEvolucao.getText() + "'");
                    conecta.rs.first();
                    nomeUserRegistro = conecta.rs.getString("UsuarioInsert");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Não foi possivel encontrar o usuário.");
                }
                if (nomeUserRegistro == null ? nameUser == null : nomeUserRegistro.equals(nameUser)) {
                    acao = 6;
                    bloquearCampos();
                    AlterarEvolucao();
                    statusMov = "Alterou";
                    horaMov = jHoraSistema.getText();
                    dataModFinal = jDataSistema.getText();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Esse registro foi inserido pelo " + nomeUserRegistro + " só esse usuário poderá modificar.");
                    conecta.desconecta();
                }
            } else if (admEvolucao.equals("")) {
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM EVOLUCAOENFERMAGEM "
                            + "WHERE IdItem='" + jIdEvolucao.getText() + "'");
                    conecta.rs.first();
                    nomeUserRegistro = conecta.rs.getString("UsuarioInsert");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Não foi possivel encontrar o usuário.");
                }
                if (nomeUserRegistro == null ? nameUser == null : nomeUserRegistro.equals(nameUser)) {
                    acao = 6;
                    bloquearCampos();
                    AlterarEvolucao();
                    statusMov = "Alterou";
                    horaMov = jHoraSistema.getText();
                    dataModFinal = jDataSistema.getText();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Esse registro foi inserido pelo " + nomeUserRegistro + " só esse usuário poderá modificar.");
                    conecta.desconecta();
                }
            } else if (admEvolucao.equals("Sim")) {
                JOptionPane.showMessageDialog(rootPane, "Essa evolução não poderá ser alterada nessa tela, será necessário alterar na admissão.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtAlterarEvolucaoActionPerformed

    private void jBtExcluirEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirEvolucaoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAdmissaoEnfeIntEvolENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaAdmissaoEnfeIntEvolENF) && codExcluirENF == 1) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM EVOLUCAOENFERMAGEM WHERE IdItem='" + jIdEvolucao.getText() + "'");
                conecta.rs.first();
                nomeUserRegistro = conecta.rs.getString("UsuarioInsert");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não foi possivel encontrar o usuário.");
            }
            if (nomeUserRegistro == null ? nameUser == null : nomeUserRegistro.equals(nameUser)) {
                objAdmEnfermagem.setStatusLanc(jStatusLanc.getText());
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir a evolução selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    objEvolEnferma.setIdItem(idItemEvol);
                    objEvolEnferma.setIdLanc(Integer.parseInt(jIdLanc.getText()));
                    controleEnfa.excluirEvolucaoEnfermagem(objEvolEnferma);
                    objEvolEnferma.setIdLanc(Integer.parseInt(jIdLanc.getText()));
                    objEvolEnferma.setIdItem(idItemEvol);
                    controlMovEvolEnfa.excluirMovTecEnf(objEvolEnferma);
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    preencherTabelaEvolucaoEnfermagem("SELECT * FROM EVOLUCAOENFERMAGEM WHERE IdLanc='" + jIdLanc.getText() + "'");
                    JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                    ExcluirEvolucao();
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esse registro foi inserido pelo " + nomeUserRegistro + " só esse usuário poderá excluir.");
                conecta.desconecta();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirEvolucaoActionPerformed

    private void jBtSalvarEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarEvolucaoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAdmissaoEnfeIntEvolENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaAdmissaoEnfeIntEvolENF) && codGravarENF == 1) {
            if (jDataEvolu.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data da evolução do interno.");
                jDataEvolu.requestFocus();
                jDataEvolu.setBackground(Color.red);
            } else {
                objEvolEnferma.setDataEvol(jDataEvolu.getDate());
                objEvolEnferma.setTextoEvolucao(jTextoEvolucao.getText());
                objEvolEnferma.setStatusLanc(jStatusLanc.getText());
                if (acao == 5) {
                    // log de usuario
                    objEvolEnferma.setUsuarioInsert(nameUser);
                    objEvolEnferma.setDataInsert(dataModFinal);
                    objEvolEnferma.setHoraInsert(horaMov);
                    objEvolEnferma.setIdInternoCrc(Integer.valueOf(jIdInternoMedico.getText()));
                    objEvolEnferma.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                    controleEnfa.incluirEvolucaoEnfermagem(objEvolEnferma);
                    //
                    buscarEvolucao();
                    objEvolEnferma.setDeptoMedico(deptoTecnico);
                    objEvolEnferma.setIdInternoCrc(Integer.valueOf(jIdInternoMedico.getText()));
                    objEvolEnferma.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                    objEvolEnferma.setNomeInterno(jNomeInternoMedico.getText());
                    controlMovEvolEnfa.incluirMovTecEnf(objEvolEnferma); // Histórico de Movimento Técnico
                    // MODIFICAR A TABELA REGISTRO_ATENDIMENTO_INTERNO_PSP INFORMANDO QUE JÁ FOI ATENDIDO     
                    atendido = "Sim";
                    objRegAtend.setIdInternoCrc(Integer.valueOf(jIdInternoMedico.getText()));
                    objRegAtend.setNomeInternoCrc(jNomeInternoMedico.getText());
                    objRegAtend.setIdDepartamento(codigoDepartamentoENFenf);
                    objRegAtend.setTipoAtemdimento(tipoAtendimentoEvolENF);
                    objRegAtend.setAtendido(atendido);
                    objRegAtend.setDataAtendimento(jDataLanc.getDate());
                    objRegAtend.setIdAtend(Integer.valueOf(jIdLanc.getText()));
                    objRegAtend.setIdEvol(Integer.valueOf(jIdEvolucao.getText()));
                    objRegAtend.setAtendeEvol(atendido);
                    //
                    objRegAtend.setUsuarioUp(nameUser);
                    objRegAtend.setDataUp(dataModFinal);
                    objRegAtend.setHorarioUp(horaMov);
                    controlRegAtend.alterarRegEvol(objRegAtend);
                    SalvarEvolucao();
                    preencherTabelaEvolucaoEnfermagem("SELECT * FROM EVOLUCAOENFERMAGEM "
                            + "WHERE IdLanc='" + jIdLanc.getText() + "'");
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
                if (acao == 6) {
                    // log de usuario
                    objEvolEnferma.setUsuarioUp(nameUser);
                    objEvolEnferma.setDataUp(dataModFinal);
                    objEvolEnferma.setHoraUp(horaMov);
                    objEvolEnferma.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                    objEvolEnferma.setIdInternoCrc(Integer.valueOf(jIdInternoMedico.getText()));
                    objEvolEnferma.setIdItem(idItemEvol);
                    controleEnfa.alterarEvolucaoEnfermagem(objEvolEnferma);
                    //
                    objEvolEnferma.setDeptoMedico(deptoTecnico);
                    objEvolEnferma.setIdInternoCrc(Integer.valueOf(jIdInternoMedico.getText()));
                    objEvolEnferma.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                    objEvolEnferma.setIdItem(idItemEvol);
                    objEvolEnferma.setNomeInterno(jNomeInternoMedico.getText());
                    controlMovEvolEnfa.alterarMovTecEnf(objEvolEnferma);
                    SalvarEvolucao();
                    preencherTabelaEvolucaoEnfermagem("SELECT * FROM EVOLUCAOENFERMAGEM WHERE IdLanc='" + jCodigoLanc.getText() + "'");
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtSalvarEvolucaoActionPerformed

    private void jBtCancelarEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarEvolucaoActionPerformed
        // TODO add your handling code here:
        CancelarEvolucao();
    }//GEN-LAST:event_jBtCancelarEvolucaoActionPerformed

    private void jBtAuditoriaEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaEvolucaoActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaEvolucaoEnfermeira objAudiEvolEnf = new TelaAuditoriaEvolucaoEnfermeira();
        TelaModuloEnfermaria.jPainelMedico.add(objAudiEvolEnf);
        objAudiEvolEnf.show();
    }//GEN-LAST:event_jBtAuditoriaEvolucaoActionPerformed

    private void jTabelaEvolucaoEnfermagemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaEvolucaoEnfermagemMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            String idItem = "" + jTabelaEvolucaoEnfermagem.getValueAt(jTabelaEvolucaoEnfermagem.getSelectedRow(), 0);
            // Habilitar os botões
            jBtNovaEvolucao.setEnabled(!true);
            jBtAlterarEvolucao.setEnabled(true);
            jBtExcluirEvolucao.setEnabled(true);
            jBtSalvarEvolucao.setEnabled(!true);
            jBtCancelarEvolucao.setEnabled(true);
            jBtAuditoriaEvolucao.setEnabled(true);
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM EVOLUCAOENFERMAGEM "
                        + "WHERE IdLanc='" + jIdLanc.getText() + "' "
                        + "AND IdItem='" + idItem + "'");
                conecta.rs.first();
                jIdEvolucao.setText(conecta.rs.getString("IdItem")); //Coluna 0               
                idItemEvol = conecta.rs.getInt("IdItem"); // Coluna 2
                jNomeInternoEvolEnf.setText(jNomeInternoMedico.getText());
                jDataEvolu.setDate(conecta.rs.getDate("DataEvol"));
                jTextoEvolucao.setText(conecta.rs.getString("TextoEvolucao"));
                conecta.desconecta();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não existe dados a serem alterado!!!" + ex);
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaEvolucaoEnfermagemMouseClicked

    private void jBtImpressaoFichaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImpressaoFichaActionPerformed
        // TODO add your handling code here:
        if (!jIdLanc.getText().equals("") && !jIdInternoMedico.getText().equals("")) {
            try {
                conecta.abrirConexao();
                String path = "reports/ProntuariosInternosENFCodigo.jasper";
                conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                        + "INNER JOIN DADOSFISICOSINTERNOS "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSFISICOSINTERNOS.IdInternoCrc "
                        + "INNER JOIN PAISES "
                        + "ON PRONTUARIOSCRC.IdPais=PAISES.IdPais "
                        + "INNER JOIN CIDADES "
                        + "ON PRONTUARIOSCRC.IdCidade=CIDADES.IdCidade "
                        + "INNER JOIN DADOSPENAISINTERNOS "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                        + "INNER JOIN UNIDADE "
                        + "ON DADOSPENAISINTERNOS.IdUnid=UNIDADE.IdUnid "
                        + "WHERE PRONTUARIOSCRC.IdInternoCrc='" + jIdInternoMedico.getText() + "'");
                HashMap parametros = new HashMap();
                parametros.put("MatriculaCrc", jIdInternoMedico.getText());
                parametros.put("nomeUsuario", nameUser);
                JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
                JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
                JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
                jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
                jv.setTitle("Relatório de Prontuário de Internos");
                jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
                jv.toFront(); // Traz o relatorio para frente da aplicação            
                conecta.desconecta();
            } catch (JRException e) {
                JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório.\n\nERRO :" + e);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Pesquise o registro para imprimir a fichado interno.");
        }
    }//GEN-LAST:event_jBtImpressaoFichaActionPerformed

    private void jBtNovoAFP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoAFP1ActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAdmissãoEnfeIntAEFP1ENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaAdmissãoEnfeIntAEFP1ENF) && codIncluirENF == 1) {
            acao = 3;
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            bloquearCampos();
            NovoAFP1();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovoAFP1ActionPerformed

    private void jBtAlterarAFP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarAFP1ActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAdmissãoEnfeIntAEFP1ENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaAdmissãoEnfeIntAEFP1ENF) && codAlterarENF == 1) {
            acao = 4;
            statusMov = "Alterou";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            bloquearCampos();
            AlterarAFP1();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtAlterarAFP1ActionPerformed

    private void jBtExcluirAFP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirAFP1ActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAdmissãoEnfeIntAEFP1ENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaAdmissãoEnfeIntAEFP1ENF) && codExcluirENF == 1) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            bloquearCampos();
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objAfP1.setIdAfp1(codigoAFP1);
                controlAfP1.excluirAtendimentoFemininoP1(objAfP1);
                //
                objLog3();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação      
                ExcluirAFP1();
                JOptionPane.showMessageDialog(null, "Registro EXCLUÍDO com sucesso.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirAFP1ActionPerformed

    private void jBtSalvarAFP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarAFP1ActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAdmissãoEnfeIntAEFP1ENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaAdmissãoEnfeIntAEFP1ENF) && codGravarENF == 1) {
            verificarAEFP1();
            objAfP1.setHipertensao((String) jComboBoxHipertensao.getSelectedItem());
            objAfP1.setCardiopatias((String) jComboBoxCardiopatias.getSelectedItem());
            objAfP1.setAnemias((String) jComboBoxAnemias.getSelectedItem());
            objAfP1.setDoencasRenais((String) jComboBoxDoencasRenais.getSelectedItem());
            objAfP1.setDiabetes((String) jComboBoxDiabetes.getSelectedItem());
            objAfP1.setaPAlergias((String) jComboBoxAPAlergias.getSelectedItem());
            objAfP1.setPortadorHIV((String) jComboBoxPortadorHIV.getSelectedItem());
            objAfP1.setTransfusao((String) jComboBoxTransfusao.getSelectedItem());
            objAfP1.setRetroviarias((String) jComboBoxRetroviarias.getSelectedItem());
            objAfP1.setQuaisRetroviarias(jQuaisRetroviarias.getText());
            objAfP1.setCirurgias((String) jComboBoxCirurgias.getSelectedItem());
            objAfP1.setDataCirurgia(jDataCirurgia.getDate());
            objAfP1.setTipoCirurgia(jTipoCirurgia.getText());
            objAfP1.setCiclos(jCiclosMenstruais.getText());
            objAfP1.setMetodos(jMetodosAnticoncepcionais.getText());
            objAfP1.setDoencas(jDoencasSexualmenteTransmissiveis.getText());
            objAfP1.setColpocitologia(jColpocitologiaOncotica.getText());
            if (acao == 3) {
                if (jIdLanc.getText().equals(codigoAdm1) && jIdInternoMedico.getText().equals(codigoInternoAdm1)) {
                    JOptionPane.showMessageDialog(rootPane, "Já foi realizado um registro para esse interno.");
                } else {
                    objAfP1.setUsuarioInsert(nameUser);
                    objAfP1.setDataInsert(dataModFinal);
                    objAfP1.setHorarioInsert(horaMov);
                    //
                    objAfP1.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                    objAfP1.setIdInternoCrc(Integer.valueOf(jIdInternoMedico.getText()));
                    objAfP1.setNomeInternoCrc(jNomeInternoMedico.getText());
                    controlAfP1.incluirAtendimentoFemininoP1(objAfP1);
                    buscarCodigoAFP1();
                    //
                    objLog3();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação      
                    SalvarAFP1();
                    JOptionPane.showMessageDialog(null, "Registro gravado com sucesso.");
                }
            }
            if (acao == 4) {
                objAfP1.setUsuarioUp(nameUser);
                objAfP1.setDataUp(dataModFinal);
                objAfP1.setHorarioUp(horaMov);
                //
                objAfP1.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                objAfP1.setIdInternoCrc(Integer.valueOf(jIdInternoMedico.getText()));
                objAfP1.setNomeInternoCrc(jNomeInternoMedico.getText());
                objAfP1.setIdAfp1(codigoAFP1);
                controlAfP1.alterarAtendimentoFemininoP1(objAfP1);
                //
                objLog3();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação      
                SalvarAFP1();
                JOptionPane.showMessageDialog(null, "Registro gravado com sucesso.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtSalvarAFP1ActionPerformed

    private void jBtCancelarAFP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarAFP1ActionPerformed
        // TODO add your handling code here:
        CancelarAFP1();
    }//GEN-LAST:event_jBtCancelarAFP1ActionPerformed

    private void jBtSairAFP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairAFP1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairAFP1ActionPerformed

    private void jBtAuditoriaAFP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaAFP1ActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaAdmissaoEnfermeiraAEFP1 objAudAEFP1 = new TelaAuditoriaAdmissaoEnfermeiraAEFP1();
        TelaModuloEnfermaria.jPainelMedico.add(objAudAEFP1);
        objAudAEFP1.show();
    }//GEN-LAST:event_jBtAuditoriaAFP1ActionPerformed

    private void jBtNovoAFP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoAFP2ActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAdmissãoEnfeIntAEFP2ENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaAdmissãoEnfeIntAEFP2ENF) && codIncluirENF == 1) {
            acao = 7;
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            bloquearCampos();
            NovoAFP2();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovoAFP2ActionPerformed

    private void jBtAlterarAFP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarAFP2ActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAdmissãoEnfeIntAEFP2ENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaAdmissãoEnfeIntAEFP2ENF) && codAlterarENF == 1) {
            acao = 8;
            statusMov = "Alterou";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            bloquearCampos();
            AlterarAFP2();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtAlterarAFP2ActionPerformed

    private void jBtExcluirAFP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirAFP2ActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAdmissãoEnfeIntAEFP2ENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaAdmissãoEnfeIntAEFP2ENF) && codExcluirENF == 1) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            bloquearCampos();
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objAfP2.setIdAfp2(codigoAFP2);
                controlAfP2.excluirAtendimentoFemininoP2(objAfP2);
                //
                objLog4();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação      
                ExcluirAFP2();
                JOptionPane.showMessageDialog(null, "Registro EXCLUÍDO com sucesso.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirAFP2ActionPerformed

    private void jBtSalvarAFP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarAFP2ActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAdmissãoEnfeIntAEFP2ENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaAdmissãoEnfeIntAEFP2ENF) && codGravarENF == 1) {
            verificarAEFP2();
            if (jNumeroGestacoes.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o número de gestações ou coloque 0.");
            } else if (jNumeroPartos.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o número de partos ou coloque 0.");
            } else if (jNumeroAbortos.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o número de abortos ou coloque 0.");
            } else if (jNumeroFilhosVivos.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o número de filhos vivis ou coloque 0.");
            } else if (jIdadePrimeiraGestacao.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe a idade da primeira gestação ou coloque 0.");
            } else if (jIntervaloGestacoes.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o internvalo da grestação ou coloque 0.");
            } else if (jPretermo.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o número de pré-termo ou coloque 0.");
            } else if (jPostermo.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o número de pós-termo ou coloque 0.");
            } else if (jBaixoPeso.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o número de baixo peso ou coloque 0.");
            } else if (jMortesNeonataisPrecoce.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o número de mortes neonatais precoces ou coloque 0.");
            } else if (jMortesNeonataisTardias.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o número de mortes neonatais tardias ou coloque 0.");
            } else if (jNatimortos.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o número de natimortos ou coloque 0.");
            } else if (jIctericia.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o número de Ictéricia o coloque 0.");
            } else if (jTransfusao.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o número de transfusão ou coloque 0.");
            } else if (jHipoglicemia.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o número de hipoglicemia ou informe 0.");
            } else {
                objAfP2.setNumeroGestacoes(Integer.valueOf(jNumeroGestacoes.getText()));
                objAfP2.setNumeroPartos(Integer.valueOf(jNumeroPartos.getText()));
                objAfP2.setNumeroAbortos(Integer.valueOf(jNumeroAbortos.getText()));
                objAfP2.setNumeroFilhosVivos(Integer.valueOf(jNumeroFilhosVivos.getText()));
                objAfP2.setIdadePrimeiraGestacao(Integer.valueOf(jIdadePrimeiraGestacao.getText()));
                objAfP2.setIntervaloGestacoes(Integer.valueOf(jIntervaloGestacoes.getText()));
                objAfP2.setPretermo(Integer.valueOf(jPretermo.getText()));
                objAfP2.setPostermo(Integer.valueOf(jPostermo.getText()));
                objAfP2.setBaixoPeso(Integer.valueOf(jBaixoPeso.getText()));
                objAfP2.setMortesNeonataisPrecoce(Integer.valueOf(jMortesNeonataisPrecoce.getText()));
                objAfP2.setMotivoMorteNeonataisPrecoce(jMotivoMorteNeonataisPrecoce.getText());
                objAfP2.setMortesNeonataisTardias(Integer.valueOf(jMortesNeonataisTardias.getText()));
                objAfP2.setMotivoMortesNeonataisTardias(jMotivoMortesNeonataisTardias.getText());
                objAfP2.setNatimortos(Integer.valueOf(jNatimortos.getText()));
                objAfP2.setIctericia(Integer.valueOf(jIctericia.getText()));
                objAfP2.setTransfusao(Integer.valueOf(jTransfusao.getText()));
                objAfP2.setHipoglicemia(Integer.valueOf(jHipoglicemia.getText()));
                objAfP2.setIsoimunizacaoRH(jIsoimunizacaoRH.getText());
                objAfP2.setIntercorrenciaComplicacoesGestoes(jIntercorrenciaComplicacoesGestoes.getText());
                objAfP2.setHistoriaAleitamentosAnteriores(jHistoriaAleitamentosAnteriores.getText());
                if (acao == 7) {
                    if (jIdLanc.getText().equals(codigoAdm2) && jIdInternoMedico.getText().equals(codigoInternoAdm2)) {
                        JOptionPane.showMessageDialog(rootPane, "Já foi realizado um registro para esse interno.");
                    } else {
                        objAfP2.setUsuarioInsert(nameUser);
                        objAfP2.setDataInsert(dataModFinal);
                        objAfP2.setHorarioInsert(horaMov);
                        //
                        objAfP2.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                        objAfP2.setIdInternoCrc(Integer.valueOf(jIdInternoMedico.getText()));
                        objAfP2.setNomeInternoCrc(jNomeInternoMedico.getText());
                        controlAfP2.incluirAtendimentoFemininoP2(objAfP2);
                        buscarCodigoAFP2();
                        //
                        objLog4();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação      
                        SalvarAFP2();
                        JOptionPane.showMessageDialog(null, "Registro gravado com sucesso.");
                    }
                }
                if (acao == 8) {
                    objAfP2.setUsuarioUp(nameUser);
                    objAfP2.setDataUp(dataModFinal);
                    objAfP2.setHorarioUp(horaMov);
                    //
                    objAfP2.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                    objAfP2.setIdInternoCrc(Integer.valueOf(jIdInternoMedico.getText()));
                    objAfP2.setNomeInternoCrc(jNomeInternoMedico.getText());
                    objAfP2.setIdAfp2(codigoAFP2);
                    controlAfP2.alterarAtendimentoFemininoP2(objAfP2);
                    objLog4();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação      
                    SalvarAFP2();
                    JOptionPane.showMessageDialog(null, "Registro gravado com sucesso.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtSalvarAFP2ActionPerformed

    private void jBtCancelarAFP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarAFP2ActionPerformed
        // TODO add your handling code here:
        CancelarAFP2();
    }//GEN-LAST:event_jBtCancelarAFP2ActionPerformed

    private void jBtSairAFP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairAFP2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairAFP2ActionPerformed

    private void jBtAuditoriaAFP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaAFP2ActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaAdmissaoEnfermeiraAEFP2 objAudiAEFP2 = new TelaAuditoriaAdmissaoEnfermeiraAEFP2();
        TelaModuloEnfermaria.jPainelMedico.add(objAudiAEFP2);
        objAudiAEFP2.show();
    }//GEN-LAST:event_jBtAuditoriaAFP2ActionPerformed

    private void jBtNovoAFP3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoAFP3ActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAdmissãoEnfeIntAEFP3ENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaAdmissãoEnfeIntAEFP3ENF) && codIncluirENF == 1) {
            acao = 9;
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            bloquearCampos();
            NovoAFP3();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovoAFP3ActionPerformed

    private void jBtAlterarAFP3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarAFP3ActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAdmissãoEnfeIntAEFP3ENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaAdmissãoEnfeIntAEFP3ENF) && codAlterarENF == 1) {
            acao = 10;
            statusMov = "Alterou";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            bloquearCampos();
            AlterarAFP3();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtAlterarAFP3ActionPerformed

    private void jBtExcluirAFP3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirAFP3ActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAdmissãoEnfeIntAEFP3ENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaAdmissãoEnfeIntAEFP3ENF) && codExcluirENF == 1) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            bloquearCampos();
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objAfP3.setIdAfp3(codigoAFP3);
                controlAfP3.excluirAtendimentoFemininoP3(objAfP3);
                //
                objLog5();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação      
                ExcluirAFP3();
                JOptionPane.showMessageDialog(null, "Registro EXCLUÍDO com sucesso.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirAFP3ActionPerformed

    private void jBtSalvarAFP3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarAFP3ActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAdmissãoEnfeIntAEFP3ENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaAdmissãoEnfeIntAEFP3ENF) && codGravarENF == 1) {
            verificarAEFP3();
            objAfP3.setDataUltimaMenstruacao(jDataUltimaMenstruacao.getDate());
            objAfP3.setGestante((String) jComboBoxGestante.getSelectedItem());
            objAfP3.setCertezaDuvidaGestacao(jCertezaDuvidaGestacao.getText());
            objAfP3.setHabitosAlimentares(jHabitosAlimentares.getText());
            objAfP3.setMedicamentoGestacao(jMedicamentoGestacao.getText());
            objAfP3.setInternacaoGestacao((String) jComboBoxInternacaoGestacao.getSelectedItem());
            objAfP3.setOndeGestacao(jOndeGestacao.getText());
            objAfP3.setQuaisDrogras(jQuaisDrogras.getText());
            objAfP3.setSinaisSintomas(jSinaisSintomas.getText());
            objAfP3.setOcupacaoHabitual(jOcupacaoHabitual.getText());
            objAfP3.setAceitacaoGravidez(jAceitacaoGravidez.getText());
            if (jCheckBoxCigarro.isSelected()) {
                tipoDrogaCigarro = 0;
            } else if (!jCheckBoxCigarro.isSelected()) {
                tipoDrogaCigarro = 1;
            }
            objAfP3.setCigarro(tipoDrogaCigarro);
            if (jCheckBoxPacaia.isSelected()) {
                tipoDrogaPacaia = 0;
            } else if (!jCheckBoxPacaia.isSelected()) {
                tipoDrogaPacaia = 1;
            }
            objAfP3.setPacaia(tipoDrogaPacaia);
            if (jCheckBoxMaconha.isSelected()) {
                tipoDrogaMaconha = 0;
            } else if (!jCheckBoxMaconha.isSelected()) {
                tipoDrogaMaconha = 1;
            }
            objAfP3.setMaconha(tipoDrogaMaconha);
            if (jCheckBoxCocaina.isSelected()) {
                tipoDrogaCocaina = 0;
            } else if (!jCheckBoxCocaina.isSelected()) {
                tipoDrogaCocaina = 1;
            }
            objAfP3.setCocaina(tipoDrogaCocaina);
            if (jCheckBoxCraque.isSelected()) {
                tipoDrogaCraque = 0;
            } else if (!jCheckBoxCraque.isSelected()) {
                tipoDrogaCraque = 1;
            }
            objAfP3.setCraque(tipoDrogaCraque);

            if (jCheckBoxAlcool.isSelected()) {
                tipoDrogaAlcool = 0;
            } else if (!jCheckBoxAlcool.isSelected()) {
                tipoDrogaAlcool = 1;
            }
            objAfP3.setAlcool(tipoDrogaAlcool);
            if (jCheckBoxOutros.isSelected()) {
                tipoDrogaOutros = 0;
            } else if (!jCheckBoxOutros.isSelected()) {
                tipoDrogaOutros = 1;
            }
            objAfP3.setOutros(tipoDrogaOutros);
            if (acao == 9) {
                if (jIdLanc.getText().equals(codigoAdm3) && jIdInternoMedico.getText().equals(codigoInternoAdm3)) {
                    JOptionPane.showMessageDialog(rootPane, "Já foi realizado um registro para esse interno.");
                } else {
                    objAfP3.setUsuarioInsert(nameUser);
                    objAfP3.setDataInsert(dataModFinal);
                    objAfP3.setHorarioInsert(horaMov);
                    //
                    objAfP3.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                    objAfP3.setIdInternoCrc(Integer.valueOf(jIdInternoMedico.getText()));
                    objAfP3.setNomeInternoCrc(jNomeInternoMedico.getText());
                    controlAfP3.incluirAtendimentoFemininoP3(objAfP3);
                    buscarCodigoAFP3();
                    //
                    objLog5();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação      
                    SalvarAFP3();
                    JOptionPane.showMessageDialog(null, "Registro gravado com sucesso.");
                }
            }
            if (acao == 10) {
                objAfP3.setUsuarioUp(nameUser);
                objAfP3.setDataUp(dataModFinal);
                objAfP3.setHorarioUp(horaMov);
                //
                objAfP3.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                objAfP3.setIdInternoCrc(Integer.valueOf(jIdInternoMedico.getText()));
                objAfP3.setNomeInternoCrc(jNomeInternoMedico.getText());
                objAfP3.setIdAfp3(codigoAFP3);
                controlAfP3.alterarAtendimentoFemininoP3(objAfP3);
                objLog5();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação      
                SalvarAFP3();
                JOptionPane.showMessageDialog(null, "Registro gravado com sucesso.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtSalvarAFP3ActionPerformed

    private void jBtCancelarAFP3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarAFP3ActionPerformed
        // TODO add your handling code here:
        CancelarAFP3();
    }//GEN-LAST:event_jBtCancelarAFP3ActionPerformed

    private void jBtSairAFP3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairAFP3ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairAFP3ActionPerformed

    private void jBtAuditoriaAFP3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaAFP3ActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaAdmissaoEnfermeiraAEFP3 objAudiAEFP3 = new TelaAuditoriaAdmissaoEnfermeiraAEFP3();
        TelaModuloEnfermaria.jPainelMedico.add(objAudiAEFP3);
        objAudiAEFP3.show();
    }//GEN-LAST:event_jBtAuditoriaAFP3ActionPerformed

    private void jBtNovoAFP4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoAFP4ActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAdmissãoEnfeIntAEFP4ENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaAdmissãoEnfeIntAEFP4ENF) && codIncluirENF == 1) {
            acao = 11;
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            bloquearCampos();
            NovoAFP4();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovoAFP4ActionPerformed

    private void jBtAlterarAFP4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarAFP4ActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAdmissãoEnfeIntAEFP4ENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaAdmissãoEnfeIntAEFP4ENF) && codAlterarENF == 1) {
            acao = 12;
            statusMov = "Alterou";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            bloquearCampos();
            AlterarAFP4();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtAlterarAFP4ActionPerformed

    private void jBtExcluirAFP4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirAFP4ActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAdmissãoEnfeIntAEFP4ENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaAdmissãoEnfeIntAEFP4ENF) && codExcluirENF == 1) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            bloquearCampos();
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objAfP4.setIdAfp4(codigoAFP4);
                controlAfP4.excluirAtendimentoFemininoP4(objAfP4);
                //
                objLog6();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação      
                ExcluirAFP4();
                JOptionPane.showMessageDialog(null, "Registro EXCLUÍDO com sucesso.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirAFP4ActionPerformed

    private void jBtSalvarAFP4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarAFP4ActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAdmissãoEnfeIntAEFP4ENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaAdmissãoEnfeIntAEFP4ENF) && codGravarENF == 1) {
            DecimalFormat valorReal = new DecimalFormat("#,##00.0");
            valorReal.setCurrency(Currency.getInstance(new Locale("pt", "BR")));
            verificarAEFP4();
            if (jPesoGestante.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe um valor para o peso da gestante ou coloque 0.");
            } else if (jAlturaGestante.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe um valor para altura da gestante ou coloque 0.");
            } else if (jAlturaUterina.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe um valor para altura uternia ou coloque 0.");
            } else {
                objAfP4.setInspecaoPeleMucosa(jInspecaoPeleMucosa.getText());
                objAfP4.setPalpacaoTireoide(jPalpacaoTireoide.getText());
                objAfP4.setExameAbdomem(jExameAbdomem.getText());
                try {
                    objAfP4.setPesoGestante(valorReal.parse(jPesoGestante.getText()).floatValue());
                    objAfP4.setAlturaGestante(valorReal.parse(jAlturaGestante.getText()).floatValue());
                    objAfP4.setAlturaUterina(valorReal.parse(jAlturaUterina.getText()).floatValue());
                } catch (ParseException ex) {
                    Logger.getLogger(TelaInventarioProdutosAC.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (jCheckBoxFace.isSelected()) {
                    pesquisaEdemaFace = 0;
                } else if (!jCheckBoxFace.isSelected()) {
                    pesquisaEdemaFace = 1;
                }
                objAfP4.setFace(pesquisaEdemaFace);
                if (jCheckBoxTronco.isSelected()) {
                    pesquisaEdemaTronco = 0;
                } else if (!jCheckBoxTronco.isSelected()) {
                    pesquisaEdemaTronco = 1;
                }
                objAfP4.setTronco(pesquisaEdemaTronco);
                if (jCheckBoxMembroInferior.isSelected()) {
                    pesquisaEdemaMMII = 0;
                } else if (!jCheckBoxMembroInferior.isSelected()) {
                    pesquisaEdemaMMII = 1;
                }
                objAfP4.setMembroInferior(pesquisaEdemaMMII);
                if (jCheckBoxMembroSuperior.isSelected()) {
                    pesquisaEdemaMMSS = 0;
                } else if (!jCheckBoxMembroSuperior.isSelected()) {
                    pesquisaEdemaMMSS = 1;
                }
                objAfP4.setMembroSuperior(pesquisaEdemaMMSS);
                objAfP4.setPosicaoFetal(jPosicaoFetal.getText());
                if (acao == 11) {
                    if (jIdLanc.getText().equals(codigoAdm4) && jIdInternoMedico.getText().equals(codigoInternoAdm4)) {
                        JOptionPane.showMessageDialog(rootPane, "Já foi realizado um registro para esse interno.");
                    } else {
                        objAfP4.setUsuarioInsert(nameUser);
                        objAfP4.setDataInsert(dataModFinal);
                        objAfP4.setHorarioInsert(horaMov);
                        //
                        objAfP4.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                        objAfP4.setIdInternoCrc(Integer.valueOf(jIdInternoMedico.getText()));
                        objAfP4.setNomeInternoCrc(jNomeInternoMedico.getText());
                        controlAfP4.incluirAtendimentoFemininoP4(objAfP4);
                        buscarCodigoAFP4();
                        objLog6();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação    
                        SalvarAFP4();
                        JOptionPane.showMessageDialog(null, "Registro gravado com sucesso.");
                    }
                }
                if (acao == 12) {
                    objAfP4.setUsuarioUp(nameUser);
                    objAfP4.setDataUp(dataModFinal);
                    objAfP4.setHorarioUp(horaMov);
                    //
                    objAfP4.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                    objAfP4.setIdInternoCrc(Integer.valueOf(jIdInternoMedico.getText()));
                    objAfP4.setNomeInternoCrc(jNomeInternoMedico.getText());
                    objAfP4.setIdAfp4(codigoAFP4);
                    controlAfP4.alterarAtendimentoFemininoP4(objAfP4);
                    objLog6();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação    
                    SalvarAFP4();
                    JOptionPane.showMessageDialog(null, "Registro gravado com sucesso.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtSalvarAFP4ActionPerformed

    private void jBtCancelarAFP4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarAFP4ActionPerformed
        // TODO add your handling code here:
        CancelarAFP4();
    }//GEN-LAST:event_jBtCancelarAFP4ActionPerformed

    private void jBtSairAFP4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairAFP4ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairAFP4ActionPerformed

    private void jBtAuditoriaAFP4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaAFP4ActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaAdmissaoEnfermeiraAEFP4 objAudiAEFP4 = new TelaAuditoriaAdmissaoEnfermeiraAEFP4();
        TelaModuloEnfermaria.jPainelMedico.add(objAudiAEFP4);
        objAudiAEFP4.show();
    }//GEN-LAST:event_jBtAuditoriaAFP4ActionPerformed

    private void jBtImpressaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImpressaoActionPerformed
        // TODO add your handling code here:
        if (jIdEvolucao.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe a evolução a ser impressa.");
        } else {
            try {
                conecta.abrirConexao();
                String path = "reports/relatorioEvolucaoEnfermagem.jasper";
                conecta.executaSQL("SELECT * FROM ADMISSAOENFERMEIRA "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ADMISSAOENFERMEIRA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "INNER JOIN EVOLUCAOENFERMAGEM "
                        + "ON ADMISSAOENFERMEIRA.IdLanc=EVOLUCAOENFERMAGEM.IdLanc "
                        + "WHERE EVOLUCAOENFERMAGEM.IdItem='" + jIdEvolucao.getText() + "'");
                HashMap parametros = new HashMap();
                parametros.put("codigoEvolucao", jIdEvolucao.getText());
                parametros.put("unidadePrisional", descricaoUnidade);
                parametros.put("nameUser", nameUser);
                JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
                JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
                JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
                jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
                jv.setTitle("Relatório de Evolução de Interno.");
                jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
                jv.toFront(); // Traz o relatorio para frente da aplicação            
                conecta.desconecta();
            } catch (JRException e) {
                JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório. \n\nERRO: " + e);
            }
        }
    }//GEN-LAST:event_jBtImpressaoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AEFP1;
    private javax.swing.JPanel AEFP2;
    private javax.swing.JPanel AEFP3;
    private javax.swing.JPanel AEFP4;
    private javax.swing.ButtonGroup Abdome;
    private javax.swing.ButtonGroup AcuidadeAuditiva;
    private javax.swing.ButtonGroup AcuidadeVisual;
    private javax.swing.JPanel Admissao;
    private javax.swing.ButtonGroup Boca;
    private javax.swing.ButtonGroup Cabelos;
    private javax.swing.JPanel Continuacao;
    private javax.swing.ButtonGroup EstadoEmocional;
    private javax.swing.JPanel Evolucao;
    private javax.swing.ButtonGroup FalaLinguagem;
    private javax.swing.ButtonGroup FuncaoIntestinal;
    private javax.swing.ButtonGroup FuncaoMotora;
    private javax.swing.ButtonGroup FuncaoRespiratoria;
    private javax.swing.ButtonGroup FuncaoVesical;
    private javax.swing.ButtonGroup Genitalia;
    private javax.swing.JPanel Listagem;
    private javax.swing.ButtonGroup Locomocao;
    private javax.swing.ButtonGroup Mucosa;
    private javax.swing.ButtonGroup NivelConciencia;
    private javax.swing.ButtonGroup Pele;
    private javax.swing.ButtonGroup PeleMucosaHipo;
    private javax.swing.ButtonGroup SonoRepouso;
    private javax.swing.ButtonGroup Torax;
    private javax.swing.JTextArea jAceitacaoGravidez;
    private javax.swing.JFormattedTextField jAlturaGestante;
    private javax.swing.JFormattedTextField jAlturaUterina;
    private javax.swing.JFormattedTextField jBaixoPeso;
    private javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtAlterarAFP1;
    private javax.swing.JButton jBtAlterarAFP2;
    private javax.swing.JButton jBtAlterarAFP3;
    private javax.swing.JButton jBtAlterarAFP4;
    private javax.swing.JButton jBtAlterarEvolucao;
    private javax.swing.JButton jBtAuditoria;
    private javax.swing.JButton jBtAuditoriaAFP1;
    private javax.swing.JButton jBtAuditoriaAFP2;
    private javax.swing.JButton jBtAuditoriaAFP3;
    private javax.swing.JButton jBtAuditoriaAFP4;
    private javax.swing.JButton jBtAuditoriaEvolucao;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtCancelarAFP1;
    private javax.swing.JButton jBtCancelarAFP2;
    private javax.swing.JButton jBtCancelarAFP3;
    private javax.swing.JButton jBtCancelarAFP4;
    private javax.swing.JButton jBtCancelarEvolucao;
    private javax.swing.JButton jBtExcluir;
    private javax.swing.JButton jBtExcluirAFP1;
    private javax.swing.JButton jBtExcluirAFP2;
    private javax.swing.JButton jBtExcluirAFP3;
    private javax.swing.JButton jBtExcluirAFP4;
    private javax.swing.JButton jBtExcluirEvolucao;
    private javax.swing.JButton jBtFinalizar;
    private javax.swing.JButton jBtImpressao;
    private javax.swing.JButton jBtImpressaoFicha;
    private javax.swing.JButton jBtNovaEvolucao;
    private javax.swing.JButton jBtNovo;
    private javax.swing.JButton jBtNovoAFP1;
    private javax.swing.JButton jBtNovoAFP2;
    private javax.swing.JButton jBtNovoAFP3;
    private javax.swing.JButton jBtNovoAFP4;
    private javax.swing.JButton jBtPesqCodigo;
    private javax.swing.JButton jBtPesqDatas;
    private javax.swing.JButton jBtPesqInternoEnfermaria;
    private javax.swing.JButton jBtPesqNomeInterno;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSairAFP1;
    private javax.swing.JButton jBtSairAFP2;
    private javax.swing.JButton jBtSairAFP3;
    private javax.swing.JButton jBtSairAFP4;
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JButton jBtSalvarAFP1;
    private javax.swing.JButton jBtSalvarAFP2;
    private javax.swing.JButton jBtSalvarAFP3;
    private javax.swing.JButton jBtSalvarAFP4;
    private javax.swing.JButton jBtSalvarEvolucao;
    private javax.swing.JTextField jCertezaDuvidaGestacao;
    private javax.swing.JCheckBox jCheckBoxAlcool;
    private javax.swing.JCheckBox jCheckBoxCigarro;
    private javax.swing.JCheckBox jCheckBoxCocaina;
    private javax.swing.JCheckBox jCheckBoxCraque;
    private javax.swing.JCheckBox jCheckBoxFace;
    private javax.swing.JCheckBox jCheckBoxMaconha;
    private javax.swing.JCheckBox jCheckBoxMembroInferior;
    private javax.swing.JCheckBox jCheckBoxMembroSuperior;
    private javax.swing.JCheckBox jCheckBoxOutros;
    private javax.swing.JCheckBox jCheckBoxPacaia;
    private javax.swing.JCheckBox jCheckBoxTodos;
    private javax.swing.JCheckBox jCheckBoxTronco;
    private javax.swing.JTextArea jCiclosMenstruais;
    private javax.swing.JTextField jCodigoLanc;
    private javax.swing.JTextArea jColpocitologiaOncotica;
    private javax.swing.JComboBox jComboBoxAPAlergias;
    private javax.swing.JComboBox jComboBoxAlergias;
    private javax.swing.JComboBox jComboBoxAnemias;
    private javax.swing.JComboBox jComboBoxCardiopatias;
    private javax.swing.JComboBox jComboBoxCirurgia;
    private javax.swing.JComboBox jComboBoxCirurgias;
    private javax.swing.JComboBox jComboBoxDiabetes;
    private javax.swing.JComboBox jComboBoxDiabetesMasc;
    private javax.swing.JComboBox jComboBoxDoencasRenais;
    private javax.swing.JComboBox jComboBoxGestante;
    private javax.swing.JComboBox jComboBoxHIV;
    private javax.swing.JComboBox jComboBoxHepatiteB;
    private javax.swing.JComboBox jComboBoxHepatiteC;
    private javax.swing.JComboBox jComboBoxHipertensao;
    private javax.swing.JComboBox jComboBoxHipertensaoMasc;
    private javax.swing.JComboBox jComboBoxInternacaoGestacao;
    private javax.swing.JComboBox jComboBoxPortadorDoencas;
    private javax.swing.JComboBox jComboBoxPortadorHIV;
    private javax.swing.JComboBox jComboBoxRetroviarias;
    private javax.swing.JComboBox<String> jComboBoxSifilis;
    private javax.swing.JComboBox jComboBoxTransfusao;
    private javax.swing.JComboBox<String> jComboBoxTuberculose;
    private javax.swing.JComboBox jComboBoxUsaMedica;
    private javax.swing.JComboBox jComboBoxUsuarioDrogas;
    private javax.swing.JComboBox jComboBoxVDRL;
    private javax.swing.JComboBox jComboBoxVacinado;
    private javax.swing.JTextField jCostipacaoDias;
    private com.toedter.calendar.JDateChooser jDataCirurgia;
    private com.toedter.calendar.JDateChooser jDataEvolu;
    private com.toedter.calendar.JDateChooser jDataFinal;
    private com.toedter.calendar.JDateChooser jDataInicial;
    private com.toedter.calendar.JDateChooser jDataLanc;
    public static com.toedter.calendar.JDateChooser jDataNascimento;
    private com.toedter.calendar.JDateChooser jDataUltimaMenstruacao;
    private javax.swing.JTextArea jDoencasSexualmenteTransmissiveis;
    public static javax.swing.JTextField jEstadoCivilMedico;
    private javax.swing.JTextArea jExameAbdomem;
    public static javax.swing.JLabel jFotoInternoMedico;
    private javax.swing.JFormattedTextField jFrequenciaCardiaca;
    private javax.swing.JFormattedTextField jFrequenciaRespira;
    private javax.swing.JTextField jHabitosAlimentares;
    private javax.swing.JFormattedTextField jHemograma;
    private javax.swing.JFormattedTextField jHipoglicemia;
    private javax.swing.JTextArea jHistoriaAleitamentosAnteriores;
    private javax.swing.JFormattedTextField jIctericia;
    public static javax.swing.JTextField jIdEvolucao;
    public static javax.swing.JTextField jIdInternoMedico;
    public static javax.swing.JTextField jIdLanc;
    private javax.swing.JFormattedTextField jIdadePrimeiraGestacao;
    private javax.swing.JTextArea jInspecaoPeleMucosa;
    private javax.swing.JTextArea jIntercorrenciaComplicacoesGestoes;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JFormattedTextField jIntervaloGestacoes;
    private javax.swing.JFormattedTextField jIsoimunizacaoRH;
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
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
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
    private javax.swing.JTextField jLocalizacao;
    public static javax.swing.JTextField jMaeInterno;
    private javax.swing.JTextField jMedicamentoGestacao;
    private javax.swing.JTextArea jMetodosAnticoncepcionais;
    private javax.swing.JFormattedTextField jMortesNeonataisPrecoce;
    private javax.swing.JFormattedTextField jMortesNeonataisTardias;
    private javax.swing.JTextField jMotivoMorteNeonataisPrecoce;
    private javax.swing.JTextField jMotivoMortesNeonataisTardias;
    private javax.swing.JFormattedTextField jNatimortos;
    private javax.swing.JTextField jNomeInternoEvolEnf;
    public static javax.swing.JTextField jNomeInternoMedico;
    private javax.swing.JTextField jNomesInternoPesq;
    private javax.swing.JFormattedTextField jNumeroAbortos;
    private javax.swing.JFormattedTextField jNumeroFilhosVivos;
    private javax.swing.JFormattedTextField jNumeroGestacoes;
    private javax.swing.JFormattedTextField jNumeroPartos;
    private javax.swing.JTextArea jObservacao;
    private javax.swing.JTextArea jOcupacaoHabitual;
    private javax.swing.JTextField jOndeGestacao;
    public static javax.swing.JTextField jPaiInternoMedico;
    private javax.swing.JTextArea jPalpacaoTireoide;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
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
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JFormattedTextField jPeso;
    private javax.swing.JFormattedTextField jPesoGestante;
    private javax.swing.JTextArea jPosicaoFetal;
    private javax.swing.JFormattedTextField jPostermo;
    private javax.swing.JFormattedTextField jPressaoArterial;
    private javax.swing.JFormattedTextField jPretermo;
    private javax.swing.JTextField jQuaisAlergias;
    private javax.swing.JTextField jQuaisDoencas;
    private javax.swing.JTextField jQuaisDrogas;
    private javax.swing.JTextField jQuaisDrogras;
    private javax.swing.JTextField jQuaisRetroviarias;
    private javax.swing.JTextField jQuaisVacinas;
    private javax.swing.JTextField jQualAlteracaoFala;
    private javax.swing.JTextField jQualCirurgia;
    private javax.swing.JTextField jQualFuncaoMotora;
    private javax.swing.JTextField jQualGenitalia;
    private javax.swing.JTextField jQualMedicamento;
    private javax.swing.JRadioButton jRBAbdomeFlacido;
    private javax.swing.JRadioButton jRBAbdomeGloboso;
    private javax.swing.JRadioButton jRBAbdomePlano;
    private javax.swing.JRadioButton jRBAcuAudiPreservado;
    private javax.swing.JRadioButton jRBAcuiVisualPreservado;
    private javax.swing.JRadioButton jRBAcuiVisulaDiminuido;
    private javax.swing.JRadioButton jRBAcuidAudDiminuido;
    private javax.swing.JRadioButton jRBAgeressivo;
    private javax.swing.JRadioButton jRBAgitado;
    private javax.swing.JRadioButton jRBAnsioso;
    private javax.swing.JRadioButton jRBBocaAusenDenteCarie;
    private javax.swing.JRadioButton jRBBocaHalitose;
    private javax.swing.JRadioButton jRBBocaHalitoseCetonica;
    private javax.swing.JRadioButton jRBCabelosCalvice;
    private javax.swing.JRadioButton jRBCabelosIntegro;
    private javax.swing.JRadioButton jRBCabelosSujidade;
    private javax.swing.JRadioButton jRBComAlteracaoFala;
    private javax.swing.JRadioButton jRBDeambulando;
    private javax.swing.JRadioButton jRBDeficiente;
    private javax.swing.JRadioButton jRBDesorientado;
    private javax.swing.JRadioButton jRBDifiDeambulando;
    private javax.swing.JRadioButton jRBDiminuido;
    private javax.swing.JRadioButton jRBFuncaVeisicalEspontanea;
    private javax.swing.JRadioButton jRBFuncaoComAlteracao;
    private javax.swing.JRadioButton jRBFuncaoIntesAusente;
    private javax.swing.JRadioButton jRBFuncaoIntesConstipacao;
    private javax.swing.JRadioButton jRBFuncaoIntesDiarreia;
    private javax.swing.JRadioButton jRBFuncaoIntesRegular;
    private javax.swing.JRadioButton jRBFuncaoRespDispneico;
    private javax.swing.JRadioButton jRBFuncaoRespEupneico;
    private javax.swing.JRadioButton jRBFuncaoRespTaquipenico;
    private javax.swing.JRadioButton jRBFuncaoSemAlteracao;
    private javax.swing.JRadioButton jRBFuncaoVesicalCV;
    private javax.swing.JRadioButton jRBFuncaoVesicalFralda;
    private javax.swing.JRadioButton jRBGenitaliaComAlteracao;
    private javax.swing.JRadioButton jRBGenitaliaIntegra;
    private javax.swing.JRadioButton jRBOrientado;
    private javax.swing.JRadioButton jRBPeleHidratadas;
    private javax.swing.JRadioButton jRBPeleHipocoradas;
    private javax.swing.JRadioButton jRBPeleHipohidratada;
    private javax.swing.JRadioButton jRBPeleIntegra;
    private javax.swing.JRadioButton jRBPeleLesao;
    private javax.swing.JRadioButton jRBPeleNormocoradas;
    private javax.swing.JRadioButton jRBPreservado;
    private javax.swing.JRadioButton jRBProteseDentaria;
    private javax.swing.JRadioButton jRBSemAlteracaoFala;
    private javax.swing.JRadioButton jRBToraxAssimetrico;
    private javax.swing.JRadioButton jRBToraxSimetrico;
    private javax.swing.JRadioButton jRBTranquilo;
    private javax.swing.JRadioButton jRBTrite;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jSinaisSintomas;
    private javax.swing.JTextField jStatusLanc;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTable jTabelaAdmissaoEnfermeira;
    private javax.swing.JTable jTabelaEvolucaoEnfermagem;
    private javax.swing.JFormattedTextField jTemperatura;
    private javax.swing.JTextArea jTextoEvolucao;
    private javax.swing.JTextField jTipo;
    private javax.swing.JTextField jTipoCirurgia;
    private javax.swing.JFormattedTextField jTransfusao;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void formatarCampos() {

//        try {
//            MaskFormatter PressaoArterial = new MaskFormatter("###,###");
//            jPressaoArterial.setFormatterFactory(new DefaultFormatterFactory(PressaoArterial));
//            //
//            MaskFormatter Hemograma = new MaskFormatter("###");
//            jHemograma.setFormatterFactory(new DefaultFormatterFactory(Hemograma));
//            //
//            MaskFormatter Temperatura = new MaskFormatter("##,##");
//            jTemperatura.setFormatterFactory(new DefaultFormatterFactory(Temperatura));
//            //
//            MaskFormatter FrequenciaCardiaca = new MaskFormatter("###,##");
//            jFrequenciaCardiaca.setFormatterFactory(new DefaultFormatterFactory(FrequenciaCardiaca));
//            //
//            MaskFormatter FrequenciaRespira = new MaskFormatter("##,##");
//            jFrequenciaRespira.setFormatterFactory(new DefaultFormatterFactory(FrequenciaRespira));
//            //
//            MaskFormatter Peso = new MaskFormatter("###,###");
//            jPeso.setFormatterFactory(new DefaultFormatterFactory(Peso));
//        } catch (ParseException ex) {
//            Logger.getLogger(TelaAdmissaoEnfermagem.class.getName()).log(Level.SEVERE, null, ex);
//        }
        //
        jQualMedicamento.setDocument(new LimiteDigitosAlfa(37));
        jQualFuncaoMotora.setDocument(new LimiteDigitosAlfa(43));
        jQualAlteracaoFala.setDocument(new LimiteDigitosAlfa(60));
        jTipo.setDocument(new LimiteDigitosAlfa(37));
        jLocalizacao.setDocument(new LimiteDigitosAlfa(25));
        jQualGenitalia.setDocument(new LimiteDigitosAlfa(43));
        jQuaisVacinas.setDocument(new LimiteDigitosAlfa(67));
        jQualCirurgia.setDocument(new LimiteDigitosAlfa(40));
        jQuaisDrogas.setDocument(new LimiteDigitosAlfa(40));
        jQuaisDoencas.setDocument(new LimiteDigitosAlfa(40));
        jQuaisAlergias.setDocument(new LimiteDigitosAlfa(40));
        jObservacao.setLineWrap(true);
        jObservacao.setWrapStyleWord(true);
        jTextoEvolucao.setLineWrap(true);
        jTextoEvolucao.setWrapStyleWord(true);
        // AEF-P1
        jQuaisRetroviarias.setDocument(new LimiteDigitosAlfa(43));
        jTipoCirurgia.setDocument(new LimiteDigitosAlfa(63));
        jCiclosMenstruais.setLineWrap(true);
        jCiclosMenstruais.setWrapStyleWord(true);
        jMetodosAnticoncepcionais.setLineWrap(true);
        jMetodosAnticoncepcionais.setWrapStyleWord(true);
        jDoencasSexualmenteTransmissiveis.setLineWrap(true);
        jDoencasSexualmenteTransmissiveis.setWrapStyleWord(true);
        jColpocitologiaOncotica.setLineWrap(true);
        jColpocitologiaOncotica.setWrapStyleWord(true);
        // AEF-P2
        jNumeroGestacoes.setDocument(new LimiteDigitosSoNum(3));
        jNumeroPartos.setDocument(new LimiteDigitosSoNum(3));
        jNumeroAbortos.setDocument(new LimiteDigitosSoNum(3));
        jNumeroFilhosVivos.setDocument(new LimiteDigitosSoNum(3));
        jIdadePrimeiraGestacao.setDocument(new LimiteDigitosSoNum(3));
        jIntervaloGestacoes.setDocument(new LimiteDigitosSoNum(3));
        jPretermo.setDocument(new LimiteDigitosSoNum(3));
        jPostermo.setDocument(new LimiteDigitosSoNum(3));
        jBaixoPeso.setDocument(new LimiteDigitosSoNum(3));
        jMortesNeonataisPrecoce.setDocument(new LimiteDigitosSoNum(3));
        jMotivoMorteNeonataisPrecoce.setDocument(new LimiteDigitosAlfa(80));
        jMortesNeonataisTardias.setDocument(new LimiteDigitosSoNum(3));
        jMotivoMortesNeonataisTardias.setDocument(new LimiteDigitosAlfa(47));
        jNatimortos.setDocument(new LimiteDigitosSoNum(3));
        jIctericia.setDocument(new LimiteDigitosSoNum(3));
        jTransfusao.setDocument(new LimiteDigitosSoNum(3));
        jHipoglicemia.setDocument(new LimiteDigitosSoNum(3));
        jIsoimunizacaoRH.setDocument(new LimiteDigitosAlfa(71));
        jIntercorrenciaComplicacoesGestoes.setLineWrap(true);
        jIntercorrenciaComplicacoesGestoes.setWrapStyleWord(true);
        jHistoriaAleitamentosAnteriores.setLineWrap(true);
        jHistoriaAleitamentosAnteriores.setWrapStyleWord(true);
        // AEF-P3
        jCertezaDuvidaGestacao.setDocument(new LimiteDigitosAlfa(68));
        jHabitosAlimentares.setDocument(new LimiteDigitosAlfa(68));
        jMedicamentoGestacao.setDocument(new LimiteDigitosAlfa(68));
        jOndeGestacao.setDocument(new LimiteDigitosAlfa(51));
        jQuaisDrogras.setDocument(new LimiteDigitosAlfa(44));
        jSinaisSintomas.setLineWrap(true);
        jSinaisSintomas.setWrapStyleWord(true);
        jOcupacaoHabitual.setLineWrap(true);
        jOcupacaoHabitual.setWrapStyleWord(true);
        jAceitacaoGravidez.setLineWrap(true);
        jAceitacaoGravidez.setWrapStyleWord(true);
        // AEF-P4
        jInspecaoPeleMucosa.setLineWrap(true);
        jInspecaoPeleMucosa.setWrapStyleWord(true);
        jPalpacaoTireoide.setLineWrap(true);
        jPalpacaoTireoide.setWrapStyleWord(true);
        jExameAbdomem.setLineWrap(true);
        jExameAbdomem.setWrapStyleWord(true);
        jPosicaoFetal.setLineWrap(true);
        jPosicaoFetal.setWrapStyleWord(true);

    }

    public void corCampos() {
        // ADMISSÃO
        jIdLanc.setBackground(Color.white);
        jStatusLanc.setBackground(Color.white);
        jDataLanc.setBackground(Color.white);
        //
        jIdInternoMedico.setBackground(Color.white);
        jNomeInternoMedico.setBackground(Color.white);
        jMaeInterno.setBackground(Color.white);
        jPaiInternoMedico.setBackground(Color.white);
        jFotoInternoMedico.setBackground(Color.white);
        jEstadoCivilMedico.setBackground(Color.white);
        //
        jPressaoArterial.setBackground(Color.white);
        jHemograma.setBackground(Color.white);
        jTemperatura.setBackground(Color.white);
        jFrequenciaRespira.setBackground(Color.white);
        jPeso.setBackground(Color.white);
        jFrequenciaCardiaca.setBackground(Color.white);
        jQualMedicamento.setBackground(Color.white);
        jQualFuncaoMotora.setBackground(Color.white);
        jQualAlteracaoFala.setBackground(Color.white);
        jTipo.setBackground(Color.white);
        jLocalizacao.setBackground(Color.white);
        jCostipacaoDias.setBackground(Color.white);
        jQualGenitalia.setBackground(Color.white);
        jQuaisVacinas.setBackground(Color.white);
        jQualCirurgia.setBackground(Color.white);
        jComboBoxUsuarioDrogas.setBackground(Color.white);
        jComboBoxPortadorDoencas.setBackground(Color.white);
        jComboBoxAlergias.setBackground(Color.white);
        jQuaisDrogas.setBackground(Color.white);
        jQuaisDoencas.setBackground(Color.white);
        jQuaisAlergias.setBackground(Color.white);
        jComboBoxVDRL.setBackground(Color.white);
        jComboBoxHepatiteC.setBackground(Color.white);
        jComboBoxHepatiteB.setBackground(Color.white);
        jComboBoxHIV.setBackground(Color.white);
        jObservacao.setBackground(Color.white);
        // AEF-P1
        jComboBoxHipertensao.setBackground(Color.white);
        jComboBoxCardiopatias.setBackground(Color.white);
        jComboBoxAnemias.setBackground(Color.white);
        jComboBoxDoencasRenais.setBackground(Color.white);
        jComboBoxDiabetes.setBackground(Color.white);
        jComboBoxAPAlergias.setBackground(Color.white);
        jComboBoxPortadorHIV.setBackground(Color.white);
        jComboBoxTransfusao.setBackground(Color.white);
        jComboBoxRetroviarias.setBackground(Color.white);
        jQuaisRetroviarias.setBackground(Color.white);
        jComboBoxCirurgias.setBackground(Color.white);
        jDataCirurgia.setBackground(Color.white);
        jTipoCirurgia.setBackground(Color.white);
        jCiclosMenstruais.setBackground(Color.white);
        jMetodosAnticoncepcionais.setBackground(Color.white);
        jDoencasSexualmenteTransmissiveis.setBackground(Color.white);
        jColpocitologiaOncotica.setBackground(Color.white);
        // AEF-P2
        jNumeroGestacoes.setBackground(Color.white);
        jNumeroPartos.setBackground(Color.white);
        jNumeroAbortos.setBackground(Color.white);
        jNumeroFilhosVivos.setBackground(Color.white);
        jIdadePrimeiraGestacao.setBackground(Color.white);
        jIntervaloGestacoes.setBackground(Color.white);
        jPretermo.setBackground(Color.white);
        jPostermo.setBackground(Color.white);
        jBaixoPeso.setBackground(Color.white);
        jMortesNeonataisPrecoce.setBackground(Color.white);
        jMotivoMorteNeonataisPrecoce.setBackground(Color.white);
        jMortesNeonataisTardias.setBackground(Color.white);
        jMotivoMortesNeonataisTardias.setBackground(Color.white);
        jNatimortos.setBackground(Color.white);
        jIctericia.setBackground(Color.white);
        jTransfusao.setBackground(Color.white);
        jHipoglicemia.setBackground(Color.white);
        jIsoimunizacaoRH.setBackground(Color.white);
        jIntercorrenciaComplicacoesGestoes.setBackground(Color.white);
        jHistoriaAleitamentosAnteriores.setBackground(Color.white);
        // AEF-P3      
        jDataUltimaMenstruacao.setBackground(Color.white);
        jComboBoxGestante.setBackground(Color.white);
        jCertezaDuvidaGestacao.setBackground(Color.white);
        jHabitosAlimentares.setBackground(Color.white);
        jMedicamentoGestacao.setBackground(Color.white);
        jComboBoxInternacaoGestacao.setBackground(Color.white);
        jOndeGestacao.setBackground(Color.white);
        jSinaisSintomas.setBackground(Color.white);
        jOcupacaoHabitual.setBackground(Color.white);
        jAceitacaoGravidez.setBackground(Color.white);
        // AEF-P4
        jPesoGestante.setBackground(Color.white);
        jAlturaGestante.setBackground(Color.white);
        jInspecaoPeleMucosa.setBackground(Color.white);
        jPalpacaoTireoide.setBackground(Color.white);
        jExameAbdomem.setBackground(Color.white);
        jAlturaUterina.setBackground(Color.white);
        jPosicaoFetal.setBackground(Color.white);
        // EVOLUÇÃO
        jIdEvolucao.setBackground(Color.white);
        jNomeInternoEvolEnf.setBackground(Color.white);
        jDataEvolu.setBackground(Color.white);
        jTextoEvolucao.setBackground(Color.white);
    }

    public void bloquearCampos() {
        // ADMISSÃO
        jDataLanc.setEnabled(!true);
        jBtPesqInternoEnfermaria.setEnabled(!true);
        // Estado Emocional
        jRBTranquilo.setEnabled(!true);
        jRBAgeressivo.setEnabled(!true);
        jRBAgitado.setEnabled(!true);
        jRBAnsioso.setEnabled(!true);
        jRBTrite.setEnabled(!true);
        // Sono/Repouso
        jRBPreservado.setEnabled(!true);
        jRBDiminuido.setEnabled(!true);
        //Sinais Vitais
        jPressaoArterial.setEnabled(!true);
        jHemograma.setEnabled(!true);
        jTemperatura.setEnabled(!true);
        jFrequenciaRespira.setEnabled(!true);
        jPeso.setEnabled(!true);
        jFrequenciaCardiaca.setEnabled(!true);
        //Nível de consciência
        jRBOrientado.setEnabled(!true);
        jRBDesorientado.setEnabled(!true);
        //Uso de medicamento.
        jComboBoxUsaMedica.setEnabled(!true);
        jQualMedicamento.setEnabled(!true);
        // Locomação
        jRBDeambulando.setEnabled(!true);
        jRBDeficiente.setEnabled(!true);
        jRBDifiDeambulando.setEnabled(!true);
        // Acuidade Visual/Auditiva
        jRBAcuiVisualPreservado.setEnabled(!true);
        jRBAcuiVisulaDiminuido.setEnabled(!true);
        jRBAcuAudiPreservado.setEnabled(!true);
        jRBAcuidAudDiminuido.setEnabled(!true);
        // Função Motora
        jRBFuncaoComAlteracao.setEnabled(!true);
        jRBFuncaoSemAlteracao.setEnabled(!true);
        jQualFuncaoMotora.setEnabled(!true);
        // Fala/Linguagem
        jRBComAlteracaoFala.setEnabled(!true);
        jRBSemAlteracaoFala.setEnabled(!true);
        jQualAlteracaoFala.setEnabled(!true);
        //Pele/Mucosa
        jRBPeleNormocoradas.setEnabled(!true);
        jRBPeleHipocoradas.setEnabled(!true);
        jRBPeleHidratadas.setEnabled(!true);
        jRBPeleHipohidratada.setEnabled(!true);
        jRBPeleIntegra.setEnabled(!true);
        jRBPeleLesao.setEnabled(!true);
        jTipo.setEnabled(!true);
        jLocalizacao.setEnabled(!true);
        // Cabelos
        jRBCabelosCalvice.setEnabled(!true);
        jRBCabelosIntegro.setEnabled(!true);
        jRBCabelosSujidade.setEnabled(!true);
        // Boca        
        jRBBocaHalitose.setEnabled(!true);
        jRBBocaHalitoseCetonica.setEnabled(!true);
        jRBProteseDentaria.setEnabled(!true);
        jRBBocaAusenDenteCarie.setEnabled(!true);
        //Função Respiratoria         
        jRBFuncaoRespEupneico.setEnabled(!true);
        jRBFuncaoRespTaquipenico.setEnabled(!true);
        jRBFuncaoRespDispneico.setEnabled(!true);
        // Torax
        jRBToraxSimetrico.setEnabled(!true);
        jRBToraxAssimetrico.setEnabled(!true);
        // Função Intestinal
        jRBFuncaoIntesRegular.setEnabled(!true);
        jRBFuncaoIntesAusente.setEnabled(!true);
        jRBFuncaoIntesDiarreia.setEnabled(!true);
        jRBFuncaoIntesConstipacao.setEnabled(!true);
        jCostipacaoDias.setEnabled(!true);
        // Abdome
        jRBAbdomeGloboso.setEnabled(!true);
        jRBAbdomeFlacido.setEnabled(!true);
        jRBAbdomePlano.setEnabled(!true);
        // Função Vesical
        jRBFuncaoVesicalFralda.setEnabled(!true);
        jRBFuncaoVesicalCV.setEnabled(!true);
        jRBFuncaVeisicalEspontanea.setEnabled(!true);
        // Genitalia
        jRBGenitaliaIntegra.setEnabled(!true);
        jRBGenitaliaComAlteracao.setEnabled(!true);
        jQualGenitalia.setEnabled(!true);
        // Vacinas
        jComboBoxVacinado.setEnabled(!true);
        jQuaisVacinas.setEnabled(!true);
        //
        jComboBoxVDRL.setEnabled(!true);
        jComboBoxHepatiteC.setEnabled(!true);
        jComboBoxHepatiteB.setEnabled(!true);
        jComboBoxHIV.setEnabled(!true);
        jComboBoxCirurgia.setEnabled(!true);
        jQualCirurgia.setEnabled(!true);
        //
        jComboBoxUsuarioDrogas.setEnabled(!true);
        jComboBoxPortadorDoencas.setEnabled(!true);
        jComboBoxAlergias.setEnabled(!true);
        jQuaisDrogas.setEnabled(!true);
        jQuaisDoencas.setEnabled(!true);
        jQuaisAlergias.setEnabled(!true);
        jObservacao.setEnabled(!true);
        // AEF-P1
        jComboBoxHipertensao.setEnabled(!true);
        jComboBoxCardiopatias.setEnabled(!true);
        jComboBoxAnemias.setEnabled(!true);
        jComboBoxDoencasRenais.setEnabled(!true);
        jComboBoxDiabetes.setEnabled(!true);
        jComboBoxAPAlergias.setEnabled(!true);
        jComboBoxPortadorHIV.setEnabled(!true);
        jComboBoxTransfusao.setEnabled(!true);
        jComboBoxRetroviarias.setEnabled(!true);
        jQuaisRetroviarias.setEnabled(!true);
        jComboBoxCirurgias.setEnabled(!true);
        jDataCirurgia.setEnabled(!true);
        jTipoCirurgia.setEnabled(!true);
        jCiclosMenstruais.setEnabled(!true);
        jMetodosAnticoncepcionais.setEnabled(!true);
        jDoencasSexualmenteTransmissiveis.setEnabled(!true);
        jColpocitologiaOncotica.setEnabled(!true);
        // AEF-P2
        jNumeroGestacoes.setEnabled(!true);
        jNumeroPartos.setEnabled(!true);
        jNumeroAbortos.setEnabled(!true);
        jNumeroFilhosVivos.setEnabled(!true);
        jIdadePrimeiraGestacao.setEnabled(!true);
        jIntervaloGestacoes.setEnabled(!true);
        jPretermo.setEnabled(!true);
        jPostermo.setEnabled(!true);
        jBaixoPeso.setEnabled(!true);
        jMortesNeonataisPrecoce.setEnabled(!true);
        jMotivoMorteNeonataisPrecoce.setEnabled(!true);
        jMortesNeonataisTardias.setEnabled(!true);
        jMotivoMortesNeonataisTardias.setEnabled(!true);
        jNatimortos.setEnabled(!true);
        jIctericia.setEnabled(!true);
        jTransfusao.setEnabled(!true);
        jHipoglicemia.setEnabled(!true);
        jIsoimunizacaoRH.setEnabled(!true);
        jIntercorrenciaComplicacoesGestoes.setEnabled(!true);
        jHistoriaAleitamentosAnteriores.setEnabled(!true);
        // AEF-P3
        jDataUltimaMenstruacao.setEnabled(!true);
        jComboBoxGestante.setEnabled(!true);
        jCertezaDuvidaGestacao.setEnabled(!true);
        jHabitosAlimentares.setEnabled(!true);
        jMedicamentoGestacao.setEnabled(!true);
        jComboBoxInternacaoGestacao.setEnabled(!true);
        jOndeGestacao.setEnabled(!true);
        jCheckBoxCigarro.setEnabled(!true);
        jCheckBoxPacaia.setEnabled(!true);
        jCheckBoxMaconha.setEnabled(!true);
        jCheckBoxCocaina.setEnabled(!true);
        jCheckBoxCraque.setEnabled(!true);
        jCheckBoxAlcool.setEnabled(!true);
        jCheckBoxOutros.setEnabled(!true);
        jQuaisDrogras.setEnabled(!true);
        jSinaisSintomas.setEnabled(!true);
        jOcupacaoHabitual.setEnabled(!true);
        jAceitacaoGravidez.setEnabled(!true);
        // AEF-P4
        jPesoGestante.setEnabled(!true);
        jAlturaGestante.setEnabled(!true);
        jCheckBoxFace.setEnabled(!true);
        jCheckBoxTronco.setEnabled(!true);
        jCheckBoxMembroInferior.setEnabled(!true);
        jCheckBoxMembroSuperior.setEnabled(!true);
        jInspecaoPeleMucosa.setEnabled(!true);
        jPalpacaoTireoide.setEnabled(!true);
        jExameAbdomem.setEnabled(!true);
        jAlturaUterina.setEnabled(!true);
        jPosicaoFetal.setEnabled(!true);
        // EVOLUÇÃO
        jDataEvolu.setEnabled(!true);
        jTextoEvolucao.setEnabled(!true);
    }

    public void Novo() {
        // Limpar campos para inclusão
        jIdLanc.setText("");
        jStatusLanc.setText("ABERTO");
        jDataLanc.setCalendar(Calendar.getInstance());
        //
        jIdInternoMedico.setText("");
        jNomeInternoMedico.setText("");
        jMaeInterno.setText("");
        jPaiInternoMedico.setText("");
        jFotoInternoMedico.setIcon(null);
        jEstadoCivilMedico.setText("");
        //
        jPressaoArterial.setText("0");
        jHemograma.setText("0");
        jTemperatura.setText("0");
        jFrequenciaRespira.setText("0");
        jPeso.setText("0");
        jFrequenciaCardiaca.setText("0");
        //Uso de medicamento.
        jComboBoxUsaMedica.setSelectedItem("Não");
        jQualMedicamento.setText("");
        //Função Motora
        jQualFuncaoMotora.setText("");
        //Fala/Pele        
        jQualAlteracaoFala.setText("");
        jTipo.setText("");
        jLocalizacao.setText("");
        // Função Intestinal
        jCostipacaoDias.setText("");
        // Genitália
        jQualGenitalia.setText("");
        // Vacinação
        jComboBoxVacinado.setSelectedItem("Não");
        jQuaisVacinas.setText("");
        // Testes Rápidos
        jComboBoxVDRL.setSelectedItem("Não reagente");
        jComboBoxHepatiteC.setSelectedItem("Não reagente");
        jComboBoxHepatiteB.setSelectedItem("Não reagente");
        jComboBoxHIV.setSelectedItem("Não reagente");
        jComboBoxUsuarioDrogas.setSelectedItem("Não");
        jComboBoxPortadorDoencas.setSelectedItem("Não");
        jComboBoxAlergias.setSelectedItem("Não");
        jQuaisDrogas.setText("");
        jQuaisDoencas.setText("");
        jQuaisAlergias.setText("");
        // Observação
        jObservacao.setText("");
        //Habilitar/Desabilitar Campos        
        jDataLanc.setEnabled(true);
        jBtPesqInternoEnfermaria.setEnabled(true);
        // Estado Emocional
        jRBTranquilo.setEnabled(true);
        jRBAgeressivo.setEnabled(true);
        jRBAgitado.setEnabled(true);
        jRBAnsioso.setEnabled(true);
        jRBTrite.setEnabled(true);
        // Sono/Repouso
        jRBPreservado.setEnabled(true);
        jRBDiminuido.setEnabled(true);
        //Sinais Vitais
        jPressaoArterial.setEnabled(true);
        jHemograma.setEnabled(true);
        jTemperatura.setEnabled(true);
        jFrequenciaRespira.setEnabled(true);
        jPeso.setEnabled(true);
        jFrequenciaCardiaca.setEnabled(true);
        //Nível de consciência
        jRBOrientado.setEnabled(true);
        jRBDesorientado.setEnabled(true);
        //Uso de medicamento.
        jComboBoxUsaMedica.setEnabled(true);
        jQualMedicamento.setEnabled(true);
        // Locomação
        jRBDeambulando.setEnabled(true);
        jRBDeficiente.setEnabled(true);
        jRBDifiDeambulando.setEnabled(true);
        // Acuidade Visual/Auditiva
        jRBAcuiVisualPreservado.setEnabled(true);
        jRBAcuiVisulaDiminuido.setEnabled(true);
        jRBAcuAudiPreservado.setEnabled(true);
        jRBAcuidAudDiminuido.setEnabled(true);
        // Função Motora
        jRBFuncaoComAlteracao.setEnabled(true);
        jRBFuncaoSemAlteracao.setEnabled(true);
        jQualFuncaoMotora.setEnabled(true);
        // Fala/Linguagem
        jRBComAlteracaoFala.setEnabled(true);
        jRBSemAlteracaoFala.setEnabled(true);
        jQualAlteracaoFala.setEnabled(true);
        //Pele/Mucosa
        jRBPeleNormocoradas.setEnabled(true);
        jRBPeleHipocoradas.setEnabled(true);
        jRBPeleHidratadas.setEnabled(true);
        jRBPeleHipohidratada.setEnabled(true);
        jRBPeleIntegra.setEnabled(true);
        jRBPeleLesao.setEnabled(true);
        jTipo.setEnabled(true);
        jLocalizacao.setEnabled(true);
        // Cabelos
        jRBCabelosCalvice.setEnabled(true);
        jRBCabelosIntegro.setEnabled(true);
        jRBCabelosSujidade.setEnabled(true);
        // Boca        
        jRBBocaHalitose.setEnabled(true);
        jRBBocaHalitoseCetonica.setEnabled(true);
        jRBProteseDentaria.setEnabled(true);
        jRBBocaAusenDenteCarie.setEnabled(true);
        //Função Respiratoria         
        jRBFuncaoRespEupneico.setEnabled(true);
        jRBFuncaoRespTaquipenico.setEnabled(true);
        jRBFuncaoRespDispneico.setEnabled(true);
        // Torax
        jRBToraxSimetrico.setEnabled(true);
        jRBToraxAssimetrico.setEnabled(true);
        // Função Intestinal
        jRBFuncaoIntesRegular.setEnabled(true);
        jRBFuncaoIntesAusente.setEnabled(true);
        jRBFuncaoIntesDiarreia.setEnabled(true);
        jRBFuncaoIntesConstipacao.setEnabled(true);
        jCostipacaoDias.setEnabled(true);
        // Abdome
        jRBAbdomeGloboso.setEnabled(true);
        jRBAbdomeFlacido.setEnabled(true);
        jRBAbdomePlano.setEnabled(true);
        // Função Vesical
        jRBFuncaoVesicalFralda.setEnabled(true);
        jRBFuncaoVesicalCV.setEnabled(true);
        jRBFuncaVeisicalEspontanea.setEnabled(true);
        // Genitalia
        jRBGenitaliaIntegra.setEnabled(true);
        jRBGenitaliaComAlteracao.setEnabled(true);
        jQualGenitalia.setEnabled(true);
        // Vacinas
        jComboBoxVacinado.setEnabled(true);
        jQuaisVacinas.setEnabled(true);
        // TESTES RÁPIDOS
        jComboBoxVDRL.setEnabled(true);
        jComboBoxHepatiteC.setEnabled(true);
        jComboBoxHepatiteB.setEnabled(true);
        jComboBoxHIV.setEnabled(true);
        jComboBoxCirurgia.setEnabled(true);
        jQualCirurgia.setEnabled(true);
        jComboBoxSifilis.setEnabled(true);
        jComboBoxHipertensaoMasc.setEnabled(true);
        jComboBoxDiabetesMasc.setEnabled(true);
        jComboBoxTuberculose.setEnabled(true);
        //
        jComboBoxUsuarioDrogas.setEnabled(true);
        jComboBoxPortadorDoencas.setEnabled(true);
        jComboBoxAlergias.setEnabled(true);
        jQuaisDrogas.setEnabled(true);
        jQuaisDoencas.setEnabled(true);
        jQuaisAlergias.setEnabled(true);
        jObservacao.setEnabled(true);
        // ADMISSÃO
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        // AEF-P1
        jBtNovoAFP1.setEnabled(!true);
        jBtAlterarAFP1.setEnabled(!true);
        jBtExcluirAFP1.setEnabled(!true);
        jBtSalvarAFP1.setEnabled(!true);
        jBtCancelarAFP1.setEnabled(!true);
        jBtAuditoriaAFP1.setEnabled(!true);
        // AEFP2
        jBtNovoAFP2.setEnabled(!true);
        jBtAlterarAFP2.setEnabled(!true);
        jBtExcluirAFP2.setEnabled(!true);
        jBtSalvarAFP2.setEnabled(!true);
        jBtCancelarAFP2.setEnabled(!true);
        jBtAuditoriaAFP2.setEnabled(!true);
        // AEFP3
        jBtNovoAFP3.setEnabled(!true);
        jBtAlterarAFP3.setEnabled(!true);
        jBtExcluirAFP3.setEnabled(!true);
        jBtSalvarAFP3.setEnabled(!true);
        jBtCancelarAFP3.setEnabled(!true);
        jBtAuditoriaAFP3.setEnabled(!true);
        // AEFP4
        jBtNovoAFP4.setEnabled(!true);
        jBtAlterarAFP4.setEnabled(!true);
        jBtExcluirAFP4.setEnabled(!true);
        jBtSalvarAFP4.setEnabled(!true);
        jBtCancelarAFP4.setEnabled(!true);
        jBtAuditoriaAFP4.setEnabled(!true);
        // EVOLUÇÃO
        jBtNovaEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        jBtImpressaoFicha.setEnabled(!true);
    }

    public void Alterar() {
        //Habilitar/Desabilitar Campos        
        jDataLanc.setEnabled(true);
        jBtPesqInternoEnfermaria.setEnabled(true);
        //Habilitar/Desabilitar Campos        
        jDataLanc.setEnabled(true);
        jBtPesqInternoEnfermaria.setEnabled(!true);
        // Estado Emocional
        jRBTranquilo.setEnabled(true);
        jRBAgeressivo.setEnabled(true);
        jRBAgitado.setEnabled(true);
        jRBAnsioso.setEnabled(true);
        jRBTrite.setEnabled(true);
        // Sono/Repouso
        jRBPreservado.setEnabled(true);
        jRBDiminuido.setEnabled(true);
        //Sinais Vitais
        jPressaoArterial.setEnabled(true);
        jHemograma.setEnabled(true);
        jTemperatura.setEnabled(true);
        jFrequenciaRespira.setEnabled(true);
        jPeso.setEnabled(true);
        jFrequenciaCardiaca.setEnabled(true);
        //Nível de consciência
        jRBOrientado.setEnabled(true);
        jRBDesorientado.setEnabled(true);
        //Uso de medicamento.
        jComboBoxUsaMedica.setEnabled(true);
        jQualMedicamento.setEnabled(true);
        // Locomação
        jRBDeambulando.setEnabled(true);
        jRBDeficiente.setEnabled(true);
        jRBDifiDeambulando.setEnabled(true);
        // Acuidade Visual/Auditiva
        jRBAcuiVisualPreservado.setEnabled(true);
        jRBAcuiVisulaDiminuido.setEnabled(true);
        jRBAcuAudiPreservado.setEnabled(true);
        jRBAcuidAudDiminuido.setEnabled(true);
        // Função Motora
        jRBFuncaoComAlteracao.setEnabled(true);
        jRBFuncaoSemAlteracao.setEnabled(true);
        jQualFuncaoMotora.setEnabled(true);
        // Fala/Linguagem
        jRBComAlteracaoFala.setEnabled(true);
        jRBSemAlteracaoFala.setEnabled(true);
        jQualAlteracaoFala.setEnabled(true);
        //Pele/Mucosa
        jRBPeleNormocoradas.setEnabled(true);
        jRBPeleHipocoradas.setEnabled(true);
        jRBPeleHidratadas.setEnabled(true);
        jRBPeleHipohidratada.setEnabled(true);
        jRBPeleIntegra.setEnabled(true);
        jRBPeleLesao.setEnabled(true);
        jTipo.setEnabled(true);
        jLocalizacao.setEnabled(true);
        // Cabelos
        jRBCabelosCalvice.setEnabled(true);
        jRBCabelosIntegro.setEnabled(true);
        jRBCabelosSujidade.setEnabled(true);
        // Boca        
        jRBBocaHalitose.setEnabled(true);
        jRBBocaHalitoseCetonica.setEnabled(true);
        jRBProteseDentaria.setEnabled(true);
        jRBBocaAusenDenteCarie.setEnabled(true);
        //Função Respiratoria         
        jRBFuncaoRespEupneico.setEnabled(true);
        jRBFuncaoRespTaquipenico.setEnabled(true);
        jRBFuncaoRespDispneico.setEnabled(true);
        // Torax
        jRBToraxSimetrico.setEnabled(true);
        jRBToraxAssimetrico.setEnabled(true);
        // Função Intestinal
        jRBFuncaoIntesRegular.setEnabled(true);
        jRBFuncaoIntesAusente.setEnabled(true);
        jRBFuncaoIntesDiarreia.setEnabled(true);
        jRBFuncaoIntesConstipacao.setEnabled(true);
        jCostipacaoDias.setEnabled(true);
        // Abdome
        jRBAbdomeGloboso.setEnabled(true);
        jRBAbdomeFlacido.setEnabled(true);
        jRBAbdomePlano.setEnabled(true);
        // Função Vesical
        jRBFuncaoVesicalFralda.setEnabled(true);
        jRBFuncaoVesicalCV.setEnabled(true);
        jRBFuncaVeisicalEspontanea.setEnabled(true);
        // Genitalia
        jRBGenitaliaIntegra.setEnabled(true);
        jRBGenitaliaComAlteracao.setEnabled(true);
        jQualGenitalia.setEnabled(true);
        // Vacinas
        jComboBoxVacinado.setEnabled(true);
        jQuaisVacinas.setEnabled(true);
        // TESTES RÁPIDOS
        jComboBoxVDRL.setEnabled(true);
        jComboBoxHepatiteC.setEnabled(true);
        jComboBoxHepatiteB.setEnabled(true);
        jComboBoxHIV.setEnabled(true);
        jComboBoxCirurgia.setEnabled(true);
        jQualCirurgia.setEnabled(true);
        jComboBoxSifilis.setEnabled(true);
        jComboBoxHipertensaoMasc.setEnabled(true);
        jComboBoxDiabetesMasc.setEnabled(true);
        jComboBoxTuberculose.setEnabled(true);
        //
        jComboBoxUsuarioDrogas.setEnabled(true);
        jComboBoxPortadorDoencas.setEnabled(true);
        jComboBoxAlergias.setEnabled(true);
        jQuaisDrogas.setEnabled(true);
        jQuaisDoencas.setEnabled(true);
        jQuaisAlergias.setEnabled(true);
        jObservacao.setEnabled(true);
        // ADMISSÃO
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        // AEF-P1
        jBtNovoAFP1.setEnabled(!true);
        jBtAlterarAFP1.setEnabled(!true);
        jBtExcluirAFP1.setEnabled(!true);
        jBtSalvarAFP1.setEnabled(!true);
        jBtCancelarAFP1.setEnabled(!true);
        jBtAuditoriaAFP1.setEnabled(!true);
        // AEFP2
        jBtNovoAFP2.setEnabled(!true);
        jBtAlterarAFP2.setEnabled(!true);
        jBtExcluirAFP2.setEnabled(!true);
        jBtSalvarAFP2.setEnabled(!true);
        jBtCancelarAFP2.setEnabled(!true);
        jBtAuditoriaAFP2.setEnabled(!true);
        // AEFP3
        jBtNovoAFP3.setEnabled(!true);
        jBtAlterarAFP3.setEnabled(!true);
        jBtExcluirAFP3.setEnabled(!true);
        jBtSalvarAFP3.setEnabled(!true);
        jBtCancelarAFP3.setEnabled(!true);
        jBtAuditoriaAFP3.setEnabled(!true);
        // AEFP4
        jBtNovoAFP4.setEnabled(!true);
        jBtAlterarAFP4.setEnabled(!true);
        jBtExcluirAFP4.setEnabled(!true);
        jBtSalvarAFP4.setEnabled(!true);
        jBtCancelarAFP4.setEnabled(!true);
        jBtAuditoriaAFP4.setEnabled(!true);
        // EVOLUÇÃO
        jBtNovaEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        jBtImpressaoFicha.setEnabled(!true);
    }

    public void Excluir() {
        // Limpar campos para inclusão
        jIdLanc.setText("");
        jStatusLanc.setText("");
        jDataLanc.setDate(null);
        //
        jIdInternoMedico.setText("");
        jNomeInternoMedico.setText("");
        jMaeInterno.setText("");
        jPaiInternoMedico.setText("");
        jFotoInternoMedico.setIcon(null);
        jEstadoCivilMedico.setText("");
        // limpa grupo de botões
        Locomocao.clearSelection();
        AcuidadeVisual.clearSelection();
        AcuidadeAuditiva.clearSelection();
        FuncaoMotora.clearSelection();
        EstadoEmocional.clearSelection();
        SonoRepouso.clearSelection();
        NivelConciencia.clearSelection();
        FalaLinguagem.clearSelection();
        Pele.clearSelection();
        Mucosa.clearSelection();
        PeleMucosaHipo.clearSelection();
        Cabelos.clearSelection();
        Boca.clearSelection();
        FuncaoRespiratoria.clearSelection();
        Torax.clearSelection();
        FuncaoIntestinal.clearSelection();
        Abdome.clearSelection();
        FuncaoVesical.clearSelection();
        Genitalia.clearSelection();
        //
        jPressaoArterial.setText("");
        jHemograma.setText("");
        jTemperatura.setText("");
        jFrequenciaRespira.setText("");
        jPeso.setText("");
        jFrequenciaCardiaca.setText("");
        //Uso de medicamento.
        jComboBoxUsaMedica.setSelectedItem("Não");
        jQualMedicamento.setText("");
        //Função Motora
        jQualFuncaoMotora.setText("");
        //Fala/Pele        
        jQualAlteracaoFala.setText("");
        jTipo.setText("");
        jLocalizacao.setText("");
        // Função Intestinal
        jCostipacaoDias.setText("");
        // Genitália
        jQualGenitalia.setText("");
        // Vacinação
        jComboBoxVacinado.setSelectedItem(null);
        jQuaisVacinas.setText("");
        // Testes Rápidos
        jComboBoxVDRL.setSelectedItem("Não reagente");
        jComboBoxHepatiteC.setSelectedItem("Não reagente");
        jComboBoxHepatiteB.setSelectedItem("Não reagente");
        jComboBoxHIV.setSelectedItem("Não reagente");
        jComboBoxUsuarioDrogas.setSelectedItem("Não");
        jComboBoxPortadorDoencas.setSelectedItem("Não");
        jComboBoxAlergias.setSelectedItem("Não");
        jQuaisDrogas.setText("");
        jQuaisDoencas.setText("");
        jQuaisAlergias.setText("");
        jComboBoxSifilis.setSelectedItem("Não reagente");
        jComboBoxHipertensaoMasc.setSelectedItem("Não reagente");
        jComboBoxDiabetesMasc.setSelectedItem("Não reagente");
        jComboBoxTuberculose.setSelectedItem("Negativo");
        // Observação
        jObservacao.setText("");
        //Habilitar/Desabilitar Campos   
        jDataLanc.setEnabled(!true);
        jBtPesqInternoEnfermaria.setEnabled(!true);
        // Estado Emocional
        jRBTranquilo.setEnabled(!true);
        jRBAgeressivo.setEnabled(!true);
        jRBAgitado.setEnabled(!true);
        jRBAnsioso.setEnabled(!true);
        jRBTrite.setEnabled(!true);
        // Sono/Repouso
        jRBPreservado.setEnabled(!true);
        jRBDiminuido.setEnabled(!true);
        //Sinais Vitais
        jPressaoArterial.setEnabled(!true);
        jHemograma.setEnabled(!true);
        jTemperatura.setEnabled(!true);
        jFrequenciaRespira.setEnabled(!true);
        jPeso.setEnabled(!true);
        jFrequenciaCardiaca.setEnabled(!true);
        //Nível de consciência
        jRBOrientado.setEnabled(!true);
        jRBDesorientado.setEnabled(!true);
        //Uso de medicamento.
        jComboBoxUsaMedica.setEnabled(!true);
        jQualMedicamento.setEnabled(!true);
        // Locomação
        jRBDeambulando.setEnabled(!true);
        jRBDeficiente.setEnabled(!true);
        jRBDifiDeambulando.setEnabled(!true);
        // Acuidade Visual/Auditiva
        jRBAcuiVisualPreservado.setEnabled(!true);
        jRBAcuiVisulaDiminuido.setEnabled(!true);
        jRBAcuAudiPreservado.setEnabled(!true);
        jRBAcuidAudDiminuido.setEnabled(!true);
        // Função Motora
        jRBFuncaoComAlteracao.setEnabled(!true);
        jRBFuncaoSemAlteracao.setEnabled(!true);
        jQualFuncaoMotora.setEnabled(!true);
        // Fala/Linguagem
        jRBComAlteracaoFala.setEnabled(!true);
        jRBSemAlteracaoFala.setEnabled(!true);
        jQualAlteracaoFala.setEnabled(!true);
        //Pele/Mucosa
        jRBPeleNormocoradas.setEnabled(!true);
        jRBPeleHipocoradas.setEnabled(!true);
        jRBPeleHidratadas.setEnabled(!true);
        jRBPeleHipohidratada.setEnabled(!true);
        jRBPeleIntegra.setEnabled(!true);
        jRBPeleLesao.setEnabled(!true);
        jTipo.setEnabled(!true);
        jLocalizacao.setEnabled(!true);
        // Cabelos
        jRBCabelosCalvice.setEnabled(!true);
        jRBCabelosIntegro.setEnabled(!true);
        jRBCabelosSujidade.setEnabled(!true);
        // Boca        
        jRBBocaHalitose.setEnabled(!true);
        jRBBocaHalitoseCetonica.setEnabled(!true);
        jRBProteseDentaria.setEnabled(!true);
        jRBBocaAusenDenteCarie.setEnabled(!true);
        //Função Respiratoria         
        jRBFuncaoRespEupneico.setEnabled(!true);
        jRBFuncaoRespTaquipenico.setEnabled(!true);
        jRBFuncaoRespDispneico.setEnabled(!true);
        // Torax
        jRBToraxSimetrico.setEnabled(!true);
        jRBToraxAssimetrico.setEnabled(!true);
        // Função Intestinal
        jRBFuncaoIntesRegular.setEnabled(!true);
        jRBFuncaoIntesAusente.setEnabled(!true);
        jRBFuncaoIntesDiarreia.setEnabled(!true);
        jRBFuncaoIntesConstipacao.setEnabled(!true);
        jCostipacaoDias.setEnabled(!true);
        // Abdome
        jRBAbdomeGloboso.setEnabled(!true);
        jRBAbdomeFlacido.setEnabled(!true);
        jRBAbdomePlano.setEnabled(!true);
        // Função Vesical
        jRBFuncaoVesicalFralda.setEnabled(!true);
        jRBFuncaoVesicalCV.setEnabled(!true);
        jRBFuncaVeisicalEspontanea.setEnabled(!true);
        // Genitalia
        jRBGenitaliaIntegra.setEnabled(!true);
        jRBGenitaliaComAlteracao.setEnabled(!true);
        jQualGenitalia.setEnabled(!true);
        // Vacinas
        jComboBoxVacinado.setEnabled(!true);
        jQuaisVacinas.setEnabled(!true);
        // TESTES RÁPIDOS
        jComboBoxVDRL.setEnabled(!true);
        jComboBoxHepatiteC.setEnabled(!true);
        jComboBoxHepatiteB.setEnabled(!true);
        jComboBoxHIV.setEnabled(!true);
        jComboBoxCirurgia.setEnabled(!true);
        jQualCirurgia.setEnabled(!true);
        jComboBoxSifilis.setEnabled(!true);
        jComboBoxHipertensaoMasc.setEnabled(!true);
        jComboBoxDiabetesMasc.setEnabled(!true);
        jComboBoxTuberculose.setEnabled(!true);
        //
        jComboBoxUsuarioDrogas.setEnabled(!true);
        jComboBoxPortadorDoencas.setEnabled(!true);
        jComboBoxAlergias.setEnabled(!true);
        jQuaisDrogas.setEnabled(!true);
        jQuaisDoencas.setEnabled(!true);
        jQuaisAlergias.setEnabled(!true);
        jObservacao.setEnabled(!true);
        // ADMISSÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        // AEF-P1
        jBtNovoAFP1.setEnabled(!true);
        jBtAlterarAFP1.setEnabled(!true);
        jBtExcluirAFP1.setEnabled(!true);
        jBtSalvarAFP1.setEnabled(!true);
        jBtCancelarAFP1.setEnabled(!true);
        jBtAuditoriaAFP1.setEnabled(!true);
        // AEFP2
        jBtNovoAFP2.setEnabled(!true);
        jBtAlterarAFP2.setEnabled(!true);
        jBtExcluirAFP2.setEnabled(!true);
        jBtSalvarAFP2.setEnabled(!true);
        jBtCancelarAFP2.setEnabled(!true);
        jBtAuditoriaAFP2.setEnabled(!true);
        // AEFP3
        jBtNovoAFP3.setEnabled(!true);
        jBtAlterarAFP3.setEnabled(!true);
        jBtExcluirAFP3.setEnabled(!true);
        jBtSalvarAFP3.setEnabled(!true);
        jBtCancelarAFP3.setEnabled(!true);
        jBtAuditoriaAFP3.setEnabled(!true);
        // AEFP4
        jBtNovoAFP4.setEnabled(!true);
        jBtAlterarAFP4.setEnabled(!true);
        jBtExcluirAFP4.setEnabled(!true);
        jBtSalvarAFP4.setEnabled(!true);
        jBtCancelarAFP4.setEnabled(!true);
        jBtAuditoriaAFP4.setEnabled(!true);
        // EVOLUÇÃO
        jBtNovaEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        jBtImpressaoFicha.setEnabled(!true);
    }

    public void Salvar() {
        //Habilitar/Desabilitar Campos        
        jDataLanc.setEnabled(!true);
        jBtPesqInternoEnfermaria.setEnabled(!true);
        // Estado Emocional
        jRBTranquilo.setEnabled(!true);
        jRBAgeressivo.setEnabled(!true);
        jRBAgitado.setEnabled(!true);
        jRBAnsioso.setEnabled(!true);
        jRBTrite.setEnabled(!true);
        // Sono/Repouso
        jRBPreservado.setEnabled(!true);
        jRBDiminuido.setEnabled(!true);
        //Sinais Vitais
        jPressaoArterial.setEnabled(!true);
        jHemograma.setEnabled(!true);
        jTemperatura.setEnabled(!true);
        jFrequenciaRespira.setEnabled(!true);
        jPeso.setEnabled(!true);
        jFrequenciaCardiaca.setEnabled(!true);
        //Nível de consciência
        jRBOrientado.setEnabled(!true);
        jRBDesorientado.setEnabled(!true);
        //Uso de medicamento.
        jComboBoxUsaMedica.setEnabled(!true);
        jQualMedicamento.setEnabled(!true);
        // Locomação
        jRBDeambulando.setEnabled(!true);
        jRBDeficiente.setEnabled(!true);
        jRBDifiDeambulando.setEnabled(!true);
        // Acuidade Visual/Auditiva
        jRBAcuiVisualPreservado.setEnabled(!true);
        jRBAcuiVisulaDiminuido.setEnabled(!true);
        jRBAcuAudiPreservado.setEnabled(!true);
        jRBAcuidAudDiminuido.setEnabled(!true);
        // Função Motora
        jRBFuncaoComAlteracao.setEnabled(!true);
        jRBFuncaoSemAlteracao.setEnabled(!true);
        jQualFuncaoMotora.setEnabled(!true);
        // Fala/Linguagem
        jRBComAlteracaoFala.setEnabled(!true);
        jRBSemAlteracaoFala.setEnabled(!true);
        jQualAlteracaoFala.setEnabled(!true);
        //Pele/Mucosa
        jRBPeleNormocoradas.setEnabled(!true);
        jRBPeleHipocoradas.setEnabled(!true);
        jRBPeleHidratadas.setEnabled(!true);
        jRBPeleHipohidratada.setEnabled(!true);
        jRBPeleIntegra.setEnabled(!true);
        jRBPeleLesao.setEnabled(!true);
        jTipo.setEnabled(!true);
        jLocalizacao.setEnabled(!true);
        // Cabelos
        jRBCabelosCalvice.setEnabled(!true);
        jRBCabelosIntegro.setEnabled(!true);
        jRBCabelosSujidade.setEnabled(!true);
        // Boca        
        jRBBocaHalitose.setEnabled(!true);
        jRBBocaHalitoseCetonica.setEnabled(!true);
        jRBProteseDentaria.setEnabled(!true);
        jRBBocaAusenDenteCarie.setEnabled(!true);
        //Função Respiratoria         
        jRBFuncaoRespEupneico.setEnabled(!true);
        jRBFuncaoRespTaquipenico.setEnabled(!true);
        jRBFuncaoRespDispneico.setEnabled(!true);
        // Torax
        jRBToraxSimetrico.setEnabled(!true);
        jRBToraxAssimetrico.setEnabled(!true);
        // Função Intestinal
        jRBFuncaoIntesRegular.setEnabled(!true);
        jRBFuncaoIntesAusente.setEnabled(!true);
        jRBFuncaoIntesDiarreia.setEnabled(!true);
        jRBFuncaoIntesConstipacao.setEnabled(!true);
        jCostipacaoDias.setEnabled(!true);
        // Abdome
        jRBAbdomeGloboso.setEnabled(!true);
        jRBAbdomeFlacido.setEnabled(!true);
        jRBAbdomePlano.setEnabled(!true);
        // Função Vesical
        jRBFuncaoVesicalFralda.setEnabled(!true);
        jRBFuncaoVesicalCV.setEnabled(!true);
        jRBFuncaVeisicalEspontanea.setEnabled(!true);
        // Genitalia
        jRBGenitaliaIntegra.setEnabled(!true);
        jRBGenitaliaComAlteracao.setEnabled(!true);
        jQualGenitalia.setEnabled(!true);
        // Vacinas
        jComboBoxVacinado.setEnabled(!true);
        jQuaisVacinas.setEnabled(!true);
        // TESTES RÁPIDOS
        jComboBoxVDRL.setEnabled(!true);
        jComboBoxHepatiteC.setEnabled(!true);
        jComboBoxHepatiteB.setEnabled(!true);
        jComboBoxHIV.setEnabled(!true);
        jComboBoxCirurgia.setEnabled(!true);
        jQualCirurgia.setEnabled(!true);
        jComboBoxSifilis.setEnabled(!true);
        jComboBoxHipertensaoMasc.setEnabled(!true);
        jComboBoxDiabetesMasc.setEnabled(!true);
        jComboBoxTuberculose.setEnabled(!true);
        //
        jComboBoxUsuarioDrogas.setEnabled(!true);
        jComboBoxPortadorDoencas.setEnabled(!true);
        jComboBoxAlergias.setEnabled(!true);
        jQuaisDrogas.setEnabled(!true);
        jQuaisDoencas.setEnabled(!true);
        jQuaisAlergias.setEnabled(!true);
        jObservacao.setEnabled(!true);
        // ADMISSÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        // AEF-P1
        jBtNovoAFP1.setEnabled(true);
        jBtAlterarAFP1.setEnabled(!true);
        jBtExcluirAFP1.setEnabled(!true);
        jBtSalvarAFP1.setEnabled(!true);
        jBtCancelarAFP1.setEnabled(!true);
        jBtAuditoriaAFP1.setEnabled(!true);
        // AEFP2
        jBtNovoAFP2.setEnabled(true);
        jBtAlterarAFP2.setEnabled(!true);
        jBtExcluirAFP2.setEnabled(!true);
        jBtSalvarAFP2.setEnabled(!true);
        jBtCancelarAFP2.setEnabled(!true);
        jBtAuditoriaAFP2.setEnabled(!true);
        // AEFP3
        jBtNovoAFP3.setEnabled(true);
        jBtAlterarAFP3.setEnabled(!true);
        jBtExcluirAFP3.setEnabled(!true);
        jBtSalvarAFP3.setEnabled(!true);
        jBtCancelarAFP3.setEnabled(!true);
        jBtAuditoriaAFP3.setEnabled(!true);
        // AEFP4
        jBtNovoAFP4.setEnabled(true);
        jBtAlterarAFP4.setEnabled(!true);
        jBtExcluirAFP4.setEnabled(!true);
        jBtSalvarAFP4.setEnabled(!true);
        jBtCancelarAFP4.setEnabled(!true);
        jBtAuditoriaAFP4.setEnabled(!true);
        // EVOLUÇÃO
        jBtNovaEvolucao.setEnabled(true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        jBtImpressaoFicha.setEnabled(true);
    }

    public void Cancelar() {
        if (jIdLanc.getText().equals("")) {
            jStatusLanc.setText("");
            jDataLanc.setDate(null);
            //
            jIdInternoMedico.setText("");
            jNomeInternoMedico.setText("");
            jMaeInterno.setText("");
            jPaiInternoMedico.setText("");
            jFotoInternoMedico.setIcon(null);
            jEstadoCivilMedico.setText("");
            // limpa grupo de botões
            Locomocao.clearSelection();
            AcuidadeVisual.clearSelection();
            AcuidadeAuditiva.clearSelection();
            FuncaoMotora.clearSelection();
            EstadoEmocional.clearSelection();
            SonoRepouso.clearSelection();
            NivelConciencia.clearSelection();
            FalaLinguagem.clearSelection();
            Pele.clearSelection();
            Mucosa.clearSelection();
            PeleMucosaHipo.clearSelection();
            Cabelos.clearSelection();
            Boca.clearSelection();
            FuncaoRespiratoria.clearSelection();
            Torax.clearSelection();
            FuncaoIntestinal.clearSelection();
            Abdome.clearSelection();
            FuncaoVesical.clearSelection();
            Genitalia.clearSelection();
            //
            jPressaoArterial.setText("");
            jHemograma.setText("");
            jTemperatura.setText("");
            jFrequenciaRespira.setText("");
            jPeso.setText("");
            jFrequenciaCardiaca.setText("");
            //Uso de medicamento.
            jComboBoxUsaMedica.setSelectedItem("Não");
            jQualMedicamento.setText("");
            //Função Motora
            jQualFuncaoMotora.setText("");
            //Fala/Pele        
            jQualAlteracaoFala.setText("");
            jTipo.setText("");
            jLocalizacao.setText("");
            // Função Intestinal
            jCostipacaoDias.setText("");
            // Genitália
            jQualGenitalia.setText("");
            // Vacinação
            jComboBoxVacinado.setSelectedItem("Não");
            jQuaisVacinas.setText("");
            // Testes Rápidos
            jComboBoxVDRL.setSelectedItem("Não reagente");
            jComboBoxHepatiteC.setSelectedItem("Não reagente");
            jComboBoxHepatiteB.setSelectedItem("Não reagente");
            jComboBoxHIV.setSelectedItem("Não reagente");
            jComboBoxUsuarioDrogas.setSelectedItem("Não");
            jComboBoxPortadorDoencas.setSelectedItem("Não");
            jComboBoxAlergias.setSelectedItem("Não");
            jQuaisDrogas.setText("");
            jQuaisDoencas.setText("");
            jQuaisAlergias.setText("");
            jComboBoxSifilis.setSelectedItem("Não");
            jComboBoxHipertensaoMasc.setSelectedItem("Não");
            jComboBoxDiabetesMasc.setSelectedItem("Não");
            jComboBoxTuberculose.setSelectedItem("Negativo");
            // Observação
            jObservacao.setText("");
            //Habilitar/Desabilitar Campos        
            jDataLanc.setEnabled(!true);
            jBtPesqInternoEnfermaria.setEnabled(!true);
            // Estado Emocional
            jRBTranquilo.setEnabled(!true);
            jRBAgeressivo.setEnabled(!true);
            jRBAgitado.setEnabled(!true);
            jRBAnsioso.setEnabled(!true);
            jRBTrite.setEnabled(!true);
            // Sono/Repouso
            jRBPreservado.setEnabled(!true);
            jRBDiminuido.setEnabled(!true);
            //Sinais Vitais
            jPressaoArterial.setEnabled(!true);
            jHemograma.setEnabled(!true);
            jTemperatura.setEnabled(!true);
            jFrequenciaRespira.setEnabled(!true);
            jPeso.setEnabled(!true);
            jFrequenciaCardiaca.setEnabled(!true);
            //Nível de consciência
            jRBOrientado.setEnabled(!true);
            jRBDesorientado.setEnabled(!true);
            //Uso de medicamento.
            jComboBoxUsaMedica.setEnabled(!true);
            jQualMedicamento.setEnabled(!true);
            // Locomação
            jRBDeambulando.setEnabled(!true);
            jRBDeficiente.setEnabled(!true);
            jRBDifiDeambulando.setEnabled(!true);
            // Acuidade Visual/Auditiva
            jRBAcuiVisualPreservado.setEnabled(!true);
            jRBAcuiVisulaDiminuido.setEnabled(!true);
            jRBAcuAudiPreservado.setEnabled(!true);
            jRBAcuidAudDiminuido.setEnabled(!true);
            // Função Motora
            jRBFuncaoComAlteracao.setEnabled(!true);
            jRBFuncaoSemAlteracao.setEnabled(!true);
            jQualFuncaoMotora.setEnabled(!true);
            // Fala/Linguagem
            jRBComAlteracaoFala.setEnabled(!true);
            jRBSemAlteracaoFala.setEnabled(!true);
            jQualAlteracaoFala.setEnabled(!true);
            //Pele/Mucosa
            jRBPeleNormocoradas.setEnabled(!true);
            jRBPeleHipocoradas.setEnabled(!true);
            jRBPeleHidratadas.setEnabled(!true);
            jRBPeleHipohidratada.setEnabled(!true);
            jRBPeleIntegra.setEnabled(!true);
            jRBPeleLesao.setEnabled(!true);
            jTipo.setEnabled(!true);
            jLocalizacao.setEnabled(!true);
            // Cabelos
            jRBCabelosCalvice.setEnabled(!true);
            jRBCabelosIntegro.setEnabled(!true);
            jRBCabelosSujidade.setEnabled(!true);
            // Boca        
            jRBBocaHalitose.setEnabled(!true);
            jRBBocaHalitoseCetonica.setEnabled(!true);
            jRBProteseDentaria.setEnabled(!true);
            jRBBocaAusenDenteCarie.setEnabled(!true);
            //Função Respiratoria         
            jRBFuncaoRespEupneico.setEnabled(!true);
            jRBFuncaoRespTaquipenico.setEnabled(!true);
            jRBFuncaoRespDispneico.setEnabled(!true);
            // Torax
            jRBToraxSimetrico.setEnabled(!true);
            jRBToraxAssimetrico.setEnabled(!true);
            // Função Intestinal
            jRBFuncaoIntesRegular.setEnabled(!true);
            jRBFuncaoIntesAusente.setEnabled(!true);
            jRBFuncaoIntesDiarreia.setEnabled(!true);
            jRBFuncaoIntesConstipacao.setEnabled(!true);
            jCostipacaoDias.setEnabled(!true);
            // Abdome
            jRBAbdomeGloboso.setEnabled(!true);
            jRBAbdomeFlacido.setEnabled(!true);
            jRBAbdomePlano.setEnabled(!true);
            // Função Vesical
            jRBFuncaoVesicalFralda.setEnabled(!true);
            jRBFuncaoVesicalCV.setEnabled(!true);
            jRBFuncaVeisicalEspontanea.setEnabled(!true);
            // Genitalia
            jRBGenitaliaIntegra.setEnabled(!true);
            jRBGenitaliaComAlteracao.setEnabled(!true);
            jQualGenitalia.setEnabled(!true);
            // Vacinas
            jComboBoxVacinado.setEnabled(!true);
            jQuaisVacinas.setEnabled(!true);
            // TESTES RÁPIDOS
            jComboBoxVDRL.setEnabled(!true);
            jComboBoxHepatiteC.setEnabled(!true);
            jComboBoxHepatiteB.setEnabled(!true);
            jComboBoxHIV.setEnabled(!true);
            jComboBoxCirurgia.setEnabled(!true);
            jQualCirurgia.setEnabled(!true);
            jComboBoxSifilis.setEnabled(!true);
            jComboBoxHipertensaoMasc.setEnabled(!true);
            jComboBoxDiabetesMasc.setEnabled(!true);
            jComboBoxTuberculose.setEnabled(!true);
            //
            jComboBoxUsuarioDrogas.setEnabled(!true);
            jComboBoxPortadorDoencas.setEnabled(!true);
            jComboBoxAlergias.setEnabled(!true);
            jQuaisDrogas.setEnabled(!true);
            jQuaisDoencas.setEnabled(!true);
            jQuaisAlergias.setEnabled(!true);
            jObservacao.setEnabled(!true);
            // ADMISSÃO
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
            jBtAuditoria.setEnabled(!true);
            // AEF-P1
            jBtNovoAFP1.setEnabled(!true);
            jBtAlterarAFP1.setEnabled(!true);
            jBtExcluirAFP1.setEnabled(!true);
            jBtSalvarAFP1.setEnabled(!true);
            jBtCancelarAFP1.setEnabled(!true);
            jBtAuditoriaAFP1.setEnabled(!true);
            // AEFP2
            jBtNovoAFP2.setEnabled(!true);
            jBtAlterarAFP2.setEnabled(!true);
            jBtExcluirAFP2.setEnabled(!true);
            jBtSalvarAFP2.setEnabled(!true);
            jBtCancelarAFP2.setEnabled(!true);
            jBtAuditoriaAFP2.setEnabled(!true);
            // AEFP3
            jBtNovoAFP3.setEnabled(!true);
            jBtAlterarAFP3.setEnabled(!true);
            jBtExcluirAFP3.setEnabled(!true);
            jBtSalvarAFP3.setEnabled(!true);
            jBtCancelarAFP3.setEnabled(!true);
            jBtAuditoriaAFP3.setEnabled(!true);
            // AEFP4
            jBtNovoAFP4.setEnabled(!true);
            jBtAlterarAFP4.setEnabled(!true);
            jBtExcluirAFP4.setEnabled(!true);
            jBtSalvarAFP4.setEnabled(!true);
            jBtCancelarAFP4.setEnabled(!true);
            jBtAuditoriaAFP4.setEnabled(!true);
            // EVOLUÇÃO
            jBtNovaEvolucao.setEnabled(!true);
            jBtAlterarEvolucao.setEnabled(!true);
            jBtExcluirEvolucao.setEnabled(!true);
            jBtSalvarEvolucao.setEnabled(!true);
            jBtCancelarEvolucao.setEnabled(!true);
            jBtAuditoriaEvolucao.setEnabled(!true);
            jBtImpressaoFicha.setEnabled(!true);
        } else {
            //Habilitar/Desabilitar Campos        
            jDataLanc.setEnabled(!true);
            jBtPesqInternoEnfermaria.setEnabled(!true);
            // Estado Emocional
            jRBTranquilo.setEnabled(!true);
            jRBAgeressivo.setEnabled(!true);
            jRBAgitado.setEnabled(!true);
            jRBAnsioso.setEnabled(!true);
            jRBTrite.setEnabled(!true);
            // Sono/Repouso
            jRBPreservado.setEnabled(!true);
            jRBDiminuido.setEnabled(!true);
            //Sinais Vitais
            jPressaoArterial.setEnabled(!true);
            jHemograma.setEnabled(!true);
            jTemperatura.setEnabled(!true);
            jFrequenciaRespira.setEnabled(!true);
            jPeso.setEnabled(!true);
            jFrequenciaCardiaca.setEnabled(!true);
            //Nível de consciência
            jRBOrientado.setEnabled(!true);
            jRBDesorientado.setEnabled(!true);
            //Uso de medicamento.
            jComboBoxUsaMedica.setEnabled(!true);
            jQualMedicamento.setEnabled(!true);
            // Locomação
            jRBDeambulando.setEnabled(!true);
            jRBDeficiente.setEnabled(!true);
            jRBDifiDeambulando.setEnabled(!true);
            // Acuidade Visual/Auditiva
            jRBAcuiVisualPreservado.setEnabled(!true);
            jRBAcuiVisulaDiminuido.setEnabled(!true);
            jRBAcuAudiPreservado.setEnabled(!true);
            jRBAcuidAudDiminuido.setEnabled(!true);
            // Função Motora
            jRBFuncaoComAlteracao.setEnabled(!true);
            jRBFuncaoSemAlteracao.setEnabled(!true);
            jQualFuncaoMotora.setEnabled(!true);
            // Fala/Linguagem
            jRBComAlteracaoFala.setEnabled(!true);
            jRBSemAlteracaoFala.setEnabled(!true);
            jQualAlteracaoFala.setEnabled(!true);
            //Pele/Mucosa
            jRBPeleNormocoradas.setEnabled(!true);
            jRBPeleHipocoradas.setEnabled(!true);
            jRBPeleHidratadas.setEnabled(!true);
            jRBPeleHipohidratada.setEnabled(!true);
            jRBPeleIntegra.setEnabled(!true);
            jRBPeleLesao.setEnabled(!true);
            jTipo.setEnabled(!true);
            jLocalizacao.setEnabled(!true);
            // Cabelos
            jRBCabelosCalvice.setEnabled(!true);
            jRBCabelosIntegro.setEnabled(!true);
            jRBCabelosSujidade.setEnabled(!true);
            // Boca        
            jRBBocaHalitose.setEnabled(!true);
            jRBBocaHalitoseCetonica.setEnabled(!true);
            jRBProteseDentaria.setEnabled(!true);
            jRBBocaAusenDenteCarie.setEnabled(!true);
            //Função Respiratoria         
            jRBFuncaoRespEupneico.setEnabled(!true);
            jRBFuncaoRespTaquipenico.setEnabled(!true);
            jRBFuncaoRespDispneico.setEnabled(!true);
            // Torax
            jRBToraxSimetrico.setEnabled(!true);
            jRBToraxAssimetrico.setEnabled(!true);
            // Função Intestinal
            jRBFuncaoIntesRegular.setEnabled(!true);
            jRBFuncaoIntesAusente.setEnabled(!true);
            jRBFuncaoIntesDiarreia.setEnabled(!true);
            jRBFuncaoIntesConstipacao.setEnabled(!true);
            jCostipacaoDias.setEnabled(!true);
            // Abdome
            jRBAbdomeGloboso.setEnabled(!true);
            jRBAbdomeFlacido.setEnabled(!true);
            jRBAbdomePlano.setEnabled(!true);
            // Função Vesical
            jRBFuncaoVesicalFralda.setEnabled(!true);
            jRBFuncaoVesicalCV.setEnabled(!true);
            jRBFuncaVeisicalEspontanea.setEnabled(!true);
            // Genitalia
            jRBGenitaliaIntegra.setEnabled(!true);
            jRBGenitaliaComAlteracao.setEnabled(!true);
            jQualGenitalia.setEnabled(!true);
            // Vacinas
            jComboBoxVacinado.setEnabled(!true);
            jQuaisVacinas.setEnabled(!true);
            //
            jComboBoxVDRL.setEnabled(!true);
            jComboBoxHepatiteC.setEnabled(!true);
            jComboBoxHepatiteB.setEnabled(!true);
            jComboBoxHIV.setEnabled(!true);
            jComboBoxCirurgia.setEnabled(!true);
            jQualCirurgia.setEnabled(!true);
            jComboBoxSifilis.setEnabled(!true);
            jComboBoxHipertensaoMasc.setEnabled(!true);
            jComboBoxDiabetesMasc.setEnabled(!true);
            jComboBoxTuberculose.setEnabled(!true);
            //
            jComboBoxUsuarioDrogas.setEnabled(!true);
            jComboBoxPortadorDoencas.setEnabled(!true);
            jComboBoxAlergias.setEnabled(!true);
            jQuaisDrogas.setEnabled(!true);
            jQuaisDoencas.setEnabled(!true);
            jQuaisAlergias.setEnabled(!true);
            jObservacao.setEnabled(!true);
            // ADMISSÃO
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            jBtImpressaoFicha.setEnabled(true);
            // AEF-P1
            jBtNovoAFP1.setEnabled(true);
            jBtAlterarAFP1.setEnabled(!true);
            jBtExcluirAFP1.setEnabled(!true);
            jBtSalvarAFP1.setEnabled(!true);
            jBtCancelarAFP1.setEnabled(!true);
            jBtAuditoriaAFP1.setEnabled(!true);
            // AEFP2
            jBtNovoAFP2.setEnabled(true);
            jBtAlterarAFP2.setEnabled(!true);
            jBtExcluirAFP2.setEnabled(!true);
            jBtSalvarAFP2.setEnabled(!true);
            jBtCancelarAFP2.setEnabled(!true);
            jBtAuditoriaAFP2.setEnabled(!true);
            // AEFP3
            jBtNovoAFP3.setEnabled(true);
            jBtAlterarAFP3.setEnabled(!true);
            jBtExcluirAFP3.setEnabled(!true);
            jBtSalvarAFP3.setEnabled(!true);
            jBtCancelarAFP3.setEnabled(!true);
            jBtAuditoriaAFP3.setEnabled(!true);
            // AEFP4
            jBtNovoAFP4.setEnabled(true);
            jBtAlterarAFP4.setEnabled(!true);
            jBtExcluirAFP4.setEnabled(!true);
            jBtSalvarAFP4.setEnabled(!true);
            jBtCancelarAFP4.setEnabled(!true);
            jBtAuditoriaAFP4.setEnabled(!true);
            // EVOLUÇÃO
            jBtNovaEvolucao.setEnabled(true);
            jBtAlterarEvolucao.setEnabled(!true);
            jBtExcluirEvolucao.setEnabled(!true);
            jBtSalvarEvolucao.setEnabled(!true);
            jBtCancelarEvolucao.setEnabled(!true);
            jBtAuditoriaEvolucao.setEnabled(!true);
        }
    }

    public void NovoAFP1() {
        jComboBoxHipertensao.setSelectedItem("Não");
        jComboBoxCardiopatias.setSelectedItem("Não");
        jComboBoxAnemias.setSelectedItem("Não");
        jComboBoxDoencasRenais.setSelectedItem("Não");
        jComboBoxDiabetes.setSelectedItem("Não");
        jComboBoxAPAlergias.setSelectedItem("Não");
        jComboBoxPortadorHIV.setSelectedItem("Não");
        jComboBoxTransfusao.setSelectedItem("Não");
        jComboBoxRetroviarias.setSelectedItem("Não");
        jQuaisRetroviarias.setText("");
        jComboBoxCirurgias.setSelectedItem("Não");
        jDataCirurgia.setDate(null);
        jTipoCirurgia.setText("");
        jCiclosMenstruais.setText("");
        jMetodosAnticoncepcionais.setText("");
        jDoencasSexualmenteTransmissiveis.setText("");
        jColpocitologiaOncotica.setText("");
        //
        jComboBoxHipertensao.setEnabled(true);
        jComboBoxCardiopatias.setEnabled(true);
        jComboBoxAnemias.setEnabled(true);
        jComboBoxDoencasRenais.setEnabled(true);
        jComboBoxDiabetes.setEnabled(true);
        jComboBoxAPAlergias.setEnabled(true);
        jComboBoxPortadorHIV.setEnabled(true);
        jComboBoxTransfusao.setEnabled(true);
        jComboBoxRetroviarias.setEnabled(true);
        jQuaisRetroviarias.setEnabled(true);
        jComboBoxCirurgias.setEnabled(true);
        jDataCirurgia.setEnabled(true);
        jTipoCirurgia.setEnabled(true);
        jCiclosMenstruais.setEnabled(true);
        jMetodosAnticoncepcionais.setEnabled(true);
        jDoencasSexualmenteTransmissiveis.setEnabled(true);
        jColpocitologiaOncotica.setEnabled(true);
        // AEF-P1
        jBtNovoAFP1.setEnabled(!true);
        jBtAlterarAFP1.setEnabled(!true);
        jBtExcluirAFP1.setEnabled(!true);
        jBtSalvarAFP1.setEnabled(true);
        jBtCancelarAFP1.setEnabled(true);
        jBtAuditoriaAFP1.setEnabled(!true);
        // ADMISSÃO
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        // AEFP2
        jBtNovoAFP2.setEnabled(!true);
        jBtAlterarAFP2.setEnabled(!true);
        jBtExcluirAFP2.setEnabled(!true);
        jBtSalvarAFP2.setEnabled(!true);
        jBtCancelarAFP2.setEnabled(!true);
        jBtAuditoriaAFP2.setEnabled(!true);
        // AEFP3
        jBtNovoAFP3.setEnabled(!true);
        jBtAlterarAFP3.setEnabled(!true);
        jBtExcluirAFP3.setEnabled(!true);
        jBtSalvarAFP3.setEnabled(!true);
        jBtCancelarAFP3.setEnabled(!true);
        jBtAuditoriaAFP3.setEnabled(!true);
        // AEFP4
        jBtNovoAFP4.setEnabled(!true);
        jBtAlterarAFP4.setEnabled(!true);
        jBtExcluirAFP4.setEnabled(!true);
        jBtSalvarAFP4.setEnabled(!true);
        jBtCancelarAFP4.setEnabled(!true);
        jBtAuditoriaAFP4.setEnabled(!true);
        // EVOLUÇÃO
        jBtNovaEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        jBtImpressaoFicha.setEnabled(!true);
    }

    public void AlterarAFP1() {
        jComboBoxHipertensao.setEnabled(true);
        jComboBoxCardiopatias.setEnabled(true);
        jComboBoxAnemias.setEnabled(true);
        jComboBoxDoencasRenais.setEnabled(true);
        jComboBoxDiabetes.setEnabled(true);
        jComboBoxAPAlergias.setEnabled(true);
        jComboBoxPortadorHIV.setEnabled(true);
        jComboBoxTransfusao.setEnabled(true);
        jComboBoxRetroviarias.setEnabled(true);
        jQuaisRetroviarias.setEnabled(true);
        jComboBoxCirurgias.setEnabled(true);
        jDataCirurgia.setEnabled(true);
        jTipoCirurgia.setEnabled(true);
        jCiclosMenstruais.setEnabled(true);
        jMetodosAnticoncepcionais.setEnabled(true);
        jDoencasSexualmenteTransmissiveis.setEnabled(true);
        jColpocitologiaOncotica.setEnabled(true);
        // AEF-P1
        jBtNovoAFP1.setEnabled(!true);
        jBtAlterarAFP1.setEnabled(!true);
        jBtExcluirAFP1.setEnabled(!true);
        jBtSalvarAFP1.setEnabled(true);
        jBtCancelarAFP1.setEnabled(true);
        jBtAuditoriaAFP1.setEnabled(!true);
        // ADMISSÃO
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        // AEFP2
        jBtNovoAFP2.setEnabled(!true);
        jBtAlterarAFP2.setEnabled(!true);
        jBtExcluirAFP2.setEnabled(!true);
        jBtSalvarAFP2.setEnabled(!true);
        jBtCancelarAFP2.setEnabled(!true);
        jBtAuditoriaAFP2.setEnabled(!true);
        // AEFP3
        jBtNovoAFP3.setEnabled(!true);
        jBtAlterarAFP3.setEnabled(!true);
        jBtExcluirAFP3.setEnabled(!true);
        jBtSalvarAFP3.setEnabled(!true);
        jBtCancelarAFP3.setEnabled(!true);
        jBtAuditoriaAFP3.setEnabled(!true);
        // AEFP4
        jBtNovoAFP4.setEnabled(!true);
        jBtAlterarAFP4.setEnabled(!true);
        jBtExcluirAFP4.setEnabled(!true);
        jBtSalvarAFP4.setEnabled(!true);
        jBtCancelarAFP4.setEnabled(!true);
        jBtAuditoriaAFP4.setEnabled(!true);
        // EVOLUÇÃO
        jBtNovaEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        jBtImpressaoFicha.setEnabled(!true);
    }

    public void ExcluirAFP1() {
        jComboBoxHipertensao.setSelectedItem("Não");
        jComboBoxCardiopatias.setSelectedItem("Não");
        jComboBoxAnemias.setSelectedItem("Não");
        jComboBoxDoencasRenais.setSelectedItem("Não");
        jComboBoxDiabetes.setSelectedItem("Não");
        jComboBoxAPAlergias.setSelectedItem("Não");
        jComboBoxPortadorHIV.setSelectedItem("Não");
        jComboBoxTransfusao.setSelectedItem("Não");
        jComboBoxRetroviarias.setSelectedItem("Não");
        jQuaisRetroviarias.setText("");
        jComboBoxCirurgias.setSelectedItem("Não");
        jDataCirurgia.setDate(null);
        jTipoCirurgia.setText("");
        jCiclosMenstruais.setText("");
        jMetodosAnticoncepcionais.setText("");
        jDoencasSexualmenteTransmissiveis.setText("");
        jColpocitologiaOncotica.setText("");
        //
        jComboBoxHipertensao.setEnabled(!true);
        jComboBoxCardiopatias.setEnabled(!true);
        jComboBoxAnemias.setEnabled(!true);
        jComboBoxDoencasRenais.setEnabled(!true);
        jComboBoxDiabetes.setEnabled(!true);
        jComboBoxAPAlergias.setEnabled(!true);
        jComboBoxPortadorHIV.setEnabled(!true);
        jComboBoxTransfusao.setEnabled(!true);
        jComboBoxRetroviarias.setEnabled(!true);
        jQuaisRetroviarias.setEnabled(!true);
        jComboBoxCirurgias.setEnabled(!true);
        jDataCirurgia.setEnabled(!true);
        jTipoCirurgia.setEnabled(!true);
        jCiclosMenstruais.setEnabled(!true);
        jMetodosAnticoncepcionais.setEnabled(!true);
        jDoencasSexualmenteTransmissiveis.setEnabled(!true);
        jColpocitologiaOncotica.setEnabled(!true);
        // AEF-P1
        jBtNovoAFP1.setEnabled(true);
        jBtAlterarAFP1.setEnabled(!true);
        jBtExcluirAFP1.setEnabled(!true);
        jBtSalvarAFP1.setEnabled(!true);
        jBtCancelarAFP1.setEnabled(!true);
        jBtAuditoriaAFP1.setEnabled(!true);
        // ADMISSÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        jBtImpressaoFicha.setEnabled(true);
        // AEFP2
        jBtNovoAFP2.setEnabled(true);
        jBtAlterarAFP2.setEnabled(!true);
        jBtExcluirAFP2.setEnabled(!true);
        jBtSalvarAFP2.setEnabled(!true);
        jBtCancelarAFP2.setEnabled(!true);
        jBtAuditoriaAFP2.setEnabled(!true);
        // AEFP3
        jBtNovoAFP3.setEnabled(true);
        jBtAlterarAFP3.setEnabled(!true);
        jBtExcluirAFP3.setEnabled(!true);
        jBtSalvarAFP3.setEnabled(!true);
        jBtCancelarAFP3.setEnabled(!true);
        jBtAuditoriaAFP3.setEnabled(!true);
        // AEFP4
        jBtNovoAFP4.setEnabled(true);
        jBtAlterarAFP4.setEnabled(!true);
        jBtExcluirAFP4.setEnabled(!true);
        jBtSalvarAFP4.setEnabled(!true);
        jBtCancelarAFP4.setEnabled(!true);
        jBtAuditoriaAFP4.setEnabled(!true);
        // EVOLUÇÃO
        jBtNovaEvolucao.setEnabled(true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
    }

    public void SalvarAFP1() {

        jComboBoxHipertensao.setEnabled(!true);
        jComboBoxCardiopatias.setEnabled(!true);
        jComboBoxAnemias.setEnabled(!true);
        jComboBoxDoencasRenais.setEnabled(!true);
        jComboBoxDiabetes.setEnabled(!true);
        jComboBoxAPAlergias.setEnabled(!true);
        jComboBoxPortadorHIV.setEnabled(!true);
        jComboBoxTransfusao.setEnabled(!true);
        jComboBoxRetroviarias.setEnabled(!true);
        jQuaisRetroviarias.setEnabled(!true);
        jComboBoxCirurgias.setEnabled(!true);
        jDataCirurgia.setEnabled(!true);
        jTipoCirurgia.setEnabled(!true);
        jCiclosMenstruais.setEnabled(!true);
        jMetodosAnticoncepcionais.setEnabled(!true);
        jDoencasSexualmenteTransmissiveis.setEnabled(!true);
        jColpocitologiaOncotica.setEnabled(!true);
        // AEF-P1
        jBtNovoAFP1.setEnabled(true);
        jBtAlterarAFP1.setEnabled(true);
        jBtExcluirAFP1.setEnabled(true);
        jBtSalvarAFP1.setEnabled(!true);
        jBtCancelarAFP1.setEnabled(true);
        jBtAuditoriaAFP1.setEnabled(true);
        // ADMISSÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        jBtImpressaoFicha.setEnabled(true);
        // AEFP2
        jBtNovoAFP2.setEnabled(true);
        jBtAlterarAFP2.setEnabled(!true);
        jBtExcluirAFP2.setEnabled(!true);
        jBtSalvarAFP2.setEnabled(!true);
        jBtCancelarAFP2.setEnabled(!true);
        jBtAuditoriaAFP2.setEnabled(!true);
        // AEFP3
        jBtNovoAFP3.setEnabled(true);
        jBtAlterarAFP3.setEnabled(!true);
        jBtExcluirAFP3.setEnabled(!true);
        jBtSalvarAFP3.setEnabled(!true);
        jBtCancelarAFP3.setEnabled(!true);
        jBtAuditoriaAFP3.setEnabled(!true);
        // AEFP4
        jBtNovoAFP4.setEnabled(true);
        jBtAlterarAFP4.setEnabled(!true);
        jBtExcluirAFP4.setEnabled(!true);
        jBtSalvarAFP4.setEnabled(!true);
        jBtCancelarAFP4.setEnabled(!true);
        jBtAuditoriaAFP4.setEnabled(!true);
        // EVOLUÇÃO
        jBtNovaEvolucao.setEnabled(true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
    }

    public void CancelarAFP1() {

        jComboBoxHipertensao.setEnabled(!true);
        jComboBoxCardiopatias.setEnabled(!true);
        jComboBoxAnemias.setEnabled(!true);
        jComboBoxDoencasRenais.setEnabled(!true);
        jComboBoxDiabetes.setEnabled(!true);
        jComboBoxAPAlergias.setEnabled(!true);
        jComboBoxPortadorHIV.setEnabled(!true);
        jComboBoxTransfusao.setEnabled(!true);
        jComboBoxRetroviarias.setEnabled(!true);
        jQuaisRetroviarias.setEnabled(!true);
        jComboBoxCirurgias.setEnabled(!true);
        jDataCirurgia.setEnabled(!true);
        jTipoCirurgia.setEnabled(!true);
        jCiclosMenstruais.setEnabled(!true);
        jMetodosAnticoncepcionais.setEnabled(!true);
        jDoencasSexualmenteTransmissiveis.setEnabled(!true);
        jColpocitologiaOncotica.setEnabled(!true);
        // AEF -P1
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ADME_AFP1 "
                    + "INNER JOIN ADMISSAOENFERMEIRA "
                    + "ON ADME_AFP1.IdLanc=ADMISSAOENFERMEIRA.IdLanc "
                    + "WHERE ADME_AFP1.IdLanc='" + jIdLanc.getText() + "'");
            conecta.rs.first();
            codigoAFP1 = conecta.rs.getInt("IdAfp1");
            jComboBoxHipertensao.setSelectedItem(conecta.rs.getString("Hipertensao"));
            jComboBoxCardiopatias.setSelectedItem(conecta.rs.getString("Cardiopatias"));
            jComboBoxAnemias.setSelectedItem(conecta.rs.getString("Anemias"));
            jComboBoxDoencasRenais.setSelectedItem(conecta.rs.getString("DoencasRenais"));
            jComboBoxDiabetes.setSelectedItem(conecta.rs.getString("Diabetes"));
            jComboBoxAPAlergias.setSelectedItem(conecta.rs.getString("APAlergias"));
            jComboBoxPortadorHIV.setSelectedItem(conecta.rs.getString("PortadorHIV"));
            jComboBoxTransfusao.setSelectedItem(conecta.rs.getString("Transfusao"));
            jComboBoxRetroviarias.setSelectedItem(conecta.rs.getString("Retroviarias"));
            jQuaisRetroviarias.setText(conecta.rs.getString("QuaisRetroviarias"));
            jComboBoxCirurgias.setSelectedItem(conecta.rs.getString("Cirurgias"));
            jDataCirurgia.setDate(conecta.rs.getDate("DataCirurgia"));
            jTipoCirurgia.setText(conecta.rs.getString("TipoCirurgia"));
            jCiclosMenstruais.setText(conecta.rs.getString("Ciclos"));
            jMetodosAnticoncepcionais.setText(conecta.rs.getString("Metodos"));
            jDoencasSexualmenteTransmissiveis.setText(conecta.rs.getString("Doencas"));
            jColpocitologiaOncotica.setText(conecta.rs.getString("Colpocitologia"));
        } catch (Exception e) {
        }
        if (codigoAFP1 != 0) {
            jBtNovoAFP1.setEnabled(true);
            jBtAlterarAFP1.setEnabled(true);
            jBtExcluirAFP1.setEnabled(true);
            jBtSalvarAFP1.setEnabled(!true);
            jBtCancelarAFP1.setEnabled(true);
            jBtAuditoriaAFP1.setEnabled(true);
            //
            jBtNovoAFP2.setEnabled(true);
            jBtNovoAFP3.setEnabled(true);
            jBtNovoAFP4.setEnabled(true);
            jBtNovaEvolucao.setEnabled(true);
            // ADMISSÃO
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtImpressaoFicha.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
        } else {
            // ADMISSÃO
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtImpressaoFicha.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            //
            jBtNovoAFP1.setEnabled(true);
            jBtNovoAFP2.setEnabled(true);
            jBtNovoAFP3.setEnabled(true);
            jBtNovoAFP4.setEnabled(true);
            jBtNovaEvolucao.setEnabled(true);
        }
    }

    public void buscarCodigoAFP1() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ADME_AFP1");
            conecta.rs.last();
            codigoAFP1 = conecta.rs.getInt("IdAfp1");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarAEFP1() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ADME_AFP1 "
                    + "WHERE IdLanc='" + jIdLanc.getText() + "' "
                    + "AND IdInternoCrc='" + jIdInternoMedico.getText() + "'");
            conecta.rs.first();
            codigoAdm1 = conecta.rs.getString("IdLanc");
            codigoInternoAdm1 = conecta.rs.getString("IdInternoCrc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void NovoAFP2() {
        jNumeroGestacoes.setText("0");
        jNumeroPartos.setText("0");
        jNumeroAbortos.setText("0");
        jNumeroFilhosVivos.setText("0");
        jIdadePrimeiraGestacao.setText("0");
        jIntervaloGestacoes.setText("0");
        jPretermo.setText("0");
        jPostermo.setText("0");
        jBaixoPeso.setText("0");
        jMortesNeonataisPrecoce.setText("0");
        jMotivoMorteNeonataisPrecoce.setText("");
        jMortesNeonataisTardias.setText("0");
        jMotivoMortesNeonataisTardias.setText("");
        jNatimortos.setText("0");
        jIctericia.setText("0");
        jTransfusao.setText("0");
        jHipoglicemia.setText("0");
        jIsoimunizacaoRH.setText("");
        jIntercorrenciaComplicacoesGestoes.setText("");
        jHistoriaAleitamentosAnteriores.setText("");
        //
        jNumeroGestacoes.setEnabled(true);
        jNumeroPartos.setEnabled(true);
        jNumeroAbortos.setEnabled(true);
        jNumeroFilhosVivos.setEnabled(true);
        jIdadePrimeiraGestacao.setEnabled(true);
        jIntervaloGestacoes.setEnabled(true);
        jPretermo.setEnabled(true);
        jPostermo.setEnabled(true);
        jBaixoPeso.setEnabled(true);
        jMortesNeonataisPrecoce.setEnabled(true);
        jMotivoMorteNeonataisPrecoce.setEnabled(true);
        jMortesNeonataisTardias.setEnabled(true);
        jMotivoMortesNeonataisTardias.setEnabled(true);
        jNatimortos.setEnabled(true);
        jIctericia.setEnabled(true);
        jTransfusao.setEnabled(true);
        jHipoglicemia.setEnabled(true);
        jIsoimunizacaoRH.setEnabled(true);
        jIntercorrenciaComplicacoesGestoes.setEnabled(true);
        jHistoriaAleitamentosAnteriores.setEnabled(true);
        // AEFP2
        jBtNovoAFP2.setEnabled(!true);
        jBtAlterarAFP2.setEnabled(!true);
        jBtExcluirAFP2.setEnabled(!true);
        jBtSalvarAFP2.setEnabled(true);
        jBtCancelarAFP2.setEnabled(true);
        jBtAuditoriaAFP2.setEnabled(!true);
        // AEF-P1
        jBtNovoAFP1.setEnabled(!true);
        jBtAlterarAFP1.setEnabled(!true);
        jBtExcluirAFP1.setEnabled(!true);
        jBtSalvarAFP1.setEnabled(!true);
        jBtCancelarAFP1.setEnabled(!true);
        jBtAuditoriaAFP1.setEnabled(!true);
        // ADMISSÃO
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        jBtImpressaoFicha.setEnabled(!true);
        // AEFP3
        jBtNovoAFP3.setEnabled(!true);
        jBtAlterarAFP3.setEnabled(!true);
        jBtExcluirAFP3.setEnabled(!true);
        jBtSalvarAFP3.setEnabled(!true);
        jBtCancelarAFP3.setEnabled(!true);
        jBtAuditoriaAFP3.setEnabled(!true);
        // AEFP4
        jBtNovoAFP4.setEnabled(!true);
        jBtAlterarAFP4.setEnabled(!true);
        jBtExcluirAFP4.setEnabled(!true);
        jBtSalvarAFP4.setEnabled(!true);
        jBtCancelarAFP4.setEnabled(!true);
        jBtAuditoriaAFP4.setEnabled(!true);
        // EVOLUÇÃO
        jBtNovaEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
    }

    public void AlterarAFP2() {
        jNumeroGestacoes.setEnabled(true);
        jNumeroPartos.setEnabled(true);
        jNumeroAbortos.setEnabled(true);
        jNumeroFilhosVivos.setEnabled(true);
        jIdadePrimeiraGestacao.setEnabled(true);
        jIntervaloGestacoes.setEnabled(true);
        jPretermo.setEnabled(true);
        jPostermo.setEnabled(true);
        jBaixoPeso.setEnabled(true);
        jMortesNeonataisPrecoce.setEnabled(true);
        jMotivoMorteNeonataisPrecoce.setEnabled(true);
        jMortesNeonataisTardias.setEnabled(true);
        jMotivoMortesNeonataisTardias.setEnabled(true);
        jNatimortos.setEnabled(true);
        jIctericia.setEnabled(true);
        jTransfusao.setEnabled(true);
        jHipoglicemia.setEnabled(true);
        jIsoimunizacaoRH.setEnabled(true);
        jIntercorrenciaComplicacoesGestoes.setEnabled(true);
        jHistoriaAleitamentosAnteriores.setEnabled(true);
        // AEFP2
        jBtNovoAFP2.setEnabled(!true);
        jBtAlterarAFP2.setEnabled(!true);
        jBtExcluirAFP2.setEnabled(!true);
        jBtSalvarAFP2.setEnabled(true);
        jBtCancelarAFP2.setEnabled(true);
        jBtAuditoriaAFP2.setEnabled(!true);
        // AEF-P1
        jBtNovoAFP1.setEnabled(!true);
        jBtAlterarAFP1.setEnabled(!true);
        jBtExcluirAFP1.setEnabled(!true);
        jBtSalvarAFP1.setEnabled(!true);
        jBtCancelarAFP1.setEnabled(!true);
        jBtAuditoriaAFP1.setEnabled(!true);
        // ADMISSÃO
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        jBtImpressaoFicha.setEnabled(!true);
        // AEFP3
        jBtNovoAFP3.setEnabled(!true);
        jBtAlterarAFP3.setEnabled(!true);
        jBtExcluirAFP3.setEnabled(!true);
        jBtSalvarAFP3.setEnabled(!true);
        jBtCancelarAFP3.setEnabled(!true);
        jBtAuditoriaAFP3.setEnabled(!true);
        // AEFP4
        jBtNovoAFP4.setEnabled(!true);
        jBtAlterarAFP4.setEnabled(!true);
        jBtExcluirAFP4.setEnabled(!true);
        jBtSalvarAFP4.setEnabled(!true);
        jBtCancelarAFP4.setEnabled(!true);
        jBtAuditoriaAFP4.setEnabled(!true);
        // EVOLUÇÃO
        jBtNovaEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
    }

    public void ExcluirAFP2() {
        jNumeroGestacoes.setText("");
        jNumeroPartos.setText("");
        jNumeroAbortos.setText("");
        jNumeroFilhosVivos.setText("");
        jIdadePrimeiraGestacao.setText("");
        jIntervaloGestacoes.setText("");
        jPretermo.setText("");
        jPostermo.setText("");
        jBaixoPeso.setText("");
        jMortesNeonataisPrecoce.setText("");
        jMotivoMorteNeonataisPrecoce.setText("");
        jMortesNeonataisTardias.setText("");
        jMotivoMortesNeonataisTardias.setText("");
        jNatimortos.setText("");
        jIctericia.setText("");
        jTransfusao.setText("");
        jHipoglicemia.setText("");
        jIsoimunizacaoRH.setText("");
        jIntercorrenciaComplicacoesGestoes.setText("");
        jHistoriaAleitamentosAnteriores.setText("");
        //
        jNumeroGestacoes.setEnabled(!true);
        jNumeroPartos.setEnabled(!true);
        jNumeroAbortos.setEnabled(!true);
        jNumeroFilhosVivos.setEnabled(!true);
        jIdadePrimeiraGestacao.setEnabled(!true);
        jIntervaloGestacoes.setEnabled(!true);
        jPretermo.setEnabled(!true);
        jPostermo.setEnabled(!true);
        jBaixoPeso.setEnabled(!true);
        jMortesNeonataisPrecoce.setEnabled(!true);
        jMotivoMorteNeonataisPrecoce.setEnabled(!true);
        jMortesNeonataisTardias.setEnabled(!true);
        jMotivoMortesNeonataisTardias.setEnabled(!true);
        jNatimortos.setEnabled(!true);
        jIctericia.setEnabled(!true);
        jTransfusao.setEnabled(!true);
        jHipoglicemia.setEnabled(!true);
        jIsoimunizacaoRH.setEnabled(!true);
        jIntercorrenciaComplicacoesGestoes.setEnabled(!true);
        jHistoriaAleitamentosAnteriores.setEnabled(!true);
        // AEFP2
        jBtNovoAFP2.setEnabled(true);
        jBtAlterarAFP2.setEnabled(!true);
        jBtExcluirAFP2.setEnabled(!true);
        jBtSalvarAFP2.setEnabled(!true);
        jBtCancelarAFP2.setEnabled(!true);
        jBtAuditoriaAFP2.setEnabled(!true);
        // AEF-P1
        jBtNovoAFP1.setEnabled(true);
        jBtAlterarAFP1.setEnabled(!true);
        jBtExcluirAFP1.setEnabled(!true);
        jBtSalvarAFP1.setEnabled(!true);
        jBtCancelarAFP1.setEnabled(!true);
        jBtAuditoriaAFP1.setEnabled(!true);
        // ADMISSÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        jBtImpressaoFicha.setEnabled(true);
        // AEFP3
        jBtNovoAFP3.setEnabled(true);
        jBtAlterarAFP3.setEnabled(!true);
        jBtExcluirAFP3.setEnabled(!true);
        jBtSalvarAFP3.setEnabled(!true);
        jBtCancelarAFP3.setEnabled(!true);
        jBtAuditoriaAFP3.setEnabled(!true);
        // AEFP4
        jBtNovoAFP4.setEnabled(true);
        jBtAlterarAFP4.setEnabled(!true);
        jBtExcluirAFP4.setEnabled(!true);
        jBtSalvarAFP4.setEnabled(!true);
        jBtCancelarAFP4.setEnabled(!true);
        jBtAuditoriaAFP4.setEnabled(!true);
        // EVOLUÇÃO
        jBtNovaEvolucao.setEnabled(true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
    }

    public void SalvarAFP2() {
        jNumeroGestacoes.setEnabled(!true);
        jNumeroPartos.setEnabled(!true);
        jNumeroAbortos.setEnabled(!true);
        jNumeroFilhosVivos.setEnabled(!true);
        jIdadePrimeiraGestacao.setEnabled(!true);
        jIntervaloGestacoes.setEnabled(!true);
        jPretermo.setEnabled(!true);
        jPostermo.setEnabled(!true);
        jBaixoPeso.setEnabled(!true);
        jMortesNeonataisPrecoce.setEnabled(!true);
        jMotivoMorteNeonataisPrecoce.setEnabled(!true);
        jMortesNeonataisTardias.setEnabled(!true);
        jMotivoMortesNeonataisTardias.setEnabled(!true);
        jNatimortos.setEnabled(!true);
        jIctericia.setEnabled(!true);
        jTransfusao.setEnabled(!true);
        jHipoglicemia.setEnabled(!true);
        jIsoimunizacaoRH.setEnabled(!true);
        jIntercorrenciaComplicacoesGestoes.setEnabled(!true);
        jHistoriaAleitamentosAnteriores.setEnabled(!true);
        // AEFP2
        jBtNovoAFP2.setEnabled(true);
        jBtAlterarAFP2.setEnabled(true);
        jBtExcluirAFP2.setEnabled(true);
        jBtSalvarAFP2.setEnabled(!true);
        jBtCancelarAFP2.setEnabled(true);
        jBtAuditoriaAFP2.setEnabled(true);
        // AEF-P1
        jBtNovoAFP1.setEnabled(true);
        jBtAlterarAFP1.setEnabled(!true);
        jBtExcluirAFP1.setEnabled(!true);
        jBtSalvarAFP1.setEnabled(!true);
        jBtCancelarAFP1.setEnabled(!true);
        jBtAuditoriaAFP1.setEnabled(!true);
        // ADMISSÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        jBtImpressaoFicha.setEnabled(true);
        // AEFP3
        jBtNovoAFP3.setEnabled(true);
        jBtAlterarAFP3.setEnabled(!true);
        jBtExcluirAFP3.setEnabled(!true);
        jBtSalvarAFP3.setEnabled(!true);
        jBtCancelarAFP3.setEnabled(!true);
        jBtAuditoriaAFP3.setEnabled(!true);
        // AEFP4
        jBtNovoAFP4.setEnabled(true);
        jBtAlterarAFP4.setEnabled(!true);
        jBtExcluirAFP4.setEnabled(!true);
        jBtSalvarAFP4.setEnabled(!true);
        jBtCancelarAFP4.setEnabled(!true);
        jBtAuditoriaAFP4.setEnabled(!true);
        // EVOLUÇÃO
        jBtNovaEvolucao.setEnabled(true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
    }

    public void CancelarAFP2() {
        jNumeroGestacoes.setEnabled(!true);
        jNumeroPartos.setEnabled(!true);
        jNumeroAbortos.setEnabled(!true);
        jNumeroFilhosVivos.setEnabled(!true);
        jIdadePrimeiraGestacao.setEnabled(!true);
        jIntervaloGestacoes.setEnabled(!true);
        jPretermo.setEnabled(!true);
        jPostermo.setEnabled(!true);
        jBaixoPeso.setEnabled(!true);
        jMortesNeonataisPrecoce.setEnabled(!true);
        jMotivoMorteNeonataisPrecoce.setEnabled(!true);
        jMortesNeonataisTardias.setEnabled(!true);
        jMotivoMortesNeonataisTardias.setEnabled(!true);
        jNatimortos.setEnabled(!true);
        jIctericia.setEnabled(!true);
        jTransfusao.setEnabled(!true);
        jHipoglicemia.setEnabled(!true);
        jIsoimunizacaoRH.setEnabled(!true);
        jIntercorrenciaComplicacoesGestoes.setEnabled(!true);
        jHistoriaAleitamentosAnteriores.setEnabled(!true);
        //AEF-P2
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ADME_AFP2 "
                    + "INNER JOIN ADMISSAOENFERMEIRA "
                    + "ON ADME_AFP2.IdLanc=ADMISSAOENFERMEIRA.IdLanc "
                    + "WHERE ADME_AFP2.IdLanc='" + jIdLanc.getText() + "'");
            conecta.rs.first();
            codigoAFP2 = conecta.rs.getInt("IdAfp2");
            jNumeroGestacoes.setText(conecta.rs.getString("NumeroGestacoes"));
            jNumeroPartos.setText(conecta.rs.getString("NumeroPartos"));
            jNumeroAbortos.setText(conecta.rs.getString("NumeroAbortos"));
            jNumeroFilhosVivos.setText(conecta.rs.getString("NumeroFilhosVivos"));
            jIdadePrimeiraGestacao.setText(conecta.rs.getString("IdadePrimeiraGestacao"));
            jIntervaloGestacoes.setText(conecta.rs.getString("IntervaloGestacoes"));
            jPretermo.setText(conecta.rs.getString("Pretermo"));
            jPostermo.setText(conecta.rs.getString("Postermo"));
            jBaixoPeso.setText(conecta.rs.getString("BaixoPeso"));
            jMortesNeonataisPrecoce.setText(conecta.rs.getString("MortesNeonataisPrecoce"));
            jMotivoMorteNeonataisPrecoce.setText(conecta.rs.getString("MotivoMorteNeonataisPrecoce"));
            jMortesNeonataisTardias.setText(conecta.rs.getString("MortesNeonataisTardias"));
            jMotivoMortesNeonataisTardias.setText(conecta.rs.getString("MotivoMortesNeonataisTardias"));
            jNatimortos.setText(conecta.rs.getString("Natimortos"));
            jIctericia.setText(conecta.rs.getString("Ictericia"));
            jTransfusao.setText(conecta.rs.getString("Transfusao"));
            jHipoglicemia.setText(conecta.rs.getString("Hipoglicemia"));
            jIsoimunizacaoRH.setText(conecta.rs.getString("IsoimunizacaoRH"));
            jIntercorrenciaComplicacoesGestoes.setText(conecta.rs.getString("IntercorrenciaComplicacoesGestoes"));
            jHistoriaAleitamentosAnteriores.setText(conecta.rs.getString("HistoriaAleitamentosAnteriores"));
        } catch (Exception e) {
        }
        if (codigoAFP2 != 0) {
            jBtNovoAFP2.setEnabled(true);
            jBtAlterarAFP2.setEnabled(true);
            jBtExcluirAFP2.setEnabled(true);
            jBtSalvarAFP2.setEnabled(!true);
            jBtCancelarAFP2.setEnabled(true);
            jBtAuditoriaAFP2.setEnabled(true);
            //
            jBtNovoAFP1.setEnabled(true);
            jBtNovoAFP3.setEnabled(true);
            jBtNovoAFP4.setEnabled(true);
            jBtNovaEvolucao.setEnabled(true);
            // ADMISSÃO
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtImpressaoFicha.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
        } else {
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtImpressaoFicha.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            //
            jBtNovoAFP1.setEnabled(true);
            jBtNovoAFP2.setEnabled(true);
            jBtNovoAFP3.setEnabled(true);
            jBtNovoAFP4.setEnabled(true);
            jBtNovaEvolucao.setEnabled(true);
        }
    }

    public void buscarCodigoAFP2() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ADME_AFP2");
            conecta.rs.last();
            codigoAFP2 = conecta.rs.getInt("IdAfp2");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarAEFP2() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ADME_AFP2 "
                    + "WHERE IdLanc='" + jIdLanc.getText() + "' "
                    + "AND IdInternoCrc='" + jIdInternoMedico.getText() + "'");
            conecta.rs.first();
            codigoAdm2 = conecta.rs.getString("IdLanc");
            codigoInternoAdm2 = conecta.rs.getString("IdInternoCrc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void NovoAFP3() {
        jDataUltimaMenstruacao.setDate(null);
        jComboBoxGestante.setSelectedItem("Nao");
        jCertezaDuvidaGestacao.setText("");
        jHabitosAlimentares.setText("");
        jMedicamentoGestacao.setText("");
        jComboBoxInternacaoGestacao.setSelectedItem("Nao");
        jOndeGestacao.setText("");
        jCheckBoxCigarro.setSelected(!true);
        jCheckBoxPacaia.setSelected(!true);
        jCheckBoxMaconha.setSelected(!true);
        jCheckBoxCocaina.setSelected(!true);
        jCheckBoxCraque.setSelected(!true);
        jCheckBoxAlcool.setSelected(!true);
        jCheckBoxOutros.setSelected(!true);
        jQuaisDrogras.setText("");
        jSinaisSintomas.setText("");
        jOcupacaoHabitual.setText("");
        jAceitacaoGravidez.setText("");
        //
        jDataUltimaMenstruacao.setEnabled(true);
        jComboBoxGestante.setEnabled(true);
        jCertezaDuvidaGestacao.setEnabled(true);
        jHabitosAlimentares.setEnabled(true);
        jMedicamentoGestacao.setEnabled(true);
        jComboBoxInternacaoGestacao.setEnabled(true);
        jOndeGestacao.setEnabled(true);
        jCheckBoxCigarro.setEnabled(true);
        jCheckBoxPacaia.setEnabled(true);
        jCheckBoxMaconha.setEnabled(true);
        jCheckBoxCocaina.setEnabled(true);
        jCheckBoxCraque.setEnabled(true);
        jCheckBoxAlcool.setEnabled(true);
        jCheckBoxOutros.setEnabled(true);
        jSinaisSintomas.setEnabled(true);
        jQuaisDrogras.setEnabled(true);
        jOcupacaoHabitual.setEnabled(true);
        jAceitacaoGravidez.setEnabled(true);
        // AEFP3
        jBtNovoAFP3.setEnabled(!true);
        jBtAlterarAFP3.setEnabled(!true);
        jBtExcluirAFP3.setEnabled(!true);
        jBtSalvarAFP3.setEnabled(true);
        jBtCancelarAFP3.setEnabled(true);
        jBtAuditoriaAFP3.setEnabled(!true);
        // AEFP4
        jBtNovoAFP4.setEnabled(!true);
        jBtAlterarAFP4.setEnabled(!true);
        jBtExcluirAFP4.setEnabled(!true);
        jBtSalvarAFP4.setEnabled(!true);
        jBtCancelarAFP4.setEnabled(!true);
        jBtAuditoriaAFP4.setEnabled(!true);
        // AEFP2
        jBtNovoAFP2.setEnabled(!true);
        jBtAlterarAFP2.setEnabled(!true);
        jBtExcluirAFP2.setEnabled(!true);
        jBtSalvarAFP2.setEnabled(!true);
        jBtCancelarAFP2.setEnabled(!true);
        jBtAuditoriaAFP2.setEnabled(!true);
        // AEF-P1
        jBtNovoAFP1.setEnabled(!true);
        jBtAlterarAFP1.setEnabled(!true);
        jBtExcluirAFP1.setEnabled(!true);
        jBtSalvarAFP1.setEnabled(!true);
        jBtCancelarAFP1.setEnabled(!true);
        jBtAuditoriaAFP1.setEnabled(!true);
        // ADMISSÃO
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        jBtImpressaoFicha.setEnabled(!true);
        // EVOLUÇÃO
        jBtNovaEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
    }

    public void AlterarAFP3() {
        jDataUltimaMenstruacao.setEnabled(true);
        jComboBoxGestante.setEnabled(true);
        jCertezaDuvidaGestacao.setEnabled(true);
        jHabitosAlimentares.setEnabled(true);
        jMedicamentoGestacao.setEnabled(true);
        jComboBoxInternacaoGestacao.setEnabled(true);
        jOndeGestacao.setEnabled(true);
        jCheckBoxCigarro.setEnabled(true);
        jCheckBoxPacaia.setEnabled(true);
        jCheckBoxMaconha.setEnabled(true);
        jCheckBoxCocaina.setEnabled(true);
        jCheckBoxCraque.setEnabled(true);
        jCheckBoxAlcool.setEnabled(true);
        jCheckBoxOutros.setEnabled(true);
        jQuaisDrogras.setEnabled(true);
        jSinaisSintomas.setEnabled(true);
        jOcupacaoHabitual.setEnabled(true);
        jAceitacaoGravidez.setEnabled(true);
        // AEFP3
        jBtNovoAFP3.setEnabled(!true);
        jBtAlterarAFP3.setEnabled(!true);
        jBtExcluirAFP3.setEnabled(!true);
        jBtSalvarAFP3.setEnabled(true);
        jBtCancelarAFP3.setEnabled(true);
        jBtAuditoriaAFP3.setEnabled(!true);
        // AEFP4
        jBtNovoAFP4.setEnabled(!true);
        jBtAlterarAFP4.setEnabled(!true);
        jBtExcluirAFP4.setEnabled(!true);
        jBtSalvarAFP4.setEnabled(!true);
        jBtCancelarAFP4.setEnabled(!true);
        jBtAuditoriaAFP4.setEnabled(!true);
        // AEFP2
        jBtNovoAFP2.setEnabled(!true);
        jBtAlterarAFP2.setEnabled(!true);
        jBtExcluirAFP2.setEnabled(!true);
        jBtSalvarAFP2.setEnabled(!true);
        jBtCancelarAFP2.setEnabled(!true);
        jBtAuditoriaAFP2.setEnabled(!true);
        // AEF-P1
        jBtNovoAFP1.setEnabled(!true);
        jBtAlterarAFP1.setEnabled(!true);
        jBtExcluirAFP1.setEnabled(!true);
        jBtSalvarAFP1.setEnabled(!true);
        jBtCancelarAFP1.setEnabled(!true);
        jBtAuditoriaAFP1.setEnabled(!true);
        // ADMISSÃO
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        jBtImpressaoFicha.setEnabled(!true);
        // EVOLUÇÃO
        jBtNovaEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
    }

    public void ExcluirAFP3() {
        jDataUltimaMenstruacao.setDate(null);
        jComboBoxGestante.setSelectedItem("Nao");
        jCertezaDuvidaGestacao.setText("");
        jHabitosAlimentares.setText("");
        jMedicamentoGestacao.setText("");
        jComboBoxInternacaoGestacao.setSelectedItem("Nao");
        jOndeGestacao.setText("");
        jCheckBoxCigarro.setSelected(!true);
        jCheckBoxPacaia.setSelected(!true);
        jCheckBoxMaconha.setSelected(!true);
        jCheckBoxCocaina.setSelected(!true);
        jCheckBoxCraque.setSelected(!true);
        jCheckBoxAlcool.setSelected(!true);
        jCheckBoxOutros.setSelected(!true);
        jQuaisDrogras.setText("");
        jSinaisSintomas.setText("");
        jOcupacaoHabitual.setText("");
        jAceitacaoGravidez.setText("");
        //
        jDataUltimaMenstruacao.setEnabled(!true);
        jComboBoxGestante.setEnabled(!true);
        jCertezaDuvidaGestacao.setEnabled(!true);
        jHabitosAlimentares.setEnabled(!true);
        jMedicamentoGestacao.setEnabled(!true);
        jComboBoxInternacaoGestacao.setEnabled(!true);
        jOndeGestacao.setEnabled(!true);
        jCheckBoxCigarro.setEnabled(!true);
        jCheckBoxPacaia.setEnabled(!true);
        jCheckBoxMaconha.setEnabled(!true);
        jCheckBoxCocaina.setEnabled(!true);
        jCheckBoxCraque.setEnabled(!true);
        jCheckBoxAlcool.setEnabled(!true);
        jCheckBoxOutros.setEnabled(!true);
        jQuaisDrogras.setEnabled(!true);
        jSinaisSintomas.setEnabled(!true);
        jOcupacaoHabitual.setEnabled(!true);
        jAceitacaoGravidez.setEnabled(!true);
        // AEFP3
        jBtNovoAFP3.setEnabled(true);
        jBtAlterarAFP3.setEnabled(!true);
        jBtExcluirAFP3.setEnabled(!true);
        jBtSalvarAFP3.setEnabled(!true);
        jBtCancelarAFP3.setEnabled(!true);
        jBtAuditoriaAFP3.setEnabled(!true);
        // AEFP4
        jBtNovoAFP4.setEnabled(true);
        jBtAlterarAFP4.setEnabled(!true);
        jBtExcluirAFP4.setEnabled(!true);
        jBtSalvarAFP4.setEnabled(!true);
        jBtCancelarAFP4.setEnabled(!true);
        jBtAuditoriaAFP4.setEnabled(!true);
        // AEFP2
        jBtNovoAFP2.setEnabled(true);
        jBtAlterarAFP2.setEnabled(!true);
        jBtExcluirAFP2.setEnabled(!true);
        jBtSalvarAFP2.setEnabled(!true);
        jBtCancelarAFP2.setEnabled(!true);
        jBtAuditoriaAFP2.setEnabled(!true);
        // AEF-P1
        jBtNovoAFP1.setEnabled(true);
        jBtAlterarAFP1.setEnabled(!true);
        jBtExcluirAFP1.setEnabled(!true);
        jBtSalvarAFP1.setEnabled(!true);
        jBtCancelarAFP1.setEnabled(!true);
        jBtAuditoriaAFP1.setEnabled(!true);
        // ADMISSÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        jBtImpressaoFicha.setEnabled(true);
        // EVOLUÇÃO
        jBtNovaEvolucao.setEnabled(true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
    }

    public void SalvarAFP3() {
        jDataUltimaMenstruacao.setEnabled(!true);
        jComboBoxGestante.setEnabled(!true);
        jCertezaDuvidaGestacao.setEnabled(!true);
        jHabitosAlimentares.setEnabled(!true);
        jMedicamentoGestacao.setEnabled(!true);
        jComboBoxInternacaoGestacao.setEnabled(!true);
        jOndeGestacao.setEnabled(!true);
        jCheckBoxCigarro.setEnabled(!true);
        jCheckBoxPacaia.setEnabled(!true);
        jCheckBoxMaconha.setEnabled(!true);
        jCheckBoxCocaina.setEnabled(!true);
        jCheckBoxCraque.setEnabled(!true);
        jCheckBoxAlcool.setEnabled(!true);
        jCheckBoxOutros.setEnabled(!true);
        jQuaisDrogras.setEnabled(!true);
        jSinaisSintomas.setEnabled(!true);
        jOcupacaoHabitual.setEnabled(!true);
        jAceitacaoGravidez.setEnabled(!true);
        // AEFP3
        jBtNovoAFP3.setEnabled(true);
        jBtAlterarAFP3.setEnabled(true);
        jBtExcluirAFP3.setEnabled(true);
        jBtSalvarAFP3.setEnabled(!true);
        jBtCancelarAFP3.setEnabled(!true);
        jBtAuditoriaAFP3.setEnabled(true);
        // AEFP4
        jBtNovoAFP4.setEnabled(true);
        jBtAlterarAFP4.setEnabled(!true);
        jBtExcluirAFP4.setEnabled(!true);
        jBtSalvarAFP4.setEnabled(!true);
        jBtCancelarAFP4.setEnabled(!true);
        jBtAuditoriaAFP4.setEnabled(!true);
        // AEFP2
        jBtNovoAFP2.setEnabled(true);
        jBtAlterarAFP2.setEnabled(!true);
        jBtExcluirAFP2.setEnabled(!true);
        jBtSalvarAFP2.setEnabled(!true);
        jBtCancelarAFP2.setEnabled(!true);
        jBtAuditoriaAFP2.setEnabled(!true);
        // AEF-P1
        jBtNovoAFP1.setEnabled(true);
        jBtAlterarAFP1.setEnabled(!true);
        jBtExcluirAFP1.setEnabled(!true);
        jBtSalvarAFP1.setEnabled(!true);
        jBtCancelarAFP1.setEnabled(!true);
        jBtAuditoriaAFP1.setEnabled(!true);
        // ADMISSÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        jBtImpressaoFicha.setEnabled(true);
        // EVOLUÇÃO
        jBtNovaEvolucao.setEnabled(true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
    }

    public void CancelarAFP3() {
        jDataUltimaMenstruacao.setEnabled(!true);
        jComboBoxGestante.setEnabled(!true);
        jCertezaDuvidaGestacao.setEnabled(!true);
        jHabitosAlimentares.setEnabled(!true);
        jMedicamentoGestacao.setEnabled(!true);
        jComboBoxInternacaoGestacao.setEnabled(!true);
        jOndeGestacao.setEnabled(!true);
        jCheckBoxCigarro.setEnabled(!true);
        jCheckBoxPacaia.setEnabled(!true);
        jCheckBoxMaconha.setEnabled(!true);
        jCheckBoxCocaina.setEnabled(!true);
        jCheckBoxCraque.setEnabled(!true);
        jCheckBoxAlcool.setEnabled(!true);
        jCheckBoxOutros.setEnabled(!true);
        jQuaisDrogras.setEnabled(!true);
        jSinaisSintomas.setEnabled(!true);
        jOcupacaoHabitual.setEnabled(!true);
        jAceitacaoGravidez.setEnabled(!true);
        //AEF-P3
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ADME_AFP3 "
                    + "INNER JOIN ADMISSAOENFERMEIRA "
                    + "ON ADME_AFP3.IdLanc=ADMISSAOENFERMEIRA.IdLanc "
                    + "WHERE ADME_AFP3.IdLanc='" + jIdLanc.getText() + "'");
            conecta.rs.first();
            codigoAFP3 = conecta.rs.getInt("IdAfp3");
            jDataUltimaMenstruacao.setDate(conecta.rs.getDate("DataUltimaMenstruacao"));
            jComboBoxGestante.setSelectedItem(conecta.rs.getString("Gestante"));
            jCertezaDuvidaGestacao.setText(conecta.rs.getString("CertezaDuvidaGestacao"));
            jHabitosAlimentares.setText(conecta.rs.getString("HabitosAlimentares"));
            jMedicamentoGestacao.setText(conecta.rs.getString("MedicamentoGestacao"));
            jComboBoxInternacaoGestacao.setSelectedItem(conecta.rs.getString("InternacaoGestacao"));
            jOndeGestacao.setText(conecta.rs.getString("OndeGestacao"));
            jQuaisDrogras.setText(conecta.rs.getString("QuaisDrogras"));
            jSinaisSintomas.setText(conecta.rs.getString("SinaisSintomas"));
            jOcupacaoHabitual.setText(conecta.rs.getString("OcupacaoHabitual"));
            jAceitacaoGravidez.setText(conecta.rs.getString("AceitacaoGravidez"));
            tipoDrogaCigarro = conecta.rs.getInt("Cigarro");
            if (tipoDrogaCigarro == 0) {
                jCheckBoxCigarro.setSelected(true);
            } else if (tipoDrogaCigarro == 1) {
                jCheckBoxCigarro.setSelected(!true);
            }
            tipoDrogaPacaia = conecta.rs.getInt("Pacaia");
            if (tipoDrogaPacaia == 0) {
                jCheckBoxPacaia.setSelected(true);
            } else if (tipoDrogaPacaia == 1) {
                jCheckBoxPacaia.setSelected(!true);
            }
            tipoDrogaMaconha = conecta.rs.getInt("Maconha");
            if (tipoDrogaMaconha == 0) {
                jCheckBoxMaconha.setSelected(true);
            } else if (tipoDrogaMaconha == 1) {
                jCheckBoxMaconha.setSelected(!true);
            }
            tipoDrogaCocaina = conecta.rs.getInt("Cocaina");
            if (tipoDrogaCocaina == 0) {
                jCheckBoxCocaina.setSelected(true);
            } else if (tipoDrogaCocaina == 1) {
                jCheckBoxCocaina.setSelected(!true);
            }
            tipoDrogaCraque = conecta.rs.getInt("Craque");
            if (tipoDrogaCraque == 0) {
                jCheckBoxCraque.setSelected(true);
            } else if (tipoDrogaCraque == 1) {
                jCheckBoxCraque.setSelected(!true);
            }
            tipoDrogaAlcool = conecta.rs.getInt("Alcool");
            if (tipoDrogaAlcool == 0) {
                jCheckBoxAlcool.setSelected(true);
            } else if (tipoDrogaAlcool == 1) {
                jCheckBoxAlcool.setSelected(!true);
            }
            tipoDrogaOutros = conecta.rs.getInt("Outros");
            if (tipoDrogaOutros == 0) {
                jCheckBoxOutros.setSelected(true);
            } else if (tipoDrogaOutros == 1) {
                jCheckBoxOutros.setSelected(!true);
            }
        } catch (Exception e) {
        }
        if (codigoAFP3 != 0) {
            jBtNovoAFP3.setEnabled(true);
            jBtAlterarAFP3.setEnabled(true);
            jBtExcluirAFP3.setEnabled(true);
            jBtSalvarAFP3.setEnabled(!true);
            jBtCancelarAFP3.setEnabled(true);
            jBtAuditoriaAFP3.setEnabled(true);
            //
            jBtNovoAFP1.setEnabled(true);
            jBtNovoAFP2.setEnabled(true);
            jBtNovoAFP4.setEnabled(true);
            jBtNovaEvolucao.setEnabled(true);
            // ADMISSÃO
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtImpressaoFicha.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
        } else {
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtImpressaoFicha.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            //
            jBtNovoAFP1.setEnabled(true);
            jBtNovoAFP2.setEnabled(true);
            jBtNovoAFP3.setEnabled(true);
            jBtNovoAFP4.setEnabled(true);
            jBtNovaEvolucao.setEnabled(true);
        }
    }

    public void buscarCodigoAFP3() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ADME_AFP3");
            conecta.rs.last();
            codigoAFP3 = conecta.rs.getInt("IdAfp3");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarAEFP3() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ADME_AFP3 "
                    + "WHERE IdLanc='" + jIdLanc.getText() + "' "
                    + "AND IdInternoCrc='" + jIdInternoMedico.getText() + "'");
            conecta.rs.first();
            codigoAdm3 = conecta.rs.getString("IdLanc");
            codigoInternoAdm3 = conecta.rs.getString("IdInternoCrc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void NovoAFP4() {
        jPesoGestante.setText("0");
        jAlturaGestante.setText("0");
        jCheckBoxFace.setSelected(!true);
        jCheckBoxTronco.setSelected(!true);
        jCheckBoxMembroInferior.setSelected(!true);
        jCheckBoxMembroSuperior.setSelected(!true);
        jInspecaoPeleMucosa.setText("");
        jPalpacaoTireoide.setText("");
        jExameAbdomem.setText("");
        jAlturaUterina.setText("0");
        jPosicaoFetal.setText("");
        //
        jPesoGestante.setEnabled(true);
        jAlturaGestante.setEnabled(true);
        jCheckBoxFace.setEnabled(true);
        jCheckBoxTronco.setEnabled(true);
        jCheckBoxMembroInferior.setEnabled(true);
        jCheckBoxMembroSuperior.setEnabled(true);
        jInspecaoPeleMucosa.setEnabled(true);
        jPalpacaoTireoide.setEnabled(true);
        jExameAbdomem.setEnabled(true);
        jAlturaUterina.setEnabled(true);
        jPosicaoFetal.setEnabled(true);
        // AEFP4
        jBtNovoAFP4.setEnabled(!true);
        jBtAlterarAFP4.setEnabled(!true);
        jBtExcluirAFP4.setEnabled(!true);
        jBtSalvarAFP4.setEnabled(true);
        jBtCancelarAFP4.setEnabled(true);
        jBtAuditoriaAFP4.setEnabled(!true);
        // AEFP3
        jBtNovoAFP3.setEnabled(!true);
        jBtAlterarAFP3.setEnabled(!true);
        jBtExcluirAFP3.setEnabled(!true);
        jBtSalvarAFP3.setEnabled(!true);
        jBtCancelarAFP3.setEnabled(!true);
        jBtAuditoriaAFP3.setEnabled(true);
        // AEFP2
        jBtNovoAFP2.setEnabled(!true);
        jBtAlterarAFP2.setEnabled(!true);
        jBtExcluirAFP2.setEnabled(!true);
        jBtSalvarAFP2.setEnabled(!true);
        jBtCancelarAFP2.setEnabled(!true);
        jBtAuditoriaAFP2.setEnabled(!true);
        // AEF-P1
        jBtNovoAFP1.setEnabled(!true);
        jBtAlterarAFP1.setEnabled(!true);
        jBtExcluirAFP1.setEnabled(!true);
        jBtSalvarAFP1.setEnabled(!true);
        jBtCancelarAFP1.setEnabled(!true);
        jBtAuditoriaAFP1.setEnabled(!true);
        // ADMISSÃO
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        jBtImpressaoFicha.setEnabled(!true);
        // EVOLUÇÃO
        jBtNovaEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
    }

    public void AlterarAFP4() {
        jPesoGestante.setEnabled(true);
        jAlturaGestante.setEnabled(true);
        jCheckBoxFace.setEnabled(true);
        jCheckBoxTronco.setEnabled(true);
        jCheckBoxMembroInferior.setEnabled(true);
        jCheckBoxMembroSuperior.setEnabled(true);
        jInspecaoPeleMucosa.setEnabled(true);
        jPalpacaoTireoide.setEnabled(true);
        jExameAbdomem.setEnabled(true);
        jAlturaUterina.setEnabled(true);
        jPosicaoFetal.setEnabled(true);
        // AEFP4
        jBtNovoAFP4.setEnabled(!true);
        jBtAlterarAFP4.setEnabled(!true);
        jBtExcluirAFP4.setEnabled(!true);
        jBtSalvarAFP4.setEnabled(true);
        jBtCancelarAFP4.setEnabled(true);
        jBtAuditoriaAFP4.setEnabled(!true);
        // AEFP3
        jBtNovoAFP3.setEnabled(!true);
        jBtAlterarAFP3.setEnabled(!true);
        jBtExcluirAFP3.setEnabled(!true);
        jBtSalvarAFP3.setEnabled(!true);
        jBtCancelarAFP3.setEnabled(!true);
        jBtAuditoriaAFP3.setEnabled(true);
        // AEFP2
        jBtNovoAFP2.setEnabled(!true);
        jBtAlterarAFP2.setEnabled(!true);
        jBtExcluirAFP2.setEnabled(!true);
        jBtSalvarAFP2.setEnabled(!true);
        jBtCancelarAFP2.setEnabled(!true);
        jBtAuditoriaAFP2.setEnabled(!true);
        // AEF-P1
        jBtNovoAFP1.setEnabled(!true);
        jBtAlterarAFP1.setEnabled(!true);
        jBtExcluirAFP1.setEnabled(!true);
        jBtSalvarAFP1.setEnabled(!true);
        jBtCancelarAFP1.setEnabled(!true);
        jBtAuditoriaAFP1.setEnabled(!true);
        // ADMISSÃO
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        jBtImpressaoFicha.setEnabled(!true);
        // EVOLUÇÃO
        jBtNovaEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
    }

    public void ExcluirAFP4() {
        jPesoGestante.setText("");
        jAlturaGestante.setText("");
        jCheckBoxFace.setSelected(!true);
        jCheckBoxTronco.setSelected(!true);
        jCheckBoxMembroInferior.setSelected(!true);
        jCheckBoxMembroSuperior.setSelected(!true);
        jInspecaoPeleMucosa.setText("");
        jPalpacaoTireoide.setText("");
        jExameAbdomem.setText("");
        jAlturaUterina.setText("");
        jPosicaoFetal.setText("");
        //
        jPesoGestante.setEnabled(!true);
        jAlturaGestante.setEnabled(!true);
        jCheckBoxFace.setEnabled(!true);
        jCheckBoxTronco.setEnabled(!true);
        jCheckBoxMembroInferior.setEnabled(!true);
        jCheckBoxMembroSuperior.setEnabled(!true);
        jInspecaoPeleMucosa.setEnabled(!true);
        jPalpacaoTireoide.setEnabled(!true);
        jExameAbdomem.setEnabled(!true);
        jAlturaUterina.setEnabled(!true);
        jPosicaoFetal.setEnabled(!true);
        // AEFP4
        jBtNovoAFP4.setEnabled(true);
        jBtAlterarAFP4.setEnabled(!true);
        jBtExcluirAFP4.setEnabled(!true);
        jBtSalvarAFP4.setEnabled(!true);
        jBtCancelarAFP4.setEnabled(!true);
        jBtAuditoriaAFP4.setEnabled(!true);
        // AEFP3
        jBtNovoAFP3.setEnabled(true);
        jBtAlterarAFP3.setEnabled(!true);
        jBtExcluirAFP3.setEnabled(!true);
        jBtSalvarAFP3.setEnabled(!true);
        jBtCancelarAFP3.setEnabled(!true);
        jBtAuditoriaAFP3.setEnabled(true);
        // AEFP2
        jBtNovoAFP2.setEnabled(true);
        jBtAlterarAFP2.setEnabled(!true);
        jBtExcluirAFP2.setEnabled(!true);
        jBtSalvarAFP2.setEnabled(!true);
        jBtCancelarAFP2.setEnabled(!true);
        jBtAuditoriaAFP2.setEnabled(!true);
        // AEF-P1
        jBtNovoAFP1.setEnabled(true);
        jBtAlterarAFP1.setEnabled(!true);
        jBtExcluirAFP1.setEnabled(!true);
        jBtSalvarAFP1.setEnabled(!true);
        jBtCancelarAFP1.setEnabled(!true);
        jBtAuditoriaAFP1.setEnabled(!true);
        // ADMISSÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        jBtImpressaoFicha.setEnabled(true);
        // EVOLUÇÃO
        jBtNovaEvolucao.setEnabled(true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
    }

    public void SalvarAFP4() {
        jPesoGestante.setEnabled(!true);
        jAlturaGestante.setEnabled(!true);
        jCheckBoxFace.setEnabled(!true);
        jCheckBoxTronco.setEnabled(!true);
        jCheckBoxMembroInferior.setEnabled(!true);
        jCheckBoxMembroSuperior.setEnabled(!true);
        jInspecaoPeleMucosa.setEnabled(!true);
        jPalpacaoTireoide.setEnabled(!true);
        jExameAbdomem.setEnabled(!true);
        jAlturaUterina.setEnabled(!true);
        jPosicaoFetal.setEnabled(!true);
        // AEFP4
        jBtNovoAFP4.setEnabled(true);
        jBtAlterarAFP4.setEnabled(true);
        jBtExcluirAFP4.setEnabled(true);
        jBtSalvarAFP4.setEnabled(!true);
        jBtCancelarAFP4.setEnabled(!true);
        jBtAuditoriaAFP4.setEnabled(true);
        // AEFP3
        jBtNovoAFP3.setEnabled(true);
        jBtAlterarAFP3.setEnabled(!true);
        jBtExcluirAFP3.setEnabled(!true);
        jBtSalvarAFP3.setEnabled(!true);
        jBtCancelarAFP3.setEnabled(!true);
        jBtAuditoriaAFP3.setEnabled(true);
        // AEFP2
        jBtNovoAFP2.setEnabled(true);
        jBtAlterarAFP2.setEnabled(!true);
        jBtExcluirAFP2.setEnabled(!true);
        jBtSalvarAFP2.setEnabled(!true);
        jBtCancelarAFP2.setEnabled(!true);
        jBtAuditoriaAFP2.setEnabled(!true);
        // AEF-P1
        jBtNovoAFP1.setEnabled(true);
        jBtAlterarAFP1.setEnabled(!true);
        jBtExcluirAFP1.setEnabled(!true);
        jBtSalvarAFP1.setEnabled(!true);
        jBtCancelarAFP1.setEnabled(!true);
        jBtAuditoriaAFP1.setEnabled(!true);
        // ADMISSÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        jBtImpressaoFicha.setEnabled(true);
        // EVOLUÇÃO
        jBtNovaEvolucao.setEnabled(true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
    }

    public void CancelarAFP4() {
        jPesoGestante.setEnabled(!true);
        jAlturaGestante.setEnabled(!true);
        jCheckBoxFace.setEnabled(!true);
        jCheckBoxTronco.setEnabled(!true);
        jCheckBoxMembroInferior.setEnabled(!true);
        jCheckBoxMembroSuperior.setEnabled(!true);
        jInspecaoPeleMucosa.setEnabled(!true);
        jPalpacaoTireoide.setEnabled(!true);
        jExameAbdomem.setEnabled(!true);
        jAlturaUterina.setEnabled(!true);
        jPosicaoFetal.setEnabled(!true);
        // AEF-P4
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ADME_AFP4 "
                    + "INNER JOIN ADMISSAOENFERMEIRA "
                    + "ON ADME_AFP4.IdLanc=ADMISSAOENFERMEIRA.IdLanc "
                    + "WHERE ADME_AFP4.IdLanc='" + jIdLanc.getText() + "'");
            conecta.rs.first();
            codigoAFP4 = conecta.rs.getInt("IdAfp4");
            //
            pesoGestante = conecta.rs.getFloat("PesoGestante");
            DecimalFormat p1 = new DecimalFormat("#0.00");
            String pg = p1.format(pesoGestante);
            jPesoGestante.setText(pg);
            //               
            alturaGestante = conecta.rs.getFloat("AlturaGestante");
            DecimalFormat a1 = new DecimalFormat("#0.00");
            String ag = p1.format(alturaGestante);
            jAlturaGestante.setText(ag);
            //                
            jInspecaoPeleMucosa.setText(conecta.rs.getString("InspecaoPeleMucosa"));
            jPalpacaoTireoide.setText(conecta.rs.getString("PalpacaoTireoide"));;
            jExameAbdomem.setText(conecta.rs.getString("ExameAbdomem"));
            //
            alturaUterina = conecta.rs.getFloat("AlturaUterina");
            DecimalFormat altUter = new DecimalFormat("#0.00");
            String altura = altUter.format(alturaUterina);
            jAlturaUterina.setText(altura);
            //            
            jPosicaoFetal.setText(conecta.rs.getString("PosicaoFetal"));
            pesquisaEdemaFace = conecta.rs.getInt("Face");
            if (pesquisaEdemaFace == 0) {
                jCheckBoxFace.setSelected(true);
            } else if (pesquisaEdemaFace == 1) {
                jCheckBoxFace.setSelected(!true);
            }
            pesquisaEdemaTronco = conecta.rs.getInt("Tronco");
            if (pesquisaEdemaTronco == 0) {
                jCheckBoxTronco.setSelected(true);
            } else if (pesquisaEdemaTronco == 1) {
                jCheckBoxTronco.setSelected(!true);
            }
            pesquisaEdemaMMII = conecta.rs.getInt("MembroInferior");
            if (pesquisaEdemaMMII == 0) {
                jCheckBoxMembroInferior.setSelected(true);
            } else if (pesquisaEdemaMMII == 1) {
                jCheckBoxMembroInferior.setSelected(!true);
            }
            pesquisaEdemaMMSS = conecta.rs.getInt("MembroSuperior");
            if (pesquisaEdemaMMSS == 0) {
                jCheckBoxMembroSuperior.setSelected(true);
            } else if (pesquisaEdemaMMSS == 1) {
                jCheckBoxMembroSuperior.setSelected(!true);
            }
        } catch (Exception e) {
        }
        if (codigoAFP4 != 0) {
            jBtNovoAFP4.setEnabled(true);
            jBtAlterarAFP4.setEnabled(true);
            jBtExcluirAFP4.setEnabled(true);
            jBtSalvarAFP4.setEnabled(!true);
            jBtCancelarAFP4.setEnabled(true);
            jBtAuditoriaAFP4.setEnabled(true);
            //
            jBtNovoAFP1.setEnabled(true);
            jBtNovoAFP2.setEnabled(true);
            jBtNovoAFP3.setEnabled(true);
            jBtNovaEvolucao.setEnabled(true);
            // ADMISSÃO
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtImpressaoFicha.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
        } else {
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtImpressaoFicha.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            //
            jBtNovoAFP1.setEnabled(true);
            jBtNovoAFP2.setEnabled(true);
            jBtNovoAFP3.setEnabled(true);
            jBtNovoAFP4.setEnabled(true);
            jBtNovaEvolucao.setEnabled(true);
        }
    }

    public void buscarCodigoAFP4() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ADME_AFP4");
            conecta.rs.last();
            codigoAFP4 = conecta.rs.getInt("IdAfp4");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarAEFP4() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ADME_AFP4 "
                    + "WHERE IdLanc='" + jIdLanc.getText() + "' "
                    + "AND IdInternoCrc='" + jIdInternoMedico.getText() + "'");
            conecta.rs.first();
            codigoAdm4 = conecta.rs.getString("IdLanc");
            codigoInternoAdm4 = conecta.rs.getString("IdInternoCrc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void Finalizar() {
        String statusLanc = "FINALIZADO";
        JOptionPane.showMessageDialog(rootPane, "Se esse Lançamento for finaliza,\nvocê não poderá mais excluir ou alterar.");
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente finalizar assim mesmo o lançamento selecionado?", "Confirmação",
                JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            objAdmEnfermagem.setStatusLanc(statusLanc);
            objAdmEnfermagem.setIdLanc(Integer.parseInt(jIdLanc.getText()));
            control.finalizarAdmissaoEnfermagem(objAdmEnfermagem);
            controle.finalizarMovTec(objAdmEnfermagem);
            jStatusLanc.setText("FINALIZADO");
            bloquearCampos();
            JOptionPane.showMessageDialog(rootPane, "Registro FINALIZADO com sucesso !!!");
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
        }
    }

    public void buscarID() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ADMISSAOENFERMEIRA");
            conecta.rs.last();
            jIdLanc.setText(String.valueOf(conecta.rs.getInt("IdLanc")));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter o ID do atendimento.\nERRO: " + ex);
        }
    }

    public void buscarEvolucao() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM EVOLUCAOENFERMAGEM");
            conecta.rs.last();
            jIdEvolucao.setText(conecta.rs.getString("IdItem"));
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarEvolucao() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM EVOLUCAOENFERMAGEM WHERE IdLanc='" + jIdLanc.getText() + "'");
            conecta.rs.first();
            codEvolucao = conecta.rs.getString("IdLanc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void NovaEvolucao() {
        jIdEvolucao.setText("");
        jNomeInternoEvolEnf.setText(jNomeInternoMedico.getText());
        jDataEvolu.setCalendar(Calendar.getInstance());
        jTextoEvolucao.setText("");
        //
        jDataEvolu.setEnabled(true);
        jTextoEvolucao.setEnabled(true);
        //
        jBtNovaEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(true);
        jBtCancelarEvolucao.setEnabled(true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        jBtImpressaoFicha.setEnabled(!true);
    }

    public void AlterarEvolucao() {
        //
        jDataEvolu.setEnabled(true);
        jTextoEvolucao.setEnabled(true);
        //
        jBtNovaEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(true);
        jBtCancelarEvolucao.setEnabled(true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        jBtImpressaoFicha.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
    }

    public void ExcluirEvolucao() {
        jIdEvolucao.setText("");
        jNomeInternoEvolEnf.setText("");
        jDataEvolu.setDate(null);
        jTextoEvolucao.setText("");
        //
        jDataEvolu.setEnabled(!true);
        jTextoEvolucao.setEnabled(!true);
        //
        jBtNovaEvolucao.setEnabled(true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        jBtImpressaoFicha.setEnabled(true);
    }

    public void SalvarEvolucao() {
        //
        jDataEvolu.setEnabled(!true);
        jTextoEvolucao.setEnabled(!true);
        //
        jBtNovaEvolucao.setEnabled(true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        jBtImpressaoFicha.setEnabled(true);
    }

    public void CancelarEvolucao() {
        if (jIdEvolucao.getText().equals("")) {
            jIdEvolucao.setText("");
            jNomeInternoEvolEnf.setText("");
            jDataEvolu.setDate(null);
            jTextoEvolucao.setText("");
            //
            jDataEvolu.setEnabled(!true);
            jTextoEvolucao.setEnabled(!true);
            //
            jBtNovaEvolucao.setEnabled(true);
            jBtAlterarEvolucao.setEnabled(!true);
            jBtExcluirEvolucao.setEnabled(!true);
            jBtSalvarEvolucao.setEnabled(!true);
            jBtCancelarEvolucao.setEnabled(!true);
            jBtAuditoriaEvolucao.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            jBtImpressaoFicha.setEnabled(true);
        } else if (!jIdEvolucao.getText().equals("")) {
            jDataEvolu.setEnabled(!true);
            jTextoEvolucao.setEnabled(!true);
            //
            jBtNovaEvolucao.setEnabled(true);
            jBtAlterarEvolucao.setEnabled(!true);
            jBtExcluirEvolucao.setEnabled(!true);
            jBtSalvarEvolucao.setEnabled(!true);
            jBtCancelarEvolucao.setEnabled(!true);
            jBtAuditoriaEvolucao.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            jBtImpressaoFicha.setEnabled(true);
        }
    }

    public void preencherAdmissaoEnfermeira(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Nome Completo do Interno", "Histórico Criminal"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1;
                // Formatar a data Entrada
                dataEntrada = conecta.rs.getString("DataLanc");
                String diae = dataEntrada.substring(8, 10);
                String mese = dataEntrada.substring(5, 7);
                String anoe = dataEntrada.substring(0, 4);
                dataEntrada = diae + "/" + mese + "/" + anoe;
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdLanc"), dataEntrada, conecta.rs.getString("StatusLanc"), conecta.rs.getString("NomeInternoCrc"), conecta.rs.getString("Observacao")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaAdmissaoEnfermeira.setModel(modelo);
        jTabelaAdmissaoEnfermeira.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaAdmissaoEnfermeira.getColumnModel().getColumn(0).setResizable(false);
        jTabelaAdmissaoEnfermeira.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaAdmissaoEnfermeira.getColumnModel().getColumn(1).setResizable(false);
        jTabelaAdmissaoEnfermeira.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaAdmissaoEnfermeira.getColumnModel().getColumn(2).setResizable(false);
        jTabelaAdmissaoEnfermeira.getColumnModel().getColumn(3).setPreferredWidth(335);
        jTabelaAdmissaoEnfermeira.getColumnModel().getColumn(3).setResizable(false);
        jTabelaAdmissaoEnfermeira.getColumnModel().getColumn(4).setPreferredWidth(335);
        jTabelaAdmissaoEnfermeira.getColumnModel().getColumn(4).setResizable(false);
        jTabelaAdmissaoEnfermeira.getTableHeader().setReorderingAllowed(false);
        jTabelaAdmissaoEnfermeira.setAutoResizeMode(jTabelaAdmissaoEnfermeira.AUTO_RESIZE_OFF);
        jTabelaAdmissaoEnfermeira.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaEnfermagem();
        conecta.desconecta();
    }

    public void alinharCamposTabelaEnfermagem() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaAdmissaoEnfermeira.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaAdmissaoEnfermeira.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaAdmissaoEnfermeira.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }

    public void limparTabelaAdmissao() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Nome Completo do Interno", "Histórico Criminal"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaAdmissaoEnfermeira.setModel(modelo);
        jTabelaAdmissaoEnfermeira.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaAdmissaoEnfermeira.getColumnModel().getColumn(0).setResizable(false);
        jTabelaAdmissaoEnfermeira.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaAdmissaoEnfermeira.getColumnModel().getColumn(1).setResizable(false);
        jTabelaAdmissaoEnfermeira.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaAdmissaoEnfermeira.getColumnModel().getColumn(2).setResizable(false);
        jTabelaAdmissaoEnfermeira.getColumnModel().getColumn(3).setPreferredWidth(335);
        jTabelaAdmissaoEnfermeira.getColumnModel().getColumn(3).setResizable(false);
        jTabelaAdmissaoEnfermeira.getColumnModel().getColumn(4).setPreferredWidth(335);
        jTabelaAdmissaoEnfermeira.getColumnModel().getColumn(4).setResizable(false);
        jTabelaAdmissaoEnfermeira.getTableHeader().setReorderingAllowed(false);
        jTabelaAdmissaoEnfermeira.setAutoResizeMode(jTabelaAdmissaoEnfermeira.AUTO_RESIZE_OFF);
        jTabelaAdmissaoEnfermeira.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void preencherTabelaEvolucaoEnfermagem(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Seq.", "Data", "Evolução"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dataEvolu = conecta.rs.getString("DataEvol");
                String diav = dataEvolu.substring(8, 10);
                String mesv = dataEvolu.substring(5, 7);
                String anov = dataEvolu.substring(0, 4);
                dataEvolu = diav + "/" + mesv + "/" + anov;
                dados.add(new Object[]{conecta.rs.getInt("IdItem"), dataEvolu, conecta.rs.getString("TextoEvolucao")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaEvolucaoEnfermagem.setModel(modelo);
        jTabelaEvolucaoEnfermagem.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaEvolucaoEnfermagem.getColumnModel().getColumn(0).setResizable(false);
        jTabelaEvolucaoEnfermagem.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaEvolucaoEnfermagem.getColumnModel().getColumn(1).setResizable(false);
        jTabelaEvolucaoEnfermagem.getColumnModel().getColumn(2).setPreferredWidth(440);
        jTabelaEvolucaoEnfermagem.getColumnModel().getColumn(2).setResizable(false);
        jTabelaEvolucaoEnfermagem.getTableHeader().setReorderingAllowed(false);
        jTabelaEvolucaoEnfermagem.setAutoResizeMode(jTabelaEvolucaoEnfermagem.AUTO_RESIZE_OFF);
        jTabelaEvolucaoEnfermagem.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaEvolucao();
        conecta.desconecta();
    }

    public void limparTabelaEvolucao() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Evolução"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaEvolucaoEnfermagem.setModel(modelo);
        jTabelaEvolucaoEnfermagem.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaEvolucaoEnfermagem.getColumnModel().getColumn(0).setResizable(false);
        jTabelaEvolucaoEnfermagem.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaEvolucaoEnfermagem.getColumnModel().getColumn(1).setResizable(false);
        jTabelaEvolucaoEnfermagem.getColumnModel().getColumn(2).setPreferredWidth(440);
        jTabelaEvolucaoEnfermagem.getColumnModel().getColumn(2).setResizable(false);
        jTabelaEvolucaoEnfermagem.getTableHeader().setReorderingAllowed(false);
        jTabelaEvolucaoEnfermagem.setAutoResizeMode(jTabelaEvolucaoEnfermagem.AUTO_RESIZE_OFF);
        jTabelaEvolucaoEnfermagem.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabelaEvolucao() {
        //
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaEvolucaoEnfermagem.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaEvolucaoEnfermagem.getColumnModel().getColumn(1).setCellRenderer(centralizado);
    }

    public void compararRadioButtons() {
        // Estado Emocional
        if (jRBTranquilo.isSelected()) {
            statusEstadoEmocional = 0;
        } else if (jRBAnsioso.isSelected()) {
            statusEstadoEmocional = 1;
        } else if (jRBAgeressivo.isSelected()) {
            statusEstadoEmocional = 2;
        } else if (jRBTrite.isSelected()) {
            statusEstadoEmocional = 3;
        } else if (jRBAgitado.isSelected()) {
            statusEstadoEmocional = 4;
        }
        // Sono Repouso
        if (jRBPreservado.isSelected()) {
            statusSonoRepouso = 0;
        } else if (jRBDiminuido.isSelected()) {
            statusSonoRepouso = 1;
        }
        // Nível de consciência
        if (jRBOrientado.isSelected()) {
            statusNivelConsciencia = 0;
        } else if (jRBDesorientado.isSelected()) {
            statusNivelConsciencia = 1;
        }
        // Locomoção
        if (jRBDeambulando.isSelected()) {
            statusLocomocao = 0;
        } else if (jRBDifiDeambulando.isSelected()) {
            statusLocomocao = 1;
        } else if (jRBDeficiente.isSelected()) {
            statusLocomocao = 2;
        }
        // Acuidade Visual
        if (jRBAcuiVisualPreservado.isSelected()) {
            statusAcuidadeVisual = 0;
        } else if (jRBAcuiVisulaDiminuido.isSelected()) {
            statusAcuidadeVisual = 1;
        }
        // Acuidade Auditiva
        if (jRBAcuAudiPreservado.isSelected()) {
            statusAcuidadeAuditiva = 0;
        } else if (jRBAcuidAudDiminuido.isSelected()) {
            statusAcuidadeAuditiva = 1;
        }
        // Função motora
        if (jRBFuncaoComAlteracao.isSelected()) {
            statusFuncaoMotora = 0;
        } else if (jRBFuncaoSemAlteracao.isSelected()) {
            statusFuncaoMotora = 1;
        }
        // Fala/Linguagem
        if (jRBComAlteracaoFala.isSelected()) {
            statusFalaLinguagem = 0;
        } else if (jRBSemAlteracaoFala.isSelected()) {
            statusFalaLinguagem = 1;
        }
        // Mucosa
        if (jRBPeleNormocoradas.isSelected()) {
            statusMucosa = 0;
        } else if (jRBPeleHipocoradas.isSelected()) {
            statusMucosa = 1;
        } else if (jRBPeleHidratadas.isSelected()) {
            statusMucosa = 2;
        }
        // Pele
        if (jRBPeleHipohidratada.isSelected()) {
            statusPele = 0;
        } else if (jRBPeleIntegra.isSelected()) {
            statusPele = 1;
        } else if (jRBPeleLesao.isSelected()) {
            statusPele = 2;
        }
        // Cabelos
        if (jRBCabelosIntegro.isSelected()) {
            statusCabelos = 0;
        } else if (jRBCabelosCalvice.isSelected()) {
            statusCabelos = 1;
        } else if (jRBCabelosSujidade.isSelected()) {
            statusCabelos = 2;
        }
        // Boca
        if (jRBBocaHalitose.isSelected()) {
            statusBoca = 0;
        } else if (jRBBocaHalitoseCetonica.isSelected()) {
            statusBoca = 1;
        } else if (jRBProteseDentaria.isSelected()) {
            statusBoca = 2;
        } else if (jRBBocaAusenDenteCarie.isSelected()) {
            statusBoca = 3;
        }
        // Função Respiratória
        if (jRBFuncaoRespEupneico.isSelected()) {
            statusFuncaoRespiratoria = 0;
        } else if (jRBFuncaoRespTaquipenico.isSelected()) {
            statusFuncaoRespiratoria = 1;
        } else if (jRBFuncaoRespDispneico.isSelected()) {
            statusFuncaoRespiratoria = 2;
        }
        // Torax
        if (jRBToraxSimetrico.isSelected()) {
            statusTorax = 0;
        } else if (jRBToraxAssimetrico.isSelected()) {
            statusTorax = 1;
        }
        // Função Intestinal
        if (jRBFuncaoIntesRegular.isSelected()) {
            statusFuncaoIntestinal = 0;
        } else if (jRBFuncaoIntesAusente.isSelected()) {
            statusFuncaoIntestinal = 1;
        } else if (jRBFuncaoIntesDiarreia.isSelected()) {
            statusFuncaoIntestinal = 2;
        } else if (jRBFuncaoIntesConstipacao.isSelected()) {
            statusFuncaoIntestinal = 3;
        }
        // Abdome
        if (jRBAbdomeGloboso.isSelected()) {
            statusAbdome = 0;
        } else if (jRBAbdomeFlacido.isSelected()) {
            statusAbdome = 1;
        } else if (jRBAbdomePlano.isSelected()) {
            statusAbdome = 2;
        }
        // Função Vesiccal
        if (jRBFuncaoVesicalFralda.isSelected()) {
            statusFuncaoVesical = 0;
        } else if (jRBFuncaoVesicalCV.isSelected()) {
            statusFuncaoVesical = 1;
        } else if (jRBFuncaVeisicalEspontanea.isSelected()) {
            statusFuncaoVesical = 2;
        }
        // Genitália
        if (jRBGenitaliaIntegra.isSelected()) {
            statusGenitalia = 0;
        } else if (jRBGenitaliaComAlteracao.isSelected()) {
            statusGenitalia = 1;
        }
    }

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jIdLanc.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog2() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela2);
        objLogSys.setIdLancMov(Integer.valueOf(jIdLanc.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog3() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela3);
        objLogSys.setIdLancMov(Integer.valueOf(jIdLanc.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog4() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela4);
        objLogSys.setIdLancMov(Integer.valueOf(jIdLanc.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog5() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela5);
        objLogSys.setIdLancMov(Integer.valueOf(jIdLanc.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog6() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela6);
        objLogSys.setIdLancMov(Integer.valueOf(jIdLanc.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void buscarAcessoUsuario(String nomeTelaAcesso) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nameUser + "'");
            conecta.rs.first();
            codigoUserENF = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUserENF + "'");
            conecta.rs.first();
            codigoUserGroupENF = conecta.rs.getInt("IdUsuario");
            codigoGrupoENF = conecta.rs.getInt("IdGrupo");
            nomeGrupoENF = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUserENF + "' "
                    + "AND NomeTela='" + nomeTelaAcesso + "'");
            conecta.rs.first();
            codUserAcessoENF = conecta.rs.getInt("IdUsuario");
            codAbrirENF = conecta.rs.getInt("Abrir");
            codIncluirENF = conecta.rs.getInt("Incluir");
            codAlterarENF = conecta.rs.getInt("Alterar");
            codExcluirENF = conecta.rs.getInt("Excluir");
            codGravarENF = conecta.rs.getInt("Gravar");
            codConsultarENF = conecta.rs.getInt("Consultar");
            nomeTelaENF = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarInternoRegistradoAdm() {
        conecta.abrirConexao();
        SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
        dataReg = formatoAmerica.format(jDataLanc.getDate().getTime());
        try {
            conecta.executaSQL("SELECT * FROM REGISTRO_ATENDIMENTO_INTERNO_PSP "
                    + "WHERE IdInternoCrc='" + jIdInternoMedico.getText() + "' "
                    + "AND Atendido='" + opcao + "'");
            conecta.rs.first();
            codigoInternoAtend = conecta.rs.getString("IdInternoCrc");
            codigoDepartamentoENF = conecta.rs.getInt("IdDepartamento");
            atendido = conecta.rs.getString("Atendido");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarRegistroBiometria() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PARAMETROSCRC");
            conecta.rs.first();
            phabilitaEnferemeiro = conecta.rs.getString("BiometriaEnfermeiros");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    // VERIFICAR SE A EVOLUÇÃO FAZ PARTE DA ADMISSÃO, OU SEJA, QUANDO É FEITA A ADMISSÃO DO INTERNO
    // É GRAVADO AUTOMÁTICAMETE UMA EVOLUÇÃO PARA O INTERNO.
    public void verificarEvolucaoAdmissao() {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM EVOLUCAOENFERMAGEM "
                    + "WHERE IdLanc='" + jIdLanc.getText() + "' "
                    + "AND IdItem='" + jIdEvolucao.getText() + "'");
            conecta.rs.first();
            admEvolucao = conecta.rs.getString("AdmEvo");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
