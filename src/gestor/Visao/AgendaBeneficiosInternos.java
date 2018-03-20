/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleAgendaBeneficiosInternos;
import gestor.Controle.ControleItensAgendaBeneficiaria;
import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.ModeloTabela;
import gestor.Modelo.AgendaBeneficioInternos;
import gestor.Modelo.ItensAgendaBeneficioInternos;
import static gestor.Visao.TelaAtendimentoJuridico.jIDInternoJuridico;
import static gestor.Visao.TelaAtendimentoJuridico.jNomeInternoJuridico;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
 
/**
 *
 * @author ronaldo
 */
public class AgendaBeneficiosInternos extends javax.swing.JDialog {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AgendaBeneficioInternos objAgendaBene = new AgendaBeneficioInternos();
    ControleAgendaBeneficiosInternos control = new ControleAgendaBeneficiosInternos();
    ItensAgendaBeneficioInternos objItens = new ItensAgendaBeneficioInternos();
    ControleItensAgendaBeneficiaria controleItens = new ControleItensAgendaBeneficiaria();
    //
    //
    String statusMov;
    String horaMov;
    String dataModFinal;
    String dataAgenda;
    /**
     * Creates new form AgendaBenecidosInternos
     */
    public static TelaAtendimentoJuridico atendeJru;

    public AgendaBeneficiosInternos(TelaAtendimentoJuridico parent, boolean modal) {
        this.atendeJru = parent;
        this.setModal(modal);
        setLocationRelativeTo(atendeJru);
        initComponents();
        corCampos();
        mostrarInterno();
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
        jIdRegistro = new javax.swing.JTextField();
        jComboBoxStatusRegistro = new javax.swing.JComboBox();
        jDataRegistro = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaAgendamentoBeneficio = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jIdInternoCrcAg = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jNomeInternoCrcAgenda = new javax.swing.JTextField();
        jComboBoxBeneficio = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jDataAgendamento = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jBtSalvar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("...::: Agendamento de Benefícios :::...");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Status");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Data Doc.");

        jIdRegistro.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdRegistro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdRegistro.setEnabled(false);

        jComboBoxStatusRegistro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxStatusRegistro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não Realizado", "Realizado" }));
        jComboBoxStatusRegistro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxStatusRegistro.setEnabled(false);

