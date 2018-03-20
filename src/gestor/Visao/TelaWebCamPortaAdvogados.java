/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Dao.ConexaoBancoDados;
import static gestor.Visao.TelaAdvogados.caminhoAdvogados;
import static gestor.Visao.TelaAdvogados.FotoAdvogado;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;

/**
 *
 * @author Ronaldo
 */
public class TelaWebCamPortaAdvogados extends javax.swing.JDialog {

    ConexaoBancoDados conecta = new ConexaoBancoDados();

    String localFotoAdvogado = "";

    private DaemonThread myThread = null;
    int count = 0;
    VideoCapture webSource = null;

    Mat frame = new Mat();
    MatOfByte mem = new MatOfByte();

    /**
     * Creates new form SnapShot
     *
     * @param parent
     * @param modal
     */
    public static TelaAdvogados telaAdvogados;

    //TESTADO E FUNCIONANDO NO DIA 02/12/2016 - EM VITÓRIA DA CONQUISTA
    public TelaWebCamPortaAdvogados(TelaAdvogados parent, boolean modal) {
        this.telaAdvogados = parent;
        this.setModal(modal);
        setLocationRelativeTo(telaAdvogados);
        initComponents();
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    class DaemonThread implements Runnable {

        protected volatile boolean runnable = false;

        @Override
        public void run() {
            synchronized (this) {
                while (runnable) {
                    if (webSource.grab()) {
                        try {
                            webSource.retrieve(frame);
                            Highgui.imencode(".bmp", frame, mem);
                            Image im = ImageIO.read(new ByteArrayInputStream(mem.toArray()));
                            BufferedImage buff = (BufferedImage) im;
                            Graphics g = jPanel1.getGraphics();

                            if (g.drawImage(buff, 0, 0, getWidth(), getHeight() - 150, 0, 0, buff.getWidth(), buff.getHeight(), null)) {
                                if (runnable == false) {
                                    System.out.println("Going to wait()");
                                    this.wait();
                                }
                            }
                        } catch (Exception ex) {
                            System.out.println("ERRO: " + ex);
                        }
                    }
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jBtIniciar = new javax.swing.JButton();
        jBtParar = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("...::: WebCam :::...");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Imagem", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(415, 300));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtIniciar.setForeground(new java.awt.Color(0, 0, 255));
        jBtIniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_find.png"))); // NOI18N
        jBtIniciar.setText("Iniciar");
        jBtIniciar.setToolTipText("Inicia a captura da imagem");
        jBtIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtIniciarActionPerformed(evt);
            }
        });

        jBtParar.setForeground(new java.awt.Color(255, 0, 0));
        jBtParar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216082320_16.png"))); // NOI18N
        jBtParar.setText("Pausa");
        jBtParar.setToolTipText("Pausa a captura da imagem");
        jBtParar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPararActionPerformed(evt);
            }
        });

        jBtSalvar.setForeground(new java.awt.Color(0, 153, 0));
        jBtSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvar.setText("Salvar");
        jBtSalvar.setToolTipText("Salvar imagem em local especifico");
        jBtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarActionPerformed(evt);
            }
        });

        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSair.setText("Sair");
        jBtSair.setToolTipText("Sair da tela");
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
                .addContainerGap()
                .addComponent(jBtIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtParar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSair)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtIniciar, jBtParar, jBtSair, jBtSalvar});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtIniciar)
                    .addComponent(jBtParar)
                    .addComponent(jBtSalvar)
                    .addComponent(jBtSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("WebCam - Java");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel2, jPanel3});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );

        setSize(new java.awt.Dimension(451, 452));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtIniciarActionPerformed
        // TODO add your handling code here:
        webSource = new VideoCapture(0);
        myThread = new DaemonThread();
        Thread t = new Thread(myThread);
        t.setDaemon(true);
        myThread.runnable = true;
        t.start();
        jBtIniciar.setEnabled(false);  //start button
        jBtParar.setEnabled(true);  // stop button
    }//GEN-LAST:event_jBtIniciarActionPerformed

    private void jBtPararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPararActionPerformed
        // TODO add your handling code here:
        myThread.runnable = false;
        jBtParar.setEnabled(false);
        jBtIniciar.setEnabled(true);
        webSource.release();
    }//GEN-LAST:event_jBtPararActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        localFotoAdvogado();
        if (localFotoAdvogado == null || localFotoAdvogado == "") {
            javax.swing.JFileChooser seletor = new javax.swing.JFileChooser();
            FileNameExtensionFilter tipoExtensao = new FileNameExtensionFilter("Imagem de Foto", "jpg", "bmp", "gif", "png");
            seletor.setAcceptAllFileFilterUsed(false);
            seletor.setMultiSelectionEnabled(false);
            seletor.setFileFilter(tipoExtensao);
            int acao = seletor.showOpenDialog(this);
            if (acao == JFileChooser.APPROVE_OPTION) {
                java.io.File f = new File(seletor.getSelectedFile().getAbsolutePath());
                caminhoAdvogados = f.getPath();
                if (f.getPath().endsWith("jpg") || f.getPath().endsWith("JPG")) {
                    Highgui.imwrite(f.getPath(), frame);
                    javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminhoAdvogados);
                    FotoAdvogado.setIcon(i);
                    ImageIcon image = new ImageIcon(seletor.getSelectedFile().getPath());
                    FotoAdvogado.setIcon(new ImageIcon(image.getImage().getScaledInstance(FotoAdvogado.getWidth(), FotoAdvogado.getHeight(), Image.SCALE_DEFAULT)));
                    caminhoAdvogados = f.getPath();
                } else if (f.getPath().endsWith("")) {
                    JOptionPane.showMessageDialog(rootPane, "Informe uma extensão de arquivo de foto válida. '" + ".jpg" + "'");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Seleção da foto foi cancelada");
            }
        } else {
            javax.swing.JFileChooser seletor = new javax.swing.JFileChooser(localFotoAdvogado);
            FileNameExtensionFilter tipoExtensao = new FileNameExtensionFilter("Imagem de Foto", "jpg", "bmp", "gif", "png");
            seletor.setAcceptAllFileFilterUsed(false);
            seletor.setMultiSelectionEnabled(false);
            seletor.setFileFilter(tipoExtensao);
            int acao = seletor.showOpenDialog(this);
            if (acao == JFileChooser.APPROVE_OPTION) {
                java.io.File f = new File(seletor.getSelectedFile().getAbsolutePath());
                caminhoAdvogados = f.getPath();
                if (f.getPath().endsWith("jpg") || f.getPath().endsWith("JPG")) {
                    Highgui.imwrite(f.getPath(), frame);
                    javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminhoAdvogados);
                    FotoAdvogado.setIcon(i);
                    ImageIcon image = new ImageIcon(seletor.getSelectedFile().getPath());
                    FotoAdvogado.setIcon(new ImageIcon(image.getImage().getScaledInstance(FotoAdvogado.getWidth(), FotoAdvogado.getHeight(), Image.SCALE_DEFAULT)));
                    caminhoAdvogados = f.getPath();
                } else if (f.getPath().endsWith("")) {
                    JOptionPane.showMessageDialog(rootPane, "Informe uma extensão de arquivo de foto válida. '" + ".jpg" + "'");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Seleção da foto foi cancelada");
            }
        }

    }//GEN-LAST:event_jBtSalvarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        myThread.runnable = false;
        webSource.release();
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
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
            java.util.logging.Logger.getLogger(TelaWebCamPortaAdvogados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaWebCamPortaAdvogados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaWebCamPortaAdvogados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaWebCamPortaAdvogados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaWebCamPortaAdvogados dialog = new TelaWebCamPortaAdvogados(telaAdvogados, true);
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
    private javax.swing.JButton jBtIniciar;
    private javax.swing.JButton jBtParar;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables

    public void localFotoAdvogado() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PARAMETROSCRC");
            conecta.rs.first();
            localFotoAdvogado = conecta.rs.getString("LocalFotosAdvogados");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
