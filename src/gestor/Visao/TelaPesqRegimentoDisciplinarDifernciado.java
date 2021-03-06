/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Dao.ConexaoBancoDados;
import Utilitarios.ModeloTabela;
import static gestor.Visao.TelaRetirarPenalidadeInterno.jDocumentoOrigem;
import static gestor.Visao.TelaRetirarPenalidadeInterno.jNaturezaEvento;
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
public class TelaPesqRegimentoDisciplinarDifernciado extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    int flag;
    String statusLanc = "FINALIZADO";
    String dataBrasil;

    /**
     * Creates new form TelaPesqDocumentoEventoDisciplinar
     */
    public TelaPesqRegimentoDisciplinarDifernciado() {
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
        jLabel1 = new javax.swing.JLabel();
        jNumeroDocumento = new javax.swing.JTextField();
        jBtPesqDocumento = new javax.swing.JButton();
        jCheckBoxTodos = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaDocumentos = new javax.swing.JTable();
        jBtEnviar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Pesquisar Documento Disciplinar :::...");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Documento:");

        jNumeroDocumento.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jNumeroDocumento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqDocumento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqDocumento.setContentAreaFilled(false);
        jBtPesqDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqDocumentoActionPerformed(evt);
            }
        });

        jCheckBoxTodos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxTodos.setText("Todos");
        jCheckBoxTodos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxTodosItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNumeroDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtPesqDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBoxTodos)
                .addGap(17, 17, 17))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(jNumeroDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxTodos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaDocumentos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaDocumentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Código", "Data", "Status", "Natureza do Evento"
            }
        ));
        jTabelaDocumentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaDocumentosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaDocumentos);
        if (jTabelaDocumentos.getColumnModel().getColumnCount() > 0) {
            jTabelaDocumentos.getColumnModel().getColumn(0).setMinWidth(60);
            jTabelaDocumentos.getColumnModel().getColumn(0).setMaxWidth(60);
            jTabelaDocumentos.getColumnModel().getColumn(1).setMinWidth(80);
            jTabelaDocumentos.getColumnModel().getColumn(1).setMaxWidth(80);
            jTabelaDocumentos.getColumnModel().getColumn(2).setMinWidth(100);
            jTabelaDocumentos.getColumnModel().getColumn(2).setMaxWidth(100);
            jTabelaDocumentos.getColumnModel().getColumn(3).setMinWidth(200);
            jTabelaDocumentos.getColumnModel().getColumn(3).setMaxWidth(200);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBtEnviar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtSair)))
                        .addGap(0, 2, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtEnviar, jBtSair});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtEnviar)
                    .addComponent(jBtSair))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtEnviar, jBtSair});

        setBounds(300, 20, 476, 269);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesqDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqDocumentoActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (jNumeroDocumento.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe dados para pesquisa");
            jNumeroDocumento.requestFocus();
        } else {
            preencherTabelaDocumentos("SELECT * FROM REGISTROEVENTOS "
                    + "INNER JOIN NATUREZAEVENTOS "
                    + "ON REGISTROEVENTOS.IdNatureza=NATUREZAEVENTOS.IdNatureza "
                    + "WHERE NomeFunc LIKE'%" + jNumeroDocumento.getText() + "%' "
                    + "AND StatusLanc='" + statusLanc + "'");
        }
    }//GEN-LAST:event_jBtPesqDocumentoActionPerformed

    private void jCheckBoxTodosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxTodosItemStateChanged
        // TODO add your handling code here:
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherTabelaDocumentos("SELECT * FROM REGISTROEVENTOS "
                    + "INNER JOIN NATUREZAEVENTOS "
                    + "ON REGISTROEVENTOS.IdNatureza=NATUREZAEVENTOS.IdNatureza "
                    + "WHERE StatusLanc='" + statusLanc + "'");
        } else {
            limparTabela();
        }
    }//GEN-LAST:event_jCheckBoxTodosItemStateChanged

    private void jBtEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtEnviarActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (jNumeroDocumento.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Selecione o número do documento e clique no botão ENVIAR");
        } else {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM REGISTROEVENTOS "
                        + "INNER JOIN NATUREZAEVENTOS "
                        + "ON REGISTROEVENTOS.IdNatureza=NATUREZAEVENTOS.IdNatureza "
                        + "WHERE IdLanc='" + jNumeroDocumento.getText() + "'");
                conecta.rs.first();
                jDocumentoOrigem.setText(conecta.rs.getString("IdLanc"));
                jNaturezaEvento.setText(conecta.rs.getString("DescricaoNatureza"));
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não foi possível carregar as informações \nERRO: " + ex);
            }
            dispose();
        }
    }//GEN-LAST:event_jBtEnviarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jTabelaDocumentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaDocumentosMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String numeroDocumento = "" + jTabelaDocumentos.getValueAt(jTabelaDocumentos.getSelectedRow(), 0);
            jNumeroDocumento.setText(numeroDocumento);
        }
    }//GEN-LAST:event_jTabelaDocumentosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtEnviar;
    private javax.swing.JButton jBtPesqDocumento;
    private javax.swing.JButton jBtSair;
    private javax.swing.JCheckBox jCheckBoxTodos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jNumeroDocumento;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabelaDocumentos;
    // End of variables declaration//GEN-END:variables

    public void preencherTabelaDocumentos(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Natureza do Evento"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dataBrasil = conecta.rs.getString("DataLanc");
                String dia = dataBrasil.substring(8, 10);
                String mes = dataBrasil.substring(5, 7);
                String ano = dataBrasil.substring(0, 4);
                dataBrasil = dia + "/" + mes + "/" + ano;
                dados.add(new Object[]{conecta.rs.getInt("IdLanc"), dataBrasil, conecta.rs.getString("StatusLanc"), conecta.rs.getString("DescricaoNatureza")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Dados não encontrado, use o botão TODOS \nPara pesquisar TODOS OS REGISTROS");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaDocumentos.setModel(modelo);
        jTabelaDocumentos.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaDocumentos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaDocumentos.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaDocumentos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaDocumentos.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTabelaDocumentos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaDocumentos.getColumnModel().getColumn(3).setPreferredWidth(200);
        jTabelaDocumentos.getColumnModel().getColumn(3).setResizable(false);
        jTabelaDocumentos.getTableHeader().setReorderingAllowed(false);
        jTabelaDocumentos.setAutoResizeMode(jTabelaDocumentos.AUTO_RESIZE_OFF);
        jTabelaDocumentos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabela();
        conecta.desconecta();
    }

    public void limparTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Natureza do Evento"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaDocumentos.setModel(modelo);
        jTabelaDocumentos.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaDocumentos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaDocumentos.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaDocumentos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaDocumentos.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTabelaDocumentos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaDocumentos.getColumnModel().getColumn(3).setPreferredWidth(200);
        jTabelaDocumentos.getColumnModel().getColumn(3).setResizable(false);
        jTabelaDocumentos.getTableHeader().setReorderingAllowed(false);
        jTabelaDocumentos.setAutoResizeMode(jTabelaDocumentos.AUTO_RESIZE_OFF);
        jTabelaDocumentos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
        jTabelaDocumentos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
    }
}
