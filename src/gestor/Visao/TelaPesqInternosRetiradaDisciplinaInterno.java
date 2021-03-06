/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import Utilitarios.ModeloTabela;
import gestor.Dao.*;
import static gestor.Visao.TelaRetirarPenalidadeInterno.FotoInternoRP;
import static gestor.Visao.TelaRetirarPenalidadeInterno.idCela;
import static gestor.Visao.TelaRetirarPenalidadeInterno.idPavilhao;
import static gestor.Visao.TelaRetirarPenalidadeInterno.jCelaOrigem;
import static gestor.Visao.TelaRetirarPenalidadeInterno.jIdInternoRP;
import static gestor.Visao.TelaRetirarPenalidadeInterno.jDocumentoOrigem;
import static gestor.Visao.TelaRetirarPenalidadeInterno.jMatriculaPenalRP;
import static gestor.Visao.TelaRetirarPenalidadeInterno.jNomeInternoRP;
import java.awt.Image;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import static gestor.Visao.TelaRetirarPenalidadeInterno.jPavilhaoOrigem;

/**
 *
 * @author user
 */
public class TelaPesqInternosRetiradaDisciplinaInterno extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    int flag;
    public static String idRol;
    String caminho;
    String utilizacao = "Não";

    /**
     * Creates new form TelaPesqColaborador
     */
    public TelaPesqInternosRetiradaDisciplinaInterno() {
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
        jPesqNomeInterno = new javax.swing.JTextField();
        jBtPesqNome = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaPesqInternosRol = new javax.swing.JTable();
        jBtEnviar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Pesquisa Internos Registro Disciplinar - {SE} :::...");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Listagem de Internos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jPesqNomeInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqNome.setToolTipText("Pesquisa por Nome");
        jBtPesqNome.setContentAreaFilled(false);
        jBtPesqNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqNomeActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Nome:");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPesqNomeInterno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtPesqNome, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(jPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqNome)
                    .addComponent(jCheckBox1))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jTabelaPesqInternosRol.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaPesqInternosRol.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome Completo do Interno", "Pavilhão", "Cela"
            }
        ));
        jTabelaPesqInternosRol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaPesqInternosRolMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaPesqInternosRol);
        if (jTabelaPesqInternosRol.getColumnModel().getColumnCount() > 0) {
            jTabelaPesqInternosRol.getColumnModel().getColumn(0).setMinWidth(60);
            jTabelaPesqInternosRol.getColumnModel().getColumn(0).setMaxWidth(60);
            jTabelaPesqInternosRol.getColumnModel().getColumn(1).setMinWidth(380);
            jTabelaPesqInternosRol.getColumnModel().getColumn(1).setMaxWidth(380);
            jTabelaPesqInternosRol.getColumnModel().getColumn(2).setMinWidth(100);
            jTabelaPesqInternosRol.getColumnModel().getColumn(2).setMaxWidth(100);
            jTabelaPesqInternosRol.getColumnModel().getColumn(3).setMinWidth(120);
            jTabelaPesqInternosRol.getColumnModel().getColumn(3).setMaxWidth(120);
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBtEnviar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSair)
                        .addGap(0, 492, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtEnviar)
                    .addComponent(jBtSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Pesquisas", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        setBounds(250, 20, 701, 301);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtEnviarActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String nomeInterno = "" + jTabelaPesqInternosRol.getValueAt(jTabelaPesqInternosRol.getSelectedRow(), 1);
            jPesqNomeInterno.setText(nomeInterno);
            String idFunc = "" + jTabelaPesqInternosRol.getValueAt(jTabelaPesqInternosRol.getSelectedRow(), 0);
            jIdInternoRP.setText(idFunc);//           
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                        + "INNER JOIN AUTORES_REGIMENTO_DISCIPLINAR "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=AUTORES_REGIMENTO_DISCIPLINAR.IdInternoCrc "
                        + "INNER JOIN PAVILHAO "
                        + "ON AUTORES_REGIMENTO_DISCIPLINAR.IdPav=PAVILHAO.IdPav "
                        + "INNER JOIN CELAS "
                        + "ON AUTORES_REGIMENTO_DISCIPLINAR.IdCela=CELAS.IdCela "
                        + "WHERE NomeInternoCrc='" + jPesqNomeInterno.getText() + "'");
                conecta.rs.first();
                jIdInternoRP.setText(String.valueOf(conecta.rs.getInt("IdInternoCrc")));
                jMatriculaPenalRP.setText(conecta.rs.getString("MatriculaCrc"));
                jNomeInternoRP.setText(conecta.rs.getString("NomeInternoCrc"));
                idPavilhao = conecta.rs.getInt("IdPav");
                jPavilhaoOrigem.setText(conecta.rs.getString("DescricaoPav"));
                idCela = conecta.rs.getInt("IdCela");
                jCelaOrigem.setText(conecta.rs.getString("EndCelaPav"));
                // Capturando foto
                caminho = conecta.rs.getString("FotoInternoCrc");
                javax.swing.ImageIcon v = new javax.swing.ImageIcon(caminho);
                FotoInternoRP.setIcon(v);
                FotoInternoRP.setIcon(new ImageIcon(v.getImage().getScaledInstance(FotoInternoRP.getWidth(), FotoInternoRP.getHeight(), Image.SCALE_DEFAULT)));
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

    private void jBtPesqNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNomeActionPerformed
        // TODO add your handling code here:      
        flag = 1;
        if (jPesqNomeInterno.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um nome ou parte do nome para pesquisar.");
            jPesqNomeInterno.requestFocus();
        } else {
            buscarInternoVisitas("SELECT * FROM PRONTUARIOSCRC "
                    + "INNER JOIN AUTORES_REGIMENTO_DISCIPLINAR "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=AUTORES_REGIMENTO_DISCIPLINAR.IdInternoCrc "
                    + "INNER JOIN PAVILHAO "
                    + "ON AUTORES_REGIMENTO_DISCIPLINAR.IdPav=PAVILHAO.IdPav "
                    + "INNER JOIN CELAS "
                    + "ON AUTORES_REGIMENTO_DISCIPLINAR.IdCela=CELAS.IdCela "
                    + "WHERE NomeInternoCrc LIKE'%" + jPesqNomeInterno.getText() + "%' "
                    + "AND IdReg='" + jDocumentoOrigem.getText() + "' "
                    + "AND UtilizaSaida='" + utilizacao + "'");
        }
    }//GEN-LAST:event_jBtPesqNomeActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.buscarInternoVisitas("SELECT * FROM PRONTUARIOSCRC "
                    + "INNER JOIN AUTORES_REGIMENTO_DISCIPLINAR "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=AUTORES_REGIMENTO_DISCIPLINAR.IdInternoCrc "
                    + "INNER JOIN PAVILHAO "
                    + "ON AUTORES_REGIMENTO_DISCIPLINAR.IdPav=PAVILHAO.IdPav "
                    + "INNER JOIN CELAS "
                    + "ON AUTORES_REGIMENTO_DISCIPLINAR.IdCela=CELAS.IdCela "
                    + "WHERE IdReg='" + jDocumentoOrigem.getText() + "' "
                    + "AND UtilizaSaida='" + utilizacao + "'");
        } else {
            limparTabela();
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jTabelaPesqInternosRolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaPesqInternosRolMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1 && evt.getClickCount() == 1) {
            String nomeInterno = "" + jTabelaPesqInternosRol.getValueAt(jTabelaPesqInternosRol.getSelectedRow(), 1);
            jPesqNomeInterno.setText(nomeInterno);
            String idFunc = "" + jTabelaPesqInternosRol.getValueAt(jTabelaPesqInternosRol.getSelectedRow(), 0);
            jIdInternoRP.setText(idFunc);//  
        }
    }//GEN-LAST:event_jTabelaPesqInternosRolMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtEnviar;
    private javax.swing.JButton jBtPesqNome;
    private javax.swing.JButton jBtSair;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jPesqNomeInterno;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTabelaPesqInternosRol;
    // End of variables declaration//GEN-END:variables

