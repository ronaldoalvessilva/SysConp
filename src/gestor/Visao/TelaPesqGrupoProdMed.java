/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Dao.ConexaoBancoDados;
import Utilitarios.ModeloTabela;
import static gestor.Visao.TelaMedicamentos.jDescricaoGrupo;
import static gestor.Visao.TelaMedicamentos.jIdGrupo;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author user
 */
public class TelaPesqGrupoProdMed extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    int flag;
    String statusGrupo = "Ativo";
    String modulo = "F";

    /**
     * Creates new form TelaPesqGrupoProdMed
     */
    public TelaPesqGrupoProdMed() {
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
        jPesqDescricaoGrupo = new javax.swing.JTextField();
        jBtPesqDescricao = new javax.swing.JButton();
        jCheckBoxTodosGrupos = new javax.swing.JCheckBox();
        jBtEnviar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaGrupos = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("...::: Listagem de Grupo de Produtos {FAR} :::...");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Descrição:");

        jPesqDescricaoGrupo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqDescricao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqDescricao.setContentAreaFilled(false);
        jBtPesqDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqDescricaoActionPerformed(evt);
            }
        });

        jCheckBoxTodosGrupos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxTodosGrupos.setText("Todos");
        jCheckBoxTodosGrupos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxTodosGruposItemStateChanged(evt);
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
                .addComponent(jPesqDescricaoGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtPesqDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBoxTodosGrupos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPesqDescricaoGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jBtPesqDescricao)
                    .addComponent(jCheckBoxTodosGrupos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        jTabelaGrupos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaGrupos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTabelaGrupos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaGruposMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaGrupos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBtEnviar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSair))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(48, 48, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtEnviar)
                    .addComponent(jBtSair))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Pesquisar", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        setBounds(300, 20, 409, 291);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesqDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqDescricaoActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (jPesqDescricaoGrupo.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe uma descrição ou parte dela para pesquisar.");
        } else {
            preencherTabelaGrupos("SELECT * FROM GRUPO_PRODUTOS_AC WHERE NomeGrupo LIKE'%" + jPesqDescricaoGrupo.getText() + "%' AND StatusGru='" + statusGrupo + "'AND Modulo='" + modulo + "'");
        }
    }//GEN-LAST:event_jBtPesqDescricaoActionPerformed

    private void jBtEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtEnviarActionPerformed
        // TODO add your handling code here:
        if (jPesqDescricaoGrupo.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o nome do grupo para ser enviado.");
        } else {
            if (flag == 1) {
                String nomeGrupo = "" + jTabelaGrupos.getValueAt(jTabelaGrupos.getSelectedRow(), 1);
                jPesqDescricaoGrupo.setText(nomeGrupo);
                String idGrupo = "" + jTabelaGrupos.getValueAt(jTabelaGrupos.getSelectedRow(), 0);
                jIdGrupo.setText(idGrupo);
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM GRUPO_PRODUTOS_AC WHERE NomeGrupo='" + jPesqDescricaoGrupo.getText() + "'");
                    conecta.rs.first();
                    jIdGrupo.setText(String.valueOf(conecta.rs.getInt("IdGrupo")));
                    jDescricaoGrupo.setText(conecta.rs.getString("NomeGrupo"));
                    conecta.desconecta();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa por nome" + e);
                }
                dispose();
            }
        }
    }//GEN-LAST:event_jBtEnviarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jTabelaGruposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaGruposMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            String nomeGrupo = "" + jTabelaGrupos.getValueAt(jTabelaGrupos.getSelectedRow(), 1);
            jPesqDescricaoGrupo.setText(nomeGrupo);
        }
    }//GEN-LAST:event_jTabelaGruposMouseClicked

    private void jCheckBoxTodosGruposItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxTodosGruposItemStateChanged
        // TODO add your handling code here:
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherTabelaGrupos("SELECT * FROM GRUPO_PRODUTOS_AC WHERE StatusGru='" + statusGrupo + "'AND Modulo='" + modulo + "'");
        } else {
            limparTabelaGrupo();
        }
    }//GEN-LAST:event_jCheckBoxTodosGruposItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtEnviar;
    private javax.swing.JButton jBtPesqDescricao;
    private javax.swing.JButton jBtSair;
    private javax.swing.JCheckBox jCheckBoxTodosGrupos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jPesqDescricaoGrupo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTabelaGrupos;
    // End of variables declaration//GEN-END:variables

    public void preencherTabelaGrupos(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", " Descrição Grupo", " Status"};
        conecta.abrirConexao();
        conecta.executaSQL(sql);
        try {
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdGrupo"), conecta.rs.getString("NomeGrupo"), conecta.rs.getString("StatusGru")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Dados não encontrado...");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaGrupos.setModel(modelo);
        jTabelaGrupos.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaGrupos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaGrupos.getColumnModel().getColumn(1).setPreferredWidth(260);
        jTabelaGrupos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaGrupos.getColumnModel().getColumn(2).setPreferredWidth(70);
        jTabelaGrupos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaGrupos.getTableHeader().setReorderingAllowed(false);
        jTabelaGrupos.setAutoResizeMode(jTabelaGrupos.AUTO_RESIZE_OFF);
        jTabelaGrupos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaGrupo();
        conecta.desconecta();
    }

    public void alinharCamposTabelaGrupo() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaGrupos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaGrupos.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }

    public void limparTabelaGrupo() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", " Descrição Grupo", " Status"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaGrupos.setModel(modelo);
        jTabelaGrupos.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaGrupos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaGrupos.getColumnModel().getColumn(1).setPreferredWidth(260);
        jTabelaGrupos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaGrupos.getColumnModel().getColumn(2).setPreferredWidth(70);
        jTabelaGrupos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaGrupos.getTableHeader().setReorderingAllowed(false);
        jTabelaGrupos.setAutoResizeMode(jTabelaGrupos.AUTO_RESIZE_OFF);
        jTabelaGrupos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }
}
