/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleEscalaFolgas;
import gestor.Controle.PesquisarEscalasDescricao;
import gestor.Modelo.EscalaFolgas;
import static gestor.Visao.TelaCronogramaEscala.jBtAlterar;
import static gestor.Visao.TelaCronogramaEscala.pID_REGISTRO;
import static gestor.Visao.TelaCronogramaEscala.pID_ESCALA;
import static gestor.Visao.TelaCronogramaEscala.jCargo;
import static gestor.Visao.TelaCronogramaEscala.jCodigoFunc;
import static gestor.Visao.TelaCronogramaEscala.jComboBoxAnoReferencia;
import static gestor.Visao.TelaCronogramaEscala.jComboBoxMesReferencia;
import static gestor.Visao.TelaCronogramaEscala.jComboBoxPrimeiroApt;
import static gestor.Visao.TelaCronogramaEscala.jComboBoxSegundoApt;
import static gestor.Visao.TelaCronogramaEscala.jDataFinalCronograma;
import static gestor.Visao.TelaCronogramaEscala.jDataInicialCronograma;
import static gestor.Visao.TelaCronogramaEscala.jDataPrimeiraFolga;
import static gestor.Visao.TelaCronogramaEscala.jDepartamentoEscala;
import static gestor.Visao.TelaCronogramaEscala.jEscala;
import static gestor.Visao.TelaCronogramaEscala.jNomeColaboradorEscala;
import static gestor.Visao.TelaCronogramaEscala.jQuantFolga;
import static gestor.Visao.TelaCronogramaEscala.jQuantTrabalho;
import static gestor.Visao.TelaCronogramaEscala.jTurmaEscala;
import static gestor.Visao.TelaCronogramaEscala.jTurnoEscala;
import static gestor.Visao.TelaCronogramaEscala.jBtExcluir;
import static gestor.Visao.TelaCronogramaEscala.jComboBoxTipoCronograma;
import static gestor.Visao.TelaFuncionarios.jDepartamento;
import static gestor.Visao.TelaFuncionarios.jNomeCargo;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ronal
 */
public class TelaPesquisaCronogramaEscala extends javax.swing.JDialog {

    EscalaFolgas objEscalas = new EscalaFolgas();
    PesquisarEscalasDescricao pPESQUISAR_colaborador = new PesquisarEscalasDescricao();
    ControleEscalaFolgas pPESQUISAR_todosReg = new ControleEscalaFolgas();

    String pDATA_inicial;
    String pDATA_final;
    public static int pTOTAL_registros = 0;
    public static String pMES_referencia = "";
    public static String pANO_referencia = "";
    int flag = 0;
    /**
     * Creates new form TelaPesquisaCronogramaEscala
     */
    public static TelaCronogramaEscala pCRONOGRAMA_escala;

