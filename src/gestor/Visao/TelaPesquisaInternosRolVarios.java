/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleVisitaInterno;
import gestor.Modelo.PesquisaInternosRolVisitasPortaria;
import static gestor.Visao.TelaAcessoBiometria.caminhoFotoVisita;
import static gestor.Visao.TelaAcessoBiometria.codigoPavilhao;
import static gestor.Visao.TelaAcessoBiometria.imagemFreteVisitaVI;
import static gestor.Visao.TelaAcessoBiometria.jCodigoVisita;
import static gestor.Visao.TelaAcessoBiometria.jFotoVisita;
import static gestor.Visao.TelaAcessoBiometria.jGrauParentesco;
import static gestor.Visao.TelaAcessoBiometria.jIdInternoBio;
import static gestor.Visao.TelaAcessoBiometria.jIdRol;
import static gestor.Visao.TelaAcessoBiometria.jNomeInternoBio;
import static gestor.Visao.TelaAcessoBiometria.jNomeVisitante;
import static gestor.Visao.TelaAcessoBiometria.jPavilhao;
import static gestor.Visao.TelaAcessoBiometria.jRegimePenal;
import java.awt.Color;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ronal
 */
public class TelaPesquisaInternosRolVarios extends javax.swing.JDialog {

    ControleVisitaInterno control = new ControleVisitaInterno();
    PesquisaInternosRolVisitasPortaria objPesInterno = new PesquisaInternosRolVisitasPortaria();

    int flag = 0;
    String nomeInterno;
    public static String idInt;
    public static String idVisita;
    String nomeVisita;
    String grauParentesco;
    /**
     * Creates new form TelaPesquisaInternosRolVarios
     */
    public static TelaAcessoBiometria pACESSO_biometria;

    public TelaPesquisaInternosRolVarios(TelaAcessoBiometria parent, boolean modal) {
        this.pACESSO_biometria = parent;
        this.setModal(modal);
        setLocationRelativeTo(pACESSO_biometria);
        initComponents();
        corCampos();
        pBUSCAR_DADOS_internos();
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
        jCodigoInterno = new javax.swing.JTextField();
        jPesqNomeInterno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jRegimeInterno = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jGrauParentesco = new javax.swing.JTextField();
        jCodigoVisita = new javax.swing.JTextField();
        jNomeVisita = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaPesqInternosRol = new javax.swing.JTable();
        jBtConfirmar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("...::: Relação de Internos por Visita - Rol");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Nome do Interno");

        jCodigoInterno.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodigoInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCodigoInterno.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jCodigoInterno.setEnabled(false);

        jPesqNomeInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPesqNomeInterno.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPesqNomeInterno.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Regime");

        jRegimeInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jRegimeInterno.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jRegimeInterno.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Nome da Visita");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Código");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Grau Parentesco");

        jGrauParentesco.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jGrauParentesco.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jGrauParentesco.setEnabled(false);

        jCodigoVisita.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodigoVisita.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCodigoVisita.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jCodigoVisita.setEnabled(false);

