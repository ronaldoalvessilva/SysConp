/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleHistoricoMovimentacaoENF;
import gestor.Controle.ControleItensRequisicaoMedicamentosInternos;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControleRequisicaoMedicamentosInternos;
import gestor.Modelo.RequiscaoProdutosInternos;
import gestor.Dao.ConexaoBancoDados;
import Utilitarios.LimiteDigitosSoNum;
import Utilitarios.ModeloTabela;
import gestor.Modelo.HistoricoMovimentacaoEstoque;
import gestor.Modelo.ItensRequisicaoMateriaisInternos;
import gestor.Modelo.LogSistema;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloEnfermaria.telaRequisicaoMedicaInterItensENF;
import static gestor.Visao.TelaModuloEnfermaria.telaRequisicaoMedicaInterManuENF;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import java.awt.Color;
import java.awt.Image;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Currency;
import java.util.HashMap;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import static gestor.Visao.TelaModuloEnfermaria.codigoUserENF;
import static gestor.Visao.TelaModuloEnfermaria.codUserAcessoENF;
import static gestor.Visao.TelaModuloEnfermaria.codigoUserGroupENF;
import static gestor.Visao.TelaModuloEnfermaria.codAbrirENF;
import static gestor.Visao.TelaModuloEnfermaria.codIncluirENF;
import static gestor.Visao.TelaModuloEnfermaria.codAlterarENF;
import static gestor.Visao.TelaModuloEnfermaria.codExcluirENF;
import static gestor.Visao.TelaModuloEnfermaria.codGravarENF;
import static gestor.Visao.TelaModuloEnfermaria.codConsultarENF;
import static gestor.Visao.TelaModuloEnfermaria.codigoGrupoENF;
import static gestor.Visao.TelaModuloEnfermaria.nomeGrupoENF;
import static gestor.Visao.TelaModuloEnfermaria.nomeTelaENF;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;

/**
 *
 * @author Ronaldo
 */
