/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Dao.ConexaoBancoDados;
import Utilitarios.ModeloTabela;
import static gestor.Visao.TelaListaPassagemInternos.jIdEmp;
import static gestor.Visao.TelaListaPassagemInternos.jRazaoSocial;
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
public class TelaBuscarEmpresaLabor extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    String statusEmp = "Ativa";
    int flag;
    String dataCadastro;

    /**
     * Creates new form TelaBuscarEmpresaLabor
     */
    public TelaBuscarEmpresaLabor() {
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
        jPesqNomeEmpresa = new javax.swing.JTextField();
        jBtPesqNomeEmpresa = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaEmpresas = new javax.swing.JTable();
        jBtEnviar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Pesquisa de Empresas Laborativa {TO} :::...");

        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 255));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Empresa:");

        jPesqNomeEmpresa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqNomeEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqNomeEmpresa.setContentAreaFilled(false);
        jBtPesqNomeEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqNomeEmpresaActionPerformed(evt);
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
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPesqNomeEmpresa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtPesqNomeEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtPesqNomeEmpresa)
                    .addComponent(jPesqNomeEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jCheckBox1))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jTabelaEmpresas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaEmpresas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Código", "Nome da Empresa", "Data Cadastro"
            }
        ));
        jScrollPane1.setViewportView(jTabelaEmpresas);
        if (jTabelaEmpresas.getColumnModel().getColumnCount() > 0) {
            jTabelaEmpresas.getColumnModel().getColumn(0).setMinWidth(60);
            jTabelaEmpresas.getColumnModel().getColumn(0).setMaxWidth(60);
            jTabelaEmpresas.getColumnModel().getColumn(1).setMinWidth(300);
            jTabelaEmpresas.getColumnModel().getColumn(1).setMaxWidth(300);
            jTabelaEmpresas.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaEmpresas.getColumnModel().getColumn(2).setMaxWidth(80);
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
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBtEnviar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSair)
                        .addGap(0, 274, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(300, 10, 483, 261);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesqNomeEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNomeEmpresaActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (jPesqNomeEmpresa.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o nome da empresa para pesquis.");
        } else {           
            buscarEmpresas("SELECT * FROM EMPRESALAB "
                    + "WHERE RazaoSocial LIKE'" + jPesqNomeEmpresa.getText() + "%' "
                    + "AND StatusEmp='" + statusEmp + "'");
        }
    }//GEN-LAST:event_jBtPesqNomeEmpresaActionPerformed

    private void jBtEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtEnviarActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String nomeEmpresa = "" + jTabelaEmpresas.getValueAt(jTabelaEmpresas.getSelectedRow(), 1);
            jPesqNomeEmpresa.setText(nomeEmpresa);
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM EMPRESALAB WHERE RazaoSocial='" + jPesqNomeEmpresa.getText() + "' AND StatusEmp='" + statusEmp + "'");
                conecta.rs.first();
                jIdEmp.setText(conecta.rs.getString("IdEmp"));
                jRazaoSocial.setText(conecta.rs.getString("RazaoSocial")); // Coluna 1                                                                      
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

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.buscarEmpresas("SELECT * FROM EMPRESALAB WHERE StatusEmp='" + statusEmp + "'");
        } else {
            limparTabela();
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtEnviar;
    private javax.swing.JButton jBtPesqNomeEmpresa;
    private javax.swing.JButton jBtSair;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jPesqNomeEmpresa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTabelaEmpresas;
    // End of variables declaration//GEN-END:variables

    public void buscarEmpresas(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome da Empresa", "Data Cadastro"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            // Formatar a data Entrada
            dataCadastro = conecta.rs.getString("DataCad");
            String dia = dataCadastro.substring(8, 10);
            String mes = dataCadastro.substring(5, 7);
            String ano = dataCadastro.substring(0, 4);
            dataCadastro = dia + "/" + mes + "/" + ano;
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdEmp"), conecta.rs.getString("RazaoSocial"), dataCadastro});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaEmpresas.setModel(modelo);
        jTabelaEmpresas.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaEmpresas.getColumnModel().getColumn(0).setResizable(false);
        jTabelaEmpresas.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTabelaEmpresas.getColumnModel().getColumn(1).setResizable(false);
        jTabelaEmpresas.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaEmpresas.getColumnModel().getColumn(2).setResizable(false);
        jTabelaEmpresas.getTableHeader().setReorderingAllowed(false);
        jTabelaEmpresas.setAutoResizeMode(jTabelaEmpresas.AUTO_RESIZE_OFF);
        jTabelaEmpresas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabela();
        conecta.desconecta();
    }

    public void limparTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome da Empresa", "Data Cadastro"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaEmpresas.setModel(modelo);
        jTabelaEmpresas.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaEmpresas.getColumnModel().getColumn(0).setResizable(false);
        jTabelaEmpresas.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTabelaEmpresas.getColumnModel().getColumn(1).setResizable(false);
        jTabelaEmpresas.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaEmpresas.getColumnModel().getColumn(2).setResizable(false);
        jTabelaEmpresas.getTableHeader().setReorderingAllowed(false);
        jTabelaEmpresas.setAutoResizeMode(jTabelaEmpresas.AUTO_RESIZE_OFF);
        jTabelaEmpresas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
        jTabelaEmpresas.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaEmpresas.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }
}
