/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleComposicaoKit;
import gestor.Controle.ControleListaInternosKitCompleto;
import gestor.Controle.ControleListaProdutosKitCompleto;
import gestor.Controle.ControleProdutosKitLote;
import gestor.Dao.ConexaoBancoDados;
import Utilitarios.ModeloTabela;
import gestor.Modelo.ComposicaoKit;
import gestor.Modelo.GravarInternosKitCompleto;
import gestor.Modelo.PavilhaoInternosSelecionados;
import gestor.Modelo.ProdutoInternosKitLote;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.codigoPesquisaKit;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.codigoPesquisaKitItem;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jRBtKitAnual;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jRBtKitDecendial;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jRBtKitInicial;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jRBtKitMensal;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jRBtKitQuinzenal;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jBtAdicionarProdutosKitCompleto;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jBtAdicionarTodosInternos;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jBtNovo;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jBtAlterar;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jBtExcluir;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jBtSalvar;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jBtCancelar;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jBtAuditoria;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jBtFinalizar;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jDataComp;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jDepartamentoColaborador;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jFotoColaborador;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jIdFunc;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jIdRegistroComp;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jNomeColaborador;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jObservacao;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jRBtKitSemestral;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jStatusComp;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jTabelaGeralProdutosKit;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jTabelaInternos;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jTabelaInternosKitCompleto;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jTabelaInternosSelecionados;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jTabelaProdutos;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jTabelaProdutosKitCompleto;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jtotalInternosKitCompleto;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jtotalInternosPavilhao;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jtotalInternosSelecionados;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jtotalProdutosKit;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jtotalProdutosKitCompleto;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jtotalProdutosKitInternos;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.qtdInternosSelec;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.qtdProd;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.qtdInternosKitComp;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.qtdProdutosKitComo;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.pPESQUISA_ID_kit;
import java.awt.Color;
import java.awt.Image;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.pCODIGO_pavilhao;

/**
 *
 * @author ronal
 */
public class TelaPesquisaMontagemKitHigiene extends javax.swing.JDialog {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    PavilhaoInternosSelecionados objPavInternos = new PavilhaoInternosSelecionados();
    ControleComposicaoKit controle = new ControleComposicaoKit();
    ControleProdutosKitLote control = new ControleProdutosKitLote();
    ControleListaInternosKitCompleto controleIC = new ControleListaInternosKitCompleto();
    ControleListaProdutosKitCompleto controleKitComp = new ControleListaProdutosKitCompleto();
    //
    int flag;
    int count = 0;
    int count1 = 0;
    String dataInicial;
    String dataFinal;
    //
    String nomeKit = "";
    // VARIÁVEIS PARA OS KITS INICIAL E 15 DIAS    
    int kitInicial = 0;
    int kitAnual = 0;
    int kitDecendial = 0;
    int kitQuinzenal = 0;
    int kitMensal = 0;
    int kitSemestral = 0;
    String dataEmissao;
    String idLanc;
    String idKit;
    String caminhoFoto;
    String tipoKit = "";
    //
    String pDESCRICAO_pavilhao = "";
    String pNOME_pavilhao = "";
    public static int pTOTAL_KITS_registrados = 0;
    //

    /**
     * Creates new form TelaPesquisaMontagemKitHigiene
     */
    public static TelaMontagemPagamentoKitInterno motaPagtoKit;

    public TelaPesquisaMontagemKitHigiene(TelaMontagemPagamentoKitInterno parent, boolean modal) {
        this.motaPagtoKit = parent;
        this.setModal(modal);
        setLocationRelativeTo(motaPagtoKit);
        initComponents();
        corCampo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBotoes = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jCodigoRegistroPesquisa = new javax.swing.JTextField();
        jBtPesquisaCodigo = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jDataPesqInicial = new com.toedter.calendar.JDateChooser();
        jDataPesFinal = new com.toedter.calendar.JDateChooser();
        jBtPesquisaData = new javax.swing.JButton();
        jCheckBoxTodos = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        jDescricaoPavilhao = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaRegistrosMontagemKits = new javax.swing.JTable();
        jBtConfirmar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jPanel36 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jRBtKitInicialPesquisa = new javax.swing.JRadioButton();
        jRBtKitQuinzenalPesquisa = new javax.swing.JRadioButton();
        jRBtKitMensalPesquisa = new javax.swing.JRadioButton();
        jRBtKitDecendialPesquisa = new javax.swing.JRadioButton();
        jRBtKitSemestraPesquisa = new javax.swing.JRadioButton();
        jRBtKitAnualPesquisa = new javax.swing.JRadioButton();
        jComboBoxSelecionarKit = new javax.swing.JComboBox<>();
        jBtPesquisaTipoKit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("...::: Pesquisa de Registro de Montagem de Kits Higiêne de Internos :::...");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Pesquisa de Dados Inicias e Gerais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(204, 0, 0))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código:");

        jCodigoRegistroPesquisa.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodigoRegistroPesquisa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesquisaCodigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesquisaCodigo.setContentAreaFilled(false);
        jBtPesquisaCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisaCodigoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Data Inicial:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Data Final:");

        jDataPesqInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jDataPesFinal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesquisaData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesquisaData.setContentAreaFilled(false);
        jBtPesquisaData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisaDataActionPerformed(evt);
            }
        });

        jCheckBoxTodos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxTodos.setText("Todos");
        jCheckBoxTodos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxTodosItemStateChanged(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Pavilhão:");

        jDescricaoPavilhao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDescricaoPavilhao.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCodigoRegistroPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesquisaCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataPesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesquisaData, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDescricaoPavilhao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBoxTodos)
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel1)
                        .addComponent(jCodigoRegistroPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBtPesquisaCodigo)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jDataPesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBtPesquisaData))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jCheckBoxTodos)))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jDescricaoPavilhao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(5, 5, 5))
        );

        TabelaRegistrosMontagemKits.setAutoCreateRowSorter(true);
        TabelaRegistrosMontagemKits.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        TabelaRegistrosMontagemKits.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Registro", "Data Registro", "ID Kit", "Tipo Kit", "Código", "Colaborador", "Pavilhão/Galeria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelaRegistrosMontagemKits.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaRegistrosMontagemKitsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelaRegistrosMontagemKits);
        if (TabelaRegistrosMontagemKits.getColumnModel().getColumnCount() > 0) {
            TabelaRegistrosMontagemKits.getColumnModel().getColumn(0).setMinWidth(70);
            TabelaRegistrosMontagemKits.getColumnModel().getColumn(0).setMaxWidth(70);
            TabelaRegistrosMontagemKits.getColumnModel().getColumn(1).setMinWidth(80);
            TabelaRegistrosMontagemKits.getColumnModel().getColumn(1).setMaxWidth(80);
            TabelaRegistrosMontagemKits.getColumnModel().getColumn(2).setMinWidth(60);
            TabelaRegistrosMontagemKits.getColumnModel().getColumn(2).setMaxWidth(60);
            TabelaRegistrosMontagemKits.getColumnModel().getColumn(3).setMinWidth(70);
            TabelaRegistrosMontagemKits.getColumnModel().getColumn(3).setMaxWidth(70);
            TabelaRegistrosMontagemKits.getColumnModel().getColumn(4).setMinWidth(60);
            TabelaRegistrosMontagemKits.getColumnModel().getColumn(4).setMaxWidth(60);
            TabelaRegistrosMontagemKits.getColumnModel().getColumn(5).setMinWidth(350);
            TabelaRegistrosMontagemKits.getColumnModel().getColumn(5).setMaxWidth(350);
            TabelaRegistrosMontagemKits.getColumnModel().getColumn(6).setMinWidth(350);
            TabelaRegistrosMontagemKits.getColumnModel().getColumn(6).setMaxWidth(350);
        }

        jBtConfirmar.setForeground(new java.awt.Color(0, 102, 0));
        jBtConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/40_16x16.png"))); // NOI18N
        jBtConfirmar.setText("Confirmar");
        jBtConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtConfirmarActionPerformed(evt);
            }
        });

        jBtSair.setForeground(new java.awt.Color(204, 0, 0));
        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/shutdown-icone-6920-16.png"))); // NOI18N
        jBtSair.setText("Sair");
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        jPanel36.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        jPanel37.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jLabel69.setText("Total de Registros:");

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel69))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel69)
        );

        jPanel38.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jtotalRegistros.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Pesquisa por Kit:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Tipo de Kit:");

        grupoBotoes.add(jRBtKitInicialPesquisa);
        jRBtKitInicialPesquisa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBtKitInicialPesquisa.setText("Inicial");
        jRBtKitInicialPesquisa.setEnabled(false);

        grupoBotoes.add(jRBtKitQuinzenalPesquisa);
        jRBtKitQuinzenalPesquisa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBtKitQuinzenalPesquisa.setText("Quinzenal");
        jRBtKitQuinzenalPesquisa.setEnabled(false);

        grupoBotoes.add(jRBtKitMensalPesquisa);
        jRBtKitMensalPesquisa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBtKitMensalPesquisa.setText("Mensal");
        jRBtKitMensalPesquisa.setEnabled(false);

        grupoBotoes.add(jRBtKitDecendialPesquisa);
        jRBtKitDecendialPesquisa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBtKitDecendialPesquisa.setText("Decendial");
        jRBtKitDecendialPesquisa.setEnabled(false);

        grupoBotoes.add(jRBtKitSemestraPesquisa);
        jRBtKitSemestraPesquisa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBtKitSemestraPesquisa.setText("Semestral");
        jRBtKitSemestraPesquisa.setEnabled(false);

        grupoBotoes.add(jRBtKitAnualPesquisa);
        jRBtKitAnualPesquisa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBtKitAnualPesquisa.setText("Anual");
        jRBtKitAnualPesquisa.setEnabled(false);

        jComboBoxSelecionarKit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxSelecionarKit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "Kit Inicial", "Kit Decendial", "Kit Quinzenal", "Kit Mensal", "Kit Semestral", "Kit Anual" }));
        jComboBoxSelecionarKit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesquisaTipoKit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesquisaTipoKit.setToolTipText("Pesquisa por Tipo de Kit de Higiene");
        jBtPesquisaTipoKit.setContentAreaFilled(false);
        jBtPesquisaTipoKit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisaTipoKitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRBtKitInicialPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRBtKitDecendialPesquisa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRBtKitQuinzenalPesquisa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRBtKitMensalPesquisa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRBtKitSemestraPesquisa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRBtKitAnualPesquisa)
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxSelecionarKit, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtPesquisaTipoKit, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxSelecionarKit, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesquisaTipoKit)
                    .addComponent(jLabel5)
                    .addComponent(jRBtKitAnualPesquisa)
                    .addComponent(jRBtKitSemestraPesquisa)
                    .addComponent(jRBtKitMensalPesquisa)
                    .addComponent(jRBtKitQuinzenalPesquisa)
                    .addComponent(jRBtKitDecendialPesquisa)
                    .addComponent(jRBtKitInicialPesquisa)
                    .addComponent(jLabel4))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSair)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtConfirmar, jBtSair});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtConfirmar)
                    .addComponent(jBtSair))
                .addGap(5, 5, 5))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesquisaCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisaCodigoActionPerformed
        // TODO add your handling code here:
        count = 0;
        if (jCodigoRegistroPesquisa.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o código do Registro para pesquisa.");
        } else {
            preencherTabelaRegistrosMontagemKits("SELECT DISTINCT "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp, "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp, "
                    + "KITS_HIGIENE_INTERNO.IdKit, "
                    + "KITS_HIGIENE_INTERNO.KitInicial, "
                    + "KITS_HIGIENE_INTERNO.KitDecendial, "
                    + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                    + "KITS_HIGIENE_INTERNO.KitMensal, "
                    + "KITS_HIGIENE_INTERNO.KitSemestral, "
                    + "KITS_HIGIENE_INTERNO.KitAnual, "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc, "
                    + "COLABORADOR.NomeFunc "
                    + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                    + "INNER JOIN COLABORADOR "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                    + "INNER JOIN KITS_HIGIENE_INTERNO "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                    + "WHERE COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp='" + jCodigoRegistroPesquisa.getText() + "'");
        }
    }//GEN-LAST:event_jBtPesquisaCodigoActionPerformed

    private void jBtPesquisaDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisaDataActionPerformed
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
                        if (jComboBoxSelecionarKit.getSelectedItem().equals("Selecione...")) {
                            preencherTabelaRegistrosMontagemKits("SELECT DISTINCT "
                                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp, "
                                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp, "
                                    + "KITS_HIGIENE_INTERNO.IdKit, "
                                    + "KITS_HIGIENE_INTERNO.KitInicial, "
                                    + "KITS_HIGIENE_INTERNO.KitDecendial, "
                                    + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                                    + "KITS_HIGIENE_INTERNO.KitMensal, "
                                    + "KITS_HIGIENE_INTERNO.KitSemestral, "
                                    + "KITS_HIGIENE_INTERNO.KitAnual, "
                                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc, "
                                    + "COLABORADOR.NomeFunc "
                                    + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                                    + "INNER JOIN COLABORADOR "
                                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                                    + "INNER JOIN KITS_HIGIENE_INTERNO "
                                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                                    + "WHERE COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp BETWEEN'" + dataInicial + "' "
                                    + "AND '" + dataFinal + "'");
                        } else if (jComboBoxSelecionarKit.getSelectedItem().equals("Kit Inicial")) {
                            preencherTabelaRegistrosMontagemKits("SELECT DISTINCT "
                                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp, "
                                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp, "
                                    + "KITS_HIGIENE_INTERNO.IdKit, "
                                    + "KITS_HIGIENE_INTERNO.KitInicial, "
                                    + "KITS_HIGIENE_INTERNO.KitDecendial, "
                                    + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                                    + "KITS_HIGIENE_INTERNO.KitMensal, "
                                    + "KITS_HIGIENE_INTERNO.KitSemestral, "
                                    + "KITS_HIGIENE_INTERNO.KitAnual, "
                                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc, "
                                    + "COLABORADOR.NomeFunc "
                                    + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                                    + "INNER JOIN COLABORADOR "
                                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                                    + "INNER JOIN KITS_HIGIENE_INTERNO "
                                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                                    + "WHERE COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp BETWEEN'" + dataInicial + "' "
                                    + "AND '" + dataFinal + "' "
                                    + "AND KITS_HIGIENE_INTERNO.KitInicial=1");
                        } else if (jComboBoxSelecionarKit.getSelectedItem().equals("Kit Decendial")) {
                            preencherTabelaRegistrosMontagemKits("SELECT DISTINCT "
                                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp, "
                                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp, "
                                    + "KITS_HIGIENE_INTERNO.IdKit, "
                                    + "KITS_HIGIENE_INTERNO.KitInicial, "
                                    + "KITS_HIGIENE_INTERNO.KitDecendial, "
                                    + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                                    + "KITS_HIGIENE_INTERNO.KitMensal, "
                                    + "KITS_HIGIENE_INTERNO.KitSemestral, "
                                    + "KITS_HIGIENE_INTERNO.KitAnual, "
                                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc, "
                                    + "COLABORADOR.NomeFunc "
                                    + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                                    + "INNER JOIN COLABORADOR "
                                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                                    + "INNER JOIN KITS_HIGIENE_INTERNO "
                                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                                    + "WHERE COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp BETWEEN'" + dataInicial + "' "
                                    + "AND '" + dataFinal + "' "
                                    + "AND KITS_HIGIENE_INTERNO.KitDecendial=1");
                        } else if (jComboBoxSelecionarKit.getSelectedItem().equals("Kit Quinzenal")) {
                            preencherTabelaRegistrosMontagemKits("SELECT SELECT DISTINCT "
                                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp, "
                                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp, "
                                    + "KITS_HIGIENE_INTERNO.IdKit, "
                                    + "KITS_HIGIENE_INTERNO.KitInicial, "
                                    + "KITS_HIGIENE_INTERNO.KitDecendial, "
                                    + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                                    + "KITS_HIGIENE_INTERNO.KitMensal, "
                                    + "KITS_HIGIENE_INTERNO.KitSemestral, "
                                    + "KITS_HIGIENE_INTERNO.KitAnual, "
                                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc, "
                                    + "COLABORADOR.NomeFunc "
                                    + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                                    + "INNER JOIN COLABORADOR "
                                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                                    + "INNER JOIN KITS_HIGIENE_INTERNO "
                                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                                    + "WHERE COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp BETWEEN'" + dataInicial + "' "
                                    + "AND '" + dataFinal + "' "
                                    + "AND KITS_HIGIENE_INTERNO.KitQuinzenal=1");
                        } else if (jComboBoxSelecionarKit.getSelectedItem().equals("Kit Mensal")) {
                            preencherTabelaRegistrosMontagemKits("SELECT DISTINCT "
                                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp, "
                                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp, "
                                    + "KITS_HIGIENE_INTERNO.IdKit, "
                                    + "KITS_HIGIENE_INTERNO.KitInicial, "
                                    + "KITS_HIGIENE_INTERNO.KitDecendial, "
                                    + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                                    + "KITS_HIGIENE_INTERNO.KitMensal, "
                                    + "KITS_HIGIENE_INTERNO.KitSemestral, "
                                    + "KITS_HIGIENE_INTERNO.KitAnual, "
                                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc, "
                                    + "COLABORADOR.NomeFunc "
                                    + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                                    + "INNER JOIN COLABORADOR "
                                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                                    + "INNER JOIN KITS_HIGIENE_INTERNO "
                                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                                    + "WHERE COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp BETWEEN'" + dataInicial + "' "
                                    + "AND '" + dataFinal + "' "
                                    + "AND KITS_HIGIENE_INTERNO.KitMensal=1");
                        } else if (jComboBoxSelecionarKit.getSelectedItem().equals("Kit Semestral")) {
                            preencherTabelaRegistrosMontagemKits("SELECT DISTINCT "
                                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp, "
                                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp, "
                                    + "KITS_HIGIENE_INTERNO.IdKit, "
                                    + "KITS_HIGIENE_INTERNO.KitInicial, "
                                    + "KITS_HIGIENE_INTERNO.KitDecendial, "
                                    + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                                    + "KITS_HIGIENE_INTERNO.KitMensal, "
                                    + "KITS_HIGIENE_INTERNO.KitSemestral, "
                                    + "KITS_HIGIENE_INTERNO.KitAnual, "
                                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc, "
                                    + "COLABORADOR.NomeFunc "
                                    + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                                    + "INNER JOIN COLABORADOR "
                                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                                    + "INNER JOIN KITS_HIGIENE_INTERNO "
                                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                                    + "WHERE COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp BETWEEN'" + dataInicial + "' "
                                    + "AND '" + dataFinal + "' "
                                    + "AND KITS_HIGIENE_INTERNO.KitSemestral=1");
                        } else if (jComboBoxSelecionarKit.getSelectedItem().equals("Kit Anual")) {
                            preencherTabelaRegistrosMontagemKits("SELECT DISTINCT "
                                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp, "
                                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp, "
                                    + "KITS_HIGIENE_INTERNO.IdKit, "
                                    + "KITS_HIGIENE_INTERNO.KitInicial, "
                                    + "KITS_HIGIENE_INTERNO.KitDecendial, "
                                    + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                                    + "KITS_HIGIENE_INTERNO.KitMensal, "
                                    + "KITS_HIGIENE_INTERNO.KitSemestral, "
                                    + "KITS_HIGIENE_INTERNO.KitAnual, "
                                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc, "
                                    + "COLABORADOR.NomeFunc "
                                    + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                                    + "INNER JOIN COLABORADOR "
                                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                                    + "INNER JOIN KITS_HIGIENE_INTERNO "
                                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                                    + "WHERE COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp BETWEEN'" + dataInicial + "' "
                                    + "AND '" + dataFinal + "' "
                                    + "AND KITS_HIGIENE_INTERNO.KitAnual=1");
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
                        if (jComboBoxSelecionarKit.getSelectedItem().equals("Selecione...")) {
                            preencherTabelaRegistrosMontagemKits("SELECT DISTINCT "
                                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp, "
                                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp, "
                                    + "KITS_HIGIENE_INTERNO.IdKit, "
                                    + "KITS_HIGIENE_INTERNO.KitInicial, "
                                    + "KITS_HIGIENE_INTERNO.KitDecendial, "
                                    + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                                    + "KITS_HIGIENE_INTERNO.KitMensal, "
                                    + "KITS_HIGIENE_INTERNO.KitSemestral, "
                                    + "KITS_HIGIENE_INTERNO.KitAnual, "
                                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc, "
                                    + "COLABORADOR.NomeFunc "
                                    + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                                    + "INNER JOIN COLABORADOR "
                                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                                    + "INNER JOIN KITS_HIGIENE_INTERNO "
                                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                                    + "WHERE COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp BETWEEN'" + dataInicial + "' "
                                    + "AND '" + dataFinal + "'");
                        } else if (jComboBoxSelecionarKit.getSelectedItem().equals("Kit Inicial")) {
                            preencherTabelaRegistrosMontagemKits("SELECT DISTINCT "
                                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp, "
                                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp, "
                                    + "KITS_HIGIENE_INTERNO.IdKit, "
                                    + "KITS_HIGIENE_INTERNO.KitInicial, "
                                    + "KITS_HIGIENE_INTERNO.KitDecendial, "
                                    + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                                    + "KITS_HIGIENE_INTERNO.KitMensal, "
                                    + "KITS_HIGIENE_INTERNO.KitSemestral, "
                                    + "KITS_HIGIENE_INTERNO.KitAnual, "
                                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc, "
                                    + "COLABORADOR.NomeFunc "
                                    + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                                    + "INNER JOIN COLABORADOR "
                                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                                    + "INNER JOIN KITS_HIGIENE_INTERNO "
                                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                                    + "WHERE COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp BETWEEN'" + dataInicial + "' "
                                    + "AND '" + dataFinal + "' "
                                    + "AND KITS_HIGIENE_INTERNO.KitInicial=1");
                        } else if (jComboBoxSelecionarKit.getSelectedItem().equals("Kit Decendial")) {
                            preencherTabelaRegistrosMontagemKits("SELECT DISTINCT "
                                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp, "
                                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp, "
                                    + "KITS_HIGIENE_INTERNO.IdKit, "
                                    + "KITS_HIGIENE_INTERNO.KitInicial, "
                                    + "KITS_HIGIENE_INTERNO.KitDecendial, "
                                    + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                                    + "KITS_HIGIENE_INTERNO.KitMensal, "
                                    + "KITS_HIGIENE_INTERNO.KitSemestral, "
                                    + "KITS_HIGIENE_INTERNO.KitAnual, "
                                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc, "
                                    + "COLABORADOR.NomeFunc "
                                    + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                                    + "INNER JOIN COLABORADOR "
                                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                                    + "INNER JOIN KITS_HIGIENE_INTERNO "
                                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                                    + "WHERE COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp BETWEEN'" + dataInicial + "' "
                                    + "AND '" + dataFinal + "' "
                                    + "AND KITS_HIGIENE_INTERNO.KitDecendial=1");
                        } else if (jComboBoxSelecionarKit.getSelectedItem().equals("Kit Quinzenal")) {
                            preencherTabelaRegistrosMontagemKits("SELECT DISTINCT "
                                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp, "
                                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp, "
                                    + "KITS_HIGIENE_INTERNO.IdKit, "
                                    + "KITS_HIGIENE_INTERNO.KitInicial, "
                                    + "KITS_HIGIENE_INTERNO.KitDecendial, "
                                    + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                                    + "KITS_HIGIENE_INTERNO.KitMensal, "
                                    + "KITS_HIGIENE_INTERNO.KitSemestral, "
                                    + "KITS_HIGIENE_INTERNO.KitAnual, "
                                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc, "
                                    + "COLABORADOR.NomeFunc "
                                    + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                                    + "INNER JOIN COLABORADOR "
                                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                                    + "INNER JOIN KITS_HIGIENE_INTERNO "
                                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                                    + "WHERE COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp BETWEEN'" + dataInicial + "' "
                                    + "AND '" + dataFinal + "' "
                                    + "AND KITS_HIGIENE_INTERNO.KitQuinzenal=1");
                        } else if (jComboBoxSelecionarKit.getSelectedItem().equals("Kit Mensal")) {
                            preencherTabelaRegistrosMontagemKits("SELECT DISTINCT "
                                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp, "
                                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp, "
                                    + "KITS_HIGIENE_INTERNO.IdKit, "
                                    + "KITS_HIGIENE_INTERNO.KitInicial, "
                                    + "KITS_HIGIENE_INTERNO.KitDecendial, "
                                    + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                                    + "KITS_HIGIENE_INTERNO.KitMensal, "
                                    + "KITS_HIGIENE_INTERNO.KitSemestral, "
                                    + "KITS_HIGIENE_INTERNO.KitAnual, "
                                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc, "
                                    + "COLABORADOR.NomeFunc "
                                    + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                                    + "INNER JOIN COLABORADOR "
                                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                                    + "INNER JOIN KITS_HIGIENE_INTERNO "
                                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                                    + "WHERE COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp BETWEEN'" + dataInicial + "' "
                                    + "AND '" + dataFinal + "' "
                                    + "AND KITS_HIGIENE_INTERNO.KitMensal=1");
                        } else if (jComboBoxSelecionarKit.getSelectedItem().equals("Kit Semestral")) {
                            preencherTabelaRegistrosMontagemKits("SELECT DISTINCT "
                                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp, "
                                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp, "
                                    + "KITS_HIGIENE_INTERNO.IdKit, "
                                    + "KITS_HIGIENE_INTERNO.KitInicial, "
                                    + "KITS_HIGIENE_INTERNO.KitDecendial, "
                                    + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                                    + "KITS_HIGIENE_INTERNO.KitMensal, "
                                    + "KITS_HIGIENE_INTERNO.KitSemestral, "
                                    + "KITS_HIGIENE_INTERNO.KitAnual, "
                                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc, "
                                    + "COLABORADOR.NomeFunc "
                                    + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                                    + "INNER JOIN COLABORADOR "
                                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                                    + "INNER JOIN KITS_HIGIENE_INTERNO "
                                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                                    + "WHERE COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp BETWEEN'" + dataInicial + "' "
                                    + "AND '" + dataFinal + "' "
                                    + "AND KITS_HIGIENE_INTERNO.KitSemestral=1");
                        } else if (jComboBoxSelecionarKit.getSelectedItem().equals("Kit Anual")) {
                            preencherTabelaRegistrosMontagemKits("SELECT DISTINCT "
                                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp, "
                                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp, "
                                    + "KITS_HIGIENE_INTERNO.IdKit, "
                                    + "KITS_HIGIENE_INTERNO.KitInicial, "
                                    + "KITS_HIGIENE_INTERNO.KitDecendial, "
                                    + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                                    + "KITS_HIGIENE_INTERNO.KitMensal, "
                                    + "KITS_HIGIENE_INTERNO.KitSemestral, "
                                    + "KITS_HIGIENE_INTERNO.KitAnual, "
                                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc, "
                                    + "COLABORADOR.NomeFunc "
                                    + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                                    + "INNER JOIN COLABORADOR "
                                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                                    + "INNER JOIN KITS_HIGIENE_INTERNO "
                                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                                    + "WHERE COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp BETWEEN'" + dataInicial + "' "
                                    + "AND '" + dataFinal + "' "
                                    + "AND KITS_HIGIENE_INTERNO.KitAnual=1");
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_jBtPesquisaDataActionPerformed

    private void jCheckBoxTodosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxTodosItemStateChanged
        // TODO add your handling code here:
        count = 0;
        count1 = 0;
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherTabelaRegistrosMontagemKits("SELECT DISTINCT "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp, "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp, "
                    + "KITS_HIGIENE_INTERNO.IdKit, "
                    + "KITS_HIGIENE_INTERNO.KitInicial, "
                    + "KITS_HIGIENE_INTERNO.KitDecendial, "
                    + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                    + "KITS_HIGIENE_INTERNO.KitMensal, "
                    + "KITS_HIGIENE_INTERNO.KitSemestral, "
                    + "KITS_HIGIENE_INTERNO.KitAnual, "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc, "
                    + "COLABORADOR.NomeFunc "
                    + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                    + "INNER JOIN COLABORADOR "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                    + "INNER JOIN KITS_HIGIENE_INTERNO "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit  "
                    + "ORDER BY DataComp");
        } else {
            limparTabela();
            jtotalRegistros.setText("");
        }
    }//GEN-LAST:event_jCheckBoxTodosItemStateChanged

    private void TabelaRegistrosMontagemKitsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaRegistrosMontagemKitsMouseClicked
        // TODO add your handling code here: 
        flag = 1;
        if (flag == 1) {
            idLanc = "" + TabelaRegistrosMontagemKits.getValueAt(TabelaRegistrosMontagemKits.getSelectedRow(), 0);
            jCodigoRegistroPesquisa.setText(idLanc);
            idKit = "" + TabelaRegistrosMontagemKits.getValueAt(TabelaRegistrosMontagemKits.getSelectedRow(), 2);
            codigoPesquisaKit = Integer.valueOf(idKit);
            tipoKit = "" + TabelaRegistrosMontagemKits.getValueAt(TabelaRegistrosMontagemKits.getSelectedRow(), 3);
            //
            if (tipoKit.equals("Kit Inicial")) {
                kitInicial = 1;
                jRBtKitInicialPesquisa.setSelected(true);
            } else if (tipoKit.equals("Kit Decendial")) {
                kitDecendial = 1;
                jRBtKitDecendialPesquisa.setSelected(true);
            } else if (tipoKit.equals("Kit Quinzenal")) {
                jRBtKitQuinzenalPesquisa.setSelected(true);
            } else if (tipoKit.equals("Kit Mensal")) {
                jRBtKitMensalPesquisa.setSelected(true);
            } else if (tipoKit.equals("Kit Semestral")) {
                jRBtKitSemestraPesquisa.setSelected(true);
            } else if (tipoKit.equals("Kit Anual")) {
                jRBtKitAnualPesquisa.setSelected(!true);
            }
        }
    }//GEN-LAST:event_TabelaRegistrosMontagemKitsMouseClicked

    private void jBtConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtConfirmarActionPerformed
        // TODO add your handling code here:
        limparTabelaItensKit();
        limparTabelasAbaPavIntComp();
        limparTabelaProdutosInternos();
        flag = 1;
        if (flag == 1) {
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            //
            jBtAdicionarTodosInternos.setEnabled(true);
            jBtAdicionarProdutosKitCompleto.setEnabled(true);
            //
            if (tipoKit.equals("Kit Inicial")) {
                kitInicial = 1;
                jRBtKitInicial.setSelected(true);
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT "
                            + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp, "
                            + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.StatusComp, "
                            + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp, "
                            + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdItem, "
                            + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit, "
                            + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc, "
                            + "COLABORADOR.NomeFunc, "
                            + "DEPARTAMENTOS.NomeDepartamento, "
                            + "COLABORADOR.ImagemFunc, "
                            + "COLABORADOR.ImagemFrenteCO, "
                            + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.Observacao "
                            + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                            + "INNER JOIN COLABORADOR "
                            + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                            + "INNER JOIN KITS_HIGIENE_INTERNO "
                            + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                            + "INNER JOIN DEPARTAMENTOS "
                            + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                            + "WHERE COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp='" + idLanc + "' ");
                    conecta.rs.first();
                    jIdRegistroComp.setText(String.valueOf(conecta.rs.getInt("IdRegistroComp")));
                    jStatusComp.setText(conecta.rs.getString("StatusComp"));
                    jDataComp.setDate(conecta.rs.getDate("DataComp"));
                    codigoPesquisaKitItem = conecta.rs.getInt("IdItem");
                    pPESQUISA_ID_kit = conecta.rs.getInt("IdKit");
                    if (kitInicial == 1) {
                        jRBtKitInicial.setSelected(true);
                    } else if (kitInicial == 0) {
                        jRBtKitInicial.setSelected(!true);
                    }
                    jIdFunc.setText(String.valueOf(conecta.rs.getInt("IdFunc")));
                    jNomeColaborador.setText(conecta.rs.getString("NomeFunc"));
                    jDepartamentoColaborador.setText(conecta.rs.getString("NomeDepartamento"));
                    caminhoFoto = conecta.rs.getString("ImagemFunc");
                    if (caminhoFoto != null) {
                        javax.swing.ImageIcon a = new javax.swing.ImageIcon(caminhoFoto);
                        jFotoColaborador.setIcon(a);
                        jFotoColaborador.setIcon(new ImageIcon(a.getImage().getScaledInstance(jFotoColaborador.getWidth(), jFotoColaborador.getHeight(), Image.SCALE_DEFAULT)));
                    }
                    // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                    byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrenteCO"));
                    if (imgBytes != null) {
                        ImageIcon pic = null;
                        pic = new ImageIcon(imgBytes);
                        Image scaled = pic.getImage().getScaledInstance(jFotoColaborador.getWidth(), jFotoColaborador.getHeight(), Image.SCALE_DEFAULT);
                        ImageIcon icon = new ImageIcon(scaled);
                        jFotoColaborador.setIcon(icon);
                    }
                    jObservacao.setText(conecta.rs.getString("Observacao"));
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa..." + e);
                }
                mostrarInternosSelecionados();
                mostrarProdutosSelecionados();
                mostrarInternosKitCompleto();
                mostrarProdutosKitCompleto();
                conecta.desconecta();
                dispose();
            } else if (tipoKit.equals("Kit Decendial")) {
                kitDecendial = 1;
                jRBtKitDecendial.setSelected(true);
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT "
                            + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp, "
                            + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.StatusComp, "
                            + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp, "
                            + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdItem, "
                            + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit, "
                            + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc, "
                            + "COLABORADOR.NomeFunc, "
                            + "DEPARTAMENTOS.NomeDepartamento, "
                            + "COLABORADOR.ImagemFunc, "
                            + "COLABORADOR.ImagemFrenteCO, "
                            + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.Observacao "
                            + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                            + "INNER JOIN COLABORADOR "
                            + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                            + "INNER JOIN KITS_HIGIENE_INTERNO "
                            + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                            + "INNER JOIN DEPARTAMENTOS "
                            + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                            + "WHERE COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp='" + idLanc + "' ");
                    conecta.rs.first();
                    jIdRegistroComp.setText(String.valueOf(conecta.rs.getInt("IdRegistroComp")));
                    jStatusComp.setText(conecta.rs.getString("StatusComp"));
                    jDataComp.setDate(conecta.rs.getDate("DataComp"));
                    codigoPesquisaKitItem = conecta.rs.getInt("IdItem");
                    pPESQUISA_ID_kit = conecta.rs.getInt("IdKit");
                    kitDecendial = conecta.rs.getInt("KitDecendial");
                    if (kitDecendial == 1) {
                        jRBtKitDecendial.setSelected(true);
                    } else if (kitDecendial == 0) {
                        jRBtKitDecendial.setSelected(!true);
                    }
                    jIdFunc.setText(String.valueOf(conecta.rs.getInt("IdFunc")));
                    jNomeColaborador.setText(conecta.rs.getString("NomeFunc"));
                    jDepartamentoColaborador.setText(conecta.rs.getString("NomeDepartamento"));
                    caminhoFoto = conecta.rs.getString("ImagemFunc");
                    if (caminhoFoto != null) {
                        javax.swing.ImageIcon a = new javax.swing.ImageIcon(caminhoFoto);
                        jFotoColaborador.setIcon(a);
                        jFotoColaborador.setIcon(new ImageIcon(a.getImage().getScaledInstance(jFotoColaborador.getWidth(), jFotoColaborador.getHeight(), Image.SCALE_DEFAULT)));
                    }
                    // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                    byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrenteCO"));
                    if (imgBytes != null) {
                        ImageIcon pic = null;
                        pic = new ImageIcon(imgBytes);
                        Image scaled = pic.getImage().getScaledInstance(jFotoColaborador.getWidth(), jFotoColaborador.getHeight(), Image.SCALE_DEFAULT);
                        ImageIcon icon = new ImageIcon(scaled);
                        jFotoColaborador.setIcon(icon);
                    }
                    jObservacao.setText(conecta.rs.getString("Observacao"));
                } catch (Exception e) {
                }
                mostrarInternosSelecionados();
                mostrarProdutosSelecionados();
                mostrarInternosKitCompleto();
                mostrarProdutosKitCompleto();
                conecta.desconecta();
                dispose();
            } else if (kitQuinzenal == 1) {
                kitQuinzenal = 1;
                jRBtKitQuinzenal.setSelected(true);
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT "
                            + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp, "
                            + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.StatusComp, "
                            + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp, "
                            + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdItem, "
                            + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit, "
                            + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc, "
                            + "COLABORADOR.NomeFunc, "
                            + "DEPARTAMENTOS.NomeDepartamento, "
                            + "COLABORADOR.ImagemFunc, "
                            + "COLABORADOR.ImagemFrenteCO, "
                            + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.Observacao "
                            + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                            + "INNER JOIN COLABORADOR "
                            + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                            + "INNER JOIN KITS_HIGIENE_INTERNO "
                            + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                            + "INNER JOIN DEPARTAMENTOS "
                            + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                            + "WHERE COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp='" + idLanc + "' ");
                    conecta.rs.first();
                    jIdRegistroComp.setText(String.valueOf(conecta.rs.getInt("IdRegistroComp")));
                    jStatusComp.setText(conecta.rs.getString("StatusComp"));
                    jDataComp.setDate(conecta.rs.getDate("DataComp"));
                    codigoPesquisaKitItem = conecta.rs.getInt("IdItem");
                    pPESQUISA_ID_kit = conecta.rs.getInt("IdKit");
                    kitQuinzenal = conecta.rs.getInt("KitQuinzenal");
                    if (kitQuinzenal == 1) {
                        jRBtKitQuinzenal.setSelected(true);
                    } else if (kitQuinzenal == 0) {
                        jRBtKitQuinzenal.setSelected(!true);
                    }
                    jIdFunc.setText(String.valueOf(conecta.rs.getInt("IdFunc")));
                    jNomeColaborador.setText(conecta.rs.getString("NomeFunc"));
                    jDepartamentoColaborador.setText(conecta.rs.getString("NomeDepartamento"));
                    caminhoFoto = conecta.rs.getString("ImagemFunc");
                    if (caminhoFoto != null) {
                        javax.swing.ImageIcon a = new javax.swing.ImageIcon(caminhoFoto);
                        jFotoColaborador.setIcon(a);
                        jFotoColaborador.setIcon(new ImageIcon(a.getImage().getScaledInstance(jFotoColaborador.getWidth(), jFotoColaborador.getHeight(), Image.SCALE_DEFAULT)));
                    }
                    // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                    byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrenteCO"));
                    if (imgBytes != null) {
                        ImageIcon pic = null;
                        pic = new ImageIcon(imgBytes);
                        Image scaled = pic.getImage().getScaledInstance(jFotoColaborador.getWidth(), jFotoColaborador.getHeight(), Image.SCALE_DEFAULT);
                        ImageIcon icon = new ImageIcon(scaled);
                        jFotoColaborador.setIcon(icon);
                    }
                    jObservacao.setText(conecta.rs.getString("Observacao"));
                } catch (Exception e) {
                }
                mostrarInternosSelecionados();
                mostrarProdutosSelecionados();
                mostrarInternosKitCompleto();
                mostrarProdutosKitCompleto();
                conecta.desconecta();
                dispose();
            } else if (kitMensal == 1) {
                kitMensal = 1;
                jRBtKitMensal.setSelected(true);
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT "
                            + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp, "
                            + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.StatusComp, "
                            + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp, "
                            + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdItem, "
                            + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit, "
                            + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc, "
                            + "COLABORADOR.NomeFunc, "
                            + "DEPARTAMENTOS.NomeDepartamento, "
                            + "COLABORADOR.ImagemFunc, "
                            + "COLABORADOR.ImagemFrenteCO, "
                            + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.Observacao "
                            + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                            + "INNER JOIN COLABORADOR "
                            + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                            + "INNER JOIN KITS_HIGIENE_INTERNO "
                            + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                            + "INNER JOIN DEPARTAMENTOS "
                            + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                            + "WHERE COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp='" + idLanc + "' ");
                    conecta.rs.first();
                    jIdRegistroComp.setText(String.valueOf(conecta.rs.getInt("IdRegistroComp")));
                    jStatusComp.setText(conecta.rs.getString("StatusComp"));
                    jDataComp.setDate(conecta.rs.getDate("DataComp"));
                    codigoPesquisaKitItem = conecta.rs.getInt("IdItem");
                    pPESQUISA_ID_kit = conecta.rs.getInt("IdKit");
                    kitDecendial = conecta.rs.getInt("KitMensal");
                    if (kitMensal == 1) {
                        jRBtKitMensal.setSelected(true);
                    } else if (kitMensal == 0) {
                        jRBtKitMensal.setSelected(!true);
                    }
                    jIdFunc.setText(String.valueOf(conecta.rs.getInt("IdFunc")));
                    jNomeColaborador.setText(conecta.rs.getString("NomeFunc"));
                    jDepartamentoColaborador.setText(conecta.rs.getString("NomeDepartamento"));
                    caminhoFoto = conecta.rs.getString("ImagemFunc");
                    if (caminhoFoto != null) {
                        javax.swing.ImageIcon a = new javax.swing.ImageIcon(caminhoFoto);
                        jFotoColaborador.setIcon(a);
                        jFotoColaborador.setIcon(new ImageIcon(a.getImage().getScaledInstance(jFotoColaborador.getWidth(), jFotoColaborador.getHeight(), Image.SCALE_DEFAULT)));
                    }
                    // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                    byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrenteCO"));
                    if (imgBytes != null) {
                        ImageIcon pic = null;
                        pic = new ImageIcon(imgBytes);
                        Image scaled = pic.getImage().getScaledInstance(jFotoColaborador.getWidth(), jFotoColaborador.getHeight(), Image.SCALE_DEFAULT);
                        ImageIcon icon = new ImageIcon(scaled);
                        jFotoColaborador.setIcon(icon);
                    }
                    jObservacao.setText(conecta.rs.getString("Observacao"));
                } catch (Exception e) {
                }
                mostrarInternosSelecionados();
                mostrarProdutosSelecionados();
                mostrarInternosKitCompleto();
                mostrarProdutosKitCompleto();
                conecta.desconecta();
                dispose();
            } else if (kitSemestral == 1) {
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT "
                            + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp, "
                            + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.StatusComp, "
                            + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp, "
                            + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdItem, "
                            + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit, "
                            + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc, "
                            + "COLABORADOR.NomeFunc, "
                            + "DEPARTAMENTOS.NomeDepartamento, "
                            + "COLABORADOR.ImagemFunc, "
                            + "COLABORADOR.ImagemFrenteCO, "
                            + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.Observacao "
                            + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                            + "INNER JOIN COLABORADOR "
                            + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                            + "INNER JOIN KITS_HIGIENE_INTERNO "
                            + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                            + "INNER JOIN DEPARTAMENTOS "
                            + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                            + "WHERE COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp='" + idLanc + "' ");
                    conecta.rs.first();
                    jIdRegistroComp.setText(String.valueOf(conecta.rs.getInt("IdRegistroComp")));
                    jStatusComp.setText(conecta.rs.getString("StatusComp"));
                    jDataComp.setDate(conecta.rs.getDate("DataComp"));
                    codigoPesquisaKitItem = conecta.rs.getInt("IdItem");
                    pPESQUISA_ID_kit = conecta.rs.getInt("IdKit");
                    kitSemestral = conecta.rs.getInt("KitSemestral");
                    if (kitSemestral == 1) {
                        jRBtKitSemestral.setSelected(true);
                    } else if (kitSemestral == 0) {
                        jRBtKitSemestral.setSelected(!true);
                    }
                    jIdFunc.setText(String.valueOf(conecta.rs.getInt("IdFunc")));
                    jNomeColaborador.setText(conecta.rs.getString("NomeFunc"));
                    jDepartamentoColaborador.setText(conecta.rs.getString("NomeDepartamento"));
                    caminhoFoto = conecta.rs.getString("ImagemFunc");
                    if (caminhoFoto != null) {
                        javax.swing.ImageIcon a = new javax.swing.ImageIcon(caminhoFoto);
                        jFotoColaborador.setIcon(a);
                        jFotoColaborador.setIcon(new ImageIcon(a.getImage().getScaledInstance(jFotoColaborador.getWidth(), jFotoColaborador.getHeight(), Image.SCALE_DEFAULT)));
                    }
                    // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                    byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrenteCO"));
                    if (imgBytes != null) {
                        ImageIcon pic = null;
                        pic = new ImageIcon(imgBytes);
                        Image scaled = pic.getImage().getScaledInstance(jFotoColaborador.getWidth(), jFotoColaborador.getHeight(), Image.SCALE_DEFAULT);
                        ImageIcon icon = new ImageIcon(scaled);
                        jFotoColaborador.setIcon(icon);
                    }
                    jObservacao.setText(conecta.rs.getString("Observacao"));
                } catch (Exception e) {
                }
                mostrarInternosSelecionados();
                mostrarProdutosSelecionados();
                mostrarInternosKitCompleto();
                mostrarProdutosKitCompleto();
                conecta.desconecta();
                dispose();
            } else if (kitAnual == 1) {
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT "
                            + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp, "
                            + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.StatusComp, "
                            + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp, "
                            + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdItem, "
                            + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit, "
                            + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc, "
                            + "COLABORADOR.NomeFunc, "
                            + "DEPARTAMENTOS.NomeDepartamento, "
                            + "COLABORADOR.ImagemFunc, "
                            + "COLABORADOR.ImagemFrenteCO, "
                            + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.Observacao "
                            + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                            + "INNER JOIN COLABORADOR "
                            + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                            + "INNER JOIN KITS_HIGIENE_INTERNO "
                            + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                            + "INNER JOIN DEPARTAMENTOS "
                            + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                            + "WHERE COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp='" + idLanc + "' ");
                    conecta.rs.first();
                    jIdRegistroComp.setText(String.valueOf(conecta.rs.getInt("IdRegistroComp")));
                    jStatusComp.setText(conecta.rs.getString("StatusComp"));
                    jDataComp.setDate(conecta.rs.getDate("DataComp"));
                    codigoPesquisaKitItem = conecta.rs.getInt("IdItem");
                    pPESQUISA_ID_kit = conecta.rs.getInt("IdKit");
