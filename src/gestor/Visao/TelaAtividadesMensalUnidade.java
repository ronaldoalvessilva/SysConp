/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import Utilitarios.LimiteDigitosSoNum;
import gestor.Controle.ControleAtividadesUnidade;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ConversaoDatasAtividadesUnidades;
import gestor.Controle.ListagemAgravosDiagnosticados;
import gestor.Controle.ListagemAgravosDiagnosticadosEVO;
import gestor.Controle.ListagemAtendimentoADMEVOLTerapaia;
import gestor.Controle.ListagemAtendimentoADMEnfermeira;
import gestor.Controle.ListagemAtendimentoADMMedica;
import gestor.Controle.ListagemAtendimentoADMOdontologica;
import gestor.Controle.ListagemAtendimentoPROCOdontologica;
import gestor.Controle.ListagemAtendimentoADMPsicologico;
import gestor.Controle.ListagemAtendimentoADMPsiquiatrica;
import gestor.Controle.ListagemAtendimentoADMServicoSocial;
import gestor.Controle.ListagemAtendimentoADMServicoSocialFamilia;
import gestor.Controle.ListagemAtendimentoFamiliaInternos;
import gestor.Controle.ListagemAtividadesUnidadePorCodigo;
import gestor.Controle.ListagemAtividadesUnidadePorColaborador;
import gestor.Controle.ListagemAtividadesUnidadePorData;
import gestor.Controle.ListagemAtividadesUnidadePorMesAnoRef;
import gestor.Controle.ListagemAtividadesUnidadeSelecionado;
import gestor.Controle.ListagemAtividadesUnidadeTodas;
import gestor.Controle.ListagemControleDiabetes;
import gestor.Controle.ListagemControleHipertensao;
import gestor.Controle.ListagemDoencasInfectoconagiosasADM;
import gestor.Controle.ListagemDoencasInfectoconagiosasEVO;
import gestor.Controle.ListagemInternosCivilmente;
import gestor.Controle.ListagemInternosFrequenciaPedagogia;
import gestor.Controle.ListagemInternosLivramento;
import gestor.Controle.ListagemInternosMatriculadoPedagogia;
import gestor.Controle.ListagemInternosProgressao;
import gestor.Controle.ListagemInternosSaidaAlvara;
import gestor.Controle.ListagemInternosSaidaTMP;
import gestor.Controle.ListagemInternosVacinados;
import gestor.Controle.ListagemQuantidadeInternosVisitados;
import gestor.Controle.ListagemMediaPopulacao;
import gestor.Controle.ListagemNumerosDiasVisitas;
import gestor.Controle.ListagemNumerosDiasVisitasInterno;
import gestor.Controle.ListagemNumerosVisitasInternoMenor;
import gestor.Controle.ListagemQuantidadeAparelhoCeluar;
import gestor.Controle.ListagemQuantidadeObjetos;
import gestor.Controle.ListagemQuantidadeProdutosKit;
import gestor.Controle.ListagemQuantidadeRevistaPorCela;
import gestor.Controle.ListagemQuantidadeVistantes;
import gestor.Controle.PesquisaMesAno;
import gestor.Controle.listarParametros;
import static gestor.Visao.TelaModuloAdmPessoal.codAbrirADM;
import static gestor.Visao.TelaModuloAdmPessoal.codAlterarADM;
import static gestor.Visao.TelaModuloAdmPessoal.codConsultarADM;
import static gestor.Visao.TelaModuloAdmPessoal.codExcluirADM;
import static gestor.Visao.TelaModuloAdmPessoal.codGravarADM;
import static gestor.Visao.TelaModuloAdmPessoal.codigoGrupoADM;
import static gestor.Visao.TelaModuloAdmPessoal.codigoUserGroupADM;
import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AtividadesMensalRealizadaUnidades;
import gestor.Modelo.LogSistema;
import static gestor.Visao.TelaLoginSenha.descricaoUnidade;
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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ronal
 */
