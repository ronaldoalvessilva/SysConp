/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleGrupoProdutosAC;
import gestor.Controle.ControleGrupoProdutosNUTRI;
import gestor.Controle.ControleLogSistema;
import gestor.Dao.ConexaoBancoDados;
import Utilitarios.LimiteDigitos;
import Utilitarios.ModeloTabela;
import gestor.Modelo.GrupoProdutos;
import gestor.Modelo.LogSistema;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author user
 */
public class TelaGrupoProdutosNUTRI extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    GrupoProdutos objGrupoProd = new GrupoProdutos();
    ControleGrupoProdutosNUTRI control = new ControleGrupoProdutosNUTRI();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela = "Nutrição:Grupo de Produtos:Manutenção";
    String statusMov;
    String horaMov;
    String dataModFinal;
    int acao, flag;
    String codGrupo;
    String modulo = "N";

    /**
     * Creates new form TelaGrupoMedicamentos
     */
    public TelaGrupoProdutosNUTRI() {
        initComponents();
        formatarCampos();
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

        jPanel4 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPesqNomeGrupo = new javax.swing.JTextField();
        jCheckBoxPesqTodos = new javax.swing.JCheckBox();
        jBtPesqNomeGrupo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaGrupo = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jIdGrupo = new javax.swing.JTextField();
        jDescricaoGrupo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxStatus = new javax.swing.JComboBox();
        jBtAuditoria = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jBtNovo = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Grupo de Materiais {NUTRI} :::...");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Descrição:");

        jPesqNomeGrupo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jCheckBoxPesqTodos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxPesqTodos.setText("Todos");
        jCheckBoxPesqTodos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxPesqTodosItemStateChanged(evt);
            }
        });

        jBtPesqNomeGrupo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqNomeGrupo.setContentAreaFilled(false);
        jBtPesqNomeGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqNomeGrupoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPesqNomeGrupo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtPesqNomeGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxPesqTodos)
                .addGap(16, 16, 16))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtPesqNomeGrupo)
                    .addComponent(jPesqNomeGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jCheckBoxPesqTodos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaGrupo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaGrupo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Código", "Descrição", "Status"
            }
        ));
        jTabelaGrupo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaGrupoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaGrupo);
        if (jTabelaGrupo.getColumnModel().getColumnCount() > 0) {
            jTabelaGrupo.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaGrupo.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaGrupo.getColumnModel().getColumn(1).setMinWidth(280);
            jTabelaGrupo.getColumnModel().getColumn(1).setMaxWidth(280);
            jTabelaGrupo.getColumnModel().getColumn(2).setMinWidth(50);
            jTabelaGrupo.getColumnModel().getColumn(2).setMaxWidth(50);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Listagem", jPanel1);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Descrição do Grupo");

        jIdGrupo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdGrupo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdGrupo.setEnabled(false);

        jDescricaoGrupo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDescricaoGrupo.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Status");

        jComboBoxStatus.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxStatus.setForeground(new java.awt.Color(153, 0, 102));
        jComboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ativo", "Inativo" }));
        jComboBoxStatus.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxStatus.setEnabled(false);

        jBtAuditoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoria.setToolTipText("Auditoria");
        jBtAuditoria.setContentAreaFilled(false);
        jBtAuditoria.setEnabled(false);
        jBtAuditoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDescricaoGrupo)
                    .addComponent(jLabel2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jIdGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(65, 65, 65)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jComboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBtAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtAuditoria)
                    .addComponent(jComboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDescricaoGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jBtNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/7183_16x16.png"))); // NOI18N
        jBtNovo.setText("Novo");
        jBtNovo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBtNovo.setContentAreaFilled(false);
        jBtNovo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoActionPerformed(evt);
            }
        });

        jBtAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterar.setText("Alterar");
        jBtAlterar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBtAlterar.setContentAreaFilled(false);
        jBtAlterar.setEnabled(false);
        jBtAlterar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarActionPerformed(evt);
            }
        });

        jBtExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluir.setText("Excluir");
        jBtExcluir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBtExcluir.setContentAreaFilled(false);
        jBtExcluir.setEnabled(false);
        jBtExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluir.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirActionPerformed(evt);
            }
        });

        jBtSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvar.setText("Gravar");
        jBtSalvar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBtSalvar.setContentAreaFilled(false);
        jBtSalvar.setEnabled(false);
        jBtSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarActionPerformed(evt);
            }
        });

        jBtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelar.setText("Cancelar");
        jBtCancelar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBtCancelar.setContentAreaFilled(false);
        jBtCancelar.setEnabled(false);
        jBtCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarActionPerformed(evt);
            }
        });

        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSair.setText("Sair");
        jBtSair.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBtSair.setContentAreaFilled(false);
        jBtSair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSair.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSair.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jBtSair)
                .addContainerGap())
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterar, jBtCancelar, jBtExcluir, jBtNovo, jBtSair, jBtSalvar});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBtSair)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtNovo)
                        .addComponent(jBtAlterar)
                        .addComponent(jBtExcluir)
                        .addComponent(jBtSalvar))
                    .addComponent(jBtCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterar, jBtCancelar, jBtExcluir, jBtNovo, jBtSair, jBtSalvar});

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Manutenção", jPanel2);

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

        setBounds(300, 10, 421, 271);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        statusMov = "Incluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        acao = 1;
        Novo();
        corCampos();
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        // TODO add your handling code here:
        statusMov = "Alterou";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        acao = 2;
        Alterar();
        corCampos();
    }//GEN-LAST:event_jBtAlterarActionPerformed

    private void jBtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirActionPerformed
        // TODO add your handling code here:
        verificarProduto();
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        if (jComboBoxStatus.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(rootPane, "Informe o status do grupo.");
            jComboBoxStatus.requestFocus();
            jComboBoxStatus.setBackground(Color.red);
        } else {
            if (jDescricaoGrupo.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe a descrição do grupo de produtos.");
                jDescricaoGrupo.requestFocus();
                jDescricaoGrupo.setBackground(Color.red);
            } else {
                objGrupoProd.setStatusGru((String) jComboBoxStatus.getSelectedItem());
                objGrupoProd.setNomeGrupo(jDescricaoGrupo.getText());
                objGrupoProd.setModulo(modulo);
                if (acao == 1) {
                    // log de usuario
                    objGrupoProd.setUsuarioInsert(nameUser);
                    objGrupoProd.setDataInsert(dataModFinal);
                    objGrupoProd.setHorarioInsert(horaMov);
                    control.incluirGrupoNUTRI(objGrupoProd);
                    buscarID();
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    Salvar();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
                if (acao == 2) {
                    // log de usuario
                    objGrupoProd.setUsuarioUp(nameUser);
                    objGrupoProd.setDataUp(dataModFinal);
                    objGrupoProd.setHorarioUp(horaMov);
                    objGrupoProd.setIdGrupo(Integer.valueOf(jIdGrupo.getText()));
                    control.alterarGrupoNUTRI(objGrupoProd);
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    Salvar();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
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

    private void jTabelaGrupoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaGrupoMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            String nomeForn = "" + jTabelaGrupo.getValueAt(jTabelaGrupo.getSelectedRow(), 1);
            jPesqNomeGrupo.setText(nomeForn);
            jBtNovo.setEnabled(!true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM GRUPO_PRODUTOS_AC WHERE NomeGrupo='" + jPesqNomeGrupo.getText() + "'");
                conecta.rs.first();
                jIdGrupo.setText(String.valueOf(conecta.rs.getInt("IdGrupo")));
                jComboBoxStatus.setSelectedItem(conecta.rs.getString("StatusGru"));
                jDescricaoGrupo.setText(conecta.rs.getString("NomeGrupo"));
                conecta.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa dos dados...\nERRO: " + e);
            }
        }
    }//GEN-LAST:event_jTabelaGrupoMouseClicked

    private void jBtPesqNomeGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNomeGrupoActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (jPesqNomeGrupo.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um nome para pesquisa.");
        } else {
            preencherTabelaGrupos("SELECT * FROM GRUPO_PRODUTOS_AC WHERE NomeGrupo LIKE'%" + jPesqNomeGrupo.getText() + "%'AND Modulo='" + modulo + "'");
        }
    }//GEN-LAST:event_jBtPesqNomeGrupoActionPerformed

    private void jCheckBoxPesqTodosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxPesqTodosItemStateChanged
        // TODO add your handling code here:
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {           
            this.preencherTabelaGrupos("SELECT * FROM GRUPO_PRODUTOS_AC WHERE Modulo='" + modulo + "'");
        } else {
            limparTabela();
        }
    }//GEN-LAST:event_jCheckBoxPesqTodosItemStateChanged

    private void jBtAuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaGrupoProdutosNUTRI objAudiGrupoNUTRI = new TelaAuditoriaGrupoProdutosNUTRI();
        TelaModuloNutricao.jPainelNutricao.add(objAudiGrupoNUTRI);
        objAudiGrupoNUTRI.show();
    }//GEN-LAST:event_jBtAuditoriaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtAuditoria;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtExcluir;
    private javax.swing.JButton jBtNovo;
    private javax.swing.JButton jBtPesqNomeGrupo;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JCheckBox jCheckBoxPesqTodos;
    private javax.swing.JComboBox jComboBoxStatus;
    private javax.swing.JTextField jDescricaoGrupo;
    public static javax.swing.JTextField jIdGrupo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTextField jPesqNomeGrupo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTabelaGrupo;
    // End of variables declaration//GEN-END:variables

    public void formatarCampos() {
        jDescricaoGrupo.setDocument(new LimiteDigitos(150));
    }

    public void corCampos() {
        jIdGrupo.setBackground(Color.white);
        jComboBoxStatus.setBackground(Color.white);
        jDescricaoGrupo.setBackground(Color.white);
    }

    public void Novo() {
        jIdGrupo.setText("");
        jComboBoxStatus.setSelectedItem("Ativo");
        jDescricaoGrupo.setText("");
        //
        jComboBoxStatus.setEnabled(true);
        jDescricaoGrupo.setEnabled(true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtAuditoria.setEnabled(!true);
    }

    public void Alterar() {
        //
        jComboBoxStatus.setEnabled(true);
        jDescricaoGrupo.setEnabled(true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtAuditoria.setEnabled(!true);
    }

    public void Excluir() {
        jIdGrupo.setText("");
        jComboBoxStatus.setSelectedItem(null);
        jDescricaoGrupo.setText("");
        //
        jComboBoxStatus.setEnabled(!true);
        jDescricaoGrupo.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
    }

    public void Salvar() {
        //
        jComboBoxStatus.setEnabled(!true);
        jDescricaoGrupo.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
    }

    public void Cancelar() {
        //
        jComboBoxStatus.setEnabled(!true);
        jDescricaoGrupo.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
    }

    public void buscarID() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM GRUPO_PRODUTOS_AC");
            conecta.rs.last();
            jIdGrupo.setText(String.valueOf(conecta.rs.getInt("IdGrupo")));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível adquirir o ID do grupo...");
        }
    }

    public void verificarProduto() {

        statusMov = "Excluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRODUTOS_AC");
            conecta.rs.first();
            codGrupo = conecta.rs.getString("IdGrupo");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível selecionar o arquivo.\nERRO: " + ex);
        }
        if (jIdGrupo.getText() == null ? codGrupo == null : jIdGrupo.getText().equals(codGrupo)) {
            JOptionPane.showMessageDialog(rootPane, "Não é possível excluir esse grupo, o mesmo está sendo utilizado por outro registro.");
        } else {
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir grupo selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objGrupoProd.setIdGrupo(Integer.valueOf(jIdGrupo.getText()));
                control.excluirGrupoNUTRI(objGrupoProd);
                objLog();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                Excluir();
            }
        }
    }

    public void preencherTabelaGrupos(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Descrição", "Status"};
        conecta.abrirConexao();
        conecta.executaSQL(sql);
        try {
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdGrupo"), conecta.rs.getString("NomeGrupo"), conecta.rs.getString("StatusGru")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem exibidos....");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaGrupo.setModel(modelo);
        jTabelaGrupo.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaGrupo.getColumnModel().getColumn(0).setResizable(false);
        jTabelaGrupo.getColumnModel().getColumn(1).setPreferredWidth(280);
        jTabelaGrupo.getColumnModel().getColumn(1).setResizable(false);
        jTabelaGrupo.getColumnModel().getColumn(2).setPreferredWidth(50);
        jTabelaGrupo.getColumnModel().getColumn(2).setResizable(false);
        jTabelaGrupo.getTableHeader().setReorderingAllowed(false);
        jTabelaGrupo.setAutoResizeMode(jTabelaGrupo.AUTO_RESIZE_OFF);
        jTabelaGrupo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabela();
        conecta.desconecta();
    }

    public void limparTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Descrição", "Status"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaGrupo.setModel(modelo);
        jTabelaGrupo.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaGrupo.getColumnModel().getColumn(0).setResizable(false);
        jTabelaGrupo.getColumnModel().getColumn(1).setPreferredWidth(280);
        jTabelaGrupo.getColumnModel().getColumn(1).setResizable(false);
        jTabelaGrupo.getColumnModel().getColumn(2).setPreferredWidth(50);
        jTabelaGrupo.getColumnModel().getColumn(2).setResizable(false);
        jTabelaGrupo.getTableHeader().setReorderingAllowed(false);
        jTabelaGrupo.setAutoResizeMode(jTabelaGrupo.AUTO_RESIZE_OFF);
        jTabelaGrupo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabela() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaGrupo.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaGrupo.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jIdGrupo.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }
}
