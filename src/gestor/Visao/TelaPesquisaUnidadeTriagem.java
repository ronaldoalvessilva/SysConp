/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Dao.ConexaoBancoDados;
import Utilitarios.LimiteDigitosAlfa;
import Utilitarios.ModeloTabela;
import static gestor.Visao.TelaProntuarioTriagem.jComboBoxUnid;
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
public class TelaPesquisaUnidadeTriagem extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    int flag;
    String NomeUnidade = "";

    /**
     * Creates new form TelaPesquisaCidade
     */
    public TelaPesquisaUnidadeTriagem() {
        initComponents();
//        jPesNomeUnidade.setDocument(new LimiteDigitosAlfa(50));
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
        jPanel2 = new javax.swing.JPanel();
        jPesNomeUnidade = new javax.swing.JTextField();
        jBtNome = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaUnidadePenal = new javax.swing.JTable();
        jBtEnviar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();

        setClosable(true);
        setTitle("...::: Pesquisar Unidade Penal :::...");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisar Unidade Penal", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 51, 255))); // NOI18N

        jPesNomeUnidade.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtNome.setToolTipText("Pesquisa por Nome");
        jBtNome.setContentAreaFilled(false);
        jBtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNomeActionPerformed(evt);
            }
        });

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox1.setText("Todos");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Nome:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPesNomeUnidade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(jBtNome)
                .addComponent(jPesNomeUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jCheckBox1)
                .addComponent(jLabel1))
        );

        jTabelaUnidadePenal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaUnidadePenal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Classifisicação", "Nome Unidade"
            }
        ));
        jTabelaUnidadePenal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaUnidadePenalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaUnidadePenal);
        if (jTabelaUnidadePenal.getColumnModel().getColumnCount() > 0) {
            jTabelaUnidadePenal.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaUnidadePenal.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaUnidadePenal.getColumnModel().getColumn(1).setMinWidth(100);
            jTabelaUnidadePenal.getColumnModel().getColumn(1).setMaxWidth(100);
            jTabelaUnidadePenal.getColumnModel().getColumn(2).setMinWidth(300);
            jTabelaUnidadePenal.getColumnModel().getColumn(2).setMaxWidth(300);
        }

        jBtEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/accept.png"))); // NOI18N
        jBtEnviar.setText("Enviar");
        jBtEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtEnviarActionPerformed(evt);
            }
        });

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBtEnviar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSair))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtEnviar, jBtSair});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtEnviar)
                    .addComponent(jBtSair))
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(500, 150, 507, 288);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNomeActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (jPesNomeUnidade.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe dados para pesquisa");
            jPesNomeUnidade.requestFocus();
        } else {
            preencherTabelaNome("SELECT "
                    + "IdUnid, "
                    + "ClassUnid, "
                    + "DescricaoUnid "
                    + "FROM UNIDADE "
                    + "WHERE DescricaoUnid LIKE'%" + jPesNomeUnidade.getText() + "%'");
        }
    }//GEN-LAST:event_jBtNomeActionPerformed

    private void jTabelaUnidadePenalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaUnidadePenalMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            NomeUnidade = "" + jTabelaUnidadePenal.getValueAt(jTabelaUnidadePenal.getSelectedRow(), 2);
            jPesNomeUnidade.setText(NomeUnidade);
        }
    }//GEN-LAST:event_jTabelaUnidadePenalMouseClicked

    private void jBtEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtEnviarActionPerformed
        // TODO add your handling code here:
        if (jPesNomeUnidade.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Selecione o nome da UNIDADE e clique no botão ENVIAR.");
        } else if (!jPesNomeUnidade.getText().isEmpty() && NomeUnidade.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Não foi realizada pesquisa da unidade prisional.");
        } else {
            jComboBoxUnid.setText(NomeUnidade);
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
            this.preencherTabela("SELECT "
                    + "IdUnid, "
                    + "ClassUnid, "
                    + "DescricaoUnid "
                    + "FROM UNIDADE "
                    + "ORDER BY DescricaoUnid");
        } else {
            limparTabela();
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtEnviar;
    private javax.swing.JButton jBtNome;
    private javax.swing.JButton jBtSair;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JTextField jPesNomeUnidade;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabelaUnidadePenal;
    // End of variables declaration//GEN-END:variables

    public void preencherTabela(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Codigo", "Classificação", "Nome da Unidade"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdUnid"), conecta.rs.getString("ClassUnid"), conecta.rs.getString("DescricaoUnid")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Dados não encontrado, use o botão TODOS \nPara pesquisar TODOS OS REGISTROS");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaUnidadePenal.setModel(modelo);
        jTabelaUnidadePenal.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaUnidadePenal.getColumnModel().getColumn(0).setResizable(false);
        jTabelaUnidadePenal.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTabelaUnidadePenal.getColumnModel().getColumn(1).setResizable(false);
        jTabelaUnidadePenal.getColumnModel().getColumn(2).setPreferredWidth(300);
        jTabelaUnidadePenal.getColumnModel().getColumn(2).setResizable(false);
        jTabelaUnidadePenal.getTableHeader().setReorderingAllowed(false);
        jTabelaUnidadePenal.setAutoResizeMode(jTabelaUnidadePenal.AUTO_RESIZE_OFF);
        jTabelaUnidadePenal.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaUnidade();
        conecta.desconecta();
    }

    public void preencherTabelaNome(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Codigo", "Classificação", "Nome da Unidade"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdUnid"), conecta.rs.getString("ClassUnid"), conecta.rs.getString("DescricaoUnid")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Dados não encontrado, use o botão TODOS \nPara pesquisar TODOS OS REGISTROS.");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaUnidadePenal.setModel(modelo);
        jTabelaUnidadePenal.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaUnidadePenal.getColumnModel().getColumn(0).setResizable(false);
        jTabelaUnidadePenal.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTabelaUnidadePenal.getColumnModel().getColumn(1).setResizable(false);
        jTabelaUnidadePenal.getColumnModel().getColumn(2).setPreferredWidth(300);
        jTabelaUnidadePenal.getColumnModel().getColumn(2).setResizable(false);
        jTabelaUnidadePenal.getTableHeader().setReorderingAllowed(false);
        jTabelaUnidadePenal.setAutoResizeMode(jTabelaUnidadePenal.AUTO_RESIZE_OFF);
        jTabelaUnidadePenal.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaUnidade();
        conecta.desconecta();
    }

    public void limparTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Codigo", "Classificação", "Nome da Unidade"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaUnidadePenal.setModel(modelo);
        jTabelaUnidadePenal.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaUnidadePenal.getColumnModel().getColumn(0).setResizable(false);
        jTabelaUnidadePenal.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTabelaUnidadePenal.getColumnModel().getColumn(1).setResizable(false);
        jTabelaUnidadePenal.getColumnModel().getColumn(2).setPreferredWidth(300);
        jTabelaUnidadePenal.getColumnModel().getColumn(2).setResizable(false);
        jTabelaUnidadePenal.getTableHeader().setReorderingAllowed(false);
        jTabelaUnidadePenal.setAutoResizeMode(jTabelaUnidadePenal.AUTO_RESIZE_OFF);
        jTabelaUnidadePenal.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabelaUnidade() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaUnidadePenal.getColumnModel().getColumn(0).setCellRenderer(centralizado);
    }
}
