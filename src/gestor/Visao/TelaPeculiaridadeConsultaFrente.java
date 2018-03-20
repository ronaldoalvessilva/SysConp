/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControlePeculiaridadeFrente;
import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.ModeloTabela;
import gestor.Modelo.LogSistema;
import gestor.Modelo.PeculiaridadeFrente;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaConsultaProntuarioInternoCrc.jIdInterno;
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
public class TelaPeculiaridadeConsultaFrente extends javax.swing.JDialog {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    PeculiaridadeFrente objPecuFrente = new PeculiaridadeFrente();
    ControlePeculiaridadeFrente control = new ControlePeculiaridadeFrente();
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    //
    String nomeModuloTela = "CRC:Prontuário de Internos:Peculiaridade Frente";
    String statusMov;
    String horaMov;
    String dataModFinal;
    int flag;
    int acao;
    String dataCadastro;
    /**
     * Creates new form TelaPeculiaridade
     */
    public static TelaConsultaProntuarioInternoCrc telaProntuarioCrc;

    public TelaPeculiaridadeConsultaFrente(TelaConsultaProntuarioInternoCrc parent, boolean modal) {
        this.telaProntuarioCrc = parent;
        this.setModal(modal);
        setLocationRelativeTo(telaProntuarioCrc);
        initComponents();
        preencherTabelaPeculiaridadeFrente("SELECT * FROM PECULIARIDADE_FRENTE "
                + "INNER JOIN PRONTUARIOSCRC "
                + "ON PECULIARIDADE_FRENTE.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                + "WHERE PECULIARIDADE_FRENTE.IdInternoCrc='" + jIdInterno.getText() + "'");
        formatarCampos();
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
        jDataCadastro = new com.toedter.calendar.JDateChooser();
        jComboBoxRegiaoCorpo = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextoParticularidade = new javax.swing.JTextArea();
        jBtNovo = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jCodigoPec = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabelaRegiaoCorpo = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("...::: Peculiaridade da Frente :::...");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Data");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Região do Corpo");

        jDataCadastro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataCadastro.setEnabled(false);

        jComboBoxRegiaoCorpo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxRegiaoCorpo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1 - Frontal", "2 - Orbitárias", "3 - Nasal", "4 - Malares", "5 - Masseterianas", "6 - Bucinadoras", "7 - Labial", "8 - Metoniana", "9 - Supra-hioidea", "10 - Infra-hioidea", "11 - Carotidianas", "12 - Supracalviculares", "13 - Claviculares", "14 - Infraclaviculares", "15 - External", "16 - Torácicas", "17 - Mamárias", "18 - Epigástricas", "19 - Hipocôndrias", "20 - Mesogástrica", "21 - Umbilical", "22 - Flancos", "23 - Hipogástrica", "24 - Fossas Iliácas", "25 - Pubiana", "26 - Inguinais", "27 - Crurais", "28 - (H) Peniana", "29 - (H) Escrotal", "30 - Terços Superiores", "31 - Terços Médio dos Braços", "32 - Terços Inf. dos Braços", "33 - Prego dos Cotovelos", "34 - Terços Sup. antebraços", "35 - Terços Médio dos antebraços", "36 - Terços inferiores dos antebraços", "37 - Punhos", "38 - Côncavos das mãos", "39 - Terços Superioires das Coxas", "40 - Terços Médio das Coxas", "41 - Terços Inferiores das Coxas", "42 - Rotulianas", "43 - Faces anterioires do joelho", "44 - Terços superiores das pernas", "45 - Terços médio das pernas", "46 - Terços  inferiores das pernas", "47 - Lateral Externa das pernas", "48 - Lateral interna das pernas", "49 - Dorsal do pé", "50 - (M) Vulgo vaginal" }));
        jComboBoxRegiaoCorpo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxRegiaoCorpo.setEnabled(false);

        jTextoParticularidade.setColumns(20);
        jTextoParticularidade.setRows(5);
        jTextoParticularidade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextoParticularidade.setEnabled(false);
        jScrollPane1.setViewportView(jTextoParticularidade);

        jBtNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovo.setToolTipText("Novo");
        jBtNovo.setEnabled(false);
        jBtNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoActionPerformed(evt);
            }
        });

        jBtAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterar.setToolTipText("Alterar");
        jBtAlterar.setEnabled(false);
        jBtAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarActionPerformed(evt);
            }
        });

        jBtExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluir.setToolTipText("Excluir");
        jBtExcluir.setEnabled(false);
        jBtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirActionPerformed(evt);
            }
        });

        jBtSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvar.setToolTipText("Gravar");
        jBtSalvar.setEnabled(false);
        jBtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarActionPerformed(evt);
            }
        });

        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSair.setToolTipText("Sair");
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        jBtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelar.setToolTipText("Cancelar");
        jBtCancelar.setEnabled(false);
        jBtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarActionPerformed(evt);
            }
        });

        jCodigoPec.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodigoPec.setAutoscrolls(false);
        jCodigoPec.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCodigoPec.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Código");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jCodigoPec, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jComboBoxRegiaoCorpo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBtNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 150, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterar, jBtExcluir, jBtNovo, jBtSair, jBtSalvar});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jCodigoPec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxRegiaoCorpo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jBtNovo)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtAlterar)
                            .addComponent(jBtExcluir)))
                    .addComponent(jBtSalvar)
                    .addComponent(jBtSair)
                    .addComponent(jBtCancelar))
                .addGap(12, 12, 12))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterar, jBtCancelar, jBtExcluir, jBtNovo, jBtSair, jBtSalvar});

        jTabelaRegiaoCorpo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaRegiaoCorpo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Código", "Data", "Região do Corpo"
            }
        ));
        jTabelaRegiaoCorpo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaRegiaoCorpoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTabelaRegiaoCorpo);
        if (jTabelaRegiaoCorpo.getColumnModel().getColumnCount() > 0) {
            jTabelaRegiaoCorpo.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaRegiaoCorpo.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaRegiaoCorpo.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaRegiaoCorpo.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaRegiaoCorpo.getColumnModel().getColumn(2).setMinWidth(300);
            jTabelaRegiaoCorpo.getColumnModel().getColumn(2).setMaxWidth(300);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        acao = 1;
        Novo();
        statusMov = "Incluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        // TODO add your handling code here:
        acao = 2;
        statusMov = "Alterou";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        Alterar();
    }//GEN-LAST:event_jBtAlterarActionPerformed

    private void jBtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirActionPerformed
        // TODO add your handling code here:
        statusMov = "Excluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir PRONTUÁRIO selecionado?", "Confirmação",
                JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            try {
                objPecuFrente.setIdItem(Integer.valueOf(jCodigoPec.getText()));
                control.excluirPeculiaridadeFrente(objPecuFrente);
                objLog();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                preencherTabelaPeculiaridadeFrente("SELECT * FROM PECULIARIDADE_FRENTE "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON PECULIARIDADE_FRENTE.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE PECULIARIDADE_FRENTE.IdInternoCrc='" + jIdInterno.getText() + "'");
                JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso...");
                Excluir();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, "Não foi possivel excluir o registro\nERRO: " + ex);
            }
        }
        Excluir();
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        if (jDataCadastro.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Informe a data de Cadastro da peculiaridade.");
        } else {
            objPecuFrente.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
            objPecuFrente.setDataPec(jDataCadastro.getDate());
            objPecuFrente.setRegiaoFrente((String) jComboBoxRegiaoCorpo.getSelectedItem());
            objPecuFrente.setTextoPeculiaridade(jTextoParticularidade.getText());
            if (acao == 1) {
                objPecuFrente.setUsuarioInsert(nameUser);
                objPecuFrente.setDataInsert(dataModFinal);
                objPecuFrente.setHorarioInsert(horaMov);
                control.incluirPeculiaridadeFrente(objPecuFrente);
                buscarCodigo();
                objLog();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação  
                preencherTabelaPeculiaridadeFrente("SELECT * FROM PECULIARIDADE_FRENTE "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON PECULIARIDADE_FRENTE.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE PECULIARIDADE_FRENTE.IdInternoCrc='" + jIdInterno.getText() + "'");
                Salvar();
                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
            }
            if (acao == 2) {
                objPecuFrente.setUsuarioUp(nameUser);
                objPecuFrente.setDataUp(dataModFinal);
                objPecuFrente.setHorarioUp(horaMov);
                objPecuFrente.setIdItem(Integer.valueOf(jCodigoPec.getText()));
                control.alterarPeculiaridadeFrente(objPecuFrente);
                objLog();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
                preencherTabelaPeculiaridadeFrente("SELECT * FROM PECULIARIDADE_FRENTE "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON PECULIARIDADE_FRENTE.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE PECULIARIDADE_FRENTE.IdInternoCrc='" + jIdInterno.getText() + "'");
                Salvar();
                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
            }
        }
    }//GEN-LAST:event_jBtSalvarActionPerformed

    private void jBtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarActionPerformed
        // TODO add your handling code here:
        Cancelar();
    }//GEN-LAST:event_jBtCancelarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jTabelaRegiaoCorpoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaRegiaoCorpoMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String IdLanc = "" + jTabelaRegiaoCorpo.getValueAt(jTabelaRegiaoCorpo.getSelectedRow(), 0);
            jCodigoPec.setText(IdLanc);
            //
            jBtNovo.setEnabled(!true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM PECULIARIDADE_FRENTE "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON PECULIARIDADE_FRENTE.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE IdItem='" + IdLanc + "'");
                conecta.rs.first();
                jCodigoPec.setText(String.valueOf(conecta.rs.getInt("IdItem")));
                jDataCadastro.setDate(conecta.rs.getDate("DataPec"));
                jComboBoxRegiaoCorpo.setSelectedItem(conecta.rs.getString("RegiaoFrente"));
                jTextoParticularidade.setText(conecta.rs.getString("TextoPeculiaridade"));
                conecta.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa..." + e);
            }
        }
    }//GEN-LAST:event_jTabelaRegiaoCorpoMouseClicked

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
            java.util.logging.Logger.getLogger(TelaPeculiaridadeConsultaFrente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPeculiaridadeConsultaFrente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPeculiaridadeConsultaFrente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPeculiaridadeConsultaFrente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaPeculiaridadeConsultaFrente dialog = new TelaPeculiaridadeConsultaFrente(telaProntuarioCrc, true);
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
    private javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtExcluir;
    private javax.swing.JButton jBtNovo;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSalvar;
    public static javax.swing.JTextField jCodigoPec;
    private javax.swing.JComboBox jComboBoxRegiaoCorpo;
    private com.toedter.calendar.JDateChooser jDataCadastro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTabelaRegiaoCorpo;
    private javax.swing.JTextArea jTextoParticularidade;
    // End of variables declaration//GEN-END:variables

    public void formatarCampos() {
        jTextoParticularidade.setLineWrap(true);
        jTextoParticularidade.setWrapStyleWord(true);
    }

    public void Novo() {
        jCodigoPec.setText("");
        jDataCadastro.setCalendar(Calendar.getInstance());
        jComboBoxRegiaoCorpo.setSelectedItem("1 - Parietal");
        jTextoParticularidade.setText("");
        //
        jDataCadastro.setEnabled(true);
        jComboBoxRegiaoCorpo.setEnabled(true);
        jTextoParticularidade.setEnabled(true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
    }

    public void Alterar() {
        jDataCadastro.setEnabled(true);
        jComboBoxRegiaoCorpo.setEnabled(true);
        jTextoParticularidade.setEnabled(true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
    }

    public void Excluir() {
        jCodigoPec.setText("");
        jDataCadastro.setDate(null);
        jComboBoxRegiaoCorpo.setSelectedItem("1 - Parietal");
        jTextoParticularidade.setText("");
        //
        jDataCadastro.setEnabled(!true);
        jComboBoxRegiaoCorpo.setEnabled(!true);
        jTextoParticularidade.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
    }

    public void Salvar() {
        jDataCadastro.setEnabled(!true);
        jComboBoxRegiaoCorpo.setEnabled(!true);
        jTextoParticularidade.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
    }

    public void Cancelar() {
        if (jCodigoPec.getText().equals("")) {
            jDataCadastro.setDate(null);
            jComboBoxRegiaoCorpo.setSelectedItem("1 - Parietal");
            jTextoParticularidade.setText("");
            //
            jDataCadastro.setEnabled(!true);
            jComboBoxRegiaoCorpo.setEnabled(!true);
            jTextoParticularidade.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
        } else {
            jDataCadastro.setEnabled(!true);
            jComboBoxRegiaoCorpo.setEnabled(!true);
            jTextoParticularidade.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
        }
    }

    public void buscarCodigo() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PECULIARIDADE_FRENTE");
            conecta.rs.last();
            jCodigoPec.setText(conecta.rs.getString("IdItem"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter o código do registro.\nERRO: " + e);
        }
        conecta.desconecta();
    }

    public void preencherTabelaPeculiaridadeFrente(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Região do Corpo"};
        conecta.abrirConexao();
        conecta.executaSQL(sql);
        try {
            conecta.rs.first();
            do {
                // Fortmatar data de Cadastro          
                dataCadastro = conecta.rs.getString("DataPec");
                String day = dataCadastro.substring(8, 10);
                String mesc = dataCadastro.substring(5, 7);
                String anoc = dataCadastro.substring(0, 4);
                dataCadastro = day + "/" + mesc + "/" + anoc;
                dados.add(new Object[]{conecta.rs.getInt("IdItem"), dataCadastro, conecta.rs.getString("RegiaoFrente")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaRegiaoCorpo.setModel(modelo);
        jTabelaRegiaoCorpo.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaRegiaoCorpo.getColumnModel().getColumn(0).setResizable(false);
        jTabelaRegiaoCorpo.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaRegiaoCorpo.getColumnModel().getColumn(1).setResizable(false);
        jTabelaRegiaoCorpo.getColumnModel().getColumn(2).setPreferredWidth(300);
        jTabelaRegiaoCorpo.getColumnModel().getColumn(2).setResizable(false);
        jTabelaRegiaoCorpo.getTableHeader().setReorderingAllowed(false);
        jTabelaRegiaoCorpo.setAutoResizeMode(jTabelaRegiaoCorpo.AUTO_RESIZE_OFF);
        jTabelaRegiaoCorpo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaPeculiaridade();
        conecta.desconecta();
    }

    public void alinharCamposTabelaPeculiaridade() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaRegiaoCorpo.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaRegiaoCorpo.getColumnModel().getColumn(1).setCellRenderer(centralizado);
    }

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jCodigoPec.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }
}
