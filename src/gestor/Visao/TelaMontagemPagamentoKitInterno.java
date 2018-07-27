/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleComposicaoKit;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControlePavilhaoInternosMontaKit;
import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.ModeloTabela;
import gestor.Modelo.ComposicaoKit;
import gestor.Modelo.LogSistema;
import gestor.Modelo.PavilhaoInternoMontaKit;
import gestor.Modelo.PavilhaoInternosMontagemKit;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloAlmoxarifado.codAlterarAL;
import static gestor.Visao.TelaModuloAlmoxarifado.codExcluirAL;
import static gestor.Visao.TelaModuloAlmoxarifado.codGravarAL;
import static gestor.Visao.TelaModuloAlmoxarifado.codIncluirAL;
import static gestor.Visao.TelaModuloAlmoxarifado.codUserAcessoAL;
import static gestor.Visao.TelaModuloAlmoxarifado.codigoUserAL;
import static gestor.Visao.TelaModuloAlmoxarifado.nomeGrupoAL;
import static gestor.Visao.TelaModuloAlmoxarifado.nomeTelaAL;
import static gestor.Visao.TelaModuloAlmoxarifado.telaMontagemPagamentoKitAL;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import java.awt.Color;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ronaldo - INICIO DO DESENVOLVIMENTO DO KIT 22/07/2018 AS 09:57:12HS -
 * LOCAL (ITABUNA)
 */
