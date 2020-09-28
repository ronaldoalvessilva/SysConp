/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleHistoricoMovimentacaoENF;
import gestor.Controle.ControleHistoricoMovimentacaoFAR;
import gestor.Controle.ControleItensTransferenciaFAR;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControleLoteEnfermaria;
import gestor.Controle.ControleTransferenciaProdutos;
import gestor.Dao.ConexaoBancoDados;
import Utilitarios.ModeloTabela;
import gestor.Modelo.AtualizaLoteEnfermaria;
import gestor.Modelo.HistoricoMovimentacaoEstoque;
import gestor.Modelo.ItensProdutoTransferenciaLocal;
import gestor.Modelo.LogSistema;
import gestor.Modelo.TransferenciaProdutosLocal;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import java.awt.Color;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
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
 * @author ronaldo
 */
public class TelaTransferenciaEstoqueFarmacia extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    TransferenciaProdutosLocal objTransfProd = new TransferenciaProdutosLocal();
    ItensProdutoTransferenciaLocal objItensTranProd = new ItensProdutoTransferenciaLocal();
    ControleTransferenciaProdutos control = new ControleTransferenciaProdutos();
    ControleItensTransferenciaFAR controle = new ControleItensTransferenciaFAR();
    //
    HistoricoMovimentacaoEstoque objHistMovAC = new HistoricoMovimentacaoEstoque();
    ControleHistoricoMovimentacaoFAR controlHistMov = new ControleHistoricoMovimentacaoFAR();
    ControleLoteEnfermaria controleSaldoEnf = new ControleLoteEnfermaria();
    AtualizaLoteEnfermaria objAtuaSaldoEnf = new AtualizaLoteEnfermaria();
    //
    ControleHistoricoMovimentacaoENF controlHistENF = new ControleHistoricoMovimentacaoENF();// HISTORICO DE PRODUTOS ENFERMARIA
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela = "Farmacia:Transferência de Produtos:Manutenção";
    String nomeModuloTela2 = "Farmacia:Transferência de Produtos:Produtos";
    String statusMov;
    String horaMov;
    String dataModFinal;
    //
    int acao;
    int flag;
    String dataInicial;
    String dataFinal;
    String dataEntrada, dataEmissao;
    String statusProd = "Ativo";
    public static String idItem;
    public static String qtdItemTab;
    public static double qtdItem = 0;
    double valorUnitario1 = 0;
    String valorUnitario2;
    int count;
    String dataValidade, dataVcto;
    //
    String tipoOpercao = "T";
    String nomeOperacao = "Transferência de Produtos";
    double qtdEstoque = 0;
    String codRequisicao;
    double valorUnitario = 0;
    float valorTotalItem = 0;
    double valorTotalItem2 = 0;
    public static double qtdItemAnterior = 0; // SALDO ANTERIOR A SER CALCULADO SE FOR ALTERADO PELO USUARIO
    int codProd;
    int codEstoque; // CÓDIGO DO ITEM PARA GRAVAR COM MESMO LOTE DO 
    float saldoEstoque;
    float estoqueAtual = 0;
    float estoqueAtualEnf = 0;
    float saldoEstoqueEnf;
    String loteEstoque;
    String loteEstoqueEnf;
    public static double novoSaldoAtual = 0; //SALDO CALCULADO APOS ALTERAR A QUANTIDADE DO ITEM
    String atendReq = "Sim";
    int codProdLoteEnf; //VARIVALE RESPONSAVEL PELA PESQUISA DO CÓDIGO PARA TRANSFERENCIA DE SALDO
    float qtdLote;
    String nrLote, nrDoc;
    double qtdSaldoEnf = 0;
    Date date = null;
    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    String estornoProduto = "Não";
    String modulo = "F";
    String modulo1 = "E";
    public static String idItemTrans;

    /**
     * Creates new form TelaTransferenciaEstoqueFarmacia
     */
    public TelaTransferenciaEstoqueFarmacia() {
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

        jLabel3 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jIDPesqLan = new javax.swing.JTextField();
        jBtIdLanc = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jDataPesqInicial = new com.toedter.calendar.JDateChooser();
        jLabel24 = new javax.swing.JLabel();
        jDataPesFinal = new com.toedter.calendar.JDateChooser();
        jBtDataLanc = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel26 = new javax.swing.JLabel();
        jNomeRequisitante = new javax.swing.JTextField();
        jBtPesqRequisitante = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabelaTransferenciaProdutos = new javax.swing.JTable();
        jPanel31 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jIdLanc = new javax.swing.JTextField();
        jStatusLanc = new javax.swing.JTextField();
        jDataLanc = new com.toedter.calendar.JDateChooser();
        jPanel5 = new javax.swing.JPanel();
        jBtNovo = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jBtImprimirTransferencia = new javax.swing.JButton();
        jBtFinalizar = new javax.swing.JButton();
        jBtAuditoria = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jObservacao = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel11 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jIdFunc = new javax.swing.JTextField();
        jMatriculaFunc = new javax.swing.JTextField();
        jNomeColaborador = new javax.swing.JTextField();
        jBtPesqColaborador = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jIdReqEnfermaria = new javax.swing.JTextField();
        jBtPesqRequisicaoFar = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jIdLocalOrigem = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jBtPesqLocalOrigem = new javax.swing.JButton();
        jDescricaoLocalOrigem = new javax.swing.JTextField();
        jIdLocalDestino = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jBtPesqLocalDestinio = new javax.swing.JButton();
        jDescricaoLocalDestino = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jIdProd = new javax.swing.JTextField();
        jDescricaoProduto = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jQtdItem = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLote = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jDataVencimento = new com.toedter.calendar.JDateChooser();
        jBtPesqProduto = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jCodigoBarras = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jValorUN = new javax.swing.JTextField();
        jValorTotal = new javax.swing.JTextField();
        jtotalItens = new javax.swing.JLabel();
        jComboBoxUnidade = new javax.swing.JComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTabelaItensTransferencia = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jBtNovoItem = new javax.swing.JButton();
        jBtAlterarItem = new javax.swing.JButton();
        jBtExcluirItem = new javax.swing.JButton();
        jBtSalvarItem = new javax.swing.JButton();
        jBtCancelarItem = new javax.swing.JButton();
        jBtAuditoriaItem = new javax.swing.JButton();

        jLabel3.setText("jLabel3");

        setClosable(true);
        setIconifiable(true);
        setTitle("...:::Transferência de Estoque Farmacia/Enfermaria");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Código:");

        jIDPesqLan.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIDPesqLan.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtIdLanc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtIdLanc.setContentAreaFilled(false);
        jBtIdLanc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtIdLancActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Data Inicial:");

        jDataPesqInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setText("Data Final:");

        jDataPesFinal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtDataLanc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtDataLanc.setContentAreaFilled(false);
        jBtDataLanc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtDataLancActionPerformed(evt);
            }
        });

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox1.setText("Todos");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setText("Requisitante:");

        jNomeRequisitante.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqRequisitante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqRequisitante.setContentAreaFilled(false);
        jBtPesqRequisitante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqRequisitanteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDataPesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtDataLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jIDPesqLan, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtIdLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckBox1)
                                .addGap(19, 19, 19)))
                        .addGap(24, 24, 24))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jNomeRequisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqRequisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel8)
                    .addComponent(jIDPesqLan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtIdLanc)
                    .addComponent(jCheckBox1))
                .addGap(4, 4, 4)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jDataPesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jBtDataLanc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jNomeRequisitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(jBtPesqRequisitante))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaTransferenciaProdutos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaTransferenciaProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data", "Status", "Requisitante", "Observação"
            }
        ));
        jTabelaTransferenciaProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaTransferenciaProdutosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTabelaTransferenciaProdutos);
        if (jTabelaTransferenciaProdutos.getColumnModel().getColumnCount() > 0) {
            jTabelaTransferenciaProdutos.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaTransferenciaProdutos.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaTransferenciaProdutos.getColumnModel().getColumn(1).setMinWidth(80);
            jTabelaTransferenciaProdutos.getColumnModel().getColumn(1).setMaxWidth(80);
            jTabelaTransferenciaProdutos.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaTransferenciaProdutos.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaTransferenciaProdutos.getColumnModel().getColumn(3).setMinWidth(200);
            jTabelaTransferenciaProdutos.getColumnModel().getColumn(3).setMaxWidth(200);
            jTabelaTransferenciaProdutos.getColumnModel().getColumn(4).setMinWidth(280);
            jTabelaTransferenciaProdutos.getColumnModel().getColumn(4).setMaxWidth(280);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
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
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
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

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Data");

        jIdLanc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdLanc.setEnabled(false);

        jStatusLanc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jStatusLanc.setForeground(new java.awt.Color(255, 0, 0));
        jStatusLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jStatusLanc.setDisabledTextColor(new java.awt.Color(153, 0, 153));
        jStatusLanc.setEnabled(false);

        jDataLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataLanc.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jIdLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jStatusLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jDataLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIdLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jStatusLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jBtNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovo.setText("Novo");
        jBtNovo.setToolTipText("Novo Registro");
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
        jBtAlterar.setToolTipText("Alterar Registro");
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
        jBtExcluir.setToolTipText("Excluir Registro");
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
        jBtSalvar.setToolTipText("Gravar Registro");
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
        jBtCancelar.setToolTipText("Cancelar Operação");
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
        jBtSair.setToolTipText("Sair da Tela");
        jBtSair.setContentAreaFilled(false);
        jBtSair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSair.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSair.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(jBtNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtSair))
        );

        jBtImprimirTransferencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/gtklp-icone-3770-16.png"))); // NOI18N
        jBtImprimirTransferencia.setText("Imprimir");
        jBtImprimirTransferencia.setEnabled(false);
        jBtImprimirTransferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtImprimirTransferenciaActionPerformed(evt);
            }
        });

        jBtFinalizar.setForeground(new java.awt.Color(51, 153, 0));
        jBtFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/accept.png"))); // NOI18N
        jBtFinalizar.setText("Finalizar");
        jBtFinalizar.setToolTipText("Finalizar Registro");
        jBtFinalizar.setEnabled(false);
        jBtFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFinalizarActionPerformed(evt);
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

        jObservacao.setColumns(20);
        jObservacao.setRows(5);
        jObservacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jObservacao.setEnabled(false);
        jScrollPane1.setViewportView(jObservacao);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 255));
        jLabel5.setText("Observação:");

        jTabbedPane2.setForeground(new java.awt.Color(204, 0, 0));
        jTabbedPane2.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Código");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Matricula");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Nome Completo do Colaborador");

        jIdFunc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdFunc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdFunc.setEnabled(false);

        jMatriculaFunc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jMatriculaFunc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMatriculaFunc.setEnabled(false);

        jNomeColaborador.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeColaborador.setEnabled(false);

        jBtPesqColaborador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqColaborador.setContentAreaFilled(false);
        jBtPesqColaborador.setEnabled(false);
        jBtPesqColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqColaboradorActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 0, 255));
        jLabel27.setText("Atend. Req.");

        jIdReqEnfermaria.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdReqEnfermaria.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdReqEnfermaria.setEnabled(false);

        jBtPesqRequisicaoFar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqRequisicaoFar.setContentAreaFilled(false);
        jBtPesqRequisicaoFar.setEnabled(false);
        jBtPesqRequisicaoFar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqRequisicaoFarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(jIdFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addComponent(jMatriculaFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jIdReqEnfermaria)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jBtPesqRequisicaoFar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel27)
                                        .addGap(0, 115, Short.MAX_VALUE))))
                            .addComponent(jNomeColaborador, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIdFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqColaborador)
                    .addComponent(jMatriculaFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdReqEnfermaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqRequisicaoFar))
                .addGap(3, 3, 3)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNomeColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );

        jTabbedPane2.addTab("Requisitante", jPanel11);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 255));
        jLabel17.setText("Código");

        jIdLocalOrigem.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdLocalOrigem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdLocalOrigem.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 255));
        jLabel6.setText("Local de Origem");

        jBtPesqLocalOrigem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqLocalOrigem.setContentAreaFilled(false);
        jBtPesqLocalOrigem.setEnabled(false);
        jBtPesqLocalOrigem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqLocalOrigemActionPerformed(evt);
            }
        });

        jDescricaoLocalOrigem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDescricaoLocalOrigem.setEnabled(false);

        jIdLocalDestino.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdLocalDestino.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdLocalDestino.setEnabled(false);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 153, 0));
        jLabel16.setText("Código");

        jBtPesqLocalDestinio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqLocalDestinio.setContentAreaFilled(false);
        jBtPesqLocalDestinio.setEnabled(false);
        jBtPesqLocalDestinio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqLocalDestinioActionPerformed(evt);
            }
        });

        jDescricaoLocalDestino.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDescricaoLocalDestino.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 0));
        jLabel7.setText("Local de Destino");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jIdLocalDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jIdLocalOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jBtPesqLocalOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jDescricaoLocalOrigem)))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jBtPesqLocalDestinio, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jDescricaoLocalDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel12Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jIdLocalDestino, jIdLocalOrigem});

        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIdLocalOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqLocalOrigem)
                    .addComponent(jDescricaoLocalOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIdLocalDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqLocalDestinio)
                    .addComponent(jDescricaoLocalDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel12Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jIdLocalDestino, jIdLocalOrigem});

        jPanel12Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jDescricaoLocalDestino, jDescricaoLocalOrigem});

        jTabbedPane2.addTab("Local", jPanel12);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane2)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jBtAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jBtFinalizar)
                            .addComponent(jBtImprimirTransferencia)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(7, 7, 7)
                        .addComponent(jBtFinalizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtImprimirTransferencia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtAuditoria))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manutenção", jPanel2);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Código");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Descrição do Produto");

        jIdProd.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdProd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdProd.setEnabled(false);

        jDescricaoProduto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDescricaoProduto.setEnabled(false);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Unidade");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Qtde.");

        jQtdItem.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jQtdItem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQtdItem.setEnabled(false);
        jQtdItem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jQtdItemFocusLost(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Lote");

        jLote.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLote.setEnabled(false);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Data Vencto.");

        jDataVencimento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataVencimento.setEnabled(false);

        jBtPesqProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqProduto.setToolTipText("Pesquisar Produto");
        jBtPesqProduto.setContentAreaFilled(false);
        jBtPesqProduto.setEnabled(false);
        jBtPesqProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqProdutoActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Código Barras");

        jCodigoBarras.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodigoBarras.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCodigoBarras.setEnabled(false);
        jCodigoBarras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCodigoBarrasActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("Valor UN");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setText("Valor Total");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setText("Itens");

        jValorUN.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jValorUN.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jValorUN.setEnabled(false);

        jValorTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jValorTotal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jValorTotal.setEnabled(false);

        jtotalItens.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jtotalItens.setForeground(new java.awt.Color(255, 0, 0));
        jtotalItens.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jtotalItens.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jComboBoxUnidade.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxUnidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Un", "Caixa", "Pacote", "Ml", "Kg", "Litro", "Peça", "Amp", "Kit" }));
        jComboBoxUnidade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxUnidade.setEnabled(false);

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
                                .addComponent(jIdProd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jCodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLote, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jDataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jDescricaoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jComboBoxUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jQtdItem, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jValorUN)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtotalItens, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25))
                        .addGap(21, 21, 21))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel15)
                    .addComponent(jLabel21)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIdProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqProduto)
                    .addComponent(jCodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDescricaoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel23)
                    .addComponent(jLabel22)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jValorUN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jQtdItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtotalItens, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jValorTotal, jtotalItens});

        jTabelaItensTransferencia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaItensTransferencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Código", "Descrição Produto", "Qtd.", "Lote", "Data Lote"
            }
        ));
        jTabelaItensTransferencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaItensTransferenciaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTabelaItensTransferencia);
        if (jTabelaItensTransferencia.getColumnModel().getColumnCount() > 0) {
            jTabelaItensTransferencia.getColumnModel().getColumn(0).setMinWidth(40);
            jTabelaItensTransferencia.getColumnModel().getColumn(0).setMaxWidth(40);
            jTabelaItensTransferencia.getColumnModel().getColumn(1).setMinWidth(50);
            jTabelaItensTransferencia.getColumnModel().getColumn(1).setMaxWidth(50);
            jTabelaItensTransferencia.getColumnModel().getColumn(2).setMinWidth(300);
            jTabelaItensTransferencia.getColumnModel().getColumn(2).setMaxWidth(300);
            jTabelaItensTransferencia.getColumnModel().getColumn(3).setMinWidth(50);
            jTabelaItensTransferencia.getColumnModel().getColumn(3).setMaxWidth(50);
            jTabelaItensTransferencia.getColumnModel().getColumn(4).setMinWidth(80);
            jTabelaItensTransferencia.getColumnModel().getColumn(4).setMaxWidth(80);
            jTabelaItensTransferencia.getColumnModel().getColumn(5).setMinWidth(80);
            jTabelaItensTransferencia.getColumnModel().getColumn(5).setMaxWidth(80);
        }

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jBtNovoItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoItem.setText("Novo");
        jBtNovoItem.setToolTipText("Novo Registro");
        jBtNovoItem.setContentAreaFilled(false);
        jBtNovoItem.setEnabled(false);
        jBtNovoItem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovoItem.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovoItem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovoItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoItemActionPerformed(evt);
            }
        });

        jBtAlterarItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarItem.setText("Alterar");
        jBtAlterarItem.setToolTipText("Alterar Registro");
        jBtAlterarItem.setContentAreaFilled(false);
        jBtAlterarItem.setEnabled(false);
        jBtAlterarItem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterarItem.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarItem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarItemActionPerformed(evt);
            }
        });

        jBtExcluirItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirItem.setText("Excluir");
        jBtExcluirItem.setToolTipText("Excluir Registro");
        jBtExcluirItem.setContentAreaFilled(false);
        jBtExcluirItem.setEnabled(false);
        jBtExcluirItem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluirItem.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirItem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirItemActionPerformed(evt);
            }
        });

        jBtSalvarItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarItem.setText("Gravar");
        jBtSalvarItem.setToolTipText("Gravar Registro");
        jBtSalvarItem.setContentAreaFilled(false);
        jBtSalvarItem.setEnabled(false);
        jBtSalvarItem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvarItem.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarItem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarItemActionPerformed(evt);
            }
        });

        jBtCancelarItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarItem.setText("Cancelar");
        jBtCancelarItem.setToolTipText("Cancelar Operação");
        jBtCancelarItem.setContentAreaFilled(false);
        jBtCancelarItem.setEnabled(false);
        jBtCancelarItem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelarItem.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarItem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarItemActionPerformed(evt);
            }
        });

        jBtAuditoriaItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaItem.setToolTipText("Auditoria");
        jBtAuditoriaItem.setContentAreaFilled(false);
        jBtAuditoriaItem.setEnabled(false);
        jBtAuditoriaItem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAuditoriaItem.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAuditoriaItem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAuditoriaItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jBtNovoItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelarItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaItem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(jBtCancelarItem)
                .addComponent(jBtSalvarItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtExcluirItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAlterarItem)
                .addComponent(jBtNovoItem)
                .addComponent(jBtAuditoriaItem))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Produtos", jPanel7);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, Short.MAX_VALUE)
        );

        setBounds(300, 20, 475, 486);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtIdLancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtIdLancActionPerformed
        // TODO add your handling code here:
        if (jIDPesqLan.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um código para pesquisa.");
        } else {
            jTabelaTransferenciaProdutos.setVisible(true);
            preencherTabelaTransferencia("SELECT * FROM TRANSFERENCIA_PRODUTO_FAR "
                    + "INNER JOIN LOCAL_ARMAZENAMENTO_AC "
                    + "ON TRANSFERENCIA_PRODUTO_FAR.IdLocal=LOCAL_ARMAZENAMENTO_AC.IdLocal "
                    + "INNER JOIN COLABORADOR "
                    + "ON TRANSFERENCIA_PRODUTO_FAR.IdFunc=COLABORADOR.IdFunc "
                    + "WHERE IdLanc='" + jIDPesqLan.getText() + "'");
        }
    }//GEN-LAST:event_jBtIdLancActionPerformed

    private void jBtDataLancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtDataLancActionPerformed
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
                        SimpleDateFormat formatoAmerica = new SimpleDateFormat("yyyy/MM/dd");
                        dataInicial = formatoAmerica.format(jDataPesqInicial.getDate().getTime());
                        dataFinal = formatoAmerica.format(jDataPesFinal.getDate().getTime());
                        preencherTabelaTransferencia("SELECT * FROM TRANSFERENCIA_PRODUTO_FAR "
                                + "INNER JOIN LOCAL_ARMAZENAMENTO_AC "
                                + "ON TRANSFERENCIA_PRODUTO_FAR.IdLocal=LOCAL_ARMAZENAMENTO_AC.IdLocal "
                                + "INNER JOIN COLABORADOR "
                                + "ON TRANSFERENCIA_PRODUTO_FAR.IdFunc=COLABORADOR.IdFunc "
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
                        preencherTabelaTransferencia("SELECT * FROM TRANSFERENCIA_PRODUTO_FAR "
                                + "INNER JOIN LOCAL_ARMAZENAMENTO_AC "
                                + "ON TRANSFERENCIA_PRODUTO_FAR.IdLocal=LOCAL_ARMAZENAMENTO_AC.IdLocal "
                                + "INNER JOIN COLABORADOR "
                                + "ON TRANSFERENCIA_PRODUTO_FAR.IdFunc=COLABORADOR.IdFunc "
                                + "WHERE DataLanc BETWEEN'" + dataInicial + "' "
                                + "AND '" + dataFinal + "'");
                    }
                }
            }
        }
    }//GEN-LAST:event_jBtDataLancActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherTabelaTransferencia("SELECT * FROM TRANSFERENCIA_PRODUTO_FAR "
                    + "INNER JOIN LOCAL_ARMAZENAMENTO_AC "
                    + "ON TRANSFERENCIA_PRODUTO_FAR.IdLocal=LOCAL_ARMAZENAMENTO_AC.IdLocal "
                    + "INNER JOIN COLABORADOR "
                    + "ON TRANSFERENCIA_PRODUTO_FAR.IdFunc=COLABORADOR.IdFunc");
        } else {
            count = 0;
            jtotalRegistros.setText("");
            limparTabelaTransferencia();
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jBtPesqLocalOrigemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqLocalOrigemActionPerformed
        // TODO add your handling code here:
        TelaPesqLocalArmazenamentoTransf objPesqLocalArm = new TelaPesqLocalArmazenamentoTransf();
        TelaModuloFarmacia.jPainelFarmacia.add(objPesqLocalArm);
        objPesqLocalArm.show();
    }//GEN-LAST:event_jBtPesqLocalOrigemActionPerformed

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        acao = 1;
        Novo();
        corCampos();
        statusMov = "Incluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        // TODO add your handling code here:
        if (jStatusLanc.getText().equals("FINALIZADO")) {
            JOptionPane.showMessageDialog(rootPane, "Essa transferência de produtos não poderá ser alterado, o mesmo encontra-se FINALIZADO");
        } else {
            acao = 2;
            Alterar();
            corCampos();
            statusMov = "Alterou";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        }
    }//GEN-LAST:event_jBtAlterarActionPerformed

    private void jBtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirActionPerformed
        // TODO add your handling code here:
        if (jStatusLanc.getText().equals("FINALIZADO")) {
            JOptionPane.showMessageDialog(rootPane, "Essa transferência de produtos não poderá ser alterado, o mesmo encontra-se FINALIZADO");
        } else {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            verificarItensRequisitados();
        }
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        if (jDataLanc.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Informe a data de transferência.");
            jDataLanc.requestFocus();
            jDataLanc.setBackground(Color.red);
        } else if (jIdLocalOrigem.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o local de Origem.");
        } else if (jIdFunc.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o requisitante dos produtos.");
        } else if (jIdLocalDestino.getText().equals("") || jDescricaoLocalDestino.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "É neccessário informar o local de destino da transferência.");
        } else {
            objTransfProd.setStatusLanc(jStatusLanc.getText());
            objTransfProd.setDataLanc(jDataLanc.getDate());
            objTransfProd.setNomeLocal(jDescricaoLocalOrigem.getText());
            objTransfProd.setNomeColaborador(jNomeColaborador.getText());
            objTransfProd.setIdRequisicaoEnfermaria(Integer.valueOf(jIdReqEnfermaria.getText()));
            objTransfProd.setIdLocalDst(Integer.valueOf(jIdLocalDestino.getText()));
            objTransfProd.setDescricaoLocalDestino(jDescricaoLocalDestino.getText());
            objTransfProd.setObservacao(jObservacao.getText());
            if (acao == 1) {
                objTransfProd.setUsuarioInsert(nameUser);
                objTransfProd.setDataInsert(dataModFinal);
                objTransfProd.setHorarioInsert(horaMov);
                //
                control.incluirTransferenciaProduto(objTransfProd);
                buscarCodigo();
                objLog();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                Salvar();
            }
            if (acao == 2) {
                objTransfProd.setUsuarioUp(nameUser);
                objTransfProd.setDataUp(dataModFinal);
                objTransfProd.setHorarioUp(horaMov);
                //
                objTransfProd.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                control.alterarTransferenciaProduto(objTransfProd);
                //
                objLog();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                Salvar();
            }
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

    private void jBtPesqColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqColaboradorActionPerformed
        // TODO add your handling code here:
        TelaPesqColaboradorTransferencia objPesqColaborador = new TelaPesqColaboradorTransferencia();
        TelaModuloFarmacia.jPainelFarmacia.add(objPesqColaborador);
        objPesqColaborador.show();
    }//GEN-LAST:event_jBtPesqColaboradorActionPerformed

    private void jTabelaTransferenciaProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaTransferenciaProdutosMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String IdLanc = "" + jTabelaTransferenciaProdutos.getValueAt(jTabelaTransferenciaProdutos.getSelectedRow(), 0);
            jIDPesqLan.setText(IdLanc);
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtNovoItem.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            jBtImprimirTransferencia.setEnabled(true);
            //            
            jIdProd.setText("");
            jCodigoBarras.setText("");
            jLote.setText("");
            jDataVencimento.setDate(null);
            jDescricaoProduto.setText("");
            jIdLocalDestino.setText("");
            jDescricaoLocalDestino.setText("");
            jComboBoxUnidade.setSelectedItem(null);
            jQtdItem.setText("");
            jValorUN.setText("");
            jValorTotal.setText("");
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM TRANSFERENCIA_PRODUTO_FAR "
                        + "INNER JOIN LOCAL_ARMAZENAMENTO_AC "
                        + "ON TRANSFERENCIA_PRODUTO_FAR.IdLocal=LOCAL_ARMAZENAMENTO_AC.IdLocal "
                        + "INNER JOIN COLABORADOR "
                        + "ON TRANSFERENCIA_PRODUTO_FAR.IdFunc=COLABORADOR.IdFunc "
                        + "WHERE TRANSFERENCIA_PRODUTO_FAR.IdLanc='" + IdLanc + "'");
                conecta.rs.first();
                jIdLanc.setText(String.valueOf(conecta.rs.getInt("IdLanc")));
                jStatusLanc.setText(conecta.rs.getString("StatusLanc"));
                jDataLanc.setDate(conecta.rs.getDate("DataLanc"));
                jIdLocalOrigem.setText(conecta.rs.getString("IdLocal"));
                jDescricaoLocalOrigem.setText(conecta.rs.getString("DescricaoLocal"));
                jIdLocalDestino.setText(conecta.rs.getString("IdLocalDst"));
                jDescricaoLocalDestino.setText(conecta.rs.getString("DescricaoLocalDestino"));
                jIdReqEnfermaria.setText(conecta.rs.getString("IdReqEnf"));
                jIdFunc.setText(conecta.rs.getString("IdFunc"));
                jMatriculaFunc.setText(conecta.rs.getString("MatriculaFunc"));
                jNomeColaborador.setText(conecta.rs.getString("NomeFunc"));
                jObservacao.setText(conecta.rs.getString("Observacao"));
                conecta.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "Não foi possível exibir registro.\nERRO: " + e);
            }
            count = 0;
            preencherTabelaItens("SELECT * FROM ITENS_TRANSFERENCIA_PRODUTO_FAR "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON ITENS_TRANSFERENCIA_PRODUTO_FAR.IdProd=PRODUTOS_AC.IdProd "
                    + "WHERE ITENS_TRANSFERENCIA_PRODUTO_FAR.IdLanc='" + jIdLanc.getText() + "'");
        }
    }//GEN-LAST:event_jTabelaTransferenciaProdutosMouseClicked

    private void jBtPesqRequisitanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqRequisitanteActionPerformed
        // TODO add your handling code here:
        if (jIDPesqLan.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um código para pesquisa.");
        } else {
            jTabelaTransferenciaProdutos.setVisible(true);
            preencherTabelaTransferencia("SELECT * FROM TRANSFERENCIA_PRODUTO_FAR "
                    + "INNER JOIN LOCAL_ARMAZENAMENTO_AC "
                    + "ON TRANSFERENCIA_PRODUTO_FAR.IdLocal=LOCAL_ARMAZENAMENTO_AC.IdLocal "
                    + "INNER JOIN COLABORADOR "
                    + "ON TRANSFERENCIA_PRODUTO_FAR.IdFunc=COLABORADOR.IdFunc "
                    + "WHERE COLABORADOR.NomeFunc LIKE'%" + jNomeRequisitante.getText() + "%'");
        }
    }//GEN-LAST:event_jBtPesqRequisitanteActionPerformed

    private void jBtPesqProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqProdutoActionPerformed
        // TODO add your handling code here:
        // PESQUISAR O MEDICAMENTO SEM REQUISIÇÃO DA ENFERMARIA
        if (jIdReqEnfermaria.getText().equals("0")) {
            TelaPesqProdutoFarmaciaTransferencia objPesqProdTrans = new TelaPesqProdutoFarmaciaTransferencia();
            TelaModuloFarmacia.jPainelFarmacia.add(objPesqProdTrans);
            objPesqProdTrans.show();
        } else {
            // PESQUISA DE ACORDO COM A REQUISIÇÃO DA ENFERMARIA
            TelaPesqProdutoFarmaciaTransferenciaENFA objPesqProdTransENFA = new TelaPesqProdutoFarmaciaTransferenciaENFA();
            TelaModuloFarmacia.jPainelFarmacia.add(objPesqProdTransENFA);
            objPesqProdTransENFA.show();
        }
    }//GEN-LAST:event_jBtPesqProdutoActionPerformed

    private void jCodigoBarrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCodigoBarrasActionPerformed
        // TODO add your handling code here:
        if (jIdReqEnfermaria.getText().equals("")) {
            conecta.abrirConexao();
            conecta.executaSQL("SELECT * FROM PRODUTOS "
                    + "INNER JOIN LOCAL_ARMAZENAMENTO_AC "
                    + "ON PRODUTOS_AC.IdLocal=LOCAL_ARMAZENAMENTO_AC.IdLocal "
                    + "INNER JOIN LOTE_PRODUTOS_AC "
                    + "ON PRODUTOS_AC.IdProd=LOTE_PRODUTOS_AC.IdProd "
                    + "WHERE _AC.CodigoBarra='" + jCodigoBarras.getText() + "' "
                    + "AND PRODUTOS_AC.StatusProd='" + statusProd + "' "
                    + "AND Modulo='" + modulo + "'");
            try {
                if (conecta.rs.first()) {
                    jIdProd.setText(String.valueOf(conecta.rs.getInt("IdProd")));
                    jDescricaoProduto.setText(conecta.rs.getString("DescricaoProd"));
                    jCodigoBarras.setText(conecta.rs.getString("CodigoBarra"));
                    jLote.setText(conecta.rs.getString("Lote"));
                    jDataVencimento.setDate(conecta.rs.getDate("DataVenc"));
                    jValorUN.setText(conecta.rs.getString("ValorCompra"));
                    jComboBoxUnidade.setSelectedItem(conecta.rs.getString("UnidadeProd"));
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Produto não cadastro.");
                }
            } catch (SQLException ex) {
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jCodigoBarrasActionPerformed

    private void jBtPesqLocalDestinioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqLocalDestinioActionPerformed
        // TODO add your handling code here:
        TelaPesqLocalArmazenamentoTransfDestino objPesqLocalDestino = new TelaPesqLocalArmazenamentoTransfDestino();
        TelaModuloFarmacia.jPainelFarmacia.add(objPesqLocalDestino);
        objPesqLocalDestino.show();
    }//GEN-LAST:event_jBtPesqLocalDestinioActionPerformed

    private void jTabelaItensTransferenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaItensTransferenciaMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            idItem = "" + jTabelaItensTransferencia.getValueAt(jTabelaItensTransferencia.getSelectedRow(), 0);
            String idProduto = "" + jTabelaItensTransferencia.getValueAt(jTabelaItensTransferencia.getSelectedRow(), 1);
            jIdProd.setText(idProduto);
            String nomeProduto = "" + jTabelaItensTransferencia.getValueAt(jTabelaItensTransferencia.getSelectedRow(), 2);
            jDescricaoProduto.setText(nomeProduto);
            //            
            jBtNovo.setEnabled(!true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtAuditoria.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
            //
            jBtNovoItem.setEnabled(true);
            jBtAlterarItem.setEnabled(true);
            jBtExcluirItem.setEnabled(true);
            jBtSalvarItem.setEnabled(!true);
            jBtCancelarItem.setEnabled(true);
            jBtAuditoriaItem.setEnabled(true);
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ITENS_TRANSFERENCIA_PRODUTO_FAR "
                        + "INNER JOIN PRODUTOS_AC "
                        + "ON ITENS_TRANSFERENCIA_PRODUTO_FAR.IdProd=PRODUTOS_AC.IdProd "
                        + "INNER JOIN LOCAL_ARMAZENAMENTO_AC "
                        + "ON ITENS_TRANSFERENCIA_PRODUTO_FAR.IdLocal=LOCAL_ARMAZENAMENTO_AC.IdLocal "
                        + "INNER JOIN LOTE_PRODUTOS_AC "
                        + "ON ITENS_TRANSFERENCIA_PRODUTO_FAR.IdProd=LOTE_PRODUTOS_AC.IdProd "
                        + "WHERE ITENS_TRANSFERENCIA_PRODUTO_FAR.IdLanc='" + jIdLanc.getText() + "' "
                        + "AND ITENS_TRANSFERENCIA_PRODUTO_FAR.IdItem='" + idItem + "'");
                conecta.rs.first();
                idItem = conecta.rs.getString("IdItem");
                idItemTrans = conecta.rs.getString("IdItemLote");
                codEstoque = conecta.rs.getInt("IdItemLote");
                jIdProd.setText(conecta.rs.getString("IdProd"));
                jDescricaoProduto.setText(conecta.rs.getString("DescricaoProd"));
                jCodigoBarras.setText(conecta.rs.getString("CodigoBarra"));
                jDataVencimento.setDate(conecta.rs.getDate("DataVencLote"));
                jLote.setText(conecta.rs.getString("Lote"));
                jIdLocalDestino.setText(conecta.rs.getString("IdLocal"));
                jDescricaoLocalDestino.setText(conecta.rs.getString("DescricaoLocal"));
                jComboBoxUnidade.setSelectedItem(conecta.rs.getString("UnidadeProd"));
                // PEGA QUANTIDADE PARA CALCULAR SE O USUARIO ALTERAR A QUANTIDADE.
                qtdItemAnterior = conecta.rs.getFloat("QtdItem");
                qtdItem = conecta.rs.getFloat("QtdItem");
                DecimalFormat vi = new DecimalFormat("#,##0.00");
                String vqtdItem = vi.format(qtdItem);
                jQtdItem.setText(vqtdItem);
                // Formata o valor para ser exibido na tela no formato BR                                                   
                valorUnitario = conecta.rs.getFloat("ValorUN");
                DecimalFormat vu = new DecimalFormat("#,##0.00");
                String vlUnitario = vu.format(valorUnitario);
                jValorUN.setText(vlUnitario);
                //
                valorTotalItem2 = conecta.rs.getFloat("ValorTotal");
                DecimalFormat vti = new DecimalFormat("#,##0.00");
                String vlTotalItem = vti.format(valorTotalItem2);
                jValorTotal.setText(vlTotalItem);
                //
                conecta.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "Não foi possível selecionar o registro.\nERRO: " + e);
            }
        }
    }//GEN-LAST:event_jTabelaItensTransferenciaMouseClicked

    private void jBtNovoItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoItemActionPerformed
        // TODO add your handling code here:
        if (jStatusLanc.getText().equals("FINALIZADO")) {
            JOptionPane.showMessageDialog(rootPane, "Essa transferência de produtos não poderá ser alterado, o mesmo encontra-se FINALIZADO");
        } else {
            acao = 3;
            NovoItem();
            statusMov = "Alterou";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        }
    }//GEN-LAST:event_jBtNovoItemActionPerformed

    private void jBtAlterarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarItemActionPerformed
        // TODO add your handling code here:
        if (jStatusLanc.getText().equals("FINALIZADO")) {
            JOptionPane.showMessageDialog(rootPane, "Essa transferência de produtos não poderá ser alterado, o mesmo encontra-se FINALIZADO");
        } else {
            acao = 4;
            AlterarItem();
            statusMov = "Alterou";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        }
    }//GEN-LAST:event_jBtAlterarItemActionPerformed

    private void jBtExcluirItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirItemActionPerformed
        // TODO add your handling code here: 
        DecimalFormat qtdReal = new DecimalFormat("###,##00.0");
        qtdReal.setCurrency(Currency.getInstance(new Locale("pt", "BR")));
        objItensTranProd.setIdProd(Integer.valueOf(jIdProd.getText()));
        objItensTranProd.setLoteProduto(jLote.getText());
        estoqueAtual = 0;
        estoqueAtualEnf = 0;
        atendReq = "Não";
        objTransfProd.setStatusLanc(jStatusLanc.getText());
        if (jStatusLanc.getText().equals("FINALIZADO")) {
            JOptionPane.showMessageDialog(rootPane, "Essa transferência de produtos não poderá ser alterado, o mesmo encontra-se FINALIZADO");
        } else {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                try {
                    objItensTranProd.setQtdItem(qtdReal.parse(jQtdItem.getText()).floatValue());
                } catch (ParseException ex) {
                }
                objItensTranProd.setIdItemTrans(Integer.valueOf(idItemTrans));
                objItensTranProd.setIdProd(Integer.valueOf(jIdProd.getText()));
                objItensTranProd.setLoteProduto(jLote.getText());
                pegarSaldoEstoque(objItensTranProd.getIdProd(), objItensTranProd.getLoteProduto(), objItensTranProd.getIdItemTrans());
                // CALCULA O NOVO SALDO DE ESTOQUE DA FARMÁCIA
                estoqueAtual = saldoEstoque + objItensTranProd.getQtdItem();
                //                               
                objItensTranProd.setQtdItem(estoqueAtual);
                controle.alterarEstoqueProduto(objItensTranProd); // TABELA DE LOTE_PRODUTOS_AC - FARMÁCIA  
                //
                objItensTranProd.setIdItem(Integer.valueOf(idItem));
                controle.excluirItensTransferenciaFAR(objItensTranProd);
                // ALTERAR NA TABELA ITENS_REQUISICAO_PRODUTOS_INTERNOS_ENFAR O CAMNPO ReqAtend COMO "Não"
                objItensTranProd.setIdProd(Integer.valueOf(jIdProd.getText()));
                objItensTranProd.setIdReqFar(Integer.valueOf(jIdReqEnfermaria.getText()));
                objItensTranProd.setAtendeReqEnfermaria(atendReq);
                controle.alterarUtilizacaoRequisicaoTrans(objItensTranProd);
                // ATUALIZA A TABELA LOTE_PRODUTOS_ENF
                preencherTabelaItens("SELECT * FROM ITENS_TRANSFERENCIA_PRODUTO_FAR "
                        + "INNER JOIN PRODUTOS_AC "
                        + "ON ITENS_TRANSFERENCIA_PRODUTO_FAR.IdProd=PRODUTOS_AC.IdProd "
                        + "WHERE ITENS_TRANSFERENCIA_PRODUTO_FAR.IdLanc='" + jIdLanc.getText() + "'");
                JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                ExcluirItem();
            }
        }
    }//GEN-LAST:event_jBtExcluirItemActionPerformed

    private void jBtSalvarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarItemActionPerformed
        // TODO add your handling code here:
        atendReq = "Sim";
        DecimalFormat qtdReal = new DecimalFormat("###,##00.0");
        qtdReal.setCurrency(Currency.getInstance(new Locale("pt", "BR")));
        if (jIdProd.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o produto para transferencia.");
        } else if (jQtdItem.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe a quantidade");
        } else if (jIdLocalOrigem.getText() == null ? jIdLocalDestino.getText() == null : jIdLocalOrigem.getText().equals(jIdLocalDestino.getText())) {
            JOptionPane.showMessageDialog(rootPane, "Não é permitido transfereir os medicamentos para o mesmo local de armazenamento.");
        } else if (jIdLocalDestino.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o local de Destino para os produtos.");
        } else {
            objItensTranProd.setIdItemTrans(Integer.valueOf(idItemTrans)); // ITEM DO LOTE ALTERADO EM (02/08/2016)
            objItensTranProd.setIdProd(Integer.valueOf(jIdProd.getText()));
            objItensTranProd.setDescricaoProduto(jDescricaoProduto.getText());
            objItensTranProd.setIdLanc(Integer.valueOf(jIdLanc.getText()));
            objItensTranProd.setCodigoBarras(jCodigoBarras.getText());
            objItensTranProd.setLoteProduto(jLote.getText());
            objItensTranProd.setUnidadeProd((String) jComboBoxUnidade.getSelectedItem());
            objItensTranProd.setDataVctoLote(jDataVencimento.getDate());
            try {
                objItensTranProd.setQtdItem(qtdReal.parse(jQtdItem.getText()).floatValue());
                objItensTranProd.setValorUN(qtdReal.parse(jValorUN.getText()).floatValue());
            } catch (ParseException ex) {
            }
            // CALCULAR O VALOR TOTAL DO ITEM
            valorTotalItem = objItensTranProd.getQtdItem() * objItensTranProd.getValorUN();
            objItensTranProd.setValorTotal(valorTotalItem);
            objItensTranProd.setEstornoProduto(estornoProduto);
            objItensTranProd.setLoteProduto(jLote.getText());
            if (acao == 3) {
                objItensTranProd.setUsuarioInsert(nameUser);
                objItensTranProd.setDataInsert(dataModFinal);
                objItensTranProd.setHorarioInsert(horaMov);
                // PEGA PRODUTO PARA CALCULAR SALDO DE ESTOQUE FARMACIA
                pegarSaldoEstoque(objItensTranProd.getIdProd(), objItensTranProd.getLoteProduto(), objItensTranProd.getIdItemTrans());
                //
                if (saldoEstoque >= objItensTranProd.getQtdItem()) {
                    // CALCULA O NOVO SALDO DE ESTOQUE
                    estoqueAtual = saldoEstoque - objItensTranProd.getQtdItem();
                    //
                    objItensTranProd.setIdProd(Integer.valueOf(jIdProd.getText()));
                    objItensTranProd.setLoteProduto(jLote.getText());
                    objItensTranProd.setQtdItem(estoqueAtual);
                    controle.alterarEstoqueProduto(objItensTranProd); // TABELA DE LOTE_PRODUTOS_AC - FARMÁCIA                  
                    // GRAVAR REGISTRO NA TABELA ITENS_TRANSFERENCIA_PRODUTOS_FAR                   
                    try {
                        objItensTranProd.setQtdItem(qtdReal.parse(jQtdItem.getText()).floatValue());
                        objItensTranProd.setValorUN(qtdReal.parse(jValorUN.getText()).floatValue());
                    } catch (ParseException ex) {
                    }
                    objItensTranProd.setNomeLocal(jDescricaoLocalDestino.getText());
                    controle.incluirItensTransferenciaFAR(objItensTranProd);
                    //
                    objItensTranProd.setIdProd(Integer.valueOf(jIdProd.getText()));
                    objItensTranProd.setIdReqFar(Integer.valueOf(jIdReqEnfermaria.getText()));
                    objItensTranProd.setAtendeReqEnfermaria(atendReq);
                    // ATUALIZA A TABELA DE ITENS_REQUISICAO_PRODUTOS_ENFERAMRIA_ENFAR
                    controle.alterarUtilizacaoRequisicaoTrans(objItensTranProd);

                    // MODIFICAR, COLOCAR NA FINALIZAÇÃO
                    // PEGA O SALDO DA TABELA LOTE_PRODUTOS_ENF
//                    pegarSaldoEstoqueEnfermaria(objItensTranProd.getIdProd(), objItensTranProd.getLoteProduto(), objItensTranProd.getIdItem());
//                    // CALCULA O NOVO SALDO DE ESTOQUE DA ENFERMARIA
//                    estoqueAtualEnf = saldoEstoqueEnf + objItensTranProd.getQtdItem();
//                    //
//                    objItensTranProd.setIdProd(Integer.valueOf(jIdProd.getText()));
//                    objItensTranProd.setLoteProduto(jLote.getText());
//                    objItensTranProd.setQtdItem(estoqueAtualEnf);
//                    if (jLote.getText().equals(loteEstoqueEnf)) {
//                        controle.modificarLoteEnfermaria(objItensTranProd);// MODIFICA O ESTOQUE NA ENFERMARIA - LOTE_PRODUTOS_ENF
//                    } else {
//                        objItensTranProd.setIdProd(Integer.valueOf(jIdProd.getText()));
//                        objItensTranProd.setIdLanc(Integer.valueOf(jIdLanc.getText()));
//                        objItensTranProd.setDataVctoLote(jDataVencimento.getDate());
//                        objItensTranProd.setLoteProduto(jLote.getText());
//                        objItensTranProd.setQtdItem(estoqueAtualEnf);
//                        objItensTranProd.setIdItem(Integer.valueOf(idItemTrans)); // ITEM DO LOTE ALTERADO EM (02/08/2016)
//                        controle.adicionarLoteEnfermaria(objItensTranProd);
//                    }
                    objLog2();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    preencherTabelaItens("SELECT * FROM ITENS_TRANSFERENCIA_PRODUTO_FAR "
                            + "INNER JOIN PRODUTOS_AC "
                            + "ON ITENS_TRANSFERENCIA_PRODUTO_FAR.IdProd=PRODUTOS_AC.IdProd "
                            + "WHERE ITENS_TRANSFERENCIA_PRODUTO_FAR.IdLanc='" + jIdLanc.getText() + "'");
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    SalvarItem();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Saldo de Estoque insuficiente para atender requisição.");
                }
            }
            if (acao == 4) {
                objItensTranProd.setUsuarioUp(nameUser);
                objItensTranProd.setDataUp(dataModFinal);
                objItensTranProd.setHorarioUp(horaMov);
                //
                objItensTranProd.setIdItemTrans(Integer.valueOf(idItemTrans)); // ITEM DO LOTE ALTERADO EM (02/08/2016)
                objItensTranProd.setIdProd(Integer.valueOf(jIdProd.getText()));
                objItensTranProd.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                objItensTranProd.setDataVctoLote(jDataVencimento.getDate());
                objItensTranProd.setLoteProduto(jLote.getText());
                objItensTranProd.setQtdItem(estoqueAtualEnf);
                // PEGA PRODUTO PARA CALCULAR SALDO DE ESTOQUE DA FARMÁCIA
                pegarSaldoEstoque(objItensTranProd.getIdProd(), objItensTranProd.getLoteProduto(), objItensTranProd.getIdItemTrans());
                // CALCULA O NOVO SALDO DE ESTOQUE               
                novoSaldoAtual = (float) (qtdItemAnterior + saldoEstoque); // SOMA O SALDO DA TABELA LOTE COM A TABELA ITENS_REQUISICAO                           
                //
                if (novoSaldoAtual >= objItensTranProd.getQtdItem()) {
                    objItensTranProd.setIdProd(Integer.valueOf(jIdProd.getText()));
                    objItensTranProd.setLoteProduto(jLote.getText());
                    try {
                        objItensTranProd.setQtdItem(qtdReal.parse(jQtdItem.getText()).floatValue());
                        objItensTranProd.setValorUN(qtdReal.parse(jValorUN.getText()).floatValue());
                    } catch (ParseException ex) {
                    }
                    objItensTranProd.setIdItem(Integer.valueOf(idItem));
                    objItensTranProd.setNomeLocal(jDescricaoLocalDestino.getText());
                    controle.alterarItensTransferenciaFAR(objItensTranProd); // ALTERAR QUANTIDADE NA TABELA ITENS_TRANSFERENCIA_FAR
                    //
                    estoqueAtual = (float) (novoSaldoAtual - objItensTranProd.getQtdItem()); // DEDUZ O SALDO DE ESTOQUE E GRAVA
                    //                   
                    objItensTranProd.setIdItemTrans(codEstoque);
                    objItensTranProd.setQtdItem(estoqueAtual);
                    controle.alterarEstoqueProduto(objItensTranProd); // ALTERAR SALDO DE ESTOQUE NA TABELA DE LOTE_PRODUTOS_AC - FARMÁCIA                   

                    // ATUALIZA A TABELA LOTE_PRODUTOS_ENF (AINDA NÃO FOI TESTADO 23/10/2015)
//                    if (!jIdReqEnfermaria.getText().equals("")) {
//                        pegarSaldoEstoqueEnfermaria(objItensTranProd.getIdProd(), objItensTranProd.getLoteProduto(), objItensTranProd.getIdItem());
//                        // CALCULA O NOVO SALDO DE ESTOQUE
//                        estoqueAtualEnf = saldoEstoqueEnf - objItensTranProd.getQtdItem();
//                        //                        
//                        objItensTranProd.setIdItem(Integer.valueOf(idItemTrans)); // ITEM DO LOTE ALTERADO EM (02/08/2016)
//                        objItensTranProd.setIdProd(Integer.valueOf(jIdProd.getText()));
//                        objItensTranProd.setIdLanc(Integer.valueOf(jIdLanc.getText()));
//                        objItensTranProd.setDataVctoLote(jDataVencimento.getDate());
//                        objItensTranProd.setLoteProduto(jLote.getText());
//                        objItensTranProd.setQtdItem(estoqueAtualEnf);
//                        controle.modificarLoteEnfermaria(objItensTranProd);// MODIFICA O ESTOQUE NA ENFERMARIA - LOTE_PRODUTOS_ENF
//                    }
                    //
                    objLog2();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    preencherTabelaItens("SELECT * FROM ITENS_TRANSFERENCIA_PRODUTO_FAR "
                            + "INNER JOIN PRODUTOS_AC "
                            + "ON ITENS_TRANSFERENCIA_PRODUTO_FAR.IdProd=PRODUTOS_AC.IdProd "
                            + "WHERE ITENS_TRANSFERENCIA_PRODUTO_FAR.IdLanc='" + jIdLanc.getText() + "'");
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    SalvarItem();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Quantidade requisitada é maior que o saldo de estoque.");
                }
            }
        }
    }//GEN-LAST:event_jBtSalvarItemActionPerformed

    private void jBtCancelarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarItemActionPerformed
        // TODO add your handling code here:
        CancelarItem();
    }//GEN-LAST:event_jBtCancelarItemActionPerformed

    private void jBtAuditoriaItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaItemActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaItensTransferencia objAudItensTrans = new TelaAuditoriaItensTransferencia();
        TelaModuloFarmacia.jPainelFarmacia.add(objAudItensTrans);
        objAudItensTrans.show();
    }//GEN-LAST:event_jBtAuditoriaItemActionPerformed

    private void jBtFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFinalizarActionPerformed
        // TODO add your handling code here:
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM TRANSFERENCIA_PRODUTO_FAR WHERE Idlanc='" + jIdLanc.getText() + "'");
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

    private void jBtImprimirTransferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImprimirTransferenciaActionPerformed
        // TODO add your handling code here:
        if (jIdLanc.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Não é possível listar a transferência de Materiais.");
        } else {
            try {
                conecta.abrirConexao();
                String path = "reports/Farmacia/MateriaisLocaisArmazenamento/TransferenciaMateriaisLocaisArmazenamento.jasper";
                conecta.executaSQL("SELECT * FROM TRANSFERENCIA_PRODUTO_FAR "
                        + "INNER JOIN LOCAL_ARMAZENAMENTO_AC "
                        + "ON TRANSFERENCIA_PRODUTO_FAR.IdLocal=LOCAL_ARMAZENAMENTO_AC.IdLocal "
                        + "INNER JOIN COLABORADOR "
                        + "ON TRANSFERENCIA_PRODUTO_FAR.IdFunc=COLABORADOR.IdFunc "
                        + "WHERE TRANSFERENCIA_PRODUTO_FAR.IdLanc='" + jIdLanc.getText() + "'");
                HashMap parametros = new HashMap();
                parametros.put("codigoTransferencia", jIdLanc.getText());
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
                jv.setTitle("Transferência de Materiais entre Locais de Armazenamento");
                jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
                jv.toFront(); // Traz o relatorio para frente da aplicação            
                conecta.desconecta();
            } catch (JRException e) {
                JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
            }
        }
    }//GEN-LAST:event_jBtImprimirTransferenciaActionPerformed

    private void jQtdItemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jQtdItemFocusLost
        // TODO add your handling code here:
        DecimalFormat qtdReal = new DecimalFormat("###,##00.0");
        qtdReal.setCurrency(Currency.getInstance(new Locale("pt", "BR")));
        try {
            objItensTranProd.setQtdItem(qtdReal.parse(jQtdItem.getText()).floatValue());
            objItensTranProd.setValorUN(qtdReal.parse(jValorUN.getText()).floatValue());
            objItensTranProd.setValorTotal(qtdReal.parse(jValorTotal.getText()).floatValue());
        } catch (ParseException ex) {
        }
        valorTotalItem = objItensTranProd.getQtdItem() * objItensTranProd.getValorUN();
        objItensTranProd.setValorTotal(valorTotalItem);
        jValorTotal.setText(String.valueOf(Float.valueOf(valorTotalItem)));
        // jValorTotal.setText((String.valueOf(Double.parseDouble(jQtdItem.getText())* Double.parseDouble(jValorUN.getText()))));
    }//GEN-LAST:event_jQtdItemFocusLost

    private void jBtAuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaActionPerformed

        TelaAuditoriaTransferenciaEstoqueFarmacia objAudiTrans = new TelaAuditoriaTransferenciaEstoqueFarmacia();
        TelaModuloFarmacia.jPainelFarmacia.add(objAudiTrans);
        objAudiTrans.show();
    }//GEN-LAST:event_jBtAuditoriaActionPerformed

    private void jBtPesqRequisicaoFarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqRequisicaoFarActionPerformed
        // TODO add your handling code here:
        TelaPesqRequisicaoMateriaisENFAR objSoliMatENFA = new TelaPesqRequisicaoMateriaisENFAR();
        TelaModuloFarmacia.jPainelFarmacia.add(objSoliMatENFA);
        objSoliMatENFA.show();
    }//GEN-LAST:event_jBtPesqRequisicaoFarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtAlterarItem;
    private javax.swing.JButton jBtAuditoria;
    private javax.swing.JButton jBtAuditoriaItem;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtCancelarItem;
    private javax.swing.JButton jBtDataLanc;
    private javax.swing.JButton jBtExcluir;
    private javax.swing.JButton jBtExcluirItem;
    private javax.swing.JButton jBtFinalizar;
    private javax.swing.JButton jBtIdLanc;
    private javax.swing.JButton jBtImprimirTransferencia;
    private javax.swing.JButton jBtNovo;
    private javax.swing.JButton jBtNovoItem;
    private javax.swing.JButton jBtPesqColaborador;
    private javax.swing.JButton jBtPesqLocalDestinio;
    private javax.swing.JButton jBtPesqLocalOrigem;
    private javax.swing.JButton jBtPesqProduto;
    private javax.swing.JButton jBtPesqRequisicaoFar;
    private javax.swing.JButton jBtPesqRequisitante;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JButton jBtSalvarItem;
    private javax.swing.JCheckBox jCheckBox1;
    public static javax.swing.JTextField jCodigoBarras;
    public static javax.swing.JComboBox jComboBoxUnidade;
    private com.toedter.calendar.JDateChooser jDataLanc;
    private com.toedter.calendar.JDateChooser jDataPesFinal;
    private com.toedter.calendar.JDateChooser jDataPesqInicial;
    public static com.toedter.calendar.JDateChooser jDataVencimento;
    public static javax.swing.JTextField jDescricaoLocalDestino;
    public static javax.swing.JTextField jDescricaoLocalOrigem;
    public static javax.swing.JTextField jDescricaoProduto;
    private javax.swing.JTextField jIDPesqLan;
    public static javax.swing.JTextField jIdFunc;
    public static javax.swing.JTextField jIdLanc;
    public static javax.swing.JTextField jIdLocalDestino;
    public static javax.swing.JTextField jIdLocalOrigem;
    public static javax.swing.JTextField jIdProd;
    public static javax.swing.JTextField jIdReqEnfermaria;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JTextField jLote;
    public static javax.swing.JTextField jMatriculaFunc;
    public static javax.swing.JTextField jNomeColaborador;
    private javax.swing.JTextField jNomeRequisitante;
    private javax.swing.JTextArea jObservacao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    public static javax.swing.JTextField jQtdItem;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jStatusLanc;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTabelaItensTransferencia;
    private javax.swing.JTable jTabelaTransferenciaProdutos;
    private javax.swing.JTextField jValorTotal;
    public static javax.swing.JTextField jValorUN;
    private javax.swing.JLabel jtotalItens;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void formatarCampos() {
        jObservacao.setLineWrap(true);
        jObservacao.setWrapStyleWord(true);
    }

    public void corCampos() {
        jIdLanc.setBackground(Color.white);
        jStatusLanc.setBackground(Color.white);
        jDataLanc.setBackground(Color.white);
        jIdLocalOrigem.setBackground(Color.white);
        jDescricaoLocalOrigem.setBackground(Color.white);
        jIdFunc.setBackground(Color.white);
        jMatriculaFunc.setBackground(Color.white);
        jIdReqEnfermaria.setBackground(Color.white);
        jNomeColaborador.setBackground(Color.white);
        jObservacao.setBackground(Color.white);
        //
        jIdProd.setBackground(Color.white);
        jCodigoBarras.setBackground(Color.white);
        jLote.setBackground(Color.white);
        jDataVencimento.setBackground(Color.white);
        jDescricaoProduto.setBackground(Color.white);
        jIdLocalDestino.setBackground(Color.white);
        jDescricaoLocalDestino.setBackground(Color.white);
        jComboBoxUnidade.setBackground(Color.white);
        jQtdItem.setBackground(Color.white);
        jValorUN.setBackground(Color.white);
        jValorTotal.setBackground(Color.white);
    }

    public void Novo() {
        jIdLanc.setText("");
        jStatusLanc.setText("ABERTO");
        jDataLanc.setCalendar(Calendar.getInstance());
        jIdLocalOrigem.setText("");
        jDescricaoLocalOrigem.setText("");
        jIdLocalDestino.setText("");
        jDescricaoLocalDestino.setText("");
        jIdFunc.setText("");
        jMatriculaFunc.setText("");
        jIdReqEnfermaria.setText("");
        jIdReqEnfermaria.setText("0");
        jNomeColaborador.setText("");
        jObservacao.setText("");
        //
        jDataLanc.setEnabled(true);
        jBtPesqLocalOrigem.setEnabled(true);
        jBtPesqLocalDestinio.setEnabled(true);
        jBtPesqColaborador.setEnabled(true);
        jBtPesqRequisicaoFar.setEnabled(true);
        jObservacao.setEnabled(true);
        //
        jIdProd.setText("");
        jCodigoBarras.setText("");
        jLote.setText("");
        jDataVencimento.setDate(null);
        jDescricaoProduto.setText("");
        jComboBoxUnidade.setSelectedItem(null);
        jQtdItem.setText("");
        jValorUN.setText("");
        jValorTotal.setText("");
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        jBtImprimirTransferencia.setEnabled(!true);
        //
        jBtNovoItem.setEnabled(!true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        jBtAuditoriaItem.setEnabled(!true);
        limparTabelaItens();
    }

    public void Alterar() {
        //
        jDataLanc.setEnabled(true);
        jBtPesqLocalOrigem.setEnabled(true);
        jBtPesqLocalDestinio.setEnabled(true);
        jBtPesqColaborador.setEnabled(true);
        jBtPesqRequisicaoFar.setEnabled(true);
        jObservacao.setEnabled(true);
        //
        jIdProd.setText("");
        jCodigoBarras.setText("");
        jLote.setText("");
        jDataVencimento.setDate(null);
        jDescricaoProduto.setText("");
        jComboBoxUnidade.setSelectedItem(null);
        jQtdItem.setText("");
        jValorUN.setText("");
        jValorTotal.setText("");
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        jBtImprimirTransferencia.setEnabled(!true);
        //
        jBtNovoItem.setEnabled(!true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        jBtAuditoriaItem.setEnabled(!true);
    }

    public void Excluir() {
        jIdLanc.setText("");
        jStatusLanc.setText("");
        jDataLanc.setDate(null);
        jIdLocalOrigem.setText("");
        jDescricaoLocalOrigem.setText("");
        jIdLocalDestino.setText("");
        jDescricaoLocalDestino.setText("");
        jIdFunc.setText("");
        jMatriculaFunc.setText("");
        jIdReqEnfermaria.setText("");
        jNomeColaborador.setText("");
        jObservacao.setText("");
        //
        jDataLanc.setEnabled(!true);
        jBtPesqLocalOrigem.setEnabled(!true);
        jBtPesqLocalDestinio.setEnabled(!true);
        jBtPesqColaborador.setEnabled(!true);
        jBtPesqRequisicaoFar.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        jBtImprimirTransferencia.setEnabled(!true);
        //
        jBtNovoItem.setEnabled(true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        jBtAuditoriaItem.setEnabled(!true);
    }

    public void Salvar() {
        //
        jDataLanc.setEnabled(!true);
        jBtPesqLocalOrigem.setEnabled(!true);
        jBtPesqLocalDestinio.setEnabled(!true);
        jBtPesqColaborador.setEnabled(!true);
        jBtPesqRequisicaoFar.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        jBtImprimirTransferencia.setEnabled(true);
        //
        jBtNovoItem.setEnabled(true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        jBtAuditoriaItem.setEnabled(!true);
    }

    public void Cancelar() {
        if (jIdLanc.getText().equals("")) {
            jIdLanc.setText("");
            jStatusLanc.setText("");
            jDataLanc.setDate(null);
            jIdLocalOrigem.setText("");
            jDescricaoLocalOrigem.setText("");
            jIdLocalDestino.setText("");
            jDescricaoLocalDestino.setText("");
            jIdFunc.setText("");
            jMatriculaFunc.setText("");
            jIdReqEnfermaria.setText("");
            jNomeColaborador.setText("");
            jObservacao.setText("");
            //
            jDataLanc.setEnabled(!true);
            jBtPesqLocalOrigem.setEnabled(!true);
            jBtPesqLocalDestinio.setEnabled(!true);
            jBtPesqColaborador.setEnabled(!true);
            jBtPesqRequisicaoFar.setEnabled(!true);
            jObservacao.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
            jBtAuditoria.setEnabled(!true);
            jBtImprimirTransferencia.setEnabled(!true);
            //
            jBtNovoItem.setEnabled(!true);
            jBtAlterarItem.setEnabled(!true);
            jBtExcluirItem.setEnabled(!true);
            jBtSalvarItem.setEnabled(!true);
            jBtCancelarItem.setEnabled(!true);
            jBtAuditoriaItem.setEnabled(!true);
        } else {
            //
            jDataLanc.setEnabled(!true);
            jBtPesqLocalOrigem.setEnabled(!true);
            jBtPesqLocalDestinio.setEnabled(!true);
            jBtPesqColaborador.setEnabled(!true);
            jBtPesqRequisicaoFar.setEnabled(!true);
            jObservacao.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            jBtImprimirTransferencia.setEnabled(!true);
            //
            jBtNovoItem.setEnabled(true);
            jBtAlterarItem.setEnabled(!true);
            jBtExcluirItem.setEnabled(!true);
            jBtSalvarItem.setEnabled(!true);
            jBtCancelarItem.setEnabled(!true);
            jBtAuditoriaItem.setEnabled(!true);
        }
    }

    public void buscarCodigo() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM TRANSFERENCIA_PRODUTO_FAR");
            conecta.rs.last();
            jIdLanc.setText(conecta.rs.getString("IdLanc"));
        } catch (SQLException ex) {
        }
        conecta.desconecta();
    }

    public void verificarItensRequisitados() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENS_TRANSFERENCIA_PRODUTO_FAR WHERE IdLanc='" + jIdLanc.getText() + "'");
            conecta.rs.first();
            codRequisicao = conecta.rs.getString("IdLanc");
            if (jIdLanc.getText().equals(codRequisicao)) {
                JOptionPane.showMessageDialog(rootPane, "Antes de excluir esse Lançamento, será necessário\nexcluir primeiro os itens relacionados a esse registro.");
            }
        } catch (SQLException ex) {
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o LANÇAMENTO selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objTransfProd.setIdLanc(Integer.parseInt(jIdLanc.getText()));
                control.excluirTransferenciaProduto(objTransfProd);
                objLog();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                Excluir();
            }
        }
    }

    public void Finalizar() {
        // VERIFICAR SE A TABELA TEM PRODUTOS, SE ESTIVER VAZIA NÃO FINALIZA
        Integer rows = jTabelaItensTransferencia.getModel().getRowCount();
        if (rows == 0) {
            JOptionPane.showMessageDialog(rootPane, "Não existe produtos a ser lançado.");
        } else {
            String statusLanc = "FINALIZADO";
            statusMov = "Finalizou";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            JOptionPane.showMessageDialog(rootPane, "Se esse Lançamento for finaliza,\nvocê não poderá mais excluir ou alterar.");
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente finalizar assim mesmo o lançamento selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                lancarEstoqueEnfermaria();
                lancarHistorico();
                objTransfProd.setStatusLanc(statusLanc);
                objTransfProd.setIdLanc(Integer.parseInt(jIdLanc.getText()));
                control.finalizarTransferenciaProduto(objTransfProd);
                jStatusLanc.setText("FINALIZADO");
                objLog();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                JOptionPane.showMessageDialog(rootPane, "Registro FINALIZADO com sucesso !!!");
                //
                jDataLanc.setEnabled(!true);
                jObservacao.setEnabled(!true);
                //
                jBtNovo.setEnabled(true);
                jBtAlterar.setEnabled(!true);
                jBtExcluir.setEnabled(!true);
                jBtSalvar.setEnabled(!true);
                jBtCancelar.setEnabled(!true);
                jBtFinalizar.setEnabled(!true);
                jBtImprimirTransferencia.setEnabled(true);
                jBtAuditoria.setEnabled(true);
                //
                jBtNovoItem.setEnabled(!true);
                jBtAlterarItem.setEnabled(!true);
                jBtExcluirItem.setEnabled(!true);
                jBtSalvarItem.setEnabled(!true);
                jBtCancelarItem.setEnabled(!true);
            }
        }
    }

    public void lancarHistorico() {
        DecimalFormat valorRealMoed = new DecimalFormat("#,##00.0");
        valorRealMoed.setCurrency(Currency.getInstance(new Locale("pt", "BR")));
        for (int i = 0; i < jTabelaItensTransferencia.getRowCount(); i++) {
            // LANÇAR HISTÓRICO DA SAIDA DA REQUISIÇÃO.
            objHistMovAC.setIdProd((int) jTabelaItensTransferencia.getValueAt(i, 1));
            objHistMovAC.setIdLocal(Integer.valueOf(jIdLocalOrigem.getText()));
            objHistMovAC.setTipoOpe(tipoOpercao);
            objHistMovAC.setNomeOperacao(nomeOperacao);
            objHistMovAC.setIdDoc(Integer.valueOf(jIdLanc.getText()));
            objHistMovAC.setDataMov(jDataLanc.getDate());
            try {
                objHistMovAC.setQtdItem(valorRealMoed.parse((String) jTabelaItensTransferencia.getValueAt(i, 3)).floatValue());
                objAtuaSaldoEnf.setQtd(valorRealMoed.parse((String) jTabelaItensTransferencia.getValueAt(i, 3)).floatValue());
            } catch (ParseException ex) {
            }
            somaProdutoLote(); // SOMAR PRODUTO NA TABELA DE LOTEESTOQUE PARA  TABELA HISTORICO_MOVIMENTACAO_ESTOQUE_FAR
            objHistMovAC.setSaldoAtual((float) qtdEstoque);
            controlHistMov.incluirHistoricoProdutoFAR(objHistMovAC); // SALVAR NA TABELA HISTORICO_MOVIMENTACAO_ESTOQUE_FAR
            //
            objHistMovAC.setLoteProduto((String) jTabelaItensTransferencia.getValueAt(i, 5));
            pesquisarProdutoLocalEnfermaria(); // BUSCAR DADOS DO LOTE PARA COMPARAR SE INSERE OU ALTERA
            if (objHistMovAC.getLoteProduto().equals(nrLote) && objHistMovAC.getIdProd() == codProdLoteEnf) {
                objAtuaSaldoEnf.setIdProd((int) jTabelaItensTransferencia.getValueAt(i, 1));
                objAtuaSaldoEnf.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                try {
                    // Converte a data de string para date, para ser inserido no banco de dados.
                    date = (java.util.Date) formatter.parse((String) jTabelaItensTransferencia.getValueAt(i, 4));
                } catch (ParseException ex) {
                }
                objAtuaSaldoEnf.setDataValidade(date);
                objAtuaSaldoEnf.setLote((String) jTabelaItensTransferencia.getValueAt(i, 5));
                controleSaldoEnf.alterarLoteProdutoEnfermaria(objAtuaSaldoEnf); // ALTERA A QUANTIDADE DO LOTE SE JÁ EXISTIR
            } else {
                objAtuaSaldoEnf.setIdProd((int) jTabelaItensTransferencia.getValueAt(i, 1));
                objAtuaSaldoEnf.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                try {
                    // Converte a data de string para date, para ser inserido no banco de dados.
                    date = (java.util.Date) formatter.parse((String) jTabelaItensTransferencia.getValueAt(i, 4));
                } catch (ParseException ex) {
                }
            }
            // LANÇAMENTO NA TABELA HISTORICO_MOVIMENTACAO_PRODUTO_ENF      
            somaProdutoLoteENF(); // SOMAR PRODUTOS NA TABELA LOTE_PRODUTOS_ENF (ENFERMARIA)
            objHistMovAC.setIdLocal(Integer.valueOf(jIdLocalDestino.getText()));
            objHistMovAC.setSaldoAtual((float) qtdEstoque);
            controlHistENF.incluirHistoricoProdutoENF(objHistMovAC); // SALVAR NA TABELA HISTORICO_MOVIMENTACAO_ESTOQUE_ENF
        }
    }

    public void lancarEstoqueEnfermaria() {

        DecimalFormat valorRealMoed = new DecimalFormat("#,##00.0");
        valorRealMoed.setCurrency(Currency.getInstance(new Locale("pt", "BR")));
        for (int i = 0; i < jTabelaItensTransferencia.getRowCount(); i++) {
            objItensTranProd.setIdLanc(Integer.valueOf(jIdLanc.getText()));
            objItensTranProd.setIdProd((int) jTabelaItensTransferencia.getValueAt(i, 1));
            objItensTranProd.setDescricaoProduto((String) jTabelaItensTransferencia.getValueAt(i, 2));
            try {
                // QUANTIDADE DO PRODUTO
                objItensTranProd.setQtdItem(valorRealMoed.parse((String) jTabelaItensTransferencia.getValueAt(i, 3)).floatValue());
            } catch (ParseException ex) {
            }
            objItensTranProd.setLoteProduto((String) jTabelaItensTransferencia.getValueAt(i, 4));
            try {
                // Converte a data de string para date, para ser inserido no banco de dados.
                date = (java.util.Date) formatter.parse((String) jTabelaItensTransferencia.getValueAt(i, 5));
            } catch (ParseException ex) {
            }
            objItensTranProd.setDataVctoLote(date);
            // PEGA O SALDO DA TABELA LOTE_PRODUTOS_ENF
            pegarSaldoEstoqueEnfermaria(objItensTranProd.getIdProd(), objItensTranProd.getLoteProduto(), objItensTranProd.getIdItem());
            // CALCULA O NOVO SALDO DE ESTOQUE DA ENFERMARIA
            estoqueAtualEnf = saldoEstoqueEnf + objItensTranProd.getQtdItem();
            if (jLote.getText().equals(objItensTranProd.getLoteProduto())) {
                controle.modificarLoteEnfermaria(objItensTranProd);// MODIFICA O ESTOQUE NA ENFERMARIA - LOTE_PRODUTOS_ENF
            } else {
                controle.adicionarLoteEnfermaria(objItensTranProd);
            }
        }
    }

