/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleColaborador;
import gestor.Controle.ControleDependentesColaborador;
import gestor.Controle.ControleDocumentosColaborador;
import gestor.Controle.ControleEnderecosColaborador;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControleEscalaFolgas;
import gestor.Controle.converterDataStringDataDate;
import gestor.Dao.ConexaoBancoDados;
import Utilitarios.LimiteDigitos;
import Utilitarios.LimiteDigitosAlfa;
import Utilitarios.LimiteDigitosMin;
import Utilitarios.LimiteDigitosNum;
import Utilitarios.ModeloTabela;
import gestor.Controle.ControleImplementacoes;
import gestor.Controle.PesquisarEscalasDescricao;
import gestor.Modelo.Dependentes;
import gestor.Modelo.Documentos;
import gestor.Modelo.Enderecos;
import gestor.Modelo.EscalaFolgas;
import gestor.Modelo.Funcionarios;
import gestor.Modelo.LogSistema;
import gestor.Modelo.ParametrosCrc;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloAdmPessoal.codAbrirADM;
import static gestor.Visao.TelaModuloAdmPessoal.codAlterarADM;
import static gestor.Visao.TelaModuloAdmPessoal.codConsultarADM;
import static gestor.Visao.TelaModuloAdmPessoal.codExcluirADM;
import static gestor.Visao.TelaModuloAdmPessoal.codGravarADM;
import static gestor.Visao.TelaModuloAdmPessoal.codIncluirADM;
import static gestor.Visao.TelaModuloAdmPessoal.codUserAcessoADM;
import static gestor.Visao.TelaModuloAdmPessoal.codigoGrupoADM;
import static gestor.Visao.TelaModuloAdmPessoal.codigoUserADM;
import static gestor.Visao.TelaModuloAdmPessoal.codigoUserGroupADM;
import static gestor.Visao.TelaModuloAdmPessoal.nomeGrupoADM;
import static gestor.Visao.TelaModuloAdmPessoal.nomeTelaADM;
import static gestor.Visao.TelaModuloAdmPessoal.telaColaboradoresFCDep_ADM;
import static gestor.Visao.TelaModuloAdmPessoal.telaColaboradoresFCDoc_ADM;
import static gestor.Visao.TelaModuloAdmPessoal.telaColaboradoresFCEnd_ADM;
import static gestor.Visao.TelaModuloAdmPessoal.telaColaboradoresFC_ADM;
import static gestor.Visao.TelaModuloAdmPessoal.telaCronograma_ADM;
import static gestor.Visao.TelaModuloAdmPessoal.telaEscalaTrabalho_ADM;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import java.awt.Color;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import org.opencv.core.Core;

/**
 *
 * @author Ronaldo
 */
