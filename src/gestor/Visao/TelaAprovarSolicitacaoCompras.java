/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleAprovaSolicitacaoCompra;
import gestor.Controle.ControleItensSolicitacaoMateriaisADM;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControleSolicitacaoComprasADM;
import gestor.Dao.ConexaoBancoDados;
import Utilitarios.ModeloTabela;
import gestor.Modelo.AprovarSolicitacaoCompras;
import gestor.Modelo.ItensAprovacaoSolicitacaoCompras;
import gestor.Modelo.ItensSolicitacaoCompraADM;
import gestor.Modelo.ItensSolicitacaoCompras;
import gestor.Modelo.LogSistema;
import gestor.Modelo.SolicitacaoComprasAC;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloAdmPessoal.codAbrirADM;
import static gestor.Visao.TelaModuloAdmPessoal.codAlterarADM;
import static gestor.Visao.TelaModuloAdmPessoal.codConsultarADM;
import static gestor.Visao.TelaModuloAdmPessoal.codExcluirADM;
import static gestor.Visao.TelaModuloAdmPessoal.codGravarADM;
import static gestor.Visao.TelaModuloAdmPessoal.codIncluirADM;
import static gestor.Visao.TelaModuloAdmPessoal.codUserAcessoADM;
import static gestor.Visao.TelaModuloAdmPessoal.codigoGrupoADM;
import static gestor.Visao.TelaModuloAdmPessoal.codigoUserADM;
import static gestor.Visao.TelaModuloAdmPessoal.codigoUserGroupADM;
import static gestor.Visao.TelaModuloAdmPessoal.nomeGrupoADM;
import static gestor.Visao.TelaModuloAdmPessoal.nomeTelaADM;
import static gestor.Visao.TelaModuloAdmPessoal.telaAprovadorSC_ADM;
import static gestor.Visao.TelaModuloAdmPessoal.telaAprovarItensSC_ADM;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import java.awt.Color;
import java.sql.PreparedStatement;
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
 * @author ronaldo
 */