public class TelaAtividadesMensalUnidade extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    //MANUTENÇÃO
    AtividadesMensalRealizadaUnidades objAtividade = new AtividadesMensalRealizadaUnidades();
    ListagemAtividadesUnidadeTodas listaTodosReg = new ListagemAtividadesUnidadeTodas();
    ListagemAtividadesUnidadePorData listaAtividadeData = new ListagemAtividadesUnidadePorData();
    ListagemAtividadesUnidadePorCodigo listaAtividadeCodigo = new ListagemAtividadesUnidadePorCodigo();
    ListagemAtividadesUnidadePorColaborador listaAtividadeCola = new ListagemAtividadesUnidadePorColaborador();
    ListagemAtividadesUnidadePorMesAnoRef listaAtividadeMesAno = new ListagemAtividadesUnidadePorMesAnoRef();
    ListagemMediaPopulacao listaMediaPop = new ListagemMediaPopulacao();
    ControleAtividadesUnidade control = new ControleAtividadesUnidade();
    PesquisaMesAno pesquisaMesAno = new PesquisaMesAno();
    ListagemAtividadesUnidadeSelecionado listaSelecao = new ListagemAtividadesUnidadeSelecionado();
    listarParametros parametros = new listarParametros();
    //ABA AF
    ListagemAtendimentoADMServicoSocial listaSSDao = new ListagemAtendimentoADMServicoSocial();
    ListagemAtendimentoADMServicoSocialFamilia listaDaoFam = new ListagemAtendimentoADMServicoSocialFamilia();
    ListagemNumerosDiasVisitasInterno listaDiasVIDao = new ListagemNumerosDiasVisitasInterno();
    ListagemNumerosVisitasInternoMenor listaVCDao = new ListagemNumerosVisitasInternoMenor();
    ListagemQuantidadeInternosVisitados listagemInternosVistados = new ListagemQuantidadeInternosVisitados();
    ListagemQuantidadeVistantes listagemQuantidadeVistantes = new ListagemQuantidadeVistantes();
    ListagemNumerosDiasVisitas listaNumDiasVDao = new ListagemNumerosDiasVisitas();
    ListagemInternosCivilmente listaInternosCivil = new ListagemInternosCivilmente();
    //ABA ASI
    ListagemAtendimentoADMMedica listaQtdAtMedico = new ListagemAtendimentoADMMedica();
    ListagemAtendimentoADMPsiquiatrica listaQtdAtPsiq = new ListagemAtendimentoADMPsiquiatrica();
    ListagemAtendimentoADMEnfermeira listaQtdAtEnfer = new ListagemAtendimentoADMEnfermeira();
    ListagemAtendimentoADMPsicologico listaAtdAtPsico = new ListagemAtendimentoADMPsicologico();
    ListagemAtendimentoPROCOdontologica listaProcAtOdon = new ListagemAtendimentoPROCOdontologica();
    ListagemAtendimentoADMOdontologica listaAtdAtOdon = new ListagemAtendimentoADMOdontologica();
    //
    ListagemDoencasInfectoconagiosasADM listaDoencaIntectoADM = new ListagemDoencasInfectoconagiosasADM();
    ListagemDoencasInfectoconagiosasEVO listaDoencaInfectoEvol = new ListagemDoencasInfectoconagiosasEVO();
    ListagemAgravosDiagnosticados listaAgravosDiag = new ListagemAgravosDiagnosticados();
    ListagemAgravosDiagnosticadosEVO listaAgravosDiagEvo = new ListagemAgravosDiagnosticadosEVO();
    ListagemControleHipertensao listaControleHiper = new ListagemControleHipertensao();
    ListagemControleDiabetes listaControleDiabetes = new ListagemControleDiabetes();
    ListagemInternosVacinados listaInternosVacinados = new ListagemInternosVacinados();
    //ABA AEI
    ListagemInternosMatriculadoPedagogia listaMatInTPed = new ListagemInternosMatriculadoPedagogia();
    ListagemInternosFrequenciaPedagogia listaFreqIntPed = new ListagemInternosFrequenciaPedagogia();
    //AMI
    ListagemQuantidadeProdutosKit listaProdutoKit = new ListagemQuantidadeProdutosKit();
    //ABA SEG
    ListagemQuantidadeAparelhoCeluar listaQdtCelular = new ListagemQuantidadeAparelhoCeluar();
    ListagemQuantidadeObjetos listaQtdObjetos = new ListagemQuantidadeObjetos();
    ListagemQuantidadeRevistaPorCela listaRevistaCela = new ListagemQuantidadeRevistaPorCela();
    //ABA AJ
    ListagemAtendimentoFamiliaInternos listaAtendFam = new ListagemAtendimentoFamiliaInternos();
    ListagemInternosSaidaAlvara listaSaidaAlvara = new ListagemInternosSaidaAlvara();
    ListagemInternosLivramento listaLivramento = new ListagemInternosLivramento();
    ListagemInternosProgressao listaProgressao = new ListagemInternosProgressao();
    ListagemInternosSaidaTMP listaSaidaTMP = new ListagemInternosSaidaTMP();
    ListagemAtendimentoADMEVOLTerapaia listaADMEVO = new ListagemAtendimentoADMEVOLTerapaia();
    //
    ConversaoDatasAtividadesUnidades converteDate = new ConversaoDatasAtividadesUnidades();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela = "AdmPessoal:Atividades Realizadas na Unidade:Manutenção";
    String statusMov;
    String horaMov;
    String dataModFinal;
    //    
    int acao;
    int flag;
    int count = 0;
    String dataInicial, dataFinal;
    String dataCadastro;
    //MANUTENÇÃO
    int pID_UNIDADE = 0;
    public static int pQUANTIDADE_TOTAL_POPULACAO = 0;
    public static int pQUANTIDADE_DIAS_POPULACAO = 0;
    public static int pTOTAL_REGISTROS_ATIVIDADES = 0;
    String pDATA_PESQUISA_INICIAL = "";
    String pDATA_PESQUISA_FINAL = "";
    String pDATA_PERIODO_INICIAL = "";
    String pDATA_PERIODO_FINAL = "";
    int pMEDIA_POPULCAO = 0;
    //
    String pMES_REFERENCIA = "";
    String pDIA = "";
    String pMES = "";
    String pANO = "";
    //
    String pDIA_ESCOLHIDO = "";
    String pMES_ESCOLHIDO = "";
    String pANO_ESCOLHIDO = "";
    //
    String pMES_01 = "01";
    String pMES_02 = "02";
    String pMES_03 = "Março";
    String pMES_04 = "Abril";
    String pMES_05 = "Maio";
    String pMES_06 = "Junho";
    String pMES_07 = "Julho";
    String pMES_08 = "Agosto";
    String pMES_09 = "Setembro";
    String pMES_10 = "Outubro";
    String pMES_11 = "Novembro";
    String pMES_12 = "Dezembro";
    String pEXISTE_ANO = "";
    String pEXISTE_MES = "";
    String pDATA_PESQUISA_TABELA = "";
    //ABA ASSI - SERVIÇO SOCIAL
    public static String pTIPO_ATENDIMENTO_ADM_SOCIAL = "Admissão Serviço Social";
    public static String pTIPO_ATENDIMENTO_EVO_SOCIAL = "Evolução Serviço Social";
    public static String pTIPO_ATENDIMENTO_LIGACOES = "Ligações Telefonicas";
    public static String pTIPO_ATENDIMENTO_GRUPO_SOCIAL = "Atendimento em Grupo/SS";
    public static int pQUANTIDADE_INTERNOS_CIVIL = 0;
    //ASSI - QUANTIDADES CALCULADA
    public static int pQUANTIDADE_ADM_SOCIAL = 0;
    public static int pQUANTIDADE_EVO_SOCIAL = 0;
    public static int pQUANTIDADE_ATE_FAMILIA = 0;
    public static int pQUANTIDADE_DIAS_VISITADOS = 0;
    public static int pQUANTIDADE_VISITA_FAMILIA_INT = 0;
    public static int pQUANTIDADE_VISITAS = 0;
    public static int pQUANTIDADE_INTERNOS = 0;
    int pMEDIA_VISITAS_POR_INTERNOS = 0;
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
    //AGRAVOS DIAGNOSTICADOS
    public static int pQUANTIDADE_VDRL = 0;
    public static int pQUANTIDADE_VACINADOS = 0;
    public static int pQUANTIDADE_HEPATITE_C = 0;
    public static int pQUANTIDADE_HIV = 0;
    public static int pQUANTIDADE_SIFILIS = 0;
    public static int pQUANTIDADE_HPV = 0;
    public static int pQUANTIDADE_DIABETES = 0;
    public static int pQUANTIDADE_HIPERTENSAO = 0;
    public static int pQUANTIDADE_TUBERCULOSE = 0;
    public static int pQUANTIDADE_HANSEINIASE = 0;
    public static int pQUANTIDADE_ESCABIOSE = 0;
    public static int pQUANTIDADE_DST = 0;
    public static int pQUANTIDADE_TOTAL_AGRAVOS = 0;
    public static int pQUANTIDADE_TOTAL_AGRAVOS_EVO = 0;
    int pTOTAL_GERAL_AGRAVADOS = 0;
    public static int pQUANTIDADE_TOTAL_INFECTO = 0;
    public static int pQUANTIDADE_TOTAL_INFECTO_EVO = 0;
    public static int pQUANTIDADE_TOTAL_INFECTO_EVO_ADM = 0;
    public static int pQUANTIDADE_TOTAL_VACINAS = 0;
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
    //ATENDIMENTOS PSICOLOGICOS
    public static int pQUANTIDADE_ATE_PSICOLOGIA = 0;
    //PROCEDIMENTOS ODOTOLOGICO
    public static int pQUANTIDADE_PROC_ODONTOLOGICO = 0;
    public static int pQUANTIDADE_ATE_ODONTOLOGICO = 0;
    //ABA AEI - PEDAGOGIA
    public static int pQUANTIDADE_MATRICULADOS = 0;
    public static int pQUANTIDADE_INTERNOS_PRESENTE = 0;
    //ABA AMI - ALMOXARIFADO
    //ABA SEG - GERENCIA OPERACIONAL
    public static int pQUANTIDADE_APARELHO_CELULAR = 0;
    public static int pQUANTIDADE_OBJETOS_PROC = 0;
    public static int pQUANTIDADE_REVISTA_POR_CELA = 0;
    //ABA AJ - JURÍDICO
    public static int pQUANTIDADE_ATENDE_FAMILIA_JURI = 0;
    public static int pQUANTIDADE_ALVARA = 0;
    public static int pQUANTIDADE_LIVRAMENTO = 0;
    public static int pQUANTIDADE_PROGRESSAO = 0;
    public static int pQUANTIDADE_SAIDA_TMP = 0;
    //ABA AL - TERAPIA OCUPACIONAL
    public static String pTIPO_ATENDIMENTO_ADM_TO = "Admissão Terapia";
    public static String pTIPO_ATENDIMENTO_EVO_TO = "Evolução Terapia";
    public static String pTIPO_ATENDIMENTO_GRUPO_TO = "Atendimento em Grupo/TO";
    public static int pQUANTIDADE_TOTAL_TO = 0;
    //ABA AFI - NUTRIÇÃO
    // TOTAIS
    int pQUANT_TOTAL_SOCIAL = 0;
    int pQUANT_TOTAL_SERVIDORES = 0;
    int pQUANT_TOTAL_SAUDE_INTERNO = 0;
    int pQUANT_TOTAL_EDUCACIONAL = 0;
    int pQUANT_TOTAL_MATERIAL_INTERNO = 0;
    int pQUANT_TOTAL_RECREATIVA_RELIGIOSA = 0;
    int pQUANT_TOTAL_JURIDICO = 0;
    int pQUANT_TOTAL_LABORAL = 0;
    int pQUANT_TOTAL_FOR_INTERNOS = 0;

    /**
     * Creates new form TelaAtividadesMensalUnidade
     */
    public TelaAtividadesMensalUnidade() {
        initComponents();
        formatarCampos();
        corCampos();
        validarCampos();
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
        jCodigoAtividade = new javax.swing.JTextField();
        jBtPesqCodigoAtividade = new javax.swing.JButton();
        jBtPesqDatas = new javax.swing.JButton();
        jDataPesqInicial = new com.toedter.calendar.JDateChooser();
        jLabel73 = new javax.swing.JLabel();
        jDataPesFinal = new com.toedter.calendar.JDateChooser();
        jLabel74 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        jComboBoxMesPesquisa = new javax.swing.JComboBox<>();
        jComboBoxAnoPesquisa = new javax.swing.JComboBox<>();
        jBtPesqMesAno = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaAtividadesUnidade = new javax.swing.JTable();
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxMesReferencia = new javax.swing.JComboBox<>();
        jComboBoxAnoReferencia = new javax.swing.JComboBox<>();
        jLabel153 = new javax.swing.JLabel();
        jLabel155 = new javax.swing.JLabel();
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
        jLabel13 = new javax.swing.JLabel();
        jPresoIdentCivil = new javax.swing.JFormattedTextField();
        jPanel14 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
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
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jAtendimentoMedClinico = new javax.swing.JFormattedTextField();
        jAtendimentoMedicoPsiquiatrico = new javax.swing.JFormattedTextField();
        jAtendimentoEnfermagem = new javax.swing.JFormattedTextField();
        jProcedimentoOdontologico = new javax.swing.JFormattedTextField();
        jAtendimentoPsicologico = new javax.swing.JFormattedTextField();
        jTratamentoAgravDiaginostico = new javax.swing.JFormattedTextField();
        jAtendimentoOdontologicos = new javax.swing.JFormattedTextField();
        jPresoDoencaInfecto = new javax.swing.JFormattedTextField();
        jControlHipertensao = new javax.swing.JFormattedTextField();
        jControleDiabetes = new javax.swing.JFormattedTextField();
        jPresosVacinados = new javax.swing.JFormattedTextField();
        jPanel15 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jAspectosSexual = new javax.swing.JFormattedTextField();
        jPanel6 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jLabel131 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        jPresoSentencaMatFreqEF = new javax.swing.JFormattedTextField();
        jPresoSentenciadoEF = new javax.swing.JFormattedTextField();
        jPanel48 = new javax.swing.JPanel();
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
        jLabel150 = new javax.swing.JLabel();
        jColherPlastica = new javax.swing.JFormattedTextField();
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
        jNumeroOcorrenciaPessoasFeridaMortas = new javax.swing.JFormattedTextField();
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
        jNumeroOcorrenciaFuga = new javax.swing.JFormattedTextField();
        jNumeroInterFuncVeiculosTP = new javax.swing.JFormattedTextField();
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
        jLabel157 = new javax.swing.JLabel();
        jNumeroOcorrenciaTentaFuga = new javax.swing.JFormattedTextField();
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
        jLabel156 = new javax.swing.JLabel();
        jCondicionalDeferida = new javax.swing.JFormattedTextField();
        jPanel33 = new javax.swing.JPanel();
        jPanel45 = new javax.swing.JPanel();
        jLabel121 = new javax.swing.JLabel();
        jPanel46 = new javax.swing.JPanel();
        jLabel122 = new javax.swing.JLabel();
        jTriagemAtendInernos = new javax.swing.JFormattedTextField();
        jPanel47 = new javax.swing.JPanel();
        jLabel129 = new javax.swing.JLabel();
        jLabel130 = new javax.swing.JLabel();
        jPresoSentecaAtivLaboralRemun = new javax.swing.JFormattedTextField();
        jPresoAtiviLaboralNaoRemunera = new javax.swing.JFormattedTextField();
        jLabel123 = new javax.swing.JLabel();
        jOcupacaoAtiviRecreaReligiosa = new javax.swing.JFormattedTextField();
        jLabel124 = new javax.swing.JLabel();
        jPresoAtiviArtesPlasticas = new javax.swing.JFormattedTextField();
        jLabel125 = new javax.swing.JLabel();
        jPresoAtiviLiteraria = new javax.swing.JFormattedTextField();
        jLabel126 = new javax.swing.JLabel();
        jPresoAtiviCantoTeatro = new javax.swing.JFormattedTextField();
        jLabel127 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        jMatriculadoCursoProfissionalizante = new javax.swing.JFormattedTextField();
        jCertificadoCursoProfissionalizante = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        jPresoAtiviReligiosa = new javax.swing.JFormattedTextField();
        jLabel49 = new javax.swing.JLabel();
        jPresoAtiviPraticaEsportiva = new javax.swing.JFormattedTextField();
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
        jPanel35 = new javax.swing.JPanel();
        jPanel58 = new javax.swing.JPanel();
        jLabel142 = new javax.swing.JLabel();
        jTotal_ASSIS_LABORAL = new javax.swing.JFormattedTextField();
        jPanel50 = new javax.swing.JPanel();
        jLabel133 = new javax.swing.JLabel();
        jPanel55 = new javax.swing.JPanel();
        jLabel139 = new javax.swing.JLabel();
        jTotal_MATERIAL_INTERNO = new javax.swing.JFormattedTextField();
        jPanel59 = new javax.swing.JPanel();
        jBtCalcularTotais = new javax.swing.JButton();
        jBtAtualizarDatas = new javax.swing.JButton();
        jPanel51 = new javax.swing.JPanel();
        jLabel135 = new javax.swing.JLabel();
        jTotal_ALI_FOR_SERVIDORES = new javax.swing.JFormattedTextField();
        jPanel56 = new javax.swing.JPanel();
        jLabel140 = new javax.swing.JLabel();
        jTotal_ATI_RECREATIVA_RELIGIOSA = new javax.swing.JFormattedTextField();
        jPanel52 = new javax.swing.JPanel();
        jLabel136 = new javax.swing.JLabel();
        jTotal_ATE_SAUDE_INTERNO = new javax.swing.JFormattedTextField();
        jPanel57 = new javax.swing.JPanel();
        jLabel141 = new javax.swing.JLabel();
        jTotal_ATEND_JURIDICO = new javax.swing.JFormattedTextField();
        jPanel49 = new javax.swing.JPanel();
        jLabel134 = new javax.swing.JLabel();
        jTotal_ATE_SOCIAL = new javax.swing.JFormattedTextField();
        jPanel53 = new javax.swing.JPanel();
        jLabel137 = new javax.swing.JLabel();
        jTotal_ATE_EDUCACIONAL = new javax.swing.JFormattedTextField();
        jPanel62 = new javax.swing.JPanel();
        jLabel145 = new javax.swing.JLabel();
        jTotal_ALIM_FOR_INTERNOS = new javax.swing.JFormattedTextField();
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

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Atividades Mensais Realizadas pela Unidade");

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

        jCodigoAtividade.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodigoAtividade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqCodigoAtividade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqCodigoAtividade.setContentAreaFilled(false);
        jBtPesqCodigoAtividade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqCodigoAtividadeActionPerformed(evt);
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

        jComboBoxMesPesquisa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxMesPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));
        jComboBoxMesPesquisa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jComboBoxAnoPesquisa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxAnoPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "1900", "1901", "1902", "1903", "1904", "1905", "1906", "1907", "1908", "1909", "1910", "1911", "1912", "1913", "1914", "1915", "1916", "1917", "1918", "1919", "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", "2051", "2052", "2053", "2054", "2055", "2056", "2057", "2058", "2059", "2060", "2061", "2062", "2063", "2064", "2065", "2066", "2067", "2068", "2069", "2070", "2071", "2072", "2073", "2074", "2075", "2076", "2077", "2078", "2079", "2080", "2081", "2082", "2083", "2084", "2085", "2086", "2087", "2088", "2089", "2090", "2091", "2092", "2093", "2094", "2095", "2096", "2097", "2098", "2099", "2100", "2101", "2102", "2103", "2104", "2105", "2106", "2107", "2108", "2109", "2110", "2111", "2112", "2113", "2114", "2115", "2116", "2117", "2118", "2119", "2120", "2121", "2122", "2123", "2124", "2125", "2126", "2127", "2128", "2129", "2130", "2131", "2132", "2133", "2134", "2135", "2136", "2137", "2138", "2139", "2140", "2141", "2142", "2143", "2144", "2145", "2146", "2147", "2148", "2149", "2150", "2151", "2152", "2153", "2154", "2155", "2156", "2157", "2158", "2159", "2160", "2161", "2162", "2163", "2164", "2165", "2166", "2167", "2168", "2169", "2170", "2171", "2172", "2173", "2174", "2175", "2176", "2177", "2178", "2179", "2180", "2181", "2182", "2183", "2184", "2185", "2186", "2187", "2188", "2189", "2190", "2191", "2192", "2193", "2194", "2195", "2196", "2197", "2198", "2199", "2200", "2201", "2202", "2203", "2204", "2205", "2206", "2207", "2208", "2209", "2210", "2211", "2212", "2213", "2214", "2215", "2216", "2217", "2218", "2219", "2220", "2221", "2222", "2223", "2224", "2225", "2226", "2227", "2228", "2229", "2230", "2231", "2232", "2233", "2234", "2235", "2236", "2237", "2238", "2239", "2240", "2241", "2242", "2243", "2244", "2245", "2246", "2247", "2248", "2249", "2250", "2251", "2252", "2253", "2254", "2255", "2256", "2257", "2258", "2259", "2260", "2261", "2262", "2263", "2264", "2265", "2266", "2267", "2268", "2269", "2270", "2271", "2272", "2273", "2274", "2275", "2276", "2277", "2278", "2279", "2280", "2281", "2282", "2283", "2284", "2285", "2286", "2287", "2288", "2289", "2290", "2291", "2292", "2293", "2294", "2295", "2296", "2297", "2298", "2299", "2300", "2301", "2302", "2303", "2304", "2305", "2306", "2307", "2308", "2309", "2310", "2311", "2312", "2313", "2314", "2315", "2316", "2317", "2318", "2319", "2320", "2321", "2322", "2323", "2324", "2325", "2326", "2327", "2328", "2329", "2330", "2331", "2332", "2333", "2334", "2335", "2336", "2337", "2338", "2339", "2340", "2341", "2342", "2343", "2344", "2345", "2346", "2347", "2348", "2349", "2350", "2351", "2352", "2353", " ", " ", " " }));
        jComboBoxAnoPesquisa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

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
                .addGap(33, 33, 33)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel138)
                    .addComponent(jLabel10)
                    .addComponent(jLabel73)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addComponent(jComboBoxMesPesquisa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxAnoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jCodigoAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqCodigoAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jCodigoAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqCodigoAtividade)
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
                    .addComponent(jComboBoxAnoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxMesPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel138))
                .addGap(7, 7, 7))
        );

        jTabelaAtividadesUnidade.setAutoCreateRowSorter(true);
        jTabelaAtividadesUnidade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaAtividadesUnidade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data", "Status", "Mês", "Ano", "Unidade Prisional"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabelaAtividadesUnidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaAtividadesUnidadeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaAtividadesUnidade);
        if (jTabelaAtividadesUnidade.getColumnModel().getColumnCount() > 0) {
            jTabelaAtividadesUnidade.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaAtividadesUnidade.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaAtividadesUnidade.getColumnModel().getColumn(1).setMinWidth(80);
            jTabelaAtividadesUnidade.getColumnModel().getColumn(1).setMaxWidth(80);
            jTabelaAtividadesUnidade.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaAtividadesUnidade.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaAtividadesUnidade.getColumnModel().getColumn(3).setMinWidth(80);
            jTabelaAtividadesUnidade.getColumnModel().getColumn(3).setMaxWidth(80);
            jTabelaAtividadesUnidade.getColumnModel().getColumn(4).setMinWidth(70);
            jTabelaAtividadesUnidade.getColumnModel().getColumn(4).setMaxWidth(70);
            jTabelaAtividadesUnidade.getColumnModel().getColumn(5).setMinWidth(300);
            jTabelaAtividadesUnidade.getColumnModel().getColumn(5).setMaxWidth(300);
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        jTabbedPane1.addTab("Listagem", jPanel1);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Chave");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Status");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Data Modificado");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Data Criação");

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
        jLabel9.setText("População Média");

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
        jBtPesquisarDatas.setText("Buscar");
        jBtPesquisarDatas.setToolTipText("Pesquisar dados cadastrados");
        jBtPesquisarDatas.setEnabled(false);
        jBtPesquisarDatas.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jBtPesquisarDatas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisarDatasActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Mês Referência");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Ano");

        jComboBoxMesReferencia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxMesReferencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));
        jComboBoxMesReferencia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxMesReferencia.setEnabled(false);

        jComboBoxAnoReferencia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxAnoReferencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "1900", "1901", "1902", "1903", "1904", "1905", "1906", "1907", "1908", "1909", "1910", "1911", "1912", "1913", "1914", "1915", "1916", "1917", "1918", "1919", "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", "2051", "2052", "2053", "2054", "2055", "2056", "2057", "2058", "2059", "2060", "2061", "2062", "2063", "2064", "2065", "2066", "2067", "2068", "2069", "2070", "2071", "2072", "2073", "2074", "2075", "2076", "2077", "2078", "2079", "2080", "2081", "2082", "2083", "2084", "2085", "2086", "2087", "2088", "2089", "2090", "2091", "2092", "2093", "2094", "2095", "2096", "2097", "2098", "2099", "2100", "2101", "2102", "2103", "2104", "2105", "2106", "2107", "2108", "2109", "2110", "2111", "2112", "2113", "2114", "2115", "2116", "2117", "2118", "2119", "2120", "2121", "2122", "2123", "2124", "2125", "2126", "2127", "2128", "2129", "2130", "2131", "2132", "2133", "2134", "2135", "2136", "2137", "2138", "2139", "2140", "2141", "2142", "2143", "2144", "2145", "2146", "2147", "2148", "2149", "2150", "2151", "2152", "2153", "2154", "2155", "2156", "2157", "2158", "2159", "2160", "2161", "2162", "2163", "2164", "2165", "2166", "2167", "2168", "2169", "2170", "2171", "2172", "2173", "2174", "2175", "2176", " " }));
        jComboBoxAnoReferencia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxAnoReferencia.setEnabled(false);

        jLabel153.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel153.setForeground(new java.awt.Color(204, 0, 0));
        jLabel153.setText("*");

        jLabel155.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel155.setForeground(new java.awt.Color(204, 0, 0));
        jLabel155.setText("*");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDataPeriodoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel147)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel154)))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel148)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel152))
                            .addComponent(jDataPeriodoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(3, 3, 3)
                                .addComponent(jLabel153))
                            .addComponent(jComboBoxMesReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(3, 3, 3)
                                .addComponent(jLabel155))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jComboBoxAnoReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(jBtPesquisarDatas))))
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
                            .addComponent(jDataAtualizacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel146)
                                .addComponent(jMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel9Layout.createSequentialGroup()
                                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jIdFunc, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addGap(3, 3, 3)
                                    .addComponent(jBtPesquisarColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(3, 3, 3)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jDepartamento)
                                .addGroup(jPanel9Layout.createSequentialGroup()
                                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel9Layout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel151))
                                        .addComponent(jLabel16)
                                        .addComponent(jColaboradorResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(1, 1, 1))))
                        .addComponent(jScrollPane2)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel9Layout.createSequentialGroup()
                                    .addComponent(jUnidadePrisional, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPopulacaoAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)))))
                .addGap(10, 10, 10))
        );

        jPanel9Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jDataAtualizacao, jPopulacaoAtual});

        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(5, 5, 5)
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
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel9))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
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
                        .addComponent(jLabel152))
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jLabel153)
                        .addComponent(jLabel155)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtPesquisarDatas)
                    .addComponent(jComboBoxAnoReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxMesReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataPeriodoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataPeriodoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel9Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jChave, jDataAtualizacao, jDataCriacao, jStatus});

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel143.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel143.setForeground(new java.awt.Color(0, 0, 204));
        jLabel143.setText("ATENÇÃO: A população informada tem como base o range da data inicial e final.");

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
                    .addComponent(jLabel143, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
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
        jAtendimentoPsiPreso.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jAtendimentoPsiPreso.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jAtendimentoPsiPreso.setText("0");
        jAtendimentoPsiPreso.setEnabled(false);

        jAtendimentoPsiFamilaPreso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAtendimentoPsiFamilaPreso.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
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
        jNumeroDiasVisitas.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jNumeroDiasVisitas.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jNumeroDiasVisitas.setText("0");
        jNumeroDiasVisitas.setEnabled(false);

        jNumeroVistantesInternos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNumeroVistantesInternos.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jNumeroVistantesInternos.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jNumeroVistantesInternos.setText("0");
        jNumeroVistantesInternos.setEnabled(false);

        jMediaVisitasDia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMediaVisitasDia.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jMediaVisitasDia.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jMediaVisitasDia.setText("0");
        jMediaVisitasDia.setEnabled(false);

        jMediaVisitasInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMediaVisitasInterno.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jMediaVisitasInterno.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jMediaVisitasInterno.setText("0");
        jMediaVisitasInterno.setEnabled(false);

        jNumeroCriancasVisitas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNumeroCriancasVisitas.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jNumeroCriancasVisitas.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jNumeroCriancasVisitas.setText("0");
        jNumeroCriancasVisitas.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Preso identificados civilmente");

        jPresoIdentCivil.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPresoIdentCivil.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jPresoIdentCivil.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPresoIdentCivil.setText("0");
        jPresoIdentCivil.setEnabled(false);

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
                    .addComponent(jLabel119)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPresoIdentCivil)
                    .addComponent(jNumeroCriancasVisitas, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(jMediaVisitasInterno, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(jMediaVisitasDia, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(jNumeroVistantesInternos, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(jNumeroDiasVisitas, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(jAtendimentoPsiFamilaPreso)
                    .addComponent(jAtendimentoPsiPreso, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel13Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jAtendimentoPsiFamilaPreso, jAtendimentoPsiPreso, jMediaVisitasDia, jMediaVisitasInterno, jNumeroCriancasVisitas, jNumeroDiasVisitas, jNumeroVistantesInternos, jPresoIdentCivil});

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel13)
                    .addComponent(jPresoIdentCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel13Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jAtendimentoPsiFamilaPreso, jAtendimentoPsiPreso, jMediaVisitasDia, jMediaVisitasInterno, jNumeroCriancasVisitas, jNumeroDiasVisitas, jNumeroVistantesInternos});

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 482, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 156, Short.MAX_VALUE)
        );

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
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
                    .addComponent(jLabel29)
                    .addComponent(jLabel28)
                    .addComponent(jLabel19)
                    .addComponent(jLabel21)
                    .addComponent(jLabel24)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27)
                    .addComponent(jLabel22)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jAlimentaServidaEmpContCafe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(jAlimentaServidaEmpContAlmoco, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jAlimentaServidaEmpContJantar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jAlimentaServidaEmpContLanche, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jAlimentaServidaServContCafe, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jAlimentaServidaServContAlmoco, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jAlimentaServidaServContJantar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jAlimentaServidaServContLanche, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLanchesServidoVisita))
                .addContainerGap())
        );
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
                .addContainerGap(151, Short.MAX_VALUE))
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
                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel20)
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
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

        jAtendimentoMedicoPsiquiatrico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAtendimentoMedicoPsiquiatrico.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jAtendimentoMedicoPsiquiatrico.setText("0");
        jAtendimentoMedicoPsiquiatrico.setToolTipText("Atendimento médico psiquiátrico");
        jAtendimentoMedicoPsiquiatrico.setEnabled(false);

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
                        .addComponent(jAtendimentoMedicoPsiquiatrico, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 249, Short.MAX_VALUE)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPresoDoencaInfecto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jAtendimentoMedClinico, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jControleDiabetes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jControlHipertensao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

        jPanel22Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jAtendimentoEnfermagem, jAtendimentoMedClinico, jAtendimentoMedicoPsiquiatrico, jAtendimentoOdontologicos, jAtendimentoPsicologico, jControlHipertensao, jControleDiabetes, jPresoDoencaInfecto, jPresosVacinados, jProcedimentoOdontologico, jTratamentoAgravDiaginostico});

        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel35)
                            .addComponent(jAtendimentoMedicoPsiquiatrico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jAtendimentoEnfermagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel37)
                            .addComponent(jProcedimentoOdontologico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel38)
                            .addComponent(jAtendimentoPsicologico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
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
                    .addComponent(jPresosVacinados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(204, 0, 0));
        jLabel44.setText("Aspectos relacionados a sexualidades");
        jLabel44.setToolTipText("Aspectos relacionados a sexualidades");

        jAspectosSexual.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAspectosSexual.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jAspectosSexual.setText("0");
        jAspectosSexual.setToolTipText("Aspectos relacionados a sexualidades");
        jAspectosSexual.setEnabled(false);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel44)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jAspectosSexual, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel44)
                    .addComponent(jAspectosSexual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
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
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel25Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPresoSentencaMatFreqEF, jPresoSentenciadoEF});

        jPanel48.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true))));

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 303, Short.MAX_VALUE)
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
                    .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
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
        jLabel62.setText("Sabonete (90 Gr)");

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

        jLabel150.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel150.setText("Colher plástica");

        jColherPlastica.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jColherPlastica.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jColherPlastica.setText("0");
        jColherPlastica.setEnabled(false);

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                            .addComponent(jLabel64)
                                            .addComponent(jLabel65))
                                        .addGap(92, 92, 92)
                                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jCamisa, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jBermuda, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(jPanel28Layout.createSequentialGroup()
                                    .addComponent(jLabel51)
                                    .addGap(106, 106, 106)
                                    .addComponent(jCobertor, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addComponent(jLabel56)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCaneca, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel69, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel54, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel62, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jUniformeCompleto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jToalha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSabonete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 5, Short.MAX_VALUE))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel28Layout.createSequentialGroup()
                                    .addComponent(jLabel61)
                                    .addGap(52, 52, 52)
                                    .addComponent(jSabaoPo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel28Layout.createSequentialGroup()
                                    .addComponent(jLabel66)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jCuecas, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                                    .addComponent(jChinelos, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel52)
                                    .addComponent(jLabel150))
                                .addGap(122, 122, 122)
                                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jColchao, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                                    .addComponent(jColherPlastica))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel28Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jAbsorvente, jAparelhoBarbear, jBermuda, jCamisa, jCaneca, jChinelos, jCobertor, jColchao, jCremeDental, jCuecas, jDesodorante, jEscovaDente, jLencol, jPapelHigienico, jPote, jSabaoPo, jSabonete, jToalha, jUniformeCompleto});

        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel57)
                    .addComponent(jAparelhoBarbear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel62)
                    .addComponent(jSabonete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel60)
                    .addComponent(jAbsorvente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54)
                    .addComponent(jToalha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel64)
                    .addComponent(jBermuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel69)
                    .addComponent(jUniformeCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel65)
                    .addComponent(jCamisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jCaneca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56))
                .addGap(3, 3, 3)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel51)
                    .addComponent(jCobertor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel150)
                    .addComponent(jColherPlastica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel52)
                    .addComponent(jColchao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCuecas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel66))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel28Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jAbsorvente, jAparelhoBarbear, jBermuda, jCamisa, jCaneca, jChinelos, jCobertor, jColchao, jCremeDental, jCuecas, jDesodorante, jEscovaDente, jLencol, jPapelHigienico, jPote, jSabaoPo, jSabonete, jToalha, jUniformeCompleto});

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        jLabel77.setForeground(new java.awt.Color(204, 0, 0));
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
                .addGap(3, 3, 3))
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

        jNumeroOcorrenciaPessoasFeridaMortas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNumeroOcorrenciaPessoasFeridaMortas.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jNumeroOcorrenciaPessoasFeridaMortas.setText("0");
        jNumeroOcorrenciaPessoasFeridaMortas.setEnabled(false);

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

        jNumeroOcorrenciaFuga.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNumeroOcorrenciaFuga.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jNumeroOcorrenciaFuga.setText("0");
        jNumeroOcorrenciaFuga.setEnabled(false);

        jNumeroInterFuncVeiculosTP.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNumeroInterFuncVeiculosTP.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jNumeroInterFuncVeiculosTP.setText("0");
        jNumeroInterFuncVeiculosTP.setEnabled(false);

        jLabel78.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(204, 0, 0));
        jLabel78.setText(" Nº de ocorrência de  fugas");
        jLabel78.setToolTipText(" Nº de ocorrência de  fugas");

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

        jLabel157.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel157.setForeground(new java.awt.Color(204, 0, 0));
        jLabel157.setText("Nº de ocorrência de tentativa de fugas");

        jNumeroOcorrenciaTentaFuga.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNumeroOcorrenciaTentaFuga.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jNumeroOcorrenciaTentaFuga.setText("0");
        jNumeroOcorrenciaTentaFuga.setToolTipText("Nº Ocorrência Tentavia Fuga");
        jNumeroOcorrenciaTentaFuga.setEnabled(false);

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
                    .addComponent(jLabel89)
                    .addComponent(jLabel78)
                    .addComponent(jLabel157))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jNumeroHorasTVCFTV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jNumeroOcorrenciaPessoasFeridaMortas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jNumeroFraldasEntreguePortaria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jNumeroOcorrenciaPessoasRefem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jNumeroOcorrenciaPessoaFerida, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jNumeroOcorrenciaRebeliao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jNumeroInterFuncVeiculosTP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jNumeroAbsorEntregueVisitas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jNumeroFalhasGerador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jNumeroHorasBloqueador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jNumeroDiasSemScannerCorpo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jNumeroDiasIntMetaPortatil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jNumeroOcorrenciaFuga, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jNumeroOcorrenciaTentaFuga, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel43Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jNumeroAbsorEntregueVisitas, jNumeroDiasIntMetaPortatil, jNumeroDiasSemScannerCorpo, jNumeroFalhasGerador, jNumeroFraldasEntreguePortaria, jNumeroHorasBloqueador, jNumeroHorasTVCFTV, jNumeroInterFuncVeiculosTP, jNumeroOcorrenciaFuga, jNumeroOcorrenciaPessoaFerida, jNumeroOcorrenciaPessoasFeridaMortas, jNumeroOcorrenciaPessoasRefem, jNumeroOcorrenciaRebeliao});

        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel43Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jNumeroOcorrenciaTentaFuga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel157))
                .addGap(2, 2, 2)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel78)
                    .addComponent(jNumeroOcorrenciaFuga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(jNumeroOcorrenciaPessoasFeridaMortas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(jNumeroInterFuncVeiculosTP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jPanel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, 288, Short.MAX_VALUE))
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
        jLabel95.setText("Progressão de Regime deferido");
        jLabel95.setToolTipText("Progressão de Regime Deferido");

        jLabel96.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel96.setText("Saída Temporárias deferidas");
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

        jLabel156.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel156.setForeground(new java.awt.Color(204, 0, 0));
        jLabel156.setText("Condicional Deferida");

        jCondicionalDeferida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCondicionalDeferida.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCondicionalDeferida.setText("0");
        jCondicionalDeferida.setEnabled(false);

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addGap(11, 11, 11)
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
                            .addComponent(jLabel106))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jIndultosDeferidos, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRemissaoPenaRequerida, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLiberdadeProvDeferida, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jIndultosRequeridos, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRemissaoPenaDeferida, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel42Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel108)
                        .addGap(3, 3, 3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel42Layout.createSequentialGroup()
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel111, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel42Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel112, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel113, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel42Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel114, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel115, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel109, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel110, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(4, 4, 4)))
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLaudosPsiqEmitidos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLaudoPsicoEmitidos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jHabeasCorpusDeferido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jHabeasCorpusImpetrados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSaidaTempRequerida, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jProgressaoRegRequerido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCondicionalDeferida, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCondicionalRequerida, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel42Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel156)
                .addGap(64, 64, 64))
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel107)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel42Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jAlvarSolRecebeUni, jAudienciaCumpridas, jAudienciaProvocadas, jCondicionalRequerida, jHabeasCorpusDeferido, jHabeasCorpusImpetrados, jIndultosDeferidos, jIndultosRequeridos, jJuriPopular, jJuriPopularCumprido, jLaudoPsicoEmitidos, jLaudosPsiqEmitidos, jLiberdadeProvDeferida, jLiberdadeProvRequerida, jProgressaoRegRequerido, jRemissaoPenaDeferida, jRemissaoPenaRequerida, jSaidaTempRequerida, jTP});

        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel97)
                    .addComponent(jAlvarSolRecebeUni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel108)
                    .addComponent(jCondicionalRequerida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel98)
                    .addComponent(jAudienciaProvocadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel156)
                    .addComponent(jCondicionalDeferida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel99)
                    .addComponent(jAudienciaCumpridas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel109)
                    .addComponent(jProgressaoRegRequerido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel100)
                    .addComponent(jJuriPopular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel110)
                    .addComponent(jSaidaTempRequerida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel101)
                    .addComponent(jJuriPopularCumprido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel111)
                    .addComponent(jHabeasCorpusImpetrados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel102)
                            .addComponent(jLabel112)
                            .addComponent(jHabeasCorpusDeferido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel42Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLiberdadeProvRequerida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel103)
                    .addComponent(jLiberdadeProvDeferida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel113)
                    .addComponent(jLaudoPsicoEmitidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel104)
                    .addComponent(jIndultosRequeridos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel114)
                    .addComponent(jLaudosPsiqEmitidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel105)
                    .addComponent(jIndultosDeferidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel115)
                    .addComponent(jTP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel106)
                    .addComponent(jRemissaoPenaRequerida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel107)
                    .addComponent(jRemissaoPenaDeferida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel42Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jAlvarSolRecebeUni, jAudienciaCumpridas, jAudienciaProvocadas, jCondicionalRequerida, jHabeasCorpusDeferido, jHabeasCorpusImpetrados, jIndultosDeferidos, jIndultosRequeridos, jJuriPopular, jJuriPopularCumprido, jLaudoPsicoEmitidos, jLaudosPsiqEmitidos, jLiberdadeProvDeferida, jLiberdadeProvRequerida, jProgressaoRegRequerido, jRemissaoPenaDeferida, jRemissaoPenaRequerida, jSaidaTempRequerida, jTP});

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
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
                .addComponent(jLabel122)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTriagemAtendInernos, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel122)
                    .addComponent(jTriagemAtendInernos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        jLabel123.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel123.setForeground(new java.awt.Color(204, 0, 0));
        jLabel123.setText("Ocupação com atividade recreativa/religiosa do interno");
        jLabel123.setToolTipText("Ocupação com atividade recreativa /religiosa do interno");

        jOcupacaoAtiviRecreaReligiosa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jOcupacaoAtiviRecreaReligiosa.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jOcupacaoAtiviRecreaReligiosa.setText("0");
        jOcupacaoAtiviRecreaReligiosa.setEnabled(false);

        jLabel124.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel124.setForeground(new java.awt.Color(204, 0, 0));
        jLabel124.setText("Preso em atividade de artes plásticas");
        jLabel124.setToolTipText("Preso em atividade de artes plásticas");

        jPresoAtiviArtesPlasticas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPresoAtiviArtesPlasticas.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPresoAtiviArtesPlasticas.setText("0");
        jPresoAtiviArtesPlasticas.setEnabled(false);

        jLabel125.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel125.setForeground(new java.awt.Color(204, 0, 0));
        jLabel125.setText("Preso em atividade de literatura");
        jLabel125.setToolTipText("Preso em atividade de literatura");

        jPresoAtiviLiteraria.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPresoAtiviLiteraria.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPresoAtiviLiteraria.setText("0");
        jPresoAtiviLiteraria.setEnabled(false);

        jLabel126.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel126.setForeground(new java.awt.Color(204, 0, 0));
        jLabel126.setText("Preso em atividade de canto, teatro e cinema");
        jLabel126.setToolTipText("Preso em atividade de canto, teatro e cinema");

        jPresoAtiviCantoTeatro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPresoAtiviCantoTeatro.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPresoAtiviCantoTeatro.setText("0");
        jPresoAtiviCantoTeatro.setEnabled(false);

        jLabel127.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel127.setForeground(new java.awt.Color(204, 0, 0));
        jLabel127.setText("Preso matriculado cursos profissionalizantes c/ cert. profissional");
        jLabel127.setToolTipText("Preso matriculado nos cursos profissionalizantes com certificação profissional");

        jLabel128.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel128.setForeground(new java.awt.Color(204, 0, 0));
        jLabel128.setText("Preso certificado em cursos profissionalizantes");
        jLabel128.setToolTipText("Preso certificado em cursos profissionalizantes");

        jMatriculadoCursoProfissionalizante.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMatriculadoCursoProfissionalizante.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jMatriculadoCursoProfissionalizante.setText("0");
        jMatriculadoCursoProfissionalizante.setEnabled(false);

        jCertificadoCursoProfissionalizante.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCertificadoCursoProfissionalizante.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCertificadoCursoProfissionalizante.setText("0");
        jCertificadoCursoProfissionalizante.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 0, 0));
        jLabel14.setText("Preso em atividade religiosa");

        jPresoAtiviReligiosa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPresoAtiviReligiosa.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jPresoAtiviReligiosa.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPresoAtiviReligiosa.setText("0");
        jPresoAtiviReligiosa.setEnabled(false);

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(204, 0, 0));
        jLabel49.setText("Preso em atividade de prática de esportes");

        jPresoAtiviPraticaEsportiva.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPresoAtiviPraticaEsportiva.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPresoAtiviPraticaEsportiva.setText("0");
        jPresoAtiviPraticaEsportiva.setEnabled(false);

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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel47Layout.createSequentialGroup()
                        .addComponent(jLabel123)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jOcupacaoAtiviRecreaReligiosa, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel47Layout.createSequentialGroup()
                        .addComponent(jLabel124)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPresoAtiviArtesPlasticas, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel47Layout.createSequentialGroup()
                        .addComponent(jLabel125)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPresoAtiviLiteraria, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel47Layout.createSequentialGroup()
                        .addComponent(jLabel126)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPresoAtiviCantoTeatro, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel47Layout.createSequentialGroup()
                        .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel127)
                            .addComponent(jLabel128))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCertificadoCursoProfissionalizante, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jMatriculadoCursoProfissionalizante, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel47Layout.createSequentialGroup()
                        .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel130)
                            .addComponent(jLabel14)
                            .addComponent(jLabel49))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPresoAtiviPraticaEsportiva)
                            .addComponent(jPresoAtiviReligiosa)
                            .addComponent(jPresoAtiviLaboralNaoRemunera, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))))
                .addContainerGap())
        );

        jPanel47Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jCertificadoCursoProfissionalizante, jMatriculadoCursoProfissionalizante, jOcupacaoAtiviRecreaReligiosa, jPresoAtiviArtesPlasticas, jPresoAtiviCantoTeatro, jPresoAtiviLaboralNaoRemunera, jPresoAtiviLiteraria, jPresoAtiviPraticaEsportiva, jPresoAtiviReligiosa, jPresoSentecaAtivLaboralRemun});

        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel47Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel127)
                    .addComponent(jMatriculadoCursoProfissionalizante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel128)
                    .addComponent(jCertificadoCursoProfissionalizante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel123)
                    .addComponent(jOcupacaoAtiviRecreaReligiosa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel124)
                    .addComponent(jPresoAtiviArtesPlasticas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel125)
                    .addComponent(jPresoAtiviLiteraria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel126)
                    .addComponent(jPresoAtiviCantoTeatro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel129)
                    .addComponent(jPresoSentecaAtivLaboralRemun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPresoAtiviLaboralNaoRemunera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel130))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel14)
                    .addComponent(jPresoAtiviReligiosa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel49)
                    .addComponent(jPresoAtiviPraticaEsportiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(85, Short.MAX_VALUE))
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
                    .addComponent(jPanel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
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
                .addContainerGap(298, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addComponent(jPanel61, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("AFI", jPanel34);

        jPanel58.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel142.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel142.setText("08 - AL - ASSISTÊNCIA LABORAL");

        jTotal_ASSIS_LABORAL.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTotal_ASSIS_LABORAL.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTotal_ASSIS_LABORAL.setText("0");
        jTotal_ASSIS_LABORAL.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTotal_ASSIS_LABORAL.setEnabled(false);
        jTotal_ASSIS_LABORAL.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel58Layout = new javax.swing.GroupLayout(jPanel58);
        jPanel58.setLayout(jPanel58Layout);
        jPanel58Layout.setHorizontalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel142, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTotal_ASSIS_LABORAL, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel58Layout.setVerticalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel58Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel142)
                    .addComponent(jTotal_ASSIS_LABORAL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        jTotal_MATERIAL_INTERNO.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTotal_MATERIAL_INTERNO.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTotal_MATERIAL_INTERNO.setText("0");
        jTotal_MATERIAL_INTERNO.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTotal_MATERIAL_INTERNO.setEnabled(false);
        jTotal_MATERIAL_INTERNO.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel55Layout = new javax.swing.GroupLayout(jPanel55);
        jPanel55.setLayout(jPanel55Layout);
        jPanel55Layout.setHorizontalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel139)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTotal_MATERIAL_INTERNO, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel55Layout.setVerticalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel55Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel139)
                    .addComponent(jTotal_MATERIAL_INTERNO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jPanel59.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jBtCalcularTotais.setForeground(new java.awt.Color(204, 0, 0));
        jBtCalcularTotais.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/calculator_edit.png"))); // NOI18N
        jBtCalcularTotais.setText("Calcular Totais");
        jBtCalcularTotais.setToolTipText("Atualizar das Atendimento");
        jBtCalcularTotais.setEnabled(false);
        jBtCalcularTotais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCalcularTotaisActionPerformed(evt);
            }
        });

        jBtAtualizarDatas.setForeground(new java.awt.Color(0, 102, 0));
        jBtAtualizarDatas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/calendar_view_month.png"))); // NOI18N
        jBtAtualizarDatas.setText("Atualizar Datas");
        jBtAtualizarDatas.setToolTipText("Atualizar das Atendimento");
        jBtAtualizarDatas.setEnabled(false);
        jBtAtualizarDatas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAtualizarDatasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel59Layout = new javax.swing.GroupLayout(jPanel59);
        jPanel59.setLayout(jPanel59Layout);
        jPanel59Layout.setHorizontalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtCalcularTotais)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAtualizarDatas)
                .addContainerGap())
        );

        jPanel59Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAtualizarDatas, jBtCalcularTotais});

        jPanel59Layout.setVerticalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtCalcularTotais)
                    .addComponent(jBtAtualizarDatas))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel51.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel135.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel135.setText("02 - AFV - ALIMENTAÇÃO FORNECIDAS AOS SERVIDORES");

        jTotal_ALI_FOR_SERVIDORES.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTotal_ALI_FOR_SERVIDORES.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTotal_ALI_FOR_SERVIDORES.setText("0");
        jTotal_ALI_FOR_SERVIDORES.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTotal_ALI_FOR_SERVIDORES.setEnabled(false);
        jTotal_ALI_FOR_SERVIDORES.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel51Layout = new javax.swing.GroupLayout(jPanel51);
        jPanel51.setLayout(jPanel51Layout);
        jPanel51Layout.setHorizontalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel135)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTotal_ALI_FOR_SERVIDORES, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel51Layout.setVerticalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel51Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel135)
                    .addComponent(jTotal_ALI_FOR_SERVIDORES, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jPanel56.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel140.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel140.setText("06 - ARI - ATIVIDADES RELIGIOSAS AO INTERNO");

        jTotal_ATI_RECREATIVA_RELIGIOSA.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTotal_ATI_RECREATIVA_RELIGIOSA.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTotal_ATI_RECREATIVA_RELIGIOSA.setText("0");
        jTotal_ATI_RECREATIVA_RELIGIOSA.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTotal_ATI_RECREATIVA_RELIGIOSA.setEnabled(false);
        jTotal_ATI_RECREATIVA_RELIGIOSA.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel56Layout = new javax.swing.GroupLayout(jPanel56);
        jPanel56.setLayout(jPanel56Layout);
        jPanel56Layout.setHorizontalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel56Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel140)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTotal_ATI_RECREATIVA_RELIGIOSA, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel56Layout.setVerticalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel56Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel140)
                    .addComponent(jTotal_ATI_RECREATIVA_RELIGIOSA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jPanel52.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel136.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel136.setText("03 - ASI - ATENDIMENTO A SAÚDE DO INTERNO");

        jTotal_ATE_SAUDE_INTERNO.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTotal_ATE_SAUDE_INTERNO.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTotal_ATE_SAUDE_INTERNO.setText("0");
        jTotal_ATE_SAUDE_INTERNO.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTotal_ATE_SAUDE_INTERNO.setEnabled(false);
        jTotal_ATE_SAUDE_INTERNO.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel52Layout = new javax.swing.GroupLayout(jPanel52);
        jPanel52.setLayout(jPanel52Layout);
        jPanel52Layout.setHorizontalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel136, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTotal_ATE_SAUDE_INTERNO, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel52Layout.setVerticalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel52Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel136)
                    .addComponent(jTotal_ATE_SAUDE_INTERNO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jPanel57.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel141.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel141.setText("07 - AJ - ASSISTÊNCIA JURÍDICA");

        jTotal_ATEND_JURIDICO.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTotal_ATEND_JURIDICO.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTotal_ATEND_JURIDICO.setText("0");
        jTotal_ATEND_JURIDICO.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTotal_ATEND_JURIDICO.setEnabled(false);
        jTotal_ATEND_JURIDICO.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel57Layout = new javax.swing.GroupLayout(jPanel57);
        jPanel57.setLayout(jPanel57Layout);
        jPanel57Layout.setHorizontalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel141, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTotal_ATEND_JURIDICO, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel57Layout.setVerticalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel57Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel141)
                    .addComponent(jTotal_ATEND_JURIDICO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jPanel49.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel134.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel134.setText("01 - ASSI - ATENDIMENTO SERVIÇO SOCIAL AO INTERNO");

        jTotal_ATE_SOCIAL.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTotal_ATE_SOCIAL.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jTotal_ATE_SOCIAL.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTotal_ATE_SOCIAL.setText("0");
        jTotal_ATE_SOCIAL.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTotal_ATE_SOCIAL.setEnabled(false);
        jTotal_ATE_SOCIAL.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel134)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTotal_ATE_SOCIAL, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel49Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel134)
                    .addComponent(jTotal_ATE_SOCIAL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jPanel53.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel137.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel137.setText("04 - AEI - ATENDIMENTO EDUCACIONAL AO INTERNO");

        jTotal_ATE_EDUCACIONAL.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTotal_ATE_EDUCACIONAL.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTotal_ATE_EDUCACIONAL.setText("0");
        jTotal_ATE_EDUCACIONAL.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTotal_ATE_EDUCACIONAL.setEnabled(false);
        jTotal_ATE_EDUCACIONAL.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel53Layout = new javax.swing.GroupLayout(jPanel53);
        jPanel53.setLayout(jPanel53Layout);
        jPanel53Layout.setHorizontalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel137)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTotal_ATE_EDUCACIONAL, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel53Layout.setVerticalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel53Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel137)
                    .addComponent(jTotal_ATE_EDUCACIONAL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jPanel62.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel145.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel145.setText("09 - AFI - ALIMENTAÇÃO FORNECEDIDAS AOS INTERNOS");

        jTotal_ALIM_FOR_INTERNOS.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTotal_ALIM_FOR_INTERNOS.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jTotal_ALIM_FOR_INTERNOS.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTotal_ALIM_FOR_INTERNOS.setText("0");
        jTotal_ALIM_FOR_INTERNOS.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTotal_ALIM_FOR_INTERNOS.setEnabled(false);
        jTotal_ALIM_FOR_INTERNOS.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel62Layout = new javax.swing.GroupLayout(jPanel62);
        jPanel62.setLayout(jPanel62Layout);
        jPanel62Layout.setHorizontalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel62Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel145)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTotal_ALIM_FOR_INTERNOS, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel62Layout.setVerticalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel62Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel145)
                    .addComponent(jTotal_ALIM_FOR_INTERNOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(3, 3, 3)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        setBounds(300, 30, 525, 504);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesqNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNomeActionPerformed
        // TODO add your handling code here:listaAtividadeCola
        flag = 1;
        Integer row0 = jTabelaAtividadesUnidade.getModel().getRowCount();
        if (jPesqNome.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Infome o nome do colaborador para pesquisa.");
        } else {
            DefaultTableModel dadosDestino = (DefaultTableModel) jTabelaAtividadesUnidade.getModel();
            try {
                for (AtividadesMensalRealizadaUnidades dd : listaAtividadeCola.read()) {
                    if (row0 == 0) {
                        jtotalRegistros.setText(Integer.toString(pTOTAL_REGISTROS_ATIVIDADES)); // Converter inteiro em string para exibir na tela                                
                    }
                    pDATA_PESQUISA_TABELA = String.valueOf(dd.getDataCriacao());
                    String dia = pDATA_PESQUISA_TABELA.substring(8, 10);
                    String mes = pDATA_PESQUISA_TABELA.substring(5, 7);
                    String ano = pDATA_PESQUISA_TABELA.substring(0, 4);
                    pDATA_PESQUISA_TABELA = dia + "/" + mes + "/" + ano;
                    dadosDestino.addRow(new Object[]{dd.getChave(), pDATA_PESQUISA_TABELA, dd.getStatus(), dd.getMesReferencia(), dd.getAnoReferencia(), dd.getUnidadePrisional()});
                    // BARRA DE ROLAGEM HORIZONTAL
                    jTabelaAtividadesUnidade.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                    // ALINHAR TEXTO DA TABELA CENTRALIZADO
                    DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                    centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                    //
                    jTabelaAtividadesUnidade.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                    jTabelaAtividadesUnidade.getColumnModel().getColumn(1).setCellRenderer(centralizado);
                    jTabelaAtividadesUnidade.getColumnModel().getColumn(2).setCellRenderer(centralizado);
                    jTabelaAtividadesUnidade.getColumnModel().getColumn(4).setCellRenderer(centralizado);
                }
            } catch (Exception ex) {
                Logger.getLogger(TelaAtividadesMensalUnidade.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jBtPesqNomeActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        flag = 1;
        Integer row0 = jTabelaAtividadesUnidade.getModel().getRowCount();
        if (evt.getStateChange() == evt.SELECTED) {
            DefaultTableModel dadosDestino = (DefaultTableModel) jTabelaAtividadesUnidade.getModel();
            try {
                for (AtividadesMensalRealizadaUnidades dd : listaTodosReg.read()) {
                    if (row0 == 0) {
                        jtotalRegistros.setText(Integer.toString(pTOTAL_REGISTROS_ATIVIDADES)); // Converter inteiro em string para exibir na tela                                
                    }
                    pDATA_PESQUISA_TABELA = String.valueOf(dd.getDataCriacao());
                    String dia = pDATA_PESQUISA_TABELA.substring(8, 10);
                    String mes = pDATA_PESQUISA_TABELA.substring(5, 7);
                    String ano = pDATA_PESQUISA_TABELA.substring(0, 4);
                    pDATA_PESQUISA_TABELA = dia + "/" + mes + "/" + ano;
                    dadosDestino.addRow(new Object[]{dd.getChave(), pDATA_PESQUISA_TABELA, dd.getStatus(), dd.getMesReferencia(), dd.getAnoReferencia(), dd.getUnidadePrisional()});
                    // BARRA DE ROLAGEM HORIZONTAL
                    jTabelaAtividadesUnidade.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                    // ALINHAR TEXTO DA TABELA CENTRALIZADO
                    DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                    centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                    //
                    jTabelaAtividadesUnidade.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                    jTabelaAtividadesUnidade.getColumnModel().getColumn(1).setCellRenderer(centralizado);
                    jTabelaAtividadesUnidade.getColumnModel().getColumn(2).setCellRenderer(centralizado);
                    jTabelaAtividadesUnidade.getColumnModel().getColumn(4).setCellRenderer(centralizado);
                }
            } catch (Exception ex) {
                Logger.getLogger(TelaAtividadesMensalUnidade.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            // APAGAR TODOS OS REGISTROS DA TABELA COPIADA
            DefaultTableModel tblRemove = (DefaultTableModel) jTabelaAtividadesUnidade.getModel();
            if (tblRemove.getRowCount() > 0) {
                for (int i = 0; i <= tblRemove.getRowCount(); i++) {
                    tblRemove.removeRow(i);
                    tblRemove.setRowCount(0);
                    if (tblRemove.getRowCount() < i) {
                        tblRemove.removeRow(i);
                        tblRemove.setRowCount(0);
                    }
                }
            }
            pTOTAL_REGISTROS_ATIVIDADES = 0;
            jtotalRegistros.setText("");
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jBtPesqCodigoAtividadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqCodigoAtividadeActionPerformed
        // TODO add your handling code here:
        flag = 1;
        Integer row0 = jTabelaAtividadesUnidade.getModel().getRowCount();
        if (jCodigoAtividade.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe o código do colaborador para pesquisa.");
        } else {
            DefaultTableModel dadosDestino = (DefaultTableModel) jTabelaAtividadesUnidade.getModel();
            try {
                for (AtividadesMensalRealizadaUnidades dd : listaAtividadeCodigo.read()) {
                    if (row0 == 0) {
                        jtotalRegistros.setText(Integer.toString(pTOTAL_REGISTROS_ATIVIDADES)); // Converter inteiro em string para exibir na tela                                
                    }
                    pDATA_PESQUISA_TABELA = String.valueOf(dd.getDataCriacao());
                    String dia = pDATA_PESQUISA_TABELA.substring(8, 10);
                    String mes = pDATA_PESQUISA_TABELA.substring(5, 7);
                    String ano = pDATA_PESQUISA_TABELA.substring(0, 4);
                    pDATA_PESQUISA_TABELA = dia + "/" + mes + "/" + ano;
                    dadosDestino.addRow(new Object[]{dd.getChave(), pDATA_PESQUISA_TABELA, dd.getStatus(), dd.getMesReferencia(), dd.getAnoReferencia(), dd.getUnidadePrisional()});
                    // BARRA DE ROLAGEM HORIZONTAL
                    jTabelaAtividadesUnidade.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                    // ALINHAR TEXTO DA TABELA CENTRALIZADO
                    DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                    centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                    //
                    jTabelaAtividadesUnidade.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                    jTabelaAtividadesUnidade.getColumnModel().getColumn(1).setCellRenderer(centralizado);
                    jTabelaAtividadesUnidade.getColumnModel().getColumn(2).setCellRenderer(centralizado);
                    jTabelaAtividadesUnidade.getColumnModel().getColumn(4).setCellRenderer(centralizado);
                }
            } catch (Exception ex) {
                Logger.getLogger(TelaAtividadesMensalUnidade.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jBtPesqCodigoAtividadeActionPerformed

    private void jBtPesqDatasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqDatasActionPerformed
        // TODO add your handling code here:   listaAtividadeData    
        flag = 1;
        Integer row0 = jTabelaAtividadesUnidade.getModel().getRowCount();
        if (jDataPesqInicial.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Informe a data inicial para pesquisa.");
            jDataPesqInicial.requestFocus();
        } else if (jDataPesFinal.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Informe a data final para pesquisa.");
            jDataPesFinal.requestFocus();
        } else if (jDataPesqInicial.getDate().after(jDataPesFinal.getDate())) {
            JOptionPane.showMessageDialog(rootPane, "Data Inicial não pode ser maior que data final");
        } else {
            DefaultTableModel dadosDestino = (DefaultTableModel) jTabelaAtividadesUnidade.getModel();
            try {
                for (AtividadesMensalRealizadaUnidades dd : listaTodosReg.read()) {
                    if (row0 == 0) {
                        jtotalRegistros.setText(Integer.toString(pTOTAL_REGISTROS_ATIVIDADES)); // Converter inteiro em string para exibir na tela                                
                    }
                    pDATA_PESQUISA_TABELA = String.valueOf(dd.getDataCriacao());
                    String dia = pDATA_PESQUISA_TABELA.substring(8, 10);
                    String mes = pDATA_PESQUISA_TABELA.substring(5, 7);
                    String ano = pDATA_PESQUISA_TABELA.substring(0, 4);
                    pDATA_PESQUISA_TABELA = dia + "/" + mes + "/" + ano;
                    dadosDestino.addRow(new Object[]{dd.getChave(), pDATA_PESQUISA_TABELA, dd.getStatus(), dd.getMesReferencia(), dd.getAnoReferencia(), dd.getUnidadePrisional()});
                    // BARRA DE ROLAGEM HORIZONTAL
                    jTabelaAtividadesUnidade.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                    // ALINHAR TEXTO DA TABELA CENTRALIZADO
                    DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                    centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                    //
                    jTabelaAtividadesUnidade.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                    jTabelaAtividadesUnidade.getColumnModel().getColumn(1).setCellRenderer(centralizado);
                    jTabelaAtividadesUnidade.getColumnModel().getColumn(2).setCellRenderer(centralizado);
                    jTabelaAtividadesUnidade.getColumnModel().getColumn(4).setCellRenderer(centralizado);
                }
            } catch (Exception ex) {
                Logger.getLogger(TelaAtividadesMensalUnidade.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jBtPesqDatasActionPerformed

    private void jTabelaAtividadesUnidadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaAtividadesUnidadeMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String IdLanc = "" + jTabelaAtividadesUnidade.getValueAt(jTabelaAtividadesUnidade.getSelectedRow(), 0);
            jCodigoAtividade.setText(IdLanc);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            //
            bloquearHabilitarTodosCampos(!true, !true);
            limparTodosCampos();
            //
            try {
                for (AtividadesMensalRealizadaUnidades dd : listaSelecao.read()) {
                    //ABA MANUTENÇÃO
                    jChave.setText(String.valueOf(dd.getChave()));
                    jStatus.setText(dd.getStatus());
                    jDataCriacao.setDate(dd.getDataCriacao());
                    jDataAtualizacao.setDate(dd.getDataAtualizacao());
                    jUnidadePrisional.setText(dd.getUnidadePrisional());
                    jPopulacaoAtual.setText(String.valueOf(dd.getMediaPopulacao()));
                    jDataPeriodoInicial.setDate(dd.getDataPeriodoInicial());
                    jDataPeriodoFinal.setDate(dd.getDataPeriodoFinal());
                    jComboBoxMesReferencia.setSelectedItem((String) dd.getMesReferencia());
                    jComboBoxAnoReferencia.setSelectedItem((String) dd.getAnoReferencia());
                    jIdFunc.setText(String.valueOf(dd.getIdFunc()));
                    jColaboradorResponsavel.setText(dd.getColaboradorResponsavel());
                    jMatricula.setText(dd.getMatricula());
                    jDepartamento.setText(dd.getDepartamento());
                    jObservacao.setText(dd.getObservacao());
                    //ABA ASSI
                    jAtendimentoPsiPreso.setText(String.valueOf(dd.getAtendimentoPsiPreso()));
                    jAtendimentoPsiFamilaPreso.setText(String.valueOf(dd.getAtendimentoPsiFamilaPreso()));
                    jNumeroVistantesInternos.setText(String.valueOf(dd.getNumeroVistantesInternos()));
                    jNumeroCriancasVisitas.setText(String.valueOf(dd.getNumeroCriancasVisitas()));
                    jPresoIdentCivil.setText(String.valueOf(dd.getPresoIdentCivil()));
                    //ABA AFV
                    jLanchesServidoVisita.setText(String.valueOf(dd.getLanchesVisitantes()));
                    jAlimentaServidaEmpContCafe.setText(String.valueOf(dd.getCafeContratada()));
                    jAlimentaServidaEmpContAlmoco.setText(String.valueOf(dd.getAlmocoContratada()));
                    jAlimentaServidaEmpContJantar.setText(String.valueOf(dd.getJantarContratada()));
                    jAlimentaServidaEmpContLanche.setText(String.valueOf(dd.getLancheContratada()));
                    jAlimentaServidaServContCafe.setText(String.valueOf(dd.getCafeContratante()));
                    jAlimentaServidaServContAlmoco.setText(String.valueOf(dd.getAlmocoContratante()));
                    jAlimentaServidaServContJantar.setText(String.valueOf(dd.getJantarContratante()));
                    jAlimentaServidaServContLanche.setText(String.valueOf(dd.getLancheContratante()));
                    //ASI
                    jAtendimentoMedClinico.setText(String.valueOf(dd.getAtendimentoClinico()));
                    jAtendimentoMedicoPsiquiatrico.setText(String.valueOf(dd.getAtendimentoPsiquiatrico()));
                    jAtendimentoEnfermagem.setText(String.valueOf(dd.getAtendimentoEnfermagem()));
                    jProcedimentoOdontologico.setText(String.valueOf(dd.getProcedimentoOdontologico()));
                    jAtendimentoPsicologico.setText(String.valueOf(dd.getAtendimentoPsicologico()));
                    jTratamentoAgravDiaginostico.setText(String.valueOf(dd.getTratamentoAgravosPNAISP()));
                    jAtendimentoOdontologicos.setText(String.valueOf(dd.getSensibilizadoSaudeBucal()));
                    jPresoDoencaInfecto.setText(String.valueOf(dd.getSensibilizadoInfectocontagiosas()));
                    jControlHipertensao.setText(String.valueOf(dd.getSensibilizadoHipertensao()));
                    jControleDiabetes.setText(String.valueOf(dd.getSensibilizadoDiabetes()));
                    jAspectosSexual.setText(String.valueOf(dd.getSensibilizadoSexualidade()));
                    jPresosVacinados.setText(String.valueOf(dd.getVacinadosPNI()));
                    //ABA AEI
                    jPresoSentenciadoEF.setText(String.valueOf(dd.getMatriculadoEnsinoFormal()));
                    jPresoSentencaMatFreqEF.setText(String.valueOf(dd.getFrequentandoEnsinoFormal()));
                    jPresoAtiviPraticaEsportiva.setText(String.valueOf(dd.getEsportes()));
                    //ABA AMI
                    jCobertor.setText(String.valueOf(dd.getCobertor()));
                    jColchao.setText(String.valueOf(dd.getColchao()));
                    jColherPlastica.setText(String.valueOf(dd.getColher()));
                    jLencol.setText(String.valueOf(dd.getLencol()));
                    jToalha.setText(String.valueOf(dd.getToalha()));
                    jPote.setText(String.valueOf(dd.getPote()));
                    jCaneca.setText(String.valueOf(dd.getCaneca()));
                    jAparelhoBarbear.setText(String.valueOf(dd.getAparelhoBarbear()));
                    jCremeDental.setText(String.valueOf(dd.getCremeDental()));
                    jEscovaDente.setText(String.valueOf(dd.getEscova()));
                    jAbsorvente.setText(String.valueOf(dd.getAbsorvente()));
                    jPapelHigienico.setText(String.valueOf(dd.getPapelHigienico()));
                    jSabaoPo.setText(String.valueOf(dd.getSabaoPo()));
                    jSabonete.setText(String.valueOf(dd.getSabonete()));
                    jDesodorante.setText(String.valueOf(dd.getDesodorante()));
                    jBermuda.setText(String.valueOf(dd.getBermuda()));
                    jCamisa.setText(String.valueOf(dd.getCamisa()));
                    jCuecas.setText(String.valueOf(dd.getCueca()));
                    jChinelos.setText(String.valueOf(dd.getParChinelos()));
                    jUniformeCompleto.setText(String.valueOf(dd.getUniformeCompleto()));
                    //ABA SEG
                    jNumeroOcorrenciasInd.setText(String.valueOf(dd.getOcorrenciaIndisciplina()));
                    jNumeroAparelhoConvive.setText(String.valueOf(dd.getCelularLocalizadoConvivencia()));
                    jObjetosMateriais.setText(String.valueOf(dd.getObjetoNaoAutorizadoLocalizadoConvivencia()));
                    jNumeroProcedRevista.setText(String.valueOf(dd.getRevistaCela()));
                    jNumeroOcorrenciaTentaFuga.setText(String.valueOf(dd.getTentativaFuga()));
                    jNumeroOcorrenciaFuga.setText(String.valueOf(dd.getOcorrenciaFuga()));
                    jNumeroOcorrenciaRebeliao.setText(String.valueOf(dd.getOcorrenciaRebeliao()));
                    jNumeroOcorrenciaPessoaFerida.setText(String.valueOf(dd.getOcorrenciaFerido()));
                    jNumeroOcorrenciaPessoasRefem.setText(String.valueOf(dd.getOcorrenciaRefem()));
                    jNumeroOcorrenciaPessoasFeridaMortas.setText(String.valueOf(dd.getOcorrenciaGravementeFeridoMorto()));
                    jNumeroHorasTVCFTV.setText(String.valueOf(dd.getHorasInterrupcaoCFTV()));
                    jNumeroDiasSemScannerCorpo.setText(String.valueOf(dd.getDiasInterrupcaoScannerCorporal()));
                    jNumeroDiasIntMetaPortatil.setText(String.valueOf(dd.getDiasInterrupcaoRaioXDetectorMetais()));
                    jNumeroInterFuncVeiculosTP.setText(String.valueOf(dd.getDiasInterrupcaoVeiculoTransportePreso()));
                    jNumeroFalhasGerador.setText(String.valueOf(dd.getFalhaGeradorEnergia()));
                    jNumeroHorasBloqueador.setText(String.valueOf(dd.getHorasMauFuncionamentoBRS()));
                    jNumeroAbsorEntregueVisitas.setText(String.valueOf(dd.getAbsorventesEntreguesPortariaScanner()));
                    jNumeroFraldasEntreguePortaria.setText(String.valueOf(dd.getFraldasEntreguesPortariaScanner()));
                    //ABA AJ
                    jAtendInternoSAJ.setText(String.valueOf(dd.getInternoFamiliaSAJ()));
                    jAlvaraSolturaCumprido.setText(String.valueOf(dd.getAlvaraSolturaCumprido()));
                    jLivarmentoCondRequerido.setText(String.valueOf(dd.getLivramentoCondicionalRequerido()));
                    jProgressaoRegDeferido.setText(String.valueOf(dd.getProgressaoRegimeDeferida()));
                    jSaidasTempDeferida.setText(String.valueOf(dd.getSaidasTemporariasDeferida()));
                    jAlvarSolRecebeUni.setText(String.valueOf(dd.getAlvaraSolturaRecebido()));
                    jAudienciaProvocadas.setText(String.valueOf(dd.getAudienciaProvocada()));
                    jAudienciaCumpridas.setText(String.valueOf(dd.getAudienciaCumprida()));
                    jJuriPopular.setText(String.valueOf(dd.getJuriProvocado()));
                    jJuriPopularCumprido.setText(String.valueOf(dd.getJuriCumprido()));
                    jLiberdadeProvRequerida.setText(String.valueOf(dd.getLiberdadeProvisoriaRequerida()));
                    jLiberdadeProvDeferida.setText(String.valueOf(dd.getLiberdadeProvisoriaDeferida()));
                    jIndultosRequeridos.setText(String.valueOf(dd.getIndultosRequeridos()));
                    jIndultosDeferidos.setText(String.valueOf(dd.getIndultosDeferidos()));
                    jRemissaoPenaRequerida.setText(String.valueOf(dd.getRemicaoRequerida()));
                    jRemissaoPenaDeferida.setText(String.valueOf(dd.getRemicaoDeferida()));
                    jCondicionalRequerida.setText(String.valueOf(dd.getCondicionalRequerida()));
                    jCondicionalDeferida.setText(String.valueOf(dd.getCondicionalDeferida()));
                    jProgressaoRegRequerido.setText(String.valueOf(dd.getProgressaoRegimeRequerida()));
                    jSaidaTempRequerida.setText(String.valueOf(dd.getSaidasTemporariasRequerida()));
                    jHabeasCorpusImpetrados.setText(String.valueOf(dd.getHabeasCorpusDeferido()));
                    jHabeasCorpusDeferido.setText(String.valueOf(dd.getHabeasCorpusDeferido()));
                    jLaudoPsicoEmitidos.setText(String.valueOf(dd.getLaudosPsicologicos()));
                    jLaudosPsiqEmitidos.setText(String.valueOf(dd.getLaudosPsiquiatricos()));
                    jTP.setText(String.valueOf(dd.getTransferenciaProvimento()));
                    //ABA AL
                    jTriagemAtendInernos.setText(String.valueOf(dd.getTriagem()));
                    jOcupacaoAtiviRecreaReligiosa.setText(String.valueOf(dd.getPresoAtiviReligiosa()));
                    jPresoAtiviArtesPlasticas.setText(String.valueOf(dd.getArtesPlasticas()));
                    jPresoAtiviLiteraria.setText(String.valueOf(dd.getLiteratura()));
                    jPresoAtiviCantoTeatro.setText(String.valueOf(dd.getCantoTeatroCinema()));
                    jMatriculadoCursoProfissionalizante.setText(String.valueOf(dd.getMatriculadoCursoProfissionalizante()));
                    jCertificadoCursoProfissionalizante.setText(String.valueOf(dd.getCertificadoCursoProfissionalizante()));
                    jPresoSentecaAtivLaboralRemun.setText(String.valueOf(dd.getLaborativaRemunerada()));
                    jPresoAtiviLaboralNaoRemunera.setText(String.valueOf(dd.getLaborativaNaoRemunerada()));
                    //ABA AFI
                    jAlimentaServidaInternoCafe.setText(String.valueOf(dd.getCafeInterno()));
                    jAlimentaServidaInternoAlmoco.setText(String.valueOf(dd.getAlmocoInterno()));
                    jAlimentaServidaInternoJantar.setText(String.valueOf(dd.getJantarInterno()));
                    //ABA TOT
                    jTotal_ATE_SOCIAL.setText(String.valueOf(dd.getTotalServicoSocial()));
                    jTotal_ALI_FOR_SERVIDORES.setText(String.valueOf(dd.getTotalAlimentacao()));
                    jTotal_ATE_SAUDE_INTERNO.setText(String.valueOf(dd.getTotalSaude()));
                    jTotal_ATE_EDUCACIONAL.setText(String.valueOf(dd.getTotalEducacional()));
                    jTotal_MATERIAL_INTERNO.setText(String.valueOf(dd.getTotalMaterial()));
                    jTotal_ATI_RECREATIVA_RELIGIOSA.setText(String.valueOf(dd.getTotalRecreativaReligiosa()));
                    jTotal_ATEND_JURIDICO.setText(String.valueOf(dd.getTotalJuridico()));
                    jTotal_ASSIS_LABORAL.setText(String.valueOf(dd.getTotalLaboral()));
                    jTotal_ALIM_FOR_INTERNOS.setText(String.valueOf(dd.getTotalAlimentacaoInterno()));
                }
            } catch (Exception ex) {
                Logger.getLogger(TelaAtividadesMensalUnidade.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jTabelaAtividadesUnidadeMouseClicked

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:  
        buscarAcessoUsuario(telaAtividadeMensalManu_ADM);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoADM.equals("ADMINISTRADORES") || codigoUserADM == codUserAcessoADM && nomeTelaADM.equals(telaAtividadeMensalManu_ADM) && codIncluirADM == 1) {
            jTabbedPane1.setSelectedIndex(1);
            TelaPesqColaboradorAtividadeMensal objPesFunc = new TelaPesqColaboradorAtividadeMensal();
            TelaModuloAdmPessoal.jPainelAdmPessoal.add(objPesFunc);
            objPesFunc.show();
            //ATUALIZAR DATAS DAS TABELAS
            atualizarDatasRegistrosTabelas();
            bloquearHabilitarTodosCampos(true, !true);
            limparTodosCampos();
            Novo();
            pesquisaUnidadePrisional();
            lerParamentoKit();
            acao = 1;
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtividadeMensalManu_ADM);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoADM.equals("ADMINISTRADORES") || codigoUserADM == codUserAcessoADM && nomeTelaADM.equals(telaAtividadeMensalManu_ADM) && codAlterarADM == 1) {
            if (jStatus.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(null, "Registro não pode ser alterado, o mesmo encontra-se FINALIZADO.");
            } else {
                //ATUALIZAR DATA DAS TABELAS
                atualizarDatasRegistrosTabelas();
                pesquisaUnidadePrisional();
                bloquearHabilitarTodosCampos(true, !true);
                Alterar();
                lerParamentoKit();
                acao = 2;
                statusMov = "Alterar";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtAlterarActionPerformed

    private void jBtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtividadeMensalManu_ADM);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoADM.equals("ADMINISTRADORES") || codigoUserADM == codUserAcessoADM && nomeTelaADM.equals(telaAtividadeMensalManu_ADM) && codExcluirADM == 1) {
            if (jStatus.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(null, "Registro não pode ser excluído, o mesmo encontra-se FINALIZADO.");
            } else {
                statusMov = "Excluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    bloquearHabilitarTodosCampos(!true, !true);
                    objAtividade.setChave(Integer.valueOf(jChave.getText()));
                    control.excluirASSI(objAtividade);
                    control.excluirAFV_AFI(objAtividade);
                    control.excluirASI(objAtividade);
                    control.excluirAEI(objAtividade);
                    control.excluirAMI(objAtividade);
                    control.excluirSEG(objAtividade);
                    control.excluirAJ(objAtividade);
                    control.excluirAL(objAtividade);
                    control.excluirAF(objAtividade);
                    control.excluirAVI(objAtividade);
                    control.excluirARI(objAtividade);
                    objAtividade.setChave(Integer.valueOf(jChave.getText()));
                    control.excluirAtividade(objAtividade);
                    Excluir();
                    JOptionPane.showMessageDialog(rootPane, "Registro excluído com sucesso.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtividadeMensalManu_ADM);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoADM.equals("ADMINISTRADORES") || codigoUserADM == codUserAcessoADM && nomeTelaADM.equals(telaAtividadeMensalManu_ADM) && codGravarADM == 1) {
            if (jUnidadePrisional.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Informe a unidade prisional.");
            } else if (jDataPeriodoInicial.getDate() == null) {
                JOptionPane.showMessageDialog(null, "Informe a data inicial para pesquisa.");
            } else if (jDataPeriodoFinal.getDate() == null) {
                JOptionPane.showMessageDialog(null, "Informe a data final para pesquisa.");
            } else if (jComboBoxMesReferencia.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(null, "Selecione o mês de referência.");
            } else if (jComboBoxAnoReferencia.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(null, "Selecione o ano de referência.");
            } else if (jIdFunc.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Informe o nome do colaborador.");
            } else {
                //CRITICAR O RANGE DE DATAS INICIAL E FINAL COM O MÊS DE REFERÊNCIA
                verificarRangeDatasMesAno();
                beans();
                if (acao == 1) {
                    //CRITICAR CASO O REGISTRO PARA O MÊS E ANO DE REFERÊNCIA JÁ FOI INCLUÍDO
                    try {
                        for (AtividadesMensalRealizadaUnidades pp : pesquisaMesAno.read()) {
                            pEXISTE_ANO = pp.getAnoReferencia();
                            pEXISTE_MES = pp.getMesReferencia();
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(TelaAtividadesMensalUnidade.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (jComboBoxAnoReferencia.getSelectedItem().equals((pEXISTE_ANO))
                            && jComboBoxMesReferencia.getSelectedItem().equals(pEXISTE_MES)) {
                        JOptionPane.showMessageDialog(rootPane, "Já foi cadastrado o registro para o mês e ano de referência.");
                    } else {
                        objAtividade.setUsuarioInsert(nameUser);
                        objAtividade.setDataInsert(dataModFinal);
                        objAtividade.setHorarioInsert(horaMov);
                        //
                        control.incluirAtividade(objAtividade);
                        //CALCULAR TOTAIS
                        zerarTotais();
                        calculosTOTAIS();
                        buscarChave();
                        objAtividade.setChave(Integer.valueOf(jChave.getText()));
                        control.incluirASSI(objAtividade);
                        control.incluirAFV_AFI(objAtividade);
                        control.incluirASI(objAtividade);
                        control.incluirAEI(objAtividade);
                        control.incluirAMI(objAtividade);
                        control.incluirSEG(objAtividade);
                        control.incluirAJ(objAtividade);
                        control.incluirAL(objAtividade);
                        control.incluirAF(objAtividade);
                        control.incluirAVI(objAtividade);
                        control.incluirARI(objAtividade);
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        bloquearHabilitarTodosCampos(!true, !true);
                        Salvar();
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    }
                }
                if (acao == 2) {
                    objAtividade.setUsuarioUp(nameUser);
                    objAtividade.setDataUp(dataModFinal);
                    objAtividade.setHorarioUp(horaMov);
                    //CALCULAR TOTAIS
                    zerarTotais();
                    calculosTOTAIS();
                    objAtividade.setChave(Integer.valueOf(jChave.getText()));
                    control.alterarAtividade(objAtividade);
                    control.alterarASSI(objAtividade);
                    control.alterarAFV_AFI(objAtividade);
                    control.alterarASI(objAtividade);
                    control.alterarAEI(objAtividade);
                    control.alterarAMI(objAtividade);
                    control.alterarSEG(objAtividade);
                    control.alterarAJ(objAtividade);
                    control.alterarAL(objAtividade);
                    control.alterarAF(objAtividade);
                    control.alterarAVI(objAtividade);
                    control.alterarARI(objAtividade);
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    bloquearHabilitarTodosCampos(!true, !true);
                    Salvar();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
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
        if (jStatus.getText().equals("FINALIZADO")) {
            JOptionPane.showMessageDialog(null, "Registro não pode ser finalizado, o mesmo encontra-se FINALIZADO.");
        } else {
            if (jChave.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Não existe registro a ser finalizado.");
            } else {
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente finalizar o registro selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    String pFINALIZAR = "FINALIZADO";
                    jStatus.setText(pFINALIZAR);
                    objAtividade.setChave(Integer.valueOf(jChave.getText()));
                    objAtividade.setStatus(jStatus.getText());
                    control.finalizarAtividade(objAtividade);
                    bloquearHabilitarTodosCampos(!true, !true);
                    Finalizar();
                    JOptionPane.showMessageDialog(rootPane, "Registro finalizado com sucesso.");
                }
            }
        }
    }//GEN-LAST:event_jBtFinalizarActionPerformed

    private void jBtImpressaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImpressaoActionPerformed
        // TODO add your handling code here:
        if (jChave.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Não existe registro a ser impresso..");
        } else {
            conecta.abrirConexao();
            String path = "reports/GerenciaAdministrativa/AtividadesUnidade/Relatorio_Mensal_Unidades.jasper";
            try {
                conecta.executaSQL("SELECT TOP 1 * FROM ATIVIDADES_UNIDADE "
                        + "WHERE MesReferencia LIKE '" + jComboBoxMesReferencia.getSelectedItem() + "'  "
                        + "AND AnoReferencia LIKE '" + jComboBoxAnoReferencia.getSelectedItem() + "'  ");
                HashMap parametros = new HashMap();
                parametros.put("pUsuario", nameUser);
                parametros.put("pNOME_UNIDADE", descricaoUnidade);
                parametros.put("pMes", jComboBoxMesReferencia.getSelectedItem());
                parametros.put("pAno", jComboBoxAnoReferencia.getSelectedItem());
                // Sub Relatório
                try {
                    parametros.put("REPORT_CONNECTION", conecta.stmt.getConnection());
                } catch (SQLException ex) {
                }
                JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
                JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
                JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao  
                jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
                jv.setTitle("Relatório Quantitativo Total Atendimento PSP");
                jv.setVisible(true); // Chama o relatorio para ser visualizado             
                jv.toFront(); // Traz o relatorio para frente da aplicação            
                conecta.desconecta();
            } catch (JRException e) {
                JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
            }
        }
    }//GEN-LAST:event_jBtImpressaoActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtAuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaAtividadesUnidade objAudi = new TelaAuditoriaAtividadesUnidade();
        TelaModuloAdmPessoal.jPainelAdmPessoal.add(objAudi);
        objAudi.show();
    }//GEN-LAST:event_jBtAuditoriaActionPerformed

    private void jBtPesquisarColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisarColaboradorActionPerformed
        // TODO add your handling code here:
        TelaPesqColaboradorAtividadeMensal objPesFunc = new TelaPesqColaboradorAtividadeMensal();
        TelaModuloAdmPessoal.jPainelAdmPessoal.add(objPesFunc);
        objPesFunc.show();
    }//GEN-LAST:event_jBtPesquisarColaboradorActionPerformed

    private void jBtPesqMesAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqMesAnoActionPerformed
        // TODO add your handling code here:
        flag = 1;
        Integer row0 = jTabelaAtividadesUnidade.getModel().getRowCount();
        if (jComboBoxMesPesquisa.getSelectedItem().equals("Selecione...")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o mês para pesquisa.");
        } else if (jComboBoxAnoPesquisa.getSelectedItem().equals("Selecione...")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o ano para pesquisa.");
        } else {
            DefaultTableModel dadosDestino = (DefaultTableModel) jTabelaAtividadesUnidade.getModel();
            try {
                for (AtividadesMensalRealizadaUnidades dd : listaAtividadeMesAno.read()) {
                    if (row0 == 0) {
                        jtotalRegistros.setText(Integer.toString(pTOTAL_REGISTROS_ATIVIDADES)); // Converter inteiro em string para exibir na tela                                
                    }
                    pDATA_PESQUISA_TABELA = String.valueOf(dd.getDataCriacao());
                    String dia = pDATA_PESQUISA_TABELA.substring(8, 10);
                    String mes = pDATA_PESQUISA_TABELA.substring(5, 7);
                    String ano = pDATA_PESQUISA_TABELA.substring(0, 4);
                    pDATA_PESQUISA_TABELA = dia + "/" + mes + "/" + ano;
                    dadosDestino.addRow(new Object[]{dd.getChave(), pDATA_PESQUISA_TABELA, dd.getStatus(), dd.getMesReferencia(), dd.getAnoReferencia(), dd.getUnidadePrisional()});
                    // BARRA DE ROLAGEM HORIZONTAL
                    jTabelaAtividadesUnidade.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                    // ALINHAR TEXTO DA TABELA CENTRALIZADO
                    DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                    centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                    //
                    jTabelaAtividadesUnidade.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                    jTabelaAtividadesUnidade.getColumnModel().getColumn(1).setCellRenderer(centralizado);
                    jTabelaAtividadesUnidade.getColumnModel().getColumn(2).setCellRenderer(centralizado);
                    jTabelaAtividadesUnidade.getColumnModel().getColumn(4).setCellRenderer(centralizado);
                }
            } catch (Exception ex) {
                Logger.getLogger(TelaAtividadesMensalUnidade.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jBtPesqMesAnoActionPerformed

    private void jBtPesquisarDatasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisarDatasActionPerformed
        // TODO add your handling code here:        
        if (jDataPeriodoInicial.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Informe a data inicial para pesquisa.");
        } else if (jDataPeriodoFinal.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Informe a data final para pesquisa.");
        } else if (jDataPeriodoInicial.getDate().after(jDataPeriodoFinal.getDate())) {
            JOptionPane.showMessageDialog(rootPane, "Data Inicial não pode ser maior que data final");
        } else {
            SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
            pMES_REFERENCIA = formatoAmerica.format(jDataPeriodoInicial.getDate().getTime());
            if (jComboBoxMesReferencia.getSelectedItem().equals("Janeiro")) {
                pMES_01 = "01";
                pDIA = pMES_REFERENCIA.substring(0, 1);
                pMES = pMES_REFERENCIA.substring(3, 5);
                pANO = pMES_REFERENCIA.substring(6, 10);
                pMES_REFERENCIA = pMES;
                if (pMES_REFERENCIA.equals(pMES_01) && jComboBoxAnoReferencia.getSelectedItem().equals(pANO)) {
                    calculoMediaPopulacao();
                    //ABA ASSI - SERVIÇO SOCIAL
                    calculoSS();
                    calculoSSF();
                    calculoVI();
                    caluloVC();
                    calculoPresoCivil();
                    calculoMED();
                    caluloQTVD();
                    //CALCUAR AS MÉDIAS
                    if (pQUANTIDADE_VISITA_FAMILIA_INT != 0 && pQUANTIDADE_DIAS_VISITADOS != 0) {
                        pMEDIA_VISITAS_POR_DIA = (pQUANTIDADE_VISITA_FAMILIA_INT / pQUANTIDADE_DIAS_VISITADOS);
                        jMediaVisitasDia.setText(String.valueOf(pMEDIA_VISITAS_POR_DIA));
                        calcularMediaVisitasInterno();
                    } else if (pQUANTIDADE_VISITA_FAMILIA_INT == 0 || pQUANTIDADE_DIAS_VISITADOS == 0) {
                        jMediaVisitasDia.setText("0");
                    }
                    //ABA ASI
                    calculoMED();
                    calculoPSIQ();
                    calculoENFER();
                    calculoAgravosDIAG();
                    calculoControleHipertensao();
                    calculoControleDiabetes();
                    calculoDOENCA_INFECTOCONTAGIOSAS();
                    calculoControleVacinas();
                    calculoPSI();
                    calculoProcODON();
                    calculoAtendODON();
                    //ABA AEI
                    calculoMatPED();
                    calculoFreqPED();
                    //AEI
                    calculoProdutosKit();
                    //ABA SEG
                    calculoCelularSEG();
                    calcularObjetos();
                    calcularQtdRevistaCela();
                    //ABA AJ
                    calculoATENJURI();
                    calculoSAIDA_ALVARA_LIVRAMENTO_PROGESSAO();
                    calculoATEN_TO();
                    //MÊS DE FEVEREIRO
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Dados incorreto, verifique se mês e o ano selecionado estão de acordo com a data inicial.");
                }
            } else if (jComboBoxMesReferencia.getSelectedItem().equals("Fevereiro")) {
                pMES_02 = "02";
                pDIA = pMES_REFERENCIA.substring(0, 1);
                pMES = pMES_REFERENCIA.substring(3, 5);
                pANO = pMES_REFERENCIA.substring(6, 10);
                pMES_REFERENCIA = pMES;
                if (pMES_REFERENCIA.equals(pMES_02) && jComboBoxAnoReferencia.getSelectedItem().equals(pANO)) {
                    calculoMediaPopulacao();
                    //ABA ASSI - SERVIÇO SOCIAL
                    calculoSS();
                    calculoSSF();
                    calculoVI();
                    caluloVC();
                    calculoPresoCivil();
                    calculoMED();
                    caluloQTVD();
                    //CALCUAR AS MÉDIAS
                    if (pQUANTIDADE_VISITA_FAMILIA_INT != 0 && pQUANTIDADE_DIAS_VISITADOS != 0) {
                        pMEDIA_VISITAS_POR_DIA = (pQUANTIDADE_VISITA_FAMILIA_INT / pQUANTIDADE_DIAS_VISITADOS);
                        jMediaVisitasDia.setText(String.valueOf(pMEDIA_VISITAS_POR_DIA));
                        calcularMediaVisitasInterno();
                    } else if (pQUANTIDADE_VISITA_FAMILIA_INT == 0 || pQUANTIDADE_DIAS_VISITADOS == 0) {
                        jMediaVisitasDia.setText("0");
                    }
                    //ABA ASI
                    calculoMED();
                    calculoPSIQ();
                    calculoENFER();
                    calculoAgravosDIAG();
                    calculoControleHipertensao();
                    calculoControleDiabetes();
                    calculoDOENCA_INFECTOCONTAGIOSAS();
                    calculoControleVacinas();
                    calculoPSI();
                    calculoProcODON();
                    calculoAtendODON();
                    //ABA AEI
                    calculoMatPED();
                    calculoFreqPED();
                    //AEI
                    calculoProdutosKit();
                    //ABA SEG
                    calculoCelularSEG();
                    calcularObjetos();
                    calcularQtdRevistaCela();
                    //ABA AJ
                    calculoATENJURI();
                    calculoSAIDA_ALVARA_LIVRAMENTO_PROGESSAO();
                    calculoATEN_TO();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Dados incorreto, verifique se mês e o ano selecionado estão de acordo com a data inicial.");
                }
            } else if (jComboBoxMesReferencia.getSelectedItem().equals("Março")) {
                pMES_03 = "03";
                pDIA = pMES_REFERENCIA.substring(0, 1);
                pMES = pMES_REFERENCIA.substring(3, 5);
                pANO = pMES_REFERENCIA.substring(6, 10);
                pMES_REFERENCIA = pMES;
                if (pMES_REFERENCIA.equals(pMES_03) && jComboBoxAnoReferencia.getSelectedItem().equals(pANO)) {
                    calculoMediaPopulacao();
                    //ABA ASSI - SERVIÇO SOCIAL
                    calculoSS();
                    calculoSSF();
                    calculoVI();
                    caluloVC();
                    calculoPresoCivil();
                    calculoMED();
                    caluloQTVD();
                    //CALCUAR AS MÉDIAS
                    if (pQUANTIDADE_VISITA_FAMILIA_INT != 0 && pQUANTIDADE_DIAS_VISITADOS != 0) {
                        pMEDIA_VISITAS_POR_DIA = (pQUANTIDADE_VISITA_FAMILIA_INT / pQUANTIDADE_DIAS_VISITADOS);
                        jMediaVisitasDia.setText(String.valueOf(pMEDIA_VISITAS_POR_DIA));
                        calcularMediaVisitasInterno();
                    } else if (pQUANTIDADE_VISITA_FAMILIA_INT == 0 || pQUANTIDADE_DIAS_VISITADOS == 0) {
                        jMediaVisitasDia.setText("0");
                    }
                    //ABA ASI
                    calculoMED();
                    calculoPSIQ();
                    calculoENFER();
                    calculoAgravosDIAG();
                    calculoControleHipertensao();
                    calculoControleDiabetes();
                    calculoDOENCA_INFECTOCONTAGIOSAS();
                    calculoControleVacinas();
                    calculoPSI();
                    calculoProcODON();
                    calculoAtendODON();
                    //ABA AEI
                    calculoMatPED();
                    calculoFreqPED();
                    //AEI
                    calculoProdutosKit();
                    //ABA SEG
                    calculoCelularSEG();
                    calcularObjetos();
                    calcularQtdRevistaCela();
                    //ABA AJ
                    calculoATENJURI();
                    calculoSAIDA_ALVARA_LIVRAMENTO_PROGESSAO();
                    calculoATEN_TO();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Dados incorreto, verifique se mês e o ano selecionado estão de acordo com a data inicial.");
                }
            } else if (jComboBoxMesReferencia.getSelectedItem().equals("Abril")) {
                pMES_04 = "04";
                pDIA = pMES_REFERENCIA.substring(0, 1);
                pMES = pMES_REFERENCIA.substring(3, 5);
                pANO = pMES_REFERENCIA.substring(6, 10);
                pMES_REFERENCIA = pMES;
                if (pMES_REFERENCIA.equals(pMES_04) && jComboBoxAnoReferencia.getSelectedItem().equals(pANO)) {
                    calculoMediaPopulacao();
                    //ABA ASSI - SERVIÇO SOCIAL
                    calculoSS();
                    calculoSSF();
                    calculoVI();
                    caluloVC();
                    calculoPresoCivil();
                    calculoMED();
                    caluloQTVD();
                    //CALCUAR AS MÉDIAS
                    if (pQUANTIDADE_VISITA_FAMILIA_INT != 0 && pQUANTIDADE_DIAS_VISITADOS != 0) {
                        pMEDIA_VISITAS_POR_DIA = (pQUANTIDADE_VISITA_FAMILIA_INT / pQUANTIDADE_DIAS_VISITADOS);
                        jMediaVisitasDia.setText(String.valueOf(pMEDIA_VISITAS_POR_DIA));
                        calcularMediaVisitasInterno();
                    } else if (pQUANTIDADE_VISITA_FAMILIA_INT == 0 || pQUANTIDADE_DIAS_VISITADOS == 0) {
                        jMediaVisitasDia.setText("0");
                    }
                    //ABA ASI
                    calculoMED();
                    calculoPSIQ();
                    calculoENFER();
                    calculoAgravosDIAG();
                    calculoControleHipertensao();
                    calculoControleDiabetes();
                    calculoDOENCA_INFECTOCONTAGIOSAS();
                    calculoControleVacinas();
                    calculoPSI();
                    calculoProcODON();
                    calculoAtendODON();
                    //ABA AEI
                    calculoMatPED();
                    calculoFreqPED();
                    //AEI
                    calculoProdutosKit();
                    //ABA SEG
                    calculoCelularSEG();
                    calcularObjetos();
                    calcularQtdRevistaCela();
                    //ABA AJ
                    calculoATENJURI();
                    calculoSAIDA_ALVARA_LIVRAMENTO_PROGESSAO();
                    calculoATEN_TO();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Dados incorreto, verifique se mês e o ano selecionado estão de acordo com a data inicial.");
                }
            } else if (jComboBoxMesReferencia.getSelectedItem().equals("Maio")) {
                pMES_05 = "05";
                pDIA = pMES_REFERENCIA.substring(0, 1);
                pMES = pMES_REFERENCIA.substring(3, 5);
                pANO = pMES_REFERENCIA.substring(6, 10);
                pMES_REFERENCIA = pMES;
                if (pMES_REFERENCIA.equals(pMES_05) && jComboBoxAnoReferencia.getSelectedItem().equals(pANO)) {
                    calculoMediaPopulacao();
                    //ABA ASSI - SERVIÇO SOCIAL
                    calculoSS();
                    calculoSSF();
                    calculoVI();
                    caluloVC();
                    calculoPresoCivil();
                    calculoMED();
                    caluloQTVD();
                    //CALCUAR AS MÉDIAS
                    if (pQUANTIDADE_VISITA_FAMILIA_INT != 0 && pQUANTIDADE_DIAS_VISITADOS != 0) {
                        pMEDIA_VISITAS_POR_DIA = (pQUANTIDADE_VISITA_FAMILIA_INT / pQUANTIDADE_DIAS_VISITADOS);
                        jMediaVisitasDia.setText(String.valueOf(pMEDIA_VISITAS_POR_DIA));
                        calcularMediaVisitasInterno();
                    } else if (pQUANTIDADE_VISITA_FAMILIA_INT == 0 || pQUANTIDADE_DIAS_VISITADOS == 0) {
                        jMediaVisitasDia.setText("0");
                    }
                    //ABA ASI
                    calculoMED();
                    calculoPSIQ();
                    calculoENFER();
                    calculoAgravosDIAG();
                    calculoControleHipertensao();
                    calculoControleDiabetes();
                    calculoDOENCA_INFECTOCONTAGIOSAS();
                    calculoControleVacinas();
                    calculoPSI();
                    calculoProcODON();
                    calculoAtendODON();
                    //ABA AEI
                    calculoMatPED();
                    calculoFreqPED();
                    //AEI
                    calculoProdutosKit();
                    //ABA SEG
                    calculoCelularSEG();
                    calcularObjetos();
                    calcularQtdRevistaCela();
                    //ABA AJ
                    calculoATENJURI();
                    calculoSAIDA_ALVARA_LIVRAMENTO_PROGESSAO();
                    calculoATEN_TO();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Dados incorreto, verifique se mês e o ano selecionado estão de acordo com a data inicial.");
                }
            } else if (jComboBoxMesReferencia.getSelectedItem().equals("Junho")) {
                pMES_06 = "06";
                pDIA = pMES_REFERENCIA.substring(0, 1);
                pMES = pMES_REFERENCIA.substring(3, 5);
                pANO = pMES_REFERENCIA.substring(6, 10);
                pMES_REFERENCIA = pMES;
                if (pMES_REFERENCIA.equals(pMES_06) && jComboBoxAnoReferencia.getSelectedItem().equals(pANO)) {
                    calculoMediaPopulacao();
                    //ABA ASSI - SERVIÇO SOCIAL
                    calculoSS();
                    calculoSSF();
                    calculoVI();
                    caluloVC();
                    calculoPresoCivil();
                    calculoMED();
                    caluloQTVD();
                    //CALCUAR AS MÉDIAS
                    if (pQUANTIDADE_VISITA_FAMILIA_INT != 0 && pQUANTIDADE_DIAS_VISITADOS != 0) {
                        pMEDIA_VISITAS_POR_DIA = (pQUANTIDADE_VISITA_FAMILIA_INT / pQUANTIDADE_DIAS_VISITADOS);
                        jMediaVisitasDia.setText(String.valueOf(pMEDIA_VISITAS_POR_DIA));
                        calcularMediaVisitasInterno();
                    } else if (pQUANTIDADE_VISITA_FAMILIA_INT == 0 || pQUANTIDADE_DIAS_VISITADOS == 0) {
                        jMediaVisitasDia.setText("0");
                    }
                    //ABA ASI
                    calculoMED();
                    calculoPSIQ();
                    calculoENFER();
                    calculoAgravosDIAG();
                    calculoControleHipertensao();
                    calculoControleDiabetes();
                    calculoDOENCA_INFECTOCONTAGIOSAS();
                    calculoControleVacinas();
                    calculoPSI();
                    calculoProcODON();
                    calculoAtendODON();
                    //ABA AEI
                    calculoMatPED();
                    calculoFreqPED();
                    //AEI
                    calculoProdutosKit();
                    //ABA SEG
                    calculoCelularSEG();
                    calcularObjetos();
                    calcularQtdRevistaCela();
                    //ABA AJ
                    calculoATENJURI();
                    calculoSAIDA_ALVARA_LIVRAMENTO_PROGESSAO();
                    calculoATEN_TO();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Dados incorreto, verifique se mês e o ano selecionado estão de acordo com a data inicial.");
                }
            } else if (jComboBoxMesReferencia.getSelectedItem().equals("Julho")) {
                pMES_07 = "07";
                pDIA = pMES_REFERENCIA.substring(0, 1);
                pMES = pMES_REFERENCIA.substring(3, 5);
                pANO = pMES_REFERENCIA.substring(6, 10);
                pMES_REFERENCIA = pMES;
                if (pMES_REFERENCIA.equals(pMES_07) && jComboBoxAnoReferencia.getSelectedItem().equals(pANO)) {
                    calculoMediaPopulacao();
                    //ABA ASSI - SERVIÇO SOCIAL
                    calculoSS();
                    calculoSSF();
                    calculoVI();
                    caluloVC();
                    calculoPresoCivil();
                    calculoMED();
                    caluloQTVD();
                    //CALCUAR AS MÉDIAS
                    if (pQUANTIDADE_VISITA_FAMILIA_INT != 0 && pQUANTIDADE_DIAS_VISITADOS != 0) {
                        pMEDIA_VISITAS_POR_DIA = (pQUANTIDADE_VISITA_FAMILIA_INT / pQUANTIDADE_DIAS_VISITADOS);
                        jMediaVisitasDia.setText(String.valueOf(pMEDIA_VISITAS_POR_DIA));
                        calcularMediaVisitasInterno();
                    } else if (pQUANTIDADE_VISITA_FAMILIA_INT == 0 || pQUANTIDADE_DIAS_VISITADOS == 0) {
                        jMediaVisitasDia.setText("0");
                    }
                    //ABA ASI
                    calculoMED();
                    calculoPSIQ();
                    calculoENFER();
                    calculoAgravosDIAG();
                    calculoControleHipertensao();
                    calculoControleDiabetes();
                    calculoDOENCA_INFECTOCONTAGIOSAS();
                    calculoControleVacinas();
                    calculoPSI();
                    calculoProcODON();
                    calculoAtendODON();
                    //ABA AEI
                    calculoMatPED();
                    calculoFreqPED();
                    //AEI
                    calculoProdutosKit();
                    //ABA SEG
                    calculoCelularSEG();
                    calcularObjetos();
                    calcularQtdRevistaCela();
                    //ABA AJ
                    calculoATENJURI();
                    calculoSAIDA_ALVARA_LIVRAMENTO_PROGESSAO();
                    calculoATEN_TO();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Dados incorreto, verifique se mês e o ano selecionado estão de acordo com a data inicial.");
                }
            } else if (jComboBoxMesReferencia.getSelectedItem().equals("Agosto")) {
                pMES_08 = "08";
                pDIA = pMES_REFERENCIA.substring(0, 1);
                pMES = pMES_REFERENCIA.substring(3, 5);
                pANO = pMES_REFERENCIA.substring(6, 10);
                pMES_REFERENCIA = pMES;
                if (pMES_REFERENCIA.equals(pMES_08) && jComboBoxAnoReferencia.getSelectedItem().equals(pANO)) {
                    calculoMediaPopulacao();
                    //ABA ASSI - SERVIÇO SOCIAL
                    calculoSS();
                    calculoSSF();
                    calculoVI();
                    caluloVC();
                    calculoPresoCivil();
                    calculoMED();
                    caluloQTVD();
                    //CALCUAR AS MÉDIAS
                    if (pQUANTIDADE_VISITA_FAMILIA_INT != 0 && pQUANTIDADE_DIAS_VISITADOS != 0) {
                        pMEDIA_VISITAS_POR_DIA = (pQUANTIDADE_VISITA_FAMILIA_INT / pQUANTIDADE_DIAS_VISITADOS);
                        jMediaVisitasDia.setText(String.valueOf(pMEDIA_VISITAS_POR_DIA));
                        calcularMediaVisitasInterno();
                    } else if (pQUANTIDADE_VISITA_FAMILIA_INT == 0 || pQUANTIDADE_DIAS_VISITADOS == 0) {
                        jMediaVisitasDia.setText("0");
                    }
                    //ABA ASI
                    calculoMED();
                    calculoPSIQ();
                    calculoENFER();
                    calculoAgravosDIAG();
                    calculoControleHipertensao();
                    calculoControleDiabetes();
                    calculoDOENCA_INFECTOCONTAGIOSAS();
                    calculoControleVacinas();
                    calculoPSI();
                    calculoProcODON();
                    calculoAtendODON();
                    //ABA AEI
                    calculoMatPED();
                    calculoFreqPED();
                    //AEI
                    calculoProdutosKit();
                    //ABA SEG
                    calculoCelularSEG();
                    calcularObjetos();
                    calcularQtdRevistaCela();
                    //ABA AJ
                    calculoATENJURI();
                    calculoSAIDA_ALVARA_LIVRAMENTO_PROGESSAO();
                    calculoATEN_TO();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Dados incorreto, verifique se mês e o ano selecionado estão de acordo com a data inicial.");
                }
            } else if (jComboBoxMesReferencia.getSelectedItem().equals("Setembro")) {
                pMES_09 = "09";
                pDIA = pMES_REFERENCIA.substring(0, 1);
                pMES = pMES_REFERENCIA.substring(3, 5);
                pANO = pMES_REFERENCIA.substring(6, 10);
                pMES_REFERENCIA = pMES;
                if (pMES_REFERENCIA.equals(pMES_09) && jComboBoxAnoReferencia.getSelectedItem().equals(pANO)) {
                    calculoMediaPopulacao();
                    //ABA ASSI - SERVIÇO SOCIAL
                    calculoSS();
                    calculoSSF();
                    calculoVI();
                    caluloVC();
                    calculoPresoCivil();
                    calculoMED();
                    caluloQTVD();
                    //CALCUAR AS MÉDIAS
                    if (pQUANTIDADE_VISITA_FAMILIA_INT != 0 && pQUANTIDADE_DIAS_VISITADOS != 0) {
                        pMEDIA_VISITAS_POR_DIA = (pQUANTIDADE_VISITA_FAMILIA_INT / pQUANTIDADE_DIAS_VISITADOS);
                        jMediaVisitasDia.setText(String.valueOf(pMEDIA_VISITAS_POR_DIA));
                        calcularMediaVisitasInterno();
                    } else if (pQUANTIDADE_VISITA_FAMILIA_INT == 0 || pQUANTIDADE_DIAS_VISITADOS == 0) {
                        jMediaVisitasDia.setText("0");
                    }
                    //ABA ASI
                    calculoMED();
                    calculoPSIQ();
                    calculoENFER();
                    calculoAgravosDIAG();
                    calculoControleHipertensao();
                    calculoControleDiabetes();
                    calculoDOENCA_INFECTOCONTAGIOSAS();
                    calculoControleVacinas();
                    calculoPSI();
                    calculoProcODON();
                    calculoAtendODON();
                    //ABA AEI
                    calculoMatPED();
                    calculoFreqPED();
                    //AEI
                    calculoProdutosKit();
                    //ABA SEG
                    calculoCelularSEG();
                    calcularObjetos();
                    calcularQtdRevistaCela();
                    //ABA AJ
                    calculoATENJURI();
                    calculoSAIDA_ALVARA_LIVRAMENTO_PROGESSAO();
                    calculoATEN_TO();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Dados incorreto, verifique se mês e o ano selecionado estão de acordo com a data inicial.");
                }
            } else if (jComboBoxMesReferencia.getSelectedItem().equals("Outubro")) {
                pMES_10 = "10";
                pDIA = pMES_REFERENCIA.substring(0, 1);
                pMES = pMES_REFERENCIA.substring(3, 5);
                pANO = pMES_REFERENCIA.substring(6, 10);
                pMES_REFERENCIA = pMES;
                if (pMES_REFERENCIA.equals(pMES_10) && jComboBoxAnoReferencia.getSelectedItem().equals(pANO)) {
                    calculoMediaPopulacao();
                    //ABA ASSI - SERVIÇO SOCIAL
                    calculoSS();
                    calculoSSF();
                    calculoVI();
                    caluloVC();
                    calculoPresoCivil();
                    calculoMED();
                    caluloQTVD();
                    //CALCUAR AS MÉDIAS
                    if (pQUANTIDADE_VISITA_FAMILIA_INT != 0 && pQUANTIDADE_DIAS_VISITADOS != 0) {
                        pMEDIA_VISITAS_POR_DIA = (pQUANTIDADE_VISITA_FAMILIA_INT / pQUANTIDADE_DIAS_VISITADOS);
                        jMediaVisitasDia.setText(String.valueOf(pMEDIA_VISITAS_POR_DIA));
                        calcularMediaVisitasInterno();
                    } else if (pQUANTIDADE_VISITA_FAMILIA_INT == 0 || pQUANTIDADE_DIAS_VISITADOS == 0) {
                        jMediaVisitasDia.setText("0");
                    }
                    //ABA ASI
                    calculoMED();
                    calculoPSIQ();
                    calculoENFER();
                    calculoAgravosDIAG();
                    calculoControleHipertensao();
                    calculoControleDiabetes();
                    calculoDOENCA_INFECTOCONTAGIOSAS();
                    calculoControleVacinas();
                    calculoPSI();
                    calculoProcODON();
                    calculoAtendODON();
                    //ABA AEI
                    calculoMatPED();
                    calculoFreqPED();
                    //AEI
                    calculoProdutosKit();
                    //ABA SEG
                    calculoCelularSEG();
                    calcularObjetos();
                    calcularQtdRevistaCela();
                    //ABA AJ
                    calculoATENJURI();
                    calculoSAIDA_ALVARA_LIVRAMENTO_PROGESSAO();
                    calculoATEN_TO();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Dados incorreto, verifique se mês e o ano selecionado estão de acordo com a data inicial.");
                }
            } else if (jComboBoxMesReferencia.getSelectedItem().equals("Novembro")) {
                pMES_11 = "11";
                pDIA = pMES_REFERENCIA.substring(0, 1);
                pMES = pMES_REFERENCIA.substring(3, 5);
                pANO = pMES_REFERENCIA.substring(6, 10);
                pMES_REFERENCIA = pMES;
                if (pMES_REFERENCIA.equals(pMES_11) && jComboBoxAnoReferencia.getSelectedItem().equals(pANO)) {
                    calculoMediaPopulacao();
                    //ABA ASSI - SERVIÇO SOCIAL
                    calculoSS();
                    calculoSSF();
                    calculoVI();
                    caluloVC();
                    calculoPresoCivil();
                    calculoMED();
                    caluloQTVD();
                    //CALCUAR AS MÉDIAS
                    if (pQUANTIDADE_VISITA_FAMILIA_INT != 0 && pQUANTIDADE_DIAS_VISITADOS != 0) {
                        pMEDIA_VISITAS_POR_DIA = (pQUANTIDADE_VISITA_FAMILIA_INT / pQUANTIDADE_DIAS_VISITADOS);
                        jMediaVisitasDia.setText(String.valueOf(pMEDIA_VISITAS_POR_DIA));
                        calcularMediaVisitasInterno();
                    } else if (pQUANTIDADE_VISITA_FAMILIA_INT == 0 || pQUANTIDADE_DIAS_VISITADOS == 0) {
                        jMediaVisitasDia.setText("0");
                    }
                    //ABA ASI
                    calculoMED();
                    calculoPSIQ();
                    calculoENFER();
                    calculoAgravosDIAG();
                    calculoControleHipertensao();
                    calculoControleDiabetes();
                    calculoDOENCA_INFECTOCONTAGIOSAS();
                    calculoControleVacinas();
                    calculoPSI();
                    calculoProcODON();
                    calculoAtendODON();
                    //ABA AEI
                    calculoMatPED();
                    calculoFreqPED();
                    //AEI
                    calculoProdutosKit();
                    //ABA SEG
                    calculoCelularSEG();
                    calcularObjetos();
                    calcularQtdRevistaCela();
                    //ABA AJ
                    calculoATENJURI();
                    calculoSAIDA_ALVARA_LIVRAMENTO_PROGESSAO();
                    calculoATEN_TO();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Dados incorreto, verifique se mês e o ano selecionado estão de acordo com a data inicial.");
                }
            } else if (jComboBoxMesReferencia.getSelectedItem().equals("Dezembro")) {
                pMES_12 = "12";
                pDIA = pMES_REFERENCIA.substring(0, 1);
                pMES = pMES_REFERENCIA.substring(3, 5);
                pANO = pMES_REFERENCIA.substring(6, 10);
                pMES_REFERENCIA = pMES;
                if (pMES_REFERENCIA.equals(pMES_12) && jComboBoxAnoReferencia.getSelectedItem().equals(pANO)) {
                    calculoMediaPopulacao();
                    //ABA ASSI - SERVIÇO SOCIAL
                    calculoSS();
                    calculoSSF();
                    calculoVI();
                    caluloVC();
                    calculoPresoCivil();
                    calculoMED();
                    caluloQTVD();
                    //CALCUAR AS MÉDIAS
                    if (pQUANTIDADE_VISITA_FAMILIA_INT != 0 && pQUANTIDADE_DIAS_VISITADOS != 0) {
                        pMEDIA_VISITAS_POR_DIA = (pQUANTIDADE_VISITA_FAMILIA_INT / pQUANTIDADE_DIAS_VISITADOS);
                        jMediaVisitasDia.setText(String.valueOf(pMEDIA_VISITAS_POR_DIA));
                        calcularMediaVisitasInterno();
                    } else if (pQUANTIDADE_VISITA_FAMILIA_INT == 0 || pQUANTIDADE_DIAS_VISITADOS == 0) {
                        jMediaVisitasDia.setText("0");
                    }
                    //ABA ASI
                    calculoMED();
                    calculoPSIQ();
                    calculoENFER();
                    calculoAgravosDIAG();
                    calculoControleHipertensao();
                    calculoControleDiabetes();
                    calculoDOENCA_INFECTOCONTAGIOSAS();
                    calculoControleVacinas();
                    calculoPSI();
                    calculoProcODON();
                    calculoAtendODON();
                    //ABA AEI
                    calculoMatPED();
                    calculoFreqPED();
                    //AEI
                    calculoProdutosKit();
                    //ABA SEG
                    calculoCelularSEG();
                    calcularObjetos();
                    calcularQtdRevistaCela();
                    //ABA AJ
                    calculoATENJURI();
                    calculoSAIDA_ALVARA_LIVRAMENTO_PROGESSAO();
                    calculoATEN_TO();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Dados incorreto, verifique se mês e o ano selecionado estão de acordo com a data inicial.");
                }
            }
        }
    }//GEN-LAST:event_jBtPesquisarDatasActionPerformed

    private void jBtCalcularTotaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCalcularTotaisActionPerformed
        // TODO add your handling code here:
        zerarTotais();
        calculosTOTAIS();
    }//GEN-LAST:event_jBtCalcularTotaisActionPerformed

    private void jBtAtualizarDatasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAtualizarDatasActionPerformed
        // TODO add your handling code here:
        atualizarDatasRegistrosTabelas();
        JOptionPane.showMessageDialog(rootPane, "Registros atualizados com sucesso.");
    }//GEN-LAST:event_jBtAtualizarDatasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JFormattedTextField jAtendimentoMedicoPsiquiatrico;
    private javax.swing.JFormattedTextField jAtendimentoOdontologicos;
    private javax.swing.JFormattedTextField jAtendimentoPsiFamilaPreso;
    private javax.swing.JFormattedTextField jAtendimentoPsiPreso;
    private javax.swing.JFormattedTextField jAtendimentoPsicologico;
    private javax.swing.JFormattedTextField jAudienciaCumpridas;
    private javax.swing.JFormattedTextField jAudienciaProvocadas;
    private javax.swing.JFormattedTextField jBermuda;
    private javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtAtualizarDatas;
    private javax.swing.JButton jBtAuditoria;
    private javax.swing.JButton jBtCalcularTotais;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtExcluir;
    private javax.swing.JButton jBtFinalizar;
    private javax.swing.JButton jBtImpressao;
    private javax.swing.JButton jBtNovo;
    private javax.swing.JButton jBtPesqCodigoAtividade;
    private javax.swing.JButton jBtPesqDatas;
    private javax.swing.JButton jBtPesqMesAno;
    private javax.swing.JButton jBtPesqNome;
    private javax.swing.JButton jBtPesquisarColaborador;
    private javax.swing.JButton jBtPesquisarDatas;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JFormattedTextField jCamisa;
    private javax.swing.JFormattedTextField jCaneca;
    private javax.swing.JFormattedTextField jCertificadoCursoProfissionalizante;
    public static javax.swing.JTextField jChave;
    public static javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JFormattedTextField jChinelos;
    private javax.swing.JFormattedTextField jCobertor;
    public static javax.swing.JTextField jCodigoAtividade;
    public static javax.swing.JTextField jColaboradorResponsavel;
    private javax.swing.JFormattedTextField jColchao;
    private javax.swing.JFormattedTextField jColherPlastica;
    public static javax.swing.JComboBox<String> jComboBoxAnoPesquisa;
    public static javax.swing.JComboBox<String> jComboBoxAnoReferencia;
    public static javax.swing.JComboBox<String> jComboBoxMesPesquisa;
    public static javax.swing.JComboBox<String> jComboBoxMesReferencia;
    private javax.swing.JFormattedTextField jCondicionalDeferida;
    private javax.swing.JFormattedTextField jCondicionalRequerida;
    private javax.swing.JFormattedTextField jControlHipertensao;
    private javax.swing.JFormattedTextField jControleDiabetes;
    private javax.swing.JFormattedTextField jCremeDental;
    private javax.swing.JFormattedTextField jCuecas;
    private com.toedter.calendar.JDateChooser jDataAtualizacao;
    private com.toedter.calendar.JDateChooser jDataCriacao;
    public static com.toedter.calendar.JDateChooser jDataPeriodoFinal;
    public static com.toedter.calendar.JDateChooser jDataPeriodoInicial;
    public static com.toedter.calendar.JDateChooser jDataPesFinal;
    public static com.toedter.calendar.JDateChooser jDataPesqInicial;
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
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
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
    private javax.swing.JFormattedTextField jLanchesServidoVisita;
    private javax.swing.JFormattedTextField jLaudoPsicoEmitidos;
    private javax.swing.JFormattedTextField jLaudosPsiqEmitidos;
    private javax.swing.JFormattedTextField jLencol;
    private javax.swing.JFormattedTextField jLiberdadeProvDeferida;
    private javax.swing.JFormattedTextField jLiberdadeProvRequerida;
    private javax.swing.JFormattedTextField jLivarmentoCondRequerido;
    public static javax.swing.JTextField jMatricula;
    private javax.swing.JFormattedTextField jMatriculadoCursoProfissionalizante;
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
    private javax.swing.JFormattedTextField jNumeroInterFuncVeiculosTP;
    private javax.swing.JFormattedTextField jNumeroOcorrenciaFuga;
    private javax.swing.JFormattedTextField jNumeroOcorrenciaPessoaFerida;
    private javax.swing.JFormattedTextField jNumeroOcorrenciaPessoasFeridaMortas;
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
    private javax.swing.JPanel jPanel15;
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
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JFormattedTextField jPapelHigienico;
    private javax.swing.JTextField jPesqNome;
    public static javax.swing.JTextField jPopulacaoAtual;
    private javax.swing.JFormattedTextField jPote;
    private javax.swing.JFormattedTextField jPresoAtiviArtesPlasticas;
    private javax.swing.JFormattedTextField jPresoAtiviCantoTeatro;
    private javax.swing.JFormattedTextField jPresoAtiviLaboralNaoRemunera;
    private javax.swing.JFormattedTextField jPresoAtiviLiteraria;
    private javax.swing.JFormattedTextField jPresoAtiviPraticaEsportiva;
    private javax.swing.JFormattedTextField jPresoAtiviReligiosa;
    private javax.swing.JFormattedTextField jPresoDoencaInfecto;
    private javax.swing.JFormattedTextField jPresoIdentCivil;
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
    private javax.swing.JTable jTabelaAtividadesUnidade;
    private javax.swing.JFormattedTextField jToalha;
    private javax.swing.JFormattedTextField jTotal_ALIM_FOR_INTERNOS;
    private javax.swing.JFormattedTextField jTotal_ALI_FOR_SERVIDORES;
    private javax.swing.JFormattedTextField jTotal_ASSIS_LABORAL;
    private javax.swing.JFormattedTextField jTotal_ATEND_JURIDICO;
    private javax.swing.JFormattedTextField jTotal_ATE_EDUCACIONAL;
    private javax.swing.JFormattedTextField jTotal_ATE_SAUDE_INTERNO;
    private javax.swing.JFormattedTextField jTotal_ATE_SOCIAL;
    private javax.swing.JFormattedTextField jTotal_ATI_RECREATIVA_RELIGIOSA;
    private javax.swing.JFormattedTextField jTotal_MATERIAL_INTERNO;
    private javax.swing.JFormattedTextField jTratamentoAgravDiaginostico;
    private javax.swing.JFormattedTextField jTriagemAtendInernos;
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
        jComboBoxMesReferencia.setBackground(Color.white);
        jComboBoxAnoReferencia.setBackground(Color.white);
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
        jAtendimentoMedicoPsiquiatrico.setBackground(Color.white);
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
        jColherPlastica.setBackground(Color.white);
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
        jNumeroOcorrenciaFuga.setBackground(Color.white);
        jNumeroOcorrenciaRebeliao.setBackground(Color.white);
        jNumeroOcorrenciaPessoaFerida.setBackground(Color.white);
        jNumeroOcorrenciaPessoasRefem.setBackground(Color.white);
        jNumeroOcorrenciaPessoasFeridaMortas.setBackground(Color.white);
        jNumeroHorasTVCFTV.setBackground(Color.white);
        jNumeroDiasSemScannerCorpo.setBackground(Color.white);
        jNumeroDiasIntMetaPortatil.setBackground(Color.white);
        jNumeroInterFuncVeiculosTP.setBackground(Color.white);
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
        jCondicionalDeferida.setBackground(Color.white);
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
        jPresoAtiviArtesPlasticas.setBackground(Color.white);
        jPresoAtiviLiteraria.setBackground(Color.white);
        jPresoAtiviCantoTeatro.setBackground(Color.white);
        jMatriculadoCursoProfissionalizante.setBackground(Color.white);
        jCertificadoCursoProfissionalizante.setBackground(Color.white);
        jPresoSentecaAtivLaboralRemun.setBackground(Color.white);
        jPresoAtiviLaboralNaoRemunera.setBackground(Color.white);
        //ABA AFI
        jAlimentaServidaInternoCafe.setBackground(Color.white);
        jAlimentaServidaInternoAlmoco.setBackground(Color.white);
        jAlimentaServidaInternoJantar.setBackground(Color.white);
        //ABA TOT
        jTotal_ATE_SOCIAL.setBackground(Color.white);
        jTotal_ALI_FOR_SERVIDORES.setBackground(Color.white);
        jTotal_ATE_SAUDE_INTERNO.setBackground(Color.white);
        jTotal_ATE_EDUCACIONAL.setBackground(Color.white);
        jTotal_MATERIAL_INTERNO.setBackground(Color.white);
        jTotal_ATI_RECREATIVA_RELIGIOSA.setBackground(Color.white);
        jTotal_ATEND_JURIDICO.setBackground(Color.white);
        jTotal_ASSIS_LABORAL.setBackground(Color.white);
        jTotal_ALIM_FOR_INTERNOS.setBackground(Color.white);
    }

    public void formatarCampos() {
        jObservacao.setLineWrap(true);
        jObservacao.setWrapStyleWord(true);
    }

    public void validarCampos() {
        //ABA ASSI        
        jAtendimentoPsiPreso.setDocument(new LimiteDigitosSoNum(8));
        jAtendimentoPsiFamilaPreso.setDocument(new LimiteDigitosSoNum(8));
        jNumeroDiasVisitas.setDocument(new LimiteDigitosSoNum(8));
        jNumeroVistantesInternos.setDocument(new LimiteDigitosSoNum(8));
        jMediaVisitasDia.setDocument(new LimiteDigitosSoNum(8));
        jMediaVisitasInterno.setDocument(new LimiteDigitosSoNum(8));
        jNumeroCriancasVisitas.setDocument(new LimiteDigitosSoNum(8));
        jPresoIdentCivil.setDocument(new LimiteDigitosSoNum(8));
        jPresoAtiviReligiosa.setDocument(new LimiteDigitosSoNum(8));
        //ABA AFV
        jLanchesServidoVisita.setDocument(new LimiteDigitosSoNum(8));
        jAlimentaServidaEmpContCafe.setDocument(new LimiteDigitosSoNum(8));
        jAlimentaServidaEmpContAlmoco.setDocument(new LimiteDigitosSoNum(8));
        jAlimentaServidaEmpContJantar.setDocument(new LimiteDigitosSoNum(8));
        jAlimentaServidaEmpContLanche.setDocument(new LimiteDigitosSoNum(8));
        jAlimentaServidaServContCafe.setDocument(new LimiteDigitosSoNum(8));
        jAlimentaServidaServContAlmoco.setDocument(new LimiteDigitosSoNum(8));
        jAlimentaServidaServContJantar.setDocument(new LimiteDigitosSoNum(8));
        jAlimentaServidaServContLanche.setDocument(new LimiteDigitosSoNum(8));
        //ASI
        jAtendimentoMedClinico.setDocument(new LimiteDigitosSoNum(8));
        jAtendimentoMedicoPsiquiatrico.setDocument(new LimiteDigitosSoNum(8));
        jAtendimentoEnfermagem.setDocument(new LimiteDigitosSoNum(8));
        jProcedimentoOdontologico.setDocument(new LimiteDigitosSoNum(8));
        jAtendimentoPsicologico.setDocument(new LimiteDigitosSoNum(8));
        jTratamentoAgravDiaginostico.setDocument(new LimiteDigitosSoNum(8));
        jAtendimentoOdontologicos.setDocument(new LimiteDigitosSoNum(8));
        jPresoDoencaInfecto.setDocument(new LimiteDigitosSoNum(8));
        jControlHipertensao.setDocument(new LimiteDigitosSoNum(8));
        jControleDiabetes.setDocument(new LimiteDigitosSoNum(8));
        jAspectosSexual.setDocument(new LimiteDigitosSoNum(8));
        jPresosVacinados.setDocument(new LimiteDigitosSoNum(8));
        //ABA AEI
        jPresoSentenciadoEF.setDocument(new LimiteDigitosSoNum(8));
        jPresoSentencaMatFreqEF.setDocument(new LimiteDigitosSoNum(8));
        jPresoAtiviPraticaEsportiva.setDocument(new LimiteDigitosSoNum(8));
        //ABA AMI
        jCobertor.setDocument(new LimiteDigitosSoNum(8));
        jColchao.setDocument(new LimiteDigitosSoNum(8));
        jColherPlastica.setDocument(new LimiteDigitosSoNum(8));
        jLencol.setDocument(new LimiteDigitosSoNum(8));
        jToalha.setDocument(new LimiteDigitosSoNum(8));
        jPote.setDocument(new LimiteDigitosSoNum(8));
        jCaneca.setDocument(new LimiteDigitosSoNum(8));
        jAparelhoBarbear.setDocument(new LimiteDigitosSoNum(8));
        jCremeDental.setDocument(new LimiteDigitosSoNum(8));
        jEscovaDente.setDocument(new LimiteDigitosSoNum(8));
        jAbsorvente.setDocument(new LimiteDigitosSoNum(8));
        jPapelHigienico.setDocument(new LimiteDigitosSoNum(8));
        jSabaoPo.setDocument(new LimiteDigitosSoNum(8));
        jSabonete.setDocument(new LimiteDigitosSoNum(8));
        jDesodorante.setDocument(new LimiteDigitosSoNum(8));
        jBermuda.setDocument(new LimiteDigitosSoNum(8));
        jCamisa.setDocument(new LimiteDigitosSoNum(8));
        jCuecas.setDocument(new LimiteDigitosSoNum(8));
        jChinelos.setDocument(new LimiteDigitosSoNum(8));
        jUniformeCompleto.setDocument(new LimiteDigitosSoNum(8));
        //ABA SEG
        jNumeroAparelhoConvive.setDocument(new LimiteDigitosSoNum(8));
        jObjetosMateriais.setDocument(new LimiteDigitosSoNum(8));
        jNumeroProcedRevista.setDocument(new LimiteDigitosSoNum(8));
        jNumeroOcorrenciasInd.setDocument(new LimiteDigitosSoNum(8));
        jNumeroOcorrenciaTentaFuga.setDocument(new LimiteDigitosSoNum(8));
        jNumeroOcorrenciaFuga.setDocument(new LimiteDigitosSoNum(8));
        jNumeroOcorrenciaRebeliao.setDocument(new LimiteDigitosSoNum(8));
        jNumeroOcorrenciaPessoaFerida.setDocument(new LimiteDigitosSoNum(8));
        jNumeroOcorrenciaPessoasRefem.setDocument(new LimiteDigitosSoNum(8));
        jNumeroOcorrenciaPessoasFeridaMortas.setDocument(new LimiteDigitosSoNum(8));
        jNumeroHorasTVCFTV.setDocument(new LimiteDigitosSoNum(8));
        jNumeroDiasSemScannerCorpo.setDocument(new LimiteDigitosSoNum(8));
        jNumeroDiasIntMetaPortatil.setDocument(new LimiteDigitosSoNum(8));
        jNumeroInterFuncVeiculosTP.setDocument(new LimiteDigitosSoNum(8));
        jNumeroFalhasGerador.setDocument(new LimiteDigitosSoNum(8));
        jNumeroHorasBloqueador.setDocument(new LimiteDigitosSoNum(8));
        jNumeroAbsorEntregueVisitas.setDocument(new LimiteDigitosSoNum(8));
        jNumeroFraldasEntreguePortaria.setDocument(new LimiteDigitosSoNum(8));
        //ABA AJ
        jAtendInternoSAJ.setDocument(new LimiteDigitosSoNum(8));
        jAlvaraSolturaCumprido.setDocument(new LimiteDigitosSoNum(8));
        jLivarmentoCondRequerido.setDocument(new LimiteDigitosSoNum(8));
        jProgressaoRegDeferido.setDocument(new LimiteDigitosSoNum(8));
        jSaidasTempDeferida.setDocument(new LimiteDigitosSoNum(8));
        jAlvarSolRecebeUni.setDocument(new LimiteDigitosSoNum(8));
        jAudienciaProvocadas.setDocument(new LimiteDigitosSoNum(8));
        jAudienciaCumpridas.setDocument(new LimiteDigitosSoNum(8));
        jJuriPopular.setDocument(new LimiteDigitosSoNum(8));
        jJuriPopularCumprido.setDocument(new LimiteDigitosSoNum(8));
        jLiberdadeProvRequerida.setDocument(new LimiteDigitosSoNum(8));
        jLiberdadeProvDeferida.setDocument(new LimiteDigitosSoNum(8));
        jIndultosRequeridos.setDocument(new LimiteDigitosSoNum(8));
        jIndultosDeferidos.setDocument(new LimiteDigitosSoNum(8));
        jRemissaoPenaRequerida.setDocument(new LimiteDigitosSoNum(8));
        jRemissaoPenaDeferida.setDocument(new LimiteDigitosSoNum(8));
        jCondicionalRequerida.setDocument(new LimiteDigitosSoNum(8));
        jCondicionalDeferida.setDocument(new LimiteDigitosSoNum(8));
        jProgressaoRegRequerido.setDocument(new LimiteDigitosSoNum(8));
        jSaidaTempRequerida.setDocument(new LimiteDigitosSoNum(8));
        jHabeasCorpusImpetrados.setDocument(new LimiteDigitosSoNum(8));
        jHabeasCorpusDeferido.setDocument(new LimiteDigitosSoNum(8));
        jLaudoPsicoEmitidos.setDocument(new LimiteDigitosSoNum(8));
        jLaudosPsiqEmitidos.setDocument(new LimiteDigitosSoNum(8));
        jTP.setDocument(new LimiteDigitosSoNum(4));
        //ABA AL
        jTriagemAtendInernos.setDocument(new LimiteDigitosSoNum(8));
        jOcupacaoAtiviRecreaReligiosa.setDocument(new LimiteDigitosSoNum(8));
        jPresoAtiviArtesPlasticas.setDocument(new LimiteDigitosSoNum(8));
        jPresoAtiviLiteraria.setDocument(new LimiteDigitosSoNum(8));
        jPresoAtiviCantoTeatro.setDocument(new LimiteDigitosSoNum(8));
        jMatriculadoCursoProfissionalizante.setDocument(new LimiteDigitosSoNum(8));
        jCertificadoCursoProfissionalizante.setDocument(new LimiteDigitosSoNum(8));
        jPresoSentecaAtivLaboralRemun.setDocument(new LimiteDigitosSoNum(8));
        jPresoAtiviLaboralNaoRemunera.setDocument(new LimiteDigitosSoNum(8));
        //ABA AFI
        jAlimentaServidaInternoCafe.setDocument(new LimiteDigitosSoNum(8));
        jAlimentaServidaInternoAlmoco.setDocument(new LimiteDigitosSoNum(8));
        jAlimentaServidaInternoJantar.setDocument(new LimiteDigitosSoNum(8));
        //ABA TOT
        jTotal_ATE_SOCIAL.setDocument(new LimiteDigitosSoNum(8));
        jTotal_ALI_FOR_SERVIDORES.setDocument(new LimiteDigitosSoNum(8));
        jTotal_ATE_SAUDE_INTERNO.setDocument(new LimiteDigitosSoNum(8));
        jTotal_ATE_EDUCACIONAL.setDocument(new LimiteDigitosSoNum(8));
        jTotal_MATERIAL_INTERNO.setDocument(new LimiteDigitosSoNum(8));
        jTotal_ATI_RECREATIVA_RELIGIOSA.setDocument(new LimiteDigitosSoNum(8));
        jTotal_ATEND_JURIDICO.setDocument(new LimiteDigitosSoNum(8));
        jTotal_ASSIS_LABORAL.setDocument(new LimiteDigitosSoNum(8));
        jTotal_ALIM_FOR_INTERNOS.setDocument(new LimiteDigitosSoNum(8));
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
        jBtCalcularTotais.setEnabled(opcao);
        jBtAtualizarDatas.setEnabled(opcao);
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
        jComboBoxMesReferencia.setEnabled(opcaoV);
        jComboBoxAnoReferencia.setEnabled(opcaoV);
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
        jPresoIdentCivil.setEnabled(opcaoF);
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
        jAtendimentoMedicoPsiquiatrico.setEnabled(opcaoF);
        jAtendimentoEnfermagem.setEnabled(opcaoF);
        jProcedimentoOdontologico.setEnabled(opcaoF);
        jAtendimentoPsicologico.setEnabled(opcaoF);
        jTratamentoAgravDiaginostico.setEnabled(opcaoF);
        jAtendimentoOdontologicos.setEnabled(opcaoF);
        jPresoDoencaInfecto.setEnabled(opcaoF);
        jControlHipertensao.setEnabled(opcaoF);
        jControleDiabetes.setEnabled(opcaoF);
        jAspectosSexual.setEnabled(opcaoV);
        jPresosVacinados.setEnabled(opcaoF);
        //ABA AEI
        jPresoSentenciadoEF.setEnabled(opcaoF);
        jPresoSentencaMatFreqEF.setEnabled(opcaoF);
        jPresoAtiviPraticaEsportiva.setEnabled(opcaoV);
        //ABA AMI
        jCobertor.setEnabled(opcaoF);
        jColchao.setEnabled(opcaoF);
        jColherPlastica.setEnabled(opcaoF);
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
        jNumeroOcorrenciasInd.setEnabled(opcaoV);
        jNumeroOcorrenciaTentaFuga.setEnabled(opcaoV);
        jNumeroOcorrenciaFuga.setEnabled(opcaoV);
        jNumeroOcorrenciaRebeliao.setEnabled(opcaoV);
        jNumeroOcorrenciaPessoaFerida.setEnabled(opcaoV);
        jNumeroOcorrenciaPessoasRefem.setEnabled(opcaoV);
        jNumeroOcorrenciaPessoasFeridaMortas.setEnabled(opcaoV);
        jNumeroHorasTVCFTV.setEnabled(opcaoV);
        jNumeroDiasSemScannerCorpo.setEnabled(opcaoV);
        jNumeroDiasIntMetaPortatil.setEnabled(opcaoV);
        jNumeroInterFuncVeiculosTP.setEnabled(opcaoV);
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
        jCondicionalDeferida.setEnabled(opcaoV);
        jProgressaoRegRequerido.setEnabled(opcaoV);
        jSaidaTempRequerida.setEnabled(opcaoV);
        jHabeasCorpusImpetrados.setEnabled(opcaoV);
        jHabeasCorpusDeferido.setEnabled(opcaoV);
        jLaudoPsicoEmitidos.setEnabled(opcaoV);
        jLaudosPsiqEmitidos.setEnabled(opcaoV);
        jTP.setEnabled(opcaoV);
        //ABA AL
        jTriagemAtendInernos.setEnabled(opcaoF);
        jOcupacaoAtiviRecreaReligiosa.setEnabled(opcaoV);
        jPresoAtiviArtesPlasticas.setEnabled(opcaoV);
        jPresoAtiviLiteraria.setEnabled(opcaoV);
        jPresoAtiviCantoTeatro.setEnabled(opcaoV);
        jMatriculadoCursoProfissionalizante.setEnabled(opcaoV);
        jCertificadoCursoProfissionalizante.setEnabled(opcaoV);
        jPresoSentecaAtivLaboralRemun.setEnabled(opcaoV);
        jPresoAtiviLaboralNaoRemunera.setEnabled(opcaoV);
        //ABA AFI
        jAlimentaServidaInternoCafe.setEnabled(opcaoV);
        jAlimentaServidaInternoAlmoco.setEnabled(opcaoV);
        jAlimentaServidaInternoJantar.setEnabled(opcaoV);
        //ABA TOT
        jTotal_ATE_SOCIAL.setEnabled(opcaoF);
        jTotal_ALI_FOR_SERVIDORES.setEnabled(opcaoF);
        jTotal_ATE_SAUDE_INTERNO.setEnabled(opcaoF);
        jTotal_ATE_EDUCACIONAL.setEnabled(opcaoF);
        jTotal_MATERIAL_INTERNO.setEnabled(opcaoF);
        jTotal_ATI_RECREATIVA_RELIGIOSA.setEnabled(opcaoF);
        jTotal_ATEND_JURIDICO.setEnabled(opcaoF);
        jTotal_ASSIS_LABORAL.setEnabled(opcaoF);
        jTotal_ALIM_FOR_INTERNOS.setEnabled(opcaoF);
    }

    public void abriCamposProdutosKit(boolean opcaoF) {
        //ABA AMI
        jCobertor.setEnabled(opcaoF);
        jColchao.setEnabled(opcaoF);
        jColherPlastica.setEnabled(opcaoF);
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
    }

    public void limparTodosCampos() {
        //ABA MANUTENÇÃO
        jChave.setText("");
        jStatus.setText("");
        jDataCriacao.setDate(null);
        jDataAtualizacao.setDate(null);
        jUnidadePrisional.setText("");
        jPopulacaoAtual.setText("0");
        jDataPeriodoInicial.setDate(null);
        jDataPeriodoFinal.setDate(null);
        jComboBoxMesReferencia.setSelectedItem("Selecione...");
        jComboBoxAnoReferencia.setSelectedItem("Selecione...");
        jIdFunc.setText("");
        jColaboradorResponsavel.setText("");
        jMatricula.setText("");
        jDepartamento.setText("");
        jObservacao.setText("");
        //ABA ASSI
        jAtendimentoPsiPreso.setText("0");
        jAtendimentoPsiFamilaPreso.setText("0");
        jNumeroDiasVisitas.setText("0");
        jNumeroVistantesInternos.setText("0");
        jMediaVisitasDia.setText("0");
        jMediaVisitasInterno.setText("0");
        jNumeroCriancasVisitas.setText("0");
        jPresoIdentCivil.setText("0");
        jPresoAtiviReligiosa.setText("0");
        //ABA AFV
        jLanchesServidoVisita.setText("0");
        jAlimentaServidaEmpContCafe.setText("0");
        jAlimentaServidaEmpContAlmoco.setText("0");
        jAlimentaServidaEmpContJantar.setText("0");
        jAlimentaServidaEmpContLanche.setText("0");
        jAlimentaServidaServContCafe.setText("0");
        jAlimentaServidaServContAlmoco.setText("0");
        jAlimentaServidaServContJantar.setText("0");
        jAlimentaServidaServContLanche.setText("0");
        //ASI
        jAtendimentoMedClinico.setText("0");
        jAtendimentoMedicoPsiquiatrico.setText("0");
        jAtendimentoEnfermagem.setText("0");
        jProcedimentoOdontologico.setText("0");
        jAtendimentoPsicologico.setText("0");
        jTratamentoAgravDiaginostico.setText("0");
        jAtendimentoOdontologicos.setText("0");
        jPresoDoencaInfecto.setText("0");
        jControlHipertensao.setText("0");
        jControleDiabetes.setText("0");
        jAspectosSexual.setText("0");
        jPresosVacinados.setText("0");
        //ABA AEI
        jPresoSentenciadoEF.setText("0");
        jPresoSentencaMatFreqEF.setText("0");
        jPresoAtiviPraticaEsportiva.setText("0");
        //ABA AMI
        jCobertor.setText("0");
        jColchao.setText("0");
        jColherPlastica.setText("0");
        jLencol.setText("0");
        jToalha.setText("0");
        jPote.setText("0");
        jCaneca.setText("0");
        jAparelhoBarbear.setText("0");
        jCremeDental.setText("0");
        jEscovaDente.setText("0");
        jAbsorvente.setText("0");
        jPapelHigienico.setText("0");
        jSabaoPo.setText("0");
        jSabonete.setText("0");
        jDesodorante.setText("0");
        jBermuda.setText("0");
        jCamisa.setText("0");
        jCuecas.setText("0");
        jChinelos.setText("0");
        jUniformeCompleto.setText("0");
        //ABA SEG
        jNumeroOcorrenciasInd.setText("0");
        jNumeroAparelhoConvive.setText("0");
        jObjetosMateriais.setText("0");
        jNumeroProcedRevista.setText("0");
        jNumeroOcorrenciasInd.setText("0");
        jNumeroOcorrenciaTentaFuga.setText("0");
        jNumeroOcorrenciaFuga.setText("0");
        jNumeroOcorrenciaRebeliao.setText("0");
        jNumeroOcorrenciaPessoaFerida.setText("0");
        jNumeroOcorrenciaPessoasRefem.setText("0");
        jNumeroOcorrenciaPessoasFeridaMortas.setText("0");
        jNumeroHorasTVCFTV.setText("0");
        jNumeroDiasSemScannerCorpo.setText("0");
        jNumeroDiasIntMetaPortatil.setText("0");
        jNumeroInterFuncVeiculosTP.setText("0");
        jNumeroFalhasGerador.setText("0");
        jNumeroHorasBloqueador.setText("0");
        jNumeroAbsorEntregueVisitas.setText("0");
        jNumeroFraldasEntreguePortaria.setText("0");
        //ABA AJ
        jAtendInternoSAJ.setText("0");
        jAlvaraSolturaCumprido.setText("0");
        jLivarmentoCondRequerido.setText("0");
        jProgressaoRegDeferido.setText("0");
        jSaidasTempDeferida.setText("0");
        jAlvarSolRecebeUni.setText("0");
        jAudienciaProvocadas.setText("0");
        jAudienciaCumpridas.setText("0");
        jJuriPopular.setText("0");
        jJuriPopularCumprido.setText("0");
        jLiberdadeProvRequerida.setText("0");
        jLiberdadeProvDeferida.setText("0");
        jIndultosRequeridos.setText("0");
        jIndultosDeferidos.setText("0");
        jRemissaoPenaRequerida.setText("0");
        jRemissaoPenaDeferida.setText("0");
        jCondicionalRequerida.setText("0");
        jCondicionalDeferida.setText("0");
        jProgressaoRegRequerido.setText("0");
        jSaidaTempRequerida.setText("0");
        jHabeasCorpusImpetrados.setText("0");
        jHabeasCorpusDeferido.setText("0");
        jLaudoPsicoEmitidos.setText("0");
        jLaudosPsiqEmitidos.setText("0");
        jTP.setText("0");
        //ABA AL
        jTriagemAtendInernos.setText("0");
        jOcupacaoAtiviRecreaReligiosa.setText("0");
        jPresoAtiviArtesPlasticas.setText("0");
        jPresoAtiviLiteraria.setText("0");
        jPresoAtiviCantoTeatro.setText("0");
        jMatriculadoCursoProfissionalizante.setText("0");
        jCertificadoCursoProfissionalizante.setText("0");
        jPresoSentecaAtivLaboralRemun.setText("0");
        jPresoAtiviLaboralNaoRemunera.setText("0");
        //ABA AFI
        jAlimentaServidaInternoCafe.setText("0");
        jAlimentaServidaInternoAlmoco.setText("0");
        jAlimentaServidaInternoJantar.setText("0");
        //ABA TOT
        jTotal_ATE_SOCIAL.setText("0");
        jTotal_ALI_FOR_SERVIDORES.setText("0");
        jTotal_ATE_SAUDE_INTERNO.setText("0");
        jTotal_ATE_EDUCACIONAL.setText("0");
        jTotal_MATERIAL_INTERNO.setText("0");
        jTotal_ATI_RECREATIVA_RELIGIOSA.setText("0");
        jTotal_ATEND_JURIDICO.setText("0");
        jTotal_ASSIS_LABORAL.setText("0");
        jTotal_ALIM_FOR_INTERNOS.setText("0");
    }

    public void pesquisaUnidadePrisional() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT IdUnidEmp,DescricaoUnidade FROM UNIDADE_PENAL_EMPRESA");
            conecta.rs.first();
            pID_UNIDADE = conecta.rs.getInt("IdUnidEmp");
            jUnidadePrisional.setText(conecta.rs.getString("DescricaoUnidade"));
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void calculoMediaPopulacao() {
        try {
            for (AtividadesMensalRealizadaUnidades pp : listaMediaPop.read()) {
                pp.getQuantidadeTotalPopulacao();
                pMEDIA_POPULCAO = pQUANTIDADE_TOTAL_POPULACAO / pQUANTIDADE_DIAS_POPULACAO;
                jPopulacaoAtual.setText(String.valueOf(pMEDIA_POPULCAO));
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAtividadesMensalUnidade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //HABILITAR OU NÃO A ABERTURA DOS CAMPOS DO KIT SE A UNIDADE TRABALHAR COM O KIT
    public void lerParamentoKit() {
        try {
            for (AtividadesMensalRealizadaUnidades pa : parametros.read()) {
                pa.getParametroKit();
                if (pa.getParametroKit().equals("Sim")) {
                    abriCamposProdutosKit(!true);
                } else if (pa.getParametroKit().equals("Não")) {
                    abriCamposProdutosKit(true);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAtividadesMensalUnidade.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    //MÉDIA DE VISITAS POR INTERNO
    public void calcularMediaVisitasInterno() {
        //FORMULA DA MÉDIDA
        //MV=QV/QI
        //LISTAGEM DE INTERNOS
        try {
            for (AtividadesMensalRealizadaUnidades dd25 : listagemInternosVistados.read()) {
                dd25.getDataEntradaVisita();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAtividadesMensalUnidade.class.getName()).log(Level.SEVERE, null, ex);
        }
        //LISTAGEM DE VISITAS
        try {
            for (AtividadesMensalRealizadaUnidades dd25 : listagemQuantidadeVistantes.read()) {
                dd25.getDataEntradaVisita();
                pMEDIA_VISITAS_POR_INTERNOS = pQUANTIDADE_VISITAS / pQUANTIDADE_INTERNOS;
                jMediaVisitasInterno.setText(String.valueOf(pMEDIA_VISITAS_POR_INTERNOS));
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

    //PRESOS IDENTIFICADO CIVILMENTE
    public void calculoPresoCivil() {
        try {
            for (AtividadesMensalRealizadaUnidades dd4 : listaInternosCivil.read()) {
                dd4.getDataEntradaVisita();
                jPresoIdentCivil.setText(String.valueOf(pQUANTIDADE_INTERNOS_CIVIL));
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
                jAtendimentoMedicoPsiquiatrico.setText(String.valueOf(pQUANDIDADE_ATE_PSIQUIATRICA));
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

    //AGRAVOS DIAGNOSTICADOS - ADMISSÃO
    public void calculoAgravosDIAG() {
        try {
            for (AtividadesMensalRealizadaUnidades dd16 : listaAgravosDiag.read()) {
                dd16.getTipoAtendimento();
                dd16.getTratamentoAgravosPNAISP();
            }
            //AGRAVOS DIAGNOSTICADOS - EVOLUÇÃO
            try {
                for (AtividadesMensalRealizadaUnidades dd19 : listaAgravosDiagEvo.read()) {
                    dd19.getTipoAtendimento();
                    dd19.getTratamentoAgravosPNAISP();
                    pTOTAL_GERAL_AGRAVADOS = pQUANTIDADE_TOTAL_AGRAVOS + pQUANTIDADE_TOTAL_AGRAVOS_EVO;
                    jTratamentoAgravDiaginostico.setText(String.valueOf(pTOTAL_GERAL_AGRAVADOS));
                }
            } catch (Exception ex) {
                Logger.getLogger(TelaAtividadesMensalUnidade.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAtividadesMensalUnidade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //DOENÇAS INFECTOCONTAGIOSAS - ADMISSÃO
    public void calculoDOENCA_INFECTOCONTAGIOSAS() {
        try {
            for (AtividadesMensalRealizadaUnidades dd20 : listaDoencaIntectoADM.read()) {
                dd20.getTipoAtendimento();
                dd20.getQuantidadeAdmInfectoTotal();
                jPresoDoencaInfecto.setText(String.valueOf(pQUANTIDADE_TOTAL_INFECTO));
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAtividadesMensalUnidade.class.getName()).log(Level.SEVERE, null, ex);
        }
        //DOENÇAS INFECTOCONTAGIOSAS - EVOLUÇÃO
        try {
            pQUANTIDADE_TOTAL_INFECTO_EVO_ADM = 0;
            for (AtividadesMensalRealizadaUnidades dd21 : listaDoencaInfectoEvol.read()) {
                dd21.getTipoAtendimento();
                dd21.getQuantidadeEvoInfectoTotal();
                dd21.getQuantidadeAdmInfectoTotal();
                pQUANTIDADE_TOTAL_INFECTO_EVO_ADM = pQUANTIDADE_TOTAL_INFECTO + pQUANTIDADE_TOTAL_INFECTO_EVO;
                jPresoDoencaInfecto.setText(String.valueOf(pQUANTIDADE_TOTAL_INFECTO_EVO_ADM));
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAtividadesMensalUnidade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //CONTROLE DE HIPERTNSÃO
    public void calculoControleHipertensao() {
        try {
            for (AtividadesMensalRealizadaUnidades dd17 : listaControleHiper.read()) {
                dd17.getTipoAtendimento();
                dd17.getSensibilizadoHipertensao();
                jControlHipertensao.setText(String.valueOf(pQUANTIDADE_HIPERTENSAO));
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAtividadesMensalUnidade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //CONTROLE DE DIABETES
    public void calculoControleDiabetes() {
        try {
            for (AtividadesMensalRealizadaUnidades dd18 : listaControleDiabetes.read()) {
                dd18.getTipoAtendimento();
                dd18.getSensibilizadoDiabetes();
                jControleDiabetes.setText(String.valueOf(pQUANTIDADE_DIABETES));
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAtividadesMensalUnidade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //PRESOS VACINADOS
    public void calculoControleVacinas() {
        try {
            for (AtividadesMensalRealizadaUnidades dd18 : listaInternosVacinados.read()) {
                dd18.getTipoAtendimento();
                jPresosVacinados.setText(String.valueOf(pQUANTIDADE_TOTAL_VACINAS));
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
    public void calcularPROKit() {
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
                dd12.getCelularLocalizadoConvivencia();
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
                dd13.getObjetoNaoAutorizadoLocalizadoConvivencia();
                jObjetosMateriais.setText(String.valueOf(pQUANTIDADE_OBJETOS_PROC));
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAtividadesMensalUnidade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void calcularQtdRevistaCela() {
        try {
            for (AtividadesMensalRealizadaUnidades dd14 : listaRevistaCela.read()) {
                dd14.getDataProcedimento();
                dd14.getObjetoNaoAutorizadoLocalizadoConvivencia();
                jNumeroProcedRevista.setText(String.valueOf(pQUANTIDADE_REVISTA_POR_CELA));
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAtividadesMensalUnidade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //QUANTIDADE DE PRODUTOS KIT HIGIENE 
    public void calculoProdutosKit() {
        try {
            for (AtividadesMensalRealizadaUnidades dd15 : listaProdutoKit.read()) {
                jAparelhoBarbear.setText(String.valueOf(dd15.getAparelhoBarbear()));
                jAbsorvente.setText(String.valueOf(dd15.getAbsorvente()));
                jBermuda.setText(String.valueOf(dd15.getBermuda()));
                jCamisa.setText(String.valueOf(dd15.getCamisa()));
                jCaneca.setText(String.valueOf(dd15.getCaneca()));
                jCobertor.setText(String.valueOf(dd15.getCobertor()));
                jColchao.setText(String.valueOf(dd15.getColchao()));
                jColherPlastica.setText(String.valueOf(dd15.getColher()));
                jCuecas.setText(String.valueOf(dd15.getCueca()));
                jCremeDental.setText(String.valueOf(dd15.getCremeDental()));
                jDesodorante.setText(String.valueOf(dd15.getDesodorante()));
                jEscovaDente.setText(String.valueOf(dd15.getEscova()));
                jLencol.setText(String.valueOf(dd15.getLencol()));
                jPapelHigienico.setText(String.valueOf(dd15.getPapelHigienico()));
                jChinelos.setText(String.valueOf(dd15.getParChinelos()));
                jPote.setText(String.valueOf(dd15.getPote()));
                jSabaoPo.setText(String.valueOf(dd15.getSabaoPo()));
                jSabonete.setText(String.valueOf(dd15.getSabonete()));
                jToalha.setText(String.valueOf(dd15.getToalha()));
                jUniformeCompleto.setText(String.valueOf(dd15.getUniformeCompleto()));
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAtividadesMensalUnidade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //QUANTIDADE DE ATENDIMENTO FAMILIA - JURIDICO 
    public void calculoATENJURI() {
        try {
            for (AtividadesMensalRealizadaUnidades dd22 : listaAtendFam.read()) {
                dd22.getDataProcedimento();
                jAtendInternoSAJ.setText(String.valueOf(pQUANTIDADE_ATENDE_FAMILIA_JURI));
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAtividadesMensalUnidade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //SAIDA ALVARÁ
    public void calculoSAIDA_ALVARA_LIVRAMENTO_PROGESSAO() {
        try {
            for (AtividadesMensalRealizadaUnidades dd23 : listaSaidaAlvara.read()) {
                dd23.getDataProcedimento();
                jAlvaraSolturaCumprido.setText(String.valueOf(pQUANTIDADE_ALVARA));
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAtividadesMensalUnidade.class.getName()).log(Level.SEVERE, null, ex);
        }
        //LIVRAMENTO CONDICIONAL
        try {
            for (AtividadesMensalRealizadaUnidades dd24 : listaLivramento.read()) {
                dd24.getDataProcedimento();
                jLivarmentoCondRequerido.setText(String.valueOf(pQUANTIDADE_LIVRAMENTO));
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAtividadesMensalUnidade.class.getName()).log(Level.SEVERE, null, ex);
        }
        //PROGRESSÃO DE REGIME
        try {
            for (AtividadesMensalRealizadaUnidades dd25 : listaProgressao.read()) {
                dd25.getDataProcedimento();
                jProgressaoRegDeferido.setText(String.valueOf(pQUANTIDADE_PROGRESSAO));
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAtividadesMensalUnidade.class.getName()).log(Level.SEVERE, null, ex);
        }
        //SAÍDA TEMPORARIA
        try {
            for (AtividadesMensalRealizadaUnidades dd26 : listaSaidaTMP.read()) {
                dd26.getDataProcedimento();
                jSaidasTempDeferida.setText(String.valueOf(pQUANTIDADE_SAIDA_TMP));
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAtividadesMensalUnidade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //ATENDIMENTO TRIAGEM TO
    public void calculoATEN_TO() {
        try {
            for (AtividadesMensalRealizadaUnidades dd31 : listaADMEVO.read()) {
                dd31.getDataProcedimento();
                jTriagemAtendInernos.setText(String.valueOf(pQUANTIDADE_TOTAL_TO));
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAtividadesMensalUnidade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //CALCULAR OS TOTAIS PARA O RELATÓRIO
    public void calculosTOTAIS() {
        //ABA ASSI
        pQUANT_TOTAL_SOCIAL = 0;
        pQUANT_TOTAL_SOCIAL = Integer.parseInt(jAtendimentoPsiPreso.getText())
                + Integer.parseInt(jAtendimentoPsiFamilaPreso.getText())
                + Integer.parseInt(jPresoIdentCivil.getText());
        jTotal_ATE_SOCIAL.setText(String.valueOf(pQUANT_TOTAL_SOCIAL));
        // ABA AFV
        pQUANT_TOTAL_SERVIDORES = 0;
        pQUANT_TOTAL_SERVIDORES = Integer.parseInt(jLanchesServidoVisita.getText())
                + Integer.parseInt(jAlimentaServidaEmpContCafe.getText())
                + Integer.parseInt(jAlimentaServidaEmpContAlmoco.getText())
                + Integer.parseInt(jAlimentaServidaEmpContJantar.getText())
                + Integer.parseInt(jAlimentaServidaEmpContLanche.getText())
                + Integer.parseInt(jAlimentaServidaServContCafe.getText())
                + Integer.parseInt(jAlimentaServidaServContAlmoco.getText())
                + Integer.parseInt(jAlimentaServidaServContJantar.getText())
                + Integer.parseInt(jAlimentaServidaServContLanche.getText());
        jTotal_ALI_FOR_SERVIDORES.setText(String.valueOf(pQUANT_TOTAL_SERVIDORES));
        // ABA ASI
        pQUANT_TOTAL_SAUDE_INTERNO = 0;
        pQUANT_TOTAL_SAUDE_INTERNO = Integer.parseInt(jAtendimentoMedClinico.getText())
                + Integer.parseInt(jAtendimentoMedicoPsiquiatrico.getText())
                + Integer.parseInt(jAtendimentoEnfermagem.getText())
                + Integer.parseInt(jProcedimentoOdontologico.getText())
                + Integer.parseInt(jAtendimentoPsicologico.getText())
                + Integer.parseInt(jTratamentoAgravDiaginostico.getText())
                + Integer.parseInt(jAtendimentoOdontologicos.getText())
                + Integer.parseInt(jPresoDoencaInfecto.getText())
                + Integer.parseInt(jControlHipertensao.getText())
                + Integer.parseInt(jControleDiabetes.getText())
                + Integer.parseInt(jPresosVacinados.getText())
                + Integer.parseInt(jAspectosSexual.getText());
        jTotal_ATE_SAUDE_INTERNO.setText(String.valueOf(pQUANT_TOTAL_SAUDE_INTERNO));
        //ABA AEI
        pQUANT_TOTAL_EDUCACIONAL = 0;
        pQUANT_TOTAL_EDUCACIONAL = Integer.parseInt(jPresoSentenciadoEF.getText())
                + Integer.parseInt(jPresoSentencaMatFreqEF.getText())
                + Integer.parseInt(jMatriculadoCursoProfissionalizante.getText())
                + Integer.parseInt(jCertificadoCursoProfissionalizante.getText());
        jTotal_ATE_EDUCACIONAL.setText(String.valueOf(pQUANT_TOTAL_EDUCACIONAL));
        //ABA AMI
        pQUANT_TOTAL_MATERIAL_INTERNO = 0;
        pQUANT_TOTAL_MATERIAL_INTERNO = Integer.parseInt(jAparelhoBarbear.getText())
                + Integer.parseInt(jAbsorvente.getText())
                + Integer.parseInt(jBermuda.getText())
                + Integer.parseInt(jCamisa.getText())
                + Integer.parseInt(jCaneca.getText())
                + Integer.parseInt(jCobertor.getText())
                + Integer.parseInt(jColherPlastica.getText())
                + Integer.parseInt(jColchao.getText())
                + Integer.parseInt(jCuecas.getText())
                + Integer.parseInt(jCremeDental.getText())
                + Integer.parseInt(jDesodorante.getText())
                + Integer.parseInt(jEscovaDente.getText())
                + Integer.parseInt(jLencol.getText())
                + Integer.parseInt(jPapelHigienico.getText())
                + Integer.parseInt(jChinelos.getText())
                + Integer.parseInt(jPote.getText())
                + Integer.parseInt(jSabaoPo.getText())
                + Integer.parseInt(jSabonete.getText())
                + Integer.parseInt(jToalha.getText())
                + Integer.parseInt(jUniformeCompleto.getText());
        jTotal_MATERIAL_INTERNO.setText(String.valueOf(pQUANT_TOTAL_MATERIAL_INTERNO));
        //ABA ATIVIDADES RELIGIOSAS
        pQUANT_TOTAL_RECREATIVA_RELIGIOSA = 0;
        pQUANT_TOTAL_RECREATIVA_RELIGIOSA = Integer.parseInt(jPresoAtiviArtesPlasticas.getText())
                + Integer.parseInt(jPresoAtiviLiteraria.getText())
                + Integer.parseInt(jPresoAtiviCantoTeatro.getText())
                + Integer.parseInt(jPresoAtiviPraticaEsportiva.getText())
                + Integer.parseInt(jPresoAtiviReligiosa.getText());
        jTotal_ATI_RECREATIVA_RELIGIOSA.setText(String.valueOf(pQUANT_TOTAL_RECREATIVA_RELIGIOSA));
        //ABA AJ
        pQUANT_TOTAL_JURIDICO = 0;
        pQUANT_TOTAL_JURIDICO = Integer.parseInt(jAtendInternoSAJ.getText())
                + Integer.parseInt(jAlvaraSolturaCumprido.getText())
                + Integer.parseInt(jLivarmentoCondRequerido.getText())
                + Integer.parseInt(jProgressaoRegDeferido.getText())
                + Integer.parseInt(jSaidasTempDeferida.getText())
                + Integer.parseInt(jAlvarSolRecebeUni.getText())
                + Integer.parseInt(jAudienciaProvocadas.getText())
                + Integer.parseInt(jAudienciaCumpridas.getText())
                + Integer.parseInt(jJuriPopular.getText())
                + Integer.parseInt(jJuriPopularCumprido.getText())
                + Integer.parseInt(jLiberdadeProvRequerida.getText())
                + Integer.parseInt(jLiberdadeProvDeferida.getText())
                + Integer.parseInt(jIndultosRequeridos.getText())
                + Integer.parseInt(jIndultosDeferidos.getText())
                + Integer.parseInt(jRemissaoPenaRequerida.getText())
                + Integer.parseInt(jRemissaoPenaDeferida.getText())
                + Integer.parseInt(jCondicionalDeferida.getText())
                + Integer.parseInt(jCondicionalRequerida.getText())
                + Integer.parseInt(jProgressaoRegRequerido.getText())
                + Integer.parseInt(jSaidaTempRequerida.getText())
                + Integer.parseInt(jHabeasCorpusImpetrados.getText())
                + Integer.parseInt(jHabeasCorpusDeferido.getText())
                + Integer.parseInt(jLaudoPsicoEmitidos.getText())
                + Integer.parseInt(jLaudosPsiqEmitidos.getText())
                + Integer.parseInt(jTP.getText());
        jTotal_ATEND_JURIDICO.setText(String.valueOf(pQUANT_TOTAL_JURIDICO));
        //ABA AL
        pQUANT_TOTAL_LABORAL = 0;
        pQUANT_TOTAL_LABORAL = Integer.parseInt(jTriagemAtendInernos.getText())
                + Integer.parseInt(jPresoSentecaAtivLaboralRemun.getText())
                + Integer.parseInt(jPresoAtiviLaboralNaoRemunera.getText());
        jTotal_ASSIS_LABORAL.setText(String.valueOf(pQUANT_TOTAL_LABORAL));
        //ABA AFI
        pQUANT_TOTAL_FOR_INTERNOS = 0;
        pQUANT_TOTAL_FOR_INTERNOS = Integer.parseInt(jAlimentaServidaInternoCafe.getText())
                + Integer.parseInt(jAlimentaServidaInternoAlmoco.getText())
                + Integer.parseInt(jAlimentaServidaInternoJantar.getText());
        jTotal_ALIM_FOR_INTERNOS.setText(String.valueOf(pQUANT_TOTAL_FOR_INTERNOS));
    }

    public void zerarTotais() {
        pQUANT_TOTAL_SOCIAL = 0;
        pQUANT_TOTAL_SERVIDORES = 0;
        pQUANT_TOTAL_SAUDE_INTERNO = 0;
        pQUANT_TOTAL_EDUCACIONAL = 0;
        pQUANT_TOTAL_MATERIAL_INTERNO = 0;
        pQUANT_TOTAL_RECREATIVA_RELIGIOSA = 0;
        pQUANT_TOTAL_JURIDICO = 0;
        pQUANT_TOTAL_LABORAL = 0;
        pQUANT_TOTAL_FOR_INTERNOS = 0;
    }

    //ATUALIZAR DATAS DAS TABELAS REFERENTES AS ATIVIDADES DA UNIDADE
    public void atualizarDatasRegistrosTabelas() {
        converteDate.alterarDataAtividadeUnidade(objAtividade);
        converteDate.alterarDataPopulacao(objAtividade);
        converteDate.alterarDataItensKit(objAtividade);
        converteDate.alterarDataMatriculaEscolar(objAtividade);
        converteDate.alterarDataProcedimentoJURI(objAtividade);
        converteDate.alterarDataProcedimentoREV(objAtividade);
        converteDate.alterarDataRegAtendimentoPSP(objAtividade);
        converteDate.alterarDataSaidaAlvara(objAtividade);
    }

    public void Novo() {
        jStatus.setText("ABERTO");
        jDataCriacao.setCalendar(Calendar.getInstance());
        //
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtPesquisarColaborador.setEnabled(true);
        jBtPesquisarDatas.setEnabled(true);
        jBtCalcularTotais.setEnabled(true);
        jBtAtualizarDatas.setEnabled(true);
    }

    public void Alterar() {
        jDataAtualizacao.setCalendar(Calendar.getInstance());
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtPesquisarColaborador.setEnabled(true);
        jBtPesquisarDatas.setEnabled(true);
        jBtCalcularTotais.setEnabled(true);
        jBtAtualizarDatas.setEnabled(true);
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
        jBtNovo.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        jBtImpressao.setEnabled(true);
    }

    public void buscarChave() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT IdAtividade "
                    + "FROM ATIVIDADES_UNIDADE");
            conecta.rs.last();
            jChave.setText(conecta.rs.getString("IdAtividade"));
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void beans() {
        //MOVIMENTAÇÃO
        objAtividade.setStatus(jStatus.getText());
        objAtividade.setDataCriacao(jDataCriacao.getDate());
        objAtividade.setDataAtualizacao(jDataAtualizacao.getDate());
        objAtividade.setIdUnidade(pID_UNIDADE);
        objAtividade.setUnidadePrisional(jUnidadePrisional.getText());
        objAtividade.setMediaPopulacao(Integer.valueOf(jPopulacaoAtual.getText()));
        objAtividade.setDataPeriodoInicial(jDataPeriodoInicial.getDate());
        objAtividade.setDataPeriodoFinal(jDataPeriodoFinal.getDate());
        objAtividade.setMesReferencia((String) jComboBoxMesReferencia.getSelectedItem());
        objAtividade.setAnoReferencia((String) jComboBoxAnoReferencia.getSelectedItem());
        objAtividade.setIdFunc(Integer.valueOf(jIdFunc.getText()));
        objAtividade.setColaboradorResponsavel(jColaboradorResponsavel.getText());
        objAtividade.setObservacao(jObservacao.getText());
        //ABA ASSI - 01
        objAtividade.setAtendimentoPsiPreso(Integer.valueOf(jAtendimentoPsiPreso.getText()));
        objAtividade.setAtendimentoPsiFamilaPreso(Integer.valueOf(jAtendimentoPsiFamilaPreso.getText()));
        objAtividade.setNumeroDiasVisitas(Integer.valueOf(jNumeroDiasVisitas.getText()));
        objAtividade.setNumeroVistantesInternos(Integer.valueOf(jNumeroVistantesInternos.getText()));
        objAtividade.setMediaVisitasDia(Integer.valueOf(jMediaVisitasDia.getText()));
        objAtividade.setMediaVisitasInterno(Integer.valueOf(jMediaVisitasInterno.getText()));
        objAtividade.setNumeroCriancasVisitas(Integer.valueOf(jNumeroCriancasVisitas.getText()));
        objAtividade.setPresoIdentCivil(Integer.valueOf(jPresoIdentCivil.getText()));
        objAtividade.setPresoAtiviReligiosa(Integer.valueOf(jPresoAtiviReligiosa.getText()));
        //ABA AF - 02
        objAtividade.setLanchesVisitantes(Integer.valueOf(jLanchesServidoVisita.getText()));
        objAtividade.setCafeContratada(Integer.valueOf(jAlimentaServidaEmpContCafe.getText()));
        objAtividade.setAlmocoContratada(Integer.valueOf(jAlimentaServidaEmpContAlmoco.getText()));
        objAtividade.setJantarContratada(Integer.valueOf(jAlimentaServidaEmpContJantar.getText()));
        objAtividade.setLancheContratada(Integer.valueOf(jAlimentaServidaEmpContLanche.getText()));
        objAtividade.setCafeContratante(Integer.valueOf(jAlimentaServidaServContCafe.getText()));
        objAtividade.setAlmocoContratante(Integer.valueOf(jAlimentaServidaServContAlmoco.getText()));
        objAtividade.setJantarContratante(Integer.valueOf(jAlimentaServidaServContJantar.getText()));
        objAtividade.setLancheContratante(Integer.valueOf(jAlimentaServidaServContLanche.getText()));
        //ABA ASI - 03
        objAtividade.setAtendimentoClinico(Integer.valueOf(jAtendimentoMedClinico.getText()));
        objAtividade.setAtendimentoPsiquiatrico(Integer.valueOf(jAtendimentoMedicoPsiquiatrico.getText()));
        objAtividade.setAtendimentoEnfermagem(Integer.valueOf(jAtendimentoEnfermagem.getText()));
        objAtividade.setProcedimentoOdontologico(Integer.valueOf(jProcedimentoOdontologico.getText()));
        objAtividade.setAtendimentoPsicologico(Integer.valueOf(jAtendimentoPsicologico.getText()));
        objAtividade.setTratamentoAgravosPNAISP(Integer.valueOf(jTratamentoAgravDiaginostico.getText()));
        objAtividade.setAtendimentoOdontologico(Integer.valueOf(jAtendimentoOdontologicos.getText()));
        objAtividade.setSensibilizadoInfectocontagiosas(Integer.valueOf(jPresoDoencaInfecto.getText()));
        objAtividade.setSensibilizadoHipertensao(Integer.valueOf(jControlHipertensao.getText()));
        objAtividade.setSensibilizadoDiabetes(Integer.valueOf(jControleDiabetes.getText()));
        objAtividade.setVacinadosPNI(Integer.valueOf(jPresosVacinados.getText()));
        objAtividade.setSensibilizadoSexualidade(Integer.valueOf(jAspectosSexual.getText()));
        //ABA AEI - 04
        objAtividade.setMatriculadoEnsinoFormal(Integer.valueOf(jPresoSentenciadoEF.getText()));
        objAtividade.setFrequentandoEnsinoFormal(Integer.valueOf(jPresoSentencaMatFreqEF.getText()));
        objAtividade.setEsportes(Integer.valueOf(jPresoAtiviPraticaEsportiva.getText()));
        //ABA AMI - 05
        objAtividade.setAparelhoBarbear(Integer.valueOf(jAparelhoBarbear.getText()));
        objAtividade.setAbsorvente(Integer.valueOf(jAbsorvente.getText()));
        objAtividade.setBermuda(Integer.valueOf(jBermuda.getText()));
        objAtividade.setCamisa(Integer.valueOf(jCamisa.getText()));
        objAtividade.setCaneca(Integer.valueOf(jCaneca.getText()));
        objAtividade.setCobertor(Integer.valueOf(jCobertor.getText()));
        objAtividade.setColher(Integer.valueOf(jColherPlastica.getText()));
        objAtividade.setColchao(Integer.valueOf(jColchao.getText()));
        objAtividade.setCueca(Integer.valueOf(jCuecas.getText()));
        objAtividade.setCremeDental(Integer.valueOf(jCremeDental.getText()));
        objAtividade.setDesodorante(Integer.valueOf(jDesodorante.getText()));
        objAtividade.setEscova(Integer.valueOf(jEscovaDente.getText()));
        objAtividade.setLencol(Integer.valueOf(jLencol.getText()));
        objAtividade.setPapelHigienico(Integer.valueOf(jPapelHigienico.getText()));
        objAtividade.setParChinelos(Integer.valueOf(jChinelos.getText()));
        objAtividade.setPote(Integer.valueOf(jPote.getText()));
        objAtividade.setSabaoPo(Integer.valueOf(jSabaoPo.getText()));
        objAtividade.setSabonete(Integer.valueOf(jSabonete.getText()));
        objAtividade.setToalha(Integer.valueOf(jToalha.getText()));
        objAtividade.setUniformeCompleto(Integer.valueOf(jUniformeCompleto.getText()));
        //SEG - 06                   
        objAtividade.setCelularLocalizadoConvivencia(Integer.valueOf(jNumeroAparelhoConvive.getText()));
        objAtividade.setObjetoNaoAutorizadoLocalizadoConvivencia(Integer.valueOf(jObjetosMateriais.getText()));
        objAtividade.setRevistaCela(Integer.valueOf(jNumeroProcedRevista.getText()));
        objAtividade.setOcorrenciaIndisciplina(Integer.valueOf(jNumeroOcorrenciasInd.getText()));
        objAtividade.setTentativaFuga(Integer.valueOf(jNumeroOcorrenciaTentaFuga.getText()));
        objAtividade.setOcorrenciaFuga(Integer.valueOf(jNumeroOcorrenciaFuga.getText()));
        objAtividade.setOcorrenciaRebeliao(Integer.valueOf(jNumeroOcorrenciaRebeliao.getText()));
        objAtividade.setOcorrenciaFerido(Integer.valueOf(jNumeroOcorrenciaPessoaFerida.getText()));
        objAtividade.setOcorrenciaRefem(Integer.valueOf(jNumeroOcorrenciaPessoasRefem.getText()));
        objAtividade.setOcorrenciaGravementeFeridoMorto(Integer.valueOf(jNumeroOcorrenciaPessoasFeridaMortas.getText()));
        objAtividade.setHorasInterrupcaoCFTV(Integer.valueOf(jNumeroHorasTVCFTV.getText()));
        objAtividade.setDiasInterrupcaoScannerCorporal(Integer.valueOf(jNumeroDiasSemScannerCorpo.getText()));
        objAtividade.setDiasInterrupcaoRaioXDetectorMetais(Integer.valueOf(jNumeroDiasIntMetaPortatil.getText()));
        objAtividade.setDiasInterrupcaoVeiculoTransportePreso(Integer.valueOf(jNumeroInterFuncVeiculosTP.getText()));
        objAtividade.setFalhaGeradorEnergia(Integer.valueOf(jNumeroFalhasGerador.getText()));
        objAtividade.setHorasMauFuncionamentoBRS(Integer.valueOf(jNumeroHorasBloqueador.getText()));
        objAtividade.setAbsorventesEntreguesPortariaScanner(Integer.valueOf(jNumeroAbsorEntregueVisitas.getText()));
        objAtividade.setFraldasEntreguesPortariaScanner(Integer.valueOf(jNumeroFraldasEntreguePortaria.getText()));
        //ABA AJ - 07
        objAtividade.setInternoFamiliaSAJ(Integer.valueOf(jAtendInternoSAJ.getText()));
        objAtividade.setAlvaraSolturaCumprido(Integer.valueOf(jAlvaraSolturaCumprido.getText()));
        objAtividade.setLivramentoCondicionalRequerido(Integer.valueOf(jLivarmentoCondRequerido.getText()));
        objAtividade.setProgressaoRegimeDeferida(Integer.valueOf(jProgressaoRegDeferido.getText()));
        objAtividade.setSaidasTemporariasDeferida(Integer.valueOf(jSaidasTempDeferida.getText()));
        objAtividade.setAlvaraSolturaRecebido(Integer.valueOf(jAlvarSolRecebeUni.getText()));
        objAtividade.setAudienciaProvocada(Integer.valueOf(jAudienciaProvocadas.getText()));
        objAtividade.setAudienciaCumprida(Integer.valueOf(jAudienciaCumpridas.getText()));
        objAtividade.setJuriProvocado(Integer.valueOf(jJuriPopular.getText()));
        objAtividade.setJuriCumprido(Integer.valueOf(jJuriPopularCumprido.getText()));
        objAtividade.setLiberdadeProvisoriaRequerida(Integer.valueOf(jLiberdadeProvRequerida.getText()));
        objAtividade.setLiberdadeProvisoriaDeferida(Integer.valueOf(jLiberdadeProvDeferida.getText()));
        objAtividade.setIndultosRequeridos(Integer.valueOf(jIndultosRequeridos.getText()));
        objAtividade.setIndultosDeferidos(Integer.valueOf(jIndultosDeferidos.getText()));
        objAtividade.setRemicaoRequerida(Integer.valueOf(jRemissaoPenaRequerida.getText()));
        objAtividade.setRemicaoDeferida(Integer.valueOf(jRemissaoPenaDeferida.getText()));
        objAtividade.setCondicionalRequerida(Integer.valueOf(jCondicionalRequerida.getText()));
        objAtividade.setCondicionalDeferida(Integer.valueOf(jCondicionalDeferida.getText()));
        objAtividade.setProgressaoRegimeRequerida(Integer.valueOf(jProgressaoRegRequerido.getText()));
        objAtividade.setSaidasTemporariasRequerida(Integer.valueOf(jSaidaTempRequerida.getText()));
        objAtividade.setHabeasCorpusRequerido(Integer.valueOf(jHabeasCorpusImpetrados.getText()));
        objAtividade.setHabeasCorpusDeferido(Integer.valueOf(jHabeasCorpusDeferido.getText()));
        objAtividade.setLaudosPsicologicos(Integer.valueOf(jLaudoPsicoEmitidos.getText()));
        objAtividade.setLaudosPsiquiatricos(Integer.valueOf(jLaudosPsiqEmitidos.getText()));
        objAtividade.setTransferenciaProvimento(Integer.valueOf(jTP.getText()));
        //ABA AL - 08
        objAtividade.setTriagem(Integer.valueOf(jTriagemAtendInernos.getText()));
        objAtividade.setMatriculadoCursoProfissionalizante(Integer.valueOf(jMatriculadoCursoProfissionalizante.getText()));
        objAtividade.setCertificadoCursoProfissionalizante(Integer.valueOf(jCertificadoCursoProfissionalizante.getText()));
        objAtividade.setReligiosa(Integer.valueOf(jOcupacaoAtiviRecreaReligiosa.getText()));
        objAtividade.setArtesPlasticas(Integer.valueOf(jPresoAtiviArtesPlasticas.getText()));
        objAtividade.setLiteratura(Integer.valueOf(jPresoAtiviLiteraria.getText()));
        objAtividade.setCantoTeatroCinema(Integer.valueOf(jPresoAtiviCantoTeatro.getText()));
        objAtividade.setLaborativaRemunerada(Integer.valueOf(jPresoSentecaAtivLaboralRemun.getText()));
        objAtividade.setLaborativaNaoRemunerada(Integer.valueOf(jPresoAtiviLaboralNaoRemunera.getText()));
        //ABA AFI - 09
        objAtividade.setCafeInterno(Integer.valueOf(jAlimentaServidaInternoCafe.getText()));
        objAtividade.setAlmocoInterno(Integer.valueOf(jAlimentaServidaInternoAlmoco.getText()));
        objAtividade.setJantarInterno(Integer.valueOf(jAlimentaServidaInternoJantar.getText()));
        //ABA TOT
        objAtividade.setTotalServicoSocial(Integer.valueOf(jTotal_ATE_SOCIAL.getText()));
        objAtividade.setTotalAlimentacao(Integer.valueOf(jTotal_ALI_FOR_SERVIDORES.getText()));
        objAtividade.setTotalSaude(Integer.valueOf(jTotal_ATE_SAUDE_INTERNO.getText()));
        objAtividade.setTotalEducacional(Integer.valueOf(jTotal_ATE_EDUCACIONAL.getText()));
        objAtividade.setTotalMaterial(Integer.valueOf(jTotal_MATERIAL_INTERNO.getText()));
        objAtividade.setTotalRecreativaReligiosa(Integer.valueOf(jTotal_ATI_RECREATIVA_RELIGIOSA.getText()));
        objAtividade.setTotalJuridico(Integer.valueOf(jTotal_ATEND_JURIDICO.getText()));
        objAtividade.setTotalLaboral(Integer.valueOf(jTotal_ASSIS_LABORAL.getText()));
        objAtividade.setTotalAlimentacaoInterno(Integer.valueOf(jTotal_ALIM_FOR_INTERNOS.getText()));
    }

    public void verificarRangeDatasMesAno() {
        SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
        pMES_REFERENCIA = formatoAmerica.format(jDataPeriodoInicial.getDate().getTime());
        if (jComboBoxMesReferencia.getSelectedItem().equals("Janeiro")) {
            pMES_01 = "01";
            pDIA = pMES_REFERENCIA.substring(0, 1);
            pMES = pMES_REFERENCIA.substring(3, 5);
            pANO = pMES_REFERENCIA.substring(6, 10);
            pMES_REFERENCIA = pMES;
            if (pMES_REFERENCIA.equals(pMES_01) && jComboBoxAnoReferencia.getSelectedItem().equals(pANO)) {
                calculoMediaPopulacao();
                //ABA ASSI - SERVIÇO SOCIAL
                calculoSS();
                calculoSSF();
                calculoVI();
                caluloVC();
                calculoPresoCivil();
                calculoMED();
                caluloQTVD();
                //CALCUAR AS MÉDIAS
                if (pQUANTIDADE_VISITA_FAMILIA_INT != 0 && pQUANTIDADE_DIAS_VISITADOS != 0) {
                    pMEDIA_VISITAS_POR_DIA = (pQUANTIDADE_VISITA_FAMILIA_INT / pQUANTIDADE_DIAS_VISITADOS);
                    jMediaVisitasDia.setText(String.valueOf(pMEDIA_VISITAS_POR_DIA));
                    calcularMediaVisitasInterno();
                } else if (pQUANTIDADE_VISITA_FAMILIA_INT == 0 || pQUANTIDADE_DIAS_VISITADOS == 0) {
                    jMediaVisitasDia.setText("0");
                }
                //ABA ASI
                calculoMED();
                calculoPSIQ();
                calculoENFER();
                calculoAgravosDIAG();
                calculoControleHipertensao();
                calculoControleDiabetes();
                calculoDOENCA_INFECTOCONTAGIOSAS();
                calculoControleVacinas();
                calculoPSI();
                calculoProcODON();
                calculoAtendODON();
                //ABA AEI
                calculoMatPED();
                calculoFreqPED();
                //AEI
                calculoProdutosKit();
                //ABA SEG
                calculoCelularSEG();
                calcularObjetos();
                calcularQtdRevistaCela();
                //ABA AJ
                calculoATENJURI();
                calculoSAIDA_ALVARA_LIVRAMENTO_PROGESSAO();
                calculoATEN_TO();
                //MÊS DE FEVEREIRO
            } else {
                JOptionPane.showMessageDialog(rootPane, "Dados incorreto, verifique se mês e o ano selecionado estão de acordo com a data inicial.");
            }
        } else if (jComboBoxMesReferencia.getSelectedItem().equals("Fevereiro")) {
            pMES_02 = "02";
            pDIA = pMES_REFERENCIA.substring(0, 1);
            pMES = pMES_REFERENCIA.substring(3, 5);
            pANO = pMES_REFERENCIA.substring(6, 10);
            pMES_REFERENCIA = pMES;
            if (pMES_REFERENCIA.equals(pMES_02) && jComboBoxAnoReferencia.getSelectedItem().equals(pANO)) {
                calculoMediaPopulacao();
                //ABA ASSI - SERVIÇO SOCIAL
                calculoSS();
                calculoSSF();
                calculoVI();
                caluloVC();
                calculoPresoCivil();
                calculoMED();
                caluloQTVD();
                //CALCUAR AS MÉDIAS
                if (pQUANTIDADE_VISITA_FAMILIA_INT != 0 && pQUANTIDADE_DIAS_VISITADOS != 0) {
                    pMEDIA_VISITAS_POR_DIA = (pQUANTIDADE_VISITA_FAMILIA_INT / pQUANTIDADE_DIAS_VISITADOS);
                    jMediaVisitasDia.setText(String.valueOf(pMEDIA_VISITAS_POR_DIA));
                    calcularMediaVisitasInterno();
                } else if (pQUANTIDADE_VISITA_FAMILIA_INT == 0 || pQUANTIDADE_DIAS_VISITADOS == 0) {
                    jMediaVisitasDia.setText("0");
                }
                //ABA ASI
                calculoMED();
                calculoPSIQ();
                calculoENFER();
                calculoAgravosDIAG();
                calculoControleHipertensao();
                calculoControleDiabetes();
                calculoDOENCA_INFECTOCONTAGIOSAS();
                calculoControleVacinas();
                calculoPSI();
                calculoProcODON();
                calculoAtendODON();
                //ABA AEI
                calculoMatPED();
                calculoFreqPED();
                //AEI
                calculoProdutosKit();
                //ABA SEG
                calculoCelularSEG();
                calcularObjetos();
                calcularQtdRevistaCela();
                //ABA AJ
                calculoATENJURI();
                calculoSAIDA_ALVARA_LIVRAMENTO_PROGESSAO();
                calculoATEN_TO();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Dados incorreto, verifique se mês e o ano selecionado estão de acordo com a data inicial.");
            }
        } else if (jComboBoxMesReferencia.getSelectedItem().equals("Março")) {
            pMES_03 = "03";
            pDIA = pMES_REFERENCIA.substring(0, 1);
            pMES = pMES_REFERENCIA.substring(3, 5);
            pANO = pMES_REFERENCIA.substring(6, 10);
            pMES_REFERENCIA = pMES;
            if (pMES_REFERENCIA.equals(pMES_03) && jComboBoxAnoReferencia.getSelectedItem().equals(pANO)) {
                calculoMediaPopulacao();
                //ABA ASSI - SERVIÇO SOCIAL
                calculoSS();
                calculoSSF();
                calculoVI();
                caluloVC();
                calculoPresoCivil();
                calculoMED();
                caluloQTVD();
                //CALCUAR AS MÉDIAS
                if (pQUANTIDADE_VISITA_FAMILIA_INT != 0 && pQUANTIDADE_DIAS_VISITADOS != 0) {
                    pMEDIA_VISITAS_POR_DIA = (pQUANTIDADE_VISITA_FAMILIA_INT / pQUANTIDADE_DIAS_VISITADOS);
                    jMediaVisitasDia.setText(String.valueOf(pMEDIA_VISITAS_POR_DIA));
                    calcularMediaVisitasInterno();
                } else if (pQUANTIDADE_VISITA_FAMILIA_INT == 0 || pQUANTIDADE_DIAS_VISITADOS == 0) {
                    jMediaVisitasDia.setText("0");
                }
                //ABA ASI
                calculoMED();
                calculoPSIQ();
                calculoENFER();
                calculoAgravosDIAG();
                calculoControleHipertensao();
                calculoControleDiabetes();
                calculoDOENCA_INFECTOCONTAGIOSAS();
                calculoControleVacinas();
                calculoPSI();
                calculoProcODON();
                calculoAtendODON();
                //ABA AEI
                calculoMatPED();
                calculoFreqPED();
                //AEI
                calculoProdutosKit();
                //ABA SEG
                calculoCelularSEG();
                calcularObjetos();
                calcularQtdRevistaCela();
                //ABA AJ
                calculoATENJURI();
                calculoSAIDA_ALVARA_LIVRAMENTO_PROGESSAO();
                calculoATEN_TO();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Dados incorreto, verifique se mês e o ano selecionado estão de acordo com a data inicial.");
            }
        } else if (jComboBoxMesReferencia.getSelectedItem().equals("Abril")) {
            pMES_04 = "04";
            pDIA = pMES_REFERENCIA.substring(0, 1);
            pMES = pMES_REFERENCIA.substring(3, 5);
            pANO = pMES_REFERENCIA.substring(6, 10);
            pMES_REFERENCIA = pMES;
            if (pMES_REFERENCIA.equals(pMES_04) && jComboBoxAnoReferencia.getSelectedItem().equals(pANO)) {
                calculoMediaPopulacao();
                //ABA ASSI - SERVIÇO SOCIAL
                calculoSS();
                calculoSSF();
                calculoVI();
                caluloVC();
                calculoPresoCivil();
                calculoMED();
                caluloQTVD();
                //CALCUAR AS MÉDIAS
                if (pQUANTIDADE_VISITA_FAMILIA_INT != 0 && pQUANTIDADE_DIAS_VISITADOS != 0) {
                    pMEDIA_VISITAS_POR_DIA = (pQUANTIDADE_VISITA_FAMILIA_INT / pQUANTIDADE_DIAS_VISITADOS);
                    jMediaVisitasDia.setText(String.valueOf(pMEDIA_VISITAS_POR_DIA));
                    calcularMediaVisitasInterno();
                } else if (pQUANTIDADE_VISITA_FAMILIA_INT == 0 || pQUANTIDADE_DIAS_VISITADOS == 0) {
                    jMediaVisitasDia.setText("0");
                }
                calcularMediaVisitasInterno();
                //ABA ASI
                calculoMED();
                calculoPSIQ();
                calculoENFER();
                calculoAgravosDIAG();
                calculoControleHipertensao();
                calculoControleDiabetes();
                calculoDOENCA_INFECTOCONTAGIOSAS();
                calculoControleVacinas();
                calculoPSI();
                calculoProcODON();
                calculoAtendODON();
                //ABA AEI
                calculoMatPED();
                calculoFreqPED();
                //AEI
                calculoProdutosKit();
                //ABA SEG
                calculoCelularSEG();
                calcularObjetos();
                calcularQtdRevistaCela();
                //ABA AJ
                calculoATENJURI();
                calculoSAIDA_ALVARA_LIVRAMENTO_PROGESSAO();
                calculoATEN_TO();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Dados incorreto, verifique se mês e o ano selecionado estão de acordo com a data inicial.");
            }
        } else if (jComboBoxMesReferencia.getSelectedItem().equals("Maio")) {
            pMES_05 = "05";
            pDIA = pMES_REFERENCIA.substring(0, 1);
            pMES = pMES_REFERENCIA.substring(3, 5);
            pANO = pMES_REFERENCIA.substring(6, 10);
            pMES_REFERENCIA = pMES;
            if (pMES_REFERENCIA.equals(pMES_05) && jComboBoxAnoReferencia.getSelectedItem().equals(pANO)) {
                calculoMediaPopulacao();
                //ABA ASSI - SERVIÇO SOCIAL
                calculoSS();
                calculoSSF();
                calculoVI();
                caluloVC();
                calculoPresoCivil();
                calculoMED();
                caluloQTVD();
                //CALCUAR AS MÉDIAS
                if (pQUANTIDADE_VISITA_FAMILIA_INT != 0 && pQUANTIDADE_DIAS_VISITADOS != 0) {
                    pMEDIA_VISITAS_POR_DIA = (pQUANTIDADE_VISITA_FAMILIA_INT / pQUANTIDADE_DIAS_VISITADOS);
                    jMediaVisitasDia.setText(String.valueOf(pMEDIA_VISITAS_POR_DIA));
                    calcularMediaVisitasInterno();
                } else if (pQUANTIDADE_VISITA_FAMILIA_INT == 0 || pQUANTIDADE_DIAS_VISITADOS == 0) {
                    jMediaVisitasDia.setText("0");
                }
                //ABA ASI
                calculoMED();
                calculoPSIQ();
                calculoENFER();
                calculoAgravosDIAG();
                calculoControleHipertensao();
                calculoControleDiabetes();
                calculoDOENCA_INFECTOCONTAGIOSAS();
                calculoControleVacinas();
                calculoPSI();
                calculoProcODON();
                calculoAtendODON();
                //ABA AEI
                calculoMatPED();
                calculoFreqPED();
                //AEI
                calculoProdutosKit();
                //ABA SEG
                calculoCelularSEG();
                calcularObjetos();
                calcularQtdRevistaCela();
                //ABA AJ
                calculoATENJURI();
                calculoSAIDA_ALVARA_LIVRAMENTO_PROGESSAO();
                calculoATEN_TO();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Dados incorreto, verifique se mês e o ano selecionado estão de acordo com a data inicial.");
            }
        } else if (jComboBoxMesReferencia.getSelectedItem().equals("Junho")) {
            pMES_06 = "06";
            pDIA = pMES_REFERENCIA.substring(0, 1);
            pMES = pMES_REFERENCIA.substring(3, 5);
            pANO = pMES_REFERENCIA.substring(6, 10);
            pMES_REFERENCIA = pMES;
            if (pMES_REFERENCIA.equals(pMES_06) && jComboBoxAnoReferencia.getSelectedItem().equals(pANO)) {
                calculoMediaPopulacao();
                //ABA ASSI - SERVIÇO SOCIAL
                calculoSS();
                calculoSSF();
                calculoVI();
                caluloVC();
                calculoPresoCivil();
                calculoMED();
                caluloQTVD();
                //CALCUAR AS MÉDIAS
                if (pQUANTIDADE_VISITA_FAMILIA_INT != 0 && pQUANTIDADE_DIAS_VISITADOS != 0) {
                    pMEDIA_VISITAS_POR_DIA = (pQUANTIDADE_VISITA_FAMILIA_INT / pQUANTIDADE_DIAS_VISITADOS);
                    jMediaVisitasDia.setText(String.valueOf(pMEDIA_VISITAS_POR_DIA));
                    calcularMediaVisitasInterno();
                } else if (pQUANTIDADE_VISITA_FAMILIA_INT == 0 || pQUANTIDADE_DIAS_VISITADOS == 0) {
                    jMediaVisitasDia.setText("0");
                }
                //ABA ASI
                calculoMED();
                calculoPSIQ();
                calculoENFER();
                calculoAgravosDIAG();
                calculoControleHipertensao();
                calculoControleDiabetes();
                calculoDOENCA_INFECTOCONTAGIOSAS();
                calculoControleVacinas();
                calculoPSI();
                calculoProcODON();
                calculoAtendODON();
                //ABA AEI
                calculoMatPED();
                calculoFreqPED();
                //AEI
                calculoProdutosKit();
                //ABA SEG
                calculoCelularSEG();
                calcularObjetos();
                calcularQtdRevistaCela();
                //ABA AJ
                calculoATENJURI();
                calculoSAIDA_ALVARA_LIVRAMENTO_PROGESSAO();
                calculoATEN_TO();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Dados incorreto, verifique se mês e o ano selecionado estão de acordo com a data inicial.");
            }
        } else if (jComboBoxMesReferencia.getSelectedItem().equals("Julho")) {
            pMES_07 = "07";
            pDIA = pMES_REFERENCIA.substring(0, 1);
            pMES = pMES_REFERENCIA.substring(3, 5);
            pANO = pMES_REFERENCIA.substring(6, 10);
            pMES_REFERENCIA = pMES;
            if (pMES_REFERENCIA.equals(pMES_07) && jComboBoxAnoReferencia.getSelectedItem().equals(pANO)) {
                calculoMediaPopulacao();
                //ABA ASSI - SERVIÇO SOCIAL
                calculoSS();
                calculoSSF();
                calculoVI();
                caluloVC();
                calculoPresoCivil();
                calculoMED();
                caluloQTVD();
                //CALCUAR AS MÉDIAS
                if (pQUANTIDADE_VISITA_FAMILIA_INT != 0 && pQUANTIDADE_DIAS_VISITADOS != 0) {
                    pMEDIA_VISITAS_POR_DIA = (pQUANTIDADE_VISITA_FAMILIA_INT / pQUANTIDADE_DIAS_VISITADOS);
                    jMediaVisitasDia.setText(String.valueOf(pMEDIA_VISITAS_POR_DIA));
                    calcularMediaVisitasInterno();
                } else if (pQUANTIDADE_VISITA_FAMILIA_INT == 0 || pQUANTIDADE_DIAS_VISITADOS == 0) {
                    jMediaVisitasDia.setText("0");
                }
                //ABA ASI
                calculoMED();
                calculoPSIQ();
                calculoENFER();
                calculoAgravosDIAG();
                calculoControleHipertensao();
                calculoControleDiabetes();
                calculoDOENCA_INFECTOCONTAGIOSAS();
                calculoControleVacinas();
                calculoPSI();
                calculoProcODON();
                calculoAtendODON();
                //ABA AEI
                calculoMatPED();
                calculoFreqPED();
                //AEI
                calculoProdutosKit();
                //ABA SEG
                calculoCelularSEG();
                calcularObjetos();
                calcularQtdRevistaCela();
                //ABA AJ
                calculoATENJURI();
                calculoSAIDA_ALVARA_LIVRAMENTO_PROGESSAO();
                calculoATEN_TO();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Dados incorreto, verifique se mês e o ano selecionado estão de acordo com a data inicial.");
            }
        } else if (jComboBoxMesReferencia.getSelectedItem().equals("Agosto")) {
            pMES_08 = "08";
            pDIA = pMES_REFERENCIA.substring(0, 1);
            pMES = pMES_REFERENCIA.substring(3, 5);
            pANO = pMES_REFERENCIA.substring(6, 10);
            pMES_REFERENCIA = pMES;
            if (pMES_REFERENCIA.equals(pMES_08) && jComboBoxAnoReferencia.getSelectedItem().equals(pANO)) {
                calculoMediaPopulacao();
                //ABA ASSI - SERVIÇO SOCIAL
                calculoSS();
                calculoSSF();
                calculoVI();
                caluloVC();
                calculoPresoCivil();
                calculoMED();
                caluloQTVD();
                //CALCUAR AS MÉDIAS
                if (pQUANTIDADE_VISITA_FAMILIA_INT != 0 && pQUANTIDADE_DIAS_VISITADOS != 0) {
                    pMEDIA_VISITAS_POR_DIA = (pQUANTIDADE_VISITA_FAMILIA_INT / pQUANTIDADE_DIAS_VISITADOS);
                    jMediaVisitasDia.setText(String.valueOf(pMEDIA_VISITAS_POR_DIA));
                    calcularMediaVisitasInterno();
                } else if (pQUANTIDADE_VISITA_FAMILIA_INT == 0 || pQUANTIDADE_DIAS_VISITADOS == 0) {
                    jMediaVisitasDia.setText("0");
                }
                //ABA ASI
                calculoMED();
                calculoPSIQ();
                calculoENFER();
                calculoAgravosDIAG();
                calculoControleHipertensao();
                calculoControleDiabetes();
                calculoDOENCA_INFECTOCONTAGIOSAS();
                calculoControleVacinas();
                calculoPSI();
                calculoProcODON();
                calculoAtendODON();
                //ABA AEI
                calculoMatPED();
                calculoFreqPED();
                //AEI
                calculoProdutosKit();
                //ABA SEG
                calculoCelularSEG();
                calcularObjetos();
                calcularQtdRevistaCela();
                //ABA AJ
                calculoATENJURI();
                calculoSAIDA_ALVARA_LIVRAMENTO_PROGESSAO();
                calculoATEN_TO();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Dados incorreto, verifique se mês e o ano selecionado estão de acordo com a data inicial.");
            }
        } else if (jComboBoxMesReferencia.getSelectedItem().equals("Setembro")) {
            pMES_09 = "09";
            pDIA = pMES_REFERENCIA.substring(0, 1);
            pMES = pMES_REFERENCIA.substring(3, 5);
            pANO = pMES_REFERENCIA.substring(6, 10);
            pMES_REFERENCIA = pMES;
            if (pMES_REFERENCIA.equals(pMES_09) && jComboBoxAnoReferencia.getSelectedItem().equals(pANO)) {
                calculoMediaPopulacao();
                //ABA ASSI - SERVIÇO SOCIAL
                calculoSS();
                calculoSSF();
                calculoVI();
                caluloVC();
                calculoPresoCivil();
                calculoMED();
                caluloQTVD();
                //CALCUAR AS MÉDIAS
                if (pQUANTIDADE_VISITA_FAMILIA_INT != 0 && pQUANTIDADE_DIAS_VISITADOS != 0) {
                    pMEDIA_VISITAS_POR_DIA = (pQUANTIDADE_VISITA_FAMILIA_INT / pQUANTIDADE_DIAS_VISITADOS);
                    jMediaVisitasDia.setText(String.valueOf(pMEDIA_VISITAS_POR_DIA));
                    calcularMediaVisitasInterno();
                } else if (pQUANTIDADE_VISITA_FAMILIA_INT == 0 || pQUANTIDADE_DIAS_VISITADOS == 0) {
                    jMediaVisitasDia.setText("0");
                }
                //ABA ASI
                calculoMED();
                calculoPSIQ();
                calculoENFER();
                calculoAgravosDIAG();
                calculoControleHipertensao();
                calculoControleDiabetes();
                calculoDOENCA_INFECTOCONTAGIOSAS();
                calculoControleVacinas();
                calculoPSI();
                calculoProcODON();
                calculoAtendODON();
                //ABA AEI
                calculoMatPED();
                calculoFreqPED();
                //AEI
                calculoProdutosKit();
                //ABA SEG
                calculoCelularSEG();
                calcularObjetos();
                calcularQtdRevistaCela();
                //ABA AJ
                calculoATENJURI();
                calculoSAIDA_ALVARA_LIVRAMENTO_PROGESSAO();
                calculoATEN_TO();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Dados incorreto, verifique se mês e o ano selecionado estão de acordo com a data inicial.");
            }
        } else if (jComboBoxMesReferencia.getSelectedItem().equals("Outubro")) {
            pMES_10 = "10";
            pDIA = pMES_REFERENCIA.substring(0, 1);
            pMES = pMES_REFERENCIA.substring(3, 5);
            pANO = pMES_REFERENCIA.substring(6, 10);
            pMES_REFERENCIA = pMES;
            if (pMES_REFERENCIA.equals(pMES_10) && jComboBoxAnoReferencia.getSelectedItem().equals(pANO)) {
                calculoMediaPopulacao();
                //ABA ASSI - SERVIÇO SOCIAL
                calculoSS();
                calculoSSF();
                calculoVI();
                caluloVC();
                calculoPresoCivil();
                calculoMED();
                caluloQTVD();
                //CALCUAR AS MÉDIAS
                if (pQUANTIDADE_VISITA_FAMILIA_INT != 0 && pQUANTIDADE_DIAS_VISITADOS != 0) {
                    pMEDIA_VISITAS_POR_DIA = (pQUANTIDADE_VISITA_FAMILIA_INT / pQUANTIDADE_DIAS_VISITADOS);
                    jMediaVisitasDia.setText(String.valueOf(pMEDIA_VISITAS_POR_DIA));
                    calcularMediaVisitasInterno();
                } else if (pQUANTIDADE_VISITA_FAMILIA_INT == 0 || pQUANTIDADE_DIAS_VISITADOS == 0) {
                    jMediaVisitasDia.setText("0");
                }
                //ABA ASI
                calculoMED();
                calculoPSIQ();
                calculoENFER();
                calculoAgravosDIAG();
                calculoControleHipertensao();
                calculoControleDiabetes();
                calculoDOENCA_INFECTOCONTAGIOSAS();
                calculoControleVacinas();
                calculoPSI();
                calculoProcODON();
                calculoAtendODON();
                //ABA AEI
                calculoMatPED();
                calculoFreqPED();
                //AEI
                calculoProdutosKit();
                //ABA SEG
                calculoCelularSEG();
                calcularObjetos();
                calcularQtdRevistaCela();
                //ABA AJ
                calculoATENJURI();
                calculoSAIDA_ALVARA_LIVRAMENTO_PROGESSAO();
                calculoATEN_TO();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Dados incorreto, verifique se mês e o ano selecionado estão de acordo com a data inicial.");
            }
        } else if (jComboBoxMesReferencia.getSelectedItem().equals("Novembro")) {
            pMES_11 = "11";
            pDIA = pMES_REFERENCIA.substring(0, 1);
            pMES = pMES_REFERENCIA.substring(3, 5);
            pANO = pMES_REFERENCIA.substring(6, 10);
            pMES_REFERENCIA = pMES;
            if (pMES_REFERENCIA.equals(pMES_11) && jComboBoxAnoReferencia.getSelectedItem().equals(pANO)) {
                calculoMediaPopulacao();
                //ABA ASSI - SERVIÇO SOCIAL
                calculoSS();
                calculoSSF();
                calculoVI();
                caluloVC();
                calculoPresoCivil();
                calculoMED();
                caluloQTVD();
                //CALCUAR AS MÉDIAS
                if (pQUANTIDADE_VISITA_FAMILIA_INT != 0 && pQUANTIDADE_DIAS_VISITADOS != 0) {
                    pMEDIA_VISITAS_POR_DIA = (pQUANTIDADE_VISITA_FAMILIA_INT / pQUANTIDADE_DIAS_VISITADOS);
                    jMediaVisitasDia.setText(String.valueOf(pMEDIA_VISITAS_POR_DIA));
                    calcularMediaVisitasInterno();
                } else if (pQUANTIDADE_VISITA_FAMILIA_INT == 0 || pQUANTIDADE_DIAS_VISITADOS == 0) {
                    jMediaVisitasDia.setText("0");
                }
                //ABA ASI
                calculoMED();
                calculoPSIQ();
                calculoENFER();
                calculoAgravosDIAG();
                calculoControleHipertensao();
                calculoControleDiabetes();
                calculoDOENCA_INFECTOCONTAGIOSAS();
                calculoControleVacinas();
                calculoPSI();
                calculoProcODON();
                calculoAtendODON();
                //ABA AEI
                calculoMatPED();
                calculoFreqPED();
                //AEI
                calculoProdutosKit();
                //ABA SEG
                calculoCelularSEG();
                calcularObjetos();
                calcularQtdRevistaCela();
                //ABA AJ
                calculoATENJURI();
                calculoSAIDA_ALVARA_LIVRAMENTO_PROGESSAO();
                calculoATEN_TO();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Dados incorreto, verifique se mês e o ano selecionado estão de acordo com a data inicial.");
            }
        } else if (jComboBoxMesReferencia.getSelectedItem().equals("Dezembro")) {
            pMES_12 = "12";
            pDIA = pMES_REFERENCIA.substring(0, 1);
            pMES = pMES_REFERENCIA.substring(3, 5);
            pANO = pMES_REFERENCIA.substring(6, 10);
            pMES_REFERENCIA = pMES;
            if (pMES_REFERENCIA.equals(pMES_12) && jComboBoxAnoReferencia.getSelectedItem().equals(pANO)) {
                calculoMediaPopulacao();
                //ABA ASSI - SERVIÇO SOCIAL
                calculoSS();
                calculoSSF();
                calculoVI();
                caluloVC();
                calculoPresoCivil();
                calculoMED();
                caluloQTVD();
                //CALCUAR AS MÉDIAS
                if (pQUANTIDADE_VISITA_FAMILIA_INT != 0 && pQUANTIDADE_DIAS_VISITADOS != 0) {
                    pMEDIA_VISITAS_POR_DIA = (pQUANTIDADE_VISITA_FAMILIA_INT / pQUANTIDADE_DIAS_VISITADOS);
                    jMediaVisitasDia.setText(String.valueOf(pMEDIA_VISITAS_POR_DIA));
                    calcularMediaVisitasInterno();
                } else if (pQUANTIDADE_VISITA_FAMILIA_INT == 0 || pQUANTIDADE_DIAS_VISITADOS == 0) {
                    jMediaVisitasDia.setText("0");
                }
                //ABA ASI
                calculoMED();
                calculoPSIQ();
                calculoENFER();
                calculoAgravosDIAG();
                calculoControleHipertensao();
                calculoControleDiabetes();
                calculoDOENCA_INFECTOCONTAGIOSAS();
                calculoControleVacinas();
                calculoPSI();
                calculoProcODON();
                calculoAtendODON();
                //ABA AEI
                calculoMatPED();
                calculoFreqPED();
                //AEI
                calculoProdutosKit();
                //ABA SEG
                calculoCelularSEG();
                calcularObjetos();
                calcularQtdRevistaCela();
                //ABA AJ
                calculoATENJURI();
                calculoSAIDA_ALVARA_LIVRAMENTO_PROGESSAO();
                calculoATEN_TO();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Dados incorreto, verifique se mês e o ano selecionado estão de acordo com a data inicial.");
            }
        }
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
