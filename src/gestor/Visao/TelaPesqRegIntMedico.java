/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.ModeloTabela;
import static gestor.Visao.TelaRetornoMedico.FotoInternoCrcRetEsp;
import static gestor.Visao.TelaRetornoMedico.jDataRetorno;
import static gestor.Visao.TelaRetornoMedico.jHorarioRetorno;
import static gestor.Visao.TelaRetornoMedico.jIdInterno;
import static gestor.Visao.TelaRetornoMedico.jNomeInterno;
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
public class TelaPesqRegIntMedico extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    int flag;
    String caminho;
    String confirmacaoRetrono = "Não";
    public static int idItemRetornoAudiencia; // Código do item da tabela ITENSREGISTRO    
    String dataRetorno;

    /**
     * Creates new form TelaPesqRegistroInternoPortaria
     */
    public TelaPesqRegIntMedico() {
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
        jCheckBox1 = new javax.swing.JCheckBox();
        jPesqNomeInterno = new javax.swing.JTextField();
        jBtPesqNomeInterno = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaPesqInternosPortaria = new javax.swing.JTable();
        jBtConfirmar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Pesquisar Registro de Internos :::...");

        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 255));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Nome:");

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox1.setText("Todos");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });

        jPesqNomeInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqNomeInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqNomeInterno.setContentAreaFilled(false);
        jBtPesqNomeInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqNomeInternoActionPerformed(evt);
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
                .addComponent(jBtPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtPesqNomeInterno)
                    .addComponent(jCheckBox1)
                    .addComponent(jPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaPesqInternosPortaria.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaPesqInternosPortaria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Código", "Nome do Interno", "Data Retorno", "Horário"
            }
        ));
        jScrollPane1.setViewportView(jTabelaPesqInternosPortaria);
        if (jTabelaPesqInternosPortaria.getColumnModel().getColumnCount() > 0) {
            jTabelaPesqInternosPortaria.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaPesqInternosPortaria.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaPesqInternosPortaria.getColumnModel().getColumn(1).setMinWidth(300);
            jTabelaPesqInternosPortaria.getColumnModel().getColumn(1).setMaxWidth(300);
            jTabelaPesqInternosPortaria.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaPesqInternosPortaria.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaPesqInternosPortaria.getColumnModel().getColumn(3).setMinWidth(80);
            jTabelaPesqInternosPortaria.getColumnModel().getColumn(3).setMaxWidth(80);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Listagem de Internos", jPanel1);

        jBtConfirmar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtConfirmar.setForeground(new java.awt.Color(0, 0, 255));
        jBtConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/accept.png"))); // NOI18N
        jBtConfirmar.setText("Confirmar");
        jBtConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtConfirmarActionPerformed(evt);
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
                .addComponent(jBtConfirmar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSair)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jTabbedPane1)
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtConfirmar, jBtSair});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtConfirmar)
                    .addComponent(jBtSair))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtConfirmar, jBtSair});

        setBounds(300, 50, 550, 280);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesqNomeInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNomeInternoActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (jPesqNomeInterno.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe nome do interno para pesquisa.");
        } else {
            pesquisarRegistroInterno("SELECT * FROM ITENSREGISTRO "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENSREGISTRO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE PRONTUARIOSCRC.NomeInternoCrc LIKE'%" + jPesqNomeInterno.getText() + "%' "
                    + "AND ConfirmacaoRetorno='" + confirmacaoRetrono + "'");
        }
    }//GEN-LAST:event_jBtPesqNomeInternoActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.pesquisarRegistroInterno("SELECT * FROM ITENSREGISTRO "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENSREGISTRO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE ConfirmacaoRetorno='" + confirmacaoRetrono + "'");
        } else {
            limparTabela();
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jBtConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtConfirmarActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String nomeInterno = "" + jTabelaPesqInternosPortaria.getValueAt(jTabelaPesqInternosPortaria.getSelectedRow(), 1);
            jPesqNomeInterno.setText(nomeInterno);
            String idInterno = "" + jTabelaPesqInternosPortaria.getValueAt(jTabelaPesqInternosPortaria.getSelectedRow(), 0);
            jIdInterno.setText(idInterno);//           
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ITENSREGISTRO "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ITENSREGISTRO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE PRONTUARIOSCRC.IdInternoCrc='" + idInterno + "' "
                        + "AND ConfirmacaoRetorno='" + confirmacaoRetrono + "'");
                conecta.rs.first();
                jIdInterno.setText(String.valueOf(conecta.rs.getInt("IdInternoCrc")));
                jNomeInterno.setText(conecta.rs.getString("NomeInternoCrc"));
                idItemRetornoAudiencia = conecta.rs.getInt("IdItem");
                jDataRetorno.setDate(conecta.rs.getDate("DataRetorno"));
                jHorarioRetorno.setText(conecta.rs.getString("HorarioRetorno"));
                // Foto do interno        
                caminho = conecta.rs.getString("FotoInternoCrc");
                javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                FotoInternoCrcRetEsp.setIcon(i);
                FotoInternoCrcRetEsp.setIcon(new ImageIcon(i.getImage().getScaledInstance(FotoInternoCrcRetEsp.getWidth(), FotoInternoCrcRetEsp.getHeight(), Image.SCALE_DEFAULT)));
                conecta.desconecta();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa por nome" + ex);
            }
            dispose();
        }
    }//GEN-LAST:event_jBtConfirmarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtConfirmar;
    private javax.swing.JButton jBtPesqNomeInterno;
    private javax.swing.JButton jBtSair;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jPesqNomeInterno;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTabelaPesqInternosPortaria;
    // End of variables declaration//GEN-END:variables

    public void pesquisarRegistroInterno(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome do Interno", "Data Retorno", "Horário"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dataRetorno = conecta.rs.getString("DataRetorno");
                String dia = dataRetorno.substring(8, 10);
                String mes = dataRetorno.substring(5, 7);
                String ano = dataRetorno.substring(0, 4);
                dataRetorno = dia + "/" + mes + "/" + ano;
                dados.add(new Object[]{conecta.rs.getInt("IdInternoCrc"), conecta.rs.getString("NomeInternoCrc"), dataRetorno, conecta.rs.getString("HorarioRetorno")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPesqInternosPortaria.setModel(modelo);
        jTabelaPesqInternosPortaria.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaPesqInternosPortaria.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPesqInternosPortaria.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTabelaPesqInternosPortaria.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPesqInternosPortaria.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaPesqInternosPortaria.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPesqInternosPortaria.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaPesqInternosPortaria.getColumnModel().getColumn(3).setResizable(false);
        jTabelaPesqInternosPortaria.getTableHeader().setReorderingAllowed(false);
        jTabelaPesqInternosPortaria.setAutoResizeMode(jTabelaPesqInternosPortaria.AUTO_RESIZE_OFF);
        jTabelaPesqInternosPortaria.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabela();
        conecta.desconecta();
    }

    public void limparTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome do Interno", "Data Retorno", "Horário"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPesqInternosPortaria.setModel(modelo);
        jTabelaPesqInternosPortaria.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaPesqInternosPortaria.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPesqInternosPortaria.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTabelaPesqInternosPortaria.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPesqInternosPortaria.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaPesqInternosPortaria.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPesqInternosPortaria.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaPesqInternosPortaria.getColumnModel().getColumn(3).setResizable(false);
        jTabelaPesqInternosPortaria.getTableHeader().setReorderingAllowed(false);
        jTabelaPesqInternosPortaria.setAutoResizeMode(jTabelaPesqInternosPortaria.AUTO_RESIZE_OFF);
        jTabelaPesqInternosPortaria.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
        jTabelaPesqInternosPortaria.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaPesqInternosPortaria.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        jTabelaPesqInternosPortaria.getColumnModel().getColumn(3).setCellRenderer(centralizado);
    }
}
