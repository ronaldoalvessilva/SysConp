/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Dao.*;
import static gestor.Visao.TelaPopulacao.jBrasHomenAberto;
import static gestor.Visao.TelaPopulacao.jBrasHomenFechado;
import static gestor.Visao.TelaPopulacao.jBrasHomenProvisorio;
import static gestor.Visao.TelaPopulacao.jBrasHomenSemi;
import static gestor.Visao.TelaPopulacao.jBrasMulheresAberto;
import static gestor.Visao.TelaPopulacao.jBrasMulheresFechado;
import static gestor.Visao.TelaPopulacao.jBrasMulheresProvisorio;
import static gestor.Visao.TelaPopulacao.jBrasMulheresSemi;
import static gestor.Visao.TelaPopulacao.jBrasMulheresTotal;
import static gestor.Visao.TelaPopulacao.jBtAlterar;
import static gestor.Visao.TelaPopulacao.jBtAuditoria;
import static gestor.Visao.TelaPopulacao.jBtCancelar;
import static gestor.Visao.TelaPopulacao.jBtExcluir;
import static gestor.Visao.TelaPopulacao.jBtFinalizar;
import static gestor.Visao.TelaPopulacao.jBtNovo;
import static gestor.Visao.TelaPopulacao.jBtSalvar;
import static gestor.Visao.TelaPopulacao.jDataPop;
import static gestor.Visao.TelaPopulacao.jEstaHomeAberto;
import static gestor.Visao.TelaPopulacao.jEstraHomeSemi;
import static gestor.Visao.TelaPopulacao.jEstranHomeFechado;
import static gestor.Visao.TelaPopulacao.jEstranHomeProvisorio;
import static gestor.Visao.TelaPopulacao.jEstranMulherAberto;
import static gestor.Visao.TelaPopulacao.jEstranMulherFechado;
import static gestor.Visao.TelaPopulacao.jEstranMulherProvisorio;
import static gestor.Visao.TelaPopulacao.jEstranMulherSemi;
import static gestor.Visao.TelaPopulacao.jEstranTotalHomem;
import static gestor.Visao.TelaPopulacao.jIdPop;
import static gestor.Visao.TelaPopulacao.jPopAgenteFem;
import static gestor.Visao.TelaPopulacao.jPopAgenteMasc;
import static gestor.Visao.TelaPopulacao.jPopMotoristas;
import static gestor.Visao.TelaPopulacao.jStatusPop;
import static gestor.Visao.TelaPopulacao.jTotalBrasHomens;
import static gestor.Visao.TelaPopulacao.jTotalEstranMulheres;
import static gestor.Visao.TelaPopulacao.jTotalGeralAgentes;
import static gestor.Visao.TelaPopulacao.jTotalGeralPopInternos;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Ronaldo
 */
