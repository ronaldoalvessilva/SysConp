/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleDevolucaoMedicamentosENFAR;
import gestor.Controle.ControleHistoricoMovimentacaoENF;
import gestor.Controle.ControleHistoricoMovimentacaoFAR;
import gestor.Controle.ControleItensDevolucaoMedicamentosENFAR;
import gestor.Controle.ControleLogSistema;
import gestor.Dao.ConexaoBancoDados;
import Utilitarios.ModeloTabela;
import gestor.Modelo.DevolucaoMedEnfermariaFarmacia;
import gestor.Modelo.HistoricoMovimentacaoEstoque;
import gestor.Modelo.ItensRequisicaoMateriaisInternos;
import gestor.Modelo.LogSistema;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloEnfermaria.telaDevolucaoMedicamentosItensENF;
import static gestor.Visao.TelaModuloEnfermaria.telaDevolucaoMedicamentosManuENF;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import java.awt.Color;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Currency;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
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
 * @author ronaldo
 */
public class TelaDevolucaoMedicamentosEnfermariaFarmacia extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    DevolucaoMedEnfermariaFarmacia objDevolucaoMed = new DevolucaoMedEnfermariaFarmacia();
    ControleDevolucaoMedicamentosENFAR control = new ControleDevolucaoMedicamentosENFAR();
    ItensRequisicaoMateriaisInternos objItensReqMatInter = new ItensRequisicaoMateriaisInternos();
    ControleItensDevolucaoMedicamentosENFAR controle = new ControleItensDevolucaoMedicamentosENFAR();
    //    
    HistoricoMovimentacaoEstoque objHistMovAC = new HistoricoMovimentacaoEstoque();
    ControleHistoricoMovimentacaoENF controlHistENF = new ControleHistoricoMovimentacaoENF();
    //       
    ControleHistoricoMovimentacaoFAR controleHistFAR = new ControleHistoricoMovimentacaoFAR();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela = "Enfermaria:Devolução de Medicamentos:Manutenção";
    String nomeModuloTela2 = "Enfermaria:Devolução de Medicamentos:Itens";
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
    public static double novoSaldoAtualFarmacia = 0; // SALDO CALCULADO APOS ALTERAR A QUNATIDADE DO ITEM NA FARMACIA
    int codProd;
    int codEstoque;
    float saldoEstoque; // VARIAVEL COM SALDO DE ESTOQUE DA ENFERMARIA
    float saldoEstoqueFarmacia; // VARIAVEL COM SALDO DE ESTOQUE DA FARMACIA    
    float estoqueAtual = 0;
    float estoqueAtualFarmacia = 0;
    String loteEstoque;
    public static String idItem;
    String tipoOpercao = "D";
    String nomeOperacao = "Devolução Medicamentos Farmácia";
    double qtdEstoque = 0;
    String codRequisicao;
    double valorUnitario = 0;
    float valorTotalItem = 0;
    double valorUnitario1 = 0;
    String valorUnitario2;
    double valorTotalItem2 = 0;
    String modulo = "F";

    /**
     * Creates new form TelaDevolucaoMedicamentosEnfermariaFarmacia
     */
    public TelaDevolucaoMedicamentosEnfermariaFarmacia() {
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

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
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
        jNomeColaboradorRequistante = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTabelaDevolucoes = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jIdDevo = new javax.swing.JTextField();
        jStatusDevo = new javax.swing.JTextField();
        jDataDevo = new com.toedter.calendar.JDateChooser();
        jPanel7 = new javax.swing.JPanel();
        jBtNovo = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jObservacao = new javax.swing.JTextArea();
        jBtFinalizar = new javax.swing.JButton();
        jBtAuditoria = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel14 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jIdMot = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jDescricaoMot = new javax.swing.JTextField();
        jBtPesqMotivo = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jMotivo = new javax.swing.JTextArea();
        jPanel15 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jIdLocalOrigem = new javax.swing.JTextField();
        jBtPesqLocalOrigem = new javax.swing.JButton();
        jDescricaoLocalOrigem = new javax.swing.JTextField();
        jIdLocalDestino = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jDescricaoLocalDestino = new javax.swing.JTextField();
        jBtPesqLocalDestino = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jColaboradorResponsavel = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jIdFunc = new javax.swing.JTextField();
        jBtPesqColaborador = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jDescricaoDepartamento = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
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
        jTabelaItensDevolucao = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jBtNovoItem = new javax.swing.JButton();
        jBtAlterarItem = new javax.swing.JButton();
        jBtExcluirItem = new javax.swing.JButton();
        jBtSalvarItem = new javax.swing.JButton();
        jBtCancelarItem = new javax.swing.JButton();
        jBtAuditoriaItem = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Devolução Medicamentos :::....");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

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
            .addGap(0, 231, Short.MAX_VALUE)
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

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

        jNomeColaboradorRequistante.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel74.setText("Colaborador:");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel74)
                    .addComponent(jLabel72)
                    .addComponent(jLabel70))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jCodigoReq, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqCodigoReq, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(161, 161, 161)
                        .addComponent(jCheckBoxTodosReq))
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel13Layout.createSequentialGroup()
                            .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(21, 21, 21)
                            .addComponent(jLabel73)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jDataPesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jBtPesqDatas, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel13Layout.createSequentialGroup()
                            .addComponent(jNomeColaboradorRequistante, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jBtPesqInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel70)
                    .addComponent(jCodigoReq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jNomeColaboradorRequistante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel74)
                    .addComponent(jBtPesqInterno))
                .addContainerGap())
        );

        jTabelaDevolucoes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaDevolucoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Código", "Dt. Devo.", "Status Devo.", "Nome Completo do Colaborador"
            }
        ));
        jTabelaDevolucoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaDevolucoesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTabelaDevolucoes);
        if (jTabelaDevolucoes.getColumnModel().getColumnCount() > 0) {
            jTabelaDevolucoes.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaDevolucoes.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaDevolucoes.getColumnModel().getColumn(1).setMinWidth(80);
            jTabelaDevolucoes.getColumnModel().getColumn(1).setMaxWidth(80);
            jTabelaDevolucoes.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaDevolucoes.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaDevolucoes.getColumnModel().getColumn(3).setMinWidth(380);
            jTabelaDevolucoes.getColumnModel().getColumn(3).setMaxWidth(380);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("Listagem", jPanel2);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Status");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Data");

        jIdDevo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdDevo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdDevo.setEnabled(false);

        jStatusDevo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jStatusDevo.setForeground(new java.awt.Color(153, 0, 102));
        jStatusDevo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jStatusDevo.setDisabledTextColor(new java.awt.Color(153, 0, 153));
        jStatusDevo.setEnabled(false);

        jDataDevo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataDevo.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jIdDevo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jStatusDevo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDataDevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIdDevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jStatusDevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataDevo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jBtNovo)
                .addComponent(jBtAlterar)
                .addComponent(jBtExcluir)
                .addComponent(jBtSalvar)
                .addComponent(jBtCancelar))
            .addComponent(jBtSair)
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 255));
        jLabel7.setText("Observação:");

        jObservacao.setColumns(20);
        jObservacao.setRows(5);
        jObservacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jObservacao.setEnabled(false);
        jScrollPane1.setViewportView(jObservacao);

        jBtFinalizar.setForeground(new java.awt.Color(0, 153, 0));
        jBtFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/accept.png"))); // NOI18N
        jBtFinalizar.setText("Finalizar");
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

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jBtFinalizar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jBtAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)))
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtFinalizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtAuditoria)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );

        jTabbedPane2.setForeground(new java.awt.Color(255, 0, 0));
        jTabbedPane2.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Código");

        jIdMot.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdMot.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdMot.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Motivo");

        jDescricaoMot.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDescricaoMot.setEnabled(false);

        jBtPesqMotivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqMotivo.setContentAreaFilled(false);
        jBtPesqMotivo.setEnabled(false);
        jBtPesqMotivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqMotivoActionPerformed(evt);
            }
        });

        jMotivo.setColumns(20);
        jMotivo.setRows(5);
        jMotivo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMotivo.setEnabled(false);
        jScrollPane4.setViewportView(jMotivo);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jIdMot, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jDescricaoMot))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDescricaoMot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtPesqMotivo)
                            .addComponent(jIdMot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(4, 4, 4)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Motivo", jPanel14);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 255));
        jLabel8.setText("Código");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 255));
        jLabel17.setText("Local Origem");

        jIdLocalOrigem.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdLocalOrigem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdLocalOrigem.setEnabled(false);

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

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 102, 0));
        jLabel18.setText("Código");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 102, 0));
        jLabel19.setText("Local Destino");

        jDescricaoLocalDestino.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDescricaoLocalDestino.setEnabled(false);

        jBtPesqLocalDestino.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqLocalDestino.setContentAreaFilled(false);
        jBtPesqLocalDestino.setEnabled(false);
        jBtPesqLocalDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqLocalDestinoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jIdLocalDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel18)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel8)
                        .addComponent(jIdLocalOrigem)))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel19)
                        .addComponent(jDescricaoLocalDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel17)
                        .addComponent(jDescricaoLocalOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtPesqLocalDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqLocalOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jDescricaoLocalDestino, jDescricaoLocalOrigem});

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jIdLocalDestino, jIdLocalOrigem});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIdLocalOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDescricaoLocalOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqLocalOrigem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIdLocalDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDescricaoLocalDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqLocalDestino))
                .addContainerGap())
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jDescricaoLocalDestino, jDescricaoLocalOrigem});

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jIdLocalDestino, jIdLocalOrigem});

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Local Armazenamento", jPanel15);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jColaboradorResponsavel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jColaboradorResponsavel.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Colaborador Responsável");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Código");

        jIdFunc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdFunc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdFunc.setEnabled(false);

        jBtPesqColaborador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqColaborador.setContentAreaFilled(false);
        jBtPesqColaborador.setEnabled(false);
        jBtPesqColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqColaboradorActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("Departamento");

        jDescricaoDepartamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDescricaoDepartamento.setEnabled(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jColaboradorResponsavel)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 223, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jIdFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jDescricaoDepartamento))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIdFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqColaborador)
                    .addComponent(jDescricaoDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jColaboradorResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Responsável", jPanel16);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane2))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("Manutenção", jPanel3);

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

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
        jComboBoxUnidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Un", "Caixa", "Pacote", "Ml", "Kg", "Litro", "Peça", "Amp", "Kit", "PR" }));
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

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jComboBoxUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jQtdItem, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jValorUnitarioItem, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jValorTotalItem, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtotalItens, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jCodProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jCodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLote, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDataVctoLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)))
                    .addComponent(jDescricaoProduto))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
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
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel21)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jQtdItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jValorUnitarioItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jValorTotalItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtotalItens, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaItensDevolucao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaItensDevolucao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Item", "Código", "Descrição Produto", "Qtd.", "Vl. Item"
            }
        ));
        jTabelaItensDevolucao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaItensDevolucaoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTabelaItensDevolucao);
        if (jTabelaItensDevolucao.getColumnModel().getColumnCount() > 0) {
            jTabelaItensDevolucao.getColumnModel().getColumn(0).setMinWidth(40);
            jTabelaItensDevolucao.getColumnModel().getColumn(0).setMaxWidth(40);
            jTabelaItensDevolucao.getColumnModel().getColumn(1).setMinWidth(50);
            jTabelaItensDevolucao.getColumnModel().getColumn(1).setMaxWidth(50);
            jTabelaItensDevolucao.getColumnModel().getColumn(2).setMinWidth(300);
            jTabelaItensDevolucao.getColumnModel().getColumn(2).setMaxWidth(300);
            jTabelaItensDevolucao.getColumnModel().getColumn(3).setMinWidth(50);
            jTabelaItensDevolucao.getColumnModel().getColumn(3).setMaxWidth(50);
            jTabelaItensDevolucao.getColumnModel().getColumn(4).setMinWidth(50);
            jTabelaItensDevolucao.getColumnModel().getColumn(4).setMaxWidth(50);
        }

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

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

        jBtAuditoriaItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaItem.setContentAreaFilled(false);
        jBtAuditoriaItem.setEnabled(false);
        jBtAuditoriaItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
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
                .addComponent(jBtAuditoriaItem, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtNovoItem)
                        .addComponent(jBtAlterarItem)
                        .addComponent(jBtExcluirItem)
                        .addComponent(jBtSalvarItem)
                        .addComponent(jBtCancelarItem))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBtAuditoriaItem)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("Produtos", jPanel9);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        setBounds(300, 30, 457, 496);
    }// </editor-fold>//GEN-END:initComponents

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

    private void jBtPesqProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqProdutoActionPerformed
        // TODO add your handling code here:
        TelaPesqProdutoDevolucaoENFAR objPesqProdDevMat = new TelaPesqProdutoDevolucaoENFAR();
        TelaModuloEnfermaria.jPainelMedico.add(objPesqProdDevMat);
        objPesqProdDevMat.show();
    }//GEN-LAST:event_jBtPesqProdutoActionPerformed

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

    private void jTabelaItensDevolucaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaItensDevolucaoMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            String idProduto = "" + jTabelaItensDevolucao.getValueAt(jTabelaItensDevolucao.getSelectedRow(), 1);
            jCodProduto.setText(idProduto);
            String nomeProduto = "" + jTabelaItensDevolucao.getValueAt(jTabelaItensDevolucao.getSelectedRow(), 2);
            jDescricaoProduto.setText(nomeProduto);
            idItem = "" + jTabelaItensDevolucao.getValueAt(jTabelaItensDevolucao.getSelectedRow(), 0);
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
                conecta.executaSQL("SELECT * FROM ITENS_DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR "
                        + "INNER JOIN PRODUTOS_AC "
                        + "ON ITENS_DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR.IdProd=PRODUTOS_AC.IdProd "
                        + "INNER JOIN LOTE_PRODUTOS_ENF "
                        + "ON PRODUTOS_AC.IdProd=LOTE_PRODUTOS_ENF.IdProd "
                        + "WHERE ITENS_DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR.IdDevo='" + jIdDevo.getText() + "'AND "
                        + "PRODUTOS_AC.DescricaoProd='" + jDescricaoProduto.getText() + "'AND ITENS_DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR.IdItem='" + idItem + "'");
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
    }//GEN-LAST:event_jTabelaItensDevolucaoMouseClicked

    private void jBtPesqCodigoReqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqCodigoReqActionPerformed
        // TODO add your handling code here:
        if (jCodigoReq.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um código para pesquisa.");
        } else {
            jTabelaDevolucoes.setVisible(true);
            pesquisarRequisicaoMateriais("SELECT * FROM DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR "
                    + "INNER JOIN COLABORADOR "
                    + "ON DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR.IdFunc=COLABORADOR.IdFunc "
                    + "WHERE IdDevo='" + jCodigoReq.getText() + "'");
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
                        jTabelaDevolucoes.setVisible(true);
                        pesquisarRequisicaoMateriais("SELECT * FROM DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR "
                                + "INNER JOIN COLABORADOR "
                                + "ON DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR.IdFunc=COLABORADOR.IdFunc "
                                + "WHERE DataReq BETWEEN'" + dataInicial + "'AND '" + dataFinal + "'");
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
                        jTabelaDevolucoes.setVisible(true);
                        pesquisarRequisicaoMateriais("SELECT * FROM DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR "
                                + "INNER JOIN COLABORADOR "
                                + "ON DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR.IdFunc=COLABORADOR.IdFunc "
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
            jTabelaDevolucoes.setVisible(true);
            this.pesquisarRequisicaoMateriais("SELECT * FROM DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR "
                    + "INNER JOIN COLABORADOR "
                    + "ON DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR.IdFunc=COLABORADOR.IdFunc ");
        } else {
            jtotalRegistros.setText("");
            jTabelaDevolucoes.setVisible(!true);
        }
    }//GEN-LAST:event_jCheckBoxTodosReqItemStateChanged

    private void jBtPesqInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqInternoActionPerformed
        // TODO add your handling code here:
        if (jNomeColaboradorRequistante.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um nome para pesquisa.");
        } else {
            jTabelaDevolucoes.setVisible(true);
            pesquisarRequisicaoMateriais("SELECT * FROM DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR "
                    + "INNER JOIN COLABORADOR "
                    + "ON DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR.IdFunc=COLABORADOR.IdFunc "
                    + "WHERE COLABORADOR.NomeFunc LIKE'%" + jNomeColaboradorRequistante.getText() + "%'");
        }
    }//GEN-LAST:event_jBtPesqInternoActionPerformed

    private void jTabelaDevolucoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaDevolucoesMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String IdLanc = "" + jTabelaDevolucoes.getValueAt(jTabelaDevolucoes.getSelectedRow(), 0);
            jCodigoReq.setText(IdLanc);
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtNovoItem.setEnabled(true);
            jBtAuditoria.setEnabled(true);
