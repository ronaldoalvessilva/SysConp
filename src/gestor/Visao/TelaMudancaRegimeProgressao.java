/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleItensProRegime;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControleProgressaoRegime;
import gestor.Controle.ControleSentencasInternos;
import gestor.Dao.ConexaoBancoDados;
import Utilitarios.LimiteDigitos;
import Utilitarios.ModeloTabela;
import gestor.Modelo.ItensProgressaoRegime;
import gestor.Modelo.LogSistema;
import gestor.Modelo.ProgressaoRegime;
import gestor.Modelo.SentencaInternos;
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
import static gestor.Visao.TelaModuloCRC.telaMudancaRegimeRegIntCRC;
import static gestor.Visao.TelaModuloCRC.telaMudancaRegimeRegManuCRC;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import static gestor.Visao.TelaPesquisaInternoMudancaRegimeProgressao.artigo1;
import static gestor.Visao.TelaPesquisaInternoMudancaRegimeProgressao.artigo2;
import static gestor.Visao.TelaPesquisaInternoMudancaRegimeProgressao.artigo3;
import static gestor.Visao.TelaPesquisaInternoMudancaRegimeProgressao.crimeHediondo;
import static gestor.Visao.TelaPesquisaInternoMudancaRegimeProgressao.dataCondenacaoCrc;
import static gestor.Visao.TelaPesquisaInternoMudancaRegimeProgressao.dataCrimeCrc;
import static gestor.Visao.TelaPesquisaInternoMudancaRegimeProgressao.dataEntradaCrc;
import static gestor.Visao.TelaPesquisaInternoMudancaRegimeProgressao.dataPrisaoCrc;
import static gestor.Visao.TelaPesquisaInternoMudancaRegimeProgressao.idUnid;
import static gestor.Visao.TelaPesquisaInternoMudancaRegimeProgressao.paragrafo1;
import static gestor.Visao.TelaPesquisaInternoMudancaRegimeProgressao.paragrafo2;
import static gestor.Visao.TelaPesquisaInternoMudancaRegimeProgressao.paragrafo3;
import static gestor.Visao.TelaPesquisaInternoMudancaRegimeProgressao.participacao;
import static gestor.Visao.TelaPesquisaInternoMudancaRegimeProgressao.penaAnterior;
import static gestor.Visao.TelaPesquisaInternoMudancaRegimeProgressao.regimeAnterior;
import static gestor.Visao.TelaPesquisaInternoMudancaRegimeProgressao.terminoPenaCrc;
import java.awt.Color;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ronaldo
 */
