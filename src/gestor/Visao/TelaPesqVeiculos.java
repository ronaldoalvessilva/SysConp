/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import Utilitarios.ModeloTabela;
import gestor.Dao.*;
import static gestor.Visao.TelaEntradaSaidaVeiculosTerceiros.jFotoVeiculoDiv;
import static gestor.Visao.TelaEntradaSaidaVeiculosTerceiros.jIdVeiculo;
import static gestor.Visao.TelaEntradaSaidaVeiculosTerceiros.jMarcaVeiculo;
import static gestor.Visao.TelaEntradaSaidaVeiculosTerceiros.jModeloVeiculo;
import static gestor.Visao.TelaEntradaSaidaVeiculosTerceiros.jPlaca;
import java.awt.Image;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author user
 */
public class TelaPesqVeiculos extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    int flag;
    String caminhoVeiculo;

    /**
     * Creates new form TelaPesqColaborador
     */
    public TelaPesqVeiculos() {
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
        jPesqModeloVeiculo = new javax.swing.JTextField();
        jBtPesqNomeVeiculo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jPlavaVeiculo = new javax.swing.JTextField();
        jBtPlacaVeiculo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaPesqVeiculos = new javax.swing.JTable();
        jBtEnviar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Pesquisa Veiculos - {P1V} :::...");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Listagem de Veiculos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jPesqModeloVeiculo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqNomeVeiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqNomeVeiculo.setToolTipText("Pesquisa por Nome");
        jBtPesqNomeVeiculo.setContentAreaFilled(false);
        jBtPesqNomeVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqNomeVeiculoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Modelo Veiculo:");

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox1.setText("Todos");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Placa Veiculo:");

        jPlavaVeiculo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPlacaVeiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPlacaVeiculo.setContentAreaFilled(false);
        jBtPlacaVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPlacaVeiculoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPlavaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPlacaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPesqModeloVeiculo, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqNomeVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox1)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(jPlavaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPlacaVeiculo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(jPesqModeloVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqNomeVeiculo)
                    .addComponent(jCheckBox1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaPesqVeiculos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaPesqVeiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Código", "Modelo do Veiculo", "Placa"
            }
        ));
        jTabelaPesqVeiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaPesqVeiculosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaPesqVeiculos);
        if (jTabelaPesqVeiculos.getColumnModel().getColumnCount() > 0) {
            jTabelaPesqVeiculos.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaPesqVeiculos.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaPesqVeiculos.getColumnModel().getColumn(1).setMinWidth(300);
            jTabelaPesqVeiculos.getColumnModel().getColumn(1).setMaxWidth(300);
            jTabelaPesqVeiculos.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaPesqVeiculos.getColumnModel().getColumn(2).setMaxWidth(80);
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
                        .addGap(0, 264, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(250, 20, 473, 286);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtEnviarActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String modeloVeiculo = "" + jTabelaPesqVeiculos.getValueAt(jTabelaPesqVeiculos.getSelectedRow(), 1);
            jPesqModeloVeiculo.setText(modeloVeiculo);
            String idVeiculo = "" + jTabelaPesqVeiculos.getValueAt(jTabelaPesqVeiculos.getSelectedRow(), 0);
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM VEICULOS "
                        + "WHERE ModeloVeiculo='" + modeloVeiculo + "' "
                        + "AND IdVeiculo='" + idVeiculo + "'");
                conecta.rs.first();
                // Tabela Funcionarios
                jIdVeiculo.setText(String.valueOf(conecta.rs.getInt("IdVeiculo")));
                jModeloVeiculo.setText(conecta.rs.getString("ModeloVeiculo"));
                jPlaca.setText(conecta.rs.getString("PlacaVeiculo"));
                jMarcaVeiculo.setText(conecta.rs.getString("MarcaVeiculo"));
                //
                caminhoVeiculo = conecta.rs.getString("FotoFrente");
                if (caminhoVeiculo != null) {
                    javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminhoVeiculo);
                    jFotoVeiculoDiv.setIcon(i);
                    jFotoVeiculoDiv.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoVeiculoDiv.getWidth(), jFotoVeiculoDiv.getHeight(), Image.SCALE_DEFAULT)));
                }
                // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                byte[] img2Bytes = ((byte[]) conecta.rs.getBytes("ImagemFrenteVE"));
                if (img2Bytes != null) {
                    ImageIcon pic2 = null;
                    pic2 = new ImageIcon(img2Bytes);
                    Image scaled2 = pic2.getImage().getScaledInstance(jFotoVeiculoDiv.getWidth(), jFotoVeiculoDiv.getHeight(), Image.SCALE_DEFAULT);
                    ImageIcon icon2 = new ImageIcon(scaled2);
                    jFotoVeiculoDiv.setIcon(icon2);
                }
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

    private void jBtPesqNomeVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNomeVeiculoActionPerformed
        // TODO add your handling code here:
        // Pesquisar colaborador por nome           
        flag = 1;
        if (jPesqModeloVeiculo.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um nome ou parte do nome para pesquisar.");
            jPesqModeloVeiculo.requestFocus();
        } else {
            buscarVeiculos("SELECT * FROM VEICULOS WHERE ModeloVeiculo LIKE'%" + jPesqModeloVeiculo.getText() + "%'");
        }
    }//GEN-LAST:event_jBtPesqNomeVeiculoActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.buscarVeiculos("SELECT * FROM VEICULOS ORDER BY ModeloVeiculo");
        } else {
            limparTabela();
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jBtPlacaVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPlacaVeiculoActionPerformed
        // TODO add your handling code here:
        if (jPlavaVeiculo.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um nome ou parte do nome para pesquisar.");
            jPesqModeloVeiculo.requestFocus();
        } else {
            jTabelaPesqVeiculos.setVisible(true);
            buscarVeiculos("SELECT * FROM VEICULOS WHERE PlacaVeiculo LIKE'%" + jPlavaVeiculo.getText() + "%'");
        }
    }//GEN-LAST:event_jBtPlacaVeiculoActionPerformed

    private void jTabelaPesqVeiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaPesqVeiculosMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1 && evt.getClickCount() == 1) {
            String modeloVeiculo = "" + jTabelaPesqVeiculos.getValueAt(jTabelaPesqVeiculos.getSelectedRow(), 1);
            jPesqModeloVeiculo.setText(modeloVeiculo);
        }
    }//GEN-LAST:event_jTabelaPesqVeiculosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtEnviar;
    private javax.swing.JButton jBtPesqNomeVeiculo;
    private javax.swing.JButton jBtPlacaVeiculo;
    private javax.swing.JButton jBtSair;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jPesqModeloVeiculo;
    private javax.swing.JTextField jPlavaVeiculo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTabelaPesqVeiculos;
    // End of variables declaration//GEN-END:variables

