/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleConfirmacaoAtendimento;
import gestor.Controle.ControleEvolucaoPsicologica;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControleMovPsicologia;
import gestor.Controle.ControleParecerPsicologico;
import gestor.Controle.ControlePortaEntrada;
import gestor.Controle.ControleRegistroAtendimentoInternoBio;
import gestor.Dao.ConexaoBancoDados;
import gestor.Controle.ControleAdminssaoPsicologiaDAO;
import Utilitarios.LimiteDigitos;
import Utilitarios.LimiteDigitosAlfa;
import Utilitarios.LimiteDigitosSoNum;
import Utilitarios.ModeloTabela;
import gestor.Modelo.AdmissaoPsicologica;
import gestor.Modelo.EvolucaoPsicologica;
import gestor.Modelo.LogSistema;
import gestor.Modelo.PortaEntrada;
import gestor.Modelo.RegistroAtendimentoInternos;
import static gestor.Visao.TelaAdmissaoPsicologica.jIdInterno;
import static gestor.Visao.TelaAdmissaoPsicologica.jIdLanc;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import static gestor.Visao.TelaModuloPsicologia.codAbrirPSI;
import static gestor.Visao.TelaModuloPsicologia.codAlterarPSI;
import static gestor.Visao.TelaModuloPsicologia.codConsultarPSI;
import static gestor.Visao.TelaModuloPsicologia.codExcluirPSI;
import static gestor.Visao.TelaModuloPsicologia.codGravarPSI;
import static gestor.Visao.TelaModuloPsicologia.codIncluirPSI;
import static gestor.Visao.TelaModuloPsicologia.codUserAcessoPSI;
import static gestor.Visao.TelaModuloPsicologia.codigoGrupoPSI;
import static gestor.Visao.TelaModuloPsicologia.codigoUserGroupPSI;
import static gestor.Visao.TelaModuloPsicologia.codigoUserPSI;
import static gestor.Visao.TelaModuloPsicologia.nomeGrupoPSI;
import static gestor.Visao.TelaModuloPsicologia.nomeModuloPSICOLOGIA;
import static gestor.Visao.TelaModuloPsicologia.nomeTelaPSI;
import static gestor.Visao.TelaModuloPsicologia.pQUANTIDADE_ATENDIDA;
import static gestor.Visao.TelaModuloPsicologia.telaMovimentacaoAdmIntManuPSI;
import java.awt.Color;
import java.awt.Image;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Socializa TI 02
 */
public class TelaNovaAdmissaoPSI extends javax.swing.JDialog {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AdmissaoPsicologica objAdmPsi = new AdmissaoPsicologica();
    ControleAdminssaoPsicologiaDAO control = new ControleAdminssaoPsicologiaDAO();
    //
    ControleMovPsicologia controle = new ControleMovPsicologia();
    //
    ControleParecerPsicologico controleParecer = new ControleParecerPsicologico();
    //
    EvolucaoPsicologica evolu = new EvolucaoPsicologica();
    ControleEvolucaoPsicologica controlEvolu = new ControleEvolucaoPsicologica();
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
    String nomeModuloTela = "Psicologia:Admissão de Internos:Manutenção";
    String nomeModuloTela2 = "Psicologia:Evolução Psicológica de Internos";
    String nomeModuloTela3 = "Psicologia:Parecer Psicológico de Internos";
    String statusMov;
    String horaMov;
    String dataModFinal;
    //
    int flag;
    public static int acao = 0;
    String dataInicial, dataFinal, dataEntrada, dataEvolucao;
    String deptoTecnico = "PSICOLOGIA";
    String caminho;
    String idAtendimento; // Varivel que impedi exclusão do documento se existir evolução
    int count = 0;
    //
    String nomeUserRegistro;
    int tipoAlcool;
    int tipoCigarro;
    int tipoMaconha;
    int tipoCrack;
    int tipoCocaina;
    int tipoCola;
    int tipoOutros;
    // PARECER PSICOLOGICO
    int codigoParecer;
    // AGENDAMENTO
    public static String departamentoAgenda = "PSICOLOGIA";
    String nomeDepartamento;
    String codigoStatusReg;
    String codigoInterno;
    //
    String dataReg = "";
    String codigoInternoAtend = "";
    String atendido = "Sim";
    String opcao = "Não";
    public static int codigoDepartamentoPSI = 0;
    String tipoAtendimentoAdm = "Admissão Psicologica";
    String tipoAtendimentoEvol = "Evolução Psicologica";
    //
    String pHabilitaPsicologia = "";
    //ATENDIMENTO MOSTRADO NA TV
    String pATENDIMENTO_CONCLUIDO = "Sim";
    String status_ATENDIMENTO = "Atendimento Concluido";
    //PORTA DE ENTRADA COM ORIGEM NO CRC/TRIAGEM
    String pHABILITA_PSICOLOGIA = "Sim";
    String pDEPARTAMENTO = "";
    String pINTERNOCRC = "";
    String pHABILITADO = "";
    String pCONFIRMA_ADMISSAO = "Sim";
    int codigoDepartamento = 0;
    String situacao = "ENTRADA NA UNIDADE";
    String sitRetorno = "RETORNO A UNIDADE";
    String codInterno;
    String nomeInternoAnterior = "";
    String pATENDIDO_PESQUISA = "Não";

    /**
     * Creates new form TelaNovaAdmissaoPSI
     */
    public static TelaAdmissaoPsicologica pNOVA_ADMISSAO_PSI;
    public static TelaArtigosParagrafosInternoPSI_NOVA pARTIGOS_PARAGRAFOS;
    public static TelaConsultaVisitasInternosPSI_NOVA pCONSULTA_VISITAS_INTERNOS;
    public static AgendamentoAtendimentoPsicologico_NOVO pAGENDA_ATENDIMENTO_PSI;
    public static TelaTratamentoPsicologico_NOVO pNOVO_TRATAMENTO;

    public TelaNovaAdmissaoPSI(TelaAdmissaoPsicologica parent, boolean modal) {
        this.pNOVA_ADMISSAO_PSI = parent;
        this.setModal(modal);
        setLocationRelativeTo(pNOVA_ADMISSAO_PSI);
        initComponents();
        corCampos();
        formatarCampos();
        jTabbedPane1.setSelectedIndex(1);
    }

    public void mostrarTelaArtigos() {
        pARTIGOS_PARAGRAFOS = new TelaArtigosParagrafosInternoPSI_NOVA(this, true);
        pARTIGOS_PARAGRAFOS.setVisible(true);
    }

    public void mostrarVisitasInternos() {
        pCONSULTA_VISITAS_INTERNOS = new TelaConsultaVisitasInternosPSI_NOVA(this, true);
        pCONSULTA_VISITAS_INTERNOS.setVisible(true);
    }

    public void mostrarAgendaAtendimento() {
        pAGENDA_ATENDIMENTO_PSI = new AgendamentoAtendimentoPsicologico_NOVO(this, true);
        pAGENDA_ATENDIMENTO_PSI.setVisible(true);
    }