public class TelaPesquisaPopulacao extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    int flag;
    String dataPopulacao;
    String dataInicial;
    String dataFinal;

    /**
     * Creates new form TelaPesquisaCidade
     */
    public TelaPesquisaPopulacao() {
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

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jBtData = new javax.swing.JButton();
        jPesDtPopFinal = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jPesDtPopInicial = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jIDPesPop = new javax.swing.JTextField();
        jBtPesqID = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaPopulacao = new javax.swing.JTable();
        jBtEnviar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        setClosable(true);
        setTitle("...::: Pesquisar População :::...");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisar População", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 51, 255))); // NOI18N

        jBtData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtData.setToolTipText("Pesquisa por Nome");
        jBtData.setContentAreaFilled(false);
        jBtData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtDataActionPerformed(evt);
            }
        });

        jPesDtPopFinal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("De:");

        jPesDtPopInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Até");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Código:");

        jIDPesPop.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIDPesPop.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqID.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqID.setContentAreaFilled(false);
        jBtPesqID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqIDActionPerformed(evt);
            }
        });

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox1.setText("Todos");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jIDPesPop, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                    .addComponent(jPesDtPopInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtPesqID, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPesDtPopFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtData, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, Short.MAX_VALUE)
                .addComponent(jCheckBox1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4)
                    .addComponent(jIDPesPop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqID, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jCheckBox1)
                    .addComponent(jBtData)
                    .addComponent(jPesDtPopFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jPesDtPopInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaPopulacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaPopulacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Código", "Data População", "Total Agentes", "Total Internos"
            }
        ));
        jTabelaPopulacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaPopulacaoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaPopulacao);
        if (jTabelaPopulacao.getColumnModel().getColumnCount() > 0) {
            jTabelaPopulacao.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaPopulacao.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaPopulacao.getColumnModel().getColumn(1).setMinWidth(100);
            jTabelaPopulacao.getColumnModel().getColumn(1).setMaxWidth(100);
            jTabelaPopulacao.getColumnModel().getColumn(2).setMinWidth(110);
            jTabelaPopulacao.getColumnModel().getColumn(2).setMaxWidth(110);
            jTabelaPopulacao.getColumnModel().getColumn(3).setMinWidth(110);
            jTabelaPopulacao.getColumnModel().getColumn(3).setMaxWidth(110);
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
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtEnviar)
                    .addComponent(jBtSair))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBounds(300, 150, 427, 288);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtDataActionPerformed
        flag = 1;
        if (jPesDtPopInicial.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Data inicial não pode ser em branco.");
            jPesDtPopInicial.requestFocus();
        } else {
            if (jPesDtPopFinal.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Data final não pode ser em branco.");
                jPesDtPopFinal.requestFocus();
            } else {
                if (jPesDtPopInicial.getDate().after(jPesDtPopFinal.getDate())) {
                    JOptionPane.showMessageDialog(rootPane, "Data Inicial não pode ser maior que data final.");
                } else {
                    SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
                    dataInicial = formatoAmerica.format(jPesDtPopInicial.getDate().getTime());
                    dataFinal = formatoAmerica.format(jPesDtPopFinal.getDate().getTime());                    
                    preencherTabelaNome("SELECT * FROM MOVPOPULACAO WHERE DataPopMov BETWEEN'" + dataInicial + "'AND '" + dataFinal + "'");
                }
            }
        }
    }//GEN-LAST:event_jBtDataActionPerformed

    private void jBtEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtEnviarActionPerformed
        // TODO add your handling code here:
        if (jIDPesPop.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma data' e clique no botão ENVIAR");
        } else if (flag == 1) {
            String idPopMov = "" + jTabelaPopulacao.getValueAt(jTabelaPopulacao.getSelectedRow(), 0);
            jIDPesPop.setText(idPopMov);
            //
            jBtNovo.setEnabled(!true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM MOVPOPULACAO "
                        + "INNER JOIN POPESTRANGMASC "
                        + "ON MOVPOPULACAO.IdPopMov=POPESTRANGMASC.IdPopMov "
                        + "INNER JOIN POPESTRANGFEM "
                        + "ON MOVPOPULACAO.IdPopMov=POPESTRANGFEM.IdPopMov "
                        + "INNER JOIN POPBRASMASC ON MOVPOPULACAO.IdPopMov=POPBRASMASC.IdPopMov "
                        + "INNER JOIN POPBRASFEM "
                        + "ON MOVPOPULACAO.IdPopMov=POPBRASFEM.IdPopMov "
                        + "INNER JOIN POPAGENTES "
                        + "ON MOVPOPULACAO.IdPopMov=POPAGENTES.IdPopMov "
                        + "WHERE MOVPOPULACAO.IdPopMov='" + jIDPesPop.getText() + "'");
                conecta.rs.first();
                // Tabela Movimento de População
                jIdPop.setText(conecta.rs.getString("IdPopMov"));
                jDataPop.setDate(conecta.rs.getDate("DataPopMov"));
                jStatusPop.setText(conecta.rs.getString("StatusPop"));
                // Tabela de Estrangeiros masculino
                jEstranHomeFechado.setText(conecta.rs.getString("EstraHomenFec"));
                jEstraHomeSemi.setText(conecta.rs.getString("EstraHomenSem"));
                jEstaHomeAberto.setText(conecta.rs.getString("EstraHomenAbe"));
                jEstranHomeProvisorio.setText(conecta.rs.getString("EstraHomenPro"));
                jEstranTotalHomem.setText(conecta.rs.getString("TotalGeralMasc"));
                // Tabela de Estrangeiros masculino
                jEstranMulherFechado.setText(conecta.rs.getString("EstraMulherFec"));
                jEstranMulherSemi.setText(conecta.rs.getString("EstraMulherSem"));
                jEstranMulherAberto.setText(conecta.rs.getString("EstraMulherAbe"));
                jEstranMulherProvisorio.setText(conecta.rs.getString("EstraMulherPro"));
                jTotalEstranMulheres.setText(conecta.rs.getString("TotalGeralFem"));
                // Tabela de Brasileiros masculino
                jBrasHomenFechado.setText(conecta.rs.getString("BrasHomemFec"));
                jBrasHomenSemi.setText(conecta.rs.getString("BrasHomemSem"));
                jBrasHomenAberto.setText(conecta.rs.getString("BrasHomemAbe"));
                jBrasHomenProvisorio.setText(conecta.rs.getString("BrasHomemPro"));
                jTotalBrasHomens.setText(conecta.rs.getString("TotalGeralBrasMasc"));
                // Tabela de Brasileiros feminino
                jBrasMulheresFechado.setText(conecta.rs.getString("BrasMulherFec"));
                jBrasMulheresSemi.setText(conecta.rs.getString("BrasMulherSem"));
                jBrasMulheresAberto.setText(conecta.rs.getString("BrasMulherAbe"));
                jBrasMulheresProvisorio.setText(conecta.rs.getString("BrasMulherPro"));
                jBrasMulheresTotal.setText(conecta.rs.getString("TotalGeralBrasFem"));
                // Tabela de agentes
                jPopAgenteMasc.setText(conecta.rs.getString("AgenteMasc"));
                jPopAgenteFem.setText(conecta.rs.getString("AgenteFem"));
                jPopMotoristas.setText(conecta.rs.getString("Motoristas"));
                // Tabela de Movimento População
                jTotalGeralPopInternos.setText(conecta.rs.getString("TotalGeralInternos"));
                jTotalGeralAgentes.setText(conecta.rs.getString("TotalGeralAgentes"));
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não foi possível realizar a pesquisa.\nERRO: " + ex);
            }
            dispose();
        }
    }//GEN-LAST:event_jBtEnviarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jTabelaPopulacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaPopulacaoMouseClicked
        // TODO add your handling code here:      
        if (flag == 1) {
            String idPopMov = "" + jTabelaPopulacao.getValueAt(jTabelaPopulacao.getSelectedRow(), 0);
            jIDPesPop.setText(idPopMov);
        }
    }//GEN-LAST:event_jTabelaPopulacaoMouseClicked

    private void jBtPesqIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqIDActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (jIDPesPop.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Selecione um ID e clique no botão ENVIAR");
        } else {
            preencherTabelaID("SELECT * FROM MOVPOPULACAO "
                    + "INNER JOIN POPESTRANGMASC "
                    + "ON MOVPOPULACAO.IdPopMov=POPESTRANGMASC.IdPopMov "
                    + "INNER JOIN POPESTRANGFEM "
                    + "ON MOVPOPULACAO.IdPopMov=POPESTRANGFEM.IdPopMov "
                    + "INNER JOIN POPBRASMASC "
                    + "ON MOVPOPULACAO.IdPopMov=POPBRASMASC.IdPopMov "
                    + "INNER JOIN POPBRASFEM "
                    + "ON MOVPOPULACAO.IdPopMov=POPBRASFEM.IdPopMov "
                    + "INNER JOIN POPAGENTES "
                    + "ON MOVPOPULACAO.IdPopMov=POPAGENTES.IdPopMov "
                    + "WHERE MOVPOPULACAO.IdPopMov='" + jIDPesPop.getText() + "'");
        }
    }//GEN-LAST:event_jBtPesqIDActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {            
            this.preencherTabela();
        } else {
            limparTabela();
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtData;
    private javax.swing.JButton jBtEnviar;
    private javax.swing.JButton jBtPesqID;
    private javax.swing.JButton jBtSair;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JTextField jIDPesPop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private com.toedter.calendar.JDateChooser jPesDtPopFinal;
    private com.toedter.calendar.JDateChooser jPesDtPopInicial;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabelaPopulacao;
    // End of variables declaration//GEN-END:variables

    public void preencherTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data População", "Total Agentes", "Total Internos"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM MOVPOPULACAO "
                    + "INNER JOIN POPESTRANGMASC "
                    + "ON MOVPOPULACAO.IdPopMov=POPESTRANGMASC.IdPopMov "
                    + "INNER JOIN POPESTRANGFEM "
                    + "ON MOVPOPULACAO.IdPopMov=POPESTRANGFEM.IdPopMov "
                    + "INNER JOIN POPBRASMASC "
                    + "ON MOVPOPULACAO.IdPopMov=POPBRASMASC.IdPopMov "
                    + "INNER JOIN POPBRASFEM "
                    + "ON MOVPOPULACAO.IdPopMov=POPBRASFEM.IdPopMov "
                    + "INNER JOIN POPAGENTES "
                    + "ON MOVPOPULACAO.IdPopMov=POPAGENTES.IdPopMov");
            conecta.rs.first();
            do {
                // Formatar a data População
                dataPopulacao = conecta.rs.getString("DataPopMov");
                String dia = dataPopulacao.substring(8, 10);
                String mes = dataPopulacao.substring(5, 7);
                String ano = dataPopulacao.substring(0, 4);
                dataPopulacao = dia + "/" + mes + "/" + ano;
                dados.add(new Object[]{conecta.rs.getInt("IdPopMov"), dataPopulacao, conecta.rs.getInt("TotalGeralAgentes"), conecta.rs.getInt("TotalGeralInternos")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Dados não encontrado, use o botão TODOS \nPara pesquisar TODOS OS REGISTROS");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPopulacao.setModel(modelo);
        jTabelaPopulacao.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaPopulacao.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPopulacao.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTabelaPopulacao.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPopulacao.getColumnModel().getColumn(2).setPreferredWidth(120);
        jTabelaPopulacao.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPopulacao.getColumnModel().getColumn(3).setPreferredWidth(110);
        jTabelaPopulacao.getColumnModel().getColumn(3).setResizable(false);
        jTabelaPopulacao.getTableHeader().setReorderingAllowed(false);
        jTabelaPopulacao.setAutoResizeMode(jTabelaPopulacao.AUTO_RESIZE_OFF);
        jTabelaPopulacao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCampos();
        conecta.desconecta();
    }

    public void preencherTabelaNome(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data População", "Total Agentes", "Total Internos"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dataPopulacao = conecta.rs.getString("DataPopMov");
                String dia = dataPopulacao.substring(8, 10);
                String mes = dataPopulacao.substring(5, 7);
                String ano = dataPopulacao.substring(0, 4);
                dataPopulacao = dia + "/" + mes + "/" + ano;
                dados.add(new Object[]{conecta.rs.getInt("IdPopMov"), dataPopulacao, conecta.rs.getInt("TotalGeralAgentes"), conecta.rs.getInt("TotalGeralInternos")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Dados não encontrado, use o botão TODOS \nPara pesquisar TODOS OS REGISTROS");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPopulacao.setModel(modelo);
        jTabelaPopulacao.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaPopulacao.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPopulacao.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTabelaPopulacao.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPopulacao.getColumnModel().getColumn(2).setPreferredWidth(110);
        jTabelaPopulacao.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPopulacao.getColumnModel().getColumn(3).setPreferredWidth(110);
        jTabelaPopulacao.getColumnModel().getColumn(3).setResizable(false);
        jTabelaPopulacao.getTableHeader().setReorderingAllowed(false);
        jTabelaPopulacao.setAutoResizeMode(jTabelaPopulacao.AUTO_RESIZE_OFF);
        jTabelaPopulacao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCampos();
        conecta.desconecta();
    }

    // Método de pesquisa pela Descrição
    public void preencherTabelaID(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data População", "Total Agentes", "Total Internos"};
        conecta.abrirConexao();
        conecta.executaSQL(sql);
        try {
            conecta.rs.first();
            do {
                dataPopulacao = conecta.rs.getString("DataPopMov");
                String dia = dataPopulacao.substring(8, 10);
                String mes = dataPopulacao.substring(5, 7);
                String ano = dataPopulacao.substring(0, 4);
                dataPopulacao = dia + "/" + mes + "/" + ano;
                dados.add(new Object[]{conecta.rs.getInt("IdPopMov"), dataPopulacao, conecta.rs.getInt("TotalGeralAgentes"), conecta.rs.getInt("TotalGeralInternos")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Dados não encontrado, use o botão TODOS \nPara pesquisar TODOS OS REGISTROS");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPopulacao.setModel(modelo);
        jTabelaPopulacao.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaPopulacao.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPopulacao.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTabelaPopulacao.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPopulacao.getColumnModel().getColumn(2).setPreferredWidth(110);
        jTabelaPopulacao.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPopulacao.getColumnModel().getColumn(3).setPreferredWidth(110);
        jTabelaPopulacao.getColumnModel().getColumn(3).setResizable(false);
        jTabelaPopulacao.getTableHeader().setReorderingAllowed(false);
        jTabelaPopulacao.setAutoResizeMode(jTabelaPopulacao.AUTO_RESIZE_OFF);
        jTabelaPopulacao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCampos();
        conecta.desconecta();
    }

    public void limparTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data População", "Total Agentes", "Total Internos"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPopulacao.setModel(modelo);
        jTabelaPopulacao.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaPopulacao.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPopulacao.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTabelaPopulacao.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPopulacao.getColumnModel().getColumn(2).setPreferredWidth(110);
        jTabelaPopulacao.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPopulacao.getColumnModel().getColumn(3).setPreferredWidth(110);
        jTabelaPopulacao.getColumnModel().getColumn(3).setResizable(false);
        jTabelaPopulacao.getTableHeader().setReorderingAllowed(false);
        jTabelaPopulacao.setAutoResizeMode(jTabelaPopulacao.AUTO_RESIZE_OFF);
        jTabelaPopulacao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCampos() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaPopulacao.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaPopulacao.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaPopulacao.getColumnModel().getColumn(2).setCellRenderer(direita);
        jTabelaPopulacao.getColumnModel().getColumn(3).setCellRenderer(direita);
    }
}
