/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.ModeloTabela;
import static gestor.Visao.TelaEventoDisciplinar.jIdFuncTestemunha;
import static gestor.Visao.TelaEventoDisciplinar.jNomeDepartamentoTestemunha;
import static gestor.Visao.TelaEventoDisciplinar.jFotoFuncTestemunha;
import static gestor.Visao.TelaEventoDisciplinar.jNomeFuncTestemunha;
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
public class TelaPesqInternosEventosFuncTestemunha extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    int flag;
    String statusFunc = "Ativo";
    String caminhoFotoVitima;

    /**
     * Creates new form TelaPesquisaCidade
     */
    public TelaPesqInternosEventosFuncTestemunha() {
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
        jPanel2 = new javax.swing.JPanel();
        jPesNomeColaborador = new javax.swing.JTextField();
        jBtNome = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaColabrador = new javax.swing.JTable();
        jBtEnviar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();

        setClosable(true);
        setTitle("...::: Pesquisar Colaborador :::...");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisar Colaborador", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 51, 255))); // NOI18N

        jPesNomeColaborador.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtNome.setToolTipText("Pesquisa por Nome");
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Nome:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPesNomeColaborador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(jBtNome)
                .addComponent(jPesNomeColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jCheckBox1)
                .addComponent(jLabel1))
        );

        jTabelaColabrador.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaColabrador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Código", "Nome do Colaborador", "Departamento", "Cargo"
            }
        ));
        jTabelaColabrador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaColabradorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaColabrador);
        if (jTabelaColabrador.getColumnModel().getColumnCount() > 0) {
            jTabelaColabrador.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaColabrador.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaColabrador.getColumnModel().getColumn(1).setMinWidth(240);
            jTabelaColabrador.getColumnModel().getColumn(1).setMaxWidth(240);
            jTabelaColabrador.getColumnModel().getColumn(2).setMinWidth(140);
            jTabelaColabrador.getColumnModel().getColumn(2).setMaxWidth(140);
            jTabelaColabrador.getColumnModel().getColumn(3).setMinWidth(220);
            jTabelaColabrador.getColumnModel().getColumn(3).setMaxWidth(220);
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBtEnviar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSair)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtEnviar)
                    .addComponent(jBtSair)))
        );

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBounds(300, 150, 497, 243);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNomeActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (jPesNomeColaborador.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe dados para pesquisa");
            jPesNomeColaborador.requestFocus();
        } else {
            preencherTabelaNome("SELECT * FROM COLABORADOR "
                    + "INNER JOIN DEPARTAMENTOS "
                    + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                    + "INNER JOIN CARGOS "
                    + "ON COLABORADOR.IdCargo=CARGOS.IdCargo "
                    + "WHERE NomeFunc LIKE'%" + jPesNomeColaborador.getText() + "%'AND StatusFunc='" + statusFunc + "'");
        }
    }//GEN-LAST:event_jBtNomeActionPerformed

    private void jTabelaColabradorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaColabradorMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String nomeColaborador = "" + jTabelaColabrador.getValueAt(jTabelaColabrador.getSelectedRow(), 1);
            jPesNomeColaborador.setText(nomeColaborador);
        }
    }//GEN-LAST:event_jTabelaColabradorMouseClicked

    private void jBtEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtEnviarActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (jPesNomeColaborador.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Selecione o nome da COLABORADOR e clique no botão ENVIAR");
        } else {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM COLABORADOR "
                        + "INNER JOIN DEPARTAMENTOS "
                        + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                        + "INNER JOIN CARGOS "
                        + "ON COLABORADOR.IdCargo=CARGOS.IdCargo "
                        + "WHERE NomeFunc='" + jPesNomeColaborador.getText() + "'");
                conecta.rs.first();
                jIdFuncTestemunha.setText(conecta.rs.getString("IdFunc"));
                jNomeFuncTestemunha.setText(conecta.rs.getString("NomeFunc"));
                // Capturando foto
                caminhoFotoVitima = conecta.rs.getString("ImagemFunc");
                javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminhoFotoVitima);
                jFotoFuncTestemunha.setIcon(i);
                jFotoFuncTestemunha.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoFuncTestemunha.getWidth(), jFotoFuncTestemunha.getHeight(), Image.SCALE_DEFAULT)));
                //                
                jNomeDepartamentoTestemunha.setText(conecta.rs.getString("NomeDepartamento"));
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

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherTabela("SELECT * FROM COLABORADOR "
                    + "INNER JOIN DEPARTAMENTOS "
                    + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                    + "INNER JOIN CARGOS "
                    + "ON COLABORADOR.IdCargo=CARGOS.IdCargo "
                    + "WHERE StatusFunc='" + statusFunc + "'");
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
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JTextField jPesNomeColaborador;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabelaColabrador;
    // End of variables declaration//GEN-END:variables

    public void preencherTabela(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome Colaborador", "Departamento", "Cargo "};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdFunc"), conecta.rs.getString("NomeFunc"), conecta.rs.getString("NomeDepartamento"), conecta.rs.getString("NomeCargo")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Dados não encontrado, use o botão TODOS \nPara pesquisar TODOS OS REGISTROS");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaColabrador.setModel(modelo);
        jTabelaColabrador.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaColabrador.getColumnModel().getColumn(0).setResizable(false);
        jTabelaColabrador.getColumnModel().getColumn(1).setPreferredWidth(240);
        jTabelaColabrador.getColumnModel().getColumn(1).setResizable(false);
        jTabelaColabrador.getColumnModel().getColumn(2).setPreferredWidth(140);
        jTabelaColabrador.getColumnModel().getColumn(2).setResizable(false);
        jTabelaColabrador.getColumnModel().getColumn(3).setPreferredWidth(220);
        jTabelaColabrador.getColumnModel().getColumn(3).setResizable(false);
        jTabelaColabrador.getTableHeader().setReorderingAllowed(false);
        jTabelaColabrador.setAutoResizeMode(jTabelaColabrador.AUTO_RESIZE_OFF);
        jTabelaColabrador.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabela();
        conecta.desconecta();
    }

    public void preencherTabelaNome(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome Colaborador", "Departamento", " Cargo "};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdFunc"), conecta.rs.getString("NomeFunc"), conecta.rs.getString("NomeDepartamento"), conecta.rs.getString("NomeCargo")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Dados não encontrado, use o botão TODOS \nPara pesquisar TODOS OS REGISTROS");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaColabrador.setModel(modelo);
        jTabelaColabrador.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaColabrador.getColumnModel().getColumn(0).setResizable(false);
        jTabelaColabrador.getColumnModel().getColumn(1).setPreferredWidth(240);
        jTabelaColabrador.getColumnModel().getColumn(1).setResizable(false);
        jTabelaColabrador.getColumnModel().getColumn(2).setPreferredWidth(140);
        jTabelaColabrador.getColumnModel().getColumn(2).setResizable(false);
        jTabelaColabrador.getColumnModel().getColumn(3).setPreferredWidth(220);
        jTabelaColabrador.getColumnModel().getColumn(3).setResizable(false);
        jTabelaColabrador.getTableHeader().setReorderingAllowed(false);
        jTabelaColabrador.setAutoResizeMode(jTabelaColabrador.AUTO_RESIZE_OFF);
        jTabelaColabrador.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabela();
        conecta.desconecta();
    }

    public void limparTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome Colaborador", "Departamento", " Cargo "};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaColabrador.setModel(modelo);
        jTabelaColabrador.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaColabrador.getColumnModel().getColumn(0).setResizable(false);
        jTabelaColabrador.getColumnModel().getColumn(1).setPreferredWidth(240);
        jTabelaColabrador.getColumnModel().getColumn(1).setResizable(false);
        jTabelaColabrador.getColumnModel().getColumn(2).setPreferredWidth(140);
        jTabelaColabrador.getColumnModel().getColumn(2).setResizable(false);
        jTabelaColabrador.getColumnModel().getColumn(3).setPreferredWidth(220);
        jTabelaColabrador.getColumnModel().getColumn(3).setResizable(false);
        jTabelaColabrador.getTableHeader().setReorderingAllowed(false);
        jTabelaColabrador.setAutoResizeMode(jTabelaColabrador.AUTO_RESIZE_OFF);
        jTabelaColabrador.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
        jTabelaColabrador.getColumnModel().getColumn(0).setCellRenderer(centralizado);
    }
}
