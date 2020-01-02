/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleAtividadesComplementaresPEDA;
import gestor.Controle.ControleListaCursos;
import gestor.Controle.ControleListaInstituicao;
import gestor.Controle.ControleListaProfessorIndividual;
import gestor.Controle.ControleListaProfessores;
import gestor.Controle.ControleListalCursosIndividual;
import gestor.Controle.ControleListarInstituicaoIndividual;
import gestor.Controle.ControleLogSistema;
import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.ModeloTabela;
import gestor.Modelo.AssistenciaEducativa;
import gestor.Modelo.AtividadesComplementarePedagogica;
import gestor.Modelo.Instituicao;
import gestor.Modelo.LogSistema;
import gestor.Modelo.Professores;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloPedagogia.codAbrirPEDA;
import static gestor.Visao.TelaModuloPedagogia.codAlterarPEDA;
import static gestor.Visao.TelaModuloPedagogia.codConsultarPEDA;
import static gestor.Visao.TelaModuloPedagogia.codExcluirPEDA;
import static gestor.Visao.TelaModuloPedagogia.codGravarPEDA;
import static gestor.Visao.TelaModuloPedagogia.codIncluirPEDA;
import static gestor.Visao.TelaModuloPedagogia.codUserAcessoPEDA;
import static gestor.Visao.TelaModuloPedagogia.codigoGrupoPEDA;
import static gestor.Visao.TelaModuloPedagogia.codigoUserGroupPEDA;
import static gestor.Visao.TelaModuloPedagogia.codigoUserPEDA;
import static gestor.Visao.TelaModuloPedagogia.nomeGrupoPEDA;
import static gestor.Visao.TelaModuloPedagogia.nomeTelaPEDA;
import static gestor.Visao.TelaModuloPedagogia.telaCCAC_TPS_ManuPEDA;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import java.awt.Color;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Socializa TI 02
 */