public class TelaRequisicaoMedicamentosInternos extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    RequiscaoProdutosInternos objReqMatInter = new RequiscaoProdutosInternos();
    ItensRequisicaoMateriaisInternos objItensReqMatInter = new ItensRequisicaoMateriaisInternos();
    ControleRequisicaoMedicamentosInternos control = new ControleRequisicaoMedicamentosInternos();
    ControleItensRequisicaoMedicamentosInternos controle = new ControleItensRequisicaoMedicamentosInternos();
    //    
    HistoricoMovimentacaoEstoque objHistMovAC = new HistoricoMovimentacaoEstoque();
    ControleHistoricoMovimentacaoENF controlHistENF = new ControleHistoricoMovimentacaoENF();
    //   
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela = "Enfermaria:Requisição de Medicamentos Interno:Manutenção";
    String nomeModuloTela2 = "Enfermaria:Requisição de Medicamentos Interno:Itens";
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
    public static String caminho, caminho1;
    int codProd;
    int codEstoque;
    float saldoEstoque;
    float estoqueAtual = 0;
    String loteEstoque;
    public static String idItem;
    public static int idLocal;
    String tipoOpercao = "R";
    String nomeOperacao = "Requisição de Medicamentos para Internos";
    double qtdEstoque = 0;
    String codRequisicao;
    double valorUnitario = 0;
    float valorTotalItem = 0;
    double valorUnitario1 = 0;
    String valorUnitario2;
    double valorTotalItem2 = 0;
    String estornoProduto = "Não";
    String atendReq = "Sim";
    int qdtDoses = 0;
    String statusReqAtend = "Não Atendido";
    public static int tipoA;
    int idPrescricao;
    String modulo = "F";

    /**
     * Creates new form TelaRequisicaoMateriaisInternos
     */
    public TelaRequisicaoMedicamentosInternos() {
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

        btGrupoPrescricao = new javax.swing.ButtonGroup();
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
        jTabelaRequisicoes = new javax.swing.JTable();
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
        jCodReq = new javax.swing.JTextField();
        jStatusReq = new javax.swing.JTextField();
        jDataReq = new com.toedter.calendar.JDateChooser();
        jIdLocal = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jBtPesqLocalArmazenamento = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jObservacao = new javax.swing.JTextArea();
        jBtFinalizar = new javax.swing.JButton();
        jBtImprimirRequisicao = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jBtNovo = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jBtAuditoria = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel13 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jCodInterno = new javax.swing.JTextField();
        jBtPesqInternosRequisicao = new javax.swing.JButton();
        jMatriculaPenal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jNomeInternoReq = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPavilhaoReq = new javax.swing.JTextField();
        jCelaReq = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jFotoInternoReq = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jStatusAprazamento = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jCodFuncReq = new javax.swing.JTextField();
        jMatriculaReq = new javax.swing.JTextField();
        jNomeColaboradorReq = new javax.swing.JTextField();
        jDepartamentoFuncReq = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jFotoRequisitante = new javax.swing.JLabel();
        jBtPesqColaboradorReq = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jIdPrescricao = new javax.swing.JTextField();
        jDataPrescricao = new com.toedter.calendar.JDateChooser();
        jBtPrescricaoMedica = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextoPrescricaoMedica = new javax.swing.JTextArea();
        jRadioBtMedico = new javax.swing.JRadioButton();
        jRadioBtPsiquiatrico = new javax.swing.JRadioButton();
        jRadioBtOdontologia = new javax.swing.JRadioButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jCodProduto = new javax.swing.JTextField();
        jCodigoBarras = new javax.swing.JTextField();
        jLote = new javax.swing.JTextField();
        jDescricaoProduto = new javax.swing.JTextField();
        jDataVctoLote = new com.toedter.calendar.JDateChooser();
        jBtPesqProduto = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jQtdItem = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jComboBoxUnidade = new javax.swing.JComboBox();
        jtotalItens = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jValorUnitarioItem = new javax.swing.JFormattedTextField();
        jValorTotalItem = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabelaItensRequisicao = new javax.swing.JTable();
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
        setTitle("...::: Requisição de Medicamentos para Internos :::...");

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
                .addGap(29, 29, 29)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel74)
                            .addComponent(jLabel72)
                            .addComponent(jLabel70))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(jLabel73)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDataPesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jCodigoReq, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqCodigoReq, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqDatas, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBoxTodosReq))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel74)
                    .addComponent(jBtPesqInterno))
                .addContainerGap())
        );

        jTabelaRequisicoes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaRequisicoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Código", "Dt.Req.", "Status Req.", "Nome Completo do Interno"
            }
        ));
        jTabelaRequisicoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaRequisicoesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTabelaRequisicoes);
        if (jTabelaRequisicoes.getColumnModel().getColumnCount() > 0) {
            jTabelaRequisicoes.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaRequisicoes.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaRequisicoes.getColumnModel().getColumn(1).setMinWidth(80);
            jTabelaRequisicoes.getColumnModel().getColumn(1).setMaxWidth(80);
            jTabelaRequisicoes.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaRequisicoes.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaRequisicoes.getColumnModel().getColumn(3).setMinWidth(380);
            jTabelaRequisicoes.getColumnModel().getColumn(3).setMaxWidth(380);
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
                    .addComponent(jScrollPane3)
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
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
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
        jLabel3.setText("Data Requisição");

        jCodReq.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodReq.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCodReq.setEnabled(false);

        jStatusReq.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jStatusReq.setForeground(new java.awt.Color(153, 0, 102));
        jStatusReq.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jStatusReq.setDisabledTextColor(new java.awt.Color(153, 0, 153));
        jStatusReq.setEnabled(false);

        jDataReq.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataReq.setEnabled(false);

        jIdLocal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jIdLocal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdLocal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdLocal.setDisabledTextColor(new java.awt.Color(0, 0, 255));
        jIdLocal.setEnabled(false);

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 255));
        jLabel23.setText("Local Estoque");

        jBtPesqLocalArmazenamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqLocalArmazenamento.setContentAreaFilled(false);
        jBtPesqLocalArmazenamento.setEnabled(false);
        jBtPesqLocalArmazenamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqLocalArmazenamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jCodReq, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jStatusReq, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDataReq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jIdLocal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqLocalArmazenamento, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtPesqLocalArmazenamento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataReq, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jStatusReq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCodReq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Observação", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jObservacao.setColumns(20);
        jObservacao.setRows(5);
        jObservacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jObservacao.setEnabled(false);
        jScrollPane1.setViewportView(jObservacao);

        jBtFinalizar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtFinalizar.setForeground(new java.awt.Color(0, 153, 0));
        jBtFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/accept.png"))); // NOI18N
        jBtFinalizar.setText("Finalizar");
        jBtFinalizar.setEnabled(false);
        jBtFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFinalizarActionPerformed(evt);
            }
        });

        jBtImprimirRequisicao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtImprimirRequisicao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/gtklp-icone-3770-16.png"))); // NOI18N
        jBtImprimirRequisicao.setText("Impressão");
        jBtImprimirRequisicao.setToolTipText("Imprimir Requisição");
        jBtImprimirRequisicao.setEnabled(false);
        jBtImprimirRequisicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtImprimirRequisicaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBtImprimirRequisicao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtFinalizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jBtFinalizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtImprimirRequisicao)
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

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

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
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
                .addComponent(jBtAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(jBtAuditoria)
                .addComponent(jBtSair)
                .addComponent(jBtCancelar)
                .addComponent(jBtSalvar)
                .addComponent(jBtExcluir)
                .addComponent(jBtAlterar)
                .addComponent(jBtNovo))
        );

        jTabbedPane2.setForeground(new java.awt.Color(255, 0, 0));
        jTabbedPane2.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Código");

        jCodInterno.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCodInterno.setEnabled(false);

        jBtPesqInternosRequisicao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqInternosRequisicao.setToolTipText("Pesquisar Interno");
        jBtPesqInternosRequisicao.setContentAreaFilled(false);
        jBtPesqInternosRequisicao.setEnabled(false);
        jBtPesqInternosRequisicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqInternosRequisicaoActionPerformed(evt);
            }
        });

        jMatriculaPenal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jMatriculaPenal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMatriculaPenal.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Matricula Penal");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Nome Completo do Interno");

        jNomeInternoReq.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoReq.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Pavilhão");

        jPavilhaoReq.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPavilhaoReq.setEnabled(false);

        jCelaReq.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCelaReq.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Cela");

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Foto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoReq, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoReq, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 0, 0));
        jLabel22.setText("Aprazamento");

        jStatusAprazamento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jStatusAprazamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jStatusAprazamento.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        jStatusAprazamento.setEnabled(false);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jCodInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqInternosRequisicao, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jMatriculaPenal))
                            .addComponent(jLabel6)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(53, 53, 53)
                                .addComponent(jLabel5)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jStatusAprazamento)
                                .addGap(10, 10, 10))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jPavilhaoReq, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCelaReq, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)))
                            .addComponent(jNomeInternoReq))
                        .addGap(10, 10, 10)))
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jStatusAprazamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jMatriculaPenal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqInternosRequisicao)
                    .addComponent(jCodInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNomeInternoReq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPavilhaoReq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCelaReq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Interno", jPanel13);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Código");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Matricula");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Nome Completo do Colaborado Requisitante");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Departamento");

        jCodFuncReq.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodFuncReq.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCodFuncReq.setEnabled(false);

        jMatriculaReq.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jMatriculaReq.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMatriculaReq.setEnabled(false);

        jNomeColaboradorReq.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeColaboradorReq.setEnabled(false);

        jDepartamentoFuncReq.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDepartamentoFuncReq.setEnabled(false);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Foto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoRequisitante, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoRequisitante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jBtPesqColaboradorReq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqColaboradorReq.setContentAreaFilled(false);
        jBtPesqColaboradorReq.setEnabled(false);
        jBtPesqColaboradorReq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqColaboradorReqActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addComponent(jCodFuncReq, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jBtPesqColaboradorReq, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jMatriculaReq, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18)))
                            .addComponent(jLabel20))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jNomeColaboradorReq)
                    .addComponent(jDepartamentoFuncReq))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtPesqColaboradorReq)
                    .addComponent(jCodFuncReq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jMatriculaReq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNomeColaboradorReq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addGap(11, 11, 11)
                .addComponent(jDepartamentoFuncReq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Requisitante", jPanel14);

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setText("Código:");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setText("Data:");

        jIdPrescricao.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdPrescricao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdPrescricao.setEnabled(false);

        jDataPrescricao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataPrescricao.setEnabled(false);

        jBtPrescricaoMedica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPrescricaoMedica.setContentAreaFilled(false);
        jBtPrescricaoMedica.setEnabled(false);
        jBtPrescricaoMedica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPrescricaoMedicaActionPerformed(evt);
            }
        });

        jTextoPrescricaoMedica.setColumns(20);
        jTextoPrescricaoMedica.setRows(5);
        jTextoPrescricaoMedica.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextoPrescricaoMedica.setEnabled(false);
        jScrollPane4.setViewportView(jTextoPrescricaoMedica);

        btGrupoPrescricao.add(jRadioBtMedico);
        jRadioBtMedico.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioBtMedico.setForeground(new java.awt.Color(255, 0, 0));
        jRadioBtMedico.setText("P.Médica");
        jRadioBtMedico.setEnabled(false);

        btGrupoPrescricao.add(jRadioBtPsiquiatrico);
        jRadioBtPsiquiatrico.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioBtPsiquiatrico.setForeground(new java.awt.Color(0, 51, 255));
        jRadioBtPsiquiatrico.setText("P.Psi.");
        jRadioBtPsiquiatrico.setEnabled(false);

        btGrupoPrescricao.add(jRadioBtOdontologia);
        jRadioBtOdontologia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioBtOdontologia.setForeground(new java.awt.Color(51, 153, 0));
        jRadioBtOdontologia.setText("P.Od.");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jIdPrescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataPrescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioBtMedico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioBtPsiquiatrico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioBtOdontologia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                        .addComponent(jBtPrescricaoMedica, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jDataPrescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(jIdPrescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(jRadioBtMedico)
                    .addComponent(jRadioBtPsiquiatrico)
                    .addComponent(jBtPrescricaoMedica)
                    .addComponent(jRadioBtOdontologia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Prescrição Médica", jPanel12);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );

        jTabbedPane1.addTab("Manutenção", jPanel2);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Código");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Código Barras");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Lote");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Data Vcto. Lote");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Descrição do Produto");

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

        jLote.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jLote.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLote.setEnabled(false);

        jDescricaoProduto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDescricaoProduto.setEnabled(false);

        jDataVctoLote.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataVctoLote.setEnabled(false);

        jBtPesqProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqProduto.setContentAreaFilled(false);
        jBtPesqProduto.setEnabled(false);
        jBtPesqProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqProdutoActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("UN");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Qtde.");

        jQtdItem.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jQtdItem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQtdItem.setEnabled(false);
        jQtdItem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jQtdItemFocusLost(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Valor Unit.");

        jComboBoxUnidade.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxUnidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "UN", "Caixa", "Pacote", "Ml", "Kg", "Litro", "Peça", "Amp", "Kit", "PR", "Un" }));
        jComboBoxUnidade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxUnidade.setEnabled(false);

        jtotalItens.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jtotalItens.setForeground(new java.awt.Color(255, 0, 0));
        jtotalItens.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Itens");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setText("Valor Total");

        jValorUnitarioItem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jValorUnitarioItem.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jValorUnitarioItem.setEnabled(false);

        jValorTotalItem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jValorTotalItem.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jValorTotalItem.setEnabled(false);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(jCodProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jBtPesqProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jCodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(0, 86, Short.MAX_VALUE))
                                    .addComponent(jLote))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDataVctoLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jDescricaoProduto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14)
                                            .addComponent(jComboBoxUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jQtdItem, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                            .addComponent(jLabel15))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel16)
                                            .addComponent(jValorUnitarioItem, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jValorTotalItem, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel24))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jtotalItens, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel21))))
                                .addGap(0, 4, Short.MAX_VALUE)))
                        .addGap(17, 17, 17))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)))
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jCodProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtPesqProduto)
                            .addComponent(jCodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDataVctoLote, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDescricaoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel21)
                            .addComponent(jLabel24))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jComboBoxUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jQtdItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jValorUnitarioItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jValorTotalItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.CENTER, jPanel9Layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jtotalItens, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jTabelaItensRequisicao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaItensRequisicao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Item", "Código", "Descrição Produto", "Qtd.", "Vl. Item"
            }
        ));
        jTabelaItensRequisicao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaItensRequisicaoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTabelaItensRequisicao);
        if (jTabelaItensRequisicao.getColumnModel().getColumnCount() > 0) {
            jTabelaItensRequisicao.getColumnModel().getColumn(0).setMinWidth(40);
            jTabelaItensRequisicao.getColumnModel().getColumn(0).setMaxWidth(40);
            jTabelaItensRequisicao.getColumnModel().getColumn(1).setMinWidth(50);
            jTabelaItensRequisicao.getColumnModel().getColumn(1).setMaxWidth(50);
            jTabelaItensRequisicao.getColumnModel().getColumn(2).setMinWidth(300);
            jTabelaItensRequisicao.getColumnModel().getColumn(2).setMaxWidth(300);
            jTabelaItensRequisicao.getColumnModel().getColumn(3).setMinWidth(50);
            jTabelaItensRequisicao.getColumnModel().getColumn(3).setMaxWidth(50);
            jTabelaItensRequisicao.getColumnModel().getColumn(4).setMinWidth(50);
            jTabelaItensRequisicao.getColumnModel().getColumn(4).setMaxWidth(50);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaItem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(jBtNovoItem)
                .addComponent(jBtAlterarItem)
                .addComponent(jBtExcluirItem)
                .addComponent(jBtSalvarItem)
                .addComponent(jBtCancelarItem)
                .addComponent(jBtSairItem)
                .addComponent(jBtAuditoriaItem))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Produtos", jPanel8);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(300, 20, 528, 501);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesqCodigoReqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqCodigoReqActionPerformed
        // TODO add your handling code here:
        if (jCodReq.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um código para pesquisa.");
        } else {
            jTabelaRequisicoes.setVisible(true);
            pesquisarRequisicaoMateriais("SELECT * FROM REQUISICAO_PRODUTOS_INTERNOS_ENF "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON REQUISICAO_PRODUTOS_INTERNOS_ENF.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN COLABORADOR "
                    + "ON REQUISICAO_PRODUTOS_INTERNOS_ENF.IdFunc=COLABORADOR.IdFunc "
                    + "WHERE IdReq='" + jCodigoReq.getText() + "'");
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
                        jTabelaRequisicoes.setVisible(true);
                        pesquisarRequisicaoMateriais("SELECT * FROM REQUISICAO_PRODUTOS_INTERNOS_ENF "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON REQUISICAO_PRODUTOS_INTERNOS_ENF.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                + "INNER JOIN COLABORADOR "
                                + "ON REQUISICAO_PRODUTOS_INTERNOS_ENF.IdFunc=COLABORADOR.IdFunc "
                                + "WHERE DataReq BETWEEN'" + dataInicial + "' "
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
                        jTabelaRequisicoes.setVisible(true);
                        pesquisarRequisicaoMateriais("SELECT * FROM REQUISICAO_PRODUTOS_INTERNOS_ENF "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON REQUISICAO_PRODUTOS_INTERNOS_ENF.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                + "INNER JOIN COLABORADOR "
                                + "ON REQUISICAO_PRODUTOS_INTERNOS_ENF.IdFunc=COLABORADOR.IdFunc "
                                + "WHERE DataReq BETWEEN'" + dataInicial + "'AND '" + dataFinal + "'");
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
            jTabelaRequisicoes.setVisible(true);
            this.pesquisarRequisicaoMateriais("SELECT * FROM REQUISICAO_PRODUTOS_INTERNOS_ENF "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON REQUISICAO_PRODUTOS_INTERNOS_ENF.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN COLABORADOR "
                    + "ON REQUISICAO_PRODUTOS_INTERNOS_ENF.IdFunc=COLABORADOR.IdFunc ");
        } else {
            jtotalRegistros.setText("");
            limparTabelaRequsicoes();
        }
    }//GEN-LAST:event_jCheckBoxTodosReqItemStateChanged

    private void jBtPesqInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqInternoActionPerformed
        // TODO add your handling code here:
        if (jNomeInterno.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um nome para pesquisa.");
        } else {
            jTabelaRequisicoes.setVisible(true);
            pesquisarRequisicaoMateriais("SELECT * FROM REQUISICAO_PRODUTOS_INTERNOS_ENF "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON REQUISICAO_PRODUTOS_INTERNOS_ENF.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN COLABORADOR "
                    + "ON REQUISICAO_PRODUTOS_INTERNOS_ENF.IdFunc=COLABORADOR.IdFunc "
                    + "WHERE PRONTUARIOSCRC.NomeInternoCrc LIKE'%" + jNomeInterno.getText() + "%'");
        }
    }//GEN-LAST:event_jBtPesqInternoActionPerformed

    private void jTabelaRequisicoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaRequisicoesMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String IdLanc = "" + jTabelaRequisicoes.getValueAt(jTabelaRequisicoes.getSelectedRow(), 0);
            jCodigoReq.setText(IdLanc);
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtNovoItem.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            jBtImprimirRequisicao.setEnabled(true);
            jBtPrescricaoMedica.setEnabled(!true);
            //            
            jCodProduto.setText("");
            jCodigoBarras.setText("");
            jLote.setText("");
            jDescricaoProduto.setText("");
            jComboBoxUnidade.setSelectedItem(null);
            jQtdItem.setText("");
            jValorUnitarioItem.setText("");
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM REQUISICAO_PRODUTOS_INTERNOS_ENF "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON REQUISICAO_PRODUTOS_INTERNOS_ENF.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "INNER JOIN COLABORADOR "
                        + "ON REQUISICAO_PRODUTOS_INTERNOS_ENF.IdFunc=COLABORADOR.IdFunc "
                        + "INNER JOIN DEPARTAMENTOS "
                        + "ON COLABORADOR.IdDepartamento=COLABORADOR.IdDepartamento "
                        + "INNER JOIN PRESCRICAO_MEDICA_PSIQUIATRICA "
                        + "ON REQUISICAO_PRODUTOS_INTERNOS_ENF.IdItem=PRESCRICAO_MEDICA_PSIQUIATRICA.IdItem "
                        + "WHERE REQUISICAO_PRODUTOS_INTERNOS_ENF.IdReq='" + IdLanc + "'");
                conecta.rs.first();
                jCodReq.setText(String.valueOf(conecta.rs.getInt("IdReq")));
                jStatusReq.setText(conecta.rs.getString("StatusReq"));
                jStatusAprazamento.setText(conecta.rs.getString("StatusReqAtend"));
                jDataReq.setDate(conecta.rs.getDate("DataReq"));
                jIdLocal.setText(conecta.rs.getString("IdLocal"));
                jIdPrescricao.setText(conecta.rs.getString("IdItem"));
                jDataPrescricao.setDate(conecta.rs.getDate("DataPres"));
                idPrescricao = conecta.rs.getInt("IdPres");
                if (idPrescricao == 0) {
                    jRadioBtMedico.setSelected(true);
                } else if (idPrescricao == 1) {
                    jRadioBtPsiquiatrico.setSelected(true);
                }
                jTextoPrescricaoMedica.setText(conecta.rs.getString("TextoPrescricao"));
                jCodInterno.setText(conecta.rs.getString("IdInternoCrc"));
                jMatriculaPenal.setText(conecta.rs.getString("MatriculaCrc"));
                jNomeInternoReq.setText(conecta.rs.getString("NomeInternoCrc"));
                jPavilhaoReq.setText(conecta.rs.getString("DescricaoPavilhao"));
                jCelaReq.setText(conecta.rs.getString("DescricaoCela"));
                // FOTO DO INTERNO
                caminho = conecta.rs.getString("FotoInternoCrc");
                javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                jFotoInternoReq.setIcon(i);
                jFotoInternoReq.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoInternoReq.getWidth(), jFotoInternoReq.getHeight(), Image.SCALE_DEFAULT)));
                //              
                jCodFuncReq.setText(conecta.rs.getString("IdFunc"));
                jMatriculaReq.setText(conecta.rs.getString("MatriculaFunc"));
                jNomeColaboradorReq.setText(conecta.rs.getString("NomeFunc"));
                jDepartamentoFuncReq.setText(conecta.rs.getString("NomeDepartamento"));
                // FOTO REQUISITANTE
                caminho1 = conecta.rs.getString("ImagemFunc");
                javax.swing.ImageIcon a = new javax.swing.ImageIcon(caminho1);
                jFotoRequisitante.setIcon(a);
                jFotoRequisitante.setIcon(new ImageIcon(a.getImage().getScaledInstance(jFotoRequisitante.getWidth(), jFotoRequisitante.getHeight(), Image.SCALE_DEFAULT)));
                //  
                jObservacao.setText(conecta.rs.getString("Observacao"));
                conecta.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "Não foi possível exibir registro.\nERRO: " + e);
            }
            count = 0;
            limparTabelaItens();
            preencherTabelaItens("SELECT * FROM ITENS_REQUISICAO_PRODUTOS_INTERNOS_ENF "
                    + "INNER JOIN REQUISICAO_PRODUTOS_INTERNOS_ENF "
                    + "ON ITENS_REQUISICAO_PRODUTOS_INTERNOS_ENF.IdReq=REQUISICAO_PRODUTOS_INTERNOS_ENF.IdReq "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON ITENS_REQUISICAO_PRODUTOS_INTERNOS_ENF.IdProd=PRODUTOS_AC.IdProd "
                    + "WHERE ITENS_REQUISICAO_PRODUTOS_INTERNOS_ENF.IdReq='" + jCodigoReq.getText() + "'");
        }
    }//GEN-LAST:event_jTabelaRequisicoesMouseClicked

    private void jBtPesqInternosRequisicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqInternosRequisicaoActionPerformed
        // TODO add your handling code here:
        TelaPesqInternoRequisicaoMed objPesqInternoReqMed = new TelaPesqInternoRequisicaoMed();
        TelaModuloEnfermaria.jPainelMedico.add(objPesqInternoReqMed);
        objPesqInternoReqMed.show();
    }//GEN-LAST:event_jBtPesqInternosRequisicaoActionPerformed

    private void jBtPesqColaboradorReqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqColaboradorReqActionPerformed
        // TODO add your handling code here:
        TelaPesquisaColabordorRequisicaoMed objFuncReqMed = new TelaPesquisaColabordorRequisicaoMed();
        TelaModuloEnfermaria.jPainelMedico.add(objFuncReqMed);
        objFuncReqMed.show();
    }//GEN-LAST:event_jBtPesqColaboradorReqActionPerformed

    private void jBtFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFinalizarActionPerformed
        // TODO add your handling code here:
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM REQUISICAO_PRODUTOS_INTERNOS_ENF WHERE IdReq='" + jCodReq.getText() + "'");
            conecta.rs.first();
            jStatusReq.setText(conecta.rs.getString("StatusReq"));
            if (jStatusReq.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Lançamento já foi finalizado");
            } else {
                Finalizar();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível verificar se lançamento foi finalizado\nERRO: " + ex);
        }
        conecta.desconecta();
    }//GEN-LAST:event_jBtFinalizarActionPerformed

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRequisicaoMedicaInterManuENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaRequisicaoMedicaInterManuENF) && codIncluirENF == 1) {
            acao = 1;
            Novo();
            corCampos();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            limparTabelaItens();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRequisicaoMedicaInterManuENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaRequisicaoMedicaInterManuENF) && codAlterarENF == 1) {
            objReqMatInter.setStatusReq(jStatusReq.getText());
            if (jStatusReq.getText().equals("FINALIZADO")) {
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
        buscarAcessoUsuario(telaRequisicaoMedicaInterManuENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaRequisicaoMedicaInterManuENF) && codExcluirENF == 1) {
            objReqMatInter.setStatusReq(jStatusReq.getText());
            if (jStatusReq.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser modificado, o mesmo encontra-se FINALIZADO");
            } else {
                statusMov = "Excluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
                verificarItensRequisitados();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRequisicaoMedicaInterManuENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaRequisicaoMedicaInterManuENF) && codGravarENF == 1) {
            if (jDataReq.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data da requisição.");
            } else if (jCodInterno.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome do interno para requisição.");
            } else if (jCodFuncReq.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome do requisitante.");
            } else if (jIdLocal.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o local de armazenamento dos produtos a requisitar.");
            } else if (jTextoPrescricaoMedica.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe a receita para o interno.");
            } else {
                objReqMatInter.setStatusReq(jStatusReq.getText());
                objReqMatInter.setDataReq(jDataReq.getDate());
                objReqMatInter.setStatusReqAtend(statusReqAtend);
                objReqMatInter.setIdLocal(Integer.valueOf(jIdLocal.getText()));
                objReqMatInter.setNomeInternoReq(jNomeInternoReq.getText());
                objReqMatInter.setDescricaoPavilhao(jPavilhaoReq.getText());
                objReqMatInter.setDescricaoCela(jCelaReq.getText());
                objReqMatInter.setNomeColaboradorReq(jNomeColaboradorReq.getText());
                objReqMatInter.setIdItem(Integer.valueOf(jIdPrescricao.getText()));
                if (jRadioBtMedico.isSelected()) {
                    idPrescricao = 0;
                } else if (jRadioBtPsiquiatrico.isSelected()) {
                    idPrescricao = 1;
                }
                objReqMatInter.setIdPres(idPrescricao);
                objReqMatInter.setObservacao(jObservacao.getText());
                if (acao == 1) {
                    objReqMatInter.setUsuarioInsert(nameUser);
                    objReqMatInter.setDataInsert(dataModFinal);
                    objReqMatInter.setHorarioInsert(horaMov);
                    //
                    control.incluirRequisicaoMaterialInternos(objReqMatInter);
                    buscarCodigo();
                    //
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    Salvar();
                }
                if (acao == 2) {
                    objReqMatInter.setUsuarioUp(nameUser);
                    objReqMatInter.setDataUp(dataModFinal);
                    objReqMatInter.setHorarioUp(horaMov);
                    //
                    objReqMatInter.setIdReq(Integer.valueOf(jCodReq.getText()));
                    control.alterarRequisicaoMaterialInternos(objReqMatInter);
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

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtAuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaRequisicaoIntMed objAudiReqIntMed = new TelaAuditoriaRequisicaoIntMed();
        TelaModuloEnfermaria.jPainelMedico.add(objAudiReqIntMed);
        objAudiReqIntMed.show();
    }//GEN-LAST:event_jBtAuditoriaActionPerformed

    private void jBtPesqProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqProdutoActionPerformed
        // TODO add your handling code here:       
        TelaPesqProdutoRequisicaoMedicamentos objPesqProdReqMed = new TelaPesqProdutoRequisicaoMedicamentos();
        TelaModuloEnfermaria.jPainelMedico.add(objPesqProdReqMed);
        objPesqProdReqMed.show();
    }//GEN-LAST:event_jBtPesqProdutoActionPerformed

    private void jCodigoBarrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCodigoBarrasActionPerformed
        // TODO add your handling code here:       
        conecta.abrirConexao();
        conecta.executaSQL("SELECT * FROM PRODUTOS_AC "
                + "INNER JOIN LOCAL_ARMAZENAMENTO_AC "
                + "ON PRODUTOS_AC.IdLocal=LOCAL_ARMAZENAMENTO_AC.IdLocal "
                + "INNER JOIN LOTE_PRODUTOS_ENF "
                + "ON PRODUTOS_AC.IdProd=LOTE_PRODUTOS_ENF.IdProd "
                + "WHERE PRODUTOS_AC.CodigoBarra='" + jCodigoBarras.getText() + "'AND PRODUTOS_AC.StatusProd='" + statusProd + "'AND PRODUTOS_AC.Modulo='" + modulo + "'");
        try {
            if (conecta.rs.first()) {
                jCodProduto.setText(String.valueOf(conecta.rs.getInt("IdProd")));
                jDescricaoProduto.setText(conecta.rs.getString("DescricaoProd"));
                jCodigoBarras.setText(conecta.rs.getString("CodigoBarra"));
                jLote.setText(conecta.rs.getString("Lote"));
                jDataVctoLote.setDate(conecta.rs.getDate("DataVenc"));
                jValorUnitarioItem.setText(conecta.rs.getString("ValorCompra"));
                jComboBoxUnidade.setSelectedItem(conecta.rs.getString("UnidadeProd"));
            } else {
                JOptionPane.showMessageDialog(rootPane, "Produto não cadastro.");
            }
        } catch (SQLException ex) {
        }
        conecta.desconecta();
    }//GEN-LAST:event_jCodigoBarrasActionPerformed

    private void jTabelaItensRequisicaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaItensRequisicaoMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            String idProduto = "" + jTabelaItensRequisicao.getValueAt(jTabelaItensRequisicao.getSelectedRow(), 1);
            jCodProduto.setText(idProduto);
            String nomeProduto = "" + jTabelaItensRequisicao.getValueAt(jTabelaItensRequisicao.getSelectedRow(), 2);
            jDescricaoProduto.setText(nomeProduto);
            idItem = "" + jTabelaItensRequisicao.getValueAt(jTabelaItensRequisicao.getSelectedRow(), 0);
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
                conecta.executaSQL("SELECT * FROM ITENS_REQUISICAO_PRODUTOS_INTERNOS_ENF "
                        + "INNER JOIN PRODUTOS_AC "
                        + "ON ITENS_REQUISICAO_PRODUTOS_INTERNOS_ENF.IdProd=PRODUTOS_AC.IdProd "
                        + "INNER JOIN LOTE_PRODUTOS_ENF "
                        + "ON PRODUTOS_AC.IdProd=LOTE_PRODUTOS_ENF.IdProd "
                        + "WHERE ITENS_REQUISICAO_PRODUTOS_INTERNOS_ENF.IdReq='" + jCodReq.getText() + "'AND "
                        + "PRODUTOS_AC.DescricaoProd='" + jDescricaoProduto.getText() + "'AND ITENS_REQUISICAO_PRODUTOS_INTERNOS_ENF.IdItem='" + idItem + "'");
                conecta.rs.first();
                jCodProduto.setText(conecta.rs.getString("IdProd"));
                jDescricaoProduto.setText(conecta.rs.getString("DescricaoProd"));
                idItem = conecta.rs.getString("IdItem");
                jCodigoBarras.setText(conecta.rs.getString("CodigoBarra"));
                jDataVctoLote.setDate(conecta.rs.getDate("DataVenc"));
                jLote.setText(conecta.rs.getString("Lote"));
                jComboBoxUnidade.setSelectedItem(conecta.rs.getString("UnidadeProd"));
                // PEGA QUANTIDADE PARA CALCULAR SE O USUARIO ALTERAR A QUANTIDADE.
                qtdItemAnterior = conecta.rs.getFloat("QtdItem");
                qtdItem = conecta.rs.getFloat("QtdItem");
                DecimalFormat vi = new DecimalFormat(",###0.00");
                String vqtdItem = vi.format(qtdItem);
                jQtdItem.setText(vqtdItem);
                // Formata o valor para ser exibido na tela no formato BR                                                   
                valorUnitario = conecta.rs.getFloat("ValorUnitarioItem");
                DecimalFormat vu = new DecimalFormat(",###0.00");
                String vlUnitario = vu.format(valorUnitario);
                jValorUnitarioItem.setText(vlUnitario);
                //
                valorTotalItem2 = conecta.rs.getFloat("ValorTotalItem");
                DecimalFormat vti = new DecimalFormat(",###0.00");
                String vlTotalItem = vti.format(valorTotalItem2);
                jValorTotalItem.setText(vlTotalItem);
                //
                conecta.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "Não foi possível selecionar o registro.\nERRO: " + e);
            }
        }
    }//GEN-LAST:event_jTabelaItensRequisicaoMouseClicked

    private void jBtNovoItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoItemActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRequisicaoMedicaInterItensENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaRequisicaoMedicaInterItensENF) && codIncluirENF == 1) {
            objReqMatInter.setStatusReq(jStatusReq.getText());
            if (jStatusReq.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser modificado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 3;
                NovoItem();
                statusMov = "Incluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovoItemActionPerformed

    private void jBtAlterarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarItemActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRequisicaoMedicaInterItensENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaRequisicaoMedicaInterItensENF) && codAlterarENF == 1) {
            objReqMatInter.setStatusReq(jStatusReq.getText());
            if (jStatusReq.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser modificado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 4;
                AlterarItem();
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtAlterarItemActionPerformed

    private void jBtExcluirItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirItemActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRequisicaoMedicaInterItensENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaRequisicaoMedicaInterItensENF) && codExcluirENF == 1) {
            atendReq = "Não";
            objReqMatInter.setStatusReq(jStatusReq.getText());
            if (jStatusReq.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser modificado, o mesmo encontra-se FINALIZADO");
            } else {
                statusMov = "Excluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    objItensReqMatInter.setIdProd(Integer.valueOf(jCodProduto.getText()));
                    objItensReqMatInter.setLoteProduto(jLote.getText());
                    pegarSaldoEstoque(objItensReqMatInter.getIdProd(), objItensReqMatInter.getLoteProduto());
                    // CALCULA O NOVO SALDO DE ESTOQUE
                    estoqueAtual = saldoEstoque + objItensReqMatInter.getQtdItem();
                    //
                    objItensReqMatInter.setIdProd(Integer.valueOf(jCodProduto.getText()));
                    objItensReqMatInter.setLoteProduto(jLote.getText());
                    objItensReqMatInter.setQtdItem(estoqueAtual);
                    controle.alterarEstoqueMaterais(objItensReqMatInter); // TABELA DE LOTE_PRODUTOS_AC                
                    //
                    objItensReqMatInter.setIdItem(Integer.valueOf(idItem));
                    controle.excluirRequisicaoMaterialInternos(objItensReqMatInter);
                    //
                    JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                    ExcluirItem();
                    preencherTabelaItens("SELECT * FROM ITENS_REQUISICAO_PRODUTOS_INTERNOS_ENF "
                            + "INNER JOIN REQUISICAO_PRODUTOS_INTERNOS_ENF "
                            + "ON ITENS_REQUISICAO_PRODUTOS_INTERNOS_ENF.IdReq=REQUISICAO_PRODUTOS_INTERNOS_ENF.IdReq "
                            + "INNER JOIN PRODUTOS_AC "
                            + "ON ITENS_REQUISICAO_PRODUTOS_INTERNOS_ENF.IdProd=PRODUTOS_AC.IdProd "
                            + "WHERE ITENS_REQUISICAO_PRODUTOS_INTERNOS_ENF.IdReq='" + jCodReq.getText() + "'");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirItemActionPerformed

    private void jBtSalvarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarItemActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRequisicaoMedicaInterItensENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaRequisicaoMedicaInterItensENF) && codGravarENF == 1) {
            DecimalFormat qtdReal = new DecimalFormat("###,##00.0");
            qtdReal.setCurrency(Currency.getInstance(new Locale("pt", "BR")));
            if (jCodProduto.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o produto para requisição.");
            } else if (jQtdItem.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe a quantidade");
            } else {
                objItensReqMatInter.setIdProd(Integer.valueOf(jCodProduto.getText()));
                objItensReqMatInter.setDescricaoProduto(jDescricaoProduto.getText());
                objItensReqMatInter.setIdReq(Integer.valueOf(jCodReq.getText()));
                objItensReqMatInter.setCodigoBarras(jCodigoBarras.getText());
                objItensReqMatInter.setLoteProduto(jLote.getText());
                objItensReqMatInter.setUnidadeProd((String) jComboBoxUnidade.getSelectedItem());
                objItensReqMatInter.setEstornoProduto(estornoProduto);
                objItensReqMatInter.setQtdDoses(qdtDoses);
                try {
                    objItensReqMatInter.setQtdItem(qtdReal.parse(jQtdItem.getText()).floatValue());
                    objItensReqMatInter.setValorUnitarioItem(qtdReal.parse(jValorUnitarioItem.getText()).floatValue());
                } catch (ParseException ex) {
                }
                // CALCULAR O VALOR TOTAL DO ITEM
                valorTotalItem = objItensReqMatInter.getQtdItem() * objItensReqMatInter.getValorUnitarioItem();
                objItensReqMatInter.setValorTotalItem(valorTotalItem);
                if (acao == 3) {
                    objItensReqMatInter.setUsuarioInsert(nameUser);
                    objItensReqMatInter.setDataInsert(dataModFinal);
                    objItensReqMatInter.setHorarioInsert(horaMov);
                    // PEGA PRODUTO PARA CALCULAR SALDO DE ESTOQUE
                    pegarSaldoEstoque(objItensReqMatInter.getIdProd(), objItensReqMatInter.getLoteProduto());
                    //
                    if (saldoEstoque >= objItensReqMatInter.getQtdItem()) {
                        // CALCULA O NOVO SALDO DE ESTOQUE
                        estoqueAtual = saldoEstoque - objItensReqMatInter.getQtdItem();
                        //
                        objItensReqMatInter.setIdProd(Integer.valueOf(jCodProduto.getText()));
                        objItensReqMatInter.setLoteProduto(jLote.getText());
                        objItensReqMatInter.setQtdItem(estoqueAtual);
                        controle.alterarEstoqueMaterais(objItensReqMatInter); // TABELA DE LOTE_PRODUTOS_AC                  
                        // GRAVAR REGISTRO NA TABELA ITENS_REQUISICAO_PRODUTOS_INTERNOS
                        objItensReqMatInter.setQtdItem(Float.valueOf(jQtdItem.getText()));
                        controle.incluirRequisicaoMaterialInternos(objItensReqMatInter);
                        //
                        objLog2();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        preencherTabelaItens("SELECT * FROM ITENS_REQUISICAO_PRODUTOS_INTERNOS_ENF "
                                + "INNER JOIN REQUISICAO_PRODUTOS_INTERNOS_ENF "
                                + "ON ITENS_REQUISICAO_PRODUTOS_INTERNOS_ENF.IdReq=REQUISICAO_PRODUTOS_INTERNOS_ENF.IdReq "
                                + "INNER JOIN PRODUTOS_AC "
                                + "ON ITENS_REQUISICAO_PRODUTOS_INTERNOS_ENF.IdProd=PRODUTOS_AC.IdProd "
                                + "WHERE ITENS_REQUISICAO_PRODUTOS_INTERNOS_ENF.IdReq='" + jCodReq.getText() + "'");
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                        SalvarItem();
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Saldo de Estoque insuficiente para atender requisição.");
                    }
                }
                if (acao == 4) {
                    objItensReqMatInter.setUsuarioUp(nameUser);
                    objItensReqMatInter.setDataUp(dataModFinal);
                    objItensReqMatInter.setHorarioUp(horaMov);
                    // PEGA PRODUTO PARA CALCULAR SALDO DE ESTOQUE
                    pegarSaldoEstoque(objItensReqMatInter.getIdProd(), objItensReqMatInter.getLoteProduto());
                    // CALCULA O NOVO SALDO DE ESTOQUE 
                    novoSaldoAtual = (float) (qtdItemAnterior + saldoEstoque); // SOMA O SALDO DA TABELA LOTE COM A TABELA ITENS_REQUISICAO           
                    //
                    if (novoSaldoAtual >= objItensReqMatInter.getQtdItem()) {
                        estoqueAtual = (float) (novoSaldoAtual - objItensReqMatInter.getQtdItem()); // DEDUZ O SALDO DE ESTOQUE E GRAVA
                        //
                        objItensReqMatInter.setIdProd(Integer.valueOf(jCodProduto.getText()));
                        objItensReqMatInter.setLoteProduto(jLote.getText());
                        try {
                            objItensReqMatInter.setQtdItem(qtdReal.parse(jQtdItem.getText()).floatValue());
                            objItensReqMatInter.setValorUnitarioItem(qtdReal.parse(jValorUnitarioItem.getText()).floatValue());
                        } catch (ParseException ex) {
                        }
                        objItensReqMatInter.setIdItem(Integer.valueOf(idItem));
                        controle.alterarRequisicaoMaterialInternos(objItensReqMatInter); // ALTERAR QUANTIDADE NA TABELA ITENS_REQUISICAO_PRODUTOS_INTERNOS
                        //
                        objItensReqMatInter.setQtdItem(estoqueAtual);
                        controle.alterarEstoqueMaterais(objItensReqMatInter); // ALTERAR SALDO DE ESTOQUE NA TABELA DE LOTE_PRODUTOS_AC
                        //
                        objLog2();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        preencherTabelaItens("SELECT * FROM ITENS_REQUISICAO_PRODUTOS_INTERNOS_ENF "
                                + "INNER JOIN REQUISICAO_PRODUTOS_INTERNOS_ENF "
                                + "ON ITENS_REQUISICAO_PRODUTOS_INTERNOS_ENF.IdReq=REQUISICAO_PRODUTOS_INTERNOS_ENF.IdReq "
                                + "INNER JOIN PRODUTOS_AC "
                                + "ON ITENS_REQUISICAO_PRODUTOS_INTERNOS_ENF.IdProd=PRODUTOS_AC.IdProd "
                                + "WHERE ITENS_REQUISICAO_PRODUTOS_INTERNOS_ENF.IdReq='" + jCodReq.getText() + "'");
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                        SalvarItem();
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Quantidade requisitada é maior que o saldo de estoque.");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
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
        TelaAuditoriaItensRequisicaoIntMed objAudItensReqIntMed = new TelaAuditoriaItensRequisicaoIntMed();
        TelaModuloEnfermaria.jPainelMedico.add(objAudItensReqIntMed);
        objAudItensReqIntMed.show();
    }//GEN-LAST:event_jBtAuditoriaItemActionPerformed

    private void jBtPesqLocalArmazenamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqLocalArmazenamentoActionPerformed
        // TODO add your handling code here:
        TelaPesqLocalArmazenamentoRequisicaoMed objPesqLocalArmMed = new TelaPesqLocalArmazenamentoRequisicaoMed();
        TelaModuloEnfermaria.jPainelMedico.add(objPesqLocalArmMed);
        objPesqLocalArmMed.show();
    }//GEN-LAST:event_jBtPesqLocalArmazenamentoActionPerformed

    private void jBtImprimirRequisicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImprimirRequisicaoActionPerformed
        // TODO add your handling code here:
        if (jCodReq.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Não é possível listar a Requisição de Materiais.");
        } else if (jStatusReq.getText().equals("ABERTO")) {
            JOptionPane.showMessageDialog(rootPane, "A requisição não poderá ser impressa, pois ainda não foi FINALIZADA.");
        } else {
            try {
                conecta.abrirConexao();
                String path = "reports/Enfermaria/MedicamentosInternosCodigoRequisicao/RequisicaoMedicamentosInternosCodigoRequisicao.jasper";
                conecta.executaSQL("SELECT * FROM REQUISICAO_PRODUTOS_INTERNOS_ENF "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON REQUISICAO_PRODUTOS_INTERNOS_ENF.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "INNER JOIN COLABORADOR "
                        + "ON REQUISICAO_PRODUTOS_INTERNOS_ENF.IdFunc=COLABORADOR.IdFunc "
                        + "INNER JOIN DEPARTAMENTOS "
                        + "ON COLABORADOR.IdDepartamento=COLABORADOR.IdDepartamento "
                        + "WHERE REQUISICAO_PRODUTOS_INTERNOS_ENF.IdReq='" + jCodReq.getText() + "'");
                HashMap parametros = new HashMap();
                parametros.put("CodigoRequisicao", jCodReq.getText());
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
                jv.setTitle("Requisição de Medicamentos para Internos");
                jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
                jv.toFront(); // Traz o relatorio para frente da aplicação            
                conecta.desconecta();
            } catch (JRException e) {
                JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
            }
        }
    }//GEN-LAST:event_jBtImprimirRequisicaoActionPerformed

    private void jQtdItemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jQtdItemFocusLost
        // TODO add your handling code here:
        DecimalFormat qtdReal = new DecimalFormat("###,##00.0");
        qtdReal.setCurrency(Currency.getInstance(new Locale("pt", "BR")));
        try {
            objItensReqMatInter.setQtdItem(qtdReal.parse(jQtdItem.getText()).floatValue());
            objItensReqMatInter.setValorUnitarioItem(qtdReal.parse(jValorUnitarioItem.getText()).floatValue());
            objItensReqMatInter.setValorTotalItem(qtdReal.parse(jValorTotalItem.getText()).floatValue());
        } catch (ParseException ex) {
        }
        valorTotalItem = objItensReqMatInter.getQtdItem() * objItensReqMatInter.getValorUnitarioItem();
        objItensReqMatInter.setValorTotalItem(valorTotalItem);
        DecimalFormat vti = new DecimalFormat(",###0.00");
        String vlTotalItem = vti.format(valorTotalItem);
        jValorTotalItem.setText(vlTotalItem);
    }//GEN-LAST:event_jQtdItemFocusLost

    private void jBtPrescricaoMedicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPrescricaoMedicaActionPerformed
        // TODO add your handling code here:
        if (jRadioBtMedico.isSelected()) {
            tipoA = 0;
            TelaPesqPrescricaoMedicaPsiquiatricaRequisicao objPesPrescricaoReq = new TelaPesqPrescricaoMedicaPsiquiatricaRequisicao();
            TelaModuloEnfermaria.jPainelMedico.add(objPesPrescricaoReq);
            objPesPrescricaoReq.show();
        } else if (jRadioBtPsiquiatrico.isSelected()) {
            tipoA = 1;
            TelaPesqPrescricaoMedicaPsiquiatricaRequisicao objPesPrescricaoReq = new TelaPesqPrescricaoMedicaPsiquiatricaRequisicao();
            TelaModuloEnfermaria.jPainelMedico.add(objPesPrescricaoReq);
            objPesPrescricaoReq.show();
        } else if (jRadioBtOdontologia.isSelected()) {
            tipoA = 2;
            TelaPesqPrescricaoMedicaPsiquiatricaRequisicao objPesPrescricaoReq = new TelaPesqPrescricaoMedicaPsiquiatricaRequisicao();
            TelaModuloEnfermaria.jPainelMedico.add(objPesPrescricaoReq);
            objPesPrescricaoReq.show();
        } else if (!jRadioBtMedico.isSelected() || !jRadioBtPsiquiatrico.isSelected()) {
            JOptionPane.showMessageDialog(rootPane, "Selecione um tipo de prescrição, médica ou psiquiatrica");
        }
    }//GEN-LAST:event_jBtPrescricaoMedicaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btGrupoPrescricao;
    private javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtAlterarItem;
    private javax.swing.JButton jBtAuditoria;
    private javax.swing.JButton jBtAuditoriaItem;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtCancelarItem;
    private javax.swing.JButton jBtExcluir;
    private javax.swing.JButton jBtExcluirItem;
    private javax.swing.JButton jBtFinalizar;
    private javax.swing.JButton jBtImprimirRequisicao;
    private javax.swing.JButton jBtNovo;
    private javax.swing.JButton jBtNovoItem;
    private javax.swing.JButton jBtPesqCodigoReq;
    private javax.swing.JButton jBtPesqColaboradorReq;
    private javax.swing.JButton jBtPesqDatas;
    private javax.swing.JButton jBtPesqInterno;
    private javax.swing.JButton jBtPesqInternosRequisicao;
    private javax.swing.JButton jBtPesqLocalArmazenamento;
    private javax.swing.JButton jBtPesqProduto;
    private javax.swing.JButton jBtPrescricaoMedica;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSairItem;
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JButton jBtSalvarItem;
    public static javax.swing.JTextField jCelaReq;
    private javax.swing.JCheckBox jCheckBoxTodosReq;
    public static javax.swing.JTextField jCodFuncReq;
    public static javax.swing.JTextField jCodInterno;
    public static javax.swing.JTextField jCodProduto;
    public static javax.swing.JTextField jCodReq;
    public static javax.swing.JTextField jCodigoBarras;
    private javax.swing.JTextField jCodigoReq;
    public static javax.swing.JComboBox jComboBoxUnidade;
    private com.toedter.calendar.JDateChooser jDataPesFinal;
    private com.toedter.calendar.JDateChooser jDataPesqInicial;
    public static com.toedter.calendar.JDateChooser jDataPrescricao;
    private com.toedter.calendar.JDateChooser jDataReq;
    public static com.toedter.calendar.JDateChooser jDataVctoLote;
    public static javax.swing.JTextField jDepartamentoFuncReq;
    public static javax.swing.JTextField jDescricaoProduto;
    public static javax.swing.JLabel jFotoInternoReq;
    public static javax.swing.JLabel jFotoRequisitante;
    public static javax.swing.JTextField jIdLocal;
    public static javax.swing.JTextField jIdPrescricao;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JTextField jLote;
    public static javax.swing.JTextField jMatriculaPenal;
    public static javax.swing.JTextField jMatriculaReq;
    public static javax.swing.JTextField jNomeColaboradorReq;
    private javax.swing.JTextField jNomeInterno;
    public static javax.swing.JTextField jNomeInternoReq;
    private javax.swing.JTextArea jObservacao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
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
    public static javax.swing.JTextField jPavilhaoReq;
    private javax.swing.JTextField jQtdItem;
    public static javax.swing.JRadioButton jRadioBtMedico;
    private javax.swing.JRadioButton jRadioBtOdontologia;
    public static javax.swing.JRadioButton jRadioBtPsiquiatrico;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jStatusAprazamento;
    private javax.swing.JTextField jStatusReq;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTabelaItensRequisicao;
    private javax.swing.JTable jTabelaRequisicoes;
    public static javax.swing.JTextArea jTextoPrescricaoMedica;
    private javax.swing.JFormattedTextField jValorTotalItem;
    public static javax.swing.JFormattedTextField jValorUnitarioItem;
    private javax.swing.JLabel jtotalItens;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void formatarCampos() {
        jCodigoBarras.setDocument(new LimiteDigitosSoNum(13));
        jObservacao.setLineWrap(true);
        jObservacao.setWrapStyleWord(true);
        jTextoPrescricaoMedica.setLineWrap(true);
        jTextoPrescricaoMedica.setWrapStyleWord(true);
    }

    public void corCampos() {
        jCodReq.setBackground(Color.white);
        jStatusReq.setBackground(Color.white);
        jStatusAprazamento.setBackground(Color.white);
        jDataReq.setBackground(Color.white);
        jIdLocal.setBackground(Color.white);
        jCodInterno.setBackground(Color.white);
        jMatriculaPenal.setBackground(Color.white);
//        jIdRequiscaoUsuario.setBackground(Color.white);
        jNomeInternoReq.setBackground(Color.white);
        jPavilhaoReq.setBackground(Color.white);
        jCelaReq.setBackground(Color.white);
        jFotoInternoReq.setIcon(null);
        jCodFuncReq.setBackground(Color.white);
        jMatriculaReq.setBackground(Color.white);
        jNomeColaboradorReq.setBackground(Color.white);
        jDepartamentoFuncReq.setBackground(Color.white);
        jIdPrescricao.setBackground(Color.white);
        jDataPrescricao.setBackground(Color.white);
        jTextoPrescricaoMedica.setBackground(Color.white);
        jObservacao.setBackground(Color.white);
        //
        jCodProduto.setBackground(Color.white);
        jCodigoBarras.setBackground(Color.white);
        jLote.setBackground(Color.white);
        jDataVctoLote.setBackground(Color.white);
        jDescricaoProduto.setBackground(Color.white);
        jComboBoxUnidade.setBackground(Color.white);
        jQtdItem.setBackground(Color.white);
        jValorUnitarioItem.setBackground(Color.white);
    }

    public void Novo() {
        jCodReq.setText("");
        jStatusReq.setText("ABERTO");
        jDataReq.setCalendar(Calendar.getInstance());
        jIdLocal.setText("");
        jCodInterno.setText("");
        jMatriculaPenal.setText("");
        jStatusAprazamento.setText("Não Atendido");
        jNomeInternoReq.setText("");
        jPavilhaoReq.setText("");
        jCelaReq.setText("");
        jFotoInternoReq.setIcon(null);
        jCodFuncReq.setText("");
        jMatriculaReq.setText("");
        jNomeColaboradorReq.setText("");
        jDepartamentoFuncReq.setText("");
        jFotoRequisitante.setIcon(null);
        jIdPrescricao.setText("");
        jDataPrescricao.setDate(null);
        jTextoPrescricaoMedica.setText("");
        jObservacao.setText("");
        //
        jDataReq.setEnabled(true);
        jBtPesqLocalArmazenamento.setEnabled(true);
        jBtPesqInternosRequisicao.setEnabled(true);
        jBtPesqColaboradorReq.setEnabled(true);
        jRadioBtMedico.setEnabled(true);
        jRadioBtPsiquiatrico.setEnabled(true);
        jBtPrescricaoMedica.setEnabled(true);
        jObservacao.setEnabled(true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtAuditoria.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        //
        jCodProduto.setText("");
        jCodigoBarras.setText("");
        jLote.setText("");
        jDataVctoLote.setDate(null);
        jDescricaoProduto.setText("");
        jComboBoxUnidade.setSelectedItem(null);
        jQtdItem.setText("");
        jValorUnitarioItem.setText("");
        //
        jBtPesqProduto.setEnabled(!true);
        jCodigoBarras.setEnabled(!true);
        jComboBoxUnidade.setEnabled(!true);
        jQtdItem.setEnabled(!true);
        //
        jBtNovoItem.setEnabled(!true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        jBtAuditoriaItem.setEnabled(!true);
    }

    public void Alterar() {
        //
        jDataReq.setEnabled(true);
        jBtPesqLocalArmazenamento.setEnabled(!true);
        jBtPesqInternosRequisicao.setEnabled(true);
        jBtPesqColaboradorReq.setEnabled(true);
        jRadioBtMedico.setEnabled(true);
        jRadioBtPsiquiatrico.setEnabled(true);
        jBtPrescricaoMedica.setEnabled(true);
        jObservacao.setEnabled(true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtAuditoria.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        //
        jCodProduto.setText("");
        jCodigoBarras.setText("");
        jLote.setText("");
        jDataVctoLote.setDate(null);
        jDescricaoProduto.setText("");
        jComboBoxUnidade.setSelectedItem(null);
        jQtdItem.setText("");
        jValorUnitarioItem.setText("");
        //
        jBtPesqProduto.setEnabled(!true);
        jCodigoBarras.setEnabled(!true);
        jComboBoxUnidade.setEnabled(!true);
        jQtdItem.setEnabled(!true);
        //
        jBtNovoItem.setEnabled(!true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        jBtAuditoriaItem.setEnabled(!true);
    }

    public void Excluir() {
        jCodReq.setText("");
        jStatusReq.setText("");
        jDataReq.setDate(null);
        jIdLocal.setText("");
        jCodInterno.setText("");
        jMatriculaPenal.setText("");
        jStatusAprazamento.setText("");
        jNomeInternoReq.setText("");
        jPavilhaoReq.setText("");
        jCelaReq.setText("");
        jFotoInternoReq.setIcon(null);
        jCodFuncReq.setText("");
        jMatriculaReq.setText("");
        jNomeColaboradorReq.setText("");
        jDepartamentoFuncReq.setText("");
        jFotoRequisitante.setIcon(null);
        jIdPrescricao.setText("");
        jDataPrescricao.setDate(null);
        jTextoPrescricaoMedica.setText("");
        jObservacao.setText("");
        //
        jDataReq.setEnabled(!true);
        jBtPesqLocalArmazenamento.setEnabled(!true);
        jBtPesqInternosRequisicao.setEnabled(!true);
        jBtPesqColaboradorReq.setEnabled(!true);
        jRadioBtMedico.setEnabled(!true);
        jRadioBtPsiquiatrico.setEnabled(!true);
        jBtPrescricaoMedica.setEnabled(!true);
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
        jCodProduto.setText("");
        jCodigoBarras.setText("");
        jLote.setText("");
        jDataVctoLote.setDate(null);
        jDescricaoProduto.setText("");
        jComboBoxUnidade.setSelectedItem(null);
        jQtdItem.setText("");
        jValorUnitarioItem.setText("");
        //
        jBtPesqProduto.setEnabled(!true);
        jCodigoBarras.setEnabled(!true);
        jComboBoxUnidade.setEnabled(!true);
        jQtdItem.setEnabled(!true);
        //
        jBtNovoItem.setEnabled(true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        jBtAuditoriaItem.setEnabled(!true);
    }

    public void Salvar() {
        jDataReq.setEnabled(!true);
        jBtPesqLocalArmazenamento.setEnabled(!true);
        jBtPesqInternosRequisicao.setEnabled(!true);
        jBtPesqColaboradorReq.setEnabled(!true);
        jRadioBtMedico.setEnabled(!true);
        jRadioBtPsiquiatrico.setEnabled(!true);
        jBtPrescricaoMedica.setEnabled(!true);
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
    }

    public void Cancelar() {
        if (jCodReq.getText().equals("")) {
            jStatusReq.setText("");
            jDataReq.setDate(null);
            jIdLocal.setText("");
            jCodInterno.setText("");
            jMatriculaPenal.setText("");
            jStatusAprazamento.setText("");
            jIdPrescricao.setText("");
            jDataPrescricao.setDate(null);
            jTextoPrescricaoMedica.setText("");
            jNomeInternoReq.setText("");
            jPavilhaoReq.setText("");
            jCelaReq.setText("");
            jFotoInternoReq.setIcon(null);
            jCodFuncReq.setText("");
            jMatriculaReq.setText("");
            jNomeColaboradorReq.setText("");
            jDepartamentoFuncReq.setText("");
            jFotoRequisitante.setIcon(null);
            jObservacao.setText("");
            //
            jDataReq.setEnabled(!true);
            jBtPesqLocalArmazenamento.setEnabled(!true);
            jBtPesqInternosRequisicao.setEnabled(!true);
            jBtPesqColaboradorReq.setEnabled(!true);
            jRadioBtMedico.setEnabled(!true);
            jRadioBtPsiquiatrico.setEnabled(!true);
            jBtPrescricaoMedica.setEnabled(!true);
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
            jDataReq.setEnabled(!true);
            jBtPesqLocalArmazenamento.setEnabled(!true);
            jBtPesqInternosRequisicao.setEnabled(!true);
            jBtPesqColaboradorReq.setEnabled(!true);
            jRadioBtMedico.setEnabled(!true);
            jRadioBtPsiquiatrico.setEnabled(!true);
            jBtPrescricaoMedica.setEnabled(!true);
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
        // VERIFICAR SE A TABELA TEM PRODUTOS, SE ESTIVER VAZIA NÃO FINALIZA
        Integer rows = jTabelaItensRequisicao.getModel().getRowCount();
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
                lancarHistorico();
                objReqMatInter.setStatusReq(statusLanc);
                objReqMatInter.setIdReq(Integer.parseInt(jCodReq.getText()));
                control.finalizarRequisicaoMaterialInternos(objReqMatInter);
                jStatusReq.setText("FINALIZADO");
                objLog();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                JOptionPane.showMessageDialog(rootPane, "Registro FINALIZADO com sucesso !!!");
                //
                jDataReq.setEnabled(!true);
                jObservacao.setEnabled(!true);
                //
                jBtNovo.setEnabled(true);
                jBtAlterar.setEnabled(!true);
                jBtExcluir.setEnabled(!true);
                jBtSalvar.setEnabled(!true);
                jBtCancelar.setEnabled(!true);
                jBtFinalizar.setEnabled(!true);
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
        DecimalFormat valorRealMoed = new DecimalFormat("###,##00.0");
        valorRealMoed.setCurrency(Currency.getInstance(new Locale("pt", "BR")));
        for (int i = 0; i < jTabelaItensRequisicao.getRowCount(); i++) {
            // LANÇAR HISTÓRICO DA SAIDA DA REQUISIÇÃO.
            objHistMovAC.setIdProd((int) jTabelaItensRequisicao.getValueAt(i, 1));
            objHistMovAC.setIdLocal(Integer.valueOf(jIdLocal.getText()));
            objHistMovAC.setTipoOpe(tipoOpercao);
            objHistMovAC.setNomeOperacao(nomeOperacao);
            objHistMovAC.setIdDoc(Integer.valueOf(jCodReq.getText()));
            objHistMovAC.setDataMov(jDataReq.getDate());
            try {
                objHistMovAC.setQtdItem(valorRealMoed.parse((String) jTabelaItensRequisicao.getValueAt(i, 3)).floatValue());
            } catch (ParseException ex) {
            }
            SomaProdutoLote(); // SOMAR PRODUTO NA TABELA DE LOTE_ESTOQUE_AC PARA  TABELA HISTORICO_MOVIMENTACAO_ESTOQUE_AC
            objHistMovAC.setSaldoAtual((float) qtdEstoque);
            controlHistENF.incluirHistoricoProdutoENF(objHistMovAC); // SALVAR NA TABELA HISTORICO_MOVIMENTACAO_ESTOQUE_AC
        }
    }

    // SOMAR QUANTIDADE DE CADA PRODUTO NA TABELA DE LOTEPRODUTOS PARA INSERIR NA TABELA DE HISTORICO MOVIMENTAÇÃO ESTOQUE
    public void SomaProdutoLote() {
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

    public void buscarCodigo() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM REQUISICAO_PRODUTOS_INTERNOS_ENF");
            conecta.rs.last();
            jCodReq.setText(conecta.rs.getString("IdReq"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obeter o código da requisição.");
        }
        conecta.desconecta();
    }

    public void NovoItem() {
        //
        jCodProduto.setText("");
        jCodigoBarras.setText("");
        jLote.setText("");
        jDataVctoLote.setDate(null);
        jDescricaoProduto.setText("");
        jComboBoxUnidade.setSelectedItem("Selecione...");
        jQtdItem.setText("");
        jValorUnitarioItem.setText("");
        jValorTotalItem.setText("");
        //
        jBtPesqProduto.setEnabled(true);
        jCodigoBarras.setEnabled(true);
        jComboBoxUnidade.setEnabled(true);
        jQtdItem.setEnabled(true);
        //
        jBtNovoItem.setEnabled(!true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(true);
        jBtCancelarItem.setEnabled(true);
        jBtAuditoriaItem.setEnabled(!true);
        //
        jDataReq.setEnabled(!true);
        jBtPesqInternosRequisicao.setEnabled(!true);
        jBtPesqColaboradorReq.setEnabled(!true);
        jRadioBtMedico.setEnabled(!true);
        jRadioBtPsiquiatrico.setEnabled(!true);
        jBtPrescricaoMedica.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
    }

    public void AlterarItem() {
        //
        jBtPesqProduto.setEnabled(!true);
        jCodigoBarras.setEnabled(!true);
        jComboBoxUnidade.setEnabled(true);
        jQtdItem.setEnabled(true);
        //
        jBtNovoItem.setEnabled(!true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(true);
        jBtCancelarItem.setEnabled(true);
        jBtAuditoriaItem.setEnabled(!true);
        //
        jDataReq.setEnabled(!true);
        jBtPesqInternosRequisicao.setEnabled(!true);
        jBtPesqColaboradorReq.setEnabled(!true);
        jRadioBtMedico.setEnabled(!true);
        jRadioBtPsiquiatrico.setEnabled(!true);
        jBtPrescricaoMedica.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
    }

    public void ExcluirItem() {
        //
        jCodProduto.setText("");
        jCodigoBarras.setText("");
        jLote.setText("");
        jDataVctoLote.setDate(null);
        jDescricaoProduto.setText("");
        jComboBoxUnidade.setSelectedItem(null);
        jQtdItem.setText("");
        jValorUnitarioItem.setText("");
        jValorTotalItem.setText("");
        //
        jBtPesqProduto.setEnabled(!true);
        jCodigoBarras.setEnabled(!true);
        jComboBoxUnidade.setEnabled(!true);
        jQtdItem.setEnabled(!true);
        //
        jBtNovoItem.setEnabled(true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        jBtAuditoriaItem.setEnabled(!true);
        //
        jDataReq.setEnabled(!true);
        jBtPesqInternosRequisicao.setEnabled(!true);
        jBtPesqColaboradorReq.setEnabled(!true);
        jRadioBtMedico.setEnabled(!true);
        jRadioBtPsiquiatrico.setEnabled(!true);
        jBtPrescricaoMedica.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
    }

    public void SalvarItem() {
        jCodProduto.setText("");
        jCodigoBarras.setText("");
        jLote.setText("");
        jDataVctoLote.setDate(null);
        jDescricaoProduto.setText("");
        jComboBoxUnidade.setSelectedItem(null);
        jQtdItem.setText("");
        jValorUnitarioItem.setText("");
        jValorTotalItem.setText("");
        //
        jBtPesqProduto.setEnabled(!true);
        jCodigoBarras.setEnabled(!true);
        jComboBoxUnidade.setEnabled(!true);
        jQtdItem.setEnabled(!true);
        //
        jBtNovoItem.setEnabled(true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        jBtAuditoriaItem.setEnabled(!true);
        //
        jDataReq.setEnabled(!true);
        jBtPesqInternosRequisicao.setEnabled(!true);
        jBtPesqColaboradorReq.setEnabled(!true);
        jRadioBtMedico.setEnabled(!true);
        jRadioBtPsiquiatrico.setEnabled(!true);
        jBtPrescricaoMedica.setEnabled(!true);
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

    public void CancelarItem() {
        jCodProduto.setText("");
        jCodigoBarras.setText("");
        jLote.setText("");
        jDataVctoLote.setDate(null);
        jDescricaoProduto.setText("");
        jComboBoxUnidade.setSelectedItem(null);
        jQtdItem.setText("");
        jValorUnitarioItem.setText("");
        jValorTotalItem.setText("");
        //
        jBtPesqProduto.setEnabled(!true);
        jCodigoBarras.setEnabled(!true);
        jComboBoxUnidade.setEnabled(!true);
        jQtdItem.setEnabled(!true);
        //
        jBtNovoItem.setEnabled(true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        jBtAuditoriaItem.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
        jBtFinalizar.setEnabled(true);
    }

    public void verificarItensRequisitados() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENS_REQUISICAO_PRODUTOS_INTERNOS_ENF WHERE IdReq='" + objReqMatInter.getIdReq() + "'");
            conecta.rs.first();
            codRequisicao = conecta.rs.getString("IdReq");
            if (jCodReq.getText().equals(codRequisicao)) {
                JOptionPane.showMessageDialog(rootPane, "Antes de excluir esse Lançamento, será necessário\nexcluir primeiro os itens relacionados a esse registro.");
            }
        } catch (SQLException ex) {
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o LANÇAMENTO selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objReqMatInter.setIdReq(Integer.parseInt(jCodReq.getText()));
                control.excluirRequisicaoMaterialInternos(objReqMatInter);
                objLog();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                Excluir();
            }
        }
    }

    public void pegarSaldoEstoque(int idProd, String nomeLote) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM LOTE_PRODUTOS_ENF WHERE IdProd='" + idProd + "'AND Lote='" + nomeLote + "'");
            conecta.rs.first();
            codProd = conecta.rs.getInt("IdProd");
            codEstoque = conecta.rs.getInt("IdItem");
            saldoEstoque = conecta.rs.getFloat("Qtd");
            loteEstoque = conecta.rs.getString("Lote");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void pesquisarRequisicaoMateriais(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Dt.Req.", "Status Req.", "Nome Completo do Interno"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1;
                // Formatar a data de emissão
                dataEmissao = conecta.rs.getString("DataReq");
                String dia = dataEmissao.substring(8, 10);
                String mes = dataEmissao.substring(5, 7);
                String ano = dataEmissao.substring(0, 4);
                dataEmissao = dia + "/" + mes + "/" + ano;
                //
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdReq"), dataEmissao, conecta.rs.getString("StatusReq"), conecta.rs.getString("NomeInternoCrc")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaRequisicoes.setModel(modelo);
        jTabelaRequisicoes.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaRequisicoes.getColumnModel().getColumn(0).setResizable(false);
        jTabelaRequisicoes.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaRequisicoes.getColumnModel().getColumn(1).setResizable(false);
        jTabelaRequisicoes.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaRequisicoes.getColumnModel().getColumn(2).setResizable(false);
        jTabelaRequisicoes.getColumnModel().getColumn(3).setPreferredWidth(380);
        jTabelaRequisicoes.getColumnModel().getColumn(3).setResizable(false);
        jTabelaRequisicoes.getTableHeader().setReorderingAllowed(false);
        jTabelaRequisicoes.setAutoResizeMode(jTabelaRequisicoes.AUTO_RESIZE_OFF);
        jTabelaRequisicoes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaRrequisicoes();
        conecta.desconecta();
    }

    public void alinharCamposTabelaRrequisicoes() {
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaRequisicoes.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaRequisicoes.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaRequisicoes.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }

    public void limparTabelaRequsicoes() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Dt.Req.", "Status Req.", "Nome Completo do Interno"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaRequisicoes.setModel(modelo);
        jTabelaRequisicoes.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaRequisicoes.getColumnModel().getColumn(0).setResizable(false);
        jTabelaRequisicoes.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaRequisicoes.getColumnModel().getColumn(1).setResizable(false);
        jTabelaRequisicoes.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaRequisicoes.getColumnModel().getColumn(2).setResizable(false);
        jTabelaRequisicoes.getColumnModel().getColumn(3).setPreferredWidth(380);
        jTabelaRequisicoes.getColumnModel().getColumn(3).setResizable(false);
        jTabelaRequisicoes.getTableHeader().setReorderingAllowed(false);
        jTabelaRequisicoes.setAutoResizeMode(jTabelaRequisicoes.AUTO_RESIZE_OFF);
        jTabelaRequisicoes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void preencherTabelaItens(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código", "Descrição Produto", "Qtd.", "Vl. Item"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            count = 0;
            do {
                count = count + 1;
                qtdItem = conecta.rs.getFloat("QtdItem");
                DecimalFormat vi = new DecimalFormat(",###0.00");
                String vqtdItem = vi.format(qtdItem);
                qtdItemTab = vqtdItem;
                //
                valorUnitario1 = conecta.rs.getFloat("ValorUnitarioItem");
                DecimalFormat vu1 = new DecimalFormat(",###0.00");
                String valorUnitarioP = vu1.format(valorUnitario1);
                valorUnitario2 = valorUnitarioP;
                //
                jtotalItens.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela 
                dados.add(new Object[]{conecta.rs.getInt("IdItem"), conecta.rs.getInt("IdProd"), conecta.rs.getString("DescricaoProd"), qtdItemTab, valorUnitario2});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaItensRequisicao.setModel(modelo);
        jTabelaItensRequisicao.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTabelaItensRequisicao.getColumnModel().getColumn(0).setResizable(false);
        jTabelaItensRequisicao.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTabelaItensRequisicao.getColumnModel().getColumn(1).setResizable(false);
        jTabelaItensRequisicao.getColumnModel().getColumn(2).setPreferredWidth(300);
        jTabelaItensRequisicao.getColumnModel().getColumn(2).setResizable(false);
        jTabelaItensRequisicao.getColumnModel().getColumn(3).setPreferredWidth(50);
        jTabelaItensRequisicao.getColumnModel().getColumn(3).setResizable(false);
        jTabelaItensRequisicao.getColumnModel().getColumn(4).setPreferredWidth(50);
        jTabelaItensRequisicao.getColumnModel().getColumn(4).setResizable(false);
        jTabelaItensRequisicao.getTableHeader().setReorderingAllowed(false);
        jTabelaItensRequisicao.setAutoResizeMode(jTabelaItensRequisicao.AUTO_RESIZE_OFF);
        jTabelaItensRequisicao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaItensRequisicao();
        conecta.desconecta();
    }

    public void alinharCamposTabelaItensRequisicao() {
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaItensRequisicao.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaItensRequisicao.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaItensRequisicao.getColumnModel().getColumn(3).setCellRenderer(direita);
        jTabelaItensRequisicao.getColumnModel().getColumn(4).setCellRenderer(direita);
    }

    public void limparTabelaItens() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código ", "Descrição Produto", "Qtd.", "Vl. Item"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaItensRequisicao.setModel(modelo);
        jTabelaItensRequisicao.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTabelaItensRequisicao.getColumnModel().getColumn(0).setResizable(false);
        jTabelaItensRequisicao.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTabelaItensRequisicao.getColumnModel().getColumn(1).setResizable(false);
        jTabelaItensRequisicao.getColumnModel().getColumn(2).setPreferredWidth(300);
        jTabelaItensRequisicao.getColumnModel().getColumn(2).setResizable(false);
        jTabelaItensRequisicao.getColumnModel().getColumn(3).setPreferredWidth(50);
        jTabelaItensRequisicao.getColumnModel().getColumn(3).setResizable(false);
        jTabelaItensRequisicao.getColumnModel().getColumn(4).setPreferredWidth(50);
        jTabelaItensRequisicao.getColumnModel().getColumn(4).setResizable(false);
        jTabelaItensRequisicao.getTableHeader().setReorderingAllowed(false);
        jTabelaItensRequisicao.setAutoResizeMode(jTabelaItensRequisicao.AUTO_RESIZE_OFF);
        jTabelaItensRequisicao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jCodReq.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog2() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela2);
        objLogSys.setIdLancMov(Integer.valueOf(jCodReq.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void buscarAcessoUsuario(String nomeTelaAcesso) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nameUser + "'");
            conecta.rs.first();
            codigoUserENF = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUserENF + "'");
            conecta.rs.first();
            codigoUserGroupENF = conecta.rs.getInt("IdUsuario");
            codigoGrupoENF = conecta.rs.getInt("IdGrupo");
            nomeGrupoENF = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUserENF + "' "
                    + "AND NomeTela='" + nomeTelaAcesso + "'");
            conecta.rs.first();
            codUserAcessoENF = conecta.rs.getInt("IdUsuario");
            codAbrirENF = conecta.rs.getInt("Abrir");
            codIncluirENF = conecta.rs.getInt("Incluir");
            codAlterarENF = conecta.rs.getInt("Alterar");
            codExcluirENF = conecta.rs.getInt("Excluir");
            codGravarENF = conecta.rs.getInt("Gravar");
            codConsultarENF = conecta.rs.getInt("Consultar");
            nomeTelaENF = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
