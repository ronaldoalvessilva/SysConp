/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.ModeloTabela;
import static gestor.Visao.TelaLocacaoInterno.jDescricaoCela;
import static gestor.Visao.TelaLocacaoInterno.jDescricaoPavilhao;
import static gestor.Visao.TelaLocacaoInterno.jIdCela;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Ronaldo
 */
public class TelaPesqCelasLocacao extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    int flag;
    String nomePavilhao;
    String IdPav;
    String endCela;
    String statusCela = "Ativo";

    /**
     * Creates new form TelaPesqCelasLocacao
     */
    public TelaPesqCelasLocacao() {
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
        jPesqDescricao = new javax.swing.JTextField();
        jBtPesqDescricao = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaCelas = new javax.swing.JTable();
        jBtEnviar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Pesquisa de Celas - Segurança :::...");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Celas:");

        jPesqDescricao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqDescricao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqDescricao.setContentAreaFilled(false);
        jBtPesqDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqDescricaoActionPerformed(evt);
            }
        });

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox1.setText("Todos");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPesqDescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtPesqDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1)
                .addGap(14, 14, 14))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtPesqDescricao)
                    .addComponent(jPesqDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jCheckBox1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaCelas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaCelas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Código", "Pavilhão", "Cela"
            }
        ));
        jTabelaCelas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaCelasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaCelas);
        if (jTabelaCelas.getColumnModel().getColumnCount() > 0) {
            jTabelaCelas.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaCelas.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaCelas.getColumnModel().getColumn(1).setMinWidth(220);
            jTabelaCelas.getColumnModel().getColumn(1).setMaxWidth(220);
            jTabelaCelas.getColumnModel().getColumn(2).setMinWidth(140);
            jTabelaCelas.getColumnModel().getColumn(2).setMaxWidth(140);
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
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBtEnviar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSair)
                        .addGap(0, 223, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtEnviar)
                    .addComponent(jBtSair))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Listagem", jPanel1);

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

        setBounds(250, 20, 432, 294);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtEnviarActionPerformed
        // TODO add your handling code here:
        if (flag == 1) {
            nomePavilhao = "" + jTabelaCelas.getValueAt(jTabelaCelas.getSelectedRow(), 1);
            jPesqDescricao.setText(nomePavilhao);
            IdPav = "" + jTabelaCelas.getValueAt(jTabelaCelas.getSelectedRow(), 0);
            endCela = "" + jTabelaCelas.getValueAt(jTabelaCelas.getSelectedRow(), 2);
            jIdCela.setText(IdPav);
            jDescricaoCela.setText(endCela);
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM CELAS "
                        + "INNER JOIN PAVILHAO "
                        + "ON CELAS.IdPav=PAVILHAO.IdPav "
                        + "WHERE EndCelaPav='" + endCela + "'AND DescricaoPav='" + nomePavilhao + "'");
                conecta.rs.first();
                jIdCela.setText(String.valueOf(conecta.rs.getInt("IdCela")));
                jDescricaoCela.setText(conecta.rs.getString("EndCelaPav"));
                jDescricaoPavilhao.setText(conecta.rs.getString("DescricaoPav"));
                conecta.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa por nome" + e);
            }
            dispose();
        }
    }//GEN-LAST:event_jBtEnviarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtPesqDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqDescricaoActionPerformed
        // TODO add your handling code here:        
        flag = 1;
        if (jPesqDescricao.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe dados para pesquisa");
            jPesqDescricao.requestFocus();
        } else {
            preencherTabelaCelas("SELECT * FROM CELAS "
                    + "INNER JOIN PAVILHAO "
                    + "ON CELAS.IdPav=PAVILHAO.Idpav "
                    + "WHERE EndCelaPav LIKE'%" + jPesqDescricao.getText() + "%' "
                    + "AND CELAS.StatusCela='" + statusCela + "'");
        }
    }//GEN-LAST:event_jBtPesqDescricaoActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherTabelaCelas("SELECT * FROM CELAS "
                    + "INNER JOIN PAVILHAO "
                    + "ON CELAS.IdPav=PAVILHAO.IdPav WHERE CELAS.StatusCela='" + statusCela  + "'");
        } else {
            limparTabela();
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jTabelaCelasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaCelasMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            nomePavilhao = "" + jTabelaCelas.getValueAt(jTabelaCelas.getSelectedRow(), 1);
            jPesqDescricao.setText(nomePavilhao);
            IdPav = "" + jTabelaCelas.getValueAt(jTabelaCelas.getSelectedRow(), 0);
            endCela = "" + jTabelaCelas.getValueAt(jTabelaCelas.getSelectedRow(), 2);
        }

    }//GEN-LAST:event_jTabelaCelasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtEnviar;
    private javax.swing.JButton jBtPesqDescricao;
    private javax.swing.JButton jBtSair;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jPesqDescricao;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTabelaCelas;
    // End of variables declaration//GEN-END:variables

// Método de pesquisa pela Descrição
    public void preencherTabelaCelas(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Pavilhão", "Cela"};
        conecta.abrirConexao();
        conecta.executaSQL(sql);
        try {
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdCela"), conecta.rs.getString("DescricaoPav"), conecta.rs.getString("EndCelaPav")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Dados não encontrado, use o botão TODOS \nPara pesquisar TODOS OS REGISTROS");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaCelas.setModel(modelo);
        jTabelaCelas.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaCelas.getColumnModel().getColumn(0).setResizable(false);
        jTabelaCelas.getColumnModel().getColumn(1).setPreferredWidth(220);
        jTabelaCelas.getColumnModel().getColumn(1).setResizable(false);
        jTabelaCelas.getColumnModel().getColumn(2).setPreferredWidth(140);
        jTabelaCelas.getColumnModel().getColumn(2).setResizable(false);
        jTabelaCelas.getTableHeader().setReorderingAllowed(false);
        jTabelaCelas.setAutoResizeMode(jTabelaCelas.AUTO_RESIZE_OFF);
        jTabelaCelas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabela();
        conecta.desconecta();
    }

    public void limparTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Pavilhão", "Cela"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaCelas.setModel(modelo);
        jTabelaCelas.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaCelas.getColumnModel().getColumn(0).setResizable(false);
        jTabelaCelas.getColumnModel().getColumn(1).setPreferredWidth(220);
        jTabelaCelas.getColumnModel().getColumn(1).setResizable(false);
        jTabelaCelas.getColumnModel().getColumn(2).setPreferredWidth(140);
        jTabelaCelas.getColumnModel().getColumn(2).setResizable(false);
        jTabelaCelas.getTableHeader().setReorderingAllowed(false);
        jTabelaCelas.setAutoResizeMode(jTabelaCelas.AUTO_RESIZE_OFF);
        jTabelaCelas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
        jTabelaCelas.getColumnModel().getColumn(0).setCellRenderer(centralizado);
    }
}
