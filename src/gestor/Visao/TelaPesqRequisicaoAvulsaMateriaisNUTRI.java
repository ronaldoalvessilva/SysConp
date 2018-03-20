/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.ModeloTabela;
import static gestor.Visao.TelaEstornoRequisicaoMateriaisNUTRI.jDataReq;
import static gestor.Visao.TelaEstornoRequisicaoMateriaisNUTRI.jIdLocal;
import static gestor.Visao.TelaEstornoRequisicaoMateriaisNUTRI.jIdReq;
import static gestor.Visao.TelaEstornoRequisicaoMateriaisNUTRI.jNomeRequisitante;
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
public class TelaPesqRequisicaoAvulsaMateriaisNUTRI extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    int flag;
    String dataEntrada;
    String statusReq = "FINALIZADO";

    /**
     * Creates new form TelaPesqPavilhao
     */
    public TelaPesqRequisicaoAvulsaMateriaisNUTRI() {
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
        jPesqNomeRequisitante = new javax.swing.JTextField();
        jBtDescricao = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaRequisicao = new javax.swing.JTable();
        jBtEnviar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Pesquisa Requisição Avulsa de Materiais :::...");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Requisitante:");

        jPesqNomeRequisitante.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtDescricao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtDescricao.setContentAreaFilled(false);
        jBtDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtDescricaoActionPerformed(evt);
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
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPesqNomeRequisitante)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtDescricao)
                    .addComponent(jPesqNomeRequisitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jCheckBox1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaRequisicao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaRequisicao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Código", "Data Req.", "Nome Requisitante"
            }
        ));
        jTabelaRequisicao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaRequisicaoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaRequisicao);
        if (jTabelaRequisicao.getColumnModel().getColumnCount() > 0) {
            jTabelaRequisicao.getColumnModel().getColumn(0).setMinWidth(80);
            jTabelaRequisicao.getColumnModel().getColumn(0).setMaxWidth(80);
            jTabelaRequisicao.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaRequisicao.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaRequisicao.getColumnModel().getColumn(2).setMinWidth(300);
            jTabelaRequisicao.getColumnModel().getColumn(2).setMaxWidth(300);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Pesquisa", jPanel1);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtEnviar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSair)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtEnviar)
                    .addComponent(jBtSair)))
        );

        setBounds(250, 20, 491, 276);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtEnviarActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (jPesqNomeRequisitante.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Selecione o nome do requisitante e clique no botão ENVIAR");
        } else {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM REQUISICAO_AVULSA_PRODUTOS_NUTRI "
                        + "INNER JOIN COLABORADOR "
                        + "ON REQUISICAO_AVULSA_PRODUTOS_NUTRI.IdFunc=COLABORADOR.IdFunc "
                        + "WHERE COLABORADOR.NomeFunc='" + jPesqNomeRequisitante.getText() + "'");
                conecta.rs.first();
                jIdReq.setText(conecta.rs.getString("IdReq"));
                jDataReq.setDate(conecta.rs.getDate("DataReq"));
                jIdLocal.setText(conecta.rs.getString("IdLocal"));
                jNomeRequisitante.setText(conecta.rs.getString("NomeFunc"));
                conecta.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa dos dados.\nERRO: " + e);
            }
            dispose();
        }
    }//GEN-LAST:event_jBtEnviarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtDescricaoActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (jPesqNomeRequisitante.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um nome para pesquisa.");
            jPesqNomeRequisitante.requestFocus();
        } else {
            preencherTabela("SELECT * FROM REQUISICAO_AVULSA_PRODUTOS_NUTRI "
                    + "INNER JOIN COLABORADOR "
                    + "ON REQUISICAO_AVULSA_PRODUTOS_NUTRI.IdFunc=COLABORADOR.IdFunc "
                    + "WHERE NomeFunc LIKE'%" + jPesqNomeRequisitante.getText() + "%'AND "
                    + "REQUISICAO_AVULSA_PRODUTOS_NUTRI.StatusReq='" + statusReq + "'");
        }
    }//GEN-LAST:event_jBtDescricaoActionPerformed

    private void jTabelaRequisicaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaRequisicaoMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            String nomeColaborador = "" + jTabelaRequisicao.getValueAt(jTabelaRequisicao.getSelectedRow(), 2);
            jPesqNomeRequisitante.setText(nomeColaborador);
            String idFunc = "" + jTabelaRequisicao.getValueAt(jTabelaRequisicao.getSelectedRow(), 0);

        }
    }//GEN-LAST:event_jTabelaRequisicaoMouseClicked

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherTabela("SELECT * FROM REQUISICAO_AVULSA_PRODUTOS_NUTRI "
                    + "INNER JOIN COLABORADOR "
                    + "ON REQUISICAO_AVULSA_PRODUTOS_NUTRI.IdFunc=COLABORADOR.IdFunc "
                    + "WHERE REQUISICAO_AVULSA_PRODUTOS_NUTRI.StatusReq='" + statusReq + "'");
        } else {
            limparTabela();
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtDescricao;
    private javax.swing.JButton jBtEnviar;
    private javax.swing.JButton jBtSair;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jPesqNomeRequisitante;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTabelaRequisicao;
    // End of variables declaration//GEN-END:variables

    public void preencherTabela(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data Req.", "Nome Requisitante"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dataEntrada = conecta.rs.getString("DataReq");
                String dia = dataEntrada.substring(8, 10);
                String mes = dataEntrada.substring(5, 7);
                String ano = dataEntrada.substring(0, 4);
                dataEntrada = dia + "/" + mes + "/" + ano;
                dados.add(new Object[]{conecta.rs.getInt("IdReq"), dataEntrada, conecta.rs.getString("NomeFunc")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não existe dados a ser exibido!!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaRequisicao.setModel(modelo);
        jTabelaRequisicao.getColumnModel().getColumn(0).setPreferredWidth(80);
        jTabelaRequisicao.getColumnModel().getColumn(0).setResizable(false);
        jTabelaRequisicao.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaRequisicao.getColumnModel().getColumn(1).setResizable(false);
        jTabelaRequisicao.getColumnModel().getColumn(2).setPreferredWidth(300);
        jTabelaRequisicao.getColumnModel().getColumn(2).setResizable(false);
        jTabelaRequisicao.getTableHeader().setReorderingAllowed(false);
        jTabelaRequisicao.setAutoResizeMode(jTabelaRequisicao.AUTO_RESIZE_OFF);
        jTabelaRequisicao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabela();
        conecta.desconecta();
    }

    public void limparTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data Req.", "Nome Requisitante"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaRequisicao.setModel(modelo);
        jTabelaRequisicao.getColumnModel().getColumn(0).setPreferredWidth(80);
        jTabelaRequisicao.getColumnModel().getColumn(0).setResizable(false);
        jTabelaRequisicao.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaRequisicao.getColumnModel().getColumn(1).setResizable(false);
        jTabelaRequisicao.getColumnModel().getColumn(2).setPreferredWidth(300);
        jTabelaRequisicao.getColumnModel().getColumn(2).setResizable(false);
        jTabelaRequisicao.getTableHeader().setReorderingAllowed(false);
        jTabelaRequisicao.setAutoResizeMode(jTabelaRequisicao.AUTO_RESIZE_OFF);
        jTabelaRequisicao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabela() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        //
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaRequisicao.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaRequisicao.getColumnModel().getColumn(1).setCellRenderer(centralizado);
    }
}
