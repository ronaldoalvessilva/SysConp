/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleSaque;
import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.SaqueValores;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaSaqueBancario.jDataLanc;
import static gestor.Visao.TelaSaqueBancario.jIdLanc;
import static gestor.Visao.TelaSaqueBancario.jNomeFavorecido;
import static gestor.Visao.TelaSaqueBancario.jNomeInternoSaque;
import static gestor.Visao.TelaSaqueBancario.jValorDebito;
import java.awt.Color;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Ronaldo
 */
public class TelaReciboSaqueInterno extends javax.swing.JDialog {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    SaqueValores objSaque = new SaqueValores();
    ControleSaque control = new ControleSaque();
    String textoRecibo = "";
    String modeloReciboA = "Declaro para os devidos fins que o Sr. (nome), (nacionalidade), (estado civil), "
            + "(profissão), inscrito no CPF sob o nº (informar) e no RG nº (informar), "
            + "efetuou pagamento referente a saque no valor R$ (xxx,xxx) "
            + "\n\n(localidade), (dia) de (mês) de (ano).";
    /**
     * Creates new form TelaReciboSaqueInterno
     */
    public static TelaSaqueBancario telaSaque;

    public TelaReciboSaqueInterno(TelaSaqueBancario parent, boolean modal) {
        this.telaSaque = parent;
        this.setModal(modal);
        setLocationRelativeTo(telaSaque);
        initComponents();
        formatarCampos();
        corCampos();
        inicarCampos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupModeloRecibo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jNomeInternoSacado = new javax.swing.JTextField();
        jNomeFavorecidoRecibo = new javax.swing.JTextField();
        jValorSaqueRecibo = new javax.swing.JFormattedTextField();
        jCodigoSaque = new javax.swing.JTextField();
        jDataSaqueRecibo = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextoRecibo = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jBtSair = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtImprimirRecibo = new javax.swing.JButton();
        jRadioBtModelo = new javax.swing.JRadioButton();
        jRadioBtDigitar = new javax.swing.JRadioButton();
        jAsterisco = new javax.swing.JLabel();
        jBtAlterar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("...::: Recibo de Saque :::...");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Data");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Valor R$:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Favorecido");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Nome Interno");

        jNomeInternoSacado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoSacado.setEnabled(false);

        jNomeFavorecidoRecibo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeFavorecidoRecibo.setEnabled(false);

        jValorSaqueRecibo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jValorSaqueRecibo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jValorSaqueRecibo.setEnabled(false);

        jCodigoSaque.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodigoSaque.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCodigoSaque.setEnabled(false);

