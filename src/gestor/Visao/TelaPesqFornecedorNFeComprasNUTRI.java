/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Dao.ConexaoBancoDados;
import Utilitarios.ModeloTabela;
import static gestor.Visao.TelaEntradaProdutosNUTRI.jDescricaoFornecedor;
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
public class TelaPesqFornecedorNFeComprasNUTRI extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    int flag;
    String statusLocal = "Ativo";
    String modulo = "N";

    /**
     * Creates new form TelaPesqGrupoProdMed
     */
    public TelaPesqFornecedorNFeComprasNUTRI() {
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPesqNomeFornecedor = new javax.swing.JTextField();
        jBtPesqDescricao = new javax.swing.JButton();
        jCheckBoxTodosLocais = new javax.swing.JCheckBox();
        jBtEnviar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaFornecedores = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("...::: Listagem de Fornecedores {NUTRI} :::...");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Razão Social:");

        jPesqNomeFornecedor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqDescricao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqDescricao.setContentAreaFilled(false);
        jBtPesqDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqDescricaoActionPerformed(evt);
            }
        });

        jCheckBoxTodosLocais.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxTodosLocais.setText("Todos");
        jCheckBoxTodosLocais.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxTodosLocaisItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPesqNomeFornecedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtPesqDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxTodosLocais)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPesqNomeFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jBtPesqDescricao)
                    .addComponent(jCheckBoxTodosLocais))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        jTabelaFornecedores.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaFornecedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Código", "Status", "Nome do Fornecedor"
            }
        ));
        jTabelaFornecedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaFornecedoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaFornecedores);
        if (jTabelaFornecedores.getColumnModel().getColumnCount() > 0) {
            jTabelaFornecedores.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaFornecedores.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaFornecedores.getColumnModel().getColumn(1).setMinWidth(80);
            jTabelaFornecedores.getColumnModel().getColumn(1).setMaxWidth(80);
            jTabelaFornecedores.getColumnModel().getColumn(2).setMinWidth(380);
            jTabelaFornecedores.getColumnModel().getColumn(2).setMaxWidth(380);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBtEnviar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSair)
                        .addGap(268, 280, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtEnviar)
                    .addComponent(jBtSair)))
        );

        jTabbedPane1.addTab("Pesquisar", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
        );

        setBounds(300, 20, 479, 280);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesqDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqDescricaoActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (jPesqNomeFornecedor.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe uma descrição ou parte dela para pesquisar.");
        } else {
            preencherTabelaLocais("SELECT * FROM FORNECEDORES_AC WHERE RazaoSocial LIKE'%" + jPesqNomeFornecedor.getText() + "%' AND StatusFor='" + statusLocal + "'Modulo='" + modulo + "'");
        }
    }//GEN-LAST:event_jBtPesqDescricaoActionPerformed

    private void jBtEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtEnviarActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String nomeFornecedor = "" + jTabelaFornecedores.getValueAt(jTabelaFornecedores.getSelectedRow(), 2);
            jPesqNomeFornecedor.setText(nomeFornecedor);
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM FORNECEDORES_AC WHERE RazaoSocial='" + jPesqNomeFornecedor.getText() + "'");
                conecta.rs.first();
                jDescricaoFornecedor.setText(conecta.rs.getString("RazaoSocial"));
                conecta.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa por nome" + e);
            }
            dispose();
        }
    }//GEN-LAST:event_jBtEnviarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jTabelaFornecedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaFornecedoresMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            String nomeLocal = "" + jTabelaFornecedores.getValueAt(jTabelaFornecedores.getSelectedRow(), 2);
            jPesqNomeFornecedor.setText(nomeLocal);
        }
    }//GEN-LAST:event_jTabelaFornecedoresMouseClicked

    private void jCheckBoxTodosLocaisItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxTodosLocaisItemStateChanged
        // TODO add your handling code here:
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherTabelaLocais("SELECT * FROM FORNECEDORES_AC WHERE StatusFor='" + statusLocal + "'AND Modulo='" + modulo + "'");
        } else {
            limparTabela();
        }
    }//GEN-LAST:event_jCheckBoxTodosLocaisItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtEnviar;
    private javax.swing.JButton jBtPesqDescricao;
    private javax.swing.JButton jBtSair;
    private javax.swing.JCheckBox jCheckBoxTodosLocais;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jPesqNomeFornecedor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTabelaFornecedores;
    // End of variables declaration//GEN-END:variables

    public void preencherTabelaLocais(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Status", "Nome do Fornecedor"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdForn"), conecta.rs.getString("StatusFor"), conecta.rs.getString("RazaoSocial")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Dados não encontrado...");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaFornecedores.setModel(modelo);
        jTabelaFornecedores.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaFornecedores.getColumnModel().getColumn(0).setResizable(false);
        jTabelaFornecedores.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaFornecedores.getColumnModel().getColumn(1).setResizable(false);
        jTabelaFornecedores.getColumnModel().getColumn(2).setPreferredWidth(380);
        jTabelaFornecedores.getColumnModel().getColumn(2).setResizable(false);
        jTabelaFornecedores.getTableHeader().setReorderingAllowed(false);
        jTabelaFornecedores.setAutoResizeMode(jTabelaFornecedores.AUTO_RESIZE_OFF);
        jTabelaFornecedores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabela();
        conecta.desconecta();
    }

    public void limparTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Status", "Nome do Fornecedor"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaFornecedores.setModel(modelo);
        jTabelaFornecedores.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaFornecedores.getColumnModel().getColumn(0).setResizable(false);
        jTabelaFornecedores.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaFornecedores.getColumnModel().getColumn(1).setResizable(false);
        jTabelaFornecedores.getColumnModel().getColumn(2).setPreferredWidth(380);
        jTabelaFornecedores.getColumnModel().getColumn(2).setResizable(false);
        jTabelaFornecedores.getTableHeader().setReorderingAllowed(false);
        jTabelaFornecedores.setAutoResizeMode(jTabelaFornecedores.AUTO_RESIZE_OFF);
        jTabelaFornecedores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabela() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        //
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaFornecedores.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaFornecedores.getColumnModel().getColumn(1).setCellRenderer(centralizado);
    }
}
