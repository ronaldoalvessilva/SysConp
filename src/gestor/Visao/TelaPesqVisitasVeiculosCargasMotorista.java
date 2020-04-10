/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import Utilitarios.ModeloTabela;
import gestor.Dao.*;
import static gestor.Visao.TelaEntradaSaidaVeiculosCargas.FotoMotoristaCarga;
import static gestor.Visao.TelaEntradaSaidaVeiculosCargas.jIdMotorista;
import static gestor.Visao.TelaEntradaSaidaVeiculosCargas.jNomeMotorista;
import static gestor.Visao.TelaEntradaSaidaVeiculosCargas.jRGMotorista;
import static gestor.Visao.TelaEntradaSaidaVeiculosCargas.jCPFMotorista;
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
public class TelaPesqVisitasVeiculosCargasMotorista extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    int flag;
    String caminho;

    /**
     * Creates new form TelaPesqColaborador
     */
    public TelaPesqVisitasVeiculosCargasMotorista() {
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
        jPesqNomeVisita = new javax.swing.JTextField();
        jBtPesqNome = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaPesqVisitasDiversas = new javax.swing.JTable();
        jBtEnviar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Pesquisa Visitas Diversas - {P1V} :::...");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Listagem de Visitas Diversas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jPesqNomeVisita.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqNome.setToolTipText("Pesquisa por Nome");
        jBtPesqNome.setContentAreaFilled(false);
        jBtPesqNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqNomeActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Nome Visita:");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPesqNomeVisita)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtPesqNome, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(jPesqNomeVisita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqNome)
                    .addComponent(jCheckBox1))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jTabelaPesqVisitasDiversas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaPesqVisitasDiversas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Código", "Nome da Visita"
            }
        ));
        jTabelaPesqVisitasDiversas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaPesqVisitasDiversasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaPesqVisitasDiversas);
        if (jTabelaPesqVisitasDiversas.getColumnModel().getColumnCount() > 0) {
            jTabelaPesqVisitasDiversas.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaPesqVisitasDiversas.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaPesqVisitasDiversas.getColumnModel().getColumn(1).setMinWidth(400);
            jTabelaPesqVisitasDiversas.getColumnModel().getColumn(1).setMaxWidth(400);
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBtEnviar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSair))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(250, 20, 512, 286);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtEnviarActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String nomeVisita = "" + jTabelaPesqVisitasDiversas.getValueAt(jTabelaPesqVisitasDiversas.getSelectedRow(), 1);
            jPesqNomeVisita.setText(nomeVisita);
            String idVisita = "" + jTabelaPesqVisitasDiversas.getValueAt(jTabelaPesqVisitasDiversas.getSelectedRow(), 0);
            jIdMotorista.setText(idVisita);
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM VISITASDIVERSAS "
                        + "WHERE NomeVisita='" + jPesqNomeVisita.getText() + "' "
                        + "AND IdVisita='" + idVisita + "'");
                conecta.rs.first();
                // Tabela Funcionarios
                jIdMotorista.setText(String.valueOf(conecta.rs.getInt("IdVisita")));
                jNomeMotorista.setText(conecta.rs.getString("NomeVisita"));
                jRGMotorista.setText(conecta.rs.getString("RgVisita"));
                jCPFMotorista.setText(conecta.rs.getString("CpfVisita"));
                caminho = conecta.rs.getString("FotoVisita");
                if (caminho != null) {
                    javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                    FotoMotoristaCarga.setIcon(i);
                    FotoMotoristaCarga.setIcon(new ImageIcon(i.getImage().getScaledInstance(FotoMotoristaCarga.getWidth(), FotoMotoristaCarga.getHeight(), Image.SCALE_DEFAULT)));
                }
                // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrenteVD"));
                if (imgBytes != null) {
                    ImageIcon pic = null;
                    pic = new ImageIcon(imgBytes);
                    Image scaled = pic.getImage().getScaledInstance(FotoMotoristaCarga.getWidth(), FotoMotoristaCarga.getHeight(), Image.SCALE_DEFAULT);
                    ImageIcon icon = new ImageIcon(scaled);
                    FotoMotoristaCarga.setIcon(icon);
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

    private void jBtPesqNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNomeActionPerformed
        // TODO add your handling code here:
        // Pesquisar colaborador por nome           
        flag = 1;
        if (jPesqNomeVisita.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um nome ou parte do nome para pesquisar.");
            jPesqNomeVisita.requestFocus();
        } else {
            jTabelaPesqVisitasDiversas.setVisible(true);
            buscarVisitas("SELECT * FROM VISITASDIVERSAS "
                    + "WHERE NomeVisita LIKE'%" + jPesqNomeVisita.getText() + "%'");
        }
    }//GEN-LAST:event_jBtPesqNomeActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.buscarVisitas("SELECT * FROM VISITASDIVERSAS");
        } else {
            limparTabela();
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jTabelaPesqVisitasDiversasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaPesqVisitasDiversasMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1 && evt.getClickCount() == 1) {
            String nomeVisita = "" + jTabelaPesqVisitasDiversas.getValueAt(jTabelaPesqVisitasDiversas.getSelectedRow(), 1);
            jPesqNomeVisita.setText(nomeVisita);
            String idVisita = "" + jTabelaPesqVisitasDiversas.getValueAt(jTabelaPesqVisitasDiversas.getSelectedRow(), 0);
            jIdMotorista.setText(idVisita);
        }
    }//GEN-LAST:event_jTabelaPesqVisitasDiversasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtEnviar;
    private javax.swing.JButton jBtPesqNome;
    private javax.swing.JButton jBtSair;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jPesqNomeVisita;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTabelaPesqVisitasDiversas;
    // End of variables declaration//GEN-END:variables

//Preencher tabela com todos os COLABORADORES
    public void buscarVisitas(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome da Visita"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdVisita"), conecta.rs.getString("NomeVisita")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPesqVisitasDiversas.setModel(modelo);
        jTabelaPesqVisitasDiversas.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaPesqVisitasDiversas.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPesqVisitasDiversas.getColumnModel().getColumn(1).setPreferredWidth(400);
        jTabelaPesqVisitasDiversas.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPesqVisitasDiversas.getTableHeader().setReorderingAllowed(false);
        jTabelaPesqVisitasDiversas.setAutoResizeMode(jTabelaPesqVisitasDiversas.AUTO_RESIZE_OFF);
        jTabelaPesqVisitasDiversas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabela();
        conecta.desconecta();
    }

    public void alinharCamposTabela() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaPesqVisitasDiversas.getColumnModel().getColumn(0).setCellRenderer(centralizado);
    }

    public void limparTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome da Visita"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPesqVisitasDiversas.setModel(modelo);
        jTabelaPesqVisitasDiversas.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaPesqVisitasDiversas.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPesqVisitasDiversas.getColumnModel().getColumn(1).setPreferredWidth(400);
        jTabelaPesqVisitasDiversas.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPesqVisitasDiversas.getTableHeader().setReorderingAllowed(false);
        jTabelaPesqVisitasDiversas.setAutoResizeMode(jTabelaPesqVisitasDiversas.AUTO_RESIZE_OFF);
        jTabelaPesqVisitasDiversas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }
}
