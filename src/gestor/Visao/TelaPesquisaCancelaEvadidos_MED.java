/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import Utilitarios.ModeloTabela;
import gestor.Controle.ControleCancelamentoEvasao;
import gestor.Modelo.CancelamentoEvasao;
import static gestor.Visao.TelaCancelamentoEvasao.jDataEvasao;
import static gestor.Visao.TelaCancelamentoEvasao.jDataSaida;
import static gestor.Visao.TelaCancelamentoEvasao.jDocumentoSaida;
import static gestor.Visao.TelaCancelamentoEvasao.jIdInternoEvadido;
import static gestor.Visao.TelaCancelamentoEvasao.jIdRegistroEvasao;
import static gestor.Visao.TelaCancelamentoEvasao.jIdSaida;
import static gestor.Visao.TelaCancelamentoEvasao.jNomeInternoEvadido;
import static gestor.Visao.TelaCancelamentoEvasao.jStatusEvasao;
import static gestor.Visao.TelaCancelamentoEvasao.jTipoEvasao;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Ronaldo
 */
public class TelaPesquisaCancelaEvadidos_MED extends javax.swing.JInternalFrame {

    CancelamentoEvasao objCancelaEvasao = new CancelamentoEvasao();
    ControleCancelamentoEvasao CONTROLE = new ControleCancelamentoEvasao();
    //
    int flag;
    String idInt;
    String pDATA_saida = "";
    String pDATA_evasao = "";
    public static int pTOTAL_REGISTROS_medico = 0;
    //
    public static String nomeInterno_SM;
    public static String idItem_CESMedico;
    public static String pCODIGO_INTERNO_medico;
    public static String pCODIGO_SAIDA_medico;

