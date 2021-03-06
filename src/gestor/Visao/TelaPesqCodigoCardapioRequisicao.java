/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Dao.ConexaoBancoDados;
import Utilitarios.ModeloTabela;
import static gestor.Visao.TelaRequisicaoMateriaisCardapioNUTRI.jCodigoCardapio;
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
public class TelaPesqCodigoCardapioRequisicao extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    int flag;

    /**
     * Creates new form TelaPesqProdutoFarmacia
     */
    public TelaPesqCodigoCardapioRequisicao() {
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
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jIdCardapio = new javax.swing.JTextField();
        jBtPesqCodigoCardapio = new javax.swing.JButton();
        jCheckBoxPesqTodosProd = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaCardapio = new javax.swing.JTable();
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
        setTitle("...::: Listagem de Cardápio {NUTRI} :::...");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Código:");

        jIdCardapio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqCodigoCardapio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqCodigoCardapio.setContentAreaFilled(false);
        jBtPesqCodigoCardapio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqCodigoCardapioActionPerformed(evt);
            }
        });

        jCheckBoxPesqTodosProd.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxPesqTodosProd.setText("Todos");
        jCheckBoxPesqTodosProd.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxPesqTodosProdItemStateChanged(evt);
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
                .addComponent(jIdCardapio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtPesqCodigoCardapio, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                .addComponent(jCheckBoxPesqTodosProd)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jCheckBoxPesqTodosProd)
                    .addComponent(jBtPesqCodigoCardapio)
                    .addComponent(jIdCardapio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaCardapio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaCardapio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Código", "Descrição da Ficha"
            }
        ));
        jTabelaCardapio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaCardapioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaCardapio);
        if (jTabelaCardapio.getColumnModel().getColumnCount() > 0) {
            jTabelaCardapio.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaCardapio.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaCardapio.getColumnModel().getColumn(1).setMinWidth(290);
            jTabelaCardapio.getColumnModel().getColumn(1).setMaxWidth(290);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtEnviar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSair)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtEnviar)
                    .addComponent(jBtSair))
                .addGap(30, 30, 30))
        );

        setBounds(300, 10, 397, 253);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesqCodigoCardapioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqCodigoCardapioActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (jIdCardapio.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe uma descrição do produto para pesquisa.");
        } else {
            preencherTabelaProdutos("SELECT * FROM FICHA_TECNICA_NUTRI WHERE IdFicha='" + jIdCardapio.getText() + "'");
        }
    }//GEN-LAST:event_jBtPesqCodigoCardapioActionPerformed

    private void jBtEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtEnviarActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (jIdCardapio.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Selecione o nome do interno e clique no botão ENVIAR");
        } else {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM FICHA_TECNICA_NUTRI WHERE IdFicha='" + jIdCardapio.getText() + "'");
                conecta.rs.first();
                jCodigoCardapio.setText(String.valueOf(conecta.rs.getInt("IdFicha")));
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

    private void jTabelaCardapioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaCardapioMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String idCardapio = "" + jTabelaCardapio.getValueAt(jTabelaCardapio.getSelectedRow(), 0);
            jIdCardapio.setText(idCardapio);
        }
    }//GEN-LAST:event_jTabelaCardapioMouseClicked

    private void jCheckBoxPesqTodosProdItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxPesqTodosProdItemStateChanged
        // TODO add your handling code here:
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherTabelaProdutos("SELECT * FROM FICHA_TECNICA_NUTRI");
        } else {
            limparTabela();
        }
    }//GEN-LAST:event_jCheckBoxPesqTodosProdItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtEnviar;
    private javax.swing.JButton jBtPesqCodigoCardapio;
    private javax.swing.JButton jBtSair;
    private javax.swing.JCheckBox jCheckBoxPesqTodosProd;
    private javax.swing.JTextField jIdCardapio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabelaCardapio;
    // End of variables declaration//GEN-END:variables

    public void preencherTabelaProdutos(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Descrição da Ficha"};
        conecta.abrirConexao();
        conecta.executaSQL(sql);
        try {
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdFicha"), conecta.rs.getString("DescricaoFicha")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Dados não encontrado, use o botão TODOS \nPara pesquisar TODOS OS REGISTROS");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaCardapio.setModel(modelo);
        jTabelaCardapio.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaCardapio.getColumnModel().getColumn(0).setResizable(false);
        jTabelaCardapio.getColumnModel().getColumn(1).setPreferredWidth(290);
        jTabelaCardapio.getColumnModel().getColumn(1).setResizable(false);
        jTabelaCardapio.getTableHeader().setReorderingAllowed(false);
        jTabelaCardapio.setAutoResizeMode(jTabelaCardapio.AUTO_RESIZE_OFF);
        jTabelaCardapio.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabela();
        conecta.desconecta();
    }

    public void limparTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Descrição da Ficha"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaCardapio.setModel(modelo);
        jTabelaCardapio.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaCardapio.getColumnModel().getColumn(0).setResizable(false);
        jTabelaCardapio.getColumnModel().getColumn(1).setPreferredWidth(290);
        jTabelaCardapio.getColumnModel().getColumn(1).setResizable(false);
        jTabelaCardapio.getTableHeader().setReorderingAllowed(false);
        jTabelaCardapio.setAutoResizeMode(jTabelaCardapio.AUTO_RESIZE_OFF);
        jTabelaCardapio.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
        jTabelaCardapio.getColumnModel().getColumn(0).setCellRenderer(centralizado);
    }
}
