/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Dao.ConexaoBancoDados;
import Utilitarios.ModeloTabela;
import static gestor.Visao.TelaTransCelasBGPA.jDescricaoCelaDestino;
import static gestor.Visao.TelaTransCelasBGPA.jDescricaoRaioDestino;
import static gestor.Visao.TelaTransCelasBGPA.jIdCelaDestino;
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
public class TelaPesqCelasTransInternoBGPA extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    int flag;
    String nomePavilhao;
    String IdPav;
    String endCela;
    String statusCela = "Ativo";
//    String nivelCela = "B";

    /**
     * Creates new form TelaPesqCelasTransInterno
     */
    public TelaPesqCelasTransInternoBGPA() {
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

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPesqDescricaoCela = new javax.swing.JTextField();
        jBtPesqNome = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaCelasPavilhao = new javax.swing.JTable();
        jBtEnviar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Listagem de Celas {SE} :::...");

        jTabbedPane3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Descrição Cela:");

        jPesqDescricaoCela.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqNome.setContentAreaFilled(false);
        jBtPesqNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqNomeActionPerformed(evt);
            }
        });

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox1.setText("Todos");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPesqDescricaoCela)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtPesqNome, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox1)
                .addGap(14, 14, 14))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtPesqNome)
                    .addComponent(jPesqDescricaoCela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jCheckBox1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaCelasPavilhao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaCelasPavilhao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Pavilhão", "Cela"
            }
        ));
        jTabelaCelasPavilhao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaCelasPavilhaoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaCelasPavilhao);
        if (jTabelaCelasPavilhao.getColumnModel().getColumnCount() > 0) {
            jTabelaCelasPavilhao.getColumnModel().getColumn(0).setMinWidth(60);
            jTabelaCelasPavilhao.getColumnModel().getColumn(0).setMaxWidth(60);
            jTabelaCelasPavilhao.getColumnModel().getColumn(1).setMinWidth(140);
            jTabelaCelasPavilhao.getColumnModel().getColumn(1).setMaxWidth(140);
            jTabelaCelasPavilhao.getColumnModel().getColumn(2).setMinWidth(200);
            jTabelaCelasPavilhao.getColumnModel().getColumn(2).setMaxWidth(200);
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jBtEnviar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSair)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtEnviar)
                    .addComponent(jBtSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Pesquisas", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(300, 10, 443, 284);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesqNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNomeActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (jPesqDescricaoCela.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe dados para pesquisa");
            jPesqDescricaoCela.requestFocus();
        } else {
            preencherTabelaCelas("SELECT * FROM CELAS "
                    + "INNER JOIN PAVILHAO "
                    + "ON CELAS.IdPav=PAVILHAO.Idpav "
                    + "WHERE EndCelaPav LIKE'%" + jPesqDescricaoCela.getText() + "%' "
                    + "AND StatusCela='" + statusCela + "'");
        }
    }//GEN-LAST:event_jBtPesqNomeActionPerformed

    private void jBtEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtEnviarActionPerformed
        // TODO add your handling code here:
        if (flag == 1) {
            nomePavilhao = "" + jTabelaCelasPavilhao.getValueAt(jTabelaCelasPavilhao.getSelectedRow(), 1);
            jPesqDescricaoCela.setText(nomePavilhao);
            IdPav = "" + jTabelaCelasPavilhao.getValueAt(jTabelaCelasPavilhao.getSelectedRow(), 0);
            endCela = "" + jTabelaCelasPavilhao.getValueAt(jTabelaCelasPavilhao.getSelectedRow(), 2);
            //
            jIdCelaDestino.setText(IdPav);
            jDescricaoCelaDestino.setText(endCela);
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM CELAS "
                        + "INNER JOIN PAVILHAO "
                        + "ON CELAS.IdPav = PAVILHAO.IdPav "
                        + "WHERE EndCelaPav='" + endCela + "'");
                conecta.rs.first();
                jIdCelaDestino.setText(String.valueOf(conecta.rs.getInt("IdCela")));
                jDescricaoCelaDestino.setText(conecta.rs.getString("EndCelaPav"));
                jDescricaoRaioDestino.setText(conecta.rs.getString("DescricaoPav"));
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

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherTabelaCelas("SELECT * FROM CELAS "
                    + "INNER JOIN PAVILHAO "
                    + "ON CELAS.IdPav=PAVILHAO.IdPav "
                    + "WHERE CELAS.StatusCela='" + statusCela + "'");
        } else {
            limparTabela();
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jTabelaCelasPavilhaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaCelasPavilhaoMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            nomePavilhao = "" + jTabelaCelasPavilhao.getValueAt(jTabelaCelasPavilhao.getSelectedRow(), 1);
            jPesqDescricaoCela.setText(nomePavilhao);
            IdPav = "" + jTabelaCelasPavilhao.getValueAt(jTabelaCelasPavilhao.getSelectedRow(), 0);
            endCela = "" + jTabelaCelasPavilhao.getValueAt(jTabelaCelasPavilhao.getSelectedRow(), 2);
            //
            jIdCelaDestino.setText(IdPav);
            jDescricaoCelaDestino.setText(endCela);
        }
    }//GEN-LAST:event_jTabelaCelasPavilhaoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtEnviar;
    private javax.swing.JButton jBtPesqNome;
    private javax.swing.JButton jBtSair;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jPesqDescricaoCela;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable jTabelaCelasPavilhao;
    // End of variables declaration//GEN-END:variables

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
        jTabelaCelasPavilhao.setModel(modelo);
        jTabelaCelasPavilhao.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaCelasPavilhao.getColumnModel().getColumn(0).setResizable(false);
        jTabelaCelasPavilhao.getColumnModel().getColumn(1).setPreferredWidth(140);
        jTabelaCelasPavilhao.getColumnModel().getColumn(1).setResizable(false);
        jTabelaCelasPavilhao.getColumnModel().getColumn(2).setPreferredWidth(200);
        jTabelaCelasPavilhao.getColumnModel().getColumn(2).setResizable(false);
        jTabelaCelasPavilhao.getTableHeader().setReorderingAllowed(false);
        jTabelaCelasPavilhao.setAutoResizeMode(jTabelaCelasPavilhao.AUTO_RESIZE_OFF);
        jTabelaCelasPavilhao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabela();
        conecta.desconecta();
    }

    public void limparTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Pavilhão", "Cela"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaCelasPavilhao.setModel(modelo);
        jTabelaCelasPavilhao.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaCelasPavilhao.getColumnModel().getColumn(0).setResizable(false);
        jTabelaCelasPavilhao.getColumnModel().getColumn(1).setPreferredWidth(140);
        jTabelaCelasPavilhao.getColumnModel().getColumn(1).setResizable(false);
        jTabelaCelasPavilhao.getColumnModel().getColumn(2).setPreferredWidth(200);
        jTabelaCelasPavilhao.getColumnModel().getColumn(2).setResizable(false);
        jTabelaCelasPavilhao.getTableHeader().setReorderingAllowed(false);
        jTabelaCelasPavilhao.setAutoResizeMode(jTabelaCelasPavilhao.AUTO_RESIZE_OFF);
        jTabelaCelasPavilhao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
        jTabelaCelasPavilhao.getColumnModel().getColumn(0).setCellRenderer(centralizado);
    }
}
