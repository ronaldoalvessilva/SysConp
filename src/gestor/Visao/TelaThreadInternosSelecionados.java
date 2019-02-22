/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleAtualizaInternoKits;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControlePavilhaoInternosMontaKitInicial;
import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.LogSistema;
import gestor.Modelo.PavilhaoInternosMontagemKit;
import gestor.Modelo.ProntuarioCrc;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jBtExcluirTodosInternos;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jBtExcluirUmInterno;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jBtNovoPavInternos;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jBtSelecionarTodosInternos;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jBtSelecionarUmInterno;
//import static gestor.Visao.TelaMontagemPagamentoKitInterno.codigoPavilhao;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jComboBoxPavilhoes;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jIdRegistroComp;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jTabelaInternosSelecionados;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.pTipoKitCI;
import java.awt.Rectangle;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author ronal
 */
public class TelaThreadInternosSelecionados extends javax.swing.JDialog {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    PavilhaoInternosMontagemKit objPavInt = new PavilhaoInternosMontagemKit();
    ControlePavilhaoInternosMontaKitInicial controle = new ControlePavilhaoInternosMontaKitInicial();
    //
    ControleAtualizaInternoKits controleKits = new ControleAtualizaInternoKits();
    ProntuarioCrc objProCrc = new ProntuarioCrc();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log   
    String nomeModuloTela2 = "Almoxarifado:Montagem de Pagamento do Kit de Interno:Pavilhão/Internos";
    //    
    int idRegPavInt = 0;
    int codigoPavilhao = 0;
    String statusMov = "";
    String horaMov = "";
    String dataModFinal = "";
    String pUtili = "Não";
    String opcaoKit = "Sim";
    //
    int codigoInterno = 0;
    int codigoRegistro = 0;

    /**
     * Creates new form TelaThreadInternosSelecionados
     */
    public static TelaMontagemPagamentoKitInterno threadIntSelect;

    public TelaThreadInternosSelecionados(TelaMontagemPagamentoKitInterno parent, boolean modal) {
        this.threadIntSelect = parent;
        this.setModal(modal);
        setLocationRelativeTo(threadIntSelect);
        initComponents();
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE); //Impedir que a janela seja fechada pelo X  
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
        jProgressBar1 = new javax.swing.JProgressBar();
        jBtConfirmar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("ATENÇÃO: Essa operação irá gravar os dados no banco de dados, aguarde até o termino");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setText("da operação.");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216082336_128.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        jProgressBar1.setStringPainted(true);