    public void mostraTelaTratamentoPSI() {
        pNOVO_TRATAMENTO = new TelaTratamentoPsicologico_NOVO(this, true);
        pNOVO_TRATAMENTO.setVisible(true);
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
        jPanel15 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jIDPesq = new javax.swing.JTextField();
        jBtIDPesq = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPesqNomeInterno = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jDataInicial = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jDataFinal = new com.toedter.calendar.JDateChooser();
        jBtPesqDatas = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTabelaAdmissaoPsicologica = new javax.swing.JTable();
        jPanel38 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jPanel42 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel41 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jIdInternoNovo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jNomeInterno = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jIdADM_NOVA = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jStatusLanc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jDataLanc = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jIdADM_Principal = new javax.swing.JTextField();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jHistoricoCriminal = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();
        jComboBoxPresoAntes = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jComboBoxFamiliaPreso = new javax.swing.JComboBox();
        jQuemFamiliaPreso = new javax.swing.JTextField();
        jOndePreso = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jDrogas = new javax.swing.JTextArea();
        jLabel19 = new javax.swing.JLabel();
        jComboBoxUsaDrogras = new javax.swing.JComboBox();
        jLabel20 = new javax.swing.JLabel();
        jCheckBoxAlcool = new javax.swing.JCheckBox();
        jCheckBoxCigarro = new javax.swing.JCheckBox();
        jCheckBoxMaconha = new javax.swing.JCheckBox();
        jCheckBoxCrack = new javax.swing.JCheckBox();
        jCheckBoxCocaina = new javax.swing.JCheckBox();
        jCheckBoxCola = new javax.swing.JCheckBox();
        jCheckBoxOutros = new javax.swing.JCheckBox();
        jLabel22 = new javax.swing.JLabel();
        jQualIdade = new javax.swing.JFormattedTextField();
        jLabel23 = new javax.swing.JLabel();
        jOutrasDrogas = new javax.swing.JTextField();
        jPorqueUsaDrogas = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTranstornoMental = new javax.swing.JTextArea();
        jLabel24 = new javax.swing.JLabel();
        jComboBoxTratamentoPSI = new javax.swing.JComboBox();
        jLabel25 = new javax.swing.JLabel();
        jComboBoxMedicamentoPSI = new javax.swing.JComboBox();
        jLabel26 = new javax.swing.JLabel();
        jQualMedicamento = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jComboBoxAcompanhaPSI = new javax.swing.JComboBox();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jEncaminhamento = new javax.swing.JTextArea();
        jComboBoxDepartamentoEncaminha = new javax.swing.JComboBox();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jDataEncaminhamento = new com.toedter.calendar.JDateChooser();
        jHoraAcompanha = new javax.swing.JFormattedTextField();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTratamentoAntriores = new javax.swing.JTextArea();
        jLabel31 = new javax.swing.JLabel();
        jComboBoxTratamentoSaude = new javax.swing.JComboBox();
        jLabel32 = new javax.swing.JLabel();
        jQualTratamentoSaude = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jOndeFazTratamento = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTentativaSuicidio = new javax.swing.JTextArea();
        jLabel34 = new javax.swing.JLabel();
        jComboBoxSituacaoTraumatica = new javax.swing.JComboBox();
        jLabel35 = new javax.swing.JLabel();
        jQualSituacaoTraumatica = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jComboBoxHouveTentativaSuicidio = new javax.swing.JComboBox();
        jLabel37 = new javax.swing.JLabel();
        jPorQueSuicidio = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jComoFoiTentarSuicidio = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jOndeTentouSuicidio = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jUsoMedicamentos = new javax.swing.JTextArea();
        jLabel40 = new javax.swing.JLabel();
        jQualMedicamentoUtiliza = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jPorqueUsaMedicamento = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jFamiliares = new javax.swing.JTextArea();
        jLabel42 = new javax.swing.JLabel();
        jComboBoxRecebeVisitas = new javax.swing.JComboBox();
        jLabel43 = new javax.swing.JLabel();
        jBtLocalizarVisitaRol = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jBtNovo = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jBtFinalizar = new javax.swing.JButton();
        jBtAuditoria = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jBtArtigosParagrafos = new javax.swing.JButton();
        jBtLocalizacaoInterno = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jBtTratamento = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jFotoInterno = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("...::: Porta de Entrada - Admissaõ Psicologica :::...");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Código:");

        jIDPesq.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIDPesq.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtIDPesq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtIDPesq.setContentAreaFilled(false);
        jBtIDPesq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtIDPesqActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Nome Interno:");

        jPesqNomeInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jButton10.setContentAreaFilled(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Data Inicial:");

        jDataInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Data Final:");

        jDataFinal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqDatas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqDatas.setContentAreaFilled(false);
        jBtPesqDatas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqDatasActionPerformed(evt);
            }
        });

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox1.setText("Todos");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqDatas, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel15Layout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jIDPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jBtIDPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCheckBox1))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel15Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel7)
                    .addComponent(jIDPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtIDPesq)
                    .addComponent(jCheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel11)
                    .addComponent(jDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqDatas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButton10)
                    .addComponent(jPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaAdmissaoPsicologica.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaAdmissaoPsicologica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data", "Status", "Nome Completo do Interno ", "Histórico Criminal"
            }
        ));
        jTabelaAdmissaoPsicologica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaAdmissaoPsicologicaMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(jTabelaAdmissaoPsicologica);
        if (jTabelaAdmissaoPsicologica.getColumnModel().getColumnCount() > 0) {
            jTabelaAdmissaoPsicologica.getColumnModel().getColumn(0).setMinWidth(60);
            jTabelaAdmissaoPsicologica.getColumnModel().getColumn(0).setMaxWidth(60);
            jTabelaAdmissaoPsicologica.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaAdmissaoPsicologica.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaAdmissaoPsicologica.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaAdmissaoPsicologica.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaAdmissaoPsicologica.getColumnModel().getColumn(3).setMinWidth(330);
            jTabelaAdmissaoPsicologica.getColumnModel().getColumn(3).setMaxWidth(330);
            jTabelaAdmissaoPsicologica.getColumnModel().getColumn(4).setMinWidth(330);
            jTabelaAdmissaoPsicologica.getColumnModel().getColumn(4).setMaxWidth(330);
        }

        jPanel38.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jLabel63.setText("Total de Registros:");

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel63))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel63)
        );

        jPanel42.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jtotalRegistros.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
        );

        jPanel41.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane10)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("Listagem", jPanel1);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Código");

        jIdInternoNovo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdInternoNovo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdInternoNovo.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Nome Completo do Interno");

        jNomeInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInterno.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código");

        jIdADM_NOVA.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdADM_NOVA.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdADM_NOVA.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Status");

        jStatusLanc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jStatusLanc.setForeground(new java.awt.Color(204, 0, 0));
        jStatusLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jStatusLanc.setDisabledTextColor(new java.awt.Color(204, 0, 0));
        jStatusLanc.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Data Admissão");

        jDataLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataLanc.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("ADM");

        jIdADM_Principal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdADM_Principal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdADM_Principal.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jNomeInterno)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jIdInternoNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jIdADM_NOVA, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jIdADM_Principal, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jStatusLanc))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDataLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIdADM_Principal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdADM_NOVA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jStatusLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jIdInternoNovo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));
        jTabbedPane2.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jHistoricoCriminal.setColumns(20);
        jHistoricoCriminal.setRows(5);
        jHistoricoCriminal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHistoricoCriminal.setEnabled(false);
        jScrollPane1.setViewportView(jHistoricoCriminal);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Já foi preso antes?");

        jComboBoxPresoAntes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxPresoAntes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxPresoAntes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxPresoAntes.setEnabled(false);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Alguém em sua família já esteve preso? ");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Onde?");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Se sim, quem?");

        jComboBoxFamiliaPreso.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxFamiliaPreso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxFamiliaPreso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxFamiliaPreso.setEnabled(false);

        jQuemFamiliaPreso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQuemFamiliaPreso.setEnabled(false);

        jOndePreso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jOndePreso.setEnabled(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jOndePreso)
                            .addComponent(jQuemFamiliaPreso)))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel16)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jComboBoxPresoAntes, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel17)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jComboBoxFamiliaPreso, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(13, 13, 13))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jComboBoxPresoAntes, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jComboBoxFamiliaPreso, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jQuemFamiliaPreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jOndePreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        jTabbedPane2.addTab("Histórico Criminal", jPanel5);

        jDrogas.setColumns(20);
        jDrogas.setRows(5);
        jDrogas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDrogas.setEnabled(false);
        jScrollPane3.setViewportView(jDrogas);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Você utiliza drogas lícitas/ilícitas? ");

        jComboBoxUsaDrogras.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxUsaDrogras.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxUsaDrogras.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxUsaDrogras.setEnabled(false);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Se sim, Qual (is)?");

        jCheckBoxAlcool.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxAlcool.setText("Álcool");
        jCheckBoxAlcool.setEnabled(false);

        jCheckBoxCigarro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxCigarro.setText("Cigarro/Pacaia ");
        jCheckBoxCigarro.setEnabled(false);

        jCheckBoxMaconha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxMaconha.setText("Maconha");
        jCheckBoxMaconha.setEnabled(false);

        jCheckBoxCrack.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxCrack.setText("Crack");
        jCheckBoxCrack.setEnabled(false);

        jCheckBoxCocaina.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxCocaina.setText("Cocaína");
        jCheckBoxCocaina.setEnabled(false);

        jCheckBoxCola.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxCola.setText("Cola");
        jCheckBoxCola.setEnabled(false);

        jCheckBoxOutros.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxOutros.setText("Outros:");
        jCheckBoxOutros.setEnabled(false);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("Desde que idade? ");

        jQualIdade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualIdade.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jQualIdade.setEnabled(false);

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setText("Por que começou a usar drogas?");

        jOutrasDrogas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jOutrasDrogas.setEnabled(false);

        jPorqueUsaDrogas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPorqueUsaDrogas.setEnabled(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxAlcool)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxCigarro))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jCheckBoxMaconha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxCrack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxCocaina)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxCola))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jQualIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel23)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxUsaDrogras, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPorqueUsaDrogas)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jCheckBoxOutros, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jOutrasDrogas, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jComboBoxUsaDrogras, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jCheckBoxAlcool)
                    .addComponent(jCheckBoxCigarro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxMaconha)
                    .addComponent(jCheckBoxCrack)
                    .addComponent(jCheckBoxCocaina)
                    .addComponent(jCheckBoxCola))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxOutros)
                    .addComponent(jOutrasDrogas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jQualIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPorqueUsaDrogas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Drogas", jPanel6);

        jTranstornoMental.setColumns(20);
        jTranstornoMental.setRows(5);
        jTranstornoMental.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTranstornoMental.setEnabled(false);
        jScrollPane4.setViewportView(jTranstornoMental);

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setText("Já fez tratamento psiquiátrico?");

        jComboBoxTratamentoPSI.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTratamentoPSI.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxTratamentoPSI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTratamentoPSI.setEnabled(false);

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setText("Usa medicamento psiquiátrico/controlado?");

        jComboBoxMedicamentoPSI.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxMedicamentoPSI.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxMedicamentoPSI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxMedicamentoPSI.setEnabled(false);

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setText("Qual Medicamento?");

        jQualMedicamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualMedicamento.setEnabled(false);

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setText("Sente necessidade de acompanhamento Psicológico ou Psiquiátrico?");

        jComboBoxAcompanhaPSI.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxAcompanhaPSI.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Psicológico", "Psiquiátrico", "Não precisa", "Ambos" }));
        jComboBoxAcompanhaPSI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxAcompanhaPSI.setEnabled(false);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jQualMedicamento))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addComponent(jLabel24)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jComboBoxTratamentoPSI, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addComponent(jLabel25)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jComboBoxMedicamentoPSI, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 32, Short.MAX_VALUE))
                    .addComponent(jComboBoxAcompanhaPSI, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jComboBoxTratamentoPSI, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jComboBoxMedicamentoPSI, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jQualMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxAcompanhaPSI, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Transtorno Mental", jPanel7);

        jEncaminhamento.setColumns(20);
        jEncaminhamento.setRows(5);
        jEncaminhamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jEncaminhamento.setEnabled(false);
        jScrollPane2.setViewportView(jEncaminhamento);

        jComboBoxDepartamentoEncaminha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDepartamentoEncaminha.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione..." }));
        jComboBoxDepartamentoEncaminha.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDepartamentoEncaminha.setEnabled(false);

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel28.setText("Departamento");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel29.setText("Data");

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel30.setText("Hora");

        jDataEncaminhamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataEncaminhamento.setEnabled(false);

        jHoraAcompanha.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHoraAcompanha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jHoraAcompanha.setEnabled(false);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jComboBoxDepartamentoEncaminha, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDataEncaminhamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30)
                            .addComponent(jHoraAcompanha, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxDepartamentoEncaminha, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jHoraAcompanha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDataEncaminhamento, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel30)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        jTabbedPane2.addTab("Encaminhamento", jPanel8);

        jTratamentoAntriores.setColumns(20);
        jTratamentoAntriores.setRows(5);
        jTratamentoAntriores.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTratamentoAntriores.setEnabled(false);
        jScrollPane6.setViewportView(jTratamentoAntriores);

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel31.setText("Já fez ou faz algum tratamento de saúde?");

        jComboBoxTratamentoSaude.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTratamentoSaude.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxTratamentoSaude.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTratamentoSaude.setEnabled(false);

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel32.setText("Qual?");

        jQualTratamentoSaude.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualTratamentoSaude.setEnabled(false);

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel33.setText("Onde?");

        jOndeFazTratamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jOndeFazTratamento.setEnabled(false);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel31)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxTratamentoSaude, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jQualTratamentoSaude, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jOndeFazTratamento, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel11Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jOndeFazTratamento, jQualTratamentoSaude});

        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxTratamentoSaude, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jQualTratamentoSaude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel33)
                    .addComponent(jOndeFazTratamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        jTabbedPane2.addTab("Tratamento Anteriores", jPanel11);

        jTentativaSuicidio.setColumns(20);
        jTentativaSuicidio.setRows(5);
        jTentativaSuicidio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTentativaSuicidio.setEnabled(false);
        jScrollPane7.setViewportView(jTentativaSuicidio);

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel34.setText("Houve alguma situação traumática em sua vida?");

        jComboBoxSituacaoTraumatica.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxSituacaoTraumatica.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxSituacaoTraumatica.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxSituacaoTraumatica.setEnabled(false);

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel35.setText("Qual?");

        jQualSituacaoTraumatica.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualSituacaoTraumatica.setEnabled(false);

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel36.setText("Houve tentativa de suicídio?");

        jComboBoxHouveTentativaSuicidio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxHouveTentativaSuicidio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxHouveTentativaSuicidio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxHouveTentativaSuicidio.setEnabled(false);

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel37.setText("Por que?");

        jPorQueSuicidio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPorQueSuicidio.setEnabled(false);

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel38.setText("Como?");

        jComoFoiTentarSuicidio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComoFoiTentarSuicidio.setEnabled(false);

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel39.setText("Onde?");

        jOndeTentouSuicidio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jOndeTentouSuicidio.setEnabled(false);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jQualSituacaoTraumatica))
                    .addComponent(jPorQueSuicidio)
                    .addComponent(jComoFoiTentarSuicidio)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel34)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxSituacaoTraumatica, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel36)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxHouveTentativaSuicidio, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel37)
                            .addComponent(jLabel38)
                            .addComponent(jLabel39))
                        .addGap(0, 82, Short.MAX_VALUE))
                    .addComponent(jOndeTentouSuicidio))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel34)
                    .addComponent(jComboBoxSituacaoTraumatica, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(jQualSituacaoTraumatica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36)
                    .addComponent(jComboBoxHouveTentativaSuicidio, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPorQueSuicidio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComoFoiTentarSuicidio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jOndeTentouSuicidio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        jTabbedPane2.addTab("Tentativa de Suicídio", jPanel12);

        jUsoMedicamentos.setColumns(20);
        jUsoMedicamentos.setRows(5);
        jUsoMedicamentos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jUsoMedicamentos.setEnabled(false);
        jScrollPane8.setViewportView(jUsoMedicamentos);

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel40.setText("Qual medicamento?");

        jQualMedicamentoUtiliza.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualMedicamentoUtiliza.setEnabled(false);

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel41.setText("Por que?");

        jPorqueUsaMedicamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPorqueUsaMedicamento.setEnabled(false);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel41)
                            .addComponent(jLabel40))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jQualMedicamentoUtiliza)
                            .addComponent(jPorqueUsaMedicamento))))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(jQualMedicamentoUtiliza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel41)
                    .addComponent(jPorqueUsaMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        jTabbedPane2.addTab("Uso de Medicamentos", jPanel13);

        jFamiliares.setColumns(20);
        jFamiliares.setRows(5);
        jFamiliares.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jFamiliares.setEnabled(false);
        jScrollPane9.setViewportView(jFamiliares);

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel42.setText("Recebe visitas?");

        jComboBoxRecebeVisitas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxRecebeVisitas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxRecebeVisitas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxRecebeVisitas.setEnabled(false);

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel43.setText("Quem?");

        jBtLocalizarVisitaRol.setForeground(new java.awt.Color(255, 0, 0));
        jBtLocalizarVisitaRol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtLocalizarVisitaRol.setText("Visitas");
        jBtLocalizarVisitaRol.setToolTipText("Localizar Visitas no Rol");
        jBtLocalizarVisitaRol.setEnabled(false);
        jBtLocalizarVisitaRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtLocalizarVisitaRolActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxRecebeVisitas, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel43)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtLocalizarVisitaRol)))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel43)
                    .addComponent(jBtLocalizarVisitaRol)
                    .addComponent(jComboBoxRecebeVisitas, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        jTabbedPane2.addTab("Familiares", jPanel14);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jBtNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovo.setContentAreaFilled(false);
        jBtNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoActionPerformed(evt);
            }
        });

        jBtAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterar.setContentAreaFilled(false);
        jBtAlterar.setEnabled(false);
        jBtAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarActionPerformed(evt);
            }
        });

        jBtExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216104515_16.png"))); // NOI18N
        jBtExcluir.setContentAreaFilled(false);
        jBtExcluir.setEnabled(false);
        jBtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirActionPerformed(evt);
            }
        });

        jBtSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvar.setContentAreaFilled(false);
        jBtSalvar.setEnabled(false);
        jBtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarActionPerformed(evt);
            }
        });

        jBtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelar.setContentAreaFilled(false);
        jBtCancelar.setEnabled(false);
        jBtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarActionPerformed(evt);
            }
        });

        jBtFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/40_16x16.png"))); // NOI18N
        jBtFinalizar.setContentAreaFilled(false);
        jBtFinalizar.setEnabled(false);
        jBtFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFinalizarActionPerformed(evt);
            }
        });

        jBtAuditoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoria.setContentAreaFilled(false);
        jBtAuditoria.setEnabled(false);
        jBtAuditoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jBtNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jBtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jBtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jBtFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterar, jBtCancelar, jBtExcluir, jBtNovo, jBtSalvar});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtAlterar)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jBtNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBtFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBtAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterar, jBtCancelar, jBtExcluir, jBtNovo, jBtSalvar});

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jBtArtigosParagrafos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/overlays.png"))); // NOI18N
        jBtArtigosParagrafos.setToolTipText("Consulta de Artigos e Parágrafos");
        jBtArtigosParagrafos.setContentAreaFilled(false);
        jBtArtigosParagrafos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtArtigosParagrafosActionPerformed(evt);
            }
        });

        jBtLocalizacaoInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/SEM FOTO_HOMEM_16.jpg"))); // NOI18N
        jBtLocalizacaoInterno.setToolTipText("Localização de Internos");
        jBtLocalizacaoInterno.setContentAreaFilled(false);
        jBtLocalizacaoInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtLocalizacaoInternoActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/user-group-forum-icone-3716-16.png"))); // NOI18N
        jButton1.setToolTipText("Visitas de Internos");
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jBtTratamento.setForeground(new java.awt.Color(0, 102, 0));
        jBtTratamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/061218140238_16.png"))); // NOI18N
        jBtTratamento.setToolTipText("Tratamento");
        jBtTratamento.setContentAreaFilled(false);
        jBtTratamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtTratamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jBtArtigosParagrafos, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtLocalizacaoInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtTratamento, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jBtArtigosParagrafos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jBtLocalizacaoInterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jBtTratamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addComponent(jFotoInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 135, Short.MAX_VALUE))
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(3, 3, 3)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );

        jTabbedPane1.addTab("Admissão", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtIDPesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtIDPesqActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (jIDPesq.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o ID para pesquisa.");
            jIDPesq.requestFocus();
        } else {
            jTabelaAdmissaoPsicologica.setVisible(true);
            preencherAdmissoPsicologia("SELECT * FROM PORTA_ENTRADA_PSICOLOGIA "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON PORTA_ENTRADA_PSICOLOGIA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE IdPortaPSI='" + jIDPesq.getText() + "'");
        }
    }//GEN-LAST:event_jBtIDPesqActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (jPesqNomeInterno.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o nome do interno para pesquisa.");
            jPesqNomeInterno.requestFocus();
        } else {
            jTabelaAdmissaoPsicologica.setVisible(true);
            preencherAdmissoPsicologia("SELECT * FROM PORTA_ENTRADA_PSICOLOGIA "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON PORTA_ENTRADA_PSICOLOGIA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE NomeInternoCrc LIKE'%" + jPesqNomeInterno.getText() + "%'");
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jBtPesqDatasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqDatasActionPerformed
        // TODO add your handling code here:
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
                        jTabelaAdmissaoPsicologica.setVisible(true);
                        preencherAdmissoPsicologia("SELECT * FROM PORTA_ENTRADA_PSICOLOGIA "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON PORTA_ENTRADA_PSICOLOGIA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                + "WHERE DataLanc BETWEEN'" + dataInicial + "'AND '" + dataFinal + "'");
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
                        jTabelaAdmissaoPsicologica.setVisible(true);
                        preencherAdmissoPsicologia("SELECT * FROM PORTA_ENTRADA_PSICOLOGIA "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON PORTA_ENTRADA_PSICOLOGIA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                + "WHERE DataLanc BETWEEN'" + dataInicial + "'AND '" + dataFinal + "'");
                    }
                }
            }
        }
    }//GEN-LAST:event_jBtPesqDatasActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherAdmissoPsicologia("SELECT * FROM PORTA_ENTRADA_PSICOLOGIA "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON PORTA_ENTRADA_PSICOLOGIA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc");
        } else {
            jtotalRegistros.setText("");
            limparTabela();
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jTabelaAdmissaoPsicologicaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaAdmissaoPsicologicaMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String IdLanc = "" + jTabelaAdmissaoPsicologica.getValueAt(jTabelaAdmissaoPsicologica.getSelectedRow(), 0);
            jIDPesq.setText(IdLanc);
            //
            bloquearBotoes();
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);          
            jBtFinalizar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            //
            jBtArtigosParagrafos.setEnabled(true);
            //
