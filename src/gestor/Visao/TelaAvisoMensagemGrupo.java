/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleGrupoUsuarios;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControleModulosUsuariosGrupos;
import gestor.Controle.ControleTelaAcesso;
import gestor.Controle.ControleUsuarios;
import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.ConexaoBancoDadosBAR;
import gestor.Dao.ConexaoBancoDadosITB;
import gestor.Dao.ConexaoBancoDadosLF;
import gestor.Dao.ConexaoBancoDadosSSA;
import gestor.Dao.ConexaoBancoDadosVC;
import gestor.Modelo.LogSistema;
import gestor.Modelo.TelaAcessos;
import gestor.Modelo.Usuarios;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaUsuarios.IdUsuario;
import static gestor.Visao.TelaUsuarios.jCodigoGrupo;
import static gestor.Visao.TelaUsuarios.jComboBoxAcessaTodasUnidades;
import static gestor.Visao.TelaUsuarios.jComboBoxCargo;
import static gestor.Visao.TelaUsuarios.jComboBoxDepartamento;
import static gestor.Visao.TelaUsuarios.jComboBoxStatus;
import static gestor.Visao.TelaUsuarios.jDataCadastro;
import static gestor.Visao.TelaUsuarios.jDescricaoGrupo;
import static gestor.Visao.TelaUsuarios.jNomeUsuarioCompleto;
import static gestor.Visao.TelaUsuarios.jSenha;
import static gestor.Visao.TelaUsuarios.jSenhaConf;
import static gestor.Visao.TelaUsuarios.jlogin;
import java.io.File;
import static java.lang.Thread.sleep;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Socializa TI 02
 */
public class TelaAvisoMensagemGrupo extends javax.swing.JDialog {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    Usuarios objUser = new Usuarios();
    ControleUsuarios control = new ControleUsuarios();
    ControleGrupoUsuarios controle = new ControleGrupoUsuarios();
    ControleModulosUsuariosGrupos controleMod = new ControleModulosUsuariosGrupos();
    //
    TelaAcessos objTelaAcesso = new TelaAcessos();
    ControleTelaAcesso controlaAcess = new ControleTelaAcesso();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    ConexaoBancoDadosLF conectaLF = new ConexaoBancoDadosLF();
    ConexaoBancoDadosSSA conectaSSA = new ConexaoBancoDadosSSA();
    ConexaoBancoDadosITB conectaITB = new ConexaoBancoDadosITB();
    ConexaoBancoDadosVC conectaVC = new ConexaoBancoDadosVC();
    ConexaoBancoDadosBAR conectaBAR = new ConexaoBancoDadosBAR();
    //
    String nomeModuloTela1 = "Configurações:Usuários do Sistema:Grupo Usuários";
    String statusMov;
    String horaMov;
    String dataModFinal;
    //VARIAVEIS DE ACESSO AO CADASTRO DO USUARIO NAS OUTRAS UNIDADES
    String pNOME_USUARIO_GRUPO_LF = null;
    int pCODIGO_USUARIO_LF = 0;
    //
    String pNOME_USUARIO_GRUPO_SSA = null;
    int pCODIGO_USUARIO_SSA = 0;
    //
    String pNOME_USUARIO_GRUPO_ITB = null;
    int pCODIGO_USUARIO_ITB = 0;
    //
    String pNOME_USUARIO_GRUPO_BAR = null;
    int pCODIGO_USUARIO_BAR = 0;
    //
    String pNOME_USUARIO_GRUPO_VC = null;
    int pCODIGO_USUARIO_VC = 0;
    //
    int pPERCENTUAL = 0;
    //
    int codUserGroup, codModelGroup;
    //
    int pUSUARIO_LF = 0;
    int pUSUARIO_VC = 0;
    int pUSUARIO_SSA = 0;
    int pUSUARIO_ITB = 0;
    int pUSUARIO_BAR = 0;

    /**
     * Creates new form TelaAvisoMensagem
     */
    public static TelaUsuarios pUSUARIOS_GRUPO;

    public TelaAvisoMensagemGrupo(TelaUsuarios parent, boolean modal) {
        this.pUSUARIOS_GRUPO = parent;
        setLocationRelativeTo(pUSUARIOS_GRUPO);
        initComponents();
        setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE); //Impedir que a janela seja fechada pelo X  
        Thread();
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
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();
        jBtSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("...::: Acesso Remoto as Unidades :::...");
        setType(java.awt.Window.Type.POPUP);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Aguarde, conectando aos servidores...");

