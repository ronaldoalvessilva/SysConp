/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleComposicaoKit;
import gestor.Controle.ControleKitDecendialNomeInternoTodos;
import gestor.Controle.ControleListaInternosKitDecendialIdInternos;
import gestor.Controle.ControleListaInternosProgramacaoKitTodos;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControlePagamentoKitAnualRealizado;
import gestor.Controle.ControlePagamentoKitDecendialRealizado;
import gestor.Controle.ControlePagamentoKitMensalRealizado;
import gestor.Controle.ControlePagamentoKitQuinzenalRealizado;
import gestor.Controle.ControlePagamentoKitSemestralRealizado;
import gestor.Controle.ControleProgramacaoKit;
import gestor.Controle.ControleProximoKitDecendial;
import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.ModeloTabela;
import gestor.Modelo.ComposicaoKit;
import gestor.Modelo.GravarInternosKitCompleto;
import gestor.Modelo.LogSistema;
import gestor.Modelo.ProgramacaoKit;
import static gestor.Visao.TelaLoginSenha.descricaoUnidade;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloAlmoxarifado.codAbrirAL;
import static gestor.Visao.TelaModuloAlmoxarifado.codAlterarAL;
import static gestor.Visao.TelaModuloAlmoxarifado.codConsultarAL;
import static gestor.Visao.TelaModuloAlmoxarifado.codExcluirAL;
import static gestor.Visao.TelaModuloAlmoxarifado.codGravarAL;
import static gestor.Visao.TelaModuloAlmoxarifado.codIncluirAL;
import static gestor.Visao.TelaModuloAlmoxarifado.codUserAcessoAL;
import static gestor.Visao.TelaModuloAlmoxarifado.codigoGrupoAL;
import static gestor.Visao.TelaModuloAlmoxarifado.codigoUserAL;
import static gestor.Visao.TelaModuloAlmoxarifado.codigoUserGroupAL;
import static gestor.Visao.TelaModuloAlmoxarifado.nomeGrupoAL;
import static gestor.Visao.TelaModuloAlmoxarifado.nomeTelaAL;
import static gestor.Visao.TelaModuloAlmoxarifado.telaProgramacaoKitIndAL;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
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
 * @author ronal
 */