        jDataSaqueRecibo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataSaqueRecibo.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("RECIBO DE SAQUE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jNomeFavorecidoRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jNomeInternoSacado, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCodigoSaque, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jDataSaqueRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(230, 230, 230)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jValorSaqueRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jCodigoSaque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataSaqueRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jValorSaqueRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNomeInternoSacado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNomeFavorecidoRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jTextoRecibo.setColumns(20);
        jTextoRecibo.setRows(5);
        jScrollPane1.setViewportView(jTextoRecibo);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtSair.setForeground(new java.awt.Color(255, 0, 0));
        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSair.setText("Sair");
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        jBtSalvar.setForeground(new java.awt.Color(0, 0, 255));
        jBtSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvar.setText("Gravar");
        jBtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarActionPerformed(evt);
            }
        });

        jBtImprimirRecibo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/gtklp-icone-3770-16.png"))); // NOI18N
        jBtImprimirRecibo.setText("Imprimir");
        jBtImprimirRecibo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtImprimirReciboActionPerformed(evt);
            }
        });

        buttonGroupModeloRecibo.add(jRadioBtModelo);
        jRadioBtModelo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioBtModelo.setForeground(new java.awt.Color(255, 0, 0));
        jRadioBtModelo.setText("Usar Modelo");
        jRadioBtModelo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioBtModeloMouseClicked(evt);
            }
        });

        buttonGroupModeloRecibo.add(jRadioBtDigitar);
        jRadioBtDigitar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioBtDigitar.setForeground(new java.awt.Color(0, 153, 0));
        jRadioBtDigitar.setText("Digitar");
        jRadioBtDigitar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioBtDigitarMouseClicked(evt);
            }
        });

        jAsterisco.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jAsterisco.setForeground(new java.awt.Color(255, 0, 0));
        jAsterisco.setText("*");

        jBtAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterar.setText("Alterar");
        jBtAlterar.setEnabled(false);
        jBtAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtSair)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtImprimirRecibo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioBtModelo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioBtDigitar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jAsterisco)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtSair)
                    .addComponent(jBtImprimirRecibo)
                    .addComponent(jBtSalvar)
                    .addComponent(jRadioBtModelo)
                    .addComponent(jRadioBtDigitar)
                    .addComponent(jAsterisco)
                    .addComponent(jBtAlterar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtImprimirRecibo, jBtSair, jBtSalvar});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        objSaque.setReciboSaque(jTextoRecibo.getText());
        objSaque.setIdLanc(Integer.valueOf(jIdLanc.getText()));
        control.salvarReciboSaque(objSaque);
        Salvar();
        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
    }//GEN-LAST:event_jBtSalvarActionPerformed

    private void jBtImprimirReciboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImprimirReciboActionPerformed
        // TODO add your handling code here:
        if (jTextoRecibo.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Não existe texto no recibo a ser impresso.");
        } else {
            try {
                conecta.abrirConexao();
                String path = "reports/ReciboSaqueInterno.jasper";
                conecta.executaSQL("SELECT * FROM SAQUE "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON SAQUE.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE IdSaq='" + jIdLanc.getText() + "'");
                HashMap parametros = new HashMap();
                parametros.put("codigoSaque", jIdLanc.getText());
                parametros.put("nomeUsuario", nameUser);
                JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
                JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
                JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
                jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
                jv.setTitle("Recibo de Saque");
                dispose(); // FECHA A JANELA ANTES DE EXIBIR A TELA DO RELATÓRIO.
                jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
                jv.toFront(); // Traz o relatorio para frente da aplicação                  
            } catch (JRException e) {
                JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório.\nERRO :" + e);
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jBtImprimirReciboActionPerformed

    private void jRadioBtModeloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioBtModeloMouseClicked
        // TODO add your handling code here:
        if (textoRecibo == null || textoRecibo.equals("")) {
            jTextoRecibo.setText(modeloReciboA);
        }
    }//GEN-LAST:event_jRadioBtModeloMouseClicked

    private void jRadioBtDigitarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioBtDigitarMouseClicked
        // TODO add your handling code here:
        if (textoRecibo == null || textoRecibo.equals("")) {
            jTextoRecibo.setText("");
        }
    }//GEN-LAST:event_jRadioBtDigitarMouseClicked

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        // TODO add your handling code here:
        alterar();
    }//GEN-LAST:event_jBtAlterarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaReciboSaqueInterno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaReciboSaqueInterno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaReciboSaqueInterno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaReciboSaqueInterno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaReciboSaqueInterno dialog = new TelaReciboSaqueInterno(telaSaque, true);
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
    private javax.swing.ButtonGroup buttonGroupModeloRecibo;
    private javax.swing.JLabel jAsterisco;
    private javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtImprimirRecibo;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JTextField jCodigoSaque;
    private com.toedter.calendar.JDateChooser jDataSaqueRecibo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jNomeFavorecidoRecibo;
    private javax.swing.JTextField jNomeInternoSacado;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioBtDigitar;
    private javax.swing.JRadioButton jRadioBtModelo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextoRecibo;
    private javax.swing.JFormattedTextField jValorSaqueRecibo;
    // End of variables declaration//GEN-END:variables

    public void corCampos() {
        jCodigoSaque.setBackground(Color.white);
        jDataSaqueRecibo.setBackground(Color.white);
        jValorSaqueRecibo.setBackground(Color.white);
        jNomeInternoSacado.setBackground(Color.white);
        jNomeFavorecidoRecibo.setBackground(Color.white);
        jTextoRecibo.setBackground(Color.white);
    }

    public void formatarCampos() {
        jTextoRecibo.setLineWrap(true);
        jTextoRecibo.setWrapStyleWord(true);
    }

    public void inicarCampos() {
        jCodigoSaque.setText(jIdLanc.getText());
        jDataSaqueRecibo.setDate(jDataLanc.getDate());
        jValorSaqueRecibo.setText(jValorDebito.getText());
        jNomeInternoSacado.setText(jNomeInternoSaque.getText());
        jNomeFavorecidoRecibo.setText(jNomeFavorecido.getText());
        //
        jRadioBtModelo.setEnabled(true);
        jRadioBtDigitar.setEnabled(true);
        //
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM SAQUE WHERE IdSaq='" + jIdLanc.getText() + "'");
            conecta.rs.first();
            textoRecibo = conecta.rs.getString("ReciboSaque");
        } catch (Exception e) {
        }
        conecta.desconecta();
        if (textoRecibo != null) {
            jTextoRecibo.setText(textoRecibo);
        }
    }

    public void Salvar() {
        jBtSalvar.setEnabled(!true);
        jAsterisco.setEnabled(!true);
        jBtAlterar.setEnabled(true);
        //
        jRadioBtModelo.setEnabled(!true);
        jRadioBtDigitar.setEnabled(!true);
    }

    public void alterar() {
        jBtSalvar.setEnabled(true);
        jAsterisco.setEnabled(true);
        jBtAlterar.setEnabled(!true);
        //
        jRadioBtModelo.setEnabled(true);
        jRadioBtDigitar.setEnabled(true);
    }
}
