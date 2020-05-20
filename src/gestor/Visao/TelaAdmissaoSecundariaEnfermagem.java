/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleAdmissaoEnfermagem_AD;
import gestor.Controle.ControleConfirmacaoAtendimento;
import gestor.Controle.ControleEvolucaoEnfermagem;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControleMovAdmissaoEnfermeira;
import gestor.Controle.ControlePortaEntrada;
import gestor.Controle.ControleRegistroAtendimentoInternoBio;
import gestor.Dao.ConexaoBancoDados;
import Utilitarios.LimiteDigitosAlfa;
import Utilitarios.ModeloTabela;
import gestor.Modelo.AdmissaoEnfermagem;
import gestor.Modelo.EvolucaoEnfermagem;
import gestor.Modelo.LogSistema;
import gestor.Modelo.PortaEntrada;
import gestor.Modelo.RegistroAtendimentoInternos;
import static gestor.Visao.TelaAdmissaoEnfermagem.jIdEvolucao;
import static gestor.Visao.TelaAdmissaoEnfermagem.jIdInternoEnfermeiro;
import static gestor.Visao.TelaAdmissaoEnfermagem.jIdLanc;
import static gestor.Visao.TelaAdmissaoEnfermagem.jTabelaEvolucaoEnfermagem;
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
import static gestor.Visao.TelaModuloEnfermaria.nomeModuloENFER;
import static gestor.Visao.TelaModuloEnfermaria.nomeTelaENF;
import static gestor.Visao.TelaModuloEnfermaria.telaAdmissaoEnfeIntManuENF;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import java.awt.Color;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
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
 * @author Socializa TI 02
 */
public class TelaAdmissaoSecundariaEnfermagem extends javax.swing.JDialog {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AdmissaoEnfermagem objAdmEnfermagem = new AdmissaoEnfermagem();
    ControleAdmissaoEnfermagem_AD control = new ControleAdmissaoEnfermagem_AD();
    //
    EvolucaoEnfermagem objEvolEnferma = new EvolucaoEnfermagem();
    ControleEvolucaoEnfermagem controleEnfa = new ControleEvolucaoEnfermagem();
    ControleMovAdmissaoEnfermeira controle = new ControleMovAdmissaoEnfermeira();
    //
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
    String nomeModuloTela = "ENFERMARIA:Admissão Enfermeira de Internos:Manutenção";
    String statusMov;
    String horaMov;
    String dataModFinal;
    //
    public static int acao = 0;
    public static int pGravar = 0;
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
    //
    public static String pTipo = "";
    public static String pLocalizacao = "";
    public static String pCostipacaoDias = "";
    public static String pQualGenitalia = "";
    public static String pVacina = "";
    public static String pQuaisVacinas = "";
    //
    public static int statusFalaLinguagem = 0;
    public static String qualAlteracaoFala = "";
    public static int statusPele = 0;
    public static int statusMucosa = 0;
    public static int statusCabelos = 0;
    public static int statusBoca = 0;
    public static int statusFuncaoRespiratoria = 0;
    public static int statusTorax = 0;
    public static int statusFuncaoIntestinal = 0;
    public static int statusAbdome = 0;
    public static int statusFuncaoVesical = 0;
    public static int statusGenitalia = 0;
    //
    public static String pVdrl;
    public static String pHepatiteB;
    public static String pHepatiteC;
    public static String pHiv;
    public static String pCirurgias;
    public static String pQualCirurgias;
    public static String pSifilis;
    public static String pHipertensao;
    public static String pDiabetes;
    public static String pTuberculose;
    public static String pHanseniase;
    public static String pDst;
    public static String pEscabiose;
    public static String pHpv;
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
    // TELAS TESTES RÁPIDOS E OUTRAS
    public static TelaFA1 tFA;
    public static TelaTRC1 tTRC;
    public static TelaPE1 tPE;
    public static TelaCC1 tCC;
    public static TelaFT1 tFT;
    public static TelaFIA1 tFI;
    public static TelaFVG1 tFVG;
    public static TelaVA1 tVA;
    public static TelaTPC1 tPC;
    public static TelaAdmissaoEnfermagem ADM_ENF;
    //
    int pQUANTIDADE_ATENDIDA = 1;
    //ATENDIMENTO MOSTRADO NA TV
    String pATENDIMENTO_CONCLUIDO = "Sim";
    String status_ATENDIMENTO = "Atendimento Concluido";
    //
    String situacao = "ENTRADA NA UNIDADE";
    String sitRetorno = "RETORNO A UNIDADE";
    int codigoDepartamento = 0;
    //PORTA DE ENTRADA COM ORIGEM NO CRC/TRIAGEM
    String pHABILITA_MEDICO = "Sim";
    String pDEPARTAMENTO = "";
    String pINTERNOCRC = "";
    String pHABILITADO = "";
    String pCONFIRMA_ADMISSAO = "Sim";
    String pHabilitaMedico = "";
    String codInterno; // VARIÁVEL QUE IMPEDI MUDAR O REGISTRO DE ADMISSÃO, CASO JÁ EXISTA ANAMNESES, PRESCRIÇÃO, ATEDTADO OU DIETA.
    String nomeInternoAnterior = "";
    String pATENDIDO_PESQUISA = "Não";

    /**
     * Creates new form TelaAdmissaoSecundariaEnfermagem
     */
    public TelaAdmissaoSecundariaEnfermagem(TelaAdmissaoEnfermagem parent, boolean modal) {
        this.ADM_ENF = parent;
        this.setModal(modal);
        setLocationRelativeTo(ADM_ENF);
        initComponents();
        jTabbedPane1.setSelectedIndex(1);
        formatarCampos();
        corCampos();
    }

    public void mostrarFA1() {
        tFA = new TelaFA1(this, true);
        tFA.setVisible(true);
    }

    public void mostrarPE1() {
        tPE = new TelaPE1(this, true);
        tPE.setVisible(true);
    }

    public void mostrarCC1() {
        tCC = new TelaCC1(this, true);
        tCC.setVisible(true);
    }

    public void mostrarFT1() {
        tFT = new TelaFT1(this, true);
        tFT.setVisible(true);
    }

    public void mostrarFIA1() {
        tFI = new TelaFIA1(this, true);
        tFI.setVisible(true);
    }

    public void mostrarFVG1() {
        tFVG = new TelaFVG1(this, true);
        tFVG.setVisible(true);
    }

    public void mostrarVA1() {
        tVA = new TelaVA1(this, true);
        tVA.setVisible(true);
    }

    public void mostrarTRC1() {
        tTRC = new TelaTRC1(this, true);
        tTRC.setVisible(true);
    }

