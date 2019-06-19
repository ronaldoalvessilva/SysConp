/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.ModeloTabela;
import static gestor.Visao.TelaRegistroLivroResenhaInterno.jAutor;
import static gestor.Visao.TelaRegistroLivroResenhaInterno.jIdLivro;
import static gestor.Visao.TelaRegistroLivroResenhaInterno.jNomeLivroRevista;
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
public class TelaPesqLivroAcervoResenha extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    int flag;
    String statusProd = "Ativo";
    String tipoAcervo;
    String idInt;
    String nomeProduto;

    /**
     * Creates new form TelaPesqProdutoFarmacia
     */
    public TelaPesqLivroAcervoResenha() {
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPesqDescricaoProdutos = new javax.swing.JTextField();
        jBtPesqDescricaoProd = new javax.swing.JButton();
        jCheckBoxPesqTodosProd = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaLivros = new javax.swing.JTable();
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
        setTitle("...::: Listagem de Produtos {FA} :::...");

        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 255));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Descrição:");

        jPesqDescricaoProdutos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqDescricaoProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqDescricaoProd.setContentAreaFilled(false);
        jBtPesqDescricaoProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqDescricaoProdActionPerformed(evt);
            }
        });

        jCheckBoxPesqTodosProd.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxPesqTodosProd.setText("Todos");
        jCheckBoxPesqTodosProd.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxPesqTodosProdItemStateChanged(evt);
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
                .addComponent(jPesqDescricaoProdutos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtPesqDescricaoProd, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBoxPesqTodosProd)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jCheckBoxPesqTodosProd)
                    .addComponent(jBtPesqDescricaoProd)
                    .addComponent(jPesqDescricaoProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaLivros.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaLivros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição do Livro", "Autor"
            }
        ));
        jTabelaLivros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaLivrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaLivros);
        if (jTabelaLivros.getColumnModel().getColumnCount() > 0) {
            jTabelaLivros.getColumnModel().getColumn(0).setMinWidth(60);
            jTabelaLivros.getColumnModel().getColumn(0).setMaxWidth(60);
            jTabelaLivros.getColumnModel().getColumn(1).setMinWidth(250);
            jTabelaLivros.getColumnModel().getColumn(1).setMaxWidth(250);
            jTabelaLivros.getColumnModel().getColumn(2).setMinWidth(220);
            jTabelaLivros.getColumnModel().getColumn(2).setMaxWidth(220);
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
                        .addGap(0, 341, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtEnviar, jBtSair});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtEnviar)
                    .addComponent(jBtSair))
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("Pesquisas", jPanel2);

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

        setBounds(300, 10, 562, 318);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesqDescricaoProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqDescricaoProdActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (jPesqDescricaoProdutos.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe uma descrição do produto para pesquisa.");
        } else {
            jTabelaLivros.setVisible(true);
            preencherTabelaProdutos("SELECT * FROM LIVROS_REVISTAS_JORNAIS "
                    + "INNER JOIN LOCAL_ACERVO "
                    + "ON LIVROS_REVISTAS_JORNAIS.IdLocal=LOCAL_ACERVO.IdLocal "
                    + "INNER JOIN ITENS_AUTOR_LIVROS "
                    + "ON LIVROS_REVISTAS_JORNAIS.IdLivro=ITENS_AUTOR_LIVROS.IdLivro "
                    + "INNER JOIN AUTORES_LIVROS "
                    + "ON ITENS_AUTOR_LIVROS.IdAutor=AUTORES_LIVROS.IdAutor "
                    + "WHERE TituloLivro LIKE'%" + jPesqDescricaoProdutos.getText() + "%' "
                    + "AND StatusLivro='" + statusProd + "'");
        }
    }//GEN-LAST:event_jBtPesqDescricaoProdActionPerformed

    private void jBtEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtEnviarActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (jPesqDescricaoProdutos.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Selecione o nome do interno e clique no botão ENVIAR");
        } else {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM LIVROS_REVISTAS_JORNAIS "
                        + "INNER JOIN ITENS_AUTOR_LIVROS "
                        + "ON LIVROS_REVISTAS_JORNAIS.IdLivro=ITENS_AUTOR_LIVROS.IdLivro "
                        + "INNER JOIN AUTORES_LIVROS "
                        + "ON ITENS_AUTOR_LIVROS.IdAutor=AUTORES_LIVROS.IdAutor "
                        + "WHERE LIVROS_REVISTAS_JORNAIS.IdLivro='" + idInt + "' "
                        + "AND LIVROS_REVISTAS_JORNAIS.TituloLivro='" + jPesqDescricaoProdutos.getText() + "'");
                conecta.rs.first();
                jIdLivro.setText(String.valueOf(conecta.rs.getInt("IdLivro")));
                jNomeLivroRevista.setText(conecta.rs.getString("TituloLivro"));
                jAutor.setText(conecta.rs.getString("NomeAutor"));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "Houve um erro inesperado, informe essa mensagem ao Administrador.\nERRO: " + e);
            }
            conecta.desconecta();
            dispose();
        }
    }//GEN-LAST:event_jBtEnviarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jTabelaLivrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaLivrosMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            nomeProduto = "" + jTabelaLivros.getValueAt(jTabelaLivros.getSelectedRow(), 1);
            jPesqDescricaoProdutos.setText(nomeProduto);
            idInt = "" + jTabelaLivros.getValueAt(jTabelaLivros.getSelectedRow(), 0);
        }
    }//GEN-LAST:event_jTabelaLivrosMouseClicked

    private void jCheckBoxPesqTodosProdItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxPesqTodosProdItemStateChanged
        // TODO add your handling code here:
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherTabelaProdutos("SELECT * FROM LIVROS_REVISTAS_JORNAIS "
                    + "INNER JOIN LOCAL_ACERVO "
                    + "ON LIVROS_REVISTAS_JORNAIS.IdLocal=LOCAL_ACERVO.IdLocal "
                    + "INNER JOIN ITENS_AUTOR_LIVROS "
                    + "ON LIVROS_REVISTAS_JORNAIS.IdLivro=ITENS_AUTOR_LIVROS.IdLivro "
                    + "INNER JOIN AUTORES_LIVROS "
                    + "ON ITENS_AUTOR_LIVROS.IdAutor=AUTORES_LIVROS.IdAutor "
                    + "WHERE StatusLocal='" + statusProd + "'");
        } else {
            limparTabela();
        }
    }//GEN-LAST:event_jCheckBoxPesqTodosProdItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtEnviar;
    private javax.swing.JButton jBtPesqDescricaoProd;
    private javax.swing.JButton jBtSair;
    private javax.swing.JCheckBox jCheckBoxPesqTodosProd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jPesqDescricaoProdutos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTabelaLivros;
    // End of variables declaration//GEN-END:variables

    // Método de pesquisa pela Matricula
    public void preencherTabelaProdutos(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", " Descrição Livro", "Autor"};
        conecta.abrirConexao();
        conecta.executaSQL(sql);
        try {
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdLivro"), conecta.rs.getString("TituloLivro"), conecta.rs.getString("NomeAutor")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Dados não encontrado, use o botão TODOS \nPara pesquisar TODOS OS REGISTROS");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaLivros.setModel(modelo);
        jTabelaLivros.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaLivros.getColumnModel().getColumn(0).setResizable(false);
        jTabelaLivros.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTabelaLivros.getColumnModel().getColumn(1).setResizable(false);
        jTabelaLivros.getColumnModel().getColumn(2).setPreferredWidth(220);
        jTabelaLivros.getColumnModel().getColumn(2).setResizable(false);
        jTabelaLivros.getTableHeader().setReorderingAllowed(false);
        jTabelaLivros.setAutoResizeMode(jTabelaLivros.AUTO_RESIZE_OFF);
        jTabelaLivros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharTabelaTodas();
        conecta.desconecta();
    }

    public void limparTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", " Descrição Livro", "Autor"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaLivros.setModel(modelo);
        jTabelaLivros.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaLivros.getColumnModel().getColumn(0).setResizable(false);
        jTabelaLivros.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTabelaLivros.getColumnModel().getColumn(1).setResizable(false);
        jTabelaLivros.getColumnModel().getColumn(2).setPreferredWidth(220);
        jTabelaLivros.getColumnModel().getColumn(2).setResizable(false);
        jTabelaLivros.getTableHeader().setReorderingAllowed(false);
        jTabelaLivros.setAutoResizeMode(jTabelaLivros.AUTO_RESIZE_OFF);
        jTabelaLivros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharTabelaTodas() {
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        //
        jTabelaLivros.getColumnModel().getColumn(0).setCellRenderer(centralizado);
    }
}