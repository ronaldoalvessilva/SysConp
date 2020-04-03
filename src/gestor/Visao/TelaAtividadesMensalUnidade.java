/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControleRefreshDataMovi;
import gestor.Controle.ListagemAtendimentoADMEnfermeira;
import gestor.Controle.ListagemAtendimentoADMMedica;
import gestor.Controle.ListagemAtendimentoADMOdontologica;
import gestor.Controle.ListagemAtendimentoPROCOdontologica;
import gestor.Controle.ListagemAtendimentoADMPsicologico;
import gestor.Controle.ListagemAtendimentoADMPsiquiatrica;
import gestor.Controle.ListagemAtendimentoADMServicoSocial;
import gestor.Controle.ListagemAtendimentoADMServicoSocialFamilia;
import gestor.Controle.ListagemInternosFrequenciaPedagogia;
import gestor.Controle.ListagemInternosMatriculadoPedagogia;
import gestor.Controle.ListagemNumerosDiasVisitas;
import gestor.Controle.ListagemNumerosDiasVisitasInterno;
import gestor.Controle.ListagemNumerosVisitasInternoMenor;
import gestor.Controle.ListagemQuantidadeAparelhoCeluar;
import gestor.Controle.ListagemQuantidadeObjetos;
import gestor.Controle.ListagemQuantidadeProdutosKit;
import gestor.Controle.ListagemQuantidadeRevistaPorCela;
import static gestor.Visao.TelaModuloAdmPessoal.codAbrirADM;
import static gestor.Visao.TelaModuloAdmPessoal.codAlterarADM;
import static gestor.Visao.TelaModuloAdmPessoal.codConsultarADM;
import static gestor.Visao.TelaModuloAdmPessoal.codExcluirADM;
import static gestor.Visao.TelaModuloAdmPessoal.codGravarADM;
import static gestor.Visao.TelaModuloAdmPessoal.codigoGrupoADM;
import static gestor.Visao.TelaModuloAdmPessoal.codigoUserGroupADM;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.ModeloTabela;
import gestor.Modelo.AtividadesMensalRealizadaUnidades;
import gestor.Modelo.LogSistema;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloAdmPessoal.codIncluirADM;
import static gestor.Visao.TelaModuloAdmPessoal.codUserAcessoADM;
import static gestor.Visao.TelaModuloAdmPessoal.codigoUserADM;
import static gestor.Visao.TelaModuloAdmPessoal.nomeGrupoADM;
import static gestor.Visao.TelaModuloAdmPessoal.nomeTelaADM;
import static gestor.Visao.TelaModuloAdmPessoal.telaAtividadeMensalManu_ADM;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import java.awt.Color;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Currency;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ronal
 */
