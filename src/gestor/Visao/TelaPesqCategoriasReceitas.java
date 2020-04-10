/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Dao.ConexaoBancoDados;
import Utilitarios.ModeloTabela;
import static gestor.Visao.TelaFichaTecnica.jCodigoCategoria;
import static gestor.Visao.TelaFichaTecnica.jDescricaoCategoria;
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
public class TelaPesqCategoriasReceitas extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    int flag, acao;

    /**
     * Creates new form TelaCategoriasReceitas
     */
    public TelaPesqCategoriasReceitas() {
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
        jTabelaCatReceitas = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jCodPesqCatReceita = new javax.swing.JTextField();
        jPesqDescricaoCatReceita = new javax.swing.JTextField();
        jBtPesqCodigoReceita = new javax.swing.JButton();
        jBtPesqDescricaoReceita = new javax.swing.JButton();
        jCheckBoxTodos = new javax.swing.JCheckBox();
        jBtEnviar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Categorias de Receitas :::...");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jTabelaCatReceitas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaCatReceitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Código", "Status", "Tipo Receita", "Descrição da Categoria"
            }
        ));
        jTabelaCatReceitas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaCatReceitasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaCatReceitas);
        if (jTabelaCatReceitas.getColumnModel().getColumnCount() > 0) {
            jTabelaCatReceitas.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaCatReceitas.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaCatReceitas.getColumnModel().getColumn(1).setMinWidth(50);
            jTabelaCatReceitas.getColumnModel().getColumn(1).setMaxWidth(50);
            jTabelaCatReceitas.getColumnModel().getColumn(2).setMinWidth(100);
            jTabelaCatReceitas.getColumnModel().getColumn(2).setMaxWidth(100);
            jTabelaCatReceitas.getColumnModel().getColumn(3).setMinWidth(280);
            jTabelaCatReceitas.getColumnModel().getColumn(3).setMaxWidth(280);
        }

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Código:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Descrição:");

        jCodPesqCatReceita.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jPesqDescricaoCatReceita.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqCodigoReceita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqCodigoReceita.setContentAreaFilled(false);
        jBtPesqCodigoReceita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqCodigoReceitaActionPerformed(evt);
            }
        });

        jBtPesqDescricaoReceita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqDescricaoReceita.setContentAreaFilled(false);
        jBtPesqDescricaoReceita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqDescricaoReceitaActionPerformed(evt);
            }
        });

        jCheckBoxTodos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxTodos.setText("Todos");
        jCheckBoxTodos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxTodosItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPesqDescricaoCatReceita)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqDescricaoReceita, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jCodPesqCatReceita, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqCodigoReceita, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBoxTodos)))
                .addContainerGap())
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtPesqCodigoReceita, jBtPesqDescricaoReceita});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel6)
                    .addComponent(jCodPesqCatReceita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqCodigoReceita)
                    .addComponent(jCheckBoxTodos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPesqDescricaoCatReceita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqDescricaoReceita)
                    .addComponent(jLabel7))
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBtEnviar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSair)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtEnviar, jBtSair});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtEnviar)
                    .addComponent(jBtSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Listagem", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBounds(300, 30, 492, 322);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesqCodigoReceitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqCodigoReceitaActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (jCodPesqCatReceita.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o código para pesquisa.");
        } else {
            preencherTabelaCategoria("SELECT * FROM CATEGORIA_RECEITAS_NUTRI "
                    + "WHERE IdCat='" + jCodPesqCatReceita.getText() + "'");
        }
    }//GEN-LAST:event_jBtPesqCodigoReceitaActionPerformed

    private void jCheckBoxTodosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxTodosItemStateChanged
        // TODO add your handling code here:
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherTabelaCategoria("SELECT * FROM CATEGORIA_RECEITAS_NUTRI");
        } else {
            limparTabelaCategoria();
        }
    }//GEN-LAST:event_jCheckBoxTodosItemStateChanged

    private void jBtPesqDescricaoReceitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqDescricaoReceitaActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (jPesqDescricaoCatReceita.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe uma letra ou parte do nome para pesquisa.");
        } else {
            preencherTabelaCategoria("SELECT * FROM CATEGORIA_RECEITAS_NUTRI "
                    + "WHERE DescricaoCategoria LIKE'%" + jPesqDescricaoCatReceita.getText() + "%'");
        }
    }//GEN-LAST:event_jBtPesqDescricaoReceitaActionPerformed

    private void jBtEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtEnviarActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String nomeCategoria = "" + jTabelaCatReceitas.getValueAt(jTabelaCatReceitas.getSelectedRow(), 3);
            jPesqDescricaoCatReceita.setText(nomeCategoria);
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM CATEGORIA_RECEITAS_NUTRI WHERE DescricaoCategoria='" + nomeCategoria + "'");
                conecta.rs.first();               
                jCodigoCategoria.setText(String.valueOf(conecta.rs.getInt("IdCat")));
                jDescricaoCategoria.setText(conecta.rs.getString("DescricaoCategoria"));
                //               
                conecta.desconecta();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa dos dados.\nERRO: " + ex);
            }
            dispose();
        }
    }//GEN-LAST:event_jBtEnviarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jTabelaCatReceitasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaCatReceitasMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            String nomeCategoria = "" + jTabelaCatReceitas.getValueAt(jTabelaCatReceitas.getSelectedRow(), 3);
            jPesqDescricaoCatReceita.setText(nomeCategoria);
        }
    }//GEN-LAST:event_jTabelaCatReceitasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtEnviar;
    private javax.swing.JButton jBtPesqCodigoReceita;
    private javax.swing.JButton jBtPesqDescricaoReceita;
    private javax.swing.JButton jBtSair;
    private javax.swing.JCheckBox jCheckBoxTodos;
    private javax.swing.JTextField jCodPesqCatReceita;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField jPesqDescricaoCatReceita;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTabelaCatReceitas;
    // End of variables declaration//GEN-END:variables

    public void preencherTabelaCategoria(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Status", "Tipo Receita", "Descrição da Categoria"};
        conecta.abrirConexao();
        conecta.executaSQL(sql);
        try {
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdCat"), conecta.rs.getString("StatusCat"), conecta.rs.getString("TipoReceita"), conecta.rs.getString("DescricaoCategoria")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem exibidos....");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaCatReceitas.setModel(modelo);
        jTabelaCatReceitas.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaCatReceitas.getColumnModel().getColumn(0).setResizable(false);
        jTabelaCatReceitas.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTabelaCatReceitas.getColumnModel().getColumn(1).setResizable(false);
        jTabelaCatReceitas.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTabelaCatReceitas.getColumnModel().getColumn(2).setResizable(false);
        jTabelaCatReceitas.getColumnModel().getColumn(3).setPreferredWidth(280);
        jTabelaCatReceitas.getColumnModel().getColumn(3).setResizable(false);
        jTabelaCatReceitas.getTableHeader().setReorderingAllowed(false);
        jTabelaCatReceitas.setAutoResizeMode(jTabelaCatReceitas.AUTO_RESIZE_OFF);
        jTabelaCatReceitas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // ALINHAR AS COLUNAS DA TABELA, ESQUERDA, DIREITA E CENTRALIZADA
        alinharColunasTabela();
        //
        conecta.desconecta();
    }

    public void limparTabelaCategoria() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Status", "Tipo Receita", "Descrição da Categoria"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaCatReceitas.setModel(modelo);
        jTabelaCatReceitas.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaCatReceitas.getColumnModel().getColumn(0).setResizable(false);
        jTabelaCatReceitas.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTabelaCatReceitas.getColumnModel().getColumn(1).setResizable(false);
        jTabelaCatReceitas.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTabelaCatReceitas.getColumnModel().getColumn(2).setResizable(false);
        jTabelaCatReceitas.getColumnModel().getColumn(3).setPreferredWidth(280);
        jTabelaCatReceitas.getColumnModel().getColumn(3).setResizable(false);
        jTabelaCatReceitas.getTableHeader().setReorderingAllowed(false);
        jTabelaCatReceitas.setAutoResizeMode(jTabelaCatReceitas.AUTO_RESIZE_OFF);
        jTabelaCatReceitas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharColunasTabela() {
        //
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        //
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaCatReceitas.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaCatReceitas.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaCatReceitas.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }
}
