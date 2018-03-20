/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControlePatologiaEvolucaoPsiquiatrica;
import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.ModeloTabela;
import gestor.Modelo.LogSistema;
import gestor.Modelo.PatologiaEvolucaoPsiquiatrica;
import static gestor.Visao.TelaAdmissaoMedica.jIdEvolucaoPsiquiatrica;
import static gestor.Visao.TelaAdmissaoMedica.jIdInternoAdm;
import static gestor.Visao.TelaAdmissaoMedica.jNomeCompletoInternoDiagnosticos;
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
 * @author Ronaldo
 */
public class TelaPatologiasEvolucaoMedicaPsiquiatrica extends javax.swing.JDialog {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    PatologiaEvolucaoPsiquiatrica objPatEvol = new PatologiaEvolucaoPsiquiatrica();
    ControlePatologiaEvolucaoPsiquiatrica control = new ControlePatologiaEvolucaoPsiquiatrica();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    //
    String nomeModuloTela = "Enfermagem:Anamnese Psiquiatria de Internos:Patologias";
    String statusMov;
    String horaMov;
    String dataModFinal;
    int flag;
    int acao;
    String dataCadastro;
    int count = 0;

    /**
     * Creates new form TelaPatologiasEvolucaoMedicaPsiquiatrica
     *
     */
    public static TelaAdmissaoMedica telaAdmissaoMedica;

