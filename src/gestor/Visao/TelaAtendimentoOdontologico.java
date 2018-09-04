/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleAtendimentoOdontologia;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControleMovOdontologia;
import gestor.Controle.ControleOdontograma;
import gestor.Controle.ControlePrescricaoMedicaOdontologica;
import gestor.Controle.ControlePrescricaoMedicaPsiquiatrica;
import gestor.Controle.ControleProcedimentoOdonto;
import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.LimiteDigitos;
import gestor.Dao.LimiteDigitosAlfa;
import gestor.Dao.ModeloTabela;
import gestor.Modelo.AtendimentoOdontologico;
import gestor.Modelo.LogSistema;
import gestor.Modelo.Odontograma;
import gestor.Modelo.PrescricaoMedicaPsiquiatrica;
import gestor.Modelo.PrescricaoMedicamentoOdontologica;
import gestor.Modelo.ProcedimentoOdontologico;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaModuloOdontologia.codAbrirODON;
import static gestor.Visao.TelaModuloOdontologia.codAlterarODON;
import static gestor.Visao.TelaModuloOdontologia.codConsultarODON;
import static gestor.Visao.TelaModuloOdontologia.codExcluirODON;
import static gestor.Visao.TelaModuloOdontologia.codGravarODON;
import static gestor.Visao.TelaModuloOdontologia.codIncluirODON;
import static gestor.Visao.TelaModuloOdontologia.codUserAcessoODON;
import static gestor.Visao.TelaModuloOdontologia.codigoGrupoODON;
import static gestor.Visao.TelaModuloOdontologia.codigoUserGroupODON;
import static gestor.Visao.TelaModuloOdontologia.codigoUserODON;
import static gestor.Visao.TelaModuloOdontologia.nomeGrupoODON;
import static gestor.Visao.TelaModuloOdontologia.nomeTelaODON;
import static gestor.Visao.TelaModuloOdontologia.telaAtendimentoInternoEvolucao_ODON;
import static gestor.Visao.TelaModuloOdontologia.telaAtendimentoInternoManu_ODON;
import static gestor.Visao.TelaModuloOdontologia.telaAtendimentoInternosPrescricao_ODON;
import java.awt.Color;
import java.awt.Image;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.ListSelectionModel;
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
 * @author user
 */
