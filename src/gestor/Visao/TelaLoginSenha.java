/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.LimiteDigitosMin;
import gestor.Modelo.ControleVersao;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Ronaldo
 */
// Inicio do desenvolvimento 20/03/2014
public class TelaLoginSenha extends javax.swing.JDialog {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ControleVersao versao = new ControleVersao();

    public static int Codstatus;
    public static String idUserAcesso; // CÓDIGO DO USUÁRIO PERMISSÕES DE ACESSO (24/04/2016)
    public static String nameUser; // Variavel para o nome do usuário logado
    public static long tamanhoOrigem, tamanhoDestino;
    public static long dataOrigem, dataDestino;
    // NOME DA EMPRESA E UNIDADE PENAL PARA SER UTILIZADO NA TELA PRINCIPAL E NOS RELATÓRIOS
    public static String razaoSocial;
    public static String descricaoUnidade;
    public static Double versaoAtualSistema;
    public static String enderecoUnidadePrisional;
    String bairroUnidade;
    String cidadeUnidade;
    String estadoUnidade;
    int codigoEmpresa = 0;
    //
    String caminhoExecutavel = "";
    String caminhoExecutavelAntigo = "";
    String dataVersao;
    //
    public static String hostNameSRV;
    public static String ipHostSRV;

    /**
     * Creates new form TelaLoginSenha
     *
     * @param parent
     * @param modal
     */
    public TelaLoginSenha(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        // Modelo de resolução de tela no Windows
        try {
//             JFrame.setDefaultLookAndFeelDecorated(true);      
//            SkinLookAndFeel.setSkin(SkinLookAndFeel.loadThemePack("/skins/coronaHthemepack.zip"));
//            UIManager.setLookAndFeel("com.l2fprod.gui.plaf.skin.SkinLookAndFeel");
//            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel ");
//            UIManager.setLookAndFeel("javax.swing.plaf.mac.MacLookAndFeel");
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
        }
        initComponents();
        formatarCampos();
        // Modificar a tecla tab por enter
//        HashSet conj = new HashSet(this.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
//        conj.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0));
//        this.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, conj);
    }

