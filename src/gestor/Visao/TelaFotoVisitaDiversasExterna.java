/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Dao.ConexaoBancoDados;
import static gestor.Visao.TelaEntradaSaidaVisitasDiversas.jIDVisita;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author ronaldo
 */
public class TelaFotoVisitaDiversasExterna extends javax.swing.JDialog {

    ConexaoBancoDados conecta = new ConexaoBancoDados();

    String caminhoFoto;

    public static TelaEntradaSaidaVisitasDiversasExterna telafotovisitaExterna;

    /**
     * Creates new form TelaFotoCrc
     */
    public TelaFotoVisitaDiversasExterna(TelaEntradaSaidaVisitasDiversasExterna parent, boolean modal) {
        this.telafotovisitaExterna = parent;
        this.setModal(modal);
        setLocationRelativeTo(telafotovisitaExterna);
        initComponents();
        buscarFotoVisita();
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
        FotoVisitasDiversas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("...::: Foto Visita Diversas :::...");

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(FotoVisitasDiversas, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(FotoVisitasDiversas, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(TelaFotoVisitaDiversasExterna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaFotoVisitaDiversasExterna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaFotoVisitaDiversasExterna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaFotoVisitaDiversasExterna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaFotoVisitaDiversasExterna dialog = new TelaFotoVisitaDiversasExterna(telafotovisitaExterna, true);
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
    private javax.swing.JLabel FotoVisitasDiversas;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    public void buscarFotoVisita() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM VISITASDIVERSAS WHERE IdVisita='" + jIDVisita.getText() + "'");
            conecta.rs.first();
            caminhoFoto = conecta.rs.getString("FotoVisita");
            if (caminhoFoto != null) {
                javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminhoFoto);
                FotoVisitasDiversas.setIcon(i);
                FotoVisitasDiversas.setIcon(new ImageIcon(i.getImage().getScaledInstance(FotoVisitasDiversas.getWidth(), FotoVisitasDiversas.getHeight(), Image.SCALE_DEFAULT)));
            }
            // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
            byte[] img2Bytes = ((byte[]) conecta.rs.getBytes("ImagemFrenteVI"));
            if (img2Bytes != null) {
                ImageIcon pic2 = null;
                pic2 = new ImageIcon(img2Bytes);
                Image scaled2 = pic2.getImage().getScaledInstance(FotoVisitasDiversas.getWidth(), FotoVisitasDiversas.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon icon2 = new ImageIcon(scaled2);
                FotoVisitasDiversas.setIcon(icon2);
            }
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
