/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleFrequenciaCapacitacaoInternos;
import gestor.Controle.ControleListaProfessores;
import gestor.Controle.ControleLogSistema;
import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.ModeloTabela;
import gestor.Modelo.FrequenciaCapacitacaoInternosPedagogia;
import gestor.Modelo.LogSistema;
import gestor.Modelo.Professores;
import static gestor.Visao.TelaLoginSenha.descricaoUnidade;
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
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import static gestor.Visao.TelaModuloTerapiaOcupacional.codAbrirTO;
import static gestor.Visao.TelaModuloTerapiaOcupacional.codAlterarTO;
import static gestor.Visao.TelaModuloTerapiaOcupacional.codExcluirTO;
import static gestor.Visao.TelaModuloTerapiaOcupacional.codGravarTO;
import static gestor.Visao.TelaModuloTerapiaOcupacional.codIncluirTO;
import static gestor.Visao.TelaModuloTerapiaOcupacional.codUserAcessoTO;
import static gestor.Visao.TelaModuloTerapiaOcupacional.codigoUserTO;
import static gestor.Visao.TelaModuloTerapiaOcupacional.nomeGrupoTO;
import static gestor.Visao.TelaModuloTerapiaOcupacional.nomeTelaTO;
import static gestor.Visao.TelaModuloTerapiaOcupacional.telaFreqCapacitacaoInternoIntTO;
import static gestor.Visao.TelaModuloTerapiaOcupacional.telaFreqCapacitacaoInternoManuTO;
import java.awt.Color;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Currency;
import java.util.HashMap;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class TelaControleFrequenciaCursosAC_PEDAGOGIA extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    Professores objProf = new Professores();
    ControleListaProfessores controlDAO_PRF = new ControleListaProfessores(); 
    FrequenciaCapacitacaoInternosPedagogia objFreqCap = new FrequenciaCapacitacaoInternosPedagogia();
    //
    ControleFrequenciaCapacitacaoInternos control = new ControleFrequenciaCapacitacaoInternos();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela = "Pedagogia:Controle de Frequência de Cursos:Manutenção";
    String nomeModuloTela2 = "Pedagogia:Controle de Frequência de Cursos:Participantes";
    //
    int acao = 0;
    int flag = 0;
    String dataEntrada, dataInicial, dataFinal, dataInicio, dataConclusao;
    String caminho;
    int count = 0;
    String statusMov;
    String horaMov;
    String dataModFinal;
    //
    String idItem;
    Float notaAvaliacao;
    String codigoRegistro = "";
    String notaAvaliada;
    String pSitaucaoCurso = "";
    String pSituacaoInterno = "Cursando";
    public static int codigoCurso = 0;
    public static int codigoItem = 0;
    // DIAS E HORARIOS DA SEMANA PARA SAIDA DOS INTERNOS
    int DIA_DOM = 0;
    int DIA_SEG = 0;
    int DIA_TER = 0;
    int DIA_QUA = 0;
    int DIA_QUI = 0;
    int DIA_SEX = 0;
    int DIA_SAB = 0;
    // DIAS E HORARIOS DA SEMANA PARA SAIDA DOS INTERNOS
    public static int DiaSeg;
    public static int DiaTer;
    public static int DiaQua;
    public static int DiaQui;
    public static int DiaSex;
    public static int DiaSab;
    public static int DiaDom;

    /**
     * Creates new form TelaControleFrequenciaCursosOficina
     */
    public TelaControleFrequenciaCursosAC_PEDAGOGIA() {
        initComponents();
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTabelaAtendimentoTerapia = new javax.swing.JTable();
        jPanel32 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jIDPesqLanc = new javax.swing.JTextField();
        jBtCodigoPesquisa = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jDataPesqInicial = new com.toedter.calendar.JDateChooser();
        jLabel22 = new javax.swing.JLabel();
        jDataPesqFinal = new com.toedter.calendar.JDateChooser();
        jBtPesqData = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel14 = new javax.swing.JLabel();
        jnomeInternoPesq = new javax.swing.JTextField();
        jBtPesquisarNome = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jIdRegistro = new javax.swing.JTextField();
        jStatusRegistro = new javax.swing.JTextField();
        jDataRegistro = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jDescricaoCurso = new javax.swing.JTextField();
        jBtPesquisarCurso = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLocalRealizacao = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jObservacao = new javax.swing.JTextArea();
        jPanel12 = new javax.swing.JPanel();
        jCheckBoxSeg = new javax.swing.JCheckBox();
        jCheckBoxTer = new javax.swing.JCheckBox();
        jCheckBoxQua = new javax.swing.JCheckBox();
        jCheckBoxQui = new javax.swing.JCheckBox();
        jCheckBoxSex = new javax.swing.JCheckBox();
        jCheckBoxSab = new javax.swing.JCheckBox();
        jCheckBoxDom = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxProfessor = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jBtNovo = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtFinalizar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jBtAuditoria = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jIdInternoCrc = new javax.swing.JTextField();
        jBtPesquisarInterno = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jNomeInternoCrc = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jDataEntrada = new com.toedter.calendar.JDateChooser();
        jHorarioEntrada = new javax.swing.JFormattedTextField();
        jLabel18 = new javax.swing.JLabel();
        jHorarioSaida = new javax.swing.JFormattedTextField();
        jLabel19 = new javax.swing.JLabel();
        jComboBoxConfFrequencia = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jNotaAvaliacao = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaInternos = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jBtImpressao = new javax.swing.JButton();
        jBtSairInterno = new javax.swing.JButton();
        jBtAuditoriaInterno = new javax.swing.JButton();
        jBtNovoInterno = new javax.swing.JButton();
        jBtExcluirInterno = new javax.swing.JButton();
        jBtAlterarInterno = new javax.swing.JButton();
        jBtCancelarInterno = new javax.swing.JButton();
        jBtSalvarInterno = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Controle de Frequência Cursos :::...");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jTabelaAtendimentoTerapia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaAtendimentoTerapia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Status", "Data Cadastro", "Nome do Interno"
            }
        ));
        jTabelaAtendimentoTerapia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaAtendimentoTerapiaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTabelaAtendimentoTerapia);
        if (jTabelaAtendimentoTerapia.getColumnModel().getColumnCount() > 0) {
            jTabelaAtendimentoTerapia.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaAtendimentoTerapia.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaAtendimentoTerapia.getColumnModel().getColumn(1).setMinWidth(80);
            jTabelaAtendimentoTerapia.getColumnModel().getColumn(1).setMaxWidth(80);
            jTabelaAtendimentoTerapia.getColumnModel().getColumn(2).setMinWidth(100);
            jTabelaAtendimentoTerapia.getColumnModel().getColumn(2).setMaxWidth(100);
            jTabelaAtendimentoTerapia.getColumnModel().getColumn(3).setMinWidth(510);
            jTabelaAtendimentoTerapia.getColumnModel().getColumn(3).setMaxWidth(510);
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

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Código:");

        jIDPesqLanc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIDPesqLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtCodigoPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtCodigoPesquisa.setContentAreaFilled(false);
        jBtCodigoPesquisa.setDefaultCapable(false);
        jBtCodigoPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCodigoPesquisaActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Data Inicial:");

        jDataPesqInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("Data Final:");

        jDataPesqFinal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqData.setContentAreaFilled(false);
        jBtPesqData.setDefaultCapable(false);
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

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Nome Interno:");

        jnomeInternoPesq.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesquisarNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesquisarNome.setContentAreaFilled(false);
        jBtPesquisarNome.setDefaultCapable(false);
        jBtPesquisarNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisarNomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jnomeInternoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jBtPesquisarNome, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataPesqFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqData, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jIDPesqLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtCodigoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117)
                        .addComponent(jCheckBox1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIDPesqLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtCodigoPesquisa)
                    .addComponent(jLabel13)
                    .addComponent(jCheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel21)
                    .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(jDataPesqFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtPesquisarNome)
                    .addComponent(jnomeInternoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("Listagem", jPanel1);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Status");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Data");

        jIdRegistro.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdRegistro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdRegistro.setEnabled(false);

        jStatusRegistro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jStatusRegistro.setForeground(new java.awt.Color(153, 0, 0));
        jStatusRegistro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jStatusRegistro.setDisabledTextColor(new java.awt.Color(153, 0, 0));
        jStatusRegistro.setEnabled(false);

        jDataRegistro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataRegistro.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Curso de Capacitação");

        jDescricaoCurso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDescricaoCurso.setEnabled(false);

        jBtPesquisarCurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesquisarCurso.setContentAreaFilled(false);
        jBtPesquisarCurso.setEnabled(false);
        jBtPesquisarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisarCursoActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Observação");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Local");

        jLocalRealizacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLocalRealizacao.setEnabled(false);

        jObservacao.setColumns(20);
        jObservacao.setRows(5);
        jObservacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jScrollPane2.setViewportView(jObservacao);

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
                .addGap(16, 16, 16)
                .addComponent(jCheckBoxSeg, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBoxTer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxQua, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBoxQui)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxSex, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxSab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxDom)
                .addGap(53, 53, 53))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jCheckBoxSeg)
                    .addComponent(jCheckBoxTer)
                    .addComponent(jCheckBoxQua)
                    .addComponent(jCheckBoxQui)
                    .addComponent(jCheckBoxSex)
                    .addComponent(jCheckBoxSab)
                    .addComponent(jCheckBoxDom))
                .addGap(3, 3, 3))
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Professor/Instrutor");

        jComboBoxProfessor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxProfessor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxProfessor.setEnabled(false);
        jComboBoxProfessor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxProfessorItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLocalRealizacao)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jDescricaoCurso))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesquisarCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jIdRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jStatusRegistro))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jDataRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel7)
                            .addComponent(jComboBoxProfessor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jStatusRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jDescricaoCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesquisarCurso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLocalRealizacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovo.setToolTipText("Novo");
        jBtNovo.setContentAreaFilled(false);
        jBtNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoActionPerformed(evt);
            }
        });

        jBtExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216104515_16.png"))); // NOI18N
        jBtExcluir.setToolTipText("Excluir");
        jBtExcluir.setContentAreaFilled(false);
        jBtExcluir.setEnabled(false);
        jBtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirActionPerformed(evt);
            }
        });

        jBtAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterar.setToolTipText("Alterar");
        jBtAlterar.setContentAreaFilled(false);
        jBtAlterar.setEnabled(false);
        jBtAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarActionPerformed(evt);
            }
        });

        jBtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelar.setToolTipText("Cancelar");
        jBtCancelar.setContentAreaFilled(false);
        jBtCancelar.setEnabled(false);
        jBtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarActionPerformed(evt);
            }
        });

        jBtSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvar.setToolTipText("Gravar");
        jBtSalvar.setContentAreaFilled(false);
        jBtSalvar.setEnabled(false);
        jBtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarActionPerformed(evt);
            }
        });

        jBtFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/tick.png"))); // NOI18N
        jBtFinalizar.setToolTipText("Finalizar");
        jBtFinalizar.setContentAreaFilled(false);
        jBtFinalizar.setEnabled(false);
        jBtFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFinalizarActionPerformed(evt);
            }
        });

        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSair.setToolTipText("Sair");
        jBtSair.setContentAreaFilled(false);
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        jBtAuditoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoria.setToolTipText("Auditoria");
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jBtFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jBtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jBtExcluir)
                        .addComponent(jBtAlterar)
                        .addComponent(jBtCancelar)
                        .addComponent(jBtSalvar)
                        .addComponent(jBtFinalizar)
                        .addComponent(jBtNovo)
                        .addComponent(jBtSair, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jBtAuditoria))
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Manutenção", jPanel2);

        jPanel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Código");

        jIdInternoCrc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdInternoCrc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdInternoCrc.setEnabled(false);

        jBtPesquisarInterno.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtPesquisarInterno.setForeground(new java.awt.Color(0, 204, 0));
        jBtPesquisarInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesquisarInterno.setContentAreaFilled(false);
        jBtPesquisarInterno.setEnabled(false);
        jBtPesquisarInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisarInternoActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Nome do Interno");

        jNomeInternoCrc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoCrc.setEnabled(false);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Data Frequência");

        jDataEntrada.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataEntrada.setEnabled(false);

        jHorarioEntrada.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHorarioEntrada.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jHorarioEntrada.setEnabled(false);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Hora Entrada");

        jHorarioSaida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHorarioSaida.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jHorarioSaida.setEnabled(false);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Hora Saída");

        jComboBoxConfFrequencia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxConfFrequencia.setForeground(new java.awt.Color(153, 0, 51));
        jComboBoxConfFrequencia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Presente", "Ausente" }));
        jComboBoxConfFrequencia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxConfFrequencia.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Conf. Frequência");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Nota Avaliação");

        jNotaAvaliacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNotaAvaliacao.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jNotaAvaliacao.setEnabled(false);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jHorarioEntrada))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jHorarioSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 41, Short.MAX_VALUE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jNotaAvaliacao)
                                .addContainerGap())))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                .addComponent(jIdInternoCrc, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesquisarInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxConfFrequencia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jNomeInternoCrc))
                        .addContainerGap())))
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jHorarioEntrada, jHorarioSaida});

        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jIdInternoCrc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesquisarInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNomeInternoCrc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel6))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jHorarioEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jHorarioSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jNotaAvaliacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxConfFrequencia, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaInternos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaInternos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Registro", "Nome do Interno", "Data Entrada", "Horário Entrada", "Horário Saída", "Nota Avaliação", "Frequência"
            }
        ));
        jTabelaInternos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaInternosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaInternos);
        if (jTabelaInternos.getColumnModel().getColumnCount() > 0) {
            jTabelaInternos.getColumnModel().getColumn(0).setMinWidth(60);
            jTabelaInternos.getColumnModel().getColumn(0).setMaxWidth(60);
            jTabelaInternos.getColumnModel().getColumn(1).setMinWidth(60);
            jTabelaInternos.getColumnModel().getColumn(1).setMaxWidth(60);
            jTabelaInternos.getColumnModel().getColumn(2).setMinWidth(300);
            jTabelaInternos.getColumnModel().getColumn(2).setMaxWidth(300);
            jTabelaInternos.getColumnModel().getColumn(3).setMinWidth(80);
            jTabelaInternos.getColumnModel().getColumn(3).setMaxWidth(80);
            jTabelaInternos.getColumnModel().getColumn(4).setMinWidth(80);
            jTabelaInternos.getColumnModel().getColumn(4).setMaxWidth(80);
            jTabelaInternos.getColumnModel().getColumn(5).setMinWidth(80);
            jTabelaInternos.getColumnModel().getColumn(5).setMaxWidth(80);
            jTabelaInternos.getColumnModel().getColumn(6).setMinWidth(90);
            jTabelaInternos.getColumnModel().getColumn(6).setMaxWidth(90);
            jTabelaInternos.getColumnModel().getColumn(7).setMinWidth(80);
            jTabelaInternos.getColumnModel().getColumn(7).setMaxWidth(80);
        }

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtImpressao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtImpressao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/gtklp-icone-3770-16.png"))); // NOI18N
        jBtImpressao.setToolTipText("Impressão");
        jBtImpressao.setContentAreaFilled(false);
        jBtImpressao.setEnabled(false);
        jBtImpressao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtImpressaoActionPerformed(evt);
            }
        });

        jBtSairInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSairInterno.setToolTipText("Sair");
        jBtSairInterno.setContentAreaFilled(false);
        jBtSairInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairInternoActionPerformed(evt);
            }
        });

        jBtAuditoriaInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaInterno.setToolTipText("Auditoria");
        jBtAuditoriaInterno.setContentAreaFilled(false);
        jBtAuditoriaInterno.setEnabled(false);
        jBtAuditoriaInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaInternoActionPerformed(evt);
            }
        });

        jBtNovoInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoInterno.setToolTipText("Novo");
        jBtNovoInterno.setContentAreaFilled(false);
        jBtNovoInterno.setEnabled(false);
        jBtNovoInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoInternoActionPerformed(evt);
            }
        });

        jBtExcluirInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216104515_16.png"))); // NOI18N
        jBtExcluirInterno.setToolTipText("Excluir");
        jBtExcluirInterno.setContentAreaFilled(false);
        jBtExcluirInterno.setEnabled(false);
        jBtExcluirInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirInternoActionPerformed(evt);
            }
        });

        jBtAlterarInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarInterno.setToolTipText("Alterar");
        jBtAlterarInterno.setContentAreaFilled(false);
        jBtAlterarInterno.setEnabled(false);
        jBtAlterarInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarInternoActionPerformed(evt);
            }
        });

        jBtCancelarInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarInterno.setToolTipText("Cancelar");
        jBtCancelarInterno.setContentAreaFilled(false);
        jBtCancelarInterno.setEnabled(false);
        jBtCancelarInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarInternoActionPerformed(evt);
            }
        });

        jBtSalvarInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarInterno.setToolTipText("Gravar");
        jBtSalvarInterno.setContentAreaFilled(false);
        jBtSalvarInterno.setEnabled(false);
        jBtSalvarInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarInternoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtNovoInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelarInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jBtImpressao, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jBtSairInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtImpressao)
                    .addComponent(jBtExcluirInterno)
                    .addComponent(jBtAlterarInterno)
                    .addComponent(jBtCancelarInterno)
                    .addComponent(jBtSalvarInterno)
                    .addComponent(jBtNovoInterno)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jBtSairInterno, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jBtAuditoriaInterno)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Participantes", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
        );

        setBounds(300, 40, 432, 451);
    }// </editor-fold>//GEN-END:initComponents

    private void jTabelaAtendimentoTerapiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaAtendimentoTerapiaMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            String idAtend = "" + jTabelaAtendimentoTerapia.getValueAt(jTabelaAtendimentoTerapia.getSelectedRow(), 0);
            jIDPesqLanc.setText(idAtend);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            //
            jBtNovoInterno.setEnabled(true);
            jBtImpressao.setEnabled(true);
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM FREQUENCIA_CAPACITACAO_INTERNO_TO "
                        + "INNER JOIN CURSOS "
                        + "ON CURSOS.IdCurso=FREQUENCIA_CAPACITACAO_INTERNO_TO.IdCurso "
                        + "WHERE IdFreqCap='" + idAtend + "'");
                conecta.rs.first();
                jIdRegistro.setText(String.valueOf(conecta.rs.getInt("IdFreqCap")));
                jStatusRegistro.setText(conecta.rs.getString("StatusRegistro"));
                jDataRegistro.setDate(conecta.rs.getDate("DataRegistro"));
                jDescricaoCurso.setText(conecta.rs.getString("DescricaoCurso"));
                jLocalRealizacao.setText(conecta.rs.getString("LocalCurso"));
                jObservacao.setText(conecta.rs.getString("Observacao"));
            } catch (Exception e) {
            }
            conecta.desconecta();
        }
        preencherItensInternos("SELECT * FROM ITENS_FREQUENCIA_CAPACITACAO_INTERNO_TO "
                + "INNER JOIN PRONTUARIOSCRC "
                + "ON ITENS_FREQUENCIA_CAPACITACAO_INTERNO_TO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                + "INNER JOIN FREQUENCIA_CAPACITACAO_INTERNO_TO "
                + "ON ITENS_FREQUENCIA_CAPACITACAO_INTERNO_TO.IdFreqCap=FREQUENCIA_CAPACITACAO_INTERNO_TO.IdFreqCap "
                + "WHERE ITENS_FREQUENCIA_CAPACITACAO_INTERNO_TO.IdFreqCap='" + jIDPesqLanc.getText() + "'");
    }//GEN-LAST:event_jTabelaAtendimentoTerapiaMouseClicked

    private void jBtCodigoPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCodigoPesquisaActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (jIDPesqLanc.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um ID para pesquisar.");
        } else {
            preencherTabelaTodosRegistros("SELECT * FROM FREQUENCIA_CAPACITACAO_INTERNO_TO "
                    + "WHERE IdFreqCap='" + jIDPesqLanc.getText() + "'");
        }
    }//GEN-LAST:event_jBtCodigoPesquisaActionPerformed

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
                if (jDataPesqFinal.getDate() == null) {
                    JOptionPane.showMessageDialog(rootPane, "Informe a data final para pesquisa.");
                    jDataPesqFinal.requestFocus();
                } else {
                    if (jDataPesqInicial.getDate().after(jDataPesqFinal.getDate())) {
                        JOptionPane.showMessageDialog(rootPane, "Data Inicial não pode ser maior que data final");
                    } else {
                        SimpleDateFormat formatoAmerica = new SimpleDateFormat("yyyy/MM/dd");
                        dataInicial = formatoAmerica.format(jDataPesqInicial.getDate().getTime());
                        dataFinal = formatoAmerica.format(jDataPesqFinal.getDate().getTime());
                        preencherTabelaTodosRegistros("SELECT * FROM FREQUENCIA_CAPACITACAO_INTERNO_TO "
                                + "WHERE DataRegistro BETWEEN'" + dataInicial + "' "
                                + "AND'" + dataFinal + "'");
                    }
                }
            }
        } else if (tipoServidor.equals("Servidor Windows/MS-SQL Server")) {
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
                        preencherTabelaTodosRegistros("SELECT * FROM FREQUENCIA_CAPACITACAO_INTERNO_TO "
                                + "WHERE DataRegistro BETWEEN'" + dataInicial + "' "
                                + "AND'" + dataFinal + "'");
                    }
                }
            }
        }
    }//GEN-LAST:event_jBtPesqDataActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherTabelaTodosRegistros("SELECT * FROM FREQUENCIA_CAPACITACAO_INTERNO_TO");
        } else {
            jtotalRegistros.setText("");
            limparTabela();
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jBtPesquisarNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisarNomeActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (jnomeInternoPesq.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o nome do interno para pesquisar.");
        } else {
            jTabelaAtendimentoTerapia.setVisible(true);
            preencherAtendimentoTerapia("SELECT * FROM FREQUENCIA_CAPACITACAO_INTERNO_TO "
                    + "INNER JOIN ITENS_FREQUENCIA_CAPACITACAO_INTERNO_TO "
                    + "ON FREQUENCIA_CAPACITACAO_INTERNO_TO.IdFreqCap=ITENS_FREQUENCIA_CAPACITACAO_INTERNO_TO.IdFreqCap "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENS_FREQUENCIA_CAPACITACAO_INTERNO_TO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE PRONTUARIOSCRC.NomeInternoCrc LIKE'%" + jnomeInternoPesq.getText() + "%'");
        }
    }//GEN-LAST:event_jBtPesquisarNomeActionPerformed

    private void jBtFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFinalizarActionPerformed
        // TODO add your handling code here:
        verificarSitaucaoCurso();
        if (jIdRegistro.getText().equals(codigoRegistro) && pSitaucaoCurso.equals(pSituacaoInterno)) {
            JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser FINALIZADO, existe internos com a situação do curso ainda não concluído.");
        } else {
            objFreqCap.setStatusRegistro(jStatusRegistro.getText());
            if (jStatusRegistro.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa registro não poderá ser finalizado, o mesmo encontra-se FINALIZADO");
            } else {
                objFreqCap.setStatusRegistro("");
                String statusAtend = "FINALIZADO";
                JOptionPane.showMessageDialog(rootPane, "Se esse registro for finaliza,\nvocê não poderá mais excluir ou alterar.");
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente FINALIZA o registro selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    objFreqCap.setStatusRegistro(statusAtend);
                    objFreqCap.setIdFreqCap(Integer.parseInt(jIdRegistro.getText()));
//                    control.finalizarFrequenciaCapacitacao(objFreqCap);
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    jStatusRegistro.setText(statusAtend);
                    JOptionPane.showMessageDialog(rootPane, "Registro FINALIZADO com sucesso !!!");
                }
            }
        }
    }//GEN-LAST:event_jBtFinalizarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtAuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaCapacitacaoPEDA objAudiCap = new TelaAuditoriaCapacitacaoPEDA();
        TelaModuloPedagogia.jPainelPedagogia.add(objAudiCap);
        objAudiCap.show();
    }//GEN-LAST:event_jBtAuditoriaActionPerformed

    private void jBtPesquisarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisarCursoActionPerformed
        // TODO add your handling code here:
        TelaPesqCursosFreqCapacitacao_PEDA objPesqCurso = new TelaPesqCursosFreqCapacitacao_PEDA();
        TelaModuloPedagogia.jPainelPedagogia.add(objPesqCurso);
        objPesqCurso.show();
    }//GEN-LAST:event_jBtPesquisarCursoActionPerformed

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaFreqCapacitacaoInternoManuTO);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTO.equals("ADMINISTRADORES") || codigoUserTO == codUserAcessoTO && nomeTelaTO.equals(telaFreqCapacitacaoInternoManuTO) && codIncluirTO == 1) {
            acao = 1;
            bloquearCampos();
            bloquearBotoes();
            limparCampos();
            limparTabelaInternos();
            Novo();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirActionPerformed
//         TODO add your handling code here:
        buscarAcessoUsuario(telaFreqCapacitacaoInternoManuTO);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTO.equals("ADMINISTRADORES") || codigoUserTO == codUserAcessoTO && nomeTelaTO.equals(telaFreqCapacitacaoInternoManuTO) && codExcluirTO == 1) {
            verificarInternoCapacitado();
            if (jIdRegistro.getText().equals(codigoRegistro)) {
                JOptionPane.showMessageDialog(rootPane, "Não é possível excluir esse registro, existe um ou mais registro de internos relacionados a ele.\nÉ necessário excluir os registros de internos abaixo primeiro.");
            } else {
                objFreqCap.setStatusRegistro(jStatusRegistro.getText());
                if (jStatusRegistro.getText().equals("FINALIZADO")) {
                    JOptionPane.showMessageDialog(rootPane, "Essa registro não poderá ser excluído, o mesmo encontra-se FINALIZADO");
                } else {
                    statusMov = "Excluiu";
                    horaMov = jHoraSistema.getText();
                    dataModFinal = jDataSistema.getText();
                    objFreqCap.setStatusRegistro(jStatusRegistro.getText());
                    if (jStatusRegistro.getText().equals("FINALIZADO")) {
                        JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser excluido, o mesmo encontra-se FINALIZADO");
                    } else {
                        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                                JOptionPane.YES_NO_OPTION);
                        if (resposta == JOptionPane.YES_OPTION) {
                            objFreqCap.setIdFreqCap(Integer.parseInt(jIdRegistro.getText()));
//                            control.excluirFrequenciaCapacitacao(objFreqCap);
                            objLog();
                            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                            bloquearCampos();
                            bloquearBotoes();
                            Excluir();
                            JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                        }
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaFreqCapacitacaoInternoManuTO);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTO.equals("ADMINISTRADORES") || codigoUserTO == codUserAcessoTO && nomeTelaTO.equals(telaFreqCapacitacaoInternoManuTO) && codAlterarTO == 1) {
            objFreqCap.setStatusRegistro(jStatusRegistro.getText());
            if (jStatusRegistro.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa registro não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 2;
                bloquearCampos();
                bloquearBotoes();
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

    private void jBtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarActionPerformed
        // TODO add your handling code here:
        Cancelar();
    }//GEN-LAST:event_jBtCancelarActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaFreqCapacitacaoInternoManuTO);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTO.equals("ADMINISTRADORES") || codigoUserTO == codUserAcessoTO && nomeTelaTO.equals(telaFreqCapacitacaoInternoManuTO) && codGravarTO == 1) {
            if (jDataRegistro.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data de cadastro.");
            } else if (jDescricaoCurso.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o curso de capacitação.");
            } else {
                objFreqCap.setStatusRegistro(jStatusRegistro.getText());
                objFreqCap.setDataRegistro(jDataRegistro.getDate());
                objFreqCap.setIdCurso(codigoCurso);
                objFreqCap.setDescricaoCurso(jDescricaoCurso.getText());
                objFreqCap.setLocalCurso(jLocalRealizacao.getText());
                //SEGUNDA
                if (jCheckBoxSeg.isSelected()) {
                    DIA_SEG = 1;
                } else if (!jCheckBoxSeg.isSelected()) {
                    DIA_SEG = 0;
                }
                objFreqCap.setDia2(DIA_SEG);
                //TERÇA
                if (jCheckBoxTer.isSelected()) {
                    DIA_TER = 1;
                } else if (!jCheckBoxTer.isSelected()) {
                    DIA_TER = 0;
                }
                objFreqCap.setDia3(DIA_TER);
                //QUARTA
                if (jCheckBoxQua.isSelected()) {
                    DIA_QUA = 1;
                } else if (!jCheckBoxQua.isSelected()) {
                    DIA_QUA = 0;
                }
                objFreqCap.setDia4(DIA_QUA);
                //QUINTA
                if (jCheckBoxQui.isSelected()) {
                    DIA_QUI = 1;
                } else if (!jCheckBoxQui.isSelected()) {
                    DIA_QUI = 0;
                }
                objFreqCap.setDia5(DIA_QUI);
                //SEXTA
                if (jCheckBoxSex.isSelected()) {
                    DIA_SEX = 1;
                } else if (!jCheckBoxSex.isSelected()) {
                    DIA_SEX = 0;
                }
                objFreqCap.setDia6(DIA_SEX);
                //SÁBADO
                if (jCheckBoxSab.isSelected()) {
                    DIA_SAB = 1;
                } else if (!jCheckBoxSab.isSelected()) {
                    DIA_SAB = 0;
                }
                objFreqCap.setDia7(DIA_SAB);
                //DOMINGO
                if (jCheckBoxDom.isSelected()) {
                    DIA_DOM = 1;
                } else if (!jCheckBoxDom.isSelected()) {
                    DIA_DOM = 0;
                }
                objFreqCap.setDia8(DIA_DOM);
                objFreqCap.setObservacao(jObservacao.getText());
                if (acao == 1) {
                    // log de usuario
                    objFreqCap.setUsuarioInsert(nameUser);
                    objFreqCap.setDataInsert(dataModFinal);
                    objFreqCap.setHorarioInsert(horaMov);
                    //
//                    control.incluirFrequenciaCapacitacao(objFreqCap);
                    buscarCodigo();
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    JOptionPane.showMessageDialog(rootPane, "Registro Gravado com sucesso.");
                    bloquearCampos();
                    bloquearBotoes();
                    Salvar();
                }
                if (acao == 2) {
                    objFreqCap.setUsuarioUp(nameUser);
                    objFreqCap.setDataUp(dataModFinal);
                    objFreqCap.setHorarioUp(horaMov);
                    //
                    objFreqCap.setIdFreqCap(Integer.valueOf(jIdRegistro.getText()));
//                    control.alterarFrequenciaCapacitacao(objFreqCap);
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    JOptionPane.showMessageDialog(rootPane, "Registro Gravado com sucesso.");
                    bloquearCampos();
                    bloquearBotoes();
                    Salvar();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtSalvarActionPerformed

    private void jBtPesquisarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisarInternoActionPerformed
        // TODO add your handling code here:
        TelaPesqInternoFreqCapacitacaoPEDA objPesqIntFreq = new TelaPesqInternoFreqCapacitacaoPEDA();
        TelaModuloPedagogia.jPainelPedagogia.add(objPesqIntFreq);
        objPesqIntFreq.show();
    }//GEN-LAST:event_jBtPesquisarInternoActionPerformed

    private void jBtSairInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairInternoActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairInternoActionPerformed

    private void jBtAuditoriaInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaInternoActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaItensCapacitacaoPEDA objAudiItens = new TelaAuditoriaItensCapacitacaoPEDA();
        TelaModuloPedagogia.jPainelPedagogia.add(objAudiItens);
        objAudiItens.show();
    }//GEN-LAST:event_jBtAuditoriaInternoActionPerformed

    private void jBtNovoInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoInternoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaFreqCapacitacaoInternoIntTO);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTO.equals("ADMINISTRADORES") || codigoUserTO == codUserAcessoTO && nomeTelaTO.equals(telaFreqCapacitacaoInternoIntTO) && codIncluirTO == 1) {
            objFreqCap.setStatusRegistro(jStatusRegistro.getText());
            if (jStatusRegistro.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa registro não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 3;
                bloquearCampos();
                bloquearBotoes();
                limparCamposInternos();
                NovoInterno();
                statusMov = "Incluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovoInternoActionPerformed

    private void jBtExcluirInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirInternoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaFreqCapacitacaoInternoIntTO);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTO.equals("ADMINISTRADORES") || codigoUserTO == codUserAcessoTO && nomeTelaTO.equals(telaFreqCapacitacaoInternoIntTO) && codExcluirTO == 1) {
            objFreqCap.setStatusRegistro(jStatusRegistro.getText());
            if (jStatusRegistro.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa registro não poderá ser excluído, o mesmo encontra-se FINALIZADO");
            } else {
                statusMov = "Excluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
                objFreqCap.setStatusRegistro(jStatusRegistro.getText());
                if (jStatusRegistro.getText().equals("FINALIZADO")) {
                    JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser excluido, o mesmo encontra-se FINALIZADO");
                } else {
                    int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                            JOptionPane.YES_NO_OPTION);
                    if (resposta == JOptionPane.YES_OPTION) {
                        objFreqCap.setIdItemFreqCap(codigoItem);
//                        control.excluirInternoFrequenciaCapacitacao(objFreqCap);
                        objLog2();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        preencherItensInternos("SELECT * FROM ITENS_FREQUENCIA_CAPACITACAO_INTERNO_TO "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON ITENS_FREQUENCIA_CAPACITACAO_INTERNO_TO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                + "INNER JOIN FREQUENCIA_CAPACITACAO_INTERNO_TO "
                                + "ON ITENS_FREQUENCIA_CAPACITACAO_INTERNO_TO.IdFreqCap=CAPACITACAO_INTERNO_TO.IdFreqCap "
                                + "WHERE ITENS_FREQUENCIA_CAPACITACAO_INTERNO_TO.IdFreqCap='" + jIdRegistro.getText() + "'");
                        limparCamposInternos();
                        bloquearCampos();
                        bloquearBotoes();
                        ExcluirInterno();
                        JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirInternoActionPerformed

    private void jBtAlterarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarInternoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaFreqCapacitacaoInternoIntTO);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTO.equals("ADMINISTRADORES") || codigoUserTO == codUserAcessoTO && nomeTelaTO.equals(telaFreqCapacitacaoInternoIntTO) && codAlterarTO == 1) {
            objFreqCap.setStatusRegistro(jStatusRegistro.getText());
            if (jStatusRegistro.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa registro não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 4;
                bloquearCampos();
                bloquearBotoes();
                AlterarInterno();
                statusMov = "Incluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtAlterarInternoActionPerformed

    private void jBtCancelarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarInternoActionPerformed
        // TODO add your handling code here:
        bloquearBotoes();
        bloquearCampos();
        CancelarInterno();
    }//GEN-LAST:event_jBtCancelarInternoActionPerformed

    private void jBtSalvarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarInternoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaFreqCapacitacaoInternoIntTO);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTO.equals("ADMINISTRADORES") || codigoUserTO == codUserAcessoTO && nomeTelaTO.equals(telaFreqCapacitacaoInternoIntTO) && codGravarTO == 1) {
            if (jIdInternoCrc.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário informar o nome do interno.");
            } else if (jNomeInternoCrc.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário informar o nome do interno.");
            } else if (jDataEntrada.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data de entrada na sala dop interno.");
            } else if (jHorarioEntrada.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o horário de entrada na aula do interno.");
            } else if (jComboBoxConfFrequencia.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(rootPane, "Informe a presença ou ausência do interno.");
            } else {
                DecimalFormat valorReal = new DecimalFormat("###,##00.0");
                valorReal.setCurrency(Currency.getInstance(new Locale("pt", "BR")));
                objFreqCap.setIdInterno(Integer.valueOf(jIdInternoCrc.getText()));
                objFreqCap.setNomeInterno(jNomeInternoCrc.getText());
                objFreqCap.setDataEntrada(jDataEntrada.getDate());
                objFreqCap.setHorariaEntrada(jHorarioEntrada.getText());
                objFreqCap.setHorarioSaida(jHorarioSaida.getText());
                objFreqCap.setFrequencia((String) jComboBoxConfFrequencia.getSelectedItem());
                objFreqCap.setIdFreqCap(Integer.valueOf(jIdRegistro.getText()));
                try {
                    objFreqCap.setNotaAvaliacao(valorReal.parse(jNotaAvaliacao.getText()).floatValue());
                } catch (ParseException ex) {
                    Logger.getLogger(TelaCapacitacaoInternoTO.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (acao == 3) {
                    objFreqCap.setUsuarioInsert(nameUser);
                    objFreqCap.setDataInsert(dataModFinal);
                    objFreqCap.setHorarioInsert(horaMov);
                    //
//                    control.incluirInternoFrequenciaCapacitacao(objFreqCap);
                    buscarCampoRegistroInterno();
                    objLog2();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    preencherItensInternos("SELECT * FROM ITENS_FREQUENCIA_CAPACITACAO_INTERNO_TO "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON ITENS_FREQUENCIA_CAPACITACAO_INTERNO_TO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "INNER JOIN FREQUENCIA_CAPACITACAO_INTERNO_TO "
                            + "ON ITENS_FREQUENCIA_CAPACITACAO_INTERNO_TO.IdFreqCap=FREQUENCIA_CAPACITACAO_INTERNO_TO.IdFreqCap "
                            + "WHERE ITENS_FREQUENCIA_CAPACITACAO_INTERNO_TO.IdFreqCap='" + jIdRegistro.getText() + "'");
                    limparCamposInternos();
                    bloquearCampos();
                    bloquearBotoes();
                    SalvarInterno();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso !!!");
                }
                if (acao == 4) {
                    objFreqCap.setUsuarioUp(nameUser);
                    objFreqCap.setDataUp(dataModFinal);
                    objFreqCap.setHorarioUp(horaMov);
                    //
                    objFreqCap.setIdItemFreqCap(codigoItem);
//                    control.alterarInternoFrequenciaCapacitacao(objFreqCap);
                    objLog2();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    preencherItensInternos("SELECT * FROM ITENS_FREQUENCIA_CAPACITACAO_INTERNO_TO "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON ITENS_FREQUENCIA_CAPACITACAO_INTERNO_TO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "INNER JOIN FREQUENCIA_CAPACITACAO_INTERNO_TO "
                            + "ON ITENS_FREQUENCIA_CAPACITACAO_INTERNO_TO.IdFreqCap=FREQUENCIA_CAPACITACAO_INTERNO_TO.IdFreqCap "
                            + "WHERE ITENS_FREQUENCIA_CAPACITACAO_INTERNO_TO.IdFreqCap='" + jIdRegistro.getText() + "'");
                    limparCamposInternos();
                    bloquearCampos();
                    bloquearBotoes();
                    SalvarInterno();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso !!!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtSalvarInternoActionPerformed

    private void jTabelaInternosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaInternosMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            String idInternoCrc = "" + jTabelaInternos.getValueAt(jTabelaInternos.getSelectedRow(), 1);
            jIdInternoCrc.setText(idInternoCrc);
            String nomeInternoCrc = "" + jTabelaInternos.getValueAt(jTabelaInternos.getSelectedRow(), 2);
            jNomeInternoCrc.setText(nomeInternoCrc);
            idItem = "" + jTabelaInternos.getValueAt(jTabelaInternos.getSelectedRow(), 0);
            //
            // limparCampos();
            bloquearCampos();
            bloquearBotoes();
            //
            jBtNovoInterno.setEnabled(true);
            jBtAlterarInterno.setEnabled(true);
            jBtExcluirInterno.setEnabled(true);
            jBtCancelarInterno.setEnabled(true);
            jBtAuditoriaInterno.setEnabled(true);
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ITENS_FREQUENCIA_CAPACITACAO_INTERNO_TO "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ITENS_FREQUENCIA_CAPACITACAO_INTERNO_TO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE ITENS_FREQUENCIA_CAPACITACAO_INTERNO_TO.IdFreqCap='" + jIdRegistro.getText() + "' "
                        + "AND PRONTUARIOSCRC.NomeInternoCrc='" + jNomeInternoCrc.getText() + "' "
                        + "AND IdItemFreqCap='" + idItem + "'");
                conecta.rs.first();
                codigoItem = conecta.rs.getInt("IdItemFreqCap");
                jIdInternoCrc.setText(String.valueOf(conecta.rs.getInt("IdInternoCrc")));
                jNomeInternoCrc.setText(conecta.rs.getString("NomeInternoCrc"));
                jDataEntrada.setDate(conecta.rs.getDate("DataEntrada"));
                jHorarioEntrada.setText(conecta.rs.getString("HoraEntrada"));
                jHorarioSaida.setText(conecta.rs.getString("HoraSaida"));
                jComboBoxConfFrequencia.setSelectedItem(conecta.rs.getString("Frequencia"));
                notaAvaliacao = conecta.rs.getFloat("NotaAvalia");
                if (notaAvaliacao != null) {
                    DecimalFormat na = new DecimalFormat("#,##0.00");
                    String vlCusto = na.format(notaAvaliacao);
                    jNotaAvaliacao.setText(vlCusto);
                }
                conecta.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa..." + e);
            }
        }
    }//GEN-LAST:event_jTabelaInternosMouseClicked

    private void jBtImpressaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImpressaoActionPerformed
        // TODO add your handling code here:telaControleFrequenciaPrin_PEDA
        buscarAcessoUsuario(telaFreqCapacitacaoInternoManuTO);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTO.equals("ADMINISTRADORES") || codigoUserTO == codUserAcessoTO && nomeTelaTO.equals(telaFreqCapacitacaoInternoManuTO) && codAbrirTO == 1) {
            try {
                conecta.abrirConexao();
                String path = "reports/RelatorioFrequenciaCursosTO.jasper";
                conecta.executaSQL("SELECT * FROM FREQUENCIA_CAPACITACAO_INTERNO_TO "
                        + "INNER JOIN CURSOS "
                        + "ON CURSOS.IdCurso=FREQUENCIA_CAPACITACAO_INTERNO_TO.IdCurso "
                        + "WHERE IdFreqCap='" + jIdRegistro.getText() + "'");
                HashMap parametros = new HashMap();
                parametros.put("codFrequencia", jIdRegistro.getText());
                parametros.put("descricaoUnidade", descricaoUnidade);
                parametros.put("nomeUsuario", nameUser);
                // Sub Relatório
                try {
                    parametros.put("REPORT_CONNECTION", conecta.stmt.getConnection());
                } catch (SQLException ex) {
                }
                JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio
                JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
                JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao
                jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
                jv.setTitle("Relatório de Frequência de Internos");
                jv.setVisible(true); // Chama o relatorio para ser visualizado
                jv.toFront(); // Traz o relatorio para frente da aplicação
                conecta.desconecta();
            } catch (JRException e) {
                JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtImpressaoActionPerformed

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
//            objAtivi.setIdProf(professores.getIdProf());
        }
    }//GEN-LAST:event_jComboBoxProfessorItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtAlterarInterno;
    private javax.swing.JButton jBtAuditoria;
    private javax.swing.JButton jBtAuditoriaInterno;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtCancelarInterno;
    private javax.swing.JButton jBtCodigoPesquisa;
    private javax.swing.JButton jBtExcluir;
    private javax.swing.JButton jBtExcluirInterno;
    private javax.swing.JButton jBtFinalizar;
    private javax.swing.JButton jBtImpressao;
    private javax.swing.JButton jBtNovo;
    private javax.swing.JButton jBtNovoInterno;
    private javax.swing.JButton jBtPesqData;
    private javax.swing.JButton jBtPesquisarCurso;
    private javax.swing.JButton jBtPesquisarInterno;
    private javax.swing.JButton jBtPesquisarNome;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSairInterno;
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JButton jBtSalvarInterno;
    private javax.swing.JCheckBox jCheckBox1;
    public static javax.swing.JCheckBox jCheckBoxDom;
    public static javax.swing.JCheckBox jCheckBoxQua;
    public static javax.swing.JCheckBox jCheckBoxQui;
    public static javax.swing.JCheckBox jCheckBoxSab;
    public static javax.swing.JCheckBox jCheckBoxSeg;
    public static javax.swing.JCheckBox jCheckBoxSex;
    public static javax.swing.JCheckBox jCheckBoxTer;
    private javax.swing.JComboBox jComboBoxConfFrequencia;
    public static javax.swing.JComboBox<Object> jComboBoxProfessor;
    private com.toedter.calendar.JDateChooser jDataEntrada;
    private com.toedter.calendar.JDateChooser jDataPesqFinal;
    private com.toedter.calendar.JDateChooser jDataPesqInicial;
    private com.toedter.calendar.JDateChooser jDataRegistro;
    public static javax.swing.JTextField jDescricaoCurso;
    private javax.swing.JFormattedTextField jHorarioEntrada;
    private javax.swing.JFormattedTextField jHorarioSaida;
    private javax.swing.JTextField jIDPesqLanc;
    public static javax.swing.JTextField jIdInternoCrc;
    public static javax.swing.JTextField jIdRegistro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jLocalRealizacao;
    public static javax.swing.JTextField jNomeInternoCrc;
    private javax.swing.JFormattedTextField jNotaAvaliacao;
    private javax.swing.JTextArea jObservacao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jStatusRegistro;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTabelaAtendimentoTerapia;
    private javax.swing.JTable jTabelaInternos;
    private javax.swing.JTextField jnomeInternoPesq;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void corCampos() {
        jIdRegistro.setBackground(Color.white);
        jStatusRegistro.setBackground(Color.white);
        jDataRegistro.setBackground(Color.white);
        jDescricaoCurso.setBackground(Color.white);
        jLocalRealizacao.setBackground(Color.white);
        jObservacao.setBackground(Color.white);
        //
        jIdInternoCrc.setBackground(Color.white);
        jNomeInternoCrc.setBackground(Color.white);
        jDataEntrada.setBackground(Color.white);
        jHorarioEntrada.setBackground(Color.white);
        jHorarioSaida.setBackground(Color.white);
        jComboBoxConfFrequencia.setBackground(Color.white);
        jNotaAvaliacao.setBackground(Color.white);
    }

    public void bloquearCampos() {
        jIdRegistro.setEnabled(!true);
        jStatusRegistro.setEnabled(!true);
        jDataRegistro.setEnabled(!true);
        jDescricaoCurso.setEnabled(!true);
        jLocalRealizacao.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jIdInternoCrc.setEnabled(!true);
        jNomeInternoCrc.setEnabled(!true);
        jDataEntrada.setEnabled(!true);
        jHorarioEntrada.setEnabled(!true);
        jHorarioSaida.setEnabled(!true);
        jComboBoxConfFrequencia.setEnabled(!true);
        jNotaAvaliacao.setEnabled(!true);
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
        jBtPesquisarCurso.setEnabled(!true);
        jBtPesquisarInterno.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(!true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
    }

    public void limparCampos() {
        jIdRegistro.setText("");
        jStatusRegistro.setText("");
        jDataRegistro.setDate(null);
        jDescricaoCurso.setText("");
        jLocalRealizacao.setText("");
        jObservacao.setText("");
        //
        jIdInternoCrc.setText("");
        jNomeInternoCrc.setText("");
        jDataEntrada.setDate(null);
        jHorarioEntrada.setText("");
        jHorarioSaida.setText("");
        jNotaAvaliacao.setText("");
        jComboBoxConfFrequencia.setSelectedItem("Selecione...");
    }

    public void limparCamposInternos() {
        jIdInternoCrc.setText("");
        jIdInternoCrc.setText("");
        jNomeInternoCrc.setText("");
        jDataEntrada.setDate(null);
        jHorarioEntrada.setText("");
        jHorarioSaida.setText("");
        jNotaAvaliacao.setText("");
        jComboBoxConfFrequencia.setSelectedItem(null);
    }

    public void Novo() {
        jStatusRegistro.setText("ABERTO");
        jDataRegistro.setCalendar(Calendar.getInstance());
        jDataRegistro.setEnabled(true);
        jLocalRealizacao.setEnabled(true);
        jObservacao.setEnabled(true);
        //
        jBtPesquisarCurso.setEnabled(true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
    }

    public void Alterar() {
        jDataRegistro.setEnabled(true);
        jLocalRealizacao.setEnabled(true);
        jObservacao.setEnabled(true);
        //
        jBtPesquisarCurso.setEnabled(true);
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
        //
        jBtNovoInterno.setEnabled(true);
    }

    public void Cancelar() {
        if (jIdRegistro.getText().equals("")) {
            limparCampos();
            bloquearBotoes();
            bloquearCampos();
            //
            jBtNovo.setEnabled(true);
        } else {
            bloquearBotoes();
            bloquearCampos();
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            //
            jBtNovoInterno.setEnabled(true);
        }
    }

    public void buscarCodigo() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM FREQUENCIA_CAPACITACAO_INTERNO_TO");
            conecta.rs.last();
            jIdRegistro.setText(conecta.rs.getString("IdFreqCap"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter o código do registro.");
        }
        conecta.desconecta();
    }

    public void verificarInternoCapacitado() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENS_FREQUENCIA_CAPACITACAO_INTERNO_TO "
                    + "WHERE IdFreqCap='" + jIdRegistro.getText() + "'");
            conecta.rs.first();
            codigoRegistro = conecta.rs.getString("IdFreqCap");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarSitaucaoCurso() {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENS_FREQUENCIA_CAPACITACAO_INTERNO_TO "
                    + "WHERE IdFreqCap='" + jIdRegistro.getText() + "' "
                    + "AND SituacaoCurso='" + pSituacaoInterno + "'");
            conecta.rs.first();
            codigoRegistro = conecta.rs.getString("IdFreqCap");
            pSitaucaoCurso = conecta.rs.getString("SituacaoCurso");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void NovoInterno() {
        limparCamposInternos();
        jDataEntrada.setCalendar(Calendar.getInstance());
        jHorarioEntrada.setText("00:00");
        jHorarioSaida.setText("00:00");
        jNotaAvaliacao.setText("0,00");
        jComboBoxConfFrequencia.setSelectedItem("Selecione...");
        //
        jDataEntrada.setEnabled(true);
        jHorarioEntrada.setEnabled(true);
        jHorarioSaida.setEnabled(true);
        jNotaAvaliacao.setEnabled(true);
        jComboBoxConfFrequencia.setEnabled(true);
        //
        jBtPesquisarInterno.setEnabled(true);
        //
        jBtSalvarInterno.setEnabled(true);
        jBtCancelarInterno.setEnabled(true);
    }

    public void AlterarInterno() {
        jDataEntrada.setEnabled(true);
        jHorarioEntrada.setEnabled(true);
        jHorarioSaida.setEnabled(true);
        jNotaAvaliacao.setEnabled(true);
        jComboBoxConfFrequencia.setEnabled(true);
        //
        jBtSalvarInterno.setEnabled(true);
        jBtCancelarInterno.setEnabled(true);
    }

    public void ExcluirInterno() {
        jBtNovoInterno.setEnabled(true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
    }

    public void SalvarInterno() {
        //PARAMETRO PARA LIMPAR VARIVAL QUE VERIFICA SE O INTERNO ESTÁ CURSANDO OU NÃO.
        pSitaucaoCurso = "";
        jBtNovoInterno.setEnabled(true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        jBtImpressao.setEnabled(true);
    }

    public void CancelarInterno() {
        limparCamposInternos();
        bloquearBotoes();
        bloquearCampos();
        jBtNovoInterno.setEnabled(true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
    }

    public void buscarCampoRegistroInterno() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENS_FREQUENCIA_CAPACITACAO_INTERNO_TO");
            conecta.rs.last();
            codigoItem = conecta.rs.getInt("IdItemFreqCap");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter o código do registro.");
        }
        conecta.desconecta();
    }

    public void preencherTabelaTodosRegistros(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Status", "Data Cadastro", "Observação"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1;
                // Formatar a data Entrada
                dataEntrada = conecta.rs.getString("DataRegistro");
                String dia = dataEntrada.substring(8, 10);
                String mes = dataEntrada.substring(5, 7);
                String ano = dataEntrada.substring(0, 4);
                dataEntrada = dia + "/" + mes + "/" + ano;
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdFreqCap"), conecta.rs.getString("StatusRegistro"), dataEntrada, conecta.rs.getString("Observacao")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem registros a serem exibidos.");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaAtendimentoTerapia.setModel(modelo);
        jTabelaAtendimentoTerapia.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaAtendimentoTerapia.getColumnModel().getColumn(0).setResizable(false);
        jTabelaAtendimentoTerapia.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaAtendimentoTerapia.getColumnModel().getColumn(1).setResizable(false);
        jTabelaAtendimentoTerapia.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTabelaAtendimentoTerapia.getColumnModel().getColumn(2).setResizable(false);
        jTabelaAtendimentoTerapia.getColumnModel().getColumn(3).setPreferredWidth(510);
        jTabelaAtendimentoTerapia.getColumnModel().getColumn(3).setResizable(false);
        jTabelaAtendimentoTerapia.getTableHeader().setReorderingAllowed(false);
        jTabelaAtendimentoTerapia.setAutoResizeMode(jTabelaAtendimentoTerapia.AUTO_RESIZE_OFF);
        jTabelaAtendimentoTerapia.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabela();
        conecta.desconecta();
    }

    public void preencherAtendimentoTerapia(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Status", "Data Cadastro", "Nome do Interno"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1;
                // Formatar a data Entrada
                dataEntrada = conecta.rs.getString("DataRegistro");
                String dia = dataEntrada.substring(8, 10);
                String mes = dataEntrada.substring(5, 7);
                String ano = dataEntrada.substring(0, 4);
                dataEntrada = dia + "/" + mes + "/" + ano;
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdFreqCap"), conecta.rs.getString("StatusRegistro"), dataEntrada, conecta.rs.getString("NomeInternoCrc")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem registros a serem exibidos.");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaAtendimentoTerapia.setModel(modelo);
        jTabelaAtendimentoTerapia.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaAtendimentoTerapia.getColumnModel().getColumn(0).setResizable(false);
        jTabelaAtendimentoTerapia.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaAtendimentoTerapia.getColumnModel().getColumn(1).setResizable(false);
        jTabelaAtendimentoTerapia.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTabelaAtendimentoTerapia.getColumnModel().getColumn(2).setResizable(false);
        jTabelaAtendimentoTerapia.getColumnModel().getColumn(3).setPreferredWidth(510);
        jTabelaAtendimentoTerapia.getColumnModel().getColumn(3).setResizable(false);
        jTabelaAtendimentoTerapia.getTableHeader().setReorderingAllowed(false);
        jTabelaAtendimentoTerapia.setAutoResizeMode(jTabelaAtendimentoTerapia.AUTO_RESIZE_OFF);
        jTabelaAtendimentoTerapia.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabela();
        conecta.desconecta();
    }

    public void limparTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Status", "Data Cadastro", "Nome do Interno"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaAtendimentoTerapia.setModel(modelo);
        jTabelaAtendimentoTerapia.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaAtendimentoTerapia.getColumnModel().getColumn(0).setResizable(false);
        jTabelaAtendimentoTerapia.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaAtendimentoTerapia.getColumnModel().getColumn(1).setResizable(false);
        jTabelaAtendimentoTerapia.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTabelaAtendimentoTerapia.getColumnModel().getColumn(2).setResizable(false);
        jTabelaAtendimentoTerapia.getColumnModel().getColumn(3).setPreferredWidth(510);
        jTabelaAtendimentoTerapia.getColumnModel().getColumn(3).setResizable(false);
        jTabelaAtendimentoTerapia.getTableHeader().setReorderingAllowed(false);
        jTabelaAtendimentoTerapia.setAutoResizeMode(jTabelaAtendimentoTerapia.AUTO_RESIZE_OFF);
        jTabelaAtendimentoTerapia.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabela() {

        //
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaAtendimentoTerapia.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaAtendimentoTerapia.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaAtendimentoTerapia.getColumnModel().getColumn(2).setCellRenderer(centralizado);

    }

    public void preencherItensInternos(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Registro", "Nome do Interno", "Data Entrada", "Horário Entrada", "Horário Saída", "Nota Avaliação", "Frequência"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                // Formatar a data Entrada
                dataInicio = conecta.rs.getString("DataEntrada");
                if (dataInicio != null) {
                    String diai = dataInicio.substring(8, 10);
                    String mesi = dataInicio.substring(5, 7);
                    String anoi = dataInicio.substring(0, 4);
                    dataInicio = diai + "/" + mesi + "/" + anoi;
                }
                notaAvaliacao = conecta.rs.getFloat("NotaAvalia");
                if (notaAvaliacao != null) {
                    DecimalFormat na = new DecimalFormat("#,##0.00");
                    notaAvaliada = na.format(notaAvaliacao);
                }
                dados.add(new Object[]{conecta.rs.getInt("IdItemFreqCap"), conecta.rs.getInt("IdFreqCap"), conecta.rs.getString("NomeInternoCrc"), dataInicio, conecta.rs.getString("HoraEntrada"), conecta.rs.getString("HoraSaida"), notaAvaliada, conecta.rs.getString("Frequencia")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInternos.setModel(modelo);
        jTabelaInternos.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaInternos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(1).setPreferredWidth(60);
        jTabelaInternos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(2).setPreferredWidth(300);
        jTabelaInternos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaInternos.getColumnModel().getColumn(3).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(4).setPreferredWidth(90);
        jTabelaInternos.getColumnModel().getColumn(4).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(5).setPreferredWidth(80);
        jTabelaInternos.getColumnModel().getColumn(5).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(6).setPreferredWidth(90);
        jTabelaInternos.getColumnModel().getColumn(6).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(7).setPreferredWidth(80);
        jTabelaInternos.getColumnModel().getColumn(7).setResizable(false);
        jTabelaInternos.getTableHeader().setReorderingAllowed(false);
        jTabelaInternos.setAutoResizeMode(jTabelaInternos.AUTO_RESIZE_OFF);
        jTabelaInternos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaInternos();
        conecta.desconecta();
    }

    public void limparTabelaInternos() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Registro", "Nome do Interno", "Data Entrada", "Horário Entrada", "Horário Saída", "Nota Avaliação", "Frequência"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInternos.setModel(modelo);
        jTabelaInternos.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaInternos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(1).setPreferredWidth(60);
        jTabelaInternos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(2).setPreferredWidth(300);
        jTabelaInternos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaInternos.getColumnModel().getColumn(3).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTabelaInternos.getColumnModel().getColumn(4).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(5).setPreferredWidth(80);
        jTabelaInternos.getColumnModel().getColumn(5).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(6).setPreferredWidth(90);
        jTabelaInternos.getColumnModel().getColumn(6).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(7).setPreferredWidth(80);
        jTabelaInternos.getColumnModel().getColumn(7).setResizable(false);
        jTabelaInternos.getTableHeader().setReorderingAllowed(false);
        jTabelaInternos.setAutoResizeMode(jTabelaInternos.AUTO_RESIZE_OFF);
        jTabelaInternos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabelaInternos() {
        //
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaInternos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaInternos.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaInternos.getColumnModel().getColumn(3).setCellRenderer(centralizado);
        jTabelaInternos.getColumnModel().getColumn(4).setCellRenderer(centralizado);
        jTabelaInternos.getColumnModel().getColumn(5).setCellRenderer(centralizado);
        jTabelaInternos.getColumnModel().getColumn(6).setCellRenderer(centralizado);
    }

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jIdRegistro.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog2() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela2);
        objLogSys.setIdLancMov(Integer.valueOf(codigoItem));
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
