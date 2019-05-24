/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleIndicadoresAcompanhaPedagogia;
import gestor.Controle.ControleIndicadoresAcompanhaEnfermaria;
import gestor.Controle.ControleIndicadoresAcompanhaJuridicoCrc;
import gestor.Controle.ControleIndicadoresAcompanhamento;
import gestor.Controle.ControleLogSistema;
import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.ModeloTabela;
import gestor.Modelo.IndicadoresAcompanhamento;
import gestor.Modelo.LogSistema;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloEnfermaria.codAbrirENF;
import static gestor.Visao.TelaModuloEnfermaria.codAlterarENF;
import static gestor.Visao.TelaModuloEnfermaria.codConsultarENF;
import static gestor.Visao.TelaModuloEnfermaria.codExcluirENF;
import static gestor.Visao.TelaModuloEnfermaria.codGravarENF;
import static gestor.Visao.TelaModuloEnfermaria.codIncluirENF;
import static gestor.Visao.TelaModuloEnfermaria.codUserAcessoENF;
import static gestor.Visao.TelaModuloEnfermaria.codigoGrupoENF;
import static gestor.Visao.TelaModuloEnfermaria.codigoUserENF;
import static gestor.Visao.TelaModuloEnfermaria.codigoUserGroupENF;
import static gestor.Visao.TelaModuloEnfermaria.nomeGrupoENF;
import static gestor.Visao.TelaModuloEnfermaria.nomeTelaENF;
import static gestor.Visao.TelaModuloEnfermaria.telaIndAcompanhaAbaC;
import static gestor.Visao.TelaModuloEnfermaria.telaIndAcompanhaAbaE;
import static gestor.Visao.TelaModuloEnfermaria.telaIndAcompanhaAbaP;
import static gestor.Visao.TelaModuloEnfermaria.telaIndAcompanhaManu;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import java.awt.Color;
import java.awt.Image;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Socializa TI 02
 */
