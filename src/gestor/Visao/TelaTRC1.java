/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AdmissaoEnfermagem;
import static gestor.Visao.TelaAdmissaoSecundariaEnfermagem.acao;
import static gestor.Visao.TelaAdmissaoSecundariaEnfermagem.pCirurgias;
import static gestor.Visao.TelaAdmissaoSecundariaEnfermagem.pDiabetes;
import static gestor.Visao.TelaAdmissaoSecundariaEnfermagem.pDst;
import static gestor.Visao.TelaAdmissaoSecundariaEnfermagem.pEscabiose;
import static gestor.Visao.TelaAdmissaoSecundariaEnfermagem.pHanseniase;
import static gestor.Visao.TelaAdmissaoSecundariaEnfermagem.pHepatiteB;
import static gestor.Visao.TelaAdmissaoSecundariaEnfermagem.pHepatiteC;
import static gestor.Visao.TelaAdmissaoSecundariaEnfermagem.pHipertensao;
import static gestor.Visao.TelaAdmissaoSecundariaEnfermagem.pHiv;
import static gestor.Visao.TelaAdmissaoSecundariaEnfermagem.pHpv;
import static gestor.Visao.TelaAdmissaoSecundariaEnfermagem.pQualCirurgias;
import static gestor.Visao.TelaAdmissaoSecundariaEnfermagem.pSifilis;
import static gestor.Visao.TelaAdmissaoSecundariaEnfermagem.pTuberculose;
import static gestor.Visao.TelaAdmissaoSecundariaEnfermagem.pVdrl;
import static gestor.Visao.TelaAdmissaoSecundariaEnfermagem.qualAlteracaoFala;
import static gestor.Visao.TelaAdmissaoSecundariaEnfermagem.statusFalaLinguagem;
import java.awt.Color;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static gestor.Visao.TelaAdmissaoSecundariaEnfermagem.jIdADM_Secundaria;

/**
 *
 * @author ronal
 */
public class TelaTRC1 extends javax.swing.JDialog {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AdmissaoEnfermagem objAdmEnfermagem = new AdmissaoEnfermagem();

    /**
     * Creates new form TelaFA
     */
    public static TelaAdmissaoSecundariaEnfermagem taeTRC;

