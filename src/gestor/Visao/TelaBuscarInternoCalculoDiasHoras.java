/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Dao.ConexaoBancoDados;
import Utilitarios.ModeloTabela;
import static gestor.Visao.TelaFrequenciaMensalInternosEducacao.jIdInternoCrcDemo;
import static gestor.Visao.TelaFrequenciaMensalInternosEducacao.jNomeInternoCrcDemo;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ronaldo
 */
public class TelaBuscarInternoCalculoDiasHoras extends javax.swing.JDialog {

    ConexaoBancoDados conecta = new ConexaoBancoDados();

    int flag;
    public static TelaFrequenciaMensalInternosEducacao frequenciaEducacao;

    /**
     * Creates new form TelaBuscarInternoCalculoDias
     */
    public TelaBuscarInternoCalculoDiasHoras(TelaFrequenciaMensalInternosEducacao parent, boolean modal) {
        this.frequenciaEducacao = parent;
        this.setModal(modal);
        setLocationRelativeTo(frequenciaEducacao);
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
        jNomeInternoDias = new javax.swing.JTextField();
        jBtPesqNomeInterno = new javax.swing.JButton();
        jCheckBoxTodos = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaInternos = new javax.swing.JTable();
        jBtSelecionar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("...::: Pesquisar Internos :::...");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Nome Interno:");

        jNomeInternoDias.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqNomeInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqNomeInterno.setToolTipText("Pesquisar Internos");
        jBtPesqNomeInterno.setContentAreaFilled(false);
        jBtPesqNomeInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqNomeInternoActionPerformed(evt);
            }
        });

        jCheckBoxTodos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxTodos.setText("Todos");
        jCheckBoxTodos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxTodosItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNomeInternoDias, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxTodos)
                .addContainerGap(9, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jCheckBoxTodos)
                    .addComponent(jBtPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNomeInternoDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaInternos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaInternos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Código", "Nome do Interno", "Total Dias"
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
            jTabelaInternos.getColumnModel().getColumn(1).setMinWidth(350);
            jTabelaInternos.getColumnModel().getColumn(1).setMaxWidth(350);
            jTabelaInternos.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaInternos.getColumnModel().getColumn(2).setMaxWidth(80);
        }

        jBtSelecionar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtSelecionar.setForeground(new java.awt.Color(0, 153, 0));
        jBtSelecionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/accept.png"))); // NOI18N
        jBtSelecionar.setText("Selecionar");
        jBtSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSelecionarActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jBtSelecionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSair))
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtSair, jBtSelecionar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtSelecionar)
                    .addComponent(jBtSair))
                .addGap(6, 6, 6))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtSair, jBtSelecionar});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesqNomeInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNomeInternoActionPerformed
        // TODO add your handling code here:
        if (jNomeInternoDias.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o nome do interno para pesquisa.");
        } else {
            preencherTabelaInternosdDemo("SELECT * FROM FREQUENCIA_PEDAGOGIA_EXTERNA "
                    + "INNER JOIN ITENS_FREQUENCIA_PEDAGOGIA_EXTERNA "
                    + "ON FREQUENCIA_PEDAGOGIA_EXTERNA.IdFreqLab=ITENS_FREQUENCIA_PEDAGOGIA_EXTERNA.IdFreqLab "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENS_FREQUENCIA_PEDAGOGIA_EXTERNA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE PRONTUARIOSCRC.NomeInternoCrc LIKE'%" + jNomeInternoDias.getText() + "%'");
        }
    }//GEN-LAST:event_jBtPesqNomeInternoActionPerformed

    private void jCheckBoxTodosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxTodosItemStateChanged
        // TODO add your handling code here:
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherTabelaInternosdDemo("SELECT * FROM FREQUENCIA_PEDAGOGIA_EXTERNA "
                    + "INNER JOIN ITENS_FREQUENCIA_PEDAGOGIA_EXTERNA "
                    + "ON FREQUENCIA_PEDAGOGIA_EXTERNA.IdFreqLab=ITENS_FREQUENCIA_PEDAGOGIA_EXTERNA.IdFreqLab "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENS_FREQUENCIA_PEDAGOGIA_EXTERNA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc ");
        } else {
            limparTabela();
        }
    }//GEN-LAST:event_jCheckBoxTodosItemStateChanged

    private void jTabelaInternosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaInternosMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1 && evt.getClickCount() == 1) {
            String nomeInterno = "" + jTabelaInternos.getValueAt(jTabelaInternos.getSelectedRow(), 1);
            jNomeInternoDias.setText(nomeInterno);
        }
    }//GEN-LAST:event_jTabelaInternosMouseClicked

    private void jBtSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSelecionarActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String codInterno = "" + jTabelaInternos.getValueAt(jTabelaInternos.getSelectedRow(), 0);
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM FREQUENCIA_PEDAGOGIA_EXTERNA "
                        + "INNER JOIN ITENS_FREQUENCIA_PEDAGOGIA_EXTERNA "
                        + "ON FREQUENCIA_EDUCATIVA_EXTERNA.IdFreqLab=ITENS_FREQUENCIA_PEDAGOGIA_EXTERNA.IdFreqLab "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ITENS_FREQUENCIA_PEDAGOGIA_EXTERNA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE PRONTUARIOSCRC.IdInternoCrc='" + codInterno + "'");
                conecta.rs.first();
                jIdInternoCrcDemo.setText(String.valueOf(conecta.rs.getInt("IdInternoCrc")));
                jNomeInternoCrcDemo.setText(conecta.rs.getString("NomeInternoCrc"));
                conecta.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa." + e);
            }
            dispose();
        }
    }//GEN-LAST:event_jBtSelecionarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaBuscarInternoCalculoDiasHoras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaBuscarInternoCalculoDiasHoras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaBuscarInternoCalculoDiasHoras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaBuscarInternoCalculoDiasHoras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaBuscarInternoCalculoDiasHoras dialog = new TelaBuscarInternoCalculoDiasHoras(frequenciaEducacao, true);
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
    private javax.swing.JButton jBtPesqNomeInterno;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSelecionar;
    private javax.swing.JCheckBox jCheckBoxTodos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jNomeInternoDias;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabelaInternos;
    // End of variables declaration//GEN-END:variables

    public void preencherTabelaInternosdDemo(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome do Interno", "Total Dias"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getString("IdInternoCrc"), conecta.rs.getString("NomeInternoCrc"), conecta.rs.getString("TotalDias")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInternos.setModel(modelo);
        jTabelaInternos.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaInternos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(1).setPreferredWidth(350);
        jTabelaInternos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(2).setPreferredWidth(70);
        jTabelaInternos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInternos.setAutoResizeMode(jTabelaInternos.AUTO_RESIZE_OFF);
        jTabelaInternos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCampoTabelaItens();
        conecta.desconecta();
    }

    public void limparTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome do Interno", "Total Dias"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInternos.setModel(modelo);
        jTabelaInternos.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaInternos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(1).setPreferredWidth(350);
        jTabelaInternos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(2).setPreferredWidth(70);
        jTabelaInternos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInternos.setAutoResizeMode(jTabelaInternos.AUTO_RESIZE_OFF);
        jTabelaInternos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCampoTabelaItens() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaInternos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaInternos.getColumnModel().getColumn(2).setCellRenderer(direita);
    }
}
