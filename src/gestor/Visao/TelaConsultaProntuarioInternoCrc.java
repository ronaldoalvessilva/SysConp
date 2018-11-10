/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleDadosFisicos;
import gestor.Controle.ControleDadosPenais;
import gestor.Controle.ControleInternoCrc;
import gestor.Controle.ControleLogSistema;
import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.LimiteDigitos;
import gestor.Dao.LimiteDigitosAlfa;
import gestor.Dao.LimiteDigitosNum;
import gestor.Dao.LimiteDigitosSoNum;
import gestor.Dao.ModeloTabela;
import gestor.Modelo.DadosFisicosInternos;
import gestor.Modelo.DadosPenaisCrc;
import gestor.Modelo.LogSistema;
import gestor.Modelo.ProntuarioCrc;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloEnfermaria.codAlterarENF;
import static gestor.Visao.TelaModuloEnfermaria.codExcluirENF;
import static gestor.Visao.TelaModuloEnfermaria.codGravarENF;
import static gestor.Visao.TelaModuloEnfermaria.codConsultarENF;
import static gestor.Visao.TelaModuloEnfermaria.nomeGrupoENF;
import static gestor.Visao.TelaModuloEnfermaria.nomeTelaENF;
import static gestor.Visao.TelaModuloEnfermaria.telaConsultaProntuarioInternosDocENF;
import static gestor.Visao.TelaModuloJuridico.codigoUserGroupJURI;
import static gestor.Visao.TelaModuloJuridico.codigoGrupoJURI;
import static gestor.Visao.TelaModuloJuridico.codIncluirJURI;
import static gestor.Visao.TelaModuloJuridico.codAlterarJURI;
import static gestor.Visao.TelaModuloJuridico.codExcluirJURI;
import static gestor.Visao.TelaModuloJuridico.codGravarJURI;
import static gestor.Visao.TelaModuloJuridico.codAbrirJURI;
import static gestor.Visao.TelaModuloJuridico.codUserAcessoJURI;
import static gestor.Visao.TelaModuloJuridico.codigoUserJURI;
import static gestor.Visao.TelaModuloJuridico.nomeGrupoJURI;
import static gestor.Visao.TelaModuloJuridico.nomeTelaJURI;
import static gestor.Visao.TelaModuloJuridico.telaConsultaProntuarioInternosDocJURI;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaModuloPsicologia.codigoUserGroupPSI;
import static gestor.Visao.TelaModuloPsicologia.codigoGrupoPSI;
import static gestor.Visao.TelaModuloPsicologia.codAbrirPSI;
import static gestor.Visao.TelaModuloPsicologia.codIncluirPSI;
import static gestor.Visao.TelaModuloPsicologia.codAlterarPSI;
import static gestor.Visao.TelaModuloPsicologia.codExcluirPSI;
import static gestor.Visao.TelaModuloPsicologia.codGravarPSI;
import static gestor.Visao.TelaModuloPsicologia.codConsultarPSI;
import static gestor.Visao.TelaModuloPsicologia.codUserAcessoPSI;
import static gestor.Visao.TelaModuloPsicologia.codigoUserPSI;
import static gestor.Visao.TelaModuloPsicologia.nomeGrupoPSI;
import static gestor.Visao.TelaModuloPsicologia.nomeTelaPSI;
import static gestor.Visao.TelaModuloPsicologia.telaConsultaProntuarioInternosDocPSI;
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
import static gestor.Visao.TelaModuloJuridico.codConsultarJURI;
import static gestor.Visao.TelaModuloEnfermaria.codigoUserENF;
import static gestor.Visao.TelaModuloEnfermaria.codUserAcessoENF;
import static gestor.Visao.TelaModuloEnfermaria.codigoUserGroupENF;
import static gestor.Visao.TelaModuloEnfermaria.codAbrirENF;
import static gestor.Visao.TelaModuloEnfermaria.codIncluirENF;
import java.awt.Component;
import javax.swing.JTable;

/**
 *
 * @author user
 */
public final class TelaConsultaProntuarioInternoCrc extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ProntuarioCrc objProCrc = new ProntuarioCrc();
    DadosPenaisCrc objDadosPena = new DadosPenaisCrc();
    DadosFisicosInternos objDadosFis = new DadosFisicosInternos();
    ControleInternoCrc control = new ControleInternoCrc();
    ControleDadosFisicos controlFisicos = new ControleDadosFisicos();
    ControleDadosPenais controlPenais = new ControleDadosPenais();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    //
    int acao;
    int flag;
    String codInternoCrc; // Verificar se existe movimentação do intero para não ser excluído
    String nomePais;
    String dataEntrada;
    String dataCadastro;
    String caminho;
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
    // LIBERAÇÃO DA OBSERVAÇÃO PARA GRUPO DE ADMINISTRADORES
    int codigoUsuario;
    int codigoGrupo;
    int codigoGrupoAdm = 1;
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
    String CLASS = "";
    Color c = Color.BLACK;
    // VARIAVEIS PARA ALERTA QUANTO AS DOENÇAS DOS INTERNOS.
    String pHepatiteB = "Reagente";   // Reagente ou Não reagente
    String pHepatiteC = "Reagente";   // Reagente ou Não reagente
    String pHiv = "Reagente";         // Reagente ou Não reagente
    String pSifilis = "Reagente";     // Reagente ou Não reagente
    String pHipertensao = "Sim";      // Sim ou Não
    String pDiabetes = "Sim";         // Sim ou Não
    String pTuberculose = "Positivo"; // Negativo ou Positivo
    String pAlergias = "Sim";         // Sim ou Não

    /**
     * Creates new form TelaTriagem
     */
