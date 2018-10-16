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
import gestor.Dao.ModeloTabela;
import gestor.Modelo.GravarInternosKitCompleto;
import gestor.Modelo.PavilhaoInternosSelecionados;
import gestor.Modelo.ProdutoInternosKitLote;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jRBtKitAnual;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jRBtKitDecendial;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jRBtKitInicial;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jRBtKitMensal;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jRBtKitQuinzenal;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.codigoPesquisaKit;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.codigoPesquisaKitItem;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jBtNovo;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jBtAlterar;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jBtExcluir;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jBtSalvar;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jBtCancelar;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jBtAuditoria;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jDataComp;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jDepartamentoColaborador;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jFotoColaborador;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jIdFunc;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jIdRegistroComp;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jNomeColaborador;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jObservacao;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jRBtKitSemestral;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jStatusComp;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jTabelaInternosKitCompleto;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jTabelaInternosSelecionados;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jTabelaProdutos;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jTabelaProdutosKitCompleto;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jtotalInternosKitCompleto;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jtotalInternosSelecionados;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jtotalProdutosKitCompleto;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.qtdInternosSelec;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.qtdProd;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jtotalProdutosKitInternos;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.qtdInternosKitComp;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.qtdProdutosKitComo;
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

/**
 *
 * @author ronal
 */
public class TelaPesquisaMontagemKitHigiene extends javax.swing.JDialog {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
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

    /**
     * Creates new form TelaPesquisaMontagemKitHigiene
     */
    public static TelaMontagemPagamentoKitInterno motaPagtoKit;

    public TelaPesquisaMontagemKitHigiene(TelaMontagemPagamentoKitInterno parent, boolean modal) {
        this.motaPagtoKit = parent;
        this.setModal(modal);
        setLocationRelativeTo(motaPagtoKit);
        initComponents();
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
        jLabel1 = new javax.swing.JLabel();
        jCodigoRegistro = new javax.swing.JTextField();
        jBtPesquisaCodigo = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jDataPesqInicial = new com.toedter.calendar.JDateChooser();
        jDataPesFinal = new com.toedter.calendar.JDateChooser();
        jBtPesquisaData = new javax.swing.JButton();
        jCheckBoxTodos = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jRBtKitInicialp = new javax.swing.JRadioButton();
        jRBtKitQuinzenalp = new javax.swing.JRadioButton();
        jRBtKitMensalp = new javax.swing.JRadioButton();
        jRBtKitDecendialp = new javax.swing.JRadioButton();
        jRBtKitSemestralp = new javax.swing.JRadioButton();
        jRBtKitAnualp = new javax.swing.JRadioButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("...::: Pesquisa de Registro de Montagem de Kits Higiêne de Internos :::...");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Pesquisa de Dados Inicias e Gerais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(204, 0, 0))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código:");

        jCodigoRegistro.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodigoRegistro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

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

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Tipo de Kit:");

        jRBtKitInicialp.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBtKitInicialp.setText("Inicial");
        jRBtKitInicialp.setEnabled(false);

        jRBtKitQuinzenalp.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBtKitQuinzenalp.setText("Quinzenal");
        jRBtKitQuinzenalp.setEnabled(false);

        jRBtKitMensalp.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBtKitMensalp.setText("Mensal");
        jRBtKitMensalp.setEnabled(false);

        jRBtKitDecendialp.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBtKitDecendialp.setText("Decendial");
        jRBtKitDecendialp.setEnabled(false);

        jRBtKitSemestralp.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBtKitSemestralp.setText("Semestral");
        jRBtKitSemestralp.setEnabled(false);

