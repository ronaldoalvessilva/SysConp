/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleListarGravarProdutosKitCompleto;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControleProdutosKitLote;
import gestor.Controle.ControleSelecaoKitsCompleto;
import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.GravarInternosKitCompleto;
import gestor.Modelo.LogSistema;
import gestor.Modelo.ProdutoInternosKitLote;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.codigoPesquisaKit;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jBtSalvarProdutoBanco;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jIdRegistroComp;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jTabelaInternosKitCompleto;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jTabelaProdutosKitCompleto;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.qtdInternos;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.qtdProd;
import java.awt.Rectangle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ronal
 */
public class TelaGravarProdutosKitCompleto extends javax.swing.JDialog {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ProdutoInternosKitLote objProdKit = new ProdutoInternosKitLote();
    ControleListarGravarProdutosKitCompleto controle = new ControleListarGravarProdutosKitCompleto();
    //
    ControleListarGravarProdutosKitCompleto listar = new ControleListarGravarProdutosKitCompleto();
    ControleProdutosKitLote control = new ControleProdutosKitLote();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log   
    String nomeModuloTela2 = "Almoxarifado:Montagem de Pagamento do Kit de Interno:Gravar Produtos Kit Completo";
    //    
    int IdRegProdutosKC = 0;
    int codigoPavilhao = 0;
    String statusMov = "";
    String horaMov = "";
    String dataModFinal = "";
    int pGravado = 1;
    String pUtili = "Sim";
    int codigoProduto = 0;
    int codigoRegistro = 0;
    int tipoKit = 0; // 0 - COMPLETO E 1 INCOMPLETO
    int pTOTAL_REGISTROS = 0;
    int pTOTAL_REGISTROS_PRO = 0;

    /**
     * Creates new form TelaGravarInternosKitCompleto
     */
    public static TelaMontagemPagamentoKitInterno montaKitProdComp;

