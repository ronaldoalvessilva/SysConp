/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleLogSistema;
import gestor.Dao.ConexaoBancoDados;
import Utilitarios.LimiteDigitos;
import Utilitarios.LimiteDigitosAlfa;
import Utilitarios.LimiteDigitosNum;
import Utilitarios.LimiteDigitosSoNum;
import Utilitarios.ModeloTabela;
import Utilitarios.ValidaCPF;
import gestor.Controle.ControleDadosFisicos_TRIAGEM;
import gestor.Controle.ControleDadosPenais_TRIAGEM;
import gestor.Controle.ControleInternoCrc_TRIAGEM;
import gestor.Modelo.DadosFisicosInternos;
import gestor.Modelo.DadosPenaisCrc;
import gestor.Modelo.LogSistema;
import gestor.Modelo.ProntuarioCrc;
import gestor.Modelo.ProntuarioFisicosPenaisInternos;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaLoginSenha.descricaoUnidade;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaModuloTriagem.telaCadastroProntuarioBioTRI;
import static gestor.Visao.TelaModuloTriagem.telaCadastroProntuarioBuscarEntTRI;
import static gestor.Visao.TelaModuloTriagem.telaCadastroProntuarioImportTRI;
import static gestor.Visao.TelaModuloTriagem.telaCadastroProntuarioManuTRI;
import static gestor.Visao.TelaModuloTriagem.telaCadastroProntuarioObsTRI;
import static gestor.Visao.TelaModuloTriagem.telaCadastroProntuarioPecCosTRI;
import static gestor.Visao.TelaModuloTriagem.telaCadastroProntuarioPecFreTRI;
import static gestor.Visao.TelaModuloTriagem.telaCadastroProntuarioPrintTRI;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import org.opencv.core.Core;
import static gestor.Visao.TelaModuloTriagem.codigoGrupoTRI;
import static gestor.Visao.TelaModuloTriagem.codigoUserGroupTRI;
import static gestor.Visao.TelaModuloTriagem.codAbrirTRI;
import static gestor.Visao.TelaModuloTriagem.codIncluirTRI;
import static gestor.Visao.TelaModuloTriagem.codAlterarTRI;
import static gestor.Visao.TelaModuloTriagem.codExcluirTRI;
import static gestor.Visao.TelaModuloTriagem.codGravarTRI;
import static gestor.Visao.TelaModuloTriagem.codConcultarTRI;
import static gestor.Visao.TelaModuloTriagem.codigoUserTRI;
import static gestor.Visao.TelaModuloTriagem.codUserAcessoTRI;
import static gestor.Visao.TelaModuloTriagem.nomeGrupoTRI;
import static gestor.Visao.TelaModuloTriagem.nomeTelaTRI;
import java.awt.Component;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import javax.swing.JTable;

/**
 *
 * @author user
 */
