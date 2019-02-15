/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.ModeloTabela;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import java.awt.Color;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ronaldo
 */
public class TelaLogSistema extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    int flag;
    String dataInicial, dataFinal;

    /**
     * Creates new form TelaLogSistema
     */
    public TelaLogSistema() {
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jNomeModuloTela = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jHorarioMov = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jIdLanc = new javax.swing.JTextField();
        jNomeUsuario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jStatusMov = new javax.swing.JTextField();
        jDataMov = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jBtPesqNomeUsuario = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPesqNomeUsuario = new javax.swing.JTextField();
        jCheckBoxTodosLogs = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jDataInicial = new com.toedter.calendar.JDateChooser();
        jBtDataLog = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaLog = new javax.swing.JTable();
        jBtSair = new javax.swing.JButton();
        jBtImprimir = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Log do Sistema {CO} :::...");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Tela do Sistema");

        jNomeModuloTela.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeModuloTela.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jNomeModuloTela.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Data");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Horas");

        jHorarioMov.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jHorarioMov.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHorarioMov.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jHorarioMov.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Registro");

        jIdLanc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdLanc.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jIdLanc.setEnabled(false);

        jNomeUsuario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeUsuario.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jNomeUsuario.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Usuário");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Status");

        jStatusMov.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jStatusMov.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jStatusMov.setEnabled(false);

        jDataMov.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jDataMov.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataMov.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jDataMov.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jDataMov, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jHorarioMov, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jNomeUsuario)))
                    .addComponent(jLabel5)
                    .addComponent(jNomeModuloTela, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jStatusMov, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel6)
                        .addComponent(jIdLanc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jNomeModuloTela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jDataMov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jHorarioMov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jStatusMov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqNomeUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqNomeUsuario.setContentAreaFilled(false);
        jBtPesqNomeUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqNomeUsuarioActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Nome do Usuário:");

        jPesqNomeUsuario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jCheckBoxTodosLogs.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxTodosLogs.setText("Todos");
        jCheckBoxTodosLogs.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxTodosLogsItemStateChanged(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Data da Pesquisa:");

        jDataInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtDataLog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtDataLog.setContentAreaFilled(false);
        jBtDataLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtDataLogActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPesqNomeUsuario))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtDataLog, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtPesqNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxTodosLogs)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jCheckBoxTodosLogs)
                    .addComponent(jBtPesqNomeUsuario)
                    .addComponent(jPesqNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(2, 2, 2)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel8)
                    .addComponent(jDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtDataLog)))
        );

        jTabelaLog.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaLog.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Nome da Tela", "Data", "Hora", "Nome do Usuário", "Status"
            }
        ));
        jTabelaLog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaLogMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaLog);
        if (jTabelaLog.getColumnModel().getColumnCount() > 0) {
            jTabelaLog.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaLog.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaLog.getColumnModel().getColumn(1).setMinWidth(300);
            jTabelaLog.getColumnModel().getColumn(1).setMaxWidth(300);
            jTabelaLog.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaLog.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaLog.getColumnModel().getColumn(3).setMinWidth(70);
            jTabelaLog.getColumnModel().getColumn(3).setMaxWidth(70);
            jTabelaLog.getColumnModel().getColumn(4).setMinWidth(270);
            jTabelaLog.getColumnModel().getColumn(4).setMaxWidth(270);
            jTabelaLog.getColumnModel().getColumn(5).setMinWidth(70);
            jTabelaLog.getColumnModel().getColumn(5).setMaxWidth(70);
        }

        jBtSair.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtSair.setForeground(new java.awt.Color(255, 0, 0));
        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSair.setText("Sair");
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        jBtImprimir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtImprimir.setForeground(new java.awt.Color(153, 0, 51));
        jBtImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/gtklp-icone-3770-16.png"))); // NOI18N
        jBtImprimir.setText("Imprimir");

        jBtExcluir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtExcluir.setForeground(new java.awt.Color(51, 0, 255));
        jBtExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluir.setText("Excluir");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jBtImprimir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSair)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtExcluir, jBtImprimir, jBtSair});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtSair)
                    .addComponent(jBtImprimir)
                    .addComponent(jBtExcluir))
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtExcluir, jBtImprimir, jBtSair});

        jTabbedPane1.addTab("Pesquisas", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        setBounds(300, 10, 666, 510);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesqNomeUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNomeUsuarioActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (jPesqNomeUsuario.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o nome do usuário para pesquisar.");
        } else if (!jPesqNomeUsuario.getText().equals("") && jDataInicial.getDate() == null) {
            preencherTabelaInternos("SELECT * FROM LOGSISTEMA "
                    + "WHERE NomeUsuarioLogado LIKE'%" + jPesqNomeUsuario.getText() + "%'");
        } else if (!jPesqNomeUsuario.getText().equals("") && jDataInicial.getDate() != null) {
            SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
            dataInicial = formatoAmerica.format(jDataInicial.getDate().getTime());
            preencherTabelaInternos("SELECT * FROM LOGSISTEMA WHERE DataMov='" + dataInicial + "' "
                    + "AND NomeUsuarioLogado LIKE '%" + jPesqNomeUsuario.getText() + "%'");
        }
    }//GEN-LAST:event_jBtPesqNomeUsuarioActionPerformed

    private void jCheckBoxTodosLogsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxTodosLogsItemStateChanged
        // TODO add your handling code here:
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherTabelaInternos("SELECT * FROM LOGSISTEMA");
        } else {
            limparTabela();
        }
    }//GEN-LAST:event_jCheckBoxTodosLogsItemStateChanged

    private void jBtDataLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtDataLogActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (tipoServidor == null || tipoServidor.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "É necessário definir o parâmtero para o sistema operacional utilizado no servidor, (UBUNTU-LINUX ou WINDOWS SERVER).");
        } else if (tipoServidor.equals("Servidor Linux (Ubuntu)/MS-SQL Server")) {
            if (jDataInicial.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe uma data para pesquisa.");
                jDataInicial.requestFocus();
            } else if (jDataInicial.getDate() != null && jPesqNomeUsuario.getText().equals("")) {
                SimpleDateFormat formatoAmerica = new SimpleDateFormat("yyyy/MM/dd");
                dataInicial = formatoAmerica.format(jDataInicial.getDate().getTime());
                preencherTabelaInternos("SELECT * FROM LOGSISTEMA "
                        + "WHERE DataMov='" + dataInicial + "'");
            } else if (!jPesqNomeUsuario.getText().equals("")) {
                SimpleDateFormat formatoAmerica = new SimpleDateFormat("yyyy/MM/dd");
                dataInicial = formatoAmerica.format(jDataInicial.getDate().getTime());
                preencherTabelaInternos("SELECT * FROM LOGSISTEMA "
                        + "WHERE DataMov='" + dataInicial + "' "
                        + "AND NomeUsuarioLogado LIKE '%" + jPesqNomeUsuario.getText() + "%'");
            }
        } else if (tipoServidor.equals("Servidor Windows/MS-SQL Server")) {
            if (jDataInicial.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe uma data para pesquisa.");
                jDataInicial.requestFocus();
            } else if (jDataInicial.getDate() != null && jPesqNomeUsuario.getText().equals("")) {
                SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
                dataInicial = formatoAmerica.format(jDataInicial.getDate().getTime());
                preencherTabelaInternos("SELECT * FROM LOGSISTEMA "
                        + "WHERE DataMov='" + dataInicial + "'");
            } else if (!jPesqNomeUsuario.getText().equals("")) {
                SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
                dataInicial = formatoAmerica.format(jDataInicial.getDate().getTime());
                preencherTabelaInternos("SELECT * FROM LOGSISTEMA "
                        + "WHERE DataMov='" + dataInicial + "' "
                        + "AND NomeUsuarioLogado LIKE '%" + jPesqNomeUsuario.getText() + "%'");
            }
        }
    }//GEN-LAST:event_jBtDataLogActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jTabelaLogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaLogMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            String nomeUsuario = "" + jTabelaLog.getValueAt(jTabelaLog.getSelectedRow(), 4);
            jPesqNomeUsuario.setText(nomeUsuario);
            String idLog = "" + jTabelaLog.getValueAt(jTabelaLog.getSelectedRow(), 0);
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM LOGSISTEMA WHERE IdLog='" + idLog + "'");
                conecta.rs.first();
                jNomeModuloTela.setText(conecta.rs.getString("NomeModuloTela"));
                jIdLanc.setText(conecta.rs.getString("IdLancMov"));
                jDataMov.setText(conecta.rs.getString("DataMov"));
                jHorarioMov.setText(conecta.rs.getString("HorarioMov"));
                jNomeUsuario.setText(conecta.rs.getString("NomeUsuarioLogado"));
                jStatusMov.setText(conecta.rs.getString("StatusMov"));
                conecta.desconecta();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa por nome" + e);
            }
        }
    }//GEN-LAST:event_jTabelaLogMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtDataLog;
    private javax.swing.JButton jBtExcluir;
    private javax.swing.JButton jBtImprimir;
    private javax.swing.JButton jBtPesqNomeUsuario;
    private javax.swing.JButton jBtSair;
    private javax.swing.JCheckBox jCheckBoxTodosLogs;
    private com.toedter.calendar.JDateChooser jDataInicial;
    private javax.swing.JTextField jDataMov;
    private javax.swing.JTextField jHorarioMov;
    private javax.swing.JTextField jIdLanc;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jNomeModuloTela;
    private javax.swing.JTextField jNomeUsuario;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTextField jPesqNomeUsuario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jStatusMov;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTabelaLog;
    // End of variables declaration//GEN-END:variables

    public void corCampos() {
        //  jIdLog.setBackground(Color.white);
        jNomeModuloTela.setBackground(Color.white);
        jIdLanc.setBackground(Color.white);
        jDataMov.setBackground(Color.white);
        jHorarioMov.setBackground(Color.white);
        jNomeUsuario.setBackground(Color.white);
        jStatusMov.setBackground(Color.white);
    }

    public void preencherTabelaInternos(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome da Tela", "Data", "Hora", "Nome do Usuário", "Status"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdLog"), conecta.rs.getString("NomeModuloTela"), conecta.rs.getString("DataMov"), conecta.rs.getString("HorarioMov"), conecta.rs.getString("NomeUsuarioLogado"), conecta.rs.getString("StatusMov")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaLog.setModel(modelo);
        jTabelaLog.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaLog.getColumnModel().getColumn(0).setResizable(false);
        jTabelaLog.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTabelaLog.getColumnModel().getColumn(1).setResizable(false);
        jTabelaLog.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaLog.getColumnModel().getColumn(2).setResizable(false);
        jTabelaLog.getColumnModel().getColumn(3).setPreferredWidth(60);
        jTabelaLog.getColumnModel().getColumn(3).setResizable(false);
        jTabelaLog.getColumnModel().getColumn(4).setPreferredWidth(270);
        jTabelaLog.getColumnModel().getColumn(4).setResizable(false);
        jTabelaLog.getColumnModel().getColumn(5).setPreferredWidth(70);
        jTabelaLog.getColumnModel().getColumn(5).setResizable(false);
        jTabelaLog.getTableHeader().setReorderingAllowed(false);
        jTabelaLog.setAutoResizeMode(jTabelaLog.AUTO_RESIZE_OFF);
        jTabelaLog.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaLog();
        conecta.desconecta();
    }

    public void limparTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome da Tela", "Data", "Hora", "Nome do Usuário", "Status"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaLog.setModel(modelo);
        jTabelaLog.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaLog.getColumnModel().getColumn(0).setResizable(false);
        jTabelaLog.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTabelaLog.getColumnModel().getColumn(1).setResizable(false);
        jTabelaLog.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaLog.getColumnModel().getColumn(2).setResizable(false);
        jTabelaLog.getColumnModel().getColumn(3).setPreferredWidth(60);
        jTabelaLog.getColumnModel().getColumn(3).setResizable(false);
        jTabelaLog.getColumnModel().getColumn(4).setPreferredWidth(270);
        jTabelaLog.getColumnModel().getColumn(4).setResizable(false);
        jTabelaLog.getColumnModel().getColumn(5).setPreferredWidth(70);
        jTabelaLog.getColumnModel().getColumn(5).setResizable(false);
        jTabelaLog.getTableHeader().setReorderingAllowed(false);
        jTabelaLog.setAutoResizeMode(jTabelaLog.AUTO_RESIZE_OFF);
        jTabelaLog.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public void alinharCamposTabelaLog() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaLog.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaLog.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        jTabelaLog.getColumnModel().getColumn(3).setCellRenderer(centralizado);
        jTabelaLog.getColumnModel().getColumn(5).setCellRenderer(centralizado);
    }
}
