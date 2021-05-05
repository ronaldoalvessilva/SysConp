/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleConfirmacaoAtendimento;
import gestor.Controle.ControleEvolucaoTerapia;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControleMovTerapiaOcupacional;
import gestor.Controle.ControleRegistroAtendimentoInternoBio;
import gestor.Dao.ConexaoBancoDados;
import gestor.Controle.ControleAtendimentoTerapiaDAO;
import gestor.Controle.ControleAvaliacaoIDAO;
import gestor.Controle.ControleAvaliacaoIIDAO;
import gestor.Controle.ControleHistoricoEducacionalDAO;
import gestor.Controle.ControleHistoricoLaborativoDAO;
import gestor.Controle.ControleIncluirExperienciaProfissionaDAO;
import gestor.Controle.ControleInclusaoCursosTO_DAO;
import Utilitarios.LimiteDigitosAlfa;
import Utilitarios.LimiteDigitosNum;
import Utilitarios.ModeloTabela;
import gestor.Controle.ControlePortaEntrada;
import gestor.Modelo.AtendimentoTerapeuta;
import gestor.Modelo.AvaliacaoI;
import gestor.Modelo.AvaliacaoII;
import gestor.Modelo.EvolucaoTerapia;
import gestor.Modelo.HistoricoEducacionalLaboral;
import gestor.Modelo.LogSistema;
import gestor.Modelo.PortaEntrada;
import gestor.Modelo.RegistroAtendimentoInternos;
import static gestor.Visao.TelaAtendimentoTerapiaOcupacional.jIdAtend;
import static gestor.Visao.TelaAtendimentoTerapiaOcupacional.jIdInterno;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloTerapiaOcupacional.pQUANTIDADE_ATENDIDA;
import static gestor.Visao.TelaAtendimentoTerapiaOcupacional.codigoDepartamentoTO_SEC;
import static gestor.Visao.TelaAtendimentoTerapiaOcupacional.jIdEvolucao;
import static gestor.Visao.TelaAtendimentoTerapiaOcupacional.jTabelaEvolucao;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import static gestor.Visao.TelaModuloTerapiaOcupacional.codAbrirTO;
import static gestor.Visao.TelaModuloTerapiaOcupacional.codAlterarTO;
import static gestor.Visao.TelaModuloTerapiaOcupacional.codConsultarTO;
import static gestor.Visao.TelaModuloTerapiaOcupacional.codExcluirTO;
import static gestor.Visao.TelaModuloTerapiaOcupacional.codGravarTO;
import static gestor.Visao.TelaModuloTerapiaOcupacional.codIncluirTO;
import static gestor.Visao.TelaModuloTerapiaOcupacional.codUserAcessoTO;
import static gestor.Visao.TelaModuloTerapiaOcupacional.codigoGrupoTO;
import static gestor.Visao.TelaModuloTerapiaOcupacional.codigoUserGroupTO;
import static gestor.Visao.TelaModuloTerapiaOcupacional.codigoUserTO;
import static gestor.Visao.TelaModuloTerapiaOcupacional.nomeGrupoTO;
import static gestor.Visao.TelaModuloTerapiaOcupacional.nomeModuloTO;
import static gestor.Visao.TelaModuloTerapiaOcupacional.nomeTelaTO;
import static gestor.Visao.TelaModuloTerapiaOcupacional.telaAtendimentoInternoAvaIITO;
import static gestor.Visao.TelaModuloTerapiaOcupacional.telaAtendimentoInternoAvaITO;
import static gestor.Visao.TelaModuloTerapiaOcupacional.telaAtendimentoInternoHistEduTO;
import static gestor.Visao.TelaModuloTerapiaOcupacional.telaAtendimentoInternoHistLabTO;
import static gestor.Visao.TelaModuloTerapiaOcupacional.telaAtendimentoInternoManuTO;
import java.awt.Color;
import java.awt.Image;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Socializa TI 02
 */
public class TelaPortaEntradaTO extends javax.swing.JDialog {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AtendimentoTerapeuta objAtend = new AtendimentoTerapeuta();
    ControleAtendimentoTerapiaDAO control = new ControleAtendimentoTerapiaDAO();
    EvolucaoTerapia objEvolu = new EvolucaoTerapia();
    ControleMovTerapiaOcupacional controle = new ControleMovTerapiaOcupacional();
    ControleEvolucaoTerapia controleEvolucao = new ControleEvolucaoTerapia();
    //
    AvaliacaoI objAvaliaI = new AvaliacaoI();
    ControleAvaliacaoIDAO controleAvaliacaoI = new ControleAvaliacaoIDAO();
    //
    AvaliacaoII objAvaliaII = new AvaliacaoII();
    ControleAvaliacaoIIDAO controleAvaliacaoII = new ControleAvaliacaoIIDAO();
    //
    HistoricoEducacionalLaboral objHistEducLabor = new HistoricoEducacionalLaboral();
    ControleHistoricoEducacionalDAO controleHistEduca = new ControleHistoricoEducacionalDAO();
    ControleInclusaoCursosTO_DAO controleCursosTO = new ControleInclusaoCursosTO_DAO();
    //
    ControleHistoricoLaborativoDAO controleHistLab = new ControleHistoricoLaborativoDAO();
    ControleIncluirExperienciaProfissionaDAO controleExpTO = new ControleIncluirExperienciaProfissionaDAO();
    // INFORMAR QUE O INTERNO FOI ATENDIDO NA ADMISSÃO E NA EVOLUÇÃO
    RegistroAtendimentoInternos objRegAtend = new RegistroAtendimentoInternos();
    ControleRegistroAtendimentoInternoBio controlRegAtend = new ControleRegistroAtendimentoInternoBio();
    // PARA O ATENDIMENTO NA TV
    ControleConfirmacaoAtendimento control_ATENDE = new ControleConfirmacaoAtendimento();
    //PORTA DE ENTRADA
    PortaEntrada objPortaEntrada = new PortaEntrada();
    ControlePortaEntrada control_PE = new ControlePortaEntrada();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela = "Terapia Ocupacional:Atendimento Internos:Manutenção";
    String nomeModuloTela2 = "Terapia Ocupacional:Evolução Atendimento:Internos";
    String nomeModuloTela3 = "Terapia Ocupacional:Atendimento Internos:Avaliação I";
    String nomeModuloTela4 = "Terapia Ocupacional:Atendimento Internos:Avaliação II";
    String nomeModuloTela5 = "Terapia Ocupacional:Atendimento Internos:Histórico Educacional";
    String nomeModuloTela6 = "Terapia Ocupacional:Atendimento Internos:Histórico Laborativo";
    String statusMov;
    String horaMov;
    String dataModFinal;
    String statusAtendimento = "ABERTO";
    String deptoTecnico = "TERAPIA OCUPACIONAL";
    //
    int acao, flag;
    String dataEntrada, dataInicial, dataFinal, dataEvolucao;
    String caminho;
    int count = 0;
    // AVALIAÇÃO I
    public static int codigoAvaliacaoI;
    String codigoAtend;
    String codigoInternoAtend;
    // AVALIÇÃO II
    public static int codigoAvaliacaoII;
    String codigoAtendII;
    String codigoInternoAtendII;
    // HISTORICOS EDUCACIONAL
    int prioridadeCursos, idItem, pesquisarPrioridadeCursos;
    String letraPrioridade;
    String codigoCurso;
    public static int codigoHistoricoEduca;
    int prioridadeCursoTabela;
    String prioridadeLetraCurso;
    String codigoInterno;
    String codigoRegistro;
    // HISTORICO PROFISSIONAL
    String codigoProfissao;
    String codigoExpProfissao;
    int interesseAtividade;
    int remuneracao;
    public static int codigoHistoricoProf;
    String tipoRemuneracao;
    int opcaoRemueracao;
    int idItemProf;
    // HISTÓRICO FAMILIAR
    int SFSeg;
    int SFTer;
    int SFQua;
    int SFQui;
    int SFSex;
    int SFSab;
    int SFDom;
    int IntSeg;
    int IntTer;
    int IntQua;
    int IntQui;
    int IntSex;
    int IntSab;
    int IntDom;
    // VARIVAEIS PARA SABER SE O INTERNO FOI REGISTRADO COM BIOMETRIA      
    String dataReg = "";
    Date dataRegistro = null;
//    String codigoInternoAtend = "";
    String atendido = "Sim";
    String opcao = "Não";
    public static int codigoDepartamentoTO = 0;
    String tipoAtendimentoAdm = "Admissão Terapia";
    String tipoAtendimentoEvol = "Evolução Terapia";
    //
    String pHabilitaTerapia = "";
    //ATENDIMENTO MOSTRADO NA TV
    String pATENDIMENTO_CONCLUIDO = "Sim";
    String status_ATENDIMENTO = "Atendimento Concluido";
    //
    String situacao = "ENTRADA NA UNIDADE";
    String sitRetorno = "RETORNO A UNIDADE";
    int codigoDepartamento = 0;
    //PORTA DE ENTRADA COM ORIGEM NO CRC/TRIAGEM
    String pHABILITA_TERAPIA = "Sim";
    String pDEPARTAMENTO = "";
    String pINTERNOCRC = "";
    String pHABILITADO = "";
    String pCONFIRMA_ADMISSAO = "Sim";
    String pHabilitaTO = "";
    String codInterno; // VARIÁVEL QUE IMPEDI MUDAR O REGISTRO DE ADMISSÃO, CASO JÁ EXISTA ANAMNESES, PRESCRIÇÃO, ATEDTADO OU DIETA.
    String nomeInternoAnterior = "";
    String pATENDIDO_PESQUISA = "Não";
    //RESPONDE COMO NÃO PARA NÃO FAZER OUTRA ADMISSÃO QUANDO O INTERNO CHEGAR PELA PRIMEIRA VEZ
    String pHABILITA_TO = "Não";
    //EVOLUÇÃO DA ADMISSAO
    String admEvolucao = "Sim";

    /**
     * Creates new form TelaPortaEntradaTO
     */
    public static TelaAtendimentoTerapiaOcupacional pADMISSAO_TO;
    public static TelaAuditoriaAdmNovaTO pAUDITORIA_MANUTENCAO;
    public static TelaAuditoriaAdmNova_EDU pAUDITORIA_EDU;
    public static TelaAuditoriaAdmNova_PROF pAUDITORIA_PROF;
    public static TelaAuditoriaAdmNova_SOAPI pAUDITORIA_SOAPI;
    public static TelaAuditoriaAdmNova_SOAPII pAUDITORIA_SOAPII;

    public TelaPortaEntradaTO(TelaAtendimentoTerapiaOcupacional parent, boolean modal) {
        this.pADMISSAO_TO = parent;
        this.setModal(modal);
        setLocationRelativeTo(pADMISSAO_TO);
        initComponents();
        jTabbedPane1.setSelectedIndex(1);
        formataCampos();
        corCampos();
    }

    public void mostraAdutoriaManu() {
        pAUDITORIA_MANUTENCAO = new TelaAuditoriaAdmNovaTO(this, true);
        pAUDITORIA_MANUTENCAO.setVisible(true);
    }

    public void mostrarAuditoriaHistoricoEduca() {
        pAUDITORIA_EDU = new TelaAuditoriaAdmNova_EDU(this, true);
        pAUDITORIA_EDU.setVisible(true);
    }

    public void mostrarAuditoriaHistoricoLab() {
        pAUDITORIA_PROF = new TelaAuditoriaAdmNova_PROF(this, true);
        pAUDITORIA_PROF.setVisible(true);
    }

    public void mostrarAuditoriaHistoricoSOAFI() {
        pAUDITORIA_SOAPI = new TelaAuditoriaAdmNova_SOAPI(this, true);
        pAUDITORIA_SOAPI.setVisible(true);
    }

    public void mostrarAuditoriaHistoricoSOAFII() {
pAUDITORIA_SOAPII = new TelaAuditoriaAdmNova_SOAPII(this, true);
        pAUDITORIA_SOAPII.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupProf = new javax.swing.ButtonGroup();
        buttonGroupLab = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jIDPesqLanc = new javax.swing.JTextField();
        jBtTodos1 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jDataPesqInicial = new com.toedter.calendar.JDateChooser();
        jLabel22 = new javax.swing.JLabel();
        jDataPesqFinal = new com.toedter.calendar.JDateChooser();
        jBtPesqData = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        jnomeInternoPesq = new javax.swing.JTextField();
        jBtPesquisaNome = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTabelaAtendimentoTerapia = new javax.swing.JTable();
        jPanel30 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jIdAtendNovo = new javax.swing.JTextField();
        jStatusLanc = new javax.swing.JTextField();
        jDataLanc = new com.toedter.calendar.JDateChooser();
        jIdInternoAD = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jNomeInternoAD = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jIdADM_Principal = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jBtNovo = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jBtFinalizar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jBtImpressao = new javax.swing.JButton();
        jBtAuditoria = new javax.swing.JButton();
        jBtConcluir = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jObsDesempenhoOcupacional = new javax.swing.JTextArea();
        jLabel96 = new javax.swing.JLabel();
        jComboBoxDominancia = new javax.swing.JComboBox();
        jLabel97 = new javax.swing.JLabel();
        jComboBoxAmputacao = new javax.swing.JComboBox();
        jLabel98 = new javax.swing.JLabel();
        jComboBoxDeficienciaOcupa = new javax.swing.JComboBox();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jComboBoxMotora = new javax.swing.JComboBox();
        jLabel101 = new javax.swing.JLabel();
        jComboBoxCognitiva = new javax.swing.JComboBox();
        jLabel102 = new javax.swing.JLabel();
        jComboBoxSensorial = new javax.swing.JComboBox();
        jComboBoxIntPsi = new javax.swing.JComboBox();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jComboBoxReabilitacao = new javax.swing.JComboBox();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jComboBoxTrabalho = new javax.swing.JComboBox();
        jComboBoxLazer = new javax.swing.JComboBox();
        jComboBoxAIVD = new javax.swing.JComboBox();
        jComboBoxAVD = new javax.swing.JComboBox();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jObsHistoricoFamiliar = new javax.swing.JTextArea();
        jLabel88 = new javax.swing.JLabel();
        jComboBoxPaisVivos = new javax.swing.JComboBox();
        jLabel89 = new javax.swing.JLabel();
        jComboBoxTemCompanheira = new javax.swing.JComboBox();
        jLabel118 = new javax.swing.JLabel();
        jComboBoxTemFilhos = new javax.swing.JComboBox();
        jLabel119 = new javax.swing.JLabel();
        jQuantosFilhos = new javax.swing.JFormattedTextField();
        jLabel120 = new javax.swing.JLabel();
        jCheckBoxSFSeg = new javax.swing.JCheckBox();
        jCheckBoxSFTer = new javax.swing.JCheckBox();
        jCheckBoxSFQua = new javax.swing.JCheckBox();
        jCheckBoxSFQui = new javax.swing.JCheckBox();
        jCheckBoxSFSex = new javax.swing.JCheckBox();
        jCheckBoxSFSab = new javax.swing.JCheckBox();
        jCheckBoxSFDom = new javax.swing.JCheckBox();
        jCheckBoxIntSeg = new javax.swing.JCheckBox();
        jCheckBoxIntTer = new javax.swing.JCheckBox();
        jCheckBoxIntQua = new javax.swing.JCheckBox();
        jCheckBoxIntQui = new javax.swing.JCheckBox();
        jCheckBoxIntSex = new javax.swing.JCheckBox();
        jCheckBoxIntSab = new javax.swing.JCheckBox();
        jCheckBoxIntDom = new javax.swing.JCheckBox();
        jComboBoxVisitaFamiliar = new javax.swing.JComboBox();
        jLabel121 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        jComboBoxVisitaIntima = new javax.swing.JComboBox();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ObsDadosClinicos = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();
        jComboBoxHipertensao = new javax.swing.JComboBox();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jComboBoxDiabetes = new javax.swing.JComboBox();
        jComboBoxCancer = new javax.swing.JComboBox();
        jComboBoxProRespiratorio = new javax.swing.JComboBox();
        jComboBoxTransMental = new javax.swing.JComboBox();
        jComboBoxDoencasDigestivo = new javax.swing.JComboBox();
        jComboBoxInfectocontagiosa = new javax.swing.JComboBox();
        jComboBoxDeficienciaVAF = new javax.swing.JComboBox();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        ObsAlteracoesPsicologicas = new javax.swing.JTextArea();
        jLabel110 = new javax.swing.JLabel();
        jComboBoxHumor = new javax.swing.JComboBox();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jComboBoxInsonia = new javax.swing.JComboBox();
        jComboBoxIrritabilidade = new javax.swing.JComboBox();
        jComboBoxFrustracao = new javax.swing.JComboBox();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jComboBoxDificultadeConcentrar = new javax.swing.JComboBox();
        jComboBoxRaiva = new javax.swing.JComboBox();
        jComboBoxInquietacao = new javax.swing.JComboBox();
        jComboBoxAnsiedade = new javax.swing.JComboBox();
        jPanel11 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jComboBoxTabagismo = new javax.swing.JComboBox();
        jLabel69 = new javax.swing.JLabel();
        jQuantoTabagismo = new javax.swing.JFormattedTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        jObsTriagemSPA = new javax.swing.JTextArea();
        jLabel68 = new javax.swing.JLabel();
        jComboBoxEtilismo = new javax.swing.JComboBox();
        jLabel80 = new javax.swing.JLabel();
        jTipoEtilismo = new javax.swing.JFormattedTextField();
        jLabel81 = new javax.swing.JLabel();
        jComboBoxMedicaoAlopatica = new javax.swing.JComboBox();
        jLabel82 = new javax.swing.JLabel();
        jTipoMedicaoAlopatica = new javax.swing.JFormattedTextField();
        jLabel83 = new javax.swing.JLabel();
        jComboBoxSPA = new javax.swing.JComboBox();
        jLabel84 = new javax.swing.JLabel();
        jTipoSPA = new javax.swing.JFormattedTextField();
        jComboBoxEtilismoUsuario = new javax.swing.JComboBox();
        jComboBoxSPAUsuario = new javax.swing.JComboBox();
        jComboBoxMedicaoAlopaticaUsuario = new javax.swing.JComboBox();
        jComboBoxTabagismoUsuario = new javax.swing.JComboBox();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jObsEstiloVida = new javax.swing.JTextArea();
        jLabel85 = new javax.swing.JLabel();
        jComboBoxVidaSexual = new javax.swing.JComboBox();
        jLabel86 = new javax.swing.JLabel();
        jComboBoxMetodoContraCeptivo = new javax.swing.JComboBox();
        jLabel87 = new javax.swing.JLabel();
        jQualMetodoContraCeptivo = new javax.swing.JTextField();
        jLabel90 = new javax.swing.JLabel();
        jComboBoxGestante = new javax.swing.JComboBox();
        jLabel91 = new javax.swing.JLabel();
        jComboBoxAborto = new javax.swing.JComboBox();
        jLabel92 = new javax.swing.JLabel();
        jMotivoAborto = new javax.swing.JTextField();
        jLabel93 = new javax.swing.JLabel();
        jComboBoxPraticaAtividadeFisica = new javax.swing.JComboBox();
        jLabel94 = new javax.swing.JLabel();
        jQualAtividadeFisica = new javax.swing.JTextField();
        jLabel95 = new javax.swing.JLabel();
        jComboBoxTrataPsicologico = new javax.swing.JComboBox();
        jPanel16 = new javax.swing.JPanel();
        jFotoInternoTerapia = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        jComboBoxEscreveProprioNome = new javax.swing.JComboBox();
        jComboBoxNivelInstrucao = new javax.swing.JComboBox();
        jLabel60 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jComboBoxSabeLerEscrever = new javax.swing.JComboBox();
        jComboBoxInteresseEstudar = new javax.swing.JComboBox();
        jLabel61 = new javax.swing.JLabel();
        jComboBoxCursoProfissionalizante = new javax.swing.JComboBox();
        jLabel62 = new javax.swing.JLabel();
        jComboBoxDescricaoCurso = new javax.swing.JComboBox();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTabelaCursos_NOVO = new javax.swing.JTable();
        jPanel35 = new javax.swing.JPanel();
        jBtIncluirCurso = new javax.swing.JButton();
        jBtExcluirCurso = new javax.swing.JButton();
        jPanel36 = new javax.swing.JPanel();
        jRadioBtC = new javax.swing.JRadioButton();
        jRadioBtB = new javax.swing.JRadioButton();
        jRadioBtA = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        jBtNovoHistoricoEduca = new javax.swing.JButton();
        jBtAlterarHistoricoEduca = new javax.swing.JButton();
        jBtExcluirHistoricoEduca = new javax.swing.JButton();
        jBtSalvarHistoricoEduca = new javax.swing.JButton();
        jBtCancelarHistoricoEduca = new javax.swing.JButton();
        jBtRefersCursos = new javax.swing.JButton();
        jBtAuditoriaHistoricoEduca = new javax.swing.JButton();
        jPanel37 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jComboBoxQualProfissao = new javax.swing.JComboBox();
        jComboBoxQualExperienciaProfissional = new javax.swing.JComboBox();
        jLabel65 = new javax.swing.JLabel();
        jComboBoxTemProfissao = new javax.swing.JComboBox();
        jLabel66 = new javax.swing.JLabel();
        jComboBoxExperienciaProfissional = new javax.swing.JComboBox();
        jLabel70 = new javax.swing.JLabel();
        jComboBoxDesejaTrabalharUnid = new javax.swing.JComboBox();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTabelaExperiencia = new javax.swing.JTable();
        jPanel39 = new javax.swing.JPanel();
        jBtIncluirExperiencia = new javax.swing.JButton();
        jBtExcluirExperiencia = new javax.swing.JButton();
        jRadioBtRemunerado = new javax.swing.JRadioButton();
        jRadioBtNaoRemunerado = new javax.swing.JRadioButton();
        jRadioBtAmbos = new javax.swing.JRadioButton();
        jLabel71 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jBtNovoHistoricoLabor = new javax.swing.JButton();
        jBtAlterarHistoricoLabor = new javax.swing.JButton();
        jBtExcluirHistoricoLabor = new javax.swing.JButton();
        jBtSalvarHistoricoLabor = new javax.swing.JButton();
        jBtCancelarHistoricoLabor = new javax.swing.JButton();
        jBtSairHistorico = new javax.swing.JButton();
        jBtRefersProfissao = new javax.swing.JButton();
        jBtAuditoriaHistoricoLabor = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jComboBoxConhecoHabilidades = new javax.swing.JComboBox();
        jComboBoxEsperoResultados = new javax.swing.JComboBox();
        jComboBoxAcreditaRealizacoes = new javax.swing.JComboBox();
        jLabel27 = new javax.swing.JLabel();
        jComboBoxAcreditoRealizaTrabalho = new javax.swing.JComboBox();
        jComboBoxAcreditoRealizaLar = new javax.swing.JComboBox();
        jLabel25 = new javax.swing.JLabel();
        jComboBoxAcreditoDiverteLazer = new javax.swing.JComboBox();
        jPanel21 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jComboBoxFacoAtividades = new javax.swing.JComboBox();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jComboBoxTenhoObjetoFuturo = new javax.swing.JComboBox();
        jComboBoxTenhoExpectativa = new javax.swing.JComboBox();
        jPanel22 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jComboBoxIdentificoGostos = new javax.swing.JComboBox();
        jComboBoxTenhoVariosInteresse = new javax.swing.JComboBox();
        jComboBoxParticipoProjetosImport = new javax.swing.JComboBox();
        jPanel23 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jComboBoxCostumoComprometo = new javax.swing.JComboBox();
        jComboBoxDeEstudante = new javax.swing.JComboBox();
        jComboBoxDeTrabalho = new javax.swing.JComboBox();
        jComboBoxDeAmigo = new javax.swing.JComboBox();
        jComboBoxDeFamiliar = new javax.swing.JComboBox();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jComboBoxReconhecoPapeis = new javax.swing.JComboBox();
        jComboBoxMantenhoVida = new javax.swing.JComboBox();
        jPanel26 = new javax.swing.JPanel();
        jBtNovoAvaliacaoI = new javax.swing.JButton();
        jBtAlterarAvaliacaoI = new javax.swing.JButton();
        jBtExcluirAvaliacaoI = new javax.swing.JButton();
        jBtSalvarAvaliacaoI = new javax.swing.JButton();
        jBtCancelarAvaliacaoI = new javax.swing.JButton();
        jBtSairAvaliacaoI = new javax.swing.JButton();
        jBtAuditoriaAvaliacaoI = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jComboBoxOrganizoTempo = new javax.swing.JComboBox();
        jLabel41 = new javax.swing.JLabel();
        jComboBoxMantenhoPapeis = new javax.swing.JComboBox();
        jLabel42 = new javax.swing.JLabel();
        jComboBoxSouRotina = new javax.swing.JComboBox();
        jPanel27 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jComboBoxConsigoOutros = new javax.swing.JComboBox();
        jComboBoxTenhoSocial = new javax.swing.JComboBox();
        jComboBoxPlanejoAgir = new javax.swing.JComboBox();
        jComboBoxConcentroTrabalho = new javax.swing.JComboBox();
        jComboBoxIdentificoProblemas = new javax.swing.JComboBox();
        jComboBoxIdentificoSolucaoProblemas = new javax.swing.JComboBox();
        jComboBoxQuandoAgir = new javax.swing.JComboBox();
        jComboBoxConsigoCotidianas = new javax.swing.JComboBox();
        jComboBoxConsigoHigiene = new javax.swing.JComboBox();
        jComboBoxConsigoFinancas = new javax.swing.JComboBox();
        jComboBoxConsigoCasa = new javax.swing.JComboBox();
        jComboBoxSintoPreciso = new javax.swing.JComboBox();
        jPanel28 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jComboBoxCostumoFrequentar = new javax.swing.JComboBox();
        jLabel56 = new javax.swing.JLabel();
        jDataAplicacao = new com.toedter.calendar.JDateChooser();
        jPanel29 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jResponsavelAplicacao = new javax.swing.JTextField();
        jPanel25 = new javax.swing.JPanel();
        jBtNovoAvaliacaoII = new javax.swing.JButton();
        jBtAlterarAvaliacaoII = new javax.swing.JButton();
        jBtExcluirAvaliacaoII = new javax.swing.JButton();
        jBtSalvarAvaliacaoII = new javax.swing.JButton();
        jBtCancelarAvaliacaoII = new javax.swing.JButton();
        jBtSairAvaliacaoII = new javax.swing.JButton();
        jBtAuditoriaAvaliacaoII = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("...::: Admissão Terapia - Porta Entrada :::...");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Código:");

        jIDPesqLanc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIDPesqLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtTodos1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtTodos1.setContentAreaFilled(false);
        jBtTodos1.setDefaultCapable(false);
        jBtTodos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtTodos1ActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Data Inicial:");

        jDataPesqInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("Data Final:");

        jDataPesqFinal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqData.setContentAreaFilled(false);
        jBtPesqData.setDefaultCapable(false);
        jBtPesqData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqDataActionPerformed(evt);
            }
        });

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox1.setText("Todos");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Nome Interno:");

        jnomeInternoPesq.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesquisaNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesquisaNome.setContentAreaFilled(false);
        jBtPesquisaNome.setDefaultCapable(false);
        jBtPesquisaNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisaNomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel14Layout.createSequentialGroup()
                            .addGap(39, 39, 39)
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jIDPesqLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jBtTodos1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(216, 216, 216)
                            .addComponent(jCheckBox1)
                            .addGap(57, 57, 57))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel14Layout.createSequentialGroup()
                            .addGap(13, 13, 13)
                            .addComponent(jLabel21)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel22)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jDataPesqFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jBtPesqData, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(123, 123, 123)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jnomeInternoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtPesquisaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIDPesqLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtTodos1)
                    .addComponent(jLabel11)
                    .addComponent(jCheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel21)
                    .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(jDataPesqFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtPesquisaNome)
                    .addComponent(jnomeInternoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaAtendimentoTerapia.setAutoCreateRowSorter(true);
        jTabelaAtendimentoTerapia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaAtendimentoTerapia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Status", "Data Cadastro", "Nome do Interno"
            }
        ));
        jTabelaAtendimentoTerapia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaAtendimentoTerapiaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTabelaAtendimentoTerapia);

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
            .addGap(0, 387, Short.MAX_VALUE)
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("Lisagem", jPanel1);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Status");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Data ");

        jIdAtendNovo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdAtendNovo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdAtendNovo.setEnabled(false);

        jStatusLanc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jStatusLanc.setForeground(new java.awt.Color(255, 0, 0));
        jStatusLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jStatusLanc.setEnabled(false);

        jDataLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataLanc.setEnabled(false);

        jIdInternoAD.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdInternoAD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdInternoAD.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Código");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Nome Completo do Interno");

        jNomeInternoAD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoAD.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("At.Principal");

        jIdADM_Principal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdADM_Principal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdADM_Principal.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jIdADM_Principal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jIdAtendNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jStatusLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jDataLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jIdInternoAD, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(175, 175, 175))
                            .addComponent(jNomeInternoAD))))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jIdAtendNovo, jIdInternoAD});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel6)))
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIdADM_Principal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdAtendNovo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jStatusLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jIdInternoAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jNomeInternoAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jBtNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovo.setToolTipText("Novo");
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
        jBtAlterar.setToolTipText("Alterar");
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
        jBtExcluir.setToolTipText("Excluir");
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
        jBtSalvar.setToolTipText("Gravar");
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
        jBtCancelar.setToolTipText("Cancelar");
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
        jBtFinalizar.setToolTipText("Finalizar");
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
        jBtSair.setToolTipText("Sair");
        jBtSair.setContentAreaFilled(false);
        jBtSair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSair.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSair.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        jBtImpressao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/gtklp-icone-3770-16.png"))); // NOI18N
        jBtImpressao.setToolTipText("Impressão");
        jBtImpressao.setContentAreaFilled(false);
        jBtImpressao.setEnabled(false);
        jBtImpressao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtImpressao.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtImpressao.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtImpressao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtImpressaoActionPerformed(evt);
            }
        });

        jBtAuditoria.setForeground(new java.awt.Color(0, 0, 255));
        jBtAuditoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoria.setToolTipText("Auditoria");
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

        jBtConcluir.setForeground(new java.awt.Color(0, 153, 0));
        jBtConcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/tick.png"))); // NOI18N
        jBtConcluir.setToolTipText("Concluir Atendimento");
        jBtConcluir.setContentAreaFilled(false);
        jBtConcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtConcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jBtNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jBtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jBtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jBtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jBtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jBtFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtConcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtImpressao, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel9Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterar, jBtCancelar, jBtExcluir, jBtFinalizar, jBtNovo, jBtSalvar});

        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtAuditoria)
                    .addComponent(jBtImpressao)
                    .addComponent(jBtConcluir)
                    .addComponent(jBtSair)
                    .addComponent(jBtFinalizar)
                    .addComponent(jBtCancelar)
                    .addComponent(jBtSalvar)
                    .addComponent(jBtExcluir)
                    .addComponent(jBtAlterar)
                    .addComponent(jBtNovo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jObsDesempenhoOcupacional.setColumns(20);
        jObsDesempenhoOcupacional.setRows(5);
        jObsDesempenhoOcupacional.setText("DIGITE AQUI A EVOLUÇÃO DA ADMISSÃO.");
        jObsDesempenhoOcupacional.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jObsDesempenhoOcupacional.setEnabled(false);
        jScrollPane1.setViewportView(jObsDesempenhoOcupacional);

        jLabel96.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(0, 0, 204));
        jLabel96.setText("Dominância:");

        jComboBoxDominancia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDominancia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Destro", "Canhoto", "Ambidestro" }));
        jComboBoxDominancia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDominancia.setEnabled(false);

        jLabel97.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel97.setText("Amputação?");

        jComboBoxAmputacao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxAmputacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxAmputacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxAmputacao.setEnabled(false);

        jLabel98.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel98.setText("Deficiência?");

        jComboBoxDeficienciaOcupa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDeficienciaOcupa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxDeficienciaOcupa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDeficienciaOcupa.setEnabled(false);

        jLabel99.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(0, 102, 0));
        jLabel99.setText("Presença de Alteração:");

        jLabel100.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel100.setText("Motora:");

        jComboBoxMotora.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxMotora.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxMotora.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxMotora.setEnabled(false);

        jLabel101.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel101.setText("Cognitiva:");

        jComboBoxCognitiva.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxCognitiva.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxCognitiva.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxCognitiva.setEnabled(false);

        jLabel102.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel102.setText("Sensorial:");

        jComboBoxSensorial.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxSensorial.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxSensorial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxSensorial.setEnabled(false);

        jComboBoxIntPsi.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxIntPsi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxIntPsi.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxIntPsi.setEnabled(false);

        jLabel103.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel103.setText("Int./ Psi:");
        jLabel103.setToolTipText("Integrativa/ Psicossocial:");

        jLabel104.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel104.setText("Nec. reabilitação?");
        jLabel104.setToolTipText("Necessita reabilitação?");

        jComboBoxReabilitacao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxReabilitacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxReabilitacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxReabilitacao.setEnabled(false);

        jLabel105.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel105.setForeground(new java.awt.Color(204, 0, 0));
        jLabel105.setText("Independente para:");

        jLabel106.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel106.setText("AVD:");

        jLabel107.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel107.setText("AIVD:");

        jLabel108.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel108.setText("Lazer:");

        jLabel109.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel109.setText("Trabalho:");

        jComboBoxTrabalho.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTrabalho.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxTrabalho.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTrabalho.setEnabled(false);

        jComboBoxLazer.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxLazer.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxLazer.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxLazer.setEnabled(false);

        jComboBoxAIVD.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxAIVD.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxAIVD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxAIVD.setEnabled(false);

        jComboBoxAVD.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxAVD.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxAVD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxAVD.setEnabled(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1)
                .addGap(10, 10, 10))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel96)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel108)
                            .addComponent(jLabel102)
                            .addComponent(jLabel104)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jComboBoxDominancia, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel97))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel99)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel100))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel105)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel106)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxLazer, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxAVD, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxSensorial, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxMotora, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxReabilitacao, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxAmputacao, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel98)
                    .addComponent(jLabel103, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel109, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel107, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel101, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxDeficienciaOcupa, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxCognitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxIntPsi, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxAIVD, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel96)
                    .addComponent(jComboBoxDominancia, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel97)
                    .addComponent(jComboBoxAmputacao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel104)
                    .addComponent(jComboBoxReabilitacao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel98)
                    .addComponent(jComboBoxDeficienciaOcupa, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel99)
                    .addComponent(jLabel100)
                    .addComponent(jComboBoxMotora, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel101)
                    .addComponent(jComboBoxCognitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel103)
                    .addComponent(jComboBoxIntPsi, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel102)
                    .addComponent(jComboBoxSensorial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel106)
                    .addComponent(jComboBoxAVD, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel107)
                    .addComponent(jComboBoxAIVD, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel105))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel108)
                    .addComponent(jComboBoxLazer, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel109)
                    .addComponent(jComboBoxTrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Desempenho Ocupacional", jPanel6);

        jObsHistoricoFamiliar.setColumns(20);
        jObsHistoricoFamiliar.setRows(5);
        jObsHistoricoFamiliar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jObsHistoricoFamiliar.setEnabled(false);
        jScrollPane2.setViewportView(jObsHistoricoFamiliar);

        jLabel88.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel88.setText("Pais vivos?");

        jComboBoxPaisVivos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxPaisVivos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim", "Não sei" }));
        jComboBoxPaisVivos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxPaisVivos.setEnabled(false);

        jLabel89.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel89.setText("Tem companheiro(a)?");

        jComboBoxTemCompanheira.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTemCompanheira.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxTemCompanheira.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTemCompanheira.setEnabled(false);

        jLabel118.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel118.setText("Tem filhos?");

        jComboBoxTemFilhos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTemFilhos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxTemFilhos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTemFilhos.setEnabled(false);

        jLabel119.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel119.setText("Qtos?");

        jQuantosFilhos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQuantosFilhos.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jQuantosFilhos.setEnabled(false);

        jLabel120.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel120.setText("Recebe visita?");

        jCheckBoxSFSeg.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxSFSeg.setText("Seg");
        jCheckBoxSFSeg.setEnabled(false);

        jCheckBoxSFTer.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxSFTer.setText("Ter");
        jCheckBoxSFTer.setEnabled(false);

        jCheckBoxSFQua.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxSFQua.setText("Qua");
        jCheckBoxSFQua.setEnabled(false);

        jCheckBoxSFQui.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxSFQui.setText("Qui");
        jCheckBoxSFQui.setEnabled(false);

        jCheckBoxSFSex.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxSFSex.setText("Sex");
        jCheckBoxSFSex.setEnabled(false);

        jCheckBoxSFSab.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxSFSab.setText("Sáb");
        jCheckBoxSFSab.setEnabled(false);

        jCheckBoxSFDom.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxSFDom.setText("Dom");
        jCheckBoxSFDom.setEnabled(false);

        jCheckBoxIntSeg.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxIntSeg.setText("Seg");
        jCheckBoxIntSeg.setEnabled(false);

        jCheckBoxIntTer.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxIntTer.setText("Ter");
        jCheckBoxIntTer.setEnabled(false);

        jCheckBoxIntQua.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxIntQua.setText("Qua");
        jCheckBoxIntQua.setEnabled(false);

        jCheckBoxIntQui.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxIntQui.setText("Qui");
        jCheckBoxIntQui.setEnabled(false);

        jCheckBoxIntSex.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxIntSex.setText("Sex");
        jCheckBoxIntSex.setEnabled(false);

        jCheckBoxIntSab.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxIntSab.setText("Sáb");
        jCheckBoxIntSab.setEnabled(false);

        jCheckBoxIntDom.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxIntDom.setText("Dom");
        jCheckBoxIntDom.setEnabled(false);

        jComboBoxVisitaFamiliar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxVisitaFamiliar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxVisitaFamiliar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxVisitaFamiliar.setEnabled(false);

        jLabel121.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel121.setText("Social/Familiar:");

        jLabel122.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel122.setText("Intima:");

        jComboBoxVisitaIntima.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxVisitaIntima.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxVisitaIntima.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxVisitaIntima.setEnabled(false);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel120)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxVisitaFamiliar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel122)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxVisitaIntima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel121)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jCheckBoxSFSeg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxSFTer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxSFQua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxSFQui)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxSFSex)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxSFSab)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxSFDom))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jCheckBoxIntSeg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxIntTer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxIntQua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxIntQui)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxIntSex)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxIntSab)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxIntDom)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel88)
                        .addGap(6, 6, 6)
                        .addComponent(jComboBoxPaisVivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel89)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxTemCompanheira, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel118)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxTemFilhos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(jLabel119)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jQuantosFilhos, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel88)
                    .addComponent(jComboBoxPaisVivos, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel89)
                    .addComponent(jComboBoxTemCompanheira, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel118)
                    .addComponent(jComboBoxTemFilhos, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jQuantosFilhos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel119))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel120)
                    .addComponent(jComboBoxVisitaFamiliar, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel121)
                    .addComponent(jCheckBoxSFSeg)
                    .addComponent(jCheckBoxSFTer)
                    .addComponent(jCheckBoxSFQua)
                    .addComponent(jCheckBoxSFQui)
                    .addComponent(jCheckBoxSFSex)
                    .addComponent(jCheckBoxSFSab)
                    .addComponent(jCheckBoxSFDom))
                .addGap(3, 3, 3)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel122)
                    .addComponent(jComboBoxVisitaIntima, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxIntSeg)
                    .addComponent(jCheckBoxIntTer)
                    .addComponent(jCheckBoxIntQua)
                    .addComponent(jCheckBoxIntQui)
                    .addComponent(jCheckBoxIntSex)
                    .addComponent(jCheckBoxIntSab)
                    .addComponent(jCheckBoxIntDom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Histórico Familiar", jPanel7);

        ObsDadosClinicos.setColumns(20);
        ObsDadosClinicos.setRows(5);
        ObsDadosClinicos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        ObsDadosClinicos.setEnabled(false);
        jScrollPane3.setViewportView(ObsDadosClinicos);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Você apresenta alguma destas doenças?");

        jComboBoxHipertensao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxHipertensao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxHipertensao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxHipertensao.setEnabled(false);

        jLabel72.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel72.setText("Diabetes:");

        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel73.setText("Hipertensão:");

        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel74.setText("Cancêr:");

        jLabel75.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel75.setText("Problemas Respiratório:");

        jLabel76.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel76.setText("Infectocontagiosa:");

        jLabel77.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel77.setText("Transt. Mental:");

        jLabel78.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel78.setText("Deficiência (Visual, auditiva, física):");

        jLabel79.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel79.setText("Doenças do trato digestivo:");

        jComboBoxDiabetes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDiabetes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxDiabetes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDiabetes.setEnabled(false);

        jComboBoxCancer.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxCancer.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxCancer.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxCancer.setEnabled(false);

        jComboBoxProRespiratorio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxProRespiratorio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxProRespiratorio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxProRespiratorio.setEnabled(false);

        jComboBoxTransMental.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTransMental.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxTransMental.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTransMental.setEnabled(false);

        jComboBoxDoencasDigestivo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDoencasDigestivo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxDoencasDigestivo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDoencasDigestivo.setEnabled(false);

        jComboBoxInfectocontagiosa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxInfectocontagiosa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxInfectocontagiosa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxInfectocontagiosa.setEnabled(false);

        jComboBoxDeficienciaVAF.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDeficienciaVAF.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxDeficienciaVAF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDeficienciaVAF.setEnabled(false);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel78)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxDeficienciaVAF, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel75)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxProRespiratorio, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel79)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxDoencasDigestivo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel74)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxCancer, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel77)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxTransMental, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel76)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxInfectocontagiosa, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel73)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxHipertensao, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel72)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxDiabetes, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 43, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel74)
                    .addComponent(jComboBoxCancer, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel73)
                    .addComponent(jComboBoxHipertensao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel75)
                        .addComponent(jComboBoxProRespiratorio, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jComboBoxTransMental, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel77)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel79)
                    .addComponent(jComboBoxDoencasDigestivo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel76)
                    .addComponent(jComboBoxInfectocontagiosa, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel78)
                    .addComponent(jComboBoxDeficienciaVAF, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxDiabetes, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel72))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Dados Clinicos", jPanel8);

        ObsAlteracoesPsicologicas.setColumns(20);
        ObsAlteracoesPsicologicas.setRows(5);
        ObsAlteracoesPsicologicas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        ObsAlteracoesPsicologicas.setEnabled(false);
        jScrollPane7.setViewportView(ObsAlteracoesPsicologicas);

        jLabel110.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel110.setText("Humor disfórico/deprimido:");

        jComboBoxHumor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxHumor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxHumor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxHumor.setEnabled(false);

        jLabel111.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel111.setText("Insônia:");

        jLabel112.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel112.setText("Irritabilidade:");

        jLabel113.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel113.setText("frustração:");

        jComboBoxInsonia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxInsonia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxInsonia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxInsonia.setEnabled(false);

        jComboBoxIrritabilidade.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxIrritabilidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxIrritabilidade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxIrritabilidade.setEnabled(false);

        jComboBoxFrustracao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxFrustracao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxFrustracao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxFrustracao.setEnabled(false);

        jLabel114.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel114.setText("Raiva:");

        jLabel115.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel115.setText("Ansiedade:");

        jLabel116.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel116.setText("Dificuldade concentrar-se:");
        jLabel116.setToolTipText("Dificuldade para concentrar-se");

        jLabel117.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel117.setText("Inquietação:");

        jComboBoxDificultadeConcentrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDificultadeConcentrar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxDificultadeConcentrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDificultadeConcentrar.setEnabled(false);

        jComboBoxRaiva.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxRaiva.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxRaiva.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxRaiva.setEnabled(false);

        jComboBoxInquietacao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxInquietacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxInquietacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxInquietacao.setEnabled(false);

        jComboBoxAnsiedade.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxAnsiedade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxAnsiedade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxAnsiedade.setEnabled(false);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jLabel113))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel110)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxFrustracao, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jComboBoxDificultadeConcentrar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel115, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel114, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel111, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBoxAnsiedade, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(152, 152, 152))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBoxRaiva, 0, 53, Short.MAX_VALUE)
                                    .addComponent(jComboBoxInsonia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel112)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxIrritabilidade, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel117)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxInquietacao, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addComponent(jComboBoxHumor, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(119, 119, 119))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel116)
                .addGap(462, 462, 462))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jComboBoxAnsiedade, jComboBoxInsonia, jComboBoxRaiva});

        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxIrritabilidade, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel112)
                    .addComponent(jComboBoxInsonia, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel111)
                    .addComponent(jComboBoxHumor, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel110))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxInquietacao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel117)
                    .addComponent(jComboBoxRaiva, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel114)
                    .addComponent(jComboBoxDificultadeConcentrar, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel116))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel113)
                    .addComponent(jComboBoxFrustracao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel115)
                    .addComponent(jComboBoxAnsiedade, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Alterações Psicologicas", jPanel10);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Tabagismo:");

        jComboBoxTabagismo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTabagismo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxTabagismo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTabagismo.setEnabled(false);

        jLabel69.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel69.setText("Q.P.D.");

        jQuantoTabagismo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQuantoTabagismo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jQuantoTabagismo.setEnabled(false);

        jObsTriagemSPA.setColumns(20);
        jObsTriagemSPA.setRows(5);
        jObsTriagemSPA.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jScrollPane5.setViewportView(jObsTriagemSPA);

        jLabel68.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel68.setText("Etilismo:");

        jComboBoxEtilismo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxEtilismo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxEtilismo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxEtilismo.setEnabled(false);

        jLabel80.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel80.setText("Tipo:");

        jTipoEtilismo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTipoEtilismo.setEnabled(false);

        jLabel81.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel81.setText("Med. alopática?");
        jLabel81.setToolTipText("Medicação alopática");

        jComboBoxMedicaoAlopatica.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxMedicaoAlopatica.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxMedicaoAlopatica.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxMedicaoAlopatica.setEnabled(false);

        jLabel82.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel82.setText("Tipo:");

        jTipoMedicaoAlopatica.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTipoMedicaoAlopatica.setEnabled(false);

        jLabel83.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel83.setText("Outra(s) SPA (s)?");

        jComboBoxSPA.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxSPA.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxSPA.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxSPA.setEnabled(false);

        jLabel84.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel84.setText("Tipo:");

        jTipoSPA.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTipoSPA.setEnabled(false);

        jComboBoxEtilismoUsuario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxEtilismoUsuario.setForeground(new java.awt.Color(153, 0, 102));
        jComboBoxEtilismoUsuario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Usuário Recreativo", "Usuário", "Dependente", "Não se aplica" }));
        jComboBoxEtilismoUsuario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxEtilismoUsuario.setEnabled(false);

        jComboBoxSPAUsuario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxSPAUsuario.setForeground(new java.awt.Color(153, 0, 102));
        jComboBoxSPAUsuario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Usuário Recreativo", "Usuário", "Dependente", "Não se aplica" }));
        jComboBoxSPAUsuario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxSPAUsuario.setEnabled(false);

        jComboBoxMedicaoAlopaticaUsuario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxMedicaoAlopaticaUsuario.setForeground(new java.awt.Color(153, 0, 102));
        jComboBoxMedicaoAlopaticaUsuario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Usuário Recreativo", "Usuário", "Dependente", "Não se aplica" }));
        jComboBoxMedicaoAlopaticaUsuario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxMedicaoAlopaticaUsuario.setEnabled(false);

        jComboBoxTabagismoUsuario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTabagismoUsuario.setForeground(new java.awt.Color(153, 0, 102));
        jComboBoxTabagismoUsuario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Usuário Recreativo", "Usuário", "Dependente", "Não se aplica" }));
        jComboBoxTabagismoUsuario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTabagismoUsuario.setEnabled(false);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel68)
                            .addComponent(jLabel10)
                            .addComponent(jLabel81)
                            .addComponent(jLabel83))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxMedicaoAlopatica, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxSPA, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxTabagismo, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxEtilismo, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel84, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel82, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel80, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel69, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jQuantoTabagismo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTipoMedicaoAlopatica, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                            .addComponent(jTipoEtilismo)
                            .addComponent(jTipoSPA))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jComboBoxMedicaoAlopaticaUsuario, 0, 0, Short.MAX_VALUE)
                                .addComponent(jComboBoxSPAUsuario, 0, 0, Short.MAX_VALUE))
                            .addComponent(jComboBoxEtilismoUsuario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxTabagismoUsuario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jComboBoxEtilismoUsuario, jComboBoxMedicaoAlopaticaUsuario, jComboBoxSPAUsuario, jComboBoxTabagismoUsuario});

        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel10)
                    .addComponent(jComboBoxTabagismo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel69)
                    .addComponent(jQuantoTabagismo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTabagismoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel68)
                    .addComponent(jComboBoxEtilismo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel80)
                    .addComponent(jTipoEtilismo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxEtilismoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel81)
                    .addComponent(jComboBoxMedicaoAlopatica, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel82)
                    .addComponent(jTipoMedicaoAlopatica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxMedicaoAlopaticaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel83)
                    .addComponent(jComboBoxSPA, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel84)
                    .addComponent(jTipoSPA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxSPAUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Qualidade de Vida - (Triagem Spa)", jPanel11);

        jObsEstiloVida.setColumns(20);
        jObsEstiloVida.setRows(5);
        jObsEstiloVida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jObsEstiloVida.setEnabled(false);
        jScrollPane6.setViewportView(jObsEstiloVida);

        jLabel85.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel85.setText("Vida sexual ativa:");

        jComboBoxVidaSexual.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxVidaSexual.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxVidaSexual.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxVidaSexual.setEnabled(false);

        jLabel86.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel86.setText("Método contraceptivo:");

        jComboBoxMetodoContraCeptivo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxMetodoContraCeptivo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxMetodoContraCeptivo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxMetodoContraCeptivo.setEnabled(false);

        jLabel87.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel87.setText("Qual?");

        jQualMetodoContraCeptivo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualMetodoContraCeptivo.setEnabled(false);

        jLabel90.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel90.setText("Gestante:");

        jComboBoxGestante.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxGestante.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxGestante.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxGestante.setEnabled(false);

        jLabel91.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel91.setText("Aborto:");

        jComboBoxAborto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxAborto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxAborto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxAborto.setEnabled(false);

        jLabel92.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel92.setText("Motivo Aborto:");

        jMotivoAborto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMotivoAborto.setEnabled(false);
        jMotivoAborto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMotivoAbortoActionPerformed(evt);
            }
        });

        jLabel93.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel93.setText("Pratica ativ. física?");
        jLabel93.setToolTipText("Pratica Atividade Fisica");

        jComboBoxPraticaAtividadeFisica.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxPraticaAtividadeFisica.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxPraticaAtividadeFisica.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxPraticaAtividadeFisica.setEnabled(false);

        jLabel94.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel94.setText("Qual/ Freqüência?");

        jQualAtividadeFisica.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualAtividadeFisica.setEnabled(false);

        jLabel95.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel95.setText("Já fez ou faz tratamento com psicólogo/psiquiatra? ");
        jLabel95.setToolTipText("Já fez ou faz tratamento com psicólogo ou psiquiatra: ");

        jComboBoxTrataPsicologico.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTrataPsicologico.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxTrataPsicologico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTrataPsicologico.setEnabled(false);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel85)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxVidaSexual, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel93)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxPraticaAtividadeFisica, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel91)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxAborto, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel90)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxGestante, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel86)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxMetodoContraCeptivo, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel87)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jQualMetodoContraCeptivo))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel92)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(jLabel94)
                                        .addGap(2, 2, 2)))
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jQualAtividadeFisica, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                                    .addComponent(jMotivoAborto)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                                .addGap(0, 29, Short.MAX_VALUE)
                                .addComponent(jLabel95)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxTrataPsicologico, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel85)
                            .addComponent(jComboBoxVidaSexual, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel86)
                            .addComponent(jComboBoxMetodoContraCeptivo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel87)
                            .addComponent(jQualMetodoContraCeptivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jComboBoxAborto, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel91))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel93)
                            .addComponent(jComboBoxPraticaAtividadeFisica, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jMotivoAborto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel92))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jQualAtividadeFisica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel94))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxGestante, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel90)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel95)
                        .addComponent(jComboBoxTrataPsicologico, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Qualidade de Vida - (Estilo Vida)", jPanel13);

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoTerapia, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoTerapia, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2))
        );

        jTabbedPane1.addTab("Admissão", jPanel2);

        jPanel34.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Histórico Educacional/Profissionalizante", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel58.setText("Escreve o próprio nome?");

        jComboBoxEscreveProprioNome.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxEscreveProprioNome.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxEscreveProprioNome.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxEscreveProprioNome.setEnabled(false);

        jComboBoxNivelInstrucao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxNivelInstrucao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não Alfabetizado", "Alfabetizado", "Fundamental Completo", "Fundamental Incompleto", "1º Grau Completo", "1º Grau Incompleto", "2º Grau Completo", "2º Grau Incompleto", "Superior Completo", "Superior Incompleto" }));
        jComboBoxNivelInstrucao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxNivelInstrucao.setEnabled(false);

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel60.setText("Nível de instrução:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Têm interesse em estudar?");

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel59.setText("Sabe ler e escrever?");

        jComboBoxSabeLerEscrever.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxSabeLerEscrever.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxSabeLerEscrever.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxSabeLerEscrever.setEnabled(false);

        jComboBoxInteresseEstudar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxInteresseEstudar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxInteresseEstudar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxInteresseEstudar.setEnabled(false);

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel61.setText("Curso profissionalizante?");

        jComboBoxCursoProfissionalizante.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxCursoProfissionalizante.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxCursoProfissionalizante.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxCursoProfissionalizante.setEnabled(false);

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel62.setText("Quais?");

        jComboBoxDescricaoCurso.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDescricaoCurso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione..." }));
        jComboBoxDescricaoCurso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDescricaoCurso.setEnabled(false);

        jTabelaCursos_NOVO.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaCursos_NOVO.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição do Curso", "Prioridade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabelaCursos_NOVO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaCursos_NOVOMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(jTabelaCursos_NOVO);

        jPanel35.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jBtIncluirCurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtIncluirCurso.setToolTipText("Incluir Registro");
        jBtIncluirCurso.setEnabled(false);
        jBtIncluirCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtIncluirCursoActionPerformed(evt);
            }
        });

        jBtExcluirCurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirCurso.setToolTipText("Excluir Registro");
        jBtExcluirCurso.setEnabled(false);
        jBtExcluirCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirCursoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBtIncluirCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtExcluirCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtIncluirCurso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirCurso)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel36.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        buttonGroupProf.add(jRadioBtC);
        jRadioBtC.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioBtC.setForeground(new java.awt.Color(0, 0, 255));
        jRadioBtC.setText(" C");
        jRadioBtC.setEnabled(false);

        buttonGroupProf.add(jRadioBtB);
        jRadioBtB.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioBtB.setForeground(new java.awt.Color(204, 0, 0));
        jRadioBtB.setText(" B");
        jRadioBtB.setEnabled(false);

        buttonGroupProf.add(jRadioBtA);
        jRadioBtA.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioBtA.setForeground(new java.awt.Color(0, 153, 0));
        jRadioBtA.setSelected(true);
        jRadioBtA.setText(" A");
        jRadioBtA.setEnabled(false);

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioBtB)
                    .addComponent(jRadioBtC)
                    .addComponent(jRadioBtA))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addComponent(jRadioBtA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioBtB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioBtC))
        );

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel61, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel60, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel58, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel34Layout.createSequentialGroup()
                                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxEscreveProprioNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxNivelInstrucao, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel34Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxInteresseEstudar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel34Layout.createSequentialGroup()
                                        .addComponent(jLabel59)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxSabeLerEscrever, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel34Layout.createSequentialGroup()
                                .addComponent(jComboBoxCursoProfissionalizante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel62)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxDescricaoCurso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(jComboBoxEscreveProprioNome, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel59)
                    .addComponent(jComboBoxSabeLerEscrever, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60)
                    .addComponent(jComboBoxNivelInstrucao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jComboBoxInteresseEstudar, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61)
                    .addComponent(jComboBoxCursoProfissionalizante, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel62)
                    .addComponent(jComboBoxDescricaoCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jBtNovoHistoricoEduca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoHistoricoEduca.setToolTipText("Novo");
        jBtNovoHistoricoEduca.setContentAreaFilled(false);
        jBtNovoHistoricoEduca.setEnabled(false);
        jBtNovoHistoricoEduca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoHistoricoEducaActionPerformed(evt);
            }
        });

        jBtAlterarHistoricoEduca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarHistoricoEduca.setToolTipText("Alterar");
        jBtAlterarHistoricoEduca.setContentAreaFilled(false);
        jBtAlterarHistoricoEduca.setEnabled(false);
        jBtAlterarHistoricoEduca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarHistoricoEducaActionPerformed(evt);
            }
        });

        jBtExcluirHistoricoEduca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirHistoricoEduca.setToolTipText("Excluir");
        jBtExcluirHistoricoEduca.setContentAreaFilled(false);
        jBtExcluirHistoricoEduca.setEnabled(false);
        jBtExcluirHistoricoEduca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirHistoricoEducaActionPerformed(evt);
            }
        });

        jBtSalvarHistoricoEduca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarHistoricoEduca.setToolTipText("Gravar");
        jBtSalvarHistoricoEduca.setContentAreaFilled(false);
        jBtSalvarHistoricoEduca.setEnabled(false);
        jBtSalvarHistoricoEduca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarHistoricoEducaActionPerformed(evt);
            }
        });

        jBtCancelarHistoricoEduca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarHistoricoEduca.setToolTipText("Cancelar");
        jBtCancelarHistoricoEduca.setContentAreaFilled(false);
        jBtCancelarHistoricoEduca.setEnabled(false);
        jBtCancelarHistoricoEduca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarHistoricoEducaActionPerformed(evt);
            }
        });

        jBtRefersCursos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtRefersCursos.setToolTipText("Refesh");
        jBtRefersCursos.setContentAreaFilled(false);
        jBtRefersCursos.setEnabled(false);
        jBtRefersCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtRefersCursosActionPerformed(evt);
            }
        });

        jBtAuditoriaHistoricoEduca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaHistoricoEduca.setToolTipText("Auditoria");
        jBtAuditoriaHistoricoEduca.setContentAreaFilled(false);
        jBtAuditoriaHistoricoEduca.setEnabled(false);
        jBtAuditoriaHistoricoEduca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaHistoricoEducaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtNovoHistoricoEduca, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jBtAlterarHistoricoEduca, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jBtExcluirHistoricoEduca, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jBtSalvarHistoricoEduca, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jBtCancelarHistoricoEduca, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(144, 144, 144)
                .addComponent(jBtRefersCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 197, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaHistoricoEduca, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterarHistoricoEduca, jBtCancelarHistoricoEduca, jBtExcluirHistoricoEduca, jBtNovoHistoricoEduca, jBtRefersCursos, jBtSalvarHistoricoEduca});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtAuditoriaHistoricoEduca)
                    .addComponent(jBtRefersCursos)
                    .addComponent(jBtCancelarHistoricoEduca)
                    .addComponent(jBtAlterarHistoricoEduca)
                    .addComponent(jBtExcluirHistoricoEduca)
                    .addComponent(jBtSalvarHistoricoEduca)
                    .addComponent(jBtNovoHistoricoEduca))
                .addGap(3, 3, 3))
        );

        jPanel37.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Histórico Laboral", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 153, 0))); // NOI18N

        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel63.setText("Qual?");

        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel64.setText("Qual?");

        jComboBoxQualProfissao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxQualProfissao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione..." }));
        jComboBoxQualProfissao.setToolTipText("Especificar Profissão");
        jComboBoxQualProfissao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxQualProfissao.setEnabled(false);

        jComboBoxQualExperienciaProfissional.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxQualExperienciaProfissional.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione..." }));
        jComboBoxQualExperienciaProfissional.setToolTipText("Especificar Profissão");
        jComboBoxQualExperienciaProfissional.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxQualExperienciaProfissional.setEnabled(false);

        jLabel65.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel65.setText("Tem profissão?");

        jComboBoxTemProfissao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTemProfissao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxTemProfissao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTemProfissao.setEnabled(false);

        jLabel66.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel66.setText("Tem experiência profissional?");

        jComboBoxExperienciaProfissional.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxExperienciaProfissional.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxExperienciaProfissional.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxExperienciaProfissional.setEnabled(false);

        jLabel70.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel70.setText("Deseja Trabalhar na Unidade?");

        jComboBoxDesejaTrabalharUnid.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDesejaTrabalharUnid.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxDesejaTrabalharUnid.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDesejaTrabalharUnid.setEnabled(false);

        jTabelaExperiencia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaExperiencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição da Experiência"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabelaExperiencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaExperienciaMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(jTabelaExperiencia);

        jPanel39.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jBtIncluirExperiencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_white_star.png"))); // NOI18N
        jBtIncluirExperiencia.setText("Incluir");
        jBtIncluirExperiencia.setEnabled(false);
        jBtIncluirExperiencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtIncluirExperienciaActionPerformed(evt);
            }
        });

        jBtExcluirExperiencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirExperiencia.setText("Excluir");
        jBtExcluirExperiencia.setEnabled(false);
        jBtExcluirExperiencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirExperienciaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBtIncluirExperiencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtExcluirExperiencia, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtIncluirExperiencia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirExperiencia)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        buttonGroupLab.add(jRadioBtRemunerado);
        jRadioBtRemunerado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioBtRemunerado.setForeground(new java.awt.Color(0, 0, 255));
        jRadioBtRemunerado.setSelected(true);
        jRadioBtRemunerado.setText("Remunerada");
        jRadioBtRemunerado.setEnabled(false);

        buttonGroupLab.add(jRadioBtNaoRemunerado);
        jRadioBtNaoRemunerado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioBtNaoRemunerado.setForeground(new java.awt.Color(255, 0, 0));
        jRadioBtNaoRemunerado.setText("Não remunerada");
        jRadioBtNaoRemunerado.setEnabled(false);

        buttonGroupLab.add(jRadioBtAmbos);
        jRadioBtAmbos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioBtAmbos.setText("Ambas");
        jRadioBtAmbos.setEnabled(false);

        jLabel71.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel71.setText("IAL:");
        jLabel71.setToolTipText("Interesse em Atividade Laboral");

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel70, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel65, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel66, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jComboBoxTemProfissao, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxDesejaTrabalharUnid, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxExperienciaProfissional, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
                                .addComponent(jLabel71)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioBtRemunerado)
                                .addGap(1, 1, 1)
                                .addComponent(jRadioBtNaoRemunerado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioBtAmbos))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
                                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel64, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel63, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBoxQualProfissao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBoxQualExperienciaProfissional, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
                        .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxDesejaTrabalharUnid, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel70)
                    .addComponent(jLabel71)
                    .addComponent(jRadioBtRemunerado)
                    .addComponent(jRadioBtNaoRemunerado)
                    .addComponent(jRadioBtAmbos, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel65)
                            .addComponent(jComboBoxTemProfissao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel66)
                            .addComponent(jComboBoxExperienciaProfissional, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxQualProfissao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel63))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxQualExperienciaProfissional, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel64))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jBtNovoHistoricoLabor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoHistoricoLabor.setToolTipText("Novo");
        jBtNovoHistoricoLabor.setContentAreaFilled(false);
        jBtNovoHistoricoLabor.setEnabled(false);
        jBtNovoHistoricoLabor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovoHistoricoLabor.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovoHistoricoLabor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovoHistoricoLabor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoHistoricoLaborActionPerformed(evt);
            }
        });

        jBtAlterarHistoricoLabor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarHistoricoLabor.setToolTipText("Alterar");
        jBtAlterarHistoricoLabor.setContentAreaFilled(false);
        jBtAlterarHistoricoLabor.setEnabled(false);
        jBtAlterarHistoricoLabor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterarHistoricoLabor.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarHistoricoLabor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarHistoricoLabor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarHistoricoLaborActionPerformed(evt);
            }
        });

        jBtExcluirHistoricoLabor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirHistoricoLabor.setToolTipText("Excluir");
        jBtExcluirHistoricoLabor.setContentAreaFilled(false);
        jBtExcluirHistoricoLabor.setEnabled(false);
        jBtExcluirHistoricoLabor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluirHistoricoLabor.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirHistoricoLabor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirHistoricoLabor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirHistoricoLaborActionPerformed(evt);
            }
        });

        jBtSalvarHistoricoLabor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarHistoricoLabor.setToolTipText("Gravar");
        jBtSalvarHistoricoLabor.setContentAreaFilled(false);
        jBtSalvarHistoricoLabor.setEnabled(false);
        jBtSalvarHistoricoLabor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvarHistoricoLabor.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarHistoricoLabor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarHistoricoLabor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarHistoricoLaborActionPerformed(evt);
            }
        });

        jBtCancelarHistoricoLabor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarHistoricoLabor.setToolTipText("Cancelar");
        jBtCancelarHistoricoLabor.setContentAreaFilled(false);
        jBtCancelarHistoricoLabor.setEnabled(false);
        jBtCancelarHistoricoLabor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelarHistoricoLabor.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarHistoricoLabor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarHistoricoLabor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarHistoricoLaborActionPerformed(evt);
            }
        });

        jBtSairHistorico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSairHistorico.setToolTipText("Sair");
        jBtSairHistorico.setContentAreaFilled(false);
        jBtSairHistorico.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSairHistorico.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSairHistorico.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSairHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairHistoricoActionPerformed(evt);
            }
        });

        jBtRefersProfissao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtRefersProfissao.setToolTipText("Refesh");
        jBtRefersProfissao.setEnabled(false);
        jBtRefersProfissao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtRefersProfissaoActionPerformed(evt);
            }
        });

        jBtAuditoriaHistoricoLabor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaHistoricoLabor.setToolTipText("Auditoria");
        jBtAuditoriaHistoricoLabor.setContentAreaFilled(false);
        jBtAuditoriaHistoricoLabor.setEnabled(false);
        jBtAuditoriaHistoricoLabor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaHistoricoLaborActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtNovoHistoricoLabor, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jBtAlterarHistoricoLabor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jBtExcluirHistoricoLabor, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jBtSalvarHistoricoLabor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jBtCancelarHistoricoLabor, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121)
                .addComponent(jBtRefersProfissao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addComponent(jBtSairHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jBtAuditoriaHistoricoLabor, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel12Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterarHistoricoLabor, jBtCancelarHistoricoLabor, jBtExcluirHistoricoLabor, jBtNovoHistoricoLabor, jBtSalvarHistoricoLabor});

        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtNovoHistoricoLabor)
                    .addComponent(jBtAlterarHistoricoLabor)
                    .addComponent(jBtExcluirHistoricoLabor)
                    .addComponent(jBtSalvarHistoricoLabor)
                    .addComponent(jBtCancelarHistoricoLabor)
                    .addComponent(jBtSairHistorico)
                    .addComponent(jBtRefersProfissao)
                    .addComponent(jBtAuditoriaHistoricoLabor))
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
        );

        jTabbedPane1.addTab("Histórico Educacional/Laboral", jPanel4);

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Causalidade Pessoal: Como você avalia as suas ações", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 51, 255))); // NOI18N

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Conheço minhas habilidades?");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Espero sempre resultados positivos das minhas ações e projetos?");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setText("Acredito nas minhas realizações?");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setText("Acredito nas minhas realizações no trabalho?");

        jComboBoxConhecoHabilidades.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxConhecoHabilidades.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sim", "Não", "Não sei" }));
        jComboBoxConhecoHabilidades.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxConhecoHabilidades.setEnabled(false);

        jComboBoxEsperoResultados.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxEsperoResultados.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sim", "Não", "Não sei" }));
        jComboBoxEsperoResultados.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxEsperoResultados.setEnabled(false);

        jComboBoxAcreditaRealizacoes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxAcreditaRealizacoes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sim", "Não", "Não sei" }));
        jComboBoxAcreditaRealizacoes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxAcreditaRealizacoes.setEnabled(false);

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setText("Acredito nas minhas realizações no meu lar?");

        jComboBoxAcreditoRealizaTrabalho.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxAcreditoRealizaTrabalho.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sim", "Não", "Não sei" }));
        jComboBoxAcreditoRealizaTrabalho.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxAcreditoRealizaTrabalho.setEnabled(false);

        jComboBoxAcreditoRealizaLar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxAcreditoRealizaLar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sim", "Não", "Não sei" }));
        jComboBoxAcreditoRealizaLar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxAcreditoRealizaLar.setEnabled(false);

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setText("Acredito nas minhas realizações no meu divertimento e no lazer?");

        jComboBoxAcreditoDiverteLazer.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxAcreditoDiverteLazer.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sim", "Não", "Não sei" }));
        jComboBoxAcreditoDiverteLazer.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxAcreditoDiverteLazer.setEnabled(false);

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel20Layout.createSequentialGroup()
                                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jComboBoxAcreditoRealizaLar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel20Layout.createSequentialGroup()
                                    .addComponent(jLabel24)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jComboBoxAcreditoRealizaTrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel25))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxAcreditoDiverteLazer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxEsperoResultados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxConhecoHabilidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxAcreditaRealizacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13))))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel19)
                    .addComponent(jComboBoxConhecoHabilidades, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(jComboBoxAcreditaRealizacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel20)
                    .addComponent(jComboBoxEsperoResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel24)
                    .addComponent(jComboBoxAcreditoRealizaTrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel27)
                    .addComponent(jComboBoxAcreditoRealizaLar, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel25)
                    .addComponent(jComboBoxAcreditoDiverteLazer, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4))
        );

        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Valores: atividades que são importantes e o valor de seus objetivos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setText("Faço ativ. que tem sig.para mim?");

        jComboBoxFacoAtividades.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxFacoAtividades.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sim", "Não", "Não sei" }));
        jComboBoxFacoAtividades.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxFacoAtividades.setEnabled(false);

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel28.setText("Tenho objetivo para futuro?");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel29.setText("Tenho exp. reais a meu respeito?");

        jComboBoxTenhoObjetoFuturo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTenhoObjetoFuturo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sim", "Não", "Não sei" }));
        jComboBoxTenhoObjetoFuturo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTenhoObjetoFuturo.setEnabled(false);

        jComboBoxTenhoExpectativa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTenhoExpectativa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sim", "Não", "Não sei" }));
        jComboBoxTenhoExpectativa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTenhoExpectativa.setEnabled(false);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxFacoAtividades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxTenhoExpectativa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(jComboBoxTenhoObjetoFuturo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel28)
                        .addComponent(jComboBoxTenhoObjetoFuturo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jComboBoxFacoAtividades, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(jComboBoxTenhoExpectativa, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(3, 3, 3))
        );

        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Interesses: a tudo que gosto de fazer", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel30.setText("Identifico meus interesses e gostos?");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel31.setText("Tenho vários interesses?");

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel32.setText("Part. dos proj. que são importantes?");
        jLabel32.setToolTipText("Participo dos projetos que me são importantes?");

        jComboBoxIdentificoGostos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxIdentificoGostos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sim", "Não", "Não sei" }));
        jComboBoxIdentificoGostos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxIdentificoGostos.setEnabled(false);

        jComboBoxTenhoVariosInteresse.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTenhoVariosInteresse.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sim", "Não", "Não sei" }));
        jComboBoxTenhoVariosInteresse.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTenhoVariosInteresse.setEnabled(false);

        jComboBoxParticipoProjetosImport.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxParticipoProjetosImport.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sim", "Não", "Não sei" }));
        jComboBoxParticipoProjetosImport.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxParticipoProjetosImport.setEnabled(false);

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel32)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jComboBoxIdentificoGostos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jComboBoxParticipoProjetosImport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxTenhoVariosInteresse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jComboBoxIdentificoGostos, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel31)
                        .addComponent(jComboBoxTenhoVariosInteresse, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel32)
                        .addComponent(jComboBoxParticipoProjetosImport, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Papíes: desempenho e comportamentos sociais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel33.setText("Costumo envolver nos papéis que comprometo?");

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel34.setText("De esdutante?");

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel35.setText("De trabalhador?");

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel36.setText("De amigo?");

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel37.setText("De familiar?");

        jComboBoxCostumoComprometo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxCostumoComprometo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sim", "Não", "Não sei" }));
        jComboBoxCostumoComprometo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxCostumoComprometo.setEnabled(false);

        jComboBoxDeEstudante.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDeEstudante.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sim", "Não", "Não sei" }));
        jComboBoxDeEstudante.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDeEstudante.setEnabled(false);

        jComboBoxDeTrabalho.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDeTrabalho.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sim", "Não", "Não sei" }));
        jComboBoxDeTrabalho.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDeTrabalho.setEnabled(false);

        jComboBoxDeAmigo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDeAmigo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sim", "Não", "Não sei" }));
        jComboBoxDeAmigo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDeAmigo.setEnabled(false);

        jComboBoxDeFamiliar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDeFamiliar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sim", "Não", "Não sei" }));
        jComboBoxDeFamiliar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDeFamiliar.setEnabled(false);

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel38.setText("Recon. e procuro atingir as exp. de meus papéis?");

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel39.setText("Mant. um equ. saudável dos papéis minha vida?");

        jComboBoxReconhecoPapeis.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxReconhecoPapeis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sim", "Não", "Não sei" }));
        jComboBoxReconhecoPapeis.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxReconhecoPapeis.setEnabled(false);

        jComboBoxMantenhoVida.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxMantenhoVida.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sim", "Não", "Não sei" }));
        jComboBoxMantenhoVida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxMantenhoVida.setEnabled(false);

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel33)
                    .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel23Layout.createSequentialGroup()
                            .addComponent(jLabel35)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jComboBoxDeTrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel36))
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxDeAmigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxCostumoComprometo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                                .addComponent(jLabel34)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxDeEstudante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                                .addComponent(jLabel37)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxDeFamiliar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxMantenhoVida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxReconhecoPapeis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxDeEstudante, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34)
                    .addComponent(jComboBoxCostumoComprometo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(jComboBoxDeTrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36)
                    .addComponent(jComboBoxDeAmigo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37)
                    .addComponent(jComboBoxDeFamiliar, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxReconhecoPapeis, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel39)
                    .addComponent(jComboBoxMantenhoVida, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        jPanel26.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jBtNovoAvaliacaoI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoAvaliacaoI.setToolTipText("Novo");
        jBtNovoAvaliacaoI.setContentAreaFilled(false);
        jBtNovoAvaliacaoI.setEnabled(false);
        jBtNovoAvaliacaoI.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovoAvaliacaoI.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovoAvaliacaoI.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovoAvaliacaoI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoAvaliacaoIActionPerformed(evt);
            }
        });

        jBtAlterarAvaliacaoI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarAvaliacaoI.setToolTipText("Alterar");
        jBtAlterarAvaliacaoI.setContentAreaFilled(false);
        jBtAlterarAvaliacaoI.setEnabled(false);
        jBtAlterarAvaliacaoI.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterarAvaliacaoI.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarAvaliacaoI.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarAvaliacaoI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarAvaliacaoIActionPerformed(evt);
            }
        });

        jBtExcluirAvaliacaoI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirAvaliacaoI.setToolTipText("Excluir");
        jBtExcluirAvaliacaoI.setContentAreaFilled(false);
        jBtExcluirAvaliacaoI.setEnabled(false);
        jBtExcluirAvaliacaoI.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluirAvaliacaoI.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirAvaliacaoI.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirAvaliacaoI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirAvaliacaoIActionPerformed(evt);
            }
        });

        jBtSalvarAvaliacaoI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarAvaliacaoI.setToolTipText("Gravar");
        jBtSalvarAvaliacaoI.setContentAreaFilled(false);
        jBtSalvarAvaliacaoI.setEnabled(false);
        jBtSalvarAvaliacaoI.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvarAvaliacaoI.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarAvaliacaoI.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarAvaliacaoI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarAvaliacaoIActionPerformed(evt);
            }
        });

        jBtCancelarAvaliacaoI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarAvaliacaoI.setToolTipText("Cancelar");
        jBtCancelarAvaliacaoI.setContentAreaFilled(false);
        jBtCancelarAvaliacaoI.setEnabled(false);
        jBtCancelarAvaliacaoI.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelarAvaliacaoI.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarAvaliacaoI.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarAvaliacaoI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarAvaliacaoIActionPerformed(evt);
            }
        });

        jBtSairAvaliacaoI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSairAvaliacaoI.setToolTipText("Sair");
        jBtSairAvaliacaoI.setContentAreaFilled(false);
        jBtSairAvaliacaoI.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSairAvaliacaoI.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSairAvaliacaoI.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSairAvaliacaoI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairAvaliacaoIActionPerformed(evt);
            }
        });

        jBtAuditoriaAvaliacaoI.setForeground(new java.awt.Color(0, 0, 255));
        jBtAuditoriaAvaliacaoI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaAvaliacaoI.setToolTipText("Auditoria");
        jBtAuditoriaAvaliacaoI.setContentAreaFilled(false);
        jBtAuditoriaAvaliacaoI.setEnabled(false);
        jBtAuditoriaAvaliacaoI.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAuditoriaAvaliacaoI.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAuditoriaAvaliacaoI.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAuditoriaAvaliacaoI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaAvaliacaoIActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jBtNovoAvaliacaoI, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jBtAlterarAvaliacaoI, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jBtExcluirAvaliacaoI, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jBtSalvarAvaliacaoI, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jBtCancelarAvaliacaoI, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(133, 133, 133)
                .addComponent(jBtSairAvaliacaoI, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaAvaliacaoI, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtAuditoriaAvaliacaoI)
                    .addComponent(jBtSairAvaliacaoI)
                    .addComponent(jBtCancelarAvaliacaoI)
                    .addComponent(jBtSalvarAvaliacaoI)
                    .addComponent(jBtExcluirAvaliacaoI)
                    .addComponent(jBtAlterarAvaliacaoI)
                    .addComponent(jBtNovoAvaliacaoI))
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel18Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel20, jPanel21, jPanel22, jPanel23, jPanel26});

        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("SAOF I", jPanel18);

        jPanel24.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Hábitos: rotina e cotidiano", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel40.setText("Organizo satisfatóriamente meu tempo?");

        jComboBoxOrganizoTempo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxOrganizoTempo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sim", "Não", "Não sei" }));
        jComboBoxOrganizoTempo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxOrganizoTempo.setEnabled(false);

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel41.setText("Mantenho hábitos saudáveis que ajudam no desempenho dos meus papéis?");

        jComboBoxMantenhoPapeis.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxMantenhoPapeis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sim", "Não", "Não sei" }));
        jComboBoxMantenhoPapeis.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxMantenhoPapeis.setEnabled(false);

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel42.setText("Sou flexível quando ocorrem mudanças na minha rotina?");

        jComboBoxSouRotina.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxSouRotina.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sim", "Não", "Não sei" }));
        jComboBoxSouRotina.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxSouRotina.setEnabled(false);

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel42)
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addComponent(jLabel40)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxSouRotina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxOrganizoTempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(jLabel41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxMantenhoPapeis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(jComboBoxOrganizoTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(jComboBoxMantenhoPapeis, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(jComboBoxSouRotina, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        jPanel27.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Meio Ambiente: recursos ambientais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel43.setText("Consigo expressar para outros?");

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel44.setText("Tenho bom contato social?");

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel45.setText("Planejo antes de agir?");

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel46.setText("Concentro e completo trabalho?");
        jLabel46.setToolTipText("Concentro-me e completo meu trabalho?");

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel47.setText("Identifico meus problemas?");

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel48.setText("Identifico a solução problemas?");
        jLabel48.setToolTipText("Identifico a solução p/ meus problemas?");

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel49.setText("Consigo des. tarefas cotidianas?");
        jLabel49.setToolTipText("Consigo desemp. minhas tarefas cotidianas?");

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel50.setText("Consigo cuidar minha higiêne?");
        jLabel50.setToolTipText("Consigo cuidar da minha higiêne?");

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel51.setText("Cuido das minhas finanças?");

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel52.setText("Consigo cuidar da minha casa?");

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel53.setText("Fisica. capaz fazer que preciso?");
        jLabel53.setToolTipText("Fisicamente capaz de fazer que preciso?");

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel54.setText("Quando identifico, consigo agir?");

        jComboBoxConsigoOutros.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxConsigoOutros.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sim", "Não", "Não sei" }));
        jComboBoxConsigoOutros.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxConsigoOutros.setEnabled(false);

        jComboBoxTenhoSocial.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTenhoSocial.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sim", "Não", "Não sei" }));
        jComboBoxTenhoSocial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTenhoSocial.setEnabled(false);

        jComboBoxPlanejoAgir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxPlanejoAgir.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sim", "Não", "Não sei" }));
        jComboBoxPlanejoAgir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxPlanejoAgir.setEnabled(false);

        jComboBoxConcentroTrabalho.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxConcentroTrabalho.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sim", "Não", "Não sei" }));
        jComboBoxConcentroTrabalho.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxConcentroTrabalho.setEnabled(false);

        jComboBoxIdentificoProblemas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxIdentificoProblemas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sim", "Não", "Não sei" }));
        jComboBoxIdentificoProblemas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxIdentificoProblemas.setEnabled(false);

        jComboBoxIdentificoSolucaoProblemas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxIdentificoSolucaoProblemas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sim", "Não", "Não sei" }));
        jComboBoxIdentificoSolucaoProblemas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxIdentificoSolucaoProblemas.setEnabled(false);

        jComboBoxQuandoAgir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxQuandoAgir.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sim", "Não", "Não sei" }));
        jComboBoxQuandoAgir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxQuandoAgir.setEnabled(false);

        jComboBoxConsigoCotidianas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxConsigoCotidianas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sim", "Não", "Não sei" }));
        jComboBoxConsigoCotidianas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxConsigoCotidianas.setEnabled(false);

        jComboBoxConsigoHigiene.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxConsigoHigiene.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sim", "Não", "Não sei" }));
        jComboBoxConsigoHigiene.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxConsigoHigiene.setEnabled(false);

        jComboBoxConsigoFinancas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxConsigoFinancas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sim", "Não", "Não sei" }));
        jComboBoxConsigoFinancas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxConsigoFinancas.setEnabled(false);

        jComboBoxConsigoCasa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxConsigoCasa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sim", "Não", "Não sei" }));
        jComboBoxConsigoCasa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxConsigoCasa.setEnabled(false);

        jComboBoxSintoPreciso.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxSintoPreciso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sim", "Não", "Não sei" }));
        jComboBoxSintoPreciso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxSintoPreciso.setEnabled(false);

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel43, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel47, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel54, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel52, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel51, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jComboBoxPlanejoAgir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBoxIdentificoProblemas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jComboBoxConsigoFinancas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxQuandoAgir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxConsigoOutros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxConsigoCasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel53, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel49, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel50, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel48, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel46, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel44, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxSintoPreciso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxConsigoCotidianas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxConsigoHigiene, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxIdentificoSolucaoProblemas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxConcentroTrabalho, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTenhoSocial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel43)
                    .addComponent(jComboBoxConsigoOutros, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44)
                    .addComponent(jComboBoxTenhoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel45)
                    .addComponent(jComboBoxPlanejoAgir, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46)
                    .addComponent(jComboBoxConcentroTrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel47)
                    .addComponent(jComboBoxIdentificoProblemas, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48)
                    .addComponent(jComboBoxIdentificoSolucaoProblemas, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel54)
                    .addComponent(jComboBoxQuandoAgir, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel50)
                    .addComponent(jComboBoxConsigoHigiene, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel49)
                    .addComponent(jComboBoxConsigoCotidianas, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel52)
                    .addComponent(jComboBoxConsigoCasa, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel51)
                    .addComponent(jComboBoxConsigoFinancas, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53)
                    .addComponent(jComboBoxSintoPreciso, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel28.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Meio Ambiente: recursos ambientais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel55.setText("Costumo freq. ambientes favoráveis para mim?");

        jComboBoxCostumoFrequentar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxCostumoFrequentar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sim", "Não", "Não sei" }));
        jComboBoxCostumoFrequentar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxCostumoFrequentar.setEnabled(false);

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel56.setText("Dt. Aplicação:");

        jDataAplicacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataAplicacao.setEnabled(false);

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel55)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxCostumoFrequentar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jLabel56)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDataAplicacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxCostumoFrequentar, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel55)
                    .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jDataAplicacao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel56)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel29.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 0, 0));
        jLabel57.setText("Responsável pela Aplicação da Avaliação");

        jResponsavelAplicacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jResponsavelAplicacao.setEnabled(false);

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addComponent(jLabel57)
                        .addGap(0, 319, Short.MAX_VALUE))
                    .addComponent(jResponsavelAplicacao, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel57)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jResponsavelAplicacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        jPanel25.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jBtNovoAvaliacaoII.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoAvaliacaoII.setToolTipText("Novo");
        jBtNovoAvaliacaoII.setContentAreaFilled(false);
        jBtNovoAvaliacaoII.setEnabled(false);
        jBtNovoAvaliacaoII.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovoAvaliacaoII.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovoAvaliacaoII.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovoAvaliacaoII.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoAvaliacaoIIActionPerformed(evt);
            }
        });

        jBtAlterarAvaliacaoII.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarAvaliacaoII.setToolTipText("Alterar");
        jBtAlterarAvaliacaoII.setContentAreaFilled(false);
        jBtAlterarAvaliacaoII.setEnabled(false);
        jBtAlterarAvaliacaoII.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterarAvaliacaoII.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarAvaliacaoII.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarAvaliacaoII.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarAvaliacaoIIActionPerformed(evt);
            }
        });

        jBtExcluirAvaliacaoII.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirAvaliacaoII.setToolTipText("Excluir");
        jBtExcluirAvaliacaoII.setContentAreaFilled(false);
        jBtExcluirAvaliacaoII.setEnabled(false);
        jBtExcluirAvaliacaoII.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluirAvaliacaoII.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirAvaliacaoII.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirAvaliacaoII.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirAvaliacaoIIActionPerformed(evt);
            }
        });

        jBtSalvarAvaliacaoII.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarAvaliacaoII.setToolTipText("Gravar");
        jBtSalvarAvaliacaoII.setContentAreaFilled(false);
        jBtSalvarAvaliacaoII.setEnabled(false);
        jBtSalvarAvaliacaoII.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvarAvaliacaoII.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarAvaliacaoII.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarAvaliacaoII.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarAvaliacaoIIActionPerformed(evt);
            }
        });

        jBtCancelarAvaliacaoII.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarAvaliacaoII.setToolTipText("Cancelar");
        jBtCancelarAvaliacaoII.setContentAreaFilled(false);
        jBtCancelarAvaliacaoII.setEnabled(false);
        jBtCancelarAvaliacaoII.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelarAvaliacaoII.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarAvaliacaoII.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarAvaliacaoII.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarAvaliacaoIIActionPerformed(evt);
            }
        });

        jBtSairAvaliacaoII.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSairAvaliacaoII.setToolTipText("Sair");
        jBtSairAvaliacaoII.setContentAreaFilled(false);
        jBtSairAvaliacaoII.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSairAvaliacaoII.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSairAvaliacaoII.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSairAvaliacaoII.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairAvaliacaoIIActionPerformed(evt);
            }
        });

        jBtAuditoriaAvaliacaoII.setForeground(new java.awt.Color(0, 0, 255));
        jBtAuditoriaAvaliacaoII.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaAvaliacaoII.setToolTipText("Auditoria");
        jBtAuditoriaAvaliacaoII.setContentAreaFilled(false);
        jBtAuditoriaAvaliacaoII.setEnabled(false);
        jBtAuditoriaAvaliacaoII.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAuditoriaAvaliacaoII.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAuditoriaAvaliacaoII.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAuditoriaAvaliacaoII.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaAvaliacaoIIActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtNovoAvaliacaoII, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jBtAlterarAvaliacaoII, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jBtExcluirAvaliacaoII, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jBtSalvarAvaliacaoII, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jBtCancelarAvaliacaoII, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(146, 146, 146)
                .addComponent(jBtSairAvaliacaoII, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaAvaliacaoII, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel25Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterarAvaliacaoII, jBtCancelarAvaliacaoII, jBtExcluirAvaliacaoII, jBtNovoAvaliacaoII, jBtSairAvaliacaoII, jBtSalvarAvaliacaoII});

        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtNovoAvaliacaoII)
                    .addComponent(jBtAlterarAvaliacaoII)
                    .addComponent(jBtExcluirAvaliacaoII)
                    .addComponent(jBtSalvarAvaliacaoII)
                    .addComponent(jBtCancelarAvaliacaoII)
                    .addComponent(jBtSairAvaliacaoII)
                    .addComponent(jBtAuditoriaAvaliacaoII))
                .addGap(4, 4, 4))
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel15Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel24, jPanel25, jPanel27, jPanel28, jPanel29});

        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("SAOF II", jPanel15);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtTodos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtTodos1ActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (jIDPesqLanc.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um ID para pesquisar.");
        } else {
            preencherAtendimentoTerapia("SELECT * FROM ADMISSAO_TERAPIA_PE "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ADMISSAO_TERAPIA_PE.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE IdATN='" + jIDPesqLanc.getText() + "'");
        }
    }//GEN-LAST:event_jBtTodos1ActionPerformed

    private void jBtPesqDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqDataActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (tipoServidor == null || tipoServidor.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "É necessário definir o parâmtero para o sistema operacional utilizado no servidor, (UBUNTU-LINUX ou WINDOWS SERVER).");
        } else if (tipoServidor.equals("Servidor Linux (Ubuntu)/MS-SQL Server")) {
            if (jDataPesqInicial.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data inicial para pesquisa.");
                jDataPesqInicial.requestFocus();
            } else {
                if (jDataPesqFinal.getDate() == null) {
                    JOptionPane.showMessageDialog(rootPane, "Informe a data final para pesquisa.");
                    jDataPesqFinal.requestFocus();
                } else {
                    if (jDataPesqInicial.getDate().after(jDataPesqFinal.getDate())) {
                        JOptionPane.showMessageDialog(rootPane, "Data Inicial não pode ser maior que data final");
                    } else {
                        SimpleDateFormat formatoAmerica = new SimpleDateFormat("yyyy/MM/dd");
                        dataInicial = formatoAmerica.format(jDataPesqInicial.getDate().getTime());
                        dataFinal = formatoAmerica.format(jDataPesqFinal.getDate().getTime());
                        preencherAtendimentoTerapia("SELECT * FROM ADMISSAO_TERAPIA_PE "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON ADMISSAO_TERAPIA_PE.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                + "WHERE DataLanc BETWEEN'" + dataInicial + "' "
                                + "AND'" + dataFinal + "' "
                                + "AND ADMISSAO_TERAPIA_PE.IdLanc='" + jIdAtend.getText() + "' "
                                + "ADMISSAO_TERAPIA_PE.IdInternoCrc='" + jIdInterno.getText() + "'");
                    }
                }
            }
        } else if (tipoServidor.equals("Servidor Windows/MS-SQL Server")) {
            if (jDataPesqInicial.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data inicial para pesquisa.");
                jDataPesqInicial.requestFocus();
            } else {
                if (jDataPesqFinal.getDate() == null) {
                    JOptionPane.showMessageDialog(rootPane, "Informe a data final para pesquisa.");
                    jDataPesqFinal.requestFocus();
                } else {
                    if (jDataPesqInicial.getDate().after(jDataPesqFinal.getDate())) {
                        JOptionPane.showMessageDialog(rootPane, "Data Inicial não pode ser maior que data final");
                    } else {
                        SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
                        dataInicial = formatoAmerica.format(jDataPesqInicial.getDate().getTime());
                        dataFinal = formatoAmerica.format(jDataPesqFinal.getDate().getTime());
                        preencherAtendimentoTerapia("SELECT * FROM ADMISSAO_TERAPIA_PE "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON ADMISSAO_TERAPIA_PE.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                + "WHERE DataLanc BETWEEN'" + dataInicial + "' "
                                + "AND'" + dataFinal + "' "
                                + "AND ADMISSAO_TERAPIA_PE.IdLanc='" + jIdAtend.getText() + "' "
                                + "ADMISSAO_TERAPIA_PE.IdInternoCrc='" + jIdInterno.getText() + "'");
                    }
                }
            }
        }
    }//GEN-LAST:event_jBtPesqDataActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherAtendimentoTerapia("SELECT * FROM ADMISSAO_TERAPIA_PE "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ADMISSAO_TERAPIA_PE.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE ADMISSAO_TERAPIA_PE.IdLanc='" + jIdAtend.getText() + "' "
                    + "AND ADMISSAO_TERAPIA_PE.IdInternoCrc='" + jIdInterno.getText() + "'");
        } else {
            jtotalRegistros.setText("");
            limparTabela();
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jBtPesquisaNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisaNomeActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (jnomeInternoPesq.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o nome do interno para pesquisar.");
        } else {
            jTabelaAtendimentoTerapia.setVisible(true);
            preencherAtendimentoTerapia("SELECT * FROM ADMISSAO_TERAPIA_PE "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ADMISSAO_TERAPIA_PE.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE PRONTUARIOSCRC.NomeInternoCrc LIKE'%" + jnomeInternoPesq.getText() + "%' "
                    + "AND ADMISSAO_TERAPIA_PE.IdLanc='" + jIdAtend.getText() + "'");
        }
    }//GEN-LAST:event_jBtPesquisaNomeActionPerformed

    private void jTabelaAtendimentoTerapiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaAtendimentoTerapiaMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            String idAtend = "" + jTabelaAtendimentoTerapia.getValueAt(jTabelaAtendimentoTerapia.getSelectedRow(), 0);
            jIDPesqLanc.setText(idAtend);
            //jDataRol.setDate(jDataRol.getDate());
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            //
            jBtNovoHistoricoEduca.setEnabled(true);
            //
            jBtNovoHistoricoLabor.setEnabled(true);
            //
            jBtNovoAvaliacaoI.setEnabled(true);
            //
            jBtNovoAvaliacaoII.setEnabled(true);
            //
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ADMISSAO_TERAPIA_PE "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=ADMISSAO_TERAPIA_PE.IdInternoCrc "
                        + "WHERE IdATN='" + idAtend + "'");
                conecta.rs.first();
                jIdADM_Principal.setText(String.valueOf(conecta.rs.getInt("IdLanc")));
                jIdAtendNovo.setText(String.valueOf(conecta.rs.getInt("IdATN")));
                jDataLanc.setDate(conecta.rs.getDate("DataLanc"));
                jStatusLanc.setText(conecta.rs.getString("StatusLanc"));
                jIdInternoAD.setText(conecta.rs.getString("IdInternoCrc"));
                jNomeInternoAD.setText(conecta.rs.getString("NomeInternoCrc"));
                // Capturando foto
                caminho = conecta.rs.getString("FotoInternoCrc");
                if (caminho != null) {
                    javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                    jFotoInternoTerapia.setIcon(i);
                    jFotoInternoTerapia.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoInternoTerapia.getWidth(), jFotoInternoTerapia.getHeight(), Image.SCALE_SMOOTH)));
                }
                // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrente"));
                if (imgBytes != null) {
                    ImageIcon pic = null;
                    pic = new ImageIcon(imgBytes);
                    Image scaled = pic.getImage().getScaledInstance(jFotoInternoTerapia.getWidth(), jFotoInternoTerapia.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon icon = new ImageIcon(scaled);
                    jFotoInternoTerapia.setIcon(icon);
                }
                // HISTÓRICO FAMILIAR
                jComboBoxPaisVivos.setSelectedItem(conecta.rs.getString("PaisVivos"));
                jComboBoxTemCompanheira.setSelectedItem(conecta.rs.getString("TemCompanheira"));
                jComboBoxTemFilhos.setSelectedItem(conecta.rs.getString("TemFilhos"));
                jQuantosFilhos.setText(conecta.rs.getString("QuantosFilhos"));
                jComboBoxVisitaFamiliar.setSelectedItem(conecta.rs.getString("VisitaFamiliar"));
                SFSeg = conecta.rs.getInt("SFseg");
                if (SFSeg == 0) {
                    jCheckBoxSFSeg.setSelected(true);
                } else if (SFSeg == 1) {
                    jCheckBoxSFSeg.setSelected(!true);
                }
                SFTer = conecta.rs.getInt("SFTer");
                if (SFTer == 0) {
                    jCheckBoxSFTer.setSelected(true);
                } else if (SFTer == 1) {
                    jCheckBoxSFTer.setSelected(!true);
                }
                SFQua = conecta.rs.getInt("SFQua");
                if (SFQua == 0) {
                    jCheckBoxSFQua.setSelected(true);
                } else if (SFQua == 1) {
                    jCheckBoxSFQua.setSelected(!true);
                }
                SFQui = conecta.rs.getInt("SFQui");
                if (SFQui == 0) {
                    jCheckBoxSFQui.setSelected(true);
                } else if (SFQui == 1) {
                    jCheckBoxSFQui.setSelected(!true);
                }
                SFSex = conecta.rs.getInt("SFSex");
                if (SFSex == 0) {
                    jCheckBoxSFSex.setSelected(true);
                } else if (SFSex == 1) {
                    jCheckBoxSFSex.setSelected(!true);
                }
                SFSab = conecta.rs.getInt("SFSab");
                if (SFSab == 0) {
                    jCheckBoxSFSab.setSelected(true);
                } else if (SFSab == 1) {
                    jCheckBoxSFSab.setSelected(!true);
                }
                SFDom = conecta.rs.getInt("SFDom");
                if (SFDom == 0) {
                    jCheckBoxSFDom.setSelected(true);
                } else if (SFDom == 1) {
                    jCheckBoxSFDom.setSelected(!true);
                }
                jComboBoxVisitaIntima.setSelectedItem(conecta.rs.getString("VisitaIntima"));
                IntSeg = conecta.rs.getInt("IntSeg");
                if (IntSeg == 0) {
                    jCheckBoxIntSeg.setSelected(true);
                } else if (IntSeg == 1) {
                    jCheckBoxIntSeg.setSelected(!true);
                }
                IntTer = conecta.rs.getInt("IntTer");
                if (IntTer == 0) {
                    jCheckBoxIntTer.setSelected(true);
                } else if (IntTer == 1) {
                    jCheckBoxIntTer.setSelected(!true);
                }
                IntQua = conecta.rs.getInt("IntQua");
                if (IntQua == 0) {
                    jCheckBoxIntQua.setSelected(true);
                } else if (IntQua == 1) {
                    jCheckBoxIntQua.setSelected(!true);
                }
                IntQui = conecta.rs.getInt("IntQui");
                if (IntQui == 0) {
                    jCheckBoxIntQui.setSelected(true);
                } else if (IntQui == 1) {
                    jCheckBoxIntQui.setSelected(!true);
                }
                IntSex = conecta.rs.getInt("IntSex");
                if (IntSex == 0) {
                    jCheckBoxIntSex.setSelected(true);
                } else if (IntSex == 1) {
                    jCheckBoxIntSex.setSelected(!true);
                }
                IntSab = conecta.rs.getInt("IntSab");
                if (IntSab == 0) {
                    jCheckBoxIntSab.setSelected(true);
                } else if (IntSab == 1) {
                    jCheckBoxIntSab.setSelected(!true);
                }
                IntDom = conecta.rs.getInt("IntDom");
                if (IntDom == 0) {
                    jCheckBoxIntDom.setSelected(true);
                } else if (IntDom == 1) {
                    jCheckBoxIntDom.setSelected(!true);
                }
                jObsHistoricoFamiliar.setText(conecta.rs.getString("ObsHistoricoFamiliar"));
                // DADOS CLINICOS
                jComboBoxHipertensao.setSelectedItem(conecta.rs.getString("Hipertensao"));
                jComboBoxDiabetes.setSelectedItem(conecta.rs.getString("Diabetes"));
                jComboBoxCancer.setSelectedItem(conecta.rs.getString("Cancer"));
                jComboBoxProRespiratorio.setSelectedItem(conecta.rs.getString("ProRespiratorio"));
                jComboBoxTransMental.setSelectedItem(conecta.rs.getString("TransMental"));
                jComboBoxInfectocontagiosa.setSelectedItem(conecta.rs.getString("Infectocontagiosa"));
                jComboBoxDoencasDigestivo.setSelectedItem(conecta.rs.getString("DoencasDigestiva"));
                jComboBoxDeficienciaVAF.setSelectedItem(conecta.rs.getString("DeficienciaVAF"));
                ObsDadosClinicos.setText(conecta.rs.getString("ObsDadosClinicos"));
                //ALTERAÇÕES PSICOLOGICAS
                jComboBoxHumor.setSelectedItem(conecta.rs.getString("Humor"));
                jComboBoxInsonia.setSelectedItem(conecta.rs.getString("Insonia"));
                jComboBoxIrritabilidade.setSelectedItem(conecta.rs.getString("Irritabilidade"));
                jComboBoxFrustracao.setSelectedItem(conecta.rs.getString("Frustracao"));
                jComboBoxDificultadeConcentrar.setSelectedItem(conecta.rs.getString("DificuldadeConcentrar"));
                jComboBoxRaiva.setSelectedItem(conecta.rs.getString("Raiva"));
                jComboBoxInquietacao.setSelectedItem(conecta.rs.getString("Inquietacao"));
                jComboBoxAnsiedade.setSelectedItem(conecta.rs.getString("Ansiedade"));
                ObsAlteracoesPsicologicas.setText(conecta.rs.getString("ObsAlteracoesPsicologicas"));
                // DESEMPENHO OCUPACIONAL
                jComboBoxDominancia.setSelectedItem(conecta.rs.getString("Dominancia"));
                jComboBoxAmputacao.setSelectedItem(conecta.rs.getString("Amputacao"));
                jComboBoxDeficienciaOcupa.setSelectedItem(conecta.rs.getString("DeficienciaOcupa"));
                jComboBoxReabilitacao.setSelectedItem(conecta.rs.getString("Reabilitacao"));
                jComboBoxMotora.setSelectedItem(conecta.rs.getString("Motora"));
                jComboBoxCognitiva.setSelectedItem(conecta.rs.getString("Cognitiva"));
                jComboBoxSensorial.setSelectedItem(conecta.rs.getString("Sensorial"));
                jComboBoxIntPsi.setSelectedItem(conecta.rs.getString("IntPsi"));
                jComboBoxAVD.setSelectedItem(conecta.rs.getString("AVD"));
                jComboBoxAIVD.setSelectedItem(conecta.rs.getString("AIVD"));
                jComboBoxLazer.setSelectedItem(conecta.rs.getString("Lazer"));
                jComboBoxTrabalho.setSelectedItem(conecta.rs.getString("Trabalho"));
                jObsDesempenhoOcupacional.setText(conecta.rs.getString("ObsDesempenhoOcupacional"));
                // QUALIDADE DE VIDA (TRIAGEM SPA)
                jComboBoxTabagismo.setSelectedItem(conecta.rs.getString("Tabagismo"));
                jQuantoTabagismo.setText(conecta.rs.getString("QuantoTabagismo"));
                jComboBoxTabagismoUsuario.setSelectedItem(conecta.rs.getString("TabagismoUsuario"));
                jComboBoxEtilismo.setSelectedItem(conecta.rs.getString("Etilismo"));
                jTipoEtilismo.setText(conecta.rs.getString("TipoEtilismo"));
                jComboBoxEtilismoUsuario.setSelectedItem(conecta.rs.getString("EtilismoUsuario"));
                jComboBoxMedicaoAlopatica.setSelectedItem(conecta.rs.getString("MedicacaoAlopatica"));
                jTipoMedicaoAlopatica.setText(conecta.rs.getString("TipoMedicacaoAlopatica"));
                jComboBoxMedicaoAlopaticaUsuario.setSelectedItem(conecta.rs.getString("MedicacaoAlopaticaUsuario"));
                jComboBoxSPA.setSelectedItem(conecta.rs.getString("SPA"));
                jTipoSPA.setText(conecta.rs.getString("TipoSPA"));
                jComboBoxSPAUsuario.setSelectedItem(conecta.rs.getString("SPAUsuario"));
                jObsTriagemSPA.setText(conecta.rs.getString("ObsTriagemSPA"));
                // QUALIDADE DE VIDA (ESTILO DE VIDA)
                jComboBoxVidaSexual.setSelectedItem(conecta.rs.getString("VidaSexual"));
                jComboBoxMetodoContraCeptivo.setSelectedItem(conecta.rs.getString("MetodoContraCeptivo"));
                jQualMetodoContraCeptivo.setText(conecta.rs.getString("QualMetodoContraCeptivo"));
                jComboBoxGestante.setSelectedItem(conecta.rs.getString("Gestante"));
                jComboBoxAborto.setSelectedItem(conecta.rs.getString("Aborto"));
                jMotivoAborto.setText(conecta.rs.getString("MotivoAborto"));
                jComboBoxPraticaAtividadeFisica.setSelectedItem(conecta.rs.getString("PraticaAtividadeFisica"));
                jQualAtividadeFisica.setText(conecta.rs.getString("QualAtividadeFisica"));
                jComboBoxTrataPsicologico.setSelectedItem(conecta.rs.getString("TrataPsicologico"));
                jObsEstiloVida.setText(conecta.rs.getString("ObsEstiloVida"));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "Não existe dados a ser exibido." + e);
            }
            // HISTÓRICO EDUCACIONAL
            limparTabelaCursos();
            try {
                conecta.executaSQL("SELECT * FROM TO_HISTORICO_EDUCACIONAL_NOVO "
                        + "INNER JOIN ADMISSAO_TERAPIA_PE "
                        + "ON TO_HISTORICO_EDUCACIONAL_NOVO.IdATN=ADMISSAO_TERAPIA_PE.IdATN "
                        + "WHERE TO_HISTORICO_EDUCACIONAL_NOVO.IdATN='" + idAtend + "'");
                conecta.rs.first();
                codigoHistoricoEduca = conecta.rs.getInt("IdHistoricoEduN");
                jComboBoxEscreveProprioNome.setSelectedItem(conecta.rs.getString("EscreveProprioNome"));
                jComboBoxSabeLerEscrever.setSelectedItem(conecta.rs.getString("SabeLerEscrever"));
                jComboBoxNivelInstrucao.setSelectedItem(conecta.rs.getString("NivelInstrucao"));
                jComboBoxInteresseEstudar.setSelectedItem(conecta.rs.getString("InteresseEstudar"));
                jComboBoxCursoProfissionalizante.setSelectedItem(conecta.rs.getString("CursoProfissionalizante"));
            } catch (Exception e) {
            }
            // TABELA DE CURSOS PROFISSIONALIZANTES
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ITENS_CURSOS_TO_HISTORICO_EDUCACIONAL_NOVO "
                        + "INNER JOIN CURSOS "
                        + "ON ITENS_CURSOS_TO_HISTORICO_EDUCACIONAL_NOVO.IdCurso=CURSOS.IdCurso "
                        + "WHERE ITENS_CURSOS_TO_HISTORICO_EDUCACIONAL_NOVO.IdATN='" + idAtend + "'");
                conecta.rs.first();
                idItem = conecta.rs.getInt("IdItemICTHEN");
                DefaultTableModel dtmCursos = (DefaultTableModel) jTabelaCursos_NOVO.getModel();
                dtmCursos.getDataVector().clear(); // limpa a tabela
                do {
                    prioridadeCursoTabela = conecta.rs.getInt("PrioridadeCurso");
                    if (prioridadeCursoTabela == 0) {
                        prioridadeLetraCurso = "A";
                    } else if (prioridadeCursoTabela == 1) {
                        prioridadeLetraCurso = "B";
                    } else if (prioridadeCursoTabela == 2) {
                        prioridadeLetraCurso = "C";
                    }
                    dtmCursos.addRow(new Object[]{conecta.rs.getInt("IdCurso"), conecta.rs.getString("DescricaoCurso"), prioridadeLetraCurso});
                } while (conecta.rs.next());
            } catch (SQLException ex) {
            }
            if (codigoHistoricoEduca != 0) {
                jBtNovoHistoricoEduca.setEnabled(true);
                jBtAlterarHistoricoEduca.setEnabled(true);
                jBtExcluirHistoricoEduca.setEnabled(true);
                jBtSalvarHistoricoEduca.setEnabled(!true);
                jBtCancelarHistoricoEduca.setEnabled(true);
                jBtAuditoriaHistoricoEduca.setEnabled(true);
            }
            // HISTORICO PROFISSIONAL
            limparTabelaExperiencia();
            jComboBoxQualProfissao.removeAllItems();
            try {
                conecta.executaSQL("SELECT * FROM TO_HISTORICO_PROFISSIONAL_NOVO "
                        + "INNER JOIN ADMISSAO_TERAPIA_PE "
                        + "ON TO_HISTORICO_PROFISSIONAL_NOVO.IdATN=ADMISSAO_TERAPIA_PE.IdATN "
                        + "WHERE TO_HISTORICO_PROFISSIONAL_NOVO.IdATN='" + idAtend + "'");
                conecta.rs.first();
                codigoHistoricoProf = conecta.rs.getInt("IdHistoricoLabPN");
                jComboBoxTemProfissao.setSelectedItem(conecta.rs.getString("TemProfissao"));
                jComboBoxQualProfissao.addItem(conecta.rs.getString("QualProfissao"));
                jComboBoxExperienciaProfissional.setSelectedItem(conecta.rs.getString("ExperienciaProfissional"));
                jComboBoxDesejaTrabalharUnid.setSelectedItem(conecta.rs.getString("DesejaTrabalharUnid"));
                opcaoRemueracao = conecta.rs.getInt("InteresseLabor");
                if (opcaoRemueracao == 0) {
                    jRadioBtRemunerado.setSelected(true);
                } else if (opcaoRemueracao == 1) {
                    jRadioBtNaoRemunerado.setSelected(true);
                } else if (opcaoRemueracao == 2) {
                    jRadioBtAmbos.setSelected(true);
                }
            } catch (Exception e) {
            }
            // TABELA DE CURSOS PROFISSIONALIZANTES
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ITENS_PROFISSAO_TO_HISTORICO_PROFISSIONAL_NOVO "
                        + "INNER JOIN PROFISSAO "
                        + "ON ITENS_PROFISSAO_TO_HISTORICO_PROFISSIONAL_NOVO.IdCodigoProf=PROFISSAO.IdCodigoProf "
                        + "WHERE ITENS_PROFISSAO_TO_HISTORICO_PROFISSIONAL_NOVO.IdATN='" + idAtend + "'");
                conecta.rs.first();
                idItemProf = conecta.rs.getInt("IdItemPTHPN");
                DefaultTableModel dtmProf = (DefaultTableModel) jTabelaExperiencia.getModel();
                dtmProf.getDataVector().clear(); // limpa a tabela
                do {
                    dtmProf.addRow(new Object[]{conecta.rs.getInt("IdCodigoProf"), conecta.rs.getString("DescricaoProf"), tipoRemuneracao});
                } while (conecta.rs.next());
            } catch (SQLException ex) {
            }
            if (codigoHistoricoProf != 0) {
                jBtNovoHistoricoLabor.setEnabled(true);
                jBtAlterarHistoricoLabor.setEnabled(true);
                jBtExcluirHistoricoLabor.setEnabled(true);
                jBtSalvarHistoricoLabor.setEnabled(!true);
                jBtCancelarHistoricoLabor.setEnabled(true);
                jBtAuditoriaHistoricoLabor.setEnabled(true);
            }
            // AVALIAÇÃO I
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM AVALIACAO_TO_I "
                        + "INNER JOIN ADMISSAO_TERAPIA_PE "
                        + "ON AVALIACAO_TO_I.IdATN=ADMISSAO_TERAPIA_PE.IdATN "
                        + "WHERE AVALIACAO_TO_I.IdATN='" + jIdAtendNovo.getText() + "'");
                conecta.rs.first();
                codigoAvaliacaoI = conecta.rs.getInt("IdAvaliaTOI");
                jComboBoxConhecoHabilidades.setSelectedItem(conecta.rs.getString("ConhecoHabilidades"));
                jComboBoxAcreditaRealizacoes.setSelectedItem(conecta.rs.getString("AcreditaRealizacoes"));
                jComboBoxEsperoResultados.setSelectedItem(conecta.rs.getString("EsperoResultados"));
                jComboBoxAcreditoRealizaTrabalho.setSelectedItem(conecta.rs.getString("AcreditoRealizaTrabalho"));
                jComboBoxAcreditoRealizaLar.setSelectedItem(conecta.rs.getString("AcreditoRealizaLar"));
                jComboBoxAcreditoDiverteLazer.setSelectedItem(conecta.rs.getString("AcreditoDiverteLazer"));
                jComboBoxFacoAtividades.setSelectedItem(conecta.rs.getString("FacoAtividades"));
                jComboBoxTenhoExpectativa.setSelectedItem(conecta.rs.getString("TenhoExpectativa"));
                jComboBoxTenhoObjetoFuturo.setSelectedItem(conecta.rs.getString("TenhoObjetoFuturo"));
                jComboBoxIdentificoGostos.setSelectedItem(conecta.rs.getString("IdentificoGostos"));
                jComboBoxParticipoProjetosImport.setSelectedItem(conecta.rs.getString("ParticipoProjetosImport"));
                jComboBoxTenhoVariosInteresse.setSelectedItem(conecta.rs.getString("TenhoVariosInteresse"));
                jComboBoxCostumoComprometo.setSelectedItem(conecta.rs.getString("CostumoComprometo"));
                jComboBoxDeEstudante.setSelectedItem(conecta.rs.getString("DeEstudante"));
                jComboBoxDeTrabalho.setSelectedItem(conecta.rs.getString("DeTrabalho"));
                jComboBoxDeAmigo.setSelectedItem(conecta.rs.getString("DeAmigo"));
                jComboBoxDeFamiliar.setSelectedItem(conecta.rs.getString("DeFamiliar"));
                jComboBoxReconhecoPapeis.setSelectedItem(conecta.rs.getString("ReconhecoPapeis"));
                jComboBoxMantenhoVida.setSelectedItem(conecta.rs.getString("MantenhoVida"));
                if (codigoAvaliacaoI != 0) {
                    jBtNovoAvaliacaoI.setEnabled(true);
                    jBtAlterarAvaliacaoI.setEnabled(true);
                    jBtExcluirAvaliacaoI.setEnabled(true);
                    jBtSalvarAvaliacaoI.setEnabled(!true);
                    jBtCancelarAvaliacaoI.setEnabled(!true);
                    jBtAuditoriaAvaliacaoI.setEnabled(true);
                }
            } catch (Exception e) {
            }
            // AVALIAÇÃO II
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM AVALIACAO_TO_II "
                        + "INNER JOIN ADMISSAO_TERAPIA_PE "
                        + "ON AVALIACAO_TO_II.IdATN=ADMISSAO_TERAPIA_PE.IdATN "
                        + "WHERE AVALIACAO_TO_II.IdATN='" + jIdAtendNovo.getText() + "'");
                conecta.rs.first();
                codigoAvaliacaoII = conecta.rs.getInt("IdAvaliaTOII");
                jComboBoxOrganizoTempo.setSelectedItem(conecta.rs.getString("OrganizoTempo"));
                jComboBoxMantenhoPapeis.setSelectedItem(conecta.rs.getString("MantenhoPapeis"));
                jComboBoxSouRotina.setSelectedItem(conecta.rs.getString("SouRotina"));
                jComboBoxConsigoOutros.setSelectedItem(conecta.rs.getString("ConsigoOutros"));
                jComboBoxTenhoSocial.setSelectedItem(conecta.rs.getString("TenhoSocial"));
                jComboBoxPlanejoAgir.setSelectedItem(conecta.rs.getString("PlanejoAgir"));
                jComboBoxConcentroTrabalho.setSelectedItem(conecta.rs.getString("ConcentroTrabalho"));
                jComboBoxIdentificoProblemas.setSelectedItem(conecta.rs.getString("IdentificoProblemas"));
                jComboBoxIdentificoSolucaoProblemas.setSelectedItem(conecta.rs.getString("IdentificoSolucaoProblemas"));
                jComboBoxQuandoAgir.setSelectedItem(conecta.rs.getString("QuandoAgir"));
                jComboBoxConsigoHigiene.setSelectedItem(conecta.rs.getString("ConsigoHigiene"));
                jComboBoxConsigoCasa.setSelectedItem(conecta.rs.getString("ConsigoCasa"));
                jComboBoxConsigoCotidianas.setSelectedItem(conecta.rs.getString("ConsigoCotidianas"));
                jComboBoxConsigoFinancas.setSelectedItem(conecta.rs.getString("ConsigoFinancas"));
                jComboBoxSintoPreciso.setSelectedItem(conecta.rs.getString("SintoPreciso"));
                jComboBoxCostumoFrequentar.setSelectedItem(conecta.rs.getString("CostumoFrequentar"));
                jDataAplicacao.setDate(conecta.rs.getDate("DataAplicacao"));
                jResponsavelAplicacao.setText(conecta.rs.getString("ResponsavelAplicacao"));
                if (codigoAvaliacaoII != 0) {
                    jBtNovoAvaliacaoII.setEnabled(true);
                    jBtAlterarAvaliacaoII.setEnabled(true);
                    jBtExcluirAvaliacaoII.setEnabled(true);
                    jBtSalvarAvaliacaoII.setEnabled(!true);
                    jBtCancelarAvaliacaoII.setEnabled(!true);
                    jBtAuditoriaAvaliacaoII.setEnabled(true);
                }
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_jTabelaAtendimentoTerapiaMouseClicked

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtendimentoInternoManuTO);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTO.equals("ADMINISTRADORES") || codigoUserTO == codUserAcessoTO && nomeTelaTO.equals(telaAtendimentoInternoManuTO) && codIncluirTO == 1) {
            verificarPortaEntrada();
            verificarRegistroBiometria();
            if (jIdInterno.getText().equals(pINTERNOCRC) && deptoTecnico.equals(pDEPARTAMENTO) && pHABILITADO.equals("Sim")) {
                if (pHabilitaTO.equals("Não")) {
                    bloquearCampos();
                    Novo();
                    statusMov = "Incluiu";
                    horaMov = jHoraSistema.getText();
                    dataModFinal = jDataSistema.getText();
                    limparTabelaCursos();
                    limparTabelaExperiencia();
                    acao = 1;
                    pesquisarInternoManual();
                } else {
                    bloquearCampos();
                    limparTabelaCursos();
                    limparTabelaExperiencia();
                    Novo();
                    //PESQUISAR CÓDIGO DO DEPARTAMENTO PARA CONTABILIZAR O ATENDIMENTO NA TABELA REGISTRO_ATENDIMENTO_INTERNO_PSP
                    procurarDepartamento();
                    //PESQUISAR O INTERNO NO QUAL FEZ A ASSINATURA BIOMETRICA OU FOI LIBERADO PELO COLABORADOR
                    pesquisarInternoColaboradorBiometria();
                    if (jIdInternoAD.getText().equals("")) {
                        JOptionPane.showMessageDialog(rootPane, "Não é possível realizar o atendimento, esse interno não assinou pela biometria ou não foi liberado para ser atendido.");
                    } else {
                        acao = 1;
                        statusMov = "Incluiu";
                        horaMov = jHoraSistema.getText();
                        dataModFinal = jDataSistema.getText();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Já existe uma admissão para esse interno, por isso não é possível fazer uma nova admissão.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtendimentoInternoManuTO);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTO.equals("ADMINISTRADORES") || codigoUserTO == codUserAcessoTO && nomeTelaTO.equals(telaAtendimentoInternoManuTO) && codAlterarTO == 1) {
            acao = 2;
            bloquearCampos();
            Alterar();
            corCampos();
            statusMov = "Alterou";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtAlterarActionPerformed

    private void jBtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtendimentoInternoManuTO);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTO.equals("ADMINISTRADORES") || codigoUserTO == codUserAcessoTO && nomeTelaTO.equals(telaAtendimentoInternoManuTO) && codExcluirTO == 1) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            objAtend.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse atendimento não poderá ser excluido, o mesmo encontra-se FINALIZADO");
            } else {
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o ATENDIMENTO selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    objAtend.setIdATN(Integer.parseInt(jIdAtendNovo.getText()));
                    control.excluirAtendTerapia(objAtend);
                    objAtend.setIdLanc(Integer.parseInt(jIdAtendNovo.getText()));
                    controle.excluirMovTec(objAtend);
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                    Excluir();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtendimentoInternoManuTO);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTO.equals("ADMINISTRADORES") || codigoUserTO == codUserAcessoTO && nomeTelaTO.equals(telaAtendimentoInternoManuTO) && codGravarTO == 1) {
            if (jDataLanc.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data do atendimento.");
                jDataLanc.requestFocus();
                jDataLanc.setBackground(Color.red);
            } else {
                if (jNomeInternoAD.getText().equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Informe qual é o interno a ser atendido");
                } else if (jQuantoTabagismo.getText().equals("") || jQuantoTabagismo.getText() == null) {
                    JOptionPane.showMessageDialog(rootPane, "Preencha o campo com a quantidade de tabagismo(0) ou quantidade de tabagismo superior a (0)");
                } else if (jQuantosFilhos.getText().equals("") || jQuantosFilhos.getText() == null) {
                    JOptionPane.showMessageDialog(rootPane, "Preencha o campo com a quantidade de filhos(0) ou quantidade de filhos superior a (0)");
                } else {
                    objAtend.setIdLanc(Integer.valueOf(jIdADM_Principal.getText()));
                    objAtend.setStatusLanc(statusAtendimento);
                    objAtend.setDataLanc(jDataLanc.getDate());
                    // DESEMPENHO OCUPACIONAL
                    objAtend.setDominancia((String) jComboBoxDominancia.getSelectedItem());
                    objAtend.setAmputacao((String) jComboBoxAmputacao.getSelectedItem());
                    objAtend.setDeficienciaOcupa((String) jComboBoxDeficienciaOcupa.getSelectedItem());
                    objAtend.setReabilitacao((String) jComboBoxReabilitacao.getSelectedItem());
                    objAtend.setMotora((String) jComboBoxMotora.getSelectedItem());
                    objAtend.setCognitiva((String) jComboBoxCognitiva.getSelectedItem());
                    objAtend.setSensorial((String) jComboBoxSensorial.getSelectedItem());
                    objAtend.setIntPsi((String) jComboBoxIntPsi.getSelectedItem());
                    objAtend.setaVD((String) jComboBoxAVD.getSelectedItem());
                    objAtend.setaIVD((String) jComboBoxAIVD.getSelectedItem());
                    objAtend.setLazer((String) jComboBoxLazer.getSelectedItem());
                    objAtend.setTrabalho((String) jComboBoxTrabalho.getSelectedItem());
                    objAtend.setObsDesempenhoOcupacional(jObsDesempenhoOcupacional.getText());
                    // HISTÓRICO FAMILIAR
                    objAtend.setPaisVivos((String) jComboBoxPaisVivos.getSelectedItem());
                    objAtend.setTemCompanheira((String) jComboBoxTemCompanheira.getSelectedItem());
                    objAtend.setTemFilhos((String) jComboBoxTemFilhos.getSelectedItem());
                    objAtend.setQuantosFilhos(Integer.valueOf(jQuantosFilhos.getText()));
                    objAtend.setVisitaFamiliar((String) jComboBoxVisitaFamiliar.getSelectedItem());
                    if (jCheckBoxSFSeg.isSelected()) {
                        SFSeg = 0;
                    } else if (!jCheckBoxSFSeg.isSelected()) {
                        SFSeg = 1;
                    }
                    objAtend.setsFSeg(SFSeg);
                    if (jCheckBoxSFTer.isSelected()) {
                        SFTer = 0;
                    } else if (!jCheckBoxSFTer.isSelected()) {
                        SFTer = 1;
                    }
                    objAtend.setsFTer(SFTer);
                    if (jCheckBoxSFQua.isSelected()) {
                        SFQua = 0;
                    } else if (!jCheckBoxSFQua.isSelected()) {
                        SFQua = 1;
                    }
                    objAtend.setsFQua(SFQua);
                    if (jCheckBoxSFQui.isSelected()) {
                        SFQui = 0;
                    } else if (!jCheckBoxSFQui.isSelected()) {
                        SFQui = 1;
                    }
                    objAtend.setsFQui(SFQui);
                    if (jCheckBoxSFSex.isSelected()) {
                        SFSex = 0;
                    } else if (!jCheckBoxSFSex.isSelected()) {
                        SFSex = 1;
                    }
                    objAtend.setsFSex(SFSex);
                    if (jCheckBoxSFSab.isSelected()) {
                        SFSab = 0;
                    } else if (!jCheckBoxSFSab.isSelected()) {
                        SFSab = 1;
                    }
                    objAtend.setsFSab(SFSab);
                    if (jCheckBoxSFDom.isSelected()) {
                        SFDom = 0;
                    } else if (!jCheckBoxSFDom.isSelected()) {
                        SFDom = 1;
                    }
                    objAtend.setsFDom(SFDom);
                    objAtend.setVisitaIntima((String) jComboBoxVisitaIntima.getSelectedItem());
                    if (jCheckBoxIntSeg.isSelected()) {
                        IntSeg = 0;
                    } else if (!jCheckBoxIntSeg.isSelected()) {
                        IntSeg = 1;
                    }
                    objAtend.setIntSeg(IntSeg);
                    if (jCheckBoxIntTer.isSelected()) {
                        IntTer = 0;
                    } else if (!jCheckBoxIntTer.isSelected()) {
                        IntTer = 1;
                    }
                    objAtend.setIntTer(IntTer);
                    if (jCheckBoxIntQua.isSelected()) {
                        IntQua = 0;
                    } else if (!jCheckBoxIntQua.isSelected()) {
                        IntQua = 1;
                    }
                    objAtend.setIntQua(IntQua);
                    if (jCheckBoxIntQui.isSelected()) {
                        IntQui = 0;
                    } else if (!jCheckBoxIntQui.isSelected()) {
                        IntQui = 1;
                    }
                    objAtend.setIntQui(IntQui);
                    if (jCheckBoxIntSex.isSelected()) {
                        IntSex = 0;
                    } else if (!jCheckBoxIntSex.isSelected()) {
                        IntSex = 1;
                    }
                    objAtend.setIntSex(IntSex);
                    if (jCheckBoxIntSab.isSelected()) {
                        IntSab = 0;
                    } else if (!jCheckBoxIntSab.isSelected()) {
                        IntSab = 1;
                    }
                    objAtend.setIntSab(IntSab);
                    if (jCheckBoxIntDom.isSelected()) {
                        IntDom = 0;
                    } else if (!jCheckBoxIntDom.isSelected()) {
                        IntDom = 1;
                    }
                    objAtend.setIntDom(IntDom);
                    objAtend.setObsHistoricoFamiliar(jObsHistoricoFamiliar.getText());
                    // DADOS CLINICOS
                    objAtend.setHipertensao((String) jComboBoxHipertensao.getSelectedItem());
                    objAtend.setDiabetes((String) jComboBoxDiabetes.getSelectedItem());
                    objAtend.setCancer((String) jComboBoxCancer.getSelectedItem());
                    objAtend.setProRespiratorio((String) jComboBoxProRespiratorio.getSelectedItem());
                    objAtend.setTransMental((String) jComboBoxTransMental.getSelectedItem());
                    objAtend.setInfectoContagiosa((String) jComboBoxInfectocontagiosa.getSelectedItem());
                    objAtend.setDoencasDigestiva((String) jComboBoxDoencasDigestivo.getSelectedItem());
                    objAtend.setDeficienciaVAF((String) jComboBoxDeficienciaVAF.getSelectedItem());
                    objAtend.setObsDadosClinicos(ObsDadosClinicos.getText());
                    // QUALIDADE DE VIDA (TRIAGEM SPA)
                    objAtend.setTabagismo((String) jComboBoxTabagismo.getSelectedItem());
                    objAtend.setQuantoTabagismo(Integer.parseInt(jQuantoTabagismo.getText()));
                    objAtend.setTabagismoUsuario((String) jComboBoxTabagismoUsuario.getSelectedItem());
                    objAtend.setEtilismo((String) jComboBoxEtilismo.getSelectedItem());
                    objAtend.setTipoEtilismo(jTipoEtilismo.getText());
                    objAtend.setEtilismoUsuario((String) jComboBoxEtilismoUsuario.getSelectedItem());
                    objAtend.setMedicacaoAlopativa((String) jComboBoxMedicaoAlopatica.getSelectedItem());
                    objAtend.setTipoMedicacaoAlopativa(jTipoMedicaoAlopatica.getText());
                    objAtend.setMedicaoAlopaticaUsuario((String) jComboBoxMedicaoAlopaticaUsuario.getSelectedItem());
                    objAtend.setsPA((String) jComboBoxSPA.getSelectedItem());
                    objAtend.setTipoSPA(jTipoSPA.getText());
                    objAtend.setsPAUsuario((String) jComboBoxSPAUsuario.getSelectedItem());
                    objAtend.setObsTriagemSPA(jObsTriagemSPA.getText());
                    // QUALIDADE DE VIDA (ESTILO VIDA)
                    objAtend.setVidaSexual((String) jComboBoxVidaSexual.getSelectedItem());
                    objAtend.setMetodoContraCeptivo((String) jComboBoxMetodoContraCeptivo.getSelectedItem());
                    objAtend.setQualMetodoContraCeptivo(jQualMetodoContraCeptivo.getText());
                    objAtend.setGestante((String) jComboBoxGestante.getSelectedItem());
                    objAtend.setAborto((String) jComboBoxAborto.getSelectedItem());
                    objAtend.setMotivoAborto(jMotivoAborto.getText());
                    objAtend.setPraticaAtividadeFisica((String) jComboBoxPraticaAtividadeFisica.getSelectedItem());
                    objAtend.setQualAtividadeFisica(jQualAtividadeFisica.getText());
                    objAtend.setTrataPsicologica((String) jComboBoxTrataPsicologico.getSelectedItem());
                    objAtend.setObsEstiloVida(jObsEstiloVida.getText());
                    // ALTERAÇÕES PSICOLOGICAS
                    objAtend.setHumor((String) jComboBoxHumor.getSelectedItem());
                    objAtend.setInsonia((String) jComboBoxInsonia.getSelectedItem());
                    objAtend.setIrritabilidade((String) jComboBoxIrritabilidade.getSelectedItem());
                    objAtend.setFrustracao((String) jComboBoxFrustracao.getSelectedItem());
                    objAtend.setDificuldadeConcentrar((String) jComboBoxDificultadeConcentrar.getSelectedItem());
                    objAtend.setRaiva((String) jComboBoxRaiva.getSelectedItem());
                    objAtend.setInquietacao((String) jComboBoxInquietacao.getSelectedItem());
                    objAtend.setAnsiedade((String) jComboBoxAnsiedade.getSelectedItem());
                    objAtend.setObsAlteracoesPsicologicas(ObsAlteracoesPsicologicas.getText());
                    if (acao == 1) {
                        // log de usuario
                        objAtend.setUsuarioInsert(nameUser);
                        objAtend.setDataInsert(dataModFinal);
                        objAtend.setHoraInsert(horaMov);
                        //
                        objAtend.setIdInternoCrc(Integer.valueOf(jIdInternoAD.getText()));
                        objAtend.setNomeInternoCrc(jNomeInternoAD.getText());
                        control.incluirAtendTerapia(objAtend);
                        buscarID();
                        objAtend.setIdLanc(Integer.valueOf(jIdAtendNovo.getText()));
                        objAtend.setNomeInternoCrc(jNomeInternoAD.getText());
                        objAtend.setDeptoTerapia(deptoTecnico);
                        controle.incluirMovTec(objAtend);
                        // MODIFICAR A TABELA REGISTRO_ATENDIMENTO_INTERNO_PSP INFORMANDO QUE JÁ FOI ATENDIDO    
                        atendido = "Sim";
                        objRegAtend.setIdInternoCrc(Integer.valueOf(jIdInternoAD.getText()));
                        objRegAtend.setNomeInternoCrc(jNomeInternoAD.getText());
                        objRegAtend.setIdDepartamento(codigoDepartamentoTO);
                        objRegAtend.setNomeDepartamento(nomeModuloTO);
                        objRegAtend.setTipoAtemdimento(tipoAtendimentoAdm);
                        objRegAtend.setAtendido(atendido);
                        objRegAtend.setDataAtendimento(jDataLanc.getDate());
                        objRegAtend.setIdAtend(Integer.valueOf(jIdADM_Principal.getText()));
                        objRegAtend.setQtdAtend(pQUANTIDADE_ATENDIDA);
                        //
                        objRegAtend.setUsuarioUp(nameUser);
                        objRegAtend.setDataUp(dataModFinal);
                        objRegAtend.setHorarioUp(horaMov);
                        controlRegAtend.alterarRegAtend(objRegAtend);
                        //GRAVAR NA TABELA DE ATENDIMENTO ATENDIMENTO_PSP_INTERNO_TV        
                        objRegAtend.setStatusAtendimento(status_ATENDIMENTO);
                        objRegAtend.setIdInternoCrc(Integer.valueOf(jIdInternoAD.getText()));
                        objRegAtend.setNomeInternoCrc(jNomeInternoAD.getText());
                        objRegAtend.setIdDepartamento(codigoDepartamentoTO);
                        objRegAtend.setNomeDepartamento(nomeModuloTO);
                        objRegAtend.setConcluido(pATENDIMENTO_CONCLUIDO);
                        objRegAtend.setHorarioUp(horaMov);
                        objRegAtend.setIdAtend(Integer.valueOf(jIdAtend.getText()));
                        objRegAtend.setTipoAtemdimento(tipoAtendimentoAdm);
                        control_ATENDE.confirmarAtendimento(objRegAtend);
                        //CONFIRMA A REALIZAÇÃO ADMISSÃO DO INTERNO, IMPEDINDO QUE FAÇA OUTRA ADMISSÃO
                        pHABILITA_TO = "Não";
                        objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIdInternoAD.getText()));
                        objPortaEntrada.setNomeInternoCrc(jNomeInternoAD.getText());
                        objPortaEntrada.setHabTer(pHABILITA_TO);
                        control_PE.alterarPortaEntradaTerapia(objPortaEntrada);
                        //
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        //EVOLUÇÃO DA ADMISSÃO - AINDA NÃO FOI IMPLEMENTADA
                        objEvolu.setDataEvo(jDataLanc.getDate());
                        objEvolu.setEvolucao(jObsDesempenhoOcupacional.getText());
                        // log de usuario
                        objEvolu.setUsuarioInsert(nameUser);
                        objEvolu.setDataInsert(dataModFinal);
                        objEvolu.setHorarioInsert(horaMov);
                        //
                        objEvolu.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
                        objEvolu.setIdLanc(Integer.valueOf(jIdAtend.getText()));
                        objEvolu.setAdmEvo(admEvolucao);
                        controleEvolucao.incluirEvolucaoTerapia(objEvolu);
                        preencherItensEvolucao("SELECT * FROM EVOLUCAOTERAPIA "
                                + "WHERE IdLanc='" + jIdAtend.getText() + "'");
                        //
                        JOptionPane.showMessageDialog(rootPane, "Registro Gravado com sucesso.");
                        Salvar();
                        JOptionPane.showMessageDialog(rootPane, "Se já terminou o atendimento, será necessário clicar no botão <Concluir> para contabilizar o atendimento e liberar o interno.");
                    }
                    if (acao == 2) {
                        // log de usuario
                        objAtend.setUsuarioUp(nameUser);
                        objAtend.setDataUp(dataModFinal);
                        objAtend.setHoraUp(horaMov);
                        //
                        objAtend.setIdATN(Integer.valueOf(jIdAtendNovo.getText()));
                        objAtend.setIdInternoCrc(Integer.valueOf(jIdInternoAD.getText()));
                        objAtend.setNomeInternoCrc(jNomeInternoAD.getText());
                        control.alterarAtendTerapia(objAtend);
                        objAtend.setIdLanc(Integer.valueOf(jIdAtendNovo.getText()));
                        objAtend.setNomeInternoCrc(jNomeInternoAD.getText());
                        objAtend.setDeptoTerapia(deptoTecnico);
                        controle.alterarMovTec(objAtend);
                        //ADMISSÃO EVOLUÇÃO - AINDA NÃO IMPLEMENTADA
                        objEvolu.setDataEvo(jDataLanc.getDate());
                        objEvolu.setEvolucao(jObsDesempenhoOcupacional.getText());
                        // log de usuario
                        objEvolu.setUsuarioUp(nameUser);
                        objEvolu.setDataUp(dataModFinal);
                        objEvolu.setHorarioUp(horaMov);
                        //
                        objEvolu.setIdEvo(Integer.valueOf(jIdEvolucao.getText()));
                        objEvolu.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
                        objEvolu.setIdLanc(Integer.valueOf(jIdAtend.getText()));
                        objEvolu.setAdmEvo(admEvolucao);
                        controleEvolucao.alterarEvolucaoTerapiaADM(objEvolu);
                        preencherItensEvolucao("SELECT * FROM EVOLUCAOTERAPIA "
                                + "WHERE IdLanc='" + jIdAtend.getText() + "'");
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        JOptionPane.showMessageDialog(rootPane, "Registro Gravado com sucesso.");
                        Salvar();
                        JOptionPane.showMessageDialog(rootPane, "Se já terminou o atendimento, será necessário clicar no botão <Concluir> para contabilizar o atendimento e liberar o interno.");
                    }
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
        statusMov = "Finalizou";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        String statusAtend = "FINALIZADO";
        JOptionPane.showMessageDialog(rootPane, "Se esse atendimento for finaliza,\nvocê não poderá mais excluir ou alterar.");
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente FINALIZA o ATENDIMENTO selecionado?", "Confirmação",
                JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            objAtend.setStatusLanc(statusAtend);
            objAtend.setIdLanc(Integer.parseInt(jIdAtendNovo.getText()));
            control.finalizarAtendTerapia(objAtend);
            objAtend.setIdLanc(Integer.valueOf(jIdAtendNovo.getText()));
            controle.finalizarMovTec(objAtend);
            objLog();
            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
            jStatusLanc.setText(statusAtend);
            JOptionPane.showMessageDialog(rootPane, "Registro FINALIZADO com sucesso !!!");
        }
    }//GEN-LAST:event_jBtFinalizarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtImpressaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImpressaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtImpressaoActionPerformed

    private void jBtAuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaActionPerformed
        // TODO add your handling code here:
        if (jIdAtendNovo.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Não existe registro selecionado.");
        } else {
            mostraAdutoriaManu();
        }
    }//GEN-LAST:event_jBtAuditoriaActionPerformed

    private void jBtConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtConcluirActionPerformed
        // TODO add your handling code here:
        if (jIdAtendNovo.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Não existe atendimento a ser concluído.");
        } else {
            verificarInternoRegistradoAdm();
            // MODIFICAR A TABELA REGISTRO_ATENDIMENTO_INTERNO_PSP INFORMANDO QUE JÁ FOI ATENDIDO
            atendido = "Sim";
            objRegAtend.setIdInternoCrc(Integer.valueOf(jIdInternoAD.getText()));
            objRegAtend.setNomeInternoCrc(jNomeInternoAD.getText());
            objRegAtend.setIdDepartamento(codigoDepartamentoTO);
            objRegAtend.setNomeDepartamento(nomeModuloTO);
            objRegAtend.setTipoAtemdimento(tipoAtendimentoAdm);
            objRegAtend.setAtendido(atendido);
            objRegAtend.setDataAtendimento(jDataLanc.getDate());
            objRegAtend.setIdAtend(Integer.valueOf(jIdAtendNovo.getText()));
            objRegAtend.setQtdAtend(pQUANTIDADE_ATENDIDA);
            //
            objRegAtend.setUsuarioUp(nameUser);
            objRegAtend.setDataUp(dataModFinal);
            objRegAtend.setHorarioUp(horaMov);
            controlRegAtend.alterarRegAtend(objRegAtend);
            //GRAVAR NA TABELA DE ATENDIMENTO ATENDIMENTO_PSP_INTERNO_TV
            objRegAtend.setStatusAtendimento(status_ATENDIMENTO);
            objRegAtend.setIdInternoCrc(Integer.valueOf(jIdInternoAD.getText()));
            objRegAtend.setNomeInternoCrc(jNomeInternoAD.getText());
            objRegAtend.setIdDepartamento(codigoDepartamentoTO);
            objRegAtend.setNomeDepartamento(nomeModuloTO);
            objRegAtend.setConcluido(pATENDIMENTO_CONCLUIDO);
            objRegAtend.setHorarioUp(horaMov);
            objRegAtend.setIdAtend(Integer.valueOf(jIdAtendNovo.getText()));
            objRegAtend.setTipoAtemdimento(tipoAtendimentoAdm);
            control_ATENDE.confirmarAtendimento(objRegAtend);
            JOptionPane.showMessageDialog(rootPane, "Registro concluído com sucesso.");
        }
    }//GEN-LAST:event_jBtConcluirActionPerformed

    private void jMotivoAbortoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMotivoAbortoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMotivoAbortoActionPerformed

    private void jTabelaCursos_NOVOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaCursos_NOVOMouseClicked
        // TODO add your handling code here:
        //  jComboBoxDescricaoCurso.removeAllItems();
        flag = 1;
        if (acao == 9 || acao == 10) {
            jBtExcluirCurso.setEnabled(true);
            if (flag == 1) {
                String codItem = "" + jTabelaCursos_NOVO.getValueAt(jTabelaCursos_NOVO.getSelectedRow(), 0);
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM ITENS_CURSOS_TO_HISTORICO_EDUCACIONAL_NOVO "
                            + "INNER JOIN CURSOS "
                            + "ON ITENS_CURSOS_TO_HISTORICO_EDUCACIONAL_NOVO.IdCurso=CURSOS.IdCurso "
                            + "WHERE IdATN='" + jIdAtendNovo.getText() + "' "
                            + "AND ITENS_CURSOS_TO_HISTORICO_EDUCACIONAL_NOVO.IdCurso='" + codItem + "'");
                    conecta.rs.first();
                    pesquisarPrioridadeCursos = conecta.rs.getInt("PrioridadeCurso");
                    if (pesquisarPrioridadeCursos == 0) {
                        jRadioBtA.setSelected(true);
                    } else if (pesquisarPrioridadeCursos == 1) {
                        jRadioBtB.setSelected(true);
                    } else if (pesquisarPrioridadeCursos == 2) {
                        jRadioBtC.setSelected(true);
                    }
                } catch (SQLException ex) {
                }
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaCursos_NOVOMouseClicked

    private void jBtIncluirCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtIncluirCursoActionPerformed
        // TODO add your handling code here:
        if (jComboBoxDescricaoCurso.getSelectedItem().equals("Selecione...") || jComboBoxDescricaoCurso.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Selecione um curso profissionalizante...");
        } else {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM CURSOS WHERE DescricaoCurso='" + jComboBoxDescricaoCurso.getSelectedItem() + "'");
                conecta.rs.first();
                codigoCurso = conecta.rs.getString("IdCurso");
                objHistEducLabor.setIdCurso(Integer.valueOf(codigoCurso));
            } catch (Exception e) {
            }
            if (jRadioBtA.isSelected()) {
                letraPrioridade = "A";
            } else if (jRadioBtB.isSelected()) {
                letraPrioridade = "B";
            } else if (jRadioBtC.isSelected()) {
                letraPrioridade = "C";
            }
            DefaultTableModel descCursos = (DefaultTableModel) jTabelaCursos_NOVO.getModel();
            objHistEducLabor.setIdCurso(Integer.valueOf(codigoCurso));
            objHistEducLabor.setDescricaoCurso((String) jComboBoxDescricaoCurso.getSelectedItem());
            Object campos[] = {objHistEducLabor.getIdCurso(), objHistEducLabor.getDescricaoCurso(), letraPrioridade};
            descCursos.addRow(campos);
            //
            jComboBoxDescricaoCurso.setSelectedItem("Selecione...");
            conecta.desconecta();
        }
    }//GEN-LAST:event_jBtIncluirCursoActionPerformed

    private void jBtExcluirCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirCursoActionPerformed
        // TODO add your handling code here:
        if (jTabelaCursos_NOVO.getSelectedRow() != -1) {
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o item selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                DefaultTableModel dtm = (DefaultTableModel) jTabelaCursos_NOVO.getModel();
                dtm.removeRow(jTabelaCursos_NOVO.getSelectedRow());
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione o registro que deseja excluir.");
        }
    }//GEN-LAST:event_jBtExcluirCursoActionPerformed

    private void jBtNovoHistoricoEducaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoHistoricoEducaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtendimentoInternoHistEduTO);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTO.equals("ADMINISTRADORES") || codigoUserTO == codUserAcessoTO && nomeTelaTO.equals(telaAtendimentoInternoHistEduTO) && codIncluirTO == 1) {
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            acao = 9;
            bloquearCampos();
            NovoHistoricoEdu();
            preencherComboNovo();
            limparTabelaCursos();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovoHistoricoEducaActionPerformed

    private void jBtAlterarHistoricoEducaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarHistoricoEducaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtendimentoInternoHistEduTO);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTO.equals("ADMINISTRADORES") || codigoUserTO == codUserAcessoTO && nomeTelaTO.equals(telaAtendimentoInternoHistEduTO) && codAlterarTO == 1) {
            statusMov = "Alterou";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            acao = 10;
            bloquearCampos();
            AlterarHistoricoEdu();
            preencherComboNovo();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtAlterarHistoricoEducaActionPerformed

    private void jBtExcluirHistoricoEducaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirHistoricoEducaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtendimentoInternoHistEduTO);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTO.equals("ADMINISTRADORES") || codigoUserTO == codUserAcessoTO && nomeTelaTO.equals(telaAtendimentoInternoHistEduTO) && codExcluirTO == 1) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                bloquearCampos();
                objHistEducLabor.setIdHistoricoEduN(codigoHistoricoEduca);
                // EXCLUIR OS DADOS DA TABELA ITENS_PROFISSAO_TO_HISTORICO_EDUCACIONAL
                controleCursosTO.excluirCursos(objHistEducLabor);
                limparTabelaCursos();
                // EXCLUIR OS DADOS DA TABELA TO_HISTORICO_EDUCACIONAL
                controleHistEduca.excluirHistoricoEduca(objHistEducLabor);
                //
                objLog5();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                ExcluirHistoricoEdu();
                JOptionPane.showMessageDialog(rootPane, "Registro excluído com sucesso.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirHistoricoEducaActionPerformed

    private void jBtSalvarHistoricoEducaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarHistoricoEducaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtendimentoInternoHistEduTO);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTO.equals("ADMINISTRADORES") || codigoUserTO == codUserAcessoTO && nomeTelaTO.equals(telaAtendimentoInternoHistEduTO) && codGravarTO == 1) {
            verificarHistoricoEduca();// VERIFICAR SE O INTERNO JÁ FOI CADASTRADO NO HISTORICO EDUCACIONAL.
            Integer rows = jTabelaCursos_NOVO.getModel().getRowCount();
            if (rows == 0) {
                JOptionPane.showMessageDialog(rootPane, "Informe pelo menos um tipo de curso.");
            } else {
                objHistEducLabor.setEscreveProprioNome((String) jComboBoxEscreveProprioNome.getSelectedItem());
                objHistEducLabor.setSabeLerEscrever((String) jComboBoxSabeLerEscrever.getSelectedItem());
                objHistEducLabor.setNivelInstrucao((String) jComboBoxNivelInstrucao.getSelectedItem());
                objHistEducLabor.setInteresseEstudar((String) jComboBoxInteresseEstudar.getSelectedItem());
                objHistEducLabor.setCursoProfissionalizante((String) jComboBoxCursoProfissionalizante.getSelectedItem());
                objHistEducLabor.setDescricaoCurso((String) jComboBoxDescricaoCurso.getSelectedItem());
                objHistEducLabor.setIdATN(Integer.valueOf(jIdAtendNovo.getText()));
                objHistEducLabor.setNomeInternoCrc(jNomeInternoAD.getText());
                if (acao == 9) {
                    if (jIdInternoAD.getText().equals(codigoInterno) && jIdAtendNovo.getText().equals(codigoRegistro)) {
                        JOptionPane.showMessageDialog(rootPane, "Registro ja foi gravado para esse interno.");
                    } else {
                        objHistEducLabor.setUsuarioInsert(nameUser);
                        objHistEducLabor.setDataInsert(dataModFinal);
                        objHistEducLabor.setHorarioInsert(horaMov);
                        //
                        controleHistEduca.incluirHistoricoEduca(objHistEducLabor);
                        buscarCodigoHistoricoEduca();
                        JOptionPane.showMessageDialog(rootPane, "CÓDIGO DO HISTÓRICO EDUCAÇÃO: " + codigoHistoricoEduca);
                        //GRAVAR CURSOS NA TABELA ITENS_PROFISSAO_TO_HISTORICO_EDUCACIONAL
                        //codigoHistoricoEduca
                        incluirCursos();
                        //
                        objLog5();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        SalvarHistoricoEdu();
                        JOptionPane.showMessageDialog(rootPane, "Registro Gravado com sucesso.");
                        JOptionPane.showMessageDialog(rootPane, "Se já terminou o atendimento, será necessário clicar no botão <Concluir> para contabilizar o atendimento e liberar o interno.");
                    }
                }
                if (acao == 10) {
                    objHistEducLabor.setUsuarioUp(nameUser);
                    objHistEducLabor.setDataUp(dataModFinal);
                    objHistEducLabor.setHorarioUp(horaMov);
                    //
                    objHistEducLabor.setIdHistoricoEduN(codigoHistoricoEduca);
                    controleHistEduca.alterarHistoricoEduca(objHistEducLabor);
                    // ALTERAR OS DADOS DA TABELA ITENS_PROFISSAO_TO_HISTORICO_EDUCACIONAL
                    controleCursosTO.excluirCursos(objHistEducLabor);
                    incluirCursos();
                    //
                    objLog5();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    SalvarHistoricoEdu();
                    JOptionPane.showMessageDialog(rootPane, "Registro Gravado com sucesso.");
                    JOptionPane.showMessageDialog(rootPane, "Se já terminou o atendimento, será necessário clicar no botão <Concluir> para contabilizar o atendimento e liberar o interno.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtSalvarHistoricoEducaActionPerformed

    private void jBtCancelarHistoricoEducaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarHistoricoEducaActionPerformed
        // TODO add your handling code here:
        CancelarHistoricoEdu();
    }//GEN-LAST:event_jBtCancelarHistoricoEducaActionPerformed

    private void jBtRefersCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtRefersCursosActionPerformed
        // TODO add your handling code here:
        preencherComboNovo();
    }//GEN-LAST:event_jBtRefersCursosActionPerformed

    private void jBtAuditoriaHistoricoEducaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaHistoricoEducaActionPerformed
        // TODO add your handling code here:
        if (jIdAtendNovo.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Não existe registro selecionado.");
        } else {
            mostrarAuditoriaHistoricoEduca();
        }
    }//GEN-LAST:event_jBtAuditoriaHistoricoEducaActionPerformed

    private void jTabelaExperienciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaExperienciaMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (acao == 11 || acao == 12) {
            jBtExcluirExperiencia.setEnabled(true);
            if (flag == 1) {
                String codItemProf = "" + jTabelaExperiencia.getValueAt(jTabelaExperiencia.getSelectedRow(), 0);
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM ITENS_PROFISSAO_TO_HISTORICO_PROFISSIONAL_NOVO "
                            + "INNER JOIN PROFISSAO "
                            + "ON ITENS_PROFISSAO_TO_HISTORICO_PROFISSIONAL_NOVO.IdCodigoProf=PROFISSAO.IdCodigoProf "
                            + "WHERE IdATN='" + jIdAtendNovo.getText() + "' "
                            + "AND ITENS_PROFISSAO_TO_HISTORICO_PROFISSIONAL_NOVO.IdCodigoProf='" + codItemProf + "'");
                    conecta.rs.first();
                } catch (SQLException ex) {
                }
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaExperienciaMouseClicked

    private void jBtIncluirExperienciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtIncluirExperienciaActionPerformed
        // TODO add your handling code here:
        if (jComboBoxQualExperienciaProfissional.getSelectedItem().equals("Selecione...") || jComboBoxQualExperienciaProfissional.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma experiência profissional...");
        } else {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM PROFISSAO WHERE DescricaoProf='" + jComboBoxQualExperienciaProfissional.getSelectedItem() + "'");
                conecta.rs.first();
                codigoExpProfissao = conecta.rs.getString("IdCodigoProf");
                objHistEducLabor.setIdProfissao(Integer.valueOf(codigoExpProfissao));
            } catch (Exception e) {
            }
            //            if (jRadioBtRemunerado.isSelected()) {
            //                tipoRemuneracao = "Remunerada";
            //            } else if (jRadioBtNaoRemunerado.isSelected()) {
            //                tipoRemuneracao = "Não Remunerada";
            //            } else if (jRadioBtAmbos.isSelected()) {
            //                tipoRemuneracao = "Ambas";
            //            }
            DefaultTableModel descProf = (DefaultTableModel) jTabelaExperiencia.getModel();
            objHistEducLabor.setIdProfissao(Integer.valueOf(codigoExpProfissao));
            objHistEducLabor.setExperienciaProfissional((String) jComboBoxQualExperienciaProfissional.getSelectedItem());
            Object campos[] = {objHistEducLabor.getIdProfissao(), objHistEducLabor.getExperienciaProfissional()};
            //            Object campos[] = {objHistEducLabor.getIdProfissao(), objHistEducLabor.getExperienciaProfissional(), tipoRemuneracao};
            descProf.addRow(campos);
            //
            jComboBoxQualExperienciaProfissional.setSelectedItem("Selecione...");
            conecta.desconecta();
        }
    }//GEN-LAST:event_jBtIncluirExperienciaActionPerformed

    private void jBtExcluirExperienciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirExperienciaActionPerformed
        // TODO add your handling code here:
        if (jTabelaExperiencia.getSelectedRow() != -1) {
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o item selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                DefaultTableModel dmpExp = (DefaultTableModel) jTabelaExperiencia.getModel();
                dmpExp.removeRow(jTabelaExperiencia.getSelectedRow());
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione o registro que deseja excluir.");
        }
    }//GEN-LAST:event_jBtExcluirExperienciaActionPerformed

    private void jBtNovoHistoricoLaborActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoHistoricoLaborActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtendimentoInternoHistLabTO);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTO.equals("ADMINISTRADORES") || codigoUserTO == codUserAcessoTO && nomeTelaTO.equals(telaAtendimentoInternoHistLabTO) && codIncluirTO == 1) {
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            acao = 11;
            bloquearCampos();
            NovoHistoricoLabor();
            preencherComboExperiencia();
            preencherComboProfissao();
            limparTabelaExperiencia();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovoHistoricoLaborActionPerformed

    private void jBtAlterarHistoricoLaborActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarHistoricoLaborActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtendimentoInternoHistLabTO);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTO.equals("ADMINISTRADORES") || codigoUserTO == codUserAcessoTO && nomeTelaTO.equals(telaAtendimentoInternoHistLabTO) && codAlterarTO == 1) {
            statusMov = "Alterou";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            acao = 12;
            bloquearCampos();
            AlterarHistoricoLabor();
            preencherComboExperiencia();
            preencherComboProfissao();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtAlterarHistoricoLaborActionPerformed

    private void jBtExcluirHistoricoLaborActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirHistoricoLaborActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtendimentoInternoHistLabTO);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTO.equals("ADMINISTRADORES") || codigoUserTO == codUserAcessoTO && nomeTelaTO.equals(telaAtendimentoInternoHistLabTO) && codExcluirTO == 1) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                bloquearCampos();
                objHistEducLabor.setIdHistoricoLabPN(codigoHistoricoProf);
                // EXCLUIR OS DADOS DA TABELA ITENS_PROFISSAO_TO_HISTORICO_PROFISSIONAL
                controleExpTO.excluirExperiencia(objHistEducLabor);
                limparTabelaExperiencia();
                // EXCLUIR OS DADOS DA TABELA TO_HISTORICO_PROFISSIONAL
                controleHistLab.excluirHistoricoLabor(objHistEducLabor);
                //
                objLog6();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                ExcluirHistoricoLabor();
                JOptionPane.showMessageDialog(rootPane, "Registro excluído com sucesso.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirHistoricoLaborActionPerformed

    private void jBtSalvarHistoricoLaborActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarHistoricoLaborActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtendimentoInternoHistLabTO);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTO.equals("ADMINISTRADORES") || codigoUserTO == codUserAcessoTO && nomeTelaTO.equals(telaAtendimentoInternoHistLabTO) && codGravarTO == 1) {
            verificarHistoricoLabor(); // VERIFICAR SE O REGISTRO JÁ EXISTE
            Integer rows = jTabelaExperiencia.getModel().getRowCount();
            if (rows == 0) {
                JOptionPane.showMessageDialog(rootPane, "Informe pelo menos um tipo de experiência.");
            } else {
                objHistEducLabor.setTemProfissao((String) jComboBoxTemProfissao.getSelectedItem());
                objHistEducLabor.setQualProfissao((String) jComboBoxQualProfissao.getSelectedItem());
                objHistEducLabor.setExperienciaProfissional((String) jComboBoxExperienciaProfissional.getSelectedItem());
                objHistEducLabor.setQualExperienciaProfissional((String) jComboBoxQualExperienciaProfissional.getSelectedItem());
                objHistEducLabor.setDesejaTrabalharUnid((String) jComboBoxDesejaTrabalharUnid.getSelectedItem());
                objHistEducLabor.setIdATN(Integer.valueOf(jIdAtendNovo.getText()));
                objHistEducLabor.setNomeInternoCrc(jNomeInternoAD.getText());
                if (jRadioBtRemunerado.isSelected()) {
                    remuneracao = 0;
                } else if (jRadioBtNaoRemunerado.isSelected()) {
                    remuneracao = 1;
                } else if (jRadioBtAmbos.isSelected()) {
                    remuneracao = 2;
                }
                objHistEducLabor.setTipoRemuneracao(remuneracao);
                if (acao == 11) {
                    if (jIdInternoAD.getText().equals(codigoInterno) && jIdAtendNovo.getText().equals(codigoRegistro)) {
                        JOptionPane.showMessageDialog(rootPane, "Registro ja foi gravado para esse interno.");
                    } else {
                        objHistEducLabor.setUsuarioInsert(nameUser);
                        objHistEducLabor.setDataInsert(dataModFinal);
                        objHistEducLabor.setHorarioInsert(horaMov);
                        //
                        controleHistLab.incluirHistoricoLabor(objHistEducLabor);
                        buscarHistoricoLabor();
                        // GRAVAR EXPERIENCIAS PROFISSIONAIS NA TABELA ITENS_PROFISSAO_TO_HISTORICO_PROFISSIONAL
                        incluirExperiencia();
                        //
                        objLog6();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        SalvarHistoricoLabor();
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                        JOptionPane.showMessageDialog(rootPane, "Se já terminou o atendimento, será necessário clicar no botão <Concluir> para contabilizar o atendimento e liberar o interno.");
                    }
                }
                if (acao == 12) {
                    objHistEducLabor.setUsuarioUp(nameUser);
                    objHistEducLabor.setDataUp(dataModFinal);
                    objHistEducLabor.setHorarioUp(horaMov);
                    //
                    objHistEducLabor.setIdHistoricoLabPN(codigoHistoricoProf);
                    controleHistLab.alterarHistoricoLabor(objHistEducLabor);
                    //
                    controleExpTO.excluirExperiencia(objHistEducLabor);
                    incluirExperiencia();
                    //
                    objLog6();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    SalvarHistoricoLabor();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    JOptionPane.showMessageDialog(rootPane, "Se já terminou o atendimento, será necessário clicar no botão <Concluir> para contabilizar o atendimento e liberar o interno.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtSalvarHistoricoLaborActionPerformed

    private void jBtCancelarHistoricoLaborActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarHistoricoLaborActionPerformed
        // TODO add your handling code here:
        CancelarHistoricoLabor();
    }//GEN-LAST:event_jBtCancelarHistoricoLaborActionPerformed

    private void jBtSairHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairHistoricoActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairHistoricoActionPerformed

    private void jBtRefersProfissaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtRefersProfissaoActionPerformed
        // TODO add your handling code here:
        jComboBoxQualProfissao.removeAllItems();
        jComboBoxQualExperienciaProfissional.removeAllItems();
        preencherComboProfissao();
        preencherComboExperiencia();
    }//GEN-LAST:event_jBtRefersProfissaoActionPerformed

    private void jBtAuditoriaHistoricoLaborActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaHistoricoLaborActionPerformed
        // TODO add your handling code here:
        if (jIdAtendNovo.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Não existe registro selecionado.");
        } else {
            mostrarAuditoriaHistoricoLab();
        }
    }//GEN-LAST:event_jBtAuditoriaHistoricoLaborActionPerformed

    private void jBtNovoAvaliacaoIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoAvaliacaoIActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtendimentoInternoAvaITO);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTO.equals("ADMINISTRADORES") || codigoUserTO == codUserAcessoTO && nomeTelaTO.equals(telaAtendimentoInternoAvaITO) && codIncluirTO == 1) {
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            acao = 5;
            bloquearCampos();
            NovaAvaliacaoI();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovoAvaliacaoIActionPerformed

    private void jBtAlterarAvaliacaoIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarAvaliacaoIActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtendimentoInternoAvaITO);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTO.equals("ADMINISTRADORES") || codigoUserTO == codUserAcessoTO && nomeTelaTO.equals(telaAtendimentoInternoAvaITO) && codAlterarTO == 1) {
            statusMov = "Alterou";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            acao = 6;
            bloquearCampos();
            AlterarAvaliacaoI();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtAlterarAvaliacaoIActionPerformed

    private void jBtExcluirAvaliacaoIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirAvaliacaoIActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtendimentoInternoAvaITO);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTO.equals("ADMINISTRADORES") || codigoUserTO == codUserAcessoTO && nomeTelaTO.equals(telaAtendimentoInternoAvaITO) && codExcluirTO == 1) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            bloquearCampos();
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objAvaliaI.setIdATN(Integer.valueOf(jIdAtendNovo.getText()));
                objAvaliaI.setIdAvaliaI(codigoAvaliacaoI);
                controleAvaliacaoI.excluirAvaliacaoI(objAvaliaI);
                ExcluirAvaliacaoI();
                //
                objLog4();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                SalvarAvaliacaoI();
                JOptionPane.showMessageDialog(rootPane, "Registro EXCLUÍDO com successo.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirAvaliacaoIActionPerformed

    private void jBtSalvarAvaliacaoIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarAvaliacaoIActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtendimentoInternoAvaITO);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTO.equals("ADMINISTRADORES") || codigoUserTO == codUserAcessoTO && nomeTelaTO.equals(telaAtendimentoInternoAvaITO) && codGravarTO == 1) {
            verificarCodigoAvaliacaoI();
            objAvaliaI.setConhecoHabilidades((String) jComboBoxConhecoHabilidades.getSelectedItem());
            objAvaliaI.setAcreditaRealizacoes((String) jComboBoxAcreditaRealizacoes.getSelectedItem());
            objAvaliaI.setEsperoResultados((String) jComboBoxEsperoResultados.getSelectedItem());
            objAvaliaI.setAcreditoRealizaTrabalho((String) jComboBoxAcreditoRealizaTrabalho.getSelectedItem());
            objAvaliaI.setAcreditoRealizaLar((String) jComboBoxAcreditoRealizaLar.getSelectedItem());
            objAvaliaI.setAcreditoDiverteLazer((String) jComboBoxAcreditoDiverteLazer.getSelectedItem());
            objAvaliaI.setFacoAtividades((String) jComboBoxFacoAtividades.getSelectedItem());
            objAvaliaI.setTenhoExpectativa((String) jComboBoxTenhoExpectativa.getSelectedItem());
            objAvaliaI.setTenhoObjetoFuturo((String) jComboBoxTenhoObjetoFuturo.getSelectedItem());
            objAvaliaI.setIdentificoGostos((String) jComboBoxIdentificoGostos.getSelectedItem());
            objAvaliaI.setParticipoProjetosImport((String) jComboBoxParticipoProjetosImport.getSelectedItem());
            objAvaliaI.setTenhoVariosInteresse((String) jComboBoxTenhoVariosInteresse.getSelectedItem());
            objAvaliaI.setCostumoComprometo((String) jComboBoxCostumoComprometo.getSelectedItem());
            objAvaliaI.setDeEstudante((String) jComboBoxDeEstudante.getSelectedItem());
            objAvaliaI.setDeTrabalho((String) jComboBoxDeTrabalho.getSelectedItem());
            objAvaliaI.setDeAmigo((String) jComboBoxDeAmigo.getSelectedItem());
            objAvaliaI.setDeFamiliar((String) jComboBoxDeFamiliar.getSelectedItem());
            objAvaliaI.setReconhecoPapeis((String) jComboBoxReconhecoPapeis.getSelectedItem());
            objAvaliaI.setMantenhoVida((String) jComboBoxMantenhoVida.getSelectedItem());
            objAvaliaI.setIdATN(Integer.valueOf(jIdAtendNovo.getText()));
            objAvaliaI.setIdInternoCrc(Integer.valueOf(jIdInternoAD.getText()));
            if (acao == 5) {
                if (jIdAtendNovo.getText().equals(codigoAtend) && jIdInternoAD.getText().equals(codigoInternoAtend)) {
                    JOptionPane.showMessageDialog(rootPane, "Já foi realizado um registro para esse interno.");
                } else {
                    objAvaliaI.setUsuarioInsert(nameUser);
                    objAvaliaI.setDataInsert(dataModFinal);
                    objAvaliaI.setHorarioInsert(horaMov);
                    //
                    controleAvaliacaoI.incluirAvaliacaoI(objAvaliaI);
                    buscarCodigoAvaliacaoI();
                    //
                    objLog3();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    SalvarAvaliacaoI();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com successo.");
                    JOptionPane.showMessageDialog(rootPane, "Se já terminou o atendimento, será necessário clicar no botão <Concluir> para contabilizar o atendimento e liberar o interno.");
                }
            }
            if (acao == 6) {
                objAvaliaI.setUsuarioUp(nameUser);
                objAvaliaI.setDataUp(dataModFinal);
                objAvaliaI.setHorarioUp(horaMov);
                //
                objAvaliaI.setIdAvaliaI(codigoAvaliacaoI);
                controleAvaliacaoI.alterarAvaliacaoI(objAvaliaI);
                //
                objLog3();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                SalvarAvaliacaoI();
                JOptionPane.showMessageDialog(rootPane, "Registro gravado com successo.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
            JOptionPane.showMessageDialog(rootPane, "Se já terminou o atendimento, será necessário clicar no botão <Concluir> para contabilizar o atendimento e liberar o interno.");
        }
    }//GEN-LAST:event_jBtSalvarAvaliacaoIActionPerformed

    private void jBtCancelarAvaliacaoIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarAvaliacaoIActionPerformed
        // TODO add your handling code here:
        CancelarAvaliacaoI();
    }//GEN-LAST:event_jBtCancelarAvaliacaoIActionPerformed

    private void jBtSairAvaliacaoIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairAvaliacaoIActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairAvaliacaoIActionPerformed

    private void jBtAuditoriaAvaliacaoIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaAvaliacaoIActionPerformed
        // TODO add your handling code here:
        if (jIdAtendNovo.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Não existe registro selecionado.");
        } else {
            mostrarAuditoriaHistoricoSOAFI();
        }
    }//GEN-LAST:event_jBtAuditoriaAvaliacaoIActionPerformed

    private void jBtNovoAvaliacaoIIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoAvaliacaoIIActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtendimentoInternoAvaIITO);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTO.equals("ADMINISTRADORES") || codigoUserTO == codUserAcessoTO && nomeTelaTO.equals(telaAtendimentoInternoAvaIITO) && codIncluirTO == 1) {
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            acao = 7;
            bloquearCampos();
            NovaAvaliacaoII();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovoAvaliacaoIIActionPerformed

    private void jBtAlterarAvaliacaoIIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarAvaliacaoIIActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtendimentoInternoAvaIITO);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTO.equals("ADMINISTRADORES") || codigoUserTO == codUserAcessoTO && nomeTelaTO.equals(telaAtendimentoInternoAvaIITO) && codAlterarTO == 1) {
            statusMov = "Alterou";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            acao = 8;
            bloquearCampos();
            AlterarAvaliacaoII();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtAlterarAvaliacaoIIActionPerformed

    private void jBtExcluirAvaliacaoIIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirAvaliacaoIIActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtendimentoInternoAvaIITO);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTO.equals("ADMINISTRADORES") || codigoUserTO == codUserAcessoTO && nomeTelaTO.equals(telaAtendimentoInternoAvaIITO) && codExcluirTO == 1) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            bloquearCampos();
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objAvaliaII.setIdATN(Integer.valueOf(jIdAtendNovo.getText()));
                objAvaliaII.setIdAvaliaII(codigoAvaliacaoII);
                controleAvaliacaoII.excluirAvaliacaoII(objAvaliaII);
                ExcluirAvaliacaoII();
                //
                objLog4();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                SalvarAvaliacaoII();
                JOptionPane.showMessageDialog(rootPane, "Registro EXCLUÍDO com successo.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirAvaliacaoIIActionPerformed

    private void jBtSalvarAvaliacaoIIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarAvaliacaoIIActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtendimentoInternoAvaIITO);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTO.equals("ADMINISTRADORES") || codigoUserTO == codUserAcessoTO && nomeTelaTO.equals(telaAtendimentoInternoAvaIITO) && codGravarTO == 1) {
            verificarCodigoAvaliacaoII();
            objAvaliaII.setOrganizoTempo((String) jComboBoxOrganizoTempo.getSelectedItem());
            objAvaliaII.setMantenhoPapeis((String) jComboBoxMantenhoPapeis.getSelectedItem());
            objAvaliaII.setSouRotina((String) jComboBoxSouRotina.getSelectedItem());
            objAvaliaII.setConsigoOutros((String) jComboBoxConsigoOutros.getSelectedItem());
            objAvaliaII.setTenhoSocial((String) jComboBoxTenhoSocial.getSelectedItem());
            objAvaliaII.setPlanejoAgir((String) jComboBoxPlanejoAgir.getSelectedItem());
            objAvaliaII.setConcentroTrabalho((String) jComboBoxConcentroTrabalho.getSelectedItem());
            objAvaliaII.setIdentificoProblemas((String) jComboBoxIdentificoProblemas.getSelectedItem());
            objAvaliaII.setIdentificoSolucaoProblemas((String) jComboBoxIdentificoSolucaoProblemas.getSelectedItem());
            objAvaliaII.setQuandoAgir((String) jComboBoxQuandoAgir.getSelectedItem());
            objAvaliaII.setConsigoHigiene((String) jComboBoxConsigoHigiene.getSelectedItem());
            objAvaliaII.setConsigoCotidianas((String) jComboBoxConsigoCasa.getSelectedItem());
            objAvaliaII.setConsigoFinancas((String) jComboBoxConsigoCotidianas.getSelectedItem());
            objAvaliaII.setConsigoCasa((String) jComboBoxConsigoFinancas.getSelectedItem());
            objAvaliaII.setSintoPreciso((String) jComboBoxSintoPreciso.getSelectedItem());
            objAvaliaII.setCostumoFrequentar((String) jComboBoxCostumoFrequentar.getSelectedItem());
            objAvaliaII.setDataAplicacao(jDataAplicacao.getDate());
            objAvaliaII.setResponsavelAplicacao(jResponsavelAplicacao.getText());
            objAvaliaII.setIdATN(Integer.valueOf(jIdAtendNovo.getText()));
            objAvaliaII.setIdInternoCrc(Integer.valueOf(jIdInternoAD.getText()));
            if (acao == 7) {
                if (jIdAtendNovo.getText().equals(codigoAtendII) && jIdInternoAD.getText().equals(codigoInternoAtendII)) {
                    JOptionPane.showMessageDialog(rootPane, "Já foi realizado um registro para esse interno.");
                } else {
                    objAvaliaII.setUsuarioInsert(nameUser);
                    objAvaliaII.setDataInsert(dataModFinal);
                    objAvaliaII.setHorarioInsert(horaMov);
                    //
                    controleAvaliacaoII.incluirAvaliacaoII(objAvaliaII);
                    buscarCodigoAvaliacaoII();
                    //
                    objLog4();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    SalvarAvaliacaoII();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com successo.");
                    JOptionPane.showMessageDialog(rootPane, "Se já terminou o atendimento, será necessário clicar no botão <Concluir> para contabilizar o atendimento e liberar o interno.");
                }
            }
            if (acao == 8) {
                objAvaliaII.setUsuarioUp(nameUser);
                objAvaliaII.setDataUp(dataModFinal);
                objAvaliaII.setHorarioUp(horaMov);
                //
                objAvaliaII.setIdAvaliaTOII(codigoAvaliacaoII);
                controleAvaliacaoII.alterarAvaliacaoII(objAvaliaII);
                //
                objLog4();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                SalvarAvaliacaoII();
                JOptionPane.showMessageDialog(rootPane, "Registro gravado com successo.");
                JOptionPane.showMessageDialog(rootPane, "Se já terminou o atendimento, será necessário clicar no botão <Concluir> para contabilizar o atendimento e liberar o interno.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtSalvarAvaliacaoIIActionPerformed

    private void jBtCancelarAvaliacaoIIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarAvaliacaoIIActionPerformed
        // TODO add your handling code here:
        CancelarAvaliacaoII();
    }//GEN-LAST:event_jBtCancelarAvaliacaoIIActionPerformed

    private void jBtSairAvaliacaoIIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairAvaliacaoIIActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairAvaliacaoIIActionPerformed

    private void jBtAuditoriaAvaliacaoIIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaAvaliacaoIIActionPerformed
        // TODO add your handling code here:
        if (jIdAtendNovo.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Não existe registro selecionado.");
        } else {
            mostrarAuditoriaHistoricoSOAFII();
        }
    }//GEN-LAST:event_jBtAuditoriaAvaliacaoIIActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPortaEntradaTO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPortaEntradaTO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPortaEntradaTO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPortaEntradaTO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaPortaEntradaTO dialog = new TelaPortaEntradaTO(pADMISSAO_TO, true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea ObsAlteracoesPsicologicas;
    private javax.swing.JTextArea ObsDadosClinicos;
    private javax.swing.ButtonGroup buttonGroupLab;
    private javax.swing.ButtonGroup buttonGroupProf;
    private javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtAlterarAvaliacaoI;
    private javax.swing.JButton jBtAlterarAvaliacaoII;
    private javax.swing.JButton jBtAlterarHistoricoEduca;
    private javax.swing.JButton jBtAlterarHistoricoLabor;
    private javax.swing.JButton jBtAuditoria;
    private javax.swing.JButton jBtAuditoriaAvaliacaoI;
    private javax.swing.JButton jBtAuditoriaAvaliacaoII;
    private javax.swing.JButton jBtAuditoriaHistoricoEduca;
    private javax.swing.JButton jBtAuditoriaHistoricoLabor;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtCancelarAvaliacaoI;
    private javax.swing.JButton jBtCancelarAvaliacaoII;
    private javax.swing.JButton jBtCancelarHistoricoEduca;
    private javax.swing.JButton jBtCancelarHistoricoLabor;
    private javax.swing.JButton jBtConcluir;
    private javax.swing.JButton jBtExcluir;
    private javax.swing.JButton jBtExcluirAvaliacaoI;
    private javax.swing.JButton jBtExcluirAvaliacaoII;
    private javax.swing.JButton jBtExcluirCurso;
    private javax.swing.JButton jBtExcluirExperiencia;
    private javax.swing.JButton jBtExcluirHistoricoEduca;
    private javax.swing.JButton jBtExcluirHistoricoLabor;
    private javax.swing.JButton jBtFinalizar;
    private javax.swing.JButton jBtImpressao;
    private javax.swing.JButton jBtIncluirCurso;
    private javax.swing.JButton jBtIncluirExperiencia;
    private javax.swing.JButton jBtNovo;
    private javax.swing.JButton jBtNovoAvaliacaoI;
    private javax.swing.JButton jBtNovoAvaliacaoII;
    private javax.swing.JButton jBtNovoHistoricoEduca;
    private javax.swing.JButton jBtNovoHistoricoLabor;
    private javax.swing.JButton jBtPesqData;
    private javax.swing.JButton jBtPesquisaNome;
    private javax.swing.JButton jBtRefersCursos;
    private javax.swing.JButton jBtRefersProfissao;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSairAvaliacaoI;
    private javax.swing.JButton jBtSairAvaliacaoII;
    private javax.swing.JButton jBtSairHistorico;
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JButton jBtSalvarAvaliacaoI;
    private javax.swing.JButton jBtSalvarAvaliacaoII;
    private javax.swing.JButton jBtSalvarHistoricoEduca;
    private javax.swing.JButton jBtSalvarHistoricoLabor;
    private javax.swing.JButton jBtTodos1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBoxIntDom;
    private javax.swing.JCheckBox jCheckBoxIntQua;
    private javax.swing.JCheckBox jCheckBoxIntQui;
    private javax.swing.JCheckBox jCheckBoxIntSab;
    private javax.swing.JCheckBox jCheckBoxIntSeg;
    private javax.swing.JCheckBox jCheckBoxIntSex;
    private javax.swing.JCheckBox jCheckBoxIntTer;
    private javax.swing.JCheckBox jCheckBoxSFDom;
    private javax.swing.JCheckBox jCheckBoxSFQua;
    private javax.swing.JCheckBox jCheckBoxSFQui;
    private javax.swing.JCheckBox jCheckBoxSFSab;
    private javax.swing.JCheckBox jCheckBoxSFSeg;
    private javax.swing.JCheckBox jCheckBoxSFSex;
    private javax.swing.JCheckBox jCheckBoxSFTer;
    private javax.swing.JComboBox jComboBoxAIVD;
    private javax.swing.JComboBox jComboBoxAVD;
    private javax.swing.JComboBox jComboBoxAborto;
    private javax.swing.JComboBox jComboBoxAcreditaRealizacoes;
    private javax.swing.JComboBox jComboBoxAcreditoDiverteLazer;
    private javax.swing.JComboBox jComboBoxAcreditoRealizaLar;
    private javax.swing.JComboBox jComboBoxAcreditoRealizaTrabalho;
    private javax.swing.JComboBox jComboBoxAmputacao;
    private javax.swing.JComboBox jComboBoxAnsiedade;
    private javax.swing.JComboBox jComboBoxCancer;
    private javax.swing.JComboBox jComboBoxCognitiva;
    private javax.swing.JComboBox jComboBoxConcentroTrabalho;
    private javax.swing.JComboBox jComboBoxConhecoHabilidades;
    private javax.swing.JComboBox jComboBoxConsigoCasa;
    private javax.swing.JComboBox jComboBoxConsigoCotidianas;
    private javax.swing.JComboBox jComboBoxConsigoFinancas;
    private javax.swing.JComboBox jComboBoxConsigoHigiene;
    private javax.swing.JComboBox jComboBoxConsigoOutros;
    private javax.swing.JComboBox jComboBoxCostumoComprometo;
    private javax.swing.JComboBox jComboBoxCostumoFrequentar;
    private javax.swing.JComboBox jComboBoxCursoProfissionalizante;
    private javax.swing.JComboBox jComboBoxDeAmigo;
    private javax.swing.JComboBox jComboBoxDeEstudante;
    private javax.swing.JComboBox jComboBoxDeFamiliar;
    private javax.swing.JComboBox jComboBoxDeTrabalho;
    private javax.swing.JComboBox jComboBoxDeficienciaOcupa;
    private javax.swing.JComboBox jComboBoxDeficienciaVAF;
    private javax.swing.JComboBox jComboBoxDescricaoCurso;
    private javax.swing.JComboBox jComboBoxDesejaTrabalharUnid;
    private javax.swing.JComboBox jComboBoxDiabetes;
    private javax.swing.JComboBox jComboBoxDificultadeConcentrar;
    private javax.swing.JComboBox jComboBoxDoencasDigestivo;
    private javax.swing.JComboBox jComboBoxDominancia;
    private javax.swing.JComboBox jComboBoxEscreveProprioNome;
    private javax.swing.JComboBox jComboBoxEsperoResultados;
    private javax.swing.JComboBox jComboBoxEtilismo;
    private javax.swing.JComboBox jComboBoxEtilismoUsuario;
    private javax.swing.JComboBox jComboBoxExperienciaProfissional;
    private javax.swing.JComboBox jComboBoxFacoAtividades;
    private javax.swing.JComboBox jComboBoxFrustracao;
    private javax.swing.JComboBox jComboBoxGestante;
    private javax.swing.JComboBox jComboBoxHipertensao;
    private javax.swing.JComboBox jComboBoxHumor;
    private javax.swing.JComboBox jComboBoxIdentificoGostos;
    private javax.swing.JComboBox jComboBoxIdentificoProblemas;
    private javax.swing.JComboBox jComboBoxIdentificoSolucaoProblemas;
    private javax.swing.JComboBox jComboBoxInfectocontagiosa;
    private javax.swing.JComboBox jComboBoxInquietacao;
    private javax.swing.JComboBox jComboBoxInsonia;
    private javax.swing.JComboBox jComboBoxIntPsi;
    private javax.swing.JComboBox jComboBoxInteresseEstudar;
    private javax.swing.JComboBox jComboBoxIrritabilidade;
    private javax.swing.JComboBox jComboBoxLazer;
    private javax.swing.JComboBox jComboBoxMantenhoPapeis;
    private javax.swing.JComboBox jComboBoxMantenhoVida;
    private javax.swing.JComboBox jComboBoxMedicaoAlopatica;
    private javax.swing.JComboBox jComboBoxMedicaoAlopaticaUsuario;
    private javax.swing.JComboBox jComboBoxMetodoContraCeptivo;
    private javax.swing.JComboBox jComboBoxMotora;
    private javax.swing.JComboBox jComboBoxNivelInstrucao;
    private javax.swing.JComboBox jComboBoxOrganizoTempo;
    private javax.swing.JComboBox jComboBoxPaisVivos;
    private javax.swing.JComboBox jComboBoxParticipoProjetosImport;
    private javax.swing.JComboBox jComboBoxPlanejoAgir;
    private javax.swing.JComboBox jComboBoxPraticaAtividadeFisica;
    private javax.swing.JComboBox jComboBoxProRespiratorio;
    private javax.swing.JComboBox jComboBoxQualExperienciaProfissional;
    private javax.swing.JComboBox jComboBoxQualProfissao;
    private javax.swing.JComboBox jComboBoxQuandoAgir;
    private javax.swing.JComboBox jComboBoxRaiva;
    private javax.swing.JComboBox jComboBoxReabilitacao;
    private javax.swing.JComboBox jComboBoxReconhecoPapeis;
    private javax.swing.JComboBox jComboBoxSPA;
    private javax.swing.JComboBox jComboBoxSPAUsuario;
    private javax.swing.JComboBox jComboBoxSabeLerEscrever;
    private javax.swing.JComboBox jComboBoxSensorial;
    private javax.swing.JComboBox jComboBoxSintoPreciso;
    private javax.swing.JComboBox jComboBoxSouRotina;
    private javax.swing.JComboBox jComboBoxTabagismo;
    private javax.swing.JComboBox jComboBoxTabagismoUsuario;
    private javax.swing.JComboBox jComboBoxTemCompanheira;
    private javax.swing.JComboBox jComboBoxTemFilhos;
    private javax.swing.JComboBox jComboBoxTemProfissao;
    private javax.swing.JComboBox jComboBoxTenhoExpectativa;
    private javax.swing.JComboBox jComboBoxTenhoObjetoFuturo;
    private javax.swing.JComboBox jComboBoxTenhoSocial;
    private javax.swing.JComboBox jComboBoxTenhoVariosInteresse;
    private javax.swing.JComboBox jComboBoxTrabalho;
    private javax.swing.JComboBox jComboBoxTransMental;
    private javax.swing.JComboBox jComboBoxTrataPsicologico;
    private javax.swing.JComboBox jComboBoxVidaSexual;
    private javax.swing.JComboBox jComboBoxVisitaFamiliar;
    private javax.swing.JComboBox jComboBoxVisitaIntima;
    private com.toedter.calendar.JDateChooser jDataAplicacao;
    private com.toedter.calendar.JDateChooser jDataLanc;
    private com.toedter.calendar.JDateChooser jDataPesqFinal;
    private com.toedter.calendar.JDateChooser jDataPesqInicial;
    private javax.swing.JLabel jFotoInternoTerapia;
    private javax.swing.JTextField jIDPesqLanc;
    public static javax.swing.JTextField jIdADM_Principal;
    public static javax.swing.JTextField jIdAtendNovo;
    public static javax.swing.JTextField jIdInternoAD;
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
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JTextField jMotivoAborto;
    public static javax.swing.JTextField jNomeInternoAD;
    private javax.swing.JTextArea jObsDesempenhoOcupacional;
    private javax.swing.JTextArea jObsEstiloVida;
    private javax.swing.JTextArea jObsHistoricoFamiliar;
    private javax.swing.JTextArea jObsTriagemSPA;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel18;
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
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jQualAtividadeFisica;
    private javax.swing.JTextField jQualMetodoContraCeptivo;
    private javax.swing.JFormattedTextField jQuantoTabagismo;
    private javax.swing.JFormattedTextField jQuantosFilhos;
    private javax.swing.JRadioButton jRadioBtA;
    private javax.swing.JRadioButton jRadioBtAmbos;
    private javax.swing.JRadioButton jRadioBtB;
    private javax.swing.JRadioButton jRadioBtC;
    private javax.swing.JRadioButton jRadioBtNaoRemunerado;
    private javax.swing.JRadioButton jRadioBtRemunerado;
    private javax.swing.JTextField jResponsavelAplicacao;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextField jStatusLanc;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTabelaAtendimentoTerapia;
    private javax.swing.JTable jTabelaCursos_NOVO;
    private javax.swing.JTable jTabelaExperiencia;
    private javax.swing.JFormattedTextField jTipoEtilismo;
    private javax.swing.JFormattedTextField jTipoMedicaoAlopatica;
    private javax.swing.JFormattedTextField jTipoSPA;
    private javax.swing.JTextField jnomeInternoPesq;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void verificarPortaEntrada() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PORTA_ENTRADA "
                    + "WHERE IdInternoCrc='" + jIdInterno.getText() + "' "
                    + "AND PSPTer='" + deptoTecnico + "' "
                    + "AND HabTer='" + pHABILITA_TERAPIA + "'");
            conecta.rs.first();
            pINTERNOCRC = conecta.rs.getString("IdInternoCrc");
            pDEPARTAMENTO = conecta.rs.getString("PSPTer");
            pHABILITADO = conecta.rs.getString("HabTer");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void pesquisarInternoManual() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "INNER JOIN DADOSFISICOSINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSFISICOSINTERNOS.IdInternoCrc "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "INNER JOIN ATENDIMENTOTERAPIA "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ATENDIMENTOTERAPIA.IdInternoCrc "
                    + "WHERE PRONTUARIOSCRC.SituacaoCrc='" + situacao + "' "
                    + "AND ATENDIMENTOTERAPIA.IdInternoCrc='" + jIdInterno.getText() + " '"
                    + "OR PRONTUARIOSCRC.SituacaoCrc='" + sitRetorno + "' "
                    + "AND ATENDIMENTOTERAPIA.IdInternoCrc='" + jIdInterno.getText() + "'");
            conecta.rs.first();
            jIdADM_Principal.setText(String.valueOf(conecta.rs.getInt("IdLanc")));
            // VARIÁVEL QUE NÃO DEIXA MUDAR O INTERNO SE EXISTIR ANAMNESES OU ATESTADO, DIETA E OUTROS.
            codInterno = conecta.rs.getString("IdInternoCrc");
            nomeInternoAnterior = conecta.rs.getString("NomeInternoCrc");
            jIdInternoAD.setText(conecta.rs.getString("IdInternoCrc"));
            jNomeInternoAD.setText(conecta.rs.getString("NomeInternoCrc"));
            // Capturando foto
            caminho = conecta.rs.getString("FotoInternoCrc");
            if (caminho != null) {
                javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                jFotoInternoTerapia.setIcon(i);
                jFotoInternoTerapia.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoInternoTerapia.getWidth(), jFotoInternoTerapia.getHeight(), Image.SCALE_SMOOTH)));
            }
            // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
            byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrente"));
            if (imgBytes != null) {
                ImageIcon pic = null;
                pic = new ImageIcon(imgBytes);
                Image scaled = pic.getImage().getScaledInstance(jFotoInternoTerapia.getWidth(), jFotoInternoTerapia.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(scaled);
                jFotoInternoTerapia.setIcon(icon);
            }
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void pesquisarInternoColaboradorBiometria() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM REGISTRO_ATENDIMENTO_INTERNO_PSP "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON REGISTRO_ATENDIMENTO_INTERNO_PSP.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN DADOSFISICOSINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSFISICOSINTERNOS.IdInternoCrc "
                    + "INNER JOIN PAISES ON PRONTUARIOSCRC.IdPais=PAISES.IdPais "
                    + "INNER JOIN CIDADES "
                    + "ON PRONTUARIOSCRC.IdCidade=CIDADES.IdCidade "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "INNER JOIN UNIDADE "
                    + "ON DADOSPENAISINTERNOS.IdUnid=UNIDADE.IdUnid "
                    + "WHERE REGISTRO_ATENDIMENTO_INTERNO_PSP.IdInternoCrc='" + jIdInterno.getText() + "' "
                    + "AND SituacaoCrc='" + situacao + "' "
                    + "AND Atendido='" + pATENDIDO_PESQUISA + "' "
                    + "AND IdDepartamento='" + codigoDepartamento + "' "
                    + "OR REGISTRO_ATENDIMENTO_INTERNO_PSP.IdInternoCrc='" + jIdInterno.getText() + "' "
                    + "AND SituacaoCrc='" + sitRetorno + "' "
                    + "AND Atendido='" + pATENDIDO_PESQUISA + "' "
                    + "AND IdDepartamento='" + codigoDepartamento + "'");
            conecta.rs.first();
            jIdADM_Principal.setText(jIdAtend.getText());
            // VARIÁVEL QUE NÃO DEIXA MUDAR O INTERNO SE EXISTIR ANAMNESES OU ATESTADO, DIETA E OUTROS.
            codInterno = conecta.rs.getString("IdInternoCrc");
            nomeInternoAnterior = conecta.rs.getString("NomeInternoCrc");
            jIdInternoAD.setText(conecta.rs.getString("IdInternoCrc"));
            jNomeInternoAD.setText(conecta.rs.getString("NomeInternoCrc"));
            // Capturando foto
            caminho = conecta.rs.getString("FotoInternoCrc");
            if (caminho != null) {
                javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                jFotoInternoTerapia.setIcon(i);
                jFotoInternoTerapia.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoInternoTerapia.getWidth(), jFotoInternoTerapia.getHeight(), Image.SCALE_SMOOTH)));
            }
            // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
            byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrente"));
            if (imgBytes != null) {
                ImageIcon pic = null;
                pic = new ImageIcon(imgBytes);
                Image scaled = pic.getImage().getScaledInstance(jFotoInternoTerapia.getWidth(), jFotoInternoTerapia.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(scaled);
                jFotoInternoTerapia.setIcon(icon);
            }
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarRegistroBiometria() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PARAMETROSCRC");
            conecta.rs.first();
            pHabilitaTO = conecta.rs.getString("AdmissaoTO");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void procurarDepartamento() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM DEPARTAMENTOS "
                    + "WHERE NomeDepartamento='" + nomeModuloTO + "'");
            conecta.rs.first();
            codigoDepartamento = conecta.rs.getInt("IdDepartamento");
            codigoDepartamentoTO_SEC = conecta.rs.getInt("IdDepartamento");
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
                    + "WHERE IdInternoCrc='" + jIdInternoAD.getText() + "' "
                    + "AND Atendido='" + opcao + "'");
            conecta.rs.first();
            codigoInternoAtend = conecta.rs.getString("IdInternoCrc");
            codigoDepartamentoTO = conecta.rs.getInt("IdDepartamento");
            atendido = conecta.rs.getString("Atendido");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void formataCampos() {
        jQuantosFilhos.setDocument(new LimiteDigitosNum(4));
        jQuantoTabagismo.setDocument(new LimiteDigitosNum(4));
        jTipoEtilismo.setDocument(new LimiteDigitosAlfa(32));
        jTipoMedicaoAlopatica.setDocument(new LimiteDigitosAlfa(32));
        jTipoSPA.setDocument(new LimiteDigitosAlfa(32));
        jQualMetodoContraCeptivo.setDocument(new LimiteDigitosAlfa(32));
        jMotivoAborto.setDocument(new LimiteDigitosAlfa(42));
        jQualAtividadeFisica.setDocument(new LimiteDigitosAlfa(42));
        //
        jObsDesempenhoOcupacional.setLineWrap(true);
        jObsDesempenhoOcupacional.setWrapStyleWord(true);
        //
        jObsHistoricoFamiliar.setLineWrap(true);
        jObsHistoricoFamiliar.setWrapStyleWord(true);
        //
        ObsDadosClinicos.setLineWrap(true);
        ObsDadosClinicos.setWrapStyleWord(true);
        //
        jObsTriagemSPA.setLineWrap(true);
        jObsTriagemSPA.setWrapStyleWord(true);
        //
        jObsEstiloVida.setWrapStyleWord(true);
        jObsEstiloVida.setLineWrap(true);
        //
        ObsAlteracoesPsicologicas.setLineWrap(true);
        ObsAlteracoesPsicologicas.setWrapStyleWord(true);
    }

    public void corCampos() {
        jIdADM_Principal.setBackground(Color.white);
        jIdAtendNovo.setBackground(Color.white);
        jStatusLanc.setBackground(Color.white);
        jDataLanc.setBackground(Color.white);
        jIdInternoAD.setBackground(Color.white);
        jNomeInternoAD.setBackground(Color.white);
        //
        jQuantosFilhos.setBackground(Color.white);
        jQuantoTabagismo.setBackground(Color.white);
        jTipoEtilismo.setBackground(Color.white);
        jTipoMedicaoAlopatica.setBackground(Color.white);
        jTipoSPA.setBackground(Color.white);
        jQualMetodoContraCeptivo.setBackground(Color.white);
        jMotivoAborto.setBackground(Color.white);
        jQualAtividadeFisica.setBackground(Color.white);
        jObsDesempenhoOcupacional.setBackground(Color.white);
        jObsHistoricoFamiliar.setBackground(Color.white);
        ObsDadosClinicos.setBackground(Color.white);
        jComboBoxInteresseEstudar.setBackground(Color.white);
        jObsTriagemSPA.setBackground(Color.white);
        jObsEstiloVida.setBackground(Color.white);
        ObsAlteracoesPsicologicas.setBackground(Color.white);
    }

    public void bloquearCampos() {
        // ABA MAUTENÇÃO
        jDataLanc.setEnabled(!true);
        //DESEMPENHO OCUPACIONAL
        jComboBoxDominancia.setEnabled(!true);
        jComboBoxAmputacao.setEnabled(!true);
        jComboBoxDeficienciaOcupa.setEnabled(!true);
        jComboBoxReabilitacao.setEnabled(!true);
        jComboBoxMotora.setEnabled(!true);
        jComboBoxCognitiva.setEnabled(!true);
        jComboBoxSensorial.setEnabled(!true);
        jComboBoxIntPsi.setEnabled(!true);
        jComboBoxAVD.setEnabled(!true);
        jComboBoxAIVD.setEnabled(!true);
        jComboBoxLazer.setEnabled(!true);
        jComboBoxTrabalho.setEnabled(!true);
        jObsDesempenhoOcupacional.setEnabled(!true);
        jComboBoxPaisVivos.setEnabled(!true);
        jComboBoxTemCompanheira.setEnabled(!true);
        jComboBoxTemFilhos.setEnabled(!true);
        jQuantosFilhos.setEnabled(!true);
        jComboBoxVisitaFamiliar.setEnabled(!true);
        jCheckBoxSFSeg.setEnabled(!true);
        jCheckBoxSFTer.setEnabled(!true);
        jCheckBoxSFQua.setEnabled(!true);
        jCheckBoxSFQui.setEnabled(!true);
        jCheckBoxSFSex.setEnabled(!true);
        jCheckBoxSFSab.setEnabled(!true);
        jCheckBoxSFDom.setEnabled(!true);
        jComboBoxVisitaIntima.setEnabled(!true);
        jCheckBoxIntSeg.setEnabled(!true);
        jCheckBoxIntTer.setEnabled(!true);
        jCheckBoxIntQua.setEnabled(!true);
        jCheckBoxIntQui.setEnabled(!true);
        jCheckBoxIntSex.setEnabled(!true);
        jCheckBoxIntSab.setEnabled(!true);
        jCheckBoxIntDom.setEnabled(!true);
        jObsHistoricoFamiliar.setEnabled(!true);
        // DADOS CLINICOS
        jComboBoxHipertensao.setEnabled(!true);
        jComboBoxDiabetes.setEnabled(!true);
        jComboBoxCancer.setEnabled(!true);
        jComboBoxProRespiratorio.setEnabled(!true);
        jComboBoxTransMental.setEnabled(!true);
        jComboBoxInfectocontagiosa.setEnabled(!true);
        jComboBoxDoencasDigestivo.setEnabled(!true);
        jComboBoxDeficienciaVAF.setEnabled(!true);
        ObsDadosClinicos.setEnabled(!true);
        //ALTERAÇÕES PSICOLOGICAS
        jComboBoxHumor.setEnabled(!true);
        jComboBoxInsonia.setEnabled(!true);
        jComboBoxIrritabilidade.setEnabled(!true);
        jComboBoxFrustracao.setEnabled(!true);
        jComboBoxDificultadeConcentrar.setEnabled(!true);
        jComboBoxRaiva.setEnabled(!true);
        jComboBoxInquietacao.setEnabled(!true);
        jComboBoxAnsiedade.setEnabled(!true);
        ObsAlteracoesPsicologicas.setEnabled(!true);
        // DESEMPENHO OCUPACIONAL
        jComboBoxDominancia.setEnabled(!true);
        jComboBoxAmputacao.setEnabled(!true);
        jComboBoxDeficienciaOcupa.setEnabled(!true);
        jComboBoxReabilitacao.setEnabled(!true);
        jComboBoxMotora.setEnabled(!true);
        jComboBoxCognitiva.setEnabled(!true);
        jComboBoxSensorial.setEnabled(!true);
        jComboBoxIntPsi.setEnabled(!true);
        jComboBoxAVD.setEnabled(!true);
        jComboBoxAIVD.setEnabled(!true);
        jComboBoxLazer.setEnabled(!true);
        jComboBoxTrabalho.setEnabled(!true);
        jObsDesempenhoOcupacional.setEnabled(!true);
        // QUALIDADE DE VIDA (TRIAGEM SPA)
        jComboBoxTabagismo.setEnabled(!true);
        jQuantoTabagismo.setEnabled(!true);
        jComboBoxTabagismoUsuario.setEnabled(!true);
        jComboBoxEtilismo.setEnabled(!true);
        jTipoEtilismo.setEnabled(!true);
        jComboBoxEtilismoUsuario.setEnabled(!true);
        jComboBoxMedicaoAlopatica.setEnabled(!true);
        jTipoMedicaoAlopatica.setEnabled(!true);
        jComboBoxMedicaoAlopaticaUsuario.setEnabled(!true);
        jComboBoxSPA.setEnabled(!true);
        jTipoSPA.setEnabled(!true);
        jComboBoxSPAUsuario.setEnabled(!true);
        jObsTriagemSPA.setEnabled(!true);
        // QUALIDADE DE VIDA (ESTILO DE VIDA)
        jComboBoxVidaSexual.setEnabled(!true);
        jComboBoxMetodoContraCeptivo.setEnabled(!true);
        jQualMetodoContraCeptivo.setEnabled(!true);
        jComboBoxGestante.setEnabled(!true);
        jComboBoxAborto.setEnabled(!true);
        jMotivoAborto.setEnabled(!true);
        jComboBoxPraticaAtividadeFisica.setEnabled(!true);
        jQualAtividadeFisica.setEnabled(!true);
        jComboBoxTrataPsicologico.setEnabled(!true);
        jObsEstiloVida.setEnabled(!true);
        // HISTÓRICO EDUCACIONAL
        jComboBoxEscreveProprioNome.setEnabled(!true);
        jComboBoxSabeLerEscrever.setEnabled(!true);
        jComboBoxNivelInstrucao.setEnabled(!true);
        jComboBoxInteresseEstudar.setEnabled(!true);
        jComboBoxCursoProfissionalizante.setEnabled(!true);
        jComboBoxDescricaoCurso.setEnabled(!true);
        jRadioBtA.setEnabled(!true);
        jRadioBtB.setEnabled(!true);
        jRadioBtC.setEnabled(!true);
        // HISTORICO PROFISSIONAL (LABORATIVO)
        jComboBoxTemProfissao.setEnabled(!true);
        jComboBoxQualProfissao.setEnabled(!true);
        jComboBoxExperienciaProfissional.setEnabled(!true);
        jComboBoxQualExperienciaProfissional.setEnabled(!true);
        jComboBoxDesejaTrabalharUnid.setEnabled(!true);
        //
        jRadioBtRemunerado.setEnabled(!true);
        jRadioBtNaoRemunerado.setEnabled(!true);
        jRadioBtAmbos.setEnabled(!true);
        //
        jBtIncluirExperiencia.setEnabled(!true);
        jBtExcluirExperiencia.setEnabled(!true);
        // AVALIAÇÃO I
        jComboBoxConhecoHabilidades.setEnabled(!true);
        jComboBoxAcreditaRealizacoes.setEnabled(!true);
        jComboBoxEsperoResultados.setEnabled(!true);
        jComboBoxAcreditoRealizaTrabalho.setEnabled(!true);
        jComboBoxAcreditoRealizaLar.setEnabled(!true);
        jComboBoxAcreditoDiverteLazer.setEnabled(!true);
        jComboBoxFacoAtividades.setEnabled(!true);
        jComboBoxTenhoExpectativa.setEnabled(!true);
        jComboBoxTenhoObjetoFuturo.setEnabled(!true);
        jComboBoxIdentificoGostos.setEnabled(!true);
        jComboBoxParticipoProjetosImport.setEnabled(!true);
        jComboBoxTenhoVariosInteresse.setEnabled(!true);
        jComboBoxCostumoComprometo.setEnabled(!true);
        jComboBoxDeEstudante.setEnabled(!true);
        jComboBoxDeTrabalho.setEnabled(!true);
        jComboBoxDeAmigo.setEnabled(!true);
        jComboBoxDeFamiliar.setEnabled(!true);
        jComboBoxReconhecoPapeis.setEnabled(!true);
        jComboBoxMantenhoVida.setEnabled(!true);
        // AVALIAÇÃO II
        jComboBoxConhecoHabilidades.setEnabled(!true);
        jComboBoxOrganizoTempo.setEnabled(!true);
        jComboBoxMantenhoPapeis.setEnabled(!true);
        jComboBoxSouRotina.setEnabled(!true);
        jComboBoxConsigoOutros.setEnabled(!true);
        jComboBoxTenhoSocial.setEnabled(!true);
        jComboBoxPlanejoAgir.setEnabled(!true);
        jComboBoxConcentroTrabalho.setEnabled(!true);
        jComboBoxIdentificoProblemas.setEnabled(!true);
        jComboBoxIdentificoSolucaoProblemas.setEnabled(!true);
        jComboBoxQuandoAgir.setEnabled(!true);
        jComboBoxConsigoHigiene.setEnabled(!true);
        jComboBoxConsigoCasa.setEnabled(!true);
        jComboBoxConsigoCotidianas.setEnabled(!true);
        jComboBoxConsigoFinancas.setEnabled(!true);
        jComboBoxSintoPreciso.setEnabled(!true);
        jComboBoxCostumoFrequentar.setEnabled(!true);
        jDataAplicacao.setEnabled(!true);
        jResponsavelAplicacao.setEnabled(!true);
    }

    public void Novo() {
        // Limpara campos
        jIdAtendNovo.setText("");
        jStatusLanc.setText("ABERTO");
        jDataLanc.setCalendar(Calendar.getInstance());
        jIdInternoAD.setText("");
        jFotoInternoTerapia.setIcon(null);
        jNomeInternoAD.setText("");
        jFotoInternoTerapia.setIcon(null);
        //DESEMPENHO OCUPACIONAL
        jComboBoxDominancia.setSelectedItem("Destro");
        jComboBoxAmputacao.setSelectedItem("Não");
        jComboBoxDeficienciaOcupa.setSelectedItem("Não");
        jComboBoxReabilitacao.setSelectedItem("Não");
        jComboBoxMotora.setSelectedItem("Não");
        jComboBoxCognitiva.setSelectedItem("Não");
        jComboBoxSensorial.setSelectedItem("Não");
        jComboBoxIntPsi.setSelectedItem("Não");
        jComboBoxAVD.setSelectedItem("Não");
        jComboBoxAIVD.setSelectedItem("Não");
        jComboBoxLazer.setSelectedItem("Não");
        jComboBoxTrabalho.setSelectedItem("Não");
        jObsDesempenhoOcupacional.setText("DIGITE AQUI A EVOLUÇÃO DA ADMISSÃO.");
        // HISTÓRICO FAMILIAR
        jComboBoxPaisVivos.setSelectedItem("Não");
        jComboBoxTemCompanheira.setSelectedItem("Não");
        jComboBoxTemFilhos.setSelectedItem("Não");
        jQuantosFilhos.setText("0");
        jComboBoxVisitaFamiliar.setSelectedItem("Não");
        jCheckBoxSFSeg.setSelected(!true);
        jCheckBoxSFTer.setSelected(!true);
        jCheckBoxSFQua.setSelected(!true);
        jCheckBoxSFQui.setSelected(!true);
        jCheckBoxSFSex.setSelected(!true);
        jCheckBoxSFSab.setSelected(!true);
        jCheckBoxSFDom.setSelected(!true);
        jComboBoxVisitaIntima.setSelectedItem("Não");
        jCheckBoxIntSeg.setSelected(!true);
        jCheckBoxIntTer.setSelected(!true);
        jCheckBoxIntQua.setSelected(!true);
        jCheckBoxIntQui.setSelected(!true);
        jCheckBoxIntSex.setSelected(!true);
        jCheckBoxIntSab.setSelected(!true);
        jCheckBoxIntDom.setSelected(!true);
        jObsHistoricoFamiliar.setText("");
        // DADOS CLINICOS
        jComboBoxHipertensao.setSelectedItem("Não");
        jComboBoxDiabetes.setSelectedItem("Não");
        jComboBoxCancer.setSelectedItem("Não");
        jComboBoxProRespiratorio.setSelectedItem("Não");
        jComboBoxTransMental.setSelectedItem("Não");
        jComboBoxInfectocontagiosa.setSelectedItem("Não");
        jComboBoxDoencasDigestivo.setSelectedItem("Não");
        jComboBoxDeficienciaVAF.setSelectedItem("Não");
        ObsDadosClinicos.setText("");
        //ALTERAÇÕES PSICOLOGICAS
        jComboBoxHumor.setSelectedItem("Não");
        jComboBoxInsonia.setSelectedItem("Não");
        jComboBoxIrritabilidade.setSelectedItem("Não");
        jComboBoxFrustracao.setSelectedItem("Não");
        jComboBoxDificultadeConcentrar.setSelectedItem("Não");
        jComboBoxRaiva.setSelectedItem("Não");
        jComboBoxInquietacao.setSelectedItem("Não");
        jComboBoxAnsiedade.setSelectedItem("Não");
        ObsAlteracoesPsicologicas.setText("");
        // DESEMPENHO OCUPACIONAL
        jComboBoxDominancia.setSelectedItem("Não");
        jComboBoxAmputacao.setSelectedItem("Não");
        jComboBoxDeficienciaOcupa.setSelectedItem("Não");
        jComboBoxReabilitacao.setSelectedItem("Não");
        jComboBoxMotora.setSelectedItem("Não");
        jComboBoxCognitiva.setSelectedItem("Não");
        jComboBoxSensorial.setSelectedItem("Não");
        jComboBoxIntPsi.setSelectedItem("Não");
        jComboBoxAVD.setSelectedItem("Não");
        jComboBoxAIVD.setSelectedItem("Não");
        jComboBoxLazer.setSelectedItem("Não");
        jComboBoxTrabalho.setSelectedItem("Não");
        jObsDesempenhoOcupacional.setText("");
        // QUALIDADE DE VIDA (TRIAGEM SPA)
        jComboBoxTabagismo.setSelectedItem("Não");
        jQuantoTabagismo.setText("0");
        jComboBoxTabagismoUsuario.setSelectedItem("Nao");
        jComboBoxEtilismo.setSelectedItem("Não");
        jTipoEtilismo.setText("");
        jComboBoxEtilismoUsuario.setSelectedItem("Não");
        jComboBoxMedicaoAlopatica.setSelectedItem("Não");
        jTipoMedicaoAlopatica.setText("");
        jComboBoxMedicaoAlopaticaUsuario.setSelectedItem("Não");
        jComboBoxSPA.setSelectedItem("Não");
        jTipoSPA.setText("");
        jComboBoxSPAUsuario.setSelectedItem("Não");
        jObsTriagemSPA.setText("");
        // QUALIDADE DE VIDA (ESTILO DE VIDA)
        jComboBoxVidaSexual.setSelectedItem("Não");
        jComboBoxMetodoContraCeptivo.setSelectedItem("Não");
        jQualMetodoContraCeptivo.setText("");
        jComboBoxGestante.setSelectedItem("Não");
        jComboBoxAborto.setSelectedItem("Não");
        jMotivoAborto.setText("");
        jComboBoxPraticaAtividadeFisica.setSelectedItem("Não");
        jQualAtividadeFisica.setText("");
        jComboBoxTrataPsicologico.setSelectedItem("Não");
        jObsEstiloVida.setText("");
        // Habilitar/Desabilitar campos               
        jDataLanc.setEnabled(true);
        //DESEMPENHO OCUPACIONAL
        jComboBoxDominancia.setEnabled(true);
        jComboBoxAmputacao.setEnabled(true);
        jComboBoxDeficienciaOcupa.setEnabled(true);
        jComboBoxReabilitacao.setEnabled(true);
        jComboBoxMotora.setEnabled(true);
        jComboBoxCognitiva.setEnabled(true);
        jComboBoxSensorial.setEnabled(true);
        jComboBoxIntPsi.setEnabled(true);
        jComboBoxAVD.setEnabled(true);
        jComboBoxAIVD.setEnabled(true);
        jComboBoxLazer.setEnabled(true);
        jComboBoxTrabalho.setEnabled(true);
        jObsDesempenhoOcupacional.setEnabled(true);
        // HISTÓRICO FAMILIAR
        jComboBoxPaisVivos.setEnabled(true);
        jComboBoxTemCompanheira.setEnabled(true);
        jComboBoxTemFilhos.setEnabled(true);
        jQuantosFilhos.setEnabled(true);
        jComboBoxVisitaFamiliar.setEnabled(true);
        jCheckBoxSFSeg.setEnabled(true);
        jCheckBoxSFTer.setEnabled(true);
        jCheckBoxSFQua.setEnabled(true);
        jCheckBoxSFQui.setEnabled(true);
        jCheckBoxSFSex.setEnabled(true);
        jCheckBoxSFSab.setEnabled(true);
        jCheckBoxSFDom.setEnabled(true);
        jComboBoxVisitaIntima.setEnabled(true);
        jCheckBoxIntSeg.setEnabled(true);
        jCheckBoxIntTer.setEnabled(true);
        jCheckBoxIntQua.setEnabled(true);
        jCheckBoxIntQui.setEnabled(true);
        jCheckBoxIntSex.setEnabled(true);
        jCheckBoxIntSab.setEnabled(true);
        jCheckBoxIntDom.setEnabled(true);
        jObsHistoricoFamiliar.setEnabled(true);
        // DADOS CLINICOS
        jComboBoxHipertensao.setEnabled(true);
        jComboBoxDiabetes.setEnabled(true);
        jComboBoxCancer.setEnabled(true);
        jComboBoxProRespiratorio.setEnabled(true);
        jComboBoxTransMental.setEnabled(true);
        jComboBoxInfectocontagiosa.setEnabled(true);
        jComboBoxDoencasDigestivo.setEnabled(true);
        jComboBoxDeficienciaVAF.setEnabled(true);
        ObsDadosClinicos.setEnabled(true);
        //ALTERAÇÕES PSICOLOGICAS
        jComboBoxHumor.setEnabled(true);
        jComboBoxInsonia.setEnabled(true);
        jComboBoxIrritabilidade.setEnabled(true);
        jComboBoxFrustracao.setEnabled(true);
        jComboBoxDificultadeConcentrar.setEnabled(true);
        jComboBoxRaiva.setEnabled(true);
        jComboBoxInquietacao.setEnabled(true);
        jComboBoxAnsiedade.setEnabled(true);
        ObsAlteracoesPsicologicas.setEnabled(true);
        // DESEMPENHO OCUPACIONAL
        jComboBoxDominancia.setEnabled(true);
        jComboBoxAmputacao.setEnabled(true);
        jComboBoxDeficienciaOcupa.setEnabled(true);
        jComboBoxReabilitacao.setEnabled(true);
        jComboBoxMotora.setEnabled(true);
        jComboBoxCognitiva.setEnabled(true);
        jComboBoxSensorial.setEnabled(true);
        jComboBoxIntPsi.setEnabled(true);
        jComboBoxAVD.setEnabled(true);
        jComboBoxAIVD.setEnabled(true);
        jComboBoxLazer.setEnabled(true);
        jComboBoxTrabalho.setEnabled(true);
        jObsDesempenhoOcupacional.setEnabled(true);
        // QUALIDADE DE VIDA (TRIAGEM SPA)
        jComboBoxTabagismo.setEnabled(true);
        jQuantoTabagismo.setEnabled(true);
        jComboBoxTabagismoUsuario.setEnabled(true);
        jComboBoxEtilismo.setEnabled(true);
        jTipoEtilismo.setEnabled(true);
        jComboBoxEtilismoUsuario.setEnabled(true);
        jComboBoxMedicaoAlopatica.setEnabled(true);
        jTipoMedicaoAlopatica.setEnabled(true);
        jComboBoxMedicaoAlopaticaUsuario.setEnabled(true);
        jComboBoxSPA.setEnabled(true);
        jTipoSPA.setEnabled(true);
        jComboBoxSPAUsuario.setEnabled(true);
        jObsTriagemSPA.setEnabled(true);
        // QUALIDADE DE VIDA (ESTILO DE VIDA)
        jComboBoxVidaSexual.setEnabled(true);
        jComboBoxMetodoContraCeptivo.setEnabled(true);
        jQualMetodoContraCeptivo.setEnabled(true);
        jComboBoxGestante.setEnabled(true);
        jComboBoxAborto.setEnabled(true);
        jMotivoAborto.setEnabled(true);
        jComboBoxPraticaAtividadeFisica.setEnabled(true);
        jQualAtividadeFisica.setEnabled(true);
        jComboBoxTrataPsicologico.setEnabled(true);
        jObsEstiloVida.setEnabled(true);
        // MANUTENÇÃO
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(!true);
        jBtImpressao.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        // HISTORICO EDUCACIONAL
        jBtNovoHistoricoEduca.setEnabled(!true);
        jBtAlterarHistoricoEduca.setEnabled(!true);
        jBtExcluirHistoricoEduca.setEnabled(!true);
        jBtSalvarHistoricoEduca.setEnabled(!true);
        jBtCancelarHistoricoEduca.setEnabled(!true);
        jBtAuditoriaHistoricoEduca.setEnabled(!true);
        // HISTÓRICO LABORATIVO
        jBtNovoHistoricoLabor.setEnabled(!true);
        jBtAlterarHistoricoLabor.setEnabled(!true);
        jBtExcluirHistoricoLabor.setEnabled(!true);
        jBtSalvarHistoricoLabor.setEnabled(!true);
        jBtCancelarHistoricoLabor.setEnabled(!true);
        jBtAuditoriaHistoricoLabor.setEnabled(!true);
        // AVALIAÇÃO I
        jBtNovoAvaliacaoI.setEnabled(!true);
        jBtAlterarAvaliacaoI.setEnabled(!true);
        jBtExcluirAvaliacaoI.setEnabled(!true);
        jBtSalvarAvaliacaoI.setEnabled(!true);
        jBtCancelarAvaliacaoI.setEnabled(!true);
        jBtAuditoriaAvaliacaoI.setEnabled(!true);
        // AVALIAÇÃO II
        jBtNovoAvaliacaoII.setEnabled(!true);
        jBtAlterarAvaliacaoII.setEnabled(!true);
        jBtExcluirAvaliacaoII.setEnabled(!true);
        jBtSalvarAvaliacaoII.setEnabled(!true);
        jBtCancelarAvaliacaoII.setEnabled(!true);
        jBtAuditoriaAvaliacaoII.setEnabled(!true);
    }

    public void Alterar() {
        // Habilitar/Desabilitar campos               
        jDataLanc.setEnabled(true);
        //DESEMPENHO OCUPACIONAL
        jComboBoxDominancia.setEnabled(true);
        jComboBoxAmputacao.setEnabled(true);
        jComboBoxDeficienciaOcupa.setEnabled(true);
        jComboBoxReabilitacao.setEnabled(true);
        jComboBoxMotora.setEnabled(true);
        jComboBoxCognitiva.setEnabled(true);
        jComboBoxSensorial.setEnabled(true);
        jComboBoxIntPsi.setEnabled(true);
        jComboBoxAVD.setEnabled(true);
        jComboBoxAIVD.setEnabled(true);
        jComboBoxLazer.setEnabled(true);
        jComboBoxTrabalho.setEnabled(true);
        jObsDesempenhoOcupacional.setEnabled(true);
        // HISTÓRICO FAMILIAR
        jComboBoxPaisVivos.setEnabled(true);
        jComboBoxTemCompanheira.setEnabled(true);
        jComboBoxTemFilhos.setEnabled(true);
        jQuantosFilhos.setEnabled(true);
        jComboBoxVisitaFamiliar.setEnabled(true);
        jCheckBoxSFSeg.setEnabled(true);
        jCheckBoxSFTer.setEnabled(true);
        jCheckBoxSFQua.setEnabled(true);
        jCheckBoxSFQui.setEnabled(true);
        jCheckBoxSFSex.setEnabled(true);
        jCheckBoxSFSab.setEnabled(true);
        jCheckBoxSFDom.setEnabled(true);
        jComboBoxVisitaIntima.setEnabled(true);
        jCheckBoxIntSeg.setEnabled(true);
        jCheckBoxIntTer.setEnabled(true);
        jCheckBoxIntQua.setEnabled(true);
        jCheckBoxIntQui.setEnabled(true);
        jCheckBoxIntSex.setEnabled(true);
        jCheckBoxIntSab.setEnabled(true);
        jCheckBoxIntDom.setEnabled(true);
        jObsHistoricoFamiliar.setEnabled(true);
        // DADOS CLINICOS
        jComboBoxHipertensao.setEnabled(true);
        jComboBoxDiabetes.setEnabled(true);
        jComboBoxCancer.setEnabled(true);
        jComboBoxProRespiratorio.setEnabled(true);
        jComboBoxTransMental.setEnabled(true);
        jComboBoxInfectocontagiosa.setEnabled(true);
        jComboBoxDoencasDigestivo.setEnabled(true);
        jComboBoxDeficienciaVAF.setEnabled(true);
        ObsDadosClinicos.setEnabled(true);
        //ALTERAÇÕES PSICOLOGICAS
        jComboBoxHumor.setEnabled(true);
        jComboBoxInsonia.setEnabled(true);
        jComboBoxIrritabilidade.setEnabled(true);
        jComboBoxFrustracao.setEnabled(true);
        jComboBoxDificultadeConcentrar.setEnabled(true);
        jComboBoxRaiva.setEnabled(true);
        jComboBoxInquietacao.setEnabled(true);
        jComboBoxAnsiedade.setEnabled(true);
        ObsAlteracoesPsicologicas.setEnabled(true);
        // DESEMPENHO OCUPACIONAL
        jComboBoxDominancia.setEnabled(true);
        jComboBoxAmputacao.setEnabled(true);
        jComboBoxDeficienciaOcupa.setEnabled(true);
        jComboBoxReabilitacao.setEnabled(true);
        jComboBoxMotora.setEnabled(true);
        jComboBoxCognitiva.setEnabled(true);
        jComboBoxSensorial.setEnabled(true);
        jComboBoxIntPsi.setEnabled(true);
        jComboBoxAVD.setEnabled(true);
        jComboBoxAIVD.setEnabled(true);
        jComboBoxLazer.setEnabled(true);
        jComboBoxTrabalho.setEnabled(true);
        jObsDesempenhoOcupacional.setEnabled(true);
        // QUALIDADE DE VIDA (TRIAGEM SPA)
        jComboBoxTabagismo.setEnabled(true);
        jQuantoTabagismo.setEnabled(true);
        jComboBoxTabagismoUsuario.setEnabled(true);
        jComboBoxEtilismo.setEnabled(true);
        jTipoEtilismo.setEnabled(true);
        jComboBoxEtilismoUsuario.setEnabled(true);
        jComboBoxMedicaoAlopatica.setEnabled(true);
        jTipoMedicaoAlopatica.setEnabled(true);
        jComboBoxMedicaoAlopaticaUsuario.setEnabled(true);
        jComboBoxSPA.setEnabled(true);
        jTipoSPA.setEnabled(true);
        jComboBoxSPAUsuario.setEnabled(true);
        jObsTriagemSPA.setEnabled(true);
        // QUALIDADE DE VIDA (ESTILO DE VIDA)
        jComboBoxVidaSexual.setEnabled(true);
        jComboBoxMetodoContraCeptivo.setEnabled(true);
        jQualMetodoContraCeptivo.setEnabled(true);
        jComboBoxGestante.setEnabled(true);
        jComboBoxAborto.setEnabled(true);
        jMotivoAborto.setEnabled(true);
        jComboBoxPraticaAtividadeFisica.setEnabled(true);
        jQualAtividadeFisica.setEnabled(true);
        jComboBoxTrataPsicologico.setEnabled(true);
        jObsEstiloVida.setEnabled(true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(!true);
        jBtImpressao.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        // HISTORICO EDUCACIONAL
        jBtNovoHistoricoEduca.setEnabled(!true);
        jBtAlterarHistoricoEduca.setEnabled(!true);
        jBtExcluirHistoricoEduca.setEnabled(!true);
        jBtSalvarHistoricoEduca.setEnabled(!true);
        jBtCancelarHistoricoEduca.setEnabled(!true);
        jBtAuditoriaHistoricoEduca.setEnabled(!true);
        // HISTÓRICO LABORATIVO
        jBtNovoHistoricoLabor.setEnabled(!true);
        jBtAlterarHistoricoLabor.setEnabled(!true);
        jBtExcluirHistoricoLabor.setEnabled(!true);
        jBtSalvarHistoricoLabor.setEnabled(!true);
        jBtCancelarHistoricoLabor.setEnabled(!true);
        jBtAuditoriaHistoricoLabor.setEnabled(!true);
        // AVALIAÇÃO I
        jBtNovoAvaliacaoI.setEnabled(!true);
        jBtAlterarAvaliacaoI.setEnabled(!true);
        jBtExcluirAvaliacaoI.setEnabled(!true);
        jBtSalvarAvaliacaoI.setEnabled(!true);
        jBtCancelarAvaliacaoI.setEnabled(!true);
        jBtAuditoriaAvaliacaoI.setEnabled(!true);
        // AVALIAÇÃO II
        jBtNovoAvaliacaoII.setEnabled(!true);
        jBtAlterarAvaliacaoII.setEnabled(!true);
        jBtExcluirAvaliacaoII.setEnabled(!true);
        jBtSalvarAvaliacaoII.setEnabled(!true);
        jBtCancelarAvaliacaoII.setEnabled(!true);
        jBtAuditoriaAvaliacaoII.setEnabled(!true);
    }

    public void Excluir() {
        jIdAtendNovo.setText("");
        jStatusLanc.setText("");
        jDataLanc.setDate(null);
        jIdInternoAD.setText("");
        jFotoInternoTerapia.setIcon(null);
        jNomeInternoAD.setText("");
        //DESEMPENHO OCUPACIONAL
        jComboBoxDominancia.setSelectedItem("Destro");
        jComboBoxAmputacao.setSelectedItem("Não");
        jComboBoxDeficienciaOcupa.setSelectedItem("Não");
        jComboBoxReabilitacao.setSelectedItem("Não");
        jComboBoxMotora.setSelectedItem("Não");
        jComboBoxCognitiva.setSelectedItem("Não");
        jComboBoxSensorial.setSelectedItem("Não");
        jComboBoxIntPsi.setSelectedItem("Não");
        jComboBoxAVD.setSelectedItem("Não");
        jComboBoxAIVD.setSelectedItem("Não");
        jComboBoxLazer.setSelectedItem("Não");
        jComboBoxTrabalho.setSelectedItem("Não");
        jObsDesempenhoOcupacional.setText("");
        // HISTÓRICO FAMILIAR
        jComboBoxPaisVivos.setSelectedItem("Não");
        jComboBoxTemCompanheira.setSelectedItem("Não");
        jComboBoxTemFilhos.setSelectedItem("Não");
        jQuantosFilhos.setText("0");
        jComboBoxVisitaFamiliar.setSelectedItem("Não");
        jCheckBoxSFSeg.setSelected(!true);
        jCheckBoxSFTer.setSelected(!true);
        jCheckBoxSFQua.setSelected(!true);
        jCheckBoxSFQui.setSelected(!true);
        jCheckBoxSFSex.setSelected(!true);
        jCheckBoxSFSab.setSelected(!true);
        jCheckBoxSFDom.setSelected(!true);
        jComboBoxVisitaIntima.setSelectedItem("Não");
        jCheckBoxIntSeg.setSelected(!true);
        jCheckBoxIntTer.setSelected(!true);
        jCheckBoxIntQua.setSelected(!true);
        jCheckBoxIntQui.setSelected(!true);
        jCheckBoxIntSex.setSelected(!true);
        jCheckBoxIntSab.setSelected(!true);
        jCheckBoxIntDom.setSelected(!true);
        jObsHistoricoFamiliar.setText("");
        // DADOS CLINICOS
        jComboBoxHipertensao.setSelectedItem("Não");
        jComboBoxDiabetes.setSelectedItem("Não");
        jComboBoxCancer.setSelectedItem("Não");
        jComboBoxProRespiratorio.setSelectedItem("Não");
        jComboBoxTransMental.setSelectedItem("Não");
        jComboBoxInfectocontagiosa.setSelectedItem("Não");
        jComboBoxDoencasDigestivo.setSelectedItem("Não");
        jComboBoxDeficienciaVAF.setSelectedItem("Não");
        ObsDadosClinicos.setText("");
        //ALTERAÇÕES PSICOLOGICAS
        jComboBoxHumor.setSelectedItem("Não");
        jComboBoxInsonia.setSelectedItem("Não");
        jComboBoxIrritabilidade.setSelectedItem("Não");
        jComboBoxFrustracao.setSelectedItem("Não");
        jComboBoxDificultadeConcentrar.setSelectedItem("Não");
        jComboBoxRaiva.setSelectedItem("Não");
        jComboBoxInquietacao.setSelectedItem("Não");
        jComboBoxAnsiedade.setSelectedItem("Não");
        ObsAlteracoesPsicologicas.setText("");
        // DESEMPENHO OCUPACIONAL
        jComboBoxDominancia.setSelectedItem("Não");
        jComboBoxAmputacao.setSelectedItem("Não");
        jComboBoxDeficienciaOcupa.setSelectedItem("Não");
        jComboBoxReabilitacao.setSelectedItem("Não");
        jComboBoxMotora.setSelectedItem("Não");
        jComboBoxCognitiva.setSelectedItem("Não");
        jComboBoxSensorial.setSelectedItem("Não");
        jComboBoxIntPsi.setSelectedItem("Não");
        jComboBoxAVD.setSelectedItem("Não");
        jComboBoxAIVD.setSelectedItem("Não");
        jComboBoxLazer.setSelectedItem("Não");
        jComboBoxTrabalho.setSelectedItem("Não");
        jObsDesempenhoOcupacional.setText("");
        // QUALIDADE DE VIDA (TRIAGEM SPA)
        jComboBoxTabagismo.setSelectedItem("Não");
        jQuantoTabagismo.setText("0");
        jComboBoxTabagismoUsuario.setSelectedItem("Nao");
        jComboBoxEtilismo.setSelectedItem("Não");
        jTipoEtilismo.setText("");
        jComboBoxEtilismoUsuario.setSelectedItem("Não");
        jComboBoxMedicaoAlopatica.setSelectedItem("Não");
        jTipoMedicaoAlopatica.setText("");
        jComboBoxMedicaoAlopaticaUsuario.setSelectedItem("Não");
        jComboBoxSPA.setSelectedItem("Não");
        jTipoSPA.setText("");
        jComboBoxSPAUsuario.setSelectedItem("Não");
        jObsTriagemSPA.setText("");
        // QUALIDADE DE VIDA (ESTILO DE VIDA)
        jComboBoxVidaSexual.setSelectedItem("Não");
        jComboBoxMetodoContraCeptivo.setSelectedItem("Não");
        jQualMetodoContraCeptivo.setText("");
        jComboBoxGestante.setSelectedItem("Não");
        jComboBoxAborto.setSelectedItem("Não");
        jMotivoAborto.setText("");
        jComboBoxPraticaAtividadeFisica.setSelectedItem("Não");
        jQualAtividadeFisica.setText("");
        jComboBoxTrataPsicologico.setSelectedItem("Não");
        jObsEstiloVida.setText("");
        // Habilitar/Desabilitar campos               
        jDataLanc.setEnabled(!true);
        //DESEMPENHO OCUPACIONAL
        jComboBoxDominancia.setEnabled(!true);
        jComboBoxAmputacao.setEnabled(!true);
        jComboBoxDeficienciaOcupa.setEnabled(!true);
        jComboBoxReabilitacao.setEnabled(!true);
        jComboBoxMotora.setEnabled(!true);
        jComboBoxCognitiva.setEnabled(!true);
        jComboBoxSensorial.setEnabled(!true);
        jComboBoxIntPsi.setEnabled(!true);
        jComboBoxAVD.setEnabled(!true);
        jComboBoxAIVD.setEnabled(!true);
        jComboBoxLazer.setEnabled(!true);
        jComboBoxTrabalho.setEnabled(!true);
        jObsDesempenhoOcupacional.setEnabled(!true);
        // HISTÓRICO FAMILIAR
        jComboBoxPaisVivos.setEnabled(!true);
        jComboBoxTemCompanheira.setEnabled(!true);
        jComboBoxTemFilhos.setEnabled(!true);
        jQuantosFilhos.setEnabled(!true);
        jComboBoxVisitaFamiliar.setEnabled(!true);
        jCheckBoxSFSeg.setEnabled(!true);
        jCheckBoxSFTer.setEnabled(!true);
        jCheckBoxSFQua.setEnabled(!true);
        jCheckBoxSFQui.setEnabled(!true);
        jCheckBoxSFSex.setEnabled(!true);
        jCheckBoxSFSab.setEnabled(!true);
        jCheckBoxSFDom.setEnabled(!true);
        jComboBoxVisitaIntima.setEnabled(!true);
        jCheckBoxIntSeg.setEnabled(!true);
        jCheckBoxIntTer.setEnabled(!true);
        jCheckBoxIntQua.setEnabled(!true);
        jCheckBoxIntQui.setEnabled(!true);
        jCheckBoxIntSex.setEnabled(!true);
        jCheckBoxIntSab.setEnabled(!true);
        jCheckBoxIntDom.setEnabled(!true);
        jObsHistoricoFamiliar.setEnabled(!true);
        // DADOS CLINICOS
        jComboBoxHipertensao.setEnabled(!true);
        jComboBoxDiabetes.setEnabled(!true);
        jComboBoxCancer.setEnabled(!true);
        jComboBoxProRespiratorio.setEnabled(!true);
        jComboBoxTransMental.setEnabled(!true);
        jComboBoxInfectocontagiosa.setEnabled(!true);
        jComboBoxDoencasDigestivo.setEnabled(!true);
        jComboBoxDeficienciaVAF.setEnabled(!true);
        ObsDadosClinicos.setEnabled(!true);
        //ALTERAÇÕES PSICOLOGICAS
        jComboBoxHumor.setEnabled(!true);
        jComboBoxInsonia.setEnabled(!true);
        jComboBoxIrritabilidade.setEnabled(!true);
        jComboBoxFrustracao.setEnabled(!true);
        jComboBoxDificultadeConcentrar.setEnabled(!true);
        jComboBoxRaiva.setEnabled(!true);
        jComboBoxInquietacao.setEnabled(!true);
        jComboBoxAnsiedade.setEnabled(!true);
        ObsAlteracoesPsicologicas.setEnabled(!true);
        // DESEMPENHO OCUPACIONAL
        jComboBoxDominancia.setEnabled(!true);
        jComboBoxAmputacao.setEnabled(!true);
        jComboBoxDeficienciaOcupa.setEnabled(!true);
        jComboBoxReabilitacao.setEnabled(!true);
        jComboBoxMotora.setEnabled(!true);
        jComboBoxCognitiva.setEnabled(!true);
        jComboBoxSensorial.setEnabled(!true);
        jComboBoxIntPsi.setEnabled(!true);
        jComboBoxAVD.setEnabled(!true);
        jComboBoxAIVD.setEnabled(!true);
        jComboBoxLazer.setEnabled(!true);
        jComboBoxTrabalho.setEnabled(!true);
        jObsDesempenhoOcupacional.setEnabled(!true);
        // QUALIDADE DE VIDA (TRIAGEM SPA)
        jComboBoxTabagismo.setEnabled(!true);
        jQuantoTabagismo.setEnabled(!true);
        jComboBoxTabagismoUsuario.setEnabled(!true);
        jComboBoxEtilismo.setEnabled(!true);
        jTipoEtilismo.setEnabled(!true);
        jComboBoxEtilismoUsuario.setEnabled(!true);
        jComboBoxMedicaoAlopatica.setEnabled(!true);
        jTipoMedicaoAlopatica.setEnabled(!true);
        jComboBoxMedicaoAlopaticaUsuario.setEnabled(!true);
        jComboBoxSPA.setEnabled(!true);
        jTipoSPA.setEnabled(!true);
        jComboBoxSPAUsuario.setEnabled(!true);
        jObsTriagemSPA.setEnabled(!true);
        // QUALIDADE DE VIDA (ESTILO DE VIDA)
        jComboBoxVidaSexual.setEnabled(!true);
        jComboBoxMetodoContraCeptivo.setEnabled(!true);
        jQualMetodoContraCeptivo.setEnabled(!true);
        jComboBoxGestante.setEnabled(!true);
        jComboBoxAborto.setEnabled(!true);
        jMotivoAborto.setEnabled(!true);
        jComboBoxPraticaAtividadeFisica.setEnabled(!true);
        jQualAtividadeFisica.setEnabled(!true);
        jComboBoxTrataPsicologico.setEnabled(!true);
        jObsEstiloVida.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtImpressao.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        // HISTORICO EDUCACIONAL
        jBtNovoHistoricoEduca.setEnabled(!true);
        jBtAlterarHistoricoEduca.setEnabled(!true);
        jBtExcluirHistoricoEduca.setEnabled(!true);
        jBtSalvarHistoricoEduca.setEnabled(!true);
        jBtCancelarHistoricoEduca.setEnabled(!true);
        jBtAuditoriaHistoricoEduca.setEnabled(!true);
        // HISTÓRICO LABORATIVO
        jBtNovoHistoricoLabor.setEnabled(!true);
        jBtAlterarHistoricoLabor.setEnabled(!true);
        jBtExcluirHistoricoLabor.setEnabled(!true);
        jBtSalvarHistoricoLabor.setEnabled(!true);
        jBtCancelarHistoricoLabor.setEnabled(!true);
        jBtAuditoriaHistoricoLabor.setEnabled(!true);
        // AVALIAÇÃO I
        jBtNovoAvaliacaoI.setEnabled(!true);
        jBtAlterarAvaliacaoI.setEnabled(!true);
        jBtExcluirAvaliacaoI.setEnabled(!true);
        jBtSalvarAvaliacaoI.setEnabled(!true);
        jBtCancelarAvaliacaoI.setEnabled(!true);
        jBtAuditoriaAvaliacaoI.setEnabled(!true);
        // AVALIAÇÃO II
        jBtNovoAvaliacaoII.setEnabled(!true);
        jBtAlterarAvaliacaoII.setEnabled(!true);
        jBtExcluirAvaliacaoII.setEnabled(!true);
        jBtSalvarAvaliacaoII.setEnabled(!true);
        jBtCancelarAvaliacaoII.setEnabled(!true);
        jBtAuditoriaAvaliacaoII.setEnabled(!true);
    }

    public void Salvar() {
        // Habilitar/Desabilitar campos               
        jDataLanc.setEnabled(!true);
        //DESEMPENHO OCUPACIONAL
        jComboBoxDominancia.setEnabled(!true);
        jComboBoxAmputacao.setEnabled(!true);
        jComboBoxDeficienciaOcupa.setEnabled(!true);
        jComboBoxReabilitacao.setEnabled(!true);
        jComboBoxMotora.setEnabled(!true);
        jComboBoxCognitiva.setEnabled(!true);
        jComboBoxSensorial.setEnabled(!true);
        jComboBoxIntPsi.setEnabled(!true);
        jComboBoxAVD.setEnabled(!true);
        jComboBoxAIVD.setEnabled(!true);
        jComboBoxLazer.setEnabled(!true);
        jComboBoxTrabalho.setEnabled(!true);
        jObsDesempenhoOcupacional.setEnabled(!true);
        // HISTÓRICO FAMILIAR
        jComboBoxPaisVivos.setEnabled(!true);
        jComboBoxTemCompanheira.setEnabled(!true);
        jComboBoxTemFilhos.setEnabled(!true);
        jQuantosFilhos.setEnabled(!true);
        jComboBoxVisitaFamiliar.setEnabled(!true);
        jCheckBoxSFSeg.setEnabled(!true);
        jCheckBoxSFTer.setEnabled(!true);
        jCheckBoxSFQua.setEnabled(!true);
        jCheckBoxSFQui.setEnabled(!true);
        jCheckBoxSFSex.setEnabled(!true);
        jCheckBoxSFSab.setEnabled(!true);
        jCheckBoxSFDom.setEnabled(!true);
        jComboBoxVisitaIntima.setEnabled(!true);
        jCheckBoxIntSeg.setEnabled(!true);
        jCheckBoxIntTer.setEnabled(!true);
        jCheckBoxIntQua.setEnabled(!true);
        jCheckBoxIntQui.setEnabled(!true);
        jCheckBoxIntSex.setEnabled(!true);
        jCheckBoxIntSab.setEnabled(!true);
        jCheckBoxIntDom.setEnabled(!true);
        jObsHistoricoFamiliar.setEnabled(!true);
        // DADOS CLINICOS
        jComboBoxHipertensao.setEnabled(!true);
        jComboBoxDiabetes.setEnabled(!true);
        jComboBoxCancer.setEnabled(!true);
        jComboBoxProRespiratorio.setEnabled(!true);
        jComboBoxTransMental.setEnabled(!true);
        jComboBoxInfectocontagiosa.setEnabled(!true);
        jComboBoxDoencasDigestivo.setEnabled(!true);
        jComboBoxDeficienciaVAF.setEnabled(!true);
        ObsDadosClinicos.setEnabled(!true);
        //ALTERAÇÕES PSICOLOGICAS
        jComboBoxHumor.setEnabled(!true);
        jComboBoxInsonia.setEnabled(!true);
        jComboBoxIrritabilidade.setEnabled(!true);
        jComboBoxFrustracao.setEnabled(!true);
        jComboBoxDificultadeConcentrar.setEnabled(!true);
        jComboBoxRaiva.setEnabled(!true);
        jComboBoxInquietacao.setEnabled(!true);
        jComboBoxAnsiedade.setEnabled(!true);
        ObsAlteracoesPsicologicas.setEnabled(!true);
        // DESEMPENHO OCUPACIONAL
        jComboBoxDominancia.setEnabled(!true);
        jComboBoxAmputacao.setEnabled(!true);
        jComboBoxDeficienciaOcupa.setEnabled(!true);
        jComboBoxReabilitacao.setEnabled(!true);
        jComboBoxMotora.setEnabled(!true);
        jComboBoxCognitiva.setEnabled(!true);
        jComboBoxSensorial.setEnabled(!true);
        jComboBoxIntPsi.setEnabled(!true);
        jComboBoxAVD.setEnabled(!true);
        jComboBoxAIVD.setEnabled(!true);
        jComboBoxLazer.setEnabled(!true);
        jComboBoxTrabalho.setEnabled(!true);
        jObsDesempenhoOcupacional.setEnabled(!true);
        // QUALIDADE DE VIDA (TRIAGEM SPA)
        jComboBoxTabagismo.setEnabled(!true);
        jQuantoTabagismo.setEnabled(!true);
        jComboBoxTabagismoUsuario.setEnabled(!true);
        jComboBoxEtilismo.setEnabled(!true);
        jTipoEtilismo.setEnabled(!true);
        jComboBoxEtilismoUsuario.setEnabled(!true);
        jComboBoxMedicaoAlopatica.setEnabled(!true);
        jTipoMedicaoAlopatica.setEnabled(!true);
        jComboBoxMedicaoAlopaticaUsuario.setEnabled(!true);
        jComboBoxSPA.setEnabled(!true);
        jTipoSPA.setEnabled(!true);
        jComboBoxSPAUsuario.setEnabled(!true);
        jObsTriagemSPA.setEnabled(!true);
        // QUALIDADE DE VIDA (ESTILO DE VIDA)
        jComboBoxVidaSexual.setEnabled(!true);
        jComboBoxMetodoContraCeptivo.setEnabled(!true);
        jQualMetodoContraCeptivo.setEnabled(!true);
        jComboBoxGestante.setEnabled(!true);
        jComboBoxAborto.setEnabled(!true);
        jMotivoAborto.setEnabled(!true);
        jComboBoxPraticaAtividadeFisica.setEnabled(!true);
        jQualAtividadeFisica.setEnabled(!true);
        jComboBoxTrataPsicologico.setEnabled(!true);
        jObsEstiloVida.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtImpressao.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        // HISTORICO EDUCACIONAL
        if (codigoHistoricoEduca != 0) {
            jBtNovoHistoricoEduca.setEnabled(true);
            jBtAlterarHistoricoEduca.setEnabled(true);
            jBtExcluirHistoricoEduca.setEnabled(true);
            jBtSalvarHistoricoEduca.setEnabled(!true);
            jBtCancelarHistoricoEduca.setEnabled(!true);
            jBtAuditoriaHistoricoEduca.setEnabled(true);
        } else {
            jBtNovoHistoricoEduca.setEnabled(true);
        }
        // HISTÓRICO LABORATIVO
        if (codigoHistoricoProf != 0) {
            jBtNovoHistoricoLabor.setEnabled(true);
            jBtAlterarHistoricoLabor.setEnabled(true);
            jBtExcluirHistoricoLabor.setEnabled(true);
            jBtSalvarHistoricoLabor.setEnabled(!true);
            jBtCancelarHistoricoLabor.setEnabled(!true);
            jBtAuditoriaHistoricoLabor.setEnabled(true);
        } else {
            jBtNovoHistoricoLabor.setEnabled(true);
        }
        // AVALIAÇÃO I
        if (codigoAvaliacaoI != 0) {
            jBtNovoAvaliacaoI.setEnabled(true);
            jBtAlterarAvaliacaoI.setEnabled(true);
            jBtExcluirAvaliacaoI.setEnabled(true);
            jBtSalvarAvaliacaoI.setEnabled(!true);
            jBtCancelarAvaliacaoI.setEnabled(!true);
            jBtAuditoriaAvaliacaoI.setEnabled(true);
        } else {
            jBtNovoAvaliacaoI.setEnabled(true);
        }
        // AVALIAÇÃO II
        if (codigoAvaliacaoII != 0) {
            jBtNovoAvaliacaoII.setEnabled(true);
            jBtAlterarAvaliacaoII.setEnabled(true);
            jBtExcluirAvaliacaoII.setEnabled(true);
            jBtSalvarAvaliacaoII.setEnabled(!true);
            jBtCancelarAvaliacaoII.setEnabled(!true);
            jBtAuditoriaAvaliacaoII.setEnabled(true);
        } else {
            jBtNovoAvaliacaoII.setEnabled(true);
        }
    }

    public void Cancelar() {
        // Limpar campos caso seja uma insersão
        if (jIdAtendNovo.getText().equals("")) {
            //DESEMPENHO OCUPACIONAL
            jComboBoxDominancia.setSelectedItem("Destro");
            jComboBoxAmputacao.setSelectedItem("Não");
            jComboBoxDeficienciaOcupa.setSelectedItem("Não");
            jComboBoxReabilitacao.setSelectedItem("Não");
            jComboBoxMotora.setSelectedItem("Não");
            jComboBoxCognitiva.setSelectedItem("Não");
            jComboBoxSensorial.setSelectedItem("Não");
            jComboBoxIntPsi.setSelectedItem("Não");
            jComboBoxAVD.setSelectedItem("Não");
            jComboBoxAIVD.setSelectedItem("Não");
            jComboBoxLazer.setSelectedItem("Não");
            jComboBoxTrabalho.setSelectedItem("Não");
            jObsDesempenhoOcupacional.setText("");
            // HISTÓRICO FAMILIAR
            jComboBoxPaisVivos.setSelectedItem("Não");
            jComboBoxTemCompanheira.setSelectedItem("Não");
            jComboBoxTemFilhos.setSelectedItem("Não");
            jQuantosFilhos.setText("");
            jComboBoxVisitaFamiliar.setSelectedItem("Não");
            jCheckBoxSFSeg.setSelected(!true);
            jCheckBoxSFTer.setSelected(!true);
            jCheckBoxSFQua.setSelected(!true);
            jCheckBoxSFQui.setSelected(!true);
            jCheckBoxSFSex.setSelected(!true);
            jCheckBoxSFSab.setSelected(!true);
            jCheckBoxSFDom.setSelected(!true);
            jComboBoxVisitaIntima.setSelectedItem("Não");
            jCheckBoxIntSeg.setSelected(!true);
            jCheckBoxIntTer.setSelected(!true);
            jCheckBoxIntQua.setSelected(!true);
            jCheckBoxIntQui.setSelected(!true);
            jCheckBoxIntSex.setSelected(!true);
            jCheckBoxIntSab.setSelected(!true);
            jCheckBoxIntDom.setSelected(!true);
            jObsHistoricoFamiliar.setText("");
            // DADOS CLINICOS
            jComboBoxHipertensao.setSelectedItem("Não");
            jComboBoxDiabetes.setSelectedItem("Não");
            jComboBoxCancer.setSelectedItem("Não");
            jComboBoxProRespiratorio.setSelectedItem("Não");
            jComboBoxTransMental.setSelectedItem("Não");
            jComboBoxInfectocontagiosa.setSelectedItem("Não");
            jComboBoxDoencasDigestivo.setSelectedItem("Não");
            jComboBoxDeficienciaVAF.setSelectedItem("Não");
            ObsDadosClinicos.setText("");
            //ALTERAÇÕES PSICOLOGICAS
            jComboBoxHumor.setSelectedItem("Não");
            jComboBoxInsonia.setSelectedItem("Não");
            jComboBoxIrritabilidade.setSelectedItem("Não");
            jComboBoxFrustracao.setSelectedItem("Não");
            jComboBoxDificultadeConcentrar.setSelectedItem("Não");
            jComboBoxRaiva.setSelectedItem("Não");
            jComboBoxInquietacao.setSelectedItem("Não");
            jComboBoxAnsiedade.setSelectedItem("Não");
            ObsAlteracoesPsicologicas.setText("");
            // DESEMPENHO OCUPACIONAL
            jComboBoxDominancia.setSelectedItem("Não");
            jComboBoxAmputacao.setSelectedItem("Não");
            jComboBoxDeficienciaOcupa.setSelectedItem("Não");
            jComboBoxReabilitacao.setSelectedItem("Não");
            jComboBoxMotora.setSelectedItem("Não");
            jComboBoxCognitiva.setSelectedItem("Não");
            jComboBoxSensorial.setSelectedItem("Não");
            jComboBoxIntPsi.setSelectedItem("Não");
            jComboBoxAVD.setSelectedItem("Não");
            jComboBoxAIVD.setSelectedItem("Não");
            jComboBoxLazer.setSelectedItem("Não");
            jComboBoxTrabalho.setSelectedItem("Não");
            jObsDesempenhoOcupacional.setText("");
            // QUALIDADE DE VIDA (TRIAGEM SPA)
            jComboBoxTabagismo.setSelectedItem("Não");
            jQuantoTabagismo.setText("");
            jComboBoxTabagismoUsuario.setSelectedItem("Nao");
            jComboBoxEtilismo.setSelectedItem("Não");
            jTipoEtilismo.setText("");
            jComboBoxEtilismoUsuario.setSelectedItem("Não");
            jComboBoxMedicaoAlopatica.setSelectedItem("Não");
            jTipoMedicaoAlopatica.setText("");
            jComboBoxMedicaoAlopaticaUsuario.setSelectedItem("Não");
            jComboBoxSPA.setSelectedItem("Não");
            jTipoSPA.setText("");
            jComboBoxSPAUsuario.setSelectedItem("Não");
            jObsTriagemSPA.setText("");
            // QUALIDADE DE VIDA (ESTILO DE VIDA)
            jComboBoxVidaSexual.setSelectedItem("Não");
            jComboBoxMetodoContraCeptivo.setSelectedItem("Não");
            jQualMetodoContraCeptivo.setText("");
            jComboBoxGestante.setSelectedItem("Não");
            jComboBoxAborto.setSelectedItem("Não");
            jMotivoAborto.setText("");
            jComboBoxPraticaAtividadeFisica.setSelectedItem("Não");
            jQualAtividadeFisica.setText("");
            jComboBoxTrataPsicologico.setSelectedItem("Não");
            jObsEstiloVida.setText("");
            //
            jDataLanc.setEnabled(!true);
            //DESEMPENHO OCUPACIONAL
            jComboBoxDominancia.setEnabled(!true);
            jComboBoxAmputacao.setEnabled(!true);
            jComboBoxDeficienciaOcupa.setEnabled(!true);
            jComboBoxReabilitacao.setEnabled(!true);
            jComboBoxMotora.setEnabled(!true);
            jComboBoxCognitiva.setEnabled(!true);
            jComboBoxSensorial.setEnabled(!true);
            jComboBoxIntPsi.setEnabled(!true);
            jComboBoxAVD.setEnabled(!true);
            jComboBoxAIVD.setEnabled(!true);
            jComboBoxLazer.setEnabled(!true);
            jComboBoxTrabalho.setEnabled(!true);
            jObsDesempenhoOcupacional.setEnabled(!true);
            // HISTÓRICO FAMILIAR
            jComboBoxPaisVivos.setEnabled(!true);
            jComboBoxTemCompanheira.setEnabled(!true);
            jComboBoxTemFilhos.setEnabled(!true);
            jQuantosFilhos.setEnabled(!true);
            jComboBoxVisitaFamiliar.setEnabled(!true);
            jCheckBoxSFSeg.setEnabled(!true);
            jCheckBoxSFTer.setEnabled(!true);
            jCheckBoxSFQua.setEnabled(!true);
            jCheckBoxSFQui.setEnabled(!true);
            jCheckBoxSFSex.setEnabled(!true);
            jCheckBoxSFSab.setEnabled(!true);
            jCheckBoxSFDom.setEnabled(!true);
            jComboBoxVisitaIntima.setEnabled(!true);
            jCheckBoxIntSeg.setEnabled(!true);
            jCheckBoxIntTer.setEnabled(!true);
            jCheckBoxIntQua.setEnabled(!true);
            jCheckBoxIntQui.setEnabled(!true);
            jCheckBoxIntSex.setEnabled(!true);
            jCheckBoxIntSab.setEnabled(!true);
            jCheckBoxIntDom.setEnabled(!true);
            jObsHistoricoFamiliar.setEnabled(!true);
            // DADOS CLINICOS
            jComboBoxHipertensao.setEnabled(!true);
            jComboBoxDiabetes.setEnabled(!true);
            jComboBoxCancer.setEnabled(!true);
            jComboBoxProRespiratorio.setEnabled(!true);
            jComboBoxTransMental.setEnabled(!true);
            jComboBoxInfectocontagiosa.setEnabled(!true);
            jComboBoxDoencasDigestivo.setEnabled(!true);
            jComboBoxDeficienciaVAF.setEnabled(!true);
            ObsDadosClinicos.setEnabled(!true);
            //ALTERAÇÕES PSICOLOGICAS
            jComboBoxHumor.setEnabled(!true);
            jComboBoxInsonia.setEnabled(!true);
            jComboBoxIrritabilidade.setEnabled(!true);
            jComboBoxFrustracao.setEnabled(!true);
            jComboBoxDificultadeConcentrar.setEnabled(!true);
            jComboBoxRaiva.setEnabled(!true);
            jComboBoxInquietacao.setEnabled(!true);
            jComboBoxAnsiedade.setEnabled(!true);
            ObsAlteracoesPsicologicas.setEnabled(!true);
            // DESEMPENHO OCUPACIONAL
            jComboBoxDominancia.setEnabled(!true);
            jComboBoxAmputacao.setEnabled(!true);
            jComboBoxDeficienciaOcupa.setEnabled(!true);
            jComboBoxReabilitacao.setEnabled(!true);
            jComboBoxMotora.setEnabled(!true);
            jComboBoxCognitiva.setEnabled(!true);
            jComboBoxSensorial.setEnabled(!true);
            jComboBoxIntPsi.setEnabled(!true);
            jComboBoxAVD.setEnabled(!true);
            jComboBoxAIVD.setEnabled(!true);
            jComboBoxLazer.setEnabled(!true);
            jComboBoxTrabalho.setEnabled(!true);
            jObsDesempenhoOcupacional.setEnabled(!true);
            // QUALIDADE DE VIDA (TRIAGEM SPA)
            jComboBoxTabagismo.setEnabled(!true);
            jQuantoTabagismo.setEnabled(!true);
            jComboBoxTabagismoUsuario.setEnabled(!true);
            jComboBoxEtilismo.setEnabled(!true);
            jTipoEtilismo.setEnabled(!true);
            jComboBoxEtilismoUsuario.setEnabled(!true);
            jComboBoxMedicaoAlopatica.setEnabled(!true);
            jTipoMedicaoAlopatica.setEnabled(!true);
            jComboBoxMedicaoAlopaticaUsuario.setEnabled(!true);
            jComboBoxSPA.setEnabled(!true);
            jTipoSPA.setEnabled(!true);
            jComboBoxSPAUsuario.setEnabled(!true);
            jObsTriagemSPA.setEnabled(!true);
            // QUALIDADE DE VIDA (ESTILO DE VIDA)
            jComboBoxVidaSexual.setEnabled(!true);
            jComboBoxMetodoContraCeptivo.setEnabled(!true);
            jQualMetodoContraCeptivo.setEnabled(!true);
            jComboBoxGestante.setEnabled(!true);
            jComboBoxAborto.setEnabled(!true);
            jMotivoAborto.setEnabled(!true);
            jComboBoxPraticaAtividadeFisica.setEnabled(!true);
            jQualAtividadeFisica.setEnabled(!true);
            jComboBoxTrataPsicologico.setEnabled(!true);
            jObsEstiloVida.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
            jBtImpressao.setEnabled(!true);
            jBtAuditoria.setEnabled(!true);
        } else {
            jDataLanc.setEnabled(!true);
            //DESEMPENHO OCUPACIONAL
            jComboBoxDominancia.setEnabled(!true);
            jComboBoxAmputacao.setEnabled(!true);
            jComboBoxDeficienciaOcupa.setEnabled(!true);
            jComboBoxReabilitacao.setEnabled(!true);
            jComboBoxMotora.setEnabled(!true);
            jComboBoxCognitiva.setEnabled(!true);
            jComboBoxSensorial.setEnabled(!true);
            jComboBoxIntPsi.setEnabled(!true);
            jComboBoxAVD.setEnabled(!true);
            jComboBoxAIVD.setEnabled(!true);
            jComboBoxLazer.setEnabled(!true);
            jComboBoxTrabalho.setEnabled(!true);
            jObsDesempenhoOcupacional.setEnabled(!true);
            // HISTÓRICO FAMILIAR
            jComboBoxPaisVivos.setEnabled(!true);
            jComboBoxTemCompanheira.setEnabled(!true);
            jComboBoxTemFilhos.setEnabled(!true);
            jQuantosFilhos.setEnabled(!true);
            jComboBoxVisitaFamiliar.setEnabled(!true);
            jCheckBoxSFSeg.setEnabled(!true);
            jCheckBoxSFTer.setEnabled(!true);
            jCheckBoxSFQua.setEnabled(!true);
            jCheckBoxSFQui.setEnabled(!true);
            jCheckBoxSFSex.setEnabled(!true);
            jCheckBoxSFSab.setEnabled(!true);
            jCheckBoxSFDom.setEnabled(!true);
            jComboBoxVisitaIntima.setEnabled(!true);
            jCheckBoxIntSeg.setEnabled(!true);
            jCheckBoxIntTer.setEnabled(!true);
            jCheckBoxIntQua.setEnabled(!true);
            jCheckBoxIntQui.setEnabled(!true);
            jCheckBoxIntSex.setEnabled(!true);
            jCheckBoxIntSab.setEnabled(!true);
            jCheckBoxIntDom.setEnabled(!true);
            jObsHistoricoFamiliar.setEnabled(!true);
            // DADOS CLINICOS
            jComboBoxHipertensao.setEnabled(!true);
            jComboBoxDiabetes.setEnabled(!true);
            jComboBoxCancer.setEnabled(!true);
            jComboBoxProRespiratorio.setEnabled(!true);
            jComboBoxTransMental.setEnabled(!true);
            jComboBoxInfectocontagiosa.setEnabled(!true);
            jComboBoxDoencasDigestivo.setEnabled(!true);
            jComboBoxDeficienciaVAF.setEnabled(!true);
            ObsDadosClinicos.setEnabled(!true);
            //ALTERAÇÕES PSICOLOGICAS
            jComboBoxHumor.setEnabled(!true);
            jComboBoxInsonia.setEnabled(!true);
            jComboBoxIrritabilidade.setEnabled(!true);
            jComboBoxFrustracao.setEnabled(!true);
            jComboBoxDificultadeConcentrar.setEnabled(!true);
            jComboBoxRaiva.setEnabled(!true);
            jComboBoxInquietacao.setEnabled(!true);
            jComboBoxAnsiedade.setEnabled(!true);
            ObsAlteracoesPsicologicas.setEnabled(!true);
            // DESEMPENHO OCUPACIONAL
            jComboBoxDominancia.setEnabled(!true);
            jComboBoxAmputacao.setEnabled(!true);
            jComboBoxDeficienciaOcupa.setEnabled(!true);
            jComboBoxReabilitacao.setEnabled(!true);
            jComboBoxMotora.setEnabled(!true);
            jComboBoxCognitiva.setEnabled(!true);
            jComboBoxSensorial.setEnabled(!true);
            jComboBoxIntPsi.setEnabled(!true);
            jComboBoxAVD.setEnabled(!true);
            jComboBoxAIVD.setEnabled(!true);
            jComboBoxLazer.setEnabled(!true);
            jComboBoxTrabalho.setEnabled(!true);
            jObsDesempenhoOcupacional.setEnabled(!true);
            // QUALIDADE DE VIDA (TRIAGEM SPA)
            jComboBoxTabagismo.setEnabled(!true);
            jQuantoTabagismo.setEnabled(!true);
            jComboBoxTabagismoUsuario.setEnabled(!true);
            jComboBoxEtilismo.setEnabled(!true);
            jTipoEtilismo.setEnabled(!true);
            jComboBoxEtilismoUsuario.setEnabled(!true);
            jComboBoxMedicaoAlopatica.setEnabled(!true);
            jTipoMedicaoAlopatica.setEnabled(!true);
            jComboBoxMedicaoAlopaticaUsuario.setEnabled(!true);
            jComboBoxSPA.setEnabled(!true);
            jTipoSPA.setEnabled(!true);
            jComboBoxSPAUsuario.setEnabled(!true);
            jObsTriagemSPA.setEnabled(!true);
            // QUALIDADE DE VIDA (ESTILO DE VIDA)
            jComboBoxVidaSexual.setEnabled(!true);
            jComboBoxMetodoContraCeptivo.setEnabled(!true);
            jQualMetodoContraCeptivo.setEnabled(!true);
            jComboBoxGestante.setEnabled(!true);
            jComboBoxAborto.setEnabled(!true);
            jMotivoAborto.setEnabled(!true);
            jComboBoxPraticaAtividadeFisica.setEnabled(!true);
            jQualAtividadeFisica.setEnabled(!true);
            jComboBoxTrataPsicologico.setEnabled(!true);
            jObsEstiloVida.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtImpressao.setEnabled(true);
            jBtAuditoria.setEnabled(true);
        }
        // HISTORICO EDUCACIONAL
        if (codigoHistoricoEduca != 0) {
            jBtNovoHistoricoEduca.setEnabled(true);
            jBtAlterarHistoricoEduca.setEnabled(true);
            jBtExcluirHistoricoEduca.setEnabled(true);
            jBtSalvarHistoricoEduca.setEnabled(!true);
            jBtCancelarHistoricoEduca.setEnabled(!true);
            jBtAuditoriaHistoricoEduca.setEnabled(true);
        } else {
            jBtNovoHistoricoEduca.setEnabled(true);
        }
        // HISTÓRICO LABORATIVO
        if (codigoHistoricoProf != 0) {
            jBtNovoHistoricoLabor.setEnabled(true);
            jBtAlterarHistoricoLabor.setEnabled(true);
            jBtExcluirHistoricoLabor.setEnabled(true);
            jBtSalvarHistoricoLabor.setEnabled(!true);
            jBtCancelarHistoricoLabor.setEnabled(!true);
            jBtAuditoriaHistoricoLabor.setEnabled(true);
        } else {
            jBtNovoHistoricoLabor.setEnabled(true);
        }
        // AVALIAÇÃO I
        if (codigoAvaliacaoI != 0) {
            jBtNovoAvaliacaoI.setEnabled(true);
            jBtAlterarAvaliacaoI.setEnabled(true);
            jBtExcluirAvaliacaoI.setEnabled(true);
            jBtSalvarAvaliacaoI.setEnabled(!true);
            jBtCancelarAvaliacaoI.setEnabled(!true);
            jBtAuditoriaAvaliacaoI.setEnabled(true);
        } else {
            jBtNovoAvaliacaoI.setEnabled(true);
        }
        // AVALIAÇÃO II
        if (codigoAvaliacaoII != 0) {
            jBtNovoAvaliacaoII.setEnabled(true);
            jBtAlterarAvaliacaoII.setEnabled(true);
            jBtExcluirAvaliacaoII.setEnabled(true);
            jBtSalvarAvaliacaoII.setEnabled(!true);
            jBtCancelarAvaliacaoII.setEnabled(!true);
            jBtAuditoriaAvaliacaoII.setEnabled(true);
        } else {
            jBtNovoAvaliacaoII.setEnabled(true);
        }
    }

    public void NovoHistoricoEdu() {
        jComboBoxEscreveProprioNome.setSelectedItem("Não");
        jComboBoxSabeLerEscrever.setSelectedItem("Não");
        jComboBoxNivelInstrucao.setSelectedItem("Não Alfabetizado");
        jComboBoxInteresseEstudar.setSelectedItem("Não");
        jComboBoxCursoProfissionalizante.setSelectedItem("Selecione...");
        jComboBoxDescricaoCurso.setSelectedItem("Não");
        //
        jComboBoxEscreveProprioNome.setEnabled(true);
        jComboBoxSabeLerEscrever.setEnabled(true);
        jComboBoxNivelInstrucao.setEnabled(true);
        jComboBoxInteresseEstudar.setEnabled(true);
        jComboBoxCursoProfissionalizante.setEnabled(true);
        jComboBoxDescricaoCurso.setEnabled(true);
        jRadioBtA.setEnabled(true);
        jRadioBtB.setEnabled(true);
        jRadioBtC.setEnabled(true);
        //
        jBtIncluirCurso.setEnabled(true);
        jBtExcluirCurso.setEnabled(true);
        //
        jBtNovoHistoricoEduca.setEnabled(!true);
        jBtAlterarHistoricoEduca.setEnabled(!true);
        jBtExcluirHistoricoEduca.setEnabled(!true);
        jBtSalvarHistoricoEduca.setEnabled(true);
        jBtCancelarHistoricoEduca.setEnabled(true);
        jBtAuditoriaHistoricoEduca.setEnabled(!true);
        // HISTÓRICO LABORATIVO
        jBtNovoHistoricoLabor.setEnabled(!true);
        jBtAlterarHistoricoLabor.setEnabled(!true);
        jBtExcluirHistoricoLabor.setEnabled(!true);
        jBtSalvarHistoricoLabor.setEnabled(!true);
        jBtCancelarHistoricoLabor.setEnabled(!true);
        jBtAuditoriaHistoricoLabor.setEnabled(!true);
        jBtRefersCursos.setEnabled(true);
        // MANUTENÇÃO
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        // AVALIAÇÃO I
        jBtNovoAvaliacaoI.setEnabled(!true);
        jBtAlterarAvaliacaoI.setEnabled(!true);
        jBtExcluirAvaliacaoI.setEnabled(!true);
        jBtSalvarAvaliacaoI.setEnabled(!true);
        jBtCancelarAvaliacaoI.setEnabled(!true);
        jBtAuditoriaAvaliacaoI.setEnabled(!true);
        // AVALIAÇÃO II
        jBtNovoAvaliacaoII.setEnabled(!true);
        jBtAlterarAvaliacaoII.setEnabled(!true);
        jBtExcluirAvaliacaoII.setEnabled(!true);
        jBtSalvarAvaliacaoII.setEnabled(!true);
        jBtCancelarAvaliacaoII.setEnabled(!true);
        jBtAuditoriaAvaliacaoII.setEnabled(!true);
    }

    public void AlterarHistoricoEdu() {
        jComboBoxEscreveProprioNome.setEnabled(true);
        jComboBoxSabeLerEscrever.setEnabled(true);
        jComboBoxNivelInstrucao.setEnabled(true);
        jComboBoxInteresseEstudar.setEnabled(true);
        jComboBoxCursoProfissionalizante.setEnabled(true);
        jComboBoxDescricaoCurso.setEnabled(true);
        jRadioBtA.setEnabled(true);
        jRadioBtB.setEnabled(true);
        jRadioBtC.setEnabled(true);
        //
        jBtIncluirCurso.setEnabled(true);
        jBtExcluirCurso.setEnabled(true);
        //
        jBtNovoHistoricoEduca.setEnabled(!true);
        jBtAlterarHistoricoEduca.setEnabled(!true);
        jBtExcluirHistoricoEduca.setEnabled(!true);
        jBtSalvarHistoricoEduca.setEnabled(true);
        jBtCancelarHistoricoEduca.setEnabled(true);
        jBtAuditoriaHistoricoEduca.setEnabled(!true);
        jBtRefersCursos.setEnabled(true);
    }

    public void ExcluirHistoricoEdu() {
        jComboBoxEscreveProprioNome.setSelectedItem("Não");
        jComboBoxSabeLerEscrever.setSelectedItem("Não");
        jComboBoxNivelInstrucao.setSelectedItem("Não Alfabetizado");
        jComboBoxInteresseEstudar.setSelectedItem("Não");
        jComboBoxCursoProfissionalizante.setSelectedItem("Selecione...");
        jComboBoxDescricaoCurso.setSelectedItem("Não");
        //
        jComboBoxEscreveProprioNome.setEnabled(!true);
        jComboBoxSabeLerEscrever.setEnabled(!true);
        jComboBoxNivelInstrucao.setEnabled(!true);
        jComboBoxInteresseEstudar.setEnabled(!true);
        jComboBoxCursoProfissionalizante.setEnabled(!true);
        jComboBoxDescricaoCurso.setEnabled(!true);
        jRadioBtA.setEnabled(!true);
        jRadioBtB.setEnabled(!true);
        jRadioBtC.setEnabled(!true);
        //
        jBtIncluirCurso.setEnabled(!true);
        jBtExcluirCurso.setEnabled(!true);
        //
        jBtNovoHistoricoEduca.setEnabled(true);
        jBtAlterarHistoricoEduca.setEnabled(!true);
        jBtExcluirHistoricoEduca.setEnabled(!true);
        jBtSalvarHistoricoEduca.setEnabled(!true);
        jBtCancelarHistoricoEduca.setEnabled(!true);
        jBtAuditoriaHistoricoEduca.setEnabled(!true);
        jBtRefersCursos.setEnabled(!true);
        // HISTÓRICO LABORATIVO
        jBtNovoHistoricoLabor.setEnabled(true);
        jBtAlterarHistoricoLabor.setEnabled(!true);
        jBtExcluirHistoricoLabor.setEnabled(!true);
        jBtSalvarHistoricoLabor.setEnabled(!true);
        jBtCancelarHistoricoLabor.setEnabled(!true);
        jBtAuditoriaHistoricoLabor.setEnabled(!true);
        jBtRefersCursos.setEnabled(!true);
        // MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
        // AVALIAÇÃO I
        jBtNovoAvaliacaoI.setEnabled(true);
        jBtAlterarAvaliacaoI.setEnabled(!true);
        jBtExcluirAvaliacaoI.setEnabled(!true);
        jBtSalvarAvaliacaoI.setEnabled(!true);
        jBtCancelarAvaliacaoI.setEnabled(!true);
        jBtAuditoriaAvaliacaoI.setEnabled(!true);
        // AVALIAÇÃO II
        jBtNovoAvaliacaoII.setEnabled(true);
        jBtAlterarAvaliacaoII.setEnabled(!true);
        jBtExcluirAvaliacaoII.setEnabled(!true);
        jBtSalvarAvaliacaoII.setEnabled(!true);
        jBtCancelarAvaliacaoII.setEnabled(!true);
        jBtAuditoriaAvaliacaoII.setEnabled(!true);
    }

    public void SalvarHistoricoEdu() {
        jComboBoxEscreveProprioNome.setEnabled(!true);
        jComboBoxSabeLerEscrever.setEnabled(!true);
        jComboBoxNivelInstrucao.setEnabled(!true);
        jComboBoxInteresseEstudar.setEnabled(!true);
        jComboBoxCursoProfissionalizante.setEnabled(!true);
        jComboBoxDescricaoCurso.setEnabled(!true);
        jRadioBtA.setEnabled(!true);
        jRadioBtB.setEnabled(!true);
        jRadioBtC.setEnabled(!true);
        //
        jBtIncluirCurso.setEnabled(!true);
        jBtExcluirCurso.setEnabled(!true);
        //
        jBtNovoHistoricoEduca.setEnabled(true);
        jBtAlterarHistoricoEduca.setEnabled(true);
        jBtExcluirHistoricoEduca.setEnabled(true);
        jBtSalvarHistoricoEduca.setEnabled(!true);
        jBtCancelarHistoricoEduca.setEnabled(!true);
        jBtAuditoriaHistoricoEduca.setEnabled(true);
        jBtRefersCursos.setEnabled(!true);
        // HISTÓRICO LABORATIVO
        jBtNovoHistoricoLabor.setEnabled(true);
        jBtAlterarHistoricoLabor.setEnabled(!true);
        jBtExcluirHistoricoLabor.setEnabled(!true);
        jBtSalvarHistoricoLabor.setEnabled(!true);
        jBtCancelarHistoricoLabor.setEnabled(!true);
        jBtAuditoriaHistoricoLabor.setEnabled(!true);
        // MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
        // AVALIAÇÃO I
        jBtNovoAvaliacaoI.setEnabled(true);
        jBtAlterarAvaliacaoI.setEnabled(!true);
        jBtExcluirAvaliacaoI.setEnabled(!true);
        jBtSalvarAvaliacaoI.setEnabled(!true);
        jBtCancelarAvaliacaoI.setEnabled(!true);
        jBtAuditoriaAvaliacaoI.setEnabled(!true);
        // AVALIAÇÃO II
        jBtNovoAvaliacaoII.setEnabled(true);
        jBtAlterarAvaliacaoII.setEnabled(!true);
        jBtExcluirAvaliacaoII.setEnabled(!true);
        jBtSalvarAvaliacaoII.setEnabled(!true);
        jBtCancelarAvaliacaoII.setEnabled(!true);
        jBtAuditoriaAvaliacaoII.setEnabled(!true);
    }

    public void CancelarHistoricoEdu() {
        acao = 0;
        jComboBoxEscreveProprioNome.setEnabled(!true);
        jComboBoxSabeLerEscrever.setEnabled(!true);
        jComboBoxNivelInstrucao.setEnabled(!true);
        jComboBoxInteresseEstudar.setEnabled(!true);
        jComboBoxCursoProfissionalizante.setEnabled(!true);
        jComboBoxDescricaoCurso.setEnabled(!true);
        jRadioBtA.setEnabled(!true);
        jRadioBtB.setEnabled(!true);
        jRadioBtC.setEnabled(!true);
        //
        jBtIncluirCurso.setEnabled(!true);
        jBtExcluirCurso.setEnabled(!true);
        //
        if (codigoHistoricoEduca != 0) {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM TO_HISTORICO_EDUCACIONAL_NOVO "
                        + "INNER JOIN ADMISSAO_TERAPIA_PE "
                        + "ON TO_HISTORICO_EDUCACIONAL_NOVO.IdATN=ADMISSAO_TERAPIA_PE.IdATN "
                        + "WHERE TO_HISTORICO_EDUCACIONAL_NOVO.IdATN='" + jIdAtendNovo.getText() + "'");
                conecta.rs.first();
                codigoHistoricoEduca = conecta.rs.getInt("IdHistoricoEduN");
                jComboBoxEscreveProprioNome.setSelectedItem(conecta.rs.getString("EscreveProprioNome"));
                jComboBoxSabeLerEscrever.setSelectedItem(conecta.rs.getString("SabeLerEscrever"));
                jComboBoxNivelInstrucao.setSelectedItem(conecta.rs.getString("NivelInstrucao"));
                jComboBoxInteresseEstudar.setSelectedItem(conecta.rs.getString("InteresseEstudar"));
                jComboBoxCursoProfissionalizante.setSelectedItem(conecta.rs.getString("CursoProfissionalizante"));
            } catch (Exception e) {
            }
            // TABELA DE CURSOS PROFISSIONALIZANTES
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ITENS_CURSOS_TO_HISTORICO_EDUCACIONAL_NOVO "
                        + "INNER JOIN CURSOS "
                        + "ON ITENS_CURSOS_TO_HISTORICO_EDUCACIONAL_NOVO.IdCurso=CURSOS.IdCurso "
                        + "WHERE ITENS_CURSOS_TO_HISTORICO_EDUCACIONAL_NOVO.IdATN='" + jIdAtendNovo.getText() + "'");
                conecta.rs.first();
                idItem = conecta.rs.getInt("IdItemICTHEN");
                DefaultTableModel dtmCursos = (DefaultTableModel) jTabelaCursos_NOVO.getModel();
                dtmCursos.getDataVector().clear(); // limpa a tabela 
                do {
                    prioridadeCursoTabela = conecta.rs.getInt("PrioridadeCurso");
                    if (prioridadeCursoTabela == 0) {
                        prioridadeLetraCurso = "A";
                    } else if (prioridadeCursoTabela == 1) {
                        prioridadeLetraCurso = "B";
                    } else if (prioridadeCursoTabela == 2) {
                        prioridadeLetraCurso = "C";
                    }
                    dtmCursos.addRow(new Object[]{conecta.rs.getInt("IdCurso"), conecta.rs.getString("DescricaoCurso"), prioridadeLetraCurso});
                } while (conecta.rs.next());
            } catch (SQLException ex) {
            }
            if (codigoHistoricoEduca != 0) {
                jBtNovoHistoricoEduca.setEnabled(true);
                jBtAlterarHistoricoEduca.setEnabled(true);
                jBtExcluirHistoricoEduca.setEnabled(true);
                jBtSalvarHistoricoEduca.setEnabled(!true);
                jBtCancelarHistoricoEduca.setEnabled(true);
                jBtAuditoriaHistoricoEduca.setEnabled(true);
                jBtRefersCursos.setEnabled(!true);
            }
            conecta.desconecta();
            jBtNovoHistoricoEduca.setEnabled(true);
            jBtAlterarHistoricoEduca.setEnabled(true);
            jBtExcluirHistoricoEduca.setEnabled(true);
            jBtSalvarHistoricoEduca.setEnabled(!true);
            jBtCancelarHistoricoEduca.setEnabled(!true);
            jBtAuditoriaHistoricoEduca.setEnabled(true);
        } else {
            jBtNovoHistoricoEduca.setEnabled(true);
            jBtAlterarHistoricoEduca.setEnabled(!true);
            jBtExcluirHistoricoEduca.setEnabled(!true);
            jBtSalvarHistoricoEduca.setEnabled(!true);
            jBtCancelarHistoricoEduca.setEnabled(!true);
            jBtAuditoriaHistoricoEduca.setEnabled(!true);
            jBtRefersCursos.setEnabled(!true);
        }
        // HISTÓRICO LABORATIVO
        jBtNovoHistoricoLabor.setEnabled(true);
        jBtAlterarHistoricoLabor.setEnabled(!true);
        jBtExcluirHistoricoLabor.setEnabled(!true);
        jBtSalvarHistoricoLabor.setEnabled(!true);
        jBtCancelarHistoricoLabor.setEnabled(!true);
        jBtAuditoriaHistoricoLabor.setEnabled(!true);
        // MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
        // AVALIAÇÃO I
        jBtNovoAvaliacaoI.setEnabled(true);
        jBtAlterarAvaliacaoI.setEnabled(!true);
        jBtExcluirAvaliacaoI.setEnabled(!true);
        jBtSalvarAvaliacaoI.setEnabled(!true);
        jBtCancelarAvaliacaoI.setEnabled(!true);
        jBtAuditoriaAvaliacaoI.setEnabled(!true);
        // AVALIAÇÃO II
        jBtNovoAvaliacaoII.setEnabled(true);
        jBtAlterarAvaliacaoII.setEnabled(!true);
        jBtExcluirAvaliacaoII.setEnabled(!true);
        jBtSalvarAvaliacaoII.setEnabled(!true);
        jBtCancelarAvaliacaoII.setEnabled(!true);
        jBtAuditoriaAvaliacaoII.setEnabled(!true);
    }

    public void buscarCodigoHistoricoEduca() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM TO_HISTORICO_EDUCACIONAL_NOVO");
            conecta.rs.last();
            codigoHistoricoEduca = conecta.rs.getInt("IdHistoricoEduN");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarHistoricoEduca() {
        // VERIFICAR SE O INTERNO JÁ FOI CADASTRADO NESSE REGISTRO.
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM TO_HISTORICO_EDUCACIONAL_NOVO "
                    + "WHERE IdInternoCrc='" + jIdInternoAD.getText() + "' "
                    + "AND IdATN='" + jIdAtendNovo.getText() + "'");
            conecta.rs.first();
            codigoInterno = conecta.rs.getString("IdInternoCrc");
            codigoRegistro = conecta.rs.getString("IdATN");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void preencherComboNovo() {
        codigoCurso = "";
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM CURSOS ORDER BY DescricaoCurso");
            conecta.rs.first();
            do {
                jComboBoxDescricaoCurso.addItem(conecta.rs.getString("DescricaoCurso"));
                codigoCurso = conecta.rs.getString("IdCurso");
            } while (conecta.rs.next());
        } catch (SQLException ex) {//           
        }
        conecta.desconecta();
    }

    public void limparTabelaCursos() {

        while (jTabelaCursos_NOVO.getModel().getRowCount() > 0) {
            ((DefaultTableModel) jTabelaCursos_NOVO.getModel()).removeRow(0);
        }
    }

    public void incluirCursos() {
        // Grava os dados do arrayList na tabela
        for (int i = 0; i < jTabelaCursos_NOVO.getRowCount(); i++) {
            objHistEducLabor.setIdAtend(Integer.valueOf(jIdAtendNovo.getText()));
            objHistEducLabor.setIdHistoricoEduN(codigoHistoricoEduca);
            objHistEducLabor.setIdCurso((int) jTabelaCursos_NOVO.getValueAt(i, 0));
            objHistEducLabor.setDescricaoCurso((String) jTabelaCursos_NOVO.getValueAt(i, 1));
            objHistEducLabor.setCursoProfissionalizante((String) jTabelaCursos_NOVO.getValueAt(i, 2));
            objHistEducLabor.getDescricaoCurso();
            if (objHistEducLabor.getCursoProfissionalizante().equals("A")) {
                prioridadeCursos = 0;
            } else if (objHistEducLabor.getCursoProfissionalizante().equals("B")) {
                prioridadeCursos = 1;
            } else if (objHistEducLabor.getCursoProfissionalizante().equals("C")) {
                prioridadeCursos = 2;
            }
            objHistEducLabor.setPrioridadeCurso(prioridadeCursos);
            controleCursosTO.incluirCursos(objHistEducLabor);
        }
    }

    public void tabelaCursos() {

        jTabelaCursos_NOVO.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaCursos_NOVO.getColumnModel().getColumn(0).setResizable(false);
        jTabelaCursos_NOVO.getColumnModel().getColumn(1).setPreferredWidth(280);
        jTabelaCursos_NOVO.getColumnModel().getColumn(1).setResizable(false);
        jTabelaCursos_NOVO.getColumnModel().getColumn(2).setPreferredWidth(60);
        jTabelaCursos_NOVO.getColumnModel().getColumn(2).setResizable(false);
        jTabelaCursos_NOVO.getTableHeader().setReorderingAllowed(false);
        jTabelaCursos_NOVO.setAutoResizeMode(jTabelaCursos_NOVO.AUTO_RESIZE_OFF);
        jTabelaCursos_NOVO.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaCursos();
    }

    public void alinharCamposTabelaCursos() {
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaCursos_NOVO.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaCursos_NOVO.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }

    public void NovoHistoricoLabor() {
        jBtNovoHistoricoEduca.setEnabled(true);
        //HISTÓRICO LABORAL
        jComboBoxTemProfissao.setSelectedItem("Não");
        jComboBoxQualProfissao.setSelectedItem("Selecione...");
        jComboBoxExperienciaProfissional.setSelectedItem("Não");
        jComboBoxQualExperienciaProfissional.setSelectedItem("Selecione...");
        jComboBoxDesejaTrabalharUnid.setSelectedItem("Não");
        //
        jComboBoxTemProfissao.setEnabled(true);
        jComboBoxQualProfissao.setEnabled(true);
        jComboBoxExperienciaProfissional.setEnabled(true);
        jComboBoxQualExperienciaProfissional.setEnabled(true);
        jComboBoxDesejaTrabalharUnid.setEnabled(true);
        //
        jRadioBtRemunerado.setEnabled(true);
        jRadioBtNaoRemunerado.setEnabled(true);
        jRadioBtAmbos.setEnabled(true);
        //
        jBtIncluirExperiencia.setEnabled(true);
        jBtExcluirExperiencia.setEnabled(true);
        // HISTORICO LABORATIVO
        jBtNovoHistoricoLabor.setEnabled(!true);
        jBtAlterarHistoricoLabor.setEnabled(!true);
        jBtExcluirHistoricoLabor.setEnabled(!true);
        jBtSalvarHistoricoLabor.setEnabled(true);
        jBtCancelarHistoricoLabor.setEnabled(true);
        jBtAuditoriaHistoricoLabor.setEnabled(!true);
        jBtRefersProfissao.setEnabled(true);
        // HISTÓRICO EDUCACIONAL
        jBtNovoHistoricoEduca.setEnabled(!true);
        jBtAlterarHistoricoEduca.setEnabled(!true);
        jBtExcluirHistoricoEduca.setEnabled(!true);
        jBtSalvarHistoricoEduca.setEnabled(true);
        jBtCancelarHistoricoEduca.setEnabled(true);
        jBtAuditoriaHistoricoEduca.setEnabled(!true);
        // MANUTENÇÃO
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        // AVALIAÇÃO I
        jBtNovoAvaliacaoI.setEnabled(!true);
        jBtAlterarAvaliacaoI.setEnabled(!true);
        jBtExcluirAvaliacaoI.setEnabled(!true);
        jBtSalvarAvaliacaoI.setEnabled(!true);
        jBtCancelarAvaliacaoI.setEnabled(!true);
        jBtAuditoriaAvaliacaoI.setEnabled(!true);
        // AVALIAÇÃO II
        jBtNovoAvaliacaoII.setEnabled(!true);
        jBtAlterarAvaliacaoII.setEnabled(!true);
        jBtExcluirAvaliacaoII.setEnabled(!true);
        jBtSalvarAvaliacaoII.setEnabled(!true);
        jBtCancelarAvaliacaoII.setEnabled(!true);
        jBtAuditoriaAvaliacaoII.setEnabled(!true);
    }

    public void AlterarHistoricoLabor() {
        jComboBoxTemProfissao.setEnabled(true);
        jComboBoxQualProfissao.setEnabled(true);
        jComboBoxExperienciaProfissional.setEnabled(true);
        jComboBoxQualExperienciaProfissional.setEnabled(true);
        jComboBoxDesejaTrabalharUnid.setEnabled(true);
        //
        jRadioBtRemunerado.setEnabled(true);
        jRadioBtNaoRemunerado.setEnabled(true);
        jRadioBtAmbos.setEnabled(true);
        //
        jBtIncluirExperiencia.setEnabled(true);
        jBtExcluirExperiencia.setEnabled(true);
        // HISTORICO LABORATIVO
        jBtNovoHistoricoLabor.setEnabled(!true);
        jBtAlterarHistoricoLabor.setEnabled(!true);
        jBtExcluirHistoricoLabor.setEnabled(!true);
        jBtSalvarHistoricoLabor.setEnabled(true);
        jBtCancelarHistoricoLabor.setEnabled(true);
        jBtAuditoriaHistoricoLabor.setEnabled(!true);
        jBtRefersProfissao.setEnabled(true);
        // HISTÓRICO EDUCACIONAL
        jBtNovoHistoricoEduca.setEnabled(!true);
        jBtAlterarHistoricoEduca.setEnabled(!true);
        jBtExcluirHistoricoEduca.setEnabled(!true);
        jBtSalvarHistoricoEduca.setEnabled(!true);
        jBtCancelarHistoricoEduca.setEnabled(!true);
        jBtAuditoriaHistoricoEduca.setEnabled(!true);
        // MANUTENÇÃO
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        // AVALIAÇÃO I
        jBtNovoAvaliacaoI.setEnabled(!true);
        jBtAlterarAvaliacaoI.setEnabled(!true);
        jBtExcluirAvaliacaoI.setEnabled(!true);
        jBtSalvarAvaliacaoI.setEnabled(!true);
        jBtCancelarAvaliacaoI.setEnabled(!true);
        jBtAuditoriaAvaliacaoI.setEnabled(!true);
        // AVALIAÇÃO II
        jBtNovoAvaliacaoII.setEnabled(!true);
        jBtAlterarAvaliacaoII.setEnabled(!true);
        jBtExcluirAvaliacaoII.setEnabled(!true);
        jBtSalvarAvaliacaoII.setEnabled(!true);
        jBtCancelarAvaliacaoII.setEnabled(!true);
        jBtAuditoriaAvaliacaoII.setEnabled(!true);
    }

    public void ExcluirHistoricoLabor() {
        jComboBoxTemProfissao.setSelectedItem("Não");
        jComboBoxQualProfissao.setSelectedItem("Selecione...");
        jComboBoxExperienciaProfissional.setSelectedItem("Não");
        jComboBoxQualExperienciaProfissional.setSelectedItem("Selecione...");
        jComboBoxDesejaTrabalharUnid.setSelectedItem("Não");
        //
        jComboBoxTemProfissao.setEnabled(!true);
        jComboBoxQualProfissao.setEnabled(!true);
        jComboBoxExperienciaProfissional.setEnabled(!true);
        jComboBoxQualExperienciaProfissional.setEnabled(!true);
        jComboBoxDesejaTrabalharUnid.setEnabled(!true);
        //
        jRadioBtRemunerado.setEnabled(!true);
        jRadioBtNaoRemunerado.setEnabled(!true);
        jRadioBtAmbos.setEnabled(!true);
        //
        jBtIncluirExperiencia.setEnabled(!true);
        jBtExcluirExperiencia.setEnabled(!true);
        // HISTORICO LABORATIVO
        jBtNovoHistoricoLabor.setEnabled(true);
        jBtAlterarHistoricoLabor.setEnabled(!true);
        jBtExcluirHistoricoLabor.setEnabled(!true);
        jBtSalvarHistoricoLabor.setEnabled(!true);
        jBtCancelarHistoricoLabor.setEnabled(!true);
        jBtAuditoriaHistoricoLabor.setEnabled(!true);
        jBtRefersProfissao.setEnabled(!true);
        // HISTÓRICO EDUCACIONAL
        jBtNovoHistoricoEduca.setEnabled(true);
        jBtAlterarHistoricoEduca.setEnabled(!true);
        jBtExcluirHistoricoEduca.setEnabled(!true);
        jBtSalvarHistoricoEduca.setEnabled(!true);
        jBtCancelarHistoricoEduca.setEnabled(!true);
        jBtAuditoriaHistoricoEduca.setEnabled(!true);
        // MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
        // AVALIAÇÃO I
        jBtNovoAvaliacaoI.setEnabled(true);
        jBtAlterarAvaliacaoI.setEnabled(!true);
        jBtExcluirAvaliacaoI.setEnabled(!true);
        jBtSalvarAvaliacaoI.setEnabled(!true);
        jBtCancelarAvaliacaoI.setEnabled(!true);
        jBtAuditoriaAvaliacaoI.setEnabled(!true);
        // AVALIAÇÃO II
        jBtNovoAvaliacaoII.setEnabled(true);
        jBtAlterarAvaliacaoII.setEnabled(!true);
        jBtExcluirAvaliacaoII.setEnabled(!true);
        jBtSalvarAvaliacaoII.setEnabled(!true);
        jBtCancelarAvaliacaoII.setEnabled(!true);
        jBtAuditoriaAvaliacaoII.setEnabled(!true);
    }

    public void SalvarHistoricoLabor() {
        acao = 0;
        jComboBoxTemProfissao.setEnabled(!true);
        jComboBoxQualProfissao.setEnabled(!true);
        jComboBoxExperienciaProfissional.setEnabled(!true);
        jComboBoxQualExperienciaProfissional.setEnabled(!true);
        jComboBoxDesejaTrabalharUnid.setEnabled(!true);
        //
        jRadioBtRemunerado.setEnabled(!true);
        jRadioBtNaoRemunerado.setEnabled(!true);
        jRadioBtAmbos.setEnabled(!true);
        //
        jBtIncluirExperiencia.setEnabled(!true);
        jBtExcluirExperiencia.setEnabled(!true);
        // HISTORICO LABORATIVO
        jBtNovoHistoricoLabor.setEnabled(true);
        jBtAlterarHistoricoLabor.setEnabled(true);
        jBtExcluirHistoricoLabor.setEnabled(true);
        jBtSalvarHistoricoLabor.setEnabled(!true);
        jBtCancelarHistoricoLabor.setEnabled(true);
        jBtAuditoriaHistoricoLabor.setEnabled(true);
        jBtRefersProfissao.setEnabled(!true);
        // HISTÓRICO EDUCACIONAL
        jBtNovoHistoricoEduca.setEnabled(true);
        jBtAlterarHistoricoEduca.setEnabled(!true);
        jBtExcluirHistoricoEduca.setEnabled(!true);
        jBtSalvarHistoricoEduca.setEnabled(!true);
        jBtCancelarHistoricoEduca.setEnabled(!true);
        jBtAuditoriaHistoricoEduca.setEnabled(!true);
        // MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
        // AVALIAÇÃO I
        jBtNovoAvaliacaoI.setEnabled(true);
        jBtAlterarAvaliacaoI.setEnabled(!true);
        jBtExcluirAvaliacaoI.setEnabled(!true);
        jBtSalvarAvaliacaoI.setEnabled(!true);
        jBtCancelarAvaliacaoI.setEnabled(!true);
        jBtAuditoriaAvaliacaoI.setEnabled(!true);
        // AVALIAÇÃO II
        jBtNovoAvaliacaoII.setEnabled(true);
        jBtAlterarAvaliacaoII.setEnabled(!true);
        jBtExcluirAvaliacaoII.setEnabled(!true);
        jBtSalvarAvaliacaoII.setEnabled(!true);
        jBtCancelarAvaliacaoII.setEnabled(!true);
        jBtAuditoriaAvaliacaoII.setEnabled(!true);
        // TABELA DE HISTORICO EDUCACIONAL
        if (codigoHistoricoEduca != 0) {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM TO_HISTORICO_EDUCACIONAL_NOVO "
                        + "INNER JOIN ADMISSAO_TERAPIA_PE "
                        + "ON TO_HISTORICO_EDUCACIONAL_NOVO.IdATN=ADMISSAO_TERAPIA_PE.IdATN "
                        + "WHERE TO_HISTORICO_EDUCACIONAL_NOVO.IdATN='" + jIdAtendNovo.getText() + "'");
                conecta.rs.first();
                codigoHistoricoEduca = conecta.rs.getInt("IdHistoricoEduN");
                jComboBoxEscreveProprioNome.setSelectedItem(conecta.rs.getString("EscreveProprioNome"));
                jComboBoxSabeLerEscrever.setSelectedItem(conecta.rs.getString("SabeLerEscrever"));
                jComboBoxNivelInstrucao.setSelectedItem(conecta.rs.getString("NivelInstrucao"));
                jComboBoxInteresseEstudar.setSelectedItem(conecta.rs.getString("InteresseEstudar"));
                jComboBoxCursoProfissionalizante.setSelectedItem(conecta.rs.getString("CursoProfissionalizante"));
            } catch (Exception e) {
            }
            // TABELA DE CURSOS PROFISSIONALIZANTES
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ITENS_CURSOS_TO_HISTORICO_EDUCACIONAL_NOVO "
                        + "INNER JOIN CURSOS "
                        + "ON ITENS_CURSOS_TO_HISTORICO_EDUCACIONAL_NOVO.IdCurso=CURSOS.IdCurso "
                        + "WHERE ITENS_CURSOS_TO_HISTORICO_EDUCACIONAL_NOVO.IdATN='" + jIdAtendNovo.getText() + "'");
                conecta.rs.first();
                idItem = conecta.rs.getInt("IdItemICTHEN");
                DefaultTableModel dtmCursos = (DefaultTableModel) jTabelaCursos_NOVO.getModel();
                dtmCursos.getDataVector().clear(); // limpa a tabela 
                do {
                    prioridadeCursoTabela = conecta.rs.getInt("PrioridadeCurso");
                    if (prioridadeCursoTabela == 0) {
                        prioridadeLetraCurso = "A";
                    } else if (prioridadeCursoTabela == 1) {
                        prioridadeLetraCurso = "B";
                    } else if (prioridadeCursoTabela == 2) {
                        prioridadeLetraCurso = "C";
                    }
                    dtmCursos.addRow(new Object[]{conecta.rs.getInt("IdCurso"), conecta.rs.getString("DescricaoCurso"), prioridadeLetraCurso});
                } while (conecta.rs.next());
            } catch (SQLException ex) {
            }
            if (codigoHistoricoEduca != 0) {
                jBtNovoHistoricoEduca.setEnabled(true);
                jBtAlterarHistoricoEduca.setEnabled(true);
                jBtExcluirHistoricoEduca.setEnabled(true);
                jBtSalvarHistoricoEduca.setEnabled(!true);
                jBtCancelarHistoricoEduca.setEnabled(true);
                jBtAuditoriaHistoricoEduca.setEnabled(true);
            }
            conecta.desconecta();
        }
    }

    public void CancelarHistoricoLabor() {
        acao = 0;
        jComboBoxTemProfissao.setEnabled(!true);
        jComboBoxQualProfissao.setEnabled(!true);
        jComboBoxExperienciaProfissional.setEnabled(!true);
        jComboBoxQualExperienciaProfissional.setEnabled(!true);
        jComboBoxDesejaTrabalharUnid.setEnabled(!true);
        //
        jRadioBtRemunerado.setEnabled(!true);
        jRadioBtNaoRemunerado.setEnabled(!true);
        jRadioBtAmbos.setEnabled(!true);
        //
        jBtIncluirExperiencia.setEnabled(!true);
        jBtExcluirExperiencia.setEnabled(!true);
        // HISTORICO LABORATIVO
        jBtNovoHistoricoLabor.setEnabled(true);
        jBtAlterarHistoricoLabor.setEnabled(!true);
        jBtExcluirHistoricoLabor.setEnabled(!true);
        jBtSalvarHistoricoLabor.setEnabled(!true);
        jBtCancelarHistoricoLabor.setEnabled(!true);
        jBtAuditoriaHistoricoLabor.setEnabled(!true);
        // HISTÓRICO EDUCACIONAL
        jBtNovoHistoricoEduca.setEnabled(true);
        jBtAlterarHistoricoEduca.setEnabled(!true);
        jBtExcluirHistoricoEduca.setEnabled(!true);
        jBtSalvarHistoricoEduca.setEnabled(!true);
        jBtCancelarHistoricoEduca.setEnabled(!true);
        jBtAuditoriaHistoricoEduca.setEnabled(!true);
        jBtRefersProfissao.setEnabled(!true);
        // MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
        // AVALIAÇÃO I
        jBtNovoAvaliacaoI.setEnabled(true);
        jBtAlterarAvaliacaoI.setEnabled(!true);
        jBtExcluirAvaliacaoI.setEnabled(!true);
        jBtSalvarAvaliacaoI.setEnabled(!true);
        jBtCancelarAvaliacaoI.setEnabled(!true);
        jBtAuditoriaAvaliacaoI.setEnabled(!true);
        // AVALIAÇÃO II
        jBtNovoAvaliacaoII.setEnabled(true);
        jBtAlterarAvaliacaoII.setEnabled(!true);
        jBtExcluirAvaliacaoII.setEnabled(!true);
        jBtSalvarAvaliacaoII.setEnabled(!true);
        jBtCancelarAvaliacaoII.setEnabled(!true);
        jBtAuditoriaAvaliacaoII.setEnabled(!true);
        //
        if (codigoHistoricoProf != 0) {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM TO_HISTORICO_PROFISSIONAL_NOVO "
                        + "INNER JOIN ADMISSAO_TERAPIA_PE "
                        + "ON TO_HISTORICO_PROFISSIONAL_NOVO.IdATN=ADMISSAO_TERAPIA_PE.IdATN "
                        + "WHERE TO_HISTORICO_PROFISSIONAL_NOVO.IdATN='" + jIdAtendNovo.getText() + "'");
                conecta.rs.first();
                codigoHistoricoProf = conecta.rs.getInt("IdHistoricoLabPN");
                jComboBoxTemProfissao.setSelectedItem(conecta.rs.getString("TemProfissao"));
                jComboBoxQualProfissao.setSelectedItem(conecta.rs.getString("QualProfissao"));
                jComboBoxExperienciaProfissional.setSelectedItem(conecta.rs.getString("ExperienciaProfissional"));
                jComboBoxDesejaTrabalharUnid.setSelectedItem(conecta.rs.getString("DesejaTrabalharUnid"));
            } catch (Exception e) {
            }
            // TABELA DE EXPERIENCIAS PROFISSIONAIS
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ITENS_PROFISSAO_TO_HISTORICO_PROFISSIONAL_NOVO "
                        + "INNER JOIN PROFISSAO "
                        + "ON ITENS_PROFISSAO_TO_HISTORICO_PROFISSIONAL_NOVO.IdCodigoProf=PROFISSAO.IdCodigoProf "
                        + "WHERE ITENS_PROFISSAO_TO_HISTORICO_PROFISSIONAL_NOVO.IdATN='" + jIdAtendNovo.getText() + "'");
                conecta.rs.first();
                idItemProf = conecta.rs.getInt("IdItemPTHPN");
                DefaultTableModel dtmProf = (DefaultTableModel) jTabelaExperiencia.getModel();
                dtmProf.getDataVector().clear(); // limpa a tabela 
                do {
                    remuneracao = conecta.rs.getInt("InteresseLabor");
                    if (remuneracao == 0) {
                        tipoRemuneracao = "Remunerada";
                    } else if (remuneracao == 1) {
                        tipoRemuneracao = "Não Remunerada";
                    } else if (remuneracao == 2) {
                        tipoRemuneracao = "Ambas";
                    }
                    dtmProf.addRow(new Object[]{conecta.rs.getInt("IdCodigoProf"), conecta.rs.getString("DescricaoProf"), tipoRemuneracao});
                } while (conecta.rs.next());
            } catch (SQLException ex) {
            }
            // HISTORICO LABORATIVO
            jBtNovoHistoricoLabor.setEnabled(true);
            jBtAlterarHistoricoLabor.setEnabled(true);
            jBtExcluirHistoricoLabor.setEnabled(true);
            jBtSalvarHistoricoLabor.setEnabled(!true);
            jBtCancelarHistoricoLabor.setEnabled(!true);
            jBtAuditoriaHistoricoLabor.setEnabled(true);
        } else {
            jComboBoxTemProfissao.setSelectedItem("Não");
            jComboBoxQualProfissao.setSelectedItem("Selecione...");
            jComboBoxExperienciaProfissional.setSelectedItem("Não");
            jComboBoxQualExperienciaProfissional.setSelectedItem("Selecione...");
            jComboBoxDesejaTrabalharUnid.setSelectedItem("Não");
            limparTabelaExperiencia();
        }
        // TABELA DE HISTORICO EDUCACIONAL
        if (codigoHistoricoEduca != 0) {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM TO_HISTORICO_EDUCACIONAL_NOVO "
                        + "INNER JOIN ADMISSAO_TERAPIA_PE "
                        + "ON TO_HISTORICO_EDUCACIONAL_NOVO.IdATN=ADMISSAO_TERAPIA_PE.IdATN "
                        + "WHERE TO_HISTORICO_EDUCACIONAL_NOVO.IdATN='" + jIdAtendNovo.getText() + "'");
                conecta.rs.first();
                codigoHistoricoEduca = conecta.rs.getInt("IdHistoricoEduN");
                jComboBoxEscreveProprioNome.setSelectedItem(conecta.rs.getString("EscreveProprioNome"));
                jComboBoxSabeLerEscrever.setSelectedItem(conecta.rs.getString("SabeLerEscrever"));
                jComboBoxNivelInstrucao.setSelectedItem(conecta.rs.getString("NivelInstrucao"));
                jComboBoxInteresseEstudar.setSelectedItem(conecta.rs.getString("InteresseEstudar"));
                jComboBoxCursoProfissionalizante.setSelectedItem(conecta.rs.getString("CursoProfissionalizante"));
            } catch (Exception e) {
            }
            // TABELA DE CURSOS PROFISSIONALIZANTES
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ITENS_CURSOS_TO_HISTORICO_EDUCACIONAL_NOVO "
                        + "INNER JOIN CURSOS "
                        + "ON ITENS_CURSOS_TO_HISTORICO_EDUCACIONAL_NOVO.IdCurso=CURSOS.IdCurso "
                        + "WHERE ITENS_CURSOS_TO_HISTORICO_EDUCACIONAL_NOVO.IdATN='" + jIdAtendNovo.getText() + "'");
                conecta.rs.first();
                idItem = conecta.rs.getInt("IdItemICTHEN");
                DefaultTableModel dtmCursos = (DefaultTableModel) jTabelaCursos_NOVO.getModel();
                dtmCursos.getDataVector().clear(); // limpa a tabela 
                do {
                    prioridadeCursoTabela = conecta.rs.getInt("PrioridadeCurso");
                    if (prioridadeCursoTabela == 0) {
                        prioridadeLetraCurso = "A";
                    } else if (prioridadeCursoTabela == 1) {
                        prioridadeLetraCurso = "B";
                    } else if (prioridadeCursoTabela == 2) {
                        prioridadeLetraCurso = "C";
                    }
                    dtmCursos.addRow(new Object[]{conecta.rs.getInt("IdCurso"), conecta.rs.getString("DescricaoCurso"), prioridadeLetraCurso});
                } while (conecta.rs.next());
            } catch (SQLException ex) {
            }
            if (codigoHistoricoEduca != 0) {
                jBtNovoHistoricoEduca.setEnabled(true);
                jBtAlterarHistoricoEduca.setEnabled(true);
                jBtExcluirHistoricoEduca.setEnabled(true);
                jBtSalvarHistoricoEduca.setEnabled(!true);
                jBtCancelarHistoricoEduca.setEnabled(true);
                jBtAuditoriaHistoricoEduca.setEnabled(true);
            }
            conecta.desconecta();
        }
    }

    public void buscarHistoricoLabor() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM TO_HISTORICO_PROFISSIONAL_NOVO");
            conecta.rs.last();
            codigoHistoricoProf = conecta.rs.getInt("IdHistoricoLabPN");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void incluirExperiencia() {
        // Grava os dados do arrayList na tabela
        for (int i = 0; i < jTabelaExperiencia.getRowCount(); i++) {
            objHistEducLabor.setIdATN(Integer.valueOf(jIdAtendNovo.getText()));
            objHistEducLabor.setIdHistoricoLabPN(codigoHistoricoProf);
            objHistEducLabor.setIdProfissao((int) jTabelaExperiencia.getValueAt(i, 0));
            objHistEducLabor.setExperienciaProfissional((String) jTabelaExperiencia.getValueAt(i, 1));
            objHistEducLabor.getExperienciaProfissional();
            controleExpTO.incluirExperiencia(objHistEducLabor);
        }
    }

    public void limparTabelaExperiencia() {

        while (jTabelaExperiencia.getModel().getRowCount() > 0) {
            ((DefaultTableModel) jTabelaExperiencia.getModel()).removeRow(0);
        }
    }

    public void tabelaExperiencia() {

        jTabelaExperiencia.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaExperiencia.getColumnModel().getColumn(0).setResizable(false);
        jTabelaExperiencia.getColumnModel().getColumn(1).setPreferredWidth(350);
        jTabelaExperiencia.getColumnModel().getColumn(1).setResizable(false);
        jTabelaExperiencia.getTableHeader().setReorderingAllowed(false);
        jTabelaExperiencia.setAutoResizeMode(jTabelaExperiencia.AUTO_RESIZE_OFF);
        jTabelaExperiencia.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaExperiencia();
    }

    public void alinharCamposTabelaExperiencia() {
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaExperiencia.getColumnModel().getColumn(0).setCellRenderer(centralizado);
    }

    public void verificarHistoricoLabor() {
        // VERIFICAR SE O INTERNO JÁ FOI CADASTRADO NESSE REGISTRO.
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM TO_HISTORICO_PROFISSIONAL_NOVO "
                    + "WHERE IdInternoCrc='" + jIdInternoAD.getText() + "' "
                    + "AND IdATN='" + jIdAtendNovo.getText() + "'");
            conecta.rs.first();
            codigoInterno = conecta.rs.getString("IdInternoCrc");
            codigoRegistro = conecta.rs.getString("IdATN");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void preencherComboProfissao() {
        codigoProfissao = "";
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PROFISSAO ORDER BY DescricaoProf");
            conecta.rs.first();
            do {
                jComboBoxQualProfissao.addItem(conecta.rs.getString("DescricaoProf"));
                codigoProfissao = conecta.rs.getString("IdCodigoProf");
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void preencherComboExperiencia() {
        codigoExpProfissao = "";
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PROFISSAO ORDER BY DescricaoProf");
            conecta.rs.first();
            do {
                jComboBoxQualExperienciaProfissional.addItem(conecta.rs.getString("DescricaoProf"));
                codigoExpProfissao = conecta.rs.getString("IdCodigoProf");
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void NovaAvaliacaoI() {
        jComboBoxConhecoHabilidades.setSelectedItem("Sim");
        jComboBoxAcreditaRealizacoes.setSelectedItem("Sim");
        jComboBoxEsperoResultados.setSelectedItem("Sim");
        jComboBoxAcreditoRealizaTrabalho.setSelectedItem("Sim");
        jComboBoxAcreditoRealizaLar.setSelectedItem("Sim");
        jComboBoxAcreditoDiverteLazer.setSelectedItem("Sim");
        jComboBoxFacoAtividades.setSelectedItem("Sim");
        jComboBoxTenhoExpectativa.setSelectedItem("Sim");
        jComboBoxTenhoObjetoFuturo.setSelectedItem("Sim");
        jComboBoxIdentificoGostos.setSelectedItem("Sim");
        jComboBoxParticipoProjetosImport.setSelectedItem("Sim");
        jComboBoxTenhoVariosInteresse.setSelectedItem("Sim");
        jComboBoxCostumoComprometo.setSelectedItem("Sim");
        jComboBoxDeEstudante.setSelectedItem("Sim");
        jComboBoxDeTrabalho.setSelectedItem("Sim");
        jComboBoxDeAmigo.setSelectedItem("Sim");
        jComboBoxDeFamiliar.setSelectedItem("Sim");
        jComboBoxReconhecoPapeis.setSelectedItem("Sim");
        jComboBoxMantenhoVida.setSelectedItem("Sim");
        //
        jComboBoxConhecoHabilidades.setEnabled(true);
        jComboBoxAcreditaRealizacoes.setEnabled(true);
        jComboBoxEsperoResultados.setEnabled(true);
        jComboBoxAcreditoRealizaTrabalho.setEnabled(true);
        jComboBoxAcreditoRealizaLar.setEnabled(true);
        jComboBoxAcreditoDiverteLazer.setEnabled(true);
        jComboBoxFacoAtividades.setEnabled(true);
        jComboBoxTenhoExpectativa.setEnabled(true);
        jComboBoxTenhoObjetoFuturo.setEnabled(true);
        jComboBoxIdentificoGostos.setEnabled(true);
        jComboBoxParticipoProjetosImport.setEnabled(true);
        jComboBoxTenhoVariosInteresse.setEnabled(true);
        jComboBoxCostumoComprometo.setEnabled(true);
        jComboBoxDeEstudante.setEnabled(true);
        jComboBoxDeTrabalho.setEnabled(true);
        jComboBoxDeAmigo.setEnabled(true);
        jComboBoxDeFamiliar.setEnabled(true);
        jComboBoxReconhecoPapeis.setEnabled(true);
        jComboBoxMantenhoVida.setEnabled(true);
        //
        jBtNovoAvaliacaoI.setEnabled(true);
        jBtAlterarAvaliacaoI.setEnabled(!true);
        jBtExcluirAvaliacaoI.setEnabled(!true);
        jBtSalvarAvaliacaoI.setEnabled(true);
        jBtCancelarAvaliacaoI.setEnabled(true);
        jBtAuditoriaAvaliacaoI.setEnabled(!true);
    }

    public void AlterarAvaliacaoI() {
        jComboBoxConhecoHabilidades.setEnabled(true);
        jComboBoxAcreditaRealizacoes.setEnabled(true);
        jComboBoxEsperoResultados.setEnabled(true);
        jComboBoxAcreditoRealizaTrabalho.setEnabled(true);
        jComboBoxAcreditoRealizaLar.setEnabled(true);
        jComboBoxAcreditoDiverteLazer.setEnabled(true);
        jComboBoxFacoAtividades.setEnabled(true);
        jComboBoxTenhoExpectativa.setEnabled(true);
        jComboBoxTenhoObjetoFuturo.setEnabled(true);
        jComboBoxIdentificoGostos.setEnabled(true);
        jComboBoxParticipoProjetosImport.setEnabled(true);
        jComboBoxTenhoVariosInteresse.setEnabled(true);
        jComboBoxCostumoComprometo.setEnabled(true);
        jComboBoxDeEstudante.setEnabled(true);
        jComboBoxDeTrabalho.setEnabled(true);
        jComboBoxDeAmigo.setEnabled(true);
        jComboBoxDeFamiliar.setEnabled(true);
        jComboBoxReconhecoPapeis.setEnabled(true);
        jComboBoxMantenhoVida.setEnabled(true);
        //
        jBtNovoAvaliacaoI.setEnabled(true);
        jBtAlterarAvaliacaoI.setEnabled(!true);
        jBtExcluirAvaliacaoI.setEnabled(!true);
        jBtSalvarAvaliacaoI.setEnabled(true);
        jBtCancelarAvaliacaoI.setEnabled(true);
        jBtAuditoriaAvaliacaoI.setEnabled(!true);
    }

    public void ExcluirAvaliacaoI() {
        jComboBoxConhecoHabilidades.setSelectedItem("Sim");
        jComboBoxAcreditaRealizacoes.setSelectedItem("Sim");
        jComboBoxEsperoResultados.setSelectedItem("Sim");
        jComboBoxAcreditoRealizaTrabalho.setSelectedItem("Sim");
        jComboBoxAcreditoRealizaLar.setSelectedItem("Sim");
        jComboBoxAcreditoDiverteLazer.setSelectedItem("Sim");
        jComboBoxFacoAtividades.setSelectedItem("Sim");
        jComboBoxTenhoExpectativa.setSelectedItem("Sim");
        jComboBoxTenhoObjetoFuturo.setSelectedItem("Sim");
        jComboBoxIdentificoGostos.setSelectedItem("Sim");
        jComboBoxParticipoProjetosImport.setSelectedItem("Sim");
        jComboBoxTenhoVariosInteresse.setSelectedItem("Sim");
        jComboBoxCostumoComprometo.setSelectedItem("Sim");
        jComboBoxDeEstudante.setSelectedItem("Sim");
        jComboBoxDeTrabalho.setSelectedItem("Sim");
        jComboBoxDeAmigo.setSelectedItem("Sim");
        jComboBoxDeFamiliar.setSelectedItem("Sim");
        jComboBoxReconhecoPapeis.setSelectedItem("Sim");
        jComboBoxMantenhoVida.setSelectedItem("Sim");
        //
        jComboBoxConhecoHabilidades.setEnabled(!true);
        jComboBoxAcreditaRealizacoes.setEnabled(!true);
        jComboBoxEsperoResultados.setEnabled(!true);
        jComboBoxAcreditoRealizaTrabalho.setEnabled(!true);
        jComboBoxAcreditoRealizaLar.setEnabled(!true);
        jComboBoxAcreditoDiverteLazer.setEnabled(!true);
        jComboBoxFacoAtividades.setEnabled(!true);
        jComboBoxTenhoExpectativa.setEnabled(!true);
        jComboBoxTenhoObjetoFuturo.setEnabled(!true);
        jComboBoxIdentificoGostos.setEnabled(!true);
        jComboBoxParticipoProjetosImport.setEnabled(!true);
        jComboBoxTenhoVariosInteresse.setEnabled(!true);
        jComboBoxCostumoComprometo.setEnabled(!true);
        jComboBoxDeEstudante.setEnabled(!true);
        jComboBoxDeTrabalho.setEnabled(!true);
        jComboBoxDeAmigo.setEnabled(!true);
        jComboBoxDeFamiliar.setEnabled(!true);
        jComboBoxReconhecoPapeis.setEnabled(!true);
        jComboBoxMantenhoVida.setEnabled(!true);
        //
        jBtNovoAvaliacaoI.setEnabled(true);
        jBtAlterarAvaliacaoI.setEnabled(true);
        jBtExcluirAvaliacaoI.setEnabled(true);
        jBtSalvarAvaliacaoI.setEnabled(!true);
        jBtCancelarAvaliacaoI.setEnabled(!true);
        jBtAuditoriaAvaliacaoI.setEnabled(!true);
        //
        jBtNovoAvaliacaoII.setEnabled(true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtImpressao.setEnabled(true);
        jBtAuditoria.setEnabled(true);
    }

    public void SalvarAvaliacaoI() {
        jComboBoxConhecoHabilidades.setEnabled(!true);
        jComboBoxAcreditaRealizacoes.setEnabled(!true);
        jComboBoxEsperoResultados.setEnabled(!true);
        jComboBoxAcreditoRealizaTrabalho.setEnabled(!true);
        jComboBoxAcreditoRealizaLar.setEnabled(!true);
        jComboBoxAcreditoDiverteLazer.setEnabled(!true);
        jComboBoxFacoAtividades.setEnabled(!true);
        jComboBoxTenhoExpectativa.setEnabled(!true);
        jComboBoxTenhoObjetoFuturo.setEnabled(!true);
        jComboBoxIdentificoGostos.setEnabled(!true);
        jComboBoxParticipoProjetosImport.setEnabled(!true);
        jComboBoxTenhoVariosInteresse.setEnabled(!true);
        jComboBoxCostumoComprometo.setEnabled(!true);
        jComboBoxDeEstudante.setEnabled(!true);
        jComboBoxDeTrabalho.setEnabled(!true);
        jComboBoxDeAmigo.setEnabled(!true);
        jComboBoxDeFamiliar.setEnabled(!true);
        jComboBoxReconhecoPapeis.setEnabled(!true);
        jComboBoxMantenhoVida.setEnabled(!true);
        //
        jBtNovoAvaliacaoI.setEnabled(true);
        jBtAlterarAvaliacaoI.setEnabled(true);
        jBtExcluirAvaliacaoI.setEnabled(true);
        jBtSalvarAvaliacaoI.setEnabled(!true);
        jBtCancelarAvaliacaoI.setEnabled(!true);
        jBtAuditoriaAvaliacaoI.setEnabled(true);
        //
        jBtNovoAvaliacaoII.setEnabled(true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtImpressao.setEnabled(true);
        jBtAuditoria.setEnabled(true);
    }

    public void CancelarAvaliacaoI() {
        jComboBoxConhecoHabilidades.setEnabled(!true);
        jComboBoxAcreditaRealizacoes.setEnabled(!true);
        jComboBoxEsperoResultados.setEnabled(!true);
        jComboBoxAcreditoRealizaTrabalho.setEnabled(!true);
        jComboBoxAcreditoRealizaLar.setEnabled(!true);
        jComboBoxAcreditoDiverteLazer.setEnabled(!true);
        jComboBoxFacoAtividades.setEnabled(!true);
        jComboBoxTenhoExpectativa.setEnabled(!true);
        jComboBoxTenhoObjetoFuturo.setEnabled(!true);
        jComboBoxIdentificoGostos.setEnabled(!true);
        jComboBoxParticipoProjetosImport.setEnabled(!true);
        jComboBoxTenhoVariosInteresse.setEnabled(!true);
        jComboBoxCostumoComprometo.setEnabled(!true);
        jComboBoxDeEstudante.setEnabled(!true);
        jComboBoxDeTrabalho.setEnabled(!true);
        jComboBoxDeAmigo.setEnabled(!true);
        jComboBoxDeFamiliar.setEnabled(!true);
        jComboBoxReconhecoPapeis.setEnabled(!true);
        jComboBoxMantenhoVida.setEnabled(!true);
        //
        jBtNovoAvaliacaoII.setEnabled(true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtImpressao.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM AVALIACAO_TO_I "
                    + "INNER JOIN ADMISSAO_TERAPIA_PE "
                    + "ON AVALIACAO_TO_I.IdATN=ADMISSAO_TERAPIA_PE.IdATN "
                    + "WHERE AVALIACAO_TO_I.IdATN='" + jIdAtendNovo.getText() + "'");
            conecta.rs.first();
            codigoAvaliacaoI = conecta.rs.getInt("IdAvaliaTOI");
            jComboBoxConhecoHabilidades.setSelectedItem(conecta.rs.getString("ConhecoHabilidades"));
            jComboBoxAcreditaRealizacoes.setSelectedItem(conecta.rs.getString("AcreditaRealizacoes"));
            jComboBoxEsperoResultados.setSelectedItem(conecta.rs.getString("EsperoResultados"));
            jComboBoxAcreditoRealizaTrabalho.setSelectedItem(conecta.rs.getString("AcreditoRealizaTrabalho"));
            jComboBoxAcreditoRealizaLar.setSelectedItem(conecta.rs.getString("AcreditoRealizaLar"));
            jComboBoxAcreditoDiverteLazer.setSelectedItem(conecta.rs.getString("AcreditoDiverteLazer"));
            jComboBoxFacoAtividades.setSelectedItem(conecta.rs.getString("FacoAtividades"));
            jComboBoxTenhoExpectativa.setSelectedItem(conecta.rs.getString("TenhoExpectativa"));
            jComboBoxTenhoObjetoFuturo.setSelectedItem(conecta.rs.getString("TenhoObjetoFuturo"));
            jComboBoxIdentificoGostos.setSelectedItem(conecta.rs.getString("IdentificoGostos"));
            jComboBoxParticipoProjetosImport.setSelectedItem(conecta.rs.getString("ParticipoProjetosImport"));
            jComboBoxTenhoVariosInteresse.setSelectedItem(conecta.rs.getString("TenhoVariosInteresse"));
            jComboBoxCostumoComprometo.setSelectedItem(conecta.rs.getString("CostumoComprometo"));
            jComboBoxDeEstudante.setSelectedItem(conecta.rs.getString("DeEstudante"));
            jComboBoxDeTrabalho.setSelectedItem(conecta.rs.getString("DeTrabalho"));
            jComboBoxDeAmigo.setSelectedItem(conecta.rs.getString("DeAmigo"));
            jComboBoxDeFamiliar.setSelectedItem(conecta.rs.getString("DeFamiliar"));
            jComboBoxReconhecoPapeis.setSelectedItem(conecta.rs.getString("ReconhecoPapeis"));
            jComboBoxMantenhoVida.setSelectedItem(conecta.rs.getString("MantenhoVida"));
            if (codigoAvaliacaoI != 0) {
                jBtNovoAvaliacaoI.setEnabled(true);
                jBtAlterarAvaliacaoI.setEnabled(true);
                jBtExcluirAvaliacaoI.setEnabled(true);
                jBtSalvarAvaliacaoI.setEnabled(!true);
                jBtCancelarAvaliacaoI.setEnabled(!true);
                jBtAuditoriaAvaliacaoI.setEnabled(true);
            }
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void buscarCodigoAvaliacaoI() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM AVALIACAO_TO_I");
            conecta.rs.last();
            codigoAvaliacaoI = conecta.rs.getInt("IdAvaliaTOI");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter o código do registro.");
        }
        conecta.desconecta();
    }

    public void verificarCodigoAvaliacaoI() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM AVALIACAO_TO_I "
                    + "WHERE IdATN='" + jIdAtendNovo.getText() + "' "
                    + "AND IdInternoCrc='" + jIdInternoAD.getText() + "'");
            conecta.rs.first();
            codigoAtend = conecta.rs.getString("IdATN");
            codigoInternoAtend = conecta.rs.getString("IdInternoCrc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void NovaAvaliacaoII() {
        jComboBoxConhecoHabilidades.setSelectedItem("Sim");
        jComboBoxOrganizoTempo.setSelectedItem("Sim");
        jComboBoxMantenhoPapeis.setSelectedItem("Sim");
        jComboBoxSouRotina.setSelectedItem("Sim");
        jComboBoxConsigoOutros.setSelectedItem("Sim");
        jComboBoxTenhoSocial.setSelectedItem("Sim");
        jComboBoxPlanejoAgir.setSelectedItem("Sim");
        jComboBoxConcentroTrabalho.setSelectedItem("Sim");
        jComboBoxIdentificoProblemas.setSelectedItem("Sim");
        jComboBoxIdentificoSolucaoProblemas.setSelectedItem("Sim");
        jComboBoxQuandoAgir.setSelectedItem("Sim");
        jComboBoxConsigoHigiene.setSelectedItem("Sim");
        jComboBoxConsigoCasa.setSelectedItem("Sim");
        jComboBoxConsigoCotidianas.setSelectedItem("Sim");
        jComboBoxConsigoFinancas.setSelectedItem("Sim");
        jComboBoxSintoPreciso.setSelectedItem("Sim");
        jComboBoxCostumoFrequentar.setSelectedItem("Sim");
        jDataAplicacao.setCalendar(Calendar.getInstance());
        jResponsavelAplicacao.setText(nameUser);
        //
        jComboBoxConhecoHabilidades.setEnabled(true);
        jComboBoxOrganizoTempo.setEnabled(true);
        jComboBoxMantenhoPapeis.setEnabled(true);
        jComboBoxSouRotina.setEnabled(true);
        jComboBoxConsigoOutros.setEnabled(true);
        jComboBoxTenhoSocial.setEnabled(true);
        jComboBoxPlanejoAgir.setEnabled(true);
        jComboBoxConcentroTrabalho.setEnabled(true);
        jComboBoxIdentificoProblemas.setEnabled(true);
        jComboBoxIdentificoSolucaoProblemas.setEnabled(true);
        jComboBoxQuandoAgir.setEnabled(true);
        jComboBoxConsigoHigiene.setEnabled(true);
        jComboBoxConsigoCasa.setEnabled(true);
        jComboBoxConsigoCotidianas.setEnabled(true);
        jComboBoxConsigoFinancas.setEnabled(true);
        jComboBoxSintoPreciso.setEnabled(true);
        jComboBoxCostumoFrequentar.setEnabled(true);
        jDataAplicacao.setEnabled(true);
        //
        jBtNovoAvaliacaoII.setEnabled(!true);
        jBtAlterarAvaliacaoII.setEnabled(!true);
        jBtExcluirAvaliacaoII.setEnabled(!true);
        jBtSalvarAvaliacaoII.setEnabled(true);
        jBtCancelarAvaliacaoII.setEnabled(true);
        jBtAuditoriaAvaliacaoII.setEnabled(!true);
        // AVALIAÇÃO I
        jBtNovoAvaliacaoI.setEnabled(!true);
        jBtAlterarAvaliacaoI.setEnabled(!true);
        jBtExcluirAvaliacaoI.setEnabled(!true);
        jBtSalvarAvaliacaoI.setEnabled(!true);
        jBtCancelarAvaliacaoI.setEnabled(!true);
        jBtAuditoriaAvaliacaoI.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
    }

    public void AlterarAvaliacaoII() {
        jComboBoxConhecoHabilidades.setEnabled(true);
        jComboBoxOrganizoTempo.setEnabled(true);
        jComboBoxMantenhoPapeis.setEnabled(true);
        jComboBoxSouRotina.setEnabled(true);
        jComboBoxConsigoOutros.setEnabled(true);
        jComboBoxTenhoSocial.setEnabled(true);
        jComboBoxPlanejoAgir.setEnabled(true);
        jComboBoxConcentroTrabalho.setEnabled(true);
        jComboBoxIdentificoProblemas.setEnabled(true);
        jComboBoxIdentificoSolucaoProblemas.setEnabled(true);
        jComboBoxQuandoAgir.setEnabled(true);
        jComboBoxConsigoHigiene.setEnabled(true);
        jComboBoxConsigoCasa.setEnabled(true);
        jComboBoxConsigoCotidianas.setEnabled(true);
        jComboBoxConsigoFinancas.setEnabled(true);
        jComboBoxSintoPreciso.setEnabled(true);
        jComboBoxCostumoFrequentar.setEnabled(true);
        jDataAplicacao.setEnabled(true);
        //
        jBtNovoAvaliacaoII.setEnabled(!true);
        jBtAlterarAvaliacaoII.setEnabled(!true);
        jBtExcluirAvaliacaoII.setEnabled(!true);
        jBtSalvarAvaliacaoII.setEnabled(true);
        jBtCancelarAvaliacaoII.setEnabled(true);
        jBtAuditoriaAvaliacaoII.setEnabled(!true);
        // AVALIAÇÃO I
        jBtNovoAvaliacaoI.setEnabled(!true);
        jBtAlterarAvaliacaoI.setEnabled(!true);
        jBtExcluirAvaliacaoI.setEnabled(!true);
        jBtSalvarAvaliacaoI.setEnabled(!true);
        jBtCancelarAvaliacaoI.setEnabled(!true);
        jBtAuditoriaAvaliacaoI.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
    }

    public void ExcluirAvaliacaoII() {
        jComboBoxConhecoHabilidades.setSelectedItem("Sim");
        jComboBoxOrganizoTempo.setSelectedItem("Sim");
        jComboBoxMantenhoPapeis.setSelectedItem("Sim");
        jComboBoxSouRotina.setSelectedItem("Sim");
        jComboBoxConsigoOutros.setSelectedItem("Sim");
        jComboBoxTenhoSocial.setSelectedItem("Sim");
        jComboBoxPlanejoAgir.setSelectedItem("Sim");
        jComboBoxConcentroTrabalho.setSelectedItem("Sim");
        jComboBoxIdentificoProblemas.setSelectedItem("Sim");
        jComboBoxIdentificoSolucaoProblemas.setSelectedItem("Sim");
        jComboBoxQuandoAgir.setSelectedItem("Sim");
        jComboBoxConsigoHigiene.setSelectedItem("Sim");
        jComboBoxConsigoCasa.setSelectedItem("Sim");
        jComboBoxConsigoCotidianas.setSelectedItem("Sim");
        jComboBoxConsigoFinancas.setSelectedItem("Sim");
        jComboBoxSintoPreciso.setSelectedItem("Sim");
        jComboBoxCostumoFrequentar.setSelectedItem("Sim");
        jDataAplicacao.setDate(null);
        jResponsavelAplicacao.setText("");
        //
        jComboBoxConhecoHabilidades.setEnabled(!true);
        jComboBoxOrganizoTempo.setEnabled(!true);
        jComboBoxMantenhoPapeis.setEnabled(!true);
        jComboBoxSouRotina.setEnabled(!true);
        jComboBoxConsigoOutros.setEnabled(!true);
        jComboBoxTenhoSocial.setEnabled(!true);
        jComboBoxPlanejoAgir.setEnabled(!true);
        jComboBoxConcentroTrabalho.setEnabled(!true);
        jComboBoxIdentificoProblemas.setEnabled(!true);
        jComboBoxIdentificoSolucaoProblemas.setEnabled(!true);
        jComboBoxQuandoAgir.setEnabled(!true);
        jComboBoxConsigoHigiene.setEnabled(!true);
        jComboBoxConsigoCasa.setEnabled(!true);
        jComboBoxConsigoCotidianas.setEnabled(!true);
        jComboBoxConsigoFinancas.setEnabled(!true);
        jComboBoxSintoPreciso.setEnabled(!true);
        jComboBoxCostumoFrequentar.setEnabled(!true);
        jDataAplicacao.setEnabled(!true);
        jResponsavelAplicacao.setEnabled(!true);
        //
        jBtNovoAvaliacaoII.setEnabled(true);
        jBtAlterarAvaliacaoII.setEnabled(!true);
        jBtExcluirAvaliacaoII.setEnabled(!true);
        jBtSalvarAvaliacaoII.setEnabled(!true);
        jBtCancelarAvaliacaoII.setEnabled(!true);
        jBtAuditoriaAvaliacaoII.setEnabled(!true);
        // AVALIAÇÃO I
        jBtNovoAvaliacaoI.setEnabled(true);
        jBtAlterarAvaliacaoI.setEnabled(!true);
        jBtExcluirAvaliacaoI.setEnabled(!true);
        jBtSalvarAvaliacaoI.setEnabled(!true);
        jBtCancelarAvaliacaoI.setEnabled(!true);
        jBtAuditoriaAvaliacaoI.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
    }

    public void SalvarAvaliacaoII() {
        jComboBoxConhecoHabilidades.setEnabled(!true);
        jComboBoxOrganizoTempo.setEnabled(!true);
        jComboBoxMantenhoPapeis.setEnabled(!true);
        jComboBoxSouRotina.setEnabled(!true);
        jComboBoxConsigoOutros.setEnabled(!true);
        jComboBoxTenhoSocial.setEnabled(!true);
        jComboBoxPlanejoAgir.setEnabled(!true);
        jComboBoxConcentroTrabalho.setEnabled(!true);
        jComboBoxIdentificoProblemas.setEnabled(!true);
        jComboBoxIdentificoSolucaoProblemas.setEnabled(!true);
        jComboBoxQuandoAgir.setEnabled(!true);
        jComboBoxConsigoHigiene.setEnabled(!true);
        jComboBoxConsigoCasa.setEnabled(!true);
        jComboBoxConsigoCotidianas.setEnabled(!true);
        jComboBoxConsigoFinancas.setEnabled(!true);
        jComboBoxSintoPreciso.setEnabled(!true);
        jComboBoxCostumoFrequentar.setEnabled(!true);
        jDataAplicacao.setEnabled(!true);
        jResponsavelAplicacao.setEnabled(!true);
        //
        jBtNovoAvaliacaoII.setEnabled(true);
        jBtAlterarAvaliacaoII.setEnabled(true);
        jBtExcluirAvaliacaoII.setEnabled(true);
        jBtSalvarAvaliacaoII.setEnabled(!true);
        jBtCancelarAvaliacaoII.setEnabled(!true);
        jBtAuditoriaAvaliacaoII.setEnabled(true);
        // AVALIAÇÃO I
        jBtNovoAvaliacaoI.setEnabled(true);
        jBtAlterarAvaliacaoI.setEnabled(!true);
        jBtExcluirAvaliacaoI.setEnabled(!true);
        jBtSalvarAvaliacaoI.setEnabled(!true);
        jBtCancelarAvaliacaoI.setEnabled(!true);
        jBtAuditoriaAvaliacaoI.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
    }

    public void CancelarAvaliacaoII() {
        jComboBoxConhecoHabilidades.setEnabled(!true);
        jComboBoxOrganizoTempo.setEnabled(!true);
        jComboBoxMantenhoPapeis.setEnabled(!true);
        jComboBoxSouRotina.setEnabled(!true);
        jComboBoxConsigoOutros.setEnabled(!true);
        jComboBoxTenhoSocial.setEnabled(!true);
        jComboBoxPlanejoAgir.setEnabled(!true);
        jComboBoxConcentroTrabalho.setEnabled(!true);
        jComboBoxIdentificoProblemas.setEnabled(!true);
        jComboBoxIdentificoSolucaoProblemas.setEnabled(!true);
        jComboBoxQuandoAgir.setEnabled(!true);
        jComboBoxConsigoHigiene.setEnabled(!true);
        jComboBoxConsigoCasa.setEnabled(!true);
        jComboBoxConsigoCotidianas.setEnabled(!true);
        jComboBoxConsigoFinancas.setEnabled(!true);
        jComboBoxSintoPreciso.setEnabled(!true);
        jComboBoxCostumoFrequentar.setEnabled(!true);
        jDataAplicacao.setEnabled(!true);
        jResponsavelAplicacao.setEnabled(!true);
        // AVALIAÇÃO I
        jBtNovoAvaliacaoI.setEnabled(true);
        jBtAlterarAvaliacaoI.setEnabled(!true);
        jBtExcluirAvaliacaoI.setEnabled(!true);
        jBtSalvarAvaliacaoI.setEnabled(!true);
        jBtCancelarAvaliacaoI.setEnabled(!true);
        jBtAuditoriaAvaliacaoI.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
        //
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM AVALIACAO_TO_II "
                    + "INNER JOIN ADMISSAO_TERAPIA_PE "
                    + "ON AVALIACAO_TO_II.IdATN=ADMISSAO_TERAPIA_PE.IdLanc "
                    + "WHERE AVALIACAO_TO_II.IdATN='" + jIdAtendNovo.getText() + "'");
            conecta.rs.first();
            codigoAvaliacaoII = conecta.rs.getInt("IdAvaliaTOII");
            jComboBoxOrganizoTempo.setSelectedItem(conecta.rs.getString("OrganizoTempo"));
            jComboBoxMantenhoPapeis.setSelectedItem(conecta.rs.getString("MantenhoPapeis"));
            jComboBoxSouRotina.setSelectedItem(conecta.rs.getString("SouRotina"));
            jComboBoxConsigoOutros.setSelectedItem(conecta.rs.getString("ConsigoOutros"));
            jComboBoxTenhoSocial.setSelectedItem(conecta.rs.getString("TenhoSocial"));
            jComboBoxPlanejoAgir.setSelectedItem(conecta.rs.getString("PlanejoAgir"));
            jComboBoxConcentroTrabalho.setSelectedItem(conecta.rs.getString("ConcentroTrabalho"));
            jComboBoxIdentificoProblemas.setSelectedItem(conecta.rs.getString("IdentificoProblemas"));
            jComboBoxIdentificoSolucaoProblemas.setSelectedItem(conecta.rs.getString("IdentificoSolucaoProblemas"));
            jComboBoxQuandoAgir.setSelectedItem(conecta.rs.getString("QuandoAgir"));
            jComboBoxConsigoHigiene.setSelectedItem(conecta.rs.getString("ConsigoHigiene"));
            jComboBoxConsigoCasa.setSelectedItem(conecta.rs.getString("ConsigoCasa"));
            jComboBoxConsigoCotidianas.setSelectedItem(conecta.rs.getString("ConsigoCotidianas"));
            jComboBoxConsigoFinancas.setSelectedItem(conecta.rs.getString("ConsigoFinancas"));
            jComboBoxSintoPreciso.setSelectedItem(conecta.rs.getString("SintoPreciso"));
            jComboBoxCostumoFrequentar.setSelectedItem(conecta.rs.getString("CostumoFrequentar"));
            jDataAplicacao.setDate(conecta.rs.getDate("DataAplicacao"));
            jResponsavelAplicacao.setText(conecta.rs.getString("ResponsavelAplicacao"));
            if (codigoAvaliacaoII != 0) {
                jBtNovoAvaliacaoII.setEnabled(true);
                jBtAlterarAvaliacaoII.setEnabled(true);
                jBtExcluirAvaliacaoII.setEnabled(true);
                jBtSalvarAvaliacaoII.setEnabled(!true);
                jBtCancelarAvaliacaoII.setEnabled(!true);
                jBtAuditoriaAvaliacaoII.setEnabled(true);
            }
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void buscarCodigoAvaliacaoII() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM AVALIACAO_TO_II");
            conecta.rs.last();
            codigoAvaliacaoII = conecta.rs.getInt("IdAvaliaTOII");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter o código do registro.");
        }
        conecta.desconecta();
    }

    public void verificarCodigoAvaliacaoII() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM AVALIACAO_TO_II "
                    + "WHERE IdATN='" + jIdAtendNovo.getText() + "' "
                    + "AND IdInternoCrc='" + jIdInternoAD.getText() + "'");
            conecta.rs.first();
            codigoAtendII = conecta.rs.getString("IdATN");
            codigoInternoAtendII = conecta.rs.getString("IdInternoCrc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void buscarID() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ADMISSAO_TERAPIA_PE");
            conecta.rs.last();
            jIdAtendNovo.setText(conecta.rs.getString("IdATN"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter o código do atendimento.");
        }
    }

    public void preencherAtendimentoTerapia(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Status", "Data Cadastro", "Nome do Interno"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1;
                // Formatar a data Entrada
                dataEntrada = conecta.rs.getString("DataLanc");
                String dia = dataEntrada.substring(8, 10);
                String mes = dataEntrada.substring(5, 7);
                String ano = dataEntrada.substring(0, 4);
                dataEntrada = dia + "/" + mes + "/" + ano;
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdATN"), conecta.rs.getString("StatusLanc"), dataEntrada, conecta.rs.getString("NomeInternoCrc")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaAtendimentoTerapia.setModel(modelo);
        jTabelaAtendimentoTerapia.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaAtendimentoTerapia.getColumnModel().getColumn(0).setResizable(false);
        jTabelaAtendimentoTerapia.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaAtendimentoTerapia.getColumnModel().getColumn(1).setResizable(false);
        jTabelaAtendimentoTerapia.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTabelaAtendimentoTerapia.getColumnModel().getColumn(2).setResizable(false);
        jTabelaAtendimentoTerapia.getColumnModel().getColumn(3).setPreferredWidth(510);
        jTabelaAtendimentoTerapia.getColumnModel().getColumn(3).setResizable(false);
        jTabelaAtendimentoTerapia.getTableHeader().setReorderingAllowed(false);
        jTabelaAtendimentoTerapia.setAutoResizeMode(jTabelaAtendimentoTerapia.AUTO_RESIZE_OFF);
        jTabelaAtendimentoTerapia.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabela();
        conecta.desconecta();
    }

    public void limparTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Status", "Data Cadastro", "Nome do Interno"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaAtendimentoTerapia.setModel(modelo);
        jTabelaAtendimentoTerapia.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaAtendimentoTerapia.getColumnModel().getColumn(0).setResizable(false);
        jTabelaAtendimentoTerapia.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaAtendimentoTerapia.getColumnModel().getColumn(1).setResizable(false);
        jTabelaAtendimentoTerapia.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTabelaAtendimentoTerapia.getColumnModel().getColumn(2).setResizable(false);
        jTabelaAtendimentoTerapia.getColumnModel().getColumn(3).setPreferredWidth(510);
        jTabelaAtendimentoTerapia.getColumnModel().getColumn(3).setResizable(false);
        jTabelaAtendimentoTerapia.getTableHeader().setReorderingAllowed(false);
        jTabelaAtendimentoTerapia.setAutoResizeMode(jTabelaAtendimentoTerapia.AUTO_RESIZE_OFF);
        jTabelaAtendimentoTerapia.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabela() {

        //
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaAtendimentoTerapia.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaAtendimentoTerapia.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaAtendimentoTerapia.getColumnModel().getColumn(2).setCellRenderer(centralizado);

    }

    public void preencherItensEvolucao(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Evolução"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                // Formatar a data Entrada
                dataEvolucao = conecta.rs.getString("DataEvo");
                String diae = dataEvolucao.substring(8, 10);
                String mese = dataEvolucao.substring(5, 7);
                String anoe = dataEvolucao.substring(0, 4);
                dataEvolucao = diae + "/" + mese + "/" + anoe;
                dados.add(new Object[]{conecta.rs.getInt("IdEvo"), dataEvolucao, conecta.rs.getString("Evolucao")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaEvolucao.setModel(modelo);
        jTabelaEvolucao.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaEvolucao.getColumnModel().getColumn(0).setResizable(false);
        jTabelaEvolucao.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaEvolucao.getColumnModel().getColumn(1).setResizable(false);
        jTabelaEvolucao.getColumnModel().getColumn(2).setPreferredWidth(500);
        jTabelaEvolucao.getColumnModel().getColumn(2).setResizable(false);
        jTabelaEvolucao.getTableHeader().setReorderingAllowed(false);
        jTabelaEvolucao.setAutoResizeMode(jTabelaEvolucao.AUTO_RESIZE_OFF);
        jTabelaEvolucao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaEvolucao();
        conecta.desconecta();
    }

    public void limparTabelaEvolucao() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Evolução"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaEvolucao.setModel(modelo);
        jTabelaEvolucao.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaEvolucao.getColumnModel().getColumn(0).setResizable(false);
        jTabelaEvolucao.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaEvolucao.getColumnModel().getColumn(1).setResizable(false);
        jTabelaEvolucao.getColumnModel().getColumn(2).setPreferredWidth(500);
        jTabelaEvolucao.getColumnModel().getColumn(2).setResizable(false);
        jTabelaEvolucao.getTableHeader().setReorderingAllowed(false);
        jTabelaEvolucao.setAutoResizeMode(jTabelaEvolucao.AUTO_RESIZE_OFF);
        jTabelaEvolucao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
        jTabelaEvolucao.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaEvolucao.getColumnModel().getColumn(1).setCellRenderer(centralizado);
    }

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jIdAtendNovo.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog2() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela2);
        objLogSys.setIdLancMov(Integer.valueOf(jIdEvolucao.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog3() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela3);
        objLogSys.setIdLancMov(Integer.valueOf(jIdAtendNovo.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog4() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela4);
        objLogSys.setIdLancMov(Integer.valueOf(jIdAtendNovo.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog5() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela5);
        objLogSys.setIdLancMov(Integer.valueOf(jIdAtendNovo.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog6() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela6);
        objLogSys.setIdLancMov(Integer.valueOf(jIdAtendNovo.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void buscarAcessoUsuario(String nomeTelaAcesso) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nameUser + "'");
            conecta.rs.first();
            codigoUserTO = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUserTO + "'");
            conecta.rs.first();
            codigoUserGroupTO = conecta.rs.getInt("IdUsuario");
            codigoGrupoTO = conecta.rs.getInt("IdGrupo");
            nomeGrupoTO = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUserTO + "' "
                    + "AND NomeTela='" + nomeTelaAcesso + "'");
            conecta.rs.first();
            codUserAcessoTO = conecta.rs.getInt("IdUsuario");
            codAbrirTO = conecta.rs.getInt("Abrir");
            codIncluirTO = conecta.rs.getInt("Incluir");
            codAlterarTO = conecta.rs.getInt("Alterar");
            codExcluirTO = conecta.rs.getInt("Excluir");
            codGravarTO = conecta.rs.getInt("Gravar");
            codConsultarTO = conecta.rs.getInt("Consultar");
            nomeTelaTO = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
