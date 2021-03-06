/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleDeposito;
import gestor.Controle.ControleDepositoInativo;
import gestor.Controle.ControleEvadidosIndividual;
import gestor.Controle.ControleItensLocacaoInternos;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControleMovInternos;
import gestor.Controle.ControleRolVisitas;
import gestor.Controle.ControleSaldoDepositoInativos;
import gestor.Controle.ControleSaldoSaque;
import gestor.Controle.ControleSaque;
import gestor.Controle.ControleSituacao;
import gestor.Dao.ConexaoBancoDados;
import Utilitarios.ModeloTabela;
import gestor.Modelo.ConsultaSaldoInternos;
import gestor.Modelo.DepositoInterno;
import gestor.Modelo.EvadidoIndividual;
import gestor.Modelo.ItensEntradaSaidaLaborInterno;
import gestor.Modelo.ItensLocacaoInternos;
import gestor.Modelo.ItensSaidaInterno;
import gestor.Modelo.LogSistema;
import gestor.Modelo.ProntuarioCrc;
import gestor.Modelo.RolVisitas;
import gestor.Modelo.SaqueValores;
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
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloCRC.telaLancarEvasaoManuCRC;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import java.awt.Color;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ronaldo
 */
public class TelaEvadidosSaidaTemporariaManual extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EvadidoIndividual objEvadidoInd = new EvadidoIndividual();
    ItensEntradaSaidaLaborInterno objItenLabor = new ItensEntradaSaidaLaborInterno();
    ControleEvadidosIndividual control = new ControleEvadidosIndividual();
    ControleMovInternos controlMov = new ControleMovInternos();
    ItensSaidaInterno objItemSaida = new ItensSaidaInterno();
    ProntuarioCrc objProCrc = new ProntuarioCrc();
    ControleSituacao mod = new ControleSituacao();
    // EXCLUIR INTERNO NA EVASÃO
    ControleItensLocacaoInternos excluirInternoCela = new ControleItensLocacaoInternos();
    ItensLocacaoInternos objItensLoca = new ItensLocacaoInternos();
    // CLASSE DO SERVIÇO SOCIAL PARA FINALIZAR ROL QUANDO INTERNO SAIR DA UNIDADE/EVASÃO
    ControleRolVisitas controlRol = new ControleRolVisitas();
    RolVisitas objRol = new RolVisitas();
    // BANCO VIRTUAL (FINANCEIRO)
    SaqueValores objSaque = new SaqueValores();
    ControleSaque controleSaque = new ControleSaque();
    //
    ControleSaldoDepositoInativos controleIna = new ControleSaldoDepositoInativos();
    ControleDepositoInativo controlDPI = new ControleDepositoInativo();
    //
    DepositoInterno objDeposito = new DepositoInterno();
    ControleDeposito controlDep = new ControleDeposito();
    ConsultaSaldoInternos objSaldo = new ConsultaSaldoInternos();
    ControleSaldoSaque controle = new ControleSaldoSaque();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela = "CRC:InternosEvadidos:Manutenção";
    String statusMov;
    String horaMov;
    String dataModFinal;
    int flag;
    public static int acao;
    String dataInicial, dataFinal, dataLancaMov;
    String tipoOperacao = "EVASAO - SAIDA TEMPORARIA";
    String tipoOperacao1 = "EVASÃO - SAIDA LABORATIVA";
    String tipoOperacao2 = "EVASÃO - SAIDA ESTUDOS";
    String tipoOperacao3 = "EVASÃO - SAIDA PRISÃO DOMICILIAR";
    String statusEva = "ABERTO";
    String evadidoInd = "EVADIDO";
    String situacao = "EVADIDO DA UNIDADE"; // Máximo 19 caracteres   
    String confirmaRetorno = "Não";
    String confirmaEvasao = "Sim";
    String operacaoSaida = "SAIDA TEMPORARIA"; //Quando o interno estiver evadido ALTERAR na tabela ITENSSAIDA
    String statusRol = "FINALIZADO";
    //
    String NrDocRetorno = "";
    String NrDocRetornoNull = null;
    String dataEvasao = ""; // Variavel que controla a saida temporaria junto com a evasão
    String dataEntrada, dataSaida, dataSaidaTemp;
    String idRetorniInt;
    String dataRetorno, dataPrevRetorno;
    int tipoEvasao, idInternoRol;
    String horarioEntrada = "00:00";
    int count;
    //
    double valorDebito = 0;
    double valorCredito = 0;
    double saldoTotalCredito = 0;
    double saldoTotalDebito = 0;
    double valorLiquido = 0;
    String tipoMovDeb = "D";
    String tipoMovCred = "C";
    String statusSaque = "FINALIZADO";
    String movStatus = "D";
    String movTrans = "C";
    double saldoAtual = 0;
    double totalGeral = 0;

    /**
     * Creates new form TelaEvadidosIndividual
     */
    public TelaEvadidosSaidaTemporariaManual() {
        initComponents();
        corCampos();
        formatarCampos();
    }

    //     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupEvasao = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jCodigo = new javax.swing.JTextField();
        jNomeInterno = new javax.swing.JTextField();
        jDataPesqInicial = new com.toedter.calendar.JDateChooser();
        jDataPesFinal = new com.toedter.calendar.JDateChooser();
        jBtPesquisaCodigo = new javax.swing.JButton();
        jBtDataLancamento = new javax.swing.JButton();
        jBtPesquisaNomeInterno = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaIntEvadidosPrincipal = new javax.swing.JTable();
        jPanel32 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jIdLanc = new javax.swing.JTextField();
        jDataLanc = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jStatusLanc = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jRBtSaidaTemporaria = new javax.swing.JRadioButton();
        jRBtSaidaLaborativa = new javax.swing.JRadioButton();
        jRBtSaidaEstudos = new javax.swing.JRadioButton();
        jRBtSaidaMedico = new javax.swing.JRadioButton();
        jRBtSaidaDomiciliar = new javax.swing.JRadioButton();
        jOperacao = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jObservacao = new javax.swing.JTextArea();
        jBtAuditoria = new javax.swing.JButton();
        jBtFinalizar = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jBtSalvar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jBtNovo = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jIdInternoEvadido = new javax.swing.JTextField();
        jNomeInternoEvadido = new javax.swing.JTextField();
        jBtPesquisarInternos = new javax.swing.JButton();
        jIdSaida = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jDataSaida = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        jDocumentoSaida = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Evasão de Internos - Saída Temporária/Laborativa/Estudo :::...");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Código:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Data Inicial:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Data Final:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Interno:");

        jCodigo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodigo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jNomeInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jDataPesqInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jDataPesFinal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesquisaCodigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesquisaCodigo.setContentAreaFilled(false);
        jBtPesquisaCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisaCodigoActionPerformed(evt);
            }
        });

        jBtDataLancamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtDataLancamento.setContentAreaFilled(false);
        jBtDataLancamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtDataLancamentoActionPerformed(evt);
            }
        });

        jBtPesquisaNomeInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesquisaNomeInterno.setContentAreaFilled(false);
        jBtPesquisaNomeInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisaNomeInternoActionPerformed(evt);
            }
        });

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox1.setText("Todos");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtPesquisaNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesquisaCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(143, 143, 143)
                        .addComponent(jCheckBox1))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataPesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtDataLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jBtPesquisaCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(jCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel6)
                    .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jDataPesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtDataLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtPesquisaNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jTabelaIntEvadidosPrincipal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaIntEvadidosPrincipal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Doc.", "Data Evasão", "Status", "Nome do Interno"
            }
        ));
        jTabelaIntEvadidosPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaIntEvadidosPrincipalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaIntEvadidosPrincipal);
        if (jTabelaIntEvadidosPrincipal.getColumnModel().getColumnCount() > 0) {
            jTabelaIntEvadidosPrincipal.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaIntEvadidosPrincipal.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaIntEvadidosPrincipal.getColumnModel().getColumn(1).setMinWidth(80);
            jTabelaIntEvadidosPrincipal.getColumnModel().getColumn(1).setMaxWidth(80);
            jTabelaIntEvadidosPrincipal.getColumnModel().getColumn(2).setMinWidth(100);
            jTabelaIntEvadidosPrincipal.getColumnModel().getColumn(2).setMaxWidth(100);
            jTabelaIntEvadidosPrincipal.getColumnModel().getColumn(3).setMinWidth(300);
            jTabelaIntEvadidosPrincipal.getColumnModel().getColumn(3).setMaxWidth(300);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        jTabbedPane1.addTab("Listagem", jPanel1);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Data Evasão");

        jIdLanc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdLanc.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jIdLanc.setEnabled(false);

        jDataLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataLanc.setEnabled(false);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Status");

        jStatusLanc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jStatusLanc.setForeground(new java.awt.Color(255, 0, 0));
        jStatusLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jStatusLanc.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        jStatusLanc.setEnabled(false);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo de Evasão", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        buttonGroupEvasao.add(jRBtSaidaTemporaria);
        jRBtSaidaTemporaria.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBtSaidaTemporaria.setForeground(new java.awt.Color(0, 0, 255));
        jRBtSaidaTemporaria.setText("S. Temporária");
        jRBtSaidaTemporaria.setToolTipText("Saída Temporária");
        jRBtSaidaTemporaria.setEnabled(false);
        jRBtSaidaTemporaria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRBtSaidaTemporariaMouseClicked(evt);
            }
        });

        buttonGroupEvasao.add(jRBtSaidaLaborativa);
        jRBtSaidaLaborativa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBtSaidaLaborativa.setForeground(new java.awt.Color(0, 102, 0));
        jRBtSaidaLaborativa.setText("S. Laborativa");
        jRBtSaidaLaborativa.setToolTipText("Saída Laborativa");
        jRBtSaidaLaborativa.setEnabled(false);
        jRBtSaidaLaborativa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRBtSaidaLaborativaMouseClicked(evt);
            }
        });

        buttonGroupEvasao.add(jRBtSaidaEstudos);
        jRBtSaidaEstudos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBtSaidaEstudos.setForeground(new java.awt.Color(102, 0, 102));
        jRBtSaidaEstudos.setText("S. Educacional");
        jRBtSaidaEstudos.setToolTipText("Saída Educacional");
        jRBtSaidaEstudos.setEnabled(false);
        jRBtSaidaEstudos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRBtSaidaEstudosMouseClicked(evt);
            }
        });

        buttonGroupEvasao.add(jRBtSaidaMedico);
        jRBtSaidaMedico.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBtSaidaMedico.setText("S. Médico");
        jRBtSaidaMedico.setToolTipText("Saída para Médico");
        jRBtSaidaMedico.setEnabled(false);
        jRBtSaidaMedico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRBtSaidaMedicoMouseClicked(evt);
            }
        });

        buttonGroupEvasao.add(jRBtSaidaDomiciliar);
        jRBtSaidaDomiciliar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBtSaidaDomiciliar.setText("S. Prisão Domiciliar");
        jRBtSaidaDomiciliar.setToolTipText("Saída de Prisão Domiciliar");
        jRBtSaidaDomiciliar.setEnabled(false);
        jRBtSaidaDomiciliar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRBtSaidaDomiciliarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jRBtSaidaTemporaria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRBtSaidaLaborativa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRBtSaidaEstudos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRBtSaidaMedico))
                    .addComponent(jRBtSaidaDomiciliar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRBtSaidaTemporaria)
                    .addComponent(jRBtSaidaLaborativa)
                    .addComponent(jRBtSaidaEstudos)
                    .addComponent(jRBtSaidaMedico))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRBtSaidaDomiciliar))
        );

        jOperacao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jOperacao.setForeground(new java.awt.Color(153, 0, 102));
        jOperacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jOperacao.setDisabledTextColor(new java.awt.Color(153, 0, 102));
        jOperacao.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Descrição da Operação");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jOperacao, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jIdLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jStatusLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDataLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel1)
                        .addComponent(jLabel11))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jStatusLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(4, 4, 4)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jDataLanc, jIdLanc, jStatusLanc});

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 255));
        jLabel5.setText("Observação:");

        jObservacao.setColumns(20);
        jObservacao.setRows(5);
        jObservacao.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jObservacao.setEnabled(false);
        jScrollPane2.setViewportView(jObservacao);

        jBtAuditoria.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtAuditoria.setForeground(new java.awt.Color(255, 0, 0));
        jBtAuditoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoria.setToolTipText("Auditoria");
        jBtAuditoria.setContentAreaFilled(false);
        jBtAuditoria.setEnabled(false);
        jBtAuditoria.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAuditoria.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jBtAuditoria.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jBtAuditoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaActionPerformed(evt);
            }
        });

        jBtFinalizar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtFinalizar.setForeground(new java.awt.Color(255, 0, 0));
        jBtFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/accept.png"))); // NOI18N
        jBtFinalizar.setToolTipText("Finalizar Documento");
        jBtFinalizar.setContentAreaFilled(false);
        jBtFinalizar.setEnabled(false);
        jBtFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFinalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jBtAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jBtFinalizar)
                            .addComponent(jBtAuditoria))
                        .addGap(0, 30, Short.MAX_VALUE)))
                .addGap(3, 3, 3))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

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

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jBtNovo)
                .addGap(1, 1, 1)
                .addComponent(jBtAlterar)
                .addGap(1, 1, 1)
                .addComponent(jBtExcluir)
                .addGap(1, 1, 1)
                .addComponent(jBtSalvar)
                .addGap(1, 1, 1)
                .addComponent(jBtCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtSair)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jBtNovo)
            .addComponent(jBtAlterar)
            .addComponent(jBtSalvar, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jBtCancelar, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jBtSair, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jBtExcluir, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtCancelar, jBtSair, jBtSalvar});

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Código");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Nome do Interno");

        jIdInternoEvadido.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdInternoEvadido.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdInternoEvadido.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jIdInternoEvadido.setEnabled(false);

        jNomeInternoEvadido.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoEvadido.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jNomeInternoEvadido.setEnabled(false);

        jBtPesquisarInternos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtPesquisarInternos.setForeground(new java.awt.Color(255, 0, 0));
        jBtPesquisarInternos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesquisarInternos.setToolTipText("Pesquisar Interno");
        jBtPesquisarInternos.setContentAreaFilled(false);
        jBtPesquisarInternos.setEnabled(false);
        jBtPesquisarInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisarInternosActionPerformed(evt);
            }
        });

        jIdSaida.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdSaida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdSaida.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Código Saida");

        jDataSaida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataSaida.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Data Saida");

        jDocumentoSaida.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jDocumentoSaida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDocumentoSaida.setEnabled(false);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Doc. Saida");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jNomeInternoEvadido)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jIdInternoEvadido, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesquisarInternos, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                            .addComponent(jIdSaida))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jDocumentoSaida)))
                    .addComponent(jLabel10))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel14)
                        .addComponent(jLabel13)
                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIdInternoEvadido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesquisarInternos)
                    .addComponent(jIdSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDocumentoSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNomeInternoEvadido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 4, Short.MAX_VALUE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
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
            .addComponent(jTabbedPane1)
        );

        setBounds(350, 80, 483, 486);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaLancarEvasaoManuCRC);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaLancarEvasaoManuCRC) && codGravarCRC == 1) {
            if (jOperacao.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o tipo de operação.");
            } else if (jDataLanc.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data de lançamento.");
                jDataLanc.requestFocus();
                jDataLanc.setBackground(Color.red);
            } else if (jNomeInternoEvadido.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome do interno.");
            } else if (jDocumentoSaida.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o número do documento.");
            } else if (jDocumentoSaida.getText().equals("0")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o número do documento.");
            } else if (jDocumentoSaida.getText().equals("00")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o número do documento.");
            } else if (jDocumentoSaida.getText().equals("000")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o número do documento.");
            } else if (jDocumentoSaida.getText().equals("0000")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o número do documento.");
            } else if (jDocumentoSaida.getText().equals("00000")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o número do documento.");
            } else {
                objEvadidoInd.setStatusLanc(statusEva);
                objEvadidoInd.setTipoOperacao(jOperacao.getText());
                objEvadidoInd.setDataEvasao(jDataLanc.getDate());
                objEvadidoInd.setIdInternoCrc(Integer.valueOf(jIdInternoEvadido.getText()));
                objEvadidoInd.setIdSaida(Integer.valueOf(jIdSaida.getText()));
                objEvadidoInd.setDataLanc(jDataSaida.getDate());
                objEvadidoInd.setNrDocSaida(jDocumentoSaida.getText());
                objEvadidoInd.setObservacao(jObservacao.getText());
                if (jRBtSaidaTemporaria.isSelected()) {
                    tipoEvasao = 0;
                } else if (jRBtSaidaLaborativa.isSelected()) {
                    tipoEvasao = 1;
                } else if (jRBtSaidaEstudos.isSelected()) {
                    tipoEvasao = 2;
                } else if (jRBtSaidaMedico.isSelected()) {
                    tipoEvasao = 3;
                } else if (jRBtSaidaDomiciliar.isSelected()) {
                    tipoEvasao = 4;
                }
                objEvadidoInd.setTipoEvasao(tipoEvasao);
                if (acao == 1) {
                    objEvadidoInd.setUsuarioInsert(nameUser);
                    objEvadidoInd.setDataInsert(jDataSistema.getText());
                    objEvadidoInd.setHorarioInsert(jHoraSistema.getText());
                    control.incluirEvadidoInd(objEvadidoInd); // inclui na tabela EVADIDOIND. TESTADO EM 06/06/2015 FUNCIONANDO     
                    buscarId();
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    Salvar();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
                if (acao == 2) {
                    objEvadidoInd.setUsuarioUp(nameUser);
                    objEvadidoInd.setDataUp(jDataSistema.getText());
                    objEvadidoInd.setHorarioUp(jHoraSistema.getText());
                    // ATUALIZA TABELA EVADIDOSIND. TESTADO EM 06/06/2015 FUNCIONANDO                        
                    objEvadidoInd.setIdInternoCrc(Integer.valueOf(jIdInternoEvadido.getText()));
                    objEvadidoInd.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                    control.alterarEvadidoInd(objEvadidoInd);
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
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

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        if (jStatusLanc.getText().equals("ABERTO") && !jIdLanc.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Não esqueça de finalizar o documento para concluir a operação.");
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja FINALIZAR o registro selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                Finalizar();
            }
            dispose();
        } else {
            dispose();
        }
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtAuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaEvadidosManual objAudEva = new TelaAuditoriaEvadidosManual();
        TelaModuloCRC.jPainelCRC.add(objAudEva);
        objAudEva.show();
    }//GEN-LAST:event_jBtAuditoriaActionPerformed

    private void jBtPesquisarInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisarInternosActionPerformed
        // TODO add your handling code here:
        if (jRBtSaidaTemporaria.isSelected()) {
            TelaPesqInternosEvadidosManual objPesqIntMan = new TelaPesqInternosEvadidosManual();
            TelaModuloCRC.jPainelCRC.add(objPesqIntMan);
            objPesqIntMan.show();
        } else if (jRBtSaidaLaborativa.isSelected()) {
            TelaPesqInternosEvadidosLaborativa objPesqIntEvaLab = new TelaPesqInternosEvadidosLaborativa();
            TelaModuloCRC.jPainelCRC.add(objPesqIntEvaLab);
            objPesqIntEvaLab.show();
        } else if (jRBtSaidaEstudos.isSelected()) {
            TelaPesqInternosEvadidosEducacao objPesqIntEvaEdu = new TelaPesqInternosEvadidosEducacao();
            TelaModuloCRC.jPainelCRC.add(objPesqIntEvaEdu);
            objPesqIntEvaEdu.show();
        } else if (jRBtSaidaMedico.isSelected()) {
            TelaPesqInternosEvadidosManualMedico objPesqIntEvaMedico = new TelaPesqInternosEvadidosManualMedico();
            TelaModuloCRC.jPainelCRC.add(objPesqIntEvaMedico);
            objPesqIntEvaMedico.show();
        } else if (jRBtSaidaDomiciliar.isSelected()) {
            TelaPesqInternosEvadidosPrisaoDomiciliar objPesqIntEvaDomiciliar = new TelaPesqInternosEvadidosPrisaoDomiciliar();
            TelaModuloCRC.jPainelCRC.add(objPesqIntEvaDomiciliar);
            objPesqIntEvaDomiciliar.show();
        }
    }//GEN-LAST:event_jBtPesquisarInternosActionPerformed

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaLancarEvasaoManuCRC);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaLancarEvasaoManuCRC) && codIncluirCRC == 1) {
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
        buscarAcessoUsuario(telaLancarEvasaoManuCRC);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaLancarEvasaoManuCRC) && codAlterarCRC == 1) {
            objEvadidoInd.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa registro de internos não poderá ser alterado, o mesmo encontra-se FINALIZADO");
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
        buscarAcessoUsuario(telaLancarEvasaoManuCRC);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaLancarEvasaoManuCRC) && codExcluirCRC == 1) {
            confirmaEvasao = ""; // LIMPA A CONFIRMAÇÃO
            evadidoInd = ""; // LIMPARA O CAMPO PARA GRAVAR VAZIO
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            objEvadidoInd.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa registro de internos não poderá ser excluído, o mesmo encontra-se FINALIZADO");
            } else {
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o LANÇAMENTO selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    objEvadidoInd.setIdInternoCrc(Integer.valueOf(jIdInternoEvadido.getText()));
                    objEvadidoInd.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                    controlMov.excluirMovEvasaoSaidaTmp(objEvadidoInd); // EXCLUIR MOVIMENTO DE INTERNO EVADIDO.
                    control.excluirEvadidoInd(objEvadidoInd); // EXCLUIR REGISTRO DE INTERNO EVADIDO             
                    Excluir();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            jTabelaIntEvadidosPrincipal.setVisible(true);
            this.preencherTabelaEvadidoPrincipal("SELECT * FROM EVADIDOSIND "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON EVADIDOSIND.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc ORDER BY NomeInternoCrc");
        } else {
            jtotalRegistros.setText("");
            limparCamposTabelaEvadido();
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jBtPesquisaCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisaCodigoActionPerformed
        // TODO add your handling code here:
        count = 0;
        if (jCodigo.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o código do lançamento para pesquisa.");
        } else {
            jTabelaIntEvadidosPrincipal.setVisible(true);
            preencherTabelaEvadidoPrincipal("SELECT * FROM EVADIDOSIND "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON EVADIDOSIND.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE IdLanc='" + jCodigo.getText() + "'");
        }
    }//GEN-LAST:event_jBtPesquisaCodigoActionPerformed

    private void jBtDataLancamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtDataLancamentoActionPerformed
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
                        preencherTabelaEvadidoPrincipal("SELECT * FROM EVADIDOSIND "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON EVADIDOSIND.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                + "WHERE DataLanc BETWEEN'" + dataInicial + "' "
                                + "AND '" + dataFinal + "' "
                                + "ORDER BY NomeInternoCrc");
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
                        preencherTabelaEvadidoPrincipal("SELECT * FROM EVADIDOSIND "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON EVADIDOSIND.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                + "WHERE DataLanc BETWEEN'" + dataInicial + "' "
                                + "AND '" + dataFinal + "' "
                                + "ORDER BY NomeInternoCrc");
                    }
                }
            }
        }
    }//GEN-LAST:event_jBtDataLancamentoActionPerformed

    private void jBtPesquisaNomeInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisaNomeInternoActionPerformed
        // TODO add your handling code here:
        count = 0;
        if (jNomeInterno.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o código do lançamento para pesquisa.");
        } else {
            jTabelaIntEvadidosPrincipal.setVisible(true);
            preencherTabelaEvadidoPrincipal("SELECT * FROM EVADIDOSIND "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON EVADIDOSIND.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE NomeInternoCrc LIKE'%" + jNomeInterno.getText() + "%'");
        }
    }//GEN-LAST:event_jBtPesquisaNomeInternoActionPerformed

    private void jTabelaIntEvadidosPrincipalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaIntEvadidosPrincipalMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String IdLanc = "" + jTabelaIntEvadidosPrincipal.getValueAt(jTabelaIntEvadidosPrincipal.getSelectedRow(), 0);
            jCodigo.setText(IdLanc);
            jDataLanc.setDate(jDataLanc.getDate());
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(true);
            // jBtFinalizar.setEnabled(true);            
            jBtAuditoria.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM EVADIDOSIND "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON EVADIDOSIND.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE IdLanc='" + jCodigo.getText() + "'");
                conecta.rs.first();
                jIdLanc.setText(String.valueOf(conecta.rs.getInt("IdLanc")));
                jStatusLanc.setText(conecta.rs.getString("StatusLanc"));
                jDataLanc.setDate(conecta.rs.getDate("DataLanc"));
                jOperacao.setText(conecta.rs.getString("TipoOp"));
                jDocumentoSaida.setText(conecta.rs.getString("NrDocSaida"));
                tipoEvasao = conecta.rs.getInt("TipoEvasao");
                if (tipoEvasao == 0) {
                    jRBtSaidaTemporaria.setSelected(true);
                } else if (tipoEvasao == 1) {
                    jRBtSaidaLaborativa.setSelected(true);
                } else if (tipoEvasao == 2) {
                    jRBtSaidaEstudos.setSelected(true);
                } else if (tipoEvasao == 3) {
                    jRBtSaidaMedico.setSelected(true);
                } else if (tipoEvasao == 4) {
                    jRBtSaidaDomiciliar.setSelected(true);
                    jOperacao.setText("EVASÃO - SAIDA DOMICILIAR");
                }
                jIdInternoEvadido.setText(conecta.rs.getString("IdInternoCrc"));
                jNomeInternoEvadido.setText(conecta.rs.getString("NomeInternoCrc"));
                jIdSaida.setText(conecta.rs.getString("IdSaida"));
                jDataSaida.setDate(conecta.rs.getDate("DataSaida"));
                jDocumentoSaida.setText(conecta.rs.getString("NrDocSaida"));
                jObservacao.setText(conecta.rs.getString("Observacao"));
                conecta.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa por DATA " + e);
            }
        }
        // IMPEDI QUE A TELA SEJA FECHADA COM O LANÇAMENTO EM ABERTO, OBRIGANDO A FECHAR PELO BOTÃO SAIR E LENDO O AVISO
        if (jStatusLanc.getText().equals("ABERTO") && !jIdLanc.getText().equals("")) {
            setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE); //Impedir que a janela seja fechada pelo X 
        } else {
            setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
        }
    }//GEN-LAST:event_jTabelaIntEvadidosPrincipalMouseClicked

    private void jBtFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFinalizarActionPerformed
        // TODO add your handling code here:
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM EVADIDOSIND WHERE IdLanc='" + jIdLanc.getText() + "'");
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

    private void jRBtSaidaTemporariaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRBtSaidaTemporariaMouseClicked
        // TODO add your handling code here:
        if (acao == 1 && jRBtSaidaTemporaria.isSelected() && jIdLanc.getText().equals("") || acao == 2 && jRBtSaidaTemporaria.isSelected() && jIdLanc.getText().equals("")) {
            jOperacao.setText("EVASÃO - SAIDA TEMPORARIA");
            jIdInternoEvadido.setText("");
            jNomeInternoEvadido.setText("");
            jIdSaida.setText("");
            jDataSaida.setDate(null);
            jDocumentoSaida.setText("");
            jIdSaida.setEnabled(!true);
            jDataSaida.setEnabled(!true);
        }
    }//GEN-LAST:event_jRBtSaidaTemporariaMouseClicked

    private void jRBtSaidaLaborativaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRBtSaidaLaborativaMouseClicked
        // TODO add your handling code here:
        if (acao == 1 && jRBtSaidaLaborativa.isSelected() && jIdLanc.getText().equals("") || acao == 2 && jRBtSaidaLaborativa.isSelected() && jIdLanc.getText().equals("")) {
            jOperacao.setText("EVASÃO - SAIDA LABORATIVA");
            jIdInternoEvadido.setText("");
            jNomeInternoEvadido.setText("");
            jIdSaida.setText("");
            jDataSaida.setDate(null);
            jDocumentoSaida.setText("");
            jIdSaida.setEnabled(true);
            jDataSaida.setEnabled(true);
        }
    }//GEN-LAST:event_jRBtSaidaLaborativaMouseClicked

    private void jRBtSaidaEstudosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRBtSaidaEstudosMouseClicked
        // TODO add your handling code here:
        if (acao == 1 && jRBtSaidaEstudos.isSelected() && jIdLanc.getText().equals("") || acao == 2 && jRBtSaidaEstudos.isSelected() && jIdLanc.getText().equals("")) {
            jOperacao.setText("EVASÃO - SAIDA ESTUDOS");
            jIdInternoEvadido.setText("");
            jNomeInternoEvadido.setText("");
            jIdSaida.setText("");
            jDataSaida.setDate(null);
            jDocumentoSaida.setText("");
            jIdSaida.setEnabled(true);
            jDataSaida.setEnabled(true);
        }
    }//GEN-LAST:event_jRBtSaidaEstudosMouseClicked

    private void jRBtSaidaMedicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRBtSaidaMedicoMouseClicked
        // TODO add your handling code here:
        if (acao == 1 && jRBtSaidaMedico.isSelected() && jIdLanc.getText().equals("") || acao == 2 && jRBtSaidaMedico.isSelected() && jIdLanc.getText().equals("")) {
            jOperacao.setText("EVASÃO - SAIDA MÉDICO");
            jIdInternoEvadido.setText("");
            jNomeInternoEvadido.setText("");
            jIdSaida.setText("");
            jDataSaida.setDate(null);
            jDocumentoSaida.setText("");
            jIdSaida.setEnabled(true);
            jDataSaida.setEnabled(true);
        }
    }//GEN-LAST:event_jRBtSaidaMedicoMouseClicked

    private void jRBtSaidaDomiciliarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRBtSaidaDomiciliarMouseClicked
        // TODO add your handling code here:
        if (acao == 1 && jRBtSaidaDomiciliar.isSelected() && jIdLanc.getText().equals("") || acao == 2 && jRBtSaidaDomiciliar.isSelected() && jIdLanc.getText().equals("")) {
            jOperacao.setText("EVASÃO - SAIDA DOMICILIAR");
            jIdInternoEvadido.setText("");
            jNomeInternoEvadido.setText("");
            jIdSaida.setText("");
            jDataSaida.setDate(null);
            jDocumentoSaida.setText("");
            jIdSaida.setEnabled(true);
            jDataSaida.setEnabled(true);
        }
    }//GEN-LAST:event_jRBtSaidaDomiciliarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupEvasao;
    private javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtAuditoria;
    public static javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtDataLancamento;
    private javax.swing.JButton jBtExcluir;
    private javax.swing.JButton jBtFinalizar;
    private javax.swing.JButton jBtNovo;
    private javax.swing.JButton jBtPesquisaCodigo;
    private javax.swing.JButton jBtPesquisaNomeInterno;
    private javax.swing.JButton jBtPesquisarInternos;
    private javax.swing.JButton jBtSair;
    public static javax.swing.JButton jBtSalvar;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JTextField jCodigo;
    public static com.toedter.calendar.JDateChooser jDataLanc;
    private com.toedter.calendar.JDateChooser jDataPesFinal;
    private com.toedter.calendar.JDateChooser jDataPesqInicial;
    public static com.toedter.calendar.JDateChooser jDataSaida;
    public static javax.swing.JTextField jDocumentoSaida;
    public static javax.swing.JTextField jIdInternoEvadido;
    public static javax.swing.JTextField jIdLanc;
    public static javax.swing.JTextField jIdSaida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jNomeInterno;
    public static javax.swing.JTextField jNomeInternoEvadido;
    public static javax.swing.JTextArea jObservacao;
    public static javax.swing.JTextField jOperacao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRBtSaidaDomiciliar;
    private javax.swing.JRadioButton jRBtSaidaEstudos;
    private javax.swing.JRadioButton jRBtSaidaLaborativa;
    private javax.swing.JRadioButton jRBtSaidaMedico;
    private javax.swing.JRadioButton jRBtSaidaTemporaria;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jStatusLanc;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTabelaIntEvadidosPrincipal;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void formatarCampos() {
//        jDocumentoSaida.setDocument(new LimiteDigitosAlfa(14));
        jObservacao.setLineWrap(true);
        jObservacao.setWrapStyleWord(true);
    }

    public void corCampos() {
        jIdLanc.setBackground(Color.white);
        jStatusLanc.setBackground(Color.white);
        jOperacao.setBackground(Color.white);
        jDataLanc.setBackground(Color.white);
        jObservacao.setBackground(Color.white);
        jIdInternoEvadido.setBackground(Color.white);
        jNomeInternoEvadido.setBackground(Color.white);
        jIdSaida.setBackground(Color.white);
        jDataSaida.setBackground(Color.white);
        jDocumentoSaida.setBackground(Color.white);
    }

    public void Novo() {
        //
        jIdLanc.setText("");
        jStatusLanc.setText("ABERTO");
        jOperacao.setText("");
        jDataLanc.setCalendar(Calendar.getInstance());
        jObservacao.setText("");
        jIdSaida.setText("");
        jDataSaida.setDate(null);
        jDocumentoSaida.setText("");
        jIdInternoEvadido.setText("");
        jNomeInternoEvadido.setText("");
        //
        jBtPesquisarInternos.setEnabled(true);
        jRBtSaidaTemporaria.setEnabled(true);
        jRBtSaidaLaborativa.setEnabled(true);
        jRBtSaidaEstudos.setEnabled(true);
        jRBtSaidaMedico.setEnabled(true);
        jRBtSaidaDomiciliar.setEnabled(true);
        //
        jIdSaida.setEnabled(true);
        jDataSaida.setEnabled(true);
        jDocumentoSaida.setEnabled(true);
        jDataLanc.setEnabled(true);
        jObservacao.setEnabled(true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtAuditoria.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
    }

    public void Alterar() {
        //
        if (tipoEvasao == 0) {
            jBtPesquisarInternos.setEnabled(true);
            jDataLanc.setEnabled(true);
            jRBtSaidaTemporaria.setEnabled(true);
            jRBtSaidaLaborativa.setEnabled(true);
            jRBtSaidaEstudos.setEnabled(true);
            jRBtSaidaMedico.setEnabled(true);
            jRBtSaidaDomiciliar.setEnabled(true);
            //
            jIdSaida.setEnabled(!true);
            jDataSaida.setEnabled(!true);
            jDocumentoSaida.setEnabled(true);
            jObservacao.setEnabled(true);
            //
            jBtNovo.setEnabled(!true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(true);
            jBtCancelar.setEnabled(true);
            jBtAuditoria.setEnabled(!true);
        } else if (tipoEvasao == 1) {
            jBtPesquisarInternos.setEnabled(true);
            jDataLanc.setEnabled(true);
            jRBtSaidaTemporaria.setEnabled(true);
            jRBtSaidaLaborativa.setEnabled(true);
            jRBtSaidaEstudos.setEnabled(true);
            jRBtSaidaMedico.setEnabled(true);
            jRBtSaidaDomiciliar.setEnabled(true);
            //
            jIdSaida.setEnabled(!true);
            jDataSaida.setEnabled(true);
            jDocumentoSaida.setEnabled(true);
            jObservacao.setEnabled(true);
            //
            jBtNovo.setEnabled(!true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(true);
            jBtCancelar.setEnabled(true);
            jBtAuditoria.setEnabled(!true);
        } else if (tipoEvasao == 2) {
            jBtPesquisarInternos.setEnabled(true);
            jDataLanc.setEnabled(true);
            jRBtSaidaTemporaria.setEnabled(true);
            jRBtSaidaLaborativa.setEnabled(true);
            jRBtSaidaEstudos.setEnabled(true);
            jRBtSaidaMedico.setEnabled(true);
            jRBtSaidaDomiciliar.setEnabled(true);
            //
            jIdSaida.setEnabled(!true);
            jDataSaida.setEnabled(true);
            jDocumentoSaida.setEnabled(true);
            jObservacao.setEnabled(true);
            //
            jBtNovo.setEnabled(!true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(true);
            jBtCancelar.setEnabled(true);
            jBtAuditoria.setEnabled(!true);
        } else if (tipoEvasao == 3) {
            jBtPesquisarInternos.setEnabled(true);
            jDataLanc.setEnabled(true);
            jRBtSaidaTemporaria.setEnabled(true);
            jRBtSaidaLaborativa.setEnabled(true);
            jRBtSaidaEstudos.setEnabled(true);
            jRBtSaidaMedico.setEnabled(true);
            jRBtSaidaDomiciliar.setEnabled(true);
            //
            jIdSaida.setEnabled(!true);
            jDataSaida.setEnabled(true);
            jDocumentoSaida.setEnabled(true);
            jObservacao.setEnabled(true);
            //
            jBtNovo.setEnabled(!true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(true);
            jBtCancelar.setEnabled(true);
            jBtAuditoria.setEnabled(!true);
        } else if (tipoEvasao == 4) {
            jBtPesquisarInternos.setEnabled(true);
            jDataLanc.setEnabled(true);
            jRBtSaidaTemporaria.setEnabled(true);
            jRBtSaidaLaborativa.setEnabled(true);
            jRBtSaidaEstudos.setEnabled(true);
            jRBtSaidaMedico.setEnabled(true);
            jRBtSaidaDomiciliar.setEnabled(true);
            //
            jIdSaida.setEnabled(!true);
            jDataSaida.setEnabled(true);
            jDocumentoSaida.setEnabled(true);
            jObservacao.setEnabled(true);
            //
            jBtNovo.setEnabled(!true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(true);
            jBtCancelar.setEnabled(true);
            jBtAuditoria.setEnabled(!true);
        }
    }

    public void Excluir() {
        //
        jIdLanc.setText("");
        jOperacao.setText("");
        jDataLanc.setDate(null);
        //
        jIdSaida.setText("");
        jDataSaida.setDate(null);
        jDocumentoSaida.setText("");
        jObservacao.setText("");
        jIdInternoEvadido.setText("");
        jNomeInternoEvadido.setText("");
        //
        jBtPesquisarInternos.setEnabled(!true);
        jDataLanc.setEnabled(!true);
        jRBtSaidaTemporaria.setEnabled(!true);
        jRBtSaidaLaborativa.setEnabled(!true);
        jRBtSaidaEstudos.setEnabled(!true);
        jRBtSaidaMedico.setEnabled(!true);
        jRBtSaidaDomiciliar.setEnabled(!true);
        //
        jIdSaida.setEnabled(!true);
        jDataSaida.setEnabled(!true);
        jDocumentoSaida.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
    }

    public void Salvar() {
        //
        jBtPesquisarInternos.setEnabled(!true);
        jDataLanc.setEnabled(!true);
        jRBtSaidaTemporaria.setEnabled(!true);
        jRBtSaidaLaborativa.setEnabled(!true);
        jRBtSaidaEstudos.setEnabled(!true);
        jRBtSaidaMedico.setEnabled(!true);
        jRBtSaidaDomiciliar.setEnabled(!true);
        //
        jIdSaida.setEnabled(!true);
        jDataSaida.setEnabled(!true);
        jDocumentoSaida.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
        jBtFinalizar.setEnabled(true);
    }

    public void Cancelar() {
        if (jIdLanc.getText().equals("")) {
            //
            jIdLanc.setText("");
            jOperacao.setText("");
            jDataLanc.setDate(null);
            jObservacao.setText("");
            //
            jIdSaida.setText("");
            jDataSaida.setDate(null);
            jDocumentoSaida.setText("");
            jObservacao.setText("");
            jIdInternoEvadido.setText("");
            jNomeInternoEvadido.setText("");
            //
            jBtPesquisarInternos.setEnabled(!true);
            jDataLanc.setEnabled(!true);
            jRBtSaidaTemporaria.setEnabled(!true);
            jRBtSaidaLaborativa.setEnabled(!true);
            jRBtSaidaEstudos.setEnabled(!true);
            jRBtSaidaDomiciliar.setEnabled(!true);
            //
            jIdSaida.setEnabled(!true);
            jDataSaida.setEnabled(!true);
            jDocumentoSaida.setEnabled(!true);
            jObservacao.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtAuditoria.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
        } else {
            //
            jBtPesquisarInternos.setEnabled(!true);
            jDataLanc.setEnabled(!true);
            jRBtSaidaTemporaria.setEnabled(!true);
            jRBtSaidaLaborativa.setEnabled(!true);
            jRBtSaidaEstudos.setEnabled(!true);
            jRBtSaidaDomiciliar.setEnabled(!true);
            //
            jIdSaida.setEnabled(!true);
            jDataSaida.setEnabled(!true);
            jDocumentoSaida.setEnabled(!true);
            jObservacao.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtAuditoria.setEnabled(true);
            jBtFinalizar.setEnabled(true);
        }
    }

    public void Finalizar() {
        statusMov = "Finalizou";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        String statusEntrada = "FINALIZADO";
        JOptionPane.showMessageDialog(rootPane, "Se essa evasão de internos for finalizado, você não poderá mais excluir ou alterar. Será também\n"
                + "excluído a LOCALIZAÇÃO do INTERNO e modificado a POPULAÇÃO DA UNIDADE PENAL.");
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente FINALIZAR o lançamento selecionado?", "Confirmação",
                JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            finalizarEvasao();
            objEvadidoInd.setStatusLanc(statusEntrada);
            objEvadidoInd.setIdLanc(Integer.parseInt(jIdLanc.getText()));
            objEvadidoInd.setIdInternoCrc(Integer.valueOf(jIdInternoEvadido.getText()));
            control.finalizarEvadidoInd(objEvadidoInd);
            jStatusLanc.setText(statusEntrada);
            // EXCLUIR O INTERNO DA CELA NO MOMENTO DA SAIDA DA EVASÃO. EM 08/07/2016                
            objItensLoca.setNomeInterno(jNomeInternoEvadido.getText());
            objItensLoca.setIdInternoCrc(Integer.valueOf(jIdInternoEvadido.getText()));
            excluirInternoCela.deletarInternoLocacaoSaida(objItensLoca);
            // CALCULAR O VALOR LIQUIDO DO INTERNO
            calcularCredito();
            calcularDebito();
            valorLiquido = saldoTotalCredito - saldoTotalDebito;
            // INCLUIR SAQUE NA  TABELA SALDOVALORES
            objSaldo.setHistorico(situacao);
            objSaldo.setDataMov(jDataLanc.getDate());
            objSaldo.setFavorecidoDepositante(jNomeInternoEvadido.getText());
            objSaldo.setIdInternoCrc(Integer.valueOf(jIdInternoEvadido.getText()));
            objSaldo.setStatusMov(movStatus);
            objSaldo.setSaldo((float) valorLiquido);
            objSaldo.setIdLanc(Integer.valueOf(jIdLanc.getText()));
            controle.incluirSaldo(objSaldo); // SALDOVALORES
            // TABELA SALDO_VALORES_INATIVOS
            objSaldo.setSaldoAtual(valorLiquido);
            controleIna.incluirSaldo(objSaldo); // SALDO_VALORES_INATIVOS
            // LANÇA DEBITO NA TABELA SAQUE
            objSaque.setStatusLanc(statusSaque);
            objSaque.setDataLanc(jDataLanc.getDate());
            objSaque.setIdInternoCrc(Integer.valueOf(jIdInternoEvadido.getText()));
            objSaque.setNomeInterno(jNomeInternoEvadido.getText());
            objSaque.setFavorecido(jNomeInternoEvadido.getText());
            objSaque.setObservacao(situacao);
            objSaque.setValorSaque((float) valorLiquido);
            controleSaque.incluirSaque(objSaque); // TABELA - SAQUE
            // DEPOSITO NA CONTA DOS INATIVOS DEPOSITO_INATIVOS
            objDeposito.setStatusLanc(statusSaque);
            objDeposito.setDataLanc(jDataLanc.getDate());
            objDeposito.setValorDeposito((float) valorLiquido);
            objDeposito.setDepositante(jNomeInternoEvadido.getText());
            objDeposito.setObservacao(situacao);
            objDeposito.setIdInternoCrc(Integer.valueOf(jIdInternoEvadido.getText()));
            objDeposito.setNomeInterno(jNomeInternoEvadido.getText());
            controlDPI.incluirDepositos(objDeposito); // TABELA - DEPOSITOS_INATIVOS
            //
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
        }
    }

    public void buscarId() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM EVADIDOSIND");
            conecta.rs.last();
            jIdLanc.setText(conecta.rs.getString("IdLanc"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter o código do lançamento.");
        }
        conecta.desconecta();
    }

    public void finalizarEvasao() {
        objEvadidoInd.setStatusLanc(statusEva);
        objEvadidoInd.setTipoOperacao(jOperacao.getText());
        objEvadidoInd.setNrDocSaida(jDocumentoSaida.getText());
        objEvadidoInd.setDataLanc(jDataLanc.getDate());
        objEvadidoInd.setIdInternoCrc(Integer.valueOf(jIdInternoEvadido.getText()));
        objEvadidoInd.setObservacao(jObservacao.getText());
        // SE FOR EVSÃO DE SAIDA TEMPORARIA
        if (tipoEvasao == 0) {
            // INCLUIR NA TABELA (MOVIMENTOCRC)
            objEvadidoInd.setIdLanc(Integer.valueOf(jIdLanc.getText()));
            controlMov.incluirMovEvasaoSaidaTmp(objEvadidoInd);
            // Atualiza tabela de Itens de saida temporaria, quando interno está evadido. TESTADO EM 06/06/2015 FUNCIONANDO                        
            objItemSaida.setInternoEvadido(evadidoInd); // Quando interno EVADE
            objItemSaida.setIdInternoSaida(Integer.valueOf(jIdInternoEvadido.getText()));
            objItemSaida.setDocumento(jDocumentoSaida.getText());
            objItemSaida.setConfirmaEvasao(confirmaEvasao);
            control.alterarEvasaoInternoSaidaTmp(objItemSaida); // tabela ITENSSAIDA quando evadidos. TESTADO EM 06/06/2015 FUNCIONANDO                              
            // CONFIRMA A EVASÃO DO INTERNO DA TABELA (MOVISR). TESTADO EM 06/06/2015 - FUNCIONANDO
            objItemSaida.setDataEvasaoTmp(jDataLanc.getDate()); // Data da Evasão 
            objItemSaida.setDocumento(jDocumentoSaida.getText());
            objItemSaida.setConfirmaEvasao(confirmaEvasao);
            control.confirmaEvasaoInternoSaidaTmp(objItemSaida);
            // SE FOR EVASÃO DE SAIDA LABORATIVA EXTERNA
        } else if (tipoEvasao == 1) {
            // INCLUIR NA TABELA (MOVIMENTOCRC)
            objEvadidoInd.setIdInternoCrc(Integer.valueOf(jIdInternoEvadido.getText()));
            objEvadidoInd.setIdLanc(Integer.valueOf(jIdLanc.getText()));
            objEvadidoInd.setTipoOperacao(tipoOperacao1);
            controlMov.incluirMovEvasao(objEvadidoInd);
            // ATUALIZA TABELA DE (ITENSLABORINTERNO), QUADO INTERNO ESTÁ EVADIDO.
            objItenLabor.setInternoEvadido(evadidoInd);
            objItenLabor.setIdLanc(Integer.valueOf(jIdSaida.getText()));
            objItenLabor.setIdInternoCrc(Integer.valueOf(jIdInternoEvadido.getText()));
            control.incluirEvasaoInterno(objItenLabor);
            // INSERIR NA TABELA (MOVISR) OS DADOS DO INTERNO EVADIDO
            objItemSaida.setIdInternoSaida(Integer.valueOf(jIdInternoEvadido.getText()));
            objItemSaida.setIdSaida(Integer.valueOf(jIdSaida.getText()));
            objItemSaida.setDataSaida(jDataSaida.getDate());
            objItemSaida.setDocumento(jDocumentoSaida.getText());
            objItemSaida.setConfirmaEvasao(confirmaEvasao);
            objItemSaida.setDataEvasaoTmp(jDataLanc.getDate());
            control.incluirEvasaoInternoSaidaLaborativa(objItemSaida);
            // SE FOR EVASÃO DE SAIDA PARA ESTUDAR NA TABELA INTERNOS_ENTRADA_SAIDA_EDUCACAO  
        } else if (tipoEvasao == 2) {
            // INCLUIR NA TABELA (MOVIMENTOCRC)
            objEvadidoInd.setIdLanc(Integer.valueOf(jIdLanc.getText()));
            controlMov.incluirMovEvasaoSaidaEduca(objEvadidoInd);
            // UPDATE CAMPO (OBSERVACAO E EVADIDO) DA TABELA INTERNOS_ENTRADA_SAIDA_EDUCACAO - PORTARIA 
            objItenLabor.setIdInternoCrc(Integer.valueOf(jIdInternoEvadido.getText()));
            objItenLabor.setInternoEvadido(evadidoInd);
            objItenLabor.setObservacao(evadidoInd);
            objItenLabor.setHorarioEntrada(horarioEntrada);
            control.incluirEvasaoEducacionalInternoPortaria(objItenLabor);
            // UPDATE NO CAMPO (EVADIDO) DA TABELA INTERNOS_SAIDA_EDUCACIONAL - PEDAGOGIA
            objItenLabor.setIdInternoCrc(Integer.valueOf(jIdInternoEvadido.getText()));
            objItenLabor.setInternoEvadido(evadidoInd);
            control.incluirEvasaoEducacionalInternoPedagogia(objItenLabor);
            // INSERIR NA TABELA (MOVISR) OS DADOS DO INTERNO EVADIDO
            objItemSaida.setIdInternoSaida(Integer.valueOf(jIdInternoEvadido.getText()));
            objItemSaida.setIdSaida(Integer.valueOf(jIdSaida.getText()));
            objItemSaida.setDataSaida(jDataSaida.getDate());
            objItemSaida.setDocumento(jDocumentoSaida.getText());
            objItemSaida.setConfirmaEvasao(confirmaEvasao);
            objItemSaida.setDataEvasaoTmp(jDataLanc.getDate());
            control.incluirEvasaoInternoSaidaLaborativa(objItemSaida);
        } else if (tipoEvasao == 3) {
            // INCLUIR NA TABELA (MOVIMENTOCRC)
            objEvadidoInd.setIdLanc(Integer.valueOf(jIdLanc.getText()));
            controlMov.incluirMovEvasaoSaidaMedico(objEvadidoInd);
            // UPDATE CAMPO (OBSERVACAO E EVADIDO) DA TABELA INTERNOS_ENTRADA_SAIDA_EDUCACAO - PORTARIA 
            objItenLabor.setIdInternoCrc(Integer.valueOf(jIdInternoEvadido.getText()));
            objItenLabor.setInternoEvadido(evadidoInd);
            objItenLabor.setObservacao(evadidoInd);
            objItenLabor.setHorarioEntrada(horarioEntrada);
            control.incluirEvasaoEducacionalInternoPortaria(objItenLabor);
            // UPDATE NO CAMPO (EVADIDO) DA TABELA INTERNOS_SAIDA_EDUCACIONAL - PEDAGOGIA
            objItenLabor.setIdInternoCrc(Integer.valueOf(jIdInternoEvadido.getText()));
            objItenLabor.setInternoEvadido(evadidoInd);
            control.incluirEvasaoEducacionalInternoPedagogia(objItenLabor);
            // INSERIR NA TABELA (MOVISR) OS DADOS DO INTERNO EVADIDO
            objItemSaida.setIdInternoSaida(Integer.valueOf(jIdInternoEvadido.getText()));
            objItemSaida.setIdSaida(Integer.valueOf(jIdSaida.getText()));
            objItemSaida.setDataSaida(jDataSaida.getDate());
            objItemSaida.setDocumento(jDocumentoSaida.getText());
            objItemSaida.setConfirmaEvasao(confirmaEvasao);
            objItemSaida.setDataEvasaoTmp(jDataLanc.getDate());
            control.incluirEvasaoInternoSaidaLaborativa(objItemSaida);
            //PRISÃO DOMICILIAR
        } else if (tipoEvasao == 4) {
            // INCLUIR NA TABELA (MOVIMENTOCRC)
            objEvadidoInd.setIdLanc(Integer.valueOf(jIdLanc.getText()));
            controlMov.incluirMovEvasaoSaidaTmp(objEvadidoInd);
            // Atualiza tabela de Itens de saida temporaria, quando interno está evadido. TESTADO EM 06/06/2015 FUNCIONANDO                        
            objItemSaida.setInternoEvadido(evadidoInd); // Quando interno EVADE
            objItemSaida.setIdInternoSaida(Integer.valueOf(jIdInternoEvadido.getText()));
            objItemSaida.setDocumento(jDocumentoSaida.getText());
            objItemSaida.setConfirmaEvasao(confirmaEvasao);
            control.alterarEvasaoInternoSaidaTmp(objItemSaida); // tabela ITENSSAIDA quando evadidos. TESTADO EM 06/06/2015 FUNCIONANDO                              
            // CONFIRMA A EVASÃO DO INTERNO DA TABELA (MOVISR). TESTADO EM 06/06/2015 - FUNCIONANDO
            objItemSaida.setDataEvasaoTmp(jDataLanc.getDate()); // Data da Evasão 
            objItemSaida.setDocumento(jDocumentoSaida.getText());
            objItemSaida.setConfirmaEvasao(confirmaEvasao);
            control.confirmaEvasaoInternoSaidaPD(objItemSaida);
        }
        // MODIFICA A SITUAÇÃO DO INTERNO NA TABELA PRONTUARIOSCRC
        objProCrc.setIdInterno(Integer.parseInt(jIdInternoEvadido.getText()));
        objProCrc.setSituacao(situacao);
        mod.alterarSituacaoInterno(objProCrc);
        // FINALIZAR O ROL DE VISITAS, BLOQUEIA INTERNO NO ROL (FINALIZAR)                                                  
        atualizarRolSaidaInterno();
        // EXCLUI O INTERNO DA CELA NO MOMENTO DO LANÇAMENTO DA EVASÃO.
        objItensLoca.setIdInternoCrc(Integer.valueOf(jIdInternoEvadido.getText()));
        excluirInternoCela.deletarInternoLocacaoSaida(objItensLoca);
    }

    // FINALIZA o Rol do interno quando o mesmo sair da unidade
    public void atualizarRolSaidaInterno() {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdInternoCrc, "
                    + "StatusRol "
                    + "FROM ROLVISITAS "
                    + "WHERE IdInternoCrc='" + jIdInternoEvadido.getText() + "' "
                    + "AND StatusRol='" + statusRol + "'");
            conecta.rs.first();
            idInternoRol = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
        }
        statusRol = "FINALIZADO";
        objRol.setIdInterno(Integer.valueOf(jIdInternoEvadido.getText()));
        objRol.setStatusRol(statusRol);
        objRol.setObsRol(jOperacao.getText());
        objRol.setUsuarioUp(nameUser);
        objRol.setDataUp(jDataSistema.getText());
        objRol.setHoraUp(horaMov);
        controlRol.finalizarRolVisitasPortaria(objRol);
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

    public void preencherTabelaEvadidoPrincipal(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Doc.", "Data Evasão", "Status", "Nome do Interno"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1;
                // Formatar a data no formato Brasil
                dataSaida = conecta.rs.getString("DataLanc");
                String dia = dataSaida.substring(8, 10);
                String mes = dataSaida.substring(5, 7);
                String ano = dataSaida.substring(0, 4);
                dataSaida = dia + "/" + mes + "/" + ano;
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdLanc"), dataSaida, conecta.rs.getString("StatusLanc"), conecta.rs.getString("NomeInternoCrc")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaIntEvadidosPrincipal.setModel(modelo);
        jTabelaIntEvadidosPrincipal.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaIntEvadidosPrincipal.getColumnModel().getColumn(0).setResizable(false);
        jTabelaIntEvadidosPrincipal.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaIntEvadidosPrincipal.getColumnModel().getColumn(1).setResizable(false);
        jTabelaIntEvadidosPrincipal.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTabelaIntEvadidosPrincipal.getColumnModel().getColumn(2).setResizable(false);
        jTabelaIntEvadidosPrincipal.getColumnModel().getColumn(3).setPreferredWidth(300);
        jTabelaIntEvadidosPrincipal.getColumnModel().getColumn(3).setResizable(false);
        jTabelaIntEvadidosPrincipal.getTableHeader().setReorderingAllowed(false);
        jTabelaIntEvadidosPrincipal.setAutoResizeMode(jTabelaIntEvadidosPrincipal.AUTO_RESIZE_OFF);
        jTabelaIntEvadidosPrincipal.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinhaColunasEvadidosPrincipal();
        conecta.desconecta();
    }

    public void alinhaColunasEvadidosPrincipal() {
        //
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        //
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaIntEvadidosPrincipal.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaIntEvadidosPrincipal.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaIntEvadidosPrincipal.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }

    public void limparCamposTabelaEvadido() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Doc.", "Data Evasão", "Status", "Nome do Interno"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaIntEvadidosPrincipal.setModel(modelo);
        jTabelaIntEvadidosPrincipal.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaIntEvadidosPrincipal.getColumnModel().getColumn(0).setResizable(false);
        jTabelaIntEvadidosPrincipal.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaIntEvadidosPrincipal.getColumnModel().getColumn(1).setResizable(false);
        jTabelaIntEvadidosPrincipal.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTabelaIntEvadidosPrincipal.getColumnModel().getColumn(2).setResizable(false);
        jTabelaIntEvadidosPrincipal.getColumnModel().getColumn(3).setPreferredWidth(300);
        jTabelaIntEvadidosPrincipal.getColumnModel().getColumn(3).setResizable(false);
        jTabelaIntEvadidosPrincipal.getTableHeader().setReorderingAllowed(false);
        jTabelaIntEvadidosPrincipal.setAutoResizeMode(jTabelaIntEvadidosPrincipal.AUTO_RESIZE_OFF);
        jTabelaIntEvadidosPrincipal.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void calcularDebito() {
        valorDebito = 0;
        saldoTotalDebito = 0;
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM SALDOVALORES "
                    + "WHERE IdInternoCrc='" + jIdInternoEvadido.getText() + "' "
                    + "AND StatusMov='" + tipoMovDeb + "'");
            conecta.rs.first();
            do {
                valorDebito = conecta.rs.getDouble("ValorMov");
                saldoTotalDebito = saldoTotalDebito + valorDebito;
            } while (conecta.rs.next());
        } catch (Exception e) {
        }
    }

    public void calcularCredito() {
        valorCredito = 0;
        saldoTotalCredito = 0;
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM SALDOVALORES "
                    + "WHERE IdInternoCrc='" + jIdInternoEvadido.getText() + "' "
                    + "AND StatusMov='" + tipoMovCred + "'");
            conecta.rs.first();
            do {
                valorCredito = conecta.rs.getDouble("ValorMov");
                saldoTotalCredito = saldoTotalCredito + valorCredito;
            } while (conecta.rs.next());
        } catch (Exception e) {
        }
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