public class TelaAtividadesMensalUnidade extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AtividadesMensalRealizadaUnidades objAtividade = new AtividadesMensalRealizadaUnidades();
    //ABA AF
    ListagemAtendimentoADMServicoSocial listaSSDao = new ListagemAtendimentoADMServicoSocial();
    ListagemAtendimentoADMServicoSocialFamilia listaDaoFam = new ListagemAtendimentoADMServicoSocialFamilia();
    ListagemNumerosDiasVisitasInterno listaDiasVIDao = new ListagemNumerosDiasVisitasInterno();
    ListagemNumerosVisitasInternoMenor listaVCDao = new ListagemNumerosVisitasInternoMenor();
    ListagemNumerosDiasVisitas listaNumDiasVDao = new ListagemNumerosDiasVisitas();
    //ABA ASI
    ListagemAtendimentoADMMedica listaQtdAtMedico = new ListagemAtendimentoADMMedica();
    ListagemAtendimentoADMPsiquiatrica listaQtdAtPsiq = new ListagemAtendimentoADMPsiquiatrica();
    ListagemAtendimentoADMEnfermeira listaQtdAtEnfer = new ListagemAtendimentoADMEnfermeira();
    ListagemAtendimentoADMPsicologico listaAtdAtPsico = new ListagemAtendimentoADMPsicologico();
    ListagemAtendimentoPROCOdontologica listaProcAtOdon = new ListagemAtendimentoPROCOdontologica();
    ListagemAtendimentoADMOdontologica listaAtdAtOdon = new ListagemAtendimentoADMOdontologica();
    //ABA AEI
    ListagemInternosMatriculadoPedagogia listaMatInTPed = new ListagemInternosMatriculadoPedagogia();
    ListagemInternosFrequenciaPedagogia listaFreqIntPed = new ListagemInternosFrequenciaPedagogia();
    //AMI
    ListagemQuantidadeProdutosKit listaProdutoKit = new ListagemQuantidadeProdutosKit();
    //SEG
    ListagemQuantidadeAparelhoCeluar listaQdtCelular = new ListagemQuantidadeAparelhoCeluar();
    ListagemQuantidadeObjetos listaQtdObjetos = new ListagemQuantidadeObjetos();
    ListagemQuantidadeRevistaPorCela listaRevistaCela = new ListagemQuantidadeRevistaPorCela();
    //
    ControleRefreshDataMovi converteDate = new ControleRefreshDataMovi();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela = "AdmPessoal:Colaboradores:Ficha Cadastral:Manutenção";
    String nomeModuloTela1 = "AdmPessoal:Colaboradores:Ficha Cadastral:Dependentes";
    String statusMov;
    String horaMov;
    String dataModFinal;
    //    
    int acao;
    int flag;
    int count = 0;
    String dataInicial, dataFinal;
    String dataCadastro;
    //ABA ASSI - SERVIÇO SOCIAL
    public static String pTIPO_ATENDIMENTO_ADM_SOCIAL = "Admissão Serviço Social";
    public static String pTIPO_ATENDIMENTO_EVO_SOCIAL = "Evolução Serviço Social";
    public static String pTIPO_ATENDIMENTO_LIGACOES = "Ligações Telefonicas";
    public static String pTIPO_ATENDIMENTO_GRUPO_SOCIAL = "Atendimento em Grupo/SS";
    //QUANTIDADES CALCULADA
    public static int pQUANTIDADE_ADM_SOCIAL = 0;
    public static int pQUANTIDADE_EVO_SOCIAL = 0;
    public static int pQUANTIDADE_ATE_FAMILIA = 0;
    public static int pQUANTIDADE_DIAS_VISITADOS = 0;
    public static int pQUANTIDADE_VISITA_FAMILIA_INT = 0;
    int pMEDIA_VISITAS_POR_DIA = 0;
    public static int pQUANTIDADE_VISITA_CRIANCA_INT = 0;
    //ABA ASI - ENFERMARIA
    public static String pTIPO_ATENDIMENTO_ATE_MEDICO = "Admissão Médica";
    public static String pTIPO_ATENDIMENTO_EVO_MEDICA = "Evolução Médica";
    public static String pTIPO_ATENDIMENTO_ATE_PSIQUIATRICO = "Admissão Psiquiatrica";
    public static String pTIPO_ATENDIMENTO_EVO_PSIQUIATRICA = "Evolução Psiquiatrica";
    public static String pTIPO_ATENDIMENTO_ATE_ENFERMAGEM = "Admissão Enfermagem";
    public static String pTIPO_ATENDIMENTO_EVO_ENFERMAGEM = "Evolução Enfermagem";
    public static String pTIPO_ATENDIMENTO_GRUPO_ENFERMAGEM = "Atendimento em Grupo/ENF";
    public static String pTIPO_ATENDIMENTO_ATE_TECNICO_ENF = "Atendimento Técnico Enfermagem";
    //ABA ASI - PSICOLOGIA
    public static String pTIPO_ATENDIMENTO_ATE_PSICOLOGICO = "Admissão Psicologica";
    public static String pTIPO_ATENDIMENTO_EVO_PSICOLOGICO = "Evolução Psicologica";
    public static String pTIPO_ATENDIMENTO_GRUPO_PSICOLOGICO = "Atendimento em Grupo/PSI";
    //PROCEDIMENTOS ODOTOLOGICO
    public static String pTIPO_ATENDIMENTO_ATE_ODONTOLOGICO = "Admissão Odontologica";
    public static String pTIPO_ATENDIMENTO_EVO_ODONTOLOGICO = "Evolução Odontologica";
    //ABA AEI - PEDAGOGIA
    public static String pTIPO_MATRICULA_PEDAGODIA = "Matriculado";
    public static String pPRESENCA_INTERNO = "Presente";
    //QUANTIDADES CALCULADA
    public static int pQUANTIDADE_ATE_MEDICA = 0;
    public static int pQUANDIDADE_ATE_PSIQUIATRICA = 0;
    public static int pQUANTIDADE_EVO_MEDICA = 0;
    public static int pQUANTIDADE_EVO_PSIQUIATRICA = 0;
    public static int pQUANTIDADE_ATE_ENFERMAGEM = 0;
    public static int pQUANTIDADE_EVO_ENFERMAGEM = 0;
    public static int pQUANTIDADE_ATE_TECNICO_ENF = 0;
    public static int pQUANTIDADE_ATE_PSICOLOGIA = 0;
    public static int pQUANTIDADE_PROC_ODONTOLOGICO = 0;
    public static int pQUANTIDADE_ATE_ODONTOLOGICO = 0;
    public static int pQUANTIDADE_MATRICULADOS = 0;
    public static int pQUANTIDADE_INTERNOS_PRESENTE = 0;
    public static int pQUANTIDADE_APARELHO_CELULAR = 0;
    public static int pQUANTIDADE_OBJETOS_PROC = 0;
    public static int pQUANTIDADE_REVISTA_POR_CELA = 0;

    //ABA AMI - ALMOXARIFADO
    //ABA SEG - GERENCIA OPERACIONAL
    //ABA AJ - JURÍDICO
    //ABA AL - TERAPIA OCUPACIONAL
    //ABA AFI - NUTRIÇÃO
    /**
     * Creates new form TelaAtividadesMensalUnidade
     */
    public TelaAtividadesMensalUnidade() {
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPesqNome = new javax.swing.JTextField();
        jBtPesqNome = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel23 = new javax.swing.JLabel();
        jCodigoPesqFunc = new javax.swing.JTextField();
        jBtPesqCodigoFunc = new javax.swing.JButton();
        jBtPesqDatas = new javax.swing.JButton();
        jDataPesqInicial = new com.toedter.calendar.JDateChooser();
        jLabel73 = new javax.swing.JLabel();
        jDataPesFinal = new com.toedter.calendar.JDateChooser();
        jLabel74 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        jComboBoxMes1 = new javax.swing.JComboBox<>();
        jComboBoxAno1 = new javax.swing.JComboBox<>();
        jBtPesqMesAno = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaFuncionario = new javax.swing.JTable();
        jPanel32 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jChave = new javax.swing.JTextField();
        jStatus = new javax.swing.JTextField();
        jUnidadePrisional = new javax.swing.JTextField();
        jColaboradorResponsavel = new javax.swing.JTextField();
        jDataAtualizacao = new com.toedter.calendar.JDateChooser();
        jDataCriacao = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jPopulacaoAtual = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jMatricula = new javax.swing.JTextField();
        jDepartamento = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jObservacao = new javax.swing.JTextArea();
        jBtPesquisarColaborador = new javax.swing.JButton();
        jLabel146 = new javax.swing.JLabel();
        jIdFunc = new javax.swing.JTextField();
        jLabel147 = new javax.swing.JLabel();
        jDataPeriodoInicial = new com.toedter.calendar.JDateChooser();
        jDataPeriodoFinal = new com.toedter.calendar.JDateChooser();
        jLabel148 = new javax.swing.JLabel();
        jLabel151 = new javax.swing.JLabel();
        jLabel152 = new javax.swing.JLabel();
        jLabel154 = new javax.swing.JLabel();
        jBtPesquisarDatas = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jBtNovo = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jBtFinalizar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jBtAuditoria = new javax.swing.JButton();
        jBtImpressao = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel143 = new javax.swing.JLabel();
        jLabel149 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jAtendimentoPsiPreso = new javax.swing.JFormattedTextField();
        jAtendimentoPsiFamilaPreso = new javax.swing.JFormattedTextField();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jNumeroDiasVisitas = new javax.swing.JFormattedTextField();
        jNumeroVistantesInternos = new javax.swing.JFormattedTextField();
        jMediaVisitasDia = new javax.swing.JFormattedTextField();
        jMediaVisitasInterno = new javax.swing.JFormattedTextField();
        jNumeroCriancasVisitas = new javax.swing.JFormattedTextField();
        jPanel14 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPresoIdentCivil = new javax.swing.JFormattedTextField();
        jPresoAtiviReligiosa = new javax.swing.JFormattedTextField();
        jPanel16 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel63 = new javax.swing.JPanel();
        jBtNovo10 = new javax.swing.JButton();
        jBtAlterar10 = new javax.swing.JButton();
        jBtExcluir10 = new javax.swing.JButton();
        jBtSalvar10 = new javax.swing.JButton();
        jBtCancelar10 = new javax.swing.JButton();
        jBtFinalizar1 = new javax.swing.JButton();
        jBtSair10 = new javax.swing.JButton();
        jBtAuditoria10 = new javax.swing.JButton();
        jBtImpressao3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jAlimentaServidaEmpContAlmoco = new javax.swing.JFormattedTextField();
        jLanchesServidoVisita = new javax.swing.JFormattedTextField();
        jAlimentaServidaEmpContJantar = new javax.swing.JFormattedTextField();
        jAlimentaServidaEmpContLanche = new javax.swing.JFormattedTextField();
        jAlimentaServidaServContCafe = new javax.swing.JFormattedTextField();
        jAlimentaServidaEmpContCafe = new javax.swing.JFormattedTextField();
        jAlimentaServidaServContAlmoco = new javax.swing.JFormattedTextField();
        jAlimentaServidaServContJantar = new javax.swing.JFormattedTextField();
        jAlimentaServidaServContLanche = new javax.swing.JFormattedTextField();
        jPanel19 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel64 = new javax.swing.JPanel();
        jBtNovo11 = new javax.swing.JButton();
        jBtAlterar11 = new javax.swing.JButton();
        jBtExcluir11 = new javax.swing.JButton();
        jBtSalvar11 = new javax.swing.JButton();
        jBtCancelar11 = new javax.swing.JButton();
        jBtFinalizar2 = new javax.swing.JButton();
        jBtSair11 = new javax.swing.JButton();
        jBtAuditoria11 = new javax.swing.JButton();
        jBtImpressao4 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jAtendimentoMedClinico = new javax.swing.JFormattedTextField();
        jAtendimentoMedPsi = new javax.swing.JFormattedTextField();
        jAtendimentoEnfermagem = new javax.swing.JFormattedTextField();
        jProcedimentoOdontologico = new javax.swing.JFormattedTextField();
        jAtendimentoPsicologico = new javax.swing.JFormattedTextField();
        jTratamentoAgravDiaginostico = new javax.swing.JFormattedTextField();
        jAtendimentoOdontologicos = new javax.swing.JFormattedTextField();
        jPresoDoencaInfecto = new javax.swing.JFormattedTextField();
        jControlHipertensao = new javax.swing.JFormattedTextField();
        jControleDiabetes = new javax.swing.JFormattedTextField();
        jAspectosSexual = new javax.swing.JFormattedTextField();
        jPresosVacinados = new javax.swing.JFormattedTextField();
        jPanel65 = new javax.swing.JPanel();
        jBtNovo12 = new javax.swing.JButton();
        jBtAlterar12 = new javax.swing.JButton();
        jBtExcluir12 = new javax.swing.JButton();
        jBtSalvar12 = new javax.swing.JButton();
        jBtCancelar12 = new javax.swing.JButton();
        jBtFinalizar3 = new javax.swing.JButton();
        jBtSair12 = new javax.swing.JButton();
        jBtAuditoria12 = new javax.swing.JButton();
        jBtImpressao5 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jLabel131 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        jPresoSentencaMatFreqEF = new javax.swing.JFormattedTextField();
        jPresoSentenciadoEF = new javax.swing.JFormattedTextField();
        jPanel48 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jPresoAtiviPraticaEsportiva = new javax.swing.JFormattedTextField();
        jPanel66 = new javax.swing.JPanel();
        jBtNovo13 = new javax.swing.JButton();
        jBtAlterar13 = new javax.swing.JButton();
        jBtExcluir13 = new javax.swing.JButton();
        jBtSalvar13 = new javax.swing.JButton();
        jBtCancelar13 = new javax.swing.JButton();
        jBtFinalizar4 = new javax.swing.JButton();
        jBtSair13 = new javax.swing.JButton();
        jBtAuditoria13 = new javax.swing.JButton();
        jBtImpressao6 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jDesodorante = new javax.swing.JFormattedTextField();
        jSabaoPo = new javax.swing.JFormattedTextField();
        jSabonete = new javax.swing.JFormattedTextField();
        jBermuda = new javax.swing.JFormattedTextField();
        jCamisa = new javax.swing.JFormattedTextField();
        jAparelhoBarbear = new javax.swing.JFormattedTextField();
        jCremeDental = new javax.swing.JFormattedTextField();
        jEscovaDente = new javax.swing.JFormattedTextField();
        jAbsorvente = new javax.swing.JFormattedTextField();
        jPapelHigienico = new javax.swing.JFormattedTextField();
        jColchao = new javax.swing.JFormattedTextField();
        jLencol = new javax.swing.JFormattedTextField();
        jToalha = new javax.swing.JFormattedTextField();
        jPote = new javax.swing.JFormattedTextField();
        jCaneca = new javax.swing.JFormattedTextField();
        jCobertor = new javax.swing.JFormattedTextField();
        jChinelos = new javax.swing.JFormattedTextField();
        jCuecas = new javax.swing.JFormattedTextField();
        jLabel69 = new javax.swing.JLabel();
        jUniformeCompleto = new javax.swing.JFormattedTextField();
        jPanel67 = new javax.swing.JPanel();
        jBtNovo14 = new javax.swing.JButton();
        jBtAlterar14 = new javax.swing.JButton();
        jBtExcluir14 = new javax.swing.JButton();
        jBtSalvar14 = new javax.swing.JButton();
        jBtCancelar14 = new javax.swing.JButton();
        jBtFinalizar5 = new javax.swing.JButton();
        jBtSair14 = new javax.swing.JButton();
        jBtAuditoria14 = new javax.swing.JButton();
        jBtImpressao7 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jNumeroAparelhoConvive = new javax.swing.JFormattedTextField();
        jObjetosMateriais = new javax.swing.JFormattedTextField();
        jNumeroOcorrenciasInd = new javax.swing.JFormattedTextField();
        jNumeroProcedRevista = new javax.swing.JFormattedTextField();
        jPanel38 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        jPanel43 = new javax.swing.JPanel();
        jNumeroHorasTVCFTV = new javax.swing.JFormattedTextField();
        jNumeroOcorrenciaPessoasFerida = new javax.swing.JFormattedTextField();
        jLabel85 = new javax.swing.JLabel();
        jNumeroFraldasEntreguePortaria = new javax.swing.JFormattedTextField();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jNumeroOcorrenciaPessoasRefem = new javax.swing.JFormattedTextField();
        jNumeroOcorrenciaPessoaFerida = new javax.swing.JFormattedTextField();
        jNumeroOcorrenciaRebeliao = new javax.swing.JFormattedTextField();
        jNumeroOcorrenciaTentaFuga = new javax.swing.JFormattedTextField();
        jUmeroInterFuncVeiculosTP = new javax.swing.JFormattedTextField();
        jLabel78 = new javax.swing.JLabel();
        jNumeroAbsorEntregueVisitas = new javax.swing.JFormattedTextField();
        jLabel79 = new javax.swing.JLabel();
        jNumeroFalhasGerador = new javax.swing.JFormattedTextField();
        jLabel80 = new javax.swing.JLabel();
        jNumeroHorasBloqueador = new javax.swing.JFormattedTextField();
        jLabel81 = new javax.swing.JLabel();
        jNumeroDiasIntMetaPortatil = new javax.swing.JFormattedTextField();
        jLabel82 = new javax.swing.JLabel();
        jNumeroDiasSemScannerCorpo = new javax.swing.JFormattedTextField();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jPanel68 = new javax.swing.JPanel();
        jBtNovo15 = new javax.swing.JButton();
        jBtAlterar15 = new javax.swing.JButton();
        jBtExcluir15 = new javax.swing.JButton();
        jBtSalvar15 = new javax.swing.JButton();
        jBtCancelar15 = new javax.swing.JButton();
        jBtFinalizar6 = new javax.swing.JButton();
        jBtSair15 = new javax.swing.JButton();
        jBtAuditoria15 = new javax.swing.JButton();
        jBtImpressao8 = new javax.swing.JButton();
        jPanel29 = new javax.swing.JPanel();
        jPanel40 = new javax.swing.JPanel();
        jLabel91 = new javax.swing.JLabel();
        jPanel41 = new javax.swing.JPanel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jAtendInternoSAJ = new javax.swing.JFormattedTextField();
        jAlvaraSolturaCumprido = new javax.swing.JFormattedTextField();
        jLivarmentoCondRequerido = new javax.swing.JFormattedTextField();
        jProgressaoRegDeferido = new javax.swing.JFormattedTextField();
        jSaidasTempDeferida = new javax.swing.JFormattedTextField();
        jPanel42 = new javax.swing.JPanel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jCondicionalRequerida = new javax.swing.JFormattedTextField();
        jAlvarSolRecebeUni = new javax.swing.JFormattedTextField();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jAudienciaProvocadas = new javax.swing.JFormattedTextField();
        jProgressaoRegRequerido = new javax.swing.JFormattedTextField();
        jJuriPopular = new javax.swing.JFormattedTextField();
        jAudienciaCumpridas = new javax.swing.JFormattedTextField();
        jLiberdadeProvRequerida = new javax.swing.JFormattedTextField();
        jJuriPopularCumprido = new javax.swing.JFormattedTextField();
        jIndultosRequeridos = new javax.swing.JFormattedTextField();
        jLiberdadeProvDeferida = new javax.swing.JFormattedTextField();
        jRemissaoPenaRequerida = new javax.swing.JFormattedTextField();
        jIndultosDeferidos = new javax.swing.JFormattedTextField();
        jHabeasCorpusDeferido = new javax.swing.JFormattedTextField();
        jLaudosPsiqEmitidos = new javax.swing.JFormattedTextField();
        jTP = new javax.swing.JFormattedTextField();
        jRemissaoPenaDeferida = new javax.swing.JFormattedTextField();
        jLaudoPsicoEmitidos = new javax.swing.JFormattedTextField();
        jHabeasCorpusImpetrados = new javax.swing.JFormattedTextField();
        jSaidaTempRequerida = new javax.swing.JFormattedTextField();
        jPanel69 = new javax.swing.JPanel();
        jBtNovo16 = new javax.swing.JButton();
        jBtAlterar16 = new javax.swing.JButton();
        jBtExcluir16 = new javax.swing.JButton();
        jBtSalvar16 = new javax.swing.JButton();
        jBtCancelar16 = new javax.swing.JButton();
        jBtFinalizar7 = new javax.swing.JButton();
        jBtSair16 = new javax.swing.JButton();
        jBtAuditoria16 = new javax.swing.JButton();
        jBtImpressao9 = new javax.swing.JButton();
        jPanel33 = new javax.swing.JPanel();
        jPanel45 = new javax.swing.JPanel();
        jLabel121 = new javax.swing.JLabel();
        jPanel46 = new javax.swing.JPanel();
        jLabel122 = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        jLabel126 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        jPresoMatProfissional = new javax.swing.JFormattedTextField();
        jPresoCertificaCursoProf = new javax.swing.JFormattedTextField();
        jPresoAtiviCantoTeatro = new javax.swing.JFormattedTextField();
        jPresoAtiviLiteraria = new javax.swing.JFormattedTextField();
        PresoAtiviArtesPlasticas = new javax.swing.JFormattedTextField();
        jOcupacaoAtiviRecreaReligiosa = new javax.swing.JFormattedTextField();
        jTriagemAtendInernos = new javax.swing.JFormattedTextField();
        jPanel47 = new javax.swing.JPanel();
        jLabel129 = new javax.swing.JLabel();
        jLabel130 = new javax.swing.JLabel();
        jPresoSentecaAtivLaboralRemun = new javax.swing.JFormattedTextField();
        jPresoAtiviLaboralNaoRemunera = new javax.swing.JFormattedTextField();
        jPanel70 = new javax.swing.JPanel();
        jBtNovo17 = new javax.swing.JButton();
        jBtAlterar17 = new javax.swing.JButton();
        jBtExcluir17 = new javax.swing.JButton();
        jBtSalvar17 = new javax.swing.JButton();
        jBtCancelar17 = new javax.swing.JButton();
        jBtFinalizar8 = new javax.swing.JButton();
        jBtSair17 = new javax.swing.JButton();
        jBtAuditoria17 = new javax.swing.JButton();
        jBtImpressao10 = new javax.swing.JButton();
        jPanel34 = new javax.swing.JPanel();
        jPanel61 = new javax.swing.JPanel();
        jLabel144 = new javax.swing.JLabel();
        jPanel54 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jAlimentaServidaInternoCafe = new javax.swing.JFormattedTextField();
        jLabel32 = new javax.swing.JLabel();
        jAlimentaServidaInternoAlmoco = new javax.swing.JFormattedTextField();
        jAlimentaServidaInternoJantar = new javax.swing.JFormattedTextField();
        jPanel71 = new javax.swing.JPanel();
        jBtNovo18 = new javax.swing.JButton();
        jBtAlterar18 = new javax.swing.JButton();
        jBtExcluir18 = new javax.swing.JButton();
        jBtSalvar18 = new javax.swing.JButton();
        jBtCancelar18 = new javax.swing.JButton();
        jBtFinalizar9 = new javax.swing.JButton();
        jBtSair18 = new javax.swing.JButton();
        jBtAuditoria18 = new javax.swing.JButton();
        jBtImpressao11 = new javax.swing.JButton();
        jPanel35 = new javax.swing.JPanel();
        jPanel58 = new javax.swing.JPanel();
        jLabel142 = new javax.swing.JLabel();
        jTotal08 = new javax.swing.JFormattedTextField();
        jPanel50 = new javax.swing.JPanel();
        jLabel133 = new javax.swing.JLabel();
        jPanel55 = new javax.swing.JPanel();
        jLabel139 = new javax.swing.JLabel();
        jTotal05 = new javax.swing.JFormattedTextField();
        jPanel59 = new javax.swing.JPanel();
        jBtCalcularTotais = new javax.swing.JButton();
        jPanel51 = new javax.swing.JPanel();
        jLabel135 = new javax.swing.JLabel();
        jTotal02 = new javax.swing.JFormattedTextField();
        jPanel56 = new javax.swing.JPanel();
        jLabel140 = new javax.swing.JLabel();
        jTotal06 = new javax.swing.JFormattedTextField();
        jPanel52 = new javax.swing.JPanel();
        jLabel136 = new javax.swing.JLabel();
        jTotal03 = new javax.swing.JFormattedTextField();
        jPanel57 = new javax.swing.JPanel();
        jLabel141 = new javax.swing.JLabel();
        jTotal07 = new javax.swing.JFormattedTextField();
        jPanel49 = new javax.swing.JPanel();
        jLabel134 = new javax.swing.JLabel();
        jTotal01 = new javax.swing.JFormattedTextField();
        jPanel53 = new javax.swing.JPanel();
        jLabel137 = new javax.swing.JLabel();
        jTotal04 = new javax.swing.JFormattedTextField();
        jPanel62 = new javax.swing.JPanel();
        jLabel145 = new javax.swing.JLabel();
        jTotal09 = new javax.swing.JFormattedTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Atividades Mensal Realizada pela Unidade");

        jTabbedPane1.setToolTipText("");
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 51, 255))); // NOI18N

        jPesqNome.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqNome.setContentAreaFilled(false);
        jBtPesqNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqNomeActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("Nome Colaborador:");

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox1.setText("Todos");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setText("Código:");

        jCodigoPesqFunc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodigoPesqFunc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqCodigoFunc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqCodigoFunc.setContentAreaFilled(false);
        jBtPesqCodigoFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqCodigoFuncActionPerformed(evt);
            }
        });

        jBtPesqDatas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqDatas.setContentAreaFilled(false);
        jBtPesqDatas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqDatasActionPerformed(evt);
            }
        });

        jDataPesqInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel73.setText("Data Inicial:");

        jDataPesFinal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel74.setText("Data Final:");

        jLabel138.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel138.setText("Mês/Ano:");

        jComboBoxMes1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxMes1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));
        jComboBoxMes1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jComboBoxAno1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxAno1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "1900", "1901", "1902", "1903", "1904", "1905", "1906", "1907", "1908", "1909", "1910", "1911", "1912", "1913", "1914", "1915", "1916", "1917", "1918", "1919", "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", "2051", "2052", "2053", "2054", "2055", "2056", "2057", "2058", "2059", "2060", "2061", "2062", "2063", "2064", "2065", "2066", "2067", "2068", "2069", "2070", "2071", "2072", "2073", "2074", "2075", "2076", "2077", "2078", "2079", "2080", "2081", "2082", "2083", "2084", "2085", "2086", "2087", "2088", "2089", "2090", "2091", "2092", "2093", "2094", "2095", "2096", "2097", "2098", "2099", "2100", "2101", "2102", "2103", "2104", "2105", "2106", "2107", "2108", "2109", "2110", "2111", "2112", "2113", "2114", "2115", "2116", "2117", "2118", "2119", "2120", "2121", "2122", "2123", "2124", "2125", "2126", "2127", "2128", "2129", "2130", "2131", "2132", "2133", "2134", "2135", "2136", "2137", "2138", "2139", "2140", "2141", "2142", "2143", "2144", "2145", "2146", "2147", "2148", "2149", "2150", "2151", "2152", "2153", "2154", "2155", "2156", "2157", "2158", "2159", "2160", "2161", "2162", "2163", "2164", "2165", "2166", "2167", "2168", "2169", "2170", "2171", "2172", "2173", "2174", "2175", "2176", "2177", "2178", "2179", "2180", "2181", "2182", "2183", "2184", "2185", "2186", "2187", "2188", "2189", "2190", "2191", "2192", "2193", "2194", "2195", "2196", "2197", "2198", "2199", "2200", "2201", "2202", "2203", "2204", "2205", "2206", "2207", "2208", "2209", "2210", "2211", "2212", "2213", "2214", "2215", "2216", "2217", "2218", "2219", "2220", "2221", "2222", "2223", "2224", "2225", "2226", "2227", "2228", "2229", "2230", "2231", "2232", "2233", "2234", "2235", "2236", "2237", "2238", "2239", "2240", "2241", "2242", "2243", "2244", "2245", "2246", "2247", "2248", "2249", "2250", "2251", "2252", "2253", "2254", "2255", "2256", "2257", "2258", "2259", "2260", "2261", "2262", "2263", "2264", "2265", "2266", "2267", "2268", "2269", "2270", "2271", "2272", "2273", "2274", "2275", "2276", "2277", "2278", "2279", "2280", "2281", "2282", "2283", "2284", "2285", "2286", "2287", "2288", "2289", "2290", "2291", "2292", "2293", "2294", "2295", "2296", "2297", "2298", "2299", "2300", "2301", "2302", "2303", "2304", "2305", "2306", "2307", "2308", "2309", "2310", "2311", "2312", "2313", "2314", "2315", "2316", "2317", "2318", "2319", "2320", "2321", "2322", "2323", "2324", "2325", "2326", "2327", "2328", "2329", "2330", "2331", "2332", "2333", "2334", "2335", "2336", "2337", "2338", "2339", "2340", "2341", "2342", "2343", "2344", "2345", "2346", "2347", "2348", "2349", "2350", "2351", "2352", "2353", " ", " ", " " }));
        jComboBoxAno1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqMesAno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqMesAno.setContentAreaFilled(false);
        jBtPesqMesAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqMesAnoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel138)
                    .addComponent(jLabel10)
                    .addComponent(jLabel73)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addComponent(jComboBoxMes1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxAno1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jCodigoPesqFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqCodigoFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckBox1))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(jLabel74)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDataPesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jPesqNome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jBtPesqDatas, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBtPesqNome, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBtPesqMesAno, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel23)
                    .addComponent(jCodigoPesqFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqCodigoFunc)
                    .addComponent(jCheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel73)
                    .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel74)
                    .addComponent(jDataPesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqDatas, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel10)
                    .addComponent(jPesqNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqNome, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtPesqMesAno, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxAno1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxMes1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel138))
                .addGap(7, 7, 7))
        );

        jTabelaFuncionario.setAutoCreateRowSorter(true);
        jTabelaFuncionario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaFuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data", "Status", "Mês", "Ano", "Unidade Prisional"
            }
        ));
        jTabelaFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaFuncionarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaFuncionario);
        if (jTabelaFuncionario.getColumnModel().getColumnCount() > 0) {
            jTabelaFuncionario.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaFuncionario.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaFuncionario.getColumnModel().getColumn(1).setMinWidth(80);
            jTabelaFuncionario.getColumnModel().getColumn(1).setMaxWidth(80);
            jTabelaFuncionario.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaFuncionario.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaFuncionario.getColumnModel().getColumn(3).setMinWidth(80);
            jTabelaFuncionario.getColumnModel().getColumn(3).setMaxWidth(80);
            jTabelaFuncionario.getColumnModel().getColumn(4).setMinWidth(70);
            jTabelaFuncionario.getColumnModel().getColumn(4).setMaxWidth(70);
            jTabelaFuncionario.getColumnModel().getColumn(5).setMinWidth(300);
            jTabelaFuncionario.getColumnModel().getColumn(5).setMaxWidth(300);
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
            .addGap(0, 0, Short.MAX_VALUE)
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jTabbedPane1.addTab("Listagem", jPanel1);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Chave");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Status");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Data Up");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Data Insert");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Unidade Prisional");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Colaborador Responsável");

        jChave.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jChave.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jChave.setEnabled(false);

        jStatus.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jStatus.setForeground(new java.awt.Color(204, 0, 0));
        jStatus.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jStatus.setDisabledTextColor(new java.awt.Color(204, 0, 0));
        jStatus.setEnabled(false);

        jUnidadePrisional.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jUnidadePrisional.setEnabled(false);

        jColaboradorResponsavel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jColaboradorResponsavel.setEnabled(false);

        jDataAtualizacao.setBackground(new java.awt.Color(255, 255, 255));
        jDataAtualizacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataAtualizacao.setEnabled(false);

        jDataCriacao.setBackground(new java.awt.Color(255, 255, 255));
        jDataCriacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataCriacao.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("População Atual");

        jPopulacaoAtual.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPopulacaoAtual.setForeground(new java.awt.Color(204, 0, 0));
        jPopulacaoAtual.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPopulacaoAtual.setText("0");
        jPopulacaoAtual.setToolTipText("");
        jPopulacaoAtual.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPopulacaoAtual.setDisabledTextColor(new java.awt.Color(204, 0, 0));
        jPopulacaoAtual.setEnabled(false);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Matricula");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Departamento");

        jMatricula.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jMatricula.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMatricula.setEnabled(false);

        jDepartamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDepartamento.setEnabled(false);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Observação");

        jScrollPane2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jScrollPane2.setEnabled(false);

        jObservacao.setColumns(20);
        jObservacao.setRows(5);
        jScrollPane2.setViewportView(jObservacao);

        jBtPesquisarColaborador.setForeground(new java.awt.Color(0, 0, 204));
        jBtPesquisarColaborador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesquisarColaborador.setToolTipText("Pesquisar Colaborador");
        jBtPesquisarColaborador.setContentAreaFilled(false);
        jBtPesquisarColaborador.setEnabled(false);
        jBtPesquisarColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisarColaboradorActionPerformed(evt);
            }
        });

        jLabel146.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel146.setText("Cóodigo");

        jIdFunc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdFunc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdFunc.setEnabled(false);

        jLabel147.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel147.setText("Data Inicial");

        jDataPeriodoInicial.setBackground(new java.awt.Color(255, 255, 255));
        jDataPeriodoInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataPeriodoInicial.setToolTipText("Período Inicial");
        jDataPeriodoInicial.setEnabled(false);

        jDataPeriodoFinal.setBackground(new java.awt.Color(255, 255, 255));
        jDataPeriodoFinal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataPeriodoFinal.setToolTipText("Período Final");
        jDataPeriodoFinal.setEnabled(false);

        jLabel148.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel148.setText("Data Final");

        jLabel151.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel151.setForeground(new java.awt.Color(204, 0, 0));
        jLabel151.setText("*");

        jLabel152.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel152.setForeground(new java.awt.Color(204, 0, 0));
        jLabel152.setText("*");

        jLabel154.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel154.setForeground(new java.awt.Color(204, 0, 0));
        jLabel154.setText("*");

        jBtPesquisarDatas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtPesquisarDatas.setText("Refresh");
        jBtPesquisarDatas.setToolTipText("Pesquisar Datas dos Registros");
        jBtPesquisarDatas.setEnabled(false);
        jBtPesquisarDatas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisarDatasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel146)
                                    .addComponent(jMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jIdFunc, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(3, 3, 3)
                                        .addComponent(jBtPesquisarColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(3, 3, 3)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDepartamento)
                                    .addComponent(jColaboradorResponsavel)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel151))
                                    .addComponent(jLabel16)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(jUnidadePrisional, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jPopulacaoAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jChave, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel1))
                                        .addGap(3, 3, 3)
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jDataCriacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(3, 3, 3)
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jDataAtualizacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane2))
                        .addGap(65, 65, 65))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDataPeriodoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel147)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel154)))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel148)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel152))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jDataPeriodoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(jBtPesquisarDatas, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2))
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jChave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataCriacao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataAtualizacao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jUnidadePrisional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPopulacaoAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel147)
                        .addComponent(jLabel154))
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel148)
                        .addComponent(jLabel152)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jDataPeriodoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataPeriodoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesquisarDatas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel146)
                    .addComponent(jLabel151))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIdFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesquisarColaborador)
                    .addComponent(jColaboradorResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        jPanel9Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jChave, jDataAtualizacao, jDataCriacao, jStatus});

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jBtNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovo.setToolTipText("Novo");
        jBtNovo.setContentAreaFilled(false);
        jBtNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoActionPerformed(evt);
            }
        });

        jBtAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterar.setToolTipText("Alterar");
        jBtAlterar.setContentAreaFilled(false);
        jBtAlterar.setEnabled(false);
        jBtAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarActionPerformed(evt);
            }
        });

        jBtExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216104515_16.png"))); // NOI18N
        jBtExcluir.setToolTipText("Excluir");
        jBtExcluir.setContentAreaFilled(false);
        jBtExcluir.setEnabled(false);
        jBtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirActionPerformed(evt);
            }
        });

        jBtSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvar.setToolTipText("Gravar");
        jBtSalvar.setContentAreaFilled(false);
        jBtSalvar.setEnabled(false);
        jBtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarActionPerformed(evt);
            }
        });

        jBtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelar.setToolTipText("Cancelar");
        jBtCancelar.setContentAreaFilled(false);
        jBtCancelar.setEnabled(false);
        jBtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarActionPerformed(evt);
            }
        });

        jBtFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/tick.png"))); // NOI18N
        jBtFinalizar.setToolTipText("Finalizar");
        jBtFinalizar.setContentAreaFilled(false);
        jBtFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFinalizarActionPerformed(evt);
            }
        });

        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/shutdown-icone-6920-16.png"))); // NOI18N
        jBtSair.setToolTipText("Sair");
        jBtSair.setContentAreaFilled(false);
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        jBtAuditoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoria.setToolTipText("Auditoria");
        jBtAuditoria.setContentAreaFilled(false);
        jBtAuditoria.setEnabled(false);
        jBtAuditoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaActionPerformed(evt);
            }
        });

        jBtImpressao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/gtklp-icone-3770-16.png"))); // NOI18N
        jBtImpressao.setToolTipText("Impressão");
        jBtImpressao.setContentAreaFilled(false);
        jBtImpressao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtImpressaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jBtNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jBtFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jBtImpressao, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jBtAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel10Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterar, jBtCancelar, jBtExcluir, jBtFinalizar, jBtNovo, jBtSair, jBtSalvar});

        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtImpressao)
                    .addComponent(jBtFinalizar)
                    .addComponent(jBtSair)
                    .addComponent(jBtAuditoria)
                    .addComponent(jBtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtSalvar)
                    .addComponent(jBtCancelar)
                    .addComponent(jBtNovo))
                .addGap(3, 3, 3))
        );

        jPanel10Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterar, jBtAuditoria, jBtCancelar, jBtExcluir, jBtFinalizar, jBtNovo, jBtSair, jBtSalvar});

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel143.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel143.setForeground(new java.awt.Color(0, 0, 204));
        jLabel143.setText("ATENÇÃO: A população deverá ser a última população do mês das atividades.");

        jLabel149.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel149.setForeground(new java.awt.Color(204, 0, 0));
        jLabel149.setText("(*) - ATENÇÃO: Campos marcados com asterisco são obrigatórios");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel143, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                    .addComponent(jLabel149, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jLabel143)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel149)
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Manutenção", jPanel2);

        jPanel3.setToolTipText("Atendimento Serviço Social ao Interno");

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Atendimento psicossocial ao preso");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Atendimento psicossocial a família do preso");

        jAtendimentoPsiPreso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAtendimentoPsiPreso.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jAtendimentoPsiPreso.setText("0");
        jAtendimentoPsiPreso.setEnabled(false);

        jAtendimentoPsiFamilaPreso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAtendimentoPsiFamilaPreso.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jAtendimentoPsiFamilaPreso.setText("0");
        jAtendimentoPsiFamilaPreso.setEnabled(false);

        jLabel116.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel116.setText("Números de dias de visitas");
        jLabel116.setToolTipText("Números de dias de visitas");

        jLabel117.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel117.setText("Número de visitantes de internos");
        jLabel117.setToolTipText("Número de visitantes de internos");

        jLabel118.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel118.setText("Média de visitantes por dia");
        jLabel118.setToolTipText("Número de visitantes por dia");

        jLabel119.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel119.setText("Média de visitantes por interno");
        jLabel119.setToolTipText("Número Média de visitantes por interno");

        jLabel120.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel120.setText("Número de crianças visitantes ");

        jNumeroDiasVisitas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNumeroDiasVisitas.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jNumeroDiasVisitas.setText("0");
        jNumeroDiasVisitas.setEnabled(false);

        jNumeroVistantesInternos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNumeroVistantesInternos.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jNumeroVistantesInternos.setText("0");
        jNumeroVistantesInternos.setEnabled(false);

        jMediaVisitasDia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMediaVisitasDia.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jMediaVisitasDia.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jMediaVisitasDia.setText("0");
        jMediaVisitasDia.setEnabled(false);

        jMediaVisitasInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMediaVisitasInterno.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jMediaVisitasInterno.setText("0");
        jMediaVisitasInterno.setEnabled(false);

        jNumeroCriancasVisitas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNumeroCriancasVisitas.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jNumeroCriancasVisitas.setText("0");
        jNumeroCriancasVisitas.setEnabled(false);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel120)
                    .addComponent(jLabel116)
                    .addComponent(jLabel117)
                    .addComponent(jLabel118)
                    .addComponent(jLabel119))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jNumeroCriancasVisitas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jMediaVisitasInterno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jMediaVisitasDia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNumeroVistantesInternos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNumeroDiasVisitas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jAtendimentoPsiFamilaPreso, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jAtendimentoPsiPreso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel13Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jAtendimentoPsiFamilaPreso, jAtendimentoPsiPreso, jMediaVisitasDia, jMediaVisitasInterno, jNumeroCriancasVisitas, jNumeroDiasVisitas, jNumeroVistantesInternos});

        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel11)
                    .addComponent(jAtendimentoPsiPreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel12)
                    .addComponent(jAtendimentoPsiFamilaPreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel116)
                    .addComponent(jNumeroDiasVisitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel117)
                    .addComponent(jNumeroVistantesInternos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel118)
                    .addComponent(jMediaVisitasDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel119)
                    .addComponent(jMediaVisitasInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jNumeroCriancasVisitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel120))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel13Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jAtendimentoPsiFamilaPreso, jAtendimentoPsiPreso, jMediaVisitasDia, jMediaVisitasInterno, jNumeroCriancasVisitas, jNumeroDiasVisitas, jNumeroVistantesInternos});

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 0, 0));
        jLabel13.setText("Preso identificados civilmente");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 0, 0));
        jLabel14.setText("Preso em atividade religiosa");

        jPresoIdentCivil.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPresoIdentCivil.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPresoIdentCivil.setText("0");
        jPresoIdentCivil.setEnabled(false);

        jPresoAtiviReligiosa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPresoAtiviReligiosa.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPresoAtiviReligiosa.setText("0");
        jPresoAtiviReligiosa.setEnabled(false);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPresoIdentCivil, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                    .addComponent(jPresoAtiviReligiosa))
                .addGap(8, 8, 8))
        );

        jPanel14Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPresoAtiviReligiosa, jPresoIdentCivil});

        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel13)
                    .addComponent(jPresoIdentCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel14)
                    .addComponent(jPresoAtiviReligiosa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(125, Short.MAX_VALUE))
        );

        jPanel14Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPresoAtiviReligiosa, jPresoIdentCivil});

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("ATENDIMENTO SERVIÇO SOCIAL AO INTERNO");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel18)
                .addGap(5, 5, 5))
        );

        jPanel63.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jBtNovo10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovo10.setToolTipText("Novo");
        jBtNovo10.setContentAreaFilled(false);
        jBtNovo10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovo10ActionPerformed(evt);
            }
        });

        jBtAlterar10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterar10.setToolTipText("Alterar");
        jBtAlterar10.setContentAreaFilled(false);
        jBtAlterar10.setEnabled(false);
        jBtAlterar10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterar10ActionPerformed(evt);
            }
        });

        jBtExcluir10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216104515_16.png"))); // NOI18N
        jBtExcluir10.setToolTipText("Excluir");
        jBtExcluir10.setContentAreaFilled(false);
        jBtExcluir10.setEnabled(false);
        jBtExcluir10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluir10ActionPerformed(evt);
            }
        });

        jBtSalvar10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvar10.setToolTipText("Gravar");
        jBtSalvar10.setContentAreaFilled(false);
        jBtSalvar10.setEnabled(false);
        jBtSalvar10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvar10ActionPerformed(evt);
            }
        });

        jBtCancelar10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelar10.setToolTipText("Cancelar");
        jBtCancelar10.setContentAreaFilled(false);
        jBtCancelar10.setEnabled(false);
        jBtCancelar10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelar10ActionPerformed(evt);
            }
        });

        jBtFinalizar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/tick.png"))); // NOI18N
        jBtFinalizar1.setToolTipText("Finalizar");
        jBtFinalizar1.setContentAreaFilled(false);
        jBtFinalizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFinalizar1ActionPerformed(evt);
            }
        });

        jBtSair10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/shutdown-icone-6920-16.png"))); // NOI18N
        jBtSair10.setToolTipText("Sair");
        jBtSair10.setContentAreaFilled(false);
        jBtSair10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSair10ActionPerformed(evt);
            }
        });

        jBtAuditoria10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoria10.setToolTipText("Auditoria");
        jBtAuditoria10.setContentAreaFilled(false);
        jBtAuditoria10.setEnabled(false);
        jBtAuditoria10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoria10ActionPerformed(evt);
            }
        });

        jBtImpressao3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/gtklp-icone-3770-16.png"))); // NOI18N
        jBtImpressao3.setToolTipText("Impressão");
        jBtImpressao3.setContentAreaFilled(false);
        jBtImpressao3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtImpressao3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel63Layout = new javax.swing.GroupLayout(jPanel63);
        jPanel63.setLayout(jPanel63Layout);
        jPanel63Layout.setHorizontalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel63Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jBtNovo10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtAlterar10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtExcluir10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtSalvar10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtCancelar10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jBtFinalizar1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jBtImpressao3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtSair10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jBtAuditoria10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel63Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterar10, jBtCancelar10, jBtExcluir10, jBtFinalizar1, jBtImpressao3, jBtNovo10, jBtSair10, jBtSalvar10});

        jPanel63Layout.setVerticalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel63Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtImpressao3)
                    .addComponent(jBtFinalizar1)
                    .addComponent(jBtSair10)
                    .addComponent(jBtAuditoria10)
                    .addComponent(jBtAlterar10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtExcluir10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtSalvar10)
                    .addComponent(jBtCancelar10)
                    .addComponent(jBtNovo10))
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel63, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("ASSI", jPanel3);

        jPanel4.setToolTipText("Alimentação fornecida ao Interno");

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 0, 0));
        jLabel19.setText("Lanches servidos a visitantes");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(204, 0, 0));
        jLabel21.setText("Alimentação servida a empregados da CONTRATADA (café)");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(204, 0, 0));
        jLabel22.setText("Alimentação servida a empregados da CONTRATADA (almoço)");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(204, 0, 0));
        jLabel24.setText("Alimentação servida a empregados da CONTRATADA (jantar)");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(204, 0, 0));
        jLabel25.setText("Alimentação servida a empregados da CONTRATADA (lanche)");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(204, 0, 0));
        jLabel26.setText("Alimentação servida a servidores do CONTRATANTE (café)");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(204, 0, 0));
        jLabel27.setText("Alimentação servida a servidores do CONTRATANTE (almoço)");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(204, 0, 0));
        jLabel28.setText("Alimentação servida a servidores do CONTRATANTE (jantar)");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(204, 0, 0));
        jLabel29.setText("Alimentação servida a servidores do CONTRATANTE (lanche)");

        jAlimentaServidaEmpContAlmoco.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAlimentaServidaEmpContAlmoco.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jAlimentaServidaEmpContAlmoco.setText("0");
        jAlimentaServidaEmpContAlmoco.setEnabled(false);

        jLanchesServidoVisita.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLanchesServidoVisita.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jLanchesServidoVisita.setText("0");
        jLanchesServidoVisita.setEnabled(false);

        jAlimentaServidaEmpContJantar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAlimentaServidaEmpContJantar.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jAlimentaServidaEmpContJantar.setText("0");
        jAlimentaServidaEmpContJantar.setEnabled(false);

        jAlimentaServidaEmpContLanche.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAlimentaServidaEmpContLanche.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jAlimentaServidaEmpContLanche.setText("0");
        jAlimentaServidaEmpContLanche.setEnabled(false);

        jAlimentaServidaServContCafe.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAlimentaServidaServContCafe.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jAlimentaServidaServContCafe.setText("0");
        jAlimentaServidaServContCafe.setEnabled(false);

        jAlimentaServidaEmpContCafe.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAlimentaServidaEmpContCafe.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jAlimentaServidaEmpContCafe.setText("0");
        jAlimentaServidaEmpContCafe.setEnabled(false);

        jAlimentaServidaServContAlmoco.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAlimentaServidaServContAlmoco.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jAlimentaServidaServContAlmoco.setText("0");
        jAlimentaServidaServContAlmoco.setEnabled(false);

        jAlimentaServidaServContJantar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAlimentaServidaServContJantar.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jAlimentaServidaServContJantar.setText("0");
        jAlimentaServidaServContJantar.setEnabled(false);

        jAlimentaServidaServContLanche.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAlimentaServidaServContLanche.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jAlimentaServidaServContLanche.setText("0");
        jAlimentaServidaServContLanche.setEnabled(false);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jAlimentaServidaServContLanche, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jAlimentaServidaServContJantar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLanchesServidoVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jAlimentaServidaEmpContCafe, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jAlimentaServidaEmpContJantar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jAlimentaServidaServContCafe, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jAlimentaServidaServContAlmoco, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel25))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jAlimentaServidaEmpContLanche, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jAlimentaServidaEmpContAlmoco, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel18Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jAlimentaServidaEmpContAlmoco, jAlimentaServidaEmpContCafe, jAlimentaServidaEmpContJantar, jAlimentaServidaEmpContLanche, jAlimentaServidaServContAlmoco, jAlimentaServidaServContCafe, jAlimentaServidaServContJantar, jAlimentaServidaServContLanche, jLanchesServidoVisita});

        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel19)
                    .addComponent(jLanchesServidoVisita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel21)
                    .addComponent(jAlimentaServidaEmpContCafe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel22)
                    .addComponent(jAlimentaServidaEmpContAlmoco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel24)
                    .addComponent(jAlimentaServidaEmpContJantar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(jAlimentaServidaEmpContLanche, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel26)
                    .addComponent(jAlimentaServidaServContCafe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel27)
                    .addComponent(jAlimentaServidaServContAlmoco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jAlimentaServidaServContJantar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jAlimentaServidaServContLanche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addContainerGap(144, Short.MAX_VALUE))
        );

        jPanel18Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jAlimentaServidaEmpContAlmoco, jAlimentaServidaEmpContCafe, jAlimentaServidaEmpContJantar, jAlimentaServidaEmpContLanche, jAlimentaServidaServContAlmoco, jAlimentaServidaServContCafe, jAlimentaServidaServContJantar, jAlimentaServidaServContLanche, jLanchesServidoVisita});

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("ALIMENTAÇÃO FORNECIDA AOS SERVIDORES");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel20)
                .addGap(5, 5, 5))
        );

        jPanel64.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jBtNovo11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovo11.setToolTipText("Novo");
        jBtNovo11.setContentAreaFilled(false);
        jBtNovo11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovo11ActionPerformed(evt);
            }
        });

        jBtAlterar11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterar11.setToolTipText("Alterar");
        jBtAlterar11.setContentAreaFilled(false);
        jBtAlterar11.setEnabled(false);
        jBtAlterar11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterar11ActionPerformed(evt);
            }
        });

        jBtExcluir11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216104515_16.png"))); // NOI18N
        jBtExcluir11.setToolTipText("Excluir");
        jBtExcluir11.setContentAreaFilled(false);
        jBtExcluir11.setEnabled(false);
        jBtExcluir11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluir11ActionPerformed(evt);
            }
        });

        jBtSalvar11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvar11.setToolTipText("Gravar");
        jBtSalvar11.setContentAreaFilled(false);
        jBtSalvar11.setEnabled(false);
        jBtSalvar11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvar11ActionPerformed(evt);
            }
        });

        jBtCancelar11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelar11.setToolTipText("Cancelar");
        jBtCancelar11.setContentAreaFilled(false);
        jBtCancelar11.setEnabled(false);
        jBtCancelar11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelar11ActionPerformed(evt);
            }
        });

        jBtFinalizar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/tick.png"))); // NOI18N
        jBtFinalizar2.setToolTipText("Finalizar");
        jBtFinalizar2.setContentAreaFilled(false);
        jBtFinalizar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFinalizar2ActionPerformed(evt);
            }
        });

        jBtSair11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/shutdown-icone-6920-16.png"))); // NOI18N
        jBtSair11.setToolTipText("Sair");
        jBtSair11.setContentAreaFilled(false);
        jBtSair11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSair11ActionPerformed(evt);
            }
        });

        jBtAuditoria11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoria11.setToolTipText("Auditoria");
        jBtAuditoria11.setContentAreaFilled(false);
        jBtAuditoria11.setEnabled(false);
        jBtAuditoria11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoria11ActionPerformed(evt);
            }
        });

        jBtImpressao4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/gtklp-icone-3770-16.png"))); // NOI18N
        jBtImpressao4.setToolTipText("Impressão");
        jBtImpressao4.setContentAreaFilled(false);
        jBtImpressao4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtImpressao4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel64Layout = new javax.swing.GroupLayout(jPanel64);
        jPanel64.setLayout(jPanel64Layout);
        jPanel64Layout.setHorizontalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel64Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jBtNovo11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtAlterar11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtExcluir11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtSalvar11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtCancelar11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jBtFinalizar2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtImpressao4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtSair11, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jBtAuditoria11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel64Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterar11, jBtCancelar11, jBtExcluir11, jBtFinalizar2, jBtImpressao4, jBtNovo11, jBtSair11, jBtSalvar11});

        jPanel64Layout.setVerticalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel64Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtImpressao4)
                    .addComponent(jBtFinalizar2)
                    .addComponent(jBtSair11)
                    .addComponent(jBtAuditoria11)
                    .addComponent(jBtAlterar11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtExcluir11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtSalvar11)
                    .addComponent(jBtCancelar11)
                    .addComponent(jBtNovo11))
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel64, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        jTabbedPane1.addTab("AFV", jPanel4);

        jPanel5.setToolTipText("Atendimento a Saúde do Interno");

        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("ATENDIMENTO A SAÚDE DO INTERNO");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel33)
                .addGap(5, 5, 5))
        );

        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel34.setText("Atendimento médico clínico");
        jLabel34.setToolTipText("Atendimento médico clínico");

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel35.setText("Atendimento médico psiquiátrico");
        jLabel35.setToolTipText("Atendimento médico psiquiátrico");

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel36.setText("Atendimento enfermagem");
        jLabel36.setToolTipText("Atendimento enfermagem");

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel37.setText("Procedimentos odontológicos");
        jLabel37.setToolTipText("Procedimentos odontológicos");

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel38.setText("Atendimento psicológico");
        jLabel38.setToolTipText("Atendimento psicológico");

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel39.setText("Tratamento de agravos diagnosticados");
        jLabel39.setToolTipText("Tratamento de agravos diagnosticados");

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel40.setText("Preso sensib. e capac. sobre cuidados com a saúde bucal  (Atendimentos ");
        jLabel40.setToolTipText("Preso sensib. e capac. sobre cuidados com a saúde bucal  (Atendimentos odontológicos)");

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel41.setText("Preso sensib. e capac. sobre cuidados com a saúde e controle das doenças ");
        jLabel41.setToolTipText("Preso sensib. e capac. sobre cuidados com a saúde e controle das doenças infectocontagiosas");

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel42.setText("Controle da hipertensão");
        jLabel42.setToolTipText("Controle da hipertensão");

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel43.setText("Controle das diabetes");
        jLabel43.setToolTipText("Controle das diabetes");

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel44.setText("Aspectos relacionados a sexualidades");
        jLabel44.setToolTipText("Aspectos relacionados a sexualidades");

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel45.setText("Presos vacinados");
        jLabel45.setToolTipText("Presos vacinados");

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel46.setText("infectocontagiosas");

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel47.setText("odontológicos)");

        jAtendimentoMedClinico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAtendimentoMedClinico.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jAtendimentoMedClinico.setText("0");
        jAtendimentoMedClinico.setToolTipText("Atendimento médico clínico");
        jAtendimentoMedClinico.setEnabled(false);

        jAtendimentoMedPsi.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAtendimentoMedPsi.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jAtendimentoMedPsi.setText("0");
        jAtendimentoMedPsi.setToolTipText("Atendimento médico psiquiátrico");
        jAtendimentoMedPsi.setEnabled(false);

        jAtendimentoEnfermagem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAtendimentoEnfermagem.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jAtendimentoEnfermagem.setText("0");
        jAtendimentoEnfermagem.setToolTipText("Atendimento enfermagem");
        jAtendimentoEnfermagem.setEnabled(false);

        jProcedimentoOdontologico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jProcedimentoOdontologico.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jProcedimentoOdontologico.setText("0");
        jProcedimentoOdontologico.setToolTipText("Procedimentos odontológicos");
        jProcedimentoOdontologico.setEnabled(false);

        jAtendimentoPsicologico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAtendimentoPsicologico.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jAtendimentoPsicologico.setText("0");
        jAtendimentoPsicologico.setToolTipText("Atendimento psicológico");
        jAtendimentoPsicologico.setEnabled(false);

        jTratamentoAgravDiaginostico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTratamentoAgravDiaginostico.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTratamentoAgravDiaginostico.setText("0");
        jTratamentoAgravDiaginostico.setToolTipText("Tratamento de agravos diagnosticados");
        jTratamentoAgravDiaginostico.setEnabled(false);

        jAtendimentoOdontologicos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAtendimentoOdontologicos.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jAtendimentoOdontologicos.setText("0");
        jAtendimentoOdontologicos.setToolTipText("Preso sensib. e capac. sobre cuidados com a saúde bucal  (Atendimentos odontológicos)");
        jAtendimentoOdontologicos.setEnabled(false);

        jPresoDoencaInfecto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPresoDoencaInfecto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPresoDoencaInfecto.setText("0");
        jPresoDoencaInfecto.setToolTipText("Preso sensib. e capac. sobre cuidados com a saúde e controle das doenças infectocontagiosas");
        jPresoDoencaInfecto.setEnabled(false);

        jControlHipertensao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jControlHipertensao.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jControlHipertensao.setText("0");
        jControlHipertensao.setToolTipText("Controle da hipertensão");
        jControlHipertensao.setEnabled(false);

        jControleDiabetes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jControleDiabetes.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jControleDiabetes.setText("0");
        jControleDiabetes.setToolTipText("Controle das diabetes");
        jControleDiabetes.setEnabled(false);

        jAspectosSexual.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAspectosSexual.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jAspectosSexual.setText("0");
        jAspectosSexual.setToolTipText("Aspectos relacionados a sexualidades");
        jAspectosSexual.setEnabled(false);

        jPresosVacinados.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPresosVacinados.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPresosVacinados.setText("0");
        jPresosVacinados.setToolTipText("Presos vacinados");
        jPresosVacinados.setEnabled(false);

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jAtendimentoMedPsi, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jAtendimentoEnfermagem, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jProcedimentoOdontologico, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jAtendimentoPsicologico, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel39)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTratamentoAgravDiaginostico, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel47)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jAtendimentoOdontologicos, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel42)
                            .addComponent(jLabel43))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPresoDoencaInfecto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jAtendimentoMedClinico, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jControleDiabetes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jControlHipertensao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel44)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jAspectosSexual, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel45)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPresosVacinados, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel46)
                            .addComponent(jLabel34)
                            .addComponent(jLabel41))
                        .addGap(0, 41, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel22Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jAspectosSexual, jAtendimentoEnfermagem, jAtendimentoMedClinico, jAtendimentoMedPsi, jAtendimentoOdontologicos, jAtendimentoPsicologico, jControlHipertensao, jControleDiabetes, jPresoDoencaInfecto, jPresosVacinados, jProcedimentoOdontologico, jTratamentoAgravDiaginostico});

        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel35)
                            .addComponent(jAtendimentoMedPsi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jAtendimentoEnfermagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel37)
                            .addComponent(jProcedimentoOdontologico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel38)
                            .addComponent(jAtendimentoPsicologico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel39)
                            .addComponent(jTratamentoAgravDiaginostico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jAtendimentoMedClinico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel47)
                    .addComponent(jAtendimentoOdontologicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel46)
                    .addComponent(jPresoDoencaInfecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jControlHipertensao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jControleDiabetes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel44)
                    .addComponent(jAspectosSexual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPresosVacinados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel65.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jBtNovo12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovo12.setToolTipText("Novo");
        jBtNovo12.setContentAreaFilled(false);
        jBtNovo12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovo12ActionPerformed(evt);
            }
        });

        jBtAlterar12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterar12.setToolTipText("Alterar");
        jBtAlterar12.setContentAreaFilled(false);
        jBtAlterar12.setEnabled(false);
        jBtAlterar12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterar12ActionPerformed(evt);
            }
        });

        jBtExcluir12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216104515_16.png"))); // NOI18N
        jBtExcluir12.setToolTipText("Excluir");
        jBtExcluir12.setContentAreaFilled(false);
        jBtExcluir12.setEnabled(false);
        jBtExcluir12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluir12ActionPerformed(evt);
            }
        });

        jBtSalvar12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvar12.setToolTipText("Gravar");
        jBtSalvar12.setContentAreaFilled(false);
        jBtSalvar12.setEnabled(false);
        jBtSalvar12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvar12ActionPerformed(evt);
            }
        });

        jBtCancelar12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelar12.setToolTipText("Cancelar");
        jBtCancelar12.setContentAreaFilled(false);
        jBtCancelar12.setEnabled(false);
        jBtCancelar12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelar12ActionPerformed(evt);
            }
        });

        jBtFinalizar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/tick.png"))); // NOI18N
        jBtFinalizar3.setToolTipText("Finalizar");
        jBtFinalizar3.setContentAreaFilled(false);
        jBtFinalizar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFinalizar3ActionPerformed(evt);
            }
        });

        jBtSair12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/shutdown-icone-6920-16.png"))); // NOI18N
        jBtSair12.setToolTipText("Sair");
        jBtSair12.setContentAreaFilled(false);
        jBtSair12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSair12ActionPerformed(evt);
            }
        });

        jBtAuditoria12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoria12.setToolTipText("Auditoria");
        jBtAuditoria12.setContentAreaFilled(false);
        jBtAuditoria12.setEnabled(false);
        jBtAuditoria12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoria12ActionPerformed(evt);
            }
        });

        jBtImpressao5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/gtklp-icone-3770-16.png"))); // NOI18N
        jBtImpressao5.setToolTipText("Impressão");
        jBtImpressao5.setContentAreaFilled(false);
        jBtImpressao5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtImpressao5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel65Layout = new javax.swing.GroupLayout(jPanel65);
        jPanel65.setLayout(jPanel65Layout);
        jPanel65Layout.setHorizontalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel65Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jBtNovo12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtAlterar12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtExcluir12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtSalvar12, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtCancelar12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jBtFinalizar3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jBtImpressao5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtSair12, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jBtAuditoria12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel65Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterar12, jBtCancelar12, jBtExcluir12, jBtFinalizar3, jBtImpressao5, jBtNovo12, jBtSair12, jBtSalvar12});

        jPanel65Layout.setVerticalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel65Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtImpressao5)
                    .addComponent(jBtFinalizar3)
                    .addComponent(jBtSair12)
                    .addComponent(jBtAuditoria12)
                    .addComponent(jBtAlterar12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtExcluir12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtSalvar12)
                    .addComponent(jBtCancelar12)
                    .addComponent(jBtNovo12))
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel65, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel65, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("ASI", jPanel5);

        jPanel6.setToolTipText("Atendimento Educacional ao Interno");

        jPanel24.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setText("ATENDIMENTO EDUCACIONAL AO INTERNO");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel48)
                .addGap(5, 5, 5))
        );

        jPanel25.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel131.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel131.setText("Preso sentenciado matriculado no ensino formal ");
        jLabel131.setToolTipText("Preso sentenciado matriculado no ensino formal ");

        jLabel132.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel132.setText("Preso sentenciado matriculado e frequentando o ensino formal ");
        jLabel132.setToolTipText("Preso sentenciado matriculado e frequentando o ensino formal ");

        jPresoSentencaMatFreqEF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPresoSentencaMatFreqEF.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPresoSentencaMatFreqEF.setText("0");
        jPresoSentencaMatFreqEF.setEnabled(false);

        jPresoSentenciadoEF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPresoSentenciadoEF.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPresoSentenciadoEF.setText("0");
        jPresoSentenciadoEF.setEnabled(false);

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel131)
                    .addComponent(jLabel132))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPresoSentenciadoEF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPresoSentencaMatFreqEF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel25Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPresoSentencaMatFreqEF, jPresoSentenciadoEF});

        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel131)
                    .addComponent(jPresoSentenciadoEF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel132)
                    .addComponent(jPresoSentencaMatFreqEF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel25Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPresoSentencaMatFreqEF, jPresoSentenciadoEF});

        jPanel48.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true))));

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(204, 0, 0));
        jLabel49.setText("Preso em atividade de prática de esportes");

        jPresoAtiviPraticaEsportiva.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPresoAtiviPraticaEsportiva.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPresoAtiviPraticaEsportiva.setText("0");
        jPresoAtiviPraticaEsportiva.setEnabled(false);

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel48Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel49)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPresoAtiviPraticaEsportiva, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel49)
                    .addComponent(jPresoAtiviPraticaEsportiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(245, Short.MAX_VALUE))
        );

        jPanel66.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jBtNovo13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovo13.setToolTipText("Novo");
        jBtNovo13.setContentAreaFilled(false);
        jBtNovo13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovo13ActionPerformed(evt);
            }
        });

        jBtAlterar13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterar13.setToolTipText("Alterar");
        jBtAlterar13.setContentAreaFilled(false);
        jBtAlterar13.setEnabled(false);
        jBtAlterar13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterar13ActionPerformed(evt);
            }
        });

        jBtExcluir13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216104515_16.png"))); // NOI18N
        jBtExcluir13.setToolTipText("Excluir");
        jBtExcluir13.setContentAreaFilled(false);
        jBtExcluir13.setEnabled(false);
        jBtExcluir13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluir13ActionPerformed(evt);
            }
        });

        jBtSalvar13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvar13.setToolTipText("Gravar");
        jBtSalvar13.setContentAreaFilled(false);
        jBtSalvar13.setEnabled(false);
        jBtSalvar13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvar13ActionPerformed(evt);
            }
        });

        jBtCancelar13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelar13.setToolTipText("Cancelar");
        jBtCancelar13.setContentAreaFilled(false);
        jBtCancelar13.setEnabled(false);
        jBtCancelar13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelar13ActionPerformed(evt);
            }
        });

        jBtFinalizar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/tick.png"))); // NOI18N
        jBtFinalizar4.setToolTipText("Finalizar");
        jBtFinalizar4.setContentAreaFilled(false);
        jBtFinalizar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFinalizar4ActionPerformed(evt);
            }
        });

        jBtSair13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/shutdown-icone-6920-16.png"))); // NOI18N
        jBtSair13.setToolTipText("Sair");
        jBtSair13.setContentAreaFilled(false);
        jBtSair13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSair13ActionPerformed(evt);
            }
        });

        jBtAuditoria13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoria13.setToolTipText("Auditoria");
        jBtAuditoria13.setContentAreaFilled(false);
        jBtAuditoria13.setEnabled(false);
        jBtAuditoria13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoria13ActionPerformed(evt);
            }
        });

        jBtImpressao6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/gtklp-icone-3770-16.png"))); // NOI18N
        jBtImpressao6.setToolTipText("Impressão");
        jBtImpressao6.setContentAreaFilled(false);
        jBtImpressao6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtImpressao6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel66Layout = new javax.swing.GroupLayout(jPanel66);
        jPanel66.setLayout(jPanel66Layout);
        jPanel66Layout.setHorizontalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel66Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jBtNovo13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtAlterar13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtExcluir13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtSalvar13, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtCancelar13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jBtFinalizar4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtImpressao6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtSair13, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jBtAuditoria13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel66Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterar13, jBtCancelar13, jBtExcluir13, jBtFinalizar4, jBtImpressao6, jBtNovo13, jBtSair13, jBtSalvar13});

        jPanel66Layout.setVerticalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel66Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtImpressao6)
                    .addComponent(jBtFinalizar4)
                    .addComponent(jBtSair13)
                    .addComponent(jBtAuditoria13)
                    .addComponent(jBtAlterar13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtExcluir13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtSalvar13)
                    .addComponent(jBtCancelar13)
                    .addComponent(jBtNovo13))
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel66, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel66, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        jTabbedPane1.addTab("AEI", jPanel6);

        jPanel27.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setText("ASSISTÊNCIA MATERIAL AO INTERNO");

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel50)
                .addGap(5, 5, 5))
        );

        jPanel28.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel51.setText("Cobertor popular ");

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel52.setText("Colchão D23");

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel53.setText("Lençol de algodão de solteiro");

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel54.setText("Toalha de banho");

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel55.setText("Pote plástico");

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel56.setText("Caneca plástica");

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel57.setText("Aparelho de barbear descartável");

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel58.setText("Creme dental (90 gramas)");

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel59.setText("Escova de dentes");

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel60.setText("Absorventes para internas");

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel61.setText("Sabão em pó (200 gramas)");

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel62.setText("Sabonete (90 gramas)");

        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel63.setText("Desodo. antitranspirante em creme");

        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel64.setText("Bermuda");

        jLabel65.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel65.setText("Camisa ou camiseta");

        jLabel66.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel66.setText("Cuecas");

        jLabel68.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel68.setText("Par de chinelos");

        jLabel70.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel70.setText("Papel higiênico (rolo c/ 30 metros)");

        jDesodorante.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDesodorante.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jDesodorante.setText("0");
        jDesodorante.setEnabled(false);

        jSabaoPo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jSabaoPo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jSabaoPo.setText("0");
        jSabaoPo.setEnabled(false);

        jSabonete.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jSabonete.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jSabonete.setText("0");
        jSabonete.setEnabled(false);

        jBermuda.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jBermuda.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jBermuda.setText("0");
        jBermuda.setEnabled(false);

        jCamisa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCamisa.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCamisa.setText("0");
        jCamisa.setEnabled(false);

        jAparelhoBarbear.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAparelhoBarbear.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jAparelhoBarbear.setText("0");
        jAparelhoBarbear.setEnabled(false);

        jCremeDental.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCremeDental.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCremeDental.setText("0");
        jCremeDental.setEnabled(false);

        jEscovaDente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jEscovaDente.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jEscovaDente.setText("0");
        jEscovaDente.setEnabled(false);

        jAbsorvente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAbsorvente.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jAbsorvente.setText("0");
        jAbsorvente.setEnabled(false);

        jPapelHigienico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPapelHigienico.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPapelHigienico.setText("0");
        jPapelHigienico.setEnabled(false);

        jColchao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jColchao.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jColchao.setText("0");
        jColchao.setEnabled(false);

        jLencol.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLencol.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jLencol.setText("0");
        jLencol.setEnabled(false);

        jToalha.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jToalha.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jToalha.setText("0");
        jToalha.setEnabled(false);

        jPote.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPote.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPote.setText("0");
        jPote.setEnabled(false);

        jCaneca.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCaneca.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCaneca.setText("0");
        jCaneca.setEnabled(false);

        jCobertor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCobertor.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCobertor.setText("0");
        jCobertor.setEnabled(false);

        jChinelos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jChinelos.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jChinelos.setText("0");
        jChinelos.setEnabled(false);

        jCuecas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCuecas.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCuecas.setText("0");
        jCuecas.setEnabled(false);

        jLabel69.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel69.setText("Unif. especifico");

        jUniformeCompleto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jUniformeCompleto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jUniformeCompleto.setText("0");
        jUniformeCompleto.setEnabled(false);

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
                                .addComponent(jLabel56)
                                .addGap(117, 117, 117)
                                .addComponent(jCaneca, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel28Layout.createSequentialGroup()
                                    .addComponent(jLabel64)
                                    .addGap(154, 154, 154)
                                    .addComponent(jBermuda, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel28Layout.createSequentialGroup()
                                    .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel60)
                                        .addComponent(jLabel57))
                                    .addGap(19, 19, 19)
                                    .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jAbsorvente, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jAparelhoBarbear, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel28Layout.createSequentialGroup()
                                    .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel61)
                                        .addComponent(jLabel62))
                                    .addGap(52, 52, 52)
                                    .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jSabonete, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jSabaoPo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel28Layout.createSequentialGroup()
                                    .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel51)
                                        .addComponent(jLabel66))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jCobertor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jCuecas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel28Layout.createSequentialGroup()
                                    .addComponent(jLabel65)
                                    .addGap(92, 92, 92)
                                    .addComponent(jCamisa, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                                .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jUniformeCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                                .addComponent(jLabel54)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jToalha, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addComponent(jLabel52)
                                .addGap(136, 136, 136)
                                .addComponent(jColchao, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel28Layout.createSequentialGroup()
                                    .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel70)
                                        .addComponent(jLabel55))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPote, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPapelHigienico, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel28Layout.createSequentialGroup()
                                    .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel63)
                                        .addComponent(jLabel59)
                                        .addComponent(jLabel58)
                                        .addComponent(jLabel53))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jCremeDental, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jEscovaDente, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jDesodorante, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLencol, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                                    .addComponent(jLabel68)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jChinelos, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel28Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jAbsorvente, jAparelhoBarbear, jBermuda, jCamisa, jCaneca, jChinelos, jCobertor, jColchao, jCremeDental, jCuecas, jDesodorante, jEscovaDente, jLencol, jPapelHigienico, jPote, jSabaoPo, jSabonete, jToalha, jUniformeCompleto});

        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel57)
                    .addComponent(jAparelhoBarbear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54)
                    .addComponent(jToalha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel60)
                    .addComponent(jAbsorvente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel69)
                    .addComponent(jUniformeCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel64)
                    .addComponent(jBermuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel56)
                    .addComponent(jCaneca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel65)
                    .addComponent(jCamisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel51)
                    .addComponent(jCobertor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel52)
                    .addComponent(jColchao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel66)
                    .addComponent(jCuecas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel58)
                    .addComponent(jCremeDental, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel63)
                    .addComponent(jDesodorante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel59)
                    .addComponent(jEscovaDente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel53)
                    .addComponent(jLencol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel70)
                    .addComponent(jPapelHigienico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel68)
                    .addComponent(jChinelos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel55)
                    .addComponent(jPote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel61)
                    .addComponent(jSabaoPo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel62)
                    .addComponent(jSabonete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel28Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jAbsorvente, jAparelhoBarbear, jBermuda, jCamisa, jCaneca, jChinelos, jCobertor, jColchao, jCremeDental, jCuecas, jDesodorante, jEscovaDente, jLencol, jPapelHigienico, jPote, jSabaoPo, jSabonete, jToalha, jUniformeCompleto});

        jPanel67.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jBtNovo14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovo14.setToolTipText("Novo");
        jBtNovo14.setContentAreaFilled(false);
        jBtNovo14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovo14ActionPerformed(evt);
            }
        });

        jBtAlterar14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterar14.setToolTipText("Alterar");
        jBtAlterar14.setContentAreaFilled(false);
        jBtAlterar14.setEnabled(false);
        jBtAlterar14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterar14ActionPerformed(evt);
            }
        });

        jBtExcluir14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216104515_16.png"))); // NOI18N
        jBtExcluir14.setToolTipText("Excluir");
        jBtExcluir14.setContentAreaFilled(false);
        jBtExcluir14.setEnabled(false);
        jBtExcluir14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluir14ActionPerformed(evt);
            }
        });

        jBtSalvar14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvar14.setToolTipText("Gravar");
        jBtSalvar14.setContentAreaFilled(false);
        jBtSalvar14.setEnabled(false);
        jBtSalvar14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvar14ActionPerformed(evt);
            }
        });

        jBtCancelar14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelar14.setToolTipText("Cancelar");
        jBtCancelar14.setContentAreaFilled(false);
        jBtCancelar14.setEnabled(false);
        jBtCancelar14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelar14ActionPerformed(evt);
            }
        });

        jBtFinalizar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/tick.png"))); // NOI18N
        jBtFinalizar5.setToolTipText("Finalizar");
        jBtFinalizar5.setContentAreaFilled(false);
        jBtFinalizar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFinalizar5ActionPerformed(evt);
            }
        });

        jBtSair14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/shutdown-icone-6920-16.png"))); // NOI18N
        jBtSair14.setToolTipText("Sair");
        jBtSair14.setContentAreaFilled(false);
        jBtSair14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSair14ActionPerformed(evt);
            }
        });

        jBtAuditoria14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoria14.setToolTipText("Auditoria");
        jBtAuditoria14.setContentAreaFilled(false);
        jBtAuditoria14.setEnabled(false);
        jBtAuditoria14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoria14ActionPerformed(evt);
            }
        });

        jBtImpressao7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/gtklp-icone-3770-16.png"))); // NOI18N
        jBtImpressao7.setToolTipText("Impressão");
        jBtImpressao7.setContentAreaFilled(false);
        jBtImpressao7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtImpressao7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel67Layout = new javax.swing.GroupLayout(jPanel67);
        jPanel67.setLayout(jPanel67Layout);
        jPanel67Layout.setHorizontalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel67Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jBtNovo14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtAlterar14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtExcluir14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtSalvar14, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtCancelar14, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jBtFinalizar5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtImpressao7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtSair14, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jBtAuditoria14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel67Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterar14, jBtCancelar14, jBtExcluir14, jBtFinalizar5, jBtImpressao7, jBtNovo14, jBtSair14, jBtSalvar14});

        jPanel67Layout.setVerticalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel67Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtImpressao7)
                    .addComponent(jBtFinalizar5)
                    .addComponent(jBtSair14)
                    .addComponent(jBtAuditoria14)
                    .addComponent(jBtAlterar14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtExcluir14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtSalvar14)
                    .addComponent(jBtCancelar14)
                    .addComponent(jBtNovo14))
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel67, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel67, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("AMI", jPanel7);

        jPanel36.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel72.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel72.setText("Nº aparelho celular localizado na área convivência dos internos");
        jLabel72.setToolTipText("Nº de aparelho celular localizado na área de convivência dos internos");

        jLabel75.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel75.setText("Nº Objetos/materiais localizado na área convivência dos internos");
        jLabel75.setToolTipText("Nº de objetos/materiais não autorizados localizados na área de convivência dos internos");

        jLabel76.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel76.setText("Nº procedimentos de revistas em cada cela");
        jLabel76.setToolTipText("Nº procedimentos de revistas em cada cela");

        jLabel77.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel77.setText("Nº de ocorrência de indisciplina");
        jLabel77.setToolTipText("Nº de ocorrência  indisciplinar");

        jNumeroAparelhoConvive.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNumeroAparelhoConvive.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jNumeroAparelhoConvive.setText("0");
        jNumeroAparelhoConvive.setEnabled(false);

        jObjetosMateriais.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jObjetosMateriais.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jObjetosMateriais.setText("0");
        jObjetosMateriais.setEnabled(false);

        jNumeroOcorrenciasInd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNumeroOcorrenciasInd.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jNumeroOcorrenciasInd.setText("0");
        jNumeroOcorrenciasInd.setEnabled(false);

        jNumeroProcedRevista.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNumeroProcedRevista.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jNumeroProcedRevista.setText("0");
        jNumeroProcedRevista.setEnabled(false);

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel72)
                    .addComponent(jLabel77)
                    .addComponent(jLabel76)
                    .addComponent(jLabel75))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jNumeroAparelhoConvive, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jObjetosMateriais, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jNumeroProcedRevista, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jNumeroOcorrenciasInd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel36Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jNumeroAparelhoConvive, jNumeroOcorrenciasInd, jNumeroProcedRevista, jObjetosMateriais});

        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel72)
                    .addComponent(jNumeroAparelhoConvive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel75)
                    .addComponent(jObjetosMateriais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel76)
                    .addComponent(jNumeroProcedRevista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel77)
                    .addComponent(jNumeroOcorrenciasInd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jPanel36Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jNumeroAparelhoConvive, jNumeroOcorrenciasInd, jNumeroProcedRevista, jObjetosMateriais});

        jPanel38.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel71.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel71.setText("SEGURANÇA DO INTERNO");

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel71)
                .addGap(5, 5, 5))
        );

        jPanel43.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jNumeroHorasTVCFTV.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNumeroHorasTVCFTV.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jNumeroHorasTVCFTV.setText("0");
        jNumeroHorasTVCFTV.setEnabled(false);

        jNumeroOcorrenciaPessoasFerida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNumeroOcorrenciaPessoasFerida.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jNumeroOcorrenciaPessoasFerida.setText("0");
        jNumeroOcorrenciaPessoasFerida.setEnabled(false);

        jLabel85.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(204, 0, 0));
        jLabel85.setText("Nº dias c/ interrup. serviços raios X, portal detector metais portátil");
        jLabel85.setToolTipText("Nº dias com interrupção dos serviços de raios X, portal detector de metais e portátil");

        jNumeroFraldasEntreguePortaria.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNumeroFraldasEntreguePortaria.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jNumeroFraldasEntreguePortaria.setText("0");
        jNumeroFraldasEntreguePortaria.setEnabled(false);

        jLabel86.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(204, 0, 0));
        jLabel86.setText("Nº  interrup. serviços funcionamento veículos transporte presos");
        jLabel86.setToolTipText("Nº das com interrupção dos serviços de funcionamento dos veículos de transporte de presos");

        jLabel87.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(204, 0, 0));
        jLabel87.setText("Nº de falhas ocorridas no funcionamento gerador de energia");
        jLabel87.setToolTipText("Nº de falhas ocorridas no funcionamento gerador de energia");

        jLabel88.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(204, 0, 0));
        jLabel88.setText("Nº horas mau funcio.serviço BRS – Bloqueador de Sinal Radiocom.");
        jLabel88.setToolTipText("Nº horas com mau funcionamento de serviço BRS – Bloqueador de Sinal de Radiocomunicação");

        jLabel89.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(204, 0, 0));
        jLabel89.setText("Nº absor. entregues visitas proced. porta.interna – SCANER");
        jLabel89.setToolTipText("Nº de absorventes entregues as visitas em procedimento de portaria interna – SCANER");

        jLabel90.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(204, 0, 0));
        jLabel90.setText("Nº fraldas Descartáveis entregues visitas procedimento portaria ");
        jLabel90.setToolTipText("Nº de fraldas Descartáveis e entregues as visitas em procedimento de portaria ");

        jNumeroOcorrenciaPessoasRefem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNumeroOcorrenciaPessoasRefem.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jNumeroOcorrenciaPessoasRefem.setText("0");
        jNumeroOcorrenciaPessoasRefem.setEnabled(false);

        jNumeroOcorrenciaPessoaFerida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNumeroOcorrenciaPessoaFerida.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jNumeroOcorrenciaPessoaFerida.setText("0");
        jNumeroOcorrenciaPessoaFerida.setEnabled(false);

        jNumeroOcorrenciaRebeliao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNumeroOcorrenciaRebeliao.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jNumeroOcorrenciaRebeliao.setText("0");
        jNumeroOcorrenciaRebeliao.setEnabled(false);

        jNumeroOcorrenciaTentaFuga.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNumeroOcorrenciaTentaFuga.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jNumeroOcorrenciaTentaFuga.setText("0");
        jNumeroOcorrenciaTentaFuga.setEnabled(false);

        jUmeroInterFuncVeiculosTP.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jUmeroInterFuncVeiculosTP.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jUmeroInterFuncVeiculosTP.setText("0");
        jUmeroInterFuncVeiculosTP.setEnabled(false);

        jLabel78.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(204, 0, 0));
        jLabel78.setText(" Nº de ocorrência de tentativa de fugas");
        jLabel78.setToolTipText(" Nº de ocorrência de tentativa de fugas");

        jNumeroAbsorEntregueVisitas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNumeroAbsorEntregueVisitas.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jNumeroAbsorEntregueVisitas.setText("0");
        jNumeroAbsorEntregueVisitas.setEnabled(false);

        jLabel79.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(204, 0, 0));
        jLabel79.setText("Nº de ocorrência de rebelião ");
        jLabel79.setToolTipText("Nº de ocorrência de rebelião ");

        jNumeroFalhasGerador.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNumeroFalhasGerador.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jNumeroFalhasGerador.setText("0");
        jNumeroFalhasGerador.setEnabled(false);

        jLabel80.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(204, 0, 0));
        jLabel80.setText("Nº de ocorrência pessoa ferida");
        jLabel80.setToolTipText("Nº de ocorrência pessoa ferida");

        jNumeroHorasBloqueador.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNumeroHorasBloqueador.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jNumeroHorasBloqueador.setText("0");
        jNumeroHorasBloqueador.setEnabled(false);

        jLabel81.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(204, 0, 0));
        jLabel81.setText("Nº de ocorrência de pessoas tomadas como refém");
        jLabel81.setToolTipText("Nº de ocorrência de pessoas tomadas como refém");

        jNumeroDiasIntMetaPortatil.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNumeroDiasIntMetaPortatil.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jNumeroDiasIntMetaPortatil.setText("0");
        jNumeroDiasIntMetaPortatil.setEnabled(false);

        jLabel82.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(204, 0, 0));
        jLabel82.setText("Nº de ocorrência de pessoas gravemente feridas ou mortas");
        jLabel82.setToolTipText("Nº de ocorrência de pessoas gravemente feridas ou mortas");

        jNumeroDiasSemScannerCorpo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNumeroDiasSemScannerCorpo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jNumeroDiasSemScannerCorpo.setText("0");
        jNumeroDiasSemScannerCorpo.setEnabled(false);

        jLabel83.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(204, 0, 0));
        jLabel83.setText("Nº horas com interrupção dos serviços circuito fechado TV – CFTV");
        jLabel83.setToolTipText("Nº horas com interrupção dos serviços circuito fechado de TV – CFTV");

        jLabel84.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(204, 0, 0));
        jLabel84.setText(" Nº dias com interrupção dos serviços de scanner corporal");
        jLabel84.setToolTipText(" Nº dias com interrupção dos serviços de scanner corporal");

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel90)
                    .addComponent(jLabel88)
                    .addComponent(jLabel87)
                    .addComponent(jLabel86)
                    .addComponent(jLabel85)
                    .addComponent(jLabel84)
                    .addComponent(jLabel83)
                    .addComponent(jLabel82)
                    .addComponent(jLabel81)
                    .addComponent(jLabel80)
                    .addComponent(jLabel79)
                    .addComponent(jLabel78)
                    .addComponent(jLabel89))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jNumeroHorasTVCFTV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNumeroOcorrenciaPessoasFerida, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNumeroFraldasEntreguePortaria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNumeroOcorrenciaPessoasRefem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNumeroOcorrenciaPessoaFerida, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNumeroOcorrenciaRebeliao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNumeroOcorrenciaTentaFuga, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jUmeroInterFuncVeiculosTP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNumeroAbsorEntregueVisitas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNumeroFalhasGerador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNumeroHorasBloqueador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNumeroDiasSemScannerCorpo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNumeroDiasIntMetaPortatil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel43Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jNumeroAbsorEntregueVisitas, jNumeroDiasIntMetaPortatil, jNumeroDiasSemScannerCorpo, jNumeroFalhasGerador, jNumeroFraldasEntreguePortaria, jNumeroHorasBloqueador, jNumeroHorasTVCFTV, jNumeroOcorrenciaPessoaFerida, jNumeroOcorrenciaPessoasFerida, jNumeroOcorrenciaPessoasRefem, jNumeroOcorrenciaRebeliao, jNumeroOcorrenciaTentaFuga, jUmeroInterFuncVeiculosTP});

        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel43Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel78)
                    .addComponent(jNumeroOcorrenciaTentaFuga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel79)
                    .addComponent(jNumeroOcorrenciaRebeliao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel80)
                    .addComponent(jNumeroOcorrenciaPessoaFerida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel81)
                    .addComponent(jNumeroOcorrenciaPessoasRefem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel82)
                    .addComponent(jNumeroOcorrenciaPessoasFerida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel83)
                    .addComponent(jNumeroHorasTVCFTV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel84)
                    .addComponent(jNumeroDiasSemScannerCorpo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel85)
                    .addComponent(jNumeroDiasIntMetaPortatil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel86)
                    .addComponent(jUmeroInterFuncVeiculosTP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel87)
                    .addComponent(jNumeroFalhasGerador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel88)
                    .addComponent(jNumeroHorasBloqueador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel89)
                    .addComponent(jNumeroAbsorEntregueVisitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jNumeroFraldasEntreguePortaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel90))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel68.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jBtNovo15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovo15.setToolTipText("Novo");
        jBtNovo15.setContentAreaFilled(false);
        jBtNovo15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovo15ActionPerformed(evt);
            }
        });

        jBtAlterar15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterar15.setToolTipText("Alterar");
        jBtAlterar15.setContentAreaFilled(false);
        jBtAlterar15.setEnabled(false);
        jBtAlterar15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterar15ActionPerformed(evt);
            }
        });

        jBtExcluir15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216104515_16.png"))); // NOI18N
        jBtExcluir15.setToolTipText("Excluir");
        jBtExcluir15.setContentAreaFilled(false);
        jBtExcluir15.setEnabled(false);
        jBtExcluir15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluir15ActionPerformed(evt);
            }
        });

        jBtSalvar15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvar15.setToolTipText("Gravar");
        jBtSalvar15.setContentAreaFilled(false);
        jBtSalvar15.setEnabled(false);
        jBtSalvar15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvar15ActionPerformed(evt);
            }
        });

        jBtCancelar15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelar15.setToolTipText("Cancelar");
        jBtCancelar15.setContentAreaFilled(false);
        jBtCancelar15.setEnabled(false);
        jBtCancelar15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelar15ActionPerformed(evt);
            }
        });

        jBtFinalizar6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/tick.png"))); // NOI18N
        jBtFinalizar6.setToolTipText("Finalizar");
        jBtFinalizar6.setContentAreaFilled(false);
        jBtFinalizar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFinalizar6ActionPerformed(evt);
            }
        });

        jBtSair15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/shutdown-icone-6920-16.png"))); // NOI18N
        jBtSair15.setToolTipText("Sair");
        jBtSair15.setContentAreaFilled(false);
        jBtSair15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSair15ActionPerformed(evt);
            }
        });

        jBtAuditoria15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoria15.setToolTipText("Auditoria");
        jBtAuditoria15.setContentAreaFilled(false);
        jBtAuditoria15.setEnabled(false);
        jBtAuditoria15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoria15ActionPerformed(evt);
            }
        });

        jBtImpressao8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/gtklp-icone-3770-16.png"))); // NOI18N
        jBtImpressao8.setToolTipText("Impressão");
        jBtImpressao8.setContentAreaFilled(false);
        jBtImpressao8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtImpressao8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel68Layout = new javax.swing.GroupLayout(jPanel68);
        jPanel68.setLayout(jPanel68Layout);
        jPanel68Layout.setHorizontalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel68Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jBtNovo15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtAlterar15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtExcluir15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtSalvar15, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtCancelar15, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jBtFinalizar6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtImpressao8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtSair15, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jBtAuditoria15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel68Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterar15, jBtCancelar15, jBtExcluir15, jBtFinalizar6, jBtImpressao8, jBtNovo15, jBtSair15, jBtSalvar15});

        jPanel68Layout.setVerticalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel68Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtImpressao8)
                    .addComponent(jBtFinalizar6)
                    .addComponent(jBtSair15)
                    .addComponent(jBtAuditoria15)
                    .addComponent(jBtAlterar15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtExcluir15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtSalvar15)
                    .addComponent(jBtCancelar15)
                    .addComponent(jBtNovo15))
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel68, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel68, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("SEG", jPanel8);

        jPanel40.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel91.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel91.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel91.setText("ASSISTÊNCIA JURÍDICA");

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel91, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel91)
                .addGap(5, 5, 5))
        );

        jPanel41.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel92.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel92.setText("Atend. interno, família ou emissão de SAJ");
        jLabel92.setToolTipText("Atendimento ao interno, família ou emissão de SAJ");

        jLabel93.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel93.setText("Alvara de Soltura cumprido");
        jLabel93.setToolTipText("Alvara de Soltura cumprido");

        jLabel94.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel94.setText("Livramento condicional deferido");
        jLabel94.setToolTipText("Livramento condicional deferido");

        jLabel95.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel95.setText("Progressão de Regime Deferido");
        jLabel95.setToolTipText("Progressão de Regime Deferido");

        jLabel96.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel96.setText("Saída Temporárias Deferidas");
        jLabel96.setToolTipText("Saída Temporárias Deferidas");

        jAtendInternoSAJ.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAtendInternoSAJ.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jAtendInternoSAJ.setText("0");
        jAtendInternoSAJ.setEnabled(false);

        jAlvaraSolturaCumprido.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAlvaraSolturaCumprido.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jAlvaraSolturaCumprido.setText("0");
        jAlvaraSolturaCumprido.setEnabled(false);

        jLivarmentoCondRequerido.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLivarmentoCondRequerido.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jLivarmentoCondRequerido.setText("0");
        jLivarmentoCondRequerido.setEnabled(false);

        jProgressaoRegDeferido.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jProgressaoRegDeferido.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jProgressaoRegDeferido.setText("0");
        jProgressaoRegDeferido.setEnabled(false);

        jSaidasTempDeferida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jSaidasTempDeferida.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jSaidasTempDeferida.setText("0");
        jSaidasTempDeferida.setEnabled(false);

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addComponent(jLabel92)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jAtendInternoSAJ, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addComponent(jLabel96)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSaidasTempDeferida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addComponent(jLabel93)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jAlvaraSolturaCumprido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addComponent(jLabel94)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLivarmentoCondRequerido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addComponent(jLabel95)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jProgressaoRegDeferido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel41Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jAlvaraSolturaCumprido, jAtendInternoSAJ, jLivarmentoCondRequerido, jProgressaoRegDeferido, jSaidasTempDeferida});

        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel92)
                    .addComponent(jAtendInternoSAJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel93)
                    .addComponent(jAlvaraSolturaCumprido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel94)
                    .addComponent(jLivarmentoCondRequerido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel95)
                    .addComponent(jProgressaoRegDeferido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel96)
                    .addComponent(jSaidasTempDeferida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel41Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jAlvaraSolturaCumprido, jAtendInternoSAJ, jLivarmentoCondRequerido, jProgressaoRegDeferido, jSaidasTempDeferida});

        jPanel42.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel102.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel102.setForeground(new java.awt.Color(204, 0, 0));
        jLabel102.setText("Liberdade provisória requerida");
        jLabel102.setToolTipText("Liberdade provisória requerida");

        jLabel103.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel103.setForeground(new java.awt.Color(204, 0, 0));
        jLabel103.setText("Liberdade provisória deferida");
        jLabel103.setToolTipText("Liberdade provisória deferida");

        jLabel104.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel104.setForeground(new java.awt.Color(204, 0, 0));
        jLabel104.setText("Indultos requeridos");
        jLabel104.setToolTipText("Indultos requeridos");

        jLabel105.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel105.setForeground(new java.awt.Color(204, 0, 0));
        jLabel105.setText("Indultos deferidos");
        jLabel105.setToolTipText("Indultos deferidos");

        jLabel106.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel106.setForeground(new java.awt.Color(204, 0, 0));
        jLabel106.setText("Remissão de pena requerida");
        jLabel106.setToolTipText("Remissão de pena requerida");

        jLabel107.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel107.setForeground(new java.awt.Color(204, 0, 0));
        jLabel107.setText("Remissão de pena deferida");
        jLabel107.setToolTipText("Remissão de pena deferida");

        jLabel97.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel97.setForeground(new java.awt.Color(204, 0, 0));
        jLabel97.setText("Alvara de soltura recebida na unidade");
        jLabel97.setToolTipText("Alvara de soltura recebida na unidade");

        jLabel108.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel108.setForeground(new java.awt.Color(204, 0, 0));
        jLabel108.setText("Condicional requerida");
        jLabel108.setToolTipText("Condicional requerida");

        jLabel98.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(204, 0, 0));
        jLabel98.setText("Audiências provocadas");
        jLabel98.setToolTipText("Audiências provocadas");

        jLabel99.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(204, 0, 0));
        jLabel99.setText("Audiências Cumpridas");
        jLabel99.setToolTipText("Audiências Cumpridas");

        jLabel100.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel100.setForeground(new java.awt.Color(204, 0, 0));
        jLabel100.setText("Júri popular provocado");
        jLabel100.setToolTipText("Júri popular provocado");

        jLabel101.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel101.setForeground(new java.awt.Color(204, 0, 0));
        jLabel101.setText("Júri popular cumprido");
        jLabel101.setToolTipText("Júri popular cumprido");

        jCondicionalRequerida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCondicionalRequerida.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCondicionalRequerida.setText("0");
        jCondicionalRequerida.setEnabled(false);

        jAlvarSolRecebeUni.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAlvarSolRecebeUni.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jAlvarSolRecebeUni.setText("0");
        jAlvarSolRecebeUni.setEnabled(false);

        jLabel109.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel109.setForeground(new java.awt.Color(204, 0, 0));
        jLabel109.setText("Progressão reg.requerido");
        jLabel109.setToolTipText("Progressão de regime requerido");

        jLabel110.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel110.setForeground(new java.awt.Color(204, 0, 0));
        jLabel110.setText("Saída Temp. requerida");
        jLabel110.setToolTipText("Saída Temporária requerida");

        jLabel111.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel111.setForeground(new java.awt.Color(204, 0, 0));
        jLabel111.setText("Habeas corpus impetrados");
        jLabel111.setToolTipText("Habeas corpus impetrados");

        jLabel112.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel112.setForeground(new java.awt.Color(204, 0, 0));
        jLabel112.setText("Habeas corpus deferidos");
        jLabel112.setToolTipText("Habeas corpus deferidos");

        jLabel113.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel113.setForeground(new java.awt.Color(204, 0, 0));
        jLabel113.setText("Laudos Psicolo. emitidos");

        jLabel114.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel114.setForeground(new java.awt.Color(204, 0, 0));
        jLabel114.setText("Laudos Psiquia. emitidos");
        jLabel114.setToolTipText("Laudos Psiquiátricos emitidos");

        jLabel115.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel115.setForeground(new java.awt.Color(204, 0, 0));
        jLabel115.setText("T.P. - (04/2017CGU)");
        jLabel115.setToolTipText("Transferências – provimento (04/2017CGU)");

        jAudienciaProvocadas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAudienciaProvocadas.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jAudienciaProvocadas.setText("0");
        jAudienciaProvocadas.setEnabled(false);

        jProgressaoRegRequerido.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jProgressaoRegRequerido.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jProgressaoRegRequerido.setText("0");
        jProgressaoRegRequerido.setEnabled(false);

        jJuriPopular.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jJuriPopular.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jJuriPopular.setText("0");
        jJuriPopular.setEnabled(false);

        jAudienciaCumpridas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAudienciaCumpridas.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jAudienciaCumpridas.setText("0");
        jAudienciaCumpridas.setEnabled(false);

        jLiberdadeProvRequerida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLiberdadeProvRequerida.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jLiberdadeProvRequerida.setText("0");
        jLiberdadeProvRequerida.setEnabled(false);

        jJuriPopularCumprido.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jJuriPopularCumprido.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jJuriPopularCumprido.setText("0");
        jJuriPopularCumprido.setEnabled(false);

        jIndultosRequeridos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIndultosRequeridos.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIndultosRequeridos.setText("0");
        jIndultosRequeridos.setEnabled(false);

        jLiberdadeProvDeferida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLiberdadeProvDeferida.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jLiberdadeProvDeferida.setText("0");
        jLiberdadeProvDeferida.setEnabled(false);

        jRemissaoPenaRequerida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jRemissaoPenaRequerida.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jRemissaoPenaRequerida.setText("0");
        jRemissaoPenaRequerida.setEnabled(false);

        jIndultosDeferidos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIndultosDeferidos.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIndultosDeferidos.setText("0");
        jIndultosDeferidos.setEnabled(false);

        jHabeasCorpusDeferido.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHabeasCorpusDeferido.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jHabeasCorpusDeferido.setText("0");
        jHabeasCorpusDeferido.setEnabled(false);

        jLaudosPsiqEmitidos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLaudosPsiqEmitidos.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jLaudosPsiqEmitidos.setText("0");
        jLaudosPsiqEmitidos.setEnabled(false);

        jTP.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTP.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTP.setText("0");
        jTP.setEnabled(false);

        jRemissaoPenaDeferida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jRemissaoPenaDeferida.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jRemissaoPenaDeferida.setText("0");
        jRemissaoPenaDeferida.setEnabled(false);

        jLaudoPsicoEmitidos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLaudoPsicoEmitidos.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jLaudoPsicoEmitidos.setText("0");
        jLaudoPsicoEmitidos.setEnabled(false);

        jHabeasCorpusImpetrados.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHabeasCorpusImpetrados.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jHabeasCorpusImpetrados.setText("0");
        jHabeasCorpusImpetrados.setEnabled(false);

        jSaidaTempRequerida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jSaidaTempRequerida.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jSaidaTempRequerida.setText("0");
        jSaidaTempRequerida.setEnabled(false);

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addComponent(jLabel97)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jAlvarSolRecebeUni, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addComponent(jLabel98)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jAudienciaProvocadas, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel99)
                            .addComponent(jLabel100))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jAudienciaCumpridas, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jJuriPopular, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel102)
                            .addComponent(jLabel101))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jJuriPopularCumprido, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLiberdadeProvRequerida, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel42Layout.createSequentialGroup()
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel103)
                            .addComponent(jLabel104)
                            .addComponent(jLabel105)
                            .addComponent(jLabel106)
                            .addComponent(jLabel107))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jIndultosDeferidos, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRemissaoPenaRequerida, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLiberdadeProvDeferida, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jIndultosRequeridos, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRemissaoPenaDeferida, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel108)
                            .addComponent(jLabel110, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel109)
                            .addComponent(jLabel111, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel114)
                            .addComponent(jLabel115)))
                    .addComponent(jLabel112, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel113, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(3, 3, 3)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jHabeasCorpusDeferido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLaudosPsiqEmitidos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCondicionalRequerida, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLaudoPsicoEmitidos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jHabeasCorpusImpetrados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSaidaTempRequerida, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jProgressaoRegRequerido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );

        jPanel42Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jAlvarSolRecebeUni, jAudienciaCumpridas, jAudienciaProvocadas, jCondicionalRequerida, jHabeasCorpusDeferido, jHabeasCorpusImpetrados, jIndultosDeferidos, jIndultosRequeridos, jJuriPopular, jJuriPopularCumprido, jLaudoPsicoEmitidos, jLaudosPsiqEmitidos, jLiberdadeProvDeferida, jLiberdadeProvRequerida, jProgressaoRegRequerido, jRemissaoPenaDeferida, jRemissaoPenaRequerida, jSaidaTempRequerida, jTP});

        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel42Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel108)
                            .addComponent(jCondicionalRequerida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jAlvarSolRecebeUni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel97))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jProgressaoRegRequerido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel109)
                            .addComponent(jAudienciaProvocadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel98))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jSaidaTempRequerida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel110)
                            .addComponent(jAudienciaCumpridas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel99))
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel42Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel100)
                                        .addComponent(jLabel111)
                                        .addComponent(jHabeasCorpusImpetrados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jJuriPopular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel101)
                                    .addComponent(jLabel112))
                                .addGap(2, 2, 2)
                                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel102)
                                    .addComponent(jLabel113)
                                    .addComponent(jLaudoPsicoEmitidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel42Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jHabeasCorpusDeferido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addComponent(jJuriPopularCumprido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jLiberdadeProvRequerida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLiberdadeProvDeferida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel103)
                        .addComponent(jLabel114)
                        .addComponent(jLaudosPsiqEmitidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel115)
                    .addComponent(jIndultosRequeridos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel104))
                .addGap(2, 2, 2)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addComponent(jLabel105)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel106))
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addComponent(jIndultosDeferidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jRemissaoPenaRequerida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel107)
                    .addComponent(jRemissaoPenaDeferida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel42Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jAlvarSolRecebeUni, jAudienciaCumpridas, jAudienciaProvocadas, jCondicionalRequerida, jHabeasCorpusDeferido, jHabeasCorpusImpetrados, jIndultosDeferidos, jIndultosRequeridos, jJuriPopular, jJuriPopularCumprido, jLaudoPsicoEmitidos, jLaudosPsiqEmitidos, jLiberdadeProvDeferida, jLiberdadeProvRequerida, jProgressaoRegRequerido, jRemissaoPenaDeferida, jRemissaoPenaRequerida, jSaidaTempRequerida, jTP});

        jPanel69.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jBtNovo16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovo16.setToolTipText("Novo");
        jBtNovo16.setContentAreaFilled(false);
        jBtNovo16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovo16ActionPerformed(evt);
            }
        });

        jBtAlterar16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterar16.setToolTipText("Alterar");
        jBtAlterar16.setContentAreaFilled(false);
        jBtAlterar16.setEnabled(false);
        jBtAlterar16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterar16ActionPerformed(evt);
            }
        });

        jBtExcluir16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216104515_16.png"))); // NOI18N
        jBtExcluir16.setToolTipText("Excluir");
        jBtExcluir16.setContentAreaFilled(false);
        jBtExcluir16.setEnabled(false);
        jBtExcluir16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluir16ActionPerformed(evt);
            }
        });

        jBtSalvar16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvar16.setToolTipText("Gravar");
        jBtSalvar16.setContentAreaFilled(false);
        jBtSalvar16.setEnabled(false);
        jBtSalvar16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvar16ActionPerformed(evt);
            }
        });

        jBtCancelar16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelar16.setToolTipText("Cancelar");
        jBtCancelar16.setContentAreaFilled(false);
        jBtCancelar16.setEnabled(false);
        jBtCancelar16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelar16ActionPerformed(evt);
            }
        });

        jBtFinalizar7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/tick.png"))); // NOI18N
        jBtFinalizar7.setToolTipText("Finalizar");
        jBtFinalizar7.setContentAreaFilled(false);
        jBtFinalizar7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFinalizar7ActionPerformed(evt);
            }
        });

        jBtSair16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/shutdown-icone-6920-16.png"))); // NOI18N
        jBtSair16.setToolTipText("Sair");
        jBtSair16.setContentAreaFilled(false);
        jBtSair16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSair16ActionPerformed(evt);
            }
        });

        jBtAuditoria16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoria16.setToolTipText("Auditoria");
        jBtAuditoria16.setContentAreaFilled(false);
        jBtAuditoria16.setEnabled(false);
        jBtAuditoria16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoria16ActionPerformed(evt);
            }
        });

        jBtImpressao9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/gtklp-icone-3770-16.png"))); // NOI18N
        jBtImpressao9.setToolTipText("Impressão");
        jBtImpressao9.setContentAreaFilled(false);
        jBtImpressao9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtImpressao9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel69Layout = new javax.swing.GroupLayout(jPanel69);
        jPanel69.setLayout(jPanel69Layout);
        jPanel69Layout.setHorizontalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel69Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jBtNovo16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtAlterar16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtExcluir16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtSalvar16, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtCancelar16, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jBtFinalizar7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtImpressao9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtSair16, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jBtAuditoria16, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel69Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterar16, jBtCancelar16, jBtExcluir16, jBtFinalizar7, jBtImpressao9, jBtNovo16, jBtSair16, jBtSalvar16});

        jPanel69Layout.setVerticalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel69Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtImpressao9)
                    .addComponent(jBtFinalizar7)
                    .addComponent(jBtSair16)
                    .addComponent(jBtAuditoria16)
                    .addComponent(jBtAlterar16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtExcluir16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtSalvar16)
                    .addComponent(jBtCancelar16)
                    .addComponent(jBtNovo16))
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel69, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addComponent(jPanel69, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("AJ", jPanel29);

        jPanel45.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel121.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel121.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel121.setText("ASSISTÊNCIA LABORAL");

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel121, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel121)
                .addGap(5, 5, 5))
        );

        jPanel46.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel122.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel122.setText("Triagem e atendimentos internos");
        jLabel122.setToolTipText("Triagem e atendimentos internos");

        jLabel123.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel123.setText("Ocupação com atividade recreativa /religiosa do interno");
        jLabel123.setToolTipText("Ocupação com atividade recreativa /religiosa do interno");

        jLabel124.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel124.setText("Preso em atividade de artes plásticas");
        jLabel124.setToolTipText("Preso em atividade de artes plásticas");

        jLabel125.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel125.setText("Preso em atividade de literatura");
        jLabel125.setToolTipText("Preso em atividade de literatura");

        jLabel126.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel126.setText("Preso em atividade de canto, teatro e cinema");
        jLabel126.setToolTipText("Preso em atividade de canto, teatro e cinema");

        jLabel127.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel127.setText("Preso matriculado cursos profissionalizantes c/ cert. profissional");
        jLabel127.setToolTipText("Preso matriculado nos cursos profissionalizantes com certificação profissional");

        jLabel128.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel128.setText("Preso certificado em cursos profissionalizantes");
        jLabel128.setToolTipText("Preso certificado em cursos profissionalizantes");

        jPresoMatProfissional.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPresoMatProfissional.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPresoMatProfissional.setText("0");
        jPresoMatProfissional.setEnabled(false);

        jPresoCertificaCursoProf.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPresoCertificaCursoProf.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPresoCertificaCursoProf.setText("0");
        jPresoCertificaCursoProf.setEnabled(false);

        jPresoAtiviCantoTeatro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPresoAtiviCantoTeatro.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPresoAtiviCantoTeatro.setText("0");
        jPresoAtiviCantoTeatro.setEnabled(false);

        jPresoAtiviLiteraria.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPresoAtiviLiteraria.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPresoAtiviLiteraria.setText("0");
        jPresoAtiviLiteraria.setEnabled(false);

        PresoAtiviArtesPlasticas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        PresoAtiviArtesPlasticas.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        PresoAtiviArtesPlasticas.setText("0");
        PresoAtiviArtesPlasticas.setEnabled(false);

        jOcupacaoAtiviRecreaReligiosa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jOcupacaoAtiviRecreaReligiosa.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jOcupacaoAtiviRecreaReligiosa.setText("0");
        jOcupacaoAtiviRecreaReligiosa.setEnabled(false);

        jTriagemAtendInernos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTriagemAtendInernos.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTriagemAtendInernos.setText("0");
        jTriagemAtendInernos.setEnabled(false);

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel127)
                    .addComponent(jLabel122)
                    .addComponent(jLabel128)
                    .addComponent(jLabel126)
                    .addComponent(jLabel125)
                    .addComponent(jLabel124)
                    .addComponent(jLabel123))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPresoCertificaCursoProf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPresoMatProfissional, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPresoAtiviCantoTeatro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPresoAtiviLiteraria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PresoAtiviArtesPlasticas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jOcupacaoAtiviRecreaReligiosa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTriagemAtendInernos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel46Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {PresoAtiviArtesPlasticas, jOcupacaoAtiviRecreaReligiosa, jPresoAtiviCantoTeatro, jPresoAtiviLiteraria, jPresoCertificaCursoProf, jPresoMatProfissional, jTriagemAtendInernos});

        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel122)
                    .addComponent(jTriagemAtendInernos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel123)
                    .addComponent(jOcupacaoAtiviRecreaReligiosa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel124)
                    .addComponent(PresoAtiviArtesPlasticas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel125)
                    .addComponent(jPresoAtiviLiteraria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel126)
                    .addComponent(jPresoAtiviCantoTeatro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel127)
                    .addComponent(jPresoMatProfissional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel128)
                    .addComponent(jPresoCertificaCursoProf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel46Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {PresoAtiviArtesPlasticas, jOcupacaoAtiviRecreaReligiosa, jPresoAtiviCantoTeatro, jPresoAtiviLiteraria, jPresoCertificaCursoProf, jPresoMatProfissional, jTriagemAtendInernos});

        jPanel47.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel129.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel129.setForeground(new java.awt.Color(204, 0, 0));
        jLabel129.setText("Preso sentenciado em atividade laboral remunerada");
        jLabel129.setToolTipText("Preso sentenciado em atividade laboral remunerada");

        jLabel130.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel130.setForeground(new java.awt.Color(204, 0, 0));
        jLabel130.setText("Preso em atividade laboral não remunerada");

        jPresoSentecaAtivLaboralRemun.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPresoSentecaAtivLaboralRemun.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPresoSentecaAtivLaboralRemun.setText("0");
        jPresoSentecaAtivLaboralRemun.setEnabled(false);

        jPresoAtiviLaboralNaoRemunera.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPresoAtiviLaboralNaoRemunera.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPresoAtiviLaboralNaoRemunera.setText("0");
        jPresoAtiviLaboralNaoRemunera.setEnabled(false);

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel47Layout.createSequentialGroup()
                        .addComponent(jLabel129)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPresoSentecaAtivLaboralRemun, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel47Layout.createSequentialGroup()
                        .addComponent(jLabel130)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPresoAtiviLaboralNaoRemunera, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel129)
                    .addComponent(jPresoSentecaAtivLaboralRemun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPresoAtiviLaboralNaoRemunera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel130))
                .addContainerGap(109, Short.MAX_VALUE))
        );

        jPanel70.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jBtNovo17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovo17.setToolTipText("Novo");
        jBtNovo17.setContentAreaFilled(false);
        jBtNovo17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovo17ActionPerformed(evt);
            }
        });

        jBtAlterar17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterar17.setToolTipText("Alterar");
        jBtAlterar17.setContentAreaFilled(false);
        jBtAlterar17.setEnabled(false);
        jBtAlterar17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterar17ActionPerformed(evt);
            }
        });

        jBtExcluir17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216104515_16.png"))); // NOI18N
        jBtExcluir17.setToolTipText("Excluir");
        jBtExcluir17.setContentAreaFilled(false);
        jBtExcluir17.setEnabled(false);
        jBtExcluir17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluir17ActionPerformed(evt);
            }
        });

        jBtSalvar17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvar17.setToolTipText("Gravar");
        jBtSalvar17.setContentAreaFilled(false);
        jBtSalvar17.setEnabled(false);
        jBtSalvar17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvar17ActionPerformed(evt);
            }
        });

        jBtCancelar17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelar17.setToolTipText("Cancelar");
        jBtCancelar17.setContentAreaFilled(false);
        jBtCancelar17.setEnabled(false);
        jBtCancelar17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelar17ActionPerformed(evt);
            }
        });

        jBtFinalizar8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/tick.png"))); // NOI18N
        jBtFinalizar8.setToolTipText("Finalizar");
        jBtFinalizar8.setContentAreaFilled(false);
        jBtFinalizar8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFinalizar8ActionPerformed(evt);
            }
        });

        jBtSair17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/shutdown-icone-6920-16.png"))); // NOI18N
        jBtSair17.setToolTipText("Sair");
        jBtSair17.setContentAreaFilled(false);
        jBtSair17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSair17ActionPerformed(evt);
            }
        });

        jBtAuditoria17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoria17.setToolTipText("Auditoria");
        jBtAuditoria17.setContentAreaFilled(false);
        jBtAuditoria17.setEnabled(false);
        jBtAuditoria17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoria17ActionPerformed(evt);
            }
        });

        jBtImpressao10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/gtklp-icone-3770-16.png"))); // NOI18N
        jBtImpressao10.setToolTipText("Impressão");
        jBtImpressao10.setContentAreaFilled(false);
        jBtImpressao10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtImpressao10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel70Layout = new javax.swing.GroupLayout(jPanel70);
        jPanel70.setLayout(jPanel70Layout);
        jPanel70Layout.setHorizontalGroup(
            jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel70Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jBtNovo17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtAlterar17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtExcluir17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtSalvar17, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtCancelar17, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jBtFinalizar8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtImpressao10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtSair17, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jBtAuditoria17, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel70Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterar17, jBtCancelar17, jBtExcluir17, jBtFinalizar8, jBtImpressao10, jBtNovo17, jBtSair17, jBtSalvar17});

        jPanel70Layout.setVerticalGroup(
            jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel70Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtImpressao10)
                    .addComponent(jBtFinalizar8)
                    .addComponent(jBtSair17)
                    .addComponent(jBtAuditoria17)
                    .addComponent(jBtAlterar17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtExcluir17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtSalvar17)
                    .addComponent(jBtCancelar17)
                    .addComponent(jBtNovo17))
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel70, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addComponent(jPanel70, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("AL", jPanel33);

        jPanel61.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel144.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel144.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel144.setText("ALIMENTAÇÃO FORNECIDAS A INTERNOS");

        javax.swing.GroupLayout jPanel61Layout = new javax.swing.GroupLayout(jPanel61);
        jPanel61.setLayout(jPanel61Layout);
        jPanel61Layout.setHorizontalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel61Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel144, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel61Layout.setVerticalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel61Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel144)
                .addGap(5, 5, 5))
        );

        jPanel54.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(204, 0, 0));
        jLabel30.setText("Alimentação servida a interno (café)");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(204, 0, 0));
        jLabel31.setText("Alimentação servida a interno (almoço)");

        jAlimentaServidaInternoCafe.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAlimentaServidaInternoCafe.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jAlimentaServidaInternoCafe.setText("0");
        jAlimentaServidaInternoCafe.setEnabled(false);

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(204, 0, 0));
        jLabel32.setText("Alimentação servida a interno (jantar)");

        jAlimentaServidaInternoAlmoco.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAlimentaServidaInternoAlmoco.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jAlimentaServidaInternoAlmoco.setText("0");
        jAlimentaServidaInternoAlmoco.setEnabled(false);

        jAlimentaServidaInternoJantar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAlimentaServidaInternoJantar.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jAlimentaServidaInternoJantar.setText("0");
        jAlimentaServidaInternoJantar.setEnabled(false);

        javax.swing.GroupLayout jPanel54Layout = new javax.swing.GroupLayout(jPanel54);
        jPanel54.setLayout(jPanel54Layout);
        jPanel54Layout.setHorizontalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel54Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jAlimentaServidaInternoJantar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel54Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jAlimentaServidaInternoCafe, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel54Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                        .addComponent(jAlimentaServidaInternoAlmoco, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel54Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jAlimentaServidaInternoAlmoco, jAlimentaServidaInternoCafe, jAlimentaServidaInternoJantar});

        jPanel54Layout.setVerticalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel30)
                    .addComponent(jAlimentaServidaInternoCafe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel31)
                    .addComponent(jAlimentaServidaInternoAlmoco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jAlimentaServidaInternoJantar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addContainerGap(293, Short.MAX_VALUE))
        );

        jPanel71.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jBtNovo18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovo18.setToolTipText("Novo");
        jBtNovo18.setContentAreaFilled(false);
        jBtNovo18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovo18ActionPerformed(evt);
            }
        });

        jBtAlterar18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterar18.setToolTipText("Alterar");
        jBtAlterar18.setContentAreaFilled(false);
        jBtAlterar18.setEnabled(false);
        jBtAlterar18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterar18ActionPerformed(evt);
            }
        });

        jBtExcluir18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216104515_16.png"))); // NOI18N
        jBtExcluir18.setToolTipText("Excluir");
        jBtExcluir18.setContentAreaFilled(false);
        jBtExcluir18.setEnabled(false);
        jBtExcluir18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluir18ActionPerformed(evt);
            }
        });

        jBtSalvar18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvar18.setToolTipText("Gravar");
        jBtSalvar18.setContentAreaFilled(false);
        jBtSalvar18.setEnabled(false);
        jBtSalvar18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvar18ActionPerformed(evt);
            }
        });

        jBtCancelar18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelar18.setToolTipText("Cancelar");
        jBtCancelar18.setContentAreaFilled(false);
        jBtCancelar18.setEnabled(false);
        jBtCancelar18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelar18ActionPerformed(evt);
            }
        });

        jBtFinalizar9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/tick.png"))); // NOI18N
        jBtFinalizar9.setToolTipText("Finalizar");
        jBtFinalizar9.setContentAreaFilled(false);
        jBtFinalizar9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFinalizar9ActionPerformed(evt);
            }
        });

        jBtSair18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/shutdown-icone-6920-16.png"))); // NOI18N
        jBtSair18.setToolTipText("Sair");
        jBtSair18.setContentAreaFilled(false);
        jBtSair18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSair18ActionPerformed(evt);
            }
        });

        jBtAuditoria18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoria18.setToolTipText("Auditoria");
        jBtAuditoria18.setContentAreaFilled(false);
        jBtAuditoria18.setEnabled(false);
        jBtAuditoria18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoria18ActionPerformed(evt);
            }
        });

        jBtImpressao11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/gtklp-icone-3770-16.png"))); // NOI18N
        jBtImpressao11.setToolTipText("Impressão");
        jBtImpressao11.setContentAreaFilled(false);
        jBtImpressao11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtImpressao11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel71Layout = new javax.swing.GroupLayout(jPanel71);
        jPanel71.setLayout(jPanel71Layout);
        jPanel71Layout.setHorizontalGroup(
            jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel71Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jBtNovo18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtAlterar18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtExcluir18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtSalvar18, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtCancelar18, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jBtFinalizar9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtImpressao11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtSair18, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jBtAuditoria18, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel71Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterar18, jBtCancelar18, jBtExcluir18, jBtFinalizar9, jBtImpressao11, jBtNovo18, jBtSair18, jBtSalvar18});

        jPanel71Layout.setVerticalGroup(
            jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel71Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtImpressao11)
                    .addComponent(jBtFinalizar9)
                    .addComponent(jBtSair18)
                    .addComponent(jBtAuditoria18)
                    .addComponent(jBtAlterar18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtExcluir18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtSalvar18)
                    .addComponent(jBtCancelar18)
                    .addComponent(jBtNovo18))
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel71, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addComponent(jPanel71, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel61, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("AFI", jPanel34);

        jPanel58.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel142.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel142.setText("08 - AL - ASSISTÊNCIA LABORAL");

        jTotal08.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTotal08.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTotal08.setText("0");
        jTotal08.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTotal08.setEnabled(false);
        jTotal08.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel58Layout = new javax.swing.GroupLayout(jPanel58);
        jPanel58.setLayout(jPanel58Layout);
        jPanel58Layout.setHorizontalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel142, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTotal08, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel58Layout.setVerticalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel58Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel142)
                    .addComponent(jTotal08, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jPanel50.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel133.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel133.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel133.setText("TOTALIZADORES MENSAIS");

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel133, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel133)
                .addGap(5, 5, 5))
        );

        jPanel55.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel139.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel139.setText("05 - AMI - ASSISTÊNCIA MATERIAL AO INTERNO");

        jTotal05.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTotal05.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTotal05.setText("0");
        jTotal05.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTotal05.setEnabled(false);
        jTotal05.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel55Layout = new javax.swing.GroupLayout(jPanel55);
        jPanel55.setLayout(jPanel55Layout);
        jPanel55Layout.setHorizontalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel139)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTotal05, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel55Layout.setVerticalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel55Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel139)
                    .addComponent(jTotal05, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jPanel59.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jBtCalcularTotais.setForeground(new java.awt.Color(204, 0, 0));
        jBtCalcularTotais.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/calculator_edit.png"))); // NOI18N
        jBtCalcularTotais.setText("Calular Totais");

        javax.swing.GroupLayout jPanel59Layout = new javax.swing.GroupLayout(jPanel59);
        jPanel59.setLayout(jPanel59Layout);
        jPanel59Layout.setHorizontalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jBtCalcularTotais)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel59Layout.setVerticalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel59Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jBtCalcularTotais)
                .addGap(22, 22, 22))
        );

        jPanel51.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel135.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel135.setText("02 - AFV - ALIMENTAÇÃO FORNECIDAS AOS SERVIDORES");

        jTotal02.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTotal02.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTotal02.setText("0");
        jTotal02.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTotal02.setEnabled(false);
        jTotal02.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel51Layout = new javax.swing.GroupLayout(jPanel51);
        jPanel51.setLayout(jPanel51Layout);
        jPanel51Layout.setHorizontalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel135)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTotal02, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel51Layout.setVerticalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel51Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel135)
                    .addComponent(jTotal02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jPanel56.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel140.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel140.setText("06 - SEG - SEGURANÇA DO INTERNO");

        jTotal06.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTotal06.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTotal06.setText("0");
        jTotal06.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTotal06.setEnabled(false);
        jTotal06.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel56Layout = new javax.swing.GroupLayout(jPanel56);
        jPanel56.setLayout(jPanel56Layout);
        jPanel56Layout.setHorizontalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel56Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel140, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTotal06, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel56Layout.setVerticalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel56Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel140)
                    .addComponent(jTotal06, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jPanel52.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel136.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel136.setText("03 - ASI - ATENDIMENTO A SAÚDE DO INTERNO");

        jTotal03.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTotal03.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTotal03.setText("0");
        jTotal03.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTotal03.setEnabled(false);
        jTotal03.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel52Layout = new javax.swing.GroupLayout(jPanel52);
        jPanel52.setLayout(jPanel52Layout);
        jPanel52Layout.setHorizontalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel136, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTotal03, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel52Layout.setVerticalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel52Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel136)
                    .addComponent(jTotal03, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jPanel57.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel141.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel141.setText("07 - AJ - ASSISTÊNCIA JURÍDICA");

        jTotal07.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTotal07.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTotal07.setText("0");
        jTotal07.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTotal07.setEnabled(false);
        jTotal07.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel57Layout = new javax.swing.GroupLayout(jPanel57);
        jPanel57.setLayout(jPanel57Layout);
        jPanel57Layout.setHorizontalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel141, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTotal07, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel57Layout.setVerticalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel57Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel141)
                    .addComponent(jTotal07, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jPanel49.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel134.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel134.setText("01 - ASSI - ATENDIMENTO SERVIÇO SOCIAL AO INTERNO");

        jTotal01.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTotal01.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTotal01.setText("0");
        jTotal01.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTotal01.setEnabled(false);
        jTotal01.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel134)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTotal01, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel49Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel134)
                    .addComponent(jTotal01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jPanel53.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel137.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel137.setText("04 - AEI - ATENDIMENTO EDUCACIONAL AO INTERNO");

        jTotal04.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTotal04.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTotal04.setText("0");
        jTotal04.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTotal04.setEnabled(false);
        jTotal04.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel53Layout = new javax.swing.GroupLayout(jPanel53);
        jPanel53.setLayout(jPanel53Layout);
        jPanel53Layout.setHorizontalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel137)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTotal04, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel53Layout.setVerticalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel53Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel137)
                    .addComponent(jTotal04, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jPanel62.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel145.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel145.setText("09 - AFI - ALIMENTAÇÃO FORNECEDIDAS AOS INTERNOS");

        jTotal09.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTotal09.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTotal09.setText("0");
        jTotal09.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTotal09.setEnabled(false);
        jTotal09.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel62Layout = new javax.swing.GroupLayout(jPanel62);
        jPanel62.setLayout(jPanel62Layout);
        jPanel62Layout.setHorizontalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel62Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel145)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTotal09, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel62Layout.setVerticalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel62Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel145)
                    .addComponent(jTotal09, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel56, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel57, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel56, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel57, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel58, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel62, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("TOT", jPanel35);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 509, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(300, 30, 523, 498);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesqNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNomeActionPerformed
        // TODO add your handling code here:
//        count = 0;
//        flag = 1;
//        pesquisarFuncNome("SELECT * FROM COLABORADOR "
//            + "INNER JOIN DEPARTAMENTOS "
//            + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
//            + "INNER JOIN CARGOS "
//            + "ON COLABORADOR.IdCargo=CARGOS.IdCargo "
//            + "WHERE NomeFunc LIKE'%" + jPesqNome.getText() + "%'");
    }//GEN-LAST:event_jBtPesqNomeActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
