/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import Utilitarios.ModeloTabela;
import gestor.Dao.*;
import gestor.Modelo.DadosPenaisCrc;
import gestor.Modelo.ProntuarioCrc;
import static gestor.Visao.TelaDepositoBancario.jDataEntrada;
import static gestor.Visao.TelaDepositoBancario.jFotoInternoDepFin;
import static gestor.Visao.TelaDepositoBancario.jIdInternoDepFin;
import static gestor.Visao.TelaDepositoBancario.jNomeInternoDepFin;
import static gestor.Visao.TelaDepositoBancario.jSituacao;
import static gestor.Visao.TelaLiberadoresFinanceiro.jIdUsuario;
import static gestor.Visao.TelaLiberadoresFinanceiro.jNomeUsuario;
import java.awt.Color;
import java.awt.Font;
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
 * @author Ronaldo
 */
public class TelaPesqLiberadores extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ProntuarioCrc objProCrc = new ProntuarioCrc();
    DadosPenaisCrc objDadosPena = new DadosPenaisCrc();
    int flag;
    String caminho;
    String nomeInterno;
    String dataCadastro;
    String dataEntrada;
    String idInt;

    /**
     * Creates new form TelaPesquisaEntradaInternos
     */
    public TelaPesqLiberadores() {
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
        jPanel3 = new javax.swing.JPanel();
        jPesqNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jBtNome = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaUsuarios = new javax.swing.JTable();
        jBtSair = new javax.swing.JButton();
        jBtEnviar = new javax.swing.JButton();

        setClosable(true);
        setTitle("...::: Pesquisa de Internos");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisar Pronturários de Internos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 0, 255)));

        jPesqNome.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Nome:");

        jBtNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtNome.setToolTipText("Pesquisa Por Nome");
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPesqNome, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(jPesqNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtNome)
                    .addComponent(jCheckBox1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaUsuarios.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Código", "Nome do Usuário", "Departamento", "Função"
            }
        ));
        jTabelaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaUsuarios);
        if (jTabelaUsuarios.getColumnModel().getColumnCount() > 0) {
            jTabelaUsuarios.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaUsuarios.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaUsuarios.getColumnModel().getColumn(1).setMinWidth(300);
            jTabelaUsuarios.getColumnModel().getColumn(1).setMaxWidth(300);
            jTabelaUsuarios.getColumnModel().getColumn(2).setMinWidth(250);
            jTabelaUsuarios.getColumnModel().getColumn(2).setMaxWidth(250);
            jTabelaUsuarios.getColumnModel().getColumn(3).setMinWidth(250);
            jTabelaUsuarios.getColumnModel().getColumn(3).setMaxWidth(250);
        }

        jBtSair.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtSair.setForeground(new java.awt.Color(255, 0, 0));
        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSair.setText("Sair");
        jBtSair.setToolTipText("Sair da Pesquisa");
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        jBtEnviar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtEnviar.setForeground(new java.awt.Color(0, 0, 255));
        jBtEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/accept.png"))); // NOI18N
        jBtEnviar.setText("Enviar");
        jBtEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtEnviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBtEnviar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSair)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtEnviar, jBtSair});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtSair)
                    .addComponent(jBtEnviar))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtEnviar, jBtSair});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(200, 10, 552, 274);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNomeActionPerformed

        flag = 1;
        if (jPesqNome.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe NOME para pesquisa!!!");
            jPesqNome.requestFocus();
        } else {
            preencherTabelaNome("SELECT * FROM USUARIOS "
                    + "WHERE USUARIOS.NomeUsuario LIKE'%" + jPesqNome.getText() + "%'");
        }
    }//GEN-LAST:event_jBtNomeActionPerformed

    private void jTabelaUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaUsuariosMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            nomeInterno = "" + jTabelaUsuarios.getValueAt(jTabelaUsuarios.getSelectedRow(), 1);
            jPesqNome.setText(nomeInterno);
            idInt = "" + jTabelaUsuarios.getValueAt(jTabelaUsuarios.getSelectedRow(), 0);
        }
    }//GEN-LAST:event_jTabelaUsuariosMouseClicked

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtEnviarActionPerformed
        // TODO add your handling code here:
        if (jPesqNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Selecione o nome do interno e clique no botão ENVIAR");
        } else {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM USUARIOS "
                        + "WHERE USUARIOS.NomeUsuario='" + nomeInterno + "' "
                        + "AND USUARIOS.IdUsuario='" + idInt + "'");
                conecta.rs.first();
                jIdUsuario.setText(String.valueOf(conecta.rs.getInt("IdUsuario")));
                jNomeUsuario.setText(conecta.rs.getString("NomeUsuario"));
                conecta.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa do usuário." + e);
            }
            dispose();
        }
    }//GEN-LAST:event_jBtEnviarActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherTodosInternos("SELECT * FROM USUARIOS ORDER BY NomeUsuario");
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jPesqNome;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabelaUsuarios;
    // End of variables declaration//GEN-END:variables
  // Método de pesquisa pela Descrição

    public void preencherTabelaNome(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome do Usuário", "Departamento", "Função"};
        conecta.abrirConexao();
        conecta.executaSQL(sql);
        try {
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdUsuario"), conecta.rs.getString("NomeUsuario"), conecta.rs.getString("NomeDepartamento"), conecta.rs.getString("NomeCargo")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Dados não encontrado, use o botão TODOS \nPara pesquisar TODOS OS REGISTROS");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaUsuarios.setModel(modelo);
        jTabelaUsuarios.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaUsuarios.getColumnModel().getColumn(0).setResizable(false);
        jTabelaUsuarios.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTabelaUsuarios.getColumnModel().getColumn(1).setResizable(false);
        jTabelaUsuarios.getColumnModel().getColumn(2).setPreferredWidth(250);
        jTabelaUsuarios.getColumnModel().getColumn(2).setResizable(false);
        jTabelaUsuarios.getColumnModel().getColumn(3).setPreferredWidth(250);
        jTabelaUsuarios.getColumnModel().getColumn(3).setResizable(false);
        jTabelaUsuarios.getTableHeader().setReorderingAllowed(false);
        jTabelaUsuarios.setAutoResizeMode(jTabelaUsuarios.AUTO_RESIZE_OFF);
        jTabelaUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabela();
        conecta.desconecta();
    }

    //Preencher tabela com todos os INTERNOS
    public void preencherTodosInternos(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome do Usuário", "Departamento", "Função"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdUsuario"), conecta.rs.getString("NomeUsuario"), conecta.rs.getString("NomeDepartamento"), conecta.rs.getString("NomeCargo")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaUsuarios.setModel(modelo);
        jTabelaUsuarios.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaUsuarios.getColumnModel().getColumn(0).setResizable(false);
        jTabelaUsuarios.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTabelaUsuarios.getColumnModel().getColumn(1).setResizable(false);
        jTabelaUsuarios.getColumnModel().getColumn(2).setPreferredWidth(250);
        jTabelaUsuarios.getColumnModel().getColumn(2).setResizable(false);
        jTabelaUsuarios.getColumnModel().getColumn(3).setPreferredWidth(250);
        jTabelaUsuarios.getColumnModel().getColumn(3).setResizable(false);
        jTabelaUsuarios.getTableHeader().setReorderingAllowed(false);
        jTabelaUsuarios.setAutoResizeMode(jTabelaUsuarios.AUTO_RESIZE_OFF);
        jTabelaUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabela();
        conecta.desconecta();
    }

    public void limparTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome do Usuário", "Departamento", "Função"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaUsuarios.setModel(modelo);
        jTabelaUsuarios.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaUsuarios.getColumnModel().getColumn(0).setResizable(false);
        jTabelaUsuarios.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTabelaUsuarios.getColumnModel().getColumn(1).setResizable(false);
        jTabelaUsuarios.getColumnModel().getColumn(2).setPreferredWidth(250);
        jTabelaUsuarios.getColumnModel().getColumn(2).setResizable(false);
        jTabelaUsuarios.getColumnModel().getColumn(3).setPreferredWidth(250);
        jTabelaUsuarios.getColumnModel().getColumn(3).setResizable(false);
        jTabelaUsuarios.getTableHeader().setReorderingAllowed(false);
        jTabelaUsuarios.setAutoResizeMode(jTabelaUsuarios.AUTO_RESIZE_OFF);
        jTabelaUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
        jTabelaUsuarios.getColumnModel().getColumn(0).setCellRenderer(centralizado);        
    }
}