public class TelaMontagemPagamentoKitInterno extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ComposicaoKit objComp = new ComposicaoKit();
    ControleComposicaoKit control = new ControleComposicaoKit();
    //
    PavilhaoInternosMontagemKit objPavInt = new PavilhaoInternosMontagemKit();
    ControlePavilhaoInternosMontaKit controle = new ControlePavilhaoInternosMontaKit();
    //   
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela = "Almoxarifado:Montagem de Pagamento do Kit de Interno:Dados Iniciais/Geral";
    String nomeModuloTela2 = "Almoxarifado:Montagem de Pagamento do Kit de Interno:Pavilhão/Internos";
    String nomeModuloTela3 = "Almoxarifado:Montagem de Pagamento do Kit de Interno:Composição Kit";
    //
    int flag = 0;
    int acao = 0;
    String dataEntrada = "";
    String statusMov = "";
    String horaMov = "";
    String dataModFinal = "";
    String statusKit = "Ativo";
    public static int count = 0;
    int count1 = 0; // PARA TABELA DE INTERNOS SELECIONADOS
    int count2 = 0;
    int count3 = 0;
    //
    String caminho;
    int Inicial = 0;
    int kitQuinzenal = 0;
    int kitMensal = 0;
    int kitDecimal = 0;
    int kitAnual = 0;
    int kitSemetral = 0;
    public static double qtdItem = 0;
    public static String qtdItemTab;
    int codigoKit = 0;
    // CÓDIGO DO REGISTRO DE MONTAGEM DO KIT (codigoPesquisaKit) 
    // E DOS PRODUTOS DOS KITS (codigoPesquisaKitItem)
    public static int codigoPesquisaKit = 0;
    public static int codigoPesquisaKitItem = 0;
    // ABA PAVILHÃO/INTERNOS
    public static int codigoPavilhao = 0;
    String situacaoEntrada = "ENTRADA NA UNIDADE";
    String situacaoRetorno = "RETORNO A UNIDADE";
    String idInterno;
    String cncInterno;
    String nomeInterno;
    public static int qtdInternos = 0;
    int idRegPavInt = 0;

    /**
     * Creates new form TelaMontagemPagamentoKitInterno
     */
    public static TelaPesquisaKitComp pesqKit;
    public static TelaPesquisaColaboradorMontagemKitAL pesqCola;
    public static TelaPesquisaMontagemKitHigiene pesqMontaReg;
    public static TelaConsultaEstoqueMontagemKit pesqSaldoEstoque;
    public static TelaThreadInternosSelecionados montaThread;

    public TelaMontagemPagamentoKitInterno() {
        super();
        initComponents();
        setResizable(false);
        formatarCampos();
        corCampos();
    }

    public void mostrarBuscaKit() {
        pesqKit = new TelaPesquisaKitComp(this, true);
        pesqKit.setVisible(true);
    }

    public void mostrarColaborador() {
        pesqCola = new TelaPesquisaColaboradorMontagemKitAL(this, true);
        pesqCola.setVisible(true);
    }

    public void mostrarPesquisas() {
        pesqMontaReg = new TelaPesquisaMontagemKitHigiene(this, true);
        pesqMontaReg.setVisible(true);
    }

    public void mostraEstoque() {
        pesqSaldoEstoque = new TelaConsultaEstoqueMontagemKit(this, true);
        pesqSaldoEstoque.setVisible(true);
    }

    public void mostrarThread() {
        montaThread = new TelaThreadInternosSelecionados(this, true);
        montaThread.setVisible(true);
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jRBtKitInicial = new javax.swing.JRadioButton();
        jRBtKitQuinzenal = new javax.swing.JRadioButton();
        jRBtKitMensal = new javax.swing.JRadioButton();
        jRBtKitDecendial = new javax.swing.JRadioButton();
        jRBtKitSemestral = new javax.swing.JRadioButton();
        jRBtKitAnual = new javax.swing.JRadioButton();
        jBtPesquisarKit = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTabelaGeralProdutosKit = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        jBtAlterar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jBtAuditoria = new javax.swing.JButton();
        jBtNovo = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jIdFunc = new javax.swing.JTextField();
        jNomeColaborador = new javax.swing.JTextField();
        jDepartamentoColaborador = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        jFotoColaborador = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jObservacao = new javax.swing.JTextArea();
        jPanel36 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        jtotalProdutosKit = new javax.swing.JLabel();
        jBtPesquisarColaborador = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jComboBoxPavilhoes = new javax.swing.JComboBox<>();
        jBtPesquisarInternosPavilhao = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaInternos = new javax.swing.JTable();
        jPanel30 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jtotalInternosPavilhao = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jBtNovoPavInternos = new javax.swing.JButton();
        jBtExcluirPavInternos = new javax.swing.JButton();
        jBtSelecionarUmInterno = new javax.swing.JButton();
        jBtSelecionarTodosInternos = new javax.swing.JButton();
        jBtSalvarPavInternos = new javax.swing.JButton();
        jBtAuditoriaPavInternos = new javax.swing.JButton();
        jBtCancelarPavilhaoInterno = new javax.swing.JButton();
        jBtExcluirUmInterno = new javax.swing.JButton();
        jBtExcluirTodosInternos = new javax.swing.JButton();
        jBtSaldoEstoque = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabelaInternosSelecionados = new javax.swing.JTable();
        jPanel33 = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jtotalInternosSelecionados = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTabelaProduto = new javax.swing.JTable();
        jPanel18 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jCodigoProd = new javax.swing.JTextField();
        jUnidadeProd = new javax.swing.JTextField();
        jDescricaoProd = new javax.swing.JTextField();
        jQuantidadeProd = new javax.swing.JFormattedTextField();
        jPanel39 = new javax.swing.JPanel();
        jPanel40 = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        jPanel41 = new javax.swing.JPanel();
        jtotalProdutosKitInternos = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jIdRegistroComp = new javax.swing.JTextField();
        jStatusComp = new javax.swing.JTextField();
        jDataComp = new com.toedter.calendar.JDateChooser();
        jBtPesquisaComp = new javax.swing.JButton();
        jBtFinalizar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Preparção dos Kits de Higiene de Internos - Em Lote :::...");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Full_shopping_cart_Icon_16.png"))); // NOI18N

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Tipos de Kits", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(153, 0, 153))); // NOI18N

        grupoBotoes.add(jRBtKitInicial);
        jRBtKitInicial.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBtKitInicial.setText("Inicial");
        jRBtKitInicial.setEnabled(false);
        jRBtKitInicial.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRBtKitInicialItemStateChanged(evt);
            }
        });

        grupoBotoes.add(jRBtKitQuinzenal);
        jRBtKitQuinzenal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBtKitQuinzenal.setText("Quinzenal");
        jRBtKitQuinzenal.setEnabled(false);
        jRBtKitQuinzenal.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRBtKitQuinzenalItemStateChanged(evt);
            }
        });

        grupoBotoes.add(jRBtKitMensal);
        jRBtKitMensal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBtKitMensal.setText("Mensal");
        jRBtKitMensal.setEnabled(false);
        jRBtKitMensal.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRBtKitMensalItemStateChanged(evt);
            }
        });

        grupoBotoes.add(jRBtKitDecendial);
        jRBtKitDecendial.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBtKitDecendial.setText("Decendial");
        jRBtKitDecendial.setEnabled(false);
        jRBtKitDecendial.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRBtKitDecendialItemStateChanged(evt);
            }
        });

        grupoBotoes.add(jRBtKitSemestral);
        jRBtKitSemestral.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBtKitSemestral.setText("Semestral");
        jRBtKitSemestral.setEnabled(false);
        jRBtKitSemestral.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRBtKitSemestralItemStateChanged(evt);
            }
        });

        grupoBotoes.add(jRBtKitAnual);
        jRBtKitAnual.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBtKitAnual.setText("Anual");
        jRBtKitAnual.setEnabled(false);
        jRBtKitAnual.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRBtKitAnualItemStateChanged(evt);
            }
        });

        jBtPesquisarKit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/overlays.png"))); // NOI18N
        jBtPesquisarKit.setEnabled(false);
        jBtPesquisarKit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisarKitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRBtKitDecendial)
                    .addComponent(jRBtKitInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRBtKitQuinzenal)
                    .addComponent(jRBtKitSemestral))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRBtKitAnual)
                    .addComponent(jRBtKitMensal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jBtPesquisarKit, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jRBtKitMensal)
                    .addComponent(jRBtKitQuinzenal)
                    .addComponent(jRBtKitInicial))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jRBtKitDecendial)
                        .addComponent(jRBtKitSemestral))
                    .addComponent(jRBtKitAnual))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtPesquisarKit)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jTabelaGeralProdutosKit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaGeralProdutosKit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição Produtos", "Un.", "Quant."
            }
        ));
        jScrollPane3.setViewportView(jTabelaGeralProdutosKit);
        if (jTabelaGeralProdutosKit.getColumnModel().getColumnCount() > 0) {
            jTabelaGeralProdutosKit.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaGeralProdutosKit.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaGeralProdutosKit.getColumnModel().getColumn(1).setMinWidth(250);
            jTabelaGeralProdutosKit.getColumnModel().getColumn(1).setMaxWidth(250);
            jTabelaGeralProdutosKit.getColumnModel().getColumn(2).setMinWidth(50);
            jTabelaGeralProdutosKit.getColumnModel().getColumn(2).setMaxWidth(50);
            jTabelaGeralProdutosKit.getColumnModel().getColumn(3).setMinWidth(50);
            jTabelaGeralProdutosKit.getColumnModel().getColumn(3).setMaxWidth(50);
        }

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jBtAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterar.setText("Alterar");
        jBtAlterar.setEnabled(false);
        jBtAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarActionPerformed(evt);
            }
        });

        jBtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelar.setText("Cancelar");
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

        jBtNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovo.setText("Novo");
        jBtNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoActionPerformed(evt);
            }
        });

        jBtExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluir.setText("Excluir");
        jBtExcluir.setEnabled(false);
        jBtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirActionPerformed(evt);
            }
        });

        jBtSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvar.setText("Gravar");
        jBtSalvar.setEnabled(false);
        jBtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jBtNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel12Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterar, jBtCancelar, jBtExcluir, jBtNovo, jBtSalvar});

        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtAlterar)
                    .addComponent(jBtCancelar)
                    .addComponent(jBtAuditoria)
                    .addComponent(jBtNovo)
                    .addComponent(jBtExcluir)
                    .addComponent(jBtSalvar))
                .addContainerGap())
        );

        jPanel12Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtExcluir, jBtNovo, jBtSalvar});

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Colaborador Responsável", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(204, 0, 0))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Código");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Nome do Colaborador");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Departamento");

        jIdFunc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdFunc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdFunc.setEnabled(false);

        jNomeColaborador.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeColaborador.setEnabled(false);

        jDepartamentoColaborador.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDepartamentoColaborador.setEnabled(false);

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jFotoColaborador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jFotoColaborador, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jFotoColaborador, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jNomeColaborador)
                            .addComponent(jDepartamentoColaborador)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(0, 221, Short.MAX_VALUE)))
                        .addGap(10, 10, 10))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jIdFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addGap(11, 11, 11)
                        .addComponent(jIdFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jNomeColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDepartamentoColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Observação", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 102, 51))); // NOI18N

        jScrollPane5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jObservacao.setColumns(20);
        jObservacao.setRows(5);
        jObservacao.setEnabled(false);
        jScrollPane5.setViewportView(jObservacao);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                .addContainerGap())
        );

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

        jtotalProdutosKit.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalProdutosKit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalProdutosKit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
        );

        jBtPesquisarColaborador.setForeground(new java.awt.Color(0, 153, 153));
        jBtPesquisarColaborador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesquisarColaborador.setText("Adicionar Colaborador");
        jBtPesquisarColaborador.setEnabled(false);
        jBtPesquisarColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisarColaboradorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jBtPesquisarColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesquisarColaborador)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Geral", new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/40_16x16.png")), jPanel1); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Pavilhão e Internos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(204, 0, 0))); // NOI18N

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Pavilhão", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jComboBoxPavilhoes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxPavilhoes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione..." }));
        jComboBoxPavilhoes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxPavilhoes.setEnabled(false);

        jBtPesquisarInternosPavilhao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/overlays.png"))); // NOI18N
        jBtPesquisarInternosPavilhao.setEnabled(false);
        jBtPesquisarInternosPavilhao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisarInternosPavilhaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxPavilhoes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtPesquisarInternosPavilhao, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxPavilhoes, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesquisarInternosPavilhao))
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Internos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(204, 0, 0))); // NOI18N

        jTabelaInternos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaInternos.setForeground(new java.awt.Color(204, 0, 0));
        jTabelaInternos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "CNC", "Nome do Interno"
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
            jTabelaInternos.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaInternos.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaInternos.getColumnModel().getColumn(2).setMinWidth(350);
            jTabelaInternos.getColumnModel().getColumn(2).setMaxWidth(350);
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

        jPanel32.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jtotalInternosPavilhao.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalInternosPavilhao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalInternosPavilhao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Seleção", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(153, 0, 51))); // NOI18N

        jBtNovoPavInternos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoPavInternos.setText("Novo");
        jBtNovoPavInternos.setEnabled(false);
        jBtNovoPavInternos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtNovoPavInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoPavInternosActionPerformed(evt);
            }
        });

        jBtExcluirPavInternos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirPavInternos.setText("Excluir");
        jBtExcluirPavInternos.setEnabled(false);
        jBtExcluirPavInternos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtExcluirPavInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirPavInternosActionPerformed(evt);
            }
        });

        jBtSelecionarUmInterno.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtSelecionarUmInterno.setForeground(new java.awt.Color(0, 102, 0));
        jBtSelecionarUmInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/250718131515_16.png"))); // NOI18N
        jBtSelecionarUmInterno.setToolTipText("Adicionar interno selecionado na tabela a direita");
        jBtSelecionarUmInterno.setEnabled(false);
        jBtSelecionarUmInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSelecionarUmInternoActionPerformed(evt);
            }
        });

        jBtSelecionarTodosInternos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtSelecionarTodosInternos.setForeground(new java.awt.Color(0, 102, 0));
        jBtSelecionarTodosInternos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/250718131115_16.png"))); // NOI18N
        jBtSelecionarTodosInternos.setToolTipText("Adicionar todos os internos para tabela a direita");
        jBtSelecionarTodosInternos.setEnabled(false);
        jBtSelecionarTodosInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSelecionarTodosInternosActionPerformed(evt);
            }
        });

        jBtSalvarPavInternos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarPavInternos.setText("Gravar");
        jBtSalvarPavInternos.setEnabled(false);
        jBtSalvarPavInternos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtSalvarPavInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarPavInternosActionPerformed(evt);
            }
        });

        jBtAuditoriaPavInternos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaPavInternos.setContentAreaFilled(false);
        jBtAuditoriaPavInternos.setEnabled(false);

        jBtCancelarPavilhaoInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarPavilhaoInterno.setText("Cancelar");
        jBtCancelarPavilhaoInterno.setEnabled(false);
        jBtCancelarPavilhaoInterno.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtCancelarPavilhaoInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarPavilhaoInternoActionPerformed(evt);
            }
        });

        jBtExcluirUmInterno.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtExcluirUmInterno.setForeground(new java.awt.Color(204, 0, 0));
        jBtExcluirUmInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/250718131526_16.png"))); // NOI18N
        jBtExcluirUmInterno.setToolTipText("Excluir interno selecionado");
        jBtExcluirUmInterno.setEnabled(false);
        jBtExcluirUmInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirUmInternoActionPerformed(evt);
            }
        });

        jBtExcluirTodosInternos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtExcluirTodosInternos.setForeground(new java.awt.Color(204, 0, 0));
        jBtExcluirTodosInternos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/250718131210_16.png"))); // NOI18N
        jBtExcluirTodosInternos.setToolTipText("Excluir todos os internos selecionados");
        jBtExcluirTodosInternos.setEnabled(false);
        jBtExcluirTodosInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirTodosInternosActionPerformed(evt);
            }
        });

        jBtSaldoEstoque.setForeground(new java.awt.Color(0, 0, 255));
        jBtSaldoEstoque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/overlays.png"))); // NOI18N
        jBtSaldoEstoque.setText("S.Estoque");
        jBtSaldoEstoque.setToolTipText("Consultar Estoque de Produtos");
        jBtSaldoEstoque.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtSaldoEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSaldoEstoqueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                .addComponent(jBtNovoPavInternos)
                                .addComponent(jBtExcluirPavInternos)
                                .addComponent(jBtSalvarPavInternos)
                                .addComponent(jBtCancelarPavilhaoInterno)
                                .addComponent(jBtSelecionarUmInterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBtSelecionarTodosInternos, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                                .addComponent(jBtAuditoriaPavInternos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jBtExcluirUmInterno)
                                .addComponent(jBtExcluirTodosInternos))))
                    .addComponent(jBtSaldoEstoque))
                .addContainerGap())
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtCancelarPavilhaoInterno, jBtExcluirPavInternos, jBtExcluirTodosInternos, jBtExcluirUmInterno, jBtNovoPavInternos, jBtSaldoEstoque, jBtSalvarPavInternos, jBtSelecionarTodosInternos, jBtSelecionarUmInterno});

        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jBtNovoPavInternos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirPavInternos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarPavInternos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelarPavilhaoInterno)
                .addGap(62, 62, 62)
                .addComponent(jBtSelecionarUmInterno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSelecionarTodosInternos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirUmInterno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirTodosInternos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jBtSaldoEstoque)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAuditoriaPavInternos, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Internos Selecionados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 102, 0))); // NOI18N

        jTabelaInternosSelecionados.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaInternosSelecionados.setForeground(new java.awt.Color(0, 102, 0));
        jTabelaInternosSelecionados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "CNC", "Nome do Interno"
            }
        ));
        jScrollPane2.setViewportView(jTabelaInternosSelecionados);
        if (jTabelaInternosSelecionados.getColumnModel().getColumnCount() > 0) {
            jTabelaInternosSelecionados.getColumnModel().getColumn(0).setMinWidth(60);
            jTabelaInternosSelecionados.getColumnModel().getColumn(0).setMaxWidth(60);
            jTabelaInternosSelecionados.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaInternosSelecionados.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaInternosSelecionados.getColumnModel().getColumn(2).setMinWidth(350);
            jTabelaInternosSelecionados.getColumnModel().getColumn(2).setMaxWidth(350);
        }

        jPanel33.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 113, Short.MAX_VALUE)
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        jPanel34.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jLabel68.setText("Total de Registros:");

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel68))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel68)
        );

        jPanel35.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jtotalInternosSelecionados.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalInternosSelecionados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalInternosSelecionados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Pavilhão/Internos", new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/user-group-forum-icone-3716-16.png")), jPanel2); // NOI18N

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Produtos do Kit", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(102, 0, 0))); // NOI18N

        jTabelaProduto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Código", "Descrição Produto", "Un.", "Quant."
            }
        ));
        jScrollPane4.setViewportView(jTabelaProduto);
        if (jTabelaProduto.getColumnModel().getColumnCount() > 0) {
            jTabelaProduto.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaProduto.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaProduto.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaProduto.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaProduto.getColumnModel().getColumn(2).setMinWidth(250);
            jTabelaProduto.getColumnModel().getColumn(2).setMaxWidth(250);
            jTabelaProduto.getColumnModel().getColumn(3).setMinWidth(50);
            jTabelaProduto.getColumnModel().getColumn(3).setMaxWidth(50);
            jTabelaProduto.getColumnModel().getColumn(4).setMinWidth(70);
            jTabelaProduto.getColumnModel().getColumn(4).setMaxWidth(70);
        }

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Código");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Un.");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Quant.");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Descrição");

        jCodigoProd.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodigoProd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCodigoProd.setEnabled(false);

        jUnidadeProd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jUnidadeProd.setEnabled(false);

        jDescricaoProd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDescricaoProd.setEnabled(false);

        jQuantidadeProd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQuantidadeProd.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jQuantidadeProd.setEnabled(false);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDescricaoProd)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jCodigoProd, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jUnidadeProd, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jQuantidadeProd, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jQuantidadeProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jUnidadeProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCodigoProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDescricaoProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel39.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 256, Short.MAX_VALUE)
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        jPanel40.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jLabel70.setText("Total de Registros:");

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel70))
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel70)
        );

        jPanel41.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jtotalProdutosKitInternos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalProdutosKitInternos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalProdutosKitInternos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Confirmação", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(204, 0, 0))); // NOI18N

        jButton21.setForeground(new java.awt.Color(102, 0, 102));
        jButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/overlays.png"))); // NOI18N
        jButton21.setText("Consultar Estoque");
        jButton21.setEnabled(false);
        jButton21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jButton22.setForeground(new java.awt.Color(0, 102, 102));
        jButton22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/document-file-search-zoom-preview-icone-3750-16.png"))); // NOI18N
        jButton22.setText("Consultar Kit");
        jButton22.setEnabled(false);
        jButton22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jButton23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/refresh-reload-icone-6258-16.png"))); // NOI18N
        jButton23.setText("Alterar Qtd. kit");
        jButton23.setEnabled(false);
        jButton23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jButton20.setForeground(new java.awt.Color(204, 0, 0));
        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/overlays.png"))); // NOI18N
        jButton20.setText("Selecionar Produtos");
        jButton20.setEnabled(false);
        jButton20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton22, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton23, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton21)
                            .addComponent(jButton20))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel10Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton20, jButton21, jButton22, jButton23});

        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jButton20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton21)
                .addGap(66, 66, 66)
                .addComponent(jButton22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton23)
                .addContainerGap(177, Short.MAX_VALUE))
        );

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Totais de Produtos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 204))); // NOI18N

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 172, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Composição do Kit", new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Full_shopping_cart_Icon_16.png")), jPanel16); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Dados Iniciais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Status:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Data:");

        jIdRegistroComp.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdRegistroComp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdRegistroComp.setEnabled(false);

        jStatusComp.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jStatusComp.setForeground(new java.awt.Color(204, 0, 0));
        jStatusComp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jStatusComp.setDisabledTextColor(new java.awt.Color(204, 0, 0));
        jStatusComp.setEnabled(false);

        jDataComp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataComp.setEnabled(false);

        jBtPesquisaComp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/overlays.png"))); // NOI18N
        jBtPesquisaComp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisaCompActionPerformed(evt);
            }
        });

        jBtFinalizar.setForeground(new java.awt.Color(0, 102, 0));
        jBtFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/tick.png"))); // NOI18N
        jBtFinalizar.setText("Finalizar");
        jBtFinalizar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFinalizarActionPerformed(evt);
            }
        });

        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSair.setText("Sair");
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jIdRegistroComp, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jStatusComp, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDataComp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtFinalizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(jBtPesquisaComp, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtFinalizar, jBtSair});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(jIdRegistroComp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jStatusComp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jDataComp, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtFinalizar)
                    .addComponent(jBtPesquisaComp, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jBtSair))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBounds(200, 30, 903, 557);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoAL.equals("ADMINISTRADORES") || codigoUserAL == codUserAcessoAL && nomeTelaAL.equals(telaMontagemPagamentoKitAL) && codIncluirAL == 1) {
            acao = 1;
            bloquearBotoes();
            bloquearCampos();
            limparCampos();
            limparTabelaItensKit();
            limparTabelasAbaPavIntComp();
            Novo();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, solicite liberação ao administrador do sistema.");
        }
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        // TODO add your handling code here:
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoAL.equals("ADMINISTRADORES") || codigoUserAL == codUserAcessoAL && nomeTelaAL.equals(telaMontagemPagamentoKitAL) && codAlterarAL == 1) {
            acao = 2;
            bloquearBotoes();
            bloquearCampos();
            Alterar();
            statusMov = "Alterou";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, solicite liberação ao administrador do sistema.");
        }
    }//GEN-LAST:event_jBtAlterarActionPerformed

    private void jBtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirActionPerformed
        // TODO add your handling code here:
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoAL.equals("ADMINISTRADORES") || codigoUserAL == codUserAcessoAL && nomeTelaAL.equals(telaMontagemPagamentoKitAL) && codExcluirAL == 1) {
            objComp.setStatusComp(jStatusComp.getText());
            if (jStatusComp.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser modificado, o mesmo encontra-se FINALIZADO");
            } else {
                statusMov = "Excluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
                // AINDA NÃO FOI CRIADO
                verificarDadosIniciais();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, solicite liberação ao administrador do sistema.");
        }
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoAL.equals("ADMINISTRADORES") || codigoUserAL == codUserAcessoAL && nomeTelaAL.equals(telaMontagemPagamentoKitAL) && codGravarAL == 1) {
            if (jDataComp.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "É necessário informar a data do registro.");
            } else if (codigoPesquisaKit == 0 && codigoPesquisaKitItem == 0) {
                JOptionPane.showMessageDialog(rootPane, "Os códigos do tipo de kit e dos produtos dos kits estão nulos, faça uma nova pesquisa.");
            } else if (jIdFunc.getText().equals("") && jNomeColaborador.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário informar o colaborador responsavel.");
            } else {
                objComp.setDataComp(jDataComp.getDate());
                objComp.setStatusComp(jStatusComp.getText());
                objComp.setIdKit(codigoPesquisaKit);
                objComp.setIdItem(codigoPesquisaKitItem);
                objComp.setIdFunc(Integer.valueOf(jIdFunc.getText()));
                objComp.setNomeColaborador(jNomeColaborador.getText());
                objComp.setObservacao(jObservacao.getText());
                if (acao == 1) {
                    objComp.setUsuarioInsert(nameUser);
                    objComp.setDataInsert(dataModFinal);
                    objComp.setHorarioInsert(horaMov);
                    control.incluirComposicaoKitlInternos(objComp);
                    buscarCodigoDadosIniciais();
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    bloquearBotoes();
                    bloquearCampos();
                    Salvar();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
                if (acao == 2) {
                    objComp.setUsuarioUp(nameUser);
                    objComp.setDataUp(dataModFinal);
                    objComp.setHorarioUp(horaMov);
                    objComp.setIdRegistroComp(Integer.valueOf(jIdRegistroComp.getText()));
                    control.alterarComposicaoKitlInternos(objComp);
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    bloquearBotoes();
                    bloquearCampos();
                    Salvar();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, solicite liberação ao administrador do sistema.");
        }
    }//GEN-LAST:event_jBtSalvarActionPerformed

    private void jBtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarActionPerformed
        // TODO add your handling code here:
        bloquearBotoes();
        bloquearCampos();
        Cancelar();
    }//GEN-LAST:event_jBtCancelarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtAuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtAuditoriaActionPerformed

    private void jRBtKitInicialItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRBtKitInicialItemStateChanged
        // TODO add your handling code here:
        count = 0;
        if (evt.getStateChange() == evt.SELECTED) {
            preencherTabelaItensKit("SELECT * FROM PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                    + "WHERE KitInicial='" + codigoPesquisaKit + "'");
        }
    }//GEN-LAST:event_jRBtKitInicialItemStateChanged

    private void jRBtKitQuinzenalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRBtKitQuinzenalItemStateChanged
        // TODO add your handling code here:
        count = 0;
        if (evt.getStateChange() == evt.SELECTED) {
            preencherTabelaItensKit("SELECT * FROM PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                    + "WHERE KitQuinzenal='" + codigoPesquisaKit + "'");
        }
    }//GEN-LAST:event_jRBtKitQuinzenalItemStateChanged

    private void jRBtKitMensalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRBtKitMensalItemStateChanged
        // TODO add your handling code here:
        count = 0;
        if (evt.getStateChange() == evt.SELECTED) {
            preencherTabelaItensKit("SELECT * FROM PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                    + "WHERE KitMensal='" + codigoPesquisaKit + "'");
        }
    }//GEN-LAST:event_jRBtKitMensalItemStateChanged

    private void jRBtKitDecendialItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRBtKitDecendialItemStateChanged
        // TODO add your handling code here:
        count = 0;
        if (evt.getStateChange() == evt.SELECTED) {
            preencherTabelaItensKit("SELECT * FROM PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                    + "WHERE KitDecendial='" + codigoPesquisaKit + "'");
        }
    }//GEN-LAST:event_jRBtKitDecendialItemStateChanged

    private void jRBtKitSemestralItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRBtKitSemestralItemStateChanged
        // TODO add your handling code here:
        count = 0;
        if (evt.getStateChange() == evt.SELECTED) {
            preencherTabelaItensKit("SELECT * FROM PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                    + "WHERE KitSemestral='" + codigoPesquisaKit + "'");
        }
    }//GEN-LAST:event_jRBtKitSemestralItemStateChanged

    private void jRBtKitAnualItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRBtKitAnualItemStateChanged
        // TODO add your handling code here:
        count = 0;
        if (evt.getStateChange() == evt.SELECTED) {
            preencherTabelaItensKit("SELECT * FROM PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                    + "WHERE KitAnual='" + codigoPesquisaKit + "'");
        }
    }//GEN-LAST:event_jRBtKitAnualItemStateChanged

    private void jBtFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFinalizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtFinalizarActionPerformed

    private void jBtPesquisarKitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisarKitActionPerformed
        // TODO add your handling code here:
        mostrarBuscaKit();
    }//GEN-LAST:event_jBtPesquisarKitActionPerformed

    private void jBtPesquisarColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisarColaboradorActionPerformed
        // TODO add your handling code here:
        mostrarColaborador();
    }//GEN-LAST:event_jBtPesquisarColaboradorActionPerformed

    private void jBtPesquisaCompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisaCompActionPerformed
        // TODO add your handling code here:
        mostrarPesquisas();
    }//GEN-LAST:event_jBtPesquisaCompActionPerformed

    private void jBtNovoPavInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoPavInternosActionPerformed
        // TODO add your handling code here:
        statusMov = "Incluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        acao = 3;
        bloquearBotoes();
        bloquearCampos();
        NovoPavilhaoInterno();
        pesquisarPavilhao();
    }//GEN-LAST:event_jBtNovoPavInternosActionPerformed

    private void jBtExcluirPavInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirPavInternosActionPerformed
        // TODO add your handling code here:
        bloquearBotoes();
        bloquearCampos();
        limparTabelasAbaPavIntComp();
        ExcluirPavilhaoInterno();
    }//GEN-LAST:event_jBtExcluirPavInternosActionPerformed

    private void jBtSalvarPavInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarPavInternosActionPerformed
        // TODO add your handling code here:  
