/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControleSelecaoKitsCompleto;
import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.GravarInternosKitCompleto;
import gestor.Modelo.LogSistema;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jTabelaInternosKitCompleto;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jtotalInternosKitCompleto;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.qtdInternos;
import static gestor.Visao.TelaSelecaoInternosKitCompleto.jTabelaSelecaoInternosKit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ronal
 */
public class TelaSelecaoInternosKitCompleto extends javax.swing.JDialog {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ControleSelecaoKitsCompleto controle = new ControleSelecaoKitsCompleto();
    GravarInternosKitCompleto objGravaIntComp = new GravarInternosKitCompleto();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log   
    String nomeModuloTela2 = "Almoxarifado:Montagem de Pagamento do Kit de Interno:Seleção Completa de Internos";
    //    
    int idRegPavInt = 0;
    int codigoPavilhao = 0;
    String statusMov = "";
    String horaMov = "";
    String dataModFinal = "";

    public static boolean opcao = !true;
    int todos = 0;
    int flag = 0;
    String idInterno;
    String nomeInterno;
    String col;
    Boolean checked;

    /**
     * Creates new form TelaSelecaoInternosKitCompleto
     */
    public static TelaMontagemPagamentoKitInterno montaKitSelec;
//    public static TelaThreadSelecaoInternosKitCompleto threadComp;

    public TelaSelecaoInternosKitCompleto(TelaMontagemPagamentoKitInterno parent, boolean modal) {
        this.montaKitSelec = parent;
        this.setModal(modal);
        setLocationRelativeTo(montaKitSelec);
        initComponents();
        mostraSelecaoInternos();
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
        jPanel42 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        jPanel43 = new javax.swing.JPanel();
        jtotalInternosSelecionados = new javax.swing.JLabel();
        jPanel44 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTabelaSelecaoInternosKit = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jBtExportarTodosInternos = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jBtExportarSelecionados = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("....::: Seleção de Internos para Kit :::...");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jPanel42.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jLabel71.setText("Total de Registros:");

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel71))
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel71)
        );

        jPanel43.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jtotalInternosSelecionados.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalInternosSelecionados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalInternosSelecionados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
        );

        jPanel44.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        jTabelaSelecaoInternosKit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaSelecaoInternosKit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome do Interno"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabelaSelecaoInternosKit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaSelecaoInternosKitMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTabelaSelecaoInternosKit);
        if (jTabelaSelecaoInternosKit.getColumnModel().getColumnCount() > 0) {
            jTabelaSelecaoInternosKit.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaSelecaoInternosKit.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaSelecaoInternosKit.getColumnModel().getColumn(1).setMinWidth(300);
            jTabelaSelecaoInternosKit.getColumnModel().getColumn(1).setMaxWidth(300);
        }

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jBtExportarTodosInternos.setForeground(new java.awt.Color(0, 102, 0));
        jBtExportarTodosInternos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/250718131210_16.png"))); // NOI18N
        jBtExportarTodosInternos.setToolTipText("Exporta todos os registros de uma única vez.");
        jBtExportarTodosInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExportarTodosInternosActionPerformed(evt);
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

        jBtExportarSelecionados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/250718131526_16.png"))); // NOI18N
        jBtExportarSelecionados.setToolTipText("Selecione um ou vários registros a ser exportado (s).");
        jBtExportarSelecionados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExportarSelecionadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jBtExportarTodosInternos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExportarSelecionados, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSair)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtExportarSelecionados, jBtExportarTodosInternos, jBtSair});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBtSair)
                    .addComponent(jBtExportarSelecionados)
                    .addComponent(jBtExportarTodosInternos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtExportarTodosInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExportarTodosInternosActionPerformed
        // TODO add your handling code here:
        Integer rows = jTabelaInternosKitCompleto.getRowCount();
        if (rows == 0) {
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente confirmar essa operação?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                // APAGAR DADOS DA TABELA
                while (jTabelaSelecaoInternosKit.getModel().getRowCount() > 0) {
                    ((DefaultTableModel) jTabelaSelecaoInternosKit.getModel()).removeRow(0);
                }
                preencherTabelaInternosCompletos();
                dispose();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Já foram transferido todos os internos.");
        }
    }//GEN-LAST:event_jBtExportarTodosInternosActionPerformed

    private void jBtExportarSelecionadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExportarSelecionadosActionPerformed
        // TODO add your handling code here:  
        if (jTabelaSelecaoInternosKit.getSelectedRowCount() != 0) {
            DefaultTableModel modelOrigem = (DefaultTableModel) jTabelaSelecaoInternosKit.getModel();
            DefaultTableModel modelDestino = (DefaultTableModel) jTabelaInternosKitCompleto.getModel();
            //Cria uma linha para ser incluida na tabela de destino, no meu caso tem duas colunas, adapte para as suas tabelas
            Object[] obj = {jTabelaSelecaoInternosKit.getValueAt(jTabelaSelecaoInternosKit.getSelectedRow(), 0), jTabelaSelecaoInternosKit.getValueAt(jTabelaSelecaoInternosKit.getSelectedRow(), 1)};
            // BARRA DE ROLAGEM HORIZONTAL
            jTabelaInternosKitCompleto.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            // ALINHAR TEXTO DA TABELA CENTRALIZADO
            DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);
            //
            jTabelaInternosKitCompleto.getColumnModel().getColumn(0).setCellRenderer(centralizado);
            //Adiciona no destino e remove da origem
            modelDestino.addRow(obj);
            modelOrigem.removeRow(jTabelaSelecaoInternosKit.getSelectedRow());
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione um registro.");
        }
    }//GEN-LAST:event_jBtExportarSelecionadosActionPerformed

    private void jTabelaSelecaoInternosKitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaSelecaoInternosKitMouseClicked
        // TODO add your handling code here:
//        flag = 1;
//        if (flag == 1) {
//            idInterno = "" + jTabelaSelecaoInternosKit.getValueAt(jTabelaSelecaoInternosKit.getSelectedRow(), 0);
//            nomeInterno = "" + jTabelaSelecaoInternosKit.getValueAt(jTabelaSelecaoInternosKit.getSelectedRow(), 1);
//            opcao = true;           
//        }            

//        for (int i = 0; i < jTabelaSelecaoInternosKit.getRowCount(); i++) {
//            checked = Boolean.valueOf(jTabelaSelecaoInternosKit.getValueAt(i, 2).toString());
//            col = jTabelaSelecaoInternosKit.getValueAt(i, 1).toString();
//            idInterno = "" + jTabelaSelecaoInternosKit.getValueAt(jTabelaSelecaoInternosKit.getSelectedRow(), 0);
//            nomeInterno = "" + jTabelaSelecaoInternosKit.getValueAt(jTabelaSelecaoInternosKit.getSelectedRow(), 1);
        //DISPLAY
//            if (checked) {
//                JOptionPane.showMessageDialog(null, col);
//            }
//        }
    }//GEN-LAST:event_jTabelaSelecaoInternosKitMouseClicked

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
            java.util.logging.Logger.getLogger(TelaSelecaoInternosKitCompleto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaSelecaoInternosKitCompleto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaSelecaoInternosKitCompleto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaSelecaoInternosKitCompleto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaSelecaoInternosKitCompleto dialog = new TelaSelecaoInternosKitCompleto(montaKitSelec, true);
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
    private javax.swing.JButton jBtExportarSelecionados;
    private javax.swing.JButton jBtExportarTodosInternos;
    private javax.swing.JButton jBtSair;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JScrollPane jScrollPane6;
    public static javax.swing.JTable jTabelaSelecaoInternosKit;
    public static javax.swing.JLabel jtotalInternosSelecionados;
    // End of variables declaration//GEN-END:variables

    public void mostraSelecaoInternos() {
        DefaultTableModel dadosOrigem = (DefaultTableModel) jTabelaSelecaoInternosKit.getModel();
        GravarInternosKitCompleto d = new GravarInternosKitCompleto();
        try {
            for (GravarInternosKitCompleto dd : controle.read()) {                
                jtotalInternosSelecionados.setText(Integer.toString(qtdInternos)); // Converter inteiro em string para exibir na tela 
                dadosOrigem.addRow(new Object[]{dd.getIdInternoCrc(), dd.getNomeInternoCrc(), opcao});
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaSelecaoInternosKit.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaSelecaoInternosKit.getColumnModel().getColumn(0).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaMontagemPagamentoKitInterno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void preencherTabelaInternosCompletos() {
        qtdInternos = 0;
        GravarInternosKitCompleto d = new GravarInternosKitCompleto();
        try {
            for (GravarInternosKitCompleto dd : controle.read()) {
                DefaultTableModel dadosOrigem = (DefaultTableModel) jTabelaInternosKitCompleto.getModel();
                jtotalInternosKitCompleto.setText(Integer.toString(qtdInternos)); // Converter inteiro em string para exibir na tela 
                dadosOrigem.addRow(new Object[]{dd.getIdInternoCrc(), dd.getNomeInternoCrc()});
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaInternosKitCompleto.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaInternosKitCompleto.getColumnModel().getColumn(0).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaSelecaoInternosKitCompleto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