        jBtConfirmar.setForeground(new java.awt.Color(0, 102, 0));
        jBtConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/40_16x16.png"))); // NOI18N
        jBtConfirmar.setText("Confirmar");
        jBtConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtConfirmarActionPerformed(evt);
            }
        });

        jBtSair.setForeground(new java.awt.Color(204, 0, 0));
        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/shutdown-icone-6920-16.png"))); // NOI18N
        jBtSair.setText("Sair");
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSair)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtConfirmar, jBtSair});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtConfirmar)
                    .addComponent(jBtSair))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtConfirmarActionPerformed
        // TODO add your handling code here:
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente confirmar essa operação?", "Confirmação",
                JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            Integer row = jTabelaInternosSelecionados.getRowCount();
            if (row == 0) {
                JOptionPane.showMessageDialog(rootPane, "Não existe internos selecionados para pagamento dos kits.");
            } else {
                jBtConfirmar.setEnabled(!true);
                jBtSair.setEnabled(!true);
                // THREAD DOS DADOS
                try {
                    Thread t0 = new Thread() {
                        public void run() {
                            statusMov = "Incluiu";
                            horaMov = jHoraSistema.getText();
                            dataModFinal = jDataSistema.getText();
                            // GRAVAR NA TABELA INTERNOS_SELECIONADOS_KIT_LOTE                     
                            for (int i = 0; i < jTabelaInternosSelecionados.getRowCount(); i++) {//  
                                objPavInt.setUsuarioInsert(nameUser);
                                objPavInt.setDataInsert(dataModFinal);
                                objPavInt.setHorarioInsert(horaMov);
                                //
                                objPavInt.setpUtili(pUtili);
                                objPavInt.setIdRegistroComp(Integer.valueOf(jIdRegistroComp.getText()));// TABELA PRINCIPAL (COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE)                        
                                objPavInt.setIdPav(codigoPavilhao); // CÓDIGO DO PAVILHÃO
                                objPavInt.setDescricaoPavilhao((String) jComboBoxPavilhoes.getSelectedItem());
                                objPavInt.setIdInternoCrc((int) jTabelaInternosSelecionados.getValueAt(i, 0));
                                objPavInt.setNomeInternoCrc((String) jTabelaInternosSelecionados.getValueAt(i, 2));
                                // VERIFICAR SE O INTERNO JÁ SE ENCONTRA GRAVADO NA TABELA PARA PARA O MESMO REGISTRO
                                verificarInternoBancoDados(objPavInt.getIdRegistroComp(), objPavInt.getIdInternoCrc());
                                // SE O REGISTRO FOR IGUAL E O INTERNO DIFERENTE, GRAVA
                                if (objPavInt.getIdRegistroComp() == codigoRegistro && objPavInt.getIdInternoCrc() != codigoInterno) {
                                    controle.incluirPavilhaoInternos(objPavInt);
                                    // SE O REGISTRO FOR DIFERENTE GRAVA OS NOVOS INTERNOS
                                } else if (objPavInt.getIdRegistroComp() != codigoRegistro) {
                                    controle.incluirPavilhaoInternos(objPavInt);
                                    // SE O CODIGO DO INTERNO FOR ZERO
                                } else if (codigoRegistro == 0) {
                                    controle.incluirPavilhaoInternos(objPavInt);
                                    // SE O CODIGO DO REGISTRO FOR DIFERENTE E O CÓDIGO DO INTERNO FOR DIFERENTE GRAVA
                                } else if (objPavInt.getIdRegistroComp() != codigoRegistro && objPavInt.getIdInternoCrc() != codigoInterno) {
                                    controle.incluirPavilhaoInternos(objPavInt);
                                }
                                // 1 - INICIAL, 2 - DECENDIAL, 3 - QUINZENAL, 4 - MENSAL, 5 - SEMESTRAL, 6 - ANUAL
                                switch (pTipoKitCI) {
                                    case 1:
                                        objProCrc.setKitIPago(opcaoKit);
                                        objProCrc.setIdInterno((int) jTabelaInternosSelecionados.getValueAt(i, 0));
                                        controleKits.atualizarInternoKitInicial(objProCrc);
                                        break;
                                    case 2:
                                        objProCrc.setKitDecendial(opcaoKit);
                                        objProCrc.setIdInterno((int) jTabelaInternosSelecionados.getValueAt(i, 0));
                                        controleKits.atualizarInternoKitDecendial(objProCrc);
                                        break;
                                    case 3:
                                        objProCrc.setKitQuinzenal(opcaoKit);
                                        objProCrc.setIdInterno((int) jTabelaInternosSelecionados.getValueAt(i, 0));
                                        controleKits.atualizarInternoKitQuinzenal(objProCrc);
                                        break;
                                    case 4:
                                        objProCrc.setKitMensal(opcaoKit);
                                        objProCrc.setIdInterno((int) jTabelaInternosSelecionados.getValueAt(i, 0));
                                        controleKits.atualizarInternoKitMensal(objProCrc);
                                        break;
                                    case 5:
                                        objProCrc.setKitSemestral(opcaoKit);
                                        objProCrc.setIdInterno((int) jTabelaInternosSelecionados.getValueAt(i, 0));
                                        controleKits.atualizarInternoKitSemestral(objProCrc);
                                        break;
                                    case 6:
                                        objProCrc.setKitAnual(opcaoKit);
                                        objProCrc.setIdInterno((int) jTabelaInternosSelecionados.getValueAt(i, 0));
                                        controleKits.atualizarInternoKitAnual(objProCrc);
                                        break;
                                    default:
                                        break;
                                }
                                buscarCodigoRegistroPavilhaoInterno();
                                objLog2();
                                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação                                 
                            }
                            try {
                                Thread.sleep(10);
                            } catch (InterruptedException ex) {
                            }
                        }
                    };
                    t0.start();
                } catch (Exception e) {
                }
                // THREAD DA BARRA DE EXECUÇÃO
                try {
                    Thread t = new Thread() {
                        public void run() {
                            jProgressBar1.setMaximum(jTabelaInternosSelecionados.getRowCount());
                            Rectangle rect;
                            for (int i = 0; i < jTabelaInternosSelecionados.getRowCount(); i++) {
                                rect = jTabelaInternosSelecionados.getCellRect(i, 0, true);
                                try {
                                    jTabelaInternosSelecionados.scrollRectToVisible(rect);
                                } catch (java.lang.ClassCastException e) {
                                }
                                jTabelaInternosSelecionados.setRowSelectionInterval(i, 0);
                                jProgressBar1.setValue((i + 1));
                                try {
                                    Thread.sleep(100);
                                } catch (InterruptedException ex) {
                                }
                            }
                            jProgressBar1.setValue(0);
                            JOptionPane.showMessageDialog(rootPane, "Operação Concluída com sucesso...");
                            jBtSair.setEnabled(true);
                            try {
                            } catch (Exception e) {
                            }
                        }
                    };
                    t.start();
                } catch (Exception e) {
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Operação Cancelada...");
        }
    }//GEN-LAST:event_jBtConfirmarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        jBtNovoPavInternos.setEnabled(true);
        jBtSelecionarUmInterno.setEnabled(true);
        jBtSelecionarTodosInternos.setEnabled(true);
        jBtExcluirUmInterno.setEnabled(true);
        jBtExcluirTodosInternos.setEnabled(true);
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

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
            java.util.logging.Logger.getLogger(TelaThreadInternosSelecionados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaThreadInternosSelecionados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaThreadInternosSelecionados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaThreadInternosSelecionados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaThreadInternosSelecionados dialog = new TelaThreadInternosSelecionados(threadIntSelect, true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables

    // PEGAR O ID PARA O LOG2
    public void buscarCodigoRegistroPavilhaoInterno() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM INTERNOS_PAVILHAO_KIT_LOTE");
            conecta.rs.last();
            idRegPavInt = conecta.rs.getInt("IdRegPavInt");
        } catch (Exception ERROR) {
        }
        conecta.desconecta();
    }

    // VERIFICAR SE O INTERNO JÁ FOI INCLUÍDO NO BANCO DE DADOS
    // PARA NÃO SER GRAVADO MAIS DE UMA VEZ NO MESMO KIT
    public void verificarInternoBancoDados(int codigoReg, int codInternoCrc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM INTERNOS_PAVILHAO_KIT_LOTE "
                    + "WHERE IdRegistroComp='" + codigoReg + "' "
                    + "AND IdInternoCrc='" + codInternoCrc + "'");
            conecta.rs.last();
            codigoInterno = conecta.rs.getInt("IdInternoCrc");
            codigoRegistro = conecta.rs.getInt("IdRegistroComp");
        } catch (Exception ERROR) {
        }
        conecta.desconecta();
    }

    public void objLog2() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela2);
        objLogSys.setIdLancMov(Integer.valueOf(jIdRegistroComp.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }
}
