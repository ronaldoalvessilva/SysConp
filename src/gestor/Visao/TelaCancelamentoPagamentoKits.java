/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleAcessoGeral;
import gestor.Controle.ControleCancelamentoPagoKit;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControlePagamentoKitFinalizacao;
import gestor.Controle.PesquisaCancelamentoKitCodigo;
import gestor.Controle.PesquisaCancelamentoKitData;
import gestor.Controle.PesquisarInternosProdutosCanceladosKits;
import gestor.Controle.PesquisarInternosProdutosCancelados_kits;
import gestor.Controle.PesquisarProdutosCanceladosKits;
import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.CamposAcessos;
import gestor.Modelo.CancelamentoPagamentoKitHigiene;
import gestor.Modelo.ComposicaoKit;
import gestor.Modelo.LogSistema;
import static gestor.Visao.TelaLoginSenha.descricaoUnidade;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloAlmoxarifado.telaCancelamentoPagamentoInt;
import static gestor.Visao.TelaModuloAlmoxarifado.telaCancelamentoPagamentoManu;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import java.awt.Color;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
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
 * @author ronaldo.silva7
 */
public class TelaCancelamentoPagamentoKits extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    CancelamentoPagamentoKitHigiene objCancelaKit = new CancelamentoPagamentoKitHigiene();
    ControleCancelamentoPagoKit control = new ControleCancelamentoPagoKit();
    PesquisaCancelamentoKitCodigo listaCodigo = new PesquisaCancelamentoKitCodigo();
    PesquisaCancelamentoKitData listaData = new PesquisaCancelamentoKitData();
    //
    PesquisarInternosProdutosCanceladosKits listaInternos = new PesquisarInternosProdutosCanceladosKits();
    PesquisarInternosProdutosCancelados_kits LISTAR_internos = new PesquisarInternosProdutosCancelados_kits();
    PesquisarProdutosCanceladosKits listaItens = new PesquisarProdutosCanceladosKits();
    //
    ControleAcessoGeral pPESQUISAR_acessos = new ControleAcessoGeral();
    CamposAcessos objCampos = new CamposAcessos();
    //       
    ComposicaoKit objComp = new ComposicaoKit();
    ControlePagamentoKitFinalizacao controlPagoKit = new ControlePagamentoKitFinalizacao();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela = "Almoxarifado:Cancelamento de Pagamento de Kit de Higiene:Manutenção";
    String nomeModuloTela2 = "Almoxarifado:Cancelamento de Pagamento de Kit de Higiene:Internos/Produtos";
    //
    int flag;
    int acao;
    String dataEmissao, dataValidade;
    public static String dataInicial;
    public static String dataFinal;
    String dataEntrada;
    String statusMov;
    String horaMov;
    String dataModFinal;
    String statusProd = "Ativo";
    int count;
    public static String idItem;
    public static String pINTERNOS;
    public static int idItemINT = 0;
    public static int codItemINT = 0;
    public static int pCODIGO_pav = 0;
    public static int pCODIGO_cela = 0;
    public static int pTOTAL_registros = 0;
    //
    String pDATA_Registros = "";
    public static int pITEM_interno = 0;
    public static int qtdProd = 0;
    //
    String caminho = "";
    public static int codItem;
    public static String idItemPagto;
    public static int pCODIGO_colaborador = 0;
    public static String pDESCRICAO_pavilhao = "";
    //FINALIZAÇÃO DO KIT
    String pRespostaKit = "Sim";

    /**
     * Creates new form TelaCancelamentoPagamentoKits
     */
    public static TelaCancelamentoKit pCANCELAR_kit;
    public static TelaPesquisaInternoKitPagoCancelado pPESQUISAR_internos;

    public TelaCancelamentoPagamentoKits() {
        initComponents();
        corCampos();
        formatarCampos();
    }

    public void mostrarCancelar() {
        pCANCELAR_kit = new TelaCancelamentoKit(this, true);
        pCANCELAR_kit.setVisible(true);
    }

    public void mostrarInternoPesquisado() {
        pPESQUISAR_internos = new TelaPesquisaInternoKitPagoCancelado(this, true);
        pPESQUISAR_internos.setVisible(true);
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
        jPanel11 = new javax.swing.JPanel();
        jCodigoReq = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        jBtPesqCodigoReq = new javax.swing.JButton();
        jLabel72 = new javax.swing.JLabel();
        jDataPesqInicial = new com.toedter.calendar.JDateChooser();
        jLabel73 = new javax.swing.JLabel();
        jDataPesFinal = new com.toedter.calendar.JDateChooser();
        jBtPesqDatas = new javax.swing.JButton();
        jCheckBoxTodosReq = new javax.swing.JCheckBox();
        jBtPesqInterno = new javax.swing.JButton();
        jNomeInterno = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTabelaCancelamento = new javax.swing.JTable();
        jPanel31 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jIdRegistro = new javax.swing.JTextField();
        jStatusRegistro = new javax.swing.JTextField();
        jDataRegistro = new com.toedter.calendar.JDateChooser();
        jComboBoxTiposKits = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jMotivoCancelamento = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jIdRegistroComp = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jDataComposicaoKit = new com.toedter.calendar.JDateChooser();
        jBtPesquisarKit = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jComboBoxPavilhao = new javax.swing.JComboBox<>();
        jIdKit = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jResponsavel = new javax.swing.JTextField();
        jComboBoxSituacaoInterno = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jBtNovo = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jBtAuditoria = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jIdProdutoKit = new javax.swing.JTextField();
        jDescricaoProdutoKit = new javax.swing.JTextField();
        jQuantidadeProdutoKit = new javax.swing.JTextField();
        jUnidadeProdutoKit = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jIdInternoKit = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jNomeInternoKit = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabelaProdutosKitInterno = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jBtNovoInterno = new javax.swing.JButton();
        jBtAlterarInterno = new javax.swing.JButton();
        jBtExcluirInterno = new javax.swing.JButton();
        jBtSalvarInterno = new javax.swing.JButton();
        jBtCancelarInterno = new javax.swing.JButton();
        jBtAuditoriaInterno = new javax.swing.JButton();
        jPanel43 = new javax.swing.JPanel();
        jtotaProdutosSelecionados = new javax.swing.JLabel();
        jPanel44 = new javax.swing.JPanel();
        jPanel42 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTabelaInternos = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jFotoInternoKit = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jBtSelecionaProdutos = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jBtFinalizar = new javax.swing.JButton();
        jBtPesquisarInterno = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jDataEntrega = new com.toedter.calendar.JDateChooser();
        jLabel17 = new javax.swing.JLabel();
        jHorarioPagto = new javax.swing.JFormattedTextField();
        jPanel9 = new javax.swing.JPanel();
        jBtSair = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Cancelar Pagamento Kit Higiene :::...");

        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jCodigoReq.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodigoReq.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel70.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel70.setText("Código:");

        jBtPesqCodigoReq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqCodigoReq.setContentAreaFilled(false);
        jBtPesqCodigoReq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqCodigoReqActionPerformed(evt);
            }
        });

        jLabel72.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel72.setText("Data Inicial:");

        jDataPesqInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel73.setText("Data Final:");

        jDataPesFinal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqDatas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqDatas.setContentAreaFilled(false);
        jBtPesqDatas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqDatasActionPerformed(evt);
            }
        });

        jCheckBoxTodosReq.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxTodosReq.setText("Todos");
        jCheckBoxTodosReq.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxTodosReqItemStateChanged(evt);
            }
        });

        jBtPesqInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqInterno.setContentAreaFilled(false);
        jBtPesqInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqInternoActionPerformed(evt);
            }
        });

        jNomeInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel74.setText("Interno:");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel74)
                            .addComponent(jLabel72)
                            .addComponent(jLabel70))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel73)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDataPesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqDatas, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jCodigoReq, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqCodigoReq, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckBoxTodosReq))))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel70)
                    .addComponent(jCodigoReq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqCodigoReq)
                    .addComponent(jCheckBoxTodosReq))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel72)
                    .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel73)
                    .addComponent(jDataPesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqDatas))
                .addGap(3, 3, 3)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel74)
                    .addComponent(jBtPesqInterno))
                .addGap(5, 5, 5))
        );

        jTabelaCancelamento.setAutoCreateRowSorter(true);
        jTabelaCancelamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaCancelamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Dt. Registro", "Status Registro", "Tipo de Kit", "Pavilhão"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabelaCancelamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaCancelamentoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTabelaCancelamento);
        if (jTabelaCancelamento.getColumnModel().getColumnCount() > 0) {
            jTabelaCancelamento.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaCancelamento.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaCancelamento.getColumnModel().getColumn(1).setMinWidth(80);
            jTabelaCancelamento.getColumnModel().getColumn(1).setMaxWidth(80);
            jTabelaCancelamento.getColumnModel().getColumn(2).setMinWidth(90);
            jTabelaCancelamento.getColumnModel().getColumn(2).setMaxWidth(90);
            jTabelaCancelamento.getColumnModel().getColumn(3).setMinWidth(250);
            jTabelaCancelamento.getColumnModel().getColumn(3).setMaxWidth(250);
            jTabelaCancelamento.getColumnModel().getColumn(4).setMinWidth(250);
            jTabelaCancelamento.getColumnModel().getColumn(4).setMaxWidth(250);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
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
                .addGap(7, 7, 7)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        jTabbedPane1.addTab("Listagem", jPanel1);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Status");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Data");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Tipo de Kit Higiene");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Motivo do Cancelamento");

        jIdRegistro.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdRegistro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdRegistro.setEnabled(false);

        jStatusRegistro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jStatusRegistro.setForeground(new java.awt.Color(204, 0, 0));
        jStatusRegistro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jStatusRegistro.setDisabledTextColor(new java.awt.Color(204, 0, 0));
        jStatusRegistro.setEnabled(false);

        jDataRegistro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataRegistro.setEnabled(false);

        jComboBoxTiposKits.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTiposKits.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "Kit Incial", "Kit Decendial", "Kit Quinzenal", "Kit Mensal", "Kit Semestral", "Kit Anual" }));
        jComboBoxTiposKits.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTiposKits.setEnabled(false);

        jMotivoCancelamento.setColumns(20);
        jMotivoCancelamento.setRows(5);
        jMotivoCancelamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMotivoCancelamento.setEnabled(false);
        jScrollPane1.setViewportView(jMotivoCancelamento);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Registro");

        jIdRegistroComp.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdRegistroComp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdRegistroComp.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Data");

        jDataComposicaoKit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataComposicaoKit.setEnabled(false);

        jBtPesquisarKit.setForeground(new java.awt.Color(0, 0, 204));
        jBtPesquisarKit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesquisarKit.setText("Pesquisar");
        jBtPesquisarKit.setEnabled(false);
        jBtPesquisarKit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisarKitActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Pavilhão");

        jComboBoxPavilhao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxPavilhao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione..." }));
        jComboBoxPavilhao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxPavilhao.setEnabled(false);

        jIdKit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jIdKit.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdKit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdKit.setDisabledTextColor(new java.awt.Color(204, 0, 0));
        jIdKit.setEnabled(false);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 0, 0));
        jLabel18.setText("ID Kit");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Responsável");

        jResponsavel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jResponsavel.setEnabled(false);

        jComboBoxSituacaoInterno.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxSituacaoInterno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "Dentro da Unidade", "Fora da Unidade" }));
        jComboBoxSituacaoInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxSituacaoInterno.setEnabled(false);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Situação Interno");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jComboBoxTiposKits, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxSituacaoInterno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel14)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jIdRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(3, 3, 3)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jStatusRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDataRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)))
                            .addComponent(jLabel5)
                            .addComponent(jLabel15)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(jIdRegistroComp, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel18)
                                            .addComponent(jIdKit, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(jLabel13))
                                    .addComponent(jDataComposicaoKit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesquisarKit)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addComponent(jComboBoxPavilhao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jResponsavel))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jIdKit, jIdRegistroComp});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jDataRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jStatusRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxPavilhao, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxTiposKits, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxSituacaoInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel18)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIdRegistroComp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdKit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataComposicaoKit, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesquisarKit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jIdKit, jIdRegistroComp});

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

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

        jBtExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216104515_16.png"))); // NOI18N
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

        jBtAuditoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoria.setContentAreaFilled(false);
        jBtAuditoria.setEnabled(false);
        jBtAuditoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jBtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jBtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jBtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jBtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterar, jBtCancelar, jBtExcluir, jBtNovo, jBtSalvar});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtAlterar)
                    .addComponent(jBtExcluir)
                    .addComponent(jBtSalvar)
                    .addComponent(jBtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtAuditoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterar, jBtCancelar, jBtExcluir, jBtNovo, jBtSalvar});

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 371, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manutenção", jPanel2);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Código");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Un");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Descrição Produto");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Qtd.");

        jIdProdutoKit.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdProdutoKit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdProdutoKit.setEnabled(false);

        jDescricaoProdutoKit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDescricaoProdutoKit.setEnabled(false);

        jQuantidadeProdutoKit.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jQuantidadeProdutoKit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQuantidadeProdutoKit.setEnabled(false);

        jUnidadeProdutoKit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jUnidadeProdutoKit.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jIdProdutoKit, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jDescricaoProdutoKit, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jUnidadeProdutoKit, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(13, 13, 13))
                    .addComponent(jQuantidadeProdutoKit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jIdProdutoKit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDescricaoProdutoKit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jQuantidadeProdutoKit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jUnidadeProdutoKit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jIdInternoKit.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdInternoKit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdInternoKit.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Código");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Nome do Interno");

        jNomeInternoKit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoKit.setEnabled(false);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jIdInternoKit, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jNomeInternoKit, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(7, 7, 7)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jIdInternoKit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNomeInternoKit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jTabelaProdutosKitInterno.setAutoCreateRowSorter(true);
        jTabelaProdutosKitInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaProdutosKitInterno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Registro", "Código", "Descrição", "Un", "Qtd."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabelaProdutosKitInterno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaProdutosKitInternoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTabelaProdutosKitInterno);
        if (jTabelaProdutosKitInterno.getColumnModel().getColumnCount() > 0) {
            jTabelaProdutosKitInterno.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaProdutosKitInterno.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaProdutosKitInterno.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaProdutosKitInterno.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaProdutosKitInterno.getColumnModel().getColumn(2).setMinWidth(250);
            jTabelaProdutosKitInterno.getColumnModel().getColumn(2).setMaxWidth(250);
            jTabelaProdutosKitInterno.getColumnModel().getColumn(3).setMinWidth(60);
            jTabelaProdutosKitInterno.getColumnModel().getColumn(3).setMaxWidth(60);
            jTabelaProdutosKitInterno.getColumnModel().getColumn(4).setMinWidth(60);
            jTabelaProdutosKitInterno.getColumnModel().getColumn(4).setMaxWidth(60);
        }

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

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

        jBtExcluirInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216104515_16.png"))); // NOI18N
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

        jBtAuditoriaInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaInterno.setToolTipText("Auditoria");
        jBtAuditoriaInterno.setContentAreaFilled(false);
        jBtAuditoriaInterno.setEnabled(false);
        jBtAuditoriaInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaInternoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtNovoInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jBtAlterarInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jBtExcluirInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jBtSalvarInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jBtCancelarInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterarInterno, jBtCancelarInterno, jBtExcluirInterno, jBtNovoInterno, jBtSalvarInterno});

        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtNovoInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtAlterarInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtExcluirInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtSalvarInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtCancelarInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtAuditoriaInterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4))
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterarInterno, jBtCancelarInterno, jBtExcluirInterno, jBtNovoInterno, jBtSalvarInterno});

        jPanel43.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jtotaProdutosSelecionados.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotaProdutosSelecionados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotaProdutosSelecionados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
        );

        jPanel44.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

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

        jTabelaInternos.setAutoCreateRowSorter(true);
        jTabelaInternos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaInternos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Código", "Nome do Interno"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabelaInternos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaInternosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTabelaInternos);
        if (jTabelaInternos.getColumnModel().getColumnCount() > 0) {
            jTabelaInternos.getColumnModel().getColumn(0).setMinWidth(60);
            jTabelaInternos.getColumnModel().getColumn(0).setMaxWidth(60);
            jTabelaInternos.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaInternos.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaInternos.getColumnModel().getColumn(2).setMinWidth(350);
            jTabelaInternos.getColumnModel().getColumn(2).setMaxWidth(350);
        }

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(jPanel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jTabbedPane1.addTab("Internos/Produtos", jPanel5);

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Foto Interno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(204, 0, 0))); // NOI18N

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoKit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoKit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtSelecionaProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Almoxarifado18.png"))); // NOI18N
        jBtSelecionaProdutos.setText("Cancelamento");
        jBtSelecionaProdutos.setToolTipText("Pesquisar Produtos do Kit de higiene");
        jBtSelecionaProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSelecionaProdutosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtSelecionaProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jBtSelecionaProdutos)
                .addGap(4, 4, 4))
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtFinalizar.setForeground(new java.awt.Color(51, 153, 0));
        jBtFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/accept.png"))); // NOI18N
        jBtFinalizar.setText("Finalizar");
        jBtFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFinalizarActionPerformed(evt);
            }
        });

        jBtPesquisarInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesquisarInterno.setText("Pesquisar");
        jBtPesquisarInterno.setToolTipText("Pesquisar Interno");
        jBtPesquisarInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisarInternoActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/gtklp-icone-3770-16.png"))); // NOI18N
        jButton1.setText("Impressão");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Data Operação");

        jDataEntrega.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataEntrega.setEnabled(false);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Horário");

        jHorarioPagto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHorarioPagto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jHorarioPagto.setEnabled(false);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtFinalizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtPesquisarInterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jDataEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jHorarioPagto, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jBtPesquisarInterno)
                .addGap(2, 2, 2)
                .addComponent(jBtFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jButton1)
                .addGap(3, 3, 3)
                .addComponent(jLabel16)
                .addGap(3, 3, 3)
                .addComponent(jDataEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jHorarioPagto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSair.setText("Sair");
        jBtSair.setToolTipText("Sair da tela");
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtSair, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jBtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel12, jPanel13, jPanel9});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setBounds(330, 60, 617, 481);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesqCodigoReqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqCodigoReqActionPerformed
        // TODO add your handling code here:
        if (jCodigoReq.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um código para pesquisa.");
        } else {
            // APAGAR DADOS DA TABELA
            while (jTabelaCancelamento.getModel().getRowCount() > 0) {
                ((DefaultTableModel) jTabelaCancelamento.getModel()).removeRow(0);
            }
            mostrarRegistroCodigo();
            if (pTOTAL_registros == 0) {
                JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem exibidos...");
            }
        }
    }//GEN-LAST:event_jBtPesqCodigoReqActionPerformed

    private void jBtPesqDatasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqDatasActionPerformed
        // TODO add your handling code here:
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
                        SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
                        dataInicial = formatoAmerica.format(jDataPesqInicial.getDate().getTime());
                        dataFinal = formatoAmerica.format(jDataPesFinal.getDate().getTime());
                        // APAGAR DADOS DA TABELA
                        while (jTabelaCancelamento.getModel().getRowCount() > 0) {
                            ((DefaultTableModel) jTabelaCancelamento.getModel()).removeRow(0);
                        }
                        mostraPesquisaData();
                        if (pTOTAL_registros == 0) {
                            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem exibidos...");
                        }
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
                        // APAGAR DADOS DA TABELA
                        while (jTabelaCancelamento.getModel().getRowCount() > 0) {
                            ((DefaultTableModel) jTabelaCancelamento.getModel()).removeRow(0);
                        }
                        mostraPesquisaData();
                        if (pTOTAL_registros == 0) {
                            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem exibidos...");
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_jBtPesqDatasActionPerformed

    private void jCheckBoxTodosReqItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxTodosReqItemStateChanged
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            // APAGAR DADOS DA TABELA
            while (jTabelaCancelamento.getModel().getRowCount() > 0) {
                ((DefaultTableModel) jTabelaCancelamento.getModel()).removeRow(0);
            }
            mostrarTodos();
            if (pTOTAL_registros == 0) {
                JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem exibidos...");
            }
        } else {
            // APAGAR DADOS DA TABELA
            while (jTabelaCancelamento.getModel().getRowCount() > 0) {
                ((DefaultTableModel) jTabelaCancelamento.getModel()).removeRow(0);
            }
            jtotalRegistros.setText("");
        }
    }//GEN-LAST:event_jCheckBoxTodosReqItemStateChanged

    private void jBtPesqInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqInternoActionPerformed
        // TODO add your handling code here:
        if (jNomeInterno.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um nome para pesquisa.");
        } else {

        }
    }//GEN-LAST:event_jBtPesqInternoActionPerformed

    private void jTabelaCancelamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaCancelamentoMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String IdLanc = "" + jTabelaCancelamento.getValueAt(jTabelaCancelamento.getSelectedRow(), 0);
            jCodigoReq.setText(IdLanc);
            pDESCRICAO_pavilhao = "" + jTabelaCancelamento.getValueAt(jTabelaCancelamento.getSelectedRow(), 4);
            bloquearBotoes(!true);
            bloquearCampos(!true);
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            //
            jComboBoxPavilhao.removeAllItems();
            //
            control.MOSTRAR_interno(objCancelaKit);
            jIdRegistro.setText(String.valueOf(objCancelaKit.getIdRegistro()));
            jStatusRegistro.setText(objCancelaKit.getStatusRegistro());
            jDataRegistro.setDate(objCancelaKit.getDataRegistro());
            jResponsavel.setText(objCancelaKit.getNomeFunc());
            jComboBoxPavilhao.addItem(objCancelaKit.getDescricaoPav().toString());
            jComboBoxTiposKits.setSelectedItem(objCancelaKit.getTipoKit());
            jComboBoxSituacaoInterno.setSelectedItem(objCancelaKit.getSituacaoInterno());
            jIdRegistroComp.setText(String.valueOf(objCancelaKit.getIdRegistroKit()));
            jIdKit.setText(String.valueOf(objCancelaKit.getIdKit()));
            jDataComposicaoKit.setDate(objCancelaKit.getDataRegistroKit());
            jMotivoCancelamento.setText(objCancelaKit.getMotivoCancelamento());
            //
            // APAGAR DADOS DA TABELA
            while (jTabelaInternos.getModel().getRowCount() > 0) {
                ((DefaultTableModel) jTabelaInternos.getModel()).removeRow(0);
            }
            pPREENCHER_TABELA_Internos();
        }
    }//GEN-LAST:event_jTabelaCancelamentoMouseClicked

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        objCampos.setNomeUsuario(nameUser);
        objCampos.setNomeTelaAcesso(telaCancelamentoPagamentoManu);
        pPESQUISAR_acessos.pesquisarUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarGrupoUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarTelasAcesso(objCampos);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || objCampos.getNomeGrupo().equals("ADMINISTRADORES") || objCampos.getCodigoUsuario() == objCampos.getCodigoUsuarioAcesso() && objCampos.getNomeTelaAcesso().equals(telaCancelamentoPagamentoManu) && objCampos.getCodigoIncluir() == 1) {
            acao = 1;
            limparTodosCampos();
            bloquearBotoes(!true);
            bloquearCampos(!true);
            Novo();
            PREENCHER_COMBO_pavilhao();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        // TODO add your handling code here:
        objCampos.setNomeUsuario(nameUser);
        objCampos.setNomeTelaAcesso(telaCancelamentoPagamentoManu);
        pPESQUISAR_acessos.pesquisarUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarGrupoUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarTelasAcesso(objCampos);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || objCampos.getNomeGrupo().equals("ADMINISTRADORES") || objCampos.getCodigoUsuario() == objCampos.getCodigoUsuarioAcesso() && objCampos.getNomeTelaAcesso().equals(telaCancelamentoPagamentoManu) && objCampos.getCodigoAlterar() == 1) {
            objCancelaKit.setStatusRegistro(jStatusRegistro.getText());
            if (jStatusRegistro.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa saida de internos não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 2;
                bloquearBotoes(!true);
                bloquearCampos(!true);
                Alterar();
                PREENCHER_COMBO_pavilhao();
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
        objCampos.setNomeUsuario(nameUser);
        objCampos.setNomeTelaAcesso(telaCancelamentoPagamentoManu);
        pPESQUISAR_acessos.pesquisarUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarGrupoUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarTelasAcesso(objCampos);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || objCampos.getNomeGrupo().equals("ADMINISTRADORES") || objCampos.getCodigoUsuario() == objCampos.getCodigoUsuarioAcesso() && objCampos.getNomeTelaAcesso().equals(telaCancelamentoPagamentoManu) && objCampos.getCodigoExcluir() == 1) {
            objCancelaKit.setStatusRegistro(jStatusRegistro.getText());
            if (jStatusRegistro.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa saida de internos não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    bloquearBotoes(!true);
                    bloquearCampos(!true);
                    limparTodosCampos();
                    statusMov = "Excluiu";
                    horaMov = jHoraSistema.getText();
                    objCancelaKit.setIdRegistro(Integer.valueOf(jIdRegistro.getText()));
                    control.excluirRegistroCancelamento(objCancelaKit);
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação         
                    bloquearBotoes(!true);
                    bloquearCampos(!true);
                    Excluir();
                    JOptionPane.showMessageDialog(rootPane, "Registro excluído com sucesso.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        objCampos.setNomeUsuario(nameUser);
        objCampos.setNomeTelaAcesso(telaCancelamentoPagamentoManu);
        pPESQUISAR_acessos.pesquisarUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarGrupoUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarTelasAcesso(objCampos);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || objCampos.getNomeGrupo().equals("ADMINISTRADORES") || objCampos.getCodigoUsuario() == objCampos.getCodigoUsuarioAcesso() && objCampos.getNomeTelaAcesso().equals(telaCancelamentoPagamentoManu) && objCampos.getCodigoGravar() == 1) {
            if (jComboBoxPavilhao.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o pavilhão.");
            } else if (jComboBoxTiposKits.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o tipo de kit de higiene.");
            } else if (jIdRegistroComp.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário informar o código do registro da composição do kit.");
            } else if (jMotivoCancelamento.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o motivo do cancelamento do kit.");
            } else if (jComboBoxSituacaoInterno.getSelectedItem().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe a situação do interno na unidade.");
            } else {
                objCancelaKit.setStatusRegistro(jStatusRegistro.getText());
                objCancelaKit.setDataRegistro(jDataRegistro.getDate());
                objCancelaKit.setIdFunc(pCODIGO_colaborador);
                objCancelaKit.setDescricaoPav((String) jComboBoxPavilhao.getSelectedItem());
                objCancelaKit.setTipoKit((String) jComboBoxTiposKits.getSelectedItem());
                objCancelaKit.setSituacaoInterno((String) jComboBoxSituacaoInterno.getSelectedItem());
                objCancelaKit.setIdRegistroKit(Integer.valueOf(jIdRegistroComp.getText()));
                objCancelaKit.setIdKit(Integer.valueOf(jIdKit.getText()));
                objCancelaKit.setDataRegistroKit(jDataComposicaoKit.getDate());
                objCancelaKit.setMotivoCancelamento(jMotivoCancelamento.getText());
                if (acao == 1) {
                    objCancelaKit.setUsuarioInsert(nameUser);
                    objCancelaKit.setDataInsert(dataModFinal);
                    objCancelaKit.setHorarioInsert(horaMov);
                    //
                    control.incluirRegistroCancelamento(objCancelaKit);
                    buscarCodigo();
                    //
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    bloquearCampos(!true);
                    bloquearBotoes(!true);
                    Salvar();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
                if (acao == 2) {
                    objCancelaKit.setUsuarioUp(nameUser);
                    objCancelaKit.setDataUp(dataModFinal);
                    objCancelaKit.setHorarioUp(horaMov);
                    objCancelaKit.setIdRegistro(Integer.valueOf(jIdRegistro.getText()));
                    control.altgerarRegistroCancelamento(objCancelaKit);
                    //
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    bloquearCampos(!true);
                    bloquearBotoes(!true);
                    Salvar();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtSalvarActionPerformed

    private void jBtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarActionPerformed
        // TODO add your handling code here:
        bloquearCampos(!true);
        Cancelar();
    }//GEN-LAST:event_jBtCancelarActionPerformed

    private void jBtFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFinalizarActionPerformed
        // TODO add your handling code here:
        Integer rows = jTabelaInternos.getModel().getRowCount();
        if (rows == 0) {
            JOptionPane.showMessageDialog(rootPane, "Não é possível finalizar esse registro, pois não existe(m) produto(s) lançado(s).");
        } else {
            control.PESQUISAR_status(objCancelaKit);
            if (objCancelaKit.getStatusRegistro().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Lançamento já foi finalizado");
            } else {
                Finalizar();
            }
        }
    }//GEN-LAST:event_jBtFinalizarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtAuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaCancelamentoPk objAudi = new TelaAuditoriaCancelamentoPk();
        TelaModuloAlmoxarifado.jPainelAlmoxarifado.add(objAudi);
        objAudi.show();
    }//GEN-LAST:event_jBtAuditoriaActionPerformed

    private void jBtNovoInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoInternoActionPerformed
        // TODO add your handling code here:
        objCampos.setNomeUsuario(nameUser);
        objCampos.setNomeTelaAcesso(telaCancelamentoPagamentoInt);
        pPESQUISAR_acessos.pesquisarUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarGrupoUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarTelasAcesso(objCampos);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || objCampos.getNomeGrupo().equals("ADMINISTRADORES") || objCampos.getCodigoUsuario() == objCampos.getCodigoUsuarioAcesso() && objCampos.getNomeTelaAcesso().equals(telaCancelamentoPagamentoInt) && objCampos.getCodigoIncluir() == 1) {
            acao = 3;
            limparCamposProdutosInternos();
            bloquearBotoes(!true);
            bloquearCampos(!true);
            NovoInterno();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtNovoInternoActionPerformed

    private void jBtAlterarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarInternoActionPerformed
        // TODO add your handling code here:
        objCampos.setNomeUsuario(nameUser);
        objCampos.setNomeTelaAcesso(telaCancelamentoPagamentoInt);
        pPESQUISAR_acessos.pesquisarUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarGrupoUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarTelasAcesso(objCampos);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || objCampos.getNomeGrupo().equals("ADMINISTRADORES") || objCampos.getCodigoUsuario() == objCampos.getCodigoUsuarioAcesso() && objCampos.getNomeTelaAcesso().equals(telaCancelamentoPagamentoInt) && objCampos.getCodigoAlterar() == 1) {
            acao = 4;
            bloquearBotoes(!true);
            bloquearCampos(!true);
            NovoInterno();
            statusMov = "Alterou";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtAlterarInternoActionPerformed

    private void jBtExcluirInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirInternoActionPerformed
        // TODO add your handling code here:
        objCampos.setNomeUsuario(nameUser);
        objCampos.setNomeTelaAcesso(telaCancelamentoPagamentoInt);
        pPESQUISAR_acessos.pesquisarUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarGrupoUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarTelasAcesso(objCampos);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || objCampos.getNomeGrupo().equals("ADMINISTRADORES") || objCampos.getCodigoUsuario() == objCampos.getCodigoUsuarioAcesso() && objCampos.getNomeTelaAcesso().equals(telaCancelamentoPagamentoInt) && objCampos.getCodigoExcluir() == 1) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                bloquearBotoes(!true);
                bloquearCampos(!true);
                objCancelaKit.setIdItemSA(pITEM_interno);
                control.excluirInternoProdutoCancelamento(objCancelaKit);
                ExcluirInterno();
                //MOSTRAR OS DADOS DA TABELA
                mostrarItens();
                JOptionPane.showMessageDialog(rootPane, "Registro excluído com sucesso.");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtExcluirInternoActionPerformed

    private void jBtSalvarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarInternoActionPerformed
        // TODO add your handling code here:
        objCampos.setNomeUsuario(nameUser);
        objCampos.setNomeTelaAcesso(telaCancelamentoPagamentoInt);
        pPESQUISAR_acessos.pesquisarUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarGrupoUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarTelasAcesso(objCampos);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || objCampos.getNomeGrupo().equals("ADMINISTRADORES") || objCampos.getCodigoUsuario() == objCampos.getCodigoUsuarioAcesso() && objCampos.getNomeTelaAcesso().equals(telaCancelamentoPagamentoInt) && objCampos.getCodigoGravar() == 1) {

        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtSalvarInternoActionPerformed

    private void jBtCancelarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarInternoActionPerformed
        // TODO add your handling code here:
        CancelarInterno();
    }//GEN-LAST:event_jBtCancelarInternoActionPerformed

    private void jBtAuditoriaInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaInternoActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaInternosKitCancelado objAudiItem = new TelaAuditoriaInternosKitCancelado();
        TelaModuloAlmoxarifado.jPainelAlmoxarifado.add(objAudiItem);
        objAudiItem.show();
    }//GEN-LAST:event_jBtAuditoriaInternoActionPerformed

    private void jBtPesquisarKitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisarKitActionPerformed
        // TODO add your handling code here:
        TelaPesquisarComposicaoKit_CA objPesquisa_COMP = new TelaPesquisarComposicaoKit_CA();
        TelaModuloAlmoxarifado.jPainelAlmoxarifado.add(objPesquisa_COMP);
        objPesquisa_COMP.show();
    }//GEN-LAST:event_jBtPesquisarKitActionPerformed

    private void jBtPesquisarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisarInternoActionPerformed
        // TODO add your handling code here:
        mostrarInternoPesquisado();
    }//GEN-LAST:event_jBtPesquisarInternoActionPerformed

    private void jTabelaProdutosKitInternoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaProdutosKitInternoMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String pQUANTIDADE = "" + jTabelaProdutosKitInterno.getValueAt(jTabelaProdutosKitInterno.getSelectedRow(), 4);
            jQuantidadeProdutoKit.setText(pQUANTIDADE);
            String pUNIDADE = "" + jTabelaProdutosKitInterno.getValueAt(jTabelaProdutosKitInterno.getSelectedRow(), 3);
            jUnidadeProdutoKit.setText(pUNIDADE);
            String nomeProduto = "" + jTabelaProdutosKitInterno.getValueAt(jTabelaProdutosKitInterno.getSelectedRow(), 2);
            jDescricaoProdutoKit.setText(nomeProduto);
            String idProduto = "" + jTabelaProdutosKitInterno.getValueAt(jTabelaProdutosKitInterno.getSelectedRow(), 1);
            jIdProdutoKit.setText(idProduto);
        }
    }//GEN-LAST:event_jTabelaProdutosKitInternoMouseClicked

    private void jBtSelecionaProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSelecionaProdutosActionPerformed
        // TODO add your handling code here:
        objCancelaKit.setStatusRegistro(jStatusRegistro.getText());
        if (jStatusRegistro.getText().equals("FINALIZADO")) {
            JOptionPane.showMessageDialog(rootPane, "Essa saida de internos não poderá ser alterado, o mesmo encontra-se FINALIZADO");
        } else {
            if (jIdRegistro.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário informar o registro principal.");
                jIdRegistro.requestFocus();
                jIdRegistro.setBackground(Color.red);
            } else if (jStatusRegistro.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Registro já foi finalizado, não é permitido adicionar lançamentos.");
            } else {
                mostrarCancelar();
            }
        }
    }//GEN-LAST:event_jBtSelecionaProdutosActionPerformed

    private void jTabelaInternosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaInternosMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            idItemPagto = "" + jTabelaInternos.getValueAt(jTabelaInternos.getSelectedRow(), 0);
            pINTERNOS = "" + jTabelaInternos.getValueAt(jTabelaInternos.getSelectedRow(), 1);
            //
            bloquearBotoes(!true);
            bloquearCampos(!true);
            jBtNovoInterno.setEnabled(true);
            jBtAuditoriaInterno.setEnabled(true);
            //
            listaItens.MOSTRAR_KIT_INTERNO_cancelado(objCancelaKit);
            jIdInternoKit.setText(String.valueOf(objCancelaKit.getIdInternoKit()));
            jNomeInternoKit.setText(objCancelaKit.getNomeInternoKit());
            // APAGAR DADOS DA TABELA
            while (jTabelaProdutosKitInterno.getModel().getRowCount() > 0) {
                ((DefaultTableModel) jTabelaProdutosKitInterno.getModel()).removeRow(0);
            }
            //MOSTRAR PRODUTOS CANCELADOS
            mostrarItens();
        }
    }//GEN-LAST:event_jTabelaInternosMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        // VERIFICAR SE A TABELA TEM PRODUTOS, SE ESTIVER VAZIA NÃO IMPRIMI
        Integer rows = jTabelaInternos.getModel().getRowCount();
        if (rows == 0) {
            JOptionPane.showMessageDialog(rootPane, "Não é possível imprimir esse registro, pois não existe(m) produto(s) lançado(s).");
        } else if (jIdInternoKit.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Selecione o interno para imprimir o relatório.");
        } else {
            final ViewAguarde carregando = new ViewAguarde(); //Teste tela aguarde
            carregando.setVisible(true);//Teste tela aguarde
            Thread t = new Thread() { //Teste tela aguarde
                public void run() { //Teste
                    try {
                        conecta.abrirConexao();
                        String path = "reports/Almoxarifado/RelatorioCancelamentoKitInterno.jasper";
                        conecta.executaSQL("SELECT * FROM CANCELAR_PAGAMENTO_KIT_HIGIENE "
                                + "INNER JOIN PAVILHAO "
                                + "ON CANCELAR_PAGAMENTO_KIT_HIGIENE.IdPav=PAVILHAO.IdPav "
                                + "INNER JOIN ITENS_CANCELAR_PAGAMENTO_KIT_HIGIENE_INTERNOS "
                                + "ON CANCELAR_PAGAMENTO_KIT_HIGIENE.IdRegistro=ITENS_CANCELAR_PAGAMENTO_KIT_HIGIENE_INTERNOS.IdRegistro "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON ITENS_CANCELAR_PAGAMENTO_KIT_HIGIENE_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                + "WHERE CANCELAR_PAGAMENTO_KIT_HIGIENE.IdRegistro='" + jIdRegistro.getText() + "' "
                                + "AND ITENS_CANCELAR_PAGAMENTO_KIT_HIGIENE_INTERNOS.IdInternoCrc='" + jIdInternoKit.getText() + "'");
                        HashMap parametros = new HashMap();
                        parametros.put("pUnidade", descricaoUnidade);
                        parametros.put("pCodigo", jIdRegistro.getText());
                        parametros.put("pCodigoInternoCrc", jIdInternoKit.getText());
                        parametros.put("pUsuario", nameUser);
                        // Sub Relatório
                        try {
                            parametros.put("REPORT_CONNECTION", conecta.stmt.getConnection());
                        } catch (SQLException ex) {
                        }
                        JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
                        JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
                        JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
                        jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
                        jv.setTitle("Relatório de Cancelamento de Kit de Interno.");
                        jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
                        jv.toFront(); // Traz o relatorio para frente da aplicação    
                        carregando.dispose(); //Teste tela aguarde
                        conecta.desconecta();
                    } catch (JRException e) {
                        JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório...\n\nERROR :" + e);
                    }
                }
            }; //Teste tela aguarde
            t.start(); //Teste tela aguarde
        }
    }//GEN-LAST:event_jButton1ActionPerformed


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
    private javax.swing.JButton jBtPesqCodigoReq;
    private javax.swing.JButton jBtPesqDatas;
    private javax.swing.JButton jBtPesqInterno;
    private javax.swing.JButton jBtPesquisarInterno;
    private javax.swing.JButton jBtPesquisarKit;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JButton jBtSalvarInterno;
    private javax.swing.JButton jBtSelecionaProdutos;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBoxTodosReq;
    public static javax.swing.JTextField jCodigoReq;
    public static javax.swing.JComboBox<String> jComboBoxPavilhao;
    public static javax.swing.JComboBox<String> jComboBoxSituacaoInterno;
    public static javax.swing.JComboBox<String> jComboBoxTiposKits;
    public static com.toedter.calendar.JDateChooser jDataComposicaoKit;
    public static com.toedter.calendar.JDateChooser jDataEntrega;
    public static com.toedter.calendar.JDateChooser jDataPesFinal;
    public static com.toedter.calendar.JDateChooser jDataPesqInicial;
    private com.toedter.calendar.JDateChooser jDataRegistro;
    private javax.swing.JTextField jDescricaoProdutoKit;
    public static javax.swing.JLabel jFotoInternoKit;
    public static javax.swing.JFormattedTextField jHorarioPagto;
    public static javax.swing.JTextField jIdInternoKit;
    public static javax.swing.JTextField jIdKit;
    private javax.swing.JTextField jIdProdutoKit;
    public static javax.swing.JTextField jIdRegistro;
    public static javax.swing.JTextField jIdRegistroComp;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextArea jMotivoCancelamento;
    public static javax.swing.JTextField jNomeInterno;
    public static javax.swing.JTextField jNomeInternoKit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jQuantidadeProdutoKit;
    public static javax.swing.JTextField jResponsavel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jStatusRegistro;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTabelaCancelamento;
    public static javax.swing.JTable jTabelaInternos;
    public static javax.swing.JTable jTabelaProdutosKitInterno;
    private javax.swing.JTextField jUnidadeProdutoKit;
    public static javax.swing.JLabel jtotaProdutosSelecionados;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void corCampos() {
        jIdRegistro.setBackground(Color.white);
        jStatusRegistro.setBackground(Color.white);
        jDataRegistro.setBackground(Color.white);
        jResponsavel.setBackground(Color.white);
        jComboBoxPavilhao.setBackground(Color.white);
        jComboBoxTiposKits.setBackground(Color.white);
        jComboBoxSituacaoInterno.setBackground(Color.white);
        jIdRegistroComp.setBackground(Color.white);
        jIdKit.setBackground(Color.white);
        jDataComposicaoKit.setBackground(Color.white);
        jMotivoCancelamento.setBackground(Color.white);
        //INTERNO DO KIT
        jIdInternoKit.setBackground(Color.white);
        jNomeInternoKit.setBackground(Color.white);
        // PRODUTOS DO KIT DO INTERNO
        jIdProdutoKit.setBackground(Color.white);
        jDescricaoProdutoKit.setBackground(Color.white);
        jUnidadeProdutoKit.setBackground(Color.white);
        jQuantidadeProdutoKit.setBackground(Color.white);
    }

    public void formatarCampos() {
        jMotivoCancelamento.setLineWrap(true);
        jMotivoCancelamento.setWrapStyleWord(true);
    }

    public void bloquearBotoes(boolean opcao) {
        jBtNovo.setEnabled(opcao);
        jBtAlterar.setEnabled(opcao);
        jBtExcluir.setEnabled(opcao);
        jBtSalvar.setEnabled(opcao);
        jBtCancelar.setEnabled(opcao);
        jBtAuditoria.setEnabled(opcao);
        jBtPesquisarKit.setEnabled(opcao);
        //
        jBtNovoInterno.setEnabled(opcao);
        jBtAlterarInterno.setEnabled(opcao);
        jBtExcluirInterno.setEnabled(opcao);
        jBtSalvarInterno.setEnabled(opcao);
        jBtCancelarInterno.setEnabled(opcao);
        jBtAuditoriaInterno.setEnabled(opcao);
    }

    public void bloquearCampos(boolean opcao) {
        jIdRegistro.setEnabled(opcao);
        jStatusRegistro.setEnabled(opcao);
        jDataRegistro.setEnabled(opcao);
        jComboBoxPavilhao.setEnabled(opcao);
        jComboBoxTiposKits.setEnabled(opcao);
        jComboBoxSituacaoInterno.setEnabled(opcao);
        jIdRegistroComp.setEnabled(opcao);
        jDataComposicaoKit.setEnabled(opcao);
        jMotivoCancelamento.setEnabled(opcao);
        //INTERNO DO KIT
        jIdInternoKit.setEnabled(opcao);
        jNomeInternoKit.setEnabled(opcao);
        // PRODUTOS DO KIT DO INTERNO
        jIdProdutoKit.setEnabled(opcao);
        jDescricaoProdutoKit.setEnabled(opcao);
        jUnidadeProdutoKit.setEnabled(opcao);
        jQuantidadeProdutoKit.setEnabled(opcao);
    }

    public void limparTodosCampos() {
        jComboBoxPavilhao.removeAllItems();
        //
        jIdRegistro.setText("");
        jStatusRegistro.setText("");
        jDataRegistro.setDate(null);
        jResponsavel.setText("");
        jComboBoxPavilhao.addItem("Selecione...");
        jComboBoxTiposKits.setSelectedItem("Selecione...");
        jComboBoxSituacaoInterno.setSelectedItem("Selecione...");
        jIdRegistroComp.setText("");
        jDataComposicaoKit.setDate(null);
        jMotivoCancelamento.setText("");
        //INTERNO DO KIT
        jIdInternoKit.setText("");
        jNomeInternoKit.setText("");
        // PRODUTOS DO KIT DO INTERNO
        jIdProdutoKit.setText("");
        jDescricaoProdutoKit.setText("");
        jUnidadeProdutoKit.setText("");
        jQuantidadeProdutoKit.setText("");
    }

    public void limparCamposProdutosInternos() {
        //INTERNO DO KIT
        jIdInternoKit.setText("");
        jNomeInternoKit.setText("");
        // PRODUTOS DO KIT DO INTERNO
        jIdProdutoKit.setText("");
        jDescricaoProdutoKit.setText("");
        jUnidadeProdutoKit.setText("");
        jQuantidadeProdutoKit.setText("");
    }

    public void Novo() {
        jStatusRegistro.setText("ABERTO");
        jDataRegistro.setCalendar(Calendar.getInstance());
        //
        jComboBoxPavilhao.setEnabled(true);
        jComboBoxSituacaoInterno.setEnabled(true);
        jMotivoCancelamento.setEnabled(true);
        jBtPesquisarKit.setEnabled(true);
        //
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtPesquisarKit.setEnabled(true);
    }

    public void Alterar() {
        jComboBoxPavilhao.setEnabled(true);
        jComboBoxSituacaoInterno.setEnabled(true);
        jMotivoCancelamento.setEnabled(true);
        jBtPesquisarKit.setEnabled(true);
        //
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtPesquisarKit.setEnabled(true);
    }

    public void Excluir() {
        jBtNovo.setEnabled(true);
    }

    public void Salvar() {
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtAuditoria.setEnabled(true);
    }

    public void Cancelar() {
        if (jIdRegistro.getText().equals("")) {
            limparTodosCampos();
            bloquearCampos(!true);
            bloquearBotoes(!true);
            jBtNovo.setEnabled(true);
        } else {
            bloquearCampos(!true);
            bloquearBotoes(!true);
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            //
            jBtNovoInterno.setEnabled(true);
        }
    }

    public void Finalizar() {
        statusMov = "Finalizou";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        String statusLanc = "FINALIZADO";
        JOptionPane.showMessageDialog(rootPane, "Se esse Lançamento for finaliza,\nvocê não poderá mais excluir ou alterar.");
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente finalizar o lançamento selecionado?", "Confirmação",
                JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            objCancelaKit.setStatusRegistro(statusLanc);
            objCancelaKit.setIdRegistro(Integer.parseInt(jIdRegistro.getText()));
            control.finalizarRegistroCancelamento(objCancelaKit);
            jStatusRegistro.setText("FINALIZADO");
            if (tipoServidor == null || tipoServidor.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário definir o parâmtero para o sistema operacional utilizado no servidor, (UBUNTU-LINUX ou WINDOWS SERVER).");
            } else if (tipoServidor.equals("Servidor Linux (Ubuntu)/MS-SQL Server")) {
                SimpleDateFormat formatoAmerica = new SimpleDateFormat("yyyy/MM/dd");
                String dataConvert = formatoAmerica.format(jDataRegistro.getDate().getTime());
                try {
                    java.sql.Date data = new java.sql.Date(formatoAmerica.parse(dataConvert).getTime());
                    objCancelaKit.setDataRegistroKit(data);
                } catch (ParseException ex) {
                    Logger.getLogger(TelaPagamentoKitInternoCPK.class.getName()).log(Level.SEVERE, null, ex);
                }
                //INFORMAR QUE O KIT FOI CANCELADO.
                objComp.setIdRegistroComp(Integer.valueOf(jIdRegistro.getText()));
                objComp.setKitPago(pRespostaKit);
                controlPagoKit.confirmarPagamentoKit(objComp);
                //CONFIRMAR O PAGAMENTO DO KIT TAMBÉM NA TABELA "PROGRAMACAO_PAGAMENTO_KITS_INTERNOS" DA PROGRAMAÇÃO INDEPENDENTE.
                objComp.setIdKit(Integer.valueOf(jIdKit.getText()));
                objComp.setKitPago("Can");
                controlPagoKit.confirmarPagamentoKitProgramacao(objComp);
                //
                objLog();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                JOptionPane.showMessageDialog(rootPane, "Registro FINALIZADO com sucesso !!!");
                //
                bloquearBotoes(!true);
                bloquearCampos(!true);
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
            } else if (tipoServidor.equals("Servidor Windows/MS-SQL Server")) {
                //INFORMAR QUE O KIT FOI CANCELADO.
                objComp.setIdRegistroComp(Integer.valueOf(jIdRegistroComp.getText()));
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    java.sql.Date data = new java.sql.Date(format.parse(jDataSistema.getText()).getTime());
                    objComp.setDataPagamentoKit(data);
                } catch (ParseException ex) {
                    Logger.getLogger(TelaPagamentoKitInternoCPK.class.getName()).log(Level.SEVERE, null, ex);
                }
                objComp.setKitPago(pRespostaKit);
                controlPagoKit.confirmarPagamentoKit(objComp);
                //CONFIRMAR O PAGAMENTO DO KIT TAMBÉM NA TABELA "PROGRAMACAO_PAGAMENTO_KITS_INTERNOS" DA PROGRAMAÇÃO INDEPENDENTE.
                objComp.setIdKit(Integer.valueOf(jIdKit.getText()));
                objComp.setKitPago("Can");
                controlPagoKit.confirmarPagamentoKitProgramacao(objComp);
                //
                objLog();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                JOptionPane.showMessageDialog(rootPane, "Registro FINALIZADO com sucesso !!!");
                //
                bloquearBotoes(!true);
                bloquearCampos(!true);
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
            }
        }
    }

    public void buscarCodigo() {
        control.pesquisarCodigo(objCancelaKit);
    }

    public void PREENCHER_COMBO_pavilhao() {
        control.pesquisarPavilhao(objCancelaKit);
    }

    public void NovoInterno() {
        jBtPesquisarInterno.setEnabled(true);
        jBtSelecionaProdutos.setEnabled(true);
        //
        jBtSalvarInterno.setEnabled(true);
        jBtCancelarInterno.setEnabled(true);
    }

    public void AlterarInterno() {
        jBtPesquisarInterno.setEnabled(true);
        jBtSelecionaProdutos.setEnabled(true);
        //
        jBtSalvarInterno.setEnabled(true);
        jBtCancelarInterno.setEnabled(true);
    }

    public void ExcluirInterno() {

    }

    public void SalvarInterno() {

    }

    public void CancelarInterno() {

    }

    public void mostrarTodos() {
        DefaultTableModel dadosOrigem = (DefaultTableModel) jTabelaCancelamento.getModel();
        CancelamentoPagamentoKitHigiene d = new CancelamentoPagamentoKitHigiene();
        try {
            for (CancelamentoPagamentoKitHigiene dd : control.read()) {
                pDATA_Registros = String.valueOf(dd.getDataRegistro());
                String dia = pDATA_Registros.substring(8, 10);
                String mes = pDATA_Registros.substring(5, 7);
                String ano = pDATA_Registros.substring(0, 4);
                pDATA_Registros = dia + "/" + mes + "/" + ano;
                jtotalRegistros.setText(Integer.toString(pTOTAL_registros));
                dadosOrigem.addRow(new Object[]{dd.getIdRegistro(), pDATA_Registros, dd.getStatusRegistro(), dd.getTipoKit(), dd.getDescricaoPav()});
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaCancelamento.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaCancelamento.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                jTabelaCancelamento.getColumnModel().getColumn(1).setCellRenderer(centralizado);
                jTabelaCancelamento.getColumnModel().getColumn(2).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaCancelamentoPagamentoKits.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mostrarRegistroCodigo() {
        DefaultTableModel dadosOrigem = (DefaultTableModel) jTabelaCancelamento.getModel();
        CancelamentoPagamentoKitHigiene d = new CancelamentoPagamentoKitHigiene();
        try {
            for (CancelamentoPagamentoKitHigiene dd : listaCodigo.read()) {
                pDATA_Registros = String.valueOf(dd.getDataRegistro());
                String dia = pDATA_Registros.substring(8, 10);
                String mes = pDATA_Registros.substring(5, 7);
                String ano = pDATA_Registros.substring(0, 4);
                pDATA_Registros = dia + "/" + mes + "/" + ano;
                jtotalRegistros.setText(Integer.toString(pTOTAL_registros));
                dadosOrigem.addRow(new Object[]{dd.getIdRegistro(), pDATA_Registros, dd.getStatusRegistro(), dd.getTipoKit(), dd.getDescricaoPav()});
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaCancelamento.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaCancelamento.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                jTabelaCancelamento.getColumnModel().getColumn(1).setCellRenderer(centralizado);
                jTabelaCancelamento.getColumnModel().getColumn(2).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaCancelamentoPagamentoKits.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mostraPesquisaData() {
        DefaultTableModel dadosOrigem = (DefaultTableModel) jTabelaCancelamento.getModel();
        CancelamentoPagamentoKitHigiene d = new CancelamentoPagamentoKitHigiene();
        try {
            for (CancelamentoPagamentoKitHigiene dd : listaData.read()) {
                pDATA_Registros = String.valueOf(dd.getDataRegistro());
                String dia = pDATA_Registros.substring(8, 10);
                String mes = pDATA_Registros.substring(5, 7);
                String ano = pDATA_Registros.substring(0, 4);
                pDATA_Registros = dia + "/" + mes + "/" + ano;
                jtotalRegistros.setText(Integer.toString(pTOTAL_registros));
                dadosOrigem.addRow(new Object[]{dd.getIdRegistro(), pDATA_Registros, dd.getStatusRegistro(), dd.getTipoKit(), dd.getDescricaoPav()});
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaCancelamento.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaCancelamento.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                jTabelaCancelamento.getColumnModel().getColumn(1).setCellRenderer(centralizado);
                jTabelaCancelamento.getColumnModel().getColumn(2).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaCancelamentoPagamentoKits.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void pPREENCHER_TABELA_Internos() {

        DefaultTableModel dadosOrigem = (DefaultTableModel) jTabelaInternos.getModel();
        CancelamentoPagamentoKitHigiene d = new CancelamentoPagamentoKitHigiene();
        try {
            for (CancelamentoPagamentoKitHigiene dd : LISTAR_internos.read()) {
                dadosOrigem.addRow(new Object[]{dd.getIdItemINT(), dd.getIdInternoKit(), dd.getNomeInternoKit()});
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaInternos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaInternos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                jTabelaInternos.getColumnModel().getColumn(1).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaCancelamentoPagamentoKits.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mostrarItens() {
        DefaultTableModel dadosOrigem = (DefaultTableModel) jTabelaProdutosKitInterno.getModel();
        CancelamentoPagamentoKitHigiene d = new CancelamentoPagamentoKitHigiene();
        try {
            for (CancelamentoPagamentoKitHigiene dd : listaItens.read()) {
                dadosOrigem.addRow(new Object[]{dd.getIdRegistro(), dd.getCodigoProduto(), dd.getDescricaoProduto(), dd.getUnidadeProduto(), dd.getQuantidadeProduto()});
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaProdutosKitInterno.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaProdutosKitInterno.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                jTabelaProdutosKitInterno.getColumnModel().getColumn(1).setCellRenderer(centralizado);
                jTabelaProdutosKitInterno.getColumnModel().getColumn(3).setCellRenderer(centralizado);
                jTabelaProdutosKitInterno.getColumnModel().getColumn(4).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaCancelamentoPagamentoKits.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jIdRegistro.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }
}