//Preencher tabela com todos os COLABORADORES
    public void buscarVeiculos(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Modelo do Veiculo", "Placa"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdVeiculo"), conecta.rs.getString("ModeloVeiculo"), conecta.rs.getString("PlacaVeiculo")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPesqVeiculos.setModel(modelo);
        jTabelaPesqVeiculos.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaPesqVeiculos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPesqVeiculos.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTabelaPesqVeiculos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPesqVeiculos.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaPesqVeiculos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPesqVeiculos.getTableHeader().setReorderingAllowed(false);
        jTabelaPesqVeiculos.setAutoResizeMode(jTabelaPesqVeiculos.AUTO_RESIZE_OFF);
        jTabelaPesqVeiculos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabela();
        conecta.desconecta();
    }

    public void limparTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Modelo do Veiculo", "Placa"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPesqVeiculos.setModel(modelo);
        jTabelaPesqVeiculos.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaPesqVeiculos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPesqVeiculos.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTabelaPesqVeiculos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPesqVeiculos.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaPesqVeiculos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPesqVeiculos.getTableHeader().setReorderingAllowed(false);
        jTabelaPesqVeiculos.setAutoResizeMode(jTabelaPesqVeiculos.AUTO_RESIZE_OFF);
        jTabelaPesqVeiculos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
        jTabelaPesqVeiculos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaPesqVeiculos.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }
}