public class TelaAtendimentoOdontologico extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AtendimentoOdontologico objAtendOdonto = new AtendimentoOdontologico();
    ControleAtendimentoOdontologia control = new ControleAtendimentoOdontologia();
    //
    ControleMovOdontologia controle = new ControleMovOdontologia();
    ProcedimentoOdontologico objProcedOdonto = new ProcedimentoOdontologico();
    //
    ControleProcedimentoOdonto controlar = new ControleProcedimentoOdonto();
    PrescricaoMedicamentoOdontologica objPrescOdonto = new PrescricaoMedicamentoOdontologica();
    ControlePrescricaoMedicaOdontologica controlePres = new ControlePrescricaoMedicaOdontologica();
    //
    PrescricaoMedicaPsiquiatrica objPrescricao = new PrescricaoMedicaPsiquiatrica();
    ControlePrescricaoMedicaPsiquiatrica controlePrescricao = new ControlePrescricaoMedicaPsiquiatrica();
    //
    Odontograma objOdonto = new Odontograma();
    ControleOdontograma controlOdontograma = new ControleOdontograma();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela = "Odontologia:Atendimento de Internos:Manutenção";
    String nomeModuloTela2 = "Odontologia:Evolução de Internos:Internos";
    String nomeModuloTela3 = "Odontologia:Prescrição de Medicamentos:Internos";
    String statusMov;
    String horaMov;
    String dataModFinal;
    //
    int flag, acao;
    String dataInicial, dataFinal, dataEntrada, dataProcedimento;
    String caminho;
    String deptoTecnico = "ODONTOLOGIA";
    public static String idItem;
    int count = 0;
    int tipoPres = 2; // TIPO DE PRESCRIÇÃO 0 - MEDICA, 1 - PSIQUIATRICA, 2 - ODONTOLOGIA    
    String idItemPresq; // CÓDIGO DA PRESCRIÇÃO ODONTOLOGICA
    int corDenteVermelho;
    int corDenteVerde;
    int corDenteAzul;
    String tipoCorDente;
    String codigoProcedimento;
    String dataOdonto;
    Date date = null;
    // EM FASE DE TESTE INICIO (01/09/2017)
    String caminhoIcon1 = "C:\\Users\\ronaldo.silva7\\Documents\\ProjetosNetBeans\\GestorPrisional\\build\\classes\\gestor\\Imagens\\ModeloDente2.jpg";
    String caminhoIcon2 = "C:\\Users\\ronaldo.silva7\\Documents\\ProjetosNetBeans\\GestorPrisional\\build\\classes\\gestor\\Imagens\\ModeloDente10.jpg";

    /**
     * Creates new form TelaAtendimentoOdontologico
     */
    public TelaAtendimentoOdontologico() {
        initComponents();
        formatarCampos();
        corCampo();
        tabelaOdontograma();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel31 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        Listagem = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jPesqNomeInternoOdonto = new javax.swing.JTextField();
        jBtPesqNomeInterno = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        jIDPesqAtend = new javax.swing.JTextField();
        jBtIdPesqAtend = new javax.swing.JButton();
        jLabel48 = new javax.swing.JLabel();
        jDataInicial = new com.toedter.calendar.JDateChooser();
        jLabel49 = new javax.swing.JLabel();
        jDataFinal = new com.toedter.calendar.JDateChooser();
        jBtPesqData = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabelaOdontologia = new javax.swing.JTable();
        jPanel31 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        Admissao = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jBtNovo = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jBtFinalizar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jBtAuditoriaOdonto = new javax.swing.JButton();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        DadosConsulta = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jComboBoxAlegria = new javax.swing.JComboBox();
        jComboBoxMedicacao = new javax.swing.JComboBox();
        jComboBoxTratamentoMedico = new javax.swing.JComboBox();
        jComboBoxTipoAtendimento = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jAfirmacao3 = new javax.swing.JTextField();
        jAfirmacao2 = new javax.swing.JTextField();
        jAfirmacao1 = new javax.swing.JTextField();
        jQueixaPrincipal = new javax.swing.JTextField();
        jComboBoxFumante = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jIDLanc = new javax.swing.JTextField();
        jStatusLanc = new javax.swing.JTextField();
        jDataLanc = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jIDInterno = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jNomeInterno = new javax.swing.JTextField();
        jBtPesqInterno = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jFotoInternoOdonto = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jComboBoxGestante = new javax.swing.JComboBox();
        jLabel85 = new javax.swing.JLabel();
        jTempoGestacao = new javax.swing.JSpinner();
        jScrollPane5 = new javax.swing.JScrollPane();
        jObservacao = new javax.swing.JTextArea();
        Patologias = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jComboBoxHiv = new javax.swing.JComboBox();
        jComboBoxCicatrizacao = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jComboBoxAsma = new javax.swing.JComboBox();
        jComboBoxHepatite = new javax.swing.JComboBox();
        jComboBoxFebre = new javax.swing.JComboBox();
        jComboBoxDiabetes = new javax.swing.JComboBox();
        jLabel22 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jComboBoxCardiaco = new javax.swing.JComboBox();
        jComboBoxTensao = new javax.swing.JComboBox();
        jComboBoxHepatico = new javax.swing.JComboBox();
        jComboBoxEpilepsia = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jComboBoxInternacao = new javax.swing.JComboBox();
        jLabel23 = new javax.swing.JLabel();
        jComboBoxDisturbios = new javax.swing.JComboBox();
        jLabel24 = new javax.swing.JLabel();
        jComboBoxEndocardite = new javax.swing.JComboBox();
        jLabel26 = new javax.swing.JLabel();
        jComboBoxRenal = new javax.swing.JComboBox();
        jLabel29 = new javax.swing.JLabel();
        jComboBoxCirurgia = new javax.swing.JComboBox();
        jLabel81 = new javax.swing.JLabel();
        jComboBoxSifilis = new javax.swing.JComboBox();
        jLabel82 = new javax.swing.JLabel();
        jComboBoxTuberculose = new javax.swing.JComboBox();
        jLabel84 = new javax.swing.JLabel();
        jComboBoxOutras = new javax.swing.JComboBox();
        jLabel86 = new javax.swing.JLabel();
        jQualOutraDoenca = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextoDoenca = new javax.swing.JTextArea();
        Odontograma = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
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
        jBt18 = new javax.swing.JButton();
        jBt17 = new javax.swing.JButton();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTabelaOdontograma = new javax.swing.JTable();
        jPanel23 = new javax.swing.JPanel();
        jLabel98 = new javax.swing.JLabel();
        jDataOdontograma = new com.toedter.calendar.JDateChooser();
        jLabel33 = new javax.swing.JLabel();
        jComboBoxTipoProcedimento = new javax.swing.JComboBox();
        jLabel78 = new javax.swing.JLabel();
        jComboBoxFacesDente = new javax.swing.JComboBox();
        jLabel79 = new javax.swing.JLabel();
        jNumeroDente = new javax.swing.JFormattedTextField();
        jLabel80 = new javax.swing.JLabel();
        jCheckBoxVermelho = new javax.swing.JCheckBox();
        jCheckBoxVerde = new javax.swing.JCheckBox();
        jCheckBoxAzul = new javax.swing.JCheckBox();
        jLabel87 = new javax.swing.JLabel();
        jPlanoTratamento = new javax.swing.JTextField();
        jBt16 = new javax.swing.JButton();
        jBt15 = new javax.swing.JButton();
        jBt12 = new javax.swing.JButton();
        jBt11 = new javax.swing.JButton();
        jBt14 = new javax.swing.JButton();
        jBt13 = new javax.swing.JButton();
        jBt46 = new javax.swing.JButton();
        jBt44 = new javax.swing.JButton();
        jBt41 = new javax.swing.JButton();
        jBt42 = new javax.swing.JButton();
        jBt45 = new javax.swing.JButton();
        jBt48 = new javax.swing.JButton();
        jBt47 = new javax.swing.JButton();
        jBt43 = new javax.swing.JButton();
        jBt23 = new javax.swing.JButton();
        jBt25 = new javax.swing.JButton();
        jBt28 = new javax.swing.JButton();
        jBt27 = new javax.swing.JButton();
        jBt24 = new javax.swing.JButton();
        jBt21 = new javax.swing.JButton();
        jBt22 = new javax.swing.JButton();
        jBt26 = new javax.swing.JButton();
        jBt33 = new javax.swing.JButton();
        jBt35 = new javax.swing.JButton();
        jBt36 = new javax.swing.JButton();
        jBt32 = new javax.swing.JButton();
        jBt37 = new javax.swing.JButton();
        jBt38 = new javax.swing.JButton();
        jBt31 = new javax.swing.JButton();
        jBt34 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jBtAdicionar = new javax.swing.JButton();
        jBtRemover = new javax.swing.JButton();
        Continuacao = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jDataEvolucao = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        jIdEvolucao = new javax.swing.JTextField();
        jNomeInternoEvolucao = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jEvolucao = new javax.swing.JTextArea();
        jPanel9 = new javax.swing.JPanel();
        jBtNovoEvolucao = new javax.swing.JButton();
        jBtAlterarEvolucao = new javax.swing.JButton();
        jBtExcluirEvolucao = new javax.swing.JButton();
        jBtSalvarEvolucao = new javax.swing.JButton();
        jBtCancelarEvolucao = new javax.swing.JButton();
        jBtImpressaoEvolucao = new javax.swing.JButton();
        jBtAuditoriaEvolucao = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTabelaProcedimentos = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jDataPrescricao = new com.toedter.calendar.JDateChooser();
        jLabel38 = new javax.swing.JLabel();
        jIdPrescricao = new javax.swing.JTextField();
        jNomeInternoPrescricao = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jPrescricaoOdontologia = new javax.swing.JTextArea();
        jPanel20 = new javax.swing.JPanel();
        jBtNovoPrescricao = new javax.swing.JButton();
        jBtAlterarPrescricao = new javax.swing.JButton();
        jBtExcluirPrescricao = new javax.swing.JButton();
        jBtSalvarPrescricao = new javax.swing.JButton();
        jBtCancelarPrescricao = new javax.swing.JButton();
        jBtImpressaoPrescricao = new javax.swing.JButton();
        jBtAuditoriaPrescricao = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTabelaPrescricao = new javax.swing.JTable();

        jLabel31.setText("jLabel31");

        jLabel36.setText("jLabel36");

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Atendimento Odontologico {OD} :::...");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel34.setText("Nome do Interno:");

        jPesqNomeInternoOdonto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqNomeInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqNomeInterno.setContentAreaFilled(false);
        jBtPesqNomeInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqNomeInternoActionPerformed(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel35.setText("Código:");

        jIDPesqAtend.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIDPesqAtend.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtIdPesqAtend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtIdPesqAtend.setContentAreaFilled(false);
        jBtIdPesqAtend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtIdPesqAtendActionPerformed(evt);
            }
        });

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel48.setText("Data Inicial:");

        jDataInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel49.setText("Data Final:");

        jDataFinal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqData.setContentAreaFilled(false);
        jBtPesqData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqDataActionPerformed(evt);
            }
        });

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox1.setText("Todos");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jIDPesqAtend, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtIdPesqAtend, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel48)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel49)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jBtPesqData, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jPesqNomeInternoOdonto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1)
                .addGap(22, 22, 22))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtIdPesqAtend)
                    .addComponent(jIDPesqAtend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35)
                    .addComponent(jBtPesqData)
                    .addComponent(jDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49)
                    .addComponent(jDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtPesqNomeInterno)
                    .addComponent(jPesqNomeInternoOdonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34)
                    .addComponent(jCheckBox1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaOdontologia.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaOdontologia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Data", "Status", "Nome Completo do Interno", "Tipo de Atendimento"
            }
        ));
        jTabelaOdontologia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaOdontologiaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTabelaOdontologia);
        if (jTabelaOdontologia.getColumnModel().getColumnCount() > 0) {
            jTabelaOdontologia.getColumnModel().getColumn(0).setMinWidth(80);
            jTabelaOdontologia.getColumnModel().getColumn(0).setMaxWidth(80);
            jTabelaOdontologia.getColumnModel().getColumn(1).setMinWidth(80);
            jTabelaOdontologia.getColumnModel().getColumn(1).setMaxWidth(80);
            jTabelaOdontologia.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaOdontologia.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaOdontologia.getColumnModel().getColumn(3).setMinWidth(335);
            jTabelaOdontologia.getColumnModel().getColumn(3).setMaxWidth(335);
            jTabelaOdontologia.getColumnModel().getColumn(4).setMinWidth(200);
            jTabelaOdontologia.getColumnModel().getColumn(4).setMaxWidth(200);
        }

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

        javax.swing.GroupLayout ListagemLayout = new javax.swing.GroupLayout(Listagem);
        Listagem.setLayout(ListagemLayout);
        ListagemLayout.setHorizontalGroup(
            ListagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ListagemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ListagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ListagemLayout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(ListagemLayout.createSequentialGroup()
                        .addGroup(ListagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        ListagemLayout.setVerticalGroup(
            ListagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ListagemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ListagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("Listagem", Listagem);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

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

        jBtFinalizar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtFinalizar.setForeground(new java.awt.Color(255, 0, 0));
        jBtFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/accept.png"))); // NOI18N
        jBtFinalizar.setToolTipText("Finalizar");
        jBtFinalizar.setEnabled(false);
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

        jBtAuditoriaOdonto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtAuditoriaOdonto.setForeground(new java.awt.Color(0, 0, 255));
        jBtAuditoriaOdonto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaOdonto.setToolTipText("Auditoria");
        jBtAuditoriaOdonto.setContentAreaFilled(false);
        jBtAuditoriaOdonto.setEnabled(false);
        jBtAuditoriaOdonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaOdontoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jBtNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSair)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 185, Short.MAX_VALUE)
                .addComponent(jBtFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAuditoriaOdonto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBtAuditoriaOdonto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtFinalizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtNovo)
                    .addComponent(jBtAlterar)
                    .addComponent(jBtExcluir)
                    .addComponent(jBtSalvar)
                    .addComponent(jBtCancelar)
                    .addComponent(jBtSair))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterar, jBtCancelar, jBtExcluir, jBtNovo, jBtSair, jBtSalvar});

        jTabbedPane3.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Tipo Atendimento:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Está em tratamento médico?");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Está usando medicação?");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Alergia:");

        jComboBoxAlegria.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxAlegria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Não sei", "Sim" }));
        jComboBoxAlegria.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxAlegria.setEnabled(false);

        jComboBoxMedicacao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxMedicacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxMedicacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxMedicacao.setEnabled(false);

        jComboBoxTratamentoMedico.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTratamentoMedico.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxTratamentoMedico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTratamentoMedico.setEnabled(false);

        jComboBoxTipoAtendimento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTipoAtendimento.setForeground(new java.awt.Color(255, 0, 0));
        jComboBoxTipoAtendimento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Consulta", "Urgência", "Tratamento", "Manutenção" }));
        jComboBoxTipoAtendimento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTipoAtendimento.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Queixa principal/Motivo da consulta:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Qual?");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Qual?");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Qual?");

        jAfirmacao3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAfirmacao3.setEnabled(false);

        jAfirmacao2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAfirmacao2.setEnabled(false);

        jAfirmacao1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAfirmacao1.setEnabled(false);

        jQueixaPrincipal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQueixaPrincipal.setEnabled(false);

        jComboBoxFumante.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxFumante.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxFumante.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxFumante.setEnabled(false);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Fumante:");

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel40.setText("Observação:");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados Admissionais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Status");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Dt. Atendimento");

        jIDLanc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIDLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIDLanc.setEnabled(false);

        jStatusLanc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jStatusLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jStatusLanc.setEnabled(false);

        jDataLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataLanc.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Código");

        jIDInterno.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIDInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIDInterno.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Nome Completo do Interno");

        jNomeInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInterno.setEnabled(false);

        jBtPesqInterno.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtPesqInterno.setForeground(new java.awt.Color(255, 0, 0));
        jBtPesqInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqInterno.setToolTipText("Pesquisar");
        jBtPesqInterno.setContentAreaFilled(false);
        jBtPesqInterno.setEnabled(false);
        jBtPesqInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqInternoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jIDLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jStatusLanc))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDataLanc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(jNomeInterno)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jIDInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jIDInterno, jIDLanc});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jStatusLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIDLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jIDInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBtPesqInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Foto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoOdonto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoOdonto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel83.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel83.setText("Gestante:");

        jComboBoxGestante.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxGestante.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Não sei", "Sim" }));
        jComboBoxGestante.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxGestante.setEnabled(false);

        jLabel85.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel85.setText("Tempo:");

        jTempoGestacao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTempoGestacao.setToolTipText("Tempo de Gestação em semanas");
        jTempoGestacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTempoGestacao.setEnabled(false);

        jObservacao.setColumns(20);
        jObservacao.setRows(5);
        jObservacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jObservacao.setEnabled(false);
        jScrollPane5.setViewportView(jObservacao);

        javax.swing.GroupLayout DadosConsultaLayout = new javax.swing.GroupLayout(DadosConsulta);
        DadosConsulta.setLayout(DadosConsultaLayout);
        DadosConsultaLayout.setHorizontalGroup(
            DadosConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DadosConsultaLayout.createSequentialGroup()
                .addGroup(DadosConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(DadosConsultaLayout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jLabel40)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DadosConsultaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(DadosConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DadosConsultaLayout.createSequentialGroup()
                                .addGroup(DadosConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(DadosConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, DadosConsultaLayout.createSequentialGroup()
                                        .addGroup(DadosConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBoxAlegria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jComboBoxMedicacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jComboBoxTratamentoMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(DadosConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(DadosConsultaLayout.createSequentialGroup()
                                                .addComponent(jLabel13)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jAfirmacao3, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(DadosConsultaLayout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jAfirmacao2, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(DadosConsultaLayout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jAfirmacao1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jQueixaPrincipal, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(DadosConsultaLayout.createSequentialGroup()
                                        .addComponent(jComboBoxTipoAtendimento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxFumante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel83)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxGestante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel85)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTempoGestacao, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1))))
                            .addGroup(DadosConsultaLayout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(13, 13, 13))
        );

        DadosConsultaLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jComboBoxAlegria, jComboBoxMedicacao, jComboBoxTratamentoMedico});

        DadosConsultaLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jAfirmacao1, jAfirmacao2, jAfirmacao3});

        DadosConsultaLayout.setVerticalGroup(
            DadosConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DadosConsultaLayout.createSequentialGroup()
                .addGroup(DadosConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DadosConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel6)
                    .addComponent(jComboBoxTipoAtendimento, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxFumante, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addGroup(DadosConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel83)
                        .addComponent(jComboBoxGestante, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel85)
                        .addComponent(jTempoGestacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DadosConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jQueixaPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DadosConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel8)
                    .addComponent(jComboBoxTratamentoMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jAfirmacao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(DadosConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel10)
                    .addComponent(jComboBoxMedicacao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jAfirmacao2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DadosConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel12)
                    .addComponent(jComboBoxAlegria, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jAfirmacao3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DadosConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel40)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        DadosConsultaLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jAfirmacao1, jAfirmacao2, jAfirmacao3});

        jTabbedPane3.addTab("Dados da Consulta", DadosConsulta);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Patologias", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("HIV/DST:");

        jComboBoxHiv.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxHiv.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Não sei", "Sim" }));
        jComboBoxHiv.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxHiv.setEnabled(false);

        jComboBoxCicatrizacao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxCicatrizacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Não sei", "Sim" }));
        jComboBoxCicatrizacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxCicatrizacao.setEnabled(false);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Febre Reumática:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Asma:");

        jComboBoxAsma.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxAsma.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Não sei", "Sim" }));
        jComboBoxAsma.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxAsma.setEnabled(false);

        jComboBoxHepatite.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxHepatite.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Não sei", "Sim" }));
        jComboBoxHepatite.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxHepatite.setEnabled(false);

        jComboBoxFebre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxFebre.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Não sei", "Sim" }));
        jComboBoxFebre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxFebre.setEnabled(false);

        jComboBoxDiabetes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDiabetes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Não sei", "Sim" }));
        jComboBoxDiabetes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDiabetes.setEnabled(false);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("Cicatrização ruim:");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setText("Problema hepático:");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setText("Problema Cardiaco:");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel28.setText("Tensão arterial:");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Diabetes:");

        jComboBoxCardiaco.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxCardiaco.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Não sei", "Sim" }));
        jComboBoxCardiaco.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxCardiaco.setEnabled(false);

        jComboBoxTensao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTensao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Não sei", "Sim" }));
        jComboBoxTensao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTensao.setEnabled(false);

        jComboBoxHepatico.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxHepatico.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Não sei", "Sim" }));
        jComboBoxHepatico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxHepatico.setEnabled(false);

        jComboBoxEpilepsia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxEpilepsia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Não sei", "Sim" }));
        jComboBoxEpilepsia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxEpilepsia.setEnabled(false);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Hepatite:");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Epilepsia:");

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel30.setText("Internação hospitalar:");

        jComboBoxInternacao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxInternacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Não sei", "Sim" }));
        jComboBoxInternacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxInternacao.setEnabled(false);

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setText("Distúrbios Psico:");

        jComboBoxDisturbios.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDisturbios.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Não sei", "Sim" }));
        jComboBoxDisturbios.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDisturbios.setEnabled(false);

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setText("Endocardite Bact.:");

        jComboBoxEndocardite.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxEndocardite.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Não sei", "Sim" }));
        jComboBoxEndocardite.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxEndocardite.setEnabled(false);

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setText("Problema renal:");

        jComboBoxRenal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxRenal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Não sei", "Sim" }));
        jComboBoxRenal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxRenal.setEnabled(false);

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel29.setText("Cirurgia:");

        jComboBoxCirurgia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxCirurgia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Não sei", "Sim" }));
        jComboBoxCirurgia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxCirurgia.setEnabled(false);

        jLabel81.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel81.setText("Sifilis:");

        jComboBoxSifilis.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxSifilis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Não sei", "Sim" }));
        jComboBoxSifilis.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxSifilis.setEnabled(false);

        jLabel82.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel82.setText("Tuberculose:");

        jComboBoxTuberculose.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTuberculose.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Não sei", "Sim" }));
        jComboBoxTuberculose.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTuberculose.setEnabled(false);

        jLabel84.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel84.setText("Outras:");

        jComboBoxOutras.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxOutras.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxOutras.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxOutras.setEnabled(false);

        jLabel86.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel86.setText("Qual?");

        jQualOutraDoenca.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualOutraDoenca.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel86)
                    .addComponent(jLabel81)
                    .addComponent(jLabel21)
                    .addComponent(jLabel17)
                    .addComponent(jLabel16)
                    .addComponent(jLabel20)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxSifilis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jComboBoxEpilepsia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBoxAsma, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBoxHiv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBoxDiabetes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBoxHepatite, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxCicatrizacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxTensao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxCardiaco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(71, 71, 71))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel82)
                                    .addComponent(jLabel25))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxHepatico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxFebre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxTuberculose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(65, 65, 65)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel29)
                            .addComponent(jLabel26)
                            .addComponent(jLabel24)
                            .addComponent(jLabel23)
                            .addComponent(jLabel30)
                            .addComponent(jLabel84))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxEndocardite, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxDisturbios, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxCirurgia, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxInternacao, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxRenal, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxOutras, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jQualOutraDoenca))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel15)
                    .addComponent(jComboBoxHepatite, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(jComboBoxCardiaco, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30)
                    .addComponent(jComboBoxInternacao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel20)
                    .addComponent(jComboBoxDiabetes, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(jComboBoxTensao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(jComboBoxDisturbios, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel16)
                    .addComponent(jComboBoxHiv, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(jComboBoxCicatrizacao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(jComboBoxEndocardite, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel17)
                    .addComponent(jComboBoxAsma, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(jComboBoxFebre, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(jComboBoxRenal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel21)
                    .addComponent(jComboBoxEpilepsia, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(jComboBoxHepatico, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29)
                    .addComponent(jComboBoxCirurgia, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel81)
                    .addComponent(jComboBoxSifilis, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel82)
                    .addComponent(jComboBoxTuberculose, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel84)
                    .addComponent(jComboBoxOutras, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel86)
                    .addComponent(jQualOutraDoenca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel32.setText("Você possui alguma doença / problema significativo não mencionado?");

        jTextoDoenca.setColumns(20);
        jTextoDoenca.setRows(5);
        jTextoDoenca.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextoDoenca.setEnabled(false);
        jScrollPane1.setViewportView(jTextoDoenca);

        javax.swing.GroupLayout PatologiasLayout = new javax.swing.GroupLayout(Patologias);
        Patologias.setLayout(PatologiasLayout);
        PatologiasLayout.setHorizontalGroup(
            PatologiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatologiasLayout.createSequentialGroup()
                .addGroup(PatologiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PatologiasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(PatologiasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel32)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PatologiasLayout.setVerticalGroup(
            PatologiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatologiasLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Patologias", Patologias);

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel43.setText("18");

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("17");

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("16");

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("15");

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText("14");

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setText("13");

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("12");

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel52.setText("11");

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel53.setText("48");

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setText("47");

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel55.setText("46");

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel56.setText("45");

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel57.setText("44");

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel58.setText("43");

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel59.setText("42");

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel60.setText("41");

        jBt18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/ModeloDente3.jpg"))); // NOI18N
        jBt18.setContentAreaFilled(false);
        jBt18.setEnabled(false);

        jBt17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/ModeloDente3.jpg"))); // NOI18N
        jBt17.setContentAreaFilled(false);
        jBt17.setEnabled(false);

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel61.setText("21");

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel62.setText("22");

        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel63.setText("23");

        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel64.setText("24");

        jLabel65.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel65.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel65.setText("25");

        jLabel66.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel66.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel66.setText("26");

        jLabel68.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel68.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel68.setText("27");

        jLabel69.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel69.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel69.setText("28");

        jLabel70.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel70.setText("31");

        jLabel71.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel71.setText("32");

        jLabel72.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel72.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel72.setText("33");

        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel73.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel73.setText("34");

        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel74.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel74.setText("35");

        jLabel75.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel75.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel75.setText("36");

        jLabel76.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel76.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel76.setText("37");

        jLabel77.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel77.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel77.setText("38");

        jPanel22.setBackground(new java.awt.Color(0, 0, 0));
        jPanel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 102, Short.MAX_VALUE)
        );

        jTabelaOdontograma.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaOdontograma.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Procedimento", "Nº Dente", "Face", "Data", "Cor Dente", "Plano Tratamento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(jTabelaOdontograma);
        if (jTabelaOdontograma.getColumnModel().getColumnCount() > 0) {
            jTabelaOdontograma.getColumnModel().getColumn(0).setMinWidth(60);
            jTabelaOdontograma.getColumnModel().getColumn(0).setMaxWidth(60);
            jTabelaOdontograma.getColumnModel().getColumn(1).setMinWidth(200);
            jTabelaOdontograma.getColumnModel().getColumn(1).setMaxWidth(200);
            jTabelaOdontograma.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaOdontograma.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaOdontograma.getColumnModel().getColumn(3).setMinWidth(110);
            jTabelaOdontograma.getColumnModel().getColumn(3).setMaxWidth(110);
            jTabelaOdontograma.getColumnModel().getColumn(4).setMinWidth(80);
            jTabelaOdontograma.getColumnModel().getColumn(4).setMaxWidth(80);
            jTabelaOdontograma.getColumnModel().getColumn(5).setMinWidth(100);
            jTabelaOdontograma.getColumnModel().getColumn(5).setMaxWidth(100);
            jTabelaOdontograma.getColumnModel().getColumn(6).setMinWidth(250);
            jTabelaOdontograma.getColumnModel().getColumn(6).setMaxWidth(250);
        }

        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel98.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel98.setText("Data:");

        jDataOdontograma.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataOdontograma.setEnabled(false);

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel33.setText("Tipo Procedimento:");

        jComboBoxTipoProcedimento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTipoProcedimento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione..." }));
        jComboBoxTipoProcedimento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTipoProcedimento.setEnabled(false);

        jLabel78.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel78.setText("Faces do Dente:");

        jComboBoxFacesDente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxFacesDente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Lingual/Palatal", "Mesial", "Oclusal", "Distal", "Vestibular", "Retirado" }));
        jComboBoxFacesDente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxFacesDente.setEnabled(false);

        jLabel79.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel79.setText("Nº Dente:");

        jNumeroDente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNumeroDente.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jNumeroDente.setEnabled(false);

        jLabel80.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel80.setText("Cor Dente:");

        jCheckBoxVermelho.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxVermelho.setForeground(new java.awt.Color(255, 0, 0));
        jCheckBoxVermelho.setText("Vermelho");
        jCheckBoxVermelho.setEnabled(false);

        jCheckBoxVerde.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxVerde.setForeground(new java.awt.Color(0, 153, 0));
        jCheckBoxVerde.setText("Verde");
        jCheckBoxVerde.setEnabled(false);

        jCheckBoxAzul.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxAzul.setForeground(new java.awt.Color(0, 0, 255));
        jCheckBoxAzul.setText("Azul");
        jCheckBoxAzul.setEnabled(false);

        jLabel87.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel87.setText("Plano Tratamento:");

        jPlanoTratamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPlanoTratamento.setEnabled(false);

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel78)
                    .addComponent(jLabel33)
                    .addComponent(jLabel87))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxTipoProcedimento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxFacesDente, 0, 220, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel79)
                            .addComponent(jLabel80))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addComponent(jNumeroDente, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel98)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDataOdontograma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addComponent(jCheckBoxVermelho, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jCheckBoxVerde)
                                .addGap(18, 18, 18)
                                .addComponent(jCheckBoxAzul)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jPlanoTratamento))
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel33)
                    .addComponent(jComboBoxTipoProcedimento, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel79)
                    .addComponent(jNumeroDente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel98)
                    .addComponent(jDataOdontograma, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel78)
                    .addComponent(jComboBoxFacesDente, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel80)
                    .addComponent(jCheckBoxVermelho)
                    .addComponent(jCheckBoxVerde)
                    .addComponent(jCheckBoxAzul))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel87)
                    .addComponent(jPlanoTratamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jBt16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/ModeloDente3.jpg"))); // NOI18N
        jBt16.setContentAreaFilled(false);
        jBt16.setEnabled(false);

        jBt15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/ModeloDente3.jpg"))); // NOI18N
        jBt15.setContentAreaFilled(false);
        jBt15.setEnabled(false);

        jBt12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/ModeloDente3.jpg"))); // NOI18N
        jBt12.setContentAreaFilled(false);
        jBt12.setEnabled(false);

        jBt11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/ModeloDente3.jpg"))); // NOI18N
        jBt11.setContentAreaFilled(false);
        jBt11.setEnabled(false);

        jBt14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/ModeloDente3.jpg"))); // NOI18N
        jBt14.setContentAreaFilled(false);
        jBt14.setEnabled(false);

        jBt13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/ModeloDente3.jpg"))); // NOI18N
        jBt13.setContentAreaFilled(false);
        jBt13.setEnabled(false);

        jBt46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/ModeloDente3.jpg"))); // NOI18N
        jBt46.setContentAreaFilled(false);
        jBt46.setEnabled(false);

        jBt44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/ModeloDente3.jpg"))); // NOI18N
        jBt44.setContentAreaFilled(false);
        jBt44.setEnabled(false);

        jBt41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/ModeloDente3.jpg"))); // NOI18N
        jBt41.setContentAreaFilled(false);
        jBt41.setEnabled(false);

        jBt42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/ModeloDente3.jpg"))); // NOI18N
        jBt42.setContentAreaFilled(false);
        jBt42.setEnabled(false);

        jBt45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/ModeloDente3.jpg"))); // NOI18N
        jBt45.setContentAreaFilled(false);
        jBt45.setEnabled(false);

        jBt48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/ModeloDente3.jpg"))); // NOI18N
        jBt48.setContentAreaFilled(false);
        jBt48.setEnabled(false);

        jBt47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/ModeloDente3.jpg"))); // NOI18N
        jBt47.setContentAreaFilled(false);
        jBt47.setEnabled(false);

        jBt43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/ModeloDente3.jpg"))); // NOI18N
        jBt43.setContentAreaFilled(false);
        jBt43.setEnabled(false);

        jBt23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/ModeloDente3.jpg"))); // NOI18N
        jBt23.setContentAreaFilled(false);
        jBt23.setEnabled(false);

        jBt25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/ModeloDente3.jpg"))); // NOI18N
        jBt25.setContentAreaFilled(false);
        jBt25.setEnabled(false);

        jBt28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/ModeloDente3.jpg"))); // NOI18N
        jBt28.setContentAreaFilled(false);
        jBt28.setEnabled(false);

        jBt27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/ModeloDente3.jpg"))); // NOI18N
        jBt27.setContentAreaFilled(false);
        jBt27.setEnabled(false);

        jBt24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/ModeloDente3.jpg"))); // NOI18N
        jBt24.setContentAreaFilled(false);
        jBt24.setEnabled(false);

        jBt21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/ModeloDente3.jpg"))); // NOI18N
        jBt21.setContentAreaFilled(false);
        jBt21.setEnabled(false);

        jBt22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/ModeloDente3.jpg"))); // NOI18N
        jBt22.setContentAreaFilled(false);
        jBt22.setEnabled(false);

        jBt26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/ModeloDente3.jpg"))); // NOI18N
        jBt26.setContentAreaFilled(false);
        jBt26.setEnabled(false);

        jBt33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/ModeloDente3.jpg"))); // NOI18N
        jBt33.setContentAreaFilled(false);
        jBt33.setEnabled(false);

        jBt35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/ModeloDente3.jpg"))); // NOI18N
        jBt35.setContentAreaFilled(false);
        jBt35.setEnabled(false);

        jBt36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/ModeloDente3.jpg"))); // NOI18N
        jBt36.setContentAreaFilled(false);
        jBt36.setEnabled(false);

        jBt32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/ModeloDente3.jpg"))); // NOI18N
        jBt32.setContentAreaFilled(false);
        jBt32.setEnabled(false);

        jBt37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/ModeloDente3.jpg"))); // NOI18N
        jBt37.setContentAreaFilled(false);
        jBt37.setEnabled(false);

        jBt38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/ModeloDente3.jpg"))); // NOI18N
        jBt38.setContentAreaFilled(false);
        jBt38.setEnabled(false);

        jBt31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/ModeloDente3.jpg"))); // NOI18N
        jBt31.setContentAreaFilled(false);
        jBt31.setEnabled(false);

        jBt34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/ModeloDente3.jpg"))); // NOI18N
        jBt34.setContentAreaFilled(false);
        jBt34.setEnabled(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtAdicionar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtAdicionar.setForeground(new java.awt.Color(0, 0, 255));
        jBtAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtAdicionar.setText("Adicionar");
        jBtAdicionar.setEnabled(false);
        jBtAdicionar.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jBtAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAdicionarActionPerformed(evt);
            }
        });

        jBtRemover.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtRemover.setForeground(new java.awt.Color(255, 0, 0));
        jBtRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtRemover.setText("Excluir");
        jBtRemover.setEnabled(false);
        jBtRemover.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jBtRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtRemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtRemover)
                    .addComponent(jBtAdicionar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAdicionar, jBtRemover});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jBtAdicionar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtRemover)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout OdontogramaLayout = new javax.swing.GroupLayout(Odontograma);
        Odontograma.setLayout(OdontogramaLayout);
        OdontogramaLayout.setHorizontalGroup(
            OdontogramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OdontogramaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(OdontogramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(OdontogramaLayout.createSequentialGroup()
                        .addComponent(jScrollPane8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(OdontogramaLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(OdontogramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(OdontogramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OdontogramaLayout.createSequentialGroup()
                            .addComponent(jBt18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(4, 4, 4))
                        .addGroup(OdontogramaLayout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(OdontogramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBt48, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(OdontogramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel54, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBt47, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBt17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(OdontogramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel55, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBt46, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBt16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(OdontogramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel56, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBt45, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBt15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(OdontogramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel57, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBt44, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBt14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel47, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(OdontogramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel58, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBt43, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBt13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel50, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(OdontogramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel59, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBt42, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBt12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel51, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(OdontogramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBt41, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBt11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(OdontogramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OdontogramaLayout.createSequentialGroup()
                        .addGroup(OdontogramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(OdontogramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(OdontogramaLayout.createSequentialGroup()
                                .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(OdontogramaLayout.createSequentialGroup()
                        .addComponent(jBt31, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jBt32, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jBt33, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(OdontogramaLayout.createSequentialGroup()
                        .addComponent(jBt21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jBt22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addGroup(OdontogramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBt23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(OdontogramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(OdontogramaLayout.createSequentialGroup()
                                .addGroup(OdontogramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(OdontogramaLayout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(jBt24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OdontogramaLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(OdontogramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(OdontogramaLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jBt25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OdontogramaLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(OdontogramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(OdontogramaLayout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(jBt26, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OdontogramaLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(OdontogramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(OdontogramaLayout.createSequentialGroup()
                                        .addComponent(jBt27, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jBt28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(OdontogramaLayout.createSequentialGroup()
                                        .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(OdontogramaLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jBt34, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBt35, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(jBt36, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBt37, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBt38, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        OdontogramaLayout.setVerticalGroup(
            OdontogramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OdontogramaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(OdontogramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(OdontogramaLayout.createSequentialGroup()
                        .addGroup(OdontogramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(OdontogramaLayout.createSequentialGroup()
                                .addGroup(OdontogramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(OdontogramaLayout.createSequentialGroup()
                                        .addComponent(jLabel43)
                                        .addGap(6, 6, 6)
                                        .addComponent(jBt18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(OdontogramaLayout.createSequentialGroup()
                                        .addComponent(jLabel44)
                                        .addGap(6, 6, 6)
                                        .addComponent(jBt17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(OdontogramaLayout.createSequentialGroup()
                                        .addComponent(jLabel45)
                                        .addGap(6, 6, 6)
                                        .addComponent(jBt16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel46)
                                    .addComponent(jLabel47)
                                    .addComponent(jLabel50)
                                    .addGroup(OdontogramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel51)
                                        .addGroup(OdontogramaLayout.createSequentialGroup()
                                            .addGap(20, 20, 20)
                                            .addComponent(jBt12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OdontogramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(OdontogramaLayout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addComponent(jBt11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel52)))
                                    .addGroup(OdontogramaLayout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addGroup(OdontogramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jBt15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jBt14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jBt13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(OdontogramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jBt48, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jBt47, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jBt46, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(OdontogramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jBt42, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jBt41, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jBt45, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jBt44, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jBt43, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(OdontogramaLayout.createSequentialGroup()
                                .addGroup(OdontogramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel62)
                                    .addComponent(jLabel61)
                                    .addComponent(jLabel63)
                                    .addComponent(jLabel64)
                                    .addComponent(jLabel65)
                                    .addComponent(jLabel66)
                                    .addComponent(jLabel68)
                                    .addComponent(jLabel69))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(OdontogramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jBt21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jBt22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jBt23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(OdontogramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jBt27, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jBt28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jBt24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jBt25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jBt26, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(OdontogramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jBt31, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jBt32, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jBt33, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(OdontogramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jBt37, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jBt38, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jBt34, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jBt35, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jBt36, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(OdontogramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(OdontogramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel54)
                                .addComponent(jLabel53)
                                .addComponent(jLabel55)
                                .addComponent(jLabel56)
                                .addComponent(jLabel57)
                                .addComponent(jLabel58)
                                .addComponent(jLabel59)
                                .addComponent(jLabel60))
                            .addGroup(OdontogramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel70)
                                .addComponent(jLabel71)
                                .addComponent(jLabel72)
                                .addComponent(jLabel73)
                                .addComponent(jLabel74)
                                .addComponent(jLabel75)
                                .addComponent(jLabel76)
                                .addComponent(jLabel77)))))
                .addGap(13, 13, 13)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(OdontogramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane3.addTab("Plano Tratamento", Odontograma);

        javax.swing.GroupLayout AdmissaoLayout = new javax.swing.GroupLayout(Admissao);
        Admissao.setLayout(AdmissaoLayout);
        AdmissaoLayout.setHorizontalGroup(
            AdmissaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdmissaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AdmissaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        AdmissaoLayout.setVerticalGroup(
            AdmissaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdmissaoLayout.createSequentialGroup()
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Admissão", Admissao);

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel39.setText("Data");

        jDataEvolucao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataEvolucao.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Código");

        jIdEvolucao.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdEvolucao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdEvolucao.setEnabled(false);

        jNomeInternoEvolucao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoEvolucao.setEnabled(false);

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel37.setText("Nome Completo do Interno");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jIdEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jNomeInternoEvolucao))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel39)
                    .addComponent(jDataEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel37)
                        .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jNomeInternoEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Evolução", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 51, 255))); // NOI18N

        jEvolucao.setColumns(20);
        jEvolucao.setRows(5);
        jEvolucao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jEvolucao.setEnabled(false);
        jScrollPane3.setViewportView(jEvolucao);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jBtNovoEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoEvolucao.setText("Novo");
        jBtNovoEvolucao.setEnabled(false);
        jBtNovoEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoEvolucaoActionPerformed(evt);
            }
        });

        jBtAlterarEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarEvolucao.setText("Alterar");
        jBtAlterarEvolucao.setEnabled(false);
        jBtAlterarEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarEvolucaoActionPerformed(evt);
            }
        });

        jBtExcluirEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirEvolucao.setText("Excluir");
        jBtExcluirEvolucao.setEnabled(false);
        jBtExcluirEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirEvolucaoActionPerformed(evt);
            }
        });

        jBtSalvarEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarEvolucao.setText("Gravar");
        jBtSalvarEvolucao.setEnabled(false);
        jBtSalvarEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarEvolucaoActionPerformed(evt);
            }
        });

        jBtCancelarEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarEvolucao.setText("Cancelar");
        jBtCancelarEvolucao.setEnabled(false);
        jBtCancelarEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarEvolucaoActionPerformed(evt);
            }
        });

        jBtImpressaoEvolucao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtImpressaoEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/gtklp-icone-3770-16.png"))); // NOI18N
        jBtImpressaoEvolucao.setToolTipText("Impressão");
        jBtImpressaoEvolucao.setEnabled(false);

        jBtAuditoriaEvolucao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtAuditoriaEvolucao.setForeground(new java.awt.Color(0, 0, 255));
        jBtAuditoriaEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaEvolucao.setContentAreaFilled(false);
        jBtAuditoriaEvolucao.setEnabled(false);
        jBtAuditoriaEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaEvolucaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtNovoEvolucao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarEvolucao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirEvolucao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarEvolucao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelarEvolucao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(jBtImpressaoEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jBtAuditoriaEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtImpressaoEvolucao)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtNovoEvolucao)
                        .addComponent(jBtAlterarEvolucao)
                        .addComponent(jBtExcluirEvolucao)
                        .addComponent(jBtSalvarEvolucao)
                        .addComponent(jBtCancelarEvolucao))
                    .addComponent(jBtAuditoriaEvolucao))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterarEvolucao, jBtCancelarEvolucao, jBtExcluirEvolucao, jBtImpressaoEvolucao, jBtNovoEvolucao, jBtSalvarEvolucao});

        jTabelaProcedimentos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaProcedimentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Código", "Data", "Evolução"
            }
        ));
        jTabelaProcedimentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaProcedimentosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTabelaProcedimentos);
        if (jTabelaProcedimentos.getColumnModel().getColumnCount() > 0) {
            jTabelaProcedimentos.getColumnModel().getColumn(0).setMinWidth(80);
            jTabelaProcedimentos.getColumnModel().getColumn(0).setMaxWidth(80);
            jTabelaProcedimentos.getColumnModel().getColumn(1).setMinWidth(80);
            jTabelaProcedimentos.getColumnModel().getColumn(1).setMaxWidth(80);
            jTabelaProcedimentos.getColumnModel().getColumn(2).setMinWidth(620);
            jTabelaProcedimentos.getColumnModel().getColumn(2).setMaxWidth(620);
        }

        javax.swing.GroupLayout ContinuacaoLayout = new javax.swing.GroupLayout(Continuacao);
        Continuacao.setLayout(ContinuacaoLayout);
        ContinuacaoLayout.setHorizontalGroup(
            ContinuacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContinuacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ContinuacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4))
                .addContainerGap())
        );
        ContinuacaoLayout.setVerticalGroup(
            ContinuacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContinuacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Evolução", Continuacao);

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel41.setText("Data");

        jDataPrescricao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataPrescricao.setEnabled(false);

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel38.setText("Código");

        jIdPrescricao.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdPrescricao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdPrescricao.setEnabled(false);

        jNomeInternoPrescricao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoPrescricao.setEnabled(false);

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel42.setText("Nome Completo do Interno");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38)
                    .addComponent(jIdPrescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel42)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jNomeInternoPrescricao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel41)
                    .addComponent(jDataPrescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel42)
                        .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jNomeInternoPrescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdPrescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataPrescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Prescrição de Medicamentos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(153, 0, 153))); // NOI18N

        jPrescricaoOdontologia.setColumns(20);
        jPrescricaoOdontologia.setRows(5);
        jPrescricaoOdontologia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPrescricaoOdontologia.setEnabled(false);
        jScrollPane6.setViewportView(jPrescricaoOdontologia);

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
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jBtNovoPrescricao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoPrescricao.setText("Novo");
        jBtNovoPrescricao.setEnabled(false);
        jBtNovoPrescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoPrescricaoActionPerformed(evt);
            }
        });

        jBtAlterarPrescricao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarPrescricao.setText("Alterar");
        jBtAlterarPrescricao.setEnabled(false);
        jBtAlterarPrescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarPrescricaoActionPerformed(evt);
            }
        });

        jBtExcluirPrescricao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirPrescricao.setText("Excluir");
        jBtExcluirPrescricao.setEnabled(false);
        jBtExcluirPrescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirPrescricaoActionPerformed(evt);
            }
        });

        jBtSalvarPrescricao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarPrescricao.setText("Gravar");
        jBtSalvarPrescricao.setEnabled(false);
        jBtSalvarPrescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarPrescricaoActionPerformed(evt);
            }
        });

        jBtCancelarPrescricao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarPrescricao.setText("Cancelar");
        jBtCancelarPrescricao.setEnabled(false);
        jBtCancelarPrescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarPrescricaoActionPerformed(evt);
            }
        });

        jBtImpressaoPrescricao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtImpressaoPrescricao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/gtklp-icone-3770-16.png"))); // NOI18N
        jBtImpressaoPrescricao.setToolTipText("Impressão");
        jBtImpressaoPrescricao.setEnabled(false);
        jBtImpressaoPrescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtImpressaoPrescricaoActionPerformed(evt);
            }
        });

        jBtAuditoriaPrescricao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtAuditoriaPrescricao.setForeground(new java.awt.Color(0, 0, 255));
        jBtAuditoriaPrescricao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaPrescricao.setContentAreaFilled(false);
        jBtAuditoriaPrescricao.setEnabled(false);
        jBtAuditoriaPrescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaPrescricaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtNovoPrescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarPrescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirPrescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarPrescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelarPrescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(jBtImpressaoPrescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jBtAuditoriaPrescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtImpressaoPrescricao)
                    .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtNovoPrescricao)
                        .addComponent(jBtAlterarPrescricao)
                        .addComponent(jBtExcluirPrescricao)
                        .addComponent(jBtSalvarPrescricao)
                        .addComponent(jBtCancelarPrescricao))
                    .addComponent(jBtAuditoriaPrescricao))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaPrescricao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaPrescricao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Código", "Data", "Prescrição de Medicamentos"
            }
        ));
        jTabelaPrescricao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaPrescricaoMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jTabelaPrescricao);
        if (jTabelaPrescricao.getColumnModel().getColumnCount() > 0) {
            jTabelaPrescricao.getColumnModel().getColumn(0).setMinWidth(80);
            jTabelaPrescricao.getColumnModel().getColumn(0).setMaxWidth(80);
            jTabelaPrescricao.getColumnModel().getColumn(1).setMinWidth(80);
            jTabelaPrescricao.getColumnModel().getColumn(1).setMaxWidth(80);
            jTabelaPrescricao.getColumnModel().getColumn(2).setMinWidth(620);
            jTabelaPrescricao.getColumnModel().getColumn(2).setMaxWidth(620);
        }

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane7))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Prescrição", jPanel7);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 693, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(300, 10, 709, 530);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesqDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqDataActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
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
                    preencherAvaliacaoOdotologica("SELECT * FROM ATENDIMENTODONTO "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON ATENDIMENTODONTO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "WHERE DataLanc BETWEEN'" + dataInicial + "'AND '" + dataFinal + "'");
                }
            }
        }
    }//GEN-LAST:event_jBtPesqDataActionPerformed

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtendimentoInternoManu_ODON);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoODON.equals("ADMINISTRADORES") || codigoUserODON == codUserAcessoODON && nomeTelaODON.equals(telaAtendimentoInternoManu_ODON) && codIncluirODON == 1) {
            acao = 1;
            bloquearCampos();
            bloquearBotoes();
            limparCampos();
            limparTabelaProcedimentos();
            limparTabelaPrescricao();
            limparTabelaOdontograma();
            preencherComboNovo();
            Novo();
            corCampo();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtendimentoInternoManu_ODON);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoODON.equals("ADMINISTRADORES") || codigoUserODON == codUserAcessoODON && nomeTelaODON.equals(telaAtendimentoInternoManu_ODON) && codAlterarODON == 1) {
            objAtendOdonto.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse atendimento não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 2;
                bloquearCampos();
                bloquearBotoes();
                limparCampos();
                preencherComboNovo();
                Alterar();
                corCampo();
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
        buscarAcessoUsuario(telaAtendimentoInternoManu_ODON);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoODON.equals("ADMINISTRADORES") || codigoUserODON == codUserAcessoODON && nomeTelaODON.equals(telaAtendimentoInternoManu_ODON) && codExcluirODON == 1) {
            bloquearCampos();
            bloquearBotoes();
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            objAtendOdonto.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse atendimento não poderá ser excluido, o mesmo encontra-se FINALIZADO");
            } else {
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o ATENDIMENTO selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    objAtendOdonto.setIdLanc(Integer.parseInt(jIDLanc.getText()));
                    control.excluirAtendOdonto(objAtendOdonto);
                    objAtendOdonto.setIdLanc(Integer.parseInt(jIDLanc.getText()));
                    controle.excluirMovTec(objAtendOdonto);
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                    Excluir();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtendimentoInternoManu_ODON);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoODON.equals("ADMINISTRADORES") || codigoUserODON == codUserAcessoODON && nomeTelaODON.equals(telaAtendimentoInternoManu_ODON) && codGravarODON == 1) {
            Integer rows = jTabelaOdontograma.getModel().getRowCount();
            if (jDataLanc.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data do Atendimento");
                jDataLanc.requestFocus();
                jDataLanc.setBackground(Color.red);
            } else {
                if (jNomeInterno.getText().equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Informe o nome do interno para atendimento");
                } else {
                    objAtendOdonto.setStatusLanc(jStatusLanc.getText());
                    objAtendOdonto.setDataLanc(jDataLanc.getDate());
                    objAtendOdonto.setTipoAtendimento((String) jComboBoxTipoAtendimento.getSelectedItem());
                    objAtendOdonto.setFumante((String) jComboBoxFumante.getSelectedItem());
                    objAtendOdonto.setGestante((String) jComboBoxGestante.getSelectedItem());
                    objAtendOdonto.setTempoGestacao((int) jTempoGestacao.getValue());
                    objAtendOdonto.setTratamentoMedico((String) jComboBoxTratamentoMedico.getSelectedItem());
                    objAtendOdonto.setMedicacao((String) jComboBoxMedicacao.getSelectedItem());
                    objAtendOdonto.setAlegria((String) jComboBoxMedicacao.getSelectedItem());
                    objAtendOdonto.setQueixaPrincipal(jQueixaPrincipal.getText());
                    objAtendOdonto.setAfirmacao1(jAfirmacao1.getText());
                    objAtendOdonto.setAfirmacao2(jAfirmacao2.getText());
                    objAtendOdonto.setAfirmacao3(jAfirmacao3.getText());
                    objAtendOdonto.setObservacao(jObservacao.getText());
                    // PATOLOGIAS
                    objAtendOdonto.setHepatite((String) jComboBoxHepatite.getSelectedItem());
                    objAtendOdonto.setHiv((String) jComboBoxHiv.getSelectedItem());
                    objAtendOdonto.setAsma((String) jComboBoxAsma.getSelectedItem());
                    objAtendOdonto.setFebre((String) jComboBoxFebre.getSelectedItem());
                    objAtendOdonto.setDiabetes((String) jComboBoxDiabetes.getSelectedItem());
                    objAtendOdonto.setEpilepsia((String) jComboBoxEpilepsia.getSelectedItem());
                    objAtendOdonto.setCicatrizacao((String) jComboBoxCicatrizacao.getSelectedItem());
                    objAtendOdonto.setDisturbios((String) jComboBoxDisturbios.getSelectedItem());
                    objAtendOdonto.setEndocardite((String) jComboBoxEndocardite.getSelectedItem());
                    objAtendOdonto.setEpatico((String) jComboBoxHepatico.getSelectedItem());
                    objAtendOdonto.setRenal((String) jComboBoxRenal.getSelectedItem());
                    objAtendOdonto.setCardiaco((String) jComboBoxCardiaco.getSelectedItem());
                    objAtendOdonto.setTensao((String) jComboBoxTensao.getSelectedItem());
                    objAtendOdonto.setCirurgia((String) jComboBoxCirurgia.getSelectedItem());
                    objAtendOdonto.setInternacao((String) jComboBoxInternacao.getSelectedItem());
                    objAtendOdonto.setSifilis((String) jComboBoxSifilis.getSelectedItem());
                    objAtendOdonto.setTuberculose((String) jComboBoxTuberculose.getSelectedItem());
                    objAtendOdonto.setOutras((String) jComboBoxOutras.getSelectedItem());
                    objAtendOdonto.setQualOutraDoenca(jQualOutraDoenca.getText());
                    objAtendOdonto.setTextoDoenca(jTextoDoenca.getText());
                    if (acao == 1) {
                        // log de usuario
                        objAtendOdonto.setUsuarioInsert(nameUser);
                        objAtendOdonto.setDataInsert(dataModFinal);
                        objAtendOdonto.setHorarioInsert(horaMov);
                        //
                        objAtendOdonto.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                        objAtendOdonto.setNomeInterno(jNomeInterno.getText());
                        control.incluirAtendOdonto(objAtendOdonto);
                        buscarID();
                        objAtendOdonto.setIdLanc(Integer.valueOf(jIDLanc.getText()));
                        objAtendOdonto.setNomeInterno(jNomeInterno.getText());
                        objAtendOdonto.setDeptoOdonto(deptoTecnico);
                        controle.incluirMovTec(objAtendOdonto);
                        if (rows != 0) {
                            incluirOdontograma();
                        }
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                        Salvar();
                    }
                    if (acao == 2) {
                        // log de usuario
                        objAtendOdonto.setUsuarioUp(nameUser);
                        objAtendOdonto.setDataUp(dataModFinal);
                        objAtendOdonto.setHorarioUp(horaMov);
                        //
                        objAtendOdonto.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                        objAtendOdonto.setNomeInterno(jNomeInterno.getText());
                        objAtendOdonto.setIdLanc(Integer.valueOf(jIDLanc.getText()));
                        control.alterarAtendOdonto(objAtendOdonto);
                        objAtendOdonto.setIdLanc(Integer.valueOf(jIDLanc.getText()));
                        objAtendOdonto.setNomeInterno(jNomeInterno.getText());
                        objAtendOdonto.setDeptoOdonto(deptoTecnico);
                        controle.alterarMovTec(objAtendOdonto);
                        //
                        objOdonto.setIdLanc(Integer.valueOf(jIDLanc.getText()));
                        controlOdontograma.excluirOdontoGrama(objOdonto);
                        //
                        if (rows != 0) {
                            incluirOdontograma();
                        }
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                        Salvar();
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

    private void jBtFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFinalizarActionPerformed
        // TODO add your handling code here:
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ATENDIMENTODONTO WHERE IdLanc='" + jIDPesqAtend.getText() + "'");
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

    private void jBtPesqNomeInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNomeInternoActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        preencherAvaliacaoOdotologica("SELECT * FROM ATENDIMENTODONTO "
                + "INNER JOIN PRONTUARIOSCRC "
                + "ON ATENDIMENTODONTO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                + "WHERE NomeInternoCrc LIKE'%" + jPesqNomeInternoOdonto.getText() + "%'");
    }//GEN-LAST:event_jBtPesqNomeInternoActionPerformed

    private void jBtIdPesqAtendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtIdPesqAtendActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        preencherAvaliacaoOdotologica("SELECT * FROM ATENDIMENTODONTO "
                + "INNER JOIN PRONTUARIOSCRC "
                + "ON ATENDIMENTODONTO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                + "WHERE IdLanc='" + jIDPesqAtend.getText() + "'");
    }//GEN-LAST:event_jBtIdPesqAtendActionPerformed

    private void jBtPesqInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqInternoActionPerformed
        // TODO add your handling code here:
        TelaPesqInternoOdontologia objPesqIntOdont = new TelaPesqInternoOdontologia();
        TelaModuloOdontologia.jPainelOdontologia.add(objPesqIntOdont);
        objPesqIntOdont.show();
    }//GEN-LAST:event_jBtPesqInternoActionPerformed

    private void jTabelaOdontologiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaOdontologiaMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String IdLanc = "" + jTabelaOdontologia.getValueAt(jTabelaOdontologia.getSelectedRow(), 0);
            jIDPesqAtend.setText(IdLanc);
            //  jDatalancamento.setDate(jDatalancamento.getDate());
            jBtNovo.setEnabled(!true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtNovoEvolucao.setEnabled(true);
            jBtAuditoriaOdonto.setEnabled(true);
            //
            jBtNovoPrescricao.setEnabled(true);
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ATENDIMENTODONTO "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ATENDIMENTODONTO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE IdLanc='" + IdLanc + "'");
                conecta.rs.first();
                jIDLanc.setText(String.valueOf(conecta.rs.getInt("IdLanc")));
                jStatusLanc.setText(conecta.rs.getString("StatusLanc"));
                jDataLanc.setDate(conecta.rs.getDate("DataLanc"));
                jIDInterno.setText(conecta.rs.getString("IdInternoCrc"));
                jNomeInterno.setText(conecta.rs.getString("NomeInternoCrc"));
                // Capturando foto
                caminho = conecta.rs.getString("FotoInternoCrc");
                javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                jFotoInternoOdonto.setIcon(i);
                jFotoInternoOdonto.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoInternoOdonto.getWidth(), jFotoInternoOdonto.getHeight(), Image.SCALE_DEFAULT)));
                //
                jComboBoxTipoAtendimento.setSelectedItem(conecta.rs.getString("TipoAtendimento"));
                jComboBoxFumante.setSelectedItem(conecta.rs.getString("Fumante"));
                jComboBoxGestante.setSelectedItem(conecta.rs.getString("Gestante"));
                jTempoGestacao.setValue(conecta.rs.getInt("TempoGestacao"));
                jComboBoxTratamentoMedico.setSelectedItem(conecta.rs.getString("TratamentoMedico"));
                jComboBoxMedicacao.setSelectedItem(conecta.rs.getString("Medicacao"));
                jComboBoxAlegria.setSelectedItem(conecta.rs.getString("Alegria"));
                jQueixaPrincipal.setText(conecta.rs.getString("QueixaPrincipal"));
                jAfirmacao1.setText(conecta.rs.getString("Afirmacao1"));
                jAfirmacao2.setText(conecta.rs.getString("Afirmacao2"));
                jAfirmacao3.setText(conecta.rs.getString("Afirmacao3"));
                jObservacao.setText(conecta.rs.getString("Observacao"));
                //
                jComboBoxHepatite.setSelectedItem(conecta.rs.getString("Hepatite"));
                jComboBoxHiv.setSelectedItem(conecta.rs.getString("Hiv"));
                jComboBoxAsma.setSelectedItem(conecta.rs.getString("Asma"));
                jComboBoxFebre.setSelectedItem(conecta.rs.getString("Febre"));
                jComboBoxDiabetes.setSelectedItem(conecta.rs.getString("Diabetes"));
                jComboBoxEpilepsia.setSelectedItem(conecta.rs.getString("Epilepsia"));
                jComboBoxCicatrizacao.setSelectedItem(conecta.rs.getString("Cicatrizacao"));
                jComboBoxDisturbios.setSelectedItem(conecta.rs.getString("Disturbios"));
                jComboBoxEndocardite.setSelectedItem(conecta.rs.getString("Endocardite"));
                jComboBoxHepatico.setSelectedItem(conecta.rs.getString("Epatico"));
                jComboBoxRenal.setSelectedItem(conecta.rs.getString("Renal"));
                jComboBoxCardiaco.setSelectedItem(conecta.rs.getString("Cardiaco"));
                jComboBoxTensao.setSelectedItem(conecta.rs.getString("Tensao"));
                jComboBoxCirurgia.setSelectedItem(conecta.rs.getString("Cirurgia"));
                jComboBoxInternacao.setSelectedItem(conecta.rs.getString("Internacao"));
                jComboBoxSifilis.setSelectedItem(conecta.rs.getString("Sifilis"));
                jComboBoxTuberculose.setSelectedItem(conecta.rs.getString("Tuberculose"));
                jComboBoxOutras.setSelectedItem(conecta.rs.getString("Outras"));
                jQualOutraDoenca.setText(conecta.rs.getString("QualOutraDoenca"));
                jTextoDoenca.setText(conecta.rs.getString("TextoDoenca"));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa..." + e);
            }
            // ODONTOGRAMA    
            limparTabelaOdontograma();
            try {
                conecta.executaSQL("SELECT * FROM ODONTOGRAMA "
                        + "INNER JOIN PROCEDIMENTOS_ODONTOLOGICO "
                        + "ON ODONTOGRAMA.IdProcOdonto=PROCEDIMENTOS_ODONTOLOGICO.IdProcOdonto "
                        + "WHERE ODONTOGRAMA.IdLanc='" + jIDLanc.getText() + "'");
                conecta.rs.first();
                DefaultTableModel dtmProcedimento = (DefaultTableModel) jTabelaOdontograma.getModel();
                dtmProcedimento.getDataVector().clear(); // limpa a tabela 
                do {
                    dataOdonto = conecta.rs.getString("DataOdontograma");
                    if (dataOdonto != null) {
                        String dia = dataOdonto.substring(8, 10);
                        String mes = dataOdonto.substring(5, 7);
                        String ano = dataOdonto.substring(0, 4);
                        dataOdonto = dia + "/" + mes + "/" + ano;
                    }
                    corDenteVermelho = conecta.rs.getInt("Vermelho");
                    corDenteVerde = conecta.rs.getInt("Verde");
                    corDenteAzul = conecta.rs.getInt("Azul");
                    if (corDenteVermelho == 0) {
                        tipoCorDente = "Vermelho";
                    } else if (corDenteVerde == 0) {
                        tipoCorDente = "Verde";
                    } else if (corDenteAzul == 0) {
                        tipoCorDente = "Azul";
                    }
                    dtmProcedimento.addRow(new Object[]{conecta.rs.getInt("IdProcOdonto"), conecta.rs.getString("DescricaoProcedimento"), conecta.rs.getInt("NumeroDente"), conecta.rs.getString("FacesDente"), dataOdonto, tipoCorDente, conecta.rs.getString("PlanoTratamento")});
                } while (conecta.rs.next());
            } catch (SQLException ex) {
            }
            // EVOLUÇÃO
            preencherItensProcedimentos("SELECT * FROM ODONTOPROCEDIMENTO WHERE IdLanc='" + jIDLanc.getText() + "'");
            // PRESCRIÇÃO          
            preencherItensPrescricao("SELECT * FROM PRESCRICAO_ODONTOLOGIA WHERE IdLanc='" + jIDLanc.getText() + "'");
        }
    }//GEN-LAST:event_jTabelaOdontologiaMouseClicked

    private void jBtNovoEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoEvolucaoActionPerformed
        // TODO add your handling code here:tela
        buscarAcessoUsuario(telaAtendimentoInternoEvolucao_ODON);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoODON.equals("ADMINISTRADORES") || codigoUserODON == codUserAcessoODON && nomeTelaODON.equals(telaAtendimentoInternoEvolucao_ODON) && codIncluirODON == 1) {
            acao = 3;
            bloquearBotoes();
            bloquearCampos();
            NovoProcedimento();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovoEvolucaoActionPerformed

    private void jBtAlterarEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarEvolucaoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtendimentoInternoEvolucao_ODON);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoODON.equals("ADMINISTRADORES") || codigoUserODON == codUserAcessoODON && nomeTelaODON.equals(telaAtendimentoInternoEvolucao_ODON) && codAlterarODON == 1) {
            acao = 4;
            bloquearBotoes();
            bloquearCampos();
            AlterarProcedimento();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtAlterarEvolucaoActionPerformed

    private void jBtExcluirEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirEvolucaoActionPerformed
        // TODO add your handling code here:  
        buscarAcessoUsuario(telaAtendimentoInternoEvolucao_ODON);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoODON.equals("ADMINISTRADORES") || codigoUserODON == codUserAcessoODON && nomeTelaODON.equals(telaAtendimentoInternoEvolucao_ODON) && codExcluirODON == 1) {
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o procedimento selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objProcedOdonto.setIdPro(Integer.parseInt(jIdEvolucao.getText()));
                controlar.excluirProcedimentoOdonto(objProcedOdonto);
                objLog2();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                preencherItensProcedimentos("SELECT * FROM ODONTOPROCEDIMENTO WHERE IdLanc='" + jIDLanc.getText() + "'");
                JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                ExcluirProcedimento();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirEvolucaoActionPerformed

    private void jBtSalvarEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarEvolucaoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtendimentoInternoEvolucao_ODON);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoODON.equals("ADMINISTRADORES") || codigoUserODON == codUserAcessoODON && nomeTelaODON.equals(telaAtendimentoInternoEvolucao_ODON) && codGravarODON == 1) {
            if (jDataEvolucao.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Data não pode ser em branco.");
                jDataEvolucao.requestFocus();
                jDataEvolucao.setBackground(Color.red);
            } else {
                objProcedOdonto.setDataProcedimento(jDataEvolucao.getDate());
                objProcedOdonto.setProcedimento(jEvolucao.getText());
                if (acao == 3) {
                    // log de usuario
                    objProcedOdonto.setUsuarioInsert(nameUser);
                    objProcedOdonto.setDataInsert(jDataSistema.getText());
                    objProcedOdonto.setHorarioInsert(jHoraSistema.getText());
                    //
                    objProcedOdonto.setIdLanc(Integer.valueOf(jIDLanc.getText()));
                    objProcedOdonto.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                    controlar.incluirProcedimentoOdonto(objProcedOdonto);
                    buscarrCodProd();
                    objLog2();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    //
                    SalvarProcedimento();
                    preencherItensProcedimentos("SELECT * FROM ODONTOPROCEDIMENTO WHERE IdLanc='" + jIDLanc.getText() + "'");
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
                if (acao == 4) {
                    // log de usuario
                    objProcedOdonto.setUsuarioUp(nameUser);
                    objProcedOdonto.setDataUp(jDataSistema.getText());
                    objProcedOdonto.setHorarioUp(jHoraSistema.getText());
                    //
                    objProcedOdonto.setIdLanc(Integer.valueOf(jIDLanc.getText()));
                    objProcedOdonto.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                    objProcedOdonto.setIdPro(Integer.valueOf(jIdEvolucao.getText()));
                    controlar.alterarProcedimentoOdonto(objProcedOdonto);
                    objLog2();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    //
                    SalvarProcedimento();
                    preencherItensProcedimentos("SELECT * FROM ODONTOPROCEDIMENTO WHERE IdLanc='" + jIDLanc.getText() + "'");
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtSalvarEvolucaoActionPerformed

    private void jBtCancelarEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarEvolucaoActionPerformed
        // TODO add your handling code here:
        CancelarProcedimento();
    }//GEN-LAST:event_jBtCancelarEvolucaoActionPerformed

    private void jTabelaProcedimentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaProcedimentosMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String IdLanc = "" + jTabelaProcedimentos.getValueAt(jTabelaProcedimentos.getSelectedRow(), 0);
            jIDPesqAtend.setText(IdLanc);
            jBtNovo.setEnabled(!true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
            //
            jBtNovoEvolucao.setEnabled(true);
            jBtAlterarEvolucao.setEnabled(true);
            jBtExcluirEvolucao.setEnabled(true);
            jBtSalvarEvolucao.setEnabled(!true);
            jBtCancelarEvolucao.setEnabled(true);
            jBtAuditoriaEvolucao.setEnabled(true);
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ODONTOPROCEDIMENTO WHERE IdPro='" + IdLanc + "'");
                conecta.rs.first();
                jIdEvolucao.setText(String.valueOf(conecta.rs.getInt("IdPro")));
                jNomeInternoEvolucao.setText(jNomeInterno.getText());
                jDataEvolucao.setDate(conecta.rs.getDate("DataPro"));
                jEvolucao.setText(conecta.rs.getString("Procedimento"));
                conecta.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa..." + e);
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaProcedimentosMouseClicked

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherAvaliacaoOdotologica("SELECT * FROM ATENDIMENTODONTO "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ATENDIMENTODONTO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc");
        } else {
            jtotalRegistros.setText("");
            limparTabela();
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jBtAuditoriaOdontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaOdontoActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaAtendimentoOdonto audiAten = new TelaAuditoriaAtendimentoOdonto();
        TelaModuloOdontologia.jPainelOdontologia.add(audiAten);
        audiAten.show();
    }//GEN-LAST:event_jBtAuditoriaOdontoActionPerformed

    private void jBtAuditoriaEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaEvolucaoActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaEvolucaoOdontologica audiEvoOdonto = new TelaAuditoriaEvolucaoOdontologica();
        TelaModuloOdontologia.jPainelOdontologia.add(audiEvoOdonto);
        audiEvoOdonto.show();
    }//GEN-LAST:event_jBtAuditoriaEvolucaoActionPerformed

    private void jTabelaPrescricaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaPrescricaoMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String IdLanc = "" + jTabelaPrescricao.getValueAt(jTabelaPrescricao.getSelectedRow(), 0);
            jIDPesqAtend.setText(IdLanc);
            //
            jBtNovoPrescricao.setEnabled(true);
            jBtAlterarPrescricao.setEnabled(true);
            jBtExcluirPrescricao.setEnabled(true);
            jBtSalvarPrescricao.setEnabled(!true);
            jBtCancelarPrescricao.setEnabled(true);
            jBtAuditoriaPrescricao.setEnabled(true);
            jBtImpressaoPrescricao.setEnabled(true);
            //
            jBtNovo.setEnabled(!true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
            //
            jBtNovoEvolucao.setEnabled(!true);
            jBtAlterarEvolucao.setEnabled(!true);
            jBtExcluirEvolucao.setEnabled(!true);
            jBtSalvarEvolucao.setEnabled(!true);
            jBtCancelarEvolucao.setEnabled(!true);
            jBtAuditoriaEvolucao.setEnabled(!true);
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM PRESCRICAO_ODONTOLOGIA WHERE IdPre='" + IdLanc + "'");
                conecta.rs.first();
                jIdPrescricao.setText(String.valueOf(conecta.rs.getInt("IdPre")));
                jNomeInternoPrescricao.setText(jNomeInterno.getText());
                jDataPrescricao.setDate(conecta.rs.getDate("DataPre"));
                jPrescricaoOdontologia.setText(conecta.rs.getString("TextoPrescricao"));
                conecta.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa...\nERRO: " + e);
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaPrescricaoMouseClicked

    private void jBtNovoPrescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoPrescricaoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtendimentoInternosPrescricao_ODON);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoODON.equals("ADMINISTRADORES") || codigoUserODON == codUserAcessoODON && nomeTelaODON.equals(telaAtendimentoInternosPrescricao_ODON) && codIncluirODON == 1) {
            acao = 5;
            bloquearBotoes();
            bloquearCampos();
            NovaPrescricao();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovoPrescricaoActionPerformed

    private void jBtAlterarPrescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarPrescricaoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtendimentoInternosPrescricao_ODON);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoODON.equals("ADMINISTRADORES") || codigoUserODON == codUserAcessoODON && nomeTelaODON.equals(telaAtendimentoInternosPrescricao_ODON) && codAlterarODON == 1) {
            acao = 6;
            bloquearBotoes();
            bloquearCampos();
            AlterarPrescricao();
            statusMov = "Alterou";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtAlterarPrescricaoActionPerformed

    private void jBtExcluirPrescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirPrescricaoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtendimentoInternosPrescricao_ODON);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoODON.equals("ADMINISTRADORES") || codigoUserODON == codUserAcessoODON && nomeTelaODON.equals(telaAtendimentoInternosPrescricao_ODON) && codExcluirODON == 1) {
            // VERIFICAR SE A PRESCRIÇÃO ODONTOLOGICA JÁ FOI UTILIZADA NA REQUISIÇÃO DE MEDICAMENTOS.
            verificarPrescricaoMedica();
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            if (jPrescricaoOdontologia.getText().equals(idItemPresq)) {
                JOptionPane.showMessageDialog(jTextoDoenca, "Essa receita odontologica não poderá ser excluida,\nestá sendo utilizada na requisição de medicamentos.");
            } else {
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o procedimento selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    // DELETAR PRESCRIÇÃO NA TABELA PRESCRICAO_MEDICA_PSIQUIATRICA
                    objPrescricao.setIdLanc(Integer.valueOf(jIdPrescricao.getText()));
                    controlePrescricao.excluirPrescricaoOdontologica(objPrescricao);
                    objPrescOdonto.setIdPre(Integer.parseInt(jIdPrescricao.getText()));
                    controlePres.excluirPrescricaoOdontologica(objPrescOdonto);
                    objLog3();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    preencherItensPrescricao("SELECT * FROM PRESCRICAO_ODONTOLOGIA WHERE IdLanc='" + jIDLanc.getText() + "'");
                    JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                    ExcluirPrescricao();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirPrescricaoActionPerformed

    private void jBtSalvarPrescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarPrescricaoActionPerformed
        // TODO add your handling code here:      
        buscarAcessoUsuario(telaAtendimentoInternosPrescricao_ODON);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoODON.equals("ADMINISTRADORES") || codigoUserODON == codUserAcessoODON && nomeTelaODON.equals(telaAtendimentoInternosPrescricao_ODON) && codGravarODON == 1) {
            if (jDataPrescricao.getDate() == null) {
                JOptionPane.showMessageDialog(null, "Informe a data da prescrição da medicação.");
            } else {
                objPrescOdonto.setDataPrescricao(jDataPrescricao.getDate());
                objPrescOdonto.setIdLanc(Integer.valueOf(jIDLanc.getText()));
                objPrescOdonto.setTextoPrescricao(jPrescricaoOdontologia.getText());
                objPrescOdonto.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                if (acao == 5) {
                    objPrescOdonto.setUsuarioInsert(nameUser);
                    objPrescOdonto.setDataInsert(dataModFinal);
                    objPrescOdonto.setHoraInsert(horaMov);
                    controlePres.incluirPrescricaoOdontologica(objPrescOdonto);
                    buscarCodigoPrescricao();
                    // INCLUIR PRESCRIÇÃO PARA O DEPARTAMENTO DE ENFERMARIA
                    objPrescricao.setIdLanc(Integer.valueOf(jIDLanc.getText()));
                    objPrescricao.setDataPrescricao(jDataPrescricao.getDate());
                    objPrescricao.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                    objPrescricao.setTipoPrescricaoMedica(tipoPres);
                    objPrescricao.setTextoPrescricao(jPrescricaoOdontologia.getText());
                    objPrescricao.setUsuarioInsert(nameUser);
                    objPrescricao.setDataInsert(dataModFinal);
                    objPrescricao.setHoraInsert(horaMov);
                    controlePrescricao.incluirPrescricaoMedica(objPrescricao);
                    //
                    objLog3();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação                
                    SalvarPrescricao();
                    preencherItensPrescricao("SELECT * FROM PRESCRICAO_ODONTOLOGIA WHERE IdLanc='" + jIDLanc.getText() + "'");
                    JOptionPane.showMessageDialog(null, "Registro gravado com sucesso.");
                }
                if (acao == 6) {
                    objPrescOdonto.setUsuarioUp(nameUser);
                    objPrescOdonto.setDataUp(dataModFinal);
                    objPrescOdonto.setHoraUp(horaMov);
                    objPrescOdonto.setIdPre(Integer.valueOf(jIdPrescricao.getText()));
                    controlePres.alterarPrescricaoOdontologica(objPrescOdonto);
                    // ALTERAR PRESCRIÇÃO NA TABELA DE PRESCRICAO_MEDICA_PSIQUIATRICA
                    objPrescricao.setIdLanc(Integer.valueOf(jIdPrescricao.getText()));
                    objPrescricao.setDataPrescricao(jDataPrescricao.getDate());
                    objPrescricao.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                    objPrescricao.setTipoPrescricaoMedica(tipoPres);
                    objPrescricao.setTextoPrescricao(jPrescricaoOdontologia.getText());
                    objPrescricao.setUsuarioUp(nameUser);
                    objPrescricao.setDataUp(dataModFinal);
                    objPrescricao.setHoraUp(horaMov);
                    controlePrescricao.alterarPrescricaoOdontolica(objPrescricao);
                    objLog3();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    SalvarPrescricao();
                    preencherItensPrescricao("SELECT * FROM PRESCRICAO_ODONTOLOGIA WHERE IdLanc='" + jIDLanc.getText() + "'");
                    JOptionPane.showMessageDialog(null, "Registro gravado com sucesso.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtSalvarPrescricaoActionPerformed

    private void jBtCancelarPrescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarPrescricaoActionPerformed
        // TODO add your handling code here:
        CancelarPrescricao();
    }//GEN-LAST:event_jBtCancelarPrescricaoActionPerformed

    private void jBtAuditoriaPrescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaPrescricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtAuditoriaPrescricaoActionPerformed

    private void jBtImpressaoPrescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImpressaoPrescricaoActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/RelatorioPrescricaoOdontologica.jasper";
            conecta.executaSQL("SELECT * FROM PRESCRICAO_ODONTOLOGIA "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON PRESCRICAO_ODONTOLOGIA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE PRESCRICAO_ODONTOLOGIA.IdPre='" + jIdPrescricao.getText() + "'");
            HashMap parametros = new HashMap();
            parametros.put("nomeUsuario", nameUser);
            parametros.put("codigoPres", jIdPrescricao.getText());
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Receituario de Médico - Odontologia");
            jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
            jv.toFront(); // Traz o relatorio para frente da aplicação            
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_jBtImpressaoPrescricaoActionPerformed

    private void jBtAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAdicionarActionPerformed
        // TODO add your handling code here:
        if (jComboBoxTipoProcedimento.getSelectedItem().equals("Selecione...") || jComboBoxTipoProcedimento.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Selecione um tipo de procedimento...");
        } else {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM PROCEDIMENTOS_ODONTOLOGICO "
                        + "WHERE DescricaoProcedimento='" + jComboBoxTipoProcedimento.getSelectedItem() + "'");
                conecta.rs.first();
                codigoProcedimento = conecta.rs.getString("IdProcOdonto");
                objOdonto.setIdProcOdonto(Integer.valueOf(codigoProcedimento));
            } catch (Exception e) {
            }
            if (jCheckBoxVermelho.isSelected()) {
                tipoCorDente = "Vermelho";
            } else if (jCheckBoxVerde.isSelected()) {
                tipoCorDente = "Verde";
            } else if (jCheckBoxAzul.isSelected()) {
                tipoCorDente = "Azul";
            }
            DefaultTableModel tabOrto = (DefaultTableModel) jTabelaOdontograma.getModel();
            objOdonto.setIdOdonto(Integer.valueOf(codigoProcedimento));
            objOdonto.setDescricaoProcedimento((String) jComboBoxTipoProcedimento.getSelectedItem());
            objOdonto.setNumeroDente(Integer.valueOf(jNumeroDente.getText()));
            objOdonto.setFacesDente((String) jComboBoxFacesDente.getSelectedItem());
            SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
            dataOdonto = formatoAmerica.format(jDataOdontograma.getDate().getTime());
            objOdonto.setCorDente(tipoCorDente);
            objOdonto.setPlanoTratamento(jPlanoTratamento.getText());
            Object campos[] = {objOdonto.getIdOdonto(), objOdonto.getDescricaoProcedimento(), objOdonto.getNumeroDente(), objOdonto.getFacesDente(), dataOdonto, tipoCorDente, objOdonto.getPlanoTratamento()};
            tabOrto.addRow(campos);
            //          
            jComboBoxTipoProcedimento.setSelectedItem("Selecione...");
            jNumeroDente.setText("");
            jDataOdontograma.setDate(null);
            jComboBoxFacesDente.setSelectedItem("Selecione...");
            jCheckBoxVermelho.setSelected(!true);
            jCheckBoxVerde.setSelected(!true);
            jCheckBoxAzul.setSelected(!true);
            jPlanoTratamento.setText("");
            conecta.desconecta();
        }
    }//GEN-LAST:event_jBtAdicionarActionPerformed

    private void jBtRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtRemoverActionPerformed
        // TODO add your handling code here:
        if (jTabelaOdontograma.getSelectedRow() != -1) {
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o item selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                DefaultTableModel dtm = (DefaultTableModel) jTabelaOdontograma.getModel();
                dtm.removeRow(jTabelaOdontograma.getSelectedRow());
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione o registro que deseja excluir.");
        }
    }//GEN-LAST:event_jBtRemoverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Admissao;
    private javax.swing.JPanel Continuacao;
    private javax.swing.JPanel DadosConsulta;
    private javax.swing.JPanel Listagem;
    private javax.swing.JPanel Odontograma;
    private javax.swing.JPanel Patologias;
    private javax.swing.JTextField jAfirmacao1;
    private javax.swing.JTextField jAfirmacao2;
    private javax.swing.JTextField jAfirmacao3;
    private javax.swing.JButton jBt11;
    private javax.swing.JButton jBt12;
    private javax.swing.JButton jBt13;
    private javax.swing.JButton jBt14;
    private javax.swing.JButton jBt15;
    private javax.swing.JButton jBt16;
    private javax.swing.JButton jBt17;
    private javax.swing.JButton jBt18;
    private javax.swing.JButton jBt21;
    private javax.swing.JButton jBt22;
    private javax.swing.JButton jBt23;
    private javax.swing.JButton jBt24;
    private javax.swing.JButton jBt25;
    private javax.swing.JButton jBt26;
    private javax.swing.JButton jBt27;
    private javax.swing.JButton jBt28;
    private javax.swing.JButton jBt31;
    private javax.swing.JButton jBt32;
    private javax.swing.JButton jBt33;
    private javax.swing.JButton jBt34;
    private javax.swing.JButton jBt35;
    private javax.swing.JButton jBt36;
    private javax.swing.JButton jBt37;
    private javax.swing.JButton jBt38;
    private javax.swing.JButton jBt41;
    private javax.swing.JButton jBt42;
    private javax.swing.JButton jBt43;
    private javax.swing.JButton jBt44;
    private javax.swing.JButton jBt45;
    private javax.swing.JButton jBt46;
    private javax.swing.JButton jBt47;
    private javax.swing.JButton jBt48;
    private javax.swing.JButton jBtAdicionar;
    private javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtAlterarEvolucao;
    private javax.swing.JButton jBtAlterarPrescricao;
    private javax.swing.JButton jBtAuditoriaEvolucao;
    private javax.swing.JButton jBtAuditoriaOdonto;
    private javax.swing.JButton jBtAuditoriaPrescricao;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtCancelarEvolucao;
    private javax.swing.JButton jBtCancelarPrescricao;
    private javax.swing.JButton jBtExcluir;
    private javax.swing.JButton jBtExcluirEvolucao;
    private javax.swing.JButton jBtExcluirPrescricao;
    private javax.swing.JButton jBtFinalizar;
    private javax.swing.JButton jBtIdPesqAtend;
    private javax.swing.JButton jBtImpressaoEvolucao;
    private javax.swing.JButton jBtImpressaoPrescricao;
    private javax.swing.JButton jBtNovo;
    private javax.swing.JButton jBtNovoEvolucao;
    private javax.swing.JButton jBtNovoPrescricao;
    private javax.swing.JButton jBtPesqData;
    private javax.swing.JButton jBtPesqInterno;
    private javax.swing.JButton jBtPesqNomeInterno;
    private javax.swing.JButton jBtRemover;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JButton jBtSalvarEvolucao;
    private javax.swing.JButton jBtSalvarPrescricao;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBoxAzul;
    private javax.swing.JCheckBox jCheckBoxVerde;
    private javax.swing.JCheckBox jCheckBoxVermelho;
    private javax.swing.JComboBox jComboBoxAlegria;
    private javax.swing.JComboBox jComboBoxAsma;
    private javax.swing.JComboBox jComboBoxCardiaco;
    private javax.swing.JComboBox jComboBoxCicatrizacao;
    private javax.swing.JComboBox jComboBoxCirurgia;
    private javax.swing.JComboBox jComboBoxDiabetes;
    private javax.swing.JComboBox jComboBoxDisturbios;
    private javax.swing.JComboBox jComboBoxEndocardite;
    private javax.swing.JComboBox jComboBoxEpilepsia;
    private javax.swing.JComboBox jComboBoxFacesDente;
    private javax.swing.JComboBox jComboBoxFebre;
    private javax.swing.JComboBox jComboBoxFumante;
    private javax.swing.JComboBox jComboBoxGestante;
    private javax.swing.JComboBox jComboBoxHepatico;
    private javax.swing.JComboBox jComboBoxHepatite;
    private javax.swing.JComboBox jComboBoxHiv;
    private javax.swing.JComboBox jComboBoxInternacao;
    private javax.swing.JComboBox jComboBoxMedicacao;
    private javax.swing.JComboBox jComboBoxOutras;
    private javax.swing.JComboBox jComboBoxRenal;
    private javax.swing.JComboBox jComboBoxSifilis;
    private javax.swing.JComboBox jComboBoxTensao;
    private javax.swing.JComboBox jComboBoxTipoAtendimento;
    private javax.swing.JComboBox jComboBoxTipoProcedimento;
    private javax.swing.JComboBox jComboBoxTratamentoMedico;
    private javax.swing.JComboBox jComboBoxTuberculose;
    private com.toedter.calendar.JDateChooser jDataEvolucao;
    private com.toedter.calendar.JDateChooser jDataFinal;
    private com.toedter.calendar.JDateChooser jDataInicial;
    private com.toedter.calendar.JDateChooser jDataLanc;
    private com.toedter.calendar.JDateChooser jDataOdontograma;
    private com.toedter.calendar.JDateChooser jDataPrescricao;
    private javax.swing.JTextArea jEvolucao;
    public static javax.swing.JLabel jFotoInternoOdonto;
    public static javax.swing.JTextField jIDInterno;
    public static javax.swing.JTextField jIDLanc;
    private javax.swing.JTextField jIDPesqAtend;
    public static javax.swing.JTextField jIdEvolucao;
    public static javax.swing.JTextField jIdPrescricao;
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel98;
    public static javax.swing.JTextField jNomeInterno;
    private javax.swing.JTextField jNomeInternoEvolucao;
    private javax.swing.JTextField jNomeInternoPrescricao;
    private javax.swing.JFormattedTextField jNumeroDente;
    private javax.swing.JTextArea jObservacao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jPesqNomeInternoOdonto;
    private javax.swing.JTextField jPlanoTratamento;
    private javax.swing.JTextArea jPrescricaoOdontologia;
    private javax.swing.JTextField jQualOutraDoenca;
    private javax.swing.JTextField jQueixaPrincipal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTextField jStatusLanc;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable jTabelaOdontograma;
    private javax.swing.JTable jTabelaOdontologia;
    private javax.swing.JTable jTabelaPrescricao;
    private javax.swing.JTable jTabelaProcedimentos;
    private javax.swing.JSpinner jTempoGestacao;
    private javax.swing.JTextArea jTextoDoenca;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void formatarCampos() {
        jPesqNomeInternoOdonto.setDocument(new LimiteDigitos(50));
        jQueixaPrincipal.setDocument(new LimiteDigitos(52));
        jAfirmacao1.setDocument(new LimiteDigitos(52));
        jAfirmacao2.setDocument(new LimiteDigitos(52));
        jAfirmacao3.setDocument(new LimiteDigitos(52));
        jObservacao.setLineWrap(true);
        jObservacao.setWrapStyleWord(true);
        jQualOutraDoenca.setDocument(new LimiteDigitosAlfa(93));
        jTextoDoenca.setLineWrap(true);
        jTextoDoenca.setWrapStyleWord(true);
        jPlanoTratamento.setDocument(new LimiteDigitosAlfa(84));
    }

    public void corCampo() {
        // ADMISSÃO
        jIDLanc.setBackground(Color.white);
        jStatusLanc.setBackground(Color.white);
        jDataLanc.setBackground(Color.white);
        jIDInterno.setBackground(Color.white);
        jNomeInterno.setBackground(Color.white);
        jComboBoxTipoAtendimento.setBackground(Color.white);
        jComboBoxFumante.setBackground(Color.white);
        jComboBoxGestante.setBackground(Color.white);
        jTempoGestacao.setBackground(Color.white);
        jComboBoxTratamentoMedico.setBackground(Color.white);
        jComboBoxMedicacao.setBackground(Color.white);
        jComboBoxAlegria.setBackground(Color.white);
        jQueixaPrincipal.setBackground(Color.white);
        jAfirmacao1.setBackground(Color.white);
        jAfirmacao2.setBackground(Color.white);
        jAfirmacao3.setBackground(Color.white);
        jObservacao.setBackground(Color.white);
        // PATOLOGIAS
        jComboBoxHepatite.setBackground(Color.white);
        jComboBoxHiv.setBackground(Color.white);
        jComboBoxAsma.setBackground(Color.white);
        jComboBoxFumante.setBackground(Color.white);
        jComboBoxFebre.setBackground(Color.white);
        jComboBoxDiabetes.setBackground(Color.white);
        jComboBoxEpilepsia.setBackground(Color.white);
        jComboBoxCicatrizacao.setBackground(Color.white);
        jComboBoxDisturbios.setBackground(Color.white);
        jComboBoxEndocardite.setBackground(Color.white);
        jComboBoxHepatico.setBackground(Color.white);
        jComboBoxRenal.setBackground(Color.white);
        jComboBoxCardiaco.setBackground(Color.white);
        jComboBoxTensao.setBackground(Color.white);
        jComboBoxCirurgia.setBackground(Color.white);
        jComboBoxSifilis.setBackground(Color.white);
        jComboBoxTuberculose.setBackground(Color.white);
        jComboBoxOutras.setBackground(Color.white);
        jQualOutraDoenca.setBackground(Color.white);
        jComboBoxInternacao.setBackground(Color.white);
        jTextoDoenca.setBackground(Color.white);
        jQualOutraDoenca.setBackground(Color.white);
        // ODONTOGRAMA
        jComboBoxTipoProcedimento.setBackground(Color.white);
        jNumeroDente.setBackground(Color.white);
        jDataOdontograma.setBackground(Color.white);
        jComboBoxFacesDente.setBackground(Color.white);
        jPlanoTratamento.setBackground(Color.white);
        // EVOLUÇÃO
        jIdEvolucao.setBackground(Color.white);
        jDataEvolucao.setBackground(Color.white);
        jEvolucao.setBackground(Color.white);
        jNomeInternoEvolucao.setBackground(Color.white);
        // PRESCRIÇÃO ODONTOLOGICA
        jIdPrescricao.setBackground(Color.white);
        jNomeInternoPrescricao.setBackground(Color.white);
        jDataPrescricao.setBackground(Color.white);
        jPrescricaoOdontologia.setBackground(Color.white);
    }

    public void bloquearCampos() {
        // DADOS DA CONSULTA
        jDataLanc.setEnabled(!true);
        jComboBoxTipoAtendimento.setEnabled(!true);
        jComboBoxFumante.setEnabled(!true);
        jComboBoxGestante.setEnabled(!true);
        jTempoGestacao.setEnabled(!true);
        jQueixaPrincipal.setEnabled(!true);
        jComboBoxTratamentoMedico.setEnabled(!true);
        jComboBoxMedicacao.setEnabled(!true);
        jComboBoxAlegria.setEnabled(!true);
        jAfirmacao1.setEnabled(!true);
        jAfirmacao2.setEnabled(!true);
        jAfirmacao3.setEnabled(!true);
        jObservacao.setEnabled(!true);
        // PATOLOGIAS
        jComboBoxHepatite.setEnabled(!true);
        jComboBoxHiv.setEnabled(!true);
        jComboBoxAsma.setEnabled(!true);
        jComboBoxFumante.setEnabled(!true);
        jComboBoxFebre.setEnabled(!true);
        jComboBoxDiabetes.setEnabled(!true);
        jComboBoxEpilepsia.setEnabled(!true);
        jComboBoxCicatrizacao.setEnabled(!true);
        jComboBoxDisturbios.setEnabled(!true);
        jComboBoxEndocardite.setEnabled(!true);
        jComboBoxHepatico.setEnabled(!true);
        jComboBoxRenal.setEnabled(!true);
        jComboBoxCardiaco.setEnabled(!true);
        jComboBoxTensao.setEnabled(!true);
        jComboBoxCirurgia.setEnabled(!true);
        jComboBoxInternacao.setEnabled(!true);
        jComboBoxSifilis.setEnabled(!true);
        jComboBoxTuberculose.setEnabled(!true);
        jComboBoxOutras.setEnabled(!true);
        jQualOutraDoenca.setEnabled(!true);
        jTextoDoenca.setEnabled(!true);
        // ODONTOGRAMA       
        jBt11.setEnabled(!true);
        jBt12.setEnabled(!true);
        jBt13.setEnabled(!true);
        jBt14.setEnabled(!true);
        jBt15.setEnabled(!true);
        jBt16.setEnabled(!true);
        jBt17.setEnabled(!true);
        jBt18.setEnabled(!true);
        //
        jBt21.setEnabled(!true);
        jBt22.setEnabled(!true);
        jBt23.setEnabled(!true);
        jBt24.setEnabled(!true);
        jBt25.setEnabled(!true);
        jBt26.setEnabled(!true);
        jBt27.setEnabled(!true);
        jBt28.setEnabled(!true);
        //
        jBt31.setEnabled(!true);
        jBt32.setEnabled(!true);
        jBt33.setEnabled(!true);
        jBt34.setEnabled(!true);
        jBt35.setEnabled(!true);
        jBt36.setEnabled(!true);
        jBt37.setEnabled(!true);
        jBt38.setEnabled(!true);
        //
        jBt41.setEnabled(!true);
        jBt42.setEnabled(!true);
        jBt43.setEnabled(!true);
        jBt44.setEnabled(!true);
        jBt45.setEnabled(!true);
        jBt46.setEnabled(!true);
        jBt47.setEnabled(!true);
        jBt48.setEnabled(!true);
        //
        jComboBoxTipoProcedimento.setEnabled(!true);
        jNumeroDente.setEnabled(!true);
        jDataOdontograma.setEnabled(!true);
        jComboBoxFacesDente.setEnabled(!true);
        jCheckBoxVermelho.setEnabled(!true);
        jCheckBoxVerde.setEnabled(!true);
        jCheckBoxAzul.setEnabled(!true);
        jPlanoTratamento.setEnabled(!true);
        // EVOLUÇÃO        
        jDataEvolucao.setEnabled(!true);
        jEvolucao.setEnabled(!true);
        //
        jDataPrescricao.setEnabled(!true);
        jPrescricaoOdontologia.setEnabled(!true);
    }

    public void limparCampos() {
        // LIMPAR CAMPOS
        jIdEvolucao.setText("");
        jNomeInternoEvolucao.setText("");
        jDataEvolucao.setDate(null);
        jEvolucao.setText("");
        // PRESCRIÇÃO
        jIdPrescricao.setText("");
        jNomeInternoPrescricao.setText("");
        jPrescricaoOdontologia.setText("");
        jDataPrescricao.setDate(null);
    }

    public void bloquearBotoes() {
        jBtPesqInterno.setEnabled(!true);
        // ADMISSÃO
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoriaOdonto.setEnabled(!true);
        //
        jBtAdicionar.setEnabled(!true);
        jBtRemover.setEnabled(!true);
        // EVOLUÇÃO
        jBtNovoEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtImpressaoEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        // PRESCRIÇÃO
        jPrescricaoOdontologia.setEnabled(!true);
        //
        jBtNovoPrescricao.setEnabled(!true);
        jBtAlterarPrescricao.setEnabled(!true);
        jBtExcluirPrescricao.setEnabled(!true);
        jBtSalvarPrescricao.setEnabled(!true);
        jBtCancelarPrescricao.setEnabled(!true);
        jBtAuditoriaPrescricao.setEnabled(!true);
        jBtImpressaoPrescricao.setEnabled(!true);
    }

    public void Novo() {
        // Limpar campos para incluir
        jIDLanc.setText("");
        jStatusLanc.setText("ABERTO");
        jDataLanc.setCalendar(Calendar.getInstance());
        jIDInterno.setText("");
        jNomeInterno.setText("");
        jFotoInternoOdonto.setIcon(null);
        //
        jComboBoxTipoAtendimento.setSelectedItem("Consulta");
        jComboBoxFumante.setSelectedItem("Não");
        jComboBoxGestante.setSelectedItem("Não");
        jTempoGestacao.setValue(0);
        jComboBoxTratamentoMedico.setSelectedItem("Não");
        jComboBoxMedicacao.setSelectedItem("Não");
        jComboBoxAlegria.setSelectedItem("Não");
        jQueixaPrincipal.setText("");
        jAfirmacao1.setText("");
        jAfirmacao2.setText("");
        jAfirmacao3.setText("");
        jObservacao.setText("");
        //
        jComboBoxHepatite.setSelectedItem("Não");
        jComboBoxHiv.setSelectedItem("Não");
        jComboBoxAsma.setSelectedItem("Não");
        jComboBoxFumante.setSelectedItem("Não");
        jComboBoxFebre.setSelectedItem("Não");
        jComboBoxDiabetes.setSelectedItem("Não");
        jComboBoxEpilepsia.setSelectedItem("Não");
        jComboBoxCicatrizacao.setSelectedItem("Não");
        jComboBoxDisturbios.setSelectedItem("Não");
        jComboBoxEndocardite.setSelectedItem("Não");
        jComboBoxHepatico.setSelectedItem("Não");
        jComboBoxRenal.setSelectedItem("Não");
        jComboBoxCardiaco.setSelectedItem("Não");
        jComboBoxTensao.setSelectedItem("Não");
        jComboBoxCirurgia.setSelectedItem("Não");
        jComboBoxInternacao.setSelectedItem("Não");
        jComboBoxSifilis.setSelectedItem("Não");
        jComboBoxTuberculose.setSelectedItem("Não");
        jComboBoxOutras.setSelectedItem("Não");
        jQualOutraDoenca.setText("");
        jTextoDoenca.setText("");
        // ODONTOGRAMA
        jComboBoxTipoProcedimento.setSelectedItem("Selecione...");
        jNumeroDente.setText("");
        jDataOdontograma.setCalendar(Calendar.getInstance());
        jComboBoxFacesDente.setSelectedItem("Selecione...");
        jCheckBoxVermelho.setSelected(!true);
        jCheckBoxVerde.setSelected(!true);
        jCheckBoxAzul.setSelected(!true);
        jPlanoTratamento.setText("");
        //
        jBtPesqInterno.setEnabled(true);
        // DADOS DA CONSULTA
        jDataLanc.setEnabled(true);
        jComboBoxTipoAtendimento.setEnabled(true);
        jComboBoxFumante.setEnabled(true);
        jComboBoxGestante.setEnabled(true);
        jTempoGestacao.setEnabled(true);
        jQueixaPrincipal.setEnabled(true);
        jComboBoxTratamentoMedico.setEnabled(true);
        jComboBoxMedicacao.setEnabled(true);
        jComboBoxAlegria.setEnabled(true);
        jAfirmacao1.setEnabled(true);
        jAfirmacao2.setEnabled(true);
        jAfirmacao3.setEnabled(true);
        jObservacao.setEnabled(true);
        // PATOLOGIAS
        jComboBoxHepatite.setEnabled(true);
        jComboBoxHiv.setEnabled(true);
        jComboBoxAsma.setEnabled(true);
        jComboBoxFumante.setEnabled(true);
        jComboBoxFebre.setEnabled(true);
        jComboBoxDiabetes.setEnabled(true);
        jComboBoxEpilepsia.setEnabled(true);
        jComboBoxCicatrizacao.setEnabled(true);
        jComboBoxDisturbios.setEnabled(true);
        jComboBoxEndocardite.setEnabled(true);
        jComboBoxHepatico.setEnabled(true);
        jComboBoxRenal.setEnabled(true);
        jComboBoxCardiaco.setEnabled(true);
        jComboBoxTensao.setEnabled(true);
        jComboBoxCirurgia.setEnabled(true);
        jComboBoxInternacao.setEnabled(true);
        jComboBoxSifilis.setEnabled(true);
        jComboBoxTuberculose.setEnabled(true);
        jComboBoxOutras.setEnabled(true);
        jQualOutraDoenca.setEnabled(true);
        jTextoDoenca.setEnabled(true);
        // ODONTOGRAMA
        jComboBoxTipoProcedimento.setEnabled(true);
        jNumeroDente.setEnabled(true);
        jDataOdontograma.setEnabled(true);
        jComboBoxFacesDente.setEnabled(true);
        jCheckBoxVermelho.setEnabled(true);
        jCheckBoxVerde.setEnabled(true);
        jCheckBoxAzul.setEnabled(true);
        jPlanoTratamento.setEnabled(true);
        //
        jBt11.setEnabled(true);
        jBt12.setEnabled(true);
        jBt13.setEnabled(true);
        jBt14.setEnabled(true);
        jBt15.setEnabled(true);
        jBt16.setEnabled(true);
        jBt17.setEnabled(true);
        jBt18.setEnabled(true);
        //
        jBt21.setEnabled(true);
        jBt22.setEnabled(true);
        jBt23.setEnabled(true);
        jBt24.setEnabled(true);
        jBt25.setEnabled(true);
        jBt26.setEnabled(true);
        jBt27.setEnabled(true);
        jBt28.setEnabled(true);
        //
        jBt31.setEnabled(true);
        jBt32.setEnabled(true);
        jBt33.setEnabled(true);
        jBt34.setEnabled(true);
        jBt35.setEnabled(true);
        jBt36.setEnabled(true);
        jBt37.setEnabled(true);
        jBt38.setEnabled(true);
        //
        jBt41.setEnabled(true);
        jBt42.setEnabled(true);
        jBt43.setEnabled(true);
        jBt44.setEnabled(true);
        jBt45.setEnabled(true);
        jBt46.setEnabled(true);
        jBt47.setEnabled(true);
        jBt48.setEnabled(true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoriaOdonto.setEnabled(!true);
        //
        jBtAdicionar.setEnabled(true);
        jBtRemover.setEnabled(true);
    }

    public void Alterar() {
        jBtPesqInterno.setEnabled(true);
        // DADOS DA CONSULTA
        jDataLanc.setEnabled(true);
        jComboBoxTipoAtendimento.setEnabled(true);
        jComboBoxFumante.setEnabled(true);
        jComboBoxGestante.setEnabled(true);
        jTempoGestacao.setEnabled(true);
        jQueixaPrincipal.setEnabled(true);
        jComboBoxTratamentoMedico.setEnabled(true);
        jComboBoxMedicacao.setEnabled(true);
        jComboBoxAlegria.setEnabled(true);
        jAfirmacao1.setEnabled(true);
        jAfirmacao2.setEnabled(true);
        jAfirmacao3.setEnabled(true);
        jObservacao.setEnabled(true);
        // PATOLOGIAS
        jComboBoxHepatite.setEnabled(true);
        jComboBoxHiv.setEnabled(true);
        jComboBoxAsma.setEnabled(true);
        jComboBoxFumante.setEnabled(true);
        jComboBoxFebre.setEnabled(true);
        jComboBoxDiabetes.setEnabled(true);
        jComboBoxEpilepsia.setEnabled(true);
        jComboBoxCicatrizacao.setEnabled(true);
        jComboBoxDisturbios.setEnabled(true);
        jComboBoxEndocardite.setEnabled(true);
        jComboBoxHepatico.setEnabled(true);
        jComboBoxRenal.setEnabled(true);
        jComboBoxCardiaco.setEnabled(true);
        jComboBoxTensao.setEnabled(true);
        jComboBoxCirurgia.setEnabled(true);
        jComboBoxInternacao.setEnabled(true);
        jComboBoxSifilis.setEnabled(true);
        jComboBoxTuberculose.setEnabled(true);
        jComboBoxOutras.setEnabled(true);
        jQualOutraDoenca.setEnabled(true);
        jTextoDoenca.setEnabled(true);
        // ODONTOGRAMA
        jComboBoxTipoProcedimento.setEnabled(true);
        jNumeroDente.setEnabled(true);
        jDataOdontograma.setEnabled(true);
        jComboBoxFacesDente.setEnabled(true);
        jCheckBoxVermelho.setEnabled(true);
        jCheckBoxVerde.setEnabled(true);
        jCheckBoxAzul.setEnabled(true);
        jPlanoTratamento.setEnabled(true);
        //
        jBt11.setEnabled(true);
        jBt12.setEnabled(true);
        jBt13.setEnabled(true);
        jBt14.setEnabled(true);
        jBt15.setEnabled(true);
        jBt16.setEnabled(true);
        jBt17.setEnabled(true);
        jBt18.setEnabled(true);
        //
        jBt21.setEnabled(true);
        jBt22.setEnabled(true);
        jBt23.setEnabled(true);
        jBt24.setEnabled(true);
        jBt25.setEnabled(true);
        jBt26.setEnabled(true);
        jBt27.setEnabled(true);
        jBt28.setEnabled(true);
        //
        jBt31.setEnabled(true);
        jBt32.setEnabled(true);
        jBt33.setEnabled(true);
        jBt34.setEnabled(true);
        jBt35.setEnabled(true);
        jBt36.setEnabled(true);
        jBt37.setEnabled(true);
        jBt38.setEnabled(true);
        //
        jBt41.setEnabled(true);
        jBt42.setEnabled(true);
        jBt43.setEnabled(true);
        jBt44.setEnabled(true);
        jBt45.setEnabled(true);
        jBt46.setEnabled(true);
        jBt47.setEnabled(true);
        jBt48.setEnabled(true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoriaOdonto.setEnabled(!true);
        //
        jBtAdicionar.setEnabled(true);
        jBtRemover.setEnabled(true);
    }

    public void Excluir() {
        jIDLanc.setText("");
        jStatusLanc.setText("ABERTO");
        jDataLanc.setCalendar(Calendar.getInstance());
        jIDInterno.setText("");
        jNomeInterno.setText("");
        jFotoInternoOdonto.setIcon(null);
        //
        jComboBoxTipoAtendimento.setSelectedItem("Consulta");
        jComboBoxFumante.setSelectedItem("Não");
        jComboBoxGestante.setSelectedItem("Não");
        jTempoGestacao.setValue(0);
        jComboBoxTratamentoMedico.setSelectedItem("Não");
        jComboBoxMedicacao.setSelectedItem("Não");
        jComboBoxAlegria.setSelectedItem("Não");
        jQueixaPrincipal.setText("");
        jAfirmacao1.setText("");
        jAfirmacao2.setText("");
        jAfirmacao3.setText("");
        jObservacao.setText("");
        //
        jComboBoxHepatite.setSelectedItem("Não");
        jComboBoxHiv.setSelectedItem("Não");
        jComboBoxAsma.setSelectedItem("Não");
        jComboBoxFumante.setSelectedItem("Não");
        jComboBoxFebre.setSelectedItem("Não");
        jComboBoxDiabetes.setSelectedItem("Não");
        jComboBoxEpilepsia.setSelectedItem("Não");
        jComboBoxCicatrizacao.setSelectedItem("Não");
        jComboBoxDisturbios.setSelectedItem("Não");
        jComboBoxEndocardite.setSelectedItem("Não");
        jComboBoxHepatico.setSelectedItem("Não");
        jComboBoxRenal.setSelectedItem("Não");
        jComboBoxCardiaco.setSelectedItem("Não");
        jComboBoxTensao.setSelectedItem("Não");
        jComboBoxCirurgia.setSelectedItem("Não");
        jComboBoxInternacao.setSelectedItem("Não");
        jComboBoxSifilis.setSelectedItem("Não");
        jComboBoxTuberculose.setSelectedItem("Não");
        jComboBoxOutras.setSelectedItem("Não");
        jQualOutraDoenca.setText("");
        jTextoDoenca.setText("");
        // ODONTOGRAMA
        jComboBoxTipoProcedimento.setSelectedItem("Selecione...");
        jNumeroDente.setText("");
        jDataOdontograma.setDate(null);
        jComboBoxFacesDente.setSelectedItem("Selecione...");
        jCheckBoxVermelho.setSelected(!true);
        jCheckBoxVerde.setSelected(!true);
        jCheckBoxAzul.setSelected(!true);
        jPlanoTratamento.setText("");
        //
        jDataLanc.setEnabled(!true);
        jComboBoxTipoAtendimento.setEnabled(!true);
        jComboBoxFumante.setEnabled(!true);
        jComboBoxGestante.setEnabled(!true);
        jTempoGestacao.setEnabled(!true);
        jQueixaPrincipal.setEnabled(!true);
        jComboBoxTratamentoMedico.setEnabled(!true);
        jComboBoxMedicacao.setEnabled(!true);
        jComboBoxAlegria.setEnabled(!true);
        jAfirmacao1.setEnabled(!true);
        jAfirmacao2.setEnabled(!true);
        jAfirmacao3.setEnabled(!true);
        jObservacao.setEnabled(!true);
        // PATOLOGIAS
        jComboBoxHepatite.setEnabled(!true);
        jComboBoxHiv.setEnabled(!true);
        jComboBoxAsma.setEnabled(!true);
        jComboBoxFumante.setEnabled(!true);
        jComboBoxFebre.setEnabled(!true);
        jComboBoxDiabetes.setEnabled(!true);
        jComboBoxEpilepsia.setEnabled(!true);
        jComboBoxCicatrizacao.setEnabled(!true);
        jComboBoxDisturbios.setEnabled(!true);
        jComboBoxEndocardite.setEnabled(!true);
        jComboBoxHepatico.setEnabled(!true);
        jComboBoxRenal.setEnabled(!true);
        jComboBoxCardiaco.setEnabled(!true);
        jComboBoxTensao.setEnabled(!true);
        jComboBoxCirurgia.setEnabled(!true);
        jComboBoxInternacao.setEnabled(!true);
        jComboBoxSifilis.setEnabled(!true);
        jComboBoxTuberculose.setEnabled(!true);
        jComboBoxOutras.setEnabled(!true);
        jQualOutraDoenca.setEnabled(!true);
        jTextoDoenca.setEnabled(!true);
        // ODONTOGRAMA
        jBt11.setEnabled(!true);
        jBt12.setEnabled(!true);
        jBt13.setEnabled(!true);
        jBt14.setEnabled(!true);
        jBt15.setEnabled(!true);
        jBt16.setEnabled(!true);
        jBt17.setEnabled(!true);
        jBt18.setEnabled(!true);
        //
        jBt21.setEnabled(!true);
        jBt22.setEnabled(!true);
        jBt23.setEnabled(!true);
        jBt24.setEnabled(!true);
        jBt25.setEnabled(!true);
        jBt26.setEnabled(!true);
        jBt27.setEnabled(!true);
        jBt28.setEnabled(!true);
        //
        jBt31.setEnabled(!true);
        jBt32.setEnabled(!true);
        jBt33.setEnabled(!true);
        jBt34.setEnabled(!true);
        jBt35.setEnabled(!true);
        jBt36.setEnabled(!true);
        jBt37.setEnabled(!true);
        jBt38.setEnabled(!true);
        //
        jBt41.setEnabled(!true);
        jBt42.setEnabled(!true);
        jBt43.setEnabled(!true);
        jBt44.setEnabled(!true);
        jBt45.setEnabled(!true);
        jBt46.setEnabled(!true);
        jBt47.setEnabled(!true);
        jBt48.setEnabled(!true);
        //
        jComboBoxTipoProcedimento.setEnabled(!true);
        jNumeroDente.setEnabled(!true);
        jDataOdontograma.setEnabled(!true);
        jComboBoxFacesDente.setEnabled(!true);
        jCheckBoxVermelho.setEnabled(!true);
        jCheckBoxVerde.setEnabled(!true);
        jCheckBoxAzul.setEnabled(!true);
        jPlanoTratamento.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoriaOdonto.setEnabled(!true);
        //
        jBtAdicionar.setEnabled(!true);
        jBtRemover.setEnabled(!true);
    }

    public void Salvar() {
        //
        jDataLanc.setEnabled(!true);
        jComboBoxTipoAtendimento.setEnabled(!true);
        jComboBoxFumante.setEnabled(!true);
        jComboBoxGestante.setEnabled(!true);
        jTempoGestacao.setEnabled(!true);
        jQueixaPrincipal.setEnabled(!true);
        jComboBoxTratamentoMedico.setEnabled(!true);
        jComboBoxMedicacao.setEnabled(!true);
        jComboBoxAlegria.setEnabled(!true);
        jAfirmacao1.setEnabled(!true);
        jAfirmacao2.setEnabled(!true);
        jAfirmacao3.setEnabled(!true);
        jObservacao.setEnabled(!true);
        // PATOLOGIAS
        jComboBoxHepatite.setEnabled(!true);
        jComboBoxHiv.setEnabled(!true);
        jComboBoxAsma.setEnabled(!true);
        jComboBoxFumante.setEnabled(!true);
        jComboBoxFebre.setEnabled(!true);
        jComboBoxDiabetes.setEnabled(!true);
        jComboBoxEpilepsia.setEnabled(!true);
        jComboBoxCicatrizacao.setEnabled(!true);
        jComboBoxDisturbios.setEnabled(!true);
        jComboBoxEndocardite.setEnabled(!true);
        jComboBoxHepatico.setEnabled(!true);
        jComboBoxRenal.setEnabled(!true);
        jComboBoxCardiaco.setEnabled(!true);
        jComboBoxTensao.setEnabled(!true);
        jComboBoxCirurgia.setEnabled(!true);
        jComboBoxInternacao.setEnabled(!true);
        jComboBoxSifilis.setEnabled(!true);
        jComboBoxTuberculose.setEnabled(!true);
        jComboBoxOutras.setEnabled(!true);
        jQualOutraDoenca.setEnabled(!true);
        jTextoDoenca.setEnabled(!true);
        // ODONTOGRAMA
        jComboBoxTipoProcedimento.setEnabled(!true);
        jNumeroDente.setEnabled(!true);
        jDataOdontograma.setEnabled(!true);
        jComboBoxFacesDente.setEnabled(!true);
        jCheckBoxVermelho.setEnabled(!true);
        jCheckBoxVerde.setEnabled(!true);
        jCheckBoxAzul.setEnabled(!true);
        jPlanoTratamento.setEnabled(!true);
        //
        jBt11.setEnabled(!true);
        jBt12.setEnabled(!true);
        jBt13.setEnabled(!true);
        jBt14.setEnabled(!true);
        jBt15.setEnabled(!true);
        jBt16.setEnabled(!true);
        jBt17.setEnabled(!true);
        jBt18.setEnabled(!true);
        //
        jBt21.setEnabled(!true);
        jBt22.setEnabled(!true);
        jBt23.setEnabled(!true);
        jBt24.setEnabled(!true);
        jBt25.setEnabled(!true);
        jBt26.setEnabled(!true);
        jBt27.setEnabled(!true);
        jBt28.setEnabled(!true);
        //
        jBt31.setEnabled(!true);
        jBt32.setEnabled(!true);
        jBt33.setEnabled(!true);
        jBt34.setEnabled(!true);
        jBt35.setEnabled(!true);
        jBt36.setEnabled(!true);
        jBt37.setEnabled(!true);
        jBt38.setEnabled(!true);
        //
        jBt41.setEnabled(!true);
        jBt42.setEnabled(!true);
        jBt43.setEnabled(!true);
        jBt44.setEnabled(!true);
        jBt45.setEnabled(!true);
        jBt46.setEnabled(!true);
        jBt47.setEnabled(!true);
        jBt48.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoriaOdonto.setEnabled(true);
        //
        jBtNovoEvolucao.setEnabled(true);
        jBtNovoPrescricao.setEnabled(true);
        //
        jBtAdicionar.setEnabled(!true);
        jBtRemover.setEnabled(!true);
    }

    public void Cancelar() {
        if (jIDLanc.getText().equals("")) {
            jStatusLanc.setText("ABERTO");
            jDataLanc.setCalendar(Calendar.getInstance());
            jIDInterno.setText("");
            jNomeInterno.setText("");
            jFotoInternoOdonto.setIcon(null);
            //
            jComboBoxTipoAtendimento.setSelectedItem("Consulta");
            jComboBoxFumante.setSelectedItem("Não");
            jComboBoxGestante.setSelectedItem("Não");
            jTempoGestacao.setValue(0);
            jComboBoxTratamentoMedico.setSelectedItem("Não");
            jComboBoxMedicacao.setSelectedItem("Não");
            jComboBoxAlegria.setSelectedItem("Não");
            jQueixaPrincipal.setText("");
            jAfirmacao1.setText("");
            jAfirmacao2.setText("");
            jAfirmacao3.setText("");
            jObservacao.setText("");
            //
            jComboBoxHepatite.setSelectedItem("Não");
            jComboBoxHiv.setSelectedItem("Não");
            jComboBoxAsma.setSelectedItem("Não");
            jComboBoxFumante.setSelectedItem("Não");
            jComboBoxFebre.setSelectedItem("Não");
            jComboBoxDiabetes.setSelectedItem("Não");
            jComboBoxEpilepsia.setSelectedItem("Não");
            jComboBoxCicatrizacao.setSelectedItem("Não");
            jComboBoxDisturbios.setSelectedItem("Não");
            jComboBoxEndocardite.setSelectedItem("Não");
            jComboBoxHepatico.setSelectedItem("Não");
            jComboBoxRenal.setSelectedItem("Não");
            jComboBoxCardiaco.setSelectedItem("Não");
            jComboBoxTensao.setSelectedItem("Não");
            jComboBoxCirurgia.setSelectedItem("Não");
            jComboBoxInternacao.setSelectedItem("Não");
            jComboBoxSifilis.setSelectedItem("Não");
            jComboBoxTuberculose.setSelectedItem("Não");
            jComboBoxOutras.setSelectedItem("Não");
            jQualOutraDoenca.setText("");
            jTextoDoenca.setText("");
            // ODONTOGRAMA
            jComboBoxTipoProcedimento.setSelectedItem("Selecione...");
            jNumeroDente.setText("");
            jDataOdontograma.setDate(null);
            jComboBoxFacesDente.setSelectedItem("Selecione...");
            jCheckBoxVermelho.setSelected(!true);
            jCheckBoxVerde.setSelected(!true);
            jCheckBoxAzul.setSelected(!true);
            jPlanoTratamento.setText("");
            //
            jDataLanc.setEnabled(!true);
            jComboBoxTipoAtendimento.setEnabled(!true);
            jComboBoxFumante.setEnabled(!true);
            jComboBoxGestante.setEnabled(!true);
            jTempoGestacao.setEnabled(!true);
            jQueixaPrincipal.setEnabled(!true);
            jComboBoxTratamentoMedico.setEnabled(!true);
            jComboBoxMedicacao.setEnabled(!true);
            jComboBoxAlegria.setEnabled(!true);
            jAfirmacao1.setEnabled(!true);
            jAfirmacao2.setEnabled(!true);
            jAfirmacao3.setEnabled(!true);
            jObservacao.setEnabled(!true);
            // PATOLOGIAS
            jComboBoxHepatite.setEnabled(!true);
            jComboBoxHiv.setEnabled(!true);
            jComboBoxAsma.setEnabled(!true);
            jComboBoxFumante.setEnabled(!true);
            jComboBoxFebre.setEnabled(!true);
            jComboBoxDiabetes.setEnabled(!true);
            jComboBoxEpilepsia.setEnabled(!true);
            jComboBoxCicatrizacao.setEnabled(!true);
            jComboBoxDisturbios.setEnabled(!true);
            jComboBoxEndocardite.setEnabled(!true);
            jComboBoxHepatico.setEnabled(!true);
            jComboBoxRenal.setEnabled(!true);
            jComboBoxCardiaco.setEnabled(!true);
            jComboBoxTensao.setEnabled(!true);
            jComboBoxCirurgia.setEnabled(!true);
            jComboBoxInternacao.setEnabled(!true);
            jComboBoxSifilis.setEnabled(!true);
            jComboBoxTuberculose.setEnabled(!true);
            jComboBoxOutras.setEnabled(!true);
            jQualOutraDoenca.setEnabled(!true);
            jTextoDoenca.setEnabled(!true);
            // ODONTOGRAMA
            jComboBoxTipoProcedimento.setEnabled(!true);
            jNumeroDente.setEnabled(!true);
            jDataOdontograma.setEnabled(!true);
            jComboBoxFacesDente.setEnabled(!true);
            jCheckBoxVermelho.setEnabled(!true);
            jCheckBoxVerde.setEnabled(!true);
            jCheckBoxAzul.setEnabled(!true);
            jPlanoTratamento.setEnabled(!true);
            //
            jBt11.setEnabled(!true);
            jBt12.setEnabled(!true);
            jBt13.setEnabled(!true);
            jBt14.setEnabled(!true);
            jBt15.setEnabled(!true);
            jBt16.setEnabled(!true);
            jBt17.setEnabled(!true);
            jBt18.setEnabled(!true);
            //
            jBt21.setEnabled(!true);
            jBt22.setEnabled(!true);
            jBt23.setEnabled(!true);
            jBt24.setEnabled(!true);
            jBt25.setEnabled(!true);
            jBt26.setEnabled(!true);
            jBt27.setEnabled(!true);
            jBt28.setEnabled(!true);
            //
            jBt31.setEnabled(!true);
            jBt32.setEnabled(!true);
            jBt33.setEnabled(!true);
            jBt34.setEnabled(!true);
            jBt35.setEnabled(!true);
            jBt36.setEnabled(!true);
            jBt37.setEnabled(!true);
            jBt38.setEnabled(!true);
            //
            jBt41.setEnabled(!true);
            jBt42.setEnabled(!true);
            jBt43.setEnabled(!true);
            jBt44.setEnabled(!true);
            jBt45.setEnabled(!true);
            jBt46.setEnabled(!true);
            jBt47.setEnabled(!true);
            jBt48.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
            jBtAuditoriaOdonto.setEnabled(!true);
            //
            jBtAdicionar.setEnabled(!true);
            jBtRemover.setEnabled(!true);
            //
            jBtNovoEvolucao.setEnabled(!true);
            jBtNovoPrescricao.setEnabled(!true);
        } else {
            jDataLanc.setEnabled(!true);
            jComboBoxTipoAtendimento.setEnabled(!true);
            jComboBoxFumante.setEnabled(!true);
            jComboBoxGestante.setEnabled(!true);
            jTempoGestacao.setEnabled(!true);
            jQueixaPrincipal.setEnabled(!true);
            jComboBoxTratamentoMedico.setEnabled(!true);
            jComboBoxMedicacao.setEnabled(!true);
            jComboBoxAlegria.setEnabled(!true);
            jAfirmacao1.setEnabled(!true);
            jAfirmacao2.setEnabled(!true);
            jAfirmacao3.setEnabled(!true);
            jObservacao.setEnabled(!true);
            // PATOLOGIAS
            jComboBoxHepatite.setEnabled(!true);
            jComboBoxHiv.setEnabled(!true);
            jComboBoxAsma.setEnabled(!true);
            jComboBoxFumante.setEnabled(!true);
            jComboBoxFebre.setEnabled(!true);
            jComboBoxDiabetes.setEnabled(!true);
            jComboBoxEpilepsia.setEnabled(!true);
            jComboBoxCicatrizacao.setEnabled(!true);
            jComboBoxDisturbios.setEnabled(!true);
            jComboBoxEndocardite.setEnabled(!true);
            jComboBoxHepatico.setEnabled(!true);
            jComboBoxRenal.setEnabled(!true);
            jComboBoxCardiaco.setEnabled(!true);
            jComboBoxTensao.setEnabled(!true);
            jComboBoxCirurgia.setEnabled(!true);
            jComboBoxInternacao.setEnabled(!true);
            jComboBoxSifilis.setEnabled(!true);
            jComboBoxTuberculose.setEnabled(!true);
            jComboBoxOutras.setEnabled(!true);
            jQualOutraDoenca.setEnabled(!true);
            jTextoDoenca.setEnabled(!true);
            // ODONTOGRAMA
            jComboBoxTipoProcedimento.setEnabled(!true);
            jNumeroDente.setEnabled(!true);
            jDataOdontograma.setEnabled(!true);
            jComboBoxFacesDente.setEnabled(!true);
            jCheckBoxVermelho.setEnabled(!true);
            jCheckBoxVerde.setEnabled(!true);
            jCheckBoxAzul.setEnabled(!true);
            jPlanoTratamento.setEnabled(!true);
            //
            jBt11.setEnabled(!true);
            jBt12.setEnabled(!true);
            jBt13.setEnabled(!true);
            jBt14.setEnabled(!true);
            jBt15.setEnabled(!true);
            jBt16.setEnabled(!true);
            jBt17.setEnabled(!true);
            jBt18.setEnabled(!true);
            //
            jBt21.setEnabled(!true);
            jBt22.setEnabled(!true);
            jBt23.setEnabled(!true);
            jBt24.setEnabled(!true);
            jBt25.setEnabled(!true);
            jBt26.setEnabled(!true);
            jBt27.setEnabled(!true);
            jBt28.setEnabled(!true);
            //
            jBt31.setEnabled(!true);
            jBt32.setEnabled(!true);
            jBt33.setEnabled(!true);
            jBt34.setEnabled(!true);
            jBt35.setEnabled(!true);
            jBt36.setEnabled(!true);
            jBt37.setEnabled(!true);
            jBt38.setEnabled(!true);
            //
            jBt41.setEnabled(!true);
            jBt42.setEnabled(!true);
            jBt43.setEnabled(!true);
            jBt44.setEnabled(!true);
            jBt45.setEnabled(!true);
            jBt46.setEnabled(!true);
            jBt47.setEnabled(!true);
            jBt48.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoriaOdonto.setEnabled(true);
            //
            jBtNovoEvolucao.setEnabled(true);
            jBtNovoPrescricao.setEnabled(true);
            //
            jBtAdicionar.setEnabled(!true);
            jBtRemover.setEnabled(!true);
        }
    }

    public void preencherComboNovo() {
        codigoProcedimento = "";
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PROCEDIMENTOS_ODONTOLOGICO ORDER BY DescricaoProcedimento");
            conecta.rs.first();
            do {
                jComboBoxTipoProcedimento.addItem(conecta.rs.getString("DescricaoProcedimento"));
                codigoProcedimento = conecta.rs.getString("IdProcOdonto");
            } while (conecta.rs.next());
        } catch (SQLException ex) {//           
        }
        conecta.desconecta();
    }

    public void Finalizar() {
        statusMov = "Finalizou";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        String statusAtend = "FINALIZADO";
        JOptionPane.showMessageDialog(rootPane, "Se esse atendimento for finaliza,\nvocê não poderá mais excluir ou alterar.");
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente FINALIZA o ATENDIMENTO selecionado?", "Confirmação",
                JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            objAtendOdonto.setStatusLanc(statusAtend);
            objAtendOdonto.setIdLanc(Integer.parseInt(jIDPesqAtend.getText()));
            control.finalizarAtendOdonto(objAtendOdonto);
            objAtendOdonto.setIdLanc(Integer.valueOf(jIDPesqAtend.getText()));
            controle.finalizarMovTec(objAtendOdonto);
            jStatusLanc.setText(statusAtend);
            JOptionPane.showMessageDialog(rootPane, "Registro FINALIZADO com sucesso !!!");
            //
            jBtPesqInterno.setEnabled(!true);
            jDataLanc.setEnabled(!true);
            jComboBoxTipoAtendimento.setEnabled(!true);
            jComboBoxTratamentoMedico.setEnabled(!true);
            jComboBoxMedicacao.setEnabled(!true);
            jComboBoxAlegria.setEnabled(!true);
            jQueixaPrincipal.setEnabled(!true);
            jAfirmacao1.setEnabled(!true);
            jAfirmacao2.setEnabled(!true);
            jAfirmacao3.setEnabled(!true);
            jPlanoTratamento.setEnabled(!true);
            //
            jComboBoxHepatite.setEnabled(!true);
            jComboBoxHiv.setEnabled(!true);
            jComboBoxAsma.setEnabled(!true);
            jComboBoxFumante.setEnabled(!true);
            jComboBoxFebre.setEnabled(!true);
            jComboBoxDiabetes.setEnabled(!true);
            jComboBoxEpilepsia.setEnabled(!true);
            jComboBoxCicatrizacao.setEnabled(!true);
            jComboBoxDisturbios.setEnabled(!true);
            jComboBoxEndocardite.setEnabled(!true);
            jComboBoxHepatico.setEnabled(!true);
            jComboBoxRenal.setEnabled(!true);
            jComboBoxCardiaco.setEnabled(!true);
            jComboBoxTensao.setEnabled(!true);
            jComboBoxCirurgia.setEnabled(!true);
            jComboBoxInternacao.setEnabled(!true);
            jTextoDoenca.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
            //
            jBtNovoEvolucao.setEnabled(!true);
            jBtAlterarEvolucao.setEnabled(!true);
            jBtExcluirEvolucao.setEnabled(!true);
            jBtSalvarEvolucao.setEnabled(!true);
            jBtCancelarEvolucao.setEnabled(!true);
            //
            jDataEvolucao.setEnabled(!true);
            jEvolucao.setEnabled(!true);
        }
    }

    public void NovoProcedimento() {
        jIdEvolucao.setText("");
        jDataEvolucao.setCalendar(Calendar.getInstance());
        jNomeInternoEvolucao.setText(jNomeInterno.getText());
        jEvolucao.setText("");
        //            
        jDataEvolucao.setEnabled(true);
        jEvolucao.setEnabled(true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        //
        jBtNovoEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(true);
        jBtCancelarEvolucao.setEnabled(true);
        //
        jBtPesqInterno.setEnabled(!true);
        jDataLanc.setEnabled(!true);
        jComboBoxTipoAtendimento.setEnabled(!true);
        jComboBoxTratamentoMedico.setEnabled(!true);
        jComboBoxMedicacao.setEnabled(!true);
        jComboBoxAlegria.setEnabled(!true);
        jQueixaPrincipal.setEnabled(!true);
        jAfirmacao1.setEnabled(!true);
        jAfirmacao2.setEnabled(!true);
        jAfirmacao3.setEnabled(!true);
        jPlanoTratamento.setEnabled(!true);
        //
        jComboBoxHepatite.setEnabled(!true);
        jComboBoxHiv.setEnabled(!true);
        jComboBoxAsma.setEnabled(!true);
        jComboBoxFumante.setEnabled(!true);
        jComboBoxFebre.setEnabled(!true);
        jComboBoxDiabetes.setEnabled(!true);
        jComboBoxEpilepsia.setEnabled(!true);
        jComboBoxCicatrizacao.setEnabled(!true);
        jComboBoxDisturbios.setEnabled(!true);
        jComboBoxEndocardite.setEnabled(!true);
        jComboBoxHepatico.setEnabled(!true);
        jComboBoxRenal.setEnabled(!true);
        jComboBoxCardiaco.setEnabled(!true);
        jComboBoxTensao.setEnabled(!true);
        jComboBoxCirurgia.setEnabled(!true);
        jComboBoxInternacao.setEnabled(!true);
        jTextoDoenca.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoriaOdonto.setEnabled(!true);
        //
    }

    public void AlterarProcedimento() {
        //       
        jDataEvolucao.setEnabled(true);
        jEvolucao.setEnabled(true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        //
        jBtNovoEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(true);
        jBtCancelarEvolucao.setEnabled(true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        //
        jBtPesqInterno.setEnabled(!true);
        jDataLanc.setEnabled(!true);
        jComboBoxTipoAtendimento.setEnabled(!true);
        jComboBoxTratamentoMedico.setEnabled(!true);
        jComboBoxMedicacao.setEnabled(!true);
        jComboBoxAlegria.setEnabled(!true);
        jQueixaPrincipal.setEnabled(!true);
        jAfirmacao1.setEnabled(!true);
        jAfirmacao2.setEnabled(!true);
        jAfirmacao3.setEnabled(!true);
        jPlanoTratamento.setEnabled(!true);
        //
        jComboBoxHepatite.setEnabled(!true);
        jComboBoxHiv.setEnabled(!true);
        jComboBoxAsma.setEnabled(!true);
        jComboBoxFumante.setEnabled(!true);
        jComboBoxFebre.setEnabled(!true);
        jComboBoxDiabetes.setEnabled(!true);
        jComboBoxEpilepsia.setEnabled(!true);
        jComboBoxCicatrizacao.setEnabled(!true);
        jComboBoxDisturbios.setEnabled(!true);
        jComboBoxEndocardite.setEnabled(!true);
        jComboBoxHepatico.setEnabled(!true);
        jComboBoxRenal.setEnabled(!true);
        jComboBoxCardiaco.setEnabled(!true);
        jComboBoxTensao.setEnabled(!true);
        jComboBoxCirurgia.setEnabled(!true);
        jComboBoxInternacao.setEnabled(!true);
        jTextoDoenca.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoriaOdonto.setEnabled(!true);
        //
    }

    public void ExcluirProcedimento() {
        jIdEvolucao.setText("");
        jDataEvolucao.setDate(null);
        jEvolucao.setText("");
        jNomeInternoEvolucao.setText("");
        //       
        jDataEvolucao.setEnabled(!true);
        jEvolucao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        //
        jBtNovoEvolucao.setEnabled(true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
    }

    public void SalvarProcedimento() {
        //       
        jDataEvolucao.setEnabled(!true);
        jEvolucao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        //
        jBtNovoEvolucao.setEnabled(true);
        jBtAlterarEvolucao.setEnabled(true);
        jBtExcluirEvolucao.setEnabled(true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(true);
        //
        jBtNovoPrescricao.setEnabled(true);
    }

    public void CancelarProcedimento() {
        jIdEvolucao.setText("");
        jNomeInternoEvolucao.setText("");
        jDataEvolucao.setDate(null);
        jEvolucao.setText("");
        //       
        jDataEvolucao.setEnabled(!true);
        jEvolucao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        //
        jBtNovoEvolucao.setEnabled(true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        //
        jBtNovoPrescricao.setEnabled(true);
    }

    public void NovaPrescricao() {
        //
        jIdPrescricao.setText("");
        jNomeInternoPrescricao.setText(jNomeInterno.getText());
        jPrescricaoOdontologia.setText("");
        //
        jDataPrescricao.setCalendar(Calendar.getInstance());
        jPrescricaoOdontologia.setEnabled(true);
        //
        jBtNovoPrescricao.setEnabled(!true);
        jBtAlterarPrescricao.setEnabled(!true);
        jBtExcluirPrescricao.setEnabled(!true);
        jBtSalvarPrescricao.setEnabled(true);
        jBtCancelarPrescricao.setEnabled(true);
        jBtAuditoriaPrescricao.setEnabled(!true);
        //
        jIdEvolucao.setText("");
        jDataEvolucao.setDate(null);
        jNomeInternoEvolucao.setText("");
        jEvolucao.setText("");
        //            
        jDataEvolucao.setEnabled(!true);
        jEvolucao.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        //
        jBtNovoEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        //
        jBtPesqInterno.setEnabled(!true);
        jDataLanc.setEnabled(!true);
        jComboBoxTipoAtendimento.setEnabled(!true);
        jComboBoxTratamentoMedico.setEnabled(!true);
        jComboBoxMedicacao.setEnabled(!true);
        jComboBoxAlegria.setEnabled(!true);
        jQueixaPrincipal.setEnabled(!true);
        jAfirmacao1.setEnabled(!true);
        jAfirmacao2.setEnabled(!true);
        jAfirmacao3.setEnabled(!true);
        jPlanoTratamento.setEnabled(!true);
        //
        jComboBoxHepatite.setEnabled(!true);
        jComboBoxHiv.setEnabled(!true);
        jComboBoxAsma.setEnabled(!true);
        jComboBoxFumante.setEnabled(!true);
        jComboBoxFebre.setEnabled(!true);
        jComboBoxDiabetes.setEnabled(!true);
        jComboBoxEpilepsia.setEnabled(!true);
        jComboBoxCicatrizacao.setEnabled(!true);
        jComboBoxDisturbios.setEnabled(!true);
        jComboBoxEndocardite.setEnabled(!true);
        jComboBoxHepatico.setEnabled(!true);
        jComboBoxRenal.setEnabled(!true);
        jComboBoxCardiaco.setEnabled(!true);
        jComboBoxTensao.setEnabled(!true);
        jComboBoxCirurgia.setEnabled(!true);
        jComboBoxInternacao.setEnabled(!true);
        jTextoDoenca.setEnabled(!true);
    }

    public void AlterarPrescricao() {
        jDataPrescricao.setCalendar(Calendar.getInstance());
        jPrescricaoOdontologia.setEnabled(true);
        //
        jBtNovoPrescricao.setEnabled(!true);
        jBtAlterarPrescricao.setEnabled(!true);
        jBtExcluirPrescricao.setEnabled(!true);
        jBtSalvarPrescricao.setEnabled(true);
        jBtCancelarPrescricao.setEnabled(true);
        jBtAuditoriaPrescricao.setEnabled(!true);
        //
        jIdEvolucao.setText("");
        jDataEvolucao.setDate(null);
        jNomeInternoEvolucao.setText("");
        jEvolucao.setText("");
        //            
        jDataEvolucao.setEnabled(!true);
        jEvolucao.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        //
        jBtNovoEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        //
        jBtPesqInterno.setEnabled(!true);
        jDataLanc.setEnabled(!true);
        jComboBoxTipoAtendimento.setEnabled(!true);
        jComboBoxTratamentoMedico.setEnabled(!true);
        jComboBoxMedicacao.setEnabled(!true);
        jComboBoxAlegria.setEnabled(!true);
        jQueixaPrincipal.setEnabled(!true);
        jAfirmacao1.setEnabled(!true);
        jAfirmacao2.setEnabled(!true);
        jAfirmacao3.setEnabled(!true);
        jPlanoTratamento.setEnabled(!true);
        //
        jComboBoxHepatite.setEnabled(!true);
        jComboBoxHiv.setEnabled(!true);
        jComboBoxAsma.setEnabled(!true);
        jComboBoxFumante.setEnabled(!true);
        jComboBoxFebre.setEnabled(!true);
        jComboBoxDiabetes.setEnabled(!true);
        jComboBoxEpilepsia.setEnabled(!true);
        jComboBoxCicatrizacao.setEnabled(!true);
        jComboBoxDisturbios.setEnabled(!true);
        jComboBoxEndocardite.setEnabled(!true);
        jComboBoxHepatico.setEnabled(!true);
        jComboBoxRenal.setEnabled(!true);
        jComboBoxCardiaco.setEnabled(!true);
        jComboBoxTensao.setEnabled(!true);
        jComboBoxCirurgia.setEnabled(!true);
        jComboBoxInternacao.setEnabled(!true);
        jTextoDoenca.setEnabled(!true);
    }

    public void ExcluirPrescricao() {
        //
        jIdPrescricao.setText("");
        jNomeInternoPrescricao.setText("");
        jPrescricaoOdontologia.setText("");
        //
        jDataPrescricao.setDate(null);
        jPrescricaoOdontologia.setEnabled(!true);
        //
        jBtNovoPrescricao.setEnabled(true);
        jBtAlterarPrescricao.setEnabled(!true);
        jBtExcluirPrescricao.setEnabled(!true);
        jBtSalvarPrescricao.setEnabled(!true);
        jBtCancelarPrescricao.setEnabled(!true);
        jBtAuditoriaPrescricao.setEnabled(!true);
        //
        jIdEvolucao.setText("");
        jDataEvolucao.setDate(null);
        jNomeInternoEvolucao.setText("");
        jEvolucao.setText("");
        //            
        jDataEvolucao.setEnabled(!true);
        jEvolucao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        //
        jBtNovoEvolucao.setEnabled(true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        //
        jBtPesqInterno.setEnabled(!true);
        jDataLanc.setEnabled(!true);
        jComboBoxTipoAtendimento.setEnabled(!true);
        jComboBoxTratamentoMedico.setEnabled(!true);
        jComboBoxMedicacao.setEnabled(!true);
        jComboBoxAlegria.setEnabled(!true);
        jQueixaPrincipal.setEnabled(!true);
        jAfirmacao1.setEnabled(!true);
        jAfirmacao2.setEnabled(!true);
        jAfirmacao3.setEnabled(!true);
        jPlanoTratamento.setEnabled(!true);
        //
        jComboBoxHepatite.setEnabled(!true);
        jComboBoxHiv.setEnabled(!true);
        jComboBoxAsma.setEnabled(!true);
        jComboBoxFumante.setEnabled(!true);
        jComboBoxFebre.setEnabled(!true);
        jComboBoxDiabetes.setEnabled(!true);
        jComboBoxEpilepsia.setEnabled(!true);
        jComboBoxCicatrizacao.setEnabled(!true);
        jComboBoxDisturbios.setEnabled(!true);
        jComboBoxEndocardite.setEnabled(!true);
        jComboBoxHepatico.setEnabled(!true);
        jComboBoxRenal.setEnabled(!true);
        jComboBoxCardiaco.setEnabled(!true);
        jComboBoxTensao.setEnabled(!true);
        jComboBoxCirurgia.setEnabled(!true);
        jComboBoxInternacao.setEnabled(!true);
        jTextoDoenca.setEnabled(!true);
    }

    public void SalvarPrescricao() {
        jIdPrescricao.setText("");
        jNomeInternoPrescricao.setText("");
        jPrescricaoOdontologia.setText("");
        //
        jDataPrescricao.setDate(null);
        jPrescricaoOdontologia.setEnabled(!true);
        //
        jBtNovoPrescricao.setEnabled(true);
        jBtAlterarPrescricao.setEnabled(!true);
        jBtExcluirPrescricao.setEnabled(!true);
        jBtSalvarPrescricao.setEnabled(!true);
        jBtCancelarPrescricao.setEnabled(!true);
        jBtAuditoriaPrescricao.setEnabled(!true);
        //            
        jDataEvolucao.setEnabled(!true);
        jEvolucao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoriaEvolucao.setEnabled(true);
        //
        jBtNovoEvolucao.setEnabled(true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        //
        jBtPesqInterno.setEnabled(!true);
        jDataLanc.setEnabled(!true);
        jComboBoxTipoAtendimento.setEnabled(!true);
        jComboBoxTratamentoMedico.setEnabled(!true);
        jComboBoxMedicacao.setEnabled(!true);
        jComboBoxAlegria.setEnabled(!true);
        jQueixaPrincipal.setEnabled(!true);
        jAfirmacao1.setEnabled(!true);
        jAfirmacao2.setEnabled(!true);
        jAfirmacao3.setEnabled(!true);
        jPlanoTratamento.setEnabled(!true);
        //
        jComboBoxHepatite.setEnabled(!true);
        jComboBoxHiv.setEnabled(!true);
        jComboBoxAsma.setEnabled(!true);
        jComboBoxFumante.setEnabled(!true);
        jComboBoxFebre.setEnabled(!true);
        jComboBoxDiabetes.setEnabled(!true);
        jComboBoxEpilepsia.setEnabled(!true);
        jComboBoxCicatrizacao.setEnabled(!true);
        jComboBoxDisturbios.setEnabled(!true);
        jComboBoxEndocardite.setEnabled(!true);
        jComboBoxHepatico.setEnabled(!true);
        jComboBoxRenal.setEnabled(!true);
        jComboBoxCardiaco.setEnabled(!true);
        jComboBoxTensao.setEnabled(!true);
        jComboBoxCirurgia.setEnabled(!true);
        jComboBoxInternacao.setEnabled(!true);
        jTextoDoenca.setEnabled(!true);
    }

    public void CancelarPrescricao() {
        jIdPrescricao.setText("");
        jNomeInternoPrescricao.setText("");
        jPrescricaoOdontologia.setText("");
        //
        jDataPrescricao.setDate(null);
        jPrescricaoOdontologia.setEnabled(!true);
        //
        jBtNovoPrescricao.setEnabled(true);
        jBtAlterarPrescricao.setEnabled(!true);
        jBtExcluirPrescricao.setEnabled(!true);
        jBtSalvarPrescricao.setEnabled(!true);
        jBtCancelarPrescricao.setEnabled(!true);
        jBtAuditoriaPrescricao.setEnabled(!true);
        //            
        jDataEvolucao.setEnabled(!true);
        jEvolucao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoriaEvolucao.setEnabled(true);
        //
        jBtNovoEvolucao.setEnabled(true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        //
        jBtPesqInterno.setEnabled(!true);
        jDataLanc.setEnabled(!true);
        jComboBoxTipoAtendimento.setEnabled(!true);
        jComboBoxTratamentoMedico.setEnabled(!true);
        jComboBoxMedicacao.setEnabled(!true);
        jComboBoxAlegria.setEnabled(!true);
        jQueixaPrincipal.setEnabled(!true);
        jAfirmacao1.setEnabled(!true);
        jAfirmacao2.setEnabled(!true);
        jAfirmacao3.setEnabled(!true);
        jPlanoTratamento.setEnabled(!true);
        //
        jComboBoxHepatite.setEnabled(!true);
        jComboBoxHiv.setEnabled(!true);
        jComboBoxAsma.setEnabled(!true);
        jComboBoxFumante.setEnabled(!true);
        jComboBoxFebre.setEnabled(!true);
        jComboBoxDiabetes.setEnabled(!true);
        jComboBoxEpilepsia.setEnabled(!true);
        jComboBoxCicatrizacao.setEnabled(!true);
        jComboBoxDisturbios.setEnabled(!true);
        jComboBoxEndocardite.setEnabled(!true);
        jComboBoxHepatico.setEnabled(!true);
        jComboBoxRenal.setEnabled(!true);
        jComboBoxCardiaco.setEnabled(!true);
        jComboBoxTensao.setEnabled(!true);
        jComboBoxCirurgia.setEnabled(!true);
        jComboBoxInternacao.setEnabled(!true);
        jTextoDoenca.setEnabled(!true);
    }

    public void buscarID() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ATENDIMENTODONTO");
            conecta.rs.last();
            jIDLanc.setText(String.valueOf(conecta.rs.getInt("IdLanc")));
            conecta.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel encontrar ATENDIMENTO \nERRO: " + ex);
        }
    }

    public void buscarrCodProd() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ODONTOPROCEDIMENTO");
            conecta.rs.last();
            jIdEvolucao.setText(String.valueOf(conecta.rs.getInt("IdPro")));
            conecta.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel encontrar código procedimento \nERRO: " + ex);
        }
    }

    public void buscarCodigoPrescricao() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRESCRICAO_ODONTOLOGIA");
            conecta.rs.last();
            jIdPrescricao.setText(String.valueOf(conecta.rs.getInt("IdPre")));
            conecta.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel encontrar código prescrição.\nERRO: " + ex);
        }
    }

    public void verificarPrescricaoMedica() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM REQUISICAO_PRODUTOS_INTERNOS_ENF WHERE IdItem='" + jIdPrescricao.getText() + "'");
            conecta.rs.last();
            idItemPresq = conecta.rs.getString("IdItem");
            conecta.desconecta();
        } catch (SQLException ex) {
        }
    }

    public void preencherAvaliacaoOdotologica(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Nome Completo do Interno", "Tipo de Atendimento"};
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
                dados.add(new Object[]{conecta.rs.getInt("IdLanc"), dataEntrada, conecta.rs.getString("StatusLanc"), conecta.rs.getString("NomeInternoCrc"), conecta.rs.getString("TipoAtendimento")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaOdontologia.setModel(modelo);
        jTabelaOdontologia.getColumnModel().getColumn(0).setPreferredWidth(80);
        jTabelaOdontologia.getColumnModel().getColumn(0).setResizable(false);
        jTabelaOdontologia.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaOdontologia.getColumnModel().getColumn(1).setResizable(false);
        jTabelaOdontologia.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaOdontologia.getColumnModel().getColumn(2).setResizable(false);
        jTabelaOdontologia.getColumnModel().getColumn(3).setPreferredWidth(335);
        jTabelaOdontologia.getColumnModel().getColumn(3).setResizable(false);
        jTabelaOdontologia.getColumnModel().getColumn(4).setPreferredWidth(200);
        jTabelaOdontologia.getColumnModel().getColumn(4).setResizable(false);
        jTabelaOdontologia.getTableHeader().setReorderingAllowed(false);
        jTabelaOdontologia.setAutoResizeMode(jTabelaOdontologia.AUTO_RESIZE_OFF);
        jTabelaOdontologia.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabela();
        conecta.desconecta();
    }

    public void alinharCamposTabela() {
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaOdontologia.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaOdontologia.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaOdontologia.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }

    public void limparTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Nome Completo do Interno", "Tipo de Atendimento"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaOdontologia.setModel(modelo);
        jTabelaOdontologia.getColumnModel().getColumn(0).setPreferredWidth(80);
        jTabelaOdontologia.getColumnModel().getColumn(0).setResizable(false);
        jTabelaOdontologia.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaOdontologia.getColumnModel().getColumn(1).setResizable(false);
        jTabelaOdontologia.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaOdontologia.getColumnModel().getColumn(2).setResizable(false);
        jTabelaOdontologia.getColumnModel().getColumn(3).setPreferredWidth(335);
        jTabelaOdontologia.getColumnModel().getColumn(3).setResizable(false);
        jTabelaOdontologia.getColumnModel().getColumn(4).setPreferredWidth(200);
        jTabelaOdontologia.getColumnModel().getColumn(4).setResizable(false);
        jTabelaOdontologia.getTableHeader().setReorderingAllowed(false);
        jTabelaOdontologia.setAutoResizeMode(jTabelaOdontologia.AUTO_RESIZE_OFF);
        jTabelaOdontologia.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void preencherItensProcedimentos(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Evolução"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                // Formatar a data Entrada
                dataProcedimento = conecta.rs.getString("DataPro");
                String dia = dataProcedimento.substring(8, 10);
                String mes = dataProcedimento.substring(5, 7);
                String ano = dataProcedimento.substring(0, 4);
                dataProcedimento = dia + "/" + mes + "/" + ano;
                dados.add(new Object[]{conecta.rs.getInt("IdPro"), dataProcedimento, conecta.rs.getString("Procedimento")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaProcedimentos.setModel(modelo);
        jTabelaProcedimentos.getColumnModel().getColumn(0).setPreferredWidth(80);
        jTabelaProcedimentos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaProcedimentos.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaProcedimentos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaProcedimentos.getColumnModel().getColumn(2).setPreferredWidth(620);
        jTabelaProcedimentos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaProcedimentos.getTableHeader().setReorderingAllowed(false);
        jTabelaProcedimentos.setAutoResizeMode(jTabelaProcedimentos.AUTO_RESIZE_OFF);
        jTabelaProcedimentos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        aliharCamposTabelaProcedimento();
        conecta.desconecta();
    }

    public void limparTabelaProcedimentos() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Evolução"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaProcedimentos.setModel(modelo);
        jTabelaProcedimentos.getColumnModel().getColumn(0).setPreferredWidth(80);
        jTabelaProcedimentos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaProcedimentos.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaProcedimentos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaProcedimentos.getColumnModel().getColumn(2).setPreferredWidth(620);
        jTabelaProcedimentos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaProcedimentos.getTableHeader().setReorderingAllowed(false);
        jTabelaProcedimentos.setAutoResizeMode(jTabelaProcedimentos.AUTO_RESIZE_OFF);
        jTabelaProcedimentos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void aliharCamposTabelaProcedimento() {
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaProcedimentos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaProcedimentos.getColumnModel().getColumn(1).setCellRenderer(centralizado);
    }

    public void preencherItensPrescricao(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Prescrição de Medicamentos"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                // Formatar a data Entrada
                dataProcedimento = conecta.rs.getString("DataPre");
                String dia = dataProcedimento.substring(8, 10);
                String mes = dataProcedimento.substring(5, 7);
                String ano = dataProcedimento.substring(0, 4);
                dataProcedimento = dia + "/" + mes + "/" + ano;
                dados.add(new Object[]{conecta.rs.getInt("IdPre"), dataProcedimento, conecta.rs.getString("TextoPrescricao")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPrescricao.setModel(modelo);
        jTabelaPrescricao.getColumnModel().getColumn(0).setPreferredWidth(80);
        jTabelaPrescricao.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPrescricao.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaPrescricao.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPrescricao.getColumnModel().getColumn(2).setPreferredWidth(620);
        jTabelaPrescricao.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPrescricao.getTableHeader().setReorderingAllowed(false);
        jTabelaPrescricao.setAutoResizeMode(jTabelaPrescricao.AUTO_RESIZE_OFF);
        jTabelaPrescricao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        aliharCamposTabelaPrescricao();
        conecta.desconecta();
    }

    public void limparTabelaPrescricao() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Prescrição de Medicamentos"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPrescricao.setModel(modelo);
        jTabelaPrescricao.getColumnModel().getColumn(0).setPreferredWidth(80);
        jTabelaPrescricao.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPrescricao.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaPrescricao.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPrescricao.getColumnModel().getColumn(2).setPreferredWidth(620);
        jTabelaPrescricao.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPrescricao.getTableHeader().setReorderingAllowed(false);
        jTabelaPrescricao.setAutoResizeMode(jTabelaPrescricao.AUTO_RESIZE_OFF);
        jTabelaPrescricao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void aliharCamposTabelaPrescricao() {
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaPrescricao.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaPrescricao.getColumnModel().getColumn(1).setCellRenderer(centralizado);
    }

    public void limparTabelaOdontograma() {

        while (jTabelaOdontograma.getModel().getRowCount() > 0) {
            ((DefaultTableModel) jTabelaOdontograma.getModel()).removeRow(0);
        }
    }

    public void incluirOdontograma() {

        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        // Grava os dados do arrayList na tabela
        for (int i = 0; i < jTabelaOdontograma.getRowCount(); i++) {
            objOdonto.setIdLanc(Integer.valueOf(jIDLanc.getText()));
            objOdonto.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
            objOdonto.setNomeInternoCrc(jNomeInterno.getText());
            objOdonto.setPlanoTratamento(jPlanoTratamento.getText());
            objOdonto.setIdProcOdonto((int) jTabelaOdontograma.getValueAt(i, 0));
            objOdonto.setDescricaoProcedimento((String) jTabelaOdontograma.getValueAt(i, 1));
            objOdonto.setNumeroDente((int) jTabelaOdontograma.getValueAt(i, 2));
            objOdonto.setFacesDente((String) jTabelaOdontograma.getValueAt(i, 3));
            try {
                // Converte a data de string para date, para ser inserido no banco de dados.
                date = (java.util.Date) formatter.parse((String) jTabelaOdontograma.getValueAt(i, 4));
            } catch (ParseException ex) {
            }
            objOdonto.setCorDente((String) jTabelaOdontograma.getValueAt(i, 5));
            objOdonto.setPlanoTratamento((String) jTabelaOdontograma.getValueAt(i, 6));
            if (objOdonto.getCorDente().equals("Vermelho")) {
                corDenteVermelho = 0;
            } else {
                corDenteVermelho = 1;
            }
            objOdonto.setVermelho(corDenteVermelho);
            if (objOdonto.getCorDente().equals("Verde")) {
                corDenteVerde = 0;
            } else {
                corDenteVerde = 1;
            }
            objOdonto.setVerde(corDenteVerde);
            if (objOdonto.getCorDente().equals("Azul")) {
                corDenteAzul = 0;
            } else {
                corDenteAzul = 1;
            }
            objOdonto.setAzul(corDenteAzul);
            objOdonto.getDescricaoProcedimento();
            objOdonto.setDataOdontograma(date);
            controlOdontograma.incluirOdontoGrama(objOdonto);;
        }
    }

    public void tabelaOdontograma() {

        jTabelaOdontograma.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaOdontograma.getColumnModel().getColumn(0).setResizable(false);
        jTabelaOdontograma.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTabelaOdontograma.getColumnModel().getColumn(1).setResizable(false);
        jTabelaOdontograma.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaOdontograma.getColumnModel().getColumn(2).setResizable(false);
        jTabelaOdontograma.getColumnModel().getColumn(3).setPreferredWidth(110);
        jTabelaOdontograma.getColumnModel().getColumn(3).setResizable(false);
        jTabelaOdontograma.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTabelaOdontograma.getColumnModel().getColumn(4).setResizable(false);
        jTabelaOdontograma.getColumnModel().getColumn(5).setPreferredWidth(100);
        jTabelaOdontograma.getColumnModel().getColumn(5).setResizable(false);
        jTabelaOdontograma.getColumnModel().getColumn(6).setPreferredWidth(200);
        jTabelaOdontograma.getColumnModel().getColumn(6).setResizable(false);
        jTabelaOdontograma.getTableHeader().setReorderingAllowed(false);
        jTabelaOdontograma.setAutoResizeMode(jTabelaOdontograma.AUTO_RESIZE_OFF);
        jTabelaOdontograma.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaOdontograma();
    }

    public void alinharCamposTabelaOdontograma() {
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaOdontograma.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaOdontograma.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        jTabelaOdontograma.getColumnModel().getColumn(4).setCellRenderer(centralizado);
    }

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jIDLanc.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog2() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela2);
        objLogSys.setIdLancMov(Integer.valueOf(jIDLanc.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog3() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela3);
        objLogSys.setIdLancMov(Integer.valueOf(jIDLanc.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void buscarAcessoUsuario(String nomeTelaAcesso) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nameUser + "'");
            conecta.rs.first();
            codigoUserODON = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUserODON + "'");
            conecta.rs.first();
            codigoUserGroupODON = conecta.rs.getInt("IdUsuario");
            codigoGrupoODON = conecta.rs.getInt("IdGrupo");
            nomeGrupoODON = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUserODON + "' "
                    + "AND NomeTela='" + nomeTelaAcesso + "'");
            conecta.rs.first();
            codUserAcessoODON = conecta.rs.getInt("IdUsuario");
            codAbrirODON = conecta.rs.getInt("Abrir");
            codIncluirODON = conecta.rs.getInt("Incluir");
            codAlterarODON = conecta.rs.getInt("Alterar");
            codExcluirODON = conecta.rs.getInt("Excluir");
            codGravarODON = conecta.rs.getInt("Gravar");
            codConsultarODON = conecta.rs.getInt("Consultar");
            nomeTelaODON = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
