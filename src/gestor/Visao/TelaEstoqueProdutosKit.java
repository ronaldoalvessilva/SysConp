/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.ModeloTabela;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.idKit;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jCodigoProd;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jUnidadeProd;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jQuantidadeProdEstoque;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jQuantidadeKit;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jDescricaoProd;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jQuantidadeInternos;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jtotalInternosSelecionados;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ronal
 */
public class TelaEstoqueProdutosKit extends javax.swing.JDialog {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    //
    double qtdItem = 0;
    String qtdItemTab;
    int count = 0;
    int flag = 0;
    String statusProd = "Ativo";
    float qtdEstoque = 0;
    String modulo = "A";
    String compoeKit = "Sim";
    String idProd;
    float qdtKit = 0;
    String nomeProduto = "";

    /**
     * Creates new form TelaConsultaEstoqueMontagemKit
     */
    public static TelaMontagemPagamentoKitInterno montaKitProd;

    public TelaEstoqueProdutosKit(TelaMontagemPagamentoKitInterno parent, boolean modal) {
        this.montaKitProd = parent;
        this.setModal(modal);
        setLocationRelativeTo(montaKitProd);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jCodigoProdPesquisa = new javax.swing.JTextField();
        jCodigoBarraPesquisa = new javax.swing.JTextField();
        jDescricapProdPesquisa = new javax.swing.JTextField();
        jCheckBoxTodos = new javax.swing.JCheckBox();
        jBtPesquisaCodigoProd = new javax.swing.JButton();
        jBtPesquisaNomeProd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelalProdutosEstoque = new javax.swing.JTable();
        jPanel36 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        jtotalProdutos = new javax.swing.JLabel();
        jBtConfirmar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("....::: Consulta de Estoque - Almoxarifado Local :::...");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Consulta de Saldo de Estoque", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 204))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Código Barra");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Descrição do Produto");