public class TelaMudancaRegimeProgressao extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ProgressaoRegime objProgresRegime = new ProgressaoRegime();
    ControleProgressaoRegime control = new ControleProgressaoRegime();
    ItensProgressaoRegime objItenPro = new ItensProgressaoRegime();
    ControleItensProRegime controle = new ControleItensProRegime();
    SentencaInternos objSentInt = new SentencaInternos();
    ControleSentencasInternos controleSent = new ControleSentencasInternos();
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela = "CRC:Mudança Regime Progressão de Internos:Manutenção";
    String nomeModuloTela2 = "CRC:Mudança Regime Progressão de Internos:Internos";
    String statusMov;
    String horaMov;
    String dataModFinal;

    //
    int acao, flag;
    String dataInicial, dataFinal, dataLanc;
    String codEntrada;
    public static String idItem;
    String codInterno; // Código do interno para verificar duplicidade na mudança de regime.
    String codLanc; // Código do lançamento associado ao interno para ver se já foi cadastrado para o documento.
    int count = 0;

    /**
     * Creates new form TelaMudancaRegime
     */
    public TelaMudancaRegimeProgressao() {
        initComponents();
        formatarCampos();
        corCampos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jIDPesqLan = new javax.swing.JTextField();
        jBtDataLanc = new javax.swing.JButton();
        jBtIdLanc = new javax.swing.JButton();
        jDataPesqInicial = new com.toedter.calendar.JDateChooser();
        jDataPesFinal = new com.toedter.calendar.JDateChooser();
        jLabel24 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPesqNomeInterno = new javax.swing.JTextField();
        jBtNomeInterno = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTabelaMudancaRegimeReg = new javax.swing.JTable();
        jPanel30 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jIdLanc = new javax.swing.JTextField();
        jStatusLanc = new javax.swing.JTextField();
        jDataLanc = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        jComboBoxRegressao = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jObservacao = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabelaInternoRegressao = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jBtNovo = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jBtFinalizar = new javax.swing.JButton();
        jBtAuditoria = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jBtNovoInterno = new javax.swing.JButton();
        jBtAlterarInterno = new javax.swing.JButton();
        jBtExcluirInterno = new javax.swing.JButton();
        jBtSalvarInterno = new javax.swing.JButton();
        jBtCancelarInterno = new javax.swing.JButton();
        jBtAuditoriaInterno = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jIdInterno = new javax.swing.JTextField();
        jNomeInternoRegime = new javax.swing.JTextField();
        jBtPesqInterno = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jDataProgressao = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxRegime = new javax.swing.JComboBox();
        jDataTerminoPena = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jJuizoCompetente = new javax.swing.JTextField();

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Mudança de Regime Penal - Progressão :::...");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisa Lançamentos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 51, 255))); // NOI18N

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Data Inicial:");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Código:");

        jIDPesqLan.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIDPesqLan.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtDataLanc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtDataLanc.setContentAreaFilled(false);
        jBtDataLanc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtDataLancActionPerformed(evt);
            }
        });

        jBtIdLanc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtIdLanc.setContentAreaFilled(false);
        jBtIdLanc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtIdLancActionPerformed(evt);
            }
        });

        jDataPesqInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jDataPesFinal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setText("Data Final:");

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox1.setText("Todos");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });

        jPesqNomeInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtNomeInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtNomeInterno.setContentAreaFilled(false);
        jBtNomeInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNomeInternoActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Nome Interno:");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jIDPesqLan, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtIdLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDataPesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtDataLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jPesqNomeInterno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox1)))
                .addGap(14, 14, 14))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtDataLanc)
                    .addComponent(jDataPesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(jBtIdLanc)
                    .addComponent(jIDPesqLan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(jBtNomeInterno)
                    .addComponent(jCheckBox1))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jTabelaMudancaRegimeReg.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaMudancaRegimeReg.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data", "Status", "Tipo Operação", "Observação"
            }
        ));
        jTabelaMudancaRegimeReg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaMudancaRegimeRegMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTabelaMudancaRegimeReg);
        if (jTabelaMudancaRegimeReg.getColumnModel().getColumnCount() > 0) {
            jTabelaMudancaRegimeReg.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaMudancaRegimeReg.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaMudancaRegimeReg.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaMudancaRegimeReg.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaMudancaRegimeReg.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaMudancaRegimeReg.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaMudancaRegimeReg.getColumnModel().getColumn(3).setMinWidth(120);
            jTabelaMudancaRegimeReg.getColumnModel().getColumn(3).setMaxWidth(120);
            jTabelaMudancaRegimeReg.getColumnModel().getColumn(4).setMinWidth(380);
            jTabelaMudancaRegimeReg.getColumnModel().getColumn(4).setMaxWidth(380);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
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
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("Listagem", jPanel1);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Status");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Dt. Documento");

        jIdLanc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdLanc.setEnabled(false);

        jStatusLanc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jStatusLanc.setForeground(new java.awt.Color(255, 0, 0));
        jStatusLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jStatusLanc.setEnabled(false);

        jDataLanc.setBackground(new java.awt.Color(255, 255, 255));
        jDataLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataLanc.setEnabled(false);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Tipo de Mudança");

        jComboBoxRegressao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxRegressao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Progressão" }));
        jComboBoxRegressao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxRegressao.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jIdLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jStatusLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jComboBoxRegressao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDataLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jIdLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jStatusLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxRegressao, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDataLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel3))))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

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
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaInternoRegressao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaInternoRegressao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Item", "Código", "Nome do Interno", "Regime"
            }
        ));
        jTabelaInternoRegressao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaInternoRegressaoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTabelaInternoRegressao);
        if (jTabelaInternoRegressao.getColumnModel().getColumnCount() > 0) {
            jTabelaInternoRegressao.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaInternoRegressao.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaInternoRegressao.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaInternoRegressao.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaInternoRegressao.getColumnModel().getColumn(2).setMinWidth(300);
            jTabelaInternoRegressao.getColumnModel().getColumn(2).setMaxWidth(300);
            jTabelaInternoRegressao.getColumnModel().getColumn(3).setMinWidth(150);
            jTabelaInternoRegressao.getColumnModel().getColumn(3).setMaxWidth(150);
        }

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jBtNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovo.setText("Novo");
        jBtNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoActionPerformed(evt);
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

        jBtAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterar.setText("Alterar");
        jBtAlterar.setEnabled(false);
        jBtAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarActionPerformed(evt);
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

        jBtExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluir.setText("Excluir");
        jBtExcluir.setEnabled(false);
        jBtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirActionPerformed(evt);
            }
        });

        jBtFinalizar.setForeground(new java.awt.Color(255, 0, 0));
        jBtFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/accept.png"))); // NOI18N
        jBtFinalizar.setText("Finalizar");
        jBtFinalizar.setToolTipText("Finalizar Registro");
        jBtFinalizar.setEnabled(false);
        jBtFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFinalizarActionPerformed(evt);
            }
        });

        jBtAuditoria.setForeground(new java.awt.Color(0, 0, 255));
        jBtAuditoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoria.setText("Auditoria");
        jBtAuditoria.setEnabled(false);
        jBtAuditoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtAlterar)
                    .addComponent(jBtExcluir)
                    .addComponent(jBtSalvar)
                    .addComponent(jBtCancelar))
                .addGap(33, 33, 33))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtFinalizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtAuditoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterar, jBtAuditoria, jBtCancelar, jBtExcluir, jBtFinalizar, jBtNovo, jBtSalvar});

        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
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
                .addComponent(jBtFinalizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAuditoria)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterar, jBtAuditoria, jBtCancelar, jBtExcluir, jBtFinalizar, jBtNovo, jBtSalvar});

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

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

        jBtAuditoriaInterno.setForeground(new java.awt.Color(0, 51, 255));
        jBtAuditoriaInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaInterno.setText("Auditoria");
        jBtAuditoriaInterno.setEnabled(false);
        jBtAuditoriaInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaInternoActionPerformed(evt);
            }
        });

        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSair.setText("Sair");
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jBtAuditoriaInterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtNovoInterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtCancelarInterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtSalvarInterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtAlterarInterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtExcluirInterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterarInterno, jBtCancelarInterno, jBtExcluirInterno, jBtNovoInterno, jBtSair, jBtSalvarInterno});

        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtNovoInterno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarInterno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirInterno)
                .addGap(1, 1, 1)
                .addComponent(jBtSalvarInterno)
                .addGap(1, 1, 1)
                .addComponent(jBtCancelarInterno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAuditoriaInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSair)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterarInterno, jBtCancelarInterno, jBtExcluirInterno, jBtNovoInterno, jBtSair, jBtSalvarInterno});

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Código");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Nome Completo do Interno");

        jIdInterno.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdInterno.setEnabled(false);

        jNomeInternoRegime.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoRegime.setEnabled(false);

        jBtPesqInterno.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtPesqInterno.setForeground(new java.awt.Color(0, 0, 255));
        jBtPesqInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqInterno.setContentAreaFilled(false);
        jBtPesqInterno.setEnabled(false);
        jBtPesqInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqInternoActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Data Prog:");

        jDataProgressao.setBackground(new java.awt.Color(255, 255, 255));
        jDataProgressao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataProgressao.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Regime:");

        jComboBoxRegime.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxRegime.setForeground(new java.awt.Color(153, 0, 102));
        jComboBoxRegime.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Fechado", "Semi-Aberto", "Aberto", "Provisório" }));
        jComboBoxRegime.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxRegime.setEnabled(false);

        jDataTerminoPena.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataTerminoPena.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("T. Pena:");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("Juízo Comp:");

        jJuizoCompetente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jJuizoCompetente.setEnabled(false);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jIdInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel17)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addComponent(jDataProgressao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxRegime, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtPesqInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jNomeInternoRegime)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jDataTerminoPena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jJuizoCompetente)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jIdInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNomeInternoRegime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxRegime, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jDataProgressao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jBtPesqInterno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel6)
                    .addComponent(jDataTerminoPena, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel22)
                        .addComponent(jJuizoCompetente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2))
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manutenção", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(250, 20, 631, 532);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtDataLancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtDataLancActionPerformed
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
                        preencherTabelaRegressao("SELECT * FROM PROGRESSAOREGIME "
                                + "WHERE DataLanc BETWEEN'" + dataInicial + "' "
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
                        preencherTabelaRegressao("SELECT * FROM PROGRESSAOREGIME "
                                + "WHERE DataLanc BETWEEN'" + dataInicial + "' "
                                + "AND '" + dataFinal + "'");
                    }
                }
            }
        }
    }//GEN-LAST:event_jBtDataLancActionPerformed

    private void jBtIdLancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtIdLancActionPerformed
        // TODO add your handling code here:
        count = 0;
        if (jIDPesqLan.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um código para pesquisa.");
        } else {
            preencherTabelaRegressao("SELECT * FROM PROGRESSAOREGIME WHERE IdLanc='" + jIDPesqLan.getText() + "'");
        }
    }//GEN-LAST:event_jBtIdLancActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            jTabelaMudancaRegimeReg.setVisible(true);
            this.preencherTabelaRegressao("SELECT * FROM PROGRESSAOREGIME");
        } else {
            jtotalRegistros.setText("");
            limparTabela();
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jBtNomeInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNomeInternoActionPerformed
        // TODO add your handling code here:
        count = 0;
        if (jPesqNomeInterno.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "É necessário informar um nome ou parte do nome para pesquuisa.");
        } else {
            preencherTabelaRegressaoNome("SELECT * FROM  PROGRESSAOREGIME "
                    + "INNER JOIN ITENSPROGRESSAOREGIME "
                    + "ON PROGRESSAOREGIME.IdLanc=ITENSPROGRESSAOREGIME.IdLanc "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENSPROGRESSAOREGIME.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE NomeInternoCrc LIKE'%" + jPesqNomeInterno.getText() + "%'");
        }
    }//GEN-LAST:event_jBtNomeInternoActionPerformed

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaMudancaRegimeRegManuCRC);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaMudancaRegimeRegManuCRC) && codIncluirCRC == 1) {
            acao = 1;
            Novo();
            corCampos();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaMudancaRegimeRegManuCRC);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaMudancaRegimeRegManuCRC) && codAlterarCRC == 1) {
            objProgresRegime.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa mudança de regime não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 2;
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

    private void jBtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaMudancaRegimeRegManuCRC);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaMudancaRegimeRegManuCRC) && codExcluirCRC == 1) {
            objProgresRegime.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa mudança de regime não poderá ser excluída, o mesmo encontra-se FINALIZADO");
            } else {
                verificarItens();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaMudancaRegimeRegManuCRC);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaMudancaRegimeRegManuCRC) && codGravarCRC == 1) {
            if (jDataLanc.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data de lançamento.");
                jDataLanc.requestFocus();
                jDataLanc.setBackground(Color.red);
            } else {
                objProgresRegime.setStatusLanc(jStatusLanc.getText());
                objProgresRegime.setTipoMudanca((String) jComboBoxRegressao.getSelectedItem());
                objProgresRegime.setDataLanc(jDataLanc.getDate());
                objProgresRegime.setObservacao(jObservacao.getText());
                if (acao == 1) {
                    // log de usuario
                    objProgresRegime.setUsuarioInsert(nameUser);
                    objProgresRegime.setDataInsert(dataModFinal);
                    objProgresRegime.setHorarioInsert(horaMov);
                    control.incluirProgressaoRegime(objProgresRegime);
                    buscarCod();
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    Salvar();
                }
                if (acao == 2) {
                    // log de usuario
                    objProgresRegime.setUsuarioUp(nameUser);
                    objProgresRegime.setDataUp(dataModFinal);
                    objProgresRegime.setHorarioUp(horaMov);
                    objProgresRegime.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                    control.alterarProgressaoRegime(objProgresRegime);
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    Salvar();
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
            conecta.executaSQL("SELECT * FROM PROGRESSAOREGIME WHERE IdLanc='" + jIdLanc.getText() + "'");
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
        TelaAuditoriaProgressao objAudiProgres = new TelaAuditoriaProgressao();
        TelaModuloCRC.jPainelCRC.add(objAudiProgres);
        objAudiProgres.show();
    }//GEN-LAST:event_jBtAuditoriaActionPerformed

    private void jBtNovoInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoInternoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaMudancaRegimeRegIntCRC);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaMudancaRegimeRegIntCRC) && codIncluirCRC == 1) {
            objProgresRegime.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa mudança de regime não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                JOptionPane.showMessageDialog(null, "Esse lançamento irá atualizar o prontuario do interno.\nEntão tenha certeza de que os dados estejam corretos.\nApós gravar os dados não será possível altera-los.\nCaso necesseário, altere os dados no prontuario do\ninterno manualmente.");
                acao = 3;
                NovoInterno();
                statusMov = "Incluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovoInternoActionPerformed

    private void jBtAlterarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarInternoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaMudancaRegimeRegIntCRC);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaMudancaRegimeRegIntCRC) && codAlterarCRC == 1) {
            objProgresRegime.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa mudança de regime não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 4;
                AlterarInterno();
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtAlterarInternoActionPerformed

    private void jBtExcluirInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirInternoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaMudancaRegimeRegIntCRC);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaMudancaRegimeRegIntCRC) && codExcluirCRC == 1) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            objProgresRegime.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse  interno não poderá ser excluído, o mesmo encontra-se FINALIZADO");
            } else {
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o INTERNO selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    objSentInt.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                    objSentInt.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
                    controleSent.excluirSentencaInternos(objSentInt); // Excluir os dados na tabela SENTENCA
                    //
                    objItenPro.setIdItem(Integer.valueOf(idItem));
                    controle.excluirItensProgressaoRegime(objItenPro);
                    objLog2();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                    ExcluirInterno();
                    preencherTabelaItens("SELECT * FROM ITENSPROGRESSAOREGIME "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON ITENSPROGRESSAOREGIME.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "WHERE IdLanc='" + jIdLanc.getText() + "'");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirInternoActionPerformed

    private void jBtSalvarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarInternoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaMudancaRegimeRegIntCRC);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaMudancaRegimeRegIntCRC) && codGravarCRC == 1) {
            verificarInternoCadastrado(); // Verificar se o interno já foi incluido no documento.
            if (jNomeInternoRegime.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Informe qual é o nome do interno.");
            } else {
                if (jDataProgressao.getDate() == null) {
                    JOptionPane.showMessageDialog(null, "Informe a data de regressão do interno.");
                } else {
                    if (jComboBoxRegime.getSelectedItem() == null) {
                        JOptionPane.showMessageDialog(null, "Informe o regime ao qual o interno foi regredido.");
                    } else {

                        if (jDataTerminoPena.getDate() == null) {
                            JOptionPane.showMessageDialog(null, "Informe a data do termino da pena.");
                        } else {
                            if (jJuizoCompetente.getText().equals("")) {
                                JOptionPane.showMessageDialog(null, "Informe o Juizo Competente.");
                            } else {
                                objItenPro.setDataProgressao(jDataProgressao.getDate());
                                objItenPro.setRegime((String) jComboBoxRegime.getSelectedItem());
                                objItenPro.setTerminoPena(jDataTerminoPena.getDate());
                                objItenPro.setJuizo(jJuizoCompetente.getText());
                                if (acao == 3) {
                                    if (jIdInterno.getText().equals(codInterno) && jIdLanc.getText().equals(codLanc)) {
                                        JOptionPane.showMessageDialog(null, "Esse interno já foi incluído nesse documento.");
                                    } else {
                                        objItenPro.setUsuarioInsert(nameUser);
                                        objItenPro.setDataInsert(dataModFinal);
                                        objItenPro.setHorarioInsert(horaMov);
                                        objItenPro.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                                        objItenPro.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
                                        objItenPro.setNomeInternoCrc(jNomeInternoRegime.getText());
                                        controle.incluirItensProgressaoRegime(objItenPro);
                                        //
                                        objSentInt.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                                        objSentInt.setMudancaRegime((String) jComboBoxRegressao.getSelectedItem());
                                        objSentInt.setDataLanc(jDataLanc.getDate());
                                        objSentInt.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
                                        objSentInt.setDataEntradaCrc(dataEntradaCrc);
                                        objSentInt.setIdUnid(Integer.valueOf(idUnid));
                                        objSentInt.setDataCrimeCrc(dataCrimeCrc);
                                        objSentInt.setDataPrisaoCrc(dataPrisaoCrc);
                                        objSentInt.setDataCondenacaoCrc(dataCondenacaoCrc);
                                        objSentInt.setParticipacao(participacao);
                                        objSentInt.setRegimeAnterior(regimeAnterior);
                                        objSentInt.setPena(penaAnterior);
                                        objSentInt.setArtigo1(artigo1);
                                        objSentInt.setArtigo2(artigo2);
                                        objSentInt.setArtigo3(artigo3);
                                        objSentInt.setParagrafo1(paragrafo1);
                                        objSentInt.setParagrafo2(paragrafo2);
                                        objSentInt.setParagrafo3(paragrafo3);
                                        objSentInt.setCrimeHediondo(crimeHediondo);
                                        objSentInt.setTerminoPenaCrc(terminoPenaCrc);
                                        objSentInt.setDescricaoUnidade(crimeHediondo);
                                        controleSent.incluirSentencaInternos(objSentInt); // Incluir na tabela SENTENCAS, histórico de mudança de regime para relatório                                   
                                        // Atualiza o prontuário do interno quando provisório na tabela de DADOSPENAISINTERNOS.
                                        objItenPro.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
                                        controle.atualizarRegimeProgressaoInterno(objItenPro);
                                        //
                                        objLog2();
                                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação                                                                        
                                        preencherTabelaItens("SELECT * FROM ITENSPROGRESSAOREGIME "
                                                + "INNER JOIN PRONTUARIOSCRC "
                                                + "ON ITENSPROGRESSAOREGIME.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                                + "WHERE IdLanc='" + jIdLanc.getText() + "'");
                                        JOptionPane.showMessageDialog(null, "Registro gravado com sucesso.");
                                        SalvarInterno();
                                    }
                                }
                                if (acao == 4) {
                                    objItenPro.setUsuarioUp(nameUser);
                                    objItenPro.setDataUp(dataModFinal);
                                    objItenPro.setHorarioUp(horaMov);
                                    objItenPro.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                                    objItenPro.setNomeInternoCrc(jNomeInternoRegime.getText());
                                    objItenPro.setIdItem(Integer.valueOf(idItem));
                                    controle.alterarItensProgressaoRegime(objItenPro);
                                    objLog2();
                                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                                    preencherTabelaItens("SELECT * FROM ITENSPROGRESSAOREGIME "
                                            + "INNER JOIN PRONTUARIOSCRC "
                                            + "ON ITENSPROGRESSAOREGIME.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                            + "WHERE IdLanc='" + jIdLanc.getText() + "'");
                                    JOptionPane.showMessageDialog(null, "Registro gravado com sucesso.");
                                    SalvarInterno();
                                }
                            }
                        }
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtSalvarInternoActionPerformed

    private void jBtCancelarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarInternoActionPerformed
        // TODO add your handling code here:
        CancelarInterno();
    }//GEN-LAST:event_jBtCancelarInternoActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtPesqInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqInternoActionPerformed
        // TODO add your handling code here:
        TelaPesquisaInternoMudancaRegimeProgressao objPesqIntMuda = new TelaPesquisaInternoMudancaRegimeProgressao();
        TelaModuloCRC.jPainelCRC.add(objPesqIntMuda);
        objPesqIntMuda.show();
    }//GEN-LAST:event_jBtPesqInternoActionPerformed

    private void jBtAuditoriaInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaInternoActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaItensProgressao obuAudItensPro = new TelaAuditoriaItensProgressao();
        TelaModuloCRC.jPainelCRC.add(obuAudItensPro);
        obuAudItensPro.show();
    }//GEN-LAST:event_jBtAuditoriaInternoActionPerformed

    private void jTabelaMudancaRegimeRegMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaMudancaRegimeRegMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String IdLanc = "" + jTabelaMudancaRegimeReg.getValueAt(jTabelaMudancaRegimeReg.getSelectedRow(), 0);
            jIDPesqLan.setText(IdLanc);
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtNovoInterno.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            //
            bloquearCamposPesquisa();
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM PROGRESSAOREGIME WHERE IdLanc='" + IdLanc + "'");
                conecta.rs.first();
                jIdLanc.setText(String.valueOf(conecta.rs.getInt("IdLanc")));
                jStatusLanc.setText(conecta.rs.getString("StatusLanc"));
                jComboBoxRegressao.setSelectedItem(conecta.rs.getString("TipoMudanca"));
                jDataLanc.setDate(conecta.rs.getDate("DataLanc"));
                jObservacao.setText(conecta.rs.getString("Observacao"));
                conecta.desconecta();
                preencherTabelaItens("SELECT * FROM ITENSPROGRESSAOREGIME "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ITENSPROGRESSAOREGIME.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE IdLanc='" + IdLanc + "'");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa..." + e);
            }
        }
    }//GEN-LAST:event_jTabelaMudancaRegimeRegMouseClicked

    private void jTabelaInternoRegressaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaInternoRegressaoMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            String nomeInterno = "" + jTabelaInternoRegressao.getValueAt(jTabelaInternoRegressao.getSelectedRow(), 2);
            jNomeInternoRegime.setText(nomeInterno);
            idItem = "" + jTabelaInternoRegressao.getValueAt(jTabelaInternoRegressao.getSelectedRow(), 0);
            // Habilitar os botões
            jBtNovoInterno.setEnabled(!true);
            jBtAlterarInterno.setEnabled(true);
            jBtExcluirInterno.setEnabled(true);
            jBtSalvarInterno.setEnabled(!true);
            jBtCancelarInterno.setEnabled(true);
            jBtAuditoriaInterno.setEnabled(true);
            //      jComboBoxUnidPenal.removeAllItems();
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ITENSPROGRESSAOREGIME "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ITENSPROGRESSAOREGIME.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE NomeInternoCrc='" + jNomeInternoRegime.getText() + "' AND IdLanc='" + jIdLanc.getText() + "'AND IdItem='" + idItem + "'");
                conecta.rs.first();
                jIdInterno.setText(conecta.rs.getString("IdInternoCrc"));
                jNomeInternoRegime.setText(conecta.rs.getString("NomeInternoCrc"));
                idItem = conecta.rs.getString("IdItem");
                jDataProgressao.setDate(conecta.rs.getDate("DataProgressao"));
                jComboBoxRegime.setSelectedItem(conecta.rs.getString("NovoRegimePro"));
                jDataTerminoPena.setDate(conecta.rs.getDate("NovoTerminoPenaPro"));
                jJuizoCompetente.setText(conecta.rs.getString("Juizo"));
                conecta.desconecta();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não existe dados a serem alterado!!!" + ex);
            }
        }
    }//GEN-LAST:event_jTabelaInternoRegressaoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtAlterarInterno;
    private javax.swing.JButton jBtAuditoria;
    private javax.swing.JButton jBtAuditoriaInterno;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtCancelarInterno;
    private javax.swing.JButton jBtDataLanc;
    private javax.swing.JButton jBtExcluir;
    private javax.swing.JButton jBtExcluirInterno;
    private javax.swing.JButton jBtFinalizar;
    private javax.swing.JButton jBtIdLanc;
    private javax.swing.JButton jBtNomeInterno;
    private javax.swing.JButton jBtNovo;
    private javax.swing.JButton jBtNovoInterno;
    private javax.swing.JButton jBtPesqInterno;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JButton jBtSalvarInterno;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox jComboBoxRegime;
    private javax.swing.JComboBox jComboBoxRegressao;
    private com.toedter.calendar.JDateChooser jDataLanc;
    private com.toedter.calendar.JDateChooser jDataPesFinal;
    private com.toedter.calendar.JDateChooser jDataPesqInicial;
    private com.toedter.calendar.JDateChooser jDataProgressao;
    private com.toedter.calendar.JDateChooser jDataTerminoPena;
    private javax.swing.JTextField jIDPesqLan;
    public static javax.swing.JTextField jIdInterno;
    public static javax.swing.JTextField jIdLanc;
    private javax.swing.JTextField jJuizoCompetente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel63;
    public static javax.swing.JTextField jNomeInternoRegime;
    private javax.swing.JTextArea jObservacao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField jPesqNomeInterno;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jStatusLanc;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTabelaInternoRegressao;
    private javax.swing.JTable jTabelaMudancaRegimeReg;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void bloquearCamposPesquisa() {
        jIdLanc.setEnabled(!true);
        jStatusLanc.setEnabled(!true);
        jComboBoxRegressao.setEnabled(!true);
        jDataLanc.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //        
        jIdInterno.setEnabled(!true);
        jNomeInternoRegime.setEnabled(!true);
        jDataProgressao.setEnabled(!true);
        jComboBoxRegime.setEnabled(!true);
        jDataTerminoPena.setEnabled(!true);
        jJuizoCompetente.setEnabled(!true);
        //
        jBtPesqInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        //
        jIdLanc.setEnabled(!true);
        jStatusLanc.setEnabled(!true);
        jComboBoxRegressao.setEnabled(!true);
        jDataLanc.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //        
        jIdInterno.setText("");
        jNomeInternoRegime.setText("");
        jDataProgressao.setDate(null);
        jComboBoxRegime.setSelectedItem(null);
        jDataTerminoPena.setDate(null);
        jJuizoCompetente.setText("");
    }

    public void formatarCampos() {
        jObservacao.setLineWrap(true);
        jObservacao.setWrapStyleWord(true);
        jJuizoCompetente.setDocument(new LimiteDigitos(44));
    }

    public void corCampos() {
        jIdLanc.setBackground(Color.white);
        jStatusLanc.setBackground(Color.white);
        jComboBoxRegressao.setBackground(Color.white);
        jDataLanc.setBackground(Color.white);
        jObservacao.setBackground(Color.white);
        //
        jIdInterno.setBackground(Color.white);
        jNomeInternoRegime.setBackground(Color.white);
        jDataProgressao.setBackground(Color.white);
        jComboBoxRegime.setBackground(Color.white);
        jDataTerminoPena.setBackground(Color.white);
        jJuizoCompetente.setBackground(Color.white);
    }

    public void Novo() {
        //
        jIdLanc.setText("");
        jStatusLanc.setText("ABERTO");
        jDataLanc.setCalendar(Calendar.getInstance());
        jObservacao.setText("");
        //
        jComboBoxRegressao.setEnabled(true);
        jDataLanc.setEnabled(true);
        jObservacao.setEnabled(true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(!true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        limparTabelaItens();
        //        
        jIdInterno.setText("");
        jNomeInternoRegime.setText("");
        jDataProgressao.setDate(null);
        jComboBoxRegime.setSelectedItem(null);
        jDataTerminoPena.setDate(null);
        jJuizoCompetente.setText("");
    }

    public void Alterar() {
        //
        jComboBoxRegressao.setEnabled(true);
        jDataLanc.setEnabled(true);
        jObservacao.setEnabled(true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(!true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
    }

    public void Excluir() {
        jIdLanc.setText("");
        jStatusLanc.setText("");
        jDataLanc.setDate(null);
        jObservacao.setText("");
        //
        jComboBoxRegressao.setEnabled(!true);
        jDataLanc.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
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
    }

    public void Salvar() {
        //
        jComboBoxRegressao.setEnabled(!true);
        jDataLanc.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        //
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
    }

    public void Cancelar() {
        if (jIdLanc.getText().equals("")) {
            jStatusLanc.setText("");
            jDataLanc.setDate(null);
            jObservacao.setText("");
            //
            jComboBoxRegressao.setEnabled(!true);
            jDataLanc.setEnabled(!true);
            jObservacao.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
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
        } else {
            //
            jComboBoxRegressao.setEnabled(!true);
            jDataLanc.setEnabled(!true);
            jObservacao.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            //
            jBtNovoInterno.setEnabled(true);
            jBtAlterarInterno.setEnabled(!true);
            jBtExcluirInterno.setEnabled(!true);
            jBtSalvarInterno.setEnabled(!true);
            jBtCancelarInterno.setEnabled(!true);
            jBtAuditoriaInterno.setEnabled(!true);
        }
    }

    public void Finalizar() {
        statusMov = "Finalizou";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        String statusEntrada = "FINALIZADO";
        JOptionPane.showMessageDialog(rootPane, "Se essa entrada de internos for finalizado, você não poderá\nmais excluir ou alterar.");
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente FINALIZAR o lançamento selecionado?", "Confirmação",
                JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            objProgresRegime.setStatusLanc(statusEntrada);
            objProgresRegime.setIdLanc(Integer.parseInt(jIdLanc.getText()));
            control.finalizarProgressaoRegime(objProgresRegime);
            jStatusLanc.setText(statusEntrada);
            objLog();
            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
            JOptionPane.showMessageDialog(rootPane, "Registro FINALIZADO com sucesso !!!");
            jDataLanc.setEnabled(!true);
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
            jBtNovoInterno.setEnabled(!true);
        }
    }

    public void buscarCod() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PROGRESSAOREGIME");
            conecta.rs.last();
            jIdLanc.setText(conecta.rs.getString("Idlanc"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(jJuizoCompetente, "Não foi possível obter o código do registro.");
        }
    }

    // Verificar se o interno já foi incluido no documento.
    public void verificarInternoCadastrado() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENSPROGRESSAOREGIME WHERE IdInternoCrc='" + jIdInterno.getText() + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getString("IdInternoCrc");
            codLanc = conecta.rs.getString("IdLanc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void NovoInterno() {
        //
        jIdInterno.setText("");
        jNomeInternoRegime.setText("");
        jDataProgressao.setCalendar(Calendar.getInstance());
        jComboBoxRegime.setSelectedItem(null);
        jDataTerminoPena.setCalendar(Calendar.getInstance());
        jJuizoCompetente.setText("");
        //
        jBtPesqInterno.setEnabled(true);
        jDataProgressao.setEnabled(true);
        jComboBoxRegime.setEnabled(true);
        jDataTerminoPena.setEnabled(true);
        jJuizoCompetente.setEnabled(true);
        //
        jComboBoxRegressao.setEnabled(!true);
        jDataLanc.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
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
        jBtSalvarInterno.setEnabled(true);
        jBtCancelarInterno.setEnabled(true);
        jBtAuditoriaInterno.setEnabled(!true);
    }

    public void AlterarInterno() {
        //
        jBtPesqInterno.setEnabled(!true);
        jDataProgressao.setEnabled(true);
        jComboBoxRegime.setEnabled(true);
        jDataTerminoPena.setEnabled(true);
        jJuizoCompetente.setEnabled(true);
        //
        jComboBoxRegressao.setEnabled(!true);
        jDataLanc.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
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
        jBtSalvarInterno.setEnabled(true);
        jBtCancelarInterno.setEnabled(true);
        jBtAuditoriaInterno.setEnabled(!true);
    }

    public void ExcluirInterno() {
        //
        jIdInterno.setText("");
        jNomeInternoRegime.setText("");
        jDataProgressao.setDate(null);
        jComboBoxRegime.setSelectedItem(null);
        jDataTerminoPena.setDate(null);
        jJuizoCompetente.setText("");
        //
        jBtPesqInterno.setEnabled(!true);
        jDataProgressao.setEnabled(!true);
        jComboBoxRegime.setEnabled(!true);
        jDataTerminoPena.setEnabled(!true);
        jJuizoCompetente.setEnabled(!true);
        //
        jComboBoxRegressao.setEnabled(!true);
        jDataLanc.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        //
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
    }

    public void SalvarInterno() {
        //
        jIdInterno.setText("");
        jNomeInternoRegime.setText("");
        jDataProgressao.setDate(null);
        jComboBoxRegime.setSelectedItem(null);
        jDataTerminoPena.setDate(null);
        jJuizoCompetente.setText("");
        //
        jBtPesqInterno.setEnabled(!true);
        jDataProgressao.setEnabled(!true);
        jComboBoxRegime.setEnabled(!true);
        jDataTerminoPena.setEnabled(!true);
        jJuizoCompetente.setEnabled(!true);
        //
        jComboBoxRegressao.setEnabled(!true);
        jDataLanc.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        //
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
    }

    public void CancelarInterno() {
        //
        jIdInterno.setText("");
        jNomeInternoRegime.setText("");
        jDataProgressao.setDate(null);
        jComboBoxRegime.setSelectedItem(null);
        jDataTerminoPena.setDate(null);
        jJuizoCompetente.setText("");
        //
        jBtPesqInterno.setEnabled(!true);
        jDataProgressao.setEnabled(!true);
        jComboBoxRegime.setEnabled(!true);
        jDataTerminoPena.setEnabled(!true);
        jJuizoCompetente.setEnabled(!true);
        //
        jComboBoxRegressao.setEnabled(!true);
        jDataLanc.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        //
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
    }

    public void verificarItens() {
        statusMov = "Excluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENSPROGRESSAOREGIME WHERE IdLanc='" + jIdLanc.getText() + "'");
            conecta.rs.first();
            codEntrada = conecta.rs.getString("IdLanc");
            if (jIdLanc.getText().equals(codEntrada)) {
                JOptionPane.showMessageDialog(rootPane, "Antes de excluir esse Lançamento, será necessário\nexcluir primeiro os internos relacionados a esse registro.");
            }
            conecta.desconecta();
        } catch (SQLException ex) {
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o LANÇAMENTO selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objProgresRegime.setIdLanc(Integer.parseInt(jIdLanc.getText()));
                control.excluirProgressaoRegime(objProgresRegime);
                objLog();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                Excluir();
            }
        }
    }

    public void preencherTabelaRegressao(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Tipo Mudança", "Observação"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1;
                // Formatar a data no formato Brasil
                dataLanc = conecta.rs.getString("DataLanc");
                String dia = dataLanc.substring(8, 10);
                String mes = dataLanc.substring(5, 7);
                String ano = dataLanc.substring(0, 4);
                dataLanc = dia + "/" + mes + "/" + ano;
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdLanc"), dataLanc, conecta.rs.getString("StatusLanc"), conecta.rs.getString("TipoMudanca"), conecta.rs.getString("Observacao")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaMudancaRegimeReg.setModel(modelo);
        jTabelaMudancaRegimeReg.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaMudancaRegimeReg.getColumnModel().getColumn(0).setResizable(false);
        jTabelaMudancaRegimeReg.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaMudancaRegimeReg.getColumnModel().getColumn(1).setResizable(false);
        jTabelaMudancaRegimeReg.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaMudancaRegimeReg.getColumnModel().getColumn(2).setResizable(false);
        jTabelaMudancaRegimeReg.getColumnModel().getColumn(3).setPreferredWidth(120);
        jTabelaMudancaRegimeReg.getColumnModel().getColumn(3).setResizable(false);
        jTabelaMudancaRegimeReg.getColumnModel().getColumn(4).setPreferredWidth(380);
        jTabelaMudancaRegimeReg.getColumnModel().getColumn(4).setResizable(false);
        jTabelaMudancaRegimeReg.getTableHeader().setReorderingAllowed(false);
        jTabelaMudancaRegimeReg.setAutoResizeMode(jTabelaMudancaRegimeReg.AUTO_RESIZE_OFF);
        jTabelaMudancaRegimeReg.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabela();
        conecta.desconecta();
    }

    public void limparTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Tipo Mudança", "Observação"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaMudancaRegimeReg.setModel(modelo);
        jTabelaMudancaRegimeReg.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaMudancaRegimeReg.getColumnModel().getColumn(0).setResizable(false);
        jTabelaMudancaRegimeReg.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaMudancaRegimeReg.getColumnModel().getColumn(1).setResizable(false);
        jTabelaMudancaRegimeReg.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaMudancaRegimeReg.getColumnModel().getColumn(2).setResizable(false);
        jTabelaMudancaRegimeReg.getColumnModel().getColumn(3).setPreferredWidth(120);
        jTabelaMudancaRegimeReg.getColumnModel().getColumn(3).setResizable(false);
        jTabelaMudancaRegimeReg.getColumnModel().getColumn(4).setPreferredWidth(380);
        jTabelaMudancaRegimeReg.getColumnModel().getColumn(4).setResizable(false);
        jTabelaMudancaRegimeReg.getTableHeader().setReorderingAllowed(false);
        jTabelaMudancaRegimeReg.setAutoResizeMode(jTabelaMudancaRegimeReg.AUTO_RESIZE_OFF);
        jTabelaMudancaRegimeReg.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void preencherTabelaRegressaoNome(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Tipo Mudança", "Nome do Interno"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                // Formatar a data no formato Brasil
                dataLanc = conecta.rs.getString("DataLanc");
                String dia = dataLanc.substring(8, 10);
                String mes = dataLanc.substring(5, 7);
                String ano = dataLanc.substring(0, 4);
                dataLanc = dia + "/" + mes + "/" + ano;
                dados.add(new Object[]{conecta.rs.getInt("IdLanc"), dataLanc, conecta.rs.getString("StatusLanc"), conecta.rs.getString("TipoMudanca"), conecta.rs.getString("NomeInternoCrc")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaMudancaRegimeReg.setModel(modelo);
        jTabelaMudancaRegimeReg.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaMudancaRegimeReg.getColumnModel().getColumn(0).setResizable(false);
        jTabelaMudancaRegimeReg.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaMudancaRegimeReg.getColumnModel().getColumn(1).setResizable(false);
        jTabelaMudancaRegimeReg.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaMudancaRegimeReg.getColumnModel().getColumn(2).setResizable(false);
        jTabelaMudancaRegimeReg.getColumnModel().getColumn(3).setPreferredWidth(120);
        jTabelaMudancaRegimeReg.getColumnModel().getColumn(3).setResizable(false);
        jTabelaMudancaRegimeReg.getColumnModel().getColumn(4).setPreferredWidth(380);
        jTabelaMudancaRegimeReg.getColumnModel().getColumn(4).setResizable(false);
        jTabelaMudancaRegimeReg.getTableHeader().setReorderingAllowed(false);
        jTabelaMudancaRegimeReg.setAutoResizeMode(jTabelaMudancaRegimeReg.AUTO_RESIZE_OFF);
        jTabelaMudancaRegimeReg.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
        jTabelaMudancaRegimeReg.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaMudancaRegimeReg.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaMudancaRegimeReg.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }

    public void preencherTabelaItens(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código", "Nome do Interno", "Regime"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdItem"), conecta.rs.getInt("IdInternoCrc"), conecta.rs.getString("NomeInternoCrc"), conecta.rs.getString("NovoRegimePro")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInternoRegressao.setModel(modelo);
        jTabelaInternoRegressao.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaInternoRegressao.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInternoRegressao.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaInternoRegressao.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInternoRegressao.getColumnModel().getColumn(2).setPreferredWidth(300);
        jTabelaInternoRegressao.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInternoRegressao.getColumnModel().getColumn(3).setPreferredWidth(150);
        jTabelaInternoRegressao.getColumnModel().getColumn(3).setResizable(false);
        jTabelaInternoRegressao.getTableHeader().setReorderingAllowed(false);
        jTabelaInternoRegressao.setAutoResizeMode(jTabelaInternoRegressao.AUTO_RESIZE_OFF);
        jTabelaInternoRegressao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaItens();
        conecta.desconecta();
    }

    public void limparTabelaItens() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código", "Nome do Interno", "Regime"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInternoRegressao.setModel(modelo);
        jTabelaInternoRegressao.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaInternoRegressao.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInternoRegressao.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaInternoRegressao.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInternoRegressao.getColumnModel().getColumn(2).setPreferredWidth(300);
        jTabelaInternoRegressao.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInternoRegressao.getColumnModel().getColumn(3).setPreferredWidth(150);
        jTabelaInternoRegressao.getColumnModel().getColumn(3).setResizable(false);
        jTabelaInternoRegressao.getTableHeader().setReorderingAllowed(false);
        jTabelaInternoRegressao.setAutoResizeMode(jTabelaInternoRegressao.AUTO_RESIZE_OFF);
        jTabelaInternoRegressao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabelaItens() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaInternoRegressao.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaInternoRegressao.getColumnModel().getColumn(1).setCellRenderer(centralizado);
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
}