public class TelaProgramacaoKitsHigiene extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ComposicaoKit objComp = new ComposicaoKit();
    ControleComposicaoKit control = new ControleComposicaoKit();
    ProgramacaoKit objProg = new ProgramacaoKit();
    ControleProgramacaoKit controlPagtoKit = new ControleProgramacaoKit();
    //KIT DECENDIAL
    GravarInternosKitCompleto objGravaIntComp = new GravarInternosKitCompleto();
    ControleListaInternosProgramacaoKitTodos controleKDTodos = new ControleListaInternosProgramacaoKitTodos();
    ControleListaInternosKitDecendialIdInternos controleKD = new ControleListaInternosKitDecendialIdInternos();
    ControleKitDecendialNomeInternoTodos controlNome = new ControleKitDecendialNomeInternoTodos();
    ControlePagamentoKitDecendialRealizado controlListKD = new ControlePagamentoKitDecendialRealizado();  //LISTAR KIT DECENDIAL PARA SER CONSULTADO OU EXCLUÍDO.
    ControleProximoKitDecendial controleExcluirKD = new ControleProximoKitDecendial(); // EXCLUIR TODOS OS INTERNOS
    //
    ControlePagamentoKitQuinzenalRealizado controlListKQ = new ControlePagamentoKitQuinzenalRealizado();
    ControlePagamentoKitMensalRealizado controlListKM = new ControlePagamentoKitMensalRealizado();
    ControlePagamentoKitSemestralRealizado controlListKS = new ControlePagamentoKitSemestralRealizado();
    ControlePagamentoKitAnualRealizado controlListKA = new ControlePagamentoKitAnualRealizado();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    //
    //KIT QUINZENAL
    // 1 - DECENDIAL, 2 - QUINZENAL, 3 - MENSAL, 4 - SEMESTRAL, 5 - ANUAL
    public static int tipoKit = 0;
    String nomeKit = "";
    //
    int totalRegistro = 0;
    int totalRegistro1 = 0;
    int count2 = 0;
    String idInterno;
    String codInter;
    int flag = 0;
    int acao = 0;
    //
    String gerado = "";
    String idRegistro = "";
    int idRegistro_PROG = 0;
    public static int qtdInternos = 0;
    //
    String statusMov = "";
    String horaMov = "";
    String dataModFinal = "";
    int codigoInterno = 0;
    int codigoRegistro = 0;
    Date data;
    public static int idPROG = 0;
    int kitInicial = 0;
    int kitAnual = 0;
    int kitDecendial = 0;
    int kitQuinzenal = 0;
    int kitMensal = 0;
    int kitSemestral = 0;
    public static int codigoPavilhao = 0;
    String dataEntrada, dataUltimoPagto, dataPrevisao;
    int count = 0;
    // BUSCAR ID DO KIT NA TABELA KIT_HIGIENE_INTERNO
    int idKitBusca = 0;
    String nomeCampoTabela = "";
    String kitPago = "";
    int idPav = 0;
    int codigoKit = 0;
    String dataInicial = "";
    String dataFinal = "";

    /**
     * Creates new form TelaProgramacaoKitsHigiene
     */
    public static TelaGravarProximoKitDecendialInd gravarKitDec;
    public static TelaGravarProximoKitQuinzenalInd gravarKitQuin;
    public static TelaGravarProximoKitMensaInd gravarKitMensa;
    public static TelaGravarProximoKitSemestralInd gravarKitSeme;
    public static TelaGravarProximoKitAnualInd gravaKitAnua;
    public static TelaExcluirUmInternoProgramacaoKit excluirUm;

    public TelaProgramacaoKitsHigiene() {
        initComponents();
    }

    public void mostrarProxKitDecendial() {
        gravarKitDec = new TelaGravarProximoKitDecendialInd(this, true);
        gravarKitDec.setVisible(true);
    }

    public void mostrarProxKitQuinzenal() {
        gravarKitQuin = new TelaGravarProximoKitQuinzenalInd(this, true);
        gravarKitQuin.setVisible(true);
    }

    public void mostrarProxKitMensal() {
        gravarKitMensa = new TelaGravarProximoKitMensaInd(this, true);
        gravarKitMensa.setVisible(true);
    }

    public void mostrarProxKitSemestral() {
        gravarKitSeme = new TelaGravarProximoKitSemestralInd(this, true);
        gravarKitSeme.setVisible(true);
    }

    public void mostrarProxKitAnual() {
        gravaKitAnua = new TelaGravarProximoKitAnualInd(this, true);
        gravaKitAnua.setVisible(true);
    }

    public void mostrarExcluirUm() {
        excluirUm = new TelaExcluirUmInternoProgramacaoKit(this, true);
        excluirUm.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jCheckBoxTodosRegistros = new javax.swing.JCheckBox();
        jRB_DECENDIAL = new javax.swing.JRadioButton();
        jRB_QUINZENAL = new javax.swing.JRadioButton();
        jRB_MENSAL = new javax.swing.JRadioButton();
        jRB_SEMESTRAL = new javax.swing.JRadioButton();
        jRB_ANUAL = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        jDataInicial = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jDataFinal = new com.toedter.calendar.JDateChooser();
        jBtPesquisaData = new javax.swing.JButton();
        jBtPesquisaKit = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTabelaProgramacaoKit = new javax.swing.JTable();
        jPanel48 = new javax.swing.JPanel();
        jLabel73 = new javax.swing.JLabel();
        jPanel49 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel50 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jRBDencendial = new javax.swing.JRadioButton();
        jRBQuinzenal = new javax.swing.JRadioButton();
        jRBMensal = new javax.swing.JRadioButton();
        jRBSemestral = new javax.swing.JRadioButton();
        jRBAnual = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jNomeInternoPesq = new javax.swing.JTextField();
        jBtNomePesquisa = new javax.swing.JButton();
        jCheckBoxTodos = new javax.swing.JCheckBox();
        jComboBoxPavilhao = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jDataUltimoPagto = new com.toedter.calendar.JDateChooser();
        jPanel8 = new javax.swing.JPanel();
        jDataPrevisao = new com.toedter.calendar.JDateChooser();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabelaOrigem = new javax.swing.JTable();
        jPanel42 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        jPanel43 = new javax.swing.JPanel();
        jtotalOrigem = new javax.swing.JLabel();
        jPanel44 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jBtAdicionarUm = new javax.swing.JButton();
        jBtAdicionarTodos = new javax.swing.JButton();
        jBtVoltarUm = new javax.swing.JButton();
        jBtVoltarTodos = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaDestino = new javax.swing.JTable();
        jPanel45 = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        jPanel46 = new javax.swing.JPanel();
        jtotalDestino = new javax.swing.JLabel();
        jPanel47 = new javax.swing.JPanel();
        jBtNovo = new javax.swing.JButton();
        jBtExcluirTodos = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jBtAuditoria = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jDataGeracao = new com.toedter.calendar.JDateChooser();
        jBtExcluirUm = new javax.swing.JButton();
        jBtImpressao = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Programação de Pagamento de Kits :::....");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Tipo Kit:");

        jCheckBoxTodosRegistros.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxTodosRegistros.setText("Todos");
        jCheckBoxTodosRegistros.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxTodosRegistrosItemStateChanged(evt);
            }
        });

        buttonGroup1.add(jRB_DECENDIAL);
        jRB_DECENDIAL.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRB_DECENDIAL.setForeground(new java.awt.Color(0, 0, 204));
        jRB_DECENDIAL.setSelected(true);
        jRB_DECENDIAL.setText("Decendial");

        buttonGroup1.add(jRB_QUINZENAL);
        jRB_QUINZENAL.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRB_QUINZENAL.setForeground(new java.awt.Color(204, 0, 0));
        jRB_QUINZENAL.setText("Quinzenal");

        buttonGroup1.add(jRB_MENSAL);
        jRB_MENSAL.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRB_MENSAL.setForeground(new java.awt.Color(0, 102, 0));
        jRB_MENSAL.setText("Mensal");

        buttonGroup1.add(jRB_SEMESTRAL);
        jRB_SEMESTRAL.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRB_SEMESTRAL.setForeground(new java.awt.Color(153, 0, 51));
        jRB_SEMESTRAL.setText("Semestral");

        buttonGroup1.add(jRB_ANUAL);
        jRB_ANUAL.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRB_ANUAL.setText("Anual");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Data Inicial:");

        jDataInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Data Final:");

        jDataFinal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesquisaData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesquisaData.setContentAreaFilled(false);
        jBtPesquisaData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisaDataActionPerformed(evt);
            }
        });

        jBtPesquisaKit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesquisaKit.setContentAreaFilled(false);
        jBtPesquisaKit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisaKitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jRB_DECENDIAL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRB_QUINZENAL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRB_MENSAL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRB_SEMESTRAL))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesquisaData, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRB_ANUAL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtPesquisaKit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jCheckBoxTodosRegistros)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtPesquisaKit)
                    .addComponent(jRB_ANUAL)
                    .addComponent(jRB_SEMESTRAL)
                    .addComponent(jRB_MENSAL)
                    .addComponent(jRB_QUINZENAL)
                    .addComponent(jRB_DECENDIAL)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtPesquisaData)
                    .addComponent(jDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jCheckBoxTodosRegistros))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaProgramacaoKit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaProgramacaoKit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Programação", "Tipo Kit", "Pagamento", "Previsão"
            }
        ));
        jTabelaProgramacaoKit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaProgramacaoKitMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTabelaProgramacaoKit);
        if (jTabelaProgramacaoKit.getColumnModel().getColumnCount() > 0) {
            jTabelaProgramacaoKit.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaProgramacaoKit.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaProgramacaoKit.getColumnModel().getColumn(1).setMinWidth(100);
            jTabelaProgramacaoKit.getColumnModel().getColumn(1).setMaxWidth(100);
            jTabelaProgramacaoKit.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaProgramacaoKit.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaProgramacaoKit.getColumnModel().getColumn(3).setMinWidth(80);
            jTabelaProgramacaoKit.getColumnModel().getColumn(3).setMaxWidth(80);
            jTabelaProgramacaoKit.getColumnModel().getColumn(4).setMinWidth(80);
            jTabelaProgramacaoKit.getColumnModel().getColumn(4).setMaxWidth(80);
        }

        jPanel48.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jLabel73.setText("Total de Registros:");

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel73))
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel73)
        );

        jPanel49.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jtotalRegistros.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
        );

        jPanel50.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 407, Short.MAX_VALUE)
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("Listagem", jPanel1);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Tipo Kit", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 204))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Tipo de Kit:");

        buttonGroup2.add(jRBDencendial);
        jRBDencendial.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBDencendial.setForeground(new java.awt.Color(0, 0, 204));
        jRBDencendial.setSelected(true);
        jRBDencendial.setText("Decendial");
        jRBDencendial.setEnabled(false);

        buttonGroup2.add(jRBQuinzenal);
        jRBQuinzenal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBQuinzenal.setForeground(new java.awt.Color(204, 0, 0));
        jRBQuinzenal.setText("Quinzenal");
        jRBQuinzenal.setEnabled(false);

        buttonGroup2.add(jRBMensal);
        jRBMensal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBMensal.setForeground(new java.awt.Color(0, 102, 0));
        jRBMensal.setText("Mensal");
        jRBMensal.setEnabled(false);

        buttonGroup2.add(jRBSemestral);
        jRBSemestral.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBSemestral.setForeground(new java.awt.Color(102, 0, 51));
        jRBSemestral.setText("Semestral");
        jRBSemestral.setEnabled(false);

        buttonGroup2.add(jRBAnual);
        jRBAnual.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBAnual.setText("Anual");
        jRBAnual.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRBDencendial, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRBQuinzenal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRBMensal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRBSemestral)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRBAnual)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jRBAnual)
                    .addComponent(jRBSemestral)
                    .addComponent(jRBMensal)
                    .addComponent(jRBQuinzenal)
                    .addComponent(jRBDencendial)
                    .addComponent(jLabel4))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Pesquisas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 102, 0))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Pavilhão:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Nome  Interno:");

        jNomeInternoPesq.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoPesq.setEnabled(false);

        jBtNomePesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtNomePesquisa.setToolTipText("Pesquisa Interno");
        jBtNomePesquisa.setContentAreaFilled(false);
        jBtNomePesquisa.setEnabled(false);
        jBtNomePesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNomePesquisaActionPerformed(evt);
            }
        });

        jCheckBoxTodos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxTodos.setText("Todos");
        jCheckBoxTodos.setToolTipText("Selecionar Todos Internos");
        jCheckBoxTodos.setEnabled(false);
        jCheckBoxTodos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxTodosItemStateChanged(evt);
            }
        });

        jComboBoxPavilhao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxPavilhao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione..." }));
        jComboBoxPavilhao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxPavilhao.setEnabled(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel5))
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jComboBoxPavilhao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxTodos)
                        .addGap(10, 10, 10))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jNomeInternoPesq)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtNomePesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel5)
                    .addComponent(jComboBoxPavilhao, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxTodos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel6)
                    .addComponent(jNomeInternoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtNomePesquisa))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Datas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Data Último Pagto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jDataUltimoPagto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataUltimoPagto.setEnabled(false);
        jDataUltimoPagto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jDataUltimoPagtoMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDataUltimoPagto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jDataUltimoPagto, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Data Previsão", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(204, 0, 0))); // NOI18N

        jDataPrevisao.setBackground(new java.awt.Color(255, 255, 255));
        jDataPrevisao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataPrevisao.setEnabled(false);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDataPrevisao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jDataPrevisao, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Origem", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(204, 0, 0))); // NOI18N

        jTabelaOrigem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaOrigem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome do Interno"
            }
        ));
        jScrollPane2.setViewportView(jTabelaOrigem);
        if (jTabelaOrigem.getColumnModel().getColumnCount() > 0) {
            jTabelaOrigem.getColumnModel().getColumn(0).setMinWidth(60);
            jTabelaOrigem.getColumnModel().getColumn(1).setMinWidth(250);
        }

        jPanel42.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jLabel71.setText("Total de Registros:");

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel71))
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel71)
        );

        jPanel43.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jtotalOrigem.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalOrigem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalOrigem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
        );

        jPanel44.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 49, Short.MAX_VALUE)
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "NV", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 204))); // NOI18N

        jBtAdicionarUm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/250718131515_16.png"))); // NOI18N
        jBtAdicionarUm.setToolTipText("Selecionar um Registro");
        jBtAdicionarUm.setEnabled(false);
        jBtAdicionarUm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAdicionarUmActionPerformed(evt);
            }
        });

        jBtAdicionarTodos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/250718131115_16.png"))); // NOI18N
        jBtAdicionarTodos.setToolTipText("Selecionar Todos Registros");
        jBtAdicionarTodos.setEnabled(false);
        jBtAdicionarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAdicionarTodosActionPerformed(evt);
            }
        });

        jBtVoltarUm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/250718131526_16.png"))); // NOI18N
        jBtVoltarUm.setToolTipText("Retornar um Registro");
        jBtVoltarUm.setEnabled(false);
        jBtVoltarUm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtVoltarUmActionPerformed(evt);
            }
        });

        jBtVoltarTodos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/250718131210_16.png"))); // NOI18N
        jBtVoltarTodos.setToolTipText("Retornoar Todos Registros");
        jBtVoltarTodos.setEnabled(false);
        jBtVoltarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtVoltarTodosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jBtVoltarTodos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jBtVoltarUm, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jBtAdicionarTodos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtAdicionarUm, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jBtAdicionarUm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAdicionarTodos)
                .addGap(70, 70, 70)
                .addComponent(jBtVoltarUm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtVoltarTodos)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Destino", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 102, 0))); // NOI18N

        jTabelaDestino.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaDestino.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome do Interno"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTabelaDestino);
        if (jTabelaDestino.getColumnModel().getColumnCount() > 0) {
            jTabelaDestino.getColumnModel().getColumn(0).setMinWidth(60);
            jTabelaDestino.getColumnModel().getColumn(1).setMinWidth(250);
        }

        jPanel45.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jLabel72.setText("Total de Registros:");

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel72))
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel72)
        );

        jPanel46.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jtotalDestino.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalDestino, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalDestino, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
        );

        jPanel47.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jBtNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovo.setToolTipText("Novo Registro");
        jBtNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoActionPerformed(evt);
            }
        });

        jBtExcluirTodos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216104515_16.png"))); // NOI18N
        jBtExcluirTodos.setToolTipText("Excluir Todos Registros");
        jBtExcluirTodos.setEnabled(false);
        jBtExcluirTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirTodosActionPerformed(evt);
            }
        });

        jBtSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvar.setToolTipText("Gravar Registro");
        jBtSalvar.setEnabled(false);
        jBtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarActionPerformed(evt);
            }
        });

        jBtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelar.setToolTipText("Cancelar Operação");
        jBtCancelar.setEnabled(false);
        jBtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarActionPerformed(evt);
            }
        });

        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSair.setToolTipText("Sair da Tela");
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

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Data Registro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(102, 0, 51))); // NOI18N

        jDataGeracao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataGeracao.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDataGeracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jDataGeracao, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jBtExcluirUm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216104428_16.png"))); // NOI18N
        jBtExcluirUm.setToolTipText("Excluir Interno");
        jBtExcluirUm.setEnabled(false);
        jBtExcluirUm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirUmActionPerformed(evt);
            }
        });

        jBtImpressao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/gtklp-icone-3770-16.png"))); // NOI18N
        jBtImpressao.setEnabled(false);
        jBtImpressao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtImpressaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jBtNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtExcluirTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtExcluirUm, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jBtImpressao, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(jBtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)
                                .addComponent(jBtAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtCancelar, jBtExcluirTodos, jBtExcluirUm, jBtImpressao, jBtNovo, jBtSair, jBtSalvar});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBtExcluirTodos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                            .addComponent(jBtSalvar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                            .addComponent(jBtCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                            .addComponent(jBtAuditoria)
                            .addComponent(jBtNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtSair, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtExcluirUm, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jBtImpressao, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(117, 117, 117))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtCancelar, jBtExcluirTodos, jBtExcluirUm, jBtImpressao, jBtNovo, jBtSair, jBtSalvar});

        jTabbedPane1.addTab("Manutenção", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 539, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBounds(350, 0, 633, 567);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtNomePesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNomePesquisaActionPerformed
        // TODO add your handling code here:
        if (jNomeInternoPesq.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um nome para pesquisa.");
        } else {
            if (jRBDencendial.isSelected()) {
                tipoKit = 1;
                while (jTabelaOrigem.getModel().getRowCount() > 0) {
                    ((DefaultTableModel) jTabelaOrigem.getModel()).removeRow(0);
                }
                totalRegistro = 0;
                qtdInternos = 0;
                DefaultTableModel tabelaOrigem = (DefaultTableModel) jTabelaOrigem.getModel();
                GravarInternosKitCompleto d = new GravarInternosKitCompleto();
                try {
                    for (GravarInternosKitCompleto dd : controlNome.read()) {
                        jtotalOrigem.setText(Integer.toString(qtdInternos)); // Converter inteiro em string para exibir na tela
                        Object campos[] = {dd.getIdInternoCrc(), dd.getNomeInternoCrc()};
                        tabelaOrigem.addRow(campos);
                        // BARRA DE ROLAGEM HORIZONTAL
                        jTabelaOrigem.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        // ALINHAR TEXTO DA TABELA CENTRALIZADO
                        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                        //
                        jTabelaOrigem.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(TelaPrevisaoKitHigiene.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (jRBQuinzenal.isSelected()) {
                tipoKit = 2;
                while (jTabelaOrigem.getModel().getRowCount() > 0) {
                    ((DefaultTableModel) jTabelaOrigem.getModel()).removeRow(0);
                }
                totalRegistro = 0;
                qtdInternos = 0;
                DefaultTableModel tabelaOrigem = (DefaultTableModel) jTabelaOrigem.getModel();
                GravarInternosKitCompleto d = new GravarInternosKitCompleto();
                try {
                    for (GravarInternosKitCompleto dd : controlNome.read()) {
                        jtotalOrigem.setText(Integer.toString(qtdInternos)); // Converter inteiro em string para exibir na tela
                        Object campos[] = {dd.getIdInternoCrc(), dd.getNomeInternoCrc()};
                        tabelaOrigem.addRow(campos);
                        // BARRA DE ROLAGEM HORIZONTAL
                        jTabelaOrigem.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        // ALINHAR TEXTO DA TABELA CENTRALIZADO
                        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                        //
                        jTabelaOrigem.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(TelaPrevisaoKitHigiene.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (jRBMensal.isSelected()) {
                tipoKit = 3;
                while (jTabelaOrigem.getModel().getRowCount() > 0) {
                    ((DefaultTableModel) jTabelaOrigem.getModel()).removeRow(0);
                }
                totalRegistro = 0;
                qtdInternos = 0;
                DefaultTableModel tabelaOrigem = (DefaultTableModel) jTabelaOrigem.getModel();
                GravarInternosKitCompleto d = new GravarInternosKitCompleto();
                try {
                    for (GravarInternosKitCompleto dd : controlNome.read()) {
                        jtotalOrigem.setText(Integer.toString(qtdInternos)); // Converter inteiro em string para exibir na tela
                        Object campos[] = {dd.getIdInternoCrc(), dd.getNomeInternoCrc()};
                        tabelaOrigem.addRow(campos);
                        // BARRA DE ROLAGEM HORIZONTAL
                        jTabelaOrigem.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        // ALINHAR TEXTO DA TABELA CENTRALIZADO
                        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                        //
                        jTabelaOrigem.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(TelaPrevisaoKitHigiene.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (jRBSemestral.isSelected()) {
                tipoKit = 4;
                while (jTabelaOrigem.getModel().getRowCount() > 0) {
                    ((DefaultTableModel) jTabelaOrigem.getModel()).removeRow(0);
                }
                totalRegistro = 0;
                qtdInternos = 0;
                DefaultTableModel tabelaOrigem = (DefaultTableModel) jTabelaOrigem.getModel();
                GravarInternosKitCompleto d = new GravarInternosKitCompleto();
                try {
                    for (GravarInternosKitCompleto dd : controlNome.read()) {
                        jtotalOrigem.setText(Integer.toString(qtdInternos)); // Converter inteiro em string para exibir na tela
                        Object campos[] = {dd.getIdInternoCrc(), dd.getNomeInternoCrc()};
                        tabelaOrigem.addRow(campos);
                        // BARRA DE ROLAGEM HORIZONTAL
                        jTabelaOrigem.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        // ALINHAR TEXTO DA TABELA CENTRALIZADO
                        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                        //
                        jTabelaOrigem.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(TelaPrevisaoKitHigiene.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (jRBAnual.isSelected()) {
                tipoKit = 5;
                while (jTabelaOrigem.getModel().getRowCount() > 0) {
                    ((DefaultTableModel) jTabelaOrigem.getModel()).removeRow(0);
                }
                totalRegistro = 0;
                qtdInternos = 0;
                DefaultTableModel tabelaOrigem = (DefaultTableModel) jTabelaOrigem.getModel();
                GravarInternosKitCompleto d = new GravarInternosKitCompleto();
                try {
                    for (GravarInternosKitCompleto dd : controlNome.read()) {
                        jtotalOrigem.setText(Integer.toString(qtdInternos)); // Converter inteiro em string para exibir na tela
                        Object campos[] = {dd.getIdInternoCrc(), dd.getNomeInternoCrc()};
                        tabelaOrigem.addRow(campos);
                        // BARRA DE ROLAGEM HORIZONTAL
                        jTabelaOrigem.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        // ALINHAR TEXTO DA TABELA CENTRALIZADO
                        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                        //
                        jTabelaOrigem.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(TelaPrevisaoKitHigiene.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jBtNomePesquisaActionPerformed

    private void jCheckBoxTodosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxTodosItemStateChanged
        // TODO add your handling code here:
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            // APAGAR TODOS OS REGISTROS DA TABELA COPIADA
            DefaultTableModel tblRemove = (DefaultTableModel) jTabelaOrigem.getModel();
            if (tblRemove.getRowCount() > 0) {
                for (int i = 0; i <= tblRemove.getRowCount(); i++) {
                    tblRemove.removeRow(i);
                    tblRemove.setRowCount(0);
                    if (tblRemove.getRowCount() < i) {
                        tblRemove.removeRow(i);
                        tblRemove.setRowCount(0);
                    }
                }
            }
            // LIMPAR O TOTALIZADOR DA TABELA
            qtdInternos = 0;
            jtotalOrigem.setText(Integer.toString(qtdInternos));
            mostraSelecaoInternosKitDecendial();
        } else {
            // APAGAR TODOS OS REGISTROS DA TABELA COPIADA
            DefaultTableModel tblRemove = (DefaultTableModel) jTabelaOrigem.getModel();
            if (tblRemove.getRowCount() > 0) {
                for (int i = 0; i <= tblRemove.getRowCount(); i++) {
                    tblRemove.removeRow(i);
                    tblRemove.setRowCount(0);
                    if (tblRemove.getRowCount() < i) {
                        tblRemove.removeRow(i);
                        tblRemove.setRowCount(0);
                    }
                }
            }
            // LIMPAR O TOTALIZADOR DA TABELA
            qtdInternos = 0;
            jtotalOrigem.setText(Integer.toString(qtdInternos));
        }
    }//GEN-LAST:event_jCheckBoxTodosItemStateChanged

    private void jDataUltimoPagtoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDataUltimoPagtoMouseEntered
        // TODO add your handling code here:
        if (jRBDencendial.isSelected()) {
            calcularVencimentoKit(10);
        } else if (jRBQuinzenal.isSelected()) {
            calcularVencimentoKit(15);
        } else if (jRBMensal.isSelected()) {
            calcularVencimentoKit(30);
        } else if (jRBSemestral.isSelected()) {
            calcularVencimentoKit(180);
        } else if (jRBAnual.isSelected()) {
            calcularVencimentoKit(365);
        }
    }//GEN-LAST:event_jDataUltimoPagtoMouseEntered

    private void jBtAdicionarUmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAdicionarUmActionPerformed
        // TODO add your handling code here:
        Integer row = jTabelaDestino.getRowCount();
        boolean encontrou = !true;
        if (jTabelaOrigem.getSelectedRowCount() != 0 && row == 0) { //Verifica se existe linha selecionada para não dar erro na hora de pegar os valores
            count2 = count2 + 1;
            qtdInternos = qtdInternos - 1;
            jtotalDestino.setText(Integer.toString(count2)); // Converter inteiro em string para exibir na tela
            jtotalOrigem.setText(Integer.toString(qtdInternos));
            //Pega os models das listas, para fazer as inserções e remoções
            DefaultTableModel modelOrigem = (DefaultTableModel) jTabelaOrigem.getModel();
            DefaultTableModel modelDestino = (DefaultTableModel) jTabelaDestino.getModel();
            //Cria uma linha para ser incluida na tabela de destino, no meu caso tem duas colunas, adapte para as suas tabelas
            Object[] obj = {jTabelaOrigem.getValueAt(jTabelaOrigem.getSelectedRow(), 0), jTabelaOrigem.getValueAt(jTabelaOrigem.getSelectedRow(), 1)};
            // BARRA DE ROLAGEM HORIZONTAL
            jTabelaDestino.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            // ALINHAR TEXTO DA TABELA CENTRALIZADO
            DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);
            //
            jTabelaDestino.getColumnModel().getColumn(0).setCellRenderer(centralizado);
            //Adiciona no destino e remove da origem
            modelDestino.addRow(obj);
            modelOrigem.removeRow(jTabelaOrigem.getSelectedRow());
        } else if (jTabelaOrigem.getSelectedRowCount() != 0 && row != 0) {
            DefaultTableModel modelOrigem = (DefaultTableModel) jTabelaOrigem.getModel();
            DefaultTableModel modelDestino = (DefaultTableModel) jTabelaDestino.getModel();
            count2 = count2 + 1;
            qtdInternos = qtdInternos - 1;
            jtotalDestino.setText(Integer.toString(count2)); // Converter inteiro em string para exibir na tela
            jtotalOrigem.setText(Integer.toString(qtdInternos));
            //Adiciona no destino e remove da origem
            Object[] obj = {jTabelaOrigem.getValueAt(jTabelaOrigem.getSelectedRow(), 0), jTabelaOrigem.getValueAt(jTabelaOrigem.getSelectedRow(), 1)};
            modelDestino.addRow(obj);
            modelOrigem.removeRow(jTabelaOrigem.getSelectedRow());
            // BARRA DE ROLAGEM HORIZONTAL
            jTabelaDestino.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            // ALINHAR TEXTO DA TABELA CENTRALIZADO
            DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);
            //
            jTabelaDestino.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione pelo menos uma linha para transferir todos registros da tabela.");
            //Não tem nenhuma linha selecionada na tabela de origem, faça um aviso para o usuário ou algo do tipo.
        }
    }//GEN-LAST:event_jBtAdicionarUmActionPerformed

    private void jBtAdicionarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAdicionarTodosActionPerformed
        // TODO add your handling code here:
        flag = 0;
        Integer rows = jTabelaOrigem.getModel().getRowCount();
        if (rows != 0) {
            qtdInternos = 0;
            DefaultTableModel dadosDestino = (DefaultTableModel) jTabelaDestino.getModel();
            GravarInternosKitCompleto d = new GravarInternosKitCompleto();
            try {
                for (GravarInternosKitCompleto dd : controleKDTodos.read()) {
                    jtotalOrigem.setText(Integer.toString(qtdInternos));
                    jtotalDestino.setText(jtotalOrigem.getText()); // Converter inteiro em string para exibir na tela
                    dadosDestino.addRow(new Object[]{dd.getIdInternoCrc(), dd.getNomeInternoCrc()});
                    // BARRA DE ROLAGEM HORIZONTAL
                    jTabelaDestino.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                    // ALINHAR TEXTO DA TABELA CENTRALIZADO
                    DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                    centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                    //
                    jTabelaDestino.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                }
            } catch (Exception ex) {
                Logger.getLogger(TelaMontagemPagamentoKitInterno.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            // APAGAR TODOS OS REGISTROS DA TABELA COPIADA
            DefaultTableModel tblRemove = (DefaultTableModel) jTabelaOrigem.getModel();
            if (tblRemove.getRowCount() > 0) {
                for (int i = 0; i <= tblRemove.getRowCount(); i++) {
                    tblRemove.removeRow(i);
                    tblRemove.setRowCount(0);
                    if (tblRemove.getRowCount() < i) {
                        tblRemove.removeRow(i);
                        tblRemove.setRowCount(0);
                    }
                }
            }
            // LIMPAR O TOTALIZADOR DA TABELA
            jtotalOrigem.setText("");
        } else {
            JOptionPane.showMessageDialog(rootPane, "A tabela com os internos a serem selecionados, não contém itens.");
        }
    }//GEN-LAST:event_jBtAdicionarTodosActionPerformed

    private void jBtVoltarUmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtVoltarUmActionPerformed
        // TODO add your handling code here:
        Integer rows = jTabelaDestino.getModel().getRowCount();
        if (rows != 0) {
            if (jTabelaDestino.getSelectedRowCount() != 0) { //Verifica se existe linha selecionada para não dar erro na hora de pegar os valores
                count2 = count2 - 1;
                qtdInternos = qtdInternos + 1;
                jtotalDestino.setText(Integer.toString(count2)); // Converter inteiro em string para exibir na tela
                jtotalOrigem.setText(Integer.toString(qtdInternos));
                //Pega os models das listas, para fazer as inserções e remoções
                DefaultTableModel modelOrigem = (DefaultTableModel) jTabelaDestino.getModel();
                DefaultTableModel modelDestino = (DefaultTableModel) jTabelaOrigem.getModel();
                //Cria uma linha para ser incluida na tabela de destino, no meu caso tem duas colunas, adapte para as suas tabelas
                Object[] obj = {jTabelaDestino.getValueAt(jTabelaDestino.getSelectedRow(), 0), jTabelaDestino.getValueAt(jTabelaDestino.getSelectedRow(), 1)};
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaOrigem.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaOrigem.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                //Adiciona no destino e remove da origem
                modelDestino.addRow(obj);
                modelOrigem.removeRow(jTabelaDestino.getSelectedRow());
            } else {
                JOptionPane.showMessageDialog(rootPane, "Selecione pelo menos uma linha para transferir todos registros da tabela.");
                //Não tem nenhuma linha selecionada na tabela de origem, faça um aviso para o usuário ou algo do tipo.
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Não existe dados a ser excluído.");
        }
    }//GEN-LAST:event_jBtVoltarUmActionPerformed

    private void jBtVoltarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtVoltarTodosActionPerformed
        // TODO add your handling code here:
        flag = 0;
        Integer rows = jTabelaDestino.getModel().getRowCount();
        if (rows != 0) {
            DefaultTableModel dadosDestino = (DefaultTableModel) jTabelaOrigem.getModel();
            GravarInternosKitCompleto d = new GravarInternosKitCompleto();
            try {
                for (GravarInternosKitCompleto dd : controleKDTodos.read()) {
                    jtotalOrigem.setText(jtotalDestino.getText()); // Converter inteiro em string para exibir na tela
                    dadosDestino.addRow(new Object[]{dd.getIdInternoCrc(), dd.getNomeInternoCrc()});
                    // BARRA DE ROLAGEM HORIZONTAL
                    jTabelaOrigem.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                    // ALINHAR TEXTO DA TABELA CENTRALIZADO
                    DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                    centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                    //
                    jTabelaOrigem.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                }
            } catch (Exception ex) {
                Logger.getLogger(TelaMontagemPagamentoKitInterno.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        // APAGAR DADOS DA TABELA
        while (jTabelaDestino.getModel().getRowCount() > 0) {
            ((DefaultTableModel) jTabelaDestino.getModel()).removeRow(0);
        }
        // LIMPAR O TOTALIZADOR DA TABELA
        jtotalDestino.setText("");
    }//GEN-LAST:event_jBtVoltarTodosActionPerformed

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaProgramacaoKitIndAL);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoAL.equals("ADMINISTRADORES") || codigoUserAL == codUserAcessoAL && nomeTelaAL.equals(telaProgramacaoKitIndAL) && codIncluirAL == 1) {
            acao = 1;
            limparCampos();
            limparTabelaInternos();
            bloquearBotoes();
            Novo();
            pesquisarPavilhao();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, solicite liberação ao administrador do sistema.");
        }
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtExcluirTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirTodosActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaProgramacaoKitIndAL);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoAL.equals("ADMINISTRADORES") || codigoUserAL == codUserAcessoAL && nomeTelaAL.equals(telaProgramacaoKitIndAL) && codExcluirAL == 1) {
            switch (tipoKit) {
                case 1:
                    tipoKit = 1;
                    int resposta0 = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o LANÇAMENTO selecionado?", "Confirmação",
                            JOptionPane.YES_NO_OPTION);
                    if (resposta0 == JOptionPane.YES_OPTION) {
                        objGravaIntComp.setIDREG_PROG(idPROG);
                        controleExcluirKD.excluirKitDecendial(objGravaIntComp);
                        objProg.setIdPROG(idPROG);
                        controlPagtoKit.excluirProgramacaoKit(objProg);
                    }
                    break;
                case 2:
                    tipoKit = 2;
                    int resposta1 = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o LANÇAMENTO selecionado?", "Confirmação",
                            JOptionPane.YES_NO_OPTION);
                    if (resposta1 == JOptionPane.YES_OPTION) {
                        objGravaIntComp.setIDREG_PROG(idPROG);
                        controleExcluirKD.excluirKitQuinzenal(objGravaIntComp);
                        objProg.setIdPROG(idPROG);
                        controlPagtoKit.excluirProgramacaoKit(objProg);
                    }
                    break;
                case 3:
                    tipoKit = 3;
                    int resposta2 = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o LANÇAMENTO selecionado?", "Confirmação",
                            JOptionPane.YES_NO_OPTION);
                    if (resposta2 == JOptionPane.YES_OPTION) {
                        objGravaIntComp.setIDREG_PROG(idPROG);
                        controleExcluirKD.excluirKitMensal(objGravaIntComp);
                        objProg.setIdPROG(idPROG);
                        controlPagtoKit.excluirProgramacaoKit(objProg);
                    }
                    break;
                case 4:
                    tipoKit = 4;
                    int resposta3 = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o LANÇAMENTO selecionado?", "Confirmação",
                            JOptionPane.YES_NO_OPTION);
                    if (resposta3 == JOptionPane.YES_OPTION) {
                        objGravaIntComp.setIDREG_PROG(idPROG);
                        controleExcluirKD.excluirKitSemestral(objGravaIntComp);
                        objProg.setIdPROG(idPROG);
                        controlPagtoKit.excluirProgramacaoKit(objProg);
                    }
                    break;
                case 5:
                    tipoKit = 5;
                    int resposta4 = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o LANÇAMENTO selecionado?", "Confirmação",
                            JOptionPane.YES_NO_OPTION);
                    if (resposta4 == JOptionPane.YES_OPTION) {
                        objGravaIntComp.setIDREG_PROG(idPROG);
                        controleExcluirKD.excluirKitAnual(objGravaIntComp);
                        objProg.setIdPROG(idPROG);
                        controlPagtoKit.excluirProgramacaoKit(objProg);
                    }
                    break;
                default:
                    break;
            }
            Excluir();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, solicite liberação ao administrador do sistema.");
        }
    }//GEN-LAST:event_jBtExcluirTodosActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaProgramacaoKitIndAL);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoAL.equals("ADMINISTRADORES") || codigoUserAL == codUserAcessoAL && nomeTelaAL.equals(telaProgramacaoKitIndAL) && codGravarAL == 1) {
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            Integer rows = jTabelaDestino.getRowCount();
            if (jDataUltimoPagto.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data do último pagamento de kit.");
            } else if (jDataPrevisao.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data para o próximo pagamento do kit.");
            } else if (rows == 0) {
                JOptionPane.showMessageDialog(rootPane, "Não existem internos selecionados para programação dos próximos pagamento de kit.");
            } else {
                if (jRBDencendial.isSelected() == true) {
                    tipoKit = 1;
                    int pValor = 1;
                    nomeCampoTabela = "KitDecendial";
                    buscar_ID_KIT_DECENDIAL(pValor);
                } else if (jRBQuinzenal.isSelected() == true) {
                    tipoKit = 2;
                    int pValor = 1;
                    nomeCampoTabela = "KitQuinzenal";
                    buscar_ID_KIT_QUINZENAL(pValor);
                } else if (jRBMensal.isSelected() == true) {
                    tipoKit = 3;
                    int pValor = 1;
                    nomeCampoTabela = "KitMensal";
                    buscar_ID_KIT_MENSAL(pValor);
                } else if (jRBSemestral.isSelected() == true) {
                    tipoKit = 4;
                    int pValor = 1;
                    nomeCampoTabela = "KitSemestral";
                    buscar_ID_KIT_SEMESTRAL(pValor);
                } else if (jRBAnual.isSelected() == true) {
                    tipoKit = 5;
                    int pValor = 1;
                    nomeCampoTabela = "KitAnual";
                    buscar_ID_KIT_ANUAL(pValor);
                }
                objProg.setDataUltimoPagto(jDataUltimoPagto.getDate());
                objProg.setDataPrevisao(jDataPrevisao.getDate());
                objProg.setDataPROG(jDataGeracao.getDate());
                objProg.setTipoKit(tipoKit);
                objProg.setIdPav(codigoPavilhao);
                objProg.setIdKit(idKitBusca);
                objProg.setKitPago("Não");
                objProg.setProgGerado("Sim");
                objProg.setDataPagamento(null);
                objProg.setDescricaoPav((String) jComboBoxPavilhao.getSelectedItem());
                //
                objProg.setUsuarioInsert(nameUser);
                objProg.setDataInsert(dataModFinal);
                objProg.setHorarioInsert(horaMov);
                //PESQUISAR CÓDIGO DO PAVILHÃO PARA COMPARAR SE O KIT JÁ FOI PROGRAMADO
                buscarPavilhao(objProg.getDescricaoPav());
                // VERIFICAR SE JÁ FOI GERADO A PREVISÃO
                pesquisarProgramacaoPagamento();
                //SE O ID DO PAVILHÃO EXISTIR E O KIT NÃO FOR PAGO
                if (idPav == codigoPavilhao && kitPago.equals("Não") && codigoKit == idKitBusca) {
                    JOptionPane.showMessageDialog(rootPane, "Já foi gerado a previsão de pagamento para esse pavilhão.");
                } else {
                    controlPagtoKit.incluirProgramacaoKit(objProg);
                    buscarCodigo();
                    if (jRBDencendial.isSelected() == true) {
                        mostrarProxKitDecendial();
                    } else if (jRBQuinzenal.isSelected() == true) {
                        mostrarProxKitQuinzenal();
                    } else if (jRBMensal.isSelected() == true) {
                        mostrarProxKitMensal();
                    } else if (jRBSemestral.isSelected() == true) {
                        mostrarProxKitSemestral();
                    } else if (jRBAnual.isSelected() == true) {
                        mostrarProxKitAnual();
                    }
                }
                Salvar();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, solicite liberação ao administrador do sistema.");
        }
    }//GEN-LAST:event_jBtSalvarActionPerformed

    private void jBtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarActionPerformed
        // TODO add your handling code here:
        Cancelar();
    }//GEN-LAST:event_jBtCancelarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtPesquisaKitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisaKitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtPesquisaKitActionPerformed

    private void jBtPesquisaDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisaDataActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (tipoServidor == null || tipoServidor.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "É necessário definir o parâmtero para o sistema operacional utilizado no servidor, (UBUNTU-LINUX ou WINDOWS SERVER).");
        } else if (tipoServidor.equals("Servidor Linux (Ubuntu)/MS-SQL Server")) {
            if (jRB_DECENDIAL.isSelected() == true) {
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
                            preencherTabelaProgramacao("SELECT DISTINCT IdPROG,DataPROG,TipoKit,DataUltimoPagto,DataPrevisao "
                                    + "FROM PROGRAMACAO_PAGAMENTO_KITS_INTERNOS "
                                    + "INNER JOIN KITS_DECENDIAL_INTERNOS "
                                    + "ON PROGRAMACAO_PAGAMENTO_KITS_INTERNOS.IdPROG=KITS_DECENDIAL_INTERNOS.IDREG_PROG "
                                    + "WHERE DataPROG BETWEEN'" + dataInicial + "' "
                                    + "AND '" + dataFinal + "'");
                        }
                    }
                }
            } else if (jRB_QUINZENAL.isSelected() == true) {
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
                            preencherTabelaProgramacao("SELECT DISTINCT IdPROG,DataPROG,TipoKit,DataUltimoPagto,KITS_QUINZENAL_INTERNOS.DataPrevisao "
                                    + "FROM PROGRAMACAO_PAGAMENTO_KITS_INTERNOS "
                                    + "INNER JOIN KITS_QUINZENAL_INTERNOS "
                                    + "ON PROGRAMACAO_PAGAMENTO_KITS_INTERNOS.IdPROG=KITS_QUINZENAL_INTERNOS.IDREG_PROG "
                                    + "WHERE DataPROG BETWEEN'" + dataInicial + "' "
                                    + "AND '" + dataFinal + "'");
                        }
                    }
                }
            } else if (jRB_MENSAL.isSelected() == true) {
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
                            preencherTabelaProgramacao("SELECT DISTINCT IdPROG,DataPROG,TipoKit,DataUltimoPagto,DataPrevisao "
                                    + "FROM PROGRAMACAO_PAGAMENTO_KITS_INTERNOS "
                                    + "INNER JOIN KITS_MENSAL_INTERNOS "
                                    + "ON PROGRAMACAO_PAGAMENTO_KITS_INTERNOS.IdPROG=KITS_MENSAL_INTERNOS.IDREG_PROG "
                                    + "WHERE DataPROG BETWEEN'" + dataInicial + "' "
                                    + "AND '" + dataFinal + "'");
                        }
                    }
                }
            } else if (jRB_SEMESTRAL.isSelected() == true) {
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
                            preencherTabelaProgramacao("SELECT DISTINCT IdPROG,DataPROG,TipoKit,DataUltimoPagto,DataPrevisao "
                                    + "FROM PROGRAMACAO_PAGAMENTO_KITS_INTERNOS "
                                    + "INNER JOIN KITS_SEMESTRAL_INTERNOS "
                                    + "ON PROGRAMACAO_PAGAMENTO_KITS_INTERNOS.IdPROG=KITS_SEMESTRAL_INTERNOS.IDREG_PROG "
                                    + "WHERE DataPROG BETWEEN'" + dataInicial + "' "
                                    + "AND '" + dataFinal + "'");
                        }
                    }
                }
            } else if (jRB_ANUAL.isSelected() == true) {
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
                            preencherTabelaProgramacao("SELECT DISTINCT IdPROG,DataPROG,TipoKit,DataUltimoPagto,DataPrevisao "
                                    + "FROM PROGRAMACAO_PAGAMENTO_KITS_INTERNOS "
                                    + "INNER JOIN KITS_ANUAL_INTERNOS "
                                    + "ON PROGRAMACAO_PAGAMENTO_KITS_INTERNOS.IdPROG=KITS_ANUAL_INTERNOS.IDREG_PROG "
                                    + "WHERE DataPROG BETWEEN'" + dataInicial + "' "
                                    + "AND '" + dataFinal + "'");
                        }
                    }
                }
            }
        } else if (tipoServidor.equals("Servidor Windows/MS-SQL Server")) {
            if (jRB_DECENDIAL.isSelected() == true) {
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
                            preencherTabelaProgramacao("SELECT DISTINCT IdPROG,DataPROG,TipoKit,DataUltimoPagto,DataPrevisao "
                                    + "FROM PROGRAMACAO_PAGAMENTO_KITS_INTERNOS "
                                    + "INNER JOIN KITS_DECENDIAL_INTERNOS "
                                    + "ON PROGRAMACAO_PAGAMENTO_KITS_INTERNOS.IdPROG=KITS_DECENDIAL_INTERNOS.IDREG_PROG "
                                    + "WHERE DataPROG BETWEEN'" + dataInicial + "' "
                                    + "AND '" + dataFinal + "'");
                        }
                    }
                }
            } else if (jRB_QUINZENAL.isSelected() == true) {
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
                            preencherTabelaProgramacao("SELECT DISTINCT IdPROG,DataPROG,TipoKit,DataUltimoPagto,KITS_QUINZENAL_INTERNOS.DataPrevisao "
                                    + "FROM PROGRAMACAO_PAGAMENTO_KITS_INTERNOS "
                                    + "INNER JOIN KITS_QUINZENAL_INTERNOS "
                                    + "ON PROGRAMACAO_PAGAMENTO_KITS_INTERNOS.IdPROG=KITS_QUINZENAL_INTERNOS.IDREG_PROG "
                                    + "WHERE DataPROG BETWEEN'" + dataInicial + "' "
                                    + "AND '" + dataFinal + "'");
                        }
                    }
                }
            } else if (jRB_MENSAL.isSelected() == true) {
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
                            preencherTabelaProgramacao("SELECT DISTINCT IdPROG,DataPROG,TipoKit,DataUltimoPagto,DataPrevisao "
                                    + "FROM PROGRAMACAO_PAGAMENTO_KITS_INTERNOS "
                                    + "INNER JOIN KITS_MENSAL_INTERNOS "
                                    + "ON PROGRAMACAO_PAGAMENTO_KITS_INTERNOS.IdPROG=KITS_MENSAL_INTERNOS.IDREG_PROG "
                                    + "WHERE DataPROG BETWEEN'" + dataInicial + "' "
                                    + "AND '" + dataFinal + "'");
                        }
                    }
                }
            } else if (jRB_SEMESTRAL.isSelected() == true) {
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
                            preencherTabelaProgramacao("SELECT DISTINCT IdPROG,DataPROG,TipoKit,DataUltimoPagto,DataPrevisao "
                                    + "FROM PROGRAMACAO_PAGAMENTO_KITS_INTERNOS "
                                    + "INNER JOIN KITS_SEMESTRAL_INTERNOS "
                                    + "ON PROGRAMACAO_PAGAMENTO_KITS_INTERNOS.IdPROG=KITS_SEMESTRAL_INTERNOS.IDREG_PROG "
                                    + "WHERE DataPROG BETWEEN'" + dataInicial + "' "
                                    + "AND '" + dataFinal + "'");
                        }
                    }
                }
            } else if (jRB_ANUAL.isSelected() == true) {
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
                            preencherTabelaProgramacao("SELECT DISTINCT IdPROG,DataPROG,TipoKit,DataUltimoPagto,DataPrevisao "
                                    + "FROM PROGRAMACAO_PAGAMENTO_KITS_INTERNOS "
                                    + "INNER JOIN KITS_ANUAL_INTERNOS "
                                    + "ON PROGRAMACAO_PAGAMENTO_KITS_INTERNOS.IdPROG=KITS_ANUAL_INTERNOS.IDREG_PROG "
                                    + "WHERE DataPROG BETWEEN'" + dataInicial + "' "
                                    + "AND '" + dataFinal + "'");
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_jBtPesquisaDataActionPerformed

    private void jCheckBoxTodosRegistrosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxTodosRegistrosItemStateChanged
        // TODO add your handling code here:
        flag = 1;
        count = 0;
        if (jRB_DECENDIAL.isSelected() == true) {
            if (evt.getStateChange() == evt.SELECTED) {
                preencherTabelaProgramacao("SELECT DISTINCT IdPROG,DataPROG,TipoKit,DataUltimoPagto,DataPrevisao "
                        + "FROM PROGRAMACAO_PAGAMENTO_KITS_INTERNOS "
                        + "INNER JOIN KITS_DECENDIAL_INTERNOS "
                        + "ON PROGRAMACAO_PAGAMENTO_KITS_INTERNOS.IdPROG=KITS_DECENDIAL_INTERNOS.IDREG_PROG");
            } else {
                limparTabelaProgramacao();
                jtotalRegistros.setText("");
            }
        } else if (jRB_QUINZENAL.isSelected() == true) {
            if (evt.getStateChange() == evt.SELECTED) {
                preencherTabelaProgramacao("SELECT DISTINCT IdPROG,DataPROG,TipoKit,DataUltimoPagto,PROGRAMACAO_PAGAMENTO_KITS_INTERNOS.DataPrevisao "
                        + "FROM PROGRAMACAO_PAGAMENTO_KITS_INTERNOS "
                        + "INNER JOIN KITS_QUINZENAL_INTERNOS "
                        + "ON PROGRAMACAO_PAGAMENTO_KITS_INTERNOS.IdPROG=KITS_QUINZENAL_INTERNOS.IDREG_PROG");
            } else {
                limparTabelaProgramacao();
                jtotalRegistros.setText("");
            }
        } else if (jRB_MENSAL.isSelected() == true) {
            if (evt.getStateChange() == evt.SELECTED) {
                preencherTabelaProgramacao("SELECT DISTINCT IdPROG,DataPROG,TipoKit,DataUltimoPagto,DataPrevisao "
                        + "FROM PROGRAMACAO_PAGAMENTO_KITS_INTERNOS "
                        + "INNER JOIN KITS_MENSAL_INTERNOS "
                        + "ON PROGRAMACAO_PAGAMENTO_KITS_INTERNOS.IdPROG=KITS_MENSAL_INTERNOS.IDREG_PROG");
            } else {
                limparTabelaProgramacao();
                jtotalRegistros.setText("");
            }
        } else if (jRB_SEMESTRAL.isSelected() == true) {
            if (evt.getStateChange() == evt.SELECTED) {
                preencherTabelaProgramacao("SELECT DISTINCT IdPROG,DataPROG,TipoKit,DataUltimoPagto,DataPrevisao "
                        + "FROM PROGRAMACAO_PAGAMENTO_KITS_INTERNOS "
                        + "INNER JOIN KITS_SEMESTRAL_INTERNOS "
                        + "ON PROGRAMACAO_PAGAMENTO_KITS_INTERNOS.IdPROG=KITS_SEMESTRAL_INTERNOS.IDREG_PROG");
            } else {
                limparTabelaProgramacao();
                jtotalRegistros.setText("");
            }
        } else if (jRB_ANUAL.isSelected() == true) {
            if (evt.getStateChange() == evt.SELECTED) {
                preencherTabelaProgramacao("SELECT DISTINCT IdPROG,DataPROG,TipoKit,DataUltimoPagto,DataPrevisao "
                        + "FROM PROGRAMACAO_PAGAMENTO_KITS_INTERNOS "
                        + "INNER JOIN KITS_ANUAL_INTERNOS "
                        + "ON PROGRAMACAO_PAGAMENTO_KITS_INTERNOS.IdPROG=KITS_ANUAL_INTERNOS.IDREG_PROG");
            } else {
                limparTabelaProgramacao();
                jtotalRegistros.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione um dos kits para pesquisa...");
        }
    }//GEN-LAST:event_jCheckBoxTodosRegistrosItemStateChanged

    private void jBtAuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaProgramacaoKit objAudiPro = new TelaAuditoriaProgramacaoKit();
        TelaModuloAlmoxarifado.jPainelAlmoxarifado.add(objAudiPro);
        objAudiPro.show();
    }//GEN-LAST:event_jBtAuditoriaActionPerformed

    private void jTabelaProgramacaoKitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaProgramacaoKitMouseClicked
        // TODO add your handling code here:
        limparTabelaInternos();
        flag = 1;
        if (flag == 1) {
            String idLanc = "" + jTabelaProgramacaoKit.getValueAt(jTabelaProgramacaoKit.getSelectedRow(), 0);
            //
            jBtNovo.setEnabled(true);
            jBtExcluirTodos.setEnabled(true);
            jBtExcluirUm.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            jBtImpressao.setEnabled(true);
            jComboBoxPavilhao.removeAllItems();
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM PROGRAMACAO_PAGAMENTO_KITS_INTERNOS "
                        + "INNER JOIN PAVILHAO "
                        + "ON PROGRAMACAO_PAGAMENTO_KITS_INTERNOS.IdPav=PAVILHAO.IdPav "
                        + "WHERE IdPROG='" + idLanc + "'");
                conecta.rs.first();
                idPROG = conecta.rs.getInt("IdPROG");
                jDataUltimoPagto.setDate(conecta.rs.getDate("DataUltimoPagto"));
                jComboBoxPavilhao.addItem(conecta.rs.getString("DescricaoPav"));
                jDataPrevisao.setDate(conecta.rs.getDate("DataPrevisao"));
                jDataGeracao.setDate(conecta.rs.getDate("DataPROG"));
                tipoKit = conecta.rs.getInt("TipoKit");
                switch (tipoKit) {
                    case 1:
                        tipoKit = 1;
                        jRBDencendial.setSelected(true);
                        mostraSelecaoInternosKDExcluir();
                        break;
                    case 2:
                        tipoKit = 2;
                        jRBQuinzenal.setSelected(true);
                        mostraSelecaoInternosKQExcluir();
                        break;
                    case 3:
                        tipoKit = 3;
                        jRBMensal.setSelected(true);
                        mostraSelecaoInternosKMExcluir();
                        break;
                    case 4:
                        tipoKit = 4;
                        jRBSemestral.setSelected(true);
                        mostraSelecaoInternosKSExcluir();
                        break;
                    case 5:
                        tipoKit = 5;
                        jRBAnual.setSelected(true);
                        mostraSelecaoInternosKAExcluir();
                        break;
                    default:
                        break;
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "Não foi possível selecionar o registro.\nERRO: " + e);
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaProgramacaoKitMouseClicked

    private void jBtExcluirUmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirUmActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaProgramacaoKitIndAL);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoAL.equals("ADMINISTRADORES") || codigoUserAL == codUserAcessoAL && nomeTelaAL.equals(telaProgramacaoKitIndAL) && codExcluirAL == 1) {
            mostrarExcluirUm();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, solicite liberação ao administrador do sistema.");
        }
    }//GEN-LAST:event_jBtExcluirUmActionPerformed

    private void jBtImpressaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImpressaoActionPerformed
        // TODO add your handling code here:
        if (idPROG == 0) {
            JOptionPane.showMessageDialog(rootPane, "É necessário selecionar um registro para ser impresso...");
        } else {
            if (jRBDencendial.isSelected() == true) {
                try {
                    conecta.abrirConexao();
                    String path = "reports/ProgramacaoKitDecendial.jasper";
                    conecta.executaSQL("SELECT * FROM PROGRAMACAO_PAGAMENTO_KITS_INTERNOS "
                            + "INNER JOIN KITS_DECENDIAL_INTERNOS "
                            + "ON PROGRAMACAO_PAGAMENTO_KITS_INTERNOS.IdPROG=KITS_DECENDIAL_INTERNOS.IDREG_PROG "
                            + "INNER JOIN PAVILHAO "
                            + "ON PROGRAMACAO_PAGAMENTO_KITS_INTERNOS.IdPav=PAVILHAO.IdPav "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON KITS_DECENDIAL_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "WHERE IdPROG='" + idPROG + "'");
                    HashMap parametros = new HashMap();
                    parametros.put("pUsuario", nameUser);
                    parametros.put("pUnidade", descricaoUnidade);
                    JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
                    JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
                    JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
                    jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
                    jv.setTitle("Relatório de Programação de Kit Decendial");
                    jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
                    jv.toFront(); // Traz o relatorio para frente da aplicação            
                    conecta.desconecta();
                } catch (JRException e) {
                    JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
                }
            } else if (jRBQuinzenal.isSelected() == true) {
                try {
                    conecta.abrirConexao();
                    String path = "reports/ProgramacaoKitQuinzenal.jasper";
                    conecta.executaSQL("SELECT * FROM PROGRAMACAO_PAGAMENTO_KITS_INTERNOS "
                            + "INNER JOIN KITS_QUINZENAL_INTERNOS "
                            + "ON PROGRAMACAO_PAGAMENTO_KITS_INTERNOS.IdPROG=KITS_QUINZENAL_INTERNOS.IDREG_PROG "
                            + "INNER JOIN PAVILHAO "
                            + "ON PROGRAMACAO_PAGAMENTO_KITS_INTERNOS.IdPav=PAVILHAO.IdPav "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON KITS_QUINZENAL_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "WHERE IdPROG='" + idPROG + "'");
                    HashMap parametros = new HashMap();
                    parametros.put("pUsuario", nameUser);
                    parametros.put("pUnidade", descricaoUnidade);
                    JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
                    JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
                    JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
                    jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
                    jv.setTitle("Relatório de Programação de Kit Quinzenal");
                    jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
                    jv.toFront(); // Traz o relatorio para frente da aplicação            
                    conecta.desconecta();
                } catch (JRException e) {
                    JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
                }
            } else if (jRBMensal.isSelected() == true) {
                try {
                    conecta.abrirConexao();
                    String path = "reports/ProgramacaoKitMensal.jasper";
                    conecta.executaSQL("SELECT * FROM PROGRAMACAO_PAGAMENTO_KITS_INTERNOS "
                            + "INNER JOIN KITS_MENSAL_INTERNOS "
                            + "ON PROGRAMACAO_PAGAMENTO_KITS_INTERNOS.IdPROG=KITS_MENSAL_INTERNOS.IDREG_PROG "
                            + "INNER JOIN PAVILHAO "
                            + "ON PROGRAMACAO_PAGAMENTO_KITS_INTERNOS.IdPav=PAVILHAO.IdPav "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON KITS_MENSAL_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "WHERE IdPROG='" + idPROG + "'");
                    HashMap parametros = new HashMap();
                    parametros.put("pUsuario", nameUser);
                    parametros.put("pUnidade", descricaoUnidade);
                    JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
                    JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
                    JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
                    jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
                    jv.setTitle("Relatório de Programação de Kit Mensal");
                    jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
                    jv.toFront(); // Traz o relatorio para frente da aplicação            
                    conecta.desconecta();
                } catch (JRException e) {
                    JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
                }
            } else if (jRBSemestral.isSelected() == true) {
                try {
                    conecta.abrirConexao();
                    String path = "reports/ProgramacaoKitSemestral.jasper";
                    conecta.executaSQL("SELECT * FROM PROGRAMACAO_PAGAMENTO_KITS_INTERNOS "
                            + "INNER JOIN KITS_SEMESTRAL_INTERNOS "
                            + "ON PROGRAMACAO_PAGAMENTO_KITS_INTERNOS.IdPROG=KITS_SEMESTRAL_INTERNOS.IDREG_PROG "
                            + "INNER JOIN PAVILHAO "
                            + "ON PROGRAMACAO_PAGAMENTO_KITS_INTERNOS.IdPav=PAVILHAO.IdPav "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON KITS_SEMESTRAL_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "WHERE IdPROG='" + idPROG + "'");
                    HashMap parametros = new HashMap();
                    parametros.put("pUsuario", nameUser);
                    parametros.put("pUnidade", descricaoUnidade);
                    JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
                    JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
                    JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
                    jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
                    jv.setTitle("Relatório de Programação de Kit Semestral");
                    jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
                    jv.toFront(); // Traz o relatorio para frente da aplicação            
                    conecta.desconecta();
                } catch (JRException e) {
                    JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
                }
            } else if (jRBAnual.isSelected() == true) {
                try {
                    conecta.abrirConexao();
                    String path = "reports/ProgramacaoKitAnual.jasper";
                    conecta.executaSQL("SELECT * FROM PROGRAMACAO_PAGAMENTO_KITS_INTERNOS "
                            + "INNER JOIN KITS_ANUAL_INTERNOS "
                            + "ON PROGRAMACAO_PAGAMENTO_KITS_INTERNOS.IdPROG=KITS_ANUAL_INTERNOS.IDREG_PROG "
                            + "INNER JOIN PAVILHAO "
                            + "ON PROGRAMACAO_PAGAMENTO_KITS_INTERNOS.IdPav=PAVILHAO.IdPav "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON KITS_ANUAL_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "WHERE IdPROG='" + idPROG + "'");
                    HashMap parametros = new HashMap();
                    parametros.put("pUsuario", nameUser);
                    parametros.put("pUnidade", descricaoUnidade);
                    JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
                    JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
                    JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
                    jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
                    jv.setTitle("Relatório de Programação de Kit Anual");
                    jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
                    jv.toFront(); // Traz o relatorio para frente da aplicação            
                    conecta.desconecta();
                } catch (JRException e) {
                    JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
                }
            }
        }
    }//GEN-LAST:event_jBtImpressaoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jBtAdicionarTodos;
    private javax.swing.JButton jBtAdicionarUm;
    public static javax.swing.JButton jBtAuditoria;
    public static javax.swing.JButton jBtCancelar;
    public static javax.swing.JButton jBtExcluirTodos;
    public static javax.swing.JButton jBtExcluirUm;
    public static javax.swing.JButton jBtImpressao;
    private javax.swing.JButton jBtNomePesquisa;
    private javax.swing.JButton jBtNovo;
    private javax.swing.JButton jBtPesquisaData;
    private javax.swing.JButton jBtPesquisaKit;
    private javax.swing.JButton jBtSair;
    public static javax.swing.JButton jBtSalvar;
    private javax.swing.JButton jBtVoltarTodos;
    private javax.swing.JButton jBtVoltarUm;
    private javax.swing.JCheckBox jCheckBoxTodos;
    private javax.swing.JCheckBox jCheckBoxTodosRegistros;
    public static javax.swing.JComboBox<String> jComboBoxPavilhao;
    private com.toedter.calendar.JDateChooser jDataFinal;
    private com.toedter.calendar.JDateChooser jDataGeracao;
    private com.toedter.calendar.JDateChooser jDataInicial;
    public static com.toedter.calendar.JDateChooser jDataPrevisao;
    public static com.toedter.calendar.JDateChooser jDataUltimoPagto;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JTextField jNomeInternoPesq;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRBAnual;
    private javax.swing.JRadioButton jRBDencendial;
    private javax.swing.JRadioButton jRBMensal;
    private javax.swing.JRadioButton jRBQuinzenal;
    private javax.swing.JRadioButton jRBSemestral;
    private javax.swing.JRadioButton jRB_ANUAL;
    private javax.swing.JRadioButton jRB_DECENDIAL;
    private javax.swing.JRadioButton jRB_MENSAL;
    private javax.swing.JRadioButton jRB_QUINZENAL;
    private javax.swing.JRadioButton jRB_SEMESTRAL;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JTable jTabelaDestino;
    public static javax.swing.JTable jTabelaOrigem;
    private javax.swing.JTable jTabelaProgramacaoKit;
    public static javax.swing.JLabel jtotalDestino;
    public static javax.swing.JLabel jtotalOrigem;
    public static javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void corCampos() {
        jNomeInternoPesq.setBackground(Color.white);
    }

    public void bloquearCampos() {
        jDataUltimoPagto.setEnabled(!true);
        jComboBoxPavilhao.setEnabled(!true);
        jNomeInternoPesq.setEnabled(!true);
        jRBDencendial.setEnabled(!true);
        jRBQuinzenal.setEnabled(!true);
        jRBMensal.setEnabled(!true);
        jRBSemestral.setEnabled(!true);
        jRBAnual.setEnabled(!true);
    }

    public void bloquearBotoes() {
        jBtNovo.setEnabled(!true);
        jBtExcluirTodos.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        jBtNomePesquisa.setEnabled(!true);
        jCheckBoxTodos.setEnabled(!true);
        jBtAdicionarUm.setEnabled(!true);
        jBtAdicionarTodos.setEnabled(!true);
        jBtVoltarUm.setEnabled(!true);
        jBtVoltarTodos.setEnabled(!true);
        jBtImpressao.setEnabled(!true);
    }

    public void limparCampos() {
        jComboBoxPavilhao.setSelectedItem(null);
        jNomeInternoPesq.setText("");
        jDataUltimoPagto.setDate(null);
        jDataPrevisao.setDate(null);
        jDataGeracao.setDate(null);
    }

    public void Novo() {
        jDataUltimoPagto.setEnabled(true);
        jComboBoxPavilhao.setEnabled(true);
        jNomeInternoPesq.setEnabled(true);
        jRBDencendial.setEnabled(true);
        jRBQuinzenal.setEnabled(true);
        jRBMensal.setEnabled(true);
        jRBSemestral.setEnabled(true);
        jRBAnual.setEnabled(true);
        jDataGeracao.setCalendar(Calendar.getInstance());
        //        
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        //        
        jBtNomePesquisa.setEnabled(true);
        jCheckBoxTodos.setEnabled(true);
        jBtAdicionarUm.setEnabled(true);
        jBtAdicionarTodos.setEnabled(true);
        jBtVoltarUm.setEnabled(true);
        jBtVoltarTodos.setEnabled(true);
    }

    public void Excluir() {
        bloquearBotoes();
        bloquearCampos();
        limparCampos();
        limparTabelaInternos();
        jBtNovo.setEnabled(true);
    }

    public void Salvar() {
        bloquearBotoes();
        bloquearCampos();
        jBtNovo.setEnabled(true);
        jBtExcluirTodos.setEnabled(true);
        jBtExcluirUm.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        jBtImpressao.setEnabled(true);
    }

    public void Cancelar() {
        idPROG = 0;
        if (idPROG == 0) {
            bloquearBotoes();
            bloquearCampos();
            limparCampos();
            limparTabelaInternos();
            jBtNovo.setEnabled(true);
        } else {
            bloquearBotoes();
            bloquearCampos();
            limparCampos();
            limparTabelaInternos();
            jBtNovo.setEnabled(true);
            jBtImpressao.setEnabled(true);
        }
    }

    public void buscar_ID_KIT_DECENDIAL(int valor) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT KitDecendial,IdKit FROM KITS_HIGIENE_INTERNO "
                    + "WHERE KitDecendial='" + valor + "'");
            conecta.rs.first();
            idKitBusca = conecta.rs.getInt("IdKit");
        } catch (SQLException ex) {
            Logger.getLogger(TelaProgramacaoKitsHigiene.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
    }

    public void buscar_ID_KIT_QUINZENAL(int valor) {
        conecta.abrirConexao();

        try {
            conecta.executaSQL("SELECT * FROM KITS_HIGIENE_INTERNO WHERE KitQuinzenal='" + valor + "'");
            conecta.rs.first();
            idKitBusca = conecta.rs.getInt("IdKit");
        } catch (SQLException ex) {
            Logger.getLogger(TelaProgramacaoKitsHigiene.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
    }

    public void buscar_ID_KIT_MENSAL(int valor) {
        conecta.abrirConexao();

        try {
            conecta.executaSQL("SELECT * FROM KITS_HIGIENE_INTERNO WHERE KitMensal='" + valor + "'");
            conecta.rs.first();
            idKitBusca = conecta.rs.getInt("IdKit");
        } catch (SQLException ex) {
            Logger.getLogger(TelaProgramacaoKitsHigiene.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
    }

    public void buscar_ID_KIT_SEMESTRAL(int valor) {
        conecta.abrirConexao();

        try {
            conecta.executaSQL("SELECT * FROM KITS_HIGIENE_INTERNO WHERE KitSemestral='" + valor + "'");
            conecta.rs.first();
            idKitBusca = conecta.rs.getInt("IdKit");
        } catch (SQLException ex) {
            Logger.getLogger(TelaProgramacaoKitsHigiene.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
    }

    public void buscar_ID_KIT_ANUAL(int valor) {
        conecta.abrirConexao();

        try {
            conecta.executaSQL("SELECT * FROM KITS_HIGIENE_INTERNO WHERE KitAnual='" + valor + "'");
            conecta.rs.first();
            idKitBusca = conecta.rs.getInt("IdKit");
        } catch (SQLException ex) {
            Logger.getLogger(TelaProgramacaoKitsHigiene.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
    }

    public void buscarCodigo() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PROGRAMACAO_PAGAMENTO_KITS_INTERNOS");
            conecta.rs.last();
            idPROG = conecta.rs.getInt("IdPROG");
        } catch (SQLException ex) {
        }
        conecta.desconecta();
    }

    public void pesquisarPavilhao() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PAVILHAO ORDER BY DescricaoPav");
            conecta.rs.first();
            do {
                jComboBoxPavilhao.addItem(conecta.rs.getString("DescricaoPav"));
                codigoPavilhao = conecta.rs.getInt("IdPav");
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        conecta.desconecta();
    }

    public void buscarPavilhao(String nomePav) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PAVILHAO "
                    + "WHERE DescricaoPav='" + nomePav + "'");
            conecta.rs.first();
            codigoPavilhao = conecta.rs.getInt("IdPav");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void preencherTabelaProgramacao(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Programação", "TipoKit", "Pagamento", "Previsão"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1;
                // Formatar a data Entrada

                dataEntrada = conecta.rs.getString("DataPROG");
                if (dataEntrada != null) {
                    String diae = dataEntrada.substring(8, 10);
                    String mese = dataEntrada.substring(5, 7);
                    String anoe = dataEntrada.substring(0, 4);
                    dataEntrada = diae + "/" + mese + "/" + anoe;
                }
                //
                dataUltimoPagto = conecta.rs.getString("DataUltimoPagto");
                if (dataUltimoPagto != null) {
                    String dia = dataUltimoPagto.substring(8, 10);
                    String mes = dataUltimoPagto.substring(5, 7);
                    String ano = dataUltimoPagto.substring(0, 4);
                    dataUltimoPagto = dia + "/" + mes + "/" + ano;
                }
                //
                dataPrevisao = conecta.rs.getString("DataPrevisao");
                if (dataPrevisao != null) {
                    String pdia = dataPrevisao.substring(8, 10);
                    String pmes = dataPrevisao.substring(5, 7);
                    String pano = dataPrevisao.substring(0, 4);
                    dataPrevisao = pdia + "/" + pmes + "/" + pano;
                }
                //
                tipoKit = conecta.rs.getInt("TipoKit");
                if (tipoKit == 1) {
                    nomeKit = "Kit Decendial";
                } else if (tipoKit == 2) {
                    nomeKit = "Kit Quinzenal";
                } else if (tipoKit == 3) {
                    nomeKit = "Kit Mensal";
                } else if (tipoKit == 4) {
                    nomeKit = "Kit Semestral";
                } else if (tipoKit == 5) {
                    nomeKit = "Kit Anual";
                }
                //
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdPROG"), dataEntrada, nomeKit, dataUltimoPagto, dataPrevisao});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaProgramacaoKit.setModel(modelo);
        jTabelaProgramacaoKit.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaProgramacaoKit.getColumnModel().getColumn(0).setResizable(false);
        jTabelaProgramacaoKit.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTabelaProgramacaoKit.getColumnModel().getColumn(1).setResizable(false);
        jTabelaProgramacaoKit.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaProgramacaoKit.getColumnModel().getColumn(2).setResizable(false);
        jTabelaProgramacaoKit.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaProgramacaoKit.getColumnModel().getColumn(3).setResizable(false);
        jTabelaProgramacaoKit.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTabelaProgramacaoKit.getColumnModel().getColumn(4).setResizable(false);
        jTabelaProgramacaoKit.getTableHeader().setReorderingAllowed(false);
        jTabelaProgramacaoKit.setAutoResizeMode(jTabelaProgramacaoKit.AUTO_RESIZE_OFF);
        jTabelaProgramacaoKit.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaProgramacao();
        conecta.desconecta();
    }

    public void alinharCamposTabelaProgramacao() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaProgramacaoKit.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaProgramacaoKit.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaProgramacaoKit.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        jTabelaProgramacaoKit.getColumnModel().getColumn(3).setCellRenderer(centralizado);
        jTabelaProgramacaoKit.getColumnModel().getColumn(4).setCellRenderer(centralizado);
    }

    public void limparTabelaProgramacao() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Programação", "TipoKit", "Pagamento", "Previsão"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaProgramacaoKit.setModel(modelo);
        jTabelaProgramacaoKit.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaProgramacaoKit.getColumnModel().getColumn(0).setResizable(false);
        jTabelaProgramacaoKit.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTabelaProgramacaoKit.getColumnModel().getColumn(1).setResizable(false);
        jTabelaProgramacaoKit.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaProgramacaoKit.getColumnModel().getColumn(2).setResizable(false);
        jTabelaProgramacaoKit.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaProgramacaoKit.getColumnModel().getColumn(3).setResizable(false);
        jTabelaProgramacaoKit.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTabelaProgramacaoKit.getColumnModel().getColumn(4).setResizable(false);
        jTabelaProgramacaoKit.getTableHeader().setReorderingAllowed(false);
        jTabelaProgramacaoKit.setAutoResizeMode(jTabelaProgramacaoKit.AUTO_RESIZE_OFF);
        jTabelaProgramacaoKit.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void limparTabelaInternos() {
        // APAGAR DADOS DA TABELA PRODUTOS
        while (jTabelaOrigem.getModel().getRowCount() > 0) {
            ((DefaultTableModel) jTabelaOrigem.getModel()).removeRow(0);
        }
        // LIMPAR O TOTALIZADOR DA TABELA PRODUTOS
        jtotalOrigem.setText("");
        // APAGAR DADOS DA TABELA INTERNOS SELECIONADOS
        while (jTabelaDestino.getModel().getRowCount() > 0) {
            ((DefaultTableModel) jTabelaDestino.getModel()).removeRow(0);
        }
        // LIMPAR O TOTALIZADOR DA TABELA PRODUTOS SELECIONADOS PARA BAIXA
        jtotalDestino.setText("");
        qtdInternos = 0;
        jtotalOrigem.setText(Integer.toString(qtdInternos));
        jtotalDestino.setText(Integer.toString(qtdInternos));
    }

    // LISTAR OS TODOS OS INTERNOS QUE FORAM SELECIONADOS KIT INICIAL PARA PAGAMENTO DO KIT DENCENDIAL
    public void mostraSelecaoInternosKitDecendial() {
        DefaultTableModel dadosOrigem = (DefaultTableModel) jTabelaOrigem.getModel();
        GravarInternosKitCompleto d = new GravarInternosKitCompleto();
        try {
            for (GravarInternosKitCompleto dd : controleKDTodos.read()) {
                jtotalOrigem.setText(Integer.toString(qtdInternos)); // Converter inteiro em string para exibir na tela 
                dadosOrigem.addRow(new Object[]{dd.getIdInternoCrc(), dd.getNomeInternoCrc()});
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaOrigem.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaOrigem.getColumnModel().getColumn(0).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaPrevisaoKitHigiene.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //KIT DECENDIAL
    public void mostraSelecaoInternosKDExcluir() {
        qtdInternos = 0;
        DefaultTableModel dadosDestino = (DefaultTableModel) jTabelaDestino.getModel();
        GravarInternosKitCompleto d = new GravarInternosKitCompleto();
        try {
            for (GravarInternosKitCompleto dd : controlListKD.read()) {
                jtotalDestino.setText(Integer.toString(qtdInternos)); // Converter inteiro em string para exibir na tela 
                dadosDestino.addRow(new Object[]{dd.getIdInternoCrc(), dd.getNomeInternoCrc()});
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaDestino.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaDestino.getColumnModel().getColumn(0).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaPrevisaoKitHigiene.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //KIT QUINZENAL
    public void mostraSelecaoInternosKQExcluir() {
        qtdInternos = 0;
        DefaultTableModel dadosDestino = (DefaultTableModel) jTabelaDestino.getModel();
        GravarInternosKitCompleto d = new GravarInternosKitCompleto();
        try {
            for (GravarInternosKitCompleto dd : controlListKQ.read()) {
                jtotalDestino.setText(Integer.toString(qtdInternos)); // Converter inteiro em string para exibir na tela 
                dadosDestino.addRow(new Object[]{dd.getIdInternoCrc(), dd.getNomeInternoCrc()});
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaDestino.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaDestino.getColumnModel().getColumn(0).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaPrevisaoKitHigiene.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //KIT MENSAL
    public void mostraSelecaoInternosKMExcluir() {
        qtdInternos = 0;
        DefaultTableModel dadosDestino = (DefaultTableModel) jTabelaDestino.getModel();
        GravarInternosKitCompleto d = new GravarInternosKitCompleto();
        try {
            for (GravarInternosKitCompleto dd : controlListKM.read()) {
                jtotalDestino.setText(Integer.toString(qtdInternos)); // Converter inteiro em string para exibir na tela 
                dadosDestino.addRow(new Object[]{dd.getIdInternoCrc(), dd.getNomeInternoCrc()});
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaDestino.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaDestino.getColumnModel().getColumn(0).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaPrevisaoKitHigiene.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //KIT SEMESTRAL
    public void mostraSelecaoInternosKSExcluir() {
        qtdInternos = 0;
        DefaultTableModel dadosDestino = (DefaultTableModel) jTabelaDestino.getModel();
        GravarInternosKitCompleto d = new GravarInternosKitCompleto();
        try {
            for (GravarInternosKitCompleto dd : controlListKS.read()) {
                jtotalDestino.setText(Integer.toString(qtdInternos)); // Converter inteiro em string para exibir na tela 
                dadosDestino.addRow(new Object[]{dd.getIdInternoCrc(), dd.getNomeInternoCrc()});
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaDestino.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaDestino.getColumnModel().getColumn(0).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaPrevisaoKitHigiene.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //KIT ANUAL
    public void mostraSelecaoInternosKAExcluir() {
        qtdInternos = 0;
        DefaultTableModel dadosDestino = (DefaultTableModel) jTabelaDestino.getModel();
        GravarInternosKitCompleto d = new GravarInternosKitCompleto();
        try {
            for (GravarInternosKitCompleto dd : controlListKA.read()) {
                jtotalDestino.setText(Integer.toString(qtdInternos)); // Converter inteiro em string para exibir na tela 
                dadosDestino.addRow(new Object[]{dd.getIdInternoCrc(), dd.getNomeInternoCrc()});
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaDestino.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaDestino.getColumnModel().getColumn(0).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaPrevisaoKitHigiene.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void calcularVencimentoKit(int diaVencimento) {

        if (jDataUltimoPagto.getDate() != null) {
            SimpleDateFormat formatoAmerica = new SimpleDateFormat("yyyy/MM/dd");
            String dataUltimoPagto = formatoAmerica.format(jDataUltimoPagto.getDate().getTime());
            Date a = new Date(dataUltimoPagto);
            a.setDate(a.getDate() + diaVencimento);

            String formato = "dd/MM/yyyy";
            SimpleDateFormat dataFormatada = new SimpleDateFormat(formato);
//            System.out.println("Daqui há dez dias: " + dataFormatada.format(a));
            dataFormatada.format(a);
            jDataPrevisao.setDate(a);
        }
    }

    // VERIFICAR SE A DATA DE PREVISÃO JÁ FOI CADASTRADA E ALERTAR O USUÁRIO
    public void pesquisarProgramacaoPagamento() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PROGRAMACAO_PAGAMENTO_KITS_INTERNOS "
                    + "WHERE IdKit='" + idKitBusca + "' ");
            conecta.rs.first();
            kitPago = conecta.rs.getString("KitPago");
            idPav = conecta.rs.getInt("IdPav");
            codigoKit = conecta.rs.getInt("IdKit");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void buscarAcessoUsuario(String nomeTelaAcesso) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nameUser + "'");
            conecta.rs.first();
            codigoUserAL = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUserAL + "'");
            conecta.rs.first();
            codigoUserGroupAL = conecta.rs.getInt("IdUsuario");
            codigoGrupoAL = conecta.rs.getInt("IdGrupo");
            nomeGrupoAL = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUserAL + "' "
                    + "AND NomeTela='" + nomeTelaAcesso + "'");
            conecta.rs.first();
            codUserAcessoAL = conecta.rs.getInt("IdUsuario");
            codAbrirAL = conecta.rs.getInt("Abrir");
            codIncluirAL = conecta.rs.getInt("Incluir");
            codAlterarAL = conecta.rs.getInt("Alterar");
            codExcluirAL = conecta.rs.getInt("Excluir");
            codGravarAL = conecta.rs.getInt("Gravar");
            codConsultarAL = conecta.rs.getInt("Consultar");
            nomeTelaAL = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
