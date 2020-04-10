/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import Utilitarios.ModeloTabela;
import gestor.Dao.*;
import static gestor.Visao.TelaInventarioProdutosNUTRI.idItem;
import static gestor.Visao.TelaInventarioProdutosNUTRI.jBtAlterarItem;
import static gestor.Visao.TelaInventarioProdutosNUTRI.jBtBuscarProduto;
import static gestor.Visao.TelaInventarioProdutosNUTRI.jBtCancelarItem;
import static gestor.Visao.TelaInventarioProdutosNUTRI.jBtExcluirItem;
import static gestor.Visao.TelaInventarioProdutosNUTRI.jBtNovoItem;
import static gestor.Visao.TelaInventarioProdutosNUTRI.jBtSalvarItem;
import static gestor.Visao.TelaInventarioProdutosNUTRI.jDataVctoLote;
import static gestor.Visao.TelaInventarioProdutosNUTRI.jIdLanc;
import static gestor.Visao.TelaInventarioProdutosNUTRI.jBtAuditoriaItens;
import static gestor.Visao.TelaInventarioProdutosNUTRI.jBtImpressaoItens;
import static gestor.Visao.TelaInventarioProdutosNUTRI.jCodigoBarra;
import static gestor.Visao.TelaInventarioProdutosNUTRI.jComboBoxUnidProduto;
import static gestor.Visao.TelaInventarioProdutosNUTRI.jDescricaoProduto;
import static gestor.Visao.TelaInventarioProdutosNUTRI.jIdProduto;
import static gestor.Visao.TelaInventarioProdutosNUTRI.jLote;
import static gestor.Visao.TelaInventarioProdutosNUTRI.jQtd;
import static gestor.Visao.TelaInventarioProdutosNUTRI.jValorCusto;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author user
 */
public class TelaBuscarProdutosInventarioNUTRI extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    int flag;
    double valorCusto = 0;
    double qtdItem = 0;

    /**
     * Creates new form TelaPesqColaborador
     */
    public TelaBuscarProdutosInventarioNUTRI() {
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
        jPesqDescricaoProduto = new javax.swing.JTextField();
        jBtPesqNome = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaPesqProdutos = new javax.swing.JTable();
        jBtEnviar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Pesquisa Produtos Inventário - {NUTRI} :::...");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Listagem de Produtos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jPesqDescricaoProduto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqNome.setToolTipText("Pesquisa por Nome");
        jBtPesqNome.setContentAreaFilled(false);
        jBtPesqNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqNomeActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Descrição:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPesqDescricaoProduto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtPesqNome, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPesqDescricaoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jBtPesqNome))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jTabelaPesqProdutos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaPesqProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTabelaPesqProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaPesqProdutosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaPesqProdutos);

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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBtEnviar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSair)
                        .addGap(0, 221, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtEnviar)
                    .addComponent(jBtSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        setBounds(250, 20, 430, 270);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtEnviarActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String descricaoProduto = "" + jTabelaPesqProdutos.getValueAt(jTabelaPesqProdutos.getSelectedRow(), 1);
            jPesqDescricaoProduto.setText(descricaoProduto);
            String codProd = "" + jTabelaPesqProdutos.getValueAt(jTabelaPesqProdutos.getSelectedRow(), 0);
            //
            jBtNovoItem.setEnabled(true);
            jBtAlterarItem.setEnabled(true);
            jBtExcluirItem.setEnabled(true);
            jBtSalvarItem.setEnabled(!true);
            jBtCancelarItem.setEnabled(true);
            jBtBuscarProduto.setEnabled(true);
            jBtImpressaoItens.setEnabled(true);
            jBtAuditoriaItens.setEnabled(true);
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ITENS_INVENTARIO_NUTRI "
                        + "INNER JOIN PRODUTOS_NUTRI "
                        + "ON ITENS_INVENTARIO_NUTRI.IdProd=PRODUTOS_NUTRI.IdProd "
                        + "WHERE DescricaoProd='" + jPesqDescricaoProduto.getText() + "' AND IdLanc='" + jIdLanc.getText() + "'");
                conecta.rs.first();
                jIdProduto.setText(conecta.rs.getString("IdProd")); //Coluna 0
                jDescricaoProduto.setText(conecta.rs.getString("DescricaoProd")); // Coluna 1 
                idItem = conecta.rs.getString("IdItem"); // Coluna 2                                                               
                jCodigoBarra.setText(conecta.rs.getString("CodigoBarra"));
                jComboBoxUnidProduto.setSelectedItem(conecta.rs.getString("UnidadeProd"));
                qtdItem = conecta.rs.getFloat("QtdItem");
                DecimalFormat vi = new DecimalFormat(",###0.00");
                String vqtdItem = vi.format(qtdItem);
                jQtd.setText(vqtdItem);
                // Formata o valor para ser exibido na tela no formato BR                                                   
                valorCusto = conecta.rs.getFloat("ValorCusto");
                DecimalFormat vc = new DecimalFormat(",###0.00");
                String vlCusto = vc.format(valorCusto);
                jValorCusto.setText(vlCusto);
                jLote.setText(conecta.rs.getString("Lote"));
                jDataVctoLote.setDate(conecta.rs.getDate("DataLote"));
                conecta.desconecta();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa por nome" + ex);
            }
            dispose();
        }
    }//GEN-LAST:event_jBtEnviarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtPesqNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNomeActionPerformed
        // TODO add your handling code here:                
        flag = 1;
        if (jPesqDescricaoProduto.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um nome ou parte do nome para pesquisar.");
            jPesqDescricaoProduto.requestFocus();
        } else {
            buscarInternos("SELECT * FROM ITENS_INVENTARIO_NUTRI "
                    + "INNER JOIN PRODUTOS_NUTRI "
                    + "ON ITENS_INVENTARIO_NUTRI.IdProd=PRODUTOS_NUTRI.IdProd "
                    + "WHERE DescricaoProd LIKE'%" + jPesqDescricaoProduto.getText() + "%' AND IdLanc='" + jIdLanc.getText() + "'");
        }
    }//GEN-LAST:event_jBtPesqNomeActionPerformed

    private void jTabelaPesqProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaPesqProdutosMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String descricaoProduto = "" + jTabelaPesqProdutos.getValueAt(jTabelaPesqProdutos.getSelectedRow(), 1);
            jPesqDescricaoProduto.setText(descricaoProduto);
        }
    }//GEN-LAST:event_jTabelaPesqProdutosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtEnviar;
    private javax.swing.JButton jBtPesqNome;
    private javax.swing.JButton jBtSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jPesqDescricaoProduto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTabelaPesqProdutos;
    // End of variables declaration//GEN-END:variables

//Preencher tabela com todos os VISITANTES
    public void buscarInternos(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "     Descrição do Produto ", " Qtde."};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdProd"), conecta.rs.getString("DescricaoProd"), conecta.rs.getInt("QtdItem")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPesqProdutos.setModel(modelo);
        jTabelaPesqProdutos.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaPesqProdutos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPesqProdutos.getColumnModel().getColumn(1).setPreferredWidth(280);
        jTabelaPesqProdutos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPesqProdutos.getColumnModel().getColumn(2).setPreferredWidth(60);
        jTabelaPesqProdutos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPesqProdutos.getTableHeader().setReorderingAllowed(false);
        jTabelaPesqProdutos.setAutoResizeMode(jTabelaPesqProdutos.AUTO_RESIZE_OFF);
        jTabelaPesqProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conecta.desconecta();
    }
}
