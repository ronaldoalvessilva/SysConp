/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleAdminssaoPsicologia;
import gestor.Controle.ControleConfirmacaoAtendimento;
import gestor.Controle.ControleEvolucaoPsicologica;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControleMovPsicologia;
import gestor.Controle.ControleParecerPsicologico;
import gestor.Controle.ControleRegistroAtendimentoInternoBio;
import gestor.Dao.ConexaoBancoDados;
import Utilitarios.LimiteDigitos;
import Utilitarios.LimiteDigitosAlfa;
import Utilitarios.LimiteDigitosSoNum;
import Utilitarios.ModeloTabela;
import gestor.Controle.ControleMovPsicologiaEvolucao;
import gestor.Controle.ControlePortaEntrada;
import gestor.Modelo.AdmissaoPsicologica;
import gestor.Modelo.EvolucaoPsicologica;
import gestor.Modelo.LogSistema;
import gestor.Modelo.PortaEntrada;
import gestor.Modelo.RegistroAtendimentoInternos;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloPsicologia.pQUANTIDADE_ATENDIDA;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import static gestor.Visao.TelaModuloPsicologia.codAbrirPSI;
import static gestor.Visao.TelaModuloPsicologia.codAlterarPSI;
import static gestor.Visao.TelaModuloPsicologia.codExcluirPSI;
import static gestor.Visao.TelaModuloPsicologia.codGravarPSI;
import static gestor.Visao.TelaModuloPsicologia.codIncluirPSI;
import static gestor.Visao.TelaModuloPsicologia.codUserAcessoPSI;
import static gestor.Visao.TelaModuloPsicologia.codigoUserPSI;
import static gestor.Visao.TelaModuloPsicologia.nomeGrupoPSI;
import static gestor.Visao.TelaModuloPsicologia.nomeTelaPSI;
import static gestor.Visao.TelaModuloPsicologia.codConsultarPSI;
import static gestor.Visao.TelaModuloPsicologia.codigoUserGroupPSI;
import static gestor.Visao.TelaModuloPsicologia.codigoGrupoPSI;
import static gestor.Visao.TelaModuloPsicologia.nomeModuloPSICOLOGIA;
import static gestor.Visao.TelaModuloPsicologia.telaMovimentacaoAdmIntManuPSI;
import static gestor.Visao.TelaModuloPsicologia.telaMovimentacaoEvolIntPSI;
import static gestor.Visao.TelaModuloPsicologia.telaMovimentacaoPareIntPSI;
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
 * @author user
 */
