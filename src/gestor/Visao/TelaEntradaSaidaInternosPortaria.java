/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleEntradaSaidaLaborInterno;
import gestor.Controle.ControleHistoricoEmpresasInternos;
import gestor.Controle.ControleItensEntradaSaidaLabor;
import gestor.Controle.ControleLogSistema;
import gestor.Dao.ConexaoBancoDados;
import Utilitarios.LimiteDigitos;
import Utilitarios.ModeloTabela;
import gestor.Modelo.EntradaSaidaLaborInterno;
import gestor.Modelo.HistoricoInternosEmpresa;
import gestor.Modelo.ItensEntradaSaidaLaborInterno;
import gestor.Modelo.LogSistema;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloPortarias.codAbrirP1;
import static gestor.Visao.TelaModuloPortarias.codigoUserGroupP1;
import static gestor.Visao.TelaModuloPortarias.codigoGrupoP1;
import static gestor.Visao.TelaModuloPortarias.codAlterarP1;
import static gestor.Visao.TelaModuloPortarias.codExcluirP1;
import static gestor.Visao.TelaModuloPortarias.codGravarP1;
import static gestor.Visao.TelaModuloPortarias.codConsultarP1;
import static gestor.Visao.TelaModuloPortarias.codIncluirP1;
import static gestor.Visao.TelaModuloPortarias.codUserAcessoP1;
import static gestor.Visao.TelaModuloPortarias.codigoUserP1;
import static gestor.Visao.TelaModuloPortarias.nomeGrupoP1;
import static gestor.Visao.TelaModuloPortarias.nomeTelaP1;
import static gestor.Visao.TelaModuloPortarias.telaEntradaSaidaLABBio;
import static gestor.Visao.TelaModuloPortarias.telaEntradaSaidaLABIntP1;
import static gestor.Visao.TelaModuloPortarias.telaEntradaSaidaLABManuP1;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import java.awt.Color;
import java.awt.Image;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
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
public class TelaEntradaSaidaInternosPortaria extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EntradaSaidaLaborInterno objEntSaiLabor = new EntradaSaidaLaborInterno();
    ItensEntradaSaidaLaborInterno objItenLabor = new ItensEntradaSaidaLaborInterno();
    ControleEntradaSaidaLaborInterno control = new ControleEntradaSaidaLaborInterno();
    ControleItensEntradaSaidaLabor controle = new ControleItensEntradaSaidaLabor();
    ControleHistoricoEmpresasInternos controlHist = new ControleHistoricoEmpresasInternos(); // Controla o histório da empresa com os dados do interno
    HistoricoInternosEmpresa objHistInterEmp = new HistoricoInternosEmpresa();
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela = "Portaria:Entrada/Saida de Internos P1:Manutenção";
    String nomeModuloTela2 = "Portaria:Entrada/Saida de Internos P1:Internos";
    String statusMov;
    String horaMov;
    String dataModFinal;

    int acao;
    int flag;
    String statusEnt = "ABERTO";
    String dataInicial;
    String dataFinal;
    String dataEntrada;
    String dataSaida;
    public static String idItem;
    String codlanc;
    String caminho;
    int count = 0;
    // VARIAVEIS PARA BLOQUEAR O REGISTRO CASO NÃO ESTEJA COM OS HORÁRIOS PREENCHIDOS COM AS HORAS.
    String verHorarioSaida = "00:00";
    String verHorarioEntrada = "00:00";
    String horaEntradaEncontrada, codigoRegistro, horaSaidaEncontrado;
    //
    String mesAtual;
    String codigoInterno;
    String codigoInternoCrc, statusFreqLab, mesReferencia, anoReferencia, dataPeriodoInicial, dataPeriodoFinal;
    String statusFreq = "ABERTO";
    int vQuant = 1;
    int qtdDias;
    int qtdDiastotal = 0;
    //
    String codigoInternoBio;
    byte[] pAssinaturaDigital;

    /**
     * Creates new form TelaEntradaSaidaInternosPortaria
     */
    public static TelaFotoPortariaSaidaLaborativa telafotosaidalabor;
    public static TelaDatasHorasEntradaSaidas telaDatasHoras;
    public static TelaBiometriaSaidaLaborativaPortaria biometriaSaidaInterno;

    public TelaEntradaSaidaInternosPortaria() {
        super();
        initComponents();
        setResizable(false);
        formatarCampo();
        corCampo();
    }

    public void mostrarFotoSaidaLaborativa() {
        telafotosaidalabor = new TelaFotoPortariaSaidaLaborativa(this, true);
        telafotosaidalabor.setVisible(true);
    }

    public void mostrarDatgaHorasSaidas() {
        telaDatasHoras = new TelaDatasHorasEntradaSaidas(this, true);
        telaDatasHoras.setVisible(true);
    }

    public void mostrarBiometriaSaidaInternos() {
        biometriaSaidaInterno = new TelaBiometriaSaidaLaborativaPortaria(this, true);
        biometriaSaidaInterno.setVisible(true);
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
        jBtPesqData = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jDataPesqInicial = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        jDataPesqFinal = new com.toedter.calendar.JDateChooser();
        jLabel17 = new javax.swing.JLabel();
        jIDPesqLanc = new javax.swing.JTextField();
        jBtPesqID = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPesqInterno = new javax.swing.JTextField();
        jBtPesqNomeInterno = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTabelaLaborInternos = new javax.swing.JTable();
        jPanel30 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jIDlanc = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jDatalancamento = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jStatusEntCola = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jBtNovo = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jBtFinalizar = new javax.swing.JButton();
        jBtAuditoriaManu = new javax.swing.JButton();
        jBtImpressao = new javax.swing.JButton();
        jBtSairVisita = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jIDEmpresa = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jNomeEmpresa = new javax.swing.JTextField();
        jBtPesqNomeEmpresa = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jObservacao = new javax.swing.JTextArea();
        jPanel9 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jNomeInterno = new javax.swing.JTextField();
        jBtPesqInterno = new javax.swing.JButton();
        jIdInterno = new javax.swing.JTextField();
        jLabelEvadido = new javax.swing.JLabel();
        jDataSaida = new com.toedter.calendar.JDateChooser();
        jLabel19 = new javax.swing.JLabel();
        jHorarioSaida = new javax.swing.JFormattedTextField();
        jLabel20 = new javax.swing.JLabel();
        jDataEntrada = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jHorarioEntrada = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        jBtZoon = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jComboBoxTornozeleira = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jFotoInternoLabor = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jBtNovoInterno = new javax.swing.JButton();
        jBtAlterarInterno = new javax.swing.JButton();
        jBtExcluirInterno = new javax.swing.JButton();
        jBtSalvarInterno = new javax.swing.JButton();
        jBtCancelarInterno = new javax.swing.JButton();
        jBtBuscarInterno = new javax.swing.JButton();
        jBtAudiInternos = new javax.swing.JButton();
        jBtDatasHoras = new javax.swing.JButton();
        jBtBiometria = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabelaInternos = new javax.swing.JTable();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setTitle("...::: Entrada/Saída de Internos Atividade Laborativa {P1} :::...");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jBtPesqData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqData.setContentAreaFilled(false);
        jBtPesqData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqDataActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Data Inicial:");

        jDataPesqInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Data Final:");

        jDataPesqFinal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Código:");

        jIDPesqLanc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIDPesqLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqID.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqID.setContentAreaFilled(false);
        jBtPesqID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqIDActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Nome Interno:");

        jPesqInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqNomeInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqNomeInterno.setContentAreaFilled(false);
        jBtPesqNomeInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqNomeInternoActionPerformed(evt);
            }
        });

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox1.setText("Todos");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jIDPesqLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqID, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataPesqFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqData, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jPesqInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel17)
                    .addComponent(jIDPesqLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqID)
                    .addComponent(jLabel15)
                    .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jDataPesqFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jPesqInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBtPesqNomeInterno)
                    .addComponent(jCheckBox1)))
        );

        jTabelaLaborInternos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaLaborInternos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data", "Status", "Observação"
            }
        ));
        jTabelaLaborInternos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaLaborInternosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTabelaLaborInternos);
        if (jTabelaLaborInternos.getColumnModel().getColumnCount() > 0) {
            jTabelaLaborInternos.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaLaborInternos.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaLaborInternos.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaLaborInternos.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaLaborInternos.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaLaborInternos.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaLaborInternos.getColumnModel().getColumn(3).setMinWidth(530);
            jTabelaLaborInternos.getColumnModel().getColumn(3).setMaxWidth(530);
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
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Listagem", jPanel1);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cabeçalho", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código");

        jIDlanc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIDlanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIDlanc.setEnabled(false);
        jIDlanc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jIDlancActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Data Cadastro");

        jDatalancamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDatalancamento.setEnabled(false);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Status");

        jStatusEntCola.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jStatusEntCola.setForeground(new java.awt.Color(255, 0, 0));
        jStatusEntCola.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jStatusEntCola.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jIDlanc, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jStatusEntCola)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDatalancamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIDlanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jStatusEntCola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDatalancamento, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 5, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Botões", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        jBtNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovo.setText("Novo");
        jBtNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoActionPerformed(evt);
            }
        });

        jBtAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterar.setText("Alterar");
        jBtAlterar.setEnabled(false);
        jBtAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarActionPerformed(evt);
            }
        });

        jBtExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluir.setText("Excluir");
        jBtExcluir.setEnabled(false);
        jBtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirActionPerformed(evt);
            }
        });

        jBtSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvar.setText("Gravar");
        jBtSalvar.setEnabled(false);
        jBtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarActionPerformed(evt);
            }
        });

        jBtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelar.setText("Cancelar");
        jBtCancelar.setEnabled(false);
        jBtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarActionPerformed(evt);
            }
        });

        jBtFinalizar.setForeground(new java.awt.Color(255, 0, 0));
        jBtFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/accept.png"))); // NOI18N
        jBtFinalizar.setText("Finalizar");
        jBtFinalizar.setEnabled(false);
        jBtFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFinalizarActionPerformed(evt);
            }
        });

        jBtAuditoriaManu.setForeground(new java.awt.Color(0, 0, 255));
        jBtAuditoriaManu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaManu.setText("Auditoria");
        jBtAuditoriaManu.setToolTipText("Auditoria");
        jBtAuditoriaManu.setEnabled(false);
        jBtAuditoriaManu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaManuActionPerformed(evt);
            }
        });

        jBtImpressao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtImpressao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/gtklp-icone-3770-16.png"))); // NOI18N
        jBtImpressao.setText("Impressão");
        jBtImpressao.setEnabled(false);

        jBtSairVisita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSairVisita.setText("Sair");
        jBtSairVisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairVisitaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtCancelar)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtNovo)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jBtSalvar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jBtAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jBtExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jBtFinalizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jBtAuditoriaManu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jBtImpressao)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jBtSairVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterar, jBtCancelar, jBtExcluir, jBtNovo, jBtSalvar});

        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jBtNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtExcluir))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jBtImpressao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtAuditoriaManu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtFinalizar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtSalvar)
                    .addComponent(jBtSairVisita))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterar, jBtAuditoriaManu, jBtCancelar, jBtExcluir, jBtFinalizar, jBtImpressao, jBtNovo, jBtSalvar});

        jTabbedPane2.setForeground(new java.awt.Color(0, 0, 255));
        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Código");

        jIDEmpresa.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIDEmpresa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIDEmpresa.setEnabled(false);
        jIDEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jIDEmpresaActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Razão Social");

        jNomeEmpresa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeEmpresa.setEnabled(false);

        jBtPesqNomeEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqNomeEmpresa.setContentAreaFilled(false);
        jBtPesqNomeEmpresa.setEnabled(false);
        jBtPesqNomeEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqNomeEmpresaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jIDEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 263, Short.MAX_VALUE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jNomeEmpresa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqNomeEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIDEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNomeEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqNomeEmpresa))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Dados da Empresa", jPanel10);

        jObservacao.setColumns(20);
        jObservacao.setRows(5);
        jObservacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jObservacao.setEnabled(false);
        jScrollPane1.setViewportView(jObservacao);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Observação", jPanel11);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Interno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 255, 0))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Código");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Nome do Interno");

        jNomeInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInterno.setEnabled(false);

        jBtPesqInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqInterno.setToolTipText("Pesquisar Setor");
        jBtPesqInterno.setContentAreaFilled(false);
        jBtPesqInterno.setEnabled(false);
        jBtPesqInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqInternoActionPerformed(evt);
            }
        });

        jIdInterno.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdInterno.setEnabled(false);

        jLabelEvadido.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelEvadido.setForeground(new java.awt.Color(255, 0, 0));
        jLabelEvadido.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jDataSaida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataSaida.setEnabled(false);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 51, 0));
        jLabel19.setText("Data Saída");

        jHorarioSaida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHorarioSaida.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jHorarioSaida.setEnabled(false);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 51, 0));
        jLabel20.setText("Horário");

        jDataEntrada.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataEntrada.setToolTipText("Data Entrada/Retorno do interno na unidade");
        jDataEntrada.setEnabled(false);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 0, 255));
        jLabel11.setText("Data Entrada");

        jHorarioEntrada.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHorarioEntrada.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jHorarioEntrada.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 0, 255));
        jLabel13.setText("Horário");

        jBtZoon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/11985_16x16.png"))); // NOI18N
        jBtZoon.setToolTipText("Ampliar Foto do Interno");
        jBtZoon.setEnabled(false);
        jBtZoon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtZoonActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Tornozeleira");

        jComboBoxTornozeleira.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTornozeleira.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "Não", "Sim" }));
        jComboBoxTornozeleira.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTornozeleira.setEnabled(false);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jIdInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelEvadido, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jBtZoon, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19))
                                .addGap(3, 3, 3)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20)
                                    .addComponent(jHorarioSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addGap(3, 3, 3)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jHorarioEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jComboBoxTornozeleira, 0, 0, Short.MAX_VALUE)))
                            .addComponent(jNomeInterno))
                        .addGap(5, 5, 5))))
        );

        jPanel9Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jHorarioEntrada, jHorarioSaida});

        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel8))
                .addGap(36, 36, 36))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jIdInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtPesqInterno)
                            .addComponent(jLabelEvadido, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtZoon))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jHorarioSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jHorarioEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxTornozeleira, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jLabel11)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Foto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoLabor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoLabor, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
        );

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Botões", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        jBtNovoInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoInterno.setText("Novo");
        jBtNovoInterno.setEnabled(false);
        jBtNovoInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoInternoActionPerformed(evt);
            }
        });

        jBtAlterarInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarInterno.setText("Alterar");
        jBtAlterarInterno.setEnabled(false);
        jBtAlterarInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarInternoActionPerformed(evt);
            }
        });

        jBtExcluirInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirInterno.setText("Excluir");
        jBtExcluirInterno.setEnabled(false);
        jBtExcluirInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirInternoActionPerformed(evt);
            }
        });

        jBtSalvarInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarInterno.setText("Gravar");
        jBtSalvarInterno.setEnabled(false);
        jBtSalvarInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarInternoActionPerformed(evt);
            }
        });

        jBtCancelarInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarInterno.setText("Cancelar");
        jBtCancelarInterno.setEnabled(false);
        jBtCancelarInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarInternoActionPerformed(evt);
            }
        });

        jBtBuscarInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtBuscarInterno.setText("Buscar");
        jBtBuscarInterno.setEnabled(false);
        jBtBuscarInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtBuscarInternoActionPerformed(evt);
            }
        });

        jBtAudiInternos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtAudiInternos.setForeground(new java.awt.Color(255, 0, 0));
        jBtAudiInternos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAudiInternos.setToolTipText("Auditoria");
        jBtAudiInternos.setContentAreaFilled(false);
        jBtAudiInternos.setEnabled(false);
        jBtAudiInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAudiInternosActionPerformed(evt);
            }
        });

        jBtDatasHoras.setForeground(new java.awt.Color(0, 153, 0));
        jBtDatasHoras.setText("Datas/Horas");
        jBtDatasHoras.setToolTipText("Datas/Horas Entrada/Saída");
        jBtDatasHoras.setEnabled(false);
        jBtDatasHoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtDatasHorasActionPerformed(evt);
            }
        });

        jBtBiometria.setForeground(new java.awt.Color(204, 0, 0));
        jBtBiometria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Biometria16Vermelho.png"))); // NOI18N
        jBtBiometria.setText("Biometria");
        jBtBiometria.setEnabled(false);
        jBtBiometria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtBiometriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtExcluirInterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtSalvarInterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtCancelarInterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtBuscarInterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtNovoInterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtAlterarInterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtDatasHoras))
                .addGap(24, 24, 24))
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBtBiometria))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jBtAudiInternos, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel18Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterarInterno, jBtBiometria, jBtBuscarInterno, jBtCancelarInterno, jBtDatasHoras, jBtExcluirInterno, jBtNovoInterno, jBtSalvarInterno});

        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtNovoInterno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarInterno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirInterno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarInterno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelarInterno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtBuscarInterno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtDatasHoras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtBiometria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAudiInternos, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jTabelaInternos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaInternos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome do Interno", "Data Saída", "Horário", "Data Entrada", "Horário"
            }
        ));
        jTabelaInternos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaInternosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTabelaInternos);
        if (jTabelaInternos.getColumnModel().getColumnCount() > 0) {
            jTabelaInternos.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaInternos.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaInternos.getColumnModel().getColumn(1).setMinWidth(250);
            jTabelaInternos.getColumnModel().getColumn(1).setMaxWidth(250);
            jTabelaInternos.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaInternos.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaInternos.getColumnModel().getColumn(3).setMinWidth(70);
            jTabelaInternos.getColumnModel().getColumn(3).setMaxWidth(70);
            jTabelaInternos.getColumnModel().getColumn(4).setMinWidth(80);
            jTabelaInternos.getColumnModel().getColumn(4).setMaxWidth(80);
            jTabelaInternos.getColumnModel().getColumn(5).setMinWidth(70);
            jTabelaInternos.getColumnModel().getColumn(5).setMaxWidth(70);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE))
                        .addGap(5, 5, 5)
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Manutenção", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(300, 20, 738, 559);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesqDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqDataActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (jDataPesqInicial.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Informe a data inicial para pesquisa.");
            jDataPesqInicial.requestFocus();
        } else {
            if (jDataPesqFinal.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data final para pesquisa.");
                jDataPesqFinal.requestFocus();
            } else {
                if (jDataPesqInicial.getDate().after(jDataPesqFinal.getDate())) {
                    JOptionPane.showMessageDialog(rootPane, "Data Inicial não pode ser maior que data final");
                } else {
                    SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
                    dataInicial = formatoAmerica.format(jDataPesqInicial.getDate().getTime());
                    dataFinal = formatoAmerica.format(jDataPesqFinal.getDate().getTime());
                    preencherTodasEntSai("SELECT * FROM ENTRADALABORINTERNO "
                            + "INNER JOIN ITENSLABORINTERNO "
                            + "ON ENTRADALABORINTERNO.IdLanc=ITENSLABORINTERNO.IdLanc "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON ITENSLABORINTERNO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "WHERE DataLanc BETWEEN'" + dataInicial + "'AND'" + dataFinal + "'");
                }
            }
        }
    }//GEN-LAST:event_jBtPesqDataActionPerformed

    private void jBtPesqIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqIDActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (jIDPesqLanc.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um ID para pesquisa.");
        } else {
            preencherTodasEntSai("SELECT * FROM ENTRADALABORINTERNO "
                    + "INNER JOIN ITENSLABORINTERNO "
                    + "ON ENTRADALABORINTERNO.IdLanc=ITENSLABORINTERNO.IdLanc "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENSLABORINTERNO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE ENTRADALABORINTERNO.IdLanc='" + jIDPesqLanc.getText() + "'");
        }
    }//GEN-LAST:event_jBtPesqIDActionPerformed

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntradaSaidaLABManuP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaSaidaLABManuP1) && codIncluirP1 == 1) {
            acao = 1;
            Novo();
            corCampo();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntradaSaidaLABManuP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaSaidaLABManuP1) && codAlterarP1 == 1) {
            objEntSaiLabor.setStatusLanc(jStatusEntCola.getText());
            if (jStatusEntCola.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa entrada de colaboradores não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 2;
                Alterar();
                corCampo();
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtAlterarActionPerformed

    private void jBtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntradaSaidaLABManuP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaSaidaLABManuP1) && codExcluirP1 == 1) {
            objEntSaiLabor.setStatusLanc(jStatusEntCola.getText());
            if (jStatusEntCola.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse lançamento não poderá ser excluída, o mesmo encontra-se FINALIZADO");
            } else {
                verificarItens();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntradaSaidaLABManuP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaSaidaLABManuP1) && codGravarP1 == 1) {
            if (jDatalancamento.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data do lancamento.");
                jDatalancamento.requestFocus();
                jDatalancamento.setBackground(Color.white);
            } else {
                if (jNomeEmpresa.getText().equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Informe o nome da empresa.");
                } else {
                    objEntSaiLabor.setDataLanc(jDatalancamento.getDate());
                    objEntSaiLabor.setObsLanc(jObservacao.getText());
                    objEntSaiLabor.setStatusLanc(statusEnt);
                    if (acao == 1) {
                        objEntSaiLabor.setUsuarioInsert(nameUser);
                        objEntSaiLabor.setDataInsert(dataModFinal);
                        objEntSaiLabor.setHoraInsert(horaMov);
                        objEntSaiLabor.setNomeEmpresa(jNomeEmpresa.getText());
                        control.incluirEntSaiLabor(objEntSaiLabor);
                        buscarID();
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                        Salvar();
                    }
                    if (acao == 2) {
                        objEntSaiLabor.setUsuarioUp(nameUser);
                        objEntSaiLabor.setDataUp(dataModFinal);
                        objEntSaiLabor.setHoraUp(horaMov);
                        objEntSaiLabor.setIdLanc(Integer.valueOf(jIDlanc.getText()));
                        objEntSaiLabor.setNomeEmpresa(jNomeEmpresa.getText());
                        control.alterarEntSaiLabor(objEntSaiLabor);
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                        Salvar();
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
        verificarHoraEntrada();
        if (jHorarioSaida.getText().equals(horaSaidaEncontrado) && jIDlanc.getText().equals(codigoRegistro) || jHorarioEntrada.getText().equals(horaEntradaEncontrada) && jIDlanc.getText().equals(codigoRegistro)) {
            JOptionPane.showMessageDialog(rootPane, "Não é possível FINALIZAR esse registro, existe(m) horário(s) de entrada de interno(s) em aberto.\nCorrija os horários com divergências e então poderá FINALIZAR o documento. ");
        } else {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ENTRADALABORINTERNO WHERE IdLanc='" + jIDlanc.getText() + "'");
                conecta.rs.first();
                jStatusEntCola.setText(conecta.rs.getString("StatusLanc"));
                if (jStatusEntCola.getText().equals("FINALIZADO")) {
                    JOptionPane.showMessageDialog(rootPane, "Lançamento já foi finalizado");
                } else {
                    Finalizar();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não foi possível verificar se lançamento foi finalizado\nERRO: " + ex);
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jBtFinalizarActionPerformed

    private void jBtPesqInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqInternoActionPerformed
        // TODO add your handling code here:
        TelaPesqInternosLabor objInternosLabor = new TelaPesqInternosLabor();
        TelaModuloPortarias.jPainelPortarias.add(objInternosLabor);
        objInternosLabor.show();
    }//GEN-LAST:event_jBtPesqInternoActionPerformed

    private void jTabelaInternosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaInternosMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            String nomeColaborador = "" + jTabelaInternos.getValueAt(jTabelaInternos.getSelectedRow(), 1);
            jNomeInterno.setText(nomeColaborador);
            idItem = "" + jTabelaInternos.getValueAt(jTabelaInternos.getSelectedRow(), 2);
            // Habilitar os botões
            jBtZoon.setEnabled(true);
            jBtNovoInterno.setEnabled(!true);
            jBtAlterarInterno.setEnabled(true);
            jBtExcluirInterno.setEnabled(true);
            jBtSalvarInterno.setEnabled(!true);
            jBtCancelarInterno.setEnabled(true);
            jBtBuscarInterno.setEnabled(!true);
            jBtAuditoriaManu.setEnabled(!true);
            jBtAudiInternos.setEnabled(true);
            jBtDatasHoras.setEnabled(true);
            //
            jDatalancamento.setEnabled(!true);
            jBtPesqNomeEmpresa.setEnabled(!true);
            jObservacao.setEnabled(!true);
            //
            jBtNovo.setEnabled(!true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ITENSLABORINTERNO "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ITENSLABORINTERNO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE NomeInternoCrc='" + jNomeInterno.getText() + "' AND IdLanc='" + jIDlanc.getText() + "'");
                conecta.rs.first();
                jIdInterno.setText(conecta.rs.getString("IdInternoCrc"));
                jNomeInterno.setText(conecta.rs.getString("NomeInternoCrc"));
                idItem = conecta.rs.getString("IdItem"); // Coluna 2               
                // Capturando foto
                caminho = conecta.rs.getString("FotoInternoCrc");
                if (caminho != null) {
                    javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                    jFotoInternoLabor.setIcon(i);
                    jFotoInternoLabor.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoInternoLabor.getWidth(), jFotoInternoLabor.getHeight(), Image.SCALE_DEFAULT)));
                }
                // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrente"));
                if (imgBytes != null) {
                    ImageIcon pic = null;
                    pic = new ImageIcon(imgBytes);
                    Image scaled = pic.getImage().getScaledInstance(jFotoInternoLabor.getWidth(), jFotoInternoLabor.getHeight(), Image.SCALE_DEFAULT);
                    ImageIcon icon = new ImageIcon(scaled);
                    jFotoInternoLabor.setIcon(icon);
                }
                jDataEntrada.setDate(conecta.rs.getDate("DataEntrada"));
                jHorarioEntrada.setText(conecta.rs.getString("HorarioEntrada"));
                jDataSaida.setDate(conecta.rs.getDate("DataSaida"));
                jHorarioSaida.setText(conecta.rs.getString("HorarioSaida"));
                jLabelEvadido.setText(conecta.rs.getString("Evadido"));
                jComboBoxTornozeleira.setSelectedItem(conecta.rs.getString("Tornozeleira"));
                conecta.desconecta();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não existe dados a serem alterado!!!" + ex);
            }
        }
    }//GEN-LAST:event_jTabelaInternosMouseClicked

    private void jBtNovoInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoInternoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntradaSaidaLABIntP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaSaidaLABIntP1) && codIncluirP1 == 1) {
            objEntSaiLabor.setStatusLanc(jStatusEntCola.getText());
            if (jStatusEntCola.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa entrada de interno não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 3;
                NovoInterno();
                corCampo();
                statusMov = "Incluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtNovoInternoActionPerformed

    private void jBtAlterarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarInternoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntradaSaidaLABIntP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaSaidaLABIntP1) && codAlterarP1 == 1) {
            objEntSaiLabor.setStatusLanc(jStatusEntCola.getText());
            if (jStatusEntCola.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa entrada de interno não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                if (jLabelEvadido.getText().equals("EVADIDO")) {
                    JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser alterado, o interno está evadido.");
                } else {
                    if (jLabelEvadido.getText().equals("EVADIDO")) {
                        JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser modificado, interno encontra-se evadido");
                    } else {
                        acao = 4;
                        verificarAcessoBiometriaInterno();
                        //pAssinaturaDigital
                        if (jIdInterno.getText().equals(codigoInternoBio) && pAssinaturaDigital != null) {
                            AlterarInternoBiometria();
                        } else {
                            corCampo();
                            statusMov = "Alterou";
                            horaMov = jHoraSistema.getText();
                            dataModFinal = jDataSistema.getText();
                            AlterarInterno();
                        }
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtAlterarInternoActionPerformed

    private void jBtExcluirInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirInternoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntradaSaidaLABIntP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaSaidaLABIntP1) && codExcluirP1 == 1) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            verificarAcessoBiometriaInterno();
            objEntSaiLabor.setStatusLanc(jStatusEntCola.getText());
            if (jStatusEntCola.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse  interno não poderá ser excluído, o mesmo encontra-se FINALIZADO");
            } else if (jLabelEvadido.getText().equals("EVADIDO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não pode ser excluído, o interno encontra-se evadido.");
            } else if (jIdInterno.getText().equals(codigoInternoBio) && pAssinaturaDigital != null) {
                JOptionPane.showMessageDialog(rootPane, "Não é possível excluir esse registro de interno, o mesmo tem assinatura digital.");
            } else {
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o interno selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    objItenLabor.setIdItem(Integer.valueOf(idItem));
                    controle.excluirItensLaborInterno(objItenLabor);
                    objDatasHoras();
                    controlHist.excluirInterEmp(objHistInterEmp);
                    objLog2();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                    ExcluirInterno();
                    preencherTabelaItens("SELECT * FROM ITENSLABORINTERNO "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON ITENSLABORINTERNO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "WHERE Idlanc='" + jIDlanc.getText() + "'");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtExcluirInternoActionPerformed

    private void jBtSalvarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarInternoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntradaSaidaLABIntP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaSaidaLABIntP1) && codGravarP1 == 1) {
            horaEntradaEncontrada = "";
            horaSaidaEncontrado = "";
            if (jNomeInterno.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome do Interno");
                jNomeInterno.requestFocus();
                jNomeInterno.setBackground(Color.red);
            } else {
                if (jDataSaida.getDate() == null) {
                    JOptionPane.showMessageDialog(rootPane, "Informe a data de saida do interno.");
                    jDataSaida.requestFocus();
                    jDataSaida.setBackground(Color.red);
                } else {
                    if (jDataEntrada.getDate() == null) {
                        JOptionPane.showMessageDialog(rootPane, "Informe a data de entrada do interno.");
                        jDataEntrada.requestFocus();
                        jDataEntrada.setBackground(Color.red);
                    } else {
                        objItenLabor.setDataEntrada(jDataEntrada.getDate());
                        objItenLabor.setHorarioEntrada(jHorarioEntrada.getText());
                        objItenLabor.setDataSaida(jDataSaida.getDate());
                        objItenLabor.setHorarioSaida(jHorarioSaida.getText());
                        // Para o log do registro
                        objItenLabor.setUsuarioInsert(nameUser);
                        objItenLabor.setDataInsert(dataModFinal);
                        objItenLabor.setHoraInsert(horaMov);
                        if (acao == 3) {
                            objItenLabor.setIdLanc(Integer.valueOf(jIDlanc.getText()));
                            objItenLabor.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
                            objItenLabor.setNomeInterno(jNomeInterno.getText());
                            controle.incluirItensLaborInterno(objItenLabor);
                            //Inclusão do histórico do interno na empresa
                            objHistInterEmp.setNomeEmpresa(jNomeEmpresa.getText());
                            objHistInterEmp.setNomeInterno(jNomeInterno.getText());
                            objDatasHoras();
                            controlHist.incluirInterEmp(objHistInterEmp);
                            objLog2();
                            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                            preencherTabelaItens("SELECT * FROM ITENSLABORINTERNO "
                                    + "INNER JOIN PRONTUARIOSCRC "
                                    + "ON ITENSLABORINTERNO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                    + "WHERE Idlanc='" + jIDlanc.getText() + "'");
                            JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                            SalvarInterno();
                        }
                        if (acao == 4) {
                            objItenLabor.setUsuarioUp(nameUser);
                            objItenLabor.setDataUp(dataModFinal);
                            objItenLabor.setHoraUp(horaMov);
                            objItenLabor.setIdLanc(Integer.valueOf(jIDlanc.getText()));
                            objItenLabor.setIdItem(Integer.valueOf(idItem));
                            objItenLabor.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
                            objItenLabor.setNomeInterno(jNomeInterno.getText());
                            controle.alterarItensLaborInterno(objItenLabor);
                            //Alteração do histórico do interno na empresa
                            objHistInterEmp.setNomeEmpresa(jNomeEmpresa.getText());
                            objHistInterEmp.setNomeInterno(jNomeInterno.getText());
                            objDatasHoras();
                            controlHist.alterarInterEmp(objHistInterEmp);
                            objLog2();
                            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                            preencherTabelaItens("SELECT * FROM ITENSLABORINTERNO "
                                    + "INNER JOIN PRONTUARIOSCRC "
                                    + "ON ITENSLABORINTERNO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                    + "WHERE Idlanc='" + jIDlanc.getText() + "'");
                            JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                            SalvarInterno();
                        }
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtSalvarInternoActionPerformed

    private void jBtCancelarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarInternoActionPerformed
        // TODO add your handling code here:
        CancelarInterno();
    }//GEN-LAST:event_jBtCancelarInternoActionPerformed

    private void jBtSairVisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairVisitaActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairVisitaActionPerformed

    private void jBtBuscarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtBuscarInternoActionPerformed
        // TODO add your handling code here:
        TelaBuscarInternosLabor objBuscarInternos = new TelaBuscarInternosLabor();
        TelaModuloPortarias.jPainelPortarias.add(objBuscarInternos);
        objBuscarInternos.show();
    }//GEN-LAST:event_jBtBuscarInternoActionPerformed

    private void jTabelaLaborInternosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaLaborInternosMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String IdLanc = "" + jTabelaLaborInternos.getValueAt(jTabelaLaborInternos.getSelectedRow(), 0);
            jIDPesqLanc.setText(IdLanc);
            jDatalancamento.setDate(jDatalancamento.getDate());
            jBtNovo.setEnabled(!true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(true);
            //
            jBtNovoInterno.setEnabled(true);
            jBtBiometria.setEnabled(true);
            jBtBuscarInterno.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoriaManu.setEnabled(true);
            //
            bloquearCamposPesquisa();
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ENTRADALABORINTERNO "
                        + "INNER JOIN EMPRESALAB "
                        + "ON ENTRADALABORINTERNO.IdEmp=EMPRESALAB.IdEmp "
                        + "WHERE IdLanc='" + IdLanc + "'");
                conecta.rs.first();
                jIDlanc.setText(String.valueOf(conecta.rs.getInt("IdLanc")));
                jStatusEntCola.setText(conecta.rs.getString("Statuslanc"));
                jDatalancamento.setDate(conecta.rs.getDate("DataLanc"));
                jIDEmpresa.setText(conecta.rs.getString("IdEmp"));
                jNomeEmpresa.setText(conecta.rs.getString("RazaoSocial"));
                jObservacao.setText(conecta.rs.getString("ObsLanc"));
                conecta.desconecta();

            } catch (SQLException e) {
            }
            preencherTabelaItens("SELECT * FROM ITENSLABORINTERNO "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENSLABORINTERNO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE IdLanc='" + IdLanc + "'");
        }
    }//GEN-LAST:event_jTabelaLaborInternosMouseClicked

    private void jBtPesqNomeInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNomeInternoActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (jPesqInterno.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o nome ou parte do nome do interno para pesquisa.");
        } else {
            preencherTodasEntSai("SELECT * FROM ENTRADALABORINTERNO "
                    + "INNER JOIN ITENSLABORINTERNO "
                    + "ON ENTRADALABORINTERNO.IdLanc=ITENSLABORINTERNO.IdLanc "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENSLABORINTERNO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE NomeInternoCrc LIKE'" + jPesqInterno.getText() + "%'");
        }
    }//GEN-LAST:event_jBtPesqNomeInternoActionPerformed

    private void jBtPesqNomeEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNomeEmpresaActionPerformed
        // TODO add your handling code here:
        TelaBuscarEmpresaLaborPortaria objEmpLabPort = new TelaBuscarEmpresaLaborPortaria();
        TelaModuloPortarias.jPainelPortarias.add(objEmpLabPort);
        objEmpLabPort.show();
    }//GEN-LAST:event_jBtPesqNomeEmpresaActionPerformed

    private void jIDlancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jIDlancActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jIDlancActionPerformed

    private void jIDEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jIDEmpresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jIDEmpresaActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            //      this.preencherTodasEntSai("SELECT * FROM ENTRADALABORINTERNO INNER JOIN ITENSLABORINTERNO ON ENTRADALABORINTERNO.IdLanc=ITENSLABORINTERNO.IdLanc INNER JOIN PRONTUARIOSCRC ON ITENSLABORINTERNO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc");
            this.preencherTodasEntSai("SELECT * FROM ENTRADALABORINTERNO");
        } else {
            jtotalRegistros.setText("");
            limpaTabelaLaborativa();
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jBtAuditoriaManuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaManuActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaEntradaSaidaInternosP1 objAudEntSaiIntP1 = new TelaAuditoriaEntradaSaidaInternosP1();
        TelaModuloPortarias.jPainelPortarias.add(objAudEntSaiIntP1);
        objAudEntSaiIntP1.show();
    }//GEN-LAST:event_jBtAuditoriaManuActionPerformed

    private void jBtAudiInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAudiInternosActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaItensEntSaiIntP1 objAudItensEntSaiIntP1 = new TelaAuditoriaItensEntSaiIntP1();
        TelaModuloPortarias.jPainelPortarias.add(objAudItensEntSaiIntP1);
        objAudItensEntSaiIntP1.show();
    }//GEN-LAST:event_jBtAudiInternosActionPerformed

    private void jBtZoonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtZoonActionPerformed
        // TODO add your handling code here:
        mostrarFotoSaidaLaborativa();
    }//GEN-LAST:event_jBtZoonActionPerformed

    private void jBtDatasHorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtDatasHorasActionPerformed
        // TODO add your handling code here:
        mostrarDatgaHorasSaidas();
    }//GEN-LAST:event_jBtDatasHorasActionPerformed

    private void jBtBiometriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtBiometriaActionPerformed
        // TODO add your handling code here:       
        buscarAcessoUsuario(telaEntradaSaidaLABBio);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaSaidaLABBio) && codAbrirP1 == 1) {
            if (jStatusEntCola.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Não é possível utilizar essa funcionalidade, o registro já foi finalizado");
            } else {
                mostrarBiometriaSaidaInternos();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtBiometriaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtAlterar;
    public static javax.swing.JButton jBtAlterarInterno;
    private javax.swing.JButton jBtAudiInternos;
    private javax.swing.JButton jBtAuditoriaManu;
    private javax.swing.JButton jBtBiometria;
    public static javax.swing.JButton jBtBuscarInterno;
    private javax.swing.JButton jBtCancelar;
    public static javax.swing.JButton jBtCancelarInterno;
    private javax.swing.JButton jBtDatasHoras;
    private javax.swing.JButton jBtExcluir;
    public static javax.swing.JButton jBtExcluirInterno;
    private javax.swing.JButton jBtFinalizar;
    private javax.swing.JButton jBtImpressao;
    private javax.swing.JButton jBtNovo;
    public static javax.swing.JButton jBtNovoInterno;
    private javax.swing.JButton jBtPesqData;
    private javax.swing.JButton jBtPesqID;
    private javax.swing.JButton jBtPesqInterno;
    private javax.swing.JButton jBtPesqNomeEmpresa;
    private javax.swing.JButton jBtPesqNomeInterno;
    private javax.swing.JButton jBtSairVisita;
    private javax.swing.JButton jBtSalvar;
    public static javax.swing.JButton jBtSalvarInterno;
    public static javax.swing.JButton jBtZoon;
    private javax.swing.JCheckBox jCheckBox1;
    public static javax.swing.JComboBox<String> jComboBoxTornozeleira;
    public static com.toedter.calendar.JDateChooser jDataEntrada;
    private com.toedter.calendar.JDateChooser jDataPesqFinal;
    private com.toedter.calendar.JDateChooser jDataPesqInicial;
    public static com.toedter.calendar.JDateChooser jDataSaida;
    private com.toedter.calendar.JDateChooser jDatalancamento;
    public static javax.swing.JLabel jFotoInternoLabor;
    public static javax.swing.JFormattedTextField jHorarioEntrada;
    public static javax.swing.JFormattedTextField jHorarioSaida;
    public static javax.swing.JTextField jIDEmpresa;
    private javax.swing.JTextField jIDPesqLanc;
    public static javax.swing.JTextField jIDlanc;
    public static javax.swing.JTextField jIdInterno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelEvadido;
    public static javax.swing.JTextField jNomeEmpresa;
    public static javax.swing.JTextField jNomeInterno;
    private javax.swing.JTextArea jObservacao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jPesqInterno;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jStatusEntCola;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    public static javax.swing.JTable jTabelaInternos;
    private javax.swing.JTable jTabelaLaborInternos;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void objDatasHoras() {
        objHistInterEmp.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
        objHistInterEmp.setDataEntrada(jDataEntrada.getDate());
        objHistInterEmp.setHorarioEntrada(jHorarioEntrada.getText());
        objHistInterEmp.setDataSaida(jDataSaida.getDate());
        objHistInterEmp.setHorarioSaida(jHorarioSaida.getText());
    }

    public void formatarCampo() {
        jObservacao.setLineWrap(true);
        jObservacao.setWrapStyleWord(true);
        jPesqInterno.setDocument(new LimiteDigitos(50));
        try {
            MaskFormatter horarioEntrada = new MaskFormatter("##:##");
            jHorarioEntrada.setFormatterFactory(new DefaultFormatterFactory(horarioEntrada));
            MaskFormatter horarioSaida = new MaskFormatter("##:##");
            jHorarioSaida.setFormatterFactory(new DefaultFormatterFactory(horarioSaida));
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível formatar os campos de hora.");
        }
    }

    public void bloquearCamposPesquisa() {
        jDatalancamento.setEnabled(!true);
        jIDEmpresa.setEnabled(!true);
        jNomeEmpresa.setEnabled(!true);
        jBtPesqNomeEmpresa.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jIdInterno.setText("");
        jNomeInterno.setText("");
        jFotoInternoLabor.setIcon(null);
        jDataEntrada.setDate(null);
        jHorarioEntrada.setText("00:00");
        jDataSaida.setDate(null);
        jHorarioSaida.setText("00:00");
        //
        jIdInterno.setEnabled(!true);
        jNomeInterno.setEnabled(!true);
        jDataEntrada.setEnabled(!true);
        jHorarioEntrada.setEnabled(!true);
        jDataSaida.setEnabled(!true);
        jHorarioSaida.setEnabled(!true);
        jBtPesqInterno.setEnabled(!true);
        //
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAudiInternos.setEnabled(!true);
    }

    public void corCampo() {
        jIDlanc.setBackground(Color.white);
        jStatusEntCola.setBackground(Color.white);
        jDatalancamento.setBackground(Color.white);
        jObservacao.setBackground(Color.white);
        jIDEmpresa.setBackground(Color.white);
        jNomeEmpresa.setBackground(Color.white);
        jIdInterno.setBackground(Color.white);
        jNomeInterno.setBackground(Color.white);
        jDataEntrada.setBackground(Color.white);
        jHorarioEntrada.setBackground(Color.white);
        jDataSaida.setBackground(Color.white);
        jHorarioSaida.setBackground(Color.white);
    }

    public void verificarAcessoBiometriaInterno() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENSLABORINTERNO "
                    + "WHERE IdInternoCrc='" + jIdInterno.getText() + "' "
                    + "AND IdLanc='" + jIDlanc.getText() + "'");
            conecta.rs.first();
            codigoInternoBio = conecta.rs.getString("IdInternoCrc");
            pAssinaturaDigital = conecta.rs.getBytes("AssinaturaSaida");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void Novo() {
        if (jIDlanc.getText().equals("")) {
            jIDlanc.setText("");
            jStatusEntCola.setText("");
            jDatalancamento.setDate(null);
            jIDEmpresa.setText("");
            jNomeEmpresa.setText("");
            jIdInterno.setText("");
            jFotoInternoLabor.setIcon(null);
            jNomeInterno.setText("");
            jDataEntrada.setDate(null);
            jHorarioEntrada.setText("00:00");
            jDataSaida.setDate(null);
            jHorarioSaida.setText("00:00");
            limparTabelaItens();
            //
            jBtAuditoriaManu.setEnabled(!true);
            jBtAudiInternos.setEnabled(!true);
            jBtImpressao.setEnabled(!true);
        }
        // Limpar campos para insersão
        jIDlanc.setText("");
        jStatusEntCola.setText("ABERTO");
        jDatalancamento.setCalendar(Calendar.getInstance());
        jObservacao.setText("");
        jIdInterno.setText("");
        jNomeInterno.setText("");
        jFotoInternoLabor.setIcon(null);
        jIDEmpresa.setText("");
        jNomeEmpresa.setText("");
        jDataEntrada.setDate(null);
        jHorarioEntrada.setText("00:00");
        jDataSaida.setDate(null);
        jHorarioSaida.setText("00:00");
        //
        jDatalancamento.setEnabled(true);
        jBtPesqNomeEmpresa.setEnabled(true);
        jObservacao.setEnabled(true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(!true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtBuscarInterno.setEnabled(!true);
        jBtAudiInternos.setEnabled(!true);
        jBtBiometria.setEnabled(!true);
        //
        //jTabelaInternos.setEnabled(!true);
        jBtPesqInterno.setEnabled(!true);
        jDataEntrada.setEnabled(!true);
        jHorarioEntrada.setEnabled(!true);
        jDataSaida.setEnabled(!true);
        jHorarioSaida.setEnabled(!true);
        limparTabelaItens();
    }

    public void Alterar() {
        //
        jDatalancamento.setEnabled(true);
        jBtPesqNomeEmpresa.setEnabled(true);
        jObservacao.setEnabled(true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(!true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtBuscarInterno.setEnabled(!true);
        //
        //jTabelaInternos.setEnabled(!true);
        jBtPesqInterno.setEnabled(!true);
        jDataEntrada.setEnabled(!true);
        jHorarioEntrada.setEnabled(!true);
        jDataSaida.setEnabled(!true);
        jHorarioSaida.setEnabled(!true);
        //
        jBtAudiInternos.setEnabled(!true);
        jBtAuditoriaManu.setEnabled(!true);
        jBtImpressao.setEnabled(!true);
        jBtBiometria.setEnabled(!true);
    }

    public void Excluir() {
        jIDlanc.setText("");
        jStatusEntCola.setText("");
        jDatalancamento.setDate(null);
        jIDEmpresa.setText("");
        jNomeEmpresa.setText("");
        jObservacao.setText("");
        //
        jIdInterno.setText("");
        jFotoInternoLabor.setIcon(null);
        jNomeInterno.setText("");
        jDataEntrada.setDate(null);
        jHorarioEntrada.setText("00:00");
        jDataSaida.setDate(null);
        jHorarioSaida.setText("00:00");
        //
        jDatalancamento.setEnabled(!true);
        jBtPesqNomeEmpresa.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(!true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtBuscarInterno.setEnabled(!true);
        jBtBiometria.setEnabled(!true);
        //
        //jTabelaInternos.setEnabled(!true);
        jBtPesqInterno.setEnabled(!true);
        jDataEntrada.setEnabled(!true);
        jHorarioEntrada.setEnabled(!true);
        jDataSaida.setEnabled(!true);
        jHorarioSaida.setEnabled(!true);
    }

    public void Salvar() {
        //
        jDatalancamento.setEnabled(!true);
        jBtPesqNomeEmpresa.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        //
        jBtNovoInterno.setEnabled(true);
        jBtBiometria.setEnabled(true);
    }

    public void Cancelar() {
        jDatalancamento.setEnabled(!true);
        jBtPesqNomeEmpresa.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        //
        if (jIDlanc.getText().equals("")) {
            jIDlanc.setText("");
            jStatusEntCola.setText("");
            jDatalancamento.setDate(null);
            jIDEmpresa.setText("");
            jFotoInternoLabor.setIcon(null);
            jNomeEmpresa.setText("");
            jIdInterno.setText("");
            jNomeInterno.setText("");
            jDataEntrada.setDate(null);
            jHorarioEntrada.setText("00:00");
            jDataSaida.setDate(null);
            jHorarioSaida.setText("00:00");
            limparTabelaItens();
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
            objEntSaiLabor.setStatusLanc(statusLanc);
            objEntSaiLabor.setIdLanc(Integer.parseInt(jIDlanc.getText()));
            control.finalizarEntSaiLabor(objEntSaiLabor);
            // GRAVAR NA TABELA DE ITENS_FREQUENCIA_LABORATIVA_EXTERNA
            gravarRegistroLaborativo();
            jStatusEntCola.setText("FINALIZADO");
            objLog();
            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
            JOptionPane.showMessageDialog(rootPane, "Registro FINALIZADO com sucesso !!!");
            //
            jBtPesqInterno.setEnabled(!true);
            jDatalancamento.setEnabled(!true);
            jDataEntrada.setEnabled(!true);
            jHorarioEntrada.setEnabled(!true);
            jDataSaida.setEnabled(!true);
            jHorarioSaida.setEnabled(!true);
            jBtPesqNomeEmpresa.setEnabled(!true);
            jObservacao.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
            //
            jBtNovoInterno.setEnabled(!true);
            jBtAlterarInterno.setEnabled(!true);
            jBtExcluirInterno.setEnabled(!true);
            jBtSalvarInterno.setEnabled(!true);
            jBtCancelarInterno.setEnabled(!true);
            jBtBiometria.setEnabled(!true);
        }
    }

    public void verificarHoraEntrada() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENSLABORINTERNO "
                    + "WHERE HorarioSaida='" + verHorarioSaida + "' "
                    + "AND Idlanc='" + jIDlanc.getText() + "' "
                    + "OR HorarioEntrada='" + verHorarioEntrada + "' "
                    + "AND Idlanc='" + jIDlanc.getText() + "'");
            conecta.rs.first();
            horaEntradaEncontrada = conecta.rs.getString("HorarioEntrada");
            horaSaidaEncontrado = conecta.rs.getString("HorarioSaida");
            codigoRegistro = conecta.rs.getString("Idlanc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void NovoInterno() {
        jDatalancamento.setEnabled(!true);
        jIDEmpresa.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        //
        jIdInterno.setText("");
        jNomeInterno.setText("");
        jFotoInternoLabor.setIcon(null);
        jDataEntrada.setCalendar(Calendar.getInstance());
        jHorarioEntrada.setText("00:00");
        jDataSaida.setCalendar(Calendar.getInstance());
        jHorarioSaida.setText("00:00");
        jComboBoxTornozeleira.setSelectedItem("Selecione...");
        //
        jBtPesqInterno.setEnabled(true);
        jDataEntrada.setEnabled(true);
        jHorarioEntrada.setEnabled(true);
        jDataSaida.setEnabled(true);
        jHorarioSaida.setEnabled(true);
        jBtDatasHoras.setEnabled(true);
        //
        jBtNovoInterno.setEnabled(!true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(true);
        jBtCancelarInterno.setEnabled(true);
        jBtBuscarInterno.setEnabled(!true);
        jBtAudiInternos.setEnabled(!true);
        jBtAuditoriaManu.setEnabled(!true);
        jBtImpressao.setEnabled(!true);
        jBtBiometria.setEnabled(!true);
    }

    public void AlterarInterno() {
        jDatalancamento.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        //
        jBtPesqInterno.setEnabled(true);
        jDataEntrada.setEnabled(true);
        jHorarioEntrada.setEnabled(true);
        jDataSaida.setEnabled(true);
        jHorarioSaida.setEnabled(true);
        //
        jBtNovoInterno.setEnabled(!true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(true);
        jBtCancelarInterno.setEnabled(true);
        jBtBuscarInterno.setEnabled(!true);
        jBtAudiInternos.setEnabled(!true);
        jBtAuditoriaManu.setEnabled(!true);
        jBtImpressao.setEnabled(!true);
        jBtBiometria.setEnabled(!true);
    }

    public void AlterarInternoBiometria() {
        jDatalancamento.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        //
        //  jBtPesqInterno.setEnabled(true);
        jDataEntrada.setEnabled(true);
        jHorarioEntrada.setEnabled(true);
        // jDataSaida.setEnabled(true);
        // jHorarioSaida.setEnabled(true);
        //
        jBtNovoInterno.setEnabled(!true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(true);
        jBtCancelarInterno.setEnabled(true);
        jBtBuscarInterno.setEnabled(!true);
        jBtAudiInternos.setEnabled(!true);
        jBtAuditoriaManu.setEnabled(!true);
        jBtImpressao.setEnabled(!true);
        jBtBiometria.setEnabled(!true);
    }

    public void ExcluirInterno() {
        //
        jIdInterno.setText("");
        jNomeInterno.setText("");
        jFotoInternoLabor.setIcon(null);
        jDataEntrada.setDate(null);
        jHorarioEntrada.setText("00:00");
        jDataSaida.setDate(null);
        jHorarioSaida.setText("00:00");
        jComboBoxTornozeleira.setSelectedItem("Selecione...");
        //
        jBtPesqInterno.setEnabled(!true);
        jDataEntrada.setEnabled(!true);
        jHorarioEntrada.setEnabled(!true);
        jDataSaida.setEnabled(!true);
        jHorarioSaida.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtBuscarInterno.setEnabled(!true);
        jBtAudiInternos.setEnabled(!true);
        jBtAuditoriaManu.setEnabled(!true);
        jBtImpressao.setEnabled(!true);
        jBtBiometria.setEnabled(true);
    }

    public void SalvarInterno() {
        //
        jIdInterno.setText("");
        jNomeInterno.setText("");
        jFotoInternoLabor.setIcon(null);
        jDataEntrada.setDate(null);
        jHorarioEntrada.setText("00:00");
        jDataSaida.setDate(null);
        jHorarioSaida.setText("00:00");
        jComboBoxTornozeleira.setSelectedItem("Selecione...");
        //
        jBtPesqInterno.setEnabled(!true);
        jDataEntrada.setEnabled(!true);
        jHorarioEntrada.setEnabled(!true);
        jDataSaida.setEnabled(!true);
        jHorarioSaida.setEnabled(!true);
        jBtDatasHoras.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtBuscarInterno.setEnabled(true);
        jBtBiometria.setEnabled(true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
    }

    public void CancelarInterno() {
        //
        jBtPesqInterno.setEnabled(!true);
        jDataEntrada.setEnabled(!true);
        jHorarioEntrada.setEnabled(!true);
        jDataSaida.setEnabled(!true);
        jHorarioSaida.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtDatasHoras.setEnabled(!true);
        jBtBiometria.setEnabled(true);
        //
        if (!jIDlanc.getText().equals("")) {
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtCancelar.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            //
            jBtBuscarInterno.setEnabled(true);
            jBtAudiInternos.setEnabled(true);
            jBtAuditoriaManu.setEnabled(true);
            jBtImpressao.setEnabled(true);
            jBtBiometria.setEnabled(true);
        }
    }

    public void buscarID() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ENTRADALABORINTERNO");
            conecta.rs.last();
            jIDlanc.setText(conecta.rs.getString("IdLanc"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter o ID do lancamento.\nERRO: " + ex);
        }
    }

    public void verificarItens() {

        statusMov = "Excluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENSLABORINTERNO WHERE IdLanc='" + jIDlanc.getText() + "'");
            conecta.rs.first();
            codlanc = conecta.rs.getString("IdLanc");
            if (jIDlanc.getText().equals(codlanc)) {
                JOptionPane.showMessageDialog(rootPane, "Antes de excluir esse Lançamento, será necessário\nexcluir primeiro os internos relacionados a esse registro.");
            }
            conecta.desconecta();
        } catch (SQLException ex) {
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o LANÇAMENTO selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objEntSaiLabor.setIdLanc(Integer.parseInt(jIDlanc.getText()));
                control.excluirEntSaiLabor(objEntSaiLabor);
                objLog();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                Excluir();
            }
        }
    }

    public void preencherTabelaItens(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome do Interno", "Data Saída", "Horário", "Data Entrada", "Horário"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1;
                // Formatar a data Entrada
                dataEntrada = conecta.rs.getString("DataEntrada");
                if (dataEntrada != null) {
                    String dia = dataEntrada.substring(8, 10);
                    String mes = dataEntrada.substring(5, 7);
                    String ano = dataEntrada.substring(0, 4);
                    dataEntrada = dia + "/" + mes + "/" + ano;
                }
                // Formatar a data Saida 
                dataSaida = conecta.rs.getString("DataSaida");
                if (dataSaida != null) {
                    String dias = dataSaida.substring(8, 10);
                    String mess = dataSaida.substring(5, 7);
                    String anos = dataSaida.substring(0, 4);
                    dataSaida = dias + "/" + mess + "/" + anos;
                }
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdInternoCrc"), conecta.rs.getString("NomeInternoCrc"), dataSaida, conecta.rs.getString("HorarioSaida"), dataEntrada, conecta.rs.getString("HorarioEntrada")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInternos.setModel(modelo);
        jTabelaInternos.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaInternos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTabelaInternos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaInternos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(3).setPreferredWidth(70);
        jTabelaInternos.getColumnModel().getColumn(3).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTabelaInternos.getColumnModel().getColumn(4).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(5).setPreferredWidth(70);
        jTabelaInternos.getColumnModel().getColumn(5).setResizable(false);
        jTabelaInternos.getTableHeader().setReorderingAllowed(false);
        jTabelaInternos.setAutoResizeMode(jTabelaInternos.AUTO_RESIZE_OFF);
        jTabelaInternos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaInternos();
        conecta.desconecta();
    }

    public void limparTabelaItens() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome do Interno", "Data Saída", "Horário", "Data Entrada", "Horário"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInternos.setModel(modelo);
        jTabelaInternos.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaInternos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTabelaInternos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaInternos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(3).setPreferredWidth(70);
        jTabelaInternos.getColumnModel().getColumn(3).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTabelaInternos.getColumnModel().getColumn(4).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(5).setPreferredWidth(70);
        jTabelaInternos.getColumnModel().getColumn(5).setResizable(false);
        jTabelaInternos.getTableHeader().setReorderingAllowed(false);
        jTabelaInternos.setAutoResizeMode(jTabelaInternos.AUTO_RESIZE_OFF);
        jTabelaInternos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void preencherTodasEntSai(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Observação"};
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
                dados.add(new Object[]{conecta.rs.getInt("IdLanc"), dataEntrada, conecta.rs.getString("StatusLanc"), conecta.rs.getString("ObsLanc")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaLaborInternos.setModel(modelo);
        jTabelaLaborInternos.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaLaborInternos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaLaborInternos.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaLaborInternos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaLaborInternos.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaLaborInternos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaLaborInternos.getColumnModel().getColumn(3).setPreferredWidth(530);
        jTabelaLaborInternos.getColumnModel().getColumn(3).setResizable(false);
        jTabelaLaborInternos.getTableHeader().setReorderingAllowed(false);
        jTabelaLaborInternos.setAutoResizeMode(jTabelaLaborInternos.AUTO_RESIZE_OFF);
        jTabelaLaborInternos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaIntLab();
        conecta.desconecta();
    }

    public void alinharCamposTabelaIntLab() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaLaborInternos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaLaborInternos.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaLaborInternos.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }

    public void alinharCamposTabelaInternos() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaInternos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaInternos.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        jTabelaInternos.getColumnModel().getColumn(3).setCellRenderer(centralizado);
        jTabelaInternos.getColumnModel().getColumn(4).setCellRenderer(centralizado);
        jTabelaInternos.getColumnModel().getColumn(5).setCellRenderer(centralizado);
    }

    public void limpaTabelaLaborativa() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Observação"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaLaborInternos.setModel(modelo);
        jTabelaLaborInternos.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaLaborInternos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaLaborInternos.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaLaborInternos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaLaborInternos.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaLaborInternos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaLaborInternos.getColumnModel().getColumn(3).setPreferredWidth(530);
        jTabelaLaborInternos.getColumnModel().getColumn(3).setResizable(false);
        jTabelaLaborInternos.getTableHeader().setReorderingAllowed(false);
        jTabelaLaborInternos.setAutoResizeMode(jTabelaLaborInternos.AUTO_RESIZE_OFF);
        jTabelaLaborInternos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void preencherTodasEntSaiNome(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome do Interno", "Data Saída", "Horário", "Data Entrada", "Horário"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1;
                // Formatar a data Entrada
                dataEntrada = conecta.rs.getString("DataEntrada");
                String dia = dataEntrada.substring(8, 10);
                String mes = dataEntrada.substring(5, 7);
                String ano = dataEntrada.substring(0, 4);
                dataEntrada = dia + "/" + mes + "/" + ano;
                // Formatar a data Entrada
                dataSaida = conecta.rs.getString("DataSaida");
                String diae = dataSaida.substring(8, 10);
                String mese = dataSaida.substring(5, 7);
                String anoe = dataSaida.substring(0, 4);
                dataSaida = diae + "/" + mese + "/" + anoe;
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdLanc"), conecta.rs.getString("NomeInternoCrc"), dataSaida, conecta.rs.getString("HorarioSaida"), dataEntrada, conecta.rs.getString("HorarioEntrada")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaLaborInternos.setModel(modelo);
        jTabelaLaborInternos.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaLaborInternos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaLaborInternos.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTabelaLaborInternos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaLaborInternos.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaLaborInternos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaLaborInternos.getColumnModel().getColumn(3).setPreferredWidth(70);
        jTabelaLaborInternos.getColumnModel().getColumn(3).setResizable(false);
        jTabelaLaborInternos.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTabelaLaborInternos.getColumnModel().getColumn(4).setResizable(false);
        jTabelaLaborInternos.getColumnModel().getColumn(5).setPreferredWidth(70);
        jTabelaLaborInternos.getColumnModel().getColumn(5).setResizable(false);
        jTabelaLaborInternos.getTableHeader().setReorderingAllowed(false);
        jTabelaLaborInternos.setAutoResizeMode(jTabelaLaborInternos.AUTO_RESIZE_OFF);
        jTabelaLaborInternos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaLaborInt();
        conecta.desconecta();
    }

    public void alinharCamposTabelaLaborInt() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaLaborInternos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaLaborInternos.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaLaborInternos.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }

    // GRAVAR AS FREQUENCIAS DOS INTERNOS NO MOMENTO QUE FOR FINALIZADO O DOCUMENTO NA TABELA ITENS_FREQUENCIA_LABORATIVA_EXTERNA
    public void gravarRegistroLaborativo() {
        Integer rows = jTabelaInternos.getModel().getRowCount();
        if (rows == 0) {
            JOptionPane.showMessageDialog(rootPane, "Não existe registro na tabela a ser lançado.");
        } else {
            for (int i = 0; i < jTabelaInternos.getRowCount(); i++) {
                objItenLabor.setIdInternoCrc((int) jTabelaInternos.getValueAt(i, 0));
                pegarDataRegistro();
                pegarDadosInterno();
                qtdDiastotal = qtdDias + vQuant;
                if (codigoInterno.equals(codigoInternoCrc) && mesReferencia.equals(mesAtual) && statusFreqLab.equals(statusFreq)) {
                    objItenLabor.setIdInternoCrc((int) jTabelaInternos.getValueAt(i, 0));
                    objItenLabor.setQtdInt(qtdDiastotal);
                    objItenLabor.setMesReferencia(mesReferencia);
                    // GRAVA NA TABELA DE ITENS_FREQUENCIA_LABORATIVA_EXERNA
                    controle.alterarQuantidadeFrequencia(objItenLabor);
                }
            }
        }
    }

    // PEGAR O MES DA DATA NA TABELA ITENSLABORINTERNO PARA GRAVAR NA TABELA DE ITENS_FREQUENCIA_LABORATIVA_EXTERNA (10/03/2016)
    public void pegarDataRegistro() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENSLABORINTERNO "
                    + "WHERE Idlanc='" + jIDlanc.getText() + "'AND IdInternoCrc='" + objItenLabor.getIdInternoCrc() + "'");
            conecta.rs.first();
            codigoInterno = conecta.rs.getString("IdInternoCrc");
            dataEntrada = conecta.rs.getString("DataEntrada");
            String dia = dataEntrada.substring(8, 10);
            String mes = dataEntrada.substring(5, 7);
            String ano = dataEntrada.substring(0, 4);
            dataEntrada = dia + "/" + mes + "/" + ano;
            java.util.Date dt = df.parse(dataEntrada);
            DateFormat df2 = new SimpleDateFormat("MMMMM", new Locale("pt", "BR"));
            mesAtual = df2.format(dt);
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    // TABELA DE FREQUENCIA_LABORATIVA_EXTERNA E ITENS_FREQUENCIA_LABORATIVA_EXTERNA
    public void pegarDadosInterno() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM FREQUENCIA_LABORATIVA_EXTERNA "
                    + "INNER JOIN ITENS_FREQUENCIA_LABORATIVA_EXTERNA "
                    + "ON FREQUENCIA_LABORATIVA_EXTERNA.IdFreqLab=ITENS_FREQUENCIA_LABORATIVA_EXTERNA.IdFreqLab "
                    + "WHERE ITENS_FREQUENCIA_LABORATIVA_EXTERNA.IdInternoCrc='" + objItenLabor.getIdInternoCrc() + "'AND StatusFreqlab='" + statusFreq + "'");
            conecta.rs.first();
            statusFreqLab = conecta.rs.getString("StatusFreqLab");
            mesReferencia = conecta.rs.getString("MesReferencia");
            anoReferencia = conecta.rs.getString("AnoReferencia");
            codigoInternoCrc = conecta.rs.getString("IdInternoCrc");
            qtdDias = conecta.rs.getInt("TotalDias");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jIDlanc.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog2() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela2);
        objLogSys.setIdLancMov(Integer.valueOf(jIDlanc.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void buscarAcessoUsuario(String nomeTelaAcesso) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nameUser + "'");
            conecta.rs.first();
            codigoUserP1 = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUserP1 + "'");
            conecta.rs.first();
            codigoUserGroupP1 = conecta.rs.getInt("IdUsuario");
            codigoGrupoP1 = conecta.rs.getInt("IdGrupo");
            nomeGrupoP1 = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUserP1 + "' "
                    + "AND NomeTela='" + nomeTelaAcesso + "'");
            conecta.rs.first();
            codUserAcessoP1 = conecta.rs.getInt("IdUsuario");
            codAbrirP1 = conecta.rs.getInt("Abrir");
            codIncluirP1 = conecta.rs.getInt("Incluir");
            codAlterarP1 = conecta.rs.getInt("Alterar");
            codExcluirP1 = conecta.rs.getInt("Excluir");
            codGravarP1 = conecta.rs.getInt("Gravar");
            codConsultarP1 = conecta.rs.getInt("Consultar");
            nomeTelaP1 = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