//            jBtAgendamentoAtendimento.setEnabled(true);
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM PORTA_ENTRADA_PSICOLOGIA "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON PORTA_ENTRADA_PSICOLOGIA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE IdPortaPSI='" + IdLanc + "'");
                conecta.rs.first();
                jIdADM_NOVA.setText(String.valueOf(conecta.rs.getInt("IdPortaPSI")));
                jIdADM_Principal.setText(String.valueOf(conecta.rs.getInt("IdLanc")));
                jStatusLanc.setText(conecta.rs.getString("StatusLanc"));
                jDataLanc.setDate(conecta.rs.getDate("DataLanc"));
                jIdInternoNovo.setText(conecta.rs.getString("IdInternoCrc"));
                jNomeInterno.setText(conecta.rs.getString("NomeInternoCrc"));
                // Capturando foto
                caminho = conecta.rs.getString("FotoInternoCrc");
                if (caminho != null) {
                    javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                    jFotoInterno.setIcon(i);
                    jFotoInterno.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoInterno.getWidth(), jFotoInterno.getHeight(), Image.SCALE_DEFAULT)));
                }
                // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrente"));
                if (imgBytes != null) {
                    ImageIcon pic = null;
                    pic = new ImageIcon(imgBytes);
                    Image scaled = pic.getImage().getScaledInstance(jFotoInterno.getWidth(), jFotoInterno.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon icon = new ImageIcon(scaled);
                    jFotoInterno.setIcon(icon);
                }
                // HISTORICO CRIMINAL
                jComboBoxPresoAntes.setSelectedItem(conecta.rs.getString("PresoAntes"));
                jComboBoxFamiliaPreso.setSelectedItem(conecta.rs.getString("FamiliaPreso"));
                jQuemFamiliaPreso.setText(conecta.rs.getString("QuemFamiliaPreso"));
                jOndePreso.setText(conecta.rs.getString("OndePreso"));
                jHistoricoCriminal.setText(conecta.rs.getString("HistoricoCriminal"));
                // DROGAS
                jComboBoxUsaDrogras.setSelectedItem(conecta.rs.getString("UsaDrogras"));
                tipoAlcool = conecta.rs.getInt("Alcool");
                if (tipoAlcool == 0) {
                    jCheckBoxAlcool.setSelected(true);
                } else if (tipoAlcool == 1) {
                    jCheckBoxAlcool.setSelected(!true);
                }
                tipoCigarro = conecta.rs.getInt("Cigarro");
                if (tipoCigarro == 0) {
                    jCheckBoxCigarro.setSelected(true);
                } else if (tipoCigarro == 1) {
                    jCheckBoxCigarro.setSelected(!true);
                }
                tipoMaconha = conecta.rs.getInt("Maconha");
                if (tipoMaconha == 0) {
                    jCheckBoxMaconha.setSelected(true);
                } else if (tipoMaconha == 1) {
                    jCheckBoxMaconha.setSelected(!true);
                }
                tipoCrack = conecta.rs.getInt("Crack");
                if (tipoCrack == 0) {
                    jCheckBoxCrack.setSelected(true);
                } else if (tipoCrack == 1) {
                    jCheckBoxCrack.setSelected(!true);
                }
                tipoCocaina = conecta.rs.getInt("Cocaina");
                if (tipoCocaina == 0) {
                    jCheckBoxCocaina.setSelected(true);
                } else if (tipoCocaina == 1) {
                    jCheckBoxCocaina.setSelected(!true);
                }
                tipoCola = conecta.rs.getInt("Cola");
                if (tipoCola == 0) {
                    jCheckBoxCola.setSelected(true);
                } else if (tipoCola == 1) {
                    jCheckBoxCola.setSelected(!true);
                }
                tipoOutros = conecta.rs.getInt("Outros");
                if (tipoOutros == 0) {
                    jCheckBoxOutros.setSelected(true);
                } else if (tipoOutros == 1) {
                    jCheckBoxOutros.setSelected(!true);
                }
                jOutrasDrogas.setText(conecta.rs.getString("OutrasDrogas"));
                jQualIdade.setText(conecta.rs.getString("QualIdade"));
                jPorqueUsaDrogas.setText(conecta.rs.getString("PorqueUsaDrogas"));
                jDrogas.setText(conecta.rs.getString("Drogas"));
                // TRANSTORNO MENTAL
                jComboBoxTratamentoPSI.setSelectedItem(conecta.rs.getString("TratamentoPSI"));
                jComboBoxMedicamentoPSI.setSelectedItem(conecta.rs.getString("MedicamentoPSI"));
                jQualMedicamento.setText(conecta.rs.getString("QualMedicamento"));
                jComboBoxAcompanhaPSI.setSelectedItem(conecta.rs.getString("AcompanhaPSI"));
                jTranstornoMental.setText(conecta.rs.getString("TranstornoMental"));
                // ENCAMINHAMENTO
                jComboBoxDepartamentoEncaminha.setSelectedItem(conecta.rs.getString("DepartamentoEncaminha"));
                jDataEncaminhamento.setDate(conecta.rs.getDate("DataEncaminhamento"));
                jHoraAcompanha.setText(conecta.rs.getString("HoraAcompanha"));
                jEncaminhamento.setText(conecta.rs.getString("Encaminhamento"));
                // TRATAMENTO ANTERIORES
                jComboBoxTratamentoSaude.setSelectedItem(conecta.rs.getString("TratamentoSaude"));
                jQualTratamentoSaude.setText(conecta.rs.getString("QualTratamentoSaude"));
                jOndeFazTratamento.setText(conecta.rs.getString("OndeFazTratamento"));
                jTratamentoAntriores.setText(conecta.rs.getString("TratamentoAnteriores"));
                // TENTATIVA SUICIDIO
                jComboBoxSituacaoTraumatica.setSelectedItem(conecta.rs.getString("SituacaoTraumatica"));
                jQualSituacaoTraumatica.setText(conecta.rs.getString("QualSituacaoTraumatica"));
                jComboBoxHouveTentativaSuicidio.setSelectedItem(conecta.rs.getString("HouveTentativaSuicidio"));
                jPorQueSuicidio.setText(conecta.rs.getString("PorQueSuicidio"));
                jComoFoiTentarSuicidio.setText(conecta.rs.getString("ComoFoiTentarSuicidio"));
                jOndeTentouSuicidio.setText(conecta.rs.getString("OndeTentouSuicidio"));
                jTentativaSuicidio.setText(conecta.rs.getString("TentativaSuicidio"));
                // USO MEDICAMENTOS
                jQualMedicamentoUtiliza.setText(conecta.rs.getString("QualMedicamentoUtiliza"));
                jPorqueUsaMedicamento.setText(conecta.rs.getString("PorqueUsaMedicamento"));
                jUsoMedicamentos.setText(conecta.rs.getString("UsoMedicamentos"));
                jUsoMedicamentos.setText(conecta.rs.getString("UsoMedicamentos"));
                // FAMILIARES
                jComboBoxRecebeVisitas.setSelectedItem(conecta.rs.getString("RecebeVisitas"));
                if (jComboBoxRecebeVisitas.getSelectedItem().equals("Sim")) {
                    jBtLocalizarVisitaRol.setEnabled(true);
                } else if (jComboBoxRecebeVisitas.getSelectedItem().equals("Não") || jComboBoxRecebeVisitas.getSelectedItem().equals("")) {
                    jBtLocalizarVisitaRol.setEnabled(!true);
                }
                jFamiliares.setText(conecta.rs.getString("Familiares"));
                conecta.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa..." + e);
            }
        }
    }//GEN-LAST:event_jTabelaAdmissaoPsicologicaMouseClicked

    private void jBtLocalizarVisitaRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtLocalizarVisitaRolActionPerformed
        // TODO add your handling code here:
        if (jIdInternoNovo.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Pesquise primeiro o interno para consultar a(s) visita(s).");
        } else {
            jBtLocalizarVisitaRol.setEnabled(true);
            mostrarVisitasInternos();
        }
    }//GEN-LAST:event_jBtLocalizarVisitaRolActionPerformed

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaMovimentacaoAdmIntManuPSI);
        if (codigoUserPSI == codUserAcessoPSI && nomeTelaPSI.equals(telaMovimentacaoAdmIntManuPSI) && codIncluirPSI == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPSI.equals("ADMINISTRADORES")) {
            verificarPortaEntrada();
            verificarRegistroBiometria();
            if (jIdInterno.getText().equals(pINTERNOCRC) && deptoTecnico.equals(pDEPARTAMENTO) && pHABILITADO.equals("Sim")) {
                if (pHabilitaPsicologia.equals("Não")) {
                    acao = 1;
                    Novo();
                    statusMov = "Incluiu";
                    horaMov = jHoraSistema.getText();
                    dataModFinal = jDataSistema.getText();
                    preencherComboBoxDepartamento();
                    pesquisarInternoManual();
                } else {                   
                    //PESQUISAR CÓDIGO DO DEPARTAMENTO PARA CONTABILIZAR O ATENDIMENTO NA TABELA REGISTRO_ATENDIMENTO_INTERNO_PSP
                    procurarDepartamento();
                    //PESQUISAR O INTERNO NO QUAL FEZ A ASSINATURA BIOMETRICA OU FOI LIBERADO PELO COLABORADOR
                    pesquisarInternoColaboradorBiometria();
                    if (jIdInternoNovo.getText().equals("")) {
                        JOptionPane.showMessageDialog(rootPane, "Não é possível realizar o atendimento, esse interno não assinou pela biometria ou não foi liberado para ser atendido.");
                    } else {
                         Novo();
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
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaMovimentacaoAdmIntManuPSI);
        if (codigoUserPSI == codUserAcessoPSI && nomeTelaPSI.equals(telaMovimentacaoAdmIntManuPSI) && codAlterarPSI == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPSI.equals("ADMINISTRADORES")) {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM PORTA_ENTRADA_PSICOLOGIA WHERE IdPortaPSI='" + jIdADM_NOVA.getText() + "'");
                conecta.rs.first();
                nomeUserRegistro = conecta.rs.getString("UsuarioInsert");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não foi possivel encontrar o usuário.");
            }
            if (nomeUserRegistro == null ? nameUser == null : nomeUserRegistro.equals(nameUser)) {
                objAdmPsi.setStatusLanc(jStatusLanc.getText());
                if (jStatusLanc.getText().equals("FINALIZADO")) {
                    JOptionPane.showMessageDialog(rootPane, "Esse antedimento não poderá ser alterado, o mesmo encontra-se FINALIZADO");
                } else {
                    acao = 2;
                    preencherComboBoxDepartamento();
                    Alterar();
                    statusMov = "Alterou";
                    horaMov = jHoraSistema.getText();
                    dataModFinal = jDataSistema.getText();
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esse registro foi inserido pelo " + nomeUserRegistro + " só esse usuário poderá modificar.");
                conecta.desconecta();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtAlterarActionPerformed

    private void jBtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaMovimentacaoAdmIntManuPSI);
        if (codigoUserPSI == codUserAcessoPSI && nomeTelaPSI.equals(telaMovimentacaoAdmIntManuPSI) && codExcluirPSI == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPSI.equals("ADMINISTRADORES")) {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM PORTA_ENTRADA_PSICOLOGIA WHERE IdPortaPSI='" + jIdADM_NOVA.getText() + "'");
                conecta.rs.first();
                nomeUserRegistro = conecta.rs.getString("UsuarioInsert");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não foi possivel encontrar o usuário.");
            }
            if (nomeUserRegistro == null ? nameUser == null : nomeUserRegistro.equals(nameUser)) {
                statusMov = "Excluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
                objAdmPsi.setStatusLanc(jStatusLanc.getText());
                if (jStatusLanc.getText().equals("FINALIZADO")) {
                    JOptionPane.showMessageDialog(rootPane, "Esse antedimento não poderá ser excluída, o mesmo encontra-se FINALIZADO");
                } else {
                    int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                            JOptionPane.YES_NO_OPTION);
                    if (resposta == JOptionPane.YES_OPTION) {
                        objAdmPsi.setIdLanc(Integer.valueOf(jIdADM_NOVA.getText()));
                        control.excluirNovaAdmissaoPsi(objAdmPsi);
                        objAdmPsi.setNomeInterno(jNomeInterno.getText());;
                        objAdmPsi.setIdLanc(Integer.valueOf(jIdADM_NOVA.getText()));
                        controle.excluirMovTec(objAdmPsi);
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                        Excluir();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esse registro foi inserido pelo " + nomeUserRegistro + " só esse usuário poderá modificar.");
                conecta.desconecta();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaMovimentacaoAdmIntManuPSI);
        if (codigoUserPSI == codUserAcessoPSI && nomeTelaPSI.equals(telaMovimentacaoAdmIntManuPSI) && codGravarPSI == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPSI.equals("ADMINISTRADORES")) {
            if (jDataLanc.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data do lançamento.");
                jDataLanc.requestFocus();
                jDataLanc.setBackground(Color.red);
            } else {
                if (jNomeInterno.getText().equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "É necessário informar o nome do interno.");
                } else {
                    objAdmPsi.setIdLanc(Integer.valueOf(jIdADM_Principal.getText()));
                    objAdmPsi.setStatusLanc(jStatusLanc.getText());
                    objAdmPsi.setDataLanc(jDataLanc.getDate());
                    // HISTORICO CRIMINAL
                    objAdmPsi.setPresoAntes((String) jComboBoxPresoAntes.getSelectedItem());
                    objAdmPsi.setFamiliaPreso((String) jComboBoxFamiliaPreso.getSelectedItem());
                    objAdmPsi.setQuemFamiliaPreso(jQuemFamiliaPreso.getText());
                    objAdmPsi.setOndePreso(jOndePreso.getText());
                    objAdmPsi.setHistoricoCriminal(jHistoricoCriminal.getText());
                    // DROGAS
                    objAdmPsi.setUsaDrogras((String) jComboBoxUsaDrogras.getSelectedItem());
                    if (jCheckBoxAlcool.isSelected()) {
                        tipoAlcool = 0;
                    } else if (!jCheckBoxAlcool.isSelected()) {
                        tipoAlcool = 1;
                    }
                    objAdmPsi.setAlcool(tipoAlcool);
                    if (jCheckBoxCigarro.isSelected()) {
                        tipoCigarro = 0;
                    } else if (!jCheckBoxCigarro.isSelected()) {
                        tipoCigarro = 1;
                    }
                    objAdmPsi.setCigarro(tipoCigarro);
                    if (jCheckBoxMaconha.isSelected()) {
                        tipoMaconha = 0;
                    } else if (!jCheckBoxMaconha.isSelected()) {
                        tipoMaconha = 1;
                    }
                    objAdmPsi.setMaconha(tipoMaconha);
                    if (jCheckBoxCrack.isSelected()) {
                        tipoCrack = 0;
                    } else if (!jCheckBoxCrack.isSelected()) {
                        tipoCrack = 1;
                    }
                    objAdmPsi.setCrack(tipoCrack);
                    if (jCheckBoxCocaina.isSelected()) {
                        tipoCocaina = 0;
                    } else if (!jCheckBoxCocaina.isSelected()) {
                        tipoCocaina = 1;
                    }
                    objAdmPsi.setCocaina(tipoCocaina);
                    if (jCheckBoxCola.isSelected()) {
                        tipoCola = 0;
                    } else if (!jCheckBoxCola.isSelected()) {
                        tipoCola = 1;
                    }
                    objAdmPsi.setCola(tipoCola);
                    if (jCheckBoxOutros.isSelected()) {
                        tipoOutros = 0;
                    } else if (!jCheckBoxOutros.isSelected()) {
                        tipoOutros = 1;
                    }
                    objAdmPsi.setOutros(tipoOutros);
                    objAdmPsi.setOutrasDrogas(jOutrasDrogas.getText());
                    objAdmPsi.setQualIdade(Integer.valueOf(jQualIdade.getText()));
                    objAdmPsi.setPorqueUsaDrogas(jPorqueUsaDrogas.getText());
                    objAdmPsi.setDrogas(jDrogas.getText());
                    // TRANSTORNO MENTAL
                    objAdmPsi.setTratamentoPSI((String) jComboBoxTratamentoPSI.getSelectedItem());
                    objAdmPsi.setMedicamentoPSI((String) jComboBoxMedicamentoPSI.getSelectedItem());
                    objAdmPsi.setQualMedicamento(jQualMedicamento.getText());
                    objAdmPsi.setAcompanhaPSI((String) jComboBoxAcompanhaPSI.getSelectedItem());
                    objAdmPsi.setTranstornoMental(jTranstornoMental.getText());
                    // ENCAMINHAMENTO
                    objAdmPsi.setDepartamentoEncaminha((String) jComboBoxDepartamentoEncaminha.getSelectedItem());
                    objAdmPsi.setDataEncaminhamento(jDataEncaminhamento.getDate());
                    objAdmPsi.setHoraAcompanha(jHoraAcompanha.getText());
                    objAdmPsi.setEncaminhamento(jEncaminhamento.getText());
                    // TRATAMENTO ANTERIORES
                    objAdmPsi.setTratamentoSaude((String) jComboBoxTratamentoSaude.getSelectedItem());
                    objAdmPsi.setQualTratamentoSaude(jQualTratamentoSaude.getText());
                    objAdmPsi.setOndeFazTratamento(jOndeFazTratamento.getText());
                    objAdmPsi.setTratamentoAntriores(jTratamentoAntriores.getText());
                    // TENTATIVA SUICIDIO
                    objAdmPsi.setSituacaoTraumatica((String) jComboBoxSituacaoTraumatica.getSelectedItem());
                    objAdmPsi.setQualSituacaoTraumatica(jQualSituacaoTraumatica.getText());
                    objAdmPsi.setHouveTentativaSuicidio((String) jComboBoxHouveTentativaSuicidio.getSelectedItem());
                    objAdmPsi.setPorQueSuicidio(jPorQueSuicidio.getText());
                    objAdmPsi.setComoFoiTentarSuicidio(jComoFoiTentarSuicidio.getText());
                    objAdmPsi.setOndeTentouSuicidio(jOndeTentouSuicidio.getText());
                    objAdmPsi.setTentativaSuicidio(jTentativaSuicidio.getText());
                    // USO DE MEDICAMENTOS
                    objAdmPsi.setQualMedicamentoUtiliza(jQualMedicamentoUtiliza.getText());
                    objAdmPsi.setPorqueUsaMedicamento(jPorqueUsaMedicamento.getText());
                    objAdmPsi.setUsoMedicamentos(jUsoMedicamentos.getText());
                    // FAMILIARES
                    objAdmPsi.setRecebeVisitas((String) jComboBoxRecebeVisitas.getSelectedItem());
                    objAdmPsi.setFamiliares(jFamiliares.getText());
                    if (acao == 1) {
                        // log de usuario
                        objAdmPsi.setUsuarioInsert(nameUser);
                        objAdmPsi.setDataInsert(dataModFinal);
                        objAdmPsi.setHoraInsert(horaMov);
                        objAdmPsi.setIdInternoCrc(Integer.valueOf(jIdInternoNovo.getText()));
                        objAdmPsi.setNomeInterno(jNomeInterno.getText());
                        control.incluirNovaAdmissaoPsi(objAdmPsi);
                        buscarID();
                        objAdmPsi.setIdLanc(Integer.valueOf(jIdADM_NOVA.getText()));
                        objAdmPsi.setNomeInterno(jNomeInterno.getText());
                        objAdmPsi.setDeptoPsicologico(deptoTecnico);
                        controle.incluirMovTec(objAdmPsi);
                        // MODIFICAR A TABELA REGISTRO_ATENDIMENTO_INTERNO_PSP INFORMANDO QUE JÁ FOI ATENDIDO   
                        atendido = "Sim";
                        objRegAtend.setIdInternoCrc(Integer.valueOf(jIdInternoNovo.getText()));
                        objRegAtend.setNomeInternoCrc(jNomeInterno.getText());
                        objRegAtend.setIdDepartamento(codigoDepartamentoPSI);
                        objRegAtend.setNomeDepartamento(nomeModuloPSICOLOGIA);
                        objRegAtend.setTipoAtemdimento(tipoAtendimentoAdm);
                        objRegAtend.setAtendido(atendido);
                        objRegAtend.setDataAtendimento(jDataLanc.getDate());
                        objRegAtend.setIdAtend(Integer.valueOf(jIdADM_NOVA.getText()));
                        objRegAtend.setQtdAtend(pQUANTIDADE_ATENDIDA);
                        //
                        objRegAtend.setUsuarioUp(nameUser);
                        objRegAtend.setDataUp(dataModFinal);
                        objRegAtend.setHorarioUp(horaMov);
                        controlRegAtend.alterarRegAtend(objRegAtend);
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        //GRAVAR NA TABELA DE ATENDIMENTO ATENDIMENTO_PSP_INTERNO_TV        
                        objRegAtend.setStatusAtendimento(status_ATENDIMENTO);
                        objRegAtend.setIdInternoCrc(Integer.valueOf(jIdInternoNovo.getText()));
                        objRegAtend.setNomeInternoCrc(jNomeInterno.getText());
                        objRegAtend.setIdDepartamento(codigoDepartamentoPSI);
                        objRegAtend.setNomeDepartamento(nomeModuloPSICOLOGIA);
                        objRegAtend.setConcluido(pATENDIMENTO_CONCLUIDO);
                        objRegAtend.setHorarioUp(horaMov);
                        objRegAtend.setIdAtend(Integer.valueOf(jIdADM_NOVA.getText()));
                        objRegAtend.setTipoAtemdimento(tipoAtendimentoAdm);
                        control_ATENDE.confirmarAtendimento(objRegAtend);
                        //CONFIRMA A REALIZAÇÃO ADMISSÃO DO INTERNO, IMPEDINDO QUE FAÇA OUTRA ADMISSÃO
                        pHABILITA_PSICOLOGIA = "Não";
                        objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIdInternoNovo.getText()));
                        objPortaEntrada.setNomeInternoCrc(jNomeInterno.getText());
                        objPortaEntrada.setHabPsi(pHABILITA_PSICOLOGIA);
                        control_PE.alterarPortaEntradaPsicologia(objPortaEntrada);
                        Salvar();
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                        int resposta = JOptionPane.showConfirmDialog(this, "Deseja iniciar tratamento ao interno agora?", "Confirmação",
                                JOptionPane.YES_NO_OPTION);
                        if (resposta == JOptionPane.YES_OPTION) {
                            mostraTelaTratamentoPSI();
                        }
                    }
                    if (acao == 2) {
                        // log de usuario
                        objAdmPsi.setUsuarioUp(nameUser);
                        objAdmPsi.setDataUp(dataModFinal);
                        objAdmPsi.setHoraUp(horaMov);
                        //
                        objAdmPsi.setIdInternoCrc(Integer.valueOf(jIdInternoNovo.getText()));
                        objAdmPsi.setNomeInterno(jNomeInterno.getText());
                        objAdmPsi.setIdPortaPSI(Integer.valueOf(jIdADM_NOVA.getText()));
                        control.alterarNovaAdmissaoPsi(objAdmPsi);
                        objAdmPsi.setIdLanc(Integer.valueOf(jIdADM_NOVA.getText()));
                        objAdmPsi.setDeptoPsicologico(deptoTecnico);
                        controle.alterarMovTec(objAdmPsi);
                        //CONFIRMA A REALIZAÇÃO ADMISSÃO DO INTERNO, IMPEDINDO QUE FAÇA OUTRA ADMISSÃO
                        pHABILITA_PSICOLOGIA = "Não";
                        objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIdInternoNovo.getText()));
                        objPortaEntrada.setNomeInternoCrc(jNomeInterno.getText());
                        objPortaEntrada.setHabPsi(pHABILITA_PSICOLOGIA);
                        control_PE.alterarPortaEntradaPsicologia(objPortaEntrada);
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        Salvar();
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
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
            conecta.executaSQL("SELECT * FROM PORTA_ENTRADA_PSICOLOGIA "
                    + "WHERE IdPortaPSI='" + jIdADM_NOVA.getText() + "'");
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

    private void jBtAuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtAuditoriaActionPerformed

    private void jBtArtigosParagrafosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtArtigosParagrafosActionPerformed
        // TODO add your handling code here:
        if (jIdInternoNovo.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Pesquise primeiro o interno para consultar o(s) artigo(s).");
        } else {
            mostrarTelaArtigos();
        }
    }//GEN-LAST:event_jBtArtigosParagrafosActionPerformed

    private void jBtLocalizacaoInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtLocalizacaoInternoActionPerformed
        // TODO add your handling code here:
        TelaConsultaLocalInternoPsicologia objLoca = new TelaConsultaLocalInternoPsicologia();
        TelaModuloPsicologia.jPainelPsicologia.add(objLoca);
        objLoca.show();
    }//GEN-LAST:event_jBtLocalizacaoInternoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (jIdInternoNovo.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Pesquise primeiro o interno para consultar a(s) visita(s).");
        } else {
            mostrarVisitasInternos();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jBtTratamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtTratamentoActionPerformed
        // TODO add your handling code here:
        if (jIdADM_NOVA.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "É necessário informar um registro de atendimento para iniciar ou terminar um tratamento.");
        } else {
            mostraTelaTratamentoPSI();
        }
    }//GEN-LAST:event_jBtTratamentoActionPerformed

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
            java.util.logging.Logger.getLogger(TelaNovaAdmissaoPSI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaNovaAdmissaoPSI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaNovaAdmissaoPSI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaNovaAdmissaoPSI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaNovaAdmissaoPSI dialog = new TelaNovaAdmissaoPSI(pNOVA_ADMISSAO_PSI, true);
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
    private javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtArtigosParagrafos;
    private javax.swing.JButton jBtAuditoria;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtExcluir;
    private javax.swing.JButton jBtFinalizar;
    private javax.swing.JButton jBtIDPesq;
    private javax.swing.JButton jBtLocalizacaoInterno;
    private javax.swing.JButton jBtLocalizarVisitaRol;
    private javax.swing.JButton jBtNovo;
    private javax.swing.JButton jBtPesqDatas;
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JButton jBtTratamento;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBoxAlcool;
    private javax.swing.JCheckBox jCheckBoxCigarro;
    private javax.swing.JCheckBox jCheckBoxCocaina;
    private javax.swing.JCheckBox jCheckBoxCola;
    private javax.swing.JCheckBox jCheckBoxCrack;
    private javax.swing.JCheckBox jCheckBoxMaconha;
    private javax.swing.JCheckBox jCheckBoxOutros;
    private javax.swing.JComboBox jComboBoxAcompanhaPSI;
    private javax.swing.JComboBox jComboBoxDepartamentoEncaminha;
    private javax.swing.JComboBox jComboBoxFamiliaPreso;
    private javax.swing.JComboBox jComboBoxHouveTentativaSuicidio;
    private javax.swing.JComboBox jComboBoxMedicamentoPSI;
    private javax.swing.JComboBox jComboBoxPresoAntes;
    private javax.swing.JComboBox jComboBoxRecebeVisitas;
    private javax.swing.JComboBox jComboBoxSituacaoTraumatica;
    private javax.swing.JComboBox jComboBoxTratamentoPSI;
    private javax.swing.JComboBox jComboBoxTratamentoSaude;
    private javax.swing.JComboBox jComboBoxUsaDrogras;
    private javax.swing.JTextField jComoFoiTentarSuicidio;
    private com.toedter.calendar.JDateChooser jDataEncaminhamento;
    private com.toedter.calendar.JDateChooser jDataFinal;
    private com.toedter.calendar.JDateChooser jDataInicial;
    private com.toedter.calendar.JDateChooser jDataLanc;
    private javax.swing.JTextArea jDrogas;
    private javax.swing.JTextArea jEncaminhamento;
    private javax.swing.JTextArea jFamiliares;
    public static javax.swing.JLabel jFotoInterno;
    private javax.swing.JTextArea jHistoricoCriminal;
    private javax.swing.JFormattedTextField jHoraAcompanha;
    private javax.swing.JTextField jIDPesq;
    public static javax.swing.JTextField jIdADM_NOVA;
    public static javax.swing.JTextField jIdADM_Principal;
    public static javax.swing.JTextField jIdInternoNovo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    public static javax.swing.JTextField jNomeInterno;
    private javax.swing.JTextField jOndeFazTratamento;
    private javax.swing.JTextField jOndePreso;
    private javax.swing.JTextField jOndeTentouSuicidio;
    private javax.swing.JTextField jOutrasDrogas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jPesqNomeInterno;
    private javax.swing.JTextField jPorQueSuicidio;
    private javax.swing.JTextField jPorqueUsaDrogas;
    private javax.swing.JTextField jPorqueUsaMedicamento;
    private javax.swing.JFormattedTextField jQualIdade;
    private javax.swing.JTextField jQualMedicamento;
    private javax.swing.JTextField jQualMedicamentoUtiliza;
    private javax.swing.JTextField jQualSituacaoTraumatica;
    private javax.swing.JTextField jQualTratamentoSaude;
    private javax.swing.JTextField jQuemFamiliaPreso;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextField jStatusLanc;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTabelaAdmissaoPsicologica;
    private javax.swing.JTextArea jTentativaSuicidio;
    private javax.swing.JTextArea jTranstornoMental;
    private javax.swing.JTextArea jTratamentoAntriores;
    private javax.swing.JTextArea jUsoMedicamentos;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void verificarPortaEntrada() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PORTA_ENTRADA "
                    + "WHERE IdInternoCrc='" + jIdInterno.getText() + "' "
                    + "AND PSPPsi='" + deptoTecnico + "' "
                    + "AND HabPsi='" + pHABILITA_PSICOLOGIA + "'");
            conecta.rs.first();
            pINTERNOCRC = conecta.rs.getString("IdInternoCrc");
            pDEPARTAMENTO = conecta.rs.getString("PSPPsi");
            pHABILITADO = conecta.rs.getString("HabPsi");
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
                    + "INNER JOIN ADMISSAOPSI "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ADMISSAOPSI.IdInternoCrc "
                    + "WHERE PRONTUARIOSCRC.SituacaoCrc='" + situacao + "' "
                    + "AND ADMISSAOPSI.IdInternoCrc='" + jIdInterno.getText() + " '"
                    + "OR PRONTUARIOSCRC.SituacaoCrc='" + sitRetorno + "' "
                    + "AND ADMISSAOPSI.IdInternoCrc='" + jIdInterno.getText() + "'");
            conecta.rs.first();
            jIdADM_Principal.setText(String.valueOf(conecta.rs.getInt("IdLanc")));
            // VARIÁVEL QUE NÃO DEIXA MUDAR O INTERNO SE EXISTIR ANAMNESES OU ATESTADO, DIETA E OUTROS.
            codInterno = conecta.rs.getString("IdInternoCrc");
            nomeInternoAnterior = conecta.rs.getString("NomeInternoCrc");
            jIdInternoNovo.setText(conecta.rs.getString("IdInternoCrc"));
            jNomeInterno.setText(conecta.rs.getString("NomeInternoCrc"));
            // Capturando foto
            caminho = conecta.rs.getString("FotoInternoCrc");
            if (caminho != null) {
                javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                jFotoInterno.setIcon(i);
                jFotoInterno.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoInterno.getWidth(), jFotoInterno.getHeight(), Image.SCALE_SMOOTH)));
            }
            // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
            byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrente"));
            if (imgBytes != null) {
                ImageIcon pic = null;
                pic = new ImageIcon(imgBytes);
                Image scaled = pic.getImage().getScaledInstance(jFotoInterno.getWidth(), jFotoInterno.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(scaled);
                jFotoInterno.setIcon(icon);
            }
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void procurarDepartamento() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM DEPARTAMENTOS "
                    + "WHERE NomeDepartamento='" + nomeModuloPSICOLOGIA + "'");
            conecta.rs.first();
            codigoDepartamento = conecta.rs.getInt("IdDepartamento");
            codigoDepartamentoPSI = conecta.rs.getInt("IdDepartamento");
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
            jIdADM_Principal.setText(jIdLanc.getText());
            // VARIÁVEL QUE NÃO DEIXA MUDAR O INTERNO SE EXISTIR ANAMNESES OU ATESTADO, DIETA E OUTROS.
            codInterno = conecta.rs.getString("IdInternoCrc");
            nomeInternoAnterior = conecta.rs.getString("NomeInternoCrc");
            jIdInternoNovo.setText(conecta.rs.getString("IdInternoCrc"));
            jNomeInterno.setText(conecta.rs.getString("NomeInternoCrc"));
            // Capturando foto
            caminho = conecta.rs.getString("FotoInternoCrc");
            if (caminho != null) {
                javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                jFotoInterno.setIcon(i);
                jFotoInterno.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoInterno.getWidth(), jFotoInterno.getHeight(), Image.SCALE_DEFAULT)));
            }
            // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
            byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrente"));
            if (imgBytes != null) {
                ImageIcon pic = null;
                pic = new ImageIcon(imgBytes);
                Image scaled = pic.getImage().getScaledInstance(jFotoInterno.getWidth(), jFotoInterno.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon icon = new ImageIcon(scaled);
                jFotoInterno.setIcon(icon);
            }
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void formatarCampos() {
        jPesqNomeInterno.setDocument(new LimiteDigitos(50));
        //
        jHistoricoCriminal.setLineWrap(true);
        jHistoricoCriminal.setWrapStyleWord(true);
        jDrogas.setLineWrap(true);
        jDrogas.setWrapStyleWord(true);
        //
        jTranstornoMental.setLineWrap(true);
        jTranstornoMental.setWrapStyleWord(true);
        //
        jEncaminhamento.setLineWrap(true);
        jEncaminhamento.setWrapStyleWord(true);
        //
        jTratamentoAntriores.setLineWrap(true);
        jTratamentoAntriores.setWrapStyleWord(true);
        //
        jTentativaSuicidio.setLineWrap(true);
        jTentativaSuicidio.setWrapStyleWord(true);
        //
        jUsoMedicamentos.setLineWrap(true);
        jUsoMedicamentos.setWrapStyleWord(true);
        //
        jFamiliares.setLineWrap(true);
        jFamiliares.setWrapStyleWord(true);
        // HISTORICO CRIMINAL       
        jQuemFamiliaPreso.setDocument(new LimiteDigitosAlfa(73));
        jOndePreso.setDocument(new LimiteDigitosAlfa(73));
        // DROGAS       
        jOutrasDrogas.setDocument(new LimiteDigitosAlfa(35));
        jQualIdade.setDocument(new LimiteDigitosSoNum(5));
        jPorqueUsaDrogas.setDocument(new LimiteDigitosAlfa(35));
        // TRANSTORNO MENTAL        
        jQualMedicamento.setDocument(new LimiteDigitosAlfa(35));
        // ENCAMINHAMENTOS 
        try {
            MaskFormatter hora = new MaskFormatter("##:##:##");
            jHoraAcompanha.setFormatterFactory(new DefaultFormatterFactory(hora));
        } catch (Exception e) {
        }
        // TRATAMENTOS ANTERIORES        
        jQualTratamentoSaude.setDocument(new LimiteDigitosAlfa(36));
        jOndeFazTratamento.setDocument(new LimiteDigitosAlfa(86));
        // TENTATIVA DE SUICIDIO       
        jQualSituacaoTraumatica.setDocument(new LimiteDigitosAlfa(30));
        jPorQueSuicidio.setDocument(new LimiteDigitosAlfa(46));
        jComoFoiTentarSuicidio.setDocument(new LimiteDigitosAlfa(29));
        jOndeTentouSuicidio.setDocument(new LimiteDigitosAlfa(46));
        // USO DE MEDICAMENTOS
        jQualMedicamentoUtiliza.setDocument(new LimiteDigitosAlfa(73));
        jPorqueUsaMedicamento.setDocument(new LimiteDigitosAlfa(73));
    }

    public void corCampos() {
        jIdADM_NOVA.setBackground(Color.white);
        jIdADM_Principal.setBackground(Color.white);
        jStatusLanc.setBackground(Color.white);
        jDataLanc.setBackground(Color.white);
        jIdInternoNovo.setBackground(Color.white);
        jNomeInterno.setBackground(Color.white);
        // HISTORICO CRIMINAL
        jComboBoxPresoAntes.setBackground(Color.white);
        jComboBoxFamiliaPreso.setBackground(Color.white);
        jQuemFamiliaPreso.setBackground(Color.white);
        jOndePreso.setBackground(Color.white);
        jHistoricoCriminal.setBackground(Color.white);
        // DROGAS       
        jOutrasDrogas.setBackground(Color.white);
        jQualIdade.setBackground(Color.white);
        jPorqueUsaDrogas.setBackground(Color.white);
        jDrogas.setBackground(Color.white);
        // TRANSTORNO MENTAL
        jComboBoxTratamentoPSI.setBackground(Color.white);
        jComboBoxMedicamentoPSI.setBackground(Color.white);
        jQualMedicamento.setBackground(Color.white);
        jComboBoxAcompanhaPSI.setBackground(Color.white);
        jTranstornoMental.setBackground(Color.white);
        // ENCAMINHAMENTOS
        jComboBoxDepartamentoEncaminha.setBackground(Color.white);
        jDataEncaminhamento.setBackground(Color.white);
        jHoraAcompanha.setBackground(Color.white);
        jEncaminhamento.setBackground(Color.white);
        // TRATAMENTOS ANTERIORES
        jComboBoxTratamentoSaude.setBackground(Color.white);
        jQualTratamentoSaude.setBackground(Color.white);
        jOndeFazTratamento.setBackground(Color.white);
        jTratamentoAntriores.setBackground(Color.white);
        // TENTATIVA DE SUICIDIO
        jComboBoxSituacaoTraumatica.setBackground(Color.white);
        jQualSituacaoTraumatica.setBackground(Color.white);
        jComboBoxHouveTentativaSuicidio.setBackground(Color.white);
        jPorQueSuicidio.setBackground(Color.white);
        jComoFoiTentarSuicidio.setBackground(Color.white);
        jOndeTentouSuicidio.setBackground(Color.white);
        jTentativaSuicidio.setBackground(Color.white);
        // USO DE MEDICAMENTOS
        jQualMedicamentoUtiliza.setBackground(Color.white);
        jPorqueUsaMedicamento.setBackground(Color.white);
        jUsoMedicamentos.setBackground(Color.white);
        // FAMILIARES
        jComboBoxRecebeVisitas.setBackground(Color.white);
        jFamiliares.setBackground(Color.white);
    }

    public void bloquearCampos() {
        jDataLanc.setEnabled(!true);
        // HISTORICO CRIMINAL
        jComboBoxPresoAntes.setEnabled(!true);
        jComboBoxFamiliaPreso.setEnabled(!true);
        jQuemFamiliaPreso.setEnabled(!true);
        jOndePreso.setEnabled(!true);
        jHistoricoCriminal.setEnabled(!true);
        // DROGAS
        jComboBoxUsaDrogras.setEnabled(!true);
        jCheckBoxAlcool.setEnabled(!true);
        jCheckBoxCigarro.setEnabled(!true);
        jCheckBoxMaconha.setEnabled(!true);
        jCheckBoxCrack.setEnabled(!true);
        jCheckBoxCocaina.setEnabled(!true);
        jCheckBoxCola.setEnabled(!true);
        jCheckBoxOutros.setEnabled(!true);
        jOutrasDrogas.setEnabled(!true);
        jQualIdade.setEnabled(!true);
        jPorqueUsaDrogas.setEnabled(!true);
        jDrogas.setEnabled(!true);
        // TRANSTORNO MENTAL
        jComboBoxTratamentoPSI.setEnabled(!true);
        jComboBoxMedicamentoPSI.setEnabled(!true);
        jQualMedicamento.setEnabled(!true);
        jComboBoxAcompanhaPSI.setEnabled(!true);
        jTranstornoMental.setEnabled(!true);
        // ENCAMINHAMENTOS
        jComboBoxDepartamentoEncaminha.setEnabled(!true);
        jDataEncaminhamento.setEnabled(!true);
        jHoraAcompanha.setEnabled(!true);
        jEncaminhamento.setEnabled(!true);
        // TRATAMENTOS ANTERIORES
        jComboBoxTratamentoSaude.setEnabled(!true);
        jQualTratamentoSaude.setEnabled(!true);
        jOndeFazTratamento.setEnabled(!true);
        jTratamentoAntriores.setEnabled(!true);
        // TENTATIVA DE SUICIDIO
        jComboBoxSituacaoTraumatica.setEnabled(!true);
        jQualSituacaoTraumatica.setEnabled(!true);
        jComboBoxHouveTentativaSuicidio.setEnabled(!true);
        jPorQueSuicidio.setEnabled(!true);
        jComoFoiTentarSuicidio.setEnabled(!true);
        jOndeTentouSuicidio.setEnabled(!true);
        jTentativaSuicidio.setEnabled(!true);
        // USO DE MEDICAMENTOS
        jQualMedicamentoUtiliza.setEnabled(!true);
        jPorqueUsaMedicamento.setEnabled(!true);
        jUsoMedicamentos.setEnabled(!true);
        // FAMILIARES
        jComboBoxRecebeVisitas.setEnabled(!true);
        jFamiliares.setEnabled(!true);
    }

    public void limparCampos() {
        jIdADM_NOVA.setText("");
        jStatusLanc.setText("");
        jDataLanc.setDate(null);
        jIdInternoNovo.setText("");
        jNomeInterno.setText("");
        jFotoInterno.setIcon(null);
        // HISTORICO CRIMINAL
        jComboBoxPresoAntes.setSelectedItem("Não");
        jComboBoxFamiliaPreso.setSelectedItem("Não");
        jQuemFamiliaPreso.setText("");
        jOndePreso.setText("");
        jHistoricoCriminal.setText("");
        // DROGAS
        jComboBoxUsaDrogras.setSelectedItem("Não");
        jCheckBoxAlcool.setSelected(!true);
        jCheckBoxCigarro.setSelected(!true);
        jCheckBoxMaconha.setSelected(!true);
        jCheckBoxCrack.setSelected(!true);
        jCheckBoxCocaina.setSelected(!true);
        jCheckBoxCola.setSelected(!true);
        jCheckBoxOutros.setEnabled(true);
        jOutrasDrogas.setText("");
        jQualIdade.setText("0");
        jPorqueUsaDrogas.setText("");
        jDrogas.setText("");
        // TRANSTORNO MENTAL
        jComboBoxTratamentoPSI.setSelectedItem("Não");
        jComboBoxMedicamentoPSI.setSelectedItem("Não");
        jQualMedicamento.setText("");
        jComboBoxAcompanhaPSI.setSelectedItem("Psicológico");
        jTranstornoMental.setText("");
        // ENCAMINHAMENTOS
        jComboBoxDepartamentoEncaminha.setSelectedItem("Selecione...");
        jDataEncaminhamento.setDate(null);
        jHoraAcompanha.setText(jHoraSistema.getText());
        jEncaminhamento.setText("");
        // TRATAMENTOS ANTERIORES
        jComboBoxTratamentoSaude.setSelectedItem("Não");
        jQualTratamentoSaude.setText("");
        jOndeFazTratamento.setText("");
        jTratamentoAntriores.setText("");
        // TENTATIVA DE SUICIDIO
        jComboBoxSituacaoTraumatica.setSelectedItem("Não");
        jQualSituacaoTraumatica.setText("");
        jComboBoxHouveTentativaSuicidio.setSelectedItem("Não");
        jPorQueSuicidio.setText("");
        jComoFoiTentarSuicidio.setText("");
        jOndeTentouSuicidio.setText("");
        jTentativaSuicidio.setText("");
        // USO DE MEDICAMENTOS
        jQualMedicamentoUtiliza.setText("");
        jPorqueUsaMedicamento.setText("");
        jUsoMedicamentos.setText("");
        // FAMILIARES
        jComboBoxRecebeVisitas.setSelectedItem("Não");
        jFamiliares.setText("");
    }

    public void abrirCampos() {
        // HISTORICO CRIMINAL
        jComboBoxPresoAntes.setEnabled(true);
        jComboBoxFamiliaPreso.setEnabled(true);
        jQuemFamiliaPreso.setEnabled(true);
        jOndePreso.setEnabled(true);
        jHistoricoCriminal.setEnabled(true);
        // DROGAS
        jComboBoxUsaDrogras.setEnabled(true);
        jCheckBoxAlcool.setEnabled(true);
        jCheckBoxCigarro.setEnabled(true);
        jCheckBoxMaconha.setEnabled(true);
        jCheckBoxCrack.setEnabled(true);
        jCheckBoxCocaina.setEnabled(true);
        jCheckBoxCola.setEnabled(true);
        jCheckBoxOutros.setEnabled(true);
        jOutrasDrogas.setEnabled(true);
        jQualIdade.setEnabled(true);
        jPorqueUsaDrogas.setEnabled(true);
        jDrogas.setEnabled(true);
        // TRANSTORNO MENTAL
        jComboBoxTratamentoPSI.setEnabled(true);
        jComboBoxMedicamentoPSI.setEnabled(true);
        jQualMedicamento.setEnabled(true);
        jComboBoxAcompanhaPSI.setEnabled(true);
        jTranstornoMental.setEnabled(true);
        // ENCAMINHAMENTOS
        jComboBoxDepartamentoEncaminha.setEnabled(true);
        jDataEncaminhamento.setEnabled(true);
        jHoraAcompanha.setEnabled(true);
        jEncaminhamento.setEnabled(true);
        // TRATAMENTOS ANTERIORES
        jComboBoxTratamentoSaude.setEnabled(true);
        jQualTratamentoSaude.setEnabled(true);
        jOndeFazTratamento.setEnabled(true);
        jTratamentoAntriores.setEnabled(true);
        // TENTATIVA DE SUICIDIO
        jComboBoxSituacaoTraumatica.setEnabled(true);
        jQualSituacaoTraumatica.setEnabled(true);
        jComboBoxHouveTentativaSuicidio.setEnabled(true);
        jPorQueSuicidio.setEnabled(true);
        jComoFoiTentarSuicidio.setEnabled(true);
        jOndeTentouSuicidio.setEnabled(true);
        jTentativaSuicidio.setEnabled(true);
        // USO DE MEDICAMENTOS
        jQualMedicamentoUtiliza.setEnabled(true);
        jPorqueUsaMedicamento.setEnabled(true);
        jUsoMedicamentos.setEnabled(true);
        // FAMILIARES
        jComboBoxRecebeVisitas.setEnabled(true);
        jFamiliares.setEnabled(true);
    }

    public void bloquearBotoes() {
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
    }

    public void Novo() {
        limparCampos();
        abrirCampos();
        bloquearBotoes();
        jStatusLanc.setText("ABERTO");
        jDataLanc.setCalendar(Calendar.getInstance());
        //
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
    }

    public void Alterar() {
        abrirCampos();
        bloquearBotoes();
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
    }

    public void Excluir() {
        limparCampos();
        bloquearCampos();
        bloquearBotoes();
        jBtNovo.setEnabled(true);
    }

    public void Salvar() {
        bloquearCampos();
        bloquearBotoes();
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
    }

    public void Cancelar() {
        if (jIdADM_NOVA.getText().equals("")) {
            limparCampos();
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

    public void buscarID() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PORTA_ENTRADA_PSICOLOGIA");
            conecta.rs.last();
            jIdADM_NOVA.setText(conecta.rs.getString("IdPortaPSI"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível pegar o ID do lançamento");
        }
    }

    public void Finalizar() {
        statusMov = "Finalizou";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        String statusLanc = "FINALIZADO";
        JOptionPane.showMessageDialog(rootPane, "Se esse Lançamento for finaliza,\nvocê não poderá mais excluir ou alterar.");
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente finalizar assim mesmo o lançamento selecionado?", "Confirmação",
                JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            objAdmPsi.setStatusLanc(statusLanc);
            objAdmPsi.setIdLanc(Integer.parseInt(jIdADM_NOVA.getText()));
            control.finalizarNovaAdmissaoPsi(objAdmPsi);
            controle.finalizarMovTec(objAdmPsi);
            objLog();
            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
            jStatusLanc.setText("FINALIZADO");
            //            
            bloquearCampos();
            bloquearBotoes();
            //
            jBtNovo.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            JOptionPane.showMessageDialog(rootPane, "Registro FINALIZADO com sucesso !!!");
        }
    }

    public void preencherComboBoxDepartamento() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM DEPARTAMENTOS ORDER BY NomeDepartamento");
            conecta.rs.first();
            do {
                jComboBoxDepartamentoEncaminha.addItem(conecta.rs.getString("NomeDepartamento"));
            } while (conecta.rs.next());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos!!!\nERRO: " + e);
        }
        conecta.desconecta();
    }

    public void preencherAdmissoPsicologia(String sql) {
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
                dados.add(new Object[]{conecta.rs.getInt("IdPortaPSI"), dataEntrada, conecta.rs.getString("StatusLanc"), conecta.rs.getString("NomeInternoCrc"), conecta.rs.getString("HistoricoCriminal")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaAdmissaoPsicologica.setModel(modelo);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(0).setResizable(false);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(1).setResizable(false);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(2).setResizable(false);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(3).setPreferredWidth(330);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(3).setResizable(false);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(4).setPreferredWidth(330);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(4).setResizable(false);
        jTabelaAdmissaoPsicologica.getTableHeader().setReorderingAllowed(false);
        jTabelaAdmissaoPsicologica.setAutoResizeMode(jTabelaAdmissaoPsicologica.AUTO_RESIZE_OFF);
        jTabelaAdmissaoPsicologica.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabela();
        conecta.desconecta();
    }

    public void alinharCamposTabela() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }

    public void limparTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Nome Completo do Interno", "Histórico Criminal"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaAdmissaoPsicologica.setModel(modelo);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(0).setResizable(false);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(1).setResizable(false);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(2).setResizable(false);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(3).setPreferredWidth(330);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(3).setResizable(false);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(4).setPreferredWidth(330);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(4).setResizable(false);
        jTabelaAdmissaoPsicologica.getTableHeader().setReorderingAllowed(false);
        jTabelaAdmissaoPsicologica.setAutoResizeMode(jTabelaAdmissaoPsicologica.AUTO_RESIZE_OFF);
        jTabelaAdmissaoPsicologica.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jIdADM_NOVA.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void buscarAcessoUsuario(String nomeTelaAcesso) {
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

    public void verificarRegistroBiometria() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PARAMETROSCRC");
            conecta.rs.first();
            pHabilitaPsicologia = conecta.rs.getString("AtendimentoBioPSI");
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
                    + "WHERE IdInternoCrc='" + jIdInternoNovo.getText() + "' "
                    + "AND Atendido='" + opcao + "'");
            conecta.rs.first();
            codigoInternoAtend = conecta.rs.getString("IdInternoCrc");
            codigoDepartamentoPSI = conecta.rs.getInt("IdDepartamento");
            atendido = conecta.rs.getString("Atendido");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
