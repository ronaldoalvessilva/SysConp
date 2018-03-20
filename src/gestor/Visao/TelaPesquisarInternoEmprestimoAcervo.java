/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.ModeloTabela;
import static gestor.Visao.TelaEmprestimoAcervo.FotoInternoReserva;
import static gestor.Visao.TelaEmprestimoAcervo.jCela;
import static gestor.Visao.TelaEmprestimoAcervo.jIdInternoReserva;
import static gestor.Visao.TelaEmprestimoAcervo.jIdReserva;
import static gestor.Visao.TelaEmprestimoAcervo.jMatriculaPenal;
import static gestor.Visao.TelaEmprestimoAcervo.jNomeInternoReserva;
import static gestor.Visao.TelaEmprestimoAcervo.jPavilhao;
import java.awt.Image;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author ronaldo
 */
public class TelaPesquisarInternoEmprestimoAcervo extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();

    int flag;
    String nomeInterno;
    String statusLocal = "Ativo";
    String caminho;

    /**
     * Creates new form TelaPesquisarLocalPertence
     */
    public TelaPesquisarInternoEmprestimoAcervo() {
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
        jPesqNomeInternoReserva = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jBtPesqDescricao = new javax.swing.JButton();
        jCheckBoxTodos = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaLocalizacaoInterno = new javax.swing.JTable();
        jBtConfirmar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Pesquisar Internos :::...");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPesqNomeInternoReserva.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Nome:");

        jBtPesqDescricao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqDescricao.setContentAreaFilled(false);
        jBtPesqDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqDescricaoActionPerformed(evt);
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
                .addComponent(jPesqNomeInternoReserva)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtPesqDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxTodos)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPesqNomeInternoReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqDescricao)
                    .addComponent(jLabel1)
                    .addComponent(jCheckBoxTodos))
                .addContainerGap())
        );

        jTabelaLocalizacaoInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaLocalizacaoInterno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTabelaLocalizacaoInterno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaLocalizacaoInternoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaLocalizacaoInterno);

        jBtConfirmar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtConfirmar.setForeground(new java.awt.Color(0, 153, 0));
        jBtConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/accept.png"))); // NOI18N
        jBtConfirmar.setText("Confirmar");
        jBtConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtConfirmarActionPerformed(evt);
            }
        });

        jBtSair.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtSair.setForeground(new java.awt.Color(204, 0, 0));
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jBtConfirmar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jBtSair))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtConfirmar, jBtSair});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtConfirmar)
                    .addComponent(jBtSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtConfirmar, jBtSair});

        setBounds(300, 30, 405, 254);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtConfirmarActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            nomeInterno = "" + jTabelaLocalizacaoInterno.getValueAt(jTabelaLocalizacaoInterno.getSelectedRow(), 1);
            jPesqNomeInternoReserva.setText(nomeInterno);
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                        + "INNER JOIN LOCALINTERNOS "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=LOCALINTERNOS.IdInternoCrc "
                        + "INNER JOIN CELAS "
                        + "ON LOCALINTERNOS.IdCela=CELAS.IdCela "
                        + "INNER JOIN PAVILHAO "
                        + "ON CELAS.IdPav=PAVILHAO.IdPav "
                        + "WHERE NomeInternoCrc='" + jPesqNomeInternoReserva.getText() + "'");
                conecta.rs.first();
                jIdInternoReserva.setText(String.valueOf(conecta.rs.getInt("IdInternoCrc")));
                jNomeInternoReserva.setText(conecta.rs.getString("NomeInternoCrc"));
                // Capturando foto
                caminho = conecta.rs.getString("FotoInternoCrc");
                javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                FotoInternoReserva.setIcon(i);
                FotoInternoReserva.setIcon(new ImageIcon(i.getImage().getScaledInstance(FotoInternoReserva.getWidth(), FotoInternoReserva.getHeight(), Image.SCALE_DEFAULT)));
                jMatriculaPenal.setText(conecta.rs.getString("MatriculaCrc"));
                jCela.setText(conecta.rs.getString("EndCelaPav"));
                jPavilhao.setText(conecta.rs.getString("DescricaoPav"));
                conecta.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa..." + e);
            }
            // Limpar o campo da reserva caso o usuário opte por não buscar a reserva do acervo.
            jIdReserva.setText("");
            dispose();
        }
    }//GEN-LAST:event_jBtConfirmarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtPesqDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqDescricaoActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (jPesqNomeInternoReserva.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o nome do interno para pesquisar.");
        } else {
            jTabelaLocalizacaoInterno.setVisible(true);
            preencherTabelaInternos("SELECT * FROM PRONTUARIOSCRC "
                    + "INNER JOIN LOCALINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=LOCALINTERNOS.IdInternoCrc "
                    + "INNER JOIN CELAS "
                    + "ON LOCALINTERNOS.IdCela=CELAS.IdCela "
                    + "INNER JOIN PAVILHAO "
                    + "ON CELAS.IdPav=PAVILHAO.IdPav "
                    + "WHERE NomeInternoCrc LIKE'%" + jPesqNomeInternoReserva.getText() + "%'");
        }
    }//GEN-LAST:event_jBtPesqDescricaoActionPerformed

    private void jCheckBoxTodosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxTodosItemStateChanged
        // TODO add your handling code here:
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            jTabelaLocalizacaoInterno.setVisible(true);
            this.preencherTabelaInternos("SELECT * FROM PRONTUARIOSCRC "
                    + "INNER JOIN LOCALINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=LOCALINTERNOS.IdInternoCrc "
                    + "INNER JOIN CELAS "
                    + "ON LOCALINTERNOS.IdCela=CELAS.IdCela "
                    + "INNER JOIN PAVILHAO "
                    + "ON CELAS.IdPav=PAVILHAO.IdPav");
        } else {
            jTabelaLocalizacaoInterno.setVisible(!true);
        }
    }//GEN-LAST:event_jCheckBoxTodosItemStateChanged

    private void jTabelaLocalizacaoInternoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaLocalizacaoInternoMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            nomeInterno = "" + jTabelaLocalizacaoInterno.getValueAt(jTabelaLocalizacaoInterno.getSelectedRow(), 1);
            jPesqNomeInternoReserva.setText(nomeInterno);
        }
    }//GEN-LAST:event_jTabelaLocalizacaoInternoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtConfirmar;
    private javax.swing.JButton jBtPesqDescricao;
    private javax.swing.JButton jBtSair;
    private javax.swing.JCheckBox jCheckBoxTodos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jPesqNomeInternoReserva;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabelaLocalizacaoInterno;
    // End of variables declaration//GEN-END:variables

    public void preencherTabelaInternos(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "    Nome do Interno "};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdInternoCrc"), conecta.rs.getString("NomeInternoCrc")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaLocalizacaoInterno.setModel(modelo);
        jTabelaLocalizacaoInterno.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaLocalizacaoInterno.getColumnModel().getColumn(0).setResizable(false);
        jTabelaLocalizacaoInterno.getColumnModel().getColumn(1).setPreferredWidth(380);
        jTabelaLocalizacaoInterno.getColumnModel().getColumn(1).setResizable(false);
        jTabelaLocalizacaoInterno.getTableHeader().setReorderingAllowed(false);
        jTabelaLocalizacaoInterno.setAutoResizeMode(jTabelaLocalizacaoInterno.AUTO_RESIZE_OFF);
        jTabelaLocalizacaoInterno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conecta.desconecta();
    }
}
