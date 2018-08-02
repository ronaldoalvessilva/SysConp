/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControleSelecaoKitsCompleto;
import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.GravarInternosKitCompleto;
import gestor.Modelo.LogSistema;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jIdRegistroComp;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jTabelaInternosKitCompleto;
import java.awt.Rectangle;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author ronal
 */
public class TelaGravarInternosKitCompleto extends javax.swing.JDialog {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    GravarInternosKitCompleto objGravaIntComp = new GravarInternosKitCompleto();
    ControleSelecaoKitsCompleto controle = new ControleSelecaoKitsCompleto();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log   
    String nomeModuloTela2 = "Almoxarifado:Montagem de Pagamento do Kit de Interno:Gravar Internos Kir Completo";
    //    
    int idRegPavInt = 0;
    int codigoPavilhao = 0;
    String statusMov = "";
    String horaMov = "";
    String dataModFinal = "";
    int pGravado = 1;
    String pUtili = "Sim";
    int codigoInterno = 0;
    int codigoRegistro = 0;

    /**
     * Creates new form TelaGravarInternosKitCompleto
     */
    public static TelaMontagemPagamentoKitInterno montaKitIntComp;

    public TelaGravarInternosKitCompleto(TelaMontagemPagamentoKitInterno parent, boolean modal) {
        this.montaKitIntComp = parent;
        this.setModal(modal);
        setLocationRelativeTo(montaKitIntComp);
        initComponents();
        gravarDadosBanco();
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
        jProgressBar1 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("...::: Gravar Internos Kit Completo :::...");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Aguarde....");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216082327_48.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jProgressBar1.setStringPainted(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(TelaGravarInternosKitCompleto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaGravarInternosKitCompleto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaGravarInternosKitCompleto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaGravarInternosKitCompleto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaGravarInternosKitCompleto dialog = new TelaGravarInternosKitCompleto(montaKitIntComp, true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables

    public void gravarDadosBanco() {
        // THREAD DOS DADOS
        try {
            Thread t0 = new Thread() {
                public void run() {
                    statusMov = "Incluiu";
                    horaMov = jHoraSistema.getText();
                    dataModFinal = jDataSistema.getText();
                    // GRAVAR NA TABELA ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO                    
                    for (int i = 0; i < jTabelaInternosKitCompleto.getRowCount(); i++) {//  
                        objGravaIntComp.setUsuarioInsert(nameUser);
                        objGravaIntComp.setDataInsert(dataModFinal);
                        objGravaIntComp.setHorarioInsert(horaMov);
                        //
                        objGravaIntComp.setIdRegistroComp(Integer.valueOf(jIdRegistroComp.getText()));// TABELA PRINCIPAL (COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE)                                                        
                        objGravaIntComp.setIdInternoCrc((int) jTabelaInternosKitCompleto.getValueAt(i, 0));
                        objGravaIntComp.setNomeInternoCrc((String) jTabelaInternosKitCompleto.getValueAt(i, 1));
                        objGravaIntComp.setGravado(pGravado);
                        // VERIFICAR SE O INTERNO JÁ SE ENCONTRA GRAVADO NA TABELA PARA PARA O MESMO REGISTRO
                        verificarInternoBancoDados(objGravaIntComp.getIdRegistroComp(), objGravaIntComp.getIdInternoCrc());
                        // SE O REGISTRO FOR IGUAL E O INTERNO DIFERENTE, GRAVA
                        if (objGravaIntComp.getIdRegistroComp() == codigoRegistro && objGravaIntComp.getIdInternoCrc() != codigoInterno) {
                            controle.incluirInternosKitCompleto(objGravaIntComp);
                            buscarCodigoRegistroInternoKitCompleto();
                            // FAZ UM UPDATE NA TABELA INTERNOS_PAVILHAO_KIT_LOTE INFORMANDO A UTILIZAÇÃO DOS INTERNOS PARA 
                            // O KIT COMPLETO
                            objGravaIntComp.setUtili(pUtili);
                            controle.atualizarInternosPavilhao(objGravaIntComp);
                            objLog2();
                            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação  
                            // SE O REGISTRO FOR DIFERENTE GRAVA OS NOVOS INTERNOS
                        } else if (objGravaIntComp.getIdRegistroComp() != codigoRegistro) {
                            controle.incluirInternosKitCompleto(objGravaIntComp);
                            buscarCodigoRegistroInternoKitCompleto();
                            // FAZ UM UPDATE NA TABELA INTERNOS_PAVILHAO_KIT_LOTE INFORMANDO A UTILIZAÇÃO DOS INTERNOS PARA 
                            // O KIT COMPLETO
                            objGravaIntComp.setUtili(pUtili);
                            controle.atualizarInternosPavilhao(objGravaIntComp);
                            objLog2();
                            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação  
                            // SE O CODIGO DO INTERNO FOR ZERO
                        } else if (codigoRegistro == 0) {
                            controle.incluirInternosKitCompleto(objGravaIntComp);
                            buscarCodigoRegistroInternoKitCompleto();
                            // FAZ UM UPDATE NA TABELA INTERNOS_PAVILHAO_KIT_LOTE INFORMANDO A UTILIZAÇÃO DOS INTERNOS PARA 
                            // O KIT COMPLETO
                            objGravaIntComp.setUtili(pUtili);
                            controle.atualizarInternosPavilhao(objGravaIntComp);
                            objLog2();
                            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação  
                            // SE O CODIGO DO REGISTRO FOR DIFERENTE E O CÓDIGO DO INTERNO FOR DIFERENTE GRAVA
                        } else if (objGravaIntComp.getIdRegistroComp() != codigoRegistro && objGravaIntComp.getIdInternoCrc() != codigoInterno) {
                            controle.incluirInternosKitCompleto(objGravaIntComp);
                            buscarCodigoRegistroInternoKitCompleto();
                            // FAZ UM UPDATE NA TABELA INTERNOS_PAVILHAO_KIT_LOTE INFORMANDO A UTILIZAÇÃO DOS INTERNOS PARA 
                            // O KIT COMPLETO
                            objGravaIntComp.setUtili(pUtili);
                            controle.atualizarInternosPavilhao(objGravaIntComp);
                            objLog2();
                            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação  
                        }
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
                    jProgressBar1.setMaximum(jTabelaInternosKitCompleto.getRowCount());
                    Rectangle rect;
                    for (int i = 0; i < jTabelaInternosKitCompleto.getRowCount(); i++) {
                        rect = jTabelaInternosKitCompleto.getCellRect(i, 0, true);
                        try {
                            jTabelaInternosKitCompleto.scrollRectToVisible(rect);
                        } catch (java.lang.ClassCastException e) {
                        }
                        jTabelaInternosKitCompleto.setRowSelectionInterval(i, 1);
                        jProgressBar1.setValue((i + 1));
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                        }
                    }
                    jProgressBar1.setValue(0);
                    JOptionPane.showMessageDialog(rootPane, "Operação Concluída com sucesso...");
                    dispose();
                    try {
                    } catch (Exception e) {
                    }
                }
            };
            t.start();
        } catch (Exception e) {
        }
    }

    // PEGAR O ID PARA O LOG2
    public void buscarCodigoRegistroInternoKitCompleto() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO");
            conecta.rs.last();
            idRegPavInt = conecta.rs.getInt("IdRegIntAgrupComp");
        } catch (Exception ERROR) {
        }
        conecta.desconecta();
    }

    // VERIFICAR SE O INTERNO JÁ FOI INCLUÍDO NO BANCO DE DADOS
    // PARA NÃO SER GRAVADO MAIS DE UMA VEZ NO MESMO KIT
    public void verificarInternoBancoDados(int codigoReg, int codInternoCrc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO "
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
