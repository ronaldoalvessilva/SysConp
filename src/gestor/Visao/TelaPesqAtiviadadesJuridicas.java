/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Dao.ConexaoBancoDados;
import Utilitarios.ModeloTabela;
import static gestor.Visao.TelaAtendimentoJuridico.jAtividadeRealizada;
import static gestor.Visao.TelaAtendimentoJuridico.jIdAtiv;
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
public class TelaPesqAtiviadadesJuridicas extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    int flag;
    String statusAtiv = "Ativo";
    String dataAtiv;
    String descricaoAtiv;

    /**
     * Creates new form TelaPesqAtiviadadesJuridicas
     */
    public TelaPesqAtiviadadesJuridicas() {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaAtividades = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPesqDescricao = new javax.swing.JTextField();
        jBtPesqDescricao = new javax.swing.JButton();
        jCheckBoxTodos = new javax.swing.JCheckBox();
        jBtConfirmar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();

        setClosable(true);
        setTitle("...::: Pesquisar Atividades Jurídicas :::...");

        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 255));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jTabelaAtividades.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaAtividades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Código", "Data", "Status", "Descrição"
            }
        ));
        jTabelaAtividades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaAtividadesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaAtividades);
        if (jTabelaAtividades.getColumnModel().getColumnCount() > 0) {
            jTabelaAtividades.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaAtividades.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaAtividades.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaAtividades.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaAtividades.getColumnModel().getColumn(2).setMinWidth(70);
            jTabelaAtividades.getColumnModel().getColumn(2).setMaxWidth(70);
            jTabelaAtividades.getColumnModel().getColumn(3).setMinWidth(280);
            jTabelaAtividades.getColumnModel().getColumn(3).setMaxWidth(280);
        }

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("Descrição:");

        jPesqDescricao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqDescricao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqDescricao.setContentAreaFilled(false);
        jBtPesqDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqDescricaoActionPerformed(evt);
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
                .addComponent(jPesqDescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtPesqDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBoxTodos)
                .addGap(14, 14, 14))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPesqDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqDescricao)
                    .addComponent(jCheckBoxTodos)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jBtConfirmar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtConfirmar.setForeground(new java.awt.Color(0, 0, 204));
        jBtConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/accept.png"))); // NOI18N
        jBtConfirmar.setText("Confirmar");
        jBtConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtConfirmarActionPerformed(evt);
            }
        });

        jBtSair.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtSair.setForeground(new java.awt.Color(204, 0, 0));
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBtConfirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSair)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtConfirmar, jBtSair});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtConfirmar)
                    .addComponent(jBtSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtConfirmar, jBtSair});

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
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBounds(300, 40, 512, 290);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtConfirmarActionPerformed
        // TODO add your handling code here:
        if (flag == 1) {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ATIVIDADESJURIDICOS "
                        + "WHERE DescricaoAtiv='" + descricaoAtiv + "'");
                conecta.rs.first();
                jIdAtiv.setText(conecta.rs.getString("IdAtiv"));
                jAtividadeRealizada.setText(conecta.rs.getString("DescricaoAtiv"));
                conecta.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa dos dados...\nERRO: " + e);
            }
            conecta.desconecta();
            dispose();
        }
    }//GEN-LAST:event_jBtConfirmarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jCheckBoxTodosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxTodosItemStateChanged
        // TODO add your handling code here:
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            jTabelaAtividades.setVisible(true);
            this.preencherAtividadeJuri("SELECT * FROM ATIVIDADESJURIDICOS "
                    + "WHERE StatusAtiv='" + statusAtiv + "'");
        } else {
            limparCamposTabela();
        }
    }//GEN-LAST:event_jCheckBoxTodosItemStateChanged

    private void jBtPesqDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqDescricaoActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (jPesqDescricao.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe a descrição para pesquisa.");
        } else {
            preencherAtividadeJuri("SELECT * FROM ATIVIDADESJURIDICOS "
                    + "WHERE DescricaoAtiv LIKE'" + jPesqDescricao.getText() + "%' "
                    + "AND StatusAtiv='" + statusAtiv + "'");
        }
    }//GEN-LAST:event_jBtPesqDescricaoActionPerformed

    private void jTabelaAtividadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaAtividadesMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            descricaoAtiv = "" + jTabelaAtividades.getValueAt(jTabelaAtividades.getSelectedRow(), 3);
            jPesqDescricao.setText(descricaoAtiv);
        }
    }//GEN-LAST:event_jTabelaAtividadesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtConfirmar;
    private javax.swing.JButton jBtPesqDescricao;
    private javax.swing.JButton jBtSair;
    private javax.swing.JCheckBox jCheckBoxTodos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jPesqDescricao;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTabelaAtividades;
    // End of variables declaration//GEN-END:variables

    public void preencherAtividadeJuri(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Descrição"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                // Formatar a data no formato Brasil
                dataAtiv = conecta.rs.getString("DataAtiv");
                String dia = dataAtiv.substring(8, 10);
                String mes = dataAtiv.substring(5, 7);
                String ano = dataAtiv.substring(0, 4);
                dataAtiv = dia + "/" + mes + "/" + ano;
                dados.add(new Object[]{conecta.rs.getInt("IdAtiv"), dataAtiv, conecta.rs.getString("StatusAtiv"), conecta.rs.getString("DescricaoAtiv")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaAtividades.setModel(modelo);
        jTabelaAtividades.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaAtividades.getColumnModel().getColumn(0).setResizable(false);
        jTabelaAtividades.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaAtividades.getColumnModel().getColumn(1).setResizable(false);
        jTabelaAtividades.getColumnModel().getColumn(2).setPreferredWidth(70);
        jTabelaAtividades.getColumnModel().getColumn(2).setResizable(false);
        jTabelaAtividades.getColumnModel().getColumn(3).setPreferredWidth(280);
        jTabelaAtividades.getColumnModel().getColumn(3).setResizable(false);
        jTabelaAtividades.getTableHeader().setReorderingAllowed(false);
        jTabelaAtividades.setAutoResizeMode(jTabelaAtividades.AUTO_RESIZE_OFF);
        jTabelaAtividades.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabela();
        conecta.desconecta();
    }

    public void limparCamposTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Descrição"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaAtividades.setModel(modelo);
        jTabelaAtividades.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaAtividades.getColumnModel().getColumn(0).setResizable(false);
        jTabelaAtividades.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaAtividades.getColumnModel().getColumn(1).setResizable(false);
        jTabelaAtividades.getColumnModel().getColumn(2).setPreferredWidth(70);
        jTabelaAtividades.getColumnModel().getColumn(2).setResizable(false);
        jTabelaAtividades.getColumnModel().getColumn(3).setPreferredWidth(280);
        jTabelaAtividades.getColumnModel().getColumn(3).setResizable(false);
        jTabelaAtividades.getTableHeader().setReorderingAllowed(false);
        jTabelaAtividades.setAutoResizeMode(jTabelaAtividades.AUTO_RESIZE_OFF);
        jTabelaAtividades.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabela() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaAtividades.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaAtividades.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaAtividades.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }
}