public class TelaCCAC_TPS extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AtividadesComplementarePedagogica objAtivi = new AtividadesComplementarePedagogica();
    Instituicao objInst = new Instituicao();
    Professores objProf = new Professores();
    ControleAtividadesComplementaresPEDA control = new ControleAtividadesComplementaresPEDA();
    ControleListaInstituicao controlDAO_INS = new ControleListaInstituicao();
    ControleListaProfessores controlDAO_PRF = new ControleListaProfessores();
    ControleListaCursos controlDAO_CUR = new ControleListaCursos();
    //
    ControleListarInstituicaoIndividual pLISTA_INDIVIDUAL_INSTITUICAO = new ControleListarInstituicaoIndividual();
    ControleListaProfessorIndividual pLISTA_INDIVIDUAL_PROFESSOR = new ControleListaProfessorIndividual();
    ControleListalCursosIndividual pLISTA_INDIVIDUAL_CURSOS = new ControleListalCursosIndividual();
    //   
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela = "Pedagogia:Assistência Atividade Complementar:Manutenção";
    String nomeModuloTela2 = "Pedagogia:Assistência Atividade Complementar:Internos";
    String statusMov;
    String horaMov;
    String dataModFinal;
    //
    int acao;
    int flag;
    String dataInicial, dataFinal;
    int count = 0;
    int count0 = 0;
    String dataCadastro;
    // DIAS E HORARIOS DA SEMANA PARA SAIDA DOS INTERNOS
    public static int DiaSeg;
    public static int DiaTer;
    public static int DiaQua;
    public static int DiaQui;
    public static int DiaSex;
    public static int DiaSab;
    public static int DiaDom;
    //
    public static int DiaSeg1;
    public static int DiaTer1;
    public static int DiaQua1;
    public static int DiaQui1;
    public static int DiaSex1;
    public static int DiaSab1;
    public static int DiaDom1;
    //
    public static int pCODIGO_CURSO = 0;
    //
    int DIA_DOM = 0;
    int DIA_SEG = 0;
    int DIA_TER = 0;
    int DIA_QUA = 0;
    int DIA_QUI = 0;
    int DIA_SEX = 0;
    int DIA_SAB = 0;
    //
    int DIA_VISITA_DOM = 0;
    int DIA_VISITA_SEG = 0;
    int DIA_VISITA_TER = 0;
    int DIA_VISITA_QUA = 0;
    int DIA_VISITA_QUI = 0;
    int DIA_VISITA_SEX = 0;
    int DIA_VISITA_SAB = 0;
    //
    int diaDom, diaSeg, diaTer, diaQua, diaQui, diaSex, diaSab;
    //
    String pSTATUS_INSTITUICAO = "Ativo";
    String pSTATUS_PROFESSOR = "Ativo";
    String pSTATUS_CURSO = "Ativo";
    public static String pCODIGO_INSTITUICAO;
    public static String pCODIGO_PROFESSOR;
    public static String pCODIGO_AT;

    /**
     * Creates new form TelaCCAC_TPS
     */
    public TelaCCAC_TPS() {
        initComponents();
        corCampos();
        formatarCampos();
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
        jPanel13 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jDataPesqInicial = new com.toedter.calendar.JDateChooser();
        jDataPesFinal = new com.toedter.calendar.JDateChooser();
        jBtPesqData = new javax.swing.JButton();
        jIDPesqLan = new javax.swing.JTextField();
        jPesqNomeInterno = new javax.swing.JTextField();
        jBtPesqCodigo = new javax.swing.JButton();
        jBtPesqNomeInterno = new javax.swing.JButton();
        jCheckBox2 = new javax.swing.JCheckBox();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTabelaAssistenciaEducaional = new javax.swing.JTable();
        jPanel33 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jIdLanc = new javax.swing.JTextField();
        jStatus = new javax.swing.JTextField();
        jDataEvento = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxInstituicao = new javax.swing.JComboBox<>();
        jComboBoxProfessor = new javax.swing.JComboBox<>();
        jCargaHoraria = new javax.swing.JFormattedTextField();
        jPanel12 = new javax.swing.JPanel();
        jCheckBoxSeg = new javax.swing.JCheckBox();
        jCheckBoxTer = new javax.swing.JCheckBox();
        jCheckBoxQua = new javax.swing.JCheckBox();
        jCheckBoxQui = new javax.swing.JCheckBox();
        jCheckBoxSex = new javax.swing.JCheckBox();
        jCheckBoxSab = new javax.swing.JCheckBox();
        jCheckBoxDom = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxTurno = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jComboBoxDescricaoAtividade = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jObservacao = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jBtNovo = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jBtFinalizar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jBtAuditoria = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jBtNovoInterno = new javax.swing.JButton();
        jBtAlterarInterno = new javax.swing.JButton();
        jBtExcluirInterno = new javax.swing.JButton();
        jBtSalvarInterno = new javax.swing.JButton();
        jBtCancelarInterno = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jBtSairGeral = new javax.swing.JButton();
        jBtAuditoriaInterno = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jIdInternoAC = new javax.swing.JTextField();
        jCNC = new javax.swing.JTextField();
        jNomeInternoAC = new javax.swing.JTextField();
        jBtPesquisaInterno = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jObservacaoInterno = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jSegundaVisita = new javax.swing.JCheckBox();
        jTercaVisita = new javax.swing.JCheckBox();
        jQuartaVisita = new javax.swing.JCheckBox();
        jQuintaVisita = new javax.swing.JCheckBox();
        jSextaVisita = new javax.swing.JCheckBox();
        jSabadoVisita = new javax.swing.JCheckBox();
        jDomingoVisita = new javax.swing.JCheckBox();
        jPanel18 = new javax.swing.JPanel();
        jHoraSeg = new javax.swing.JFormattedTextField();
        jHoraTer = new javax.swing.JFormattedTextField();
        jHoraQua = new javax.swing.JFormattedTextField();
        jHoraQui = new javax.swing.JFormattedTextField();
        jHoraSex = new javax.swing.JFormattedTextField();
        jHoraSab = new javax.swing.JFormattedTextField();
        jHoraDom = new javax.swing.JFormattedTextField();
        jPanel19 = new javax.swing.JPanel();
        jHoraSegEnt = new javax.swing.JFormattedTextField();
        jHoraTerEnt = new javax.swing.JFormattedTextField();
        jHoraQuaEnt = new javax.swing.JFormattedTextField();
        jHoraQuiEnt = new javax.swing.JFormattedTextField();
        jHoraSexEnt = new javax.swing.JFormattedTextField();
        jHoraSabEnt = new javax.swing.JFormattedTextField();
        jHoraDomEnt = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel30 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jtotalRegistrosInt = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Controle de Atividades Complentares :::...");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Código");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Data Inicial:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Data Final:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Nome Interno:");

        jDataPesqInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jDataPesFinal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqData.setContentAreaFilled(false);
        jBtPesqData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqDataActionPerformed(evt);
            }
        });

        jIDPesqLan.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIDPesqLan.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jPesqNomeInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqCodigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqCodigo.setContentAreaFilled(false);
        jBtPesqCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqCodigoActionPerformed(evt);
            }
        });

        jBtPesqNomeInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqNomeInterno.setContentAreaFilled(false);
        jBtPesqNomeInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqNomeInternoActionPerformed(evt);
            }
        });

        jCheckBox2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox2.setText("Todos");
        jCheckBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox2ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jPesqNomeInterno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jIDPesqLan, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jCheckBox2)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDataPesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqData, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel15)
                    .addComponent(jIDPesqLan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqCodigo)
                    .addComponent(jCheckBox2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel16)
                    .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jDataPesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqNomeInterno)
                    .addComponent(jLabel18))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaAssistenciaEducaional.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaAssistenciaEducaional.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data", "Status", "Observação"
            }
        ));
        jTabelaAssistenciaEducaional.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaAssistenciaEducaionalMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTabelaAssistenciaEducaional);
        if (jTabelaAssistenciaEducaional.getColumnModel().getColumnCount() > 0) {
            jTabelaAssistenciaEducaional.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaAssistenciaEducaional.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaAssistenciaEducaional.getColumnModel().getColumn(1).setMinWidth(80);
            jTabelaAssistenciaEducaional.getColumnModel().getColumn(1).setMaxWidth(80);
            jTabelaAssistenciaEducaional.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaAssistenciaEducaional.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaAssistenciaEducaional.getColumnModel().getColumn(3).setMinWidth(250);
            jTabelaAssistenciaEducaional.getColumnModel().getColumn(3).setMaxWidth(250);
        }

        jPanel33.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jLabel64.setText("Total de Registros:");

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel64))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel64)
        );

        jPanel34.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jtotalRegistros.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtotalRegistros, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
        );

        jPanel35.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("Listagem", jPanel1);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Status");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Data Registro");

        jIdLanc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdLanc.setEnabled(false);

        jStatus.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jStatus.setForeground(new java.awt.Color(204, 0, 0));
        jStatus.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jStatus.setDisabledTextColor(new java.awt.Color(204, 0, 0));
        jStatus.setEnabled(false);

        jDataEvento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataEvento.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Instituição");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Professor/Instrutor");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Carga Horária");

        jComboBoxInstituicao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxInstituicao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxInstituicao.setEnabled(false);
        jComboBoxInstituicao.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxInstituicaoItemStateChanged(evt);
            }
        });

        jComboBoxProfessor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxProfessor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxProfessor.setEnabled(false);
        jComboBoxProfessor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxProfessorItemStateChanged(evt);
            }
        });

        jCargaHoraria.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCargaHoraria.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jCargaHoraria.setText("00:00");
        jCargaHoraria.setEnabled(false);

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Dias da Semana", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jCheckBoxSeg.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxSeg.setText("Seg");
        jCheckBoxSeg.setEnabled(false);
        jCheckBoxSeg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jCheckBoxSeg.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jCheckBoxSeg.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jCheckBoxTer.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxTer.setText("Ter");
        jCheckBoxTer.setEnabled(false);
        jCheckBoxTer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jCheckBoxTer.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jCheckBoxTer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jCheckBoxQua.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxQua.setText("Qua");
        jCheckBoxQua.setEnabled(false);
        jCheckBoxQua.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jCheckBoxQua.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jCheckBoxQua.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jCheckBoxQui.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxQui.setText("Qui");
        jCheckBoxQui.setEnabled(false);
        jCheckBoxQui.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jCheckBoxQui.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jCheckBoxQui.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jCheckBoxSex.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxSex.setText("Sex");
        jCheckBoxSex.setEnabled(false);
        jCheckBoxSex.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jCheckBoxSex.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jCheckBoxSex.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jCheckBoxSab.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxSab.setText("Sáb");
        jCheckBoxSab.setEnabled(false);
        jCheckBoxSab.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jCheckBoxSab.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jCheckBoxSab.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jCheckBoxDom.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxDom.setText("Dom");
        jCheckBoxDom.setEnabled(false);
        jCheckBoxDom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jCheckBoxDom.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jCheckBoxDom.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBoxSeg, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxTer, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxQua, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBoxQui, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBoxSex)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBoxSab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxDom)
                .addGap(47, 47, 47))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(0, 2, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jCheckBoxSeg)
                    .addComponent(jCheckBoxTer)
                    .addComponent(jCheckBoxQua)
                    .addComponent(jCheckBoxQui)
                    .addComponent(jCheckBoxSex)
                    .addComponent(jCheckBoxSab)
                    .addComponent(jCheckBoxDom)))
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Turno da Atividade");

        jComboBoxTurno.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTurno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "Matutino", "Vespertino", "Noturno" }));
        jComboBoxTurno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTurno.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Descrição Atividade Complementar/Curso");

        jComboBoxDescricaoAtividade.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDescricaoAtividade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDescricaoAtividade.setEnabled(false);
        jComboBoxDescricaoAtividade.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxDescricaoAtividadeItemStateChanged(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Observação");

        jScrollPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jObservacao.setColumns(20);
        jObservacao.setRows(5);
        jObservacao.setEnabled(false);
        jScrollPane1.setViewportView(jObservacao);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jIdLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDataEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)))
                            .addComponent(jLabel4))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxInstituicao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxProfessor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 382, Short.MAX_VALUE)
                            .addComponent(jLabel5)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jCargaHoraria, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jComboBoxTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel8)
                            .addComponent(jComboBoxDescricaoAtividade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9)
                            .addComponent(jScrollPane1))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jIdLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDataEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(5, 5, 5)
                .addComponent(jComboBoxInstituicao, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCargaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxDescricaoAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoActionPerformed(evt);
            }
        });

        jBtAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterar.setEnabled(false);
        jBtAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarActionPerformed(evt);
            }
        });

        jBtExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluir.setEnabled(false);
        jBtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirActionPerformed(evt);
            }
        });

        jBtSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvar.setEnabled(false);
        jBtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarActionPerformed(evt);
            }
        });

        jBtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelar.setEnabled(false);
        jBtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarActionPerformed(evt);
            }
        });

        jBtFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/40_16x16.png"))); // NOI18N
        jBtFinalizar.setEnabled(false);
        jBtFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFinalizarActionPerformed(evt);
            }
        });

        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jBtNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jBtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterar, jBtCancelar, jBtExcluir, jBtFinalizar, jBtNovo, jBtSair, jBtSalvar});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtAlterar)
                    .addComponent(jBtExcluir)
                    .addComponent(jBtSalvar)
                    .addComponent(jBtCancelar)
                    .addComponent(jBtFinalizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtAuditoria))
                .addGap(3, 3, 3))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterar, jBtCancelar, jBtExcluir, jBtFinalizar, jBtNovo, jBtSair, jBtSalvar});

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manutenção", jPanel2);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtNovoInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoInterno.setEnabled(false);
        jBtNovoInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoInternoActionPerformed(evt);
            }
        });

        jBtAlterarInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarInterno.setEnabled(false);
        jBtAlterarInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarInternoActionPerformed(evt);
            }
        });

        jBtExcluirInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirInterno.setEnabled(false);
        jBtExcluirInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirInternoActionPerformed(evt);
            }
        });

        jBtSalvarInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarInterno.setEnabled(false);
        jBtSalvarInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarInternoActionPerformed(evt);
            }
        });

        jBtCancelarInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarInterno.setEnabled(false);
        jBtCancelarInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarInternoActionPerformed(evt);
            }
        });

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/40_16x16.png"))); // NOI18N
        jButton14.setEnabled(false);
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jBtSairGeral.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSairGeral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairGeralActionPerformed(evt);
            }
        });

        jBtAuditoriaInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaInterno.setContentAreaFilled(false);
        jBtAuditoriaInterno.setEnabled(false);
        jBtAuditoriaInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaInternoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jBtNovoInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtAlterarInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtExcluirInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtSalvarInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtCancelarInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jBtSairGeral, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtAuditoriaInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterarInterno, jBtCancelarInterno, jBtExcluirInterno, jBtNovoInterno, jBtSairGeral, jBtSalvarInterno, jButton14});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtNovoInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtAlterarInterno)
                    .addComponent(jBtExcluirInterno)
                    .addComponent(jBtSalvarInterno)
                    .addComponent(jBtCancelarInterno)
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtSairGeral, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtAuditoriaInterno))
                .addGap(3, 3, 3))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterarInterno, jBtCancelarInterno, jBtExcluirInterno, jBtNovoInterno, jBtSairGeral, jBtSalvarInterno, jButton14});

        jTabbedPane2.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Código");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("CNC");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Nome do Interno");

        jIdInternoAC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdInternoAC.setEnabled(false);

        jCNC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCNC.setEnabled(false);

        jNomeInternoAC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoAC.setEnabled(false);

        jBtPesquisaInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesquisaInterno.setContentAreaFilled(false);
        jBtPesquisaInterno.setEnabled(false);
        jBtPesquisaInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisaInternoActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Observação");

        jObservacaoInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jObservacaoInterno.setEnabled(false);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jNomeInternoAC)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jIdInternoAC, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jBtPesquisaInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jCNC, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel13))
                        .addGap(0, 131, Short.MAX_VALUE))
                    .addComponent(jObservacaoInterno))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesquisaInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(jIdInternoAC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jCNC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(5, 5, 5)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNomeInternoAC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jObservacaoInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel10Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtPesquisaInterno, jCNC, jIdInternoAC});

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(4, 4, 4))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Participantes", jPanel8);

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Dias da Semana", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jSegundaVisita.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jSegundaVisita.setText("Seg");
        jSegundaVisita.setEnabled(false);
        jSegundaVisita.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jSegundaVisita.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jSegundaVisita.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jTercaVisita.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTercaVisita.setText("Ter");
        jTercaVisita.setEnabled(false);
        jTercaVisita.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTercaVisita.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jTercaVisita.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jQuartaVisita.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jQuartaVisita.setText("Qua");
        jQuartaVisita.setEnabled(false);
        jQuartaVisita.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jQuartaVisita.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jQuartaVisita.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jQuintaVisita.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jQuintaVisita.setText("Qui");
        jQuintaVisita.setEnabled(false);
        jQuintaVisita.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jQuintaVisita.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jQuintaVisita.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jSextaVisita.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jSextaVisita.setText("Sex");
        jSextaVisita.setEnabled(false);
        jSextaVisita.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jSextaVisita.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jSextaVisita.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jSabadoVisita.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jSabadoVisita.setText("Sáb");
        jSabadoVisita.setEnabled(false);
        jSabadoVisita.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jSabadoVisita.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jSabadoVisita.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jDomingoVisita.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jDomingoVisita.setText("Dom");
        jDomingoVisita.setEnabled(false);
        jDomingoVisita.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jDomingoVisita.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jDomingoVisita.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSegundaVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTercaVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jQuartaVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jQuintaVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSextaVisita)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSabadoVisita)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDomingoVisita)
                .addGap(25, 25, 25))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jSegundaVisita)
                    .addComponent(jTercaVisita)
                    .addComponent(jQuartaVisita)
                    .addComponent(jQuintaVisita)
                    .addComponent(jSextaVisita)
                    .addComponent(jSabadoVisita)
                    .addComponent(jDomingoVisita))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Horários de Saída", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        jHoraSeg.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHoraSeg.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jHoraSeg.setEnabled(false);

        jHoraTer.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHoraTer.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jHoraTer.setEnabled(false);

        jHoraQua.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHoraQua.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jHoraQua.setEnabled(false);

        jHoraQui.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHoraQui.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jHoraQui.setEnabled(false);

        jHoraSex.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHoraSex.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jHoraSex.setEnabled(false);

        jHoraSab.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHoraSab.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jHoraSab.setEnabled(false);

        jHoraDom.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHoraDom.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jHoraDom.setEnabled(false);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jHoraSeg, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jHoraTer, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jHoraQua, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jHoraQui, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jHoraSex, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jHoraSab, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jHoraDom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel18Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jHoraDom, jHoraQua, jHoraQui, jHoraSab, jHoraSeg, jHoraSex, jHoraTer});

        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jHoraSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jHoraSab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jHoraDom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jHoraQui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jHoraSeg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jHoraTer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jHoraQua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5))
        );

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Horários de Entrada", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 153, 0))); // NOI18N

        jHoraSegEnt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHoraSegEnt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jHoraSegEnt.setEnabled(false);

        jHoraTerEnt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHoraTerEnt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jHoraTerEnt.setEnabled(false);

        jHoraQuaEnt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHoraQuaEnt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jHoraQuaEnt.setEnabled(false);

        jHoraQuiEnt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHoraQuiEnt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jHoraQuiEnt.setEnabled(false);

        jHoraSexEnt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHoraSexEnt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jHoraSexEnt.setEnabled(false);

        jHoraSabEnt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHoraSabEnt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jHoraSabEnt.setEnabled(false);

        jHoraDomEnt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHoraDomEnt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jHoraDomEnt.setEnabled(false);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jHoraSegEnt, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jHoraTerEnt, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jHoraQuaEnt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jHoraQuiEnt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jHoraSexEnt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jHoraSabEnt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jHoraDomEnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel19Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jHoraDomEnt, jHoraQuaEnt, jHoraQuiEnt, jHoraSabEnt, jHoraSegEnt, jHoraSexEnt, jHoraTerEnt});

        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jHoraSexEnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jHoraSabEnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jHoraDomEnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jHoraQuiEnt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jHoraSegEnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jHoraTerEnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jHoraQuaEnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 384, Short.MAX_VALUE))
                .addGap(7, 7, 7))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Dias/Horários", jPanel9);

        jTable1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Código", "CNC", "Nome do Interno"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(60);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(60);
            jTable1.getColumnModel().getColumn(1).setMinWidth(70);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(70);
            jTable1.getColumnModel().getColumn(2).setMinWidth(90);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(90);
            jTable1.getColumnModel().getColumn(3).setMinWidth(350);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(350);
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

        jPanel32.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jtotalRegistrosInt.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtotalRegistrosInt, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistrosInt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane2)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("Participantes", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBounds(300, 60, 445, 492);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesqDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqDataActionPerformed
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
                        preencherTabelaAtividadesComplementares("SELECT * FROM ATIVIDADES_COMPLEMENTARES_PEDAGOGICA "
                                + "WHERE DataAC BETWEEN'" + dataInicial + "' "
                                + "AND '" + dataFinal + "'");
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
                        preencherTabelaAtividadesComplementares("SELECT * FROM ATIVIDADES_COMPLEMENTARES_PEDAGOGICA "
                                + "WHERE DataAC BETWEEN'" + dataInicial + "' "
                                + "AND '" + dataFinal + "'");
                    }
                }
            }
        }
    }//GEN-LAST:event_jBtPesqDataActionPerformed

    private void jBtPesqCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqCodigoActionPerformed
        // TODO add your handling code here:
        count = 0;
        if (jIDPesqLan.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um código para pesquisa.");
        } else {
            jTabelaAssistenciaEducaional.setVisible(true);
            preencherTabelaAtividadesComplementares("SELECT * FROM ATIVIDADES_COMPLEMENTARES_PEDAGOGICA "
                    + "WHERE IdAC='" + jIDPesqLan.getText() + "'");
        }
    }//GEN-LAST:event_jBtPesqCodigoActionPerformed

    private void jBtPesqNomeInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNomeInternoActionPerformed
        // TODO add your handling code here:
//        count = 0;
//        if (jPesqNomeInterno.getText().equals("")) {
//            JOptionPane.showMessageDialog(rootPane, "É necessário informar um nome ou parte do nome para pesquisa.");
//        } else {
//            preencherTabelaAtividadesComplementares("SELECT * FROM ATIVIDADES_COMPLEMENTARES_PEDAGOGICA "
//                    + "INNER JOIN INSTITUICAOESCOLAR "
//                    + "ON ASSISTENCIA_EDUCACAO_EXTERNA.IdICod=INSTITUICAOESCOLAR.IdICod "
//                    + "INNER JOIN TURNOSAULA "
//                    + "ON ASSISTENCIA_EDUCACAO_EXTERNA.IdTurno=TURNOSAULA.IdTurno "
//                    + "WHERE NomeInternoCrc LIKE'%" + jPesqNomeInterno.getText() + "%'");
//        }
    }//GEN-LAST:event_jBtPesqNomeInternoActionPerformed

    private void jCheckBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox2ItemStateChanged
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherTabelaAtividadesComplementares("SELECT * FROM ATIVIDADES_COMPLEMENTARES_PEDAGOGICA ");
        } else {
            jtotalRegistrosInt.setText("");
            limparTabela();
        }
    }//GEN-LAST:event_jCheckBox2ItemStateChanged

    private void jTabelaAssistenciaEducaionalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaAssistenciaEducaionalMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String IdLanc = "" + jTabelaAssistenciaEducaional.getValueAt(jTabelaAssistenciaEducaional.getSelectedRow(), 0);
            jIDPesqLan.setText(IdLanc);
            //
            bloquearCampos();
            bloquearBotoes();
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtNovoInterno.setEnabled(true);
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ATIVIDADES_COMPLEMENTARES_PEDAGOGICA "
                        + "WHERE IdAC='" + IdLanc + "'");
                conecta.rs.first();
                jIdLanc.setText(String.valueOf(conecta.rs.getInt("IdAC")));
                jStatus.setText(conecta.rs.getString("StatusAC"));
                jDataEvento.setDate(conecta.rs.getDate("DataAC"));
                pCODIGO_INSTITUICAO = conecta.rs.getString("IdCod");
                pCODIGO_PROFESSOR = conecta.rs.getString("IdProf");
                pCODIGO_AT = conecta.rs.getString("IdCurso");
                jCargaHoraria.setText(conecta.rs.getString("CargaHoraria"));
                jComboBoxTurno.setSelectedItem(conecta.rs.getString("TurnoAtividade"));
                jObservacao.setText(conecta.rs.getString("Observacao"));
                // INSTITUIÇÃO DE ENSINO
                jComboBoxInstituicao.removeAllItems();
                try {
                    for (Instituicao i : pLISTA_INDIVIDUAL_INSTITUICAO.read()) {
                        jComboBoxInstituicao.addItem(i);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(TelaCCAC_TPS.class.getName()).log(Level.SEVERE, null, ex);
                }
                Instituicao instituicao = (Instituicao) jComboBoxInstituicao.getSelectedItem();
                instituicao.getIdCod();
                instituicao.getNomeInstituicao();
                objAtivi.setIdCod(instituicao.getIdCod());
                // PROFESSORES
                jComboBoxProfessor.removeAllItems();
                try {
                    for (Professores p : pLISTA_INDIVIDUAL_PROFESSOR.read()) {
                        jComboBoxProfessor.addItem(p);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(TelaCCAC_TPS.class.getName()).log(Level.SEVERE, null, ex);
                }
                Professores professores = (Professores) jComboBoxProfessor.getSelectedItem();
                professores.getIdProf();
                professores.getNomeProfessor();
                objAtivi.setIdProf(professores.getIdProf());
                //CURSOS - ATIVIDADES EDUCACIONAIS
                jComboBoxDescricaoAtividade.removeAllItems();
                try {
                    for (AssistenciaEducativa c : pLISTA_INDIVIDUAL_CURSOS.read()) {
                        jComboBoxDescricaoAtividade.addItem(c);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(TelaAssistenciaEducacionalExterna.class.getName()).log(Level.SEVERE, null, ex);
                }
                AssistenciaEducativa cursosDiversos = (AssistenciaEducativa) jComboBoxDescricaoAtividade.getSelectedItem();
                cursosDiversos.getIdCurso();
                cursosDiversos.getDescricaoCurso();
                objAtivi.setIdCurso(cursosDiversos.getIdCurso());
                //
                DiaSeg = conecta.rs.getInt("Dia2");
                if (DiaSeg == 1) {
                    jCheckBoxSeg.setSelected(true);
                } else if (DiaSeg == 0) {
                    jCheckBoxSeg.setSelected(!true);
                }
                DiaTer = conecta.rs.getInt("Dia3");
                if (DiaTer == 1) {
                    jCheckBoxTer.setSelected(true);
                } else if (DiaTer == 0) {
                    jCheckBoxTer.setSelected(!true);
                }
                DiaQua = conecta.rs.getInt("Dia4");
                if (DiaQua == 1) {
                    jCheckBoxQua.setSelected(true);
                } else if (DiaQua == 0) {
                    jCheckBoxQua.setSelected(!true);
                }
                DiaQui = conecta.rs.getInt("Dia5");
                if (DiaQui == 1) {
                    jCheckBoxQui.setSelected(true);
                } else if (DiaQui == 0) {
                    jCheckBoxQui.setSelected(!true);
                }
                DiaSex = conecta.rs.getInt("Dia6");
                if (DiaSex == 1) {
                    jCheckBoxSex.setSelected(true);
                } else if (DiaSex == 0) {
                    jCheckBoxSex.setSelected(!true);
                }
                DiaSab = conecta.rs.getInt("Dia7");
                if (DiaSab == 1) {
                    jCheckBoxSab.setSelected(true);
                } else if (DiaSab == 0) {
                    jCheckBoxSab.setSelected(!true);
                }
                DiaDom = conecta.rs.getInt("Dia8");
                if (DiaDom == 1) {
                    jCheckBoxDom.setSelected(true);
                } else if (DiaDom == 0) {
                    jCheckBoxDom.setSelected(!true);
                }
                //
                conecta.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa dos dados." + e);
            }
            count0 = 0;
            preencherTabelaInternos("SELECT * FROM INTERNOS_SAIDA_EDUCACIONAL "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON INTERNOS_SAIDA_EDUCACIONAL.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN ASSISTENCIA_EDUCACAO_EXTERNA "
                    + "ON INTERNOS_SAIDA_EDUCACIONAL.IdEduca=ASSISTENCIA_EDUCACAO_EXTERNA.IdEduca "
                    + "WHERE INTERNOS_SAIDA_EDUCACIONAL.IdEduca='" + IdLanc + "'");
        }
    }//GEN-LAST:event_jTabelaAssistenciaEducaionalMouseClicked

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCCAC_TPS_ManuPEDA);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPEDA.equals("ADMINISTRADORES") || codigoUserPEDA == codUserAcessoPEDA && nomeTelaPEDA.equals(telaCCAC_TPS_ManuPEDA) && codIncluirPEDA == 1) {
            acao = 1;
            limparCamposTodos();
            bloquearBotoes();
            limparTabelaItens();
            bloquearCamposAba2();
            habilitarCamposAba1();
            preencherComboBoxInstituicao();
            preencherComboBoxProfessor();
            preencherComboBoxCurso();
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
        buscarAcessoUsuario(telaCCAC_TPS_ManuPEDA);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPEDA.equals("ADMINISTRADORES") || codigoUserPEDA == codUserAcessoPEDA && nomeTelaPEDA.equals(telaCCAC_TPS_ManuPEDA) && codAlterarPEDA == 1) {
            if (jStatus.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Registro já finalizado, não pode ser modificado.");
            } else {
                acao = 2;
                bloquearBotoes();
                bloquearCamposAba2();
                limparCamposAba2();
                habilitarCamposAba1();
                preencherComboBoxInstituicao();
                preencherComboBoxProfessor();
                preencherComboBoxCurso();
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
        buscarAcessoUsuario(telaCCAC_TPS_ManuPEDA);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPEDA.equals("ADMINISTRADORES") || codigoUserPEDA == codUserAcessoPEDA && nomeTelaPEDA.equals(telaCCAC_TPS_ManuPEDA) && codExcluirPEDA == 1) {
            if (jStatus.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Registro já finalizado, não pode ser modificado.");
            } else {
                statusMov = "Excluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
                bloquearBotoes();
                bloquearCamposAba2();
                limparCamposAba2();
                Excluir();

            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCCAC_TPS_ManuPEDA);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPEDA.equals("ADMINISTRADORES") || codigoUserPEDA == codUserAcessoPEDA && nomeTelaPEDA.equals(telaCCAC_TPS_ManuPEDA) && codGravarPEDA == 1) {
            if (jDataEvento.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data do registro.");
            } else if (jComboBoxInstituicao.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a instituição do evento.");
            } else if (jComboBoxProfessor.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome do professor.");
            } else if (jComboBoxTurno.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(rootPane, "Selecione o turno do evento.");
            } else if (jComboBoxDescricaoAtividade.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a atividade a ser realizada.");
            } else {
                objAtivi.setStatusAC(jStatus.getText());
                objAtivi.setDataAC(jDataEvento.getDate());
                objAtivi.setCargaHoraria(jCargaHoraria.getText());
                objAtivi.setTurnoAtividade((String) jComboBoxTurno.getSelectedItem());
                //SEGUNDA
                if (jCheckBoxSeg.isSelected()) {
                    DIA_SEG = 1;
                } else if (!jCheckBoxSeg.isSelected()) {
                    DIA_SEG = 0;
                }
                objAtivi.setDia2(DIA_SEG);
                //TERÇA
                if (jCheckBoxTer.isSelected()) {
                    DIA_TER = 1;
                } else if (!jCheckBoxTer.isSelected()) {
                    DIA_TER = 0;
                }
                objAtivi.setDia3(DIA_TER);
                //QUARTA
                if (jCheckBoxQua.isSelected()) {
                    DIA_QUA = 1;
                } else if (!jCheckBoxQua.isSelected()) {
                    DIA_QUA = 0;
                }
                objAtivi.setDia4(DIA_QUA);
                //QUINTA
                if (jCheckBoxQui.isSelected()) {
                    DIA_QUI = 1;
                } else if (!jCheckBoxQui.isSelected()) {
                    DIA_QUI = 0;
                }
                objAtivi.setDia5(DIA_QUI);
                //SEXTA
                if (jCheckBoxSex.isSelected()) {
                    DIA_SEX = 1;
                } else if (!jCheckBoxSex.isSelected()) {
                    DIA_SEX = 0;
                }
                objAtivi.setDia6(DIA_SEX);
                //SÁBADO
                if (jCheckBoxSab.isSelected()) {
                    DIA_SAB = 1;
                } else if (!jCheckBoxSab.isSelected()) {
                    DIA_SAB = 0;
                }
                objAtivi.setDia7(DIA_SAB);
                //DOMINGO
                if (jCheckBoxDom.isSelected()) {
                    DIA_DOM = 1;
                } else if (!jCheckBoxDom.isSelected()) {
                    DIA_DOM = 0;
                }
                objAtivi.setDia8(DIA_DOM);
                objAtivi.setObservacao(jObservacao.getText());
                if (acao == 1) {
                    objAtivi.setUsuarioInsert(nameUser);
                    objAtivi.setDataInsert(dataModFinal);
                    objAtivi.setHorarioInsert(horaMov);
                    //
                    control.incluirAC(objAtivi);
                    buscarCodigoAba1();
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    bloquearBotoes();
                    bloquearCampos();
                    Salvar();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
                if (acao == 2) {
                    objAtivi.setUsuarioUp(nameUser);
                    objAtivi.setDataUp(dataModFinal);
                    objAtivi.setHorarioUp(horaMov);
                    //
                    objAtivi.setIdAC(Integer.valueOf(jIdLanc.getText()));
                    control.alterarAC(objAtivi);
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
    }//GEN-LAST:event_jBtFinalizarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtAuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtAuditoriaActionPerformed

    private void jComboBoxInstituicaoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxInstituicaoItemStateChanged
        // TODO add your handling code here:
        jComboBoxInstituicao.removeAll();
        if (evt.getStateChange() == evt.SELECTED && acao == 1 || evt.getStateChange() == evt.SELECTED && acao == 2) {
            try {
                for (Instituicao i : controlDAO_INS.read()) {
                    jComboBoxInstituicao.addItem(i);
                }
            } catch (Exception ex) {
                Logger.getLogger(TelaCCAC_TPS.class.getName()).log(Level.SEVERE, null, ex);
            }
            Instituicao instituicao = (Instituicao) jComboBoxInstituicao.getSelectedItem();
            instituicao.getIdCod();
            instituicao.getNomeInstituicao();
            objAtivi.setIdCod(instituicao.getIdCod());
        }
    }//GEN-LAST:event_jComboBoxInstituicaoItemStateChanged

    private void jComboBoxProfessorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxProfessorItemStateChanged
        // TODO add your handling code here:
        jComboBoxProfessor.removeAll();
        if (evt.getStateChange() == evt.SELECTED && acao == 1 || evt.getStateChange() == evt.SELECTED && acao == 2) {
            try {
                for (Professores p : controlDAO_PRF.read()) {
                    jComboBoxProfessor.addItem(p);
                }
            } catch (Exception ex) {
                Logger.getLogger(TelaCCAC_TPS.class.getName()).log(Level.SEVERE, null, ex);
            }
            Professores professores = (Professores) jComboBoxProfessor.getSelectedItem();
            professores.getIdProf();
            professores.getNomeProfessor();
            objAtivi.setIdProf(professores.getIdProf());
        }
    }//GEN-LAST:event_jComboBoxProfessorItemStateChanged

    private void jComboBoxDescricaoAtividadeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxDescricaoAtividadeItemStateChanged
        // TODO add your handling code here:
        jComboBoxDescricaoAtividade.removeAll();
        if (evt.getStateChange() == evt.SELECTED && acao == 1 || evt.getStateChange() == evt.SELECTED && acao == 2) {
            try {
                for (AssistenciaEducativa c : controlDAO_CUR.read()) {
                    jComboBoxDescricaoAtividade.addItem(c);
                }
            } catch (Exception ex) {
                Logger.getLogger(TelaAssistenciaEducacionalExterna.class.getName()).log(Level.SEVERE, null, ex);
            }
            AssistenciaEducativa cursosDiversos = (AssistenciaEducativa) jComboBoxDescricaoAtividade.getSelectedItem();
            cursosDiversos.getIdCurso();
            cursosDiversos.getDescricaoCurso();
            objAtivi.setIdCurso(cursosDiversos.getIdCurso());
        }
    }//GEN-LAST:event_jComboBoxDescricaoAtividadeItemStateChanged

    private void jBtNovoInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoInternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtNovoInternoActionPerformed

    private void jBtAlterarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarInternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtAlterarInternoActionPerformed

    private void jBtExcluirInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirInternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtExcluirInternoActionPerformed

    private void jBtSalvarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarInternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtSalvarInternoActionPerformed

    private void jBtCancelarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarInternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtCancelarInternoActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jBtSairGeralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairGeralActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtSairGeralActionPerformed

    private void jBtAuditoriaInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaInternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtAuditoriaInternoActionPerformed

    private void jBtPesquisaInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisaInternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtPesquisaInternoActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtAlterarInterno;
    private javax.swing.JButton jBtAuditoria;
    private javax.swing.JButton jBtAuditoriaInterno;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtCancelarInterno;
    private javax.swing.JButton jBtExcluir;
    private javax.swing.JButton jBtExcluirInterno;
    private javax.swing.JButton jBtFinalizar;
    private javax.swing.JButton jBtNovo;
    private javax.swing.JButton jBtNovoInterno;
    private javax.swing.JButton jBtPesqCodigo;
    private javax.swing.JButton jBtPesqData;
    private javax.swing.JButton jBtPesqNomeInterno;
    private javax.swing.JButton jBtPesquisaInterno;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSairGeral;
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JButton jBtSalvarInterno;
    private javax.swing.JButton jButton14;
    private javax.swing.JTextField jCNC;
    private javax.swing.JFormattedTextField jCargaHoraria;
    private javax.swing.JCheckBox jCheckBox2;
    public static javax.swing.JCheckBox jCheckBoxDom;
    public static javax.swing.JCheckBox jCheckBoxQua;
    public static javax.swing.JCheckBox jCheckBoxQui;
    public static javax.swing.JCheckBox jCheckBoxSab;
    public static javax.swing.JCheckBox jCheckBoxSeg;
    public static javax.swing.JCheckBox jCheckBoxSex;
    public static javax.swing.JCheckBox jCheckBoxTer;
    public static javax.swing.JComboBox<Object> jComboBoxDescricaoAtividade;
    public static javax.swing.JComboBox<Object> jComboBoxInstituicao;
    public static javax.swing.JComboBox<Object> jComboBoxProfessor;
    private javax.swing.JComboBox<String> jComboBoxTurno;
    private com.toedter.calendar.JDateChooser jDataEvento;
    private com.toedter.calendar.JDateChooser jDataPesFinal;
    private com.toedter.calendar.JDateChooser jDataPesqInicial;
    public static javax.swing.JCheckBox jDomingoVisita;
    public static javax.swing.JFormattedTextField jHoraDom;
    public static javax.swing.JFormattedTextField jHoraDomEnt;
    public static javax.swing.JFormattedTextField jHoraQua;
    public static javax.swing.JFormattedTextField jHoraQuaEnt;
    public static javax.swing.JFormattedTextField jHoraQui;
    public static javax.swing.JFormattedTextField jHoraQuiEnt;
    public static javax.swing.JFormattedTextField jHoraSab;
    public static javax.swing.JFormattedTextField jHoraSabEnt;
    public static javax.swing.JFormattedTextField jHoraSeg;
    public static javax.swing.JFormattedTextField jHoraSegEnt;
    public static javax.swing.JFormattedTextField jHoraSex;
    public static javax.swing.JFormattedTextField jHoraSexEnt;
    public static javax.swing.JFormattedTextField jHoraTer;
    public static javax.swing.JFormattedTextField jHoraTerEnt;
    private javax.swing.JTextField jIDPesqLan;
    private javax.swing.JTextField jIdInternoAC;
    public static javax.swing.JTextField jIdLanc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jNomeInternoAC;
    private javax.swing.JTextArea jObservacao;
    private javax.swing.JTextField jObservacaoInterno;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jPesqNomeInterno;
    public static javax.swing.JCheckBox jQuartaVisita;
    public static javax.swing.JCheckBox jQuintaVisita;
    public static javax.swing.JCheckBox jSabadoVisita;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    public static javax.swing.JCheckBox jSegundaVisita;
    public static javax.swing.JCheckBox jSextaVisita;
    private javax.swing.JTextField jStatus;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTabelaAssistenciaEducaional;
    private javax.swing.JTable jTable1;
    public static javax.swing.JCheckBox jTercaVisita;
    private javax.swing.JLabel jtotalRegistros;
    private javax.swing.JLabel jtotalRegistrosInt;
    // End of variables declaration//GEN-END:variables

    public void corCampos() {
        jIdLanc.setBackground(Color.white);
        jStatus.setBackground(Color.white);
        jDataEvento.setBackground(Color.white);
        jComboBoxInstituicao.setBackground(Color.white);
        jComboBoxProfessor.setBackground(Color.white);
        jCargaHoraria.setBackground(Color.white);
        jComboBoxTurno.setBackground(Color.white);
        jComboBoxDescricaoAtividade.setBackground(Color.white);
        jObservacao.setBackground(Color.white);
        //
        jIdInternoAC.setBackground(Color.white);
        jCNC.setBackground(Color.white);
        jNomeInternoAC.setBackground(Color.white);
        jObservacaoInterno.setBackground(Color.white);
    }

    public void formatarCampos() {
        jObservacao.setLineWrap(true);
        jObservacao.setWrapStyleWord(true);
    }

    public void bloquearCampos() {
        jIdLanc.setEnabled(!true);
        jStatus.setEnabled(!true);
        jDataEvento.setEnabled(!true);
        jComboBoxInstituicao.setEnabled(!true);
        jComboBoxProfessor.setEnabled(!true);
        jCargaHoraria.setEnabled(!true);
        jComboBoxTurno.setEnabled(!true);
        jCheckBoxSeg.setEnabled(!true);
        jCheckBoxTer.setEnabled(!true);
        jCheckBoxQua.setEnabled(!true);
        jCheckBoxQui.setEnabled(!true);
        jCheckBoxSex.setEnabled(!true);
        jCheckBoxSab.setEnabled(!true);
        jCheckBoxDom.setEnabled(!true);
        jComboBoxDescricaoAtividade.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jIdInternoAC.setEnabled(!true);
        jCNC.setEnabled(!true);
        jNomeInternoAC.setEnabled(!true);
        jObservacaoInterno.setEnabled(!true);
    }

    public void bloquearCamposAba2() {
        jIdInternoAC.setEnabled(!true);
        jCNC.setEnabled(!true);
        jNomeInternoAC.setEnabled(!true);
        jObservacaoInterno.setEnabled(!true);
    }

    public void bloquearBotoes() {
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(!true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        jBtPesquisaInterno.setEnabled(!true);
    }

    public void limparCamposTodos() {
        jIdLanc.setText("");
        jStatus.setText("");
        jDataEvento.setDate(null);
        jComboBoxInstituicao.setSelectedItem(null);
        jComboBoxProfessor.setSelectedItem(null);
        jCargaHoraria.setText("");
        jComboBoxTurno.setSelectedItem("Selecione...");
        jCheckBoxSeg.setSelected(!true);
        jCheckBoxTer.setSelected(!true);
        jCheckBoxQua.setSelected(!true);
        jCheckBoxQui.setSelected(!true);
        jCheckBoxSex.setSelected(!true);
        jCheckBoxSab.setSelected(!true);
        jCheckBoxDom.setSelected(!true);
        jComboBoxDescricaoAtividade.setSelectedItem(null);
        jObservacao.setText("");
        //
        jIdInternoAC.setText("");
        jCNC.setText("");
        jNomeInternoAC.setText("");
        jObservacaoInterno.setText("");
    }

    public void limparCamposAba2() {
        jIdInternoAC.setText("");
        jCNC.setText("");
        jNomeInternoAC.setText("");
        jObservacaoInterno.setText("");
    }

    public void habilitarCamposAba1() {
        jComboBoxInstituicao.setEnabled(true);
        jComboBoxProfessor.setEnabled(true);
        jCargaHoraria.setEnabled(true);
        jComboBoxTurno.setEnabled(true);
        jComboBoxDescricaoAtividade.setEnabled(true);
        jCheckBoxSeg.setEnabled(true);
        jCheckBoxTer.setEnabled(true);
        jCheckBoxQua.setEnabled(true);
        jCheckBoxQui.setEnabled(true);
        jCheckBoxSex.setEnabled(true);
        jCheckBoxSab.setEnabled(true);
        jCheckBoxDom.setEnabled(true);
        jObservacao.setEnabled(true);
    }

    public void Novo() {
        jStatus.setText("ABERTO");
        jDataEvento.setCalendar(Calendar.getInstance());
        //
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
    }

    public void Alterar() {
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
        jBtAuditoria.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        //
        jBtNovoInterno.setEnabled(true);
    }

    public void Cancelar() {

    }

    public void buscarCodigoAba1() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ATIVIDADES_COMPLEMENTARES_PEDAGOGICA");
            conecta.rs.last();
            jIdLanc.setText(conecta.rs.getString("IdAC"));
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void preencherComboBoxInstituicao() {
        jComboBoxInstituicao.removeAll();
        try {
            for (Instituicao i : controlDAO_INS.read()) {
                jComboBoxInstituicao.addItem(i);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaCCAC_TPS.class.getName()).log(Level.SEVERE, null, ex);
        }
        Instituicao instituicao = (Instituicao) jComboBoxInstituicao.getSelectedItem();
        instituicao.getIdCod();
        instituicao.getNomeInstituicao();
        objAtivi.setIdCod(instituicao.getIdCod());
    }

    public void preencherComboBoxProfessor() {
        jComboBoxProfessor.removeAll();
        try {
            for (Professores p : controlDAO_PRF.read()) {
                jComboBoxProfessor.addItem(p);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaCCAC_TPS.class.getName()).log(Level.SEVERE, null, ex);
        }
        Professores professores = (Professores) jComboBoxProfessor.getSelectedItem();
        professores.getIdProf();
        professores.getNomeProfessor();
        objAtivi.setIdProf(professores.getIdProf());
    }

    public void preencherComboBoxCurso() {
        jComboBoxDescricaoAtividade.removeAll();
        try {
            for (AssistenciaEducativa c : controlDAO_CUR.read()) {
                jComboBoxDescricaoAtividade.addItem(c);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAssistenciaEducacionalExterna.class.getName()).log(Level.SEVERE, null, ex);
        }
        AssistenciaEducativa cursosDiversos = (AssistenciaEducativa) jComboBoxDescricaoAtividade.getSelectedItem();
        cursosDiversos.getIdCurso();
        cursosDiversos.getDescricaoCurso();
        objAtivi.setIdCurso(cursosDiversos.getIdCurso());
    }

    public void NovoInterno() {

    }

    public void AlterarInterno() {

    }

    public void ExcluirInterno() {

    }

    public void SalvarInterno() {

    }

    public void CancelarInterno() {

    }

    public void preencherTabelaAtividadesComplementares(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Observação"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1;
                // Fortmatar data de Cadastro          
                dataCadastro = conecta.rs.getString("DataAC");
                String day = dataCadastro.substring(8, 10);
                String mesc = dataCadastro.substring(5, 7);
                String anoc = dataCadastro.substring(0, 4);
                dataCadastro = day + "/" + mesc + "/" + anoc;
                //
                jtotalRegistros.setText(Integer.toString(count));
                dados.add(new Object[]{conecta.rs.getInt("IdAC"), dataCadastro, conecta.rs.getString("StatusAC"), conecta.rs.getString("Observacao")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Dados não encontrado, use o botão TODOS \nPara pesquisar TODOS OS REGISTROS");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaAssistenciaEducaional.setModel(modelo);
        jTabelaAssistenciaEducaional.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaAssistenciaEducaional.getColumnModel().getColumn(0).setResizable(false);
        jTabelaAssistenciaEducaional.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaAssistenciaEducaional.getColumnModel().getColumn(1).setResizable(false);
        jTabelaAssistenciaEducaional.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaAssistenciaEducaional.getColumnModel().getColumn(2).setResizable(false);
        jTabelaAssistenciaEducaional.getColumnModel().getColumn(3).setPreferredWidth(280);
        jTabelaAssistenciaEducaional.getColumnModel().getColumn(3).setResizable(false);
        jTabelaAssistenciaEducaional.getTableHeader().setReorderingAllowed(false);
        jTabelaAssistenciaEducaional.setAutoResizeMode(jTabelaAssistenciaEducaional.AUTO_RESIZE_OFF);
        jTabelaAssistenciaEducaional.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaAssistenciaEducaional();
        conecta.desconecta();
    }

    public void limparTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Observação"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaAssistenciaEducaional.setModel(modelo);
        jTabelaAssistenciaEducaional.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaAssistenciaEducaional.getColumnModel().getColumn(0).setResizable(false);
        jTabelaAssistenciaEducaional.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaAssistenciaEducaional.getColumnModel().getColumn(1).setResizable(false);
        jTabelaAssistenciaEducaional.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaAssistenciaEducaional.getColumnModel().getColumn(2).setResizable(false);
        jTabelaAssistenciaEducaional.getColumnModel().getColumn(3).setPreferredWidth(280);
        jTabelaAssistenciaEducaional.getColumnModel().getColumn(3).setResizable(false);
        jTabelaAssistenciaEducaional.getTableHeader().setReorderingAllowed(false);
        jTabelaAssistenciaEducaional.setAutoResizeMode(jTabelaAssistenciaEducaional.AUTO_RESIZE_OFF);
        jTabelaAssistenciaEducaional.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabelaAssistenciaEducaional() {
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaAssistenciaEducaional.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaAssistenciaEducaional.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaAssistenciaEducaional.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }

    public void preencherTabelaInternos(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código", "Nome do Interno", "Matricula Penal"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count0 = count0 + 1;
                jtotalRegistrosInt.setText(Integer.toString(count));
                dados.add(new Object[]{conecta.rs.getInt("IdItem"), conecta.rs.getString("IdInternoCrc"), conecta.rs.getString("NomeInternoCrc"), conecta.rs.getString("MatriculaCrc")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTable1.setModel(modelo);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(0).setResizable(false);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTable1.getColumnModel().getColumn(1).setResizable(false);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(250);
        jTable1.getColumnModel().getColumn(2).setResizable(false);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(3).setResizable(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaInternos();
        conecta.desconecta();
    }

    public void limparTabelaItens() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código", "Nome do Interno", "Matricula Penal"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTable1.setModel(modelo);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(0).setResizable(false);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTable1.getColumnModel().getColumn(1).setResizable(false);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(250);
        jTable1.getColumnModel().getColumn(2).setResizable(false);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(3).setResizable(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabelaInternos() {
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTable1.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTable1.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTable1.getColumnModel().getColumn(3).setCellRenderer(centralizado);
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
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jIdLanc.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void buscarAcessoUsuario(String nomeTelaAcesso) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nameUser + "'");
            conecta.rs.first();
            codigoUserPEDA = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUserPEDA + "'");
            conecta.rs.first();
            codigoUserGroupPEDA = conecta.rs.getInt("IdUsuario");
            codigoGrupoPEDA = conecta.rs.getInt("IdGrupo");
            nomeGrupoPEDA = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUserPEDA + "' "
                    + "AND NomeTela='" + nomeTelaAcesso + "'");
            conecta.rs.first();
            codUserAcessoPEDA = conecta.rs.getInt("IdUsuario");
            codAbrirPEDA = conecta.rs.getInt("Abrir");
            codIncluirPEDA = conecta.rs.getInt("Incluir");
            codAlterarPEDA = conecta.rs.getInt("Alterar");
            codExcluirPEDA = conecta.rs.getInt("Excluir");
            codGravarPEDA = conecta.rs.getInt("Gravar");
            codConsultarPEDA = conecta.rs.getInt("Consultar");
            nomeTelaPEDA = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
