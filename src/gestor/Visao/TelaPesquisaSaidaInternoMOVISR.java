/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import Utilitarios.ModeloTabela;
import gestor.Dao.*;
import static gestor.Visao.TelaProrrogracaoSaidaTemporariaDomiciliar.jComboBoxTipoSaida;
import static gestor.Visao.TelaProrrogracaoSaidaTemporariaDomiciliar.jDataSaida;
import static gestor.Visao.TelaProrrogracaoSaidaTemporariaDomiciliar.jIdInternoPro;
import static gestor.Visao.TelaProrrogracaoSaidaTemporariaDomiciliar.jIdSaida;
import static gestor.Visao.TelaProrrogracaoSaidaTemporariaDomiciliar.jNomeInternoPro;
import static gestor.Visao.TelaProrrogracaoSaidaTemporariaDomiciliar.jSituacaoPro;
import static gestor.Visao.TelaProrrogracaoSaidaTemporariaDomiciliar.pID_SAIDA_ORIGEM;
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
public class TelaPesquisaSaidaInternoMOVISR extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    int flag;
    String nomeInterno;
    String pDATA_PREVISAO_RETORNO;
    String pDATA_SAIDA;
    String idInt;
    String pREGISTRO;

    /**
     * Creates new form TelaPesquisaEntradaInternos
     */
    public TelaPesquisaSaidaInternoMOVISR() {
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
        jPesqMatricula = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jBtNome = new javax.swing.JButton();
        jBtMatricula = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaInterno = new javax.swing.JTable();
        jBtSair = new javax.swing.JButton();
        jBtEnviar = new javax.swing.JButton();

        setClosable(true);
        setTitle("...::: Pesquisa de Internos Saída :::...");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPesqNome.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jPesqMatricula.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Pesquisa Por Nome:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Pesquisa por Matricula:");

        jBtNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtNome.setToolTipText("Pesquisa Por Nome");
        jBtNome.setContentAreaFilled(false);
        jBtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNomeActionPerformed(evt);
            }
        });

        jBtMatricula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtMatricula.setToolTipText("Pesquisa Por Matricula");
        jBtMatricula.setContentAreaFilled(false);
        jBtMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtMatriculaActionPerformed(evt);
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
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPesqMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBox1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPesqNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtNome)
                    .addComponent(jPesqNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(3, 3, 3)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(jPesqMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtMatricula)
                    .addComponent(jCheckBox1))
                .addGap(4, 4, 4))
        );

        jTabelaInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaInterno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Registro", "Código", "Nome do Interno", "Data Saída", "Destino Saída", "Origem"
            }
        ));
        jTabelaInterno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaInternoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaInterno);
        if (jTabelaInterno.getColumnModel().getColumnCount() > 0) {
            jTabelaInterno.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaInterno.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaInterno.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaInterno.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaInterno.getColumnModel().getColumn(2).setMinWidth(350);
            jTabelaInterno.getColumnModel().getColumn(2).setMaxWidth(350);
            jTabelaInterno.getColumnModel().getColumn(3).setMinWidth(80);
            jTabelaInterno.getColumnModel().getColumn(3).setMaxWidth(80);
            jTabelaInterno.getColumnModel().getColumn(4).setMinWidth(200);
            jTabelaInterno.getColumnModel().getColumn(4).setMaxWidth(200);
            jTabelaInterno.getColumnModel().getColumn(5).setMinWidth(70);
            jTabelaInterno.getColumnModel().getColumn(5).setMaxWidth(70);
        }

        jBtSair.setForeground(new java.awt.Color(255, 0, 0));
        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSair.setText("Sair");
        jBtSair.setToolTipText("Sair da Pesquisa");
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        jBtEnviar.setForeground(new java.awt.Color(0, 102, 0));
        jBtEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/accept.png"))); // NOI18N
        jBtEnviar.setText("Confirmar");
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
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBtEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSair)
                        .addGap(0, 350, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtEnviar, jBtSair});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtSair)
                    .addComponent(jBtEnviar))
                .addGap(3, 3, 3))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4))
        );

        setBounds(200, 10, 598, 298);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNomeActionPerformed

        flag = 1;
        if (jPesqNome.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe NOME para pesquisa!!!");
            jPesqNome.requestFocus();
        } else {
            preencherTabelaNome("SELECT ITENSREGSAIDA.IdItem,ITENSREGSAIDA.IdInternoCrc, "
                    + "PRONTUARIOSCRC.NomeInternoCrc,ITENSREGSAIDA.IdSaida, "
                    + "ITENSREGSAIDA.DataSaida,ITENSREGSAIDA.DestinoSaida, "
                    + "ITENSREGSAIDA.IdSaidaTmp "
                    + "FROM ITENSREGSAIDA "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENSREGSAIDA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE PRONTUARIOSCRC.NomeInternoCrc LIKE'%" + jPesqNome.getText() + "%' "
                    + "AND ITENSREGSAIDA.DestinoSaida LIKE'%" + jComboBoxTipoSaida.getSelectedItem() + "%' ");
        }
    }//GEN-LAST:event_jBtNomeActionPerformed

    private void jBtMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtMatriculaActionPerformed

        flag = 1;
        if (jPesqMatricula.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe MATRICULA para pesquisa!!!");
            jPesqMatricula.requestFocus();
        } else {
            buscarInternosMatricula("SELECT ITENSREGSAIDA.IdItem,ITENSREGSAIDA.IdInternoCrc, "
                    + "PRONTUARIOSCRC.NomeInternoCrc,ITENSREGSAIDA.IdSaida, "
                    + "ITENSREGSAIDA.DataSaida,ITENSREGSAIDA.DestinoSaida, "
                    + "ITENSREGSAIDA.IdSaidaTmp "
                    + "FROM ITENSREGSAIDA "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENSREGSAIDA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE MatriculaCrc LIKE'%" + jPesqMatricula.getText() + "%' "
                    + "AND ITENSREGSAIDA.DestinoSaida LIKE'%" + jComboBoxTipoSaida.getSelectedItem() + "%' ");

        }
    }//GEN-LAST:event_jBtMatriculaActionPerformed

    private void jTabelaInternoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaInternoMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            nomeInterno = "" + jTabelaInterno.getValueAt(jTabelaInterno.getSelectedRow(), 2);
            jPesqNome.setText(nomeInterno);
            idInt = "" + jTabelaInterno.getValueAt(jTabelaInterno.getSelectedRow(), 1);
            pREGISTRO = "" + jTabelaInterno.getValueAt(jTabelaInterno.getSelectedRow(), 0);
        }
    }//GEN-LAST:event_jTabelaInternoMouseClicked

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
                conecta.executaSQL("SELECT ITENSREGSAIDA.IdInternoCrc, "
                        + "PRONTUARIOSCRC.NomeInternoCrc,ITENSREGSAIDA.IdSaida, "
                        + "ITENSREGSAIDA.DataSaida,ITENSREGSAIDA.DestinoSaida, "
                        + "ITENSREGSAIDA.IdSaidaTmp "
                        + "FROM ITENSREGSAIDA "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ITENSREGSAIDA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE PRONTUARIOSCRC.NomeInternoCrc='" + nomeInterno + "' "
                        + "AND PRONTUARIOSCRC.IdInternoCrc='" + idInt + "' "
                        + "AND IdItem='" + pREGISTRO + "'");
                conecta.rs.first();
                jIdInternoPro.setText(String.valueOf(conecta.rs.getInt("IdInternoCrc")));
                jNomeInternoPro.setText(conecta.rs.getString("NomeInternoCrc"));
                jSituacaoPro.setText(conecta.rs.getString("DestinoSaida"));
                jIdSaida.setText(conecta.rs.getString("IdSaida"));
                jDataSaida.setDate(conecta.rs.getDate("DataSaida"));
                pID_SAIDA_ORIGEM = conecta.rs.getInt("IdSaidaTmp");
                conecta.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa INTERNO." + e);
            }
            dispose();
        }
    }//GEN-LAST:event_jBtEnviarActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherTodosInternos("SELECT ITENSREGSAIDA.IdItem,ITENSREGSAIDA.IdInternoCrc, "
                    + "PRONTUARIOSCRC.NomeInternoCrc,ITENSREGSAIDA.IdSaida, "
                    + "ITENSREGSAIDA.DataSaida,ITENSREGSAIDA.DestinoSaida, "
                    + "ITENSREGSAIDA.IdSaidaTmp "
                    + "FROM ITENSREGSAIDA "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENSREGSAIDA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE ITENSREGSAIDA.DestinoSaida LIKE'%" + jComboBoxTipoSaida.getSelectedItem() + "%' ");
        } else {
            limparTabela();
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtEnviar;
    private javax.swing.JButton jBtMatricula;
    private javax.swing.JButton jBtNome;
    private javax.swing.JButton jBtSair;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jPesqMatricula;
    private javax.swing.JTextField jPesqNome;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabelaInterno;
    // End of variables declaration//GEN-END:variables
  // Método de pesquisa pela Descrição

    public void preencherTabelaNome(String sql) {
       ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Registro", "Código", "Nome do Interno", "Data Saída", "Destino Saída", "Origem"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                // Formatar a data no formato Brasil
                pDATA_SAIDA = conecta.rs.getString("DataSaida");
                String dia = pDATA_SAIDA.substring(8, 10);
                String mes = pDATA_SAIDA.substring(5, 7);
                String ano = pDATA_SAIDA.substring(0, 4);
                pDATA_SAIDA = dia + "/" + mes + "/" + ano;
                dados.add(new Object[]{conecta.rs.getInt("IdItem"), conecta.rs.getInt("IdInternoCrc"), conecta.rs.getString("NomeInternoCrc"), pDATA_SAIDA, conecta.rs.getString("DestinoSaida"), conecta.rs.getString("IdSaidaTmp")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInterno.setModel(modelo);
        jTabelaInterno.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaInterno.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaInterno.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(2).setPreferredWidth(350);
        jTabelaInterno.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaInterno.getColumnModel().getColumn(3).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(4).setPreferredWidth(200);
        jTabelaInterno.getColumnModel().getColumn(4).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(5).setPreferredWidth(70);
        jTabelaInterno.getColumnModel().getColumn(5).setResizable(false);
        jTabelaInterno.getTableHeader().setReorderingAllowed(false);
        jTabelaInterno.setAutoResizeMode(jTabelaInterno.AUTO_RESIZE_OFF);
        jTabelaInterno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabela();
        conecta.desconecta();
    }

    //Preencher tabela com todos os INTERNOS
    public void preencherTodosInternos(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Registro", "Código", "Nome do Interno", "Data Saída", "Destino Saída", "Origem"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                // Formatar a data no formato Brasil
                pDATA_SAIDA = conecta.rs.getString("DataSaida");
                String dia = pDATA_SAIDA.substring(8, 10);
                String mes = pDATA_SAIDA.substring(5, 7);
                String ano = pDATA_SAIDA.substring(0, 4);
                pDATA_SAIDA = dia + "/" + mes + "/" + ano;
                dados.add(new Object[]{conecta.rs.getInt("IdItem"), conecta.rs.getInt("IdInternoCrc"), conecta.rs.getString("NomeInternoCrc"), pDATA_SAIDA, conecta.rs.getString("DestinoSaida"), conecta.rs.getString("IdSaidaTmp")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInterno.setModel(modelo);
        jTabelaInterno.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaInterno.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaInterno.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(2).setPreferredWidth(350);
        jTabelaInterno.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaInterno.getColumnModel().getColumn(3).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(4).setPreferredWidth(200);
        jTabelaInterno.getColumnModel().getColumn(4).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(5).setPreferredWidth(70);
        jTabelaInterno.getColumnModel().getColumn(5).setResizable(false);
        jTabelaInterno.getTableHeader().setReorderingAllowed(false);
        jTabelaInterno.setAutoResizeMode(jTabelaInterno.AUTO_RESIZE_OFF);
        jTabelaInterno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabela();
        conecta.desconecta();
    }

    public void limparTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Registro", "Código", "Nome do Interno", "Data Saída", "Destino Saída", "Origem"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInterno.setModel(modelo);
        jTabelaInterno.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaInterno.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaInterno.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(2).setPreferredWidth(350);
        jTabelaInterno.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaInterno.getColumnModel().getColumn(3).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(4).setPreferredWidth(200);
        jTabelaInterno.getColumnModel().getColumn(4).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(5).setPreferredWidth(70);
        jTabelaInterno.getColumnModel().getColumn(5).setResizable(false);
        jTabelaInterno.getTableHeader().setReorderingAllowed(false);
        jTabelaInterno.setAutoResizeMode(jTabelaInterno.AUTO_RESIZE_OFF);
        jTabelaInterno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    // Método de pesquisa pela Matricula
    public void buscarInternosMatricula(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Registro", "Código", "Nome do Interno", "Data Saída", "Destino Saída", "Origem"};
        conecta.abrirConexao();
        conecta.executaSQL(sql);
        try {
            conecta.rs.first();
            do {
                // Formatar a data no formato Brasil
                pDATA_SAIDA = conecta.rs.getString("DataSaida");
                String dia = pDATA_SAIDA.substring(8, 10);
                String mes = pDATA_SAIDA.substring(5, 7);
                String ano = pDATA_SAIDA.substring(0, 4);
                pDATA_SAIDA = dia + "/" + mes + "/" + ano;
                // Formatar a data no formato Brasil
                if (pDATA_PREVISAO_RETORNO != null) {
                    pDATA_PREVISAO_RETORNO = conecta.rs.getString("DataPrevRetorno");
                    String diac = pDATA_PREVISAO_RETORNO.substring(8, 10);
                    String mesc = pDATA_PREVISAO_RETORNO.substring(5, 7);
                    String anoc = pDATA_PREVISAO_RETORNO.substring(0, 4);
                    pDATA_PREVISAO_RETORNO = diac + "/" + mesc + "/" + anoc;
                }
                dados.add(new Object[]{conecta.rs.getInt("IdItem"), conecta.rs.getInt("IdInternoCrc"), conecta.rs.getString("NomeInternoCrc"), pDATA_SAIDA, conecta.rs.getString("DestinoSaida"), conecta.rs.getString("IdSaidaTmp")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Dados não encontrado, use o botão TODOS \nPara pesquisar TODOS OS REGISTROS");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInterno.setModel(modelo);
        jTabelaInterno.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaInterno.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaInterno.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(2).setPreferredWidth(350);
        jTabelaInterno.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaInterno.getColumnModel().getColumn(3).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(4).setPreferredWidth(200);
        jTabelaInterno.getColumnModel().getColumn(4).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(5).setPreferredWidth(70);
        jTabelaInterno.getColumnModel().getColumn(5).setResizable(false);
        jTabelaInterno.getTableHeader().setReorderingAllowed(false);
        jTabelaInterno.setAutoResizeMode(jTabelaInterno.AUTO_RESIZE_OFF);
        jTabelaInterno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
        jTabelaInterno.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaInterno.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaInterno.getColumnModel().getColumn(3).setCellRenderer(centralizado);
        jTabelaInterno.getColumnModel().getColumn(5).setCellRenderer(centralizado);
    }
}