public class TelaFuncionarios extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    Funcionarios objCola = new Funcionarios();
    ControleColaborador control = new ControleColaborador();
    Enderecos objEnd = new Enderecos();
    ControleEnderecosColaborador controle = new ControleEnderecosColaborador();
    Documentos objDoc = new Documentos();
    ControleDocumentosColaborador controleDoc = new ControleDocumentosColaborador();
    Dependentes objDep = new Dependentes();
    ControleDependentesColaborador controlDep = new ControleDependentesColaborador();
    //
    converterDataStringDataDate convertedata = new converterDataStringDataDate();
    //ESCALA DE TRABALHO
    EscalaFolgas objEscala = new EscalaFolgas();
    PesquisarEscalasDescricao pPESQUISAR_nome = new PesquisarEscalasDescricao();
    ControleEscalaFolgas CONTROLE_ESCALA_colaborador = new ControleEscalaFolgas();
    //     
    ParametrosCrc objParCrc = new ParametrosCrc();
    ControleImplementacoes controlImp = new ControleImplementacoes();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela = "AdmPessoal:Colaboradores:Ficha Cadastral:Manutenção";
    String nomeModuloTela1 = "AdmPessoal:Colaboradores:Ficha Cadastral:Dependentes";
    String nomeModuloTela2 = "AdmPessoal:Colaboradores:Ficha Cadastral:Escala de Trabalho";
    String statusMov;
    String horaMov;
    String dataModFinal;
    //
    public static String caminhoFotoFunc = "";
    int acao;
    int flag;
    String dataCadastro;
    int codFunc, codEnd, codDoc, codDep;
    String codFuncEnd, codFuncDoc, codFuncDep;
    String idFunc;
    String nomeFunc; // Pesquisar o nome do colaborador na tabela FUNCIONARIOS
    String nomeColaborador, nomeMaeColaborador; // Verificar dupliciadade de cadastro
    int count = 0;
    int countDep = 0;
    //
    String dataNascDep; // Formatar a data de Nascimento dependente
    String dataInicial, dataFinal;
    //ARRAY PARA FOTO DO COLABORADOR
    byte[] persona_imagem = null;
    //
    public static int pID_ESCALA = 0;
    public static String pRESPOSTA_escala = "";
    public static int pCODIGO_colaborador = 0;
    //
    public static String pCODIGO_PESQUISA_func = "";

    /**
     * Creates new form TelaFuncionarios
     */
    public static TelaWebCamColaborador webCamFunc;
    public static TelaBiometriaColaboradores telaBiometriaFunc;
    public static TelaCronogramaEscala pCRONOGRAMA;

    public TelaFuncionarios() {
        initComponents();
        formatarCampos();
        corCampo();
        PESQUISAR_LIBERACAO_implementacao();
    }

    public void mostrarWebCamFunc() {
        webCamFunc = new TelaWebCamColaborador(this, true);
        webCamFunc.setVisible(true);
    }

    public void mostrarBiometriaFunc() {
        telaBiometriaFunc = new TelaBiometriaColaboradores(this, true);
        telaBiometriaFunc.setVisible(true);
    }

    public void mostrarCRONOGRAMA() {
        pCRONOGRAMA = new TelaCronogramaEscala(this, true);
        pCRONOGRAMA.setVisible(true);
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
        jListagem = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPesqNome = new javax.swing.JTextField();
        jBtPesqNome = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel23 = new javax.swing.JLabel();
        jCodigoPesqFunc = new javax.swing.JTextField();
        jBtPesqCodigoFunc = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jPesqMatricula = new javax.swing.JTextField();
        jBtPesqMatricula = new javax.swing.JButton();
        jBtPesqDatas = new javax.swing.JButton();
        jDataPesqInicial = new com.toedter.calendar.JDateChooser();
        jLabel73 = new javax.swing.JLabel();
        jDataPesFinal = new com.toedter.calendar.JDateChooser();
        jLabel74 = new javax.swing.JLabel();
        jComboBoxPesqFunc = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaFuncionario = new javax.swing.JTable();
        jPanel30 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jManutencao = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jIDFunc = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jFotoColaborador = new javax.swing.JLabel();
        jNomeFuncionario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jComboBoxEscolaridade = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jComboBoxSexo = new javax.swing.JComboBox();
        jBtExcluirFoto2 = new javax.swing.JButton();
        jBtNovoFoto2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxStatusFunc = new javax.swing.JComboBox();
        jBtWebCam = new javax.swing.JButton();
        jDataAdmissao = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jMatricula = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jDataNascimento = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jComboBoxEstadoCivil = new javax.swing.JComboBox();
        jLabel70 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jBtNovo = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jBtAuditoria = new javax.swing.JButton();
        jBtBiometria = new javax.swing.JButton();
        jBtConsultaMovimentacao = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jNomeMae = new javax.swing.JTextField();
        jNomePai = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jReligiao = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        jTipoSang = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel14 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jDepartamento = new javax.swing.JTextField();
        jBtPesqDepto = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jNomeCargo = new javax.swing.JTextField();
        jBtPesqCargo = new javax.swing.JButton();
        jLabel54 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jCargaHoraria = new javax.swing.JFormattedTextField();
        jLabel17 = new javax.swing.JLabel();
        jComboBoxRegimeTrabalho = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        jHorarioFinal = new javax.swing.JFormattedTextField();
        jHorarioInicio = new javax.swing.JFormattedTextField();
        jLabel19 = new javax.swing.JLabel();
        jFuncao = new javax.swing.JTextField();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jComboBoxNacionalidade = new javax.swing.JComboBox();
        jLabel52 = new javax.swing.JLabel();
        jPais = new javax.swing.JTextField();
        jPanel24 = new javax.swing.JPanel();
        jNaturalidade = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jComboBoxEstadoNaturalidade = new javax.swing.JComboBox();
        jLabel81 = new javax.swing.JLabel();
        jLogradouro = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        jEndereco = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        jBairro = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jCidade = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jCep = new javax.swing.JFormattedTextField();
        jLabel61 = new javax.swing.JLabel();
        jComplemento = new javax.swing.JTextField();
        jComboBoxEstado = new javax.swing.JComboBox();
        jPanel10 = new javax.swing.JPanel();
        jLabel65 = new javax.swing.JLabel();
        jEmail = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        jTelefone = new javax.swing.JFormattedTextField();
        jLabel62 = new javax.swing.JLabel();
        jTelefoneEnd = new javax.swing.JFormattedTextField();
        jLabel64 = new javax.swing.JLabel();
        jCelularEnd = new javax.swing.JFormattedTextField();
        jLabel66 = new javax.swing.JLabel();
        jURL = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jObservacao = new javax.swing.JTextArea();
        jPanel11 = new javax.swing.JPanel();
        jBtNovoLogradouro = new javax.swing.JButton();
        jBtAlterarLogradouro = new javax.swing.JButton();
        jBtExcluirLogradouro = new javax.swing.JButton();
        jBtSalvarLogradouro = new javax.swing.JButton();
        jBtCancelarLogradouro = new javax.swing.JButton();
        jBtSairLogradouro = new javax.swing.JButton();
        jBtAuditoriaLogradouro = new javax.swing.JButton();
        jDocumentos = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jRG = new javax.swing.JFormattedTextField();
        jCPF = new javax.swing.JFormattedTextField();
        jPis = new javax.swing.JTextField();
        jTitulo = new javax.swing.JTextField();
        jZona = new javax.swing.JTextField();
        jCTPS = new javax.swing.JTextField();
        jSerie = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jReservista = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jCategoria = new javax.swing.JTextField();
        jDataEmissaoRg = new com.toedter.calendar.JDateChooser();
        jSecao = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jOrgaoEmissor = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jDataCadPis = new com.toedter.calendar.JDateChooser();
        jLabel37 = new javax.swing.JLabel();
        jHabilita = new javax.swing.JTextField();
        jCartaoSaude = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jComboBoxEstadoOrgao = new javax.swing.JComboBox();
        jPanel18 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jProfissao = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jCarteiraconselho = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jAltura = new javax.swing.JFormattedTextField();
        jLabel48 = new javax.swing.JLabel();
        jPeso = new javax.swing.JFormattedTextField();
        jLabel49 = new javax.swing.JLabel();
        jCalca = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jCamisa = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jSapato = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jComboBoxTipoConjugue = new javax.swing.JComboBox();
        jLabel21 = new javax.swing.JLabel();
        jNomeConjugue = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jDataNasConjugue = new com.toedter.calendar.JDateChooser();
        jPanel19 = new javax.swing.JPanel();
        jBtNovoDocumentos = new javax.swing.JButton();
        jBtAlterarDocumentos = new javax.swing.JButton();
        jBtExcluirDocumentos = new javax.swing.JButton();
        jBtSalvarDocumentos = new javax.swing.JButton();
        jBtCancelarDocumentos = new javax.swing.JButton();
        jBtSairDocumentos = new javax.swing.JButton();
        jBtAuditoriaDocumentos = new javax.swing.JButton();
        jBtImpressaoFichaColaborador = new javax.swing.JButton();
        jDependentesEscala = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jDependentes = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jCodigoDependente = new javax.swing.JTextField();
        jNomeDependente = new javax.swing.JTextField();
        jDataNascimentoParentesco = new com.toedter.calendar.JDateChooser();
        jComboBoxParentesco = new javax.swing.JComboBox();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jBtNovoDependente = new javax.swing.JButton();
        jBtAlterarDependente = new javax.swing.JButton();
        jBtExcluirDependente = new javax.swing.JButton();
        jBtSalvarDependente = new javax.swing.JButton();
        jBtCancelarDependente = new javax.swing.JButton();
        jBtAuditoriaDependente = new javax.swing.JButton();
        jLabel71 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTabelaDependentes = new javax.swing.JTable();
        jPanel33 = new javax.swing.JPanel();
        jLabel82 = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        jtotalItens = new javax.swing.JLabel();
        jDadosEscala = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jCodigoEscala = new javax.swing.JTextField();
        jQtdTrabalho = new javax.swing.JTextField();
        jQtdFolga = new javax.swing.JTextField();
        jTurnoEscala = new javax.swing.JTextField();
        jLabel88 = new javax.swing.JLabel();
        jTurmaEscala = new javax.swing.JTextField();
        jLabel89 = new javax.swing.JLabel();
        jComboBoxDescricaoEscala = new javax.swing.JComboBox<>();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jDepartamentoEscala = new javax.swing.JTextField();
        jNomeCargoEscala = new javax.swing.JTextField();
        jPanel28 = new javax.swing.JPanel();
        jBtNovaEscala = new javax.swing.JButton();
        jBtAlterarEscala = new javax.swing.JButton();
        jBtExcluirEscala = new javax.swing.JButton();
        jBtSalvarEscala = new javax.swing.JButton();
        jBtCancelarEscala = new javax.swing.JButton();
        jBtAuditoriaEscala = new javax.swing.JButton();
        jPanel29 = new javax.swing.JPanel();
        jBtCronogramaEscala = new javax.swing.JButton();
        jBtImprimeEscala = new javax.swing.JButton();
        jPanel36 = new javax.swing.JPanel();

        setClosable(true);
        setIconifiable(true);
        setTitle("...: Cadastro de Colaborador :::...");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisa de Colaborador", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 51, 255))); // NOI18N

        jPesqNome.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqNome.setContentAreaFilled(false);
        jBtPesqNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqNomeActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("Nome Colaborador:");

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

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setText("Matricula:");

        jPesqMatricula.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPesqMatricula.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqMatricula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqMatricula.setContentAreaFilled(false);
        jBtPesqMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqMatriculaActionPerformed(evt);
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

        jComboBoxPesqFunc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxPesqFunc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ativo", "Inativo" }));
        jComboBoxPesqFunc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel73, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jCodigoPesqFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqCodigoFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel74, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPesqMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jDataPesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqDatas, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox1)
                    .addComponent(jComboBoxPesqFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(jPesqNome, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtPesqNome, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jDataPesFinal, jPesqMatricula});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPesqMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(jCodigoPesqFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqCodigoFunc)
                    .addComponent(jLabel24)
                    .addComponent(jBtPesqMatricula)
                    .addComponent(jComboBoxPesqFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel73)
                    .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel74)
                    .addComponent(jDataPesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqDatas)
                    .addComponent(jCheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel6)
                    .addComponent(jPesqNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqNome))
                .addContainerGap())
        );

        jTabelaFuncionario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaFuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data", "Status", "Nome do Colaborador", "Departamento"
            }
        ));
        jTabelaFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaFuncionarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaFuncionario);
        if (jTabelaFuncionario.getColumnModel().getColumnCount() > 0) {
            jTabelaFuncionario.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaFuncionario.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaFuncionario.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaFuncionario.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaFuncionario.getColumnModel().getColumn(2).setMinWidth(60);
            jTabelaFuncionario.getColumnModel().getColumn(2).setMaxWidth(60);
            jTabelaFuncionario.getColumnModel().getColumn(3).setMinWidth(250);
            jTabelaFuncionario.getColumnModel().getColumn(3).setMaxWidth(250);
            jTabelaFuncionario.getColumnModel().getColumn(4).setMinWidth(200);
            jTabelaFuncionario.getColumnModel().getColumn(4).setMaxWidth(200);
        }

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

        javax.swing.GroupLayout jListagemLayout = new javax.swing.GroupLayout(jListagem);
        jListagem.setLayout(jListagemLayout);
        jListagemLayout.setHorizontalGroup(
            jListagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jListagemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jListagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
                    .addGroup(jListagemLayout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jListagemLayout.setVerticalGroup(
            jListagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jListagemLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jListagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("Listagem", jListagem);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Colaborador", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 51, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código");

        jIDFunc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIDFunc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIDFunc.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Data Admissão");

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Foto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 51))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoColaborador, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoColaborador, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
        );

        jNomeFuncionario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeFuncionario.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Nome Completo  do Colaborador");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Escolaridade");

        jComboBoxEscolaridade.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxEscolaridade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Analfabeto", "Alfabetizado", "Ensino Fundamental", "1º Grau Incompleto", "1º Grau Completo", "2º Grau Incompleto", "2º Grau Completo", "Superior Incompleto", "Superior Completo", "Mestrado", "Doutorado" }));
        jComboBoxEscolaridade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxEscolaridade.setEnabled(false);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Sexo");

        jComboBoxSexo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Masculino", "Feminino" }));
        jComboBoxSexo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxSexo.setEnabled(false);

        jBtExcluirFoto2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirFoto2.setToolTipText("Excluir Foto");
        jBtExcluirFoto2.setEnabled(false);
        jBtExcluirFoto2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirFoto2ActionPerformed(evt);
            }
        });

        jBtNovoFoto2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/7183_16x16.png"))); // NOI18N
        jBtNovoFoto2.setToolTipText("Adicionar Foto");
        jBtNovoFoto2.setEnabled(false);
        jBtNovoFoto2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoFoto2ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Status");

        jComboBoxStatusFunc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxStatusFunc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ativo", "Inativo", "INSS", "Férias", "Transferência", "Em Trânsito", "Óbito", "Desligado", "Abandono de emprego", "Em Transito" }));
        jComboBoxStatusFunc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxStatusFunc.setEnabled(false);

        jBtWebCam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/webcam_start.png"))); // NOI18N
        jBtWebCam.setEnabled(false);
        jBtWebCam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtWebCamActionPerformed(evt);
            }
        });

        jDataAdmissao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataAdmissao.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Matricula");

        jMatricula.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jMatricula.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMatricula.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Dt. Nascimento");

        jDataNascimento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataNascimento.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Estado Civil:");

        jComboBoxEstadoCivil.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Casado", "Casada", "Solteiro", "Solteira", "Outros" }));
        jComboBoxEstadoCivil.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxEstadoCivil.setEnabled(false);

        jLabel70.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(255, 0, 0));
        jLabel70.setText("*");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jNomeFuncionario)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel70))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jIDFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jComboBoxStatusFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jDataAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxSexo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxEscolaridade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jComboBoxEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jBtNovoFoto2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtExcluirFoto2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtWebCam, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jDataAdmissao, jDataNascimento});

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jIDFunc, jMatricula});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtNovoFoto2)
                    .addComponent(jBtExcluirFoto2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBtWebCam))
                .addGap(80, 80, 80))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIDFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxStatusFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel70))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNomeFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(jLabel8))
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxEscolaridade, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jDataAdmissao, jDataNascimento});

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 51, 255))); // NOI18N

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

        jBtAuditoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoria.setToolTipText("Auditoria");
        jBtAuditoria.setContentAreaFilled(false);
        jBtAuditoria.setEnabled(false);
        jBtAuditoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaActionPerformed(evt);
            }
        });

        jBtBiometria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216082320_16.png"))); // NOI18N
        jBtBiometria.setToolTipText("Biometria de Colaborador");
        jBtBiometria.setContentAreaFilled(false);
        jBtBiometria.setEnabled(false);
        jBtBiometria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtBiometriaActionPerformed(evt);
            }
        });

        jBtConsultaMovimentacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/061218140238_16.png"))); // NOI18N
        jBtConsultaMovimentacao.setToolTipText("Movimentação do Colaborador");
        jBtConsultaMovimentacao.setContentAreaFilled(false);
        jBtConsultaMovimentacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtConsultaMovimentacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jBtNovo)
                .addGap(1, 1, 1)
                .addComponent(jBtAlterar)
                .addGap(1, 1, 1)
                .addComponent(jBtExcluir)
                .addGap(1, 1, 1)
                .addComponent(jBtSalvar)
                .addGap(1, 1, 1)
                .addComponent(jBtCancelar)
                .addGap(1, 1, 1)
                .addComponent(jBtSair)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtBiometria, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtConsultaMovimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterar, jBtExcluir, jBtNovo, jBtSalvar});

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAuditoria, jBtBiometria, jBtConsultaMovimentacao});

        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtNovo, javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtAlterar, javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtExcluir, javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtSalvar, javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtCancelar, javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtSair, javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtBiometria, javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtConsultaMovimentacao, javax.swing.GroupLayout.Alignment.CENTER))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtAuditoria)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterar, jBtCancelar, jBtExcluir, jBtNovo, jBtSair, jBtSalvar});

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAuditoria, jBtBiometria, jBtConsultaMovimentacao});

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filiação", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Nome da Mãe:");

        jNomeMae.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeMae.setEnabled(false);

        jNomePai.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomePai.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Nome do Pai:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Religião:");

        jReligiao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jReligiao.setEnabled(false);

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel55.setText("Tipo Sanguíneo:");

        jTipoSang.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTipoSang.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTipoSang.setEnabled(false);

        jLabel72.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(255, 0, 0));
        jLabel72.setText("*");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel72)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11))))
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jNomePai)
                    .addComponent(jNomeMae)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jReligiao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel55)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTipoSang, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jNomeMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel72))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jNomePai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(jReligiao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel55)
                        .addComponent(jTipoSang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.setForeground(new java.awt.Color(51, 204, 0));
        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Departamento:");

        jDepartamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDepartamento.setEnabled(false);

        jBtPesqDepto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqDepto.setContentAreaFilled(false);
        jBtPesqDepto.setEnabled(false);
        jBtPesqDepto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqDeptoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Cargo:");

        jNomeCargo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeCargo.setEnabled(false);

        jBtPesqCargo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqCargo.setContentAreaFilled(false);
        jBtPesqCargo.setEnabled(false);
        jBtPesqCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqCargoActionPerformed(evt);
            }
        });

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 0, 0));
        jLabel54.setText("*");

        jLabel69.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 0, 0));
        jLabel69.setText("*");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel54)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel69)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jNomeCargo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jDepartamento, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqDepto, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4)
                    .addComponent(jDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqDepto)
                    .addComponent(jLabel69))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtPesqCargo)
                    .addComponent(jNomeCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel54))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel14Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jDepartamento, jNomeCargo});

        jTabbedPane2.addTab("Departamento/Cargo", jPanel14);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Carga Horária:");

        jCargaHoraria.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCargaHoraria.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCargaHoraria.setEnabled(false);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Turma:");

        jComboBoxRegimeTrabalho.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxRegimeTrabalho.setForeground(new java.awt.Color(153, 0, 102));
        jComboBoxRegimeTrabalho.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "ADM", "A", "B", "C", "D", " " }));
        jComboBoxRegimeTrabalho.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxRegimeTrabalho.setEnabled(false);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Horário:");

        jHorarioFinal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHorarioFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jHorarioFinal.setEnabled(false);

        jHorarioInicio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHorarioInicio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jHorarioInicio.setEnabled(false);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Função:");

        jFuncao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jFuncao.setEnabled(false);

        jLabel78.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(255, 0, 0));
        jLabel78.setText("*");

        jLabel79.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(255, 0, 0));
        jLabel79.setText("*");

        jLabel80.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(255, 0, 0));
        jLabel80.setText("*");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jCargaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel80)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxRegimeTrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel78)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jHorarioInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jHorarioFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel79)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jFuncao))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel17)
                    .addComponent(jComboBoxRegimeTrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel78)
                    .addComponent(jLabel18)
                    .addComponent(jHorarioInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jHorarioFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel79)
                    .addComponent(jLabel80)
                    .addComponent(jCargaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel16Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jHorarioFinal, jHorarioInicio});

        jTabbedPane2.addTab("Carga Horária", jPanel16);

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel42.setText("Nacionalidade");

        jComboBoxNacionalidade.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxNacionalidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Brasileira", "Estrangeira" }));
        jComboBoxNacionalidade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxNacionalidade.setEnabled(false);

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel52.setText("País");

        jPais.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPais.setEnabled(false);

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel42)
                    .addComponent(jComboBoxNacionalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel52)
                    .addComponent(jPais, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(jLabel52))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxNacionalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Nacionalidade", jPanel23);

        jNaturalidade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNaturalidade.setEnabled(false);

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel53.setText("Cidade");

        jLabel68.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel68.setText("Estado");

        jComboBoxEstadoNaturalidade.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxEstadoNaturalidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "AC", "AL", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        jComboBoxEstadoNaturalidade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxEstadoNaturalidade.setEnabled(false);

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel53)
                    .addComponent(jNaturalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(jLabel68)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jComboBoxEstadoNaturalidade, 0, 104, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(jLabel68))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jNaturalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxEstadoNaturalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Naturalidade", jPanel24);

        jLabel81.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(204, 0, 0));
        jLabel81.setText("(*) - Campos obrigatórios");

        javax.swing.GroupLayout jManutencaoLayout = new javax.swing.GroupLayout(jManutencao);
        jManutencao.setLayout(jManutencaoLayout);
        jManutencaoLayout.setHorizontalGroup(
            jManutencaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jManutencaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jManutencaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jManutencaoLayout.createSequentialGroup()
                        .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jManutencaoLayout.setVerticalGroup(
            jManutencaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jManutencaoLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel81)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        jTabbedPane1.addTab("Manutenção", jManutencao);

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Logradouro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), java.awt.Color.blue)); // NOI18N

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel56.setText("Endereço:");

        jEndereco.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jEndereco.setEnabled(false);

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel57.setText("Bairro:");

        jBairro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jBairro.setEnabled(false);

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel58.setText("Cidade:");

        jCidade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCidade.setEnabled(false);

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel59.setText("Estado:");

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel60.setText("C.E.P:");

        jCep.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCep.setEnabled(false);

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel61.setText("Comp:");

        jComplemento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComplemento.setEnabled(false);

        jComboBoxEstado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "AC", "AL", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        jComboBoxEstado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxEstado.setEnabled(false);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel58, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel61, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel57, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel56, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel59)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel60)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCep))
                    .addComponent(jComplemento)
                    .addComponent(jBairro)
                    .addComponent(jEndereco))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(jEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(jBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61)
                    .addComponent(jComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(jCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel59)
                    .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel60)
                    .addComponent(jCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel15Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBairro, jComplemento, jEndereco});

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contatos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        jLabel65.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel65.setText("E-mail:");

        jEmail.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jEmail.setEnabled(false);

        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel63.setText("Telefone:");

        jTelefone.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTelefone.setEnabled(false);

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel62.setText("Telefone:");

        jTelefoneEnd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTelefoneEnd.setEnabled(false);

        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel64.setText("Celular:");

        jCelularEnd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCelularEnd.setEnabled(false);

        jLabel66.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel66.setText("URL:");

        jURL.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jURL.setEnabled(false);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel66, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel63, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel65, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addComponent(jLabel62)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTelefoneEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel64)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCelularEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jURL)
                    .addComponent(jEmail))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel10Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jCelularEnd, jTelefone, jTelefoneEnd});

        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel65)
                    .addComponent(jEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel63)
                    .addComponent(jTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel62)
                    .addComponent(jTelefoneEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel64)
                    .addComponent(jCelularEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel66)
                    .addComponent(jURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Observação", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 153, 51))); // NOI18N

        jObservacao.setColumns(20);
        jObservacao.setRows(5);
        jObservacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jObservacao.setEnabled(false);
        jScrollPane2.setViewportView(jObservacao);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 51, 255))); // NOI18N

        jBtNovoLogradouro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoLogradouro.setText("Novo");
        jBtNovoLogradouro.setContentAreaFilled(false);
        jBtNovoLogradouro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovoLogradouro.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovoLogradouro.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovoLogradouro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoLogradouroActionPerformed(evt);
            }
        });

        jBtAlterarLogradouro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarLogradouro.setText("Alterar");
        jBtAlterarLogradouro.setContentAreaFilled(false);
        jBtAlterarLogradouro.setEnabled(false);
        jBtAlterarLogradouro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterarLogradouro.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarLogradouro.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarLogradouro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarLogradouroActionPerformed(evt);
            }
        });

        jBtExcluirLogradouro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirLogradouro.setText("Excluir");
        jBtExcluirLogradouro.setContentAreaFilled(false);
        jBtExcluirLogradouro.setEnabled(false);
        jBtExcluirLogradouro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluirLogradouro.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirLogradouro.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirLogradouro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirLogradouroActionPerformed(evt);
            }
        });

        jBtSalvarLogradouro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarLogradouro.setText("Gravar");
        jBtSalvarLogradouro.setContentAreaFilled(false);
        jBtSalvarLogradouro.setEnabled(false);
        jBtSalvarLogradouro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvarLogradouro.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarLogradouro.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarLogradouro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarLogradouroActionPerformed(evt);
            }
        });

        jBtCancelarLogradouro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarLogradouro.setText("Cancelar");
        jBtCancelarLogradouro.setContentAreaFilled(false);
        jBtCancelarLogradouro.setEnabled(false);
        jBtCancelarLogradouro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelarLogradouro.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarLogradouro.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarLogradouro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarLogradouroActionPerformed(evt);
            }
        });

        jBtSairLogradouro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSairLogradouro.setText("Sair");
        jBtSairLogradouro.setContentAreaFilled(false);
        jBtSairLogradouro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSairLogradouro.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSairLogradouro.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSairLogradouro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairLogradouroActionPerformed(evt);
            }
        });

        jBtAuditoriaLogradouro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaLogradouro.setToolTipText("Auditoria");
        jBtAuditoriaLogradouro.setContentAreaFilled(false);
        jBtAuditoriaLogradouro.setEnabled(false);
        jBtAuditoriaLogradouro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaLogradouroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jBtNovoLogradouro)
                .addGap(1, 1, 1)
                .addComponent(jBtAlterarLogradouro)
                .addGap(1, 1, 1)
                .addComponent(jBtExcluirLogradouro)
                .addGap(1, 1, 1)
                .addComponent(jBtSalvarLogradouro)
                .addGap(1, 1, 1)
                .addComponent(jBtCancelarLogradouro)
                .addGap(1, 1, 1)
                .addComponent(jBtSairLogradouro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel11Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterarLogradouro, jBtExcluirLogradouro, jBtNovoLogradouro, jBtSalvarLogradouro});

        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jBtSairLogradouro, javax.swing.GroupLayout.Alignment.CENTER)
            .addComponent(jBtAuditoriaLogradouro, javax.swing.GroupLayout.Alignment.CENTER)
            .addComponent(jBtCancelarLogradouro, javax.swing.GroupLayout.Alignment.CENTER)
            .addComponent(jBtSalvarLogradouro, javax.swing.GroupLayout.Alignment.CENTER)
            .addComponent(jBtExcluirLogradouro, javax.swing.GroupLayout.Alignment.CENTER)
            .addComponent(jBtAlterarLogradouro, javax.swing.GroupLayout.Alignment.CENTER)
            .addComponent(jBtNovoLogradouro, javax.swing.GroupLayout.Alignment.CENTER)
        );

        jPanel11Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterarLogradouro, jBtExcluirLogradouro, jBtNovoLogradouro, jBtSalvarLogradouro});

        javax.swing.GroupLayout jLogradouroLayout = new javax.swing.GroupLayout(jLogradouro);
        jLogradouro.setLayout(jLogradouroLayout);
        jLogradouroLayout.setHorizontalGroup(
            jLogradouroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLogradouroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLogradouroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jLogradouroLayout.setVerticalGroup(
            jLogradouroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLogradouroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("Endereço", jLogradouro);

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Documentos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 102, 0))); // NOI18N

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setText("RG:");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel28.setText(" Emissão:");

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel30.setText("CPF:");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel31.setText("PIS:");

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel34.setText("Titulo:");

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel35.setText("Zona:");

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel38.setText("CTPS:");

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel39.setText("Série:");

        jRG.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jRG.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jRG.setEnabled(false);

        jCPF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCPF.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCPF.setEnabled(false);

        jPis.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPis.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPis.setEnabled(false);

        jTitulo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTitulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTitulo.setEnabled(false);

        jZona.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jZona.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jZona.setEnabled(false);

        jCTPS.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCTPS.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCTPS.setEnabled(false);

        jSerie.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jSerie.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jSerie.setEnabled(false);

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel40.setText("Reser:");

        jReservista.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jReservista.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jReservista.setEnabled(false);

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel43.setText("Cat:");

        jCategoria.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCategoria.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCategoria.setEnabled(false);

        jDataEmissaoRg.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataEmissaoRg.setEnabled(false);

        jSecao.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jSecao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jSecao.setEnabled(false);

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel36.setText("Seção:");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel29.setText("Órgão Exp:");

        jOrgaoEmissor.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jOrgaoEmissor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jOrgaoEmissor.setEnabled(false);

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel32.setText("Data Cada.:");

        jDataCadPis.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataCadPis.setEnabled(false);

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel37.setText("Habilitação:");

        jHabilita.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jHabilita.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHabilita.setEnabled(false);

        jCartaoSaude.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCartaoSaude.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCartaoSaude.setEnabled(false);

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel44.setText("C. Saúde:");

        jComboBoxEstadoOrgao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxEstadoOrgao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "AC", "AL", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        jComboBoxEstadoOrgao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxEstadoOrgao.setEnabled(false);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel40, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRG, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCPF)
                    .addComponent(jTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(jCTPS)
                    .addComponent(jReservista, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel43, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jZona, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                            .addComponent(jSerie)
                            .addComponent(jCategoria)))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel28)
                            .addComponent(jLabel31))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPis, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                            .addComponent(jDataEmissaoRg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel44, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jHabilita, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSecao, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jDataCadPis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCartaoSaude, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jOrgaoEmissor, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxEstadoOrgao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel17Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jCartaoSaude, jDataCadPis, jHabilita, jSecao});

        jPanel17Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jCPF, jCTPS, jRG, jReservista, jTitulo});

        jPanel17Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jCategoria, jDataEmissaoRg, jPis, jSerie, jZona});

        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel29)
                    .addComponent(jOrgaoEmissor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxEstadoOrgao, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataEmissaoRg, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(jRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel30)
                    .addComponent(jCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31)
                    .addComponent(jPis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32)
                    .addComponent(jDataCadPis, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel34)
                    .addComponent(jTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35)
                    .addComponent(jZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36)
                    .addComponent(jSecao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel38)
                    .addComponent(jCTPS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39)
                    .addComponent(jSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37)
                    .addComponent(jHabilita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel40)
                    .addComponent(jReservista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43)
                    .addComponent(jCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44)
                    .addComponent(jCartaoSaude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Outros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), java.awt.Color.blue)); // NOI18N

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel45.setText("Profissão:");

        jProfissao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jProfissao.setEnabled(false);

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel46.setText("Carteira:");

        jCarteiraconselho.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCarteiraconselho.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCarteiraconselho.setEnabled(false);

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel47.setText("Altura:");

        jAltura.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAltura.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jAltura.setEnabled(false);

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel48.setText("Peso:");

        jPeso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPeso.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPeso.setEnabled(false);

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel49.setText("Calça:");

        jCalca.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCalca.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCalca.setEnabled(false);

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel50.setText("Camisa:");

        jCamisa.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCamisa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCamisa.setEnabled(false);

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel51.setText("Sapato:");

        jSapato.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jSapato.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jSapato.setEnabled(false);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel48, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel47, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPeso)
                            .addComponent(jAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel49))
                            .addComponent(jLabel50, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCalca)
                            .addComponent(jCamisa, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel46, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel51, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCarteiraconselho)
                            .addComponent(jSapato, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jProfissao, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(jProfissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(jAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49)
                    .addComponent(jCalca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel51)
                    .addComponent(jSapato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(jPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel50)
                    .addComponent(jCamisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46)
                    .addComponent(jCarteiraconselho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Conjugue", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(204, 0, 204))); // NOI18N

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Tipo de Conjugue:");

        jComboBoxTipoConjugue.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTipoConjugue.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Companheiro", "Companheira", "Esposo", "Esposa", "União Estavél", "Outros" }));
        jComboBoxTipoConjugue.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTipoConjugue.setEnabled(false);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Nome do Conjugue");

        jNomeConjugue.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeConjugue.setEnabled(false);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("Data Nascimento:");

        jDataNasConjugue.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataNasConjugue.setEnabled(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jNomeConjugue)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel20)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jComboBoxTipoConjugue, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                            .addComponent(jLabel22)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jDataNasConjugue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(22, 22, 22))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel20)
                    .addComponent(jComboBoxTipoConjugue, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(jDataNasConjugue, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel21)
                .addGap(4, 4, 4)
                .addComponent(jNomeConjugue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 51, 255))); // NOI18N

        jBtNovoDocumentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoDocumentos.setText("Novo");
        jBtNovoDocumentos.setContentAreaFilled(false);
        jBtNovoDocumentos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovoDocumentos.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovoDocumentos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovoDocumentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoDocumentosActionPerformed(evt);
            }
        });

        jBtAlterarDocumentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarDocumentos.setText("Alterar");
        jBtAlterarDocumentos.setContentAreaFilled(false);
        jBtAlterarDocumentos.setEnabled(false);
        jBtAlterarDocumentos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterarDocumentos.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarDocumentos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarDocumentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarDocumentosActionPerformed(evt);
            }
        });

        jBtExcluirDocumentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirDocumentos.setText("Excluir");
        jBtExcluirDocumentos.setContentAreaFilled(false);
        jBtExcluirDocumentos.setEnabled(false);
        jBtExcluirDocumentos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluirDocumentos.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirDocumentos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirDocumentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirDocumentosActionPerformed(evt);
            }
        });

        jBtSalvarDocumentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarDocumentos.setText("Gravar");
        jBtSalvarDocumentos.setContentAreaFilled(false);
        jBtSalvarDocumentos.setEnabled(false);
        jBtSalvarDocumentos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvarDocumentos.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarDocumentos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarDocumentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarDocumentosActionPerformed(evt);
            }
        });

        jBtCancelarDocumentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarDocumentos.setText("Cancelar");
        jBtCancelarDocumentos.setContentAreaFilled(false);
        jBtCancelarDocumentos.setEnabled(false);
        jBtCancelarDocumentos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelarDocumentos.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarDocumentos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarDocumentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarDocumentosActionPerformed(evt);
            }
        });

        jBtSairDocumentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSairDocumentos.setText("Sair");
        jBtSairDocumentos.setContentAreaFilled(false);
        jBtSairDocumentos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSairDocumentos.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSairDocumentos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSairDocumentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairDocumentosActionPerformed(evt);
            }
        });

        jBtAuditoriaDocumentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaDocumentos.setToolTipText("Auditoria");
        jBtAuditoriaDocumentos.setContentAreaFilled(false);
        jBtAuditoriaDocumentos.setEnabled(false);
        jBtAuditoriaDocumentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaDocumentosActionPerformed(evt);
            }
        });

        jBtImpressaoFichaColaborador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/gtklp-icone-3770-16.png"))); // NOI18N
        jBtImpressaoFichaColaborador.setToolTipText("Imprimir Ficha do Colaborador");
        jBtImpressaoFichaColaborador.setContentAreaFilled(false);
        jBtImpressaoFichaColaborador.setEnabled(false);
        jBtImpressaoFichaColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtImpressaoFichaColaboradorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(jBtNovoDocumentos)
                .addGap(1, 1, 1)
                .addComponent(jBtAlterarDocumentos)
                .addGap(1, 1, 1)
                .addComponent(jBtExcluirDocumentos)
                .addGap(1, 1, 1)
                .addComponent(jBtSalvarDocumentos)
                .addGap(1, 1, 1)
                .addComponent(jBtCancelarDocumentos)
                .addGap(1, 1, 1)
                .addComponent(jBtSairDocumentos)
                .addGap(18, 18, 18)
                .addComponent(jBtImpressaoFichaColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaDocumentos, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel19Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterarDocumentos, jBtExcluirDocumentos, jBtNovoDocumentos, jBtSalvarDocumentos});

        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtAuditoriaDocumentos)
                    .addComponent(jBtImpressaoFichaColaborador)))
            .addComponent(jBtSairDocumentos, javax.swing.GroupLayout.Alignment.CENTER)
            .addComponent(jBtCancelarDocumentos, javax.swing.GroupLayout.Alignment.CENTER)
            .addComponent(jBtSalvarDocumentos, javax.swing.GroupLayout.Alignment.CENTER)
            .addComponent(jBtExcluirDocumentos, javax.swing.GroupLayout.Alignment.CENTER)
            .addComponent(jBtAlterarDocumentos, javax.swing.GroupLayout.Alignment.CENTER)
            .addComponent(jBtNovoDocumentos, javax.swing.GroupLayout.Alignment.CENTER)
        );

        javax.swing.GroupLayout jDocumentosLayout = new javax.swing.GroupLayout(jDocumentos);
        jDocumentos.setLayout(jDocumentosLayout);
        jDocumentosLayout.setHorizontalGroup(
            jDocumentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDocumentosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDocumentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jDocumentosLayout.setVerticalGroup(
            jDocumentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDocumentosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("Documentos", jDocumentos);

        jTabbedPane3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setText("Código");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setText("Nome do Dependente");

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel33.setText("Parentesco");

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel41.setText("Dt. Nascimento");

        jCodigoDependente.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodigoDependente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCodigoDependente.setEnabled(false);

        jNomeDependente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeDependente.setEnabled(false);

        jDataNascimentoParentesco.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataNascimentoParentesco.setEnabled(false);

        jComboBoxParentesco.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxParentesco.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Avó", "Avô", "Companheira", "Companheiro", "Cunhada", "Cunhado", "Enteada", "Enteado", "Esposa", "Esposo", "Filha", "Filho", "Irmã", "Irmão", "Mãe", "Pai", "Sobrinha", "Sobrinho", "Tia", "Tio", "Outros" }));
        jComboBoxParentesco.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxParentesco.setEnabled(false);

        jLabel76.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 0, 0));
        jLabel76.setText("*");

        jLabel77.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(255, 0, 0));
        jLabel77.setText("*");

        jLabel75.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(255, 0, 0));
        jLabel75.setText("*");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel76))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCodigoDependente, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel25))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel21Layout.createSequentialGroup()
                                        .addComponent(jLabel33)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel75)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jComboBoxParentesco, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel41)
                                    .addComponent(jDataNascimentoParentesco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jNomeDependente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel77)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel25)
                        .addComponent(jLabel33)
                        .addComponent(jLabel75))
                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel41)
                        .addComponent(jLabel77)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jCodigoDependente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataNascimentoParentesco, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxParentesco, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel76))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNomeDependente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jBtNovoDependente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_white_star.png"))); // NOI18N
        jBtNovoDependente.setToolTipText("Novo");
        jBtNovoDependente.setEnabled(false);
        jBtNovoDependente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoDependenteActionPerformed(evt);
            }
        });

        jBtAlterarDependente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/refresh-reload-icone-6258-16.png"))); // NOI18N
        jBtAlterarDependente.setToolTipText("Alterar");
        jBtAlterarDependente.setEnabled(false);
        jBtAlterarDependente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarDependenteActionPerformed(evt);
            }
        });

        jBtExcluirDependente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirDependente.setToolTipText("Excluir");
        jBtExcluirDependente.setEnabled(false);
        jBtExcluirDependente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirDependenteActionPerformed(evt);
            }
        });

        jBtSalvarDependente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarDependente.setToolTipText("Gravar");
        jBtSalvarDependente.setEnabled(false);
        jBtSalvarDependente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarDependenteActionPerformed(evt);
            }
        });

        jBtCancelarDependente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarDependente.setToolTipText("Cancelar");
        jBtCancelarDependente.setEnabled(false);
        jBtCancelarDependente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarDependenteActionPerformed(evt);
            }
        });

        jBtAuditoriaDependente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaDependente.setToolTipText("Auditoria");
        jBtAuditoriaDependente.setContentAreaFilled(false);
        jBtAuditoriaDependente.setEnabled(false);
        jBtAuditoriaDependente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaDependenteActionPerformed(evt);
            }
        });

        jLabel71.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(255, 0, 0));
        jLabel71.setText("Campos obrigatórios (*)");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtNovoDependente, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jBtAlterarDependente, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jBtExcluirDependente, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jBtSalvarDependente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jBtCancelarDependente, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jBtAuditoriaDependente, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel22Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterarDependente, jBtCancelarDependente, jBtExcluirDependente, jBtNovoDependente, jBtSalvarDependente});

        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtNovoDependente)
                    .addComponent(jBtAlterarDependente)
                    .addComponent(jBtExcluirDependente)
                    .addComponent(jBtSalvarDependente)
                    .addComponent(jBtCancelarDependente)
                    .addComponent(jLabel71)
                    .addComponent(jBtAuditoriaDependente))
                .addGap(3, 3, 3))
        );

        jPanel22Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterarDependente, jBtCancelarDependente, jBtExcluirDependente, jBtNovoDependente, jBtSalvarDependente});

        jTabelaDependentes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaDependentes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome do Dependente", "Nascimento", "Parentesco"
            }
        ));
        jTabelaDependentes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaDependentesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTabelaDependentes);
        if (jTabelaDependentes.getColumnModel().getColumnCount() > 0) {
            jTabelaDependentes.getColumnModel().getColumn(0).setMinWidth(60);
            jTabelaDependentes.getColumnModel().getColumn(0).setMaxWidth(60);
            jTabelaDependentes.getColumnModel().getColumn(1).setMinWidth(250);
            jTabelaDependentes.getColumnModel().getColumn(1).setMaxWidth(250);
            jTabelaDependentes.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaDependentes.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaDependentes.getColumnModel().getColumn(3).setMinWidth(180);
            jTabelaDependentes.getColumnModel().getColumn(3).setMaxWidth(180);
        }

        jPanel33.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jLabel82.setText("Total de Registros:");

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel82))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel82)
        );

        jPanel34.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        jPanel35.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jtotalItens.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalItens, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalItens, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDependentesLayout = new javax.swing.GroupLayout(jDependentes);
        jDependentes.setLayout(jDependentesLayout);
        jDependentesLayout.setHorizontalGroup(
            jDependentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDependentesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDependentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jDependentesLayout.createSequentialGroup()
                        .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDependentesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDependentesLayout.createSequentialGroup()
                        .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jDependentesLayout.setVerticalGroup(
            jDependentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDependentesLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addGroup(jDependentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        jTabbedPane3.addTab("Dependentes", jDependentes);

        jPanel27.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel83.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel83.setText("Código");

        jLabel84.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel84.setText("Descrição da Escala");

        jLabel85.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel85.setText("Qtd. Trab.");

        jLabel86.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel86.setText("Qtd. Folga");

        jLabel87.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel87.setText("Turno");

        jCodigoEscala.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCodigoEscala.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodigoEscala.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCodigoEscala.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jCodigoEscala.setEnabled(false);

        jQtdTrabalho.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jQtdTrabalho.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jQtdTrabalho.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQtdTrabalho.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jQtdTrabalho.setEnabled(false);

        jQtdFolga.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jQtdFolga.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jQtdFolga.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQtdFolga.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jQtdFolga.setEnabled(false);

        jTurnoEscala.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTurnoEscala.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTurnoEscala.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTurnoEscala.setEnabled(false);

        jLabel88.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel88.setText("Turma");

        jTurmaEscala.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTurmaEscala.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTurmaEscala.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTurmaEscala.setEnabled(false);

        jLabel89.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel89.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/X.png"))); // NOI18N

        jComboBoxDescricaoEscala.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDescricaoEscala.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione..." }));
        jComboBoxDescricaoEscala.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDescricaoEscala.setEnabled(false);
        jComboBoxDescricaoEscala.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxDescricaoEscalaItemStateChanged(evt);
            }
        });

        jLabel90.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel90.setText("Departamento:");

        jLabel91.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel91.setText("Cargo:");

        jDepartamentoEscala.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jDepartamentoEscala.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDepartamentoEscala.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jDepartamentoEscala.setEnabled(false);

        jNomeCargoEscala.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jNomeCargoEscala.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeCargoEscala.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jNomeCargoEscala.setEnabled(false);

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel27Layout.createSequentialGroup()
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel91)
                            .addComponent(jLabel90))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jNomeCargoEscala)
                            .addComponent(jDepartamentoEscala)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel27Layout.createSequentialGroup()
                            .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel83)
                                .addComponent(jCodigoEscala, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBoxDescricaoEscala, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel27Layout.createSequentialGroup()
                            .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel27Layout.createSequentialGroup()
                                    .addComponent(jQtdTrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel89)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel27Layout.createSequentialGroup()
                                    .addComponent(jLabel85, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(32, 32, 32)))
                            .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel27Layout.createSequentialGroup()
                                    .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE))
                                .addComponent(jQtdFolga))
                            .addGap(9, 9, 9)
                            .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel87)
                                .addComponent(jTurnoEscala, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel88)
                                .addComponent(jTurmaEscala, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(31, 31, 31))
        );

        jPanel27Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jCodigoEscala, jQtdTrabalho});

        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel83)
                    .addComponent(jLabel84))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCodigoEscala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxDescricaoEscala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel85)
                        .addComponent(jLabel86))
                    .addComponent(jLabel88)
                    .addComponent(jLabel87))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTurnoEscala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jQtdTrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel89)
                    .addComponent(jQtdFolga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTurmaEscala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel90)
                    .addComponent(jDepartamentoEscala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jNomeCargoEscala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel91))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel28.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtNovaEscala.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovaEscala.setText("Novo");
        jBtNovaEscala.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        jBtNovaEscala.setEnabled(false);
        jBtNovaEscala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovaEscalaActionPerformed(evt);
            }
        });

        jBtAlterarEscala.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarEscala.setText("Alterar");
        jBtAlterarEscala.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        jBtAlterarEscala.setEnabled(false);
        jBtAlterarEscala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarEscalaActionPerformed(evt);
            }
        });

        jBtExcluirEscala.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216104515_16.png"))); // NOI18N
        jBtExcluirEscala.setText("Excluir");
        jBtExcluirEscala.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        jBtExcluirEscala.setEnabled(false);
        jBtExcluirEscala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirEscalaActionPerformed(evt);
            }
        });

        jBtSalvarEscala.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarEscala.setText("Gravar");
        jBtSalvarEscala.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        jBtSalvarEscala.setEnabled(false);
        jBtSalvarEscala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarEscalaActionPerformed(evt);
            }
        });

        jBtCancelarEscala.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarEscala.setText("Cancelar");
        jBtCancelarEscala.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        jBtCancelarEscala.setEnabled(false);
        jBtCancelarEscala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarEscalaActionPerformed(evt);
            }
        });

        jBtAuditoriaEscala.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaEscala.setToolTipText("Auditoria");
        jBtAuditoriaEscala.setContentAreaFilled(false);
        jBtAuditoriaEscala.setEnabled(false);
        jBtAuditoriaEscala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaEscalaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtNovaEscala, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtAlterarEscala)
                .addGap(1, 1, 1)
                .addComponent(jBtExcluirEscala)
                .addGap(1, 1, 1)
                .addComponent(jBtSalvarEscala)
                .addGap(1, 1, 1)
                .addComponent(jBtCancelarEscala, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaEscala, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel28Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterarEscala, jBtCancelarEscala, jBtExcluirEscala, jBtNovaEscala, jBtSalvarEscala});

        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtNovaEscala, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtAlterarEscala)
                    .addComponent(jBtExcluirEscala)
                    .addComponent(jBtSalvarEscala)
                    .addComponent(jBtCancelarEscala)
                    .addComponent(jBtAuditoriaEscala))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel28Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterarEscala, jBtCancelarEscala, jBtExcluirEscala, jBtNovaEscala, jBtSalvarEscala});

        jPanel29.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtCronogramaEscala.setForeground(new java.awt.Color(0, 102, 0));
        jBtCronogramaEscala.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/calendar_add.png"))); // NOI18N
        jBtCronogramaEscala.setText("CRONOGRAMA");
        jBtCronogramaEscala.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        jBtCronogramaEscala.setEnabled(false);
        jBtCronogramaEscala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCronogramaEscalaActionPerformed(evt);
            }
        });

        jBtImprimeEscala.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/gtklp-icone-3770-16.png"))); // NOI18N
        jBtImprimeEscala.setText("IMPRIMIR CRONOGRAMA");
        jBtImprimeEscala.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        jBtImprimeEscala.setEnabled(false);

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtCronogramaEscala, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtImprimeEscala, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel29Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtCronogramaEscala, jBtImprimeEscala});

        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtImprimeEscala)
                    .addComponent(jBtCronogramaEscala, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel29Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtCronogramaEscala, jBtImprimeEscala});

        jPanel36.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDadosEscalaLayout = new javax.swing.GroupLayout(jDadosEscala);
        jDadosEscala.setLayout(jDadosEscalaLayout);
        jDadosEscalaLayout.setHorizontalGroup(
            jDadosEscalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDadosEscalaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDadosEscalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, 527, Short.MAX_VALUE)
                    .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jDadosEscalaLayout.setVerticalGroup(
            jDadosEscalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDadosEscalaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Dados da Escala", jDadosEscala);

        javax.swing.GroupLayout jDependentesEscalaLayout = new javax.swing.GroupLayout(jDependentesEscala);
        jDependentesEscala.setLayout(jDependentesEscalaLayout);
        jDependentesEscalaLayout.setHorizontalGroup(
            jDependentesEscalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDependentesEscalaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3)
                .addContainerGap())
        );
        jDependentesEscalaLayout.setVerticalGroup(
            jDependentesEscalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDependentesEscalaLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jTabbedPane3))
        );

        jTabbedPane1.addTab("Dependentes/Escala", jDependentesEscala);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 517, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBounds(250, 20, 587, 547);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaColaboradoresFC_ADM);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoADM.equals("ADMINISTRADORES") || codigoUserADM == codUserAcessoADM && nomeTelaADM.equals(telaColaboradoresFC_ADM) && codIncluirADM == 1) {
            acao = 1;
            Novo();
            corCampo();
            limparCamposEscala();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaColaboradoresFC_ADM);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoADM.equals("ADMINISTRADORES") || codigoUserADM == codUserAcessoADM && nomeTelaADM.equals(telaColaboradoresFC_ADM) && codAlterarADM == 1) {
            acao = 2;
            Alterar();
            corCampo();
            statusMov = "Alterou";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtAlterarActionPerformed

    private void jBtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirActionPerformed
        // TODO add your handling code here: 
        buscarAcessoUsuario(telaColaboradoresFC_ADM);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoADM.equals("ADMINISTRADORES") || codigoUserADM == codUserAcessoADM && nomeTelaADM.equals(telaColaboradoresFC_ADM) && codExcluirADM == 1) {
            //VERIFICAR SE EXISTE REGISTRO NA TABELA CRONOGRAMA_ESCALA_TRABALHO_FOLGA_COLABORADOR
            PESQUISAR_COLABORADOR_escala();
            if (jIDFunc.getText().equals(pCODIGO_PESQUISA_func)) {
                JOptionPane.showMessageDialog(rootPane, "Não é possível excluir o registro selecionado, existe outros registros associados a esse colaborador na tabela de ESCALAS DE TRABALHO.");
            } else {
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM ITENSENTRADASFUNC "
                            + "WHERE IdFunc='" + jIDFunc.getText() + "'ORDER BY IdFunc");
                    conecta.rs.first();
                    idFunc = conecta.rs.getString("IdFunc");
                    //
                    conecta.executaSQL("SELECT * FROM DEPENDENTES "
                            + "WHERE IdFunc='" + jIDFunc.getText() + "'");
                    conecta.rs.first();
                    codFuncDep = conecta.rs.getString("IdFunc");
                } catch (SQLException ex) {
                }
                if (jIDFunc.getText().equals(idFunc)) {
                    JOptionPane.showMessageDialog(rootPane, "Esse colaborador não pode ser excluído,\no mesmo está sendo utilizado em outro registro.");
                } else if (jIDFunc.getText().equals(codFuncDep)) {
                    JOptionPane.showMessageDialog(null, "Esse Colaborador não poderá ser excluído, existe DEPENDENTES relacionados a ele.\nExclua TODOS os DEPENDENTES relacionados a ele para poder excluir.");
                } else {
                    statusMov = "Excluiu";
                    horaMov = jHoraSistema.getText();
                    dataModFinal = jDataSistema.getText();
                    int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir COLABORADOR selecionado?", "Confirmação",
                            JOptionPane.YES_NO_OPTION);
                    if (resposta == JOptionPane.YES_OPTION) {
                        // EXCLUIR O DOCUMENTO
                        objDoc.setIdFunc(Integer.valueOf(jIDFunc.getText()));
                        objDoc.setIdDoc(codDoc);
                        controleDoc.excluirDocumentosColaborador(objDoc);
                        // EXCLUIR ENDEREÇO
                        objEnd.setIdFunc(Integer.valueOf(jIDFunc.getText()));
                        objEnd.setIdEnd(codEnd);
                        controle.excluiEnderecosColaborador(objEnd);
                        //
                        objCola.setIdFunc(Integer.valueOf(jIDFunc.getText()));
                        control.excluirColaborador(objCola);
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        Excluir();
                        JOptionPane.showMessageDialog(rootPane, "Colaborador excluido com sucesso.");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaColaboradoresFC_ADM);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoADM.equals("ADMINISTRADORES") || codigoUserADM == codUserAcessoADM && nomeTelaADM.equals(telaColaboradoresFC_ADM) && codGravarADM == 1) {
            if (jNomeFuncionario.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Informe o nome do Colaborador.");
                jNomeFuncionario.requestFocus();
                jNomeFuncionario.setBackground(Color.red);
            } else if (jDataAdmissao.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data de Admissão.");
                jDataAdmissao.requestFocus();
                jDataAdmissao.setBackground(Color.red);
            } else if (jNomeMae.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome da mãe do colaborador.");
                jNomeMae.requestFocus();
                jNomeMae.setBackground(Color.red);
            } else if (jDepartamento.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome do departamento.");
                jDepartamento.requestFocus();
                jDepartamento.setBackground(Color.red);
            } else if (jNomeCargo.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome do cargo.");
                jNomeCargo.requestFocus();
                jNomeCargo.setBackground(Color.red);
            } else if (jComboBoxRegimeTrabalho.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a turma do colaborador.");
                jComboBoxRegimeTrabalho.requestFocus();
                jComboBoxRegimeTrabalho.setBackground(Color.red);
            } else if (jComboBoxRegimeTrabalho.getSelectedItem().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe a turma do colaborador.");
                jComboBoxRegimeTrabalho.requestFocus();
                jComboBoxRegimeTrabalho.setBackground(Color.red);
            } else if (jComboBoxRegimeTrabalho.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(rootPane, "Informe a turma do colaborador.");
                jComboBoxRegimeTrabalho.requestFocus();
                jComboBoxRegimeTrabalho.setBackground(Color.red);
            } else if (jHorarioInicio.getText().equals("") || jHorarioInicio.getText().equals("00:00") || jHorarioInicio.getText().equals(" : ")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o horário inicial do colaborador.");
                jHorarioInicio.requestFocus();
                jHorarioInicio.setBackground(Color.red);
            } else if (jHorarioInicio.getText().equals("") || jHorarioFinal.getText().equals("00:00") || jHorarioFinal.getText().equals(" : ")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o horário inicial do colaborador.");
                jHorarioInicio.requestFocus();
                jHorarioInicio.setBackground(Color.red);
            } else if (jCargaHoraria.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe a carga horária do colaborador.");
                jCargaHoraria.requestFocus();
                jCargaHoraria.setBackground(Color.red);
            } else if (caminhoFotoFunc == null) {
                JOptionPane.showMessageDialog(rootPane, "Insira a foto do colaborador");
                jFotoColaborador.requestFocus();
            } else {
                // DADOS DO COLABORADOR (MANUTENÇÃO)
                objCola.setStatusFunc((String) jComboBoxStatusFunc.getSelectedItem());
                objCola.setDataCadastro(jDataAdmissao.getDate());
                objCola.setNomeFuncionario(jNomeFuncionario.getText().trim());
                objCola.setMatricula(jMatricula.getText());
                objCola.setSexo((String) jComboBoxSexo.getSelectedItem());
                objCola.setEscolaridade((String) jComboBoxEscolaridade.getSelectedItem());
                objCola.setEstadoCivil((String) jComboBoxEstadoCivil.getSelectedItem());
                objCola.setDataNascimento(jDataNascimento.getDate());
                objCola.setFoto(caminhoFotoFunc);
                objCola.setNomeMae(jNomeMae.getText().trim());
                objCola.setNomePai(jNomePai.getText());
                objCola.setReligiao(jReligiao.getText());
                objCola.setTipoSangue(jTipoSang.getText());
                objCola.setNomeDepartamento(jDepartamento.getText());
                objCola.setNomeCargo(jNomeCargo.getText());
                objCola.setCargaHoraria(jCargaHoraria.getText());
                objCola.setRegimeTrabalho((String) jComboBoxRegimeTrabalho.getSelectedItem());
                objCola.setHorarioInicio(jHorarioInicio.getText());
                objCola.setHorarioFinal(jHorarioFinal.getText());
                objCola.setFuncao(jFuncao.getText());
                objCola.setNacionalidade((String) jComboBoxNacionalidade.getSelectedItem());
                objCola.setPais(jPais.getText());
                objCola.setNaturalidade(jNaturalidade.getText());
                objCola.setEstadoNacionalidade((String) jComboBoxEstadoNaturalidade.getSelectedItem());
                // PREPARAR FOTO PARA GRAVAR NO BANCO DE DADOS - FOTO DE FRENTE   
                if (jFotoColaborador.getIcon() != null) {
                    objCola.setImagemFrenteCO(persona_imagem);
                }
                // DADOS DO ENDEREÇO
                objEnd.setEndereco(jEndereco.getText());
                objEnd.setBairroEnd(jBairro.getText());
                objEnd.setCompEnd(jComplemento.getText());
                objEnd.setCidadeEnd(jCidade.getText());
                objEnd.setEstadoEnd((String) jComboBoxEstado.getSelectedItem());
                objEnd.setCepEnd(jCep.getText());
                objEnd.setTelEnd(jTelefone.getText());
                objEnd.setFoneEnd(jTelefoneEnd.getText());
                objEnd.setCelEnd(jCelularEnd.getText());
                objEnd.setEmalEnd(jEmail.getText());
                objEnd.setUrl(jURL.getText());
                objEnd.setObservacao(jObservacao.getText());
                // DADOS DO DOCUMENTO        
                objDoc.setRgDoc((jRG.getText()));
                objDoc.setDataEmissaoDoc(jDataEmissaoRg.getDate());
                objDoc.setOrgaoDoc(jOrgaoEmissor.getText());
                objDoc.setEstadoOrgao((String) jComboBoxEstadoOrgao.getSelectedItem());
                objDoc.setCpfDoc((jCPF.getText()));
                objDoc.setPisDoc((jPis.getText()));
                objDoc.setDataCadPisDoc(jDataCadPis.getDate());
                objDoc.setTituloDoc((jTitulo.getText()));
                objDoc.setZonaDoc((jZona.getText()));
                objDoc.setSecaoDoc((jSecao.getText()));
                objDoc.setCtpsDoc((jCTPS.getText()));
                objDoc.setSerieDoc(jSerie.getText());
                objDoc.setHabiliDoc(jHabilita.getText());
                objDoc.setReserVistaDoc((jReservista.getText()));
                objDoc.setCateDoc(jCategoria.getText());
                objDoc.setCartSaudeDoc(jCartaoSaude.getText());
                objDoc.setProfDoc(jProfissao.getText());
                objDoc.setAlturaDoc((jAltura.getText()));
                objDoc.setCalcaDoc((jCalca.getText()));
                objDoc.setSapatoDoc((jSapato.getText()));
                objDoc.setPesoDoc((jPeso.getText()));
                objDoc.setCamisaDoc((jCamisa.getText()));
                objDoc.setCarteiraDoc((jCarteiraconselho.getText()));
                objDoc.setTipoConjugue((String) jComboBoxTipoConjugue.getSelectedItem());
                objDoc.setDataNasConjugue(jDataNasConjugue.getDate());
                objDoc.setNomeConjugue(jNomeConjugue.getText());
                //                                
                verificarColaborador();
                if (acao == 1 && jNomeFuncionario.getText().trim().equals(nomeColaborador) && jNomeMae.getText().trim().equals(nomeMaeColaborador)) {
                    JOptionPane.showMessageDialog(rootPane, "Esse colaborador já foi cadastrada, verifique o cadastro do mesmo.");
                } else {
                    if (acao == 1) {
                        objCola.setUsuarioInsert(nameUser);
                        objCola.setDataInsert(dataModFinal);
                        objCola.setHorarioInsert(horaMov);
                        // INCLUIR COLABORADOR
                        control.incluirColaborador(objCola);
                        buscarCodFunc();
                        // INCLUIR ENDEREÇO
                        objEnd.setUsuarioInsert(nameUser);
                        objEnd.setDataInsert(dataModFinal);
                        objEnd.setHorarioInsert(horaMov);
                        objEnd.setIdFunc(Integer.valueOf(jIDFunc.getText()));
                        controle.incluirEnderecosColaborador(objEnd);
                        buscarCodEnd();
                        // INCLUIR DOCUMENTOS
                        objDoc.setUsuarioInsert(nameUser);
                        objDoc.setDataInsert(dataModFinal);
                        objDoc.setHorarioInsert(horaMov);
                        objDoc.setIdFunc(Integer.valueOf(jIDFunc.getText()));
                        controleDoc.incluirDocumentosColaborador(objDoc);
                        buscarCodDoc();
                        //
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        Salvar();
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    }
                }
                if (acao == 2) {
                    objCola.setUsuarioUp(nameUser);
                    objCola.setDataUp(dataModFinal);
                    objCola.setHorarioUp(horaMov);
                    // ALTERAR COLABORADOR
                    objCola.setNomeDepartamento(jDepartamento.getText());
                    objCola.setNomeCargo(jNomeCargo.getText());
                    objCola.setIdFunc(Integer.valueOf(jIDFunc.getText()));
                    control.alterarColaborador(objCola);
                    // ALTERAR ENDEREÇO
                    objEnd.setUsuarioUp(nameUser);
                    objEnd.setDataUp(dataModFinal);
                    objEnd.setHorarioUp(horaMov);
                    objEnd.setIdFunc(Integer.valueOf(jIDFunc.getText()));
                    objEnd.setIdEnd(codEnd);
                    controle.alterarEnderecoColaborador(objEnd);
                    // ALTERAR DOCUMENTOS
                    objDoc.setUsuarioUp(nameUser);
                    objDoc.setDataUp(dataModFinal);
                    objDoc.setHorarioUp(horaMov);
                    objDoc.setIdFunc(Integer.valueOf(jIDFunc.getText()));
                    objDoc.setIdDoc(codDoc);
                    controleDoc.alterarDocumentosColaborador(objDoc);
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
        Cancelar();
    }//GEN-LAST:event_jBtCancelarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtNovoFoto2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoFoto2ActionPerformed
        // CÓDIGO PARA O BOTÃO ABRIR IMAGEM
        // Cria o objeto Janela de Seleção de Arquivos
        JFileChooser chooser = new JFileChooser();
        int acao = chooser.showOpenDialog(this);
        if (acao == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            caminhoFotoFunc = f.getAbsolutePath();
            ImageIcon imagemicon = new ImageIcon(new ImageIcon(caminhoFotoFunc).getImage().getScaledInstance(jFotoColaborador.getWidth(), jFotoColaborador.getHeight(), Image.SCALE_SMOOTH));
            jFotoColaborador.setIcon(imagemicon);
            try {
                File image = new File(caminhoFotoFunc);
                FileInputStream fis = new FileInputStream(image);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                for (int readNum; (readNum = fis.read(buf)) != -1;) {
                    bos.write(buf, 0, readNum);
                }
                persona_imagem = bos.toByteArray();
            } catch (Exception e) {
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Seleção da figura cancelada.");
        }
    }//GEN-LAST:event_jBtNovoFoto2ActionPerformed

    private void jBtExcluirFoto2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirFoto2ActionPerformed
        // TODO add your handling code here:
        jFotoColaborador.setIcon(null);
    }//GEN-LAST:event_jBtExcluirFoto2ActionPerformed

    private void jBtPesqDeptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqDeptoActionPerformed
        // TODO add your handling code here:        
        TelaPesquisaDeptoFunc objDeptoFunc = new TelaPesquisaDeptoFunc();
        TelaModuloAdmPessoal.jPainelAdmPessoal.add(objDeptoFunc);
        objDeptoFunc.show();
    }//GEN-LAST:event_jBtPesqDeptoActionPerformed

    private void jBtPesqCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqCargoActionPerformed
        // TODO add your handling code here:
        TelaPesquisaCargoFunc objCargoFunc = new TelaPesquisaCargoFunc();
        TelaModuloAdmPessoal.jPainelAdmPessoal.add(objCargoFunc);
        objCargoFunc.show();
    }//GEN-LAST:event_jBtPesqCargoActionPerformed

    private void jBtPesqNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNomeActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        pesquisarFuncNome("SELECT * FROM COLABORADOR "
                + "INNER JOIN DEPARTAMENTOS "
                + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                + "INNER JOIN CARGOS "
                + "ON COLABORADOR.IdCargo=CARGOS.IdCargo "
                + "WHERE NomeFunc LIKE'%" + jPesqNome.getText() + "%'");
    }//GEN-LAST:event_jBtPesqNomeActionPerformed

    private void jTabelaFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaFuncionarioMouseClicked
        // TODO add your handling code here:   
        flag = 1;
        if (flag == 1) {
            String pIDFunc = "" + jTabelaFuncionario.getValueAt(jTabelaFuncionario.getSelectedRow(), 0);
            jCodigoPesqFunc.setText(pIDFunc);
            String nomeFunc = "" + jTabelaFuncionario.getValueAt(jTabelaFuncionario.getSelectedRow(), 3);
            jPesqNome.setText(nomeFunc);
            // MANUTENÇÃO
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            jBtBiometria.setEnabled(true);
            // ENDEREÇO
            jBtNovoLogradouro.setEnabled(true);
            jBtAlterarLogradouro.setEnabled(true);
            jBtExcluirLogradouro.setEnabled(true);
            jBtSalvarLogradouro.setEnabled(!true);
            jBtCancelarLogradouro.setEnabled(true);
            jBtAuditoriaLogradouro.setEnabled(true);
            // DOCUMENTOS
            jBtNovoDocumentos.setEnabled(true);
            jBtAlterarDocumentos.setEnabled(true);
            jBtExcluirDocumentos.setEnabled(true);
            jBtSalvarDocumentos.setEnabled(!true);
            jBtCancelarDocumentos.setEnabled(true);
            jBtAuditoriaDocumentos.setEnabled(true);
            jBtImpressaoFichaColaborador.setEnabled(true);
            // DEPENDENTES
            jBtNovoDependente.setEnabled(true);
            //
            limparCamposRegistro();
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM COLABORADOR "
                        + "INNER JOIN DEPARTAMENTOS "
                        + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                        + "INNER JOIN CARGOS "
                        + "ON COLABORADOR.IdCargo=CARGOS.IdCargo "
                        + "INNER JOIN ENDERECOS "
                        + "ON COLABORADOR.IdFunc=ENDERECOS.IdFunc "
                        + "INNER JOIN DOCUMENTOS "
                        + "ON COLABORADOR.IdFunc=DOCUMENTOS.IdFunc "
                        + "WHERE NomeFunc='" + jPesqNome.getText() + "'");
                conecta.rs.first();
                jIDFunc.setText(String.valueOf(conecta.rs.getInt("IdFunc")));
                jComboBoxStatusFunc.setSelectedItem(conecta.rs.getString("StatusFunc"));
                jDataAdmissao.setDate(conecta.rs.getDate("DataCadFunc"));
                jNomeFuncionario.setText(conecta.rs.getString("NomeFunc"));
                jMatricula.setText(conecta.rs.getString("MatriculaFunc"));
                jComboBoxSexo.setSelectedItem(conecta.rs.getString("SexoFunc"));
                jComboBoxEscolaridade.setSelectedItem(conecta.rs.getString("EscolaFunc"));
                jComboBoxEstadoCivil.setSelectedItem(conecta.rs.getString("EstadoCivil"));
                jDataNascimento.setDate(conecta.rs.getDate("DataNascimento"));
                // Capturando foto
                caminhoFotoFunc = conecta.rs.getString("ImagemFunc");
                if (caminhoFotoFunc != null) {
                    javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminhoFotoFunc);
                    jFotoColaborador.setIcon(i);
                    jFotoColaborador.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoColaborador.getWidth(), jFotoColaborador.getHeight(), Image.SCALE_SMOOTH)));
                }
                // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrenteCO"));
                if (imgBytes != null) {
                    ImageIcon pic = null;
                    pic = new ImageIcon(imgBytes);
                    Image scaled = pic.getImage().getScaledInstance(jFotoColaborador.getWidth(), jFotoColaborador.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon icon = new ImageIcon(scaled);
                    jFotoColaborador.setIcon(icon);
                }
                jNomeMae.setText(conecta.rs.getString("NomeMae"));
                jNomePai.setText(conecta.rs.getString("NomePai"));
                jReligiao.setText(conecta.rs.getString("Religiao"));
                jTipoSang.setText(conecta.rs.getString("TipoSangue"));
                jDepartamento.setText(conecta.rs.getString("NomeDepartamento"));
                jNomeCargo.setText(conecta.rs.getString("NomeCargo"));
                //
                jCargaHoraria.setText(conecta.rs.getString("CargaHoraria"));
                jComboBoxRegimeTrabalho.setSelectedItem(conecta.rs.getString("RegimeTrabalho"));
                jHorarioInicio.setText(conecta.rs.getString("HorarioInicio"));
                jHorarioFinal.setText(conecta.rs.getString("HorarioFinal"));
                jFuncao.setText(conecta.rs.getString("Funcao"));
                jComboBoxNacionalidade.setSelectedItem(conecta.rs.getString("Nacionalidade"));
                jPais.setText(conecta.rs.getString("Pais"));
                jNaturalidade.setText(conecta.rs.getString("Naturalidade"));
                jComboBoxEstadoNaturalidade.setSelectedItem(conecta.rs.getString("EstadoNaturalidade"));
                // ENDEREÇO
                codEnd = conecta.rs.getInt("IdEnd");
                jEndereco.setText(conecta.rs.getString("Endereco"));
                jBairro.setText(conecta.rs.getString("BairroEnd"));
                jComplemento.setText(conecta.rs.getString("CompEnd"));
                jCidade.setText(conecta.rs.getString("CidadeEnd"));
                jComboBoxEstado.setSelectedItem(conecta.rs.getString("UfEnd"));
                jCep.setText(conecta.rs.getString("CepEnd"));
                // CONTATO
                jEmail.setText(conecta.rs.getString("EmailEnd"));
                jTelefone.setText(conecta.rs.getString("FoneEnd"));
                jTelefoneEnd.setText(conecta.rs.getString("TelEnd"));
                jCelularEnd.setText(conecta.rs.getString("CelEnd"));
                jURL.setText(conecta.rs.getString("Url"));
                jObservacao.setText(conecta.rs.getString("Observacao"));
                // DOCUMENTOS
                codDoc = conecta.rs.getInt("IdDoc");
                jRG.setText(conecta.rs.getString("RgDoc"));
                jCPF.setText(conecta.rs.getString("CpfDoc"));
                jDataEmissaoRg.setDate(conecta.rs.getDate("DataEmissaoDoc"));
                jOrgaoEmissor.setText(conecta.rs.getString("OrgaoDoc"));
                jComboBoxEstadoOrgao.setSelectedItem(conecta.rs.getString("EstadoOrg"));
                jPis.setText(conecta.rs.getString("PisDoc"));
                jDataCadPis.setDate(conecta.rs.getDate("DataCadPisDoc"));
                jTitulo.setText(conecta.rs.getString("TituloDoc"));
                jZona.setText(conecta.rs.getString("ZonaDoc"));
                jSecao.setText(conecta.rs.getString("SecaoDoc"));
                jCTPS.setText(conecta.rs.getString("CtpsDoc"));
                jSerie.setText(conecta.rs.getString("SerieDoc"));
                jHabilita.setText(conecta.rs.getString("HabiliDoc"));
                jReservista.setText(conecta.rs.getString("ReservistaDoc"));
                jCategoria.setText(conecta.rs.getString("CateDoc"));
                jCartaoSaude.setText(conecta.rs.getString("CartSaudeDoc"));
                jProfissao.setText(conecta.rs.getString("ProfDoc"));
                jAltura.setText(conecta.rs.getString("AlturaDoc"));
                jCalca.setText(conecta.rs.getString("CalcaDoc"));
                jSapato.setText(conecta.rs.getString("SapatoDoc"));
                jPeso.setText(conecta.rs.getString("PesoDoc"));
                jCamisa.setText(conecta.rs.getString("CamisaDoc"));
                jCarteiraconselho.setText(conecta.rs.getString("CarteiraDoc"));
                // CONJUGUE
                jComboBoxTipoConjugue.setSelectedItem(conecta.rs.getString("TipoConjugue"));
                jDataNasConjugue.setDate(conecta.rs.getDate("DataNasConjugue"));
                jNomeConjugue.setText(conecta.rs.getString("NomeConjugue"));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa dos dados." + e);
            }
            conecta.desconecta();
        }
        countDep = 0;
        preencherTabelaDepende("SELECT * FROM DEPENDENTES WHERE IdFunc='" + jIDFunc.getText() + "'");
        //PESQUISAR CÓDIGO DO COLABORADOR PARA VER SE O MESMO TEM ESCALA CADASTRADA
        CONTROLE_ESCALA_colaborador.MOSTRAR_CODIGO_ESCALA_func(objEscala);
        if (pCODIGO_colaborador == Integer.parseInt(jIDFunc.getText())) {
            jComboBoxDescricaoEscala.removeAllItems();
            pPESQUISAR_nome.MOSTRAR_FUNC_escala(objEscala);
            jCodigoEscala.setText(String.valueOf(objEscala.getIdRegistro()));
            pID_ESCALA = objEscala.getIdEscala();
            jComboBoxDescricaoEscala.addItem(objEscala.getDescricaoEscala());
            jQtdTrabalho.setText(String.valueOf(objEscala.getQuantidadeTrab()));
            jQtdFolga.setText(String.valueOf(objEscala.getQuantidadeFolga()));
            jTurnoEscala.setText(objEscala.getTurno());
            jTurmaEscala.setText(objEscala.getTurma());
            jDepartamentoEscala.setText(jDepartamento.getText());
            jNomeCargoEscala.setText(jNomeCargo.getText());
            //
            bloquearBotoesEscala(!true);
            jBtAlterarEscala.setEnabled(true);
            jBtExcluirEscala.setEnabled(true);
            jBtAuditoriaEscala.setEnabled(true);
            jBtCronogramaEscala.setEnabled(true);
            jBtImprimeEscala.setEnabled(true);
        } else {
            limparCamposEscala();
            bloquearBotoesEscala(!true);
            jBtNovaEscala.setEnabled(true);
        }
    }//GEN-LAST:event_jTabelaFuncionarioMouseClicked

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherTodasEntradas("SELECT * FROM COLABORADOR "
                    + "INNER JOIN DEPARTAMENTOS "
                    + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                    + "INNER JOIN CARGOS "
                    + "ON COLABORADOR.IdCargo=CARGOS.IdCargo "
                    + "WHERE StatusFunc='" + jComboBoxPesqFunc.getSelectedItem() + "' "
                    + "ORDER BY NomeFunc");
        } else {
            jtotalRegistros.setText("");
            limparTabela();
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jBtWebCamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtWebCamActionPerformed
        // TODO add your handling code here:
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        mostrarWebCamFunc();
    }//GEN-LAST:event_jBtWebCamActionPerformed

    private void jBtNovoLogradouroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoLogradouroActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaColaboradoresFCEnd_ADM);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoADM.equals("ADMINISTRADORES") || codigoUserADM == codUserAcessoADM && nomeTelaADM.equals(telaColaboradoresFCEnd_ADM) && codIncluirADM == 1) {
            acao = 1;
            Novo();
            corCampo();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovoLogradouroActionPerformed

    private void jBtAlterarLogradouroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarLogradouroActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaColaboradoresFCEnd_ADM);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoADM.equals("ADMINISTRADORES") || codigoUserADM == codUserAcessoADM && nomeTelaADM.equals(telaColaboradoresFCEnd_ADM) && codAlterarADM == 1) {
            acao = 2;
            Alterar();
            corCampo();
            statusMov = "Alterou";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtAlterarLogradouroActionPerformed

    private void jBtExcluirLogradouroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirLogradouroActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaColaboradoresFCEnd_ADM);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoADM.equals("ADMINISTRADORES") || codigoUserADM == codUserAcessoADM && nomeTelaADM.equals(telaColaboradoresFCEnd_ADM) && codExcluirADM == 1) {
            //VERIFICAR SE EXISTE REGISTRO NA TABELA CRONOGRAMA_ESCALA_TRABALHO_FOLGA_COLABORADOR
            PESQUISAR_COLABORADOR_escala();
            if (jIDFunc.getText().equals(pCODIGO_PESQUISA_func)) {
                JOptionPane.showMessageDialog(rootPane, "Não é possível excluir o registro selecionado, existe outros registros associados a esse colaborador na tabela de ESCALAS DE TRABALHO.");
            } else {
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM ITENSENTRADASFUNC WHERE IdFunc='" + jIDFunc.getText() + "'ORDER BY IdFunc");
                    conecta.rs.first();
                    idFunc = conecta.rs.getString("IdFunc");
                    //
                    conecta.executaSQL("SELECT * FROM DEPENDENTES WHERE IdFunc='" + jIDFunc.getText() + "'");
                    conecta.rs.first();
                    codFuncDep = conecta.rs.getString("IdFunc");
                } catch (SQLException ex) {
                }
                if (jIDFunc.getText().equals(idFunc)) {
                    JOptionPane.showMessageDialog(rootPane, "Esse colaborador não pode ser excluído,\no mesmo está sendo utilizado em outro registro.");
                } else if (jIDFunc.getText().equals(codFuncDep)) {
                    JOptionPane.showMessageDialog(null, "Esse Colaborador não poderá ser excluído, existe DEPENDENTES relacionados a ele.\nExclua TODOS os DEPENDENTES relacionados a ele para poder excluir.");
                } else {
                    statusMov = "Excluiu";
                    horaMov = jHoraSistema.getText();
                    dataModFinal = jDataSistema.getText();
                    int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir COLABORADOR selecionado?", "Confirmação",
                            JOptionPane.YES_NO_OPTION);
                    if (resposta == JOptionPane.YES_OPTION) {
                        // EXCLUIR O DOCUMENTO
                        objDoc.setIdFunc(Integer.valueOf(jIDFunc.getText()));
                        objDoc.setIdDoc(codDoc);
                        controleDoc.excluirDocumentosColaborador(objDoc);
                        // EXCLUIR ENDEREÇO
                        objEnd.setIdFunc(Integer.valueOf(jIDFunc.getText()));
                        objEnd.setIdEnd(codEnd);
                        controle.excluiEnderecosColaborador(objEnd);
                        //
                        objCola.setIdFunc(Integer.valueOf(jIDFunc.getText()));
                        control.excluirColaborador(objCola);
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        Excluir();
                        JOptionPane.showMessageDialog(rootPane, "Colaborador excluido com sucesso.");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirLogradouroActionPerformed

    private void jBtSalvarLogradouroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarLogradouroActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaColaboradoresFC_ADM);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoADM.equals("ADMINISTRADORES") || codigoUserADM == codUserAcessoADM && nomeTelaADM.equals(telaColaboradoresFC_ADM) && codGravarADM == 1) {
            if (jNomeFuncionario.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Informe o nome do Colaborador.");
                jNomeFuncionario.requestFocus();
                jNomeFuncionario.setBackground(Color.red);
            } else {
                if (jDataAdmissao.getDate() == null) {
                    JOptionPane.showMessageDialog(rootPane, "Informe a data de Admissão.");
                    jDataAdmissao.requestFocus();
                    jDataAdmissao.setBackground(Color.red);
                } else {
                    if (jNomeMae.getText().equals("")) {
                        JOptionPane.showMessageDialog(rootPane, "Informe o nome da mãe do colaborador.");
                        jNomeMae.requestFocus();
                        jNomeMae.setBackground(Color.red);
                    } else {
                        if (jDepartamento.getText().equals("")) {
                            JOptionPane.showMessageDialog(rootPane, "Informe o nome do departamento.");
                            jDepartamento.requestFocus();
                            jDepartamento.setBackground(Color.red);
                        } else {
                            if (jNomeCargo.getText().equals("")) {
                                JOptionPane.showMessageDialog(rootPane, "Informe o nome do cargo.");
                                jNomeCargo.requestFocus();
                                jNomeCargo.setBackground(Color.red);
                            } else {
                                if (caminhoFotoFunc == null) {
                                    JOptionPane.showMessageDialog(rootPane, "Insira a foto do colaborador");
                                    jFotoColaborador.requestFocus();
                                } else {
                                    // DADOS DO COLABORADOR (MANUTENÇÃO)
                                    objCola.setStatusFunc((String) jComboBoxStatusFunc.getSelectedItem());
                                    objCola.setDataCadastro(jDataAdmissao.getDate());
                                    objCola.setNomeFuncionario(jNomeFuncionario.getText().trim());
                                    objCola.setMatricula(jMatricula.getText());
                                    objCola.setSexo((String) jComboBoxSexo.getSelectedItem());
                                    objCola.setEscolaridade((String) jComboBoxEscolaridade.getSelectedItem());
                                    objCola.setEstadoCivil((String) jComboBoxEstadoCivil.getSelectedItem());
                                    objCola.setDataNascimento(jDataNascimento.getDate());
                                    objCola.setFoto(caminhoFotoFunc);
                                    objCola.setNomeMae(jNomeMae.getText().trim());
                                    objCola.setNomePai(jNomePai.getText());
                                    objCola.setReligiao(jReligiao.getText());
                                    objCola.setTipoSangue(jTipoSang.getText());
                                    objCola.setNomeDepartamento(jDepartamento.getText());
                                    objCola.setNomeCargo(jNomeCargo.getText());
                                    objCola.setCargaHoraria(jCargaHoraria.getText());
                                    objCola.setRegimeTrabalho((String) jComboBoxRegimeTrabalho.getSelectedItem());
                                    objCola.setHorarioInicio(jHorarioInicio.getText());
                                    objCola.setHorarioFinal(jHorarioFinal.getText());
                                    objCola.setFuncao(jFuncao.getText());
                                    objCola.setNacionalidade((String) jComboBoxNacionalidade.getSelectedItem());
                                    objCola.setPais(jPais.getText());
                                    objCola.setNaturalidade(jNaturalidade.getText());
                                    objCola.setEstadoNacionalidade((String) jComboBoxEstadoNaturalidade.getSelectedItem());
                                    // PREPARAR FOTO PARA GRAVAR NO BANCO DE DADOS - FOTO DE FRENTE   
                                    if (jFotoColaborador.getIcon() != null) {
                                        objCola.setImagemFrenteCO(persona_imagem);
                                    }
                                    // DADOS DO ENDEREÇO
                                    objEnd.setEndereco(jEndereco.getText());
                                    objEnd.setBairroEnd(jBairro.getText());
                                    objEnd.setCompEnd(jComplemento.getText());
                                    objEnd.setCidadeEnd(jCidade.getText());
                                    objEnd.setEstadoEnd((String) jComboBoxEstado.getSelectedItem());
                                    objEnd.setCepEnd(jCep.getText());
                                    objEnd.setTelEnd(jTelefone.getText());
                                    objEnd.setFoneEnd(jTelefoneEnd.getText());
                                    objEnd.setCelEnd(jCelularEnd.getText());
                                    objEnd.setEmalEnd(jEmail.getText());
                                    objEnd.setUrl(jURL.getText());
                                    objEnd.setObservacao(jObservacao.getText());
                                    // DADOS DO DOCUMENTO        
                                    objDoc.setRgDoc((jRG.getText()));
                                    objDoc.setDataEmissaoDoc(jDataEmissaoRg.getDate());
                                    objDoc.setOrgaoDoc(jOrgaoEmissor.getText());
                                    objDoc.setEstadoOrgao((String) jComboBoxEstadoOrgao.getSelectedItem());
                                    objDoc.setCpfDoc((jCPF.getText()));
                                    objDoc.setPisDoc((jPis.getText()));
                                    objDoc.setDataCadPisDoc(jDataCadPis.getDate());
                                    objDoc.setTituloDoc((jTitulo.getText()));
                                    objDoc.setZonaDoc((jZona.getText()));
                                    objDoc.setSecaoDoc((jSecao.getText()));
                                    objDoc.setCtpsDoc((jCTPS.getText()));
                                    objDoc.setSerieDoc(jSerie.getText());
                                    objDoc.setHabiliDoc(jHabilita.getText());
                                    objDoc.setReserVistaDoc((jReservista.getText()));
                                    objDoc.setCateDoc(jCategoria.getText());
                                    objDoc.setCartSaudeDoc(jCartaoSaude.getText());
                                    objDoc.setProfDoc(jProfissao.getText());
                                    objDoc.setAlturaDoc((jAltura.getText()));
                                    objDoc.setCalcaDoc((jCalca.getText()));
                                    objDoc.setSapatoDoc((jSapato.getText()));
                                    objDoc.setPesoDoc((jPeso.getText()));
                                    objDoc.setCamisaDoc((jCamisa.getText()));
                                    objDoc.setCarteiraDoc((jCarteiraconselho.getText()));
                                    objDoc.setTipoConjugue((String) jComboBoxTipoConjugue.getSelectedItem());
                                    objDoc.setDataNasConjugue(jDataNasConjugue.getDate());
                                    objDoc.setNomeConjugue(jNomeConjugue.getText());
                                    //
                                    verificarColaborador();
                                    if (acao == 1 && jNomeFuncionario.getText().trim().equals(nomeColaborador) && jNomeMae.getText().trim().equals(nomeMaeColaborador)) {
                                        JOptionPane.showMessageDialog(rootPane, "Esse colaborador já foi cadastrada, verifique o cadastro do mesmo.");
                                    } else {
                                        if (acao == 1) {
                                            objCola.setUsuarioInsert(nameUser);
                                            objCola.setDataInsert(dataModFinal);
                                            objCola.setHorarioInsert(horaMov);
                                            // INCLUIR COLABORADOR
                                            control.incluirColaborador(objCola);
                                            buscarCodFunc();
                                            // INCLUIR ENDEREÇO
                                            objEnd.setUsuarioInsert(nameUser);
                                            objEnd.setDataInsert(dataModFinal);
                                            objEnd.setHorarioInsert(horaMov);
                                            objEnd.setIdFunc(Integer.valueOf(jIDFunc.getText()));
                                            controle.incluirEnderecosColaborador(objEnd);
                                            buscarCodEnd();
                                            // INCLUIR DOCUMENTOS
                                            objDoc.setUsuarioInsert(nameUser);
                                            objDoc.setDataInsert(dataModFinal);
                                            objDoc.setHorarioInsert(horaMov);
                                            objDoc.setIdFunc(Integer.valueOf(jIDFunc.getText()));
                                            controleDoc.incluirDocumentosColaborador(objDoc);
                                            buscarCodDoc();
                                            //
                                            objLog();
                                            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                                            Salvar();
                                            JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                                        }
                                    }
                                    if (acao == 2) {
                                        objCola.setUsuarioUp(nameUser);
                                        objCola.setDataUp(dataModFinal);
                                        objCola.setHorarioUp(horaMov);
                                        // ALTERAR COLABORADOR
                                        objCola.setNomeDepartamento(jDepartamento.getText());
                                        objCola.setNomeCargo(jNomeCargo.getText());
                                        objCola.setIdFunc(Integer.valueOf(jIDFunc.getText()));
                                        control.alterarColaborador(objCola);
                                        // ALTERAR ENDEREÇO
                                        objEnd.setUsuarioUp(nameUser);
                                        objEnd.setDataUp(dataModFinal);
                                        objEnd.setHorarioUp(horaMov);
                                        objEnd.setIdFunc(Integer.valueOf(jIDFunc.getText()));
                                        objEnd.setIdEnd(codEnd);
                                        controle.alterarEnderecoColaborador(objEnd);
                                        // ALTERAR DOCUMENTOS
                                        objDoc.setUsuarioUp(nameUser);
                                        objDoc.setDataUp(dataModFinal);
                                        objDoc.setHorarioUp(horaMov);
                                        objDoc.setIdFunc(Integer.valueOf(jIDFunc.getText()));
                                        objDoc.setIdDoc(codDoc);
                                        controleDoc.alterarDocumentosColaborador(objDoc);
                                        //
                                        objLog();
                                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                                        Salvar();
                                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtSalvarLogradouroActionPerformed

    private void jBtCancelarLogradouroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarLogradouroActionPerformed
        // TODO add your handling code here:
        Cancelar();
    }//GEN-LAST:event_jBtCancelarLogradouroActionPerformed

    private void jBtSairLogradouroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairLogradouroActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairLogradouroActionPerformed

    private void jBtNovoDocumentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoDocumentosActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaColaboradoresFCDoc_ADM);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoADM.equals("ADMINISTRADORES") || codigoUserADM == codUserAcessoADM && nomeTelaADM.equals(telaColaboradoresFCDoc_ADM) && codIncluirADM == 1) {
            acao = 1;
            Novo();
            corCampo();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovoDocumentosActionPerformed

    private void jBtAlterarDocumentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarDocumentosActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaColaboradoresFCDoc_ADM);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoADM.equals("ADMINISTRADORES") || codigoUserADM == codUserAcessoADM && nomeTelaADM.equals(telaColaboradoresFCDoc_ADM) && codAlterarADM == 1) {
            acao = 2;
            Alterar();
            corCampo();
            statusMov = "Alterou";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtAlterarDocumentosActionPerformed

    private void jBtExcluirDocumentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirDocumentosActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaColaboradoresFCDoc_ADM);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoADM.equals("ADMINISTRADORES") || codigoUserADM == codUserAcessoADM && nomeTelaADM.equals(telaColaboradoresFCDoc_ADM) && codExcluirADM == 1) {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ITENSENTRADASFUNC WHERE IdFunc='" + jIDFunc.getText() + "'ORDER BY IdFunc");
                conecta.rs.first();
                idFunc = conecta.rs.getString("IdFunc");
                //
                conecta.executaSQL("SELECT * FROM DEPENDENTES WHERE IdFunc='" + jIDFunc.getText() + "'");
                conecta.rs.first();
                codFuncDep = conecta.rs.getString("IdFunc");
            } catch (SQLException ex) {
            }
            if (jIDFunc.getText().equals(idFunc)) {
                JOptionPane.showMessageDialog(rootPane, "Esse colaborador não pode ser excluído,\no mesmo está sendo utilizado em outro registro.");
            } else if (jIDFunc.getText().equals(codFuncDep)) {
                JOptionPane.showMessageDialog(null, "Esse Colaborador não poderá ser excluído, existe DEPENDENTES relacionados a ele.\nExclua TODOS os DEPENDENTES relacionados a ele para poder excluir.");
            } else {
                statusMov = "Excluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir COLABORADOR selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    // EXCLUIR O DOCUMENTO
                    objDoc.setIdFunc(Integer.valueOf(jIDFunc.getText()));
                    objDoc.setIdDoc(codDoc);
                    controleDoc.excluirDocumentosColaborador(objDoc);
                    // EXCLUIR ENDEREÇO
                    objEnd.setIdFunc(Integer.valueOf(jIDFunc.getText()));
                    objEnd.setIdEnd(codEnd);
                    controle.excluiEnderecosColaborador(objEnd);
                    //
                    objCola.setIdFunc(Integer.valueOf(jIDFunc.getText()));
                    control.excluirColaborador(objCola);
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    Excluir();
                    JOptionPane.showMessageDialog(rootPane, "Colaborador excluido com sucesso.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirDocumentosActionPerformed

    private void jBtSalvarDocumentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarDocumentosActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaColaboradoresFCDoc_ADM);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoADM.equals("ADMINISTRADORES") || codigoUserADM == codUserAcessoADM && nomeTelaADM.equals(telaColaboradoresFCDoc_ADM) && codGravarADM == 1) {
            if (jNomeFuncionario.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Informe o nome do Colaborador.");
                jNomeFuncionario.requestFocus();
                jNomeFuncionario.setBackground(Color.red);
            } else {
                if (jDataAdmissao.getDate() == null) {
                    JOptionPane.showMessageDialog(rootPane, "Informe a data de Admissão.");
                    jDataAdmissao.requestFocus();
                    jDataAdmissao.setBackground(Color.red);
                } else {
                    if (jNomeMae.getText().equals("")) {
                        JOptionPane.showMessageDialog(rootPane, "Informe o nome da mãe do colaborador.");
                        jNomeMae.requestFocus();
                        jNomeMae.setBackground(Color.red);
                    } else {
                        if (jDepartamento.getText().equals("")) {
                            JOptionPane.showMessageDialog(rootPane, "Informe o nome do departamento.");
                            jDepartamento.requestFocus();
                            jDepartamento.setBackground(Color.red);
                        } else {
                            if (jNomeCargo.getText().equals("")) {
                                JOptionPane.showMessageDialog(rootPane, "Informe o nome do cargo.");
                                jNomeCargo.requestFocus();
                                jNomeCargo.setBackground(Color.red);
                            } else {
                                if (caminhoFotoFunc == null) {
                                    JOptionPane.showMessageDialog(rootPane, "Insira a foto do colaborador");
                                    jFotoColaborador.requestFocus();
                                } else {
                                    // DADOS DO COLABORADOR (MANUTENÇÃO)
                                    objCola.setStatusFunc((String) jComboBoxStatusFunc.getSelectedItem());
                                    objCola.setDataCadastro(jDataAdmissao.getDate());
                                    objCola.setNomeFuncionario(jNomeFuncionario.getText().trim());
                                    objCola.setMatricula(jMatricula.getText());
                                    objCola.setSexo((String) jComboBoxSexo.getSelectedItem());
                                    objCola.setEscolaridade((String) jComboBoxEscolaridade.getSelectedItem());
                                    objCola.setEstadoCivil((String) jComboBoxEstadoCivil.getSelectedItem());
                                    objCola.setDataNascimento(jDataNascimento.getDate());
                                    objCola.setFoto(caminhoFotoFunc);
                                    objCola.setNomeMae(jNomeMae.getText().trim());
                                    objCola.setNomePai(jNomePai.getText());
                                    objCola.setReligiao(jReligiao.getText());
                                    objCola.setTipoSangue(jTipoSang.getText());
                                    objCola.setNomeDepartamento(jDepartamento.getText());
                                    objCola.setNomeCargo(jNomeCargo.getText());
                                    objCola.setCargaHoraria(jCargaHoraria.getText());
                                    objCola.setRegimeTrabalho((String) jComboBoxRegimeTrabalho.getSelectedItem());
                                    objCola.setHorarioInicio(jHorarioInicio.getText());
                                    objCola.setHorarioFinal(jHorarioFinal.getText());
                                    objCola.setFuncao(jFuncao.getText());
                                    objCola.setNacionalidade((String) jComboBoxNacionalidade.getSelectedItem());
                                    objCola.setPais(jPais.getText());
                                    objCola.setNaturalidade(jNaturalidade.getText());
                                    objCola.setEstadoNacionalidade((String) jComboBoxEstadoNaturalidade.getSelectedItem());
                                    // PREPARAR FOTO PARA GRAVAR NO BANCO DE DADOS - FOTO DE FRENTE   
                                    if (jFotoColaborador.getIcon() != null) {
                                        objCola.setImagemFrenteCO(persona_imagem);
                                    }
                                    // DADOS DO ENDEREÇO
                                    objEnd.setEndereco(jEndereco.getText());
                                    objEnd.setBairroEnd(jBairro.getText());
                                    objEnd.setCompEnd(jComplemento.getText());
                                    objEnd.setCidadeEnd(jCidade.getText());
                                    objEnd.setEstadoEnd((String) jComboBoxEstado.getSelectedItem());
                                    objEnd.setCepEnd(jCep.getText());
                                    objEnd.setTelEnd(jTelefone.getText());
                                    objEnd.setFoneEnd(jTelefoneEnd.getText());
                                    objEnd.setCelEnd(jCelularEnd.getText());
                                    objEnd.setEmalEnd(jEmail.getText());
                                    objEnd.setUrl(jURL.getText());
                                    objEnd.setObservacao(jObservacao.getText());
                                    // DADOS DO DOCUMENTO        
                                    objDoc.setRgDoc((jRG.getText()));
                                    objDoc.setDataEmissaoDoc(jDataEmissaoRg.getDate());
                                    objDoc.setOrgaoDoc(jOrgaoEmissor.getText());
                                    objDoc.setEstadoOrgao((String) jComboBoxEstadoOrgao.getSelectedItem());
                                    objDoc.setCpfDoc((jCPF.getText()));
                                    objDoc.setPisDoc((jPis.getText()));
                                    objDoc.setDataCadPisDoc(jDataCadPis.getDate());
                                    objDoc.setTituloDoc((jTitulo.getText()));
                                    objDoc.setZonaDoc((jZona.getText()));
                                    objDoc.setSecaoDoc((jSecao.getText()));
                                    objDoc.setCtpsDoc((jCTPS.getText()));
                                    objDoc.setSerieDoc(jSerie.getText());
                                    objDoc.setHabiliDoc(jHabilita.getText());
                                    objDoc.setReserVistaDoc((jReservista.getText()));
                                    objDoc.setCateDoc(jCategoria.getText());
                                    objDoc.setCartSaudeDoc(jCartaoSaude.getText());
                                    objDoc.setProfDoc(jProfissao.getText());
                                    objDoc.setAlturaDoc((jAltura.getText()));
                                    objDoc.setCalcaDoc((jCalca.getText()));
                                    objDoc.setSapatoDoc((jSapato.getText()));
                                    objDoc.setPesoDoc((jPeso.getText()));
                                    objDoc.setCamisaDoc((jCamisa.getText()));
                                    objDoc.setCarteiraDoc((jCarteiraconselho.getText()));
                                    objDoc.setTipoConjugue((String) jComboBoxTipoConjugue.getSelectedItem());
                                    objDoc.setDataNasConjugue(jDataNasConjugue.getDate());
                                    objDoc.setNomeConjugue(jNomeConjugue.getText());
                                    //
                                    verificarColaborador();
                                    if (acao == 1 && jNomeFuncionario.getText().trim().equals(nomeColaborador) && jNomeMae.getText().trim().equals(nomeMaeColaborador)) {
                                        JOptionPane.showMessageDialog(rootPane, "Esse colaborador já foi cadastrada, verifique o cadastro do mesmo.");
                                    } else {
                                        if (acao == 1) {
                                            objCola.setUsuarioInsert(nameUser);
                                            objCola.setDataInsert(dataModFinal);
                                            objCola.setHorarioInsert(horaMov);
                                            // INCLUIR COLABORADOR
                                            control.incluirColaborador(objCola);
                                            buscarCodFunc();
                                            // INCLUIR ENDEREÇO
                                            objEnd.setUsuarioInsert(nameUser);
                                            objEnd.setDataInsert(dataModFinal);
                                            objEnd.setHorarioInsert(horaMov);
                                            objEnd.setIdFunc(Integer.valueOf(jIDFunc.getText()));
                                            controle.incluirEnderecosColaborador(objEnd);
                                            buscarCodEnd();
                                            // INCLUIR DOCUMENTOS
                                            objDoc.setUsuarioInsert(nameUser);
                                            objDoc.setDataInsert(dataModFinal);
                                            objDoc.setHorarioInsert(horaMov);
                                            objDoc.setIdFunc(Integer.valueOf(jIDFunc.getText()));
                                            controleDoc.incluirDocumentosColaborador(objDoc);
                                            buscarCodDoc();
                                            //
                                            objLog();
                                            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                                            Salvar();
                                            JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                                        }
                                    }
                                    if (acao == 2) {
                                        objCola.setUsuarioUp(nameUser);
                                        objCola.setDataUp(dataModFinal);
                                        objCola.setHorarioUp(horaMov);
                                        // ALTERAR COLABORADOR
                                        objCola.setNomeDepartamento(jDepartamento.getText());
                                        objCola.setNomeCargo(jNomeCargo.getText());
                                        objCola.setIdFunc(Integer.valueOf(jIDFunc.getText()));
                                        control.alterarColaborador(objCola);
                                        // ALTERAR ENDEREÇO
                                        objEnd.setUsuarioUp(nameUser);
                                        objEnd.setDataUp(dataModFinal);
                                        objEnd.setHorarioUp(horaMov);
                                        objEnd.setIdFunc(Integer.valueOf(jIDFunc.getText()));
                                        objEnd.setIdEnd(codEnd);
                                        controle.alterarEnderecoColaborador(objEnd);
                                        // ALTERAR DOCUMENTOS
                                        objDoc.setUsuarioUp(nameUser);
                                        objDoc.setDataUp(dataModFinal);
                                        objDoc.setHorarioUp(horaMov);
                                        objDoc.setIdFunc(Integer.valueOf(jIDFunc.getText()));
                                        objDoc.setIdDoc(codDoc);
                                        controleDoc.alterarDocumentosColaborador(objDoc);
                                        //
                                        objLog();
                                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                                        Salvar();
                                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtSalvarDocumentosActionPerformed

    private void jBtCancelarDocumentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarDocumentosActionPerformed
        // TODO add your handling code here:
        Cancelar();
    }//GEN-LAST:event_jBtCancelarDocumentosActionPerformed

    private void jBtSairDocumentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairDocumentosActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairDocumentosActionPerformed

    private void jBtPesqCodigoFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqCodigoFuncActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (jCodigoPesqFunc.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe o código do colaborador para pesquisa.");
        } else {
            preencherTodasEntradas("SELECT * FROM COLABORADOR "
                    + "INNER JOIN DEPARTAMENTOS "
                    + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                    + "INNER JOIN CARGOS "
                    + "ON COLABORADOR.IdCargo=CARGOS.IdCargo "
                    + "WHERE IdFunc='" + jCodigoPesqFunc.getText() + "'");
        }
    }//GEN-LAST:event_jBtPesqCodigoFuncActionPerformed

    private void jBtPesqMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqMatriculaActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (jPesqMatricula.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe a matricula do colaborador para pesquisa.");
        } else {
            preencherTodasEntradas("SELECT * FROM COLABORADOR "
                    + "INNER JOIN DEPARTAMENTOS "
                    + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                    + "INNER JOIN CARGOS "
                    + "ON COLABORADOR.IdCargo=CARGOS.IdCargo "
                    + "WHERE MatriculaFunc='" + jPesqMatricula.getText() + "'");
        }
    }//GEN-LAST:event_jBtPesqMatriculaActionPerformed

    private void jBtNovoDependenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoDependenteActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaColaboradoresFCDep_ADM);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoADM.equals("ADMINISTRADORES") || codigoUserADM == codUserAcessoADM && nomeTelaADM.equals(telaColaboradoresFCDep_ADM) && codIncluirADM == 1) {
            acao = 3;
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            NovoDependente();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovoDependenteActionPerformed

    private void jBtAlterarDependenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarDependenteActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaColaboradoresFCDep_ADM);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoADM.equals("ADMINISTRADORES") || codigoUserADM == codUserAcessoADM && nomeTelaADM.equals(telaColaboradoresFCDep_ADM) && codAlterarADM == 1) {
            acao = 4;
            statusMov = "Alterou";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            AlterarDependente();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtAlterarDependenteActionPerformed

    private void jBtExcluirDependenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirDependenteActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaColaboradoresFCDep_ADM);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoADM.equals("ADMINISTRADORES") || codigoUserADM == codUserAcessoADM && nomeTelaADM.equals(telaColaboradoresFCDep_ADM) && codExcluirADM == 1) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir DEPENDENTE selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objDep.setIdFunc(Integer.valueOf(jIDFunc.getText()));
                objDep.setIdDep(Integer.valueOf(jCodigoDependente.getText()));
                controlDep.excluirDepndenteColaborador(objDep);
                objLog1();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                //
                preencherTabelaDepende("SELECT * FROM DEPENDENTES WHERE IdFunc='" + jIDFunc.getText() + "'");
                ExcluirDependente();
                JOptionPane.showMessageDialog(rootPane, "Registro excluído com sucesso.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirDependenteActionPerformed

    private void jBtSalvarDependenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarDependenteActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaColaboradoresFCDep_ADM);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoADM.equals("ADMINISTRADORES") || codigoUserADM == codUserAcessoADM && nomeTelaADM.equals(telaColaboradoresFCDep_ADM) && codGravarADM == 1) {
            if (jDataNasConjugue.getDate() == null) {
                JOptionPane.showMessageDialog(null, "Informe a data de nascimento do conjugue.");
            } else if (jComboBoxTipoConjugue.getSelectedItem().equals("Selecione")) {
                JOptionPane.showMessageDialog(null, "Informe o grau de parentesco do dependente.");
            } else if (jNomeDependente.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Informe o nome do dependente.");
            } else {
                objDep.setNomeDep(jNomeDependente.getText());
                objDep.setDataNascDep(jDataNascimentoParentesco.getDate());
                objDep.setParenteDep((String) jComboBoxParentesco.getSelectedItem());
                if (acao == 3) {
                    objDep.setUsuarioInsert(nameUser);
                    objDep.setDataInsert(dataModFinal);
                    objDep.setHorarioInsert(horaMov);
                    //
                    objDep.setIdFunc(Integer.valueOf(jIDFunc.getText()));
                    controlDep.incluirDepndenteColaborador(objDep);
                    buscarCodDependente();
                    //
                    objLog1();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    //
                    preencherTabelaDepende("SELECT * FROM DEPENDENTES WHERE IdFunc='" + jIDFunc.getText() + "'");
                    SalvarDependente();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
                if (acao == 4) {
                    objDep.setUsuarioUp(nameUser);
                    objDep.setDataUp(dataModFinal);
                    objDep.setHorarioUp(horaMov);
                    //
                    objDep.setIdFunc(Integer.valueOf(jIDFunc.getText()));
                    objDep.setIdDep(Integer.valueOf(jCodigoDependente.getText()));
                    controlDep.alterarDepndenteColaborador(objDep);
                    objLog1();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    //
                    preencherTabelaDepende("SELECT * FROM DEPENDENTES WHERE IdFunc='" + jIDFunc.getText() + "'");
                    SalvarDependente();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtSalvarDependenteActionPerformed

    private void jBtCancelarDependenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarDependenteActionPerformed
        // TODO add your handling code here:
        CancelarDependente();
    }//GEN-LAST:event_jBtCancelarDependenteActionPerformed

    private void jTabelaDependentesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaDependentesMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            String idDep = "" + jTabelaDependentes.getValueAt(jTabelaDependentes.getSelectedRow(), 0);
            jCodigoDependente.setText(idDep);
            //
            jBtNovoDependente.setEnabled(!true);
            jBtAlterarDependente.setEnabled(true);
            jBtExcluirDependente.setEnabled(true);
            jBtSalvarDependente.setEnabled(!true);
            jBtCancelarDependente.setEnabled(true);
            jBtAuditoriaDependente.setEnabled(true);
            //           
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM DEPENDENTES WHERE IdDep='" + idDep + "'");
                conecta.rs.first();
                jCodigoDependente.setText(conecta.rs.getString("IdDep"));
                jComboBoxParentesco.setSelectedItem(conecta.rs.getString("ParenteDep"));
                jDataNascimentoParentesco.setDate(conecta.rs.getDate("DataNascDep"));
                jNomeDependente.setText(conecta.rs.getString("NomeDep"));
                conecta.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "Não foi possível selecionar o registro.\nERRO: " + e);
            }
        }
    }//GEN-LAST:event_jTabelaDependentesMouseClicked

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
                        preencherTodasEntradas("SELECT * FROM COLABORADOR "
                                + "INNER JOIN DEPARTAMENTOS "
                                + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                                + "INNER JOIN CARGOS "
                                + "ON COLABORADOR.IdCargo=CARGOS.IdCargo "
                                + "WHERE DataCadFunc BETWEEN'" + dataInicial + "' "
                                + "AND '" + dataFinal + "' ");
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
                        preencherTodasEntradas("SELECT * FROM COLABORADOR "
                                + "INNER JOIN DEPARTAMENTOS "
                                + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                                + "INNER JOIN CARGOS "
                                + "ON COLABORADOR.IdCargo=CARGOS.IdCargo "
                                + "WHERE DataCadFunc BETWEEN'" + dataInicial + "' "
                                + "AND '" + dataFinal + "' ");
                    }
                }
            }
        }
    }//GEN-LAST:event_jBtPesqDatasActionPerformed

    private void jBtAuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaColaborador objAudi = new TelaAuditoriaColaborador();
        TelaModuloAdmPessoal.jPainelAdmPessoal.add(objAudi);
        objAudi.show();
    }//GEN-LAST:event_jBtAuditoriaActionPerformed

    private void jBtAuditoriaLogradouroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaLogradouroActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaColaborador objAudi = new TelaAuditoriaColaborador();
        TelaModuloAdmPessoal.jPainelAdmPessoal.add(objAudi);
        objAudi.show();
    }//GEN-LAST:event_jBtAuditoriaLogradouroActionPerformed

    private void jBtAuditoriaDocumentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaDocumentosActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaColaborador objAudi = new TelaAuditoriaColaborador();
        TelaModuloAdmPessoal.jPainelAdmPessoal.add(objAudi);
        objAudi.show();
    }//GEN-LAST:event_jBtAuditoriaDocumentosActionPerformed

    private void jBtAuditoriaDependenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaDependenteActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaDependentesColaborador objAudiDep = new TelaAuditoriaDependentesColaborador();
        TelaModuloAdmPessoal.jPainelAdmPessoal.add(objAudiDep);
        objAudiDep.show();
    }//GEN-LAST:event_jBtAuditoriaDependenteActionPerformed

    private void jBtBiometriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtBiometriaActionPerformed
        // TODO add your handling code here:
        mostrarBiometriaFunc();
    }//GEN-LAST:event_jBtBiometriaActionPerformed

    private void jBtImpressaoFichaColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImpressaoFichaColaboradorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtImpressaoFichaColaboradorActionPerformed

    private void jBtConsultaMovimentacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtConsultaMovimentacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtConsultaMovimentacaoActionPerformed

    private void jComboBoxDescricaoEscalaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxDescricaoEscalaItemStateChanged
        // TODO add your handling code here:
        if (jComboBoxDescricaoEscala.getSelectedItem() != null) {
            if (evt.getStateChange() == evt.SELECTED) {
                pPESQUISAR_nome.MOSTRAR_escala(objEscala);
                jCodigoEscala.setText(String.valueOf(objEscala.getIdRegistro()));
                jComboBoxDescricaoEscala.addItem(objEscala.getDescricaoEscala());
                jQtdTrabalho.setText(String.valueOf(objEscala.getQuantidadeTrab()));
                jQtdFolga.setText(String.valueOf(objEscala.getQuantidadeFolga()));
                jTurnoEscala.setText(objEscala.getTurno());
                jTurmaEscala.setText(objEscala.getTurma());
            }
        }
    }//GEN-LAST:event_jComboBoxDescricaoEscalaItemStateChanged

    private void jBtNovaEscalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovaEscalaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEscalaTrabalho_ADM);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoADM.equals("ADMINISTRADORES") || codigoUserADM == codUserAcessoADM && nomeTelaADM.equals(telaEscalaTrabalho_ADM) && codIncluirADM == 1) {
            if (jComboBoxStatusFunc.getSelectedItem().equals("Ativo")) {
                acao = 5;
                bloquearBotoesEscala(!true);
                habilitarCamposEscala(true);
                NovaEscala(true);
                statusMov = "Incluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
                jComboBoxDescricaoEscala.removeAllItems();
                jDepartamentoEscala.setText(jDepartamento.getText());
                jNomeCargoEscala.setText(jNomeCargo.getText());
                try {
                    for (EscalaFolgas b : pPESQUISAR_nome.read()) {
                        jCodigoEscala.setText(String.valueOf(b.getIdRegistro()));
                        jComboBoxDescricaoEscala.addItem(b.getDescricaoEscala());
                        jQtdTrabalho.setText(String.valueOf(b.getQuantidadeTrab()));
                        jQtdFolga.setText(String.valueOf(b.getQuantidadeFolga()));
                        jTurnoEscala.setText(b.getTurno());
                        jTurmaEscala.setText(b.getTurma());
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Não exites escala a ser exibida. Será necessário gravar primeiro as escalas de trabalho do colaborador.");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Colaborador não está ativo, por isso não é possível definir escala de trabalho e folga.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovaEscalaActionPerformed

    private void jBtAlterarEscalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarEscalaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEscalaTrabalho_ADM);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoADM.equals("ADMINISTRADORES") || codigoUserADM == codUserAcessoADM && nomeTelaADM.equals(telaEscalaTrabalho_ADM) && codAlterarADM == 1) {
            if (jComboBoxStatusFunc.getSelectedItem().equals("Ativo")) {
                //VERIFICAR SE EXISTE REGISTRO NA TABELA CRONOGRAMA_ESCALA_TRABALHO_FOLGA_COLABORADOR
                PESQUISAR_COLABORADOR_escala();
                if (jIDFunc.getText().equals(pCODIGO_PESQUISA_func)) {
                    JOptionPane.showMessageDialog(rootPane, "Não é possível excluir o registro selecionado, existe outros registros associados a esse colaboradorna tabela de ESCALAS DE TRABALHO.");
                } else {
                    acao = 6;
                    statusMov = "Alterou";
                    horaMov = jHoraSistema.getText();
                    dataModFinal = jDataSistema.getText();
                    bloquearBotoesEscala(!true);
                    habilitarCamposEscala(true);
                    AlterarEscala(true);
                    jDepartamentoEscala.setText(jDepartamento.getText());
                    jNomeCargoEscala.setText(jNomeCargo.getText());
                    try {
                        for (EscalaFolgas b : pPESQUISAR_nome.read()) {
                            jCodigoEscala.setText(String.valueOf(b.getIdRegistro()));
                            jComboBoxDescricaoEscala.addItem(b.getDescricaoEscala());
                            jQtdTrabalho.setText(String.valueOf(b.getQuantidadeTrab()));
                            jQtdFolga.setText(String.valueOf(b.getQuantidadeFolga()));
                            jTurnoEscala.setText(b.getTurno());
                            jTurmaEscala.setText(b.getTurma());
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Não exites escala a ser exibida. Será necessário gravar primeiro as escalas de trabalho do colaborador.");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Colaborador não está ativo, por isso não é possível definir escala de trabalho e folga.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtAlterarEscalaActionPerformed

    private void jBtExcluirEscalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirEscalaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEscalaTrabalho_ADM);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoADM.equals("ADMINISTRADORES") || codigoUserADM == codUserAcessoADM && nomeTelaADM.equals(telaEscalaTrabalho_ADM) && codExcluirADM == 1) {
            if (jComboBoxStatusFunc.getSelectedItem().equals("Ativo")) {
                //VERIFICAR SE EXISTE REGISTRO NA TABELA CRONOGRAMA_ESCALA_TRABALHO_FOLGA_COLABORADOR
                PESQUISAR_COLABORADOR_escala();
                if (jIDFunc.getText().equals(pCODIGO_PESQUISA_func)) {
                    JOptionPane.showMessageDialog(rootPane, "Não é possível excluir o registro selecionado, existe outros registros associados a esse colaboradorna tabela de ESCALAS DE TRABALHO.");
                } else {
                    int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                            JOptionPane.YES_NO_OPTION);
                    if (resposta == JOptionPane.YES_OPTION) {
                        statusMov = "Excluiu";
                        horaMov = jHoraSistema.getText();
                        dataModFinal = jDataSistema.getText();
                        objEscala.setIdEscala(pID_ESCALA);
                        CONTROLE_ESCALA_colaborador.excluirEscalaTrabalhoFolga(objEscala);
                        bloquearBotoesEscala(!true);
                        habilitarCamposEscala(!true);
                        ExcluirEscala(!true);
                        limparCamposEscala();
                        if (pRESPOSTA_escala.equals("Sim")) {
                            JOptionPane.showMessageDialog(null, "Resgistro excluído com sucesso.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Não foi possível excluir o registro, tente novamente.");
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Colaborador não está ativo, por isso não é possível definir escala de trabalho e folga.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirEscalaActionPerformed

    private void jBtSalvarEscalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarEscalaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEscalaTrabalho_ADM);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoADM.equals("ADMINISTRADORES") || codigoUserADM == codUserAcessoADM && nomeTelaADM.equals(telaEscalaTrabalho_ADM) && codGravarADM == 1) {
            if (jCodigoEscala.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Informe o código da escala.");
            } else if (jComboBoxDescricaoEscala.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(null, "Informe a descrição da escala.");
            } else if (jQtdTrabalho.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Informe a quantidade de dias de trabalho.");
            } else if (jQtdFolga.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Informe a quantidade de dias de folga.");
            } else {
                objEscala.setIdRegistro(Integer.valueOf(objEscala.getIdRegistro()));
                objEscala.setIdFunc(Integer.valueOf(jIDFunc.getText()));
                objEscala.setDescricaoEscala((String) jComboBoxDescricaoEscala.getSelectedItem());
                objEscala.setQuantidadeTrab(Integer.valueOf(jQtdTrabalho.getText()));
                objEscala.setQuantidadeFolga(Integer.valueOf(jQtdFolga.getText()));
                if (acao == 5) {
                    objEscala.setUsuarioInsert(nameUser);
                    objEscala.setDataInsert(dataModFinal);
                    objEscala.setHorarioInsert(horaMov);
                    CONTROLE_ESCALA_colaborador.incluirEscalaTrabalhoFolga(objEscala);
                    objLog2();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    bloquearBotoesEscala(!true);
                    habilitarCamposEscala(!true);
                    SalvarEscala(true);
                    //BUSCAR CÓDIGO DA ESCALA DE TRABALHO E FOLGA NA TABELA ESCALA_TRABALHO_FOLGA_COLABORADOR
                    CONTROLE_ESCALA_colaborador.PESQUISAR_CODIGO_escala(objEscala);
                    if (pRESPOSTA_escala.equals("Sim")) {
                        JOptionPane.showMessageDialog(null, "Resgistro gravado com sucesso.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Não foi possível gravar o registro, tente novamente.");
                    }
                }
                if (acao == 6) {
                    objEscala.setUsuarioUp(nameUser);
                    objEscala.setDataUp(dataModFinal);
                    objEscala.setHorarioUp(horaMov);
                    objEscala.setIdEscala(pID_ESCALA);
                    CONTROLE_ESCALA_colaborador.alterarEscalaTrabalhoFolga(objEscala);
                    objLog2();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    bloquearBotoesEscala(!true);
                    habilitarCamposEscala(!true);
                    SalvarEscala(true);
                    if (pRESPOSTA_escala.equals("Sim")) {
                        JOptionPane.showMessageDialog(null, "Resgistro gravado com sucesso.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Não foi possível gravar o registro, tente novamente.");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtSalvarEscalaActionPerformed

    private void jBtCancelarEscalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarEscalaActionPerformed
        // TODO add your handling code here:
        bloquearBotoesEscala(!true);
        CancelarEscala(true);
    }//GEN-LAST:event_jBtCancelarEscalaActionPerformed

    private void jBtCronogramaEscalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCronogramaEscalaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCronograma_ADM);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoADM.equals("ADMINISTRADORES") || codigoUserADM == codUserAcessoADM && nomeTelaADM.equals(telaCronograma_ADM) && codIncluirADM == 1) {
            if (jComboBoxStatusFunc.getSelectedItem().equals("Ativo")) {
                mostrarCRONOGRAMA();
            } else {
                JOptionPane.showMessageDialog(rootPane, "O colaborador não está ativo, por isso não é permitido gerar o cronograma de trabalho.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtCronogramaEscalaActionPerformed

    private void jBtAuditoriaEscalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaEscalaActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaEscalaTrabalhoFolga objAuditoriaES = new TelaAuditoriaEscalaTrabalhoFolga();
        TelaModuloAdmPessoal.jPainelAdmPessoal.add(objAuditoriaES);
        objAuditoriaES.show();
    }//GEN-LAST:event_jBtAuditoriaEscalaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField jAltura;
    private javax.swing.JTextField jBairro;
    private javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtAlterarDependente;
    private javax.swing.JButton jBtAlterarDocumentos;
    private javax.swing.JButton jBtAlterarEscala;
    private javax.swing.JButton jBtAlterarLogradouro;
    private javax.swing.JButton jBtAuditoria;
    private javax.swing.JButton jBtAuditoriaDependente;
    private javax.swing.JButton jBtAuditoriaDocumentos;
    private javax.swing.JButton jBtAuditoriaEscala;
    private javax.swing.JButton jBtAuditoriaLogradouro;
    private javax.swing.JButton jBtBiometria;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtCancelarDependente;
    private javax.swing.JButton jBtCancelarDocumentos;
    private javax.swing.JButton jBtCancelarEscala;
    private javax.swing.JButton jBtCancelarLogradouro;
    private javax.swing.JButton jBtConsultaMovimentacao;
    private javax.swing.JButton jBtCronogramaEscala;
    private javax.swing.JButton jBtExcluir;
    private javax.swing.JButton jBtExcluirDependente;
    private javax.swing.JButton jBtExcluirDocumentos;
    private javax.swing.JButton jBtExcluirEscala;
    private javax.swing.JButton jBtExcluirFoto2;
    private javax.swing.JButton jBtExcluirLogradouro;
    private javax.swing.JButton jBtImpressaoFichaColaborador;
    private javax.swing.JButton jBtImprimeEscala;
    private javax.swing.JButton jBtNovaEscala;
    private javax.swing.JButton jBtNovo;
    private javax.swing.JButton jBtNovoDependente;
    private javax.swing.JButton jBtNovoDocumentos;
    private javax.swing.JButton jBtNovoFoto2;
    private javax.swing.JButton jBtNovoLogradouro;
    private javax.swing.JButton jBtPesqCargo;
    private javax.swing.JButton jBtPesqCodigoFunc;
    private javax.swing.JButton jBtPesqDatas;
    private javax.swing.JButton jBtPesqDepto;
    private javax.swing.JButton jBtPesqMatricula;
    private javax.swing.JButton jBtPesqNome;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSairDocumentos;
    private javax.swing.JButton jBtSairLogradouro;
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JButton jBtSalvarDependente;
    private javax.swing.JButton jBtSalvarDocumentos;
    private javax.swing.JButton jBtSalvarEscala;
    private javax.swing.JButton jBtSalvarLogradouro;
    private javax.swing.JButton jBtWebCam;
    private javax.swing.JFormattedTextField jCPF;
    private javax.swing.JTextField jCTPS;
    private javax.swing.JTextField jCalca;
    private javax.swing.JTextField jCamisa;
    private javax.swing.JFormattedTextField jCargaHoraria;
    private javax.swing.JTextField jCartaoSaude;
    private javax.swing.JTextField jCarteiraconselho;
    private javax.swing.JTextField jCategoria;
    private javax.swing.JFormattedTextField jCelularEnd;
    private javax.swing.JFormattedTextField jCep;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JTextField jCidade;
    public static javax.swing.JTextField jCodigoDependente;
    private javax.swing.JTextField jCodigoEscala;
    public static javax.swing.JTextField jCodigoPesqFunc;
    public static javax.swing.JComboBox<String> jComboBoxDescricaoEscala;
    private javax.swing.JComboBox jComboBoxEscolaridade;
    private javax.swing.JComboBox jComboBoxEstado;
    private javax.swing.JComboBox jComboBoxEstadoCivil;
    private javax.swing.JComboBox jComboBoxEstadoNaturalidade;
    private javax.swing.JComboBox jComboBoxEstadoOrgao;
    private javax.swing.JComboBox jComboBoxNacionalidade;
    private javax.swing.JComboBox jComboBoxParentesco;
    private javax.swing.JComboBox jComboBoxPesqFunc;
    private javax.swing.JComboBox jComboBoxRegimeTrabalho;
    private javax.swing.JComboBox jComboBoxSexo;
    public static javax.swing.JComboBox jComboBoxStatusFunc;
    private javax.swing.JComboBox jComboBoxTipoConjugue;
    private javax.swing.JTextField jComplemento;
    private javax.swing.JPanel jDadosEscala;
    private com.toedter.calendar.JDateChooser jDataAdmissao;
    private com.toedter.calendar.JDateChooser jDataCadPis;
    private com.toedter.calendar.JDateChooser jDataEmissaoRg;
    private com.toedter.calendar.JDateChooser jDataNasConjugue;
    private com.toedter.calendar.JDateChooser jDataNascimento;
    private com.toedter.calendar.JDateChooser jDataNascimentoParentesco;
    private com.toedter.calendar.JDateChooser jDataPesFinal;
    private com.toedter.calendar.JDateChooser jDataPesqInicial;
    public static javax.swing.JTextField jDepartamento;
    public static javax.swing.JTextField jDepartamentoEscala;
    private javax.swing.JPanel jDependentes;
    private javax.swing.JPanel jDependentesEscala;
    private javax.swing.JPanel jDocumentos;
    private javax.swing.JTextField jEmail;
    private javax.swing.JTextField jEndereco;
    public static javax.swing.JLabel jFotoColaborador;
    private javax.swing.JTextField jFuncao;
    private javax.swing.JTextField jHabilita;
    private javax.swing.JFormattedTextField jHorarioFinal;
    private javax.swing.JFormattedTextField jHorarioInicio;
    public static javax.swing.JTextField jIDFunc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JPanel jListagem;
    private javax.swing.JPanel jLogradouro;
    private javax.swing.JPanel jManutencao;
    public static javax.swing.JTextField jMatricula;
    private javax.swing.JTextField jNaturalidade;
    public static javax.swing.JTextField jNomeCargo;
    public static javax.swing.JTextField jNomeCargoEscala;
    private javax.swing.JTextField jNomeConjugue;
    private javax.swing.JTextField jNomeDependente;
    public static javax.swing.JTextField jNomeFuncionario;
    private javax.swing.JTextField jNomeMae;
    private javax.swing.JTextField jNomePai;
    private javax.swing.JTextArea jObservacao;
    private javax.swing.JTextField jOrgaoEmissor;
    private javax.swing.JTextField jPais;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JFormattedTextField jPeso;
    private javax.swing.JTextField jPesqMatricula;
    private javax.swing.JTextField jPesqNome;
    private javax.swing.JTextField jPis;
    private javax.swing.JTextField jProfissao;
    private javax.swing.JTextField jQtdFolga;
    private javax.swing.JTextField jQtdTrabalho;
    private javax.swing.JFormattedTextField jRG;
    private javax.swing.JTextField jReligiao;
    private javax.swing.JTextField jReservista;
    private javax.swing.JTextField jSapato;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jSecao;
    private javax.swing.JTextField jSerie;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable jTabelaDependentes;
    private javax.swing.JTable jTabelaFuncionario;
    private javax.swing.JFormattedTextField jTelefone;
    private javax.swing.JFormattedTextField jTelefoneEnd;
    private javax.swing.JTextField jTipoSang;
    private javax.swing.JTextField jTitulo;
    private javax.swing.JTextField jTurmaEscala;
    private javax.swing.JTextField jTurnoEscala;
    private javax.swing.JTextField jURL;
    private javax.swing.JTextField jZona;
    private javax.swing.JLabel jtotalItens;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void formatarCampos() {
        jPesqNome.setDocument(new LimiteDigitos(50));
        // AINDA NÃO FOI VERIFICADO (20/04/2016)
        jNomeFuncionario.setDocument(new LimiteDigitos(58));
        jMatricula.setDocument(new LimiteDigitosNum(10));
        jNomeMae.setDocument(new LimiteDigitos(66));
        jNomePai.setDocument(new LimiteDigitos(66));
        jReligiao.setDocument(new LimiteDigitos(34));
        jTipoSang.setDocument(new LimiteDigitos(14));
        jFuncao.setDocument(new LimiteDigitos(67));
        jCargaHoraria.setDocument(new LimiteDigitosNum(7));
        jPais.setDocument(new LimiteDigitos(50));
        jNaturalidade.setDocument(new LimiteDigitos(150));
        //
        jEndereco.setDocument(new LimiteDigitosAlfa(75));
        jBairro.setDocument(new LimiteDigitosAlfa(75));
        jComplemento.setDocument(new LimiteDigitosAlfa(75));
        jCidade.setDocument(new LimiteDigitos(32));
        jEmail.setDocument(new LimiteDigitosMin(75));
        jURL.setDocument(new LimiteDigitosMin(75));
        jObservacao.setLineWrap(true);
        jObservacao.setWrapStyleWord(true);
        // DOCUMENTOS       
        jOrgaoEmissor.setDocument(new LimiteDigitos(6));
        jPis.setDocument(new LimiteDigitosNum(14));
        jTitulo.setDocument(new LimiteDigitosNum(17));
        jZona.setDocument(new LimiteDigitosNum(14));
        jSecao.setDocument(new LimiteDigitosNum(14));
        jCTPS.setDocument(new LimiteDigitosNum(17));
        jSerie.setDocument(new LimiteDigitosNum(14));
        jHabilita.setDocument(new LimiteDigitosNum(14));
        jReservista.setDocument(new LimiteDigitosNum(17));
        jCategoria.setDocument(new LimiteDigitos(14));
        jCartaoSaude.setDocument(new LimiteDigitosNum(14));
        jProfissao.setDocument(new LimiteDigitos(65));
        jAltura.setDocument(new LimiteDigitosNum(4));
        jCalca.setDocument(new LimiteDigitosNum(2));
        jSapato.setDocument(new LimiteDigitosNum(2));
        jPeso.setDocument(new LimiteDigitosNum(5));
        jCamisa.setDocument(new LimiteDigitosNum(4));
        jCarteiraconselho.setDocument(new LimiteDigitosNum(21));
        jNomeConjugue.setDocument(new LimiteDigitosAlfa(60));
        try {
            // FORMATAR HORÁRIO DE TRABALHO
            MaskFormatter horaInicial = new MaskFormatter("##:##");
            jHorarioInicio.setFormatterFactory(new DefaultFormatterFactory(horaInicial));
            //
            MaskFormatter horaFinal = new MaskFormatter("##:##");
            jHorarioFinal.setFormatterFactory(new DefaultFormatterFactory(horaFinal));
            //Formatação para números de telefones
            MaskFormatter telefone = new MaskFormatter("(##)-####-####");
            jTelefone.setFormatterFactory(new DefaultFormatterFactory(telefone));
            MaskFormatter telefoneEnd = new MaskFormatter("(##)-####-####");
            jTelefoneEnd.setFormatterFactory(new DefaultFormatterFactory(telefoneEnd));
            MaskFormatter celularEnd = new MaskFormatter("(##)-#####-####");
            jCelularEnd.setFormatterFactory(new DefaultFormatterFactory(celularEnd));
            //Formataçõa par CEP
            MaskFormatter cep = new MaskFormatter("##.###-###");
            jCep.setFormatterFactory(new DefaultFormatterFactory(cep));
            // Formatação para CPF
            MaskFormatter cpf = new MaskFormatter("###.###.###-##");
            jCPF.setFormatterFactory(new DefaultFormatterFactory(cpf));
            //Formatação para RG
            MaskFormatter rg = new MaskFormatter("##.###.###-##");
            jRG.setFormatterFactory(new DefaultFormatterFactory(rg));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possivel FORMATAR CAMPOS!!!\nERRO: " + ex);
        }
    }

    public void corCampo() {
        jIDFunc.setBackground(Color.WHITE);
        jComboBoxStatusFunc.setBackground(Color.WHITE);
        jDataAdmissao.setBackground(Color.WHITE);
        jNomeFuncionario.setBackground(Color.WHITE);
        jMatricula.setBackground(Color.WHITE);
        jComboBoxSexo.setBackground(Color.WHITE);
        jComboBoxEscolaridade.setBackground(Color.WHITE);
        jFotoColaborador.setBackground(Color.WHITE);
        jComboBoxEstadoCivil.setBackground(Color.WHITE);
        jDataNascimento.setBackground(Color.WHITE);
        jNomeMae.setBackground(Color.WHITE);
        jNomePai.setBackground(Color.WHITE);
        jReligiao.setBackground(Color.WHITE);
        jTipoSang.setBackground(Color.WHITE);
        // DEPARTAMENTO/CARGO
        jDepartamento.setBackground(Color.WHITE);
        jNomeCargo.setBackground(Color.WHITE);
        // CARGA HORÁRIA
        jCargaHoraria.setBackground(Color.WHITE);
        jComboBoxRegimeTrabalho.setBackground(Color.WHITE);
        jHorarioInicio.setBackground(Color.WHITE);
        jHorarioFinal.setBackground(Color.WHITE);
        jFuncao.setBackground(Color.WHITE);
        // NACIONALIDADE
        jComboBoxNacionalidade.setBackground(Color.WHITE);
        jPais.setBackground(Color.WHITE);
        // NATURALIDADE
        jNaturalidade.setBackground(Color.WHITE);
        jComboBoxEstadoNaturalidade.setBackground(Color.WHITE);
        // ENDEREÇO
        jEndereco.setBackground(Color.WHITE);
        jBairro.setBackground(Color.WHITE);
        jComplemento.setBackground(Color.WHITE);
        jCidade.setBackground(Color.WHITE);
        jComboBoxEstado.setBackground(Color.WHITE);
        jCep.setBackground(Color.WHITE);
        // CONTATO
        jEmail.setBackground(Color.WHITE);
        jTelefone.setBackground(Color.WHITE);
        jTelefoneEnd.setBackground(Color.WHITE);
        jCelularEnd.setBackground(Color.WHITE);
        jURL.setBackground(Color.WHITE);
        jObservacao.setBackground(Color.WHITE);
        // DOCUMENTOS
        jRG.setBackground(Color.WHITE);
        jCPF.setBackground(Color.WHITE);
        jDataEmissaoRg.setBackground(Color.WHITE);
        jOrgaoEmissor.setBackground(Color.WHITE);
        jPis.setBackground(Color.WHITE);
        jDataCadPis.setBackground(Color.WHITE);
        jTitulo.setBackground(Color.WHITE);
        jZona.setBackground(Color.WHITE);
        jSecao.setBackground(Color.WHITE);
        jCTPS.setBackground(Color.WHITE);
        jSerie.setBackground(Color.WHITE);
        jHabilita.setBackground(Color.WHITE);
        jReservista.setBackground(Color.WHITE);
        jCategoria.setBackground(Color.WHITE);
        jCartaoSaude.setBackground(Color.WHITE);
        jProfissao.setBackground(Color.WHITE);
        jAltura.setBackground(Color.WHITE);
        jCalca.setBackground(Color.WHITE);
        jSapato.setBackground(Color.WHITE);
        jPeso.setBackground(Color.WHITE);
        jCamisa.setBackground(Color.WHITE);
        jCarteiraconselho.setBackground(Color.WHITE);
        // CONJUGUE
        jComboBoxTipoConjugue.setBackground(Color.WHITE);
        jDataNasConjugue.setBackground(Color.WHITE);
        jNomeConjugue.setBackground(Color.WHITE);
        // DEPENDENTES
        jCodigoDependente.setBackground(Color.WHITE);
        jComboBoxParentesco.setBackground(Color.WHITE);
        jNomeDependente.setBackground(Color.WHITE);
        jDataNascimentoParentesco.setBackground(Color.WHITE);
        jtotalItens.setBackground(Color.WHITE);
        //ESCALA DE TRABALHO
        jCodigoEscala.setBackground(Color.WHITE);
        jComboBoxDescricaoEscala.setBackground(Color.WHITE);
        jQtdTrabalho.setBackground(Color.WHITE);
        jQtdFolga.setBackground(Color.WHITE);
        jTurnoEscala.setBackground(Color.WHITE);
        jTurmaEscala.setBackground(Color.WHITE);
        jDepartamentoEscala.setBackground(Color.WHITE);
        jNomeCargoEscala.setBackground(Color.WHITE);
    }

    public void limparCamposRegistro() {
        jIDFunc.setText("");
        jComboBoxStatusFunc.setSelectedItem("Ativo");
        jDataAdmissao.setCalendar(Calendar.getInstance());
        jNomeFuncionario.setText("");
        jMatricula.setText("");
        jComboBoxSexo.setSelectedItem("Selecione...");
        jComboBoxEscolaridade.setSelectedItem("Selecione...");
        jFotoColaborador.setIcon(null);
        jComboBoxEstadoCivil.setSelectedItem("Selecione...");
        jDataNascimento.setDate(null);
        jNomeMae.setText("");
        jNomePai.setText("");
        jReligiao.setText("");
        jTipoSang.setText("");
        // DEPARTAMENTO/CARGO
        jDepartamento.setText("");
        jNomeCargo.setText("");
        // CARGA HORÁRIA
        jCargaHoraria.setText("");
        jComboBoxRegimeTrabalho.setSelectedItem("Selecione...");
        jHorarioInicio.setText("");
        jHorarioFinal.setText("");
        jFuncao.setText("");
        // NACIONALIDADE
        jComboBoxNacionalidade.setSelectedItem("Selecione...");
        jPais.setText("");
        // NATURALIDADE
        jNaturalidade.setText("");
        jComboBoxEstadoNaturalidade.setSelectedItem("Selecione...");
        // ENDEREÇO
        jEndereco.setText("");
        jBairro.setText("");
        jComplemento.setText("");
        jCidade.setText("");
        jComboBoxEstado.setSelectedItem("Selecione...");
        jCep.setText("");
        // CONTATO
        jEmail.setText("");
        jTelefone.setText("");
        jTelefoneEnd.setText("");
        jCelularEnd.setText("");
        jURL.setText("");
        jObservacao.setText("");
        // DOCUMENTOS
        jRG.setText("");
        jCPF.setText("");
        jDataEmissaoRg.setDate(null);
        jOrgaoEmissor.setText("");
        jComboBoxEstadoOrgao.setSelectedItem(null);
        jPis.setText("");
        jDataCadPis.setDate(null);
        jTitulo.setText("");
        jZona.setText("");
        jSecao.setText("");
        jCTPS.setText("");
        jSerie.setText("");
        jHabilita.setText("");
        jReservista.setText("");
        jCategoria.setText("");
        jCartaoSaude.setText("");
        jProfissao.setText("");
        jAltura.setText("");
        jCalca.setText("");
        jSapato.setText("");
        jPeso.setText("");
        jCamisa.setText("");
        jCarteiraconselho.setText("");
        // CONJUGUE
        jComboBoxTipoConjugue.setSelectedItem("Selecione...");
        jDataNasConjugue.setDate(null);
        jNomeConjugue.setText("");
        // DEPENDENTES
        jCodigoDependente.setText("");
        jComboBoxParentesco.setSelectedItem("Selecione...");
        jNomeConjugue.setText("");
        jDataNascimentoParentesco.setDate(null);
        jtotalItens.setText("");
    }

    public void Novo() {
        // MANUTENÇÃO
        jIDFunc.setText("");
        jComboBoxStatusFunc.setSelectedItem("Ativo");
        jDataAdmissao.setCalendar(Calendar.getInstance());
        jNomeFuncionario.setText("");
        jMatricula.setText("");
        jComboBoxSexo.setSelectedItem("Selecione...");
        jComboBoxEscolaridade.setSelectedItem("Selecione...");
        jFotoColaborador.setIcon(null);
        caminhoFotoFunc = "";
        jComboBoxEstadoCivil.setSelectedItem("Selecione...");
        jDataNascimento.setDate(null);
        jNomeMae.setText("");
        jNomePai.setText("");
        jReligiao.setText("");
        jTipoSang.setText("");
        // DEPARTAMENTO/CARGO
        jDepartamento.setText("");
        jNomeCargo.setText("");
        // CARGA HORÁRIA
        jCargaHoraria.setText("");
        jComboBoxRegimeTrabalho.setSelectedItem("Selecione...");
        jHorarioInicio.setText("");
        jHorarioFinal.setText("");
        jFuncao.setText("");
        // NACIONALIDADE
        jComboBoxNacionalidade.setSelectedItem("Selecione...");
        jPais.setText("");
        // NATURALIDADE
        jNaturalidade.setText("");
        jComboBoxEstadoNaturalidade.setSelectedItem(null);
        // ENDEREÇO
        jEndereco.setText("");
        jBairro.setText("");
        jComplemento.setText("");
        jCidade.setText("");
        jComboBoxEstado.setSelectedItem(null);
        jCep.setText("");
        // CONTATO
        jEmail.setText("");
        jTelefone.setText("");
        jTelefoneEnd.setText("");
        jCelularEnd.setText("");
        jURL.setText("");
        jObservacao.setText("");
        // DOCUMENTOS
        jRG.setText("");
        jCPF.setText("");
        jDataEmissaoRg.setDate(null);
        jOrgaoEmissor.setText("");
        jComboBoxEstadoOrgao.setSelectedItem(null);
        jPis.setText("");
        jDataCadPis.setDate(null);
        jTitulo.setText("");
        jZona.setText("");
        jSecao.setText("");
        jCTPS.setText("");
        jSerie.setText("");
        jHabilita.setText("");
        jReservista.setText("");
        jCategoria.setText("");
        jCartaoSaude.setText("");
        jProfissao.setText("");
        jAltura.setText("");
        jCalca.setText("");
        jSapato.setText("");
        jPeso.setText("");
        jCamisa.setText("");
        jCarteiraconselho.setText("");
        // CONJUGUE
        jComboBoxTipoConjugue.setSelectedItem("Selecione...");
        jDataNasConjugue.setDate(null);
        jNomeConjugue.setText("");
        // DEPENDENTES
        jCodigoDependente.setText("");
        jComboBoxParentesco.setSelectedItem("Selecione...");
        jNomeConjugue.setText("");
        jDataNascimentoParentesco.setDate(null);
        jtotalItens.setText("");
        // Habiltar os campos        
        jComboBoxStatusFunc.setEnabled(true);
        jDataAdmissao.setEnabled(true);
        jMatricula.setEnabled(true);
        jNomeFuncionario.setEnabled(true);
        jComboBoxEscolaridade.setEnabled(true);
        jComboBoxSexo.setEnabled(true);
        jComboBoxEstadoCivil.setEnabled(true);
        jDataNascimento.setEnabled(true);
        jNomeMae.setEnabled(true);
        jNomePai.setEnabled(true);
        jReligiao.setEnabled(true);
        jTipoSang.setEnabled(true);
        // DEPARTAMENTO/CARGO
        jBtPesqDepto.setEnabled(true);
        jBtPesqCargo.setEnabled(true);
        // CARGA HORÁRIA
        jCargaHoraria.setEnabled(true);
        jComboBoxRegimeTrabalho.setEnabled(true);
        jHorarioInicio.setEnabled(true);
        jHorarioFinal.setEnabled(true);
        jFuncao.setEnabled(true);
        // NACIONALIDADE
        jComboBoxNacionalidade.setEnabled(true);
        jPais.setEnabled(true);
        // NATURALIDADE
        jNaturalidade.setEnabled(true);
        jComboBoxEstadoNaturalidade.setEnabled(true);
        // Habiltar/Desabilitar os botões
        jBtNovoFoto2.setEnabled(true);
        jBtExcluirFoto2.setEnabled(true);
        // ENDEREÇO
        jEndereco.setEnabled(true);
        jBairro.setEnabled(true);
        jComplemento.setEnabled(true);
        jCidade.setEnabled(true);
        jComboBoxEstado.setEnabled(true);
        jCep.setEnabled(true);
        // CONTATO
        jEmail.setEnabled(true);
        jTelefone.setEnabled(true);
        jTelefoneEnd.setEnabled(true);
        jCelularEnd.setEnabled(true);
        jURL.setEnabled(true);
        jObservacao.setEnabled(true);
        // DOCUMENTOS
        jRG.setEnabled(true);
        jCPF.setEnabled(true);
        jDataEmissaoRg.setEnabled(true);
        jOrgaoEmissor.setEnabled(true);
        jComboBoxEstadoOrgao.setEnabled(true);
        jPis.setEnabled(true);
        jDataCadPis.setEnabled(true);
        jTitulo.setEnabled(true);
        jZona.setEnabled(true);
        jSecao.setEnabled(true);
        jCTPS.setEnabled(true);
        jSerie.setEnabled(true);
        jHabilita.setEnabled(true);
        jReservista.setEnabled(true);
        jCategoria.setEnabled(true);
        jCartaoSaude.setEnabled(true);
        jProfissao.setEnabled(true);
        jAltura.setEnabled(true);
        jCalca.setEnabled(true);
        jSapato.setEnabled(true);
        jPeso.setEnabled(true);
        jCamisa.setEnabled(true);
        jCarteiraconselho.setEnabled(true);
        jComboBoxTipoConjugue.setEnabled(true);
        jDataNasConjugue.setEnabled(true);
        jNomeConjugue.setEnabled(true);
        // BOTÕES MANUTENÇÃO
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtAuditoria.setEnabled(!true);
        jBtBiometria.setEnabled(!true);
        jBtNovoFoto2.setEnabled(true);
        jBtExcluirFoto2.setEnabled(true);
        jBtWebCam.setEnabled(true);
        // BOTÕES ENDEREÇO
        jBtNovoLogradouro.setEnabled(!true);
        jBtAlterarLogradouro.setEnabled(!true);
        jBtExcluirLogradouro.setEnabled(!true);
        jBtSalvarLogradouro.setEnabled(true);
        jBtCancelarLogradouro.setEnabled(true);
        jBtAuditoriaLogradouro.setEnabled(!true);
        //BOTÕES DOCUMETOS
        jBtNovoDocumentos.setEnabled(!true);
        jBtAlterarDocumentos.setEnabled(!true);
        jBtExcluirDocumentos.setEnabled(!true);
        jBtSalvarDocumentos.setEnabled(true);
        jBtCancelarDocumentos.setEnabled(true);
        jBtAuditoriaDocumentos.setEnabled(!true);
        jBtImpressaoFichaColaborador.setEnabled(!true);
        // BOTÕES DEPENDENTES
        jBtNovoDependente.setEnabled(!true);
        jBtAlterarDependente.setEnabled(!true);
        jBtExcluirDependente.setEnabled(!true);
        jBtSalvarDependente.setEnabled(!true);
        jBtCancelarDependente.setEnabled(!true);
        jBtAuditoriaDependente.setEnabled(!true);
        //        
        limparTabelaDependente();
    }

    public void Alterar() {
        // Habiltar os campos     
        jComboBoxStatusFunc.setEnabled(true);
        jDataAdmissao.setEnabled(true);
        jMatricula.setEnabled(true);
        jNomeFuncionario.setEnabled(true);
        jComboBoxEscolaridade.setEnabled(true);
        jComboBoxSexo.setEnabled(true);
        jComboBoxEstadoCivil.setEnabled(true);
        jDataNascimento.setEnabled(true);
        jNomeMae.setEnabled(true);
        jNomePai.setEnabled(true);
        jReligiao.setEnabled(true);
        jTipoSang.setEnabled(true);
        // DEPARTAMENTO/CARGO
        jBtPesqDepto.setEnabled(true);
        jBtPesqCargo.setEnabled(true);
        // CARGA HORÁRIA
        jCargaHoraria.setEnabled(true);
        jComboBoxRegimeTrabalho.setEnabled(true);
        jHorarioInicio.setEnabled(true);
        jHorarioFinal.setEnabled(true);
        jFuncao.setEnabled(true);
        // NACIONALIDADE
        jComboBoxNacionalidade.setEnabled(true);
        jPais.setEnabled(true);
        // NATURALIDADE
        jNaturalidade.setEnabled(true);
        jComboBoxEstadoNaturalidade.setEnabled(true);
        // Habiltar/Desabilitar os botões
        jBtNovoFoto2.setEnabled(true);
        jBtExcluirFoto2.setEnabled(true);
        // ENDEREÇO
        jEndereco.setEnabled(true);
        jBairro.setEnabled(true);
        jComplemento.setEnabled(true);
        jCidade.setEnabled(true);
        jComboBoxEstado.setEnabled(true);
        jCep.setEnabled(true);
        // CONTATO
        jEmail.setEnabled(true);
        jTelefone.setEnabled(true);
        jTelefoneEnd.setEnabled(true);
        jCelularEnd.setEnabled(true);
        jURL.setEnabled(true);
        jObservacao.setEnabled(true);
        // DOCUMENTOS
        jRG.setEnabled(true);
        jCPF.setEnabled(true);
        jDataEmissaoRg.setEnabled(true);
        jOrgaoEmissor.setEnabled(true);
        jComboBoxEstadoOrgao.setEnabled(true);
        jPis.setEnabled(true);
        jDataCadPis.setEnabled(true);
        jTitulo.setEnabled(true);
        jZona.setEnabled(true);
        jSecao.setEnabled(true);
        jCTPS.setEnabled(true);
        jSerie.setEnabled(true);
        jHabilita.setEnabled(true);
        jReservista.setEnabled(true);
        jCategoria.setEnabled(true);
        jCartaoSaude.setEnabled(true);
        jProfissao.setEnabled(true);
        jAltura.setEnabled(true);
        jCalca.setEnabled(true);
        jSapato.setEnabled(true);
        jPeso.setEnabled(true);
        jCamisa.setEnabled(true);
        jCarteiraconselho.setEnabled(true);
        jComboBoxTipoConjugue.setEnabled(true);
        jDataNasConjugue.setEnabled(true);
        jNomeConjugue.setEnabled(true);
        // BOTÕES MANUTENÇÃO
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtAuditoria.setEnabled(!true);
        jBtBiometria.setEnabled(!true);
        jBtNovoFoto2.setEnabled(true);
        jBtExcluirFoto2.setEnabled(true);
        jBtWebCam.setEnabled(true);
        // BOTÕES ENDEREÇO
        jBtNovoLogradouro.setEnabled(!true);
        jBtAlterarLogradouro.setEnabled(!true);
        jBtExcluirLogradouro.setEnabled(!true);
        jBtSalvarLogradouro.setEnabled(true);
        jBtCancelarLogradouro.setEnabled(true);
        jBtAuditoriaLogradouro.setEnabled(!true);
        //BOTÕES DOCUMENTOS
        jBtNovoDocumentos.setEnabled(!true);
        jBtAlterarDocumentos.setEnabled(!true);
        jBtExcluirDocumentos.setEnabled(!true);
        jBtSalvarDocumentos.setEnabled(true);
        jBtCancelarDocumentos.setEnabled(true);
        jBtAuditoriaDocumentos.setEnabled(!true);
        jBtImpressaoFichaColaborador.setEnabled(!true);
        // BOTÕES DEPENDENTES
        jBtNovoDependente.setEnabled(!true);
        jBtAlterarDependente.setEnabled(!true);
        jBtExcluirDependente.setEnabled(!true);
        jBtSalvarDependente.setEnabled(!true);
        jBtCancelarDependente.setEnabled(!true);
        jBtAuditoriaDependente.setEnabled(!true);
    }

    public void Excluir() {
        // MANUTENÇÃO
        jIDFunc.setText("");
        jComboBoxStatusFunc.setSelectedItem("Ativo");
        jDataAdmissao.setDate(null);
        jNomeFuncionario.setText("");
        jMatricula.setText("");
        jComboBoxSexo.setSelectedItem("Selecione");
        jComboBoxEscolaridade.setSelectedItem("Selecione");
        jFotoColaborador.setIcon(null);
        jComboBoxEstadoCivil.setSelectedItem("Selecione");
        jDataNascimento.setDate(null);
        jNomeMae.setText("");
        jNomePai.setText("");
        jReligiao.setText("");
        jTipoSang.setText("");
        // DEPARTAMENTO/CARGO
        jDepartamento.setText("");
        jNomeCargo.setText("");
        // CARGA HORÁRIA
        jCargaHoraria.setText("");
        jComboBoxRegimeTrabalho.setSelectedItem("Selecione");
        jHorarioInicio.setText("");
        jHorarioFinal.setText("");
        jFuncao.setText("");
        // NACIONALIDADE
        jComboBoxNacionalidade.setSelectedItem("Selecione");
        jPais.setText("");
        // NATURALIDADE
        jNaturalidade.setText("");
        jComboBoxEstadoNaturalidade.setSelectedItem(null);
        // ENDEREÇO
        jEndereco.setText("");
        jBairro.setText("");
        jComplemento.setText("");
        jCidade.setText("");
        jComboBoxEstado.setSelectedItem(null);
        jCep.setText("");
        // CONTATO
        jEmail.setText("");
        jTelefone.setText("");
        jTelefoneEnd.setText("");
        jCelularEnd.setText("");
        jURL.setText("");
        jObservacao.setText("");
        // DOCUMENTOS
        jRG.setText("");
        jCPF.setText("");
        jDataEmissaoRg.setDate(null);
        jOrgaoEmissor.setText("");
        jComboBoxEstadoOrgao.setSelectedItem(null);
        jPis.setText("");
        jDataCadPis.setDate(null);
        jTitulo.setText("");
        jZona.setText("");
        jSecao.setText("");
        jCTPS.setText("");
        jSerie.setText("");
        jHabilita.setText("");
        jReservista.setText("");
        jCategoria.setText("");
        jCartaoSaude.setText("");
        jProfissao.setText("");
        jAltura.setText("");
        jCalca.setText("");
        jSapato.setText("");
        jPeso.setText("");
        jCamisa.setText("");
        jCarteiraconselho.setText("");
        // CONJUGUE
        jComboBoxTipoConjugue.setSelectedItem("Selecione");
        jDataNasConjugue.setDate(null);
        jNomeConjugue.setText("");
        // DEPENDENTES
        jCodigoDependente.setText("");
        jComboBoxParentesco.setSelectedItem("Selecione");
        jNomeConjugue.setText("");
        jDataNascimentoParentesco.setDate(null);
        jtotalItens.setText("");
        // Habiltar os campos        
        jComboBoxStatusFunc.setEnabled(!true);
        jDataAdmissao.setEnabled(!true);
        jMatricula.setEnabled(!true);
        jNomeFuncionario.setEnabled(!true);
        jComboBoxEscolaridade.setEnabled(!true);
        jComboBoxSexo.setEnabled(!true);
        jComboBoxEstadoCivil.setEnabled(!true);
        jDataNascimento.setEnabled(!true);
        jNomeMae.setEnabled(!true);
        jNomePai.setEnabled(!true);
        jReligiao.setEnabled(!true);
        jTipoSang.setEnabled(!true);
        // DEPARTAMENTO/CARGO
        jBtPesqDepto.setEnabled(!true);
        jBtPesqCargo.setEnabled(!true);
        // CARGA HORÁRIA
        jCargaHoraria.setEnabled(!true);
        jComboBoxRegimeTrabalho.setEnabled(!true);
        jHorarioInicio.setEnabled(!true);
        jHorarioFinal.setEnabled(!true);
        jFuncao.setEnabled(!true);
        // NACIONALIDADE
        jComboBoxNacionalidade.setEnabled(!true);
        jPais.setEnabled(!true);
        // NATURALIDADE
        jNaturalidade.setEnabled(!true);
        jComboBoxEstadoNaturalidade.setEnabled(!true);
        // Habiltar/Desabilitar os botões
        jBtNovoFoto2.setEnabled(!true);
        jBtExcluirFoto2.setEnabled(!true);
        // ENDEREÇO
        jEndereco.setEnabled(!true);
        jBairro.setEnabled(!true);
        jComplemento.setEnabled(!true);
        jCidade.setEnabled(!true);
        jComboBoxEstado.setEnabled(!true);
        jCep.setEnabled(!true);
        // CONTATO
        jEmail.setEnabled(!true);
        jTelefone.setEnabled(!true);
        jTelefoneEnd.setEnabled(!true);
        jCelularEnd.setEnabled(!true);
        jURL.setEnabled(!true);
        jObservacao.setEnabled(!true);
        // DOCUMENTOS
        jRG.setEnabled(!true);
        jCPF.setEnabled(!true);
        jDataEmissaoRg.setEnabled(!true);
        jOrgaoEmissor.setEnabled(!true);
        jComboBoxEstadoOrgao.setEnabled(!true);
        jPis.setEnabled(!true);
        jDataCadPis.setEnabled(!true);
        jTitulo.setEnabled(!true);
        jZona.setEnabled(!true);
        jSecao.setEnabled(!true);
        jCTPS.setEnabled(!true);
        jSerie.setEnabled(!true);
        jHabilita.setEnabled(!true);
        jReservista.setEnabled(!true);
        jCategoria.setEnabled(!true);
        jCartaoSaude.setEnabled(!true);
        jProfissao.setEnabled(!true);
        jAltura.setEnabled(!true);
        jCalca.setEnabled(!true);
        jSapato.setEnabled(!true);
        jPeso.setEnabled(!true);
        jCamisa.setEnabled(!true);
        jCarteiraconselho.setEnabled(!true);
        jComboBoxTipoConjugue.setEnabled(!true);
        jDataNasConjugue.setEnabled(!true);
        jNomeConjugue.setEnabled(!true);
        // BOTÕES MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        jBtBiometria.setEnabled(!true);
        jBtNovoFoto2.setEnabled(!true);
        jBtExcluirFoto2.setEnabled(!true);
        jBtWebCam.setEnabled(!true);
        // BOTÕES ENDEREÇO
        jBtNovoLogradouro.setEnabled(true);
        jBtAlterarLogradouro.setEnabled(!true);
        jBtExcluirLogradouro.setEnabled(!true);
        jBtSalvarLogradouro.setEnabled(!true);
        jBtCancelarLogradouro.setEnabled(!true);
        jBtAuditoriaLogradouro.setEnabled(!true);
        // BOTÕES DOCUMENTOS
        jBtNovoDocumentos.setEnabled(true);
        jBtAlterarDocumentos.setEnabled(!true);
        jBtExcluirDocumentos.setEnabled(!true);
        jBtSalvarDocumentos.setEnabled(!true);
        jBtCancelarDocumentos.setEnabled(!true);
        jBtAuditoriaDocumentos.setEnabled(!true);
        jBtImpressaoFichaColaborador.setEnabled(!true);
        // BOTÕES DEPENDENTES
        jBtNovoDependente.setEnabled(!true);
        jBtAlterarDependente.setEnabled(!true);
        jBtExcluirDependente.setEnabled(!true);
        jBtSalvarDependente.setEnabled(!true);
        jBtCancelarDependente.setEnabled(!true);
        jBtAuditoriaDependente.setEnabled(!true);
    }

    public void Salvar() {
        // Habiltar os campos        
        jComboBoxStatusFunc.setEnabled(!true);
        jDataAdmissao.setEnabled(!true);
        jMatricula.setEnabled(!true);
        jNomeFuncionario.setEnabled(!true);
        jComboBoxEscolaridade.setEnabled(!true);
        jComboBoxSexo.setEnabled(!true);
        jComboBoxEstadoCivil.setEnabled(!true);
        jDataNascimento.setEnabled(!true);
        jNomeMae.setEnabled(!true);
        jNomePai.setEnabled(!true);
        jReligiao.setEnabled(!true);
        jTipoSang.setEnabled(!true);
        // DEPARTAMENTO/CARGO
        jBtPesqDepto.setEnabled(!true);
        jBtPesqCargo.setEnabled(!true);
        // CARGA HORÁRIA
        jCargaHoraria.setEnabled(!true);
        jComboBoxRegimeTrabalho.setEnabled(!true);
        jHorarioInicio.setEnabled(!true);
        jHorarioFinal.setEnabled(!true);
        jFuncao.setEnabled(!true);
        // NACIONALIDADE
        jComboBoxNacionalidade.setEnabled(!true);
        jPais.setEnabled(!true);
        // NATURALIDADE
        jNaturalidade.setEnabled(!true);
        jComboBoxEstadoNaturalidade.setEnabled(!true);
        // Habiltar/Desabilitar os botões
        jBtNovoFoto2.setEnabled(!true);
        jBtExcluirFoto2.setEnabled(!true);
        // ENDEREÇO
        jEndereco.setEnabled(!true);
        jBairro.setEnabled(!true);
        jComplemento.setEnabled(!true);
        jCidade.setEnabled(!true);
        jComboBoxEstado.setEnabled(!true);
        jCep.setEnabled(!true);
        // CONTATO
        jEmail.setEnabled(!true);
        jTelefone.setEnabled(!true);
        jTelefoneEnd.setEnabled(!true);
        jCelularEnd.setEnabled(!true);
        jURL.setEnabled(!true);
        jObservacao.setEnabled(!true);
        // DOCUMENTOS
        jRG.setEnabled(!true);
        jCPF.setEnabled(!true);
        jDataEmissaoRg.setEnabled(!true);
        jOrgaoEmissor.setEnabled(!true);
        jComboBoxEstadoOrgao.setEnabled(!true);
        jPis.setEnabled(!true);
        jDataCadPis.setEnabled(!true);
        jTitulo.setEnabled(!true);
        jZona.setEnabled(!true);
        jSecao.setEnabled(!true);
        jCTPS.setEnabled(!true);
        jSerie.setEnabled(!true);
        jHabilita.setEnabled(!true);
        jReservista.setEnabled(!true);
        jCategoria.setEnabled(!true);
        jCartaoSaude.setEnabled(!true);
        jProfissao.setEnabled(!true);
        jAltura.setEnabled(!true);
        jCalca.setEnabled(!true);
        jSapato.setEnabled(!true);
        jPeso.setEnabled(!true);
        jCamisa.setEnabled(!true);
        jCarteiraconselho.setEnabled(!true);
        jComboBoxTipoConjugue.setEnabled(!true);
        jDataNasConjugue.setEnabled(!true);
        jNomeConjugue.setEnabled(!true);
        // BOTÕES MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
        jBtBiometria.setEnabled(true);
        jBtWebCam.setEnabled(!true);
        // BOTÕES ENDEREÇO
        jBtNovoLogradouro.setEnabled(true);
        jBtAlterarLogradouro.setEnabled(true);
        jBtExcluirLogradouro.setEnabled(true);
        jBtSalvarLogradouro.setEnabled(!true);
        jBtCancelarLogradouro.setEnabled(!true);
        jBtAuditoriaLogradouro.setEnabled(true);
        jBtNovoFoto2.setEnabled(!true);
        jBtExcluirFoto2.setEnabled(!true);
        jBtWebCam.setEnabled(!true);
        // BOTÕES DOCUMENTOS
        jBtNovoDocumentos.setEnabled(true);
        jBtAlterarDocumentos.setEnabled(true);
        jBtExcluirDocumentos.setEnabled(true);
        jBtSalvarDocumentos.setEnabled(!true);
        jBtCancelarDocumentos.setEnabled(!true);
        jBtAuditoriaDocumentos.setEnabled(true);
        jBtImpressaoFichaColaborador.setEnabled(!true);
        // BOTÕES DEPENDENTES
        jBtNovoDependente.setEnabled(true);
        jBtAlterarDependente.setEnabled(!true);
        jBtExcluirDependente.setEnabled(!true);
        jBtSalvarDependente.setEnabled(!true);
        jBtCancelarDependente.setEnabled(!true);
        jBtAuditoriaDependente.setEnabled(!true);
    }

    public void Cancelar() {
        if (jIDFunc.getText().equals("")) {
            // MANUTENÇÃO            
            jComboBoxStatusFunc.setSelectedItem("Ativo");
            jDataAdmissao.setDate(null);
            jNomeFuncionario.setText("");
            jMatricula.setText("");
            jComboBoxSexo.setSelectedItem("Selecione");
            jComboBoxEscolaridade.setSelectedItem("Selecione");
            jFotoColaborador.setIcon(null);
            jComboBoxEstadoCivil.setSelectedItem("Selecione");
            jDataNascimento.setDate(null);
            jNomeMae.setText("");
            jNomePai.setText("");
            jReligiao.setText("");
            jTipoSang.setText("");
            // DEPARTAMENTO/CARGO
            jDepartamento.setText("");
            jNomeCargo.setText("");
            // CARGA HORÁRIA
            jCargaHoraria.setText("");
            jComboBoxRegimeTrabalho.setSelectedItem("Selecione");
            jHorarioInicio.setText("");
            jHorarioFinal.setText("");
            jFuncao.setText("");
            // NACIONALIDADE
            jComboBoxNacionalidade.setSelectedItem("Selecione");
            jPais.setText("");
            // NATURALIDADE
            jNaturalidade.setText("");
            jComboBoxEstadoNaturalidade.setSelectedItem(null);
            // ENDEREÇO
            jEndereco.setText("");
            jBairro.setText("");
            jComplemento.setText("");
            jCidade.setText("");
            jComboBoxEstado.setSelectedItem(null);
            jCep.setText("");
            // CONTATO
            jEmail.setText("");
            jTelefone.setText("");
            jTelefoneEnd.setText("");
            jCelularEnd.setText("");
            jURL.setText("");
            jObservacao.setText("");
            // DOCUMENTOS
            jRG.setText("");
            jCPF.setText("");
            jDataEmissaoRg.setDate(null);
            jOrgaoEmissor.setText("");
            jComboBoxEstadoOrgao.setSelectedItem(null);
            jPis.setText("");
            jDataCadPis.setDate(null);
            jTitulo.setText("");
            jZona.setText("");
            jSecao.setText("");
            jCTPS.setText("");
            jSerie.setText("");
            jHabilita.setText("");
            jReservista.setText("");
            jCategoria.setText("");
            jCartaoSaude.setText("");
            jProfissao.setText("");
            jAltura.setText("");
            jCalca.setText("");
            jSapato.setText("");
            jPeso.setText("");
            jCamisa.setText("");
            jCarteiraconselho.setText("");
            // CONJUGUE
            jComboBoxTipoConjugue.setSelectedItem("Selecione");
            jDataNasConjugue.setDate(null);
            jNomeConjugue.setText("");
            // DEPENDENTES
            jCodigoDependente.setText("");
            jComboBoxParentesco.setSelectedItem("Selecione");
            jNomeConjugue.setText("");
            jDataNascimentoParentesco.setDate(null);
            jtotalItens.setText("");
            // Habiltar os campos        
            jComboBoxStatusFunc.setEnabled(!true);
            jDataAdmissao.setEnabled(!true);
            jMatricula.setEnabled(!true);
            jNomeFuncionario.setEnabled(!true);
            jComboBoxEscolaridade.setEnabled(!true);
            jComboBoxSexo.setEnabled(!true);
            jComboBoxEstadoCivil.setEnabled(!true);
            jDataNascimento.setEnabled(!true);
            jNomeMae.setEnabled(!true);
            jNomePai.setEnabled(!true);
            jReligiao.setEnabled(!true);
            jTipoSang.setEnabled(!true);
            // DEPARTAMENTO/CARGO
            jBtPesqDepto.setEnabled(!true);
            jBtPesqCargo.setEnabled(!true);
            // CARGA HORÁRIA
            jCargaHoraria.setEnabled(!true);
            jComboBoxRegimeTrabalho.setEnabled(!true);
            jHorarioInicio.setEnabled(!true);
            jHorarioFinal.setEnabled(!true);
            jFuncao.setEnabled(!true);
            // NACIONALIDADE
            jComboBoxNacionalidade.setEnabled(!true);
            jPais.setEnabled(!true);
            // NATURALIDADE
            jNaturalidade.setEnabled(!true);
            jComboBoxEstadoNaturalidade.setEnabled(!true);
            // ENDEREÇO
            jEndereco.setEnabled(!true);
            jBairro.setEnabled(!true);
            jComplemento.setEnabled(!true);
            jCidade.setEnabled(!true);
            jComboBoxEstado.setEnabled(!true);
            jCep.setEnabled(!true);
            // CONTATO
            jEmail.setEnabled(!true);
            jTelefone.setEnabled(!true);
            jTelefoneEnd.setEnabled(!true);
            jCelularEnd.setEnabled(!true);
            jURL.setEnabled(!true);
            jObservacao.setEnabled(!true);
            // DOCUMENTOS
            jRG.setEnabled(!true);
            jCPF.setEnabled(!true);
            jDataEmissaoRg.setEnabled(!true);
            jOrgaoEmissor.setEnabled(!true);
            jComboBoxEstadoOrgao.setEnabled(!true);
            jPis.setEnabled(!true);
            jDataCadPis.setEnabled(!true);
            jTitulo.setEnabled(!true);
            jZona.setEnabled(!true);
            jSecao.setEnabled(!true);
            jCTPS.setEnabled(!true);
            jSerie.setEnabled(!true);
            jHabilita.setEnabled(!true);
            jReservista.setEnabled(!true);
            jCategoria.setEnabled(!true);
            jCartaoSaude.setEnabled(!true);
            jProfissao.setEnabled(!true);
            jAltura.setEnabled(!true);
            jCalca.setEnabled(!true);
            jSapato.setEnabled(!true);
            jPeso.setEnabled(!true);
            jCamisa.setEnabled(!true);
            jCarteiraconselho.setEnabled(!true);
            jComboBoxTipoConjugue.setEnabled(!true);
            jDataNasConjugue.setEnabled(!true);
            jNomeConjugue.setEnabled(!true);
            // BOTÕES MANUTENÇÃO
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtAuditoria.setEnabled(!true);
            jBtBiometria.setEnabled(!true);
            jBtNovoFoto2.setEnabled(!true);
            jBtExcluirFoto2.setEnabled(!true);
            jBtWebCam.setEnabled(!true);
            // BOTÕES ENDEREÇO
            jBtNovoLogradouro.setEnabled(true);
            jBtAlterarLogradouro.setEnabled(!true);
            jBtExcluirLogradouro.setEnabled(!true);
            jBtSalvarLogradouro.setEnabled(!true);
            jBtCancelarLogradouro.setEnabled(!true);
            jBtAuditoriaLogradouro.setEnabled(!true);
            // BOTÕES DOCUMENTOS
            jBtNovoDocumentos.setEnabled(true);
            jBtAlterarDocumentos.setEnabled(!true);
            jBtExcluirDocumentos.setEnabled(!true);
            jBtSalvarDocumentos.setEnabled(!true);
            jBtCancelarDocumentos.setEnabled(!true);
            jBtAuditoriaDocumentos.setEnabled(!true);
            jBtImpressaoFichaColaborador.setEnabled(!true);
            // BOTÕES DEPENDENTES
            jBtNovoDependente.setEnabled(!true);
            jBtAlterarDependente.setEnabled(!true);
            jBtExcluirDependente.setEnabled(!true);
            jBtSalvarDependente.setEnabled(!true);
            jBtCancelarDependente.setEnabled(!true);
            jBtAuditoriaDependente.setEnabled(!true);
        } else {
            // Habiltar os campos        
            jComboBoxStatusFunc.setEnabled(!true);
            jDataAdmissao.setEnabled(!true);
            jMatricula.setEnabled(!true);
            jNomeFuncionario.setEnabled(!true);
            jComboBoxEscolaridade.setEnabled(!true);
            jComboBoxSexo.setEnabled(!true);
            jComboBoxEstadoCivil.setEnabled(!true);
            jDataNascimento.setEnabled(!true);
            jNomeMae.setEnabled(!true);
            jNomePai.setEnabled(!true);
            jReligiao.setEnabled(!true);
            jTipoSang.setEnabled(!true);
            // DEPARTAMENTO/CARGO
            jBtPesqDepto.setEnabled(!true);
            jBtPesqCargo.setEnabled(!true);
            // CARGA HORÁRIA
            jCargaHoraria.setEnabled(!true);
            jComboBoxRegimeTrabalho.setEnabled(!true);
            jHorarioInicio.setEnabled(!true);
            jHorarioFinal.setEnabled(!true);
            jFuncao.setEnabled(!true);
            // NACIONALIDADE
            jComboBoxNacionalidade.setEnabled(!true);
            jPais.setEnabled(!true);
            // NATURALIDADE
            jNaturalidade.setEnabled(!true);
            jComboBoxEstadoNaturalidade.setEnabled(!true);
            // Habiltar/Desabilitar os botões
            // ENDEREÇO
            jEndereco.setEnabled(!true);
            jBairro.setEnabled(!true);
            jComplemento.setEnabled(!true);
            jCidade.setEnabled(!true);
            jComboBoxEstado.setEnabled(!true);
            jCep.setEnabled(!true);
            // CONTATO
            jEmail.setEnabled(!true);
            jTelefone.setEnabled(!true);
            jTelefoneEnd.setEnabled(!true);
            jCelularEnd.setEnabled(!true);
            jURL.setEnabled(!true);
            jObservacao.setEnabled(!true);
            // DOCUMENTOS
            jRG.setEnabled(!true);
            jCPF.setEnabled(!true);
            jDataEmissaoRg.setEnabled(!true);
            jOrgaoEmissor.setEnabled(!true);
            jComboBoxEstadoOrgao.setEnabled(!true);
            jPis.setEnabled(!true);
            jDataCadPis.setEnabled(!true);
            jTitulo.setEnabled(!true);
            jZona.setEnabled(!true);
            jSecao.setEnabled(!true);
            jCTPS.setEnabled(!true);
            jSerie.setEnabled(!true);
            jHabilita.setEnabled(!true);
            jReservista.setEnabled(!true);
            jCategoria.setEnabled(!true);
            jCartaoSaude.setEnabled(!true);
            jProfissao.setEnabled(!true);
            jAltura.setEnabled(!true);
            jCalca.setEnabled(!true);
            jSapato.setEnabled(!true);
            jPeso.setEnabled(!true);
            jCamisa.setEnabled(!true);
            jCarteiraconselho.setEnabled(!true);
            jComboBoxTipoConjugue.setEnabled(!true);
            jDataNasConjugue.setEnabled(!true);
            jNomeConjugue.setEnabled(!true);
            // BOTÕES MANUTENÇÃO
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtAuditoria.setEnabled(!true);
            jBtBiometria.setEnabled(!true);
            jBtNovoFoto2.setEnabled(!true);
            jBtExcluirFoto2.setEnabled(!true);
            jBtWebCam.setEnabled(!true);
            // BOTÕES ENDEREÇO
            jBtNovoLogradouro.setEnabled(true);
            jBtAlterarLogradouro.setEnabled(true);
            jBtExcluirLogradouro.setEnabled(true);
            jBtSalvarLogradouro.setEnabled(!true);
            jBtCancelarLogradouro.setEnabled(!true);
            jBtAuditoriaLogradouro.setEnabled(!true);
            // BOTÕES DOCUMENTOS
            jBtNovoDocumentos.setEnabled(true);
            jBtAlterarDocumentos.setEnabled(true);
            jBtExcluirDocumentos.setEnabled(true);
            jBtSalvarDocumentos.setEnabled(!true);
            jBtCancelarDocumentos.setEnabled(!true);
            jBtAuditoriaDocumentos.setEnabled(!true);
            jBtImpressaoFichaColaborador.setEnabled(!true);
            // BOTÕES DEPENDENTES
            jBtNovoDependente.setEnabled(true);
            jBtAlterarDependente.setEnabled(!true);
            jBtExcluirDependente.setEnabled(!true);
            jBtSalvarDependente.setEnabled(!true);
            jBtCancelarDependente.setEnabled(!true);
            jBtAuditoriaDependente.setEnabled(!true);
        }
    }

    public void NovoDependente() {
        // MANUTENÇÃO
        jComboBoxStatusFunc.setEnabled(!true);
        jDataAdmissao.setEnabled(!true);
        jMatricula.setEnabled(!true);
        jNomeFuncionario.setEnabled(!true);
        jComboBoxEscolaridade.setEnabled(!true);
        jComboBoxSexo.setEnabled(!true);
        jComboBoxEstadoCivil.setEnabled(!true);
        jDataNascimento.setEnabled(!true);
        jNomeMae.setEnabled(!true);
        jNomePai.setEnabled(!true);
        jReligiao.setEnabled(!true);
        jTipoSang.setEnabled(!true);
        // DEPARTAMENTO/CARGO
        jBtPesqDepto.setEnabled(!true);
        jBtPesqCargo.setEnabled(!true);
        // CARGA HORÁRIA
        jCargaHoraria.setEnabled(!true);
        jComboBoxRegimeTrabalho.setEnabled(!true);
        jHorarioInicio.setEnabled(!true);
        jHorarioFinal.setEnabled(!true);
        jFuncao.setEnabled(!true);
        // NACIONALIDADE
        jComboBoxNacionalidade.setEnabled(!true);
        jPais.setEnabled(!true);
        // NATURALIDADE
        jNaturalidade.setEnabled(!true);
        jComboBoxEstadoNaturalidade.setEnabled(!true);
        // Habiltar/Desabilitar os botões
        // ENDEREÇO
        jEndereco.setEnabled(!true);
        jBairro.setEnabled(!true);
        jComplemento.setEnabled(!true);
        jCidade.setEnabled(!true);
        jComboBoxEstado.setEnabled(!true);
        jCep.setEnabled(!true);
        // CONTATO
        jEmail.setEnabled(!true);
        jTelefone.setEnabled(!true);
        jTelefoneEnd.setEnabled(!true);
        jCelularEnd.setEnabled(!true);
        jURL.setEnabled(!true);
        jObservacao.setEnabled(!true);
        // DOCUMENTOS
        jRG.setEnabled(!true);
        jCPF.setEnabled(!true);
        jDataEmissaoRg.setEnabled(!true);
        jOrgaoEmissor.setEnabled(!true);
        jComboBoxEstadoOrgao.setEnabled(!true);
        jPis.setEnabled(!true);
        jDataCadPis.setEnabled(!true);
        jTitulo.setEnabled(!true);
        jZona.setEnabled(!true);
        jSecao.setEnabled(!true);
        jCTPS.setEnabled(!true);
        jSerie.setEnabled(!true);
        jHabilita.setEnabled(!true);
        jReservista.setEnabled(!true);
        jCategoria.setEnabled(!true);
        jCartaoSaude.setEnabled(!true);
        jProfissao.setEnabled(!true);
        jAltura.setEnabled(!true);
        jCalca.setEnabled(!true);
        jSapato.setEnabled(!true);
        jPeso.setEnabled(!true);
        jCamisa.setEnabled(!true);
        jCarteiraconselho.setEnabled(!true);
        jComboBoxTipoConjugue.setEnabled(!true);
        jDataNasConjugue.setEnabled(!true);
        jNomeConjugue.setEnabled(!true);
        // BOTÕES MANUTENÇÃO
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        jBtBiometria.setEnabled(!true);
        jBtNovoFoto2.setEnabled(!true);
        jBtExcluirFoto2.setEnabled(!true);
        jBtWebCam.setEnabled(!true);
        // BOTÕES ENDEREÇO
        jBtNovoLogradouro.setEnabled(!true);
        jBtAlterarLogradouro.setEnabled(!true);
        jBtExcluirLogradouro.setEnabled(!true);
        jBtSalvarLogradouro.setEnabled(!true);
        jBtCancelarLogradouro.setEnabled(!true);
        jBtAuditoriaLogradouro.setEnabled(!true);
        // BOTÕES DOCUMENTOS
        jBtNovoDocumentos.setEnabled(!true);
        jBtAlterarDocumentos.setEnabled(!true);
        jBtExcluirDocumentos.setEnabled(!true);
        jBtSalvarDocumentos.setEnabled(!true);
        jBtCancelarDocumentos.setEnabled(!true);
        jBtAuditoriaDocumentos.setEnabled(!true);
        jBtImpressaoFichaColaborador.setEnabled(!true);
        // DEPENDENTES
        jCodigoDependente.setText("");
        jComboBoxParentesco.setSelectedItem("Selecione");
        jDataNascimentoParentesco.setCalendar(Calendar.getInstance());
        jNomeDependente.setText("");
        //
        jComboBoxParentesco.setEnabled(true);
        jDataNascimentoParentesco.setEnabled(true);
        jNomeDependente.setEnabled(true);
        // BOTÕES 
        jBtNovoDependente.setEnabled(!true);
        jBtAlterarDependente.setEnabled(!true);
        jBtExcluirDependente.setEnabled(!true);
        jBtSalvarDependente.setEnabled(true);
        jBtCancelarDependente.setEnabled(true);
        jBtAuditoriaDependente.setEnabled(!true);
    }

    public void AlterarDependente() {
        // MANUTENÇÃO
        jComboBoxStatusFunc.setEnabled(!true);
        jDataAdmissao.setEnabled(!true);
        jMatricula.setEnabled(!true);
        jNomeFuncionario.setEnabled(!true);
        jComboBoxEscolaridade.setEnabled(!true);
        jComboBoxSexo.setEnabled(!true);
        jComboBoxEstadoCivil.setEnabled(!true);
        jDataNascimento.setEnabled(!true);
        jNomeMae.setEnabled(!true);
        jNomePai.setEnabled(!true);
        jReligiao.setEnabled(!true);
        jTipoSang.setEnabled(!true);
        // DEPARTAMENTO/CARGO
        jBtPesqDepto.setEnabled(!true);
        jBtPesqCargo.setEnabled(!true);
        // CARGA HORÁRIA
        jCargaHoraria.setEnabled(!true);
        jComboBoxRegimeTrabalho.setEnabled(!true);
        jHorarioInicio.setEnabled(!true);
        jHorarioFinal.setEnabled(!true);
        jFuncao.setEnabled(!true);
        // NACIONALIDADE
        jComboBoxNacionalidade.setEnabled(!true);
        jPais.setEnabled(!true);
        // NATURALIDADE
        jNaturalidade.setEnabled(!true);
        jComboBoxEstadoNaturalidade.setEnabled(!true);
        // Habiltar/Desabilitar os botões
        // ENDEREÇO
        jEndereco.setEnabled(!true);
        jBairro.setEnabled(!true);
        jComplemento.setEnabled(!true);
        jCidade.setEnabled(!true);
        jComboBoxEstado.setEnabled(!true);
        jCep.setEnabled(!true);
        // CONTATO
        jEmail.setEnabled(!true);
        jTelefone.setEnabled(!true);
        jTelefoneEnd.setEnabled(!true);
        jCelularEnd.setEnabled(!true);
        jURL.setEnabled(!true);
        jObservacao.setEnabled(!true);
        // DOCUMENTOS
        jRG.setEnabled(!true);
        jCPF.setEnabled(!true);
        jDataEmissaoRg.setEnabled(!true);
        jOrgaoEmissor.setEnabled(!true);
        jComboBoxEstadoOrgao.setEnabled(!true);
        jPis.setEnabled(!true);
        jDataCadPis.setEnabled(!true);
        jTitulo.setEnabled(!true);
        jZona.setEnabled(!true);
        jSecao.setEnabled(!true);
        jCTPS.setEnabled(!true);
        jSerie.setEnabled(!true);
        jHabilita.setEnabled(!true);
        jReservista.setEnabled(!true);
        jCategoria.setEnabled(!true);
        jCartaoSaude.setEnabled(!true);
        jProfissao.setEnabled(!true);
        jAltura.setEnabled(!true);
        jCalca.setEnabled(!true);
        jSapato.setEnabled(!true);
        jPeso.setEnabled(!true);
        jCamisa.setEnabled(!true);
        jCarteiraconselho.setEnabled(!true);
        jComboBoxTipoConjugue.setEnabled(!true);
        jDataNasConjugue.setEnabled(!true);
        jNomeConjugue.setEnabled(!true);
        // BOTÕES MANUTENÇÃO
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        jBtBiometria.setEnabled(!true);
        jBtNovoFoto2.setEnabled(!true);
        jBtExcluirFoto2.setEnabled(!true);
        jBtWebCam.setEnabled(!true);
        // BOTÕES ENDEREÇO
        jBtNovoLogradouro.setEnabled(!true);
        jBtAlterarLogradouro.setEnabled(!true);
        jBtExcluirLogradouro.setEnabled(true);
        jBtSalvarLogradouro.setEnabled(!true);
        jBtCancelarLogradouro.setEnabled(!true);
        jBtAuditoriaLogradouro.setEnabled(!true);
        // BOTÕES DOCUMENTOS
        jBtNovoDocumentos.setEnabled(!true);
        jBtAlterarDocumentos.setEnabled(true);
        jBtExcluirDocumentos.setEnabled(true);
        jBtSalvarDocumentos.setEnabled(!true);
        jBtCancelarDocumentos.setEnabled(!true);
        jBtAuditoriaDocumentos.setEnabled(!true);
        jBtImpressaoFichaColaborador.setEnabled(!true);
        // DEPENDENTES        
        jComboBoxParentesco.setEnabled(true);
        jDataNascimentoParentesco.setEnabled(true);
        jNomeDependente.setEnabled(true);
        // BOTÕES 
        jBtNovoDependente.setEnabled(!true);
        jBtAlterarDependente.setEnabled(!true);
        jBtExcluirDependente.setEnabled(!true);
        jBtSalvarDependente.setEnabled(true);
        jBtCancelarDependente.setEnabled(true);
        jBtAuditoriaDependente.setEnabled(!true);
    }

    public void ExcluirDependente() {
        // BOTÕES MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        jBtBiometria.setEnabled(!true);
        // BOTÕES ENDEREÇO
        jBtNovoLogradouro.setEnabled(true);
        jBtAlterarLogradouro.setEnabled(true);
        jBtExcluirLogradouro.setEnabled(true);
        jBtSalvarLogradouro.setEnabled(!true);
        jBtCancelarLogradouro.setEnabled(!true);
        jBtAuditoriaLogradouro.setEnabled(true);
        // BOTÕES DOCUMENTOS
        jBtNovoDocumentos.setEnabled(true);
        jBtAlterarDocumentos.setEnabled(true);
        jBtExcluirDocumentos.setEnabled(true);
        jBtSalvarDocumentos.setEnabled(!true);
        jBtCancelarDocumentos.setEnabled(!true);
        jBtAuditoriaDocumentos.setEnabled(true);
        jBtImpressaoFichaColaborador.setEnabled(!true);
        // DEPENDENTES
        jCodigoDependente.setText("");
        jComboBoxParentesco.setSelectedItem("Selecione");
        jDataNascimentoParentesco.setDate(null);
        jNomeDependente.setText("");
        //
        jComboBoxParentesco.setEnabled(!true);
        jDataNascimentoParentesco.setEnabled(!true);
        jNomeDependente.setEnabled(!true);
        // BOTÕES 
        jBtNovoDependente.setEnabled(true);
        jBtAlterarDependente.setEnabled(!true);
        jBtExcluirDependente.setEnabled(!true);
        jBtSalvarDependente.setEnabled(!true);
        jBtCancelarDependente.setEnabled(!true);
        jBtAuditoriaDependente.setEnabled(!true);
    }

    public void SalvarDependente() {
        // BOTÕES MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
        jBtBiometria.setEnabled(true);
        // BOTÕES ENDEREÇO
        jBtNovoLogradouro.setEnabled(true);
        jBtAlterarLogradouro.setEnabled(true);
        jBtExcluirLogradouro.setEnabled(true);
        jBtSalvarLogradouro.setEnabled(!true);
        jBtCancelarLogradouro.setEnabled(!true);
        jBtAuditoriaLogradouro.setEnabled(true);
        // BOTÕES DOCUMENTOS
        jBtNovoDocumentos.setEnabled(true);
        jBtAlterarDocumentos.setEnabled(true);
        jBtExcluirDocumentos.setEnabled(true);
        jBtSalvarDocumentos.setEnabled(!true);
        jBtCancelarDocumentos.setEnabled(!true);
        jBtAuditoriaDocumentos.setEnabled(true);
        jBtImpressaoFichaColaborador.setEnabled(true);
        // DEPENDENTES
        jCodigoDependente.setText("");
        jComboBoxParentesco.setSelectedItem("Selecione");
        jDataNascimentoParentesco.setDate(null);
        jNomeDependente.setText("");
        //
        jComboBoxParentesco.setEnabled(!true);
        jDataNascimentoParentesco.setEnabled(!true);
        jNomeDependente.setEnabled(!true);
        // BOTÕES 
        jBtNovoDependente.setEnabled(true);
        jBtAlterarDependente.setEnabled(!true);
        jBtExcluirDependente.setEnabled(!true);
        jBtSalvarDependente.setEnabled(!true);
        jBtCancelarDependente.setEnabled(!true);
        jBtAuditoriaDependente.setEnabled(!true);
    }

    public void CancelarDependente() {
        // BOTÕES MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
        jBtBiometria.setEnabled(!true);
        // BOTÕES ENDEREÇO
        jBtNovoLogradouro.setEnabled(true);
        jBtAlterarLogradouro.setEnabled(true);
        jBtExcluirLogradouro.setEnabled(true);
        jBtSalvarLogradouro.setEnabled(!true);
        jBtCancelarLogradouro.setEnabled(!true);
        jBtAuditoriaLogradouro.setEnabled(true);
        // BOTÕES DOCUMENTOS
        jBtNovoDocumentos.setEnabled(true);
        jBtAlterarDocumentos.setEnabled(true);
        jBtExcluirDocumentos.setEnabled(true);
        jBtSalvarDocumentos.setEnabled(!true);
        jBtCancelarDocumentos.setEnabled(!true);
        jBtAuditoriaDocumentos.setEnabled(true);
        jBtImpressaoFichaColaborador.setEnabled(!true);
        // DEPENDENTES
        jCodigoDependente.setText("");
        jComboBoxParentesco.setSelectedItem("Selecione");
        jDataNascimentoParentesco.setDate(null);
        jNomeDependente.setText("");
        //
        jComboBoxParentesco.setEnabled(!true);
        jDataNascimentoParentesco.setEnabled(!true);
        jNomeDependente.setEnabled(!true);
        // BOTÕES 
        jBtNovoDependente.setEnabled(true);
        jBtAlterarDependente.setEnabled(!true);
        jBtExcluirDependente.setEnabled(!true);
        jBtSalvarDependente.setEnabled(!true);
        jBtCancelarDependente.setEnabled(!true);
        jBtAuditoriaDependente.setEnabled(!true);
    }

    public void habilitarCamposEscala(boolean opcao) {
        jComboBoxDescricaoEscala.setEnabled(opcao);
    }

    public void bloquearBotoesEscala(boolean opcao) {
        jBtNovaEscala.setEnabled(opcao);
        jBtAlterarEscala.setEnabled(opcao);
        jBtExcluirEscala.setEnabled(opcao);
        jBtSalvarEscala.setEnabled(opcao);
        jBtCancelarEscala.setEnabled(opcao);
        jBtAuditoriaEscala.setEnabled(opcao);
        jBtCronogramaEscala.setEnabled(opcao);
        jBtImprimeEscala.setEnabled(opcao);
    }

    public void NovaEscala(boolean opcao) {
        jBtSalvarEscala.setEnabled(opcao);
        jBtCancelarEscala.setEnabled(opcao);
    }

    public void AlterarEscala(boolean opcao) {
        jBtSalvarEscala.setEnabled(opcao);
        jBtCancelarEscala.setEnabled(opcao);
    }

    public void ExcluirEscala(boolean opcao) {
        jBtNovaEscala.setEnabled(opcao);
    }

    public void SalvarEscala(boolean opcao) {
        jBtAlterarEscala.setEnabled(opcao);
        jBtExcluirEscala.setEnabled(opcao);
        jBtAuditoriaEscala.setEnabled(opcao);
        //
        jBtCronogramaEscala.setEnabled(opcao);
        jBtImprimeEscala.setEnabled(opcao);
    }

    public void CancelarEscala(boolean opcao) {
        if (pID_ESCALA != 0) {
            jComboBoxDescricaoEscala.removeAllItems();
            pPESQUISAR_nome.MOSTRAR_FUNC_escala(objEscala);
            jCodigoEscala.setText(String.valueOf(objEscala.getIdRegistro()));
            pID_ESCALA = objEscala.getIdEscala();
            jComboBoxDescricaoEscala.addItem(objEscala.getDescricaoEscala());
            jQtdTrabalho.setText(String.valueOf(objEscala.getQuantidadeTrab()));
            jQtdFolga.setText(String.valueOf(objEscala.getQuantidadeFolga()));
            jTurnoEscala.setText(objEscala.getTurno());
            jTurmaEscala.setText(objEscala.getTurma());
            jDepartamentoEscala.setText(jDepartamento.getText());
            jNomeCargoEscala.setText(jNomeCargo.getText());
            //
            jBtAlterarEscala.setEnabled(opcao);
            jBtExcluirEscala.setEnabled(opcao);
            jBtAuditoriaEscala.setEnabled(opcao);
            habilitarCamposEscala(!true);
        } else {
            habilitarCamposEscala(!true);
            limparCamposEscala();
            jBtNovaEscala.setEnabled(opcao);
        }
    }

    public void limparCamposEscala() {
        jCodigoEscala.setText("");
        jComboBoxDescricaoEscala.removeAllItems();
        jQtdTrabalho.setText("");
        jQtdFolga.setText("");
        jTurnoEscala.setText("");
        jTurmaEscala.setText("");
        jDepartamentoEscala.setText("");
        jNomeCargoEscala.setText("");
    }

    public void verificarColaborador() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM COLABORADOR "
                    + "WHERE NomeFunc='" + jNomeFuncionario.getText() + "'");
            conecta.rs.first();
            nomeColaborador = conecta.rs.getString("NomeFunc");
            nomeMaeColaborador = conecta.rs.getString("NomeMae");
        } catch (SQLException ex) {
        }
        conecta.desconecta();
    }

    public void buscarCodFunc() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM COLABORADOR");
            conecta.rs.last();
            codFunc = conecta.rs.getInt("IdFunc");
            jIDFunc.setText(String.valueOf(conecta.rs.getInt("IdFunc")));
            objCola.setIdFunc(Integer.valueOf(jIDFunc.getText()));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar COLABORADOR. \nERRO: " + ex);
        }
        conecta.desconecta();
    }

    public void buscarCodEnd() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ENDERECOS");
            conecta.rs.last();
            codEnd = conecta.rs.getInt("IdEnd");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar o código do ENDEREÇO. \nERRO: " + ex);
        }
        conecta.desconecta();
    }

    public void buscarCodDoc() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM DOCUMENTOS");
            conecta.rs.last();
            codDoc = conecta.rs.getInt("IdDoc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar código do DOCUMENTO. \nERRO: " + ex);
        }
        conecta.desconecta();
    }

    public void buscarCodDependente() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM DEPENDENTES");
            conecta.rs.last();
            jCodigoDependente.setText(conecta.rs.getString("IdDep"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar código do DEPENDENTES. \nERRO: " + ex);
        }
        conecta.desconecta();
    }

    public void verificarExclusaoEnderecoDocumentosDependentes() {
        conecta.abrirConexao();
        try {
            // VERIFICAR COLABORADOR NA TABELA ENDEREÇOS
            conecta.executaSQL("SELECT * FROM ENDERECOS WHERE IdFunc='" + jIDFunc.getText() + "'");
            conecta.rs.first();
            codFuncEnd = conecta.rs.getString("IdFunc");
            // VERIFICAR COLABORADOR NA TABELA DOCUMENTOS
            conecta.executaSQL("SELECT * FROM DOCUMENTOS WHERE IdFunc='" + jIDFunc.getText() + "'");
            conecta.rs.first();
            codFuncDoc = conecta.rs.getString("IdFunc");
            // VERIFICAR COLABORADOR NA TABELA DEPENDENTES
            conecta.executaSQL("SELECT * FROM DEPENDENTES WHERE IdFunc='" + jIDFunc.getText() + "'");
            conecta.rs.first();
            codFuncDep = conecta.rs.getString("IdFunc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void PESQUISAR_COLABORADOR_escala() {
        pPESQUISAR_nome.MOSTRAR_DADOS_COLABORADOR_EXCLUIR_escala(objEscala);
    }

    public void preencherTodasEntradas(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Nome do Colaborador", "Departamento"};
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

    // Pesquisa de todos os lançamentos
    public void pesquisarFuncNome(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Nome do Colaborador", "Departamento"};
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
        String[] Colunas = new String[]{"Código", "Data", "Status", "Nome do Colaborador", "Departamento"};
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

    public void preencherTabelaDepende(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome do Dependente", "Nascimento", "Parentesco"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            countDep = 0;
            do {
                countDep = countDep + 1;
                // Formatar a data no formato Brasil
                dataNascDep = conecta.rs.getString("DataNascDep");
                String dia = dataNascDep.substring(8, 10);
                String mes = dataNascDep.substring(5, 7);
                String ano = dataNascDep.substring(0, 4);
                dataNascDep = dia + "/" + mes + "/" + ano;
                jtotalItens.setText(Integer.toString(countDep)); // Converter inteiro em string para exibir na tela 
                dados.add(new Object[]{conecta.rs.getString("IdDep"), conecta.rs.getString("NomeDep"), dataNascDep, conecta.rs.getString("ParenteDep")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaDependentes.setModel(modelo);
        jTabelaDependentes.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaDependentes.getColumnModel().getColumn(0).setResizable(false);
        jTabelaDependentes.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTabelaDependentes.getColumnModel().getColumn(1).setResizable(false);
        jTabelaDependentes.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaDependentes.getColumnModel().getColumn(2).setResizable(false);
        jTabelaDependentes.getColumnModel().getColumn(3).setPreferredWidth(180);
        jTabelaDependentes.getColumnModel().getColumn(3).setResizable(false);
        jTabelaDependentes.getTableHeader().setReorderingAllowed(false);
        jTabelaDependentes.setAutoResizeMode(jTabelaDependentes.AUTO_RESIZE_OFF);
        jTabelaDependentes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaDependentes();
        conecta.desconecta();
    }

    public void limparTabelaDependente() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome do Dependente", "Nascimento", "Parentesco"};
        conecta.abrirConexao();
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaDependentes.setModel(modelo);
        jTabelaDependentes.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaDependentes.getColumnModel().getColumn(0).setResizable(false);
        jTabelaDependentes.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTabelaDependentes.getColumnModel().getColumn(1).setResizable(false);
        jTabelaDependentes.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaDependentes.getColumnModel().getColumn(2).setResizable(false);
        jTabelaDependentes.getColumnModel().getColumn(3).setPreferredWidth(180);
        jTabelaDependentes.getColumnModel().getColumn(3).setResizable(false);
        jTabelaDependentes.getTableHeader().setReorderingAllowed(false);
        jTabelaDependentes.setAutoResizeMode(jTabelaDependentes.AUTO_RESIZE_OFF);
        jTabelaDependentes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabelaDependentes() {
        //
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaDependentes.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaDependentes.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jIDFunc.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog1() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela1);
        objLogSys.setIdLancMov(Integer.valueOf(jIDFunc.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog2() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela2);
        objLogSys.setIdLancMov(Integer.valueOf(jIDFunc.getText()));
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

    public void PESQUISAR_LIBERACAO_implementacao() {
        PESQUISAR_IMPLEMENTA_GTA_FUN_001(telaEscalaTrabalho_ADM);
    }

    public void PESQUISAR_IMPLEMENTA_GTA_FUN_001(String pNOME_tela) {
        objParCrc.setNomeTela(pNOME_tela);
        controlImp.pPESQUISAR_CODIGO_TELA(objParCrc);
        controlImp.pPESQUISAR_liberacao(objParCrc);
        if (objParCrc.getHabilitarImp() != null && objParCrc.getHabilitarImp().equals("Não") && !nameUser.equals("ADMINISTRADOR DO SISTEMA")) {
            jTabbedPane3.remove(jDadosEscala);
        } else if (nameUser.equals("ADMINISTRADOR DO SISTEMA")) {
            jTabbedPane3.add(jDadosEscala.add("Dados Escala", jCep));
        } else if (objParCrc.getHabilitarImp() != null && objParCrc.getHabilitarImp().equals("Sim") && !nameUser.equals("ADMINISTRADOR DO SISTEMA")) {
            jTabbedPane3.add(jDadosEscala.add("Dados Escala", jCep));
        } else if (objParCrc.getHabilitarImp() == null) {
            jTabbedPane3.remove(jDadosEscala);
        } else if (objParCrc.getHabilitarImp().equals("")) {
            jTabbedPane3.remove(jDadosEscala);
        } else {
            jTabbedPane3.add(jDadosEscala.add("Dados Escala", jCep));
        }
    }
}