    public void mostrarPC1() {
        tPC = new TelaTPC1(this, true);
        tPC.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
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
        jTabelaAdmissaoEnfermeiraAD = new javax.swing.JTable();
        jPanel45 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel46 = new javax.swing.JPanel();
        jPanel47 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jIdADM_Secundaria = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jStatusLanc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jDataLanc = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jIdInternoEnfermeiroAD = new javax.swing.JTextField();
        jNomeInternoEnfermeiroAD = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jIdADM_Princial = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jRBTranquilo = new javax.swing.JRadioButton();
        jRBAnsioso = new javax.swing.JRadioButton();
        jRBAgeressivo = new javax.swing.JRadioButton();
        jRBTrite = new javax.swing.JRadioButton();
        jRBAgitado = new javax.swing.JRadioButton();
        jPanel17 = new javax.swing.JPanel();
        jRBPreservado = new javax.swing.JRadioButton();
        jRBDiminuido = new javax.swing.JRadioButton();
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
        jPanel16 = new javax.swing.JPanel();
        jRBOrientado = new javax.swing.JRadioButton();
        jRBDesorientado = new javax.swing.JRadioButton();
        jLabel42 = new javax.swing.JLabel();
        jComboBoxUsaMedica = new javax.swing.JComboBox();
        jLabel50 = new javax.swing.JLabel();
        jQualMedicamento = new javax.swing.JTextField();
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
        jPanel11 = new javax.swing.JPanel();
        jRBFuncaoComAlteracao = new javax.swing.JRadioButton();
        jRBFuncaoSemAlteracao = new javax.swing.JRadioButton();
        jLabel52 = new javax.swing.JLabel();
        jQualFuncaoMotora = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel42 = new javax.swing.JPanel();
        jBtFIA = new javax.swing.JButton();
        jBtFVG = new javax.swing.JButton();
        jBtVA = new javax.swing.JButton();
        jBtTRC = new javax.swing.JButton();
        jBtFA = new javax.swing.JButton();
        jBtPE = new javax.swing.JButton();
        jBtCC = new javax.swing.JButton();
        jBtFT = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jComboBoxUsuarioDrogas = new javax.swing.JComboBox();
        jQuaisDrogas = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jQuaisDoencas = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jComboBoxPortadorDoencas = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jComboBoxAlergias = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        jQuaisAlergias = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jObservacao = new javax.swing.JTextArea();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("...::: Admissão Enfermagem :::...");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

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

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jCodigoLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqDatas, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(131, Short.MAX_VALUE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jNomesInternoPesq)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxTodos)
                        .addGap(21, 21, 21))))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel20)
                    .addComponent(jCodigoLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqCodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel22)
                    .addComponent(jDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(jDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqDatas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jNomesInternoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(jBtPesqNomeInterno)
                    .addComponent(jCheckBoxTodos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaAdmissaoEnfermeiraAD.setAutoCreateRowSorter(true);
        jTabelaAdmissaoEnfermeiraAD.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaAdmissaoEnfermeiraAD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data", "Status", "Nome Completo do Interno", "Histórico Criminal"
            }
        ));
        jTabelaAdmissaoEnfermeiraAD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaAdmissaoEnfermeiraADMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTabelaAdmissaoEnfermeiraAD);
        if (jTabelaAdmissaoEnfermeiraAD.getColumnModel().getColumnCount() > 0) {
            jTabelaAdmissaoEnfermeiraAD.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaAdmissaoEnfermeiraAD.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaAdmissaoEnfermeiraAD.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaAdmissaoEnfermeiraAD.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaAdmissaoEnfermeiraAD.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaAdmissaoEnfermeiraAD.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaAdmissaoEnfermeiraAD.getColumnModel().getColumn(3).setMinWidth(335);
            jTabelaAdmissaoEnfermeiraAD.getColumnModel().getColumn(3).setMaxWidth(335);
            jTabelaAdmissaoEnfermeiraAD.getColumnModel().getColumn(4).setMinWidth(335);
            jTabelaAdmissaoEnfermeiraAD.getColumnModel().getColumn(4).setMaxWidth(335);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("Listagem", jPanel1);

        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código");

        jIdADM_Secundaria.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdADM_Secundaria.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdADM_Secundaria.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Status");

        jStatusLanc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jStatusLanc.setForeground(new java.awt.Color(153, 0, 153));
        jStatusLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jStatusLanc.setDisabledTextColor(new java.awt.Color(204, 0, 153));
        jStatusLanc.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Data");

        jDataLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataLanc.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Código");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Nome Completo do Interno");

        jIdInternoEnfermeiroAD.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jIdInternoEnfermeiroAD.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdInternoEnfermeiroAD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdInternoEnfermeiroAD.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jIdInternoEnfermeiroAD.setEnabled(false);

        jNomeInternoEnfermeiroAD.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jNomeInternoEnfermeiroAD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoEnfermeiroAD.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jNomeInternoEnfermeiroAD.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("A.Principal");

        jIdADM_Princial.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdADM_Princial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdADM_Princial.setEnabled(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jIdInternoEnfermeiroAD, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(247, 247, 247)
                                .addComponent(jLabel3)
                                .addGap(64, 64, 64))
                            .addComponent(jNomeInternoEnfermeiroAD)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jIdADM_Secundaria, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jIdADM_Princial)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jStatusLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDataLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jIdADM_Secundaria, jIdInternoEnfermeiroAD});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIdADM_Princial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdADM_Secundaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jStatusLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(3, 3, 3)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIdInternoEnfermeiroAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNomeInternoEnfermeiroAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Estado Emocional", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jRBTranquilo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBTranquilo.setSelected(true);
        jRBTranquilo.setText("Tranquilo");
        jRBTranquilo.setEnabled(false);

        jRBAnsioso.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBAnsioso.setText("Ansioso");
        jRBAnsioso.setEnabled(false);

        jRBAgeressivo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBAgeressivo.setText("Agressivo");
        jRBAgeressivo.setEnabled(false);

        jRBTrite.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBTrite.setText("Triste");
        jRBTrite.setEnabled(false);

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
                .addContainerGap(16, Short.MAX_VALUE))
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

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Sono/Repouso", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jRBPreservado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBPreservado.setSelected(true);
        jRBPreservado.setText("Preservado");
        jRBPreservado.setEnabled(false);

        jRBDiminuido.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBDiminuido.setText("Dimunuido");
        jRBDiminuido.setEnabled(false);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRBDiminuido)
                    .addComponent(jRBPreservado))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jRBPreservado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRBDiminuido))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Sinais Vitais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

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
                    .addComponent(jFrequenciaRespira, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(jPressaoArterial))
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel34)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPeso, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(jHemograma))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel28)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jFrequenciaCardiaca)
                    .addComponent(jTemperatura, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31)
                    .addComponent(jLabel29))
                .addContainerGap())
        );

        jPanel12Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jHemograma, jPeso});

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

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Nível Consciência", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jRBOrientado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBOrientado.setSelected(true);
        jRBOrientado.setText("Orientado");
        jRBOrientado.setEnabled(false);

        jRBDesorientado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBDesorientado.setText("Desorientado");
        jRBDesorientado.setEnabled(false);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        jPanel43.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Locomoção", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jRBDeambulando.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBDeambulando.setSelected(true);
        jRBDeambulando.setText("Deambul.");
        jRBDeambulando.setEnabled(false);

        jRBDifiDeambulando.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBDifiDeambulando.setText("Difi. Deamb.");
        jRBDifiDeambulando.setEnabled(false);

        jRBDeficiente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBDeficiente.setText("Deficiente");
        jRBDeficiente.setEnabled(false);

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel43Layout.createSequentialGroup()
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
                .addContainerGap()
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jRBDeambulando)
                    .addComponent(jRBDifiDeambulando)
                    .addComponent(jRBDeficiente))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Acuidade Visual", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jRBAcuiVisualPreservado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBAcuiVisualPreservado.setSelected(true);
        jRBAcuiVisualPreservado.setText("Preservado");
        jRBAcuiVisualPreservado.setEnabled(false);

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

        jPanel44.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "A. Auditiva", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jRBAcuAudiPreservado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBAcuAudiPreservado.setSelected(true);
        jRBAcuAudiPreservado.setText("Preservado");
        jRBAcuAudiPreservado.setEnabled(false);

        jRBAcuidAudDiminuido.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBAcuidAudDiminuido.setText("Diminuido");
        jRBAcuidAudDiminuido.setEnabled(false);

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRBAcuAudiPreservado)
                    .addComponent(jRBAcuidAudDiminuido)))
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addComponent(jRBAcuAudiPreservado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRBAcuidAudDiminuido))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Função Motora", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jRBFuncaoComAlteracao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBFuncaoComAlteracao.setText("Com Alteração");
        jRBFuncaoComAlteracao.setEnabled(false);

        jRBFuncaoSemAlteracao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBFuncaoSemAlteracao.setSelected(true);
        jRBFuncaoSemAlteracao.setText("Sem Alteração");
        jRBFuncaoSemAlteracao.setEnabled(false);

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel52.setText("Qual?");

        jQualFuncaoMotora.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualFuncaoMotora.setEnabled(false);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
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
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jRBFuncaoComAlteracao)
                    .addComponent(jRBFuncaoSemAlteracao)
                    .addComponent(jQualFuncaoMotora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel52))
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 522, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxUsaMedica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel50)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jQualMedicamento))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(3, 3, 3)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 2, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(jComboBoxUsaMedica, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel50)
                    .addComponent(jQualMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jPanel43, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane2.addTab("Dados Iniciais", jPanel3);

        jPanel42.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Anotação/Evolução da Admissão", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jBtFIA.setText("FIA");
        jBtFIA.setToolTipText("Função Intestinal/Abdome");
        jBtFIA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFIAActionPerformed(evt);
            }
        });

        jBtFVG.setText("FVG");
        jBtFVG.setToolTipText("Função Vesical/Genitália");
        jBtFVG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFVGActionPerformed(evt);
            }
        });

        jBtVA.setText("VA");
        jBtVA.setToolTipText("Vacinas");
        jBtVA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtVAActionPerformed(evt);
            }
        });

        jBtTRC.setText("TRC");
        jBtTRC.setToolTipText("Testes Rápidos/Cirurgias");
        jBtTRC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtTRCActionPerformed(evt);
            }
        });

        jBtFA.setText("FA");
        jBtFA.setToolTipText("Fala");
        jBtFA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFAActionPerformed(evt);
            }
        });

        jBtPE.setText("PE");
        jBtPE.setToolTipText("Pele/Mucosa");
        jBtPE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPEActionPerformed(evt);
            }
        });

        jBtCC.setText("CC");
        jBtCC.setToolTipText("Couro Cabeludo");
        jBtCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCCActionPerformed(evt);
            }
        });

        jBtFT.setText("FT");
        jBtFT.setToolTipText("Função Respiratória/Tórax");
        jBtFT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jBtFA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtPE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtFT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtFIA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtFVG)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtVA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtTRC)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtFA)
                    .addComponent(jBtPE)
                    .addComponent(jBtCC)
                    .addComponent(jBtFT)
                    .addComponent(jBtFIA)
                    .addComponent(jBtFVG)
                    .addComponent(jBtVA)
                    .addComponent(jBtTRC))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Anotação/Evolução da Admissão", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Quais?");

        jComboBoxUsuarioDrogas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxUsuarioDrogas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxUsuarioDrogas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxUsuarioDrogas.setEnabled(false);

        jQuaisDrogas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQuaisDrogas.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Usuário de drogas?");

        jQuaisDoencas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQuaisDoencas.setEnabled(false);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Quais?");

        jComboBoxPortadorDoencas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxPortadorDoencas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxPortadorDoencas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxPortadorDoencas.setEnabled(false);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Portador doença?");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Alergias?");

        jComboBoxAlergias.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxAlergias.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxAlergias.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxAlergias.setEnabled(false);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Quais?");

        jQuaisAlergias.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQuaisAlergias.setEnabled(false);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jComboBoxUsuarioDrogas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jQuaisDrogas, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxPortadorDoencas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxAlergias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(323, 323, 323))
                            .addComponent(jQuaisAlergias)
                            .addComponent(jQuaisDoencas))
                        .addContainerGap())))
        );

        jPanel13Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jComboBoxAlergias, jComboBoxPortadorDoencas, jComboBoxUsuarioDrogas});

        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel14)
                    .addComponent(jComboBoxUsuarioDrogas, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jQuaisDrogas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jComboBoxPortadorDoencas, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jQuaisDoencas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel18)
                    .addComponent(jComboBoxAlergias, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jQuaisAlergias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Anotação/Evolução da Admissão", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jObservacao.setColumns(20);
        jObservacao.setRows(5);
        jObservacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jObservacao.setEnabled(false);
        jScrollPane1.setViewportView(jObservacao);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel13, jPanel4, jPanel42});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Continuação", jPanel5);

        jPanel28.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

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
                .addGap(1, 1, 1)
                .addComponent(jBtAlterar)
                .addGap(1, 1, 1)
                .addComponent(jBtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Admissão Enfermgem", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 522, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtFIAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFIAActionPerformed
        // TODO add your handling code here:
        mostrarFIA1();
    }//GEN-LAST:event_jBtFIAActionPerformed

    private void jBtFVGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFVGActionPerformed
        // TODO add your handling code here:
        mostrarFVG1();
    }//GEN-LAST:event_jBtFVGActionPerformed

    private void jBtVAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtVAActionPerformed
        // TODO add your handling code here:
        mostrarVA1();
    }//GEN-LAST:event_jBtVAActionPerformed

    private void jBtTRCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtTRCActionPerformed
        // TODO add your handling code here:
        mostrarTRC1();
    }//GEN-LAST:event_jBtTRCActionPerformed

    private void jBtFAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFAActionPerformed
        // TODO add your handling code here:
        mostrarFA1();
    }//GEN-LAST:event_jBtFAActionPerformed

    private void jBtPEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPEActionPerformed
        // TODO add your handling code here:
        mostrarPE1();
    }//GEN-LAST:event_jBtPEActionPerformed

    private void jBtCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCCActionPerformed
        // TODO add your handling code here:
        mostrarCC1();
    }//GEN-LAST:event_jBtCCActionPerformed

    private void jBtFTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFTActionPerformed
        // TODO add your handling code here:
        mostrarFT1();
    }//GEN-LAST:event_jBtFTActionPerformed

    private void jBtPesqCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqCodigoActionPerformed
        // TODO add your handling code here:
        count = 0;
        if (jCodigoLanc.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um código de Lançamento a ser pesquisado.");
        } else {
            preencherAdmissaoEnfermeira("SELECT * FROM ADMISSAO_ENFERMEIRA_COMPLEMENTAR "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ADMISSAO_ENFERMEIRA_COMPLEMENTAR.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE IdADME='" + jCodigoLanc.getText() + "' ");
        }
    }//GEN-LAST:event_jBtPesqCodigoActionPerformed

    private void jBtPesqNomeInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNomeInternoActionPerformed
        // TODO add your handling code here:
        count = 0;
        if (jNomesInternoPesq.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o nome do interno para pesquisa.");
        } else {
            preencherAdmissaoEnfermeira("SELECT * FROM ADMISSAO_ENFERMEIRA_COMPLEMENTAR "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ADMISSAO_ENFERMEIRA_COMPLEMENTAR.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE NomeInternoCrc LIKE'%" + jNomesInternoPesq.getText() + "%' "
                    + "AND ADMISSAO_ENFERMEIRA_COMPLEMENTAR.IdLanc='" + jIdLanc.getText() + "'");
        }
    }//GEN-LAST:event_jBtPesqNomeInternoActionPerformed

    private void jCheckBoxTodosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxTodosItemStateChanged
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherAdmissaoEnfermeira("SELECT * FROM ADMISSAO_ENFERMEIRA_COMPLEMENTAR "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ADMISSAO_ENFERMEIRA_COMPLEMENTAR.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "AND ADMISSAO_ENFERMEIRA_COMPLEMENTAR.IdLanc='" + jIdLanc.getText() + "'"
                    + "AND ADMISSAO_ENFERMEIRA_COMPLEMENTAR.IdInternoCrc=" + jIdInternoEnfermeiro.getText() + "'");
        } else {
            jtotalRegistros.setText("");
            limparTabelaAdmissao();
        }
    }//GEN-LAST:event_jCheckBoxTodosItemStateChanged

    private void jBtPesqDatasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqDatasActionPerformed
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
                        preencherAdmissaoEnfermeira("SELECT * FROM ADMISSAO_ENFERMEIRA_COMPLEMENTAR "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON ADMISSAO_ENFERMEIRA_COMPLEMENTAR.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                + "WHERE DataLanc BETWEEN'" + dataInicial + "' "
                                + "AND '" + dataFinal + "' "
                                + "AND ADMISSAO_ENFERMEIRA_COMPLEMENTAR.IdLanc='" + jIdLanc.getText() + "' "
                                + "AND ADMISSAO_ENFERMEIRA_COMPLEMENTAR.IdInternoCrc='" + jIdInternoEnfermeiro.getText() + "'");
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
                        preencherAdmissaoEnfermeira("SELECT * FROM ADMISSAO_ENFERMEIRA_COMPLEMENTAR "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON ADMISSAO_ENFERMEIRA_COMPLEMENTAR.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                + "WHERE DataLanc BETWEEN'" + dataInicial + "' "
                                + "AND '" + dataFinal + "' "
                                + "AND ADMISSAO_ENFERMEIRA_COMPLEMENTAR.IdLanc='" + jIdLanc.getText() + "' "
                                + "AND ADMISSAO_ENFERMEIRA_COMPLEMENTAR.IdInternoCrc='" + jIdInternoEnfermeiro.getText() + "'");
                    }
                }
            }
        }
    }//GEN-LAST:event_jBtPesqDatasActionPerformed

    private void jTabelaAdmissaoEnfermeiraADMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaAdmissaoEnfermeiraADMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String IdLanc = "" + jTabelaAdmissaoEnfermeiraAD.getValueAt(jTabelaAdmissaoEnfermeiraAD.getSelectedRow(), 0);
            jCodigoLanc.setText(IdLanc);
            //
            jBtNovo.setEnabled(!true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            jBtImpressaoFicha.setEnabled(true);
            //
            jBtImpressaoFicha.setEnabled(true);
            //
            bloquearCampos();
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ADMISSAO_ENFERMEIRA_COMPLEMENTAR "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ADMISSAO_ENFERMEIRA_COMPLEMENTAR.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE IdADME='" + IdLanc + "'");
                conecta.rs.first();
                jIdADM_Secundaria.setText(String.valueOf(conecta.rs.getInt("IdADME")));
                jStatusLanc.setText(conecta.rs.getString("StatusLanc"));
                jDataLanc.setDate(conecta.rs.getDate("DataLanc"));
                jIdInternoEnfermeiroAD.setText(conecta.rs.getString("IdInternoCrc"));
                jNomeInternoEnfermeiroAD.setText(conecta.rs.getString("NomeInternoCrc"));
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
                qualAlteracaoFala = conecta.rs.getString("QualFala");
                statusMucosa = conecta.rs.getInt("Mucosa");
                statusPele = conecta.rs.getInt("Pele");
                pTipo = conecta.rs.getString("TipoPele");
                pLocalizacao = conecta.rs.getString("Localizacao");
                statusCabelos = conecta.rs.getInt("Cabelos");
                statusBoca = conecta.rs.getInt("Boca");
                statusFuncaoRespiratoria = conecta.rs.getInt("FuncaoRespiratoria");
                statusTorax = conecta.rs.getInt("Torax");
                statusFuncaoIntestinal = conecta.rs.getInt("FuncaoIntestinal");
                pCostipacaoDias = conecta.rs.getString("DiasConstipado");
                statusAbdome = conecta.rs.getInt("Abdome");
                statusFuncaoVesical = conecta.rs.getInt("FuncaoVesical");
                statusGenitalia = conecta.rs.getInt("Genitalia");
                pQualGenitalia = conecta.rs.getString("QualGenitalia");
                pVacina = conecta.rs.getString("Vacinado");
                pQuaisVacinas = conecta.rs.getString("QuaisVacinas");
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
        }
    }//GEN-LAST:event_jTabelaAdmissaoEnfermeiraADMouseClicked

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

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAdmissaoEnfeIntManuENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaAdmissaoEnfeIntManuENF) && codIncluirENF == 1) {
            verificarPortaEntrada();
            verificarRegistroBiometria();
            if (jIdInternoEnfermeiro.getText().equals(pINTERNOCRC) && deptoTecnico.equals(pDEPARTAMENTO) && pHABILITADO.equals("Sim")) {
                if (pHabilitaMedico.equals("Não")) {
                    limparCampos();
                    bloquearCampos();
                    Novo();
                    statusMov = "Incluiu";
                    horaMov = jHoraSistema.getText();
                    dataModFinal = jDataSistema.getText();
                    acao = 1;
                    pesquisarInternoManual();
                } else {
                    limparCampos();
                    bloquearCampos();
                    Novo();
                    //PESQUISAR CÓDIGO DO DEPARTAMENTO PARA CONTABILIZAR O ATENDIMENTO NA TABELA REGISTRO_ATENDIMENTO_INTERNO_PSP
                    procurarDepartamento();
                    //PESQUISAR O INTERNO NO QUAL FEZ A ASSINATURA BIOMETRICA OU FOI LIBERADO PELO COLABORADOR
                    pesquisarInternoColaboradorBiometria();
                    if (jIdInternoEnfermeiroAD.getText().equals("")) {
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

    private void jBtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAdmissaoEnfeIntManuENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaAdmissaoEnfeIntManuENF) && codExcluirENF == 1) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            objAdmEnfermagem.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse antedimento não poderá ser excluída, o mesmo encontra-se FINALIZADO");
            } else {
                if (jIdADM_Secundaria.getText().equals(codEvolucao)) {
                    JOptionPane.showMessageDialog(rootPane, "Esse registro não pode ser EXCLUÍDO.");
                } else {
                    int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o atendimento selecionado?", "Confirmação",
                            JOptionPane.YES_NO_OPTION);
                    if (resposta == JOptionPane.YES_OPTION) {
                        objAdmEnfermagem.setIdADME(Integer.valueOf(jIdADM_Secundaria.getText()));
                        control.excluiAdmissaoEnfermagem(objAdmEnfermagem);
                        objAdmEnfermagem.setNomeInterno(jNomeInternoEnfermeiroAD.getText());;
                        objAdmEnfermagem.setIdLanc(Integer.valueOf(jIdADM_Secundaria.getText()));
                        controle.excluirMovTec(objAdmEnfermagem);
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                        bloquearCampos();
                        bloquearBotoes();
                        limparCampos();
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
            } else if (jNomeInternoEnfermeiroAD.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome do interno para atendimento.");
                jNomeInternoEnfermeiroAD.requestFocus();
                jNomeInternoEnfermeiroAD.setBackground(Color.red);
            } else {
                compararRadioButtons(); // Compara qual botão foi assionado pelo usuário
                objAdmEnfermagem.setIdLanc(Integer.valueOf(jIdLanc.getText()));
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
                //FALA/LINGUAGEM
                objAdmEnfermagem.setFalaLinguagem(statusFalaLinguagem);
                objAdmEnfermagem.setQualFala(qualAlteracaoFala);
                //PELE-MUCOSA
                objAdmEnfermagem.setPele(statusPele);
                objAdmEnfermagem.setMucosa(statusMucosa);
                objAdmEnfermagem.setTipoPele(pTipo);
                objAdmEnfermagem.setLocalizacao(pLocalizacao);
                //CABELOS/BOCA
                objAdmEnfermagem.setCabelos(statusCabelos);
                objAdmEnfermagem.setBoca(statusBoca);
                //RESPIRAÇÃO/TORAX
                objAdmEnfermagem.setFuncaoRespiratoria(statusFuncaoRespiratoria);
                objAdmEnfermagem.setTorax(statusTorax);
                //FUNÇÃO INSTESTINAL
                objAdmEnfermagem.setFuncaoIntestinal(statusFuncaoIntestinal);
                objAdmEnfermagem.setDiasConstipado(pCostipacaoDias);
                objAdmEnfermagem.setAbdome(statusAbdome);
                //FUNÇÃO VESICAL
                objAdmEnfermagem.setFuncaoVesical(statusFuncaoVesical);
                objAdmEnfermagem.setGenitalia(statusGenitalia);
                objAdmEnfermagem.setQualGenitalia(pQualGenitalia);
                // VACINAS
                objAdmEnfermagem.setVacinado(pVacina);
                objAdmEnfermagem.setQuaisVacinas(pQuaisVacinas);
                //TESTES RÁPIDOS
                objAdmEnfermagem.setVdrl(pVdrl);
                objAdmEnfermagem.setHepatiteC(pHepatiteC);
                objAdmEnfermagem.setHepatiteB(pHepatiteB);
                objAdmEnfermagem.setHiv(pHiv);
                objAdmEnfermagem.setCirurgias(pCirurgias);
                objAdmEnfermagem.setQuaisCirurgias(pQualCirurgias);
                objAdmEnfermagem.setSifilis(pSifilis);
                objAdmEnfermagem.setHipertensao(pHipertensao);
                objAdmEnfermagem.setDiabetes(pDiabetes);
                objAdmEnfermagem.setTuberculose(pTuberculose);
                objAdmEnfermagem.setHanseniase(pHanseniase);
                objAdmEnfermagem.setDst(pDst);
                objAdmEnfermagem.setEscabiose(pEscabiose);
                objAdmEnfermagem.setHpv(pHpv);
                //
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
                    objAdmEnfermagem.setIdInternoCrc(Integer.valueOf(jIdInternoEnfermeiroAD.getText()));
                    objAdmEnfermagem.setNomeInterno(jNomeInternoEnfermeiroAD.getText());
                    control.incluirAdmissaoEnfermagem(objAdmEnfermagem);
                    buscarID();
                    objAdmEnfermagem.setIdLanc(Integer.valueOf(jIdADM_Princial.getText()));
                    objAdmEnfermagem.setNomeInterno(jNomeInternoEnfermeiroAD.getText());
                    objAdmEnfermagem.setDeptoMedico(deptoTecnico);
                    controle.incluirMovTec(objAdmEnfermagem);
                    // MODIFICAR A TABELA REGISTRO_ATENDIMENTO_INTERNO_PSP INFORMANDO QUE JÁ FOI ATENDIDO
                    atendido = "Sim";
                    objRegAtend.setIdInternoCrc(Integer.valueOf(jIdInternoEnfermeiroAD.getText()));
                    objRegAtend.setNomeInternoCrc(jNomeInternoEnfermeiroAD.getText());
                    objRegAtend.setIdDepartamento(codigoDepartamentoENFenf);
                    objRegAtend.setNomeDepartamento(nomeModuloENFER);
                    objRegAtend.setTipoAtemdimento(tipoAtendimentoAdm);
                    objRegAtend.setAtendido(atendido);
                    objRegAtend.setDataAtendimento(jDataLanc.getDate());
                    objRegAtend.setIdAtend(Integer.valueOf(jIdADM_Secundaria.getText()));
                    objRegAtend.setQtdAtend(pQUANTIDADE_ATENDIDA);
                    //
                    objRegAtend.setUsuarioUp(nameUser);
                    objRegAtend.setDataUp(dataModFinal);
                    objRegAtend.setHorarioUp(horaMov);
                    controlRegAtend.alterarRegAtend(objRegAtend);
                    //GRAVAR NA TABELA DE ATENDIMENTO ATENDIMENTO_PSP_INTERNO_TV
                    pATENDIMENTO_CONCLUIDO = "Sim";
                    objRegAtend.setStatusAtendimento(status_ATENDIMENTO);
                    objRegAtend.setIdInternoCrc(Integer.valueOf(jIdInternoEnfermeiroAD.getText()));
                    objRegAtend.setNomeInternoCrc(jNomeInternoEnfermeiroAD.getText());
                    objRegAtend.setIdDepartamento(codigoDepartamentoENFenf);
                    objRegAtend.setNomeDepartamento(nomeModuloENFER);
                    objRegAtend.setConcluido(pATENDIMENTO_CONCLUIDO);
                    objRegAtend.setHorarioUp(horaMov);
                    objRegAtend.setIdAtend(Integer.valueOf(jIdADM_Secundaria.getText()));
                    objRegAtend.setTipoAtemdimento(tipoAtendimentoAdm);
                    control_ATENDE.confirmarAtendimento(objRegAtend);
                    //CONFIRMA A REALIZAÇÃO ADMISSÃO DO INTERNO, IMPEDINDO QUE FAÇA OUTRA ADMISSÃO
                    pHABILITA_MEDICO = "Não";
                    objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIdInternoEnfermeiroAD.getText()));
                    objPortaEntrada.setNomeInternoCrc(jNomeInternoEnfermeiroAD.getText());
                    objPortaEntrada.setHabEnf(pHABILITA_MEDICO);
                    control_PE.alterarPortaEntradaEnfermeira(objPortaEntrada);
                    // ADICIONA EVOLUÇÃO APARTIR DA ADMISSÃO - RETIRADO POR INCONSISTENCIA
//                    objRegAtend.setStatusAtendimento(status_ATENDIMENTO);
//                    objEvolEnferma.setIdInternoCrc(Integer.valueOf(jIdInternoEnfermeiroAD.getText()));
//                    objEvolEnferma.setIdLanc(Integer.valueOf(jIdADM_Princial.getText()));
//                    objEvolEnferma.setDataEvol(jDataLanc.getDate());
//                    objEvolEnferma.setTextoEvolucao(jObservacao.getText());
//                    objEvolEnferma.setAdmEvo(admEvolucao);
//                    // log de usuario
//                    objEvolEnferma.setUsuarioInsert(nameUser);
//                    objEvolEnferma.setDataInsert(dataModFinal);
//                    objEvolEnferma.setHoraInsert(horaMov);
//                    controleEnfa.incluirEvolucaoEnfermagem(objEvolEnferma);
                    //
//                    preencherTabelaEvolucaoEnfermagem("SELECT * FROM EVOLUCAOENFERMAGEM "
//                            + "WHERE IdLanc='" + jIdADM_Secundaria.getText() + "'");
//                    buscarEvolucao();
                    //
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    bloquearBotoes();
                    bloquearCampos();
                    Salvar();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
                if (acao == 2) {
                    // log de usuario
                    objAdmEnfermagem.setUsuarioUp(nameUser);
                    objAdmEnfermagem.setDataUp(dataModFinal);
                    objAdmEnfermagem.setHoraUp(horaMov);
                    objAdmEnfermagem.setIdInternoCrc(Integer.valueOf(jIdInternoEnfermeiroAD.getText()));
                    objAdmEnfermagem.setNomeInterno(jNomeInternoEnfermeiroAD.getText());
                    objAdmEnfermagem.setIdADME(Integer.valueOf(jIdADM_Secundaria.getText()));
//                    objAdmEnfermagem.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                    control.alterarAdmissaoEnfermagem(objAdmEnfermagem);
                    objAdmEnfermagem.setIdLanc(Integer.valueOf(jIdADM_Secundaria.getText()));
                    objAdmEnfermagem.setNomeInterno(jNomeInternoEnfermeiroAD.getText());
                    objAdmEnfermagem.setDeptoMedico(deptoTecnico);
                    controle.alterarMovTec(objAdmEnfermagem);
                    // EDITAR A EVOLUÇÃO APARTIR DA ADMISSÃO - RETIRADO POR INCONSISTENCIA
//                    objEvolEnferma.setIdItem(Integer.valueOf(jIdADM_Secundaria.getText()));
//                    objEvolEnferma.setIdInternoCrc(Integer.valueOf(jIdInternoEnfermeiroAD.getText()));
//                    objEvolEnferma.setIdLanc(Integer.valueOf(jIdADM_Princial.getText()));
//                    objEvolEnferma.setDataEvol(jDataLanc.getDate());
//                    objEvolEnferma.setTextoEvolucao(jObservacao.getText());
//                    // log de usuario
//                    objEvolEnferma.setUsuarioInsert(nameUser);
//                    objEvolEnferma.setDataInsert(dataModFinal);
//                    objEvolEnferma.setHoraInsert(horaMov);
//                    controleEnfa.alterarEvolucaoEnfermagem(objEvolEnferma);
//                    preencherTabelaEvolucaoEnfermagem("SELECT * FROM EVOLUCAOENFERMAGEM "
//                            + "WHERE IdLanc='" + jIdADM_Secundaria.getText() + "'");
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    bloquearBotoes();
                    bloquearCampos();
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
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ADMISSAOENFERMEIRA WHERE IdLanc='" + jIdADM_Secundaria.getText() + "'");
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

    private void jBtAuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaAdmissaoEnfermeira objAudiEnfer = new TelaAuditoriaAdmissaoEnfermeira();
        TelaModuloEnfermaria.jPainelMedico.add(objAudiEnfer);
        objAudiEnfer.show();
    }//GEN-LAST:event_jBtAuditoriaActionPerformed

    private void jBtImpressaoFichaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImpressaoFichaActionPerformed
        // TODO add your handling code here:
        if (!jIdADM_Secundaria.getText().equals("") && !jIdInternoEnfermeiroAD.getText().equals("")) {
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
                        + "WHERE PRONTUARIOSCRC.IdInternoCrc='" + jIdInternoEnfermeiroAD.getText() + "'");
                HashMap parametros = new HashMap();
                parametros.put("MatriculaCrc", jIdInternoEnfermeiroAD.getText());
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
            java.util.logging.Logger.getLogger(TelaAdmissaoSecundariaEnfermagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAdmissaoSecundariaEnfermagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAdmissaoSecundariaEnfermagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAdmissaoSecundariaEnfermagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaAdmissaoSecundariaEnfermagem dialog = new TelaAdmissaoSecundariaEnfermagem(ADM_ENF, true);
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
    private javax.swing.ButtonGroup Abdome;
    private javax.swing.ButtonGroup AcuidadeAuditiva;
    private javax.swing.ButtonGroup AcuidadeVisual;
    private javax.swing.ButtonGroup Boca;
    private javax.swing.ButtonGroup Cabelos;
    private javax.swing.ButtonGroup EstadoEmocional;
    private javax.swing.ButtonGroup FalaLinguagem;
    private javax.swing.ButtonGroup FuncaoIntestinal;
    private javax.swing.ButtonGroup FuncaoMotora;
    private javax.swing.ButtonGroup FuncaoRespiratoria;
    private javax.swing.ButtonGroup FuncaoVesical;
    private javax.swing.ButtonGroup Genitalia;
    private javax.swing.ButtonGroup Locomocao;
    private javax.swing.ButtonGroup Mucosa;
    private javax.swing.ButtonGroup NivelConciencia;
    private javax.swing.ButtonGroup Pele;
    private javax.swing.ButtonGroup PeleMucosaHipo;
    private javax.swing.ButtonGroup SonoRepouso;
    private javax.swing.ButtonGroup Torax;
    private javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtAuditoria;
    private javax.swing.JButton jBtCC;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtExcluir;
    private javax.swing.JButton jBtFA;
    private javax.swing.JButton jBtFIA;
    private javax.swing.JButton jBtFT;
    private javax.swing.JButton jBtFVG;
    private javax.swing.JButton jBtFinalizar;
    private javax.swing.JButton jBtImpressaoFicha;
    private javax.swing.JButton jBtNovo;
    private javax.swing.JButton jBtPE;
    private javax.swing.JButton jBtPesqCodigo;
    private javax.swing.JButton jBtPesqDatas;
    private javax.swing.JButton jBtPesqNomeInterno;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JButton jBtTRC;
    private javax.swing.JButton jBtVA;
    private javax.swing.JCheckBox jCheckBoxTodos;
    private javax.swing.JTextField jCodigoLanc;
    private javax.swing.JComboBox jComboBoxAlergias;
    private javax.swing.JComboBox jComboBoxPortadorDoencas;
    private javax.swing.JComboBox jComboBoxUsaMedica;
    private javax.swing.JComboBox jComboBoxUsuarioDrogas;
    private com.toedter.calendar.JDateChooser jDataFinal;
    private com.toedter.calendar.JDateChooser jDataInicial;
    private com.toedter.calendar.JDateChooser jDataLanc;
    private javax.swing.JFormattedTextField jFrequenciaCardiaca;
    private javax.swing.JFormattedTextField jFrequenciaRespira;
    private javax.swing.JFormattedTextField jHemograma;
    private javax.swing.JTextField jIdADM_Princial;
    public static javax.swing.JTextField jIdADM_Secundaria;
    public static javax.swing.JTextField jIdInternoEnfermeiroAD;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel63;
    public static javax.swing.JTextField jNomeInternoEnfermeiroAD;
    private javax.swing.JTextField jNomesInternoPesq;
    private javax.swing.JTextArea jObservacao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JFormattedTextField jPeso;
    private javax.swing.JFormattedTextField jPressaoArterial;
    private javax.swing.JTextField jQuaisAlergias;
    private javax.swing.JTextField jQuaisDoencas;
    private javax.swing.JTextField jQuaisDrogas;
    private javax.swing.JTextField jQualFuncaoMotora;
    private javax.swing.JTextField jQualMedicamento;
    private javax.swing.JRadioButton jRBAcuAudiPreservado;
    private javax.swing.JRadioButton jRBAcuiVisualPreservado;
    private javax.swing.JRadioButton jRBAcuiVisulaDiminuido;
    private javax.swing.JRadioButton jRBAcuidAudDiminuido;
    private javax.swing.JRadioButton jRBAgeressivo;
    private javax.swing.JRadioButton jRBAgitado;
    private javax.swing.JRadioButton jRBAnsioso;
    private javax.swing.JRadioButton jRBDeambulando;
    private javax.swing.JRadioButton jRBDeficiente;
    private javax.swing.JRadioButton jRBDesorientado;
    private javax.swing.JRadioButton jRBDifiDeambulando;
    private javax.swing.JRadioButton jRBDiminuido;
    private javax.swing.JRadioButton jRBFuncaoComAlteracao;
    private javax.swing.JRadioButton jRBFuncaoSemAlteracao;
    private javax.swing.JRadioButton jRBOrientado;
    private javax.swing.JRadioButton jRBPreservado;
    private javax.swing.JRadioButton jRBTranquilo;
    private javax.swing.JRadioButton jRBTrite;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTextField jStatusLanc;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTabelaAdmissaoEnfermeiraAD;
    private javax.swing.JFormattedTextField jTemperatura;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void formatarCampos() {
        jQualMedicamento.setDocument(new LimiteDigitosAlfa(37));
        jQualFuncaoMotora.setDocument(new LimiteDigitosAlfa(43));
        jQuaisDrogas.setDocument(new LimiteDigitosAlfa(40));
        jQuaisDoencas.setDocument(new LimiteDigitosAlfa(40));
        jQuaisAlergias.setDocument(new LimiteDigitosAlfa(40));
        jObservacao.setLineWrap(true);
        jObservacao.setWrapStyleWord(true);
    }

    public void corCampos() {
        // ADMISSÃO
        jIdADM_Secundaria.setBackground(Color.white);
        jIdADM_Princial.setBackground(Color.white);
        jStatusLanc.setBackground(Color.white);
        jDataLanc.setBackground(Color.white);
        //
        jIdInternoEnfermeiroAD.setBackground(Color.white);
        jNomeInternoEnfermeiroAD.setBackground(Color.white);
        //
        jPressaoArterial.setBackground(Color.white);
        jHemograma.setBackground(Color.white);
        jTemperatura.setBackground(Color.white);
        jFrequenciaRespira.setBackground(Color.white);
        jPeso.setBackground(Color.white);
        jFrequenciaCardiaca.setBackground(Color.white);
        jQualMedicamento.setBackground(Color.white);
        jQualFuncaoMotora.setBackground(Color.white);
        jComboBoxUsuarioDrogas.setBackground(Color.white);
        jComboBoxPortadorDoencas.setBackground(Color.white);
        jComboBoxAlergias.setBackground(Color.white);
        jQuaisDrogas.setBackground(Color.white);
        jQuaisDoencas.setBackground(Color.white);
        jQuaisAlergias.setBackground(Color.white);
        jObservacao.setBackground(Color.white);
    }

    public void procurarDepartamento() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM DEPARTAMENTOS "
                    + "WHERE NomeDepartamento='" + nomeModuloENFER + "'");
            conecta.rs.first();
            codigoDepartamento = conecta.rs.getInt("IdDepartamento");
            codigoDepartamentoENFenf = conecta.rs.getInt("IdDepartamento");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarPortaEntrada() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PORTA_ENTRADA "
                    + "WHERE IdInternoCrc='" + jIdInternoEnfermeiro.getText() + "' "
                    + "AND PSPEnf='" + deptoTecnico + "' "
                    + "AND HabEnf='" + pHABILITA_MEDICO + "'");
            conecta.rs.first();
            pINTERNOCRC = conecta.rs.getString("IdInternoCrc");
            pDEPARTAMENTO = conecta.rs.getString("PSPEnf");
            pHABILITADO = conecta.rs.getString("HabEnf");
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
                    + "INNER JOIN ADMISSAOENFERMEIRA "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ADMISSAOENFERMEIRA.IdInternoCrc "
                    + "WHERE PRONTUARIOSCRC.SituacaoCrc='" + situacao + "' "
                    + "AND ADMISSAOENFERMEIRA.IdInternoCrc='" + jIdInternoEnfermeiro.getText() + " '"
                    + "OR PRONTUARIOSCRC.SituacaoCrc='" + sitRetorno + "' "
                    + "AND ADMISSAOENFERMEIRA.IdInternoCrc='" + jIdInternoEnfermeiro.getText() + "'");
            conecta.rs.first();
            jIdADM_Princial.setText(String.valueOf(conecta.rs.getInt("IdLanc")));
            // VARIÁVEL QUE NÃO DEIXA MUDAR O INTERNO SE EXISTIR ANAMNESES OU ATESTADO, DIETA E OUTROS.
            codInterno = conecta.rs.getString("IdInternoCrc");
            nomeInternoAnterior = conecta.rs.getString("NomeInternoCrc");
            jIdInternoEnfermeiroAD.setText(conecta.rs.getString("IdInternoCrc"));
            jNomeInternoEnfermeiroAD.setText(conecta.rs.getString("NomeInternoCrc"));
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
                    + "WHERE REGISTRO_ATENDIMENTO_INTERNO_PSP.IdInternoCrc='" + jIdInternoEnfermeiro.getText() + "' "
                    + "AND SituacaoCrc='" + situacao + "' "
                    + "AND Atendido='" + pATENDIDO_PESQUISA + "' "
                    + "AND IdDepartamento='" + codigoDepartamento + "' "
                    + "OR REGISTRO_ATENDIMENTO_INTERNO_PSP.IdInternoCrc='" + jIdInternoEnfermeiro.getText() + "' "
                    + "AND SituacaoCrc='" + sitRetorno + "' "
                    + "AND Atendido='" + pATENDIDO_PESQUISA + "' "
                    + "AND IdDepartamento='" + codigoDepartamento + "'");
            conecta.rs.first();
            jIdADM_Princial.setText(jIdLanc.getText());
            // VARIÁVEL QUE NÃO DEIXA MUDAR O INTERNO SE EXISTIR ANAMNESES OU ATESTADO, DIETA E OUTROS.
            codInterno = conecta.rs.getString("IdInternoCrc");
            nomeInternoAnterior = conecta.rs.getString("NomeInternoCrc");
            jIdInternoEnfermeiroAD.setText(conecta.rs.getString("IdInternoCrc"));
            jNomeInternoEnfermeiroAD.setText(conecta.rs.getString("NomeInternoCrc"));
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarRegistroBiometria() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PARAMETROSCRC");
            conecta.rs.first();
            pHabilitaMedico = conecta.rs.getString("BiometriaMedicos");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void limparCampos() {
        jIdADM_Secundaria.setText("");
        jStatusLanc.setText("");
        jDataLanc.setDate(null);
        //
        jIdInternoEnfermeiroAD.setText("");
        jNomeInternoEnfermeiroAD.setText("");
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
        jComboBoxUsuarioDrogas.setSelectedItem("Não");
        jComboBoxPortadorDoencas.setSelectedItem("Não");
        jComboBoxAlergias.setSelectedItem("Não");
        jQuaisDrogas.setText("");
        jQuaisDoencas.setText("");
        jQuaisAlergias.setText("");
        jObservacao.setText("");
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
        jComboBoxUsuarioDrogas.setSelectedItem("Não");
        jComboBoxPortadorDoencas.setSelectedItem("Não");
        jComboBoxAlergias.setSelectedItem("Não");
        jQuaisDrogas.setText("");
        jQuaisDoencas.setText("");
        jQuaisAlergias.setText("");
        // Observação
        jObservacao.setText("");
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
    }

    public void bloquearCampos() {
        jDataLanc.setEnabled(!true);
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
        //
        jComboBoxUsuarioDrogas.setEnabled(!true);
        jComboBoxPortadorDoencas.setEnabled(!true);
        jComboBoxAlergias.setEnabled(!true);
        jQuaisDrogas.setEnabled(!true);
        jQuaisDoencas.setEnabled(!true);
        jQuaisAlergias.setEnabled(!true);
        jObservacao.setEnabled(!true);
    }

    public void bloquearBotoes() {
        // ADMISSÃO
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        jBtImpressaoFicha.setEnabled(!true);
    }

    public void Novo() {
        //Habilitar/Desabilitar Campos   
        jStatusLanc.setText("ABERTO");
        jDataLanc.setCalendar(Calendar.getInstance());
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
        //
        jComboBoxUsuarioDrogas.setEnabled(true);
        jComboBoxPortadorDoencas.setEnabled(true);
        jComboBoxAlergias.setEnabled(true);
        jQuaisDrogas.setEnabled(true);
        jQuaisDoencas.setEnabled(true);
        jQuaisAlergias.setEnabled(true);
        jObservacao.setEnabled(true);
        // ADMISSÃO
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
    }

    public void Alterar() {
        //Habilitar/Desabilitar Campos        
        jDataLanc.setEnabled(true);
        //Habilitar/Desabilitar Campos        
        jDataLanc.setEnabled(true);
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
        //
        jComboBoxUsuarioDrogas.setEnabled(true);
        jComboBoxPortadorDoencas.setEnabled(true);
        jComboBoxAlergias.setEnabled(true);
        jQuaisDrogas.setEnabled(true);
        jQuaisDoencas.setEnabled(true);
        jQuaisAlergias.setEnabled(true);
        jObservacao.setEnabled(true);
        // ADMISSÃO
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
        jBtImpressaoFicha.setEnabled(true);
    }

    public void Cancelar() {
        if (jIdADM_Secundaria.getText().equals("")) {
            limparCampos();
            bloquearBotoes();
            bloquearCampos();
            jBtNovo.setEnabled(true);
        } else {
            bloquearCampos();
            bloquearBotoes();
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtCancelar.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            jBtImpressaoFicha.setEnabled(true);
        }
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
    }

    public void Finalizar() {
        String statusLanc = "FINALIZADO";
        JOptionPane.showMessageDialog(rootPane, "Se esse Lançamento for finaliza,\nvocê não poderá mais excluir ou alterar.");
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente finalizar assim mesmo o lançamento selecionado?", "Confirmação",
                JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            objAdmEnfermagem.setStatusLanc(statusLanc);
            objAdmEnfermagem.setIdLanc(Integer.parseInt(jIdADM_Secundaria.getText()));
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
            conecta.executaSQL("SELECT * FROM ADMISSAO_ENFERMEIRA_COMPLEMENTAR");
            conecta.rs.last();
            jIdADM_Secundaria.setText(String.valueOf(conecta.rs.getInt("IdADME")));
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

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jIdADM_Secundaria.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
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
                dados.add(new Object[]{conecta.rs.getString("IdADME"), dataEntrada, conecta.rs.getString("StatusLanc"), conecta.rs.getString("NomeInternoCrc"), conecta.rs.getString("Observacao")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaAdmissaoEnfermeiraAD.setModel(modelo);
        jTabelaAdmissaoEnfermeiraAD.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaAdmissaoEnfermeiraAD.getColumnModel().getColumn(0).setResizable(false);
        jTabelaAdmissaoEnfermeiraAD.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaAdmissaoEnfermeiraAD.getColumnModel().getColumn(1).setResizable(false);
        jTabelaAdmissaoEnfermeiraAD.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaAdmissaoEnfermeiraAD.getColumnModel().getColumn(2).setResizable(false);
        jTabelaAdmissaoEnfermeiraAD.getColumnModel().getColumn(3).setPreferredWidth(335);
        jTabelaAdmissaoEnfermeiraAD.getColumnModel().getColumn(3).setResizable(false);
        jTabelaAdmissaoEnfermeiraAD.getColumnModel().getColumn(4).setPreferredWidth(335);
        jTabelaAdmissaoEnfermeiraAD.getColumnModel().getColumn(4).setResizable(false);
        jTabelaAdmissaoEnfermeiraAD.getTableHeader().setReorderingAllowed(false);
        jTabelaAdmissaoEnfermeiraAD.setAutoResizeMode(jTabelaAdmissaoEnfermeiraAD.AUTO_RESIZE_OFF);
        jTabelaAdmissaoEnfermeiraAD.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
        jTabelaAdmissaoEnfermeiraAD.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaAdmissaoEnfermeiraAD.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaAdmissaoEnfermeiraAD.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }

    public void limparTabelaAdmissao() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Nome Completo do Interno", "Histórico Criminal"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaAdmissaoEnfermeiraAD.setModel(modelo);
        jTabelaAdmissaoEnfermeiraAD.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaAdmissaoEnfermeiraAD.getColumnModel().getColumn(0).setResizable(false);
        jTabelaAdmissaoEnfermeiraAD.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaAdmissaoEnfermeiraAD.getColumnModel().getColumn(1).setResizable(false);
        jTabelaAdmissaoEnfermeiraAD.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaAdmissaoEnfermeiraAD.getColumnModel().getColumn(2).setResizable(false);
        jTabelaAdmissaoEnfermeiraAD.getColumnModel().getColumn(3).setPreferredWidth(335);
        jTabelaAdmissaoEnfermeiraAD.getColumnModel().getColumn(3).setResizable(false);
        jTabelaAdmissaoEnfermeiraAD.getColumnModel().getColumn(4).setPreferredWidth(335);
        jTabelaAdmissaoEnfermeiraAD.getColumnModel().getColumn(4).setResizable(false);
        jTabelaAdmissaoEnfermeiraAD.getTableHeader().setReorderingAllowed(false);
        jTabelaAdmissaoEnfermeiraAD.setAutoResizeMode(jTabelaAdmissaoEnfermeiraAD.AUTO_RESIZE_OFF);
        jTabelaAdmissaoEnfermeiraAD.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void preencherTabelaEvolucaoEnfermagem(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Seq.", "Data", "Anotação/Evolução"};
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
        String[] Colunas = new String[]{"Código", "Data", "Anotação/Evolução"};
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
