/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Dao.*;
import static gestor.Visao.TelaAtendimentoFamiliarJuridico.jIDInterno;
import static gestor.Visao.TelaAtendimentoFamiliarJuridico.FotoVisita;
import static gestor.Visao.TelaAtendimentoFamiliarJuridico.jDataCadastro;
import static gestor.Visao.TelaAtendimentoFamiliarJuridico.jDataValidadeAntec;
import static gestor.Visao.TelaAtendimentoFamiliarJuridico.jIDVisita;
import static gestor.Visao.TelaAtendimentoFamiliarJuridico.jNomeVisita;
import static gestor.Visao.TelaAtendimentoFamiliarJuridico.jParentesco;
import static gestor.Visao.TelaAtendimentoFamiliarJuridico.jRGVisita;
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
public class TelaPesqVisitaAtendFamiliarJuridico extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();

    int flag;
    String caminho;
    String nomeVisita;
    String dataCadastro;
    String dataEntrada;
    String statusVisita = "Ativo";

    /**
     * Creates new form TelaPesquisaEntradaInternos
     */
    public TelaPesqVisitaAtendFamiliarJuridico() {
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
        jTabelaVisitas = new javax.swing.JTable();
        jBtSair = new javax.swing.JButton();
        jBtEnviar = new javax.swing.JButton();

        setClosable(true);
        setTitle("...::: Pesquisa de Internos");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisar Visitas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jPesqNome.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Pesquisa Por Nome");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPesqNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPesqNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtNome)
                    .addComponent(jCheckBox1))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jTabelaVisitas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaVisitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Código", "Nome da Visita", "Parentesco", "Data Cadastro"
            }
        ));
        jTabelaVisitas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaVisitasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaVisitas);
        if (jTabelaVisitas.getColumnModel().getColumnCount() > 0) {
            jTabelaVisitas.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaVisitas.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaVisitas.getColumnModel().getColumn(1).setMinWidth(250);
            jTabelaVisitas.getColumnModel().getColumn(1).setMaxWidth(250);
            jTabelaVisitas.getColumnModel().getColumn(2).setMinWidth(100);
            jTabelaVisitas.getColumnModel().getColumn(2).setMaxWidth(100);
            jTabelaVisitas.getColumnModel().getColumn(3).setMinWidth(80);
            jTabelaVisitas.getColumnModel().getColumn(3).setMaxWidth(80);
        }

        jBtSair.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtSair.setForeground(new java.awt.Color(204, 0, 0));
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBtEnviar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSair))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtEnviar, jBtSair});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtSair)
                    .addComponent(jBtEnviar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtEnviar, jBtSair});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, Short.MAX_VALUE)
        );

        setBounds(200, 10, 517, 319);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNomeActionPerformed

        flag = 1;
        if (jPesqNome.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe NOME para pesquisa!!!");
            jPesqNome.requestFocus();
        } else {
            preencherTabelaNome("SELECT * FROM VISITASINTERNO "
                    + "INNER JOIN ITENSROL "
                    + "ON VISITASINTERNO.IdVisita=ITENSROL.IdVisita "
                    + "WHERE  VISITASINTERNO.NomeVisita LIKE'%" + jPesqNome.getText() + "%' "
                    + "AND  VISITASINTERNO.StatusVisita='" + statusVisita + "' "
                    + "AND IdInternoCRC='" + jIDInterno.getText() + "'");
        }
    }//GEN-LAST:event_jBtNomeActionPerformed

    private void jTabelaVisitasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaVisitasMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            nomeVisita = "" + jTabelaVisitas.getValueAt(jTabelaVisitas.getSelectedRow(), 1);
            jPesqNome.setText(nomeVisita);
            String idInt = "" + jTabelaVisitas.getValueAt(jTabelaVisitas.getSelectedRow(), 0);
        }
    }//GEN-LAST:event_jTabelaVisitasMouseClicked

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
                conecta.executaSQL("SELECT * FROM VISITASINTERNO WHERE NomeVisita LIKE'" + nomeVisita + "%'");
                conecta.rs.first();
                jIDVisita.setText(String.valueOf(conecta.rs.getInt("IdVisita")));
                jNomeVisita.setText(conecta.rs.getString("NomeVisita"));
                caminho = conecta.rs.getString("ImagemVisita");
                javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                FotoVisita.setIcon(i);
                FotoVisita.setIcon(new ImageIcon(i.getImage().getScaledInstance(FotoVisita.getWidth(), FotoVisita.getHeight(), Image.SCALE_DEFAULT)));
                jParentesco.setText(conecta.rs.getString("ParentescoVisita"));
                jRGVisita.setText(conecta.rs.getString("RgVisita"));
                jDataCadastro.setDate(conecta.rs.getDate("DataCadVisita"));
                jDataValidadeAntec.setDate(conecta.rs.getDate("DataValiAnte"));
                conecta.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa FAMILIAR" + e);
            }
            dispose();
        }
    }//GEN-LAST:event_jBtEnviarActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherTodosInternos("SELECT * FROM VISITASINTERNO "
                    + "INNER JOIN ITENSROL "
                    + "ON VISITASINTERNO.IdVisita=ITENSROL.IdVisita "
                    + "WHERE VISITASINTERNO.StatusVisita='" + statusVisita + "'AND IdInternoCRC='" + jIDInterno.getText() + "'");
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
    private javax.swing.JTable jTabelaVisitas;
    // End of variables declaration//GEN-END:variables
  // Método de pesquisa pela Descrição

    public void preencherTabelaNome(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome da Visita", "Parentesco", "Data Cadastro"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                // Formatar a data no formato Brasil
                dataCadastro = conecta.rs.getString("DataCadVisita");
                String diac = dataCadastro.substring(8, 10);
                String mesc = dataCadastro.substring(5, 7);
                String anoc = dataCadastro.substring(0, 4);
                dataCadastro = diac + "/" + mesc + "/" + anoc;
                dados.add(new Object[]{conecta.rs.getInt("IdVisita"), conecta.rs.getString("NomeVisita"), conecta.rs.getString("ParentescoVisita"), dataCadastro});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaVisitas.setModel(modelo);
        jTabelaVisitas.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaVisitas.getColumnModel().getColumn(0).setResizable(false);
        jTabelaVisitas.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTabelaVisitas.getColumnModel().getColumn(1).setResizable(false);
        jTabelaVisitas.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTabelaVisitas.getColumnModel().getColumn(2).setResizable(false);
        jTabelaVisitas.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaVisitas.getColumnModel().getColumn(3).setResizable(false);
        jTabelaVisitas.getTableHeader().setReorderingAllowed(false);
        jTabelaVisitas.setAutoResizeMode(jTabelaVisitas.AUTO_RESIZE_OFF);
        jTabelaVisitas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabela();
        conecta.desconecta();
    }

    //Preencher tabela com todos os INTERNOS
    public void preencherTodosInternos(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome da Visita", "Parentesco", "Data Cadastro"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                // Formatar a data no formato Brasil
                dataCadastro = conecta.rs.getString("DataCadVisita");
                String diac = dataCadastro.substring(8, 10);
                String mesc = dataCadastro.substring(5, 7);
                String anoc = dataCadastro.substring(0, 4);
                dataCadastro = diac + "/" + mesc + "/" + anoc;
                dados.add(new Object[]{conecta.rs.getInt("IdVisita"), conecta.rs.getString("NomeVisita"), conecta.rs.getString("ParentescoVisita"), dataCadastro});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaVisitas.setModel(modelo);
        jTabelaVisitas.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaVisitas.getColumnModel().getColumn(0).setResizable(false);
        jTabelaVisitas.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTabelaVisitas.getColumnModel().getColumn(1).setResizable(false);
        jTabelaVisitas.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTabelaVisitas.getColumnModel().getColumn(2).setResizable(false);
        jTabelaVisitas.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaVisitas.getColumnModel().getColumn(3).setResizable(false);
        jTabelaVisitas.getTableHeader().setReorderingAllowed(false);
        jTabelaVisitas.setAutoResizeMode(jTabelaVisitas.AUTO_RESIZE_OFF);
        jTabelaVisitas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
        jTabelaVisitas.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaVisitas.getColumnModel().getColumn(3).setCellRenderer(centralizado);
    }

    public void limparTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome da Visita", "Parentesco", "Data Cadastro"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaVisitas.setModel(modelo);
        jTabelaVisitas.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaVisitas.getColumnModel().getColumn(0).setResizable(false);
        jTabelaVisitas.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTabelaVisitas.getColumnModel().getColumn(1).setResizable(false);
        jTabelaVisitas.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTabelaVisitas.getColumnModel().getColumn(2).setResizable(false);
        jTabelaVisitas.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaVisitas.getColumnModel().getColumn(3).setResizable(false);
        jTabelaVisitas.getTableHeader().setReorderingAllowed(false);
        jTabelaVisitas.setAutoResizeMode(jTabelaVisitas.AUTO_RESIZE_OFF);
        jTabelaVisitas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
}