//            jBtImprimirRequisicao.setEnabled(true);
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
                conecta.executaSQL("SELECT * FROM DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR "
                        + "INNER JOIN COLABORADOR "
                        + "ON DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR.IdFunc=COLABORADOR.IdFunc "
                        + "INNER JOIN DEPARTAMENTOS "
                        + "ON COLABORADOR.IdDepartamento=COLABORADOR.IdDepartamento "
                        + "INNER JOIN MOTIVO_SAIDA_PRODUTOS_ENFAR "
                        + "ON DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR.IdMot=MOTIVO_SAIDA_PRODUTOS_ENFAR.IdMot "
                        + "INNER JOIN LOCAL_ARMAZENAMENTO_AC "
                        + "ON DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR.IdLocal=LOCAL_ARMAZENAMENTO_AC.IdLocal "
                        + "WHERE DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR.IdDevo='" + IdLanc + "'");
                conecta.rs.first();
                jIdDevo.setText(String.valueOf(conecta.rs.getInt("IdDevo")));
                jStatusDevo.setText(conecta.rs.getString("StatusDevo"));
                jDataDevo.setDate(conecta.rs.getDate("DataDevo"));
                jIdMot.setText(String.valueOf(conecta.rs.getInt("IdMot")));
                jDescricaoMot.setText(conecta.rs.getString("TituloMotivo"));
                jMotivo.setText(conecta.rs.getString("Motivo"));
                jIdLocalOrigem.setText(conecta.rs.getString("IdLocal"));
                jDescricaoLocalOrigem.setText(conecta.rs.getString("DescricaoLocal"));
                jIdLocalDestino.setText(conecta.rs.getString("IdLocalDst"));
                jDescricaoLocalDestino.setText(conecta.rs.getString("DescricaoLocalDestino"));
                jIdFunc.setText(conecta.rs.getString("IdFunc"));
                jDescricaoDepartamento.setText(conecta.rs.getString("NomeDepartamento"));
                jColaboradorResponsavel.setText(conecta.rs.getString("NomeFunc"));
                jObservacao.setText(conecta.rs.getString("Observacao"));
                conecta.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "Não foi possível exibir registro.\nERRO: " + e);
            }
            count = 0;
            preencherTabelaItens("SELECT * FROM ITENS_DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR "
                    + "INNER JOIN DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR "
                    + "ON ITENS_DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR.IdDevo=DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR.IdDevo "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON ITENS_DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR.IdProd=PRODUTOS_AC.IdProd "
                    + "WHERE ITENS_DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR.IdDevo='" + jIdDevo.getText() + "'");
        }
    }//GEN-LAST:event_jTabelaDevolucoesMouseClicked

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtNovoItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoItemActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaDevolucaoMedicamentosItensENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaDevolucaoMedicamentosItensENF) && codIncluirENF == 1) {
            objDevolucaoMed.setStatusDevo(jStatusDevo.getText());
            if (jStatusDevo.getText().equals("FINALIZADO")) {
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
        buscarAcessoUsuario(telaDevolucaoMedicamentosItensENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaDevolucaoMedicamentosItensENF) && codAlterarENF == 1) {
            objDevolucaoMed.setStatusDevo(jStatusDevo.getText());
            if (jStatusDevo.getText().equals("FINALIZADO")) {
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
        buscarAcessoUsuario(telaDevolucaoMedicamentosItensENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaDevolucaoMedicamentosItensENF) && codExcluirENF == 1) {
            DecimalFormat qtdReal = new DecimalFormat("###,##00.0");
            qtdReal.setCurrency(Currency.getInstance(new Locale("pt", "BR")));
            objDevolucaoMed.setStatusDevo(jStatusDevo.getText());
            if (jStatusDevo.getText().equals("FINALIZADO")) {
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
                    // PEGAR O SALDO DA ENFERARIA LOTE_PRODUTOS_ENF
                    pegarSaldoEstoque(objItensReqMatInter.getIdProd(), objItensReqMatInter.getLoteProduto());
                    try {
                        objItensReqMatInter.setQtdItem(qtdReal.parse(jQtdItem.getText()).floatValue());
                    } catch (ParseException ex) {
                    }
                    // CALCULA O NOVO SALDO DE ESTOQUE                
                    estoqueAtual = saldoEstoque + objItensReqMatInter.getQtdItem();
                    // PEGAR O SALDO DA FARMACIA LOTE_PRODUTOS_AC (FARMACIA)
                    pegarSaldoEstoqueFarmacia(objItensReqMatInter.getIdProd(), objItensReqMatInter.getLoteProduto());
                    // CALCULA O OVO SALDO DE ESTOQUE DA FARMÁCIA                
                    estoqueAtualFarmacia = saldoEstoqueFarmacia - objItensReqMatInter.getQtdItem();
                    //
                    objItensReqMatInter.setIdProd(Integer.valueOf(jCodProduto.getText()));
                    objItensReqMatInter.setLoteProduto(jLote.getText());
                    objItensReqMatInter.setQtdItem(estoqueAtual);
                    controle.alterarEstoqueMateraisENFAR(objItensReqMatInter); // TABELA DE LOTE_PRODUTOS_ENF 
                    //
                    objItensReqMatInter.setIdProd(Integer.valueOf(jCodProduto.getText()));
                    objItensReqMatInter.setLoteProduto(jLote.getText());
                    objItensReqMatInter.setQtdItem(estoqueAtualFarmacia);
                    controle.alterarEstoqueMateraisFARMACIA(objItensReqMatInter); // TABELA DE LOTE_PRODUTOS_AC
                    //
                    objItensReqMatInter.setIdItem(Integer.valueOf(idItem));
                    controle.excluirItensDevolucaoENFAR(objItensReqMatInter);
                    //
                    JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                    ExcluirItem();
                    preencherTabelaItens("SELECT * FROM ITENS_DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR "
                            + "INNER JOIN DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR "
                            + "ON ITENS_DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR.IdDevo=DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR.IdDevo "
                            + "INNER JOIN PRODUTOS_AC "
                            + "ON ITENS_DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR.IdProd=PRODUTOS_AC.IdProd "
                            + "WHERE ITENS_DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR.IdDevo='" + jIdDevo.getText() + "'");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirItemActionPerformed

    private void jBtSalvarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarItemActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaDevolucaoMedicamentosItensENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaDevolucaoMedicamentosItensENF) && codGravarENF == 1) {
            DecimalFormat qtdReal = new DecimalFormat("###,##00.0");
            qtdReal.setCurrency(Currency.getInstance(new Locale("pt", "BR")));
            if (jCodProduto.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o produto para requisição.");
            } else if (jQtdItem.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe a quantidade");
            } else {
                objItensReqMatInter.setIdProd(Integer.valueOf(jCodProduto.getText()));
                objItensReqMatInter.setDescricaoProduto(jDescricaoProduto.getText());
                objItensReqMatInter.setIdReq(Integer.valueOf(jIdDevo.getText()));
                objItensReqMatInter.setCodigoBarras(jCodigoBarras.getText());
                objItensReqMatInter.setLoteProduto(jLote.getText());
                objItensReqMatInter.setUnidadeProd((String) jComboBoxUnidade.getSelectedItem());
                //  objItensReqMatInter.setEstornoProduto(estornoProduto);
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
                    // PEGA PRODUTO PARA CALCULAR SALDO DE ESTOQUE ENFERMARIA LOTE_PRODUTOS_ENF
                    pegarSaldoEstoque(objItensReqMatInter.getIdProd(), objItensReqMatInter.getLoteProduto());
                    // PEGAR PRODUTO PARA CALCULAR SALDO DE ESTOQUE DA FARMÁCIA LOTE_PRODUTO_AC
                    pegarSaldoEstoqueFarmacia(objItensReqMatInter.getIdProd(), objItensReqMatInter.getLoteProduto());
                    //
                    if (saldoEstoque >= objItensReqMatInter.getQtdItem()) {
                        // CALCULA O NOVO SALDO DE ESTOQUE DA ENFERMARIA
                        estoqueAtual = saldoEstoque - objItensReqMatInter.getQtdItem();
                        // CALCULA O NOVO SALDO DE ESTOQUE DA FARMÁCIA
                        estoqueAtualFarmacia = saldoEstoqueFarmacia + objItensReqMatInter.getQtdItem();
                        // ESTOQUE DA ENFRMARIA
                        objItensReqMatInter.setIdProd(Integer.valueOf(jCodProduto.getText()));
                        objItensReqMatInter.setLoteProduto(jLote.getText());
                        objItensReqMatInter.setQtdItem(estoqueAtual);
                        controle.alterarEstoqueMateraisENFAR(objItensReqMatInter); // TABELA DE LOTE_PRODUTOS_ENF                  
                        // GRAVAR REGISTRO NA TABELA ITENS_REQUISICAO_PRODUTOS_INTERNOS
                        objItensReqMatInter.setQtdItem(Float.valueOf(jQtdItem.getText()));
                        controle.incluirItensDevolucaoENFAR(objItensReqMatInter);
                        // ESTOQUE DA FAMÁCIA
                        objItensReqMatInter.setIdProd(Integer.valueOf(jCodProduto.getText()));
                        objItensReqMatInter.setLoteProduto(jLote.getText());
                        objItensReqMatInter.setQtdItem(estoqueAtualFarmacia); // TABELA DE LOTE_PRODUTOS_AC (FARMÁCIA)
                        controle.alterarEstoqueMateraisFARMACIA(objItensReqMatInter);
                        //
                        objLog2();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        preencherTabelaItens("SELECT * FROM ITENS_DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR "
                                + "INNER JOIN DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR "
                                + "ON ITENS_DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR.IdDevo=DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR.IdDevo "
                                + "INNER JOIN PRODUTOS_AC "
                                + "ON ITENS_DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR.IdProd=PRODUTOS_AC.IdProd "
                                + "WHERE ITENS_DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR.IdDevo='" + jIdDevo.getText() + "'");
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
                    // PEGA PRODUTO PARA CALCULAR SALDO DE ESTOQUE (LOTE_PRODUTOS_ENF)
                    pegarSaldoEstoque(objItensReqMatInter.getIdProd(), objItensReqMatInter.getLoteProduto());
                    // CALCULA O NOVO SALDO DE ESTOQUE 
                    novoSaldoAtual = (float) (qtdItemAnterior + saldoEstoque); // SOMA O SALDO DA TABELA LOTE COM A TABELA ITENS_REQUISICAO           
                    // PEGA PRODUTO PARA CALCULAR SALDO DE ESTOQUE DA FARMÁCIA (LOTE_PRODUTOS_AC)
                    pegarSaldoEstoqueFarmacia(objItensReqMatInter.getIdProd(), objItensReqMatInter.getLoteProduto());
                    // CALCULA O NOVO SALDO DE ESTOQUE DA FARMACIA
                    novoSaldoAtualFarmacia = (float) (qtdItemAnterior + saldoEstoqueFarmacia); // SOMA O SALDO DA TABELA LOTE COM A TABELA ITENS_REQUISICAO                           
                    //               
                    if (novoSaldoAtual >= objItensReqMatInter.getQtdItem()) {
                        // CALCULA O NOVO SALDO DO ITEM PARA TABELA LOTE_PRODUTOS_ENF
                        estoqueAtual = (float) (novoSaldoAtual - objItensReqMatInter.getQtdItem()); // DEDUZ O SALDO DE ESTOQUE E GRAVA
                        // CALCULA O NOVO SALDO DO ITEM PARA TABELA LOTE_PRODUTOS_AC
                        estoqueAtualFarmacia = (float) (novoSaldoAtualFarmacia - objItensReqMatInter.getQtdItem());
                        //
                        objItensReqMatInter.setIdProd(Integer.valueOf(jCodProduto.getText()));
                        objItensReqMatInter.setLoteProduto(jLote.getText());
                        try {
                            objItensReqMatInter.setQtdItem(qtdReal.parse(jQtdItem.getText()).floatValue());
                            objItensReqMatInter.setValorUnitarioItem(qtdReal.parse(jValorUnitarioItem.getText()).floatValue());
                        } catch (ParseException ex) {
                        }
                        objItensReqMatInter.setIdItem(Integer.valueOf(idItem));
                        controle.alterarItensDevolucaoENFAR(objItensReqMatInter); // ALTERAR QUANTIDADE NA TABELA ITENS_REQUISICAO_PRODUTOS_INTERNOS
                        // ALTERAR SALDO DE ESTOQUE NA TABELA DE LOTE_PRODUTOS_ENF
                        objItensReqMatInter.setQtdItem(estoqueAtual);
                        controle.alterarEstoqueMateraisENFAR(objItensReqMatInter); // ALTERAR SALDO DE ESTOQUE NA TABELA DE LOTE_PRODUTOS_ENF
                        // ESTOQUE DA FAMÁCIA
                        objItensReqMatInter.setIdProd(Integer.valueOf(jCodProduto.getText()));
                        objItensReqMatInter.setLoteProduto(jLote.getText());
                        objItensReqMatInter.setQtdItem(estoqueAtualFarmacia); // TABELA DE LOTE_PRODUTOS_AC (FARMÁCIA)
                        controle.alterarEstoqueMateraisFARMACIA(objItensReqMatInter);
                        //
                        objLog2();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        preencherTabelaItens("SELECT * FROM ITENS_DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR "
                                + "INNER JOIN DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR "
                                + "ON ITENS_DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR.IdDevo=DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR.IdDevo "
                                + "INNER JOIN PRODUTOS_AC "
                                + "ON ITENS_DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR.IdProd=PRODUTOS_AC.IdProd "
                                + "WHERE ITENS_DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR.IdDevo='" + jIdDevo.getText() + "'");
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

    private void jBtAuditoriaItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaItemActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaItensDevolucaoENF objAuidItensDev = new TelaAuditoriaItensDevolucaoENF();
        TelaModuloEnfermaria.jPainelMedico.add(objAuidItensDev);
        objAuidItensDev.show();
    }//GEN-LAST:event_jBtAuditoriaItemActionPerformed

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaDevolucaoMedicamentosManuENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaDevolucaoMedicamentosManuENF) && codIncluirENF == 1) {
            acao = 1;
            Novo();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaDevolucaoMedicamentosManuENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaDevolucaoMedicamentosManuENF) && codAlterarENF == 1) {
            objDevolucaoMed.setStatusDevo(jStatusDevo.getText());
            if (jStatusDevo.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser modificado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 24;
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
        buscarAcessoUsuario(telaDevolucaoMedicamentosManuENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaDevolucaoMedicamentosManuENF) && codExcluirENF == 1) {
            objDevolucaoMed.setStatusDevo(jStatusDevo.getText());
            if (jStatusDevo.getText().equals("FINALIZADO")) {
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
        buscarAcessoUsuario(telaDevolucaoMedicamentosManuENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaDevolucaoMedicamentosManuENF) && codGravarENF == 1) {
            if (jDataDevo.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data da requisição.");
            } else if (jStatusDevo.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome do requisitante para requisição.");
            } else if (jIdMot.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o motivo da devolução.");
            } else if (jIdLocalOrigem.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o local de Origem dos produtos a devolver.");
            } else if (jIdLocalDestino.getText().equals("") || jDescricaoLocalDestino.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o local de Destino dos produtos a devolver.");
            } else if (jIdFunc.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome do Colaborador.");
            } else {
                objDevolucaoMed.setStatusDevo(jStatusDevo.getText());
                objDevolucaoMed.setDataDevo(jDataDevo.getDate());
                // objDevolucaoMed.setIdMot(Integer.valueOf(jIdMot.getText()));
                // objDevolucaoMed.setIdLocal(Integer.valueOf(jIdLocalOrigem.getText()));
                objDevolucaoMed.setIdLocalDst(Integer.valueOf(jIdLocalDestino.getText()));
                objDevolucaoMed.setDescricaoLocalDestino(jDescricaoLocalDestino.getText());

                objDevolucaoMed.setObservacao(jObservacao.getText());
                if (acao == 1) {
                    objDevolucaoMed.setUsuarioInsert(nameUser);
                    objDevolucaoMed.setDataInsert(dataModFinal);
                    objDevolucaoMed.setHorarioInsert(horaMov);
                    //
                    objDevolucaoMed.setDescricaoMotivo(jDescricaoMot.getText());
                    objDevolucaoMed.setNomecolaborador(jColaboradorResponsavel.getText());
                    objDevolucaoMed.setDescricaoLocalOrigem(jDescricaoLocalOrigem.getText());
                    control.incluirDevolucaoMedicamentosENFAR(objDevolucaoMed);
                    buscarCodigo();
                    //
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    Salvar();
                }
                if (acao == 2) {
                    objDevolucaoMed.setUsuarioUp(nameUser);
                    objDevolucaoMed.setDataUp(dataModFinal);
                    objDevolucaoMed.setHorarioUp(horaMov);
                    //
                    objDevolucaoMed.setIdDevo(Integer.valueOf(jIdDevo.getText()));
                    control.alterarDevolucaoMedicamentosENFAR(objDevolucaoMed);
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

    private void jBtPesqMotivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqMotivoActionPerformed
        // TODO add your handling code here:
        TelaPesqMotivoDevolucao objPesqMot = new TelaPesqMotivoDevolucao();
        TelaModuloEnfermaria.jPainelMedico.add(objPesqMot);
        objPesqMot.show();
    }//GEN-LAST:event_jBtPesqMotivoActionPerformed

    private void jBtPesqColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqColaboradorActionPerformed
        // TODO add your handling code here:
        TelaPesqColaboradorDevolucaoENFAR objPesqColaENFAR = new TelaPesqColaboradorDevolucaoENFAR();
        TelaModuloEnfermaria.jPainelMedico.add(objPesqColaENFAR);
        objPesqColaENFAR.show();
    }//GEN-LAST:event_jBtPesqColaboradorActionPerformed

    private void jBtPesqLocalOrigemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqLocalOrigemActionPerformed
        // TODO add your handling code here:
        TelaPesqLocalArmazenamentoENFAR objPesqLocalOri = new TelaPesqLocalArmazenamentoENFAR();
        TelaModuloEnfermaria.jPainelMedico.add(objPesqLocalOri);
        objPesqLocalOri.show();
    }//GEN-LAST:event_jBtPesqLocalOrigemActionPerformed

    private void jBtPesqLocalDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqLocalDestinoActionPerformed
        // TODO add your handling code here:
        TelaPesqLocalArmazenamentoENFARDest objPesqLocalDst = new TelaPesqLocalArmazenamentoENFARDest();
        TelaModuloEnfermaria.jPainelMedico.add(objPesqLocalDst);
        objPesqLocalDst.show();
    }//GEN-LAST:event_jBtPesqLocalDestinoActionPerformed

    private void jBtFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFinalizarActionPerformed
        // TODO add your handling code here:
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR WHERE IdDevo='" + jIdDevo.getText() + "'");
            conecta.rs.first();
            jStatusDevo.setText(conecta.rs.getString("StatusDevo"));
            if (jStatusDevo.getText().equals("FINALIZADO")) {
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
        TelaAuditoriaDevolucaoNF objAudDevoMed = new TelaAuditoriaDevolucaoNF();
        TelaModuloEnfermaria.jPainelMedico.add(objAudDevoMed);
        objAudDevoMed.show();
    }//GEN-LAST:event_jBtAuditoriaActionPerformed


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
    private javax.swing.JButton jBtNovo;
    private javax.swing.JButton jBtNovoItem;
    private javax.swing.JButton jBtPesqCodigoReq;
    private javax.swing.JButton jBtPesqColaborador;
    private javax.swing.JButton jBtPesqDatas;
    private javax.swing.JButton jBtPesqInterno;
    private javax.swing.JButton jBtPesqLocalDestino;
    private javax.swing.JButton jBtPesqLocalOrigem;
    private javax.swing.JButton jBtPesqMotivo;
    private javax.swing.JButton jBtPesqProduto;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JButton jBtSalvarItem;
    private javax.swing.JCheckBox jCheckBoxTodosReq;
    public static javax.swing.JTextField jCodProduto;
    public static javax.swing.JTextField jCodigoBarras;
    private javax.swing.JTextField jCodigoReq;
    public static javax.swing.JTextField jColaboradorResponsavel;
    public static javax.swing.JComboBox jComboBoxUnidade;
    private com.toedter.calendar.JDateChooser jDataDevo;
    private com.toedter.calendar.JDateChooser jDataPesFinal;
    private com.toedter.calendar.JDateChooser jDataPesqInicial;
    public static com.toedter.calendar.JDateChooser jDataVctoLote;
    public static javax.swing.JTextField jDescricaoDepartamento;
    public static javax.swing.JTextField jDescricaoLocalDestino;
    public static javax.swing.JTextField jDescricaoLocalOrigem;
    public static javax.swing.JTextField jDescricaoMot;
    public static javax.swing.JTextField jDescricaoProduto;
    public static javax.swing.JTextField jIdDevo;
    public static javax.swing.JTextField jIdFunc;
    public static javax.swing.JTextField jIdLocalDestino;
    public static javax.swing.JTextField jIdLocalOrigem;
    public static javax.swing.JTextField jIdMot;
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
    private javax.swing.JLabel jLabel24;
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
    public static javax.swing.JTextArea jMotivo;
    private javax.swing.JTextField jNomeColaboradorRequistante;
    private javax.swing.JTextArea jObservacao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
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
    private javax.swing.JTextField jQtdItem;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jStatusDevo;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTabelaDevolucoes;
    private javax.swing.JTable jTabelaItensDevolucao;
    private javax.swing.JFormattedTextField jValorTotalItem;
    public static javax.swing.JFormattedTextField jValorUnitarioItem;
    private javax.swing.JLabel jtotalItens;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void formatarCampos() {
        jMotivo.setLineWrap(true);
        jMotivo.setWrapStyleWord(true);
        jObservacao.setLineWrap(true);
        jObservacao.setWrapStyleWord(true);
    }

    public void corCampos() {
        jIdDevo.setBackground(Color.white);
        jStatusDevo.setBackground(Color.white);
        jDataDevo.setBackground(Color.white);
        jIdMot.setBackground(Color.white);
        jDescricaoMot.setBackground(Color.white);
        jMotivo.setBackground(Color.white);
        jIdLocalOrigem.setBackground(Color.white);
        jDescricaoLocalOrigem.setBackground(Color.white);
        jIdLocalDestino.setBackground(Color.white);
        jDescricaoLocalDestino.setBackground(Color.white);
        jIdFunc.setBackground(Color.white);
        jDescricaoDepartamento.setBackground(Color.white);
        jColaboradorResponsavel.setBackground(Color.white);
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
        jValorTotalItem.setBackground(Color.white);
    }

    public void Novo() {
        jIdDevo.setText("");
        jStatusDevo.setText("ABERTO");
        jDataDevo.setCalendar(Calendar.getInstance());
        jIdMot.setText("");
        jDescricaoMot.setText("");
        jMotivo.setText("");
        jIdLocalOrigem.setText("");
        jDescricaoLocalOrigem.setText("");
        jIdLocalDestino.setText("");
        jDescricaoLocalDestino.setText("");
        jIdFunc.setText("");
        jDescricaoDepartamento.setText("");
        jColaboradorResponsavel.setText("");
        jObservacao.setText("");
        //
        jDataDevo.setEnabled(true);
        jBtPesqMotivo.setEnabled(true);
        jBtPesqLocalOrigem.setEnabled(true);
        jBtPesqLocalDestino.setEnabled(true);
        jBtPesqColaborador.setEnabled(true);
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
        jDataDevo.setEnabled(true);
        jBtPesqMotivo.setEnabled(true);
        jBtPesqLocalOrigem.setEnabled(true);
        jBtPesqLocalDestino.setEnabled(true);
        jBtPesqColaborador.setEnabled(true);
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
        jIdDevo.setText("");
        jStatusDevo.setText("");
        jDataDevo.setDate(null);
        jIdMot.setText("");
        jDescricaoMot.setText("");
        jMotivo.setText("");
        jIdLocalOrigem.setText("");
        jDescricaoLocalOrigem.setText("");
        jIdLocalDestino.setText("");
        jDescricaoLocalDestino.setText("");
        jIdFunc.setText("");
        jDescricaoDepartamento.setText("");
        jColaboradorResponsavel.setText("");
        jObservacao.setText("");
        //
        jDataDevo.setEnabled(!true);
        jBtPesqMotivo.setEnabled(!true);
        jBtPesqLocalOrigem.setEnabled(!true);
        jBtPesqLocalDestino.setEnabled(!true);
        jBtPesqColaborador.setEnabled(!true);
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
        jBtNovoItem.setEnabled(!true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        jBtAuditoriaItem.setEnabled(!true);
    }

    public void Salvar() {
        //
        jDataDevo.setEnabled(!true);
        jBtPesqMotivo.setEnabled(!true);
        jBtPesqLocalOrigem.setEnabled(!true);
        jBtPesqLocalDestino.setEnabled(!true);
        jBtPesqColaborador.setEnabled(!true);
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

    public void Cancelar() {
        if (jIdDevo.getText().equals("")) {
            jStatusDevo.setText("");
            jDataDevo.setDate(null);
            jIdMot.setText("");
            jDescricaoMot.setText("");
            jMotivo.setText("");
            jIdLocalOrigem.setText("");
            jDescricaoLocalOrigem.setText("");
            jIdLocalDestino.setText("");
            jDescricaoLocalDestino.setText("");
            jIdFunc.setText("");
            jDescricaoDepartamento.setText("");
            jColaboradorResponsavel.setText("");
            jObservacao.setText("");
            //
            jDataDevo.setEnabled(!true);
            jBtPesqMotivo.setEnabled(!true);
            jBtPesqLocalOrigem.setEnabled(!true);
            jBtPesqLocalDestino.setEnabled(!true);
            jBtPesqColaborador.setEnabled(!true);
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
            jBtNovoItem.setEnabled(!true);
            jBtAlterarItem.setEnabled(!true);
            jBtExcluirItem.setEnabled(!true);
            jBtSalvarItem.setEnabled(!true);
            jBtCancelarItem.setEnabled(!true);
            jBtAuditoriaItem.setEnabled(!true);
        } else {
            jDataDevo.setEnabled(!true);
            jBtPesqMotivo.setEnabled(!true);
            jBtPesqLocalOrigem.setEnabled(!true);
            jBtPesqLocalDestino.setEnabled(!true);
            jBtPesqColaborador.setEnabled(!true);
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
    }

    public void Finalizar() {
        // VERIFICAR SE A TABELA TEM PRODUTOS, SE ESTIVER VAZIA NÃO FINALIZA
        Integer rows = jTabelaItensDevolucao.getModel().getRowCount();
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
                lancarHistoricoFarmacia();
                objDevolucaoMed.setStatusDevo(statusLanc);
                objDevolucaoMed.setIdDevo(Integer.parseInt(jIdDevo.getText()));
                control.finalizarDevolucaoMedicamentosENFAR(objDevolucaoMed);
                jStatusDevo.setText("FINALIZADO");
                objLog();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                JOptionPane.showMessageDialog(rootPane, "Registro FINALIZADO com sucesso !!!");
                //
                jDataDevo.setEnabled(!true);
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
        for (int i = 0; i < jTabelaItensDevolucao.getRowCount(); i++) {
            // LANÇAR HISTÓRICO DA SAIDA DA REQUISIÇÃO.
            objHistMovAC.setIdProd((int) jTabelaItensDevolucao.getValueAt(i, 1));
            objHistMovAC.setIdLocal(Integer.valueOf(jIdLocalOrigem.getText()));
            objHistMovAC.setTipoOpe(tipoOpercao);
            objHistMovAC.setNomeOperacao(nomeOperacao);
            objHistMovAC.setIdDoc(Integer.valueOf(jIdDevo.getText()));
            objHistMovAC.setDataMov(jDataDevo.getDate());
            try {
                objHistMovAC.setQtdItem(valorRealMoed.parse((String) jTabelaItensDevolucao.getValueAt(i, 3)).floatValue());
            } catch (ParseException ex) {
            }
            somaProdutoLote(); // SOMAR PRODUTO NA TABELA DE LOTE_ESTOQUE_AC PARA  TABELA HISTORICO_MOVIMENTACAO_ESTOQUE_ENF
            objHistMovAC.setSaldoAtual((float) qtdEstoque);
            controlHistENF.incluirHistoricoProdutoENF(objHistMovAC); // SALVAR NA TABELA HISTORICO_MOVIMENTACAO_ESTOQUE_ENF
        }
    }

    public void lancarHistoricoFarmacia() {
        DecimalFormat valorRealMoed = new DecimalFormat("###,##00.0");
        valorRealMoed.setCurrency(Currency.getInstance(new Locale("pt", "BR")));
        for (int i = 0; i < jTabelaItensDevolucao.getRowCount(); i++) {
            // LANÇAR HISTÓRICO DA SAIDA DA REQUISIÇÃO.
            objHistMovAC.setIdProd((int) jTabelaItensDevolucao.getValueAt(i, 1));
            objHistMovAC.setIdLocal(Integer.valueOf(jIdLocalOrigem.getText()));
            objHistMovAC.setTipoOpe(tipoOpercao);
            objHistMovAC.setNomeOperacao(nomeOperacao);
            objHistMovAC.setIdDoc(Integer.valueOf(jIdDevo.getText()));
            objHistMovAC.setDataMov(jDataDevo.getDate());
            try {
                objHistMovAC.setQtdItem(valorRealMoed.parse((String) jTabelaItensDevolucao.getValueAt(i, 3)).floatValue());
            } catch (ParseException ex) {
            }
            somarProdutoLoteFarmacia(); // SOMAR PRODUTO NA TABELA DE LOTE_ESTOQUE_AC PARA  TABELA HISTORICO_MOVIMENTACAO_ESTOQUE_ENF
            objHistMovAC.setSaldoAtual((float) qtdEstoque);
            controleHistFAR.incluirHistoricoProdutoFAR(objHistMovAC); // SALVAR NA TABELA HISTORICO_MOVIMENTACAO_ESTOQUE_FAR
        }
    }

    // SOMAR QUANTIDADE DE CADA PRODUTO NA TABELA DE LOTEPRODUTOS PARA INSERIR NA TABELA DE HISTORICO MOVIMENTAÇÃO ESTOQUE
    public void somaProdutoLote() {
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
        conecta.desconecta();
    }

    // SOMAR PRODUTO DA FARMACIA COM PRODUTO A SER DEVOLVIDO
    public void somarProdutoLoteFarmacia() {
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
        conecta.desconecta();
    }

    public void buscarCodigo() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR");
            conecta.rs.last();
            jIdDevo.setText(conecta.rs.getString("IdDevo"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter o código.");
        }
        conecta.desconecta();
    }

    public void NovoItem() {
        jCodProduto.setText("");
        jCodigoBarras.setText("");
        jLote.setText("");
        jDataVctoLote.setDate(null);
        jDescricaoProduto.setText("");
        jComboBoxUnidade.setSelectedItem("Selecione");
        jQtdItem.setText("");
        jValorUnitarioItem.setText("");
        jValorTotalItem.setText("");
        //
        jBtPesqProduto.setEnabled(true);
        jCodigoBarras.setEnabled(true);
        jComboBoxUnidade.setEnabled(true);
        jQtdItem.setEnabled(true);
        jValorTotalItem.setEnabled(true);
        //
        jBtNovoItem.setEnabled(!true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(true);
        jBtCancelarItem.setEnabled(true);
        jBtAuditoriaItem.setEnabled(!true);
        //
        jDataDevo.setEnabled(!true);
        jBtPesqMotivo.setEnabled(!true);
        jBtPesqLocalOrigem.setEnabled(!true);
        jBtPesqLocalDestino.setEnabled(!true);
        jBtPesqColaborador.setEnabled(!true);
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
        jBtPesqProduto.setEnabled(!true);
        jCodigoBarras.setEnabled(!true);
        jComboBoxUnidade.setEnabled(true);
        jQtdItem.setEnabled(true);
        jValorTotalItem.setEnabled(true);
        //
        jBtNovoItem.setEnabled(!true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(true);
        jBtCancelarItem.setEnabled(true);
        jBtAuditoriaItem.setEnabled(!true);
        //
        jDataDevo.setEnabled(!true);
        jBtPesqMotivo.setEnabled(!true);
        jBtPesqLocalOrigem.setEnabled(!true);
        jBtPesqLocalDestino.setEnabled(!true);
        jBtPesqColaborador.setEnabled(!true);
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
        jValorTotalItem.setEnabled(!true);
        //
        jBtNovoItem.setEnabled(true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        jBtAuditoriaItem.setEnabled(!true);
        //
        jDataDevo.setEnabled(!true);
        jBtPesqMotivo.setEnabled(!true);
        jBtPesqLocalOrigem.setEnabled(!true);
        jBtPesqLocalDestino.setEnabled(!true);
        jBtPesqColaborador.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        jBtFinalizar.setEnabled(true);
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
        jValorTotalItem.setEnabled(!true);
        //
        jBtNovoItem.setEnabled(true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        jBtAuditoriaItem.setEnabled(!true);
        //
        jDataDevo.setEnabled(!true);
        jBtPesqMotivo.setEnabled(!true);
        jBtPesqLocalOrigem.setEnabled(!true);
        jBtPesqLocalDestino.setEnabled(!true);
        jBtPesqColaborador.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
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
        jValorTotalItem.setEnabled(!true);
        //
        jBtNovoItem.setEnabled(true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        jBtAuditoriaItem.setEnabled(!true);
        //
        jDataDevo.setEnabled(!true);
        jBtPesqMotivo.setEnabled(!true);
        jBtPesqLocalOrigem.setEnabled(!true);
        jBtPesqLocalDestino.setEnabled(!true);
        jBtPesqColaborador.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        jBtFinalizar.setEnabled(true);
    }

    public void verificarItensRequisitados() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENS_DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR "
                    + "WHERE IdDevo='" + objDevolucaoMed.getIdDevo() + "'");
            conecta.rs.first();
            codRequisicao = conecta.rs.getString("IdDevo");
            if (jIdDevo.getText().equals(codRequisicao)) {
                JOptionPane.showMessageDialog(rootPane, "Antes de excluir esse Lançamento, será necessário\nexcluir primeiro os itens relacionados a esse registro.");
            }
        } catch (SQLException ex) {
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o LANÇAMENTO selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objDevolucaoMed.setIdDevo(Integer.parseInt(jIdDevo.getText()));
                control.excluirDevolucaoMedicamentosENFAR(objDevolucaoMed);
                objLog();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                Excluir();
            }
        }
    }

    // PEGAR SALDO DE ESTOQUE DA ENFERMÁRIA
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

    // PEGAR SALDO DE ESTOQUE DA FARMÁCIA PARA ADICIONAR A DEVOLUÇÃO DA ENFERMARIA
    public void pegarSaldoEstoqueFarmacia(int idProd, String nomeLote) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM LOTE_PRODUTOS_AC WHERE IdProd='" + idProd + "'AND Lote='" + nomeLote + "'");
            conecta.rs.first();
            codProd = conecta.rs.getInt("IdProd");
            codEstoque = conecta.rs.getInt("IdItem");
            saldoEstoqueFarmacia = conecta.rs.getFloat("Qtd");
            loteEstoque = conecta.rs.getString("Lote");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void pesquisarRequisicaoMateriais(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Dt.Devo.", "Status Devo.", "Nome Completo do Colaborador"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1;
                // Formatar a data de emissão
                dataEmissao = conecta.rs.getString("DataDevo");
                String dia = dataEmissao.substring(8, 10);
                String mes = dataEmissao.substring(5, 7);
                String ano = dataEmissao.substring(0, 4);
                dataEmissao = dia + "/" + mes + "/" + ano;
                //
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdDevo"), dataEmissao, conecta.rs.getString("StatusDevo"), conecta.rs.getString("NomeFunc")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaDevolucoes.setModel(modelo);
        jTabelaDevolucoes.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaDevolucoes.getColumnModel().getColumn(0).setResizable(false);
        jTabelaDevolucoes.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaDevolucoes.getColumnModel().getColumn(1).setResizable(false);
        jTabelaDevolucoes.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaDevolucoes.getColumnModel().getColumn(2).setResizable(false);
        jTabelaDevolucoes.getColumnModel().getColumn(3).setPreferredWidth(380);
        jTabelaDevolucoes.getColumnModel().getColumn(3).setResizable(false);
        jTabelaDevolucoes.getTableHeader().setReorderingAllowed(false);
        jTabelaDevolucoes.setAutoResizeMode(jTabelaDevolucoes.AUTO_RESIZE_OFF);
        jTabelaDevolucoes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaDevolucoes();
        conecta.desconecta();
    }

    public void alinharCamposTabelaDevolucoes() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaDevolucoes.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaDevolucoes.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaDevolucoes.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }

    public void limparTabelaDevolucoes() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Dt.Devo.", "Status Devo.", "Nome Completo do Colaborador"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaDevolucoes.setModel(modelo);
        jTabelaDevolucoes.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaDevolucoes.getColumnModel().getColumn(0).setResizable(false);
        jTabelaDevolucoes.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaDevolucoes.getColumnModel().getColumn(1).setResizable(false);
        jTabelaDevolucoes.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaDevolucoes.getColumnModel().getColumn(2).setResizable(false);
        jTabelaDevolucoes.getColumnModel().getColumn(3).setPreferredWidth(380);
        jTabelaDevolucoes.getColumnModel().getColumn(3).setResizable(false);
        jTabelaDevolucoes.getTableHeader().setReorderingAllowed(false);
        jTabelaDevolucoes.setAutoResizeMode(jTabelaDevolucoes.AUTO_RESIZE_OFF);
        jTabelaDevolucoes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
                DecimalFormat vu1 = new DecimalFormat(",###.00");
                String valorUnitarioP = vu1.format(valorUnitario1);
                valorUnitario2 = valorUnitarioP;
                //
                jtotalItens.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela 
                dados.add(new Object[]{conecta.rs.getInt("IdItem"), conecta.rs.getInt("IdProd"), conecta.rs.getString("DescricaoProd"), qtdItemTab, valorUnitario2});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaItensDevolucao.setModel(modelo);
        jTabelaItensDevolucao.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTabelaItensDevolucao.getColumnModel().getColumn(0).setResizable(false);
        jTabelaItensDevolucao.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTabelaItensDevolucao.getColumnModel().getColumn(1).setResizable(false);
        jTabelaItensDevolucao.getColumnModel().getColumn(2).setPreferredWidth(300);
        jTabelaItensDevolucao.getColumnModel().getColumn(2).setResizable(false);
        jTabelaItensDevolucao.getColumnModel().getColumn(3).setPreferredWidth(50);
        jTabelaItensDevolucao.getColumnModel().getColumn(3).setResizable(false);
        jTabelaItensDevolucao.getColumnModel().getColumn(4).setPreferredWidth(50);
        jTabelaItensDevolucao.getColumnModel().getColumn(4).setResizable(false);
        jTabelaItensDevolucao.getTableHeader().setReorderingAllowed(false);
        jTabelaItensDevolucao.setAutoResizeMode(jTabelaItensDevolucao.AUTO_RESIZE_OFF);
        jTabelaItensDevolucao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCaposTabelaItens();
        conecta.desconecta();
    }

    public void alinharCaposTabelaItens() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaItensDevolucao.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaItensDevolucao.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaItensDevolucao.getColumnModel().getColumn(3).setCellRenderer(direita);
        jTabelaItensDevolucao.getColumnModel().getColumn(4).setCellRenderer(direita);
    }

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jIdDevo.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog2() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela2);
        objLogSys.setIdLancMov(Integer.valueOf(jIdDevo.getText()));
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