// SOMAR QUANTIDADE DE CADA PRODUTO NA TABELA DE LOTE_PRODUTOS_AC PARA INSERIR NA TABELA DE HISTORICO MOVIMENTAÇÃO ESTOQUE
    public void somaProdutoLote() {
        qtdEstoque = 0;
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM LOTE_PRODUTOS_AC WHERE IdProd='" + objHistMovAC.getIdProd() + "'");
            while (conecta.rs.next()) {
                qtdEstoque = qtdEstoque + conecta.rs.getFloat("Qtd");
            }
            objHistMovAC.setSaldoAtual((float) qtdEstoque);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro na soma do saldo de estoque.\nERRO: " + ex);
        }
    }

    public void somaProdutoLoteENF() {
        qtdEstoque = 0;
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM LOTE_PRODUTOS_ENF WHERE IdProd='" + objHistMovAC.getIdProd() + "'");
            while (conecta.rs.next()) {
                qtdEstoque = qtdEstoque + conecta.rs.getFloat("Qtd");
            }
            objHistMovAC.setSaldoAtual((float) qtdEstoque);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro na soma do saldo de estoque.\nERRO: " + ex);
        }
    }

    public void pesquisarProdutoLocalEnfermaria() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM LOTE_PRODUTOS_ENF WHERE IdProd='" + objAtuaSaldoEnf.getIdProd() + "'");
            conecta.rs.first();
            codProdLoteEnf = conecta.rs.getInt("IdProd");
            qtdLote = conecta.rs.getFloat("Qtd");
            nrLote = conecta.rs.getString("Lote");
            nrDoc = conecta.rs.getString("IdLanc");
        } catch (Exception e) {
        }
    }

    public void NovoItem() {
        jIdProd.setText("");
        jCodigoBarras.setText("");
        jLote.setText("");
        jDataVencimento.setDate(null);
        jDescricaoProduto.setText("");
        jComboBoxUnidade.setSelectedItem(null);
        jQtdItem.setText("");
        jValorUN.setText("");
        jValorTotal.setText("");
        //
        jBtPesqProduto.setEnabled(true);
        jQtdItem.setEnabled(true);
        jValorUN.setEnabled(true);
        jValorTotal.setEnabled(true);

        //
        jBtNovoItem.setEnabled(!true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(true);
        jBtCancelarItem.setEnabled(true);
        //     jBtAuditoriaItem.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
    }

    public void AlterarItem() {
        if (!jIdReqEnfermaria.getText().equals("0")) {
            jBtPesqProduto.setEnabled(!true);
            jQtdItem.setEnabled(!true);
            jValorUN.setEnabled(!true);
            jValorTotal.setEnabled(!true);
            //
            jBtNovoItem.setEnabled(!true);
            jBtAlterarItem.setEnabled(!true);
            jBtExcluirItem.setEnabled(!true);
            jBtSalvarItem.setEnabled(!true);
            jBtCancelarItem.setEnabled(true);
            jBtAuditoriaItem.setEnabled(!true);
            //
            jBtNovo.setEnabled(!true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
            jBtAuditoria.setEnabled(!true);
        } else {
            jBtPesqProduto.setEnabled(true);
            jQtdItem.setEnabled(true);
            jValorUN.setEnabled(true);
            jValorTotal.setEnabled(true);
            jBtPesqLocalDestinio.setEnabled(true);
            //
            jBtNovoItem.setEnabled(!true);
            jBtAlterarItem.setEnabled(!true);
            jBtExcluirItem.setEnabled(!true);
            jBtSalvarItem.setEnabled(true);
            jBtCancelarItem.setEnabled(true);
            jBtAuditoriaItem.setEnabled(!true);
            //
            jBtNovo.setEnabled(!true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
            jBtAuditoria.setEnabled(!true);
        }
    }

    public void ExcluirItem() {
        jIdProd.setText("");
        jCodigoBarras.setText("");
        jLote.setText("");
        jDataVencimento.setDate(null);
        jDescricaoProduto.setText("");
        jComboBoxUnidade.setSelectedItem(null);
        jQtdItem.setText("");
        jValorUN.setText("");
        jValorTotal.setText("");
        //
        jBtPesqProduto.setEnabled(!true);
        jQtdItem.setEnabled(!true);
        jValorUN.setEnabled(!true);
        jValorTotal.setEnabled(!true);
        //
        jBtNovoItem.setEnabled(true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        //   jBtAuditoriaItem.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
    }

    public void SalvarItem() {
        jIdProd.setText("");
        jCodigoBarras.setText("");
        jLote.setText("");
        jDataVencimento.setDate(null);
        jDescricaoProduto.setText("");
        jComboBoxUnidade.setSelectedItem(null);
        jQtdItem.setText("");
        jValorUN.setText("");
        jValorTotal.setText("");
        //
        jBtPesqProduto.setEnabled(!true);
        jQtdItem.setEnabled(!true);
        jValorUN.setEnabled(!true);
        jValorTotal.setEnabled(!true);
        //
        jBtNovoItem.setEnabled(true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        //   jBtAuditoriaItem.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
    }

    public void CancelarItem() {
        jIdProd.setText("");
        jCodigoBarras.setText("");
        jLote.setText("");
        jDataVencimento.setDate(null);
        jDescricaoProduto.setText("");
        jComboBoxUnidade.setSelectedItem(null);
        jQtdItem.setText("");
        jValorUN.setText("");
        jValorTotal.setText("");
        //
        jBtPesqProduto.setEnabled(!true);
        jQtdItem.setEnabled(!true);
        jValorUN.setEnabled(!true);
        jValorTotal.setEnabled(!true);
        //
        jBtNovoItem.setEnabled(true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        //   jBtAuditoriaItem.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        jBtImprimirTransferencia.setEnabled(true);
    }

    public void pegarSaldoEstoque(int idProd, String nomeLote, int codItem) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM LOTE_PRODUTOS_AC WHERE IdProd='" + idProd + "' AND Lote='" + nomeLote + "' AND IdItem='" + codItem + "'");
            conecta.rs.first();
            codProd = conecta.rs.getInt("IdProd");
            codEstoque = conecta.rs.getInt("IdItem");
            saldoEstoque = conecta.rs.getFloat("Qtd");
            loteEstoque = conecta.rs.getString("Lote");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    // SALDO DE LOTE ENFERMARIA
    public void pegarSaldoEstoqueEnfermaria(int idProd, String nomeLote, int codItem) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM LOTE_PRODUTOS_ENF WHERE IdProd='" + idProd + "'AND Lote='" + nomeLote + "'AND IdItem='" + codItem + "'");
            conecta.rs.first();
            codProd = conecta.rs.getInt("IdProd");
            codEstoque = conecta.rs.getInt("IdItem");
            saldoEstoqueEnf = conecta.rs.getFloat("Qtd");
            loteEstoqueEnf = conecta.rs.getString("Lote");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void preencherTabelaTransferencia(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Requisitante", "Observação"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1;
                // Formatar a data de emissão
                dataEmissao = conecta.rs.getString("DataLanc");
                String dia = dataEmissao.substring(8, 10);
                String mes = dataEmissao.substring(5, 7);
                String ano = dataEmissao.substring(0, 4);
                dataEmissao = dia + "/" + mes + "/" + ano;
                //
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdLanc"), dataEmissao, conecta.rs.getString("StatusLanc"), conecta.rs.getString("NomeFunc"), conecta.rs.getString("Observacao")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaTransferenciaProdutos.setModel(modelo);
        jTabelaTransferenciaProdutos.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaTransferenciaProdutos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaTransferenciaProdutos.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaTransferenciaProdutos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaTransferenciaProdutos.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaTransferenciaProdutos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaTransferenciaProdutos.getColumnModel().getColumn(3).setPreferredWidth(200);
        jTabelaTransferenciaProdutos.getColumnModel().getColumn(3).setResizable(false);
        jTabelaTransferenciaProdutos.getColumnModel().getColumn(4).setPreferredWidth(280);
        jTabelaTransferenciaProdutos.getColumnModel().getColumn(4).setResizable(false);
        jTabelaTransferenciaProdutos.getTableHeader().setReorderingAllowed(false);
        jTabelaTransferenciaProdutos.setAutoResizeMode(jTabelaTransferenciaProdutos.AUTO_RESIZE_OFF);
        jTabelaTransferenciaProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaTrans();
        conecta.desconecta();
    }

    public void alinharCamposTabelaTrans() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaTransferenciaProdutos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaTransferenciaProdutos.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaTransferenciaProdutos.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }

    public void limparTabelaTransferencia() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Requisitante", "Observação"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaTransferenciaProdutos.setModel(modelo);
        jTabelaTransferenciaProdutos.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaTransferenciaProdutos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaTransferenciaProdutos.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaTransferenciaProdutos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaTransferenciaProdutos.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaTransferenciaProdutos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaTransferenciaProdutos.getColumnModel().getColumn(3).setPreferredWidth(200);
        jTabelaTransferenciaProdutos.getColumnModel().getColumn(3).setResizable(false);
        jTabelaTransferenciaProdutos.getColumnModel().getColumn(4).setPreferredWidth(280);
        jTabelaTransferenciaProdutos.getColumnModel().getColumn(4).setResizable(false);
        jTabelaTransferenciaProdutos.getTableHeader().setReorderingAllowed(false);
        jTabelaTransferenciaProdutos.setAutoResizeMode(jTabelaTransferenciaProdutos.AUTO_RESIZE_OFF);
        jTabelaTransferenciaProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void preencherTabelaItens(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código ", "Descrição Produto", "Qtd.", "Lote", "Data Lote"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            count = 0;
            do {
                count = count + 1;
                qtdItem = conecta.rs.getFloat("QtdItem");
                DecimalFormat vi = new DecimalFormat("#,##0.00");
                String vqtdItem = vi.format(qtdItem);
                qtdItemTab = vqtdItem;
                //
                dataVcto = conecta.rs.getString("DataVencLote");
                String diac = dataVcto.substring(8, 10);
                String mesc = dataVcto.substring(5, 7);
                String anoc = dataVcto.substring(0, 4);
                dataVcto = diac + "/" + mesc + "/" + anoc;
                //
                jtotalItens.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela 
                dados.add(new Object[]{conecta.rs.getInt("IdItem"), conecta.rs.getInt("IdProd"), conecta.rs.getString("DescricaoProd"), qtdItemTab, conecta.rs.getString("Lote"), dataVcto});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaItensTransferencia.setModel(modelo);
        jTabelaItensTransferencia.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTabelaItensTransferencia.getColumnModel().getColumn(0).setResizable(false);
        jTabelaItensTransferencia.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTabelaItensTransferencia.getColumnModel().getColumn(1).setResizable(false);
        jTabelaItensTransferencia.getColumnModel().getColumn(2).setPreferredWidth(300);
        jTabelaItensTransferencia.getColumnModel().getColumn(2).setResizable(false);
        jTabelaItensTransferencia.getColumnModel().getColumn(3).setPreferredWidth(50);
        jTabelaItensTransferencia.getColumnModel().getColumn(3).setResizable(false);
        jTabelaItensTransferencia.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTabelaItensTransferencia.getColumnModel().getColumn(4).setResizable(false);
        jTabelaItensTransferencia.getColumnModel().getColumn(5).setPreferredWidth(80);
        jTabelaItensTransferencia.getColumnModel().getColumn(5).setResizable(false);
        jTabelaItensTransferencia.getTableHeader().setReorderingAllowed(false);
        jTabelaItensTransferencia.setAutoResizeMode(jTabelaItensTransferencia.AUTO_RESIZE_OFF);
        jTabelaItensTransferencia.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaItens();
        conecta.desconecta();
    }

    public void alinharCamposTabelaItens() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaItensTransferencia.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaItensTransferencia.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaItensTransferencia.getColumnModel().getColumn(3).setCellRenderer(direita);
        jTabelaItensTransferencia.getColumnModel().getColumn(4).setCellRenderer(direita);
        jTabelaItensTransferencia.getColumnModel().getColumn(5).setCellRenderer(centralizado);
    }

    public void limparTabelaItens() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código ", "Descrição Produto", "Qtd.", "Lote", "Data Lote"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaItensTransferencia.setModel(modelo);
        jTabelaItensTransferencia.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTabelaItensTransferencia.getColumnModel().getColumn(0).setResizable(false);
        jTabelaItensTransferencia.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTabelaItensTransferencia.getColumnModel().getColumn(1).setResizable(false);
        jTabelaItensTransferencia.getColumnModel().getColumn(2).setPreferredWidth(300);
        jTabelaItensTransferencia.getColumnModel().getColumn(2).setResizable(false);
        jTabelaItensTransferencia.getColumnModel().getColumn(3).setPreferredWidth(50);
        jTabelaItensTransferencia.getColumnModel().getColumn(3).setResizable(false);
        jTabelaItensTransferencia.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTabelaItensTransferencia.getColumnModel().getColumn(4).setResizable(false);
        jTabelaItensTransferencia.getColumnModel().getColumn(5).setPreferredWidth(80);
        jTabelaItensTransferencia.getColumnModel().getColumn(5).setResizable(false);
        jTabelaItensTransferencia.getTableHeader().setReorderingAllowed(false);
        jTabelaItensTransferencia.setAutoResizeMode(jTabelaItensTransferencia.AUTO_RESIZE_OFF);
        jTabelaItensTransferencia.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
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
}