    /**
     * Creates new form TelaPesqInternosEvadidosManual
     */
    public TelaPesquisaCancelaEvadidos_MED() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPesqNomeInternoEvadido_MED = new javax.swing.JTextField();
        jBtPesqNomeInternoEvadido = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jBtSelecionar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaIntEvadidosSaidaMedico = new javax.swing.JTable();
        jPanel32 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("...::: Pesquisa de Internos Saída Médico {Evadido} :::..");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/11985_16x16.png"))); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Nome:");

        jPesqNomeInternoEvadido_MED.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqNomeInternoEvadido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqNomeInternoEvadido.setContentAreaFilled(false);
        jBtPesqNomeInternoEvadido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqNomeInternoEvadidoActionPerformed(evt);
            }
        });

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox1.setText("Todos");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPesqNomeInternoEvadido_MED)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtPesqNomeInternoEvadido, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPesqNomeInternoEvadido_MED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jBtPesqNomeInternoEvadido, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jBtSelecionar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtSelecionar.setForeground(new java.awt.Color(0, 102, 0));
        jBtSelecionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/accept.png"))); // NOI18N
        jBtSelecionar.setText("Selecionar");
        jBtSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSelecionarActionPerformed(evt);
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

        jTabelaIntEvadidosSaidaMedico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaIntEvadidosSaidaMedico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Código", "Nome do Interno", "Código Saída", "Data Saída", "Data Evasão", "Tipo de Saída"
            }
        ));
        jTabelaIntEvadidosSaidaMedico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaIntEvadidosSaidaMedicoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaIntEvadidosSaidaMedico);
        if (jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumnCount() > 0) {
            jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(1).setMinWidth(80);
            jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(1).setMaxWidth(80);
            jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(2).setMinWidth(250);
            jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(2).setMaxWidth(250);
            jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(3).setMinWidth(80);
            jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(3).setMaxWidth(80);
            jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(4).setMinWidth(80);
            jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(4).setMaxWidth(80);
            jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(5).setMinWidth(80);
            jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(5).setMaxWidth(80);
            jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(6).setMinWidth(200);
            jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(6).setMaxWidth(200);
        }

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtSelecionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSair)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtSair, jBtSelecionar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtSelecionar)
                    .addComponent(jBtSair))
                .addGap(5, 5, 5))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtSair, jBtSelecionar});

        setBounds(300, 20, 664, 311);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSelecionarActionPerformed
        // TODO add your handling code here:
        if (jPesqNomeInternoEvadido_MED.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um nome de interno a ser selecionado.");
        } else if (idItem_CESMedico == null) {
            JOptionPane.showMessageDialog(rootPane, "Selecione corretamente o nome do interno..");
        } else {
            //ABA DADOS DO INTERNO - MOVISR
            CONTROLE.PESQUISAR_DADOS_INTERNO_SM_evasao(objCancelaEvasao);
            jIdSaida.setText(String.valueOf(objCancelaEvasao.getIdSaida()));
            jIdInternoEvadido.setText(String.valueOf(objCancelaEvasao.getIdInternoCrc()));
            jNomeInternoEvadido.setText(objCancelaEvasao.getNomeInternoCrc());
            jDataSaida.setDate(objCancelaEvasao.getDataSaida());
            jDocumentoSaida.setText(objCancelaEvasao.getNrDocSaida());
            //ABA DADOS EVASÃO - EVADIDOIND
            CONTROLE.ENVIAR_DADOS_REGISTRO_SM_evasao(objCancelaEvasao);
            jIdRegistroEvasao.setText(String.valueOf(objCancelaEvasao.getIdRegistroEvasao()));
            jStatusEvasao.setText(objCancelaEvasao.getStatusLanc());
            jDataEvasao.setDate(objCancelaEvasao.getDataEvasao());
            jTipoEvasao.setText(objCancelaEvasao.getTipoOperacao());
            dispose();
        }
    }//GEN-LAST:event_jBtSelecionarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtPesqNomeInternoEvadidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNomeInternoEvadidoActionPerformed
        // TODO add your handling code here:
        if (jPesqNomeInternoEvadido_MED.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o nome do interno para pesquisa.");
        } else {
            PREENCHER_TABELA_EVADIDOS_MEDICO_nome();
            if (pTOTAL_REGISTROS_medico == 0) {
                JOptionPane.showMessageDialog(rootPane, "Não existem registros a serem exibidos.");
            }
        }
    }//GEN-LAST:event_jBtPesqNomeInternoEvadidoActionPerformed

    private void jTabelaIntEvadidosSaidaMedicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaIntEvadidosSaidaMedicoMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            pCODIGO_SAIDA_medico = "" + jTabelaIntEvadidosSaidaMedico.getValueAt(jTabelaIntEvadidosSaidaMedico.getSelectedRow(), 3);
            nomeInterno_SM = "" + jTabelaIntEvadidosSaidaMedico.getValueAt(jTabelaIntEvadidosSaidaMedico.getSelectedRow(), 2);
            jPesqNomeInternoEvadido_MED.setText(nomeInterno_SM);
            pCODIGO_INTERNO_medico = "" + jTabelaIntEvadidosSaidaMedico.getValueAt(jTabelaIntEvadidosSaidaMedico.getSelectedRow(), 1);
            idItem_CESMedico = "" + jTabelaIntEvadidosSaidaMedico.getValueAt(jTabelaIntEvadidosSaidaMedico.getSelectedRow(), 0);
        }
    }//GEN-LAST:event_jTabelaIntEvadidosSaidaMedicoMouseClicked

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:                
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            PREENCHER_TABELA_EVADIDOS_MEDICO_todos();
            if (pTOTAL_REGISTROS_medico == 0) {
                JOptionPane.showMessageDialog(rootPane, "Não existem registros a serem exibidos.");
            }
        } else {
            limparTabela();
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtPesqNomeInternoEvadido;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSelecionar;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    public static javax.swing.JTextField jPesqNomeInternoEvadido_MED;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabelaIntEvadidosSaidaMedico;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void PREENCHER_TABELA_EVADIDOS_MEDICO_nome() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código", "Nome do Interno ", "Código Saída", "Data Saída", "Dt.Evasão", "Tipo de Saída"};
        CONTROLE.PESQUISAR_INTERNO_nome(objCancelaEvasao);
        pDATA_saida = String.valueOf(objCancelaEvasao.getDataSaida());
        if (pDATA_saida != null) {
            String dia = pDATA_saida.substring(8, 10);
            String mes = pDATA_saida.substring(5, 7);
            String ano = pDATA_saida.substring(0, 4);
            pDATA_saida = dia + "/" + mes + "/" + ano;
        }
        pDATA_evasao = objCancelaEvasao.getDataPesquisaEvasao();
        if (pDATA_evasao != null || !pDATA_evasao.equals("")) {
            String pDia = pDATA_evasao.substring(8, 10);
            String pMes = pDATA_evasao.substring(5, 7);
            String pAno = pDATA_evasao.substring(0, 4);
            pDATA_evasao = pDia + "/" + pMes + "/" + pAno;
        }
        dados.add(new Object[]{objCancelaEvasao.getIdItem(), objCancelaEvasao.getIdInternoCrc(), objCancelaEvasao.getNomeInternoCrc(), objCancelaEvasao.getIdSaida(), pDATA_saida, pDATA_evasao, objCancelaEvasao.getNomeDestino()});
        jtotalRegistros.setText(Integer.toString(pTOTAL_REGISTROS_medico));
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaIntEvadidosSaidaMedico.setModel(modelo);
        jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(0).setResizable(false);
        jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(1).setResizable(false);
        jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(2).setPreferredWidth(250);
        jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(2).setResizable(false);
        jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(3).setResizable(false);
        jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(4).setResizable(false);
        jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(5).setPreferredWidth(80);
        jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(5).setResizable(false);
        jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(6).setPreferredWidth(200);
        jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(6).setResizable(false);
        jTabelaIntEvadidosSaidaMedico.getTableHeader().setReorderingAllowed(false);
        jTabelaIntEvadidosSaidaMedico.setAutoResizeMode(jTabelaIntEvadidosSaidaMedico.AUTO_RESIZE_OFF);
        jTabelaIntEvadidosSaidaMedico.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinhaColunasTabelaEvadidosSaidaTemporaria();
    }

    public void PREENCHER_TABELA_EVADIDOS_MEDICO_todos() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código", "Nome do Interno ", "Código Saída", "Data Saída", "Dt.Evasão", "Tipo de Saída"};
        try {
            for (CancelamentoEvasao dd : CONTROLE.LISTA_REGISTROS_EVADIDOS_SM_todos()) {
                pDATA_saida = String.valueOf(dd.getDataSaida());
                if (pDATA_saida != null) {
                    String dia = pDATA_saida.substring(8, 10);
                    String mes = pDATA_saida.substring(5, 7);
                    String ano = pDATA_saida.substring(0, 4);
                    pDATA_saida = dia + "/" + mes + "/" + ano;
                }
                //
                pDATA_evasao = dd.getDataPesquisaEvasao();
                if (pDATA_evasao != null || !pDATA_evasao.equals("")) {
                    String pDia = pDATA_evasao.substring(8, 10);
                    String pMes = pDATA_evasao.substring(5, 7);
                    String pAno = pDATA_evasao.substring(0, 4);
                    pDATA_evasao = pDia + "/" + pMes + "/" + pAno;
                }
                dados.add(new Object[]{dd.getIdItem(), dd.getIdInternoCrc(), dd.getNomeInternoCrc(), dd.getIdSaida(), pDATA_saida, pDATA_evasao, dd.getNomeDestino()});
                jtotalRegistros.setText(Integer.toString(pTOTAL_REGISTROS_medico));
                ModeloTabela modelo = new ModeloTabela(dados, Colunas);
                jTabelaIntEvadidosSaidaMedico.setModel(modelo);
                jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(0).setPreferredWidth(70);
                jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(0).setResizable(false);
                jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(1).setPreferredWidth(80);
                jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(1).setResizable(false);
                jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(2).setPreferredWidth(250);
                jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(2).setResizable(false);
                jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(3).setPreferredWidth(80);
                jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(3).setResizable(false);
                jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(4).setPreferredWidth(80);
                jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(4).setResizable(false);
                jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(5).setPreferredWidth(80);
                jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(5).setResizable(false);
                jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(6).setPreferredWidth(200);
                jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(6).setResizable(false);
                jTabelaIntEvadidosSaidaMedico.getTableHeader().setReorderingAllowed(false);
                jTabelaIntEvadidosSaidaMedico.setAutoResizeMode(jTabelaIntEvadidosSaidaMedico.AUTO_RESIZE_OFF);
                jTabelaIntEvadidosSaidaMedico.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                alinhaColunasTabelaEvadidosSaidaTemporaria();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaPesquisaCancelaEvadidos_MED.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void limparTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código", "Nome do Interno ", "Código Saída", "Data Saída", "Dt.Evasão", "Tipo de Saída"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaIntEvadidosSaidaMedico.setModel(modelo);
        jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(0).setResizable(false);
        jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(1).setResizable(false);
        jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(2).setPreferredWidth(250);
        jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(2).setResizable(false);
        jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(3).setResizable(false);
        jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(4).setResizable(false);
        jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(5).setPreferredWidth(80);
        jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(5).setResizable(false);
        jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(6).setPreferredWidth(200);
        jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(6).setResizable(false);
        jTabelaIntEvadidosSaidaMedico.getTableHeader().setReorderingAllowed(false);
        jTabelaIntEvadidosSaidaMedico.setAutoResizeMode(jTabelaIntEvadidosSaidaMedico.AUTO_RESIZE_OFF);
        jTabelaIntEvadidosSaidaMedico.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinhaColunasTabelaEvadidosSaidaTemporaria() {
        //
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        //
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(3).setCellRenderer(centralizado);
        jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(4).setCellRenderer(centralizado);
        jTabelaIntEvadidosSaidaMedico.getColumnModel().getColumn(5).setCellRenderer(centralizado);
    }
}
