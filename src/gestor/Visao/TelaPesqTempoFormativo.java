/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.ModeloTabela;
import static gestor.Visao.TelaMatriculaPedagogica.codigoMatricula;
import static gestor.Visao.TelaMatriculaPedagogica.jDescricaoTempoFormativo;
import static gestor.Visao.TelaMatriculaPedagogica.jDescricaoTurno;
import static gestor.Visao.TelaMatriculaPedagogica.jEixo;
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
public class TelaPesqTempoFormativo extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    int flag;
    String statusInst = "Ativo";
    String descricaoTempoFormativo;
    String idInst;

    /**
     * Creates new form TelaPesqInstituicaoMat
     */
    public TelaPesqTempoFormativo() {
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
        jPesqNomeInstituicao = new javax.swing.JTextField();
        jBtPesqNomeInstituicao = new javax.swing.JButton();
        jCheckBoxTodos = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaTempoFormativo = new javax.swing.JTable();
        jBtConfirmar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();

        setClosable(true);
        setTitle("...::: Pesquisar Tempo Formativo :::...");

        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 204));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Descrição:");

        jPesqNomeInstituicao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqNomeInstituicao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqNomeInstituicao.setContentAreaFilled(false);
        jBtPesqNomeInstituicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqNomeInstituicaoActionPerformed(evt);
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
                .addComponent(jPesqNomeInstituicao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtPesqNomeInstituicao, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxTodos)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtPesqNomeInstituicao)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jPesqNomeInstituicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jCheckBoxTodos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaTempoFormativo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaTempoFormativo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome do Tempo Formativo", "Eixo", "Turnos de Aulas"
            }
        ));
        jTabelaTempoFormativo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaTempoFormativoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaTempoFormativo);
        if (jTabelaTempoFormativo.getColumnModel().getColumnCount() > 0) {
            jTabelaTempoFormativo.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaTempoFormativo.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaTempoFormativo.getColumnModel().getColumn(1).setMinWidth(300);
            jTabelaTempoFormativo.getColumnModel().getColumn(1).setMaxWidth(300);
            jTabelaTempoFormativo.getColumnModel().getColumn(2).setMinWidth(90);
            jTabelaTempoFormativo.getColumnModel().getColumn(2).setMaxWidth(90);
            jTabelaTempoFormativo.getColumnModel().getColumn(3).setMinWidth(200);
            jTabelaTempoFormativo.getColumnModel().getColumn(3).setMaxWidth(200);
        }

        jBtConfirmar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtConfirmar.setForeground(new java.awt.Color(0, 0, 204));
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jBtConfirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSair)
                        .addGap(0, 329, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtConfirmar, jBtSair});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtConfirmar)
                    .addComponent(jBtSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtConfirmar, jBtSair});

        jTabbedPane1.addTab("Pesquisas", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        setBounds(300, 30, 594, 283);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtConfirmarActionPerformed
        // TODO add your handling code here:
        if (jPesqNomeInstituicao.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Selecione o nome do interno e clique no botão ENVIAR");
        } else {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM TEMPOFORMATIVO "
                        + "INNER JOIN TURNOSAULA "
                        + "ON TEMPOFORMATIVO.IdTurno=TURNOSAULA.IdTurno "
                         + "WHERE IdTempo='" + idInst + "'");
                conecta.rs.first();
                codigoMatricula = conecta.rs.getInt("IdTempo");
                jDescricaoTempoFormativo.setText(conecta.rs.getString("DescricaoTempo"));
                jEixo.setText(conecta.rs.getString("Eixo"));
                jDescricaoTurno.setText(conecta.rs.getString("DescricaoTurno"));
                conecta.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa TEMPO FORMATIVO" + e);
            }
            dispose();
        }
    }//GEN-LAST:event_jBtConfirmarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtPesqNomeInstituicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNomeInstituicaoActionPerformed
        // TODO add your handling code here:
        if (jPesqNomeInstituicao.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um nome para pesquisa.");
        } else {
            preencherTabelaInstituicao("SELECT * FROM TEMPOFORMATIVO "
                    + "INNER JOIN TURNOSAULA "
                    + "ON TEMPOFORMATIVO.IdTurno=TURNOSAULA.IdTurno "
                    + "WHERE DescricaoTempo LIKE'" + jPesqNomeInstituicao.getText() + "%' "
                    + "AND StatusTempo='" + statusInst + "'");
        }
    }//GEN-LAST:event_jBtPesqNomeInstituicaoActionPerformed

    private void jCheckBoxTodosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxTodosItemStateChanged
        // TODO add your handling code here:
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherTabelaInstituicao("SELECT * FROM TEMPOFORMATIVO "
                    + "INNER JOIN TURNOSAULA "
                    + "ON TEMPOFORMATIVO.IdTurno=TURNOSAULA.IdTurno "
                    + "WHERE StatusTempo='" + statusInst + "'");
        } else {
            limparTabela();
        }
    }//GEN-LAST:event_jCheckBoxTodosItemStateChanged

    private void jTabelaTempoFormativoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaTempoFormativoMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            descricaoTempoFormativo = "" + jTabelaTempoFormativo.getValueAt(jTabelaTempoFormativo.getSelectedRow(), 1);
            jPesqNomeInstituicao.setText(descricaoTempoFormativo);
            idInst = "" + jTabelaTempoFormativo.getValueAt(jTabelaTempoFormativo.getSelectedRow(), 0);
        }
    }//GEN-LAST:event_jTabelaTempoFormativoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtConfirmar;
    private javax.swing.JButton jBtPesqNomeInstituicao;
    private javax.swing.JButton jBtSair;
    private javax.swing.JCheckBox jCheckBoxTodos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jPesqNomeInstituicao;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTabelaTempoFormativo;
    // End of variables declaration//GEN-END:variables

    public void preencherTabelaInstituicao(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome do Tempo Formativo", "Eixo", "Turnos de Aulas"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdTempo"), conecta.rs.getString("DescricaoTempo"), conecta.rs.getString("Eixo"), conecta.rs.getString("DescricaoTurno")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaTempoFormativo.setModel(modelo);
        jTabelaTempoFormativo.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaTempoFormativo.getColumnModel().getColumn(0).setResizable(false);
        jTabelaTempoFormativo.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTabelaTempoFormativo.getColumnModel().getColumn(1).setResizable(false);
        jTabelaTempoFormativo.getColumnModel().getColumn(2).setPreferredWidth(90);
        jTabelaTempoFormativo.getColumnModel().getColumn(2).setResizable(false);
        jTabelaTempoFormativo.getColumnModel().getColumn(3).setPreferredWidth(200);
        jTabelaTempoFormativo.getColumnModel().getColumn(3).setResizable(false);
        jTabelaTempoFormativo.getTableHeader().setReorderingAllowed(false);
        jTabelaTempoFormativo.setAutoResizeMode(jTabelaTempoFormativo.AUTO_RESIZE_OFF);
        jTabelaTempoFormativo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabela();
        conecta.desconecta();
    }

    public void limparTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome do Tempo Formativo", "Eixo", "Turnos de Aulas"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaTempoFormativo.setModel(modelo);
        jTabelaTempoFormativo.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaTempoFormativo.getColumnModel().getColumn(0).setResizable(false);
        jTabelaTempoFormativo.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTabelaTempoFormativo.getColumnModel().getColumn(1).setResizable(false);
        jTabelaTempoFormativo.getColumnModel().getColumn(2).setPreferredWidth(90);
        jTabelaTempoFormativo.getColumnModel().getColumn(2).setResizable(false);
        jTabelaTempoFormativo.getColumnModel().getColumn(3).setPreferredWidth(200);
        jTabelaTempoFormativo.getColumnModel().getColumn(3).setResizable(false);
        jTabelaTempoFormativo.getTableHeader().setReorderingAllowed(false);
        jTabelaTempoFormativo.setAutoResizeMode(jTabelaTempoFormativo.AUTO_RESIZE_OFF);
        jTabelaTempoFormativo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabela() {
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaTempoFormativo.getColumnModel().getColumn(0).setCellRenderer(centralizado);
    }
}
