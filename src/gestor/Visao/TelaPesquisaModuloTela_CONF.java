package gestor.Visao;

import gestor.Controle.ControleParamentrosCrc;
import gestor.Controle.ControlePesquisaParametrosImplementacoes;
import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ParametrosCrc;
import static gestor.Visao.TelaParamentrosSistema.jComboBoxModuloImplementacao;
import static gestor.Visao.TelaParamentrosSistema.jComboBoxTelaImplementacao;
import static gestor.Visao.TelaParamentrosSistema.jComboBoxHabilitar;
import static gestor.Visao.TelaParamentrosSistema.jBtAlterarImp;
import static gestor.Visao.TelaParamentrosSistema.jBtExcluirImp;
import static gestor.Visao.TelaParamentrosSistema.pCOD_mod;
import static gestor.Visao.TelaParamentrosSistema.pCOD_tel;
import static gestor.Visao.TelaParamentrosSistema.pCODIGO_registro;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ronaldo.silva7
 */
public class TelaPesquisaModuloTela_CONF extends javax.swing.JDialog {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ;
    ParametrosCrc objParCrc = new ParametrosCrc();
    ControleParamentrosCrc control = new ControleParamentrosCrc();
    ControlePesquisaParametrosImplementacoes controle = new ControlePesquisaParametrosImplementacoes();

    int flag = 1;
    public static String pCOD_modp;
    public static String pCOD_telp;
    public static String pMODp;
    public static String pTELAp;

    /**
     * Creates new form TelaPesquisaModuloTela_CONF
     */
    public static TelaParamentrosSistema pTELA_parametros;

    public TelaPesquisaModuloTela_CONF(TelaParamentrosSistema parent, boolean modal) {
        this.pTELA_parametros = parent;
        this.setModal(modal);
        setLocationRelativeTo(pTELA_parametros);
        initComponents();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTelaModuloImplementacao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jCodigoModulo = new javax.swing.JTextField();
        jCodigoTela = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jHabilitarPesquisa = new javax.swing.JTextField();
        jModuloPesquisa = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jBtConfirmar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaPesquisaImplementacoes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Módulo");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Tela");

