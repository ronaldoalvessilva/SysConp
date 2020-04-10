/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Dao.ConexaoBancoDados;
import Utilitarios.LimiteDigitosAlfa;
import Utilitarios.ModeloTabela;
import static gestor.Visao.TelaCelas.jPavilhao;
import static gestor.Visao.TelaCelas.nivelCelaSeg;
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
public class TelaPesqPavilhao extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    int flag;
    String nomePavilhao;
    String statusPavilhao = "Ativo";

    /**
     * Creates new form TelaPesqPavilhao
     */
    public TelaPesqPavilhao() {
        initComponents();
        jPesqNomePavilhao.setDocument(new LimiteDigitosAlfa(40));
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
        jPesqNomePavilhao = new javax.swing.JTextField();
        jBtDescricao = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaPavilhao = new javax.swing.JTable();
        jBtEnviar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Pesquisa Pavilhao :::...");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Nome Pavilhão:");

        jPesqNomePavilhao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtDescricao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtDescricao.setContentAreaFilled(false);
        jBtDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtDescricaoActionPerformed(evt);
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
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPesqNomePavilhao, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtDescricao)
                    .addComponent(jPesqNomePavilhao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jCheckBox1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaPavilhao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaPavilhao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Código", "Descrição", "Nível"
            }
        ));
        jTabelaPavilhao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaPavilhaoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaPavilhao);
        if (jTabelaPavilhao.getColumnModel().getColumnCount() > 0) {
            jTabelaPavilhao.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaPavilhao.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaPavilhao.getColumnModel().getColumn(1).setMinWidth(340);
            jTabelaPavilhao.getColumnModel().getColumn(1).setMaxWidth(340);
            jTabelaPavilhao.getColumnModel().getColumn(2).setMinWidth(70);
            jTabelaPavilhao.getColumnModel().getColumn(2).setMaxWidth(70);
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 1, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jBtEnviar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtSair)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtEnviar)
                    .addComponent(jBtSair))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Pesquisa", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(250, 20, 521, 286);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtEnviarActionPerformed
        // TODO add your handling code here:
        // flag = 1;
        if (jPesqNomePavilhao.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Selecione o nome do pavilhão e clique no botão ENVIAR");
        } else {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM PAVILHAO WHERE DescricaoPav='" + jPesqNomePavilhao.getText() + "'");
                conecta.rs.first();
                jPavilhao.setText(conecta.rs.getString("DescricaoPav"));
                nivelCelaSeg = conecta.rs.getString("NivelPav");
                conecta.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa PAVILHÃO.\nERRO: " + e);
            }
            dispose();
        }
    }//GEN-LAST:event_jBtEnviarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtDescricaoActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (jPesqNomePavilhao.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um nome para pesquisa.");
            jPesqNomePavilhao.requestFocus();
        } else {
            preencherTabela("SELECT * FROM PAVILHAO "
                    + "WHERE DescricaoPav LIKE'%" + jPesqNomePavilhao.getText() + "%' "
                    + "AND StatusPav='" + statusPavilhao + "'");
        }
    }//GEN-LAST:event_jBtDescricaoActionPerformed

    private void jTabelaPavilhaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaPavilhaoMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            String NomePavilhao = "" + jTabelaPavilhao.getValueAt(jTabelaPavilhao.getSelectedRow(), 1);
            jPesqNomePavilhao.setText(NomePavilhao);
            String IdPav = "" + jTabelaPavilhao.getValueAt(jTabelaPavilhao.getSelectedRow(), 0);

        }
    }//GEN-LAST:event_jTabelaPavilhaoMouseClicked

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherTabela("SELECT * FROM PAVILHAO WHERE StatusPav='" + statusPavilhao + "'");
        } else {
            limparTabela();
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtDescricao;
    private javax.swing.JButton jBtEnviar;
    private javax.swing.JButton jBtSair;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jPesqNomePavilhao;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTabelaPavilhao;
    // End of variables declaration//GEN-END:variables

    public void preencherTabela(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Descrição", "Nivel"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdPav"), conecta.rs.getString("DescricaoPav"), conecta.rs.getString("NivelPav")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não existe dados a ser exibido!!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPavilhao.setModel(modelo);
        jTabelaPavilhao.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaPavilhao.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPavilhao.getColumnModel().getColumn(1).setPreferredWidth(340);
        jTabelaPavilhao.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPavilhao.getColumnModel().getColumn(2).setPreferredWidth(70);
        jTabelaPavilhao.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPavilhao.getTableHeader().setReorderingAllowed(false);
        jTabelaPavilhao.setAutoResizeMode(jTabelaPavilhao.AUTO_RESIZE_OFF);
        jTabelaPavilhao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCampos();
        conecta.desconecta();
    }

    public void limparTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Descrição", "Nivel"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPavilhao.setModel(modelo);
        jTabelaPavilhao.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaPavilhao.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPavilhao.getColumnModel().getColumn(1).setPreferredWidth(340);
        jTabelaPavilhao.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPavilhao.getColumnModel().getColumn(2).setPreferredWidth(70);
        jTabelaPavilhao.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPavilhao.getTableHeader().setReorderingAllowed(false);
        jTabelaPavilhao.setAutoResizeMode(jTabelaPavilhao.AUTO_RESIZE_OFF);
        jTabelaPavilhao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCampos() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaPavilhao.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaPavilhao.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }
}