        jRBtKitAnualp.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBtKitAnualp.setText("Anual");
        jRBtKitAnualp.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCodigoRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(jBtPesquisaData, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(jCheckBoxTodos))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRBtKitInicialp, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRBtKitQuinzenalp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRBtKitMensalp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRBtKitDecendialp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRBtKitSemestralp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRBtKitAnualp)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(jCodigoRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesquisaCodigo)
                    .addComponent(jLabel2)
                    .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jDataPesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesquisaData)
                    .addComponent(jCheckBoxTodos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jRBtKitAnualp)
                    .addComponent(jRBtKitSemestralp)
                    .addComponent(jRBtKitDecendialp)
                    .addComponent(jRBtKitMensalp)
                    .addComponent(jRBtKitQuinzenalp)
                    .addComponent(jRBtKitInicialp)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TabelaRegistrosMontagemKits.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        TabelaRegistrosMontagemKits.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Registro", "Data Registro", "ID Kit", "Tipo Kit", "Código", "Colaborador", "Observação"
            }
        ));
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
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtConfirmar, jBtSair});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtConfirmar)
                    .addComponent(jBtSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesquisaCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisaCodigoActionPerformed
        // TODO add your handling code here:
        count = 0;
        if (jCodigoRegistro.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o código do Registro para pesquisa.");
        } else {
            preencherTabelaRegistrosMontagemKits("SELECT * FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
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
                    + "WHERE COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp='" + jCodigoRegistro.getText() + "'");
        }
    }//GEN-LAST:event_jBtPesquisaCodigoActionPerformed

    private void jBtPesquisaDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisaDataActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
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
                    preencherTabelaRegistrosMontagemKits("SELECT * FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
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
                            + "WHERE COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp BETWEEN'" + dataInicial + "' "
                            + "AND '" + dataFinal + "'");
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
            this.preencherTabelaRegistrosMontagemKits("SELECT * FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                    + "INNER JOIN COLABORADOR "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                    + "INNER JOIN DEPARTAMENTOS "
                    + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                    + "INNER JOIN KITS_HIGIENE_INTERNO "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                    + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdItem=PRODUTOS_KITS_HIGIENE_INTERNO.IdItem "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd");
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
            jCodigoRegistro.setText(idLanc);
            idKit = "" + TabelaRegistrosMontagemKits.getValueAt(TabelaRegistrosMontagemKits.getSelectedRow(), 2);
            if (kitInicial == 1) {
                jRBtKitInicialp.setSelected(true);
            } else if (kitInicial == 0) {
                jRBtKitInicialp.setSelected(!true);
            }
            if (kitQuinzenal == 1) {
                jRBtKitQuinzenal.setSelected(true);
                jRBtKitQuinzenalp.setSelected(true);
            } else if (kitQuinzenal == 0) {
                jRBtKitQuinzenal.setSelected(!true);
                jRBtKitQuinzenalp.setSelected(!true);
            }
            if (kitMensal == 1) {
                jRBtKitMensal.setSelected(true);
                jRBtKitMensalp.setSelected(true);
            } else if (kitMensal == 0) {
                jRBtKitMensal.setSelected(!true);
                jRBtKitMensalp.setSelected(!true);
            }
            if (kitDecendial == 1) {
                jRBtKitDecendial.setSelected(true);
                jRBtKitDecendialp.setSelected(true);
            } else if (kitDecendial == 0) {
                jRBtKitDecendial.setSelected(!true);
                jRBtKitDecendialp.setSelected(!true);
            }
            if (kitSemestral == 1) {
                jRBtKitSemestral.setSelected(true);
                jRBtKitSemestralp.setSelected(true);
            } else if (kitSemestral == 0) {
                jRBtKitSemestral.setSelected(!true);
                jRBtKitSemestralp.setSelected(!true);
            }
            if (kitAnual == 1) {
                jRBtKitAnual.setSelected(true);
                jRBtKitAnualp.setSelected(true);
            } else if (kitAnual == 0) {
                jRBtKitAnual.setSelected(!true);
                jRBtKitAnualp.setSelected(!true);
            }
        }
    }//GEN-LAST:event_TabelaRegistrosMontagemKitsMouseClicked

    private void jBtConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtConfirmarActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            //
            if (kitInicial == 1) {
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                            + "INNER JOIN COLABORADOR "
                            + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                            + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                            + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=PRODUTOS_KITS_HIGIENE_INTERNO.IdKit "
                            + "INNER JOIN PRODUTOS_AC "
                            + "ON PRODUTOS_AC.IdProd=PRODUTOS_KITS_HIGIENE_INTERNO.IdProd "
                            + "INNER JOIN DEPARTAMENTOS "
                            + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                            + "WHERE COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp='" + idLanc + "' "
                            + "AND COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit='" + idKit + "' "
                            + "AND PRODUTOS_KITS_HIGIENE_INTERNO.KitInicial='" + kitInicial + "'");
                    conecta.rs.first();
                    jIdRegistroComp.setText(String.valueOf(conecta.rs.getInt("IdRegistroComp")));
                    jStatusComp.setText(conecta.rs.getString("StatusComp"));
                    jDataComp.setDate(conecta.rs.getDate("DataComp"));
                    codigoPesquisaKitItem = conecta.rs.getInt("IdItem");
                    codigoPesquisaKit = conecta.rs.getInt("IdKit");
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
            } else if (kitQuinzenal == 1) {
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                            + "INNER JOIN COLABORADOR "
                            + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                            + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                            + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=PRODUTOS_KITS_HIGIENE_INTERNO.IdKit "
                            + "INNER JOIN PRODUTOS_AC "
                            + "ON PRODUTOS_AC.IdProd=PRODUTOS_KITS_HIGIENE_INTERNO.IdProd "
                            + "INNER JOIN DEPARTAMENTOS "
                            + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                            + "WHERE COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp='" + idLanc + "' "
                            + "AND COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit='" + idKit + "' "
                            + "AND PRODUTOS_KITS_HIGIENE_INTERNO.KitQuinzenal='" + kitQuinzenal + "'");
                    conecta.rs.first();
                    jIdRegistroComp.setText(String.valueOf(conecta.rs.getInt("IdRegistroComp")));
                    jStatusComp.setText(conecta.rs.getString("StatusComp"));
                    jDataComp.setDate(conecta.rs.getDate("DataComp"));
                    codigoPesquisaKitItem = conecta.rs.getInt("IdItem");
                    codigoPesquisaKit = conecta.rs.getInt("IdKit");
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
                conecta.desconecta();
                dispose();
            } else if (kitMensal == 1) {
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                            + "INNER JOIN COLABORADOR "
                            + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                            + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                            + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=PRODUTOS_KITS_HIGIENE_INTERNO.IdKit "
                            + "INNER JOIN PRODUTOS_AC "
                            + "ON PRODUTOS_AC.IdProd=PRODUTOS_KITS_HIGIENE_INTERNO.IdProd "
                            + "INNER JOIN DEPARTAMENTOS "
                            + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                            + "WHERE COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp='" + idLanc + "' "
                            + "AND COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit='" + idKit + "' "
                            + "AND PRODUTOS_KITS_HIGIENE_INTERNO.KitMensal='" + kitMensal + "'");
                    conecta.rs.first();
                    jIdRegistroComp.setText(String.valueOf(conecta.rs.getInt("IdRegistroComp")));
                    jStatusComp.setText(conecta.rs.getString("StatusComp"));
                    jDataComp.setDate(conecta.rs.getDate("DataComp"));
                    codigoPesquisaKitItem = conecta.rs.getInt("IdItem");
                    codigoPesquisaKit = conecta.rs.getInt("IdKit");
                    kitMensal = conecta.rs.getInt("KitMensal");
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
                conecta.desconecta();
                dispose();
            } else if (kitDecendial == 1) {
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                            + "INNER JOIN COLABORADOR "
                            + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                            + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                            + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=PRODUTOS_KITS_HIGIENE_INTERNO.IdKit "
                            + "INNER JOIN PRODUTOS_AC "
                            + "ON PRODUTOS_AC.IdProd=PRODUTOS_KITS_HIGIENE_INTERNO.IdProd "
                            + "INNER JOIN DEPARTAMENTOS "
                            + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                            + "WHERE COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp='" + idLanc + "' "
                            + "AND COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit='" + idKit + "' "
                            + "AND PRODUTOS_KITS_HIGIENE_INTERNO.KitDecendial='" + kitDecendial + "'");
                    conecta.rs.first();
                    jIdRegistroComp.setText(String.valueOf(conecta.rs.getInt("IdRegistroComp")));
                    jStatusComp.setText(conecta.rs.getString("StatusComp"));
                    jDataComp.setDate(conecta.rs.getDate("DataComp"));
                    codigoPesquisaKitItem = conecta.rs.getInt("IdItem");
                    codigoPesquisaKit = conecta.rs.getInt("IdKit");
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
                conecta.desconecta();
                dispose();
            } else if (kitSemestral == 1) {
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                            + "INNER JOIN COLABORADOR "
                            + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                            + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                            + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=PRODUTOS_KITS_HIGIENE_INTERNO.IdKit "
                            + "INNER JOIN PRODUTOS_AC "
                            + "ON PRODUTOS_AC.IdProd=PRODUTOS_KITS_HIGIENE_INTERNO.IdProd "
                            + "INNER JOIN DEPARTAMENTOS "
                            + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                            + "WHERE COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp='" + idLanc + "' "
                            + "AND COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit='" + idKit + "' "
                            + "AND PRODUTOS_KITS_HIGIENE_INTERNO.KitSemestral='" + kitSemestral + "'");
                    conecta.rs.first();
                    jIdRegistroComp.setText(String.valueOf(conecta.rs.getInt("IdRegistroComp")));
                    jStatusComp.setText(conecta.rs.getString("StatusComp"));
                    jDataComp.setDate(conecta.rs.getDate("DataComp"));
                    codigoPesquisaKitItem = conecta.rs.getInt("IdItem");
                    codigoPesquisaKit = conecta.rs.getInt("IdKit");
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
                conecta.desconecta();
                dispose();
            } else if (kitAnual == 1) {
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                            + "INNER JOIN COLABORADOR "
                            + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                            + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                            + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=PRODUTOS_KITS_HIGIENE_INTERNO.IdKit "
                            + "INNER JOIN PRODUTOS_AC "
                            + "ON PRODUTOS_AC.IdProd=PRODUTOS_KITS_HIGIENE_INTERNO.IdProd "
                            + "INNER JOIN DEPARTAMENTOS "
                            + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                            + "WHERE COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp='" + idLanc + "' "
                            + "AND COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit='" + idKit + "' "
                            + "AND PRODUTOS_KITS_HIGIENE_INTERNO.KitAnual='" + kitAnual + "'");
                    conecta.rs.first();
                    jIdRegistroComp.setText(String.valueOf(conecta.rs.getInt("IdRegistroComp")));
                    jStatusComp.setText(conecta.rs.getString("StatusComp"));
                    jDataComp.setDate(conecta.rs.getDate("DataComp"));
                    codigoPesquisaKitItem = conecta.rs.getInt("IdItem");
                    codigoPesquisaKit = conecta.rs.getInt("IdKit");
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
                conecta.desconecta();
                dispose();
            }
        }
    }//GEN-LAST:event_jBtConfirmarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

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
    private javax.swing.JButton jBtConfirmar;
    private javax.swing.JButton jBtPesquisaCodigo;
    private javax.swing.JButton jBtPesquisaData;
    private javax.swing.JButton jBtSair;
    private javax.swing.JCheckBox jCheckBoxTodos;
    private javax.swing.JTextField jCodigoRegistro;
    private com.toedter.calendar.JDateChooser jDataPesFinal;
    private com.toedter.calendar.JDateChooser jDataPesqInicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    public static javax.swing.JRadioButton jRBtKitAnualp;
    public static javax.swing.JRadioButton jRBtKitDecendialp;
    public static javax.swing.JRadioButton jRBtKitInicialp;
    public static javax.swing.JRadioButton jRBtKitMensalp;
    public static javax.swing.JRadioButton jRBtKitQuinzenalp;
    public static javax.swing.JRadioButton jRBtKitSemestralp;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public static javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void preencherTabelaRegistrosMontagemKits(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Registro", "Data Registro", "ID Kit", "Tipo Kit", "Código", "Colaborador", "Observação"};
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
                kitAnual = conecta.rs.getInt("KitAnual");
                kitDecendial = conecta.rs.getInt("KitDecendial");
                kitQuinzenal = conecta.rs.getInt("KitQuinzenal");
                kitMensal = conecta.rs.getInt("KitMensal");
                kitSemestral = conecta.rs.getInt("KitSemestral");
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
                dados.add(new Object[]{conecta.rs.getInt("IdRegistroComp"), dataEmissao, conecta.rs.getInt("IdKit"), nomeKit, conecta.rs.getString("IdFunc"), conecta.rs.getString("NomeFunc"), conecta.rs.getString("Observacao")});
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
        DefaultTableModel dadosDestino = (DefaultTableModel) jTabelaInternosSelecionados.getModel();
        PavilhaoInternosSelecionados d = new PavilhaoInternosSelecionados();
        try {
            for (PavilhaoInternosSelecionados dd : controle.read()) {
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

    public void mostrarProdutosSelecionados() {
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
            Logger.getLogger(TelaMontagemPagamentoKitInterno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mostrarInternosKitCompleto() {
        //
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
            Logger.getLogger(TelaMontagemPagamentoKitInterno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mostrarProdutosKitCompleto() {
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
            Logger.getLogger(TelaMontagemPagamentoKitInterno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