    public TelaPatologiasEvolucaoMedicaPsiquiatrica(TelaAdmissaoMedica parent, boolean modal) {
        this.telaAdmissaoMedica = parent;
        this.setModal(modal);
        setLocationRelativeTo(telaAdmissaoMedica);
        initComponents();
        corCampos();
        jNomeInternoEvolucaoPsi.setText(jNomeCompletoInternoDiagnosticos.getText());

        preencherTabelaPatologiasPsiquiatricas("SELECT * FROM PATOLOGIA_EVOLUCAO_PSIQUIATRICA "
                + "INNER JOIN DOENCAS "
                + "ON PATOLOGIA_EVOLUCAO_PSIQUIATRICA.IdDoenca=DOENCAS.IdDoenca "
                + "INNER JOIN EVOLUCAO_PSIQUIATRICA "
                + "ON PATOLOGIA_EVOLUCAO_PSIQUIATRICA.IdItem=EVOLUCAO_PSIQUIATRICA.IdItem "
                + "WHERE PATOLOGIA_EVOLUCAO_PSIQUIATRICA.IdInternoCrc='" + jIdInternoAdm.getText() + "' "
                + "AND PATOLOGIA_EVOLUCAO_PSIQUIATRICA.IdItem='" + jIdEvolucaoPsiquiatrica.getText() + "'");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaRegiaoPatologias = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxDescricaoPatologia = new javax.swing.JComboBox();
        jBtNovo = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jCodigoEvolucaoPat = new javax.swing.JTextField();
        jDataReg = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jNomeInternoEvolucaoPsi = new javax.swing.JTextField();
        jBtCancelar = new javax.swing.JButton();
        jPanel30 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("...::: Patologias Adquiridas :::...");

        jTabelaRegiaoPatologias.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaRegiaoPatologias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Item", "Data", "Código", "Descrição da Patologia", "CID"
            }
        ));
        jTabelaRegiaoPatologias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaRegiaoPatologiasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaRegiaoPatologias);
        if (jTabelaRegiaoPatologias.getColumnModel().getColumnCount() > 0) {
            jTabelaRegiaoPatologias.getColumnModel().getColumn(0).setMinWidth(60);
            jTabelaRegiaoPatologias.getColumnModel().getColumn(0).setMaxWidth(60);
            jTabelaRegiaoPatologias.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaRegiaoPatologias.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaRegiaoPatologias.getColumnModel().getColumn(2).setMinWidth(60);
            jTabelaRegiaoPatologias.getColumnModel().getColumn(2).setMaxWidth(60);
            jTabelaRegiaoPatologias.getColumnModel().getColumn(3).setMinWidth(280);
            jTabelaRegiaoPatologias.getColumnModel().getColumn(3).setMaxWidth(280);
            jTabelaRegiaoPatologias.getColumnModel().getColumn(4).setMinWidth(60);
            jTabelaRegiaoPatologias.getColumnModel().getColumn(4).setMaxWidth(60);
        }

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Descrição da Patologia");

        jComboBoxDescricaoPatologia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDescricaoPatologia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDescricaoPatologia.setEnabled(false);

        jBtNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovo.setToolTipText("Novo");
        jBtNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoActionPerformed(evt);
            }
        });

        jBtAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/refresh-reload-icone-6258-16.png"))); // NOI18N
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

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Código");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Data");

        jCodigoEvolucaoPat.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodigoEvolucaoPat.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCodigoEvolucaoPat.setEnabled(false);

        jDataReg.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataReg.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Nome Completo do Interno");

        jNomeInternoEvolucaoPsi.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoEvolucaoPsi.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jNomeInternoEvolucaoPsi.setEnabled(false);

        jBtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelar.setToolTipText("Cancelar Operação");
        jBtCancelar.setEnabled(false);
        jBtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(110, 327, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCodigoEvolucaoPat, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDataReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jComboBoxDescricaoPatologia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jNomeInternoEvolucaoPsi)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jBtNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterar, jBtCancelar, jBtExcluir, jBtNovo, jBtSair, jBtSalvar});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBtCancelar)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jNomeInternoEvolucaoPsi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jCodigoEvolucaoPat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDataReg, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxDescricaoPatologia, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtSalvar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jBtSair, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jBtAlterar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jBtExcluir, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jBtNovo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterar, jBtCancelar, jBtExcluir, jBtNovo, jBtSair, jBtSalvar});

        jPanel30.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jLabel63.setText("Total de Registros:");

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel63))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel63)
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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
        preencherComboNovo();
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        // TODO add your handling code here:
        acao = 2;
        statusMov = "Alterou";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        Alterar();
        preencherComboNovo();
    }//GEN-LAST:event_jBtAlterarActionPerformed

    private void jBtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirActionPerformed
        // TODO add your handling code here:
        statusMov = "Excluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir registro selecionado?", "Confirmação",
                JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            objPatEvol.setIdPatPsi(Integer.valueOf(jCodigoEvolucaoPat.getText()));
            control.excluirPatologiaPsiquiatria(objPatEvol);
            objLog();
            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
            preencherTabelaPatologiasPsiquiatricas("SELECT * FROM PATOLOGIA_EVOLUCAO_PSIQUIATRICA "
                    + "INNER JOIN DOENCAS "
                    + "ON PATOLOGIA_EVOLUCAO_PSIQUIATRICA.IdDoenca=DOENCAS.IdDoenca "
                    + "INNER JOIN EVOLUCAO_PSIQUIATRICA "
                    + "ON PATOLOGIA_EVOLUCAO_PSIQUIATRICA.IdItem=EVOLUCAO_PSIQUIATRICA.IdItem "
                    + "WHERE PATOLOGIA_EVOLUCAO_PSIQUIATRICA.IdInternoCrc='" + jIdInternoAdm.getText() + "' "
                    + "AND PATOLOGIA_EVOLUCAO_PSIQUIATRICA.IdItem='" + jIdEvolucaoPsiquiatrica.getText() + "'");
            Excluir();
            JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso...");
        }
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        if (jDataReg.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Informe a data do registro.");
        } else if (jComboBoxDescricaoPatologia.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe a descrição da patologia.");
        } else {
            // CÓDIGO DA EVOLUÇÃO PSIQUIATRICA
            objPatEvol.setIdItem(Integer.valueOf(jIdEvolucaoPsiquiatrica.getText()));
            objPatEvol.setIdInternoCrc(Integer.valueOf(jIdInternoAdm.getText()));
            objPatEvol.setDataReg(jDataReg.getDate());
            objPatEvol.setDescricaoDoenca((String) jComboBoxDescricaoPatologia.getSelectedItem());
            if (acao == 1) {
                objPatEvol.setUsuarioInsert(nameUser);
                objPatEvol.setDataInsert(dataModFinal);
                objPatEvol.setHorarioInsert(horaMov);
                control.incluirPatologiaPsiquiatria(objPatEvol);
                buscarCodigo();
                objLog();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação  
                preencherTabelaPatologiasPsiquiatricas("SELECT * FROM PATOLOGIA_EVOLUCAO_PSIQUIATRICA "
                        + "INNER JOIN DOENCAS "
                        + "ON PATOLOGIA_EVOLUCAO_PSIQUIATRICA.IdDoenca=DOENCAS.IdDoenca "
                        + "INNER JOIN EVOLUCAO_PSIQUIATRICA "
                        + "ON PATOLOGIA_EVOLUCAO_PSIQUIATRICA.IdItem=EVOLUCAO_PSIQUIATRICA.IdItem "
                        + "WHERE PATOLOGIA_EVOLUCAO_PSIQUIATRICA.IdInternoCrc='" + jIdInternoAdm.getText() + "' "
                        + "AND PATOLOGIA_EVOLUCAO_PSIQUIATRICA.IdItem='" + jIdEvolucaoPsiquiatrica.getText() + "'");
                Salvar();
                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
            }
            if (acao == 2) {
                objPatEvol.setUsuarioUp(nameUser);
                objPatEvol.setDataUp(dataModFinal);
                objPatEvol.setHorarioUp(horaMov);
                objPatEvol.setIdPatPsi(Integer.valueOf(jCodigoEvolucaoPat.getText()));
                control.alterarPatologiaPsiquiatria(objPatEvol);
                objLog();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação  
                preencherTabelaPatologiasPsiquiatricas("SELECT * FROM PATOLOGIA_EVOLUCAO_PSIQUIATRICA "
                        + "INNER JOIN DOENCAS "
                        + "ON PATOLOGIA_EVOLUCAO_PSIQUIATRICA.IdDoenca=DOENCAS.IdDoenca "
                        + "INNER JOIN EVOLUCAO_PSIQUIATRICA "
                        + "ON PATOLOGIA_EVOLUCAO_PSIQUIATRICA.IdItem=EVOLUCAO_PSIQUIATRICA.IdItem "
                        + "WHERE PATOLOGIA_EVOLUCAO_PSIQUIATRICA.IdInternoCrc='" + jIdInternoAdm.getText() + "' "
                        + "AND PATOLOGIA_EVOLUCAO_PSIQUIATRICA.IdItem='" + jIdEvolucaoPsiquiatrica.getText() + "'");
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

    private void jTabelaRegiaoPatologiasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaRegiaoPatologiasMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String IdLanc = "" + jTabelaRegiaoPatologias.getValueAt(jTabelaRegiaoPatologias.getSelectedRow(), 0);
            jCodigoEvolucaoPat.setText(IdLanc);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(true);
            jComboBoxDescricaoPatologia.removeAllItems();
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM PATOLOGIA_EVOLUCAO_PSIQUIATRICA "
                        + "INNER JOIN DOENCAS "
                        + "ON PATOLOGIA_EVOLUCAO_PSIQUIATRICA.IdDoenca=DOENCAS.IdDoenca "
                        + "INNER JOIN EVOLUCAO_PSIQUIATRICA "
                        + "ON PATOLOGIA_EVOLUCAO_PSIQUIATRICA.IdItem=EVOLUCAO_PSIQUIATRICA.IdItem "
                        + "WHERE PATOLOGIA_EVOLUCAO_PSIQUIATRICA.IdPatPsi='" + IdLanc + "'");
                conecta.rs.first();
                jCodigoEvolucaoPat.setText(String.valueOf(conecta.rs.getInt("IdPatPsi")));
                jDataReg.setDate(conecta.rs.getDate("DataReg"));
                jComboBoxDescricaoPatologia.addItem(conecta.rs.getString("Descricao"));
                conecta.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa..." + e);
            }
        }
    }//GEN-LAST:event_jTabelaRegiaoPatologiasMouseClicked

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
            java.util.logging.Logger.getLogger(TelaPatologiasEvolucaoMedicaPsiquiatrica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPatologiasEvolucaoMedicaPsiquiatrica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPatologiasEvolucaoMedicaPsiquiatrica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPatologiasEvolucaoMedicaPsiquiatrica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaPatologiasEvolucaoMedicaPsiquiatrica dialog = new TelaPatologiasEvolucaoMedicaPsiquiatrica(telaAdmissaoMedica, true);
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
    private javax.swing.JTextField jCodigoEvolucaoPat;
    private javax.swing.JComboBox jComboBoxDescricaoPatologia;
    private com.toedter.calendar.JDateChooser jDataReg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JTextField jNomeInternoEvolucaoPsi;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabelaRegiaoPatologias;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void corCampos() {
        jNomeInternoEvolucaoPsi.setBackground(Color.white);
        jCodigoEvolucaoPat.setBackground(Color.white);
    }

    public void Novo() {
        jCodigoEvolucaoPat.setText("");
        jDataReg.setCalendar(Calendar.getInstance());
        //
        jDataReg.setEnabled(true);
        jComboBoxDescricaoPatologia.setEnabled(true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
    }

    public void Alterar() {
        jDataReg.setEnabled(true);
        jComboBoxDescricaoPatologia.setEnabled(true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
    }

    public void Excluir() {
        jCodigoEvolucaoPat.setText("");
        jDataReg.setDate(null);
        //
        jDataReg.setEnabled(!true);
        jComboBoxDescricaoPatologia.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
    }

    public void Salvar() {
        jCodigoEvolucaoPat.setText("");
        jDataReg.setDate(null);
        //
        jDataReg.setEnabled(!true);
        jComboBoxDescricaoPatologia.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
    }

    public void Cancelar() {

        jCodigoEvolucaoPat.setText("");
        jDataReg.setDate(null);
        //
        jDataReg.setEnabled(!true);
        jComboBoxDescricaoPatologia.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
    }

    public void buscarCodigo() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PATOLOGIA_EVOLUCAO_PSIQUIATRICA");
            conecta.rs.last();
            jCodigoEvolucaoPat.setText(conecta.rs.getString("IdItem"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter o código do registro.\nERRO: " + e);
        }
        conecta.desconecta();
    }

    public void preencherComboNovo() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM DOENCAS ORDER BY Descricao");
            conecta.rs.first();
            do {
                jComboBoxDescricaoPatologia.addItem(conecta.rs.getString("Descricao"));
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void preencherTabelaPatologiasPsiquiatricas(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Data", "Código", "Descrição da Patologia", "CID"};
        conecta.abrirConexao();
        conecta.executaSQL(sql);
        try {
            conecta.rs.first();
            count = 0;
            do {
                count = count + 1;
                // Fortmatar data de Cadastro          
                dataCadastro = conecta.rs.getString("DataReg");
                String day = dataCadastro.substring(8, 10);
                String mesc = dataCadastro.substring(5, 7);
                String anoc = dataCadastro.substring(0, 4);
                dataCadastro = day + "/" + mesc + "/" + anoc;
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdPatPsi"), dataCadastro, conecta.rs.getString("IdDoenca"), conecta.rs.getString("Descricao"), conecta.rs.getString("Cid")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaRegiaoPatologias.setModel(modelo);
        jTabelaRegiaoPatologias.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaRegiaoPatologias.getColumnModel().getColumn(0).setResizable(false);
        jTabelaRegiaoPatologias.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaRegiaoPatologias.getColumnModel().getColumn(1).setResizable(false);
        jTabelaRegiaoPatologias.getColumnModel().getColumn(2).setPreferredWidth(60);
        jTabelaRegiaoPatologias.getColumnModel().getColumn(2).setResizable(false);
        jTabelaRegiaoPatologias.getColumnModel().getColumn(3).setPreferredWidth(280);
        jTabelaRegiaoPatologias.getColumnModel().getColumn(3).setResizable(false);
        jTabelaRegiaoPatologias.getColumnModel().getColumn(4).setPreferredWidth(60);
        jTabelaRegiaoPatologias.getColumnModel().getColumn(4).setResizable(false);
        jTabelaRegiaoPatologias.getTableHeader().setReorderingAllowed(false);
        jTabelaRegiaoPatologias.setAutoResizeMode(jTabelaRegiaoPatologias.AUTO_RESIZE_OFF);
        jTabelaRegiaoPatologias.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaPatologias();
        conecta.desconecta();
    }

    public void alinharCamposTabelaPatologias() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaRegiaoPatologias.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaRegiaoPatologias.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaRegiaoPatologias.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        jTabelaRegiaoPatologias.getColumnModel().getColumn(4).setCellRenderer(centralizado);
    }

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jCodigoEvolucaoPat.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }
}