// VARIÁVEL PARA MOSTRAR FOTO NO JDIALOG (TELAFOTO)
//    public static int codInternocrc;    
    // BUSCAR TELA DE FOTO MAIOR
    public static TelaFotoCrcConsulta telafotocrc;
    public static TelaPeculiaridadeConsultaInternosCrc telaPeculiaridade;
    public static TelaPeculiaridadeConsultaFrente telaPeculiaridadeFrente;
    //
    public static TelaConsultaEvolucaoPsicologia telaConsultaPsi;
    public static TelaConsultaEvolucaoServicoSocial telaConsultaSS;
    public static TelaConsultaEvolucaoTerapiaOcupacional telaConultaTO;
    public static TelaConsultaEvolucaoOdontologia telaConsultaOdonto;
    //
    public static TelaConsultaEvolucaoMedicaClinica telaConsultaMC;
    public static TelaConsultaEvolucaoMedicaPsiquiatrica telaConsultaPSIQ;
    public static TelaConsultaEvolucaoEnfermagem telaConsultaENF;
    //
    public static TelaConsultaPrescricaoMedicaClinica telaPrescricaoMedicaCLI;
    public static TelaConsultaPrescricaoMedicaPsiquiatrica telaPrescricaoMedicaPSIQ;
    public static TelaConsultaPrescricaoMedicaOdontologica telaPrescricaoODO;
    //
    public static TelaConsultaDietaMedica telaDietaMedica;
    public static TelaConsultaAtestadoMedico telaAtestado;
    //
    public static TelaObservacaoProntuarioUnico telaObsInterno;
    public static TelaConsultaExamesMedicos telaConsultaExames;
    //
    public static PdfViewPSP consultaDocInternos;
    //
    public static TelaConsultaTestesRapidos consultaRapida;

    public TelaConsultaProntuarioInternoCrc() {
        super();
        initComponents();
        setResizable(false);
        corCampos();
        formatarCampos();
        buscarCaminhoTempleteImagem();
    }

    public void mostraTelaFotoCrcConsulta() {
        telafotocrc = new TelaFotoCrcConsulta(this, true);
        telafotocrc.setVisible(true);
    }

    public void mostrarTelaPeculiaridadeConsulta() {
        telaPeculiaridade = new TelaPeculiaridadeConsultaInternosCrc(this, true);
        telaPeculiaridade.setVisible(true);
    }

    public void mostrarTelaPeculiaridadeConsultaFrente() {
        telaPeculiaridadeFrente = new TelaPeculiaridadeConsultaFrente(this, true);
        telaPeculiaridadeFrente.setVisible(true);
    }

    public void mostrarConsultaPsi() {
        telaConsultaPsi = new TelaConsultaEvolucaoPsicologia(this, true);
        telaConsultaPsi.setVisible(true);
    }

    public void mostrarConsultaSS() {
        telaConsultaSS = new TelaConsultaEvolucaoServicoSocial(this, true);
        telaConsultaSS.setVisible(true);
    }

    public void mostrarConsultaTO() {
        telaConultaTO = new TelaConsultaEvolucaoTerapiaOcupacional(this, true);
        telaConultaTO.setVisible(true);
    }

    public void mostrarConsultaOdonto() {
        telaConsultaOdonto = new TelaConsultaEvolucaoOdontologia(this, true);
        telaConsultaOdonto.setVisible(true);
    }

    public void mostrarConsultaMedicaClinica() {
        telaConsultaMC = new TelaConsultaEvolucaoMedicaClinica(this, true);
        telaConsultaMC.setVisible(true);
    }

    public void mostrarConsultaPsiquiatrica() {
        telaConsultaPSIQ = new TelaConsultaEvolucaoMedicaPsiquiatrica(this, true);
        telaConsultaPSIQ.setVisible(true);
    }

    public void mostrarConsultaEnfermagem() {
        telaConsultaENF = new TelaConsultaEvolucaoEnfermagem(this, true);
        telaConsultaENF.setVisible(true);
    }

    public void mostrarPrescricaoMedicaClinica() {
        telaPrescricaoMedicaCLI = new TelaConsultaPrescricaoMedicaClinica(this, true);
        telaPrescricaoMedicaCLI.setVisible(true);
    }

    public void mostrarPrescricaoMedicaPsiquiatrica() {
        telaPrescricaoMedicaPSIQ = new TelaConsultaPrescricaoMedicaPsiquiatrica(this, true);
        telaPrescricaoMedicaPSIQ.setVisible(true);
    }

    public void mostrarPrescricaoOdontologica() {
        telaPrescricaoODO = new TelaConsultaPrescricaoMedicaOdontologica(this, true);
        telaPrescricaoODO.setVisible(true);
    }

    public void mostrarDietasMedicas() {
        telaDietaMedica = new TelaConsultaDietaMedica(this, true);
        telaDietaMedica.setVisible(true);
    }

    public void mostrarAtestadosMedicos() {
        telaAtestado = new TelaConsultaAtestadoMedico(this, true);
        telaAtestado.setVisible(true);
    }

    public void mostrarObservacaoInterno() {
        telaObsInterno = new TelaObservacaoProntuarioUnico(this, true);
        telaObsInterno.setVisible(true);
    }

    public void mostrarExamesMedicos() {
        telaConsultaExames = new TelaConsultaExamesMedicos(this, true);
        telaConsultaExames.setVisible(true);
    }

    public void mostrarDocInternos() {
        consultaDocInternos = new PdfViewPSP(this, true);
        consultaDocInternos.setVisible(true);
    }

    public void mostrarTestesRapidos() {
        consultaRapida = new TelaConsultaTestesRapidos(this, true);
        consultaRapida.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
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
        jLabel163 = new javax.swing.JLabel();
        jPesquisaCNC = new javax.swing.JTextField();
        jBtCNCPesquisa = new javax.swing.JButton();
        jComboBoxOpcao = new javax.swing.JComboBox<>();
        jLabel160 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaInterno = new javax.swing.JTable();
        jPanel30 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jIdInternoConPSP = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jNomeInternoConPSP = new javax.swing.JTextField();
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
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jReligiao = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jProfissao = new javax.swing.JTextField();
        jRGInterno = new javax.swing.JFormattedTextField();
        jLabel60 = new javax.swing.JLabel();
        jSituacao = new javax.swing.JTextField();
        jDataCadastro = new com.toedter.calendar.JDateChooser();
        jDataNascimento = new com.toedter.calendar.JDateChooser();
        jPanel13 = new javax.swing.JPanel();
        jLabelFotoInterno = new javax.swing.JLabel();
        jComboBoxPais = new javax.swing.JTextField();
        jComboBoxCidade = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jCartaoSus = new javax.swing.JTextField();
        jBtZoonFoto = new javax.swing.JButton();
        jLabel162 = new javax.swing.JLabel();
        jCNC_PSP = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jBtImprimirProntuario = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jBtObservacao = new javax.swing.JButton();
        jBtTesteRapidos = new javax.swing.JButton();
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
        jPanel43 = new javax.swing.JPanel();
        jBtMedico = new javax.swing.JButton();
        jBtPsiquiatrico = new javax.swing.JButton();
        jBtPsicologico = new javax.swing.JButton();
        jBtAssistenciaSocial = new javax.swing.JButton();
        jBtTerapiaOcupacional = new javax.swing.JButton();
        jBtEnfermeira = new javax.swing.JButton();
        jBtOdontologica = new javax.swing.JButton();
        jPanel45 = new javax.swing.JPanel();
        jBtPrescricaoMedica = new javax.swing.JButton();
        jBtPrescricaoPsiquiatrica = new javax.swing.JButton();
        jBtPrescricaoOdontologica = new javax.swing.JButton();
        jPanel46 = new javax.swing.JPanel();
        jBtDietaMedica = new javax.swing.JButton();
        jBtAtestadoMedico = new javax.swing.JButton();
        jBtExames = new javax.swing.JButton();
        jBtDocumentos = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Prontuário de Interno {PRONTUÁRIO ÚNICO} ::: ...");
        setToolTipText("");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jPesqNome.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jPesqMatricula.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPesqMatricula.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Pesquisa Por Nome:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Pesquisa p/Matricula:");

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

        jComboBoxOpcao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxOpcao.setForeground(new java.awt.Color(204, 0, 0));
        jComboBoxOpcao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "Todos Registros", "Só Enfermaria" }));
        jComboBoxOpcao.setToolTipText("Opção para pesquisar os internos com Doenças Infectocontagiosas");
        jComboBoxOpcao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel160.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel160.setText("Opção:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel163)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPesqMatricula, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                            .addComponent(jPesquisaCNC))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtCNCPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel160, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel73, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPesqAlcunha)
                            .addComponent(jComboBoxOpcao, 0, 141, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckBox1))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jBtPesqAlcunha, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPesqNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPesqAlcunha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqAlcunha)
                    .addComponent(jLabel73)
                    .addComponent(jBtMatricula)
                    .addComponent(jPesqMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel163)
                    .addComponent(jPesquisaCNC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtCNCPesquisa)
                    .addComponent(jLabel160)
                    .addComponent(jComboBoxOpcao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(jPesqNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtNome))
                .addGap(0, 7, Short.MAX_VALUE))
        );

        jTabelaInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaInterno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome do Interno", "Matricula Penal", "Data Entrada", "Data Cadastro"
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
            jTabelaInterno.getColumnModel().getColumn(2).setMinWidth(100);
            jTabelaInterno.getColumnModel().getColumn(2).setMaxWidth(100);
            jTabelaInterno.getColumnModel().getColumn(3).setMinWidth(80);
            jTabelaInterno.getColumnModel().getColumn(3).setMaxWidth(80);
            jTabelaInterno.getColumnModel().getColumn(4).setMinWidth(80);
            jTabelaInterno.getColumnModel().getColumn(4).setMaxWidth(80);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
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
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel30, jPanel31, jPanel32});

        jTabbedPane1.addTab("Listagem", jPanel1);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Código:");

        jIdInternoConPSP.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdInternoConPSP.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdInternoConPSP.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Data Cadastro:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Nome:");

        jNomeInternoConPSP.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoConPSP.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("M.P.");

        jMatriculaPenal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jMatriculaPenal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMatriculaPenal.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Mãe:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
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
        jComboBoxSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Masculino", "Feminino" }));
        jComboBoxSexo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxSexo.setEnabled(false);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Escolaridade:");

        jComboBoxEscolaridade.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxEscolaridade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Não Alfabetizado", "Alfabetizado", "Fundamental Completo", "Fundamental Incompleto", "1º Grau Completo", "1º Grau Incompleto", "2º Grau Completo", "2º Grau Incompleto", "Superior Completo", "Superior Incompleto" }));
        jComboBoxEscolaridade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxEscolaridade.setEnabled(false);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("E.Civil:");

        jComboBoxEstadoCivil.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Casado", "Casada", "Solteiro", "Solteira", "Outros" }));
        jComboBoxEstadoCivil.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxEstadoCivil.setEnabled(false);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Nacionalidade:");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Naturalidade:");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Religião:");

        jReligiao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jReligiao.setEnabled(false);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Profissão:");

        jProfissao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jProfissao.setEnabled(false);
        jProfissao.setPreferredSize(new java.awt.Dimension(4, 17));

        jRGInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jRGInterno.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jRGInterno.setEnabled(false);

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 51, 51));
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
            .addComponent(jLabelFotoInterno, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelFotoInterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jComboBoxPais.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxPais.setEnabled(false);

        jComboBoxCidade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxCidade.setEnabled(false);

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

        jCNC_PSP.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCNC_PSP.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCNC_PSP.setEnabled(false);

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
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jDataCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jIdInternoConPSP))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel22)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jMatriculaPenal)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel162)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCNC_PSP, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jPaiInterno)
                            .addComponent(jMaeInterno)
                            .addComponent(jNomeInternoConPSP)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jAlcunha)
                                    .addComponent(jRGInterno, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCartaoSus, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCPFInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(jBtZoonFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jComboBoxEscolaridade, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jReligiao, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jProfissao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jComboBoxCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSituacao)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel60)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jComboBoxPais, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jAlcunha, jRGInterno});

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jCPFInterno, jCartaoSus, jComboBoxEstadoCivil});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2)
                        .addComponent(jBtZoonFoto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jCNC_PSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel162)
                            .addComponent(jMatriculaPenal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jIdInternoConPSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(jLabel7)
                                    .addComponent(jDataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22)
                                    .addComponent(jDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jNomeInternoConPSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                        .addComponent(jCartaoSus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(37, 37, 37))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(135, 135, 135)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(jRGInterno, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(jCPFInterno, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel9)
                        .addGap(177, 177, 177)))
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
                    .addComponent(jLabel60))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel19)
                    .addComponent(jSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jReligiao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(jProfissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jCPFInterno, jCartaoSus, jComboBoxEscolaridade, jComboBoxEstadoCivil, jLabel16, jLabel17});

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jProfissao, jSituacao});

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jBtImprimirProntuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/gtklp-icone-3770-16.png"))); // NOI18N
        jBtImprimirProntuario.setText("Impressão");
        jBtImprimirProntuario.setToolTipText("Imprimir Prontuário");
        jBtImprimirProntuario.setEnabled(false);
        jBtImprimirProntuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtImprimirProntuarioActionPerformed(evt);
            }
        });

        jBtSair.setForeground(new java.awt.Color(0, 0, 204));
        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSair.setText("Sair");
        jBtSair.setToolTipText("Sair da Tela");
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        jBtObservacao.setForeground(new java.awt.Color(0, 153, 0));
        jBtObservacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/accept.png"))); // NOI18N
        jBtObservacao.setText("Observação");
        jBtObservacao.setEnabled(false);
        jBtObservacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtObservacaoActionPerformed(evt);
            }
        });

        jBtTesteRapidos.setForeground(new java.awt.Color(204, 0, 0));
        jBtTesteRapidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_find.png"))); // NOI18N
        jBtTesteRapidos.setText("Doenças Infecto");
        jBtTesteRapidos.setToolTipText("Doenças Infectocontagiosas");
        jBtTesteRapidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtTesteRapidosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtImprimirProntuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtObservacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtTesteRapidos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtImprimirProntuario, jBtObservacao, jBtSair, jBtTesteRapidos});

        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtImprimirProntuario)
                    .addComponent(jBtSair)
                    .addComponent(jBtObservacao)
                    .addComponent(jBtTesteRapidos))
                .addContainerGap())
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtImprimirProntuario, jBtSair});

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
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jCidade))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel42)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCelular))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
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
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jCelular, jTelefone, jTelefone1});

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        jComboBoxCutis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Parda", "Negra", "Branca", "Amarela", "Indigina" }));
        jComboBoxCutis.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxCutis.setEnabled(false);

        jComboBoxOlhos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxOlhos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Azul", "Preto", "Castanho Escuro", "Castanho Claro", "Verdes" }));
        jComboBoxOlhos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxOlhos.setEnabled(false);

        jComboBoxCabelos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxCabelos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Carapinha", "Lisos", "Ondulados", "Encaracolados", "Crespos" }));
        jComboBoxCabelos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxCabelos.setEnabled(false);
        jComboBoxCabelos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCabelosActionPerformed(evt);
            }
        });

        jComboBoxBarba.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxBarba.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Rala", "Cheia", "Rapada", "Sem Barba" }));
        jComboBoxBarba.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxBarba.setEnabled(false);

        jComboBoxBigode.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxBigode.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Ralo", "Cheio", "Rapado", "Sem Bigode" }));
        jComboBoxBigode.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxBigode.setEnabled(false);

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel35.setText("Nariz:");

        jComboBoxNariz.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxNariz.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Achatado", "Afilado", "Arrebitado", "Comprido", "Curvo", "Adunco", "Pequeno", "Fino" }));
        jComboBoxNariz.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxNariz.setEnabled(false);

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel36.setText("Boca:");

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel37.setText("Rosto:");

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel38.setText("Lábios:");

        jComboBoxBoca.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxBoca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Média", "Pequena", "Grande" }));
        jComboBoxBoca.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxBoca.setEnabled(false);

        jComboBoxRosto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxRosto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Comprido", "Oval", "Quadrado", "Redondo", "Médios" }));
        jComboBoxRosto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxRosto.setEnabled(false);

        jComboBoxLabios.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxLabios.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Finos", "Grossos", "Grande", "Pequeno", "Leporinos", "Médios" }));
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
        jComboBoxOrelha.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Abertas", "Coladas", "Grandes", "Médias", "Pequenas" }));
        jComboBoxOrelha.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxOrelha.setEnabled(false);

        jComboBoxPescoco.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxPescoco.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Comprido", "Curto", "Fino", "Grosso", "Médio" }));
        jComboBoxPescoco.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxPescoco.setEnabled(false);

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel62.setText("Comple:");

        jComboBoxCompleicao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxCompleicao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Gordo", "Magro", "Médio", "Raquitico", "Trocudo" }));
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
        jComboBoxParticipacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Autor", "Co-Autor" }));
        jComboBoxParticipacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxParticipacao.setEnabled(false);

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel45.setText("Procedência:");

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel47.setText("Data Prisão:");

        jDataPrisao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataPrisao.setEnabled(false);

        jComboBoxRegime.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxRegime.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Fechado", "Aberto", "Semi-Aberto", "Provisório" }));
        jComboBoxRegime.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxRegime.setEnabled(false);

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel50.setText("Regime:");

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
        jComboBoxEdiondo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Sim", "Não" }));
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
                .addContainerGap(29, Short.MAX_VALUE)
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
                .addGap(21, 21, 21))
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
                    .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel72, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel49, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel46, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel44, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jVaraCondenacao, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxParticipacao, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDataCrime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel50)
                            .addComponent(jLabel47)
                            .addComponent(jLabel159))
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
                            .addComponent(jDataNovaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jComboBoxUnid))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(jComboBoxUnid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
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
            .addComponent(jFotoPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
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
            .addComponent(jFotoCorpo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
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
            .addComponent(jFotoCorpo1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
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
            .addComponent(jFotoCorpo2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );

        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel64.setText("Identificação");

        jIdentificador.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdentificador.setEnabled(false);

        jLabel65.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel65.setText("Perfil");

        jPerfil.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPerfil.setEnabled(false);

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
                .addGap(34, 34, 34)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addContainerGap(47, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel10Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jIdentificador, jIdentificador1, jIdentificador2, jIdentificador3, jPerfil, jRegiaoCorpo, jRegiaoCorpo1, jRegiaoCorpo2});

        jPanel10Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel12, jPanel14, jPanel15, jPanel16});

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jPanel33.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 594, Short.MAX_VALUE)
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
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
                    .addComponent(jPanel33, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addComponent(jLabel76)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtPeculiaridadeFrente)
                        .addGap(57, 57, 57))))
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jBtPeculiaridadeFrente)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel76, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addComponent(jLabel74, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addGap(0, 57, Short.MAX_VALUE)
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
                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Peculiaridade Costas", jPanel36);

        jPanel40.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Consultas Técnicas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        jPanel43.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Evoluções", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jBtMedico.setForeground(new java.awt.Color(0, 153, 0));
        jBtMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_white_star.png"))); // NOI18N
        jBtMedico.setText("Médica");
        jBtMedico.setToolTipText("Evoluçao Médica");
        jBtMedico.setEnabled(false);
        jBtMedico.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtMedicoActionPerformed(evt);
            }
        });

        jBtPsiquiatrico.setForeground(new java.awt.Color(0, 153, 0));
        jBtPsiquiatrico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_white_star.png"))); // NOI18N
        jBtPsiquiatrico.setText("Psiquiatrica");
        jBtPsiquiatrico.setToolTipText("Evoluçao Psiquiatrica");
        jBtPsiquiatrico.setEnabled(false);
        jBtPsiquiatrico.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtPsiquiatrico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPsiquiatricoActionPerformed(evt);
            }
        });

        jBtPsicologico.setForeground(new java.awt.Color(0, 153, 0));
        jBtPsicologico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_white_star.png"))); // NOI18N
        jBtPsicologico.setText("Psicologia");
        jBtPsicologico.setToolTipText("Evoluçao Psicologica");
        jBtPsicologico.setEnabled(false);
        jBtPsicologico.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtPsicologico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPsicologicoActionPerformed(evt);
            }
        });

        jBtAssistenciaSocial.setForeground(new java.awt.Color(0, 153, 0));
        jBtAssistenciaSocial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_white_star.png"))); // NOI18N
        jBtAssistenciaSocial.setText("A. Social");
        jBtAssistenciaSocial.setToolTipText("Evoluçao Assitencia Social");
        jBtAssistenciaSocial.setEnabled(false);
        jBtAssistenciaSocial.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtAssistenciaSocial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAssistenciaSocialActionPerformed(evt);
            }
        });

        jBtTerapiaOcupacional.setForeground(new java.awt.Color(0, 153, 0));
        jBtTerapiaOcupacional.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_white_star.png"))); // NOI18N
        jBtTerapiaOcupacional.setText(" T.O.");
        jBtTerapiaOcupacional.setToolTipText("Evoluçao Terapia Ocupacional");
        jBtTerapiaOcupacional.setEnabled(false);
        jBtTerapiaOcupacional.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtTerapiaOcupacional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtTerapiaOcupacionalActionPerformed(evt);
            }
        });

        jBtEnfermeira.setForeground(new java.awt.Color(0, 153, 0));
        jBtEnfermeira.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_white_star.png"))); // NOI18N
        jBtEnfermeira.setText("Enfermeira");
        jBtEnfermeira.setToolTipText("Evoluçao Jurídica");
        jBtEnfermeira.setEnabled(false);
        jBtEnfermeira.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtEnfermeira.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtEnfermeiraActionPerformed(evt);
            }
        });

        jBtOdontologica.setForeground(new java.awt.Color(0, 153, 0));
        jBtOdontologica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_white_star.png"))); // NOI18N
        jBtOdontologica.setText("Odontologica");
        jBtOdontologica.setEnabled(false);
        jBtOdontologica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtOdontologicaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtEnfermeira, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtMedico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtPsicologico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtAssistenciaSocial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtTerapiaOcupacional, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtPsiquiatrico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jBtOdontologica, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel43Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAssistenciaSocial, jBtEnfermeira, jBtMedico, jBtPsicologico, jBtPsiquiatrico, jBtTerapiaOcupacional});

        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addComponent(jBtMedico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtPsiquiatrico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtPsicologico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAssistenciaSocial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtTerapiaOcupacional)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtEnfermeira)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtOdontologica)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel45.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Prescrições", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(153, 0, 102))); // NOI18N

        jBtPrescricaoMedica.setForeground(new java.awt.Color(0, 153, 0));
        jBtPrescricaoMedica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_white_star.png"))); // NOI18N
        jBtPrescricaoMedica.setText("Médica");
        jBtPrescricaoMedica.setToolTipText("Prescrição Medica");
        jBtPrescricaoMedica.setEnabled(false);
        jBtPrescricaoMedica.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtPrescricaoMedica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPrescricaoMedicaActionPerformed(evt);
            }
        });

        jBtPrescricaoPsiquiatrica.setForeground(new java.awt.Color(0, 153, 0));
        jBtPrescricaoPsiquiatrica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_white_star.png"))); // NOI18N
        jBtPrescricaoPsiquiatrica.setText("Psiquiatrica");
        jBtPrescricaoPsiquiatrica.setEnabled(false);
        jBtPrescricaoPsiquiatrica.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtPrescricaoPsiquiatrica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPrescricaoPsiquiatricaActionPerformed(evt);
            }
        });

        jBtPrescricaoOdontologica.setForeground(new java.awt.Color(0, 153, 0));
        jBtPrescricaoOdontologica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_white_star.png"))); // NOI18N
        jBtPrescricaoOdontologica.setText("Odontologica");
        jBtPrescricaoOdontologica.setEnabled(false);
        jBtPrescricaoOdontologica.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtPrescricaoOdontologica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPrescricaoOdontologicaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jBtPrescricaoPsiquiatrica, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtPrescricaoOdontologica, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtPrescricaoMedica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addComponent(jBtPrescricaoMedica)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtPrescricaoPsiquiatrica)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtPrescricaoOdontologica)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel46.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Outros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jBtDietaMedica.setForeground(new java.awt.Color(0, 153, 0));
        jBtDietaMedica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_white_star.png"))); // NOI18N
        jBtDietaMedica.setText("D. Médicas");
        jBtDietaMedica.setToolTipText("Dietas Médicas");
        jBtDietaMedica.setEnabled(false);
        jBtDietaMedica.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtDietaMedica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtDietaMedicaActionPerformed(evt);
            }
        });

        jBtAtestadoMedico.setForeground(new java.awt.Color(0, 153, 0));
        jBtAtestadoMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_white_star.png"))); // NOI18N
        jBtAtestadoMedico.setText("A. Médico");
        jBtAtestadoMedico.setToolTipText("Atestado Médico");
        jBtAtestadoMedico.setEnabled(false);
        jBtAtestadoMedico.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtAtestadoMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAtestadoMedicoActionPerformed(evt);
            }
        });

        jBtExames.setForeground(new java.awt.Color(0, 153, 0));
        jBtExames.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_white_star.png"))); // NOI18N
        jBtExames.setText("Exames");
        jBtExames.setToolTipText("Exames Médicos");
        jBtExames.setEnabled(false);
        jBtExames.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtExames.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExamesActionPerformed(evt);
            }
        });

        jBtDocumentos.setForeground(new java.awt.Color(51, 153, 0));
        jBtDocumentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Pdf16.png"))); // NOI18N
        jBtDocumentos.setText("Documentos");
        jBtDocumentos.setToolTipText("Documentação do Interno");
        jBtDocumentos.setEnabled(false);
        jBtDocumentos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtDocumentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtDocumentosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtAtestadoMedico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtDietaMedica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtExames, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtDocumentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel46Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAtestadoMedico, jBtDietaMedica, jBtDocumentos, jBtExames});

        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addComponent(jBtDietaMedica)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAtestadoMedico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExames)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtDocumentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel40Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel40Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel43, jPanel45, jPanel46});

        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel40Layout.createSequentialGroup()
                .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1)
        );

        setBounds(300, 15, 818, 587);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxCabelosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCabelosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCabelosActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNomeActionPerformed
        // Pesquisa de Interno por NOME 
        count = 0;
        flag = 1;
        if (jPesqNome.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe NOME para pesquisa!!!");
            jPesqNome.requestFocus();
        } else if (jComboBoxOpcao.getSelectedItem().equals("Selecione...")) {
            JOptionPane.showMessageDialog(rootPane, "Selecione um tipo de pesquisa.");
        } else if (jComboBoxOpcao.getSelectedItem().equals("Todos Registros")) {
            preencherTabelaNome("SELECT * FROM PRONTUARIOSCRC "
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
                    + "WHERE NomeInternoCrc LIKE'%" + jPesqNome.getText() + "%'");
        } else if (jComboBoxOpcao.getSelectedItem().equals("Só Enfermaria")) {
            pesquisarInternosDoencasInfecto("SELECT * FROM PRONTUARIOSCRC "
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
                    + "INNER JOIN ADMISSAOENFERMEIRA "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ADMISSAOENFERMEIRA.IdInternoCrc "
                    + "WHERE NomeInternoCrc LIKE'%" + jPesqNome.getText() + "%'");
        }
    }//GEN-LAST:event_jBtNomeActionPerformed

    private void jBtMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtMatriculaActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (jPesqMatricula.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe MATRICULA para pesquisa!!!");
            jPesqMatricula.requestFocus();
        } else if (jComboBoxOpcao.getSelectedItem().equals("Selecione...")) {
            JOptionPane.showMessageDialog(rootPane, "Selecione um tipo de pesquisa.");
        } else if (jComboBoxOpcao.getSelectedItem().equals("Todos Registros")) {
            buscarInternosMatricula("SELECT * FROM PRONTUARIOSCRC "
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
        } else if (jComboBoxOpcao.getSelectedItem().equals("Só Enfermaria")) {
            pesquisarInternosDoencasInfecto("SELECT * FROM PRONTUARIOSCRC "
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
                    + "INNER JOIN ADMISSAOENFERMEIRA "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ADMISSAOENFERMEIRA.IdInternoCrc "
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
            jIdInternoConPSP.setText(idInt);
            // Habilitar botões
            jBtZoonFoto.setEnabled(true);
            jBtPeculiaridadeCostas.setEnabled(true);
            jBtPeculiaridadeFrente.setEnabled(true);
            //
            bloquearCamposEdicao();
            //
            jBtMedico.setEnabled(true);
            jBtPsiquiatrico.setEnabled(true);
            jBtPsicologico.setEnabled(true);
            jBtAssistenciaSocial.setEnabled(true);
            jBtTerapiaOcupacional.setEnabled(true);
            jBtOdontologica.setEnabled(true);
            jBtEnfermeira.setEnabled(true);
            jBtPrescricaoMedica.setEnabled(true);
            jBtPrescricaoPsiquiatrica.setEnabled(true);
            jBtPrescricaoOdontologica.setEnabled(true);
            jBtDietaMedica.setEnabled(true);
            jBtAtestadoMedico.setEnabled(true);
            jBtExames.setEnabled(true);
            jBtDocumentos.setEnabled(true);
            //
            jBtImprimirProntuario.setEnabled(true);
            jBtObservacao.setEnabled(true);
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
                        + "WHERE PRONTUARIOSCRC.NomeInternoCrc='" + nomeInterno + "'AND PRONTUARIOSCRC.IdInternoCrc='" + idInt + "'");
                conecta.rs.first();
                jIdInternoConPSP.setText(String.valueOf(conecta.rs.getInt("IdInternoCrc")));
                jMatriculaPenal.setText(conecta.rs.getString("MatriculaCrc"));
                jCNC_PSP.setText(conecta.rs.getString("Cnc"));
                jDataCadastro.setDate(conecta.rs.getDate("DataCadastCrc"));
                jDataNascimento.setDate(conecta.rs.getDate("DataNasciCrc"));
                jNomeInternoConPSP.setText(conecta.rs.getString("NomeInternoCrc"));
                jMaeInterno.setText(conecta.rs.getString("MaeInternoCrc"));
                jPaiInterno.setText(conecta.rs.getString("PaiInternoCrc"));
                jAlcunha.setText(conecta.rs.getString("AlcunhaCrc"));
                jRGInterno.setText(conecta.rs.getString("RgInternoCrc"));
                jCPFInterno.setText(conecta.rs.getString("CpfInternoCrc"));
                jCartaoSus.setText(conecta.rs.getString("CartaoSus"));
                // Capturando foto
                caminho = conecta.rs.getString("FotoInternoCrc");
                javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                jLabelFotoInterno.setIcon(i);
                jLabelFotoInterno.setIcon(new ImageIcon(i.getImage().getScaledInstance(jLabelFotoInterno.getWidth(), jLabelFotoInterno.getHeight(), Image.SCALE_DEFAULT)));
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
                    jFotoPerfil.setIcon(new ImageIcon(w.getImage().getScaledInstance(jFotoPerfil.getWidth(), jFotoPerfil.getHeight(), Image.SCALE_DEFAULT)));
                }
                caminhoFotoCorpo = conecta.rs.getString("FotoCorpo");
                if (caminhoFotoCorpo != null) {
                    javax.swing.ImageIcon y = new javax.swing.ImageIcon(caminhoFotoCorpo);
                    jFotoCorpo.setIcon(y);
                    jFotoCorpo.setIcon(new ImageIcon(y.getImage().getScaledInstance(jFotoCorpo.getWidth(), jFotoCorpo.getHeight(), Image.SCALE_DEFAULT)));
                }
                caminhoFotoCorpo1 = conecta.rs.getString("FotoCorpo1");
                if (caminhoFotoCorpo1 != null) {
                    javax.swing.ImageIcon z = new javax.swing.ImageIcon(caminhoFotoCorpo1);
                    jFotoCorpo1.setIcon(z);
                    jFotoCorpo1.setIcon(new ImageIcon(z.getImage().getScaledInstance(jFotoCorpo1.getWidth(), jFotoCorpo1.getHeight(), Image.SCALE_DEFAULT)));
                }
                caminhoFotoCorpo2 = conecta.rs.getString("FotoCorpo2");
                if (caminhoFotoCorpo2 != null) {
                    javax.swing.ImageIcon t = new javax.swing.ImageIcon(caminhoFotoCorpo2);
                    jFotoCorpo2.setIcon(t);
                    jFotoCorpo2.setIcon(new ImageIcon(t.getImage().getScaledInstance(jFotoCorpo2.getWidth(), jFotoCorpo2.getHeight(), Image.SCALE_DEFAULT)));
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
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa por nome" + e);
            }
        }
    }//GEN-LAST:event_jTabelaInternoMouseClicked

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (jComboBoxOpcao.getSelectedItem().equals("Selecione...")) {
            JOptionPane.showMessageDialog(rootPane, "Selecione um tipo de pesquisa.");
        } else if (jComboBoxOpcao.getSelectedItem().equals("Todos Registros")) {
            if (evt.getStateChange() == evt.SELECTED) {
                this.preencherTodosInternos("SELECT * FROM PRONTUARIOSCRC "
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
        } else if (jComboBoxOpcao.getSelectedItem().equals("Só Enfermaria")) {
            if (evt.getStateChange() == evt.SELECTED) {
                this.pesquisarInternosDoencasInfecto("SELECT * FROM PRONTUARIOSCRC "
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
                        + "INNER JOIN ADMISSAOENFERMEIRA "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=ADMISSAOENFERMEIRA.IdInternoCrc "
                        + "ORDER BY PRONTUARIOSCRC.IdInternoCrc");
            } else {
                jtotalRegistros.setText("");
                limparTabelaDoencasInfecto();
            }
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jBtZoonFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtZoonFotoActionPerformed
        // TODO add your handling code here:
        mostraTelaFotoCrcConsulta();
    }//GEN-LAST:event_jBtZoonFotoActionPerformed

    private void jBtPesqAlcunhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqAlcunhaActionPerformed
        // TODO add your handling code here:
        if (jPesqAlcunha.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe a alcunha para pesquisa.");
        } else if (jComboBoxOpcao.getSelectedItem().equals("Selecione...")) {
            JOptionPane.showMessageDialog(rootPane, "Selecione um tipo de pesquisa.");
        } else if (jComboBoxOpcao.getSelectedItem().equals("Todos Registros")) {
            preencherTabelaNome("SELECT * FROM PRONTUARIOSCRC "
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
        } else if (jComboBoxOpcao.getSelectedItem().equals("Só Enfermaria")) {
            pesquisarInternosDoencasInfecto("SELECT * FROM PRONTUARIOSCRC "
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
                    + "INNER JOIN ADMISSAOENFERMEIRA "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ADMISSAOENFERMEIRA.IdInternoCrc "
                    + "WHERE AlcunhaCrc LIKE'%" + jPesqAlcunha.getText() + "%'");
        }
    }//GEN-LAST:event_jBtPesqAlcunhaActionPerformed

    private void jBtPeculiaridadeCostasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPeculiaridadeCostasActionPerformed
        // TODO add your handling code here:
        mostrarTelaPeculiaridadeConsulta();
    }//GEN-LAST:event_jBtPeculiaridadeCostasActionPerformed

    private void jBtPeculiaridadeFrenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPeculiaridadeFrenteActionPerformed
        // TODO add your handling code here:
        mostrarTelaPeculiaridadeConsultaFrente();
    }//GEN-LAST:event_jBtPeculiaridadeFrenteActionPerformed

    private void jBtImprimirProntuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImprimirProntuarioActionPerformed
        // TODO add your handling code here:
        buscarUsuario(); // BUSCAR O CÓDIGO DO USUÁRIO
        buscarCodigoGrupo(); // COM O CÓDIGO DO USUÁRIO, BUSCAR O CÓDIGO DO GRUPO PARA SER COMPARADO.
        if (codigoGrupo == codigoGrupoAdm || nameUser.equals("ADMINISTRADOR DO SISTEMA")) {
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
                    JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório.\n\nERRO :" + e);
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "ATENÇÃO: Esse usuário não tem acesso a impressão do PRONTUÁRIO.");
        }
    }//GEN-LAST:event_jBtImprimirProntuarioActionPerformed

    private void jBtObservacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtObservacaoActionPerformed
        // TODO add your handling code here:
        buscarUsuario(); // BUSCAR O CÓDIGO DO USUÁRIO
        buscarCodigoGrupo(); // COM O CÓDIGO DO USUÁRIO, BUSCAR O CÓDIGO DO GRUPO PARA SER COMPARADO.
        if (codigoGrupo == codigoGrupoAdm || nameUser.equals("ADMINISTRADOR DO SISTEMA")) {
            mostrarObservacaoInterno();
        } else {
            JOptionPane.showMessageDialog(rootPane, "ATENÇÃO: Esse usuário não tem acesso a observação.");
        }
    }//GEN-LAST:event_jBtObservacaoActionPerformed

    private void jBtMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtMedicoActionPerformed
        // TODO add your handling code here:
        mostrarConsultaMedicaClinica();
    }//GEN-LAST:event_jBtMedicoActionPerformed

    private void jBtPsiquiatricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPsiquiatricoActionPerformed
        // TODO add your handling code here:
        mostrarConsultaPsiquiatrica();
    }//GEN-LAST:event_jBtPsiquiatricoActionPerformed

    private void jBtPsicologicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPsicologicoActionPerformed
        // TODO add your handling code here:
        mostrarConsultaPsi();
    }//GEN-LAST:event_jBtPsicologicoActionPerformed

    private void jBtAssistenciaSocialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAssistenciaSocialActionPerformed
        // TODO add your handling code here:
        mostrarConsultaSS();
    }//GEN-LAST:event_jBtAssistenciaSocialActionPerformed

    private void jBtTerapiaOcupacionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtTerapiaOcupacionalActionPerformed
        // TODO add your handling code here:
        mostrarConsultaTO();
    }//GEN-LAST:event_jBtTerapiaOcupacionalActionPerformed

    private void jBtPrescricaoMedicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPrescricaoMedicaActionPerformed
        // TODO add your handling code here:
        mostrarPrescricaoMedicaClinica();
    }//GEN-LAST:event_jBtPrescricaoMedicaActionPerformed

    private void jBtPrescricaoPsiquiatricaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPrescricaoPsiquiatricaActionPerformed
        // TODO add your handling code here:
        mostrarPrescricaoMedicaPsiquiatrica();
    }//GEN-LAST:event_jBtPrescricaoPsiquiatricaActionPerformed

    private void jBtPrescricaoOdontologicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPrescricaoOdontologicaActionPerformed
        // TODO add your handling code here:
        mostrarPrescricaoOdontologica();
    }//GEN-LAST:event_jBtPrescricaoOdontologicaActionPerformed

    private void jBtDietaMedicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtDietaMedicaActionPerformed
        // TODO add your handling code here:
        mostrarDietasMedicas();
    }//GEN-LAST:event_jBtDietaMedicaActionPerformed

    private void jBtAtestadoMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAtestadoMedicoActionPerformed
        // TODO add your handling code here:
        mostrarAtestadosMedicos();
    }//GEN-LAST:event_jBtAtestadoMedicoActionPerformed

    private void jBtExamesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExamesActionPerformed
        // TODO add your handling code here:
        mostrarExamesMedicos();
    }//GEN-LAST:event_jBtExamesActionPerformed

    private void jBtDocumentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtDocumentosActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaConsultaProntuarioInternosDocJURI);
        buscarAcessoUsuario1(telaConsultaProntuarioInternosDocPSI);
        buscarAcessoUsuario2(telaConsultaProntuarioInternosDocENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoJURI.equals("ADMINISTRADORES") || codigoUserJURI == codUserAcessoJURI && nomeTelaJURI.equals(telaConsultaProntuarioInternosDocJURI) && codAbrirJURI == 1) {
            mostrarDocInternos();
        } else if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPSI.equals("ADMINISTRADORES") || codigoUserPSI == codUserAcessoPSI && nomeTelaPSI.equals(telaConsultaProntuarioInternosDocPSI) && codAbrirPSI == 1) {
            mostrarDocInternos();
        } else if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaConsultaProntuarioInternosDocENF) && codAbrirENF == 1) {
            mostrarDocInternos();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtDocumentosActionPerformed

    private void jBtOdontologicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtOdontologicaActionPerformed
        // TODO add your handling code here:
        mostrarConsultaOdonto();
    }//GEN-LAST:event_jBtOdontologicaActionPerformed

    private void jBtEnfermeiraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtEnfermeiraActionPerformed
        // TODO add your handling code here:
        mostrarConsultaEnfermagem();
    }//GEN-LAST:event_jBtEnfermeiraActionPerformed

    private void jBtCNCPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCNCPesquisaActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (jPesquisaCNC.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe MATRICULA para pesquisa!!!");
            jPesquisaCNC.requestFocus();
        } else if (jComboBoxOpcao.getSelectedItem().equals("Selecione...")) {
            JOptionPane.showMessageDialog(rootPane, "Selecione um tipo de pesquisa.");
        } else if (jComboBoxOpcao.getSelectedItem().equals("Todos Registros")) {
            buscarInternosMatricula("SELECT * FROM PRONTUARIOSCRC "
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
        } else if (jComboBoxOpcao.getSelectedItem().equals("Só Enfermaria")) {
            pesquisarInternosDoencasInfecto("SELECT * FROM PRONTUARIOSCRC "
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
                    + "INNER JOIN ADMISSAOENFERMEIRA "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ADMISSAOENFERMEIRA.IdInternoCrc "
                    + "WHERE Cnc LIKE'%" + jPesquisaCNC.getText() + "%'");
        }
    }//GEN-LAST:event_jBtCNCPesquisaActionPerformed

    private void jBtTesteRapidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtTesteRapidosActionPerformed
        // TODO add your handling code here:TelaConsultaTestesRapidos
        mostrarTestesRapidos();
    }//GEN-LAST:event_jBtTesteRapidosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField jAlcunha;
    private javax.swing.JTextField jAltura;
    private javax.swing.JTextField jArtigo1;
    private javax.swing.JTextField jArtigo2;
    private javax.swing.JTextField jArtigo3;
    private javax.swing.JTextField jBairro;
    private javax.swing.JButton jBtAssistenciaSocial;
    private javax.swing.JButton jBtAtestadoMedico;
    private javax.swing.JButton jBtCNCPesquisa;
    private javax.swing.JButton jBtDietaMedica;
    private javax.swing.JButton jBtDocumentos;
    private javax.swing.JButton jBtEnfermeira;
    private javax.swing.JButton jBtExames;
    private javax.swing.JButton jBtImprimirProntuario;
    private javax.swing.JButton jBtMatricula;
    private javax.swing.JButton jBtMedico;
    private javax.swing.JButton jBtNome;
    private javax.swing.JButton jBtObservacao;
    private javax.swing.JButton jBtOdontologica;
    private javax.swing.JButton jBtPeculiaridadeCostas;
    private javax.swing.JButton jBtPeculiaridadeFrente;
    private javax.swing.JButton jBtPesqAlcunha;
    private javax.swing.JButton jBtPrescricaoMedica;
    private javax.swing.JButton jBtPrescricaoOdontologica;
    private javax.swing.JButton jBtPrescricaoPsiquiatrica;
    private javax.swing.JButton jBtPsicologico;
    private javax.swing.JButton jBtPsiquiatrico;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtTerapiaOcupacional;
    private javax.swing.JButton jBtTesteRapidos;
    private javax.swing.JButton jBtZoonFoto;
    public static javax.swing.JTextField jCNC_PSP;
    private javax.swing.JFormattedTextField jCPFInterno;
    private javax.swing.JTextField jCalca;
    private javax.swing.JTextField jCamisa;
    private javax.swing.JTextField jCartaoSus;
    private javax.swing.JFormattedTextField jCelular;
    private javax.swing.JCheckBox jCheckBox1;
    public static javax.swing.JTextField jCidade;
    private javax.swing.JComboBox jComboBoxBarba;
    private javax.swing.JComboBox jComboBoxBigode;
    private javax.swing.JComboBox jComboBoxBoca;
    private javax.swing.JComboBox jComboBoxCabelos;
    public static javax.swing.JTextField jComboBoxCidade;
    private javax.swing.JComboBox jComboBoxCompleicao;
    private javax.swing.JComboBox jComboBoxCutis;
    private javax.swing.JComboBox jComboBoxEdiondo;
    private javax.swing.JComboBox jComboBoxEscolaridade;
    private javax.swing.JComboBox jComboBoxEstadoCivil;
    private javax.swing.JComboBox jComboBoxLabios;
    private javax.swing.JComboBox jComboBoxNariz;
    private javax.swing.JComboBox jComboBoxOlhos;
    private javax.swing.JComboBox<String> jComboBoxOpcao;
    private javax.swing.JComboBox jComboBoxOrelha;
    public static javax.swing.JTextField jComboBoxPais;
    private javax.swing.JComboBox jComboBoxParticipacao;
    private javax.swing.JComboBox jComboBoxPescoco;
    private javax.swing.JComboBox jComboBoxRegime;
    private javax.swing.JComboBox jComboBoxRosto;
    private javax.swing.JComboBox jComboBoxSexo;
    public static javax.swing.JTextField jComboBoxUnid;
    private com.toedter.calendar.JDateChooser jDataCadastro;
    private com.toedter.calendar.JDateChooser jDataCondenacao;
    private com.toedter.calendar.JDateChooser jDataCrime;
    private com.toedter.calendar.JDateChooser jDataEntrada;
    private com.toedter.calendar.JDateChooser jDataNascimento;
    private com.toedter.calendar.JDateChooser jDataNovaEntrada;
    private com.toedter.calendar.JDateChooser jDataPrisao;
    private com.toedter.calendar.JDateChooser jDataTerPena;
    private javax.swing.JTextField jEndereco;
    private javax.swing.JTextField jEstado;
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
    public static javax.swing.JTextField jIdInternoConPSP;
    private javax.swing.JTextField jIdentificador;
    private javax.swing.JTextField jIdentificador1;
    private javax.swing.JTextField jIdentificador2;
    private javax.swing.JTextField jIdentificador3;
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
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
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
    private javax.swing.JLabel jLabelFotoInterno;
    private javax.swing.JTextField jMaeInterno;
    private javax.swing.JTextField jMatriculaPenal;
    public static javax.swing.JTextField jNomeInternoConPSP;
    private javax.swing.JTextField jPaiInterno;
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
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jParagrafo1;
    private javax.swing.JTextField jParagrafo2;
    private javax.swing.JTextField jParagrafo3;
    private javax.swing.JTextField jParticularidade;
    private javax.swing.JTextField jPena;
    private javax.swing.JTextField jPerfil;
    private javax.swing.JTextField jPeso;
    private javax.swing.JTextField jPesqAlcunha;
    private javax.swing.JTextField jPesqMatricula;
    private javax.swing.JTextField jPesqNome;
    private javax.swing.JTextField jPesquisaCNC;
    private javax.swing.JTextField jProfissao;
    private javax.swing.JFormattedTextField jRGInterno;
    private javax.swing.JTextField jRegiaoCorpo;
    private javax.swing.JTextField jRegiaoCorpo1;
    private javax.swing.JTextField jRegiaoCorpo2;
    private javax.swing.JTextField jReligiao;
    private javax.swing.JTextField jSapato;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextField jSituacao;
    private javax.swing.JSplitPane jSplitPane1;
    public static javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable jTabelaInterno;
    private javax.swing.JFormattedTextField jTelefone;
    private javax.swing.JFormattedTextField jTelefone1;
    private javax.swing.JTextField jVaraCondenacao;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void buscarUsuario() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS WHERE NomeUsuario='" + nameUser + "'");
            conecta.rs.first();
            codigoUsuario = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void buscarCodigoGrupo() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS WHERE IdUsuario='" + codigoUsuario + "'");
            conecta.rs.first();
            codigoGrupo = conecta.rs.getInt("IdGrupo");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void bloquearCamposEdicao() {
        jMatriculaPenal.setEnabled(!true);
        jDataCadastro.setEnabled(!true);
        jDataNascimento.setEnabled(!true);
        jNomeInternoConPSP.setEnabled(!true);
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
    }

    public void corCampos() {
        jIdInternoConPSP.setBackground(Color.white);
        jMatriculaPenal.setBackground(Color.white);
        jCNC_PSP.setBackground(Color.white);
        jDataCadastro.setBackground(Color.white);
        jDataNascimento.setBackground(Color.white);
        jDataEntrada.setBackground(Color.white);
        jDataCrime.setBackground(Color.white);
        jDataPrisao.setBackground(Color.white);
        jDataCondenacao.setBackground(Color.white);
        jDataTerPena.setBackground(Color.white);
        jNomeInternoConPSP.setBackground(Color.white);
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
        // Limpar campos para inclusão
        jIdInternoConPSP.setText("");
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
        jNomeInternoConPSP.setText("");
        jMaeInterno.setText("");
        jPaiInterno.setText("");
        jAlcunha.setText("");
        jRGInterno.setText("");
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

        // Habilitar campos para INCLUSÃO
        jMatriculaPenal.setEnabled(true);
        jDataCadastro.setEnabled(true);
        jDataNascimento.setEnabled(true);
        jNomeInternoConPSP.setEnabled(true);
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
//        jComboBoxPais.setEnabled(true);
//        jComboBoxCidade.setEnabled(true);
        jReligiao.setEnabled(true);
        jProfissao.setEnabled(true);
        jEndereco.setEnabled(true);
        jBairro.setEnabled(true);
        jCidade.setEnabled(true);
        jEstado.setEnabled(true);
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
        // Habilitar/Desabilitar  Botões
        jBtZoonFoto.setEnabled(!true);
        jBtPeculiaridadeCostas.setEnabled(!true);
        jBtPeculiaridadeFrente.setEnabled(!true);
    }

    public void Alterar() {
        jMatriculaPenal.setEnabled(true);
        jDataCadastro.setEnabled(true);
        jDataNascimento.setEnabled(true);
        jNomeInternoConPSP.setEnabled(true);
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
        //  jComboBoxPais.setEnabled(true);
        //   jComboBoxCidade.setEnabled(true);
        jReligiao.setEnabled(true);
        jProfissao.setEnabled(true);
        jEndereco.setEnabled(true);
        jBairro.setEnabled(true);
        jCidade.setEnabled(true);
        jEstado.setEnabled(true);
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
        // Habilitar/Desabilitar  Botões
        jBtZoonFoto.setEnabled(true);
        jBtPeculiaridadeCostas.setEnabled(!true);
        jBtPeculiaridadeFrente.setEnabled(!true);
    }

    public void Excluir() {

        jMatriculaPenal.setText("");
        jNomeInternoConPSP.setText("");
        jMaeInterno.setText("");
        jPaiInterno.setText("");
        jAlcunha.setText("");
        jRGInterno.setText("");
        jCPFInterno.setText("");
        jCartaoSus.setText("");
        jLabelFotoInterno.setIcon(null);
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
        // Desabilitar os campos
        jMatriculaPenal.setEnabled(!true);
        jDataCadastro.setEnabled(!true);
        jDataNascimento.setEnabled(!true);
        jNomeInternoConPSP.setEnabled(!true);
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
        jComboBoxOrelha.setEnabled(!true);
        jComboBoxPescoco.setEnabled(!true);
        jComboBoxCompleicao.setEnabled(!true);
        jDataEntrada.setEnabled(!true);
        jComboBoxUnid.setEnabled(!true);
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
        jBtZoonFoto.setEnabled(!true);
        //
        jBtPeculiaridadeCostas.setEnabled(!true);
        jBtPeculiaridadeFrente.setEnabled(!true);
    }

    public void Salvar() {

        jMatriculaPenal.setEnabled(!true);
        jDataCadastro.setEnabled(!true);
        jDataNascimento.setEnabled(!true);
        jNomeInternoConPSP.setEnabled(!true);
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
        jComboBoxOrelha.setEnabled(!true);
        jComboBoxPescoco.setEnabled(!true);
        jComboBoxCompleicao.setEnabled(!true);
        jDataEntrada.setEnabled(!true);
        jComboBoxUnid.setEnabled(!true);
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
        jBtZoonFoto.setEnabled(!true);
        //                
        jBtPeculiaridadeCostas.setEnabled(true);
        jBtPeculiaridadeFrente.setEnabled(true);
    }

    public void Cancelar() {

        if (jIdInternoConPSP.getText().equals("")) {
            // Limpar campos para inclusão
            jIdInternoConPSP.setText("");
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
            jNomeInternoConPSP.setText("");
            jMaeInterno.setText("");
            jPaiInterno.setText("");
            jAlcunha.setText("");
            jRGInterno.setText("");
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
            // Desabilitar os campos
            jMatriculaPenal.setEnabled(!true);
            jDataCadastro.setEnabled(!true);
            jDataNascimento.setEnabled(!true);
            jNomeInternoConPSP.setEnabled(!true);
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
            jComboBoxOrelha.setEnabled(!true);
            jComboBoxPescoco.setEnabled(!true);
            jComboBoxCompleicao.setEnabled(!true);
            jDataEntrada.setEnabled(!true);
            jComboBoxUnid.setEnabled(!true);
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
            jBtZoonFoto.setEnabled(!true);
        } else {
            // Desabilitar os campos
            jMatriculaPenal.setEnabled(!true);
            jDataCadastro.setEnabled(!true);
            jDataNascimento.setEnabled(!true);
            jNomeInternoConPSP.setEnabled(!true);
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
            jComboBoxOrelha.setEnabled(!true);
            jComboBoxPescoco.setEnabled(!true);
            jComboBoxCompleicao.setEnabled(!true);
            jDataEntrada.setEnabled(!true);
            jComboBoxUnid.setEnabled(!true);
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
            jBtZoonFoto.setEnabled(true);
            jBtPeculiaridadeCostas.setEnabled(true);
            jBtPeculiaridadeFrente.setEnabled(true);
        }
    }

    public void formatarCampos() {

        try {
            MaskFormatter telefone = new MaskFormatter("(###)####-####");
            jTelefone.setFormatterFactory(new DefaultFormatterFactory(telefone));
            MaskFormatter telefone1 = new MaskFormatter("(###)####-####");
            jTelefone1.setFormatterFactory(new DefaultFormatterFactory(telefone1));
            MaskFormatter celular = new MaskFormatter("(###)####-####");
            jCelular.setFormatterFactory(new DefaultFormatterFactory(celular));
            jCartaoSus.setDocument(new LimiteDigitosSoNum(20));
            jPesqNome.setDocument(new LimiteDigitos(50));
            jPesqMatricula.setDocument(new LimiteDigitosAlfa(15));
            jNomeInternoConPSP.setDocument(new LimiteDigitos(50));
            jMatriculaPenal.setDocument(new LimiteDigitosAlfa(16));
            jMaeInterno.setDocument(new LimiteDigitos(50));
            jPaiInterno.setDocument(new LimiteDigitos(50));
            jAlcunha.setDocument(new LimiteDigitosAlfa(30));
            jSituacao.setDocument(new LimiteDigitos(50));
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
            conecta.executaSQL("SELECT * FROM ITENSENTRADA WHERE IdInternoCrc='" + jIdInternoConPSP.getText() + "'");
            conecta.rs.first();
            codInternoCrc = conecta.rs.getString("IdInternoCrc");
        } catch (SQLException ex) {
        }
        if (jIdInternoConPSP.getText().equals(codInternoCrc)) {
            JOptionPane.showMessageDialog(rootPane, "Esse interno não pode ser excluído, existe movimentação para o mesmo!!!");
        } else {
            objDadosPena.setIdInternoCrc(Integer.valueOf(jIdInternoConPSP.getText()));
            objDadosFis.setIdInternoCrc(Integer.valueOf(jIdInternoConPSP.getText()));
            objProCrc.setIdInterno(Integer.valueOf(jIdInternoConPSP.getText()));
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
            jIdInternoConPSP.setText(conecta.rs.getString("IdInternoCrc"));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possivel identificar o número do prontuario... \nERRO: " + e);
        }
        conecta.desconecta();
    }

    // Método de pesquisa pela Descrição
    public void preencherTabelaNome(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome do Interno", "Matricula Penal", "Data Entrada", "Data Cadastro"};
        conecta.abrirConexao();
        conecta.executaSQL(sql);
        try {
            conecta.rs.first();
            do {
                count = count + 1;
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
                dados.add(new Object[]{conecta.rs.getInt("IdInternoCrc"), conecta.rs.getString("NomeInternoCrc"), conecta.rs.getString("MatriculaCrc"), dataEntrada, dataCadastro});
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
        jTabelaInterno.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTabelaInterno.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaInterno.getColumnModel().getColumn(3).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTabelaInterno.getColumnModel().getColumn(4).setResizable(false);
        jTabelaInterno.getTableHeader().setReorderingAllowed(false);
        jTabelaInterno.setAutoResizeMode(jTabelaInterno.AUTO_RESIZE_OFF);
        jTabelaInterno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaProntuario();
        conecta.desconecta();
    }

    //Preencher tabela com todos os INTERNOS
    public void preencherTodosInternos(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome do Interno", "Matricula Penal", "Data Entrada", "Data Cadastro"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1; // Contador de registros                
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
                dados.add(new Object[]{conecta.rs.getInt("IdInternoCrc"), conecta.rs.getString("NomeInternoCrc"), conecta.rs.getString("MatriculaCrc"), dataEntrada, dataCadastro});
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
        jTabelaInterno.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTabelaInterno.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaInterno.getColumnModel().getColumn(3).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTabelaInterno.getColumnModel().getColumn(4).setResizable(false);
        jTabelaInterno.getTableHeader().setReorderingAllowed(false);
        jTabelaInterno.setAutoResizeMode(jTabelaInterno.AUTO_RESIZE_OFF);
        jTabelaInterno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaProntuario();
        conecta.desconecta();
    }

    // Método de pesquisa pela Matricula
    public void buscarInternosMatricula(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome do Interno", "Matricula Penal", "Data Entrada", "Data Cadastro"};
        conecta.abrirConexao();
        conecta.executaSQL(sql);
        try {
            conecta.rs.first();
            do {
                count = count + 1;
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
                dados.add(new Object[]{conecta.rs.getInt("IdInternoCrc"), conecta.rs.getString("NomeInternoCrc"), conecta.rs.getString("MatriculaCrc"), dataEntrada, dataCadastro});
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
        jTabelaInterno.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTabelaInterno.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaInterno.getColumnModel().getColumn(3).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTabelaInterno.getColumnModel().getColumn(4).setResizable(false);
        jTabelaInterno.getTableHeader().setReorderingAllowed(false);
        jTabelaInterno.setAutoResizeMode(jTabelaInterno.AUTO_RESIZE_OFF);
        jTabelaInterno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaProntuario();
        conecta.desconecta();
    }

    public void limparTabelaProntuario() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome do Interno", "Matricula Penal", "Data Entrada", "Data Cadastro"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInterno.setRowSorter(new TableRowSorter(modelo)); //FAZER ORDENAMENTO NA TABLEA  
        jTabelaInterno.setModel(modelo);
        jTabelaInterno.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaInterno.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTabelaInterno.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTabelaInterno.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaInterno.getColumnModel().getColumn(3).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTabelaInterno.getColumnModel().getColumn(4).setResizable(false);
        jTabelaInterno.getTableHeader().setReorderingAllowed(false);
        jTabelaInterno.setAutoResizeMode(jTabelaInterno.AUTO_RESIZE_OFF);
        jTabelaInterno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void limparTabelaDoencasInfecto() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome do Interno", "Matricula Penal", "Data Entrada", "Data Cadastro", "Hepatite B", "Hepatite C", "Hiv", "Sifilis", "Hipertensão", "Diabetes", "Tuberculose", "Alergias"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInterno.setRowSorter(new TableRowSorter(modelo)); //FAZER ORDENAMENTO NA TABLEA
        jTabelaInterno.setModel(modelo);
        jTabelaInterno.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaInterno.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTabelaInterno.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTabelaInterno.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaInterno.getColumnModel().getColumn(3).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTabelaInterno.getColumnModel().getColumn(4).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(5).setPreferredWidth(80);
        jTabelaInterno.getColumnModel().getColumn(5).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(6).setPreferredWidth(80);
        jTabelaInterno.getColumnModel().getColumn(6).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(7).setPreferredWidth(80);
        jTabelaInterno.getColumnModel().getColumn(7).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(8).setPreferredWidth(80);
        jTabelaInterno.getColumnModel().getColumn(8).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(9).setPreferredWidth(80);
        jTabelaInterno.getColumnModel().getColumn(9).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(10).setPreferredWidth(80);
        jTabelaInterno.getColumnModel().getColumn(10).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(11).setPreferredWidth(70);
        jTabelaInterno.getColumnModel().getColumn(11).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(12).setPreferredWidth(60);
        jTabelaInterno.getColumnModel().getColumn(12).setResizable(false);
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
    }

    public void corNaLinha() {
        DefaultTableCellRenderer tableCellRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (jComboBoxOpcao.getSelectedItem().equals("Só Enfermaria")) {
                    Object textoHpC = table.getValueAt(row, 5);
                    Object textoHpB = table.getValueAt(row, 6);
                    Object textoHiv = table.getValueAt(row, 7);
                    Object textoSifilis = table.getValueAt(row, 8);
                    Object textoHiper = table.getValueAt(row, 9);
                    Object textoDiabes = table.getValueAt(row, 10);
                    Object textoTuber = table.getValueAt(row, 11);
                    Object textoAlerge = table.getValueAt(row, 12);
                    if (textoHpC != null && pHepatiteC.equals(textoHpC.toString())) {
                        comp.setForeground(Color.RED);
                        comp.setBackground(Color.WHITE);
                    } else if (textoHpB != null && pHepatiteB.equals(textoHpC.toString())) {
                        comp.setForeground(Color.RED);
                        comp.setBackground(Color.WHITE);
                    } else if (textoHiv != null && pHiv.equals(textoHpC.toString())) {
                        comp.setForeground(Color.RED);
                        comp.setBackground(Color.WHITE);
                    } else if (textoSifilis != null && pSifilis.equals(textoSifilis.toString())) {
                        comp.setForeground(Color.RED);
                        comp.setBackground(Color.WHITE);
                    } else if (textoHiper != null && pHipertensao.equals(textoHiper.toString())) {
                        comp.setForeground(Color.RED);
                        comp.setBackground(Color.WHITE);
                    } else if (textoDiabes != null && pDiabetes.equals(textoDiabes.toString())) {
                        comp.setForeground(Color.RED);
                        comp.setBackground(Color.WHITE);
                    } else if (textoTuber != null && pTuberculose.equals(textoTuber.toString())) {
                        comp.setForeground(Color.RED);
                        comp.setBackground(Color.WHITE);
                    } else if (textoAlerge != null && pAlergias.equals(textoAlerge.toString())) {
                        comp.setForeground(Color.RED);
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

    public void pesquisarInternosDoencasInfecto(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome do Interno", "Matricula Penal", "Data Entrada", "Data Cadastro", "Hepatite B", "Hepatite C", "Hiv", "Sifilis", "Hipertensão", "Diabetes", "Tuberculose", "Alergias"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1; // Contador de registros                
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
                dados.add(new Object[]{conecta.rs.getInt("IdInternoCrc"), conecta.rs.getString("NomeInternoCrc"), conecta.rs.getString("MatriculaCrc"), dataEntrada, dataCadastro, conecta.rs.getString("HepatiteB"), conecta.rs.getString("HepatiteC"), conecta.rs.getString("Hiv"), conecta.rs.getString("Sifilis"), conecta.rs.getString("Hipertensao"), conecta.rs.getString("Diabetes"), conecta.rs.getString("Tuberculose"), conecta.rs.getString("Alergias")});
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
        jTabelaInterno.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTabelaInterno.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaInterno.getColumnModel().getColumn(3).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTabelaInterno.getColumnModel().getColumn(4).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(5).setPreferredWidth(80);
        jTabelaInterno.getColumnModel().getColumn(5).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(6).setPreferredWidth(80);
        jTabelaInterno.getColumnModel().getColumn(6).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(7).setPreferredWidth(80);
        jTabelaInterno.getColumnModel().getColumn(7).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(8).setPreferredWidth(80);
        jTabelaInterno.getColumnModel().getColumn(8).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(9).setPreferredWidth(80);
        jTabelaInterno.getColumnModel().getColumn(9).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(10).setPreferredWidth(80);
        jTabelaInterno.getColumnModel().getColumn(10).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(11).setPreferredWidth(70);
        jTabelaInterno.getColumnModel().getColumn(11).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(12).setPreferredWidth(60);
        jTabelaInterno.getColumnModel().getColumn(12).setResizable(false);
        jTabelaInterno.getTableHeader().setReorderingAllowed(false);
        jTabelaInterno.setAutoResizeMode(jTabelaInterno.AUTO_RESIZE_OFF);
        jTabelaInterno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        corNaLinha();
        conecta.desconecta();
    }

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jIdInternoConPSP.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void confirmarRegistroPortaria() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENSENTRADAPORTARIA WHERE NomeInterno='" + jNomeInternoConPSP.getText() + "'");
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
            imagem1 = ImageIO.read(new File(caminhoBiometria1 + jIdInternoConPSP.getText() + "-" + jNomeInternoConPSP.getText() + "-Digital1-MD" + ".gif"));
            javax.swing.ImageIcon a = new javax.swing.ImageIcon(imagem1);
            jFotoPolegarDireito.setIcon(a);
            jFotoPolegarDireito.setIcon(new ImageIcon(a.getImage().getScaledInstance(jFotoPolegarDireito.getWidth(), jFotoPolegarDireito.getHeight(), Image.SCALE_DEFAULT)));
        } catch (Exception e) {
        }
        //
        try {
            BufferedImage imagem2;
            imagem2 = ImageIO.read(new File(caminhoBiometria2 + jIdInternoConPSP.getText() + "-" + jNomeInternoConPSP.getText() + "-Digital2-MD" + ".gif"));
            javax.swing.ImageIcon b = new javax.swing.ImageIcon(imagem2);
            jFotoIndicadorDireito.setIcon(b);
            jFotoIndicadorDireito.setIcon(new ImageIcon(b.getImage().getScaledInstance(jFotoIndicadorDireito.getWidth(), jFotoIndicadorDireito.getHeight(), Image.SCALE_DEFAULT)));
        } catch (Exception e) {
        }
        //
        try {
            BufferedImage imagem3;
            imagem3 = ImageIO.read(new File(caminhoBiometria3 + jIdInternoConPSP.getText() + "-" + jNomeInternoConPSP.getText() + "-Digital3-MD" + ".gif"));
            javax.swing.ImageIcon c = new javax.swing.ImageIcon(imagem3);
            jFotoMedioDireito.setIcon(c);
            jFotoMedioDireito.setIcon(new ImageIcon(c.getImage().getScaledInstance(jFotoMedioDireito.getWidth(), jFotoMedioDireito.getHeight(), Image.SCALE_DEFAULT)));
        } catch (Exception e) {
        }
        //
        try {
            BufferedImage imagem4;
            imagem4 = ImageIO.read(new File(caminhoBiometria4 + jIdInternoConPSP.getText() + "-" + jNomeInternoConPSP.getText() + "-Digital4-MD" + ".gif"));
            javax.swing.ImageIcon d = new javax.swing.ImageIcon(imagem4);
            jFotoAnularDireito.setIcon(d);
            jFotoAnularDireito.setIcon(new ImageIcon(d.getImage().getScaledInstance(jFotoAnularDireito.getWidth(), jFotoAnularDireito.getHeight(), Image.SCALE_DEFAULT)));
        } catch (Exception e) {
        }
        try {
            BufferedImage imagem5;
            imagem5 = ImageIO.read(new File(caminhoBiometria5 + jIdInternoConPSP.getText() + "-" + jNomeInternoConPSP.getText() + "-Digital5-MD" + ".gif"));
            javax.swing.ImageIcon e = new javax.swing.ImageIcon(imagem5);
            jFotoMininoDireito.setIcon(e);
            jFotoMininoDireito.setIcon(new ImageIcon(e.getImage().getScaledInstance(jFotoMininoDireito.getWidth(), jFotoMininoDireito.getHeight(), Image.SCALE_DEFAULT)));
        } catch (Exception e) {
        }
        //
        try {
            BufferedImage imagem6;
            imagem6 = ImageIO.read(new File(caminhoBiometria6 + jIdInternoConPSP.getText() + "-" + jNomeInternoConPSP.getText() + "-Digital6-ME" + ".gif"));
            javax.swing.ImageIcon f = new javax.swing.ImageIcon(imagem6);
            jFotoPolegarEsquerdo.setIcon(f);
            jFotoPolegarEsquerdo.setIcon(new ImageIcon(f.getImage().getScaledInstance(jFotoPolegarEsquerdo.getWidth(), jFotoPolegarEsquerdo.getHeight(), Image.SCALE_DEFAULT)));
        } catch (Exception e) {
        }
        try {
            BufferedImage imagem7;
            imagem7 = ImageIO.read(new File(caminhoBiometria4 + jIdInternoConPSP.getText() + "-" + jNomeInternoConPSP.getText() + "-Digital7-ME" + ".gif"));
            javax.swing.ImageIcon g = new javax.swing.ImageIcon(imagem7);
            jFotoIndicadorEsquerdo.setIcon(g);
            jFotoIndicadorEsquerdo.setIcon(new ImageIcon(g.getImage().getScaledInstance(jFotoIndicadorEsquerdo.getWidth(), jFotoIndicadorEsquerdo.getHeight(), Image.SCALE_DEFAULT)));
        } catch (Exception e) {
        }
        try {
            BufferedImage imagem8;
            imagem8 = ImageIO.read(new File(caminhoBiometria5 + jIdInternoConPSP.getText() + "-" + jNomeInternoConPSP.getText() + "-Digital8-ME" + ".gif"));
            javax.swing.ImageIcon h = new javax.swing.ImageIcon(imagem8);
            jFotoMedioEsquerdo.setIcon(h);
            jFotoMedioEsquerdo.setIcon(new ImageIcon(h.getImage().getScaledInstance(jFotoMedioEsquerdo.getWidth(), jFotoMedioEsquerdo.getHeight(), Image.SCALE_DEFAULT)));
        } catch (Exception e) {
        }
        //
        try {
            BufferedImage imagem9;
            imagem9 = ImageIO.read(new File(caminhoBiometria9 + jIdInternoConPSP.getText() + "-" + jNomeInternoConPSP.getText() + "-Digital9-ME" + ".gif"));
            javax.swing.ImageIcon i = new javax.swing.ImageIcon(imagem9);
            jFotoAnularEsquerdo.setIcon(i);
            jFotoAnularEsquerdo.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoAnularEsquerdo.getWidth(), jFotoAnularEsquerdo.getHeight(), Image.SCALE_DEFAULT)));
        } catch (Exception e) {
        }
        //
        try {
            BufferedImage imagem10;
            imagem10 = ImageIO.read(new File(caminhoBiometria10 + jIdInternoConPSP.getText() + "-" + jNomeInternoConPSP.getText() + "-Digital10-ME" + ".gif"));
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
            codigoUserJURI = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUserJURI + "'");
            conecta.rs.first();
            codigoUserGroupJURI = conecta.rs.getInt("IdUsuario");
            codigoGrupoJURI = conecta.rs.getInt("IdGrupo");
            nomeGrupoJURI = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUserJURI + "' "
                    + "AND NomeTela='" + nomeTelaAcesso + "'");
            conecta.rs.first();
            codUserAcessoJURI = conecta.rs.getInt("IdUsuario");
            codAbrirJURI = conecta.rs.getInt("Abrir");
            codIncluirJURI = conecta.rs.getInt("Incluir");
            codAlterarJURI = conecta.rs.getInt("Alterar");
            codExcluirJURI = conecta.rs.getInt("Excluir");
            codGravarJURI = conecta.rs.getInt("Gravar");
            codConsultarJURI = conecta.rs.getInt("Consultar");
            nomeTelaJURI = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void buscarAcessoUsuario1(String nomeTelaAcesso) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nameUser + "'");
            conecta.rs.first();
            codigoUserPSI = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUserPSI + "'");
            conecta.rs.first();
            codigoUserGroupPSI = conecta.rs.getInt("IdUsuario");
            codigoGrupoPSI = conecta.rs.getInt("IdGrupo");
            nomeGrupoPSI = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUserPSI + "' "
                    + "AND NomeTela='" + nomeTelaAcesso + "'");
            conecta.rs.first();
            codUserAcessoPSI = conecta.rs.getInt("IdUsuario");
            codAbrirPSI = conecta.rs.getInt("Abrir");
            codIncluirPSI = conecta.rs.getInt("Incluir");
            codAlterarPSI = conecta.rs.getInt("Alterar");
            codExcluirPSI = conecta.rs.getInt("Excluir");
            codGravarPSI = conecta.rs.getInt("Gravar");
            codConsultarPSI = conecta.rs.getInt("Consultar");
            nomeTelaPSI = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void buscarAcessoUsuario2(String nomeTelaAcesso) {
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
            codigoGrupo = conecta.rs.getInt("IdGrupo");
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
