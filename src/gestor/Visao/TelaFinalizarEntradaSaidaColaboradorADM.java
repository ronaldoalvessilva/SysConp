/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleListaSSA;
import gestor.Controle.ControleListaTransferenciaColaVC;
import gestor.Controle.ControleTransferenciaColaboradorUnidades;
import gestor.Modelo.ColaboradoresTransferenciasUnidades;
import static gestor.Visao.TelaEntradaSaidasColaboradores.jTabelaColaborador;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo.silva7
 */
public class TelaFinalizarEntradaSaidaColaboradorADM extends javax.swing.JDialog {

    ControleTransferenciaColaboradorUnidades control = new ControleTransferenciaColaboradorUnidades();
    ColaboradoresTransferenciasUnidades objCola = new ColaboradoresTransferenciasUnidades();
    ControleListaSSA controlSSA = new ControleListaSSA();
    ControleListaTransferenciaColaVC controlVC = new ControleListaTransferenciaColaVC();
    //
    int pCODIGO_func = 0;
    public static String pNOME_colaborador = "";
    public static String pNOME_MAE_colaborador = "";
    public static String pRESPOSTA_reposta = "";

    /**
     * Creates new form TelaFinalizarEntradaSaidaColaboradorADM
     */
    public static TelaEntradaSaidasColaboradores pENTRADA_SAIDA_colaboradores;

