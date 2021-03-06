/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleConfirmacaoAtendimento;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControleRegistroAtendimentoInternoBio;
import gestor.Dao.ConexaoBancoDados;
import Utilitarios.ModeloTabela;
import gestor.Modelo.LogSistema;
import gestor.Modelo.ProntuarioCrc;
import gestor.Modelo.RegistroAtendimentoInternos;
import static gestor.Visao.TelaBiometriaEntradaSaidaPortaria.caminhoFotoInterno;
import static gestor.Visao.TelaLoginSenha.descricaoUnidade;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloEducacaoFisica.codigoUserGroupEF;
import static gestor.Visao.TelaModuloEducacaoFisica.codConsultarEF;
import static gestor.Visao.TelaModuloEducacaoFisica.codAlterarEF;
import static gestor.Visao.TelaModuloEducacaoFisica.codExcluirEF;
import static gestor.Visao.TelaModuloEducacaoFisica.codGravarEF;
import static gestor.Visao.TelaModuloEducacaoFisica.codigoGrupoEF;
import static gestor.Visao.TelaModuloEducacaoFisica.nomeGrupoEF;
import static gestor.Visao.TelaModuloEducacaoFisica.nomeTelaEF;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
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
import static gestor.Visao.TelaModuloEducacaoFisica.codigoUserEF;
import static gestor.Visao.TelaModuloEducacaoFisica.codUserAcessoEF;
import static gestor.Visao.TelaModuloEducacaoFisica.codAbrirEF;
import static gestor.Visao.TelaModuloEducacaoFisica.codIncluirEF;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import static gestor.Visao.TelaModuloEducacaoFisica.nomeModuloEF;
import static gestor.Visao.TelaModuloEducacaoFisica.telaRegistroAtendimentoImpBio_EF;
import static gestor.Visao.TelaModuloEducacaoFisica.telaRegistroAtendimentoColLiberador_EF;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ronal
 */