public class TelaAdmissaoPsicologica extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AdmissaoPsicologica objAdmPsi = new AdmissaoPsicologica();
    ControleAdminssaoPsicologia control = new ControleAdminssaoPsicologia();
    //
    ControleMovPsicologia controle = new ControleMovPsicologia();
    ControleMovPsicologiaEvolucao controleEvo = new ControleMovPsicologiaEvolucao();
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
    String pCODIGO_INTERNO = "";
    //EVOLUÇÃO DA ADMISSAO
    String admEvolucao = "Sim";
    //RESPONDE COMO NÃO PARA NÃO FAZER OUTRA ADMISSÃO QUANDO O INTERNO CHEGAR PELA PRIMEIRA VEZ
    String pHABILITA_PSICOLOGIA = "Não";

    /**
     * Creates new form TelaAdmissaoPsicologica
     */
    public static TelaArtigosParagrafosInternoPSI telaArtigosParagrafos;
    public static TelaConsultaVisitasInternosPSI telaVisitasInternosPSI;
    public static AgendamentoAtendimentoPsicologico agendaAtendimento;
    public static TelaTratamentoPsicologico TP;
    public static TelaNovaAdmissaoPSI pTELA_NOVA_ADMISSAO;

    public TelaAdmissaoPsicologica() {
        super();
        initComponents();
        setResizable(false);
        formatarCampos();
        corCampos();
    }

    public void mostrarTelaArtigos() {
        telaArtigosParagrafos = new TelaArtigosParagrafosInternoPSI(this, true);
        telaArtigosParagrafos.setVisible(true);
    }

    public void mostrarVisitasInternos() {
        telaVisitasInternosPSI = new TelaConsultaVisitasInternosPSI(this, true);
        telaVisitasInternosPSI.setVisible(true);
    }

    public void mostrarAgendaAtendimento() {
        agendaAtendimento = new AgendamentoAtendimentoPsicologico(this, true);
        agendaAtendimento.setVisible(true);
    }

    public void mostraTelaTratamentoPSI() {
        TP = new TelaTratamentoPsicologico(this, true);
        TP.setVisible(true);
    }

    public void mostrarTelaNovaAdm() {
        pTELA_NOVA_ADMISSAO = new TelaNovaAdmissaoPSI(this, true);
        pTELA_NOVA_ADMISSAO.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
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
        jIdInterno = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jNomeInterno = new javax.swing.JTextField();
        jBtPesqInterno = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jIdLanc = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jStatusLanc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jDataLanc = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jDataNascimento = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jSituacaoUnidade = new javax.swing.JTextField();
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
        jTextoEvolucaoAdmissao = new javax.swing.JTextArea();
        jComboBoxDepartamentoEncaminha = new javax.swing.JComboBox();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jDataEncaminhamento = new com.toedter.calendar.JDateChooser();
        jHoraAcompanha = new javax.swing.JFormattedTextField();
        jLabel50 = new javax.swing.JLabel();
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
        jPanel20 = new javax.swing.JPanel();
        jBtNovo = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jBtAuditoria = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jBtFinalizar = new javax.swing.JButton();
        jBtImpressao = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jFotoInterno = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jBtArtigosParagrafos = new javax.swing.JButton();
        jBtLocalizacaoInterno = new javax.swing.JButton();
        jBtVisitasInterno = new javax.swing.JButton();
        jBtTratamento = new javax.swing.JButton();
        jBtNovaAdmissao = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jParecerPsicologico = new javax.swing.JTextArea();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTabelaParecerPsicologico = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jCodigoParecer = new javax.swing.JTextField();
        jNomeInternoParecer = new javax.swing.JTextField();
        jDataParecer = new com.toedter.calendar.JDateChooser();
        jPanel25 = new javax.swing.JPanel();
        jBtNovoParecer = new javax.swing.JButton();
        jBtAlterarParecer = new javax.swing.JButton();
        jBtExcluirParecer = new javax.swing.JButton();
        jBtSalvarParecer = new javax.swing.JButton();
        jBtCancelarParecer = new javax.swing.JButton();
        jBtAuditoriaParecer = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTabelaEvolucaoPsicologia = new javax.swing.JTable();
        jPanel18 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jIdEvolucao = new javax.swing.JTextField();
        jDataEvolucao = new com.toedter.calendar.JDateChooser();
        jComboBoxStatusEvolucao = new javax.swing.JComboBox();
        jPanel19 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jEvolucao = new javax.swing.JTextArea();
        jPanel17 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jComboBoxEncaminharSetorEvo = new javax.swing.JComboBox();
        jLabel48 = new javax.swing.JLabel();
        jDataEncaminhamentoEvo = new com.toedter.calendar.JDateChooser();
        jHoraEnvioEvo = new javax.swing.JFormattedTextField();
        jLabel49 = new javax.swing.JLabel();
        jBtNovaEvolucao = new javax.swing.JButton();
        jBtAlterarEvolucao = new javax.swing.JButton();
        jBtExcluirEvolucao = new javax.swing.JButton();
        jBtSalvarEvolucao = new javax.swing.JButton();
        jBtCancelarEvolucao = new javax.swing.JButton();
        jBtAgendamentoAtendimento = new javax.swing.JButton();
        jBtAuditoriaEvolucao = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();

        jLabel6.setText("jLabel6");

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Admissão Psicologica {PSI} :::...");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

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
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jIDPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtIDPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqDatas, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBox1)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel7)
                    .addComponent(jIDPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtIDPesq)
                    .addComponent(jLabel11)
                    .addComponent(jDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqDatas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jCheckBox1)
                    .addComponent(jButton10)
                    .addComponent(jPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap(17, Short.MAX_VALUE))
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
            jTabelaAdmissaoPsicologica.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaAdmissaoPsicologica.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaAdmissaoPsicologica.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaAdmissaoPsicologica.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaAdmissaoPsicologica.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaAdmissaoPsicologica.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaAdmissaoPsicologica.getColumnModel().getColumn(3).setMinWidth(335);
            jTabelaAdmissaoPsicologica.getColumnModel().getColumn(3).setMaxWidth(335);
            jTabelaAdmissaoPsicologica.getColumnModel().getColumn(4).setMinWidth(335);
            jTabelaAdmissaoPsicologica.getColumnModel().getColumn(4).setMaxWidth(335);
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
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane10))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("Listagem", jPanel1);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Interno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Código");

        jIdInterno.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdInterno.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Nome Completo do Interno");

        jNomeInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInterno.setEnabled(false);

        jBtPesqInterno.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtPesqInterno.setForeground(new java.awt.Color(0, 204, 0));
        jBtPesqInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqInterno.setToolTipText("Pesquisar Interno");
        jBtPesqInterno.setContentAreaFilled(false);
        jBtPesqInterno.setEnabled(false);
        jBtPesqInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqInternoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código");

        jIdLanc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdLanc.setEnabled(false);

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

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Dt. Nascimento");

        jDataNascimento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataNascimento.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Situação na Unidade");

        jSituacaoUnidade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jSituacaoUnidade.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jIdInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 79, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jSituacaoUnidade)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addComponent(jNomeInterno)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jIdLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(0, 198, Short.MAX_VALUE))
                                    .addComponent(jStatusLanc))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDataLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)))
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jIdInterno, jIdLanc});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIdLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jStatusLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jSituacaoUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqInterno)
                    .addComponent(jDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jHistoricoCriminal.setColumns(20);
        jHistoricoCriminal.setRows(5);
        jHistoricoCriminal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHistoricoCriminal.setEnabled(false);
        jScrollPane1.setViewportView(jHistoricoCriminal);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Preso antes?");
        jLabel16.setToolTipText("Já foi preso antes?");

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
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel16))
                                    .addComponent(jLabel21))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jComboBoxPresoAntes, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxFamiliaPreso, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jQuemFamiliaPreso)))
                            .addComponent(jScrollPane1)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jOndePreso)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jComboBoxPresoAntes, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jComboBoxFamiliaPreso, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jQuemFamiliaPreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGap(4, 4, 4)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel18)
                    .addComponent(jOndePreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxUsaDrogras, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBoxAlcool)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBoxCigarro))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jQualIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel23))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jCheckBoxMaconha)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBoxCrack)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBoxCocaina)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBoxCola)
                                .addGap(18, 18, 18)
                                .addComponent(jCheckBoxOutros)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jOutrasDrogas, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPorqueUsaDrogas, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jOutrasDrogas, jPorqueUsaDrogas});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jComboBoxUsaDrogras, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(jCheckBoxAlcool)
                    .addComponent(jCheckBoxCigarro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxMaconha)
                    .addComponent(jCheckBoxCrack)
                    .addComponent(jCheckBoxCocaina)
                    .addComponent(jCheckBoxCola)
                    .addComponent(jCheckBoxOutros)
                    .addComponent(jOutrasDrogas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jQualIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(jPorqueUsaDrogas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel26))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jComboBoxTratamentoPSI, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxMedicamentoPSI, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jQualMedicamento)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxAcompanhaPSI, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jComboBoxTratamentoPSI, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(jComboBoxMedicamentoPSI, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jQualMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel27)
                    .addComponent(jComboBoxAcompanhaPSI, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Transtorno Mental", jPanel7);

        jTextoEvolucaoAdmissao.setColumns(20);
        jTextoEvolucaoAdmissao.setRows(5);
        jTextoEvolucaoAdmissao.setText("[DIGITE AQUI O TEXTO DA EVOLUÇÃO DA ADMISSÃO...]");
        jTextoEvolucaoAdmissao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextoEvolucaoAdmissao.setEnabled(false);
        jScrollPane2.setViewportView(jTextoEvolucaoAdmissao);

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

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(204, 0, 0));
        jLabel50.setText("Texto da Evolução da Admissão");

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
                            .addComponent(jHoraAcompanha, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(96, 96, 96))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel50)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(jLabel29))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jHoraAcompanha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDataEncaminhamento, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxDepartamentoEncaminha, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel30)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel50)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
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
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxTratamentoSaude, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jQualTratamentoSaude))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jOndeFazTratamento)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jQualTratamentoSaude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32)
                    .addComponent(jComboBoxTratamentoSaude, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jOndeFazTratamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6)
                .addContainerGap())
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
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxSituacaoTraumatica, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jQualSituacaoTraumatica, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel38)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComoFoiTentarSuicidio))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel36)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxHouveTentativaSuicidio, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPorQueSuicidio)
                            .addComponent(jOndeTentouSuicidio))))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel34)
                    .addComponent(jComboBoxSituacaoTraumatica, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35)
                    .addComponent(jQualSituacaoTraumatica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxHouveTentativaSuicidio, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37)
                    .addComponent(jPorQueSuicidio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(jComoFoiTentarSuicidio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39)
                    .addComponent(jOndeTentouSuicidio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel36)
                .addGap(115, 115, 115))
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
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
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
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                .addContainerGap())
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
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
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
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Familiares", jPanel14);

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

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

        jBtAuditoria.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtAuditoria.setForeground(new java.awt.Color(0, 0, 255));
        jBtAuditoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoria.setToolTipText("Auditoria");
        jBtAuditoria.setContentAreaFilled(false);
        jBtAuditoria.setEnabled(false);
        jBtAuditoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addComponent(jBtNovo)
                .addGap(0, 0, 0)
                .addComponent(jBtAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelar)
                .addGap(42, 42, 42)
                .addComponent(jBtFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtImpressao, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtSair)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtNovo)
                    .addComponent(jBtAlterar)
                    .addComponent(jBtExcluir)
                    .addComponent(jBtSalvar)
                    .addComponent(jBtCancelar)
                    .addComponent(jBtFinalizar)
                    .addComponent(jBtImpressao)
                    .addComponent(jBtSair)
                    .addComponent(jBtAuditoria))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel20Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterar, jBtCancelar, jBtExcluir, jBtNovo, jBtSair, jBtSalvar});

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Foto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

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

        jBtVisitasInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/user-group-forum-icone-3716-16.png"))); // NOI18N
        jBtVisitasInterno.setToolTipText("Visitas de Internos");
        jBtVisitasInterno.setContentAreaFilled(false);
        jBtVisitasInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtVisitasInternoActionPerformed(evt);
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

        jBtNovaAdmissao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/290718163923_16.png"))); // NOI18N
        jBtNovaAdmissao.setContentAreaFilled(false);
        jBtNovaAdmissao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovaAdmissaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtArtigosParagrafos, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtLocalizacaoInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtVisitasInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtNovaAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(jBtTratamento, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jBtTratamento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtArtigosParagrafos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtLocalizacaoInterno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtVisitasInterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtNovaAdmissao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
        );

        jTabbedPane1.addTab("Admissão", jPanel2);

        jParecerPsicologico.setColumns(20);
        jParecerPsicologico.setRows(5);
        jParecerPsicologico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jParecerPsicologico.setEnabled(false);
        jScrollPane5.setViewportView(jParecerPsicologico);

        jTabelaParecerPsicologico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaParecerPsicologico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data", "Nome do Interno", "Parecer Psicológico"
            }
        ));
        jTabelaParecerPsicologico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaParecerPsicologicoMouseClicked(evt);
            }
        });
        jScrollPane13.setViewportView(jTabelaParecerPsicologico);
        if (jTabelaParecerPsicologico.getColumnModel().getColumnCount() > 0) {
            jTabelaParecerPsicologico.getColumnModel().getColumn(0).setMinWidth(60);
            jTabelaParecerPsicologico.getColumnModel().getColumn(0).setMaxWidth(60);
            jTabelaParecerPsicologico.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaParecerPsicologico.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaParecerPsicologico.getColumnModel().getColumn(2).setMinWidth(300);
            jTabelaParecerPsicologico.getColumnModel().getColumn(2).setMaxWidth(300);
            jTabelaParecerPsicologico.getColumnModel().getColumn(3).setMinWidth(200);
            jTabelaParecerPsicologico.getColumnModel().getColumn(3).setMaxWidth(200);
        }

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel45.setText("Código");

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel46.setText("Data");

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel47.setText("Nome Completo do Interno");

        jCodigoParecer.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodigoParecer.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCodigoParecer.setEnabled(false);

        jNomeInternoParecer.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoParecer.setEnabled(false);

        jDataParecer.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataParecer.setEnabled(false);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel45)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel46))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jCodigoParecer, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataParecer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel47)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jNomeInternoParecer))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel47)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel45)
                        .addComponent(jLabel46)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jCodigoParecer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataParecer, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNomeInternoParecer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel25.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtNovoParecer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_white_star.png"))); // NOI18N
        jBtNovoParecer.setToolTipText("Novo Parecer Psicológico");
        jBtNovoParecer.setEnabled(false);
        jBtNovoParecer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoParecerActionPerformed(evt);
            }
        });

        jBtAlterarParecer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarParecer.setToolTipText("Alterar Parecer Psicológico");
        jBtAlterarParecer.setEnabled(false);
        jBtAlterarParecer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarParecerActionPerformed(evt);
            }
        });

        jBtExcluirParecer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirParecer.setToolTipText("Excluir Parecer Psicológico");
        jBtExcluirParecer.setEnabled(false);
        jBtExcluirParecer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirParecerActionPerformed(evt);
            }
        });

        jBtSalvarParecer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarParecer.setToolTipText("Gravar Parecer Psicológico");
        jBtSalvarParecer.setEnabled(false);
        jBtSalvarParecer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarParecerActionPerformed(evt);
            }
        });

        jBtCancelarParecer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarParecer.setToolTipText("Cancelar Parecer Psicológico");
        jBtCancelarParecer.setEnabled(false);
        jBtCancelarParecer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarParecerActionPerformed(evt);
            }
        });

        jBtAuditoriaParecer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaParecer.setToolTipText("Auditoria");
        jBtAuditoriaParecer.setContentAreaFilled(false);
        jBtAuditoriaParecer.setEnabled(false);
        jBtAuditoriaParecer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaParecerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtNovoParecer, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtAlterarParecer, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtExcluirParecer, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtSalvarParecer, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtCancelarParecer, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaParecer, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel25Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterarParecer, jBtCancelarParecer, jBtExcluirParecer, jBtNovoParecer, jBtSalvarParecer});

        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtNovoParecer, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtAlterarParecer)
                    .addComponent(jBtExcluirParecer)
                    .addComponent(jBtSalvarParecer)
                    .addComponent(jBtCancelarParecer)
                    .addComponent(jBtAuditoriaParecer))
                .addGap(3, 3, 3))
        );

        jPanel25Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterarParecer, jBtCancelarParecer, jBtExcluirParecer, jBtNovoParecer, jBtSalvarParecer});

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
                    .addComponent(jScrollPane13)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Parecer Psicológico", jPanel10);

        jTabelaEvolucaoPsicologia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaEvolucaoPsicologia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data", "Status", "Evolução"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabelaEvolucaoPsicologia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaEvolucaoPsicologiaMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(jTabelaEvolucaoPsicologia);
        if (jTabelaEvolucaoPsicologia.getColumnModel().getColumnCount() > 0) {
            jTabelaEvolucaoPsicologia.getColumnModel().getColumn(0).setMinWidth(60);
            jTabelaEvolucaoPsicologia.getColumnModel().getColumn(0).setMaxWidth(60);
            jTabelaEvolucaoPsicologia.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaEvolucaoPsicologia.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaEvolucaoPsicologia.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaEvolucaoPsicologia.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaEvolucaoPsicologia.getColumnModel().getColumn(3).setMinWidth(380);
            jTabelaEvolucaoPsicologia.getColumnModel().getColumn(3).setMaxWidth(380);
        }

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Código:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(153, 0, 0));
        jLabel14.setText("T. Tratamento:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Data Evolução:");

        jIdEvolucao.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdEvolucao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdEvolucao.setEnabled(false);

        jDataEvolucao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataEvolucao.setEnabled(false);

        jComboBoxStatusEvolucao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxStatusEvolucao.setForeground(new java.awt.Color(0, 0, 255));
        jComboBoxStatusEvolucao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Sem Tratamento", "Em Andamento", "Concluído" }));
        jComboBoxStatusEvolucao.setToolTipText("Tipo de Tratamento");
        jComboBoxStatusEvolucao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxStatusEvolucao.setEnabled(false);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jIdEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxStatusEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDataEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jDataEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxStatusEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Evolução", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jEvolucao.setColumns(20);
        jEvolucao.setRows(5);
        jEvolucao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jEvolucao.setEnabled(false);
        jScrollPane12.setViewportView(jEvolucao);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane12)
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
        );

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel44.setText("Qual Setor foi Encamihado? ");

        jComboBoxEncaminharSetorEvo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxEncaminharSetorEvo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione..." }));
        jComboBoxEncaminharSetorEvo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxEncaminharSetorEvo.setEnabled(false);

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel48.setText("Data");

        jDataEncaminhamentoEvo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataEncaminhamentoEvo.setEnabled(false);

        jHoraEnvioEvo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHoraEnvioEvo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));
        jHoraEnvioEvo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jHoraEnvioEvo.setEnabled(false);

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel49.setText("Horário");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxEncaminharSetorEvo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDataEncaminhamentoEvo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jHoraEnvioEvo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel17Layout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addComponent(jLabel44)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 247, Short.MAX_VALUE)
                    .addComponent(jLabel48)
                    .addGap(74, 74, 74)
                    .addComponent(jLabel49)
                    .addGap(25, 25, 25)))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxEncaminharSetorEvo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataEncaminhamentoEvo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jHoraEnvioEvo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel17Layout.createSequentialGroup()
                    .addGap(4, 4, 4)
                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel49)
                        .addComponent(jLabel48)
                        .addComponent(jLabel44))
                    .addContainerGap(36, Short.MAX_VALUE)))
        );

        jBtNovaEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovaEvolucao.setToolTipText("Novo");
        jBtNovaEvolucao.setEnabled(false);
        jBtNovaEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovaEvolucaoActionPerformed(evt);
            }
        });

        jBtAlterarEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarEvolucao.setToolTipText("Alterar");
        jBtAlterarEvolucao.setEnabled(false);
        jBtAlterarEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarEvolucaoActionPerformed(evt);
            }
        });

        jBtExcluirEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirEvolucao.setToolTipText("Excluir");
        jBtExcluirEvolucao.setEnabled(false);
        jBtExcluirEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirEvolucaoActionPerformed(evt);
            }
        });

        jBtSalvarEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarEvolucao.setToolTipText("Gravar");
        jBtSalvarEvolucao.setEnabled(false);
        jBtSalvarEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarEvolucaoActionPerformed(evt);
            }
        });

        jBtCancelarEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarEvolucao.setToolTipText("Cancelar");
        jBtCancelarEvolucao.setEnabled(false);
        jBtCancelarEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarEvolucaoActionPerformed(evt);
            }
        });

        jBtAgendamentoAtendimento.setForeground(new java.awt.Color(255, 0, 0));
        jBtAgendamentoAtendimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/composer-preferences-icone-5121-16.png"))); // NOI18N
        jBtAgendamentoAtendimento.setText("Agendar");
        jBtAgendamentoAtendimento.setToolTipText("Agenda Atendimento Psicologico");
        jBtAgendamentoAtendimento.setEnabled(false);
        jBtAgendamentoAtendimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAgendamentoAtendimentoActionPerformed(evt);
            }
        });

        jBtAuditoriaEvolucao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtAuditoriaEvolucao.setForeground(new java.awt.Color(0, 0, 255));
        jBtAuditoriaEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaEvolucao.setToolTipText("Auditoria");
        jBtAuditoriaEvolucao.setContentAreaFilled(false);
        jBtAuditoriaEvolucao.setEnabled(false);
        jBtAuditoriaEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaEvolucaoActionPerformed(evt);
            }
        });

        jButton2.setForeground(new java.awt.Color(0, 102, 0));
        jButton2.setText("Tratamento");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane11)
                    .addComponent(jPanel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jBtNovaEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtAlterarEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtExcluirEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSalvarEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtCancelarEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtAgendamentoAtendimento)
                        .addGap(48, 48, 48)
                        .addComponent(jBtAuditoriaEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterarEvolucao, jBtCancelarEvolucao, jBtExcluirEvolucao, jBtNovaEvolucao, jBtSalvarEvolucao});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtAuditoriaEvolucao)
                    .addComponent(jBtAgendamentoAtendimento)
                    .addComponent(jBtCancelarEvolucao)
                    .addComponent(jBtSalvarEvolucao)
                    .addComponent(jBtExcluirEvolucao)
                    .addComponent(jBtAlterarEvolucao)
                    .addComponent(jBtNovaEvolucao)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterarEvolucao, jBtAuditoriaEvolucao, jBtCancelarEvolucao, jBtExcluirEvolucao, jBtNovaEvolucao, jBtSalvarEvolucao});

        jTabbedPane1.addTab("Evolução Psicológica", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(300, 10, 630, 525);
    }// </editor-fold>//GEN-END:initComponents

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
                        preencherAdmissoPsicologia("SELECT * FROM ADMISSAOPSI "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON ADMISSAOPSI.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
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
                        preencherAdmissoPsicologia("SELECT * FROM ADMISSAOPSI "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON ADMISSAOPSI.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                + "WHERE DataLanc BETWEEN'" + dataInicial + "'AND '" + dataFinal + "'");
                    }
                }
            }
        }
    }//GEN-LAST:event_jBtPesqDatasActionPerformed

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaMovimentacaoAdmIntManuPSI);
        if (codigoUserPSI == codUserAcessoPSI && nomeTelaPSI.equals(telaMovimentacaoAdmIntManuPSI) && codIncluirPSI == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPSI.equals("ADMINISTRADORES")) {
            acao = 1;
            Novo();
            limparTabelaEvolucao();
            limparTabelaParecer();
            verificarInternoRegistradoAdm();
            preencherComboBoxDepartamento();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
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
                conecta.executaSQL("SELECT * FROM ADMISSAOPSI WHERE IdLanc='" + jIdLanc.getText() + "'");
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
                conecta.executaSQL("SELECT * FROM ADMISSAOPSI WHERE IdLanc='" + jIdLanc.getText() + "'");
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
                    verificarEvolucao();
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
            verificarAdmissao();
            if (jDataLanc.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data do lançamento.");
                jDataLanc.requestFocus();
                jDataLanc.setBackground(Color.red);
            } else if (jNomeInterno.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário informar o nome do interno.");
            } else if (jTextoEvolucaoAdmissao.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Digite o texto da primeira evolução.");
                jTextoEvolucaoAdmissao.requestFocus();
                jTextoEvolucaoAdmissao.setBackground(Color.red);
            } else {
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
                objAdmPsi.setEncaminhamento(jTextoEvolucaoAdmissao.getText());
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
                    if (jIdInterno.getText().equals(pCODIGO_INTERNO)) {
                        JOptionPane.showMessageDialog(rootPane, "Esse interno já fez admissão anteriormente nessa tela.");
                        int resposta = JOptionPane.showConfirmDialog(this, "Deseja cadastrar uma nova admissão na aba complementar?", "Confirmação",
                                JOptionPane.YES_NO_OPTION);
                        if (resposta == JOptionPane.YES_OPTION) {
                            pesquisarInternoExistente();
                            mostrarTelaNovaAdm();
                        }
                    } else {
                        // log de usuario
                        objAdmPsi.setUsuarioInsert(nameUser);
                        objAdmPsi.setDataInsert(dataModFinal);
                        objAdmPsi.setHoraInsert(horaMov);
                        objAdmPsi.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
                        objAdmPsi.setNomeInterno(jNomeInterno.getText());
                        control.incluirAdmissaoPsi(objAdmPsi);
                        buscarID();
                        objAdmPsi.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                        objAdmPsi.setNomeInterno(jNomeInterno.getText());
                        objAdmPsi.setDeptoPsicologico(deptoTecnico);
                        controle.incluirMovTec(objAdmPsi);
                        // MODIFICAR A TABELA REGISTRO_ATENDIMENTO_INTERNO_PSP INFORMANDO QUE JÁ FOI ATENDIDO   
                        atendido = "Sim";
                        objRegAtend.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
                        objRegAtend.setNomeInternoCrc(jNomeInterno.getText());
                        objRegAtend.setIdDepartamento(codigoDepartamentoPSI);
                        objRegAtend.setNomeDepartamento(nomeModuloPSICOLOGIA);
                        objRegAtend.setTipoAtemdimento(tipoAtendimentoAdm);
                        objRegAtend.setAtendido(atendido);
                        objRegAtend.setDataAtendimento(jDataLanc.getDate());
                        objRegAtend.setIdAtend(Integer.valueOf(jIdLanc.getText()));
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
                        objRegAtend.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
                        objRegAtend.setNomeInternoCrc(jNomeInterno.getText());
                        objRegAtend.setIdDepartamento(codigoDepartamentoPSI);
                        objRegAtend.setNomeDepartamento(nomeModuloPSICOLOGIA);
                        objRegAtend.setConcluido(pATENDIMENTO_CONCLUIDO);
                        objRegAtend.setHorarioUp(horaMov);
                        objRegAtend.setIdAtend(Integer.valueOf(jIdLanc.getText()));
                        objRegAtend.setTipoAtemdimento(tipoAtendimentoAdm);
                        control_ATENDE.confirmarAtendimento(objRegAtend);
                        //CONFIRMA A REALIZAÇÃO ADMISSÃO DO INTERNO, IMPEDINDO QUE FAÇA OUTRA ADMISSÃO
                        pHABILITA_PSICOLOGIA = "Não";
                        objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
                        objPortaEntrada.setNomeInternoCrc(jNomeInterno.getText());
                        objPortaEntrada.setHabPsi(pHABILITA_PSICOLOGIA);
                        control_PE.alterarPortaEntradaPsicologia(objPortaEntrada);
                        // ADICIONAR UMA EVOLUÇÃO INICIAL
                        evolu.setDataEvolucao(jDataLanc.getDate());
                        evolu.setNomeDepartamento((String) jComboBoxDepartamentoEncaminha.getSelectedItem());
                        evolu.setDataEncaminhamento(jDataEncaminhamento.getDate());
                        evolu.setHoraEncaminhamento(jHoraAcompanha.getText());
                        evolu.setTextoEvolucaoAdmissao(jTextoEvolucaoAdmissao.getText());
                        // Para o log do registro
                        evolu.setUsuarioInsert(nameUser);
                        evolu.setDataInsert(dataModFinal);
                        evolu.setHorarioInsert(horaMov);
                        evolu.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                        evolu.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
                        evolu.setNomeInternoCrc(jNomeInterno.getText());
                        evolu.setAdmEvo(admEvolucao);
                        controlEvolu.incluirEvolucaoPsiADM(evolu);
                        buscarCodEvolucao();
                        preencherEvolucaoPsicologia("SELECT * FROM EVOLUCAOPSICOLOGICA "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON EVOLUCAOPSICOLOGICA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                + "WHERE IdLanc='" + jIdLanc.getText() + "'");
                        //CONFIRMA A REALIZAÇÃO ADMISSÃO DO INTERNO, IMPEDINDO QUE FAÇA OUTRA ADMISSÃO
                        pHABILITA_PSICOLOGIA = "Não";
                        objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
                        objPortaEntrada.setNomeInternoCrc(jNomeInterno.getText());
                        objPortaEntrada.setHabPsi(pHABILITA_PSICOLOGIA);
                        control_PE.alterarPortaEntradaPsicologia(objPortaEntrada);
                        Salvar();
                        corCampos();
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                        int resposta = JOptionPane.showConfirmDialog(this, "Deseja iniciar tratamento ao interno agora?", "Confirmação",
                                JOptionPane.YES_NO_OPTION);
                        if (resposta == JOptionPane.YES_OPTION) {
                            mostraTelaTratamentoPSI();
                        }
                    }
                }
                if (acao == 2) {
                    // log de usuario
                    objAdmPsi.setUsuarioUp(nameUser);
                    objAdmPsi.setDataUp(dataModFinal);
                    objAdmPsi.setHoraUp(horaMov);
                    //
                    objAdmPsi.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
                    objAdmPsi.setNomeInterno(jNomeInterno.getText());
                    objAdmPsi.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                    control.alterarAdmissaoPsi(objAdmPsi);
                    //MOVIMENTO TÉCNICO
                    objAdmPsi.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                    objAdmPsi.setDeptoPsicologico(deptoTecnico);
                    controle.alterarMovTec(objAdmPsi);
                    //EVOLUÇÃO DA ADMISSÃO
                    evolu.setUsuarioUp(nameUser);
                    evolu.setDataUp(jDataSistema.getText());
                    evolu.setHorarioUp(jHoraSistema.getText());
                    //
                    evolu.setDataEvolucao(jDataLanc.getDate());
                    evolu.setNomeDepartamento((String) jComboBoxDepartamentoEncaminha.getSelectedItem());
                    evolu.setDataEncaminhamento(jDataEncaminhamento.getDate());
                    evolu.setHoraEncaminhamento(jHoraAcompanha.getText());
                    evolu.setTextoEvolucaoAdmissao(jTextoEvolucaoAdmissao.getText());
                    evolu.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                    evolu.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
                    evolu.setNomeInternoCrc(jNomeInterno.getText());
                    evolu.setAdmEvo(admEvolucao);
                    controlEvolu.alterarEvolucaoPsiADM(evolu);
                    preencherEvolucaoPsicologia("SELECT * FROM EVOLUCAOPSICOLOGICA "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON EVOLUCAOPSICOLOGICA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "WHERE IdLanc='" + jIdLanc.getText() + "'");
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    Salvar();
                    corCampos();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
            }
//            acao = 0;
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtSalvarActionPerformed

    private void jBtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarActionPerformed
        // TODO add your handling code here:
        Cancelar();
        acao = 0;
    }//GEN-LAST:event_jBtCancelarActionPerformed

    private void jBtFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFinalizarActionPerformed
        // TODO add your handling code here:
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ADMISSAOPSI "
                    + "WHERE IdLanc='" + jIdLanc.getText() + "'");
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

    private void jBtPesqInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqInternoActionPerformed
        // TODO add your handling code here:
        verificarRegistroBiometria();
        if (pHabilitaPsicologia.equals("Não")) {
            TelaPesqInternoAdmPsicologia objPesqIntAdmPsi = new TelaPesqInternoAdmPsicologia();
            TelaModuloPsicologia.jPainelPsicologia.add(objPesqIntAdmPsi);
            objPesqIntAdmPsi.show();
        } else {
            TelaPesqInternoAtendPSIBio objPesqIntBio = new TelaPesqInternoAtendPSIBio();
            TelaModuloPsicologia.jPainelPsicologia.add(objPesqIntBio);
            objPesqIntBio.show();
        }
    }//GEN-LAST:event_jBtPesqInternoActionPerformed

    private void jBtIDPesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtIDPesqActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (jIDPesq.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o ID para pesquisa.");
            jIDPesq.requestFocus();
        } else {
            jTabelaAdmissaoPsicologica.setVisible(true);
            preencherAdmissoPsicologia("SELECT * FROM ADMISSAOPSI "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ADMISSAOPSI.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE IdLanc='" + jIDPesq.getText() + "'");
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
            preencherAdmissoPsicologia("SELECT * FROM ADMISSAOPSI "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ADMISSAOPSI.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE NomeInternoCrc LIKE'" + jPesqNomeInterno.getText() + "%'");
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jTabelaAdmissaoPsicologicaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaAdmissaoPsicologicaMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String IdLanc = "" + jTabelaAdmissaoPsicologica.getValueAt(jTabelaAdmissaoPsicologica.getSelectedRow(), 0);
            jIDPesq.setText(IdLanc);
            //  
            jBtNovo.setEnabled(!true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            jBtNovaEvolucao.setEnabled(true);
            //
            jBtArtigosParagrafos.setEnabled(true);
            //
            jBtNovoParecer.setEnabled(true);
            //
            jBtAgendamentoAtendimento.setEnabled(true);
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ADMISSAOPSI "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ADMISSAOPSI.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE IdLanc='" + IdLanc + "'");
                conecta.rs.first();
                jIdLanc.setText(String.valueOf(conecta.rs.getInt("IdLanc")));
                jStatusLanc.setText(conecta.rs.getString("StatusLanc"));
                jDataLanc.setDate(conecta.rs.getDate("DataLanc"));
                jIdInterno.setText(conecta.rs.getString("IdInternoCrc"));
                jNomeInterno.setText(conecta.rs.getString("NomeInternoCrc"));
                jDataNascimento.setDate(conecta.rs.getDate("DataNasciCrc"));
                jSituacaoUnidade.setText(conecta.rs.getString("SituacaoCrc"));
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
                jTextoEvolucaoAdmissao.setText(conecta.rs.getString("Encaminhamento"));
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
            // PARECER PSICOLOGICO
            preencherParecerPsicologia("SELECT * FROM PARECER_PSI INNER "
                    + "JOIN ADMISSAOPSI "
                    + "ON PARECER_PSI.IdLanc=ADMISSAOPSI.IdLanc "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON PARECER_PSI.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE PARECER_PSI.IdLanc='" + jIdLanc.getText() + "'");
            // EVOLUÇÃO PSICOLOGICA
            jIdEvolucao.setText("");
            jComboBoxStatusEvolucao.setSelectedItem("Em Andamento");
            jDataEvolucao.setDate(null);
            jComboBoxEncaminharSetorEvo.setSelectedItem("Selecione...");
            jDataEncaminhamentoEvo.setDate(null);
            jHoraEnvioEvo.setText("");
            jEvolucao.setText("");
            preencherEvolucaoPsicologia("SELECT * FROM EVOLUCAOPSICOLOGICA "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON EVOLUCAOPSICOLOGICA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE IdLanc='" + IdLanc + "'");
        }
    }//GEN-LAST:event_jTabelaAdmissaoPsicologicaMouseClicked

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherAdmissoPsicologia("SELECT * FROM ADMISSAOPSI "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ADMISSAOPSI.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc");
        } else {
            jtotalRegistros.setText("");
            limparTabela();
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jBtAuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaActionPerformed
        // TODO add your handling code heredPsi
        TelaAuditoriaAdmissaoPsicologia audPsi = new TelaAuditoriaAdmissaoPsicologia();
        TelaModuloPsicologia.jPainelPsicologia.add(audPsi);
        audPsi.show();
    }//GEN-LAST:event_jBtAuditoriaActionPerformed

    private void jBtNovaEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovaEvolucaoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaMovimentacaoEvolIntPSI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPSI.equals("ADMINISTRADORES") || codigoUserPSI == codUserAcessoPSI && nomeTelaPSI.equals(telaMovimentacaoEvolIntPSI) && codIncluirPSI == 1) {
            verificarInternoRegistradoAdm();
            if (atendido == null) {
                JOptionPane.showMessageDialog(rootPane, "É necessário fazer o registro do interno para ser atendido.");
            } else if (atendido.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário fazer o registro do interno para ser atendido.");
            } else if (atendido.equals("Sim")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário fazer o registro do interno para ser atendido.");
            } else if (atendido.equals("Não")) {
                acao = 3;
                NovaEvolucao();
                statusMov = "Incluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
                preencherComboBoxDepartamento();
                corCampos();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovaEvolucaoActionPerformed

    private void jBtAlterarEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarEvolucaoActionPerformed
        // TODO add your handling code here:   
        buscarAcessoUsuario(telaMovimentacaoEvolIntPSI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPSI.equals("ADMINISTRADORES") || codigoUserPSI == codUserAcessoPSI && nomeTelaPSI.equals(telaMovimentacaoEvolIntPSI) && codAlterarPSI == 1) {
            verificarEvolucaoAdmissao();
            if (admEvolucao == null) {
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM EVOLUCAOPSICOLOGICA WHERE IdEvolucao='" + jIdEvolucao.getText() + "'");
                    conecta.rs.first();
                    nomeUserRegistro = conecta.rs.getString("UsuarioInsert");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Não foi possivel encontrar o usuário.");
                }
                if (nomeUserRegistro == null ? nameUser == null : nomeUserRegistro.equals(nameUser)) {
                    acao = 4;
                    AlterarEvolucao();
                    preencherComboBoxDepartamento();
                    statusMov = "Alterou";
                    horaMov = jHoraSistema.getText();
                    dataModFinal = jDataSistema.getText();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Esse registro foi inserido pelo " + nomeUserRegistro + " só esse usuário poderá modificar.");
                    conecta.desconecta();
                }
            } else if (admEvolucao.equals("")) {
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM EVOLUCAOPSICOLOGICA WHERE IdEvolucao='" + jIdEvolucao.getText() + "'");
                    conecta.rs.first();
                    nomeUserRegistro = conecta.rs.getString("UsuarioInsert");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Não foi possivel encontrar o usuário.");
                }
                if (nomeUserRegistro == null ? nameUser == null : nomeUserRegistro.equals(nameUser)) {
                    acao = 4;
                    AlterarEvolucao();
                    preencherComboBoxDepartamento();
                    statusMov = "Alterou";
                    horaMov = jHoraSistema.getText();
                    dataModFinal = jDataSistema.getText();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Esse registro foi inserido pelo " + nomeUserRegistro + " só esse usuário poderá modificar.");
                    conecta.desconecta();
                }
            } else if (admEvolucao.equals("Sim")) {
                JOptionPane.showMessageDialog(rootPane, "Essa evolução não poderá ser alterada nessa tela, será necessário alterar na admissão.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtAlterarEvolucaoActionPerformed

    private void jBtExcluirEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirEvolucaoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaMovimentacaoEvolIntPSI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPSI.equals("ADMINISTRADORES") || codigoUserPSI == codUserAcessoPSI && nomeTelaPSI.equals(telaMovimentacaoEvolIntPSI) && codExcluirPSI == 1) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM EVOLUCAOPSICOLOGICA WHERE IdEvolucao='" + jIdEvolucao.getText() + "'");
                conecta.rs.first();
                nomeUserRegistro = conecta.rs.getString("UsuarioInsert");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não foi possivel encontrar o usuário.");
            }
            if (nomeUserRegistro == null ? nameUser == null : nomeUserRegistro.equals(nameUser)) {
                objAdmPsi.setStatusLanc(jStatusLanc.getText());
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o INTERNO selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    evolu.setIdEvolucao(Integer.valueOf(jIdEvolucao.getText()));
                    evolu.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                    evolu.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
                    controlEvolu.excluirEvolucaoPsi(evolu);
                    objLog2();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                    ExcluirEvolucao();
                    preencherEvolucaoPsicologia("SELECT * FROM EVOLUCAOPSICOLOGICA "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON EVOLUCAOPSICOLOGICA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "WHERE IdLanc='" + jIdLanc.getText() + "'");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esse registro foi inserido pelo " + nomeUserRegistro + " só esse usuário poderá excluir.");
                conecta.desconecta();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirEvolucaoActionPerformed

    private void jBtSalvarEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarEvolucaoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaMovimentacaoEvolIntPSI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPSI.equals("ADMINISTRADORES") || codigoUserPSI == codUserAcessoPSI && nomeTelaPSI.equals(telaMovimentacaoEvolIntPSI) && codGravarPSI == 1) {
            if (jDataEvolucao.getDate() == null) {
                JOptionPane.showMessageDialog(null, "Informe a data da Evolução.");
                jDataEvolucao.requestFocus();
                jDataEvolucao.setBackground(Color.red);
            } else if (jComboBoxStatusEvolucao.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o tipo de tratamento do interno.");
            } else {
                evolu.setStatusEvo((String) jComboBoxStatusEvolucao.getSelectedItem());
                evolu.setDataEvolucao(jDataEvolucao.getDate());
                evolu.setNomeDepartamento((String) jComboBoxEncaminharSetorEvo.getSelectedItem());
                evolu.setDataEncaminhamento(jDataEncaminhamentoEvo.getDate());
                evolu.setHoraEncaminhamento(jHoraEnvioEvo.getText());
                evolu.setHistorico(jEvolucao.getText());
                if (acao == 3) {
                    // Para o log do registro
                    evolu.setUsuarioInsert(nameUser);
                    evolu.setDataInsert(dataModFinal);
                    evolu.setHorarioInsert(horaMov);
                    evolu.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                    evolu.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
                    evolu.setNomeInternoCrc(jNomeInterno.getText());
                    controlEvolu.incluirEvolucaoPsi(evolu);
                    buscarCodEvolucao();
                    objAdmPsi.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                    objAdmPsi.setDataLanc(jDataEvolucao.getDate());
                    objAdmPsi.setNomeInterno(jNomeInterno.getText());
                    objAdmPsi.setDeptoPsicologico(deptoTecnico);
                    controleEvo.incluirMovTec(objAdmPsi);
                    // MODIFICAR A TABELA REGISTRO_ATENDIMENTO_INTERNO_PSP INFORMANDO QUE JÁ FOI ATENDIDO     
                    atendido = "Sim";
                    objRegAtend.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
                    objRegAtend.setNomeInternoCrc(jNomeInterno.getText());
                    objRegAtend.setIdDepartamento(codigoDepartamentoPSI);
                    objRegAtend.setNomeDepartamento(nomeModuloPSICOLOGIA);
                    objRegAtend.setTipoAtemdimento(tipoAtendimentoEvol);
                    objRegAtend.setAtendido(atendido);
                    objRegAtend.setDataAtendimento(jDataEvolucao.getDate());
                    objRegAtend.setIdAtend(Integer.valueOf(jIdLanc.getText()));
                    objRegAtend.setIdEvol(Integer.valueOf(jIdEvolucao.getText()));
                    objRegAtend.setAtendeEvol(atendido);
                    objRegAtend.setQtdAtend(pQUANTIDADE_ATENDIDA);
                    //
                    objRegAtend.setUsuarioUp(nameUser);
                    objRegAtend.setDataUp(dataModFinal);
                    objRegAtend.setHorarioUp(horaMov);
                    controlRegAtend.alterarRegEvol(objRegAtend);
                    //
                    objLog2();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    //GRAVAR NA TABELA DE ATENDIMENTO ATENDIMENTO_PSP_INTERNO_TV        
                    objRegAtend.setStatusAtendimento(status_ATENDIMENTO);
                    objRegAtend.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
                    objRegAtend.setNomeInternoCrc(jNomeInterno.getText());
                    objRegAtend.setIdDepartamento(codigoDepartamentoPSI);
                    objRegAtend.setNomeDepartamento(nomeModuloPSICOLOGIA);
                    objRegAtend.setConcluido(pATENDIMENTO_CONCLUIDO);
                    objRegAtend.setHorarioUp(horaMov);
                    objRegAtend.setIdAtend(Integer.valueOf(jIdEvolucao.getText()));
                    objRegAtend.setTipoAtemdimento(tipoAtendimentoEvol);
                    control_ATENDE.confirmarAtendimento(objRegAtend);
                    SalvarEvolucao();
                    preencherEvolucaoPsicologia("SELECT * FROM EVOLUCAOPSICOLOGICA "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON EVOLUCAOPSICOLOGICA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "WHERE IdLanc='" + jIdLanc.getText() + "'");
                    JOptionPane.showMessageDialog(null, "Registro gravado com sucesso.");

                }
                if (acao == 4) {
                    // Para o log do registro
                    evolu.setUsuarioUp(nameUser);
                    evolu.setDataUp(jDataSistema.getText());
                    evolu.setHorarioUp(jHoraSistema.getText());
                    //
                    evolu.setIdEvolucao(Integer.valueOf(jIdEvolucao.getText()));
                    evolu.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                    evolu.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
                    evolu.setNomeInternoCrc(jNomeInterno.getText());
                    controlEvolu.alterarEvolucaoPsi(evolu);
                    //
                    objAdmPsi.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                    objAdmPsi.setNomeInterno(jNomeInterno.getText());
                    objAdmPsi.setDataLanc(jDataEvolucao.getDate());
                    objAdmPsi.setDeptoPsicologico(deptoTecnico);
                    controleEvo.alterarMovTec(objAdmPsi);
                    //
                    objLog2();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    SalvarEvolucao();
                    preencherEvolucaoPsicologia("SELECT * FROM EVOLUCAOPSICOLOGICA "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON EVOLUCAOPSICOLOGICA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "WHERE IdLanc='" + jIdLanc.getText() + "'");
                    JOptionPane.showMessageDialog(null, "Registro gravado com sucesso.");
                }
            }
            acao = 0;
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtSalvarEvolucaoActionPerformed

    private void jBtCancelarEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarEvolucaoActionPerformed
        // TODO add your handling code here:
        CancelarEvolucao();
        acao = 0;
    }//GEN-LAST:event_jBtCancelarEvolucaoActionPerformed

    private void jBtAuditoriaEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaEvolucaoActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaEvolucaoPsicologia objEvolu = new TelaAuditoriaEvolucaoPsicologia();
        TelaModuloPsicologia.jPainelPsicologia.add(objEvolu);
        objEvolu.show();
    }//GEN-LAST:event_jBtAuditoriaEvolucaoActionPerformed

    private void jTabelaEvolucaoPsicologiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaEvolucaoPsicologiaMouseClicked
        // TODO add your handling code here:      
        if (flag == 1) {
            String IdEvolucao = "" + jTabelaEvolucaoPsicologia.getValueAt(jTabelaEvolucaoPsicologia.getSelectedRow(), 0);
            jIdEvolucao.setText(IdEvolucao);
            //           
            jBtNovaEvolucao.setEnabled(true);
            jBtAlterarEvolucao.setEnabled(true);
            jBtExcluirEvolucao.setEnabled(true);
            jBtCancelarEvolucao.setEnabled(true);
            jBtAuditoriaEvolucao.setEnabled(true);
            //          
            jComboBoxEncaminharSetorEvo.removeAllItems();
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM EVOLUCAOPSICOLOGICA WHERE IdEvolucao='" + IdEvolucao + "'");
                conecta.rs.first();
                jIdEvolucao.setText(conecta.rs.getString("IdEvolucao"));
                jComboBoxStatusEvolucao.setSelectedItem(conecta.rs.getString("StatusEvo"));
                jDataEvolucao.setDate(conecta.rs.getDate("DataEvolucao"));
                jDataEncaminhamentoEvo.setDate(conecta.rs.getDate("DataEncaminhamento"));
                jHoraEnvioEvo.setText(conecta.rs.getString("HoraEncaminhamento"));
                jEvolucao.setText(conecta.rs.getString("Historico"));
                jComboBoxEncaminharSetorEvo.addItem(conecta.rs.getString("NomeDepartamento"));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Erro na seleção...\nERRO: " + e);
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaEvolucaoPsicologiaMouseClicked

    private void jBtImpressaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImpressaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtImpressaoActionPerformed

    private void jBtArtigosParagrafosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtArtigosParagrafosActionPerformed
        // TODO add your handling code here:
        if (jIdInterno.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Pesquise primeiro o interno para consultar o(s) artigo(s).");
        } else {
            mostrarTelaArtigos();
        }
    }//GEN-LAST:event_jBtArtigosParagrafosActionPerformed

    private void jBtLocalizarVisitaRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtLocalizarVisitaRolActionPerformed
        // TODO add your handling code here:
        if (jIdInterno.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Pesquise primeiro o interno para consultar a(s) visita(s).");
        } else {
            mostrarVisitasInternos();
        }
    }//GEN-LAST:event_jBtLocalizarVisitaRolActionPerformed

    private void jBtNovoParecerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoParecerActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaMovimentacaoPareIntPSI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPSI.equals("ADMINISTRADORES") || codigoUserPSI == codUserAcessoPSI && nomeTelaPSI.equals(telaMovimentacaoPareIntPSI) && codIncluirPSI == 1) {
            statusMov = "Icluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            acao = 5;
            bloquearCampos();
            NovoParecer();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovoParecerActionPerformed

    private void jBtAlterarParecerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarParecerActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaMovimentacaoPareIntPSI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPSI.equals("ADMINISTRADORES") || codigoUserPSI == codUserAcessoPSI && nomeTelaPSI.equals(telaMovimentacaoPareIntPSI) && codAlterarPSI == 1) {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM PARECER_PSI WHERE IdParecer='" + jCodigoParecer.getText() + "'");
                conecta.rs.first();
                nomeUserRegistro = conecta.rs.getString("UsuarioInsert");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não foi possivel encontrar o usuário.");
            }
            if (nomeUserRegistro == null ? nameUser == null : nomeUserRegistro.equals(nameUser)) {
                acao = 6;
                AlterarParecer();
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esse registro foi inserido pelo " + nomeUserRegistro + " só esse usuário poderá modificar.");
                conecta.desconecta();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtAlterarParecerActionPerformed

    private void jBtExcluirParecerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirParecerActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaMovimentacaoPareIntPSI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPSI.equals("ADMINISTRADORES") || codigoUserPSI == codUserAcessoPSI && nomeTelaPSI.equals(telaMovimentacaoPareIntPSI) && codExcluirPSI == 1) {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM PARECER_PSI WHERE IdParecer='" + jCodigoParecer.getText() + "'");
                conecta.rs.first();
                nomeUserRegistro = conecta.rs.getString("UsuarioInsert");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não foi possivel encontrar o usuário.");
            }
            if (nomeUserRegistro == null ? nameUser == null : nomeUserRegistro.equals(nameUser)) {
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    objAdmPsi.setIdParecer(Integer.valueOf(jCodigoParecer.getText()));
                    controleParecer.excluirParecerPsi(objAdmPsi);
                    ExcluirParecer();
                    preencherParecerPsicologia("SELECT * FROM PARECER_PSI INNER "
                            + "JOIN ADMISSAOPSI "
                            + "ON PARECER_PSI.IdLanc=ADMISSAOPSI.IdLanc "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON PARECER_PSI.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "WHERE PARECER_PSI.IdLanc='" + jIdLanc.getText() + "'");
                    JOptionPane.showMessageDialog(rootPane, "Registro excluído com sucesso.");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esse registro foi inserido pelo " + nomeUserRegistro + " só esse usuário poderá modificar.");
                conecta.desconecta();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirParecerActionPerformed

    private void jBtSalvarParecerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarParecerActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaMovimentacaoPareIntPSI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPSI.equals("ADMINISTRADORES") || codigoUserPSI == codUserAcessoPSI && nomeTelaPSI.equals(telaMovimentacaoPareIntPSI) && codGravarPSI == 1) {
            if (jDataParecer.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data do parecer psicologico.");
            } else {
                objAdmPsi.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                objAdmPsi.setDataParecer(jDataParecer.getDate());
                objAdmPsi.setParecerPsicologico(jParecerPsicologico.getText());
                objAdmPsi.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
                objAdmPsi.setNomeInterno(jNomeInterno.getText());
                if (acao == 5) {
                    // log de usuario
                    objAdmPsi.setUsuarioInsert(nameUser);
                    objAdmPsi.setDataInsert(dataModFinal);
                    objAdmPsi.setHoraInsert(horaMov);
                    controleParecer.incluirParecerPsi(objAdmPsi);
                    buscarCodigoParecer();
                    objLog3();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    SalvarParecer();
                    preencherParecerPsicologia("SELECT * FROM PARECER_PSI INNER "
                            + "JOIN ADMISSAOPSI "
                            + "ON PARECER_PSI.IdLanc=ADMISSAOPSI.IdLanc "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON PARECER_PSI.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "WHERE PARECER_PSI.IdLanc='" + jIdLanc.getText() + "'");
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
                if (acao == 6) {
                    objAdmPsi.setUsuarioUp(nameUser);
                    objAdmPsi.setDataUp(dataModFinal);
                    objAdmPsi.setHoraUp(horaMov);
                    objAdmPsi.setIdParecer(Integer.valueOf(jCodigoParecer.getText()));
                    controleParecer.alterarParecerPsi(objAdmPsi);
                    objLog3();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    SalvarParecer();
                    preencherParecerPsicologia("SELECT * FROM PARECER_PSI INNER "
                            + "JOIN ADMISSAOPSI "
                            + "ON PARECER_PSI.IdLanc=ADMISSAOPSI.IdLanc "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON PARECER_PSI.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "WHERE PARECER_PSI.IdLanc='" + jIdLanc.getText() + "'");
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtSalvarParecerActionPerformed

    private void jBtCancelarParecerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarParecerActionPerformed
        // TODO add your handling code here:
        CancelarParecer();
    }//GEN-LAST:event_jBtCancelarParecerActionPerformed

    private void jBtAuditoriaParecerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaParecerActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaParecerPsicologico objAudiPar = new TelaAuditoriaParecerPsicologico();
        TelaModuloPsicologia.jPainelPsicologia.add(objAudiPar);
        objAudiPar.show();
    }//GEN-LAST:event_jBtAuditoriaParecerActionPerformed

    private void jTabelaParecerPsicologicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaParecerPsicologicoMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            String codigoParecer = "" + jTabelaParecerPsicologico.getValueAt(jTabelaParecerPsicologico.getSelectedRow(), 0);
            jCodigoParecer.setText(codigoParecer);
            //
            jBtNovoParecer.setEnabled(!true);
            jBtAlterarParecer.setEnabled(true);
            jBtExcluirParecer.setEnabled(true);
            jBtSalvarParecer.setEnabled(!true);
            jBtCancelarParecer.setEnabled(true);
            jBtAuditoriaParecer.setEnabled(true);
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM PARECER_PSI "
                        + "INNER JOIN ADMISSAOPSI "
                        + "ON PARECER_PSI.IdLanc=ADMISSAOPSI.IdLanc "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON PARECER_PSI.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE PARECER_PSI.IdLanc='" + jIdLanc.getText() + "' "
                        + "AND PARECER_PSI.IdParecer='" + codigoParecer + "'");
                conecta.rs.first();
                jCodigoParecer.setText(conecta.rs.getString("Idparecer"));
                jDataParecer.setDate(conecta.rs.getDate("DataParecer"));
                jNomeInternoParecer.setText(conecta.rs.getString("NomeInternoCrc"));
                jParecerPsicologico.setText(conecta.rs.getString("ParecerPsicologico"));
            } catch (Exception e) {
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaParecerPsicologicoMouseClicked

    private void jBtAgendamentoAtendimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAgendamentoAtendimentoActionPerformed
        // TODO add your handling code here:
        if (jIdInterno.getText().equals("") && jIdLanc.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "É necessário gravar primeiro a admissão para poder fazer o agendamento.");
        } else {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM AGENDA_ATENDIMENTO_INTERNOS "
                        + "INNER JOIN ITENS_AGENDA_ATENDIMENTO_INTERNOS "
                        + "ON AGENDA_ATENDIMENTO_INTERNOS.IdReg=ITENS_AGENDA_ATENDIMENTO_INTERNOS.IdReg "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ITENS_AGENDA_ATENDIMENTO_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE ITENS_AGENDA_ATENDIMENTO_INTERNOS.IdInternoCrc='" + jIdInterno.getText() + "'");
                conecta.rs.first();
                nomeDepartamento = conecta.rs.getString("Departamento");
                codigoStatusReg = conecta.rs.getString("StatusReg");
                codigoInterno = conecta.rs.getString("IdInternoCrc");
            } catch (Exception e) {
            }
            if (jIdInterno.getText().equals(codigoInterno) && nomeDepartamento.equals("PSICOLOGIA") && codigoStatusReg.equals("Não Realizado")) {
                JOptionPane.showMessageDialog(rootPane, "Já existe um agendamento para esse interno nesse departamento.");
            } else {
                mostrarAgendaAtendimento();
            }
        }

    }//GEN-LAST:event_jBtAgendamentoAtendimentoActionPerformed

    private void jBtLocalizacaoInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtLocalizacaoInternoActionPerformed
        // TODO add your handling code here:
        TelaConsultaLocalInternoPsicologia objLoca = new TelaConsultaLocalInternoPsicologia();
        TelaModuloPsicologia.jPainelPsicologia.add(objLoca);
        objLoca.show();
    }//GEN-LAST:event_jBtLocalizacaoInternoActionPerformed

    private void jBtVisitasInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtVisitasInternoActionPerformed
        // TODO add your handling code here:
        if (jIdInterno.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Pesquise primeiro o interno para consultar a(s) visita(s).");
        } else {
            mostrarVisitasInternos();
        }
    }//GEN-LAST:event_jBtVisitasInternoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (jIdLanc.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "É necessário informar um registro de atendimento para iniciar ou terminar um tratamento.");
        } else {
            mostraTelaTratamentoPSI();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jBtTratamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtTratamentoActionPerformed
        // TODO add your handling code here:
        if (jIdLanc.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "É necessário informar um registro de atendimento para iniciar ou terminar um tratamento.");
        } else {
            mostraTelaTratamentoPSI();
        }
    }//GEN-LAST:event_jBtTratamentoActionPerformed

    private void jBtNovaAdmissaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovaAdmissaoActionPerformed
        // TODO add your handling code here:
        if (jIdLanc.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "É necessário pesquisar primeiro o interno.");
        } else {
            mostrarTelaNovaAdm();
        }
    }//GEN-LAST:event_jBtNovaAdmissaoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtAgendamentoAtendimento;
    private javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtAlterarEvolucao;
    private javax.swing.JButton jBtAlterarParecer;
    private javax.swing.JButton jBtArtigosParagrafos;
    private javax.swing.JButton jBtAuditoria;
    private javax.swing.JButton jBtAuditoriaEvolucao;
    private javax.swing.JButton jBtAuditoriaParecer;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtCancelarEvolucao;
    private javax.swing.JButton jBtCancelarParecer;
    private javax.swing.JButton jBtExcluir;
    private javax.swing.JButton jBtExcluirEvolucao;
    private javax.swing.JButton jBtExcluirParecer;
    private javax.swing.JButton jBtFinalizar;
    private javax.swing.JButton jBtIDPesq;
    private javax.swing.JButton jBtImpressao;
    private javax.swing.JButton jBtLocalizacaoInterno;
    private javax.swing.JButton jBtLocalizarVisitaRol;
    private javax.swing.JButton jBtNovaAdmissao;
    private javax.swing.JButton jBtNovaEvolucao;
    private javax.swing.JButton jBtNovo;
    private javax.swing.JButton jBtNovoParecer;
    private javax.swing.JButton jBtPesqDatas;
    private javax.swing.JButton jBtPesqInterno;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JButton jBtSalvarEvolucao;
    private javax.swing.JButton jBtSalvarParecer;
    private javax.swing.JButton jBtTratamento;
    private javax.swing.JButton jBtVisitasInterno;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBoxAlcool;
    private javax.swing.JCheckBox jCheckBoxCigarro;
    private javax.swing.JCheckBox jCheckBoxCocaina;
    private javax.swing.JCheckBox jCheckBoxCola;
    private javax.swing.JCheckBox jCheckBoxCrack;
    private javax.swing.JCheckBox jCheckBoxMaconha;
    private javax.swing.JCheckBox jCheckBoxOutros;
    public static javax.swing.JTextField jCodigoParecer;
    private javax.swing.JComboBox jComboBoxAcompanhaPSI;
    private javax.swing.JComboBox jComboBoxDepartamentoEncaminha;
    private javax.swing.JComboBox jComboBoxEncaminharSetorEvo;
    private javax.swing.JComboBox jComboBoxFamiliaPreso;
    private javax.swing.JComboBox jComboBoxHouveTentativaSuicidio;
    private javax.swing.JComboBox jComboBoxMedicamentoPSI;
    private javax.swing.JComboBox jComboBoxPresoAntes;
    private javax.swing.JComboBox jComboBoxRecebeVisitas;
    private javax.swing.JComboBox jComboBoxSituacaoTraumatica;
    private javax.swing.JComboBox jComboBoxStatusEvolucao;
    private javax.swing.JComboBox jComboBoxTratamentoPSI;
    private javax.swing.JComboBox jComboBoxTratamentoSaude;
    private javax.swing.JComboBox jComboBoxUsaDrogras;
    private javax.swing.JTextField jComoFoiTentarSuicidio;
    private com.toedter.calendar.JDateChooser jDataEncaminhamento;
    private com.toedter.calendar.JDateChooser jDataEncaminhamentoEvo;
    private com.toedter.calendar.JDateChooser jDataEvolucao;
    private com.toedter.calendar.JDateChooser jDataFinal;
    private com.toedter.calendar.JDateChooser jDataInicial;
    private com.toedter.calendar.JDateChooser jDataLanc;
    public static com.toedter.calendar.JDateChooser jDataNascimento;
    private com.toedter.calendar.JDateChooser jDataParecer;
    private javax.swing.JTextArea jDrogas;
    private javax.swing.JTextArea jEvolucao;
    private javax.swing.JTextArea jFamiliares;
    public static javax.swing.JLabel jFotoInterno;
    private javax.swing.JTextArea jHistoricoCriminal;
    private javax.swing.JFormattedTextField jHoraAcompanha;
    private javax.swing.JFormattedTextField jHoraEnvioEvo;
    private javax.swing.JTextField jIDPesq;
    public static javax.swing.JTextField jIdEvolucao;
    public static javax.swing.JTextField jIdInterno;
    public static javax.swing.JTextField jIdLanc;
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JTextField jNomeInterno;
    private javax.swing.JTextField jNomeInternoParecer;
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
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel25;
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
    private javax.swing.JTextArea jParecerPsicologico;
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
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator2;
    public static javax.swing.JTextField jSituacaoUnidade;
    private javax.swing.JTextField jStatusLanc;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTabelaAdmissaoPsicologica;
    public static javax.swing.JTable jTabelaEvolucaoPsicologia;
    private javax.swing.JTable jTabelaParecerPsicologico;
    private javax.swing.JTextArea jTentativaSuicidio;
    private javax.swing.JTextArea jTextoEvolucaoAdmissao;
    private javax.swing.JTextArea jTranstornoMental;
    private javax.swing.JTextArea jTratamentoAntriores;
    private javax.swing.JTextArea jUsoMedicamentos;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void verificarAdmissao() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ADMISSAOPSI "
                    + "WHERE IdInternoCrc='" + jIdInterno.getText() + "'");
            conecta.rs.first();
            pCODIGO_INTERNO = conecta.rs.getString("IdInternoCrc");
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
        jTextoEvolucaoAdmissao.setLineWrap(true);
        jTextoEvolucaoAdmissao.setWrapStyleWord(true);
        //
        jParecerPsicologico.setLineWrap(true);
        jParecerPsicologico.setWrapStyleWord(true);
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
        //
        jEvolucao.setLineWrap(true);
        jEvolucao.setWrapStyleWord(true);
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
        jIdLanc.setBackground(Color.white);
        jStatusLanc.setBackground(Color.white);
        jDataLanc.setBackground(Color.white);
        jIdInterno.setBackground(Color.white);
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
        jTextoEvolucaoAdmissao.setBackground(Color.white);
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
        // EVOLUÇÃO
        jIdEvolucao.setBackground(Color.white);
        jComboBoxStatusEvolucao.setBackground(Color.white);
        jDataEvolucao.setBackground(Color.white);
        jComboBoxEncaminharSetorEvo.setBackground(Color.white);
        jDataEncaminhamentoEvo.setBackground(Color.white);
        jHoraEnvioEvo.setBackground(Color.white);
        jEvolucao.setBackground(Color.white);
        //
        jCodigoParecer.setBackground(Color.white);
        jDataParecer.setBackground(Color.white);
        jNomeInternoParecer.setBackground(Color.white);
        jParecerPsicologico.setBackground(Color.white);
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
        jTextoEvolucaoAdmissao.setEnabled(!true);
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
        //  EVOLUÇÃO
        jIdEvolucao.setEnabled(!true);
        jComboBoxStatusEvolucao.setEnabled(!true);
        jDataEvolucao.setEnabled(!true);
        jComboBoxEncaminharSetorEvo.setEnabled(!true);
        jDataEncaminhamentoEvo.setEnabled(!true);
        jHoraEnvioEvo.setEnabled(!true);
        // PARECER PSICOLOGICO
        jCodigoParecer.setEnabled(!true);
        jDataParecer.setEnabled(!true);
        jNomeInternoParecer.setEnabled(!true);
        jParecerPsicologico.setEnabled(!true);
        jEvolucao.setEnabled(!true);
    }

    public void Novo() {
        //
        jIdLanc.setText("");
        jStatusLanc.setText("ABERTO");
        jDataLanc.setCalendar(Calendar.getInstance());
        jIdInterno.setText("");
        jNomeInterno.setText("");
        jFotoInterno.setIcon(null);
        jSituacaoUnidade.setText("");
        jDataNascimento.setDate(null);
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
        jTextoEvolucaoAdmissao.setText("[DIGITE AQUI O TEXTO DA EVOLUÇÃO DA ADMISSÃO...]");
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
        //     
        jDataLanc.setEnabled(true);
        jBtPesqInterno.setEnabled(true);
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
        jTextoEvolucaoAdmissao.setEnabled(true);
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
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        jBtArtigosParagrafos.setEnabled(true);
        // EVOLUÇÃO        
        jIdEvolucao.setText("");
        jComboBoxStatusEvolucao.setSelectedItem("Em Andamento");
        jDataEvolucao.setDate(null);
        jComboBoxEncaminharSetorEvo.setSelectedItem("Selecione...");
        jDataEncaminhamentoEvo.setDate(null);
        jHoraEnvioEvo.setText("00:00:00");
        jEvolucao.setText("");
        //
        jBtNovaEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        // PARECER PSICOLOGICO
        jDataParecer.setEnabled(!true);
        //
        jBtNovoParecer.setEnabled(!true);
        jBtAlterarParecer.setEnabled(!true);
        jBtExcluirParecer.setEnabled(!true);
        jBtSalvarParecer.setEnabled(!true);
        jBtCancelarParecer.setEnabled(!true);
        jBtAuditoriaParecer.setEnabled(!true);
    }

    public void Alterar() {
        //Habiliar/Desabilitar Campos        
        jDataLanc.setEnabled(true);
        jBtPesqInterno.setEnabled(true);
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
        jTextoEvolucaoAdmissao.setEnabled(true);
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
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        // EVOLUÇÃO        
        jIdEvolucao.setText("");
        jComboBoxStatusEvolucao.setSelectedItem("Em Andamento");
        jDataEvolucao.setDate(null);
        jComboBoxEncaminharSetorEvo.setSelectedItem("Selecione...");
        jDataEncaminhamentoEvo.setDate(null);
        jHoraEnvioEvo.setText("00:00:00");
        jEvolucao.setText("");
        //
        jBtNovaEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        // PARECER PSICOLOGICO
        jDataParecer.setEnabled(!true);
        //
        jBtNovoParecer.setEnabled(!true);
        jBtAlterarParecer.setEnabled(!true);
        jBtExcluirParecer.setEnabled(!true);
        jBtSalvarParecer.setEnabled(!true);
        jBtCancelarParecer.setEnabled(!true);
        jBtAuditoriaParecer.setEnabled(!true);
    }

    public void Excluir() {
        //
        jIdLanc.setText("");
        jStatusLanc.setText("ABERTO");
        jDataLanc.setCalendar(Calendar.getInstance());
        jIdInterno.setText("");
        jNomeInterno.setText("");
        jFotoInterno.setIcon(null);
        jSituacaoUnidade.setText("");
        jDataNascimento.setDate(null);
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
        jQualIdade.setText("");
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
        jHoraAcompanha.setText("");
        jTextoEvolucaoAdmissao.setText("DIGITE AQUI O TEXTO DA EVOLUÇÃO DA ADMISSÃO...");
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
        //     
        jDataLanc.setEnabled(!true);
        jBtPesqInterno.setEnabled(!true);
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
        jTextoEvolucaoAdmissao.setEnabled(!true);
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
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        // EVOLUÇÃO        
        jIdEvolucao.setText("");
        jComboBoxStatusEvolucao.setSelectedItem("Em Andamento");
        jDataEvolucao.setDate(null);
        jComboBoxEncaminharSetorEvo.setSelectedItem("Selecione...");
        jDataEncaminhamentoEvo.setDate(null);
        jHoraEnvioEvo.setText("00:00:00");
        jEvolucao.setText("");
        //
        jBtNovaEvolucao.setEnabled(true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        // PARECER PSICOLOGICO
        jDataParecer.setEnabled(!true);
        //
        jBtNovoParecer.setEnabled(true);
        jBtAlterarParecer.setEnabled(!true);
        jBtExcluirParecer.setEnabled(!true);
        jBtSalvarParecer.setEnabled(!true);
        jBtCancelarParecer.setEnabled(!true);
        jBtAuditoriaParecer.setEnabled(!true);
    }

    public void Salvar() {
        jDataLanc.setEnabled(!true);
        jBtPesqInterno.setEnabled(!true);
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
        jTextoEvolucaoAdmissao.setEnabled(!true);
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
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        // EVOLUÇÃO        
        jIdEvolucao.setText("");
        jComboBoxStatusEvolucao.setSelectedItem("Em Andamento");
        jDataEvolucao.setDate(null);
        jComboBoxEncaminharSetorEvo.setSelectedItem("Selecione...");
        jDataEncaminhamentoEvo.setDate(null);
        jHoraEnvioEvo.setText("00:00:00");
        jEvolucao.setText("");
        //
        jBtNovaEvolucao.setEnabled(true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        // PARECER PSICOLOGICO
        jDataParecer.setEnabled(!true);
        //
        jBtNovoParecer.setEnabled(true);
        jBtAlterarParecer.setEnabled(!true);
        jBtExcluirParecer.setEnabled(!true);
        jBtSalvarParecer.setEnabled(!true);
        jBtCancelarParecer.setEnabled(!true);
        jBtAuditoriaParecer.setEnabled(!true);
    }

    public void Cancelar() {
        if (jIdLanc.getText().equals("")) {
            jStatusLanc.setText("ABERTO");
            jDataLanc.setCalendar(Calendar.getInstance());
            jIdInterno.setText("");
            jNomeInterno.setText("");
            jFotoInterno.setIcon(null);
            jSituacaoUnidade.setText("");
            jDataNascimento.setDate(null);
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
            jQualIdade.setText("");
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
            jHoraAcompanha.setText("");
            jTextoEvolucaoAdmissao.setText("DIGITE AQUI O TEXTO DA EVOLUÇÃO DA ADMISSÃO...");
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
            //
            jDataLanc.setEnabled(!true);
            jBtPesqInterno.setEnabled(!true);
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
            jTextoEvolucaoAdmissao.setEnabled(!true);
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
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            // EVOLUÇÃO        
            jIdEvolucao.setText("");
            jComboBoxStatusEvolucao.setSelectedItem("Em Andamento");
            jDataEvolucao.setDate(null);
            jComboBoxEncaminharSetorEvo.setSelectedItem("Selecione...");
            jDataEncaminhamentoEvo.setDate(null);
            jHoraEnvioEvo.setText("00:00:00");
            jEvolucao.setText("");
            //
            jBtNovaEvolucao.setEnabled(true);
            jBtAlterarEvolucao.setEnabled(!true);
            jBtExcluirEvolucao.setEnabled(!true);
            jBtSalvarEvolucao.setEnabled(!true);
            jBtCancelarEvolucao.setEnabled(!true);
            jBtAuditoriaEvolucao.setEnabled(!true);
            // PARECER PSICOLOGICO
            jDataParecer.setEnabled(!true);
            //
            jBtNovoParecer.setEnabled(true);
            jBtAlterarParecer.setEnabled(!true);
            jBtExcluirParecer.setEnabled(!true);
            jBtSalvarParecer.setEnabled(!true);
            jBtCancelarParecer.setEnabled(!true);
            jBtAuditoriaParecer.setEnabled(!true);
        } else {
            jDataLanc.setEnabled(!true);
            jBtPesqInterno.setEnabled(!true);
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
            jTextoEvolucaoAdmissao.setEnabled(!true);
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
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            // EVOLUÇÃO        
            jIdEvolucao.setText("");
            jComboBoxStatusEvolucao.setSelectedItem("Em Andamento");
            jDataEvolucao.setDate(null);
            jComboBoxEncaminharSetorEvo.setSelectedItem("Selecione...");
            jDataEncaminhamentoEvo.setDate(null);
            jHoraEnvioEvo.setText("00:00:00");
            jEvolucao.setText("");
            //
            jBtNovaEvolucao.setEnabled(true);
            jBtAlterarEvolucao.setEnabled(!true);
            jBtExcluirEvolucao.setEnabled(!true);
            jBtSalvarEvolucao.setEnabled(!true);
            jBtCancelarEvolucao.setEnabled(!true);
            jBtAuditoriaEvolucao.setEnabled(!true);
            // PARECER PSICOLOGICO
            jDataParecer.setEnabled(!true);
            //
            jBtNovoParecer.setEnabled(true);
            jBtAlterarParecer.setEnabled(!true);
            jBtExcluirParecer.setEnabled(!true);
            jBtSalvarParecer.setEnabled(!true);
            jBtCancelarParecer.setEnabled(!true);
            jBtAuditoriaParecer.setEnabled(!true);
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
            objAdmPsi.setIdLanc(Integer.parseInt(jIdLanc.getText()));
            control.finalizarAdmissaoPsi(objAdmPsi);
            controle.finalizarMovTec(objAdmPsi);
            objLog();
            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
            jStatusLanc.setText("FINALIZADO");
            JOptionPane.showMessageDialog(rootPane, "Registro FINALIZADO com sucesso !!!");
            //
            //Habiliar/Desabilitar Campos         
            jDataLanc.setEnabled(!true);
            jBtPesqInterno.setEnabled(!true);
            jHistoricoCriminal.setEnabled(!true);
            jDrogas.setEnabled(!true);
            jTranstornoMental.setEnabled(!true);
            jTextoEvolucaoAdmissao.setEnabled(!true);
            jParecerPsicologico.setEnabled(!true);
            jTratamentoAntriores.setEnabled(!true);
            jTentativaSuicidio.setEnabled(!true);
            jUsoMedicamentos.setEnabled(!true);
            jFamiliares.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
            jBtAuditoria.setEnabled(true);
        }
    }

    public void NovoParecer() {
        jCodigoParecer.setText("");
        jDataParecer.setCalendar(Calendar.getInstance());
        jNomeInternoParecer.setText(jNomeInterno.getText());
        jParecerPsicologico.setText("");
        //
        jDataParecer.setEnabled(true);
        jParecerPsicologico.setEnabled(true);
        // PARECER PSICOLOGICO
        jBtNovoParecer.setEnabled(!true);
        jBtAlterarParecer.setEnabled(!true);
        jBtExcluirParecer.setEnabled(!true);
        jBtSalvarParecer.setEnabled(true);
        jBtCancelarParecer.setEnabled(true);
        jBtAuditoriaParecer.setEnabled(!true);
        // MANUTENÇÃO
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        // EVOLUÇÃO
        jIdEvolucao.setText("");
        jComboBoxStatusEvolucao.setSelectedItem("Em Andamento");
        jDataEvolucao.setDate(null);
        jComboBoxEncaminharSetorEvo.setSelectedItem("Selecione...");
        jDataEncaminhamentoEvo.setDate(null);
        jHoraEnvioEvo.setText("00:00:00");
        jEvolucao.setText("");
        //
        jBtNovaEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
    }

    public void AlterarParecer() {
        jDataParecer.setEnabled(true);
        jParecerPsicologico.setEnabled(true);
        // PARECER PSICOLOGICO
        jBtNovoParecer.setEnabled(!true);
        jBtAlterarParecer.setEnabled(!true);
        jBtExcluirParecer.setEnabled(!true);
        jBtSalvarParecer.setEnabled(true);
        jBtCancelarParecer.setEnabled(true);
        jBtAuditoriaParecer.setEnabled(!true);
        // MANUTENÇÃO
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        // EVOLUÇÃO
        jBtNovaEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
    }

    public void ExcluirParecer() {
        jCodigoParecer.setText("");
        jDataParecer.setDate(null);
        jNomeInternoParecer.setText("");
        jParecerPsicologico.setText("");
        //
        jDataParecer.setEnabled(!true);
        jParecerPsicologico.setEnabled(!true);
        // PARECER PSICOLOGICO
        jBtNovoParecer.setEnabled(true);
        jBtAlterarParecer.setEnabled(!true);
        jBtExcluirParecer.setEnabled(!true);
        jBtSalvarParecer.setEnabled(!true);
        jBtCancelarParecer.setEnabled(!true);
        jBtAuditoriaParecer.setEnabled(!true);
        // MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        // EVOLUÇÃO
        jBtNovaEvolucao.setEnabled(true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(true);
    }

    public void SalvarParecer() {
        jCodigoParecer.setText("");
        jDataParecer.setDate(null);
        jNomeInternoParecer.setText("");
        jParecerPsicologico.setText("");
        //
        jDataParecer.setEnabled(!true);
        jParecerPsicologico.setEnabled(!true);
        // PARECER PSICOLOGICO
        jBtNovoParecer.setEnabled(true);
        jBtAlterarParecer.setEnabled(!true);
        jBtExcluirParecer.setEnabled(!true);
        jBtSalvarParecer.setEnabled(!true);
        jBtCancelarParecer.setEnabled(!true);
        jBtAuditoriaParecer.setEnabled(!true);
        // MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        // EVOLUÇÃO
        jBtNovaEvolucao.setEnabled(true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(true);
    }

    public void CancelarParecer() {
        jCodigoParecer.setText("");
        jDataParecer.setDate(null);
        jNomeInternoParecer.setText("");
        jParecerPsicologico.setText("");
        //
        jDataParecer.setEnabled(!true);
        jParecerPsicologico.setEnabled(!true);
        // PARECER PSICOLOGICO
        jBtNovoParecer.setEnabled(true);
        jBtAlterarParecer.setEnabled(!true);
        jBtExcluirParecer.setEnabled(!true);
        jBtSalvarParecer.setEnabled(!true);
        jBtCancelarParecer.setEnabled(!true);
        jBtAuditoriaParecer.setEnabled(!true);
        // MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        // EVOLUÇÃO
        jBtNovaEvolucao.setEnabled(true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(true);
    }

    public void buscarCodigoParecer() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PARECER_PSI");
            conecta.rs.last();
            jCodigoParecer.setText(conecta.rs.getString("IdParecer"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter código do parecer.");
        }
        conecta.desconecta();
    }

    public void NovaEvolucao() {
        //    
        jIdEvolucao.setText("");
        jComboBoxStatusEvolucao.setSelectedItem("Em Andamento");
        jDataEvolucao.setCalendar(Calendar.getInstance());
        jComboBoxEncaminharSetorEvo.setSelectedItem("Selecione...");
        jDataEncaminhamentoEvo.setCalendar(Calendar.getInstance());
        jHoraEnvioEvo.setText(jHoraSistema.getText());
        jEvolucao.setText("");
        //
        jComboBoxStatusEvolucao.setEnabled(true);
        jDataEvolucao.setEnabled(true);
        jComboBoxEncaminharSetorEvo.setEnabled(true);
        jDataEncaminhamentoEvo.setEnabled(true);
        jHoraEnvioEvo.setEnabled(true);
        jEvolucao.setEnabled(true);
        //
        jBtNovaEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(true);
        jBtCancelarEvolucao.setEnabled(true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        // MANUTENÇÃO
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        // PARECER
        jBtNovoParecer.setEnabled(!true);
        jBtAlterarParecer.setEnabled(!true);
        jBtExcluirParecer.setEnabled(!true);
        jBtSalvarParecer.setEnabled(!true);
        jBtCancelarParecer.setEnabled(!true);
        jBtAuditoriaParecer.setEnabled(!true);
    }

    public void AlterarEvolucao() {
        //
        jComboBoxStatusEvolucao.setEnabled(true);
        jDataEvolucao.setEnabled(true);
        jComboBoxEncaminharSetorEvo.setEnabled(true);
        jDataEncaminhamentoEvo.setEnabled(true);
        jHoraEnvioEvo.setText(jHoraSistema.getText());
        jHoraEnvioEvo.setEnabled(true);
        jEvolucao.setEnabled(true);
        //
        jBtNovaEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(true);
        jBtCancelarEvolucao.setEnabled(true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        // PARECER
        jBtNovoParecer.setEnabled(!true);
        jBtAlterarParecer.setEnabled(!true);
        jBtExcluirParecer.setEnabled(!true);
        jBtSalvarParecer.setEnabled(!true);
        jBtCancelarParecer.setEnabled(!true);
        jBtAuditoriaParecer.setEnabled(!true);
    }

    public void ExcluirEvolucao() {
        //    
        jIdEvolucao.setText("");
        jComboBoxStatusEvolucao.setSelectedItem("Em Andamento");
        jDataEvolucao.setDate(null);
        jComboBoxEncaminharSetorEvo.setSelectedItem("Selecione...");
        jDataEncaminhamentoEvo.setDate(null);
        jHoraEnvioEvo.setText("00:00:00");
        jEvolucao.setText("");
        //
        jComboBoxStatusEvolucao.setEnabled(!true);
        jDataEvolucao.setEnabled(!true);
        jComboBoxEncaminharSetorEvo.setEnabled(!true);
        jDataEncaminhamentoEvo.setEnabled(!true);
        jHoraEnvioEvo.setEnabled(!true);
        jEvolucao.setEnabled(!true);
        //
        jBtNovaEvolucao.setEnabled(true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        // PARECER
        jBtNovoParecer.setEnabled(true);
        jBtAlterarParecer.setEnabled(!true);
        jBtExcluirParecer.setEnabled(!true);
        jBtSalvarParecer.setEnabled(!true);
        jBtCancelarParecer.setEnabled(!true);
        jBtAuditoriaParecer.setEnabled(!true);
    }

    public void SalvarEvolucao() {
        jIdEvolucao.setText("");
        jComboBoxStatusEvolucao.setSelectedItem("Em Andamento");
        jDataEvolucao.setDate(null);
        jComboBoxEncaminharSetorEvo.setSelectedItem("Selecione...");
        jDataEncaminhamentoEvo.setDate(null);
        jHoraEnvioEvo.setText("00:00:00");
        jEvolucao.setText("");
        //
        jComboBoxStatusEvolucao.setEnabled(!true);
        jDataEvolucao.setEnabled(!true);
        jComboBoxEncaminharSetorEvo.setEnabled(!true);
        jDataEncaminhamentoEvo.setEnabled(!true);
        jHoraEnvioEvo.setEnabled(!true);
        jEvolucao.setEnabled(!true);
        //
        jBtNovaEvolucao.setEnabled(true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        // PARECER
        jBtNovoParecer.setEnabled(true);
        jBtAlterarParecer.setEnabled(!true);
        jBtExcluirParecer.setEnabled(!true);
        jBtSalvarParecer.setEnabled(!true);
        jBtCancelarParecer.setEnabled(!true);
        jBtAuditoriaParecer.setEnabled(!true);
    }

    public void CancelarEvolucao() {
        if (jIdEvolucao.getText().equals("")) {
            jIdEvolucao.setText("");
            jComboBoxStatusEvolucao.setSelectedItem("Em Andamento");
            jDataEvolucao.setDate(null);
            jComboBoxEncaminharSetorEvo.setSelectedItem("Selecione...");
            jDataEncaminhamentoEvo.setDate(null);
            jHoraEnvioEvo.setText("00:00:00");
            jEvolucao.setText("");
            //
            jComboBoxStatusEvolucao.setEnabled(!true);
            jDataEvolucao.setEnabled(!true);
            jComboBoxEncaminharSetorEvo.setEnabled(!true);
            jDataEncaminhamentoEvo.setEnabled(!true);
            jHoraEnvioEvo.setEnabled(!true);
            jEvolucao.setEnabled(!true);
            //
            jBtNovaEvolucao.setEnabled(true);
            jBtAlterarEvolucao.setEnabled(!true);
            jBtExcluirEvolucao.setEnabled(!true);
            jBtSalvarEvolucao.setEnabled(!true);
            jBtCancelarEvolucao.setEnabled(!true);
            jBtAuditoriaEvolucao.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            // PARECER
            jBtNovoParecer.setEnabled(true);
            jBtAlterarParecer.setEnabled(!true);
            jBtExcluirParecer.setEnabled(!true);
            jBtSalvarParecer.setEnabled(!true);
            jBtCancelarParecer.setEnabled(!true);
            jBtAuditoriaParecer.setEnabled(!true);
        } else {
            jComboBoxStatusEvolucao.setEnabled(!true);
            jDataEvolucao.setEnabled(!true);
            jComboBoxEncaminharSetorEvo.setEnabled(!true);
            jDataEncaminhamentoEvo.setEnabled(!true);
            jHoraEnvioEvo.setEnabled(!true);
            jEvolucao.setEnabled(!true);
            //
            jBtNovaEvolucao.setEnabled(true);
            jBtAlterarEvolucao.setEnabled(!true);
            jBtExcluirEvolucao.setEnabled(!true);
            jBtSalvarEvolucao.setEnabled(!true);
            jBtCancelarEvolucao.setEnabled(!true);
            jBtAuditoriaEvolucao.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            // PARECER
            jBtNovoParecer.setEnabled(true);
            jBtAlterarParecer.setEnabled(!true);
            jBtExcluirParecer.setEnabled(!true);
            jBtSalvarParecer.setEnabled(!true);
            jBtCancelarParecer.setEnabled(!true);
            jBtAuditoriaParecer.setEnabled(!true);
        }
    }

    public void buscarID() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ADMISSAOPSI");
            conecta.rs.last();
            jIdLanc.setText(conecta.rs.getString("IdLanc"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível pegar o ID do lançamento");
        }
        conecta.desconecta();
    }

    public void buscarCodEvolucao() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM EVOLUCAOPSICOLOGICA");
            conecta.rs.last();
            jIdEvolucao.setText(conecta.rs.getString("IdEvolucao"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível pegar o código da evolução");
        }
    }

    //
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
                dados.add(new Object[]{conecta.rs.getInt("IdLanc"), dataEntrada, conecta.rs.getString("StatusLanc"), conecta.rs.getString("NomeInternoCrc"), conecta.rs.getString("HistoricoCriminal")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaAdmissaoPsicologica.setModel(modelo);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(0).setResizable(false);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(1).setResizable(false);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(2).setResizable(false);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(3).setPreferredWidth(335);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(3).setResizable(false);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(4).setPreferredWidth(335);
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
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(0).setResizable(false);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(1).setResizable(false);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(2).setResizable(false);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(3).setPreferredWidth(335);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(3).setResizable(false);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(4).setPreferredWidth(335);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(4).setResizable(false);
        jTabelaAdmissaoPsicologica.getTableHeader().setReorderingAllowed(false);
        jTabelaAdmissaoPsicologica.setAutoResizeMode(jTabelaAdmissaoPsicologica.AUTO_RESIZE_OFF);
        jTabelaAdmissaoPsicologica.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void preencherEvolucaoPsicologia(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Evolução"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                // Formatar a data Entrada
                dataEvolucao = conecta.rs.getString("DataEvolucao");
                String diae = dataEvolucao.substring(8, 10);
                String mese = dataEvolucao.substring(5, 7);
                String anoe = dataEvolucao.substring(0, 4);
                dataEvolucao = diae + "/" + mese + "/" + anoe;
                dados.add(new Object[]{conecta.rs.getInt("IdEvolucao"), dataEvolucao, conecta.rs.getString("StatusEvo"), conecta.rs.getString("Historico")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaEvolucaoPsicologia.setModel(modelo);
        jTabelaEvolucaoPsicologia.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaEvolucaoPsicologia.getColumnModel().getColumn(0).setResizable(false);
        jTabelaEvolucaoPsicologia.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaEvolucaoPsicologia.getColumnModel().getColumn(1).setResizable(false);
        jTabelaEvolucaoPsicologia.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaEvolucaoPsicologia.getColumnModel().getColumn(2).setResizable(false);
        jTabelaEvolucaoPsicologia.getColumnModel().getColumn(3).setPreferredWidth(380);
        jTabelaEvolucaoPsicologia.getColumnModel().getColumn(3).setResizable(false);
        jTabelaEvolucaoPsicologia.getTableHeader().setReorderingAllowed(false);
        jTabelaEvolucaoPsicologia.setAutoResizeMode(jTabelaEvolucaoPsicologia.AUTO_RESIZE_OFF);
        jTabelaEvolucaoPsicologia.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaEvolucao();
        conecta.desconecta();
    }

    public void alinharCamposTabelaEvolucao() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaEvolucaoPsicologia.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaEvolucaoPsicologia.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaEvolucaoPsicologia.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }

    public void limparTabelaEvolucao() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Nome do Interno", "Evolução"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaEvolucaoPsicologia.setModel(modelo);
        jTabelaEvolucaoPsicologia.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaEvolucaoPsicologia.getColumnModel().getColumn(0).setResizable(false);
        jTabelaEvolucaoPsicologia.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaEvolucaoPsicologia.getColumnModel().getColumn(1).setResizable(false);
        jTabelaEvolucaoPsicologia.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaEvolucaoPsicologia.getColumnModel().getColumn(2).setResizable(false);
        jTabelaEvolucaoPsicologia.getColumnModel().getColumn(3).setPreferredWidth(380);
        jTabelaEvolucaoPsicologia.getColumnModel().getColumn(3).setResizable(false);
        jTabelaEvolucaoPsicologia.getTableHeader().setReorderingAllowed(false);
        jTabelaEvolucaoPsicologia.setAutoResizeMode(jTabelaEvolucaoPsicologia.AUTO_RESIZE_OFF);
        jTabelaEvolucaoPsicologia.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void preencherParecerPsicologia(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Nome do Interno", "Parecer Psicológico"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                // Formatar a data Entrada
                dataEvolucao = conecta.rs.getString("DataParecer");
                String diae = dataEvolucao.substring(8, 10);
                String mese = dataEvolucao.substring(5, 7);
                String anoe = dataEvolucao.substring(0, 4);
                dataEvolucao = diae + "/" + mese + "/" + anoe;
                dados.add(new Object[]{conecta.rs.getInt("IdParecer"), dataEvolucao, conecta.rs.getString("NomeInternoCrc"), conecta.rs.getString("ParecerPsicologico")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaParecerPsicologico.setModel(modelo);
        jTabelaParecerPsicologico.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaParecerPsicologico.getColumnModel().getColumn(0).setResizable(false);
        jTabelaParecerPsicologico.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaParecerPsicologico.getColumnModel().getColumn(1).setResizable(false);
        jTabelaParecerPsicologico.getColumnModel().getColumn(2).setPreferredWidth(300);
        jTabelaParecerPsicologico.getColumnModel().getColumn(2).setResizable(false);
        jTabelaParecerPsicologico.getColumnModel().getColumn(3).setPreferredWidth(200);
        jTabelaParecerPsicologico.getColumnModel().getColumn(3).setResizable(false);
        jTabelaParecerPsicologico.getTableHeader().setReorderingAllowed(false);
        jTabelaParecerPsicologico.setAutoResizeMode(jTabelaParecerPsicologico.AUTO_RESIZE_OFF);
        jTabelaParecerPsicologico.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharTabelaParecerPsicologico();
        conecta.desconecta();
    }

    public void limparTabelaParecer() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Nome do Interno", "Parecer Psicológico"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaParecerPsicologico.setModel(modelo);
        jTabelaParecerPsicologico.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaParecerPsicologico.getColumnModel().getColumn(0).setResizable(false);
        jTabelaParecerPsicologico.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaParecerPsicologico.getColumnModel().getColumn(1).setResizable(false);
        jTabelaParecerPsicologico.getColumnModel().getColumn(2).setPreferredWidth(300);
        jTabelaParecerPsicologico.getColumnModel().getColumn(2).setResizable(false);
        jTabelaParecerPsicologico.getColumnModel().getColumn(3).setPreferredWidth(200);
        jTabelaParecerPsicologico.getColumnModel().getColumn(3).setResizable(false);
        jTabelaParecerPsicologico.getTableHeader().setReorderingAllowed(false);
        jTabelaParecerPsicologico.setAutoResizeMode(jTabelaParecerPsicologico.AUTO_RESIZE_OFF);
        jTabelaParecerPsicologico.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharTabelaParecerPsicologico() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaParecerPsicologico.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaParecerPsicologico.getColumnModel().getColumn(1).setCellRenderer(centralizado);
    }

    public void verificarEvolucao() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM EVOLUCAOPSICOLOGICA WHERE IdLanc='" + jIdLanc.getText() + "'");
            conecta.rs.first();
            idAtendimento = conecta.rs.getString("IdLanc");
            if (jIdLanc.getText().equals(idAtendimento)) {
                JOptionPane.showMessageDialog(rootPane, "Antes de excluir esse Lançamento, será necessário excluir primeiro(a)s\nevolução(ões) relacionada (as) a esse registro.");
            }
            conecta.desconecta();
        } catch (Exception e) {
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objAdmPsi.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                control.excluirAdmissaoPsi(objAdmPsi);
                objAdmPsi.setNomeInterno(jNomeInterno.getText());;
                objAdmPsi.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                controle.excluirMovTec(objAdmPsi);
                objLog();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                Excluir();
            }
        }
    }

    public void preencherComboBoxDepartamento() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM DEPARTAMENTOS ORDER BY NomeDepartamento");
            conecta.rs.first();
            do {
                jComboBoxDepartamentoEncaminha.addItem(conecta.rs.getString("NomeDepartamento"));
                jComboBoxEncaminharSetorEvo.addItem(conecta.rs.getString("NomeDepartamento"));
            } while (conecta.rs.next());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos!!!\nERRO: " + e);
        }
        conecta.desconecta();
    }

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jIdLanc.getText()));
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
        objLogSys.setIdLancMov(Integer.valueOf(jCodigoParecer.getText()));
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
                    + "WHERE IdInternoCrc='" + jIdInterno.getText() + "' "
                    + "AND Atendido='" + opcao + "'");
            conecta.rs.first();
            codigoInternoAtend = conecta.rs.getString("IdInternoCrc");
            codigoDepartamentoPSI = conecta.rs.getInt("IdDepartamento");
            atendido = conecta.rs.getString("Atendido");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void pesquisarInternoExistente() {
        bloquearCampos();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ADMISSAOPSI "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ADMISSAOPSI.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE ADMISSAOPSI.IdInternoCrc='" + jIdInterno.getText() + "'");
            conecta.rs.first();
            jIdLanc.setText(String.valueOf(conecta.rs.getInt("IdLanc")));
            jStatusLanc.setText(conecta.rs.getString("StatusLanc"));
            jDataLanc.setDate(conecta.rs.getDate("DataLanc"));
            jIdInterno.setText(conecta.rs.getString("IdInternoCrc"));
            jNomeInterno.setText(conecta.rs.getString("NomeInternoCrc"));
            jDataNascimento.setDate(conecta.rs.getDate("DataNasciCrc"));
            jSituacaoUnidade.setText(conecta.rs.getString("SituacaoCrc"));
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
            jTextoEvolucaoAdmissao.setText(conecta.rs.getString("Encaminhamento"));
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
        // PARECER PSICOLOGICO
        preencherParecerPsicologia("SELECT * FROM PARECER_PSI INNER "
                + "JOIN ADMISSAOPSI "
                + "ON PARECER_PSI.IdLanc=ADMISSAOPSI.IdLanc "
                + "INNER JOIN PRONTUARIOSCRC "
                + "ON PARECER_PSI.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                + "WHERE PARECER_PSI.IdLanc='" + jIdLanc.getText() + "'");
        // EVOLUÇÃO PSICOLOGICA
        jIdEvolucao.setText("");
        jComboBoxStatusEvolucao.setSelectedItem("Em Andamento");
        jDataEvolucao.setDate(null);
        jComboBoxEncaminharSetorEvo.setSelectedItem("Selecione...");
        jDataEncaminhamentoEvo.setDate(null);
        jHoraEnvioEvo.setText("");
        jEvolucao.setText("");
        preencherEvolucaoPsicologia("SELECT * FROM EVOLUCAOPSICOLOGICA "
                + "INNER JOIN PRONTUARIOSCRC "
                + "ON EVOLUCAOPSICOLOGICA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                + "WHERE IdLanc='" + jIdLanc.getText() + "'");
    }

    // VERIFICAR SE A EVOLUÇÃO FAZ PARTE DA ADMISSÃO, OU SEJA, QUANDO É FEITA A ADMISSÃO DO INTERNO
    // É GRAVADO AUTOMÁTICAMETE UMA EVOLUÇÃO PARA O INTERNO.
    public void verificarEvolucaoAdmissao() {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM EVOLUCAOPSICOLOGICA "
                    + "WHERE IdLanc='" + jIdLanc.getText() + "' "
                    + "AND IdEvolucao='" + jIdEvolucao.getText() + "'");
            conecta.rs.first();
            admEvolucao = conecta.rs.getString("AdmEvo");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
