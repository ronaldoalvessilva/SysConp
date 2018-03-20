/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.ModeloTabela;
import static gestor.Visao.TelaUsuarios.IdUsuario;
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
public class TelaConsultaUsuariosGrupo extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();

    int count = 0;
    int flag;
    int statusUser;
    String statusNome;

    /**
     * Creates new form TelaConsultaUsuariosGrupo
     */
    public TelaConsultaUsuariosGrupo() {
        initComponents();
        jComboBoxDescricaoGrupo.removeAllItems();
        preencherComboBoxGrupo();
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
        jPanel14 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jBtPesquisaGrupoUsuarios = new javax.swing.JButton();
        jCheckBox2 = new javax.swing.JCheckBox();
        jComboBoxDescricaoGrupo = new javax.swing.JComboBox();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTabelaGrupo = new javax.swing.JTable();
        jPanel31 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Consulta de Internos Por Grupo :::...");

        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 255));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("Nome do Grupo");

        jBtPesquisaGrupoUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesquisaGrupoUsuarios.setContentAreaFilled(false);
        jBtPesquisaGrupoUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisaGrupoUsuariosActionPerformed(evt);
            }
        });

        jCheckBox2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox2.setText("Todos");
        jCheckBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox2ItemStateChanged(evt);
            }
        });

        jComboBoxDescricaoGrupo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDescricaoGrupo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione" }));
        jComboBoxDescricaoGrupo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jComboBoxDescricaoGrupo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesquisaGrupoUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox2)
                        .addGap(16, 16, 16))))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxDescricaoGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesquisaGrupoUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaGrupo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaGrupo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Código", "Status", "Nome do Usuário", "Nome do Grupo"
            }
        ));
        jScrollPane4.setViewportView(jTabelaGrupo);
        if (jTabelaGrupo.getColumnModel().getColumnCount() > 0) {
            jTabelaGrupo.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaGrupo.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaGrupo.getColumnModel().getColumn(1).setMinWidth(60);
            jTabelaGrupo.getColumnModel().getColumn(1).setMaxWidth(60);
            jTabelaGrupo.getColumnModel().getColumn(2).setMinWidth(200);
            jTabelaGrupo.getColumnModel().getColumn(2).setMaxWidth(200);
            jTabelaGrupo.getColumnModel().getColumn(3).setMinWidth(150);
            jTabelaGrupo.getColumnModel().getColumn(3).setMaxWidth(150);
        }

        jPanel31.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        jPanel30.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jLabel67.setText("Total de Registros:");

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel67))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel67)
        );

        jPanel32.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jtotalRegistros.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("Consultas", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        setBounds(300, 30, 461, 495);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesquisaGrupoUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisaGrupoUsuariosActionPerformed
        // TODO add your handling code here:
        count = 0;
        if (jComboBoxDescricaoGrupo.getSelectedItem().equals("Selecione")) {
            JOptionPane.showMessageDialog(rootPane, "Selecione um grupo para pesquisar os usuários.");
        } else {
            preencherTabelaGrupos("SELECT * FROM USUARIOS "
                    + "INNER JOIN USUARIOS_GRUPOS "
                    + "ON USUARIOS.IdUsuario=USUARIOS_GRUPOS.IdUsuario "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE NomeGrupo='" + jComboBoxDescricaoGrupo.getSelectedItem() + "'");
        }
    }//GEN-LAST:event_jBtPesquisaGrupoUsuariosActionPerformed

    private void jCheckBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox2ItemStateChanged
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherTabelaGrupos("SELECT * FROM USUARIOS "
                    + "INNER JOIN USUARIOS_GRUPOS "
                    + "ON USUARIOS.IdUsuario=USUARIOS_GRUPOS.IdUsuario "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo");
        } else {
            limparTabelaGrupo();
        }
    }//GEN-LAST:event_jCheckBox2ItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtPesquisaGrupoUsuarios;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JComboBox jComboBoxDescricaoGrupo;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTabelaGrupo;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void preencherComboBoxGrupo() {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM GRUPOUSUARIOS ORDER BY GRUPOUSUARIOS.NomeGrupo");
            conecta.rs.first();
            do {
                jComboBoxDescricaoGrupo.addItem(conecta.rs.getString("NomeGrupo"));
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void preencherTabelaGrupos(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Status", "Nome do Usuário", "Nome do Grupo"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1;
                statusUser = conecta.rs.getInt("StatusUsuario");
                if (statusUser == 0) {
                    statusNome = "Inativo";
                } else if (statusUser == 1) {
                    statusNome = "Ativo";
                }
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdUsuario"), statusNome, conecta.rs.getString("NomeUsuario"), conecta.rs.getString("NomeGrupo")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaGrupo.setModel(modelo);
        jTabelaGrupo.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaGrupo.getColumnModel().getColumn(0).setResizable(false);
        jTabelaGrupo.getColumnModel().getColumn(1).setPreferredWidth(60);
        jTabelaGrupo.getColumnModel().getColumn(1).setResizable(false);
        jTabelaGrupo.getColumnModel().getColumn(2).setPreferredWidth(200);
        jTabelaGrupo.getColumnModel().getColumn(2).setResizable(false);
        jTabelaGrupo.getColumnModel().getColumn(3).setPreferredWidth(150);
        jTabelaGrupo.getColumnModel().getColumn(3).setResizable(false);
        jTabelaGrupo.getTableHeader().setReorderingAllowed(false);
        jTabelaGrupo.setAutoResizeMode(jTabelaGrupo.AUTO_RESIZE_OFF);
        jTabelaGrupo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaGrupo();
        conecta.desconecta();
    }

    public void limparTabelaGrupo() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Status", "Nome do Usuário", "Nome do Grupo"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaGrupo.setModel(modelo);
        jTabelaGrupo.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaGrupo.getColumnModel().getColumn(0).setResizable(false);
        jTabelaGrupo.getColumnModel().getColumn(1).setPreferredWidth(60);
        jTabelaGrupo.getColumnModel().getColumn(1).setResizable(false);
        jTabelaGrupo.getColumnModel().getColumn(2).setPreferredWidth(200);
        jTabelaGrupo.getColumnModel().getColumn(2).setResizable(false);
        jTabelaGrupo.getColumnModel().getColumn(3).setPreferredWidth(150);
        jTabelaGrupo.getColumnModel().getColumn(3).setResizable(false);
        jTabelaGrupo.getTableHeader().setReorderingAllowed(false);
        jTabelaGrupo.setAutoResizeMode(jTabelaGrupo.AUTO_RESIZE_OFF);
        jTabelaGrupo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabelaGrupo() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaGrupo.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaGrupo.getColumnModel().getColumn(1).setCellRenderer(centralizado);
    }

}
