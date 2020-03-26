/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleComposicaoKit;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControleProximoKitDecendial;
import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ComposicaoKit;
import gestor.Modelo.GravarInternosKitCompleto;
import gestor.Modelo.LogSistema;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaProgramacaoKitsHigiene.jDataPrevisao;
import static gestor.Visao.TelaProgramacaoKitsHigiene.jDataUltimoPagto;
import static gestor.Visao.TelaProgramacaoKitsHigiene.jTabelaDestino;
import static gestor.Visao.TelaProgramacaoKitsHigiene.idPROG;
import java.awt.Rectangle;
import java.util.Date;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author ronal
 */
public class TelaGravarProximoKitDecendialInd extends javax.swing.JDialog {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ComposicaoKit objComp = new ComposicaoKit();
    ControleComposicaoKit control = new ControleComposicaoKit();
    //
    GravarInternosKitCompleto objGravaIntComp = new GravarInternosKitCompleto();
    ControleProximoKitDecendial controle = new ControleProximoKitDecendial();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log   
    String nomeModuloTela2 = "Almoxarifado:Montagem de Pagamento do Kit de Interno:Gravar Kit Decendial";
    //    
    int IdRegInternosKC = 0;
    int codigoPavilhao = 0;
    String statusMov = "";
    String horaMov = "";
    String dataModFinal = "";
    int pGravado = 1;
    String pUtili = "Sim";
    String utilizado = "Não";
    String kitPago = "Não";
    int codigoInterno = 0;
    int codigoRegistro = 0;
    int tipoKit = 0; // 0 - COMPLETO E 1 INCOMPLETO
    //
    String progGerada = "Sim";
    Date data;
    int pTOTAL_REGISTROS = 0;
    int pTOTAL_REGISTROS_PRO = 0;

    /**
     * Creates new form TelaGravarInternosKitCompleto
     */
    public static TelaProgramacaoKitsHigiene gravarProximooKitDecendial;

