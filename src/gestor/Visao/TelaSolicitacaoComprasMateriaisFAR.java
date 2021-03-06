/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleAtualizaValorSolicitantes;
import gestor.Controle.ControleItensSolicitacaoMateriaisADM;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControleSolicitacaoComprasADM;
import gestor.Dao.ConexaoBancoDados;
import Utilitarios.LimiteDigitosSoNum;
import Utilitarios.ModeloTabela;
import gestor.Controle.ControleAcessoGeral;
import gestor.Modelo.CamposAcessos;
import gestor.Modelo.ItensSolicitacaoCompras;
import gestor.Modelo.ItensSolicitantesCompras;
import gestor.Modelo.LogSistema;
import gestor.Modelo.SolicitacaoComprasAC;
import gestor.Modelo.SolicitantesCompras;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloFarmacia.telaMovimentacaoSolicitacaoComprasManu_FAR;
import static gestor.Visao.TelaModuloFarmacia.telaMovimentacaoSolicitacaoComprasProd_FAR;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import java.awt.Color;
import java.sql.SQLException;
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
 * @author Ronaldo
 */
public class TelaSolicitacaoComprasMateriaisFAR extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    SolicitacaoComprasAC objSoliMat = new SolicitacaoComprasAC();
    ItensSolicitacaoCompras objItensCompra = new ItensSolicitacaoCompras();
    ControleSolicitacaoComprasADM control = new ControleSolicitacaoComprasADM();
    ControleItensSolicitacaoMateriaisADM controle = new ControleItensSolicitacaoMateriaisADM();
    //
    ControleAtualizaValorSolicitantes controleSAC = new ControleAtualizaValorSolicitantes();
    ItensSolicitantesCompras itensSolComp = new ItensSolicitantesCompras();
    SolicitantesCompras solComp = new SolicitantesCompras();
    //
    ControleAcessoGeral pPESQUISAR_acessos = new ControleAcessoGeral();
    CamposAcessos objCampos = new CamposAcessos();
    //           
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela = "Farmácia:Solicitação de Materiais:Manutenção";
    String nomeModuloTela2 = "Farmácia:Solicitação de Materiais:Produtos";
    //
    int flag;
    int acao;
    String dataInicial, dataFinal, dataEmissao, dataValidade;
    String dataEntrada;
    String statusMov;
    String horaMov;
    String dataModFinal;
    String statusProd = "Ativo";
    int count;
    public static double qtdItem = 0;
    public static String qtdItemTab;
    public static double qtdItemAnterior = 0; // SALDO ANTERIOR A SER CALCULADO SE FOR ALTERADO PELO USUARIO
    public static double novoSaldoAtual = 0; //SALDO CALCULADO APOS ALTERAR A QUANTIDADE DO ITEM
    int codProd;
    int codEstoque;
    float saldoEstoque;
    float estoqueAtual = 0;
    String loteEstoque;
    public static String idItem;
    String tipoOpercao = "S";
    String nomeOperacao = "Solicitação de Compras de Produtos/Medicamentos";
    double qtdEstoque = 0;
    String codSolicitacao;
    double valorUnitario = 0;
    float valorTotalItem = 0;
    double valorUnitario1 = 0;
    String valorUnitario2;
    double valorTotalItem2 = 0;
    String atendeSolicitacao = "Não";
    double valorTotalSoli = 0;
    String valorTotalSoli1;
    String valorTotalSoli2;
    double valorSolicitado = 0;
    //
    public static String codigoDepto;
    String codigoDEPTO;
    public static int tipoValor;
    double valorMAX = 0;
    String codFunc;
    double valorMaxIND = 0;
    double valorVTA = 0; // VALOR TOTAL ACUMULADO INDIVIDUAL
    double valorMaxGAC = 0; // VALOR DO GRUPO ACUMULADO
    Date dataGrupoInicial, dataGrupoFinal;
    Date dataIndInicial, dataIndFinal;
    //
    double valorAIL = 0; // VALOR ACUMULADO LIQUIDO.
    String modulo = "FAR";
    int valorAproado = 0;

    /**
     * Creates new form TelaSolicitacaoComprasMateriaisAC
     */
    public TelaSolicitacaoComprasMateriaisFAR() {
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jCodigoSolicitacao = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        jBtPesqCodigoReq = new javax.swing.JButton();
        jLabel72 = new javax.swing.JLabel();
        jDataPesqInicial = new com.toedter.calendar.JDateChooser();
        jLabel73 = new javax.swing.JLabel();
        jDataPesFinal = new com.toedter.calendar.JDateChooser();
        jBtPesqDatas = new javax.swing.JButton();
        jCheckBoxTodosReq = new javax.swing.JCheckBox();
        jLabel22 = new javax.swing.JLabel();
        jNomeSolicitante = new javax.swing.JTextField();
        jBtPesqNomeSolicitante = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTabelaSolicitacoes = new javax.swing.JTable();
        jPanel30 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jIdSol = new javax.swing.JTextField();
        jStatusSol = new javax.swing.JTextField();
        jDataSol = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jComboBoxSituacao = new javax.swing.JComboBox();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jObservacao = new javax.swing.JTextArea();
        jBtFinalizar = new javax.swing.JButton();
        jBtImpressaoSol = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jBtNovo = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jBtAuditoria = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel11 = new javax.swing.JPanel();
        jBtPesqFuncSol = new javax.swing.JButton();
        jNomeFuncSol = new javax.swing.JTextField();
        jMatriculaFuncSol = new javax.swing.JTextField();
        jDepartamentoFuncSol = new javax.swing.JTextField();
        jIdFuncSol = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jBtFuncLib = new javax.swing.JButton();
        jNomeFuncLib = new javax.swing.JTextField();
        jIdFuncLib = new javax.swing.JTextField();
        jDepartamentoFuncLib = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jIdLocalSol = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jBtPesqLocalSol = new javax.swing.JButton();
        jDescricaoLocalSol = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jValorSolicitado = new javax.swing.JFormattedTextField();
        jValorAprovado = new javax.swing.JFormattedTextField();
        jLabel25 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jCodProduto = new javax.swing.JTextField();
        jCodigoBarras = new javax.swing.JTextField();
        jDescricaoProduto = new javax.swing.JTextField();
        jComboBoxUnidade = new javax.swing.JComboBox();
        jQtdItem = new javax.swing.JFormattedTextField();
        jBtPesqProdSol = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jValorUnitarioItem = new javax.swing.JFormattedTextField();
        jValorTotalItem = new javax.swing.JFormattedTextField();
        jtotalItens = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jComboBoxAprovacao = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabelaItensSolicitacao = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jBtNovoItem = new javax.swing.JButton();
        jBtAlterarItem = new javax.swing.JButton();
        jBtExcluirItem = new javax.swing.JButton();
        jBtSalvarItem = new javax.swing.JButton();
        jBtCancelarItem = new javax.swing.JButton();
        jBtSairItem = new javax.swing.JButton();
        jBtAuditoriaItem = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Solicitação de Compras de Produtos {FAR} :::...");
        setPreferredSize(new java.awt.Dimension(511, 517));

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jCodigoSolicitacao.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodigoSolicitacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

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

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("Solicitante:");

        jNomeSolicitante.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqNomeSolicitante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqNomeSolicitante.setContentAreaFilled(false);
        jBtPesqNomeSolicitante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqNomeSolicitanteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel22)
                    .addComponent(jLabel72)
                    .addComponent(jLabel70))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(jLabel73)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDataPesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jCodigoSolicitacao, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqCodigoReq, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jCheckBoxTodosReq))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqDatas, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addComponent(jBtPesqNomeSolicitante, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jNomeSolicitante, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel70)
                    .addComponent(jCodigoSolicitacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqCodigoReq)
                    .addComponent(jCheckBoxTodosReq))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel72)
                    .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel73)
                    .addComponent(jDataPesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqDatas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtPesqNomeSolicitante)
                    .addComponent(jNomeSolicitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addGap(19, 19, 19))
        );

        jTabelaSolicitacoes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaSolicitacoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Dt. Sol.", "Status Sol.", "Solicitante", "Observação"
            }
        ));
        jTabelaSolicitacoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaSolicitacoesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTabelaSolicitacoes);
        if (jTabelaSolicitacoes.getColumnModel().getColumnCount() > 0) {
            jTabelaSolicitacoes.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaSolicitacoes.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaSolicitacoes.getColumnModel().getColumn(1).setMinWidth(80);
            jTabelaSolicitacoes.getColumnModel().getColumn(1).setMaxWidth(80);
            jTabelaSolicitacoes.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaSolicitacoes.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaSolicitacoes.getColumnModel().getColumn(3).setMinWidth(300);
            jTabelaSolicitacoes.getColumnModel().getColumn(3).setMaxWidth(300);
            jTabelaSolicitacoes.getColumnModel().getColumn(4).setMinWidth(380);
            jTabelaSolicitacoes.getColumnModel().getColumn(4).setMaxWidth(380);
        }

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
                    .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
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
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
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
        jLabel3.setText("Data");

        jIdSol.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdSol.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdSol.setEnabled(false);

        jStatusSol.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jStatusSol.setForeground(new java.awt.Color(153, 0, 153));
        jStatusSol.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jStatusSol.setDisabledTextColor(new java.awt.Color(153, 0, 153));
        jStatusSol.setEnabled(false);

        jDataSol.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataSol.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Situação");

        jComboBoxSituacao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxSituacao.setForeground(new java.awt.Color(204, 0, 0));
        jComboBoxSituacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pendente", "Liberada", "Cotando", "Pedido", "Concluído" }));
        jComboBoxSituacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxSituacao.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jIdSol, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jStatusSol, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jComboBoxSituacao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jDataSol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataSol, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jStatusSol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdSol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jComboBoxSituacao, jDataSol, jIdSol, jStatusSol});

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Observação", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        jObservacao.setColumns(20);
        jObservacao.setRows(5);
        jObservacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jObservacao.setEnabled(false);
        jScrollPane1.setViewportView(jObservacao);

        jBtFinalizar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtFinalizar.setForeground(new java.awt.Color(51, 153, 0));
        jBtFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/accept.png"))); // NOI18N
        jBtFinalizar.setText("Finalizar");
        jBtFinalizar.setEnabled(false);
        jBtFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFinalizarActionPerformed(evt);
            }
        });

        jBtImpressaoSol.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtImpressaoSol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/gtklp-icone-3770-16.png"))); // NOI18N
        jBtImpressaoSol.setText("Impressão");
        jBtImpressaoSol.setEnabled(false);
        jBtImpressaoSol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtImpressaoSolActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtFinalizar)
                    .addComponent(jBtImpressaoSol))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtFinalizar, jBtImpressaoSol});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jBtFinalizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtImpressaoSol)
                .addContainerGap(43, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtNovo)
                        .addComponent(jBtAlterar)
                        .addComponent(jBtExcluir)
                        .addComponent(jBtSalvar)
                        .addComponent(jBtCancelar)
                        .addComponent(jBtSair))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBtAuditoria)))
                .addContainerGap())
        );

        jTabbedPane2.setForeground(new java.awt.Color(0, 102, 0));
        jTabbedPane2.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jBtPesqFuncSol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqFuncSol.setContentAreaFilled(false);
        jBtPesqFuncSol.setEnabled(false);
        jBtPesqFuncSol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqFuncSolActionPerformed(evt);
            }
        });

        jNomeFuncSol.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeFuncSol.setEnabled(false);

        jMatriculaFuncSol.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jMatriculaFuncSol.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMatriculaFuncSol.setEnabled(false);

        jDepartamentoFuncSol.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDepartamentoFuncSol.setEnabled(false);

        jIdFuncSol.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdFuncSol.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdFuncSol.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Nome Completo do Solicitante");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Departamento");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Matricula");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Código");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(55, 55, 55))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jIdFuncSol, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqFuncSol, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jMatriculaFuncSol, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jDepartamentoFuncSol)))
                    .addComponent(jNomeFuncSol, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel5))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jDepartamentoFuncSol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jMatriculaFuncSol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqFuncSol)
                    .addComponent(jIdFuncSol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNomeFuncSol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Solicitante", jPanel11);

        jBtFuncLib.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtFuncLib.setContentAreaFilled(false);
        jBtFuncLib.setEnabled(false);
        jBtFuncLib.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFuncLibActionPerformed(evt);
            }
        });

        jNomeFuncLib.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeFuncLib.setEnabled(false);

        jIdFuncLib.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdFuncLib.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdFuncLib.setEnabled(false);

        jDepartamentoFuncLib.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDepartamentoFuncLib.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Nome Completo do Liberador");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Departamento");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Código");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jNomeFuncLib, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(61, 61, 61))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jIdFuncLib, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtFuncLib, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jDepartamentoFuncLib))))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDepartamentoFuncLib, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jIdFuncLib, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtFuncLib))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNomeFuncLib, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Liberador", jPanel12);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Descrição Local de Armazenamento");

        jIdLocalSol.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdLocalSol.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdLocalSol.setEnabled(false);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Código");

        jBtPesqLocalSol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqLocalSol.setContentAreaFilled(false);
        jBtPesqLocalSol.setEnabled(false);
        jBtPesqLocalSol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqLocalSolActionPerformed(evt);
            }
        });

        jDescricaoLocalSol.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDescricaoLocalSol.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel21)
                            .addGap(55, 55, 55))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jIdLocalSol, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jBtPesqLocalSol, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jDescricaoLocalSol, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jIdLocalSol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqLocalSol))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDescricaoLocalSol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Local Armazenamento", jPanel4);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(153, 0, 102));
        jLabel23.setText("Valor Solicitado R$:");

        jValorSolicitado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jValorSolicitado.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        jValorSolicitado.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jValorSolicitado.setEnabled(false);
        jValorSolicitado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jValorAprovado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jValorAprovado.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        jValorAprovado.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jValorAprovado.setEnabled(false);
        jValorAprovado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 153, 0));
        jLabel25.setText("Valor Aprovado R$:");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jValorSolicitado, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jValorAprovado, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jValorAprovado, jValorSolicitado});

        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jValorAprovado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(jValorSolicitado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Manutenção", jPanel2);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Código");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Código Barras");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Unidade");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Qtde.");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Descrição do Produto");

        jCodProduto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodProduto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCodProduto.setEnabled(false);

        jCodigoBarras.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodigoBarras.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCodigoBarras.setEnabled(false);
        jCodigoBarras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCodigoBarrasActionPerformed(evt);
            }
        });

        jDescricaoProduto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDescricaoProduto.setEnabled(false);

        jComboBoxUnidade.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxUnidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "UN", "Caixa", "Pacote", "Ml", "Kg", "Litro", "Peça", "Amp", "Kit", "PR", "Un" }));
        jComboBoxUnidade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxUnidade.setEnabled(false);

        jQtdItem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQtdItem.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jQtdItem.setEnabled(false);
        jQtdItem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jQtdItemFocusLost(evt);
            }
        });

        jBtPesqProdSol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqProdSol.setContentAreaFilled(false);
        jBtPesqProdSol.setEnabled(false);
        jBtPesqProdSol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqProdSolActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Vl. Unit.");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Vl. Total");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Itens");

        jValorUnitarioItem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jValorUnitarioItem.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jValorUnitarioItem.setEnabled(false);

        jValorTotalItem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jValorTotalItem.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jValorTotalItem.setEnabled(false);

        jtotalItens.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jtotalItens.setForeground(new java.awt.Color(255, 0, 0));
        jtotalItens.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setText("Status de Aprovação");

        jComboBoxAprovacao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxAprovacao.setForeground(new java.awt.Color(255, 0, 0));
        jComboBoxAprovacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Processando", "Aprovado", "Não Aprovado" }));
        jComboBoxAprovacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxAprovacao.setEnabled(false);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCodProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqProdSol, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jCodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxAprovacao, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel24)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jQtdItem, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jValorUnitarioItem, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(jValorTotalItem, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addComponent(jtotalItens, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jDescricaoProduto, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(20, 20, 20))))
        );

        jPanel9Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jValorTotalItem, jValorUnitarioItem});

        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(jLabel24)))
                .addGap(3, 3, 3)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxAprovacao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqProdSol)
                    .addComponent(jCodProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDescricaoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19))
                .addGap(3, 3, 3)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jQtdItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jValorUnitarioItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jValorTotalItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtotalItens, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jTabelaItensSolicitacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaItensSolicitacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Código", "Descrição Produto", "Qtd.", "Vl. Item", "Vl. Total"
            }
        ));
        jTabelaItensSolicitacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaItensSolicitacaoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTabelaItensSolicitacao);
        if (jTabelaItensSolicitacao.getColumnModel().getColumnCount() > 0) {
            jTabelaItensSolicitacao.getColumnModel().getColumn(0).setMinWidth(40);
            jTabelaItensSolicitacao.getColumnModel().getColumn(0).setMaxWidth(40);
            jTabelaItensSolicitacao.getColumnModel().getColumn(1).setMinWidth(50);
            jTabelaItensSolicitacao.getColumnModel().getColumn(1).setMaxWidth(50);
            jTabelaItensSolicitacao.getColumnModel().getColumn(2).setMinWidth(300);
            jTabelaItensSolicitacao.getColumnModel().getColumn(2).setMaxWidth(300);
            jTabelaItensSolicitacao.getColumnModel().getColumn(3).setMinWidth(50);
            jTabelaItensSolicitacao.getColumnModel().getColumn(3).setMaxWidth(50);
            jTabelaItensSolicitacao.getColumnModel().getColumn(4).setMinWidth(50);
            jTabelaItensSolicitacao.getColumnModel().getColumn(4).setMaxWidth(50);
            jTabelaItensSolicitacao.getColumnModel().getColumn(5).setMinWidth(80);
            jTabelaItensSolicitacao.getColumnModel().getColumn(5).setMaxWidth(80);
        }

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jBtNovoItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoItem.setText("Novo");
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

        jBtSairItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSairItem.setText("Sair");
        jBtSairItem.setContentAreaFilled(false);
        jBtSairItem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSairItem.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSairItem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSairItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairItemActionPerformed(evt);
            }
        });

        jBtAuditoriaItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaItem.setContentAreaFilled(false);
        jBtAuditoriaItem.setEnabled(false);
        jBtAuditoriaItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jBtNovoItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelarItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSairItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaItem, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtNovoItem)
                        .addComponent(jBtAlterarItem)
                        .addComponent(jBtExcluirItem)
                        .addComponent(jBtSalvarItem)
                        .addComponent(jBtCancelarItem)
                        .addComponent(jBtSairItem))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBtAuditoriaItem)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(13, 13, 13))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Produtos", jPanel7);

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

        setBounds(300, 30, 520, 517);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesqCodigoReqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqCodigoReqActionPerformed
        // TODO add your handling code here:
        if (jCodigoSolicitacao.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um código para pesquisa.");
        } else {
            pesquisarRequisicaoMateriais("SELECT * FROM SOLICITACAO_PRODUTOS_ADM "
                    + "INNER JOIN COLABORADOR "
                    + "ON SOLICITACAO_PRODUTOS_ADM.IdFunc=COLABORADOR.IdFunc "
                    + "INNER JOIN DEPARTAMENTOS "
                    + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                    + "INNER JOIN APROVADOR_SOLICITACAO_COMPRAS_AC "
                    + "ON SOLICITACAO_PRODUTOS_ADM.IdFuncAprova=APROVADOR_SOLICITACAO_COMPRAS_AC.IdFuncAprova "
                    + "INNER JOIN LOCAL_ARMAZENAMENTO_AC "
                    + "ON SOLICITACAO_PRODUTOS_ADM.IdLocal=LOCAL_ARMAZENAMENTO_AC.IdLocal "
                    + "WHERE SOLICITACAO_PRODUTOS_ADM.IdSol='" + jCodigoSolicitacao.getText() + "' "
                    + "AND SOLICITACAO_PRODUTOS_ADM.Modulo='" + modulo + "'");
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
                        SimpleDateFormat formatoAmerica = new SimpleDateFormat("yyyy/MM/dd");
                        dataInicial = formatoAmerica.format(jDataPesqInicial.getDate().getTime());
                        dataFinal = formatoAmerica.format(jDataPesFinal.getDate().getTime());
                        pesquisarRequisicaoMateriais("SELECT * FROM SOLICITACAO_PRODUTOS_ADM "
                                + "INNER JOIN COLABORADOR "
                                + "ON SOLICITACAO_PRODUTOS_ADM.IdFunc=COLABORADOR.IdFunc "
                                + "INNER JOIN DEPARTAMENTOS "
                                + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                                + "INNER JOIN APROVADOR_SOLICITACAO_COMPRAS_FAR "
                                + "ON SOLICITACAO_PRODUTOS_ADM.IdFuncAprova=APROVADOR_SOLICITACAO_COMPRAS_AC.IdFuncAprova "
                                + "INNER JOIN LOCAL_ARMAZENAMENTO_AC "
                                + "ON SOLICITACAO_PRODUTOS_ADM.IdLocal=LOCAL_ARMAZENAMENTO_AC.IdLocal "
                                + "WHERE DataSol BETWEEN'" + dataInicial + "'AND '" + dataFinal + "' "
                                + "AND SOLICITACAO_PRODUTOS_ADM.Modulo='" + modulo + "'");
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
                        pesquisarRequisicaoMateriais("SELECT * FROM SOLICITACAO_PRODUTOS_ADM "
                                + "INNER JOIN COLABORADOR "
                                + "ON SOLICITACAO_PRODUTOS_ADM.IdFunc=COLABORADOR.IdFunc "
                                + "INNER JOIN DEPARTAMENTOS "
                                + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                                + "INNER JOIN APROVADOR_SOLICITACAO_COMPRAS_FAR "
                                + "ON SOLICITACAO_PRODUTOS_ADM.IdFuncAprova=APROVADOR_SOLICITACAO_COMPRAS_AC.IdFuncAprova "
                                + "INNER JOIN LOCAL_ARMAZENAMENTO_AC "
                                + "ON SOLICITACAO_PRODUTOS_ADM.IdLocal=LOCAL_ARMAZENAMENTO_AC.IdLocal "
                                + "WHERE DataSol BETWEEN'" + dataInicial + "'AND '" + dataFinal + "' "
                                + "AND SOLICITACAO_PRODUTOS_ADM.Modulo='" + modulo + "'");
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
            this.pesquisarRequisicaoMateriais("SELECT * FROM SOLICITACAO_PRODUTOS_ADM "
                    + "INNER JOIN COLABORADOR "
                    + "ON SOLICITACAO_PRODUTOS_ADM.IdFunc=COLABORADOR.IdFunc "
                    + "INNER JOIN DEPARTAMENTOS "
                    + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                    + "INNER JOIN APROVADOR_SOLICITACAO_COMPRAS_AC "
                    + "ON SOLICITACAO_PRODUTOS_ADM.IdFuncAprova=APROVADOR_SOLICITACAO_COMPRAS_AC.IdFuncAprova "
                    + "INNER JOIN LOCAL_ARMAZENAMENTO_AC "
                    + "ON SOLICITACAO_PRODUTOS_ADM.IdLocal=LOCAL_ARMAZENAMENTO_AC.IdLocal "
                    + "WHERE SOLICITACAO_PRODUTOS_ADM.Modulo='" + modulo + "'");

        } else {
            jtotalRegistros.setText("");
            limparTabelaSolicitacao();
        }
    }//GEN-LAST:event_jCheckBoxTodosReqItemStateChanged

    private void jTabelaSolicitacoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaSolicitacoesMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String IdLanc = "" + jTabelaSolicitacoes.getValueAt(jTabelaSolicitacoes.getSelectedRow(), 0);
            jCodigoSolicitacao.setText(IdLanc);
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtImpressaoSol.setEnabled(true);
            jBtNovoItem.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            //
            jCodProduto.setText("");
            jCodigoBarras.setText("");
            jComboBoxAprovacao.setSelectedItem(null);
            jDescricaoProduto.setText("");
            jComboBoxUnidade.setSelectedItem(null);
            jQtdItem.setText("");
            jValorUnitarioItem.setText("");
            jComboBoxSituacao.removeAllItems();
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM SOLICITACAO_PRODUTOS_ADM "
                        + "INNER JOIN COLABORADOR "
                        + "ON SOLICITACAO_PRODUTOS_ADM.IdFunc=COLABORADOR.IdFunc "
                        + "INNER JOIN DEPARTAMENTOS "
                        + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                        + "INNER JOIN APROVADOR_SOLICITACAO_COMPRAS_AC "
                        + "ON SOLICITACAO_PRODUTOS_ADM.IdFuncAprova=APROVADOR_SOLICITACAO_COMPRAS_AC.IdFuncAprova "
                        + "INNER JOIN LOCAL_ARMAZENAMENTO_AC "
                        + "ON SOLICITACAO_PRODUTOS_ADM.IdLocal=LOCAL_ARMAZENAMENTO_AC.IdLocal "
                        + "WHERE SOLICITACAO_PRODUTOS_ADM.IdSol='" + IdLanc + "'");
                conecta.rs.first();
                jIdSol.setText(String.valueOf(conecta.rs.getInt("IdSol")));
                jComboBoxSituacao.addItem(conecta.rs.getString("Situacao"));
                jStatusSol.setText(conecta.rs.getString("StatusSol"));
                jDataSol.setDate(conecta.rs.getDate("DataSol"));
                jIdFuncSol.setText(conecta.rs.getString("IdFunc"));
                jMatriculaFuncSol.setText(conecta.rs.getString("MatriculaFunc"));
                jDepartamentoFuncSol.setText(conecta.rs.getString("NomeDepartamento"));
                jNomeFuncSol.setText(conecta.rs.getString("NomeFunc"));
                //
                jIdFuncLib.setText(String.valueOf(conecta.rs.getInt("IdFuncAprova")));
                // jMatriculaFuncLib.setText(conecta.rs.getString("matricula"));
                jDepartamentoFuncLib.setText(conecta.rs.getString("NomeDepartamento"));
                jNomeFuncLib.setText(conecta.rs.getString("NomeAprovador"));
                //
                jIdLocalSol.setText(conecta.rs.getString("IdLocal"));
                jDescricaoLocalSol.setText(conecta.rs.getString("DescricaoLocal"));
                jObservacao.setText(conecta.rs.getString("Observacao"));
                conecta.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "Não foi possível exibir registro.\nERRO: " + e);
            }
            count = 0;
            preencherTabelaItens("SELECT * FROM ITENS_SOLICITACAO_PRODUTOS_ADM "
                    + "INNER JOIN SOLICITACAO_PRODUTOS_ADM "
                    + "ON ITENS_SOLICITACAO_PRODUTOS_ADM.IdSol=SOLICITACAO_PRODUTOS_ADM.IdSol "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON ITENS_SOLICITACAO_PRODUTOS_ADM.IdProd=PRODUTOS_AC.IdProd "
                    + "WHERE ITENS_SOLICITACAO_PRODUTOS_ADM.IdSol='" + jIdSol.getText() + "'");
        }
    }//GEN-LAST:event_jTabelaSolicitacoesMouseClicked

    private void jBtPesqFuncSolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqFuncSolActionPerformed
        // TODO add your handling code here:
        TelaPesquisaColabordorSolicitacaoFAR objPesqColaSoli = new TelaPesquisaColabordorSolicitacaoFAR();
        TelaModuloFarmacia.jPainelFarmacia.add(objPesqColaSoli);
        objPesqColaSoli.show();
    }//GEN-LAST:event_jBtPesqFuncSolActionPerformed

    private void jBtFuncLibActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFuncLibActionPerformed
        // TODO add your handling code here:
        TelaPesquisaColabordorLiberadorFAR objPesqColaLib = new TelaPesquisaColabordorLiberadorFAR();
        TelaModuloFarmacia.jPainelFarmacia.add(objPesqColaLib);
        objPesqColaLib.show();
    }//GEN-LAST:event_jBtFuncLibActionPerformed

    private void jBtPesqLocalSolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqLocalSolActionPerformed
        // TODO add your handling code here:
        TelaPesqLocalArmazenamentoSolFAR objPesqLocalArmSol = new TelaPesqLocalArmazenamentoSolFAR();
        TelaModuloFarmacia.jPainelFarmacia.add(objPesqLocalArmSol);
        objPesqLocalArmSol.show();
    }//GEN-LAST:event_jBtPesqLocalSolActionPerformed

    private void jBtFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFinalizarActionPerformed
        // TODO add your handling code here:
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM SOLICITACAO_PRODUTOS_ADM WHERE IdSol='" + jIdSol.getText() + "'");
            conecta.rs.first();
            jStatusSol.setText(conecta.rs.getString("StatusSol"));
            if (jStatusSol.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Lançamento já foi finalizado");
            } else {
                Finalizar();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível verificar se lançamento foi finalizado\nERRO: " + ex);
        }
        conecta.desconecta();
    }//GEN-LAST:event_jBtFinalizarActionPerformed

    private void jBtImpressaoSolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImpressaoSolActionPerformed
        // TODO add your handling code here:
        if (jIdSol.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Não é possível listar a Requisição de Materiais.");
        } else {
            try {
                conecta.abrirConexao();
                String path = "reports/Almoxarifado/MateriaisCodigoSolicitacaoADM/SolicitacaoMateriaisCodigoSolicitacaoADM.jasper";
                conecta.executaSQL("SELECT * FROM SOLICITACAO_PRODUTOS_ADM "
                        + "INNER JOIN COLABORADOR "
                        + "ON SOLICITACAO_PRODUTOS_ADM.IdFunc=COLABORADOR.IdFunc "
                        + "INNER JOIN DEPARTAMENTOS "
                        + "ON COLABORADOR.IdDepartamento=COLABORADOR.IdDepartamento "
                        + "INNER JOIN APROVADOR_SOLICITACAO_COMPRAS_AC "
                        + "ON SOLICITACAO_PRODUTOS_ADM.IdFuncAprova=APROVADOR_SOLICITACAO_COMPRAS_AC.IdFuncAprova "
                        + "INNER JOIN LOCAL_ARMAZENAMENTO_AC "
                        + "ON SOLICITACAO_PRODUTOS_ADM.IdLocal=LOCAL_ARMAZENAMENTO_AC.IdLocal "
                        + "WHERE SOLICITACAO_PRODUTOS_ADM.IdSol='" + jIdSol.getText() + "'");
                HashMap parametros = new HashMap();
                parametros.put("CodigoSolicitacao", jIdSol.getText());
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
                jv.setTitle("Solicitação de Compras de Materiais");
                jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
                jv.toFront(); // Traz o relatorio para frente da aplicação            
                conecta.desconecta();
            } catch (JRException e) {
                JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
            }
        }
    }//GEN-LAST:event_jBtImpressaoSolActionPerformed

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        objCampos.setNomeUsuario(nameUser);
        objCampos.setNomeTelaAcesso(telaMovimentacaoSolicitacaoComprasManu_FAR);
        pPESQUISAR_acessos.pesquisarUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarGrupoUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarTelasAcesso(objCampos);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || objCampos.getNomeGrupo().equals("ADMINISTRADORES") || objCampos.getCodigoUsuario() == objCampos.getCodigoUsuarioAcesso() && objCampos.getNomeTelaAcesso().equals(telaMovimentacaoSolicitacaoComprasManu_FAR) && objCampos.getCodigoIncluir() == 1) {
            acao = 1;
            Novo();
            corCampos();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            limparTabelaItens();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        // TODO add your handling code here:
        objCampos.setNomeUsuario(nameUser);
        objCampos.setNomeTelaAcesso(telaMovimentacaoSolicitacaoComprasManu_FAR);
        pPESQUISAR_acessos.pesquisarUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarGrupoUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarTelasAcesso(objCampos);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || objCampos.getNomeGrupo().equals("ADMINISTRADORES") || objCampos.getCodigoUsuario() == objCampos.getCodigoUsuarioAcesso() && objCampos.getNomeTelaAcesso().equals(telaMovimentacaoSolicitacaoComprasManu_FAR) && objCampos.getCodigoAlterar() == 1) {
            objSoliMat.setStatusSol(jStatusSol.getText());
            if (jStatusSol.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser modificado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 2;
                Alterar();
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
        objCampos.setNomeTelaAcesso(telaMovimentacaoSolicitacaoComprasManu_FAR);
        pPESQUISAR_acessos.pesquisarUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarGrupoUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarTelasAcesso(objCampos);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || objCampos.getNomeGrupo().equals("ADMINISTRADORES") || objCampos.getCodigoUsuario() == objCampos.getCodigoUsuarioAcesso() && objCampos.getNomeTelaAcesso().equals(telaMovimentacaoSolicitacaoComprasManu_FAR) && objCampos.getCodigoGravar() == 1) {
            objSoliMat.setStatusSol(jStatusSol.getText());
            if (jStatusSol.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser modificado, o mesmo encontra-se FINALIZADO");
            } else {
                statusMov = "Excluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
                verificarItensRequisitados();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        if (jDataSol.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Informe a data da Solicitação de Materiais.");
        } else if (jIdFuncSol.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o solicitante do material.");
        } else if (jIdFuncLib.getText().equals("")
                || jDepartamentoFuncLib.getText().equals("")
                || jNomeFuncLib.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe os dados do liberador da solicitação.");
        } else if (jIdLocalSol.getText().equals("") || jDescricaoLocalSol.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe dos dados do local de armazenamento.");
        } else {
            objSoliMat.setStatusSol(jStatusSol.getText());
            objSoliMat.setSituacao((String) jComboBoxSituacao.getSelectedItem());
            objSoliMat.setTipoValor(tipoValor);
            objSoliMat.setDataSol(jDataSol.getDate());
            objSoliMat.setIdFunc(Integer.valueOf(jIdFuncSol.getText()));
            objSoliMat.setNomeColaborador(jNomeFuncSol.getText());
            objSoliMat.setNomeLiberador(jNomeFuncLib.getText());
            objSoliMat.setDescricaoLocal(jDescricaoLocalSol.getText());
            objSoliMat.setModulo(modulo);
            objSoliMat.setValorAprovado(valorAproado);
            objSoliMat.setObservacao(jObservacao.getText());
            //
            if (tipoValor == 0) { // SE O VALOR FOR INDIVIDUAL       
                pesquisaValorIndividualSOL(); // PESQUISAR VALOR INDIVIDUAL.   
                // SE A DATA DA SOLICITAÇÃO FOR ENTRE A DATA DO PERIODO
                if (jDataSol.getDate().after(dataIndInicial) && jDataSol.getDate().before(dataIndFinal)) {
                    if (acao == 1) {
                        objSoliMat.setUsuarioInsert(nameUser);
                        objSoliMat.setDataInsert(dataModFinal);
                        objSoliMat.setHorarioInsert(horaMov);
                        //
                        control.incluirSolicitacaoMaterialADM(objSoliMat);
                        buscarCodigo();
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                        Salvar();
                    }
                    if (acao == 2) {
                        objSoliMat.setUsuarioUp(nameUser);
                        objSoliMat.setDataUp(dataModFinal);
                        objSoliMat.setHorarioUp(horaMov);
                        //
                        objSoliMat.setIdSol(Integer.valueOf(jIdSol.getText()));
                        control.alterarSolicitacaoMaterialADM(objSoliMat);
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                        Salvar();
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Período de solicitação de compras expirado...");
                }
            } else if (tipoValor == 1) { // SE O VALOR FOR PARA GRUPO
                pesquisarValorGrupoSOL(); // PESQUISAR VALOR DO GRUPO.
                // SE A DATA DA SOLICITAÇÃO FOR ENTRE A DATA DO PERIODO
                if (jDataSol.getDate().after(dataGrupoInicial) && jDataSol.getDate().before(dataGrupoFinal)) {
                    if (acao == 1) {
                        objSoliMat.setUsuarioInsert(nameUser);
                        objSoliMat.setDataInsert(dataModFinal);
                        objSoliMat.setHorarioInsert(horaMov);
                        //
                        control.incluirSolicitacaoMaterialADM(objSoliMat);
                        buscarCodigo();
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                        Salvar();
                    }
                    if (acao == 2) {
                        objSoliMat.setUsuarioUp(nameUser);
                        objSoliMat.setDataUp(dataModFinal);
                        objSoliMat.setHorarioUp(horaMov);
                        //
                        objSoliMat.setIdSol(Integer.valueOf(jIdSol.getText()));
                        control.alterarSolicitacaoMaterialADM(objSoliMat);
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                        Salvar();
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Período de solicitação de compras expirado...");
                }
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

    private void jBtAuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaActionPerformed
        // TODO add your handling code here:
        TelaAuditoriasolicitacaoComprasFAR objAudSolComp = new TelaAuditoriasolicitacaoComprasFAR();
        TelaModuloFarmacia.jPainelFarmacia.add(objAudSolComp);
        objAudSolComp.show();
    }//GEN-LAST:event_jBtAuditoriaActionPerformed

    private void jBtPesqProdSolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqProdSolActionPerformed
        // TODO add your handling code here:
        TelaPesqProdutoSolicitacaoMateriaisFAR objPesqProdSol = new TelaPesqProdutoSolicitacaoMateriaisFAR();
        TelaModuloFarmacia.jPainelFarmacia.add(objPesqProdSol);
        objPesqProdSol.show();
    }//GEN-LAST:event_jBtPesqProdSolActionPerformed

    private void jCodigoBarrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCodigoBarrasActionPerformed
        // TODO add your handling code here:
        conecta.abrirConexao();
        conecta.executaSQL("SELECT * FROM PRODUTOS_AC "
                + "INNER JOIN LOCAL_ARMAZENAMENTO_AC "
                + "ON PRODUTOS_AC.IdLocal=LOCAL_ARMAZENAMENTO_AC.IdLocal "
                + "INNER JOIN LOTE_PRODUTOS_AC "
                + "ON PRODUTOS_AC.IdProd=LOTE_PRODUTOS_AC.IdProd "
                + "WHERE PRODUTOS_AC.CodigoBarra='" + jCodigoBarras.getText() + "'AND PRODUTOS_AC.StatusProd='" + statusProd + "'");
        try {
            if (conecta.rs.first()) {
                jCodProduto.setText(String.valueOf(conecta.rs.getInt("IdProd")));
                jDescricaoProduto.setText(conecta.rs.getString("DescricaoProd"));
                jCodigoBarras.setText(conecta.rs.getString("CodigoBarra"));
                jValorUnitarioItem.setText(conecta.rs.getString("ValorCompra"));
                jComboBoxUnidade.setSelectedItem(conecta.rs.getString("UnidadeProd"));
            } else {
                JOptionPane.showMessageDialog(rootPane, "Produto não cadastro.");
            }
        } catch (SQLException ex) {
        }
        conecta.desconecta();
    }//GEN-LAST:event_jCodigoBarrasActionPerformed

    private void jTabelaItensSolicitacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaItensSolicitacaoMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            String idProduto = "" + jTabelaItensSolicitacao.getValueAt(jTabelaItensSolicitacao.getSelectedRow(), 1);
            jCodProduto.setText(idProduto);
            String nomeProduto = "" + jTabelaItensSolicitacao.getValueAt(jTabelaItensSolicitacao.getSelectedRow(), 2);
            jDescricaoProduto.setText(nomeProduto);
            idItem = "" + jTabelaItensSolicitacao.getValueAt(jTabelaItensSolicitacao.getSelectedRow(), 0);
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
                conecta.executaSQL("SELECT * FROM ITENS_SOLICITACAO_PRODUTOS_ADM "
                        + "INNER JOIN PRODUTOS_AC "
                        + "ON ITENS_SOLICITACAO_PRODUTOS_ADM.IdProd=PRODUTOS_AC.IdProd "
                        + "INNER JOIN GRUPO_PRODUTOS_AC ON PRODUTOS_AC.IdGrupo=GRUPO_PRODUTOS_AC.IdGrupo "
                        + "WHERE ITENS_SOLICITACAO_PRODUTOS_ADM.IdSol='" + jIdSol.getText() + "'AND "
                        + "PRODUTOS_AC.DescricaoProd='" + jDescricaoProduto.getText() + "'AND "
                        + "ITENS_SOLICITACAO_PRODUTOS_ADM.IdItem='" + idItem + "'");
                conecta.rs.first();
                jCodProduto.setText(conecta.rs.getString("IdProd"));
                jDescricaoProduto.setText(conecta.rs.getString("DescricaoProd"));
                idItem = conecta.rs.getString("IdItem");
                jCodigoBarras.setText(conecta.rs.getString("CodigoBarra"));
                jComboBoxAprovacao.setSelectedItem(conecta.rs.getString("StatusAprovacao"));
                jComboBoxUnidade.setSelectedItem(conecta.rs.getString("UnidadeProd"));
                // PEGA QUANTIDADE PARA CALCULAR SE O USUARIO ALTERAR A QUANTIDADE.
                qtdItemAnterior = conecta.rs.getFloat("QtdItem");
                qtdItem = conecta.rs.getFloat("QtdItem");
                DecimalFormat vi = new DecimalFormat("#,##0.00");
                String vqtdItem = vi.format(qtdItem);
                jQtdItem.setText(vqtdItem);
                // Formata o valor para ser exibido na tela no formato BR
                valorUnitario = conecta.rs.getFloat("ValorUnitarioItem");
                DecimalFormat vu = new DecimalFormat("#,##0.00");
                String vlUnitario = vu.format(valorUnitario);
                jValorUnitarioItem.setText(vlUnitario);
                //
                valorTotalItem2 = conecta.rs.getFloat("ValorTotalItem");
                DecimalFormat vti = new DecimalFormat("#,##0.00");
                String vlTotalItem = vti.format(valorTotalItem2);
                jValorTotalItem.setText(vlTotalItem);
                //
                conecta.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "Não foi possível selecionar o registro.\nERRO: " + e);
            }
        }
    }//GEN-LAST:event_jTabelaItensSolicitacaoMouseClicked

    private void jBtNovoItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoItemActionPerformed
        // TODO add your handling code here:
        objCampos.setNomeUsuario(nameUser);
        objCampos.setNomeTelaAcesso(telaMovimentacaoSolicitacaoComprasProd_FAR);
        pPESQUISAR_acessos.pesquisarUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarGrupoUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarTelasAcesso(objCampos);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || objCampos.getNomeGrupo().equals("ADMINISTRADORES") || objCampos.getCodigoUsuario() == objCampos.getCodigoUsuarioAcesso() && objCampos.getNomeTelaAcesso().equals(telaMovimentacaoSolicitacaoComprasManu_FAR) && objCampos.getCodigoIncluir() == 1) {
            objSoliMat.setStatusSol(jStatusSol.getText());
            if (jStatusSol.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser modificado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 3;
                NovoItem();
                statusMov = "Incluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtNovoItemActionPerformed

    private void jBtAlterarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarItemActionPerformed
        // TODO add your handling code here:
        objCampos.setNomeUsuario(nameUser);
        objCampos.setNomeTelaAcesso(telaMovimentacaoSolicitacaoComprasProd_FAR);
        pPESQUISAR_acessos.pesquisarUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarGrupoUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarTelasAcesso(objCampos);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || objCampos.getNomeGrupo().equals("ADMINISTRADORES") || objCampos.getCodigoUsuario() == objCampos.getCodigoUsuarioAcesso() && objCampos.getNomeTelaAcesso().equals(telaMovimentacaoSolicitacaoComprasManu_FAR) && objCampos.getCodigoAlterar() == 1) {
            objSoliMat.setStatusSol(jStatusSol.getText());
            if (jStatusSol.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser modificado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 4;
                AlterarItem();
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtAlterarItemActionPerformed

    private void jBtExcluirItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirItemActionPerformed
        // TODO add your handling code here:
        objCampos.setNomeUsuario(nameUser);
        objCampos.setNomeTelaAcesso(telaMovimentacaoSolicitacaoComprasProd_FAR);
        pPESQUISAR_acessos.pesquisarUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarGrupoUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarTelasAcesso(objCampos);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || objCampos.getNomeGrupo().equals("ADMINISTRADORES") || objCampos.getCodigoUsuario() == objCampos.getCodigoUsuarioAcesso() && objCampos.getNomeTelaAcesso().equals(telaMovimentacaoSolicitacaoComprasManu_FAR) && objCampos.getCodigoExcluir() == 1) {
            objSoliMat.setStatusSol(jStatusSol.getText());
            if (jStatusSol.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser modificado, o mesmo encontra-se FINALIZADO");
            } else {
                statusMov = "Excluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
                if (tipoValor == 0) { // VALOR INDIVIDUAL
                    pesquisaValorIndividualSOL(); // PESQUISAR VALOR INDIVIDUAL.       
                    int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                            JOptionPane.YES_NO_OPTION);
                    if (resposta == JOptionPane.YES_OPTION) {
                        // CALCULA VALOR A SER GRAVADO                              
                        valorVTA = valorVTA + valorTotalItem2;
                        // FORMATA AS DATAS PARA GRAVAR NA TABELA ITENS_SOLICITANTES_COMPRAS O VALOR
                        SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
                        dataInicial = formatoAmerica.format(jDataSol.getDate().getTime());
                        dataFinal = formatoAmerica.format(jDataSol.getDate().getTime());
                        // GRAVAR NA TABELA "ITENS_SOLICITANTES_COMPRAS" O VALOR RETIRADO.
                        itensSolComp.setIdFunc(Integer.valueOf(jIdFuncSol.getText()));
                        itensSolComp.setDataInicialComp(dataInicial);
                        itensSolComp.setDataFinalComp(dataFinal);
                        itensSolComp.setValorVTA((float) valorVTA);
                        controleSAC.alterarValorAcumuladoSolicitanteIndividualAC(itensSolComp);
                        //
                        objItensCompra.setIdItem(Integer.valueOf(idItem));
                        controle.excluirItensSolicitacaoMaterialADM(objItensCompra);
                        JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                        ExcluirItem();
                        preencherTabelaItens("SELECT * FROM ITENS_SOLICITACAO_PRODUTOS_ADM "
                                + "INNER JOIN SOLICITACAO_PRODUTOS_ADM "
                                + "ON ITENS_SOLICITACAO_PRODUTOS_ADM.IdSol=SOLICITACAO_PRODUTOS_ADM.IdSol "
                                + "INNER JOIN PRODUTOS_AC "
                                + "ON ITENS_SOLICITACAO_PRODUTOS_ADM.IdProd=PRODUTOS_AC.IdProd "
                                + "WHERE ITENS_SOLICITACAO_PRODUTOS_ADM.IdSol='" + jIdSol.getText() + "'");
                    }
                } else if (tipoValor == 1) { // VALOR EM GRUPO
                    pesquisarValorGrupoSOL(); // PESQUISAR VALOR GRUPO.
                    int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                            JOptionPane.YES_NO_OPTION);
                    if (resposta == JOptionPane.YES_OPTION) {
                        // CALCULAR VALOR ACUMULADO COM A SAIDA DA SOLICITAÇÃO EM GRUPO
                        valorMaxGAC = valorMaxGAC + valorTotalItem2;
                        // FORMATA AS DATAS PARA GRAVAR NA TABELA ITENS_SOLICITANTES_COMPRAS O VALOR
                        SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
                        dataInicial = formatoAmerica.format(jDataSol.getDate().getTime());
                        dataFinal = formatoAmerica.format(jDataSol.getDate().getTime());
                        // GRAVAR NA TABELA "ITENS_SOLICITANTES_COMPRAS" O VALOR RETIRADO.                           
                        solComp.setIdDepartamento(Integer.valueOf(codigoDEPTO));
                        solComp.setTipoValor(tipoValor);
                        solComp.setDataInicialComp(dataInicial);
                        solComp.setDataFinalComp(dataFinal);
                        solComp.setValorMax((float) valorMaxGAC);
                        controleSAC.alterarValorAcumuladoSolicitanteGrupoAC(solComp);
                        //
                        objItensCompra.setIdItem(Integer.valueOf(idItem));
                        controle.excluirItensSolicitacaoMaterialADM(objItensCompra);
                        preencherTabelaItens("SELECT * FROM ITENS_SOLICITACAO_PRODUTOS_AC "
                                + "INNER JOIN SOLICITACAO_PRODUTOS_AC "
                                + "ON ITENS_SOLICITACAO_PRODUTOS_ADM.IdSol=SOLICITACAO_PRODUTOS_ADM.IdSol "
                                + "INNER JOIN PRODUTOS_AC "
                                + "ON ITENS_SOLICITACAO_PRODUTOS_ADM.IdProd=PRODUTOS_AC.IdProd "
                                + "WHERE ITENS_SOLICITACAO_PRODUTOS_ADM.IdSol='" + jIdSol.getText() + "'");
                        JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                        ExcluirItem();
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtExcluirItemActionPerformed

    private void jBtSalvarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarItemActionPerformed
        // TODO add your handling code here:
        objCampos.setNomeUsuario(nameUser);
        objCampos.setNomeTelaAcesso(telaMovimentacaoSolicitacaoComprasProd_FAR);
        pPESQUISAR_acessos.pesquisarUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarGrupoUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarTelasAcesso(objCampos);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || objCampos.getNomeGrupo().equals("ADMINISTRADORES") || objCampos.getCodigoUsuario() == objCampos.getCodigoUsuarioAcesso() && objCampos.getNomeTelaAcesso().equals(telaMovimentacaoSolicitacaoComprasManu_FAR) && objCampos.getCodigoGravar() == 1) {
            DecimalFormat qtdReal = new DecimalFormat("###,##00.0");
            qtdReal.setCurrency(Currency.getInstance(new Locale("pt", "BR")));
            if (jCodProduto.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o produto para solicitação.");
            } else if (jQtdItem.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe a quantidade");
            } else if (jCodigoBarras.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o código de barras do produto.");
            } else {
                objItensCompra.setIdProd(Integer.valueOf(jCodProduto.getText()));
                objItensCompra.setNomeProduto(jDescricaoProduto.getText());
                objItensCompra.setIdSol(Integer.valueOf(jIdSol.getText()));
                objItensCompra.setCodigoBarras(jCodigoBarras.getText());
                objItensCompra.setStatusAprovacao((String) jComboBoxAprovacao.getSelectedItem());
                objItensCompra.setUnidadeProd((String) jComboBoxUnidade.getSelectedItem());
                objItensCompra.setAprovaSolicitacao(atendeSolicitacao);
                objItensCompra.setValorTotalItem(valorTotalItem);
                if (tipoValor == 0) { // SE O VALOR FOR INDIVIDUAL    
                    pesquisaValorIndividualSOL(); // PESQUISAR VALOR INDIVIDUAL.     
                    // SE A DATA DA SOLICITAÇÃO FOR ENTRE A DATA DO PERIODO
                    if (jDataSol.getDate().after(dataIndInicial) && jDataSol.getDate().before(dataIndFinal)) {
                        // SE O VALOR SOLICITADO FOR MAIOR QUE O ACUMULADO.
                        if (objItensCompra.getValorTotalItem() <= valorVTA) {
                            if (acao == 3) {
                                objItensCompra.setUsuarioInsert(nameUser);
                                objItensCompra.setDataInsert(dataModFinal);
                                objItensCompra.setHorarioInsert(horaMov);
                                objItensCompra.setQtdItem(Float.valueOf(jQtdItem.getText()));
                                controle.incluirItensSolicitacaoMaterialADM(objItensCompra);
                                // CALCULA VALOR A SER GRAVADO
                                valorAIL = valorVTA;
                                valorAIL = valorAIL - objItensCompra.getValorTotalItem();
                                // FORMATA AS DATAS PARA GRAVAR NA TABELA ITENS_SOLICITANTES_COMPRAS O VALOR
                                SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
                                dataInicial = formatoAmerica.format(jDataSol.getDate().getTime());
                                dataFinal = formatoAmerica.format(jDataSol.getDate().getTime());
                                // GRAVAR NA TABELA "ITENS_SOLICITANTES_COMPRAS" O VALOR RETIRADO.
                                itensSolComp.setIdFunc(Integer.valueOf(jIdFuncSol.getText()));
                                itensSolComp.setDataInicialComp(dataInicial);
                                itensSolComp.setDataFinalComp(dataFinal);
                                itensSolComp.setValorVTA((float) valorAIL);
                                controleSAC.alterarValorAcumuladoSolicitanteIndividualAC(itensSolComp);
                                //
                                objLog2();
                                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação                            
                                preencherTabelaItens("SELECT * FROM ITENS_SOLICITACAO_PRODUTOS_ADM "
                                        + "INNER JOIN SOLICITACAO_PRODUTOS_ADM "
                                        + "ON ITENS_SOLICITACAO_PRODUTOS_ADM.IdSol=SOLICITACAO_PRODUTOS_ADM.IdSol "
                                        + "INNER JOIN PRODUTOS_AC "
                                        + "ON ITENS_SOLICITACAO_PRODUTOS_ADM.IdProd=PRODUTOS_AC.IdProd "
                                        + "WHERE ITENS_SOLICITACAO_PRODUTOS_ADM.IdSol='" + jIdSol.getText() + "'");
                                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                                SalvarItem();
                            }
                            if (acao == 4) {
                                objItensCompra.setUsuarioUp(nameUser);
                                objItensCompra.setDataUp(dataModFinal);
                                objItensCompra.setHorarioUp(horaMov);
                                objItensCompra.setIdProd(Integer.valueOf(jCodProduto.getText()));
                                try {
                                    objItensCompra.setQtdItem(qtdReal.parse(jQtdItem.getText()).floatValue());
                                    objItensCompra.setValorUnitarioItem(qtdReal.parse(jValorUnitarioItem.getText()).floatValue());
                                } catch (ParseException ex) {
                                }
                                objItensCompra.setIdItem(Integer.valueOf(idItem));
                                controle.alterarItensSolicitacaoMaterialADM(objItensCompra);
                                // CALCULA VALOR A SER GRAVADO
                                valorAIL = valorVTA;
                                valorAIL = (valorTotalItem2 + valorAIL) - objItensCompra.getValorTotalItem();
                                // FORMATA AS DATAS PARA GRAVAR NA TABELA ITENS_SOLICITANTES_COMPRAS O VALOR
                                SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
                                dataInicial = formatoAmerica.format(jDataSol.getDate().getTime());
                                dataFinal = formatoAmerica.format(jDataSol.getDate().getTime());
                                // GRAVAR NA TABELA "ITENS_SOLICITANTES_COMPRAS" O VALOR RETIRADO.
                                itensSolComp.setIdFunc(Integer.valueOf(jIdFuncSol.getText()));
                                itensSolComp.setDataInicialComp(dataInicial);
                                itensSolComp.setDataFinalComp(dataFinal);
                                itensSolComp.setValorVTA((float) valorAIL);
                                controleSAC.alterarValorAcumuladoSolicitanteIndividualAC(itensSolComp);
                                //
                                objLog2();
                                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                                preencherTabelaItens("SELECT * FROM ITENS_SOLICITACAO_PRODUTOS_ADM "
                                        + "INNER JOIN SOLICITACAO_PRODUTOS_ADM "
                                        + "ON ITENS_SOLICITACAO_PRODUTOS_ADM.IdSol=SOLICITACAO_PRODUTOS_ADM.IdSol "
                                        + "INNER JOIN PRODUTOS_AC "
                                        + "ON ITENS_SOLICITACAO_PRODUTOS_ADM.IdProd=PRODUTOS_AC.IdProd "
                                        + "WHERE ITENS_SOLICITACAO_PRODUTOS_ADM.IdSol='" + jIdSol.getText() + "'");
                                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                                SalvarItem();
                            }
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "O valor do produto solicitado é insuficiente para realizar compras.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Período de solicitação de compras expirado...");
                    }
                } else if (tipoValor == 1) { // VALOR EM GRUPO
                    pesquisarValorGrupoSOL(); // PESQUISAR VALOR GRUPO.
                    // SE A DATA DA SOLICITAÇÃO FOR ENTRE A DATA DO PERIODO
                    if (jDataSol.getDate().after(dataGrupoInicial) && jDataSol.getDate().before(dataGrupoFinal)) {
                        // SE O VALOR SOLICITADO FOR MAIOR QUE O ACUMULADO.
                        if (objItensCompra.getValorTotalItem() <= valorMaxGAC) {
                            if (acao == 3) {
                                objItensCompra.setUsuarioInsert(nameUser);
                                objItensCompra.setDataInsert(dataModFinal);
                                objItensCompra.setHorarioInsert(horaMov);
                                objItensCompra.setQtdItem(Float.valueOf(jQtdItem.getText()));
                                controle.incluirItensSolicitacaoMaterialADM(objItensCompra);
                                // CALCULAR VALOR ACUMULADO COM A SAIDA DA SOLICITAÇÃO EM GRUPO
                                valorMaxGAC = valorMaxGAC - objItensCompra.getValorTotalItem();
                                // FORMATA AS DATAS PARA GRAVAR NA TABELA ITENS_SOLICITANTES_COMPRAS O VALOR
                                SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
                                dataInicial = formatoAmerica.format(jDataSol.getDate().getTime());
                                dataFinal = formatoAmerica.format(jDataSol.getDate().getTime());
                                // GRAVAR NA TABELA "ITENS_SOLICITANTES_COMPRAS" O VALOR RETIRADO.                           
                                solComp.setIdDepartamento(Integer.valueOf(codigoDEPTO));
                                solComp.setTipoValor(tipoValor);
                                solComp.setDataInicialComp(dataInicial);
                                solComp.setDataFinalComp(dataFinal);
                                solComp.setValorMax((float) valorMaxGAC);
                                controleSAC.alterarValorAcumuladoSolicitanteGrupoAC(solComp);
                                //
                                objLog2();
                                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                                preencherTabelaItens("SELECT * FROM ITENS_SOLICITACAO_PRODUTOS_ADM "
                                        + "INNER JOIN SOLICITACAO_PRODUTOS_ADM "
                                        + "ON ITENS_SOLICITACAO_PRODUTOS_ADM.IdSol=SOLICITACAO_PRODUTOS_ADM.IdSol "
                                        + "INNER JOIN PRODUTOS_AC "
                                        + "ON ITENS_SOLICITACAO_PRODUTOS_ADM.IdProd=PRODUTOS_AC.IdProd "
                                        + "WHERE ITENS_SOLICITACAO_PRODUTOS_ADM.IdSol='" + jIdSol.getText() + "'");
                                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                                SalvarItem();
                            }
                            if (acao == 4) {
                                objItensCompra.setUsuarioUp(nameUser);
                                objItensCompra.setDataUp(dataModFinal);
                                objItensCompra.setHorarioUp(horaMov);
                                objItensCompra.setIdProd(Integer.valueOf(jCodProduto.getText()));
                                try {
                                    objItensCompra.setQtdItem(qtdReal.parse(jQtdItem.getText()).floatValue());
                                    objItensCompra.setValorUnitarioItem(qtdReal.parse(jValorUnitarioItem.getText()).floatValue());
                                } catch (ParseException ex) {
                                }
                                objItensCompra.setIdItem(Integer.valueOf(idItem));
                                controle.alterarItensSolicitacaoMaterialADM(objItensCompra);
                                // CALCULAR VALOR ACUMULADO COM A SAIDA DA SOLICITAÇÃO EM GRUPO
                                valorMaxGAC = (valorTotalItem2 + valorMaxGAC) - objItensCompra.getValorTotalItem();
                                // FORMATA AS DATAS PARA GRAVAR NA TABELA ITENS_SOLICITANTES_COMPRAS O VALOR
                                SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
                                dataInicial = formatoAmerica.format(jDataSol.getDate().getTime());
                                dataFinal = formatoAmerica.format(jDataSol.getDate().getTime());
                                // GRAVAR NA TABELA "ITENS_SOLICITANTES_COMPRAS" O VALOR RETIRADO.                           
                                solComp.setIdDepartamento(Integer.valueOf(codigoDEPTO));
                                solComp.setTipoValor(tipoValor);
                                solComp.setDataInicialComp(dataInicial);
                                solComp.setDataFinalComp(dataFinal);
                                solComp.setValorMax((float) valorMaxGAC);
                                controleSAC.alterarValorAcumuladoSolicitanteGrupoAC(solComp);
                                //
                                objLog2();
                                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                                preencherTabelaItens("SELECT * FROM ITENS_SOLICITACAO_PRODUTOS_ADM "
                                        + "INNER JOIN SOLICITACAO_PRODUTOS_ADM "
                                        + "ON ITENS_SOLICITACAO_PRODUTOS_ADM.IdSol=SOLICITACAO_PRODUTOS_ADM.IdSol "
                                        + "INNER JOIN PRODUTOS_AC "
                                        + "ON ITENS_SOLICITACAO_PRODUTOS_ADM.IdProd=PRODUTOS_AC.IdProd "
                                        + "WHERE ITENS_SOLICITACAO_PRODUTOS_ADM.IdSol='" + jIdSol.getText() + "'");
                                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                                SalvarItem();
                            }
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "O valor do produto solicitado é insuficiente para realizar compras.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Período de solicitação de compras expirado...");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtSalvarItemActionPerformed

    private void jBtCancelarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarItemActionPerformed
        // TODO add your handling code here:
        CancelarItem();
    }//GEN-LAST:event_jBtCancelarItemActionPerformed

    private void jBtSairItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairItemActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairItemActionPerformed

    private void jBtAuditoriaItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaItemActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaItensSolicitacaoComprasFAR objItensCompFAR = new TelaAuditoriaItensSolicitacaoComprasFAR();
        TelaModuloFarmacia.jPainelFarmacia.add(objItensCompFAR);
        objItensCompFAR.show();
    }//GEN-LAST:event_jBtAuditoriaItemActionPerformed

    private void jQtdItemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jQtdItemFocusLost
        // TODO add your handling code here:
        DecimalFormat qtdReal = new DecimalFormat("#,##00.0");
        qtdReal.setCurrency(Currency.getInstance(new Locale("pt", "BR")));
        try {
            objItensCompra.setQtdItem(qtdReal.parse(jQtdItem.getText()).floatValue());
            objItensCompra.setValorUnitarioItem(qtdReal.parse(jValorUnitarioItem.getText()).floatValue());
            objItensCompra.setValorTotalItem(qtdReal.parse(jValorTotalItem.getText()).floatValue());
        } catch (ParseException ex) {
        }
        valorTotalItem = objItensCompra.getQtdItem() * objItensCompra.getValorUnitarioItem();
        objItensCompra.setValorTotalItem(valorTotalItem);
        DecimalFormat vti = new DecimalFormat("#,##0.00");
        String vlTotalItem = vti.format(valorTotalItem);
        jValorTotalItem.setText(vlTotalItem);
    }//GEN-LAST:event_jQtdItemFocusLost

    private void jBtPesqNomeSolicitanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNomeSolicitanteActionPerformed
        // TODO add your handling code here:
        if (jNomeSolicitante.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o nome do solicitante para pesquisa.");
        } else {
            pesquisarRequisicaoMateriais("SELECT * FROM SOLICITACAO_PRODUTOS_ADM "
                    + "INNER JOIN COLABORADOR "
                    + "ON SOLICITACAO_PRODUTOS_ADM.IdFunc=COLABORADOR.IdFunc "
                    + "INNER JOIN DEPARTAMENTOS "
                    + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                    + "INNER JOIN APROVADOR_SOLICITACAO_COMPRAS_AC "
                    + "ON SOLICITACAO_PRODUTOS_ADM.IdFuncAprova=APROVADOR_SOLICITACAO_COMPRAS_AC.IdFuncAprova "
                    + "INNER JOIN LOCAL_ARMAZENAMENTO_AC "
                    + "ON SOLICITACAO_PRODUTOS_ADM.IdLocal=LOCAL_ARMAZENAMENTO_AC.IdLocal "
                    + "WHERE APROVADOR_SOLICITACAO_COMPRAS_AC.NomeAprovador LIKE'%" + jNomeSolicitante.getText() + "%' "
                    + "AND SOLICITACAO_PRODUTOS_ADM.Modulo='" + modulo + "'");
        }
    }//GEN-LAST:event_jBtPesqNomeSolicitanteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtAlterarItem;
    private javax.swing.JButton jBtAuditoria;
    private javax.swing.JButton jBtAuditoriaItem;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtCancelarItem;
    private javax.swing.JButton jBtExcluir;
    private javax.swing.JButton jBtExcluirItem;
    private javax.swing.JButton jBtFinalizar;
    private javax.swing.JButton jBtFuncLib;
    private javax.swing.JButton jBtImpressaoSol;
    private javax.swing.JButton jBtNovo;
    private javax.swing.JButton jBtNovoItem;
    private javax.swing.JButton jBtPesqCodigoReq;
    private javax.swing.JButton jBtPesqDatas;
    private javax.swing.JButton jBtPesqFuncSol;
    private javax.swing.JButton jBtPesqLocalSol;
    private javax.swing.JButton jBtPesqNomeSolicitante;
    private javax.swing.JButton jBtPesqProdSol;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSairItem;
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JButton jBtSalvarItem;
    private javax.swing.JCheckBox jCheckBoxTodosReq;
    public static javax.swing.JTextField jCodProduto;
    public static javax.swing.JTextField jCodigoBarras;
    private javax.swing.JTextField jCodigoSolicitacao;
    private javax.swing.JComboBox jComboBoxAprovacao;
    private javax.swing.JComboBox jComboBoxSituacao;
    public static javax.swing.JComboBox jComboBoxUnidade;
    private com.toedter.calendar.JDateChooser jDataPesFinal;
    private com.toedter.calendar.JDateChooser jDataPesqInicial;
    private com.toedter.calendar.JDateChooser jDataSol;
    public static javax.swing.JTextField jDepartamentoFuncLib;
    public static javax.swing.JTextField jDepartamentoFuncSol;
    public static javax.swing.JTextField jDescricaoLocalSol;
    public static javax.swing.JTextField jDescricaoProduto;
    public static javax.swing.JTextField jIdFuncLib;
    public static javax.swing.JTextField jIdFuncSol;
    public static javax.swing.JTextField jIdLocalSol;
    public static javax.swing.JTextField jIdSol;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JTextField jMatriculaFuncSol;
    public static javax.swing.JTextField jNomeFuncLib;
    public static javax.swing.JTextField jNomeFuncSol;
    private javax.swing.JTextField jNomeSolicitante;
    private javax.swing.JTextArea jObservacao;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JFormattedTextField jQtdItem;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jStatusSol;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTabelaItensSolicitacao;
    private javax.swing.JTable jTabelaSolicitacoes;
    private javax.swing.JFormattedTextField jValorAprovado;
    private javax.swing.JFormattedTextField jValorSolicitado;
    private javax.swing.JFormattedTextField jValorTotalItem;
    public static javax.swing.JFormattedTextField jValorUnitarioItem;
    private javax.swing.JLabel jtotalItens;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void formatarCampos() {
        jCodigoBarras.setDocument(new LimiteDigitosSoNum(13));
        jObservacao.setLineWrap(true);
        jObservacao.setWrapStyleWord(true);
        jValorSolicitado.setText("0,00");
        jValorAprovado.setText("0,00");
    }

    public void corCampos() {
        jIdSol.setBackground(Color.white);
        jStatusSol.setBackground(Color.white);
        jDataSol.setBackground(Color.white);
        jIdFuncSol.setBackground(Color.white);
        jMatriculaFuncSol.setBackground(Color.white);
        jDepartamentoFuncSol.setBackground(Color.white);
        jNomeFuncSol.setBackground(Color.white);
        //
        jIdFuncLib.setBackground(Color.white);
        jDepartamentoFuncLib.setBackground(Color.white);
        jNomeFuncLib.setBackground(Color.white);
        //
        jIdLocalSol.setBackground(Color.white);
        jObservacao.setBackground(Color.white);
        //
        jCodProduto.setBackground(Color.white);
        jCodigoBarras.setBackground(Color.white);
        jComboBoxAprovacao.setBackground(Color.white);
        jDescricaoProduto.setBackground(Color.white);
        jQtdItem.setBackground(Color.white);
        jValorUnitarioItem.setBackground(Color.white);
        jValorTotalItem.setBackground(Color.white);
    }

    public void Novo() {
        jIdSol.setText("");
        jComboBoxSituacao.setSelectedItem("Pendente");
        jStatusSol.setText("ABERTO");
        jDataSol.setCalendar(Calendar.getInstance());
        jIdFuncSol.setText("");
        jMatriculaFuncSol.setText("");
        jDepartamentoFuncSol.setText("");
        jNomeFuncSol.setText("");
        //
        jIdFuncLib.setText("");
        jDepartamentoFuncLib.setText("");
        jNomeFuncLib.setText("");
        jDescricaoLocalSol.setText("");
        //
        jIdLocalSol.setText("");
        jObservacao.setText("");
        jValorSolicitado.setText("0,00");
        jValorAprovado.setText("0,00");
        //
        jDataSol.setEnabled(true);
        jBtPesqFuncSol.setEnabled(true);
        jBtFuncLib.setEnabled(true);
        jBtPesqLocalSol.setEnabled(true);
        jObservacao.setEnabled(true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        jBtFinalizar.setEnabled(!true);
        jBtImpressaoSol.setEnabled(!true);
        //
        jBtNovoItem.setEnabled(!true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(true);
        jBtCancelarItem.setEnabled(true);
        jBtAuditoriaItem.setEnabled(true);
        //
        jCodProduto.setText("");
        jCodigoBarras.setText("");
        jComboBoxAprovacao.setSelectedItem(null);
        jDescricaoProduto.setText("");
        jComboBoxUnidade.setSelectedItem(null);
        jQtdItem.setText("");
        jValorUnitarioItem.setText("");
        jValorTotalItem.setText("");
        //
        jBtPesqProdSol.setEnabled(!true);
        jCodigoBarras.setEnabled(!true);
        jComboBoxUnidade.setEnabled(!true);
        jQtdItem.setEnabled(!true);
        jValorUnitarioItem.setEnabled(!true);
        jValorTotalItem.setEnabled(!true);
        limparTabelaItens();
        jtotalItens.setText("");
    }

    public void Alterar() {
        //
        jDataSol.setEnabled(true);
        jBtPesqFuncSol.setEnabled(true);
        jBtFuncLib.setEnabled(true);
        jBtPesqLocalSol.setEnabled(true);
        jObservacao.setEnabled(true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        jBtFinalizar.setEnabled(!true);
        //
        jBtNovoItem.setEnabled(!true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        jBtAuditoriaItem.setEnabled(!true);
        //
        jCodProduto.setText("");
        jCodigoBarras.setText("");
        jComboBoxAprovacao.setSelectedItem(null);
        jDescricaoProduto.setText("");
        jComboBoxUnidade.setSelectedItem(null);
        jQtdItem.setText("");
        jValorUnitarioItem.setText("");
        jValorTotalItem.setText("");
        //
        jBtPesqProdSol.setEnabled(!true);
        jCodigoBarras.setEnabled(!true);
        jComboBoxUnidade.setEnabled(!true);
        jQtdItem.setEnabled(!true);
        jValorUnitarioItem.setEnabled(!true);
        jValorTotalItem.setEnabled(!true);
    }

    public void Excluir() {
        jIdSol.setText("");
        jComboBoxSituacao.setSelectedItem(null);
        jStatusSol.setText("");
        jDataSol.setDate(null);
        jIdFuncSol.setText("");
        jMatriculaFuncSol.setText("");
        jDepartamentoFuncSol.setText("");
        jNomeFuncSol.setText("");
        //
        jIdFuncLib.setText("");
        jDepartamentoFuncLib.setText("");
        jNomeFuncLib.setText("");
        //
        jIdLocalSol.setText("");
        jObservacao.setText("");
        //
        jDataSol.setEnabled(!true);
        jBtPesqFuncSol.setEnabled(!true);
        jBtFuncLib.setEnabled(!true);
        jBtPesqLocalSol.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        //
        jBtNovoItem.setEnabled(!true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        jBtAuditoriaItem.setEnabled(!true);
        //
        jCodProduto.setText("");
        jCodigoBarras.setText("");
        jComboBoxAprovacao.setSelectedItem(null);
        jDescricaoProduto.setText("");
        jComboBoxUnidade.setSelectedItem(null);
        jQtdItem.setText("");
        jValorUnitarioItem.setText("");
        jValorTotalItem.setText("");
        //
        jBtPesqProdSol.setEnabled(!true);
        jCodigoBarras.setEnabled(!true);
        jComboBoxUnidade.setEnabled(!true);
        jQtdItem.setEnabled(!true);
        jValorUnitarioItem.setEnabled(!true);
        jValorTotalItem.setEnabled(!true);
    }

    public void Salvar() {
        jDataSol.setEnabled(!true);
        jBtPesqFuncSol.setEnabled(!true);
        jBtFuncLib.setEnabled(!true);
        jBtPesqLocalSol.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        //
        jBtNovoItem.setEnabled(true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        jBtAuditoriaItem.setEnabled(!true);
        //
    }

    public void Cancelar() {
        if (jIdSol.getText().equals("")) {
            jComboBoxSituacao.setSelectedItem(null);
            jStatusSol.setText("");
            jDataSol.setDate(null);
            jIdFuncSol.setText("");
            jMatriculaFuncSol.setText("");
            jDepartamentoFuncSol.setText("");
            jNomeFuncSol.setText("");
            //
            jIdFuncLib.setText("");
            jDepartamentoFuncLib.setText("");
            jNomeFuncLib.setText("");
            //
            jIdLocalSol.setText("");
            jObservacao.setText("");
            //
            jDataSol.setEnabled(!true);
            jBtPesqFuncSol.setEnabled(!true);
            jBtFuncLib.setEnabled(!true);
            jBtPesqLocalSol.setEnabled(!true);
            jObservacao.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtAuditoria.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
            //
            jBtNovoItem.setEnabled(!true);
        } else {
            //
            jDataSol.setEnabled(!true);
            jBtPesqFuncSol.setEnabled(!true);
            jBtFuncLib.setEnabled(!true);
            jBtPesqLocalSol.setEnabled(!true);
            jObservacao.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            //
            jBtNovoItem.setEnabled(true);
        }
    }

    public void Finalizar() {
        String statusLanc = "FINALIZADO";
        statusMov = "Finalizou";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        JOptionPane.showMessageDialog(rootPane, "Se esse Lançamento for finaliza,\nvocê não poderá mais excluir ou alterar.");
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente finalizar assim mesmo o lançamento selecionado?", "Confirmação",
                JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            objSoliMat.setStatusSol(statusLanc);
            objSoliMat.setIdSol(Integer.parseInt(jIdSol.getText()));
            control.finalizarSolicitacaoMaterialADM(objSoliMat);
            jStatusSol.setText("FINALIZADO");
            objLog();
            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
            JOptionPane.showMessageDialog(rootPane, "Registro FINALIZADO com sucesso !!!");
            //
            jDataSol.setEnabled(!true);
            jBtPesqFuncSol.setEnabled(!true);
            jBtFuncLib.setEnabled(!true);
            jBtPesqLocalSol.setEnabled(!true);
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
            jBtNovoItem.setEnabled(!true);
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
            conecta.executaSQL("SELECT * FROM SOLICITACAO_PRODUTOS_ADM");
            conecta.rs.last();
            jIdSol.setText(conecta.rs.getString("IdSol"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter o código da solicitação.");
        }
        conecta.desconecta();
    }

    public void verificarItensRequisitados() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENS_SOLICITACAO_PRODUTOS_ADM WHERE IdSol='" + objSoliMat.getIdSol() + "'");
            conecta.rs.first();
            codSolicitacao = conecta.rs.getString("IdSol");
            if (jIdSol.getText().equals(codSolicitacao)) {
                JOptionPane.showMessageDialog(rootPane, "Antes de excluir esse Lançamento, será necessário\nexcluir primeiro os itens relacionados a esse registro.");
            }
        } catch (SQLException ex) {
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o LANÇAMENTO selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objSoliMat.setIdSol(Integer.parseInt(jIdSol.getText()));
                control.excluirSolicitacaoMaterialADM(objSoliMat);
                objLog();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                Excluir();
            }
        }
    }

    public void NovoItem() {
        jCodProduto.setText("");
        jCodigoBarras.setText("");
        jComboBoxAprovacao.setSelectedItem("Processando");
        jDescricaoProduto.setText("");
        jComboBoxUnidade.setSelectedItem("Selecione");
        jQtdItem.setText("");
        jValorUnitarioItem.setText("");
        jValorTotalItem.setText("");
        //
        jBtPesqProdSol.setEnabled(true);
        jCodigoBarras.setEnabled(true);
        jComboBoxUnidade.setEnabled(true);
        jQtdItem.setEnabled(true);
        jValorUnitarioItem.setEnabled(true);
        jValorTotalItem.setEnabled(true);
        //
        jBtNovoItem.setEnabled(!true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(true);
        jBtCancelarItem.setEnabled(true);
        jBtAlterarItem.setEnabled(!true);
        //
        jDataSol.setEnabled(!true);
        jBtPesqFuncSol.setEnabled(!true);
        jBtFuncLib.setEnabled(!true);
        jBtPesqLocalSol.setEnabled(!true);
        jObservacao.setEnabled(!true);
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
        //
        jBtPesqProdSol.setEnabled(true);
        jCodigoBarras.setEnabled(true);
        jComboBoxUnidade.setEnabled(true);
        jQtdItem.setEnabled(true);
        jValorUnitarioItem.setEnabled(true);
        jValorTotalItem.setEnabled(true);
        //
        jBtNovoItem.setEnabled(!true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(true);
        jBtCancelarItem.setEnabled(true);
        jBtAlterarItem.setEnabled(!true);
        //
        jDataSol.setEnabled(!true);
        jBtPesqFuncSol.setEnabled(!true);
        jBtFuncLib.setEnabled(!true);
        jBtPesqLocalSol.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
    }

    public void ExcluirItem() {
        jCodProduto.setText("");
        jCodigoBarras.setText("");
        jComboBoxAprovacao.setSelectedItem(null);
        jDescricaoProduto.setText("");
        jComboBoxUnidade.setSelectedItem(null);
        jQtdItem.setText("");
        jValorUnitarioItem.setText("");
        jValorTotalItem.setText("");
        //
        jBtPesqProdSol.setEnabled(!true);
        jCodigoBarras.setEnabled(!true);
        jComboBoxUnidade.setEnabled(!true);
        jQtdItem.setEnabled(!true);
        jValorUnitarioItem.setEnabled(!true);
        jValorTotalItem.setEnabled(!true);
        //
        jBtNovoItem.setEnabled(true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        jBtAlterarItem.setEnabled(!true);
        //
        jDataSol.setEnabled(!true);
        jBtPesqFuncSol.setEnabled(!true);
        jBtFuncLib.setEnabled(!true);
        jBtPesqLocalSol.setEnabled(!true);
        jObservacao.setEnabled(!true);
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
        jCodProduto.setText("");
        jCodigoBarras.setText("");
        jComboBoxAprovacao.setSelectedItem(null);
        jDescricaoProduto.setText("");
        jComboBoxUnidade.setSelectedItem(null);
        jQtdItem.setText("");
        jValorUnitarioItem.setText("");
        jValorTotalItem.setText("");
        //
        jBtPesqProdSol.setEnabled(!true);
        jCodigoBarras.setEnabled(!true);
        jComboBoxUnidade.setEnabled(!true);
        jQtdItem.setEnabled(!true);
        jValorUnitarioItem.setEnabled(!true);
        jValorTotalItem.setEnabled(!true);
        //
        jBtNovoItem.setEnabled(true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        jBtAlterarItem.setEnabled(!true);
        //
        jDataSol.setEnabled(!true);
        jBtPesqFuncSol.setEnabled(!true);
        jBtFuncLib.setEnabled(!true);
        jBtPesqLocalSol.setEnabled(!true);
        jObservacao.setEnabled(!true);
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
        jCodProduto.setText("");
        jCodigoBarras.setText("");
        jComboBoxAprovacao.setSelectedItem(null);
        jDescricaoProduto.setText("");
        jComboBoxUnidade.setSelectedItem(null);
        jQtdItem.setText("");
        jValorUnitarioItem.setText("");
        jValorTotalItem.setText("");
        //
        jBtPesqProdSol.setEnabled(!true);
        jCodigoBarras.setEnabled(!true);
        jComboBoxUnidade.setEnabled(!true);
        jQtdItem.setEnabled(!true);
        jValorUnitarioItem.setEnabled(!true);
        jValorTotalItem.setEnabled(!true);
        //
        jBtNovoItem.setEnabled(true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        jBtAlterarItem.setEnabled(!true);
        //
        jDataSol.setEnabled(!true);
        jBtPesqFuncSol.setEnabled(!true);
        jBtFuncLib.setEnabled(!true);
        jBtPesqLocalSol.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
    }

    public void pesquisarValorGrupoSOL() {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM SOLICITANTES_COMPRAS WHERE IdDepartamento='" + codigoDepto + "'AND TipoValor='" + tipoValor + "'");
            conecta.rs.first();
            codigoDEPTO = conecta.rs.getString("IdDepartamento");
            tipoValor = conecta.rs.getInt("TipoValor");
            valorMaxGAC = conecta.rs.getFloat("ValorGAC");
            dataGrupoInicial = conecta.rs.getDate("DataInicial");
            dataGrupoFinal = conecta.rs.getDate("DataFinal");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void pesquisaValorIndividualSOL() {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENS_SOLICITANTES_COMPRAS WHERE IdFunc='" + jIdFuncSol.getText() + "'");
            conecta.rs.first();
            codFunc = conecta.rs.getString("IdFunc");
            valorMaxIND = conecta.rs.getFloat("ValorMax");
            valorVTA = conecta.rs.getFloat("ValorVTA");
            dataIndInicial = conecta.rs.getDate("DataInicial");
            dataIndFinal = conecta.rs.getDate("DataFinal");
        } catch (Exception e) {
        }
    }

    public void pesquisarRequisicaoMateriais(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Dt.Sol.", "Status Sol.", "Solicitante", "Aprovador", "Observação"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1;
                // Formatar a data de emissão
                dataEmissao = conecta.rs.getString("DataSol");
                String dia = dataEmissao.substring(8, 10);
                String mes = dataEmissao.substring(5, 7);
                String ano = dataEmissao.substring(0, 4);
                dataEmissao = dia + "/" + mes + "/" + ano;
                //
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdSol"), dataEmissao, conecta.rs.getString("StatusSol"), conecta.rs.getString("NomeFunc"), conecta.rs.getString("NomeAprovador"), conecta.rs.getString("Observacao")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaSolicitacoes.setModel(modelo);
        jTabelaSolicitacoes.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaSolicitacoes.getColumnModel().getColumn(0).setResizable(false);
        jTabelaSolicitacoes.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaSolicitacoes.getColumnModel().getColumn(1).setResizable(false);
        jTabelaSolicitacoes.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaSolicitacoes.getColumnModel().getColumn(2).setResizable(false);
        jTabelaSolicitacoes.getColumnModel().getColumn(3).setPreferredWidth(300);
        jTabelaSolicitacoes.getColumnModel().getColumn(3).setResizable(false);
        jTabelaSolicitacoes.getColumnModel().getColumn(4).setPreferredWidth(300);
        jTabelaSolicitacoes.getColumnModel().getColumn(4).setResizable(false);
        jTabelaSolicitacoes.getColumnModel().getColumn(5).setPreferredWidth(380);
        jTabelaSolicitacoes.getColumnModel().getColumn(5).setResizable(false);
        jTabelaSolicitacoes.getTableHeader().setReorderingAllowed(false);
        jTabelaSolicitacoes.setAutoResizeMode(jTabelaSolicitacoes.AUTO_RESIZE_OFF);
        jTabelaSolicitacoes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaSolicitacao();
        conecta.desconecta();
    }

    public void alinharCamposTabelaSolicitacao() {
        //
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaSolicitacoes.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaSolicitacoes.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaSolicitacoes.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }

    public void limparTabelaSolicitacao() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Dt.Sol.", "Status Sol.", "Solicitante", "Aprovador", "Observação"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaSolicitacoes.setModel(modelo);
        jTabelaSolicitacoes.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaSolicitacoes.getColumnModel().getColumn(0).setResizable(false);
        jTabelaSolicitacoes.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaSolicitacoes.getColumnModel().getColumn(1).setResizable(false);
        jTabelaSolicitacoes.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaSolicitacoes.getColumnModel().getColumn(2).setResizable(false);
        jTabelaSolicitacoes.getColumnModel().getColumn(3).setPreferredWidth(300);
        jTabelaSolicitacoes.getColumnModel().getColumn(3).setResizable(false);
        jTabelaSolicitacoes.getColumnModel().getColumn(4).setPreferredWidth(300);
        jTabelaSolicitacoes.getColumnModel().getColumn(4).setResizable(false);
        jTabelaSolicitacoes.getColumnModel().getColumn(5).setPreferredWidth(380);
        jTabelaSolicitacoes.getColumnModel().getColumn(5).setResizable(false);
        jTabelaSolicitacoes.getTableHeader().setReorderingAllowed(false);
        jTabelaSolicitacoes.setAutoResizeMode(jTabelaSolicitacoes.AUTO_RESIZE_OFF);
        jTabelaSolicitacoes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void preencherTabelaItens(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código", "Descrição Produto", "Qtd.", "Vl. Item", "Vl. Total"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            count = 0;
            valorSolicitado = 0;
            do {
                count = count + 1;
                qtdItem = conecta.rs.getFloat("QtdItem");
                DecimalFormat vi = new DecimalFormat("#,##0.00");
                String vqtdItem = vi.format(qtdItem);
                qtdItemTab = vqtdItem;
                //
                valorUnitario1 = conecta.rs.getFloat("ValorUnitarioItem");
                DecimalFormat vu1 = new DecimalFormat("#,##0.00");
                String valorUnitarioP = vu1.format(valorUnitario1);
                valorUnitario2 = valorUnitarioP;
                //
                valorTotalSoli = conecta.rs.getFloat("ValorTotalItem");
                DecimalFormat vut = new DecimalFormat("#,##0.00");
                String valorTotalP = vut.format(valorTotalSoli);
                valorTotalSoli1 = valorTotalP;
                //
                valorSolicitado = valorSolicitado + valorTotalSoli;
                DecimalFormat vus = new DecimalFormat("#,##0.00");
                String valorTotalS = vus.format(valorSolicitado);
                valorTotalSoli2 = valorTotalS;
                jValorSolicitado.setText(valorTotalSoli2);
                //                
                jtotalItens.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela 
                dados.add(new Object[]{conecta.rs.getInt("IdItem"), conecta.rs.getInt("IdProd"), conecta.rs.getString("DescricaoProd"), qtdItemTab, valorUnitario2, valorTotalSoli1});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaItensSolicitacao.setModel(modelo);
        jTabelaItensSolicitacao.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTabelaItensSolicitacao.getColumnModel().getColumn(0).setResizable(false);
        jTabelaItensSolicitacao.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTabelaItensSolicitacao.getColumnModel().getColumn(1).setResizable(false);
        jTabelaItensSolicitacao.getColumnModel().getColumn(2).setPreferredWidth(300);
        jTabelaItensSolicitacao.getColumnModel().getColumn(2).setResizable(false);
        jTabelaItensSolicitacao.getColumnModel().getColumn(3).setPreferredWidth(50);
        jTabelaItensSolicitacao.getColumnModel().getColumn(3).setResizable(false);
        jTabelaItensSolicitacao.getColumnModel().getColumn(4).setPreferredWidth(50);
        jTabelaItensSolicitacao.getColumnModel().getColumn(4).setResizable(false);
        jTabelaItensSolicitacao.getColumnModel().getColumn(5).setPreferredWidth(80);
        jTabelaItensSolicitacao.getColumnModel().getColumn(5).setResizable(false);
        jTabelaItensSolicitacao.getTableHeader().setReorderingAllowed(false);
        jTabelaItensSolicitacao.setAutoResizeMode(jTabelaItensSolicitacao.AUTO_RESIZE_OFF);
        jTabelaItensSolicitacao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposItensTabelaSolicitacao();
        conecta.desconecta();
    }

    public void alinharCamposItensTabelaSolicitacao() {
        //
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaItensSolicitacao.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaItensSolicitacao.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaItensSolicitacao.getColumnModel().getColumn(3).setCellRenderer(direita);
        jTabelaItensSolicitacao.getColumnModel().getColumn(4).setCellRenderer(direita);
        jTabelaItensSolicitacao.getColumnModel().getColumn(5).setCellRenderer(direita);
    }

    public void limparTabelaItens() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código", "Descrição Produto", "Qtd.", "Vl. Item", "Vl. Total"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaItensSolicitacao.setModel(modelo);
        jTabelaItensSolicitacao.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTabelaItensSolicitacao.getColumnModel().getColumn(0).setResizable(false);
        jTabelaItensSolicitacao.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTabelaItensSolicitacao.getColumnModel().getColumn(1).setResizable(false);
        jTabelaItensSolicitacao.getColumnModel().getColumn(2).setPreferredWidth(300);
        jTabelaItensSolicitacao.getColumnModel().getColumn(2).setResizable(false);
        jTabelaItensSolicitacao.getColumnModel().getColumn(3).setPreferredWidth(50);
        jTabelaItensSolicitacao.getColumnModel().getColumn(3).setResizable(false);
        jTabelaItensSolicitacao.getColumnModel().getColumn(4).setPreferredWidth(50);
        jTabelaItensSolicitacao.getColumnModel().getColumn(4).setResizable(false);
        jTabelaItensSolicitacao.getColumnModel().getColumn(5).setPreferredWidth(80);
        jTabelaItensSolicitacao.getColumnModel().getColumn(5).setResizable(false);
        jTabelaItensSolicitacao.getTableHeader().setReorderingAllowed(false);
        jTabelaItensSolicitacao.setAutoResizeMode(jTabelaItensSolicitacao.AUTO_RESIZE_OFF);
        jTabelaItensSolicitacao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jIdSol.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog2() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela2);
        objLogSys.setIdLancMov(Integer.valueOf(jIdSol.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }
}
