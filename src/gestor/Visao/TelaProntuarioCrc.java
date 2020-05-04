/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleDadosFisicos;
import gestor.Controle.ControleDadosPenais;
import gestor.Controle.ControleDocInternosFaltando;
import gestor.Controle.ControleInternoCrc;
import gestor.Controle.ControleLogSistema;
import gestor.Dao.ConexaoBancoDados;
import Utilitarios.LimiteDigitos;
import Utilitarios.LimiteDigitosAlfa;
import Utilitarios.LimiteDigitosNum;
import Utilitarios.LimiteDigitosSoNum;
import Utilitarios.ModeloTabela;
import gestor.Modelo.DadosFisicosInternos;
import gestor.Modelo.DadosPenaisCrc;
import gestor.Modelo.LogSistema;
import gestor.Modelo.ProntuarioCrc;
import gestor.Modelo.ProntuarioFisicosPenaisInternos;
import static gestor.Visao.TelaLoginSenha.descricaoUnidade;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloCRC.codAbrirCRC;
import static gestor.Visao.TelaModuloCRC.codAlterarCRC;
import static gestor.Visao.TelaModuloCRC.codConsultarCRC;
import static gestor.Visao.TelaModuloCRC.codExcluirCRC;
import static gestor.Visao.TelaModuloCRC.codGravarCRC;
import static gestor.Visao.TelaModuloCRC.codIncluirCRC;
import static gestor.Visao.TelaModuloCRC.codUserAcessoCRC;
import static gestor.Visao.TelaModuloCRC.codigoGrupoCRC;
import static gestor.Visao.TelaModuloCRC.codigoUserCRC;
import static gestor.Visao.TelaModuloCRC.codigoUserGroupCRC;
import static gestor.Visao.TelaModuloCRC.nomeGrupoCRC;
import static gestor.Visao.TelaModuloCRC.nomeTelaCRC;
import static gestor.Visao.TelaModuloCRC.telaCadastroProntuarioBuscarEntCRC;
import static gestor.Visao.TelaModuloCRC.telaCadastroProntuarioDocCRC;
import static gestor.Visao.TelaModuloCRC.telaCadastroProntuarioImportCRC;
import static gestor.Visao.TelaModuloCRC.telaCadastroProntuarioManuCRC;
import static gestor.Visao.TelaModuloCRC.telaCadastroProntuarioObsCRC;
import static gestor.Visao.TelaModuloCRC.telaCadastroProntuarioPecCosCRC;
import static gestor.Visao.TelaModuloCRC.telaCadastroProntuarioPecFreCRC;
import static gestor.Visao.TelaModuloCRC.telaCadastroProntuarioPrintCRC;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import java.awt.Color;
import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author user
 */
public final class TelaProntuarioCrc extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ProntuarioCrc objProCrc = new ProntuarioCrc();
    DadosPenaisCrc objDadosPena = new DadosPenaisCrc();
    DadosFisicosInternos objDadosFis = new DadosFisicosInternos();
    ControleInternoCrc control = new ControleInternoCrc();
    ControleDadosFisicos controlFisicos = new ControleDadosFisicos();
    ControleDadosPenais controlPenais = new ControleDadosPenais();
    //
    ProntuarioFisicosPenaisInternos pPront = new ProntuarioFisicosPenaisInternos();
    // GRAVAR DOCUMENTOS DO INTERNO FALTANDO.
    ControleDocInternosFaltando controleDoc = new ControleDocInternosFaltando();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    public static int acao;
    int flag;
    String codInternoCrc; // Verificar se existe movimentação do intero para não ser excluído
    String nomePais;
    String dataEntrada;
    String dataCadastro;
    public static String caminho = "";
    String caminhoFotoPerfil = "";
    String caminhoFotoCorpo = "";
    String caminhoFotoCorpo1 = "";
    String caminhoFotoCorpo2 = "";
    String caminhoFotoCorpo3 = "";
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
    String nomeInternoCrc;
    String nomeMaeInterno;
    // Variáveis para gravar o log
    String nomeModuloTela = "CRC:Prontuário de Internos";
    String statusMov;
    String horaMov;
    String dataModFinal;
    //
    String nomeUsuarioCrc = "ADMINISTRADOR DO SISTEMA"; // Para poder alterar a situação do interno
    String usuarioAutorizado;
    String nomeInterno; // Para pesquisa do interno no registroda portaria, bloquear.
    String confirmaEntrada = "Sim"; // Confirma a utilização do registro do interno iniciado na portaria.
    String codParametrosEntrada;
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
    //
    String codProc;
    String codProdDoc;
    String codIncPen;
    String dataFicha, dataAmparo, dataInicial, dataFinal, dataDoc, dataInicioProcesso, dataTerminoProcesso;
    String codigoFichaJuridica;
    String codigoInterno;
    String codIntPenal;
    //
    String confirmarTransf = "Sim";
    //DOCUMENTAÇÃO DO INTERNO
    public static Object[] obj;
    public static int pTotalDocumentos = 0;
    public static int codigoDocumento = 0;
    String idDocumento;
    int c_INTERNO;
    int c_REGISTRO;
    int idChek;
    //
    String codigoCheck;
    //
    byte[] persona_imagem = null;
    byte[] persona_imagem1 = null;
    byte[] persona_imagem2 = null;
    byte[] persona_imagem3 = null;
    byte[] persona_imagem4 = null;
    //
    int pSAIDA_TEMP = 0;
    int pSAIDA_COVID = 0;
    String pSAIDA_temporaria = "";
    String pSAIDA_covid = "";
    //
//    String psaida_TMP = "";

    /**
     * Creates new form TelaTriagem
     */
