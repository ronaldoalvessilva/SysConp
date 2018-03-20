/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Dao.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Ronaldo
 */
public class TelaPesquisaOpPrevisaoSaida extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    int flag;
    String tipo = "Saídas";

    /**
     * Creates new form TelaPesquisaCidade
     */
    public TelaPesquisaOpPrevisaoSaida() {
        initComponents();
        jPesDescOp.setDocument(new LimiteDigitosAlfa(33));
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
        jPesDescOp = new javax.swing.JTextField();
        jBtNome = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaOperacao = new javax.swing.JTable();
        jBtEnviar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();

        setClosable(true);
        setTitle("...::: Pesquisar Tipo Operação :::...");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisar Tipo Operação", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(51, 51, 255)));

        jPesDescOp.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/pesq.png"))); // NOI18N
        jBtNome.setToolTipText("Pesquisa por Nome");
        jBtNome.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPesDescOp)
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
                .addComponent(jPesDescOp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jCheckBox1))
        );

        jTabelaOperacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaOperacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTabelaOperacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaOperacaoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaOperacao);

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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtEnviar)
                    .addComponent(jBtSair))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBounds(300, 150, 346, 243);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNomeActionPerformed
        // TODO add your handling code here:
        // Pesquisa feita somente para operação de entrada
        flag = 1;
        if (jPesDescOp.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe dados para pesquisa");
            jPesDescOp.requestFocus();
        } else {
            jTabelaOperacao.setVisible(true);
            preencherTabelaNome("SELECT * FROM OPERACAO WHERE DescricaoOp LIKE'" + jPesDescOp.getText() + "%' AND TipoOp='" + tipo + "'");
        }

    }//GEN-LAST:event_jBtNomeActionPerformed

    private void jTabelaOperacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaOperacaoMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            String descricaoOperacao = "" + jTabelaOperacao.getValueAt(jTabelaOperacao.getSelectedRow(), 1);
            jPesDescOp.setText(descricaoOperacao);
        }
    }//GEN-LAST:event_jTabelaOperacaoMouseClicked

    private void jBtEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtEnviarActionPerformed
        // TODO add your handling code here:
        if (jPesDescOp.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Selecione o nome da OPERAÇÃO e clique no botão ENVIAR");
        }
        TelaPrevisaoSaidaInternos.jOperacao.setText(jPesDescOp.getText());
        dispose();
    }//GEN-LAST:event_jBtEnviarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        flag = 1;
            if (evt.getStateChange() == evt.SELECTED) {
                jTabelaOperacao.setVisible(true);
                this.preencherTabela();
            } else {
                jTabelaOperacao.setVisible(!true);
            }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtEnviar;
    private javax.swing.JButton jBtNome;
    private javax.swing.JButton jBtSair;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JTextField jPesDescOp;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabelaOperacao;
    // End of variables declaration//GEN-END:variables

    public void preencherTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"ID", "Descrição"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM OPERACAO WHERE TipoOp='"+ tipo +"'");
            conecta.rs.first();            
                do {
                dados.add(new Object[]{conecta.rs.getInt("IdOp"), conecta.rs.getString("DescricaoOp")});
            } while (conecta.rs.next());                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Dados não encontrado, use o botão TODOS \nPara pesquisar TODOS OS REGISTROS");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaOperacao.setModel(modelo);
        jTabelaOperacao.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaOperacao.getColumnModel().getColumn(0).setResizable(false);
        jTabelaOperacao.getColumnModel().getColumn(1).setPreferredWidth(240);
        jTabelaOperacao.getColumnModel().getColumn(1).setResizable(false);        
        jTabelaOperacao.getTableHeader().setReorderingAllowed(false);
        jTabelaOperacao.setAutoResizeMode(jTabelaOperacao.AUTO_RESIZE_OFF);
        jTabelaOperacao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conecta.desconecta();
    }

    public void preencherTabelaNome(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Descrição"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdOp"), conecta.rs.getString("DescricaoOp")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Dados não encontrado, use o botão TODOS \nPara pesquisar TODOS OS REGISTROS");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaOperacao.setModel(modelo);
        jTabelaOperacao.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaOperacao.getColumnModel().getColumn(0).setResizable(false);
        jTabelaOperacao.getColumnModel().getColumn(1).setPreferredWidth(240);
        jTabelaOperacao.getColumnModel().getColumn(1).setResizable(false);        
        jTabelaOperacao.getTableHeader().setReorderingAllowed(false);
        jTabelaOperacao.setAutoResizeMode(jTabelaOperacao.AUTO_RESIZE_OFF);
        jTabelaOperacao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conecta.desconecta();
    }
}
