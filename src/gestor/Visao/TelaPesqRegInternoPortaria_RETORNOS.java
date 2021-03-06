/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Dao.ConexaoBancoDados;
import Utilitarios.ModeloTabela;
import static gestor.Visao.TelaCancelRegistroPortaria_RETORNOS.jComboBoxTipoRetorno;
import static gestor.Visao.TelaCancelRegistroPortaria_RETORNOS.jIdInternoReg;
import static gestor.Visao.TelaCancelRegistroPortaria_RETORNOS.jNomeInternoReg;
import static gestor.Visao.TelaCancelRegistroPortaria_RETORNOS.jNrDocumento;
import static gestor.Visao.TelaCancelRegistroPortaria_RETORNOS.pRETORNO_PORTARIA;
import static gestor.Visao.TelaCancelRegistroPortaria_RETORNOS.pCODIGO_ENTRADA_SAIDA;
import static gestor.Visao.TelaCancelRegistroPortaria_RETORNOS.jDataEntrada;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ronaldo
 */
public class TelaPesqRegInternoPortaria_RETORNOS extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();

    int flag;
    String pRETORNO_CRC = "Não";
    String pRETORNO_PORTARIA_RetPort = "Sim";
    String pCONFIRMACAO_RETORNO = "Não";
    String pREGISTRO_CANCELADO = "";
    String nomeInterno;
    String pREGISTRO;

    // public static String idItemIntPor;
    /**
     * Creates new form TelaPesqRegInternoPortaria
     */
    public TelaPesqRegInternoPortaria_RETORNOS() {
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
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPesqNomeInterno = new javax.swing.JTextField();
        jBtPesqNomeInterno = new javax.swing.JButton();
        jCheckBoxTodos = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaPesqInternos = new javax.swing.JTable();
        jBtEnviar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();

        setClosable(true);
        setTitle("...::: Pesquisa Registro Entrada Internos - ENTRADA 1ª VEZ :::...");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Nome Interno:");

        jPesqNomeInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqNomeInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqNomeInterno.setContentAreaFilled(false);
        jBtPesqNomeInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqNomeInternoActionPerformed(evt);
            }
        });

        jCheckBoxTodos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxTodos.setText("Todos");
        jCheckBoxTodos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxTodosItemStateChanged(evt);
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
                .addComponent(jPesqNomeInterno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxTodos)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(jPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqNomeInterno)
                    .addComponent(jCheckBoxTodos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaPesqInternos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaPesqInternos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Registro", "Código", "Nome do Interno", "Tipo Retorno"
            }
        ));
        jTabelaPesqInternos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaPesqInternosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaPesqInternos);
        if (jTabelaPesqInternos.getColumnModel().getColumnCount() > 0) {
            jTabelaPesqInternos.getColumnModel().getColumn(0).setMinWidth(60);
            jTabelaPesqInternos.getColumnModel().getColumn(0).setMaxWidth(60);
            jTabelaPesqInternos.getColumnModel().getColumn(1).setMinWidth(60);
            jTabelaPesqInternos.getColumnModel().getColumn(1).setMaxWidth(60);
            jTabelaPesqInternos.getColumnModel().getColumn(2).setMinWidth(300);
            jTabelaPesqInternos.getColumnModel().getColumn(2).setMaxWidth(300);
            jTabelaPesqInternos.getColumnModel().getColumn(3).setMinWidth(250);
            jTabelaPesqInternos.getColumnModel().getColumn(3).setMaxWidth(250);
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
                        .addGap(0, 348, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtEnviar)
                    .addComponent(jBtSair)))
        );

        jTabbedPane2.addTab("Pesquisa", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        setBounds(250, 20, 557, 272);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesqNomeInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNomeInternoActionPerformed
        // TODO add your handling code here:
        if (jPesqNomeInterno.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o nome do interno para pesquisa.");
        } else {
            preencherTabelaInternos("SELECT DISTINCT ITENSREGISTRO.IdInternoCrc,PRONTUARIOSCRC.NomeInternoCrc, "
                    + "ITENSREGISTRO.IdRetorno,ITENSREGISTRO.OrigemRetorno,ITENSREGISTRO.ConfirmacaoRetorno, "
                    + "VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS.IdEntraSaida, "
                    + "VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS.RetPort, "
                    + "VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS.RetCrc, "
                    + "ITENSREGISTRO.RegistroCancelado "
                    + "FROM ITENSREGISTRO "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENSREGISTRO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS "
                    + "ON ITENSREGISTRO.IdInternoCrc=VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS.IdInternoCrc "
                    + "WHERE PRONTUARIOSCRC.NomeInternoCrc LIKE'%" + jPesqNomeInterno.getText() + "%' "
                    + "AND ITENSREGISTRO.ConfirmacaoRetorno='" + pCONFIRMACAO_RETORNO + "' "
                    + "AND VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS.RetCrc='" + pRETORNO_CRC + "' "
                    + "AND ITENSREGISTRO.OrigemRetorno='" + jComboBoxTipoRetorno.getSelectedItem() + "' "
                    + "AND VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS.RetPort='" + pRETORNO_PORTARIA_RetPort + "' "
                    + "AND ITENSREGISTRO.RegistroCancelado IS NULL");
        }
    }//GEN-LAST:event_jBtPesqNomeInternoActionPerformed

    private void jCheckBoxTodosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxTodosItemStateChanged
        // TODO add your handling code here:
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherTabelaInternos("SELECT DISTINCT ITENSREGISTRO.IdInternoCrc,PRONTUARIOSCRC.NomeInternoCrc, "
                    + "ITENSREGISTRO.IdRetorno,ITENSREGISTRO.OrigemRetorno,ITENSREGISTRO.ConfirmacaoRetorno, "
                    + "VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS.IdEntraSaida, "
                    + "VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS.RetPort, "
                    + "VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS.RetCrc, "
                    + "ITENSREGISTRO.RegistroCancelado "
                    + "FROM ITENSREGISTRO "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENSREGISTRO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS "
                    + "ON ITENSREGISTRO.IdInternoCrc=VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS.IdInternoCrc "
                    + "WHERE VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS.RetCrc='" + pRETORNO_CRC + "' "
                    + "AND ITENSREGISTRO.ConfirmacaoRetorno='" + pCONFIRMACAO_RETORNO + "' "
                    + "AND ITENSREGISTRO.OrigemRetorno='" + jComboBoxTipoRetorno.getSelectedItem() + "' "
                    + "AND VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS.RetPort='" + pRETORNO_PORTARIA_RetPort + "' "
                    + "AND ITENSREGISTRO.RegistroCancelado IS NULL ORDER BY NomeInternoCrc");
        } else {
            limparTabela();
        }
    }//GEN-LAST:event_jCheckBoxTodosItemStateChanged

    private void jBtEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtEnviarActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            nomeInterno = "" + jTabelaPesqInternos.getValueAt(jTabelaPesqInternos.getSelectedRow(), 2);
            jPesqNomeInterno.setText(nomeInterno);
            String idInterno = "" + jTabelaPesqInternos.getValueAt(jTabelaPesqInternos.getSelectedRow(), 1);
            pREGISTRO = "" + jTabelaPesqInternos.getValueAt(jTabelaPesqInternos.getSelectedRow(), 0);
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT ITENSREGISTRO.IdInternoCrc,PRONTUARIOSCRC.NomeInternoCrc, "
                        + "ITENSREGISTRO.IdRetorno,ITENSREGISTRO.OrigemRetorno,ITENSREGISTRO.ConfirmacaoRetorno, "
                        + "ITENSREGISTRO.DocumentoRetorno,ITENSREGISTRO.DataRetorno, "
                        + "VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS.IdEntraSaida, "
                        + "VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS.RetPort, "
                        + "VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS.RetCrc "
                        + "FROM ITENSREGISTRO "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ITENSREGISTRO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "INNER JOIN VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS "
                        + "ON ITENSREGISTRO.IdInternoCrc=VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS.IdInternoCrc "
                        + "WHERE NomeInternoCrc='" + nomeInterno + "' "
                        + "AND ITENSREGISTRO.IdInternoCrc='" + idInterno + "' "
                        + "AND ITENSREGISTRO.OrigemRetorno='" + jComboBoxTipoRetorno.getSelectedItem() + "' "
                        + "AND VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS.IdEntraSaida='" + pREGISTRO + "'"
                        + "AND ITENSREGISTRO.RegistroCancelado IS NULL");
                conecta.rs.first();
                pCODIGO_ENTRADA_SAIDA = conecta.rs.getInt("IdEntraSaida");
                jIdInternoReg.setText(String.valueOf(conecta.rs.getInt("IdInternoCrc")));
                jNomeInternoReg.setText(conecta.rs.getString("NomeInternoCrc"));
                pRETORNO_PORTARIA = conecta.rs.getInt("IdRetorno");
                jNrDocumento.setText(conecta.rs.getString("DocumentoRetorno"));
                jDataEntrada.setDate(conecta.rs.getDate("DataRetorno"));
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

    private void jTabelaPesqInternosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaPesqInternosMouseClicked
        // TODO add your handling code here:
        pREGISTRO = "" + jTabelaPesqInternos.getValueAt(jTabelaPesqInternos.getSelectedRow(), 0);
        nomeInterno = "" + jTabelaPesqInternos.getValueAt(jTabelaPesqInternos.getSelectedRow(), 2);
        jPesqNomeInterno.setText(nomeInterno);
    }//GEN-LAST:event_jTabelaPesqInternosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtEnviar;
    private javax.swing.JButton jBtPesqNomeInterno;
    private javax.swing.JButton jBtSair;
    private javax.swing.JCheckBox jCheckBoxTodos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jPesqNomeInterno;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTabelaPesqInternos;
    // End of variables declaration//GEN-END:variables

    public void preencherTabelaInternos(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Registro", "Código", "Nome do Interno", "Tipo Retorno"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdEntraSaida"), conecta.rs.getInt("IdInternoCrc"), conecta.rs.getString("NomeInternoCrc"), conecta.rs.getString("OrigemRetorno")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPesqInternos.setModel(modelo);
        jTabelaPesqInternos.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaPesqInternos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPesqInternos.getColumnModel().getColumn(1).setPreferredWidth(60);
        jTabelaPesqInternos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPesqInternos.getColumnModel().getColumn(2).setPreferredWidth(300);
        jTabelaPesqInternos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPesqInternos.getColumnModel().getColumn(3).setPreferredWidth(250);
        jTabelaPesqInternos.getColumnModel().getColumn(3).setResizable(false);
        jTabelaPesqInternos.getTableHeader().setReorderingAllowed(false);
        jTabelaPesqInternos.setAutoResizeMode(jTabelaPesqInternos.AUTO_RESIZE_OFF);
        jTabelaPesqInternos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaItens();
        conecta.desconecta();
    }

    public void limparTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Registro", "Código", "Nome do Interno", "Tipo Retorno"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPesqInternos.setModel(modelo);
        jTabelaPesqInternos.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaPesqInternos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPesqInternos.getColumnModel().getColumn(1).setPreferredWidth(60);
        jTabelaPesqInternos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPesqInternos.getColumnModel().getColumn(2).setPreferredWidth(300);
        jTabelaPesqInternos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPesqInternos.getColumnModel().getColumn(3).setPreferredWidth(250);
        jTabelaPesqInternos.getColumnModel().getColumn(3).setResizable(false);
        jTabelaPesqInternos.getTableHeader().setReorderingAllowed(false);
        jTabelaPesqInternos.setAutoResizeMode(jTabelaPesqInternos.AUTO_RESIZE_OFF);
        jTabelaPesqInternos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabelaItens() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaPesqInternos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaPesqInternos.getColumnModel().getColumn(1).setCellRenderer(centralizado);
    }
}