public final class TelaProntuarioTriagem extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ProntuarioCrc objProCrc = new ProntuarioCrc();
    DadosPenaisCrc objDadosPena = new DadosPenaisCrc();
    DadosFisicosInternos objDadosFis = new DadosFisicosInternos();
    ControleInternoCrc_TRIAGEM CONTROLE_DADOS_civil = new ControleInternoCrc_TRIAGEM();
    ControleDadosFisicos_TRIAGEM CONTROLE_DADOS_fisicos = new ControleDadosFisicos_TRIAGEM();
    ControleDadosPenais_TRIAGEM CONTROLE_DADOS_penais = new ControleDadosPenais_TRIAGEM();
    //
    ProntuarioFisicosPenaisInternos pPront = new ProntuarioFisicosPenaisInternos();
    DadosFisicosInternos objDafis = new DadosFisicosInternos();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    //
    int acao;
    int flag;
    String nomePais;
    String dataEntrada;
    String dataCadastro;
    public static String caminhoFotoInternoTRIAGEM;
    String caminhoFotoPerfil;
    String caminhoFotoCorpo;
    String caminhoFotoCorpo1;
    String caminhoFotoCorpo2;
    String caminhoFotoCorpo3;
    String caminhoPolegarDireito;
    String caminhoIndicadorDireito;
    String caminhoMedioDireito;
    String caminhoAnularDireito;
    String caminhoMininoDireito;
    String caminhoPolegarEsquerdo;
    String caminhoIndicadorEsquerdo;
    String caminhoMedioEsquerdo;
    String caminhoAnularEsquerdo;
    String caminhoMininoEsquerdo;
    //
    public static String codInternoCrc; // Verificar se existe movimentação do intero para não ser excluído
    public static String nomeInternoCrc;
    public static String nomeMaeInterno;
    public static String CODIGO_INTERNO_TABELA_penal;
    public static String caminho = "";
    public static String pRESPOSTA_gravacao = "";
    public static String pRESPOSTA_EXCLUSÃO_prontuario = "";
    public static String pRESPOSTA_DADOS_fisicos = "";
    public static String pRESPOSTA_EXCLUSÃO_fisicos = "";
    public static String pRESPOSTA_DADOS_penais = "";
    public static String pRESPOSTA_EXCLUSÃO_penais = "";
    // Variáveis para gravar o log
    String nomeModuloTela = "CRC:Prontuário de Internos";
    String statusMov;
    String horaMov;
    String dataModFinal;
    //
    String nomeUsuarioCrc = "ADMINISTRADOR DO SISTEMA"; // Para poder alterar a situação do interno
    String usuarioAutorizado;
    public static String nomeInterno; // Para pesquisa do interno no registroda portaria, bloquear.
    String confirmaEntrada = "Sim"; // Confirma a utilização do registro do interno iniciado na portaria.
    public static String codParametrosEntrada;
    int count = 0;
    String situacaoEnt = "ENTRADA NA UNIDADE";
    String situacaoRet = "RETORNO A UNIDADE";
    String situacaoTra = "TRANSFERENCIA";
    String situacaoAlv = "SAIDA ALVARA";
    String situacaoCon = "LIVRAMENTO CONDICIONAL";
    String situacaoReg = "PROGRESSAO REGIME";
    String situacaoEva = "EVADIDO DA UNIDADE";
    String pSAIDA_TEMPORARIA = "SAIDA TEMPORARIA";
    String pSAIDA_PRISAO_DOMICILIAR = "PRISAO DOMICILIAR";
    String pPRISAO_DOMICILIAR_COVID = "PRISAO DOMICILIAR - COVID-19";
    // CAMINHO DAS IMAGENS DA MÃO DIREITA
    String caminhoBiometria1 = "";
    String caminhoBiometria2 = "";
    String caminhoBiometria3 = "";
    String caminhoBiometria4 = "";
    String caminhoBiometria5 = "";
    // CAMINHO DAS IMAGENS DA MÃO ESQUERDA
    String caminhoBiometria6 = "";
    String caminhoBiometria7 = "";
    String caminhoBiometria8 = "";
    String caminhoBiometria9 = "";
    String caminhoBiometria10 = "";
    String codIntPenal;
    //
    String confirmarTransf = "Sim";
    //
    byte[] persona_imagem = null;
    byte[] persona_imagem1 = null;
    byte[] persona_imagem2 = null;
    byte[] persona_imagem3 = null;
    byte[] persona_imagem4 = null;
    //    
    String pSAIDA_temporaria = "";
    String pSAIDA_covid = "";
    String pENTRADA_UNIDADE = "";
    String pRETORNO_UNIDADE = "";
    //
    int pSAIDA_TEMP = 0;
    int pSAIDA_COVID = 0;
    int pATIVOS_ENTRADA = 0;
    int pATIVOS_RETORNO = 0;
    int pTOTAL_ATIVOS = 0;

    /**
     * Creates new form TelaTriagem
     */
    // BUSCAR TELA DE FOTO MAIOR
    public static TelaFotoTriagem telafototriagem;
    public static TelaPeculiaridadeCostasTriagem telaPeculiaridadeTriagem;
    public static TelaPeculiaridadeFrenteTriagem telaPeculiaridadeFrenteTriagem;
    public static TelaBiometriaInterno telaBiometriaInterno;
    public static TelaWebCamInternoTriagem telaWebCamInterno;
    public static TelaPesquisaExternaInternoTriagem telaPesquisaExternaTriagem;

    //
    public TelaProntuarioTriagem() {
        super();
        initComponents();
        setResizable(false);
        corCampos();
        formatarCampos();
        buscarCaminhoTempleteImagem();
    }

    public void mostrarTelaFotoTriagem() {
        telafototriagem = new TelaFotoTriagem(this, true);
        telafototriagem.setVisible(true);
    }

    public void mostrarTelaPeculiaridadeCostasTriagem() {
        telaPeculiaridadeTriagem = new TelaPeculiaridadeCostasTriagem(this, true);
        telaPeculiaridadeTriagem.setVisible(true);
    }

    public void mostrarTelaPeculiaridadeFrenteTriagem() {
        telaPeculiaridadeFrenteTriagem = new TelaPeculiaridadeFrenteTriagem(this, true);
        telaPeculiaridadeFrenteTriagem.setVisible(true);
    }

    public void mostrarTelaBiometriaInterno() {
        telaBiometriaInterno = new TelaBiometriaInterno(this, true);
        telaBiometriaInterno.setVisible(true);
    }

    public void mostrarWebCamFotoInternoTRI() {
        telaWebCamInterno = new TelaWebCamInternoTriagem(this, true);
        telaWebCamInterno.setVisible(true);
    }

    public void mostrarTelaPesquisaExterna() {
        telaPesquisaExternaTriagem = new TelaPesquisaExternaInternoTriagem(this, true);
        telaPesquisaExternaTriagem.setVisible(true);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaInterno = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPesqNome = new javax.swing.JTextField();
        jPesqMatricula = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jBtNome = new javax.swing.JButton();
        jBtMatricula = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel73 = new javax.swing.JLabel();
        jPesqAlcunha = new javax.swing.JTextField();
        jBtPesqAlcunha = new javax.swing.JButton();
        jLabel163 = new javax.swing.JLabel();
        jComboBoxPesqSituacao = new javax.swing.JComboBox();
        jLabel164 = new javax.swing.JLabel();
        jPesqCodigo = new javax.swing.JTextField();
        jBtPesqCodigo = new javax.swing.JButton();
        jBtPesqSitucao = new javax.swing.JButton();
        jLabel165 = new javax.swing.JLabel();
        jPesquisaCNC = new javax.swing.JTextField();
        jBtCNCPesquisa = new javax.swing.JButton();
        jPanel52 = new javax.swing.JPanel();
        jtotalRegistrosTMP = new javax.swing.JLabel();
        jPanel47 = new javax.swing.JPanel();
        jtotalInternos_ATIVOS = new javax.swing.JLabel();
        jPanel53 = new javax.swing.JPanel();
        jLabel195 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jPanel54 = new javax.swing.JPanel();
        jtotalRegistrosPDC = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jLabel196 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel51 = new javax.swing.JPanel();
        jLabel194 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jIdInterno = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jNomeInterno = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jMatriculaPenal = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jMaeInterno = new javax.swing.JTextField();
        jPaiInterno = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jAlcunha = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jCPFInterno = new javax.swing.JFormattedTextField();
        jLabel15 = new javax.swing.JLabel();
        jComboBoxSexo = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        jComboBoxEscolaridade = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        jComboBoxEstadoCivil = new javax.swing.JComboBox();
        jBtNovaFoto = new javax.swing.JButton();
        jBtExcluirFoto = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jBtPesqPais = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jReligiao = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jProfissao = new javax.swing.JTextField();
        jBtPesqCidade = new javax.swing.JButton();
        jRGInterno = new javax.swing.JFormattedTextField();
        jLabel60 = new javax.swing.JLabel();
        jSituacao = new javax.swing.JTextField();
        jDataCadastro = new com.toedter.calendar.JDateChooser();
        jDataNascimento = new com.toedter.calendar.JDateChooser();
        jPanel13 = new javax.swing.JPanel();
        jLabelFotoInterno = new javax.swing.JLabel();
        jComboBoxPais = new javax.swing.JTextField();
        jComboBoxCidade = new javax.swing.JTextField();
        jBtWebCam = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jCartaoSus = new javax.swing.JTextField();
        jBtZoonFoto = new javax.swing.JButton();
        jCNC = new javax.swing.JTextField();
        jLabel162 = new javax.swing.JLabel();
        jComboBoxUF = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        jBtNovo = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jBtImpressao = new javax.swing.JButton();
        jBtAuditoriaPronCrc = new javax.swing.JButton();
        jBtObservacao = new javax.swing.JButton();
        jBtBuscarRegPortaria = new javax.swing.JButton();
        jBtImportarProntuario = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jEndereco = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jBairro = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jCidade = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jEstado = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTelefone = new javax.swing.JFormattedTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jTelefone1 = new javax.swing.JFormattedTextField();
        jCelular = new javax.swing.JFormattedTextField();
        jBtPesqCidadeEnd = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jComboBoxCutis = new javax.swing.JComboBox();
        jComboBoxOlhos = new javax.swing.JComboBox();
        jComboBoxCabelos = new javax.swing.JComboBox();
        jComboBoxBarba = new javax.swing.JComboBox();
        jComboBoxBigode = new javax.swing.JComboBox();
        jLabel35 = new javax.swing.JLabel();
        jComboBoxNariz = new javax.swing.JComboBox();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jComboBoxBoca = new javax.swing.JComboBox();
        jComboBoxRosto = new javax.swing.JComboBox();
        jComboBoxLabios = new javax.swing.JComboBox();
        jLabel39 = new javax.swing.JLabel();
        jCamisa = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jCalca = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jSapato = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jPeso = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jAltura = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jParticularidade = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jComboBoxOrelha = new javax.swing.JComboBox();
        jComboBoxPescoco = new javax.swing.JComboBox();
        jLabel62 = new javax.swing.JLabel();
        jComboBoxCompleicao = new javax.swing.JComboBox();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jDataEntrada = new com.toedter.calendar.JDateChooser();
        jLabel46 = new javax.swing.JLabel();
        jDataCrime = new com.toedter.calendar.JDateChooser();
        jLabel49 = new javax.swing.JLabel();
        jComboBoxParticipacao = new javax.swing.JComboBox();
        jLabel45 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jDataPrisao = new com.toedter.calendar.JDateChooser();
        jComboBoxRegime = new javax.swing.JComboBox();
        jLabel50 = new javax.swing.JLabel();
        jBtPesqUnidade = new javax.swing.JButton();
        jLabel48 = new javax.swing.JLabel();
        jDataCondenacao = new com.toedter.calendar.JDateChooser();
        jLabel51 = new javax.swing.JLabel();
        jPena = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jArtigo1 = new javax.swing.JTextField();
        jArtigo2 = new javax.swing.JTextField();
        jArtigo3 = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jParagrafo1 = new javax.swing.JTextField();
        jParagrafo2 = new javax.swing.JTextField();
        jParagrafo3 = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jComboBoxEdiondo = new javax.swing.JComboBox();
        jLabel59 = new javax.swing.JLabel();
        jDataTerPena = new com.toedter.calendar.JDateChooser();
        jComboBoxUnid = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        jVaraCondenacao = new javax.swing.JTextField();
        jLabel159 = new javax.swing.JLabel();
        jDataNovaEntrada = new com.toedter.calendar.JDateChooser();
        jPanel10 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jFotoPerfil = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jFotoCorpo = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jFotoCorpo1 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jFotoCorpo2 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jIdentificador = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        jPerfil = new javax.swing.JTextField();
        jBtNovaFotoPerfil = new javax.swing.JButton();
        jBtExcluirFotoPerfil = new javax.swing.JButton();
        jBtNovaFotoCorpo = new javax.swing.JButton();
        jBtExcluirFotoCorpo = new javax.swing.JButton();
        jBtNovaFotoCorpo1 = new javax.swing.JButton();
        jBtExcluirFotoCorpo1 = new javax.swing.JButton();
        jBtNovaFotoCorpo2 = new javax.swing.JButton();
        jBtExcluirCorpo2 = new javax.swing.JButton();
        jLabel66 = new javax.swing.JLabel();
        jIdentificador1 = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        jIdentificador2 = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        jIdentificador3 = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();
        jRegiaoCorpo = new javax.swing.JTextField();
        jRegiaoCorpo1 = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        jRegiaoCorpo2 = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jFotoMedioDireito = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jFotoMedioEsquerdo = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jFotoAnularDireito = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jFotoAnularEsquerdo = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jFotoMininoDireito = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jFotoMinimoEsquerdo = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jFotoPolegarDireito = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jFotoPolegarEsquerdo = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jFotoIndicadorDireito = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jFotoIndicadorEsquerdo = new javax.swing.JLabel();
        jLabel160 = new javax.swing.JLabel();
        jLabel161 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel33 = new javax.swing.JPanel();
        jBtNovo1 = new javax.swing.JButton();
        jBtAlterar1 = new javax.swing.JButton();
        jBtExcluir1 = new javax.swing.JButton();
        jBtSalvar1 = new javax.swing.JButton();
        jBtCancelar1 = new javax.swing.JButton();
        jBtSair1 = new javax.swing.JButton();
        jBtImpressao1 = new javax.swing.JButton();
        jBtAuditoriaPronCrc1 = new javax.swing.JButton();
        jBtObservacao1 = new javax.swing.JButton();
        jBtBuscarRegPortaria1 = new javax.swing.JButton();
        jBtBiometria = new javax.swing.JButton();
        jPanel34 = new javax.swing.JPanel();
        jLabel74 = new javax.swing.JLabel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel41 = new javax.swing.JPanel();
        jLabel83 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jPanel42 = new javax.swing.JPanel();
        jLabel123 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        jLabel126 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jBtPeculiaridadeFrente = new javax.swing.JButton();
        jPanel35 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        jLabel127 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        jLabel130 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        jLabel141 = new javax.swing.JLabel();
        jLabel142 = new javax.swing.JLabel();
        jLabel143 = new javax.swing.JLabel();
        jLabel144 = new javax.swing.JLabel();
        jLabel145 = new javax.swing.JLabel();
        jLabel146 = new javax.swing.JLabel();
        jLabel147 = new javax.swing.JLabel();
        jLabel148 = new javax.swing.JLabel();
        jLabel149 = new javax.swing.JLabel();
        jLabel150 = new javax.swing.JLabel();
        jLabel151 = new javax.swing.JLabel();
        jLabel152 = new javax.swing.JLabel();
        jLabel153 = new javax.swing.JLabel();
        jLabel154 = new javax.swing.JLabel();
        jLabel155 = new javax.swing.JLabel();
        jLabel156 = new javax.swing.JLabel();
        jLabel157 = new javax.swing.JLabel();
        jLabel158 = new javax.swing.JLabel();
        jBtPeculiaridadeCostas = new javax.swing.JButton();
        jPanel39 = new javax.swing.JPanel();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Prontuário de Interno ::: ...");
        setToolTipText("");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jTabelaInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaInterno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome do Interno", "Situação", "Matricula Penal", "Data Entrada", "Data Cadastro"
            }
        ));
        jTabelaInterno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaInternoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaInterno);
        if (jTabelaInterno.getColumnModel().getColumnCount() > 0) {
            jTabelaInterno.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaInterno.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaInterno.getColumnModel().getColumn(1).setMinWidth(300);
            jTabelaInterno.getColumnModel().getColumn(1).setMaxWidth(300);
            jTabelaInterno.getColumnModel().getColumn(2).setMinWidth(200);
            jTabelaInterno.getColumnModel().getColumn(2).setMaxWidth(200);
            jTabelaInterno.getColumnModel().getColumn(3).setMinWidth(100);
            jTabelaInterno.getColumnModel().getColumn(3).setMaxWidth(100);
            jTabelaInterno.getColumnModel().getColumn(4).setMinWidth(80);
            jTabelaInterno.getColumnModel().getColumn(4).setMaxWidth(80);
            jTabelaInterno.getColumnModel().getColumn(5).setMinWidth(80);
            jTabelaInterno.getColumnModel().getColumn(5).setMaxWidth(80);
        }

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jPesqNome.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jPesqMatricula.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPesqMatricula.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Nome:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Matricula:");

        jBtNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtNome.setToolTipText("Pesquisa Por Nome");
        jBtNome.setContentAreaFilled(false);
        jBtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNomeActionPerformed(evt);
            }
        });

        jBtMatricula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtMatricula.setToolTipText("Pesquisa Por Matricula");
        jBtMatricula.setContentAreaFilled(false);
        jBtMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtMatriculaActionPerformed(evt);
            }
        });

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox1.setText("Todos");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });

        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel73.setText("Alcunha:");

        jPesqAlcunha.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqAlcunha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqAlcunha.setContentAreaFilled(false);
        jBtPesqAlcunha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqAlcunhaActionPerformed(evt);
            }
        });

        jLabel163.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel163.setForeground(new java.awt.Color(255, 0, 0));
        jLabel163.setText("Situação:");

        jComboBoxPesqSituacao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxPesqSituacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ativos", "Inativos", "Evadidos" }));
        jComboBoxPesqSituacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel164.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel164.setText("Código:");

        jPesqCodigo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPesqCodigo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqCodigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqCodigo.setToolTipText("Pesquisar por Código");
        jBtPesqCodigo.setContentAreaFilled(false);
        jBtPesqCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqCodigoActionPerformed(evt);
            }
        });

        jBtPesqSitucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqSitucao.setToolTipText("Pesquisar por Código");
        jBtPesqSitucao.setContentAreaFilled(false);
        jBtPesqSitucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqSitucaoActionPerformed(evt);
            }
        });

        jLabel165.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel165.setText("CNC:");

        jPesquisaCNC.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPesquisaCNC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtCNCPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtCNCPesquisa.setToolTipText("Pesquisa Por Matricula");
        jBtCNCPesquisa.setContentAreaFilled(false);
        jBtCNCPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCNCPesquisaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBox1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jPesqCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jBtPesqCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jPesqMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jBtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel165, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel163, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(jComboBoxPesqSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jBtPesqSitucao, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPesquisaCNC, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jBtCNCPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel164, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(jLabel73)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPesqAlcunha)
                                    .addComponent(jPesqNome))))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBtPesqAlcunha, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addGap(14, 14, 14))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtPesqSitucao, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1)
                    .addComponent(jComboBoxPesqSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel163)
                    .addComponent(jBtPesqCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPesqCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel164))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(jPesqMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtMatricula)
                    .addComponent(jLabel165)
                    .addComponent(jPesquisaCNC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtCNCPesquisa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtNome)
                    .addComponent(jPesqNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel73)
                    .addComponent(jPesqAlcunha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqAlcunha))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel52.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jtotalRegistrosTMP.setForeground(new java.awt.Color(204, 0, 0));
        jtotalRegistrosTMP.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel52Layout = new javax.swing.GroupLayout(jPanel52);
        jPanel52.setLayout(jPanel52Layout);
        jPanel52Layout.setHorizontalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addComponent(jtotalRegistrosTMP, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        jPanel52Layout.setVerticalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistrosTMP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
        );

        jPanel47.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));
        jPanel47.setToolTipText("");

        jtotalInternos_ATIVOS.setForeground(new java.awt.Color(0, 102, 0));
        jtotalInternos_ATIVOS.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalInternos_ATIVOS, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalInternos_ATIVOS, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
        );

        jPanel53.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jLabel195.setForeground(new java.awt.Color(0, 0, 204));
        jLabel195.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel195.setText("Total de Saída PDC:");

        javax.swing.GroupLayout jPanel53Layout = new javax.swing.GroupLayout(jPanel53);
        jPanel53.setLayout(jPanel53Layout);
        jPanel53Layout.setHorizontalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel195, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
        );
        jPanel53Layout.setVerticalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel195)
        );

        jPanel30.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jLabel63.setText("Total de Registros:");

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel63)
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel63, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jPanel54.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jtotalRegistrosPDC.setForeground(new java.awt.Color(0, 0, 204));
        jtotalRegistrosPDC.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel54Layout = new javax.swing.GroupLayout(jPanel54);
        jPanel54.setLayout(jPanel54Layout);
        jPanel54Layout.setHorizontalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistrosPDC, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );
        jPanel54Layout.setVerticalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistrosPDC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
        );

        jPanel31.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));
        jPanel31.setToolTipText("t");

        jLabel196.setForeground(new java.awt.Color(0, 102, 0));
        jLabel196.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel196.setText("Internos Ativos:");

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel196, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel196)
        );

        jPanel32.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jtotalRegistros.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
        );

        jPanel51.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jLabel194.setForeground(new java.awt.Color(204, 0, 0));
        jLabel194.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel194.setText("Total de Saída Temp:");

        javax.swing.GroupLayout jPanel51Layout = new javax.swing.GroupLayout(jPanel51);
        jPanel51.setLayout(jPanel51Layout);
        jPanel51Layout.setHorizontalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel194, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
        );
        jPanel51Layout.setVerticalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel194)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(jPanel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(jPanel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(jPanel54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(jPanel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4))
        );

        jTabbedPane1.addTab("Listagem", jPanel1);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 0, 0));
        jLabel5.setText("Código:");

        jIdInterno.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdInterno.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Data Cadastro:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 0, 0));
        jLabel8.setText("Nome:");

        jNomeInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInterno.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("MP:");

        jMatriculaPenal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jMatriculaPenal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMatriculaPenal.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 0, 0));
        jLabel10.setText("Mãe:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 0, 0));
        jLabel11.setText("Pai:");

        jMaeInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMaeInterno.setEnabled(false);

        jPaiInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPaiInterno.setEnabled(false);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Alcunha:");

        jAlcunha.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAlcunha.setEnabled(false);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("Data Nascimento:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("R.G.:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("C.P.F.:");

        jCPFInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCPFInterno.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCPFInterno.setText("99999999999");
        jCPFInterno.setToolTipText("Esse campo tem validador de CPF. Utilize os números 99999999999 quando o interno não tiver CPF.");
        jCPFInterno.setEnabled(false);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(153, 0, 0));
        jLabel15.setText("Sexo:");

        jComboBoxSexo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Masculino", "Feminino" }));
        jComboBoxSexo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxSexo.setEnabled(false);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Escolaridade:");

        jComboBoxEscolaridade.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxEscolaridade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Não sabe Informar", "Não Alfabetizado", "Alfabetizado", "Fundamental Completo", "Fundamental Incompleto", "Fundamental I Completo", "Fundamental I Incompleto", "Fundamental II Incompleto", "Fundamental II Completo", "Ensino Médio Completo", "Ensino Médio Incompleto", "1º Grau Completo", "1º Grau Incompleto", "2º Grau Completo", "2º Grau Incompleto", "Superior Completo", "Superior Incompleto" }));
        jComboBoxEscolaridade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxEscolaridade.setEnabled(false);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("E.Civil:");

        jComboBoxEstadoCivil.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Casado", "Casada", "Solteiro", "Solteira", "Outros" }));
        jComboBoxEstadoCivil.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxEstadoCivil.setEnabled(false);

        jBtNovaFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/2998132-camera-photo-photography_99870.png"))); // NOI18N
        jBtNovaFoto.setToolTipText("Nova Foto");
        jBtNovaFoto.setEnabled(false);
        jBtNovaFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovaFotoActionPerformed(evt);
            }
        });

        jBtExcluirFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirFoto.setToolTipText("Excluir Foto");
        jBtExcluirFoto.setEnabled(false);
        jBtExcluirFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirFotoActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(153, 0, 0));
        jLabel18.setText("Nacionalidade:");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(153, 0, 0));
        jLabel19.setText("Naturalidade:");

        jBtPesqPais.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqPais.setToolTipText("Pesquisar Paises");
        jBtPesqPais.setContentAreaFilled(false);
        jBtPesqPais.setEnabled(false);
        jBtPesqPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqPaisActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Religião:");

        jReligiao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jReligiao.setEnabled(false);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Profissão:");

        jProfissao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jProfissao.setEnabled(false);
        jProfissao.setPreferredSize(new java.awt.Dimension(4, 17));

        jBtPesqCidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqCidade.setToolTipText("Pesquisar Cidades");
        jBtPesqCidade.setContentAreaFilled(false);
        jBtPesqCidade.setEnabled(false);
        jBtPesqCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqCidadeActionPerformed(evt);
            }
        });

        jRGInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jRGInterno.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jRGInterno.setEnabled(false);

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(0, 0, 153));
        jLabel60.setText("Situação do Interno");

        jSituacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jSituacao.setEnabled(false);

        jDataCadastro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataCadastro.setEnabled(false);

        jDataNascimento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataNascimento.setEnabled(false);

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Foto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelFotoInterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelFotoInterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jComboBoxPais.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxPais.setEnabled(false);

        jComboBoxCidade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxCidade.setEnabled(false);

        jBtWebCam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/webcam_start.png"))); // NOI18N
        jBtWebCam.setEnabled(false);
        jBtWebCam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtWebCamActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Cartão SUS:");

        jCartaoSus.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCartaoSus.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCartaoSus.setEnabled(false);

        jBtZoonFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/11985_16x16.png"))); // NOI18N
        jBtZoonFoto.setToolTipText("Zoon da Foto");
        jBtZoonFoto.setEnabled(false);
        jBtZoonFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtZoonFotoActionPerformed(evt);
            }
        });

        jCNC.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCNC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCNC.setEnabled(false);

        jLabel162.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel162.setText("CNC/PN:");

        jComboBoxUF.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxUF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "AC", "AL", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        jComboBoxUF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxUF.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jDataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPaiInterno)
                            .addComponent(jMaeInterno)
                            .addComponent(jNomeInterno)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jAlcunha)
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel4))
                                    .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCartaoSus, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCPFInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jIdInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jMatriculaPenal, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel162)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCNC, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jBtZoonFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtNovaFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtExcluirFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtWebCam, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBoxPais, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxCidade)
                                    .addComponent(jReligiao))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel21)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jProfissao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jBtPesqCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jBtPesqPais, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                        .addGap(38, 38, 38)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jSituacao)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel60)
                                                .addGap(0, 0, Short.MAX_VALUE))))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jRGInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jComboBoxEscolaridade, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxSexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtExcluirFoto, jBtNovaFoto, jBtWebCam, jBtZoonFoto});

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jCPFInterno, jCartaoSus, jComboBoxEstadoCivil});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(jIdInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9)
                                .addComponent(jMatriculaPenal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                .addComponent(jLabel162)
                                .addComponent(jCNC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel7)
                            .addComponent(jDataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22)
                            .addComponent(jDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jMaeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jPaiInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jAlcunha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)
                                .addComponent(jCartaoSus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jComboBoxEscolaridade, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(jComboBoxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(jComboBoxEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel18)
                            .addComponent(jComboBoxPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtPesqPais, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel60))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel19)
                            .addComponent(jBtPesqCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(jReligiao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21)
                            .addComponent(jProfissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.CENTER)
                            .addGroup(javax.swing.GroupLayout.Alignment.CENTER, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel14)
                                .addComponent(jRGInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBoxUF, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jCPFInterno, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtZoonFoto, javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jBtNovaFoto, javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jBtExcluirFoto, javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jBtWebCam, javax.swing.GroupLayout.Alignment.CENTER))
                        .addGap(124, 124, 124))))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jCPFInterno, jCartaoSus, jComboBoxEscolaridade, jComboBoxEstadoCivil, jLabel16, jLabel17});

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtPesqCidade, jBtPesqPais});

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtExcluirFoto, jBtNovaFoto, jBtWebCam});

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jProfissao, jSituacao});

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jBtNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovo.setText("Novo");
        jBtNovo.setToolTipText("Novo Registro");
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
        jBtAlterar.setToolTipText("Atualizar Registro");
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
        jBtExcluir.setToolTipText("Excluir Registro");
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
        jBtSalvar.setToolTipText("Salvar Registro");
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
        jBtCancelar.setToolTipText("Cancelar Operação");
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
        jBtSair.setToolTipText("Sair da Tela");
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

        jBtAuditoriaPronCrc.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jBtAuditoriaPronCrc.setForeground(new java.awt.Color(255, 0, 0));
        jBtAuditoriaPronCrc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaPronCrc.setToolTipText("Auditoria");
        jBtAuditoriaPronCrc.setContentAreaFilled(false);
        jBtAuditoriaPronCrc.setEnabled(false);
        jBtAuditoriaPronCrc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAuditoriaPronCrc.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAuditoriaPronCrc.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAuditoriaPronCrc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaPronCrcActionPerformed(evt);
            }
        });

        jBtObservacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/accept.png"))); // NOI18N
        jBtObservacao.setToolTipText("Observação");
        jBtObservacao.setContentAreaFilled(false);
        jBtObservacao.setEnabled(false);
        jBtObservacao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtObservacao.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtObservacao.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtObservacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtObservacaoActionPerformed(evt);
            }
        });

        jBtBuscarRegPortaria.setForeground(new java.awt.Color(0, 0, 255));
        jBtBuscarRegPortaria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtBuscarRegPortaria.setToolTipText("Buscar Registro Interno na Portaria");
        jBtBuscarRegPortaria.setContentAreaFilled(false);
        jBtBuscarRegPortaria.setEnabled(false);
        jBtBuscarRegPortaria.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtBuscarRegPortaria.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtBuscarRegPortaria.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtBuscarRegPortaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtBuscarRegPortariaActionPerformed(evt);
            }
        });

        jBtImportarProntuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/kde-file-downloads-icone-4393-16.png"))); // NOI18N
        jBtImportarProntuario.setToolTipText("Importar Prontuário de Interno");
        jBtImportarProntuario.setContentAreaFilled(false);
        jBtImportarProntuario.setEnabled(false);
        jBtImportarProntuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtImportarProntuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jBtNovo)
                .addGap(1, 1, 1)
                .addComponent(jBtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSair)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtImpressao, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtBuscarRegPortaria, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtAuditoriaPronCrc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtImportarProntuario, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtAlterar)
                    .addComponent(jBtExcluir)
                    .addComponent(jBtSalvar)
                    .addComponent(jBtCancelar)
                    .addComponent(jBtSair)
                    .addComponent(jBtImpressao)
                    .addComponent(jBtObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtBuscarRegPortaria, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtAuditoriaPronCrc, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtImportarProntuario))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterar, jBtCancelar, jBtExcluir, jBtNovo, jBtSair, jBtSalvar});

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAuditoriaPronCrc, jBtBuscarRegPortaria, jBtImportarProntuario, jBtImpressao, jBtObservacao});

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Logradouro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setText("Endereço:");

        jEndereco.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jEndereco.setEnabled(false);

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setText("Bairro:");

        jBairro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jBairro.setEnabled(false);

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(153, 0, 0));
        jLabel25.setText("Cidade:");

        jCidade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCidade.setEnabled(false);

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setText("Estado:");

        jEstado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jEstado.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Telefone:");

        jTelefone.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTelefone.setEnabled(false);

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setText("Telefone:");

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel42.setText("Celular:");

        jTelefone1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTelefone1.setEnabled(false);

        jCelular.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCelular.setEnabled(false);

        jBtPesqCidadeEnd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqCidadeEnd.setContentAreaFilled(false);
        jBtPesqCidadeEnd.setEnabled(false);
        jBtPesqCidadeEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqCidadeEndActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jBtPesqCidadeEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel42)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jCelular, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel27)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jEstado))))
                        .addComponent(jEndereco)
                        .addComponent(jBairro))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTelefone, jTelefone1});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(jBtPesqCidadeEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addGap(6, 6, 6)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(jTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(jTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42)
                    .addComponent(jCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jCelular, jTelefone, jTelefone1});

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );

        jTabbedPane1.addTab("Manutenção", jPanel2);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados Fisicos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 204))); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Cutis:");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel28.setText("Olhos:");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel29.setText("Cabelos:");

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel30.setText("Barba:");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel31.setText("Bigode:");

        jComboBoxCutis.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxCutis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Parda", "Negra", "Branca", "Amarela", "Indigina" }));
        jComboBoxCutis.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxCutis.setEnabled(false);

        jComboBoxOlhos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxOlhos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Azul", "Preto", "Castanho Escuro", "Castanho Claro", "Verdes" }));
        jComboBoxOlhos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxOlhos.setEnabled(false);

        jComboBoxCabelos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxCabelos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Carapinha", "Lisos", "Ondulados", "Encaracolados", "Crespos" }));
        jComboBoxCabelos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxCabelos.setEnabled(false);
        jComboBoxCabelos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCabelosActionPerformed(evt);
            }
        });

        jComboBoxBarba.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxBarba.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Rala", "Cheia", "Rapada", "Sem Barba" }));
        jComboBoxBarba.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxBarba.setEnabled(false);

        jComboBoxBigode.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxBigode.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Ralo", "Cheio", "Rapado", "Sem Bigode" }));
        jComboBoxBigode.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxBigode.setEnabled(false);

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel35.setText("Nariz:");

        jComboBoxNariz.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxNariz.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Achatado", "Afilado", "Arrebitado", "Comprido", "Curvo", "Adunco", "Pequeno", "Fino" }));
        jComboBoxNariz.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxNariz.setEnabled(false);

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel36.setText("Boca:");

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel37.setText("Rosto:");

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel38.setText("Lábios:");

        jComboBoxBoca.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxBoca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Média", "Pequena", "Grande" }));
        jComboBoxBoca.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxBoca.setEnabled(false);

        jComboBoxRosto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxRosto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Comprido", "Oval", "Quadrado", "Redondo", "Médios" }));
        jComboBoxRosto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxRosto.setEnabled(false);

        jComboBoxLabios.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxLabios.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Finos", "Grossos", "Grande", "Pequeno", "Leporinos", "Médios" }));
        jComboBoxLabios.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxLabios.setEnabled(false);

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel39.setText("Camisa:");

        jCamisa.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCamisa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCamisa.setEnabled(false);

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel40.setText("Calça:");

        jCalca.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCalca.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCalca.setEnabled(false);

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel41.setText("Sapato:");

        jSapato.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jSapato.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jSapato.setEnabled(false);

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel32.setText("Peso:");

        jPeso.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPeso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPeso.setEnabled(false);

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel33.setText("Altura:");

        jAltura.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jAltura.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAltura.setEnabled(false);

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel34.setText("Particu:");

        jParticularidade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jParticularidade.setEnabled(false);

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel43.setText("Pescoço");

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel61.setText("Orelha:");

        jComboBoxOrelha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxOrelha.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Abertas", "Coladas", "Grandes", "Médias", "Pequenas" }));
        jComboBoxOrelha.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxOrelha.setEnabled(false);

        jComboBoxPescoco.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxPescoco.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Comprido", "Curto", "Fino", "Grosso", "Médio" }));
        jComboBoxPescoco.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxPescoco.setEnabled(false);

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel62.setText("Comple:");

        jComboBoxCompleicao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxCompleicao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Gordo", "Magro", "Médio", "Raquitico", "Trocudo" }));
        jComboBoxCompleicao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxCompleicao.setEnabled(false);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel43, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCamisa, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                    .addComponent(jComboBoxBoca, 0, 104, Short.MAX_VALUE)
                    .addComponent(jComboBoxBarba, 0, 111, Short.MAX_VALUE)
                    .addComponent(jComboBoxCutis, 0, 111, Short.MAX_VALUE)
                    .addComponent(jPeso)
                    .addComponent(jComboBoxPescoco, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel61, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel40, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jAltura, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCalca, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxRosto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxBigode, 0, 120, Short.MAX_VALUE)
                    .addComponent(jComboBoxOlhos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxOrelha, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel62, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel41, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jParticularidade, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jSapato, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                        .addComponent(jComboBoxLabios, javax.swing.GroupLayout.Alignment.TRAILING, 0, 106, Short.MAX_VALUE)
                        .addComponent(jComboBoxNariz, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBoxCabelos, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jComboBoxCompleicao, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        jPanel9Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jCamisa, jComboBoxBarba, jComboBoxBoca, jComboBoxCutis});

        jPanel9Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jComboBoxBigode, jComboBoxOlhos, jComboBoxRosto});

        jPanel9Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jComboBoxCabelos, jComboBoxLabios, jComboBoxNariz, jParticularidade, jSapato});

        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29)
                    .addComponent(jComboBoxCutis, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxOlhos, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxCabelos, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jComboBoxBarba, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31)
                    .addComponent(jComboBoxBigode, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35)
                    .addComponent(jComboBoxNariz, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(jLabel37)
                    .addComponent(jLabel38)
                    .addComponent(jComboBoxBoca, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxRosto, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxLabios, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(jCamisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40)
                    .addComponent(jCalca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41)
                    .addComponent(jSapato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(jPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33)
                    .addComponent(jAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34)
                    .addComponent(jParticularidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(jLabel61)
                    .addComponent(jComboBoxOrelha, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxPescoco, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel62)
                    .addComponent(jComboBoxCompleicao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jCamisa, jComboBoxBarba, jComboBoxBoca, jComboBoxCutis});

        jPanel9Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jComboBoxBigode, jComboBoxOlhos, jComboBoxRosto});

        jPanel9Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jComboBoxCabelos, jComboBoxLabios, jComboBoxNariz, jParticularidade, jSapato});

        jTabbedPane2.setForeground(new java.awt.Color(255, 0, 0));
        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel44.setText("Data Entrada:");

        jDataEntrada.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataEntrada.setEnabled(false);

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel46.setText("Data Crime:");

        jDataCrime.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataCrime.setEnabled(false);

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel49.setText("Participação:");

        jComboBoxParticipacao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxParticipacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Autor", "Co-Autor" }));
        jComboBoxParticipacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxParticipacao.setEnabled(false);

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(153, 0, 0));
        jLabel45.setText("Procedência:");

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel47.setText("Data Prisão:");

        jDataPrisao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataPrisao.setEnabled(false);

        jComboBoxRegime.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxRegime.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Fechado", "Aberto", "Semi-Aberto", "Provisório" }));
        jComboBoxRegime.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxRegime.setEnabled(false);

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel50.setText("Regime:");

        jBtPesqUnidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqUnidade.setContentAreaFilled(false);
        jBtPesqUnidade.setEnabled(false);
        jBtPesqUnidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqUnidadeActionPerformed(evt);
            }
        });

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel48.setText("Data Conden:");

        jDataCondenacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataCondenacao.setEnabled(false);

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel51.setText("Pena:");

        jPena.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPena.setEnabled(false);

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Artigos e Parágrafos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 204))); // NOI18N

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel52.setText("Artigo 1:");

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel53.setText("Artigo 2:");

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel54.setText("Artigo 3:");

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel55.setText("Parágrafo 1:");

        jArtigo1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jArtigo1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jArtigo1.setEnabled(false);

        jArtigo2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jArtigo2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jArtigo2.setEnabled(false);

        jArtigo3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jArtigo3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jArtigo3.setEnabled(false);

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel56.setText("Parágrafo 2:");

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel57.setText("Parágrafo 3:");

        jParagrafo1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jParagrafo1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jParagrafo1.setEnabled(false);

        jParagrafo2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jParagrafo2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jParagrafo2.setEnabled(false);

        jParagrafo3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jParagrafo3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jParagrafo3.setEnabled(false);

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel58.setText("Crime Hediondo:");

        jComboBoxEdiondo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxEdiondo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Sim", "Não" }));
        jComboBoxEdiondo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxEdiondo.setEnabled(false);

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel59.setText("Término Pena:");

        jDataTerPena.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataTerPena.setEnabled(false);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel54)
                    .addComponent(jLabel52)
                    .addComponent(jLabel53))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jArtigo1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jLabel55)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jParagrafo1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jArtigo2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jArtigo3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel56)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jParagrafo2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel57)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jParagrafo3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel59, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel58, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDataTerPena, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxEdiondo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel52)
                            .addComponent(jLabel55)
                            .addComponent(jArtigo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jParagrafo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jParagrafo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jArtigo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel53)
                            .addComponent(jLabel56))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel54)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jArtigo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel57)
                                .addComponent(jParagrafo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel58)
                            .addComponent(jComboBoxEdiondo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jDataTerPena, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel59))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jComboBoxUnid.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxUnid.setEnabled(false);

        jLabel72.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel72.setText("Vara Condenação:");

        jVaraCondenacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jVaraCondenacao.setEnabled(false);

        jLabel159.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel159.setForeground(new java.awt.Color(0, 0, 255));
        jLabel159.setText("Nova Entrada:");

        jDataNovaEntrada.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataNovaEntrada.setEnabled(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel72, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel49, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel46, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel44, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jComboBoxUnid, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jVaraCondenacao, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jDataCrime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jComboBoxParticipacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel50, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel47, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel159, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addComponent(jDataPrisao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel48)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jDataCondenacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addComponent(jComboBoxRegime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel51)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jPena, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jDataNovaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel46)
                    .addComponent(jDataCrime, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel44)
                            .addComponent(jDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel159)
                            .addComponent(jDataNovaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel47)
                            .addComponent(jDataPrisao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel48)
                            .addComponent(jDataCondenacao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jComboBoxParticipacao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel49)
                            .addComponent(jLabel50)
                            .addComponent(jComboBoxRegime, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel51)
                            .addComponent(jPena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel72)
                    .addComponent(jVaraCondenacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel45)
                    .addComponent(jComboBoxUnid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Dados Penais", jPanel5);

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Foto Perfil", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoPerfil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Foto do Corpo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 0, 255))); // NOI18N

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoCorpo, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoCorpo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Foto Corpo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 0, 255))); // NOI18N

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoCorpo1, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoCorpo1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
        );

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Foto Corpo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 0, 255))); // NOI18N

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoCorpo2, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoCorpo2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
        );

        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel64.setText("Identificação");

        jIdentificador.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdentificador.setEnabled(false);

        jLabel65.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel65.setText("Perfil");

        jPerfil.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPerfil.setEnabled(false);

        jBtNovaFotoPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/2998132-camera-photo-photography_99870.png"))); // NOI18N
        jBtNovaFotoPerfil.setContentAreaFilled(false);
        jBtNovaFotoPerfil.setEnabled(false);
        jBtNovaFotoPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovaFotoPerfilActionPerformed(evt);
            }
        });

        jBtExcluirFotoPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirFotoPerfil.setContentAreaFilled(false);
        jBtExcluirFotoPerfil.setEnabled(false);
        jBtExcluirFotoPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirFotoPerfilActionPerformed(evt);
            }
        });

        jBtNovaFotoCorpo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/2998132-camera-photo-photography_99870.png"))); // NOI18N
        jBtNovaFotoCorpo.setContentAreaFilled(false);
        jBtNovaFotoCorpo.setEnabled(false);
        jBtNovaFotoCorpo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovaFotoCorpoActionPerformed(evt);
            }
        });

        jBtExcluirFotoCorpo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirFotoCorpo.setContentAreaFilled(false);
        jBtExcluirFotoCorpo.setEnabled(false);
        jBtExcluirFotoCorpo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirFotoCorpoActionPerformed(evt);
            }
        });

        jBtNovaFotoCorpo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/2998132-camera-photo-photography_99870.png"))); // NOI18N
        jBtNovaFotoCorpo1.setContentAreaFilled(false);
        jBtNovaFotoCorpo1.setEnabled(false);
        jBtNovaFotoCorpo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovaFotoCorpo1ActionPerformed(evt);
            }
        });

        jBtExcluirFotoCorpo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirFotoCorpo1.setContentAreaFilled(false);
        jBtExcluirFotoCorpo1.setEnabled(false);
        jBtExcluirFotoCorpo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirFotoCorpo1ActionPerformed(evt);
            }
        });

        jBtNovaFotoCorpo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/2998132-camera-photo-photography_99870.png"))); // NOI18N
        jBtNovaFotoCorpo2.setContentAreaFilled(false);
        jBtNovaFotoCorpo2.setEnabled(false);
        jBtNovaFotoCorpo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovaFotoCorpo2ActionPerformed(evt);
            }
        });

        jBtExcluirCorpo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirCorpo2.setContentAreaFilled(false);
        jBtExcluirCorpo2.setEnabled(false);
        jBtExcluirCorpo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirCorpo2ActionPerformed(evt);
            }
        });

        jLabel66.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel66.setText("Identificação");

        jIdentificador1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdentificador1.setEnabled(false);

        jLabel67.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel67.setText("Identificação");

        jIdentificador2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdentificador2.setEnabled(false);

        jLabel68.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel68.setText("Identificação");

        jIdentificador3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdentificador3.setEnabled(false);

        jLabel69.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel69.setText("Região Corpo");

        jRegiaoCorpo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jRegiaoCorpo.setEnabled(false);

        jRegiaoCorpo1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jRegiaoCorpo1.setEnabled(false);

        jLabel70.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel70.setText("Região Corpo");

        jRegiaoCorpo2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jRegiaoCorpo2.setEnabled(false);

        jLabel71.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel71.setText("Região Corpo");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPerfil)
                            .addComponent(jIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel64)
                            .addComponent(jLabel65))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                    .addComponent(jRegiaoCorpo, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jRegiaoCorpo1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jRegiaoCorpo2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel10Layout.createSequentialGroup()
                                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jIdentificador1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel66)
                                        .addComponent(jLabel69))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jIdentificador2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel67)
                                        .addComponent(jLabel70))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel71)
                                        .addComponent(jIdentificador3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel68))))))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jBtNovaFotoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtExcluirFotoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(jBtNovaFotoCorpo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtExcluirFotoCorpo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(jBtNovaFotoCorpo1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtExcluirFotoCorpo1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(jBtNovaFotoCorpo2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtExcluirCorpo2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44))
        );

        jPanel10Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel12, jPanel14, jPanel15, jPanel16});

        jPanel10Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jIdentificador, jIdentificador1, jIdentificador2, jIdentificador3, jPerfil, jRegiaoCorpo, jRegiaoCorpo1, jRegiaoCorpo2});

        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel65)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel67)
                            .addComponent(jLabel66)
                            .addComponent(jLabel64)
                            .addComponent(jLabel68))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jIdentificador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jIdentificador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jIdentificador3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel71)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(jRegiaoCorpo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jRegiaoCorpo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jRegiaoCorpo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel70)
                                    .addComponent(jLabel69))
                                .addGap(24, 24, 24)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jBtNovaFotoCorpo2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jBtExcluirFotoCorpo1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jBtNovaFotoCorpo1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jBtExcluirFotoCorpo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jBtNovaFotoCorpo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jBtExcluirFotoPerfil, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jBtNovaFotoPerfil, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtExcluirCorpo2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );

        jPanel10Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jIdentificador, jIdentificador1, jIdentificador2, jIdentificador3, jPerfil, jRegiaoCorpo, jRegiaoCorpo1, jRegiaoCorpo2});

        jTabbedPane2.addTab("Fotos", jPanel10);

        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Médio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 0, 255))); // NOI18N

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoMedioDireito, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoMedioDireito, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        jPanel27.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Médio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 0, 255))); // NOI18N

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoMedioEsquerdo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoMedioEsquerdo, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Anular", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 0, 255))); // NOI18N

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoAnularDireito, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoAnularDireito, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        jPanel28.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Anular", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 0, 255))); // NOI18N

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoAnularEsquerdo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoAnularEsquerdo, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        jPanel24.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mínimo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 0, 255))); // NOI18N

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoMininoDireito, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoMininoDireito, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        jPanel29.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mínimo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 0, 255))); // NOI18N

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoMinimoEsquerdo, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoMinimoEsquerdo, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Polegar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 0, 255))); // NOI18N

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoPolegarDireito, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoPolegarDireito, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        jPanel25.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Polegar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 0, 255))); // NOI18N

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoPolegarEsquerdo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoPolegarEsquerdo, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Indicador", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 0, 255))); // NOI18N

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoIndicadorDireito, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoIndicadorDireito, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        jPanel26.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Indicador", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 0, 255))); // NOI18N

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoIndicadorEsquerdo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoIndicadorEsquerdo, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        jLabel160.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel160.setText("Mão Direita");

        jLabel161.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel161.setText("Mão Esquerda");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(37, Short.MAX_VALUE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(jLabel161)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(jLabel160)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator2)))
                        .addContainerGap())))
        );

        jPanel17Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel20, jPanel21, jPanel22, jPanel23, jPanel24, jPanel25, jPanel26, jPanel27, jPanel28, jPanel29});

        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel160))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel161)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel28, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel27, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel17Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel20, jPanel21, jPanel22, jPanel23, jPanel24, jPanel25, jPanel26, jPanel27, jPanel28, jPanel29});

        jTabbedPane2.addTab("Ficha Datiloscópica", jPanel17);

        jPanel33.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jBtNovo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovo1.setText("Novo");
        jBtNovo1.setToolTipText("Novo Registro");
        jBtNovo1.setContentAreaFilled(false);
        jBtNovo1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovo1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovo1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovo1ActionPerformed(evt);
            }
        });

        jBtAlterar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterar1.setText("Alterar");
        jBtAlterar1.setToolTipText("Atualizar Registro");
        jBtAlterar1.setContentAreaFilled(false);
        jBtAlterar1.setEnabled(false);
        jBtAlterar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterar1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterar1ActionPerformed(evt);
            }
        });

        jBtExcluir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluir1.setText("Excluir");
        jBtExcluir1.setToolTipText("Excluir Registro");
        jBtExcluir1.setContentAreaFilled(false);
        jBtExcluir1.setEnabled(false);
        jBtExcluir1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluir1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluir1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluir1ActionPerformed(evt);
            }
        });

        jBtSalvar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvar1.setText("Gravar");
        jBtSalvar1.setToolTipText("Salvar Registro");
        jBtSalvar1.setContentAreaFilled(false);
        jBtSalvar1.setEnabled(false);
        jBtSalvar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvar1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvar1ActionPerformed(evt);
            }
        });

        jBtCancelar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelar1.setText("Cancelar");
        jBtCancelar1.setToolTipText("Cancelar Operação");
        jBtCancelar1.setContentAreaFilled(false);
        jBtCancelar1.setEnabled(false);
        jBtCancelar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelar1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelar1ActionPerformed(evt);
            }
        });

        jBtSair1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSair1.setText("Sair");
        jBtSair1.setToolTipText("Sair da Tela");
        jBtSair1.setContentAreaFilled(false);
        jBtSair1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSair1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSair1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSair1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSair1ActionPerformed(evt);
            }
        });

        jBtImpressao1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/gtklp-icone-3770-16.png"))); // NOI18N
        jBtImpressao1.setToolTipText("Impressão");
        jBtImpressao1.setContentAreaFilled(false);
        jBtImpressao1.setEnabled(false);
        jBtImpressao1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtImpressao1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtImpressao1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtImpressao1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtImpressao1ActionPerformed(evt);
            }
        });

        jBtAuditoriaPronCrc1.setForeground(new java.awt.Color(255, 0, 0));
        jBtAuditoriaPronCrc1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaPronCrc1.setToolTipText("Auditoria");
        jBtAuditoriaPronCrc1.setContentAreaFilled(false);
        jBtAuditoriaPronCrc1.setEnabled(false);
        jBtAuditoriaPronCrc1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAuditoriaPronCrc1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAuditoriaPronCrc1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAuditoriaPronCrc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaPronCrc1ActionPerformed(evt);
            }
        });

        jBtObservacao1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/accept.png"))); // NOI18N
        jBtObservacao1.setToolTipText("Observação");
        jBtObservacao1.setContentAreaFilled(false);
        jBtObservacao1.setEnabled(false);
        jBtObservacao1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtObservacao1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtObservacao1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtObservacao1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtObservacao1ActionPerformed(evt);
            }
        });

        jBtBuscarRegPortaria1.setForeground(new java.awt.Color(0, 0, 255));
        jBtBuscarRegPortaria1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtBuscarRegPortaria1.setToolTipText("Buscar Registro Interno na Portaria");
        jBtBuscarRegPortaria1.setContentAreaFilled(false);
        jBtBuscarRegPortaria1.setEnabled(false);
        jBtBuscarRegPortaria1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtBuscarRegPortaria1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtBuscarRegPortaria1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtBuscarRegPortaria1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtBuscarRegPortaria1ActionPerformed(evt);
            }
        });

        jBtBiometria.setForeground(new java.awt.Color(0, 153, 51));
        jBtBiometria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Biometria16Vermelho.png"))); // NOI18N
        jBtBiometria.setToolTipText("Biometria");
        jBtBiometria.setContentAreaFilled(false);
        jBtBiometria.setEnabled(false);
        jBtBiometria.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtBiometria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtBiometriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel33Layout.createSequentialGroup()
                .addComponent(jBtNovo1)
                .addGap(1, 1, 1)
                .addComponent(jBtAlterar1)
                .addGap(1, 1, 1)
                .addComponent(jBtExcluir1)
                .addGap(1, 1, 1)
                .addComponent(jBtSalvar1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSair1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtImpressao1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtObservacao1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtBuscarRegPortaria1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtAuditoriaPronCrc1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtBiometria, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(jBtSair1)
                .addComponent(jBtNovo1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jBtAlterar1)
                .addComponent(jBtExcluir1)
                .addComponent(jBtSalvar1)
                .addComponent(jBtCancelar1)
                .addComponent(jBtImpressao1)
                .addComponent(jBtObservacao1)
                .addComponent(jBtBuscarRegPortaria1)
                .addComponent(jBtAuditoriaPronCrc1)
                .addComponent(jBtBiometria))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane2)
                    .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );

        jTabbedPane1.addTab("Dados Fisicos/Penais", jPanel8);

        jLabel74.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel74.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/FRENTE_HOME_COMPLETO.jpg"))); // NOI18N

        jTabbedPane3.setForeground(new java.awt.Color(0, 51, 255));
        jTabbedPane3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel83.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel83.setText("7 - Labial");

        jLabel82.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel82.setText("6 - Bucinadoras");

        jLabel87.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel87.setText("11 - Carotidianas");

        jLabel86.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel86.setText("10 - Infra-hioidea");

        jLabel110.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel110.setText("34 - Terços Sup. antebraços");

        jLabel85.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel85.setText("9 - Supra-hioidea");

        jLabel84.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel84.setText("8 - Metoniana");

        jLabel108.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel108.setText("32 - Terços Inf. dos Braços");

        jLabel91.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel91.setText("15 - External");

        jLabel109.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel109.setText("33 - Prego dos Cotovelos");

        jLabel90.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel90.setText("14 - Infraclaviculares");

        jLabel106.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel106.setText("30 - Terços Superiores");

        jLabel89.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel89.setText("13 - Claviculares");

        jLabel107.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel107.setText("31 - Terços Médio dos Braços");

        jLabel88.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel88.setText("12 - Supracalviculares");

        jLabel104.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel104.setText("28 - (H) Peniana");

        jLabel105.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel105.setText("29 - (H) Escrotal");

        jLabel102.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel102.setText("26 - Inguinais");

        jLabel103.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel103.setText("27 - Crurais");

        jLabel92.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel92.setText("16 - Torácicas");

        jLabel94.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel94.setText("18 - Epigástricas");

        jLabel93.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel93.setText("17 - Mamárias");

        jLabel96.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel96.setText("20 - Mesogástrica");

        jLabel95.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel95.setText("19 - Hipocôndrias");

        jLabel98.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel98.setText("22 - Flancos");

        jLabel97.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel97.setText("21 - Umbilical");

        jLabel100.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel100.setText("24 - Fossas Iliácas");

        jLabel81.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel81.setText("5 - Masseterianas");

        jLabel99.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel99.setText("23 - Hipogástrica");

        jLabel101.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel101.setText("25 - Pubiana");

        jLabel78.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel78.setText("2 - Orbitárias");

        jLabel77.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel77.setText("1 - Frontal");

        jLabel80.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel80.setText("4 - Malares");

        jLabel79.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel79.setText("3 - Nasal");

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel90)
                    .addComponent(jLabel91)
                    .addComponent(jLabel92)
                    .addComponent(jLabel93)
                    .addComponent(jLabel88)
                    .addComponent(jLabel89)
                    .addComponent(jLabel77)
                    .addComponent(jLabel78)
                    .addComponent(jLabel79)
                    .addComponent(jLabel80)
                    .addComponent(jLabel81)
                    .addComponent(jLabel82)
                    .addComponent(jLabel83)
                    .addComponent(jLabel84)
                    .addComponent(jLabel85)
                    .addComponent(jLabel86)
                    .addComponent(jLabel87))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel108)
                    .addComponent(jLabel110)
                    .addComponent(jLabel109)
                    .addComponent(jLabel104)
                    .addComponent(jLabel103)
                    .addComponent(jLabel105)
                    .addComponent(jLabel107)
                    .addComponent(jLabel106)
                    .addComponent(jLabel95)
                    .addComponent(jLabel94)
                    .addComponent(jLabel96)
                    .addComponent(jLabel97)
                    .addComponent(jLabel98)
                    .addComponent(jLabel99)
                    .addComponent(jLabel100)
                    .addComponent(jLabel101)
                    .addComponent(jLabel102))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel77)
                    .addComponent(jLabel94))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel78)
                    .addComponent(jLabel95))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel79)
                    .addComponent(jLabel96))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel80)
                    .addComponent(jLabel97))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel81)
                    .addComponent(jLabel98))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel82)
                    .addComponent(jLabel99))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel83)
                    .addComponent(jLabel100))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel84)
                    .addComponent(jLabel101))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel85)
                    .addComponent(jLabel102))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel86)
                    .addComponent(jLabel103))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel87)
                    .addComponent(jLabel104))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel88)
                    .addComponent(jLabel105))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel89)
                    .addComponent(jLabel106))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel90)
                    .addComponent(jLabel107))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel91)
                    .addComponent(jLabel108))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel92)
                    .addComponent(jLabel109))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel93)
                    .addComponent(jLabel110))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Região - A", jPanel41);

        jLabel123.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel123.setText("47 - Lateral Externa das pernas");

        jLabel122.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel122.setText("46 - Terços  inferiores das pernas");

        jLabel124.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel124.setText("48 - Lateral interna das pernas");

        jLabel121.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel121.setText("45 - Terços médio das pernas");

        jLabel117.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel117.setText("41 - Terços Inferiores das Coxas");

        jLabel118.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel118.setText("42 - Rotulianas");

        jLabel119.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel119.setText("43 - Faces anterioires do joelho");

        jLabel120.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel120.setText("44 - Terços superiores das pernas ");

        jLabel116.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel116.setText("40 - Terços Médio das Coxas");

        jLabel111.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel111.setText("35 - Terços Médio dos antebraços");

        jLabel112.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel112.setText("36 - Terços inferiores dos antebraços");

        jLabel113.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel113.setText("37 - Punhos");

        jLabel114.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel114.setText("38 - Côncavos das mãos");

        jLabel115.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel115.setText("39 - Terços Superioires das Coxas");

        jLabel125.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel125.setText("49 - Dorsal do pé");

        jLabel126.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel126.setText("50 - (M) Vulgo vaginal");

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel126)
                    .addComponent(jLabel125)
                    .addComponent(jLabel116)
                    .addComponent(jLabel111)
                    .addComponent(jLabel112)
                    .addComponent(jLabel113)
                    .addComponent(jLabel114)
                    .addComponent(jLabel115)
                    .addComponent(jLabel117)
                    .addComponent(jLabel118)
                    .addComponent(jLabel119)
                    .addComponent(jLabel120)
                    .addComponent(jLabel121)
                    .addComponent(jLabel122)
                    .addComponent(jLabel123)
                    .addComponent(jLabel124))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel111)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel112)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel113)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel114)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel115)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel116)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel117)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel118)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel119)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel120)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel121)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel122)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel123)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel124)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel125)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel126)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Região - B", jPanel42);

        jLabel76.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel76.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/FRENTE_HOMEM.jpg"))); // NOI18N

        jBtPeculiaridadeFrente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/folder_blue_open.png"))); // NOI18N
        jBtPeculiaridadeFrente.setEnabled(false);
        jBtPeculiaridadeFrente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPeculiaridadeFrenteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addComponent(jLabel76)
                        .addGap(107, 107, 107)
                        .addComponent(jBtPeculiaridadeFrente))
                    .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addComponent(jLabel74, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jBtPeculiaridadeFrente)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addComponent(jLabel76, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        jTabbedPane1.addTab("Peculiaridade Frente", jPanel34);

        jPanel37.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel75.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel75.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/COSTAS_III.jpg"))); // NOI18N

        jPanel38.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Região", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        jLabel127.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel127.setText("1 - Parietal");

        jLabel128.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel128.setText("2 - Occipital");

        jLabel129.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel129.setText("3 - Temporal");

        jLabel130.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel130.setText("4 - Cervical");

        jLabel131.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel131.setText("5 - Supra espacular");

        jLabel132.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel132.setText("6 - Espacular");

        jLabel133.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel133.setText("7 - Dorsal");

        jLabel134.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel134.setText("8 - Lombar");

        jLabel135.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel135.setText("9 - Iliaca");

        jLabel136.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel136.setText("10 - Espondiléia");

        jLabel137.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel137.setText("11 - Sacro coccigea");

        jLabel138.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel138.setText("12 - Glútea");

        jLabel139.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel139.setText("13 - Terço superior da coxa");

        jLabel140.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel140.setText("14 - Terço médio da coxa");

        jLabel141.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel141.setText("15 - Terço inferior da perna");

        jLabel142.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel142.setText("17 - Terço sup. da perna");

        jLabel143.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel143.setText("18 - Terço médio perna");

        jLabel144.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel144.setText("19 - Terço inf. da perna");

        jLabel145.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel145.setText("20 - Maleolar externa");

        jLabel146.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel146.setText("21 - Calcaniana");

        jLabel147.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel147.setText("22 - Borda extena do pé");

        jLabel148.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel148.setText("23 - Deltódiana");

        jLabel149.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel149.setText("24 - Terço Sup. do braço");

        jLabel150.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel150.setText("25 - Terço médio braço");

        jLabel151.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel151.setText("26 - Terço inf. do braço");

        jLabel152.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel152.setText("27 - Cotovelo");

        jLabel153.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel153.setText("28 - Terço sup. antebraço");

        jLabel154.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel154.setText("29 - Terço  méd. antebraço");

        jLabel155.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel155.setText("30 - Terço inf. antebraço");

        jLabel156.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel156.setText("31 - Punho");

        jLabel157.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel157.setText("16 - Poplitéia");

        jLabel158.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel158.setText("32 - Face dorsal mão");

        jBtPeculiaridadeCostas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/folder_blue_open.png"))); // NOI18N
        jBtPeculiaridadeCostas.setToolTipText("Cadastrar Peculiaridade Costas");
        jBtPeculiaridadeCostas.setEnabled(false);
        jBtPeculiaridadeCostas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPeculiaridadeCostasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel127)
                    .addComponent(jLabel128)
                    .addComponent(jLabel129)
                    .addComponent(jLabel130)
                    .addComponent(jLabel131)
                    .addComponent(jLabel132)
                    .addComponent(jLabel133)
                    .addComponent(jLabel134)
                    .addComponent(jLabel135)
                    .addComponent(jLabel136)
                    .addComponent(jLabel137)
                    .addComponent(jLabel138)
                    .addComponent(jLabel139)
                    .addComponent(jLabel140)
                    .addComponent(jLabel141)
                    .addComponent(jLabel157)
                    .addComponent(jLabel145)
                    .addComponent(jLabel144, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel142)
                    .addComponent(jLabel143))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel146)
                    .addComponent(jLabel147)
                    .addComponent(jLabel148)
                    .addComponent(jLabel149)
                    .addComponent(jLabel150)
                    .addComponent(jLabel151)
                    .addComponent(jLabel152)
                    .addComponent(jLabel153)
                    .addComponent(jLabel154)
                    .addComponent(jLabel155)
                    .addComponent(jLabel156)
                    .addComponent(jLabel158)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
                        .addComponent(jBtPeculiaridadeCostas)
                        .addGap(36, 36, 36)))
                .addContainerGap())
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addComponent(jLabel127)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel128)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel129)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel130)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel131)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel132)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel133)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel134)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel135)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel136)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel137)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel138))
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addComponent(jLabel146)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel147)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel148)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel149)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel150)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel151)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel152)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel153)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel154)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel155)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel156)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel158)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel139)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel140)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel141)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel157)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel142)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addComponent(jLabel143)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel144)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel145))
                    .addComponent(jBtPeculiaridadeCostas))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel39.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 52, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel75)
                    .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Peculiaridade Costas", jPanel35);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setBounds(300, 15, 649, 582);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxCabelosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCabelosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCabelosActionPerformed

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCadastroProntuarioManuTRI);
        if (codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaCadastroProntuarioManuTRI) && codIncluirTRI == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTRI.equals("ADMINISTRADORES")) {
            VERIFICAR_PARAMETROS_crc();
            acao = 1;
            Novo();
            corCampos();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado.");
        }
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        // TODO add your handling code here:  
        buscarAcessoUsuario(telaCadastroProntuarioManuTRI);
        if (codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaCadastroProntuarioManuTRI) && codAlterarTRI == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTRI.equals("ADMINISTRADORES")) {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM PARAMETROSCRC "
                        + "WHERE UsuarioAutorizado='" + nameUser + "'");
                conecta.rs.first();
                usuarioAutorizado = conecta.rs.getString("UsuarioAutorizado");
            } catch (SQLException ex) {
            }
            VERIFICAR_PARAMETROS_crc();
            acao = 2;
            Alterar();
            corCampos();
            statusMov = "Alterou";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            if (nameUser == null ? nomeUsuarioCrc == null : nameUser.equals(nomeUsuarioCrc) || (nameUser == null ? usuarioAutorizado == null : nameUser.equals(usuarioAutorizado))) {
                jSituacao.setEnabled(true);
            }
            conecta.desconecta();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado.");
        }
    }//GEN-LAST:event_jBtAlterarActionPerformed

    private void jBtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirActionPerformed
        buscarAcessoUsuario(telaCadastroProntuarioManuTRI);
        if (codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaCadastroProntuarioManuTRI) && codExcluirTRI == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTRI.equals("ADMINISTRADORES")) {
            pVERIFICAR_ENTRADA_internos();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado.");
        }
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:  
        buscarAcessoUsuario(telaCadastroProntuarioManuTRI);
        if (codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaCadastroProntuarioManuTRI) && codGravarTRI == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTRI.equals("ADMINISTRADORES")) {
            if (jNomeInterno.getText().isEmpty() || jNomeInterno.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Nome do INTERNO não pode ser em branco...");
                jNomeInterno.requestFocus();
            } else if (jMaeInterno.getText().isEmpty() || jMaeInterno.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Nome da MÃE do INTERNO não pode ser em branco...");
                jMaeInterno.requestFocus();
            } else if (jPaiInterno.getText().isEmpty() || jPaiInterno.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Nome do PAI do INTERNO não pode ser em branco...");
                jPaiInterno.requestFocus();
            } else if (jComboBoxSexo.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o sexo do interno(a).");
                jComboBoxSexo.requestFocus();
            } else if (caminhoFotoInternoTRIAGEM == null) {
                JOptionPane.showMessageDialog(rootPane, "FOTO do INTERNO não pode ser em branco...");
            } else if (jDataNascimento.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "DATA NASCIMENTO não pode ser em branco");
                jDataCadastro.requestFocus();
            } else if (jDataEntrada.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "DATA ENTRADA não pode ser em branco");
                jDataEntrada.requestFocus();
            } else if (jDataCrime.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "DATA CRIME não pode ser em branco");
                jDataCrime.requestFocus();
            } else if (jDataPrisao.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "DATA PRISÃO não pode ser em branco");
                jDataPrisao.requestFocus();
            } else if (jDataCondenacao.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "DATA CONDENAÇÃO não pode ser em branco");
                jDataCondenacao.requestFocus();
            } else if (jComboBoxUnid.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe a unidade penal");
                jComboBoxUnid.requestFocus();
                jComboBoxUnid.setBackground(Color.red);
            } else if (jComboBoxPais.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome do Paíes");
                jComboBoxPais.requestFocus();
                jComboBoxPais.setBackground(Color.red);
            } else if (jComboBoxCidade.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome da Cidade");
                jComboBoxCidade.requestFocus();
                jComboBoxCidade.setBackground(Color.red);
            } else if (jComboBoxEscolaridade.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o grau de instrução do interno.");
                jComboBoxEscolaridade.requestFocus();
                jComboBoxEscolaridade.setBackground(Color.red);
            } else {
                if (ValidaCPF.isCPF(jCPFInterno.getText()) == true) {
                    objProCrc.setMatricula(jMatriculaPenal.getText());
                    objProCrc.setDataCadast(jDataCadastro.getDate());
                    objProCrc.setDataNasci(jDataNascimento.getDate());
                    objProCrc.setNomeInterno(jNomeInterno.getText());
                    objProCrc.setMaeInterno(jMaeInterno.getText());
                    objProCrc.setPaiInterno(jPaiInterno.getText());
                    objProCrc.setAlcunha(jAlcunha.getText());
                    objProCrc.setRgInterno(jRGInterno.getText());
                    objProCrc.setuFRg((String) jComboBoxUF.getSelectedItem());
                    objProCrc.setCpfInterno(jCPFInterno.getText());
                    objProCrc.setCartoaSus(jCartaoSus.getText());
                    objProCrc.setFotoInterno(caminhoFotoInternoTRIAGEM);
                    objProCrc.setEscolaridade((String) jComboBoxEscolaridade.getSelectedItem());
                    objProCrc.setEstadoCivil((String) jComboBoxEstadoCivil.getSelectedItem());
                    objProCrc.setSexo((String) jComboBoxSexo.getSelectedItem());
                    objProCrc.setSituacao(jSituacao.getText());
                    objProCrc.setNomePais(jComboBoxPais.getText());
                    objProCrc.setNomeCidade(jComboBoxCidade.getText());
                    objProCrc.setReligiao(jReligiao.getText());
                    objProCrc.setProfissao(jProfissao.getText());
                    objProCrc.setEndereco(jEndereco.getText());
                    objProCrc.setBairro(jBairro.getText());
                    objProCrc.setCidade(jCidade.getText());
                    objProCrc.setEstado(jEstado.getText());
                    objProCrc.setTelefone(jTelefone.getText());
                    objProCrc.setTelefone1(jTelefone1.getText());
                    objProCrc.setCelular(jCelular.getText());
                    objProCrc.setCnc(jCNC.getText());
                    // Classe Dados Fisicos
                    objDadosFis.setCutis((String) jComboBoxCutis.getSelectedItem());
                    objDadosFis.setOlhos((String) jComboBoxOlhos.getSelectedItem());
                    objDadosFis.setCabelos((String) jComboBoxCabelos.getSelectedItem());
                    objDadosFis.setBarba((String) jComboBoxBarba.getSelectedItem());
                    objDadosFis.setBigode((String) jComboBoxBigode.getSelectedItem());
                    objDadosFis.setNariz((String) jComboBoxNariz.getSelectedItem());
                    objDadosFis.setBoca((String) jComboBoxBoca.getSelectedItem());
                    objDadosFis.setRosto((String) jComboBoxRosto.getSelectedItem());
                    objDadosFis.setLabios((String) jComboBoxLabios.getSelectedItem());
                    objDadosFis.setCamisa(jCamisa.getText());
                    objDadosFis.setCalca(jCalca.getText());
                    objDadosFis.setSapato(jSapato.getText());
                    objDadosFis.setPeso(jPeso.getText());
                    objDadosFis.setAltura(jAltura.getText());
                    objDadosFis.setSinais(jParticularidade.getText());
                    objDadosFis.setOrelha((String) jComboBoxOrelha.getSelectedItem());
                    objDadosFis.setPescoco((String) jComboBoxPescoco.getSelectedItem());
                    objDadosFis.setCompleicao((String) jComboBoxCompleicao.getSelectedItem());
                    // Dados Penais
                    objDadosPena.setDataEntrada(jDataEntrada.getDate());
                    objDadosPena.setNomeUnidade(jComboBoxUnid.getText());
                    objDadosPena.setDataCrime(jDataCrime.getDate());
                    objDadosPena.setDataPrisao(jDataPrisao.getDate());
                    objDadosPena.setDataCondenacao(jDataCondenacao.getDate());
                    objDadosPena.setParticipacao((String) jComboBoxParticipacao.getSelectedItem());
                    objDadosPena.setRegime((String) jComboBoxRegime.getSelectedItem());
                    objDadosPena.setPena(jPena.getText());
                    objDadosPena.setArtigo1(jArtigo1.getText());
                    objDadosPena.setArtigo2(jArtigo2.getText());
                    objDadosPena.setArtigo3(jArtigo3.getText());
                    objDadosPena.setParagrafo1(jParagrafo1.getText());
                    objDadosPena.setParagrafo2(jParagrafo2.getText());
                    objDadosPena.setParagrafo3(jParagrafo3.getText());
                    objDadosPena.setCrimeEdiondo((String) jComboBoxEdiondo.getSelectedItem());
                    objDadosPena.setTerminoPena(jDataTerPena.getDate());
                    objDadosPena.setIdentificador(jIdentificador.getText());
                    objDadosPena.setIdentificador1(jIdentificador1.getText());
                    objDadosPena.setIdentificador2(jIdentificador2.getText());
                    objDadosPena.setIdentificador3(jIdentificador3.getText());
                    objDadosPena.setPerfil(jPerfil.getText());
                    objDadosPena.setRegiaoCorpo(jRegiaoCorpo.getText());
                    objDadosPena.setRegiaoCorpo1(jRegiaoCorpo1.getText());
                    objDadosPena.setRegiaoCorpo2(jRegiaoCorpo2.getText());
                    objDadosPena.setFotoPerfil(caminhoFotoPerfil);
                    objDadosPena.setFotoCorpo(caminhoFotoCorpo);
                    objDadosPena.setFotoCorpo1(caminhoFotoCorpo1);
                    objDadosPena.setFotoCorpo2(caminhoFotoCorpo2);
                    objDadosPena.setVaraCondenatoria(jVaraCondenacao.getText());
                    objDadosPena.setDataNovaEntrada(jDataNovaEntrada.getDate());
                    objProCrc.setUsuarioInsert(nameUser);
                    objProCrc.setDataInsert(jDataSistema.getText());
                    objProCrc.setHoraInsert(jHoraSistema.getText());
                    // PREPARAR FOTO PARA GRAVAR NO BANCO DE DADOS - FOTO DE FRENTE 
                    if (jLabelFotoInterno.getIcon() != null) {//                                                                   
                        objProCrc.setImagemInterno(persona_imagem);
                    }
                    // PREPARAR FOTO PARA GRAVAR NO BANCO DE DADOS FOTO DE PERFIL
                    if (jFotoPerfil.getIcon() != null) {//                                                                
                        objDadosPena.setImagemPerfil(persona_imagem1);
                    }
                    // PREPARAR FOTO PARA GRAVAR NO BANCO DE DADOS FOTO DE PERFIL - FOTO CORPO
                    if (jFotoCorpo.getIcon() != null) {
                        objDadosPena.setImagemCorpo(persona_imagem2);
                    }
                    // PREPARAR FOTO PARA GRAVAR NO BANCO DE DADOS FOTO DE PERFIL - FOTO CORPO1
                    if (jFotoCorpo1.getIcon() != null) {//                                                                  
                        objDadosPena.setImagemCorpo1(persona_imagem3);
                    }
                    // PREPARAR FOTO PARA GRAVAR NO BANCO DE DADOS FOTO DE PERFIL - FOTO CORPO2
                    if (jFotoCorpo2.getIcon() != null) {//                                                                    
                        objDadosPena.setImagemCorpo2(persona_imagem4);
                    }
                    //VERIFICAR SE O INTERNO JÁ EXISTE PARA NÃO CADASTRAR EM DUPLICIDADE
                    PESQUISAR_EXISTENCIA_interno();
                    if (acao == 1) {
                        if (jNomeInterno.getText().trim().equals(nomeInternoCrc) && jMaeInterno.getText().trim().equals(nomeMaeInterno)) {
                            JOptionPane.showMessageDialog(rootPane, "Esse Interno já foi cadastrado.");
                            conecta.desconecta();
                        } else {
                            //GRAVA NA TABELA PRONTUARIOSCRC
                            CONTROLE_DADOS_civil.incluirInternoCrc(objProCrc);
                            BUSCAR_CODIGO_interno();
                            // TABELA NA TABELA DADOSFISICOSINTERNOS
                            objDadosFis.setNomeInternoCrc(jNomeInterno.getText());
                            objDadosFis.setNomeMaeInternoCrc(jMaeInterno.getText());
                            CONTROLE_DADOS_fisicos.incluirDadosFisicos(objDadosFis);
                            // GRAVA NA TABELA DADOSPENAISINTERNOS
                            objDadosPena.setNomeInternoCrc(jNomeInterno.getText());
                            objDadosPena.setNomeMaeInternoCrc(jMaeInterno.getText());
                            CONTROLE_DADOS_penais.incluirDadosPenais(objDadosPena);
                            // VERIFICAR SE O INTERNO FOI GRAVADO NA TABELA DADOSPENAISINTERNOS COM SUCESSO
                            objProCrc.setIdInterno(Integer.valueOf(jIdInterno.getText()));
                            VERIFICAR_GRAVACAO_interno();
                            if (jIdInterno.getText().equals(CODIGO_INTERNO_TABELA_penal)
                                    && pRESPOSTA_gravacao.equals("Sim")
                                    && pRESPOSTA_DADOS_fisicos.equals("Sim")
                                    && pRESPOSTA_DADOS_penais.equals("Sim")) {
                                // Confirma a utilização do registro do interno iniciado pela portaria.
                                objProCrc.setNomeInterno(jNomeInterno.getText());
                                objProCrc.setConfirmaEntrada(confirmaEntrada);
                                CONTROLE_DADOS_civil.confirmarRegInternoCrc(objProCrc);
                                //
                                objLog();
                                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                                Salvar();
                            } else {
                                //SE O REGISTRO NÃO FOI INCLUÍDO NAS 03(TRÊS) TABELAS CORRETAMENTE, APAGA O REGISTRO NAS OUTRAS
                                DELETAR_REGISTRO_interno();
                                if (pRESPOSTA_EXCLUSÃO_fisicos.equals("Sim") && pRESPOSTA_EXCLUSÃO_prontuario.equals("Sim")) {
                                    JOptionPane.showMessageDialog(rootPane, "Não foi possível concluir a gravação do registro, por favor tente novamente.");
                                } else {
                                    JOptionPane.showMessageDialog(rootPane, "Existem residuos do cadastro do interno, será necessário realizar uma limpeza diretamente no banco de dados.\nCaso não seja realizado a limpeza direto no banco de dados, não será possível registrar esse interno.");
                                }
                            }
                        }
                    }
                    if (acao == 2) {
                        try {
                            objProCrc.setUsuarioUp(nameUser);
                            objProCrc.setDataUp(jDataSistema.getText());
                            objProCrc.setHoraUp(jHoraSistema.getText());
                            objProCrc.setIdInterno(Integer.parseInt(jIdInterno.getText()));
                            objDadosFis.setIdInternoCrc(Integer.parseInt(jIdInterno.getText()));
                            objDadosPena.setIdInternoCrc(Integer.parseInt(jIdInterno.getText()));
                            CONTROLE_DADOS_civil.alterarInternoCrc(objProCrc);
                            CONTROLE_DADOS_fisicos.alterarDadosFisicos(objDadosFis);
                            CONTROLE_DADOS_penais.alterarDadosPenais(objDadosPena);
                            objLog();
                            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação          
                            JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso...");
                            Salvar();
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(rootPane, "Não foi possível alterar o registro.\nERRO: " + e);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "CPF invalido !!!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado.");
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

    private void jTabelaInternoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaInternoMouseClicked
        // TODO add your handling code here:
        // Clique para mostra na tela e modificar
        flag = 1;
        if (flag == 1) {
            String nomeInterno = "" + jTabelaInterno.getValueAt(jTabelaInterno.getSelectedRow(), 1);
            jPesqNome.setText(nomeInterno);
            String idInt = "" + jTabelaInterno.getValueAt(jTabelaInterno.getSelectedRow(), 0);
            jIdInterno.setText(idInt);
            // Habilitar botões
            jBtZoonFoto.setEnabled(true);
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(true);
            jBtNovaFoto.setEnabled(!true);
            jBtExcluirFoto.setEnabled(!true);
            jBtPesqPais.setEnabled(!true);
            jBtPesqCidade.setEnabled(!true);
            jBtPesqCidadeEnd.setEnabled(!true);
            jBtPesqUnidade.setEnabled(!true);
            jBtImpressao.setEnabled(true);
            jBtAuditoriaPronCrc.setEnabled(true);
            jBtObservacao.setEnabled(true);
            jBtPeculiaridadeCostas.setEnabled(true);
            jBtPeculiaridadeFrente.setEnabled(true);
            //
            jBtNovo1.setEnabled(true);
            jBtAlterar1.setEnabled(true);
            jBtExcluir1.setEnabled(true);
            jBtSalvar1.setEnabled(!true);
            jBtCancelar1.setEnabled(true);
            jBtImpressao1.setEnabled(true);
            jBtAuditoriaPronCrc1.setEnabled(true);
            jBtObservacao1.setEnabled(true);
            jBtBiometria.setEnabled(true);
            //
            bloquearCamposEdicao();
            //
            jFotoPolegarDireito.setIcon(null);
            jFotoIndicadorDireito.setIcon(null);
            jFotoMedioDireito.setIcon(null);
            jFotoAnularDireito.setIcon(null);
            jFotoMininoDireito.setIcon(null);
            //
            jFotoPolegarEsquerdo.setIcon(null);
            jFotoIndicadorEsquerdo.setIcon(null);
            jFotoMedioEsquerdo.setIcon(null);
            jFotoAnularEsquerdo.setIcon(null);
            jFotoMinimoEsquerdo.setIcon(null);
            // LIMPAR FOTOS
            jLabelFotoInterno.setIcon(null);
            jFotoPerfil.setIcon(null);
            jFotoCorpo.setIcon(null);
            jFotoCorpo1.setIcon(null);
            jFotoCorpo2.setIcon(null);
            //
            conecta.abrirConexao();
            try {
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
                        + "WHERE PRONTUARIOSCRC.NomeInternoCrc='" + nomeInterno + "' "
                        + "AND PRONTUARIOSCRC.IdInternoCrc='" + idInt + "'");
                conecta.rs.first();
                jIdInterno.setText(String.valueOf(conecta.rs.getInt("IdInternoCrc")));
                jMatriculaPenal.setText(conecta.rs.getString("MatriculaCrc"));
                jDataCadastro.setDate(conecta.rs.getDate("DataCadastCrc"));
                jDataNascimento.setDate(conecta.rs.getDate("DataNasciCrc"));
                jNomeInterno.setText(conecta.rs.getString("NomeInternoCrc"));
                jMaeInterno.setText(conecta.rs.getString("MaeInternoCrc"));
                jPaiInterno.setText(conecta.rs.getString("PaiInternoCrc"));
                jAlcunha.setText(conecta.rs.getString("AlcunhaCrc"));
                jRGInterno.setText(conecta.rs.getString("RgInternoCrc"));
                jComboBoxUF.setSelectedItem(conecta.rs.getString("UfRG"));
                jCPFInterno.setText(conecta.rs.getString("CpfInternoCrc"));
                jCartaoSus.setText(conecta.rs.getString("CartaoSus"));
                // Capturando foto
                caminhoFotoInternoTRIAGEM = conecta.rs.getString("FotoInternoCrc");
                if (caminhoFotoInternoTRIAGEM != null) {
                    javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminhoFotoInternoTRIAGEM);
                    jLabelFotoInterno.setIcon(i);
                    jLabelFotoInterno.setIcon(new ImageIcon(i.getImage().getScaledInstance(jLabelFotoInterno.getWidth(), jLabelFotoInterno.getHeight(), Image.SCALE_SMOOTH)));
                }
                // BUSCAR A FOTO DO BANCO DE DADOS - FOTO FRENTE
                byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrente"));
                if (imgBytes != null) {
                    ImageIcon pic = null;
                    pic = new ImageIcon(imgBytes);
                    Image scaled = pic.getImage().getScaledInstance(jLabelFotoInterno.getWidth(), jLabelFotoInterno.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon icon = new ImageIcon(scaled);
                    jLabelFotoInterno.setIcon(icon);
                }
                //
                jComboBoxEscolaridade.setSelectedItem(conecta.rs.getString("EscolaridadeCrc"));
                jComboBoxEstadoCivil.setSelectedItem(conecta.rs.getString("EstadoCivilCrc"));
                jComboBoxSexo.setSelectedItem(conecta.rs.getString("SexoCrc"));
                jSituacao.setText(conecta.rs.getString("SituacaoCrc"));
                jComboBoxPais.setText(conecta.rs.getString("NomePais"));
                jComboBoxCidade.setText(conecta.rs.getString("NomeCidade"));
                jReligiao.setText(conecta.rs.getString("ReligiaoCrc"));
                jProfissao.setText(conecta.rs.getString("ProfissaoCrc"));
                jEndereco.setText(conecta.rs.getString("EnderecoCrc"));
                jBairro.setText(conecta.rs.getString("BairroCrc"));
                jCidade.setText(conecta.rs.getString("CidadeCrc"));
                jEstado.setText(conecta.rs.getString("EstadoCrc"));
                jCNC.setText(conecta.rs.getString("Cnc"));
                // Tabela Dados Fisicos
                jComboBoxCutis.setSelectedItem(conecta.rs.getString("Cutis"));
                jComboBoxOlhos.setSelectedItem(conecta.rs.getString("Olhos"));
                jComboBoxCabelos.setSelectedItem(conecta.rs.getString("Cabelos"));
                jComboBoxBarba.setSelectedItem(conecta.rs.getString("Barba"));
                jComboBoxBigode.setSelectedItem(conecta.rs.getString("Bigode"));
                jComboBoxNariz.setSelectedItem(conecta.rs.getString("Nariz"));
                jComboBoxBoca.setSelectedItem(conecta.rs.getString("Boca"));
                jComboBoxRosto.setSelectedItem(conecta.rs.getString("Rosto"));
                jComboBoxLabios.setSelectedItem(conecta.rs.getString("Labios"));
                jCamisa.setText(conecta.rs.getString("Camisa"));
                jCalca.setText(conecta.rs.getString("Calca"));
                jSapato.setText(conecta.rs.getString("Sapato"));
                jPeso.setText(conecta.rs.getString("Peso"));
                jAltura.setText(conecta.rs.getString("Altura"));
                jParticularidade.setText(conecta.rs.getString("Sinais"));
                jComboBoxOrelha.setSelectedItem(conecta.rs.getString("Orelhas"));
                jComboBoxPescoco.setSelectedItem(conecta.rs.getString("Pescoco"));
                jComboBoxCompleicao.setSelectedItem(conecta.rs.getString("Compleicao"));
                // Tabela Dados Penais
                jDataEntrada.setDate(conecta.rs.getDate("DataEntrada"));
                jComboBoxUnid.setText(conecta.rs.getString("DescricaoUnid"));
                jDataCrime.setDate(conecta.rs.getDate("DataCrime"));
                jDataPrisao.setDate(conecta.rs.getDate("DataPrisao"));
                jDataCondenacao.setDate(conecta.rs.getDate("DataCondenacao"));
                jComboBoxParticipacao.setSelectedItem(conecta.rs.getString("Participacao"));
                jComboBoxRegime.setSelectedItem(conecta.rs.getString("Regime"));
                jPena.setText(conecta.rs.getString("Pena"));
                jArtigo1.setText(conecta.rs.getString("Artigo1"));
                jArtigo2.setText(conecta.rs.getString("Artigo2"));
                jArtigo3.setText(conecta.rs.getString("Artigo3"));
                jParagrafo1.setText(conecta.rs.getString("Paragrafo1"));
                jParagrafo2.setText(conecta.rs.getString("Paragrafo2"));
                jParagrafo3.setText(conecta.rs.getString("Paragrafo3"));
                jComboBoxEdiondo.setSelectedItem(conecta.rs.getString("CrimeEdiondo"));
                jDataTerPena.setDate(conecta.rs.getDate("TerminoPena"));
                jVaraCondenacao.setText(conecta.rs.getString("VaraCondenatoria"));
                jDataNovaEntrada.setDate(conecta.rs.getDate("DataNovaEntrada"));
                caminhoFotoPerfil = conecta.rs.getString("FotoPerfil");
                // Fotos Perfil e Corpo
                if (caminhoFotoPerfil != null) {
                    javax.swing.ImageIcon w = new javax.swing.ImageIcon(caminhoFotoPerfil);
                    jFotoPerfil.setIcon(w);
                    jFotoPerfil.setIcon(new ImageIcon(w.getImage().getScaledInstance(jFotoPerfil.getWidth(), jFotoPerfil.getHeight(), Image.SCALE_SMOOTH)));
                }
                caminhoFotoCorpo = conecta.rs.getString("FotoCorpo");
                if (caminhoFotoCorpo != null) {
                    javax.swing.ImageIcon y = new javax.swing.ImageIcon(caminhoFotoCorpo);
                    jFotoCorpo.setIcon(y);
                    jFotoCorpo.setIcon(new ImageIcon(y.getImage().getScaledInstance(jFotoCorpo.getWidth(), jFotoCorpo.getHeight(), Image.SCALE_SMOOTH)));
                }
                caminhoFotoCorpo1 = conecta.rs.getString("FotoCorpo1");
                if (caminhoFotoCorpo1 != null) {
                    javax.swing.ImageIcon z = new javax.swing.ImageIcon(caminhoFotoCorpo1);
                    jFotoCorpo1.setIcon(z);
                    jFotoCorpo1.setIcon(new ImageIcon(z.getImage().getScaledInstance(jFotoCorpo1.getWidth(), jFotoCorpo1.getHeight(), Image.SCALE_SMOOTH)));
                }
                caminhoFotoCorpo2 = conecta.rs.getString("FotoCorpo2");
                if (caminhoFotoCorpo2 != null) {
                    javax.swing.ImageIcon t = new javax.swing.ImageIcon(caminhoFotoCorpo2);
                    jFotoCorpo2.setIcon(t);
                    jFotoCorpo2.setIcon(new ImageIcon(t.getImage().getScaledInstance(jFotoCorpo2.getWidth(), jFotoCorpo2.getHeight(), Image.SCALE_SMOOTH)));
                }
                // BUSCAR A FOTO DO BANCO DE DADOS - FOTO PERFIL
                byte[] imgPerfilBytes = ((byte[]) conecta.rs.getBytes("ImagemPerfil"));
                if (imgPerfilBytes != null) {
                    ImageIcon picPerf = null;
                    picPerf = new ImageIcon(imgPerfilBytes);
                    Image scaledp = picPerf.getImage().getScaledInstance(jFotoPerfil.getWidth(), jFotoPerfil.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon iconPerf = new ImageIcon(scaledp);
                    jFotoPerfil.setIcon(iconPerf);
                }
                // BUSCAR A FOTO DO BANCO DE DADOS - FOTO CORPO
                byte[] imgCorpoBytes = ((byte[]) conecta.rs.getBytes("ImagemCorpo"));
                if (imgCorpoBytes != null) {
                    ImageIcon picCorpo = null;
                    picCorpo = new ImageIcon(imgCorpoBytes);
                    Image scaled0 = picCorpo.getImage().getScaledInstance(jFotoCorpo.getWidth(), jFotoCorpo.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon iconCorpo = new ImageIcon(scaled0);
                    jFotoCorpo.setIcon(iconCorpo);
                }
                // BUSCAR A FOTO DO BANCO DE DADOS - FOTO CORPO1
                byte[] imgCorpo1Bytes = ((byte[]) conecta.rs.getBytes("ImagemCorpo1"));
                if (imgCorpo1Bytes != null) {
                    ImageIcon picCorpo1 = null;
                    picCorpo1 = new ImageIcon(imgCorpo1Bytes);
                    Image scaled1 = picCorpo1.getImage().getScaledInstance(jFotoCorpo1.getWidth(), jFotoCorpo1.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon iconCorpo1 = new ImageIcon(scaled1);
                    jFotoCorpo1.setIcon(iconCorpo1);
                }
                // BUSCAR A FOTO DO BANCO DE DADOS - FOTO CORPO2
                byte[] imgCorpo2Bytes = ((byte[]) conecta.rs.getBytes("ImagemCorpo2"));
                if (imgCorpo2Bytes != null) {
                    ImageIcon picCorpo2 = null;
                    picCorpo2 = new ImageIcon(imgCorpo2Bytes);
                    Image scaled2 = picCorpo2.getImage().getScaledInstance(jFotoCorpo2.getWidth(), jFotoCorpo2.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon iconCorpo2 = new ImageIcon(scaled2);
                    jFotoCorpo2.setIcon(iconCorpo2);
                }
                //
                jIdentificador.setText(conecta.rs.getString("Identificador"));
                jIdentificador1.setText(conecta.rs.getString("Identificador1"));
                jIdentificador2.setText(conecta.rs.getString("Identificador2"));
                jIdentificador3.setText(conecta.rs.getString("Identificador3"));
                jPerfil.setText(conecta.rs.getString("Perfil"));
                jRegiaoCorpo.setText(conecta.rs.getString("RegiaoCorpo"));
                jRegiaoCorpo1.setText(conecta.rs.getString("RegiaoCorpo1"));
                jRegiaoCorpo2.setText(conecta.rs.getString("RegiaoCorpo2"));
                lerDigitaisCadastradas();
                conecta.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa dos dados." + e);
            }
        }
    }//GEN-LAST:event_jTabelaInternoMouseClicked

    private void jBtPesqPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqPaisActionPerformed
        // TODO add your handling code here:
        //    buscarNacionalidade("SELECT * FROM PAISES WHERE NomePais LIKE'" + jPesNomePais.getText() + "%'");       
        TelaPesquisaPaisTriagem objPaises = new TelaPesquisaPaisTriagem();
        TelaModuloTriagem.jPainelTriagem.add(objPaises);
        objPaises.show();

    }//GEN-LAST:event_jBtPesqPaisActionPerformed

    private void jBtNovaFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovaFotoActionPerformed
        // TODO add your handling code here:
        // Incluir Foto
        JFileChooser chooser = new JFileChooser();
        int acao = chooser.showOpenDialog(this);
        if (acao == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            caminhoFotoInternoTRIAGEM = f.getAbsolutePath();
            ImageIcon imagemicon = new ImageIcon(new ImageIcon(caminhoFotoInternoTRIAGEM).getImage().getScaledInstance(jLabelFotoInterno.getWidth(), jLabelFotoInterno.getHeight(), Image.SCALE_SMOOTH));
            jLabelFotoInterno.setIcon(imagemicon);
            try {
                File image = new File(caminhoFotoInternoTRIAGEM);
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
    }//GEN-LAST:event_jBtNovaFotoActionPerformed

    private void jBtExcluirFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirFotoActionPerformed
        // TODO add your handling code here:
        // Excluir Foto
        jLabelFotoInterno.setIcon(null);
    }//GEN-LAST:event_jBtExcluirFotoActionPerformed

    private void jBtPesqCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqCidadeActionPerformed
        // TODO add your handling code here:
        TelaPesquisaCidadeTriagem objCidaC = new TelaPesquisaCidadeTriagem();
        TelaModuloTriagem.jPainelTriagem.add(objCidaC);
        objCidaC.show();
    }//GEN-LAST:event_jBtPesqCidadeActionPerformed

    private void jBtPesqUnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqUnidadeActionPerformed
        // TODO add your handling code here:
        TelaPesquisaUnidadeTriagem objUnidPenal2 = new TelaPesquisaUnidadeTriagem();
        TelaModuloTriagem.jPainelTriagem.add(objUnidPenal2);
        objUnidPenal2.show();
    }//GEN-LAST:event_jBtPesqUnidadeActionPerformed

    private void jBtNovaFotoPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovaFotoPerfilActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        int acao = chooser.showOpenDialog(this);
        if (acao == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            caminhoFotoPerfil = f.getAbsolutePath();
            ImageIcon imagemicon = new ImageIcon(new ImageIcon(caminhoFotoPerfil).getImage().getScaledInstance(jFotoPerfil.getWidth(), jFotoPerfil.getHeight(), Image.SCALE_SMOOTH));
            jFotoPerfil.setIcon(imagemicon);
            try {
                File image = new File(caminhoFotoPerfil);
                FileInputStream fis = new FileInputStream(image);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                for (int readNum; (readNum = fis.read(buf)) != -1;) {
                    bos.write(buf, 0, readNum);
                }
                persona_imagem1 = bos.toByteArray();
            } catch (Exception e) {
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Seleção da figura cancelada.");
        }
    }//GEN-LAST:event_jBtNovaFotoPerfilActionPerformed

    private void jBtExcluirFotoPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirFotoPerfilActionPerformed
        // TODO add your handling code here:
        jFotoPerfil.setIcon(null);
        caminhoFotoPerfil = "vazio";
    }//GEN-LAST:event_jBtExcluirFotoPerfilActionPerformed

    private void jBtNovaFotoCorpoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovaFotoCorpoActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        int acao = chooser.showOpenDialog(this);
        if (acao == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            caminhoFotoCorpo = f.getAbsolutePath();
            ImageIcon imagemicon = new ImageIcon(new ImageIcon(caminhoFotoCorpo).getImage().getScaledInstance(jFotoCorpo.getWidth(), jFotoCorpo.getHeight(), Image.SCALE_SMOOTH));
            jFotoCorpo.setIcon(imagemicon);
            try {
                File image = new File(caminhoFotoCorpo);
                FileInputStream fis = new FileInputStream(image);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                for (int readNum; (readNum = fis.read(buf)) != -1;) {
                    bos.write(buf, 0, readNum);
                }
                persona_imagem2 = bos.toByteArray();
            } catch (Exception e) {
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Seleção da figura cancelada.");
        }
    }//GEN-LAST:event_jBtNovaFotoCorpoActionPerformed

    private void jBtExcluirFotoCorpoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirFotoCorpoActionPerformed
        // TODO add your handling code here:
        jFotoCorpo.setIcon(null);
        caminhoFotoCorpo = "vazio";
    }//GEN-LAST:event_jBtExcluirFotoCorpoActionPerformed

    private void jBtNovaFotoCorpo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovaFotoCorpo1ActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        int acao = chooser.showOpenDialog(this);
        if (acao == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            caminhoFotoCorpo1 = f.getAbsolutePath();
            ImageIcon imagemicon = new ImageIcon(new ImageIcon(caminhoFotoCorpo1).getImage().getScaledInstance(jFotoCorpo1.getWidth(), jFotoCorpo1.getHeight(), Image.SCALE_SMOOTH));
            jFotoCorpo1.setIcon(imagemicon);
            try {
                File image = new File(caminhoFotoCorpo1);
                FileInputStream fis = new FileInputStream(image);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                for (int readNum; (readNum = fis.read(buf)) != -1;) {
                    bos.write(buf, 0, readNum);
                }
                persona_imagem3 = bos.toByteArray();
            } catch (Exception e) {
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Seleção da figura cancelada.");
        }
    }//GEN-LAST:event_jBtNovaFotoCorpo1ActionPerformed

    private void jBtExcluirFotoCorpo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirFotoCorpo1ActionPerformed
        // TODO add your handling code here:
        jFotoCorpo1.setIcon(null);
        caminhoFotoCorpo1 = "vazio";
    }//GEN-LAST:event_jBtExcluirFotoCorpo1ActionPerformed

    private void jBtNovaFotoCorpo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovaFotoCorpo2ActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        int acao = chooser.showOpenDialog(this);
        if (acao == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            caminhoFotoCorpo2 = f.getAbsolutePath();
            ImageIcon imagemicon = new ImageIcon(new ImageIcon(caminhoFotoCorpo2).getImage().getScaledInstance(jFotoCorpo2.getWidth(), jFotoCorpo2.getHeight(), Image.SCALE_SMOOTH));
            jFotoCorpo2.setIcon(imagemicon);
            try {
                File image = new File(caminhoFotoCorpo2);
                FileInputStream fis = new FileInputStream(image);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                for (int readNum; (readNum = fis.read(buf)) != -1;) {
                    bos.write(buf, 0, readNum);
                }
                persona_imagem4 = bos.toByteArray();
            } catch (Exception e) {
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Seleção da figura cancelada.");
        }
    }//GEN-LAST:event_jBtNovaFotoCorpo2ActionPerformed

    private void jBtExcluirCorpo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirCorpo2ActionPerformed
        // TODO add your handling code here:
        jFotoCorpo2.setIcon(null);
        caminhoFotoCorpo2 = "vazio";
    }//GEN-LAST:event_jBtExcluirCorpo2ActionPerformed

    private void jBtImpressaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImpressaoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCadastroProntuarioPrintTRI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTRI.equals("ADMINISTRADORES") || codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaCadastroProntuarioPrintTRI) && codAbrirTRI == 1) {
            if (jIdInterno.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Não é possível listar o relatório, pois, o interno não código.");
            } else {
                try {
                    conecta.abrirConexao();
                    String path = "reports/Diretoria/ProntuariosInternosCrcCodigo.jasper";
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
                            + "WHERE PRONTUARIOSCRC.IdInternoCrc='" + jIdInterno.getText() + "'");
                    HashMap parametros = new HashMap();
                    parametros.put("MatriculaCrc", jMatriculaPenal.getText());
                    parametros.put("nomeUsuario", nameUser);
                    parametros.put("descricaoUnidade", descricaoUnidade);
                    JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
                    JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
                    JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
                    jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
                    jv.setTitle("Relatório de Prontuário de Internos");
                    jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
                    jv.toFront(); // Traz o relatorio para frente da aplicação            
                    conecta.desconecta();
                } catch (JRException e) {
                    JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado.");
        }
    }//GEN-LAST:event_jBtImpressaoActionPerformed

    private void jBtPesqCidadeEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqCidadeEndActionPerformed
        // TODO add your handling code here:
        TelaPesquisaCidadesEndTri objPesqCidaEndTri = new TelaPesquisaCidadesEndTri();
        TelaModuloTriagem.jPainelTriagem.add(objPesqCidaEndTri);
        objPesqCidaEndTri.show();
    }//GEN-LAST:event_jBtPesqCidadeEndActionPerformed

    private void jBtAuditoriaPronCrcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaPronCrcActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaProntuarioInternoTriagem objAudPronTri = new TelaAuditoriaProntuarioInternoTriagem();
        TelaModuloTriagem.jPainelTriagem.add(objAudPronTri);
        objAudPronTri.show();
    }//GEN-LAST:event_jBtAuditoriaPronCrcActionPerformed

    private void jBtWebCamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtWebCamActionPerformed
        // TODO add your handling code here: 
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        mostrarWebCamFotoInternoTRI();
    }//GEN-LAST:event_jBtWebCamActionPerformed

    private void jBtObservacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtObservacaoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCadastroProntuarioObsTRI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTRI.equals("ADMINISTRADORES") || codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaCadastroProntuarioObsTRI) && codAbrirTRI == 1) {
            TelaObservacoesInternos objObsInt = new TelaObservacoesInternos();
            TelaModuloCRC.jPainelCRC.add(objObsInt);
            objObsInt.show();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado.");
        }
    }//GEN-LAST:event_jBtObservacaoActionPerformed

    private void jBtBuscarRegPortariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtBuscarRegPortariaActionPerformed
        // TODO add your handling code here:    
        buscarAcessoUsuario(telaCadastroProntuarioBuscarEntTRI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTRI.equals("ADMINISTRADORES") || codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaCadastroProntuarioBuscarEntTRI) && codAbrirTRI == 1) {
            TelaPesqEntradaIntPortariaTriagem objPesqRegInternos = new TelaPesqEntradaIntPortariaTriagem();
            TelaModuloTriagem.jPainelTriagem.add(objPesqRegInternos);
            objPesqRegInternos.show();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado.");
        }
    }//GEN-LAST:event_jBtBuscarRegPortariaActionPerformed

    private void jBtZoonFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtZoonFotoActionPerformed
        // TODO add your handling code here:
        mostrarTelaFotoTriagem();
    }//GEN-LAST:event_jBtZoonFotoActionPerformed

    private void jBtNovo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovo1ActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCadastroProntuarioManuTRI);
        if (codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaCadastroProntuarioManuTRI) && codIncluirTRI == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTRI.equals("ADMINISTRADORES")) {
            VERIFICAR_PARAMETROS_crc();
            acao = 1;
            Novo();
            corCampos();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado.");
        }
    }//GEN-LAST:event_jBtNovo1ActionPerformed

    private void jBtAlterar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterar1ActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCadastroProntuarioManuTRI);
        if (codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaCadastroProntuarioManuTRI) && codAlterarTRI == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTRI.equals("ADMINISTRADORES")) {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM PARAMETROSCRC WHERE UsuarioAutorizado='" + nameUser + "'");
                conecta.rs.first();
                usuarioAutorizado = conecta.rs.getString("UsuarioAutorizado");
            } catch (SQLException ex) {
            }
            VERIFICAR_PARAMETROS_crc();
            acao = 2;
            Alterar();
            corCampos();
            statusMov = "Alterou";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            if (nameUser == null ? nomeUsuarioCrc == null : nameUser.equals(nomeUsuarioCrc) || (nameUser == null ? usuarioAutorizado == null : nameUser.equals(usuarioAutorizado))) {
                jSituacao.setEnabled(true);
            }
            conecta.desconecta();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado.");
        }
    }//GEN-LAST:event_jBtAlterar1ActionPerformed

    private void jBtExcluir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluir1ActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCadastroProntuarioManuTRI);
        if (codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaCadastroProntuarioManuTRI) && codExcluirTRI == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTRI.equals("ADMINISTRADORES")) {
            pVERIFICAR_ENTRADA_internos();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado.");
        }
    }//GEN-LAST:event_jBtExcluir1ActionPerformed

    private void jBtSalvar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvar1ActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCadastroProntuarioManuTRI);
        if (codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaCadastroProntuarioManuTRI) && codGravarTRI == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTRI.equals("ADMINISTRADORES")) {
            if (jNomeInterno.getText().isEmpty() || jNomeInterno.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Nome do INTERNO não pode ser em branco...");
                jNomeInterno.requestFocus();
            } else if (jMaeInterno.getText().isEmpty() || jMaeInterno.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Nome da MÃE do INTERNO não pode ser em branco...");
                jMaeInterno.requestFocus();
            } else if (jPaiInterno.getText().isEmpty() || jPaiInterno.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Nome do PAI do INTERNO não pode ser em branco...");
                jPaiInterno.requestFocus();
            } else if (jComboBoxSexo.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o sexo do interno(a).");
                jComboBoxSexo.requestFocus();
            } else if (caminhoFotoInternoTRIAGEM == null) {
                JOptionPane.showMessageDialog(rootPane, "FOTO do INTERNO não pode ser em branco...");
            } else if (jDataNascimento.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "DATA NASCIMENTO não pode ser em branco");
                jDataCadastro.requestFocus();
            } else if (jDataEntrada.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "DATA ENTRADA não pode ser em branco");
                jDataEntrada.requestFocus();
            } else if (jDataCrime.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "DATA CRIME não pode ser em branco");
                jDataCrime.requestFocus();
            } else if (jDataPrisao.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "DATA PRISÃO não pode ser em branco");
                jDataPrisao.requestFocus();
            } else if (jDataCondenacao.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "DATA CONDENAÇÃO não pode ser em branco");
                jDataCondenacao.requestFocus();
            } else if (jComboBoxUnid.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe a unidade penal");
                jComboBoxUnid.requestFocus();
                jComboBoxUnid.setBackground(Color.red);
            } else if (jComboBoxPais.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome do Paíes");
                jComboBoxPais.requestFocus();
                jComboBoxPais.setBackground(Color.red);
            } else if (jComboBoxCidade.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome da Cidade");
                jComboBoxCidade.requestFocus();
                jComboBoxCidade.setBackground(Color.red);
            } else if (jComboBoxEscolaridade.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o grau de instrução do interno.");
                jComboBoxEscolaridade.requestFocus();
                jComboBoxEscolaridade.setBackground(Color.red);
            } else {
                if (ValidaCPF.isCPF(jCPFInterno.getText()) == true) {
                    objProCrc.setMatricula(jMatriculaPenal.getText());
                    objProCrc.setDataCadast(jDataCadastro.getDate());
                    objProCrc.setDataNasci(jDataNascimento.getDate());
                    objProCrc.setNomeInterno(jNomeInterno.getText());
                    objProCrc.setMaeInterno(jMaeInterno.getText());
                    objProCrc.setPaiInterno(jPaiInterno.getText());
                    objProCrc.setAlcunha(jAlcunha.getText());
                    objProCrc.setRgInterno(jRGInterno.getText());
                    objProCrc.setuFRg((String) jComboBoxUF.getSelectedItem());
                    objProCrc.setCpfInterno(jCPFInterno.getText());
                    objProCrc.setCartoaSus(jCartaoSus.getText());
                    objProCrc.setFotoInterno(caminhoFotoInternoTRIAGEM);
                    objProCrc.setEscolaridade((String) jComboBoxEscolaridade.getSelectedItem());
                    objProCrc.setEstadoCivil((String) jComboBoxEstadoCivil.getSelectedItem());
                    objProCrc.setSexo((String) jComboBoxSexo.getSelectedItem());
                    objProCrc.setSituacao(jSituacao.getText());
                    objProCrc.setNomePais(jComboBoxPais.getText());
                    objProCrc.setNomeCidade(jComboBoxCidade.getText());
                    objProCrc.setReligiao(jReligiao.getText());
                    objProCrc.setProfissao(jProfissao.getText());
                    objProCrc.setEndereco(jEndereco.getText());
                    objProCrc.setBairro(jBairro.getText());
                    objProCrc.setCidade(jCidade.getText());
                    objProCrc.setEstado(jEstado.getText());
                    objProCrc.setTelefone(jTelefone.getText());
                    objProCrc.setTelefone1(jTelefone1.getText());
                    objProCrc.setCelular(jCelular.getText());
                    objProCrc.setCnc(jCNC.getText());
                    // Classe Dados Fisicos
                    objDadosFis.setCutis((String) jComboBoxCutis.getSelectedItem());
                    objDadosFis.setOlhos((String) jComboBoxOlhos.getSelectedItem());
                    objDadosFis.setCabelos((String) jComboBoxCabelos.getSelectedItem());
                    objDadosFis.setBarba((String) jComboBoxBarba.getSelectedItem());
                    objDadosFis.setBigode((String) jComboBoxBigode.getSelectedItem());
                    objDadosFis.setNariz((String) jComboBoxNariz.getSelectedItem());
                    objDadosFis.setBoca((String) jComboBoxBoca.getSelectedItem());
                    objDadosFis.setRosto((String) jComboBoxRosto.getSelectedItem());
                    objDadosFis.setLabios((String) jComboBoxLabios.getSelectedItem());
                    objDadosFis.setCamisa(jCamisa.getText());
                    objDadosFis.setCalca(jCalca.getText());
                    objDadosFis.setSapato(jSapato.getText());
                    objDadosFis.setPeso(jPeso.getText());
                    objDadosFis.setAltura(jAltura.getText());
                    objDadosFis.setSinais(jParticularidade.getText());
                    objDadosFis.setOrelha((String) jComboBoxOrelha.getSelectedItem());
                    objDadosFis.setPescoco((String) jComboBoxPescoco.getSelectedItem());
                    objDadosFis.setCompleicao((String) jComboBoxCompleicao.getSelectedItem());
                    // Dados Penais
                    objDadosPena.setDataEntrada(jDataEntrada.getDate());
                    objDadosPena.setNomeUnidade(jComboBoxUnid.getText());
                    objDadosPena.setDataCrime(jDataCrime.getDate());
                    objDadosPena.setDataPrisao(jDataPrisao.getDate());
                    objDadosPena.setDataCondenacao(jDataCondenacao.getDate());
                    objDadosPena.setParticipacao((String) jComboBoxParticipacao.getSelectedItem());
                    objDadosPena.setRegime((String) jComboBoxRegime.getSelectedItem());
                    objDadosPena.setPena(jPena.getText());
                    objDadosPena.setArtigo1(jArtigo1.getText());
                    objDadosPena.setArtigo2(jArtigo2.getText());
                    objDadosPena.setArtigo3(jArtigo3.getText());
                    objDadosPena.setParagrafo1(jParagrafo1.getText());
                    objDadosPena.setParagrafo2(jParagrafo2.getText());
                    objDadosPena.setParagrafo3(jParagrafo3.getText());
                    objDadosPena.setCrimeEdiondo((String) jComboBoxEdiondo.getSelectedItem());
                    objDadosPena.setTerminoPena(jDataTerPena.getDate());
                    objDadosPena.setIdentificador(jIdentificador.getText());
                    objDadosPena.setIdentificador1(jIdentificador1.getText());
                    objDadosPena.setIdentificador2(jIdentificador2.getText());
                    objDadosPena.setIdentificador3(jIdentificador3.getText());
                    objDadosPena.setPerfil(jPerfil.getText());
                    objDadosPena.setRegiaoCorpo(jRegiaoCorpo.getText());
                    objDadosPena.setRegiaoCorpo1(jRegiaoCorpo1.getText());
                    objDadosPena.setRegiaoCorpo2(jRegiaoCorpo2.getText());
                    objDadosPena.setFotoPerfil(caminhoFotoPerfil);
                    objDadosPena.setFotoCorpo(caminhoFotoCorpo);
                    objDadosPena.setFotoCorpo1(caminhoFotoCorpo1);
                    objDadosPena.setFotoCorpo2(caminhoFotoCorpo2);
                    objDadosPena.setVaraCondenatoria(jVaraCondenacao.getText());
                    objDadosPena.setDataNovaEntrada(jDataNovaEntrada.getDate());
                    objProCrc.setUsuarioInsert(nameUser);
                    objProCrc.setDataInsert(jDataSistema.getText());
                    objProCrc.setHoraInsert(jHoraSistema.getText());
                    // PREPARAR FOTO PARA GRAVAR NO BANCO DE DADOS - FOTO DE FRENTE 
                    if (jLabelFotoInterno.getIcon() != null) {//                                                                   
                        objProCrc.setImagemInterno(persona_imagem);
                    }
                    // PREPARAR FOTO PARA GRAVAR NO BANCO DE DADOS FOTO DE PERFIL
                    if (jFotoPerfil.getIcon() != null) {//                                                                
                        objDadosPena.setImagemPerfil(persona_imagem1);
                    }
                    // PREPARAR FOTO PARA GRAVAR NO BANCO DE DADOS FOTO DE PERFIL - FOTO CORPO
                    if (jFotoCorpo.getIcon() != null) {
                        objDadosPena.setImagemCorpo(persona_imagem2);
                    }
                    // PREPARAR FOTO PARA GRAVAR NO BANCO DE DADOS FOTO DE PERFIL - FOTO CORPO1
                    if (jFotoCorpo1.getIcon() != null) {//                                                                  
                        objDadosPena.setImagemCorpo1(persona_imagem3);
                    }
                    // PREPARAR FOTO PARA GRAVAR NO BANCO DE DADOS FOTO DE PERFIL - FOTO CORPO2
                    if (jFotoCorpo2.getIcon() != null) {//                                                                    
                        objDadosPena.setImagemCorpo2(persona_imagem4);
                    }
                    //VERIFICAR SE O INTERNO JÁ EXISTE PARA NÃO CADASTRAR EM DUPLICIDADE
                    PESQUISAR_EXISTENCIA_interno();
                    if (acao == 1) {
                        if (jNomeInterno.getText().trim().equals(nomeInternoCrc) && jMaeInterno.getText().trim().equals(nomeMaeInterno)) {
                            JOptionPane.showMessageDialog(rootPane, "Esse Interno já foi cadastrado.");
                            conecta.desconecta();
                        } else {
                            //GRAVA NA TABELA PRONTUARIOSCRC
                            CONTROLE_DADOS_civil.incluirInternoCrc(objProCrc);
                            BUSCAR_CODIGO_interno();
                            // TABELA NA TABELA DADOSFISICOSINTERNOS
                            objDadosFis.setNomeInternoCrc(jNomeInterno.getText());
                            objDadosFis.setNomeMaeInternoCrc(jMaeInterno.getText());
                            CONTROLE_DADOS_fisicos.incluirDadosFisicos(objDadosFis);
                            // GRAVA NA TABELA DADOSPENAISINTERNOS
                            objDadosPena.setNomeInternoCrc(jNomeInterno.getText());
                            objDadosPena.setNomeMaeInternoCrc(jMaeInterno.getText());
                            CONTROLE_DADOS_penais.incluirDadosPenais(objDadosPena);
                            // VERIFICAR SE O INTERNO FOI GRAVADO NA TABELA DADOSPENAISINTERNOS COM SUCESSO
                            objProCrc.setIdInterno(Integer.valueOf(jIdInterno.getText()));
                            VERIFICAR_GRAVACAO_interno();
                            if (jIdInterno.getText().equals(CODIGO_INTERNO_TABELA_penal)
                                    && pRESPOSTA_gravacao.equals("Sim")
                                    && pRESPOSTA_DADOS_fisicos.equals("Sim")
                                    && pRESPOSTA_DADOS_penais.equals("Sim")) {
                                // Confirma a utilização do registro do interno iniciado pela portaria.
                                objProCrc.setNomeInterno(jNomeInterno.getText());
                                objProCrc.setConfirmaEntrada(confirmaEntrada);
                                CONTROLE_DADOS_civil.confirmarRegInternoCrc(objProCrc);
                                //
                                objLog();
                                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                                Salvar();
                            } else {
                                //SE O REGISTRO NÃO FOI INCLUÍDO NAS 03(TRÊS) TABELAS CORRETAMENTE, APAGA O REGISTRO NAS OUTRAS
                                DELETAR_REGISTRO_interno();
                                if (pRESPOSTA_EXCLUSÃO_fisicos.equals("Sim") && pRESPOSTA_EXCLUSÃO_prontuario.equals("Sim")) {
                                    JOptionPane.showMessageDialog(rootPane, "Não foi possível concluir a gravação do registro, por favor tente novamente.");
                                } else {
                                    JOptionPane.showMessageDialog(rootPane, "Existem residuos do cadastro do interno, será necessário realizar uma limpeza diretamente no banco de dados.\nCaso não seja realizado a limpeza direto no banco de dados, não será possível registrar esse interno.");
                                }
                            }
                        }
                    }
                    if (acao == 2) {
                        try {
                            objProCrc.setUsuarioUp(nameUser);
                            objProCrc.setDataUp(jDataSistema.getText());
                            objProCrc.setHoraUp(jHoraSistema.getText());
                            objProCrc.setIdInterno(Integer.parseInt(jIdInterno.getText()));
                            objDadosFis.setIdInternoCrc(Integer.parseInt(jIdInterno.getText()));
                            objDadosPena.setIdInternoCrc(Integer.parseInt(jIdInterno.getText()));
                            CONTROLE_DADOS_civil.alterarInternoCrc(objProCrc);
                            CONTROLE_DADOS_fisicos.alterarDadosFisicos(objDadosFis);
                            CONTROLE_DADOS_penais.alterarDadosPenais(objDadosPena);
                            objLog();
                            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação          
                            JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso...");
                            Salvar();
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(rootPane, "Não foi possível alterar o registro.\nERRO: " + e);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "CPF invalido !!!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado.");
        }
    }//GEN-LAST:event_jBtSalvar1ActionPerformed

    private void jBtCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelar1ActionPerformed
        // TODO add your handling code here:
        Cancelar();
    }//GEN-LAST:event_jBtCancelar1ActionPerformed

    private void jBtSair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSair1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSair1ActionPerformed

    private void jBtImpressao1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImpressao1ActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCadastroProntuarioPrintTRI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTRI.equals("ADMINISTRADORES") || codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaCadastroProntuarioPrintTRI) && codAbrirTRI == 1) {
            if (jIdInterno.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Não é possível listar o relatório, pois, o interno não código.");
            } else {
                try {
                    conecta.abrirConexao();
                    String path = "reports/Diretoria/ProntuariosInternosCrcCodigo.jasper";
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
                            + "WHERE PRONTUARIOSCRC.IdInternoCrc='" + jIdInterno.getText() + "'");
                    HashMap parametros = new HashMap();
                    parametros.put("MatriculaCrc", jMatriculaPenal.getText());
                    parametros.put("nomeUsuario", nameUser);
                    parametros.put("descricaoUnidade", descricaoUnidade);
                    JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
                    JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
                    JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
                    jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
                    jv.setTitle("Relatório de Prontuário de Internos");
                    jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
                    jv.toFront(); // Traz o relatorio para frente da aplicação            
                    conecta.desconecta();
                } catch (JRException e) {
                    JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado.");
        }
    }//GEN-LAST:event_jBtImpressao1ActionPerformed

    private void jBtAuditoriaPronCrc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaPronCrc1ActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaProntuarioInternoCrc objAudProInternoCrc = new TelaAuditoriaProntuarioInternoCrc();
        TelaModuloCRC.jPainelCRC.add(objAudProInternoCrc);
        objAudProInternoCrc.show();
    }//GEN-LAST:event_jBtAuditoriaPronCrc1ActionPerformed

    private void jBtObservacao1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtObservacao1ActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCadastroProntuarioObsTRI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTRI.equals("ADMINISTRADORES") || codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaCadastroProntuarioObsTRI) && codAbrirTRI == 1) {
            TelaObservacoesInternos objObsInt = new TelaObservacoesInternos();
            TelaModuloCRC.jPainelCRC.add(objObsInt);
            objObsInt.show();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado.");
        }
    }//GEN-LAST:event_jBtObservacao1ActionPerformed

    private void jBtBuscarRegPortaria1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtBuscarRegPortaria1ActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCadastroProntuarioBuscarEntTRI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTRI.equals("ADMINISTRADORES") || codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaCadastroProntuarioBuscarEntTRI) && codAbrirTRI == 1) {
            TelaPesqEntradaIntPortariaTriagem objPesqRegInternos = new TelaPesqEntradaIntPortariaTriagem();
            TelaModuloTriagem.jPainelTriagem.add(objPesqRegInternos);
            objPesqRegInternos.show();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado.");
        }
    }//GEN-LAST:event_jBtBuscarRegPortaria1ActionPerformed

    private void jBtPeculiaridadeFrenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPeculiaridadeFrenteActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCadastroProntuarioPecFreTRI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTRI.equals("ADMINISTRADORES") || codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaCadastroProntuarioPecFreTRI) && codAbrirTRI == 1) {
            mostrarTelaPeculiaridadeFrenteTriagem();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado.");
        }
    }//GEN-LAST:event_jBtPeculiaridadeFrenteActionPerformed

    private void jBtPeculiaridadeCostasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPeculiaridadeCostasActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCadastroProntuarioPecCosTRI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTRI.equals("ADMINISTRADORES") || codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaCadastroProntuarioPecCosTRI) && codAbrirTRI == 1) {
            mostrarTelaPeculiaridadeCostasTriagem();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado.");
        }
    }//GEN-LAST:event_jBtPeculiaridadeCostasActionPerformed

    private void jBtBiometriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtBiometriaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCadastroProntuarioBioTRI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTRI.equals("ADMINISTRADORES") || codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaCadastroProntuarioBioTRI) && codAbrirTRI == 1) {
            mostrarTelaBiometriaInterno();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado.");
        }
    }//GEN-LAST:event_jBtBiometriaActionPerformed

    private void jBtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNomeActionPerformed
        // Pesquisa de Interno por NOME
        count = 0;
        pSAIDA_TEMP = 0;
        pSAIDA_COVID = 0;
        pATIVOS_ENTRADA = 0;
        pATIVOS_RETORNO = 0;
        pTOTAL_ATIVOS = 0;
        flag = 1;
        if (jPesqNome.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe NOME para pesquisa!!!");
            jPesqNome.requestFocus();
        } else {
            PREENCHER_TABELA_nome("SELECT PRONTUARIOSCRC.IdInternoCrc, "
                    + "PRONTUARIOSCRC.NomeInternoCrc,PRONTUARIOSCRC.MatriculaCrc, "
                    + "PRONTUARIOSCRC.DataCadastCrc,DADOSPENAISINTERNOS.DataEntrada, "
                    + "PRONTUARIOSCRC.Cnc, "
                    + "PRONTUARIOSCRC.SituacaoCrc "
                    + "FROM PRONTUARIOSCRC "
                    + "INNER JOIN DADOSFISICOSINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSFISICOSINTERNOS.IdInternoCrc "
                    + "INNER JOIN PAISES "
                    + "ON PRONTUARIOSCRC.IdPais=PAISES.IdPais "
                    + "INNER JOIN CIDADES "
                    + "ON PRONTUARIOSCRC.IdCidade=CIDADES.IdCidade "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "INNER JOIN UNIDADE ON DADOSPENAISINTERNOS.IdUnid=UNIDADE.IdUnid "
                    + "WHERE NomeInternoCrc LIKE'%" + jPesqNome.getText() + "%'");
        }
    }//GEN-LAST:event_jBtNomeActionPerformed

    private void jBtMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtMatriculaActionPerformed
        // TODO add your handling code here:
        count = 0;
        pSAIDA_TEMP = 0;
        pSAIDA_COVID = 0;
        pATIVOS_ENTRADA = 0;
        pATIVOS_RETORNO = 0;
        pTOTAL_ATIVOS = 0;
        flag = 1;
        if (jPesqMatricula.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe MATRICULA para pesquisa!!!");
            jPesqMatricula.requestFocus();
        } else {
            PREENCHER_TABELA_INTERNOS_matricula("SELECT PRONTUARIOSCRC.IdInternoCrc, "
                    + "PRONTUARIOSCRC.NomeInternoCrc,PRONTUARIOSCRC.MatriculaCrc, "
                    + "PRONTUARIOSCRC.DataCadastCrc,DADOSPENAISINTERNOS.DataEntrada, "
                    + "PRONTUARIOSCRC.Cnc, "
                    + "PRONTUARIOSCRC.SituacaoCrc "
                    + "FROM PRONTUARIOSCRC "
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
                    + "WHERE MatriculaCrc LIKE'%" + jPesqMatricula.getText() + "%'");
        }
    }//GEN-LAST:event_jBtMatriculaActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        count = 0;
        pSAIDA_TEMP = 0;
        pSAIDA_COVID = 0;
        pATIVOS_ENTRADA = 0;
        pATIVOS_RETORNO = 0;
        pTOTAL_ATIVOS = 0;
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.PREENCHER_TODOS_internos("SELECT PRONTUARIOSCRC.IdInternoCrc, "
                    + "PRONTUARIOSCRC.NomeInternoCrc,PRONTUARIOSCRC.MatriculaCrc, "
                    + "PRONTUARIOSCRC.DataCadastCrc,DADOSPENAISINTERNOS.DataEntrada, "
                    + "PRONTUARIOSCRC.Cnc, "
                    + "PRONTUARIOSCRC.SituacaoCrc "
                    + "FROM PRONTUARIOSCRC "
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
                    + "ORDER BY PRONTUARIOSCRC.IdInternoCrc");
        } else {
            jtotalRegistros.setText("");
            jtotalRegistros.setText("");
            jtotalRegistrosTMP.setText("");
            jtotalRegistrosPDC.setText("");
            jtotalInternos_ATIVOS.setText("");
            limparTabelaProntuario();
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jBtPesqAlcunhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqAlcunhaActionPerformed
        // TODO add your handling code here:
        count = 0;
        pSAIDA_TEMP = 0;
        pSAIDA_COVID = 0;
        pATIVOS_ENTRADA = 0;
        pATIVOS_RETORNO = 0;
        pTOTAL_ATIVOS = 0;
        flag = 1;
        if (jPesqAlcunha.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe a alcunha para pesquisa.");
        } else {
            PREENCHER_TABELA_nome("SELECT PRONTUARIOSCRC.IdInternoCrc, "
                    + "PRONTUARIOSCRC.NomeInternoCrc,PRONTUARIOSCRC.MatriculaCrc, "
                    + "PRONTUARIOSCRC.DataCadastCrc,DADOSPENAISINTERNOS.DataEntrada, "
                    + "PRONTUARIOSCRC.Cnc, "
                    + "PRONTUARIOSCRC.SituacaoCrc "
                    + "FROM PRONTUARIOSCRC "
                    + "INNER JOIN DADOSFISICOSINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSFISICOSINTERNOS.IdInternoCrc "
                    + "INNER JOIN PAISES "
                    + "ON PRONTUARIOSCRC.IdPais=PAISES.IdPais "
                    + "INNER JOIN CIDADES "
                    + "ON PRONTUARIOSCRC.IdCidade=CIDADES.IdCidade "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "INNER JOIN UNIDADE ON DADOSPENAISINTERNOS.IdUnid=UNIDADE.IdUnid "
                    + "WHERE AlcunhaCrc LIKE'%" + jPesqAlcunha.getText() + "%'");
        }
    }//GEN-LAST:event_jBtPesqAlcunhaActionPerformed

    private void jBtPesqCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqCodigoActionPerformed
        // TODO add your handling code here:
        count = 0;
        pSAIDA_TEMP = 0;
        pSAIDA_COVID = 0;
        pATIVOS_ENTRADA = 0;
        pATIVOS_RETORNO = 0;
        pTOTAL_ATIVOS = 0;
        flag = 1;
        if (jPesqCodigo.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o código do interno para pesquisa.");
        } else {
            PREENCHER_TABELA_nome("SELECT PRONTUARIOSCRC.IdInternoCrc, "
                    + "PRONTUARIOSCRC.NomeInternoCrc,PRONTUARIOSCRC.MatriculaCrc, "
                    + "PRONTUARIOSCRC.DataCadastCrc,DADOSPENAISINTERNOS.DataEntrada, "
                    + "PRONTUARIOSCRC.Cnc, "
                    + "PRONTUARIOSCRC.SituacaoCrc "
                    + "FROM PRONTUARIOSCRC "
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
                    + "WHERE PRONTUARIOSCRC.IdInternoCrc='" + jPesqCodigo.getText() + "'");
        }
    }//GEN-LAST:event_jBtPesqCodigoActionPerformed

    private void jBtPesqSitucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqSitucaoActionPerformed
        // TODO add your handling code here:
        count = 0;
        pSAIDA_TEMP = 0;
        pSAIDA_COVID = 0;
        pATIVOS_ENTRADA = 0;
        pATIVOS_RETORNO = 0;
        pTOTAL_ATIVOS = 0;
        flag = 1;
        if (jComboBoxPesqSituacao.getSelectedItem().equals("Ativos")) {
            PREENCHER_TABELA_nome("SELECT PRONTUARIOSCRC.IdInternoCrc, "
                    + "PRONTUARIOSCRC.NomeInternoCrc,PRONTUARIOSCRC.MatriculaCrc, "
                    + "PRONTUARIOSCRC.DataCadastCrc,DADOSPENAISINTERNOS.DataEntrada, "
                    + "PRONTUARIOSCRC.Cnc, "
                    + "PRONTUARIOSCRC.SituacaoCrc "
                    + "FROM PRONTUARIOSCRC "
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
                    + "WHERE PRONTUARIOSCRC.SituacaoCrc='" + situacaoEnt + "' "
                    + "OR PRONTUARIOSCRC.SituacaoCrc='" + situacaoRet + "' "
                    + "OR PRONTUARIOSCRC.SituacaoCrc='" + pSAIDA_TEMPORARIA + "' "
                    + "OR PRONTUARIOSCRC.SituacaoCrc LIKE'%" + pSAIDA_PRISAO_DOMICILIAR + "%'");
        } else if (jComboBoxPesqSituacao.getSelectedItem().equals("Inativos")) {
            PREENCHER_TABELA_nome("SELECT PRONTUARIOSCRC.IdInternoCrc, "
                    + "PRONTUARIOSCRC.NomeInternoCrc,PRONTUARIOSCRC.MatriculaCrc, "
                    + "PRONTUARIOSCRC.DataCadastCrc,DADOSPENAISINTERNOS.DataEntrada, "
                    + "PRONTUARIOSCRC.Cnc, "
                    + "PRONTUARIOSCRC.SituacaoCrc "
                    + "FROM PRONTUARIOSCRC "
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
                    + "WHERE PRONTUARIOSCRC.SituacaoCrc='" + situacaoTra + "' "
                    + "OR PRONTUARIOSCRC.SituacaoCrc='" + situacaoAlv + "' "
                    + "OR PRONTUARIOSCRC.SituacaoCrc='" + situacaoCon + "' "
                    + "OR PRONTUARIOSCRC.SituacaoCrc='" + situacaoReg + "'");
        } else if (jComboBoxPesqSituacao.getSelectedItem().equals("Evadidos")) {
            PREENCHER_TABELA_nome("SELECT PRONTUARIOSCRC.IdInternoCrc, "
                    + "PRONTUARIOSCRC.NomeInternoCrc,PRONTUARIOSCRC.MatriculaCrc, "
                    + "PRONTUARIOSCRC.DataCadastCrc,DADOSPENAISINTERNOS.DataEntrada, "
                    + "PRONTUARIOSCRC.Cnc, "
                    + "PRONTUARIOSCRC.SituacaoCrc "
                    + "FROM PRONTUARIOSCRC "
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
                    + "WHERE PRONTUARIOSCRC.SituacaoCrc='" + situacaoEva + "' ");

        }
    }//GEN-LAST:event_jBtPesqSitucaoActionPerformed

    private void jBtCNCPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCNCPesquisaActionPerformed
        // TODO add your handling code here:
        count = 0;
        pSAIDA_TEMP = 0;
        pSAIDA_COVID = 0;
        pATIVOS_ENTRADA = 0;
        pATIVOS_RETORNO = 0;
        pTOTAL_ATIVOS = 0;
        flag = 1;
        if (jPesquisaCNC.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe MATRICULA para pesquisa!!!");
            jPesquisaCNC.requestFocus();
        } else {
            PREENCHER_TABELA_INTERNOS_matricula("SELECT PRONTUARIOSCRC.IdInternoCrc, "
                    + "PRONTUARIOSCRC.NomeInternoCrc,PRONTUARIOSCRC.MatriculaCrc, "
                    + "PRONTUARIOSCRC.DataCadastCrc,DADOSPENAISINTERNOS.DataEntrada, "
                    + "PRONTUARIOSCRC.Cnc, "
                    + "PRONTUARIOSCRC.SituacaoCrc "
                    + "FROM PRONTUARIOSCRC "
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
                    + "WHERE Cnc LIKE'%" + jPesquisaCNC.getText() + "%'");
        }
    }//GEN-LAST:event_jBtCNCPesquisaActionPerformed

    private void jBtImportarProntuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImportarProntuarioActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCadastroProntuarioImportTRI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTRI.equals("ADMINISTRADORES") || codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaCadastroProntuarioImportTRI) && codAbrirTRI == 1) {
            mostrarTelaPesquisaExterna();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado.");
        }
    }//GEN-LAST:event_jBtImportarProntuarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField jAlcunha;
    public static javax.swing.JTextField jAltura;
    public static javax.swing.JTextField jArtigo1;
    public static javax.swing.JTextField jArtigo2;
    public static javax.swing.JTextField jArtigo3;
    public static javax.swing.JTextField jBairro;
    private javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtAlterar1;
    private javax.swing.JButton jBtAuditoriaPronCrc;
    private javax.swing.JButton jBtAuditoriaPronCrc1;
    private javax.swing.JButton jBtBiometria;
    private javax.swing.JButton jBtBuscarRegPortaria;
    private javax.swing.JButton jBtBuscarRegPortaria1;
    private javax.swing.JButton jBtCNCPesquisa;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtCancelar1;
    private javax.swing.JButton jBtExcluir;
    private javax.swing.JButton jBtExcluir1;
    private javax.swing.JButton jBtExcluirCorpo2;
    private javax.swing.JButton jBtExcluirFoto;
    private javax.swing.JButton jBtExcluirFotoCorpo;
    private javax.swing.JButton jBtExcluirFotoCorpo1;
    private javax.swing.JButton jBtExcluirFotoPerfil;
    private javax.swing.JButton jBtImportarProntuario;
    private javax.swing.JButton jBtImpressao;
    private javax.swing.JButton jBtImpressao1;
    private javax.swing.JButton jBtMatricula;
    private javax.swing.JButton jBtNome;
    private javax.swing.JButton jBtNovaFoto;
    private javax.swing.JButton jBtNovaFotoCorpo;
    private javax.swing.JButton jBtNovaFotoCorpo1;
    private javax.swing.JButton jBtNovaFotoCorpo2;
    private javax.swing.JButton jBtNovaFotoPerfil;
    private javax.swing.JButton jBtNovo;
    private javax.swing.JButton jBtNovo1;
    private javax.swing.JButton jBtObservacao;
    private javax.swing.JButton jBtObservacao1;
    private javax.swing.JButton jBtPeculiaridadeCostas;
    private javax.swing.JButton jBtPeculiaridadeFrente;
    private javax.swing.JButton jBtPesqAlcunha;
    private javax.swing.JButton jBtPesqCidade;
    private javax.swing.JButton jBtPesqCidadeEnd;
    private javax.swing.JButton jBtPesqCodigo;
    private javax.swing.JButton jBtPesqPais;
    private javax.swing.JButton jBtPesqSitucao;
    private javax.swing.JButton jBtPesqUnidade;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSair1;
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JButton jBtSalvar1;
    private javax.swing.JButton jBtWebCam;
    private javax.swing.JButton jBtZoonFoto;
    public static javax.swing.JTextField jCNC;
    public static javax.swing.JFormattedTextField jCPFInterno;
    public static javax.swing.JTextField jCalca;
    public static javax.swing.JTextField jCamisa;
    public static javax.swing.JTextField jCartaoSus;
    public static javax.swing.JFormattedTextField jCelular;
    private javax.swing.JCheckBox jCheckBox1;
    public static javax.swing.JTextField jCidade;
    public static javax.swing.JComboBox jComboBoxBarba;
    public static javax.swing.JComboBox jComboBoxBigode;
    public static javax.swing.JComboBox jComboBoxBoca;
    public static javax.swing.JComboBox jComboBoxCabelos;
    public static javax.swing.JTextField jComboBoxCidade;
    public static javax.swing.JComboBox jComboBoxCompleicao;
    public static javax.swing.JComboBox jComboBoxCutis;
    public static javax.swing.JComboBox jComboBoxEdiondo;
    public static javax.swing.JComboBox jComboBoxEscolaridade;
    public static javax.swing.JComboBox jComboBoxEstadoCivil;
    public static javax.swing.JComboBox jComboBoxLabios;
    public static javax.swing.JComboBox jComboBoxNariz;
    public static javax.swing.JComboBox jComboBoxOlhos;
    public static javax.swing.JComboBox jComboBoxOrelha;
    public static javax.swing.JTextField jComboBoxPais;
    public static javax.swing.JComboBox jComboBoxParticipacao;
    public static javax.swing.JComboBox jComboBoxPescoco;
    private javax.swing.JComboBox jComboBoxPesqSituacao;
    public static javax.swing.JComboBox jComboBoxRegime;
    public static javax.swing.JComboBox jComboBoxRosto;
    public static javax.swing.JComboBox jComboBoxSexo;
    private javax.swing.JComboBox<String> jComboBoxUF;
    public static javax.swing.JTextField jComboBoxUnid;
    public static com.toedter.calendar.JDateChooser jDataCadastro;
    public static com.toedter.calendar.JDateChooser jDataCondenacao;
    public static com.toedter.calendar.JDateChooser jDataCrime;
    public static com.toedter.calendar.JDateChooser jDataEntrada;
    public static com.toedter.calendar.JDateChooser jDataNascimento;
    public static com.toedter.calendar.JDateChooser jDataNovaEntrada;
    public static com.toedter.calendar.JDateChooser jDataPrisao;
    public static com.toedter.calendar.JDateChooser jDataTerPena;
    public static javax.swing.JTextField jEndereco;
    public static javax.swing.JTextField jEstado;
    public static javax.swing.JLabel jFotoAnularDireito;
    public static javax.swing.JLabel jFotoAnularEsquerdo;
    private javax.swing.JLabel jFotoCorpo;
    private javax.swing.JLabel jFotoCorpo1;
    private javax.swing.JLabel jFotoCorpo2;
    public static javax.swing.JLabel jFotoIndicadorDireito;
    public static javax.swing.JLabel jFotoIndicadorEsquerdo;
    public static javax.swing.JLabel jFotoMedioDireito;
    public static javax.swing.JLabel jFotoMedioEsquerdo;
    public static javax.swing.JLabel jFotoMinimoEsquerdo;
    public static javax.swing.JLabel jFotoMininoDireito;
    private javax.swing.JLabel jFotoPerfil;
    public static javax.swing.JLabel jFotoPolegarDireito;
    public static javax.swing.JLabel jFotoPolegarEsquerdo;
    public static javax.swing.JTextField jIdInterno;
    public static javax.swing.JTextField jIdentificador;
    public static javax.swing.JTextField jIdentificador1;
    public static javax.swing.JTextField jIdentificador2;
    public static javax.swing.JTextField jIdentificador3;
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
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
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
    public static javax.swing.JLabel jLabelFotoInterno;
    public static javax.swing.JTextField jMaeInterno;
    public static javax.swing.JTextField jMatriculaPenal;
    public static javax.swing.JTextField jNomeInterno;
    public static javax.swing.JTextField jPaiInterno;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
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
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    public static javax.swing.JTextField jParagrafo1;
    public static javax.swing.JTextField jParagrafo2;
    public static javax.swing.JTextField jParagrafo3;
    public static javax.swing.JTextField jParticularidade;
    public static javax.swing.JTextField jPena;
    public static javax.swing.JTextField jPerfil;
    public static javax.swing.JTextField jPeso;
    private javax.swing.JTextField jPesqAlcunha;
    private javax.swing.JTextField jPesqCodigo;
    private javax.swing.JTextField jPesqMatricula;
    private javax.swing.JTextField jPesqNome;
    private javax.swing.JTextField jPesquisaCNC;
    public static javax.swing.JTextField jProfissao;
    public static javax.swing.JFormattedTextField jRGInterno;
    public static javax.swing.JTextField jRegiaoCorpo;
    public static javax.swing.JTextField jRegiaoCorpo1;
    public static javax.swing.JTextField jRegiaoCorpo2;
    public static javax.swing.JTextField jReligiao;
    public static javax.swing.JTextField jSapato;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    public static javax.swing.JTextField jSituacao;
    public static javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable jTabelaInterno;
    public static javax.swing.JFormattedTextField jTelefone;
    public static javax.swing.JFormattedTextField jTelefone1;
    public static javax.swing.JTextField jVaraCondenacao;
    private javax.swing.JLabel jtotalInternos_ATIVOS;
    private javax.swing.JLabel jtotalRegistros;
    private javax.swing.JLabel jtotalRegistrosPDC;
    private javax.swing.JLabel jtotalRegistrosTMP;
    // End of variables declaration//GEN-END:variables

    public void bloquearCamposEdicao() {
        jMatriculaPenal.setEnabled(!true);
        jDataCadastro.setEnabled(!true);
        jDataNascimento.setEnabled(!true);
        jNomeInterno.setEnabled(!true);
        jMaeInterno.setEnabled(!true);
        jPaiInterno.setEnabled(!true);
        jAlcunha.setEnabled(!true);
        jRGInterno.setEnabled(!true);
        jComboBoxUF.setEnabled(!true);
        jCPFInterno.setEnabled(!true);
        jCartaoSus.setEnabled(!true);
        jComboBoxEscolaridade.setEnabled(!true);
        jComboBoxEstadoCivil.setEnabled(!true);
        jComboBoxSexo.setEnabled(!true);
        jSituacao.setEnabled(!true);
        jComboBoxPais.setEnabled(!true);
        jComboBoxCidade.setEnabled(!true);
        jReligiao.setEnabled(!true);
        jProfissao.setEnabled(!true);
        jEndereco.setEnabled(!true);
        jBairro.setEnabled(!true);
        jCidade.setEnabled(!true);
        jEstado.setEnabled(!true);
        jTelefone.setEnabled(!true);
        jTelefone1.setEnabled(!true);
        jCelular.setEnabled(!true);
        jComboBoxCutis.setEnabled(!true);
        jComboBoxOlhos.setEnabled(!true);
        jComboBoxCabelos.setEnabled(!true);
        jComboBoxBarba.setEnabled(!true);
        jComboBoxBigode.setEnabled(!true);
        jComboBoxNariz.setEnabled(!true);
        jComboBoxBoca.setEnabled(!true);
        jComboBoxRosto.setEnabled(!true);
        jComboBoxLabios.setEnabled(!true);
        jCamisa.setEnabled(!true);
        jCalca.setEnabled(!true);
        jSapato.setEnabled(!true);
        jPeso.setEnabled(!true);
        jAltura.setEnabled(!true);
        jParticularidade.setEnabled(!true);
        jComboBoxOrelha.setEnabled(true);
        jComboBoxPescoco.setEnabled(true);
        jComboBoxCompleicao.setEnabled(!true);
        jComboBoxPescoco.setEnabled(!true);
        jComboBoxOrelha.setEnabled(!true);
        jDataEntrada.setEnabled(!true);
        jComboBoxUnid.setEnabled(!true);
        jBtPesqUnidade.setEnabled(!true);
        jDataCrime.setEnabled(!true);
        jDataPrisao.setEnabled(!true);
        jDataCondenacao.setEnabled(!true);
        jComboBoxParticipacao.setEnabled(!true);
        jComboBoxRegime.setEnabled(!true);
        jPena.setEnabled(!true);
        jArtigo1.setEnabled(!true);
        jArtigo2.setEnabled(!true);
        jArtigo3.setEnabled(!true);
        jParagrafo1.setEnabled(!true);
        jParagrafo2.setEnabled(!true);
        jComboBoxEdiondo.setEnabled(!true);
        jParagrafo3.setEnabled(!true);
        jDataTerPena.setEnabled(!true);
        jIdentificador.setEnabled(!true);
        jIdentificador1.setEnabled(!true);
        jIdentificador2.setEnabled(!true);
        jIdentificador3.setEnabled(!true);
        jPerfil.setEnabled(!true);
        jRegiaoCorpo.setEnabled(!true);
        jRegiaoCorpo1.setEnabled(!true);
        jRegiaoCorpo2.setEnabled(!true);
        jVaraCondenacao.setEnabled(!true);
        // Habilitar/Desabilitar  Botões        
        jBtNovaFoto.setEnabled(!true);
        jBtExcluirFoto.setEnabled(!true);
        jBtPesqPais.setEnabled(!true);
        jBtPesqCidade.setEnabled(!true);
        jBtPesqCidadeEnd.setEnabled(!true);
        //
        jBtNovaFotoPerfil.setEnabled(!true);
        jBtExcluirFotoPerfil.setEnabled(!true);
        jBtNovaFotoCorpo.setEnabled(!true);
        jBtExcluirFotoCorpo.setEnabled(!true);
        jBtNovaFotoCorpo1.setEnabled(!true);
        jBtExcluirFotoCorpo1.setEnabled(!true);
        jBtNovaFotoCorpo2.setEnabled(!true);
        jBtExcluirCorpo2.setEnabled(!true);
        jBtWebCam.setEnabled(!true);
    }

    public void corCampos() {
        jIdInterno.setBackground(Color.white);
        jMatriculaPenal.setBackground(Color.white);
        jDataCadastro.setBackground(Color.white);
        jDataNascimento.setBackground(Color.white);
        jDataEntrada.setBackground(Color.white);
        jDataCrime.setBackground(Color.white);
        jDataPrisao.setBackground(Color.white);
        jDataCondenacao.setBackground(Color.white);
        jDataTerPena.setBackground(Color.white);
        jNomeInterno.setBackground(Color.white);
        jMaeInterno.setBackground(Color.white);
        jPaiInterno.setBackground(Color.white);
        jAlcunha.setBackground(Color.white);
        jRGInterno.setBackground(Color.white);
        jComboBoxUF.setBackground(Color.white);
        jCartaoSus.setBackground(Color.white);
        jCPFInterno.setBackground(Color.white);
        jComboBoxEscolaridade.setBackground(Color.white);
        jComboBoxEstadoCivil.setBackground(Color.white);
        jComboBoxSexo.setBackground(Color.white);
        jSituacao.setBackground(Color.white);
        jComboBoxCutis.setBackground(Color.white);
        jComboBoxOlhos.setBackground(Color.white);
        jComboBoxCabelos.setBackground(Color.white);
        jComboBoxBarba.setBackground(Color.white);
        jComboBoxBigode.setBackground(Color.white);
        jComboBoxNariz.setBackground(Color.white);
        jComboBoxBoca.setBackground(Color.white);
        jComboBoxRosto.setBackground(Color.white);
        jComboBoxLabios.setBackground(Color.white);
        jComboBoxParticipacao.setBackground(Color.white);
        jComboBoxRegime.setBackground(Color.white);
        jComboBoxEdiondo.setBackground(Color.white);
        jComboBoxPais.setBackground(Color.white);
        jComboBoxCidade.setBackground(Color.white);
        jComboBoxUnid.setBackground(Color.white);
        jReligiao.setBackground(Color.white);
        jProfissao.setBackground(Color.white);
        jEndereco.setBackground(Color.white);
        jBairro.setBackground(Color.white);
        jCidade.setBackground(Color.white);
        jEstado.setBackground(Color.white);
        jCNC.setBackground(Color.white);
        jTelefone.setBackground(Color.white);
        jTelefone1.setBackground(Color.white);
        jCelular.setBackground(Color.white);
        jCamisa.setBackground(Color.white);
        jCalca.setBackground(Color.white);
        jSapato.setBackground(Color.white);
        jPeso.setBackground(Color.white);
        jAltura.setBackground(Color.white);
        jComboBoxOrelha.setBackground(Color.white);
        jComboBoxPescoco.setBackground(Color.white);
        jComboBoxCompleicao.setBackground(Color.white);
        jParticularidade.setBackground(Color.white);
        jPena.setBackground(Color.white);
        jArtigo1.setBackground(Color.white);
        jArtigo2.setBackground(Color.white);
        jArtigo3.setBackground(Color.white);
        jParagrafo1.setBackground(Color.white);
        jParagrafo2.setBackground(Color.white);
        jParagrafo3.setBackground(Color.white);
        jIdentificador.setBackground(Color.white);
        jIdentificador1.setBackground(Color.white);
        jIdentificador2.setBackground(Color.white);
        jIdentificador3.setBackground(Color.white);
        jPerfil.setBackground(Color.white);
        jRegiaoCorpo.setBackground(Color.white);
        jRegiaoCorpo1.setBackground(Color.white);
        jRegiaoCorpo2.setBackground(Color.white);
        jVaraCondenacao.setBackground(Color.white);
    }

    public void Novo() {
        if (codParametrosEntrada == null) {
            JOptionPane.showMessageDialog(rootPane, "O Parametro que controla a situação do interno está vazio, é necessário\nque seja configurado. Solicite ao Administrador do Sistema.");
        } else {
            if (codParametrosEntrada.equals("Sim")) {
                jBtBuscarRegPortaria.setEnabled(true); // Pesquisar registro da portaria 
                jBtBuscarRegPortaria1.setEnabled(true);
            } else {
                jBtBuscarRegPortaria.setEnabled(!true); // O parametro da entrada esta como "Não", desabilitar pesquisa na portaria
                jBtBuscarRegPortaria1.setEnabled(!true);
            }
        }
        // Limpar campos para inclusão
        jIdInterno.setText("");
        jMatriculaPenal.setText("");
        jDataCadastro.setCalendar(Calendar.getInstance());
        jDataNascimento.setCalendar(Calendar.getInstance());
        jDataEntrada.setCalendar(Calendar.getInstance());
        jDataEntrada.setCalendar(Calendar.getInstance());
        jDataCrime.setCalendar(Calendar.getInstance());
        jDataPrisao.setCalendar(Calendar.getInstance());
        jDataCondenacao.setCalendar(Calendar.getInstance());
        jDataTerPena.setCalendar(Calendar.getInstance());
        jLabelFotoInterno.setIcon(null);
        jFotoPerfil.setIcon(null);
        jFotoCorpo.setIcon(null);
        jFotoCorpo1.setIcon(null);
        jFotoCorpo2.setIcon(null);
        //
        jFotoPolegarDireito.setIcon(null);
        jFotoIndicadorDireito.setIcon(null);
        jFotoMedioDireito.setIcon(null);
        jFotoAnularDireito.setIcon(null);
        jFotoMininoDireito.setIcon(null);
        //
        jFotoPolegarEsquerdo.setIcon(null);
        jFotoIndicadorEsquerdo.setIcon(null);
        jFotoMedioEsquerdo.setIcon(null);
        jFotoAnularEsquerdo.setIcon(null);
        jFotoMinimoEsquerdo.setIcon(null);
        // caminho = "";
        caminhoFotoPerfil = "";
        caminhoFotoCorpo = "";
        caminhoFotoCorpo1 = "";
        caminhoFotoCorpo2 = "";
        caminhoFotoCorpo3 = "";
        caminhoPolegarDireito = "";
        caminhoIndicadorDireito = "";
        caminhoMedioDireito = "";
        caminhoAnularDireito = "";
        caminhoMininoDireito = "";
        caminhoPolegarEsquerdo = "";
        caminhoIndicadorEsquerdo = "";
        caminhoMedioEsquerdo = "";
        caminhoAnularEsquerdo = "";
        caminhoMininoEsquerdo = "";
        jNomeInterno.setText("");
        jMaeInterno.setText("");
        jPaiInterno.setText("");
        jAlcunha.setText("");
        jRGInterno.setText("");
        jComboBoxUF.setSelectedItem("AC");
        jCPFInterno.setText("");
        jCartaoSus.setText("");
        jComboBoxEscolaridade.setSelectedItem("");
        jComboBoxEstadoCivil.setSelectedItem("");
        jComboBoxSexo.setSelectedItem("");
        jSituacao.setText("");
        jComboBoxCutis.setSelectedItem("");
        jComboBoxOlhos.setSelectedItem("");
        jComboBoxCabelos.setSelectedItem("");
        jComboBoxBarba.setSelectedItem("");
        jComboBoxBigode.setSelectedItem("");
        jComboBoxNariz.setSelectedItem("");
        jComboBoxBoca.setSelectedItem("");
        jComboBoxRosto.setSelectedItem("");
        jComboBoxLabios.setSelectedItem("");
        jComboBoxParticipacao.setSelectedItem("");
        jComboBoxRegime.setSelectedItem("");
        jComboBoxEdiondo.setSelectedItem("");
        jComboBoxPais.setText("");
        jComboBoxCidade.setText("");
        jComboBoxUnid.setText("");
        jReligiao.setText("");
        jProfissao.setText("");
        jEndereco.setText("");
        jBairro.setText("");
        jCidade.setText("");
        jEstado.setText("");
        jCNC.setText("");
        jTelefone.setText("");
        jTelefone1.setText("");
        jCelular.setText("");
        jCamisa.setText("");
        jCalca.setText("");
        jSapato.setText("");
        jPeso.setText("");
        jAltura.setText("");
        jComboBoxOrelha.setSelectedItem(null);
        jComboBoxPescoco.setSelectedItem(null);
        jComboBoxCompleicao.setSelectedItem(null);
        jPena.setText("");
        jArtigo1.setText("");
        jArtigo2.setText("");
        jArtigo3.setText("");
        jParagrafo1.setText("");
        jParagrafo2.setText("");
        jParagrafo3.setText("");
        jIdentificador.setText("");
        jIdentificador1.setText("");
        jIdentificador2.setText("");
        jIdentificador3.setText("");
        jPerfil.setText("");
        jRegiaoCorpo.setText("");
        jRegiaoCorpo1.setText("");
        jRegiaoCorpo2.setText("");
        jVaraCondenacao.setText("");
        jDataNovaEntrada.setDate(null);
        // Habilitar campos para INCLUSÃO
        jMatriculaPenal.setEnabled(true);
        jDataCadastro.setEnabled(true);
        jDataNascimento.setEnabled(true);
        jNomeInterno.setEnabled(true);
        jMaeInterno.setEnabled(true);
        jPaiInterno.setEnabled(true);
        jAlcunha.setEnabled(true);
        jRGInterno.setEnabled(true);
        jComboBoxUF.setEnabled(true);
        jCPFInterno.setEnabled(true);
        jCartaoSus.setEnabled(true);
        jComboBoxEscolaridade.setEnabled(true);
        jComboBoxEstadoCivil.setEnabled(true);
        jSituacao.setEnabled(!true);
        jComboBoxSexo.setEnabled(true);
//        jComboBoxPais.setEnabled(true);
//        jComboBoxCidade.setEnabled(true);
        jReligiao.setEnabled(true);
        jProfissao.setEnabled(true);
        jEndereco.setEnabled(true);
        jBairro.setEnabled(true);
        jCidade.setEnabled(true);
        jEstado.setEnabled(true);
        jCNC.setEnabled(true);
        jTelefone.setEnabled(true);
        jTelefone1.setEnabled(true);
        jCelular.setEnabled(true);
        jComboBoxCutis.setEnabled(true);
        jComboBoxOlhos.setEnabled(true);
        jComboBoxCabelos.setEnabled(true);
        jComboBoxBarba.setEnabled(true);
        jComboBoxBigode.setEnabled(true);
        jComboBoxNariz.setEnabled(true);
        jComboBoxBoca.setEnabled(true);
        jComboBoxRosto.setEnabled(true);
        jComboBoxLabios.setEnabled(true);
        jCamisa.setEnabled(true);
        jCalca.setEnabled(true);
        jSapato.setEnabled(true);
        jPeso.setEnabled(true);
        jAltura.setEnabled(true);
        jParticularidade.setEnabled(true);
        jComboBoxOrelha.setEnabled(true);
        jComboBoxPescoco.setEnabled(true);
        jComboBoxCompleicao.setEnabled(true);
        jDataEntrada.setEnabled(true);
        //  jComboBoxUnid.setEnabled(true);
        jBtPesqUnidade.setEnabled(true);
        jDataCrime.setEnabled(true);
        jDataPrisao.setEnabled(true);
        jDataCondenacao.setEnabled(true);
        jComboBoxParticipacao.setEnabled(true);
        jComboBoxRegime.setEnabled(true);
        jPena.setEnabled(true);
        jArtigo1.setEnabled(true);
        jArtigo2.setEnabled(true);
        jArtigo3.setEnabled(true);
        jParagrafo1.setEnabled(true);
        jParagrafo2.setEnabled(true);
        jComboBoxEdiondo.setEnabled(true);
        jParagrafo3.setEnabled(true);
        jDataTerPena.setEnabled(true);
        jIdentificador.setEnabled(true);
        jIdentificador1.setEnabled(true);
        jIdentificador2.setEnabled(true);
        jIdentificador3.setEnabled(true);
        jPerfil.setEnabled(true);
        jRegiaoCorpo.setEnabled(true);
        jRegiaoCorpo1.setEnabled(true);
        jRegiaoCorpo2.setEnabled(true);
        jVaraCondenacao.setEnabled(true);
        jDataNovaEntrada.setEnabled(true);
        // Habilitar/Desabilitar  Botões        
        jBtNovaFoto.setEnabled(true);
        jBtExcluirFoto.setEnabled(true);
        jBtPesqPais.setEnabled(true);
        jBtPesqCidade.setEnabled(true);
        jBtPesqCidadeEnd.setEnabled(true);
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtAuditoriaPronCrc.setEnabled(!true);
        jBtPeculiaridadeCostas.setEnabled(!true);
        jBtPeculiaridadeFrente.setEnabled(!true);
        //
        jBtNovaFotoPerfil.setEnabled(true);
        jBtExcluirFotoPerfil.setEnabled(true);
        jBtNovaFotoCorpo.setEnabled(true);
        jBtExcluirFotoCorpo.setEnabled(true);
        jBtNovaFotoCorpo1.setEnabled(true);
        jBtExcluirFotoCorpo1.setEnabled(true);
        jBtNovaFotoCorpo2.setEnabled(true);
        jBtExcluirCorpo2.setEnabled(true);
        jBtImpressao.setEnabled(!true);
        jBtWebCam.setEnabled(true);
        jBtObservacao.setEnabled(!true);
        // BOTÕES DA SEGUNDA ABA
        jBtNovo1.setEnabled(true);
        jBtAlterar1.setEnabled(!true);
        jBtExcluir1.setEnabled(!true);
        jBtSalvar1.setEnabled(true);
        jBtCancelar1.setEnabled(true);
        jBtImpressao1.setEnabled(!true);
        jBtObservacao1.setEnabled(!true);
        jBtAuditoriaPronCrc1.setEnabled(!true);
        jBtBiometria.setEnabled(!true);
        jBtImportarProntuario.setEnabled(true);
    }

    public void Alterar() {
        if (codParametrosEntrada == null) {
            JOptionPane.showMessageDialog(rootPane, "O Parametro que controla a situação do interno está vazio, é necessário\nque seja configurado. Solicite ao Administrador do Sistema.");
        } else {
            if (codParametrosEntrada.equals("Sim")) {
                jBtBuscarRegPortaria.setEnabled(true); // Pesquisar registro da portaria 
                jBtBuscarRegPortaria1.setEnabled(true);
            } else {
                jBtBuscarRegPortaria.setEnabled(!true); // O parametro da entrada esta como "Não", desabilitar pesquisa na portaria
                jBtBuscarRegPortaria1.setEnabled(!true);
            }
        }
        jMatriculaPenal.setEnabled(true);
        jDataCadastro.setEnabled(true);
        jDataNascimento.setEnabled(true);
        jNomeInterno.setEnabled(true);
        jMaeInterno.setEnabled(true);
        jPaiInterno.setEnabled(true);
        jAlcunha.setEnabled(true);
        jRGInterno.setEnabled(true);
        jComboBoxUF.setEnabled(true);
        jCPFInterno.setEnabled(true);
        jCartaoSus.setEnabled(true);
        jComboBoxEscolaridade.setEnabled(true);
        jComboBoxEstadoCivil.setEnabled(true);
        jComboBoxSexo.setEnabled(true);
        jSituacao.setEnabled(!true);
        //  jComboBoxPais.setEnabled(true);
        //   jComboBoxCidade.setEnabled(true);
        jReligiao.setEnabled(true);
        jProfissao.setEnabled(true);
        jEndereco.setEnabled(true);
        jBairro.setEnabled(true);
        jCidade.setEnabled(true);
        jEstado.setEnabled(true);
        jCNC.setEnabled(true);
        jTelefone.setEnabled(true);
        jTelefone1.setEnabled(true);
        jCelular.setEnabled(true);
        jComboBoxCutis.setEnabled(true);
        jComboBoxOlhos.setEnabled(true);
        jComboBoxCabelos.setEnabled(true);
        jComboBoxBarba.setEnabled(true);
        jComboBoxBigode.setEnabled(true);
        jComboBoxNariz.setEnabled(true);
        jComboBoxBoca.setEnabled(true);
        jComboBoxRosto.setEnabled(true);
        jComboBoxLabios.setEnabled(true);
        jCamisa.setEnabled(true);
        jCalca.setEnabled(true);
        jSapato.setEnabled(true);
        jPeso.setEnabled(true);
        jAltura.setEnabled(true);
        jParticularidade.setEnabled(true);
        jComboBoxOrelha.setEnabled(true);
        jComboBoxPescoco.setEnabled(true);
        jComboBoxCompleicao.setEnabled(true);
        jDataEntrada.setEnabled(true);
        //   jComboBoxUnid.setEnabled(true);
        jBtPesqUnidade.setEnabled(true);
        jDataCrime.setEnabled(true);
        jDataPrisao.setEnabled(true);
        jDataCondenacao.setEnabled(true);
        jComboBoxParticipacao.setEnabled(true);
        jComboBoxRegime.setEnabled(true);
        jPena.setEnabled(true);
        jArtigo1.setEnabled(true);
        jArtigo2.setEnabled(true);
        jArtigo3.setEnabled(true);
        jParagrafo1.setEnabled(true);
        jParagrafo2.setEnabled(true);
        jComboBoxEdiondo.setEnabled(true);
        jParagrafo3.setEnabled(true);
        jDataTerPena.setEnabled(true);
        jIdentificador.setEnabled(true);
        jIdentificador1.setEnabled(true);
        jIdentificador2.setEnabled(true);
        jIdentificador3.setEnabled(true);
        jPerfil.setEnabled(true);
        jRegiaoCorpo.setEnabled(true);
        jRegiaoCorpo1.setEnabled(true);
        jRegiaoCorpo2.setEnabled(true);
        jVaraCondenacao.setEnabled(true);
        jDataNovaEntrada.setEnabled(true);
        // Habilitar/Desabilitar  Botões
        jBtZoonFoto.setEnabled(true);
        jBtNovaFoto.setEnabled(true);
        jBtExcluirFoto.setEnabled(true);
        jBtPesqPais.setEnabled(true);
        jBtPesqCidade.setEnabled(true);
        jBtPesqCidadeEnd.setEnabled(true);
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtImpressao.setEnabled(!true);
        jBtObservacao.setEnabled(!true);
        jBtAuditoriaPronCrc.setEnabled(!true);
        jBtPeculiaridadeCostas.setEnabled(!true);
        jBtPeculiaridadeFrente.setEnabled(!true);
        //
        jBtNovaFotoPerfil.setEnabled(true);
        jBtExcluirFotoPerfil.setEnabled(true);
        jBtNovaFotoCorpo.setEnabled(true);
        jBtExcluirFotoCorpo.setEnabled(true);
        jBtNovaFotoCorpo1.setEnabled(true);
        jBtExcluirFotoCorpo1.setEnabled(true);
        jBtNovaFotoCorpo2.setEnabled(true);
        jBtExcluirCorpo2.setEnabled(true);
        jBtWebCam.setEnabled(true);
        //
        jBtNovo1.setEnabled(!true);
        jBtAlterar1.setEnabled(!true);
        jBtExcluir1.setEnabled(!true);
        jBtSalvar1.setEnabled(true);
        jBtCancelar1.setEnabled(true);
        jBtImpressao1.setEnabled(!true);
        jBtObservacao1.setEnabled(!true);
        jBtAuditoriaPronCrc1.setEnabled(!true);
        jBtBiometria.setEnabled(!true);
        jBtImportarProntuario.setEnabled(!true);
    }

    public void Excluir() {

        jMatriculaPenal.setText("");
        jNomeInterno.setText("");
        jMaeInterno.setText("");
        jPaiInterno.setText("");
        jAlcunha.setText("");
        jRGInterno.setText("");
        jComboBoxUF.setSelectedItem("AC");
        jCPFInterno.setText("");
        jCartaoSus.setText("");
        jComboBoxEscolaridade.setSelectedItem("");
        jComboBoxEstadoCivil.setSelectedItem("");
        jComboBoxSexo.setSelectedItem("");
        jSituacao.setText("");
        jComboBoxCutis.setSelectedItem("");
        jComboBoxOlhos.setSelectedItem("");
        jComboBoxCabelos.setSelectedItem("");
        jComboBoxBarba.setSelectedItem("");
        jComboBoxBigode.setSelectedItem("");
        jComboBoxNariz.setSelectedItem("");
        jComboBoxBoca.setSelectedItem("");
        jComboBoxRosto.setSelectedItem("");
        jComboBoxLabios.setSelectedItem("");
        jComboBoxParticipacao.setSelectedItem("");
        jComboBoxRegime.setSelectedItem("");
        jComboBoxEdiondo.setSelectedItem("");
        jComboBoxPais.setText("");
        jComboBoxCidade.setText("");
        jComboBoxUnid.setText("");
        jReligiao.setText("");
        jProfissao.setText("");
        jEndereco.setText("");
        jBairro.setText("");
        jCidade.setText("");
        jEstado.setText("");
        jCNC.setText("");
        jTelefone.setText("");
        jTelefone1.setText("");
        jCelular.setText("");
        jCamisa.setText("");
        jCalca.setText("");
        jSapato.setText("");
        jPeso.setText("");
        jAltura.setText("");
        jComboBoxOrelha.setSelectedItem(null);
        jComboBoxPescoco.setSelectedItem(null);
        jComboBoxCompleicao.setSelectedItem(null);
        jPena.setText("");
        jArtigo1.setText("");
        jArtigo2.setText("");
        jArtigo3.setText("");
        jParagrafo1.setText("");
        jParagrafo2.setText("");
        jParagrafo3.setText("");
        jIdentificador.setText("");
        jIdentificador1.setText("");
        jIdentificador2.setText("");
        jIdentificador3.setText("");
        jPerfil.setText("");
        jRegiaoCorpo.setText("");
        jRegiaoCorpo1.setText("");
        jRegiaoCorpo2.setText("");
        jVaraCondenacao.setText("");
        jDataNovaEntrada.setDate(null);
        //
        jLabelFotoInterno.setIcon(null);
        jFotoPerfil.setIcon(null);
        jFotoCorpo.setIcon(null);
        jFotoCorpo1.setIcon(null);
        jFotoCorpo2.setIcon(null);
        //
        jFotoPolegarDireito.setIcon(null);
        jFotoIndicadorDireito.setIcon(null);
        jFotoMedioDireito.setIcon(null);
        jFotoAnularDireito.setIcon(null);
        jFotoMininoDireito.setIcon(null);
        //
        jFotoPolegarEsquerdo.setIcon(null);
        jFotoIndicadorEsquerdo.setIcon(null);
        jFotoMedioEsquerdo.setIcon(null);
        jFotoAnularEsquerdo.setIcon(null);
        jFotoMinimoEsquerdo.setIcon(null);
        // Desabilitar os campos
        jMatriculaPenal.setEnabled(!true);
        jDataCadastro.setEnabled(!true);
        jDataNascimento.setEnabled(!true);
        jNomeInterno.setEnabled(!true);
        jMaeInterno.setEnabled(!true);
        jPaiInterno.setEnabled(!true);
        jAlcunha.setEnabled(!true);
        jRGInterno.setEnabled(!true);
        jComboBoxUF.setEnabled(!true);
        jCPFInterno.setEnabled(!true);
        jCartaoSus.setEnabled(!true);
        jComboBoxEscolaridade.setEnabled(!true);
        jComboBoxEstadoCivil.setEnabled(!true);
        jComboBoxSexo.setEnabled(!true);
        jSituacao.setEnabled(!true);
        jComboBoxPais.setEnabled(!true);
        jComboBoxCidade.setEnabled(!true);
        jReligiao.setEnabled(!true);
        jProfissao.setEnabled(!true);
        jEndereco.setEnabled(!true);
        jBairro.setEnabled(!true);
        jCidade.setEnabled(!true);
        jEstado.setEnabled(!true);
        jCNC.setEnabled(!true);
        jTelefone.setEnabled(!true);
        jTelefone1.setEnabled(!true);
        jCelular.setEnabled(!true);
        jComboBoxCutis.setEnabled(!true);
        jComboBoxOlhos.setEnabled(!true);
        jComboBoxCabelos.setEnabled(!true);
        jComboBoxBarba.setEnabled(!true);
        jComboBoxBigode.setEnabled(!true);
        jComboBoxNariz.setEnabled(!true);
        jComboBoxBoca.setEnabled(!true);
        jComboBoxRosto.setEnabled(!true);
        jComboBoxLabios.setEnabled(!true);
        jCamisa.setEnabled(!true);
        jCalca.setEnabled(!true);
        jSapato.setEnabled(!true);
        jPeso.setEnabled(!true);
        jAltura.setEnabled(!true);
        jParticularidade.setEnabled(!true);
        jComboBoxOrelha.setEnabled(true);
        jComboBoxPescoco.setEnabled(true);
        jComboBoxCompleicao.setEnabled(true);
        jDataEntrada.setEnabled(!true);
        jComboBoxUnid.setEnabled(!true);
        jBtPesqUnidade.setEnabled(!true);
        jDataCrime.setEnabled(!true);
        jDataPrisao.setEnabled(!true);
        jDataCondenacao.setEnabled(!true);
        jComboBoxParticipacao.setEnabled(!true);
        jComboBoxRegime.setEnabled(!true);
        jPena.setEnabled(!true);
        jArtigo1.setEnabled(!true);
        jArtigo2.setEnabled(!true);
        jArtigo3.setEnabled(!true);
        jParagrafo1.setEnabled(!true);
        jParagrafo2.setEnabled(!true);
        jComboBoxEdiondo.setEnabled(!true);
        jParagrafo3.setEnabled(!true);
        jDataTerPena.setEnabled(!true);
        jIdentificador.setEnabled(!true);
        jIdentificador1.setEnabled(!true);
        jIdentificador2.setEnabled(!true);
        jIdentificador3.setEnabled(!true);
        jPerfil.setEnabled(!true);
        jRegiaoCorpo.setEnabled(!true);
        jRegiaoCorpo1.setEnabled(!true);
        jRegiaoCorpo2.setEnabled(!true);
        jVaraCondenacao.setEnabled(!true);
        jDataNovaEntrada.setEnabled(!true);
        // Habilitar/Desabilitar  Botões
        jBtZoonFoto.setEnabled(!true);
        jBtNovaFoto.setEnabled(!true);
        jBtExcluirFoto.setEnabled(!true);
        jBtPesqPais.setEnabled(!true);
        jBtPesqCidade.setEnabled(!true);
        jBtPesqCidadeEnd.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtImpressao.setEnabled(!true);
        jBtObservacao.setEnabled(!true);
        jBtBuscarRegPortaria.setEnabled(!true);
        jBtAuditoriaPronCrc.setEnabled(!true);
        jBtPeculiaridadeCostas.setEnabled(!true);
        jBtPeculiaridadeFrente.setEnabled(!true);
        //
        jBtNovaFotoPerfil.setEnabled(!true);
        jBtExcluirFotoPerfil.setEnabled(!true);
        jBtNovaFotoCorpo.setEnabled(!true);
        jBtExcluirFotoCorpo.setEnabled(!true);
        jBtNovaFotoCorpo1.setEnabled(!true);
        jBtExcluirFotoCorpo1.setEnabled(!true);
        jBtNovaFotoCorpo2.setEnabled(!true);
        jBtExcluirCorpo2.setEnabled(!true);
        jBtWebCam.setEnabled(!true);
        // BOTÕES DA SEGUNDA ABA
        jBtNovo1.setEnabled(true);
        jBtAlterar1.setEnabled(!true);
        jBtExcluir1.setEnabled(!true);
        jBtSalvar1.setEnabled(!true);
        jBtCancelar1.setEnabled(!true);
        jBtImpressao1.setEnabled(!true);
        jBtObservacao1.setEnabled(!true);
        jBtBuscarRegPortaria1.setEnabled(!true);
        jBtAuditoriaPronCrc1.setEnabled(!true);
        jBtBiometria.setEnabled(!true);
    }

    public void Salvar() {

        jMatriculaPenal.setEnabled(!true);
        jDataCadastro.setEnabled(!true);
        jDataNascimento.setEnabled(!true);
        jNomeInterno.setEnabled(!true);
        jMaeInterno.setEnabled(!true);
        jPaiInterno.setEnabled(!true);
        jAlcunha.setEnabled(!true);
        jRGInterno.setEnabled(!true);
        jComboBoxUF.setEnabled(!true);
        jCPFInterno.setEnabled(!true);
        jCartaoSus.setEnabled(!true);
        jComboBoxEscolaridade.setEnabled(!true);
        jComboBoxEstadoCivil.setEnabled(!true);
        jComboBoxSexo.setEnabled(!true);
        jSituacao.setEnabled(!true);
        jComboBoxPais.setEnabled(!true);
        jComboBoxCidade.setEnabled(!true);
        jReligiao.setEnabled(!true);
        jProfissao.setEnabled(!true);
        jEndereco.setEnabled(!true);
        jBairro.setEnabled(!true);
        jCidade.setEnabled(!true);
        jEstado.setEnabled(!true);
        jCNC.setEnabled(!true);
        jTelefone.setEnabled(!true);
        jTelefone1.setEnabled(!true);
        jCelular.setEnabled(!true);
        jComboBoxCutis.setEnabled(!true);
        jComboBoxOlhos.setEnabled(!true);
        jComboBoxCabelos.setEnabled(!true);
        jComboBoxBarba.setEnabled(!true);
        jComboBoxBigode.setEnabled(!true);
        jComboBoxNariz.setEnabled(!true);
        jComboBoxBoca.setEnabled(!true);
        jComboBoxRosto.setEnabled(!true);
        jComboBoxLabios.setEnabled(!true);
        jCamisa.setEnabled(!true);
        jCalca.setEnabled(!true);
        jSapato.setEnabled(!true);
        jPeso.setEnabled(!true);
        jAltura.setEnabled(!true);
        jParticularidade.setEnabled(!true);
        jComboBoxOrelha.setEnabled(!true);
        jComboBoxPescoco.setEnabled(!true);
        jComboBoxCompleicao.setEnabled(!true);
        jDataEntrada.setEnabled(!true);
        jComboBoxUnid.setEnabled(!true);
        jBtPesqUnidade.setEnabled(!true);
        jDataCrime.setEnabled(!true);
        jDataPrisao.setEnabled(!true);
        jDataCondenacao.setEnabled(!true);
        jComboBoxParticipacao.setEnabled(!true);
        jComboBoxRegime.setEnabled(!true);
        jPena.setEnabled(!true);
        jArtigo1.setEnabled(!true);
        jArtigo2.setEnabled(!true);
        jArtigo3.setEnabled(!true);
        jParagrafo1.setEnabled(!true);
        jParagrafo2.setEnabled(!true);
        jComboBoxEdiondo.setEnabled(!true);
        jParagrafo3.setEnabled(!true);
        jDataTerPena.setEnabled(!true);
        jIdentificador.setEnabled(!true);
        jIdentificador1.setEnabled(!true);
        jIdentificador2.setEnabled(!true);
        jIdentificador3.setEnabled(!true);
        jPerfil.setEnabled(!true);
        jRegiaoCorpo.setEnabled(!true);
        jRegiaoCorpo1.setEnabled(!true);
        jRegiaoCorpo2.setEnabled(!true);
        jVaraCondenacao.setEnabled(!true);
        jDataNovaEntrada.setEnabled(!true);
        // Habilitar/Desabilitar  Botões
        jBtZoonFoto.setEnabled(!true);
        jBtNovaFoto.setEnabled(!true);
        jBtExcluirFoto.setEnabled(!true);
        jBtPesqPais.setEnabled(!true);
        jBtPesqCidade.setEnabled(!true);
        jBtPesqCidadeEnd.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtImpressao.setEnabled(true);
        jBtObservacao.setEnabled(true);
        jBtBuscarRegPortaria.setEnabled(!true);
        jBtAuditoriaPronCrc.setEnabled(true);
        jBtWebCam.setEnabled(!true);
        jBtPeculiaridadeCostas.setEnabled(true);
        jBtPeculiaridadeFrente.setEnabled(true);
        //
        jBtNovaFotoPerfil.setEnabled(!true);
        jBtExcluirFotoPerfil.setEnabled(!true);
        jBtNovaFotoCorpo.setEnabled(!true);
        jBtExcluirFotoCorpo.setEnabled(!true);
        jBtNovaFotoCorpo1.setEnabled(!true);
        jBtExcluirFotoCorpo1.setEnabled(!true);
        jBtNovaFotoCorpo2.setEnabled(!true);
        jBtExcluirCorpo2.setEnabled(!true);
        // BOTÕES DA SEGUNDA ABA
        jBtNovo1.setEnabled(true);
        jBtAlterar1.setEnabled(true);
        jBtExcluir1.setEnabled(true);
        jBtSalvar1.setEnabled(!true);
        jBtCancelar1.setEnabled(!true);
        jBtImpressao1.setEnabled(true);
        jBtObservacao1.setEnabled(true);
        jBtBuscarRegPortaria1.setEnabled(!true);
        jBtAuditoriaPronCrc1.setEnabled(true);
        jBtBiometria.setEnabled(true);
        jBtImportarProntuario.setEnabled(!true);
    }

    public void Cancelar() {

        if (jIdInterno.getText().equals("")) {
            // Limpar campos para inclusão
            jIdInterno.setText("");
            jMatriculaPenal.setText("");
            jDataCadastro.setDate(null);
            jDataNascimento.setDate(null);
            jDataEntrada.setDate(null);
            jDataEntrada.setDate(null);
            jDataCrime.setDate(null);
            jDataPrisao.setDate(null);
            jDataCondenacao.setDate(null);
            jDataTerPena.setDate(null);
            jLabelFotoInterno.setIcon(null);
            jFotoPerfil.setIcon(null);
            jFotoCorpo.setIcon(null);
            jFotoCorpo1.setIcon(null);
            jFotoCorpo2.setIcon(null);
            // caminho = "";
            caminhoFotoPerfil = "";
            caminhoFotoCorpo = "";
            caminhoFotoCorpo1 = "";
            caminhoFotoCorpo2 = "";
            caminhoFotoCorpo3 = "";
            caminhoPolegarDireito = "";
            caminhoIndicadorDireito = "";
            caminhoMedioDireito = "";
            caminhoAnularDireito = "";
            caminhoMininoDireito = "";
            caminhoPolegarEsquerdo = "";
            caminhoIndicadorEsquerdo = "";
            caminhoMedioEsquerdo = "";
            caminhoAnularEsquerdo = "";
            caminhoMininoEsquerdo = "";
            jNomeInterno.setText("");
            jMaeInterno.setText("");
            jPaiInterno.setText("");
            jAlcunha.setText("");
            jRGInterno.setText("");
            jComboBoxUF.setSelectedItem("AC");
            jCPFInterno.setText("");
            jCartaoSus.setText("");
            jComboBoxEscolaridade.setSelectedItem("");
            jComboBoxEstadoCivil.setSelectedItem("");
            jComboBoxSexo.setSelectedItem("");
            jSituacao.setText("");
            jComboBoxCutis.setSelectedItem("");
            jComboBoxOlhos.setSelectedItem("");
            jComboBoxCabelos.setSelectedItem("");
            jComboBoxBarba.setSelectedItem("");
            jComboBoxBigode.setSelectedItem("");
            jComboBoxNariz.setSelectedItem("");
            jComboBoxBoca.setSelectedItem("");
            jComboBoxRosto.setSelectedItem("");
            jComboBoxLabios.setSelectedItem("");
            jComboBoxParticipacao.setSelectedItem("");
            jComboBoxRegime.setSelectedItem("");
            jComboBoxEdiondo.setSelectedItem("");
            jComboBoxPais.setText("");
            jComboBoxCidade.setText("");
            jComboBoxUnid.setText("");
            jReligiao.setText("");
            jProfissao.setText("");
            jEndereco.setText("");
            jBairro.setText("");
            jCNC.setText("");
            jCidade.setText("");
            jEstado.setText("");
            jTelefone.setText("");
            jTelefone1.setText("");
            jCelular.setText("");
            jCamisa.setText("");
            jCalca.setText("");
            jSapato.setText("");
            jPeso.setText("");
            jAltura.setText("");
            jComboBoxOrelha.setSelectedItem(null);
            jComboBoxPescoco.setSelectedItem(null);
            jComboBoxCompleicao.setSelectedItem(null);
            jPena.setText("");
            jArtigo1.setText("");
            jArtigo2.setText("");
            jArtigo3.setText("");
            jParagrafo1.setText("");
            jParagrafo2.setText("");
            jParagrafo3.setText("");
            jIdentificador.setText("");
            jIdentificador1.setText("");
            jIdentificador2.setText("");
            jIdentificador3.setText("");
            jPerfil.setText("");
            jRegiaoCorpo.setText("");
            jRegiaoCorpo1.setText("");
            jRegiaoCorpo2.setText("");
            jVaraCondenacao.setText("");
            jDataNovaEntrada.setDate(null);
            jBtObservacao.setEnabled(!true);
            // Desabilitar os campos
            jMatriculaPenal.setEnabled(!true);
            jDataCadastro.setEnabled(!true);
            jDataNascimento.setEnabled(!true);
            jNomeInterno.setEnabled(!true);
            jMaeInterno.setEnabled(!true);
            jPaiInterno.setEnabled(!true);
            jAlcunha.setEnabled(!true);
            jRGInterno.setEnabled(!true);
            jComboBoxUF.setEnabled(!true);
            jCPFInterno.setEnabled(!true);
            jCartaoSus.setEnabled(!true);
            jComboBoxEscolaridade.setEnabled(!true);
            jComboBoxEstadoCivil.setEnabled(!true);
            jComboBoxSexo.setEnabled(!true);
            jSituacao.setEnabled(!true);
            jComboBoxPais.setEnabled(!true);
            jComboBoxCidade.setEnabled(!true);
            jReligiao.setEnabled(!true);
            jProfissao.setEnabled(!true);
            jEndereco.setEnabled(!true);
            jBairro.setEnabled(!true);
            jCidade.setEnabled(!true);
            jEstado.setEnabled(!true);
            jCNC.setEnabled(!true);
            jTelefone.setEnabled(!true);
            jTelefone1.setEnabled(!true);
            jCelular.setEnabled(!true);
            jComboBoxCutis.setEnabled(!true);
            jComboBoxOlhos.setEnabled(!true);
            jComboBoxCabelos.setEnabled(!true);
            jComboBoxBarba.setEnabled(!true);
            jComboBoxBigode.setEnabled(!true);
            jComboBoxNariz.setEnabled(!true);
            jComboBoxBoca.setEnabled(!true);
            jComboBoxRosto.setEnabled(!true);
            jComboBoxLabios.setEnabled(!true);
            jCamisa.setEnabled(!true);
            jCalca.setEnabled(!true);
            jSapato.setEnabled(!true);
            jPeso.setEnabled(!true);
            jAltura.setEnabled(!true);
            jParticularidade.setEnabled(!true);
            jComboBoxOrelha.setEnabled(!true);
            jComboBoxPescoco.setEnabled(!true);
            jComboBoxCompleicao.setEnabled(!true);
            jDataEntrada.setEnabled(!true);
            jComboBoxUnid.setEnabled(!true);
            jBtPesqUnidade.setEnabled(!true);
            jDataCrime.setEnabled(!true);
            jDataPrisao.setEnabled(!true);
            jDataCondenacao.setEnabled(!true);
            jComboBoxParticipacao.setEnabled(!true);
            jComboBoxRegime.setEnabled(!true);
            jPena.setEnabled(!true);
            jArtigo1.setEnabled(!true);
            jArtigo2.setEnabled(!true);
            jArtigo3.setEnabled(!true);
            jParagrafo1.setEnabled(!true);
            jParagrafo2.setEnabled(!true);
            jComboBoxEdiondo.setEnabled(!true);
            jParagrafo3.setEnabled(!true);
            jDataTerPena.setEnabled(!true);
            jIdentificador.setEnabled(!true);
            jIdentificador1.setEnabled(!true);
            jIdentificador2.setEnabled(!true);
            jIdentificador3.setEnabled(!true);
            jPerfil.setEnabled(!true);
            jRegiaoCorpo.setEnabled(!true);
            jRegiaoCorpo1.setEnabled(!true);
            jRegiaoCorpo2.setEnabled(!true);
            jVaraCondenacao.setEnabled(!true);
            jDataNovaEntrada.setEnabled(!true);
            // Habilitar/Desabilitar  Botões
            jBtZoonFoto.setEnabled(!true);
            jBtNovaFoto.setEnabled(!true);
            jBtExcluirFoto.setEnabled(!true);
            jBtPesqPais.setEnabled(!true);
            jBtPesqCidade.setEnabled(!true);
            jBtPesqCidadeEnd.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtWebCam.setEnabled(!true);
            jBtObservacao.setEnabled(!true);
            jBtAuditoriaPronCrc.setEnabled(!true);
            jBtPeculiaridadeCostas.setEnabled(!true);
            jBtPeculiaridadeFrente.setEnabled(!true);
            //
            jBtNovaFotoPerfil.setEnabled(!true);
            jBtExcluirFotoPerfil.setEnabled(!true);
            jBtNovaFotoCorpo.setEnabled(!true);
            jBtExcluirFotoCorpo.setEnabled(!true);
            jBtNovaFotoCorpo1.setEnabled(!true);
            jBtExcluirFotoCorpo1.setEnabled(!true);
            jBtNovaFotoCorpo2.setEnabled(!true);
            jBtExcluirCorpo2.setEnabled(!true);
            jBtImpressao.setEnabled(!true);
            jBtBuscarRegPortaria.setEnabled(!true);
            // BOTÕES DA SEGUNDA ABA
            jBtNovo1.setEnabled(true);
            jBtAlterar1.setEnabled(!true);
            jBtExcluir1.setEnabled(!true);
            jBtSalvar1.setEnabled(!true);
            jBtCancelar1.setEnabled(!true);
            jBtImpressao1.setEnabled(!true);
            jBtObservacao1.setEnabled(!true);
            jBtBuscarRegPortaria1.setEnabled(!true);
            jBtAuditoriaPronCrc1.setEnabled(!true);
            jBtBiometria.setEnabled(!true);
            jBtImportarProntuario.setEnabled(!true);
        } else {
            // Desabilitar os campos
            jMatriculaPenal.setEnabled(!true);
            jDataCadastro.setEnabled(!true);
            jDataNascimento.setEnabled(!true);
            jNomeInterno.setEnabled(!true);
            jMaeInterno.setEnabled(!true);
            jPaiInterno.setEnabled(!true);
            jAlcunha.setEnabled(!true);
            jRGInterno.setEnabled(!true);
            jComboBoxUF.setEnabled(!true);
            jCPFInterno.setEnabled(!true);
            jCartaoSus.setEnabled(!true);
            jComboBoxEscolaridade.setEnabled(!true);
            jComboBoxEstadoCivil.setEnabled(!true);
            jComboBoxSexo.setEnabled(!true);
            jSituacao.setEnabled(!true);
            jComboBoxPais.setEnabled(!true);
            jComboBoxCidade.setEnabled(!true);
            jReligiao.setEnabled(!true);
            jProfissao.setEnabled(!true);
            jEndereco.setEnabled(!true);
            jBairro.setEnabled(!true);
            jCNC.setEnabled(!true);
            jCidade.setEnabled(!true);
            jEstado.setEnabled(!true);
            jTelefone.setEnabled(!true);
            jTelefone1.setEnabled(!true);
            jCelular.setEnabled(!true);
            jComboBoxCutis.setEnabled(!true);
            jComboBoxOlhos.setEnabled(!true);
            jComboBoxCabelos.setEnabled(!true);
            jComboBoxBarba.setEnabled(!true);
            jComboBoxBigode.setEnabled(!true);
            jComboBoxNariz.setEnabled(!true);
            jComboBoxBoca.setEnabled(!true);
            jComboBoxRosto.setEnabled(!true);
            jComboBoxLabios.setEnabled(!true);
            jCamisa.setEnabled(!true);
            jCalca.setEnabled(!true);
            jSapato.setEnabled(!true);
            jPeso.setEnabled(!true);
            jAltura.setEnabled(!true);
            jParticularidade.setEnabled(!true);
            jComboBoxOrelha.setEnabled(!true);
            jComboBoxPescoco.setEnabled(!true);
            jComboBoxCompleicao.setEnabled(!true);
            jDataEntrada.setEnabled(!true);
            jComboBoxUnid.setEnabled(!true);
            jBtPesqUnidade.setEnabled(!true);
            jDataCrime.setEnabled(!true);
            jDataPrisao.setEnabled(!true);
            jDataCondenacao.setEnabled(!true);
            jComboBoxParticipacao.setEnabled(!true);
            jComboBoxRegime.setEnabled(!true);
            jPena.setEnabled(!true);
            jArtigo1.setEnabled(!true);
            jArtigo2.setEnabled(!true);
            jArtigo3.setEnabled(!true);
            jParagrafo1.setEnabled(!true);
            jParagrafo2.setEnabled(!true);
            jComboBoxEdiondo.setEnabled(!true);
            jParagrafo3.setEnabled(!true);
            jDataTerPena.setEnabled(!true);
            jIdentificador.setEnabled(!true);
            jIdentificador1.setEnabled(!true);
            jIdentificador2.setEnabled(!true);
            jIdentificador3.setEnabled(!true);
            jPerfil.setEnabled(!true);
            jRegiaoCorpo.setEnabled(!true);
            jRegiaoCorpo1.setEnabled(!true);
            jRegiaoCorpo2.setEnabled(!true);
            jVaraCondenacao.setEnabled(!true);
            jDataNovaEntrada.setEnabled(!true);
            // Habilitar/Desabilitar  Botões
            jBtZoonFoto.setEnabled(true);
            jBtNovaFoto.setEnabled(!true);
            jBtExcluirFoto.setEnabled(!true);
            jBtPesqPais.setEnabled(!true);
            jBtPesqCidade.setEnabled(!true);
            jBtPesqCidadeEnd.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtWebCam.setEnabled(!true);
            jBtObservacao.setEnabled(true);
            jBtImpressao.setEnabled(true);
            jBtBuscarRegPortaria.setEnabled(!true);
            jBtAuditoriaPronCrc.setEnabled(true);
            jBtPeculiaridadeCostas.setEnabled(true);
            jBtPeculiaridadeFrente.setEnabled(true);
            //
            jBtNovaFotoPerfil.setEnabled(!true);
            jBtExcluirFotoPerfil.setEnabled(!true);
            jBtNovaFotoCorpo.setEnabled(!true);
            jBtExcluirFotoCorpo.setEnabled(!true);
            jBtNovaFotoCorpo1.setEnabled(!true);
            jBtExcluirFotoCorpo1.setEnabled(!true);
            jBtNovaFotoCorpo2.setEnabled(!true);
            jBtExcluirCorpo2.setEnabled(!true);
            // BOTÕES DA SEGUNDA ABA
            jBtNovo1.setEnabled(true);
            jBtAlterar1.setEnabled(true);
            jBtExcluir1.setEnabled(true);
            jBtSalvar1.setEnabled(!true);
            jBtCancelar1.setEnabled(!true);
            jBtImpressao1.setEnabled(true);
            jBtObservacao1.setEnabled(true);
            jBtBuscarRegPortaria1.setEnabled(!true);
            jBtAuditoriaPronCrc1.setEnabled(true);
            jBtBiometria.setEnabled(!true);
            jBtImportarProntuario.setEnabled(!true);
        }
    }

    // Mascara dos campos
    public void formatarCampos() {

        try {
            //        MaskFormatter cpf = new MaskFormatter("###.###.###-##");
//        jCPFInterno.setFormatterFactory(new DefaultFormatterFactory(cpf));
//        MaskFormatter rg = new MaskFormatter("##.###.###-##");
//        jRGInterno.setFormatterFactory(new DefaultFormatterFactory(rg));
            MaskFormatter telefone = new MaskFormatter("(###)####-####");
            jTelefone.setFormatterFactory(new DefaultFormatterFactory(telefone));
            MaskFormatter telefone1 = new MaskFormatter("(###)####-####");
            jTelefone1.setFormatterFactory(new DefaultFormatterFactory(telefone1));
            MaskFormatter celular = new MaskFormatter("(###)####-####");
            jCelular.setFormatterFactory(new DefaultFormatterFactory(celular));
            jCartaoSus.setDocument(new LimiteDigitosSoNum(20));
            jPesqNome.setDocument(new LimiteDigitos(50));
            jPesqMatricula.setDocument(new LimiteDigitosAlfa(15));
            jNomeInterno.setDocument(new LimiteDigitos(50));
            jMatriculaPenal.setDocument(new LimiteDigitosAlfa(16));
            jMaeInterno.setDocument(new LimiteDigitos(50));
            jPaiInterno.setDocument(new LimiteDigitos(50));
            jAlcunha.setDocument(new LimiteDigitosAlfa(30));
            jSituacao.setDocument(new LimiteDigitosAlfa(50));
            jReligiao.setDocument(new LimiteDigitos(18));
            jProfissao.setDocument(new LimiteDigitos(35));
            jEndereco.setDocument(new LimiteDigitosAlfa(50));
            jBairro.setDocument(new LimiteDigitosAlfa(24));
            jCidade.setDocument(new LimiteDigitosAlfa(24));
            jEstado.setDocument(new LimiteDigitos(17));
            jCamisa.setDocument(new LimiteDigitosAlfa(3));
            jCalca.setDocument(new LimiteDigitosNum(2));
            jSapato.setDocument(new LimiteDigitosNum(2));
            jPeso.setDocument(new LimiteDigitosNum(8));
            jAltura.setDocument(new LimiteDigitosAlfa(4));
            jParticularidade.setDocument(new LimiteDigitosAlfa(13));
            jPena.setDocument(new LimiteDigitosAlfa(13));
            jArtigo1.setDocument(new LimiteDigitosNum(8));
            jArtigo2.setDocument(new LimiteDigitosNum(8));
            jArtigo3.setDocument(new LimiteDigitosNum(8));
            jParagrafo1.setDocument(new LimiteDigitosNum(8));
            jParagrafo2.setDocument(new LimiteDigitosNum(8));
            jParagrafo3.setDocument(new LimiteDigitosNum(8));
            jVaraCondenacao.setDocument(new LimiteDigitosAlfa(70));
        } catch (Exception e) {
        }

    }

    public void VERIFICAR_GRAVACAO_interno() {
        CONTROLE_DADOS_civil.LOCALIZAR_DADOS_PENAIS_interno(pPront);
    }

    public void DELETAR_REGISTRO_interno() {
        objProCrc.setIdInterno(Integer.valueOf(jIdInterno.getText()));
        objDafis.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
        try {
            CONTROLE_DADOS_fisicos.excluirDadosFisicos(objDadosFis);
            CONTROLE_DADOS_civil.excluirInternoCrc(objProCrc);
        } catch (Exception e) {
        }
    }

    public void PESQUISAR_EXISTENCIA_interno() {
        CONTROLE_DADOS_civil.pPESQUISA_EXISTENCIA_interno(pPront);
    }

    // Verificar se o interno já tem movimentação, não deixar excluir    
    public void pVERIFICAR_ENTRADA_internos() {
        statusMov = "Excluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        CONTROLE_DADOS_civil.pPESQUISA_ENTRADA_LOTE_interno(pPront);
        if (jIdInterno.getText().equals(codInternoCrc)) {
            JOptionPane.showMessageDialog(rootPane, "Esse interno não pode ser excluído, existe movimentação para o mesmo!!!");
        } else {
            objDadosPena.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
            objDadosFis.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
            objProCrc.setIdInterno(Integer.valueOf(jIdInterno.getText()));
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir PRONTUÁRIO selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                CONTROLE_DADOS_penais.excluirDadosPenais(objDadosPena);
                CONTROLE_DADOS_fisicos.excluirDadosFisicos(objDadosFis);
                CONTROLE_DADOS_civil.excluirInternoCrc(objProCrc);
                objLog();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso...");
                Excluir();
            }
        }
    }

    public void BUSCAR_CODIGO_interno() {
        CONTROLE_DADOS_civil.pPESQUISA_CODIGO_interno(pPront);
    }

    public void CONFIRMAR_REGISTRO_portaria() {
        CONTROLE_DADOS_civil.pPESQUISA_INTERNO_portaria(pPront);
    }

    public void VERIFICAR_PARAMETROS_crc() {
        CONTROLE_DADOS_civil.CONSULTAR_PARAMETROS_crc(pPront);
    }

    // Método de pesquisa pela Descrição
    public void PREENCHER_TABELA_nome(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome do Interno", "Situação", "Matricula Penal", "Data Entrada", "Data Cadastro", "CNC"};
        conecta.abrirConexao();
        conecta.executaSQL(sql);
        try {
            conecta.rs.first();
            do {
                count = count + 1;
                pSAIDA_temporaria = conecta.rs.getString("SituacaoCrc");
                if (pSAIDA_temporaria.equals("SAIDA TEMPORARIA")) {
                    pSAIDA_TEMP = pSAIDA_TEMP + 1;
                }
                pSAIDA_covid = conecta.rs.getString("SituacaoCrc");
                if (pSAIDA_covid.equals("PRISAO DOMICILIAR - COVID-19")) {
                    pSAIDA_COVID = pSAIDA_COVID + 1;
                }
                pENTRADA_UNIDADE = conecta.rs.getString("SituacaoCrc");
                if (pENTRADA_UNIDADE.equals("ENTRADA NA UNIDADE")) {
                    pATIVOS_ENTRADA = pATIVOS_ENTRADA + 1;
                }
                pRETORNO_UNIDADE = conecta.rs.getString("SituacaoCrc");
                if (pRETORNO_UNIDADE.equals("RETORNO A UNIDADE")) {
                    pATIVOS_RETORNO = pATIVOS_RETORNO + 1;
                }
                // Formatar a data Entrada
                dataEntrada = conecta.rs.getString("DataEntrada");
                String dia = dataEntrada.substring(8, 10);
                String mes = dataEntrada.substring(5, 7);
                String ano = dataEntrada.substring(0, 4);
                dataEntrada = dia + "/" + mes + "/" + ano;
                // Fortmatar data de Cadastro          
                dataCadastro = conecta.rs.getString("DataCadastCrc");
                String day = dataCadastro.substring(8, 10);
                String mesc = dataCadastro.substring(5, 7);
                String anoc = dataCadastro.substring(0, 4);
                dataCadastro = day + "/" + mesc + "/" + anoc;
                jtotalRegistros.setText(Integer.toString(count));
                jtotalRegistrosTMP.setText(Integer.toString(pSAIDA_TEMP = pSAIDA_TEMP));
                jtotalRegistrosPDC.setText(Integer.toString(pSAIDA_COVID = pSAIDA_COVID));
                pTOTAL_ATIVOS = pSAIDA_TEMP + pATIVOS_ENTRADA + pATIVOS_RETORNO;
                jtotalInternos_ATIVOS.setText(Integer.toString(pTOTAL_ATIVOS));
                dados.add(new Object[]{conecta.rs.getInt("IdInternoCrc"), conecta.rs.getString("NomeInternoCrc"), conecta.rs.getString("SituacaoCrc"), conecta.rs.getString("MatriculaCrc"), dataEntrada, dataCadastro, conecta.rs.getString("Cnc")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Dados não encontrado, use o botão TODOS \nPara pesquisar TODOS OS REGISTROS");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInterno.setRowSorter(new TableRowSorter(modelo)); //FAZER ORDENAMENTO NA TABLEA
        jTabelaInterno.setModel(modelo);
        jTabelaInterno.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaInterno.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTabelaInterno.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(2).setPreferredWidth(200);
        jTabelaInterno.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaInterno.getColumnModel().getColumn(3).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTabelaInterno.getColumnModel().getColumn(4).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(5).setPreferredWidth(100);
        jTabelaInterno.getColumnModel().getColumn(5).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(6).setPreferredWidth(100);
        jTabelaInterno.getColumnModel().getColumn(6).setResizable(false);
        jTabelaInterno.getTableHeader().setReorderingAllowed(false);
        jTabelaInterno.setAutoResizeMode(jTabelaInterno.AUTO_RESIZE_OFF);
        jTabelaInterno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        corNaLinha();
        conecta.desconecta();
    }

    public void corNaLinha() {
        DefaultTableCellRenderer tableCellRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (jComboBoxPesqSituacao.getSelectedItem().equals("Ativos")) {
                    Object psituacao_TMP = table.getValueAt(row, 2);
                    Object psaida_PDC = table.getValueAt(row, 2);
                    if (psituacao_TMP != null && pSAIDA_TEMPORARIA.equals(psituacao_TMP.toString())) {
                        comp.setForeground(Color.RED);
                        comp.setBackground(Color.WHITE);
                    } else if (psaida_PDC != null && pPRISAO_DOMICILIAR_COVID.equals(psaida_PDC.toString())) {
                        comp.setForeground(Color.BLUE);
                        comp.setBackground(Color.WHITE);
                    } else {
                        comp.setForeground(Color.BLACK);
                        comp.setBackground(Color.WHITE);
                    }
                }
                return comp;
            }
        };
        jTabelaInterno.setDefaultRenderer(Object.class, tableCellRenderer);
    }

    //Preencher tabela com todos os INTERNOS
    public void PREENCHER_TODOS_internos(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome do Interno", "Situação", "Matricula Penal", "Data Entrada", "Data Cadastro", "CNC"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1; // Contador de registros
                pSAIDA_temporaria = conecta.rs.getString("SituacaoCrc");
                if (pSAIDA_temporaria.equals("SAIDA TEMPORARIA")) {
                    pSAIDA_TEMP = pSAIDA_TEMP + 1;
                }
                pSAIDA_covid = conecta.rs.getString("SituacaoCrc");
                if (pSAIDA_covid.equals("PRISAO DOMICILIAR - COVID-19")) {
                    pSAIDA_COVID = pSAIDA_COVID + 1;
                }
                pENTRADA_UNIDADE = conecta.rs.getString("SituacaoCrc");
                if (pENTRADA_UNIDADE.equals("ENTRADA NA UNIDADE")) {
                    pATIVOS_ENTRADA = pATIVOS_ENTRADA + 1;
                }
                pRETORNO_UNIDADE = conecta.rs.getString("SituacaoCrc");
                if (pRETORNO_UNIDADE.equals("RETORNO A UNIDADE")) {
                    pATIVOS_RETORNO = pATIVOS_RETORNO + 1;
                }
                // Formatar a data Entrada
                dataEntrada = conecta.rs.getString("DataEntrada");
                String dia = dataEntrada.substring(8, 10);
                String mes = dataEntrada.substring(5, 7);
                String ano = dataEntrada.substring(0, 4);
                dataEntrada = dia + "/" + mes + "/" + ano;
                // Fortmatar data de Cadastro          
                dataCadastro = conecta.rs.getString("DataCadastCrc");
                String day = dataCadastro.substring(8, 10);
                String mesc = dataCadastro.substring(5, 7);
                String anoc = dataCadastro.substring(0, 4);
                dataCadastro = day + "/" + mesc + "/" + anoc;
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                jtotalRegistrosTMP.setText(Integer.toString(pSAIDA_TEMP = pSAIDA_TEMP));
                jtotalRegistrosPDC.setText(Integer.toString(pSAIDA_COVID = pSAIDA_COVID));
                pTOTAL_ATIVOS = pSAIDA_TEMP + pATIVOS_ENTRADA + pATIVOS_RETORNO;
                jtotalInternos_ATIVOS.setText(Integer.toString(pTOTAL_ATIVOS));
                dados.add(new Object[]{conecta.rs.getInt("IdInternoCrc"), conecta.rs.getString("NomeInternoCrc"), conecta.rs.getString("SituacaoCrc"), conecta.rs.getString("MatriculaCrc"), dataEntrada, dataCadastro, conecta.rs.getString("Cnc")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInterno.setRowSorter(new TableRowSorter(modelo)); //FAZER ORDENAMENTO NA TABLEA
        jTabelaInterno.setModel(modelo);
        jTabelaInterno.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaInterno.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTabelaInterno.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(2).setPreferredWidth(200);
        jTabelaInterno.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaInterno.getColumnModel().getColumn(3).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTabelaInterno.getColumnModel().getColumn(4).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(5).setPreferredWidth(100);
        jTabelaInterno.getColumnModel().getColumn(5).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(6).setPreferredWidth(100);
        jTabelaInterno.getColumnModel().getColumn(6).setResizable(false);
        jTabelaInterno.getTableHeader().setReorderingAllowed(false);
        jTabelaInterno.setAutoResizeMode(jTabelaInterno.AUTO_RESIZE_OFF);
        jTabelaInterno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        corNaLinha();
        conecta.desconecta();
    }

    // Método de pesquisa pela Matricula
    public void PREENCHER_TABELA_INTERNOS_matricula(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome do Interno", "Situação", "Matricula Penal", "Data Entrada", "Data Cadastro", "CNC"};
        conecta.abrirConexao();
        conecta.executaSQL(sql);
        try {
            conecta.rs.first();
            do {
                count = count + 1;
                pSAIDA_temporaria = conecta.rs.getString("SituacaoCrc");
                if (pSAIDA_temporaria.equals("SAIDA TEMPORARIA")) {
                    pSAIDA_TEMP = pSAIDA_TEMP + 1;
                }
                pSAIDA_covid = conecta.rs.getString("SituacaoCrc");
                if (pSAIDA_covid.equals("PRISAO DOMICILIAR - COVID-19")) {
                    pSAIDA_COVID = pSAIDA_COVID + 1;
                }
                pENTRADA_UNIDADE = conecta.rs.getString("SituacaoCrc");
                if (pENTRADA_UNIDADE.equals("ENTRADA NA UNIDADE")) {
                    pATIVOS_ENTRADA = pATIVOS_ENTRADA + 1;
                }
                pRETORNO_UNIDADE = conecta.rs.getString("SituacaoCrc");
                if (pRETORNO_UNIDADE.equals("RETORNO A UNIDADE")) {
                    pATIVOS_RETORNO = pATIVOS_RETORNO + 1;
                }
                // Formatar a data Entrada
                dataEntrada = conecta.rs.getString("DataEntrada");
                String dia = dataEntrada.substring(8, 10);
                String mes = dataEntrada.substring(5, 7);
                String ano = dataEntrada.substring(0, 4);
                dataEntrada = dia + "/" + mes + "/" + ano;
                // Fortmatar data de Cadastro          
                dataCadastro = conecta.rs.getString("DataCadastCrc");
                String day = dataCadastro.substring(8, 10);
                String mesc = dataCadastro.substring(5, 7);
                String anoc = dataCadastro.substring(0, 4);
                dataCadastro = day + "/" + mesc + "/" + anoc;
                jtotalRegistros.setText(Integer.toString(count));
                jtotalRegistrosTMP.setText(Integer.toString(pSAIDA_TEMP = pSAIDA_TEMP));
                jtotalRegistrosPDC.setText(Integer.toString(pSAIDA_COVID = pSAIDA_COVID));
                pTOTAL_ATIVOS = pSAIDA_TEMP + pATIVOS_ENTRADA + pATIVOS_RETORNO;
                jtotalInternos_ATIVOS.setText(Integer.toString(pTOTAL_ATIVOS));
                dados.add(new Object[]{conecta.rs.getInt("IdInternoCrc"), conecta.rs.getString("NomeInternoCrc"), conecta.rs.getString("SituacaoCrc"), conecta.rs.getString("MatriculaCrc"), dataEntrada, dataCadastro, conecta.rs.getString("Cnc")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Dados não encontrado, use o botão TODOS \nPara pesquisar TODOS OS REGISTROS");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInterno.setRowSorter(new TableRowSorter(modelo)); //FAZER ORDENAMENTO NA TABLEA
        jTabelaInterno.setModel(modelo);
        jTabelaInterno.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaInterno.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTabelaInterno.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(2).setPreferredWidth(200);
        jTabelaInterno.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaInterno.getColumnModel().getColumn(3).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTabelaInterno.getColumnModel().getColumn(4).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(5).setPreferredWidth(100);
        jTabelaInterno.getColumnModel().getColumn(5).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(6).setPreferredWidth(100);
        jTabelaInterno.getColumnModel().getColumn(6).setResizable(false);
        jTabelaInterno.getTableHeader().setReorderingAllowed(false);
        jTabelaInterno.setAutoResizeMode(jTabelaInterno.AUTO_RESIZE_OFF);
        jTabelaInterno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        corNaLinha();
        conecta.desconecta();
    }

    public void limparTabelaProntuario() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome do Interno", "Situação", "Matricula Penal", "Data Entrada", "Data Cadastro", "CNC"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInterno.setRowSorter(new TableRowSorter(modelo)); //FAZER ORDENAMENTO NA TABLEA  
        jTabelaInterno.setModel(modelo);
        jTabelaInterno.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaInterno.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTabelaInterno.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(2).setPreferredWidth(200);
        jTabelaInterno.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaInterno.getColumnModel().getColumn(3).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTabelaInterno.getColumnModel().getColumn(4).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(5).setPreferredWidth(100);
        jTabelaInterno.getColumnModel().getColumn(5).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(6).setPreferredWidth(100);
        jTabelaInterno.getColumnModel().getColumn(6).setResizable(false);
        jTabelaInterno.getTableHeader().setReorderingAllowed(false);
        jTabelaInterno.setAutoResizeMode(jTabelaInterno.AUTO_RESIZE_OFF);
        jTabelaInterno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabelaProntuario() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaInterno.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaInterno.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        jTabelaInterno.getColumnModel().getColumn(3).setCellRenderer(centralizado);
        jTabelaInterno.getColumnModel().getColumn(5).setCellRenderer(centralizado);
    }

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jIdInterno.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void confirmarRegistroPortaria() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENSENTRADAPORTARIA WHERE NomeInterno='" + jNomeInterno.getText() + "'");
            conecta.rs.first();
            nomeInterno = conecta.rs.getString("NomeInternoCrc");
        } catch (SQLException ex) {
        }
    }

    // Executar programa externo da webcam
    public void webCam() {
        try {
            Process p = Runtime.getRuntime().exec("C:\\SysConp\\MyCam/MyCam.exe");
            if (p.exitValue() == 0) {
                System.out.println("Programa terminou normalmente");
            }
        } catch (Exception e) {
        }
    }

    public void buscarCaminhoTempleteImagem() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PARAMETROSCRC");
            conecta.rs.first();
            // CAMINHOS DAS IMAGENS
            caminhoBiometria1 = conecta.rs.getString("CaminhoImagemCRCInterno");
            caminhoBiometria2 = conecta.rs.getString("CaminhoImagemCRCInterno");
            caminhoBiometria3 = conecta.rs.getString("CaminhoImagemCRCInterno");
            caminhoBiometria4 = conecta.rs.getString("CaminhoImagemCRCInterno");
            caminhoBiometria5 = conecta.rs.getString("CaminhoImagemCRCInterno");
            caminhoBiometria6 = conecta.rs.getString("CaminhoImagemCRCInterno");
            caminhoBiometria7 = conecta.rs.getString("CaminhoImagemCRCInterno");
            caminhoBiometria8 = conecta.rs.getString("CaminhoImagemCRCInterno");
            caminhoBiometria9 = conecta.rs.getString("CaminhoImagemCRCInterno");
            caminhoBiometria10 = conecta.rs.getString("CaminhoImagemCRCInterno");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void lerDigitaisCadastradas() {
        // LER A IMAGEM DA DIGITAL E MOSTRAR NA TELA
        try {
            BufferedImage imagem1;
            imagem1 = ImageIO.read(new File(caminhoBiometria1 + jIdInterno.getText() + "-" + jNomeInterno.getText() + "-Digital1-MD" + ".gif"));
            javax.swing.ImageIcon a = new javax.swing.ImageIcon(imagem1);
            jFotoPolegarDireito.setIcon(a);
            jFotoPolegarDireito.setIcon(new ImageIcon(a.getImage().getScaledInstance(jFotoPolegarDireito.getWidth(), jFotoPolegarDireito.getHeight(), Image.SCALE_DEFAULT)));
        } catch (Exception e) {
        }
        //
        try {
            BufferedImage imagem2;
            imagem2 = ImageIO.read(new File(caminhoBiometria2 + jIdInterno.getText() + "-" + jNomeInterno.getText() + "-Digital2-MD" + ".gif"));
            javax.swing.ImageIcon b = new javax.swing.ImageIcon(imagem2);
            jFotoIndicadorDireito.setIcon(b);
            jFotoIndicadorDireito.setIcon(new ImageIcon(b.getImage().getScaledInstance(jFotoIndicadorDireito.getWidth(), jFotoIndicadorDireito.getHeight(), Image.SCALE_DEFAULT)));
        } catch (Exception e) {
        }
        //
        try {
            BufferedImage imagem3;
            imagem3 = ImageIO.read(new File(caminhoBiometria3 + jIdInterno.getText() + "-" + jNomeInterno.getText() + "-Digital3-MD" + ".gif"));
            javax.swing.ImageIcon c = new javax.swing.ImageIcon(imagem3);
            jFotoMedioDireito.setIcon(c);
            jFotoMedioDireito.setIcon(new ImageIcon(c.getImage().getScaledInstance(jFotoMedioDireito.getWidth(), jFotoMedioDireito.getHeight(), Image.SCALE_DEFAULT)));
        } catch (Exception e) {
        }
        //
        try {
            BufferedImage imagem4;
            imagem4 = ImageIO.read(new File(caminhoBiometria4 + jIdInterno.getText() + "-" + jNomeInterno.getText() + "-Digital4-MD" + ".gif"));
            javax.swing.ImageIcon d = new javax.swing.ImageIcon(imagem4);
            jFotoAnularDireito.setIcon(d);
            jFotoAnularDireito.setIcon(new ImageIcon(d.getImage().getScaledInstance(jFotoAnularDireito.getWidth(), jFotoAnularDireito.getHeight(), Image.SCALE_DEFAULT)));
        } catch (Exception e) {
        }
        try {
            BufferedImage imagem5;
            imagem5 = ImageIO.read(new File(caminhoBiometria5 + jIdInterno.getText() + "-" + jNomeInterno.getText() + "-Digital5-MD" + ".gif"));
            javax.swing.ImageIcon e = new javax.swing.ImageIcon(imagem5);
            jFotoMininoDireito.setIcon(e);
            jFotoMininoDireito.setIcon(new ImageIcon(e.getImage().getScaledInstance(jFotoMininoDireito.getWidth(), jFotoMininoDireito.getHeight(), Image.SCALE_DEFAULT)));
        } catch (Exception e) {
        }
        //
        try {
            BufferedImage imagem6;
            imagem6 = ImageIO.read(new File(caminhoBiometria6 + jIdInterno.getText() + "-" + jNomeInterno.getText() + "-Digital6-ME" + ".gif"));
            javax.swing.ImageIcon f = new javax.swing.ImageIcon(imagem6);
            jFotoPolegarEsquerdo.setIcon(f);
            jFotoPolegarEsquerdo.setIcon(new ImageIcon(f.getImage().getScaledInstance(jFotoPolegarEsquerdo.getWidth(), jFotoPolegarEsquerdo.getHeight(), Image.SCALE_DEFAULT)));
        } catch (Exception e) {
        }
        try {
            BufferedImage imagem7;
            imagem7 = ImageIO.read(new File(caminhoBiometria4 + jIdInterno.getText() + "-" + jNomeInterno.getText() + "-Digital7-ME" + ".gif"));
            javax.swing.ImageIcon g = new javax.swing.ImageIcon(imagem7);
            jFotoIndicadorEsquerdo.setIcon(g);
            jFotoIndicadorEsquerdo.setIcon(new ImageIcon(g.getImage().getScaledInstance(jFotoIndicadorEsquerdo.getWidth(), jFotoIndicadorEsquerdo.getHeight(), Image.SCALE_DEFAULT)));
        } catch (Exception e) {
        }
        try {
            BufferedImage imagem8;
            imagem8 = ImageIO.read(new File(caminhoBiometria5 + jIdInterno.getText() + "-" + jNomeInterno.getText() + "-Digital8-ME" + ".gif"));
            javax.swing.ImageIcon h = new javax.swing.ImageIcon(imagem8);
            jFotoMedioEsquerdo.setIcon(h);
            jFotoMedioEsquerdo.setIcon(new ImageIcon(h.getImage().getScaledInstance(jFotoMedioEsquerdo.getWidth(), jFotoMedioEsquerdo.getHeight(), Image.SCALE_DEFAULT)));
        } catch (Exception e) {
        }
        //
        try {
            BufferedImage imagem9;
            imagem9 = ImageIO.read(new File(caminhoBiometria9 + jIdInterno.getText() + "-" + jNomeInterno.getText() + "-Digital9-ME" + ".gif"));
            javax.swing.ImageIcon i = new javax.swing.ImageIcon(imagem9);
            jFotoAnularEsquerdo.setIcon(i);
            jFotoAnularEsquerdo.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoAnularEsquerdo.getWidth(), jFotoAnularEsquerdo.getHeight(), Image.SCALE_DEFAULT)));
        } catch (Exception e) {
        }
        //
        try {
            BufferedImage imagem10;
            imagem10 = ImageIO.read(new File(caminhoBiometria10 + jIdInterno.getText() + "-" + jNomeInterno.getText() + "-Digital10-ME" + ".gif"));
            javax.swing.ImageIcon j = new javax.swing.ImageIcon(imagem10);
            jFotoMinimoEsquerdo.setIcon(j);
            jFotoMinimoEsquerdo.setIcon(new ImageIcon(j.getImage().getScaledInstance(jFotoMinimoEsquerdo.getWidth(), jFotoMinimoEsquerdo.getHeight(), Image.SCALE_DEFAULT)));
        } catch (Exception e) {
        }
    }

    public void buscarAcessoUsuario(String nomeTelaAcesso) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nameUser + "'");
            conecta.rs.first();
            codigoUserTRI = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUserTRI + "'");
            conecta.rs.first();
            codigoUserGroupTRI = conecta.rs.getInt("IdUsuario");
            codigoGrupoTRI = conecta.rs.getInt("IdGrupo");
            nomeGrupoTRI = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUserTRI + "' "
                    + "AND NomeTela='" + nomeTelaAcesso + "'");
            conecta.rs.first();
            codUserAcessoTRI = conecta.rs.getInt("IdUsuario");
            codAbrirTRI = conecta.rs.getInt("Abrir");
            codIncluirTRI = conecta.rs.getInt("Incluir");
            codAlterarTRI = conecta.rs.getInt("Alterar");
            codExcluirTRI = conecta.rs.getInt("Excluir");
            codGravarTRI = conecta.rs.getInt("Gravar");
            codConcultarTRI = conecta.rs.getInt("Consultar");
            nomeTelaTRI = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
