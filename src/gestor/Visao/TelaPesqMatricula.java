/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.ModeloTabela;
import static gestor.Visao.TelaControleFrequencia.jDataMatricula;
import static gestor.Visao.TelaControleFrequencia.jDescricaoSala;
import static gestor.Visao.TelaControleFrequencia.jDescricaoTurno;
import static gestor.Visao.TelaControleFrequencia.jIdMatricula;
import static gestor.Visao.TelaControleFrequencia.jNomeInstituicao;
import static gestor.Visao.TelaControleFrequencia.jTempoFormativo;
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
public class TelaPesqMatricula extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();

    int flag;
    String codMatricula;

    /**
     * Creates new form TelaPesqMatricula
     */
    public TelaPesqMatricula() {
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
        jBtPesqMatricula = new javax.swing.JButton();
        jCheckBoxTodos = new javax.swing.JCheckBox();
        jPesqMatricula = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaMatricula = new javax.swing.JTable();
        jBtConfirmar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();

        setClosable(true);
        setTitle("...::: Pesquisa de Matricula Escolar :::...");

        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 255));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Código Matricula:");

        jBtPesqMatricula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqMatricula.setContentAreaFilled(false);
        jBtPesqMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqMatriculaActionPerformed(evt);
            }
        });

        jCheckBoxTodos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxTodos.setText("Todos");
        jCheckBoxTodos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxTodosItemStateChanged(evt);
            }
        });

        jPesqMatricula.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPesqMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtPesqMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                .addComponent(jCheckBoxTodos)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(jPesqMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqMatricula)
                    .addComponent(jCheckBoxTodos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaMatricula.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaMatricula.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Código", "Nome do Tempo Formativo", "Turnos de Aulas"
            }
        ));
        jTabelaMatricula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaMatriculaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaMatricula);
        if (jTabelaMatricula.getColumnModel().getColumnCount() > 0) {
            jTabelaMatricula.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaMatricula.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaMatricula.getColumnModel().getColumn(1).setMinWidth(300);
            jTabelaMatricula.getColumnModel().getColumn(1).setMaxWidth(300);
            jTabelaMatricula.getColumnModel().getColumn(2).setMinWidth(200);
            jTabelaMatricula.getColumnModel().getColumn(2).setMaxWidth(200);
        }

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jBtConfirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSair)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtConfirmar, jBtSair});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtConfirmar)
                    .addComponent(jBtSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtConfirmar, jBtSair});

        jTabbedPane1.addTab("Pesquisa", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(300, 30, 452, 266);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesqMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqMatriculaActionPerformed
        // TODO add your handling code here:
        if (jPesqMatricula.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um código para pesquisa.");
        } else {
            preencherTabelaMatricula("SELECT * FROM MATRICULAESCOLAR "
                    + "INNER JOIN INSTITUICAOESCOLAR "
                    + "ON MATRICULAESCOLAR.IdCod=INSTITUICAOESCOLAR.IdCod "
                    + "INNER JOIN TEMPOFORMATIVO ON "
                    + "MATRICULAESCOLAR.IdTempo=TEMPOFORMATIVO.IdTempo "
                    + "INNER JOIN SALAS ON MATRICULAESCOLAR.IdSala=SALAS.IdSala "
                    + "INNER JOIN TURNOSAULA ON "
                    + "TEMPOFORMATIVO.IdTurno=TURNOSAULA.IdTurno "
                    + "WHERE IdMat='" + jPesqMatricula.getText() + "'");
        }
    }//GEN-LAST:event_jBtPesqMatriculaActionPerformed

    private void jCheckBoxTodosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxTodosItemStateChanged
        // TODO add your handling code here:
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherTabelaMatricula("SELECT * FROM MATRICULAESCOLAR "
                    + "INNER JOIN INSTITUICAOESCOLAR "
                    + "ON MATRICULAESCOLAR.IdCod=INSTITUICAOESCOLAR.IdCod "
                    + "INNER JOIN TEMPOFORMATIVO ON "
                    + "MATRICULAESCOLAR.IdTempo=TEMPOFORMATIVO.IdTempo "
                    + "INNER JOIN SALAS ON MATRICULAESCOLAR.IdSala=SALAS.IdSala "
                    + "INNER JOIN TURNOSAULA "
                    + "ON TEMPOFORMATIVO.IdTurno=TURNOSAULA.IdTurno");
        } else {
            limparTabela();
        }
    }//GEN-LAST:event_jCheckBoxTodosItemStateChanged

    private void jBtConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtConfirmarActionPerformed
        // TODO add your handling code here:
        if (jPesqMatricula.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Selecione o código da matricula e clique no botão ENVIAR");
        } else {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM MATRICULAESCOLAR "
                        + "INNER JOIN INSTITUICAOESCOLAR "
                        + "ON MATRICULAESCOLAR.IdCod=INSTITUICAOESCOLAR.IdCod "
                        + "INNER JOIN TEMPOFORMATIVO "
                        + "ON MATRICULAESCOLAR.IdTempo=TEMPOFORMATIVO.IdTempo "
                        + "INNER JOIN SALAS ON MATRICULAESCOLAR.IdSala=SALAS.IdSala "
                        + "INNER JOIN TURNOSAULA "
                        + "ON TEMPOFORMATIVO.IdTurno=TURNOSAULA.IdTurno "
                        + "WHERE IdMat='" + codMatricula + "'");
                conecta.rs.first();
                jIdMatricula.setText(conecta.rs.getString("IdMat"));
                jDataMatricula.setDate(conecta.rs.getDate("DataMat"));
                jNomeInstituicao.setText(conecta.rs.getString("NomeInstituicao"));
                jTempoFormativo.setText(conecta.rs.getString("DescricaoTempo"));
                jDescricaoTurno.setText(conecta.rs.getString("DescricaoTurno"));
                jDescricaoSala.setText(conecta.rs.getString("Descricao"));
                conecta.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa MATRICULA ESCOLAR." + e);
            }
            dispose();
        }
    }//GEN-LAST:event_jBtConfirmarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jTabelaMatriculaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaMatriculaMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            codMatricula = "" + jTabelaMatricula.getValueAt(jTabelaMatricula.getSelectedRow(), 0);
            jPesqMatricula.setText(codMatricula);
            //   String idInst = "" + jTabelaMatricula.getValueAt(jTabelaMatricula.getSelectedRow(), 0);
        }
    }//GEN-LAST:event_jTabelaMatriculaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtConfirmar;
    private javax.swing.JButton jBtPesqMatricula;
    private javax.swing.JButton jBtSair;
    private javax.swing.JCheckBox jCheckBoxTodos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jPesqMatricula;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTabelaMatricula;
    // End of variables declaration//GEN-END:variables

    public void preencherTabelaMatricula(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome do Tempo Formativo", "Turnos de Aulas"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdMat"), conecta.rs.getString("DescricaoTempo"), conecta.rs.getString("DescricaoTurno")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaMatricula.setModel(modelo);
        jTabelaMatricula.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaMatricula.getColumnModel().getColumn(0).setResizable(false);
        jTabelaMatricula.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTabelaMatricula.getColumnModel().getColumn(1).setResizable(false);
        jTabelaMatricula.getColumnModel().getColumn(2).setPreferredWidth(200);
        jTabelaMatricula.getColumnModel().getColumn(2).setResizable(false);
        jTabelaMatricula.getTableHeader().setReorderingAllowed(false);
        jTabelaMatricula.setAutoResizeMode(jTabelaMatricula.AUTO_RESIZE_OFF);
        jTabelaMatricula.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaMatriculas();
        conecta.desconecta();
    }

    public void limparTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome do Tempo Formativo", "Turnos de Aulas"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaMatricula.setModel(modelo);
        jTabelaMatricula.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaMatricula.getColumnModel().getColumn(0).setResizable(false);
        jTabelaMatricula.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTabelaMatricula.getColumnModel().getColumn(1).setResizable(false);
        jTabelaMatricula.getColumnModel().getColumn(2).setPreferredWidth(200);
        jTabelaMatricula.getColumnModel().getColumn(2).setResizable(false);
        jTabelaMatricula.getTableHeader().setReorderingAllowed(false);
        jTabelaMatricula.setAutoResizeMode(jTabelaMatricula.AUTO_RESIZE_OFF);
        jTabelaMatricula.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabelaMatriculas() {
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaMatricula.getColumnModel().getColumn(0).setCellRenderer(centralizado);
    }
}
