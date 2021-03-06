/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Dao.ConexaoBancoDados;
import Utilitarios.ModeloTabela;
import static gestor.Visao.TelaCalendarioVacinasInternos.jCategoriaVacina;
import static gestor.Visao.TelaCalendarioVacinasInternos.jDescricaoVacina;
import static gestor.Visao.TelaCalendarioVacinasInternos.jIdVacina;
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
public class TelaPesqTipoVacinas extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    int flag;
    String statusUnid = "Ativo";
    String nomeExame;

    /**
     * Creates new form TelaPesqCelasLocacao
     */
    public TelaPesqTipoVacinas() {
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
        jTabelaInstituicaoEscolar = new javax.swing.JTable();
        jBtEnviar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Pesquisa de Tipo Vacinas :::...");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Nome Vacina:");

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
                .addContainerGap()
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

        jTabelaInstituicaoEscolar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaInstituicaoEscolar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome do Exame"
            }
        ));
        jTabelaInstituicaoEscolar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaInstituicaoEscolarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaInstituicaoEscolar);
        if (jTabelaInstituicaoEscolar.getColumnModel().getColumnCount() > 0) {
            jTabelaInstituicaoEscolar.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaInstituicaoEscolar.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaInstituicaoEscolar.getColumnModel().getColumn(1).setMinWidth(370);
            jTabelaInstituicaoEscolar.getColumnModel().getColumn(1).setMaxWidth(370);
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
                        .addGap(0, 237, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtEnviar)
                    .addComponent(jBtSair))
                .addGap(0, 4, Short.MAX_VALUE))
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
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(250, 20, 446, 278);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtEnviarActionPerformed
        // TODO add your handling code here:
        if (flag == 1) {
            nomeExame = "" + jTabelaInstituicaoEscolar.getValueAt(jTabelaInstituicaoEscolar.getSelectedRow(), 1);
            jPesqDescricao.setText(nomeExame);
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM TIPOS_VACINAS WHERE DescricaoVacina='" + nomeExame + "'");
                conecta.rs.first();
                jIdVacina.setText(conecta.rs.getString("IdVacina"));
                jDescricaoVacina.setText(conecta.rs.getString("DescricaoVacina"));
                jCategoriaVacina.setText(conecta.rs.getString("Classificacao"));
                conecta.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa por nome" + e);
            }
            dispose();
        }
        conecta.abrirConexao();
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
            preencherTabelaInstituicao("SELECT * FROM TIPOS_VACINAS WHERE DescricaoVacina LIKE'%" + jPesqDescricao.getText() + "%'AND StatusVacina='" + statusUnid + "'");
        }
    }//GEN-LAST:event_jBtPesqDescricaoActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherTabelaInstituicao("SELECT * FROM TIPOS_VACINAS WHERE StatusVacina='" + statusUnid + "'");
        } else {
            limparTabela();
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jTabelaInstituicaoEscolarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaInstituicaoEscolarMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            nomeExame = "" + jTabelaInstituicaoEscolar.getValueAt(jTabelaInstituicaoEscolar.getSelectedRow(), 1);
            jPesqDescricao.setText(nomeExame);
        }
    }//GEN-LAST:event_jTabelaInstituicaoEscolarMouseClicked


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
    private javax.swing.JTable jTabelaInstituicaoEscolar;
    // End of variables declaration//GEN-END:variables

// Método de pesquisa pela Descrição
    public void preencherTabelaInstituicao(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome da Vacina"};
        conecta.abrirConexao();
        conecta.executaSQL(sql);
        try {
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdVacina"), conecta.rs.getString("DescricaoVacina")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Dados não encontrado, use o botão TODOS \nPara pesquisar TODOS OS REGISTROS");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInstituicaoEscolar.setModel(modelo);
        jTabelaInstituicaoEscolar.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaInstituicaoEscolar.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInstituicaoEscolar.getColumnModel().getColumn(1).setPreferredWidth(370);
        jTabelaInstituicaoEscolar.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInstituicaoEscolar.getTableHeader().setReorderingAllowed(false);
        jTabelaInstituicaoEscolar.setAutoResizeMode(jTabelaInstituicaoEscolar.AUTO_RESIZE_OFF);
        jTabelaInstituicaoEscolar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabela();
        conecta.desconecta();
    }

    public void limparTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome da Vacina"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInstituicaoEscolar.setModel(modelo);
        jTabelaInstituicaoEscolar.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaInstituicaoEscolar.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInstituicaoEscolar.getColumnModel().getColumn(1).setPreferredWidth(370);
        jTabelaInstituicaoEscolar.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInstituicaoEscolar.getTableHeader().setReorderingAllowed(false);
        jTabelaInstituicaoEscolar.setAutoResizeMode(jTabelaInstituicaoEscolar.AUTO_RESIZE_OFF);
        jTabelaInstituicaoEscolar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabela() {
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaInstituicaoEscolar.getColumnModel().getColumn(0).setCellRenderer(centralizado);
    }
}