    public TelaGravarProdutosKitCompleto(TelaMontagemPagamentoKitInterno parent, boolean modal) {
        this.montaKitProdComp = parent;
        this.setModal(modal);
        setLocationRelativeTo(montaKitProdComp);
        initComponents();
        listarTodosProdutosKitCompleto();
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE); //Impedir que a janela seja fechada pelo X  
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
        jLabel2 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTOTAL_REG_COPIADO = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTOTAL_REG_GRAVADO = new javax.swing.JTextField();
        jPanel21 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTabelaProdutosKitCompletoSelecionado = new javax.swing.JTable();
        jPanel45 = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        jPanel46 = new javax.swing.JPanel();
        jtotalProdutosKitCompleto = new javax.swing.JLabel();
        jPanel47 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jBtConfirmar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("...::: Gravar Internos Kit Completo :::...");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 204))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216082327_48.png"))); // NOI18N
        jLabel2.setText("Aguarde....");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jProgressBar1.setStringPainted(true);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 204));
        jLabel4.setText("Registros Verificados:");

        jTOTAL_REG_COPIADO.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTOTAL_REG_COPIADO.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTOTAL_REG_COPIADO.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTOTAL_REG_COPIADO.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTOTAL_REG_COPIADO.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 204));
        jLabel5.setText("Registros Gravados:");

        jTOTAL_REG_GRAVADO.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTOTAL_REG_GRAVADO.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTOTAL_REG_GRAVADO.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTOTAL_REG_GRAVADO.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTOTAL_REG_GRAVADO.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTOTAL_REG_COPIADO, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTOTAL_REG_GRAVADO, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4)
                    .addComponent(jTOTAL_REG_COPIADO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTOTAL_REG_GRAVADO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Produtos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(204, 0, 0))); // NOI18N

        jTabelaProdutosKitCompletoSelecionado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaProdutosKitCompletoSelecionado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição do Produto", "Un.", "Qtd."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(jTabelaProdutosKitCompletoSelecionado);
        if (jTabelaProdutosKitCompletoSelecionado.getColumnModel().getColumnCount() > 0) {
            jTabelaProdutosKitCompletoSelecionado.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaProdutosKitCompletoSelecionado.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaProdutosKitCompletoSelecionado.getColumnModel().getColumn(1).setMinWidth(250);
            jTabelaProdutosKitCompletoSelecionado.getColumnModel().getColumn(1).setMaxWidth(250);
            jTabelaProdutosKitCompletoSelecionado.getColumnModel().getColumn(2).setMinWidth(50);
            jTabelaProdutosKitCompletoSelecionado.getColumnModel().getColumn(2).setMaxWidth(50);
            jTabelaProdutosKitCompletoSelecionado.getColumnModel().getColumn(3).setMinWidth(50);
            jTabelaProdutosKitCompletoSelecionado.getColumnModel().getColumn(3).setMaxWidth(50);
        }

        jPanel45.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jLabel72.setText("Total de Registros:");

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel72))
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel72)
        );

        jPanel46.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jtotalProdutosKitCompleto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalProdutosKitCompleto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalProdutosKitCompleto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
        );

        jPanel47.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtConfirmar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSair)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtConfirmar, jBtSair});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtConfirmar)
                    .addComponent(jBtSair))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel1, jPanel3});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtConfirmarActionPerformed
        // TODO add your handling code here:
        int resposta = JOptionPane.showConfirmDialog(this, "Confirmar a gravação dos dados selecionados?", "Confirmação",
                JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            jBtSalvarProdutoBanco.setEnabled(!true);
            jBtConfirmar.setEnabled(!true);
            jBtSair.setEnabled(!true);
            gravarDadosBanco();
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
            java.util.logging.Logger.getLogger(TelaGravarProdutosKitCompleto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaGravarProdutosKitCompleto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaGravarProdutosKitCompleto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaGravarProdutosKitCompleto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaGravarProdutosKitCompleto dialog = new TelaGravarProdutosKitCompleto(montaKitProdComp, true);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextField jTOTAL_REG_COPIADO;
    private javax.swing.JTextField jTOTAL_REG_GRAVADO;
    public static javax.swing.JTable jTabelaProdutosKitCompletoSelecionado;
    public static javax.swing.JLabel jtotalProdutosKitCompleto;
    // End of variables declaration//GEN-END:variables

    public void listarTodosProdutosKitCompleto() {
        qtdProd = 0;
        DefaultTableModel produtosSelecionados = (DefaultTableModel) jTabelaProdutosKitCompletoSelecionado.getModel();
        ProdutoInternosKitLote p = new ProdutoInternosKitLote();
        try {
            for (ProdutoInternosKitLote pp : control.read()) {
                jtotalProdutosKitCompleto.setText(Integer.toString(qtdProd)); // Converter inteiro em string para exibir na tela 
                produtosSelecionados.addRow(new Object[]{pp.getIdProd(), pp.getDescricaoProduto(), pp.getUnidadeProd(), pp.getQuantidadeProd()});
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaProdutosKitCompletoSelecionado.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaProdutosKitCompletoSelecionado.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                jTabelaProdutosKitCompletoSelecionado.getColumnModel().getColumn(2).setCellRenderer(centralizado);
                jTabelaProdutosKitCompletoSelecionado.getColumnModel().getColumn(3).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaSelecaoProdutosKitsCompletoIncompleto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void listarProdutosNaoAtendido() {
        DefaultTableModel produtosSelecionados = (DefaultTableModel) jTabelaProdutosKitCompletoSelecionado.getModel();
        ProdutoInternosKitLote p = new ProdutoInternosKitLote();
        try {
            for (ProdutoInternosKitLote pp : listar.read()) {
                jtotalProdutosKitCompleto.setText(Integer.toString(qtdProd)); // Converter inteiro em string para exibir na tela 
                produtosSelecionados.addRow(new Object[]{pp.getIdProd(), pp.getDescricaoProduto(), pp.getUnidadeProd(), pp.getQuantidadeProd()});
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaProdutosKitCompletoSelecionado.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaProdutosKitCompletoSelecionado.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                jTabelaProdutosKitCompletoSelecionado.getColumnModel().getColumn(2).setCellRenderer(centralizado);
                jTabelaProdutosKitCompletoSelecionado.getColumnModel().getColumn(3).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaSelecaoProdutosKitsCompletoIncompleto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void gravarDadosBanco() {
        // THREAD DOS DADOS
        try {
            Thread t0 = new Thread() {
                public void run() {
                    statusMov = "Incluiu";
                    horaMov = jHoraSistema.getText();
                    dataModFinal = jDataSistema.getText();
                    // GRAVAR NA TABELA ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO                         
                    for (int i = 0; i < jTabelaProdutosKitCompletoSelecionado.getRowCount(); i++) {//  
                        objProdKit.setUsuarioInsert(nameUser);
                        objProdKit.setDataInsert(dataModFinal);
                        objProdKit.setHorarioInsert(horaMov);
                        //
                        objProdKit.setIdRegistroComp(Integer.valueOf(jIdRegistroComp.getText()));// TABELA PRINCIPAL (COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE)                                                        
                        objProdKit.setIdKit(codigoPesquisaKit);
                        objProdKit.setIdProd((int) jTabelaProdutosKitCompletoSelecionado.getValueAt(i, 0));
                        objProdKit.setDescricaoProduto((String) jTabelaProdutosKitCompletoSelecionado.getValueAt(i, 1));
                        objProdKit.setQuantidadeProd((int) jTabelaProdutosKitCompletoSelecionado.getValueAt(i, 3));
                        objProdKit.setGravado(pGravado);
                        objProdKit.setTipoKitCI(tipoKit);
                        // VERIFICAR SE O INTERNO JÁ SE ENCONTRA GRAVADO NA TABELA PARA PARA O MESMO REGISTRO
                        verificarProdutoBancoDados(objProdKit.getIdRegistroComp(), objProdKit.getIdProd());
                        // SE O REGISTRO FOR IGUAL E O INTERNO DIFERENTE, GRAVA
                        if (objProdKit.getIdRegistroComp() == codigoRegistro && objProdKit.getIdProd() != codigoProduto) {
                            controle.incluirProdutosKitCompletoIncompleto(objProdKit);
                            buscarCodigoRegistroProdutoKitCompleto();
                            // FAZ UM UPDATE NA TABELA INTERNOS_PAVILHAO_KIT_LOTE INFORMANDO A UTILIZAÇÃO DOS INTERNOS PARA 
                            // O KIT COMPLETO
                            objProdKit.setpUtili(pUtili);
                            controle.atualizarProdutoUtilizadoKit(objProdKit);
                            objLog2();
                            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação  
                            // SE O REGISTRO FOR DIFERENTE GRAVA OS NOVOS INTERNOS
                        } else if (objProdKit.getIdRegistroComp() != codigoRegistro) {
                            controle.incluirProdutosKitCompletoIncompleto(objProdKit);
                            buscarCodigoRegistroProdutoKitCompleto();
                            // FAZ UM UPDATE NA TABELA INTERNOS_PAVILHAO_KIT_LOTE INFORMANDO A UTILIZAÇÃO DOS INTERNOS PARA 
                            // O KIT COMPLETO
                            objProdKit.setpUtili(pUtili);
                            controle.atualizarProdutoUtilizadoKit(objProdKit);
                            objLog2();
                            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação  
                            // SE O CODIGO DO INTERNO FOR ZERO
                        } else if (codigoRegistro == 0) {
                            controle.incluirProdutosKitCompletoIncompleto(objProdKit);
                            buscarCodigoRegistroProdutoKitCompleto();
                            // FAZ UM UPDATE NA TABELA INTERNOS_PAVILHAO_KIT_LOTE INFORMANDO A UTILIZAÇÃO DOS INTERNOS PARA 
                            // O KIT COMPLETO
                            objProdKit.setpUtili(pUtili);
                            controle.atualizarProdutoUtilizadoKit(objProdKit);
                            objLog2();
                            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação  
                            // SE O CODIGO DO REGISTRO FOR DIFERENTE E O CÓDIGO DO INTERNO FOR DIFERENTE GRAVA
                        } else if (objProdKit.getIdRegistroComp() != codigoRegistro && objProdKit.getIdProd() != codigoProduto) {
                            controle.incluirProdutosKitCompletoIncompleto(objProdKit);
                            buscarCodigoRegistroProdutoKitCompleto();
                            // FAZ UM UPDATE NA TABELA INTERNOS_PAVILHAO_KIT_LOTE INFORMANDO A UTILIZAÇÃO DOS INTERNOS PARA 
                            // O KIT COMPLETO
                            objProdKit.setpUtili(pUtili);
                            controle.atualizarProdutoUtilizadoKit(objProdKit);
                            objLog2();
                            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação  
                        }
                        pTOTAL_REGISTROS_PRO = i + 1;
                        jTOTAL_REG_GRAVADO.setText(String.valueOf(pTOTAL_REGISTROS_PRO));
                        jProgressBar1.setValue(i);
                        if (pTOTAL_REGISTROS_PRO == pTOTAL_REGISTROS || i>= 99) {
                            jBtSair.setEnabled(true);
                            JOptionPane.showMessageDialog(rootPane, "Operação Concluída com sucesso...");
                            dispose();
                        }
                    }
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                    }
                }
            };
            t0.start();
        } catch (Exception e) {
        }
        // THREAD DA BARRA DE EXECUÇÃO
        try {
            Thread t = new Thread() {
                public void run() {
                    jProgressBar1.setMaximum(jTabelaProdutosKitCompletoSelecionado.getRowCount());
                    Rectangle rect;
                    for (int i = 0; i < jTabelaProdutosKitCompletoSelecionado.getRowCount(); i++) {
                        rect = jTabelaProdutosKitCompletoSelecionado.getCellRect(i, 0, true);
                        try {
                            jTabelaProdutosKitCompletoSelecionado.scrollRectToVisible(rect);
                        } catch (java.lang.ClassCastException e) {
                        }
                        if (i == 0) {
                            jTabelaProdutosKitCompletoSelecionado.setRowSelectionInterval(i, 0);
                            jProgressBar1.setValue((i + 1));
                        } else if (i > 0) {
                            jTabelaProdutosKitCompletoSelecionado.setRowSelectionInterval(i, 1);
                            jProgressBar1.setValue((i + 1));
                        }
                        pTOTAL_REGISTROS = i + 1;
                        jTOTAL_REG_COPIADO.setText(String.valueOf(pTOTAL_REGISTROS));
                        jProgressBar1.setValue(i);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                        }
                    }
                    try {
                    } catch (Exception e) {
                    }
                }
            };
            t.start();
        } catch (Exception e) {
        }
    }

    // PEGAR O ID PARA O LOG2
    public void buscarCodigoRegistroProdutoKitCompleto() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT IdRegProdutosKC FROM ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO");
            conecta.rs.last();
            IdRegProdutosKC = conecta.rs.getInt("IdRegProdutosKC");
        } catch (Exception ERROR) {
        }
        conecta.desconecta();
    }

    // VERIFICAR SE O PRODUTO JÁ FOI INCLUÍDO NO BANCO DE DADOS
    // PARA NÃO SER GRAVADO MAIS DE UMA VEZ NO MESMO KIT
    public void verificarProdutoBancoDados(int codigoReg, int codProdutoAC) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT IdRegistroComp,IdProd "
                    + "FROM ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO "
                    + "WHERE IdRegistroComp='" + codigoReg + "' "
                    + "AND IdProd='" + codProdutoAC + "'");
            conecta.rs.last();
            codigoProduto = conecta.rs.getInt("IdProd");
            codigoRegistro = conecta.rs.getInt("IdRegistroComp");
        } catch (Exception ERROR) {
        }
        conecta.desconecta();
    }

    public void objLog2() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela2);
        objLogSys.setIdLancMov(Integer.valueOf(jIdRegistroComp.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }
}