        jTelaModuloImplementacao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTelaModuloImplementacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTelaModuloImplementacao.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTelaModuloImplementacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTelaModuloImplementacaoKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Código Módulo");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Código Tela");

        jCodigoModulo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCodigoModulo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodigoModulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCodigoModulo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jCodigoModulo.setEnabled(false);

        jCodigoTela.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCodigoTela.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodigoTela.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCodigoTela.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jCodigoTela.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Habilitar");

        jHabilitarPesquisa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jHabilitarPesquisa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHabilitarPesquisa.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jHabilitarPesquisa.setEnabled(false);

        jModuloPesquisa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jModuloPesquisa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jModuloPesquisa.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jModuloPesquisa.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jCodigoModulo)
                    .addComponent(jModuloPesquisa))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jCodigoTela, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(176, 176, 176))
                            .addComponent(jHabilitarPesquisa)))
                    .addComponent(jTelaModuloImplementacao))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jCodigoModulo, jCodigoTela, jModuloPesquisa});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jHabilitarPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCodigoTela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCodigoModulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jModuloPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTelaModuloImplementacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jBtConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/tick.png"))); // NOI18N
        jBtConfirmar.setText("Confirmar");
        jBtConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtConfirmarActionPerformed(evt);
            }
        });

        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/shutdown-icone-6920-16.png"))); // NOI18N
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
                .addComponent(jBtConfirmar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSair)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtConfirmar, jBtSair});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtConfirmar)
                    .addComponent(jBtSair))
                .addGap(4, 4, 4))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtConfirmar, jBtSair});

        jTabelaPesquisaImplementacoes.setAutoCreateRowSorter(true);
        jTabelaPesquisaImplementacoes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaPesquisaImplementacoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cód.Módulo", "Módulo", "Habilitar", "Cód.Tela", "Funcionalidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabelaPesquisaImplementacoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaPesquisaImplementacoesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaPesquisaImplementacoes);
        if (jTabelaPesquisaImplementacoes.getColumnModel().getColumnCount() > 0) {
            jTabelaPesquisaImplementacoes.getColumnModel().getColumn(0).setMinWidth(80);
            jTabelaPesquisaImplementacoes.getColumnModel().getColumn(0).setMaxWidth(80);
            jTabelaPesquisaImplementacoes.getColumnModel().getColumn(1).setMinWidth(250);
            jTabelaPesquisaImplementacoes.getColumnModel().getColumn(1).setMaxWidth(250);
            jTabelaPesquisaImplementacoes.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaPesquisaImplementacoes.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaPesquisaImplementacoes.getColumnModel().getColumn(3).setMinWidth(70);
            jTabelaPesquisaImplementacoes.getColumnModel().getColumn(3).setMaxWidth(70);
            jTabelaPesquisaImplementacoes.getColumnModel().getColumn(4).setMinWidth(550);
            jTabelaPesquisaImplementacoes.getColumnModel().getColumn(4).setMaxWidth(550);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTabelaPesquisaImplementacoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaPesquisaImplementacoesMouseClicked
        // TODO add your handling code here:
        flag = 1;
        pCOD_modp = "" + jTabelaPesquisaImplementacoes.getValueAt(jTabelaPesquisaImplementacoes.getSelectedRow(), 0);
        jCodigoModulo.setText(pCOD_modp);
        pMODp = "" + jTabelaPesquisaImplementacoes.getValueAt(jTabelaPesquisaImplementacoes.getSelectedRow(), 1);
        jModuloPesquisa.setText(pMODp);
        String pHABILITA = "" + jTabelaPesquisaImplementacoes.getValueAt(jTabelaPesquisaImplementacoes.getSelectedRow(), 2);
        jHabilitarPesquisa.setText(pHABILITA);
        pCOD_telp = "" + jTabelaPesquisaImplementacoes.getValueAt(jTabelaPesquisaImplementacoes.getSelectedRow(), 3);
        jCodigoTela.setText(pCOD_telp);
        pTELAp = "" + jTabelaPesquisaImplementacoes.getValueAt(jTabelaPesquisaImplementacoes.getSelectedRow(), 4);
        jTelaModuloImplementacao.setText(pTELAp);
        control.pPESQUISAR_REGISTRO_selecionado(objParCrc);
    }//GEN-LAST:event_jTabelaPesquisaImplementacoesMouseClicked

    private void jBtConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtConfirmarActionPerformed
        // TODO add your handling code here:
        pCODIGO_registro = objParCrc.getIdImp();
        pCOD_mod = jCodigoModulo.getText();
        pCOD_tel = jCodigoTela.getText();
        jComboBoxHabilitar.setSelectedItem(jHabilitarPesquisa.getText());
        jComboBoxModuloImplementacao.setSelectedItem(jModuloPesquisa.getText());
        jComboBoxTelaImplementacao.setSelectedItem(jTelaModuloImplementacao.getText());
        //
        jBtAlterarImp.setEnabled(true);
        jBtExcluirImp.setEnabled(true);
        dispose();
    }//GEN-LAST:event_jBtConfirmarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jTelaModuloImplementacaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTelaModuloImplementacaoKeyReleased
        // TODO add your handling code here:
        if (!jTelaModuloImplementacao.getText().equals("")) {
            pBUSCAR_DADOS_imp();
        }
    }//GEN-LAST:event_jTelaModuloImplementacaoKeyReleased

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
            java.util.logging.Logger.getLogger(TelaPesquisaModuloTela_CONF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisaModuloTela_CONF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisaModuloTela_CONF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisaModuloTela_CONF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaPesquisaModuloTela_CONF dialog = new TelaPesquisaModuloTela_CONF(pTELA_parametros, true);
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
    private javax.swing.JButton jBtSair;
    private javax.swing.JTextField jCodigoModulo;
    private javax.swing.JTextField jCodigoTela;
    private javax.swing.JTextField jHabilitarPesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jModuloPesquisa;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabelaPesquisaImplementacoes;
    public static javax.swing.JTextField jTelaModuloImplementacao;
    // End of variables declaration//GEN-END:variables

    public void corCampos() {
        jCodigoModulo.setBackground(Color.white);
        jCodigoTela.setBackground(Color.white);
        jHabilitarPesquisa.setBackground(Color.white);
        jModuloPesquisa.setBackground(Color.white);
        jTelaModuloImplementacao.setBackground(Color.white);
    }

    public void pBUSCAR_DADOS_imp() {

        DefaultTableModel dadosOrigem = (DefaultTableModel) jTabelaPesquisaImplementacoes.getModel();
        while (jTabelaPesquisaImplementacoes.getModel().getRowCount() > 0) {
            ((DefaultTableModel) jTabelaPesquisaImplementacoes.getModel()).removeRow(0);
        }
        try {
            for (ParametrosCrc pp : controle.read()) {
                dadosOrigem.addRow(new Object[]{pp.getIdModulo(), pp.getNomeModulo(), pp.getHabilitarImp(), pp.getIdTelas(), pp.getNomeTela()});
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaPesquisaImplementacoes.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaPesquisaImplementacoes.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                jTabelaPesquisaImplementacoes.getColumnModel().getColumn(3).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaParamentrosSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void limparTabela() {
        // APAGAR DADOS DA TABELA PRODUTOS
        while (jTabelaPesquisaImplementacoes.getModel().getRowCount() > 0) {
            ((DefaultTableModel) jTabelaPesquisaImplementacoes.getModel()).removeRow(0);
        }
    }
}