public class TelaRegistroInternosAtendimentoImpresso_EF extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ProntuarioCrc objProCrc = new ProntuarioCrc();
    RegistroAtendimentoInternos objRegAtend = new RegistroAtendimentoInternos();
    ControleRegistroAtendimentoInternoBio control = new ControleRegistroAtendimentoInternoBio();
    //
    ControleConfirmacaoAtendimento control_ATENE_TV = new ControleConfirmacaoAtendimento();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela = "EDUCAÇÃO FÍSICA:Registro de Atendimento de Internos:Impressão";
    String statusMov;
    String horaMov;
    String dataModFinal;
    //
    String dataInicial = "";
    String dataFinal = "";
    // VARIVAEL PARA ARMAZENAR AS DIGITAIS DO BANCO DE DADOS
    String caminhoBiometria = "";
    String caminhoBiometria1 = "";
    String caminhoBiometria2 = "";
    String caminhoBiometria3 = "";
    // PARA GRAVAR NO BANCO DE DADOS
    public static byte[] pDigitalCapturadaColaborador = null;
    String dataReg = "";
    String codigoInterno = "";
    int acao = 0;
    int flag;
    int count = 0;
    String codInternoCela = "";
    String codigoRegAtend = "";
    String atendido = "";
    String idRegistro = "";
    String DataRegistro = "";
    int codigoDepto = 0;
    //
    String pImpressao = "Sim";
    public static String pLiberacaoImpressa = "Não";
    public static int codigoLiberador = 0;
    public static String nomeLiberador = "";
    public static String dataAssinatura = "";
    public static String horaAssinatura = "";

    int qtdAtend = 1;
    //
    String pATENDENDO = "Sim";
    String pCONCLUIDO = "Não";
    String pSTATUS_ATENDIMENTO = "Em Atendimento";
    int pSTATUS_USUARIO = 1;

    /**
     * Creates new form TelaRegistroInternosAtendimento
     */
    public static TelaAssinaturaoBiometriaColaboradoresPSP_EF assinaLibera;

    public TelaRegistroInternosAtendimentoImpresso_EF() {
        initComponents();
        corCampos();
        formatarCampos();
        pesquisarModulo();
    }

    public void mostraLiberador() {
        assinaLibera = new TelaAssinaturaoBiometriaColaboradoresPSP_EF(this, true);
        assinaLibera.setVisible(true);
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
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaRegistroInterno = new javax.swing.JTable();
        jPanel32 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jPesqNomeInternoOdonto = new javax.swing.JTextField();
        jBtPesqNomeInterno = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        jIDPesqAtend = new javax.swing.JTextField();
        jBtIdPesqAtend = new javax.swing.JButton();
        jLabel48 = new javax.swing.JLabel();
        jDataInicial = new com.toedter.calendar.JDateChooser();
        jLabel49 = new javax.swing.JLabel();
        jDataFinal = new com.toedter.calendar.JDateChooser();
        jBtPesqData = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jIdInternoKitImp = new javax.swing.JTextField();
        jNomeInternoKitImp = new javax.swing.JTextField();
        jPavilhaoKitImp = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jCNC = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jRegimeKitImp = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jCelaKitBio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jDataRegistro = new com.toedter.calendar.JDateChooser();
        jHorarioSaidaEntrada = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxTipoMovimentacao = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jIdRegistro = new javax.swing.JTextField();
        jNomeDepartamento = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jMotivo = new javax.swing.JTextArea();
        jComboBoxAtendente = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jBtSalvar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jBtCancelar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jFotoInternoKitImp = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jBtPesquisaInterno = new javax.swing.JButton();
        jBtImprimirAutorização = new javax.swing.JButton();
        jBtNovo = new javax.swing.JButton();
        jBtLiberarAutorizacao = new javax.swing.JButton();
        jBtAuditoria = new javax.swing.JButton();
        jBtLiberador = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Registro de Atendimento de Internos - IMPRESSÃO :::...");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/gtklp-icone-3770-16.png"))); // NOI18N

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jTabelaRegistroInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaRegistroInterno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data", "Horário", "Nome do Interno"
            }
        ));
        jTabelaRegistroInterno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaRegistroInternoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaRegistroInterno);
        if (jTabelaRegistroInterno.getColumnModel().getColumnCount() > 0) {
            jTabelaRegistroInterno.getColumnModel().getColumn(0).setMinWidth(60);
            jTabelaRegistroInterno.getColumnModel().getColumn(0).setMaxWidth(60);
            jTabelaRegistroInterno.getColumnModel().getColumn(1).setMinWidth(80);
            jTabelaRegistroInterno.getColumnModel().getColumn(1).setMaxWidth(80);
            jTabelaRegistroInterno.getColumnModel().getColumn(2).setMinWidth(70);
            jTabelaRegistroInterno.getColumnModel().getColumn(2).setMaxWidth(70);
            jTabelaRegistroInterno.getColumnModel().getColumn(3).setMinWidth(250);
            jTabelaRegistroInterno.getColumnModel().getColumn(3).setMaxWidth(250);
        }

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
            .addGap(0, 258, Short.MAX_VALUE)
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel36.setText("Nome :");

        jPesqNomeInternoOdonto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqNomeInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqNomeInterno.setContentAreaFilled(false);
        jBtPesqNomeInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqNomeInternoActionPerformed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel37.setText("Código:");

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

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel48, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jIDPesqAtend, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtIdPesqAtend, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(204, 204, 204)
                        .addComponent(jCheckBox1))
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel15Layout.createSequentialGroup()
                            .addComponent(jDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel49)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jBtPesqData, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel15Layout.createSequentialGroup()
                            .addComponent(jPesqNomeInternoOdonto, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jBtPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jCheckBox1)
                    .addComponent(jBtIdPesqAtend)
                    .addComponent(jIDPesqAtend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel48)
                    .addComponent(jDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49)
                    .addComponent(jDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel36)
                    .addComponent(jPesqNomeInternoOdonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqNomeInterno))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 442, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("Listagem", jPanel3);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Nome Completo do Interno");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Pavilhão");

        jIdInternoKitImp.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdInternoKitImp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdInternoKitImp.setEnabled(false);

        jNomeInternoKitImp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoKitImp.setEnabled(false);

        jPavilhaoKitImp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPavilhaoKitImp.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("CNC");

        jCNC.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCNC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCNC.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Regime");

        jRegimeKitImp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jRegimeKitImp.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Cela");

        jCelaKitBio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCelaKitBio.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Data Mov.");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Horário");

        jDataRegistro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataRegistro.setEnabled(false);

        jHorarioSaidaEntrada.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHorarioSaidaEntrada.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jHorarioSaidaEntrada.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 0, 0));
        jLabel9.setText("Tipo de Atendimento");

        jComboBoxTipoMovimentacao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTipoMovimentacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Admissão Educação Física", "Evolução Educação Física", " " }));
        jComboBoxTipoMovimentacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTipoMovimentacao.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Departamento");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Código");

        jIdRegistro.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdRegistro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdRegistro.setEnabled(false);

        jNomeDepartamento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jNomeDepartamento.setForeground(new java.awt.Color(204, 0, 0));
        jNomeDepartamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeDepartamento.setDisabledTextColor(new java.awt.Color(204, 0, 0));
        jNomeDepartamento.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Motivo");

        jMotivo.setColumns(20);
        jMotivo.setRows(5);
        jMotivo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMotivo.setEnabled(false);
        jScrollPane2.setViewportView(jMotivo);

        jComboBoxAtendente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxAtendente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione..." }));
        jComboBoxAtendente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxAtendente.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 51, 204));
        jLabel14.setText("Atendente");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jNomeInternoKitImp, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jIdRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDataRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jComboBoxTipoMovimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jHorarioSaidaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)))
                            .addComponent(jCelaKitBio, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPavilhaoKitImp, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jIdInternoKitImp, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCNC, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jRegimeKitImp, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jNomeDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxAtendente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addComponent(jLabel13)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jHorarioSaidaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTipoMovimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jNomeDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxAtendente, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jRegimeKitImp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCNC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdInternoKitImp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNomeInternoKitImp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPavilhaoKitImp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCelaKitBio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                .addContainerGap())
        );

        jBtSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/filesave.png"))); // NOI18N
        jBtSalvar.setToolTipText("Gravar Registro");
        jBtSalvar.setEnabled(false);
        jBtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarActionPerformed(evt);
            }
        });

        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_32.png"))); // NOI18N
        jBtSair.setToolTipText("Sair da Tela");
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        jBtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216082324_32.png"))); // NOI18N
        jBtCancelar.setToolTipText("Cancelar Operação");
        jBtCancelar.setEnabled(false);
        jBtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 0, 0));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("...::: AUTORIZAÇÃO IMPRESSA :::...");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jBtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addComponent(jBtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(11, Short.MAX_VALUE))))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtCancelar, jBtSair, jBtSalvar});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtCancelar))
                        .addGap(5, 5, 5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(17, 17, 17))
                    .addComponent(jBtSair, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtCancelar, jBtSair, jBtSalvar});

        jTabbedPane1.addTab("Manutenção", jPanel4);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Foto Interno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jFotoInternoKitImp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoKitImp, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoKitImp, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtPesquisaInterno.setForeground(new java.awt.Color(0, 0, 255));
        jBtPesquisaInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesquisaInterno.setText("Pesquiar Interno");
        jBtPesquisaInterno.setToolTipText("Pesquiar Interno");
        jBtPesquisaInterno.setEnabled(false);
        jBtPesquisaInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisaInternoActionPerformed(evt);
            }
        });

        jBtImprimirAutorização.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/gtklp-icone-3770-16.png"))); // NOI18N
        jBtImprimirAutorização.setText("Imprimir Autorização");
        jBtImprimirAutorização.setToolTipText("Imprimir Autorização");
        jBtImprimirAutorização.setEnabled(false);
        jBtImprimirAutorização.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtImprimirAutorizaçãoActionPerformed(evt);
            }
        });

        jBtNovo.setForeground(new java.awt.Color(0, 102, 0));
        jBtNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovo.setText("Nova Autorização");
        jBtNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoActionPerformed(evt);
            }
        });

        jBtLiberarAutorizacao.setForeground(new java.awt.Color(204, 0, 0));
        jBtLiberarAutorizacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Biometria16Vermelho.png"))); // NOI18N
        jBtLiberarAutorizacao.setText("Liberação Autorização");
        jBtLiberarAutorizacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtLiberarAutorizacaoActionPerformed(evt);
            }
        });

        jBtAuditoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoria.setToolTipText("Auditoria");
        jBtAuditoria.setContentAreaFilled(false);
        jBtAuditoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaActionPerformed(evt);
            }
        });

        jBtLiberador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/composer-preferences-icone-5121-16.png"))); // NOI18N
        jBtLiberador.setToolTipText("Liberador");
        jBtLiberador.setContentAreaFilled(false);
        jBtLiberador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtLiberadorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBtPesquisaInterno, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                            .addComponent(jBtImprimirAutorização, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                            .addComponent(jBtNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtLiberarAutorizacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jBtAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtLiberador, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtImprimirAutorização, jBtNovo, jBtPesquisaInterno});

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAuditoria, jBtLiberador});

        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtPesquisaInterno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtImprimirAutorização)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtLiberarAutorizacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtAuditoria)
                    .addComponent(jBtLiberador))
                .addContainerGap())
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAuditoria, jBtLiberador});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        setBounds(300, 30, 701, 526);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:           
        buscarAcessoUsuario(telaRegistroAtendimentoImpBio_EF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoEF.equals("ADMINISTRADORES") || codigoUserEF == codUserAcessoEF && nomeTelaEF.equals(telaRegistroAtendimentoImpBio_EF) && codGravarEF == 1) {
            verificarInternos();
            if (jIdInternoKitImp.getText().equals("") || jNomeInternoKitImp.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Informe o nome do interno.");
            } else if (jDataRegistro.getDate() == null) {
                JOptionPane.showMessageDialog(null, "Informe a data do tipo de movimento.");
            } else if (jHorarioSaidaEntrada.getText().equals("") || jHorarioSaidaEntrada.getText().equals("00:00")) {
                JOptionPane.showMessageDialog(null, "Informe o horário do movimento.");
            } else if (jComboBoxTipoMovimentacao.getSelectedItem() == null || jComboBoxTipoMovimentacao.getSelectedItem().equals("") || jComboBoxTipoMovimentacao.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o tipo de atendimento para o interno.");
            } else if (jComboBoxAtendente.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome do atendente para o interno.");
            } else {
                // SE JÁ FOI REGISTRADO         
                if (jIdInternoKitImp.getText().equals(codigoInterno) && atendido.equals("Não")) {
                    JOptionPane.showMessageDialog(rootPane, "Esse interno ainda tem registro de atendimento em aberto, efetue o atendimento para fazer novo registro.");
                } else {
                    if (pLiberacaoImpressa.equals("Sim")) {
                        atendido = "Não";
                        // Para o log do registro
                        objRegAtend.setUsuarioInsert(nameUser);
                        objRegAtend.setDataInsert(dataModFinal);
                        objRegAtend.setHorarioInsert(horaMov);
                        //
                        objRegAtend.setIdInternoCrc(Integer.valueOf(jIdInternoKitImp.getText()));
                        objRegAtend.setNomeInternoCrc(jNomeInternoKitImp.getText());
                        objRegAtend.setNomeDepartamento(jNomeDepartamento.getText());
                        objRegAtend.setTipoAtemdimento((String) jComboBoxTipoMovimentacao.getSelectedItem());
                        objRegAtend.setDataReg(jDataRegistro.getDate());
                        objRegAtend.setHorario(jHorarioSaidaEntrada.getText());
                        objRegAtend.setCodigoFunc(codigoLiberador);
                        objRegAtend.setNomeFunc(nomeLiberador);
                        objRegAtend.setAssinaturaLiberador(pDigitalCapturadaColaborador);
                        objRegAtend.setDataAssinatura(dataAssinatura);
                        objRegAtend.setHoraAssinatura(horaAssinatura);
                        objRegAtend.setAtendido(atendido);
                        objRegAtend.setMotivoImpressao(jMotivo.getText());
                        objRegAtend.setImpressaoAuto(pImpressao);
                        objRegAtend.setQtdAtend(qtdAtend);
                        control.incluirRegAtendColaborador(objRegAtend);
                        buscarRegistro();
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        //GRAVAR NA TABELA DE ATENDIMENTO ATENDIMENTO_PSP_INTERNO_TV - 24/08/2019
                        objRegAtend.setIdRegistro(Integer.valueOf(jIdRegistro.getText()));
                        objRegAtend.setIdInternoCrc(Integer.valueOf(jIdInternoKitImp.getText()));
                        objRegAtend.setNomeInternoCrc(jNomeInternoKitImp.getText());
                        objRegAtend.setNomeDepartamento(nomeModuloEF);
                        objRegAtend.setTipoAtemdimento((String) jComboBoxTipoMovimentacao.getSelectedItem());
                        objRegAtend.setAtendido(pATENDENDO);
                        objRegAtend.setUsuarioAtendente((String) jComboBoxAtendente.getSelectedItem());
                        objRegAtend.setDataInsert(dataModFinal);
                        objRegAtend.setHorarioInsert(horaMov);
                        objRegAtend.setEmAtendimento(pCONCLUIDO);
                        objRegAtend.setStatusAtendimento(pSTATUS_ATENDIMENTO);
                        control_ATENE_TV.iniciarAtendimento(objRegAtend);
                        Salvar();
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                        relatorioAutorizacao();
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Essa autorização ainda não foi liberada, solicite ao responsavel a liberação.");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtSalvarActionPerformed

    private void jBtPesquisaInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisaInternoActionPerformed
        // TODO add your handling code here:        
        TelaPesqInternoRegistroImpresso_EF objPesqIntImp = new TelaPesqInternoRegistroImpresso_EF();
        TelaModuloEducacaoFisica.jPainelEducacaoFisica.add(objPesqIntImp);
        objPesqIntImp.show();
    }//GEN-LAST:event_jBtPesquisaInternoActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtImprimirAutorizaçãoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImprimirAutorizaçãoActionPerformed
        // TODO add your handling code here:       
        if (jIdInternoKitImp.getText().equals("") && jNomeInternoKitImp.getText().equals("") && jIdRegistro.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o nome do interno para impressão da autorização.");
        } else if (jComboBoxTipoMovimentacao.getSelectedItem().equals("Selecione...")) {
            JOptionPane.showMessageDialog(rootPane, "Selecione o tipo de atendimento.");
        } else {
            try {
                conecta.abrirConexao();
                String path = "reports/FichaAutorizacaoAtendimentoInterno.jasper";
                conecta.executaSQL("SELECT * FROM REGISTRO_ATENDIMENTO_INTERNO_PSP "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON REGISTRO_ATENDIMENTO_INTERNO_PSP.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "INNER JOIN DADOSPENAISINTERNOS "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                        + "INNER JOIN ITENSLOCACAOINTERNO "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSLOCACAOINTERNO.IdInternoCrc "
                        + "INNER JOIN CELAS "
                        + "ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                        + "INNER JOIN PAVILHAO "
                        + "ON CELAS.IdPav=PAVILHAO.IdPav "
                        + "WHERE REGISTRO_ATENDIMENTO_INTERNO_PSP.IdRegistro='" + jIdRegistro.getText() + "'");
                HashMap parametros = new HashMap();
                parametros.put("codigoAutoriazacao", jIdRegistro.getText());
                parametros.put("descricaoUnidade", descricaoUnidade);
                parametros.put("nomeUsuario", nameUser);
                JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
                JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
                JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
                jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
                jv.setTitle("Autorização de Atendimento - Enfermaria");
                jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
                jv.toFront(); // Traz o relatorio para frente da aplicação            
                conecta.desconecta();
            } catch (JRException e) {
                JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
            }
        }
    }//GEN-LAST:event_jBtImprimirAutorizaçãoActionPerformed

    private void jBtPesqNomeInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNomeInternoActionPerformed
        // TODO add your handling code here:
        flag = 1;
        preencherTabelaRegistros("SELECT * FROM REGISTRO_ATENDIMENTO_INTERNO_PSP "
                + "INNER JOIN PRONTUARIOSCRC "
                + "ON REGISTRO_ATENDIMENTO_INTERNO_PSP.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                + "WHERE NomeInternoCrc LIKE'%" + jPesqNomeInternoOdonto.getText() + "%' "
                + "AND IdDepartamento='" + codigoDepto + "'"
                + "AND Impresso='" + pImpressao + "'");
    }//GEN-LAST:event_jBtPesqNomeInternoActionPerformed

    private void jBtIdPesqAtendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtIdPesqAtendActionPerformed
        // TODO add your handling code here:
        flag = 1;
        preencherTabelaRegistros("SELECT * FROM REGISTRO_ATENDIMENTO_INTERNO_PSP "
                + "INNER JOIN PRONTUARIOSCRC "
                + "ON REGISTRO_ATENDIMENTO_INTERNO_PSP.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                + "WHERE REGISTRO_ATENDIMENTO_INTERNO_PSP.IdReg='" + jIDPesqAtend.getText() + "' "
                + "AND IdDepartamento='" + codigoDepto + "'"
                + "AND Impresso='" + pImpressao + "'");
    }//GEN-LAST:event_jBtIdPesqAtendActionPerformed

    private void jBtPesqDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqDataActionPerformed
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
                        preencherTabelaRegistros("SELECT * FROM REGISTRO_ATENDIMENTO_INTERNO_PSP "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON REGISTRO_ATENDIMENTO_INTERNO_PSP.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                + "WHERE DataLanc BETWEEN'" + dataInicial + "' "
                                + "AND '" + dataFinal + "' "
                                + "AND IdDepartamento='" + codigoDepto + "'"
                                + "AND Impresso='" + pImpressao + "'");
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
                        preencherTabelaRegistros("SELECT * FROM REGISTRO_ATENDIMENTO_INTERNO_PSP "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON REGISTRO_ATENDIMENTO_INTERNO_PSP.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                + "WHERE DataLanc BETWEEN'" + dataInicial + "' "
                                + "AND '" + dataFinal + "' "
                                + "AND IdDepartamento='" + codigoDepto + "'"
                                + "AND Impresso='" + pImpressao + "'");
                    }
                }
            }
        }
    }//GEN-LAST:event_jBtPesqDataActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherTabelaRegistros("SELECT * FROM REGISTRO_ATENDIMENTO_INTERNO_PSP "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON REGISTRO_ATENDIMENTO_INTERNO_PSP.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "AND IdDepartamento='" + codigoDepto + "' "
                    + "AND Impresso='" + pImpressao + "'");
        } else {
            count = 0;
            jtotalRegistros.setText("");
            limparTabela();
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jTabelaRegistroInternoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaRegistroInternoMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String IdLanc = "" + jTabelaRegistroInterno.getValueAt(jTabelaRegistroInterno.getSelectedRow(), 0);
            jIDPesqAtend.setText(IdLanc);
            String nomeInterno = "" + jTabelaRegistroInterno.getValueAt(jTabelaRegistroInterno.getSelectedRow(), 3);
            jPesqNomeInternoOdonto.setText(nomeInterno);
            //
            bloquearCampos();
            //
            if (!jIdRegistro.getText().equals("")) {
                jBtImprimirAutorização.setEnabled(true);
            }
            jComboBoxAtendente.removeAllItems();
            jComboBoxTipoMovimentacao.removeAllItems();
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM REGISTRO_ATENDIMENTO_INTERNO_PSP "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON REGISTRO_ATENDIMENTO_INTERNO_PSP.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "INNER JOIN DADOSPENAISINTERNOS "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                        + "INNER JOIN ITENSLOCACAOINTERNO "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSLOCACAOINTERNO.IdInternoCrc "
                        + "INNER JOIN CELAS "
                        + "ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                        + "INNER JOIN PAVILHAO "
                        + "ON CELAS.IdPav=PAVILHAO.IdPav "
                        + "WHERE IdRegistro='" + IdLanc + "'");
                conecta.rs.first();
                jIdRegistro.setText(String.valueOf(conecta.rs.getInt("IdRegistro")));
                jDataRegistro.setDate(conecta.rs.getDate("DataReg"));
                jComboBoxTipoMovimentacao.addItem(conecta.rs.getString("TipoAtendimento"));
                jHorarioSaidaEntrada.setText(conecta.rs.getString("Horario"));
                jComboBoxAtendente.addItem(conecta.rs.getString("UsuarioAtendente"));
                jNomeDepartamento.setText(nomeModuloEF);
                jIdInternoKitImp.setText(conecta.rs.getString("IdInternoCrc"));
                jCNC.setText(conecta.rs.getString("Cnc"));
                jRegimeKitImp.setText(conecta.rs.getString("Regime"));
                jNomeInternoKitImp.setText(conecta.rs.getString("NomeInternoCrc"));
                jPavilhaoKitImp.setText(conecta.rs.getString("DescricaoPav"));
                jCelaKitBio.setText(conecta.rs.getString("EndCelaPav"));
                jMotivo.setText(conecta.rs.getString("Motivo"));
                caminhoFotoInterno = conecta.rs.getString("FotoInternoCrc");
                if (caminhoFotoInterno != null) {
                    javax.swing.ImageIcon a = new javax.swing.ImageIcon(caminhoFotoInterno);
                    jFotoInternoKitImp.setIcon(a);
                    jFotoInternoKitImp.setIcon(new ImageIcon(a.getImage().getScaledInstance(jFotoInternoKitImp.getWidth(), jFotoInternoKitImp.getHeight(), Image.SCALE_DEFAULT)));
                }
                // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrente"));
                if (imgBytes != null) {
                    ImageIcon pic = null;
                    pic = new ImageIcon(imgBytes);
                    Image scaled = pic.getImage().getScaledInstance(jFotoInternoKitImp.getWidth(), jFotoInternoKitImp.getHeight(), Image.SCALE_DEFAULT);
                    ImageIcon icon = new ImageIcon(scaled);
                    jFotoInternoKitImp.setIcon(icon);
                }
                codigoLiberador = conecta.rs.getInt("IdFunc");
                conecta.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa..." + e);
            }
        }
    }//GEN-LAST:event_jTabelaRegistroInternoMouseClicked

    private void jBtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarActionPerformed
        // TODO add your handling code here:
        Cancelar();
    }//GEN-LAST:event_jBtCancelarActionPerformed

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroAtendimentoImpBio_EF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoEF.equals("ADMINISTRADORES") || codigoUserEF == codUserAcessoEF && nomeTelaEF.equals(telaRegistroAtendimentoImpBio_EF) && codIncluirEF == 1) {
            int resposta = JOptionPane.showConfirmDialog(this, "Esse documento só é permitido caso o interno não consiga assinar através da biometria, deseja continuar?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                acao = 1;
                Novo();
                pesquisarAtendente();
                statusMov = "Incluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtLiberarAutorizacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtLiberarAutorizacaoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroAtendimentoColLiberador_EF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoEF.equals("ADMINISTRADORES") || codigoUserEF == codUserAcessoEF && nomeTelaEF.equals(telaRegistroAtendimentoColLiberador_EF) && codAbrirEF == 1) {
            if (jIdInternoKitImp.getText().equals("") || jNomeInternoKitImp.getText().equals("") && jIdRegistro.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "E necessário selecionar primeiro o interno para liberação.");
            } else {
                mostraLiberador();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtLiberarAutorizacaoActionPerformed

    private void jBtAuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaActionPerformed
        // TODO add your handling code here:
        if (jIdRegistro.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "É necessário selecionar primeiro um registro.");
        } else {
            TelaAuditoriaRegistroAtendImpresso_EF objAudLibera = new TelaAuditoriaRegistroAtendImpresso_EF();
            TelaModuloEducacaoFisica.jPainelEducacaoFisica.add(objAudLibera);
            objAudLibera.show();
        }
    }//GEN-LAST:event_jBtAuditoriaActionPerformed

    private void jBtLiberadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtLiberadorActionPerformed
        // TODO add your handling code here:
        if (jIdRegistro.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "É necessário selecionar primeiro um registro.");
        } else {
            TelaLiberadorRegistroAtendImpresso_EF objLibera = new TelaLiberadorRegistroAtendImpresso_EF();
            TelaModuloEducacaoFisica.jPainelEducacaoFisica.add(objLibera);
            objLibera.show();
        }
    }//GEN-LAST:event_jBtLiberadorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtAuditoria;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtIdPesqAtend;
    private javax.swing.JButton jBtImprimirAutorização;
    private javax.swing.JButton jBtLiberador;
    private javax.swing.JButton jBtLiberarAutorizacao;
    private javax.swing.JButton jBtNovo;
    private javax.swing.JButton jBtPesqData;
    private javax.swing.JButton jBtPesqNomeInterno;
    private javax.swing.JButton jBtPesquisaInterno;
    private javax.swing.JButton jBtSair;
    public static javax.swing.JButton jBtSalvar;
    public static javax.swing.JTextField jCNC;
    public static javax.swing.JTextField jCelaKitBio;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBoxAtendente;
    public static javax.swing.JComboBox jComboBoxTipoMovimentacao;
    private com.toedter.calendar.JDateChooser jDataFinal;
    private com.toedter.calendar.JDateChooser jDataInicial;
    private com.toedter.calendar.JDateChooser jDataRegistro;
    public static javax.swing.JLabel jFotoInternoKitImp;
    private javax.swing.JFormattedTextField jHorarioSaidaEntrada;
    private javax.swing.JTextField jIDPesqAtend;
    public static javax.swing.JTextField jIdInternoKitImp;
    public static javax.swing.JTextField jIdRegistro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextArea jMotivo;
    private javax.swing.JTextField jNomeDepartamento;
    public static javax.swing.JTextField jNomeInternoKitImp;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    public static javax.swing.JTextField jPavilhaoKitImp;
    private javax.swing.JTextField jPesqNomeInternoOdonto;
    public static javax.swing.JTextField jRegimeKitImp;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTabelaRegistroInterno;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void pesquisarAtendente() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeDepartamento='" + nomeModuloEF + "' "
                    + "AND StatusUsuario='" + pSTATUS_USUARIO + "' "
                    + "ORDER BY NomeUsuario");
            conecta.rs.first();
            do {
                jComboBoxAtendente.addItem(conecta.rs.getString("NomeUsuario"));
            } while (conecta.rs.next());
            jComboBoxAtendente.updateUI();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void relatorioAutorizacao() {
        try {
            conecta.abrirConexao();
            String path = "reports/FichaAutorizacaoAtendimentoInterno.jasper";
            conecta.executaSQL("SELECT * FROM REGISTRO_ATENDIMENTO_INTERNO_PSP "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON REGISTRO_ATENDIMENTO_INTERNO_PSP.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "INNER JOIN ITENSLOCACAOINTERNO "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSLOCACAOINTERNO.IdInternoCrc "
                    + "INNER JOIN CELAS "
                    + "ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                    + "INNER JOIN PAVILHAO "
                    + "ON CELAS.IdPav=PAVILHAO.IdPav "
                    + "WHERE REGISTRO_ATENDIMENTO_INTERNO_PSP.IdRegistro='" + jIdRegistro.getText() + "'");
            HashMap parametros = new HashMap();
            parametros.put("codigoAutoriazacao", jIdRegistro.getText());
            parametros.put("descricaoUnidade", descricaoUnidade);
            parametros.put("nomeUsuario", nameUser);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Autorização de Atendimento - Enfermaria");
            jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
            jv.toFront(); // Traz o relatorio para frente da aplicação            
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }

    public void formatarCampos() {
        jMotivo.setLineWrap(true);
        jMotivo.setWrapStyleWord(true);
    }

    public void corCampos() {
        jIdRegistro.setBackground(Color.white);
        jDataRegistro.setBackground(Color.white);
        jComboBoxTipoMovimentacao.setBackground(Color.white);
        jHorarioSaidaEntrada.setBackground(Color.white);
        jIdInternoKitImp.setBackground(Color.white);
        jCNC.setBackground(Color.white);
        jRegimeKitImp.setBackground(Color.white);
        jNomeInternoKitImp.setBackground(Color.white);
        jPavilhaoKitImp.setBackground(Color.white);
        jCelaKitBio.setBackground(Color.white);
        jNomeDepartamento.setBackground(Color.white);
        jMotivo.setBackground(Color.white);
    }

    public void bloquearCampos() {
        jComboBoxTipoMovimentacao.setEnabled(!true);
        jMotivo.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtPesquisaInterno.setEnabled(!true);
    }

    public void Novo() {
        jIdRegistro.setText("");
        jDataRegistro.setCalendar(Calendar.getInstance());
        jComboBoxTipoMovimentacao.setSelectedItem("Selecione...");
        jHorarioSaidaEntrada.setText(jHoraSistema.getText());
        jNomeDepartamento.setText(nomeModuloEF);
        jIdInternoKitImp.setText("");
        jCNC.setText("");
        jRegimeKitImp.setText("");
        jNomeInternoKitImp.setText("");
        jPavilhaoKitImp.setText("");
        jCelaKitBio.setText("");
        jFotoInternoKitImp.setIcon(null);
        jMotivo.setText("INTERNO NÃO CONSEGUIU ASSINAR ATRAVÉS DA SUA BIOMETRIA DEVIA A DIGITAL GASTA.");
        //
        jMotivo.setEnabled(true);
        jComboBoxAtendente.setEnabled(true);
        jComboBoxTipoMovimentacao.setEnabled(true);
        //
        jBtNovo.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtPesquisaInterno.setEnabled(true);
        jBtImprimirAutorização.setEnabled(!true);
    }

    public void Salvar() {
        jMotivo.setEnabled(!true);
        jComboBoxTipoMovimentacao.setEnabled(!true);
        jComboBoxAtendente.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtPesquisaInterno.setEnabled(!true);
        jBtImprimirAutorização.setEnabled(true);
    }

    public void Cancelar() {
        if (jIdRegistro.getText().equals("")) {
            jDataRegistro.setDate(null);
            jComboBoxTipoMovimentacao.setSelectedItem("Selecione...");
            jHorarioSaidaEntrada.setText("");
            jNomeDepartamento.setText("");
            jIdInternoKitImp.setText("");
            jCNC.setText("");
            jRegimeKitImp.setText("");
            jNomeInternoKitImp.setText("");
            jPavilhaoKitImp.setText("");
            jCelaKitBio.setText("");
            jFotoInternoKitImp.setIcon(null);
            jMotivo.setText("");
            //
            jMotivo.setEnabled(!true);
            jComboBoxTipoMovimentacao.setEnabled(!true);
            jComboBoxAtendente.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtPesquisaInterno.setEnabled(!true);
            jBtImprimirAutorização.setEnabled(!true);
        } else {
            jMotivo.setEnabled(!true);
            jComboBoxTipoMovimentacao.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtPesquisaInterno.setEnabled(!true);
            jBtImprimirAutorização.setEnabled(true);
        }
    }

    public void verificarInternos() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM REGISTRO_ATENDIMENTO_INTERNO_PSP "
                    + "WHERE IdInternoCrc='" + jIdInternoKitImp.getText() + "'");
            conecta.rs.first();
            codigoInterno = conecta.rs.getString("IdInternoCrc");
            DataRegistro = conecta.rs.getString("DataReg");
            atendido = conecta.rs.getString("Atendido");
            // NÃO FOI USADO AINDA
            String dia = DataRegistro.substring(8, 10);
            String mes = DataRegistro.substring(5, 7);
            String ano = DataRegistro.substring(0, 4);
            DataRegistro = dia + "/" + mes + "/" + ano;
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void buscarRegistro() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM REGISTRO_ATENDIMENTO_INTERNO_PSP");
            conecta.rs.last();
            jIdRegistro.setText(conecta.rs.getString("IdRegistro"));
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void preencherTabelaRegistros(String sql) {
        count = 0;
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data ", "Horário", "Nome do Interno"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1;
                // Formatar a data no formato Brasil
                dataReg = conecta.rs.getString("DataReg");
                String dia = dataReg.substring(8, 10);
                String mes = dataReg.substring(5, 7);
                String ano = dataReg.substring(0, 4);
                dataReg = dia + "/" + mes + "/" + ano;
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdRegistro"), dataReg, conecta.rs.getString("Horario"), conecta.rs.getString("NomeInternoCrc")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaRegistroInterno.setModel(modelo);
        jTabelaRegistroInterno.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaRegistroInterno.getColumnModel().getColumn(0).setResizable(false);
        jTabelaRegistroInterno.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaRegistroInterno.getColumnModel().getColumn(1).setResizable(false);
        jTabelaRegistroInterno.getColumnModel().getColumn(2).setPreferredWidth(70);
        jTabelaRegistroInterno.getColumnModel().getColumn(2).setResizable(false);
        jTabelaRegistroInterno.getColumnModel().getColumn(3).setPreferredWidth(250);
        jTabelaRegistroInterno.getColumnModel().getColumn(3).setResizable(false);
        jTabelaRegistroInterno.getTableHeader().setReorderingAllowed(false);
        jTabelaRegistroInterno.setAutoResizeMode(jTabelaRegistroInterno.AUTO_RESIZE_OFF);
        jTabelaRegistroInterno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaitens();
        conecta.desconecta();
    }

    public void limparTabela() {
        count = 0;
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data ", "Horário", "Nome do Interno"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaRegistroInterno.setModel(modelo);
        jTabelaRegistroInterno.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaRegistroInterno.getColumnModel().getColumn(0).setResizable(false);
        jTabelaRegistroInterno.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaRegistroInterno.getColumnModel().getColumn(1).setResizable(false);
        jTabelaRegistroInterno.getColumnModel().getColumn(2).setPreferredWidth(70);
        jTabelaRegistroInterno.getColumnModel().getColumn(2).setResizable(false);
        jTabelaRegistroInterno.getColumnModel().getColumn(3).setPreferredWidth(250);
        jTabelaRegistroInterno.getColumnModel().getColumn(3).setResizable(false);
        jTabelaRegistroInterno.getTableHeader().setReorderingAllowed(false);
        jTabelaRegistroInterno.setAutoResizeMode(jTabelaRegistroInterno.AUTO_RESIZE_OFF);
        jTabelaRegistroInterno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabelaitens() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaRegistroInterno.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaRegistroInterno.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jIdRegistro.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void buscarAcessoUsuario(String nomeTelaAcesso) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nameUser + "'");
            conecta.rs.first();
            codigoUserEF = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUserEF + "'");
            conecta.rs.first();
            codigoUserGroupEF = conecta.rs.getInt("IdUsuario");
            codigoGrupoEF = conecta.rs.getInt("IdGrupo");
            nomeGrupoEF = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUserEF + "' "
                    + "AND NomeTela='" + nomeTelaAcesso + "'");
            conecta.rs.first();
            codUserAcessoEF = conecta.rs.getInt("IdUsuario");
            codAbrirEF = conecta.rs.getInt("Abrir");
            codIncluirEF = conecta.rs.getInt("Incluir");
            codAlterarEF = conecta.rs.getInt("Alterar");
            codExcluirEF = conecta.rs.getInt("Excluir");
            codGravarEF = conecta.rs.getInt("Gravar");
            codConsultarEF = conecta.rs.getInt("Consultar");
            nomeTelaEF = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void pesquisarModulo() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM DEPARTAMENTOS "
                    + "WHERE NomeDepartamento='" + nomeModuloEF + "'");
            conecta.rs.first();
            codigoDepto = conecta.rs.getInt("IdDepartamento");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
