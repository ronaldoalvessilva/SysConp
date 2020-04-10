/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Dao.ConexaoBancoDados;
import Utilitarios.ModeloTabela;
import static gestor.Visao.TelaRecadosAdministrador.jNomeDestinatario;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ronaldo
 */
public class TelaPesqAgendaRecUsuarioRoot extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    int flag;
    String statusUsuario;
    int statusUser = 1;
    int count = 0;

    /**
     * Creates new form TelaPesqAgendaRecUsuario
     */
    public TelaPesqAgendaRecUsuarioRoot() {
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jNomeUsuario = new javax.swing.JTextField();
        jBtPesqNomeUsuario = new javax.swing.JButton();
        jCheckBoxTodos = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaUsuarios = new javax.swing.JTable();
        jBtEnviar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Pesquisa de Usuários {AR} :::...");
        setPreferredSize(new java.awt.Dimension(484, 277));

        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 255));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Nome:");

        jNomeUsuario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqNomeUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqNomeUsuario.setContentAreaFilled(false);
        jBtPesqNomeUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqNomeUsuarioActionPerformed(evt);
            }
        });

        jCheckBoxTodos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxTodos.setText("Todos");
        jCheckBoxTodos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxTodosItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNomeUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtPesqNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxTodos)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jCheckBoxTodos)
                    .addComponent(jBtPesqNomeUsuario)
                    .addComponent(jNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaUsuarios.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Código", "Nome do Usuário", "Status"
            }
        ));
        jTabelaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaUsuarios);
        if (jTabelaUsuarios.getColumnModel().getColumnCount() > 0) {
            jTabelaUsuarios.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaUsuarios.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaUsuarios.getColumnModel().getColumn(1).setMinWidth(290);
            jTabelaUsuarios.getColumnModel().getColumn(1).setMaxWidth(290);
            jTabelaUsuarios.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaUsuarios.getColumnModel().getColumn(2).setMaxWidth(80);
        }

        jBtEnviar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtEnviar.setForeground(new java.awt.Color(0, 0, 255));
        jBtEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/accept.png"))); // NOI18N
        jBtEnviar.setText("Enviar");
        jBtEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtEnviarActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBtEnviar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSair)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtEnviar)
                    .addComponent(jBtSair))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Pesquisas", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBounds(300, 10, 484, 271);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesqNomeUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNomeUsuarioActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (jNomeUsuario.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um nome de usuário para pesquisa.");
        } else {
            preencherTabelaUsuario("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario LIKE'%" + jNomeUsuario.getText() + "%' "
                    + "AND StatusUsuario='" + statusUser + "'");
        }
    }//GEN-LAST:event_jBtPesqNomeUsuarioActionPerformed

    private void jCheckBoxTodosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxTodosItemStateChanged
        // TODO add your handling code here:
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherTabelaUsuario("SELECT * FROM USUARIOS "
                    + "WHERE StatusUsuario='" + statusUser + "'");
        } else {
            limparTabela();
        }
    }//GEN-LAST:event_jCheckBoxTodosItemStateChanged

    private void jBtEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtEnviarActionPerformed
        // TODO add your handling code here:
        if (flag == 1) {
            String nomeUsuario = "" + jTabelaUsuarios.getValueAt(jTabelaUsuarios.getSelectedRow(), 1);
            jNomeUsuario.setText(nomeUsuario);
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM USUARIOS WHERE NomeUsuario='" + jNomeUsuario.getText() + "'");
                conecta.rs.first();
                jNomeDestinatario.setText(conecta.rs.getString("NomeUsuario"));
                conecta.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa dos dados...\nERRO: " + e);
            }
            dispose();
        }
    }//GEN-LAST:event_jBtEnviarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jTabelaUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaUsuariosMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            String nomeUsuario = "" + jTabelaUsuarios.getValueAt(jTabelaUsuarios.getSelectedRow(), 1);
            jNomeUsuario.setText(nomeUsuario);
        }
    }//GEN-LAST:event_jTabelaUsuariosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtEnviar;
    private javax.swing.JButton jBtPesqNomeUsuario;
    private javax.swing.JButton jBtSair;
    private javax.swing.JCheckBox jCheckBoxTodos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jNomeUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTabelaUsuarios;
    // End of variables declaration//GEN-END:variables

    public void preencherTabelaUsuario(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome do Usuario", "Status"};
        conecta.abrirConexao();
        conecta.executaSQL(sql);
        try {
            conecta.rs.first();
            do {
                conecta.rs.getString("StatusUsuario");
                if (statusUser == 1) {
                    statusUsuario = "Ativo";
                } else if (statusUser == 0) {
                    statusUsuario = "Inativo";
                }
                dados.add(new Object[]{conecta.rs.getInt("IdUsuario"), conecta.rs.getString("NomeUsuario"), statusUsuario});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem exibidos....");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaUsuarios.setModel(modelo);
        jTabelaUsuarios.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaUsuarios.getColumnModel().getColumn(0).setResizable(false);
        jTabelaUsuarios.getColumnModel().getColumn(1).setPreferredWidth(290);
        jTabelaUsuarios.getColumnModel().getColumn(1).setResizable(false);
        jTabelaUsuarios.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaUsuarios.getColumnModel().getColumn(2).setResizable(false);
        jTabelaUsuarios.getTableHeader().setReorderingAllowed(false);
        jTabelaUsuarios.setAutoResizeMode(jTabelaUsuarios.AUTO_RESIZE_OFF);
        jTabelaUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinarCamposTabela();
        conecta.desconecta();
    }

    public void limparTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome do Usuario", "Status"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaUsuarios.setModel(modelo);
        jTabelaUsuarios.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaUsuarios.getColumnModel().getColumn(0).setResizable(false);
        jTabelaUsuarios.getColumnModel().getColumn(1).setPreferredWidth(290);
        jTabelaUsuarios.getColumnModel().getColumn(1).setResizable(false);
        jTabelaUsuarios.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaUsuarios.getColumnModel().getColumn(2).setResizable(false);
        jTabelaUsuarios.getTableHeader().setReorderingAllowed(false);
        jTabelaUsuarios.setAutoResizeMode(jTabelaUsuarios.AUTO_RESIZE_OFF);
        jTabelaUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinarCamposTabela() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaUsuarios.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaUsuarios.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }
}