//Preencher tabela com todos os COLABORADORES
    public void buscarInternoVisitas(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome Completo do Interno", "Pavilhão", "Cela"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdInternoCrc"), conecta.rs.getString("NomeInternoCrc"), conecta.rs.getString("DescricaoPav"), conecta.rs.getString("EndCelaPav")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPesqInternosRol.setModel(modelo);
        jTabelaPesqInternosRol.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaPesqInternosRol.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPesqInternosRol.getColumnModel().getColumn(1).setPreferredWidth(380);
        jTabelaPesqInternosRol.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPesqInternosRol.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTabelaPesqInternosRol.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPesqInternosRol.getColumnModel().getColumn(3).setPreferredWidth(120);
        jTabelaPesqInternosRol.getColumnModel().getColumn(3).setResizable(false);
        jTabelaPesqInternosRol.getTableHeader().setReorderingAllowed(false);
        jTabelaPesqInternosRol.setAutoResizeMode(jTabelaPesqInternosRol.AUTO_RESIZE_OFF);
        jTabelaPesqInternosRol.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabela();
        conecta.desconecta();
    }

    public void limparTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome Completo do Interno", "Pavilhão", "Cela"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPesqInternosRol.setModel(modelo);
        jTabelaPesqInternosRol.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaPesqInternosRol.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPesqInternosRol.getColumnModel().getColumn(1).setPreferredWidth(380);
        jTabelaPesqInternosRol.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPesqInternosRol.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTabelaPesqInternosRol.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPesqInternosRol.getColumnModel().getColumn(3).setPreferredWidth(120);
        jTabelaPesqInternosRol.getColumnModel().getColumn(3).setResizable(false);
        jTabelaPesqInternosRol.getTableHeader().setReorderingAllowed(false);
        jTabelaPesqInternosRol.setAutoResizeMode(jTabelaPesqInternosRol.AUTO_RESIZE_OFF);
        jTabelaPesqInternosRol.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
        jTabelaPesqInternosRol.getColumnModel().getColumn(0).setCellRenderer(centralizado);
    }
}
