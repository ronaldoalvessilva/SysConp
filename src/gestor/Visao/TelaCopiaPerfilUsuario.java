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
import gestor.Dao.ModeloTabela;
import gestor.Modelo.LogSistema;
import gestor.Modelo.TelaAcessos;
import gestor.Modelo.Usuarios;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaUsuarios.IdUsuario;
import static gestor.Visao.TelaUsuarios.jComboBoxModuloAcesso;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ronal
 */
public class TelaCopiaPerfilUsuario extends javax.swing.JDialog {

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
    //
    int pAbrir = 0;
    int pIncluir = 0;
    int pAlterar = 0;
    int pExcluir = 0;
    int pGravar = 0;
    int pConsultar = 0;
    String pAbrirAcesso = "";
    String pIncluirAcesso = "";
    String pAlterarAcesso = "";
    String pExcluirAcesso = "";
    String pGravarAcesso = "";
    String pConsultarAcesso = "";
    //   
    String codigoUsuario = "";
    //
    String statusMov;
    String horaMov;
    String dataModFinal;
    //
    int codigoUser = 0;
    String User = "";

    public static TelaUsuarios telaUsuarios;

    /**
     * Creates new form TelaCopiaPerfilUsuario
     */
    public TelaCopiaPerfilUsuario(TelaUsuarios parent, boolean modal) {
        this.telaUsuarios = parent;
        setLocationRelativeTo(telaUsuarios);
        initComponents();
        preencherComboNomeUsuario();
        preencherTabelaAcessos("SELECT * FROM TELAS_ACESSO "
                + "WHERE IdUsuario='" + IdUsuario.getText() + "'");
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
        jComboBoxNomeUsuario = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTabelaAcessos = new javax.swing.JTable();
        jBtConfirmar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("...::: Copiar Perfil Usuário :::...");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jComboBoxNomeUsuario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxNomeUsuario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione..." }));
        jComboBoxNomeUsuario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Nome do Usuário");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxNomeUsuario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaAcessos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaAcessos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Nome da Tela", "Abrir", "Incluir", "Alterar", "Excluir", "Consultar", "Nome do Módulo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTabelaAcessos);
        if (jTabelaAcessos.getColumnModel().getColumnCount() > 0) {
            jTabelaAcessos.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaAcessos.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaAcessos.getColumnModel().getColumn(1).setMinWidth(400);
            jTabelaAcessos.getColumnModel().getColumn(1).setMaxWidth(400);
            jTabelaAcessos.getColumnModel().getColumn(2).setMinWidth(40);
            jTabelaAcessos.getColumnModel().getColumn(2).setMaxWidth(40);
            jTabelaAcessos.getColumnModel().getColumn(3).setMinWidth(40);
            jTabelaAcessos.getColumnModel().getColumn(3).setMaxWidth(40);
            jTabelaAcessos.getColumnModel().getColumn(4).setMinWidth(40);
            jTabelaAcessos.getColumnModel().getColumn(5).setMinWidth(40);
            jTabelaAcessos.getColumnModel().getColumn(6).setMinWidth(40);
            jTabelaAcessos.getColumnModel().getColumn(6).setMaxWidth(40);
            jTabelaAcessos.getColumnModel().getColumn(7).setMinWidth(150);
            jTabelaAcessos.getColumnModel().getColumn(7).setMaxWidth(150);
        }

        jBtConfirmar.setForeground(new java.awt.Color(0, 153, 0));
        jBtConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/accept.png"))); // NOI18N
        jBtConfirmar.setText("Confirmar");
        jBtConfirmar.setToolTipText("Confirmar cópia do pérfil");
        jBtConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtConfirmarActionPerformed(evt);
            }
        });

        jBtSair.setForeground(new java.awt.Color(204, 0, 0));
        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/shutdown-icone-6920-16.png"))); // NOI18N
        jBtSair.setText("Sair");
        jBtSair.setToolTipText("Sair da tela");
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
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtConfirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSair)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtConfirmar, jBtSair});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtConfirmar)
                    .addComponent(jBtSair))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtConfirmarActionPerformed
        // TODO add your handling code here:
        statusMov = "Incluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        verificarTelaAcesso();
        if (jComboBoxNomeUsuario.getSelectedItem() == null || jComboBoxNomeUsuario.getSelectedItem().equals("") || jComboBoxNomeUsuario.getSelectedItem().equals("Selecione...")) {
            JOptionPane.showMessageDialog(rootPane, "É necessário selecionar um usuário para fazer a cópia do pérfil...");
        } else {
            if (codigoUsuario.equals(User)) {
                JOptionPane.showMessageDialog(rootPane, "Não e possível realizar essa operação, já existe usuário com acessos.");
            } else {
                buscarCodigoUsuario();
                copiarPerfil();
                Salvar();
                JOptionPane.showMessageDialog(rootPane, "Cópia concluida com sucesso.!!!");
            }
        }
    }//GEN-LAST:event_jBtConfirmarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCopiaPerfilUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCopiaPerfilUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCopiaPerfilUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCopiaPerfilUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaCopiaPerfilUsuario dialog = new TelaCopiaPerfilUsuario(telaUsuarios, true);
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
    private javax.swing.JComboBox jComboBoxNomeUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTabelaAcessos;
    // End of variables declaration//GEN-END:variables

    public void buscarCodigoUsuario() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + jComboBoxNomeUsuario.getSelectedItem() + "'");
            conecta.rs.first();
            codigoUser = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void copiarPerfil() {
        for (int i = 0; i < jTabelaAcessos.getRowCount(); i++) {
            objTelaAcesso.setIdUsuario(codigoUser);
            objTelaAcesso.setNomeUsuario((String) jComboBoxNomeUsuario.getSelectedItem());
            objTelaAcesso.setNomeTela((String) jTabelaAcessos.getValueAt(i, 1));
            pAbrirAcesso = (String) jTabelaAcessos.getValueAt(i, 2);
            if (pAbrirAcesso.equals("Não")) {
                pAbrir = 0;
            } else if (pAbrirAcesso.equals("Sim")) {
                pAbrir = 1;
            }
            pIncluirAcesso = (String) jTabelaAcessos.getValueAt(i, 3);
            if (pIncluirAcesso.equals("Não")) {
                pIncluir = 0;
            } else if (pIncluirAcesso.equals("Sim")) {
                pIncluir = 1;
            }
            pAlterarAcesso = (String) jTabelaAcessos.getValueAt(i, 4);
            if (pAlterarAcesso.equals("Não")) {
                pAlterar = 0;
            } else if (pAlterarAcesso.equals("Sim")) {
                pAlterar = 1;
            }
            pExcluirAcesso = (String) jTabelaAcessos.getValueAt(i, 5);
            if (pExcluirAcesso.equals("Não")) {
                pExcluir = 0;
            } else if (pExcluirAcesso.equals("Sim")) {
                pExcluir = 1;
            }
            pGravarAcesso = (String) jTabelaAcessos.getValueAt(i, 6);
            if (pGravarAcesso.equals("Não")) {
                pGravar = 0;
            } else if (pGravarAcesso.equals("Sim")) {
                pGravar = 1;
            }
            pConsultarAcesso = (String) jTabelaAcessos.getValueAt(i, 7);
            if (pConsultarAcesso.equals("Não")) {
                pConsultar = 0;
            } else if (pConsultarAcesso.equals("Sim")) {
                pConsultar = 1;
            }
            objTelaAcesso.setNomeModulo((String) jTabelaAcessos.getValueAt(i, 8));
            objTelaAcesso.setIncluir(pIncluir);
            objTelaAcesso.setAbrir(pAbrir);
            objTelaAcesso.setAlterar(pAlterar);
            objTelaAcesso.setExcluir(pExcluir);
            objTelaAcesso.setGravar(pGravar);
            objTelaAcesso.setConsultar(pConsultar);
            //
            objTelaAcesso.setUsuarioInsert(nameUser);
            objTelaAcesso.setDataInsert(dataModFinal);
            objTelaAcesso.setHorarioInsert(horaMov);
            //
            controlaAcess.incluirTelaAcesso(objTelaAcesso);
        }
    }

    public void Salvar() {
        jComboBoxNomeUsuario.setSelectedItem(null);
        jBtConfirmar.setEnabled(!true);
    }

    public void preencherComboNomeUsuario() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS ORDER BY NomeUsuario");
            conecta.rs.first();
            do {
                jComboBoxNomeUsuario.addItem(conecta.rs.getString("NomeUsuario"));
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void preencherTabelaAcessos(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Tela", "Abrir", "Incluir", "Alterar", "Excluir", "Gravar", "Consultar", "Nome do Módulo"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                pAbrir = conecta.rs.getInt("Abrir");
                if (pAbrir == 0) {
                    pAbrirAcesso = "Não";
                } else if (pAbrir == 1) {
                    pAbrirAcesso = "Sim";
                }
                pIncluir = conecta.rs.getInt("Incluir");
                if (pIncluir == 0) {
                    pIncluirAcesso = "Não";
                } else if (pIncluir == 1) {
                    pIncluirAcesso = "Sim";
                }
                pAlterar = conecta.rs.getInt("Alterar");
                if (pAlterar == 0) {
                    pAlterarAcesso = "Não";
                } else if (pAlterar == 1) {
                    pAlterarAcesso = "Sim";
                }
                pExcluir = conecta.rs.getInt("Excluir");
                if (pExcluir == 0) {
                    pExcluirAcesso = "Não";
                } else if (pExcluir == 1) {
                    pExcluirAcesso = "Sim";
                }
                pGravar = conecta.rs.getInt("Gravar");
                if (pGravar == 0) {
                    pGravarAcesso = "Não";
                } else if (pGravar == 1) {
                    pGravarAcesso = "Sim";
                }
                pConsultar = conecta.rs.getInt("Consultar");
                if (pConsultar == 0) {
                    pConsultarAcesso = "Não";
                } else if (pConsultar == 1) {
                    pConsultarAcesso = "Sim";
                }
                dados.add(new Object[]{conecta.rs.getString("IdTela"), conecta.rs.getString("NomeTela"), pAbrirAcesso, pIncluirAcesso, pAlterarAcesso, pExcluirAcesso, pGravarAcesso, pConsultarAcesso, conecta.rs.getString("NomeModulo")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaAcessos.setModel(modelo);
        jTabelaAcessos.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaAcessos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaAcessos.getColumnModel().getColumn(1).setPreferredWidth(400);
        jTabelaAcessos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaAcessos.getColumnModel().getColumn(2).setPreferredWidth(60);
        jTabelaAcessos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaAcessos.getColumnModel().getColumn(3).setPreferredWidth(60);
        jTabelaAcessos.getColumnModel().getColumn(3).setResizable(false);
        jTabelaAcessos.getColumnModel().getColumn(4).setPreferredWidth(60);
        jTabelaAcessos.getColumnModel().getColumn(4).setResizable(false);
        jTabelaAcessos.getColumnModel().getColumn(5).setPreferredWidth(60);
        jTabelaAcessos.getColumnModel().getColumn(5).setResizable(false);
        jTabelaAcessos.getColumnModel().getColumn(6).setPreferredWidth(60);
        jTabelaAcessos.getColumnModel().getColumn(6).setResizable(false);
        jTabelaAcessos.getColumnModel().getColumn(7).setPreferredWidth(60);
        jTabelaAcessos.getColumnModel().getColumn(7).setResizable(false);
        jTabelaAcessos.getColumnModel().getColumn(8).setPreferredWidth(150);
        jTabelaAcessos.getColumnModel().getColumn(8).setResizable(false);
        jTabelaAcessos.getTableHeader().setReorderingAllowed(false);
        jTabelaAcessos.setAutoResizeMode(jTabelaAcessos.AUTO_RESIZE_OFF);
        jTabelaAcessos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaAcessos();
        conecta.desconecta();
    }

    public void alinharCamposTabelaAcessos() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //       
        jTabelaAcessos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaAcessos.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        jTabelaAcessos.getColumnModel().getColumn(3).setCellRenderer(centralizado);
        jTabelaAcessos.getColumnModel().getColumn(4).setCellRenderer(centralizado);
        jTabelaAcessos.getColumnModel().getColumn(5).setCellRenderer(centralizado);
        jTabelaAcessos.getColumnModel().getColumn(6).setCellRenderer(centralizado);
        jTabelaAcessos.getColumnModel().getColumn(7).setCellRenderer(centralizado);
    }

    public void verificarTelaAcesso() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + jComboBoxNomeUsuario.getSelectedItem() + "'");
            conecta.rs.first();
            User = conecta.rs.getString("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + User + "'");
            conecta.rs.first();
            codigoUsuario = conecta.rs.getString("IdUsuario");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