    public TelaFinalizarEntradaSaidaColaboradorADM(TelaEntradaSaidasColaboradores parent, boolean modal) {
        this.pENTRADA_SAIDA_colaboradores = parent;
        this.setModal(modal);
        setLocationRelativeTo(pENTRADA_SAIDA_colaboradores);
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
        jComboBoxLocalDestino = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxDepartamentoPesquisa = new javax.swing.JComboBox<>();
        jComboBoxCargoPesquisa = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jBtConfirmar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("...::: Finalizar Entrada/Saída Colaborador :::...");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));
        jPanel1.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("UNIDADE DE DESTINO");

        jComboBoxLocalDestino.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxLocalDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "CPLF - Conjunto Penal de Lauro de Freitas", "CPMS - Conjunto Penal Masculino de Salvador", "CPVC - Conjunto Penal de Vitória da Conquista", "CPIT - Conjunto Penal de Itabuna", "CPBA - Conjunto Penal de Barreiras" }));
        jComboBoxLocalDestino.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxLocalDestino.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxLocalDestinoItemStateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("DEPARTAMENTO - (SETOR)");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("CARGO - (FUNÇÃO)");

        jComboBoxDepartamentoPesquisa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDepartamentoPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione..." }));
        jComboBoxDepartamentoPesquisa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jComboBoxCargoPesquisa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxCargoPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione..." }));
        jComboBoxCargoPesquisa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(299, 299, 299))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jComboBoxDepartamentoPesquisa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxLocalDestino, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxCargoPesquisa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxLocalDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxDepartamentoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxCargoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jBtConfirmar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSair)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtConfirmar, jBtSair});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtConfirmar)
                    .addComponent(jBtSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtConfirmarActionPerformed
        // TODO add your handling code here:
        if (jComboBoxLocalDestino.getSelectedItem().equals("Selecione...")) {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma unidade para realizar a transferência da ficha cadastral do colaborador.");
        } else if (jComboBoxLocalDestino.getSelectedItem().equals("CPLF - Conjunto Penal de Lauro de Freitas")) {

        } else if (jComboBoxLocalDestino.getSelectedItem().equals("CPMS - Conjunto Penal Masculino de Salvador")) {
            final ViewAguardeProcessando carregando = new ViewAguardeProcessando(); //Teste tela aguarde
            carregando.setVisible(true);//Teste tela aguarde
            Thread t = new Thread() { //Teste tela aguarde
                public void run() { //Teste
                    for (int i = 0; i < jTabelaColaborador.getRowCount(); i++) {
                        objCola.setIdFunc((int) jTabelaColaborador.getValueAt(i, 1));
                        pCODIGO_func = (int) jTabelaColaborador.getValueAt(i, 1);
                        objCola.setNomeFuncionario((String) jTabelaColaborador.getValueAt(i, 2));
                        objCola.setNomeMae((String) jTabelaColaborador.getValueAt(i, 5));
                        //VERIFICAR NO DESTINO SE JÁ EXISTE O COLABORADOR
                        control.pPESQUISAR_colaboradorSSA(objCola.getNomeFuncionario(), objCola.getNomeMae());
                        if (pNOME_colaborador.equals(objCola.getNomeFuncionario()) && pNOME_MAE_colaborador.equals(objCola.getNomeMae())) {
                            JOptionPane.showMessageDialog(rootPane, "Colaborador já tem ficha cadastrado na unidade de destino.");
                        } else {
                            try {
                                pPESQUISAR_COLABORADOR_gravar();
                            } catch (Exception ex) {
                                Logger.getLogger(TelaFinalizarEntradaSaidaColaboradorADM.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            //GRAVAR NA TABELA OS DADOS DO COLABORADOR
//                                    if (pCODIGO_func != ff.getIdFunc()) {
                            control.incluirColaboradorSSA(objCola);
                            BUSCAR_codigo();
                            control.incluirEnderecosColaboradorLF(objCola);
                            control.incluirDocumentosColaborador(objCola);
                            carregando.dispose(); //Teste tela aguarde
//                                    }
                        }
                    }
                }
            }; //Teste tela aguarde
            t.start(); //Teste tela aguarde
        } else if (jComboBoxLocalDestino.getSelectedItem().equals("CPVC - Conjunto Penal de Vitória da Conquista")) {

        } else if (jComboBoxLocalDestino.getSelectedItem().equals("CPIT - Conjunto Penal de Itabuna")) {

        } else if (jComboBoxLocalDestino.getSelectedItem().equals("CPBA - Conjunto Penal de Barreiras")) {

        }
    }//GEN-LAST:event_jBtConfirmarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jComboBoxLocalDestinoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxLocalDestinoItemStateChanged
        // TODO add your handling code here:
        if (jComboBoxLocalDestino.getSelectedItem().equals("Selecione...")) {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma unidade prisional.");
        } else if (jComboBoxLocalDestino.getSelectedItem().equals("CPLF - Conjunto Penal de Lauro de Freitas")) {

        } else if (jComboBoxLocalDestino.getSelectedItem().equals("CPMS - Conjunto Penal Masculino de Salvador")) {
            control.pPESQUISAR_cargoSSA(objCola);
            control.pPESQUISAR_departamentoSSA(objCola);
        } else if (jComboBoxLocalDestino.getSelectedItem().equals("CPVC - Conjunto Penal de Vitória da Conquista")) {

        } else if (jComboBoxLocalDestino.getSelectedItem().equals("CPIT - Conjunto Penal de Itabuna")) {

        } else if (jComboBoxLocalDestino.getSelectedItem().equals("CPBA - Conjunto Penal de Barreiras")) {

        }
    }//GEN-LAST:event_jComboBoxLocalDestinoItemStateChanged

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
            java.util.logging.Logger.getLogger(TelaFinalizarEntradaSaidaColaboradorADM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaFinalizarEntradaSaidaColaboradorADM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaFinalizarEntradaSaidaColaboradorADM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaFinalizarEntradaSaidaColaboradorADM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaFinalizarEntradaSaidaColaboradorADM dialog = new TelaFinalizarEntradaSaidaColaboradorADM(pENTRADA_SAIDA_colaboradores, true);
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
    public static javax.swing.JComboBox<String> jComboBoxCargoPesquisa;
    public static javax.swing.JComboBox<String> jComboBoxDepartamentoPesquisa;
    private javax.swing.JComboBox<String> jComboBoxLocalDestino;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    public void pPESQUISAR_COLABORADOR_gravar() throws Exception {
        for (ColaboradoresTransferenciasUnidades ff : controlVC.read()) {
            objCola.setIdFunc(ff.getIdFunc());
            objCola.setStatusFunc(ff.getStatusFunc());
            objCola.setDataCadastro(ff.getDataCadastro());
            objCola.setNomeFuncionario(ff.getNomeFuncionario());
            objCola.setSexo(ff.getSexo());
            objCola.setEscolaridade(ff.getEscolaridade());
            objCola.setMatricula(ff.getMatricula());
            objCola.setNomeCargo((String) jComboBoxCargoPesquisa.getSelectedItem());
            objCola.setNomeDepartamento((String) jComboBoxDepartamentoPesquisa.getSelectedItem());
            objCola.setEstadoCivil(ff.getEstadoCivil());
            objCola.setDataNascimento(ff.getDataNascimento());
            objCola.setNomeMae(ff.getNomeMae());
            objCola.setNomePai(ff.getNomePai());
            objCola.setReligiao(ff.getReligiao());
            objCola.setTipoSangue(ff.getTipoSangue());
            objCola.setCargaHoraria(ff.getCargaHoraria());
            objCola.setRegimeTrabalho(ff.getRegimeTrabalho());
            objCola.setHorarioInicio(ff.getHorarioInicio());
            objCola.setHorarioFinal(ff.getHorarioFinal());
            objCola.setFuncao(ff.getFuncao());
            objCola.setNacionalidade(ff.getNacionalidade());
            objCola.setPais(ff.getPais());
            objCola.setNaturalidade(ff.getNaturalidade());
            objCola.setEstadoNacionalidade(ff.getEstadoNacionalidade());
            objCola.setImagemFrenteCO(ff.getImagemFrenteCO());
        }
    }

    public void BUSCAR_codigo() {
        control.PESQUISAR_codigo(objCola);
    }
}