    public TelaPesquisaCronogramaEscala(TelaCronogramaEscala parent, boolean modal) {
        this.pCRONOGRAMA_escala = parent;
        this.setModal(modal);
        setLocationRelativeTo(pCRONOGRAMA_escala);
        initComponents();
        corCampos();
        LIMPAR_tabela();
        PESQUISAR_TODOS_registros();
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jNomeColaborador = new javax.swing.JTextField();
        jIdColaborador = new javax.swing.JTextField();
        jMesReferencia = new javax.swing.JTextField();
        jAnoReferencia = new javax.swing.JTextField();
        jDataInicial = new com.toedter.calendar.JDateChooser();
        jDataFinal = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaCronograma = new javax.swing.JTable();
        jPanel30 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jBtEnviar = new javax.swing.JButton();
        jBSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("...::: Cronograma de Escala e Folga de Trabalho :::...");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Nome do Colaborador");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Data Inicial");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Data Final");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Mês Referência");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Ano Referência");

        jNomeColaborador.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jNomeColaborador.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeColaborador.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jNomeColaborador.setEnabled(false);

        jIdColaborador.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jIdColaborador.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdColaborador.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdColaborador.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jIdColaborador.setEnabled(false);

        jMesReferencia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jMesReferencia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jMesReferencia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMesReferencia.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jMesReferencia.setEnabled(false);

        jAnoReferencia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jAnoReferencia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jAnoReferencia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAnoReferencia.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jAnoReferencia.setEnabled(false);

        jDataInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataInicial.setEnabled(false);

        jDataFinal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataFinal.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jMesReferencia)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jAnoReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jIdColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jNomeColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jAnoReferencia, jMesReferencia});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIdColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNomeColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jMesReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jAnoReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        jTabelaCronograma.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaCronograma.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome do Colaborador", "Data Inicial", "Data Final", "Mês Referência", "Ano Referência"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabelaCronograma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaCronogramaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaCronograma);
        if (jTabelaCronograma.getColumnModel().getColumnCount() > 0) {
            jTabelaCronograma.getColumnModel().getColumn(0).setMinWidth(60);
            jTabelaCronograma.getColumnModel().getColumn(0).setMaxWidth(60);
            jTabelaCronograma.getColumnModel().getColumn(1).setMinWidth(250);
            jTabelaCronograma.getColumnModel().getColumn(1).setMaxWidth(250);
            jTabelaCronograma.getColumnModel().getColumn(2).setMinWidth(70);
            jTabelaCronograma.getColumnModel().getColumn(2).setMaxWidth(70);
            jTabelaCronograma.getColumnModel().getColumn(3).setMinWidth(70);
            jTabelaCronograma.getColumnModel().getColumn(3).setMaxWidth(70);
            jTabelaCronograma.getColumnModel().getColumn(4).setMinWidth(100);
            jTabelaCronograma.getColumnModel().getColumn(4).setMaxWidth(100);
            jTabelaCronograma.getColumnModel().getColumn(5).setMinWidth(100);
            jTabelaCronograma.getColumnModel().getColumn(5).setMaxWidth(100);
        }

        jPanel30.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jLabel67.setText("Total de Registros:");

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel67))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel67)
        );

        jPanel31.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        jPanel32.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jtotalRegistros.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jBtEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/tick.png"))); // NOI18N
        jBtEnviar.setText("Enviar");
        jBtEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtEnviarActionPerformed(evt);
            }
        });

        jBSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/shutdown-icone-6920-16.png"))); // NOI18N
        jBSair.setText("Sair");
        jBSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtEnviar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBSair)
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBSair, jBtEnviar});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtEnviar)
                    .addComponent(jBSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTabelaCronogramaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaCronogramaMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            pMES_referencia = "" + jTabelaCronograma.getValueAt(jTabelaCronograma.getSelectedRow(), 4);
            pANO_referencia = "" + jTabelaCronograma.getValueAt(jTabelaCronograma.getSelectedRow(), 5);
            pBUSCAR_DADOS_crono();
        }
    }//GEN-LAST:event_jTabelaCronogramaMouseClicked

    private void jBtEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtEnviarActionPerformed
        // TODO add your handling code here:
        pENVIAR_DADOS_crono();
        jBtExcluir.setEnabled(true);
        jBtAlterar.setEnabled(true);
        dispose();
    }//GEN-LAST:event_jBtEnviarActionPerformed

    private void jBSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBSairActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPesquisaCronogramaEscala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisaCronogramaEscala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisaCronogramaEscala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisaCronogramaEscala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaPesquisaCronogramaEscala dialog = new TelaPesquisaCronogramaEscala(pCRONOGRAMA_escala, true);
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
    public static javax.swing.JTextField jAnoReferencia;
    private javax.swing.JButton jBSair;
    private javax.swing.JButton jBtEnviar;
    private com.toedter.calendar.JDateChooser jDataFinal;
    private com.toedter.calendar.JDateChooser jDataInicial;
    private javax.swing.JTextField jIdColaborador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel67;
    public static javax.swing.JTextField jMesReferencia;
    private javax.swing.JTextField jNomeColaborador;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabelaCronograma;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void corCampos() {
        jIdColaborador.setBackground(Color.WHITE);
        jNomeColaborador.setBackground(Color.WHITE);
        jDataInicial.setBackground(Color.WHITE);
        jDataFinal.setBackground(Color.WHITE);
        jMesReferencia.setBackground(Color.WHITE);
        jAnoReferencia.setBackground(Color.WHITE);
        jComboBoxTipoCronograma.setBackground(Color.WHITE);
    }

    public void pBUSCAR_DADOS_crono() {
        pPESQUISAR_colaborador.MOSTRAR_DADOS_CRONOGRAMA_gravado(objEscalas);
        jIdColaborador.setText(String.valueOf(objEscalas.getIdFunc()));
        jNomeColaborador.setText(objEscalas.getNomeFuncEscala());
        jDataInicial.setDate(objEscalas.getDataInicial());
        jDataFinal.setDate(objEscalas.getDataFinal());
        jMesReferencia.setText(objEscalas.getMesReferencia());
        jAnoReferencia.setText(objEscalas.getAnoReferencia());
        jComboBoxTipoCronograma.setSelectedItem(objEscalas.getTipoCronograma());
    }

    public void pENVIAR_DADOS_crono() {
        pPESQUISAR_colaborador.MOSTRAR_DADOS_CRONOGRAMA_gravadoMA(objEscalas);
        pID_REGISTRO = objEscalas.getIdRegistro();
        jCodigoFunc.setText(String.valueOf(objEscalas.getIdFunc()));
        jNomeColaboradorEscala.setText(objEscalas.getNomeFuncEscala());
        pID_ESCALA = objEscalas.getIdEscala();
        jEscala.setText(objEscalas.getDescricaoEscala());
        jQuantTrabalho.setText(String.valueOf(objEscalas.getQuantidadeTrab()));
        jQuantFolga.setText(String.valueOf(objEscalas.getQuantidadeFolga()));
        jTurnoEscala.setText(objEscalas.getTurno());
        jTurmaEscala.setText(objEscalas.getTurma());
        jComboBoxPrimeiroApt.setSelectedItem(objEscalas.getPrimeiroApt());
        jComboBoxSegundoApt.setSelectedItem(objEscalas.getSegundoApt());
        jDataInicialCronograma.setDate(objEscalas.getDataInicial());
        jDataFinalCronograma.setDate(objEscalas.getDataFinal());
        jDataPrimeiraFolga.setDate(objEscalas.getDataPrimeiraFolga());
        jDepartamentoEscala.setText(jDepartamento.getText());
        jCargo.setText(jNomeCargo.getText());
        jComboBoxMesReferencia.setSelectedItem(objEscalas.getMesReferencia());
        jComboBoxAnoReferencia.setSelectedItem(objEscalas.getAnoReferencia());
        jComboBoxTipoCronograma.setSelectedItem(objEscalas.getTipoCronograma());
    }

    public void PESQUISAR_TODOS_registros() {
        DefaultTableModel dadosOrigem = (DefaultTableModel) jTabelaCronograma.getModel();
        try {
            for (EscalaFolgas dd : pPESQUISAR_todosReg.read()) {
                pDATA_inicial = String.valueOf(dd.getDataInicial());
                String dia = pDATA_inicial.substring(8, 10);
                String mes = pDATA_inicial.substring(5, 7);
                String ano = pDATA_inicial.substring(0, 4);
                pDATA_inicial = dia + "/" + mes + "/" + ano;
                //
                pDATA_final = String.valueOf(dd.getDataFinal());
                String diaF = pDATA_final.substring(8, 10);
                String mesF = pDATA_final.substring(5, 7);
                String anoF = pDATA_final.substring(0, 4);
                pDATA_final = diaF + "/" + mesF + "/" + anoF;
                jtotalRegistros.setText(Integer.toString(pTOTAL_registros));
                dadosOrigem.addRow(new Object[]{dd.getIdFunc(), dd.getNomeFuncEscala(), pDATA_inicial, pDATA_final, dd.getMesReferencia(), dd.getAnoReferencia()});
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaCronograma.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaCronograma.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                jTabelaCronograma.getColumnModel().getColumn(2).setCellRenderer(centralizado);
                jTabelaCronograma.getColumnModel().getColumn(3).setCellRenderer(centralizado);
                jTabelaCronograma.getColumnModel().getColumn(4).setCellRenderer(centralizado);
                jTabelaCronograma.getColumnModel().getColumn(5).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaPesquisaCronogramaEscala.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void LIMPAR_tabela() {
        // APAGAR DADOS DA TABELA
        while (jTabelaCronograma.getModel().getRowCount() > 0) {
            ((DefaultTableModel) jTabelaCronograma.getModel()).removeRow(0);
        }
        jtotalRegistros.setText("");
    }
}