//        Integer row = jTabelaInternos.getRowCount();        
//        if (row == 0) {
//            JOptionPane.showMessageDialog(rootPane, "Não existe internos selecionados para pagamento dos kits.");
//        } else {
            mostrarThread();
            bloquearBotoes();
            bloquearCampos();
            SalvarPavilhaoInterno();
//        }
    }//GEN-LAST:event_jBtSalvarPavInternosActionPerformed

    private void jBtCancelarPavilhaoInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarPavilhaoInternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtCancelarPavilhaoInternoActionPerformed

    private void jBtSelecionarUmInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSelecionarUmInternoActionPerformed
        // TODO add your handling code here:
        Integer rows = jTabelaInternos.getModel().getRowCount();
        if (rows != 0) {
            count2 = count2 + 1;
            qtdInternos = qtdInternos  - 1;
            if (flag == 1) {
                jtotalInternosSelecionados.setText(Integer.toString(count2)); // Converter inteiro em string para exibir na tela 
                jtotalInternosPavilhao.setText(Integer.toString(qtdInternos));
                if (jTabelaInternos.getSelectedRowCount() != 0) { //Verifica se existe linha selecionada para não dar erro na hora de pegar os valores
                    //Pega os models das listas, para fazer as inserções e remoções
                    DefaultTableModel modelOrigem = (DefaultTableModel) jTabelaInternos.getModel();
                    DefaultTableModel modelDestino = (DefaultTableModel) jTabelaInternosSelecionados.getModel();
                    //Cria uma linha para ser incluida na tabela de destino, no meu caso tem duas colunas, adapte para as suas tabelas
                    Object[] obj = {jTabelaInternos.getValueAt(jTabelaInternos.getSelectedRow(), 0), jTabelaInternos.getValueAt(jTabelaInternos.getSelectedRow(), 1), jTabelaInternos.getValueAt(jTabelaInternos.getSelectedRow(), 2)};
                    // BARRA DE ROLAGEM HORIZONTAL
                    jTabelaInternosSelecionados.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                    // ALINHAR TEXTO DA TABELA CENTRALIZADO
                    DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                    centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                    //
                    jTabelaInternosSelecionados.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                    jTabelaInternosSelecionados.getColumnModel().getColumn(1).setCellRenderer(centralizado);
                    //Adiciona no destino e remove da origem
                    modelDestino.addRow(obj);
                    modelOrigem.removeRow(jTabelaInternos.getSelectedRow());                    
                } else {                    
                    JOptionPane.showMessageDialog(rootPane, "Selecione pelo menos uma linha para transferir todos registros da tabela.");
                    //Não tem nenhuma linha selecionada na tabela de origem, faça um aviso para o usuário ou algo do tipo.                    
                }                
            }            
        }        
    }//GEN-LAST:event_jBtSelecionarUmInternoActionPerformed

    private void jBtSelecionarTodosInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSelecionarTodosInternosActionPerformed
        // TODO add your handling code here:
        flag = 0;
        Integer rows = jTabelaInternos.getModel().getRowCount();
        if (rows != 0) {
            DefaultTableModel dadosDestino = (DefaultTableModel) jTabelaInternosSelecionados.getModel();
            PavilhaoInternoMontaKit d = new PavilhaoInternoMontaKit();
            try {
                for (PavilhaoInternoMontaKit dd : controle.read()) {
                    jtotalInternosSelecionados.setText(jtotalInternosPavilhao.getText()); // Converter inteiro em string para exibir na tela                                                         
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
            // APAGAR TODOS OS REGISTROS DA TABELA COPIADA
            DefaultTableModel tblRemove = (DefaultTableModel) jTabelaInternos.getModel();
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
            jtotalInternosPavilhao.setText("");
        }
    }//GEN-LAST:event_jBtSelecionarTodosInternosActionPerformed

    private void jBtExcluirUmInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirUmInternoActionPerformed
        // TODO add your handling code here:
        if (jTabelaInternosSelecionados.getSelectedRowCount() != 0) { //Verifica se existe linha selecionada para não dar erro na hora de pegar os valores
            //Pega os models das listas, para fazer as inserções e remoções
            DefaultTableModel modelOrigem = (DefaultTableModel) jTabelaInternosSelecionados.getModel();
            DefaultTableModel modelDestino = (DefaultTableModel) jTabelaInternos.getModel();
            //Cria uma linha para ser incluida na tabela de destino, no meu caso tem duas colunas, adapte para as suas tabelas
            Object[] obj = {jTabelaInternosSelecionados.getValueAt(jTabelaInternosSelecionados.getSelectedRow(), 0), jTabelaInternosSelecionados.getValueAt(jTabelaInternosSelecionados.getSelectedRow(), 1), jTabelaInternosSelecionados.getValueAt(jTabelaInternosSelecionados.getSelectedRow(), 2)};
            // BARRA DE ROLAGEM HORIZONTAL
            jTabelaInternos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            // ALINHAR TEXTO DA TABELA CENTRALIZADO
            DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);
            //
            jTabelaInternos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
            jTabelaInternos.getColumnModel().getColumn(1).setCellRenderer(centralizado);
            //Adiciona no destino e remove da origem
            modelDestino.addRow(obj);
            modelOrigem.removeRow(jTabelaInternosSelecionados.getSelectedRow());
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione pelo menos uma linha para transferir todos registros da tabela.");
            //Não tem nenhuma linha selecionada na tabela de origem, faça um aviso para o usuário ou algo do tipo.
        }
    }//GEN-LAST:event_jBtExcluirUmInternoActionPerformed

    private void jBtExcluirTodosInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirTodosInternosActionPerformed
        // TODO add your handling code here:
        flag = 0;
        Integer rows = jTabelaInternosSelecionados.getModel().getRowCount();
        if (rows != 0) {
            DefaultTableModel dadosDestino = (DefaultTableModel) jTabelaInternos.getModel();
            PavilhaoInternoMontaKit d = new PavilhaoInternoMontaKit();
            try {
                for (PavilhaoInternoMontaKit dd : controle.read()) {
                    jtotalInternosPavilhao.setText(jtotalInternosSelecionados.getText()); // Converter inteiro em string para exibir na tela                                     
                    dadosDestino.addRow(new Object[]{dd.getIdInternoCrc(), dd.getCncInternoCrc(), dd.getNomeInternoCrc()});
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
                Logger.getLogger(TelaMontagemPagamentoKitInterno.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // APAGAR DADOS DA TABELA
        while (jTabelaInternosSelecionados.getModel().getRowCount() > 0) {
            ((DefaultTableModel) jTabelaInternosSelecionados.getModel()).removeRow(0);
        }
        // LIMPAR O TOTALIZADOR DA TABELA
        jtotalInternosSelecionados.setText("");
    }//GEN-LAST:event_jBtExcluirTodosInternosActionPerformed

    private void jBtPesquisarInternosPavilhaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisarInternosPavilhaoActionPerformed
        // TODO add your handling code here:
        if (jComboBoxPavilhoes.getSelectedItem() == null || jComboBoxPavilhoes.getSelectedItem().equals("Selecione...")) {
            JOptionPane.showMessageDialog(rootPane, "É necessario informar o pavilhão para incluir os internos.");
        } else {
            count1 = 0;
            DefaultTableModel dadosOrigem = (DefaultTableModel) jTabelaInternos.getModel();
            PavilhaoInternoMontaKit d = new PavilhaoInternoMontaKit();
            try {
                for (PavilhaoInternoMontaKit dd : controle.read()) {
                    codigoPavilhao = dd.getIdPav();
                    jtotalInternosPavilhao.setText(Integer.toString(qtdInternos)); // Converter inteiro em string para exibir na tela 
                    dadosOrigem.addRow(new Object[]{dd.getIdInternoCrc(), dd.getCncInternoCrc(), dd.getNomeInternoCrc()});
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
                Logger.getLogger(TelaMontagemPagamentoKitInterno.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jBtPesquisarInternosPavilhaoActionPerformed

    private void jTabelaInternosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaInternosMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            idInterno = "" + jTabelaInternos.getValueAt(jTabelaInternos.getSelectedRow(), 0);
            cncInterno = "" + jTabelaInternos.getValueAt(jTabelaInternos.getSelectedRow(), 1);
            nomeInterno = "" + jTabelaInternos.getValueAt(jTabelaInternos.getSelectedRow(), 2);
        }
    }//GEN-LAST:event_jTabelaInternosMouseClicked

    private void jBtSaldoEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSaldoEstoqueActionPerformed
        // TODO add your handling code here:
        if (jIdRegistroComp.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "É necessario pesquisar o registro de montagem do kit para consultar o saldo de estoque.");
        } else {
            mostraEstoque();
        }
    }//GEN-LAST:event_jBtSaldoEstoqueActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup grupoBotoes;
    public static javax.swing.JButton jBtAlterar;
    public static javax.swing.JButton jBtAuditoria;
    public static javax.swing.JButton jBtAuditoriaPavInternos;
    public static javax.swing.JButton jBtCancelar;
    public static javax.swing.JButton jBtCancelarPavilhaoInterno;
    public static javax.swing.JButton jBtExcluir;
    public static javax.swing.JButton jBtExcluirPavInternos;
    private javax.swing.JButton jBtExcluirTodosInternos;
    private javax.swing.JButton jBtExcluirUmInterno;
    private javax.swing.JButton jBtFinalizar;
    public static javax.swing.JButton jBtNovo;
    public static javax.swing.JButton jBtNovoPavInternos;
    private javax.swing.JButton jBtPesquisaComp;
    private javax.swing.JButton jBtPesquisarColaborador;
    private javax.swing.JButton jBtPesquisarInternosPavilhao;
    private javax.swing.JButton jBtPesquisarKit;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSaldoEstoque;
    public static javax.swing.JButton jBtSalvar;
    public static javax.swing.JButton jBtSalvarPavInternos;
    public static javax.swing.JButton jBtSelecionarTodosInternos;
    public static javax.swing.JButton jBtSelecionarUmInterno;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JTextField jCodigoProd;
    public static javax.swing.JComboBox<String> jComboBoxPavilhoes;
    public static com.toedter.calendar.JDateChooser jDataComp;
    public static javax.swing.JTextField jDepartamentoColaborador;
    private javax.swing.JTextField jDescricaoProd;
    public static javax.swing.JLabel jFotoColaborador;
    public static javax.swing.JTextField jIdFunc;
    public static javax.swing.JTextField jIdRegistroComp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JTextField jNomeColaborador;
    public static javax.swing.JTextArea jObservacao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JFormattedTextField jQuantidadeProd;
    public static javax.swing.JRadioButton jRBtKitAnual;
    public static javax.swing.JRadioButton jRBtKitDecendial;
    public static javax.swing.JRadioButton jRBtKitInicial;
    public static javax.swing.JRadioButton jRBtKitMensal;
    public static javax.swing.JRadioButton jRBtKitQuinzenal;
    public static javax.swing.JRadioButton jRBtKitSemestral;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    public static javax.swing.JTextField jStatusComp;
    private javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JTable jTabelaGeralProdutosKit;
    public static javax.swing.JTable jTabelaInternos;
    public static javax.swing.JTable jTabelaInternosSelecionados;
    private javax.swing.JTable jTabelaProduto;
    private javax.swing.JTextField jUnidadeProd;
    public static javax.swing.JLabel jtotalInternosPavilhao;
    private javax.swing.JLabel jtotalInternosSelecionados;
    public static javax.swing.JLabel jtotalProdutosKit;
    private javax.swing.JLabel jtotalProdutosKitInternos;
    // End of variables declaration//GEN-END:variables

    public void formatarCampos() {
        jObservacao.setLineWrap(true);
        jObservacao.setWrapStyleWord(true);
    }

    public void corCampos() {
        //DADOS INICIAIS E ABA GERAL
        jIdRegistroComp.setBackground(Color.white);
        jStatusComp.setBackground(Color.white);
        jDataComp.setBackground(Color.white);
        jIdFunc.setBackground(Color.white);
        jNomeColaborador.setBackground(Color.white);
        jDepartamentoColaborador.setBackground(Color.white);
        jObservacao.setBackground(Color.white);
    }

    public void bloquearCampos() {
        // ABA DADOS INICIAIS
        jIdRegistroComp.setEnabled(!true);
        jStatusComp.setEnabled(!true);
        jDataComp.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jRBtKitInicial.setEnabled(!true);
        jRBtKitQuinzenal.setEnabled(!true);
        jRBtKitMensal.setEnabled(!true);
        jRBtKitDecendial.setEnabled(!true);
        jRBtKitSemestral.setEnabled(!true);
        jRBtKitAnual.setEnabled(!true);
        jObservacao.setEnabled(!true);
        // ABA PAVILHÃO/INTERNOS
        jComboBoxPavilhoes.setEnabled(!true);
    }

    public void bloquearBotoes() {
        // ABA DADOS INICIAIS  
        jBtFinalizar.setEnabled(!true);
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        jBtPesquisarKit.setEnabled(!true);
        jBtPesquisarColaborador.setEnabled(!true);
        // ABA PAVILHÃO/INTERNOS
        jBtNovoPavInternos.setEnabled(!true);
        jBtExcluirPavInternos.setEnabled(!true);
        jBtSalvarPavInternos.setEnabled(!true);
        jBtCancelarPavilhaoInterno.setEnabled(!true);
        //
        jBtSelecionarUmInterno.setEnabled(!true);
        jBtSelecionarTodosInternos.setEnabled(!true);
        jBtExcluirUmInterno.setEnabled(!true);
        jBtExcluirTodosInternos.setEnabled(!true);
        //
        jBtPesquisarInternosPavilhao.setEnabled(!true);
        jBtAuditoriaPavInternos.setEnabled(!true);
        // ABA COMPOSIÇÃO KIT

    }

    public void limparCampos() {
        // ABA DADOS INICIAIS
        jIdRegistroComp.setText("");
        jStatusComp.setText("");
        jDataComp.setDate(null);
        jIdFunc.setText("");
        jNomeColaborador.setText("");
        jDepartamentoColaborador.setText("");
        jFotoColaborador.setIcon(null);
        jObservacao.setText("");
        // ABA PAVILHÕES/INTERNOS
        jComboBoxPavilhoes.setSelectedItem("Selecione...");
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

    public void Novo() {
        // ABA DADOS INICIAIS       
        jStatusComp.setText("ABERTO");
        jDataComp.setCalendar(Calendar.getInstance());
        //  
        jObservacao.setEnabled(true);
        //
        jBtPesquisarKit.setEnabled(true);
        jBtPesquisarColaborador.setEnabled(true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
    }

    public void Alterar() {
        jObservacao.setEnabled(true);
        //
        jBtPesquisarKit.setEnabled(true);
        jBtPesquisarColaborador.setEnabled(true);
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
        jBtAuditoria.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        // ABA PAVILHÕES/INTERNOS
        jBtNovoPavInternos.setEnabled(true);
        jBtPesquisarInternosPavilhao.setEnabled(true);
    }

    public void Cancelar() {
        if (jIdRegistroComp.getText().equals("")) {
            limparCampos();
            jBtNovo.setEnabled(true);
        } else {
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            // ABA PAVILHÕES/INTERNOS
            jBtNovoPavInternos.setEnabled(true);
        }
    }

    public void buscarCodigoDadosIniciais() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE");
            conecta.rs.last();
            jIdRegistroComp.setText(conecta.rs.getString("IdRegistroComp"));
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarDadosIniciais() {
        Integer rows = jTabelaInternos.getModel().getRowCount();
        if (rows != 0) {
            conecta.abrirConexao();
//        try {
//            conecta.executaSQL("SELECT * FROM ITENS_REQUISICAO_PRODUTOS_INTERNOS WHERE IdReq='" + objReqMatInter.getIdReq() + "'");
//            conecta.rs.first();
//            codRequisicao = conecta.rs.getString("IdReq");
//            if (jCodReq.getText().equals(codRequisicao)) {
//                JOptionPane.showMessageDialog(rootPane, "Antes de excluir esse Lançamento, será necessário\nexcluir primeiro os itens relacionados a esse registro.");
//            }
//        } catch (SQLException ex) {
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objComp.setIdRegistroComp(Integer.parseInt(jIdRegistroComp.getText()));
                control.excluirComposicaoKitlInternos(objComp);
                objLog();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                bloquearBotoes();
                bloquearCampos();
                limparCampos();
                limparTabelaItensKit();
                limparTabelasAbaPavIntComp();
                Excluir();
            }
//        }
            conecta.desconecta();
        }
    }

    public void NovoPavilhaoInterno() {
        jComboBoxPavilhoes.setEnabled(true);
        //
        jBtPesquisarInternosPavilhao.setEnabled(true);
        jBtSalvarPavInternos.setEnabled(true);
        jBtCancelarPavilhaoInterno.setEnabled(true);
        //
        jBtSelecionarUmInterno.setEnabled(true);
        jBtSelecionarTodosInternos.setEnabled(true);
        jBtExcluirUmInterno.setEnabled(true);
        jBtExcluirTodosInternos.setEnabled(true);
    }

    public void AlterarPavilhaoInterno() {
        jBtSalvarPavInternos.setEnabled(true);
        jBtCancelarPavilhaoInterno.setEnabled(true);
        jBtSelecionarUmInterno.setEnabled(true);
        jBtSelecionarTodosInternos.setEnabled(true);
        jBtExcluirUmInterno.setEnabled(true);
        jBtExcluirTodosInternos.setEnabled(true);
    }

    public void ExcluirPavilhaoInterno() {

    }

    public void SalvarPavilhaoInterno() {
        // ABA PAVILHÃO/INTERNOS
        jBtExcluirPavInternos.setEnabled(true);
        jBtAuditoriaPavInternos.setEnabled(true);
        // ABA GERAL E DADOS INICIAIS
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        jBtFinalizar.setEnabled(true);
    }

    public void CancelarPavilhaoInterno() {

    }

    public void pesquisarPavilhao() {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PAVILHAO ORDER BY DescricaoPav");
            conecta.rs.first();
            do {
                jComboBoxPavilhoes.addItem(conecta.rs.getString("DescricaoPav"));
                codigoPavilhao = conecta.rs.getInt("IdPav");
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        conecta.desconecta();
    }

    public void buscarCodigoRegistroPavilhaoInterno() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PAVILHAO_INTERNOS_KIT_LOTE");
            conecta.rs.last();
            idRegPavInt = conecta.rs.getInt("IdRegPavInt");
        } catch (Exception ERROR) {
        }
        conecta.desconecta();
    }

    public void preencherTabelaItensKit(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Descrição Produto", "Un.", "Qtd."};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            codigoKit = conecta.rs.getInt("IdKit");
            count1 = 0;
            do {
                count = count + 1;
                qtdItem = conecta.rs.getFloat("QuantItem");
                DecimalFormat vi = new DecimalFormat(",###0.00");
                String vqtdItem = vi.format(qtdItem);
                qtdItemTab = vqtdItem;
                //
                jtotalProdutosKit.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela 
                dados.add(new Object[]{conecta.rs.getInt("IdProd"), conecta.rs.getString("DescricaoProd"), conecta.rs.getString("UnidadeProd"), qtdItemTab});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaGeralProdutosKit.setModel(modelo);
        jTabelaGeralProdutosKit.getColumnModel().getColumn(0).setPreferredWidth(50);
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
        alinharCamposTabelaItensKit();
        conecta.desconecta();
    }

    public void limparTabelaItensKit() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Descrição Produto", "Un.", "Qtd."};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaGeralProdutosKit.setModel(modelo);
        jTabelaGeralProdutosKit.getColumnModel().getColumn(0).setPreferredWidth(50);
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
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabelaItensKit() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaGeralProdutosKit.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaGeralProdutosKit.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        jTabelaGeralProdutosKit.getColumnModel().getColumn(3).setCellRenderer(direita);
    }

    public void preencherTabelaItensInterno(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "CNC", "Descrição do Interno"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count1 = count1 + 1;
                jtotalInternosPavilhao.setText(Integer.toString(count1)); // Converter inteiro em string para exibir na tela 
                dados.add(new Object[]{conecta.rs.getString("IdInternoCrc"), conecta.rs.getString("CNC"), conecta.rs.getString("NomeInternoCrc")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInternos.setModel(modelo);
        jTabelaInternos.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaInternos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaInternos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(2).setPreferredWidth(350);
        jTabelaInternos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInternos.getTableHeader().setReorderingAllowed(false);
        jTabelaInternos.setAutoResizeMode(jTabelaInternos.AUTO_RESIZE_OFF);
        jTabelaInternos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinarCamposTabelaInternos();
        conecta.desconecta();
    }

    public void alinarCamposTabelaInternos() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaInternos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaInternos.getColumnModel().getColumn(1).setCellRenderer(centralizado);
    }

    public void limparTabelaInternos() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "CNC", "Descrição do Interno"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInternos.setModel(modelo);
        jTabelaInternos.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaInternos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaInternos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(2).setPreferredWidth(350);
        jTabelaInternos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInternos.getTableHeader().setReorderingAllowed(false);
        jTabelaInternos.setAutoResizeMode(jTabelaInternos.AUTO_RESIZE_OFF);
        jTabelaInternos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void preencherTabelaTodosInternosSelecionados(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "CNC", "Descrição do Interno"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count1 = count1 + 1;
                jtotalInternosPavilhao.setText(Integer.toString(count1)); // Converter inteiro em string para exibir na tela 
                dados.add(new Object[]{conecta.rs.getString("IdInternoCrc"), conecta.rs.getString("CNC"), conecta.rs.getString("NomeInternoCrc")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInternosSelecionados.setModel(modelo);
        jTabelaInternosSelecionados.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaInternosSelecionados.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInternosSelecionados.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaInternosSelecionados.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInternosSelecionados.getColumnModel().getColumn(2).setPreferredWidth(350);
        jTabelaInternosSelecionados.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInternosSelecionados.getTableHeader().setReorderingAllowed(false);
        jTabelaInternosSelecionados.setAutoResizeMode(jTabelaInternos.AUTO_RESIZE_OFF);
        jTabelaInternosSelecionados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinarCamposTabelaInternosSelecionados();
    }

    public void alinarCamposTabelaInternosSelecionados() {
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        //
        jTabelaInternosSelecionados.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaInternosSelecionados.getColumnModel().getColumn(1).setCellRenderer(centralizado);
    }

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jIdRegistroComp.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog2() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela2);
        objLogSys.setIdLancMov(Integer.valueOf(jIdRegistroComp.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog3() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela3);
        objLogSys.setIdLancMov(Integer.valueOf(jIdRegistroComp.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }
}