        jProgressBar1.setStringPainted(true);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216082324_32.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/shutdown-icone-6920-16.png"))); // NOI18N
        jBtSair.setText("Sair");
        jBtSair.setEnabled(false);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jBtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSair)
                .addGap(6, 6, 6))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(TelaAvisoMensagemGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAvisoMensagemGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAvisoMensagemGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAvisoMensagemGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaAvisoMensagemGrupo dialog = new TelaAvisoMensagemGrupo(pUSUARIOS_GRUPO, true);
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
    private javax.swing.JButton jBtSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables

    public void Thread() {
        new Thread() {
            public void run() {
                for (int i = 0; i < 101; i++) {
                    try {
                        sleep(100);
                        jProgressBar1.setValue(i);
                        if (jProgressBar1.getValue() <= 10) {
                            jLabel1.setText("Conectando as unidades, Aguarde...");
                        } else if (jProgressBar1.getValue() <= 15) {
                            jLabel1.setText("Aguarde, conectando aos servidores...");
                        } else if (jProgressBar1.getValue() <= 20) {
                            jLabel1.setText("Processando atualizações...");
                            pesquisaGlobal();
                        } else if (jProgressBar1.getValue() <= 30) {
                            jLabel1.setText("Processando atualizações...");
                        } else if (jProgressBar1.getValue() <= 35) {
                            jLabel1.setText("Processando atualizações...");
                        } else if (jProgressBar1.getValue() <= 45) {
                            jLabel1.setText("Processando atualizações...");
                        } else if (jProgressBar1.getValue() <= 50) {
                            jLabel1.setText("Fechando tabelas");
                        } else if (jProgressBar1.getValue() <= 70) {
                            jLabel1.setText("Fechando banco de dados...");
                        } else if (jProgressBar1.getValue() <= 75) {
                            jLabel1.setText("Preparando para desconectar...");
                        } else if (jProgressBar1.getValue() <= 85) {
                            jLabel1.setText("Fechando conexões...");
                        } else if (jProgressBar1.getValue() <= 95) {
                            jLabel1.setText("Preparando para concluir...");
                        } else if (jProgressBar1.getValue() == 100) {
                            jBtSair.setEnabled(true);
                            jLabel1.setText("Operação concluída com sucesso !!!");
                        }
                    } catch (InterruptedException e) {
                    }
                }
            }

        }.start();
    }

    //------------------------------ GRAVAR USUÁRIOS EM OUTRAS UNIDADES PRISIONAIS
    public void pesquisaGlobal() {
        // LAURO DE FREITAS
        File arqLF = new File("C:\\SysConp\\ConectaLF.properties");
        // VITORIA DA CONQUISTA
        File arqVC = new File("C:\\SysConp\\ConectaVC.properties");
        //ITABUNA
        File arqITB = new File("C:\\SysConp\\ConectaITB.properties");
        //SALVADOR
        File arqSSA = new File("C:\\SysConp\\ConectaSSA.properties");
        //BARREIRAS
        File arqBAR = new File("C:\\SysConp\\ConectaBAR.properties");
        //LAURO DE FREITAS
        if (arqLF.exists()) {
            pesquisarUsuarioGrupoUnidadeLF();
            if (jDescricaoGrupo.getText().equals(pNOME_USUARIO_GRUPO_LF)) {
                objUser.setNomeUsuario(jNomeUsuarioCompleto.getText());
                objUser.setIdUsuario(pCODIGO_USUARIO_LF);
                objUser.setNomeGrupo(jDescricaoGrupo.getText());
                objUser.setIdUserGroup(codUserGroup);
                controle.alterarGrupoUsuariosLF(objUser);
            } else {
                buscarUsuarioBaseLF();
                objUser.setNomeUsuario(jNomeUsuarioCompleto.getText());
                objUser.setIdUsuario(pUSUARIO_LF);
                objUser.setNomeGrupo(jDescricaoGrupo.getText());
                controle.incluirGrupoUsuariosLF(objUser);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Arquivo de conexão de Lauro de Freitas, não existe. Solicite ajuda do Administrador do Sistema.");
        }
        // VITORIA DA CONQUISTA
        if (arqVC.exists()) {
            pesquisarUsuarioGrupoUnidadeVC();
            if (jDescricaoGrupo.getText().equals(pNOME_USUARIO_GRUPO_VC)) {
                objUser.setNomeUsuario(jNomeUsuarioCompleto.getText());
                objUser.setIdUsuario(pCODIGO_USUARIO_VC);
                objUser.setNomeGrupo(jDescricaoGrupo.getText());
                objUser.setIdUserGroup(codUserGroup);
                controle.alterarGrupoUsuariosVC(objUser);
            } else {
                buscarUsuarioBaseVC();
                objUser.setNomeUsuario(jNomeUsuarioCompleto.getText());
                objUser.setIdUsuario(pUSUARIO_VC);
                objUser.setNomeGrupo(jDescricaoGrupo.getText());
                controle.incluirGrupoUsuariosVC(objUser);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Arquivo de conexão de Lauro de Freitas, não existe. Solicite ajuda do Administrador do Sistema.");
        }
        //ITABUNA
        if (arqITB.exists()) {
            pesquisarUsuarioGrupoUnidadeITB();
            if (jDescricaoGrupo.getText().equals(pNOME_USUARIO_GRUPO_ITB)) {
                objUser.setNomeUsuario(jNomeUsuarioCompleto.getText());
                objUser.setIdUsuario(pCODIGO_USUARIO_ITB);
                objUser.setNomeGrupo(jDescricaoGrupo.getText());
                objUser.setIdUserGroup(codUserGroup);
                controle.alterarGrupoUsuariosITB(objUser);
            } else {
                buscarUsuarioBaseITB();
                objUser.setNomeUsuario(jNomeUsuarioCompleto.getText());
                objUser.setIdUsuario(pUSUARIO_ITB);
                objUser.setNomeGrupo(jDescricaoGrupo.getText());
                controle.incluirGrupoUsuariosITB(objUser);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Arquivo de conexão de Itabuna, não existe. Solicite ajuda do Administrador do Sistema.");
        }
        //SALVADOR
        if (arqSSA.exists()) {
            pesquisarUsuarioGrupoUnidadeSSA();
            if (jDescricaoGrupo.getText().equals(pNOME_USUARIO_GRUPO_SSA)) {
                objUser.setNomeUsuario(jNomeUsuarioCompleto.getText());
                objUser.setIdUsuario(pCODIGO_USUARIO_SSA);
                objUser.setNomeGrupo(jDescricaoGrupo.getText());
                objUser.setIdUserGroup(codUserGroup);
                controle.alterarGrupoUsuariosSSA(objUser);
            } else {
                buscarUsuarioBaseSSA();
                objUser.setNomeUsuario(jNomeUsuarioCompleto.getText());
                objUser.setIdUsuario(pUSUARIO_SSA);
                objUser.setNomeGrupo(jDescricaoGrupo.getText());
                controle.incluirGrupoUsuariosSSA(objUser);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Arquivo de conexão de Salvador, não existe. Solicite ajuda do Administrador do Sistema.");
        }
        //BARREIRAS
        if (arqBAR.exists()) {
            pesquisarUsuarioGrupoUnidadeBAR();
            if (jDescricaoGrupo.getText().equals(pNOME_USUARIO_GRUPO_BAR)) {
                objUser.setNomeUsuario(jNomeUsuarioCompleto.getText());
                objUser.setIdUsuario(pCODIGO_USUARIO_BAR);
                objUser.setNomeGrupo(jDescricaoGrupo.getText());
                objUser.setIdUserGroup(codUserGroup);
                controle.alterarGrupoUsuariosBAR(objUser);
            } else {
                buscarUsuarioBaseBAR();
                objUser.setNomeUsuario(jNomeUsuarioCompleto.getText());
                objUser.setIdUsuario(pUSUARIO_BAR);
                objUser.setNomeGrupo(jDescricaoGrupo.getText());
                controle.incluirGrupoUsuariosBAR(objUser);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Arquivo de conexão de Barreiras, não existe. Solicite ajuda do Administrador do Sistema.");
        }
    }

    public void pesquisarUsuarioGrupoUnidadeLF() {
        conectaLF.abrirConexao();
        try {
            conectaLF.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN USUARIOS "
                    + "ON USUARIOS_GRUPOS.IdUsuario=USUARIOS.IdUsuario "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE USUARIOS.LoginUsuario='" + jlogin.getText().trim() + "'");
            conectaLF.rs.first();
            pCODIGO_USUARIO_LF = conectaLF.rs.getInt("IdUsuario");
            pNOME_USUARIO_GRUPO_LF = conectaLF.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        conectaLF.desconecta();
    }

    //VITORIA DA CONQUISTA
    public void pesquisarUsuarioGrupoUnidadeVC() {
        conectaVC.abrirConexao();
        try {
            conectaVC.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN USUARIOS "
                    + "ON USUARIOS_GRUPOS.IdUsuario=USUARIOS.IdUsuario "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE USUARIOS.LoginUsuario='" + jlogin.getText().trim() + "'");
            conectaVC.rs.first();
            pCODIGO_USUARIO_VC = conectaVC.rs.getInt("IdUsuario");
            pNOME_USUARIO_GRUPO_VC = conectaVC.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        conectaVC.desconecta();
    }

    //ITABUNA
    public void pesquisarUsuarioGrupoUnidadeITB() {
        conectaITB.abrirConexao();
        try {
            conectaITB.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN USUARIOS "
                    + "ON USUARIOS_GRUPOS.IdUsuario=USUARIOS.IdUsuario "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE USUARIOS.LoginUsuario='" + jlogin.getText().trim() + "'");
            conectaITB.rs.first();
            pCODIGO_USUARIO_ITB = conectaITB.rs.getInt("IdUsuario");
            pNOME_USUARIO_GRUPO_ITB = conectaITB.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        conectaITB.desconecta();
    }

    //SALVADOR
    public void pesquisarUsuarioGrupoUnidadeSSA() {
        conectaSSA.abrirConexao();
        try {
            conectaSSA.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN USUARIOS "
                    + "ON USUARIOS_GRUPOS.IdUsuario=USUARIOS.IdUsuario "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE USUARIOS.LoginUsuario='" + jlogin.getText().trim() + "'");
            conectaSSA.rs.first();
            pCODIGO_USUARIO_SSA = conectaSSA.rs.getInt("IdUsuario");
            pNOME_USUARIO_GRUPO_SSA = conectaSSA.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        conectaSSA.desconecta();
    }

    //BARREIRAS
    public void pesquisarUsuarioGrupoUnidadeBAR() {
        conectaBAR.abrirConexao();
        try {
            conectaBAR.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN USUARIOS "
                    + "ON USUARIOS_GRUPOS.IdUsuario=USUARIOS.IdUsuario "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE USUARIOS.LoginUsuario='" + jlogin.getText().trim() + "'");
            conectaBAR.rs.first();
            pCODIGO_USUARIO_BAR = conectaBAR.rs.getInt("IdUsuario");
            pNOME_USUARIO_GRUPO_BAR = conectaBAR.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        conectaBAR.desconecta();
    }

    public void buscarUsuarioBaseLF() {
        conectaLF.abrirConexao();
        try {
            conectaLF.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE USUARIOS.LoginUsuario='" + jlogin.getText().trim() + "'");
            conectaLF.rs.first();
            pUSUARIO_LF = conectaLF.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        conectaLF.desconecta();
    }

    public void buscarUsuarioBaseSSA() {
        conectaSSA.abrirConexao();
        try {
            conectaSSA.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE USUARIOS.LoginUsuario='" + jlogin.getText().trim() + "'");
            conectaSSA.rs.first();
            pUSUARIO_SSA = conectaSSA.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        conectaSSA.desconecta();
    }

    public void buscarUsuarioBaseVC() {
        conectaVC.abrirConexao();
        try {
            conectaVC.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE USUARIOS.LoginUsuario='" + jlogin.getText().trim() + "'");
            conectaVC.rs.first();
            pUSUARIO_VC = conectaVC.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        conectaVC.desconecta();
    }

    public void buscarUsuarioBaseITB() {
        conectaITB.abrirConexao();
        try {
            conectaITB.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE USUARIOS.LoginUsuario='" + jlogin.getText().trim() + "'");
            conectaITB.rs.first();
            pUSUARIO_ITB = conectaITB.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        conectaITB.desconecta();
    }

    public void buscarUsuarioBaseBAR() {
        conectaBAR.abrirConexao();
        try {
            conectaBAR.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE USUARIOS.LoginUsuario='" + jlogin.getText().trim() + "'");
            conectaBAR.rs.first();
            pUSUARIO_BAR = conectaBAR.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        conectaBAR.desconecta();
    }

//--------------------------------------------
    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela1);
        objLogSys.setIdLancMov(Integer.valueOf(IdUsuario.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }
}