public class TelaIndicadoresAcompanhamento extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    IndicadoresAcompanhamento objPerfilInter = new IndicadoresAcompanhamento();
    ControleIndicadoresAcompanhamento control = new ControleIndicadoresAcompanhamento();
    ControleIndicadoresAcompanhaEnfermaria controle = new ControleIndicadoresAcompanhaEnfermaria();
    ControleIndicadoresAcompanhaPedagogia controlPeda = new ControleIndicadoresAcompanhaPedagogia();
    ControleIndicadoresAcompanhaJuridicoCrc controlCrc = new ControleIndicadoresAcompanhaJuridicoCrc();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela = "Indicadores de Acompanhamento:Manutenção";
    String nomeModuloTela1 = "Indicadores de Acompanhamento:Enfermaria";
    String nomeModuloTela2 = "Indicadores de Acompanhamento:Pedagogia";
    String nomeModuloTela3 = "Indicadores de Acompanhamento:Juridico/Crc";
    String nomeModuloTela4 = "Indicadores de Acompanhamento:";
    String nomeModuloTela5 = "Indicadores de Acompanhamento:";
    String nomeModuloTela6 = "Indicadores de Acompanhamento:";
    //
    String statusMov;
    String horaMov;
    String dataModFinal;
    //
    int acao;
    int flag;
    int count = 0;
    String dataInicial;
    String dataFinal, dataPAI, dataPAI1, dataPAI2, dataPAI3;
    String caminho;
    String codInterno;
    // PERFIL CARCERÁRIO
    public static int codigoPerfilCarcerario;
    String codigoPerfil;
    String codigoInternoPerfil;
    int anoReferencia;
    //ENFERMARIA
    int qtdDiabetes = 0;
    int qtdHipertensao = 0;
    int qtdEscabiose = 0;
    int qtdHanseniase = 0;
    int qtdSifilis = 0;
    int qtdTuberculose = 0;
    int qtdHib = 0;
    int qtdHepatiteB = 0;
    int qtdHepatiteC = 0;
    int qtdDst = 0;
    int qtdVdlr = 0;
    int qtdVacina = 0;
    //
    int codigoEnf = 0;
    int codigoPeda = 0;
    int codigoCrc = 0;
    //PEDAGOGIA
    int qICAA = 0;
    int qIC1 = 0;
    int qIC2P = 0;
    int qIAAU = 0;
    int qIC3 = 0;
    int qIREL = 0;
    int qIAC = 0;
    int qICU1 = 0;
    int qIC2 = 0;
    int qICA = 0;
    //JURIDICO/CRC
    int qtdProcessos = 0;
    int qtdDocumentacao = 0;
    int qtdProggressao = 0;
    int qtdLivramento = 0;

    /**
     * Creates new form TelaIndicadoresAcompanhamento
     */
    public TelaIndicadoresAcompanhamento() {
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
        jTabelaPerfilCarcerario = new javax.swing.JTable();
        jPanel32 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jIdPerfil = new javax.swing.JTextField();
        jStatusPerfil = new javax.swing.JTextField();
        jDataPerfil = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jIdInternoPerfil = new javax.swing.JTextField();
        jNomeInternoPerfil = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jEtiniaInternoPerfil = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPavilhaoInternoPerfil = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jCelaInternoPerfil = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jCidadeInternoPerfil = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jBairroInternoPerfil = new javax.swing.JTextField();
        jBtPesquisaInternoPerfil = new javax.swing.JButton();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jSexo = new javax.swing.JTextField();
        jOpcaoSexual = new javax.swing.JTextField();
        jAnoNascimento = new com.toedter.calendar.JYearChooser();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jObservacaoInternoPerfil = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        jBtNovo = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jBtAuditoria = new javax.swing.JButton();
        jBtFinalizar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jAnoReferencia = new com.toedter.calendar.JYearChooser();
        jLabel12 = new javax.swing.JLabel();
        jMesReferencia = new com.toedter.calendar.JMonthChooser();
        jPanel7 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jComboBoxHIV = new javax.swing.JComboBox();
        jComboBoxHanseniaseCont = new javax.swing.JComboBox();
        jComboBoxSifilisCont = new javax.swing.JComboBox();
        jLabel30 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jComboBoxHipertensao = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jComboBoxEscabioseCont = new javax.swing.JComboBox();
        jLabel40 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jComboBoxEscabiose = new javax.swing.JComboBox();
        jComboBoxHepatiteB = new javax.swing.JComboBox();
        jComboBoxTuberculose = new javax.swing.JComboBox();
        jLabel32 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jComboBoxHipertensaoCont = new javax.swing.JComboBox();
        jComboBoxDiabetesCont = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jComboBoxDiabetes = new javax.swing.JComboBox();
        jLabel31 = new javax.swing.JLabel();
        jComboBoxSifilis = new javax.swing.JComboBox();
        jLabel33 = new javax.swing.JLabel();
        jComboBoxHanseniase = new javax.swing.JComboBox();
        jLabel36 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jComboBoxHepatiteC = new javax.swing.JComboBox();
        jLabel21 = new javax.swing.JLabel();
        jComboBoxTuberculoseCont = new javax.swing.JComboBox();
        jLabel104 = new javax.swing.JLabel();
        jComboBoxVacina = new javax.swing.JComboBox();
        jLabel106 = new javax.swing.JLabel();
        jComboBoxhepatiteBContro = new javax.swing.JComboBox();
        jLabel107 = new javax.swing.JLabel();
        jComboBoxHepatiteCcurada = new javax.swing.JComboBox();
        jLabel105 = new javax.swing.JLabel();
        jComboBoxVDRL = new javax.swing.JComboBox();
        jLabel108 = new javax.swing.JLabel();
        jComboBoxDST = new javax.swing.JComboBox();
        jDataRegEnfermaria = new com.toedter.calendar.JDateChooser();
        jLabel97 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jComboBoxHIVCont = new javax.swing.JComboBox();
        jPanel16 = new javax.swing.JPanel();
        jBtNovoEnfermaria = new javax.swing.JButton();
        jBtAlterarEnfermaria = new javax.swing.JButton();
        jBtExcluirEnfermaria = new javax.swing.JButton();
        jBtSalvarEnfermaria = new javax.swing.JButton();
        jBtCancelarEnfermaria = new javax.swing.JButton();
        jBtSairEnfermaria = new javax.swing.JButton();
        jBtAuditoriaEnfermaria = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTabelaEnfermaria = new javax.swing.JTable();
        jPanel17 = new javax.swing.JPanel();
        jObservacaoEnfermaria = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jBtNovoPeda = new javax.swing.JButton();
        jBtAlterarPeda = new javax.swing.JButton();
        jBtExcluirPeda = new javax.swing.JButton();
        jBtSalvarPeda = new javax.swing.JButton();
        jBtCancelarPeda = new javax.swing.JButton();
        jBtSairPeda = new javax.swing.JButton();
        jBtAuditoriaPeda = new javax.swing.JButton();
        jPanel20 = new javax.swing.JPanel();
        jComboBoxICAA = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jComboBoxIC1 = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jComboBoxIC2P = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        jComboBoxIAAU = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        jComboBoxIREL = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        jComboBoxIC3 = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        jComboBoxIAC = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        jComboBoxICU1 = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        jComboBoxIC2 = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        jComboBoxICA = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jDataPeda = new com.toedter.calendar.JDateChooser();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTabelaPedagogia = new javax.swing.JTable();
        jLabel100 = new javax.swing.JLabel();
        jObservacaoPeda = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jComboBoxProcessoAcomp = new javax.swing.JComboBox<>();
        jComboBoxProgressaoRegime = new javax.swing.JComboBox<>();
        jComboBoxDocumentacao = new javax.swing.JComboBox<>();
        jComboBoxLivramentoCond = new javax.swing.JComboBox<>();
        jLabel99 = new javax.swing.JLabel();
        jDataCrc = new com.toedter.calendar.JDateChooser();
        jPanel25 = new javax.swing.JPanel();
        jBtNovoCrc = new javax.swing.JButton();
        jBtAlterarCrc = new javax.swing.JButton();
        jBtExcluirCrc = new javax.swing.JButton();
        jBtSalvarCrc = new javax.swing.JButton();
        jBtCancelarCrc = new javax.swing.JButton();
        jBtSairCrc = new javax.swing.JButton();
        jBtAuditoriaCrc = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTabelaCrcJuridico = new javax.swing.JTable();
        jPanel19 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jObservacaoCrc = new javax.swing.JTextArea();
        jPanel12 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jComboBoxConcluiuFP = new javax.swing.JComboBox<>();
        jComboBoxPassouCurso = new javax.swing.JComboBox<>();
        jComboBoxPrograma = new javax.swing.JComboBox<>();
        jLabel101 = new javax.swing.JLabel();
        jDataTO = new com.toedter.calendar.JDateChooser();
        jPanel33 = new javax.swing.JPanel();
        jBtNovoTO = new javax.swing.JButton();
        jBtAlterarTO = new javax.swing.JButton();
        jBtExcluirTO = new javax.swing.JButton();
        jBtSalvarTO = new javax.swing.JButton();
        jBtCancelarTO = new javax.swing.JButton();
        jBtSairTO = new javax.swing.JButton();
        jBtAuditoriaTO = new javax.swing.JButton();
        jPanel26 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jObservacaoTO = new javax.swing.JTextArea();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTabelaTO = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jComboBoxTratamentoPSI = new javax.swing.JComboBox<>();
        jComboBoxAcompanhamentoPSI = new javax.swing.JComboBox<>();
        jComboBoxRecuparacaoPSI = new javax.swing.JComboBox<>();
        jLabel102 = new javax.swing.JLabel();
        jDataPSI = new com.toedter.calendar.JDateChooser();
        jPanel38 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jObservacaoPSI = new javax.swing.JTextArea();
        jPanel39 = new javax.swing.JPanel();
        jBtNovoPSI = new javax.swing.JButton();
        jBtAlterarPSI = new javax.swing.JButton();
        jBtExcluirPSI = new javax.swing.JButton();
        jBtSalvarPSI = new javax.swing.JButton();
        jBtCancelarPSI = new javax.swing.JButton();
        jBtSairPSI = new javax.swing.JButton();
        jBtAuditoriaPSI = new javax.swing.JButton();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTabelaPSI = new javax.swing.JTable();
        jPanel28 = new javax.swing.JPanel();
        jPanel41 = new javax.swing.JPanel();
        jLabel96 = new javax.swing.JLabel();
        jComboBoxAcompanhaSS = new javax.swing.JComboBox<>();
        jPanel42 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jObservaacaoSS = new javax.swing.JTextArea();
        jPanel43 = new javax.swing.JPanel();
        jBtNovoSS = new javax.swing.JButton();
        jBtAlterarSS = new javax.swing.JButton();
        jBtExcluirSS = new javax.swing.JButton();
        jBtSalvarSS = new javax.swing.JButton();
        jBtCancelarSS = new javax.swing.JButton();
        jBtSairSS = new javax.swing.JButton();
        jBtAuditoriaSS = new javax.swing.JButton();
        jPanel40 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jLabel103 = new javax.swing.JLabel();
        jTextField40 = new javax.swing.JTextField();
        jPanel24 = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jTextField29 = new javax.swing.JTextField();
        jTextField30 = new javax.swing.JTextField();
        jTextField31 = new javax.swing.JTextField();
        jTextField32 = new javax.swing.JTextField();
        jPanel35 = new javax.swing.JPanel();
        jLabel95 = new javax.swing.JLabel();
        jTextField39 = new javax.swing.JTextField();
        jPanel36 = new javax.swing.JPanel();
        jLabel92 = new javax.swing.JLabel();
        jTextField36 = new javax.swing.JTextField();
        jTextField37 = new javax.swing.JTextField();
        jTextField38 = new javax.swing.JTextField();
        jLabel94 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jTextField33 = new javax.swing.JTextField();
        jTextField34 = new javax.swing.JTextField();
        jTextField35 = new javax.swing.JTextField();
        jPanel22 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        jTextField21 = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        jTextField22 = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        jTextField23 = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        jTextField24 = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        jTextField25 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jTextField26 = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jTextField27 = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jTextField28 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jFotoInternoPerfil = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Programa Indicadores de Acompanhamento :::...");

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaPerfilCarcerario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaPerfilCarcerario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data", "Status", "Nome do Interno"
            }
        ));
        jTabelaPerfilCarcerario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaPerfilCarcerarioMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTabelaPerfilCarcerario);
        if (jTabelaPerfilCarcerario.getColumnModel().getColumnCount() > 0) {
            jTabelaPerfilCarcerario.getColumnModel().getColumn(0).setMinWidth(60);
            jTabelaPerfilCarcerario.getColumnModel().getColumn(0).setMaxWidth(60);
            jTabelaPerfilCarcerario.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaPerfilCarcerario.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaPerfilCarcerario.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaPerfilCarcerario.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaPerfilCarcerario.getColumnModel().getColumn(3).setMinWidth(330);
            jTabelaPerfilCarcerario.getColumnModel().getColumn(3).setMaxWidth(330);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("Listagem", jPanel1);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Status");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Data");

        jIdPerfil.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdPerfil.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdPerfil.setEnabled(false);

        jStatusPerfil.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jStatusPerfil.setForeground(new java.awt.Color(255, 0, 0));
        jStatusPerfil.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jStatusPerfil.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        jStatusPerfil.setEnabled(false);

        jDataPerfil.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataPerfil.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Código");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Nome do Interno");

        jIdInternoPerfil.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdInternoPerfil.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdInternoPerfil.setEnabled(false);

        jNomeInternoPerfil.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoPerfil.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Cor/Etinia");

        jEtiniaInternoPerfil.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jEtiniaInternoPerfil.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Pavilhão");

        jPavilhaoInternoPerfil.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPavilhaoInternoPerfil.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Cela");

        jCelaInternoPerfil.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCelaInternoPerfil.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Cidade");

        jCidadeInternoPerfil.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCidadeInternoPerfil.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Bairro");

        jBairroInternoPerfil.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jBairroInternoPerfil.setEnabled(false);

        jBtPesquisaInternoPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesquisaInternoPerfil.setToolTipText("Pesquisar Interno");
        jBtPesquisaInternoPerfil.setContentAreaFilled(false);
        jBtPesquisaInternoPerfil.setEnabled(false);
        jBtPesquisaInternoPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisaInternoPerfilActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel41.setText("Ano Nasc.");

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel42.setText("Sexo");

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel43.setText("Opção Sexual");

        jSexo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jSexo.setEnabled(false);

        jOpcaoSexual.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jOpcaoSexual.setEnabled(false);

        jAnoNascimento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAnoNascimento.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCidadeInternoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jBairroInternoPerfil))
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(191, 191, 191))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jPavilhaoInternoPerfil)
                                .addGap(6, 6, 6)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCelaInternoPerfil)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jIdPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jStatusPerfil))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDataPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jIdInternoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jNomeInternoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesquisaInternoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jEtiniaInternoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel42)
                                    .addComponent(jSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jOpcaoSexual)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel43)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jAnoNascimento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel41, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIdPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jStatusPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jNomeInternoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesquisaInternoPerfil)
                    .addComponent(jIdInternoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel41)
                    .addComponent(jLabel42)
                    .addComponent(jLabel43))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jEtiniaInternoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jOpcaoSexual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jAnoNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPavilhaoInternoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCelaInternoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCidadeInternoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBairroInternoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Observação");

        jObservacaoInternoPerfil.setColumns(20);
        jObservacaoInternoPerfil.setRows(5);
        jObservacaoInternoPerfil.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jObservacaoInternoPerfil.setEnabled(false);
        jScrollPane1.setViewportView(jObservacaoInternoPerfil);

        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

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

        jBtAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/refresh-reload-icone-6258-16.png"))); // NOI18N
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

        jBtAuditoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoria.setToolTipText("Auditoria");
        jBtAuditoria.setContentAreaFilled(false);
        jBtAuditoria.setEnabled(false);
        jBtAuditoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaActionPerformed(evt);
            }
        });

        jBtFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/low-security-breach-icone-4155-16.png"))); // NOI18N
        jBtFinalizar.setToolTipText("Finalizar Perfil");
        jBtFinalizar.setContentAreaFilled(false);
        jBtFinalizar.setEnabled(false);
        jBtFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFinalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jBtNovo)
                .addGap(2, 2, 2)
                .addComponent(jBtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jBtExcluir)
                .addGap(2, 2, 2)
                .addComponent(jBtSalvar)
                .addGap(2, 2, 2)
                .addComponent(jBtCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSair)
                .addGap(26, 26, 26)
                .addComponent(jBtFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jBtAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(jBtNovo)
                .addComponent(jBtAlterar)
                .addComponent(jBtExcluir)
                .addComponent(jBtSalvar)
                .addComponent(jBtCancelar)
                .addComponent(jBtSair)
                .addComponent(jBtFinalizar)
                .addComponent(jBtAuditoria))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(204, 0, 0));
        jLabel44.setText("Ano Referência:");

        jAnoReferencia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAnoReferencia.setEnabled(false);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 0, 0));
        jLabel12.setText("Mês Referência:");

        jMesReferencia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMesReferencia.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jMesReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel44)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jAnoReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jMesReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel44)
                    .addComponent(jAnoReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manutenção", jPanel2);

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jComboBoxHIV.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxHIV.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não Reagente", "Reagente" }));
        jComboBoxHIV.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxHIV.setEnabled(false);
        jComboBoxHIV.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxHIVItemStateChanged(evt);
            }
        });

        jComboBoxHanseniaseCont.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxHanseniaseCont.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxHanseniaseCont.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxHanseniaseCont.setEnabled(false);

        jComboBoxSifilisCont.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxSifilisCont.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxSifilisCont.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxSifilisCont.setEnabled(false);

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel30.setText("Hipertensão?");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Curada?");

        jComboBoxHipertensao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxHipertensao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxHipertensao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxHipertensao.setEnabled(false);
        jComboBoxHipertensao.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxHipertensaoItemStateChanged(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Curada?");

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel35.setText("Hepatite B?");

        jComboBoxEscabioseCont.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxEscabioseCont.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxEscabioseCont.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxEscabioseCont.setEnabled(false);

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel40.setText("Escabiose?");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Curada?");

        jComboBoxEscabiose.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxEscabiose.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxEscabiose.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxEscabiose.setEnabled(false);

        jComboBoxHepatiteB.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxHepatiteB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não Reagente", "Reagente" }));
        jComboBoxHepatiteB.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxHepatiteB.setEnabled(false);
        jComboBoxHepatiteB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxHepatiteBItemStateChanged(evt);
            }
        });

        jComboBoxTuberculose.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTuberculose.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não Reagente", "Reagente" }));
        jComboBoxTuberculose.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTuberculose.setEnabled(false);

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel32.setText("Tuberculose?");

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel34.setText("HIV?");

        jComboBoxHipertensaoCont.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxHipertensaoCont.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxHipertensaoCont.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxHipertensaoCont.setEnabled(false);
        jComboBoxHipertensaoCont.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxHipertensaoContItemStateChanged(evt);
            }
        });

        jComboBoxDiabetesCont.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDiabetesCont.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxDiabetesCont.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDiabetesCont.setEnabled(false);
        jComboBoxDiabetesCont.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxDiabetesContItemStateChanged(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Controlada?");

        jComboBoxDiabetes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDiabetes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxDiabetes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDiabetes.setEnabled(false);
        jComboBoxDiabetes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxDiabetesItemStateChanged(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel31.setText("Diabetes?");

        jComboBoxSifilis.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxSifilis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não Reagente", "Reagente" }));
        jComboBoxSifilis.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxSifilis.setEnabled(false);

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel33.setText("Sifilis:");

        jComboBoxHanseniase.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxHanseniase.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxHanseniase.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxHanseniase.setEnabled(false);

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel36.setText("Hanseniase?");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Controlada?");

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel37.setText("Hepatite C?");

        jComboBoxHepatiteC.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxHepatiteC.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não Reagente", "Reagente" }));
        jComboBoxHepatiteC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxHepatiteC.setEnabled(false);
        jComboBoxHepatiteC.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxHepatiteCItemStateChanged(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Curada?");

        jComboBoxTuberculoseCont.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTuberculoseCont.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxTuberculoseCont.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTuberculoseCont.setEnabled(false);

        jLabel104.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel104.setText("T. DST?");

        jComboBoxVacina.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxVacina.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxVacina.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxVacina.setEnabled(false);

        jLabel106.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel106.setText("Controlada?");

        jComboBoxhepatiteBContro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxhepatiteBContro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxhepatiteBContro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxhepatiteBContro.setEnabled(false);
        jComboBoxhepatiteBContro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxhepatiteBControItemStateChanged(evt);
            }
        });

        jLabel107.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel107.setText("Controlada?");

        jComboBoxHepatiteCcurada.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxHepatiteCcurada.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxHepatiteCcurada.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxHepatiteCcurada.setEnabled(false);
        jComboBoxHepatiteCcurada.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxHepatiteCcuradaItemStateChanged(evt);
            }
        });

        jLabel105.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel105.setText("VDLR:");

        jComboBoxVDRL.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxVDRL.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não Reagente", "Reagente", "Não Realizado" }));
        jComboBoxVDRL.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxVDRL.setEnabled(false);

        jLabel108.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel108.setText("Vacina:");

        jComboBoxDST.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDST.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxDST.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDST.setEnabled(false);
        jComboBoxDST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDSTActionPerformed(evt);
            }
        });

        jDataRegEnfermaria.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataRegEnfermaria.setEnabled(false);

        jLabel97.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel97.setText("Data Registro");

        jLabel109.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel109.setText("Controlada?");

        jComboBoxHIVCont.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxHIVCont.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxHIVCont.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxHIVCont.setEnabled(false);
        jComboBoxHIVCont.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxHIVContItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel40, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jComboBoxHepatiteC, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBoxHepatiteB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxHIV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jComboBoxHipertensao, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBoxDiabetes, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBoxHanseniase, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBoxEscabiose, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jComboBoxSifilis, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBoxTuberculose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(1, 1, 1)))
                .addGap(42, 42, 42)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel106, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel107, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxHipertensaoCont, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxDiabetesCont, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxHanseniaseCont, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxSifilisCont, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxTuberculoseCont, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxhepatiteBContro, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxEscabioseCont, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxHepatiteCcurada, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel105, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel108, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel109)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxHIVCont, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel104)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxVDRL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxVacina, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataRegEnfermaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel97))
                    .addComponent(jComboBoxDST, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel13Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jComboBoxHIV, jComboBoxHepatiteB, jComboBoxHepatiteC, jComboBoxSifilis, jComboBoxTuberculose});

        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel31)
                            .addComponent(jComboBoxDiabetes, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel30)
                            .addComponent(jComboBoxHipertensao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel40)
                            .addComponent(jComboBoxEscabiose, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jComboBoxHanseniase, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36)))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBoxDiabetesCont, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBoxHipertensaoCont, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14)))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel97)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDataRegEnfermaria, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxEscabioseCont, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxHanseniaseCont, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel33)
                    .addComponent(jComboBoxSifilis, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(jComboBoxSifilisCont, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel32)
                    .addComponent(jLabel21)
                    .addComponent(jComboBoxTuberculose, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTuberculoseCont, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel34)
                    .addComponent(jComboBoxHIV, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel104)
                    .addComponent(jComboBoxDST, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxHIVCont, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel109)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxhepatiteBContro, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35)
                    .addComponent(jComboBoxHepatiteB, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel106)
                    .addComponent(jLabel108)
                    .addComponent(jComboBoxVacina, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel37)
                    .addComponent(jComboBoxHepatiteC, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel107)
                    .addComponent(jComboBoxHepatiteCcurada, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel105)
                        .addComponent(jComboBoxVDRL, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel16.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jBtNovoEnfermaria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoEnfermaria.setText("Novo");
        jBtNovoEnfermaria.setContentAreaFilled(false);
        jBtNovoEnfermaria.setEnabled(false);
        jBtNovoEnfermaria.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovoEnfermaria.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovoEnfermaria.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovoEnfermaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoEnfermariaActionPerformed(evt);
            }
        });

        jBtAlterarEnfermaria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/refresh-reload-icone-6258-16.png"))); // NOI18N
        jBtAlterarEnfermaria.setText("Alterar");
        jBtAlterarEnfermaria.setContentAreaFilled(false);
        jBtAlterarEnfermaria.setEnabled(false);
        jBtAlterarEnfermaria.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterarEnfermaria.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarEnfermaria.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarEnfermaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarEnfermariaActionPerformed(evt);
            }
        });

        jBtExcluirEnfermaria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirEnfermaria.setText("Excluir");
        jBtExcluirEnfermaria.setContentAreaFilled(false);
        jBtExcluirEnfermaria.setEnabled(false);
        jBtExcluirEnfermaria.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluirEnfermaria.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirEnfermaria.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirEnfermaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirEnfermariaActionPerformed(evt);
            }
        });

        jBtSalvarEnfermaria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarEnfermaria.setText("Gravar");
        jBtSalvarEnfermaria.setContentAreaFilled(false);
        jBtSalvarEnfermaria.setEnabled(false);
        jBtSalvarEnfermaria.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvarEnfermaria.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarEnfermaria.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarEnfermaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarEnfermariaActionPerformed(evt);
            }
        });

        jBtCancelarEnfermaria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarEnfermaria.setText("Cancelar");
        jBtCancelarEnfermaria.setContentAreaFilled(false);
        jBtCancelarEnfermaria.setEnabled(false);
        jBtCancelarEnfermaria.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelarEnfermaria.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarEnfermaria.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarEnfermaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarEnfermariaActionPerformed(evt);
            }
        });

        jBtSairEnfermaria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSairEnfermaria.setText("Sair");
        jBtSairEnfermaria.setContentAreaFilled(false);
        jBtSairEnfermaria.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSairEnfermaria.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSairEnfermaria.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSairEnfermaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairEnfermariaActionPerformed(evt);
            }
        });

        jBtAuditoriaEnfermaria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaEnfermaria.setToolTipText("Auditoria");
        jBtAuditoriaEnfermaria.setContentAreaFilled(false);
        jBtAuditoriaEnfermaria.setEnabled(false);
        jBtAuditoriaEnfermaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaEnfermariaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(jBtNovoEnfermaria)
                .addGap(2, 2, 2)
                .addComponent(jBtAlterarEnfermaria, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jBtExcluirEnfermaria)
                .addGap(2, 2, 2)
                .addComponent(jBtSalvarEnfermaria)
                .addGap(2, 2, 2)
                .addComponent(jBtCancelarEnfermaria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSairEnfermaria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaEnfermaria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(jBtAlterarEnfermaria)
                .addComponent(jBtExcluirEnfermaria)
                .addComponent(jBtNovoEnfermaria)
                .addComponent(jBtSalvarEnfermaria)
                .addComponent(jBtCancelarEnfermaria)
                .addComponent(jBtSairEnfermaria)
                .addComponent(jBtAuditoriaEnfermaria))
        );

        jTabelaEnfermaria.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaEnfermaria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Data", "Diabetes", "Controlada", "Hipertensão", "Controlada", "Escabiose", "Curada", "Hanseniase", "Curada", "Sifilis", "Curada", "Tuberculose", "Curada", "HIV", "Controlada", "Hepatite B", "Controlada", "Hepatite C", "Controlada"
            }
        ));
        jTabelaEnfermaria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaEnfermariaMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(jTabelaEnfermaria);
        if (jTabelaEnfermaria.getColumnModel().getColumnCount() > 0) {
            jTabelaEnfermaria.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaEnfermaria.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaEnfermaria.getColumnModel().getColumn(1).setMinWidth(60);
            jTabelaEnfermaria.getColumnModel().getColumn(1).setMaxWidth(60);
            jTabelaEnfermaria.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaEnfermaria.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaEnfermaria.getColumnModel().getColumn(3).setMinWidth(80);
            jTabelaEnfermaria.getColumnModel().getColumn(3).setMaxWidth(80);
            jTabelaEnfermaria.getColumnModel().getColumn(4).setMinWidth(80);
            jTabelaEnfermaria.getColumnModel().getColumn(4).setMaxWidth(80);
            jTabelaEnfermaria.getColumnModel().getColumn(5).setMinWidth(80);
            jTabelaEnfermaria.getColumnModel().getColumn(5).setMaxWidth(80);
            jTabelaEnfermaria.getColumnModel().getColumn(6).setMinWidth(70);
            jTabelaEnfermaria.getColumnModel().getColumn(6).setMaxWidth(70);
            jTabelaEnfermaria.getColumnModel().getColumn(7).setMinWidth(70);
            jTabelaEnfermaria.getColumnModel().getColumn(7).setMaxWidth(70);
            jTabelaEnfermaria.getColumnModel().getColumn(8).setMinWidth(70);
            jTabelaEnfermaria.getColumnModel().getColumn(8).setMaxWidth(70);
            jTabelaEnfermaria.getColumnModel().getColumn(9).setMinWidth(70);
            jTabelaEnfermaria.getColumnModel().getColumn(9).setMaxWidth(70);
            jTabelaEnfermaria.getColumnModel().getColumn(10).setMinWidth(60);
            jTabelaEnfermaria.getColumnModel().getColumn(10).setMaxWidth(60);
            jTabelaEnfermaria.getColumnModel().getColumn(11).setMinWidth(70);
            jTabelaEnfermaria.getColumnModel().getColumn(11).setMaxWidth(70);
            jTabelaEnfermaria.getColumnModel().getColumn(12).setMinWidth(70);
            jTabelaEnfermaria.getColumnModel().getColumn(12).setMaxWidth(70);
            jTabelaEnfermaria.getColumnModel().getColumn(13).setMinWidth(70);
            jTabelaEnfermaria.getColumnModel().getColumn(13).setMaxWidth(70);
            jTabelaEnfermaria.getColumnModel().getColumn(14).setMinWidth(60);
            jTabelaEnfermaria.getColumnModel().getColumn(14).setMaxWidth(60);
            jTabelaEnfermaria.getColumnModel().getColumn(15).setMinWidth(70);
            jTabelaEnfermaria.getColumnModel().getColumn(15).setMaxWidth(70);
            jTabelaEnfermaria.getColumnModel().getColumn(16).setMinWidth(70);
            jTabelaEnfermaria.getColumnModel().getColumn(16).setMaxWidth(70);
            jTabelaEnfermaria.getColumnModel().getColumn(17).setMinWidth(70);
            jTabelaEnfermaria.getColumnModel().getColumn(17).setMaxWidth(70);
            jTabelaEnfermaria.getColumnModel().getColumn(18).setMinWidth(70);
            jTabelaEnfermaria.getColumnModel().getColumn(18).setMaxWidth(70);
            jTabelaEnfermaria.getColumnModel().getColumn(19).setMinWidth(70);
            jTabelaEnfermaria.getColumnModel().getColumn(19).setMaxWidth(70);
        }

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Observação", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(204, 0, 0))); // NOI18N

        jObservacaoEnfermaria.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jObservacaoEnfermaria.setEnabled(false);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jObservacaoEnfermaria)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jObservacaoEnfermaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane9)
                            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Enfermaria", jPanel7);

        jPanel18.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jBtNovoPeda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoPeda.setText("Novo");
        jBtNovoPeda.setContentAreaFilled(false);
        jBtNovoPeda.setEnabled(false);
        jBtNovoPeda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovoPeda.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovoPeda.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovoPeda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoPedaActionPerformed(evt);
            }
        });

        jBtAlterarPeda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/refresh-reload-icone-6258-16.png"))); // NOI18N
        jBtAlterarPeda.setText("Alterar");
        jBtAlterarPeda.setContentAreaFilled(false);
        jBtAlterarPeda.setEnabled(false);
        jBtAlterarPeda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterarPeda.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarPeda.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarPeda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarPedaActionPerformed(evt);
            }
        });

        jBtExcluirPeda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirPeda.setText("Excluir");
        jBtExcluirPeda.setContentAreaFilled(false);
        jBtExcluirPeda.setEnabled(false);
        jBtExcluirPeda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluirPeda.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirPeda.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirPeda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirPedaActionPerformed(evt);
            }
        });

        jBtSalvarPeda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarPeda.setText("Gravar");
        jBtSalvarPeda.setContentAreaFilled(false);
        jBtSalvarPeda.setEnabled(false);
        jBtSalvarPeda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvarPeda.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarPeda.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarPeda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarPedaActionPerformed(evt);
            }
        });

        jBtCancelarPeda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarPeda.setText("Cancelar");
        jBtCancelarPeda.setContentAreaFilled(false);
        jBtCancelarPeda.setEnabled(false);
        jBtCancelarPeda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelarPeda.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarPeda.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarPeda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarPedaActionPerformed(evt);
            }
        });

        jBtSairPeda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSairPeda.setText("Sair");
        jBtSairPeda.setContentAreaFilled(false);
        jBtSairPeda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSairPeda.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSairPeda.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSairPeda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairPedaActionPerformed(evt);
            }
        });

        jBtAuditoriaPeda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaPeda.setToolTipText("Auditoria");
        jBtAuditoriaPeda.setContentAreaFilled(false);
        jBtAuditoriaPeda.setEnabled(false);
        jBtAuditoriaPeda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaPedaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(jBtNovoPeda)
                .addGap(2, 2, 2)
                .addComponent(jBtAlterarPeda, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jBtExcluirPeda)
                .addGap(2, 2, 2)
                .addComponent(jBtSalvarPeda)
                .addGap(2, 2, 2)
                .addComponent(jBtCancelarPeda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSairPeda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaPeda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(jBtAlterarPeda)
                .addComponent(jBtExcluirPeda)
                .addComponent(jBtNovoPeda)
                .addComponent(jBtSalvarPeda)
                .addComponent(jBtCancelarPeda)
                .addComponent(jBtSairPeda)
                .addComponent(jBtAuditoriaPeda))
        );

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jComboBoxICAA.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxICAA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        jComboBoxICAA.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxICAA.setEnabled(false);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("ICAA - Interno cursando a alfabetização?");

        jComboBoxIC1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxIC1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        jComboBoxIC1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxIC1.setEnabled(false);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("IC1 - Interno cursando o 1º grau?");

        jComboBoxIC2P.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxIC2P.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        jComboBoxIC2P.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxIC2P.setEnabled(false);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("IC2P - Interno cursando 2º grau/Profissionalizante?");

        jComboBoxIAAU.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxIAAU.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        jComboBoxIAAU.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxIAAU.setEnabled(false);

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setText("IAAU - Interno que adquiriu acesso a universidade?");

        jComboBoxIREL.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxIREL.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        jComboBoxIREL.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxIREL.setEnabled(false);

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setText("IC3 - Interno cursando 3º grau?");

        jComboBoxIC3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxIC3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        jComboBoxIC3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxIC3.setEnabled(false);

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setText("IREL -Interno com remissão pela educação/leitura?");

        jComboBoxIAC.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxIAC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        jComboBoxIAC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxIAC.setEnabled(false);

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setText("IAC - Interno na atividade complementar?");

        jComboBoxICU1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxICU1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        jComboBoxICU1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxICU1.setEnabled(false);

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setText("ICU1 - Interno concluiu o 1º grau?");

        jComboBoxIC2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxIC2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        jComboBoxIC2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxIC2.setEnabled(false);

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel28.setText("IC2 - Interno concluiu o 2º grau?");

        jComboBoxICA.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxICA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        jComboBoxICA.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxICA.setEnabled(false);

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel29.setText("ICA - Interno concluiu a alfabetização?");

        jLabel98.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel98.setText("Data:");

        jDataPeda.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataPeda.setEnabled(false);

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxICA, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxIC2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxICU1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxIAC, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxIREL, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxIC3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxIC1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxICAA, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxIC2P, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxIAAU, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel98)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDataPeda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jComboBoxICAA, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jComboBoxIC1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jComboBoxIC2P, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jComboBoxIAAU, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jComboBoxIC3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jComboBoxIREL, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jComboBoxIAC, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jComboBoxICU1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jComboBoxIC2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel29)
                    .addComponent(jComboBoxICA, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel98)
                    .addComponent(jDataPeda, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaPedagogia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaPedagogia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Reg.", "Data", "ICAA", "IC1", "IC2P", "IAUU", "IC3", "IREL", "IAC", "ICU1", "IC2", "ICA"
            }
        ));
        jTabelaPedagogia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaPedagogiaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTabelaPedagogia);
        if (jTabelaPedagogia.getColumnModel().getColumnCount() > 0) {
            jTabelaPedagogia.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaPedagogia.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaPedagogia.getColumnModel().getColumn(1).setMinWidth(50);
            jTabelaPedagogia.getColumnModel().getColumn(1).setMaxWidth(50);
            jTabelaPedagogia.getColumnModel().getColumn(2).setMinWidth(70);
            jTabelaPedagogia.getColumnModel().getColumn(2).setMaxWidth(70);
            jTabelaPedagogia.getColumnModel().getColumn(3).setMinWidth(50);
            jTabelaPedagogia.getColumnModel().getColumn(3).setMaxWidth(50);
            jTabelaPedagogia.getColumnModel().getColumn(4).setMinWidth(50);
            jTabelaPedagogia.getColumnModel().getColumn(4).setMaxWidth(50);
            jTabelaPedagogia.getColumnModel().getColumn(5).setMinWidth(50);
            jTabelaPedagogia.getColumnModel().getColumn(5).setMaxWidth(50);
            jTabelaPedagogia.getColumnModel().getColumn(6).setMinWidth(50);
            jTabelaPedagogia.getColumnModel().getColumn(6).setMaxWidth(50);
            jTabelaPedagogia.getColumnModel().getColumn(7).setMinWidth(50);
            jTabelaPedagogia.getColumnModel().getColumn(7).setMaxWidth(50);
            jTabelaPedagogia.getColumnModel().getColumn(8).setMinWidth(50);
            jTabelaPedagogia.getColumnModel().getColumn(8).setMaxWidth(50);
            jTabelaPedagogia.getColumnModel().getColumn(9).setMinWidth(50);
            jTabelaPedagogia.getColumnModel().getColumn(9).setMaxWidth(50);
            jTabelaPedagogia.getColumnModel().getColumn(10).setMinWidth(50);
            jTabelaPedagogia.getColumnModel().getColumn(10).setMaxWidth(50);
            jTabelaPedagogia.getColumnModel().getColumn(11).setMinWidth(50);
            jTabelaPedagogia.getColumnModel().getColumn(11).setMaxWidth(50);
            jTabelaPedagogia.getColumnModel().getColumn(12).setMinWidth(50);
            jTabelaPedagogia.getColumnModel().getColumn(12).setMaxWidth(50);
        }

        jLabel100.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel100.setForeground(new java.awt.Color(153, 0, 102));
        jLabel100.setText("Observação");

        jObservacaoPeda.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel100)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jObservacaoPeda))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel100)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jObservacaoPeda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Pedagogia", jPanel10);

        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Tem processos acompanhado?");

        jLabel76.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel76.setText("Documentação está completa?");

        jLabel77.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel77.setText("Tem progressão de regime?");

        jLabel78.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel78.setText("Tem livramento condicional?");

        jComboBoxProcessoAcomp.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxProcessoAcomp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        jComboBoxProcessoAcomp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxProcessoAcomp.setEnabled(false);

        jComboBoxProgressaoRegime.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxProgressaoRegime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        jComboBoxProgressaoRegime.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxProgressaoRegime.setEnabled(false);

        jComboBoxDocumentacao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDocumentacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        jComboBoxDocumentacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDocumentacao.setEnabled(false);

        jComboBoxLivramentoCond.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxLivramentoCond.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        jComboBoxLivramentoCond.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxLivramentoCond.setEnabled(false);

        jLabel99.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel99.setText("Data:");

        jDataCrc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataCrc.setEnabled(false);

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel76, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel77, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel78, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jComboBoxLivramentoCond, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel99)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataCrc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jComboBoxProgressaoRegime, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxDocumentacao, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxProcessoAcomp, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jComboBoxProcessoAcomp, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel76)
                    .addComponent(jComboBoxDocumentacao, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel77)
                    .addComponent(jComboBoxProgressaoRegime, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxLivramentoCond, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel78))
                    .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel99)
                        .addComponent(jDataCrc, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel25.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jBtNovoCrc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoCrc.setText("Novo");
        jBtNovoCrc.setContentAreaFilled(false);
        jBtNovoCrc.setEnabled(false);
        jBtNovoCrc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovoCrc.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovoCrc.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovoCrc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoCrcActionPerformed(evt);
            }
        });

        jBtAlterarCrc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/refresh-reload-icone-6258-16.png"))); // NOI18N
        jBtAlterarCrc.setText("Alterar");
        jBtAlterarCrc.setContentAreaFilled(false);
        jBtAlterarCrc.setEnabled(false);
        jBtAlterarCrc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterarCrc.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarCrc.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarCrc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarCrcActionPerformed(evt);
            }
        });

        jBtExcluirCrc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirCrc.setText("Excluir");
        jBtExcluirCrc.setContentAreaFilled(false);
        jBtExcluirCrc.setEnabled(false);
        jBtExcluirCrc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluirCrc.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirCrc.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirCrc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirCrcActionPerformed(evt);
            }
        });

        jBtSalvarCrc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarCrc.setText("Gravar");
        jBtSalvarCrc.setContentAreaFilled(false);
        jBtSalvarCrc.setEnabled(false);
        jBtSalvarCrc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvarCrc.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarCrc.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarCrc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarCrcActionPerformed(evt);
            }
        });

        jBtCancelarCrc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarCrc.setText("Cancelar");
        jBtCancelarCrc.setContentAreaFilled(false);
        jBtCancelarCrc.setEnabled(false);
        jBtCancelarCrc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelarCrc.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarCrc.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarCrc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarCrcActionPerformed(evt);
            }
        });

        jBtSairCrc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSairCrc.setText("Sair");
        jBtSairCrc.setContentAreaFilled(false);
        jBtSairCrc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSairCrc.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSairCrc.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSairCrc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairCrcActionPerformed(evt);
            }
        });

        jBtAuditoriaCrc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaCrc.setToolTipText("Auditoria");
        jBtAuditoriaCrc.setContentAreaFilled(false);
        jBtAuditoriaCrc.setEnabled(false);
        jBtAuditoriaCrc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaCrcActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addComponent(jBtNovoCrc)
                .addGap(2, 2, 2)
                .addComponent(jBtAlterarCrc, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jBtExcluirCrc)
                .addGap(2, 2, 2)
                .addComponent(jBtSalvarCrc)
                .addGap(2, 2, 2)
                .addComponent(jBtCancelarCrc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSairCrc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaCrc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(jBtAlterarCrc)
                .addComponent(jBtExcluirCrc)
                .addComponent(jBtNovoCrc)
                .addComponent(jBtSalvarCrc)
                .addComponent(jBtCancelarCrc)
                .addComponent(jBtSairCrc)
                .addComponent(jBtAuditoriaCrc))
        );

        jTabelaCrcJuridico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaCrcJuridico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Processos", "Documentação", "Progressão", "Livramento", "Observação"
            }
        ));
        jTabelaCrcJuridico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaCrcJuridicoMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTabelaCrcJuridico);
        if (jTabelaCrcJuridico.getColumnModel().getColumnCount() > 0) {
            jTabelaCrcJuridico.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaCrcJuridico.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaCrcJuridico.getColumnModel().getColumn(1).setMinWidth(100);
            jTabelaCrcJuridico.getColumnModel().getColumn(1).setMaxWidth(100);
            jTabelaCrcJuridico.getColumnModel().getColumn(2).setMinWidth(100);
            jTabelaCrcJuridico.getColumnModel().getColumn(2).setMaxWidth(100);
            jTabelaCrcJuridico.getColumnModel().getColumn(3).setMinWidth(100);
            jTabelaCrcJuridico.getColumnModel().getColumn(3).setMaxWidth(100);
            jTabelaCrcJuridico.getColumnModel().getColumn(4).setMinWidth(100);
            jTabelaCrcJuridico.getColumnModel().getColumn(4).setMaxWidth(100);
            jTabelaCrcJuridico.getColumnModel().getColumn(5).setMinWidth(150);
        }

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Observação", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 102, 0))); // NOI18N

        jScrollPane6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jObservacaoCrc.setColumns(20);
        jObservacaoCrc.setRows(5);
        jScrollPane6.setViewportView(jObservacaoCrc);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6)
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("CRC/Jurídico", jPanel11);

        jPanel27.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel83.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel83.setText("Está inserido em algum programa?");

        jLabel84.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel84.setText("Passou por algum curso?");

        jLabel85.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel85.setText("Concluiu alguma formação profissional?");

        jComboBoxConcluiuFP.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxConcluiuFP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        jComboBoxConcluiuFP.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxConcluiuFP.setEnabled(false);

        jComboBoxPassouCurso.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxPassouCurso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        jComboBoxPassouCurso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxPassouCurso.setEnabled(false);

        jComboBoxPrograma.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxPrograma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        jComboBoxPrograma.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxPrograma.setEnabled(false);

        jLabel101.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel101.setText("Data:");

        jDataTO.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataTO.setEnabled(false);

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel85)
                    .addComponent(jLabel84)
                    .addComponent(jLabel83))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxPassouCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxConcluiuFP, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel101)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDataTO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(184, 184, 184))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel83))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxPassouCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel84))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxConcluiuFP, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel85))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel101)
                    .addComponent(jDataTO, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel33.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

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

        jBtAlterarTO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/refresh-reload-icone-6258-16.png"))); // NOI18N
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

        jBtAuditoriaTO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaTO.setToolTipText("Auditoria");
        jBtAuditoriaTO.setContentAreaFilled(false);
        jBtAuditoriaTO.setEnabled(false);
        jBtAuditoriaTO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaTOActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addComponent(jBtNovoTO)
                .addGap(2, 2, 2)
                .addComponent(jBtAlterarTO, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jBtExcluirTO)
                .addGap(2, 2, 2)
                .addComponent(jBtSalvarTO)
                .addGap(2, 2, 2)
                .addComponent(jBtCancelarTO)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSairTO)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaTO, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(jBtAlterarTO)
                .addComponent(jBtExcluirTO)
                .addComponent(jBtNovoTO)
                .addComponent(jBtSalvarTO)
                .addComponent(jBtCancelarTO)
                .addComponent(jBtSairTO)
                .addComponent(jBtAuditoriaTO))
        );

        jPanel26.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Observação", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(153, 0, 102))); // NOI18N

        jScrollPane10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jObservacaoTO.setColumns(20);
        jObservacaoTO.setRows(5);
        jScrollPane10.setViewportView(jObservacaoTO);

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10)
                .addContainerGap())
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jTabelaTO.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaTO.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Inserido", "Algum Curso", "Concluiu", "Observação"
            }
        ));
        jScrollPane11.setViewportView(jTabelaTO);
        if (jTabelaTO.getColumnModel().getColumnCount() > 0) {
            jTabelaTO.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaTO.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaTO.getColumnModel().getColumn(1).setMinWidth(80);
            jTabelaTO.getColumnModel().getColumn(1).setMaxWidth(80);
            jTabelaTO.getColumnModel().getColumn(2).setMinWidth(100);
            jTabelaTO.getColumnModel().getColumn(2).setMaxWidth(100);
            jTabelaTO.getColumnModel().getColumn(3).setMinWidth(90);
            jTabelaTO.getColumnModel().getColumn(3).setMaxWidth(90);
            jTabelaTO.getColumnModel().getColumn(4).setMinWidth(150);
        }

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane11))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("TO", jPanel12);

        jPanel37.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel89.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel89.setText("Está em tratamento?");

        jLabel90.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel90.setText("Tem algun acompanhamento?");

        jLabel91.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel91.setText("Está em recuperação?");

        jComboBoxTratamentoPSI.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTratamentoPSI.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        jComboBoxTratamentoPSI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTratamentoPSI.setEnabled(false);

        jComboBoxAcompanhamentoPSI.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxAcompanhamentoPSI.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        jComboBoxAcompanhamentoPSI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxAcompanhamentoPSI.setEnabled(false);

        jComboBoxRecuparacaoPSI.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxRecuparacaoPSI.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        jComboBoxRecuparacaoPSI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxRecuparacaoPSI.setEnabled(false);

        jLabel102.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel102.setText("Data:");

        jDataPSI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataPSI.setEnabled(false);

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel91)
                        .addComponent(jLabel90)
                        .addComponent(jLabel89))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel102)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDataPSI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxRecuparacaoPSI, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxAcompanhamentoPSI, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTratamentoPSI, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel89)
                    .addComponent(jComboBoxTratamentoPSI, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel90)
                    .addComponent(jComboBoxAcompanhamentoPSI, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel91)
                    .addComponent(jComboBoxRecuparacaoPSI, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel102)
                    .addComponent(jDataPSI, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel38.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Observação", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 204))); // NOI18N

        jObservacaoPSI.setColumns(20);
        jObservacaoPSI.setRows(5);
        jObservacaoPSI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jObservacaoPSI.setEnabled(false);
        jScrollPane7.setViewportView(jObservacaoPSI);

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7)
                .addContainerGap())
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel39.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

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

        jBtAlterarPSI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/refresh-reload-icone-6258-16.png"))); // NOI18N
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

        jBtAuditoriaPSI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaPSI.setToolTipText("Auditoria");
        jBtAuditoriaPSI.setContentAreaFilled(false);
        jBtAuditoriaPSI.setEnabled(false);
        jBtAuditoriaPSI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaPSIActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addComponent(jBtNovoPSI)
                .addGap(2, 2, 2)
                .addComponent(jBtAlterarPSI, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jBtExcluirPSI)
                .addGap(2, 2, 2)
                .addComponent(jBtSalvarPSI)
                .addGap(2, 2, 2)
                .addComponent(jBtCancelarPSI)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSairPSI)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaPSI, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(jBtAlterarPSI)
                .addComponent(jBtExcluirPSI)
                .addComponent(jBtNovoPSI)
                .addComponent(jBtSalvarPSI)
                .addComponent(jBtCancelarPSI)
                .addComponent(jBtSairPSI)
                .addComponent(jBtAuditoriaPSI))
        );

        jTabelaPSI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaPSI.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Tratamento", "Acompanha", "Recuperação", "Observação"
            }
        ));
        jScrollPane12.setViewportView(jTabelaPSI);
        if (jTabelaPSI.getColumnModel().getColumnCount() > 0) {
            jTabelaPSI.getColumnModel().getColumn(0).setMinWidth(80);
            jTabelaPSI.getColumnModel().getColumn(0).setMaxWidth(80);
            jTabelaPSI.getColumnModel().getColumn(1).setMinWidth(90);
            jTabelaPSI.getColumnModel().getColumn(1).setMaxWidth(90);
            jTabelaPSI.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaPSI.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaPSI.getColumnModel().getColumn(3).setMinWidth(80);
            jTabelaPSI.getColumnModel().getColumn(3).setMaxWidth(80);
            jTabelaPSI.getColumnModel().getColumn(4).setMinWidth(150);
        }

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane12))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("PSI", jPanel14);

        jPanel41.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel96.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel96.setText("Tem familiares com acompanhamento?");

        jComboBoxAcompanhaSS.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxAcompanhaSS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        jComboBoxAcompanhaSS.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxAcompanhaSS.setEnabled(false);

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(jLabel96)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxAcompanhaSS, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel41Layout.createSequentialGroup()
                .addContainerGap(128, Short.MAX_VALUE)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel96)
                    .addComponent(jComboBoxAcompanhaSS, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(121, 121, 121))
        );

        jPanel42.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Observação", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 204))); // NOI18N

        jObservaacaoSS.setColumns(20);
        jObservaacaoSS.setRows(5);
        jObservaacaoSS.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jScrollPane8.setViewportView(jObservaacaoSS);

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8)
                .addContainerGap())
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel43.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

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

        jBtAlterarSS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/refresh-reload-icone-6258-16.png"))); // NOI18N
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

        jBtAuditoriaSS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaSS.setToolTipText("Auditoria");
        jBtAuditoriaSS.setContentAreaFilled(false);
        jBtAuditoriaSS.setEnabled(false);
        jBtAuditoriaSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaSSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addComponent(jBtNovoSS)
                .addGap(2, 2, 2)
                .addComponent(jBtAlterarSS, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jBtExcluirSS)
                .addGap(2, 2, 2)
                .addComponent(jBtSalvarSS)
                .addGap(2, 2, 2)
                .addComponent(jBtCancelarSS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSairSS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaSS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(jBtAlterarSS)
                .addComponent(jBtExcluirSS)
                .addComponent(jBtNovoSS)
                .addComponent(jBtSalvarSS)
                .addComponent(jBtCancelarSS)
                .addComponent(jBtSairSS)
                .addComponent(jBtAuditoriaSS))
        );

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("S.S", jPanel28);

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Enfermaria", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(204, 0, 0))); // NOI18N

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel39.setText("Hipertensão - Controlada");

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel46.setText("Hepatite B:");

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel47.setText("Escabiose:");

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel49.setText("Tuberculose - Curada:");

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel50.setText("HIV - Controlada:");

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel51.setText("Diabetes  - Controlada:");

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel52.setText("Sifilis - Controlada:");

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel53.setText("Hanseniase - Curada:");

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel54.setText("Hepatite C:");

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel56.setText("%");

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel57.setText("%");

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel58.setText("%");

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel59.setText("%");

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel60.setText("%");

        jLabel65.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel65.setText("%");

        jLabel66.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel66.setText("%");

        jLabel68.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel68.setText("%");

        jLabel69.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel69.setText("%");

        jTextField10.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jTextField11.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jTextField12.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jTextField13.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jTextField14.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jTextField15.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField15.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jTextField16.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField16.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jTextField17.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField17.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jTextField18.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField18.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel103.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel103.setText("Tratamento de DST %");

        jTextField40.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField40.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel46)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel58))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel47)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel60))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel49)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel69))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel50)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel68))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel52)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel66))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel53)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel65))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel54)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel59))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel51)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel56))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel39)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel57))
                    .addComponent(jLabel103))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextField17, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField18, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField15, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField14, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField13, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField12, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField11, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField10, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField40, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel51)
                    .addComponent(jLabel56)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel39)
                    .addComponent(jLabel57)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel46)
                    .addComponent(jLabel58)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel54)
                    .addComponent(jLabel59)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel47)
                    .addComponent(jLabel60)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel53)
                    .addComponent(jLabel65)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel52)
                    .addComponent(jLabel66)
                    .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel50)
                    .addComponent(jLabel68)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel49)
                    .addComponent(jLabel69)
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTextField40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel103))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel24.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Jurídico/CRC", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 102, 0))); // NOI18N

        jLabel79.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel79.setText("Processos acompanhado %");
        jLabel79.setToolTipText("Percentual de processos acompanhado");

        jLabel80.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel80.setText("Documentação completa %");
        jLabel80.setToolTipText("Percentuial de Documentação está completa");

        jLabel81.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel81.setText("Quant.progressão de regime");
        jLabel81.setToolTipText("Quantidade de progressão de regime");

        jLabel82.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel82.setText("Quant. livra. condicional");
        jLabel82.setToolTipText("Quantidade de livramento condicional");

        jTextField29.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField29.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jTextField30.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField30.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jTextField31.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField31.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jTextField32.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField32.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(jLabel82)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel81)
                            .addComponent(jLabel80)
                            .addComponent(jLabel79))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel79)
                    .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel80)
                    .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel81)
                    .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel82)
                    .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel35.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Serviço Social", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 51, 0))); // NOI18N

        jLabel95.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel95.setText("Int. familia. acompanhado %");
        jLabel95.setToolTipText("Percentual Internos com familiares acompanhado");

        jTextField39.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField39.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel95)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField39, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel95))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel36.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Psicologia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 102, 102))); // NOI18N

        jLabel92.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel92.setText("Internos em tratamento %");

        jTextField36.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField36.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jTextField37.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField37.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jTextField38.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField38.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel94.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel94.setText("Interno em recuperação %");

        jLabel93.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel93.setText("Internos em acompanhamento %");

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel92)
                    .addComponent(jLabel94)
                    .addComponent(jLabel93))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField38, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField37, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField36, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel92)
                    .addComponent(jTextField36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel93)
                    .addComponent(jTextField37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel94)
                    .addComponent(jTextField38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel34.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Terapia Ocupacional", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(102, 0, 102))); // NOI18N

        jLabel86.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel86.setText("Int. inserido nos programa %");

        jLabel87.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel87.setText("Int.  passaram por algum curso %");

        jLabel88.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel88.setText("Int. concl. formação profissional %");
        jLabel88.setToolTipText("Percentual de Internos que concluiram alguma formação profissional");

        jTextField33.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField33.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jTextField34.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField34.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jTextField35.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField35.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                        .addComponent(jLabel88)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField35, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                        .addComponent(jLabel86)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                        .addComponent(jLabel87)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel86)
                    .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel87)
                    .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel88)
                    .addComponent(jTextField35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Pedagogia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 204))); // NOI18N

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel55.setText("Int. cursando a alfabetização %");
        jLabel55.setToolTipText("Interno cursando a alfabetização?");

        jTextField19.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField19.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel70.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel70.setText("Internos cursando o 1º grau %");
        jLabel70.setToolTipText("Interno cursando o 1º grau?");

        jTextField20.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField20.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel71.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel71.setText("Int. cursando 2º grau/Prof. %");
        jLabel71.setToolTipText("Interno cursando 2º grau/Profissionalizante?");

        jTextField21.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField21.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel72.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel72.setText("Int. que adquiriu acesso a unid. %");
        jLabel72.setToolTipText("Interno que adquiriu acesso a universidade?");

        jTextField22.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField22.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel73.setText("Interno cursando 3º grau %");
        jLabel73.setToolTipText("Interno cursando 3º grau?");

        jTextField23.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField23.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel74.setText("Int. rem. p/ educação/leitura %");
        jLabel74.setToolTipText("Interno com remissão pela educação/leitura?");

        jTextField24.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField24.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel75.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel75.setText("Int. atividade complementar %");
        jLabel75.setToolTipText("Interno na atividade complementar?");

        jTextField25.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField25.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel38.setText("Quant. Int. concluiu o 1º grau?");
        jLabel38.setToolTipText("Quantidade de  Internos concluiu o 1º grau?");

        jTextField26.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField26.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel45.setText("Quant. Int. concluiu o 2º grau?");
        jLabel45.setToolTipText("Quantidade Interno concluiu o 2º grau?");

        jTextField27.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField27.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel48.setText("Quant. Int. concluiu alfabetização?");

        jTextField28.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField28.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel48, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel75, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel74, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel73, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel72, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel70, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel71, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel55, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel22Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTextField19, jTextField20, jTextField21, jTextField22, jTextField23, jTextField24, jTextField25});

        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel70)
                    .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel71))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel72)
                    .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel73))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel74)
                    .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel75))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel34, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel36, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel40Layout.createSequentialGroup()
                        .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Total", jPanel40);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Foto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jFotoInternoPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jFotoInternoPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 162, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, Short.MAX_VALUE))
                .addContainerGap())
        );

        setBounds(300, 30, 759, 542);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesqCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqCodigoActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (jCodigoPesqPAI.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe um código para pesquisa.");
            jCodigoPesqPAI.requestFocus();
        } else {
            preencherTabelaPerfilCarcerario("SELECT * FROM INDICADOR_ACOMPANHAMENTO_INTERNO "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=INDICADOR_ACOMPANHAMENTO_INTERNO.IdInternoCrc "
                    + "WHERE IdIndAco='" + jCodigoPesqPAI.getText() + "'");
        }
    }//GEN-LAST:event_jBtPesqCodigoActionPerformed

    private void jBtPesqDataPAIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqDataPAIActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (tipoServidor == null || tipoServidor.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "É necessário definir o parâmtero para o sistema operacional utilizado no servidor, (UBUNTU-LINUX ou WINDOWS SERVER).");
        } else if (tipoServidor.equals("Servidor Linux (Ubuntu)/MS-SQL Server")) {
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
                        SimpleDateFormat formatoAmerica = new SimpleDateFormat("yyyy/MM/dd");
                        dataInicial = formatoAmerica.format(jDataInicial.getDate().getTime());
                        dataFinal = formatoAmerica.format(jDataFinal.getDate().getTime());
                        preencherTabelaPerfilCarcerario("SELECT * FROM INDICADOR_ACOMPANHAMENTO_INTERNO "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON PRONTUARIOSCRC.IdInternoCrc=INDICADOR_ACOMPANHAMENTO_INTERNO.IdInternoCrc "
                                + "WHERE DataPerfil BETWEEN'" + dataInicial + "' "
                                + "AND '" + dataFinal + "'");
                    }
                }
            }
        } else if (tipoServidor.equals("Servidor Windows/MS-SQL Server")) {
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
                        preencherTabelaPerfilCarcerario("SELECT * FROM INDICADOR_ACOMPANHAMENTO_INTERNO "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON PRONTUARIOSCRC.IdInternoCrc=INDICADOR_ACOMPANHAMENTO_INTERNO.IdInternoCrc "
                                + "WHERE DataPerfil BETWEEN'" + dataInicial + "' "
                                + "AND '" + dataFinal + "'");
                    }
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
            preencherTabelaPerfilCarcerario("SELECT * FROM INDICADOR_ACOMPANHAMENTO_INTERNO "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=INDICADOR_ACOMPANHAMENTO_INTERNO.IdInternoCrc "
                    + "WHERE NomeInternoCrc LIKE'%" + jNomeInternoPesquisa.getText() + "%'");
        }
    }//GEN-LAST:event_jBtPesqNomeInternoPAIActionPerformed

    private void jCheckBoxTodosRegistrosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxTodosRegistrosItemStateChanged
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherTabelaPerfilCarcerario("SELECT * FROM INDICADOR_ACOMPANHAMENTO_INTERNO "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=INDICADOR_ACOMPANHAMENTO_INTERNO.IdInternoCrc");
        } else {
            limparTabelaPerfilCarcerario();
        }
    }//GEN-LAST:event_jCheckBoxTodosRegistrosItemStateChanged

    private void jTabelaPerfilCarcerarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaPerfilCarcerarioMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            String idAtend = "" + jTabelaPerfilCarcerario.getValueAt(jTabelaPerfilCarcerario.getSelectedRow(), 0);
            jCodigoPesqPAI.setText(idAtend);
            //
            bloquearCampos();
            bloquearBotoes();
            limparCamposNovo();
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            //
            jBtNovoEnfermaria.setEnabled(true);
            jBtNovoPeda.setEnabled(true);
            jBtNovoCrc.setEnabled(true);
            jBtNovoTO.setEnabled(true);
            jBtNovoPSI.setEnabled(true);
            jBtNovoSS.setEnabled(true);
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM INDICADOR_ACOMPANHAMENTO_INTERNO "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=INDICADOR_ACOMPANHAMENTO_INTERNO.IdInternoCrc "
                        + "INNER JOIN DADOSFISICOSINTERNOS "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSFISICOSINTERNOS.IdInternoCrc "
                        + "INNER JOIN DADOSPENAISINTERNOS "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                        + "INNER JOIN CIDADES "
                        + "ON PRONTUARIOSCRC.IdCidade=CIDADES.IdCidade "
                        + "INNER JOIN ITENSLOCACAOINTERNO "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSLOCACAOINTERNO.IdInternoCrc "
                        + "INNER JOIN CELAS "
                        + "ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                        + "INNER JOIN PAVILHAO "
                        + "ON CELAS.IdPav=PAVILHAO.IdPav "
                        + "WHERE INDICADOR_ACOMPANHAMENTO_INTERNO.IdIndAco='" + idAtend + "'");
                conecta.rs.first();
                jIdPerfil.setText(String.valueOf(conecta.rs.getInt("IdIndAco")));
                jStatusPerfil.setText(conecta.rs.getString("StatusPerfil"));
                jAnoReferencia.setValue(conecta.rs.getInt("AnoRef"));
                jDataPerfil.setDate(conecta.rs.getDate("DataPerfil"));
                jIdInternoPerfil.setText(conecta.rs.getString("IdInternoCrc"));
                jNomeInternoPerfil.setText(conecta.rs.getString("NomeInternoCrc"));
                jSexo.setText(conecta.rs.getString("SexoCrc"));
                jOpcaoSexual.setText(conecta.rs.getString("OpcaoSexual"));
                jAnoNascimento.setValue(conecta.rs.getInt("AnoNasc"));
                jPavilhaoInternoPerfil.setText(conecta.rs.getString("DescricaoPav"));
                jCelaInternoPerfil.setText(conecta.rs.getString("EndCelaPav"));
                // Capturando foto
                caminho = conecta.rs.getString("FotoInternoCrc");
                javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                jFotoInternoPerfil.setIcon(i);
                jFotoInternoPerfil.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoInternoPerfil.getWidth(), jFotoInternoPerfil.getHeight(), Image.SCALE_DEFAULT)));
                // BUSCAR A FOTO DO BANCO DE DADOS - FOTO FRENTE
                byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrente"));
                if (imgBytes != null) {
                    ImageIcon pic = null;
                    pic = new ImageIcon(imgBytes);
                    Image scaled = pic.getImage().getScaledInstance(jFotoInternoPerfil.getWidth(), jFotoInternoPerfil.getHeight(), Image.SCALE_DEFAULT);
                    ImageIcon icon = new ImageIcon(scaled);
                    jFotoInternoPerfil.setIcon(icon);
                }
                jEtiniaInternoPerfil.setText(conecta.rs.getString("Cutis"));
                jCidadeInternoPerfil.setText(conecta.rs.getString("CidadeCrc"));
                jBairroInternoPerfil.setText(conecta.rs.getString("BairroCrc"));
                jObservacaoInternoPerfil.setText(conecta.rs.getString("ObservacaoPerfil"));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa dos dados..." + e);
            }
            conecta.desconecta();
        }
        //ENFERMAGEM
        preencherTabelaEnfermaria("SELECT * FROM INDICADOR_ACOMPANHAMENTO_INTERNO_ENFERMARIA "
                + "WHERE IdIndAco='" + jIdPerfil.getText() + "'");
        //PEDAGOGIA
        preencherTabelaPedagogia("SELECT * FROM INDICADOR_ACOMPANHAMENTO_INTERNO_PEDAGOGIA "
                + "WHERE IdIndAco='" + jIdPerfil.getText() + "'");
        //JURIDICO/CRC
        preencherTabelaCrc("SELECT * FROM INDICADOR_ACOMPANHAMENTO_INTERNO_JURIDICO_CRC "
                + "WHERE IdIndAco='" + jIdPerfil.getText() + "'");
    }//GEN-LAST:event_jTabelaPerfilCarcerarioMouseClicked

    private void jBtPesquisaInternoPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisaInternoPerfilActionPerformed
        // TODO add your handling code here:
        TelaPesqInternoIndicadoresAcompanhamento objPesqInternoPerfil = new TelaPesqInternoIndicadoresAcompanhamento();
        TelaModuloEnfermaria.jPainelMedico.add(objPesqInternoPerfil);
        objPesqInternoPerfil.show();
    }//GEN-LAST:event_jBtPesquisaInternoPerfilActionPerformed

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaIndAcompanhaManu);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaIndAcompanhaManu) && codIncluirENF == 1) {
            acao = 1;
            bloquearCampos();
            limparCamposNovo();
            bloquearBotoes();
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
        buscarAcessoUsuario(telaIndAcompanhaManu);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaIndAcompanhaManu) && codAlterarENF == 1) {
            objPerfilInter.setStatusPerfil(jStatusPerfil.getText());
            if (jStatusPerfil.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 2;
                bloquearCampos();
                bloquearBotoes();
                Alterar();
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
        buscarAcessoUsuario(telaIndAcompanhaManu);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaIndAcompanhaManu) && codExcluirENF == 1) {
            verificarInternoIndicadorAcompanha();
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            if (jIdInternoPerfil.getText().equals(codInterno)) {
                JOptionPane.showMessageDialog(rootPane, "Não é possível excluir esse registro, o interno tem perfil carcerário cadastrado.");
            } else {
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    objPerfilInter.setIdIndAco(Integer.valueOf(jIdPerfil.getText()));
                    control.excluirIndicadorAcompanhamento(objPerfilInter);
                    bloquearCampos();
                    limparCamposNovo();
                    bloquearBotoes();
                    Excluir();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaIndAcompanhaManu);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaIndAcompanhaManu) && codGravarENF == 1) {
            verificarExistenciaIndicadorAcompanha();
            if (jDataPerfil.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data de cadastro do perfil carcerário");
            } else if (jIdInternoPerfil.getText().equals("") || jNomeInternoPerfil.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome do interno do perfil carcerário.");
            } else if (jAnoNascimento.getValue() == 0 || jAnoNascimento.getValue() < 0) {
                JOptionPane.showMessageDialog(rootPane, "Informe o ano de nascimento do interno corretamente.");
            } else if (jOpcaoSexual.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe a opção sexual do interno.");
            } else {
                objPerfilInter.setStatusPerfil(jStatusPerfil.getText());
                objPerfilInter.setDataPerfil(jDataPerfil.getDate());
                objPerfilInter.setAnoReferencia(jAnoReferencia.getValue());
                objPerfilInter.setMesReferencia(jMesReferencia.getName());
                objPerfilInter.setOpcaoSexual(jOpcaoSexual.getText());
                objPerfilInter.setAnoNascimento(jAnoNascimento.getValue());
                objPerfilInter.setObservacaoPerfil(jObservacaoInternoPerfil.getText());
                objPerfilInter.setIdInternoCrc(Integer.valueOf(jIdInternoPerfil.getText()));
                objPerfilInter.setNomeInternoPerfil(jNomeInternoPerfil.getText());
                if (acao == 1) {
                    if (jIdInternoPerfil.getText().equals(codInterno) && objPerfilInter.getAnoReferencia() == anoReferencia) {
                        JOptionPane.showMessageDialog(rootPane, "Esse interno já fez o cadastro do perfil carcerário.");
                    } else {
                        objPerfilInter.setUsuarioInsert(nameUser);
                        objPerfilInter.setDataInsert(dataModFinal);
                        objPerfilInter.setHorarioInsert(horaMov);
                        //
                        control.incluirIndicadorAcompanhamento(objPerfilInter);
                        buscarCodigo();
                        //
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        bloquearCampos();
                        bloquearBotoes();
                        Salvar();
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    }
                }
                if (acao == 2) {
                    objPerfilInter.setUsuarioUp(nameUser);
                    objPerfilInter.setDataUp(dataModFinal);
                    objPerfilInter.setHorarioUp(horaMov);
                    //
                    objPerfilInter.setIdIndAco(Integer.valueOf(jIdPerfil.getText()));
                    control.alterarIndicadorAcompanhamento(objPerfilInter);
                    //
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
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
        bloquearCampos();
        bloquearBotoes();
        Cancelar();
    }//GEN-LAST:event_jBtCancelarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtAuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaIncadoresAcompanhamento objPerfilCarEnf = new TelaAuditoriaIncadoresAcompanhamento();
        TelaModuloEnfermaria.jPainelMedico.add(objPerfilCarEnf);
        objPerfilCarEnf.show();
    }//GEN-LAST:event_jBtAuditoriaActionPerformed

    private void jBtFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFinalizarActionPerformed
        // TODO add your handling code here:
        statusMov = "Finalizou";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        String statusAtend = "FINALIZADO";
        JOptionPane.showMessageDialog(rootPane, "Se esse registro for finaliza,\nvocê não poderá mais excluir ou alterar.");
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente FINALIZA o registro selecionado?", "Confirmação",
                JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            objPerfilInter.setStatusPerfil(statusAtend);
            objPerfilInter.setIdIndAco(Integer.parseInt(jIdPerfil.getText()));
//            control.finalizarPerfilCarcerarioInterno(objPerfilInter);
            objPerfilInter.setIdIndAco(Integer.valueOf(jIdPerfil.getText()));
            jStatusPerfil.setText(statusAtend);
            //
            objLog();
            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
            JOptionPane.showMessageDialog(rootPane, "Registro FINALIZADO com sucesso !!!");
        }
    }//GEN-LAST:event_jBtFinalizarActionPerformed

    private void jBtNovoEnfermariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoEnfermariaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaIndAcompanhaAbaE);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaIndAcompanhaAbaE) && codIncluirENF == 1) {
            objPerfilInter.setStatusPerfil(jStatusPerfil.getText());
            if (jStatusPerfil.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 3;
                bloquearCampos();
                bloquearBotoes();
                NovoEnfermaria();
                statusMov = "Incluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovoEnfermariaActionPerformed

    private void jBtAlterarEnfermariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarEnfermariaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaIndAcompanhaAbaE);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaIndAcompanhaAbaE) && codAlterarENF == 1) {
            objPerfilInter.setStatusPerfil(jStatusPerfil.getText());
            if (jStatusPerfil.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 4;
                bloquearCampos();
                bloquearBotoes();
                AlterarEnfermaria();
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtAlterarEnfermariaActionPerformed

    private void jBtExcluirEnfermariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirEnfermariaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaIndAcompanhaAbaE);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaIndAcompanhaAbaE) && codExcluirENF == 1) {
            objPerfilInter.setStatusPerfil(jStatusPerfil.getText());
            if (jStatusPerfil.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser excluído, o mesmo encontra-se FINALIZADO");
            } else {
                statusMov = "Excluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    bloquearCampos();
                    bloquearBotoes();
                    objPerfilInter.setIdEnf(codigoEnf);
                    objPerfilInter.setIdIndAco(Integer.valueOf(jIdPerfil.getText()));
                    controle.excluirIndicadorAcompanhamentoEnfermaria(objPerfilInter);
                    ExcluirEnfermaria();
                    preencherTabelaEnfermaria("SELECT * FROM INDICADOR_ACOMPANHAMENTO_INTERNO_ENFERMARIA "
                            + "WHERE IdIndAco='" + jIdPerfil.getText() + "'");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirEnfermariaActionPerformed

    private void jBtSalvarEnfermariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarEnfermariaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaIndAcompanhaAbaE);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaIndAcompanhaAbaE) && codGravarENF == 1) {
            objPerfilInter.setIdIndAco(Integer.valueOf(jIdPerfil.getText()));
            objPerfilInter.setIdInternoCrc(Integer.valueOf(jIdInternoPerfil.getText()));
            objPerfilInter.setNomeInternoPerfil(jNomeInternoPerfil.getText());
            objPerfilInter.setHipertensao((String) jComboBoxHipertensao.getSelectedItem());
            objPerfilInter.setEscabiose((String) jComboBoxEscabiose.getSelectedItem());
            objPerfilInter.setEscabioseCura((String) jComboBoxEscabioseCont.getSelectedItem());
            objPerfilInter.setHanseniase((String) jComboBoxHanseniase.getSelectedItem());
            objPerfilInter.setSifilis((String) jComboBoxSifilis.getSelectedItem());
            objPerfilInter.setTuberculose((String) jComboBoxTuberculose.getSelectedItem());
            objPerfilInter.setDiabetes((String) jComboBoxDiabetes.getSelectedItem());
            objPerfilInter.setDiabControl((String) jComboBoxDiabetesCont.getSelectedItem());
            objPerfilInter.setHiperControl((String) jComboBoxHipertensaoCont.getSelectedItem());
            objPerfilInter.setHanseniaseCura((String) jComboBoxHanseniaseCont.getSelectedItem());
            objPerfilInter.setSifilisCura((String) jComboBoxSifilisCont.getSelectedItem());
            objPerfilInter.setTuberculoseCura((String) jComboBoxTuberculoseCont.getSelectedItem());
            objPerfilInter.setHiv((String) jComboBoxHIV.getSelectedItem());
            objPerfilInter.setHivControlada((String) jComboBoxHIVCont.getSelectedItem());
            objPerfilInter.setHepatiteB((String) jComboBoxHepatiteB.getSelectedItem());
            objPerfilInter.setHepatiBCont((String) jComboBoxhepatiteBContro.getSelectedItem());
            objPerfilInter.setHepatiteC((String) jComboBoxHepatiteC.getSelectedItem());
            objPerfilInter.setHepatiCcont((String) jComboBoxHepatiteCcurada.getSelectedItem());
            objPerfilInter.setDst((String) jComboBoxDST.getSelectedItem());
            objPerfilInter.setvDLR((String) jComboBoxVDRL.getSelectedItem());
            objPerfilInter.setVacina((String) jComboBoxVacina.getSelectedItem());
            objPerfilInter.setDataReg(jDataRegEnfermaria.getDate());
            objPerfilInter.setObservacaoEnf(jObservacaoEnfermaria.getText());
            //
            if (jComboBoxDiabetesCont.getSelectedItem().equals("Sim")) {
                qtdDiabetes = 1;
                objPerfilInter.setQtdDiabetes(qtdDiabetes);
            } else if (jComboBoxDiabetesCont.getSelectedItem().equals("Não")) {
                qtdDiabetes = 0;
                objPerfilInter.setQtdDiabetes(qtdDiabetes);
            }
            if (jComboBoxHipertensaoCont.getSelectedItem().equals("Sim")) {
                qtdHipertensao = 1;
                objPerfilInter.setQtdHipertensao(qtdHipertensao);
            } else if (jComboBoxHipertensaoCont.getSelectedItem().equals("Não")) {
                qtdHipertensao = 0;
                objPerfilInter.setQtdHipertensao(qtdHipertensao);
            }
            if (jComboBoxEscabioseCont.getSelectedItem().equals("Sim")) {
                qtdEscabiose = 1;
                objPerfilInter.setQtdEscabiose(qtdEscabiose);
            } else if (jComboBoxEscabioseCont.getSelectedItem().equals("Não")) {
                qtdEscabiose = 0;
                objPerfilInter.setQtdEscabiose(qtdEscabiose);
            }
            if (jComboBoxHanseniaseCont.getSelectedItem().equals("Sim")) {
                qtdHanseniase = 1;
                objPerfilInter.setQtdHanseniase(qtdHanseniase);
            } else if (jComboBoxHanseniaseCont.getSelectedItem().equals("Não")) {
                qtdHanseniase = 0;
                objPerfilInter.setQtdHanseniase(qtdHanseniase);
            }
            if (jComboBoxSifilisCont.getSelectedItem().equals("Sim")) {
                qtdSifilis = 1;
                objPerfilInter.setQtdSifilis(qtdSifilis);
            } else if (jComboBoxSifilisCont.getSelectedItem().equals("Não")) {
                qtdSifilis = 0;
                objPerfilInter.setQtdSifilis(qtdSifilis);
            }
            if (jComboBoxTuberculoseCont.getSelectedItem().equals("Sim")) {
                qtdTuberculose = 1;
                objPerfilInter.setQtdTuberculose(qtdTuberculose);
            } else if (jComboBoxTuberculoseCont.getSelectedItem().equals("Não")) {
                qtdTuberculose = 0;
                objPerfilInter.setQtdTuberculose(qtdTuberculose);
            }
            if (jComboBoxHIVCont.getSelectedItem().equals("Sim")) {
                qtdHib = 1;
                objPerfilInter.setQtdHib(qtdHib);
            } else if (jComboBoxHIVCont.getSelectedItem().equals("Não")) {
                qtdHib = 0;
                objPerfilInter.setQtdHib(qtdHib);
            }
            if (jComboBoxhepatiteBContro.getSelectedItem().equals("Sim")) {
                qtdHepatiteB = 1;
                objPerfilInter.setQtdHepatiteB(qtdHepatiteB);
            } else if (jComboBoxhepatiteBContro.getSelectedItem().equals("Não")) {
                qtdHepatiteB = 0;
                objPerfilInter.setQtdHepatiteB(qtdHepatiteB);
            }
            if (jComboBoxHepatiteCcurada.getSelectedItem().equals("Sim")) {
                qtdHepatiteC = 1;
                objPerfilInter.setQtdHepatiteC(qtdHepatiteC);
            } else if (jComboBoxHepatiteCcurada.getSelectedItem().equals("Não")) {
                qtdHepatiteC = 0;
                objPerfilInter.setQtdHepatiteC(qtdHepatiteC);
            }
            if (jComboBoxDST.getSelectedItem().equals("Sim")) {
                qtdDst = 1;
                objPerfilInter.setQdtDst(qtdDst);
            } else if (jComboBoxDST.getSelectedItem().equals("Não")) {
                qtdDst = 0;
                objPerfilInter.setQdtDst(qtdDst);
            }
            if (jComboBoxVacina.getSelectedItem().equals("Sim")) {
                qtdVacina = 1;
                objPerfilInter.setQtdVacina(qtdVacina);
            } else if (jComboBoxVacina.getSelectedItem().equals("Não")) {
                qtdVacina = 0;
                objPerfilInter.setQtdVacina(qtdVacina);
            }
            if (jComboBoxVDRL.getSelectedItem().equals("Reagente")) {
                qtdVdlr = 1;
                objPerfilInter.setQtdVdlr(qtdVdlr);
            } else if (jComboBoxVDRL.getSelectedItem().equals("Não Reagente")) {
                qtdVdlr = 0;
                objPerfilInter.setQtdVdlr(qtdVdlr);
            }
            if (acao == 3) {
                objPerfilInter.setUsuarioInsert(nameUser);
                objPerfilInter.setDataInsert(dataModFinal);
                objPerfilInter.setHorarioInsert(horaMov);
                //
                controle.incluirIndicadorAcompanhamentoEnfermaria(objPerfilInter);
                buscarCodigoEnfermaria();
                //
                objLog2();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                bloquearCampos();
                bloquearBotoes();
                SalvarEnfermaria();
                zerarVariaveis();
                preencherTabelaEnfermaria("SELECT * FROM INDICADOR_ACOMPANHAMENTO_INTERNO_ENFERMARIA "
                        + "WHERE IdIndAco='" + jIdPerfil.getText() + "'");
                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
            }
            if (acao == 4) {
                objPerfilInter.setUsuarioUp(nameUser);
                objPerfilInter.setDataUp(dataModFinal);
                objPerfilInter.setHorarioUp(horaMov);
                //
                objPerfilInter.setIdEnf(codigoEnf);
                objPerfilInter.setIdIndAco(Integer.valueOf(jIdPerfil.getText()));
                controle.alterarIndicadorAcompanhamentoEnfermaria(objPerfilInter);
                //
                objLog2();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                bloquearCampos();
                bloquearBotoes();
                SalvarEnfermaria();
                zerarVariaveis();
                preencherTabelaEnfermaria("SELECT * FROM INDICADOR_ACOMPANHAMENTO_INTERNO_ENFERMARIA "
                        + "WHERE IdIndAco='" + jIdPerfil.getText() + "'");
                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtSalvarEnfermariaActionPerformed

    private void jBtCancelarEnfermariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarEnfermariaActionPerformed
        // TODO add your handling code here:
        bloquearCampos();
        bloquearBotoes();
        CancelarEnfermaria();
    }//GEN-LAST:event_jBtCancelarEnfermariaActionPerformed

    private void jBtSairEnfermariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairEnfermariaActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairEnfermariaActionPerformed

    private void jBtAuditoriaEnfermariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaEnfermariaActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaItensPerfilCarcerarioEnf objAudiItensPerfilCarEnf = new TelaAuditoriaItensPerfilCarcerarioEnf();
        TelaModuloEnfermaria.jPainelMedico.add(objAudiItensPerfilCarEnf);
        objAudiItensPerfilCarEnf.show();
    }//GEN-LAST:event_jBtAuditoriaEnfermariaActionPerformed

    private void jBtNovoPedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoPedaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaIndAcompanhaAbaP);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaIndAcompanhaAbaP) && codIncluirENF == 1) {
            objPerfilInter.setStatusPerfil(jStatusPerfil.getText());
            if (jStatusPerfil.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 5;
                bloquearCampos();
                bloquearBotoes();
                NovoPedagogia();
                statusMov = "Incluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovoPedaActionPerformed

    private void jBtAlterarPedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarPedaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaIndAcompanhaAbaP);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaIndAcompanhaAbaP) && codAlterarENF == 1) {
            objPerfilInter.setStatusPerfil(jStatusPerfil.getText());
            if (jStatusPerfil.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 6;
                bloquearCampos();
                bloquearBotoes();
                AlterarPedagogia();
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtAlterarPedaActionPerformed

    private void jBtExcluirPedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirPedaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaIndAcompanhaAbaP);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaIndAcompanhaAbaP) && codExcluirENF == 1) {
            objPerfilInter.setStatusPerfil(jStatusPerfil.getText());
            if (jStatusPerfil.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser excluído, o mesmo encontra-se FINALIZADO");
            } else {
                statusMov = "Excluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    bloquearCampos();
                    bloquearBotoes();
                    objPerfilInter.setIdPedago(codigoPeda);
                    objPerfilInter.setIdIndAco(Integer.valueOf(jIdPerfil.getText()));
                    controlPeda.excluirIndicadorAcompanhamentoPedagogia(objPerfilInter);
                    ExcluirPedagogia();
                    preencherTabelaPedagogia("SELECT * FROM INDICADOR_ACOMPANHAMENTO_INTERNO_PEDAGOGIA "
                            + "WHERE IdIndAco='" + jIdPerfil.getText() + "'");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirPedaActionPerformed

    private void jBtSalvarPedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarPedaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaIndAcompanhaAbaP);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaIndAcompanhaAbaP) && codGravarENF == 1) {
            objPerfilInter.setIdIndAco(Integer.valueOf(jIdPerfil.getText()));
            objPerfilInter.setIdInternoCrc(Integer.valueOf(jIdInternoPerfil.getText()));
            objPerfilInter.setNomeInternoPerfil(jNomeInternoPerfil.getText());
            objPerfilInter.setiCAA((String) jComboBoxICAA.getSelectedItem());
            objPerfilInter.setiC1((String) jComboBoxIC1.getSelectedItem());
            objPerfilInter.setiC2P((String) jComboBoxIC2P.getSelectedItem());
            objPerfilInter.setiAAU((String) jComboBoxIAAU.getSelectedItem());
            objPerfilInter.setiC3((String) jComboBoxIC3.getSelectedItem());
            objPerfilInter.setiREL((String) jComboBoxIREL.getSelectedItem());
            objPerfilInter.setiAC((String) jComboBoxIAC.getSelectedItem());
            objPerfilInter.setiCU1((String) jComboBoxICU1.getSelectedItem());
            objPerfilInter.setiC2((String) jComboBoxIC2.getSelectedItem());
            objPerfilInter.setiCA((String) jComboBoxICA.getSelectedItem());
            objPerfilInter.setDataPeda(jDataPeda.getDate());
            objPerfilInter.setObservacaoPeda(jObservacaoPeda.getText());
            //
            if (jComboBoxICAA.getSelectedItem().equals("Sim")) {
                qICAA = 1;
                objPerfilInter.setQtdICAA(qICAA);
            } else if (jComboBoxICAA.getSelectedItem().equals("Não")) {
                qICAA = 0;
                objPerfilInter.setQtdICAA(qICAA);
            }
            if (jComboBoxIC1.getSelectedItem().equals("Sim")) {
                qIC1 = 1;
                objPerfilInter.setQtdIC1(qIC1);
            } else if (jComboBoxIC1.getSelectedItem().equals("Não")) {
                qIC1 = 0;
                objPerfilInter.setQtdIC1(qIC1);
            }
            if (jComboBoxIC2P.getSelectedItem().equals("Sim")) {
                qIC2P = 1;
                objPerfilInter.setQtdIC2P(qIC2P);
            } else if (jComboBoxIC2P.getSelectedItem().equals("Não")) {
                qIC2P = 0;
                objPerfilInter.setQtdIC2P(qIC2P);
            }
            if (jComboBoxIAAU.getSelectedItem().equals("Sim")) {
                qIAAU = 1;
                objPerfilInter.setQtdIAAU(qIAAU);
            } else if (jComboBoxIAAU.getSelectedItem().equals("Não")) {
                qIAAU = 0;
                objPerfilInter.setQtdIAAU(qIAAU);
            }
            if (jComboBoxIC3.getSelectedItem().equals("Sim")) {
                qIC3 = 1;
                objPerfilInter.setQtdIC3(qIC3);
            } else if (jComboBoxIC3.getSelectedItem().equals("Não")) {
                qIC3 = 0;
                objPerfilInter.setQtdIC3(qIC3);
            }
            if (jComboBoxIREL.getSelectedItem().equals("Sim")) {
                qIREL = 1;
                objPerfilInter.setQtdIREL(qIREL);
            } else if (jComboBoxIREL.getSelectedItem().equals("Não")) {
                qIREL = 0;
                objPerfilInter.setQtdIREL(qIREL);
            }
            if (jComboBoxIAC.getSelectedItem().equals("Sim")) {
                qIAC = 1;
                objPerfilInter.setQtdIAC(qIAC);
            } else if (jComboBoxIAC.getSelectedItem().equals("Não")) {
                qIAC = 0;
                objPerfilInter.setQtdIAC(qIAC);
            }
            if (jComboBoxICU1.getSelectedItem().equals("Sim")) {
                qICU1 = 1;
                objPerfilInter.setQtdICU1(qICU1);
            } else if (jComboBoxICU1.getSelectedItem().equals("Não")) {
                qICU1 = 0;
                objPerfilInter.setQtdICU1(qICU1);
            }
            if (jComboBoxIC2.getSelectedItem().equals("Sim")) {
                qIC2 = 1;
                objPerfilInter.setQtdIC2(qIC2);
            } else if (jComboBoxIC2.getSelectedItem().equals("Não")) {
                qIC2 = 0;
                objPerfilInter.setQtdIC2(qIC2);
            }
            if (jComboBoxICA.getSelectedItem().equals("Sim")) {
                qICA = 1;
                objPerfilInter.setQtdICA(qICA);
            } else if (jComboBoxICA.getSelectedItem().equals("Não")) {
                qICA = 0;
                objPerfilInter.setQtdICA(qICA);
            }
            if (acao == 5) {
                objPerfilInter.setUsuarioInsert(nameUser);
                objPerfilInter.setDataInsert(dataModFinal);
                objPerfilInter.setHorarioInsert(horaMov);
                //
                controlPeda.incluirIndicadorAcompanhamentoPedagogia(objPerfilInter);
                buscarCodigoPedagogia();
                //
                objLog2();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                bloquearCampos();
                bloquearBotoes();
                SalvarPedagogia();
                zerarVariaveis();
                preencherTabelaPedagogia("SELECT * FROM INDICADOR_ACOMPANHAMENTO_INTERNO_PEDAGOGIA "
                        + "WHERE IdIndAco='" + jIdPerfil.getText() + "'");
                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
            }
            if (acao == 6) {
                objPerfilInter.setUsuarioUp(nameUser);
                objPerfilInter.setDataUp(dataModFinal);
                objPerfilInter.setHorarioUp(horaMov);
                //
                objPerfilInter.setIdPedago(codigoPeda);
                objPerfilInter.setIdIndAco(Integer.valueOf(jIdPerfil.getText()));
                controlPeda.alterarIndicadorAcompanhamentoPedagogia(objPerfilInter);
                //
                objLog2();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                bloquearCampos();
                bloquearBotoes();
                SalvarPedagogia();
                zerarVariaveis();
                preencherTabelaPedagogia("SELECT * FROM INDICADOR_ACOMPANHAMENTO_INTERNO_PEDAGOGIA "
                        + "WHERE IdIndAco='" + jIdPerfil.getText() + "'");
                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtSalvarPedaActionPerformed

    private void jBtCancelarPedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarPedaActionPerformed
        // TODO add your handling code here:
        bloquearCampos();
        bloquearBotoes();
        CancelarPedagogia();
    }//GEN-LAST:event_jBtCancelarPedaActionPerformed

    private void jBtSairPedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairPedaActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairPedaActionPerformed

    private void jBtAuditoriaPedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaPedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtAuditoriaPedaActionPerformed

    private void jBtNovoCrcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoCrcActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaIndAcompanhaAbaC);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaIndAcompanhaAbaC) && codIncluirENF == 1) {
            objPerfilInter.setStatusPerfil(jStatusPerfil.getText());
            if (jStatusPerfil.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 7;
                bloquearCampos();
                bloquearBotoes();
                NovoCrc();
                statusMov = "Incluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovoCrcActionPerformed

    private void jBtAlterarCrcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarCrcActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaIndAcompanhaAbaC);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaIndAcompanhaAbaC) && codAlterarENF == 1) {
            objPerfilInter.setStatusPerfil(jStatusPerfil.getText());
            if (jStatusPerfil.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 8;
                bloquearCampos();
                bloquearBotoes();
                AlterarCrc();
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtAlterarCrcActionPerformed

    private void jBtExcluirCrcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirCrcActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaIndAcompanhaAbaC);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaIndAcompanhaAbaC) && codExcluirENF == 1) {
            objPerfilInter.setStatusPerfil(jStatusPerfil.getText());
            if (jStatusPerfil.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser excluído, o mesmo encontra-se FINALIZADO");
            } else {
                statusMov = "Excluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    bloquearCampos();
                    bloquearBotoes();
                    objPerfilInter.setIdJurCrc(codigoCrc);
                    objPerfilInter.setIdIndAco(Integer.valueOf(jIdPerfil.getText()));
                    controlCrc.excluirIndicadorAcompanhamentoCrc(objPerfilInter);
                    ExcluirCrc();
                    preencherTabelaCrc("SELECT * FROM INDICADOR_ACOMPANHAMENTO_INTERNO_JURIDICO_CRC "
                            + "WHERE IdIndAco='" + jIdPerfil.getText() + "'");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirCrcActionPerformed

    private void jBtSalvarCrcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarCrcActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaIndAcompanhaAbaC);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaIndAcompanhaAbaC) && codGravarENF == 1) {
            objPerfilInter.setIdIndAco(Integer.valueOf(jIdPerfil.getText()));
            objPerfilInter.setIdInternoCrc(Integer.valueOf(jIdInternoPerfil.getText()));
            objPerfilInter.setNomeInternoPerfil(jNomeInternoPerfil.getText());
            objPerfilInter.setProcessos((String) jComboBoxProcessoAcomp.getSelectedItem());
            objPerfilInter.setProgressao((String) jComboBoxProgressaoRegime.getSelectedItem());
            objPerfilInter.setDocumentacao((String) jComboBoxDocumentacao.getSelectedItem());
            objPerfilInter.setLivramento((String) jComboBoxLivramentoCond.getSelectedItem());
            objPerfilInter.setDataJurCrc(jDataCrc.getDate());
            objPerfilInter.setiREL((String) jObservacaoCrc.getText());
            if (jComboBoxProcessoAcomp.getSelectedItem().equals("Sim")) {
                qtdProcessos = 1;
                objPerfilInter.setQtdProgresso(qtdProcessos);
            } else if (jComboBoxProcessoAcomp.getSelectedItem().equals("Não")) {
                qtdProcessos = 0;
                objPerfilInter.setQtdProgresso(qtdProcessos);
            }
            if (jComboBoxProgressaoRegime.getSelectedItem().equals("Sim")) {
                qtdProggressao = 1;
                objPerfilInter.setQtdProgressao(qtdProggressao);
            } else if (jComboBoxProgressaoRegime.getSelectedItem().equals("Não")) {
                qtdProggressao = 0;
                objPerfilInter.setQtdProgressao(qtdProggressao);
            }
            if (jComboBoxDocumentacao.getSelectedItem().equals("Sim")) {
                qtdDocumentacao = 1;
                objPerfilInter.setQtdDocumentacao(qtdDocumentacao);
            } else if (jComboBoxDocumentacao.getSelectedItem().equals("Não")) {
                qtdDocumentacao = 0;
                objPerfilInter.setQtdDocumentacao(qtdDocumentacao);
            }
            if (jComboBoxLivramentoCond.getSelectedItem().equals("Sim")) {
                qtdLivramento = 1;
                objPerfilInter.setQtdLivramento(qtdLivramento);
            } else if (jComboBoxLivramentoCond.getSelectedItem().equals("Não")) {
                qtdLivramento = 0;
                objPerfilInter.setQtdLivramento(qtdLivramento);
            }
            if (acao == 7) {
                objPerfilInter.setUsuarioInsert(nameUser);
                objPerfilInter.setDataInsert(dataModFinal);
                objPerfilInter.setHorarioInsert(horaMov);
                //
                controlCrc.incluirIndicadorAcompanhamentoCrc(objPerfilInter);
                buscarCodigoCrc();
                //
                objLog2();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                bloquearCampos();
                bloquearBotoes();
                SalvarCrc();
                zerarVariaveis();
                preencherTabelaCrc("SELECT * FROM INDICADOR_ACOMPANHAMENTO_INTERNO_JURIDICO_CRC "
                        + "WHERE IdIndAco='" + jIdPerfil.getText() + "'");
                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
            }
            if (acao == 8) {
                objPerfilInter.setUsuarioUp(nameUser);
                objPerfilInter.setDataUp(dataModFinal);
                objPerfilInter.setHorarioUp(horaMov);
                //
                objPerfilInter.setIdPedago(codigoPeda);
                objPerfilInter.setIdIndAco(Integer.valueOf(jIdPerfil.getText()));
                controlCrc.alterarIndicadorAcompanhamentoCrc(objPerfilInter);
                //
                objLog2();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                bloquearCampos();
                bloquearBotoes();
                SalvarCrc();
                zerarVariaveis();
                preencherTabelaCrc("SELECT * FROM INDICADOR_ACOMPANHAMENTO_INTERNO_JURIDICO_CRC "
                        + "WHERE IdIndAco='" + jIdPerfil.getText() + "'");
                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtSalvarCrcActionPerformed

    private void jBtCancelarCrcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarCrcActionPerformed
        // TODO add your handling code here:
        bloquearCampos();
        bloquearBotoes();
        CancelarCrc();
    }//GEN-LAST:event_jBtCancelarCrcActionPerformed

    private void jBtSairCrcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairCrcActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairCrcActionPerformed

    private void jBtAuditoriaCrcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaCrcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtAuditoriaCrcActionPerformed

    private void jBtNovoTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoTOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtNovoTOActionPerformed

    private void jBtAlterarTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarTOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtAlterarTOActionPerformed

    private void jBtExcluirTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirTOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtExcluirTOActionPerformed

    private void jBtSalvarTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarTOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtSalvarTOActionPerformed

    private void jBtCancelarTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarTOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtCancelarTOActionPerformed

    private void jBtSairTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairTOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtSairTOActionPerformed

    private void jBtAuditoriaTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaTOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtAuditoriaTOActionPerformed

    private void jBtNovoPSIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoPSIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtNovoPSIActionPerformed

    private void jBtAlterarPSIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarPSIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtAlterarPSIActionPerformed

    private void jBtExcluirPSIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirPSIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtExcluirPSIActionPerformed

    private void jBtSalvarPSIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarPSIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtSalvarPSIActionPerformed

    private void jBtCancelarPSIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarPSIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtCancelarPSIActionPerformed

    private void jBtSairPSIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairPSIActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairPSIActionPerformed

    private void jBtAuditoriaPSIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaPSIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtAuditoriaPSIActionPerformed

    private void jBtNovoSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoSSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtNovoSSActionPerformed

    private void jBtAlterarSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarSSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtAlterarSSActionPerformed

    private void jBtExcluirSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirSSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtExcluirSSActionPerformed

    private void jBtSalvarSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarSSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtSalvarSSActionPerformed

    private void jBtCancelarSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarSSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtCancelarSSActionPerformed

    private void jBtSairSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairSSActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairSSActionPerformed

    private void jBtAuditoriaSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaSSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtAuditoriaSSActionPerformed

    private void jTabelaEnfermariaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaEnfermariaMouseClicked
        // TODO add your handling code here:       
        flag = 1;
        if (flag == 1) {
            String idEnf = "" + jTabelaEnfermaria.getValueAt(jTabelaEnfermaria.getSelectedRow(), 0);
            String idIndAco = "" + jTabelaEnfermaria.getValueAt(jTabelaEnfermaria.getSelectedRow(), 1);
            bloquearCampos();
            bloquearBotoes();
            //MANUTENÇÃO
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            //ENFERMAGEM
            jBtNovoEnfermaria.setEnabled(true);
            jBtAlterarEnfermaria.setEnabled(true);
            jBtExcluirEnfermaria.setEnabled(true);
            //PEDAGOGIA/CRC/TO/PSICOLOGIA/SERVIÇO SOCIAL
            jBtNovoPeda.setEnabled(true);
            jBtNovoCrc.setEnabled(true);
            jBtNovoTO.setEnabled(true);
            jBtNovoPSI.setEnabled(true);
            jBtNovoSS.setEnabled(true);
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM INDICADOR_ACOMPANHAMENTO_INTERNO_ENFERMARIA "
                        + "INNER JOIN INDICADOR_ACOMPANHAMENTO_INTERNO "
                        + "ON INDICADOR_ACOMPANHAMENTO_INTERNO_ENFERMARIA.IdIndAco=INDICADOR_ACOMPANHAMENTO_INTERNO.IdIndAco "
                        + "WHERE INDICADOR_ACOMPANHAMENTO_INTERNO_ENFERMARIA.IdEnf='" + idEnf + "' "
                        + "AND INDICADOR_ACOMPANHAMENTO_INTERNO_ENFERMARIA.IdIndAco='" + idIndAco + "'");
                conecta.rs.first();
                codigoEnf = conecta.rs.getInt("IdEnf");
                jComboBoxDiabetes.setSelectedItem(conecta.rs.getString("Diabetes"));
                jComboBoxDiabetesCont.setSelectedItem(conecta.rs.getString("DiabControl"));
                jComboBoxHipertensao.setSelectedItem(conecta.rs.getString("Hipertensao"));
                jComboBoxHipertensaoCont.setSelectedItem(conecta.rs.getString("HiperControl"));
                jComboBoxEscabiose.setSelectedItem(conecta.rs.getString("Escabiose"));
                jComboBoxEscabioseCont.setSelectedItem(conecta.rs.getString("EscabioseCura"));
                jComboBoxHanseniase.setSelectedItem(conecta.rs.getString("Hanseniase"));
                jComboBoxHanseniaseCont.setSelectedItem(conecta.rs.getString("HanseniaseCura"));
                jComboBoxSifilis.setSelectedItem(conecta.rs.getString("Sifilis"));
                jComboBoxSifilisCont.setSelectedItem(conecta.rs.getString("SifilisCura"));
                jComboBoxTuberculose.setSelectedItem(conecta.rs.getString("Tuberculose"));
                jComboBoxTuberculoseCont.setSelectedItem(conecta.rs.getString("TuberculoseCura"));
                jComboBoxHIV.setSelectedItem(conecta.rs.getString("Hiv"));
                jComboBoxHIVCont.setSelectedItem(conecta.rs.getString("HivControlada"));
                jComboBoxHepatiteB.setSelectedItem(conecta.rs.getString("HepatiteB"));
                jComboBoxhepatiteBContro.setSelectedItem(conecta.rs.getString("HepatiteBCont"));
                jComboBoxHepatiteC.setSelectedItem(conecta.rs.getString("HepatiteC"));
                jComboBoxHepatiteCcurada.setSelectedItem(conecta.rs.getString("HepatiteCCont"));
                jComboBoxDST.setSelectedItem(conecta.rs.getString("Dst"));
                jComboBoxVDRL.setSelectedItem(conecta.rs.getString("Vdlr"));
                jComboBoxVacina.setSelectedItem(conecta.rs.getString("Vacina"));
                jDataRegEnfermaria.setDate(conecta.rs.getDate("DataReg"));
                jObservacaoEnfermaria.setText(conecta.rs.getString("Observacao"));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "Não foi possível realizar a pesquisa.\nERROR: " + e);
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaEnfermariaMouseClicked

    private void jComboBoxDSTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDSTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxDSTActionPerformed

    private void jComboBoxDiabetesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxDiabetesItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == evt.SELECTED && jComboBoxDiabetes.getSelectedItem().equals("Sim")) {
            jComboBoxDiabetesCont.setSelectedItem("Sim");
        } else if (evt.getStateChange() == evt.SELECTED && jComboBoxDiabetes.getSelectedItem().equals("Não")) {
            jComboBoxDiabetesCont.setSelectedItem("Não");
        }
    }//GEN-LAST:event_jComboBoxDiabetesItemStateChanged

    private void jComboBoxDiabetesContItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxDiabetesContItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == evt.SELECTED && jComboBoxDiabetesCont.getSelectedItem().equals("Sim")) {
            jComboBoxDiabetes.setSelectedItem("Sim");
        } else if (evt.getStateChange() == evt.SELECTED && jComboBoxDiabetesCont.getSelectedItem().equals("Não")) {
            jComboBoxDiabetes.setSelectedItem("Não");
        }
    }//GEN-LAST:event_jComboBoxDiabetesContItemStateChanged

    private void jComboBoxHipertensaoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxHipertensaoItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == evt.SELECTED && jComboBoxHipertensao.getSelectedItem().equals("Sim")) {
            jComboBoxHipertensaoCont.setSelectedItem("Sim");
        } else if (evt.getStateChange() == evt.SELECTED && jComboBoxHipertensao.getSelectedItem().equals("Não")) {
            jComboBoxHipertensaoCont.setSelectedItem("Não");
        }
    }//GEN-LAST:event_jComboBoxHipertensaoItemStateChanged

    private void jComboBoxHipertensaoContItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxHipertensaoContItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == evt.SELECTED && jComboBoxHipertensaoCont.getSelectedItem().equals("Sim")) {
            jComboBoxHipertensao.setSelectedItem("Sim");
        } else if (evt.getStateChange() == evt.SELECTED && jComboBoxHipertensaoCont.getSelectedItem().equals("Não")) {
            jComboBoxHipertensao.setSelectedItem("Não");
        }
    }//GEN-LAST:event_jComboBoxHipertensaoContItemStateChanged

    private void jComboBoxHIVItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxHIVItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == evt.SELECTED && jComboBoxHIV.getSelectedItem().equals("Reagente")) {
            jComboBoxHIVCont.setSelectedItem("Sim");
        } else if (evt.getStateChange() == evt.SELECTED && jComboBoxHIV.getSelectedItem().equals("Não Reagente")) {
            jComboBoxHIVCont.setSelectedItem("Não");
        }
    }//GEN-LAST:event_jComboBoxHIVItemStateChanged

    private void jComboBoxHIVContItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxHIVContItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == evt.SELECTED && jComboBoxHIVCont.getSelectedItem().equals("Sim")) {
            jComboBoxHIV.setSelectedItem("Reagente");
        } else if (evt.getStateChange() == evt.SELECTED && jComboBoxHIVCont.getSelectedItem().equals("Não")) {
            jComboBoxHIV.setSelectedItem("Não Reagente");
        }
    }//GEN-LAST:event_jComboBoxHIVContItemStateChanged

    private void jComboBoxHepatiteBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxHepatiteBItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == evt.SELECTED && jComboBoxHepatiteB.getSelectedItem().equals("Reagente")) {
            jComboBoxhepatiteBContro.setSelectedItem("Sim");
        } else if (evt.getStateChange() == evt.SELECTED && jComboBoxHepatiteB.getSelectedItem().equals("Não Reagente")) {
            jComboBoxhepatiteBContro.setSelectedItem("Não");
        }
    }//GEN-LAST:event_jComboBoxHepatiteBItemStateChanged

    private void jComboBoxhepatiteBControItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxhepatiteBControItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == evt.SELECTED && jComboBoxhepatiteBContro.getSelectedItem().equals("Sim")) {
            jComboBoxHepatiteB.setSelectedItem("Reagente");
        } else if (evt.getStateChange() == evt.SELECTED && jComboBoxhepatiteBContro.getSelectedItem().equals("Não")) {
            jComboBoxHepatiteB.setSelectedItem("Não Reagente");
        }
    }//GEN-LAST:event_jComboBoxhepatiteBControItemStateChanged

    private void jComboBoxHepatiteCItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxHepatiteCItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == evt.SELECTED && jComboBoxHepatiteC.getSelectedItem().equals("Reagente")) {
            jComboBoxHepatiteCcurada.setSelectedItem("Sim");
        } else if (evt.getStateChange() == evt.SELECTED && jComboBoxHepatiteC.getSelectedItem().equals("Não Reagente")) {
            jComboBoxHepatiteCcurada.setSelectedItem("Não");
        }
    }//GEN-LAST:event_jComboBoxHepatiteCItemStateChanged

    private void jComboBoxHepatiteCcuradaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxHepatiteCcuradaItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == evt.SELECTED && jComboBoxHepatiteCcurada.getSelectedItem().equals("Sim")) {
            jComboBoxHepatiteC.setSelectedItem("Reagente");
        } else if (evt.getStateChange() == evt.SELECTED && jComboBoxHepatiteCcurada.getSelectedItem().equals("Não")) {
            jComboBoxHepatiteC.setSelectedItem("Não Reagente");
        }
    }//GEN-LAST:event_jComboBoxHepatiteCcuradaItemStateChanged

    private void jTabelaPedagogiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaPedagogiaMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String idPeda = "" + jTabelaPedagogia.getValueAt(jTabelaPedagogia.getSelectedRow(), 0);
            String idIndAcoPeda = "" + jTabelaPedagogia.getValueAt(jTabelaPedagogia.getSelectedRow(), 1);
            bloquearCampos();
            bloquearBotoes();
            //MANUTENÇÃO
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            //PEDAGOGIA
            jBtNovoPeda.setEnabled(true);
            jBtAlterarPeda.setEnabled(true);
            jBtExcluirPeda.setEnabled(true);
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM INDICADOR_ACOMPANHAMENTO_INTERNO_PEDAGOGIA "
                        + "INNER JOIN INDICADOR_ACOMPANHAMENTO_INTERNO "
                        + "ON INDICADOR_ACOMPANHAMENTO_INTERNO_PEDAGOGIA.IdIndAco=INDICADOR_ACOMPANHAMENTO_INTERNO.IdIndAco "
                        + "WHERE INDICADOR_ACOMPANHAMENTO_INTERNO_PEDAGOGIA.IdPedago='" + idPeda + "' "
                        + "AND INDICADOR_ACOMPANHAMENTO_INTERNO_PEDAGOGIA.IdIndAco='" + idIndAcoPeda + "'");
                conecta.rs.first();
                codigoPeda = conecta.rs.getInt("IdPedago");
                jComboBoxICAA.setSelectedItem(conecta.rs.getString("ICAA"));
                jComboBoxIC1.setSelectedItem(conecta.rs.getString("IC1"));
                jComboBoxIC2P.setSelectedItem(conecta.rs.getString("IC2P"));
                jComboBoxIAAU.setSelectedItem(conecta.rs.getString("IAAU"));
                jComboBoxIC3.setSelectedItem(conecta.rs.getString("IC3"));
                jComboBoxIREL.setSelectedItem(conecta.rs.getString("IREL"));
                jComboBoxIAC.setSelectedItem(conecta.rs.getString("IAC"));
                jComboBoxICU1.setSelectedItem(conecta.rs.getString("ICU1"));
                jComboBoxIC2.setSelectedItem(conecta.rs.getString("IC2"));
                jComboBoxICA.setSelectedItem(conecta.rs.getString("ICA"));
                jDataPeda.setDate(conecta.rs.getDate("DataPeda"));
                jObservacaoPeda.setText(conecta.rs.getString("Observacao"));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "Não foi possível realizar a pesquisa.\nERROR: " + e);
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaPedagogiaMouseClicked

    private void jTabelaCrcJuridicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaCrcJuridicoMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String idCrc = "" + jTabelaCrcJuridico.getValueAt(jTabelaCrcJuridico.getSelectedRow(), 0);
            String idIndAcoCrc = "" + jTabelaCrcJuridico.getValueAt(jTabelaCrcJuridico.getSelectedRow(), 1);
            bloquearCampos();
            bloquearBotoes();
            //MANUTENÇÃO
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            //PEDAGOGIA
            jBtNovoCrc.setEnabled(true);
            jBtAlterarCrc.setEnabled(true);
            jBtExcluirCrc.setEnabled(true);
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM INDICADOR_ACOMPANHAMENTO_INTERNO_JURIDICO_CRC "
                        + "INNER JOIN INDICADOR_ACOMPANHAMENTO_INTERNO "
                        + "ON INDICADOR_ACOMPANHAMENTO_INTERNO_JURIDICO_CRC.IdIndAco=INDICADOR_ACOMPANHAMENTO_INTERNO.IdIndAco "
                        + "WHERE INDICADOR_ACOMPANHAMENTO_INTERNO_JURIDICO_CRC.IdJurCrc='" + idCrc + "' "
                        + "AND INDICADOR_ACOMPANHAMENTO_INTERNO_JURIDICO_CRC.IdIndAco='" + idIndAcoCrc + "'");
                conecta.rs.first();
                codigoCrc = conecta.rs.getInt("IdJurCrc");
                jComboBoxProcessoAcomp.setSelectedItem(conecta.rs.getString("Processos"));
                jComboBoxDocumentacao.setSelectedItem(conecta.rs.getString("Documentacao"));
                jComboBoxProgressaoRegime.setSelectedItem(conecta.rs.getString("Progressao"));
                jComboBoxLivramentoCond.setSelectedItem(conecta.rs.getString("Livramento"));
                jDataCrc.setDate(conecta.rs.getDate("DataJurCrc"));
                jObservacaoCrc.setText(conecta.rs.getString("Observacao"));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "Não foi possível realizar a pesquisa.\nERROR: " + e);
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaCrcJuridicoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JYearChooser jAnoNascimento;
    private com.toedter.calendar.JYearChooser jAnoReferencia;
    public static javax.swing.JTextField jBairroInternoPerfil;
    private javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtAlterarCrc;
    private javax.swing.JButton jBtAlterarEnfermaria;
    private javax.swing.JButton jBtAlterarPSI;
    private javax.swing.JButton jBtAlterarPeda;
    private javax.swing.JButton jBtAlterarSS;
    private javax.swing.JButton jBtAlterarTO;
    private javax.swing.JButton jBtAuditoria;
    private javax.swing.JButton jBtAuditoriaCrc;
    private javax.swing.JButton jBtAuditoriaEnfermaria;
    private javax.swing.JButton jBtAuditoriaPSI;
    private javax.swing.JButton jBtAuditoriaPeda;
    private javax.swing.JButton jBtAuditoriaSS;
    private javax.swing.JButton jBtAuditoriaTO;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtCancelarCrc;
    private javax.swing.JButton jBtCancelarEnfermaria;
    private javax.swing.JButton jBtCancelarPSI;
    private javax.swing.JButton jBtCancelarPeda;
    private javax.swing.JButton jBtCancelarSS;
    private javax.swing.JButton jBtCancelarTO;
    private javax.swing.JButton jBtExcluir;
    private javax.swing.JButton jBtExcluirCrc;
    private javax.swing.JButton jBtExcluirEnfermaria;
    private javax.swing.JButton jBtExcluirPSI;
    private javax.swing.JButton jBtExcluirPeda;
    private javax.swing.JButton jBtExcluirSS;
    private javax.swing.JButton jBtExcluirTO;
    private javax.swing.JButton jBtFinalizar;
    private javax.swing.JButton jBtNovo;
    private javax.swing.JButton jBtNovoCrc;
    private javax.swing.JButton jBtNovoEnfermaria;
    private javax.swing.JButton jBtNovoPSI;
    private javax.swing.JButton jBtNovoPeda;
    private javax.swing.JButton jBtNovoSS;
    private javax.swing.JButton jBtNovoTO;
    private javax.swing.JButton jBtPesqCodigo;
    private javax.swing.JButton jBtPesqDataPAI;
    private javax.swing.JButton jBtPesqNomeInternoPAI;
    private javax.swing.JButton jBtPesquisaInternoPerfil;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSairCrc;
    private javax.swing.JButton jBtSairEnfermaria;
    private javax.swing.JButton jBtSairPSI;
    private javax.swing.JButton jBtSairPeda;
    private javax.swing.JButton jBtSairSS;
    private javax.swing.JButton jBtSairTO;
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JButton jBtSalvarCrc;
    private javax.swing.JButton jBtSalvarEnfermaria;
    private javax.swing.JButton jBtSalvarPSI;
    private javax.swing.JButton jBtSalvarPeda;
    private javax.swing.JButton jBtSalvarSS;
    private javax.swing.JButton jBtSalvarTO;
    public static javax.swing.JTextField jCelaInternoPerfil;
    private javax.swing.JCheckBox jCheckBoxTodosRegistros;
    public static javax.swing.JTextField jCidadeInternoPerfil;
    private javax.swing.JTextField jCodigoPesqPAI;
    private javax.swing.JComboBox<String> jComboBoxAcompanhaSS;
    private javax.swing.JComboBox<String> jComboBoxAcompanhamentoPSI;
    private javax.swing.JComboBox<String> jComboBoxConcluiuFP;
    private javax.swing.JComboBox jComboBoxDST;
    private javax.swing.JComboBox jComboBoxDiabetes;
    private javax.swing.JComboBox jComboBoxDiabetesCont;
    private javax.swing.JComboBox<String> jComboBoxDocumentacao;
    private javax.swing.JComboBox jComboBoxEscabiose;
    private javax.swing.JComboBox jComboBoxEscabioseCont;
    private javax.swing.JComboBox jComboBoxHIV;
    private javax.swing.JComboBox jComboBoxHIVCont;
    private javax.swing.JComboBox jComboBoxHanseniase;
    private javax.swing.JComboBox jComboBoxHanseniaseCont;
    private javax.swing.JComboBox jComboBoxHepatiteB;
    private javax.swing.JComboBox jComboBoxHepatiteC;
    private javax.swing.JComboBox jComboBoxHepatiteCcurada;
    private javax.swing.JComboBox jComboBoxHipertensao;
    private javax.swing.JComboBox jComboBoxHipertensaoCont;
    private javax.swing.JComboBox<String> jComboBoxIAAU;
    private javax.swing.JComboBox<String> jComboBoxIAC;
    private javax.swing.JComboBox<String> jComboBoxIC1;
    private javax.swing.JComboBox<String> jComboBoxIC2;
    private javax.swing.JComboBox<String> jComboBoxIC2P;
    private javax.swing.JComboBox<String> jComboBoxIC3;
    private javax.swing.JComboBox<String> jComboBoxICA;
    private javax.swing.JComboBox<String> jComboBoxICAA;
    private javax.swing.JComboBox<String> jComboBoxICU1;
    private javax.swing.JComboBox<String> jComboBoxIREL;
    private javax.swing.JComboBox<String> jComboBoxLivramentoCond;
    private javax.swing.JComboBox<String> jComboBoxPassouCurso;
    private javax.swing.JComboBox<String> jComboBoxProcessoAcomp;
    private javax.swing.JComboBox<String> jComboBoxPrograma;
    private javax.swing.JComboBox<String> jComboBoxProgressaoRegime;
    private javax.swing.JComboBox<String> jComboBoxRecuparacaoPSI;
    private javax.swing.JComboBox jComboBoxSifilis;
    private javax.swing.JComboBox jComboBoxSifilisCont;
    private javax.swing.JComboBox<String> jComboBoxTratamentoPSI;
    private javax.swing.JComboBox jComboBoxTuberculose;
    private javax.swing.JComboBox jComboBoxTuberculoseCont;
    private javax.swing.JComboBox jComboBoxVDRL;
    private javax.swing.JComboBox jComboBoxVacina;
    private javax.swing.JComboBox jComboBoxhepatiteBContro;
    private com.toedter.calendar.JDateChooser jDataCrc;
    private com.toedter.calendar.JDateChooser jDataFinal;
    private com.toedter.calendar.JDateChooser jDataInicial;
    private com.toedter.calendar.JDateChooser jDataPSI;
    private com.toedter.calendar.JDateChooser jDataPeda;
    private com.toedter.calendar.JDateChooser jDataPerfil;
    private com.toedter.calendar.JDateChooser jDataRegEnfermaria;
    private com.toedter.calendar.JDateChooser jDataTO;
    public static javax.swing.JTextField jEtiniaInternoPerfil;
    public static javax.swing.JLabel jFotoInternoPerfil;
    public static javax.swing.JTextField jIdInternoPerfil;
    public static javax.swing.JTextField jIdPerfil;
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
    private com.toedter.calendar.JMonthChooser jMesReferencia;
    public static javax.swing.JTextField jNomeInternoPerfil;
    private javax.swing.JTextField jNomeInternoPesquisa;
    private javax.swing.JTextArea jObservaacaoSS;
    private javax.swing.JTextArea jObservacaoCrc;
    private javax.swing.JTextField jObservacaoEnfermaria;
    private javax.swing.JTextArea jObservacaoInternoPerfil;
    private javax.swing.JTextArea jObservacaoPSI;
    private javax.swing.JTextField jObservacaoPeda;
    private javax.swing.JTextArea jObservacaoTO;
    private javax.swing.JTextField jOpcaoSexual;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    public static javax.swing.JTextField jPavilhaoInternoPerfil;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    public static javax.swing.JTextField jSexo;
    private javax.swing.JTextField jStatusPerfil;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTabelaCrcJuridico;
    private javax.swing.JTable jTabelaEnfermaria;
    private javax.swing.JTable jTabelaPSI;
    private javax.swing.JTable jTabelaPedagogia;
    private javax.swing.JTable jTabelaPerfilCarcerario;
    private javax.swing.JTable jTabelaTO;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField36;
    private javax.swing.JTextField jTextField37;
    private javax.swing.JTextField jTextField38;
    private javax.swing.JTextField jTextField39;
    private javax.swing.JTextField jTextField40;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void formatarCampos() {
        // MANUTENÇÃO
        jObservacaoInternoPerfil.setLineWrap(true);
        jObservacaoInternoPerfil.setWrapStyleWord(true);
        // ENFERMARIA
//        jObservacaoEnfermaria.setLineWrap(true);
//        jObservacaoEnfermaria.setWrapStyleWord(true);
        //CRC/JURIDICO
        jObservacaoCrc.setLineWrap(true);
        jObservacaoCrc.setWrapStyleWord(true);
        //TO
        jObservacaoTO.setLineWrap(true);
        jObservacaoTO.setLineWrap(true);
        // PSICOLOGIA
        jObservacaoPSI.setLineWrap(true);
        jObservacaoPSI.setLineWrap(true);
        //SERVIÇO SOCIAL
        jObservaacaoSS.setLineWrap(true);
        jObservaacaoSS.setLineWrap(true);
    }

    public void corCampos() {
        jIdPerfil.setBackground(Color.white);
        jStatusPerfil.setBackground(Color.white);
        jDataPerfil.setBackground(Color.white);
        jIdInternoPerfil.setBackground(Color.white);
        jNomeInternoPerfil.setBackground(Color.white);
        jSexo.setBackground(Color.white);
        jOpcaoSexual.setBackground(Color.white);
        jAnoNascimento.setBackground(Color.white);
        jPavilhaoInternoPerfil.setBackground(Color.white);
        jCelaInternoPerfil.setBackground(Color.white);
        jEtiniaInternoPerfil.setBackground(Color.white);
        jCidadeInternoPerfil.setBackground(Color.white);
        jBairroInternoPerfil.setBackground(Color.white);
        jObservacaoInternoPerfil.setBackground(Color.white);
        // ENFERMARIA
        jObservacaoEnfermaria.setBackground(Color.white);
        //PEDAGOGIA
        jObservacaoPeda.setBackground(Color.white);
        //CRC/JURIDICO
        jObservacaoCrc.setBackground(Color.white);
        // TERAPIA OCUPACIONAL
        jObservacaoTO.setBackground(Color.white);
        //PSICOLOGIA
        jObservacaoPSI.setBackground(Color.white);
        // SERVIÇO SOCIAL
        jObservaacaoSS.setBackground(Color.white);
    }

    public void bloquearBotoes() {
        jBtPesquisaInternoPerfil.setEnabled(!true);
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        //ENFERMARIA
        jBtNovoEnfermaria.setEnabled(!true);
        jBtAlterarEnfermaria.setEnabled(!true);
        jBtExcluirEnfermaria.setEnabled(!true);
        jBtSalvarEnfermaria.setEnabled(!true);
        jBtCancelarEnfermaria.setEnabled(!true);
        jBtAuditoriaEnfermaria.setEnabled(!true);
        //PEDAGOGIA
        jBtNovoPeda.setEnabled(!true);
        jBtAlterarPeda.setEnabled(!true);
        jBtExcluirPeda.setEnabled(!true);
        jBtSalvarPeda.setEnabled(!true);
        jBtCancelarPeda.setEnabled(!true);
        jBtAuditoriaPeda.setEnabled(!true);
        //CRC/JURIDICO
        jBtNovoCrc.setEnabled(!true);
        jBtAlterarCrc.setEnabled(!true);
        jBtExcluirCrc.setEnabled(!true);
        jBtSalvarCrc.setEnabled(!true);
        jBtCancelarCrc.setEnabled(!true);
        jBtAuditoriaCrc.setEnabled(!true);
        //TERAPIA OCUPACIONAL
        jBtNovoTO.setEnabled(!true);
        jBtAlterarTO.setEnabled(!true);
        jBtExcluirTO.setEnabled(!true);
        jBtSalvarTO.setEnabled(!true);
        jBtCancelarTO.setEnabled(!true);
        jBtAuditoriaTO.setEnabled(!true);
        // PSICOLOGIA
        jBtNovoPSI.setEnabled(!true);
        jBtAlterarPSI.setEnabled(!true);
        jBtExcluirPSI.setEnabled(!true);
        jBtSalvarPSI.setEnabled(!true);
        jBtCancelarPSI.setEnabled(!true);
        jBtAuditoriaPSI.setEnabled(!true);
        //SERVIÇO SOCIAL
        jBtNovoSS.setEnabled(!true);
        jBtAlterarSS.setEnabled(!true);
        jBtExcluirSS.setEnabled(!true);
        jBtSalvarSS.setEnabled(!true);
        jBtCancelarSS.setEnabled(!true);
        jBtAuditoriaSS.setEnabled(!true);
    }

    public void bloquearCampos() {
        // MANUTENÇÃO
        jDataPerfil.setEnabled(!true);
        jOpcaoSexual.setEnabled(!true);
        jAnoNascimento.setEnabled(!true);
        jObservacaoInternoPerfil.setEnabled(!true);
        // ENFERMARIA
        jComboBoxDiabetes.setEnabled(!true);
        jComboBoxHipertensao.setEnabled(!true);
        jComboBoxEscabiose.setEnabled(!true);
        jComboBoxHanseniase.setEnabled(!true);
        jComboBoxSifilis.setEnabled(!true);
        jComboBoxTuberculose.setEnabled(!true);
        jComboBoxDiabetesCont.setEnabled(!true);
        jComboBoxHipertensaoCont.setEnabled(!true);
        jComboBoxEscabioseCont.setEnabled(!true);
        jComboBoxHanseniaseCont.setEnabled(!true);
        jComboBoxSifilisCont.setEnabled(!true);
        jComboBoxTuberculoseCont.setEnabled(!true);
        jComboBoxHIV.setEnabled(!true);
        jComboBoxHIVCont.setEnabled(!true);
        jComboBoxDST.setEnabled(!true);
        jComboBoxVDRL.setEnabled(!true);
        jComboBoxHepatiteB.setEnabled(!true);
        jComboBoxHepatiteC.setEnabled(!true);
        jDataRegEnfermaria.setEnabled(!true);
        jComboBoxVacina.setEnabled(!true);
        jComboBoxhepatiteBContro.setEnabled(!true);
        jComboBoxHepatiteCcurada.setEnabled(!true);
        jObservacaoEnfermaria.setEnabled(!true);
        //PEDAGOGIA
        jComboBoxICAA.setEnabled(!true);
        jComboBoxIC1.setEnabled(!true);
        jComboBoxIC2P.setEnabled(!true);
        jComboBoxIAAU.setEnabled(!true);
        jComboBoxIREL.setEnabled(!true);
        jComboBoxIC3.setEnabled(!true);
        jComboBoxIAC.setEnabled(!true);
        jComboBoxICU1.setEnabled(!true);
        jComboBoxIC2.setEnabled(!true);
        jComboBoxICA.setEnabled(!true);
        jDataPeda.setEnabled(!true);
        jObservacaoPeda.setEnabled(!true);
        //CRC/JURIDICO
        jComboBoxProcessoAcomp.setEnabled(!true);
        jComboBoxProgressaoRegime.setEnabled(!true);
        jComboBoxDocumentacao.setEnabled(!true);
        jComboBoxLivramentoCond.setEnabled(!true);
        jDataCrc.setEnabled(!true);
        jObservacaoCrc.setEnabled(!true);
        // TERAPIA OCUPACIONAL
        jComboBoxPrograma.setEnabled(!true);
        jComboBoxPassouCurso.setEnabled(!true);
        jComboBoxConcluiuFP.setEnabled(!true);
        jDataTO.setEnabled(!true);
        jObservacaoTO.setEnabled(!true);
        //PSICOLOGIA
        jComboBoxTratamentoPSI.setEnabled(!true);
        jComboBoxAcompanhamentoPSI.setEnabled(!true);
        jComboBoxRecuparacaoPSI.setEnabled(!true);
        jDataPSI.setEnabled(!true);
        jObservacaoPSI.setEnabled(!true);
        // SERVIÇO SOCIAL
        jComboBoxAcompanhaSS.setEnabled(!true);
        jObservaacaoSS.setEnabled(!true);
    }

    public void limparCamposNovo() {
        // MANUTENÇÃO
        jIdPerfil.setText("");
        jStatusPerfil.setText("");
        jDataPerfil.setDate(null);
        jIdInternoPerfil.setText("");
        jFotoInternoPerfil.setIcon(null);
        jNomeInternoPerfil.setText("");
        jPavilhaoInternoPerfil.setText("");
        jCelaInternoPerfil.setText("");
        jEtiniaInternoPerfil.setText("");
        jCidadeInternoPerfil.setText("");
        jBairroInternoPerfil.setText("");
        jObservacaoInternoPerfil.setText("");
        // ENFERMARIA
        jComboBoxDiabetes.setSelectedItem("Não");
        jComboBoxHipertensao.setSelectedItem("Não");
        jComboBoxEscabiose.setSelectedItem("Não");
        jComboBoxHanseniase.setSelectedItem("Não");
        jComboBoxSifilis.setSelectedItem("Não");
        jComboBoxTuberculose.setSelectedItem("Não");
        jComboBoxDiabetesCont.setSelectedItem("Não");
        jComboBoxHipertensaoCont.setSelectedItem("Não");
        jComboBoxEscabioseCont.setSelectedItem("Não");
        jComboBoxHanseniaseCont.setSelectedItem("Não");
        jComboBoxSifilisCont.setSelectedItem("Não");
        jComboBoxTuberculoseCont.setSelectedItem("Não");
        jComboBoxHIV.setSelectedItem("Não");
        jComboBoxHIVCont.setSelectedItem("Não");
        jComboBoxDST.setSelectedItem("Não");
        jComboBoxVDRL.setSelectedItem("Não Reagente");
        jComboBoxHepatiteB.setSelectedItem("Não");
        jComboBoxHepatiteC.setSelectedItem("Não");
        jDataRegEnfermaria.setDate(null);
        jComboBoxVacina.setSelectedItem("Não");
        jComboBoxhepatiteBContro.setSelectedItem("Não");
        jComboBoxHepatiteCcurada.setSelectedItem("Não");
        jObservacaoEnfermaria.setText("");
        //PEDAGOGIA
        jComboBoxICAA.setSelectedItem("Não");
        jComboBoxIC1.setSelectedItem("Não");
        jComboBoxIC2P.setSelectedItem("Não");
        jComboBoxIAAU.setSelectedItem("Não");
        jComboBoxIREL.setSelectedItem("Não");
        jComboBoxIC3.setSelectedItem("Não");
        jComboBoxIAC.setSelectedItem("Não");
        jComboBoxICU1.setSelectedItem("Não");
        jComboBoxIC2.setSelectedItem("Não");
        jComboBoxICA.setSelectedItem("Não");
        jDataPeda.setDate(null);
        jObservacaoPeda.setText("");
        //CRC/JURIDICO
        jComboBoxProcessoAcomp.setSelectedItem("Não");
        jComboBoxProgressaoRegime.setSelectedItem("Não");
        jComboBoxDocumentacao.setSelectedItem("Não");
        jComboBoxLivramentoCond.setSelectedItem("Não");
        jDataCrc.setDate(null);
        jObservacaoCrc.setText("");
        // TERAPIA OCUPACIONAL
        jComboBoxPrograma.setSelectedItem("Não");
        jComboBoxPassouCurso.setSelectedItem("Não");
        jComboBoxConcluiuFP.setSelectedItem("Não");
        jDataTO.setDate(null);
        jObservacaoTO.setText("");
        //PSICOLOGIA
        jComboBoxTratamentoPSI.setSelectedItem("Não");
        jComboBoxAcompanhamentoPSI.setSelectedItem("Não");
        jComboBoxRecuparacaoPSI.setSelectedItem("Não");
        jDataPSI.setDate(null);
        jObservacaoPSI.setText("");
        // SERVIÇO SOCIAL
        jComboBoxAcompanhaSS.setSelectedItem("Não");
        jObservaacaoSS.setText("");
    }

    public void Novo() {
        jIdPerfil.setText("");
        jStatusPerfil.setText("ABERTO");
        Calendar cal = GregorianCalendar.getInstance();
        jAnoReferencia.setValue(cal.get(Calendar.YEAR));
        jMesReferencia.setMonth(cal.get(Calendar.MONTH));
        jDataPerfil.setCalendar(Calendar.getInstance());
        //
        jDataPerfil.setEnabled(true);
        jOpcaoSexual.setEnabled(true);
        jAnoNascimento.setEnabled(true);
        jObservacaoInternoPerfil.setEnabled(true);
        //
        jBtPesquisaInternoPerfil.setEnabled(true);
        //        
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
    }

    public void Alterar() {
        jDataPerfil.setEnabled(true);
        jOpcaoSexual.setEnabled(true);
        jAnoNascimento.setEnabled(true);
        jObservacaoInternoPerfil.setEnabled(true);
        //
        jBtPesquisaInternoPerfil.setEnabled(true);
        //        
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
    }

    public void Excluir() {
        jBtNovo.setEnabled(true);
    }

    public void Salvar() {

        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        //
        jBtNovoEnfermaria.setEnabled(true);
        jBtNovoPeda.setEnabled(true);
        jBtNovoCrc.setEnabled(true);
        jBtNovoTO.setEnabled(true);
        jBtNovoPSI.setEnabled(true);
        jBtNovoSS.setEnabled(true);
    }

    public void Cancelar() {
        if (jIdPerfil.getText().equals("")) {
            limparCamposNovo();
            bloquearCampos();
            bloquearBotoes();
            jBtNovo.setEnabled(true);
        } else {
            bloquearCampos();
            bloquearBotoes();
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
        }
    }

    public void buscarCodigo() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM INDICADOR_ACOMPANHAMENTO_INTERNO");
            conecta.rs.last();
            jIdPerfil.setText(conecta.rs.getString("IdIndAco"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter o código do registro.");
        }
        conecta.desconecta();
    }

    public void NovoEnfermaria() {
        jComboBoxDiabetes.setSelectedItem("Não");
        jComboBoxHipertensao.setSelectedItem("Não");
        jComboBoxEscabiose.setSelectedItem("Não");
        jComboBoxHanseniase.setSelectedItem("Não");
        jComboBoxSifilis.setSelectedItem("Não");
        jComboBoxTuberculose.setSelectedItem("Não");
        jComboBoxDiabetesCont.setSelectedItem("Não");
        jComboBoxHipertensaoCont.setSelectedItem("Não");
        jComboBoxEscabioseCont.setSelectedItem("Não");
        jComboBoxHanseniaseCont.setSelectedItem("Não");
        jComboBoxSifilisCont.setSelectedItem("Não");
        jComboBoxTuberculoseCont.setSelectedItem("Não");
        jComboBoxHIV.setSelectedItem("Não");
        jComboBoxHepatiteB.setSelectedItem("Não");
        jComboBoxHepatiteC.setSelectedItem("Não");
        jDataRegEnfermaria.setDate(null);
        jObservacaoEnfermaria.setText("");
        //
        jComboBoxDiabetes.setEnabled(true);
        jComboBoxHipertensao.setEnabled(true);
        jComboBoxEscabiose.setEnabled(true);
        jComboBoxHanseniase.setEnabled(true);
        jComboBoxSifilis.setEnabled(true);
        jComboBoxTuberculose.setEnabled(true);
        jComboBoxDiabetesCont.setEnabled(true);
        jComboBoxHipertensaoCont.setEnabled(true);
        jComboBoxEscabioseCont.setEnabled(true);
        jComboBoxHanseniaseCont.setEnabled(true);
        jComboBoxSifilisCont.setEnabled(true);
        jComboBoxTuberculoseCont.setEnabled(true);
        jComboBoxHIV.setEnabled(true);
        jComboBoxHIVCont.setEnabled(true);
        jComboBoxDST.setEnabled(true);
        jComboBoxVDRL.setEnabled(true);
        jComboBoxHepatiteB.setEnabled(true);
        jComboBoxHepatiteC.setEnabled(true);
        jComboBoxVacina.setEnabled(true);
        jComboBoxhepatiteBContro.setEnabled(true);
        jComboBoxHepatiteCcurada.setEnabled(true);
        jObservacaoEnfermaria.setEnabled(true);
        //
        jDataRegEnfermaria.setEnabled(true);
        jDataRegEnfermaria.setCalendar(Calendar.getInstance());
        //
        jBtSalvarEnfermaria.setEnabled(true);
        jBtCancelarEnfermaria.setEnabled(true);
    }

    public void AlterarEnfermaria() {
        jComboBoxDiabetes.setEnabled(true);
        jComboBoxHipertensao.setEnabled(true);
        jComboBoxEscabiose.setEnabled(true);
        jComboBoxHanseniase.setEnabled(true);
        jComboBoxSifilis.setEnabled(true);
        jComboBoxTuberculose.setEnabled(true);
        jComboBoxDiabetesCont.setEnabled(true);
        jComboBoxHipertensaoCont.setEnabled(true);
        jComboBoxEscabioseCont.setEnabled(true);
        jComboBoxHanseniaseCont.setEnabled(true);
        jComboBoxSifilisCont.setEnabled(true);
        jComboBoxTuberculoseCont.setEnabled(true);
        jComboBoxHIV.setEnabled(true);
        jComboBoxHIVCont.setEnabled(true);
        jComboBoxDST.setEnabled(true);
        jComboBoxVDRL.setEnabled(true);
        jComboBoxHepatiteB.setEnabled(true);
        jComboBoxHepatiteC.setEnabled(true);
        jComboBoxVacina.setEnabled(true);
        jComboBoxhepatiteBContro.setEnabled(true);
        jComboBoxHepatiteCcurada.setEnabled(true);
        jObservacaoEnfermaria.setEnabled(true);
        //
        jBtSalvarEnfermaria.setEnabled(true);
        jBtCancelarEnfermaria.setEnabled(true);
    }

    public void ExcluirEnfermaria() {
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        //
        jBtNovoEnfermaria.setEnabled(true);
        //
        jBtNovoPeda.setEnabled(true);
        jBtNovoCrc.setEnabled(true);
        jBtNovoTO.setEnabled(true);
        jBtNovoPSI.setEnabled(true);
        jBtNovoSS.setEnabled(true);
    }

    public void SalvarEnfermaria() {
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        //
        jBtNovoEnfermaria.setEnabled(true);
        //
        jBtNovoPeda.setEnabled(true);
        jBtNovoCrc.setEnabled(true);
        jBtNovoTO.setEnabled(true);
        jBtNovoPSI.setEnabled(true);
        jBtNovoSS.setEnabled(true);
    }

    public void CancelarEnfermaria() {
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        //
        jBtNovoEnfermaria.setEnabled(true);
        //
        jBtNovoPeda.setEnabled(true);
        jBtNovoCrc.setEnabled(true);
        jBtNovoTO.setEnabled(true);
        jBtNovoPSI.setEnabled(true);
        jBtNovoSS.setEnabled(true);
    }

    public void buscarCodigoEnfermaria() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM INDICADOR_ACOMPANHAMENTO_INTERNO_ENFERMARIA");
            conecta.rs.last();
            codigoEnf = conecta.rs.getInt("IdIndAco");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter o código do registro.");
        }
        conecta.desconecta();
    }

    public void zerarVariaveis() {
        //ENFERMARIA
        qtdDiabetes = 0;
        qtdHipertensao = 0;
        qtdEscabiose = 0;
        qtdHanseniase = 0;
        qtdSifilis = 0;
        qtdTuberculose = 0;
        qtdHib = 0;
        qtdHepatiteB = 0;
        qtdHepatiteC = 0;
        qtdDst = 0;
        qtdVdlr = 0;
        qtdVacina = 0;
        //PEDAGOGIA
        qICAA = 0;
        qIC1 = 0;
        qIC2P = 0;
        qIAAU = 0;
        qIC3 = 0;
        qIREL = 0;
        qIAC = 0;
        qICU1 = 0;
        qIC2 = 0;
        qICA = 0;
        //JURIDICO/CRC
        qtdProcessos = 0;
        qtdDocumentacao = 0;
        qtdProggressao = 0;
        qtdLivramento = 0;
    }

    public void NovoPedagogia() {
        jDataPeda.setCalendar(Calendar.getInstance());
        jComboBoxICAA.setSelectedItem("Não");
        jComboBoxIC1.setSelectedItem("Não");
        jComboBoxIC2P.setSelectedItem("Não");
        jComboBoxIAAU.setSelectedItem("Não");
        jComboBoxIREL.setSelectedItem("Não");
        jComboBoxIC3.setSelectedItem("Não");
        jComboBoxIAC.setSelectedItem("Não");
        jComboBoxICU1.setSelectedItem("Não");
        jComboBoxIC2.setSelectedItem("Não");
        jComboBoxICA.setSelectedItem("Não");
        jDataPeda.setDate(null);
        //
        jComboBoxICAA.setEnabled(true);
        jComboBoxIC1.setEnabled(true);
        jComboBoxIC2P.setEnabled(true);
        jComboBoxIAAU.setEnabled(true);
        jComboBoxIREL.setEnabled(true);
        jComboBoxIC3.setEnabled(true);
        jComboBoxIAC.setEnabled(true);
        jComboBoxICU1.setEnabled(true);
        jComboBoxIC2.setEnabled(true);
        jComboBoxICA.setEnabled(true);
        jDataPeda.setEnabled(true);
        jObservacaoPeda.setEnabled(true);
        //
        jBtSalvarPeda.setEnabled(true);
        jBtCancelarPeda.setEnabled(true);
    }

    public void AlterarPedagogia() {
        jComboBoxICAA.setEnabled(true);
        jComboBoxIC1.setEnabled(true);
        jComboBoxIC2P.setEnabled(true);
        jComboBoxIAAU.setEnabled(true);
        jComboBoxIREL.setEnabled(true);
        jComboBoxIC3.setEnabled(true);
        jComboBoxIAC.setEnabled(true);
        jComboBoxICU1.setEnabled(true);
        jComboBoxIC2.setEnabled(true);
        jComboBoxICA.setEnabled(true);
        jDataPeda.setEnabled(true);
        jObservacaoPeda.setEnabled(true);
        //
        jBtSalvarPeda.setEnabled(true);
        jBtCancelarPeda.setEnabled(true);
    }

    public void ExcluirPedagogia() {
        jComboBoxICAA.setSelectedItem("Não");
        jComboBoxIC1.setSelectedItem("Não");
        jComboBoxIC2P.setSelectedItem("Não");
        jComboBoxIAAU.setSelectedItem("Não");
        jComboBoxIREL.setSelectedItem("Não");
        jComboBoxIC3.setSelectedItem("Não");
        jComboBoxIAC.setSelectedItem("Não");
        jComboBoxICU1.setSelectedItem("Não");
        jComboBoxIC2.setSelectedItem("Não");
        jComboBoxICA.setSelectedItem("Não");
        jDataPeda.setDate(null);
        //
        jComboBoxICAA.setEnabled(!true);
        jComboBoxIC1.setEnabled(!true);
        jComboBoxIC2P.setEnabled(!true);
        jComboBoxIAAU.setEnabled(!true);
        jComboBoxIREL.setEnabled(!true);
        jComboBoxIC3.setEnabled(!true);
        jComboBoxIAC.setEnabled(!true);
        jComboBoxICU1.setEnabled(!true);
        jComboBoxIC2.setEnabled(!true);
        jComboBoxICA.setEnabled(!true);
        jDataPeda.setEnabled(!true);
        jObservacaoPeda.setEnabled(!true);
        //
        jBtNovoPeda.setEnabled(true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        //
        jBtNovoEnfermaria.setEnabled(true);
        jBtNovoPeda.setEnabled(true);
        jBtNovoCrc.setEnabled(true);
        jBtNovoTO.setEnabled(true);
        jBtNovoPSI.setEnabled(true);
        jBtNovoSS.setEnabled(true);
    }

    public void SalvarPedagogia() {
        jComboBoxICAA.setEnabled(!true);
        jComboBoxIC1.setEnabled(!true);
        jComboBoxIC2P.setEnabled(!true);
        jComboBoxIAAU.setEnabled(!true);
        jComboBoxIREL.setEnabled(!true);
        jComboBoxIC3.setEnabled(!true);
        jComboBoxIAC.setEnabled(!true);
        jComboBoxICU1.setEnabled(!true);
        jComboBoxIC2.setEnabled(!true);
        jComboBoxICA.setEnabled(!true);
        jDataPeda.setEnabled(!true);
        jObservacaoPeda.setEnabled(!true);
        //
        jBtNovoPeda.setEnabled(true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        //
        jBtNovoEnfermaria.setEnabled(true);
        jBtNovoCrc.setEnabled(true);
        jBtNovoTO.setEnabled(true);
        jBtNovoPSI.setEnabled(true);
        jBtNovoSS.setEnabled(true);
    }

    public void CancelarPedagogia() {
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        //
        jBtNovoEnfermaria.setEnabled(true);
        jBtNovoPeda.setEnabled(true);
        jBtNovoCrc.setEnabled(true);
        jBtNovoTO.setEnabled(true);
        jBtNovoPSI.setEnabled(true);
        jBtNovoSS.setEnabled(true);
    }

    public void buscarCodigoPedagogia() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM INDICADOR_ACOMPANHAMENTO_INTERNO_PEDAGOGIA");
            conecta.rs.last();
            codigoPeda = conecta.rs.getInt("IdPedago");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter o código do registro.");
        }
        conecta.desconecta();
    }

    public void NovoCrc() {
        jComboBoxProcessoAcomp.setSelectedItem("Não");
        jComboBoxProgressaoRegime.setSelectedItem("Não");
        jComboBoxDocumentacao.setSelectedItem("Não");
        jComboBoxLivramentoCond.setSelectedItem("Não");
        jDataCrc.setDate(null);
        jObservacaoCrc.setText("");
        //
        jComboBoxProcessoAcomp.setEnabled(true);
        jComboBoxProgressaoRegime.setEnabled(true);
        jComboBoxDocumentacao.setEnabled(true);
        jComboBoxLivramentoCond.setEnabled(true);
        jDataCrc.setEnabled(true);
        jObservacaoCrc.setEnabled(true);
        //
        jDataCrc.setCalendar(Calendar.getInstance());
        //        
        jBtSalvarCrc.setEnabled(true);
        jBtCancelarCrc.setEnabled(true);
    }

    public void AlterarCrc() {
        jComboBoxProcessoAcomp.setEnabled(true);
        jComboBoxProgressaoRegime.setEnabled(true);
        jComboBoxDocumentacao.setEnabled(true);
        jComboBoxLivramentoCond.setEnabled(true);
        jDataCrc.setEnabled(true);
        jObservacaoCrc.setEnabled(true);
        //        
        jBtSalvarCrc.setEnabled(true);
        jBtCancelarCrc.setEnabled(true);
    }

    public void ExcluirCrc() {
        jComboBoxProcessoAcomp.setSelectedItem("Não");
        jComboBoxProgressaoRegime.setSelectedItem("Não");
        jComboBoxDocumentacao.setSelectedItem("Não");
        jComboBoxLivramentoCond.setSelectedItem("Não");
        jDataCrc.setDate(null);
        jObservacaoCrc.setText("");
        //
        jComboBoxProcessoAcomp.setEnabled(!true);
        jComboBoxProgressaoRegime.setEnabled(!true);
        jComboBoxDocumentacao.setEnabled(!true);
        jComboBoxLivramentoCond.setEnabled(!true);
        jDataCrc.setEnabled(!true);
        jObservacaoCrc.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        //
        jBtNovoEnfermaria.setEnabled(true);
        jBtNovoPeda.setEnabled(true);
        jBtNovoCrc.setEnabled(true);
        jBtNovoTO.setEnabled(true);
        jBtNovoPSI.setEnabled(true);
        jBtNovoTO.setEnabled(true);
        jBtNovoSS.setEnabled(true);
    }

    public void SalvarCrc() {
        jComboBoxProcessoAcomp.setEnabled(!true);
        jComboBoxProgressaoRegime.setEnabled(!true);
        jComboBoxDocumentacao.setEnabled(!true);
        jComboBoxLivramentoCond.setEnabled(!true);
        jDataCrc.setEnabled(!true);
        jObservacaoCrc.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        //
        jBtNovoEnfermaria.setEnabled(true);
        jBtNovoPeda.setEnabled(true);
        jBtNovoCrc.setEnabled(true);
        jBtNovoTO.setEnabled(true);
        jBtNovoPSI.setEnabled(true);
        jBtNovoTO.setEnabled(true);
        jBtNovoSS.setEnabled(true);
    }

    public void CancelarCrc() {
        jComboBoxProcessoAcomp.setEnabled(!true);
        jComboBoxProgressaoRegime.setEnabled(!true);
        jComboBoxDocumentacao.setEnabled(!true);
        jComboBoxLivramentoCond.setEnabled(!true);
        jDataCrc.setEnabled(!true);
        jObservacaoCrc.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        //
        jBtNovoEnfermaria.setEnabled(true);
        jBtNovoPeda.setEnabled(true);
        jBtNovoCrc.setEnabled(true);
        jBtNovoTO.setEnabled(true);
        jBtNovoPSI.setEnabled(true);
        jBtNovoTO.setEnabled(true);
        jBtNovoSS.setEnabled(true);
    }

    public void buscarCodigoCrc() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM INDICADOR_ACOMPANHAMENTO_INTERNO_JURIDICO_CRC");
            conecta.rs.last();
            codigoCrc = conecta.rs.getInt("IdJurCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter o código do registro.");
        }
        conecta.desconecta();
    }

    public void verificarExistenciaIndicadorAcompanha() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM INDICADOR_ACOMPANHAMENTO_INTERNO_ENFERMARIA "
                    + "WHERE IdInternoCrc='" + jIdInternoPerfil.getText() + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getString("IdInternoCrc");
            anoReferencia = conecta.rs.getInt("AnoRef");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarInternoIndicadorAcompanha() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM INDICADOR_ACOMPANHAMENTO_INTERNO "
                    + "WHERE IdInternoCrc='" + jIdInternoPerfil.getText() + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getString("IdInternoCrc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void preencherTabelaPerfilCarcerario(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Nome do Interno"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1;
                // Formatar a data Entrada
                dataPAI = conecta.rs.getString("DataPerfil");
                String diae = dataPAI.substring(8, 10);
                String mese = dataPAI.substring(5, 7);
                String anoe = dataPAI.substring(0, 4);
                dataPAI = diae + "/" + mese + "/" + anoe;
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdIndAco"), dataPAI, conecta.rs.getString("StatusPerfil"), conecta.rs.getString("NomeInternoCrc")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPerfilCarcerario.setModel(modelo);
        jTabelaPerfilCarcerario.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaPerfilCarcerario.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPerfilCarcerario.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaPerfilCarcerario.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPerfilCarcerario.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaPerfilCarcerario.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPerfilCarcerario.getColumnModel().getColumn(3).setPreferredWidth(330);
        jTabelaPerfilCarcerario.getColumnModel().getColumn(3).setResizable(false);
        jTabelaPerfilCarcerario.getTableHeader().setReorderingAllowed(false);
        jTabelaPerfilCarcerario.setAutoResizeMode(jTabelaPerfilCarcerario.AUTO_RESIZE_OFF);
        jTabelaPerfilCarcerario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCelulasTabelaPerfilCarcerario();
        conecta.desconecta();
    }

    public void preencherTabelaEnfermaria(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Reg.", "Data", "Diabetes", "Controlada", "Hipertensão", "Controlada", "Escabiose", "Curada", "Hanseniase", "Curada", "Sifilis", "Curada", "Tuberculose", "Curada", "Hiv", "Controlada", "Hepatite B", "Controlada", "Hepatite C", "Controlada"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                // Formatar a data Entrada
                dataPAI1 = conecta.rs.getString("DataReg");
                String diae = dataPAI1.substring(8, 10);
                String mese = dataPAI1.substring(5, 7);
                String anoe = dataPAI1.substring(0, 4);
                dataPAI1 = diae + "/" + mese + "/" + anoe;
                dados.add(new Object[]{conecta.rs.getInt("IdEnf"), conecta.rs.getInt("IdIndAco"), dataPAI1, conecta.rs.getString("Diabetes"), conecta.rs.getString("DiabControl"), conecta.rs.getString("Hipertensao"), conecta.rs.getString("HiperControl"), conecta.rs.getString("Escabiose"), conecta.rs.getString("EscabioseCura"), conecta.rs.getString("Hanseniase"), conecta.rs.getString("HanseniaseCura"), conecta.rs.getString("Sifilis"), conecta.rs.getString("SifilisCura"), conecta.rs.getString("Tuberculose"), conecta.rs.getString("TuberculoseCura"), conecta.rs.getString("Hiv"), conecta.rs.getString("HivControlada"), conecta.rs.getString("HepatiteB"), conecta.rs.getString("HepatiteBCont"), conecta.rs.getString("HepatiteC"), conecta.rs.getString("HepatiteCCont")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaEnfermaria.setModel(modelo);
        jTabelaEnfermaria.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaEnfermaria.getColumnModel().getColumn(0).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTabelaEnfermaria.getColumnModel().getColumn(1).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(2).setPreferredWidth(60);
        jTabelaEnfermaria.getColumnModel().getColumn(2).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaEnfermaria.getColumnModel().getColumn(3).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTabelaEnfermaria.getColumnModel().getColumn(4).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(5).setPreferredWidth(80);
        jTabelaEnfermaria.getColumnModel().getColumn(5).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(6).setPreferredWidth(80);
        jTabelaEnfermaria.getColumnModel().getColumn(6).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(7).setPreferredWidth(70);
        jTabelaEnfermaria.getColumnModel().getColumn(7).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(8).setPreferredWidth(70);
        jTabelaEnfermaria.getColumnModel().getColumn(8).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(9).setPreferredWidth(70);
        jTabelaEnfermaria.getColumnModel().getColumn(9).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(10).setPreferredWidth(70);
        jTabelaEnfermaria.getColumnModel().getColumn(10).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(11).setPreferredWidth(60);
        jTabelaEnfermaria.getColumnModel().getColumn(11).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(12).setPreferredWidth(70);
        jTabelaEnfermaria.getColumnModel().getColumn(12).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(13).setPreferredWidth(70);
        jTabelaEnfermaria.getColumnModel().getColumn(13).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(14).setPreferredWidth(70);
        jTabelaEnfermaria.getColumnModel().getColumn(14).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(15).setPreferredWidth(60);
        jTabelaEnfermaria.getColumnModel().getColumn(15).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(16).setPreferredWidth(70);
        jTabelaEnfermaria.getColumnModel().getColumn(16).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(17).setPreferredWidth(70);
        jTabelaEnfermaria.getColumnModel().getColumn(17).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(18).setPreferredWidth(70);
        jTabelaEnfermaria.getColumnModel().getColumn(18).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(19).setPreferredWidth(70);
        jTabelaEnfermaria.getColumnModel().getColumn(19).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(20).setPreferredWidth(70);
        jTabelaEnfermaria.getColumnModel().getColumn(20).setResizable(false);
        jTabelaEnfermaria.getTableHeader().setReorderingAllowed(false);
        jTabelaEnfermaria.setAutoResizeMode(jTabelaEnfermaria.AUTO_RESIZE_OFF);
        jTabelaEnfermaria.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCelulasTabelaEnfermagem();
        conecta.desconecta();
    }

    public void preencherTabelaPedagogia(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Reg.", "Data", "ICAA", "IC1", "IC2P", "IAUU", "IC3", "IREL", "IAC", "ICU1", "IC2", "ICA"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                // Formatar a data Entrada
                dataPAI2 = conecta.rs.getString("DataPeda");
                String diae = dataPAI2.substring(8, 10);
                String mese = dataPAI2.substring(5, 7);
                String anoe = dataPAI2.substring(0, 4);
                dataPAI2 = diae + "/" + mese + "/" + anoe;
                dados.add(new Object[]{conecta.rs.getInt("IdPedago"), conecta.rs.getInt("IdIndAco"), dataPAI2, conecta.rs.getString("ICAA"), conecta.rs.getString("IC1"), conecta.rs.getString("IC2P"), conecta.rs.getString("IAAU"), conecta.rs.getString("IC3"), conecta.rs.getString("IREL"), conecta.rs.getString("IAC"), conecta.rs.getString("ICU1"), conecta.rs.getString("IC2"), conecta.rs.getString("ICA")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPedagogia.setModel(modelo);
        jTabelaPedagogia.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaPedagogia.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPedagogia.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTabelaPedagogia.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPedagogia.getColumnModel().getColumn(2).setPreferredWidth(70);
        jTabelaPedagogia.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPedagogia.getColumnModel().getColumn(3).setPreferredWidth(50);
        jTabelaPedagogia.getColumnModel().getColumn(3).setResizable(false);
        jTabelaPedagogia.getColumnModel().getColumn(4).setPreferredWidth(50);
        jTabelaPedagogia.getColumnModel().getColumn(4).setResizable(false);
        jTabelaPedagogia.getColumnModel().getColumn(5).setPreferredWidth(50);
        jTabelaPedagogia.getColumnModel().getColumn(5).setResizable(false);
        jTabelaPedagogia.getColumnModel().getColumn(6).setPreferredWidth(50);
        jTabelaPedagogia.getColumnModel().getColumn(6).setResizable(false);
        jTabelaPedagogia.getColumnModel().getColumn(7).setPreferredWidth(70);
        jTabelaPedagogia.getColumnModel().getColumn(7).setResizable(false);
        jTabelaPedagogia.getColumnModel().getColumn(8).setPreferredWidth(50);
        jTabelaPedagogia.getColumnModel().getColumn(8).setResizable(false);
        jTabelaPedagogia.getColumnModel().getColumn(9).setPreferredWidth(50);
        jTabelaPedagogia.getColumnModel().getColumn(9).setResizable(false);
        jTabelaPedagogia.getColumnModel().getColumn(10).setPreferredWidth(50);
        jTabelaPedagogia.getColumnModel().getColumn(10).setResizable(false);
        jTabelaPedagogia.getColumnModel().getColumn(11).setPreferredWidth(50);
        jTabelaPedagogia.getColumnModel().getColumn(11).setResizable(false);
        jTabelaPedagogia.getColumnModel().getColumn(12).setPreferredWidth(50);
        jTabelaPedagogia.getColumnModel().getColumn(12).setResizable(false);
        jTabelaPedagogia.getTableHeader().setReorderingAllowed(false);
        jTabelaPedagogia.setAutoResizeMode(jTabelaPedagogia.AUTO_RESIZE_OFF);
        jTabelaPedagogia.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinhaCamposTabelaPedagogia();
        conecta.desconecta();
    }

    public void preencherTabelaCrc(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Reg.", "Data", "Processos", "Documentação", "Progressão", "Livramento"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                // Formatar a data Entrada
                dataPAI3 = conecta.rs.getString("DataJurCrc");
                String diae = dataPAI3.substring(8, 10);
                String mese = dataPAI3.substring(5, 7);
                String anoe = dataPAI3.substring(0, 4);
                dataPAI3 = diae + "/" + mese + "/" + anoe;
                dados.add(new Object[]{conecta.rs.getInt("IdJurCrc"), conecta.rs.getInt("IdIndAco"), dataPAI3, conecta.rs.getString("Processos"), conecta.rs.getString("Documentacao"), conecta.rs.getString("Progressao"), conecta.rs.getString("Livramento")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaCrcJuridico.setModel(modelo);
        jTabelaCrcJuridico.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaCrcJuridico.getColumnModel().getColumn(0).setResizable(false);
        jTabelaCrcJuridico.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTabelaCrcJuridico.getColumnModel().getColumn(1).setResizable(false);
        jTabelaCrcJuridico.getColumnModel().getColumn(2).setPreferredWidth(70);
        jTabelaCrcJuridico.getColumnModel().getColumn(2).setResizable(false);
        jTabelaCrcJuridico.getColumnModel().getColumn(3).setPreferredWidth(50);
        jTabelaCrcJuridico.getColumnModel().getColumn(3).setResizable(false);
        jTabelaCrcJuridico.getColumnModel().getColumn(4).setPreferredWidth(50);
        jTabelaCrcJuridico.getColumnModel().getColumn(4).setResizable(false);
        jTabelaCrcJuridico.getColumnModel().getColumn(5).setPreferredWidth(50);
        jTabelaCrcJuridico.getColumnModel().getColumn(5).setResizable(false);
        jTabelaCrcJuridico.getColumnModel().getColumn(6).setPreferredWidth(50);
        jTabelaCrcJuridico.getColumnModel().getColumn(6).setResizable(false);
        jTabelaCrcJuridico.getTableHeader().setReorderingAllowed(false);
        jTabelaCrcJuridico.setAutoResizeMode(jTabelaCrcJuridico.AUTO_RESIZE_OFF);
        jTabelaCrcJuridico.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinhaCamposTabelaPedagogia();
        conecta.desconecta();
    }

    public void alinharCelulasTabelaPerfilCarcerario() {
        //
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaPerfilCarcerario.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaPerfilCarcerario.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaPerfilCarcerario.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }

    public void limparTabelaPerfilCarcerario() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Nome do Interno"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPerfilCarcerario.setModel(modelo);
        jTabelaPerfilCarcerario.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaPerfilCarcerario.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPerfilCarcerario.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaPerfilCarcerario.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPerfilCarcerario.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaPerfilCarcerario.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPerfilCarcerario.getColumnModel().getColumn(3).setPreferredWidth(280);
        jTabelaPerfilCarcerario.getColumnModel().getColumn(3).setResizable(false);
        jTabelaPerfilCarcerario.getTableHeader().setReorderingAllowed(false);
        jTabelaPerfilCarcerario.setAutoResizeMode(jTabelaPerfilCarcerario.AUTO_RESIZE_OFF);
        jTabelaPerfilCarcerario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void limparTabelaIndaicadoresEnfermaria() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Reg.", "Data", "Diabetes", "Controlada", "Hipertensão", "Controlada", "Escabiose", "Curada", "Hanseniase", "Curada", "Sifilis", "Curada", "Tuberculose", "Curada", "Hiv", "Controlada", "Hepatite B", "Controlada", "Hepatite C", "Controlada"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaEnfermaria.setModel(modelo);
        jTabelaEnfermaria.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaEnfermaria.getColumnModel().getColumn(0).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTabelaEnfermaria.getColumnModel().getColumn(1).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(2).setPreferredWidth(60);
        jTabelaEnfermaria.getColumnModel().getColumn(2).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaEnfermaria.getColumnModel().getColumn(3).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTabelaEnfermaria.getColumnModel().getColumn(4).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(5).setPreferredWidth(80);
        jTabelaEnfermaria.getColumnModel().getColumn(5).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(6).setPreferredWidth(80);
        jTabelaEnfermaria.getColumnModel().getColumn(6).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(7).setPreferredWidth(70);
        jTabelaEnfermaria.getColumnModel().getColumn(7).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(8).setPreferredWidth(70);
        jTabelaEnfermaria.getColumnModel().getColumn(8).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(9).setPreferredWidth(70);
        jTabelaEnfermaria.getColumnModel().getColumn(9).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(10).setPreferredWidth(70);
        jTabelaEnfermaria.getColumnModel().getColumn(10).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(11).setPreferredWidth(60);
        jTabelaEnfermaria.getColumnModel().getColumn(11).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(12).setPreferredWidth(70);
        jTabelaEnfermaria.getColumnModel().getColumn(12).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(13).setPreferredWidth(70);
        jTabelaEnfermaria.getColumnModel().getColumn(13).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(14).setPreferredWidth(70);
        jTabelaEnfermaria.getColumnModel().getColumn(14).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(15).setPreferredWidth(60);
        jTabelaEnfermaria.getColumnModel().getColumn(15).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(16).setPreferredWidth(70);
        jTabelaEnfermaria.getColumnModel().getColumn(16).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(17).setPreferredWidth(70);
        jTabelaEnfermaria.getColumnModel().getColumn(17).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(18).setPreferredWidth(70);
        jTabelaEnfermaria.getColumnModel().getColumn(18).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(19).setPreferredWidth(70);
        jTabelaEnfermaria.getColumnModel().getColumn(19).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(20).setPreferredWidth(70);
        jTabelaEnfermaria.getColumnModel().getColumn(20).setResizable(false);
        jTabelaEnfermaria.getTableHeader().setReorderingAllowed(false);
        jTabelaEnfermaria.setAutoResizeMode(jTabelaEnfermaria.AUTO_RESIZE_OFF);
        jTabelaEnfermaria.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCelulasTabelaEnfermagem() {
        //
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaEnfermaria.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaEnfermaria.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaEnfermaria.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        jTabelaEnfermaria.getColumnModel().getColumn(3).setCellRenderer(centralizado);
        jTabelaEnfermaria.getColumnModel().getColumn(4).setCellRenderer(centralizado);
        jTabelaEnfermaria.getColumnModel().getColumn(5).setCellRenderer(centralizado);
        jTabelaEnfermaria.getColumnModel().getColumn(6).setCellRenderer(centralizado);
        jTabelaEnfermaria.getColumnModel().getColumn(7).setCellRenderer(centralizado);
        jTabelaEnfermaria.getColumnModel().getColumn(8).setCellRenderer(centralizado);
        jTabelaEnfermaria.getColumnModel().getColumn(9).setCellRenderer(centralizado);
        jTabelaEnfermaria.getColumnModel().getColumn(10).setCellRenderer(centralizado);
        jTabelaEnfermaria.getColumnModel().getColumn(11).setCellRenderer(centralizado);
        jTabelaEnfermaria.getColumnModel().getColumn(12).setCellRenderer(centralizado);
        jTabelaEnfermaria.getColumnModel().getColumn(13).setCellRenderer(centralizado);
        jTabelaEnfermaria.getColumnModel().getColumn(14).setCellRenderer(centralizado);
        jTabelaEnfermaria.getColumnModel().getColumn(15).setCellRenderer(centralizado);
        jTabelaEnfermaria.getColumnModel().getColumn(16).setCellRenderer(centralizado);
        jTabelaEnfermaria.getColumnModel().getColumn(17).setCellRenderer(centralizado);
        jTabelaEnfermaria.getColumnModel().getColumn(18).setCellRenderer(centralizado);
        jTabelaEnfermaria.getColumnModel().getColumn(19).setCellRenderer(centralizado);
        jTabelaEnfermaria.getColumnModel().getColumn(20).setCellRenderer(centralizado);
    }

    public void limparTabelaPedagogia() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Reg.", "Data", "ICAA", "IC1", "IC2P", "IAUU", "IC3", "IREL", "IAC", "ICU1", "IC2", "ICA"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPedagogia.setModel(modelo);
        jTabelaPedagogia.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaPedagogia.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPedagogia.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTabelaPedagogia.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPedagogia.getColumnModel().getColumn(2).setPreferredWidth(50);
        jTabelaPedagogia.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPedagogia.getColumnModel().getColumn(3).setPreferredWidth(70);
        jTabelaPedagogia.getColumnModel().getColumn(3).setResizable(false);
        jTabelaPedagogia.getColumnModel().getColumn(4).setPreferredWidth(50);
        jTabelaPedagogia.getColumnModel().getColumn(4).setResizable(false);
        jTabelaPedagogia.getColumnModel().getColumn(5).setPreferredWidth(50);
        jTabelaPedagogia.getColumnModel().getColumn(5).setResizable(false);
        jTabelaPedagogia.getColumnModel().getColumn(6).setPreferredWidth(50);
        jTabelaPedagogia.getColumnModel().getColumn(6).setResizable(false);
        jTabelaPedagogia.getColumnModel().getColumn(7).setPreferredWidth(70);
        jTabelaPedagogia.getColumnModel().getColumn(7).setResizable(false);
        jTabelaPedagogia.getColumnModel().getColumn(8).setPreferredWidth(50);
        jTabelaPedagogia.getColumnModel().getColumn(8).setResizable(false);
        jTabelaPedagogia.getColumnModel().getColumn(9).setPreferredWidth(50);
        jTabelaPedagogia.getColumnModel().getColumn(9).setResizable(false);
        jTabelaPedagogia.getColumnModel().getColumn(10).setPreferredWidth(50);
        jTabelaPedagogia.getColumnModel().getColumn(10).setResizable(false);
        jTabelaPedagogia.getColumnModel().getColumn(11).setPreferredWidth(50);
        jTabelaPedagogia.getColumnModel().getColumn(11).setResizable(false);
        jTabelaPedagogia.getColumnModel().getColumn(12).setPreferredWidth(50);
        jTabelaPedagogia.getColumnModel().getColumn(12).setResizable(false);
        jTabelaPedagogia.getTableHeader().setReorderingAllowed(false);
        jTabelaPedagogia.setAutoResizeMode(jTabelaPedagogia.AUTO_RESIZE_OFF);
        jTabelaPedagogia.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinhaCamposTabelaPedagogia() {
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        //
        jTabelaPedagogia.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaPedagogia.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaPedagogia.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        jTabelaPedagogia.getColumnModel().getColumn(3).setCellRenderer(centralizado);
        jTabelaPedagogia.getColumnModel().getColumn(4).setCellRenderer(centralizado);
        jTabelaPedagogia.getColumnModel().getColumn(5).setCellRenderer(centralizado);
        jTabelaPedagogia.getColumnModel().getColumn(6).setCellRenderer(centralizado);
        jTabelaPedagogia.getColumnModel().getColumn(7).setCellRenderer(centralizado);
        jTabelaPedagogia.getColumnModel().getColumn(8).setCellRenderer(centralizado);
        jTabelaPedagogia.getColumnModel().getColumn(9).setCellRenderer(centralizado);
        jTabelaPedagogia.getColumnModel().getColumn(10).setCellRenderer(centralizado);
        jTabelaPedagogia.getColumnModel().getColumn(11).setCellRenderer(centralizado);
        jTabelaPedagogia.getColumnModel().getColumn(12).setCellRenderer(centralizado);
    }

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jIdPerfil.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog2() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela1);
        objLogSys.setIdLancMov(codigoEnf);
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
}