public class TelaAprovarSolicitacaoCompras extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AprovarSolicitacaoCompras objAprovaSol = new AprovarSolicitacaoCompras();
    ControleAprovaSolicitacaoCompra control = new ControleAprovaSolicitacaoCompra();
    ItensSolicitacaoCompraADM objItensSolComp = new ItensSolicitacaoCompraADM();
    ItensAprovacaoSolicitacaoCompras objItensAprovaSol = new ItensAprovacaoSolicitacaoCompras();
    //
    SolicitacaoComprasAC objSoliMat = new SolicitacaoComprasAC();
    ItensSolicitacaoCompras objItensCompra = new ItensSolicitacaoCompras();
    // ATUALIZAR TABELA DE SOLICITAÇÃO DE COMPRAS
    ControleSolicitacaoComprasADM controlSol = new ControleSolicitacaoComprasADM();
    // ATUALIZAR ITENS DA SOLICITAÇÃO DE COMPRAS
    ControleItensSolicitacaoMateriaisADM controle = new ControleItensSolicitacaoMateriaisADM();
    //          
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela = "Administração:Aprovação de Solicitação Compras:Manutenção";
    String nomeModuloTela2 = "Administração:Aprovação Solicitação de Materiais:Produtos";
    String nomeModuloTela3 = "Administração:Aprovação Solicitação de Materiais:Exclusão:Produtos";
    //
    int acao, flag;
    String dataInicial, dataFinal, dataEmissao, dataValidade;
    String dataEntrada;
    String statusMov;
    String horaMov;
    String dataModFinal;
    String codSolicitacao;
    double valorUnitario = 0;
    float valorTotalItem = 0;
    double valorUnitario1 = 0;
    String valorUnitario2;
    double valorTotalItem2 = 0;
    int count;
    public static double qtdItem = 0;
    public static String qtdItemTab;
    String nomeAprovador;
    String modulo = "ADM";
    //
    public static double valorSolicitado = 0;
    public static double valorAprovado = 0;
    //
    double valorTotalSoli = 0;
    String valorTotalSoli1;
    String valorTotalSoli2;
    //
    Date date = null;
    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    //
    String statusAprovacao = "Aprovado Total";
    String aprovaSolicitacao = "Sim";
    String situacaoSoliticacao = "Liberada";
    //
    public static int acaoAlt;
    public static int linhaSelecionada;
    public static int idProduto;
    //
    int codigoAprovador;
    int codigoProdutoAprovado;
    float valorAprovacaoSolicitacao;
    float valorSaldoTotalCompras = 0;
    float valorSaldoTotalComprasAlt = 0;
    //
    /**
     * Creates new form TelaAprovarSolicitacaoCompras
     */
    public static TelaItensSolicitacaoCompras itensSolicitacao;

    public TelaAprovarSolicitacaoCompras() {
        super();
        initComponents();
        setResizable(false);
        //  preencherComboDepartamentos();
        corCampos();
    }

    public void mostrarItensSolicitacao() {
        itensSolicitacao = new TelaItensSolicitacaoCompras(this, true);
        itensSolicitacao.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jIdPesqSol = new javax.swing.JTextField();
        jBtPesqCodigo = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jDataPesqInicial = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jDataPesFinal = new com.toedter.calendar.JDateChooser();
        jBtPesqData = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPesqNomeSolicitante = new javax.swing.JTextField();
        jBtPesqNomeSolicitante = new javax.swing.JButton();
        jCheckBoxTodos = new javax.swing.JCheckBox();
        jComboBoxDepartamentos = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaAprovacao = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jDataSolicitacao = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        jIdLocal = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jBtPesquisarSolicitacao = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jIdSolicitacao = new javax.swing.JTextField();
        jIdSolicitante = new javax.swing.JTextField();
        jDescricaoDepartamento = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jNomeSolicitante = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jValorTotalSolicitacao = new javax.swing.JFormattedTextField();
        jLabel18 = new javax.swing.JLabel();
        jValorTotalAprovado = new javax.swing.JFormattedTextField();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jObservacao = new javax.swing.JTextArea();
        jPanel12 = new javax.swing.JPanel();
        jDataAprova = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jStatusAprova = new javax.swing.JTextField();
        jIdAprova = new javax.swing.JTextField();
        jUsuarioAprovador = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jBtNovo = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jBtAuditoria = new javax.swing.JButton();
        jBtFinalizar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jBtAdcionarItensSoli = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jBtExcluirProdutoSolicitacao = new javax.swing.JButton();
        jBtImprimirSolicitacaoAprovada = new javax.swing.JButton();
        jBtAprovacaoTotal = new javax.swing.JButton();
        jBtAlterarItens = new javax.swing.JButton();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTabelaItensSolicitacao = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTabelaItensAprovado = new javax.swing.JTable();

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jButton3.setContentAreaFilled(false);

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Aprovação de Solicitação de Compras :::...");
        setToolTipText("");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código:");

        jIdPesqSol.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdPesqSol.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqCodigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqCodigo.setContentAreaFilled(false);
        jBtPesqCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqCodigoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Data Inicial:");

        jDataPesqInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Data Final:");

        jDataPesFinal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqData.setContentAreaFilled(false);
        jBtPesqData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqDataActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Aprovador:");

        jPesqNomeSolicitante.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqNomeSolicitante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqNomeSolicitante.setContentAreaFilled(false);
        jBtPesqNomeSolicitante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqNomeSolicitanteActionPerformed(evt);
            }
        });

        jCheckBoxTodos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxTodos.setText("Todos");
        jCheckBoxTodos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxTodosItemStateChanged(evt);
            }
        });

        jComboBoxDepartamentos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDepartamentos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Departamento:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jPesqNomeSolicitante)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jBtPesqNomeSolicitante, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jBtPesqData, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jDataPesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(33, 33, 33))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jIdPesqSol, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jComboBoxDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jCheckBoxTodos)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(jIdPesqSol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtPesqData, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataPesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4)
                    .addComponent(jPesqNomeSolicitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqNomeSolicitante, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jCheckBoxTodos)
                    .addComponent(jComboBoxDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel32.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jtotalRegistros.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtotalRegistros, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
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

        jTabelaAprovacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaAprovacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Data Sol.", "Status Sol.", "Código Sol.", "Aprovador", "Observação"
            }
        ));
        jTabelaAprovacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaAprovacaoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaAprovacao);
        if (jTabelaAprovacao.getColumnModel().getColumnCount() > 0) {
            jTabelaAprovacao.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaAprovacao.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaAprovacao.getColumnModel().getColumn(1).setMinWidth(80);
            jTabelaAprovacao.getColumnModel().getColumn(1).setMaxWidth(80);
            jTabelaAprovacao.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaAprovacao.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaAprovacao.getColumnModel().getColumn(3).setMinWidth(70);
            jTabelaAprovacao.getColumnModel().getColumn(3).setMaxWidth(70);
            jTabelaAprovacao.getColumnModel().getColumn(4).setMinWidth(250);
            jTabelaAprovacao.getColumnModel().getColumn(4).setMaxWidth(250);
            jTabelaAprovacao.getColumnModel().getColumn(5).setMinWidth(250);
            jTabelaAprovacao.getColumnModel().getColumn(5).setMaxWidth(250);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("Listagem", jPanel2);

        jTabbedPane2.setForeground(new java.awt.Color(255, 51, 51));
        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jDataSolicitacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataSolicitacao.setToolTipText("Daa da Solicitação");
        jDataSolicitacao.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Data Sol");

        jIdLocal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdLocal.setToolTipText("Local de Armazenamento");
        jIdLocal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdLocal.setEnabled(false);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Departamento");

        jBtPesquisarSolicitacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesquisarSolicitacao.setToolTipText("Pesquisar Solicitação");
        jBtPesquisarSolicitacao.setContentAreaFilled(false);
        jBtPesquisarSolicitacao.setEnabled(false);
        jBtPesquisarSolicitacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisarSolicitacaoActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Local");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Código");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Código Sol");

        jIdSolicitacao.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdSolicitacao.setToolTipText("Código da Solicitação");
        jIdSolicitacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdSolicitacao.setEnabled(false);

        jIdSolicitante.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdSolicitante.setToolTipText("Código do Solicitante");
        jIdSolicitante.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdSolicitante.setEnabled(false);

        jDescricaoDepartamento.setToolTipText("Departamento");
        jDescricaoDepartamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDescricaoDepartamento.setEnabled(false);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Solicitante");

        jNomeSolicitante.setToolTipText("Nome do Solicitante");
        jNomeSolicitante.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeSolicitante.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 51));
        jLabel5.setText("Vl. Solicitado");

        jValorTotalSolicitacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jValorTotalSolicitacao.setForeground(new java.awt.Color(51, 153, 0));
        jValorTotalSolicitacao.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jValorTotalSolicitacao.setToolTipText("Valor Total da Solicitação");
        jValorTotalSolicitacao.setCaretColor(new java.awt.Color(51, 153, 0));
        jValorTotalSolicitacao.setDisabledTextColor(new java.awt.Color(51, 153, 0));
        jValorTotalSolicitacao.setEnabled(false);
        jValorTotalSolicitacao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 51, 51));
        jLabel18.setText("Vl. Aprovado");

        jValorTotalAprovado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jValorTotalAprovado.setForeground(new java.awt.Color(255, 51, 51));
        jValorTotalAprovado.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jValorTotalAprovado.setToolTipText("Valor Total Aprovado");
        jValorTotalAprovado.setCaretColor(new java.awt.Color(255, 51, 51));
        jValorTotalAprovado.setDisabledTextColor(new java.awt.Color(255, 51, 51));
        jValorTotalAprovado.setEnabled(false);
        jValorTotalAprovado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdSolicitante, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel19)
                        .addComponent(jIdSolicitacao, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jDataSolicitacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jIdLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jDescricaoDepartamento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesquisarSolicitacao, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                                .addGap(32, 32, 32))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jNomeSolicitante)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jValorTotalSolicitacao, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jValorTotalAprovado, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)))
                .addContainerGap())
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jIdLocal, jIdSolicitacao});

        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12))
                        .addGap(7, 7, 7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIdSolicitacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataSolicitacao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDescricaoDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesquisarSolicitacao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIdSolicitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNomeSolicitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jValorTotalSolicitacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jValorTotalAprovado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );

        jTabbedPane2.addTab("Solicitação", jPanel8);

        jObservacao.setColumns(20);
        jObservacao.setRows(5);
        jObservacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jObservacao.setEnabled(false);
        jScrollPane4.setViewportView(jObservacao);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Observação", jPanel9);

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jDataAprova.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataAprova.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Data:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Código:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Status:");

        jStatusAprova.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jStatusAprova.setForeground(new java.awt.Color(153, 0, 102));
        jStatusAprova.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jStatusAprova.setDisabledTextColor(new java.awt.Color(153, 0, 102));
        jStatusAprova.setEnabled(false);

        jIdAprova.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdAprova.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdAprova.setEnabled(false);

        jUsuarioAprovador.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jUsuarioAprovador.setToolTipText("Usuário Aprovador");
        jUsuarioAprovador.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jUsuarioAprovador.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jUsuarioAprovador.setEnabled(false);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Aprovador:");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jIdAprova, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jStatusAprova)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataAprova, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jUsuarioAprovador))
                .addGap(31, 31, 31))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel8)
                    .addComponent(jIdAprova, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jStatusAprova, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jDataAprova, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jUsuarioAprovador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jBtNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_white_star.png"))); // NOI18N
        jBtNovo.setToolTipText("Nova Aprovação");
        jBtNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoActionPerformed(evt);
            }
        });

        jBtAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterar.setToolTipText("Alterar Aprovação");
        jBtAlterar.setEnabled(false);
        jBtAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarActionPerformed(evt);
            }
        });

        jBtExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluir.setToolTipText("Excluir Aprovação");
        jBtExcluir.setEnabled(false);
        jBtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirActionPerformed(evt);
            }
        });

        jBtSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvar.setToolTipText("Gravar Aprovação");
        jBtSalvar.setEnabled(false);
        jBtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarActionPerformed(evt);
            }
        });

        jBtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelar.setToolTipText("Canncelar Aprovação");
        jBtCancelar.setEnabled(false);
        jBtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarActionPerformed(evt);
            }
        });

        jBtAuditoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoria.setToolTipText("Auditoria Aprovação");
        jBtAuditoria.setContentAreaFilled(false);
        jBtAuditoria.setEnabled(false);
        jBtAuditoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaActionPerformed(evt);
            }
        });

        jBtFinalizar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtFinalizar.setForeground(new java.awt.Color(0, 153, 0));
        jBtFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/accept.png"))); // NOI18N
        jBtFinalizar.setToolTipText(" Finalizar Aprovação");
        jBtFinalizar.setEnabled(false);
        jBtFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFinalizarActionPerformed(evt);
            }
        });

        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSair.setToolTipText("Sair");
        jBtSair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSair.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSair.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        jBtAdcionarItensSoli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/kde-file-downloads-icone-4393-16.png"))); // NOI18N
        jBtAdcionarItensSoli.setToolTipText("Adicionar Itens Solicitado");
        jBtAdcionarItensSoli.setEnabled(false);
        jBtAdcionarItensSoli.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAdcionarItensSoli.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAdcionarItensSoli.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAdcionarItensSoli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAdcionarItensSoliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(jBtAdcionarItensSoli, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jBtFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(jBtAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(jBtNovo)
                .addComponent(jBtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jBtExcluir)
                .addComponent(jBtSalvar)
                .addComponent(jBtCancelar)
                .addComponent(jBtAuditoria)
                .addComponent(jBtFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jBtSair)
                .addComponent(jBtAdcionarItensSoli))
        );

        jPanel11Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtFinalizar, jBtSair});

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jBtExcluirProdutoSolicitacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirProdutoSolicitacao.setToolTipText("Excluir Produto Solicitação");
        jBtExcluirProdutoSolicitacao.setEnabled(false);
        jBtExcluirProdutoSolicitacao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluirProdutoSolicitacao.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirProdutoSolicitacao.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirProdutoSolicitacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirProdutoSolicitacaoActionPerformed(evt);
            }
        });

        jBtImprimirSolicitacaoAprovada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/gtklp-icone-3770-16.png"))); // NOI18N
        jBtImprimirSolicitacaoAprovada.setToolTipText("Imprimir Solicitação Aprovada");
        jBtImprimirSolicitacaoAprovada.setEnabled(false);
        jBtImprimirSolicitacaoAprovada.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtImprimirSolicitacaoAprovada.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtImprimirSolicitacaoAprovada.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtImprimirSolicitacaoAprovada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtImprimirSolicitacaoAprovadaActionPerformed(evt);
            }
        });

        jBtAprovacaoTotal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/file-access-rights-in-icone-7094-16.png"))); // NOI18N
        jBtAprovacaoTotal.setText("Aprovar Itens");
        jBtAprovacaoTotal.setToolTipText("Aprovação Total");
        jBtAprovacaoTotal.setEnabled(false);
        jBtAprovacaoTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAprovacaoTotalActionPerformed(evt);
            }
        });

        jBtAlterarItens.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/aurora-records-texto-icone-4575-16.png"))); // NOI18N
        jBtAlterarItens.setText(" Alterar Itens");
        jBtAlterarItens.setToolTipText("Alterar Aprovação");
        jBtAlterarItens.setEnabled(false);
        jBtAlterarItens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarItensActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtExcluirProdutoSolicitacao, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtImprimirSolicitacaoAprovada, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122)
                .addComponent(jBtAprovacaoTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarItens)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterarItens, jBtAprovacaoTotal});

        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtExcluirProdutoSolicitacao)
                    .addComponent(jBtImprimirSolicitacaoAprovada, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtAlterarItens)
                    .addComponent(jBtAprovacaoTotal))
                .addGap(14, 14, 14))
        );

        jTabbedPane3.setForeground(new java.awt.Color(0, 0, 255));
        jTabbedPane3.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jTabelaItensSolicitacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaItensSolicitacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Descrição do Produto", "UN", "Quant.", "Valor UN R$", "Valor Total"
            }
        ));
        jTabelaItensSolicitacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaItensSolicitacaoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTabelaItensSolicitacao);
        if (jTabelaItensSolicitacao.getColumnModel().getColumnCount() > 0) {
            jTabelaItensSolicitacao.getColumnModel().getColumn(0).setMinWidth(60);
            jTabelaItensSolicitacao.getColumnModel().getColumn(0).setMaxWidth(60);
            jTabelaItensSolicitacao.getColumnModel().getColumn(1).setMinWidth(300);
            jTabelaItensSolicitacao.getColumnModel().getColumn(1).setMaxWidth(300);
            jTabelaItensSolicitacao.getColumnModel().getColumn(2).setMinWidth(50);
            jTabelaItensSolicitacao.getColumnModel().getColumn(2).setMaxWidth(50);
            jTabelaItensSolicitacao.getColumnModel().getColumn(3).setMinWidth(70);
            jTabelaItensSolicitacao.getColumnModel().getColumn(3).setMaxWidth(70);
            jTabelaItensSolicitacao.getColumnModel().getColumn(4).setMinWidth(70);
            jTabelaItensSolicitacao.getColumnModel().getColumn(4).setMaxWidth(70);
            jTabelaItensSolicitacao.getColumnModel().getColumn(5).setMinWidth(70);
            jTabelaItensSolicitacao.getColumnModel().getColumn(5).setMaxWidth(70);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("Itens da Solicitação", jPanel1);

        jTabelaItensAprovado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaItensAprovado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Descrição do Produto", "UN", "Quant.", "Valor UN R$", "Valor Total"
            }
        ));
        jScrollPane5.setViewportView(jTabelaItensAprovado);
        if (jTabelaItensAprovado.getColumnModel().getColumnCount() > 0) {
            jTabelaItensAprovado.getColumnModel().getColumn(0).setMinWidth(60);
            jTabelaItensAprovado.getColumnModel().getColumn(0).setMaxWidth(60);
            jTabelaItensAprovado.getColumnModel().getColumn(1).setMinWidth(300);
            jTabelaItensAprovado.getColumnModel().getColumn(1).setMaxWidth(300);
            jTabelaItensAprovado.getColumnModel().getColumn(2).setMinWidth(50);
            jTabelaItensAprovado.getColumnModel().getColumn(2).setMaxWidth(50);
            jTabelaItensAprovado.getColumnModel().getColumn(3).setMinWidth(70);
            jTabelaItensAprovado.getColumnModel().getColumn(3).setMaxWidth(70);
            jTabelaItensAprovado.getColumnModel().getColumn(4).setMinWidth(70);
            jTabelaItensAprovado.getColumnModel().getColumn(4).setMaxWidth(70);
            jTabelaItensAprovado.getColumnModel().getColumn(5).setMinWidth(70);
            jTabelaItensAprovado.getColumnModel().getColumn(5).setMaxWidth(70);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("Itens Aprovado", jPanel3);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane3)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel11, jTabbedPane3});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Solicitações de Compras", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(300, 20, 563, 539);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesqCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqCodigoActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (jIdPesqSol.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o código para pesquisa.");
        } else {
            pesquisarSolicitacaoCompras("SELECT * FROM APROVACAO_SOLICITACAO_COMPRAS_ADM "
                    + "INNER JOIN SOLICITACAO_PRODUTOS_ADM "
                    + "ON APROVACAO_SOLICITACAO_COMPRAS_ADM.IdSol=SOLICITACAO_PRODUTOS_ADM.IdSol "
                    + "WHERE IdAprova='" + jIdPesqSol.getText() + "'");
        }
    }//GEN-LAST:event_jBtPesqCodigoActionPerformed

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
                        pesquisarSolicitacaoCompras("SELECT * FROM APROVACAO_SOLICITACAO_COMPRAS_ADM "
                                + "INNER JOIN SOLICITACAO_PRODUTOS_ADM "
                                + "ON APROVACAO_SOLICITACAO_COMPRAS_ADM.IdSol=SOLICITACAO_PRODUTOS_ADM.IdSol"
                                + "WHERE DataSol BETWEEN'" + dataInicial + "' "
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
                        pesquisarSolicitacaoCompras("SELECT * FROM APROVACAO_SOLICITACAO_COMPRAS_ADM "
                                + "INNER JOIN SOLICITACAO_PRODUTOS_ADM "
                                + "ON APROVACAO_SOLICITACAO_COMPRAS_ADM.IdSol=SOLICITACAO_PRODUTOS_ADM.IdSol"
                                + "WHERE DataSol BETWEEN'" + dataInicial + "' "
                                + "AND '" + dataFinal + "'");
                    }
                }
            }
        }
    }//GEN-LAST:event_jBtPesqDataActionPerformed

    private void jBtPesqNomeSolicitanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNomeSolicitanteActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (jPesqNomeSolicitante.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe  o nome do Autorizador para pesquisa.");
        } else {
            pesquisarSolicitacaoCompras("SELECT * FROM APROVACAO_SOLICITACAO_COMPRAS_ADM "
                    + "INNER JOIN SOLICITACAO_PRODUTOS_ADM "
                    + "ON APROVACAO_SOLICITACAO_COMPRAS_ADM.IdSol=SOLICITACAO_PRODUTOS_ADM.IdSol "
                    + "WHERE UsuarioAprovador='" + jPesqNomeSolicitante.getText() + "'");
        }
    }//GEN-LAST:event_jBtPesqNomeSolicitanteActionPerformed

    private void jCheckBoxTodosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxTodosItemStateChanged
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.pesquisarSolicitacaoCompras("SELECT * FROM APROVACAO_SOLICITACAO_COMPRAS_ADM "
                    + "INNER JOIN SOLICITACAO_PRODUTOS_ADM "
                    + "ON APROVACAO_SOLICITACAO_COMPRAS_ADM.IdSol=SOLICITACAO_PRODUTOS_ADM.IdSol");
        } else {
            jtotalRegistros.setText("");
            limparTabelaSolicitacao();
        }
    }//GEN-LAST:event_jCheckBoxTodosItemStateChanged

    private void jTabelaAprovacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaAprovacaoMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String IdLanc = "" + jTabelaAprovacao.getValueAt(jTabelaAprovacao.getSelectedRow(), 0);
            jIdPesqSol.setText(IdLanc);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtExcluirProdutoSolicitacao.setEnabled(!true);
            jBtAuditoria.setEnabled(true);
            jBtImprimirSolicitacaoAprovada.setEnabled(true);
            //
            bloquearCamposPesquisa();
            //
            Integer row = jTabelaItensSolicitacao.getModel().getRowCount();
            Integer rows = jTabelaItensAprovado.getModel().getRowCount();
            if (row == 0 && rows == 0) {
                jBtAprovacaoTotal.setEnabled(!true);
                jBtAlterarItens.setEnabled(!true);
            } else if (rows == 0) {
                jBtAprovacaoTotal.setEnabled(true);
                jBtAlterarItens.setEnabled(!true);
            } else {
                jBtAprovacaoTotal.setEnabled(!true);
                jBtAlterarItens.setEnabled(true);
            }
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM APROVACAO_SOLICITACAO_COMPRAS_ADM "
                        + "INNER JOIN SOLICITACAO_PRODUTOS_ADM "
                        + "ON APROVACAO_SOLICITACAO_COMPRAS_ADM.IdSol=SOLICITACAO_PRODUTOS_ADM.IdSol "
                        + "INNER JOIN SOLICITANTES_COMPRAS "
                        + "ON SOLICITACAO_PRODUTOS_ADM.IdFuncAprova=SOLICITACAO_PRODUTOS_ADM.IdFuncAprova "
                        + "INNER JOIN COLABORADOR "
                        + "ON SOLICITACAO_PRODUTOS_ADM.IdFunc=COLABORADOR.IdFunc "
                        + "INNER JOIN DEPARTAMENTOS "
                        + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                        + "WHERE APROVACAO_SOLICITACAO_COMPRAS_ADM.IdAprova='" + IdLanc + "'");
                conecta.rs.first();
                jIdAprova.setText(String.valueOf(conecta.rs.getInt("IdAprova")));
                jStatusAprova.setText(conecta.rs.getString("StatusAprova"));
                jDataAprova.setDate(conecta.rs.getDate("DataAprova"));
                jUsuarioAprovador.setText(conecta.rs.getString("UsuarioAprovador"));
                jIdSolicitacao.setText(conecta.rs.getString("IdSol"));
                jDataSolicitacao.setDate(conecta.rs.getDate("DataSol"));
                jIdLocal.setText(conecta.rs.getString("IdLocal"));
                jDescricaoDepartamento.setText(conecta.rs.getString("NomeDepartamento"));
                jIdSolicitante.setText(String.valueOf(conecta.rs.getInt("IdFunc")));
                jNomeSolicitante.setText(conecta.rs.getString("NomeFunc"));
                jObservacao.setText(conecta.rs.getString("Observacao"));
                valorSolicitado = conecta.rs.getFloat("ValorSolicitado");
                DecimalFormat vu = new DecimalFormat("#,##0.00");
                String vlSolicitado = vu.format(valorSolicitado);
                jValorTotalSolicitacao.setText(vlSolicitado);
                valorAprovado = conecta.rs.getFloat("ValorAprovado");
                DecimalFormat vti = new DecimalFormat("#,##0.00");
                String vlAprovado = vti.format(valorAprovado);
                jValorTotalAprovado.setText(vlAprovado);
                conecta.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "Não foi possível exibir registro.\nERRO: " + e);
            }
            count = 0;
            preencherTabelaItens("SELECT * FROM ITENS_SOLICITACAO_COMPRAS_ADM "
                    + "INNER JOIN SOLICITACAO_PRODUTOS_ADM "
                    + "ON ITENS_SOLICITACAO_COMPRAS_ADM.IdSol=SOLICITACAO_PRODUTOS_ADM.IdSol "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON ITENS_SOLICITACAO_COMPRAS_ADM.IdProd=PRODUTOS_AC.IdProd "
                    + "WHERE ITENS_SOLICITACAO_COMPRAS_ADM.IdSol='" + jIdSolicitacao.getText() + "'");
            //
            preencherTabelaItensAprovado("SELECT * FROM ITENS_APROVACAO_SOLICITACAO_COMPRAS_ADM "
                    + "INNER JOIN APROVACAO_SOLICITACAO_COMPRAS_ADM "
                    + "ON ITENS_APROVACAO_SOLICITACAO_COMPRAS_ADM.IdAprova=APROVACAO_SOLICITACAO_COMPRAS_ADM.IdAprova "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON ITENS_APROVACAO_SOLICITACAO_COMPRAS_ADM.IdProd=PRODUTOS_AC.IdProd "
                    + "WHERE ITENS_APROVACAO_SOLICITACAO_COMPRAS_ADM.IdAprova='" + jIdAprova.getText() + "'");
        }
    }//GEN-LAST:event_jTabelaAprovacaoMouseClicked

    private void jBtPesquisarSolicitacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisarSolicitacaoActionPerformed
        // TODO add your handling code here:
        TelaPesquisarSolicitacaoCompraAprovacao objPesqSoliAprova = new TelaPesquisarSolicitacaoCompraAprovacao();
        TelaModuloAdmPessoal.jPainelAdmPessoal.add(objPesqSoliAprova);
        objPesqSoliAprova.show();
    }//GEN-LAST:event_jBtPesquisarSolicitacaoActionPerformed

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAprovadorSC_ADM);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoADM.equals("ADMINISTRADORES") || codigoUserADM == codUserAcessoADM && nomeTelaADM.equals(telaAprovadorSC_ADM) && codIncluirADM == 1) {
            verificarLiberador();
            if (nameUser.equals(nomeAprovador)) {
                acao = 1;
                Novo();
                corCampos();
                statusMov = "Incluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esse usuário não tem permissão para aprovar/liberar Solicitações de Compras.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAprovadorSC_ADM);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoADM.equals("ADMINISTRADORES") || codigoUserADM == codUserAcessoADM && nomeTelaADM.equals(telaAprovadorSC_ADM) && codAlterarADM == 1) {
            verificarLiberador();
            objAprovaSol.setStatusAprova(jStatusAprova.getText());
            if (jStatusAprova.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser modificado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 2;
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
        buscarAcessoUsuario(telaAprovadorSC_ADM);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoADM.equals("ADMINISTRADORES") || codigoUserADM == codUserAcessoADM && nomeTelaADM.equals(telaAprovadorSC_ADM) && codExcluirADM == 1) {
            objAprovaSol.setStatusAprova(jStatusAprova.getText());
            if (jStatusAprova.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser modificado, o mesmo encontra-se FINALIZADO");
            } else {
                statusMov = "Excluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
                Integer row = jTabelaItensSolicitacao.getModel().getRowCount();
                Integer row1 = jTabelaItensAprovado.getModel().getRowCount();
                if (row == 0 && row1 == 0) {
                    int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o LANÇAMENTO selecionado?", "Confirmação",
                            JOptionPane.YES_NO_OPTION);
                    if (resposta == JOptionPane.YES_OPTION) {
                        objAprovaSol.setIdAprova(Integer.valueOf(jIdAprova.getText()));
                        control.excluirAprovacaoSolicitacao(objAprovaSol);
                        Excluir();
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Não é possível excluir esse registro. Existe(m) produto(s) relacionado(s) a esse documento.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:     
        buscarAcessoUsuario(telaAprovadorSC_ADM);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoADM.equals("ADMINISTRADORES") || codigoUserADM == codUserAcessoADM && nomeTelaADM.equals(telaAprovadorSC_ADM) && codGravarADM == 1) {
            verificarSaldoAprovacaoSolicitacao();
            situacaoSoliticacao = "Em Liberação";
            DecimalFormat qtdReal = new DecimalFormat("#,##00.0");
            qtdReal.setCurrency(Currency.getInstance(new Locale("pt", "BR")));
            if (jDataAprova.getDate() == null) {
                jDataAprova.setBackground(Color.red);
                jDataAprova.requestFocus();
                JOptionPane.showMessageDialog(rootPane, "Informe a data da aprovação.");
            } else if (jIdSolicitacao.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe a solicitação a ser aprovada.");
            } else {
                objAprovaSol.setStatusAprova(jStatusAprova.getText());
                objAprovaSol.setDataAprova(jDataAprova.getDate());
                objAprovaSol.setNomeUsuarioAprovador(jUsuarioAprovador.getText());
                objAprovaSol.setObservacao(jObservacao.getText());
                objAprovaSol.setSituacaoSol(statusMov);
                objAprovaSol.setIdSol(Integer.valueOf(jIdSolicitacao.getText()));
                try {
                    objAprovaSol.setValorTotalSolicitacao(qtdReal.parse(jValorTotalSolicitacao.getText()).floatValue());
                    objAprovaSol.setValorTotalAprovado(qtdReal.parse(jValorTotalAprovado.getText()).floatValue());
                } catch (ParseException ex) {
                    Logger.getLogger(TelaAprovarSolicitacaoCompras.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (objAprovaSol.getValorTotalSolicitacao() > valorAprovacaoSolicitacao) {
                    JOptionPane.showMessageDialog(rootPane, "Saldo de liberação é insuficiente para aprovação dessa solicitação.");
                } else {
                    if (acao == 1) {
                        objAprovaSol.setUsuarioInsert(nameUser);
                        objAprovaSol.setDataInsert(dataModFinal);
                        objAprovaSol.setHorarioInsert(horaMov);
                        //
                        control.incluirAprovacaoSolicitacao(objAprovaSol);
                        buscarCodigo();
                        // ATUALIZAR CAMPOS (ValorAprovado) E CAMPO (Situacao) NA TABELA SOLICITACAO_PRODUTOS_ADM
                        objSoliMat.setUsuarioUp(nameUser);
                        objSoliMat.setDataUp(dataModFinal);
                        objSoliMat.setHorarioUp(horaMov);
                        objSoliMat.setIdSol(Integer.valueOf(jIdSolicitacao.getText()));
                        objSoliMat.setSituacao(situacaoSoliticacao);
                        controlSol.alterarCampoSolicitacaoMaterialADM(objSoliMat);
                        // CALCULAR O SALDO DO APROVADOR.
                        valorSaldoTotalCompras = valorSaldoTotalCompras - objAprovaSol.getValorTotalSolicitacao();
                        objSoliMat.setValorSaldoRequisicao(valorSaldoTotalCompras);
                        objSoliMat.setIdLibera(codigoAprovador);
                        controlSol.atualizarSaldoLiberadorCompras(objSoliMat);
                        //
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                        Salvar();
                    }
                    if (acao == 2) {
                        objAprovaSol.setUsuarioUp(nameUser);
                        objAprovaSol.setDataUp(dataModFinal);
                        objAprovaSol.setHorarioUp(horaMov);
                        //
                        objAprovaSol.setIdAprova(Integer.valueOf(jIdAprova.getText()));
                        control.alterarAprovacaoSolicitacao(objAprovaSol);
                        // ATUALIZAR CAMPOS (ValorAprovado) E CAMPO (Situacao) NA TABELA SOLICITACAO_PRODUTOS_ADM
                        objSoliMat.setUsuarioUp(nameUser);
                        objSoliMat.setDataUp(dataModFinal);
                        objSoliMat.setHorarioUp(horaMov);
                        objSoliMat.setIdSol(Integer.valueOf(jIdSolicitacao.getText()));
                        objSoliMat.setSituacao(situacaoSoliticacao);
                        controlSol.alterarCampoSolicitacaoMaterialADM(objSoliMat);
                        // CALCULAR O SALDO DO APROVADOR.
                        //valorSaldoTotalCompras = valorSaldoTotalComprasAlt - objAprovaSol.getValorTotalSolicitacao();
                        valorSaldoTotalCompras = (float) ((valorSaldoTotalCompras - valorSolicitado) + objAprovaSol.getValorTotalSolicitacao());
                        objSoliMat.setValorSaldoRequisicao(valorSaldoTotalCompras);
                        objSoliMat.setIdLibera(codigoAprovador);
                        controlSol.atualizarSaldoLiberadorCompras(objSoliMat);
                        //
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                        Salvar();
                    }
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
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtAdcionarItensSoliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAdcionarItensSoliActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAprovarItensSC_ADM);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoADM.equals("ADMINISTRADORES") || codigoUserADM == codUserAcessoADM && nomeTelaADM.equals(telaAprovarItensSC_ADM) && codIncluirADM == 1) {
            Integer rows = jTabelaItensSolicitacao.getModel().getRowCount();
            if (rows == 0) {
                conecta.abrirConexao();
                try {
                    do {
                        PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_SOLICITACAO_COMPRAS_ADM "
                                + "(IdSol,IdProd,QtdItem,ValorUnitarioItem,ValorTotalItem) "
                                + "SELECT IdSol,IdProd,QtdItem,ValorUnitarioItem,ValorTotalItem "
                                + "FROM ITENS_SOLICITACAO_PRODUTOS_ADM WHERE IdSol='" + jIdSolicitacao.getText() + "'");
                        pst.execute();
                    } while (conecta.rs.next());
                } catch (Exception e) {
                }
                preencherTabelaItens("SELECT * FROM ITENS_SOLICITACAO_COMPRAS_ADM "
                        + "INNER JOIN SOLICITACAO_PRODUTOS_ADM "
                        + "ON ITENS_SOLICITACAO_COMPRAS_ADM.IdSol=SOLICITACAO_PRODUTOS_ADM.IdSol "
                        + "INNER JOIN PRODUTOS_AC "
                        + "ON ITENS_SOLICITACAO_COMPRAS_ADM.IdProd=PRODUTOS_AC.IdProd "
                        + "WHERE ITENS_SOLICITACAO_COMPRAS_ADM.IdSol='" + jIdSolicitacao.getText() + "'");
                conecta.desconecta();
                JOptionPane.showMessageDialog(rootPane, "Itens transferido com sucesso.");
                jBtAprovacaoTotal.setEnabled(true);
                jBtAlterarItens.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Já foi efetuado a transferência dos produtos para essa aprovação.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtAdcionarItensSoliActionPerformed

    private void jBtFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFinalizarActionPerformed
        // TODO add your handling code here:
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM APROVACAO_SOLICITACAO_COMPRAS_ADM "
                    + "WHERE IdAprova='" + jIdAprova.getText() + "'");
            conecta.rs.first();
            jStatusAprova.setText(conecta.rs.getString("StatusAprova"));
            if (jStatusAprova.getText().equals("FINALIZADO")) {
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
        TelaAuditoriaAprovacaoSolicitacao objAudiAprova = new TelaAuditoriaAprovacaoSolicitacao();
        TelaModuloAdmPessoal.jPainelAdmPessoal.add(objAudiAprova);
        objAudiAprova.show();
    }//GEN-LAST:event_jBtAuditoriaActionPerformed

    private void jBtExcluirProdutoSolicitacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirProdutoSolicitacaoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAprovarItensSC_ADM);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoADM.equals("ADMINISTRADORES") || codigoUserADM == codUserAcessoADM && nomeTelaADM.equals(telaAprovarItensSC_ADM) && codExcluirADM == 1) {
            //VERIFICAR SE O PRODUTO EXISTE NA TABELA ITENS_APROVACAO_SOLICITACAO_COMPRAS_ADM ANTES DE EXCLUIR
            verificarProdutoAprovado();
            objAprovaSol.setStatusAprova(jStatusAprova.getText());
            if (jStatusAprova.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser excluído, o mesmo encontra-se FINALIZADO");
            } else {
                statusMov = "Excluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
                if (idProduto == codigoProdutoAprovado) {
                    JOptionPane.showMessageDialog(rootPane, "Não é possível excluir esse produto, pois já foi aprovado.\nÉ necessário excluir o produto da tabela de aprovação primeiro.");
                } else {
                    int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                            JOptionPane.YES_NO_OPTION);
                    if (resposta == JOptionPane.YES_OPTION) {
                        objItensCompra.setIdSol(Integer.valueOf(jIdSolicitacao.getText()));
                        objItensCompra.setIdProd(idProduto);
                        JOptionPane.showMessageDialog(rootPane, "Solicitação: " + jIdSolicitacao.getText());
                        JOptionPane.showMessageDialog(rootPane, "Produto: " + idProduto);
                        controle.excluirItensSolicitacaoComprasADM(objItensCompra);
                        //
                        objLog3();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação                    
                        preencherTabelaItens("SELECT * FROM ITENS_SOLICITACAO_COMPRAS_ADM "
                                + "INNER JOIN SOLICITACAO_PRODUTOS_ADM "
                                + "ON ITENS_SOLICITACAO_COMPRAS_ADM.IdSol=SOLICITACAO_PRODUTOS_ADM.IdSol "
                                + "INNER JOIN PRODUTOS_AC "
                                + "ON ITENS_SOLICITACAO_COMPRAS_ADM.IdProd=PRODUTOS_AC.IdProd "
                                + "WHERE ITENS_SOLICITACAO_COMPRAS_ADM.IdSol='" + jIdSolicitacao.getText() + "'");
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirProdutoSolicitacaoActionPerformed

    private void jBtAprovacaoTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAprovacaoTotalActionPerformed
        // TODO add your handling code here:       
        buscarAcessoUsuario(telaAprovarItensSC_ADM);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoADM.equals("ADMINISTRADORES") || codigoUserADM == codUserAcessoADM && nomeTelaADM.equals(telaAprovarItensSC_ADM) && codIncluirADM == 1) {
            statusAprovacao = "Aprovado Total";
            DecimalFormat valorRealMoed = new DecimalFormat("#,##00.0");
            valorRealMoed.setCurrency(Currency.getInstance(new Locale("pt", "BR")));
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente Aprovar a SOLICITAÇÃO selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objSoliMat.setUsuarioUp(nameUser);
                objSoliMat.setDataUp(dataModFinal);
                objSoliMat.setHorarioUp(horaMov);
                //
                jValorTotalAprovado.setText(jValorTotalSolicitacao.getText());
                try {
                    objSoliMat.setValorAprovado(valorRealMoed.parse(jValorTotalAprovado.getText()).floatValue());
                } catch (ParseException ex) {
                }
                // ATUALIZAR CAMPOS (ValorAprovado) E CAMPO (Situacao) NA TABELA SOLICITACAO_PRODUTOS_ADM
                objSoliMat.setIdSol(Integer.valueOf(jIdSolicitacao.getText()));
                objSoliMat.setSituacao(situacaoSoliticacao);
                controlSol.alterarCampoSolicitacaoMaterialADM(objSoliMat);
                // GRAVAR OS DADOS NA TABELA ITENS_APROVACAO_SOLICITACAO_COMPRAS_ADM
                for (int i = 0; i < jTabelaItensSolicitacao.getRowCount(); i++) {
                    objItensCompra.setUsuarioUp(nameUser);
                    objItensCompra.setDataUp(dataModFinal);
                    objItensCompra.setHorarioUp(horaMov);
                    //
                    objItensCompra.setIdSol(Integer.valueOf(jIdSolicitacao.getText()));
                    objItensCompra.setIdAprova(Integer.valueOf(jIdAprova.getText()));
                    objItensCompra.setDataAprova(jDataAprova.getDate());
                    objItensCompra.setIdProd((int) jTabelaItensSolicitacao.getValueAt(i, 0));
                    try {
                        objItensCompra.setQtdItem(valorRealMoed.parse((String) jTabelaItensSolicitacao.getValueAt(i, 3)).floatValue());
                        objItensCompra.setValorUnitarioItem(valorRealMoed.parse((String) jTabelaItensSolicitacao.getValueAt(i, 4)).floatValue());
                        objItensCompra.setValorTotalItem(valorRealMoed.parse((String) jTabelaItensSolicitacao.getValueAt(i, 5)).floatValue());
                    } catch (ParseException ex) {
                    }
                    // GRAVAR OS PRODUTOS NA  TABELA ITENS_APROVACAO_SOLICITACAO_COMPRAS_ADM
                    controle.incluirItensAprovadoADM(objItensCompra);
                    // ATUALIZAR OS CAMPOS DA SOLICITAÇÃO QUANDO APROVADA (AprovaSol,StatusAprovacao)
                    objItensCompra.setIdSol(Integer.valueOf(jIdSolicitacao.getText()));
                    objItensCompra.setIdProd((int) jTabelaItensSolicitacao.getValueAt(i, 0));
                    objItensCompra.setStatusAprovacao(statusAprovacao); // Status APROVADO
                    objItensCompra.setAprovaSolicitacao(aprovaSolicitacao); // Aprovacao = "Sim"
                    controle.atualizaCampoAprovaSolicitacaoMaterialADM(objItensCompra);
                    objLog2();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    //
                    preencherTabelaItensAprovado("SELECT * FROM ITENS_APROVACAO_SOLICITACAO_COMPRAS_ADM "
                            + "INNER JOIN APROVACAO_SOLICITACAO_COMPRAS_ADM "
                            + "ON ITENS_APROVACAO_SOLICITACAO_COMPRAS_ADM.IdAprova=APROVACAO_SOLICITACAO_COMPRAS_ADM.IdAprova "
                            + "INNER JOIN PRODUTOS_AC "
                            + "ON ITENS_APROVACAO_SOLICITACAO_COMPRAS_ADM.IdProd=PRODUTOS_AC.IdProd "
                            + "WHERE ITENS_APROVACAO_SOLICITACAO_COMPRAS_ADM.IdAprova='" + jIdAprova.getText() + "'");
                }
                jBtAprovacaoTotal.setEnabled(!true);
                jBtImprimirSolicitacaoAprovada.setEnabled(true);
                JOptionPane.showMessageDialog(rootPane, "Aprovação de Solicitação concluída com sucesso.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtAprovacaoTotalActionPerformed

    private void jBtAlterarItensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarItensActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAprovarItensSC_ADM);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoADM.equals("ADMINISTRADORES") || codigoUserADM == codUserAcessoADM && nomeTelaADM.equals(telaAprovarItensSC_ADM) && codAlterarADM == 1) {
            mostrarItensSolicitacao();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtAlterarItensActionPerformed

    private void jBtImprimirSolicitacaoAprovadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImprimirSolicitacaoAprovadaActionPerformed
        // TODO add your handling code here:
        Integer row = jTabelaItensSolicitacao.getModel().getRowCount();
        Integer rows = jTabelaItensAprovado.getModel().getRowCount();
        if (jIdAprova.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Não é possível listar a Requisição de Materiais.");
        } else if (row != 0 && rows != 0) {
            try {
                conecta.abrirConexao();
                String path = "reports/SolicitacaoComprasAprovadosADM.jasper";
                conecta.executaSQL("SELECT * FROM APROVACAO_SOLICITACAO_COMPRAS_ADM "
                        + "INNER JOIN SOLICITACAO_PRODUTOS_ADM "
                        + "ON APROVACAO_SOLICITACAO_COMPRAS_ADM.IdSol=SOLICITACAO_PRODUTOS_ADM.IdSol "
                        + "INNER JOIN SOLICITANTES_COMPRAS "
                        + "ON SOLICITACAO_PRODUTOS_ADM.IdFuncAprova=SOLICITACAO_PRODUTOS_ADM.IdFuncAprova "
                        + "INNER JOIN COLABORADOR "
                        + "ON SOLICITACAO_PRODUTOS_ADM.IdFunc=COLABORADOR.IdFunc "
                        + "INNER JOIN DEPARTAMENTOS "
                        + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                        + "INNER JOIN ITENS_APROVACAO_SOLICITACAO_COMPRAS_ADM "
                        + "ON APROVACAO_SOLICITACAO_COMPRAS_ADM.IdAprova=ITENS_APROVACAO_SOLICITACAO_COMPRAS_ADM.IdAprova "
                        + "WHERE APROVACAO_SOLICITACAO_COMPRAS_ADM.IdAprova='" + jIdAprova.getText() + "'");
                HashMap parametros = new HashMap();
                parametros.put("codigoSolicitacao", jIdAprova.getText());
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
                jv.setTitle("Solicitação de Compras de Materiais Aprovada");
                jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
                jv.toFront(); // Traz o relatorio para frente da aplicação            
                conecta.desconecta();
            } catch (JRException e) {
                JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório. \n\nERRO :" + e);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Relatório não pode ser listado por que não existe itens.");
        }
    }//GEN-LAST:event_jBtImprimirSolicitacaoAprovadaActionPerformed

    private void jTabelaItensSolicitacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaItensSolicitacaoMouseClicked
        // TODO add your handling code here:
        linhaSelecionada = jTabelaItensSolicitacao.getSelectedRow();
        idProduto = (int) jTabelaItensSolicitacao.getValueAt(linhaSelecionada, 0);
        jBtExcluirProdutoSolicitacao.setEnabled(true);
    }//GEN-LAST:event_jTabelaItensSolicitacaoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtAdcionarItensSoli;
    private javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtAlterarItens;
    private javax.swing.JButton jBtAprovacaoTotal;
    private javax.swing.JButton jBtAuditoria;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtExcluir;
    private javax.swing.JButton jBtExcluirProdutoSolicitacao;
    private javax.swing.JButton jBtFinalizar;
    private javax.swing.JButton jBtImprimirSolicitacaoAprovada;
    private javax.swing.JButton jBtNovo;
    private javax.swing.JButton jBtPesqCodigo;
    private javax.swing.JButton jBtPesqData;
    private javax.swing.JButton jBtPesqNomeSolicitante;
    private javax.swing.JButton jBtPesquisarSolicitacao;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBoxTodos;
    private javax.swing.JComboBox jComboBoxDepartamentos;
    public static com.toedter.calendar.JDateChooser jDataAprova;
    private com.toedter.calendar.JDateChooser jDataPesFinal;
    private com.toedter.calendar.JDateChooser jDataPesqInicial;
    public static com.toedter.calendar.JDateChooser jDataSolicitacao;
    public static javax.swing.JTextField jDescricaoDepartamento;
    public static javax.swing.JTextField jIdAprova;
    public static javax.swing.JTextField jIdLocal;
    private javax.swing.JTextField jIdPesqSol;
    public static javax.swing.JTextField jIdSolicitacao;
    public static javax.swing.JTextField jIdSolicitante;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JTextField jNomeSolicitante;
    private javax.swing.JTextArea jObservacao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jPesqNomeSolicitante;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    public static javax.swing.JTextField jStatusAprova;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable jTabelaAprovacao;
    public static javax.swing.JTable jTabelaItensAprovado;
    public static javax.swing.JTable jTabelaItensSolicitacao;
    private javax.swing.JTextField jUsuarioAprovador;
    public static javax.swing.JFormattedTextField jValorTotalAprovado;
    public static javax.swing.JFormattedTextField jValorTotalSolicitacao;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void bloquearCamposPesquisa() {
        jDataAprova.setEnabled(!true);
        jBtPesquisarSolicitacao.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAdcionarItensSoli.setEnabled(true);
    }

    public void formatarCampos() {
        jObservacao.setLineWrap(true);
        jObservacao.setWrapStyleWord(true);
    }

    public void corCampos() {
        jIdAprova.setBackground(Color.white);
        jStatusAprova.setBackground(Color.white);
        jDataAprova.setBackground(Color.white);
        jUsuarioAprovador.setBackground(Color.white);
        jIdSolicitacao.setBackground(Color.white);
        jDataSolicitacao.setBackground(Color.white);
        jIdLocal.setBackground(Color.white);
        jDescricaoDepartamento.setBackground(Color.white);
        jIdSolicitante.setBackground(Color.white);
        jNomeSolicitante.setBackground(Color.white);
        jValorTotalSolicitacao.setBackground(Color.white);
        jValorTotalAprovado.setBackground(Color.white);
        jObservacao.setBackground(Color.white);
        jValorTotalSolicitacao.setText("0,00");
        jValorTotalAprovado.setText("0,00");
    }

    public void Novo() {
        jIdAprova.setText("");
        jStatusAprova.setText("ABERTO");
        jDataAprova.setCalendar(Calendar.getInstance());
        jUsuarioAprovador.setText(nameUser);
        jIdSolicitacao.setText("");
        jDataSolicitacao.setDate(null);
        jIdLocal.setText("");
        jDescricaoDepartamento.setText("");
        jIdSolicitante.setText("");
        jNomeSolicitante.setText("");
        jValorTotalSolicitacao.setText("0,00");
        jValorTotalAprovado.setText("0,00");
        jObservacao.setText("");
        //
        jDataAprova.setEnabled(true);
        jBtPesquisarSolicitacao.setEnabled(true);
        jObservacao.setEnabled(true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtAuditoria.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAdcionarItensSoli.setEnabled(!true);
        //
        jBtExcluirProdutoSolicitacao.setEnabled(!true);
        jBtImprimirSolicitacaoAprovada.setEnabled(!true);
        jBtAprovacaoTotal.setEnabled(!true);
        limparTabelaItens();
        limparTabelaItensAprovacao();
    }

    public void Alterar() {
        //
        jDataAprova.setEnabled(true);
        jBtPesquisarSolicitacao.setEnabled(true);
        jObservacao.setEnabled(true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtAuditoria.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAdcionarItensSoli.setEnabled(!true);
        //
        jBtExcluirProdutoSolicitacao.setEnabled(!true);
        jBtImprimirSolicitacaoAprovada.setEnabled(!true);
        jBtAprovacaoTotal.setEnabled(!true);
    }

    public void Excluir() {
        jIdAprova.setText("");
        jStatusAprova.setText("");
        jDataAprova.setDate(null);
        jUsuarioAprovador.setText(nameUser);
        jIdSolicitacao.setText("");
        jDataSolicitacao.setDate(null);
        jIdLocal.setText("");
        jDescricaoDepartamento.setText("");
        jIdSolicitante.setText("");
        jNomeSolicitante.setText("");
        jValorTotalSolicitacao.setText("0,00");
        jValorTotalAprovado.setText("0,00");
        jObservacao.setText("");
        //
        jDataAprova.setEnabled(!true);
        jBtPesquisarSolicitacao.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAdcionarItensSoli.setEnabled(!true);
        //
        jBtExcluirProdutoSolicitacao.setEnabled(!true);
        jBtImprimirSolicitacaoAprovada.setEnabled(!true);
        jBtAprovacaoTotal.setEnabled(!true);
    }

    public void Salvar() {
        jDataAprova.setEnabled(!true);
        jBtPesquisarSolicitacao.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAdcionarItensSoli.setEnabled(true);
        //
        jBtExcluirProdutoSolicitacao.setEnabled(true);
        jBtImprimirSolicitacaoAprovada.setEnabled(true);
        jBtAprovacaoTotal.setEnabled(!true);
        jBtAlterarItens.setEnabled(!true);
    }

    public void Cancelar() {
        if (jIdAprova.getText().equals("")) {
            jStatusAprova.setText("");
            jDataAprova.setDate(null);
            jUsuarioAprovador.setText("");
            jIdSolicitacao.setText("");
            jDataSolicitacao.setDate(null);
            jIdLocal.setText("");
            jDescricaoDepartamento.setText("");
            jIdSolicitante.setText("");
            jNomeSolicitante.setText("");
            jValorTotalSolicitacao.setText("0,00");
            jValorTotalAprovado.setText("0,00");
            jObservacao.setText("");
            //
            jDataAprova.setEnabled(!true);
            jBtPesquisarSolicitacao.setEnabled(!true);
            jObservacao.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtAuditoria.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
            jBtAdcionarItensSoli.setEnabled(!true);
            //
            jBtExcluirProdutoSolicitacao.setEnabled(!true);
            jBtImprimirSolicitacaoAprovada.setEnabled(!true);
            jBtAprovacaoTotal.setEnabled(!true);
        } else {
            jDataAprova.setEnabled(!true);
            jBtPesquisarSolicitacao.setEnabled(!true);
            jObservacao.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtAuditoria.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtAdcionarItensSoli.setEnabled(true);
            //
            jBtExcluirProdutoSolicitacao.setEnabled(true);
            jBtImprimirSolicitacaoAprovada.setEnabled(true);
            jBtAprovacaoTotal.setEnabled(true);
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
            objAprovaSol.setStatusAprova(statusLanc);
            objAprovaSol.setIdAprova(Integer.parseInt(jIdAprova.getText()));
            control.finalizarAprovacaoSolicitacao(objAprovaSol);
            jStatusAprova.setText("FINALIZADO");
            objLog();
            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
            JOptionPane.showMessageDialog(rootPane, "Registro FINALIZADO com sucesso !!!");
            //
            jDataAprova.setEnabled(!true);
            jBtPesquisarSolicitacao.setEnabled(!true);
            jBtAdcionarItensSoli.setEnabled(!true);
            jBtExcluirProdutoSolicitacao.setEnabled(!true);
            jObservacao.setEnabled(!true);
            jBtImprimirSolicitacaoAprovada.setEnabled(true);
            jBtAprovacaoTotal.setEnabled(!true);
            jBtAlterarItens.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
            jBtAuditoria.setEnabled(true);
        }
    }

    public void verificarProdutoAprovado() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENS_APROVACAO_SOLICITACAO_COMPRAS_ADM WHERE IdProd='" + idProduto + "'");
            conecta.rs.first();
            codigoProdutoAprovado = conecta.rs.getInt("IdProd");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarLiberador() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM APROVADOR_SOLICITACAO_COMPRAS_AC WHERE NomeAprovador='" + nameUser + "'");
            conecta.rs.first();
            codigoAprovador = conecta.rs.getInt("IdFuncAprova");
            nomeAprovador = conecta.rs.getString("NomeAprovador");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarSaldoAprovacaoSolicitacao() {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM APROVADOR_SOLICITACAO_COMPRAS_AC WHERE IdFuncAprova='" + codigoAprovador + "'");
            conecta.rs.first();
            valorAprovacaoSolicitacao = conecta.rs.getFloat("ValorSolicita");
            valorSaldoTotalCompras = conecta.rs.getFloat("ValorSaldoSolicita");
            valorSaldoTotalComprasAlt = conecta.rs.getFloat("ValorSaldoSolicita");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void buscarCodigo() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM APROVACAO_SOLICITACAO_COMPRAS_ADM");
            conecta.rs.last();
            jIdAprova.setText(conecta.rs.getString("IdAprova"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter o código do registro." + e);
        }
        conecta.desconecta();
    }

    public void preencherComboDepartamentos() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM DEPARTAMENTOS ORDER BY NomeDepartamento");
            conecta.rs.first();
            do {
                jComboBoxDepartamentos.addItem(conecta.rs.getString("NomeDepartamento"));
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void pesquisarSolicitacaoCompras(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Dt.Sol.", "Status Sol.", "Código Sol.", "Aprovador", "Observação"};
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
                dados.add(new Object[]{conecta.rs.getInt("IdAprova"), dataEmissao, conecta.rs.getString("StatusAprova"), conecta.rs.getString("IdSol"), conecta.rs.getString("UsuarioAprovador"), conecta.rs.getString("Observacao")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaAprovacao.setModel(modelo);
        jTabelaAprovacao.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaAprovacao.getColumnModel().getColumn(0).setResizable(false);
        jTabelaAprovacao.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaAprovacao.getColumnModel().getColumn(1).setResizable(false);
        jTabelaAprovacao.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaAprovacao.getColumnModel().getColumn(2).setResizable(false);
        jTabelaAprovacao.getColumnModel().getColumn(3).setPreferredWidth(70);
        jTabelaAprovacao.getColumnModel().getColumn(3).setResizable(false);
        jTabelaAprovacao.getColumnModel().getColumn(4).setPreferredWidth(300);
        jTabelaAprovacao.getColumnModel().getColumn(4).setResizable(false);
        jTabelaAprovacao.getColumnModel().getColumn(5).setPreferredWidth(300);
        jTabelaAprovacao.getColumnModel().getColumn(5).setResizable(false);
        jTabelaAprovacao.getTableHeader().setReorderingAllowed(false);
        jTabelaAprovacao.setAutoResizeMode(jTabelaAprovacao.AUTO_RESIZE_OFF);
        jTabelaAprovacao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
        jTabelaAprovacao.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaAprovacao.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaAprovacao.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        jTabelaAprovacao.getColumnModel().getColumn(3).setCellRenderer(centralizado);
    }

    public void limparTabelaSolicitacao() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Dt.Sol.", "Status Sol.", "Código Sol.", "Aprovador", "Observação"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaAprovacao.setModel(modelo);
        jTabelaAprovacao.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaAprovacao.getColumnModel().getColumn(0).setResizable(false);
        jTabelaAprovacao.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaAprovacao.getColumnModel().getColumn(1).setResizable(false);
        jTabelaAprovacao.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaAprovacao.getColumnModel().getColumn(2).setResizable(false);
        jTabelaAprovacao.getColumnModel().getColumn(3).setPreferredWidth(70);
        jTabelaAprovacao.getColumnModel().getColumn(3).setResizable(false);
        jTabelaAprovacao.getColumnModel().getColumn(4).setPreferredWidth(300);
        jTabelaAprovacao.getColumnModel().getColumn(4).setResizable(false);
        jTabelaAprovacao.getColumnModel().getColumn(5).setPreferredWidth(300);
        jTabelaAprovacao.getColumnModel().getColumn(5).setResizable(false);
        jTabelaAprovacao.getTableHeader().setReorderingAllowed(false);
        jTabelaAprovacao.setAutoResizeMode(jTabelaAprovacao.AUTO_RESIZE_OFF);
        jTabelaAprovacao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void preencherTabelaItens(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Descrição Produto", "UN", "Qtd.", "Vl. Item", "Vl. Total"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            //          count = 0;
            do {
                //          count = count + 1;
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
                //   jtotalItens.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela 
                dados.add(new Object[]{conecta.rs.getInt("IdProd"), conecta.rs.getString("DescricaoProd"), conecta.rs.getString("UnidadeProd"), qtdItemTab, valorUnitario2, valorTotalSoli1});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaItensSolicitacao.setModel(modelo);
        jTabelaItensSolicitacao.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaItensSolicitacao.getColumnModel().getColumn(0).setResizable(false);
        jTabelaItensSolicitacao.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTabelaItensSolicitacao.getColumnModel().getColumn(1).setResizable(false);
        jTabelaItensSolicitacao.getColumnModel().getColumn(2).setPreferredWidth(50);
        jTabelaItensSolicitacao.getColumnModel().getColumn(2).setResizable(false);
        jTabelaItensSolicitacao.getColumnModel().getColumn(3).setPreferredWidth(50);
        jTabelaItensSolicitacao.getColumnModel().getColumn(3).setResizable(false);
        jTabelaItensSolicitacao.getColumnModel().getColumn(4).setPreferredWidth(50);
        jTabelaItensSolicitacao.getColumnModel().getColumn(4).setResizable(false);
        jTabelaItensSolicitacao.getColumnModel().getColumn(5).setPreferredWidth(70);
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
        jTabelaItensSolicitacao.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        jTabelaItensSolicitacao.getColumnModel().getColumn(3).setCellRenderer(direita);
        jTabelaItensSolicitacao.getColumnModel().getColumn(4).setCellRenderer(direita);
        jTabelaItensSolicitacao.getColumnModel().getColumn(5).setCellRenderer(direita);
    }

    public void limparTabelaItens() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Descrição Produto", "UN", "Qtd.", "Vl. Item", "Vl. Total"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaItensSolicitacao.setModel(modelo);
        jTabelaItensSolicitacao.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaItensSolicitacao.getColumnModel().getColumn(0).setResizable(false);
        jTabelaItensSolicitacao.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTabelaItensSolicitacao.getColumnModel().getColumn(1).setResizable(false);
        jTabelaItensSolicitacao.getColumnModel().getColumn(2).setPreferredWidth(50);
        jTabelaItensSolicitacao.getColumnModel().getColumn(2).setResizable(false);
        jTabelaItensSolicitacao.getColumnModel().getColumn(3).setPreferredWidth(50);
        jTabelaItensSolicitacao.getColumnModel().getColumn(3).setResizable(false);
        jTabelaItensSolicitacao.getColumnModel().getColumn(4).setPreferredWidth(50);
        jTabelaItensSolicitacao.getColumnModel().getColumn(4).setResizable(false);
        jTabelaItensSolicitacao.getColumnModel().getColumn(5).setPreferredWidth(70);
        jTabelaItensSolicitacao.getColumnModel().getColumn(5).setResizable(false);
        jTabelaItensSolicitacao.getTableHeader().setReorderingAllowed(false);
        jTabelaItensSolicitacao.setAutoResizeMode(jTabelaItensSolicitacao.AUTO_RESIZE_OFF);
        jTabelaItensSolicitacao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void preencherTabelaItensAprovado(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Descrição Produto", "UN", "Qtd.", "Vl. Item", "Vl. Total"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            //          count = 0;
            do {
                //          count = count + 1;
                qtdItem = conecta.rs.getFloat("QtdAprova");
                DecimalFormat vi = new DecimalFormat("#,##0.00");
                String vqtdItem = vi.format(qtdItem);
                qtdItemTab = vqtdItem;
                //
                valorUnitario1 = conecta.rs.getFloat("ValorUnitario");
                DecimalFormat vu1 = new DecimalFormat("#,##0.00");
                String valorUnitarioP = vu1.format(valorUnitario1);
                valorUnitario2 = valorUnitarioP;
                //
                valorTotalSoli = conecta.rs.getFloat("ValorTotal");
                DecimalFormat vut = new DecimalFormat("#,##0.00");
                String valorTotalP = vut.format(valorTotalSoli);
                valorTotalSoli1 = valorTotalP;
                //   jtotalItens.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela 
                dados.add(new Object[]{conecta.rs.getInt("IdProd"), conecta.rs.getString("DescricaoProd"), conecta.rs.getString("UnidadeProd"), qtdItemTab, valorUnitario2, valorTotalSoli1});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaItensAprovado.setModel(modelo);
        jTabelaItensAprovado.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaItensAprovado.getColumnModel().getColumn(0).setResizable(false);
        jTabelaItensAprovado.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTabelaItensAprovado.getColumnModel().getColumn(1).setResizable(false);
        jTabelaItensAprovado.getColumnModel().getColumn(2).setPreferredWidth(50);
        jTabelaItensAprovado.getColumnModel().getColumn(2).setResizable(false);
        jTabelaItensAprovado.getColumnModel().getColumn(3).setPreferredWidth(50);
        jTabelaItensAprovado.getColumnModel().getColumn(3).setResizable(false);
        jTabelaItensAprovado.getColumnModel().getColumn(4).setPreferredWidth(50);
        jTabelaItensAprovado.getColumnModel().getColumn(4).setResizable(false);
        jTabelaItensAprovado.getColumnModel().getColumn(5).setPreferredWidth(70);
        jTabelaItensAprovado.getColumnModel().getColumn(5).setResizable(false);
        jTabelaItensAprovado.getTableHeader().setReorderingAllowed(false);
        jTabelaItensAprovado.setAutoResizeMode(jTabelaItensAprovado.AUTO_RESIZE_OFF);
        jTabelaItensAprovado.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposItensTabelaAprovacao();
        conecta.desconecta();
    }

    public void alinharCamposItensTabelaAprovacao() {
        //
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //        
        jTabelaItensAprovado.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaItensAprovado.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        jTabelaItensAprovado.getColumnModel().getColumn(3).setCellRenderer(direita);
        jTabelaItensAprovado.getColumnModel().getColumn(4).setCellRenderer(direita);
        jTabelaItensAprovado.getColumnModel().getColumn(5).setCellRenderer(direita);
    }

    public void limparTabelaItensAprovacao() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Descrição Produto", "UN", "Qtd.", "Vl. Item", "Vl. Total"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaItensAprovado.setModel(modelo);
        jTabelaItensAprovado.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaItensAprovado.getColumnModel().getColumn(0).setResizable(false);
        jTabelaItensAprovado.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTabelaItensAprovado.getColumnModel().getColumn(1).setResizable(false);
        jTabelaItensAprovado.getColumnModel().getColumn(2).setPreferredWidth(50);
        jTabelaItensAprovado.getColumnModel().getColumn(2).setResizable(false);
        jTabelaItensAprovado.getColumnModel().getColumn(3).setPreferredWidth(50);
        jTabelaItensAprovado.getColumnModel().getColumn(3).setResizable(false);
        jTabelaItensAprovado.getColumnModel().getColumn(4).setPreferredWidth(50);
        jTabelaItensAprovado.getColumnModel().getColumn(4).setResizable(false);
        jTabelaItensAprovado.getColumnModel().getColumn(5).setPreferredWidth(70);
        jTabelaItensAprovado.getColumnModel().getColumn(5).setResizable(false);
        jTabelaItensAprovado.getTableHeader().setReorderingAllowed(false);
        jTabelaItensAprovado.setAutoResizeMode(jTabelaItensAprovado.AUTO_RESIZE_OFF);
        jTabelaItensAprovado.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jIdAprova.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog2() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela2);
        objLogSys.setIdLancMov(Integer.valueOf(jIdAprova.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog3() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela3);
        objLogSys.setIdLancMov(Integer.valueOf(jIdAprova.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void buscarAcessoUsuario(String nomeTelaAcesso) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nameUser + "'");
            conecta.rs.first();
            codigoUserADM = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUserADM + "'");
            conecta.rs.first();
            codigoUserGroupADM = conecta.rs.getInt("IdUsuario");
            codigoGrupoADM = conecta.rs.getInt("IdGrupo");
            nomeGrupoADM = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUserADM + "' "
                    + "AND NomeTela='" + nomeTelaAcesso + "'");
            conecta.rs.first();
            codUserAcessoADM = conecta.rs.getInt("IdUsuario");
            codAbrirADM = conecta.rs.getInt("Abrir");
            codIncluirADM = conecta.rs.getInt("Incluir");
            codAlterarADM = conecta.rs.getInt("Alterar");
            codExcluirADM = conecta.rs.getInt("Excluir");
            codGravarADM = conecta.rs.getInt("Gravar");
            codConsultarADM = conecta.rs.getInt("Consultar");
            nomeTelaADM = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