        jDataRegistro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataRegistro.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jIdRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jComboBoxStatusRegistro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDataRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIdRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxStatusRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jTabelaAgendamentoBeneficio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaAgendamentoBeneficio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Código", "Nome do Interno", "Data Agenda", "Tipo Benefício"
            }
        ));
        jTabelaAgendamentoBeneficio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaAgendamentoBeneficioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaAgendamentoBeneficio);
        if (jTabelaAgendamentoBeneficio.getColumnModel().getColumnCount() > 0) {
            jTabelaAgendamentoBeneficio.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaAgendamentoBeneficio.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaAgendamentoBeneficio.getColumnModel().getColumn(1).setMinWidth(270);
            jTabelaAgendamentoBeneficio.getColumnModel().getColumn(1).setMaxWidth(270);
            jTabelaAgendamentoBeneficio.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaAgendamentoBeneficio.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaAgendamentoBeneficio.getColumnModel().getColumn(3).setMinWidth(150);
            jTabelaAgendamentoBeneficio.getColumnModel().getColumn(3).setMaxWidth(150);
        }

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Código");

        jIdInternoCrcAg.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdInternoCrcAg.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdInternoCrcAg.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Nome Completo do Interno");

        jNomeInternoCrcAgenda.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoCrcAgenda.setEnabled(false);

        jComboBoxBeneficio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxBeneficio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Saída Temporária", "Progressão de Regime", "Livramento Condicional", "Alvará de Soltura" }));
        jComboBoxBeneficio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxBeneficio.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Tipo de Benefício");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Data Agenda");

        jDataAgendamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataAgendamento.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jIdInternoCrcAg, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jNomeInternoCrcAgenda)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jComboBoxBeneficio, 0, 262, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDataAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jNomeInternoCrcAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdInternoCrcAg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxBeneficio, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jBtSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvar.setEnabled(false);
        jBtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarActionPerformed(evt);
            }
        });

        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
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
                .addComponent(jBtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtSair, jBtSalvar});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(jBtSalvar, javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jBtSair, javax.swing.GroupLayout.Alignment.TRAILING))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtSair, jBtSalvar});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        if (jDataAgendamento.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Informe a data do Agendamento.");
        } else {
            objAgendaBene.setStatusReg((String) jComboBoxStatusRegistro.getSelectedItem());
            objAgendaBene.setDataReg(jDataRegistro.getDate());
            objAgendaBene.setTipoBeneficio((String) jComboBoxBeneficio.getSelectedItem());
            objAgendaBene.setDataAg(jDataAgendamento.getDate());
            objAgendaBene.setUsuarioInsert(nameUser);
            objAgendaBene.setDataInsert(dataModFinal);
            objAgendaBene.setHorarioInsert(horaMov);
            control.incluirAgendaBeneicios(objAgendaBene);
            buscarCodigo();
            objItens.setIdReg(Integer.valueOf(jIdRegistro.getText()));
            objItens.setNomeInternoAgenda(jNomeInternoCrcAgenda.getText());
            objItens.setUsuarioInsert(nameUser);
            objItens.setDataInsert(dataModFinal);
            objItens.setHorarioInsert(horaMov);
            controleItens.incluirItensInterno(objItens);
            Salvar();
            preencherTabelaAgenda("SELECT * FROM ITENS_AGENDA_BENEFICIO_INTERNOS "
                    + "INNER JOIN AGENDA_BENEFICIO_INTERNOS "
                    + "ON ITENS_AGENDA_BENEFICIO_INTERNOS.IdReg=AGENDA_BENEFICIO_INTERNOS.IdReg "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENS_AGENDA_BENEFICIO_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE ITENS_AGENDA_BENEFICIO_INTERNOS.IdReg='" + jIdRegistro.getText() + "'");
        }
    }//GEN-LAST:event_jBtSalvarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jTabelaAgendamentoBeneficioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaAgendamentoBeneficioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabelaAgendamentoBeneficioMouseClicked

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
            java.util.logging.Logger.getLogger(AgendaBeneficiosInternos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgendaBeneficiosInternos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgendaBeneficiosInternos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgendaBeneficiosInternos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AgendaBeneficiosInternos dialog = new AgendaBeneficiosInternos(atendeJru, true);
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
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JComboBox jComboBoxBeneficio;
    private javax.swing.JComboBox jComboBoxStatusRegistro;
    private com.toedter.calendar.JDateChooser jDataAgendamento;
    private com.toedter.calendar.JDateChooser jDataRegistro;
    public static javax.swing.JTextField jIdInternoCrcAg;
    private javax.swing.JTextField jIdRegistro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public static javax.swing.JTextField jNomeInternoCrcAgenda;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabelaAgendamentoBeneficio;
    // End of variables declaration//GEN-END:variables

    public void corCampos() {
        jIdRegistro.setBackground(Color.white);
        jComboBoxStatusRegistro.setBackground(Color.white);
        jDataRegistro.setBackground(Color.white);
        jIdInternoCrcAg.setBackground(Color.white);
        jNomeInternoCrcAgenda.setBackground(Color.white);
        jComboBoxBeneficio.setBackground(Color.white);
        jDataAgendamento.setBackground(Color.white);
    }

    public void mostrarInterno() {
        jIdInternoCrcAg.setText(jIDInternoJuridico.getText());
        jNomeInternoCrcAgenda.setText(jNomeInternoJuridico.getText());
        jDataRegistro.setCalendar(Calendar.getInstance());
        //
        jComboBoxBeneficio.setEnabled(true);
        jDataAgendamento.setEnabled(true);
        //
        jBtSalvar.setEnabled(true);
        //
        statusMov = "Agendou";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
    }

    public void Salvar() {
        jComboBoxBeneficio.setEnabled(!true);
        jDataAgendamento.setEnabled(!true);
        //
        jBtSalvar.setEnabled(!true);
    }

    public void buscarCodigo() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM AGENDA_BENEFICIO_INTERNOS");
            conecta.rs.last();
            jIdRegistro.setText(conecta.rs.getString("IdReg"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter o código do registro.");
        }
        conecta.desconecta();
    }

    public void preencherTabelaAgenda(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome do Interno", "Data Agenda", "Tipo Benefício"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                // Formatar a data Entrada
                dataAgenda = conecta.rs.getString("DataAg");
                String diae = dataAgenda.substring(8, 10);
                String mese = dataAgenda.substring(5, 7);
                String anoe = dataAgenda.substring(0, 4);
                dataAgenda = diae + "/" + mese + "/" + anoe;
                dados.add(new Object[]{conecta.rs.getInt("IdInternoCrc"), conecta.rs.getString("NomeInternoCrc"), dataAgenda, conecta.rs.getString("TipoBeneficio")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaAgendamentoBeneficio.setModel(modelo);
        jTabelaAgendamentoBeneficio.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaAgendamentoBeneficio.getColumnModel().getColumn(0).setResizable(false);
        jTabelaAgendamentoBeneficio.getColumnModel().getColumn(1).setPreferredWidth(270);
        jTabelaAgendamentoBeneficio.getColumnModel().getColumn(1).setResizable(false);
        jTabelaAgendamentoBeneficio.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaAgendamentoBeneficio.getColumnModel().getColumn(2).setResizable(false);
        jTabelaAgendamentoBeneficio.getColumnModel().getColumn(3).setPreferredWidth(150);
        jTabelaAgendamentoBeneficio.getColumnModel().getColumn(3).setResizable(false);
        jTabelaAgendamentoBeneficio.getTableHeader().setReorderingAllowed(false);
        jTabelaAgendamentoBeneficio.setAutoResizeMode(jTabelaAgendamentoBeneficio.AUTO_RESIZE_OFF);
        jTabelaAgendamentoBeneficio.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharTabelaAgenda();
        conecta.desconecta();
    }

    public void alinharTabelaAgenda() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaAgendamentoBeneficio.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaAgendamentoBeneficio.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }
}