    public void acessarSistema() {

        try {
            ConexaoBancoDados conecta = new ConexaoBancoDados();
            conecta.abrirConexao();
            conecta.executaSQL("SELECT IdUsuario,LoginUsuario,SenhaUsuario,StatusUsuario,NomeUsuario FROM USUARIOS "
                    + "WHERE LoginUsuario='" + jUsuario.getText() + "' "
                    + "AND SenhaUsuario='" + jPassword.getText() + "'");
            conecta.rs.first();
            // Verifica se o usuario e a senha são iguais ao banco de dados            
            Codstatus = conecta.rs.getInt("StatusUsuario");
            if (jUsuario.getText().equals(conecta.rs.getString("LoginUsuario"))
                    && (jPassword.getText()).equals(conecta.rs.getString("SenhaUsuario"))
                    && Codstatus == 0) {
                JOptionPane.showMessageDialog(null, "Usuário INATIVO !!!");
            } else {
                if (jUsuario.getText().equals(conecta.rs.getString("LoginUsuario"))
                        && (jPassword.getText()).equals(conecta.rs.getString("SenhaUsuario"))
                        && (Codstatus == 1)) {
                    buscarEmpresa();
                    // COMPARAR O ARQUIVO EXECUTAVEL PARA REALIZAR ATUALIZAÇÃO
                    if (caminhoExecutavelAntigo == null) {
                        JOptionPane.showMessageDialog(rootPane, "O caminho do arquivo executavel antigo não existe, solicite ajuda ao Administrador do Sistema.");
                    } else {
                        File origem = new File(caminhoExecutavelAntigo);
                        dataOrigem = origem.lastModified(); // Data do arquivo de origem
                        tamanhoOrigem = origem.length();  // Tamanho do arquivo de origem        
                        File destino = new File("C://SysConp//SysConp.jar");
                        dataDestino = destino.lastModified();
                        tamanhoDestino = destino.length();
                        if (origem.exists() && destino.exists()) {
                            if (dataOrigem > dataDestino || tamanhoOrigem > tamanhoDestino) {
                                int resposta = JOptionPane.showConfirmDialog(this, "Existe uma nova atualização, deseja fazer isso agora?", "Confirmação",
                                        JOptionPane.YES_NO_OPTION);
                                if (resposta == JOptionPane.YES_OPTION) {
                                    // CHAMA O EXECUTAVEL DE INSTALAÇÃO
                                    Install_Sisconp();
                                    // UPDATE NO BANCO PARA ATUALIZAR A VERSÃO.
                                    versao.setVersao(Double.parseDouble(jNumeroVersao.getText()));
//                                java.util.Date data = new java.util.Date();
                                    versao.setDataVersao(dataVersao);
                                    PreparedStatement pst = conecta.con.prepareStatement("UPDATE EMPRESA SET VersaoAtual=?,DataVersao=? "
                                            + "WHERE IdEmpresa='" + codigoEmpresa + "'");
                                    pst.setDouble(1, versao.getVersao());
                                    pst.setTimestamp(2, new java.sql.Timestamp(versao.getDataVersao().getTime()));
                                    pst.execute();
                                    System.exit(0);
                                } else {
                                    versao.setVersao(Double.parseDouble(jNumeroVersao.getText()));
                                    if (versaoAtualSistema > versao.getVersao()) {
                                        JOptionPane.showMessageDialog(rootPane, "Não é possível acessar o sistema, seu sistema está desatualizado. Faça a atualização e só assim você poderá acessar o sistema.");
                                    } else {
                                        idUserAcesso = conecta.rs.getString("IdUsuario");
                                        nameUser = conecta.rs.getString("NomeUsuario");
                                        TelaModuloPrincipal tp = new TelaModuloPrincipal(jUsuario.getText(), nameUser);
                                        tp.setVisible(true);
                                        conecta.desconecta();
                                        this.dispose();
                                    }
                                }
                            } else {
                                idUserAcesso = conecta.rs.getString("IdUsuario");
                                nameUser = conecta.rs.getString("NomeUsuario");
                                TelaModuloPrincipal tp = new TelaModuloPrincipal(jUsuario.getText(), nameUser);
                                tp.setVisible(true);
                                conecta.desconecta();
                                this.dispose();
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Usuario ou senha Inváldo, tente novamente !!!");
                    jUsuario.setText("");
                    jPassword.setText("");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, "Usuario ou senha Inváldo, tente novamente !!!");
            jUsuario.setText("");
            jPassword.setText("");
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

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jNumeroVersao = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPassword = new javax.swing.JPasswordField();
        jUsuario = new javax.swing.JTextField();
        jBtCancelar = new javax.swing.JButton();
        jBtAcessar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("...::: Tela de Acesso :::...");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/gestor/Imagens/FavonIconJFrame100.png")));
        setResizable(false);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "SISCONP - Sistema de Controle Prisional", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(0, 0, 204))); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Logomarcas do sistema", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 102, 0))); // NOI18N

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Brasao96.png"))); // NOI18N
        jLabel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/logoSocializa200RAS.png"))); // NOI18N
        jLabel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Versão do Sistema:");

        jNumeroVersao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jNumeroVersao.setForeground(new java.awt.Color(255, 0, 0));
        jNumeroVersao.setText("5.9");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jNumeroVersao)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jNumeroVersao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Login e Senha", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Senha:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Usuário:");

        jPassword.setToolTipText("Informe Senha");
        jPassword.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordActionPerformed(evt);
            }
        });
        jPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordKeyPressed(evt);
            }
        });

        jUsuario.setToolTipText("Informe Nome de Usuário");
        jUsuario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUsuarioActionPerformed(evt);
            }
        });
        jUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jUsuarioKeyPressed(evt);
            }
        });

        jBtCancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/shutdown-icone-6920-32.png"))); // NOI18N
        jBtCancelar.setText("Cancelar");
        jBtCancelar.setToolTipText("Cancelar operação");
        jBtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarActionPerformed(evt);
            }
        });

        jBtAcessar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtAcessar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/ok-icon32.png"))); // NOI18N
        jBtAcessar.setText("Acessar");
        jBtAcessar.setToolTipText("Acessar sistema");
        jBtAcessar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAcessarActionPerformed(evt);
            }
        });
        jBtAcessar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jBtAcessarKeyPressed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/User_login_Icon_64.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                            .addComponent(jUsuario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jBtAcessar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtCancelar)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAcessar, jBtCancelar});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtAcessar)
                    .addComponent(jBtCancelar))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAcessar, jBtCancelar});

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 16, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 197, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtAcessarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAcessarActionPerformed
        // TODO add your handling code here:        
        acessarSistema();
    }//GEN-LAST:event_jBtAcessarActionPerformed

    private void jBtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jBtCancelarActionPerformed

    private void jBtAcessarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBtAcessarKeyPressed
//       if(evt.getKeyCode() == KeyEvent.VK_ENTER)
//            acessarSistema();

    }//GEN-LAST:event_jBtAcessarKeyPressed

    private void jPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            acessarSistema();
        }
    }//GEN-LAST:event_jPasswordKeyPressed

    private void jPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordActionPerformed

    private void jUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jUsuarioKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jPassword.requestFocus();
        }
    }//GEN-LAST:event_jUsuarioKeyPressed

    private void jUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jUsuarioActionPerformed

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
            java.util.logging.Logger.getLogger(TelaLoginSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLoginSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLoginSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLoginSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaLoginSenha dialog = new TelaLoginSenha(new javax.swing.JFrame(), true);
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
    public static javax.swing.JButton jBtAcessar;
    public static javax.swing.JButton jBtCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jNumeroVersao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JPasswordField jPassword;
    public static javax.swing.JTextField jUsuario;
    // End of variables declaration//GEN-END:variables

    public void formatarCampos() {
        jUsuario.setDocument(new LimiteDigitosMin(21));
        jPassword.setDocument(new LimiteDigitosMin(21));
    }

    public void atualizarSistema() throws FileNotFoundException, IOException {
        // Arquivos que iremos copiar
        File origem = new File("R://SysConp//SysConp.jar");
        dataOrigem = origem.lastModified(); // Data do arquivo de origem
        tamanhoOrigem = origem.length();  // Tamanho do arquivo de origem        
        File destino = new File("C://SysConp//SysConp.jar");
        dataDestino = destino.lastModified();
        tamanhoDestino = destino.length();
        if (origem.exists() && destino.exists()) {
            final File dirOrigem = new File("R://SysConp//");
            final File dirDestino = new File("C://SysConp//");
            if (dataOrigem > dataDestino || tamanhoOrigem > tamanhoDestino) {
                this.dispose();
                FormAtualizaSistema ta = new FormAtualizaSistema();
                ta.setVisible(true);
                ta.toFront();
            }
        }
    }

    public void buscarEmpresa() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM EMPRESA "
                    + "INNER JOIN UNIDADE_PENAL_EMPRESA "
                    + "ON EMPRESA.IdEmpresa=UNIDADE_PENAL_EMPRESA.IdEmpresa");
            conecta.rs.first();
            codigoEmpresa = conecta.rs.getInt("IdEmpresa");
            razaoSocial = conecta.rs.getString("RazaoSocial");
            descricaoUnidade = conecta.rs.getString("DescricaoUnidade");
            versaoAtualSistema = conecta.rs.getDouble("VersaoAtual");
        } catch (Exception e) {
        }
        // ENDEREÇO PARA O RELATÓRIO DE CUMPRIMENTO E NÃO CUMPRIMENTO DE ALVARÁ. (02/03/2018) - BARREIRAS.
        try {
            conecta.executaSQL("SELECT * FROM UNIDADE_PENAL_EMPRESA");
            conecta.rs.first();
            enderecoUnidadePrisional = conecta.rs.getString("Endereco");
            bairroUnidade = conecta.rs.getString("Bairro");
            cidadeUnidade = conecta.rs.getString("Cidade");
            estadoUnidade = conecta.rs.getString("Estado");
            enderecoUnidadePrisional = enderecoUnidadePrisional + " " + cidadeUnidade + " " + estadoUnidade;
        } catch (Exception e) {
        }
        // CAMINHO PARA TRAZER O LOCAL DE INSTALAÇÃO DA ATUALIZAÇÃO.
        try {
            conecta.executaSQL("SELECT * FROM PARAMETROSCRC");
            conecta.rs.first();
            caminhoExecutavel = conecta.rs.getString("CaminhoExecutavel");
            caminhoExecutavelAntigo = conecta.rs.getString("CaminhoExecutavelAntigo");
            dataVersao = conecta.rs.getString("DataVersao");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void Install_Sisconp() {
        try {
            Process p = Runtime.getRuntime().exec(caminhoExecutavel);
        } catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public void buscarIpNomeSRV() {

        InetAddress myself;
        try {
            myself = InetAddress.getLocalHost();
            ipHostSRV = myself.getHostAddress();
            hostNameSRV = myself.getHostName();
        } catch (UnknownHostException ex) {
            Logger.getLogger(TelaLoginSenha.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
