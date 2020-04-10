/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Dao.ConexaoBancoDados;
import Utilitarios.ModeloTabela;
import static gestor.Visao.TelaEntradaProdutosAC.jDescricaoProduto;
import static gestor.Visao.TelaEntradaProdutosAC.jIdProd;
import static gestor.Visao.TelaEntradaProdutosAC.jCodigoBarras;
import static gestor.Visao.TelaEntradaProdutosAC.jReferencia;
import static gestor.Visao.TelaEntradaProdutosAC.jUnidade;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author user
 */
public class TelaPesqProdutoComprasAC extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    int flag;
    String statusProd = "Ativo";
    String idInt;
    String modulo = "A";

    /**
     * Creates new form TelaPesqProdutoFarmacia
     */
    public TelaPesqProdutoComprasAC() {
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPesqDescricaoProdutos = new javax.swing.JTextField();
        jBtPesqDescricaoProd = new javax.swing.JButton();
        jCheckBoxPesqTodosProd = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jCodigo = new javax.swing.JTextField();
        jBtPesqCodigo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaProdutos = new javax.swing.JTable();
        jBtEnviar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();

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
        setTitle("...::: Listagem de Produtos {AC} :::...");

        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 255));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Descrição:");

        jPesqDescricaoProdutos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqDescricaoProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqDescricaoProd.setContentAreaFilled(false);
        jBtPesqDescricaoProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqDescricaoProdActionPerformed(evt);
            }
        });

        jCheckBoxPesqTodosProd.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxPesqTodosProd.setText("Todos");
        jCheckBoxPesqTodosProd.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxPesqTodosProdItemStateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Código:");

        jCodigo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodigo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqCodigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqCodigo.setContentAreaFilled(false);
        jBtPesqCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqCodigoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPesqDescricaoProdutos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqDescricaoProd, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBoxPesqTodosProd)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCheckBoxPesqTodosProd)
                        .addComponent(jLabel2)
                        .addComponent(jCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBtPesqCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPesqDescricaoProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jBtPesqDescricaoProd))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaProdutos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Código", "Descrição Produto", "Local de Armazenamento"
            }
        ));
        jTabelaProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaProdutosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaProdutos);
        if (jTabelaProdutos.getColumnModel().getColumnCount() > 0) {
            jTabelaProdutos.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaProdutos.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaProdutos.getColumnModel().getColumn(1).setMinWidth(250);
            jTabelaProdutos.getColumnModel().getColumn(1).setMaxWidth(250);
            jTabelaProdutos.getColumnModel().getColumn(2).setMinWidth(210);
            jTabelaProdutos.getColumnModel().getColumn(2).setMaxWidth(210);
        }

        jBtEnviar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtEnviar.setForeground(new java.awt.Color(0, 0, 255));
        jBtEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/accept.png"))); // NOI18N
        jBtEnviar.setText("Enviar");
        jBtEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtEnviarActionPerformed(evt);
            }
        });

        jBtSair.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtSair.setForeground(new java.awt.Color(255, 0, 0));
        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSair.setText("Sair");
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jBtEnviar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSair)
                        .addGap(0, 317, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtEnviar)
                    .addComponent(jBtSair))
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("Pesquisas", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
        );

        setBounds(300, 10, 526, 326);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesqDescricaoProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqDescricaoProdActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (jPesqDescricaoProdutos.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe uma descrição do produto para pesquisa.");
        } else {
            preencherTabelaProdutos("SELECT * FROM PRODUTOS_AC "
                    + "INNER JOIN LOCAL_ARMAZENAMENTO_AC "
                    + "ON PRODUTOS_AC.IdLocal=LOCAL_ARMAZENAMENTO_AC.IdLocal "
                    + "INNER JOIN LOTE_PRODUTOS_AC "
                    + "ON PRODUTOS_AC.IdProd=LOTE_PRODUTOS_AC.IdProd "
                    + "WHERE DescricaoProd LIKE'%" + jPesqDescricaoProdutos.getText() + "%' "
                    + "AND StatusProd='" + statusProd + "' "
                    + "AND PRODUTOS_AC.Modulo='" + modulo + "'");
        }
    }//GEN-LAST:event_jBtPesqDescricaoProdActionPerformed

    private void jBtEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtEnviarActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (jPesqDescricaoProdutos.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Selecione o nome do interno e clique no botão ENVIAR");
        } else {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM PRODUTOS_AC "
                        + "INNER JOIN LOCAL_ARMAZENAMENTO_AC "
                        + "ON PRODUTOS_AC.IdLocal=LOCAL_ARMAZENAMENTO_AC.IdLocal "
                        + "INNER JOIN LOTE_PRODUTOS_AC "
                        + "ON PRODUTOS_AC.IdProd=LOTE_PRODUTOS_AC.IdProd "
                        + "WHERE PRODUTOS_AC.DescricaoProd='" + jPesqDescricaoProdutos.getText() + "' "
                        + "AND PRODUTOS_AC.StatusProd='" + statusProd + "' "
                        + "AND PRODUTOS_AC.IdProd='" + idInt + "' "
                        + "AND PRODUTOS_AC.Modulo='" + modulo + "'");
                conecta.rs.first();
                jIdProd.setText(String.valueOf(conecta.rs.getInt("IdProd")));
                jCodigoBarras.setText(conecta.rs.getString("CodigoBarra"));
                jReferencia.setText(conecta.rs.getString("ReferenciaProd"));
                //   jLote.setText(conecta.rs.getString("Lote"));
                jDescricaoProduto.setText(conecta.rs.getString("DescricaoProd"));
                jUnidade.setText(conecta.rs.getString("UnidadeProd"));
                conecta.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa do produto" + e);
            }
            dispose();
        }
    }//GEN-LAST:event_jBtEnviarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jTabelaProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaProdutosMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String nomeProduto = "" + jTabelaProdutos.getValueAt(jTabelaProdutos.getSelectedRow(), 1);
            jPesqDescricaoProdutos.setText(nomeProduto);
            idInt = "" + jTabelaProdutos.getValueAt(jTabelaProdutos.getSelectedRow(), 0);
        }
    }//GEN-LAST:event_jTabelaProdutosMouseClicked

    private void jCheckBoxPesqTodosProdItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxPesqTodosProdItemStateChanged
        // TODO add your handling code here:
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherTabelaProdutos("SELECT * FROM PRODUTOS_AC "
                    + "INNER JOIN LOCAL_ARMAZENAMENTO_AC "
                    + "ON PRODUTOS_AC.IdLocal=LOCAL_ARMAZENAMENTO_AC.IdLocal "
                    + "INNER JOIN LOTE_PRODUTOS_AC "
                    + "ON PRODUTOS_AC.IdProd=LOTE_PRODUTOS_AC.IdProd "
                    + "WHERE StatusProd='" + statusProd + "' "
                    + "AND PRODUTOS_AC.Modulo='" + modulo + "'ORDER BY PRODUTOS_AC.DescricaoProd");
        } else {
            limparTabelaPrdoutos();
        }
    }//GEN-LAST:event_jCheckBoxPesqTodosProdItemStateChanged

    private void jBtPesqCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqCodigoActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (jCodigo.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um código do produto para pesquisa.");
        } else {
            preencherTabelaProdutos("SELECT * FROM PRODUTOS_AC "
                    + "INNER JOIN LOCAL_ARMAZENAMENTO_AC "
                    + "ON PRODUTOS_AC.IdLocal=LOCAL_ARMAZENAMENTO_AC.IdLocal "
                    + "INNER JOIN LOTE_PRODUTOS_AC "
                    + "ON PRODUTOS_AC.IdProd=LOTE_PRODUTOS_AC.IdProd "
                    + "WHERE PRODUTOS_AC.IdProd='" + jCodigo.getText() + "' "
                    + "AND StatusProd='" + statusProd + "' "
                    + "AND PRODUTOS_AC.Modulo='" + modulo + "'");
        }
    }//GEN-LAST:event_jBtPesqCodigoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtEnviar;
    private javax.swing.JButton jBtPesqCodigo;
    private javax.swing.JButton jBtPesqDescricaoProd;
    private javax.swing.JButton jBtSair;
    private javax.swing.JCheckBox jCheckBoxPesqTodosProd;
    private javax.swing.JTextField jCodigo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jPesqDescricaoProdutos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTabelaProdutos;
    // End of variables declaration//GEN-END:variables

    // Método de pesquisa pela Matricula
    public void preencherTabelaProdutos(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Descrição Produto", "Local de Armazenamento"};
        conecta.abrirConexao();
        conecta.executaSQL(sql);
        try {
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdProd"), conecta.rs.getString("DescricaoProd"), conecta.rs.getString("DescricaoLocal")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Dados não encontrado, use o botão TODOS \nPara pesquisar TODOS OS REGISTROS");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaProdutos.setModel(modelo);
        jTabelaProdutos.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaProdutos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaProdutos.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTabelaProdutos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaProdutos.getColumnModel().getColumn(2).setPreferredWidth(210);
        jTabelaProdutos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaProdutos.getTableHeader().setReorderingAllowed(false);
        jTabelaProdutos.setAutoResizeMode(jTabelaProdutos.AUTO_RESIZE_OFF);
        jTabelaProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaProdutos();
        conecta.desconecta();
    }

    public void alinharCamposTabelaProdutos() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaProdutos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
    }

    public void limparTabelaPrdoutos() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Descrição Produto", "Local de Armazenamento"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaProdutos.setModel(modelo);
        jTabelaProdutos.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaProdutos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaProdutos.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTabelaProdutos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaProdutos.getColumnModel().getColumn(2).setPreferredWidth(210);
        jTabelaProdutos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaProdutos.getTableHeader().setReorderingAllowed(false);
        jTabelaProdutos.setAutoResizeMode(jTabelaProdutos.AUTO_RESIZE_OFF);
        jTabelaProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }
}