//        count = 0;
//        flag = 1;
//        if (evt.getStateChange() == evt.SELECTED) {
//            this.preencherTodasEntradas("SELECT * FROM COLABORADOR "
//                + "INNER JOIN DEPARTAMENTOS "
//                + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
//                + "INNER JOIN CARGOS "
//                + "ON COLABORADOR.IdCargo=CARGOS.IdCargo WHERE StatusFunc='" + jComboBoxPesqFunc.getSelectedItem() + "'ORDER BY NomeFunc");
//        } else {
//            jtotalRegistros.setText("");
//            limparTabela();
//        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jBtPesqCodigoFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqCodigoFuncActionPerformed
        // TODO add your handling code here:
//        count = 0;
//        flag = 1;
//        if (jCodigoPesqFunc.getText().equals("")) {
//            JOptionPane.showMessageDialog(null, "Informe o código do colaborador para pesquisa.");
//        } else {
//            preencherTodasEntradas("SELECT * FROM COLABORADOR "
//                + "INNER JOIN DEPARTAMENTOS "
//                + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
//                + "INNER JOIN CARGOS "
//                + "ON COLABORADOR.IdCargo=CARGOS.IdCargo "
//                + "WHERE NomeFunc='" + jCodigoPesqFunc.getText() + "'");
//        }
    }//GEN-LAST:event_jBtPesqCodigoFuncActionPerformed

    private void jBtPesqDatasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqDatasActionPerformed
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
                if (jDataPesFinal.getDate() == null) {
                    JOptionPane.showMessageDialog(rootPane, "Informe a data final para pesquisa.");
                    jDataPesFinal.requestFocus();
                } else {
                    if (jDataPesqInicial.getDate().after(jDataPesFinal.getDate())) {
                        JOptionPane.showMessageDialog(rootPane, "Data Inicial não pode ser maior que data final");
                    } else {
                        SimpleDateFormat formatoAmerica = new SimpleDateFormat("yyyy/MM/dd");
                        dataInicial = formatoAmerica.format(jDataPesqInicial.getDate().getTime());
                        dataFinal = formatoAmerica.format(jDataPesFinal.getDate().getTime());
//                        preencherTodasEntradas("SELECT * FROM COLABORADOR "
//                            + "INNER JOIN DEPARTAMENTOS "
//                            + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
//                            + "INNER JOIN CARGOS "
//                            + "ON COLABORADOR.IdCargo=CARGOS.IdCargo "
//                            + "WHERE DataCadFunc BETWEEN'" + dataInicial + "' "
//                            + "AND '" + dataFinal + "' ");
                    }
                }
            }
        } else if (tipoServidor.equals("Servidor Windows/MS-SQL Server")) {
            if (jDataPesqInicial.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data inicial para pesquisa.");
                jDataPesqInicial.requestFocus();
            } else {
                if (jDataPesFinal.getDate() == null) {
                    JOptionPane.showMessageDialog(rootPane, "Informe a data final para pesquisa.");
                    jDataPesFinal.requestFocus();
                } else {
                    if (jDataPesqInicial.getDate().after(jDataPesFinal.getDate())) {
                        JOptionPane.showMessageDialog(rootPane, "Data Inicial não pode ser maior que data final");
                    } else {
                        SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
                        dataInicial = formatoAmerica.format(jDataPesqInicial.getDate().getTime());
                        dataFinal = formatoAmerica.format(jDataPesFinal.getDate().getTime());
//                        preencherTodasEntradas("SELECT * FROM COLABORADOR "
//                            + "INNER JOIN DEPARTAMENTOS "
//                            + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
//                            + "INNER JOIN CARGOS "
//                            + "ON COLABORADOR.IdCargo=CARGOS.IdCargo "
//                            + "WHERE DataCadFunc BETWEEN'" + dataInicial + "' "
//                            + "AND '" + dataFinal + "' ");
                    }
                }
            }
        }
    }//GEN-LAST:event_jBtPesqDatasActionPerformed

    private void jTabelaFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaFuncionarioMouseClicked
        // TODO add your handling code here:
//        if (flag == 1) {
//            String nomeFunc = "" + jTabelaFuncionario.getValueAt(jTabelaFuncionario.getSelectedRow(), 3);
//            jPesqNome.setText(nomeFunc);
//            // MANUTENÇÃO
//            jBtNovo.setEnabled(true);
//            jBtAlterar.setEnabled(true);
//            jBtExcluir.setEnabled(true);
//            jBtSalvar.setEnabled(!true);
//            jBtCancelar.setEnabled(true);
//            jBtAuditoria.setEnabled(true);
//            jBtBiometria.setEnabled(true);
//            // ENDEREÇO
//            jBtNovoLogradouro.setEnabled(true);
//            jBtAlterarLogradouro.setEnabled(true);
//            jBtExcluirLogradouro.setEnabled(true);
//            jBtSalvarLogradouro.setEnabled(!true);
//            jBtCancelarLogradouro.setEnabled(true);
//            jBtAuditoriaLogradouro.setEnabled(true);
//            jBtImpressaoLogradouro.setEnabled(true);
//            // DOCUMENTOS
//            jBtNovoDocumentos.setEnabled(true);
//            jBtAlterarDocumentos.setEnabled(true);
//            jBtExcluirDocumentos.setEnabled(true);
//            jBtSalvarDocumentos.setEnabled(!true);
//            jBtCancelarDocumentos.setEnabled(true);
//            jBtAuditoriaDocumentos.setEnabled(true);
//            jBtImpressaoDocumentos.setEnabled(true);
//            // DEPENDENTES
//            jBtNovoDependente.setEnabled(true);
//            //
//            limparCamposRegistro();
//            //
//            conecta.abrirConexao();
//            try {
//                conecta.executaSQL("SELECT * FROM COLABORADOR "
//                    + "INNER JOIN DEPARTAMENTOS "
//                    + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
//                    + "INNER JOIN CARGOS "
//                    + "ON COLABORADOR.IdCargo=CARGOS.IdCargo "
//                    + "INNER JOIN ENDERECOS "
//                    + "ON COLABORADOR.IdFunc=ENDERECOS.IdFunc "
//                    + "INNER JOIN DOCUMENTOS "
//                    + "ON COLABORADOR.IdFunc=DOCUMENTOS.IdFunc "
//                    + "WHERE NomeFunc='" + jPesqNome.getText() + "'");
//                conecta.rs.first();
//                jIDFunc.setText(String.valueOf(conecta.rs.getInt("IdFunc")));
//                jComboBoxStatusFunc.setSelectedItem(conecta.rs.getString("StatusFunc"));
//                jDataAdmissao.setDate(conecta.rs.getDate("DataCadFunc"));
//                jNomeFuncionario.setText(conecta.rs.getString("NomeFunc"));
//                jMatricula.setText(conecta.rs.getString("MatriculaFunc"));
//                jComboBoxSexo.setSelectedItem(conecta.rs.getString("SexoFunc"));
//                jComboBoxEscolaridade.setSelectedItem(conecta.rs.getString("EscolaFunc"));
//                jComboBoxEstadoCivil.setSelectedItem(conecta.rs.getString("EstadoCivil"));
//                jDataNascimento.setDate(conecta.rs.getDate("DataNascimento"));
//                // Capturando foto
//                caminhoFotoFunc = conecta.rs.getString("ImagemFunc");
//                if (caminhoFotoFunc != null) {
//                    javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminhoFotoFunc);
//                    jFotoColaborador.setIcon(i);
//                    jFotoColaborador.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoColaborador.getWidth(), jFotoColaborador.getHeight(), Image.SCALE_SMOOTH)));
//                }
//                // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
//                byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrenteCO"));
//                if (imgBytes != null) {
//                    ImageIcon pic = null;
//                    pic = new ImageIcon(imgBytes);
//                    Image scaled = pic.getImage().getScaledInstance(jFotoColaborador.getWidth(), jFotoColaborador.getHeight(), Image.SCALE_SMOOTH);
//                    ImageIcon icon = new ImageIcon(scaled);
//                    jFotoColaborador.setIcon(icon);
//                }
//                jNomeMae.setText(conecta.rs.getString("NomeMae"));
//                jNomePai.setText(conecta.rs.getString("NomePai"));
//                jReligiao.setText(conecta.rs.getString("Religiao"));
//                jTipoSang.setText(conecta.rs.getString("TipoSangue"));
//                jDepartamento.setText(conecta.rs.getString("NomeDepartamento"));
//                jNomeCargo.setText(conecta.rs.getString("NomeCargo"));
//                //
//                jCargaHoraria.setText(conecta.rs.getString("CargaHoraria"));
//                jComboBoxRegimeTrabalho.setSelectedItem(conecta.rs.getString("RegimeTrabalho"));
//                jHorarioInicio.setText(conecta.rs.getString("HorarioInicio"));
//                jHorarioFinal.setText(conecta.rs.getString("HorarioFinal"));
//                jFuncao.setText(conecta.rs.getString("Funcao"));
//                jComboBoxNacionalidade.setSelectedItem(conecta.rs.getString("Nacionalidade"));
//                jPais.setText(conecta.rs.getString("Pais"));
//                jNaturalidade.setText(conecta.rs.getString("Naturalidade"));
//                jComboBoxEstadoNaturalidade.setSelectedItem(conecta.rs.getString("EstadoNaturalidade"));
//                // ENDEREÇO
//                codEnd = conecta.rs.getInt("IdEnd");
//                jEndereco.setText(conecta.rs.getString("Endereco"));
//                jBairro.setText(conecta.rs.getString("BairroEnd"));
//                jComplemento.setText(conecta.rs.getString("CompEnd"));
//                jCidade.setText(conecta.rs.getString("CidadeEnd"));
//                jComboBoxEstado.setSelectedItem(conecta.rs.getString("UfEnd"));
//                jCep.setText(conecta.rs.getString("CepEnd"));
//                // CONTATO
//                jEmail.setText(conecta.rs.getString("EmailEnd"));
//                jTelefone.setText(conecta.rs.getString("FoneEnd"));
//                jTelefoneEnd.setText(conecta.rs.getString("TelEnd"));
//                jCelularEnd.setText(conecta.rs.getString("CelEnd"));
//                jURL.setText(conecta.rs.getString("Url"));
//                jObservacao.setText(conecta.rs.getString("Observacao"));
//                // DOCUMENTOS
//                codDoc = conecta.rs.getInt("IdDoc");
//                jRG.setText(conecta.rs.getString("RgDoc"));
//                jCPF.setText(conecta.rs.getString("CpfDoc"));
//                jDataEmissaoRg.setDate(conecta.rs.getDate("DataEmissaoDoc"));
//                jOrgaoEmissor.setText(conecta.rs.getString("OrgaoDoc"));
//                jComboBoxEstadoOrgao.setSelectedItem(conecta.rs.getString("EstadoOrg"));
//                jPis.setText(conecta.rs.getString("PisDoc"));
//                jDataCadPis.setDate(conecta.rs.getDate("DataCadPisDoc"));
//                jTitulo.setText(conecta.rs.getString("TituloDoc"));
//                jZona.setText(conecta.rs.getString("ZonaDoc"));
//                jSecao.setText(conecta.rs.getString("SecaoDoc"));
//                jCTPS.setText(conecta.rs.getString("CtpsDoc"));
//                jSerie.setText(conecta.rs.getString("SerieDoc"));
//                jHabilita.setText(conecta.rs.getString("HabiliDoc"));
//                jReservista.setText(conecta.rs.getString("ReservistaDoc"));
//                jCategoria.setText(conecta.rs.getString("CateDoc"));
//                jCartaoSaude.setText(conecta.rs.getString("CartSaudeDoc"));
//                jProfissao.setText(conecta.rs.getString("ProfDoc"));
//                jAltura.setText(conecta.rs.getString("AlturaDoc"));
//                jCalca.setText(conecta.rs.getString("CalcaDoc"));
//                jSapato.setText(conecta.rs.getString("SapatoDoc"));
//                jPeso.setText(conecta.rs.getString("PesoDoc"));
//                jCamisa.setText(conecta.rs.getString("CamisaDoc"));
//                jCarteiraconselho.setText(conecta.rs.getString("CarteiraDoc"));
//                // CONJUGUE
//                jComboBoxTipoConjugue.setSelectedItem(conecta.rs.getString("TipoConjugue"));
//                jDataNasConjugue.setDate(conecta.rs.getDate("DataNasConjugue"));
//                jNomeConjugue.setText(conecta.rs.getString("NomeConjugue"));
//            } catch (SQLException e) {
//                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa dos dados." + e);
//            }
//            conecta.desconecta();
//        }
    }//GEN-LAST:event_jTabelaFuncionarioMouseClicked

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:  
        buscarAcessoUsuario(telaAtividadeMensalManu_ADM);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoADM.equals("ADMINISTRADORES") || codigoUserADM == codUserAcessoADM && nomeTelaADM.equals(telaAtividadeMensalManu_ADM) && codIncluirADM == 1) {
            TelaPesqColaboradorAtividadeMensal objPesFunc = new TelaPesqColaboradorAtividadeMensal();
            TelaModuloAdmPessoal.jPainelAdmPessoal.add(objPesFunc);
            objPesFunc.show();
            acao = 1;
            pesquisaUnidadePrisional();
            pesquisarPopulacaoAtual();
            bloquearHabilitarTodosCampos(true, !true);
            Novo();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtAlterarActionPerformed

    private void jBtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtSalvarActionPerformed

    private void jBtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarActionPerformed
        // TODO add your handling code here:
        Cancelar();
    }//GEN-LAST:event_jBtCancelarActionPerformed

    private void jBtFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFinalizarActionPerformed
        // TODO add your handling code here:
        if (jChave.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Não existe registro a ser finalizado.");
        } else {

        }
    }//GEN-LAST:event_jBtFinalizarActionPerformed

    private void jBtImpressaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImpressaoActionPerformed
        // TODO add your handling code here:
        if (jChave.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Não existe registro a ser impresso..");
        } else {

        }
    }//GEN-LAST:event_jBtImpressaoActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtAuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtAuditoriaActionPerformed

    private void jBtPesquisarColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisarColaboradorActionPerformed
        // TODO add your handling code here:
        TelaPesqColaboradorAtividadeMensal objPesFunc = new TelaPesqColaboradorAtividadeMensal();
        TelaModuloAdmPessoal.jPainelAdmPessoal.add(objPesFunc);
        objPesFunc.show();
    }//GEN-LAST:event_jBtPesquisarColaboradorActionPerformed

    private void jBtPesqMesAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqMesAnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtPesqMesAnoActionPerformed

    private void jBtNovo10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovo10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtNovo10ActionPerformed

    private void jBtAlterar10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterar10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtAlterar10ActionPerformed

    private void jBtExcluir10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluir10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtExcluir10ActionPerformed

    private void jBtSalvar10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvar10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtSalvar10ActionPerformed

    private void jBtCancelar10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelar10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtCancelar10ActionPerformed

    private void jBtFinalizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFinalizar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtFinalizar1ActionPerformed

    private void jBtSair10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSair10ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSair10ActionPerformed

    private void jBtAuditoria10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoria10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtAuditoria10ActionPerformed

    private void jBtImpressao3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImpressao3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtImpressao3ActionPerformed

    private void jBtNovo11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovo11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtNovo11ActionPerformed

    private void jBtAlterar11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterar11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtAlterar11ActionPerformed

    private void jBtExcluir11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluir11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtExcluir11ActionPerformed

    private void jBtSalvar11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvar11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtSalvar11ActionPerformed

    private void jBtCancelar11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelar11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtCancelar11ActionPerformed

    private void jBtFinalizar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFinalizar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtFinalizar2ActionPerformed

    private void jBtSair11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSair11ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSair11ActionPerformed

    private void jBtAuditoria11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoria11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtAuditoria11ActionPerformed

    private void jBtImpressao4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImpressao4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtImpressao4ActionPerformed

    private void jBtNovo12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovo12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtNovo12ActionPerformed

    private void jBtAlterar12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterar12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtAlterar12ActionPerformed

    private void jBtExcluir12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluir12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtExcluir12ActionPerformed

    private void jBtSalvar12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvar12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtSalvar12ActionPerformed

    private void jBtCancelar12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelar12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtCancelar12ActionPerformed

    private void jBtFinalizar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFinalizar3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtFinalizar3ActionPerformed

    private void jBtSair12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSair12ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSair12ActionPerformed

    private void jBtAuditoria12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoria12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtAuditoria12ActionPerformed

    private void jBtImpressao5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImpressao5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtImpressao5ActionPerformed

    private void jBtNovo13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovo13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtNovo13ActionPerformed

    private void jBtAlterar13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterar13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtAlterar13ActionPerformed

    private void jBtExcluir13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluir13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtExcluir13ActionPerformed

    private void jBtSalvar13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvar13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtSalvar13ActionPerformed

    private void jBtCancelar13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelar13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtCancelar13ActionPerformed

    private void jBtFinalizar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFinalizar4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtFinalizar4ActionPerformed

    private void jBtSair13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSair13ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSair13ActionPerformed

    private void jBtAuditoria13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoria13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtAuditoria13ActionPerformed

    private void jBtImpressao6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImpressao6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtImpressao6ActionPerformed

    private void jBtNovo14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovo14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtNovo14ActionPerformed

    private void jBtAlterar14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterar14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtAlterar14ActionPerformed

    private void jBtExcluir14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluir14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtExcluir14ActionPerformed

    private void jBtSalvar14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvar14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtSalvar14ActionPerformed

    private void jBtCancelar14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelar14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtCancelar14ActionPerformed

    private void jBtFinalizar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFinalizar5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtFinalizar5ActionPerformed

    private void jBtSair14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSair14ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSair14ActionPerformed

    private void jBtAuditoria14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoria14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtAuditoria14ActionPerformed

    private void jBtImpressao7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImpressao7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtImpressao7ActionPerformed

    private void jBtNovo15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovo15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtNovo15ActionPerformed

    private void jBtAlterar15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterar15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtAlterar15ActionPerformed

    private void jBtExcluir15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluir15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtExcluir15ActionPerformed

    private void jBtSalvar15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvar15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtSalvar15ActionPerformed

    private void jBtCancelar15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelar15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtCancelar15ActionPerformed

    private void jBtFinalizar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFinalizar6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtFinalizar6ActionPerformed

    private void jBtSair15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSair15ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSair15ActionPerformed

    private void jBtAuditoria15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoria15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtAuditoria15ActionPerformed

    private void jBtImpressao8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImpressao8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtImpressao8ActionPerformed

    private void jBtNovo16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovo16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtNovo16ActionPerformed

    private void jBtAlterar16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterar16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtAlterar16ActionPerformed

    private void jBtExcluir16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluir16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtExcluir16ActionPerformed

    private void jBtSalvar16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvar16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtSalvar16ActionPerformed

    private void jBtCancelar16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelar16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtCancelar16ActionPerformed

    private void jBtFinalizar7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFinalizar7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtFinalizar7ActionPerformed

    private void jBtSair16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSair16ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSair16ActionPerformed

    private void jBtAuditoria16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoria16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtAuditoria16ActionPerformed

    private void jBtImpressao9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImpressao9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtImpressao9ActionPerformed

    private void jBtNovo17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovo17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtNovo17ActionPerformed

    private void jBtAlterar17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterar17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtAlterar17ActionPerformed

    private void jBtExcluir17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluir17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtExcluir17ActionPerformed

    private void jBtSalvar17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvar17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtSalvar17ActionPerformed

    private void jBtCancelar17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelar17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtCancelar17ActionPerformed

    private void jBtFinalizar8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFinalizar8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtFinalizar8ActionPerformed

    private void jBtSair17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSair17ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSair17ActionPerformed

    private void jBtAuditoria17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoria17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtAuditoria17ActionPerformed

    private void jBtImpressao10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImpressao10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtImpressao10ActionPerformed

    private void jBtNovo18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovo18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtNovo18ActionPerformed

    private void jBtAlterar18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterar18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtAlterar18ActionPerformed

    private void jBtExcluir18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluir18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtExcluir18ActionPerformed

    private void jBtSalvar18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvar18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtSalvar18ActionPerformed

    private void jBtCancelar18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelar18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtCancelar18ActionPerformed

    private void jBtFinalizar9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFinalizar9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtFinalizar9ActionPerformed

    private void jBtSair18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSair18ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSair18ActionPerformed

    private void jBtAuditoria18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoria18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtAuditoria18ActionPerformed

    private void jBtImpressao11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImpressao11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtImpressao11ActionPerformed

    private void jBtPesquisarDatasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisarDatasActionPerformed
        // TODO add your handling code here:
        DecimalFormat valorReal = new DecimalFormat("###,##00.0");
        valorReal.setCurrency(Currency.getInstance(new Locale("pt", "BR")));
        //ABA ASSI - SERVIÇO SOCIAL
        calculoSS();
        calculoSSF();
        calculoVI();
        caluloVC();
        caluloQTVD();
        //CALCUAR AS MÉDIAS
        pMEDIA_VISITAS_POR_DIA = (pQUANTIDADE_VISITA_FAMILIA_INT / pQUANTIDADE_DIAS_VISITADOS);
        jMediaVisitasDia.setText(String.valueOf(pMEDIA_VISITAS_POR_DIA));
        //ABA ASI
        calculoMED();
        calculoPSIQ();
        calculoENFER();

        calculoPSI();
        calculoProcODON();
        calculoAtendODON();
        calculoMatPED();
        calculoFreqPED();
        calculoCelularSEG();
        calcularObjetos();
        calcularQtdRevistaCela();
        calcularQtdRevistaCela();
    }//GEN-LAST:event_jBtPesquisarDatasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField PresoAtiviArtesPlasticas;
    private javax.swing.JFormattedTextField jAbsorvente;
    private javax.swing.JFormattedTextField jAlimentaServidaEmpContAlmoco;
    private javax.swing.JFormattedTextField jAlimentaServidaEmpContCafe;
    private javax.swing.JFormattedTextField jAlimentaServidaEmpContJantar;
    private javax.swing.JFormattedTextField jAlimentaServidaEmpContLanche;
    private javax.swing.JFormattedTextField jAlimentaServidaInternoAlmoco;
    private javax.swing.JFormattedTextField jAlimentaServidaInternoCafe;
    private javax.swing.JFormattedTextField jAlimentaServidaInternoJantar;
    private javax.swing.JFormattedTextField jAlimentaServidaServContAlmoco;
    private javax.swing.JFormattedTextField jAlimentaServidaServContCafe;
    private javax.swing.JFormattedTextField jAlimentaServidaServContJantar;
    private javax.swing.JFormattedTextField jAlimentaServidaServContLanche;
    private javax.swing.JFormattedTextField jAlvarSolRecebeUni;
    private javax.swing.JFormattedTextField jAlvaraSolturaCumprido;
    private javax.swing.JFormattedTextField jAparelhoBarbear;
    private javax.swing.JFormattedTextField jAspectosSexual;
    private javax.swing.JFormattedTextField jAtendInternoSAJ;
    private javax.swing.JFormattedTextField jAtendimentoEnfermagem;
    private javax.swing.JFormattedTextField jAtendimentoMedClinico;
    private javax.swing.JFormattedTextField jAtendimentoMedPsi;
    private javax.swing.JFormattedTextField jAtendimentoOdontologicos;
    private javax.swing.JFormattedTextField jAtendimentoPsiFamilaPreso;
    private javax.swing.JFormattedTextField jAtendimentoPsiPreso;
    private javax.swing.JFormattedTextField jAtendimentoPsicologico;
    private javax.swing.JFormattedTextField jAudienciaCumpridas;
    private javax.swing.JFormattedTextField jAudienciaProvocadas;
    private javax.swing.JFormattedTextField jBermuda;
    private javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtAlterar10;
    private javax.swing.JButton jBtAlterar11;
    private javax.swing.JButton jBtAlterar12;
    private javax.swing.JButton jBtAlterar13;
    private javax.swing.JButton jBtAlterar14;
    private javax.swing.JButton jBtAlterar15;
    private javax.swing.JButton jBtAlterar16;
    private javax.swing.JButton jBtAlterar17;
    private javax.swing.JButton jBtAlterar18;
    private javax.swing.JButton jBtAuditoria;
    private javax.swing.JButton jBtAuditoria10;
    private javax.swing.JButton jBtAuditoria11;
    private javax.swing.JButton jBtAuditoria12;
    private javax.swing.JButton jBtAuditoria13;
    private javax.swing.JButton jBtAuditoria14;
    private javax.swing.JButton jBtAuditoria15;
    private javax.swing.JButton jBtAuditoria16;
    private javax.swing.JButton jBtAuditoria17;
    private javax.swing.JButton jBtAuditoria18;
    private javax.swing.JButton jBtCalcularTotais;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtCancelar10;
    private javax.swing.JButton jBtCancelar11;
    private javax.swing.JButton jBtCancelar12;
    private javax.swing.JButton jBtCancelar13;
    private javax.swing.JButton jBtCancelar14;
    private javax.swing.JButton jBtCancelar15;
    private javax.swing.JButton jBtCancelar16;
    private javax.swing.JButton jBtCancelar17;
    private javax.swing.JButton jBtCancelar18;
    private javax.swing.JButton jBtExcluir;
    private javax.swing.JButton jBtExcluir10;
    private javax.swing.JButton jBtExcluir11;
    private javax.swing.JButton jBtExcluir12;
    private javax.swing.JButton jBtExcluir13;
    private javax.swing.JButton jBtExcluir14;
    private javax.swing.JButton jBtExcluir15;
    private javax.swing.JButton jBtExcluir16;
    private javax.swing.JButton jBtExcluir17;
    private javax.swing.JButton jBtExcluir18;
    private javax.swing.JButton jBtFinalizar;
    private javax.swing.JButton jBtFinalizar1;
    private javax.swing.JButton jBtFinalizar2;
    private javax.swing.JButton jBtFinalizar3;
    private javax.swing.JButton jBtFinalizar4;
    private javax.swing.JButton jBtFinalizar5;
    private javax.swing.JButton jBtFinalizar6;
    private javax.swing.JButton jBtFinalizar7;
    private javax.swing.JButton jBtFinalizar8;
    private javax.swing.JButton jBtFinalizar9;
    private javax.swing.JButton jBtImpressao;
    private javax.swing.JButton jBtImpressao10;
    private javax.swing.JButton jBtImpressao11;
    private javax.swing.JButton jBtImpressao3;
    private javax.swing.JButton jBtImpressao4;
    private javax.swing.JButton jBtImpressao5;
    private javax.swing.JButton jBtImpressao6;
    private javax.swing.JButton jBtImpressao7;
    private javax.swing.JButton jBtImpressao8;
    private javax.swing.JButton jBtImpressao9;
    private javax.swing.JButton jBtNovo;
    private javax.swing.JButton jBtNovo10;
    private javax.swing.JButton jBtNovo11;
    private javax.swing.JButton jBtNovo12;
    private javax.swing.JButton jBtNovo13;
    private javax.swing.JButton jBtNovo14;
    private javax.swing.JButton jBtNovo15;
    private javax.swing.JButton jBtNovo16;
    private javax.swing.JButton jBtNovo17;
    private javax.swing.JButton jBtNovo18;
    private javax.swing.JButton jBtPesqCodigoFunc;
    private javax.swing.JButton jBtPesqDatas;
    private javax.swing.JButton jBtPesqMesAno;
    private javax.swing.JButton jBtPesqNome;
    private javax.swing.JButton jBtPesquisarColaborador;
    private javax.swing.JButton jBtPesquisarDatas;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSair10;
    private javax.swing.JButton jBtSair11;
    private javax.swing.JButton jBtSair12;
    private javax.swing.JButton jBtSair13;
    private javax.swing.JButton jBtSair14;
    private javax.swing.JButton jBtSair15;
    private javax.swing.JButton jBtSair16;
    private javax.swing.JButton jBtSair17;
    private javax.swing.JButton jBtSair18;
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JButton jBtSalvar10;
    private javax.swing.JButton jBtSalvar11;
    private javax.swing.JButton jBtSalvar12;
    private javax.swing.JButton jBtSalvar13;
    private javax.swing.JButton jBtSalvar14;
    private javax.swing.JButton jBtSalvar15;
    private javax.swing.JButton jBtSalvar16;
    private javax.swing.JButton jBtSalvar17;
    private javax.swing.JButton jBtSalvar18;
    private javax.swing.JFormattedTextField jCamisa;
    private javax.swing.JFormattedTextField jCaneca;
    public static javax.swing.JTextField jChave;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JFormattedTextField jChinelos;
    private javax.swing.JFormattedTextField jCobertor;
    private javax.swing.JTextField jCodigoPesqFunc;
    public static javax.swing.JTextField jColaboradorResponsavel;
    private javax.swing.JFormattedTextField jColchao;
    private javax.swing.JComboBox<String> jComboBoxAno1;
    private javax.swing.JComboBox<String> jComboBoxMes1;
    private javax.swing.JFormattedTextField jCondicionalRequerida;
    private javax.swing.JFormattedTextField jControlHipertensao;
    private javax.swing.JFormattedTextField jControleDiabetes;
    private javax.swing.JFormattedTextField jCremeDental;
    private javax.swing.JFormattedTextField jCuecas;
    private com.toedter.calendar.JDateChooser jDataAtualizacao;
    private com.toedter.calendar.JDateChooser jDataCriacao;
    public static com.toedter.calendar.JDateChooser jDataPeriodoFinal;
    public static com.toedter.calendar.JDateChooser jDataPeriodoInicial;
    private com.toedter.calendar.JDateChooser jDataPesFinal;
    private com.toedter.calendar.JDateChooser jDataPesqInicial;
    public static javax.swing.JTextField jDepartamento;
    private javax.swing.JFormattedTextField jDesodorante;
    private javax.swing.JFormattedTextField jEscovaDente;
    private javax.swing.JFormattedTextField jHabeasCorpusDeferido;
    private javax.swing.JFormattedTextField jHabeasCorpusImpetrados;
    public static javax.swing.JTextField jIdFunc;
    private javax.swing.JFormattedTextField jIndultosDeferidos;
    private javax.swing.JFormattedTextField jIndultosRequeridos;
    private javax.swing.JFormattedTextField jJuriPopular;
    private javax.swing.JFormattedTextField jJuriPopularCumprido;
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
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel154;
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
    private javax.swing.JFormattedTextField jLanchesServidoVisita;
    private javax.swing.JFormattedTextField jLaudoPsicoEmitidos;
    private javax.swing.JFormattedTextField jLaudosPsiqEmitidos;
    private javax.swing.JFormattedTextField jLencol;
    private javax.swing.JFormattedTextField jLiberdadeProvDeferida;
    private javax.swing.JFormattedTextField jLiberdadeProvRequerida;
    private javax.swing.JFormattedTextField jLivarmentoCondRequerido;
    public static javax.swing.JTextField jMatricula;
    private javax.swing.JFormattedTextField jMediaVisitasDia;
    private javax.swing.JFormattedTextField jMediaVisitasInterno;
    private javax.swing.JFormattedTextField jNumeroAbsorEntregueVisitas;
    private javax.swing.JFormattedTextField jNumeroAparelhoConvive;
    private javax.swing.JFormattedTextField jNumeroCriancasVisitas;
    private javax.swing.JFormattedTextField jNumeroDiasIntMetaPortatil;
    private javax.swing.JFormattedTextField jNumeroDiasSemScannerCorpo;
    private javax.swing.JFormattedTextField jNumeroDiasVisitas;
    private javax.swing.JFormattedTextField jNumeroFalhasGerador;
    private javax.swing.JFormattedTextField jNumeroFraldasEntreguePortaria;
    private javax.swing.JFormattedTextField jNumeroHorasBloqueador;
    private javax.swing.JFormattedTextField jNumeroHorasTVCFTV;
    private javax.swing.JFormattedTextField jNumeroOcorrenciaPessoaFerida;
    private javax.swing.JFormattedTextField jNumeroOcorrenciaPessoasFerida;
    private javax.swing.JFormattedTextField jNumeroOcorrenciaPessoasRefem;
    private javax.swing.JFormattedTextField jNumeroOcorrenciaRebeliao;
    private javax.swing.JFormattedTextField jNumeroOcorrenciaTentaFuga;
    private javax.swing.JFormattedTextField jNumeroOcorrenciasInd;
    private javax.swing.JFormattedTextField jNumeroProcedRevista;
    private javax.swing.JFormattedTextField jNumeroVistantesInternos;
    private javax.swing.JFormattedTextField jObjetosMateriais;
    private javax.swing.JTextArea jObservacao;
    private javax.swing.JFormattedTextField jOcupacaoAtiviRecreaReligiosa;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
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
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
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
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel64;
    private javax.swing.JPanel jPanel65;
    private javax.swing.JPanel jPanel66;
    private javax.swing.JPanel jPanel67;
    private javax.swing.JPanel jPanel68;
    private javax.swing.JPanel jPanel69;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel70;
    private javax.swing.JPanel jPanel71;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JFormattedTextField jPapelHigienico;
    private javax.swing.JTextField jPesqNome;
    public static javax.swing.JTextField jPopulacaoAtual;
    private javax.swing.JFormattedTextField jPote;
    private javax.swing.JFormattedTextField jPresoAtiviCantoTeatro;
    private javax.swing.JFormattedTextField jPresoAtiviLaboralNaoRemunera;
    private javax.swing.JFormattedTextField jPresoAtiviLiteraria;
    private javax.swing.JFormattedTextField jPresoAtiviPraticaEsportiva;
    private javax.swing.JFormattedTextField jPresoAtiviReligiosa;
    private javax.swing.JFormattedTextField jPresoCertificaCursoProf;
    private javax.swing.JFormattedTextField jPresoDoencaInfecto;
    private javax.swing.JFormattedTextField jPresoIdentCivil;
    private javax.swing.JFormattedTextField jPresoMatProfissional;
    private javax.swing.JFormattedTextField jPresoSentecaAtivLaboralRemun;
    private javax.swing.JFormattedTextField jPresoSentencaMatFreqEF;
    private javax.swing.JFormattedTextField jPresoSentenciadoEF;
    private javax.swing.JFormattedTextField jPresosVacinados;
    private javax.swing.JFormattedTextField jProcedimentoOdontologico;
    private javax.swing.JFormattedTextField jProgressaoRegDeferido;
    private javax.swing.JFormattedTextField jProgressaoRegRequerido;
    private javax.swing.JFormattedTextField jRemissaoPenaDeferida;
    private javax.swing.JFormattedTextField jRemissaoPenaRequerida;
    private javax.swing.JFormattedTextField jSabaoPo;
    private javax.swing.JFormattedTextField jSabonete;
    private javax.swing.JFormattedTextField jSaidaTempRequerida;
    private javax.swing.JFormattedTextField jSaidasTempDeferida;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jStatus;
    private javax.swing.JFormattedTextField jTP;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTabelaFuncionario;
    private javax.swing.JFormattedTextField jToalha;
    private javax.swing.JFormattedTextField jTotal01;
    private javax.swing.JFormattedTextField jTotal02;
    private javax.swing.JFormattedTextField jTotal03;
    private javax.swing.JFormattedTextField jTotal04;
    private javax.swing.JFormattedTextField jTotal05;
    private javax.swing.JFormattedTextField jTotal06;
    private javax.swing.JFormattedTextField jTotal07;
    private javax.swing.JFormattedTextField jTotal08;
    private javax.swing.JFormattedTextField jTotal09;
    private javax.swing.JFormattedTextField jTratamentoAgravDiaginostico;
    private javax.swing.JFormattedTextField jTriagemAtendInernos;
    private javax.swing.JFormattedTextField jUmeroInterFuncVeiculosTP;
    public static javax.swing.JTextField jUnidadePrisional;
    private javax.swing.JFormattedTextField jUniformeCompleto;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void corCampos() {
        //ABA MANUTENÇÃO
        jChave.setBackground(Color.white);
        jStatus.setBackground(Color.white);
        jDataCriacao.setBackground(Color.white);
        jDataAtualizacao.setBackground(Color.white);
        jUnidadePrisional.setBackground(Color.white);
        jPopulacaoAtual.setBackground(Color.white);
        jDataPeriodoInicial.setBackground(Color.white);
        jDataPeriodoFinal.setBackground(Color.white);
        jIdFunc.setBackground(Color.white);
        jColaboradorResponsavel.setBackground(Color.white);
        jMatricula.setBackground(Color.white);
        jDepartamento.setBackground(Color.white);
        jObservacao.setBackground(Color.white);
        //ABA ASSI        
        jAtendimentoPsiPreso.setBackground(Color.white);
        jAtendimentoPsiFamilaPreso.setBackground(Color.white);
        jNumeroDiasVisitas.setBackground(Color.white);
        jNumeroVistantesInternos.setBackground(Color.white);
        jMediaVisitasDia.setBackground(Color.white);
        jMediaVisitasInterno.setBackground(Color.white);
        jNumeroCriancasVisitas.setBackground(Color.white);
        jPresoIdentCivil.setBackground(Color.white);
        jPresoAtiviReligiosa.setBackground(Color.white);
        //ABA AFV
        jLanchesServidoVisita.setBackground(Color.white);
        jAlimentaServidaEmpContCafe.setBackground(Color.white);
        jAlimentaServidaEmpContAlmoco.setBackground(Color.white);
        jAlimentaServidaEmpContJantar.setBackground(Color.white);
        jAlimentaServidaEmpContLanche.setBackground(Color.white);
        jAlimentaServidaServContCafe.setBackground(Color.white);
        jAlimentaServidaServContAlmoco.setBackground(Color.white);
        jAlimentaServidaServContJantar.setBackground(Color.white);
        jAlimentaServidaServContLanche.setBackground(Color.white);
        //ASI
        jAtendimentoMedClinico.setBackground(Color.white);
        jAtendimentoMedPsi.setBackground(Color.white);
        jAtendimentoEnfermagem.setBackground(Color.white);
        jProcedimentoOdontologico.setBackground(Color.white);
        jAtendimentoPsicologico.setBackground(Color.white);
        jTratamentoAgravDiaginostico.setBackground(Color.white);
        jAtendimentoOdontologicos.setBackground(Color.white);
        jPresoDoencaInfecto.setBackground(Color.white);
        jControlHipertensao.setBackground(Color.white);
        jControleDiabetes.setBackground(Color.white);
        jAspectosSexual.setBackground(Color.white);
        jPresosVacinados.setBackground(Color.white);
        //ABA AEI
        jPresoSentenciadoEF.setBackground(Color.white);
        jPresoSentencaMatFreqEF.setBackground(Color.white);
        jPresoAtiviPraticaEsportiva.setBackground(Color.white);
        //ABA AMI
        jCobertor.setBackground(Color.white);
        jColchao.setBackground(Color.white);
        jLencol.setBackground(Color.white);
        jToalha.setBackground(Color.white);
        jPote.setBackground(Color.white);
        jCaneca.setBackground(Color.white);
        jAparelhoBarbear.setBackground(Color.white);
        jCremeDental.setBackground(Color.white);
        jEscovaDente.setBackground(Color.white);
        jAbsorvente.setBackground(Color.white);
        jPapelHigienico.setBackground(Color.white);
        jSabaoPo.setBackground(Color.white);
        jSabonete.setBackground(Color.white);
        jDesodorante.setBackground(Color.white);
        jBermuda.setBackground(Color.white);
        jCamisa.setBackground(Color.white);
        jCuecas.setBackground(Color.white);
        jChinelos.setBackground(Color.white);
        jUniformeCompleto.setBackground(Color.white);
        //ABA SEG
        jNumeroAparelhoConvive.setBackground(Color.white);
        jObjetosMateriais.setBackground(Color.white);
        jNumeroProcedRevista.setBackground(Color.white);
        jNumeroOcorrenciasInd.setBackground(Color.white);
        jNumeroOcorrenciaTentaFuga.setBackground(Color.white);
        jNumeroOcorrenciaRebeliao.setBackground(Color.white);
        jNumeroOcorrenciaPessoaFerida.setBackground(Color.white);
        jNumeroOcorrenciaPessoasRefem.setBackground(Color.white);
        jNumeroOcorrenciaPessoasFerida.setBackground(Color.white);
        jNumeroHorasTVCFTV.setBackground(Color.white);
        jNumeroDiasSemScannerCorpo.setBackground(Color.white);
        jNumeroDiasIntMetaPortatil.setBackground(Color.white);
        jUmeroInterFuncVeiculosTP.setBackground(Color.white);
        jNumeroFalhasGerador.setBackground(Color.white);
        jNumeroHorasBloqueador.setBackground(Color.white);
        jNumeroAbsorEntregueVisitas.setBackground(Color.white);
        jNumeroFraldasEntreguePortaria.setBackground(Color.white);
        //ABA AJ
        jAtendInternoSAJ.setBackground(Color.white);
        jAlvaraSolturaCumprido.setBackground(Color.white);
        jLivarmentoCondRequerido.setBackground(Color.white);
        jProgressaoRegDeferido.setBackground(Color.white);
        jSaidasTempDeferida.setBackground(Color.white);
        jAlvarSolRecebeUni.setBackground(Color.white);
        jAudienciaProvocadas.setBackground(Color.white);
        jAudienciaCumpridas.setBackground(Color.white);
        jJuriPopular.setBackground(Color.white);
        jJuriPopularCumprido.setBackground(Color.white);
        jLiberdadeProvRequerida.setBackground(Color.white);
        jLiberdadeProvDeferida.setBackground(Color.white);
        jIndultosRequeridos.setBackground(Color.white);
        jIndultosDeferidos.setBackground(Color.white);
        jRemissaoPenaRequerida.setBackground(Color.white);
        jRemissaoPenaDeferida.setBackground(Color.white);
        jCondicionalRequerida.setBackground(Color.white);
        jProgressaoRegRequerido.setBackground(Color.white);
        jSaidaTempRequerida.setBackground(Color.white);
        jHabeasCorpusImpetrados.setBackground(Color.white);
        jHabeasCorpusDeferido.setBackground(Color.white);
        jLaudoPsicoEmitidos.setBackground(Color.white);
        jLaudosPsiqEmitidos.setBackground(Color.white);
        jTP.setBackground(Color.white);
        //ABA AL
        jTriagemAtendInernos.setBackground(Color.white);
        jOcupacaoAtiviRecreaReligiosa.setBackground(Color.white);
        PresoAtiviArtesPlasticas.setBackground(Color.white);
        jPresoAtiviLiteraria.setBackground(Color.white);
        jPresoAtiviCantoTeatro.setBackground(Color.white);
        jPresoMatProfissional.setBackground(Color.white);
        jPresoCertificaCursoProf.setBackground(Color.white);
        jPresoSentecaAtivLaboralRemun.setBackground(Color.white);
        jPresoAtiviLaboralNaoRemunera.setBackground(Color.white);
        //ABA AFI
        jAlimentaServidaInternoCafe.setBackground(Color.white);
        jAlimentaServidaInternoAlmoco.setBackground(Color.white);
        jAlimentaServidaInternoJantar.setBackground(Color.white);
        //ABA TOT
        jTotal01.setBackground(Color.white);
        jTotal02.setBackground(Color.white);
        jTotal03.setBackground(Color.white);
        jTotal04.setBackground(Color.white);
        jTotal05.setBackground(Color.white);
        jTotal06.setBackground(Color.white);
        jTotal07.setBackground(Color.white);
        jTotal08.setBackground(Color.white);
        jTotal09.setBackground(Color.white);
    }

    public void formatarCampos() {

    }

    public void bloquearDesbloquearBotoes(boolean opcao) {
        jBtNovo.setEnabled(opcao);
        jBtAlterar.setEnabled(opcao);
        jBtExcluir.setEnabled(opcao);
        jBtSalvar.setEnabled(opcao);
        jBtCancelar.setEnabled(opcao);
        jBtAuditoria.setEnabled(opcao);
        jBtPesquisarDatas.setEnabled(opcao);
        jBtPesquisarColaborador.setEnabled(opcao);
    }

    public void bloquearHabilitarTodosCampos(boolean opcaoV, boolean opcaoF) {
        //ABA MANUTENÇÃO
        jChave.setEnabled(opcaoF);
        jStatus.setEnabled(opcaoF);
        jDataCriacao.setEnabled(opcaoF);
        jDataAtualizacao.setEnabled(opcaoF);
        jUnidadePrisional.setEnabled(opcaoF);
        jPopulacaoAtual.setEnabled(opcaoF);
        jDataPeriodoInicial.setEnabled(opcaoV);
        jDataPeriodoFinal.setEnabled(opcaoV);
        jIdFunc.setEnabled(opcaoF);
        jColaboradorResponsavel.setEnabled(opcaoF);
        jMatricula.setEnabled(opcaoF);
        jDepartamento.setEnabled(opcaoF);
        jObservacao.setEnabled(opcaoV);
        //ABA ASSI
        jAtendimentoPsiPreso.setEnabled(opcaoF);
        jAtendimentoPsiFamilaPreso.setEnabled(opcaoF);
        jNumeroDiasVisitas.setEnabled(opcaoF);
        jNumeroVistantesInternos.setEnabled(opcaoF);
        jMediaVisitasDia.setEnabled(opcaoF);
        jMediaVisitasInterno.setEnabled(opcaoF);
        jNumeroCriancasVisitas.setEnabled(opcaoF);
        jPresoIdentCivil.setEnabled(opcaoV);
        jPresoAtiviReligiosa.setEnabled(opcaoV);
        //ABA AFV
        jLanchesServidoVisita.setEnabled(opcaoV);
        jAlimentaServidaEmpContCafe.setEnabled(opcaoV);
        jAlimentaServidaEmpContAlmoco.setEnabled(opcaoV);
        jAlimentaServidaEmpContJantar.setEnabled(opcaoV);
        jAlimentaServidaEmpContLanche.setEnabled(opcaoV);
        jAlimentaServidaServContCafe.setEnabled(opcaoV);
        jAlimentaServidaServContAlmoco.setEnabled(opcaoV);
        jAlimentaServidaServContJantar.setEnabled(opcaoV);
        jAlimentaServidaServContLanche.setEnabled(opcaoV);
        //ASI
        jAtendimentoMedClinico.setEnabled(opcaoF);
        jAtendimentoMedPsi.setEnabled(opcaoF);
        jAtendimentoEnfermagem.setEnabled(opcaoF);
        jProcedimentoOdontologico.setEnabled(opcaoF);
        jAtendimentoPsicologico.setEnabled(opcaoF);
        jTratamentoAgravDiaginostico.setEnabled(opcaoF);
        jAtendimentoOdontologicos.setEnabled(opcaoF);
        jPresoDoencaInfecto.setEnabled(opcaoF);
        jControlHipertensao.setEnabled(opcaoF);
        jControleDiabetes.setEnabled(opcaoF);
        jAspectosSexual.setEnabled(opcaoF);
        jPresosVacinados.setEnabled(opcaoF);
        //ABA AEI
        jPresoSentenciadoEF.setEnabled(opcaoF);
        jPresoSentencaMatFreqEF.setEnabled(opcaoF);
        jPresoAtiviPraticaEsportiva.setEnabled(opcaoV);
        //ABA AMI
        jCobertor.setEnabled(opcaoF);
        jColchao.setEnabled(opcaoF);
        jLencol.setEnabled(opcaoF);
        jToalha.setEnabled(opcaoF);
        jPote.setEnabled(opcaoF);
        jCaneca.setEnabled(opcaoF);
        jAparelhoBarbear.setEnabled(opcaoF);
        jCremeDental.setEnabled(opcaoF);
        jEscovaDente.setEnabled(opcaoF);
        jAbsorvente.setEnabled(opcaoF);
        jPapelHigienico.setEnabled(opcaoF);
        jSabaoPo.setEnabled(opcaoF);
        jSabonete.setEnabled(opcaoF);
        jDesodorante.setEnabled(opcaoF);
        jBermuda.setEnabled(opcaoF);
        jCamisa.setEnabled(opcaoF);
        jCuecas.setEnabled(opcaoF);
        jChinelos.setEnabled(opcaoF);
        jUniformeCompleto.setEnabled(opcaoF);
        //ABA SEG
        jNumeroOcorrenciasInd.setEnabled(opcaoF);
        jNumeroAparelhoConvive.setEnabled(opcaoF);
        jObjetosMateriais.setEnabled(opcaoF);
        jNumeroProcedRevista.setEnabled(opcaoF);
        jNumeroOcorrenciasInd.setEnabled(opcaoF);
        jNumeroOcorrenciaTentaFuga.setEnabled(opcaoV);
        jNumeroOcorrenciaRebeliao.setEnabled(opcaoV);
        jNumeroOcorrenciaPessoaFerida.setEnabled(opcaoV);
        jNumeroOcorrenciaPessoasRefem.setEnabled(opcaoV);
        jNumeroOcorrenciaPessoasFerida.setEnabled(opcaoV);
        jNumeroHorasTVCFTV.setEnabled(opcaoV);
        jNumeroDiasSemScannerCorpo.setEnabled(opcaoV);
        jNumeroDiasIntMetaPortatil.setEnabled(opcaoV);
        jUmeroInterFuncVeiculosTP.setEnabled(opcaoV);
        jNumeroFalhasGerador.setEnabled(opcaoV);
        jNumeroHorasBloqueador.setEnabled(opcaoV);
        jNumeroAbsorEntregueVisitas.setEnabled(opcaoV);
        jNumeroFraldasEntreguePortaria.setEnabled(opcaoV);
        //ABA AJ
        jAtendInternoSAJ.setEnabled(opcaoF);
        jAlvaraSolturaCumprido.setEnabled(opcaoF);
        jLivarmentoCondRequerido.setEnabled(opcaoF);
        jProgressaoRegDeferido.setEnabled(opcaoF);
        jSaidasTempDeferida.setEnabled(opcaoF);
        jAlvarSolRecebeUni.setEnabled(opcaoV);
        jAudienciaProvocadas.setEnabled(opcaoV);
        jAudienciaCumpridas.setEnabled(opcaoV);
        jJuriPopular.setEnabled(opcaoV);
        jJuriPopularCumprido.setEnabled(opcaoV);
        jLiberdadeProvRequerida.setEnabled(opcaoV);
        jLiberdadeProvDeferida.setEnabled(opcaoV);
        jIndultosRequeridos.setEnabled(opcaoV);
        jIndultosDeferidos.setEnabled(opcaoV);
        jRemissaoPenaRequerida.setEnabled(opcaoV);
        jRemissaoPenaDeferida.setEnabled(opcaoV);
        jCondicionalRequerida.setEnabled(opcaoV);
        jProgressaoRegRequerido.setEnabled(opcaoV);
        jSaidaTempRequerida.setEnabled(opcaoV);
        jHabeasCorpusImpetrados.setEnabled(opcaoV);
        jHabeasCorpusDeferido.setEnabled(opcaoV);
        jLaudoPsicoEmitidos.setEnabled(opcaoV);
        jLaudosPsiqEmitidos.setEnabled(opcaoV);
        jTP.setEnabled(opcaoV);
        //ABA AL
        jTriagemAtendInernos.setEnabled(opcaoF);
        jOcupacaoAtiviRecreaReligiosa.setEnabled(opcaoF);
        PresoAtiviArtesPlasticas.setEnabled(opcaoF);
        jPresoAtiviLiteraria.setEnabled(opcaoF);
        jPresoAtiviCantoTeatro.setEnabled(opcaoF);
        jPresoMatProfissional.setEnabled(opcaoF);
        jPresoCertificaCursoProf.setEnabled(opcaoF);
        jPresoSentecaAtivLaboralRemun.setEnabled(opcaoF);
        jPresoAtiviLaboralNaoRemunera.setEnabled(opcaoF);
        //ABA AFI
        jAlimentaServidaInternoCafe.setEnabled(opcaoV);
        jAlimentaServidaInternoAlmoco.setEnabled(opcaoV);
        jAlimentaServidaInternoJantar.setEnabled(opcaoV);
        //ABA TOT
        jTotal01.setEnabled(opcaoF);
        jTotal02.setEnabled(opcaoF);
        jTotal03.setEnabled(opcaoF);
        jTotal04.setEnabled(opcaoF);
        jTotal05.setEnabled(opcaoF);
        jTotal06.setEnabled(opcaoF);
        jTotal07.setEnabled(opcaoF);
        jTotal08.setEnabled(opcaoF);
        jTotal09.setEnabled(opcaoF);
    }

    public void limparTodosCampos() {

    }

    public void pesquisaUnidadePrisional() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT DescricaoUnidade FROM UNIDADE_PENAL_EMPRESA");
            conecta.rs.first();
            jUnidadePrisional.setText(conecta.rs.getString("DescricaoUnidade"));
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void pesquisarPopulacaoAtual() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT TotalGeralInternos FROM MOVPOPULACAO");
            conecta.rs.last();
            jPopulacaoAtual.setText(conecta.rs.getString("TotalGeralInternos"));
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    //ABA AF - SERVIÇO SOCIAL
    //ATENDIMENTO PSICOSSOCIAL AO INTERNO
    public void calculoSS() {
        try {
            for (AtividadesMensalRealizadaUnidades dd0 : listaSSDao.read()) {
                dd0.getTipoAtendimento();
                dd0.getDataAtendimento();
                jAtendimentoPsiPreso.setText(String.valueOf(pQUANTIDADE_ADM_SOCIAL));
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAtividadesMensalUnidade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //ATENDIMENTO PSICOSSOCIAL A FAMILIA
    public void calculoSSF() {
        try {
            for (AtividadesMensalRealizadaUnidades dd1 : listaDaoFam.read()) {
                dd1.getTipoAtendimento();
                jAtendimentoPsiFamilaPreso.setText(String.valueOf(pQUANTIDADE_ATE_FAMILIA));
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAtividadesMensalUnidade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //NUMERO DE VISITANTES
    public void calculoVI() {
        try {
            for (AtividadesMensalRealizadaUnidades dd2 : listaDiasVIDao.read()) {
                dd2.getDataEntradaVisita();
                jNumeroVistantesInternos.setText(String.valueOf(pQUANTIDADE_VISITA_FAMILIA_INT));
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAtividadesMensalUnidade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //NÚMERO DE CRIANÇAS VISITA INTERNOS
    public void caluloVC() {
        try {
            for (AtividadesMensalRealizadaUnidades dd3 : listaVCDao.read()) {
                dd3.getDataEntradaVisita();
                jNumeroCriancasVisitas.setText(String.valueOf(pQUANTIDADE_VISITA_CRIANCA_INT));
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAtividadesMensalUnidade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //QUANTIDADE DE VISITAS DIAS
    public void caluloQTVD() {
        try {
            for (AtividadesMensalRealizadaUnidades dd4 : listaNumDiasVDao.read()) {
                dd4.getDataEntradaVisita();
                jNumeroDiasVisitas.setText(String.valueOf(pQUANTIDADE_DIAS_VISITADOS));
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAtividadesMensalUnidade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //QUANTIDADE ATENDIMENTO MÉDICO
    public void calculoMED() {
        try {
            for (AtividadesMensalRealizadaUnidades dd5 : listaQtdAtMedico.read()) {
                dd5.getTipoAtendimento();
                dd5.getDataAtendimento();
                jAtendimentoMedClinico.setText(String.valueOf(pQUANTIDADE_ATE_MEDICA));
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAtividadesMensalUnidade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //QUANTIDADE ATENDIMENTO PSIQUIATRA
    public void calculoPSIQ() {
        try {
            for (AtividadesMensalRealizadaUnidades dd6 : listaQtdAtPsiq.read()) {
                dd6.getTipoAtendimento();
                dd6.getDataAtendimento();
                jAtendimentoMedPsi.setText(String.valueOf(pQUANDIDADE_ATE_PSIQUIATRICA));
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAtividadesMensalUnidade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //QUANTIDADE ATENDIMENTO ENFERMEIRA
    public void calculoENFER() {
        try {
            for (AtividadesMensalRealizadaUnidades dd6 : listaQtdAtEnfer.read()) {
                dd6.getTipoAtendimento();
                dd6.getDataAtendimento();
                jAtendimentoEnfermagem.setText(String.valueOf(pQUANTIDADE_ATE_ENFERMAGEM));
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAtividadesMensalUnidade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //QUANTIDADE ATENDIMENTO PSICOLOGICOS  
    public void calculoPSI() {
        try {
            for (AtividadesMensalRealizadaUnidades dd7 : listaAtdAtPsico.read()) {
                dd7.getDataAtendimento();
                dd7.getTipoAtendimento();
                jAtendimentoPsicologico.setText(String.valueOf(pQUANTIDADE_ATE_PSICOLOGIA));
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAtividadesMensalUnidade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //QUANTIDADE PROCEDIMENTO ODONTOLOGICO
    public void calculoProcODON() {
        try {
            for (AtividadesMensalRealizadaUnidades dd8 : listaProcAtOdon.read()) {
                dd8.getDataAtendimento();
                dd8.getTipoAtendimento();
                jProcedimentoOdontologico.setText(String.valueOf(pQUANTIDADE_PROC_ODONTOLOGICO));
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAtividadesMensalUnidade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //QUANTIDADE ATENDIMENTOS ODONTOLOGICO
    public void calculoAtendODON() {
        try {
            for (AtividadesMensalRealizadaUnidades dd9 : listaAtdAtOdon.read()) {
                dd9.getDataAtendimento();
                dd9.getTipoAtendimento();
                jAtendimentoOdontologicos.setText(String.valueOf(pQUANTIDADE_ATE_ODONTOLOGICO));
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAtividadesMensalUnidade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //QUANTIDADE PRODUTOS KIT HIGIÊNE
    public void calcularPROKit(){
        try {
            for (AtividadesMensalRealizadaUnidades dd10 : listaAtdAtOdon.read()) {
                dd10.getDataAtendimento();
                dd10.getTipoAtendimento();
                jAtendimentoOdontologicos.setText(String.valueOf(pQUANTIDADE_ATE_ODONTOLOGICO));
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAtividadesMensalUnidade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //INTERNO SENTENCIADO MATRICULADOS CURSO FUNDAMENTAL
    public void calculoMatPED() {
        try {
            for (AtividadesMensalRealizadaUnidades dd10 : listaMatInTPed.read()) {
                dd10.getDataMatricula();
                jPresoSentenciadoEF.setText(String.valueOf(pQUANTIDADE_MATRICULADOS));
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAtividadesMensalUnidade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //INTERNO SENTENCIADO MATRICULADOS CURSO FUNDAMENTAL
    public void calculoFreqPED() {
        try {
            for (AtividadesMensalRealizadaUnidades dd11 : listaFreqIntPed.read()) {
                dd11.getDataFrequencia();
                jPresoSentencaMatFreqEF.setText(String.valueOf(pQUANTIDADE_INTERNOS_PRESENTE));
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAtividadesMensalUnidade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //QUANTIDADE APARELHO CELULAR
    public void calculoCelularSEG() {
        try {
            for (AtividadesMensalRealizadaUnidades dd12 : listaQdtCelular.read()) {
                dd12.getDataProcedimento();
                dd12.getQuantidadeCelular();
                jNumeroAparelhoConvive.setText(String.valueOf(pQUANTIDADE_APARELHO_CELULAR));
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAtividadesMensalUnidade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //QUANTIDADE DE OBJETOS 
    public void calcularObjetos() {
        try {
            for (AtividadesMensalRealizadaUnidades dd13 : listaQtdObjetos.read()) {
                dd13.getDataProcedimento();
                dd13.getQuantidadeObjetos();
                jObjetosMateriais.setText(String.valueOf(pQUANTIDADE_OBJETOS_PROC));
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAtividadesMensalUnidade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //QUANTIDADE DE REVISTA REALIZADO POR CELA 
    public void calcularQtdRevistaCela() {
        try {
            for (AtividadesMensalRealizadaUnidades dd13 : listaProdutoKit.read()) {
//                dd13.getDataProcedimento();
//                dd13.getQuantidadeObjetos();
                dd13.getAparelhoBarbear();
                dd13.getAbsorvente();
                dd13.getBermuda();
                dd13.getCamisa();
                dd13.getCaneca();
                dd13.getCobertor();
                dd13.getColchao();
                dd13.getColher();
                dd13.getCremeDental();
                dd13.getCueca();
                dd13.getDesodorante();
                dd13.getEscova();
                dd13.getLencol();
                dd13.getPapelHigienico();
                dd13.getPote();
                dd13.getSabaoPo();
                dd13.getSabonete();
                dd13.getParChinelos();
                dd13.getToalha();
                jAparelhoBarbear.setText(dd13.getAparelhoBarbear());
                jAbsorvente.setText(String.valueOf(dd13.getAbsorvente()));
                jBermuda.setText(String.valueOf(dd13.getBermuda()));
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAtividadesMensalUnidade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Novo() {
        jStatus.setText("ABERTO");
        jDataCriacao.setCalendar(Calendar.getInstance());
        //
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtPesquisarColaborador.setEnabled(true);
        jBtPesquisarDatas.setEnabled(true);
    }

    public void Alterar() {
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtPesquisarColaborador.setEnabled(true);
        jBtPesquisarDatas.setEnabled(true);
    }

    public void Excluir() {
        limparTodosCampos();
        bloquearHabilitarTodosCampos(!true, !true);
        bloquearDesbloquearBotoes(!true);
        jBtNovo.setEnabled(true);
    }

    public void Salvar() {
        bloquearHabilitarTodosCampos(!true, !true);
        bloquearDesbloquearBotoes(!true);
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtAuditoria.setEnabled(true);
    }

    public void Cancelar() {
        if (jChave.getText().equals("")) {
            limparTodosCampos();
            bloquearHabilitarTodosCampos(!true, !true);
            bloquearDesbloquearBotoes(!true);
            jBtNovo.setEnabled(true);
        } else {
            bloquearHabilitarTodosCampos(!true, !true);
            bloquearDesbloquearBotoes(!true);
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtAuditoria.setEnabled(true);
        }
    }

    public void Finalizar() {

    }

    public void buscarChave() {

    }

    // Pesquisa de todos os lançamentos
    public void pesquisarFuncNome(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Mês", "Ano", "Unidade Prisional"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1;
                // Formatar a data no formato Brasil
                dataCadastro = conecta.rs.getString("DataCadFunc");
                String dia = dataCadastro.substring(8, 10);
                String mes = dataCadastro.substring(5, 7);
                String ano = dataCadastro.substring(0, 4);
                dataCadastro = dia + "/" + mes + "/" + ano;
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdFunc"), dataCadastro, conecta.rs.getString("StatusFunc"), conecta.rs.getString("NomeFunc"), conecta.rs.getString("NomeDepartamento")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaFuncionario.setModel(modelo);
        jTabelaFuncionario.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaFuncionario.getColumnModel().getColumn(0).setResizable(false);
        jTabelaFuncionario.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaFuncionario.getColumnModel().getColumn(1).setResizable(false);
        jTabelaFuncionario.getColumnModel().getColumn(2).setPreferredWidth(50);
        jTabelaFuncionario.getColumnModel().getColumn(2).setResizable(false);
        jTabelaFuncionario.getColumnModel().getColumn(3).setPreferredWidth(250);
        jTabelaFuncionario.getColumnModel().getColumn(3).setResizable(false);
        jTabelaFuncionario.getColumnModel().getColumn(4).setPreferredWidth(200);
        jTabelaFuncionario.getColumnModel().getColumn(4).setResizable(false);
        jTabelaFuncionario.getTableHeader().setReorderingAllowed(false);
        jTabelaFuncionario.setAutoResizeMode(jTabelaFuncionario.AUTO_RESIZE_OFF);
        jTabelaFuncionario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabela();
        conecta.desconecta();
    }

    public void limparTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Mês", "Ano", "Unidade Prisional"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaFuncionario.setModel(modelo);
        jTabelaFuncionario.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaFuncionario.getColumnModel().getColumn(0).setResizable(false);
        jTabelaFuncionario.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaFuncionario.getColumnModel().getColumn(1).setResizable(false);
        jTabelaFuncionario.getColumnModel().getColumn(2).setPreferredWidth(50);
        jTabelaFuncionario.getColumnModel().getColumn(2).setResizable(false);
        jTabelaFuncionario.getColumnModel().getColumn(3).setPreferredWidth(250);
        jTabelaFuncionario.getColumnModel().getColumn(3).setResizable(false);
        jTabelaFuncionario.getColumnModel().getColumn(4).setPreferredWidth(200);
        jTabelaFuncionario.getColumnModel().getColumn(4).setResizable(false);
        jTabelaFuncionario.getTableHeader().setReorderingAllowed(false);
        jTabelaFuncionario.setAutoResizeMode(jTabelaFuncionario.AUTO_RESIZE_OFF);
        jTabelaFuncionario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
        jTabelaFuncionario.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaFuncionario.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaFuncionario.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jChave.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void buscarAcessoUsuario(String nomeTelaAcesso) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nameUser + "'");
            conecta.rs.first();
            codigoUserADM = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUserADM + "'");
            conecta.rs.first();
            codigoUserGroupADM = conecta.rs.getInt("IdUsuario");
            codigoGrupoADM = conecta.rs.getInt("IdGrupo");
            nomeGrupoADM = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUserADM + "' "
                    + "AND NomeTela='" + nomeTelaAcesso + "'");
            conecta.rs.first();
            codUserAcessoADM = conecta.rs.getInt("IdUsuario");
            codAbrirADM = conecta.rs.getInt("Abrir");
            codIncluirADM = conecta.rs.getInt("Incluir");
            codAlterarADM = conecta.rs.getInt("Alterar");
            codExcluirADM = conecta.rs.getInt("Excluir");
            codGravarADM = conecta.rs.getInt("Gravar");
            codConsultarADM = conecta.rs.getInt("Consultar");
            nomeTelaADM = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