//                    codigoPesquisaKit = conecta.rs.getInt("IdKit");
                    kitAnual = conecta.rs.getInt("KitAnual");
                    if (kitAnual == 1) {
                        jRBtKitAnual.setSelected(true);
                    } else if (kitAnual == 0) {
                        jRBtKitAnual.setSelected(!true);
                    }
                    jIdFunc.setText(String.valueOf(conecta.rs.getInt("IdFunc")));
                    jNomeColaborador.setText(conecta.rs.getString("NomeFunc"));
                    jDepartamentoColaborador.setText(conecta.rs.getString("NomeDepartamento"));
                    caminhoFoto = conecta.rs.getString("ImagemFunc");
                    if (caminhoFoto != null) {
                        javax.swing.ImageIcon a = new javax.swing.ImageIcon(caminhoFoto);
                        jFotoColaborador.setIcon(a);
                        jFotoColaborador.setIcon(new ImageIcon(a.getImage().getScaledInstance(jFotoColaborador.getWidth(), jFotoColaborador.getHeight(), Image.SCALE_DEFAULT)));
                    }
                    // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                    byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrenteCO"));
                    if (imgBytes != null) {
                        ImageIcon pic = null;
                        pic = new ImageIcon(imgBytes);
                        Image scaled = pic.getImage().getScaledInstance(jFotoColaborador.getWidth(), jFotoColaborador.getHeight(), Image.SCALE_DEFAULT);
                        ImageIcon icon = new ImageIcon(scaled);
                        jFotoColaborador.setIcon(icon);
                    }
                    jObservacao.setText(conecta.rs.getString("Observacao"));
                } catch (Exception e) {
                }
                mostrarInternosSelecionados();
                mostrarProdutosSelecionados();
                mostrarInternosKitCompleto();
                mostrarProdutosKitCompleto();
                conecta.desconecta();
                dispose();
            }
        }
    }//GEN-LAST:event_jBtConfirmarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:        
        if (jIdRegistroComp.getText().equals("")) {
            jBtNovo.setEnabled(true);
        } else {
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            jBtFinalizar.setEnabled(true);
        }
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtPesquisaTipoKitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisaTipoKitActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (jComboBoxSelecionarKit.getSelectedItem().equals("Selecione...")) {
            JOptionPane.showMessageDialog(rootPane, "Selecione um tipo de kit para pesquisar.");
        } else if (jComboBoxSelecionarKit.getSelectedItem().equals("Kit Inicial") && jDataPesqInicial.getDate() == null || jComboBoxSelecionarKit.getSelectedItem().equals("Kit Inicial") && jDataPesFinal.getDate() == null) {
            preencherTabelaRegistrosMontagemKits2("SELECT "
                    + "DISTINCT COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp, "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp, "
                    + "KITS_HIGIENE_INTERNO.IdKit, "
                    + "KITS_HIGIENE_INTERNO.KitInicial, "
                    + "KITS_HIGIENE_INTERNO.KitDecendial, "
                    + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                    + "KITS_HIGIENE_INTERNO.KitMensal, "
                    + "KITS_HIGIENE_INTERNO.KitSemestral, "
                    + "KITS_HIGIENE_INTERNO.KitAnual, "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc, "
                    + "COLABORADOR.NomeFunc, "
                    + "INTERNOS_PAVILHAO_KIT_LOTE.IdPav, "
                    + "PAVILHAO.DescricaoPav "
                    + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                    + "INNER JOIN COLABORADOR "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                    + "INNER JOIN DEPARTAMENTOS "
                    + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                    + "INNER JOIN KITS_HIGIENE_INTERNO "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                    + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdItem=PRODUTOS_KITS_HIGIENE_INTERNO.IdItem "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                    + "INNER JOIN INTERNOS_PAVILHAO_KIT_LOTE "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp=INTERNOS_PAVILHAO_KIT_LOTE.IdRegistroComp "
                    + "INNER JOIN PAVILHAO "
                    + "ON INTERNOS_PAVILHAO_KIT_LOTE.IdPav=PAVILHAO.IdPav "
                    + "WHERE KITS_HIGIENE_INTERNO.KitInicial=1 "
                    + "ORDER BY DataComp");
        } else if (jComboBoxSelecionarKit.getSelectedItem().equals("Kit Inicial") && jDataPesqInicial.getDate() != null && jDataPesFinal.getDate() != null) {
            if (tipoServidor == null || tipoServidor.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário definir o parâmtero para o sistema operacional utilizado no servidor, (UBUNTU-LINUX ou WINDOWS SERVER).");
            } else if (tipoServidor.equals("Servidor Linux (Ubuntu)/MS-SQL Server")) {
                SimpleDateFormat formatoAmerica = new SimpleDateFormat("yyyy/MM/dd");
                dataInicial = formatoAmerica.format(jDataPesqInicial.getDate().getTime());
                dataFinal = formatoAmerica.format(jDataPesFinal.getDate().getTime());
                preencherTabelaRegistrosMontagemKits2("SELECT "
                        + "DISTINCT COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp, "
                        + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp, "
                        + "KITS_HIGIENE_INTERNO.IdKit, "
                        + "KITS_HIGIENE_INTERNO.KitInicial, "
                        + "KITS_HIGIENE_INTERNO.KitDecendial, "
                        + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                        + "KITS_HIGIENE_INTERNO.KitMensal, "
                        + "KITS_HIGIENE_INTERNO.KitSemestral, "
                        + "KITS_HIGIENE_INTERNO.KitAnual, "
                        + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc, "
                        + "COLABORADOR.NomeFunc, "
                        + "INTERNOS_PAVILHAO_KIT_LOTE.IdPav, "
                        + "PAVILHAO.DescricaoPav "
                        + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                        + "INNER JOIN COLABORADOR "
                        + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                        + "INNER JOIN DEPARTAMENTOS "
                        + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                        + "INNER JOIN KITS_HIGIENE_INTERNO "
                        + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                        + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                        + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdItem=PRODUTOS_KITS_HIGIENE_INTERNO.IdItem "
                        + "INNER JOIN PRODUTOS_AC "
                        + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                        + "INNER JOIN INTERNOS_PAVILHAO_KIT_LOTE "
                        + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp=INTERNOS_PAVILHAO_KIT_LOTE.IdRegistroComp "
                        + "INNER JOIN PAVILHAO "
                        + "ON INTERNOS_PAVILHAO_KIT_LOTE.IdPav=PAVILHAO.IdPav "
                        + "WHERE DataComp BETWEEN'" + dataInicial + "' "
                        + "AND'" + dataFinal + "' "
                        + "AND KITS_HIGIENE_INTERNO.KitInicial=1 "
                        + "ORDER BY DataComp");
            } else if (tipoServidor.equals("Servidor Windows/MS-SQL Server")) {
                SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
                dataInicial = formatoAmerica.format(jDataPesqInicial.getDate().getTime());
                dataFinal = formatoAmerica.format(jDataPesFinal.getDate().getTime());
                preencherTabelaRegistrosMontagemKits2("SELECT "
                        + "DISTINCT COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp, "
                        + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp, "
                        + "KITS_HIGIENE_INTERNO.IdKit, "
                        + "KITS_HIGIENE_INTERNO.KitInicial, "
                        + "KITS_HIGIENE_INTERNO.KitDecendial, "
                        + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                        + "KITS_HIGIENE_INTERNO.KitMensal, "
                        + "KITS_HIGIENE_INTERNO.KitSemestral, "
                        + "KITS_HIGIENE_INTERNO.KitAnual, "
                        + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc, "
                        + "COLABORADOR.NomeFunc, "
                        + "INTERNOS_PAVILHAO_KIT_LOTE.IdPav, "
                        + "PAVILHAO.DescricaoPav "
                        + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                        + "INNER JOIN COLABORADOR "
                        + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                        + "INNER JOIN DEPARTAMENTOS "
                        + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                        + "INNER JOIN KITS_HIGIENE_INTERNO "
                        + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                        + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                        + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdItem=PRODUTOS_KITS_HIGIENE_INTERNO.IdItem "
                        + "INNER JOIN PRODUTOS_AC "
                        + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                        + "INNER JOIN INTERNOS_PAVILHAO_KIT_LOTE "
                        + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp=INTERNOS_PAVILHAO_KIT_LOTE.IdRegistroComp "
                        + "INNER JOIN PAVILHAO "
                        + "ON INTERNOS_PAVILHAO_KIT_LOTE.IdPav=PAVILHAO.IdPav "
                        + "WHERE DataComp BETWEEN'" + dataInicial + "' "
                        + "AND'" + dataFinal + "' "
                        + "AND KITS_HIGIENE_INTERNO.KitInicial=1 "
                        + "ORDER BY DataComp");
            }
        } else if (jComboBoxSelecionarKit.getSelectedItem().equals("Kit Decendial") && jDataPesqInicial.getDate() == null || jComboBoxSelecionarKit.getSelectedItem().equals("Kit Decendial") && jDataPesFinal.getDate() == null) {
            preencherTabelaRegistrosMontagemKits2("SELECT "
                    + "DISTINCT COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp, "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp, "
                    + "KITS_HIGIENE_INTERNO.IdKit, "
                    + "KITS_HIGIENE_INTERNO.KitInicial, "
                    + "KITS_HIGIENE_INTERNO.KitDecendial, "
                    + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                    + "KITS_HIGIENE_INTERNO.KitMensal, "
                    + "KITS_HIGIENE_INTERNO.KitSemestral, "
                    + "KITS_HIGIENE_INTERNO.KitAnual, "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc, "
                    + "COLABORADOR.NomeFunc, "
                    + "INTERNOS_PAVILHAO_KIT_LOTE.IdPav, "
                    + "PAVILHAO.DescricaoPav "
                    + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                    + "INNER JOIN COLABORADOR "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                    + "INNER JOIN DEPARTAMENTOS "
                    + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                    + "INNER JOIN KITS_HIGIENE_INTERNO "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                    + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdItem=PRODUTOS_KITS_HIGIENE_INTERNO.IdItem "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                    + "INNER JOIN INTERNOS_PAVILHAO_KIT_LOTE "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp=INTERNOS_PAVILHAO_KIT_LOTE.IdRegistroComp "
                    + "INNER JOIN PAVILHAO "
                    + "ON INTERNOS_PAVILHAO_KIT_LOTE.IdPav=PAVILHAO.IdPav "
                    + "WHERE KITS_HIGIENE_INTERNO.KitDecendial=1 "
                    + "ORDER BY DataComp");
        } else if (jComboBoxSelecionarKit.getSelectedItem().equals("Kit Decendial") && jDataPesqInicial.getDate() != null && jDataPesFinal.getDate() != null) {
            if (tipoServidor == null || tipoServidor.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário definir o parâmtero para o sistema operacional utilizado no servidor, (UBUNTU-LINUX ou WINDOWS SERVER).");
            } else if (tipoServidor.equals("Servidor Linux (Ubuntu)/MS-SQL Server")) {
                SimpleDateFormat formatoAmerica = new SimpleDateFormat("yyyy/MM/dd");
                dataInicial = formatoAmerica.format(jDataPesqInicial.getDate().getTime());
                dataFinal = formatoAmerica.format(jDataPesFinal.getDate().getTime());
                preencherTabelaRegistrosMontagemKits2("SELECT "
                        + "DISTINCT COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp, "
                        + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp, "
                        + "KITS_HIGIENE_INTERNO.IdKit, "
                        + "KITS_HIGIENE_INTERNO.KitInicial, "
                        + "KITS_HIGIENE_INTERNO.KitDecendial, "
                        + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                        + "KITS_HIGIENE_INTERNO.KitMensal, "
                        + "KITS_HIGIENE_INTERNO.KitSemestral, "
                        + "KITS_HIGIENE_INTERNO.KitAnual, "
                        + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc, "
                        + "COLABORADOR.NomeFunc, "
                        + "INTERNOS_PAVILHAO_KIT_LOTE.IdPav, "
                        + "PAVILHAO.DescricaoPav "
                        + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                        + "INNER JOIN COLABORADOR "
                        + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                        + "INNER JOIN DEPARTAMENTOS "
                        + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                        + "INNER JOIN KITS_HIGIENE_INTERNO "
                        + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                        + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                        + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdItem=PRODUTOS_KITS_HIGIENE_INTERNO.IdItem "
                        + "INNER JOIN PRODUTOS_AC "
                        + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                        + "INNER JOIN INTERNOS_PAVILHAO_KIT_LOTE "
                        + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp=INTERNOS_PAVILHAO_KIT_LOTE.IdRegistroComp "
                        + "INNER JOIN PAVILHAO "
                        + "ON INTERNOS_PAVILHAO_KIT_LOTE.IdPav=PAVILHAO.IdPav "
                        + "WHERE DataComp BETWEEN'" + dataInicial + "' "
                        + "AND'" + dataFinal + "' "
                        + "AND KITS_HIGIENE_INTERNO.KitDecendial=1 "
                        + "ORDER BY DataComp");
            } else if (tipoServidor.equals("Servidor Windows/MS-SQL Server")) {
                SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
                dataInicial = formatoAmerica.format(jDataPesqInicial.getDate().getTime());
                dataFinal = formatoAmerica.format(jDataPesFinal.getDate().getTime());
                preencherTabelaRegistrosMontagemKits2("SELECT "
                        + "DISTINCT COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp, "
                        + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp, "
                        + "KITS_HIGIENE_INTERNO.IdKit, "
                        + "KITS_HIGIENE_INTERNO.KitInicial, "
                        + "KITS_HIGIENE_INTERNO.KitDecendial, "
                        + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                        + "KITS_HIGIENE_INTERNO.KitMensal, "
                        + "KITS_HIGIENE_INTERNO.KitSemestral, "
                        + "KITS_HIGIENE_INTERNO.KitAnual, "
                        + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc, "
                        + "COLABORADOR.NomeFunc, "
                        + "INTERNOS_PAVILHAO_KIT_LOTE.IdPav, "
                        + "PAVILHAO.DescricaoPav "
                        + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                        + "INNER JOIN COLABORADOR "
                        + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                        + "INNER JOIN DEPARTAMENTOS "
                        + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                        + "INNER JOIN KITS_HIGIENE_INTERNO "
                        + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                        + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                        + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdItem=PRODUTOS_KITS_HIGIENE_INTERNO.IdItem "
                        + "INNER JOIN PRODUTOS_AC "
                        + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                        + "INNER JOIN INTERNOS_PAVILHAO_KIT_LOTE "
                        + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp=INTERNOS_PAVILHAO_KIT_LOTE.IdRegistroComp "
                        + "INNER JOIN PAVILHAO "
                        + "ON INTERNOS_PAVILHAO_KIT_LOTE.IdPav=PAVILHAO.IdPav "
                        + "WHERE DataComp BETWEEN'" + dataInicial + "' "
                        + "AND'" + dataFinal + "' "
                        + "AND KITS_HIGIENE_INTERNO.KitDecendial=1 "
                        + "ORDER BY DataComp");
            }
        } else if (jComboBoxSelecionarKit.getSelectedItem().equals("Kit Quinzenal") && jDataPesqInicial.getDate() == null || jComboBoxSelecionarKit.getSelectedItem().equals("Kit Quibzenal") && jDataPesFinal.getDate() == null) {
            preencherTabelaRegistrosMontagemKits2("SELECT "
                    + "DISTINCT COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp, "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp, "
                    + "KITS_HIGIENE_INTERNO.IdKit, "
                    + "KITS_HIGIENE_INTERNO.KitInicial, "
                    + "KITS_HIGIENE_INTERNO.KitDecendial, "
                    + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                    + "KITS_HIGIENE_INTERNO.KitMensal, "
                    + "KITS_HIGIENE_INTERNO.KitSemestral, "
                    + "KITS_HIGIENE_INTERNO.KitAnual, "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc, "
                    + "COLABORADOR.NomeFunc, "
                    + "INTERNOS_PAVILHAO_KIT_LOTE.IdPav, "
                    + "PAVILHAO.DescricaoPav "
                    + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                    + "INNER JOIN COLABORADOR "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                    + "INNER JOIN DEPARTAMENTOS "
                    + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                    + "INNER JOIN KITS_HIGIENE_INTERNO "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                    + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdItem=PRODUTOS_KITS_HIGIENE_INTERNO.IdItem "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                    + "INNER JOIN INTERNOS_PAVILHAO_KIT_LOTE "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp=INTERNOS_PAVILHAO_KIT_LOTE.IdRegistroComp "
                    + "INNER JOIN PAVILHAO "
                    + "ON INTERNOS_PAVILHAO_KIT_LOTE.IdPav=PAVILHAO.IdPav "
                    + "WHERE KITS_HIGIENE_INTERNO.KitQuinzenal=1 "
                    + "ORDER BY DataComp");
        } else if (jComboBoxSelecionarKit.getSelectedItem().equals("Kit Quinzenal") && jDataPesqInicial.getDate() != null && jDataPesFinal.getDate() != null) {
            if (tipoServidor == null || tipoServidor.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário definir o parâmtero para o sistema operacional utilizado no servidor, (UBUNTU-LINUX ou WINDOWS SERVER).");
            } else if (tipoServidor.equals("Servidor Linux (Ubuntu)/MS-SQL Server")) {
                SimpleDateFormat formatoAmerica = new SimpleDateFormat("yyyy/MM/dd");
                dataInicial = formatoAmerica.format(jDataPesqInicial.getDate().getTime());
                dataFinal = formatoAmerica.format(jDataPesFinal.getDate().getTime());
                preencherTabelaRegistrosMontagemKits2("SELECT "
                        + "DISTINCT COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp, "
                        + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp, "
                        + "KITS_HIGIENE_INTERNO.IdKit, "
                        + "KITS_HIGIENE_INTERNO.KitInicial, "
                        + "KITS_HIGIENE_INTERNO.KitDecendial, "
                        + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                        + "KITS_HIGIENE_INTERNO.KitMensal, "
                        + "KITS_HIGIENE_INTERNO.KitSemestral, "
                        + "KITS_HIGIENE_INTERNO.KitAnual, "
                        + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc, "
                        + "COLABORADOR.NomeFunc, "
                        + "INTERNOS_PAVILHAO_KIT_LOTE.IdPav, "
                        + "PAVILHAO.DescricaoPav "
                        + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                        + "INNER JOIN COLABORADOR "
                        + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                        + "INNER JOIN DEPARTAMENTOS "
                        + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                        + "INNER JOIN KITS_HIGIENE_INTERNO "
                        + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                        + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                        + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdItem=PRODUTOS_KITS_HIGIENE_INTERNO.IdItem "
                        + "INNER JOIN PRODUTOS_AC "
                        + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                        + "INNER JOIN INTERNOS_PAVILHAO_KIT_LOTE "
                        + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp=INTERNOS_PAVILHAO_KIT_LOTE.IdRegistroComp "
                        + "INNER JOIN PAVILHAO "
                        + "ON INTERNOS_PAVILHAO_KIT_LOTE.IdPav=PAVILHAO.IdPav "
                        + "WHERE DataComp BETWEEN'" + dataInicial + "' "
                        + "AND'" + dataFinal + "' "
                        + "AND KITS_HIGIENE_INTERNO.KitQuinzenal=1 "
                        + "ORDER BY DataComp");
            } else if (tipoServidor.equals("Servidor Windows/MS-SQL Server")) {
                SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
                dataInicial = formatoAmerica.format(jDataPesqInicial.getDate().getTime());
                dataFinal = formatoAmerica.format(jDataPesFinal.getDate().getTime());
                preencherTabelaRegistrosMontagemKits2("SELECT "
                        + "DISTINCT COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp, "
                        + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp, "
                        + "KITS_HIGIENE_INTERNO.IdKit, "
                        + "KITS_HIGIENE_INTERNO.KitInicial, "
                        + "KITS_HIGIENE_INTERNO.KitDecendial, "
                        + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                        + "KITS_HIGIENE_INTERNO.KitMensal, "
                        + "KITS_HIGIENE_INTERNO.KitSemestral, "
                        + "KITS_HIGIENE_INTERNO.KitAnual, "
                        + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc, "
                        + "COLABORADOR.NomeFunc, "
                        + "INTERNOS_PAVILHAO_KIT_LOTE.IdPav, "
                        + "PAVILHAO.DescricaoPav "
                        + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                        + "INNER JOIN COLABORADOR "
                        + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                        + "INNER JOIN DEPARTAMENTOS "
                        + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                        + "INNER JOIN KITS_HIGIENE_INTERNO "
                        + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                        + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                        + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdItem=PRODUTOS_KITS_HIGIENE_INTERNO.IdItem "
                        + "INNER JOIN PRODUTOS_AC "
                        + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                        + "INNER JOIN INTERNOS_PAVILHAO_KIT_LOTE "
                        + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp=INTERNOS_PAVILHAO_KIT_LOTE.IdRegistroComp "
                        + "INNER JOIN PAVILHAO "
                        + "ON INTERNOS_PAVILHAO_KIT_LOTE.IdPav=PAVILHAO.IdPav "
                        + "WHERE DataComp BETWEEN'" + dataInicial + "' "
                        + "AND'" + dataFinal + "' "
                        + "AND KITS_HIGIENE_INTERNO.KitQuinzenal=1 "
                        + "ORDER BY DataComp");
            }
        } else if (jComboBoxSelecionarKit.getSelectedItem().equals("Kit Mensal") && jDataPesqInicial.getDate() == null || jComboBoxSelecionarKit.getSelectedItem().equals("Kit Mensal") && jDataPesFinal.getDate() == null) {
            preencherTabelaRegistrosMontagemKits2("SELECT "
                    + "DISTINCT COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp, "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp, "
                    + "KITS_HIGIENE_INTERNO.IdKit, "
                    + "KITS_HIGIENE_INTERNO.KitInicial, "
                    + "KITS_HIGIENE_INTERNO.KitDecendial, "
                    + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                    + "KITS_HIGIENE_INTERNO.KitMensal, "
                    + "KITS_HIGIENE_INTERNO.KitSemestral, "
                    + "KITS_HIGIENE_INTERNO.KitAnual, "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc, "
                    + "COLABORADOR.NomeFunc, "
                    + "INTERNOS_PAVILHAO_KIT_LOTE.IdPav, "
                    + "PAVILHAO.DescricaoPav "
                    + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                    + "INNER JOIN COLABORADOR "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                    + "INNER JOIN DEPARTAMENTOS "
                    + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                    + "INNER JOIN KITS_HIGIENE_INTERNO "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                    + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdItem=PRODUTOS_KITS_HIGIENE_INTERNO.IdItem "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                    + "INNER JOIN INTERNOS_PAVILHAO_KIT_LOTE "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp=INTERNOS_PAVILHAO_KIT_LOTE.IdRegistroComp "
                    + "INNER JOIN PAVILHAO "
                    + "ON INTERNOS_PAVILHAO_KIT_LOTE.IdPav=PAVILHAO.IdPav "
                    + "WHERE KITS_HIGIENE_INTERNO.KitMensal=1 "
                    + "ORDER BY DataComp");
        } else if (jComboBoxSelecionarKit.getSelectedItem().equals("Kit Mensal") && jDataPesqInicial.getDate() != null && jDataPesFinal.getDate() != null) {
            if (tipoServidor == null || tipoServidor.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário definir o parâmtero para o sistema operacional utilizado no servidor, (UBUNTU-LINUX ou WINDOWS SERVER).");
            } else if (tipoServidor.equals("Servidor Linux (Ubuntu)/MS-SQL Server")) {
                SimpleDateFormat formatoAmerica = new SimpleDateFormat("yyyy/MM/dd");
                dataInicial = formatoAmerica.format(jDataPesqInicial.getDate().getTime());
                dataFinal = formatoAmerica.format(jDataPesFinal.getDate().getTime());
                preencherTabelaRegistrosMontagemKits2("SELECT "
                        + "DISTINCT COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp, "
                        + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp, "
                        + "KITS_HIGIENE_INTERNO.IdKit, "
                        + "KITS_HIGIENE_INTERNO.KitInicial, "
                        + "KITS_HIGIENE_INTERNO.KitDecendial, "
                        + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                        + "KITS_HIGIENE_INTERNO.KitMensal, "
                        + "KITS_HIGIENE_INTERNO.KitSemestral, "
                        + "KITS_HIGIENE_INTERNO.KitAnual, "
                        + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc, "
                        + "COLABORADOR.NomeFunc, "
                        + "INTERNOS_PAVILHAO_KIT_LOTE.IdPav, "
                        + "PAVILHAO.DescricaoPav "
                        + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                        + "INNER JOIN COLABORADOR "
                        + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                        + "INNER JOIN DEPARTAMENTOS "
                        + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                        + "INNER JOIN KITS_HIGIENE_INTERNO "
                        + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                        + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                        + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdItem=PRODUTOS_KITS_HIGIENE_INTERNO.IdItem "
                        + "INNER JOIN PRODUTOS_AC "
                        + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                        + "INNER JOIN INTERNOS_PAVILHAO_KIT_LOTE "
                        + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp=INTERNOS_PAVILHAO_KIT_LOTE.IdRegistroComp "
                        + "INNER JOIN PAVILHAO "
                        + "ON INTERNOS_PAVILHAO_KIT_LOTE.IdPav=PAVILHAO.IdPav "
                        + "WHERE DataComp BETWEEN'" + dataInicial + "' "
                        + "AND'" + dataFinal + "' "
                        + "AND KITS_HIGIENE_INTERNO.KitMensal=1 "
                        + "ORDER BY DataComp");
            } else if (tipoServidor.equals("Servidor Windows/MS-SQL Server")) {
                SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
                dataInicial = formatoAmerica.format(jDataPesqInicial.getDate().getTime());
                dataFinal = formatoAmerica.format(jDataPesFinal.getDate().getTime());
                preencherTabelaRegistrosMontagemKits2("SELECT "
                        + "DISTINCT COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp, "
                        + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp, "
                        + "KITS_HIGIENE_INTERNO.IdKit, "
                        + "KITS_HIGIENE_INTERNO.KitInicial, "
                        + "KITS_HIGIENE_INTERNO.KitDecendial, "
                        + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                        + "KITS_HIGIENE_INTERNO.KitMensal, "
                        + "KITS_HIGIENE_INTERNO.KitSemestral, "
                        + "KITS_HIGIENE_INTERNO.KitAnual, "
                        + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc, "
                        + "COLABORADOR.NomeFunc, "
                        + "INTERNOS_PAVILHAO_KIT_LOTE.IdPav, "
                        + "PAVILHAO.DescricaoPav "
                        + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                        + "INNER JOIN COLABORADOR "
                        + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                        + "INNER JOIN DEPARTAMENTOS "
                        + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                        + "INNER JOIN KITS_HIGIENE_INTERNO "
                        + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                        + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                        + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdItem=PRODUTOS_KITS_HIGIENE_INTERNO.IdItem "
                        + "INNER JOIN PRODUTOS_AC "
                        + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                        + "INNER JOIN INTERNOS_PAVILHAO_KIT_LOTE "
                        + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp=INTERNOS_PAVILHAO_KIT_LOTE.IdRegistroComp "
                        + "INNER JOIN PAVILHAO "
                        + "ON INTERNOS_PAVILHAO_KIT_LOTE.IdPav=PAVILHAO.IdPav "
                        + "WHERE DataComp BETWEEN'" + dataInicial + "' "
                        + "AND'" + dataFinal + "' "
                        + "AND KITS_HIGIENE_INTERNO.KitMensal=1 "
                        + "ORDER BY DataComp");
            }
        } else if (jComboBoxSelecionarKit.getSelectedItem().equals("Kit Semestral") && jDataPesqInicial.getDate() == null || jComboBoxSelecionarKit.getSelectedItem().equals("Kit Semestral") && jDataPesFinal.getDate() == null) {
            preencherTabelaRegistrosMontagemKits2("SELECT "
                    + "DISTINCT COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp, "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp, "
                    + "KITS_HIGIENE_INTERNO.IdKit, "
                    + "KITS_HIGIENE_INTERNO.KitInicial, "
                    + "KITS_HIGIENE_INTERNO.KitDecendial, "
                    + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                    + "KITS_HIGIENE_INTERNO.KitMensal, "
                    + "KITS_HIGIENE_INTERNO.KitSemestral, "
                    + "KITS_HIGIENE_INTERNO.KitAnual, "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc, "
                    + "COLABORADOR.NomeFunc, "
                    + "INTERNOS_PAVILHAO_KIT_LOTE.IdPav, "
                    + "PAVILHAO.DescricaoPav "
                    + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                    + "INNER JOIN COLABORADOR "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                    + "INNER JOIN DEPARTAMENTOS "
                    + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                    + "INNER JOIN KITS_HIGIENE_INTERNO "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                    + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdItem=PRODUTOS_KITS_HIGIENE_INTERNO.IdItem "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                    + "INNER JOIN INTERNOS_PAVILHAO_KIT_LOTE "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp=INTERNOS_PAVILHAO_KIT_LOTE.IdRegistroComp "
                    + "INNER JOIN PAVILHAO "
                    + "ON INTERNOS_PAVILHAO_KIT_LOTE.IdPav=PAVILHAO.IdPav "
                    + "WHERE KITS_HIGIENE_INTERNO.KitSemestral=1 "
                    + "ORDER BY DataComp");
        } else if (jComboBoxSelecionarKit.getSelectedItem().equals("Kit Semestral") && jDataPesqInicial.getDate() != null && jDataPesFinal.getDate() != null) {
            if (tipoServidor == null || tipoServidor.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário definir o parâmtero para o sistema operacional utilizado no servidor, (UBUNTU-LINUX ou WINDOWS SERVER).");
            } else if (tipoServidor.equals("Servidor Linux (Ubuntu)/MS-SQL Server")) {
                SimpleDateFormat formatoAmerica = new SimpleDateFormat("yyyy/MM/dd");
                dataInicial = formatoAmerica.format(jDataPesqInicial.getDate().getTime());
                dataFinal = formatoAmerica.format(jDataPesFinal.getDate().getTime());
                preencherTabelaRegistrosMontagemKits2("SELECT "
                        + "DISTINCT COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp, "
                        + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp, "
                        + "KITS_HIGIENE_INTERNO.IdKit, "
                        + "KITS_HIGIENE_INTERNO.KitInicial, "
                        + "KITS_HIGIENE_INTERNO.KitDecendial, "
                        + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                        + "KITS_HIGIENE_INTERNO.KitMensal, "
                        + "KITS_HIGIENE_INTERNO.KitSemestral, "
                        + "KITS_HIGIENE_INTERNO.KitAnual, "
                        + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc, "
                        + "COLABORADOR.NomeFunc, "
                        + "INTERNOS_PAVILHAO_KIT_LOTE.IdPav, "
                        + "PAVILHAO.DescricaoPav "
                        + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                        + "INNER JOIN COLABORADOR "
                        + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                        + "INNER JOIN DEPARTAMENTOS "
                        + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                        + "INNER JOIN KITS_HIGIENE_INTERNO "
                        + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                        + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                        + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdItem=PRODUTOS_KITS_HIGIENE_INTERNO.IdItem "
                        + "INNER JOIN PRODUTOS_AC "
                        + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                        + "INNER JOIN INTERNOS_PAVILHAO_KIT_LOTE "
                        + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp=INTERNOS_PAVILHAO_KIT_LOTE.IdRegistroComp "
                        + "INNER JOIN PAVILHAO "
                        + "ON INTERNOS_PAVILHAO_KIT_LOTE.IdPav=PAVILHAO.IdPav "
                        + "WHERE DataComp BETWEEN'" + dataInicial + "' "
                        + "AND'" + dataFinal + "' "
                        + "AND KITS_HIGIENE_INTERNO.KitSemestral=1 "
                        + "ORDER BY DataComp");
            } else if (tipoServidor.equals("Servidor Windows/MS-SQL Server")) {
                SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
                dataInicial = formatoAmerica.format(jDataPesqInicial.getDate().getTime());
                dataFinal = formatoAmerica.format(jDataPesFinal.getDate().getTime());
                preencherTabelaRegistrosMontagemKits2("SELECT "
                        + "DISTINCT COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp, "
                        + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp, "
                        + "KITS_HIGIENE_INTERNO.IdKit, "
                        + "KITS_HIGIENE_INTERNO.KitInicial, "
                        + "KITS_HIGIENE_INTERNO.KitDecendial, "
                        + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                        + "KITS_HIGIENE_INTERNO.KitMensal, "
                        + "KITS_HIGIENE_INTERNO.KitSemestral, "
                        + "KITS_HIGIENE_INTERNO.KitAnual, "
                        + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc, "
                        + "COLABORADOR.NomeFunc, "
                        + "INTERNOS_PAVILHAO_KIT_LOTE.IdPav, "
                        + "PAVILHAO.DescricaoPav "
                        + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                        + "INNER JOIN COLABORADOR "
                        + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                        + "INNER JOIN DEPARTAMENTOS "
                        + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                        + "INNER JOIN KITS_HIGIENE_INTERNO "
                        + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                        + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                        + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdItem=PRODUTOS_KITS_HIGIENE_INTERNO.IdItem "
                        + "INNER JOIN PRODUTOS_AC "
                        + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                        + "INNER JOIN INTERNOS_PAVILHAO_KIT_LOTE "
                        + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp=INTERNOS_PAVILHAO_KIT_LOTE.IdRegistroComp "
                        + "INNER JOIN PAVILHAO "
                        + "ON INTERNOS_PAVILHAO_KIT_LOTE.IdPav=PAVILHAO.IdPav "
                        + "WHERE DataComp BETWEEN'" + dataInicial + "' "
                        + "AND'" + dataFinal + "' "
                        + "AND KITS_HIGIENE_INTERNO.KitSemestral=1 "
                        + "ORDER BY DataComp");
            }
        } else if (jComboBoxSelecionarKit.getSelectedItem().equals("Kit Anual") && jDataPesqInicial.getDate() == null || jComboBoxSelecionarKit.getSelectedItem().equals("Kit Anual") && jDataPesFinal.getDate() == null) {
            preencherTabelaRegistrosMontagemKits2("SELECT "
                    + "DISTINCT COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp, "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp, "
                    + "KITS_HIGIENE_INTERNO.IdKit, "
                    + "KITS_HIGIENE_INTERNO.KitInicial, "
                    + "KITS_HIGIENE_INTERNO.KitDecendial, "
                    + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                    + "KITS_HIGIENE_INTERNO.KitMensal, "
                    + "KITS_HIGIENE_INTERNO.KitSemestral, "
                    + "KITS_HIGIENE_INTERNO.KitAnual, "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc, "
                    + "COLABORADOR.NomeFunc, "
                    + "INTERNOS_PAVILHAO_KIT_LOTE.IdPav, "
                    + "PAVILHAO.DescricaoPav "
                    + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                    + "INNER JOIN COLABORADOR "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                    + "INNER JOIN DEPARTAMENTOS "
                    + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                    + "INNER JOIN KITS_HIGIENE_INTERNO "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                    + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdItem=PRODUTOS_KITS_HIGIENE_INTERNO.IdItem "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                    + "INNER JOIN INTERNOS_PAVILHAO_KIT_LOTE "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp=INTERNOS_PAVILHAO_KIT_LOTE.IdRegistroComp "
                    + "INNER JOIN PAVILHAO "
                    + "ON INTERNOS_PAVILHAO_KIT_LOTE.IdPav=PAVILHAO.IdPav "
                    + "WHERE KITS_HIGIENE_INTERNO.KitAnual=1 "
                    + "ORDER BY DataComp");
        } else if (jComboBoxSelecionarKit.getSelectedItem().equals("Kit Anual") && jDataPesqInicial.getDate() != null && jDataPesFinal.getDate() != null) {
            if (tipoServidor == null || tipoServidor.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário definir o parâmtero para o sistema operacional utilizado no servidor, (UBUNTU-LINUX ou WINDOWS SERVER).");
            } else if (tipoServidor.equals("Servidor Linux (Ubuntu)/MS-SQL Server")) {
                SimpleDateFormat formatoAmerica = new SimpleDateFormat("yyyy/MM/dd");
                dataInicial = formatoAmerica.format(jDataPesqInicial.getDate().getTime());
                dataFinal = formatoAmerica.format(jDataPesFinal.getDate().getTime());
                preencherTabelaRegistrosMontagemKits2("SELECT "
                        + "DISTINCT COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp, "
                        + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp, "
                        + "KITS_HIGIENE_INTERNO.IdKit, "
                        + "KITS_HIGIENE_INTERNO.KitInicial, "
                        + "KITS_HIGIENE_INTERNO.KitDecendial, "
                        + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                        + "KITS_HIGIENE_INTERNO.KitMensal, "
                        + "KITS_HIGIENE_INTERNO.KitSemestral, "
                        + "KITS_HIGIENE_INTERNO.KitAnual, "
                        + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc, "
                        + "COLABORADOR.NomeFunc, "
                        + "INTERNOS_PAVILHAO_KIT_LOTE.IdPav, "
                        + "PAVILHAO.DescricaoPav "
                        + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                        + "INNER JOIN COLABORADOR "
                        + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                        + "INNER JOIN DEPARTAMENTOS "
                        + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                        + "INNER JOIN KITS_HIGIENE_INTERNO "
                        + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                        + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                        + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdItem=PRODUTOS_KITS_HIGIENE_INTERNO.IdItem "
                        + "INNER JOIN PRODUTOS_AC "
                        + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                        + "INNER JOIN INTERNOS_PAVILHAO_KIT_LOTE "
                        + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp=INTERNOS_PAVILHAO_KIT_LOTE.IdRegistroComp "
                        + "INNER JOIN PAVILHAO "
                        + "ON INTERNOS_PAVILHAO_KIT_LOTE.IdPav=PAVILHAO.IdPav "
                        + "WHERE DataComp BETWEEN'" + dataInicial + "' "
                        + "AND'" + dataFinal + "' "
                        + "AND KITS_HIGIENE_INTERNO.KitAnual=1 "
                        + "ORDER BY DataComp");
            } else if (tipoServidor.equals("Servidor Windows/MS-SQL Server")) {
                SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
                dataInicial = formatoAmerica.format(jDataPesqInicial.getDate().getTime());
                dataFinal = formatoAmerica.format(jDataPesFinal.getDate().getTime());
                preencherTabelaRegistrosMontagemKits2("SELECT "
                        + "DISTINCT COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp, "
                        + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp, "
                        + "KITS_HIGIENE_INTERNO.IdKit, "
                        + "KITS_HIGIENE_INTERNO.KitInicial, "
                        + "KITS_HIGIENE_INTERNO.KitDecendial, "
                        + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                        + "KITS_HIGIENE_INTERNO.KitMensal, "
                        + "KITS_HIGIENE_INTERNO.KitSemestral, "
                        + "KITS_HIGIENE_INTERNO.KitAnual, "
                        + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc, "
                        + "COLABORADOR.NomeFunc, "
                        + "INTERNOS_PAVILHAO_KIT_LOTE.IdPav, "
                        + "PAVILHAO.DescricaoPav "
                        + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                        + "INNER JOIN COLABORADOR "
                        + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                        + "INNER JOIN DEPARTAMENTOS "
                        + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                        + "INNER JOIN KITS_HIGIENE_INTERNO "
                        + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                        + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                        + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdItem=PRODUTOS_KITS_HIGIENE_INTERNO.IdItem "
                        + "INNER JOIN PRODUTOS_AC "
                        + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                        + "INNER JOIN INTERNOS_PAVILHAO_KIT_LOTE "
                        + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp=INTERNOS_PAVILHAO_KIT_LOTE.IdRegistroComp "
                        + "INNER JOIN PAVILHAO "
                        + "ON INTERNOS_PAVILHAO_KIT_LOTE.IdPav=PAVILHAO.IdPav "
                        + "WHERE DataComp BETWEEN'" + dataInicial + "' "
                        + "AND'" + dataFinal + "' "
                        + "AND KITS_HIGIENE_INTERNO.KitAnual=1 "
                        + "ORDER BY DataComp");
            }
        } else if (!jComboBoxSelecionarKit.getSelectedItem().equals("Selecione...") && jDataPesqInicial.getDate().after(jDataPesFinal.getDate())) {
            JOptionPane.showMessageDialog(rootPane, "Data Inicial não pode ser maior que data final");
        }
    }//GEN-LAST:event_jBtPesquisaTipoKitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisaMontagemKitHigiene.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisaMontagemKitHigiene.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisaMontagemKitHigiene.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisaMontagemKitHigiene.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaPesquisaMontagemKitHigiene dialog = new TelaPesquisaMontagemKitHigiene(motaPagtoKit, true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelaRegistrosMontagemKits;
    private javax.swing.ButtonGroup grupoBotoes;
    private javax.swing.JButton jBtConfirmar;
    private javax.swing.JButton jBtPesquisaCodigo;
    private javax.swing.JButton jBtPesquisaData;
    private javax.swing.JButton jBtPesquisaTipoKit;
    private javax.swing.JButton jBtSair;
    private javax.swing.JCheckBox jCheckBoxTodos;
    public static javax.swing.JTextField jCodigoRegistroPesquisa;
    private javax.swing.JComboBox<String> jComboBoxSelecionarKit;
    private com.toedter.calendar.JDateChooser jDataPesFinal;
    private com.toedter.calendar.JDateChooser jDataPesqInicial;
    private javax.swing.JTextField jDescricaoPavilhao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    public static javax.swing.JRadioButton jRBtKitAnualPesquisa;
    public static javax.swing.JRadioButton jRBtKitDecendialPesquisa;
    public static javax.swing.JRadioButton jRBtKitInicialPesquisa;
    public static javax.swing.JRadioButton jRBtKitMensalPesquisa;
    public static javax.swing.JRadioButton jRBtKitQuinzenalPesquisa;
    public static javax.swing.JRadioButton jRBtKitSemestraPesquisa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public static javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void corCampo() {
        jDescricaoPavilhao.setBackground(Color.white);
    }

    public void preencherTabelaRegistrosMontagemKits(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Registro", "Data Registro", "ID Kit", "Tipo Kit", "Código", "Colaborador"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            count = 0;
            do {
                count = count + 1;
                dataEmissao = conecta.rs.getString("DataComp");
                String dia = dataEmissao.substring(8, 10);
                String mes = dataEmissao.substring(5, 7);
                String ano = dataEmissao.substring(0, 4);
                dataEmissao = dia + "/" + mes + "/" + ano;
                //
                kitInicial = conecta.rs.getInt("KitInicial");
                kitDecendial = conecta.rs.getInt("KitDecendial");
                kitQuinzenal = conecta.rs.getInt("KitQuinzenal");
                kitMensal = conecta.rs.getInt("KitMensal");
                kitSemestral = conecta.rs.getInt("KitSemestral");
                kitAnual = conecta.rs.getInt("KitAnual");
                if (kitInicial == 1) {
                    nomeKit = "Kit Inicial";
                } else if (kitAnual == 1) {
                    nomeKit = "Kit Anual";
                } else if (kitDecendial == 1) {
                    nomeKit = "Kit Decendial";
                } else if (kitQuinzenal == 1) {
                    nomeKit = "Kit Quinzenal";
                } else if (kitMensal == 1) {
                    nomeKit = "Kit Mensal";
                } else if (kitSemestral == 1) {
                    nomeKit = "Kit Semestral";
                }
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela 
                dados.add(new Object[]{conecta.rs.getInt("IdRegistroComp"), dataEmissao, conecta.rs.getInt("IdKit"), nomeKit, conecta.rs.getString("IdFunc"), conecta.rs.getString("NomeFunc")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Dados não encontrado, use o botão TODOS \nPara pesquisar TODOS OS REGISTROS");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        TabelaRegistrosMontagemKits.setModel(modelo);
        TabelaRegistrosMontagemKits.getColumnModel().getColumn(0).setPreferredWidth(70);
        TabelaRegistrosMontagemKits.getColumnModel().getColumn(0).setResizable(false);
        TabelaRegistrosMontagemKits.getColumnModel().getColumn(1).setPreferredWidth(80);
        TabelaRegistrosMontagemKits.getColumnModel().getColumn(1).setResizable(false);
        TabelaRegistrosMontagemKits.getColumnModel().getColumn(2).setPreferredWidth(60);
        TabelaRegistrosMontagemKits.getColumnModel().getColumn(2).setResizable(false);
        TabelaRegistrosMontagemKits.getColumnModel().getColumn(3).setPreferredWidth(70);
        TabelaRegistrosMontagemKits.getColumnModel().getColumn(3).setResizable(false);
        TabelaRegistrosMontagemKits.getColumnModel().getColumn(4).setPreferredWidth(60);
        TabelaRegistrosMontagemKits.getColumnModel().getColumn(4).setResizable(false);
        TabelaRegistrosMontagemKits.getColumnModel().getColumn(5).setPreferredWidth(350);
        TabelaRegistrosMontagemKits.getColumnModel().getColumn(5).setResizable(false);
        TabelaRegistrosMontagemKits.getTableHeader().setReorderingAllowed(false);
        TabelaRegistrosMontagemKits.setAutoResizeMode(TabelaRegistrosMontagemKits.AUTO_RESIZE_OFF);
        TabelaRegistrosMontagemKits.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaRegistrosMontagemKits();
        conecta.desconecta();
    }

    public void preencherTabelaRegistrosMontagemKits2(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Registro", "Data Registro", "ID Kit", "Tipo Kit", "Código", "Colaborador", "Pavilhão/Galeria"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            count = 0;
            do {
                count = count + 1;
                dataEmissao = conecta.rs.getString("DataComp");
                String dia = dataEmissao.substring(8, 10);
                String mes = dataEmissao.substring(5, 7);
                String ano = dataEmissao.substring(0, 4);
                dataEmissao = dia + "/" + mes + "/" + ano;
                //
                kitInicial = conecta.rs.getInt("KitInicial");
                kitDecendial = conecta.rs.getInt("KitDecendial");
                kitQuinzenal = conecta.rs.getInt("KitQuinzenal");
                kitMensal = conecta.rs.getInt("KitMensal");
                kitSemestral = conecta.rs.getInt("KitSemestral");
                kitAnual = conecta.rs.getInt("KitAnual");
                if (kitInicial == 1) {
                    nomeKit = "Kit Inicial";
                } else if (kitAnual == 1) {
                    nomeKit = "Kit Anual";
                } else if (kitDecendial == 1) {
                    nomeKit = "Kit Decendial";
                } else if (kitQuinzenal == 1) {
                    nomeKit = "Kit Quinzenal";
                } else if (kitMensal == 1) {
                    nomeKit = "Kit Mensal";
                } else if (kitSemestral == 1) {
                    nomeKit = "Kit Semestral";
                }
                jDescricaoPavilhao.setText(conecta.rs.getString("DescricaoPav"));
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela 
                dados.add(new Object[]{conecta.rs.getInt("IdRegistroComp"), dataEmissao, conecta.rs.getInt("IdKit"), nomeKit, conecta.rs.getString("IdFunc"), conecta.rs.getString("NomeFunc"), conecta.rs.getString("DescricaoPav")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Dados não encontrado, use o botão TODOS \nPara pesquisar TODOS OS REGISTROS");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        TabelaRegistrosMontagemKits.setModel(modelo);
        TabelaRegistrosMontagemKits.getColumnModel().getColumn(0).setPreferredWidth(70);
        TabelaRegistrosMontagemKits.getColumnModel().getColumn(0).setResizable(false);
        TabelaRegistrosMontagemKits.getColumnModel().getColumn(1).setPreferredWidth(80);
        TabelaRegistrosMontagemKits.getColumnModel().getColumn(1).setResizable(false);
        TabelaRegistrosMontagemKits.getColumnModel().getColumn(2).setPreferredWidth(60);
        TabelaRegistrosMontagemKits.getColumnModel().getColumn(2).setResizable(false);
        TabelaRegistrosMontagemKits.getColumnModel().getColumn(3).setPreferredWidth(70);
        TabelaRegistrosMontagemKits.getColumnModel().getColumn(3).setResizable(false);
        TabelaRegistrosMontagemKits.getColumnModel().getColumn(4).setPreferredWidth(60);
        TabelaRegistrosMontagemKits.getColumnModel().getColumn(4).setResizable(false);
        TabelaRegistrosMontagemKits.getColumnModel().getColumn(5).setPreferredWidth(350);
        TabelaRegistrosMontagemKits.getColumnModel().getColumn(5).setResizable(false);
        TabelaRegistrosMontagemKits.getColumnModel().getColumn(6).setPreferredWidth(350);
        TabelaRegistrosMontagemKits.getColumnModel().getColumn(6).setResizable(false);
        TabelaRegistrosMontagemKits.getTableHeader().setReorderingAllowed(false);
        TabelaRegistrosMontagemKits.setAutoResizeMode(TabelaRegistrosMontagemKits.AUTO_RESIZE_OFF);
        TabelaRegistrosMontagemKits.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaRegistrosMontagemKits();
        conecta.desconecta();
    }

    public void limparTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Registro", "Data Registro", "ID Kit", "Tipo Kit", "Código", "Colaborador", "Observação"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        TabelaRegistrosMontagemKits.setModel(modelo);
        TabelaRegistrosMontagemKits.getColumnModel().getColumn(0).setPreferredWidth(70);
        TabelaRegistrosMontagemKits.getColumnModel().getColumn(0).setResizable(false);
        TabelaRegistrosMontagemKits.getColumnModel().getColumn(1).setPreferredWidth(80);
        TabelaRegistrosMontagemKits.getColumnModel().getColumn(1).setResizable(false);
        TabelaRegistrosMontagemKits.getColumnModel().getColumn(2).setPreferredWidth(60);
        TabelaRegistrosMontagemKits.getColumnModel().getColumn(2).setResizable(false);
        TabelaRegistrosMontagemKits.getColumnModel().getColumn(3).setPreferredWidth(70);
        TabelaRegistrosMontagemKits.getColumnModel().getColumn(3).setResizable(false);
        TabelaRegistrosMontagemKits.getColumnModel().getColumn(4).setPreferredWidth(60);
        TabelaRegistrosMontagemKits.getColumnModel().getColumn(4).setResizable(false);
        TabelaRegistrosMontagemKits.getColumnModel().getColumn(5).setPreferredWidth(350);
        TabelaRegistrosMontagemKits.getColumnModel().getColumn(5).setResizable(false);
        TabelaRegistrosMontagemKits.getColumnModel().getColumn(6).setPreferredWidth(350);
        TabelaRegistrosMontagemKits.getColumnModel().getColumn(6).setResizable(false);
        TabelaRegistrosMontagemKits.getTableHeader().setReorderingAllowed(false);
        TabelaRegistrosMontagemKits.setAutoResizeMode(TabelaRegistrosMontagemKits.AUTO_RESIZE_OFF);
        TabelaRegistrosMontagemKits.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabelaRegistrosMontagemKits() {
        //
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        TabelaRegistrosMontagemKits.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        TabelaRegistrosMontagemKits.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        TabelaRegistrosMontagemKits.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        TabelaRegistrosMontagemKits.getColumnModel().getColumn(4).setCellRenderer(centralizado);
    }

    public void mostrarInternosSelecionados() {
        qtdInternosSelec = 0;
        DefaultTableModel dadosDestino = (DefaultTableModel) jTabelaInternosSelecionados.getModel();
        PavilhaoInternosSelecionados d = new PavilhaoInternosSelecionados();
        try {
            for (PavilhaoInternosSelecionados dd : controle.read()) {
                pCODIGO_pavilhao = dd.getIdPav();
                jtotalInternosSelecionados.setText(Integer.toString(qtdInternosSelec)); // Converter inteiro em string para exibir na tela 
                dadosDestino.addRow(new Object[]{dd.getIdInternoCrc(), dd.getCncInternoCrc(), dd.getNomeInternoCrc()});
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaInternosSelecionados.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaInternosSelecionados.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                jTabelaInternosSelecionados.getColumnModel().getColumn(1).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaMontagemPagamentoKitInterno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void pMOSTRAR_KIT_codigo() {
        count = 0;
        pDESCRICAO_pavilhao = "";
        DefaultTableModel dadosProduto = (DefaultTableModel) TabelaRegistrosMontagemKits.getModel();
        ComposicaoKit p = new ComposicaoKit();
        try {
            for (ComposicaoKit i : controle.pCODIGO_read()) {
                count = count + 1;
                dataEmissao = i.getDataComp().toString();
                String dia = dataEmissao.substring(8, 10);
                String mes = dataEmissao.substring(5, 7);
                String ano = dataEmissao.substring(0, 4);
                dataEmissao = dia + "/" + mes + "/" + ano;
                //
                kitInicial = i.getKitInicial();
                kitDecendial = i.getKitDecendial();
                kitQuinzenal = i.getKitQuinzenal();
                kitMensal = i.getKitMensal();
                kitSemestral = i.getKitSemestral();
                kitAnual = i.getKitAnual();
                if (kitInicial == 1) {
                    nomeKit = "Kit Inicial";
                } else if (kitAnual == 1) {
                    nomeKit = "Kit Anual";
                } else if (kitDecendial == 1) {
                    nomeKit = "Kit Decendial";
                } else if (kitQuinzenal == 1) {
                    nomeKit = "Kit Quinzenal";
                } else if (kitMensal == 1) {
                    nomeKit = "Kit Mensal";
                } else if (kitSemestral == 1) {
                    nomeKit = "Kit Semestral";
                }
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela 
                dadosProduto.addRow(new Object[]{i.getIdRegistroComp(), dataEmissao, i.getIdKit(), nomeKit, i.getIdFunc(), i.getNomeColaborador(), pDESCRICAO_pavilhao});
                // BARRA DE ROLAGEM HORIZONTAL
                TabelaRegistrosMontagemKits.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                TabelaRegistrosMontagemKits.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                TabelaRegistrosMontagemKits.getColumnModel().getColumn(1).setCellRenderer(centralizado);
                TabelaRegistrosMontagemKits.getColumnModel().getColumn(2).setCellRenderer(centralizado);
                TabelaRegistrosMontagemKits.getColumnModel().getColumn(4).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaPesquisaMontagemKitHigiene.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mostrarProdutosSelecionados() {
        qtdProd = 0;
        DefaultTableModel dadosProduto = (DefaultTableModel) jTabelaProdutos.getModel();
        ProdutoInternosKitLote p = new ProdutoInternosKitLote();
        try {
            for (ProdutoInternosKitLote pp : control.read()) {
                jtotalProdutosKitInternos.setText(Integer.toString(qtdProd)); // Converter inteiro em string para exibir na tela 
                dadosProduto.addRow(new Object[]{pp.getIdRegProdKit(), pp.getIdProd(), pp.getDescricaoProduto(), pp.getUnidadeProd(), pp.getQuantidadeProd()});
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaProdutos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaProdutos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                jTabelaProdutos.getColumnModel().getColumn(1).setCellRenderer(centralizado);
                jTabelaProdutos.getColumnModel().getColumn(3).setCellRenderer(centralizado);
                jTabelaProdutos.getColumnModel().getColumn(4).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaPesquisaMontagemKitHigiene.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mostrarInternosKitCompleto() {
        qtdInternosKitComp = 0;
        DefaultTableModel dadosProduto = (DefaultTableModel) jTabelaInternosKitCompleto.getModel();
        GravarInternosKitCompleto b = new GravarInternosKitCompleto();
        try {
            for (GravarInternosKitCompleto bb : controleIC.read()) {
                jtotalInternosKitCompleto.setText(Integer.toString(qtdInternosKitComp)); // Converter inteiro em string para exibir na tela 
                dadosProduto.addRow(new Object[]{bb.getIdInternoCrc(), bb.getNomeInternoCrc()});
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaInternosKitCompleto.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaInternosKitCompleto.getColumnModel().getColumn(0).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaPesquisaMontagemKitHigiene.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mostrarProdutosKitCompleto() {
        qtdProdutosKitComo = 0;
        DefaultTableModel dadosProduto = (DefaultTableModel) jTabelaProdutosKitCompleto.getModel();
        ProdutoInternosKitLote p = new ProdutoInternosKitLote();
        try {
            for (ProdutoInternosKitLote pp : controleKitComp.read()) {
                jtotalProdutosKitCompleto.setText(Integer.toString(qtdProdutosKitComo)); // Converter inteiro em string para exibir na tela 
                dadosProduto.addRow(new Object[]{pp.getIdProd(), pp.getDescricaoProduto(), pp.getUnidadeProd(), pp.getQuantidadeProd()});
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaProdutosKitCompleto.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaProdutosKitCompleto.getColumnModel().getColumn(0).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaPesquisaMontagemKitHigiene.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void limparTabelaItensKit() {
        count = 0;
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Descrição Produto", "Un.", "Qtd."};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaGeralProdutosKit.setModel(modelo);
        jTabelaGeralProdutosKit.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaGeralProdutosKit.getColumnModel().getColumn(0).setResizable(false);
        jTabelaGeralProdutosKit.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTabelaGeralProdutosKit.getColumnModel().getColumn(1).setResizable(false);
        jTabelaGeralProdutosKit.getColumnModel().getColumn(2).setPreferredWidth(50);
        jTabelaGeralProdutosKit.getColumnModel().getColumn(2).setResizable(false);
        jTabelaGeralProdutosKit.getColumnModel().getColumn(3).setPreferredWidth(50);
        jTabelaGeralProdutosKit.getColumnModel().getColumn(3).setResizable(false);
        jTabelaGeralProdutosKit.getTableHeader().setReorderingAllowed(false);
        jTabelaGeralProdutosKit.setAutoResizeMode(jTabelaGeralProdutosKit.AUTO_RESIZE_OFF);
        jTabelaGeralProdutosKit.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jtotalProdutosKit.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela 
        jtotalProdutosKit.setText("");
        modelo.getLinhas().clear();
    }

    public void limparTabelasAbaPavIntComp() {
        // APAGAR DADOS DA TABELA PAVILHÃO/INTERNOS
        while (jTabelaInternos.getModel().getRowCount() > 0) {
            ((DefaultTableModel) jTabelaInternos.getModel()).removeRow(0);
        }
        // LIMPAR O TOTALIZADOR DA TABELA PAVILHÃO/INTERNOS
        jtotalInternosPavilhao.setText("");
        // APAGAR DADOS DA TABELA INTERNOS SELECIONADOS
        while (jTabelaInternosSelecionados.getModel().getRowCount() > 0) {
            ((DefaultTableModel) jTabelaInternosSelecionados.getModel()).removeRow(0);
        }
        // LIMPAR O TOTALIZADOR DA TABELA INTERNOS SELECIONADOS
        jtotalInternosSelecionados.setText("");
    }

    public void limparTabelaProdutosInternos() {
        // APAGAR DADOS DA TABELA PRODUTOS
        while (jTabelaProdutos.getModel().getRowCount() > 0) {
            ((DefaultTableModel) jTabelaProdutos.getModel()).removeRow(0);
        }
        // LIMPAR O TOTALIZADOR DA TABELA PRODUTOS
        jtotalProdutosKitInternos.setText("");
        // APAGAR DADOS DA TABELA INTERNOS SELECIONADOS
        while (jTabelaInternosKitCompleto.getModel().getRowCount() > 0) {
            ((DefaultTableModel) jTabelaInternosKitCompleto.getModel()).removeRow(0);
        }
        // LIMPAR O TOTALIZADOR DA TABELA INTERNOS SELECIONADOS
        jtotalInternosKitCompleto.setText("");
        // LIMPAR TABELA DE PRODUTOS SELECIONADOS PARA BAIXA
        while (jTabelaProdutosKitCompleto.getModel().getRowCount() > 0) {
            ((DefaultTableModel) jTabelaProdutosKitCompleto.getModel()).removeRow(0);
        }
        // LIMPAR O TOTALIZADOR DA TABELA PRODUTOS SELECIONADOS PARA BAIXA
        jtotalProdutosKitCompleto.setText("");
    }
}