    public TelaTRC1(TelaAdmissaoSecundariaEnfermagem parent, boolean modal) {
        this.taeTRC = parent;
        this.setModal(modal);
        setLocationRelativeTo(taeTRC);
        initComponents();
        corCampos();
        buscarDadosExistentes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBtAlterar = new javax.swing.JButton();
        jBtConfirmar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jPanel41 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jComboBoxVDRL = new javax.swing.JComboBox();
        jComboBoxHepatiteC = new javax.swing.JComboBox();
        jComboBoxHepatiteB = new javax.swing.JComboBox();
        jComboBoxHIV = new javax.swing.JComboBox();
        jLabel91 = new javax.swing.JLabel();
        jComboBoxCirurgia = new javax.swing.JComboBox();
        jLabel92 = new javax.swing.JLabel();
        jQualCirurgia = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jComboBoxSifilis = new javax.swing.JComboBox<>();
        jLabel106 = new javax.swing.JLabel();
        jComboBoxDiabetes = new javax.swing.JComboBox();
        jLabel109 = new javax.swing.JLabel();
        jComboBoxTuberculose = new javax.swing.JComboBox<>();
        jLabel84 = new javax.swing.JLabel();
        jComboBoxHipertensao = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxEscabiose = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxHanseniase = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxDST = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxHPV = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("...::: Testes Rápidos :::...");

        jBtAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterar.setText("Alterar");
        jBtAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarActionPerformed(evt);
            }
        });

        jBtConfirmar.setForeground(new java.awt.Color(0, 102, 0));
        jBtConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/tick.png"))); // NOI18N
        jBtConfirmar.setText("Confirmar");
        jBtConfirmar.setEnabled(false);
        jBtConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtConfirmarActionPerformed(evt);
            }
        });

        jBtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelar.setText("Cancelar");
        jBtCancelar.setEnabled(false);
        jBtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarActionPerformed(evt);
            }
        });

        jPanel41.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Teste rápido/Cirurgias", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("VDRL:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Hepatite C:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Hepatite B:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("HIV:");

        jComboBoxVDRL.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxVDRL.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não reagente", "Reagente", "Não Realizado" }));
        jComboBoxVDRL.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxVDRL.setEnabled(false);

        jComboBoxHepatiteC.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxHepatiteC.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não reagente", "Reagente", "Não realizado" }));
        jComboBoxHepatiteC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxHepatiteC.setEnabled(false);

        jComboBoxHepatiteB.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxHepatiteB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não reagente", "Reagente", "Não realizado" }));
        jComboBoxHepatiteB.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxHepatiteB.setEnabled(false);

        jComboBoxHIV.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxHIV.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não reagente", "Reagente", "Não realizado" }));
        jComboBoxHIV.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxHIV.setEnabled(false);

        jLabel91.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel91.setText("Cirurgias:");

        jComboBoxCirurgia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxCirurgia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim", "Não Realizado" }));
        jComboBoxCirurgia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxCirurgia.setEnabled(false);

        jLabel92.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel92.setText("Quais:");

        jQualCirurgia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualCirurgia.setEnabled(false);

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel36.setText("Sifilis:");

        jComboBoxSifilis.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxSifilis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não reagente", "Reagente", "Não Realizado" }));
        jComboBoxSifilis.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxSifilis.setEnabled(false);

        jLabel106.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel106.setText("Diabetes:");

        jComboBoxDiabetes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDiabetes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim", "N/R" }));
        jComboBoxDiabetes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDiabetes.setEnabled(false);

        jLabel109.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel109.setText("Tuberculose:");
        jLabel109.setToolTipText("Tuberculose");

        jComboBoxTuberculose.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTuberculose.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Negativo", "Positivo", "Não Realizado" }));
        jComboBoxTuberculose.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTuberculose.setEnabled(false);

        jLabel84.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel84.setText("Hipertensão:");
        jLabel84.setToolTipText("Hipertensão");

        jComboBoxHipertensao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxHipertensao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim", "N/R" }));
        jComboBoxHipertensao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxHipertensao.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("Escabiose:");

        jComboBoxEscabiose.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxEscabiose.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim", "N/R" }));
        jComboBoxEscabiose.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxEscabiose.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setText("Hanseniase:");

        jComboBoxHanseniase.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxHanseniase.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não reagente", "Reagente", "Não Realizado" }));
        jComboBoxHanseniase.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxHanseniase.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 0, 0));
        jLabel3.setText("DST:");

        jComboBoxDST.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDST.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não reagente", "Reagente", "Não Realizado" }));
        jComboBoxDST.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDST.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 0, 0));
        jLabel4.setText("HPV:");

        jComboBoxHPV.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxHPV.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim", "N/R" }));
        jComboBoxHPV.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxHPV.setEnabled(false);

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel91, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBoxCirurgia, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxHIV, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxHanseniase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxVDRL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxSifilis, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel92, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel109, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxDST, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxTuberculose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxHepatiteB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxHepatiteC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel41Layout.createSequentialGroup()
                                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxEscabiose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxHPV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel41Layout.createSequentialGroup()
                                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel106)
                                    .addComponent(jLabel84))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxHipertensao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxDiabetes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jQualCirurgia, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel41Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jComboBoxDST, jComboBoxHepatiteB, jComboBoxHepatiteC, jComboBoxTuberculose});

        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10)
                    .addComponent(jComboBoxVDRL, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxHepatiteC, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel106)
                    .addComponent(jComboBoxDiabetes, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel13)
                    .addComponent(jComboBoxHIV, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jComboBoxHepatiteB, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel84)
                    .addComponent(jComboBoxHipertensao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel36)
                    .addComponent(jComboBoxSifilis, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel109)
                    .addComponent(jComboBoxTuberculose, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxEscabiose, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxHanseniase, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxDST, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBoxHPV, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel91)
                    .addComponent(jComboBoxCirurgia, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel92)
                    .addComponent(jQualCirurgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtConfirmar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterar, jBtCancelar, jBtConfirmar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtAlterar)
                    .addComponent(jBtConfirmar)
                    .addComponent(jBtCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        // TODO add your handling code here:
        if (acao == 1 || acao == 2) {
            jComboBoxDiabetes.setEnabled(true);
            jComboBoxHipertensao.setEnabled(true);
            jComboBoxEscabiose.setEnabled(true);
            jComboBoxHanseniase.setEnabled(true);
            jComboBoxSifilis.setEnabled(true);
            jComboBoxTuberculose.setEnabled(true);
            jComboBoxEscabiose.setEnabled(true);
            jComboBoxHIV.setEnabled(true);
            jComboBoxDST.setEnabled(true);
            jComboBoxVDRL.setEnabled(true);
            jComboBoxHepatiteB.setEnabled(true);
            jComboBoxHepatiteC.setEnabled(true);
            jComboBoxHPV.setEnabled(true);
            jComboBoxCirurgia.setEnabled(true);
            jQualCirurgia.setEnabled(true);
            //
            jBtAlterar.setEnabled(!true);
            jBtCancelar.setEnabled(true);
            jBtConfirmar.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Você não está em modo de inserção ou alteração para poder modificar o registro.");
        }
    }//GEN-LAST:event_jBtAlterarActionPerformed

    private void jBtConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtConfirmarActionPerformed
        // TODO add your handling code here:
        pVdrl = (String) jComboBoxVDRL.getSelectedItem();
        pHepatiteC = (String) jComboBoxHepatiteC.getSelectedItem();
        pHepatiteB = (String) jComboBoxHIV.getSelectedItem();
        pHiv = (String) jComboBoxHIV.getSelectedItem();
        pCirurgias = (String) jComboBoxCirurgia.getSelectedItem();
        pQualCirurgias = jQualCirurgia.getText();
        pSifilis = (String) jComboBoxSifilis.getSelectedItem();
        pHipertensao = (String) jComboBoxHipertensao.getSelectedItem();
        pDiabetes = (String) jComboBoxDiabetes.getSelectedItem();
        pTuberculose = (String) jComboBoxTuberculose.getSelectedItem();
        pHanseniase = (String) jComboBoxHanseniase.getSelectedItem();
        pDst = (String) jComboBoxDST.getSelectedItem();
        pEscabiose = (String) jComboBoxEscabiose.getSelectedItem();
        pHpv = (String) jComboBoxHPV.getSelectedItem();     
        dispose();
    }//GEN-LAST:event_jBtConfirmarActionPerformed

    private void jBtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarActionPerformed
        // TODO add your handling code here:
        buscarDadosExistentes();
        //
        jComboBoxDiabetes.setEnabled(!true);
        jComboBoxHipertensao.setEnabled(!true);
        jComboBoxEscabiose.setEnabled(!true);
        jComboBoxHanseniase.setEnabled(!true);
        jComboBoxSifilis.setEnabled(!true);
        jComboBoxTuberculose.setEnabled(!true);
        jComboBoxEscabiose.setEnabled(!true);
        jComboBoxHIV.setEnabled(!true);
        jComboBoxDST.setEnabled(!true);
        jComboBoxVDRL.setEnabled(!true);
        jComboBoxHepatiteB.setEnabled(!true);
        jComboBoxHepatiteC.setEnabled(!true);
        jComboBoxHPV.setEnabled(!true);
        jComboBoxCirurgia.setEnabled(!true);
        jQualCirurgia.setEnabled(!true);
        //
        jBtAlterar.setEnabled(true);
        jBtCancelar.setEnabled(!true);
        jBtConfirmar.setEnabled(!true);
    }//GEN-LAST:event_jBtCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaTRC1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaTRC1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaTRC1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaTRC1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaTRC1 dialog = new TelaTRC1(taeTRC, true);
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
    private javax.swing.JButton jBtConfirmar;
    private javax.swing.JComboBox jComboBoxCirurgia;
    private javax.swing.JComboBox<String> jComboBoxDST;
    private javax.swing.JComboBox jComboBoxDiabetes;
    private javax.swing.JComboBox jComboBoxEscabiose;
    private javax.swing.JComboBox jComboBoxHIV;
    private javax.swing.JComboBox jComboBoxHPV;
    private javax.swing.JComboBox<String> jComboBoxHanseniase;
    private javax.swing.JComboBox jComboBoxHepatiteB;
    private javax.swing.JComboBox jComboBoxHepatiteC;
    private javax.swing.JComboBox jComboBoxHipertensao;
    private javax.swing.JComboBox<String> jComboBoxSifilis;
    private javax.swing.JComboBox<String> jComboBoxTuberculose;
    private javax.swing.JComboBox jComboBoxVDRL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JTextField jQualCirurgia;
    // End of variables declaration//GEN-END:variables

    public void corCampos() {
        jQualCirurgia.setBackground(Color.white);
    }

    public void buscarDadosExistentes() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ADMISSAOENFERMEIRA "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ADMISSAOENFERMEIRA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE IdLanc='" + jIdADM_Secundaria.getText() + "'");
            conecta.rs.first();
            jComboBoxVDRL.setSelectedItem(conecta.rs.getString("Vdrl"));
            jComboBoxHepatiteC.setSelectedItem(conecta.rs.getString("HepatiteC"));
            jComboBoxHepatiteB.setSelectedItem(conecta.rs.getString("HepatiteB"));
            jComboBoxHIV.setSelectedItem(conecta.rs.getString("Hiv"));
            jComboBoxSifilis.setSelectedItem(conecta.rs.getString("Sifilis"));
            jComboBoxHipertensao.setSelectedItem(conecta.rs.getString("Hipertensao"));
            jComboBoxDiabetes.setSelectedItem(conecta.rs.getString("Diabetes"));
            jComboBoxTuberculose.setSelectedItem(conecta.rs.getString("Tuberculose"));
            jComboBoxCirurgia.setSelectedItem(conecta.rs.getString("Cirurgias"));
            jQualCirurgia.setText(conecta.rs.getString("QuaisCirurgias"));
            jComboBoxEscabiose.setSelectedItem(conecta.rs.getString("Escabiose"));
            jComboBoxDST.setSelectedItem(conecta.rs.getString("Dst"));
            jComboBoxHPV.setSelectedItem(conecta.rs.getString("Hpv"));
            jComboBoxHanseniase.setSelectedItem(conecta.rs.getString("Hanseniase"));
        } catch (SQLException e) {
        }
        conecta.desconecta();
    }
}