        jCodigoProdPesquisa.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodigoProdPesquisa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jCodigoBarraPesquisa.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodigoBarraPesquisa.setToolTipText("Pesquisar produto pelo código de barras");
        jCodigoBarraPesquisa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCodigoBarraPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCodigoBarraPesquisaActionPerformed(evt);
            }
        });

        jDescricapProdPesquisa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jCheckBoxTodos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxTodos.setText("Todos");
        jCheckBoxTodos.setToolTipText("Pesquisar todos os produtos");
        jCheckBoxTodos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxTodosItemStateChanged(evt);
            }
        });

        jBtPesquisaCodigoProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesquisaCodigoProd.setToolTipText("Pesquisar produto pelo código.");
        jBtPesquisaCodigoProd.setContentAreaFilled(false);
        jBtPesquisaCodigoProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisaCodigoProdActionPerformed(evt);
            }
        });

        jBtPesquisaNomeProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesquisaNomeProd.setToolTipText("Pesquisar produto pela descrição.");
        jBtPesquisaNomeProd.setContentAreaFilled(false);
        jBtPesquisaNomeProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisaNomeProdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jCodigoProdPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesquisaCodigoProd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jCodigoBarraPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckBoxTodos))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jDescricapProdPesquisa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesquisaNomeProd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtPesquisaCodigoProd)
                    .addComponent(jCodigoProdPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCodigoBarraPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxTodos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jDescricapProdPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesquisaNomeProd))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelalProdutosEstoque.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelalProdutosEstoque.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Código Barra", "Descrição do Produto", "Un.", "Qtd. Estoque", "Lote"
            }
        ));
        jTabelalProdutosEstoque.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelalProdutosEstoqueMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelalProdutosEstoque);
        if (jTabelalProdutosEstoque.getColumnModel().getColumnCount() > 0) {
            jTabelalProdutosEstoque.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelalProdutosEstoque.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelalProdutosEstoque.getColumnModel().getColumn(1).setMinWidth(100);
            jTabelalProdutosEstoque.getColumnModel().getColumn(1).setMaxWidth(100);
            jTabelalProdutosEstoque.getColumnModel().getColumn(2).setMinWidth(350);
            jTabelalProdutosEstoque.getColumnModel().getColumn(2).setMaxWidth(350);
            jTabelalProdutosEstoque.getColumnModel().getColumn(3).setMinWidth(60);
            jTabelalProdutosEstoque.getColumnModel().getColumn(3).setMaxWidth(60);
            jTabelalProdutosEstoque.getColumnModel().getColumn(4).setMinWidth(80);
            jTabelalProdutosEstoque.getColumnModel().getColumn(4).setMaxWidth(80);
            jTabelalProdutosEstoque.getColumnModel().getColumn(5).setMinWidth(90);
            jTabelalProdutosEstoque.getColumnModel().getColumn(5).setMaxWidth(90);
        }

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

        jtotalProdutos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalProdutos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalProdutos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
        );

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtSair)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtConfirmar, jBtSair});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtConfirmar)
                    .addComponent(jBtSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesquisaCodigoProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisaCodigoProdActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (jCodigoProdPesquisa.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o código do produto para pesquisa.");
        } else {
            preencherTabelaProdutos("SELECT * FROM PRODUTOS_AC "
                    + "INNER JOIN LOCAL_ARMAZENAMENTO_AC "
                    + "ON PRODUTOS_AC.IdLocal=LOCAL_ARMAZENAMENTO_AC.IdLocal "
                    + "INNER JOIN LOTE_PRODUTOS_AC "
                    + "ON PRODUTOS_AC.IdProd=LOTE_PRODUTOS_AC.IdProd "
                    + "WHERE PRODUTOS_AC.IdProd='" + jCodigoProdPesquisa.getText() + "' "
                    + "AND LOTE_PRODUTOS_AC.Qtd!='" + qtdEstoque + "' "
                    + "AND PRODUTOS_AC.StatusProd='" + statusProd + "' "
                    + "AND LOTE_PRODUTOS_AC.Modulo='" + modulo + "' "
                    + "AND PRODUTOS_AC.CompoeKit='" + compoeKit + "'");
        }
    }//GEN-LAST:event_jBtPesquisaCodigoProdActionPerformed

    private void jCodigoBarraPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCodigoBarraPesquisaActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        preencherTabelaProdutos("SELECT *FROM PRODUTOS_AC "
                + "INNER JOIN LOCAL_ARMAZENAMENTO_AC "
                + "ON PRODUTOS_AC.IdLocal=LOCAL_ARMAZENAMENTO_AC.IdLocal "
                + "INNER JOIN LOTE_PRODUTOS_AC "
                + "ON PRODUTOS_AC.IdProd=LOTE_PRODUTOS_AC.IdProd "
                + "WHERE LOTE_PRODUTOS_AC.Qtd!='" + qtdEstoque + "' "
                + "AND PRODUTOS_AC.StatusProd='" + statusProd + "' "
                + "AND LOTE_PRODUTOS_AC.Modulo='" + modulo + "' "
                + "AND PRODUTOS_AC.CodigoBarra='" + jCodigoBarraPesquisa + "' "
                + "AND PRODUTOS_AC.CompoeKit='" + compoeKit + "'");
    }//GEN-LAST:event_jCodigoBarraPesquisaActionPerformed

    private void jCheckBoxTodosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxTodosItemStateChanged
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherTabelaProdutos("SELECT * FROM PRODUTOS_AC "
                    + "INNER JOIN LOCAL_ARMAZENAMENTO_AC "
                    + "ON PRODUTOS_AC.IdLocal=LOCAL_ARMAZENAMENTO_AC.IdLocal "
                    + "INNER JOIN LOTE_PRODUTOS_AC "
                    + "ON PRODUTOS_AC.IdProd=LOTE_PRODUTOS_AC.IdProd "
                    + "WHERE LOTE_PRODUTOS_AC.Qtd!='" + qtdEstoque + "' "
                    + "AND PRODUTOS_AC.StatusProd='" + statusProd + "' "
                    + "AND LOTE_PRODUTOS_AC.Modulo='" + modulo + "' "
                    + "AND PRODUTOS_AC.CompoeKit='" + compoeKit + "'");
        } else {
            jtotalProdutos.setText("");
            limparTabelaProdutos();
        }
    }//GEN-LAST:event_jCheckBoxTodosItemStateChanged

    private void jBtPesquisaNomeProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisaNomeProdActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (jDescricapProdPesquisa.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o nome do produto para pesquisa.");
        } else {
            preencherTabelaProdutos("SELECT * FROM PRODUTOS_AC "
                    + "INNER JOIN LOCAL_ARMAZENAMENTO_AC "
                    + "ON PRODUTOS_AC.IdLocal=LOCAL_ARMAZENAMENTO_AC.IdLocal "
                    + "INNER JOIN LOTE_PRODUTOS_AC "
                    + "ON PRODUTOS_AC.IdProd=LOTE_PRODUTOS_AC.IdProd "
                    + "WHERE PRODUTOS_AC.DescricaoProd LIKE'%" + jDescricapProdPesquisa.getText() + "%' "
                    + "AND LOTE_PRODUTOS_AC.Qtd!='" + qtdEstoque + "' "
                    + "AND PRODUTOS_AC.StatusProd='" + statusProd + "' "
                    + "AND LOTE_PRODUTOS_AC.Modulo='" + modulo + "' "
                    + "AND PRODUTOS_AC.CompoeKit='" + compoeKit + "'");
        }
    }//GEN-LAST:event_jBtPesquisaNomeProdActionPerformed

    private void jTabelalProdutosEstoqueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelalProdutosEstoqueMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            nomeProduto = "" + jTabelalProdutosEstoque.getValueAt(jTabelalProdutosEstoque.getSelectedRow(), 2);
            jDescricapProdPesquisa.setText(nomeProduto);
            idProd = "" + jTabelalProdutosEstoque.getValueAt(jTabelalProdutosEstoque.getSelectedRow(), 0);
            jCodigoProdPesquisa.setText(idProd);
        }
    }//GEN-LAST:event_jTabelalProdutosEstoqueMouseClicked

    private void jBtConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtConfirmarActionPerformed
        // TODO add your handling code here:
        flag = 1;
        DecimalFormat qtdReal = new DecimalFormat("###,##00.0");
        qtdReal.setCurrency(Currency.getInstance(new Locale("pt", "BR")));
        flag = 1;
        if (jDescricapProdPesquisa.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Selecione o nome do interno e clique no botão CONFIRMAR");
        } else {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM PRODUTOS_AC "
                        + "INNER JOIN LOCAL_ARMAZENAMENTO_AC "
                        + "ON PRODUTOS_AC.IdLocal=LOCAL_ARMAZENAMENTO_AC.IdLocal "
                        + "INNER JOIN LOTE_PRODUTOS_AC "
                        + "ON PRODUTOS_AC.IdProd=LOTE_PRODUTOS_AC.IdProd "
                        + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                        + "ON PRODUTOS_AC.IdProd=PRODUTOS_KITS_HIGIENE_INTERNO.IdProd "
                        + "WHERE PRODUTOS_AC.IdProd='" + idProd + "'");
                conecta.rs.first();
                jCodigoProd.setText(String.valueOf(conecta.rs.getInt("IdProd")));
                jDescricaoProd.setText(conecta.rs.getString("DescricaoProd"));
                jUnidadeProd.setText(conecta.rs.getString("UnidadeProd"));
                idKit = conecta.rs.getInt("IdKit");
                // Formata o valor para ser exibido na tela no formato BR                                                   
                qtdEstoque = conecta.rs.getFloat("Qtd");
                DecimalFormat vu = new DecimalFormat(",###0.00");
                String qEstoque = vu.format(qtdEstoque);
                jQuantidadeProdEstoque.setText(qEstoque);
                //
                qdtKit = conecta.rs.getFloat("QuantItem");
                DecimalFormat qk = new DecimalFormat("###,###0.00");
                String qKit = qk.format(qdtKit);
                jQuantidadeKit.setText(qKit);
                jQuantidadeInternos.setText(jtotalInternosSelecionados.getText());
                conecta.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa do produto" + e);
            }
            dispose();
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
            java.util.logging.Logger.getLogger(TelaEstoqueProdutosKit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEstoqueProdutosKit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEstoqueProdutosKit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEstoqueProdutosKit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaEstoqueProdutosKit dialog = new TelaEstoqueProdutosKit(montaKitProd, true);
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
    private javax.swing.JButton jBtConfirmar;
    private javax.swing.JButton jBtPesquisaCodigoProd;
    private javax.swing.JButton jBtPesquisaNomeProd;
    private javax.swing.JButton jBtSair;
    private javax.swing.JCheckBox jCheckBoxTodos;
    private javax.swing.JTextField jCodigoBarraPesquisa;
    private javax.swing.JTextField jCodigoProdPesquisa;
    private javax.swing.JTextField jDescricapProdPesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabelalProdutosEstoque;
    public static javax.swing.JLabel jtotalProdutos;
    // End of variables declaration//GEN-END:variables

    public void preencherTabelaProdutos(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Código Barra", "Descrição Produto", "Un.", "Qtd.Estoque", "Lote"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            count = 0;
            do {
                count = count + 1;
                qtdItem = conecta.rs.getFloat("Qtd");
                DecimalFormat vi = new DecimalFormat(",###0.00");
                String vqtdItem = vi.format(qtdItem);
                qtdItemTab = vqtdItem;
                //
                jtotalProdutos.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela 
                dados.add(new Object[]{conecta.rs.getInt("IdProd"), conecta.rs.getString("CodigoBarra"), conecta.rs.getString("DescricaoProd"), conecta.rs.getString("UnidadeProd"), qtdItemTab, conecta.rs.getString("Lote")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelalProdutosEstoque.setModel(modelo);
        jTabelalProdutosEstoque.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelalProdutosEstoque.getColumnModel().getColumn(0).setResizable(false);
        jTabelalProdutosEstoque.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTabelalProdutosEstoque.getColumnModel().getColumn(1).setResizable(false);
        jTabelalProdutosEstoque.getColumnModel().getColumn(2).setPreferredWidth(350);
        jTabelalProdutosEstoque.getColumnModel().getColumn(2).setResizable(false);
        jTabelalProdutosEstoque.getColumnModel().getColumn(3).setPreferredWidth(60);
        jTabelalProdutosEstoque.getColumnModel().getColumn(3).setResizable(false);
        jTabelalProdutosEstoque.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTabelalProdutosEstoque.getColumnModel().getColumn(4).setResizable(false);
        jTabelalProdutosEstoque.getColumnModel().getColumn(4).setPreferredWidth(90);
        jTabelalProdutosEstoque.getColumnModel().getColumn(4).setResizable(false);
        jTabelalProdutosEstoque.getTableHeader().setReorderingAllowed(false);
        jTabelalProdutosEstoque.setAutoResizeMode(jTabelalProdutosEstoque.AUTO_RESIZE_OFF);
        jTabelalProdutosEstoque.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaProdutos();
        conecta.desconecta();
    }

    public void limparTabelaProdutos() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Código Barra", "Descrição Produto", "Un.", "Qtd.Estoque", "Lote"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelalProdutosEstoque.setModel(modelo);
        jTabelalProdutosEstoque.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelalProdutosEstoque.getColumnModel().getColumn(0).setResizable(false);
        jTabelalProdutosEstoque.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTabelalProdutosEstoque.getColumnModel().getColumn(1).setResizable(false);
        jTabelalProdutosEstoque.getColumnModel().getColumn(2).setPreferredWidth(350);
        jTabelalProdutosEstoque.getColumnModel().getColumn(2).setResizable(false);
        jTabelalProdutosEstoque.getColumnModel().getColumn(3).setPreferredWidth(60);
        jTabelalProdutosEstoque.getColumnModel().getColumn(3).setResizable(false);
        jTabelalProdutosEstoque.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTabelalProdutosEstoque.getColumnModel().getColumn(4).setResizable(false);
        jTabelalProdutosEstoque.getColumnModel().getColumn(4).setPreferredWidth(90);
        jTabelalProdutosEstoque.getColumnModel().getColumn(4).setResizable(false);
        jTabelalProdutosEstoque.getTableHeader().setReorderingAllowed(false);
        jTabelalProdutosEstoque.setAutoResizeMode(jTabelalProdutosEstoque.AUTO_RESIZE_OFF);
        jTabelalProdutosEstoque.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabelaProdutos() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelalProdutosEstoque.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelalProdutosEstoque.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelalProdutosEstoque.getColumnModel().getColumn(3).setCellRenderer(direita);
        jTabelalProdutosEstoque.getColumnModel().getColumn(4).setCellRenderer(direita);
        jTabelalProdutosEstoque.getColumnModel().getColumn(5).setCellRenderer(direita);
    }

}
