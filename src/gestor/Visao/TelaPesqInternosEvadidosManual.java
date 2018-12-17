/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.ModeloTabela;
import static gestor.Visao.TelaEvadidosSaidaTemporariaManual.jDataSaida;
import static gestor.Visao.TelaEvadidosSaidaTemporariaManual.jDocumentoSaida;
import static gestor.Visao.TelaEvadidosSaidaTemporariaManual.jIdInternoEvadido;
import static gestor.Visao.TelaEvadidosSaidaTemporariaManual.jIdSaida;
import static gestor.Visao.TelaEvadidosSaidaTemporariaManual.jNomeInternoEvadido;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
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
public class TelaPesqInternosEvadidosManual extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();

    String dataEntrada, dataSaida, dataSaidaTemp;
    String dataRetorno, dataPrevRetorno;
    String dataBrasil;
    String dataEvasao = ""; // Variavel que controla a saida temporaria junto com a evasão
    String NrDocRetorno = "";
    String NrDocRetornoNull = null;
    int flag;
    String nomeInterno;
    String idInt;

    /**
     * Creates new form TelaPesqInternosEvadidosManual
     */
    public TelaPesqInternosEvadidosManual() {
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
        jPesqNomeInternoEvadido = new javax.swing.JTextField();
        jBtPesqNomeInternoEvadido = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jBtSelecionar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaIntEvadidosSaidaTemporaria = new javax.swing.JTable();

        setClosable(true);
        setTitle("...::: Pesquisa de Internos Saída Temporária {Evadido} :::..");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Nome:");

        jPesqNomeInternoEvadido.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqNomeInternoEvadido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqNomeInternoEvadido.setContentAreaFilled(false);
        jBtPesqNomeInternoEvadido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqNomeInternoEvadidoActionPerformed(evt);
            }
        });

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox1.setText("Todos");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
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
                .addComponent(jPesqNomeInternoEvadido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtPesqNomeInternoEvadido, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPesqNomeInternoEvadido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jBtPesqNomeInternoEvadido, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jBtSelecionar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtSelecionar.setForeground(new java.awt.Color(0, 102, 0));
        jBtSelecionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/accept.png"))); // NOI18N
        jBtSelecionar.setText("Selecionar");
        jBtSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSelecionarActionPerformed(evt);
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

        jTabelaIntEvadidosSaidaTemporaria.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaIntEvadidosSaidaTemporaria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Item", "Código", "Nome do Interno", "Data Saída", "Dt. Previsão"
            }
        ));
        jTabelaIntEvadidosSaidaTemporaria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaIntEvadidosSaidaTemporariaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaIntEvadidosSaidaTemporaria);
        if (jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumnCount() > 0) {
            jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(1).setMinWidth(50);
            jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(1).setMaxWidth(50);
            jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(2).setMinWidth(250);
            jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(2).setMaxWidth(250);
            jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(3).setMinWidth(80);
            jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(3).setMaxWidth(80);
            jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(4).setMinWidth(70);
            jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(4).setMaxWidth(70);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtSelecionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSair)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtSair, jBtSelecionar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtSelecionar)
                    .addComponent(jBtSair))
                .addGap(5, 5, 5))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtSair, jBtSelecionar});

        setBounds(300, 20, 528, 270);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSelecionarActionPerformed
        // TODO add your handling code here:
        if (jPesqNomeInternoEvadido.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um nome de interno a ser selecionado.");
        } else if (idInt == null) {
            JOptionPane.showMessageDialog(rootPane, "Selecione corretamente o nome do interno..");
        } else {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM MOVISR "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON MOVISR.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE NomeInternoCrc='" + nomeInterno + "' "
                        + "AND IdItem='" + idInt + "'");
                conecta.rs.first();
                jIdInternoEvadido.setText(String.valueOf(conecta.rs.getInt("IdInternoCrc")));
                jNomeInternoEvadido.setText(conecta.rs.getString("NomeInternoCrc"));
                jIdSaida.setText(conecta.rs.getString("IdSaida"));
                jDataSaida.setDate(conecta.rs.getDate("DataSaida"));
                jDocumentoSaida.setText(conecta.rs.getString("NrDocSaida"));
                conecta.desconecta();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa por nome" + ex);
            }
            dispose();
        }
    }//GEN-LAST:event_jBtSelecionarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtPesqNomeInternoEvadidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNomeInternoEvadidoActionPerformed
        // TODO add your handling code here:
        if (jPesqNomeInternoEvadido.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o nome do interno para pesquisa.");
        } else {
            preencherTabelaEvadidoSaidaTemporaria("SELECT * FROM MOVISR "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON MOVISR.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE NrDocRetorno='" + NrDocRetorno + "' "
                    + "AND DataPrevRetorno <'" + jDataSistema.getText() + "' "
                    + "AND DataEvasao='" + dataEvasao + "' "
                    + "AND NomeInternoCrc LIKE'%" + jPesqNomeInternoEvadido.getText() + "%'");
        }
    }//GEN-LAST:event_jBtPesqNomeInternoEvadidoActionPerformed

    private void jTabelaIntEvadidosSaidaTemporariaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaIntEvadidosSaidaTemporariaMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            nomeInterno = "" + jTabelaIntEvadidosSaidaTemporaria.getValueAt(jTabelaIntEvadidosSaidaTemporaria.getSelectedRow(), 2);
            jPesqNomeInternoEvadido.setText(nomeInterno);
            idInt = "" + jTabelaIntEvadidosSaidaTemporaria.getValueAt(jTabelaIntEvadidosSaidaTemporaria.getSelectedRow(), 0);
        }
    }//GEN-LAST:event_jTabelaIntEvadidosSaidaTemporariaMouseClicked

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherTabelaEvadidoSaidaTemporaria("SELECT * FROM MOVISR "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON MOVISR.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE NrDocRetorno='" + NrDocRetorno + "'AND DataPrevRetorno <'" + jDataSistema.getText() + "'AND DataEvasao='" + dataEvasao + "'");
        } else {
            limparTabela();
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtPesqNomeInternoEvadido;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSelecionar;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jPesqNomeInternoEvadido;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabelaIntEvadidosSaidaTemporaria;
    // End of variables declaration//GEN-END:variables

    public void preencherTabelaEvadidoSaidaTemporaria(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código", "Nome do Interno ", "Data Saída", "Dt.Previsão"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                // Formatar a data Saida
                dataSaidaTemp = conecta.rs.getString("DataSaida");
                String diap = dataSaidaTemp.substring(8, 10);
                String mesp = dataSaidaTemp.substring(5, 7);
                String anop = dataSaidaTemp.substring(0, 4);
                dataSaidaTemp = diap + "/" + mesp + "/" + anop;
                // Formatar a data Entrada
                dataPrevRetorno = conecta.rs.getString("DataPrevRetorno");
                String diar = dataPrevRetorno.substring(8, 10);
                String mesr = dataPrevRetorno.substring(5, 7);
                String anor = dataPrevRetorno.substring(0, 4);
                dataPrevRetorno = diar + "/" + mesr + "/" + anor;
                dados.add(new Object[]{conecta.rs.getInt("IdItem"), conecta.rs.getInt("IdInternoCrc"), conecta.rs.getString("NomeInternoCrc"), dataSaidaTemp, dataPrevRetorno});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaIntEvadidosSaidaTemporaria.setModel(modelo);
        jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(0).setResizable(false);
        jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(1).setResizable(false);
        jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(2).setPreferredWidth(250);
        jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(2).setResizable(false);
        jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(3).setResizable(false);
        jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(4).setPreferredWidth(70);
        jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(4).setResizable(false);
        jTabelaIntEvadidosSaidaTemporaria.getTableHeader().setReorderingAllowed(false);
        jTabelaIntEvadidosSaidaTemporaria.setAutoResizeMode(jTabelaIntEvadidosSaidaTemporaria.AUTO_RESIZE_OFF);
        jTabelaIntEvadidosSaidaTemporaria.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinhaColunasTabelaEvadidosSaidaTemporaria();
        conecta.desconecta();
    }

    public void limparTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código", "Nome do Interno ", "Data Saída", "Dt.Previsão"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaIntEvadidosSaidaTemporaria.setModel(modelo);
        jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(0).setResizable(false);
        jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(1).setResizable(false);
        jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(2).setPreferredWidth(250);
        jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(2).setResizable(false);
        jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(3).setResizable(false);
        jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(4).setPreferredWidth(70);
        jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(4).setResizable(false);
        jTabelaIntEvadidosSaidaTemporaria.getTableHeader().setReorderingAllowed(false);
        jTabelaIntEvadidosSaidaTemporaria.setAutoResizeMode(jTabelaIntEvadidosSaidaTemporaria.AUTO_RESIZE_OFF);
        jTabelaIntEvadidosSaidaTemporaria.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinhaColunasTabelaEvadidosSaidaTemporaria() {
        //
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        //
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(3).setCellRenderer(centralizado);
    }
}