        jNomeVisita.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeVisita.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jNomeVisita.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jCodigoInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCodigoVisita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jNomeVisita)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRegimeInterno)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3))
                        .addGap(0, 18, Short.MAX_VALUE))
                    .addComponent(jGrauParentesco))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jNomeVisita, jPesqNomeInterno});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jCodigoInterno, jCodigoVisita});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jCodigoInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRegimeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jGrauParentesco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCodigoVisita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNomeVisita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaPesqInternosRol.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaPesqInternosRol.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Rol", "Código", "Nome do Interno", "Regime", "Pavilhão", "Códi.Visita", "Nome da Visita", "Grau Parentesco"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabelaPesqInternosRol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaPesqInternosRolMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaPesqInternosRol);
        if (jTabelaPesqInternosRol.getColumnModel().getColumnCount() > 0) {
            jTabelaPesqInternosRol.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaPesqInternosRol.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaPesqInternosRol.getColumnModel().getColumn(1).setMinWidth(60);
            jTabelaPesqInternosRol.getColumnModel().getColumn(1).setMaxWidth(60);
            jTabelaPesqInternosRol.getColumnModel().getColumn(2).setMinWidth(250);
            jTabelaPesqInternosRol.getColumnModel().getColumn(2).setMaxWidth(250);
            jTabelaPesqInternosRol.getColumnModel().getColumn(3).setMinWidth(70);
            jTabelaPesqInternosRol.getColumnModel().getColumn(3).setMaxWidth(70);
            jTabelaPesqInternosRol.getColumnModel().getColumn(4).setMinWidth(120);
            jTabelaPesqInternosRol.getColumnModel().getColumn(4).setMaxWidth(120);
            jTabelaPesqInternosRol.getColumnModel().getColumn(5).setMinWidth(80);
            jTabelaPesqInternosRol.getColumnModel().getColumn(5).setMaxWidth(80);
            jTabelaPesqInternosRol.getColumnModel().getColumn(6).setMinWidth(250);
            jTabelaPesqInternosRol.getColumnModel().getColumn(6).setMaxWidth(250);
            jTabelaPesqInternosRol.getColumnModel().getColumn(7).setMinWidth(120);
            jTabelaPesqInternosRol.getColumnModel().getColumn(7).setMaxWidth(120);
        }

        jBtConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/tick.png"))); // NOI18N
        jBtConfirmar.setText("Confirmar");
        jBtConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtConfirmarActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/shutdown-icone-6920-16.png"))); // NOI18N
        jButton2.setText("Sair");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtConfirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtConfirmar, jButton2});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtConfirmar)
                    .addComponent(jButton2))
                .addGap(4, 4, 4))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTabelaPesqInternosRolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaPesqInternosRolMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1 && evt.getClickCount() == 1) {
            idInt = "" + jTabelaPesqInternosRol.getValueAt(jTabelaPesqInternosRol.getSelectedRow(), 0);
            jCodigoInterno.setText(idInt);
            nomeInterno = "" + jTabelaPesqInternosRol.getValueAt(jTabelaPesqInternosRol.getSelectedRow(), 1);
            jPesqNomeInterno.setText(nomeInterno);
            idVisita = "" + jTabelaPesqInternosRol.getValueAt(jTabelaPesqInternosRol.getSelectedRow(), 5);
            jCodigoVisita.setText(idVisita);
            nomeVisita = "" + jTabelaPesqInternosRol.getValueAt(jTabelaPesqInternosRol.getSelectedRow(), 6);
            jNomeVisita.setText(nomeVisita);
            grauParentesco = "" + jTabelaPesqInternosRol.getValueAt(jTabelaPesqInternosRol.getSelectedRow(), 7);
            jGrauParentesco.setText(grauParentesco);
            //
            control.pPESQUISAR_registro(objPesInterno);
            jCodigoInterno.setText(String.valueOf(objPesInterno.getIdInternoCrc()));
            jPesqNomeInterno.setText(objPesInterno.getNomeInternoCrc());
            jCodigoVisita.setText(String.valueOf(objPesInterno.getIdVisita()));
            jNomeVisita.setText(objPesInterno.getNomeVisita());
            jGrauParentesco.setText(objPesInterno.getParentescoVisita());
        }
    }//GEN-LAST:event_jTabelaPesqInternosRolMouseClicked

    private void jBtConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtConfirmarActionPerformed
        // TODO add your handling code here:
        jIdRol.setText(String.valueOf(objPesInterno.getIdRol()));
        jIdInternoBio.setText(String.valueOf(objPesInterno.getIdInternoCrc()));
        jNomeInternoBio.setText(objPesInterno.getNomeInternoCrc());
        jRegimePenal.setText(objPesInterno.getRegime());
        codigoPavilhao = objPesInterno.getIdPav();
        jPavilhao.setText(objPesInterno.getDescricaoPav());
        jCodigoVisita.setText(String.valueOf(objPesInterno.getIdVisita()));
        caminhoFotoVisita = objPesInterno.getImagemVisita();
        if (caminhoFotoVisita != null) {
            javax.swing.ImageIcon a = new javax.swing.ImageIcon(caminhoFotoVisita);
            jFotoVisita.setIcon(a);
            jFotoVisita.setIcon(new ImageIcon(a.getImage().getScaledInstance(jFotoVisita.getWidth(), jFotoVisita.getHeight(), Image.SCALE_DEFAULT)));
        }
        // BUSCAR A FOTO DO VISITA NO BANCO DE DADOS
        imagemFreteVisitaVI = objPesInterno.getImagemFrenteVI();
        if (imagemFreteVisitaVI != null) {
            ImageIcon pic = null;
            pic = new ImageIcon(imagemFreteVisitaVI);
            Image scaled = pic.getImage().getScaledInstance(jFotoVisita.getWidth(), jFotoVisita.getHeight(), Image.SCALE_DEFAULT);
            ImageIcon icon = new ImageIcon(scaled);
            jFotoVisita.setIcon(icon);
        }
        jGrauParentesco.setText(objPesInterno.getParentescoVisita());
        jNomeVisitante.setText(objPesInterno.getNomeVisita());
        dispose();
    }//GEN-LAST:event_jBtConfirmarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPesquisaInternosRolVarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisaInternosRolVarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisaInternosRolVarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisaInternosRolVarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaPesquisaInternosRolVarios dialog = new TelaPesquisaInternosRolVarios(pACESSO_biometria, true);
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
    private javax.swing.JButton jButton2;
    private javax.swing.JTextField jCodigoInterno;
    private javax.swing.JTextField jCodigoVisita;
    private javax.swing.JTextField jGrauParentesco;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jNomeVisita;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jPesqNomeInterno;
    private javax.swing.JTextField jRegimeInterno;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabelaPesqInternosRol;
    // End of variables declaration//GEN-END:variables

    public void corCampos() {
        jCodigoInterno.setBackground(Color.white);
        jPesqNomeInterno.setBackground(Color.white);
        jCodigoVisita.setBackground(Color.white);
        jNomeVisita.setBackground(Color.white);
        jGrauParentesco.setBackground(Color.white);
    }

    public void pBUSCAR_DADOS_internos() {

        DefaultTableModel dadosOrigem = (DefaultTableModel) jTabelaPesqInternosRol.getModel();
        try {
            for (PesquisaInternosRolVisitasPortaria pp : control.INTERNOS_read()) {
                dadosOrigem.addRow(new Object[]{pp.getIdRol(), pp.getIdInternoCrc(), pp.getNomeInternoCrc(), pp.getRegime(), pp.getDescricaoPav(), pp.getIdVisita(), pp.getNomeVisita(), pp.getParentescoVisita()});
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaPesqInternosRol.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaPesqInternosRol.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                jTabelaPesqInternosRol.getColumnModel().getColumn(1).setCellRenderer(centralizado);
                jTabelaPesqInternosRol.getColumnModel().getColumn(5).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaPesquisaInternosRolVarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void limparTabela() {
        // APAGAR DADOS DA TABELA PRODUTOS
        while (jTabelaPesqInternosRol.getModel().getRowCount() > 0) {
            ((DefaultTableModel) jTabelaPesqInternosRol.getModel()).removeRow(0);
        }
    }
}