// VARIÁVEL PARA MOSTRAR FOTO NO JDIALOG (TELAFOTO)
//    public static int codInternocrc;    
    // BUSCAR TELA DE FOTO MAIOR
    public static TelaFotoCrc telafotocrc;
    public static TelaPeculiaridade telaPeculiaridade;
    public static TelaPeculiaridadeFrente telaPeculiaridadeFrente;
    public static TelaPesquisaExternaInterno telaPesquisaExterna;
    public static PdfView pdfView;
    public static TelaDocumentosInternos docInternos;
    public static TelaFasesPersecucao fasesPersecucao;

    //
    public TelaProntuarioCrc() {
        super();
        initComponents();
        setResizable(false);
        corCampos();
        formatarCampos();
        buscarCaminhoTempleteImagem();
    }

    public void mostraTelaFotoCrc() {
        telafotocrc = new TelaFotoCrc(this, true);
        telafotocrc.setVisible(true);
    }

    public void mostrarTelaPeculiaridade() {
        telaPeculiaridade = new TelaPeculiaridade(this, true);
        telaPeculiaridade.setVisible(true);
    }

    public void mostrarTelaPeculiaridadeFrente() {
        telaPeculiaridadeFrente = new TelaPeculiaridadeFrente(this, true);
        telaPeculiaridadeFrente.setVisible(true);
    }

    public void mostrarTelaPesquisaExterna() {
        telaPesquisaExterna = new TelaPesquisaExternaInterno(this, true);
        telaPesquisaExterna.setVisible(true);
    }

    public void mostrarDocumentosPDF() {
        pdfView = new PdfView(this, true);
        pdfView.setVisible(true);
    }

    public void mostrarDocumentos() {
        docInternos = new TelaDocumentosInternos(this, true);
        docInternos.setVisible(true);
    }

    public void mostrarFasePersecucao() {
        fasesPersecucao = new TelaFasesPersecucao(this, true);
        fasesPersecucao.setVisible(true);
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
        jLabel160 = new javax.swing.JLabel();
        jComboBoxPesqSituacao = new javax.swing.JComboBox();
        jLabel161 = new javax.swing.JLabel();
        jPesqCodigo = new javax.swing.JTextField();
        jBtPesqCodigo = new javax.swing.JButton();
        jBtPesqSitucao = new javax.swing.JButton();
        jLabel163 = new javax.swing.JLabel();
        jPesquisaCNC = new javax.swing.JTextField();
        jBtCNCPesquisa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaInterno = new javax.swing.JTable();
        jPanel30 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel51 = new javax.swing.JPanel();
        jLabel194 = new javax.swing.JLabel();
        jPanel52 = new javax.swing.JPanel();
        jtotalRegistrosTMP = new javax.swing.JLabel();
        jPanel53 = new javax.swing.JPanel();
        jLabel195 = new javax.swing.JLabel();
        jPanel54 = new javax.swing.JPanel();
        jtotalRegistrosPDC = new javax.swing.JLabel();
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
        jLabel162 = new javax.swing.JLabel();
        jCNC = new javax.swing.JTextField();
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
        jBtPDF = new javax.swing.JButton();
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
        jComboBoxUnid = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        jVaraCondenacao = new javax.swing.JTextField();
        jLabel159 = new javax.swing.JLabel();
        jDataNovaEntrada = new com.toedter.calendar.JDateChooser();
        jTabbedPane6 = new javax.swing.JTabbedPane();
        jPanel48 = new javax.swing.JPanel();
        jPanel49 = new javax.swing.JPanel();
        jArtigo1 = new javax.swing.JTextField();
        jArtigo2 = new javax.swing.JTextField();
        jArtigo3 = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jParagrafo1 = new javax.swing.JTextField();
        jParagrafo2 = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jParagrafo3 = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jComboBoxEdiondo = new javax.swing.JComboBox();
        jLabel55 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jDataTerPena = new com.toedter.calendar.JDateChooser();
        jComboBoxDocumentacaoCompleta = new javax.swing.JComboBox<>();
        jLabel192 = new javax.swing.JLabel();
        jLabel193 = new javax.swing.JLabel();
        jComboBoxTornozeleira = new javax.swing.JComboBox<>();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTabelaDocumentos = new javax.swing.JTable();
        jPanel50 = new javax.swing.JPanel();
        jBtExcluirRegistro = new javax.swing.JButton();
        jBtAdicionarDocumento = new javax.swing.JButton();
        jComboBoxQuaisDocumentosFaltam = new javax.swing.JComboBox<>();
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
        jPanel18 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jFotoPolegarDireito = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jFotoIndicadorDireito = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jFotoMedioDireito = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jFotoAnularDireito = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jFotoMininoDireito = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jFotoPolegarEsquerdo = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jFotoIndicadorEsquerdo = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jFotoMedioEsquerdo = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jFotoAnularEsquerdo = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jFotoMinimoEsquerdo = new javax.swing.JLabel();
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
        jBtFasesPersecucao = new javax.swing.JButton();
        jPanel34 = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        jLabel74 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
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
        jBtPeculiaridadeFrente = new javax.swing.JButton();
        jPanel36 = new javax.swing.JPanel();
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
        jPanel40 = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel43 = new javax.swing.JPanel();
        jNumeroProcesso = new javax.swing.JTextField();
        jLabel164 = new javax.swing.JLabel();
        jNumeroInquerito = new javax.swing.JTextField();
        jLabel165 = new javax.swing.JLabel();
        jLabel166 = new javax.swing.JLabel();
        jComboBoxRegimeProcesso = new javax.swing.JComboBox();
        jDataInicioProcesso = new com.toedter.calendar.JDateChooser();
        jTotalDias = new javax.swing.JTextField();
        jMeses = new javax.swing.JTextField();
        jDias = new javax.swing.JTextField();
        jLabel167 = new javax.swing.JLabel();
        jLabel168 = new javax.swing.JLabel();
        jAnos = new javax.swing.JTextField();
        jLabel169 = new javax.swing.JLabel();
        jLabel170 = new javax.swing.JLabel();
        jDataTerminoProcesso = new com.toedter.calendar.JDateChooser();
        jLabel171 = new javax.swing.JLabel();
        jLabel172 = new javax.swing.JLabel();
        jLabel173 = new javax.swing.JLabel();
        jComboBoxSentenca = new javax.swing.JComboBox();
        jLabel174 = new javax.swing.JLabel();
        jLabel175 = new javax.swing.JLabel();
        jComboBoxTipoSentencaCondenatoria = new javax.swing.JComboBox();
        jComboBoxSituacaoPresoProcesso = new javax.swing.JComboBox();
        jLabel176 = new javax.swing.JLabel();
        jLabel177 = new javax.swing.JLabel();
        jLabel178 = new javax.swing.JLabel();
        jLabel179 = new javax.swing.JLabel();
        jPanel44 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jObservacaoProcesso = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabelaProcesso = new javax.swing.JTable();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel45 = new javax.swing.JPanel();
        jDescricaoAmparoLegal = new javax.swing.JTextField();
        jLabel185 = new javax.swing.JLabel();
        jIdAmparo = new javax.swing.JTextField();
        jLabel181 = new javax.swing.JLabel();
        jLabel180 = new javax.swing.JLabel();
        jLabel184 = new javax.swing.JLabel();
        jComboBoxAlinea = new javax.swing.JTextField();
        jComboBoxArtigo = new javax.swing.JTextField();
        jLabel182 = new javax.swing.JLabel();
        jComboBoxParagrafo = new javax.swing.JTextField();
        jLabel183 = new javax.swing.JLabel();
        jComboBoxInciso = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTabelaAmparoLegal = new javax.swing.JTable();
        jPanel46 = new javax.swing.JPanel();
        jLabel186 = new javax.swing.JLabel();
        jIdNatp = new javax.swing.JTextField();
        jLabel187 = new javax.swing.JLabel();
        jDescricaoNaturezaPrisao = new javax.swing.JTextField();
        jLabel188 = new javax.swing.JLabel();
        jDocumentoPrisao = new javax.swing.JTextField();
        jOrigemDocumentoPrisao = new javax.swing.JTextField();
        jLabel189 = new javax.swing.JLabel();
        jLabel190 = new javax.swing.JLabel();
        jDataDocumentoPrisao = new com.toedter.calendar.JDateChooser();
        jHoraDocumento = new javax.swing.JTextField();
        jLabel191 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTabelaDocumentosProcesso = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Prontuário de Interno ::: ...");
        setToolTipText("");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

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

        jLabel160.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel160.setForeground(new java.awt.Color(255, 0, 0));
        jLabel160.setText("Situação:");

        jComboBoxPesqSituacao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxPesqSituacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ativos", "Inativos", "Evadidos" }));
        jComboBoxPesqSituacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel161.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel161.setText("Código:");

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

        jLabel163.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel163.setText("CNC:");

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
                                    .addComponent(jLabel163, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel160, javax.swing.GroupLayout.Alignment.TRAILING))
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
                                .addGap(0, 60, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel161, javax.swing.GroupLayout.Alignment.TRAILING)
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
                    .addComponent(jLabel160)
                    .addComponent(jBtPesqCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPesqCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel161))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(jPesqMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtMatricula)
                    .addComponent(jLabel163)
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

        jTabelaInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaInterno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome do Interno", "Situação", "Matricula Penal", "Data Entrada", "Data Cadastro", "CNC"
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
            jTabelaInterno.getColumnModel().getColumn(6).setMinWidth(100);
            jTabelaInterno.getColumnModel().getColumn(6).setMaxWidth(100);
        }

        jPanel30.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jLabel63.setText("Total de Registros:");

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel63))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel63)
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

        jPanel52.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jtotalRegistrosTMP.setForeground(new java.awt.Color(204, 0, 0));
        jtotalRegistrosTMP.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel52Layout = new javax.swing.GroupLayout(jPanel52);
        jPanel52.setLayout(jPanel52Layout);
        jPanel52Layout.setHorizontalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel52Layout.createSequentialGroup()
                .addGap(0, 4, Short.MAX_VALUE)
                .addComponent(jtotalRegistrosTMP, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel52Layout.setVerticalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistrosTMP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
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

        jPanel54.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jtotalRegistrosPDC.setForeground(new java.awt.Color(0, 0, 204));
        jtotalRegistrosPDC.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel54Layout = new javax.swing.GroupLayout(jPanel54);
        jPanel54.setLayout(jPanel54Layout);
        jPanel54Layout.setHorizontalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistrosPDC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel54Layout.setVerticalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistrosPDC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jPanel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(jPanel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(jPanel54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(10, 10, 10))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel32, jPanel52, jPanel54});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel30, jPanel31, jPanel32});

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
        jCPFInterno.setEnabled(false);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
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

        jBtNovaFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/7183_16x16.png"))); // NOI18N
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

        jLabel162.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel162.setText("CNC:");

        jCNC.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCNC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCNC.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(jComboBoxEscolaridade, 0, 189, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel17))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jRGInterno)
                                            .addComponent(jAlcunha))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCartaoSus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCPFInterno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxEstadoCivil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jDataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jIdInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jMatriculaPenal, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel162)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCNC))))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jNomeInterno)
                            .addComponent(jPaiInterno)
                            .addComponent(jMaeInterno))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jBtZoonFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtNovaFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtExcluirFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtWebCam, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jReligiao, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProfissao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jComboBoxCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBtPesqCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtPesqPais, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSituacao)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel60)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jComboBoxPais, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtExcluirFoto, jBtNovaFoto, jBtWebCam, jBtZoonFoto});

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jCPFInterno, jCartaoSus});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel5)
                            .addComponent(jIdInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jMatriculaPenal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel162)
                            .addComponent(jCNC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jRGInterno, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCPFInterno, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtZoonFoto, javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtNovaFoto, javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtExcluirFoto, javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtWebCam, javax.swing.GroupLayout.Alignment.CENTER))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel16)
                    .addComponent(jComboBoxEscolaridade, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jComboBoxEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jComboBoxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel18)
                    .addComponent(jComboBoxPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqPais, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel60))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel19)
                    .addComponent(jComboBoxCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jReligiao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(jProfissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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

        jBtAuditoriaPronCrc.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
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

        jBtPDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Pdf16.png"))); // NOI18N
        jBtPDF.setToolTipText("Adicionar Documentos dos Internos");
        jBtPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jBtNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtImpressao, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtImportarProntuario, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtBuscarRegPortaria, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtAuditoriaPronCrc, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(jBtImpressao)
                .addComponent(jBtImportarProntuario)
                .addComponent(jBtObservacao)
                .addComponent(jBtBuscarRegPortaria)
                .addComponent(jBtAuditoriaPronCrc)
                .addComponent(jBtSair)
                .addComponent(jBtCancelar)
                .addComponent(jBtSalvar)
                .addComponent(jBtExcluir)
                .addComponent(jBtAlterar)
                .addComponent(jBtNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jBtPDF))
        );

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
                    .addComponent(jBairro, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jEndereco)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jCidade))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqCidadeEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel42)
                                .addGap(3, 3, 3)))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCelular)
                            .addComponent(jEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))))
                .addContainerGap())
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
                    .addComponent(jBtPesqCidadeEnd)
                    .addComponent(jLabel25)
                    .addComponent(jEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(jTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(jTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42)
                    .addComponent(jCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jCelular, jTelefone, jTelefone1});

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
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
                    .addComponent(jComboBoxPescoco, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(jComboBoxOrelha, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addContainerGap())
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
                .addContainerGap(15, Short.MAX_VALUE))
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

        jTabbedPane6.setForeground(new java.awt.Color(0, 0, 204));
        jTabbedPane6.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jPanel48.setToolTipText("Artigos e Parágrafos");

        jPanel49.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

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

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel52.setText("Artigo 1:");

        jParagrafo3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jParagrafo3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jParagrafo3.setEnabled(false);

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel53.setText("Artigo 2:");

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel58.setText("Crime Hediondo:");

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel54.setText("Artigo 3:");

        jComboBoxEdiondo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxEdiondo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Sim", "Não" }));
        jComboBoxEdiondo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxEdiondo.setEnabled(false);

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel55.setText("Parágrafo 1:");

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel59.setText("Término Pena:");

        jDataTerPena.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataTerPena.setEnabled(false);

        jComboBoxDocumentacaoCompleta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDocumentacaoCompleta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "Não", "Sim" }));
        jComboBoxDocumentacaoCompleta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDocumentacaoCompleta.setEnabled(false);
        jComboBoxDocumentacaoCompleta.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxDocumentacaoCompletaItemStateChanged(evt);
            }
        });

        jLabel192.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel192.setForeground(new java.awt.Color(153, 0, 0));
        jLabel192.setText("Doc. Completa");
        jLabel192.setToolTipText("Documentação Completa");

        jLabel193.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel193.setForeground(new java.awt.Color(153, 0, 0));
        jLabel193.setText("Tornozeleira");

        jComboBoxTornozeleira.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTornozeleira.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "Não", "Sim", "Não sabe" }));
        jComboBoxTornozeleira.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTornozeleira.setEnabled(false);

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel49Layout.createSequentialGroup()
                        .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel58, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel54, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel52, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jArtigo3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jArtigo1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jComboBoxEdiondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel59, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel57, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel55, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jParagrafo1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDataTerPena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jParagrafo3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel49Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel53)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jArtigo2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel49Layout.createSequentialGroup()
                        .addComponent(jLabel56)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jParagrafo2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel192, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                    .addComponent(jLabel193)
                    .addComponent(jComboBoxDocumentacaoCompleta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxTornozeleira, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel193)
                    .addComponent(jParagrafo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel55)
                    .addComponent(jArtigo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel52))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxTornozeleira, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jParagrafo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56)
                    .addComponent(jArtigo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel54)
                    .addComponent(jArtigo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel57)
                    .addComponent(jParagrafo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel192))
                .addGap(7, 7, 7)
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxDocumentacaoCompleta, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataTerPena, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel59)
                    .addComponent(jComboBoxEdiondo, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel58))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane6.addTab("Artigos", jPanel48);

        jTabelaDocumentos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaDocumentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Registro", "Descrição do Documento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabelaDocumentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaDocumentosMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTabelaDocumentos);
        if (jTabelaDocumentos.getColumnModel().getColumnCount() > 0) {
            jTabelaDocumentos.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaDocumentos.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaDocumentos.getColumnModel().getColumn(1).setMinWidth(400);
            jTabelaDocumentos.getColumnModel().getColumn(1).setMaxWidth(400);
        }

        jPanel50.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtExcluirRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216104515_16.png"))); // NOI18N
        jBtExcluirRegistro.setToolTipText("Excluir Registro");
        jBtExcluirRegistro.setContentAreaFilled(false);
        jBtExcluirRegistro.setEnabled(false);
        jBtExcluirRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirRegistroActionPerformed(evt);
            }
        });

        jBtAdicionarDocumento.setForeground(new java.awt.Color(0, 102, 0));
        jBtAdicionarDocumento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/061218140238_16.png"))); // NOI18N
        jBtAdicionarDocumento.setToolTipText("Add Registro");
        jBtAdicionarDocumento.setContentAreaFilled(false);
        jBtAdicionarDocumento.setEnabled(false);
        jBtAdicionarDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAdicionarDocumentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtAdicionarDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtExcluirRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtAdicionarDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jComboBoxQuaisDocumentosFaltam.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxQuaisDocumentosFaltam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione..." }));
        jComboBoxQuaisDocumentosFaltam.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxQuaisDocumentosFaltam.setEnabled(false);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
                    .addComponent(jComboBoxQuaisDocumentosFaltam, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14)
                .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jComboBoxQuaisDocumentosFaltam, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane6.addTab("Doc.", jPanel11);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel45)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxUnid, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel72, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel49, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel46, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel44, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jDataCrime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jDataEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBoxParticipacao, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel50, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel47, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel159, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                            .addComponent(jPena, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jDataNovaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jVaraCondenacao, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane6)
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
                            .addComponent(jDataNovaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel159)
                            .addComponent(jDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel44))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxUnid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jBtNovaFotoPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/7183_16x16.png"))); // NOI18N
        jBtNovaFotoPerfil.setEnabled(false);
        jBtNovaFotoPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovaFotoPerfilActionPerformed(evt);
            }
        });

        jBtExcluirFotoPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirFotoPerfil.setEnabled(false);
        jBtExcluirFotoPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirFotoPerfilActionPerformed(evt);
            }
        });

        jBtNovaFotoCorpo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/7183_16x16.png"))); // NOI18N
        jBtNovaFotoCorpo.setEnabled(false);
        jBtNovaFotoCorpo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovaFotoCorpoActionPerformed(evt);
            }
        });

        jBtExcluirFotoCorpo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirFotoCorpo.setEnabled(false);
        jBtExcluirFotoCorpo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirFotoCorpoActionPerformed(evt);
            }
        });

        jBtNovaFotoCorpo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/7183_16x16.png"))); // NOI18N
        jBtNovaFotoCorpo1.setEnabled(false);
        jBtNovaFotoCorpo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovaFotoCorpo1ActionPerformed(evt);
            }
        });

        jBtExcluirFotoCorpo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirFotoCorpo1.setEnabled(false);
        jBtExcluirFotoCorpo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirFotoCorpo1ActionPerformed(evt);
            }
        });

        jBtNovaFotoCorpo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/7183_16x16.png"))); // NOI18N
        jBtNovaFotoCorpo2.setEnabled(false);
        jBtNovaFotoCorpo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovaFotoCorpo2ActionPerformed(evt);
            }
        });

        jBtExcluirCorpo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
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
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
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
                                        .addComponent(jLabel68)))))
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
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
                        .addComponent(jBtExcluirCorpo2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73))))
        );

        jPanel10Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel12, jPanel14, jPanel15, jPanel16});

        jPanel10Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jIdentificador, jIdentificador1, jIdentificador2, jIdentificador3, jPerfil, jRegiaoCorpo, jRegiaoCorpo1, jRegiaoCorpo2});

        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtExcluirFotoPerfil)
                    .addComponent(jBtNovaFotoPerfil)
                    .addComponent(jBtExcluirFotoCorpo)
                    .addComponent(jBtNovaFotoCorpo)
                    .addComponent(jBtExcluirFotoCorpo1)
                    .addComponent(jBtNovaFotoCorpo1)
                    .addComponent(jBtExcluirCorpo2)
                    .addComponent(jBtNovaFotoCorpo2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jIdentificador, jIdentificador1, jIdentificador2, jIdentificador3, jPerfil, jRegiaoCorpo, jRegiaoCorpo1, jRegiaoCorpo2});

        jTabbedPane2.addTab("Fotos", jPanel10);

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Série Direita", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 0, 255))); // NOI18N

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Polegar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 0, 255))); // NOI18N

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoPolegarDireito, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoPolegarDireito, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );

        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Indicador", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 0, 255))); // NOI18N

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoIndicadorDireito, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoIndicadorDireito, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );

        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Médio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 0, 255))); // NOI18N

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoMedioDireito, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoMedioDireito, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
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
            .addComponent(jFotoAnularDireito, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
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
            .addComponent(jFotoMininoDireito, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel18Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel20, jPanel21, jPanel22, jPanel23, jPanel24});

        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel18Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel20, jPanel21, jPanel22, jPanel23, jPanel24});

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Série Esquerda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 0, 255))); // NOI18N

        jPanel25.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Polegar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 0, 255))); // NOI18N

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoPolegarEsquerdo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoPolegarEsquerdo, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        jPanel26.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Indicador", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 0, 255))); // NOI18N

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoIndicadorEsquerdo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoIndicadorEsquerdo, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        jPanel27.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Médio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 0, 255))); // NOI18N

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoMedioEsquerdo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoMedioEsquerdo, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        jPanel28.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Anular", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 0, 255))); // NOI18N

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoAnularEsquerdo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoAnularEsquerdo, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        jPanel29.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mínimo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 0, 255))); // NOI18N

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoMinimoEsquerdo, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoMinimoEsquerdo, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        jPanel19Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel25, jPanel26, jPanel27, jPanel28, jPanel29});

        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel28, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel27, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel19Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel25, jPanel26, jPanel27, jPanel28, jPanel29});

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        jBtAuditoriaPronCrc1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
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

        jBtFasesPersecucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/061218140238_16.png"))); // NOI18N
        jBtFasesPersecucao.setToolTipText("Fases da Persecução");
        jBtFasesPersecucao.setContentAreaFilled(false);
        jBtFasesPersecucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFasesPersecucaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addComponent(jBtNovo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterar1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluir1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvar1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSair1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtImpressao1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtObservacao1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtBuscarRegPortaria1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAuditoriaPronCrc1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtFasesPersecucao, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(jBtImpressao1)
                .addComponent(jBtObservacao1)
                .addComponent(jBtBuscarRegPortaria1)
                .addComponent(jBtAuditoriaPronCrc1)
                .addComponent(jBtSair1)
                .addComponent(jBtCancelar1)
                .addComponent(jBtSalvar1)
                .addComponent(jBtExcluir1)
                .addComponent(jBtAlterar1)
                .addComponent(jBtNovo1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jBtFasesPersecucao))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 292, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Dados Fisicos/Penais", jPanel8);

        jPanel35.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel74.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel74.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/FRENTE_HOME_COMPLETO.jpg"))); // NOI18N

        jLabel76.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel76.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/FRENTE_HOMEM.jpg"))); // NOI18N

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

        jBtPeculiaridadeFrente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/folder_blue_open.png"))); // NOI18N
        jBtPeculiaridadeFrente.setEnabled(false);
        jBtPeculiaridadeFrente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPeculiaridadeFrenteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addComponent(jLabel76)
                        .addGap(107, 107, 107)
                        .addComponent(jBtPeculiaridadeFrente))
                    .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel74, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jBtPeculiaridadeFrente)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addComponent(jLabel76, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
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
            .addGap(0, 64, Short.MAX_VALUE)
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

        jPanel37Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel75, jPanel38});

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Peculiaridade Costas", jPanel36);

        jTabbedPane4.setForeground(new java.awt.Color(204, 0, 0));
        jTabbedPane4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jNumeroProcesso.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jNumeroProcesso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNumeroProcesso.setEnabled(false);

        jLabel164.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel164.setText("Nº. do Processo");

        jNumeroInquerito.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jNumeroInquerito.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNumeroInquerito.setEnabled(false);

        jLabel165.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel165.setText("Regime do Processo");

        jLabel166.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel166.setText("Nº.  do Inquérito");

        jComboBoxRegimeProcesso.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxRegimeProcesso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Fechado", "Semi-Aberto", "Aberto", "Provisório" }));
        jComboBoxRegimeProcesso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxRegimeProcesso.setEnabled(false);

        jDataInicioProcesso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataInicioProcesso.setEnabled(false);

        jTotalDias.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTotalDias.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTotalDias.setEnabled(false);

        jMeses.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jMeses.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMeses.setEnabled(false);

        jDias.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jDias.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDias.setEnabled(false);

        jLabel167.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel167.setText("Total de Dias");

        jLabel168.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel168.setText("Meses");

        jAnos.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jAnos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAnos.setEnabled(false);

        jLabel169.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel169.setText("Anos");

        jLabel170.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel170.setText("Data Inicio");

        jDataTerminoProcesso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataTerminoProcesso.setEnabled(false);

        jLabel171.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel171.setText("Data Término");

        jLabel172.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel172.setText("Dias");

        jLabel173.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel173.setText("Sentença");

        jComboBoxSentenca.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxSentenca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Terminativa", "Definitva", "Sem sentença", " ", " " }));
        jComboBoxSentenca.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxSentenca.setEnabled(false);

        jLabel174.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel174.setText("Tipo Sentença Condenatória");

        jLabel175.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel175.setText("Situação do Preso no Processo");

        jComboBoxTipoSentencaCondenatoria.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTipoSentencaCondenatoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Mérito", "Execução", "Provisória", "Definitiva" }));
        jComboBoxTipoSentencaCondenatoria.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTipoSentencaCondenatoria.setEnabled(false);

        jComboBoxSituacaoPresoProcesso.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxSituacaoPresoProcesso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Recluso", "Liberdade Provisória", " ", " " }));
        jComboBoxSituacaoPresoProcesso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxSituacaoPresoProcesso.setEnabled(false);

        jLabel176.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel176.setForeground(new java.awt.Color(204, 0, 0));
        jLabel176.setText("*");

        jLabel177.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel177.setForeground(new java.awt.Color(204, 0, 0));
        jLabel177.setText("*");

        jLabel178.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel178.setForeground(new java.awt.Color(204, 0, 0));
        jLabel178.setText("*");

        jLabel179.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel179.setForeground(new java.awt.Color(204, 0, 0));
        jLabel179.setText("*");

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel164)
                            .addComponent(jNumeroProcesso, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addGroup(jPanel43Layout.createSequentialGroup()
                                .addComponent(jLabel173)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel176))
                            .addComponent(jComboBoxSentenca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel43Layout.createSequentialGroup()
                                .addComponent(jLabel166)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel177))
                            .addComponent(jNumeroInquerito, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxTipoSentencaCondenatoria, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel174)))
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel43Layout.createSequentialGroup()
                                .addComponent(jAnos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel43Layout.createSequentialGroup()
                                .addComponent(jLabel169)
                                .addGap(22, 22, 22)))
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel168)
                            .addComponent(jMeses, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDias, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel172))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel43Layout.createSequentialGroup()
                                .addComponent(jLabel170)
                                .addGap(30, 30, 30))
                            .addComponent(jDataInicioProcesso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDataTerminoProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel171))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addComponent(jLabel167)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTotalDias)
                            .addComponent(jComboBoxSituacaoPresoProcesso, javax.swing.GroupLayout.Alignment.LEADING, 0, 206, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel43Layout.createSequentialGroup()
                                .addComponent(jLabel175)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel179))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel43Layout.createSequentialGroup()
                                .addComponent(jLabel165)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel178))
                            .addComponent(jComboBoxRegimeProcesso, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel43Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jComboBoxTipoSentencaCondenatoria, jNumeroInquerito});

        jPanel43Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jComboBoxSentenca, jNumeroProcesso});

        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel43Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel164)
                    .addComponent(jLabel166)
                    .addComponent(jLabel165)
                    .addComponent(jLabel177)
                    .addComponent(jLabel178))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jNumeroProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNumeroInquerito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxRegimeProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel173)
                    .addComponent(jLabel174)
                    .addComponent(jLabel175)
                    .addComponent(jLabel176)
                    .addComponent(jLabel179))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxSentenca, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTipoSentencaCondenatoria, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxSituacaoPresoProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel168)
                    .addComponent(jLabel169)
                    .addComponent(jLabel172)
                    .addComponent(jLabel170)
                    .addComponent(jLabel171)
                    .addComponent(jLabel167))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTotalDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataTerminoProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataInicioProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jMeses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jAnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        jTabbedPane4.addTab("Processos", jPanel43);

        jObservacaoProcesso.setColumns(20);
        jObservacaoProcesso.setRows(5);
        jObservacaoProcesso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jObservacaoProcesso.setEnabled(false);
        jScrollPane3.setViewportView(jObservacaoProcesso);

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane4.addTab("Observação do Processo", jPanel44);

        jTabelaProcesso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaProcesso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nr. Processo", "Nr. Inquérito", "Regime", "Anos", "Meses", "Dias", "Data Inicio", "Data Témino"
            }
        ));
        jTabelaProcesso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaProcessoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTabelaProcesso);
        if (jTabelaProcesso.getColumnModel().getColumnCount() > 0) {
            jTabelaProcesso.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaProcesso.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaProcesso.getColumnModel().getColumn(1).setMinWidth(100);
            jTabelaProcesso.getColumnModel().getColumn(1).setMaxWidth(100);
            jTabelaProcesso.getColumnModel().getColumn(2).setMinWidth(100);
            jTabelaProcesso.getColumnModel().getColumn(2).setMaxWidth(100);
            jTabelaProcesso.getColumnModel().getColumn(3).setMinWidth(70);
            jTabelaProcesso.getColumnModel().getColumn(3).setMaxWidth(70);
            jTabelaProcesso.getColumnModel().getColumn(4).setMinWidth(70);
            jTabelaProcesso.getColumnModel().getColumn(4).setMaxWidth(70);
            jTabelaProcesso.getColumnModel().getColumn(5).setMinWidth(70);
            jTabelaProcesso.getColumnModel().getColumn(5).setMaxWidth(70);
            jTabelaProcesso.getColumnModel().getColumn(6).setMinWidth(70);
            jTabelaProcesso.getColumnModel().getColumn(6).setMaxWidth(70);
            jTabelaProcesso.getColumnModel().getColumn(7).setMinWidth(70);
            jTabelaProcesso.getColumnModel().getColumn(7).setMaxWidth(70);
            jTabelaProcesso.getColumnModel().getColumn(8).setMinWidth(80);
            jTabelaProcesso.getColumnModel().getColumn(8).setMaxWidth(80);
        }

        jTabbedPane5.setForeground(new java.awt.Color(0, 0, 255));
        jTabbedPane5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jDescricaoAmparoLegal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDescricaoAmparoLegal.setEnabled(false);

        jLabel185.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel185.setText("Código");

        jIdAmparo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdAmparo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdAmparo.setEnabled(false);

        jLabel181.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel181.setText("Artigo");

        jLabel180.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel180.setText("Amparo Legal");

        jLabel184.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel184.setText("Alínea");

        jComboBoxAlinea.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jComboBoxAlinea.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxAlinea.setEnabled(false);

        jComboBoxArtigo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jComboBoxArtigo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxArtigo.setEnabled(false);

        jLabel182.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel182.setText("Parágrafo");

        jComboBoxParagrafo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jComboBoxParagrafo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxParagrafo.setEnabled(false);

        jLabel183.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel183.setText("Inciso");

        jComboBoxInciso.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jComboBoxInciso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxInciso.setEnabled(false);

        jTabelaAmparoLegal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaAmparoLegal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Amparo legal", "Artigo", "Parágrafo", "Inciso", "Alínea"
            }
        ));
        jTabelaAmparoLegal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaAmparoLegalMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTabelaAmparoLegal);
        if (jTabelaAmparoLegal.getColumnModel().getColumnCount() > 0) {
            jTabelaAmparoLegal.getColumnModel().getColumn(0).setMinWidth(80);
            jTabelaAmparoLegal.getColumnModel().getColumn(0).setMaxWidth(80);
            jTabelaAmparoLegal.getColumnModel().getColumn(1).setMinWidth(310);
            jTabelaAmparoLegal.getColumnModel().getColumn(1).setMaxWidth(310);
            jTabelaAmparoLegal.getColumnModel().getColumn(2).setMinWidth(50);
            jTabelaAmparoLegal.getColumnModel().getColumn(2).setMaxWidth(50);
            jTabelaAmparoLegal.getColumnModel().getColumn(3).setMinWidth(100);
            jTabelaAmparoLegal.getColumnModel().getColumn(3).setMaxWidth(100);
            jTabelaAmparoLegal.getColumnModel().getColumn(4).setMinWidth(50);
            jTabelaAmparoLegal.getColumnModel().getColumn(4).setMaxWidth(50);
            jTabelaAmparoLegal.getColumnModel().getColumn(5).setMinWidth(50);
            jTabelaAmparoLegal.getColumnModel().getColumn(5).setMaxWidth(50);
        }

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel185, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jIdAmparo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel45Layout.createSequentialGroup()
                                .addComponent(jLabel180)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jDescricaoAmparoLegal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel181)
                            .addComponent(jComboBoxArtigo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxParagrafo, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel182, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel183, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxInciso, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel184, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxAlinea, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel185)
                            .addComponent(jLabel180)
                            .addComponent(jLabel183)
                            .addComponent(jLabel184))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jDescricaoAmparoLegal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jIdAmparo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxInciso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxAlinea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addComponent(jLabel181)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxArtigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addComponent(jLabel182)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxParagrafo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Incidência Penal", jPanel45);

        jLabel186.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel186.setText("Código");

        jIdNatp.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdNatp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdNatp.setEnabled(false);

        jLabel187.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel187.setText("Natureza da Prisão");

        jDescricaoNaturezaPrisao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDescricaoNaturezaPrisao.setEnabled(false);

        jLabel188.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel188.setText("Documento");

        jDocumentoPrisao.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jDocumentoPrisao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDocumentoPrisao.setEnabled(false);

        jOrigemDocumentoPrisao.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jOrigemDocumentoPrisao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jOrigemDocumentoPrisao.setEnabled(false);

        jLabel189.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel189.setText("Origem do Documento");

        jLabel190.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel190.setText("Data Doc.");

        jDataDocumentoPrisao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataDocumentoPrisao.setEnabled(false);

        jHoraDocumento.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jHoraDocumento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHoraDocumento.setEnabled(false);

        jLabel191.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel191.setText("Hora Doc.");

        jTabelaDocumentosProcesso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaDocumentosProcesso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Natureza da Prisão", "Documento", "Origem", "Data", "Horário"
            }
        ));
        jTabelaDocumentosProcesso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaDocumentosProcessoMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTabelaDocumentosProcesso);
        if (jTabelaDocumentosProcesso.getColumnModel().getColumnCount() > 0) {
            jTabelaDocumentosProcesso.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaDocumentosProcesso.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaDocumentosProcesso.getColumnModel().getColumn(1).setMinWidth(300);
            jTabelaDocumentosProcesso.getColumnModel().getColumn(1).setMaxWidth(300);
            jTabelaDocumentosProcesso.getColumnModel().getColumn(2).setMinWidth(70);
            jTabelaDocumentosProcesso.getColumnModel().getColumn(2).setMaxWidth(70);
            jTabelaDocumentosProcesso.getColumnModel().getColumn(3).setMinWidth(120);
            jTabelaDocumentosProcesso.getColumnModel().getColumn(3).setMaxWidth(120);
            jTabelaDocumentosProcesso.getColumnModel().getColumn(4).setMinWidth(70);
            jTabelaDocumentosProcesso.getColumnModel().getColumn(4).setMaxWidth(70);
            jTabelaDocumentosProcesso.getColumnModel().getColumn(5).setMinWidth(70);
            jTabelaDocumentosProcesso.getColumnModel().getColumn(5).setMaxWidth(70);
        }

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel46Layout.createSequentialGroup()
                        .addComponent(jLabel189)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel46Layout.createSequentialGroup()
                        .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel186, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jIdNatp))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel187)
                            .addComponent(jDescricaoNaturezaPrisao, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel188)
                            .addComponent(jDocumentoPrisao, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel190, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDataDocumentoPrisao, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel191)
                            .addComponent(jHoraDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane4)
                    .addComponent(jOrigemDocumentoPrisao))
                .addContainerGap())
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel46Layout.createSequentialGroup()
                        .addComponent(jLabel188)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDocumentoPrisao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel187)
                                .addGroup(jPanel46Layout.createSequentialGroup()
                                    .addComponent(jLabel186)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jIdNatp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel46Layout.createSequentialGroup()
                                .addComponent(jLabel190)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDataDocumentoPrisao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel46Layout.createSequentialGroup()
                                .addComponent(jLabel191)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jHoraDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jDescricaoNaturezaPrisao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel189)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jOrigemDocumentoPrisao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Documentos do Processo", jPanel46);

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel40Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jScrollPane2, jTabbedPane4, jTabbedPane5});

        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Ficha Jurídica", jPanel40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 564, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBounds(300, 15, 663, 595);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:   
        buscarAcessoUsuario(telaCadastroProntuarioManuCRC);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaCadastroProntuarioManuCRC) && codIncluirCRC == 1) {
            verificarParamentrosCrc();
            acao = 1;
            Novo();
            corCampos();
            limparCamposFichaJuridica();
            limparTabelaAmparolegal();
            limparTabelaDocumentos();
            limparTabelaProcessos();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        // TODO add your handling code here:  
        buscarAcessoUsuario(telaCadastroProntuarioManuCRC);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaCadastroProntuarioManuCRC) && codAlterarCRC == 1) {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM PARAMETROSCRC WHERE UsuarioAutorizado='" + nameUser + "'");
                conecta.rs.first();
                usuarioAutorizado = conecta.rs.getString("UsuarioAutorizado");
            } catch (SQLException ex) {
            }
            verificarParamentrosCrc();
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
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtAlterarActionPerformed

    private void jBtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirActionPerformed
        buscarAcessoUsuario(telaCadastroProntuarioManuCRC);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaCadastroProntuarioManuCRC) && codExcluirCRC == 1) {
            verificarEntradaInterno();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:hh
        buscarAcessoUsuario(telaCadastroProntuarioManuCRC);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaCadastroProntuarioManuCRC) && codGravarCRC == 1) {
            validaCpf(jCPFInterno.getText());
            if (jNomeInterno.getText().isEmpty() || jNomeInterno.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Nome do INTERNO não pode ser em branco...");
                jNomeInterno.requestFocus();
            } else if (jMaeInterno.getText().isEmpty() || jMaeInterno.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Nome da MÃE do INTERNO não pode ser em branco...");
                jMaeInterno.requestFocus();
            } else if (jPaiInterno.getText().isEmpty() || jPaiInterno.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Nome do PAI do INTERNO não pode ser em branco...");
                jPaiInterno.requestFocus();
            } else if (caminho == null) {
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
            } else if (jComboBoxDocumentacaoCompleta.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe se o interno tem documentação completa ou não.");
                jComboBoxDocumentacaoCompleta.requestFocus();
                jComboBoxDocumentacaoCompleta.setBackground(Color.red);
            } else if (jComboBoxDocumentacaoCompleta.getSelectedItem().equals("Não") && jComboBoxQuaisDocumentosFaltam.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe quais documentos do interno estão faltando.");
                jComboBoxDocumentacaoCompleta.requestFocus();
                jComboBoxDocumentacaoCompleta.setBackground(Color.red);
            } else if (jComboBoxDocumentacaoCompleta.getSelectedItem().equals("Não") && jComboBoxQuaisDocumentosFaltam.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(rootPane, "Informe quais documentos do interno estão faltando.");
                jComboBoxDocumentacaoCompleta.requestFocus();
                jComboBoxDocumentacaoCompleta.setBackground(Color.red);
            } else if (jComboBoxDocumentacaoCompleta.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(rootPane, "Informe se o interno tem documentação completa ou não.");
                jComboBoxDocumentacaoCompleta.requestFocus();
                jComboBoxDocumentacaoCompleta.setBackground(Color.red);
            } else if (jComboBoxTornozeleira.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(rootPane, "Informe se o interno tem tornozeleira ou não.");
                jComboBoxTornozeleira.requestFocus();
                jComboBoxTornozeleira.setBackground(Color.red);
            } else if (jComboBoxTornozeleira.getSelectedItem().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe se o interno tem tornozeleira ou não.");
                jComboBoxTornozeleira.requestFocus();
                jComboBoxTornozeleira.setBackground(Color.red);
            } else if (jComboBoxEscolaridade.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o grau de instrução do interno.");
                jComboBoxEscolaridade.requestFocus();
                jComboBoxEscolaridade.setBackground(Color.red);
            } else if (jLabelFotoInterno.getIcon() == null || caminho == null || caminho.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário colocar a foto de frente do interno.");
            } else if (jFotoPerfil.getIcon() == null || caminhoFotoPerfil == null || caminhoFotoPerfil.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário colocar a primeira foto do perfil do interno.");
            } else if (jFotoCorpo.getIcon() == null || caminhoFotoCorpo == null || caminhoFotoCorpo.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário colocar a segunda foto do perfil do interno.");
            } else if (jFotoCorpo1.getIcon() == null || caminhoFotoCorpo1 == null || caminhoFotoCorpo1.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário colocar a terceira foto do perfil do interno.");
            } else if (jFotoCorpo2.getIcon() == null || caminhoFotoCorpo2 == null || caminhoFotoCorpo2.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário colocar a quarta foto do perfil do interno.");
            } else {
                objProCrc.setMatricula(jMatriculaPenal.getText());
                objProCrc.setDataCadast(jDataCadastro.getDate());
                objProCrc.setDataNasci(jDataNascimento.getDate());
                objProCrc.setNomeInterno(jNomeInterno.getText());
                objProCrc.setMaeInterno(jMaeInterno.getText());
                objProCrc.setPaiInterno(jPaiInterno.getText());
                objProCrc.setAlcunha(jAlcunha.getText());
                objProCrc.setRgInterno(jRGInterno.getText());
                objProCrc.setCpfInterno(jCPFInterno.getText());
                objProCrc.setCartoaSus(jCartaoSus.getText());
                objProCrc.setFotoInterno(caminho);
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
                objProCrc.setDocumentacaoCompleta((String) jComboBoxDocumentacaoCompleta.getSelectedItem());
                objProCrc.setQuaisDocumentosFaltam((String) jComboBoxQuaisDocumentosFaltam.getSelectedItem());
                objProCrc.setTornozeleira((String) jComboBoxTornozeleira.getSelectedItem());
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
                try {
                    // Verificar se o interno já foi cadastrado, se foi avisa
                    conecta.abrirConexao();
                    conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                            + "WHERE NomeInternoCrc='" + jNomeInterno.getText() + "' "
                            + "AND MaeInternoCrc='" + jMaeInterno.getText() + "'");
                    conecta.rs.first();
                    nomeInternoCrc = conecta.rs.getString("NomeInternoCrc");
                    nomeMaeInterno = conecta.rs.getString("MaeInternoCrc");
                    conecta.desconecta();
                } catch (SQLException | HeadlessException | NumberFormatException e) {
                }
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
                if (acao == 1) {
                    if (jNomeInterno.getText().trim().equals(nomeInternoCrc) && jMaeInterno.getText().trim().equals(nomeMaeInterno)) {
                        JOptionPane.showMessageDialog(rootPane, "Esse Interno já foi cadastrado.");
                        conecta.desconecta();
                    } else {
                        try {
                            //GRAVA NA TABELA PRONTUARIOSCRC
                            control.incluirInternoCrc(objProCrc);
                            buscarCodInt();
                            // TABELA DADOSFISICOSINTERNOS
                            controlFisicos.incluirDadosFisicos(objDadosFis);
                            // TABELA DADOSPENAISINTERNOS
                            controlPenais.incluirDadosPenais(objDadosPena);
                            // VERIFICAR SE O INTERNO FOI GRAVADO NA TABELA DADOSPENAISINTERNOS
                            objProCrc.setIdInterno(Integer.valueOf(jIdInterno.getText()));
                            verificarGravacaoInterno();
                            if (jIdInterno.getText().equals(codIntPenal)) {
                                // Confirma a utilização do registro do interno iniciado pela portaria.
                                objProCrc.setNomeInterno(jNomeInterno.getText());
                                objProCrc.setConfirmaEntrada(confirmaEntrada);
                                control.confirmarRegInternoCrc(objProCrc);
                                //
                                gravarDocumentos();
                                //
                                objLog();
                                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação                                                                                    
                                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                                Salvar();
                            } else {
                                apagarRegistroInterno();
                                JOptionPane.showMessageDialog(rootPane, "Não foi possível concluir a gravação do registro, por favor tente novamente.");
                            }

                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(rootPane, "Não foi possivel gravar registro\nERRO: " + ex);
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
                        control.alterarInternoCrc(objProCrc);
                        controlFisicos.alterarDadosFisicos(objDadosFis);
                        controlPenais.alterarDadosPenais(objDadosPena);
                        //
                        gravarDocumentos();
                        //
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação          
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso...");
                        Salvar();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(rootPane, "Não foi possível alterar o registro.\nERRO: " + e);
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

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNomeActionPerformed
        // Pesquisa de Interno por NOME 
        count = 0;
        pSAIDA_TEMP = 0;
        pSAIDA_COVID = 0;
        flag = 1;
        if (jPesqNome.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe NOME para pesquisa!!!");
            jPesqNome.requestFocus();
        } else {
            preencherTabelaNome("SELECT PRONTUARIOSCRC.IdInternoCrc, "
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
        flag = 1;
        if (jPesqMatricula.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe MATRICULA para pesquisa!!!");
            jPesqMatricula.requestFocus();
        } else {
            buscarInternosMatricula("SELECT PRONTUARIOSCRC.IdInternoCrc, "
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
            // LIMPAR FOTOS
            jLabelFotoInterno.setIcon(null);
            jFotoPerfil.setIcon(null);
            jFotoCorpo.setIcon(null);
            jFotoCorpo1.setIcon(null);
            jFotoCorpo2.setIcon(null);
            //
            bloquearCamposEdicao();
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
                jCPFInterno.setText(conecta.rs.getString("CpfInternoCrc"));
                jCartaoSus.setText(conecta.rs.getString("CartaoSus"));
                // Capturando foto
                caminho = conecta.rs.getString("FotoInternoCrc");
                if (caminho != null) {
                    javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                    jLabelFotoInterno.setIcon(i);
                    jLabelFotoInterno.setIcon(new ImageIcon(i.getImage().getScaledInstance(jLabelFotoInterno.getWidth(), jLabelFotoInterno.getHeight(), Image.SCALE_SMOOTH)));
                }
                // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
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
                jComboBoxDocumentacaoCompleta.setSelectedItem(conecta.rs.getString("DocumentacaoCompleta"));
                jComboBoxQuaisDocumentosFaltam.setSelectedItem(conecta.rs.getString("QuaisDocumentosFaltam"));
                jComboBoxTornozeleira.setSelectedItem(conecta.rs.getString("Tornozeleira"));
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
                limparTabela();
                consultaDocumentos();
                conecta.desconecta();
            } catch (SQLException e) {
                // JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa por nome" + e);
            }
            // FICHA JURIDICA                        
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM FICHA_JURIDICA "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON FICHA_JURIDICA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE FICHA_JURIDICA.IdInternoCrc='" + jIdInterno.getText() + "'");
                conecta.rs.first();
                codigoFichaJuridica = conecta.rs.getString("IdFicha");
                codigoInterno = conecta.rs.getString("IdInternoCrc");
            } catch (SQLException e) {
            }
            //
            if (jIdInterno.getText().equals(codigoInterno)) {
                preencherTabelaProcessos("SELECT * FROM PROCESSOS_JURIDICOS "
                        + "INNER JOIN FICHA_JURIDICA "
                        + "ON PROCESSOS_JURIDICOS.IdFicha=FICHA_JURIDICA.IdFicha "
                        + "WHERE PROCESSOS_JURIDICOS.IdFicha='" + codigoFichaJuridica + "'");
                preencherTabelaIncidenciaPenal("SELECT * FROM INCIDENCIA_PENAL "
                        + "INNER JOIN FICHA_JURIDICA "
                        + "ON INCIDENCIA_PENAL.IdFicha=FICHA_JURIDICA.IdFicha "
                        + "INNER JOIN AMPARO_LEGAL "
                        + "ON INCIDENCIA_PENAL.IdLanc=AMPARO_LEGAL.IdLanc "
                        + "WHERE INCIDENCIA_PENAL.IdFicha='" + codigoFichaJuridica + "'");
                preencherTabelaDocumentosProcessos("SELECT * FROM DOCUMENTOS_PROCESSO "
                        + "INNER JOIN FICHA_JURIDICA "
                        + "ON DOCUMENTOS_PROCESSO.IdFicha=FICHA_JURIDICA.IdFicha "
                        + "INNER JOIN NATUREZA_PRISAO "
                        + "ON DOCUMENTOS_PROCESSO.IdNatp=NATUREZA_PRISAO.IdNatp "
                        + "WHERE DOCUMENTOS_PROCESSO.IdFicha='" + codigoFichaJuridica + "'");
            } else {
                limparCamposFichaJuridica();
                limparTabelaDocumentos();
                limparTabelaAmparolegal();
                limparTabelaProcessos();
            }
        }
    }//GEN-LAST:event_jTabelaInternoMouseClicked

    private void jBtPesqPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqPaisActionPerformed
        // TODO add your handling code here:
        //    buscarNacionalidade("SELECT * FROM PAISES WHERE NomePais LIKE'" + jPesNomePais.getText() + "%'");       
        TelaPesquisaPaisesCrc objPaises = new TelaPesquisaPaisesCrc();
        TelaModuloCRC.jPainelCRC.add(objPaises);
        objPaises.show();

    }//GEN-LAST:event_jBtPesqPaisActionPerformed

    private void jBtNovaFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovaFotoActionPerformed
        // TODO add your handling code here:
        // Incluir Foto
        JFileChooser chooser = new JFileChooser();
        int acao = chooser.showOpenDialog(this);
        if (acao == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            caminho = f.getAbsolutePath();
            ImageIcon imagemicon = new ImageIcon(new ImageIcon(caminho).getImage().getScaledInstance(jLabelFotoInterno.getWidth(), jLabelFotoInterno.getHeight(), Image.SCALE_SMOOTH));
            jLabelFotoInterno.setIcon(imagemicon);
            try {
                File image = new File(caminho);
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
        jLabelFotoInterno.setIcon(null);
    }//GEN-LAST:event_jBtExcluirFotoActionPerformed

    private void jBtPesqCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqCidadeActionPerformed
        // TODO add your handling code here:
        TelaPesquisaCidadesCrc objCidaC = new TelaPesquisaCidadesCrc();
        TelaModuloCRC.jPainelCRC.add(objCidaC);
        objCidaC.show();
    }//GEN-LAST:event_jBtPesqCidadeActionPerformed

    private void jBtPesqUnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqUnidadeActionPerformed
        // TODO add your handling code here:
        TelaPesquisaUnidadeCrc objUnidPenal2 = new TelaPesquisaUnidadeCrc();
        TelaModuloCRC.jPainelCRC.add(objUnidPenal2);
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

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        count = 0;
        pSAIDA_TEMP = 0;
        pSAIDA_COVID = 0;
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherTodosInternos("SELECT PRONTUARIOSCRC.IdInternoCrc, "
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
            limparTabelaProntuario();
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jBtImpressaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImpressaoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCadastroProntuarioPrintCRC);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaCadastroProntuarioPrintCRC) && codAbrirCRC == 1) {
            if (jIdInterno.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Não é possível listar o relatório, pois, o interno não código no sistema.");
            } else {
                try {
                    conecta.abrirConexao();
                    String path = "reports/ProntuariosInternosCrcCodigo.jasper";
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
                    JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório.\n\nERRO :" + e);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtImpressaoActionPerformed

    private void jBtPesqCidadeEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqCidadeEndActionPerformed
        // TODO add your handling code here:
        TelaPesquisaCidadesCrcEnd objPesqCidaEnd = new TelaPesquisaCidadesCrcEnd();
        TelaModuloCRC.jPainelCRC.add(objPesqCidaEnd);
        objPesqCidaEnd.show();
    }//GEN-LAST:event_jBtPesqCidadeEndActionPerformed

    private void jBtAuditoriaPronCrcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaPronCrcActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaProntuarioInternoCrc objAudProInternoCrc = new TelaAuditoriaProntuarioInternoCrc();
        TelaModuloCRC.jPainelCRC.add(objAudProInternoCrc);
        objAudProInternoCrc.show();
    }//GEN-LAST:event_jBtAuditoriaPronCrcActionPerformed

    private void jBtWebCamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtWebCamActionPerformed
        // TODO add your handling code here:        
        webCam();
    }//GEN-LAST:event_jBtWebCamActionPerformed

    private void jBtObservacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtObservacaoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCadastroProntuarioObsCRC);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaCadastroProntuarioObsCRC) && codAbrirCRC == 1) {
            TelaObservacoesInternos objObsInt = new TelaObservacoesInternos();
            TelaModuloCRC.jPainelCRC.add(objObsInt);
            objObsInt.show();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtObservacaoActionPerformed

    private void jBtBuscarRegPortariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtBuscarRegPortariaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCadastroProntuarioBuscarEntCRC);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaCadastroProntuarioBuscarEntCRC) && codAbrirCRC == 1) {
            TelaPesqEntradaIntPortariaCrc objPesqRegInterno = new TelaPesqEntradaIntPortariaCrc();
            TelaModuloCRC.jPainelCRC.add(objPesqRegInterno);
            objPesqRegInterno.show();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtBuscarRegPortariaActionPerformed

    private void jBtZoonFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtZoonFotoActionPerformed
        // TODO add your handling code here:
        mostraTelaFotoCrc();
    }//GEN-LAST:event_jBtZoonFotoActionPerformed

    private void jBtNovo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovo1ActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCadastroProntuarioManuCRC);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaCadastroProntuarioManuCRC) && codIncluirCRC == 1) {
            verificarParamentrosCrc();
            acao = 1;
            Novo();
            corCampos();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovo1ActionPerformed

    private void jBtAlterar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterar1ActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCadastroProntuarioManuCRC);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaCadastroProntuarioManuCRC) && codAlterarCRC == 1) {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM PARAMETROSCRC WHERE UsuarioAutorizado='" + nameUser + "'");
                conecta.rs.first();
                usuarioAutorizado = conecta.rs.getString("UsuarioAutorizado");
            } catch (SQLException ex) {
            }
            verificarParamentrosCrc();
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
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtAlterar1ActionPerformed

    private void jBtExcluir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluir1ActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCadastroProntuarioManuCRC);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaCadastroProntuarioManuCRC) && codExcluirCRC == 1) {
            verificarEntradaInterno();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluir1ActionPerformed

    private void jBtSalvar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvar1ActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCadastroProntuarioManuCRC);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaCadastroProntuarioManuCRC) && codGravarCRC == 1) {
            validaCpf(jCPFInterno.getText());
            if (jNomeInterno.getText().isEmpty() || jNomeInterno.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Nome do INTERNO não pode ser em branco...");
                jNomeInterno.requestFocus();
            } else if (jMaeInterno.getText().isEmpty() || jMaeInterno.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Nome da MÃE do INTERNO não pode ser em branco...");
                jMaeInterno.requestFocus();
            } else if (jPaiInterno.getText().isEmpty() || jPaiInterno.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Nome do PAI do INTERNO não pode ser em branco...");
                jPaiInterno.requestFocus();
            } else if (caminho == null) {
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
            } else if (jComboBoxDocumentacaoCompleta.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe se o interno tem documentação completa ou não.");
                jComboBoxDocumentacaoCompleta.requestFocus();
                jComboBoxDocumentacaoCompleta.setBackground(Color.red);
            } else if (jComboBoxDocumentacaoCompleta.getSelectedItem().equals("Não") && jComboBoxQuaisDocumentosFaltam.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe quais documentos do interno estão faltando.");
                jComboBoxDocumentacaoCompleta.requestFocus();
                jComboBoxDocumentacaoCompleta.setBackground(Color.red);
            } else if (jComboBoxDocumentacaoCompleta.getSelectedItem().equals("Não") && jComboBoxQuaisDocumentosFaltam.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(rootPane, "Informe quais documentos do interno estão faltando.");
                jComboBoxDocumentacaoCompleta.requestFocus();
                jComboBoxDocumentacaoCompleta.setBackground(Color.red);
            } else if (jComboBoxDocumentacaoCompleta.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(rootPane, "Informe se o interno tem documentação completa ou não.");
                jComboBoxDocumentacaoCompleta.requestFocus();
                jComboBoxDocumentacaoCompleta.setBackground(Color.red);
            } else if (jComboBoxTornozeleira.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(rootPane, "Informe se o interno tem tornozeleira ou não.");
                jComboBoxTornozeleira.requestFocus();
                jComboBoxTornozeleira.setBackground(Color.red);
            } else if (jComboBoxTornozeleira.getSelectedItem().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe se o interno tem tornozeleira ou não.");
                jComboBoxTornozeleira.requestFocus();
                jComboBoxTornozeleira.setBackground(Color.red);
            } else if (jComboBoxEscolaridade.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o grau de instrução do interno.");
                jComboBoxEscolaridade.requestFocus();
                jComboBoxEscolaridade.setBackground(Color.red);
            } else if (jLabelFotoInterno.getIcon() == null || caminho == null || caminho.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário colocar a foto de frente do interno.");
            } else if (jFotoPerfil.getIcon() == null || caminhoFotoPerfil == null || caminhoFotoPerfil.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário colocar a primeira foto do perfil do interno.");
            } else if (jFotoCorpo.getIcon() == null || caminhoFotoCorpo == null || caminhoFotoCorpo.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário colocar a segunda foto do perfil do interno.");
            } else if (jFotoCorpo1.getIcon() == null || caminhoFotoCorpo1 == null || caminhoFotoCorpo1.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário colocar a terceira foto do perfil do interno.");
            } else if (jFotoCorpo2.getIcon() == null || caminhoFotoCorpo2 == null || caminhoFotoCorpo2.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário colocar a quarta foto do perfil do interno.");
            } else {
                objProCrc.setMatricula(jMatriculaPenal.getText());
                objProCrc.setDataCadast(jDataCadastro.getDate());
                objProCrc.setDataNasci(jDataNascimento.getDate());
                objProCrc.setNomeInterno(jNomeInterno.getText());
                objProCrc.setMaeInterno(jMaeInterno.getText());
                objProCrc.setPaiInterno(jPaiInterno.getText());
                objProCrc.setAlcunha(jAlcunha.getText());
                objProCrc.setRgInterno(jRGInterno.getText());
                objProCrc.setCpfInterno(jCPFInterno.getText());
                objProCrc.setCartoaSus(jCartaoSus.getText());
                objProCrc.setFotoInterno(caminho);
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
                objProCrc.setDocumentacaoCompleta((String) jComboBoxDocumentacaoCompleta.getSelectedItem());
                objProCrc.setQuaisDocumentosFaltam((String) jComboBoxQuaisDocumentosFaltam.getSelectedItem());
                objProCrc.setTornozeleira((String) jComboBoxTornozeleira.getSelectedItem());
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
                try {
                    // Verificar se o interno já foi cadastrado, se foi avisa
                    conecta.abrirConexao();
                    conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                            + "WHERE NomeInternoCrc='" + jNomeInterno.getText() + "' "
                            + "AND MaeInternoCrc='" + jMaeInterno.getText() + "'");
                    conecta.rs.first();
                    nomeInternoCrc = conecta.rs.getString("NomeInternoCrc");
                    nomeMaeInterno = conecta.rs.getString("MaeInternoCrc");
                    conecta.desconecta();
                } catch (SQLException | HeadlessException | NumberFormatException e) {
                }
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
                if (acao == 1) {
                    if (jNomeInterno.getText().trim().equals(nomeInternoCrc) && jMaeInterno.getText().trim().equals(nomeMaeInterno)) {
                        JOptionPane.showMessageDialog(rootPane, "Esse Interno já foi cadastrado.");
                        conecta.desconecta();
                    } else {
                        try {
                            //GRAVA NA TABELA PRONTUARIOSCRC
                            control.incluirInternoCrc(objProCrc);
                            buscarCodInt();
                            // TABELA DADOSFISICOSINTERNOS
                            controlFisicos.incluirDadosFisicos(objDadosFis);
                            // TABELA DADOSPENAISINTERNOS
                            controlPenais.incluirDadosPenais(objDadosPena);
                            // VERIFICAR SE O INTERNO FOI GRAVADO NA TABELA DADOSPENAISINTERNOS
                            objProCrc.setIdInterno(Integer.valueOf(jIdInterno.getText()));
                            verificarGravacaoInterno();
                            if (jIdInterno.getText().equals(codIntPenal)) {
                                // Confirma a utilização do registro do interno iniciado pela portaria.
                                objProCrc.setNomeInterno(jNomeInterno.getText());
                                objProCrc.setConfirmaEntrada(confirmaEntrada);
                                control.confirmarRegInternoCrc(objProCrc);
                                //
                                gravarDocumentos();
                                //
                                objLog();
                                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação                                                                                    
                                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                                Salvar();
                            } else {
                                apagarRegistroInterno();
                                JOptionPane.showMessageDialog(rootPane, "Não foi possível concluir a gravação do registro, por favor tente novamente.");
                            }

                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(rootPane, "Não foi possivel gravar registro\nERRO: " + ex);
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
                        control.alterarInternoCrc(objProCrc);
                        controlFisicos.alterarDadosFisicos(objDadosFis);
                        controlPenais.alterarDadosPenais(objDadosPena);
                        //
                        gravarDocumentos();
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação          
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso...");
                        Salvar();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(rootPane, "Não foi possível alterar o registro.\nERRO: " + e);
                    }

                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
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
        if (jMatriculaPenal.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Não é possível listar o relatório, pois, o interno não tem matricula penal.");
        } else {
            try {
                conecta.abrirConexao();
                String path = "reports/ProntuariosInternosCrcCodigo.jasper";
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
                        + "WHERE MatriculaCrc='" + jMatriculaPenal.getText() + "'");
                HashMap parametros = new HashMap();
                parametros.put("MatriculaCrc", jMatriculaPenal.getText());
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
                JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
            }
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
        TelaObservacoesInternos objObsInt = new TelaObservacoesInternos();
        TelaModuloCRC.jPainelCRC.add(objObsInt);
        objObsInt.show();
    }//GEN-LAST:event_jBtObservacao1ActionPerformed

    private void jBtBuscarRegPortaria1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtBuscarRegPortaria1ActionPerformed
        // TODO add your handling code here:
        TelaPesqEntradaIntPortariaCrc objPesqRegInterno = new TelaPesqEntradaIntPortariaCrc();
        TelaModuloCRC.jPainelCRC.add(objPesqRegInterno);
        objPesqRegInterno.show();
    }//GEN-LAST:event_jBtBuscarRegPortaria1ActionPerformed

    private void jBtPesqAlcunhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqAlcunhaActionPerformed
        // TODO add your handling code here:
        count = 0;
        pSAIDA_TEMP = 0;
        pSAIDA_COVID = 0;
        flag = 1;
        if (jPesqAlcunha.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe a alcunha para pesquisa.");
        } else {
            preencherTabelaNome("SELECT PRONTUARIOSCRC.IdInternoCrc, "
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

    private void jBtPeculiaridadeCostasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPeculiaridadeCostasActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCadastroProntuarioPecCosCRC);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaCadastroProntuarioPecCosCRC) && codAbrirCRC == 1) {
            mostrarTelaPeculiaridade();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtPeculiaridadeCostasActionPerformed

    private void jBtPeculiaridadeFrenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPeculiaridadeFrenteActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCadastroProntuarioPecFreCRC);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaCadastroProntuarioPecFreCRC) && codAbrirCRC == 1) {
            mostrarTelaPeculiaridadeFrente();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtPeculiaridadeFrenteActionPerformed

    private void jBtPesqCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqCodigoActionPerformed
        // TODO add your handling code here:
        count = 0;
        pSAIDA_TEMP = 0;
        pSAIDA_COVID = 0;
        flag = 1;
        if (jPesqCodigo.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o código do interno para pesquisa.");
        } else {
            preencherTabelaNome("SELECT PRONTUARIOSCRC.IdInternoCrc, "
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
        flag = 1;
        if (jComboBoxPesqSituacao.getSelectedItem().equals("Ativos")) {
            preencherTabelaNome("SELECT PRONTUARIOSCRC.IdInternoCrc, "
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
            preencherTabelaNome("SELECT PRONTUARIOSCRC.IdInternoCrc, "
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
            preencherTabelaNome("SELECT PRONTUARIOSCRC.IdInternoCrc, "
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
        flag = 1;
        if (jPesquisaCNC.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe MATRICULA para pesquisa!!!");
            jPesquisaCNC.requestFocus();
        } else {
            buscarInternosMatricula("SELECT PRONTUARIOSCRC.IdInternoCrc, "
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

    private void jTabelaProcessoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaProcessoMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String idLanc = "" + jTabelaProcesso.getValueAt(jTabelaProcesso.getSelectedRow(), 0);
            //            
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM PROCESSOS_JURIDICOS "
                        + "INNER JOIN FICHA_JURIDICA "
                        + "ON PROCESSOS_JURIDICOS.IdFicha=FICHA_JURIDICA.IdFicha "
                        + "WHERE PROCESSOS_JURIDICOS.IdProc='" + idLanc + "'");
                conecta.rs.first();
                codProc = conecta.rs.getString("IdProc");
                jNumeroProcesso.setText(conecta.rs.getString("NrProcesso"));
                jNumeroInquerito.setText(conecta.rs.getString("Inquerito"));
                jComboBoxRegimeProcesso.setSelectedItem(conecta.rs.getString("Regime"));
                jComboBoxSentenca.setSelectedItem(conecta.rs.getString("Sentenca"));
                jComboBoxTipoSentencaCondenatoria.setSelectedItem(conecta.rs.getString("TipoSentenca"));
                jComboBoxSituacaoPresoProcesso.setSelectedItem(conecta.rs.getString("SituacaoPresoProcesso"));
                jAnos.setText(conecta.rs.getString("Anos"));
                jMeses.setText(conecta.rs.getString("Meses"));
                jDias.setText(conecta.rs.getString("Dias"));
                jMeses.setText(conecta.rs.getString("Meses"));
                jTotalDias.setText(conecta.rs.getString("TotalDias"));
                jDataInicioProcesso.setDate(conecta.rs.getDate("DataInicio"));
                jDataTerminoProcesso.setDate(conecta.rs.getDate("DataTermino"));
                jObservacaoProcesso.setText(conecta.rs.getString("Observacao"));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa..." + e);
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaProcessoMouseClicked

    private void jTabelaAmparoLegalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaAmparoLegalMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String idLanc = "" + jTabelaAmparoLegal.getValueAt(jTabelaAmparoLegal.getSelectedRow(), 0);
            jIdAmparo.setText(idLanc);
            //           
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM INCIDENCIA_PENAL "
                        + "INNER JOIN FICHA_JURIDICA "
                        + "ON INCIDENCIA_PENAL.IdFicha=FICHA_JURIDICA.IdFicha "
                        + "INNER JOIN AMPARO_LEGAL "
                        + "ON INCIDENCIA_PENAL.IdLanc=AMPARO_LEGAL.IdLanc "
                        + "WHERE INCIDENCIA_PENAL.IdInc='" + idLanc + "'");
                conecta.rs.first();
                codIncPen = conecta.rs.getString("IdInc");
                jIdAmparo.setText(conecta.rs.getString("IdLanc"));
                jDescricaoAmparoLegal.setText(conecta.rs.getString("DescricaoAmparoLegal"));
                jComboBoxArtigo.setText(conecta.rs.getString("Artigo"));
                jComboBoxParagrafo.setText(conecta.rs.getString("Paragrafo"));
                jComboBoxInciso.setText(conecta.rs.getString("Inciso"));
                jComboBoxAlinea.setText(conecta.rs.getString("Alinea"));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa..." + e);
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaAmparoLegalMouseClicked

    private void jTabelaDocumentosProcessoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaDocumentosProcessoMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String idLanc = "" + jTabelaDocumentosProcesso.getValueAt(jTabelaDocumentosProcesso.getSelectedRow(), 0);
            jIdNatp.setText(idLanc);
            //         
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM DOCUMENTOS_PROCESSO "
                        + "INNER JOIN FICHA_JURIDICA "
                        + "ON DOCUMENTOS_PROCESSO.IdFicha=FICHA_JURIDICA.IdFicha "
                        + "INNER JOIN NATUREZA_PRISAO "
                        + "ON DOCUMENTOS_PROCESSO.IdNatp=NATUREZA_PRISAO.IdNatp "
                        + "WHERE DOCUMENTOS_PROCESSO.IdDocPro='" + idLanc + "'");
                conecta.rs.first();
                jIdNatp.setText(conecta.rs.getString("IdNatp"));
                codProdDoc = conecta.rs.getString("IdDocPro");
                jDescricaoNaturezaPrisao.setText(conecta.rs.getString("DescricaoNatureza"));
                jDocumentoPrisao.setText(conecta.rs.getString("Documento"));
                jOrigemDocumentoPrisao.setText(conecta.rs.getString("OrigemDoc"));
                jDataDocumentoPrisao.setDate(conecta.rs.getDate("DataDoc"));
                jHoraDocumento.setText(conecta.rs.getString("HoraDoc"));
//                jObservacaoDocumento.setText(conecta.rs.getString("Observacao"));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa..." + e);
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaDocumentosProcessoMouseClicked

    private void jBtImportarProntuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImportarProntuarioActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCadastroProntuarioImportCRC);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaCadastroProntuarioImportCRC) && codAbrirCRC == 1) {
            mostrarTelaPesquisaExterna();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtImportarProntuarioActionPerformed

    private void jBtPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPDFActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCadastroProntuarioDocCRC);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaCadastroProntuarioDocCRC) && codAbrirCRC == 1) {
            if (jIdInterno.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Não existe interno selecionado para incluir ou consultar a sua documentação,\nselecione primeiro o interno para poder consultar ou incluir a documentação.");
            } else {
                mostrarDocumentosPDF();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtPDFActionPerformed

    private void jComboBoxDocumentacaoCompletaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxDocumentacaoCompletaItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == evt.SELECTED) {
            if (jComboBoxDocumentacaoCompleta.getSelectedItem().equals("Sim")) {
                jComboBoxQuaisDocumentosFaltam.removeAllItems();
                jComboBoxQuaisDocumentosFaltam.addItem("Documentação do Interno está completa.");
                jComboBoxQuaisDocumentosFaltam.setEnabled(!true);
                jBtAdicionarDocumento.setEnabled(!true);
                jBtExcluirRegistro.setEnabled(!true);
            } else if (jComboBoxDocumentacaoCompleta.getSelectedItem().equals("Não")) {
                jComboBoxQuaisDocumentosFaltam.removeAllItems();
                jComboBoxQuaisDocumentosFaltam.addItem("Documentação do Interno está Incompleta.");
                jComboBoxQuaisDocumentosFaltam.setEnabled(true);
                jBtAdicionarDocumento.setEnabled(true);
//                jBtExcluirRegistro.setEnabled(true);
                preencherCheckBoxDocumentos();
            } else if (jComboBoxDocumentacaoCompleta.getSelectedItem().equals("Selecione...")) {
                jComboBoxQuaisDocumentosFaltam.removeAllItems();
                jComboBoxQuaisDocumentosFaltam.addItem("Selecione...");
                jBtAdicionarDocumento.setEnabled(!true);
                jBtExcluirRegistro.setEnabled(!true);
            }
        }
    }//GEN-LAST:event_jComboBoxDocumentacaoCompletaItemStateChanged

    private void jBtAdicionarDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAdicionarDocumentoActionPerformed
        // TODO add your handling code here:
        if (acao == 1 || acao == 2) {
            if (jComboBoxQuaisDocumentosFaltam.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário informar o tipo de documento que está faltando.");
            } else {
                objProCrc.setQuaisDocumentosFaltam((String) jComboBoxQuaisDocumentosFaltam.getSelectedItem());
                documentosInterno((String) jComboBoxQuaisDocumentosFaltam.getSelectedItem());
                Integer row = jTabelaDocumentos.getRowCount();
                boolean encontrou = !true;
                if (row == 0) { //Verifica se existe linha selecionada para não dar erro na hora de pegar os valores
                    count = count + 1;
                    jtotalRegistros.setText(Integer.toString(count));
                    pTotalDocumentos = count;
                    //Pega os models das listas, para fazer as inserções e remoções
                    DefaultTableModel modelDestino = (DefaultTableModel) jTabelaDocumentos.getModel();
                    //Cria uma linha para ser incluida na tabela de destino, no meu caso tem duas colunas, adapte para as suas tabelas
                    obj = (new Object[]{objProCrc.getIdChek(), objProCrc.getQuaisDocumentosFaltam()});
                    // BARRA DE ROLAGEM HORIZONTAL
                    jTabelaDocumentos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                    // ALINHAR TEXTO DA TABELA CENTRALIZADO
                    DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                    centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                    //
                    jTabelaDocumentos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                    //Adiciona no destino e remove da origem
                    modelDestino.addRow(obj);
                } else if (row != 0) {
                    DefaultTableModel modelDestino = (DefaultTableModel) jTabelaDocumentos.getModel();
                    // VERIFICAR SE O REGISTRO JÁ EXISTE NA TABELA, SE EXITIR AVISA.
                    for (int i = 0; i < jTabelaDocumentos.getRowCount(); i++) {
                        idDocumento = "" + jTabelaDocumentos.getValueAt(i, 1).toString();
                        if (idDocumento.equals(objProCrc.getQuaisDocumentosFaltam())) {
                            encontrou = true;
                            break;
                        } else {
                            encontrou = !true;
                        }
                    }
                    if (encontrou == true) {
                        JOptionPane.showMessageDialog(rootPane, "Documento já foi selecionado, escolha outro.");
                    } else if (encontrou == !true) {
                        count = count + 1;
                        pTotalDocumentos = count;
                        jtotalRegistros.setText(Integer.toString(count));
                        //Adiciona no destino e remove da origem
                        obj = (new Object[]{objProCrc.getIdChek(), objProCrc.getQuaisDocumentosFaltam()});
                        // BARRA DE ROLAGEM HORIZONTAL
                        jTabelaDocumentos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        // ALINHAR TEXTO DA TABELA CENTRALIZADO
                        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                        //
                        jTabelaDocumentos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                        modelDestino.addRow(obj);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser modificado, pois, não está em modo de edição.");
        }
    }//GEN-LAST:event_jBtAdicionarDocumentoActionPerformed

    private void jBtExcluirRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirRegistroActionPerformed
        // TODO add your handling code here:
        if (acao == 1 || acao == 2) {
            if (jTabelaDocumentos.getSelectedRow() != -1) {
                DefaultTableModel dtm = (DefaultTableModel) jTabelaDocumentos.getModel();
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o item selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    dtm.removeRow(jTabelaDocumentos.getSelectedRow());
                    objProCrc.setIdInterno(Integer.valueOf(jIdInterno.getText()));
                    objProCrc.setIdChek(Integer.valueOf(codigoCheck));
                    controleDoc.excluirDocumentoInternoCrc(objProCrc);
                    JOptionPane.showMessageDialog(rootPane, "Registro excluído com sucesso.");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Selecione o registro que deseja excluir.");
            }
        }
    }//GEN-LAST:event_jBtExcluirRegistroActionPerformed

    private void jTabelaDocumentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaDocumentosMouseClicked
        // TODO add your handling code here:
        if (acao == 1 || acao == 2) {
            flag = 1;
            if (flag == 1) {
                jBtExcluirRegistro.setEnabled(true);
                codigoCheck = "" + jTabelaDocumentos.getValueAt(jTabelaInterno.getSelectedRow(), 0);
            }
        }
    }//GEN-LAST:event_jTabelaDocumentosMouseClicked

    private void jBtFasesPersecucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFasesPersecucaoActionPerformed
        // TODO add your handling code here:
        if (jIdInterno.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "É necessário pesquisar o interno antes...");
        } else {
            mostrarFasePersecucao();
        }
    }//GEN-LAST:event_jBtFasesPersecucaoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField jAlcunha;
    public static javax.swing.JTextField jAltura;
    private javax.swing.JTextField jAnos;
    public static javax.swing.JTextField jArtigo1;
    public static javax.swing.JTextField jArtigo2;
    public static javax.swing.JTextField jArtigo3;
    public static javax.swing.JTextField jBairro;
    private javax.swing.JButton jBtAdicionarDocumento;
    private javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtAlterar1;
    private javax.swing.JButton jBtAuditoriaPronCrc;
    private javax.swing.JButton jBtAuditoriaPronCrc1;
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
    private javax.swing.JButton jBtExcluirRegistro;
    private javax.swing.JButton jBtFasesPersecucao;
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
    private javax.swing.JButton jBtPDF;
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
    public static javax.swing.JTextField jComboBoxAlinea;
    public static javax.swing.JTextField jComboBoxArtigo;
    public static javax.swing.JComboBox jComboBoxBarba;
    public static javax.swing.JComboBox jComboBoxBigode;
    public static javax.swing.JComboBox jComboBoxBoca;
    public static javax.swing.JComboBox jComboBoxCabelos;
    public static javax.swing.JTextField jComboBoxCidade;
    public static javax.swing.JComboBox jComboBoxCompleicao;
    public static javax.swing.JComboBox jComboBoxCutis;
    private javax.swing.JComboBox<String> jComboBoxDocumentacaoCompleta;
    public static javax.swing.JComboBox jComboBoxEdiondo;
    public static javax.swing.JComboBox jComboBoxEscolaridade;
    public static javax.swing.JComboBox jComboBoxEstadoCivil;
    public static javax.swing.JTextField jComboBoxInciso;
    public static javax.swing.JComboBox jComboBoxLabios;
    public static javax.swing.JComboBox jComboBoxNariz;
    public static javax.swing.JComboBox jComboBoxOlhos;
    public static javax.swing.JComboBox jComboBoxOrelha;
    public static javax.swing.JTextField jComboBoxPais;
    public static javax.swing.JTextField jComboBoxParagrafo;
    public static javax.swing.JComboBox jComboBoxParticipacao;
    public static javax.swing.JComboBox jComboBoxPescoco;
    private javax.swing.JComboBox jComboBoxPesqSituacao;
    private javax.swing.JComboBox<String> jComboBoxQuaisDocumentosFaltam;
    public static javax.swing.JComboBox jComboBoxRegime;
    private javax.swing.JComboBox jComboBoxRegimeProcesso;
    public static javax.swing.JComboBox jComboBoxRosto;
    private javax.swing.JComboBox jComboBoxSentenca;
    public static javax.swing.JComboBox jComboBoxSexo;
    private javax.swing.JComboBox jComboBoxSituacaoPresoProcesso;
    private javax.swing.JComboBox jComboBoxTipoSentencaCondenatoria;
    private javax.swing.JComboBox<String> jComboBoxTornozeleira;
    public static javax.swing.JTextField jComboBoxUnid;
    public static com.toedter.calendar.JDateChooser jDataCadastro;
    public static com.toedter.calendar.JDateChooser jDataCondenacao;
    public static com.toedter.calendar.JDateChooser jDataCrime;
    private com.toedter.calendar.JDateChooser jDataDocumentoPrisao;
    public static com.toedter.calendar.JDateChooser jDataEntrada;
    private com.toedter.calendar.JDateChooser jDataInicioProcesso;
    public static com.toedter.calendar.JDateChooser jDataNascimento;
    public static com.toedter.calendar.JDateChooser jDataNovaEntrada;
    public static com.toedter.calendar.JDateChooser jDataPrisao;
    public static com.toedter.calendar.JDateChooser jDataTerPena;
    private com.toedter.calendar.JDateChooser jDataTerminoProcesso;
    public static javax.swing.JTextField jDescricaoAmparoLegal;
    public static javax.swing.JTextField jDescricaoNaturezaPrisao;
    private javax.swing.JTextField jDias;
    private javax.swing.JTextField jDocumentoPrisao;
    public static javax.swing.JTextField jEndereco;
    public static javax.swing.JTextField jEstado;
    private javax.swing.JLabel jFotoAnularDireito;
    private javax.swing.JLabel jFotoAnularEsquerdo;
    private javax.swing.JLabel jFotoCorpo;
    private javax.swing.JLabel jFotoCorpo1;
    private javax.swing.JLabel jFotoCorpo2;
    private javax.swing.JLabel jFotoIndicadorDireito;
    private javax.swing.JLabel jFotoIndicadorEsquerdo;
    private javax.swing.JLabel jFotoMedioDireito;
    private javax.swing.JLabel jFotoMedioEsquerdo;
    private javax.swing.JLabel jFotoMinimoEsquerdo;
    private javax.swing.JLabel jFotoMininoDireito;
    private javax.swing.JLabel jFotoPerfil;
    private javax.swing.JLabel jFotoPolegarDireito;
    private javax.swing.JLabel jFotoPolegarEsquerdo;
    private javax.swing.JTextField jHoraDocumento;
    public static javax.swing.JTextField jIdAmparo;
    public static javax.swing.JTextField jIdInterno;
    public static javax.swing.JTextField jIdNatp;
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
    private javax.swing.JTextField jMeses;
    public static javax.swing.JTextField jNomeInterno;
    private javax.swing.JTextField jNumeroInquerito;
    private javax.swing.JTextField jNumeroProcesso;
    private javax.swing.JTextArea jObservacaoProcesso;
    private javax.swing.JTextField jOrigemDocumentoPrisao;
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
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    public static javax.swing.JTextField jSituacao;
    public static javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTabbedPane jTabbedPane6;
    public static javax.swing.JTable jTabelaAmparoLegal;
    private javax.swing.JTable jTabelaDocumentos;
    private javax.swing.JTable jTabelaDocumentosProcesso;
    private javax.swing.JTable jTabelaInterno;
    private javax.swing.JTable jTabelaProcesso;
    public static javax.swing.JFormattedTextField jTelefone;
    public static javax.swing.JFormattedTextField jTelefone1;
    private javax.swing.JTextField jTotalDias;
    public static javax.swing.JTextField jVaraCondenacao;
    private javax.swing.JLabel jtotalRegistros;
    private javax.swing.JLabel jtotalRegistrosPDC;
    private javax.swing.JLabel jtotalRegistrosTMP;
    // End of variables declaration//GEN-END:variables

    public void verificarGravacaoInterno() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM DADOSPENAISINTERNOS WHERE IdInternoCrc='" + jIdInterno.getText() + "'");
            conecta.rs.first();
            codIntPenal = conecta.rs.getString("IdInternoCrc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void apagarRegistroInterno() {
        objDadosFis.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
        objProCrc.setIdInterno(Integer.valueOf(jIdInterno.getText()));
        try {
            controlFisicos.excluirDadosFisicos(objDadosFis);
            control.excluirInternoCrc(objProCrc);
        } catch (Exception e) {
        }
    }

    public void preencherCheckBoxDocumentos() {
        jComboBoxQuaisDocumentosFaltam.removeAllItems();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM CHECK_LIST_DOCUMENTOS_INTERNO_CRC "
                    + "ORDER BY DescricaoDocumentos");
            conecta.rs.first();
            do {
                jComboBoxQuaisDocumentosFaltam.addItem(conecta.rs.getString("DescricaoDocumentos"));
            } while (conecta.rs.next());
            jComboBoxQuaisDocumentosFaltam.updateUI();
        } catch (SQLException ex) {
        }
        conecta.desconecta();
    }

    public void bloquearCamposEdicao() {
        jMatriculaPenal.setEnabled(!true);
        jDataCadastro.setEnabled(!true);
        jDataNascimento.setEnabled(!true);
        jNomeInterno.setEnabled(!true);
        jMaeInterno.setEnabled(!true);
        jPaiInterno.setEnabled(!true);
        jAlcunha.setEnabled(!true);
        jRGInterno.setEnabled(!true);
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
        jComboBoxDocumentacaoCompleta.setEnabled(!true);
        jComboBoxQuaisDocumentosFaltam.setEnabled(!true);
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
        jCNC.setBackground(Color.white);
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
        jComboBoxQuaisDocumentosFaltam.setBackground(Color.white);
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
        jCPFInterno.setText("");
        jCartaoSus.setText("");
        jComboBoxEscolaridade.setSelectedItem("Selecione...");
        jComboBoxEstadoCivil.setSelectedItem("Selecione...");
        jComboBoxSexo.setSelectedItem("");
        jSituacao.setText("");
        jComboBoxCutis.setSelectedItem("Selecione...");
        jComboBoxOlhos.setSelectedItem("Selecione...");
        jComboBoxCabelos.setSelectedItem("Selecione...");
        jComboBoxBarba.setSelectedItem("Selecione...");
        jComboBoxBigode.setSelectedItem("Selecione...");
        jComboBoxNariz.setSelectedItem("Selecione...");
        jComboBoxBoca.setSelectedItem("Selecione...");
        jComboBoxRosto.setSelectedItem("Selecione...");
        jComboBoxLabios.setSelectedItem("Selecione...");
        jComboBoxParticipacao.setSelectedItem("Selecione...");
        jComboBoxRegime.setSelectedItem("Selecione...");
        jComboBoxEdiondo.setSelectedItem("Selecione...");
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
        jComboBoxOrelha.setSelectedItem("Selecione...");
        jComboBoxPescoco.setSelectedItem("Selecione...");
        jComboBoxCompleicao.setSelectedItem("Selecione...");
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
        jComboBoxQuaisDocumentosFaltam.setSelectedItem("Selecione...");
        jComboBoxQuaisDocumentosFaltam.setEnabled(true);
        jComboBoxTornozeleira.setSelectedItem("Selecione...");
        jComboBoxTornozeleira.setEnabled(true);
        // Habilitar campos para INCLUSÃO
        jMatriculaPenal.setEnabled(true);
        jDataCadastro.setEnabled(true);
        jDataNascimento.setEnabled(true);
        jNomeInterno.setEnabled(true);
        jMaeInterno.setEnabled(true);
        jPaiInterno.setEnabled(true);
        jAlcunha.setEnabled(true);
        jRGInterno.setEnabled(true);
        jCPFInterno.setEnabled(true);
        jCartaoSus.setEnabled(true);
        jComboBoxEscolaridade.setEnabled(true);
        jComboBoxEstadoCivil.setEnabled(true);
        jSituacao.setEnabled(!true);
        jComboBoxSexo.setEnabled(true);
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
        jComboBoxDocumentacaoCompleta.setEnabled(true);
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
        jBtNovo1.setEnabled(!true);
        jBtAlterar1.setEnabled(!true);
        jBtExcluir1.setEnabled(!true);
        jBtSalvar1.setEnabled(true);
        jBtCancelar1.setEnabled(true);
        jBtImpressao1.setEnabled(!true);
        jBtObservacao1.setEnabled(!true);
        jBtAuditoriaPronCrc1.setEnabled(!true);
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
        jCPFInterno.setEnabled(true);
        jCartaoSus.setEnabled(true);
        jComboBoxEscolaridade.setEnabled(true);
        jComboBoxEstadoCivil.setEnabled(true);
        jComboBoxSexo.setEnabled(true);
        jSituacao.setEnabled(!true);
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
        jComboBoxDocumentacaoCompleta.setEnabled(true);
        jComboBoxQuaisDocumentosFaltam.setEnabled(true);
        jComboBoxTornozeleira.setEnabled(true);
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
        jBtImportarProntuario.setEnabled(!true);
    }

    public void Excluir() {

        jMatriculaPenal.setText("");
        jNomeInterno.setText("");
        jMaeInterno.setText("");
        jPaiInterno.setText("");
        jAlcunha.setText("");
        jRGInterno.setText("");
        jCPFInterno.setText("");
        jCartaoSus.setText("");
        jLabelFotoInterno.setIcon(null);
        jComboBoxEscolaridade.setSelectedItem("Selecione...");
        jComboBoxEstadoCivil.setSelectedItem("Selecione...");
        jComboBoxSexo.setSelectedItem("");
        jSituacao.setText("");
        jComboBoxCutis.setSelectedItem("Selecione...");
        jComboBoxOlhos.setSelectedItem("Selecione...");
        jComboBoxCabelos.setSelectedItem("Selecione...");
        jComboBoxBarba.setSelectedItem("Selecione...");
        jComboBoxBigode.setSelectedItem("Selecione...");
        jComboBoxNariz.setSelectedItem("Selecione...");
        jComboBoxBoca.setSelectedItem("Selecione...");
        jComboBoxRosto.setSelectedItem("Selecione...");
        jComboBoxLabios.setSelectedItem("Selecione...");
        jComboBoxParticipacao.setSelectedItem("Selecione...");
        jComboBoxRegime.setSelectedItem("Selecione...");
        jComboBoxEdiondo.setSelectedItem("Selecione...");
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
        jComboBoxOrelha.setSelectedItem("Selecione...");
        jComboBoxPescoco.setSelectedItem("Selecione...");
        jComboBoxCompleicao.setSelectedItem("Selecione...");
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
        jComboBoxDocumentacaoCompleta.setSelectedItem("Selecione...");
        jComboBoxQuaisDocumentosFaltam.setSelectedItem("Selecione...");
        jComboBoxQuaisDocumentosFaltam.setEnabled(!true);
        jComboBoxTornozeleira.setSelectedItem("Selecione...");
        jComboBoxTornozeleira.setEnabled(!true);
        // Desabilitar os campos
        jMatriculaPenal.setEnabled(!true);
        jDataCadastro.setEnabled(!true);
        jDataNascimento.setEnabled(!true);
        jNomeInterno.setEnabled(!true);
        jMaeInterno.setEnabled(!true);
        jPaiInterno.setEnabled(!true);
        jAlcunha.setEnabled(!true);
        jRGInterno.setEnabled(!true);
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
        jComboBoxDocumentacaoCompleta.setEnabled(!true);
        jComboBoxQuaisDocumentosFaltam.setEnabled(!true);
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
        jBtImportarProntuario.setEnabled(!true);
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
        jComboBoxDocumentacaoCompleta.setEnabled(!true);
        jComboBoxQuaisDocumentosFaltam.setEnabled(!true);
        jComboBoxTornozeleira.setEnabled(!true);
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
        jBtImportarProntuario.setEnabled(!true);
        //
        jBtAdicionarDocumento.setEnabled(!true);
        jBtExcluirRegistro.setEnabled(!true);
    }

    public void Cancelar() {

        if (jIdInterno.getText().equals("")) {
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
            jCPFInterno.setText("");
            jCartaoSus.setText("");
            jComboBoxEscolaridade.setSelectedItem("Selecione...");
            jComboBoxEstadoCivil.setSelectedItem("Selecione...");
            jComboBoxSexo.setSelectedItem("");
            jSituacao.setText("");
            jComboBoxCutis.setSelectedItem("Selecione...");
            jComboBoxOlhos.setSelectedItem("Selecione...");
            jComboBoxCabelos.setSelectedItem("Selecione...");
            jComboBoxBarba.setSelectedItem("Selecione...");
            jComboBoxBigode.setSelectedItem("Selecione...");
            jComboBoxNariz.setSelectedItem("Selecione...");
            jComboBoxBoca.setSelectedItem("Selecione...");
            jComboBoxRosto.setSelectedItem("Selecione...");
            jComboBoxLabios.setSelectedItem("Selecione...");
            jComboBoxParticipacao.setSelectedItem("Selecione...");
            jComboBoxRegime.setSelectedItem("Selecione...");
            jComboBoxEdiondo.setSelectedItem("Selecione...");
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
            jComboBoxOrelha.setSelectedItem("Selecione...");
            jComboBoxPescoco.setSelectedItem("Selecione...");
            jComboBoxCompleicao.setSelectedItem("Selecione...");
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
            jComboBoxDocumentacaoCompleta.setSelectedItem("Selecione...");
            jComboBoxQuaisDocumentosFaltam.setSelectedItem("Selecione...");
            jComboBoxDocumentacaoCompleta.setEnabled(!true);
            jComboBoxQuaisDocumentosFaltam.setEnabled(!true);
            jComboBoxTornozeleira.setSelectedItem("Selecione...");
            jComboBoxTornozeleira.setEnabled(!true);
            // Desabilitar os campos
            jMatriculaPenal.setEnabled(!true);
            jDataCadastro.setEnabled(!true);
            jDataNascimento.setEnabled(!true);
            jNomeInterno.setEnabled(!true);
            jMaeInterno.setEnabled(!true);
            jPaiInterno.setEnabled(!true);
            jAlcunha.setEnabled(!true);
            jRGInterno.setEnabled(!true);
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
            jComboBoxDocumentacaoCompleta.setEnabled(!true);
            jComboBoxQuaisDocumentosFaltam.setEnabled(!true);
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
            jBtImportarProntuario.setEnabled(!true);
            //
            jBtAdicionarDocumento.setEnabled(!true);
            jBtExcluirRegistro.setEnabled(!true);
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
            jComboBoxDocumentacaoCompleta.setEnabled(!true);
            jComboBoxQuaisDocumentosFaltam.setEnabled(!true);
            jComboBoxTornozeleira.setEnabled(!true);
            // Habilitar/Desabilitar  Botões
            jBtZoonFoto.setEnabled(true);
            jBtNovaFoto.setEnabled(!true);
            jBtExcluirFoto.setEnabled(!true);
            jBtPesqPais.setEnabled(!true);
            jBtPesqCidade.setEnabled(!true);
            jBtPesqCidadeEnd.setEnabled(!true);
            jBtPeculiaridadeCostas.setEnabled(true);
            jBtPeculiaridadeFrente.setEnabled(true);
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
            jBtImportarProntuario.setEnabled(!true);
            //
            jBtAdicionarDocumento.setEnabled(!true);
            jBtExcluirRegistro.setEnabled(!true);
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

    // Verificar se o interno já tem movimentação, não deixar excluir    
    public void verificarEntradaInterno() {
        statusMov = "Excluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENSENTRADA WHERE IdInternoCrc='" + jIdInterno.getText() + "'");
            conecta.rs.first();
            codInternoCrc = conecta.rs.getString("IdInternoCrc");
        } catch (SQLException ex) {
        }
        if (jIdInterno.getText().equals(codInternoCrc)) {
            JOptionPane.showMessageDialog(rootPane, "Esse interno não pode ser excluído, existe movimentação para o mesmo!!!");
        } else {
            objDadosPena.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
            objDadosFis.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
            objProCrc.setIdInterno(Integer.valueOf(jIdInterno.getText()));
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir PRONTUÁRIO selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                try {
                    controlPenais.excluirDadosPenais(objDadosPena);
                    controlFisicos.excluirDadosFisicos(objDadosFis);
                    control.excluirInternoCrc(objProCrc);
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso...");
                    Excluir();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Não foi possivel excluir o registro\nERRO: " + ex);
                }
            }
        }
    }

    public void buscarCodInt() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC");
            conecta.rs.last();
            jIdInterno.setText(conecta.rs.getString("IdInternoCrc"));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possivel identificar o número do prontuario... \nERRO: " + e);
        }
        conecta.desconecta();
    }

    // Método de pesquisa pela Descrição
    public void preencherTabelaNome(String sql) {
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
    public void preencherTodosInternos(String sql) {
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
                //                        
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                jtotalRegistrosTMP.setText(Integer.toString(pSAIDA_TEMP = pSAIDA_TEMP));
                jtotalRegistrosPDC.setText(Integer.toString(pSAIDA_COVID = pSAIDA_COVID));
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
//        alinharCamposTabelaProntuario();
        corNaLinha();
        conecta.desconecta();
    }

    // Método de pesquisa pela Matricula
    public void buscarInternosMatricula(String sql) {
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
//        alinharCamposTabelaProntuario();
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
        jTabelaInterno.getColumnModel().getColumn(4).setCellRenderer(centralizado);
        jTabelaInterno.getColumnModel().getColumn(6).setCellRenderer(centralizado);
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
            conecta.executaSQL("SELECT * FROM ITENSENTRADAPORTARIA "
                    + "WHERE NomeInterno='" + jNomeInterno.getText() + "'");
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

    public void verificarParamentrosCrc() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PARAMETROSCRC");
            conecta.rs.first();
            codParametrosEntrada = conecta.rs.getString("EntradasPortaria");
        } catch (SQLException ex) {
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

    // FICHA JURÍDICA
    public void preencherTabelaProcessos(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nr. Processo", "Nr. Inquérito", "Regime", "Anos", "Meses", "Dias", "Data Inicio", "Data Término"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                // Formatar a data no formato Brasil
                dataInicioProcesso = conecta.rs.getString("DataInicio");
                if (dataInicioProcesso != null) {
                    String diaIp = dataInicioProcesso.substring(8, 10);
                    String mesIp = dataInicioProcesso.substring(5, 7);
                    String anoIp = dataInicioProcesso.substring(0, 4);
                    dataInicioProcesso = diaIp + "/" + mesIp + "/" + anoIp;
                }
                //
                dataTerminoProcesso = conecta.rs.getString("DataTermino");
                if (dataTerminoProcesso != null) {
                    String diaTp = dataTerminoProcesso.substring(8, 10);
                    String mesTp = dataTerminoProcesso.substring(5, 7);
                    String anoTp = dataTerminoProcesso.substring(0, 4);
                    dataTerminoProcesso = diaTp + "/" + mesTp + "/" + anoTp;
                }
                dados.add(new Object[]{conecta.rs.getString("IdProc"), conecta.rs.getString("NrProcesso"), conecta.rs.getString("Inquerito"), conecta.rs.getString("Regime"), conecta.rs.getString("Anos"), conecta.rs.getString("Meses"), conecta.rs.getString("Dias"), dataInicioProcesso, dataTerminoProcesso});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaProcesso.setModel(modelo);
        jTabelaProcesso.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaProcesso.getColumnModel().getColumn(0).setResizable(false);
        jTabelaProcesso.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTabelaProcesso.getColumnModel().getColumn(1).setResizable(false);
        jTabelaProcesso.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTabelaProcesso.getColumnModel().getColumn(2).setResizable(false);
        jTabelaProcesso.getColumnModel().getColumn(3).setPreferredWidth(70);
        jTabelaProcesso.getColumnModel().getColumn(3).setResizable(false);
        jTabelaProcesso.getColumnModel().getColumn(4).setPreferredWidth(70);
        jTabelaProcesso.getColumnModel().getColumn(4).setResizable(false);
        jTabelaProcesso.getColumnModel().getColumn(5).setPreferredWidth(70);
        jTabelaProcesso.getColumnModel().getColumn(5).setResizable(false);
        jTabelaProcesso.getColumnModel().getColumn(6).setPreferredWidth(70);
        jTabelaProcesso.getColumnModel().getColumn(6).setResizable(false);
        jTabelaProcesso.getColumnModel().getColumn(7).setPreferredWidth(70);
        jTabelaProcesso.getColumnModel().getColumn(7).setResizable(false);
        jTabelaProcesso.getColumnModel().getColumn(8).setPreferredWidth(80);
        jTabelaProcesso.getColumnModel().getColumn(8).setResizable(false);
        jTabelaProcesso.setAutoResizeMode(jTabelaProcesso.AUTO_RESIZE_OFF);
        jTabelaProcesso.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaProcessos();
        conecta.desconecta();
    }

    public void alinharCamposTabelaProcessos() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaProcesso.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaProcesso.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaProcesso.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        jTabelaProcesso.getColumnModel().getColumn(3).setCellRenderer(centralizado);
        jTabelaProcesso.getColumnModel().getColumn(4).setCellRenderer(centralizado);
        jTabelaProcesso.getColumnModel().getColumn(5).setCellRenderer(centralizado);
        jTabelaProcesso.getColumnModel().getColumn(6).setCellRenderer(centralizado);
        jTabelaProcesso.getColumnModel().getColumn(7).setCellRenderer(centralizado);
        jTabelaProcesso.getColumnModel().getColumn(8).setCellRenderer(centralizado);
    }

    public void limparTabelaProcessos() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nr. Processo", "Nr. Inquérito", "Regime", "Anos", "Meses", "Dias", "Data Inicio", "Data Término"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaProcesso.setModel(modelo);
        jTabelaProcesso.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaProcesso.getColumnModel().getColumn(0).setResizable(false);
        jTabelaProcesso.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTabelaProcesso.getColumnModel().getColumn(1).setResizable(false);
        jTabelaProcesso.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTabelaProcesso.getColumnModel().getColumn(2).setResizable(false);
        jTabelaProcesso.getColumnModel().getColumn(3).setPreferredWidth(70);
        jTabelaProcesso.getColumnModel().getColumn(3).setResizable(false);
        jTabelaProcesso.getColumnModel().getColumn(4).setPreferredWidth(70);
        jTabelaProcesso.getColumnModel().getColumn(4).setResizable(false);
        jTabelaProcesso.getColumnModel().getColumn(5).setPreferredWidth(70);
        jTabelaProcesso.getColumnModel().getColumn(5).setResizable(false);
        jTabelaProcesso.getColumnModel().getColumn(6).setPreferredWidth(70);
        jTabelaProcesso.getColumnModel().getColumn(6).setResizable(false);
        jTabelaProcesso.getColumnModel().getColumn(7).setPreferredWidth(70);
        jTabelaProcesso.getColumnModel().getColumn(7).setResizable(false);
        jTabelaProcesso.getColumnModel().getColumn(8).setPreferredWidth(80);
        jTabelaProcesso.getColumnModel().getColumn(8).setResizable(false);
        jTabelaProcesso.setAutoResizeMode(jTabelaProcesso.AUTO_RESIZE_OFF);
        jTabelaProcesso.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void preencherTabelaIncidenciaPenal(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Amparo Legal", "Artigo", "Parágrafo", "Inciso", "Alínea"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdInc"), conecta.rs.getString("DescricaoAmparoLegal"), conecta.rs.getString("Artigo"), conecta.rs.getString("Paragrafo"), conecta.rs.getString("Inciso"), conecta.rs.getString("Alinea")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaAmparoLegal.setModel(modelo);
        jTabelaAmparoLegal.getColumnModel().getColumn(0).setPreferredWidth(80);
        jTabelaAmparoLegal.getColumnModel().getColumn(0).setResizable(false);
        jTabelaAmparoLegal.getColumnModel().getColumn(1).setPreferredWidth(310);
        jTabelaAmparoLegal.getColumnModel().getColumn(1).setResizable(false);
        jTabelaAmparoLegal.getColumnModel().getColumn(2).setPreferredWidth(50);
        jTabelaAmparoLegal.getColumnModel().getColumn(2).setResizable(false);
        jTabelaAmparoLegal.getColumnModel().getColumn(3).setPreferredWidth(100);
        jTabelaAmparoLegal.getColumnModel().getColumn(3).setResizable(false);
        jTabelaAmparoLegal.getColumnModel().getColumn(4).setPreferredWidth(50);
        jTabelaAmparoLegal.getColumnModel().getColumn(4).setResizable(false);
        jTabelaAmparoLegal.getColumnModel().getColumn(5).setPreferredWidth(50);
        jTabelaAmparoLegal.getColumnModel().getColumn(5).setResizable(false);
        jTabelaAmparoLegal.setAutoResizeMode(jTabelaAmparoLegal.AUTO_RESIZE_OFF);
        jTabelaAmparoLegal.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaAmparoLegal();
        conecta.desconecta();
    }

    public void alinharCamposTabelaAmparoLegal() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //       
        jTabelaAmparoLegal.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaAmparoLegal.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        jTabelaAmparoLegal.getColumnModel().getColumn(3).setCellRenderer(centralizado);
        jTabelaAmparoLegal.getColumnModel().getColumn(4).setCellRenderer(centralizado);
        jTabelaAmparoLegal.getColumnModel().getColumn(5).setCellRenderer(centralizado);
    }

    public void limparTabelaAmparolegal() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Amparo Legal", "Artigo", "Parágrafo", "Inciso", "Alínea"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaAmparoLegal.setModel(modelo);
        jTabelaAmparoLegal.getColumnModel().getColumn(0).setPreferredWidth(80);
        jTabelaAmparoLegal.getColumnModel().getColumn(0).setResizable(false);
        jTabelaAmparoLegal.getColumnModel().getColumn(1).setPreferredWidth(310);
        jTabelaAmparoLegal.getColumnModel().getColumn(1).setResizable(false);
        jTabelaAmparoLegal.getColumnModel().getColumn(2).setPreferredWidth(50);
        jTabelaAmparoLegal.getColumnModel().getColumn(2).setResizable(false);
        jTabelaAmparoLegal.getColumnModel().getColumn(3).setPreferredWidth(100);
        jTabelaAmparoLegal.getColumnModel().getColumn(3).setResizable(false);
        jTabelaAmparoLegal.getColumnModel().getColumn(4).setPreferredWidth(50);
        jTabelaAmparoLegal.getColumnModel().getColumn(4).setResizable(false);
        jTabelaAmparoLegal.getColumnModel().getColumn(5).setPreferredWidth(50);
        jTabelaAmparoLegal.getColumnModel().getColumn(5).setResizable(false);
        jTabelaAmparoLegal.setAutoResizeMode(jTabelaAmparoLegal.AUTO_RESIZE_OFF);
        jTabelaAmparoLegal.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void preencherTabelaDocumentosProcessos(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Natureza da Prisão", "Documento", "Origem", "Data", "Horário"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dataDoc = conecta.rs.getString("DataDoc");
                String dia = dataDoc.substring(8, 10);
                String mes = dataDoc.substring(5, 7);
                String ano = dataDoc.substring(0, 4);
                dataDoc = dia + "/" + mes + "/" + ano;
                dados.add(new Object[]{conecta.rs.getInt("IdDocPro"), conecta.rs.getString("DescricaoNatureza"), conecta.rs.getString("Documento"), conecta.rs.getString("OrigemDoc"), dataDoc, conecta.rs.getString("HoraDoc")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaDocumentosProcesso.setModel(modelo);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(0).setResizable(false);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(1).setResizable(false);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(2).setPreferredWidth(70);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(2).setResizable(false);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(3).setPreferredWidth(120);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(3).setResizable(false);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(4).setPreferredWidth(70);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(4).setResizable(false);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(5).setPreferredWidth(70);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(5).setResizable(false);
        jTabelaDocumentosProcesso.setAutoResizeMode(jTabelaDocumentosProcesso.AUTO_RESIZE_OFF);
        jTabelaDocumentosProcesso.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaDocumentosProcessos();
        conecta.desconecta();
    }

    public void alinharCamposTabelaDocumentosProcessos() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //       
        jTabelaDocumentosProcesso.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(3).setCellRenderer(centralizado);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(4).setCellRenderer(centralizado);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(5).setCellRenderer(centralizado);
    }

    public void limparTabelaDocumentos() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Natureza da Prisão", "Documento", "Origem", "Data", "Horário"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaDocumentosProcesso.setModel(modelo);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(0).setResizable(false);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(1).setResizable(false);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(2).setPreferredWidth(70);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(2).setResizable(false);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(3).setPreferredWidth(120);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(3).setResizable(false);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(4).setPreferredWidth(70);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(4).setResizable(false);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(5).setPreferredWidth(70);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(5).setResizable(false);
        jTabelaDocumentosProcesso.setAutoResizeMode(jTabelaDocumentosProcesso.AUTO_RESIZE_OFF);
        jTabelaDocumentosProcesso.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void limparCamposFichaJuridica() {
        // ABA PROCESSOS
        jNumeroProcesso.setText("");
        jNumeroInquerito.setText("");
        jComboBoxRegimeProcesso.setSelectedItem(null);
        jAnos.setText("");
        jMeses.setText("");
        jDias.setText("");
        jDataInicioProcesso.setDate(null);
        jDataTerminoProcesso.setDate(null);
        jTotalDias.setText("");
        jObservacaoProcesso.setText("");
        //ABA INCIDENCIA PENAL
        jIdAmparo.setText("");
        jDescricaoAmparoLegal.setText("");
        jComboBoxArtigo.setText("");
        jComboBoxParagrafo.setText("");
        jComboBoxInciso.setText("");
        jComboBoxAlinea.setText("");
        // ABA DOCUMENTO DO PROCESSO
        jIdNatp.setText("");
        jDescricaoNaturezaPrisao.setText("");
        jDocumentoPrisao.setText("");
        jOrigemDocumentoPrisao.setText("");
        jDataDocumentoPrisao.setDate(null);
        jHoraDocumento.setText("");
    }

    /**
     * Método para verifica se determinado cpf é válido.
     *
     * @param xCPF
     * @param cpf - Uma String contendo o cpf.
     * @return true se o cpf é válido e false se não é válido.
     * @author FONTE: www.guj.com.br
     */
    public static boolean validaCpf(String xCPF) {
        try {
            int d1, d4, xx, nCount, resto, digito1, digito2;
            String Check;
            String Separadores = "/-.";
            d1 = 0;
            d4 = 0;
            xx = 1;
            for (nCount = 0; nCount < xCPF.length() - 2; nCount++) {
                String s_aux = xCPF.substring(nCount, nCount + 1);

                if (Separadores.indexOf(s_aux) == -1) {
                    d1 = d1 + (11 - xx) * Integer.valueOf(s_aux).intValue();
                    d4 = d4 + (12 - xx) * Integer.valueOf(s_aux).intValue();
                    xx++;
                }
            }
            resto = (d1 % 11);
            if (resto < 2) {
                digito1 = 0;
            } else {
                digito1 = 11 - resto;
            }
            d4 = d4 + 2 * digito1;
            resto = (d4 % 11);

            if (resto < 2) {
                digito2 = 0;
            } else {
                digito2 = 11 - resto;
            }
            Check = String.valueOf(digito1) + String.valueOf(digito2);
            String s_aux2 = xCPF.substring(xCPF.length() - 2, xCPF.length());
            if (s_aux2.compareTo(Check) != 0) {
                JOptionPane.showMessageDialog(null, "CPF digitado é inválido.");
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void buscarAcessoUsuario(String nomeTelaAcesso) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nameUser + "'");
            conecta.rs.first();
            codigoUserCRC = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUserCRC + "'");
            conecta.rs.first();
            codigoUserGroupCRC = conecta.rs.getInt("IdUsuario");
            codigoGrupoCRC = conecta.rs.getInt("IdGrupo");
            nomeGrupoCRC = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUserCRC + "' "
                    + "AND NomeTela='" + nomeTelaAcesso + "'");
            conecta.rs.first();
            codUserAcessoCRC = conecta.rs.getInt("IdUsuario");
            codAbrirCRC = conecta.rs.getInt("Abrir");
            codIncluirCRC = conecta.rs.getInt("Incluir");
            codAlterarCRC = conecta.rs.getInt("Alterar");
            codExcluirCRC = conecta.rs.getInt("Excluir");
            codGravarCRC = conecta.rs.getInt("Gravar");
            codConsultarCRC = conecta.rs.getInt("Consultar");
            nomeTelaCRC = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    //GRAVAR OS DOCUMENTOS REFERENTE AO INTERNO
    public void gravarDocumentos() {

        for (int i = 0; i < jTabelaDocumentos.getRowCount(); i++) {
            objProCrc.setIdInterno(Integer.valueOf(jIdInterno.getText()));
            objProCrc.setNomeInterno(jNomeInterno.getText());
            objProCrc.setIdChek((int) jTabelaDocumentos.getValueAt(i, 0));
            objProCrc.setDescricaoDoc((String) jTabelaDocumentos.getValueAt(i, 1));
            verificarInternoBancoDados(objProCrc.getIdInterno(), objProCrc.getIdChek());
            if (c_INTERNO == 0) {
                controleDoc.incluirDocumentoInternoCrc(objProCrc);
            } else if (c_INTERNO == objProCrc.getIdInterno() && c_REGISTRO != objProCrc.getIdChek()) {
                controleDoc.incluirDocumentoInternoCrc(objProCrc);
            }
        }
    }

    public void consultaDocumentos() {

        DefaultTableModel dadosOrigem = (DefaultTableModel) jTabelaDocumentos.getModel();
        ProntuarioCrc d = new ProntuarioCrc();
        try {
            for (ProntuarioCrc dd : controleDoc.read()) {
                dadosOrigem.addRow(new Object[]{dd.getIdChek(), dd.getDescricaoDoc()});
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaDocumentos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaDocumentos.getColumnModel().getColumn(0).setCellRenderer(centralizado);

            }
        } catch (Exception ex) {
            Logger.getLogger(TelaMontagemPagamentoKitInterno.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void limparTabela() {
        // APAGAR LINHA SELECIONADA
        if (jTabelaDocumentos.getSelectedRow() != -1) {
            DefaultTableModel dtm = (DefaultTableModel) jTabelaDocumentos.getModel();
            dtm.removeRow(jTabelaDocumentos.getSelectedRow());
        }
        // APAGAR TODO O CONTEUDO DA TABELA
        while (jTabelaDocumentos.getModel().getRowCount() > 0) {
            ((DefaultTableModel) jTabelaDocumentos.getModel()).removeRow(0);
        }
    }

    //VERIFICAR SE JÁ FOI GRAVADO O INTERNO COM OS DOCUMENTOS
    public void verificarInternoBancoDados(int codigoInterno, int codDocumento) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM LISTA_DOCUMENTOS_INTERNO_CRC "
                    + "WHERE IdInternoCrc='" + codigoInterno + "' "
                    + "AND IdChek='" + codDocumento + "'");
            conecta.rs.last();
            c_INTERNO = conecta.rs.getInt("IdInternoCrc");
            c_REGISTRO = conecta.rs.getInt("IdChek");
        } catch (Exception ERROR) {
        }
        conecta.desconecta();
    }

    public void documentosInterno(String descricaoDoc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM CHECK_LIST_DOCUMENTOS_INTERNO_CRC "
                    + "WHERE DescricaoDocumentos='" + descricaoDoc + "'");
            conecta.rs.first();
            idChek = conecta.rs.getInt("IdChek");
            objProCrc.setIdChek(idChek);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados dos DOCUMENTOS a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