    public TelaGravarProximoKitDecendialInd(TelaProgramacaoKitsHigiene parent, boolean modal) {
        this.gravarProximooKitDecendial = parent;
        this.setModal(modal);
        setLocationRelativeTo(gravarProximooKitDecendial);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTOTAL_REG_COPIADO = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTOTAL_REG_GRAVADO = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("...::: Gravar Internos para Próximo Kit :::...");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Gravando Internos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(204, 0, 0))); // NOI18N

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
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jProgressBar1.setStringPainted(true);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 0, 0));
        jLabel4.setText("Registros Verificados:");

        jTOTAL_REG_COPIADO.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTOTAL_REG_COPIADO.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTOTAL_REG_COPIADO.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTOTAL_REG_COPIADO.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTOTAL_REG_COPIADO.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 0, 0));
        jLabel5.setText("Registros Gravados:");

        jTOTAL_REG_GRAVADO.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTOTAL_REG_GRAVADO.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTOTAL_REG_GRAVADO.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTOTAL_REG_GRAVADO.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTOTAL_REG_GRAVADO.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTOTAL_REG_COPIADO, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTOTAL_REG_GRAVADO, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4)
                    .addComponent(jTOTAL_REG_COPIADO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTOTAL_REG_GRAVADO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
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
            java.util.logging.Logger.getLogger(TelaGravarProximoKitDecendialInd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaGravarProximoKitDecendialInd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaGravarProximoKitDecendialInd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaGravarProximoKitDecendialInd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaGravarProximoKitDecendialInd dialog = new TelaGravarProximoKitDecendialInd(gravarProximooKitDecendial, true);
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JTextField jTOTAL_REG_COPIADO;
    private javax.swing.JTextField jTOTAL_REG_GRAVADO;
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
                    for (int i = 0; i < jTabelaDestino.getRowCount(); i++) {//  
                        objGravaIntComp.setUsuarioInsert(nameUser);
                        objGravaIntComp.setDataInsert(dataModFinal);
                        objGravaIntComp.setHorarioInsert(horaMov);
                        //
                        objGravaIntComp.setIDREG_PROG(idPROG);
                        objGravaIntComp.setDataPagamento(jDataUltimoPagto.getDate());
                        objGravaIntComp.setDataPrevisao(jDataPrevisao.getDate());
                        objGravaIntComp.setKitPago(kitPago);
                        objGravaIntComp.setUtili(utilizado);
                        objGravaIntComp.setIdInternoCrc((int) jTabelaDestino.getValueAt(i, 0));
                        objGravaIntComp.setNomeInternoCrc((String) jTabelaDestino.getValueAt(i, 1));
                        // VERIFICAR SE O INTERNO JÁ SE ENCONTRA GRAVADO NA TABELA PARA PARA O MESMO REGISTRO
                        verificarInternoBancoDados(objGravaIntComp.getIDREG_PROG(), objGravaIntComp.getIdInternoCrc());
                        // SE O REGISTRO FOR IGUAL E O INTERNO DIFERENTE, GRAVA
                        if (objGravaIntComp.getIDREG_PROG() == codigoRegistro && objGravaIntComp.getIdInternoCrc() != codigoInterno) {
                            controle.incluirProximoKitDecendial(objGravaIntComp);
                            buscarCodigoRegistroInternoKitCompleto();
                            objLog2();
                            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação  
                            // SE O REGISTRO FOR DIFERENTE GRAVA OS NOVOS INTERNOS
                        } else if (objGravaIntComp.getIDREG_PROG() != codigoRegistro) {
                            controle.incluirProximoKitDecendial(objGravaIntComp);
                            buscarCodigoRegistroInternoKitCompleto();
                            objLog2();
                            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação  
                            // SE O CODIGO DO INTERNO FOR ZERO
                        } else if (codigoRegistro == 0) {
                            controle.incluirProximoKitDecendial(objGravaIntComp);
                            buscarCodigoRegistroInternoKitCompleto();
                            objLog2();
                            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação  
                            // SE O CODIGO DO REGISTRO FOR DIFERENTE E O CÓDIGO DO INTERNO FOR DIFERENTE GRAVA
                        } else if (objGravaIntComp.getIDREG_PROG() != codigoRegistro && objGravaIntComp.getIdInternoCrc() != codigoInterno) {
                            controle.incluirProximoKitDecendial(objGravaIntComp);
                            buscarCodigoRegistroInternoKitCompleto();
                            objLog2();
                            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação  
                        }
                        pTOTAL_REGISTROS_PRO = i + 1;
                        jTOTAL_REG_GRAVADO.setText(String.valueOf(pTOTAL_REGISTROS_PRO));
                        jProgressBar1.setValue(i);
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
                    jProgressBar1.setMaximum(jTabelaDestino.getRowCount());
                    Rectangle rect;
                    for (int i = 0; i < jTabelaDestino.getRowCount(); i++) {
                        rect = jTabelaDestino.getCellRect(i, 0, true);
                        try {
                            jTabelaDestino.scrollRectToVisible(rect);
                        } catch (java.lang.ClassCastException e) {
                        }
//                        jTabelaDestino.setRowSelectionInterval(i, 1);
//                        jProgressBar1.setValue((i + 1));
                        //RETIRADO POR QUE QUANDO A TABELA SÓ TEM UMA LINHA ESTAVA
                        //DANDO ERRO. TESTAR COM MAIS DE UMA LINHA.
                        if (i == 0) {
                            jTabelaDestino.setRowSelectionInterval(i, 0);
                            jProgressBar1.setValue((i + 1));
                        } else if (i > 0) {
                            jTabelaDestino.setRowSelectionInterval(i, 1);
                            jProgressBar1.setValue((i + 1));
                        }
                        pTOTAL_REGISTROS = i + 1;
                        jTOTAL_REG_COPIADO.setText(String.valueOf(pTOTAL_REGISTROS));
                        jProgressBar1.setValue(i);
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
            conecta.executaSQL("SELECT * FROM KITS_DECENDIAL_INTERNOS");
            conecta.rs.last();
            IdRegInternosKC = conecta.rs.getInt("IdKitDecendial");
        } catch (Exception ERROR) {
        }
        conecta.desconecta();
    }

    // VERIFICAR SE O INTERNO JÁ FOI INCLUÍDO NO BANCO DE DADOS
    // PARA NÃO SER GRAVADO MAIS DE UMA VEZ NO MESMO KIT
    public void verificarInternoBancoDados(int codigoReg, int codInternoCrc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM KITS_DECENDIAL_INTERNOS "
                    + "WHERE IDREG_PROG='" + codigoReg + "' "
                    + "AND IdInternoCrc='" + codInternoCrc + "'");
            conecta.rs.last();
            codigoInterno = conecta.rs.getInt("IdInternoCrc");
            codigoRegistro = conecta.rs.getInt("IDREG_PROG");
        } catch (Exception ERROR) {
        }
        conecta.desconecta();
    }

    public void objLog2() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela2);
        objLogSys.setIdLancMov(Integer.valueOf(idPROG));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }
}
